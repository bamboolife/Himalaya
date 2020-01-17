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
import com.sundy.listen.mvvm.viewmodel.SubscribeViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class SubscribeFragment extends BaseRefreshMvvmFragment<CommonLayoutListBinding, SubscribeViewModel, SubscribeBean> {


    @NonNull
    @Override
    protected WrapRefresh onBindWrapRefresh() {
        return null;
    }

    @Override
    protected ViewModelProvider.Factory onBindViewModelFactory() {
        return null;
    }

    @Override
    protected Class onBindViewModel() {
        return null;
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

    }
}
