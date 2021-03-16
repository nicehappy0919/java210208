package book_ch5;

public class PrideSimulation {

	public static void main(String[] args) {
		//private으로 했을 경우 인캡슐레이션이 적용되는 것이다.
		//생성자를 선언할 때 private으로 선언했으므로 디폴트 생성자를 활용하고 싶다면 싱글톤 패턴으로 정의하여 사용해야 한다.
	//	Pride myCar = new Pride();  //private이 붙어있으므로 이렇게되면 에러남  데이터 복제가 안됨 -> 싱글톤
		Pride herCar = new Pride(10);
		Pride himCar = new Pride(100,4);

		himCar.wheelNum = 4; //4->14로 바뀐다. 아래 14롤 바꿔줘서
		herCar.wheelNum = 14;
		Pride.wheelNum = 5; //이렇게 쓰는게 의미가 있다. himCar.wheelNum 나 herCar.wheelNum 로 써봤자 의미가 없다. static 이므로
		
		himCar.speed = 10;
		herCar.speed = 50; //얘는 각각 윺지가 된다. 인스턴스 변수이기 때문에..
		System.out.println("himCar.wheelNum : " + himCar.wheelNum);
		System.out.println("herCar.wheelNum : " + herCar.wheelNum);
		System.out.println("herCar.wheelNum : " + Pride.wheelNum);
		System.out.println("himCar.speed : " + himCar.speed);
		System.out.println("herCar.speed : " + herCar.speed);
		
	}

}
