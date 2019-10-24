//
//  Banner
//
//  Created by DELL on 2018-01-05 11:03:20
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dzb.item;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bean.fx.proto.MIndex;
import com.mdx.framework.widget.MImageView;
import com.ndtlg.dzb.R;


public class Banner extends BaseItem {
    public MImageView mImageView;


    @SuppressLint("InflateParams")
    public static View getView(Context context, ViewGroup parent) {
        LayoutInflater flater = LayoutInflater.from(context);
        View convertView = flater.inflate(R.layout.item_banner, null);
        convertView.setTag(new Banner(convertView));
        return convertView;
    }

    public Banner(View view) {
        this.contentview = view;
        this.context = contentview.getContext();
        initView();
    }

    private void initView() {
        this.contentview.setTag(this);
        findVMethod();
    }

    private void findVMethod() {
        mImageView = (MImageView) contentview.findViewById(R.id.mImageView);


    }

    public void set(MIndex.MImg item) {
//        new AbImageLoader(context).display(mImageView, item.img);
        mImageView.setObj(item.img);
//        mImageView.setObj("http://czww.viphk.ngrok.org/download/6a14f277bca84bcbbe106ee4a50ec154");
    }


}