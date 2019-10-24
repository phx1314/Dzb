package com.ab.util;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;

import com.ab.http.AbStringHttpResponseListener;
import com.mdx.framework.log.MLog;
import com.mdx.framework.utility.Helper;

import org.json.JSONObject;

import static com.framewidget.F.createLoadingDialog;

/**
 * Created by DELL on 2017/3/29.
 */

public class HttpResponseListener extends AbStringHttpResponseListener {
    public String methodName;
    public String methodClassName;
    public boolean isShow = true;
    public Context context;
    public HttpResponseListenerSon mHttpResponseListenerSon;
    public Dialog dialog;

    public HttpResponseListener(Context context, HttpResponseListenerSon mHttpResponseListenerSon, String methodName) {
        this.methodName = methodName;
        this.mHttpResponseListenerSon = mHttpResponseListenerSon;
        this.context = context;
        dialog = createLoadingDialog(context, "数据加载中...");
    }


    public HttpResponseListener(Context context, HttpResponseListenerSon mHttpResponseListenerSon, String methodName, boolean isShow) {
        this.context = context;
        this.mHttpResponseListenerSon = mHttpResponseListenerSon;
        this.methodName = methodName;
        this.isShow = isShow;
        dialog = createLoadingDialog(context, "数据加载中...");
    }

    @Override
    public void onStart() {
        try {
            if (isShow) {
                dialog.show();
            }
            if (mHttpResponseListenerSon != null)
                mHttpResponseListenerSon.onStart();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onFinish() {
        try {
            dialog.dismiss();
            if (mHttpResponseListenerSon != null)
                mHttpResponseListenerSon.onFinish();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFailure(int statusCode, String content, Throwable error) {
        try {
            Helper.toast("请求服务器失败", context);
            MLog.D("请求服务器失败方法名：" + methodName);
            dialog.dismiss();
            if (mHttpResponseListenerSon != null)
                mHttpResponseListenerSon.onFailure(statusCode, content, error);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onSuccess(int statusCode, String content) {
        try {
            dialog.dismiss();
            MLog.I(content);
//            if (!TextUtils.isEmpty(DES.decryptDES(content, key))) {
//                JSONObject mJSONObject = new JSONObject(DES.decryptDES(content, key));
//                if (mJSONObject.has("code") && mJSONObject.getString("code").equals("300000")) {
//                    F.mCallBackOnly.goLogin();
//                    return;
//                }
//                if (mJSONObject.has("code") && !mJSONObject.getString("code").equals("000000")) {
//                    Helper.toast(mJSONObject.getString("message"), context);
//                    return;
//                }
//            }
            if (mHttpResponseListenerSon != null) {
                if (!TextUtils.isEmpty(content)) {
                    JSONObject mJSONObject = new JSONObject(content);
                    if (mJSONObject.has("data")) {
                        mHttpResponseListenerSon.onSuccess(methodName, mJSONObject.getString("data"));
                    } else {
                        Helper.toast(mJSONObject.getString("msg"), context);
                    }
//                    if (mJSONObject.has("code") && mJSONObject.getString("code").equals("300000")) {
//                        F.mCallBackOnly.goLogin();
//                        return;
//                    }
                }

            }
//            if (!TextUtils.isEmpty(content)) {
//                JSONObject mJSONObject = new JSONObject(content);
//                if (mJSONObject.has("code") && !mJSONObject.getString("code").equals("000000")) {
//                    Helper.toast(mJSONObject.getString("message"), context);
//                    return;
//                }
//            }
//            if (mHttpResponseListenerSon != null) {
//                mHttpResponseListenerSon.onSuccess(methodName, content);
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
