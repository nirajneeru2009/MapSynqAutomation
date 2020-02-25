package com.mapsynq.test.mobile.stepdefinitions;

import org.testng.Assert;

import com.mapsynq.test.mobile.page.TrafficCameraPage;
import com.mapsynq.test.mobile.page.TrafficCamerasPage;
import com.mapsynq.test.testbase.TestBase;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LiveTrafficCameraStepDefinition extends TestBase {

	TrafficCamerasPage trafficCamerasPage;
	TrafficCameraPage trafficCameraPage;
	String selectedCameraName;

	/**
	 * perform basic initialization task
	 */
	public LiveTrafficCameraStepDefinition() {
		super();
	}

	@When("^User clicks on traffic camera button$")
	public void user_clicks_on_traffic_camera_button() throws Throwable {
		trafficCamerasPage = CommonStepDefinitions.homePage.clickCamerasButton();
	}

	@Then("^Directs user to traffic cameras page$")
	public void directs_user_to_traffic_cameras_page() throws Throwable {
		// Get the title of the login page from LoginPage validate login page title
		// method

		String title = trafficCamerasPage.getTrafficCamerasPageTitle();

		// Assert the title with expected title
		// Read the expected value from configuration file
		String trafficCamerasPageTitle = prop.getProperty("mobile.traffic.camera.page.title");
		Assert.assertEquals(trafficCamerasPageTitle, title);
	}

	@Then("^User clicks on a traffic camera$")
	public void user_clicks_on_a_traffic_camera() throws Throwable {
		trafficCameraPage = trafficCamerasPage.selectTrafficCamera(prop.getProperty("mobile.selected.camera"));
	}

	@Then("^Systems displays live image$")
	public void systems_displays_live_image() throws Throwable {
		Assert.assertEquals(trafficCameraPage.getTrafficCameraName(), prop.getProperty("mobile.selected.camera"));
		Assert.assertTrue(trafficCameraPage.validateTrafficCameraImage());
	}

}
