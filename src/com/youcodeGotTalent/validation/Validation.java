package com.youcodeGotTalent.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

	public boolean emailValidation(String email) {
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);

		return matcher.matches();

	}

	public boolean passwordValidation(String password) {

		String regex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(password);

		return matcher.matches();

	}

	public boolean phoneValidation(String phone) {

		String regex = "\\+\\d{3}\\d{9}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(phone);

		return matcher.matches();

	}

}
