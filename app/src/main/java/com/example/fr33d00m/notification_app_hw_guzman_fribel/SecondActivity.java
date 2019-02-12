package com.example.fr33d00m.notification_app_hw_guzman_fribel;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    //field order should be static final fields, static fields, objects, Strings, primitives
    private static final String PRIMARY_CHANNEL_ID = "primary_notification_channel";
    private static final int NOTIFICATION_ID = 0;
    private final String NOTIFICATION_CHANNEL_NAME = "Emoji Notification";
    private final String NOTIFICATION_CHANNEL_DESCRIPTION = "Notification";
    private NotificationManager mNotifyManager;
    private SharedPreferences sharedPrefs;
    private ImageView funnyPic3;
    private TextView message3;
    private Button button;
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activity);

        sharedPrefs = getApplicationContext().getSharedPreferences("mySharedPrefs", MODE_PRIVATE);

        createNotificationChannel();
        setUpViewReferences();
        setUpView();
    }

    public PendingIntent getNotificationIntent() {
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent intent = PendingIntent.getActivity(this, NOTIFICATION_ID, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        return intent;
    }

    public void setUpViewReferences() {
        funnyPic3 = findViewById(R.id.funnypic3);
        message3 = findViewById(R.id.message3);
        button = findViewById(R.id.notify);
    }

    public void setUpView() {
        //provide a default value, and we know it's gonna be an int so use getInt/getString rather than get, avoid the extra overhead from the casting operation
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            funnyPic3.setImageResource(extras.getInt("img", R.drawable.emoji_whatever));
            message3.setText(message);
            message = extras.getString("message", "Error");

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (sharedPrefs.contains(message)) {
                        showToast();
                    } else {
                        mNotifyManager.notify(NOTIFICATION_ID, getNotificationBuilder(getNotificationIntent()));
                        //use apply for asynchronous handling
                        sharedPrefs.edit().putBoolean(message, true).apply();
                    }
                }
            });
        }
    }

    public void createNotificationChannel() {
        mNotifyManager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >=
                android.os.Build.VERSION_CODES.O) {

            NotificationChannel notificationChannel = new NotificationChannel(PRIMARY_CHANNEL_ID,
                    NOTIFICATION_CHANNEL_NAME, NotificationManager
                    .IMPORTANCE_HIGH);
            notificationChannel.setDescription(NOTIFICATION_CHANNEL_DESCRIPTION);
            mNotifyManager.createNotificationChannel(notificationChannel);
        }
    }

    private Notification getNotificationBuilder(PendingIntent intent) {
        NotificationCompat.Builder notifyBuilder = new NotificationCompat.Builder(getApplicationContext(), PRIMARY_CHANNEL_ID)
                .setContentTitle(getString(R.string.notification_added_faves))
                .setContentText(getString(R.string.notification_faves_content_text))
                .setSmallIcon(R.drawable.emoji_shocked)
                .setContentIntent(intent);
        return notifyBuilder.build();
    }

    public void showToast() {
        Toast.makeText(this, R.string.error_already_added_faves, Toast.LENGTH_SHORT).show();
    }
}