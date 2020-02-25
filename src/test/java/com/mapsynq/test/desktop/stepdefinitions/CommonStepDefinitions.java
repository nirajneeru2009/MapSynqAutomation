package com.mapsynq.test.desktop.stepdefinitions;

import org.junit.Assert;

import com.mapsynq.test.desktop.page.HomePage;
import com.mapsynq.test.testbase.TestBase;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class CommonStepDefinitions extends TestBase {

	protected static HomePage homePage;

	/**
	 * runs before each test
	 */
	@Before
	public void setup() {
		TestBase.init(false);
		homePage = new HomePage();
		homePage.closeAd();
	}

	/**
	 * perform basic initialization task
	 */
	public CommonStepDefinitions() {
		super();
	}

	@Given("^User already navigated to url$")
	public void user_already_navigated_to_url() throws Throwable {

		// Get the title of the home page from HomePage validateHomePageTitle method
		String title = homePage.getHomePageTitle();

		// Assert the title with expected title
		// Read the expected value from configuration file
		String mainPageTitle = prop.getProperty("home.page.title");
		Assert.assertEquals(mainPageTitle, title);

		homePage.clickMapIncidentsViewButton();
	}

	@Then("^User clicks on Live button$")
	public void user_clicks_on_Live_button() throws Throwable {
		// Click on info panel live button
		homePage.clickInfopanelLiveButton();
	}

	/**
	 * runs after each test
	 */
	@After
	public void cleanup() {
		super.cleanup();
	}

}
