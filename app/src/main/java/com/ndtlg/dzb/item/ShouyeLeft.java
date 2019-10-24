//
//  ShouyeLeft
//
//  Created by DELL on 2018-01-05 10:10:59
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
import android.widget.TextView;

import com.bean.fx.proto.MIndex;
import com.ndtlg.dzb.R;


public class ShouyeLeft extends BaseItem {


    public TextView mTextView_1;
    public TextView mTextView_2;
    public ImageView mImageView_1;
    public TextView mTextView_3;
    public ImageView mImageView_3;

    @SuppressLint("InflateParams")
    public static View getView(Context context, ViewGroup parent) {
        LayoutInflater flater = LayoutInflater.from(context);
        View convertView = flater.inflate(R.layout.item_shouye_left, null);
        convertView.setTag(new ShouyeLeft(convertView));
        return convertView;
    }

    public ShouyeLeft(View view) {
        this.contentview = view;
        this.context = contentview.getContext();
        initView();
    }

    private void initView() {
        this.contentview.setTag(this);
        findVMethod();
    }

    private void findVMethod() {


        mTextView_1 = (TextView) findViewById(R.id.mTextView_1);
        mTextView_2 = (TextView) findViewById(R.id.mTextView_2);
        mImageView_1 = (ImageView) findViewById(R.id.mImageView_1);
        mTextView_3 = (TextView) findViewById(R.id.mTextView_3);
        mImageView_3 = (ImageView) findViewById(R.id.mImageView_3);
    }

    public void set(MIndex.MIndexClass item) {
        mTextView_1.setText(item.mid);
        mTextView_2.setText(item.today);
        mTextView_3.setText(item.tomorrow);
        if (item.isOut == 1) {
            mImageView_1.setVisibility(View.VISIBLE);
            mImageView_3.setVisibility(View.VISIBLE);
        } else {
            mImageView_1.setVisibility(View.GONE);
            mImageView_3.setVisibility(View.GONE);
        }
    }


}