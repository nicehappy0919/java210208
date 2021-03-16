package NoticeBoardProject;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class InsertBoard extends JFrame implements ActionListener {
	//선언부
	JFrame jf2 = null;
	///////////////속지 추가하기///////////////////////
	JPanel jp_insert1 = new JPanel();
	JPanel jp_insert2 = new JPanel();
	JPanel jp_insert3 = new JPanel();
	JButton jbtn_insert = new JButton("입력");
	Choice ch = new Choice();
	JTextField jtf_msg2 = new JTextField(20); //텍스트창
	JLabel jlb = new JLabel("게시판 선택");
	JLabel jlb_sub = new JLabel("제목");
	JTextArea jta_display2 = new JTextArea(30,15); //멀티라인으로 쓸 수 있게
	JScrollPane jsp_display2 = new JScrollPane(jta_display2); //스크롤바
	//생성부
	public InsertBoard() {
		
	}
	//화면 처리부
	public void initDisplay() {
		jf2 = new JFrame();
		jp_insert1.setLayout(new BorderLayout());
		jp_insert2.setLayout(new BorderLayout());
		jp_insert3.setLayout(new BorderLayout());
		jp_insert1.add("West",jlb);
		jp_insert1.add("Center",ch);
		jp_insert2.add("West",jlb_sub);
		jp_insert2.add("Center",jtf_msg2);
		jp_insert3.add("North",jp_insert1);
		jp_insert3.add("South",jp_insert2);
		jf2.setLayout(new BorderLayout());
		jf2.setSize(800,700);
		jf2.add("North",jp_insert3);
		jf2.add("Center",jsp_display2);
		jf2.add("South",jbtn_insert);
		jf2.setTitle("게시글 입력창");
		jf2.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		InsertBoard IBoard = new InsertBoard();
		IBoard.initDisplay();

	}

}
