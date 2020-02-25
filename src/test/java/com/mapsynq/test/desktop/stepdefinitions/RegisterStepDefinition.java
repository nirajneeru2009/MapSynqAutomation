package com.mapsynq.test.desktop.stepdefinitions;

import org.junit.Assert;

import com.mapsynq.test.desktop.page.RegisterPage;
import com.mapsynq.test.testbase.TestBase;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterStepDefinition extends TestBase {

	RegisterPage registerPage;

	/**
	 * perform basic initialization task
	 */
	public RegisterStepDefinition() {
		super();

	}

	@When("^User clicks on Register link$")
	public void user_click_on_Register_link() throws Throwable {
		// Click on Register link
		registerPage = CommonStepDefinitions.homePage.clickRegisterLink();
	}

	@Then("^Directs user to Register page$")
	public void directs_user_to_Register_page() throws Throwable {
		// Get the title of the register page from RegisterPage
		// validateRegisterPageTitle method

		String title = registerPage.validateRegisterPageTitle();

		// Assert the title with expected title
		// Read the expected value from config file
		String registerPageTitle = prop.getProperty("register.page.title");
		Assert.assertEquals(registerPageTitle, title);
	}

	@Then("^User enters valid details and click on create profile button$")
	public void user_enter_valid_details_and_click_on_create_profile_button() throws Throwable {
		// Register new user using RegisterPage createProfile method
		registerPage.createProfile();
	}

	@Then("^System registers new user successfully$")
	public void system_registers_new_user_successfully() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("directs_user_to_Register_page");
	}

}
