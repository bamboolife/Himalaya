package com.sundy.home.fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sundy.common.base.BaseRefreshMvvmFragment;
import com.sundy.common.mvvm.viewmodel.BaseRefreshViewModel;
import com.sundy.home.R;
import com.sundy.home.databinding.BblFgtCategoryLayoutBinding;
import com.sundy.home.mvvm.ViewModelFactory;
import com.sundy.home.mvvm.model.CategoryBean;
import com.sundy.home.mvvm.viewmodel.CategoryViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends BaseRefreshMvvmFragment<BblFgtCategoryLayoutBinding,CategoryViewModel,CategoryBean > {


    @Override
    protected int onBindLayout() {
        return R.layout.bbl_fgt_category_layout;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {

    }

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
        return CategoryViewModel.class;
    }

    @Override
    protected void initViewObservable() {

    }
}
