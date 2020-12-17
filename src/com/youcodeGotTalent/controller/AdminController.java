package com.youcodeGotTalent.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.youcodeGotTalent.config.Config;
import com.youcodeGotTalent.models.AdminSession;
import com.youcodeGotTalent.models.Participation;
import com.youcodeGotTalent.models.User;
import com.youcodeGotTalent.smtpMail.SendMail;

public class AdminController {

	// Admin Controller
	Config conn = new Config();

	public AdminController() {
		Config conn = new Config();
	}

	public void adminConnect(String email, String password) throws SQLException {

		String defaultEmail = "ahmed.mahmoud.admin@gmail.com";
		String defaultPassword = "BELCAID@1234&bel";

		if (email.equals(defaultEmail) && password.equals(defaultPassword)) {
			System.out.println("Access Granted! Welcome!");
			AdminSession session = new AdminSession();
			session.adminConnection();
		}
	}

	// findAllUser Method

	public ArrayList<User> findAllUser() throws SQLException {

		ArrayList<User> users = new ArrayList<User>();

		String sql = "select * from user";
		PreparedStatement statement = conn.connection().prepareStatement(sql);
		ResultSet rs = statement.executeQuery(sql);

		while (rs.next()) {

			users.add(new User(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"),
					rs.getString("email"), rs.getString("phone")));
		}
		return users;

	}

	// findParticipation Method

	public ArrayList<Participation> findParticipation() throws SQLException {

		ArrayList<Participation> listParticipation = new ArrayList<Participation>();

		String sql = "select * from participation";
		PreparedStatement statement = conn.connection().prepareStatement(sql);
		ResultSet rs = statement.executeQuery(sql);

		while (rs.next()) {

			listParticipation.add(new Participation(rs.getLong("id_user"), rs.getLong("id_category"),
					rs.getString("description"), rs.getTimestamp("show_start_time"), rs.getTimestamp("show_end_time"),
					rs.getString("attached_file"), rs.getBoolean("is_accepted")));
		}
		return listParticipation;

	}

	// findParticipationByUserEmail Method

	public ArrayList<Participation> findParticipationByUserEmail(String email) throws SQLException {

		ArrayList<Participation> listParticipationByEmail = new ArrayList<Participation>();

		String sql = "select * from user where email = '" + email + "' ";

		// Get user id from user table using the email

		PreparedStatement statement = conn.connection().prepareStatement(sql);
		ResultSet rs = statement.executeQuery(sql);

		int id_user = 0;
		while (rs.next()) {
			id_user = rs.getInt("id");

		}

		String sql2 = "select * from participation WHERE id_user = '" + id_user + "'";

		PreparedStatement statement2 = conn.connection().prepareStatement(sql2);
		ResultSet rs2 = statement2.executeQuery(sql2);

		while (rs2.next()) {

			listParticipationByEmail.add(new Participation(rs2.getLong("id_user"), rs2.getLong("id_category"),
					rs2.getString("description"), rs2.getTimestamp("show_start_time"),
					rs2.getTimestamp("show_end_time"), rs2.getString("attached_file"), rs2.getBoolean("is_accepted")));
		}
		return listParticipationByEmail;

	}

	// validateParticipation Method

	public void validateParticipation(long id_user, long id_category) throws SQLException {

		// Check if id exist in table

		String sql = "select * from participation  WHERE id_user = '" + id_user + "' AND id_category = '" + id_category
				+ "'AND is_accepted = 0 ";
		PreparedStatement statement = conn.connection().prepareStatement(sql);
		ResultSet rs = statement.executeQuery(sql);
		if (rs.isBeforeFirst()) {

			String sql2 = "UPDATE participation SET is_accepted = 1 WHERE id_user ='" + id_user + "'";
			PreparedStatement statement2 = conn.connection().prepareStatement(sql2);
			statement2.executeUpdate();
			System.out.println("User Accepted \n");

			// Get the user Email :D

			String sql3 = "select * from user where id = '" + id_user + "' ";

			// Get user id from user table using the email

			PreparedStatement statement3 = conn.connection().prepareStatement(sql3);
			ResultSet rs3 = statement3.executeQuery(sql3);
			String email = "";
			while (rs3.next()) {
				email = rs3.getString("email");

			}

			// Send mail to user

			String USER_NAME = "belcaidtestmail"; // GMail user name (just the part before "@gmail.com")
			String PASSWORD = "BELCAID@1221"; // GMail password
			String RECIPIENT = email; // User Email

			String from = USER_NAME;
			String pass = PASSWORD;
			String[] to = { RECIPIENT }; // list of recipient email addresses
			String subject = "YouCode got Talent";
			String body = "Congratulations you have been selected to participate in YouCode got Talent 2020";
			SendMail.sendFromGMail(from, pass, to, subject, body);
		}

	}

	public boolean checkAdminIsLogged() throws SQLException {

		String sql = "select * from adminsession WHERE id_administrator = 15970010";
		PreparedStatement statement = conn.connection().prepareStatement(sql);
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			if (rs.getBoolean("is_connected") == true) {
				return true;
			} else {
				return false;
			}
		}
		return false;

	}

}
