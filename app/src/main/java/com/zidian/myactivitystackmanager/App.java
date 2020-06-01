package com.zidian.myactivitystackmanager;

import android.app.Application;
import android.content.Context;

import timber.log.Timber;

/**
 * @Author: UncleQing
 * @CreateDate: 2020/6/1
 * @Description: This is App
 */
public class App extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        Timber.plant(new Timber.DebugTree());
    }

}
