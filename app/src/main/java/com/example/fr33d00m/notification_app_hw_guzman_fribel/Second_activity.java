package com.example.fr33d00m.notification_app_hw_guzman_fribel;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Second_activity extends AppCompatActivity {
    private ImageView funnyPic3;
    private TextView message3;
    private Button button;
    private static final String PRIMARY_CHANNEL_ID = "primary_notification_channel";
    private static final int NOTIFICATION_ID = 0;
    private NotificationManager mNotifyManager;
    String message;
    private SharedPreferences sharedPrefs;


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
        int img = (int) getIntent().getExtras().get("img");
        funnyPic3.setImageResource(img);
        message = (String) getIntent().getExtras().get("message");
        message3.setText(message);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sharedPrefs.contains(message)) {
                    showToast();
                } else {
                    mNotifyManager.notify(NOTIFICATION_ID, getNotificationBuilder(getNotificationIntent()));
                    sharedPrefs.edit().putBoolean(message, true).commit();
                }
            }
        });
    }

    public void createNotificationChannel() {
        mNotifyManager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >=
                android.os.Build.VERSION_CODES.O) {

            NotificationChannel notificationChannel = new NotificationChannel(PRIMARY_CHANNEL_ID,
                    "Emoji Notification", NotificationManager
                    .IMPORTANCE_HIGH);
            notificationChannel.setDescription("Notification");
            mNotifyManager.createNotificationChannel(notificationChannel);
        }
    }

    private Notification getNotificationBuilder(PendingIntent intent) {
        NotificationCompat.Builder notifyBuilder = new NotificationCompat.Builder(getApplicationContext(), PRIMARY_CHANNEL_ID)
                .setContentTitle("Added to Faves")
                .setContentText("Go Back to Home")
                .setSmallIcon(R.drawable.face1)
                .setContentIntent(intent);
        return notifyBuilder.build();
    }

    public void showToast() {
        Toast.makeText(this, "Emoji already added to Faves", Toast.LENGTH_SHORT).show();
    }
}