//
//  FrgShouye
//
//  Created by DELL on 2018-01-05 11:20:53
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dzb.frg;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ab.view.listener.AbOnListViewListener;
import com.ab.view.pullview.AbPullListView;
import com.bean.common.proto.MCommon;
import com.bean.fx.proto.MIndex;
import com.framewidget.F;
import com.framewidget.view.CallBackOnly;
import com.framewidget.view.DfCirleCurr;
import com.framewidget.view.onPageChange;
import com.google.gson.Gson;
import com.mdx.framework.Frame;
import com.mdx.framework.adapter.MAdapter;
import com.mdx.framework.utility.Helper;
import com.mdx.framework.widget.MImageView;
import com.ndtlg.dzb.R;
import com.ndtlg.dzb.ada.AdaBanner;
import com.ndtlg.dzb.ada.AdaShouyeLeft;
import com.ndtlg.dzb.item.DetailDialog;
import com.ndtlg.dzb.model.ModelTime;

import java.util.ArrayList;

import static com.ndtlg.dzb.F.json2Model;
import static com.ndtlg.dzb.F.mClassList;
import static com.ndtlg.dzb.F.mClassStyleList;
import static com.ndtlg.dzb.F.mIndexClassInfo;
import static com.ndtlg.dzb.F.mStudyList;
import static com.ndtlg.dzb.F.symNewsList;


public class FrgShouye extends BaseFrg {

    public LinearLayout mLinearLayout;
    public MImageView mMImageView;
    public TextView mTextView1;
    public TextView mTextView2;
    public TextView mTextView3;
    public TextView mTextView4;
    public TextView mTextView5;
    public TextView mTextView_bj;
    public TextView mTextView_bzr;
    public AbPullListView mAbPullListView;
    public TextView mTextView_num;
    public DfCirleCurr mDfCirleCurr;
    public MImageView mImageView_news;
    public TextView mTextView_title;
    public TextView mTextView_content;
    public ImageView mImageView_gg;
    public TextView mTextView_tg1;
    public TextView mTextView_tg2;
    public TextView mTextView_tg3;
    public TextView mTextView_tg4;
    public TextView mTextView_tg5;
    public ImageView mImageView_xx;
    public TextView mTextView_xx1;
    public TextView mTextView_xx2;
    public TextView mTextView_xx3;
    public TextView mTextView_xx4;
    public TextView mTextView_xx5;
    public TextView mTextView_xw;
    public MIndex.MNewsList mMNewsList_gg;
    public MIndex.MNewsList mMNewsList_new;
    public LinearLayout mLinearLayout_new;
    public MIndex.MStudyCircleList mMStudyCircleList;
    public MIndex.MPhoto mMPhoto;
    public Handler mHandler = new Handler();
    public Runnable runnable;

    @Override
    protected void create(Bundle savedInstanceState) {
        setContentView(R.layout.frg_shouye);
        initView();
    }

