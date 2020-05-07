package com.sundy.home.mvvm.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;

import com.sundy.common.mvvm.model.QomolangmaModel;
import com.sundy.common.mvvm.viewmodel.BaseViewModel;
import com.ximalaya.ting.android.opensdk.constants.DTransferConstants;
import com.ximalaya.ting.android.opensdk.model.banner.BannerV2;
import com.ximalaya.ting.android.opensdk.model.banner.BannerV2List;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import io.reactivex.functions.Consumer;

/**
 * 项目名称：Himalaya
 *
 * @Author bamboolife
 * 邮箱：core_it@163.com
 * 创建时间：2020-01-17 22:57
 * 描述：
 */
public class HomeViewModel extends BaseViewModel<QomolangmaModel> {

    public HomeViewModel(@NonNull Application application, QomolangmaModel model) {
        super(application, model);
    }

//    /**
//     *
//     */
//    public void getCateroty(){
//        Map<String, String> map = new HashMap<>();
//        map.put(DTransferConstants.CATEGORY_ID, "1");
//        map.put(DTransferConstants.IMAGE_SCALE, "2");
//        mModel.getCategoryBannersV2(map).doOnNext(new Consumer<BannerV2List>() {
//            @Override
//            public void accept(BannerV2List bannerV2List) throws Exception {
//                List<BannerV2> bannerV2s = bannerV2List.getBannerV2s();
//                Iterator<BannerV2> iterator = bannerV2s.iterator();
//                while (iterator.hasNext()) {
//                    BannerV2 next = iterator.next();
//                    //阉割听单
//                    if (next.getBannerContentType() == 5 || next.getBannerContentType() == 6) {
//                        iterator.remove();
//                    }
//                }
//            }
//        });
//    }
}
