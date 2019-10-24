//
//  FrgXxyd
//
//  Created by DELL on 2018-01-05 11:21:44
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


public class FrgXxyd extends BaseFrg {

    public LinearLayout mLinearLayout;
    public MImageView mMImageView;
    public TextView mTextView1;
    public TextView mTextView2;
    public TextView mTextView3;
    public TextView mTextView4;
    public TextView mTextView5;
    public RadioGroup mRadioGroup;
    public RadioButton mRadioButton1;
    public LinearLayout mLinearLayout_content;
    public Fragment fragment1 = new FrgKczy();

    @Override
    protected void create(Bundle savedInstanceState) {
        setContentView(R.layout.frg_xxyd);
        initView();
        loaddata();
    }
    @Override
    public void disposeMsg(int type, Object obj) {
        switch (type) {
            case 110:
                ModelTime modelTime =  (ModelTime) obj;
                mTextView3.setText(modelTime.time_hour);
                mTextView4.setText(modelTime.week);
                mTextView5.setText(modelTime.time);  if (modelTime.mMWeather != null) {
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
        mLinearLayout_content = (LinearLayout) findViewById(R.id.mLinearLayout_content);

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.mRadioButton1:
                        chageFrgment(fragment1);
                        break;
                }
            }
        });
    }

    private void chageFrgment(Fragment fragment) {
        FragmentManager fm = getChildFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.mLinearLayout_content, fragment);
        transaction.commit();
    }

    public void loaddata() {
        chageFrgment(fragment1);
    }


}