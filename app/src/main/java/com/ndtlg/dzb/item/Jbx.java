//
//  Jbx
//
//  Created by DELL on 2018-01-03 14:31:40
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dzb.item;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bean.common.proto.MCommon;
import com.ndtlg.dzb.R;
import com.ndtlg.dzb.model.ModelData;


public class Jbx extends BaseItem {
    public LinearLayout mLinearLayout_1;
    public TextView mTextView_name_1;
    public TextView mTextView_num_1;
    public LinearLayout mLinearLayout_2;
    public TextView mTextView_name_2;
    public TextView mTextView_num_2;
    public LinearLayout mLinearLayout_3;
    public TextView mTextView_name_3;
    public TextView mTextView_num_3;
    public LinearLayout mLinearLayout_4;
    public TextView mTextView_name_4;
    public TextView mTextView_num_4;
    public LinearLayout mLinearLayout_5;
    public TextView mTextView_name_5;
    public TextView mTextView_num_5;
    public LinearLayout mLinearLayout_6;
    public TextView mTextView_name_6;
    public TextView mTextView_num_6;
    public LinearLayout mLinearLayout_7;
    public TextView mTextView_name_7;
    public TextView mTextView_num_7;
    public LinearLayout mLinearLayout_8;
    public TextView mTextView_name_8;
    public TextView mTextView_num_8;
    public TextView mTextView_name_zw;
    public TextView mTextView_name_zw2;
    public TextView mTextView_name_zw3;
    public TextView mTextView_name_zw4;
    public TextView mTextView_name_zw5;
    public TextView mTextView_name_zw6;
    public TextView mTextView_name_zw7;
    public TextView mTextView_name_zw8;


    @SuppressLint("InflateParams")
    public static View getView(Context context, ViewGroup parent) {
        LayoutInflater flater = LayoutInflater.from(context);
        View convertView = flater.inflate(R.layout.item_jbx, null);
        convertView.setTag(new Jbx(convertView));
        return convertView;
    }

    public Jbx(View view) {
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
        mTextView_name_1 = (TextView) contentview.findViewById(R.id.mTextView_name_1);
        mTextView_num_1 = (TextView) contentview.findViewById(R.id.mTextView_num_1);
        mLinearLayout_2 = (LinearLayout) contentview.findViewById(R.id.mLinearLayout_2);
        mTextView_name_2 = (TextView) contentview.findViewById(R.id.mTextView_name_2);
        mTextView_num_2 = (TextView) contentview.findViewById(R.id.mTextView_num_2);
        mLinearLayout_3 = (LinearLayout) contentview.findViewById(R.id.mLinearLayout_3);
        mTextView_name_3 = (TextView) contentview.findViewById(R.id.mTextView_name_3);
        mTextView_num_3 = (TextView) contentview.findViewById(R.id.mTextView_num_3);
        mLinearLayout_4 = (LinearLayout) contentview.findViewById(R.id.mLinearLayout_4);
        mTextView_name_4 = (TextView) contentview.findViewById(R.id.mTextView_name_4);
        mTextView_num_4 = (TextView) contentview.findViewById(R.id.mTextView_num_4);
        mLinearLayout_5 = (LinearLayout) contentview.findViewById(R.id.mLinearLayout_5);
        mTextView_name_5 = (TextView) contentview.findViewById(R.id.mTextView_name_5);
        mTextView_num_5 = (TextView) contentview.findViewById(R.id.mTextView_num_5);
        mLinearLayout_6 = (LinearLayout) contentview.findViewById(R.id.mLinearLayout_6);
        mTextView_name_6 = (TextView) contentview.findViewById(R.id.mTextView_name_6);
        mTextView_num_6 = (TextView) contentview.findViewById(R.id.mTextView_num_6);
        mLinearLayout_7 = (LinearLayout) contentview.findViewById(R.id.mLinearLayout_7);
        mTextView_name_7 = (TextView) contentview.findViewById(R.id.mTextView_name_7);
        mTextView_num_7 = (TextView) contentview.findViewById(R.id.mTextView_num_7);
        mLinearLayout_8 = (LinearLayout) contentview.findViewById(R.id.mLinearLayout_8);
        mTextView_name_8 = (TextView) contentview.findViewById(R.id.mTextView_name_8);
        mTextView_num_8 = (TextView) contentview.findViewById(R.id.mTextView_num_8);
        mTextView_name_zw = (TextView) findViewById(R.id.mTextView_name_zw);
        mTextView_name_zw2 = (TextView) findViewById(R.id.mTextView_name_zw2);
        mTextView_name_zw3 = (TextView) findViewById(R.id.mTextView_name_zw3);
        mTextView_name_zw4 = (TextView) findViewById(R.id.mTextView_name_zw4);
        mTextView_name_zw5 = (TextView) findViewById(R.id.mTextView_name_zw5);
        mTextView_name_zw6 = (TextView) findViewById(R.id.mTextView_name_zw6);
        mTextView_name_zw7 = (TextView) findViewById(R.id.mTextView_name_zw7);
        mTextView_name_zw8 = (TextView) findViewById(R.id.mTextView_name_zw8);


    }

