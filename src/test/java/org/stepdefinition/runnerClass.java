package org.stepdefinition;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources", 
		glue = "org.stepdefinition", 
		plugin = {
		"json:target/myntra-report/myntra.json", 
		"html:target/myntra-report",
		"junit:target/mynta-report/myntra.xml"
		})

public class runnerClass {

}
