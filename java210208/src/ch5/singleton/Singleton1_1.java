package ch5.singleton;

public class Singleton1_1 {
	/*******************************************************************************
	 * 싱글톤 패턴의 정의
	 * 해당 클래스의 인스턴스가 하나만 만들어지고 어디서든지 그 인스턴스에
	 * 접근할 수 있도록 하기위한 패턴이다.
	 * 고전적인 싱글톤 패턴 구현방법이다.
	 * 
	 ******************************************************************************/

	private static Singleton1_1 uniqueInstance = null;
	public static Singleton1_1 getInstance() {
		if(uniqueInstance == null) {
			uniqueInstance = new Singleton1_1();
		}
		return uniqueInstance;
	}
}
