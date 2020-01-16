package com.sundy.mine.fragment;


import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sundy.common.base.BaseFragment;
import com.sundy.common.config.Constants;
import com.sundy.mine.R;
import com.sundy.mine.databinding.BblMineFgtLayoutBinding;
/**
 * 项目名称：Himalaya
 *
 * @Author bamboolife
 * 邮箱：core_it@163.com
 * 创建时间：2020-01-16 10:18
 * 描述：我的主页
 */
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
