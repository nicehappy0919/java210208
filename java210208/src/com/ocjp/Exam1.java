package com.ocjp;
/*
 *  ++ㅑ는 i=i+1;과 같다.
 *  --i는 i=i-1;과 같다.
 *  i++는 후위 연산자 이므로 먼저 비교하고 나중에 1을 증가시킴.
 *  ++ㅑ 전위 연산자이다.
 */

public class Exam1 {

	public static void main(String[] args) {
		int i = 1;
		int j = 2;
		if((++i>j--)&(++i>j)) { //2>2 F ㅓ=1 & 3>1 T
		//if((++i>j--)|(++i>j)) {
			//실행되는가?
			System.out.println("if문이 실행 되었어요!");
		}else {
			//실행되나?
			System.out.println("else문이 실행 되었어요");
			System.out.println(i+", "+j); //concat 붙여쓰기 3 1
		}
		//변수 초기화가 있을 때와 없을때 차이가 있습니까?
		i = 1;
		j = 2;
		//2>2
		if((++i>j--)&&(++i>j)) { //4>1&&5>0
		//if((++i>j--)||(++i>j)) {
			System.out.println("if문이 실행 되었어요!");
			System.out.println(i+", "+j); //concat 붙여쓰기5 0
		}else {
			System.out.println("else문이 실행 되었어요");
		}

	}

}
