//
//  FrgShbSr
//
//  Created by DELL on 2018-01-17 11:12:38
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dzb.frg;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mdx.framework.Frame;
import com.mdx.framework.activity.IndexAct;
import com.mdx.framework.utility.Helper;
import com.ndtlg.dzb.F;
import com.ndtlg.dzb.R;

import static com.ndtlg.dzb.F.mDeviceidOk;


public class FrgShbSr extends BaseFrg {

    public LinearLayout mLinearLayout;
    public EditText mEditText;
    public ImageView mImageView_del;
    public TextView mTextView_dl;


    @Override
    protected void create(Bundle savedInstanceState) {
        setContentView(R.layout.frg_shb_sr);
        initView();
        loaddata();
    }

    private void initView() {
        findVMethod();
    }

    private void findVMethod() {
        mLinearLayout = (LinearLayout) findViewById(R.id.mLinearLayout);
        mEditText = (EditText) findViewById(R.id.mEditText);
        mImageView_del = (ImageView) findViewById(R.id.mImageView_del);
        mTextView_dl = (TextView) findViewById(R.id.mTextView_dl);

        mImageView_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Frame.finish();
            }
        });
        mTextView_dl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(mEditText.getText().toString().trim())) {
                    Helper.toast("请输入设备号", getContext());
                    return;
                }
                loadGet(mDeviceidOk + mEditText.getText().toString().trim(),mDeviceidOk);
            }
        });
    }

    @Override
    public void onSuccess(String methodName, String content) {
        if (methodName.equals(mDeviceidOk)) {
            F.saveDeviceid(mEditText.getText().toString().trim());
            Helper.startActivity(getContext(), FrgHome.class, IndexAct.class);
        }
    }

    public void loaddata() {

    }


}