package com.youcodeGotTalent.app;

import java.sql.SQLException;

import com.youcodeGotTalent.config.Config;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		Config cnx = new Config();
		try {
			cnx.connection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
