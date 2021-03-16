package athread.talk1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TalkClient extends JFrame implements ActionListener {
	///////////////속지 두장 추가하기///////////////////////
	JPanel jp_first = new JPanel();
	JPanel jp_second = new JPanel();
	JPanel jp_second_south = new JPanel(); //속지
	///////////////통신과 관련된 전역변수 추가/////////////////
	Socket             socket = null;
	//직렬화를 누릴 수 있다. 네트워크를 통해 주고받을때(패킷단위로 왔다갔다할때 줄을 세워서 보내야 중간에 끊어져도 이어보내기 쉽다.)
	ObjectOutputStream oos    = null;
	ObjectInputStream  ois    = null;//읽기쓰기를 하는데 여러타입을 쓰기 위해서
	//닉네임 담아두는 변수
	String           nickName = null; //재훈님 창, 희태님, 제정님... (사라지지않고 유지되야하므로 전역변수)
	///////////////화면관련 전역변수 추가///////////////////
	JTextArea jta_display = new JTextArea(); //멀티라인으로 쓸 수 있게
	JScrollPane jsp_display = new JScrollPane(jta_display); //스크롤바
	JPanel jp_south = new JPanel(); //속지
	JTextField jtf_msg = new JTextField(20); //텍스트창
	JButton jbtn_send = new JButton("전송"); //전송버튼
	//소켓관련 초기화
	public void init() {
		try {
			//소켓 생성하기 - ip, port - 서버측 ServerSocket에 연결됨.
			//socket = new Socket("127.0.0.1",3000);
			socket = new Socket("localhost",3000);
			oos = new ObjectOutputStream(socket.getOutputStream()); //항상 홀수부터 해줘야 한다.
			ois = new ObjectInputStream(socket.getInputStream());
			oos.writeObject(100+"#"+nickName);
			TalkClientThread tct = new TalkClientThread(this);
			tct.start(); //run메소드가 호출이 된다. 여기는 말하는 곳이다.
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	public void initDisplay() {
		nickName = JOptionPane.showInputDialog("닉네임을 입력하세요");
		jtf_msg.addActionListener(this);
		jta_display.setEditable(false);//수정모드를 꺼놓자.
		jp_south.setLayout(new BorderLayout());//보더 레이아웃으로 잡아야 구역잡아서 할 수있다. 센터등등..
		jp_south.add("Center",jbtn_send);
		jp_south.add("East",jbtn_send);
		this.add("Center",jsp_display); //전광판
		this.add("South",jp_south);
		this.setTitle(nickName+"님의 창");
		this.setSize(500,400);
		this.setVisible(true); //화면 활성화
	}
	public static void main(String[] args) {
		TalkClient tc = new TalkClient();
		tc.initDisplay();
		tc.init(); //소켓처리(화면먼저 그리고 소켓처리)
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String msg = jtf_msg.getText();
		if(jtf_msg == obj) {
			try {
				oos.writeObject(200
						+"#"+nickName
						+"#"+msg);
				jtf_msg.setText("");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
}
