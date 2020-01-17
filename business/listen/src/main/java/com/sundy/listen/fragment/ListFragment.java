package com.sundy.listen.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sundy.common.adapter.CommonPagerAdapter;
import com.sundy.common.adapter.TabNavigatorAdapter;
import com.sundy.common.base.BaseFragment;
import com.sundy.common.config.Constants;
import com.sundy.listen.R;
import com.sundy.listen.databinding.BblListFgtLayoutBinding;

import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        String[] tabs={"我的订阅","推荐订阅"};
        List<Fragment> pages=new ArrayList<>();
        pages.add(new SubscribeFragment());
        pages.add(new RecommendFragment());

        CommonPagerAdapter adapter = new CommonPagerAdapter(
                getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,pages);
        mBinding.viewpager.setOffscreenPageLimit(2);
        mBinding.viewpager.setAdapter(adapter);
        final CommonNavigator commonNavigator = new CommonNavigator(mActivity);
        commonNavigator.setAdapter(new TabNavigatorAdapter(Arrays.asList(tabs), mBinding.viewpager,60));
        mBinding.magicIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(mBinding.magicIndicator, mBinding.viewpager);
    }
}
