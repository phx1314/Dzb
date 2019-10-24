package com.bean.util;

public enum SexEnum {
	
		MALE("男",1),
		FEMALE("女",2),
		;
		
		private SexEnum(String name, Integer type) {
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
