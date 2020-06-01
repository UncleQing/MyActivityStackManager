package com.zidian.myactivitystackmanager.appB;

import android.view.View;

import com.zidian.myactivitystackmanager.ActivityStackManager;
import com.zidian.myactivitystackmanager.R;
import com.zidian.myactivitystackmanager.appA.A2Activity;
import com.zidian.myactivitystackmanager.base.BaseActivity;

public class B1Activity extends BaseActivity {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_b1;
    }

    @Override
    protected void afterOnCreate() {

    }

    public void onClick(View v){
        ActivityStackManager.getInstance().startActivity(this, B2Activity.class);
    }
}
