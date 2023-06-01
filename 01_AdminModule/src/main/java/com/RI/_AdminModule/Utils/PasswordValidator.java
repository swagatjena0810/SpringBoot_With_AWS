package com.RI._AdminModule.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class PasswordValidator {

	 public boolean validatePassword(String password) {
	        // Password must be at least 8 characters long
	        if (password.length() < 8) {
	            return false;
	        }

	        // Password must contain at least one uppercase letter
	        Pattern uppercasePattern = Pattern.compile("[A-Z]");
	        Matcher  uppercaseMatcher = uppercasePattern.matcher(password);
	        if (!uppercaseMatcher.find()) {
	            return false;
	        }

	        // Password must contain at least one lowercase letter
	        Pattern lowercasePattern = Pattern.compile("[a-z]");
	        Matcher lowercaseMatcher = lowercasePattern.matcher(password);
	        if (!lowercaseMatcher.find()) {
	            return false;
	        }

	        // Password must contain at least one digit
	        Pattern digitPattern = Pattern.compile("\\d");
	        Matcher digitMatcher = digitPattern.matcher(password);
	        if (!digitMatcher.find()) {
	            return false;
	        }

	        // Password must contain at least one special character
	        Pattern specialCharPattern = Pattern.compile("[!@#$%^&*(),.?\":{}|<>]");
	        Matcher specialCharMatcher = specialCharPattern.matcher(password);
	        if (!specialCharMatcher.find()) {
	            return false;
	        }

	        // All checks passed, password is valid
	        return true;
	    }
}
