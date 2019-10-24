//
//  FrgXyxw
//
//  Created by DELL on 2018-01-03 11:24:49
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dzb.frg;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.ab.view.listener.AbOnListViewListener;
import com.ab.view.pullview.AbPullListView;
import com.bean.fx.proto.MIndex;
import com.google.gson.Gson;
import com.mdx.framework.adapter.MAdapter;
import com.ndtlg.dzb.R;
import com.ndtlg.dzb.ada.AdaXyxw;

import java.util.ArrayList;

import static com.ndtlg.dzb.F.mNewsList;


public class FrgXyxw extends BaseFrg {

    public LinearLayout mLinearLayout;
    public AbPullListView mAbPullListView;
    public String code;

    @Override
    protected void create(Bundle savedInstanceState) {
        setContentView(R.layout.frg_xyxw);
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
        Bundle bundle = getArguments();
        //判断需写
        if (bundle != null) {
            code = bundle.getString("code");
        }
        mAbPullListView.setAdapter(new AdaXyxw(getContext(), new ArrayList()));
        mAbPullListView.setGetApiLoadParams(mNewsList + code);
        mAbPullListView.setAbOnListViewListener(new AbOnListViewListener() {
            @Override
            public MAdapter onSuccess(String methodName, String content) {
                MIndex.MNewsList mMNewsList = new Gson().fromJson(content, MIndex.MNewsList.class);
                return new AdaXyxw(getContext(), mMNewsList.list);
            }
        });

    }


}