package com.sundy.common.base;

import android.content.Context;
import android.database.DatabaseUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.IntRange;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.loadmore.LoadMoreView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 项目名称：Himalaya
 *
 * @Author bamboolife
 * 邮箱：core_it@163.com
 * 创建时间：2020-01-16 16:08
 * 描述：
 */
public abstract class BaseQuickAdapter<T extends BaseObservable,DB extends ViewDataBinding> extends RecyclerView.Adapter<BaseBindViewHolder> {
    private Context mContext;
    ObservableList<T> datas;

    public BaseQuickAdapter(){

    }

    public BaseQuickAdapter(@NonNull ObservableList<T> datas) {

        this.datas = datas;
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
    }

    @NonNull
    @Override
    public BaseBindViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.mContext=parent.getContext();
        DB binding= DataBindingUtil.inflate(LayoutInflater.from(mContext),onBindLayout(viewType), parent, false);
        return new BaseBindViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull BaseBindViewHolder holder, int position) {
        DB binding= DataBindingUtil.getBinding(holder.itemView);
        onBindItem(binding,datas.get(position));
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     *
     * @param binding
     * @param item
     */
    protected abstract void onBindItem(DB binding, T item);

    /**
     *
     * @param viewType
     * @return
     */
    protected abstract @LayoutRes int onBindLayout(int viewType);

    /**
     * 设置新的数据源
     * @param data
     */
    public void setNewData(@Nullable ObservableList<T> data) {
        this.datas = data == null ? new ObservableArrayList<>() : data;
        notifyDataSetChanged();
    }

    /**
     * 在指定的位置添加一条数据
     * @param position
     * @param data
     */
    public void addData(@IntRange(from = 0) int position, @NonNull T data) {
        datas.add(position, data);
         notifyItemInserted(position);
    }

    /**
     * 在末尾添加一条数据
     */
    public void addData(@NonNull T data) {
        datas.add(data);
        notifyItemInserted(datas.size());
    }

    /**
     * 移除指定位置的数据
     * @param position
     */
    public void remove(@IntRange(from = 0) int position) {
        datas.remove(position);
        notifyItemRemoved(position);
    }

    /**
     * 改变指定位置的数据
     */
    public void setData(@IntRange(from = 0) int index, @NonNull T data) {
        datas.set(index, data);
        notifyItemChanged(index );
    }

    /**
     * 在指定的位置添加集合
     * @param position
     * @param newData
     */
    public void addDatas(@IntRange(from = 0) int position, @NonNull Collection<? extends T> newData) {
        datas.addAll(position, newData);
        notifyItemRangeInserted(position , newData.size());

    }

    /**
     * 在末尾添加集合
     */
    public void addDatas(@NonNull Collection<? extends T> newData) {
        datas.addAll(newData);
        notifyItemRangeInserted(datas.size(), newData.size());

    }
     @NonNull
    public ObservableList<T> getDatas() {
        return datas;
    }

    @NonNull
    public T getItem(@IntRange(from = 0)int position){
        if (position>=0&&position<datas.size()){
            return datas.get(position);
        }
        return null;
    }


    class DatasChangedCallback extends ObservableList.OnListChangedCallback{

        @Override
        public void onChanged(ObservableList sender) {
          BaseQuickAdapter.this.notifyDataSetChanged();
        }

        @Override
        public void onItemRangeChanged(ObservableList sender, int positionStart, int itemCount) {
            BaseQuickAdapter.this.notifyItemRangeChanged(positionStart,itemCount);
        }

        @Override
        public void onItemRangeInserted(ObservableList sender, int positionStart, int itemCount) {
             BaseQuickAdapter.this.notifyItemRangeInserted(positionStart,itemCount);
        }

        @Override
        public void onItemRangeMoved(ObservableList sender, int fromPosition, int toPosition, int itemCount) {
              BaseQuickAdapter.this.notifyItemRangeRemoved(fromPosition,toPosition);
        }

        @Override
        public void onItemRangeRemoved(ObservableList sender, int positionStart, int itemCount) {
              BaseQuickAdapter.this.notifyItemRangeRemoved(positionStart,itemCount);
        }
    }
}
