package com.vo;

public class Meber89VO {
//ctrl+shift+y 누르면 소문자로 바뀜
	private String  mem_pw  = null; //비번담기
	public String getMem_pw() {
		return mem_pw;
	}
	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}
	//public boolean getGender() {
	//	return gender;
	//} // 이렇게 써도 된다.
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	private boolean gender  = null; //성별담기
	private String  mem_id  = null; //아이디담기
}   
