package com.example.asekeyang.app;

import android.app.Application;

/**
 * Created by 华为 on 2019/6/13.
 */

public class MyApplication extends Application {

    private static MyApplication application;

    @Override
    public void onCreate() {
        super.onCreate();

        application =this;
    }
    public static MyApplication getApplication() {
        return application;
    }
}
