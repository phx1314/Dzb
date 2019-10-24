//
//  Xyxw
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bean.fx.proto.MIndex;
import com.ndtlg.dzb.R;


public class Xyxw extends BaseItem {
    public LinearLayout mLinearLayout;
    public ImageView mImageView;
    public TextView mTextView_name;
    public TextView mTextView_time;


    @SuppressLint("InflateParams")
    public static View getView(Context context, ViewGroup parent) {
        LayoutInflater flater = LayoutInflater.from(context);
        View convertView = flater.inflate(R.layout.item_xyxw, null);
        convertView.setTag(new Xyxw(convertView));
        return convertView;
    }

    public Xyxw(View view) {
        this.contentview = view;
        this.context = contentview.getContext();
        initView();
    }

    private void initView() {
        this.contentview.setTag(this);
        findVMethod();
    }

    private void findVMethod() {
        mLinearLayout = (LinearLayout) contentview.findViewById(R.id.mLinearLayout);
        mImageView = (ImageView) contentview.findViewById(R.id.mImageView);
        mTextView_name = (TextView) contentview.findViewById(R.id.mTextView_name);
        mTextView_time = (TextView) contentview.findViewById(R.id.mTextView_time);


    }

    public void set(MIndex.MNews item) {
        mTextView_name.setText(item.title);
        mTextView_time.setText(item.time);
    }


}