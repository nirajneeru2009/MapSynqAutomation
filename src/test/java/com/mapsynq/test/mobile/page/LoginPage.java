package com.mapsynq.test.mobile.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.mapsynq.test.testbase.TestBase;

public class LoginPage extends TestBase {

	// Page Factory / Object Repository of LoginPage
	@FindBy(how = How.XPATH, using = "//input[@id='name']")
	WebElement usernameField;

	@FindBy(how = How.XPATH, using = "//input[@id='password']")
	WebElement passwordField;

	@FindBy(how = How.XPATH, using = "//*[@id='loginForm']/a[@onclick='login()']")
	WebElement loginButton;

	/**
	 * Initialize the SigninPage page factory using PageFactory class initElement
	 * method
	 */
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * login using username and password
	 * 
	 * @param username
	 *            username
	 * @param password
	 *            password
	 * @return new HomePage object
	 */
	public HomePage login(String username, String password) {
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginButton.click();
		return new HomePage();
	}

	/**
	 * get login page title
	 * 
	 * @return login page title
	 */
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

}
