//
//  Dypb
//
//  Created by DELL on 2018-01-03 11:24:49
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dzb.item;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bean.common.proto.MCommon;
import com.ndtlg.dzb.R;


public class Dypb extends BaseItem {
    public LinearLayout mLinearLayout;
    public TextView mTextView_2;
    public LinearLayout mLinearLayout_content;
    public TextView mTextView_3;
    public TextView mTextView_1;
    public ImageView mImageView;


    @SuppressLint("InflateParams")
    public static View getView(Context context, ViewGroup parent) {
        LayoutInflater flater = LayoutInflater.from(context);
        View convertView = flater.inflate(R.layout.item_dypb, null);
        convertView.setTag(new Dypb(convertView));
        return convertView;
    }

    public Dypb(View view) {
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
        mTextView_2 = (TextView) findViewById(R.id.mTextView_2);
        mLinearLayout_content = (LinearLayout) findViewById(R.id.mLinearLayout_content);
        mTextView_3 = (TextView) findViewById(R.id.mTextView_3);
        mTextView_1 = (TextView) findViewById(R.id.mTextView_1);
        mImageView = (ImageView) findViewById(R.id.mImageView);


    }

    public void set(MCommon.MClassSimple item, MCommon.MMoralScoreMap mMMoralScoreMap) {
        mTextView_1.setText(item.rank + "");
        mTextView_2.setText(item.name);
        mTextView_3.setText(item.total + "");
        if (item.isSelf == 1) {
            mImageView.setVisibility(View.VISIBLE);
            TextPaint tp = mTextView_1.getPaint();
            tp.setFakeBoldText(true);
            TextPaint tp2 = mTextView_2.getPaint();
            tp2.setFakeBoldText(true);
            TextPaint tp3 = mTextView_3.getPaint();
            tp3.setFakeBoldText(true);
        } else {
            mImageView.setVisibility(View.GONE);
            TextPaint tp = mTextView_1.getPaint();
            tp.setFakeBoldText(false);
            TextPaint tp2 = mTextView_2.getPaint();
            tp2.setFakeBoldText(false);
            TextPaint tp3 = mTextView_3.getPaint();
            tp3.setFakeBoldText(false);
        }
        mLinearLayout_content.removeAllViews();
        for (MCommon.MItem mMItem : mMMoralScoreMap.items) {
            View view = DypbSon.getView(context, null);
            ((DypbSon) view.getTag()).set(mMMoralScoreMap.scoreMap.get(mMItem.mid + "_" + item.mid) == null ? "" : (mMMoralScoreMap.scoreMap.get(mMItem.mid + "_" + item.mid) + ""), item.isSelf == 1);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT);
            layoutParams.weight = 1;
            mLinearLayout_content.addView(view, layoutParams);
        }
    }


}