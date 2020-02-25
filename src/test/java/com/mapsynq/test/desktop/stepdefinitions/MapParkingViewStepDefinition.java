package com.mapsynq.test.desktop.stepdefinitions;

import org.testng.Assert;

import com.mapsynq.test.testbase.TestBase;

import cucumber.api.java.en.Then;

public class MapParkingViewStepDefinition extends TestBase {
	/**
	 * perform basic initialization task
	 */
	public MapParkingViewStepDefinition() {
		super();
	}

	@Then("^User clicks on Parking button$")
	public void user_clicks_on_Parking_button() throws Throwable {
		// Click on parking button and load map - parking view
		CommonStepDefinitions.homePage.clickMapParkingViewButton();
	}

	@Then("^Display parking view on map$")
	public void display_parking_view_on_map() throws Throwable {
		// Check whether parking icons are displayed on map and verify map parking view
		Assert.assertNotEquals(CommonStepDefinitions.homePage.validateMapParkingView(), 0,
				"Parking icons are not displayed");
	}

}
