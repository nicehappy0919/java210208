package NoticeBoardProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.vo.DeptVO;



public class NoticeBoard extends JFrame implements ActionListener{
	//선언부
	///////////////속지 추가하기///////////////////////
	JPanel jp_first = new JPanel();
	JPanel jp_second = new JPanel();
	JPanel jp_second_south = new JPanel(); //속지
	JPanel jp_second_center = new JPanel();
	JPanel jp_north = new JPanel(); //속지
	///////////////화면관련 전역변수 추가///////////////////
	JTextArea jta_display = new JTextArea(30,15); //멀티라인으로 쓸 수 있게
	JScrollPane jsp_display = new JScrollPane(jta_display); //스크롤바
	JTextField jtf_msg = new JTextField(40); //텍스트창
	String cols[] = {"게시판 카테고리"};
	String data[][] = new String[5][1];
	DefaultTableModel dtm_nick = new DefaultTableModel(data,cols);
	JTable jtb_nick = new JTable(dtm_nick);
	JScrollPane jsp_nick = new JScrollPane(jtb_nick);
	String cols2[] = {"글제목","작성일","작성자"};
	String data2[][] = new String[5][3];
	DefaultTableModel dtm_nick2 = new DefaultTableModel(data2,cols2);
	JTable jtb_nick2 = new JTable(dtm_nick2);
	JScrollPane jsp_nick2 = new JScrollPane(jtb_nick2);
	JButton jbtn_insert = new JButton("입력");
	JButton jbtn_update = new JButton("수정");
	JButton jbtn_delete = new JButton("삭제");
	JButton jbtn_exit = new JButton("나가기");
	JButton jbtn_sel = new JButton("검색");

	BoardVO    bVO         = null;
	//DB
	/////////////////////[[ 전체 조회 하기 소스 추가 ]] /////////////////////////
	DBConnectionMgr2 dbMgr = DBConnectionMgr2.getInstance();
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ResultSet rs2 = null;
	//생성부
	public NoticeBoard() {
		
	}
	//화면처리부
	public void initDisplay() {
		jp_north.add("Center",jtf_msg);
		jp_north.add("East",jbtn_sel);
		jp_second_center.setLayout(new BorderLayout());
		jp_second_center.add("North",jsp_nick2);
		jp_second_center.add("Center",jsp_display);
		jp_second_south.setLayout(new GridLayout(1,4));
		jp_second_south.add(jbtn_insert);
		jp_second_south.add(jbtn_update);
		jp_second_south.add(jbtn_delete);
		jp_second_south.add(jbtn_exit);
		jp_second.setBackground(Color.green);
		jp_second.setLayout(new BorderLayout());
		jp_second.add("South",jp_second_south);
		jp_second.add("North",jp_north);
		jp_second.add("Center",jp_second_center);
		jp_first.setLayout(new BorderLayout());
		jp_first.add("Center",jsp_nick);
		jp_first.setBackground(Color.red);
		this.setLayout(new BorderLayout());
		this.add("West",jp_first);
		this.add("Center",jp_second);
		this.setTitle("게시판");
		this.setSize(1500,800);
		this.setVisible(true); //화면 활성화
	}
	//화면이 로딩될때
	public void refresh() {
		System.out.println("refresh 호출 성공");
		//String sql = "SELECT BoardId, Boardname, BoardPri FROM t_noticeboard order by BoardPri asc ";
	    /////게시판 카테고리에 글 뿌려주기///////
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT BoardId, Boardname, BoardPri FROM t_noticeboard ");
		sql.append("order by BoardPri asc ");
		String bNames[] = null;
	    try {
	       con = dbMgr.getConnection();
	       System.out.println("con : "+con);
	    } catch (Exception e) {
	       System.out.println(e.toString());
	    }
	    try {
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			Vector<String> v = new Vector<String>();
			while(rs.next()) {
				String bName = rs.getString("Boardname");
				v.add(bName);
			}

			bNames = new String[v.size()];
			v.copyInto(bNames);
			while(dtm_nick.getRowCount()>0) {
	            dtm_nick.removeRow(0);
	        }
			for(int i=0;i<bNames.length;i++) {
	            Vector oneRow = new Vector();
	            oneRow.add(bNames[i]);
	            dtm_nick.addRow(oneRow);
	         }
		} catch (Exception e) {
			System.out.println("Exceptioin : "+e.toString());
		}/* finally { 
			dbMgr.freeConnection(con, pstmt, rs); 
		}*/
	    ///////////////////////////게시판 글 내용 /////////////
	    StringBuilder sql2 = new StringBuilder();
	    BoardVO bVOS[] = null;
		sql2.append("select postsub,postdate,userName ");
		sql2.append("from t_BoardPost, t_User ");
		sql2.append("where T_BOARDPOST.USERID = t_user.UserId ");
		sql2.append("order by postdate desc ");
		bVO = new BoardVO();
		try {
			pstmt = con.prepareStatement(sql2.toString());
			rs2 = pstmt.executeQuery();
			Vector<BoardVO> vb = new Vector<BoardVO>();
			while(rs2.next()) {
				bVO = new BoardVO();
				bVO.setPostSub(rs2.getString("postSub")); 
				bVO.setPostDate(rs2.getString("postdate"));
				bVO.setUserName(rs2.getString("userName"));	
				//System.out.println("bVO.getPostSub()=" +bVO.getPostSub());
				vb.add(bVO);
			}
			//System.out.println("vb.size():"+vb.size());
			bVOS = new BoardVO[vb.size()];
			vb.copyInto(bVOS);
			while(dtm_nick2.getRowCount()>0) {
	            dtm_nick2.removeRow(0);
	        }
			for(int i=0;i<bVOS.length;i++) {
	            Vector oneRow = new Vector();
	            oneRow.add(bVOS[i].getPostSub());
	            oneRow.add(bVOS[i].getPostDate());
	            oneRow.add(bVOS[i].getUserName());
	            dtm_nick2.addRow(oneRow);
	         }
		} catch (Exception e) {
			System.out.println("Exceptioin : "+e.toString());
		} finally { //사용한 자원반납
			dbMgr.freeConnection(con, pstmt, rs); 
		}
	}
	//메인메소드
	public static void main(String[] args)  {
		NoticeBoard nBoard = new NoticeBoard();
		nBoard.initDisplay();
		nBoard.refresh();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
	}

}
