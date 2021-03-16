package com.ocjp;


public class ParamTest {
	void effectParam(Param p) {
		p = new Param(); //insert here일때는 얼마일까요?
		p.ival = 500;
		System.out.println("sub ival="+p.ival);
	}
	public static void main(String[] args) {
		//클래스는 반드시 대문자
		Param p = new Param();
		p.ival=100;
		ParamTest PTest = new ParamTest();
		PTest.effectParam(p);
		System.out.println("main ival="+p.ival);
	}

}
