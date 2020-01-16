package com.sundy.common.mvvm.model;

import android.app.Application;
import android.util.Property;

import org.greenrobot.greendao.query.WhereCondition;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

/**
 * 项目名称：Himalaya
 *
 * @Author bamboolife
 * 邮箱：core_it@163.com
 * 创建时间：2020-01-14 17:34
 * 描述：获取持久化数据
 */
public class BaseModel {
    private Application mApplication;

    public BaseModel(Application application){
        this.mApplication=application;
    }

    /**
     * 网络持久化数据
     * 从网络中获取ResponseBody
     * @param url
     * @return
     */

    public Observable<ResponseBody> getCommonBody(String url){

        return null;
    }

    /**
     * 一下是数据库持久化数据
     * 条件查询
     * @param cls
     * @param <T>
     * @return
     */
    public <T> Observable<List<T>> list(Class<T> cls) {

        return null;
    }

    public <T> Observable<List<T>> list(Class<T> cls, int page, int pagesize) {

        return null;
    }

    public <T> Observable<List<T>> listDesc(Class<T> cls, int page, int pagesize, Property desc) {

        return null;
    }

    public <T> Observable<List<T>> listDesc(Class<T> cls, int page, int pagesize, Property desc,WhereCondition cond, WhereCondition... condMore) {

        return null;

    }

    public <T> Observable<List<T>> list(Class<T> cls, WhereCondition cond, WhereCondition... condMore) {

        return null;
    }

    /**
     * 清空数据库所有记录
     *
     * @param cls
     * @param <T>
     * @return
     */
    public <T> Observable<Boolean> clearAll(Class<T> cls) {
        return null;
    }
    /**
     * 更新或插入一条记录
     *
     * @param entity
     * @param <T>
     * @return
     */
    public <T> Observable<T> insert(T entity) {
        return null;
    }

    public Observable<String> getSPString(String key) {
        return null;
    }

    public Observable<String> getSPString(String key, String defaultValue) {
        return null;
    }

    public Observable<Integer> getSPInt(String key) {
        return null;
    }

    public Observable<Integer> getSPInt(String key, int defaultValue) {
        return null;
    }

    public Observable<Long> getSPLong(String key) {
        return null;
    }

    public Observable<Long> getSPLong(String key, long defaultValue) {
        return null;
    }

    public Observable<String> putSP(String key, String value) {
        return null;
    }

    public Observable<Integer> putSP(String key, int value) {
        return null;
    }

    public Observable<Long> putSP(String key, long value) {
        return null;
    }


    public Observable<String> getCacheString(String key) {
        return null;
    }

    public Observable<String> getCacheString(String key, String defaultValue) {
        return null;
    }

    public Observable<Integer> getCacheInt(String key) {
        return null;
    }

    public Observable<Integer> getCacheInt(String key, int defaultValue) {
        return null;
    }

    public Observable<Long> getCacheLong(String key) {
        return null;
    }

    public Observable<Long> getCacheLong(String key, long defaultValue) {
        return null;
    }

    public Observable<String> putCache(String key, String value) {
        return null;
    }

    public Observable<Integer> putCache(String key, int value) {
        return null;
    }

    public Observable<Long> putCache(String key, long value) {
        return null;
    }

}
