package com.youcodeGotTalent.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Scanner;

import com.youcodeGotTalent.config.Config;
import com.youcodeGotTalent.models.ParticipationModels;

public class ParticipationController {

	Config conn = new Config();

	Scanner scanner = new Scanner(System.in);

	public void UserParti() throws SQLException {

		ParticipationModels partiMod = new ParticipationModels();

		System.out.println("Enter the User ID :");

		long userId = scanner.nextLong();

		partiMod.setId_user(userId);

		System.out.println("Enter the Category ID :");

		long categoryId = scanner.nextLong();

		partiMod.setId_category(categoryId);

		System.out.println("Enter the Participation Description :");

		String descParti = scanner.next();

		partiMod.setDescription(descParti);

		System.out.println("Type start to Start");

		String test = scanner.next();

		LocalDateTime timeStart = LocalDateTime.now();

		partiMod.setShow_start_time(timeStart);

		System.out.println("Type end to End");

		String test1 = scanner.next();

		LocalDateTime timeEnd = LocalDateTime.now();

		partiMod.setShow_end_time(timeEnd);

		String sql1 = "insert into participation (id_user, id_categorie, desc_parti, show_start_time, show_end_time, attached_file, is_accepted) values('"
				+ userId + "', '" + categoryId + "', '" + descParti + "', '" + timeStart + "', '" + timeEnd
				+ "', 'test', '0')";

		PreparedStatement stm1 = conn.connection().prepareStatement(sql1);

		int row1 = stm1.executeUpdate();

		if (row1 > 0) {

			System.out.println("Your Praticipation is Added");

			String sql3 = "select * from users where id = '" + userId + "'";

			Statement stm3 = conn.connection().createStatement();

			ResultSet res3 = stm3.executeQuery(sql3);

			while (res3.next()) {

				System.out.println("Your Informations are :" + res3.getString("id") + " " + res3.getString("first_name")
						+ " " + res3.getString("last_name") + " " + res3.getString("email") + " "
						+ res3.getString("phone"));

			}

		}

	}

	public void OtherParti() throws SQLException {

		ParticipationModels partiOth = new ParticipationModels();

		System.out.println("Enter the User ID :");

		Long userId = scanner.nextLong();

		partiOth.setId_user(userId);

		System.out.println("Enter the Category ID :");

		Long ctgId = scanner.nextLong();

		partiOth.setId_category(ctgId);

		String sql = "select * from participation where id_user = '" + userId + "' and id_categorie = '" + ctgId + "'";

		PreparedStatement stm = conn.connection().prepareStatement(sql);

		ResultSet res = stm.executeQuery();

		if (res.next()) {

			long test = res.getLong("id_user");

			long test1 = res.getLong("id_categorie");

			if (test == userId && test1 == ctgId) {

				System.out.println("User Already Participate in this Category");

			}

		} else {

			System.out.println("Enter the Participation Description :");

			String descParti = scanner.next();

			partiOth.setDescription(descParti);

			System.out.println("Type start to Start");

			String t = scanner.next();

			LocalDateTime timeStart = LocalDateTime.now();

			partiOth.setShow_start_time(timeStart);

			System.out.println("Type end to End");

			String t1 = scanner.next();

			LocalDateTime timeEnd = LocalDateTime.now();

			partiOth.setShow_end_time(timeEnd);

			String sql1 = "insert into participation (id_user, id_categorie, desc_parti, show_start_time, show_end_time, attached_file, is_accepted) values('"
					+ userId + "', '" + ctgId + "', '" + descParti + "', '" + timeStart + "', '" + timeEnd
					+ "', 'test', '0')";

			PreparedStatement stm1 = conn.connection().prepareStatement(sql1);

			int row1 = stm1.executeUpdate();

			if (row1 > 0) {

				System.out.println("You Participate in Other Category");

				String sql3 = "select * from users where id = '" + userId + "'";

				Statement stm3 = conn.connection().createStatement();

				ResultSet res3 = stm3.executeQuery(sql3);

				while (res3.next()) {

					System.out.println("Your Informations are :" + res3.getString("id") + " "
							+ res3.getString("first_name") + " " + res3.getString("last_name") + " "
							+ res3.getString("email") + " " + res3.getString("phone"));

				}

			}

		}

	}

}
