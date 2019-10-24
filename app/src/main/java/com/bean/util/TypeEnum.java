package com.bean.util;


public enum TypeEnum {
	
 	//1通知公告  2校园新闻 
	NOTICE("校园公告 ",1),
	NEWS("校园新闻 ",2),
	CLASSNEWS("班级公告 ",3),
	
	//1班级风采 2班级荣誉
	ALBUM_BJFC("班级风采",1),
	ALBUM_BJRY("班级荣誉",2),
	
	
	
	//1男 2女
	MALE("男",1),
	FEMALE("女",2),
	;
	
	private TypeEnum(String name, Integer type) {
		this.name = name;
		this.type = type;
	}
	private String name;
	private Integer type;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
	public static TypeEnum getByName(String name){
		for(TypeEnum s:  TypeEnum.values()){
			if(s.getName().equals(name)){
				return s;
			}
		}
		return null;
	}
	
	public static TypeEnum getByType(Integer type){
		for(TypeEnum s:  TypeEnum.values()){
			if(s.getType()==type){
				return s;
			}
		}
		return null;
	}
	
	
	 

}
