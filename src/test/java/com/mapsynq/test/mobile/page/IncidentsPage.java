package com.mapsynq.test.mobile.page;

import org.openqa.selenium.By;

import com.mapsynq.test.testbase.TestBase;

public class IncidentsPage extends TestBase {

	/**
	 * get incident page title
	 * 
	 * @return incident page title
	 */
	public String getIncidentsPageTitle() {
		return driver.getTitle();
	}

	/**
	 * click on first incident on incidents page
	 * 
	 * @return new IncidentPage object
	 */
	public IncidentPage selectFirstIncident() {
		driver.findElement(By.xpath("//*[@id='listincident'][1]")).click();
		return new IncidentPage();
	}

	/**
	 * get first incident title
	 * 
	 * @return first incident title
	 */
	public String getFirstIncidentTitle() {
		return driver.findElement(By.xpath("//*[@id='listincident'][1]/div/div")).getText();
	}

}
