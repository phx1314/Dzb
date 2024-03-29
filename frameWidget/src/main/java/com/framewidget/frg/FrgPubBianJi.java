//
//  FrgCxFaxian
//
//  Created by Administrator on 2015-04-21 10:29:49
//  Copyright (c) Administrator All rights reserved.

/**

 */

package com.framewidget.frg;

import android.content.Context;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

import com.framewidget.R;
import com.mdx.framework.Frame;
import com.mdx.framework.utility.Helper;
import com.mdx.framework.widget.ActionBar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FrgPubBianJi extends BaseFrg {

    public String from;
    public int EDT = 101;
    public EditText mEditText;
    public String data;
    public String hint;
    public int max;
    public int height;

    @Override
    protected void create(Bundle savedInstanceState) {
        setContentView(R.layout.frg_pub_edt);
        from = getActivity().getIntent().getStringExtra("from");
        EDT = getActivity().getIntent().getIntExtra("EDT", 101);
        data = getActivity().getIntent().getStringExtra("data");
        hint = getActivity().getIntent().getStringExtra("hint");
        max = getActivity().getIntent().getIntExtra("max", 0);
        height = getActivity().getIntent().getIntExtra("height", 0);
        initView();
        loaddata();
    }

    private void initView() {
        mEditText = (EditText) findViewById(R.id.mEditText);

    }

    public void loaddata() {
        if (!TextUtils.isEmpty(hint)) {
            mEditText.setHint("请输入" + hint);
        }
        if (!TextUtils.isEmpty(data)) {
            mEditText.setText(data);
        }
        if (max != 0) {
            mEditText.setMaxEms(max);
        }
        if (height != 0) {
            mEditText.setMinHeight((int) getResources().getDimension(R.dimen.j100dp));
        }
        if (hint.equals("年龄")) {
            mEditText.setInputType(InputType.TYPE_CLASS_NUMBER);
        }
        if (hint.equals("种植面积")) {
            mEditText.setInputType(InputType.TYPE_CLASS_NUMBER);
        }
        if (hint.equals("体重") || hint.equals("身高")) {
            mEditText.setInputType(8194);
        }
    }

    @Override
    public void onClick(View arg0) {
    }

    @Override
    public void setActionBar(ActionBar actionBar, Context context) {
        super.setActionBar(actionBar, context);
        mHeadlayout.setRText("保存");
        mHeadlayout.setTitle(hint);
        mHeadlayout.setRightOnclicker(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (max != 0
                        && mEditText.getText().toString().trim().length() > max) {
                    Helper.toast("请输入小于等于" + max + "位字符", getContext());
                } else if (hint.equals("体重") || hint.equals("身高")) {
                    if (mEditText.getText().toString().trim().equals(".")) {
                        Helper.toast("输入内容格式错误", getContext());
                    } else {
                        FrgPubBianJi.this.finish();
                        Frame.HANDLES.sentAll(from, EDT, mEditText.getText()
                                .toString().trim());
                    }
                } else {
                    FrgPubBianJi.this.finish();
                    Frame.HANDLES.sentAll(from, EDT, mEditText.getText()
                            .toString().trim());
                }
            }
        });
    }

    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }
}