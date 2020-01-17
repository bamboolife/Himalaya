package com.sundy.listen.mvvm.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;

import com.sundy.common.bean.SubscribeBean;
import com.sundy.common.event.SingleLiveEvent;
import com.sundy.common.mvvm.model.BaseModel;
import com.sundy.common.mvvm.model.QomolangmaModel;
import com.sundy.common.mvvm.viewmodel.BaseRefreshViewModel;
import com.sundy.common.mvvm.viewmodel.BaseViewModel;

/**
 * 项目名称：Himalaya
 *
 * @Author bamboolife
 * 邮箱：core_it@163.com
 * 创建时间：2020-01-17 14:00
 * 描述：
 */
public class SubscribeViewModel extends BaseRefreshViewModel<QomolangmaModel, SubscribeBean> {
     private SingleLiveEvent<String> test;

    public SubscribeViewModel(@NonNull Application application, QomolangmaModel model) {
        super(application, model);
    }


    public SingleLiveEvent<String> getTest() {
        if (test==null){
            test=new SingleLiveEvent<>();
        }
        return test;
    }

    public void setTest(SingleLiveEvent<String> test) {
        this.test = test;
    }
}
