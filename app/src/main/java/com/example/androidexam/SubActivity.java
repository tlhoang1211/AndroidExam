package com.example.androidexam;

import android.app.Application;

import com.example.androidexam.model.Database;

public class SubActivity extends Application {
    private static SubActivity instance;
    private Database database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = new Database(this, "Exam.sqlite", null, 1);
    }

    public static SubActivity getInstance() {
        return instance;
    }

    public Database getDatabase() {
        return database;
    }
}
