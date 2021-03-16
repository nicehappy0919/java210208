package thread.basic;
class A extends Thread{
	@Override //서로 상속 관계에 있거나 구현체 관계에 있을 때만 오버라이드
	public void run() {
		for(int i=0;i<300;i++) {
			System.out.print("-");
		}
		System.out.println("[[[ A스레드 run ]]]");
	}//////////end of run
}///////////end of A
class B extends Thread{
	@Override //서로 상속 관계에 있거나 구현체 관계에 있을 때만 오버라이드
	public void run() {
		for(int i=0;i<300;i++) {
			System.out.print("|");
		}
		System.out.println("[[[ B스레드 run ]]]");
	}
}

public class ThreadEx13 {
	
	static long startTime= 0;
	/*
	 * 29번[main thread시작] - 30[2:스레드로딩-ready-go(32번(아직 대기중)을 만났을때)]-31-32[A run call]-33[B run call]
	 * 4-5-6(-----찍기||||||-----------|||||||||)
	 * 14-15-16(||||||||||||||---|||||||||||---------) 42
	 */
	public static void main(String args[]) {
		A th1 = new A();
		B th = new B();
		Thread th2 = new Thread(th);
		th1.start();
		th2.start();
		//스레드가 활동한 시간을 계산함
		startTime = System.currentTimeMillis();
		/* */
		try {
			th1.join();	// th1의 작업이 끝날 때까지 기다린다.
			th2.join();	// th2의 작업이 끝날 때까지 기다린다.
		} catch(InterruptedException e) {}
		
		System.out.print("소요시간:" + (System.currentTimeMillis() - ThreadEx13.startTime));
	} // main

}
