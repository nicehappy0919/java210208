package variable.step1;

import java.util.Scanner;

public class Practics1 {
/*
 * 에러에는 두가지가 있다.
 * 하나는 컴파일 타임 에러이고 - 문법에러이고...
 * 두번째는 런타임 에러이다. - 실행 오류(논리의 오류이다)
 */
	void MoonWeight(double e_weight) {
		double m_weight = e_weight * 0.17;
		System.out.println("당신의 몸무게는 달에서는 "+m_weight+"kg 입니다.");
	}

	
	public static void main(String[] args) {			
		System.out.println("당신의 몸무게를 입력하세요.");
		//시스템(내가 사용하고 있는 컴터)에서 in(입력장치로부터)
		Scanner scan = new Scanner(System.in);
		double e_weight = scan.nextDouble();
		
		Practics1 MWeight = new Practics1();
		MWeight.MoonWeight(e_weight);


	}


}
