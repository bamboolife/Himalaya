package com.sundy.main.test;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * 项目名称：Himalaya
 *
 * @Author bamboolife
 * 邮箱：core_it@163.com
 * 创建时间：2020-01-15 10:25
 * 描述：
 */
public class MainPresenter implements IPresenter , LifecycleObserver {

    private static final String TAG = "log_event";
    public MainPresenter(Context context) {
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    @Override
    public void onCreate() {
        Log.i("log_event", "onCreate: ");
    }
     @OnLifecycleEvent(Lifecycle.Event.ON_START)
    @Override
    public void onStart() {
         Log.i("log_event", "onStart: ");
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    @Override
    public void onResume() {
        Log.i(TAG, "onResume: ");
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    @Override
    public void onPause() {
        Log.i(TAG, "onPause: ");
    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }
}
