//
//  JbxTop
//
//  Created by DELL on 2018-01-03 11:24:49
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dzb.item;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bean.common.proto.MCommon;
import com.framewidget.view.MGridView;
import com.ndtlg.dzb.R;
import com.ndtlg.dzb.ada.AdaJbxTopSon;


public class JbxTop extends BaseItem {
    public TextView mTextView_1;
    public MGridView mGridView;
    public TextView mTextView_2;


    @SuppressLint("InflateParams")
    public static View getView(Context context, ViewGroup parent) {
        LayoutInflater flater = LayoutInflater.from(context);
        View convertView = flater.inflate(R.layout.item_jbx_top, null);
        convertView.setTag(new JbxTop(convertView));
        return convertView;
    }

    public JbxTop(View view) {
        this.contentview = view;
        this.context = contentview.getContext();
        initView();
    }

    private void initView() {
        this.contentview.setTag(this);
        findVMethod();
    }

    private void findVMethod() {
        mTextView_1 = (TextView) contentview.findViewById(R.id.mTextView_1);
        mGridView = (MGridView) contentview.findViewById(R.id.mGridView);
        mTextView_2 = (TextView) contentview.findViewById(R.id.mTextView_2);

    }

    public void set(MCommon.MClassInfo item) {
        mTextView_1.setText(item.teachers.size() + "名");
        mTextView_2.setText(item.students.size() + "名");
        mGridView.setAdapter(new AdaJbxTopSon(context, item.teachers ));
    }


}