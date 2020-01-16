package com.sundy.common.base;

import androidx.lifecycle.ViewModelProvider;

import com.sundy.common.mvvm.viewmodel.BaseViewModel;

/**
 * 项目名称：Himalaya
 *
 * @Author bamboolife
 * 邮箱：core_it@163.com
 * 创建时间：2020-01-15 16:08
 * 描述：
 */
public abstract class BaseMvvmActivity<VM extends BaseViewModel> extends BaseActivity {
    protected VM mViewModel;
    @Override
    protected void initModel() {
        super.initModel();
        initViewModel();
        initBaseViewObservable();
        initViewObservable();
    }
    private void initViewModel() {
        mViewModel = createViewModel();
        getLifecycle().addObserver(mViewModel);
    }

    public VM createViewModel() {
        return new ViewModelProvider(this,onBindViewModelFactory()).get(onBindViewModel());
    }

    public abstract Class<VM> onBindViewModel();

    public abstract ViewModelProvider.Factory onBindViewModelFactory();

    public abstract void initViewObservable();

    protected void initBaseViewObservable() {

    }
}
