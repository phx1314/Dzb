//
//  FrgBjfc
//
//  Created by DELL on 2018-01-03 11:24:49
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dzb.frg;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.ab.view.listener.AbOnListViewListener;
import com.bean.fx.proto.MIndex;
import com.google.gson.Gson;
import com.mdx.framework.adapter.MAdapter;
import com.ndtlg.dzb.R;
import com.ndtlg.dzb.ada.AdaBjfc;
import com.ndtlg.dzb.model.ModelData;

import java.util.ArrayList;
import java.util.List;

import static com.ndtlg.dzb.F.xcmClassStyleList;


public class FrgBjfc extends BaseFrg {

    public LinearLayout mLinearLayout;
    public com.ab.view.pullview.AbPullListView mAbPullListView;


    @Override
    protected void create(Bundle savedInstanceState) {
        setContentView(R.layout.frg_bjfc);
        initView();
        loaddata();
    }

    private void initView() {
        findVMethod();
    }

    private void findVMethod() {
        mLinearLayout = (LinearLayout) findViewById(R.id.mLinearLayout);
        mAbPullListView = (com.ab.view.pullview.AbPullListView) findViewById(R.id.mAbPullListView);


    }

    public void loaddata() {

        mAbPullListView.setAdapter(new AdaBjfc(getContext(), new ArrayList()));
        mAbPullListView.setPageSize(16);
        mAbPullListView.setGetApiLoadParams(xcmClassStyleList + 1);
        mAbPullListView.setAbOnListViewListener(new AbOnListViewListener() {
            @Override
            public MAdapter onSuccess(String methodName, String content) {
                MIndex.MPhotoList mMPhotoList = new Gson().fromJson(content, MIndex.MPhotoList.class);
                List data = new ArrayList();
                for (int i = 0; i < mMPhotoList.list.size(); i++) {
                    if (i % 4 == 0) {
                        ModelData mModelData = new ModelData();
                        for (int j = i; j < Math.min(mMPhotoList.list.size(), i + 4); j++) {
                            mModelData.mList.add(mMPhotoList.list.get(j));
                        }
                        data.add(mModelData);
                    }
                }
                return new AdaBjfc(getContext(), data);
            }
        });
    }


}