package com.incubyte.runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.incubyte.base.BaseTestCase;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(monochrome = true, features = "src/test/resources/feature/", dryRun = false, glue = {
		"com/incubyte/stepdef/" }, tags = "@Test")

public class Runner extends BaseTestCase {
	@BeforeClass
	public static void setupBeforeClass() {
		System.out.println("Launching Browser...");
	}

	@AfterClass
	public static void teardown() throws Exception {
		tearDown();
	}

}
