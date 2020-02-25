package com.mapsynq.test.mobile.page;

import org.openqa.selenium.By;

import com.mapsynq.test.testbase.TestBase;

public class TrafficCamerasPage extends TestBase {

	/**
	 * select a traffic camera from list
	 * 
	 * @param cameraName
	 * @return TrafficCameraPage object
	 */
	public TrafficCameraPage selectTrafficCamera(String cameraName) {
		driver.findElement(By.linkText(cameraName)).click();
		return new TrafficCameraPage();
	}

	/**
	 * get traffic camera page title
	 * 
	 * @return traffic camera page title
	 */
	public String getTrafficCamerasPageTitle() {
		return driver.getTitle();
	}
}
