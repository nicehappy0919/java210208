package variable.step1;

public class Variable {
	//선언부
	
	//메소드 선언
	void methodA(int x) {
		
	}
	double methodB(int x) { //x는 지변이므로 밖에서는 사용불가.
		System.out.println(x); //1이 찍힘.
		return 3.14;
	}
	//메인메소드가 있어야 exe파일로 만들 수 있어요
	/***********************************************************************************************************
	 * 문제해결능력을 키움.
	 * @return void이다. - 비어있다. -돌려받을 수 있는 값이 없다. -이것때문에 에러가 발생할 수도 있다.
	 * @param args
	 */
	public static void main(String[] args) {
		//System이 가리키는것은 나의 컴퓨터, out속성이 가리키는것은 출력장치(하드웨어-모니터, 프린터....),print()이건 illegal, print(int i),print(double pi), print("안녕")
		System.out.print(5);//줄바꿈 안됨, 메소드를 호출(주소번지.methodA();
		//메소드를 선언할 때는 좌중괄호 우중괄호를 사용하고...
		//메소드를 호출할때는  ;
		//API, XXX.jar, 이 안(클래스[소스가 있으니까 구체적이다] 안에 캑체(결정되지 않은것 Sonata.java, class Sonata{}) 안에)에 있는 것을 꺼내쓴다.(클래스 또는 객체)
		//print메소드는 여러개이다. 같은 이름의 메소드를 여러개 만들 수도 있다.
		//SELECT 이름 FROM 회원집합
		// WHERE 아이디='test'
		//   AND 비번='123'
		//System.out.print(); //줄바꿈 안됨-반환값이 없으니까 에러인거야
		Variable v = new Variable();
		System.out.print(v.methodB(1)); //반환값이 있으니까 에러가 아니다. 3.14가 찍힌다.
		//System.out.print(v.methodA(1)); //반환값이 없으니까 에러인거다.
		System.out.print(1+"     "+1);
		System.out.print(10+10);
		System.out.print(10+"10");
		System.out.print(10+""+10);
		System.out.print("      ");
		System.out.println(); //줄바꿈 추가된 메소드
	}

}
