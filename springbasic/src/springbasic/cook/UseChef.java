package springbasic.cook;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseChef {

	public static void main(String[] args) {
		
		//선언적 방법으로 객체들간의 관계를 명시한 xml을 해석 및 실행할 객체를 생성하자
		//xml의 위치를 클래스패스로 접근하여 해당 xml에 있는 bean들을 인스턴스화 시켜 관리해주는
		//객체인 applicationContext를 생성하는 코드
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/config/context.xml");
		
		Chef chef = (Chef)context.getBean("chef");
		chef.cook();
	}
}
