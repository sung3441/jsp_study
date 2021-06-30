package com.koreait.mvcframework.view.blood;

import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.koreait.mvcframework.model.blood.BloodService;

public class BloodMain extends JFrame{
	
	JComboBox<String> ch;
	JButton bt;
	String[] arr = {"A", "B", "O", "AB"};
	BloodService bloodService;
	
	
	public BloodMain() {
		bloodService = new BloodService();
		ch = new JComboBox<String>(arr);
		bt = new JButton("결과보기");
		
		setLayout(new FlowLayout());

		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = bloodService.getAdvice((String)ch.getSelectedItem());
				JOptionPane.showMessageDialog(BloodMain.this, msg);
			}
		});
		
		add(ch);
		add(bt);
		
		setVisible(true);
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new BloodMain();
	}
}
