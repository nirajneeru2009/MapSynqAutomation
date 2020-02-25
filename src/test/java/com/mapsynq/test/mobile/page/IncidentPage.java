package com.mapsynq.test.mobile.page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mapsynq.test.testbase.TestBase;

public class IncidentPage extends TestBase {

	/**
	 * get incident page title
	 * 
	 * @return incident page title
	 */
	public String getIncidentTitle() {
		// explicitly wait until incident title get available on page
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='geo_content']/p"))));

		return driver.findElement(By.xpath("//*[@id='geo_content']/p")).getText();
	}

}
