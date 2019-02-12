package com.example.fr33d00m.notification_app_hw_guzman_fribel;

class Notification {
    private int funnyPic;
    private String message;

    Notification(int funnyPic, String message) {
        this.funnyPic = funnyPic;
        this.message = message;
}

    int getFunnyPic() {
        return funnyPic;
    }

    String getMessage() {
        return message;
    }
}
