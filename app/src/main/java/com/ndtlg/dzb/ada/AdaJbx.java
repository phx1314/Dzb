//
//  AdaJbx
//
//  Created by DELL on 2018-01-03 14:31:40
//  Copyright (c) DELL All rights reserved.


/**
   
*/

package com.ndtlg.dzb.ada;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.mdx.framework.adapter.MAdapter;
import com.ndtlg.dzb.item.Jbx;
import com.ndtlg.dzb.model.ModelData;

import java.util.List;

public class AdaJbx extends MAdapter<ModelData>{

   public AdaJbx(Context context, List<ModelData> list) {
        super(context, list);
    }


 	@Override
    public View getview(int position, View convertView, ViewGroup parent) {
        ModelData item = get(position);
        if (convertView == null) {
            convertView = Jbx.getView(getContext(), parent);;
        }
        Jbx mJbx=(Jbx) convertView.getTag();
        mJbx.set(item);
        return convertView;
    }
}
