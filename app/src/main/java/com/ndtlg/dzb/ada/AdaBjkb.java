//
//  AdaBjkb
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
import com.ndtlg.dzb.item.Bjkb;

import java.util.List;

public class AdaBjkb extends MAdapter<MCommon.MSectionMap> {

    public AdaBjkb(Context context, List<MCommon.MSectionMap> list) {
        super(context, list);
    }


    @Override
    public View getview(int position, View convertView, ViewGroup parent) {
        MCommon.MSectionMap item = get(position);
        if (convertView == null) {
            convertView = Bjkb.getView(getContext(), parent);
        }
        Bjkb mBjkb = (Bjkb) convertView.getTag();
        try {
            mBjkb.set(item, position);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return convertView;
    }
}
