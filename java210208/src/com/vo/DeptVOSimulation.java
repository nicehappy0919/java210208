package com.vo;

public class DeptVOSimulation {
	void methodB() { //반환값이 전혀 역할 을 못함.
		
	}
	DeptVO methodA() { //반환값이 3가지가 가능함.
		return new DeptVO();
	}
	DeptVO[] methodC() { //반환값이 3가지 종류에 대해서 n개 로우까지도 가능함.
		return new DeptVO[3];
	}
	
	public static void main(String[] args) {
		DeptVO dvo = new DeptVO();
		//insert here - 부서번호 30을 출력하도록 코드를 추가하시오.
		dvo.setDeptno(30); //생성자로 처리해보시오. 1-2 API활용능력
		int myDeptNo = dvo.getDeptno();
		
		String myDname  = dvo.getDname(); //null
		String myLoc    = dvo.getLoc(); //null
		System.out.println(myDeptNo);

		dvo = new DeptVO();
		dvo.setDeptno(300);
		myDeptNo = dvo.getDeptno();
		System.out.println(myDeptNo);

		dvo = new DeptVO();
		dvo.setDeptno(7000);
		myDeptNo = dvo.getDeptno();
		System.out.println(myDeptNo);

	}

}
