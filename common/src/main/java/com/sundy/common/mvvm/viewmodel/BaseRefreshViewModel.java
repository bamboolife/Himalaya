package com.sundy.common.mvvm.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;

import com.sundy.common.mvvm.model.BaseModel;

/**
 * 项目名称：Himalaya
 *
 * @Author bamboolife
 * 邮箱：core_it@163.com
 * 创建时间：2020-01-15 14:17
 * 描述：
 */
public class BaseRefreshViewModel<M extends BaseModel, T>extends BaseViewModel<M> {

    public BaseRefreshViewModel(@NonNull Application application, M model) {
        super(application, model);
    }
}
