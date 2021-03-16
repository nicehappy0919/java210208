package book_ch7;

import java.util.Random;
import java.util.Scanner;

//야구게임 만들기
public class BaseballGame {
   //숫자 비교하기
   void Same (int[] num, int[] myNum) {
      int strikeNum = 0; //스트라이크 숫자 담을 변수
      int ballNum = 0; //볼 숫자 담을 변수
      
      //숫자와 자리룰 비교해서 둘다 같으면 스트라이크, 숫자는 같고 자리가 다르면 볼의 갯수를 늘려준다.
      for (int i=0;i<num.length;i++) {
         for(int j=0;j<myNum.length;j++) {
            if (num[i] == myNum[j]) {
               if (i == j) {
                  strikeNum++;
               }else if (i != j) {
                  ballNum++;
               }
            }
         }
      }
      System.out.println(strikeNum+"스트라이크, "+ballNum+"볼 입니다.");
   }
   public static void main(String[] args) {
      int num[] = new int[3];
      int myNum[] = new int[3];
      Scanner sc = new Scanner(System.in);
      //임의의 숫가 3개를 생성하기
      Random r = new Random();
      //프로그램이 잘 돌아가는지 확인하기 위해 랜덤값을 출력해보기 나중에 주석처리
      for (int i=0;i<num.length;i++) {
         num[i] = r.nextInt(10);
         System.out.println("랜덤값"+num[i]);
      }
      //3개의 숫자 입력받기
      for (int j=0;j<myNum.length;j++) {
         System.out.println("0~9까지 숫자를 하나 입력하세요.");
         myNum[j] = sc.nextInt();
      }
      //입력받은 3개의 숫자와 랜덤으로 생성된 3개의 숫자 비교하기
      BaseballGame BGame = new BaseballGame();
      BGame.Same(num, myNum);
   }

}