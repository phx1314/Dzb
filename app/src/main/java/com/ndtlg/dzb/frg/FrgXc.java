//
//  FrgXc
//
//  Created by DELL on 2018-01-04 11:00:46
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dzb.frg;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bean.fx.proto.MIndex;
import com.mdx.framework.widget.MImageView;
import com.mdx.framework.widget.MPageListView;
import com.ndtlg.dzb.R;
import com.ndtlg.dzb.ada.AdaXc;

import static com.ndtlg.dzb.F.json2Model;
import static com.ndtlg.dzb.F.mClassStyleDetail;


public class FrgXc extends BaseFrg {

    public RelativeLayout mLinearLayout;
    public ImageView mImageView_gb;
    public TextView mTextView_name;
    public TextView mTextView_num;
    public MImageView mImageView;
    public ImageButton mImageView_top;
    public MPageListView mAListView;
    public ImageButton mImageView_bottom;
    public int position = 1;
    public MIndex.MPhoto mMPhoto;
    public String mid;

    @Override
    protected void create(Bundle savedInstanceState) {
        mid = getActivity().getIntent().getStringExtra("item");
        setContentView(R.layout.frg_xc);
        initView();
        loaddata();
    }

    @Override
    public void disposeMsg(int type, Object obj) {
        switch (type) {
            case 0:
                position = (int) obj + 1;
                ((AdaXc) mAListView.getListAdapter()).refresh(position - 1);
                mImageView.setObj(mMPhoto.list.get(position - 1).img);
                mTextView_num.setText(position + "/" + mMPhoto.list.size());
                break;
        }
    }

    private void initView() {
        findVMethod();
    }

    private void findVMethod() {
        mLinearLayout = (RelativeLayout) findViewById(R.id.mLinearLayout);
        mImageView_gb = (ImageView) findViewById(R.id.mImageView_gb);
        mTextView_name = (TextView) findViewById(R.id.mTextView_name);
        mTextView_num = (TextView) findViewById(R.id.mTextView_num);
        mImageView = (MImageView) findViewById(R.id.mImageView);
        mImageView_top = (ImageButton) findViewById(R.id.mImageView_top);
        mAListView = (MPageListView) findViewById(R.id.mAListView);
        mImageView_bottom = (ImageButton) findViewById(R.id.mImageView_bottom);

        mImageView_gb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FrgXc.this.finish();
            }
        });
        mImageView_top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position > 1) {
                    --position;
                } else {
                    return;
                }
                mAListView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mAListView.smoothScrollToPositionFromTop(position, mAListView.getHeight() / 2);
                        ((AdaXc) mAListView.getListAdapter()).refresh(position - 1);
                        mImageView.setObj(mMPhoto.list.get(position - 1).img);
                        mTextView_num.setText(position + "/" + mMPhoto.list.size());
                    }
                }, 100);

            }
        });
        mImageView_bottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position < mMPhoto.list.size()) {
                    ++position;
                } else {
                    return;
                }
                mAListView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mAListView.smoothScrollToPositionFromTop(position, mAListView.getHeight() / 2);
                        ((AdaXc) mAListView.getListAdapter()).refresh(position - 1);
                        mImageView.setObj(mMPhoto.list.get(position - 1).img);
                        mTextView_num.setText(position + "/" + mMPhoto.list.size());
                    }
                }, 100);

            }
        });
    }

    public void loaddata() {
        mImageView.setRound((int) getContext().getResources().getDimension(R.dimen.j2dp));
        loadGet(mClassStyleDetail + mid, mClassStyleDetail);
    }

    @Override
    public void onSuccess(String methodName, String content) {
        if (methodName.equals(mClassStyleDetail)) {
            mMPhoto = (MIndex.MPhoto) json2Model(content, MIndex.MPhoto.class);
            mTextView_name.setText(mMPhoto.title);
            mTextView_num.setText("1/" + mMPhoto.list.size());
            if (mMPhoto.list.size() > 0) {
                mImageView.setObj(mMPhoto.list.get(0).img);
                mAListView.setAdapter(new AdaXc(getContext(), mMPhoto.list));
            }
        }

    }
}