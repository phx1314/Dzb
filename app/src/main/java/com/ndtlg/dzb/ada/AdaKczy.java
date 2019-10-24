//
//  AdaKczy
//
//  Created by DELL on 2018-01-04 10:16:48
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dzb.ada;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.bean.fx.proto.MIndex;
import com.mdx.framework.adapter.MAdapter;
import com.ndtlg.dzb.item.Kczy;

import java.util.List;

public class AdaKczy extends MAdapter<MIndex.MStudyCircle> {

    public AdaKczy(Context context, List<MIndex.MStudyCircle> list) {
        super(context, list);
    }


    @Override
    public View getview(int position, View convertView, ViewGroup parent) {
        final MIndex.MStudyCircle item = get(position);
        if (convertView == null) {
            convertView = Kczy.getView(getContext(), parent);
        }
        Kczy mKczy = (Kczy) convertView.getTag();
        mKczy.set(item);
        return convertView;
    }
}
