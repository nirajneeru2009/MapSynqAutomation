package com.mapsynq.test.desktop.stepdefinitions;

import org.testng.Assert;

import com.mapsynq.test.testbase.TestBase;

import cucumber.api.java.en.Then;

public class MapCamerasViewStepDefinition extends TestBase {
	/**
	 * perform basic initialization task
	 */
	public MapCamerasViewStepDefinition() {
		super();
	}

	@Then("^User clicks on Cameras button$")
	public void user_clicks_on_Cameras_button() throws Throwable {
		// Click on cameras button and load map - cameras view
		CommonStepDefinitions.homePage.clickMapCameraViewButton();
	}

	@Then("^Display cameras view on map$")
	public void display_cameras_view_on_map() throws Throwable {
		// Check whether cameras icons are displayed on map and verify map cameras view
		Assert.assertNotEquals(CommonStepDefinitions.homePage.validateMapCameraView(), 0,
				"Camera icons are not displayed");
	}

}
