package com.example.fr33d00m.notification_app_hw_guzman_fribel;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class Adapter  extends RecyclerView.Adapter<Holder> {

    List<Notification> notificationList;

    public Adapter(List<Notification> modelList) {
        this.notificationList = modelList;
    }
    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view,viewGroup,false);
        return new Holder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Notification notification = notificationList.get(position);
        holder.onBind(notification);

    }

    @Override
    public int getItemCount() {
        return notificationList.size();
    }
}
