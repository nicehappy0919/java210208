package com.design;

import book_ch5.AddressBook2;

public class BaseBallGameLogic_ksy {
	int[] my = new int[3];
	static BaseBallGameView_ksy bbGame = new BaseBallGameView_ksy();
	
	public void nanSu(){
		bbGame.com[0] = (int)(Math.random()*10);
		do{
			bbGame.com[1] = (int)(Math.random()*10);
		}while(bbGame.com[0]==bbGame.com[1]);
		do{
			bbGame.com[2] = (int)(Math.random()*10);
		}while((bbGame.com[0]==bbGame.com[2])||(bbGame.com[1]==bbGame.com[2]));
		System.out.println(bbGame.com[0]+""+bbGame.com[1]+""+bbGame.com[2]);
	}	
	public String call(String input){
		//스트라이크를 카운트할 변수
		int strike = 0;
		//볼을 카운트할 변수
		int ball = 0;		
		int temp = 0;
		//반드시 세자리 숫자 이어야 한다.
		if(input.length()!=3){
			return "세자리 숫자만 입력하세요!!!";
		}
		temp = Integer.parseInt(input);
		my[0] = temp/100;//백자리를 받는다.
		my[1] = (temp%100)/10;//십자리를 받는다.
		my[2] = temp%10;
		for(int i=0;i<bbGame.com.length;i++){
			for(int j=0;j<my.length;j++){
				//같은 숫자가 존재하는 경우(볼확보)
				//컴퓨터가 채번한 숫자가 있는지 비교
				if(bbGame.com[i] == my[j]){
					//자리수까지도 일치하는 경우(스트라이크확보)
					//그 숫자가 존재하는 배열의 인덱스값을 비교
					if(i==j){
						strike++;
					}else{
						ball++;
					}
				}//  end of if          ////////////////
			}//////  end of inner for   ////////////////
		}//////////  end of outter for  ////////////////
		if(strike == 3) return "정답입니다.";
		return strike+"스트라이크" +ball+"볼";
}/////////////  end of call ////////////////////////
}
