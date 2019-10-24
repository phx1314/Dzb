//
//  FrgXyxx
//
//  Created by DELL on 2018-01-04 09:07:57
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dzb.frg;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.mdx.framework.widget.MImageView;
import com.ndtlg.dzb.R;
import com.ndtlg.dzb.model.ModelTime;


public class FrgXyxx extends BaseFrg implements RadioGroup.OnCheckedChangeListener {

    public LinearLayout mLinearLayout;
    public MImageView mMImageView;
    public TextView mTextView1;
    public TextView mTextView2;
    public TextView mTextView3;
    public TextView mTextView4;
    public TextView mTextView5;
    public RadioGroup mRadioGroup;
    public RadioButton mRadioButton1;
    public RadioButton mRadioButton2;
    public LinearLayout mLinearLayout_content;


    @Override
    protected void create(Bundle savedInstanceState) {
        setContentView(R.layout.frg_xyxx);
        initView();
        loaddata();
    }


    @Override
    public void disposeMsg(int type, Object obj) {
        switch (type) {
            case 1:
                chageFrgment(1);
                break;
            case 2:
                chageFrgment(2);
                break;
            case 110:
                ModelTime modelTime = (ModelTime) obj;
                mTextView3.setText(modelTime.time_hour);
                mTextView4.setText(modelTime.week);
                mTextView5.setText(modelTime.time);
                if (modelTime.mMWeather != null) {
                    mTextView1.setText(modelTime.mMWeather.info);
                    mTextView2.setText(modelTime.mMWeather.temperature + "      " + modelTime.mMWeather.wind);
                    mMImageView.setObj(modelTime.mMWeather.img);
                }
                break;
        }
    }

    private void initView() {
        findVMethod();
    }

    private void findVMethod() {
        mLinearLayout = (LinearLayout) findViewById(R.id.mLinearLayout);
        mMImageView = (MImageView) findViewById(R.id.mMImageView);
        mTextView1 = (TextView) findViewById(R.id.mTextView1);
        mTextView2 = (TextView) findViewById(R.id.mTextView2);
        mTextView3 = (TextView) findViewById(R.id.mTextView3);
        mTextView4 = (TextView) findViewById(R.id.mTextView4);
        mTextView5 = (TextView) findViewById(R.id.mTextView5);
        mRadioGroup = (RadioGroup) findViewById(R.id.mRadioGroup);
        mRadioButton1 = (RadioButton) findViewById(R.id.mRadioButton1);
        mRadioButton2 = (RadioButton) findViewById(R.id.mRadioButton2);
        mLinearLayout_content = (LinearLayout) findViewById(R.id.mLinearLayout_content);

        mRadioGroup.setOnCheckedChangeListener(this);
    }

    private void chageFrgment(int position) {
        Fragment fragment = new FrgXyxw();
        Bundle bundle = new Bundle();
        mRadioGroup.setOnCheckedChangeListener(null);
        switch (position) {
            case 1:
                bundle.putString("code", "2");
                mRadioGroup.check(R.id.mRadioButton1);
                break;
            case 2:
                bundle.putString("code", "1");
                mRadioGroup.check(R.id.mRadioButton2);
                break;
        }
        mRadioGroup.setOnCheckedChangeListener(this);
        fragment.setArguments(bundle);
        FragmentManager fm = getChildFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.mLinearLayout_content, fragment);
        transaction.commit();
    }

    public void loaddata() {
        chageFrgment(1);
    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.mRadioButton1:
                chageFrgment(1);
                break;
            case R.id.mRadioButton2:
                chageFrgment(2);
                break;
        }
    }
}