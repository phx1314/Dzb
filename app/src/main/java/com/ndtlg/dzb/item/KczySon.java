//
//  KczySon
//
//  Created by DELL on 2018-01-04 10:16:48
//  Copyright (c) DELL All rights reserved.


/**
   
*/

package com.ndtlg.dzb.item;

import com.ndtlg.dzb.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import android.view.View;
import android.widget.TextView;



public class KczySon extends BaseItem{
    public TextView mTextView;


	@SuppressLint("InflateParams")
    public static View getView(Context context,ViewGroup parent){
	     LayoutInflater flater = LayoutInflater.from(context);
	     View convertView = flater.inflate(R.layout.item_kczy_son,null);
	     convertView.setTag( new KczySon(convertView));
	     return convertView;
	}

	public KczySon(View view){
		this.contentview=view;
		this.context=contentview.getContext();
		initView();
	}
    
    private void initView() {
    	this.contentview.setTag(this);
    	findVMethod();
    }

    private void findVMethod(){
        mTextView=(TextView)contentview.findViewById(R.id.mTextView);


    }

    public void set(String item){

    }
    
    

}