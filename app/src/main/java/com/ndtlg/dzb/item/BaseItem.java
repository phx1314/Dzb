//
//  BaseItem
//
//  Created by DELL on 2018-01-03 11:24:49
//  Copyright (c) DELL All rights reserved.


/**
   
*/

package com.ndtlg.dzb.item;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;

public class BaseItem implements OnClickListener {
	protected Context context;
	protected View contentview;

	@Override
	public void onClick(View v) {

	}

	public View findViewById(int id) {
         return this.contentview.findViewById(id);
    }

}

