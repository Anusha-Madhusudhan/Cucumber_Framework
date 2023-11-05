/**
 * 
 */
package com.tekarch.testRunner;

import org.junit.runner.RunWith;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/**
 * com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:
 */
// "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/com/tekarch/featureFiles"},
                    glue="com.tekarch.stepDefinitions",
                    monochrome = true,
                    plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                    		"pretty","html:target/cucumber.html","json:target/cucumber.json"},
                    dryRun = false)
public class TestRnnerClass {
	

}
