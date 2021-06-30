package test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropsTest {
	Properties props; //key-value의 쌍으로 된 데이터를 이해하는 객체
	FileReader reader;
	String path = "D:\\workspace\\korea_jspworkspace\\MVCFramework\\src\\main\\webapp\\WEB-INF\\mapping.data";
	
	public PropsTest() {
		props = new Properties();
		try {
			props.load(reader = new FileReader(path));//props객체가 파일을 인식한 시점
			String msg = (String)props.get("zerg");
			System.out.println(msg);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new PropsTest();
	}
}
