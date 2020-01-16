package com.sundy.main.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.next.easynavigation.view.EasyNavigationBar;
import com.sundy.common.base.BaseFragment;
import com.sundy.common.config.Constants;
import com.sundy.main.R;
import com.sundy.main.databinding.BblMainFgtLayoutBinding;
import com.sundy.main.databinding.BblMainLayoutBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：Himalaya
 *
 * @Author bamboolife
 * 邮箱：core_it@163.com
 * 创建时间：2020-01-15 16:47
 * 描述：
 */
@Route(path = "/main/fragment")
public class MainFragment extends BaseFragment<BblMainFgtLayoutBinding> {
    private String[] tabText = {"首页", "我听", "", "发现", "我的"};

    private @DrawableRes
    int[] normalIcon = {R.mipmap.main_tab_home_normal, R.mipmap.main_tab_litsten_normal
            , R.mipmap.main_tab_play, R.mipmap.main_tab_find_normal, R.mipmap.main_tab_user_normal};
    private @DrawableRes
    int[] selectIcon = {R.mipmap.main_tab_home_press, R.mipmap.main_tab_listen_press
            , R.mipmap.main_tab_play, R.mipmap.main_tab_find_press, R.mipmap.main_tab_user_press};

    @Override
    protected int onBindLayout() {
        return R.layout.bbl_main_fgt_layout;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mView.setBackgroundColor(Color.WHITE);
    }

    @Override
    protected boolean enableSwipeBack() {
        return false;
    }

    @Override
    protected boolean enableLazy() {
        return true;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        List<Fragment> fragments=new ArrayList<>();
        Fragment home = (Fragment) mRouter.build(Constants.Router.Home.F_MAIN).navigation();
        if (null != home) {
            fragments.add(home);
        }
        Fragment listen = (Fragment) mRouter.build(Constants.Router.Listen.F_MAIN).navigation();
        if (null != listen) {
            fragments.add(listen);
        }
        Fragment discover = (Fragment) mRouter.build(Constants.Router.Discover.F_MAIN).navigation();
        if (null != listen) {
            fragments.add(discover);
        }
        Fragment user = (Fragment) mRouter.build(Constants.Router.User.F_MAIN).navigation();
        if (null != listen) {
            fragments.add( user);
        }
        mBinding.navigation.titleItems(tabText)
                .normalIconItems(normalIcon)
                .selectIconItems(selectIcon)
                .fragmentList(fragments)
                .lineHeight(1)
                .mode(EasyNavigationBar.MODE_ADD)
                .fragmentManager(getChildFragmentManager())
                .normalTextColor(getResources().getColor(R.color.colorGray))   //Tab未选中时字体颜色
                .selectTextColor(getResources().getColor(R.color.colorPrimary))   //Tab选中时字体颜色
                .tabTextSize(11)   //Tab文字大小
                .iconSize(27)
                .addIconSize(0)//取消中间图标
                .navigationHeight(50)
               // .onTabClickListener(this)
                .build();

    }
}
