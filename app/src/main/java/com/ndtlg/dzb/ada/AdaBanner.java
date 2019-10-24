//
//  AdaBanner
//
//  Created by DELL on 2018-01-05 11:03:20
//  Copyright (c) DELL All rights reserved.


/**
   
*/

package com.ndtlg.dzb.ada;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.bean.fx.proto.MIndex;
import com.mdx.framework.adapter.MAdapter;
import com.ndtlg.dzb.item.Banner;

import java.util.List;

public class AdaBanner extends MAdapter<MIndex.MImg>{

   public AdaBanner(Context context, List<MIndex.MImg> list) {
        super(context, list);
    }


 	@Override
    public View getview(int position, View convertView, ViewGroup parent) {
        MIndex.MImg item = get(position);
        if (convertView == null) {
            convertView = Banner.getView(getContext(), parent);;
        }
        Banner mBanner=(Banner) convertView.getTag();
        mBanner.set(item);
        return convertView;
    }
}
