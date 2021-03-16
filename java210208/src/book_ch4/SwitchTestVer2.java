package book_ch4;

import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SwitchTestVer2 extends JFrame {

	public static void main(String[] args) {
		SwitchTestVer2 stv = new SwitchTestVer2();
		int protocol 		= 0;//로그인
		String nickName 	= "tomato";
		String inputValue 	= "오늘 스터디 할까?";
		String msg = 300+"#"+nickName+"#"+inputValue;
		StringTokenizer st = new StringTokenizer(msg,"#"); //#을 기준으로 썰어서 토큰에 가져온다.
		protocol = Integer.parseInt(st.nextToken());
		String s_nickName = st.nextToken();
		String s_inputValue = st.nextToken();
		//제어문의 역할 은 업무 선서에 대한 흐름을 바군다.
		//순서에 대한 정보를 바탕으로 의사를 결정할 수 있는 것은 팀장, 차장, 부장 선택자
		//선택(비즈니스로직계층-Model계층)에 따라
		//break <-> continue
		//break가 continue보다 훨씬 많이 쓰인다. 
		//for문, while,.....무한루프를 방지하기 위해서 break가 쓰인다.
		//if문에서는 break 대신에 return이다. -return을 만나면 if문이 아니라 메소드를 탈출한다.
		//switch문에서의 break는 switch문을 탈출
		switch(protocol) {//원시형타입 + String타입
		case 100:
			//실행문
			System.out.println("0입니다.");
			break;
		case 200:
			//실행문
			System.out.println("301입니다.");
			break;
		case 300:
			//실행문
			System.out.println("["+s_nickName+"]" + s_inputValue);
			break;
		default:
			JOptionPane.showMessageDialog(stv, "잘못된 메시지 입니다.");
			//System.out.println("잘못된 메시지 입니다.");
			break;
		}///////end of switch
		System.out.println("여기");
	}
//동기화를 하려면 반드시 서버를 경유해야 한다.
}
