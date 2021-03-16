package book_ch4;

public class ForTest_java {

	public static void main(String[] args) {
		int hap = 0;
		int hap2 = 0;
		for(int i=1; i <= 10; i=i+1) {
			//출력하는 문장이 for문안에 있는 경우 10번 반복 출력되니까
			if (i % 2 == 0) { //너 i로 나눈 나머지가 0하고 같은거야?
				hap = hap + i;
			}
			else {
				hap2 = hap2 + i;
			}
		}
		//나는 for문 밖에서 한번만 30을 출력하고 싶어요.
		System.out.println("1부터10까지 세면서 짝수의 합은 구한 결과는 = " + hap + "입니다.");
		System.out.println("1부터10까지 세면서 홀수의 합은 구한 결과는 = " + hap2 + "입니다.");
	}

}
