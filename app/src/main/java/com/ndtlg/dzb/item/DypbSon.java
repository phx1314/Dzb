//
//  DypbSon
//
//  Created by DELL on 2018-01-10 13:38:52
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dzb.item;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bean.common.proto.MCommon;
import com.ndtlg.dzb.R;


public class DypbSon extends BaseItem {
    public LinearLayout mLinearLayout;
    public TextView mTextView;


    @SuppressLint("InflateParams")
    public static View getView(Context context, ViewGroup parent) {
        LayoutInflater flater = LayoutInflater.from(context);
        View convertView = flater.inflate(R.layout.item_dypb_son, null);
        convertView.setTag(new DypbSon(convertView));
        return convertView;
    }

    public DypbSon(View view) {
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
        mTextView = (TextView) contentview.findViewById(R.id.mTextView);


    }

    public void set(MCommon.MItem item) {
        mTextView.setText(TextUtils.isEmpty(item.info) ? "" : item.info);
        TextPaint tp = mTextView.getPaint();
        tp.setFakeBoldText(true);
    }

    public void set(String item, boolean isBold) {
        mTextView.setText(TextUtils.isEmpty(item) ? "" : item);
        TextPaint tp = mTextView.getPaint();
        tp.setFakeBoldText(isBold);
    }


}