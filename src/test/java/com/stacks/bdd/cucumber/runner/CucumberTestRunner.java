package com.stacks.bdd.cucumber.runner;

import com.stacks.bdd.constants.core.SystemProperties;
import com.vimalselvam.cucumber.listener.Reporter;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = {"src/test/resources/com/stacks/bdd/cucumber/features"},
	glue={
		"com.stacks.bdd.cucumber.stepdefs",
		"com.stacks.bdd.cucumber.hooks"
	},



	strict=true,
	monochrome=true,
	plugin={
			"pretty",
		"json:cucumber-json-report.json",
		"html:cucumber-html-report.html",
			"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/reports/cucumber/extent-Report/extent.html"
	}
)

public class CucumberTestRunner {

	@AfterClass
	public static void writeExtentReport() {
			Reporter.loadXMLConfig(new File(SystemProperties.getReportConfigPath()));
			Reporter.setSystemInfo("user", System.getProperty("user.name"));
	}
}
