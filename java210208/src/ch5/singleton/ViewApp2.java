package ch5.singleton;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ViewApp2{
   //setSize하기 전에 인스턴스화를 하였다.
   JFrame jf =new JFrame();
   JFrame jf2 =null;
   JButton jbtn = null;
   public void initDisplay() {
      jf2 = new JFrame();
      //디폴트 생성자는 제공해주지만 파라미터를 갖는 생성자는 제공되지 않습니다.
      EventHandler2 eh = new EventHandler2(this);
      //이메소드는 호출되나요?
      //너 실행문이야?
      jbtn = new JButton("전송");
      jbtn.addActionListener(eh);/////////메소드호출(실행문)
      jf2.add("North",jbtn);
      jf2.setSize(300, 200);
      jf2.setVisible(true);
   }
   public static void main(String[] args) {
      ViewApp2 va = new ViewApp2();
        va.initDisplay();
   }
}