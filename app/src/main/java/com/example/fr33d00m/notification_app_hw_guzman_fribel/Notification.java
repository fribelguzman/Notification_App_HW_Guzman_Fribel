package com.example.fr33d00m.notification_app_hw_guzman_fribel;

import android.widget.ImageView;

public class Notification {

    private int funnyPic;

    private String message;


    public Notification(int funnyPic , String message){
        this.funnyPic = funnyPic;
        this.message = message;
}
    public int getFunnyPic() {
        return funnyPic;
    }

    public String getMessage() {
        return message;
    }
}
