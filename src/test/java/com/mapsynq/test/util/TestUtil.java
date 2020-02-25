package com.mapsynq.test.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.mapsynq.test.testbase.TestBase;

public class TestUtil extends TestBase {

	/**
	 * take screenshot of screen
	 * 
	 * @throws IOException
	 */
	public static void takeScreenshot() throws IOException {
		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");

		FileUtils.copyFile(sourceFile, new File(currentDir + "/screenshots/"
				+ new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date()) + ".png"));

	}

}
