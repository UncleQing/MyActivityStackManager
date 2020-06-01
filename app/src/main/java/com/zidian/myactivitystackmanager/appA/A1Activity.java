package com.zidian.myactivitystackmanager.appA;

import android.view.View;

import com.zidian.myactivitystackmanager.ActivityStackManager;
import com.zidian.myactivitystackmanager.R;
import com.zidian.myactivitystackmanager.base.BaseActivity;

public class A1Activity extends BaseActivity {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_a1;
    }

    @Override
    protected void afterOnCreate() {

    }

    public void onClick(View v){
        ActivityStackManager.getInstance().startActivity(this, A2Activity.class);
    }
}
