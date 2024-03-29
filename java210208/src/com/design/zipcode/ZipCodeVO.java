package com.design.zipcode;

public class ZipCodeVO {
	private int    uid_no    = 0;   //유니크한 순번
	private int    zipcode   = 0;//우편버노
	private String zdo       = null;//시도
	private String sigu      = null;//시구
	private String dong      = null;//동 -Like패턴으로 구간검색시 사용할 컬럼명임.
	private String ri        = null;//리
	private String bungi     = null;//번지
	private String aptname   = null;//아파트이름
	private String upd_date  = null;//수정날짜
	private String address   = null;//주소
	public ZipCodeVO() {}
	public ZipCodeVO(int uid_no, int zipcode, String zdo, String sigu, String dong, String ri,String bungi
            		,String aptname, String upd_date, String address) {}
	public int getUid_no() {
		return uid_no;
	}
	public void setUid_no(int uid_no) {
		this.uid_no = uid_no;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	public String getZdo() {
		return zdo;
	}
	public void setZdo(String zdo) {
		this.zdo = zdo;
	}
	public String getSigu() {
		return sigu;
	}
	public void setSigu(String sigu) {
		this.sigu = sigu;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getRi() {
		return ri;
	}
	public void setRi(String ri) {
		this.ri = ri;
	}
	public String getBungi() {
		return bungi;
	}
	public void setBungi(String bungi) {
		this.bungi = bungi;
	}
	public String getAptname() {
		return aptname;
	}
	public void setAptname(String aptname) {
		this.aptname = aptname;
	}
	public String getUpd_date() {
		return upd_date;
	}
	public void setUpd_date(String upd_date) {
		this.upd_date = upd_date;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
