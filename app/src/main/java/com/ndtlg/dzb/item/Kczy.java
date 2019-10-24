//
//  Kczy
//
//  Created by DELL on 2018-01-04 10:16:48
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

import com.bean.fx.proto.MIndex;
import com.ndtlg.dzb.R;


public class Kczy extends BaseItem {
    public TextView mTextView_name;
    public TextView mTextView_ls;
    public TextView mTextView_content;


    @SuppressLint("InflateParams")
    public static View getView(Context context, ViewGroup parent) {
        LayoutInflater flater = LayoutInflater.from(context);
        View convertView = flater.inflate(R.layout.item_kczy, null);
        convertView.setTag(new Kczy(convertView));
        return convertView;
    }

    public Kczy(View view) {
        this.contentview = view;
        this.context = contentview.getContext();
        initView();
    }

    private void initView() {
        this.contentview.setTag(this);
        findVMethod();
    }

    private void findVMethod() {
        mTextView_name = (TextView) contentview.findViewById(R.id.mTextView_name);
        mTextView_ls = (TextView) contentview.findViewById(R.id.mTextView_ls);
        mTextView_content = (TextView) findViewById(R.id.mTextView_content);


    }

    public void set(MIndex.MStudyCircle item) {
        mTextView_name.setText(item.title);
        mTextView_content.setText(item.content);
        mTextView_ls.setText("老师：" + item.teachername + "   发布时间：" + item.time);

    }


}