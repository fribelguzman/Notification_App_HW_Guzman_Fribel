package com.example.fr33d00m.notification_app_hw_guzman_fribel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Notification> notifications = new ArrayList<>();

    RecyclerView recyclerView;

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
//        notifications.add(new Notification(R.drawable.face1,"Shook"));
        notifications.add(new Notification(R.drawable.face1,"'shocked'"));
        notifications.add(new Notification(R.drawable.face2,"'rofl'"));
        notifications.add(new Notification(R.drawable.face3,"'F@#$%*'"));
        notifications.add(new Notification(R.drawable.face4,"'mindblown'"));
        notifications.add(new Notification(R.drawable.face5,"'waaaaa'"));
        notifications.add(new Notification(R.drawable.face6,"'seriously'"));
        notifications.add(new Notification(R.drawable.face7,"'whatever'"));
        notifications.add(new Notification(R.drawable.face8,"'ahhhhhh'"));
        notifications.add(new Notification(R.drawable.face9,"'gross'"));
        notifications.add(new Notification(R.drawable.face10,"'grrrrrr'"));

        notifications.add(new Notification(R.drawable.face11,"'shhhhh'"));
        notifications.add(new Notification(R.drawable.face12,"'guilty'"));
        notifications.add(new Notification(R.drawable.face13,"'innocent'"));
        notifications.add(new Notification(R.drawable.face14,"'kisses'"));
        notifications.add(new Notification(R.drawable.face15,"'eye candy'"));
        notifications.add(new Notification(R.drawable.face16,"'really?'"));
        notifications.add(new Notification(R.drawable.face17,"'alien'"));
        notifications.add(new Notification(R.drawable.face18,"'cheese'"));
        notifications.add(new Notification(R.drawable.face19,"'special'"));
        notifications.add(new Notification(R.drawable.peace,"'peace out'"));
    }
}
