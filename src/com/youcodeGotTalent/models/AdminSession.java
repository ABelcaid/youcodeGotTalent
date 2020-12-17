package com.youcodeGotTalent.models;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.youcodeGotTalent.config.Config;

public class AdminSession {

	private long id;
	private long id_administrator;
	private Boolean is_connected;

	public AdminSession(long id, long id_administrator, Boolean is_connected) {
		super();
		this.id = id;
		this.id_administrator = id_administrator;
		this.is_connected = is_connected;
	}

	public AdminSession() {
		Config conn = new Config();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId_administrator() {
		return id_administrator;
	}

	public void setId_administrator(long id_administrator) {
		this.id_administrator = id_administrator;
	}

	public Boolean getIs_connected() {
		return is_connected;
	}

	public void setIs_connected(Boolean is_connected) {
		this.is_connected = is_connected;
	}

	// Admin connection methods

	public void adminConnection() throws SQLException {
		Config conn = new Config();
		conn.connection();

		String sql = "UPDATE adminsession SET is_connected = 1 WHERE id_administrator = 15970010";
		PreparedStatement statement = conn.connection().prepareStatement(sql);
//		statement.setBoolean(1, is_connected);
		statement.executeUpdate();

	}

	public void adminDeconnection() throws SQLException {
		Config conn = new Config();
		conn.connection();

		String sql = "UPDATE adminsession SET is_connected = 0 WHERE id_administrator = 15970010";
		PreparedStatement statement = conn.connection().prepareStatement(sql);
		statement.executeUpdate();

	}
}
