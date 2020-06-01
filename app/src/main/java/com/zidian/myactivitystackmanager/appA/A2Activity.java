package com.zidian.myactivitystackmanager.appA;

import android.view.View;

import com.zidian.myactivitystackmanager.ActivityStackManager;
import com.zidian.myactivitystackmanager.R;
import com.zidian.myactivitystackmanager.base.BaseActivity;

public class A2Activity extends BaseActivity {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_a2;
    }

    @Override
    protected void afterOnCreate() {

    }

    public void onClick(View v){
        ActivityStackManager.getInstance().startActivity(this, A3Activity.class);
    }
}
