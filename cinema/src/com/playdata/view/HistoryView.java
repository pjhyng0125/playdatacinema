package com.playdata.view;

import javax.swing.JFrame;
/*
 * 사용내역뷰
 */
public class HistoryView extends JFrame {
	public HistoryView() {
		setTitle("HistoryView");
		
		setSize(1200, 800);
		setVisible(true);
	}//생성자
	public static void main(String[] args) {
		new HistoryView();
	}
}
