package com.sundy.main.test;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

/**
 * 项目名称：Himalaya
 *
 * @Author bamboolife
 * 邮箱：core_it@163.com
 * 创建时间：2020-01-15 10:52
 * 描述：
 */
public class User extends ViewModel {

    private MutableLiveData<String> mCurrentName;

    private MutableLiveData<List<String>> mNameListData;

    public MutableLiveData<String> getCurrentName() {
        return mCurrentName;
    }

    public void setCurrentName(MutableLiveData<String> currentName) {
        mCurrentName = currentName;
    }

    public MutableLiveData<List<String>> getNameListData() {
        return mNameListData;
    }

    public void setNameListData(MutableLiveData<List<String>> nameListData) {
        mNameListData = nameListData;
    }
}
