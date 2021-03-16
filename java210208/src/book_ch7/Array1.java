package book_ch7;
/*
 * 배열은 한번 선언하면 원소의 수를 조정 불가함.
 * 끼워넣기가 안됨.
 * 배열의주번.length명사형-원소의 갯수이다. "hello".length()-문자열 길이이다.
 */
public class Array1 {

	public void printArray(int empnos[]) {
		int cnt = 0;
		for(int i=0;i<empnos.length;i++) {
			System.out.println(++cnt+"번방"+empnos[i]);
		}
	}
	/*
	 * 19번-20-22-23-9-10-11-12-11... 
	 * 
	 */
	public static void main(String[] args) {
		int empnos[] = new int[14];
		//저 14개 방에는 어떤 값이 들어있을까여? 
		Array1 a1 = new Array1();
		a1.printArray(empnos);
		

	}

}
