//
//  AdaDypbSon
//
//  Created by DELL on 2018-01-10 13:38:52
//  Copyright (c) DELL All rights reserved.


/**
   
*/

package com.ndtlg.dzb.ada;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.mdx.framework.adapter.MAdapter;
import com.ndtlg.dzb.item.DypbSon;

import java.util.List;

public class AdaDypbSon extends MAdapter<String>{

   public AdaDypbSon(Context context, List<String> list) {
        super(context, list);
    }


 	@Override
    public View getview(int position, View convertView, ViewGroup parent) {
        String item = get(position);
        if (convertView == null) {
            convertView = DypbSon.getView(getContext(), parent);;
        }
        DypbSon mDypbSon=(DypbSon) convertView.getTag();
//        mDypbSon.set(item);
        return convertView;
    }
}
