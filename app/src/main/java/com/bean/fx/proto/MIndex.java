//
//  MIndex
//
//  Created by Administrator on 2018-01-02 15:36:36
//  Copyright (c) Administrator All rights reserved.


/**
   
*/

package com.bean.fx.proto;

import com.bean.util.JsonData;

import java.util.ArrayList;
import java.util.List;


public class MIndex {


	/*****  *****/
	public static class MNews extends JsonData{
		private static final long serialVersionUID = 1L;

		public String mid; //id
		public String title; //标题
		public String info; //描述或 发布人
		public String img; //图片
		public String content; //详情 url
		public String time; //时间

		public MNews() throws Exception {
		}

		public String getMid() {
			return mid;
		}

		public void setMid(String mid) {
			this.mid = mid;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getInfo() {
			return info;
		}

		public void setInfo(String info) {
			this.info = info;
		}

		public String getImg() {
			return img;
		}

		public void setImg(String img) {
			this.img = img;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public String getTime() {
			return time;
		}

		public void setTime(String time) {
			this.time = time;
		}

		 

	}

	/*****  *****/
	public static class MIndexClassList extends JsonData{
		private static final long serialVersionUID = 1L;

		public List<MIndexClass > list=new ArrayList<MIndexClass > ();

		public MIndexClassList() throws Exception {
		}

		public List<MIndexClass> getList() {
			return list;
		}

		public void setList(List<MIndexClass> list) {
			this.list = list;
		}

		 public void addList(MIndexClass cls){
			 this.list.add(cls);
		 }

	}

	/*****  *****/
	public static class MNewsList extends JsonData{
		private static final long serialVersionUID = 1L;

		public List<MNews > list=new ArrayList<MNews > ();

		public MNewsList() throws Exception {
		}

		public List<MNews> getList() {
			return list;
		}

		public void setList(List<MNews> list) {
			this.list = list;
		}
 

	}
	
	

	/*****  *****/
	public static class MImg extends JsonData{
		private static final long serialVersionUID = 1L;

		public String mid; //id
		public String img; //图
		public int redirectType; //0:不跳转 1:url
		public String redirectContent; //跳转内容 id,url等
		public String info; //说明

		public MImg() throws Exception {
		}

		public String getMid() {
			return mid;
		}

		public void setMid(String mid) {
			this.mid = mid;
		}

		public String getImg() {
			return img;
		}

		public void setImg(String img) {
			this.img = img;
		}

		public int getRedirectType() {
			return redirectType;
		}

		public void setRedirectType(int redirectType) {
			this.redirectType = redirectType;
		}

		public String getRedirectContent() {
			return redirectContent;
		}

		public void setRedirectContent(String redirectContent) {
			this.redirectContent = redirectContent;
		}

		public String getInfo() {
			return info;
		}

		public void setInfo(String info) {
			this.info = info;
		}

		 

	}
	
	
	
	/*****  *****/
	public static class MWeather extends JsonData{
		private static final long serialVersionUID = 1L;

		public String mid; //id
		public String img; //天气图
		public String info; //天气描述
		public String temperature; //温度 xx℃
		public String wind; //风力

		public MWeather() throws Exception {
		}

		public String getMid() {
			return mid;
		}

		public void setMid(String mid) {
			this.mid = mid;
		}

		public String getImg() {
			return img;
		}

		public void setImg(String img) {
			this.img = img;
		}

		public String getInfo() {
			return info;
		}

		public void setInfo(String info) {
			this.info = info;
		}

		public String getTemperature() {
			return temperature;
		}

		public void setTemperature(String temperature) {
			this.temperature = temperature;
		}

		public String getWind() {
			return wind;
		}

		public void setWind(String wind) {
			this.wind = wind;
		}

		 

		 

	}

	/*****  *****/
	public static class MIndexClass extends JsonData{
		private static final long serialVersionUID = 1L;

		public String mid; //id
		public String today; //今日课程
		public String tomorrow; //明天课程
		public int isOut; //是否走班 1是 0否

		public MIndexClass() throws Exception {
		}

		public String getMid() {
			return mid;
		}

		public void setMid(String mid) {
			this.mid = mid;
		}

		public String getToday() {
			return today;
		}

		public void setToday(String today) {
			this.today = today;
		}

		public String getTomorrow() {
			return tomorrow;
		}

		public void setTomorrow(String tomorrow) {
			this.tomorrow = tomorrow;
		}

		public int getIsOut() {
			return isOut;
		}

		public void setIsOut(int isOut) {
			this.isOut = isOut;
		}

		 
	}

	/*****  *****/
	public static class MStudyCircle extends JsonData{
		private static final long serialVersionUID = 1L;

		public String mid; //id
		public String title; //标题
		public String catecode; //学科
		public String content; //内容
		public String teachername; //老师名字
		public String time; //时间

		public MStudyCircle() throws Exception {
		}

		public String getMid() {
			return mid;
		}

		public void setMid(String mid) {
			this.mid = mid;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getCatecode() {
			return catecode;
		}

		public void setCatecode(String catecode) {
			this.catecode = catecode;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public String getTeachername() {
			return teachername;
		}

		public void setTeachername(String teachername) {
			this.teachername = teachername;
		}

		public String getTime() {
			return time;
		}

		public void setTime(String time) {
			this.time = time;
		}

	}

	/*****  *****/
	public static class MPhoto extends JsonData{
		private static final long serialVersionUID = 1L;

		public String title; //相册标题
		public String img; //封面
		public String time; //时间
		public int cnt; //照片数量
		public List<MImg > list=new ArrayList<MImg > (); //详情接口返回
		public String info; //说明 （班级）
		public String mid; //相册id

		public MPhoto() throws Exception {
		}

		
		public String getMid() {
			return mid;
		}


		public void setMid(String mid) {
			this.mid = mid;
		}


		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getImg() {
			return img;
		}

		public void setImg(String img) {
			this.img = img;
		}

		public String getTime() {
			return time;
		}

		public void setTime(String time) {
			this.time = time;
		}

		public int getCnt() {
			return cnt;
		}

		public void setCnt(int cnt) {
			this.cnt = cnt;
		}

		public List<MImg> getList() {
			return list;
		}

		public void setList(List<MImg> list) {
			this.list = list;
		}

		public String getInfo() {
			return info;
		}

		public void setInfo(String info) {
			this.info = info;
		}

		
		public void addList(MImg img){
			if(img!=null) this.list.add(img);
		}

	}

	/*****  *****/
	public static class MCategory extends JsonData{
		private static final long serialVersionUID = 1L;

		public String mid; //id
		public String title; //名称

		public MCategory() throws Exception {
		}

		public String getMid() {
			return mid;
		}

		public void setMid(String mid) {
			this.mid = mid;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		 
	}

	/*****  *****/
	public static class MCategoryList extends JsonData{
		private static final long serialVersionUID = 1L;

		public List<MCategory > list=new ArrayList<MCategory > ();

		public MCategoryList() throws Exception {
		}

		public List<MCategory> getList() {
			return list;
		}

		public void setList(List<MCategory> list) {
			this.list = list;
		}
		public void addList(MCategory cls){
			 this.list.add(cls);
		 }
		 

	}

	/*****  *****/
	public static class MPhotoList extends JsonData{
		private static final long serialVersionUID = 1L;

		public List<MPhoto > list=new ArrayList<MPhoto > ();

		public MPhotoList() throws Exception {
		}

		public List<MPhoto> getList() {
			return list;
		}

		public void setList(List<MPhoto> list) {
			this.list = list;
		}
		 public void addList(MPhoto cls){
			 this.list.add(cls);
		 }
 
	}

	/*****  *****/
	public static class MStudyCircleList extends JsonData{
		private static final long serialVersionUID = 1L;

		public List<MStudyCircle > list=new ArrayList<MStudyCircle > ();

		public MStudyCircleList() throws Exception {
		}

		public List<MStudyCircle> getList() {
			return list;
		}

		public void setList(List<MStudyCircle> list) {
			this.list = list;
		}
		 public void addList(MStudyCircle cls){
			 this.list.add(cls);
		 }

	}


}
