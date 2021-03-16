package variable.step1;
import javax.swing.JFrame;

import java.awt.event.ActionEvent;

import javax.swing.JButton;



public class LoginView {
	//java.lang에 있는 패키지가 아니므로 별로도 import 해야함.
	JFrame jf = new JFrame();
	JButton jbtn_login = new JButton("로그인");
	//화면 그리기 구현
	public void initDisplay() {
		//내 자신이 이벤트 처리를 담당하는 핸들러 클래스이다 라는 의미로 this를 사용하기도 한다.
		jbtn_login.addActionListener(this); //이벤트 소스와 이벤트 처리를 담당하는 클래스 연결. 매칭
		jf.add("North",jbtn_login);
		jf.setSize(500,400);
		jf.setVisible(true); //true면 화면에 보여줄게, false:비활성화 해줄게
		
	}
	//내안에 있는 메소드 이지만 static영역 안에서 non-static을 접근할 수 없으므로 인스턴스화를 해서 해결함.
	public static void main(String[] args) {
		LoginView view = new LoginView();
		view.initDisplay();

	}
	//같은 이름의 메소드를 여러개 정의 할 수 있따. - 뒷받침하는 개념이 메소드 오버로딩(무조건 파라미터의 갯수가 달라야 한다.)과 오버라이딩(메소드 이름이 같고 서로 상속관계)이다.
	//어노테이션이다.
	//@Override
	//public void actionPerformed(ActionEvent e) {
	//	if(jbtn_login==e.getSource()) {
	//		System.out.println("이순신 님 환영합니다.");
	//	}
	//}
}
