package site0617.util;

public class FileManager {

	private FileManager() {
		// TODO Auto-generated constructor stub
	}
	
	//확장자만 추출하기
	public static String getExt(String path) {
		
		return path.substring(path.lastIndexOf(".")+1, path.length());
	}
}
