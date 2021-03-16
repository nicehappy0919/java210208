package book_ch7;
//EmpVO는 1개의 row만 담을 수가 있다.
public class EmpVO {
	private int    empno = 0;
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	private String ename = null; //오브젝트 타입이므로 null을 통해 초기화
	private double sal   = 0.0;
	public int EmpVO() {
		return deptno;
	}
	
}
//Alt+shift+S 그다음에 R 누르면 겟터 세터 만들어짐.