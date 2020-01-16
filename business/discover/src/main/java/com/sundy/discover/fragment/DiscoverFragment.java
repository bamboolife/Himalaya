package com.sundy.discover.fragment;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.Observable;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sundy.common.base.BaseFragment;
import com.sundy.common.base.BaseQuickAdapter;
import com.sundy.common.config.Constants;
import com.sundy.common.widget.itemdecoration.Y_Divider;
import com.sundy.common.widget.itemdecoration.Y_DividerBuilder;
import com.sundy.common.widget.itemdecoration.Y_DividerItemDecoration;
import com.sundy.discover.BR;
import com.sundy.discover.R;
import com.sundy.discover.adapter.DiscoverAdapter;
import com.sundy.discover.bean.DiscoverBean;
import com.sundy.discover.databinding.BblDiscoverFgtLayoutBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：Himalaya
 *
 * @Author bamboolife
 * 邮箱：core_it@163.com
 * 创建时间：2020-01-16 10:18
 * 描述：发现主页
 */
@Route(path = Constants.Router.Discover.F_MAIN)
public class DiscoverFragment extends BaseFragment<BblDiscoverFgtLayoutBinding> {
    DiscoverAdapter mAdapter;

    @Override
    protected int onBindLayout() {
        return R.layout.bbl_discover_fgt_layout;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mView.setBackgroundColor(Color.WHITE);
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {

        mAdapter = new DiscoverAdapter(getData());
        mBinding.include.recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mBinding.include.recyclerView.addItemDecoration(new DividerItemDecoration(mContext));
        mBinding.include.recyclerView.setAdapter(mAdapter);

    }

    private ObservableList<DiscoverBean> getData() {
        ObservableList<DiscoverBean> items = new ObservableArrayList<>();
        items.add(new DiscoverBean(R.drawable.ic_discover_ffjp, R.color.d_ffjp, getString(R.string.d_pay_good)));
        items.add(new DiscoverBean(R.drawable.ic_discover_qmld, R.color.d_qmld, getString(R.string.d_all_read)));
        items.add(new DiscoverBean(R.drawable.ic_discover_tyq, R.color.d_tyq, getString(R.string.d_listen_circle)));
        items.add(new DiscoverBean(R.drawable.ic_discover_dkzb, R.color.d_dkzb, getString(R.string.d_dkzt)));
        items.add(new DiscoverBean(R.drawable.ic_discover_wd, R.color.d_wd, getString(R.string.d_wd)));
        items.add(new DiscoverBean(R.drawable.ic_discover_sc, R.color.d_sc, getString(R.string.d_shopping_mall)));
        items.add(new DiscoverBean(R.drawable.ic_discover_yx, R.color.d_yx, getString(R.string.d_game)));
        items.add(new DiscoverBean(R.drawable.ic_discover_hd, R.color.d_hd, getString(R.string.d_activity)));
        return items;
    }

    @Override
    public void setListeners() {
        super.setListeners();
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(mContext,""+position,Toast.LENGTH_LONG).show();
            }
        });
    }

    class DividerItemDecoration extends Y_DividerItemDecoration {
        private Context mContext;

        public DividerItemDecoration(Context context) {
            super(context);
            this.mContext = context;
        }

        @Nullable
        @Override
        public Y_Divider getDivider(int itemPosition) {
            Y_Divider divider = null;
            switch (itemPosition) {
                case 0:
                    divider = new Y_DividerBuilder()
                            .setBottomSideLine(true, mContext.getResources().getColor(R.color.light_grey), 10, 0, 0)
                            .setTopSideLine(true, mContext.getResources().getColor(R.color.light_grey), 10, 0, 0).create();
                    break;
                case 2:
                    divider = new Y_DividerBuilder().setBottomSideLine(true, mContext.getResources().getColor(R.color.light_grey), 10, 0, 0).create();
                    break;
                case 4:
                    divider = new Y_DividerBuilder().setBottomSideLine(true, mContext.getResources().getColor(R.color.light_grey), 10, 0, 0).create();
                    break;
                default:
                    divider = new Y_DividerBuilder().setBottomSideLine(true, mContext.getResources().getColor(R.color.light_grey), 1, 0, 0).create();
                    break;
            }

            return divider;

        }
    }
}
