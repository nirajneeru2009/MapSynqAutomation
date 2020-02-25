package com.mapsynq.test.desktop.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.mapsynq.test.testbase.TestBase;

public class SigninPage extends TestBase {

	// Page Factory / Object Repository of HomePage
	@FindBy(how = How.XPATH, using = "//input[@id='name']")
	WebElement usernameField;

	@FindBy(how = How.XPATH, using = "//input[@id='password']")
	WebElement passwordFlield;

	@FindBy(how = How.XPATH, using = "//input[@value='Sign In']")
	WebElement submitButton;

	/**
	 * Initialize the SigninPage page factory using PageFactory class initElement
	 * method
	 */
	public SigninPage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * get sign in page title
	 * 
	 * @return sign in page title
	 */
	public String getSigninPageTitle() {
		return driver.getTitle();
	}

	/**
	 * sign in using username and password
	 * 
	 * @param username
	 *            username
	 * @param password
	 *            password
	 * @return new home page object
	 */
	public HomePage signin(String username, String password) {
		usernameField.sendKeys(username);
		passwordFlield.sendKeys(password);
		submitButton.click();
		return new HomePage();
	}

	/**
	 * verify sign up success message
	 * 
	 * @return true if sign up success
	 */
	public boolean verifySigninMessage() {
		return driver.findElement(By.xpath("//*[@id=\"notice\"]")).getText().toUpperCase()
				.contains(prop.getProperty("desktop.successfull.register.text").toUpperCase());
	}

}
