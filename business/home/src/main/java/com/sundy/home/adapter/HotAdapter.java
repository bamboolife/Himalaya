package com.sundy.home.adapter;

import androidx.annotation.NonNull;

import com.sundy.common.base.BaseQuickAdapter;
import com.sundy.home.R;
import com.sundy.home.databinding.BblHomeHotItemFgtLayoutBinding;
import com.ximalaya.ting.android.opensdk.model.album.Album;

import java.util.List;

/**
 * 项目名称：Himalaya
 *
 * @Author bamboolife
 * 邮箱：core_it@163.com
 * 创建时间：2020-01-18 15:34
 * 描述：
 */
public class HotAdapter extends BaseQuickAdapter<Album, BblHomeHotItemFgtLayoutBinding> {
    public HotAdapter(@NonNull List<Album> datas) {
        super(datas);
    }

    @Override
    protected void onBindItem(BblHomeHotItemFgtLayoutBinding binding, Album item) {
        binding.setAlbum(item);
        binding.executePendingBindings();
    }

    @Override
    protected int onBindLayout(int viewType) {
        return R.layout.bbl_home_hot_item_fgt_layout;
    }


}
