package com.sundy.home.fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sundy.common.base.BaseQuickAdapter;
import com.sundy.common.base.BaseRefreshMvvmFragment;
import com.sundy.home.R;
import com.sundy.home.adapter.HotAdapter;
import com.sundy.home.databinding.BblFgtHotLayoutBinding;
import com.sundy.home.mvvm.ViewModelFactory;
import com.sundy.home.mvvm.viewmodel.HotViewModel;
import com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest;
import com.ximalaya.ting.android.opensdk.datatrasfer.IDataCallBack;
import com.ximalaya.ting.android.opensdk.model.album.Album;
import com.ximalaya.ting.android.opensdk.model.album.AlbumList;
import com.ximalaya.ting.android.opensdk.model.category.CategoryList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotFragment extends BaseRefreshMvvmFragment<BblFgtHotLayoutBinding,HotViewModel, Album> {
    HotAdapter mAdapter;

    @Override
    protected int onBindLayout() {
        return R.layout.bbl_fgt_hot_layout;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
           mAdapter=new HotAdapter(null);
           new Handler().postDelayed(new Runnable() {
               @Override
               public void run() {
                   List<Album> albums=new ArrayList<>();
                   Album album=new Album();
                   album.setAlbumTitle("11111111");
                   albums.add(album);
                   mViewModel.getLikesEvent().setValue(albums);
               }
           },3000);
        Map<String ,String> maps = new HashMap<String, String>();
        maps.put("page" ,1 + "");
        maps.put("count" ,"200");
//        CommonRequest.getAllPaidAlbums(maps, new IDataCallBack<AlbumList>() {
////            @Override
////            public void onSuccess(AlbumList object) {
////                System.out.println("object = [" + object + "]");
////            }
////
////            @Override
////            public void onError(int code, String message) {
////                System.out.println("code = [" + code + "], message = [" + message + "]");
////            }
////        });
        CommonRequest.getCategories(null, new IDataCallBack<CategoryList>() {
            @Override
            public void onSuccess(CategoryList categoryList) {
                Log.i("log_xi", "onSuccess: "+categoryList);
            }

            @Override
            public void onError(int i, String s) {

            }
        });
    }

    @NonNull
    @Override
    protected WrapRefresh onBindWrapRefresh() {
        return new WrapRefresh(mBinding.refreshLayout,null);
    }

    @Override
    public void setListeners() {
        super.setListeners();
    }

    @Override
    protected ViewModelProvider.Factory onBindViewModelFactory() {
        return ViewModelFactory.getInstance(mApplication);
    }

    @Override
    protected Class onBindViewModel() {
        return HotViewModel.class;
    }

    @Override
    protected void initViewObservable() {
         mViewModel.getLikesEvent().observe(this, albums -> {
             Log.i("log_entity", "initViewObservable:11111111111111 ");
         });
    }

    @Override
    protected void initBaseViewObservable() {
        super.initBaseViewObservable();
    }
}
