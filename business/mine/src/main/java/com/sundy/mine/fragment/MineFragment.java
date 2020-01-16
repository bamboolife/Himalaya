package com.sundy.mine.fragment;


import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sundy.common.base.BaseFragment;
import com.sundy.common.config.Constants;
import com.sundy.mine.R;
import com.sundy.mine.databinding.BblMineFgtLayoutBinding;

@Route(path = Constants.Router.User.F_MAIN)
public class MineFragment extends BaseFragment<BblMineFgtLayoutBinding> {


    @Override
    protected int onBindLayout() {
        return R.layout.bbl_mine_fgt_layout;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {

    }
}
