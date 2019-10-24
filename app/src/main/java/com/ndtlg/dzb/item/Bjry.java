//
//  Bjry
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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bean.fx.proto.MIndex;
import com.mdx.framework.activity.NoTitleAct;
import com.mdx.framework.utility.Helper;
import com.ndtlg.dzb.R;
import com.ndtlg.dzb.frg.FrgXc;
import com.ndtlg.dzb.model.ModelData;

import static com.ndtlg.dzb.R.id.mImageView1;
import static com.ndtlg.dzb.R.id.mImageView2;
import static com.ndtlg.dzb.R.id.mImageView3;
import static com.ndtlg.dzb.R.id.mImageView4;


public class Bjry extends BaseItem {


    public com.mdx.framework.widget.MImageView mMImageView1;
    public TextView mTextView_name1;
    public TextView mTextView_num1;
    public LinearLayout mLinearLayout1;
    public com.mdx.framework.widget.MImageView mMImageView2;
    public TextView mTextView_name2;
    public TextView mTextView_num2;
    public LinearLayout mLinearLayout2;
    public com.mdx.framework.widget.MImageView mMImageView3;
    public TextView mTextView_name3;
    public TextView mTextView_num3;
    public LinearLayout mLinearLayout3;
    public com.mdx.framework.widget.MImageView mMImageView4;
    public TextView mTextView_name4;
    public TextView mTextView_num4;
    public LinearLayout mLinearLayout4;
    private ModelData item;

    @SuppressLint("InflateParams")
    public static View getView(Context context, ViewGroup parent) {
        LayoutInflater flater = LayoutInflater.from(context);
        View convertView = flater.inflate(R.layout.item_bjry, null);
        convertView.setTag(new Bjry(convertView));
        return convertView;
    }

    public Bjry(View view) {
        this.contentview = view;
        this.context = contentview.getContext();
        initView();
    }

    private void initView() {
        this.contentview.setTag(this);
        findVMethod();
    }

    private void findVMethod() {


        mMImageView1 = (com.mdx.framework.widget.MImageView) findViewById(R.id.mMImageView1);
        mTextView_name1 = (TextView) findViewById(R.id.mTextView_name1);
        mTextView_num1 = (TextView) findViewById(R.id.mTextView_num1);
        mLinearLayout1 = (LinearLayout) findViewById(R.id.mLinearLayout1);
        mMImageView2 = (com.mdx.framework.widget.MImageView) findViewById(R.id.mMImageView2);
        mTextView_name2 = (TextView) findViewById(R.id.mTextView_name2);
        mTextView_num2 = (TextView) findViewById(R.id.mTextView_num2);
        mLinearLayout2 = (LinearLayout) findViewById(R.id.mLinearLayout2);
        mMImageView3 = (com.mdx.framework.widget.MImageView) findViewById(R.id.mMImageView3);
        mTextView_name3 = (TextView) findViewById(R.id.mTextView_name3);
        mTextView_num3 = (TextView) findViewById(R.id.mTextView_num3);
        mLinearLayout3 = (LinearLayout) findViewById(R.id.mLinearLayout3);
        mMImageView4 = (com.mdx.framework.widget.MImageView) findViewById(R.id.mMImageView4);
        mTextView_name4 = (TextView) findViewById(R.id.mTextView_name4);
        mTextView_num4 = (TextView) findViewById(R.id.mTextView_num4);
        mLinearLayout4 = (LinearLayout) findViewById(R.id.mLinearLayout4);
        mLinearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Helper.startActivity(context, FrgXc.class, NoTitleAct.class, "item", item.mList.get(0));
            }
        });
        mLinearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Helper.startActivity(context, FrgXc.class, NoTitleAct.class, "item", item.mList.get(1));
            }
        });
        mLinearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Helper.startActivity(context, FrgXc.class, NoTitleAct.class, "item", item.mList.get(2));
            }
        });
        mLinearLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Helper.startActivity(context, FrgXc.class, NoTitleAct.class, "item", item.mList.get(3));
            }
        });
        mMImageView1.setRound((int) context.getResources().getDimension(R.dimen.j2dp));
        mMImageView2.setRound((int) context.getResources().getDimension(R.dimen.j2dp));
        mMImageView3.setRound((int) context.getResources().getDimension(R.dimen.j2dp));
        mMImageView4.setRound((int) context.getResources().getDimension(R.dimen.j2dp));
    }

    public void set(ModelData item) {
        this.item = item;
        setShow(item.mList.size());
        for (int i = 0; i < item.mList.size(); i++) {
            MIndex.MPhoto mMPhoto = (MIndex.MPhoto) item.mList.get(i);
            if (i == 0) {
                mTextView_name1.setText(mMPhoto.info);
                mMImageView1.setObj(mMPhoto.img);
                mTextView_num1.setText("(" + mMPhoto.cnt + ")");
            } else if (i == 1) {
                mTextView_name2.setText(mMPhoto.info);
                mMImageView2.setObj(mMPhoto.img);
                mTextView_num2.setText("(" + mMPhoto.cnt + ")");
            } else if (i == 2) {
                mTextView_name3.setText(mMPhoto.info);
                mMImageView3.setObj(mMPhoto.img);
                mTextView_num3.setText("(" + mMPhoto.cnt + ")");
            } else if (i == 3) {
                mTextView_name4.setText(mMPhoto.info);
                mMImageView4.setObj(mMPhoto.img);
                mTextView_num4.setText("(" + mMPhoto.cnt + ")");
            }
        }
    }

    void setShow(int count) {
        mLinearLayout1.setVisibility(count > 0 ? View.VISIBLE : View.INVISIBLE);
        mLinearLayout2.setVisibility(count > 1 ? View.VISIBLE : View.INVISIBLE);
        mLinearLayout3.setVisibility(count > 2 ? View.VISIBLE : View.INVISIBLE);
        mLinearLayout4.setVisibility(count > 3 ? View.VISIBLE : View.INVISIBLE);
    }

}