package variable.step1;

public class Account1_1 {
	double kor = 0; //국어줌수 담기
	double math = 0; //수학점수 담기
	double eng = 0; //영어점수 담기
	double tot = 0; //점수합 담기
	/**************************************************************************************************
	 * 총점을 구하는 메소드 입니다.
	 * @param kor2 - 학생의 국어점수
	 * @param math2 - 학생의 수학점수
	 * @param eng2 - 학생의 영어점수
	 * @param tot - 힌 힉셍의 세과목의 총점을 구하여 담는 변수
	 */
	private double hap (double kor2, double math2, double eng2) {
//		double tot = 0;
		tot = kor2 + math2 + eng2;
		return tot;
		
	}
	/*************************************************************************************************
	 * 평균을 구하는 메소드 구현
	 * @param tot - hap메소드를 호출하여 tot를 받아온다.
	 */
	private double avg (double tot) {
		double avg = 0.0;
		avg = tot / 3;
		return avg;
	}
	/*******************************************
	 * 값에의한 호출이다.(메소드를 호출할때 값을 넣어서 부른다.)
	 * @param tot - 총합을 계산한값
	 * @param subjectNumber -과목수
	 * @return
	 */
	private double avg (double tot, int subjectNumber) {
		double imsi = tot/subjectNumber;
		System.out.println("tot==>",+tot+", subjectNumber==>"+subjectNumber);
		
		return imsi;
	}
	//나는 메소드를 선언할 수 있다.
	//대입연산자 int i = 2; 이렇게 했을 때 오른쪽에 있는 값을 왼쪽에 대입해주세요.
	//메소드 안에있는 , 는 열거형 연산자라고 한다.
	//. dot 연산자 - 주소번지.전역변수 
	//접근제한자(access modifier) - static 수정자 (static이 있으면 인스턴스화를 안해도 괜찮다.) - 리턴타입 - 메소드이름(파라미터1,파라미터2,...)
	public static void main(String[] args) {
		Account1_1 ac = new Account1_1();
		ac.kor = 70;
		ac.math = 80;
		ac.eng = 90;
		double tot = ac.hap(ac.kor, ac.math, ac.eng);
		//위에서 계산한 총점 avg메소드의 파라미터로 넘기려면 반드시 리턴타입이 필요함.
		//double test_avg = ac.avg(tot); //평균 계산됨
		double test_avg2 = ac.avg(tot,3); //평균 계산됨
		
		//System.out.println("평균은 " + test_avg + "입니다.");
		System.out.println("평균은 " + test_avg2 + "입니다.");
	}
	

}
