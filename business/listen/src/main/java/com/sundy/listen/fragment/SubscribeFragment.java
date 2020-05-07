package com.sundy.listen.fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sundy.common.base.BaseRefreshMvvmFragment;
import com.sundy.common.bean.SubscribeBean;
import com.sundy.common.databinding.CommonLayoutListBinding;
import com.sundy.listen.R;
import com.sundy.listen.adapter.SubscribeAdapter;
import com.sundy.listen.mvvm.ViewModelFactory;
import com.sundy.listen.mvvm.viewmodel.SubscribeViewModel;


/**
 * 项目名称：Himalaya
 *
 * @Author bamboolife
 * 邮箱：core_it@163.com
 * 创建时间：2020-01-16 10:18
 * 描述：我的订阅
 */
public class SubscribeFragment extends BaseRefreshMvvmFragment<CommonLayoutListBinding, SubscribeViewModel, SubscribeBean> {
    SubscribeAdapter mAdapter;
    private View vFooter;
    @NonNull
    @Override
    protected WrapRefresh onBindWrapRefresh() {
        return new WrapRefresh(mBinding.refreshLayout,null);
    }

    @Override
    protected ViewModelProvider.Factory onBindViewModelFactory() {
        return ViewModelFactory.getInstance(mApplication);
    }

    @Override
    protected Class onBindViewModel() {
        return SubscribeViewModel.class;
    }

    @Override
    protected void initViewObservable() {

    }

    @Override
    protected int onBindLayout() {
        return R.layout.common_layout_list;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        mAdapter=new SubscribeAdapter();
    }
}
