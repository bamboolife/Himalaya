package com.sundy.home.mvvm.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;

import com.sundy.common.mvvm.model.QomolangmaModel;
import com.sundy.common.mvvm.viewmodel.BaseRefreshViewModel;
import com.sundy.common.mvvm.viewmodel.BaseViewModel;
import com.sundy.home.mvvm.model.CategoryBean;

/**
 * 项目名称：Himalaya
 *
 * @Author bamboolife
 * 邮箱：core_it@163.com
 * 创建时间：2020-01-18 16:48
 * 描述：
 */
public class CategoryViewModel extends BaseRefreshViewModel<QomolangmaModel, CategoryBean>{

    public CategoryViewModel(@NonNull Application application, QomolangmaModel model) {
        super(application, model);
    }
}