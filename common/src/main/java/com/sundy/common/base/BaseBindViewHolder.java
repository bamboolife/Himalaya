package com.sundy.common.base;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.sundy.common.manager.GlideApp;

/**
 * 项目名称：Himalaya
 *
 * @Author bamboolife
 * 邮箱：core_it@163.com
 * 创建时间：2020-01-16 16:10
 * 描述：
 */
public class BaseBindViewHolder extends RecyclerView.ViewHolder {
    private ViewDataBinding mBinding;
    public BaseBindViewHolder(@NonNull View itemView) {
        super(itemView);
        mBinding= DataBindingUtil.bind(itemView);
    }

    public ViewDataBinding getBinding() {
        return mBinding;
    }

    public void setBinding(ViewDataBinding binding) {
        mBinding = binding;
    }

//    @SuppressLint("ResourceType")
//    @BindingAdapter({"bind:imageUrl","bing:error"})
//    public static void loadImage(ImageView imageview, String url,  int errorId){
//        GlideApp.with(imageview.getContext()).load(url).placeholder(errorId).error(errorId).into(imageview);
//    }
//
//    @BindingAdapter("android:src")
//    public static void setImageViewResource(ImageView imageView,int resIs){
//        imageView.setImageResource(resIs);
//    }
//
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @BindingAdapter(value = {"srcCompat","android:tint"})
    public static void setImageViewCompatResource(ImageView imageView,int resId,int colorId){
        imageView.setImageResource(resId);
        imageView.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(imageView.getContext(),colorId)));

    }
}
