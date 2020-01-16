package com.sundy.common.widget.itemdecoration;

import android.content.Context;


import androidx.annotation.Nullable;

import com.sundy.common.R;


/**
 * Created by sundy.jiang on 2018/4/2.
 */

public class DividerItemDecoration extends Y_DividerItemDecoration {
    private Context mContext;
    public DividerItemDecoration(Context context) {
        super(context);
        this.mContext=context;
    }

    @Nullable
    @Override
    public Y_Divider getDivider(int itemPosition) {
        Y_Divider divider = new Y_DividerBuilder().setBottomSideLine(true, mContext.getResources().getColor(R.color.light_grey), 1, 15, 15).create();
        return divider;
    }
}
