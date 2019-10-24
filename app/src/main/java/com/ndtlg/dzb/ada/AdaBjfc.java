//
//  AdaBjfc
//
//  Created by DELL on 2018-01-03 14:47:30
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dzb.ada;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.mdx.framework.adapter.MAdapter;
import com.ndtlg.dzb.item.Bjfc;
import com.ndtlg.dzb.model.ModelData;

import java.util.List;

public class AdaBjfc extends MAdapter<ModelData> {

    public AdaBjfc(Context context, List<ModelData> list) {
        super(context, list);
    }


    @Override
    public View getview(int position, View convertView, ViewGroup parent) {
        ModelData item = get(position);
        if (convertView == null) {
            convertView = Bjfc.getView(getContext(), parent);
        }
        Bjfc mBjfc = (Bjfc) convertView.getTag();
        mBjfc.set(item);
        return convertView;
    }
}
