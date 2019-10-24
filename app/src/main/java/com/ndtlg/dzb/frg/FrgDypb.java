//
//  FrgDypb
//
//  Created by DELL on 2018-01-03 11:24:49
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dzb.frg;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ab.view.listener.AbOnListViewListener;
import com.ab.view.pullview.AbPullListView;
import com.bean.common.proto.MCommon;
import com.framewidget.newMenu.DateDfSelectDialog;
import com.google.gson.Gson;
import com.mdx.framework.adapter.MAdapter;
import com.ndtlg.dzb.R;
import com.ndtlg.dzb.ada.AdaDypb;
import com.ndtlg.dzb.item.DypbSon;
import com.ndtlg.dzb.model.ModelTime;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static com.ndtlg.dzb.F.mmoral;


public class FrgDypb extends BaseFrg {

    public LinearLayout mLinearLayout;
    public TextView mTextView_1;
    public AbPullListView mAbPullListView;
    public ModelTime modelTime;
    public LinearLayout mLinearLayout_time;
    public DateDfSelectDialog mDateSelectDialog;
    public TextView mTextView_today;
    public LinearLayout mLinearLayout_content;

    @Override
    public void disposeMsg(int type, Object obj) {
        switch (type) {
            case 110:
                modelTime = (ModelTime) obj;
                if (TextUtils.isEmpty(mTextView_1.getText().toString().trim())) {
                    mTextView_1.setText(getStringByFormat(modelTime.time, "yyyy-MM-dd"));
                    mTextView_today.setText("今天");
                    mAbPullListView.setGET_NOApiLoadParams(mmoral + mTextView_1.getText().toString());
                }
                break;
        }
    }

    public String getStringByFormat(String strDate, String format) {
        String mDateTime = null;
        try {
            Calendar c = new GregorianCalendar();
            SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
            c.setTime(mSimpleDateFormat.parse(strDate));
            SimpleDateFormat mSimpleDateFormat2 = new SimpleDateFormat(format);
            mDateTime = mSimpleDateFormat2.format(c.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mDateTime;
    }

    @Override
    protected void create(Bundle savedInstanceState) {
        setContentView(R.layout.frg_dypb);
        initView();
        loaddata();
    }

    private void initView() {
        findVMethod();
    }

    private void findVMethod() {
        mLinearLayout = (LinearLayout) findViewById(R.id.mLinearLayout);
        mTextView_1 = (TextView) findViewById(R.id.mTextView_1);
        mAbPullListView = (AbPullListView) findViewById(R.id.mAbPullListView);
        mLinearLayout_time = (LinearLayout) findViewById(R.id.mLinearLayout_time);
        mTextView_today = (TextView) findViewById(R.id.mTextView_today);
        mLinearLayout_content = (LinearLayout) findViewById(R.id.mLinearLayout_content);
        mLinearLayout_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDateSelectDialog.show();
            }
        });
        mDateSelectDialog = new DateDfSelectDialog(getContext(), null, 3);
        mDateSelectDialog.setOnSelected(new DateDfSelectDialog.OnSelected() {
            @Override
            public void onSelected(Dialog dia, String selected) {
                mTextView_1.setText(selected);
                if (selected.equals(getStringByFormat(modelTime.time, "yyyy-MM-dd"))) {
                    mTextView_today.setText("今天");
                } else {
                    mTextView_today.setText("");
                }
                mAbPullListView.setGET_NOApiLoadParams(mmoral + mTextView_1.getText().toString());
            }
        });

    }

    public void loaddata() {


        mAbPullListView.setAdapter(new AdaDypb(getContext(), new ArrayList()));
        mAbPullListView.setAbOnListViewListener(new AbOnListViewListener() {
            @Override
            public MAdapter onSuccess(String methodName, String content) {
                MCommon.MMoralScoreMap mMMoralScoreMap = new Gson().fromJson(content, MCommon.MMoralScoreMap.class);
                mLinearLayout_content.removeAllViews();
                for (MCommon.MItem item : mMMoralScoreMap.items) {
                    View view = DypbSon.getView(getContext(), null);
                    ((DypbSon) view.getTag()).set(item);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT);
                    layoutParams.weight = 1;
                    mLinearLayout_content.addView(view, layoutParams);
                }
                ((AdaDypb) mAbPullListView.getmAdapter()).setmMMoralScoreMap(mMMoralScoreMap);
                return new AdaDypb(getContext(), mMMoralScoreMap.cls);
            }
        });
    }


}