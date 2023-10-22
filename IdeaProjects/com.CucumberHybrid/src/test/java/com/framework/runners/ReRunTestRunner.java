package com.framework.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(features = "@target/Reports/rerun.txt",glue = {"com/framework/utils" ,"com/framework/stepDef"},tags = "@run",
        plugin = {
                "pretty","json:target/FailedReports/JsonReport/report.json","junit:target/FailedReports/Junitreports/report.xml",
                "html:target/FailedReports/HTMLReport"},
        monochrome=true)

@Test
public class ReRunTestRunner extends AbstractTestNGCucumberTests {
}
