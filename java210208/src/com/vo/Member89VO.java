package com.vo;

public class Member89VO {
//ctrl+shift+y 누르면 소문자로 바뀜
	private String  mem_pw  = null; //비번담기
	private boolean gender  = false; //성별담기
	private String  mem_id  = null; //아이디담기
	/*
	 * 생성자는 반환타입이 없다. void같은 것을 넣으면 생성자가 아니라 메소드가 된다.
	 * 클래스 이름과 동일해야함.
	 * 전역변수의 초기화 담당한다.
	 * static블럭에서 하는 일을 맡겨도 괜찮아.
	 * 만일 소켓통신을 통해서 서버사이드와 클라이언트 사이트 구현(구축)할 때 초기화에대한 부분은 중요하다.
	 * 
	 * 메소드 오버로딩 규칙
	 * 전제조건 - 모두 같은 이름이다. 다른 이름이라면 해당 없다.
	 * 접근제한자가 있고 없고 영향 없다.
	 * 리턴타입이 있고 없고 영향 없다. -생성자는 해당 없음.
	 * 예외를 던지고 그렇지 않고는 영향이 없다.
	 * void go() throws Exception, SQLException{}

	 */
	public Member89VO() {} //디폴트 생성자
	public Member89VO(String mem_id) { //파라미터가 있는 생성자
		this.mem_id = mem_id;
	}
	public Member89VO(String mem_id, String mem_pw) { //파라미터가 있는 생성자
		this.mem_id = mem_id;
		this.mem_pw = mem_pw;
	}
	public Member89VO(String mem_id, String mem_pw, boolean gender) { //파라미터가 있는 생성자
		this.mem_id = mem_id;
		this.mem_pw = mem_pw;
		this.gender = gender;
	}
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
}   
