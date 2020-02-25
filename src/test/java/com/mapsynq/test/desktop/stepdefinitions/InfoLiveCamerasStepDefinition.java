package com.mapsynq.test.desktop.stepdefinitions;

import org.junit.Assert;

import com.mapsynq.test.testbase.TestBase;

import cucumber.api.java.en.Then;

public class InfoLiveCamerasStepDefinition extends TestBase {

	/**
	 * perform basic initialization task
	 */
	public InfoLiveCamerasStepDefinition() {
		super();
	}

	@Then("^User clicks Cameras button on Live panel$")
	public void user_clicks_Cameras_button_on_Live_panel() throws Throwable {
		// Click on tolls button
		CommonStepDefinitions.homePage.clickLiveCamerasButton();
	}

	@Then("^User clicks on a camera$")
	public void user_clicks_on_a_camera() throws Throwable {
		// Click on toll name specified on configuration file
		CommonStepDefinitions.homePage.selectCamera(prop.getProperty("desktop.selected.camera"));
	}

	@Then("^Display camera popup with correct camera name$")
	public void display_camera_popup_with_correct_camera_name() throws Throwable {
		// Verify whether toll pop up displayed with correct toll name
		Assert.assertTrue(
				CommonStepDefinitions.homePage.validateLiveCameras(prop.getProperty("desktop.selected.camera")));
	}

}
