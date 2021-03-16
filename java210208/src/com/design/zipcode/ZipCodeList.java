package com.design.zipcode;

import java.util.List;
import java.util.Vector;

/*
 * 자료구조 종류
 * 1)List계열
 *  ArrayList - 싱글스레드 안전, 동기화처리 생략, 속도 빠르다.
 *  Vector - 멀티스레드 안전, 동기화 처리, 속도 느린편
 *  :경합이 벌어질때, 다중접속자 처리, 순서, 동기화 처리 해야할때 벡터 선택해야함.
 * 2)Map계열(해시태그)
 * 
 * 3)Set계열(빈도낮음)-집합
 * 
 */


public class ZipCodeList {

	public static void main(String[] args) {
		//꺽쇠 : 제네릭이라고 함. 생성부에는 타입없이 다이아몬드 연산자만 붙임.
		Vector<ZipCodeVO> v = new Vector<>(); //다형성을 누릴 수 없다.
		List<ZipCodeVO> v2 = new Vector<>(); //다형성을 누린다.
		ZipCodeVO zcVO = null;
		ZipCodeVO zcVOs[] = null;
		int i = 0;
		while(i<3) {
			//zcVO.setAddress("서울시 금천구 가산동"); ->인스턴스화 전이라 널
			zcVO = new ZipCodeVO();	
			zcVO.setAddress("서울시 금천구 가산동");//ok address="서울시 금천구 가산동"
			System.out.println("zcVO주소번지 바뀐다. ===>"+zcVO.getAddress());
			v.add(zcVO); //주소번지가 담긴다.(서울시 금천구 가산동 이라는 값이 담기는 것이 아니다.)
			zcVO.setAddress("인천직할시"); //원본이 바뀌는거고 벡터에는 값이 저장되는게 아니고 참조형(주소형)이 저장되므로 45번에서 인천으로 찍힘
			i++;
		}
		for(int x=0;x<v.size();x++) {
			ZipCodeVO zVO = v.get(x);//31번에서 만들어진 VO와는 다른 것이다.
			System.out.println(zVO);//다른 주소번지가 출력이 될것이다.
		}
		zcVOs = new ZipCodeVO[v.size()];//객체배열이 3개 만들어진다.
		System.out.println("배열의 크기는 "+zcVOs.length);//3이 출력됨.
		v.copyInto(zcVOs);//벡터에 담긴 것을 배열에 담아준다.
		for(int y=0;y<zcVOs.length;y++) {
			System.out.println(zcVOs[y]+", "+zcVOs[y].getAddress());//객체배열의 주소번지가 3개 출력된다.
		}
	}

}
