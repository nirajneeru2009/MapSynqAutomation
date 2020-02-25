package com.mapsynq.test.mobile.stepdefinitions;

import org.junit.Assert;

import com.mapsynq.test.mobile.page.HomePage;
import com.mapsynq.test.testbase.TestBase;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;

public class CommonStepDefinitions extends TestBase {

	protected static HomePage homePage;

	/**
	 * runs before each test
	 */
	@Before
	public void setup() {
		TestBase.init(true);
		homePage = new HomePage();
		homePage.closeAd();
	}

	/**
	 * perform basic initialization task
	 */
	public CommonStepDefinitions() {
		super();
	}

	@Given("^User already navigated to url in mobile browser$")
	public void user_already_navigated_to_url_in_mobile_browser() throws Throwable {
		// Get the title of the home page from HomePage validateHomePageTitle method
		String title = homePage.getHomePageTitle();

		// Assert the title with expected title
		// Read the expected value from configuration file
		String mainPageTitle = prop.getProperty("mobile.home.page.title");
		Assert.assertEquals(mainPageTitle, title);
		System.out.println("*****************" + mainPageTitle);

	}

	/**
	 * runs after each test
	 */
	@After
	public void cleanup() {
		super.cleanup();
	}

}
