package variable.step1;

public class Practics4 {
	//문제4)) 등비수열은 각 항의 앞에 일정한 수를 곱해서 이루어지는 수열을 말합니다. 첫번째 부터 7번째 까지의 수열을 출력하시오.

	public static void main(String[] args) {
		int rate = 2; //등비변수 초기화
		int num = 1; //등비수열 값을 담을 변수 초기화
		
		for (int i=1; i<=7; i++) {
			if (i==1) {
				System.out.print(num+" ");
			}else {
				num = num * rate;
				System.out.print(num+" ");
			}
		}
	}

}
