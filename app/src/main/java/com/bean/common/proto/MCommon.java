//
//  MCommon
//
//  Created by Administrator on 2018-01-02 15:36:36
//  Copyright (c) Administrator All rights reserved.


/**
   
*/

package com.bean.common.proto;

import com.bean.util.JsonData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MCommon {


	/*****  *****/
	public static class MItemList extends JsonData{
		private static final long serialVersionUID = 1L;

		public List<MItem > list=new ArrayList<MItem > (); //评比项目

		public MItemList() throws Exception {
		}

		public List<MItem> getList() {
			return list;
		}

		public void setList(List<MItem> list) {
			this.list = list;
		}
	}

	/*****  *****/
	public static class MItem extends JsonData{
		private static final long serialVersionUID = 1L;

		public String mid; //id
		public String time; //时间节点
		public String info; //项目

		public MItem() throws Exception {
		}

		public String getMid() {
			return mid;
		}

		public void setMid(String mid) {
			this.mid = mid;
		}

		public String getTime() {
			return time;
		}

		public void setTime(String time) {
			this.time = time;
		}

		public String getInfo() {
			return info;
		}

		public void setInfo(String info) {
			this.info = info;
		}

	}

	/*****  *****/
	public static class MSectionList extends JsonData{
		private static final long serialVersionUID = 1L;

		public List<MSectionMap > list=new ArrayList<MSectionMap > ();

		public MSectionList() throws Exception {
		}

		public List<MSectionMap> getList() {
			return list;
		}

		public void setList(List<MSectionMap> list) {
			this.list = list;
		}

	}

	/*****  *****/
	public static class MRet extends JsonData{
		private static final long serialVersionUID = 1L;

		public int code; //返回类型
		public String msg; //返回值

		public MRet() throws Exception {
		}

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

	}

	/*****  *****/
	public static class MClassInfo extends JsonData{
		private static final long serialVersionUID = 1L;

		public String mid; //id
		public String name; //班级名字
		public String leaderTeacher; //班主任
		public List<MTeacher > teachers=new ArrayList<MTeacher > (); //任课老师
		public List<MStudent > students=new ArrayList<MStudent > (); //学生花名册

		public MClassInfo() throws Exception {
		}

		public String getMid() {
			return mid;
		}

		public void setMid(String mid) {
			this.mid = mid;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getLeaderTeacher() {
			return leaderTeacher;
		}

		public void setLeaderTeacher(String leaderTeacher) {
			this.leaderTeacher = leaderTeacher;
		}

		public List<MTeacher> getTeachers() {
			return teachers;
		}

		public void setTeachers(List<MTeacher> teachers) {
			this.teachers = teachers;
		}

		public List<MStudent> getStudents() {
			return students;
		}

		public void setStudents(List<MStudent> students) {
			this.students = students;
		}
		public void addTeacher(MTeacher t){
			this.teachers.add(t);
		}
		public void addStudents(MStudent t){
			this.students.add(t);
		}

	}
	
	/*****  *****/
	public static class MClassSimple extends JsonData implements Comparable<MClassSimple>{
		private static final long serialVersionUID = 1L;

		public String mid; //id
		public String name; //班级名字
		public String leaderTeacher; //班主任
		public int rank; //排名
		public int isSelf; //是否本班 1是
		public Float total; //总分

		
		
		public Float getTotal() {
			return total;
		}

		public void setTotal(Float total) {
			this.total = total;
		}

		public MClassSimple() throws Exception {
		}

		public String getMid() {
			return mid;
		}

		public void setMid(String mid) {
			this.mid = mid;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getLeaderTeacher() {
			return leaderTeacher;
		}

		public void setLeaderTeacher(String leaderTeacher) {
			this.leaderTeacher = leaderTeacher;
		}

		public int getRank() {
			return rank;
		}

		public void setRank(int rank) {
			this.rank = rank;
		}

		public int getIsSelf() {
			return isSelf;
		}

		public void setIsSelf(int isSelf) {
			this.isSelf = isSelf;
		}

		@Override
		public int compareTo(MClassSimple o1) {
			// TODO Auto-generated method stub
			return o1.getTotal().compareTo(this.total);
		}

	}

	/*****  *****/
	public static class MStudent extends JsonData{
		private static final long serialVersionUID = 1L;

		public String mid; //id
		public String name; //姓名
		public String degree; //职务
		public String code; //学号

		public MStudent() throws Exception {
		}

		public String getMid() {
			return mid;
		}

		public void setMid(String mid) {
			this.mid = mid;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDegree() {
			return degree;
		}

		public void setDegree(String degree) {
			this.degree = degree;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

	}

	/*****  *****/
	public static class MFile extends JsonData{
		private static final long serialVersionUID = 1L;

		public byte[] file; //文件
		public String fileName; //文件名

		public MFile() throws Exception {
		}

		public byte[] getFile() {
			return file;
		}


		public void setFile(byte[] file) {
			this.file = file;
		}



		public String getFileName() {
			return fileName;
		}

		public void setFileName(String fileName) {
			this.fileName = fileName;
		}

	}

	/*****  *****/
	public static class MWeekCourse extends JsonData{
		private static final long serialVersionUID = 1L;

		public String mid; //id
		public String name; //课程
		public String teacher; //老师
		public String week;

		public MWeekCourse() throws Exception {
		}

		public String getMid() {
			return mid;
		}

		public void setMid(String mid) {
			this.mid = mid;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getTeacher() {
			return teacher;
		}

		public void setTeacher(String teacher) {
			this.teacher = teacher;
		}

		public String getWeek() {
			return week;
		}

		public void setWeek(String week) {
			this.week = week;
		}

		 

	}

	/*****  *****/
	public static class MTeacher extends JsonData{
		private static final long serialVersionUID = 1L;

		public String mid; //id
		public String name; //姓名
		public String course; //课程
		public int isLead; //是否班主任

		public MTeacher() throws Exception {
		}

		public String getMid() {
			return mid;
		}

		public void setMid(String mid) {
			this.mid = mid;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCourse() {
			return course;
		}

		public void setCourse(String course) {
			this.course = course;
		}

		public int getIsLead() {
			return isLead;
		}

		public void setIsLead(int isLead) {
			this.isLead = isLead;
		}

		 
	}

	/*****  *****/
	public static class MUserInfo extends JsonData{
		private static final long serialVersionUID = 1L;

		public String mid; //id
		public String code; //学号
		public String birthday; //生日
		public String sex; //性别
		public String phone; //手机号
		public String degree; //职务
		public String address; //籍贯
		public String department; //班级 部门
		public String nations; //民族
		public String name; //姓名
		public String headimg; //头像

		public MUserInfo() throws Exception {
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getHeadimg() {
			return headimg;
		}

		public void setHeadimg(String headimg) {
			this.headimg = headimg;
		}

		public String getMid() {
			return mid;
		}

		public void setMid(String mid) {
			this.mid = mid;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getBirthday() {
			return birthday;
		}

		public void setBirthday(String birthday) {
			this.birthday = birthday;
		}

		public String getSex() {
			return sex;
		}

		public void setSex(String sex) {
			this.sex = sex;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getDegree() {
			return degree;
		}

		public void setDegree(String degree) {
			this.degree = degree;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getDepartment() {
			return department;
		}

		public void setDepartment(String department) {
			this.department = department;
		}

		public String getNations() {
			return nations;
		}

		public void setNations(String nations) {
			this.nations = nations;
		}

	 
	}

	/*****  *****/
	public static class MSection extends JsonData{
		private static final long serialVersionUID = 1L;

		public String mid; //id
		public String time; //时间节点
		public List<MWeekCourse > list=new ArrayList<MWeekCourse > (); //课程列表

		public MSection() throws Exception {
		}

		public String getMid() {
			return mid;
		}

		public void setMid(String mid) {
			this.mid = mid;
		}

		public String getTime() {
			return time;
		}

		public void setTime(String time) {
			this.time = time;
		}

		public List<MWeekCourse> getList() {
			return list;
		}

		public void setList(List<MWeekCourse> list) {
			this.list = list;
		}

		 

	}

	
	/*****  *****/
	public static class MSectionMap extends JsonData{
		private static final long serialVersionUID = 1L;

		public String mid; //id
		public String time; //时间节点
		//key 是 week+"_"+节次ID
		public Map<String, MWeekCourse> sectMap = new HashMap<String, MWeekCourse>();

		public MSectionMap() throws Exception {
		}

		public String getMid() {
			return mid;
		}

		public void setMid(String mid) {
			this.mid = mid;
		}

		public String getTime() {
			return time;
		}

		public void setTime(String time) {
			this.time = time;
		}

		public Map<String, MWeekCourse> getSectMap() {
			return sectMap;
		}

		public void setSectMap(Map<String, MWeekCourse> sectMap) {
			this.sectMap = sectMap;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		 

		 

	}
	
	/*****  *****/
	public static class MFileList extends JsonData{
		private static final long serialVersionUID = 1L;

		public List<MFile > file=new ArrayList<MFile > ();

		public MFileList() throws Exception {
		}

		public List<MFile> getFile() {
			return file;
		}

		public void setFile(List<MFile> file) {
			this.file = file;
		}

	}

	/*****  *****/
	public static class MSysParams extends JsonData{
		private static final long serialVersionUID = 1L;

		public String param1; //预留类
		public String param2;
		public String param3;
		public String param4;
		public String param5;
		public String param6;
		public String param7;
		public String param8;
		public String param9;
		public String param10;

		public MSysParams() throws Exception {
		}

		public String getParam1() {
			return param1;
		}

		public void setParam1(String param1) {
			this.param1 = param1;
		}

		public String getParam2() {
			return param2;
		}

		public void setParam2(String param2) {
			this.param2 = param2;
		}

		public String getParam3() {
			return param3;
		}

		public void setParam3(String param3) {
			this.param3 = param3;
		}

		public String getParam4() {
			return param4;
		}

		public void setParam4(String param4) {
			this.param4 = param4;
		}

		public String getParam5() {
			return param5;
		}

		public void setParam5(String param5) {
			this.param5 = param5;
		}

		public String getParam6() {
			return param6;
		}

		public void setParam6(String param6) {
			this.param6 = param6;
		}

		public String getParam7() {
			return param7;
		}

		public void setParam7(String param7) {
			this.param7 = param7;
		}

		public String getParam8() {
			return param8;
		}

		public void setParam8(String param8) {
			this.param8 = param8;
		}

		public String getParam9() {
			return param9;
		}

		public void setParam9(String param9) {
			this.param9 = param9;
		}

		public String getParam10() {
			return param10;
		}

		public void setParam10(String param10) {
			this.param10 = param10;
		}

		 

	}
	
	
	
	public static class MMoralScoreMap  extends JsonData{
		private static final long serialVersionUID = 1L;

		public List<MItem> items = new ArrayList<MItem>(); //评比项目
		public List<MClassSimple> cls = new ArrayList<MClassSimple>(); //评比班级
		//key是 项目id+'_'+班级id
		public Map<String, Float> scoreMap = new HashMap<String, Float>();
		
		public String time;//评比时间
	 
		public MMoralScoreMap() throws Exception {
		}

		public List<MItem> getItems() {
			return items;
		}

		public void setItems(List<MItem> items) {
			this.items = items;
		}

		public List<MClassSimple> getCls() {
			return cls;
		}

		public void setCls(List<MClassSimple> cls) {
			this.cls = cls;
		}

		public Map<String, Float> getScoreMap() {
			return scoreMap;
		}

		public void setScoreMap(Map<String, Float> scoreMap) {
			this.scoreMap = scoreMap;
		}

		public String getTime() {
			return time;
		}

		public void setTime(String time) {
			this.time = time;
		}
		public void addItems(MItem item){
			this.items.add(item);
		}
		public void addCls(MClassSimple info){
			this.cls.add(info);
		}

	}


}
