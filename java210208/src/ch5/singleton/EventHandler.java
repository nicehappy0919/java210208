package ch5.singleton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventHandler implements ActionListener {
   ViewApp viewApp = null;
   //ViewApp viewApp = new ViewApp();
   public EventHandler(ViewApp viewApp) {
      this.viewApp = viewApp;
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      if(e.getSource()==viewApp.jbtn) {//NullPointerException
         System.out.println("전송 버튼 호출 성공");
      }

   }

}