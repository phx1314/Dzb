//
//  AdaDetailDialog
//
//  Created by DELL on 2018-01-04 13:08:41
//  Copyright (c) DELL All rights reserved.


/**
   
*/

package com.ndtlg.dzb.ada;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.mdx.framework.adapter.MAdapter;
import com.ndtlg.dzb.item.DetailDialog;

import java.util.List;

public class AdaDetailDialog extends MAdapter<String>{

   public AdaDetailDialog(Context context, List<String> list) {
        super(context, list);
    }


 	@Override
    public View getview(int position, View convertView, ViewGroup parent) {
        String item = get(position);
        if (convertView == null) {
            convertView = DetailDialog.getView(getContext(), parent);;
        }
        DetailDialog mDetailDialog=(DetailDialog) convertView.getTag();
//        mDetailDialog.set(item);
        return convertView;
    }
}
