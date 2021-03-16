package book_ch4;

public class SwitchTest {

	public static void main(String[] args) {
		int protocol = 100;//로그인
		protocol = 200;//입장하기
		protocol = 300;//다자간대화
		protocol = 301;//귓속말1:1채팅
		String id = "tomato";
		String input = "오늘 스터디 할까?";
		String msg = protocol + "#"+id+"#"+input;
		//제어문의 역할 은 업무 선서에 대한 흐름을 바군다.
		//순서에 대한 정보를 바탕으로 의사를 결정할 수 있는 것은 팀장, 차장, 부장 선택자
		//선택(비즈니스로직계층-Model계층)에 따라
		//break <-> continue
		//break가 continue보다 훨씬 많이 쓰인다. 
		//for문, while,.....무한루프를 방지하기 위해서 break가 쓰인다.
		//if문에서는 break 대신에 return이다. -return을 만나면 if문이 아니라 메소드를 탈출한다.
		//switch문에서의 break는 switch문을 탈출
		switch(protocol) {//원시형타입 + String타입
		case 0:
			//실행문
			System.out.println("0입니다.");
			break;
		case 301:
			//실행문
			System.out.println("301입니다.");
			break;
		case 100:
			//실행문
			System.out.println("100입니다.");
			break;
		default:
			//실행문
			System.out.println("default 입니다.");
		}///////end of switch
		System.out.println("여기");
	}

}
