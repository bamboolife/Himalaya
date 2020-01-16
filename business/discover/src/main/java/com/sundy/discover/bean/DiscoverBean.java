package com.sundy.discover.bean;

import androidx.annotation.ColorInt;
import androidx.annotation.IdRes;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.Observable;

/**
 * 项目名称：Himalaya
 *
 * @Author bamboolife
 * 邮箱：core_it@163.com
 * 创建时间：2020-01-16 10:19
 * 描述：
 */
public class DiscoverBean extends BaseObservable {
    @Bindable
    private @IdRes int resId;
    @Bindable
    private @ColorInt int colorId;
    @Bindable
    private String title;

    private String rightTitle;
    private @IdRes int rightResId;

    public DiscoverBean(int resId, String title) {
        this.resId = resId;
        this.title = title;
    }

    public DiscoverBean(int resId, int colorId, String title) {
        this.resId = resId;
        this.colorId = colorId;
        this.title = title;
    }

    public DiscoverBean(int resId, String title, String rightTitle, int rightResId) {
        this.resId = resId;
        this.title = title;
        this.rightTitle = rightTitle;
        this.rightResId = rightResId;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public String getRightTitle() {
        return rightTitle;
    }

    public void setRightTitle(String rightTitle) {
        this.rightTitle = rightTitle;
    }

    public int getRightResId() {
        return rightResId;
    }

    public void setRightResId(int rightResId) {
        this.rightResId = rightResId;
    }

}
