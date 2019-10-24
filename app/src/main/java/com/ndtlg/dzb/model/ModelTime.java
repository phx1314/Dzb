package com.ndtlg.dzb.model;

import com.bean.fx.proto.MIndex;

import java.io.Serializable;

/**
 * Created by DELL on 2018/1/9.
 */

public class ModelTime implements Serializable {
    public String week;
    public String time;
    public String time_hour;
    public MIndex.MWeather mMWeather;
}
