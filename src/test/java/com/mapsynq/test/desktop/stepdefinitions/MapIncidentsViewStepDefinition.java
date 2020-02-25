package com.mapsynq.test.desktop.stepdefinitions;

import org.testng.Assert;

import com.mapsynq.test.testbase.TestBase;

import cucumber.api.java.en.Then;

public class MapIncidentsViewStepDefinition extends TestBase {
	/**
	 * perform basic initialization task
	 */
	public MapIncidentsViewStepDefinition() {
		super();
	}

	@Then("^User clicks on Incidents button$")
	public void user_click_on_Incidents_button() throws Throwable {
		// Click on traffic button and load map - traffic view
		CommonStepDefinitions.homePage.clickMapIncidentsViewButton();
	}

	@Then("^Display incidents view on map$")
	public void display_incidents_view_on_map() throws Throwable {
		// Check whether incident icons are displayed on map and verify map incidents
		// view
		Assert.assertNotEquals(CommonStepDefinitions.homePage.validateMapIncidentsView(), 0,
				"Incident icons are not displayed");
	}

}
