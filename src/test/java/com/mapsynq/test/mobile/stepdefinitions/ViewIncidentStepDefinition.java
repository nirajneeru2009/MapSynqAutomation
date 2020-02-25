package com.mapsynq.test.mobile.stepdefinitions;

import org.testng.Assert;

import com.mapsynq.test.mobile.page.IncidentPage;
import com.mapsynq.test.mobile.page.IncidentsPage;
import com.mapsynq.test.testbase.TestBase;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ViewIncidentStepDefinition extends TestBase {

	IncidentPage incidentPage;
	IncidentsPage incidentsPage;
	String selectedIncidentTitle;

	/**
	 * perform basic initialization task
	 */
	public ViewIncidentStepDefinition() {
		super();
	}

	@When("^User clicks on traffic road conditions button$")
	public void user_clicks_on_traffic_road_conditions_button() throws Throwable {
		incidentsPage = CommonStepDefinitions.homePage.clickIncidentsButton();
	}

	@Then("^Directs user to traffic road conditions page$")
	public void directs_user_to_traffic_road_conditions_page() throws Throwable {
		Assert.assertEquals(incidentsPage.getIncidentsPageTitle(), prop.getProperty("mobile.incidents.page.title"));
	}

	@Then("^User select an incident$")
	public void user_select_an_incident() throws Throwable {
		selectedIncidentTitle = incidentsPage.getFirstIncidentTitle();
		incidentPage = incidentsPage.selectFirstIncident();

	}

	@Then("^Display incident location on map$")
	public void display_incident_location_on_map() throws Throwable {
		Assert.assertEquals(incidentPage.getIncidentTitle().replace("\n", ""), selectedIncidentTitle.replace("\n", ""));
	}

}
