package book_ch7;

public class B {
	int deptno = 0;
	public B(int deptno) {
		this.deptno = deptno; //생성자의 경우에는 파라미터 이름을 통일하는 것이 좋다.
	}
	int methodA() {
		int u_deptno = 0;
		return u_deptno;
	}
	void getDeptList(int u_deptno) { //이런 경우에는 파라미터의 이름을 통일하지 않아도 좋다.
		
		/*
		 * SELECT dname, loc FROM dept
		 * WHERE deptno =?
		 */
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
