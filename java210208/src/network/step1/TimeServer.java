package network.step1;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;
/*
 * 소켓-무전기에 장찬된 하드웨어라고 생각하면 이해하기 쉬움.
 * 네트워크에서 정보가 들어가고 나가는 지접에 대한 유일한 식별자
 * 32비트의 숫자로 구성되며 짝수번 소켓은 정보를 받아들이는 용도로
 * 홀수번 소켓은 정보를 보내는 용도로 사용됨. 따라서 사용유무와 상관없이 다 있어야 한다.
 * 
 * FIFO의 속성을 가지고 있다. 자료구조에서 큐(명령어 순차적으로 처리), 스택(백팩이다.-FILO)
 * 동시에 두가지를 할 수는 없다.(읽으면서 쓰기 혹은 쓰면서 읽기 이런것은 불가능하다.)
 * 
 * 네트워크망이 구성되어 있어야 함.
 *  
 * TCP포트번호 : 물리적인 장치를 꽂는 장소는 아니다. 용더에 따라 쓰는 숫자 값이다.
 * 서버에서 돌아가는 특정 프로그램을 나타내는 16비트 숫자
 * 웹서버 - 80
 * 텔넷서버 - 23
 * FTP서버 - 20
 * SMTP서버 - 25
 * 
 * 같은 포트에서 여러 프로그램이 돌아갈 수 있나요?
 * BindException이 발생함.
 * 
 * netstat -ano | findstr 3000 검색
 * taskkill /pid 42356 / f 이렇게 삭제해줘야 똑같은 번호를 다시 사용할 수 있다.
 */
public class TimeServer extends Thread {
	Socket socket = null;
	public TimeServer() {};
	public TimeServer(Socket socket) {
		this.socket=socket;
	}
	/************************************************************************
	 * 스레드 기동시 호출되는 메소드 이다.
	 ***********************************************************************/
	@Override
	public void run() {
		boolean isFlag = false;
		try {
			//socket에 대한 객체 주입은 인스턴스화를 통해서 생성자가 호출되었을 때 객체 주입이 이루어짐.
			PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
			while(!isFlag) {
				if(out!=null) {
					out.println(getTimer());
				}
				//1초동안 기다려... 그리고 진행.. 1초 기다려.. 진행
				try {
					sleep(1000);//밀리세크 단위 설정함. 지연하기-스레드, 경합-스레드, 순서-스레드, 순서를정한다-스레드
				}catch(Exception ie) {
					System.out.println("앗~~ 넌 누구.....");
				}
			}
		}catch(Exception e) {
			
		}
		System.out.println("run call ....");
	}
	public String getTimer() {
		Calendar cal = Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);
		//return "10:24:15";
		//삼항연산자 변수 비교연산자? 참일때 : 거짓일때
		return(hour < 10? "0"+hour : ""+hour) +":"
				+(min < 10? "0"+min : ""+min) +":"
				+(sec < 10? "0"+sec : ""+sec);
	}
	//본만큼 구현하는 것이다.
	//main메소드도 스레드이다. (defaul thread이다) - 메인메소드가 entry point 이기 때문에. 이거보다 먼저 실행되는 것은 static{}뿐이다.
	public static void main(String[] args) {
		int port = 3000; //포트번호 지정
		boolean isFlag = false; //서버를 탈출 시킬 수 있는 수단
		ServerSocket server = null;//기다림... 클라이언트가 접속할 때까지.. 클라이언트는 new Socket("192.168.0.23",3000)을 쓸때까지
		Socket client = null;
		try {
			server = new ServerSocket(port);
		}catch(Exception e) {
			
		}
		System.out.println("TimeServer Started successfully...");
		//while(true) { ->>이렇게 쓰는것은 위험하다. 무한루프에 빠질 수 있다.
		while(!isFlag) {
			try {
//				TimeServer ts = new TimeServer(client); 
//				ts.start(); //run()이 호출 당한다. 51qjsdptj NullPointerException 발생함
				//기다려. 손님올때까지 기다려...
				client = server.accept();
				//initDisplay(); 여기에 있으면 영원히 세상구경을 못할 수도 있다. 위치와 순서, 화면-input-operation-output 소통의 시작점
				System.out.println("New Client connected..."+client.toString()+"\n");
				TimeServer ts = new TimeServer(client);
				ts.start(); //run()이 호출 당한다.
			}catch(Exception e) {
				System.out.println("while ===> "+e.toString());
			}
		}
	}

}
