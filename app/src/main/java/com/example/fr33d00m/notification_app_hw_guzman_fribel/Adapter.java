package com.example.fr33d00m.notification_app_hw_guzman_fribel;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class Adapter  extends RecyclerView.Adapter<Holder> {

    private List<Notification> notificationList;

    Adapter(List<Notification> modelList) {
        this.notificationList = modelList;
    }
    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //every new variable you create is memory used, only use em if you need em
        return new Holder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.onBind(notificationList.get(position));
    }

    @Override
    public int getItemCount() {
        return notificationList.size();
    }
}
