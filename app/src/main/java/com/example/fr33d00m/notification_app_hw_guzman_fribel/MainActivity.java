package com.example.fr33d00m.notification_app_hw_guzman_fribel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Notification> notifications = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.model_recycler);

        addNotificationsToList();

        Adapter adapter= new Adapter(notifications);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    public void addNotificationsToList(){
        //use a consistent naming convention for all your resources. This will keep all related resources together and organized alphabetically
        notifications.add(new Notification(R.drawable.emoji_shocked, "'shocked'"));
        notifications.add(new Notification(R.drawable.emoji_rofl, "'rofl'"));
        notifications.add(new Notification(R.drawable.emoji_fu, "'F@#$%*'"));
        notifications.add(new Notification(R.drawable.emoji_mindblown, "'mindblown'"));
        notifications.add(new Notification(R.drawable.emoji_waaa, "'waaaaa'"));
        notifications.add(new Notification(R.drawable.emoji_seriously, "'seriously'"));
        notifications.add(new Notification(R.drawable.emoji_whatever, "'whatever'"));
        notifications.add(new Notification(R.drawable.emoji_ahhh, "'ahhhhhh'"));
        notifications.add(new Notification(R.drawable.emoji_gross, "'gross'"));
        notifications.add(new Notification(R.drawable.emoji_grrr, "'grrrrrr'"));
        notifications.add(new Notification(R.drawable.emoji_shhh, "'shhhhh'"));
        notifications.add(new Notification(R.drawable.emoji_guilty, "'guilty'"));
        notifications.add(new Notification(R.drawable.emoji_innocent, "'innocent'"));
        notifications.add(new Notification(R.drawable.emoji_kisses, "'kisses'"));
        notifications.add(new Notification(R.drawable.emoji_eye_candy, "'eye candy'"));
        notifications.add(new Notification(R.drawable.emoji_really, "'really?'"));
        notifications.add(new Notification(R.drawable.emoji_alien, "'alien'"));
        notifications.add(new Notification(R.drawable.emoji_cheese, "'cheese'"));
        notifications.add(new Notification(R.drawable.emoji_special, "'special'"));
        notifications.add(new Notification(R.drawable.emoji_peace, "'peace out'"));
    }
}
