package springbasic.gui;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseMyFrame {

	public static void main(String[] args) {
		ApplicationContext context = null;
		context = new ClassPathXmlApplicationContext("springbasic/gui/gui.xml");
		MyFrame myFrame = (MyFrame) context.getBean("myFrame");
		myFrame.init();
	}
}
