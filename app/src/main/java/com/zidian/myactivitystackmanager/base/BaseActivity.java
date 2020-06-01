package com.zidian.myactivitystackmanager.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.zidian.myactivitystackmanager.ActivityStackManager;


public abstract class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        afterOnCreate();
        ActivityStackManager.getInstance().addActivity(this);
    }

    protected abstract int getLayoutId();

    protected abstract void afterOnCreate();

    @Override
    protected void onResume() {
        super.onResume();
        ActivityStackManager.getInstance().setCurrentActivity(this);
    }

    @Override
    protected void onDestroy() {
        ActivityStackManager.getInstance().removeActivity(this);
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        ActivityStackManager.getInstance().finshActivity(this);
    }
}
