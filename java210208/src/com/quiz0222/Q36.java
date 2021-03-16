package com.quiz0222;
class Q36_1{
	void methodC() {
		Q36.methodB();
		Q36 q36 = new Q36();
		q36.methodB();
	}
}
/* non-static과 static의 차이
 * non-static 영역에서 static 타입은 접근할 수 있다.
 * 그러나 static 영역에서 non-static은 접근이 불가하다. 
 * 
 * static
 * 
 */
public class Q36 {
	//static 블럭이다.
	static {
		System.out.println("static block");
	}
	void methodA() {
		System.out.println("methodA 호출");
		methodB();
	}
	static void methodB() {
		System.out.println("static methodB호출");
		//methodA(); 이거는 안된다. static이 없어서.
	}
	//메인메소드도 static이다.
	//main htread라고 한다. 우선순위가 높다.
	//자바스크립트는 싱글스레드이다.
	public static void main(String[] args) {
		System.out.println("static block");
		methodB();

	}

}
