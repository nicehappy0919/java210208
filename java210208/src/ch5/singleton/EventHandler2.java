package ch5.singleton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventHandler2 implements ActionListener {
   ViewApp viewApp2 = null;
   //ViewApp viewApp = new ViewApp();
   public EventHandler2(ViewApp2 viewApp) {
      this.viewApp2 = viewApp2;
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      if(e.getSource()==viewApp2.jbtn) {//NullPointerException
         System.out.println("전송 버튼 호출 성공");
      }

   }

}