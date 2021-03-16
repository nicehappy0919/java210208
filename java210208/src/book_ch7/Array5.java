package book_ch7;

public class Array5 {
	void methodB(boolean isOK) {
	//	System.out.println(isOK.length);
	//	System.out.println(isOK[3]);
	}
	/*
	 * 10-11번(선언만-초기화가 안됐다.-방크기가 결정되지 않았다. isOK.length:NullPointerException)
	 */
	public static void main(String[] args) {
		boolean isOK[] = null; //선언만 하였다. 크기가 결정되지 않았다.
		Array5 a5 = new Array5();
		a5.methodB(isOK);
	}

}
/*
 * 변수는 한번에 하나의 값만 답을 수 있다. - 장애
 * 배열은 한번에 여러개 값을 담을 수 있다. 
 * 그러나 다른 타입은 담을수가 없다.[문제제기] - 객체배열, ArrayList[문제해결능력 가진자]
 * 또 끼워넣기가 불가하다. - 크기를 조절할 수 없다. -ArrayList를 사용하면 문제가 해결됨.
 * 
 * 
 * 자료구조(List계열, Map계열, set계열) - 장점)늘었다 줄었다 한다.(끼워넣기 가능. 회원탈퇴, 신입사원등록)
 * FIFO 
 * LIFO
 * LILO...
 * 
 * 세션과 쿠키로 이어진다.
 * 
 * 오라클서버 - 영원하다.(컴퓨터가 꺼져도 남아있따.)
 * 
 */
