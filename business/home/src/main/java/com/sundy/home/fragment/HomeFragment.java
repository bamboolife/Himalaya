package com.sundy.home.fragment;


import android.os.Bundle;
import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.ViewModelProvider;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sundy.common.adapter.CommonPagerAdapter;
import com.sundy.common.adapter.TabNavigatorAdapter;
import com.sundy.common.base.BaseBindViewHolder;
import com.sundy.common.base.BaseFragment;
import com.sundy.common.base.BaseMvvmFragment;
import com.sundy.common.base.BaseRefreshMvvmFragment;
import com.sundy.common.config.Constants;
import com.sundy.common.mvvm.model.QomolangmaModel;
import com.sundy.home.R;
import com.sundy.home.databinding.BblHomeFgtLayoutBinding;
import com.sundy.home.mvvm.ViewModelFactory;
import com.sundy.home.mvvm.viewmodel.HomeViewModel;
import com.ximalaya.ting.android.opensdk.constants.DTransferConstants;
import com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest;
import com.ximalaya.ting.android.opensdk.datatrasfer.IDataCallBack;
import com.ximalaya.ting.android.opensdk.model.banner.BannerV2List;

import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * 项目名称：Himalaya
 *
 * @Author bamboolife
 * 邮箱：core_it@163.com
 * 创建时间：2020-01-16 10:18
 * 描述：首页主页
 */
@Route(path = Constants.Router.Home.F_MAIN)
public class HomeFragment extends BaseMvvmFragment<BblHomeFgtLayoutBinding, HomeViewModel> {

    @Override
    protected int onBindLayout() {
        return R.layout.bbl_home_fgt_layout;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        String[] tabs = {"热门", "分类", "精品", "主播", "广播"};
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new HotFragment());
        fragments.add(new CategoryFragment());
        fragments.add(new FineFragment());
        fragments.add(new AnnouncerFragment());
        fragments.add(new RadioFragment());

        CommonPagerAdapter adapter = new CommonPagerAdapter(
                getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,fragments);
        mBinding.viewpager.setOffscreenPageLimit(4);
        mBinding.viewpager.setAdapter(adapter);

        final CommonNavigator commonNavigator = new CommonNavigator(mActivity);
        commonNavigator.setAdapter(new TabNavigatorAdapter(Arrays.asList(tabs), mBinding.viewpager, 50));
        commonNavigator.setAdjustMode(true);
        mBinding.magicIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(mBinding.magicIndicator, mBinding.viewpager);
    }

    @Override
    protected ViewModelProvider.Factory onBindViewModelFactory() {
        return ViewModelFactory.getInstance(mApplication);
    }

    @Override
    protected Class<HomeViewModel> onBindViewModel() {
        return HomeViewModel.class;
    }

    @Override
    protected void initViewObservable() {

    }

    @Override
    protected void loadData() {
        super.loadData();
        Map<String, String> map = new HashMap<>();
        map.put(DTransferConstants.CATEGORY_ID, "1");
        map.put(DTransferConstants.IMAGE_SCALE, "2");
        CommonRequest.getCategoryBannersV2(map, new IDataCallBack<BannerV2List>() {
            @Override
            public void onSuccess(BannerV2List bannerV2List) {
                Log.i("log_http", "onSuccess: ");
            }

            @Override
            public void onError(int i, String s) {
                Log.i("log_http", "error: ");
            }
        });
    }
}
