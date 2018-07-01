package com.playdata.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.playdata.view.LoginView;
import com.playdata.view.ReserView;

public class Controller {
	LoginView v_login;
	ReserView v_reserve;
	
	public Controller() {
		v_login = new LoginView();
		v_reserve = new ReserView();
		
		v_login.bt_login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				v_login.setVisible(false);
				v_reserve.setVisible(true);
			}
		});
	}
	
	public static void main(String[] args) {
		new Controller();
	}
}
