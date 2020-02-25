package com.mapsynq.test.mobile.page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mapsynq.test.testbase.TestBase;

public class TrafficCameraPage extends TestBase {

	/**
	 * check whether traffic camera image displayed
	 * 
	 * @return true if traffic camera image displayed
	 */
	public boolean validateTrafficCameraImage() {
		return driver.findElement(By.xpath("//*[@id='pageCameraList']/div[@role='main']/div[@class='geo-content']/img"))
				.isDisplayed();
	}

	/**
	 * get traffic camera name
	 * 
	 * @return get traffic camera name
	 */
	public String getTrafficCameraName() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(
				driver.findElement(By.xpath("//*[@id='pageCameraList']/div[@role='main']/div[@class='geo-content']"))));
		String title = driver
				.findElement(By.xpath("//*[@id='pageCameraList']/div[@role='main']/div[@class='geo-content']"))
				.getText();
		return title;
	}

}
