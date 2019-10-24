//
//  FrgHome
//
//  Created by DELL on 2018-01-02 10:42:19
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dzb.frg;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.bean.fx.proto.MIndex;
import com.framewidget.newMenu.OnCheckChange;
import com.framewidget.newMenu.OnPageSelset;
import com.framewidget.newMenu.SlidingFragment;
import com.framewidget.util.AbDateUtil;
import com.mdx.framework.Frame;
import com.mdx.framework.activity.NoTitleAct;
import com.mdx.framework.utility.Helper;
import com.ndtlg.dzb.R;
import com.ndtlg.dzb.model.ModelTime;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.ndtlg.dzb.F.MIndexWeather;
import static com.ndtlg.dzb.F.json2Model;


public class FrgHome extends BaseFrg implements OnPageSelset, OnCheckChange {
    //    http://blog.csdn.net/buaaroid/article/details/51536603
    public LinearLayout mLinearLayout_content;
    public SlidingFragment mSlidingFragment;
    public android.support.v4.app.FragmentManager fragmentManager;
    private Handler mHandler = new Handler();
    private Runnable runnable;
    public boolean isHasXx = false;
    public ModelTime modelTime = new ModelTime();

    @Override
    protected void create(Bundle savedInstanceState) {
        setContentView(R.layout.frg_home);
        initView();
        loaddata();
    }

    @Override
    public void disposeMsg(int type, Object obj) {
        switch (type) {
            case 1:
                mSlidingFragment.goWhere(2);
                Frame.HANDLES.sentAll("FrgBjdt", 1, null);
                break;
            case 2:
                mSlidingFragment.goWhere(1);
                Frame.HANDLES.sentAll("FrgXyxx", 2, null);
                break;
            case 3:
                mSlidingFragment.goWhere(3);
                break;
            case 4:
                mSlidingFragment.goWhere(1);
                Frame.HANDLES.sentAll("FrgXyxx", 1, null);
                break;
            case 5:
                mSlidingFragment.goWhere(0);
                break;
            case 6:
                isHasXx = true;
                mSlidingFragment.goWhere(4);
                isHasXx = false;
                break;
        }
    }

    private void initView() {
        findVMethod();
    }

    private void findVMethod() {
        mLinearLayout_content = (LinearLayout) findViewById(R.id.mLinearLayout_content);

        mSlidingFragment = new SlidingFragment(this);
        fragmentManager = getActivity().getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();
        fragmentTransaction.add(R.id.mLinearLayout_content, mSlidingFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        mSlidingFragment.addContentView(new FrgShouye(), "首页",
                R.drawable.btn_checked_1);
        mSlidingFragment.addContentView(new FrgXyxx(), "校园信息",
                R.drawable.btn_checked_2);
        mSlidingFragment.addContentView(new FrgBjdt(), "班级动态",
                R.drawable.btn_checked_3);
        mSlidingFragment.addContentView(new FrgXxyd(), "学习园地",
                R.drawable.btn_checked_4);
        mSlidingFragment.addContentView(new FrgGrxx(), "个人信息",
                R.drawable.btn_checked_5);
        WindowManager wm = (WindowManager) getContext().getSystemService(
                Context.WINDOW_SERVICE);
        mSlidingFragment.setFadeDegree(0.5f);
        mSlidingFragment.setOffscreenPageLimit(5);
//        DisplayMetrics dm = new DisplayMetrics();
//        dm = getResources().getDisplayMetrics();

//        float density = dm.density;        // 屏幕密度（像素比例：0.75/1.0/1.5/2.0）
//        int densityDPI = dm.densityDpi;     // 屏幕密度（每寸像素：120/160/240/320）
//        Helper.toast("density=" + density + "; densityDPI=" + densityDPI, getContext());
//        Log.e("  DisplayMetrics", "density=" + density + "; densityDPI=" + densityDPI);
    }

    public void loaddata() {
        runnable = new Runnable() {
            @Override
            public void run() {
                Date now = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
                SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy/MM/dd");
                SimpleDateFormat formatter2 = new SimpleDateFormat(
                        "yyyy-MM-dd HH:mm");
                modelTime.time = formatter1.format(now);
                modelTime.week = AbDateUtil.getWeekNumber(formatter2.format(now),
                        "yyyy-MM-dd HH:mm");
                modelTime.time_hour = formatter.format(now);
                Frame.HANDLES.sentAll("FrgShouye,FrgXyxx,FrgBjdt,FrgXxyd", 110, modelTime);
                mHandler.postDelayed(runnable, 3000);
            }
        };
        mHandler.post(runnable);
        loadUrlGet(MIndexWeather);
    }

    @Override
    public void onSuccess(String methodName, String content) {
        modelTime.mMWeather = (MIndex.MWeather) json2Model(content, MIndex.MWeather.class);
    }

    @Override
    public boolean onCheckedChanged(int id, int position) {
        if (position == 4 && !isHasXx) {
            Helper.startActivity(getContext(), FrgShkrz.class, NoTitleAct.class);
            return true;
        }
        if (position < 4) {
            Frame.HANDLES.sentAll("FrgGrxx", 1, null);
        }
        return false;
    }

    @Override
    public boolean OnPageSelseTed(int position) {
        if (position == 4 && !isHasXx) {
            Helper.startActivity(getContext(), FrgShkrz.class, NoTitleAct.class);
            return true;
        }
        if (position < 4) {
            Frame.HANDLES.sentAll("FrgGrxx", 1, null);
        }
        return false;
    }
}