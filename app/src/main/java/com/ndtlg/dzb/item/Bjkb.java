//
//  Bjkb
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
import android.widget.TextView;

import com.bean.common.proto.MCommon;
import com.ndtlg.dzb.R;


public class Bjkb extends BaseItem {
    public ImageView mImageView1;
    public TextView mTextView_top1;
    public TextView mTextView_bottom1;
    public ImageView mImageView2;
    public TextView mTextView_top2;
    public TextView mTextView_bottom2;
    public ImageView mImageView3;
    public TextView mTextView_top3;
    public TextView mTextView_bottom3;
    public ImageView mImageView4;
    public TextView mTextView_top4;
    public TextView mTextView_bottom4;
    public ImageView mImageView5;
    public TextView mTextView_top5;
    public TextView mTextView_bottom5;
    public ImageView mImageView6;
    public TextView mTextView_top6;
    public TextView mTextView_bottom6;
    public ImageView mImageView7;
    public TextView mTextView_top7;
    public TextView mTextView_bottom7;
    public ImageView mImageView8;
    public TextView mTextView_top8;
    public TextView mTextView_bottom8;


    @SuppressLint("InflateParams")
    public static View getView(Context context, ViewGroup parent) {
        LayoutInflater flater = LayoutInflater.from(context);
        View convertView = flater.inflate(R.layout.item_bjkb, null);
        convertView.setTag(new Bjkb(convertView));
        return convertView;
    }

    public Bjkb(View view) {
        this.contentview = view;
        this.context = contentview.getContext();
        initView();
    }

    private void initView() {
        this.contentview.setTag(this);
        findVMethod();
    }

    private void findVMethod() {
        mImageView1 = (ImageView) contentview.findViewById(R.id.mImageView1);
        mTextView_top1 = (TextView) contentview.findViewById(R.id.mTextView_top1);
        mTextView_bottom1 = (TextView) contentview.findViewById(R.id.mTextView_bottom1);
        mImageView2 = (ImageView) contentview.findViewById(R.id.mImageView2);
        mTextView_top2 = (TextView) contentview.findViewById(R.id.mTextView_top2);
        mTextView_bottom2 = (TextView) contentview.findViewById(R.id.mTextView_bottom2);
        mImageView3 = (ImageView) contentview.findViewById(R.id.mImageView3);
        mTextView_top3 = (TextView) contentview.findViewById(R.id.mTextView_top3);
        mTextView_bottom3 = (TextView) contentview.findViewById(R.id.mTextView_bottom3);
        mImageView4 = (ImageView) contentview.findViewById(R.id.mImageView4);
        mTextView_top4 = (TextView) contentview.findViewById(R.id.mTextView_top4);
        mTextView_bottom4 = (TextView) contentview.findViewById(R.id.mTextView_bottom4);
        mImageView5 = (ImageView) contentview.findViewById(R.id.mImageView5);
        mTextView_top5 = (TextView) contentview.findViewById(R.id.mTextView_top5);
        mTextView_bottom5 = (TextView) contentview.findViewById(R.id.mTextView_bottom5);
        mImageView6 = (ImageView) contentview.findViewById(R.id.mImageView6);
        mTextView_top6 = (TextView) contentview.findViewById(R.id.mTextView_top6);
        mTextView_bottom6 = (TextView) contentview.findViewById(R.id.mTextView_bottom6);
        mImageView7 = (ImageView) contentview.findViewById(R.id.mImageView7);
        mTextView_top7 = (TextView) contentview.findViewById(R.id.mTextView_top7);
        mTextView_bottom7 = (TextView) contentview.findViewById(R.id.mTextView_bottom7);
        mImageView8 = (ImageView) contentview.findViewById(R.id.mImageView8);
        mTextView_top8 = (TextView) contentview.findViewById(R.id.mTextView_top8);
        mTextView_bottom8 = (TextView) contentview.findViewById(R.id.mTextView_bottom8);


    }

    public void set(MCommon.MSectionMap item, int position) {
        mTextView_top1.setText(item.mid);
        mTextView_bottom1.setText(item.time);
        mTextView_top2.setText(item.sectMap.get("1_" + item.mid)==null?"":item.sectMap.get("1_" + item.mid).name);
        mTextView_bottom2.setText(item.sectMap.get("1_" + item.mid)==null?"":item.sectMap.get("1_" + item.mid).teacher);
        mTextView_top3.setText(item.sectMap.get("2_" + item.mid)==null?"":item.sectMap.get("2_" + item.mid).name);
        mTextView_bottom3.setText(item.sectMap.get("2_" + item.mid)==null?"":item.sectMap.get("2_" + item.mid).teacher);
        mTextView_top4.setText(item.sectMap.get("3_" + item.mid)==null?"":item.sectMap.get("3_" + item.mid).name);
        mTextView_bottom4.setText(item.sectMap.get("3_" + item.mid)==null?"":item.sectMap.get("3_" + item.mid).teacher);
        mTextView_top5.setText(item.sectMap.get("4_" + item.mid)==null?"":item.sectMap.get("4_" + item.mid).name);
        mTextView_bottom5.setText(item.sectMap.get("4_" + item.mid)==null?"":item.sectMap.get("4_" + item.mid).teacher);
        mTextView_top6.setText(item.sectMap.get("5_" + item.mid)==null?"":item.sectMap.get("5_" + item.mid).name);
        mTextView_bottom6.setText(item.sectMap.get("5_" + item.mid)==null?"":item.sectMap.get("5_" + item.mid).teacher);
        mTextView_top7.setText(item.sectMap.get("6_" + item.mid)==null?"":item.sectMap.get("6_" + item.mid).name);
        mTextView_bottom7.setText(item.sectMap.get("6_" + item.mid)==null?"":item.sectMap.get("6_" + item.mid).teacher);
        mTextView_top8.setText(item.sectMap.get("7_" + item.mid)==null?"":item.sectMap.get("7_" + item.mid).name);
        mTextView_bottom8.setText(item.sectMap.get("7_" + item.mid)==null?"":item.sectMap.get("7_" + item.mid).teacher);
    }
}