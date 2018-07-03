package com.playdata.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import com.playdata.view.LoginView;
import com.playdata.view.ReView;
import com.playdata.view.ReserView;
import com.playdata.view.ScheduleView;

public class Controller implements ActionListener {
	LoginView v_login;
	ReserView v_reserve;
	ReView v_review;
	ScheduleView v_schedule;
	
	public Controller() {
		v_login = new LoginView();
		v_reserve = new ReserView();
		v_review = new ReView();
		v_schedule = new ScheduleView();
		
/*-------------------------------------EVENT LISTENER(�͸�)------------------------------------------*/
		/*
		 * �ۼ���: ������
		 * ��������: 07/01 10:01
		 * �̺�Ʈ������ ���: ReserView => reView
		 */
		for(int i=0; i<v_reserve.subv_reserve.length; i++)
			v_reserve.subv_reserve[i].bt_reserve.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					v_reserve.setVisible(false);
					v_schedule.setVisible(true);
				}
			});
		
		/*
		 * �ۼ���: ������
		 * ��������: 07/01 10:01
		 * �̺�Ʈ������ ���: LoginView (bt_login) click => ReserView
		 */
		v_login.bt_login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				v_login.setVisible(false);
				v_reserve.setVisible(true);
			}
		}); //bt_login actionListener
		
		/*
		 * �ۼ���: ������
		 * ��������: 07/01 10:19
		 * �̺�Ʈ������ ���: ReserveSubView Action Listener �߰�
		 */
		for(int i=0; i<v_reserve.subv_reserve.length; i++)
			for(int j=0; j<v_reserve.subv_reserve[i].tbt_stars.length;j++)
				v_reserve.subv_reserve[i].tbt_stars[j].addActionListener(this);
	}//������
	
	public static void main(String[] args) {
		new Controller();
	}
	
	/*
	 * �ۼ���: ������
	 * ��������: 07/01 12:35
	 * �̺�Ʈ������ ���: ReserveSubView���� Selected�� ���� �̹��� ����
	 */
	
/*-------------------------------------EVENT LISTENER(actionPerformed)------------------------------------------*/
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
	}//actionPerformed
}
