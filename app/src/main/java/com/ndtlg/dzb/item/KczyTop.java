//
//  KczyTop
//
//  Created by DELL on 2018-01-04 10:05:40
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



public class KczyTop extends BaseItem{


	@SuppressLint("InflateParams")
    public static View getView(Context context,ViewGroup parent){
	     LayoutInflater flater = LayoutInflater.from(context);
	     View convertView = flater.inflate(R.layout.item_kczy_top,null);
	     convertView.setTag( new KczyTop(convertView));
	     return convertView;
	}

	public KczyTop(View view){
		this.contentview=view;
		this.context=contentview.getContext();
		initView();
	}
    
    private void initView() {
    	this.contentview.setTag(this);
    	findVMethod();
    }

    private void findVMethod(){


    }

    public void set(String item){

    }
    
    

}