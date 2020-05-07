package com.sundy.common.helper;

import android.app.Application;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;

import com.blankj.utilcode.util.ActivityUtils;
import com.sundy.common.config.Constants;
import com.sundy.common.reciver.MyPlayerReceiver;
import com.ximalaya.ting.android.opensdk.constants.ConstantsOpenSdk;
import com.ximalaya.ting.android.opensdk.constants.DTransferConstants;
import com.ximalaya.ting.android.opensdk.datatrasfer.AccessTokenManager;
import com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest;
import com.ximalaya.ting.android.opensdk.player.XmPlayerManager;
import com.ximalaya.ting.android.opensdk.player.appnotification.NotificationColorUtils;
import com.ximalaya.ting.android.opensdk.player.appnotification.XmNotificationCreater;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayerConfig;
import com.ximalaya.ting.android.opensdk.util.BaseUtil;
import com.ximalaya.ting.android.opensdk.util.Logger;
import com.ximalaya.ting.android.sdkdownloader.XmDownloadManager;
import com.ximalaya.ting.android.sdkdownloader.http.RequestParams;
import com.ximalaya.ting.android.sdkdownloader.http.app.RequestTracker;
import com.ximalaya.ting.android.sdkdownloader.http.request.UriRequest;

import java.lang.reflect.Method;


/**
 * <br/>Description:App初始化帮助类
 */
public class AppHelper {

    private static Application mApplication;
    private static volatile AppHelper instance;


    private AppHelper() {
    }

    public static AppHelper getInstance(Application application) {
        if (instance == null) {
            synchronized (AppHelper.class) {
                if (instance == null) {
                    mApplication = application;
                    instance = new AppHelper();
                }
            }
        }
        return instance;
    }

    public AppHelper initXmly() {
        ConstantsOpenSdk.isDebug = true;
        CommonRequest mXimalaya=CommonRequest.getInstanse();
        if (DTransferConstants.isRelease){
            mXimalaya.setAppkey(Constants.Third.TBOOK_KEY);
            mXimalaya.setPackid(Constants.Third.PACK_ID);
            mXimalaya.init(mApplication,Constants.Third.XIMALAYA_SECRET);
        }else{
            mXimalaya.setAppkey(Constants.Third.TBOOK_KEY);
            mXimalaya.setPackid(Constants.Third.PACK_ID);
            mXimalaya.init(mApplication,Constants.Third.XIMALAYA_SECRET);
        }

        AccessTokenManager.getInstanse().init(mApplication);
        if (AccessTokenManager.getInstanse().hasLogin()) {
           LoginHelper.registerLoginTokenChangeListener();
        }
        return this;
    }


    public  AppHelper  initXmlyPlayer() {
        XmNotificationCreater instanse = XmNotificationCreater.getInstanse(mApplication);
        instanse.setNextPendingIntent((PendingIntent)null);
        instanse.setPrePendingIntent((PendingIntent)null);

        String actionName = "com.app.test.android.Action_Close";
        Intent intent = new Intent(actionName);
        intent.setClass(mApplication, MyPlayerReceiver.class);
        PendingIntent broadcast = PendingIntent.getBroadcast(mApplication, 0, intent, 0);
        instanse.setClosePendingIntent(broadcast);

        String pauseActionName = "com.app.test.android.Action_PAUSE_START";
        Intent intent1 = new Intent(pauseActionName);
        intent1.setClass(mApplication, MyPlayerReceiver.class);
        PendingIntent broadcast1 = PendingIntent.getBroadcast(mApplication, 0, intent1, 0);
        instanse.setStartOrPausePendingIntent(broadcast1);
        try {
            Method method = XmPlayerConfig.getInstance(mApplication).getClass().getDeclaredMethod("setUseSystemPlayer", boolean.class);
            method.setAccessible(true);
            method.invoke(XmPlayerConfig.getInstance(mApplication), true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        NotificationColorUtils.isTargerSDKVersion24More = true;
        try {
            Notification mNotification = XmNotificationCreater.getInstanse(mApplication)
                    .initNotification(mApplication, Class.forName(ActivityUtils.getLauncherActivity()));
            XmPlayerManager.getInstance(mApplication).init(Constants.Third.XIMALAYA_NOTIFICATION, mNotification);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // 此代码表示播放时会去监测下是否已经下载(setDownloadPlayPathCallback 方法已经废弃 请使用如下方法)
        XmPlayerManager.getInstance(mApplication).setCommonBusinessHandle(XmDownloadManager.getInstance());
        return this;
    }

    public AppHelper initXmlyDownloader() {
            XmDownloadManager.Builder(mApplication)
                    .maxDownloadThread(3)            // 最大的下载个数 默认为1 最大为3
                    .maxSpaceSize(Long.MAX_VALUE)	// 设置下载文件占用磁盘空间最大值，单位字节。不设置没有限制
                    .connectionTimeOut(15000)        // 下载时连接超时的时间 ,单位毫秒 默认 30000
                    .readTimeOut(15000)                // 下载时读取的超时时间 ,单位毫秒 默认 30000
                    //     .fifo(false)                    // 等待队列的是否优先执行先加入的任务. false表示后添加的先执行(不会改变当前正在下载的音频的状态) 默认为true
                    .maxRetryCount(3)                // 出错时重试的次数 默认2次
                    .progressCallBackMaxTimeSpan(10)//  进度条progress 更新的频率 默认是800
                    .requestTracker(requestTracker)	// 日志 可以打印下载信息
                    .savePath(mApplication.getExternalFilesDir("mp3").getAbsolutePath())    // 保存的地址 会检查这个地址是否有效
                    .create();
        return this;
    }

    public AppHelper initLog() {
       // TLog.init(BuildConfig.DEBUG);
        return this;
    }

    public AppHelper initNet() {
       // NetManager.init(new File( mApplication.getCacheDir(),"rx-cache"));
        return this;
    }


    private RequestTracker requestTracker = new RequestTracker() {
        @Override
        public void onWaiting(RequestParams params) {
            Logger.log("TingApplication : onWaiting " + params);
        }

        @Override
        public void onStart(RequestParams params) {
            Logger.log("TingApplication : onStart " + params);
        }

        @Override
        public void onRequestCreated(UriRequest request) {
            Logger.log("TingApplication : onRequestCreated " + request);
        }

        @Override
        public void onSuccess(UriRequest request, Object result) {
            Logger.log("TingApplication : onSuccess " + request + "   result = " + result);
        }

        @Override
        public void onRemoved(UriRequest request) {
            Logger.log("TingApplication : onRemoved " + request);
        }

        @Override
        public void onCancelled(UriRequest request) {
            Logger.log("TingApplication : onCanclelled " + request);
        }

        @Override
        public void onError(UriRequest request, Throwable ex, boolean isCallbackError) {
            Logger.log("TingApplication : onError " + request + "   ex = " + ex + "   isCallbackError = " + isCallbackError);
        }

        @Override
        public void onFinished(UriRequest request) {
            Logger.log("TingApplication : onFinished " + request);
        }
    };

}
