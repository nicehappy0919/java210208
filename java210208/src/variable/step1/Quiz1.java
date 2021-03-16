package variable.step1;

public class Quiz1 {
	int x; //전역변수는 초기화를 하려면 두줄로 나눠서 할 수 없다. 하지만 초기화를 생략할 수는 있다.
	//메소드에는 2가지 종류가 있다.
	//JVM에서 제공되는 메소드와 사용자 정의 메소드
	//메소드 선언 순서는 리턴타입 메소드이름() { 실행문; } - 기초가 있다.
	//메소드 선언할 때 리턴타입과 반환타입을 결정할 수 있다. - 기초가 아니다. 코딩을 해봐야 한다. 책으로 공부할 수 없다. 연습만이 살길이다.
	public static void main(String[] args) {
		Quiz1 q = new Quiz1();
		System.out.println("methodA호출 성공" + q.x);
		q.methodA(); //다음 문법 에러를 해결하시오.
		q.methodA(5);
	}
//methodA의 호출이 선언 앞에 오더라도 에러가 아니다.
//왜냐하면 자바는 절차지향의 프로그램 언어가 아니니까.
//왜냐하면 객체지향 언어이므로 호출 순수와는 상관이 없다.
//자바에서는 같은 이름의 메소드를 중복하여 선언할 수 있다.
//이것을 가능하게  하는 규칙은 메소드 오버로딩이디.
//메소드 오버로딩은 반드시 파라미터의 타입이 다르거나(합집합):둘중의 하나만 만족해도 참) 파라미터의 갯수가 달라야 한다.
//주의사항:리턴타입이 있고 없고는 영향을 주지 않음.
	private void methodA() { //private으로 하면 내 안에서만 사용할 수 있다. 외부의 클래스 에서는 접근이 불가함. 호출이 안됨. 재사용불가다.
		System.out.println("methodA호출 성공");
		
	}
	//파라미터 x에는 누가 값을 정해주는 걸까요?
	//언제 결정되는 걸까요?
	//메소드를 호출할때 결정됨.
	private void methodA(int x) {
		System.out.println("methodA호출 성공" + x);
		
	}
	private int methodA(double y) {
		System.out.println("methodA호출 성공" + x);
		return 0;
	}


}
