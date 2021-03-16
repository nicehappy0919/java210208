package book_ch7;

public class TwoArray {
	void init() {
		int is[][] = {{1,2},{3,4},{5,6}};
		int x = 0;
		while(x<is.length) {
			int y = 0;
			while(y<is[x].length) {
				System.out.println("is["+x+"]["+y+"]="+is[x][y]);
				y = y + 1;
			}////////end of inner while
			x = x + 1;
		}
	}////////////////end of outter while

	public static void main(String[] args) {
		TwoArray ta6 = new TwoArray();
		ta6.init();
		System.out.println("======================================================================");
		//2는 로우를 말한다. 
		//3은 컬럼을 말한다.
		int is[][] = new int[2][3];
		for(int i=0;i<is.length;i++) {
			for(int j=0;j<is[i].length;j++) {
				System.out.println("is["+i+"]["+j+"]="+is[i][j]);
			}////end of inner for
		}////////end of outter for
	}

}
