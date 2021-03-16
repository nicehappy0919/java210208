package variable.step1;

public class MainMethod {
/*****************************************************************************************
 * 
 * @param args - 파라미터의 타입은 배열입니다.
 * String args[] = new String[3]; 원래 이렇게 생겼는데
 * main 메소드는 좀 특별한 경우라서 따로 설명하기
 * 오늘의 학습목표
 * main메소드에 대해서 설명할 수 있다.
 */
	public static void main(String[] args) {
		//만일 숫자라면 20을 출력할꺼야
		//만일 문자라면 1010을 출력할거야
		//int+int=int
		//int+String=붙여쓰기이다.
		System.out.println(args[0]+10);
		//너 타입이 뭐니?
		//타입을 체크할 수있는 연산자가 있다. - 왜냐햐면 자바는 컴파일할때 타입을 따지니까...
		if(args[0] instanceof String) { //instanceof 라는 예약어는 너 ~~ 타입이야 하는 것임.
			System.out.println("나는 문자열이야");
		}
		else {
			System.out.println("나는 문자열이 아닌데......");
		}
		//if문 안에는 반드시 boolean이 와야한다. 
		if(true) { //else를 실행할 경우는 죽어도 없다. 왜? 상수니까. (변수가 아니다)
			System.out.println("나는 참 입니다.");
		}
		else {
			System.out.println("나는 거짓 입니다.");
		}
		for(int i=0;i<100;i=i+1) {
			if(true) { //else를 실행할 경우는 죽어도 없다. 왜? 상수니까. (변수가 아니다)
				System.out.println("나는 참 입니다.");
			}
		}////end of for
	}

}
