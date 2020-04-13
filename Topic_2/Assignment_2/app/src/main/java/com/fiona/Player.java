package com.fiona;

import android.media.Image;
import android.support.v4.app.INotificationSideChannel;

public class Player {
    private String name;
    private Integer image;
    public Player(String name, Integer image) {
        this.name=name;
        this.image=image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }
}
