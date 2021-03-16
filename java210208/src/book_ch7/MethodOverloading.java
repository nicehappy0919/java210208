package book_ch7;
//전제조건은 반드시 메소드이름이 같을때만 고려함(메소드 오버로딩)
import com.vo.DeptVO;

public class MethodOverloading {
	void go() {
		
	}
	//public void go(){} //접근제한자는 영향없다. 이렇게 쓰면 두번정의한게되서 안된다.
	public void go(int[] a) {} //메소드 오퍼로딩이다. 파라미터의 갯수가 달라졌으니까.
	//public void go(int[] b) {} //메소드 오퍼로딩이 아니다. 변수의 이름은 상관이 없다.
	public void go(DeptVO dvo) {} //메소드 오버로딩을 만족함.
	//int go() {
	//	return 0; //리턴타입이 있고 없고는 영향을 미치지 않는다.
	//}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
