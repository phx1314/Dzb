//
//  AdaKczySon
//
//  Created by DELL on 2018-01-04 10:16:48
//  Copyright (c) DELL All rights reserved.


/**
   
*/

package com.ndtlg.dzb.ada;

import java.util.List;
import com.mdx.framework.adapter.MAdapter;
import android.content.Context;
import android.view.ViewGroup;
import android.view.View;

import com.ndtlg.dzb.item.KczySon;

public class AdaKczySon extends MAdapter<String>{

   public AdaKczySon(Context context, List<String> list) {
        super(context, list);
    }


 	@Override
    public View getview(int position, View convertView, ViewGroup parent) {
        String item = get(position);
        if (convertView == null) {
            convertView = KczySon.getView(getContext(), parent);;
        }
        KczySon mKczySon=(KczySon) convertView.getTag();
        mKczySon.set(item);
        return convertView;
    }
}
