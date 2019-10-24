//
//  AdaJbxTopSon
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
import com.ndtlg.dzb.item.JbxTopSon;

import java.util.List;

public class AdaJbxTopSon extends MAdapter<MCommon.MTeacher> {

    public AdaJbxTopSon(Context context, List<MCommon.MTeacher> list) {
        super(context, list);
    }


    @Override
    public View getview(int position, View convertView, ViewGroup parent) {
        MCommon.MTeacher item = get(position);
        if (convertView == null) {
            convertView = JbxTopSon.getView(getContext(), parent);
        }
        JbxTopSon mJbxTopSon = (JbxTopSon) convertView.getTag();
        mJbxTopSon.set(item);
        return convertView;
    }
}
