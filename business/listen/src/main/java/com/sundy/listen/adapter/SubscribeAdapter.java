package com.sundy.listen.adapter;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.sundy.common.base.BaseQuickAdapter;
import com.sundy.listen.R;
import com.sundy.listen.bean.SubscribeBean;
import com.sundy.listen.databinding.BblListenSubscibeItemLayoutBinding;

/**
 * 项目名称：Himalaya
 *
 * @Author bamboolife
 * 邮箱：core_it@163.com
 * 创建时间：2020-01-17 22:15
 * 描述：
 */
public class SubscribeAdapter extends BaseQuickAdapter<SubscribeBean, BblListenSubscibeItemLayoutBinding> {


    @Override
    protected void onBindItem(BblListenSubscibeItemLayoutBinding binding, SubscribeBean item) {

    }

    @Override
    protected int onBindLayout(int viewType) {
        return R.layout.bbl_listen_subscibe_item_layout;
    }


}
