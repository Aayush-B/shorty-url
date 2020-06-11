package com.shortyurl.shortyurl.services;

public class HashUrlService {

	private static char getCharFromValue(int value) {

		if ((value >= 0) && (value <= 25)) {
			return (char) (97 + value);
		}

		else if ((value >= 26) && (value <= 51)) {
			return (char) (65 + (value - 26));
		}

		else {
			return (char) (48 + (value - 52));
		}
	}

	private static Long getValueFromChar(char character) {

		int asciiValue = (int) character;

		if ((asciiValue >= 97) && (asciiValue <= 122)) {
			return (long) (asciiValue - 97);
		}

		else if ((asciiValue >= 65) && (asciiValue <= 90)) {
			return (long) (26 + (asciiValue - 65));
		}

		else {
			return (long) (52 + (asciiValue - 48));
		}
	}

	public static String encode(Long value) {

		String result = "";

		while (value != 0) {
			int rem = (int) (value % 62);

			result += getCharFromValue(rem);

			value = value / 62;
		}

		return result;
	}

	public static Long decode(String url) {

		long result = 0;

		for (int i = 0; i < url.length(); i++) {
			result += getValueFromChar(url.charAt(i)) * Math.pow(62, i);
		}

		return result;
	}
}
