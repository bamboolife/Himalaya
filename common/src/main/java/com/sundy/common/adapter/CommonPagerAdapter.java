package com.sundy.common.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.collection.SparseArrayCompat;
import androidx.databinding.ObservableList;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * 项目名称：Himalaya
 *
 * @Author bamboolife
 * 邮箱：core_it@163.com
 * 创建时间：2020-01-17 12:09
 * 描述：
 */
public class CommonPagerAdapter extends FragmentPagerAdapter {
    private final  List<Fragment> pages;
    private final SparseArrayCompat<WeakReference<Fragment>> holder;
    public CommonPagerAdapter(@NonNull FragmentManager fm, int behavior, List<Fragment> pages) {
        super(fm, behavior);
        this.pages=pages;
        this.holder=new SparseArrayCompat<>(pages.size());
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return pages.get(position);
    }

    @Override
    public int getCount() {
        return pages.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        Object item=super.instantiateItem(container,position);
        if (item instanceof Fragment){
            holder.put(position,new WeakReference<>((Fragment)item));
        }
        return item;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        holder.remove(position);
        super.destroyItem(container, position, object);
    }

    public Fragment getPage(int position) {
        final WeakReference<Fragment> weakRefItem = holder.get(position);
        return (weakRefItem != null) ? weakRefItem.get() : null;
    }
}
