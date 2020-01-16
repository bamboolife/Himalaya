package com.sundy.listen.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sundy.common.base.BaseFragment;
import com.sundy.common.config.Constants;
import com.sundy.listen.R;
import com.sundy.listen.databinding.BblListFgtLayoutBinding;
/**
 * 项目名称：Himalaya
 *
 * @Author bamboolife
 * 邮箱：core_it@163.com
 * 创建时间：2020-01-16 10:18
 * 描述：我听主页
 */
@Route(path = Constants.Router.Listen.F_MAIN)
public class ListFragment extends BaseFragment<BblListFgtLayoutBinding>{

    @Override
    protected int onBindLayout() {
        return R.layout.bbl_list_fgt_layout;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {

    }
}
