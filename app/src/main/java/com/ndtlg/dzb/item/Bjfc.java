//
//  Bjfc
//
//  Created by DELL on 2018-01-03 14:47:30
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
import com.mdx.framework.widget.MImageView;
import com.ndtlg.dzb.R;
import com.ndtlg.dzb.frg.FrgXc;
import com.ndtlg.dzb.model.ModelData;


public class Bjfc extends BaseItem {
    public LinearLayout mLinearLayout_1;
    public MImageView mImageView1;
    public TextView mTextView_name_1;
    public TextView mTextView_num_1;
    public LinearLayout mLinearLayout_2;
    public MImageView mImageView2;
    public TextView mTextView_name_2;
    public TextView mTextView_num_2;
    public LinearLayout mLinearLayout_3;
    public MImageView mImageView3;
    public TextView mTextView_name_3;
    public TextView mTextView_num_3;
    public LinearLayout mLinearLayout_4;
    public MImageView mImageView4;
    public TextView mTextView_name_4;
    public TextView mTextView_num_4;

    public ModelData item;

    @SuppressLint("InflateParams")
    public static View getView(Context context, ViewGroup parent) {
        LayoutInflater flater = LayoutInflater.from(context);
        View convertView = flater.inflate(R.layout.item_bjfc, null);
        convertView.setTag(new Bjfc(convertView));
        return convertView;
    }

    public Bjfc(View view) {
        this.contentview = view;
        this.context = contentview.getContext();
        initView();
    }

    private void initView() {
        this.contentview.setTag(this);
        findVMethod();
    }

    private void findVMethod() {
        mLinearLayout_1 = (LinearLayout) contentview.findViewById(R.id.mLinearLayout_1);
        mImageView1 = (MImageView) contentview.findViewById(R.id.mImageView1);
        mTextView_name_1 = (TextView) contentview.findViewById(R.id.mTextView_name_1);
        mTextView_num_1 = (TextView) contentview.findViewById(R.id.mTextView_num_1);
        mLinearLayout_2 = (LinearLayout) contentview.findViewById(R.id.mLinearLayout_2);
        mImageView2 = (MImageView) contentview.findViewById(R.id.mImageView2);
        mTextView_name_2 = (TextView) contentview.findViewById(R.id.mTextView_name_2);
        mTextView_num_2 = (TextView) contentview.findViewById(R.id.mTextView_num_2);
        mLinearLayout_3 = (LinearLayout) contentview.findViewById(R.id.mLinearLayout_3);
        mImageView3 = (MImageView) contentview.findViewById(R.id.mImageView3);
        mTextView_name_3 = (TextView) contentview.findViewById(R.id.mTextView_name_3);
        mTextView_num_3 = (TextView) contentview.findViewById(R.id.mTextView_num_3);
        mLinearLayout_4 = (LinearLayout) contentview.findViewById(R.id.mLinearLayout_4);
        mImageView4 = (MImageView) contentview.findViewById(R.id.mImageView4);
        mTextView_name_4 = (TextView) contentview.findViewById(R.id.mTextView_name_4);
        mTextView_num_4 = (TextView) contentview.findViewById(R.id.mTextView_num_4);
        mLinearLayout_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Helper.startActivity(context, FrgXc.class, NoTitleAct.class, "item", ((MIndex.MPhoto) item.mList.get(0)).mid);
            }
        });
        mLinearLayout_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Helper.startActivity(context, FrgXc.class, NoTitleAct.class, "item", ((MIndex.MPhoto) item.mList.get(1)).mid);
            }
        });
        mLinearLayout_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Helper.startActivity(context, FrgXc.class, NoTitleAct.class, "item", ((MIndex.MPhoto) item.mList.get(2)).mid);
            }
        });
        mLinearLayout_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Helper.startActivity(context, FrgXc.class, NoTitleAct.class, "item", ((MIndex.MPhoto) item.mList.get(3)).mid);
            }
        });
        mImageView1.setRound((int) context.getResources().getDimension(R.dimen.j2dp));
        mImageView2.setRound((int) context.getResources().getDimension(R.dimen.j2dp));
        mImageView3.setRound((int) context.getResources().getDimension(R.dimen.j2dp));
        mImageView4.setRound((int) context.getResources().getDimension(R.dimen.j2dp));
    }

    public void set(ModelData item) {
        this.item = item;
        setShow(item.mList.size());
        for (int i = 0; i < item.mList.size(); i++) {
            MIndex.MPhoto mMPhoto = (MIndex.MPhoto) item.mList.get(i);
            if (i == 0) {
                mTextView_name_1.setText(mMPhoto.title);
                mImageView1.setObj(mMPhoto.img);

                mTextView_num_1.setText("(" + mMPhoto.cnt + ")");
            } else if (i == 1) {
                mTextView_name_2.setText(mMPhoto.title);
                mImageView2.setObj(mMPhoto.img);
                mTextView_num_2.setText("(" + mMPhoto.cnt + ")");
            } else if (i == 2) {
                mTextView_name_3.setText(mMPhoto.title);
                mImageView3.setObj(mMPhoto.img);
                mTextView_num_3.setText("(" + mMPhoto.cnt + ")");
            } else if (i == 3) {
                mTextView_name_4.setText(mMPhoto.title);
                mImageView4.setObj(mMPhoto.img);
                mTextView_num_4.setText("(" + mMPhoto.cnt + ")");
            }
        }
    }

    void setShow(int count) {
        mLinearLayout_1.setVisibility(count > 0 ? View.VISIBLE : View.INVISIBLE);
        mLinearLayout_2.setVisibility(count > 1 ? View.VISIBLE : View.INVISIBLE);
        mLinearLayout_3.setVisibility(count > 2 ? View.VISIBLE : View.INVISIBLE);
        mLinearLayout_4.setVisibility(count > 3 ? View.VISIBLE : View.INVISIBLE);
    }

}