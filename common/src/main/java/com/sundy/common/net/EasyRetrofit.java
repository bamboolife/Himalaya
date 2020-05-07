package com.sundy.common.net;

import android.app.Application;
import android.content.Context;

import org.apache.http.params.HttpParams;

import okhttp3.OkHttpClient;
import okhttp3.internal.http.HttpHeaders;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 项目名称：RxEasyRetrofit
 *
 * @Author bamboolife
 * 邮箱：core_it@163.com
 * 创建时间：2019-11-13 00:56
 * 描述：Retrofit网络请求封装
 * 单利模式
 */
public class EasyRetrofit {
    private static Application sContext;
    private volatile static EasyRetrofit mInstence = null;
    private Retrofit mRetrofit;
    /**
     * 全局公共请求头
     */
    private HttpHeaders mCommonHeaders;
    /**
     * 全局公共请求参数
     */
    private HttpParams mCommonParams;
    /**
     * okhttp请求的Builder
     */
    private OkHttpClient.Builder okHttpClientBuilder;
    /**
     * Retrofit请求Builder
     */
    private Retrofit.Builder retrofitBuilder;
    private String mBaseUrl = "https://www.tianqiapi.com/";

    private EasyRetrofit() {

        okHttpClientBuilder = new OkHttpClient.Builder();
        retrofitBuilder = new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .addConverterFactory(GsonConverterFactory.create());
        mRetrofit = retrofitBuilder
                .client(okHttpClientBuilder.build()).build();

    }
    public static EasyRetrofit getInstance() {
        if (mInstence == null) {
            synchronized (EasyRetrofit.class) {
                if (mInstence == null) {
                    mInstence = new EasyRetrofit();
                }
            }

        }

        return mInstence;
    }

    /**
     * 必须在全局Application先调用，获取context上下文，否则缓存无法使用
     */
    public static void init(Application app) {
        sContext = app;
    }

    /**
     * 获取全局上下文
     */
    public static Context getContext() {
        testInitialize();
        return sContext;
    }
    private static void testInitialize() {
        if (sContext == null)
            throw new ExceptionInInitializerError("请先在全局Application中调用 EasyHttp.init() 初始化！");
    }
//    public void get() {
//        ApiService apiService = mRetrofit.create(ApiService.class);
//        ArrayMap<String, Object> params = new ArrayMap<>();
//        params.put("appid", "45825899");
//        params.put("appsecret", "BdkBA1pF");
//        params.put("version", "v2");
//        params.put("cityid", "101120201");
//
//        Call<ResponseBody> dataCall = apiService.get(params);
//        //异步请求
//        dataCall.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                try {
//                    Log.i("log_info", "onResponse: " + response.body().string());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                Log.i("log_info", "onResponse: " + t.toString());
//            }
//        });
////    try {
////        //同步请求
////       Response<ResponseBody> data= dataCall.execute();
////
////    } catch (IOException e) {
////        e.printStackTrace();
////    }
//    }


    public EasyRetrofit setReadTimeOut(long readTimeOut) {

        return this;
    }

    public EasyRetrofit setWriteTimeOut(long writeTimeout) {

        return this;
    }

    /**
     * 超时重试次数
     */
    public EasyRetrofit setRetryCount(int retryCount) {

        return this;
    }
}
