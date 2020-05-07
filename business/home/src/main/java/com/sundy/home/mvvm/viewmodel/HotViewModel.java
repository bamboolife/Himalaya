package com.sundy.home.mvvm.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;

import com.sundy.common.base.BaseRefreshMvvmFragment;
import com.sundy.common.event.SingleLiveEvent;
import com.sundy.common.mvvm.model.QomolangmaModel;
import com.sundy.common.mvvm.viewmodel.BaseRefreshViewModel;
import com.ximalaya.ting.android.opensdk.model.album.Album;

import java.util.List;

/**
 * 项目名称：Himalaya
 *
 * @Author bamboolife
 * 邮箱：core_it@163.com
 * 创建时间：2020-01-18 14:36
 * 描述：
 */
public class HotViewModel extends BaseRefreshViewModel<QomolangmaModel, Album> {
    private SingleLiveEvent<List<Album>> mLikesEvent;
    public HotViewModel(@NonNull Application application, QomolangmaModel model) {
        super(application, model);
    }

    public SingleLiveEvent<List<Album>> getLikesEvent() {
        return mLikesEvent=createLiveData(mLikesEvent);
    }
}
