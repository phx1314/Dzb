//
//  AdaDypb
//
//  Created by DELL on 2018-01-03 11:24:49
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dzb.ada;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.bean.common.proto.MCommon;
import com.mdx.framework.adapter.MAdapter;
import com.ndtlg.dzb.item.Dypb;

import java.util.List;

public class AdaDypb extends MAdapter<MCommon.MClassSimple> {
    public MCommon.MMoralScoreMap mMMoralScoreMap  ;

    public AdaDypb(Context context, List<MCommon.MClassSimple> list) {
        super(context, list);
    }

    public void setmMMoralScoreMap(MCommon.MMoralScoreMap mMMoralScoreMap) {
        this.mMMoralScoreMap = mMMoralScoreMap;
    }

    @Override
    public View getview(int position, View convertView, ViewGroup parent) {
        MCommon.MClassSimple item = get(position);
        if (convertView == null) {
            convertView = Dypb.getView(getContext(), parent);
        }
        Dypb mDypb = (Dypb) convertView.getTag();
        mDypb.set(item, mMMoralScoreMap);
        return convertView;
    }
}
