package com.framework.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(features = "src/test/java/com/framework/features",glue = {"com/framework/utils" ,"com/framework/stepDef"},
        plugin = {
                "pretty","json:target/Reports/JsonReport/report.json","junit:target/Reports/Junitreports/report.xml","html:target/Reports/HTMLReport",
                "rerun:target/Reports/rerun.txt"},
        monochrome=true)

@Test
public class ProjectRunner extends AbstractTestNGCucumberTests {
}
