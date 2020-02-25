package com.mapsynq.test.desktop.stepdefinitions;

import org.testng.Assert;

import com.mapsynq.test.testbase.TestBase;

import cucumber.api.java.en.Then;

public class MapTrafficViewStepDefinition extends TestBase {
	/**
	 * perform basic initialization task
	 */
	public MapTrafficViewStepDefinition() {
		super();
	}

	@Then("^User clicks on Traffic button$")
	public void user_click_on_Trafic_button() {
		// Click on traffic button and load map - traffic view
		CommonStepDefinitions.homePage.clickMapTrafficViewButton();
	}

	@Then("^Display traffic view on map$")
	public void display_traffic_view_on_map() {
		// Check whether 'Live Traffic' legend displayed on map and verify map traffic
		// view
		Assert.assertTrue(CommonStepDefinitions.homePage.validateMapTrafficView());
	}

}
