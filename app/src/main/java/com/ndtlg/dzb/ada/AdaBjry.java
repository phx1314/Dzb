//
//  AdaBjry
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
import com.ndtlg.dzb.item.Bjry;
import com.ndtlg.dzb.model.ModelData;

import java.util.List;

public class AdaBjry extends MAdapter<ModelData> {

    public AdaBjry(Context context, List<ModelData> list) {
        super(context, list);
    }


    @Override
    public View getview(int position, View convertView, ViewGroup parent) {
        ModelData item = get(position);
        if (convertView == null) {
            convertView = Bjry.getView(getContext(), parent);
        }
        Bjry mBjry = (Bjry) convertView.getTag();
        mBjry.set(item);
        return convertView;
    }
}
