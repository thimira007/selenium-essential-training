package com.linkedin.learning.testrunners;

import io.cucumber.testng.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"com.linkedin.learning.stepdefinitions", "com.linkedin.learning.hooks"},
        tags = "@ScenarioOutlineExample",
        plugin = {"pretty",
                "html:target/testReports/html",
                "json:target/testReports/json/report.json",
                "junit:target/testReports/junit/report.xml"}
)
public class MenuManagementTest extends AbstractTestNGCucumberTests {

}
