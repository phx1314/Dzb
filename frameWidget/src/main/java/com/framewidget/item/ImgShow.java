//
//  ImgShow
//
//  Created by Administrator on 2015-10-04 14:37:02
//  Copyright (c) Administrator All rights reserved.

/**

 */

package com.framewidget.item;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.framewidget.R;
import com.mdx.framework.widget.MImageView;

public class ImgShow extends BaseItem {
    public MImageView mMImageView;

    @SuppressLint("InflateParams")
    public static View getView(Context context, ViewGroup parent) {
        LayoutInflater flater = LayoutInflater.from(context);
        View convertView = flater.inflate(R.layout.item_img_show, null);
        convertView.setTag(new ImgShow(convertView));
        return convertView;
    }

    public ImgShow(View view) {
        this.contentview = view;
        this.context = contentview.getContext();
        initView();
    }

    private void initView() {
        this.contentview.setTag(this);
        mMImageView = (MImageView) contentview.findViewById(R.id.mMImageView);
        mMImageView.setScaleAble(true);
    }

    public void set(String item) {
        mMImageView.setObj(item);
    }

}