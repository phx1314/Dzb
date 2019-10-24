//
//  AdaKczyTop
//
//  Created by DELL on 2018-01-04 10:05:40
//  Copyright (c) DELL All rights reserved.


/**
   
*/

package com.ndtlg.dzb.ada;

import java.util.List;
import com.mdx.framework.adapter.MAdapter;
import android.content.Context;
import android.view.ViewGroup;
import android.view.View;

import com.ndtlg.dzb.item.KczyTop;

public class AdaKczyTop extends MAdapter<String>{

   public AdaKczyTop(Context context, List<String> list) {
        super(context, list);
    }


 	@Override
    public View getview(int position, View convertView, ViewGroup parent) {
        String item = get(position);
        if (convertView == null) {
            convertView = KczyTop.getView(getContext(), parent);;
        }
        KczyTop mKczyTop=(KczyTop) convertView.getTag();
        mKczyTop.set(item);
        return convertView;
    }
}
