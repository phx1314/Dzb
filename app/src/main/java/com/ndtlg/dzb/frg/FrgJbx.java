//
//  FrgJbx
//
//  Created by DELL on 2018-01-03 11:24:48
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dzb.frg;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bean.common.proto.MCommon;
import com.ndtlg.dzb.R;
import com.ndtlg.dzb.ada.AdaJbx;
import com.ndtlg.dzb.item.JbxTop;
import com.ndtlg.dzb.model.ModelData;

import java.util.ArrayList;
import java.util.List;

import static com.ndtlg.dzb.F.json2Model;
import static com.ndtlg.dzb.F.mclass;


public class FrgJbx extends BaseFrg {

    public TextView mTextView_name;
    public TextView mTextView_2;
    public com.ab.view.pullview.AbPullListView mAbPullListView;
    public View view_top;

    @Override
    protected void create(Bundle savedInstanceState) {
        setContentView(R.layout.frg_jbx);
        initView();
        loaddata();
    }

    private void initView() {
        findVMethod();
    }

    private void findVMethod() {
        mTextView_name = (TextView) findViewById(R.id.mTextView_name);
        mTextView_2 = (TextView) findViewById(R.id.mTextView_2);
        mAbPullListView = (com.ab.view.pullview.AbPullListView) findViewById(R.id.mAbPullListView);
        mAbPullListView.setPullLoadEnable(false);
        mAbPullListView.setPullRefreshEnable(false);

    }

    public void loaddata() {
        loadUrlGet(mclass);
        view_top = JbxTop.getView(getContext(), null);
        mAbPullListView.addHeaderView(view_top);
    }

    @Override
    public void onSuccess(String methodName, String content) {
        if (methodName.equals(mclass)) {
            MCommon.MClassInfo mMClassInfo = (MCommon.MClassInfo) json2Model(content, MCommon.MClassInfo.class);
            mTextView_name.setText(mMClassInfo.name);
            mTextView_name.setText("(班主任：" + mMClassInfo.leaderTeacher + ")");
            ((JbxTop) view_top.getTag()).set(mMClassInfo);
            List data = new ArrayList();
            for (int i = 0; i < mMClassInfo.students.size(); i++) {
                if (i % 8 == 0) {
                    ModelData mModelData = new ModelData();
                    for (int j = i; j < Math.min(mMClassInfo.students.size(), i + 8); j++) {
                        mModelData.mList.add(mMClassInfo.students.get(j));
                    }
                    data.add(mModelData);
                }
            }
            mAbPullListView.setAdapter(new AdaJbx(getContext(), data));
        }
    }
}