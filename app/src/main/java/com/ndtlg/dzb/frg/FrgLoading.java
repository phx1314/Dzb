//
//  FrgLoading
//
//  Created by DELL on 2018-01-02 10:42:19
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dzb.frg;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.RelativeLayout;

import com.mdx.framework.activity.IndexAct;
import com.mdx.framework.utility.Helper;
import com.mdx.framework.widget.MImageView;
import com.ndtlg.dzb.R;

import static com.ndtlg.dzb.F.deviceid;


public class FrgLoading extends BaseFrg {

    public RelativeLayout mLinearLayout;
    public MImageView iv_loading;


    @Override
    protected void create(Bundle savedInstanceState) {
        setContentView(R.layout.frg_loading);
        initView();
        loaddata();
    }

    private void initView() {
        findVMethod();
    }

    private void findVMethod() {
        mLinearLayout = (RelativeLayout) findViewById(R.id.mLinearLayout);
        iv_loading = (MImageView) findViewById(R.id.iv_loading);


    }

    public void loaddata() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (TextUtils.isEmpty(deviceid)) {
                    Helper.startActivity(getContext(), FrgShbSr.class, IndexAct.class);
                } else {
                    Helper.startActivity(getContext(), FrgHome.class, IndexAct.class);
                }

                FrgLoading.this.finish();
            }
        }, 2000);
    }


}