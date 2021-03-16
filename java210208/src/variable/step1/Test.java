package variable.step1;

public class Test {
//
//	public static void main(String[] args) {
//		int x =5;
//		boolean b1 = true;
//		boolean b2 = false;
		
//		if((x==4) && !b2)    //5==4 flase && !false true
//			System.out.print("1 ");
//			System.out.print("2 ");  // { }가 없으므로 이 문장은 실행됨.
//		if ((b2 = true) && b1)  
//			System.out.print("3 ");  
//
//	String #name = “Jane Doe”;
//	int $age=24;
//	double _height = 123.5;
//	double ~temp = 37.5;

	
	public static void main(String[] args) {
		int x = 5; //이 x와
		Test p = new Test();
		p.doStuff(x); //값에 의한 호출이다.
			 	System.out.print(" main x = "+ x);
			 }
		
	void doStuff(int x) { //여기서 x는 서로 다른 x이다.
		System.out.print(" doStuff x = "+ x++); 
		System.out.print(" doStuff x = "+ x); 
		}
			

	}




