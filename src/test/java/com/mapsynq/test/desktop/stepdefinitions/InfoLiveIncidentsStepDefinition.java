package com.mapsynq.test.desktop.stepdefinitions;

import org.junit.Assert;

import com.mapsynq.test.testbase.TestBase;

import cucumber.api.java.en.Then;

public class InfoLiveIncidentsStepDefinition extends TestBase {

	@Then("^User clicks Incidents button on Live panel$")
	public void user_clicks_Incidents_button_on_Live_panel() throws Throwable {
		// Click on incidents button
		CommonStepDefinitions.homePage.clickLiveIncidentsButton();
	}

	@Then("^User clicks on an incident$")
	public void user_clicks_on_an_incident() throws Throwable {
		// Click on first incident
		CommonStepDefinitions.homePage.selectIncident();
	}

	@Then("^Display popup with correct incident details$")
	public void display_popup_with_correct_incident_details() throws Throwable {
		// Verify whether incident pop up displayed with correct incident details
		Assert.assertTrue(CommonStepDefinitions.homePage.validateLiveIncident());
	}

}
