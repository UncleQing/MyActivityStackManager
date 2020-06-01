package com.zidian.myactivitystackmanager;

import android.content.Intent;
import android.util.SparseArray;

import com.zidian.myactivitystackmanager.base.BaseActivity;

import java.util.Stack;

import timber.log.Timber;

/**
 * @Author: UncleQing
 * @CreateDate: 2020/6/1
 * @Description: This is ActivityStackManager
 */
public class ActivityStackManager {
    private static final ActivityStackManager IN = new ActivityStackManager();

    private SparseArray<Stack<BaseActivity>> stackSparseArray;
    private BaseActivity currentActivity;

    private ActivityStackManager() {
        stackSparseArray = new SparseArray<>();
    }

    public static ActivityStackManager getInstance() {
        return IN;
    }

    /**
     * BaseActivity onCreate
     * @param activity
     */
    public void addActivity(BaseActivity activity){
        getStack(activity).push(activity);
    }

    /**
     * BaseActivity onDestroy
     * @param activity
     */
    public void removeActivity(BaseActivity activity){
        getStack(activity).remove(activity);
    }

    /**
     * BaseActivity onResume
     * @param currentActivity
     */
    public void setCurrentActivity(BaseActivity currentActivity) {
        this.currentActivity = currentActivity;
    }

    /**
     * 可以代替activity.startActivity
     * @param activity
     * @param targetClass
     */
    public void startActivity(BaseActivity activity, Class<?> targetClass){
        Intent intent = new Intent(activity, targetClass);
        activity.startActivity(intent);
    }

    /**
     * 可以代替activity.finish
     */
    public void finshActivity(){
        if (currentActivity != null) {
            finshActivity(currentActivity);
        }
    }

    public void finshActivity(BaseActivity activity){
        if (getStack(activity).size() > 1){
            activity.finish();
        }else {
            Timber.e("current activity is last in stack");
        }
    }

    /**
     * 返回当前activity的栈
     * @param activity ? extends BaseActivity
     * @return Stack
     */
    private Stack<BaseActivity> getStack(BaseActivity activity){
        Stack<BaseActivity> stack = stackSparseArray.get(activity.getTaskId());
        if (stack == null) {
            stack = new Stack<>();
            stackSparseArray.put(activity.getTaskId(), stack);
        }
        return stack;
    }

}
