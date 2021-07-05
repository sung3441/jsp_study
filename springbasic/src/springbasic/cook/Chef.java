package springbasic.cook;

//요리사를 정의한다.
public class Chef {

	private Pan pan; //has a 관계
	
	public Chef() {
		//pan = new FriPan(); //직접 생성할 필요 x
		//new 연산자 뒤에는 정확한 자료형을 명시해야 하기 때문에
		//chef와 fripan간 결합도가 너무 강해진다! 따라서 
	}
	
	public void setPan(Pan pan) {
		this.pan = pan;
	}
	
	//요리를 만든다
	public void cook() {
		pan.warm();
	}
}