package com.playdata.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import com.playdata.view.LoginView;
import com.playdata.view.ReserView;

public class Controller implements ActionListener {
	LoginView v_login;
	ReserView v_reserve;
	
	public Controller() {
		v_login = new LoginView();
		v_reserve = new ReserView();
		
		
		
		/*
		 * 작성자: 박진형
		 * 수정일자: 07/01 10:01
		 * 이벤트리스너 기능: LoginView (bt_login) click => ReserView
		 */
		v_login.bt_login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				v_login.setVisible(false);
				v_reserve.setVisible(true);
			}
		}); //bt_login actionListener
		
		/*
		 * 작성자: 박진형
		 * 수정일자: 07/01 10:19
		 * 이벤트리스너 기능: ReserveSubView Action Listener 추가
		 */
		for(int i=0; i<v_reserve.subv_reserve.length; i++)
			for(int j=0; j<v_reserve.subv_reserve[i].tbt_stars.length;j++)
				v_reserve.subv_reserve[i].tbt_stars[j].addActionListener(this);
	}//생성자
	
	public static void main(String[] args) {
		new Controller();
	}
	
	/*
	 * 작성자: 박진형
	 * 수정일자: 07/01 12:35
	 * 이벤트리스너 기능: ReserveSubView에서 Selected된 별의 이미지 변경
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		for(int i=0; i<v_reserve.subv_reserve.length;i++) {
			for(int j=0; j<v_reserve.subv_reserve[i].tbt_stars.length;j++) {
				if(ob == v_reserve.subv_reserve[i].tbt_stars[j]) {
					if(v_reserve.subv_reserve[i].tbt_stars[j].isSelected())
						v_reserve.setstarSelected(i, j);
					else
						v_reserve.setstarSelected(i, j);
				}
			}//for-j
		}//for-i
	}
}
