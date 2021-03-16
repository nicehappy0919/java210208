package ch5.singleton;

public class SonataSimulation {

	public static void main(String[] args) {
		Sonata yourCar = Sonata.getInstance(); //싱글톤의 방식이다.
		Sonata meCar = Sonata.getInstance();
		Sonata gnomCar = Sonata.getInstance();
		System.out.println(yourCar);
		System.out.println(meCar);
		System.out.println(gnomCar);
		//Sonata car = new Sonata(); //싱글톤이라서 에러난다. 이렇게 쓰면안됨.
	}

}
