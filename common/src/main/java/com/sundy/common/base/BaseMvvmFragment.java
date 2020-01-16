package com.sundy.common.base;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProvider;

import com.sundy.common.mvvm.viewmodel.BaseViewModel;

/**
 * 项目名称：Himalaya
 *
 * @Author bamboolife
 * 邮箱：core_it@163.com
 * 创建时间：2020-01-15 16:09
 * 描述：
 */
public abstract class BaseMvvmFragment<DB extends ViewDataBinding,VM extends BaseViewModel > extends BaseFragment<DB> {
    protected VM mViewModel;

    @Override
    protected void initModel() {
        initViewModel();
        initBaseViewObservable();
        initViewObservable();
    }


    protected void initViewModel() {
        mViewModel = createViewModel();
        getLifecycle().addObserver(mViewModel);
    }

    protected VM createViewModel() {
        return new ViewModelProvider(this,onBindViewModelFactory()).get(onBindViewModel());
    }

    protected abstract ViewModelProvider.Factory onBindViewModelFactory();
    protected abstract Class<VM> onBindViewModel();
    protected abstract void initViewObservable();
    protected  void initBaseViewObservable(){

    }
}
