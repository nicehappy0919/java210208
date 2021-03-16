package book_ch5;
/*
 * 싱글톤 패턴의 정의
 * 해당 클래스의 인스턴스가 하나만(정적이다.) 만들어지고 어디서든지(public, 캡슐레이션(외부에서 접근을 못하게 막아둠)이 안되어있다는 듯) 
 * 그 인스턴스에 접근할 수 있도록 하기 위한 패턴이다.
 * 클래스변수-값은 하나다. static variable이다.
 * 인스턴스변수- 인수톤수화해서 만들어진다. 값이  여러개이다. 
 * 방법1 - 고전적인 싱글톤 패턴 구현법
 * 방법2 - 성능이나 병목현상을 고려하여 구현하기
 * 방법3 - 
 * @author 
 */
public class Pride {
	//클래스 변수(-only one:값을 하나를 갖는다.)이다. static이 붙은것이
	static int wheelNum = 0;
	int		   speed = 0;
	private Pride() {  //캡슐레이션해서 외부에서 인스턴스화 할 수 없다.
		
	}
    public Pride(int speed) {
		this.speed = speed;  //전역변수의 장애: 전역변수는 자꾸만 변한다. 전역변수는 값을 유지해야 하는경우에는 static으로 두는것이 안전하다. 그래서 class변수가 필요하다.
	}
	public Pride(int speed, int wheelNum) {
		this.speed = speed;
		this.wheelNum = wheelNum;
	}
	void speedUp() {
		speed = speed + 1;
	}
	/*이 경우는 문법 에러가 발생함.
	 * static void stop() {
	 * speed = 0;
	 * }
	 */
	static void change() {
		wheelNum = 2;
	}
	
}
