package com.sundy.common.mvvm.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;

import com.sundy.common.event.SingleLiveEvent;
import com.sundy.common.mvvm.model.BaseModel;

import java.util.Collections;
import java.util.List;

/**
 * 项目名称：Himalaya
 *
 * @Author bamboolife
 * 邮箱：core_it@163.com
 * 创建时间：2020-01-15 14:17
 * 描述：
 */
public class BaseRefreshViewModel<M extends BaseModel, T>extends BaseViewModel<M> {

    public BaseRefreshViewModel(@NonNull Application application, M model) {
        super(application, model);
    }

    private SingleLiveEvent<List<T>> mFinishRefreshEvent;
    private SingleLiveEvent<List<T>> mFinishLoadmoreEvent;
    /**
     * null:失败,size==0:成功,size!=0:执行onRefeshSucc
     */
    public SingleLiveEvent<List<T>> getFinishRefreshEvent() {
        return mFinishRefreshEvent = createLiveData(mFinishRefreshEvent);
    }
    /**
     * null:失败,size==0:成功,size!=0:执行onLoadmoreSucc
     */
    public SingleLiveEvent<List<T>> getFinishLoadmoreEvent() {
        return mFinishLoadmoreEvent = createLiveData(mFinishLoadmoreEvent);
    }

    /**
     * 当界面下拉刷新时,默认直接结束刷新
     */
    public void onViewRefresh() {
        getFinishRefreshEvent().postValue(Collections.emptyList());
    }

    /**
     * 当界面下拉更多时,默认没有更多数据
     */
    public void onViewLoadmore() {
        getFinishLoadmoreEvent().postValue(Collections.emptyList());
    }
}
