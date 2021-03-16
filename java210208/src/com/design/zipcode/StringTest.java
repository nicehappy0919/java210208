package com.design.zipcode;

public class StringTest {

	public static void main(String[] args) {
		String sql = "select";
		sql = sql +" empno, ename";
		sql = sql +" from emp";
		sql = sql +" where empno > 7000";
		System.out.println(sql);

		String sql2 = "JAVA";
		sql2.replace('J', 'H');  //==>>원본이 안바뀐다.
		System.out.println(sql2);
		sql2 = sql2.replace('J', 'H');
		System.out.println(sql2); //원본이 안바뀌므로 넣어줘야한다.
	}

}
