//
//  AdaShouyeLeft
//
//  Created by DELL on 2018-01-05 10:10:59
//  Copyright (c) DELL All rights reserved.


/**
   
*/

package com.ndtlg.dzb.ada;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.bean.fx.proto.MIndex;
import com.mdx.framework.adapter.MAdapter;
import com.ndtlg.dzb.item.ShouyeLeft;

import java.util.List;

public class AdaShouyeLeft extends MAdapter<MIndex.MIndexClass>{

   public AdaShouyeLeft(Context context, List<MIndex.MIndexClass> list) {
        super(context, list);
    }


 	@Override
    public View getview(int position, View convertView, ViewGroup parent) {
        MIndex.MIndexClass item = get(position);
        if (convertView == null) {
            convertView = ShouyeLeft.getView(getContext(), parent);;
        }
        ShouyeLeft mShouyeLeft=(ShouyeLeft) convertView.getTag();
        mShouyeLeft.set(item);
        return convertView;
    }
}
