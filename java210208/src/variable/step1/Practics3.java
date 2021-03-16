package variable.step1;

import java.util.Scanner;

//두 개의 정수 사이에 있는 3의 배수는 몇개일까요?
public class Practics3 {


	void NumCount(int nNum, int nNum2) {
		int sum = 0;		
		for (int i=nNum; i<=nNum2; i++) {
			if (i % 3 == 0) {
				sum = sum + 1;
				System.out.print(i+"  ");				
			}
		}
		System.out.println("두개의 정수사이에 있는 3의 배수는 "+sum+"개 입니다.");
		
	}

	public static void main(String[] args) {
		System.out.println("두개의 정수사이에 있는 3의 배수는 몇개인지 구하려고 합니다. 첫번째 정수값을 입력하세요.");
		Scanner scan = new Scanner(System.in);
		int nNum = scan.nextInt();
		System.out.println("두개의 정수사이에 있는 3의 배수는 몇개인지 구하려고 합니다. 두번째 정수값을 입력하세요.");
		Scanner scan2 = new Scanner(System.in);
		int nNum2 = scan2.nextInt();
		
		Practics3 NCount = new Practics3();
		NCount.NumCount(nNum, nNum2);
		
	}


}