    @Override
    public void disposeMsg(int type, Object obj) {
        switch (type) {
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
        mTextView_bj = (TextView) findViewById(R.id.mTextView_bj);
        mTextView_bzr = (TextView) findViewById(R.id.mTextView_bzr);
        mAbPullListView = (AbPullListView) findViewById(R.id.mAbPullListView);
        mTextView_num = (TextView) findViewById(R.id.mTextView_num);
        mDfCirleCurr = (DfCirleCurr) findViewById(R.id.mDfCirleCurr);
        mImageView_news = (MImageView) findViewById(R.id.mImageView_news);
        mTextView_title = (TextView) findViewById(R.id.mTextView_title);
        mTextView_content = (TextView) findViewById(R.id.mTextView_content);
        mImageView_gg = (ImageView) findViewById(R.id.mImageView_gg);
        mTextView_tg1 = (TextView) findViewById(R.id.mTextView_tg1);
        mTextView_tg2 = (TextView) findViewById(R.id.mTextView_tg2);
        mTextView_tg3 = (TextView) findViewById(R.id.mTextView_tg3);
        mTextView_tg4 = (TextView) findViewById(R.id.mTextView_tg4);
        mTextView_tg5 = (TextView) findViewById(R.id.mTextView_tg5);
        mImageView_xx = (ImageView) findViewById(R.id.mImageView_xx);
        mTextView_xx1 = (TextView) findViewById(R.id.mTextView_xx1);
        mTextView_xx2 = (TextView) findViewById(R.id.mTextView_xx2);
        mTextView_xx3 = (TextView) findViewById(R.id.mTextView_xx3);
        mTextView_xx4 = (TextView) findViewById(R.id.mTextView_xx4);
        mTextView_xx5 = (TextView) findViewById(R.id.mTextView_xx5);
        mTextView_xw = (TextView) findViewById(R.id.mTextView_xw);
        mLinearLayout_new = (LinearLayout) findViewById(R.id.mLinearLayout_new);
        mDfCirleCurr.setOnPageChangeListener(new onPageChange() {
            @Override
            public void goReturnDo(int po) {
                mTextView_num.setText(++po + "/" + mMPhoto.list.size());
            }
        });
        mTextView_num.setOnClickListener(Helper.delayClickLitener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Frame.HANDLES.sentAll("FrgHome", 1, null);
            }
        }));
        mImageView_gg.setOnClickListener(Helper.delayClickLitener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Frame.HANDLES.sentAll("FrgHome", 2, null);
            }
        }));
        mImageView_xx.setOnClickListener(Helper.delayClickLitener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Frame.HANDLES.sentAll("FrgHome", 3, null);
            }
        }));
        mTextView_xw.setOnClickListener(Helper.delayClickLitener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Frame.HANDLES.sentAll("FrgHome", 4, null);
            }
        }));

        mTextView_tg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showNewDetail(mMNewsList_gg.list.get(0).content);
            }
        });
        mTextView_tg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showNewDetail(mMNewsList_gg.list.get(1).content);
            }
        });
        mTextView_tg3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showNewDetail(mMNewsList_gg.list.get(2).content);
            }
        });
        mTextView_tg4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showNewDetail(mMNewsList_gg.list.get(3).content);
            }
        });
        mTextView_tg5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showNewDetail(mMNewsList_gg.list.get(4).content);
            }
        });
        mTextView_xx1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showNewDetail(mMStudyCircleList.list.get(0).content);
            }
        });
        mTextView_xx2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showNewDetail(mMStudyCircleList.list.get(1).content);
            }
        });
        mTextView_xx3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showNewDetail(mMStudyCircleList.list.get(2).content);
            }
        });
        mTextView_xx4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showNewDetail(mMStudyCircleList.list.get(3).content);
            }
        });
        mTextView_xx5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showNewDetail(mMStudyCircleList.list.get(4).content);
            }
        });
        mAbPullListView.setAdapter(new AdaShouyeLeft(getContext(), new ArrayList()));
        mAbPullListView.setAbOnListViewListener(new AbOnListViewListener() {
            @Override
            public MAdapter onSuccess(String methodName, String content) {
                MIndex.MIndexClassList mMIndexClassList = new Gson().fromJson(content, MIndex.MIndexClassList.class);
                return new AdaShouyeLeft(getContext(), mMIndexClassList.list);
            }
        });
        runnable = new Runnable() {
            @Override
            public void run() {
                loaddata();
                mHandler.postDelayed(runnable, 3600*1000);
            }
        };
        mHandler.post(runnable);
    }

    public void showNewDetail(final String url) {
        final View view = DetailDialog.getView(getContext(), null);
        F.showCenterDialog(getContext(), view, new CallBackOnly() {
            @Override
            public void goReturnDo(Dialog mDialog) {
                ((DetailDialog) view.getTag()).set(mDialog, url);
            }
        });
    }

    public void loaddata() {
        loadUrlGet(mIndexClassInfo);
        loadUrlGet(symNewsList + 1);
        loadUrlGet(symNewsList + 2);
        loadUrlGet(mClassStyleList);
        loadUrlGet(mStudyList);
        mAbPullListView.setGET_NOApiLoadParams(mClassList);
    }

    @Override
    public void onSuccess(String methodName, String content) {
        if (methodName.equals(symNewsList + 1)) {
            mMNewsList_gg = (MIndex.MNewsList) json2Model(content, MIndex.MNewsList.class);
            for (int i = 0; i < mMNewsList_gg.list.size(); i++) {
                switch (i) {
                    case 0:
                        mTextView_tg1.setVisibility(View.VISIBLE);
                        mTextView_tg1.setText(mMNewsList_gg.list.get(i).title);
                        break;
                    case 1:
                        mTextView_tg2.setVisibility(View.VISIBLE);
                        mTextView_tg2.setText(mMNewsList_gg.list.get(i).title);
                        break;
                    case 2:
                        mTextView_tg3.setVisibility(View.VISIBLE);
                        mTextView_tg3.setText(mMNewsList_gg.list.get(i).title);
                        break;
                    case 3:
                        mTextView_tg4.setVisibility(View.VISIBLE);
                        mTextView_tg4.setText(mMNewsList_gg.list.get(i).title);
                        break;
                    case 4:
                        mTextView_tg5.setVisibility(View.VISIBLE);
                        mTextView_tg5.setText(mMNewsList_gg.list.get(i).title);
                        break;
                }
            }
        } else if (methodName.equals(symNewsList + 2)) {
            mMNewsList_new = (MIndex.MNewsList) json2Model(content, MIndex.MNewsList.class);
            mImageView_news.setObj(mMNewsList_new.list.get(0).img);
            mTextView_title.setText(mMNewsList_new.list.get(0).title);
            mTextView_content.setText(mMNewsList_new.list.get(0).content);
        } else if (methodName.equals(mClassStyleList)) {
            mMPhoto = (MIndex.MPhoto) json2Model(content, MIndex.MPhoto.class);
            mDfCirleCurr.setAdapter(new AdaBanner(getContext(), mMPhoto.list));
            mTextView_num.setText("1/" + mMPhoto.list.size());
        } else if (methodName.equals(mIndexClassInfo)) {
            MCommon.MClassInfo mMClassInfo = (MCommon.MClassInfo) json2Model(content, MCommon.MClassInfo.class);
            mTextView_bj.setText(mMClassInfo.name);
            mTextView_bzr.setText("班主任：" + mMClassInfo.leaderTeacher);
        } else if (methodName.equals(mStudyList)) {
            mMStudyCircleList = (MIndex.MStudyCircleList) json2Model(content, MIndex.MStudyCircleList.class);
            for (int i = 0; i < mMStudyCircleList.list.size(); i++) {
                switch (i) {
                    case 0:
                        mTextView_xx1.setVisibility(View.VISIBLE);
                        mTextView_xx1.setText(mMStudyCircleList.list.get(i).title);
                        break;
                    case 1:
                        mTextView_xx2.setVisibility(View.VISIBLE);
                        mTextView_xx2.setText(mMStudyCircleList.list.get(i).title);
                        break;
                    case 2:
                        mTextView_xx3.setVisibility(View.VISIBLE);
                        mTextView_xx3.setText(mMStudyCircleList.list.get(i).title);
                        break;
                    case 3:
                        mTextView_xx4.setVisibility(View.VISIBLE);
                        mTextView_xx4.setText(mMStudyCircleList.list.get(i).title);
                        break;
                    case 4:
                        mTextView_xx5.setVisibility(View.VISIBLE);
                        mTextView_xx5.setText(mMStudyCircleList.list.get(i).title);
                        break;
                }
            }
        }
    }
}