//문제) 1부터 100까지 세면서 5의 배수이면 fizz를 출력하고 7의 배수이면 buzz를 출력하고 5와 7의 공배수이면 fizzbuzz를 출력하고 나머지는 출력하는 프로그램을 작성하시오
//(for문과 switch문을 사용해서 풀어보자)
public class SwitchQuiz {

	public static void main(String[] args) {
		int num = 0; //5의 배수인지 7의 배수인지 5와7의 공배수인지를 담는 변수
		for (int i=1;i<=100;i++) {
			if ( i % 5 == 0 && i % 7 == 0) { //5와7의 공배수인 경우
				num = 570;
			}else if (i % 5 == 0) { //5의 배수인경우
				num = 500;
			}else if (i % 7 == 0) { //7의 배수인경우
				num = 700;
			}
			
			switch (num){
			case 500:
				System.out.println("fizz");
				num = i;
				break;
			case 700:
				System.out.println("buzz");
				num = i;
				break;
			case 570:
				System.out.println("fizzbuzz");
				num = i;
				break;
			default:
				System.out.println(i);
				break;
			}/////end of switch
		}////end of for	

	}

}
