package com.koreait.model2app.exception;

public class LicenseRegistException extends RuntimeException{

	//sun에서 제공해준 예외 만으로 모든 경우의 수의 상세하고 디테일한
	//예외를 처리할 수 없는 경우
	//개발자만의 예외를 커스터 마이징 할 수 있다. 이때의 언어에서
	//강요하지 않는 Runtime 예외를 상속받아 처리한다.
	public LicenseRegistException(String message) {
		super(message);
	}
	
	//Throwable은 예외 api의 최상위 인터페이스
	public LicenseRegistException(String message, Throwable e) {
		super(message, e);
	}
	
	public static void main(String[] args) {
		//자바의 예외는 처리를강요하는 에러(SQLException)와 
		//강요하지 않는 예외가 있다(ArrayIndexOutofException).
	}
}
