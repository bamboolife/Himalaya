package com.sundy.common.helper;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.sundy.common.BuildConfig;

import me.yokeyword.fragmentation.Fragmentation;
import me.yokeyword.fragmentation.helper.ExceptionHandler;

/**
 * 项目名称：Himalaya
 *
 * @Author bamboolife
 * 邮箱：core_it@163.com
 * 创建时间：2020-01-18 13:14
 * 描述：
 */
public class ThirdHelper {
    private volatile static ThirdHelper mInstance=null;
    private static Application mApplication;
    private ThirdHelper(){

    }

    public static ThirdHelper getmInstance(Application application) {
        if (mInstance==null){
            synchronized (ThirdHelper.class){
                if (mInstance==null){
                    mInstance=new ThirdHelper();
                    mApplication=application;
                }
            }
        }
        return mInstance;
    }

    //初始化路由管理
    public ThirdHelper initRouter(){
        if (BuildConfig.DEBUG) {
            // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(mApplication); // 尽可能早，推荐在Application中初始化
        return this;
    }

    /**
     * 初始化常用全局工具类
     * @return
     */
    public ThirdHelper initUtils(){

        return this;
    }

    /**
     *
     * @param isDebug
     * @return
     */
    public ThirdHelper initFragmentation(boolean isDebug){
        // 建议在Application里初始化
        Fragmentation.builder()
                // 显示悬浮球 ; 其他Mode:SHAKE: 摇一摇唤出   NONE：隐藏
                .stackViewMode(Fragmentation.BUBBLE)
                .debug(isDebug)
                /**
                 * 可以获取到{@link me.yokeyword.fragmentation.exception.AfterSaveStateTransactionWarning}
                 * 在遇到After onSaveInstanceState时，不会抛出异常，会回调到下面的ExceptionHandler
                 */
                .handleException(new ExceptionHandler() {
                    @Override
                    public void onException(Exception e) {
                        // 以Bugtags为例子: 把捕获到的 Exception 传到 Bugtags 后台。
                        // Bugtags.sendException(e);
                    }
                })
                .install();
        return this;
    }


}
