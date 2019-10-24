//
//  AdaXyxw
//
//  Created by DELL on 2018-01-03 11:24:49
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dzb.ada;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.bean.fx.proto.MIndex;
import com.framewidget.F;
import com.framewidget.view.CallBackOnly;
import com.mdx.framework.adapter.MAdapter;
import com.ndtlg.dzb.item.DetailDialog;
import com.ndtlg.dzb.item.Xyxw;

import java.util.List;

public class AdaXyxw extends MAdapter<MIndex.MNews> {

    public AdaXyxw(Context context, List<MIndex.MNews> list) {
        super(context, list);
    }


    @Override
    public View getview(int position, View convertView, ViewGroup parent) {
        final MIndex.MNews item = get(position);
        if (convertView == null) {
            convertView = Xyxw.getView(getContext(), parent);
        }
        final Xyxw mXyxw = (Xyxw) convertView.getTag();
        mXyxw.set(item);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final View view1 = DetailDialog.getView(getContext(), null);
                F.showCenterDialog(getContext(), view1, new CallBackOnly() {
                    @Override
                    public void goReturnDo(Dialog mDialog) {
                        ((DetailDialog) view1.getTag()).set(mDialog, item.content);
                    }
                });
            }
        });
        return convertView;
    }
}
