package com.mapsynq.test.desktop.stepdefinitions;

import org.junit.Assert;

import com.mapsynq.test.testbase.TestBase;

import cucumber.api.java.en.Then;

public class InfoLiveTollsStepDefinition extends TestBase {

	/**
	 * perform basic initialization task
	 */
	public InfoLiveTollsStepDefinition() {
		super();
	}

	@Then("^User clicks Tolls button on Live panel$")
	public void user_clicks_Tolls_button_on_Live_panel() throws Throwable {
		// Click on tolls button
		CommonStepDefinitions.homePage.clickLiveTollsButton();
	}

	@Then("^User clicks on a toll$")
	public void user_clicks_on_a_toll() throws Throwable {
		// Click on toll name specified on configuration file
		CommonStepDefinitions.homePage.selectToll("Anson Road");
	}

	@Then("^Display toll popup with correct toll name$")
	public void display_toll_popup_with_correct_toll_name() throws Throwable {
		// Verify whether toll pop up displayed with correct toll name
		Assert.assertTrue(CommonStepDefinitions.homePage.validateLiveTolls(prop.getProperty("desktop.selected.toll")));
	}

}
