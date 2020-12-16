package com.youcodeGotTalent.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.youcodeGotTalent.config.Config;
import com.youcodeGotTalent.models.AdminSession;
import com.youcodeGotTalent.models.Participation;
import com.youcodeGotTalent.models.User;

public class AdminController {

	// Admin Controller

	public void adminConnect(String email, String password) throws SQLException {

		String defaultEmail = "ahmed.mahmoud.admin@gmail.com";
		String defaultPassword = "ahmed@mahmoud&admin";

		if (email.equals(defaultEmail) && password.equals(defaultPassword)) {
			System.out.println("Access Granted! Welcome!");
			AdminSession session = new AdminSession();
			session.adminConnection(true);
		}
	}

	// findAllUser Method

	public ArrayList<User> findAllUser() throws SQLException {

		ArrayList<User> users = new ArrayList<User>();

		Config conn = new Config();
		conn.connection();

		String sql = "select * from user";
		PreparedStatement statement = ((Connection) conn).prepareStatement(sql);
		ResultSet rs = statement.executeQuery(sql);

		while (rs.next()) {

			users.add(new User(rs.getString("fist_name"), rs.getString("last_name"), rs.getString("email"),
					rs.getString("phone")));
		}
		return users;

	}

	// findParticipation Method

	public ArrayList<Participation> findParticipation() throws SQLException {

		ArrayList<Participation> listParticipation = new ArrayList<Participation>();

		Config conn = new Config();
		conn.connection();
		String sql = "select * from participation";
		PreparedStatement statement = ((Connection) conn).prepareStatement(sql);
		ResultSet rs = statement.executeQuery(sql);

		while (rs.next()) {

			listParticipation.add(new Participation(rs.getLong("id_user"), rs.getLong("id_category"),
					rs.getString("description"), rs.getTimestamp("show_start_time"), rs.getTimestamp("show_end_time"),
					rs.getString("file"), rs.getBoolean("is_accepted")));
		}
		return listParticipation;

	}

	// findParticipationByUserEmail Method

	public String findParticipationByUserEmail(String email) throws SQLException {
		Config conn = new Config();
		conn.connection();
		String sql = "select * from user " + "WHERE email = ?";

		// Get user id from user table using the email

		PreparedStatement statement = ((Connection) conn).prepareStatement(sql);
		statement.setString(1, email);
		ResultSet rs = statement.executeQuery(sql);
		int id_user = rs.getInt("id");

		// check if id_user not null

		if (id_user != 0) {

			String sql2 = "select * from participation " + "WHERE id = ?";
			PreparedStatement statement2 = ((Connection) conn).prepareStatement(sql);
			statement2.setLong(1, id_user);
			ResultSet rs2 = statement2.executeQuery(sql2);

			String participationFound = "";

			participationFound = rs2.getString("id_user") + " " + rs2.getString("id_category") + " "
					+ rs2.getString("description") + " " + rs2.getString("show_start_time") + " "
					+ rs2.getString("show_end_time") + " " + rs2.getString("is_accepted");

			return participationFound;
		}
		return "Participation not found ";

	}

	// validateParticipation Method

	public void validateParticipation(long id_user) throws SQLException {

		// Check if id exist in table

		Config conn = new Config();
		conn.connection();

		String sql = "select * from participation " + "WHERE id = ?";
		PreparedStatement statement = ((Connection) conn).prepareStatement(sql);
		statement.setLong(1, id_user);
		ResultSet rs = statement.executeQuery(sql);
		if (rs.isBeforeFirst()) {

			String sql2 = "UPDATE participation " + "is_accepted = ? " + "WHERE id = ?";
			PreparedStatement statement2 = ((Connection) conn).prepareStatement(sql2);
			statement2.setBoolean(1, true);
			statement2.setLong(2, id_user);
			statement2.executeUpdate();

			// Send mail to user

		}

	}
}
