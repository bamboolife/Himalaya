package com.sundy.common.mvvm.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleObserver;

import com.sundy.common.event.SingleLiveEvent;
import com.sundy.common.mvvm.model.BaseModel;

/**
 * 项目名称：Himalaya
 *
 * @Author bamboolife
 * 邮箱：core_it@163.com
 * 创建时间：2020-01-14 17:35
 * 描述：
 */
public class BaseViewModel<M extends BaseModel> extends AndroidViewModel implements LifecycleObserver {
     protected M mModel;
    public BaseViewModel(@NonNull Application application,M model) {
        super(application);
        this.mModel=model;
    }


    protected <T> SingleLiveEvent<T> createLiveData(SingleLiveEvent<T> liveData) {
        if (liveData == null) {
            liveData = new SingleLiveEvent<>();
        }
        return liveData;
    }
}
