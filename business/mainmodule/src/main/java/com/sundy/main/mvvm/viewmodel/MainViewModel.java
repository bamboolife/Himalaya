package com.sundy.main.mvvm.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.sundy.common.mvvm.viewmodel.BaseViewModel;
import com.sundy.main.mvvm.model.MainModel;

/**
 * 项目名称：Himalaya
 *
 * @Author bamboolife
 * 邮箱：core_it@163.com
 * 创建时间：2020-01-15 16:32
 * 描述：
 */
public class MainViewModel extends BaseViewModel<MainModel> {
    MutableLiveData<String> mCoverEvent;

    public MutableLiveData<String> getCoverEvent() {
        if (mCoverEvent==null){
            mCoverEvent=new MutableLiveData<>();
        }
        return mCoverEvent;
    }

    public MainViewModel(@NonNull Application application, MainModel model) {
        super(application, model);
    }
}
