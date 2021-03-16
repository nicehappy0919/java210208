package variable.step1;

import java.util.Scanner;

public class Practics2 {
	/*
	 * 연습문제2.
		1부터 N까지의 정수 합계를 구하는 프로그램을 작성하시오. (반복문 사용)
		출력)정수(n>0):100
		합계(1~n):5050출력 정답

	 */
	void Hap(int eNum) {
		int sum = 0;
		
		for ( int i=1; i<=eNum; i++) {
			sum = sum + i;
		}
		System.out.println("1부터 n까지의 정수의 합은 "+sum+" 입니다.");

	}
	
	public static void main(String[] args) {
		System.out.println("1부터 n까지의 정수의 합계를 구하려 합니다. n값을 입력하세요.");
		Scanner scan2 = new Scanner(System.in);
		int nNum = scan2.nextInt();
		
		Practics2 NHap = new Practics2();
		NHap.Hap(nNum);
		/*
		int sum = 0;
		
		for ( int i=1; i<=nNum; i++) {
					sum = sum + i;
		}
		System.out.println("1부터 n까지의 정수의 합은 "+sum+" 입니다.");
		*/

	}

}
