package book_ch5;

public class ParameterTest {
	String g_rdname = null;
	static int methodA() {
		return 100;
	}
	static int methodA(int p_empno) {
		return 100;
	}
	void methodA(int p_empno, String rdname) {
		g_rdname = rdname;
	}
	public static void main(String[] args) {
	//	int x = ParameterTest.methodA();
		int x = ParameterTest.methodA(7566);
		//int x2 = methodA(7566);
		System.out.println(x);
		String rdname = "개발2팀";
		ParameterTest pt = new  ParameterTest();
		pt.methodA(7566, rdname);
		//그러나 요기에서는 메소드를 경유하지 않고 출력이 되는군요. 그러니까 null이지 않나?
		System.out.println(new ParameterTest().g_rdname); //새로운 주소번지가 생성되므로 null로 찍힘.
		//여기서는 전역변수의 값이 출력되니까 개발2팀이 출력되구요
		//당연하게 21에서 methodA를 경유할 때 새로운 값이 초기화가 일어나기 때문임
		System.out.println(pt.g_rdname);

	}

}

//nonstatic 영역의 변수는 static에서는 쓸 수 없다.