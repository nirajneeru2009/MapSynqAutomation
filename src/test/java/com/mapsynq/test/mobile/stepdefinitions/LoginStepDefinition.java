package com.mapsynq.test.mobile.stepdefinitions;

import org.junit.Assert;

import com.mapsynq.test.mobile.page.HomePage;
import com.mapsynq.test.mobile.page.LoginPage;
import com.mapsynq.test.testbase.TestBase;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefinition extends TestBase {

	LoginPage loginPage;
	HomePage homePage;

	/**
	 * perform basic initialization task
	 */
	public LoginStepDefinition() {
		super();
	}

	@When("^User clicks on Login button$")
	public void user_clicks_on_Login_button() throws Throwable {
		// Click on Sign In link
		loginPage = CommonStepDefinitions.homePage.clickLoginButton();
	}

	@Then("^Directs user to Login page$")
	public void directs_user_to_Login_page() throws Throwable {
		// Get the title of the login page from LoginPage validate login page title
		// method

		String title = loginPage.getLoginPageTitle();

		// Assert the title with expected title
		// Read the expected value from configuration file
		String loginPageTitle = prop.getProperty("mobile.login.page.title");
		Assert.assertEquals(loginPageTitle, title);
	}

	@Then("^User enters valid \"([^\"]*)\" and \"([^\"]*)\" click on login button$")
	public void user_enters_valid_and_click_on_login_button(String username, String password) throws Throwable {
		homePage = loginPage.login(username, password);
		homePage.closeAd();
	}

	@Then("^User login successfully$")
	public void user_login_successfully() throws Throwable {
		Assert.assertTrue(homePage.checkMyAccountIconAvailability());
	}

}
