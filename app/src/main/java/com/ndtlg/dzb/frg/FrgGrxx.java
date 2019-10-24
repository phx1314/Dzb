//
//  FrgGrxx
//
//  Created by DELL on 2018-01-04 13:33:00
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dzb.frg;

import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.bean.common.proto.MCommon;
import com.mdx.framework.Frame;
import com.mdx.framework.widget.MImageView;
import com.ndtlg.dzb.R;

import static com.ndtlg.dzb.F.json2Model;
import static com.ndtlg.dzb.F.mUserInfo;


public class FrgGrxx extends BaseFrg {

    public MImageView mMImageView;
    public TextView mTextView_name;
    public TextView mTextView_cz;
    public TextView mTextView_zx;
    public TextView mTextView_xh;
    public TextView mTextView_time;
    public TextView mTextView_sex;
    public TextView mTextView_phone;
    public TextView mTextView_zw;
    public TextView mTextView_jg;
    public TextView mTextView_bm;
    public TextView mTextView_mz;
    private Handler handler = new Handler();
    private Runnable runnable;
    private int times = 60;

    @Override
    protected void create(Bundle savedInstanceState) {
        setContentView(R.layout.frg_grxx);
        initView();
        loaddata();
    }

    @Override
    public void disposeMsg(int type, Object obj) {
        switch (type) {
            case 0:
                loadGet(mUserInfo + obj.toString(), mUserInfo);
                times = 60;
                handler.post(runnable);
                break;
            case 1:
                handler.removeCallbacks(runnable);
                break;
        }
    }

    private void initView() {
        findVMethod();
    }

    private void findVMethod() {
        mMImageView = (MImageView) findViewById(R.id.mMImageView);
        mTextView_name = (TextView) findViewById(R.id.mTextView_name);
        mTextView_cz = (TextView) findViewById(R.id.mTextView_cz);
        mTextView_zx = (TextView) findViewById(R.id.mTextView_zx);
        mTextView_xh = (TextView) findViewById(R.id.mTextView_xh);
        mTextView_time = (TextView) findViewById(R.id.mTextView_time);
        mTextView_sex = (TextView) findViewById(R.id.mTextView_sex);
        mTextView_phone = (TextView) findViewById(R.id.mTextView_phone);
        mTextView_zw = (TextView) findViewById(R.id.mTextView_zw);
        mTextView_jg = (TextView) findViewById(R.id.mTextView_jg);
        mTextView_bm = (TextView) findViewById(R.id.mTextView_bm);
        mTextView_mz = (TextView) findViewById(R.id.mTextView_mz);

        runnable = new Runnable() {
            @Override
            public void run() {
                if (times > 0) {
                    times--;
                    mTextView_cz.setText("(" + times + "s内无操作将回到首页)");
                    handler.postDelayed(runnable, 1000);
                } else if (times == 0) {
                    logOut();
                }
            }
        };
        mTextView_zx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logOut();
            }
        });
    }

    public void logOut() {
        Frame.HANDLES.sentAll("FrgHome", 5, null);
    }


    public void loaddata() {

    }

    @Override
    public void onSuccess(String methodName, String content) {
        if (methodName.equals(mUserInfo)) {
            MCommon.MUserInfo mMUserInfo = (MCommon.MUserInfo) json2Model(content, MCommon.MUserInfo.class);
            mMImageView.setObj(mMUserInfo.headimg);
            mMImageView.setCircle(true);
            mTextView_name.setText(mMUserInfo.name);
            mTextView_xh.setText("学号             " + Html.fromHtml("<b>" + mMUserInfo.code + "</b>"));
            mTextView_time.setText("出生日期            " + Html.fromHtml("<b>" + mMUserInfo.birthday + "</b>"));
            mTextView_sex.setText("性别            " + Html.fromHtml("<b>" + mMUserInfo.sex + "</b>"));
            mTextView_phone.setText("手机号            " + Html.fromHtml("<b>" + mMUserInfo.phone + "</b>"));
            mTextView_zw.setText("职务             " + Html.fromHtml("<b>" + mMUserInfo.degree + "</b>"));
            mTextView_jg.setText("籍贯             " + Html.fromHtml("<b>" + mMUserInfo.address + "</b>"));
            mTextView_bm.setText("部门             " + Html.fromHtml("<b>" + mMUserInfo.department + "</b>"));
            mTextView_mz.setText("民族             " + Html.fromHtml("<b>" + mMUserInfo.nations + "</b>"));
        }
    }

}