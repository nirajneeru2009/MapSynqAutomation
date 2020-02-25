package com.mapsynq.test.desktop.stepdefinitions;

import org.junit.Assert;

import com.mapsynq.test.desktop.page.SigninPage;
import com.mapsynq.test.testbase.TestBase;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SigninStepDefinition extends TestBase {

	SigninPage signinPage;

	/**
	 * perform basic initialization task
	 */
	public SigninStepDefinition() {
		super();
	}

	@When("^User clicks on Sign in link$")
	public void user_click_on_Sign_in_link() throws Throwable {
		// Click on Sign In link
		signinPage = CommonStepDefinitions.homePage.clickSigninLink();
	}

	@Then("^Directs user to Sign in page$")
	public void directs_user_to_Sign_in_page() throws Throwable {
		// Get the title of the Sign in page from SigninPage validateSigninPageTitle
		// method
		String title = signinPage.getSigninPageTitle();

		// Assert the title with expected title
		// Read the expected value from config file
		String signinPageTitle = prop.getProperty("signin.page.title");
		Assert.assertEquals(signinPageTitle, title);
	}

	@Then("^User enters valid \"([^\"]*)\" and \"([^\"]*)\" click on sign-in button$")
	public void user_enter_valid_and_click_on_sign_in_button(String username, String password) throws Throwable {
		CommonStepDefinitions.homePage = signinPage.signin(username, password);
	}

	@Then("^User Sign in successfully$")
	public void user_Sign_in_successfully() throws Throwable {
		// Get the logged user's name from HomePage validateLoggedUser method

		String loggedUser = CommonStepDefinitions.homePage.getLoggedUser();

		// Assert the title with expected title
		// Read the expected value from config file
		String username = prop.getProperty("username");
		Assert.assertEquals(loggedUser, username);
	}

}
