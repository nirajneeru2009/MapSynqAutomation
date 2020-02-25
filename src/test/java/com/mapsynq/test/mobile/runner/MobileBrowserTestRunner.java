package com.mapsynq.test.mobile.runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/com/mapsynq/test/mobile/feature/", glue = {
		"com.mapsynq.test.mobile.stepdefinitions" }, dryRun = false, format = { "pretty", "html:test-output",
				"json:json-output/cucumber.json",
				"junit:junit-xml/cucumber.xml" }, monochrome = true, strict = true, tags = {
						"@FunctionalTest" }, plugin = {
								"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" })

public class MobileBrowserTestRunner {

	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File("src/test/resources/com/mapsynq/test/config/extent-config.xml"));
	}

}
