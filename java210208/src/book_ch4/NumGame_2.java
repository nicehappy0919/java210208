package book_ch4;

import java.util.Random;
import java.util.Scanner;

public class NumGame_2 {

	void NGame(int num, int myNum) {
		Scanner scan = new Scanner(System.in);
		for (int i=1; i<=3; i++) {
			if (myNum > num) {
				System.out.println("숫자를 낮춰보세요~!");
				myNum = scan.nextInt();
			}else if(myNum < num) {
				System.out.println("숫자를 높여보세요~!");
				myNum = scan.nextInt();
			}else if(myNum == num) {
				System.out.println("숫자를 맞췄네요~! 축하해요~!");
				break;
			}
		}
		if(myNum != num) {
			System.out.println("당신은 바보~!");
		}
	}
	
	public static void main(String[] args) {
		int myNum = 0;
		Random r = new Random();
		int num = 1;
		num = r.nextInt(10);	//0이 나오는데 어떻게 안나오게?? 나는 1부터 나오게 하고싶은데...
		System.out.println(num);
			
		System.out.println("숫자 맞추기 게임! 1부터10까지 숫자를 입력하세요.");
		Scanner scan = new Scanner(System.in);
		
		myNum = scan.nextInt();		
		//if (scan.hasNextInt()) {
			NumGame_2 Ng = new NumGame_2();
			Ng.NGame(num,myNum);
			
		//}else {
		//	System.out.println("숫자를 입력하세요!!");
		//	return;
		//}
		
	}
	

}
