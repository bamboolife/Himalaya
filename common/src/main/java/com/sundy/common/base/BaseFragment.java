package com.sundy.common.base;


import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.launcher.ARouter;
import com.sundy.common.R;

import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseFragment<DB extends ViewDataBinding> extends SwipeBackFragment {
    protected Context mContext;
    protected Activity mActivity;
    protected ARouter mRouter =ARouter.getInstance();
    //根部局
    protected View mView;
    protected DB mBinding;
    //记录是否第一次进入
    private boolean isFirst = true;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity=getActivity();
        mContext=getActivity().getApplicationContext();
        mRouter.inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.common_layout_root, container, false);
        if (enableSwipeBack()){
            mView.setBackgroundColor(Color.WHITE);
        }
        initData();
        initCommonView();
        initModel();
        if (!enableLazy()){
            loadView();
            initViews(savedInstanceState);
            setListeners();

        }
        if (enableSwipeBack()){
            attachToSwipeBack(mView);
        }
        return mView;
    }

    private void initCommonView() {
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        if (enableLazy()){
            loadView();
            initViews(savedInstanceState);
            setListeners();
            initData();
        }
    }

    @Override
    public void onEnterAnimationEnd(Bundle savedInstanceState) {
        super.onEnterAnimationEnd(savedInstanceState);
        if (!enableLazy()){
            initData();
        }
    }

    protected abstract @LayoutRes
    int onBindLayout();
    /**
     * 程序开始数据的初始化
     */
    protected void initData(){ }
    /**
     * 初始化model
     */
    protected void initModel() {

    }
    /**
     * 填充布局(布局懒加载)
     */
    protected void loadView() {
        ViewStub mViewStubContent = mView.findViewById(R.id.vs_content);
        mViewStubContent.setLayoutResource(onBindLayout());

        View contentView = mViewStubContent.inflate();
        mBinding = DataBindingUtil.bind(contentView);


    }
    /**
     * 初始化控件
     * @param savedInstanceState
     */
    protected abstract void initViews(Bundle savedInstanceState);

    /**
     * 控件监听
     */
    public void setListeners() { }


    /**
     * 载入网络数据
     * 没有网络加载则不重载
     */
    protected void loadData(){ }

    /**
     * 是否可滑动返回,默认true
     *
     * @return
     */
    protected boolean enableSwipeBack() {
        return true;
    }
    /**
     * 是否开启懒加载,默认true
     *
     * @return
     */
    protected boolean enableLazy() {
        return true;
    }
}
