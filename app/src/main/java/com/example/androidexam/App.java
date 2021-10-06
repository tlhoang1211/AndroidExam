package com.example.androidexam;

import android.app.Application;

import com.example.androidexam.model.Database;

public class App extends Application {
    private static App instance;
    private Database database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = new Database(this, "Exam.sqlite", null, 1);
    }

    public static App getInstance() {
        return instance;
    }

    public Database getDatabase() {
        return database;
    }
}
