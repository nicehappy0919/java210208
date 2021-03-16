package variable.step1;

import java.util.Scanner;
/*
 * 연습문제1.
	달의 중력은 지구 중력의 17%에 불과합니다.
	지구에서 몸무게가 100kg인 사람은 달에가면 17kg밖에 안됩니다.
	당신의 몸무게는 달에서 얼마입니까?
	
	몸무게 n은 실수이고 키보드로부터 입력받습니다.
	Scanner클래스를 사용하여 키보드로부터 입력 받을 수 있습니다.

 */
public class ScannerTest {

	public static void main(String[] args) {
		//System.out.println("0보다 큰 정수를 입력하세요.");
		//Scanner scan = new Scanner(System.in);
		//int imsi = scan.nextInt();
		//System.out.println("입력한 값은 "+imsi+" 입니다.");
		
		System.out.println("당신의 몸무게를 입력하세요.");
		Scanner scan = new Scanner(System.in);
		double e_weight = scan.nextInt();
		double m_weight = e_weight * 0.17;
		System.out.println("당신의 몸무게는 달에서는 "+m_weight+"kg 입니다.");

	}

}
