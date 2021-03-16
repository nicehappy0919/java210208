package variable.step1;

import com.vo.DeptVO;

public class MethodOverloading {
	/*
	 * @param pdvo - 조건절에서 사용될 상수값을 담음. -where절에 들어갈 조건값으로 사용됨.
	 * @return rdvo - 오라클에서 조회된 결과를 담음 -화면 출력용으로 사용.
	 */
	DeptVO go(DeptVO pdvo) {
		System.out.println(pdvo.getDeptno()+", "+pdvo.getDname()+","+pdvo.getLoc());
		DeptVO rdvo = null;
		rdvo = new DeptVO();
		//오라클 경유한다음 조회 결과를 받아온 내용을 담는 클래스 이다.
		return rdvo;
	}
	//이런것들은 메소드 오버라이딩 이다.
	//메소드 이름은 같은데 서로 다른 메소드로 인지함.
	void go() {
		System.out.println("파라미터가 없는 go() 호출 성공");
	}
	void go(int i) { //값에 의한 호출이다. i에는 메소드가 호출할 때 파라미터로 넘어도는 10이 복사됨.
		System.out.println("파라미터가 int인 go(10) 호출 성공"+i); //원시형 타입을 부르는 거니까 값이 출력됨.
	}
	void go(String name) {
		System.out.println("파라미터가  String인 go(Smith) 호출 성공");
	}
	public static void main(String[] args) {
		MethodOverloading mol = new MethodOverloading();
		mol.go();
		mol.go(10); // 그 값은 여기서 결정됨. 메소드 호출할 때 결정됨. - 파라미터이다. 겂애 의한 호출이다.
		mol.go("Smith"); //참조형 타입이니까 참조에 의한 호출이다. -String만 예외이다. 호출할때 주소번지가 아니라 값이 출력된다는 점에 대해서..
		DeptVO pdvo = new DeptVO();
		/*
		pdvo.setDeptno(50); //int
		pdvo.setDname("개발1팀"); //String
		pdvo.setLoc("제주도"); //String
		*/
		mol.go(pdvo); //주소번지를 넘겼다. 참조에 의한 호출이다. <==> 값에 의한 호출이다.

	}

}
