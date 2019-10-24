//
//  Xc
//
//  Created by DELL on 2018-01-04 11:17:10
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


public class Xc extends BaseItem {
    public MImageView mMImageView;


    @SuppressLint("InflateParams")
    public static View getView(Context context, ViewGroup parent) {
        LayoutInflater flater = LayoutInflater.from(context);
        View convertView = flater.inflate(R.layout.item_xc, null);
        convertView.setTag(new Xc(convertView));
        return convertView;
    }

    public Xc(View view) {
        this.contentview = view;
        this.context = contentview.getContext();
        initView();
    }

    private void initView() {
        this.contentview.setTag(this);
        findVMethod();
    }

    private void findVMethod() {
        mMImageView = (MImageView) contentview.findViewById(R.id.mMImageView);
        mMImageView.setRound((int) context.getResources().getDimension(R.dimen.j2dp));
    }

    public void set(MIndex.MImg item, boolean isXz) {
        mMImageView.setObj(item.img);
        if (isXz) {
            mMImageView.setBackgroundResource(R.drawable.shape_k);
        } else {
            mMImageView.setBackgroundResource(0);
        }
    }


}