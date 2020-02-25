package com.mapsynq.test.mobile.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.mapsynq.test.testbase.TestBase;

public class HomePage extends TestBase {

	// Page Factory / Object Repository of HomePage
	@FindBy(how = How.XPATH, using = "//img[@alt='Button_later']")
	WebElement laterButton;

	@FindBy(how = How.XPATH, using = "//div[@class='mobile_sprite sprite-mobile_camera']")
	WebElement trafficCameraButton;

	@FindBy(how = How.XPATH, using = "//div[@class='mobile_sprite sprite-mobile_parking']")
	WebElement parkingButton;

	@FindBy(how = How.XPATH, using = "//div[@class='mobile_sprite sprite-mobile_me']")
	WebElement loginButton;

	@FindBy(how = How.XPATH, using = "//div[@class='mobile_sprite sprite-mobile_toll']")
	WebElement tollsButton;

	@FindBy(how = How.XPATH, using = "//div[@class='mobile_sprite sprite-mobile_camera']")
	WebElement camerasButton;

	@FindBy(how = How.XPATH, using = "//div[@class='mobile_sprite sprite-incidentmobile']")
	WebElement roadConditionssButton;

	/**
	 * initialize the HomePage page factory using PageFactory class initElement
	 * method
	 */
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * click on login button
	 * 
	 * @return new login page object
	 */
	public LoginPage clickLoginButton() {
		loginButton.click();
		return new LoginPage();
	}

	/**
	 * close main page ad
	 */
	public void closeAd() {
		laterButton.click();
	}

	/**
	 * get home page title
	 * 
	 * @return home page title
	 */
	public String getHomePageTitle() {
		return driver.getTitle();
	}

	/**
	 * click camera button
	 * 
	 * @return new TrafficCamerasPage object
	 */
	public TrafficCamerasPage clickCamerasButton() {
		camerasButton.click();
		return new TrafficCamerasPage();
	}

	/**
	 * click incident button
	 * 
	 * @return new IncidentsPage
	 */
	public IncidentsPage clickIncidentsButton() {
		roadConditionssButton.click();
		return new IncidentsPage();
	}

	/**
	 * check whether my account button available in home page
	 * 
	 * @return true if my account button available in home page
	 */
	public boolean checkMyAccountIconAvailability() {
		return driver.findElement(By.xpath("//div[@class='mobile_sprite sprite-mobile_me']")).isDisplayed();
	}

}
