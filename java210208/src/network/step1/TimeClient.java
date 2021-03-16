package network.step1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JLabel;

public class TimeClient extends Thread {
	String timeStr = null;
	JLabel jlb_time = null;
	TimeClient(){
	}
	public TimeClient(JLabel jlb_time){ //package가 다를때 접근하려면 public이 필요.. 그래서 public을 붙여줘야 함.
		this.jlb_time = jlb_time;
	}
	@Override
	public void run() { //콜백메소드-사용자가 아니라 시스템 레벨에서 자동 호출되는 메소드 임.	
		System.out.println("run 호출성공");
		Socket socket = null;
		PrintWriter out = null;
		BufferedReader br = null;
		boolean isFlag = false;
		try {
			socket = new Socket("192.168.0.31",3000); //서버아이피,포트번호
			out = new PrintWriter(socket.getOutputStream(),true);
			//socket = new Socket("192.168.0.23",3000); //서버아이피
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//InputStream is = new InputStreamReader(socket.getInputStream());
			//내 소켓에 대한 포트번호는 따로 할당 됨.
			while(!isFlag) {
				while((timeStr=br.readLine())!=null) {
					System.out.println(timeStr);
					jlb_time.setText(timeStr);//디폴트 생성자를 경유하므로 jlb_time은 null이다.
					try {
						sleep(1000);
					} catch(InterruptedException e) {
						System.out.println("넌 누구.....");
					}
				}
			}			
		}catch(Exception e) {
			
		}
	}
	// AddressBook2에서 실행해야 하므로 main메소드는 없애준다.
	/*
	public static void main(String[] args) {
		TimeClient tc = new TimeClient();
		tc.start();//run메소드 호출해줌.
	}
	*/
}
