package ch5.singleton;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ViewApp {
	//setSize하기 전에 인스턴스화를 하였다.
	JFrame jf = new JFrame(); //선언과 생성을 한번에.. jf2를 써서 선언과 생성을 분리하자. 이른 인스턴스화다.
	//인스턴스화를 분리해서 할 수도 있다.
	//이럴 경우 어떤 차이가 있나요?
	JFrame  jf2  = null;
	JButton jbtn = null;
	public void initDisplay() {
		jf2 = new JFrame();
		//jbtn = new JButton();
		//jbtn.setText("전송");
		jbtn = new JButton("전송"); //위의 두 줄로 쓴것을 이렇게 한줄로 쓸 수 있다. 
		//이벤트 소스와 이벤트 처리를 담당하는 클래스를 연결해주어야 함. - 버튼을 눌렀을 때
		//이벤트 처리를 담당하는 클래스를 이벤트 핸들러 클래스 라고 한다.
		//이벤트 처리를 담당하는 클래스는 반드시 actionPerformed라는
		//메소드를 오버라이딩해야 한다. - 여기서 this사용 내 안에 있으므로
		jbtn.addActionListener(this); //ActionPerformed로 이동
		//이벤트 처리 메소드가 외부에 있을때는 
		//ViewAppEvent ve = new ViewAppEvent();
		//jbtn.addActionListener(ve); //시점의 문제를 당할 수 있다. - 문제해결능력
		//생성된 버튼을 JFrame의 북쪽에 배치해본다.
		jf2.add("North",jbtn);
		jf2.setSize(300,200);
		jf2.setVisible(true);
	}
	public static void main(String[] args) {
		ViewApp va = new ViewApp();
		va.initDisplay();

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// 너 전송버튼 누른거야?
		//ae.getSource()는 이벤트가 일어난 버튼의 주소번지를 반환해주는 메소드 이다.
		if(ae.getSource()==jbtn) { //전송버튼이 눌렸다는 뜻
			System.out.println("전송버튼 호출 성공");
		}
	}

}
