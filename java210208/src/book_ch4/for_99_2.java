package book_ch4;

public class for_99_2 {
	//구구단을 계산한다.

	public static void main(String[] args) {
		int result = 0;
		for(int j=1; j<=9; j++) {
			for (int i = 2; i<=9; i++) {
				result = i * j;
				System.out.print(i + "*" + j + "=" + result + "   ");
			}
			System.out.println();
		}

	}

}
