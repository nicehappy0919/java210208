package book_ch4;

import java.util.Random;
import java.util.Scanner;

public class NumGame {

	public static void main(String[] args) {
		int myNum = 0;
		Random r = new Random();
		int num = r.nextInt(10);
			
		System.out.println("숫자 맞추기 게임! 1부터10까지 숫자를 입력하세요.");
		Scanner scan = new Scanner(System.in);
		
				
		if (scan.hasNextInt()) {
			myNum = scan.nextInt();
			//System.out.println(num);
			for (int i=1; i<=3; i++) {
				if (myNum > num) {
					System.out.println("숫자를 낮춰보세요~!");
					myNum = scan.nextInt();
				}else if(myNum < num) {
					System.out.println("숫자를 높여보세요~!");
					myNum = scan.nextInt();
				}else if(myNum == num) {
					System.out.println("숫자를 맞췄네요~! 축하해요~!");
					return;
				}
			}
		}else {
			System.out.println("숫자를 입력하세요!!");
			return;
		}
		
		if(myNum == num) {
			System.out.println("숫자를 맞췄네요~! 축하해요~!");
			return;
		}else {
			System.out.println("당신은 바보~!");
		}
	}

}
