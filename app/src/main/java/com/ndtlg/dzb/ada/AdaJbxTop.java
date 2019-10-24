//
//  AdaJbxTop
//
//  Created by DELL on 2018-01-03 11:24:49
//  Copyright (c) DELL All rights reserved.


/**
   
*/

package com.ndtlg.dzb.ada;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.mdx.framework.adapter.MAdapter;
import com.ndtlg.dzb.item.JbxTop;

import java.util.List;

public class AdaJbxTop extends MAdapter<String>{

   public AdaJbxTop(Context context, List<String> list) {
        super(context, list);
    }


 	@Override
    public View getview(int position, View convertView, ViewGroup parent) {
        String item = get(position);
        if (convertView == null) {
            convertView = JbxTop.getView(getContext(), parent);;
        }
        JbxTop mJbxTop=(JbxTop) convertView.getTag();
//        mJbxTop.set(item);
        return convertView;
    }
}
