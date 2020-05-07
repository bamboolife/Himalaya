package com.sundy.common.mvvm.model;

import android.app.Application;

import com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest;
import com.ximalaya.ting.android.opensdk.datatrasfer.IDataCallBack;
import com.ximalaya.ting.android.opensdk.model.category.CategoryList;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/**
 * 项目名称：Himalaya
 *
 * @Author bamboolife
 * 邮箱：core_it@163.com
 * 创建时间：2020-01-17 21:52
 * 描述：
 */
public class QomolangmaModel extends BaseModel{
    public QomolangmaModel(Application application) {
        super(application);
    }

     //第一步获取免费内容分类
    /**
     * 获取喜马拉雅免费内容分类
     */
    public Observable<CategoryList> getCategories(Map<String, String> specificParams){
        return Observable.create(new ObservableOnSubscribe<CategoryList>() {
            @Override
            public void subscribe(ObservableEmitter<CategoryList> emitter) throws Exception {
                CommonRequest.getCategories(specificParams, new IDataCallBack<CategoryList>() {
                    @Override
                    public void onSuccess(CategoryList categoryList) {

                    }

                    @Override
                    public void onError(int i, String s) {

                    }
                });

            }
        });
    }
//
//    /**
//     * 获取焦点图
//     * @param specificParams
//     * @return
//     */
//    public Observable<BannerV2List> getCategoryBannersV2(Map<String, String> specificParams){
//
//        return Observable.create(new ObservableOnSubscribe<BannerV2List>() {
//            @Override
//            public void subscribe(ObservableEmitter<BannerV2List> emitter) throws Exception {
//                CommonRequest.getCategoryBannersV2(specificParams, new IDataCallBack<BannerV2List>() {
//                    @Override
//                    public void onSuccess(BannerV2List bannerV2List) {
//                        emitter.onNext(bannerV2List);
//                        emitter.onComplete();
//
//                    }
//
//                    @Override
//                    public void onError(int i, String s) {
//                        emitter.onError(new CustException(String.valueOf(i), s));
//                    }
//                });
//            }
//        });
//    }
//
//    /**
//     * 获取猜你喜欢的
//     * @param specificParams
//     * @return
//     */
//  public Observable<GussLikeAlbumList> getGussLikeAlbumList(Map<String, String> specificParams){
//        return Observable.create(new ObservableOnSubscribe<GussLikeAlbumList>() {
//            @Override
//            public void subscribe(ObservableEmitter<GussLikeAlbumList> emitter) throws Exception {
//                CommonRequest.getGuessLikeAlbum(specificParams, new IDataCallBack<GussLikeAlbumList>() {
//                    @Override
//                    public void onSuccess(GussLikeAlbumList gussLikeAlbumList) {
//                        emitter.onNext(gussLikeAlbumList);
//                        emitter.onComplete();
//                    }
//
//                    @Override
//                    public void onError(int i, String s) {
//                        emitter.onError(new CustException(String.valueOf(i), s));
//                    }
//                });
//            }
//        });
  //}

    //点播内容api
    /**
     * 分类列表
     */

    /**
     * 标签列表
     */

    /**
     * 专辑列表
     */

    /**
     * 专辑浏览
     */

    /**
     * 批量获取专辑信息
     */

    /**
     * 批量获取专辑更新信息
     */

    /**
     *
     */
}
