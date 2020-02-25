package com.mapsynq.test.desktop.stepdefinitions;

import org.testng.Assert;

import com.mapsynq.test.testbase.TestBase;

import cucumber.api.java.en.Then;

public class MapTollsViewStepDefinition extends TestBase {
	/**
	 * perform basic initialization task
	 */
	public MapTollsViewStepDefinition() {
		super();
	}

	@Then("^User clicks on Tolls button$")
	public void user_clicks_on_Tolls_button() throws Throwable {
		// Click on tolls button and load map - tolls view
		CommonStepDefinitions.homePage.clickMapTollViewButton();
	}

	@Then("^Display tolls view on map$")
	public void display_tolls_view_on_map() throws Throwable {
		// Check whether tolls icons are displayed on map and verify map tolls view
		Assert.assertNotEquals(CommonStepDefinitions.homePage.validateMapTollView(), 0,
				"Tolls icons are not displayed");
	}

}
