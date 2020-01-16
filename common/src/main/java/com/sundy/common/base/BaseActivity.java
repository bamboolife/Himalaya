package com.sundy.common.base;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.LayoutRes;

import com.alibaba.android.arouter.launcher.ARouter;

import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;
import me.yokeyword.fragmentation_swipeback.SwipeBackActivity;

/**
 * activity 基类
 */
public abstract class BaseActivity extends SwipeBackActivity {
    protected Context mContext;
    protected Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext=getApplicationContext();
        mActivity=this;
        initData();
        if (onBindLayout()!=View.NO_ID){
            setContentView(onBindLayout());
        }
        ARouter.getInstance().inject(this);
        initModel();
        initViews(savedInstanceState);
        setListeners();
        loadData();
    }
    protected @LayoutRes int onBindLayout(){
        return View.NO_ID;
    }
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
     * 设置全局动画
     * @return
     */
    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        return new DefaultHorizontalAnimator();
    }

    @Override
    public void onBackPressedSupport() {
        super.onBackPressedSupport();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
