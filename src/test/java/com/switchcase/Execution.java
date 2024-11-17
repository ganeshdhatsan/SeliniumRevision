package com.switchcase;

import org.testng.annotations.Test;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Execution extends BaseClass {

	// Example patterns for validation (you can modify these based on your
	// requirements)
	private static final String PHONE_NUMBER_REGEX = "\\b\\d{3}[-.]?\\d{3}[-.]?\\d{4}\\b";
	private static final String URL_REGEX = "\\b(https?|ftp|file):\\/\\/[-A-Za-z0-9+&@#/%?=~_|!:,.;]*[-A-Za-z0-9+&@#/%=~_|]";
	private static final String DATE_REGEX = "\\b\\d{2}/\\d{2}/\\d{4}\\b";

	private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile(PHONE_NUMBER_REGEX);
	private static final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);
	private static final Pattern DATE_PATTERN = Pattern.compile(DATE_REGEX);

	// Method to validate phone numbers in email content
	public static boolean containsPhoneNumber(String content) {
		Matcher matcher = PHONE_NUMBER_PATTERN.matcher(content);
		return matcher.find();
	}

	// Method to validate URLs in email content
	public static boolean containsUrl(String content) {
		Matcher matcher = URL_PATTERN.matcher(content);
		return matcher.find();
	}

	// Method to validate dates in email content
	public static boolean containsDate(String content) {
		Matcher matcher = DATE_PATTERN.matcher(content);
		return matcher.find();
	}

	public static void main(String[] args) {
		// Sample email content
		String emailContent = "Hello,Please visit our website at https://www.example.com."
				+ "You can also call us at 123-456-7890." + "Our meeting is scheduled for 12/25/2024." + "Best regards,"
				+ "Example Company";

		// Validate content
		boolean hasPhoneNumber = containsPhoneNumber(emailContent);
		boolean hasUrl = containsUrl(emailContent);
		boolean hasDate = containsDate(emailContent);

		// Print validation results
		System.out.println("Contains phone number: " + hasPhoneNumber);
		System.out.println("Contains URL: " + hasUrl);
		System.out.println("Contains date: " + hasDate);
	}

	private void urlLauch() {

		browerLaunch("edge", "Browerser Launched Succesfully");
		driver.get("https://www.facebook.com/");

	}
	
	@Test
	private void test() {
		runSwitch('M');

	}

	private void runSwitch(char name) {
		switch (name) {
		case 'M':
System.out.println("Char ");
			break;
			
		case 'G':

			break;

		default:
			break;
		}

	}

}
