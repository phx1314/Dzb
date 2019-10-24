//
//  BaseFrg
//
//  Created by DELL on 2018-01-02 10:42:19
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dzb.frg;

import android.os.Bundle;
import android.view.View;

import com.ab.http.HttpUtil;
import com.ab.util.HttpResponseListener;
import com.ab.util.HttpResponseListenerSon;
import com.mdx.framework.activity.MActivityActionbar;
import com.mdx.framework.activity.MFragment;

public abstract class BaseFrg extends MFragment implements View.OnClickListener, HttpResponseListenerSon {

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onFinish() {

    }

    @Override
    public void onFailure(int statusCode, String content, Throwable error) {

    }

    @Override
    public void onSuccess(String methodName, String content) {

    }

    public void loadUrlGet(String methodName, Object... mparams) {
        HttpUtil.loadUrl(getContext(), "GET", methodName, new HttpResponseListener(getContext(), this, methodName), mparams);
    }

    public void loadGet(String methodName, String methodNameBiaoShi, Object... mparams) {
        HttpUtil.loadUrl(getContext(), "GET", methodName, new HttpResponseListener(getContext(), this, methodNameBiaoShi), mparams);
    }

    @Override
    protected void initcreate(Bundle savedInstanceState) {
        super.initcreate(savedInstanceState);
        ((MActivityActionbar) getActivity()).setSwipeBackEnable(false);
    }
}
