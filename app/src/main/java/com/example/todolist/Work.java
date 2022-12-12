package com.example.todolist;

import android.graphics.Bitmap;

public class Work {
    private int id;
    private long createdDateMilliSeconds;
    private String title;
    private String description;
    private Bitmap imgWork;

    public Work(Bitmap imgWork, long createdDateMilliSeconds, String title, String description) {
        this.createdDateMilliSeconds = createdDateMilliSeconds;
        this.title = title;
        this.description = description;
        this.imgWork=imgWork;
    }

    public Bitmap getImgWork() {
        return imgWork;
    }

    public void setImgWork(Bitmap imgWork) {
        this.imgWork = imgWork;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getCreatedDateMilliSeconds() {
        return createdDateMilliSeconds;
    }

    public void setCreatedDateMilliSeconds(long createdDateMilliSeconds) {
        this.createdDateMilliSeconds = createdDateMilliSeconds;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
