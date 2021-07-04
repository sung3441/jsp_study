package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropsTest {

	Properties props;
	FileReader reader;
	String path = "D:\\workspace\\korea_jspworkspace\\study0630\\src\\main\\java\\test\\data.data";
	
	public PropsTest() {
		props = new Properties();
		try {
			reader = new FileReader(new File(path));
			props.load(reader);
			
			String name = props.getProperty("sungil");
			String hi = props.getProperty("hi");
			System.out.println(name);
			System.out.println(hi);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new PropsTest();
	}
}