package book_ch5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.util.DBConnectionMgr;
import com.vo.DeptVO;

public class AddressDialog2 extends JDialog implements ActionListener {
   static DBConnectionMgr    dbMgr    = null;
   Connection             con    = null;
   PreparedStatement       ipstmt    = null;
   PreparedStatement       upstmt    = null;
   /*
    * INSERT INTO dept(deptno, dname, loc)
       VALUES(53, '개발팀','포항')
    */
   StringBuffer sql_ins2 = new StringBuffer();//멀티스레드에 안전. 속도느리고
   StringBuilder sql_ins = new StringBuilder();//싱글스레드에 안전. 속도 빠름빠름
   /*
    * UPDATE dept
          SET loc = '인천'
        WHERE deptno=51
    */
   StringBuilder sql_upd = new StringBuilder();
   JScrollPane jsp = null;
   JPanel jp_center = new JPanel();
   JPanel jp_south  = new JPanel();
   //화면을 처리할때 해당 옵션을 두 가지로 설정가능함. - setter/getter형식으로 코딩해 보기
   JLabel       jlb_deptno   = new JLabel("부서번호");
   JTextField    jtf_deptno    = new JTextField();
   JLabel       jlb_dname    = new JLabel("부서이름");
   JTextField    jtf_dname    = new JTextField();
   JLabel       jlb_loc      = new JLabel("지역");
   JTextField    jtf_loc    = new JTextField();
   JButton jbtn_account    = new JButton("처리");
   JButton jbtn_close       = new JButton("닫기");
   DeptVO dVO = null;
   static AddressBook2 aBook = null;
   //static AddressBook2 aBook = new AddressBook2();
   public AddressDialog2() {
      dbMgr = DBConnectionMgr.getInstance();
      try {
         con = dbMgr.getConnection();
         System.out.println("con : "+con);
         //자동커밋 모드를 켜둘때와 꺼둘때 - 디폴트 -true
         //con.setAutoCommit(false);
      } catch (Exception e) {
         System.out.println(e.toString());
      }      
      initDisplay();
   }
   //화면처리부
   public void initDisplay() {
      //JPanel이 디폴트로 갖는 FlowLayout을 뭉갠다.
      jp_center.setLayout(null);
      jlb_deptno.setBounds(20, 20, 100, 20);
      jtf_deptno.setBounds(130, 20, 100, 20);
      jlb_dname.setBounds(20, 45, 100, 20);
      jtf_dname.setBounds(130, 45, 150, 20);
      jlb_loc.setBounds(20, 70, 100, 20);
      jtf_loc.setBounds(130, 70, 150, 20);
      jp_center.add(jlb_deptno);
      jp_center.add(jtf_deptno);
      jp_center.add(jlb_dname);
      jp_center.add(jtf_dname);
      jp_center.add(jlb_loc);
      jp_center.add(jtf_loc);
      jsp = new JScrollPane(jp_center);
      jbtn_account.addActionListener(this);
      jbtn_close.addActionListener(this);
      jp_south.add(jbtn_account);
      jp_south.add(jbtn_close);
      this.add("Center", jsp);
      this.add("South",jp_south);
      this.setTitle("입력");
      this.setSize(400, 500);
      this.setVisible(false);
   }
   /****************************************************************
    * 
    * @param string 사용자가 선택한 요청에 대한 제목을 정함.
    * @param aBook 부모창에서 화면처리에 대한 원본 주소번지가 필요함.
    * 입력 일때는 새창을 열어서 입력 받아야 함.
    * 수정 일때는 오라클을 경유한 후  그 결과를 화면에 출력해 놓고 수정할 정보만
    * 새로 입력을 받는다.
    * 상세조회일때도 오라클을 경유하여 한 건만 출력을 해야 함.-readonly\
    * 수정과 입력 일때는 writeable
    * 수정과 상세조회 하나로 묶고
    * 입력을 하나로 묶어 처리
    * 오라클을 경유했을 때 VO 유지해야 함.
    * 그 값을 가진 주소번지를 부모창에서 받아서 자식창의 이벤트 처리 메소드인
    * actionPerformed에서 재사용해야 하므로 전역변수로 선언한 다음 지변과 초기화를 하여 
    * 사용하기로 한다.
    * @param aBook 
    * @param aBook2 
    ***************************************************************/
   public void set(String title, DeptVO dVO, AddressBook2 aBook, boolean isFlag) {
      this.aBook = aBook;//전변이다
      this.dVO = dVO;//전변이다
      this.setTitle(title);//굳이 그러지 않아도 괜찮아
      //입력모드 | 수정모드 | 상세조회모드
      this.setEnabled(isFlag);//입력받는 JTextField클래스에 대한 상태값을 조정하기-메소드 중심의 코딩으로 일괄처리 해 본다.
      this.setValue(this.dVO);//이경우에는 클래스 전체에서 공유되는 값이 되는 것이다.
   }
   private void setValue(DeptVO dVO) {
      //입력을 위한 다이얼로그창 설정 - 모든 값을 null로 셋팅합니다.
      //aDia.set("입력", null, aBook, true);
      if(dVO == null) {
         setJtf_deptno("");
         setJtf_dname("");
         setJtf_loc("");
      }
      //상세조회, 수정시는 오라클에서 조회된 값으로 초기화 해야 합니다.
      else {
         setJtf_deptno(String.valueOf(dVO.getDeptno()));
         setJtf_dname(dVO.getDname());
         setJtf_loc(dVO.getLoc());         
      }
   }
   //set메소드를 통해서 넘어온 4번째 값에 따라서 화면을 처리하는 콤퍼넌트 클래스의 수정 모드에 대한 설정을 바꾸어 줍니다.
   //만일 true이면 setEnabled(true)로 설정하고
   //만일 false가 넘어오면 setEnabled(false)로 설정하여 수정할 수 없도록 할 계획인거죠
   public void setEnabled(boolean isFlag) {
      jtf_deptno.setEditable(isFlag);
      jtf_dname.setEditable(isFlag);
      jtf_loc.setEditable(isFlag);
   }
   //setter/getter 처리해 보기
   ////////////////////////////[[ 화면 처리에 대한 setter와 getter 구현 시작 ]]//////////////////////////
   public String getJtf_deptno() {   return jtf_deptno.getText();   }
   public void setJtf_deptno(String deptno) {
      jtf_deptno.setText(deptno);
   }
   public String getJtf_dname() { return jtf_dname.getText(); }
   public void setJtf_dname(String dname) {
      jtf_dname.setText(dname);
   }
   public String getJtf_loc() { return jtf_loc.getText(); }
   public void setJtf_loc(String loc) {
      jtf_loc.setText(loc);
   }
   ////////////////////////////[[ 화면 처리에 대한 setter와 getter 구현  끝   ]]//////////////////////////
   @Override
   public void actionPerformed(ActionEvent e) {
      //처리버튼을 눌렀을 때
      //입력을 처리, 수정을 처리
      //목적지가 다시 부모창의 목록페이지로 돌아가서 새로고침이 일어남.
      //부모창의 주번이 있어야 새로고침을 처리하는 메소드를 호출 가능함.
      String command = e.getActionCommand();
      System.out.println("actionPerformed 호출 "+command);
      if("처리".equals(command)) {
            //입력 혹은 수정처리
         if(dVO == null) {//입력일때
            DeptVO pdVO = new DeptVO();
            pdVO.setDeptno(Integer.parseInt(getJtf_deptno()));//NumberFormatException\
            pdVO.setDname(getJtf_dname());
            pdVO.setLoc(getJtf_loc());
            sql_ins.append("INSERT INTO dept(deptno, dname, loc)");
             sql_ins.append(" VALUES(?, ?, ?)      " );
            try {
               ipstmt = con.prepareStatement(sql_ins.toString());
               int i =0;
               ipstmt.setInt(++i, pdVO.getDeptno());
               ipstmt.setString(++i, pdVO.getDname());
               ipstmt.setString(++i, pdVO.getLoc());
               int iresult = ipstmt.executeUpdate();
               if(iresult == 1) {
                  JOptionPane.showMessageDialog(aBook.jf, "등록하였습니다.");               
               }
               //사용한 자원 반납하기
               dbMgr.freeConnection(con, ipstmt);
            } catch (Exception e2) {
               JOptionPane.showMessageDialog(aBook.jf, "Exception"+e2.toString());
            }
            
         }
         else {//수정일때
            DeptVO pdVO = new DeptVO();
            pdVO.setDeptno(Integer.parseInt(getJtf_deptno()));//NumberFormatException\
            pdVO.setDname(getJtf_dname());
            pdVO.setLoc(getJtf_loc());
            sql_upd.append("UPDATE dept");
              sql_upd.append("   SET loc = ?"  );
              sql_upd.append(" WHERE deptno=?" );   
              try {
               upstmt = con.prepareStatement(sql_upd.toString());
               int i =0;//물음표 갯수만큼 필요해요. 시작은 1부터 입니다.
               upstmt.setString(++i, pdVO.getLoc());
               upstmt.setInt(++i, pdVO.getDeptno());
               int uresult = ipstmt.executeUpdate();
               if(uresult == 1) {
                  JOptionPane.showMessageDialog(aBook.jf, "수정 하였습니다.");               
               }   
               dbMgr.freeConnection(con, upstmt);
            } catch (Exception e2) {
               JOptionPane.showMessageDialog(aBook.jf, "Exception"+e2.toString());
            }
         }
         aBook.refresh();
         setVisible(false);         
      }////////////end of 처리
      else if("닫기".equals(command)) {
         //닫기 버튼을 누르면 자바가상머신과의 연결 고리를 끊어서 강제 종료 시킴.
         this.dispose();
      }
   }   
/* */
   public static void main(String[] args) {
      AddressDialog2 ad2 = new AddressDialog2();
      //ad2.set("상세", ad2.dVO, aBook, false);
      ad2.initDisplay();
      //ad2.setVisible(true);
      //ad2.setTitle("수정");
   }   
   
}
