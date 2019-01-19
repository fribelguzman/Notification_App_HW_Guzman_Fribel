package com.example.fr33d00m.notification_app_hw_guzman_fribel;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Holder extends RecyclerView.ViewHolder {

    private ImageView funnyPic;
    private TextView message;


    public Holder(@NonNull View itemView) {
        super(itemView);

        funnyPic = itemView.findViewById(R.id.funnypic1);
        message = itemView.findViewById(R.id.message1);

    }


    public void onBind(final Notification notification) {
        Picasso.get().load(notification.getFunnyPic()).fit().into(funnyPic);
        message.setText(notification.getMessage());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(itemView.getContext(), Second_activity.class);
                intent.putExtra("img", notification.getFunnyPic());
                intent.putExtra("message", notification.getMessage());
                itemView.getContext().startActivity(intent);
            }
        });
    }
}
