//
//  DetailDialog
//
//  Created by DELL on 2018-01-04 13:08:41
//  Copyright (c) DELL All rights reserved.


/**

 */

package com.ndtlg.dzb.item;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.ndtlg.dzb.R;


public class DetailDialog extends BaseItem {
    public TextView mTextView_title;
    public TextView mTextView_content;
    public WebView mWebView;
    public ImageView mImageView_del;
    public Dialog item;

    @SuppressLint("InflateParams")
    public static View getView(Context context, ViewGroup parent) {
        LayoutInflater flater = LayoutInflater.from(context);
        View convertView = flater.inflate(R.layout.item_detail_dialog, null);
        convertView.setTag(new DetailDialog(convertView));
        return convertView;
    }

    public DetailDialog(View view) {
        this.contentview = view;
        this.context = contentview.getContext();
        initView();
    }

    private void initView() {
        this.contentview.setTag(this);
        findVMethod();
    }

    private void findVMethod() {
        mTextView_title = (TextView) contentview.findViewById(R.id.mTextView_title);
        mTextView_content = (TextView) contentview.findViewById(R.id.mTextView_content);
        mWebView = (WebView) contentview.findViewById(R.id.mWebView);
        mImageView_del = (ImageView) contentview.findViewById(R.id.mImageView_del);

        mImageView_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                item.dismiss();
            }
        });
    }

    public void set(Dialog item, String url) {
        this.item = item;

        mWebView.loadUrl(url);
    }


}