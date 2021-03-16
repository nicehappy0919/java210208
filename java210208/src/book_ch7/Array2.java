package book_ch7;

public class Array2 {
	int x = 3;
	String names[] = null;
	String enames[] = {"SMITH","KING","WORD"};
	public static void main(String[] args) {
		Array2 a2 = new Array2();
		boolean isOk[] = new boolean[a2.x];
		for(boolean bo:isOk) { //전제를 조회할때 사용핧 수 있음
			System.out.println(bo);
			
		}
		a2.names = new String[a2.x];
		a2.names = new String[] {"이순신","강감찬","홍길동"};
	}

}
