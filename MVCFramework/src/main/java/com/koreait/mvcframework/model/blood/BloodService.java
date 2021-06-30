package com.koreait.mvcframework.model.blood;

public class BloodService {

	//웹이건 응용이건 이 메서드를 호출하는 자는 혈액형을 넘기면, 알아서 판단하여 결과 반환
	public String getAdvice(String blood) {
		String msg = null;
		//넘겨받은 혈액형에 대한 판단 결과 도출
		if(blood.equals("A")){
			msg = "소심하고 꼼꼼하고 책임감 강함";
		}else if(blood.equals("B")){
			msg = "고집 쎔";
		}else if(blood.equals("O")){
			msg = "오지랖";
		}else if(blood.equals("AB")){
			msg = "천재";
		}
		
		return msg;
	}
}
