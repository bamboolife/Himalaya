package com.sundy.discover.adapter;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableList;

import com.sundy.common.base.BaseQuickAdapter;
import com.sundy.discover.R;
import com.sundy.discover.bean.DiscoverBean;
import com.sundy.discover.databinding.BblDiscoverFgtItemLayoutBinding;

import java.util.List;

/**
 * 项目名称：Himalaya
 *
 * @Author bamboolife
 * 邮箱：core_it@163.com
 * 创建时间：2020-01-16 10:18
 * 描述：发现适配器
 */
public class DiscoverAdapter extends BaseQuickAdapter<DiscoverBean, BblDiscoverFgtItemLayoutBinding> {
    public DiscoverAdapter(@NonNull List<DiscoverBean> datas) {
        super(datas);
    }

    @Override
    protected void onBindItem(BblDiscoverFgtItemLayoutBinding binding, DiscoverBean item) {
           binding.setDiscover(item);
           binding.executePendingBindings();
    }

    @Override
    protected int onBindLayout(int viewType) {
        return R.layout.bbl_discover_fgt_item_layout;
    }

}
