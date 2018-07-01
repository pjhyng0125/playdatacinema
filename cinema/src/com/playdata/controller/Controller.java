package com.playdata.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import com.playdata.view.LoginView;
import com.playdata.view.ReserView;

public class Controller {
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
		 * 이벤트리스너 기능: ReserveSubView에서 평점의 별 click 관련 이벤트 정의
		 */
		for(int i=0; i<v_reserve.subv_reserve.length; i++) {
			v_reserve.subv_reserve[i].tbt_stars[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					for(int i=0; i<v_reserve.subv_reserve.length;i++) {
						for(int j=0; j<v_reserve.subv_reserve[i].tbt_stars.length;j++) {
								v_reserve.subv_reserve[i].tbt_stars[j].setSelectedIcon(new ImageIcon("image/star_yellow.png"));
//								System.out.println("i="+i+" j="+j+" k="+k );
						}//for - j
					}//for - i
					
					
				}//actionPerformed
			});//addActionLister
		}//for
	}//생성자
	
	public static void main(String[] args) {
		new Controller();
	}
}
