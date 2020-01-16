package com.sundy.home.fragment;


import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sundy.common.base.BaseFragment;
import com.sundy.common.config.Constants;
import com.sundy.home.R;

/**
 * 项目名称：Himalaya
 *
 * @Author bamboolife
 * 邮箱：core_it@163.com
 * 创建时间：2020-01-16 10:18
 * 描述：首页主页
 */
@Route(path = Constants.Router.Home.F_MAIN)
public class HomeFragment extends BaseFragment {

    @Override
    protected int onBindLayout() {
        return R.layout.bbl_home_fgt_layout;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {

    }

}
