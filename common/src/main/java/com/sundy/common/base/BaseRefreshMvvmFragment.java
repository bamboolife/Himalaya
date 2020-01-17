package com.sundy.common.base;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;

import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener;
import com.sundy.common.mvvm.viewmodel.BaseRefreshViewModel;

import java.util.List;

/**
 * 项目名称：Himalaya
 *
 * @Author bamboolife
 * 邮箱：core_it@163.com
 * 创建时间：2020-01-17 16:16
 * 描述：
 */
public abstract class BaseRefreshMvvmFragment<DB extends ViewDataBinding,VM extends BaseRefreshViewModel,T> extends BaseMvvmFragment<DB,VM> implements OnRefreshLoadMoreListener {
   private WrapRefresh mWrapRefresh;

   @CallSuper
    @Override
    public void setListeners() {
        super.setListeners();
        mWrapRefresh=onBindWrapRefresh();
        mWrapRefresh.refreshLayout.setOnRefreshLoadMoreListener(this);
    }

    @Override
    protected void initBaseViewObservable() {
        super.initBaseViewObservable();
        mViewModel.getFinishRefreshEvent().observe(this, (Observer<List<T>>) list -> {
            if (list == null) {
                mWrapRefresh.refreshLayout.finishRefresh(false);
                return;
            }
            if (list.size() == 0) {
                mWrapRefresh.refreshLayout.finishRefresh(true);
                return;
            }
            mWrapRefresh.refreshLayout.finishRefresh(true);
            onRefreshSucc(list);
        });
        mViewModel.getFinishLoadmoreEvent().observe(this, (Observer<List<T>>) list -> {
            if (list == null) {
                mWrapRefresh.refreshLayout.finishLoadMore(false);
                return;
            }
            if (list.size() == 0) {
                mWrapRefresh.refreshLayout.finishLoadMoreWithNoMoreData();
                return;
            }
            mWrapRefresh.refreshLayout.finishLoadMore(true);
            onLoadMoreSucc(list);
        });
    }
    protected void onRefreshSucc(List<T> list) {
        if (mWrapRefresh.quickAdapter != null) {
            mWrapRefresh.quickAdapter.setNewData(list);
        }
    }

    protected void onLoadMoreSucc(List<T> list) {
        if (mWrapRefresh.quickAdapter != null) {
            mWrapRefresh.quickAdapter.addDatas(list);
        }
    }
    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        mViewModel.onViewLoadmore();
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        mViewModel.onViewRefresh();
    }


    protected abstract @NonNull WrapRefresh onBindWrapRefresh();
    protected  class WrapRefresh{
        SmartRefreshLayout refreshLayout;
        BaseQuickAdapter<T, DB> quickAdapter;
        public WrapRefresh(@NonNull SmartRefreshLayout refreshLayout,BaseQuickAdapter<T, DB> quickAdapter){
            this.refreshLayout=refreshLayout;
            this.quickAdapter=quickAdapter;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (null==mWrapRefresh){
            mWrapRefresh.refreshLayout.setOnRefreshLoadMoreListener(null);
        }
    }
}
