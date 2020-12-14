package com.youcodeGotTalent.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Config {

	private String url = "jdbc:mysql://localhost:3306/got_talent_db";
	private String username = "root";
	private String password = "";

	public Config(String url, String username, String password) {
		super();
		this.url = url;
		this.username = username;
		this.password = password;
	}

	public Config() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Connection connection() throws SQLException {

		Connection conn = DriverManager.getConnection(this.url, this.username, this.password);
		return conn;

	}

}
