package com.sundy.common;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.multidex.MultiDexApplication;

import com.alibaba.android.arouter.launcher.ARouter;
import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.header.ClassicsHeader;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshFooter;
import com.scwang.smart.refresh.layout.api.RefreshHeader;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.constant.SpinnerStyle;
import com.scwang.smart.refresh.layout.listener.DefaultRefreshFooterCreator;
import com.scwang.smart.refresh.layout.listener.DefaultRefreshHeaderCreator;
import com.sundy.common.helper.AppHelper;
import com.sundy.common.helper.ThirdHelper;
import com.sundy.common.widget.TRefreshHeader;
import com.ximalaya.ting.android.opensdk.util.BaseUtil;

import me.yokeyword.fragmentation.Fragmentation;
import me.yokeyword.fragmentation.helper.ExceptionHandler;

/**
 * 项目名称：Himalaya
 *
 * @Author bamboolife
 * 邮箱：core_it@163.com
 * 创建时间：2020-01-14 17:01
 * 描述：
 */
public class App extends MultiDexApplication {
    private static App instance;

    public static App getInstance() {
        return instance;
    }

    {
        //设置全局的Header构建器
//        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
//            @Override
//            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
//                layout.setHeaderHeight(40f);
//                layout.setEnableOverScrollDrag(true); //开启越界拖动（仿苹果效果)
//                layout.setEnableAutoLoadMore(true); //启用列表惯性滑动到底部时自动加载更多
//                layout.setEnableFooterFollowWhenNoMoreData(true);  //在全部加载结束之后Footer跟随内容
//                //layout.setPrimaryColorsId(R.color.colorPrimary, android.R.color.white);//全局设置主题颜色
//                ClassicsHeader.REFRESH_HEADER_REFRESHING=getString(R.string.refreshing);
//                return new ClassicsHeader(context).setEnableLastTime(false).setTextSizeTitle(14f).setSpinnerStyle(SpinnerStyle.Translate);//指定为经典Header，默认是 贝塞尔雷达Header
//            }
//        });
        SmartRefreshLayout.setDefaultRefreshHeaderCreator((context, layout) -> new TRefreshHeader(context));
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                //指定为经典Footer，默认是 BallPulseFooter
                layout.setFooterHeight(40F);
                layout.setEnableOverScrollDrag(true);
                return new ClassicsFooter(context).setDrawableSize(20).setDrawableSize(20f).setTextSizeTitle(14F);
            }
        });
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (BaseUtil.isMainProcess(this)) {
            instance = this;
            ThirdHelper.getmInstance(this)
                    .initRouter()
                    .initFragmentation(true)
                    .initUtils();
            AppHelper.getInstance(this)
                    .initXmly()
                   // .initXmlyPlayer()
                    .initXmlyDownloader();
        }

        if (BaseUtil.isPlayerProcess(this)){
         AppHelper.getInstance(this).initXmlyPlayer();
        }
    }


}
