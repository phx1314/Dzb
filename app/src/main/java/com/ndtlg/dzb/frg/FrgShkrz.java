//
//  FrgShkrz
//
//  Created by DELL on 2018-01-04 11:34:24
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dzb.frg;

import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mdx.framework.Frame;
import com.ndtlg.dzb.F;
import com.ndtlg.dzb.R;


public class FrgShkrz extends BaseFrg {

    public LinearLayout mLinearLayout;
    public ImageView mImageView_del;
    public TextView mTextView_count;
    private Handler handler = new Handler();
    private Runnable runnable;
    private int times = 10;

    @Override
    protected void create(Bundle savedInstanceState) {
        setContentView(R.layout.frg_shkrz);
        initView();
        loaddata();
    }

    private void initView() {
        findVMethod();
    }

    private void findVMethod() {
        mLinearLayout = (LinearLayout) findViewById(R.id.mLinearLayout);
        mImageView_del = (ImageView) findViewById(R.id.mImageView_del);
        mTextView_count = (TextView) findViewById(R.id.mTextView_count);
        mImageView_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logOut();
            }
        });
        mLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Frame.HANDLES.sentAll("FrgHome", 6, null);
                FrgShkrz.this.finish();
                Frame.HANDLES.sentAll("FrgGrxx", 0, F.getUserId());
            }
        });
    }


    public void loaddata() {
        runnable = new Runnable() {
            @Override
            public void run() {
                if (times > 0) {
                    times--;
                    mTextView_count.setText(times + "");
                    handler.postDelayed(runnable, 1000);
                } else if (times == 0) {
                    logOut();
                }
            }
        };
        handler.post(runnable);
    }

    public void logOut() {
        Frame.HANDLES.sentAll("FrgHome", 5, null);
        FrgShkrz.this.finish();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Frame.HANDLES.sentAll("FrgHome", 5, null);
        }
        return super.onKeyDown(keyCode, event);
    }
}