//
//  FrgKczy
//
//  Created by DELL on 2018-01-04 09:57:36
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dzb.frg;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.ab.view.listener.AbOnListViewListener;
import com.ab.view.pullview.AbPullListView;
import com.bean.fx.proto.MIndex;
import com.google.gson.Gson;
import com.mdx.framework.adapter.MAdapter;
import com.ndtlg.dzb.R;
import com.ndtlg.dzb.ada.AdaKczy;
import com.ndtlg.dzb.item.KczyTop;

import java.util.ArrayList;

import static com.ndtlg.dzb.F.json2Model;
import static com.ndtlg.dzb.F.mCategoryList;
import static com.ndtlg.dzb.F.mStudyCircleList;


public class FrgKczy extends BaseFrg {

    public AbPullListView mAbPullListView;
    public RadioGroup mRadioGroup_content;
    public MIndex.MCategoryList mMCategoryList;

    @Override
    protected void create(Bundle savedInstanceState) {
        setContentView(R.layout.frg_kczy);
        initView();
        loaddata();
    }

    private void initView() {
        findVMethod();
    }

    private void findVMethod() {
        mAbPullListView = (AbPullListView) findViewById(R.id.mAbPullListView);
        mRadioGroup_content = (RadioGroup) findViewById(R.id.mRadioGroup_content);
        mRadioGroup_content.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (mMCategoryList != null)
                    mAbPullListView.setGetApiLoadParams(mStudyCircleList + mMCategoryList.list.get(i).mid);
            }
        });
    }

    public void loaddata() {
        loadUrlGet(mCategoryList);
        mAbPullListView.setAdapter(new AdaKczy(getContext(), new ArrayList()));
        mAbPullListView.setAbOnListViewListener(new AbOnListViewListener() {
            @Override
            public MAdapter onSuccess(String methodName, String content) {
                MIndex.MStudyCircleList mMNewsList = new Gson().fromJson(content, MIndex.MStudyCircleList.class);
                return new AdaKczy(getContext(), mMNewsList.list);
            }
        });

    }

    @Override
    public void onSuccess(String methodName, String content) {
        if (methodName.equals(mCategoryList)) {
            mMCategoryList = (MIndex.MCategoryList) json2Model(content, MIndex.MCategoryList.class);
            for (int i = 0; i < mMCategoryList.list.size(); i++) {
                RadioButton mRadioButton = (RadioButton) KczyTop.getView(getContext(), null);
                mRadioButton.setId(i);
                mRadioButton.setText(mMCategoryList.list.get(i).title);
                mRadioGroup_content.addView(mRadioButton);
            }
            mRadioGroup_content.check(0);
            mAbPullListView.setGetApiLoadParams(mStudyCircleList + mMCategoryList.list.get(0).mid);
        }
    }
}