    public void set(ModelData item) {
        setShow(item.mList.size());
        for (int i = 0; i < item.mList.size(); i++) {
            MCommon.MStudent mMStudent = (MCommon.MStudent) item.mList.get(i);
            if (i == 0) {
                mTextView_name_1.setText(mMStudent.name);
                mTextView_num_1.setText(mMStudent.code);
                mTextView_name_zw.setText(mMStudent.degree);
                mTextView_name_zw.setVisibility(!TextUtils.isEmpty(mMStudent.degree) ? View.VISIBLE : View.GONE);
            } else if (i == 1) {
                mTextView_name_2.setText(mMStudent.name);
                mTextView_num_2.setText(mMStudent.code);
                mTextView_name_zw2.setText(mMStudent.degree);
                mTextView_name_zw2.setVisibility(!TextUtils.isEmpty(mMStudent.degree) ? View.VISIBLE : View.GONE);
            }else if (i == 2) {
                mTextView_name_3.setText(mMStudent.name);
                mTextView_num_3.setText(mMStudent.code);
                mTextView_name_zw3.setText(mMStudent.degree);
                mTextView_name_zw3.setVisibility(!TextUtils.isEmpty(mMStudent.degree) ? View.VISIBLE : View.GONE);
            }else if (i == 3) {
                mTextView_name_4.setText(mMStudent.name);
                mTextView_num_4.setText(mMStudent.code);
                mTextView_name_zw4.setText(mMStudent.degree);
                mTextView_name_zw4.setVisibility(!TextUtils.isEmpty(mMStudent.degree) ? View.VISIBLE : View.GONE);
            }else if (i ==4) {
                mTextView_name_5.setText(mMStudent.name);
                mTextView_num_5.setText(mMStudent.code);
                mTextView_name_zw5.setText(mMStudent.degree);
                mTextView_name_zw5.setVisibility(!TextUtils.isEmpty(mMStudent.degree) ? View.VISIBLE : View.GONE);
            }else if (i == 5) {
                mTextView_name_6.setText(mMStudent.name);
                mTextView_num_6.setText(mMStudent.code);
                mTextView_name_zw6.setText(mMStudent.degree);
                mTextView_name_zw6.setVisibility(!TextUtils.isEmpty(mMStudent.degree) ? View.VISIBLE : View.GONE);
            }else if (i == 6) {
                mTextView_name_7.setText(mMStudent.name);
                mTextView_num_7.setText(mMStudent.code);
                mTextView_name_zw7.setText(mMStudent.degree);
                mTextView_name_zw7.setVisibility(!TextUtils.isEmpty(mMStudent.degree) ? View.VISIBLE : View.GONE);
            }else if (i == 7) {
                mTextView_name_8.setText(mMStudent.name);
                mTextView_num_8.setText(mMStudent.code);
                mTextView_name_zw8.setText(mMStudent.degree);
                mTextView_name_zw8.setVisibility(!TextUtils.isEmpty(mMStudent.degree) ? View.VISIBLE : View.GONE);
            }
        }
    }

    void setShow(int count) {
        mLinearLayout_1.setVisibility(count > 0 ? View.VISIBLE : View.INVISIBLE);
        mLinearLayout_2.setVisibility(count > 1 ? View.VISIBLE : View.INVISIBLE);
        mLinearLayout_3.setVisibility(count > 2 ? View.VISIBLE : View.INVISIBLE);
        mLinearLayout_4.setVisibility(count > 3 ? View.VISIBLE : View.INVISIBLE);
        mLinearLayout_5.setVisibility(count > 4 ? View.VISIBLE : View.INVISIBLE);
        mLinearLayout_6.setVisibility(count > 5 ? View.VISIBLE : View.INVISIBLE);
        mLinearLayout_7.setVisibility(count > 6 ? View.VISIBLE : View.INVISIBLE);
        mLinearLayout_8.setVisibility(count > 7 ? View.VISIBLE : View.INVISIBLE);
    }


}