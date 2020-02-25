package com.mapsynq.test.util;

import java.io.BufferedWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Random;

public class ProfileGenerator {
	private static Random r = new Random();
	private static String alphabet = "abcdefghijklmnopqrstuvwxyz";
	private static String numbers = "0123456789";
	private static Charset charset = StandardCharsets.UTF_8;

	/**
	 * Generate a profile with random data
	 * 
	 * @return generated profile
	 */
	public static RandomProfile getRandomProfile() {
		RandomProfile randomProfile = new RandomProfile();
		randomProfile.setFirstName(getRandomText());
		randomProfile.setLastName(getRandomText());
		randomProfile.setCountry("Singapore");
		randomProfile.setAddress(getRandomText());
		randomProfile.setContact(getRandomNumber());
		randomProfile.setGender(r.nextBoolean());
		randomProfile.setDob("10-01-1990");
		randomProfile.setEmail(getRandomText() + "@example.com");
		randomProfile.setUsername(getRandomText());
		randomProfile.setPassword(getRandomText());
		saveToFile(randomProfile);
		return randomProfile;
	}

	/**
	 * Generate random text
	 * 
	 * @return generated text
	 */
	private static String getRandomText() {
		StringBuilder text = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			text.append(alphabet.charAt(r.nextInt(alphabet.length())));
		}
		return text.toString();
	}

	/**
	 * Generate random number
	 * 
	 * @return generated number
	 */
	private static String getRandomNumber() {
		StringBuilder number = new StringBuilder();
		for (int i = 0; i < 8; i++) {
			number.append(numbers.charAt(r.nextInt(numbers.length())));
		}
		return number.toString();
	}

	/**
	 * Save generated profile to test data file for future references
	 * 
	 * @param randomProfile
	 */
	private static void saveToFile(RandomProfile randomProfile) {
		Path path = Paths.get("src/test/resources/com/mapsynq/test/testdata/test-data.csv");
		try (BufferedWriter bw = Files.newBufferedWriter(path, charset, StandardOpenOption.CREATE,
				StandardOpenOption.APPEND)) {
			bw.write(randomProfile.toString());
			bw.newLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
