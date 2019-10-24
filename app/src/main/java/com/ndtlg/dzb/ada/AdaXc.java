//
//  AdaXc
//
//  Created by DELL on 2018-01-04 11:17:10
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dzb.ada;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.bean.fx.proto.MIndex;
import com.mdx.framework.Frame;
import com.mdx.framework.adapter.MAdapter;
import com.ndtlg.dzb.item.Xc;

import java.util.List;

public class AdaXc extends MAdapter<MIndex.MImg> {
    public int position_xz;

    public AdaXc(Context context, List<MIndex.MImg> list) {
        super(context, list);
    }


    @Override
    public View getview(final int position, View convertView, ViewGroup parent) {
        MIndex.MImg item = get(position);
        if (convertView == null) {
            convertView = Xc.getView(getContext(), parent);
        }
        Xc mXc = (Xc) convertView.getTag();
        mXc.set(item, position_xz == position);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Frame.HANDLES.sentAll("FrgXc", 0, position);
            }
        });
        return convertView;
    }

    public void refresh(int position) {
        this.position_xz = position;
        this.notifyDataSetChanged();
    }
}
