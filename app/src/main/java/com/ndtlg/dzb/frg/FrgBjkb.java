//
//  FrgBjkb
//
//  Created by DELL on 2018-01-03 11:24:48
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dzb.frg;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.ab.view.listener.AbOnListViewListener;
import com.ab.view.pullview.AbPullListView;
import com.bean.common.proto.MCommon;
import com.google.gson.Gson;
import com.mdx.framework.adapter.MAdapter;
import com.ndtlg.dzb.R;
import com.ndtlg.dzb.ada.AdaBjkb;

import java.util.ArrayList;

import static com.ndtlg.dzb.F.mSectionList;


public class FrgBjkb extends BaseFrg {

    public LinearLayout mLinearLayout;
    public AbPullListView mAbPullListView;


    @Override
    protected void create(Bundle savedInstanceState) {
        setContentView(R.layout.frg_bjkb);
        initView();
        loaddata();
    }

    private void initView() {
        findVMethod();
    }

    private void findVMethod() {
        mLinearLayout = (LinearLayout) findViewById(R.id.mLinearLayout);
        mAbPullListView = (AbPullListView) findViewById(R.id.mAbPullListView);


    }

    public void loaddata() {
        mAbPullListView.setAdapter(new AdaBjkb(getContext(), new ArrayList()));
        mAbPullListView.setGET_NOApiLoadParams(mSectionList);
        mAbPullListView.setAbOnListViewListener(new AbOnListViewListener() {
            @Override
            public MAdapter onSuccess(String methodName, String content) {
                MCommon.MSectionList mMNewsList = new Gson().fromJson(content, MCommon.MSectionList.class);
                return new AdaBjkb(getContext(), mMNewsList.list);
            }
        });
    }


}