package book_ch4;

public class while_99 {
	
	public static void main(String[] args) {
		int i = 2;
		int result = 0;
		while (i<=9) {
			int j=1;
			while (j<=9) {
				result = i * j;
				System.out.println(i + "*" + j + "=" + result);
				j = j + 1;
			}
			i = i + 1;
		}
	}
}
