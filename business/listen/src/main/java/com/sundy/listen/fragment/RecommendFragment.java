package com.sundy.listen.fragment;

import android.os.Bundle;

import androidx.lifecycle.ViewModelProvider;

import com.sundy.common.base.BaseMvvmFragment;
import com.sundy.common.databinding.CommonLayoutListBinding;
import com.sundy.listen.R;
import com.sundy.listen.adapter.RecommendAdapter;
import com.sundy.listen.mvvm.ViewModelFactory;
import com.sundy.listen.mvvm.viewmodel.SubscribeViewModel;

/**
 * 项目名称：Himalaya
 *
 * @Author bamboolife
 * 邮箱：core_it@163.com
 * 创建时间：2020-01-16 10:18
 * 描述：推荐订阅
 */
public class RecommendFragment extends BaseMvvmFragment<CommonLayoutListBinding, SubscribeViewModel> {

    private RecommendAdapter mRecommendAdapter;

    @Override
    protected int onBindLayout() {
        return R.layout.common_layout_list;
    }

    @Override
    protected boolean enableSwipeBack() {
        return false;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
//        mBinding.recyclerview.setLayoutManager(new LinearLayoutManager(mActivity));
//        mBinding.recyclerview.setHasFixedSize(true);
    }

    @Override
    public void initViewObservable() {

    }

    @Override
    public Class<SubscribeViewModel> onBindViewModel() {
        return SubscribeViewModel.class;
    }

    @Override
    public ViewModelProvider.Factory onBindViewModelFactory() {
        return ViewModelFactory.getInstance(mApplication);
    }



}
