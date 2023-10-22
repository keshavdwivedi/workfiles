package com.Guru99telecom.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;


@CucumberOptions(features = "src/main/resources/featureFiles",glue = {"com/Guru99telecom/Baseutils" ,"com/Guru99telecom/stepDefs"},
        plugin = {
                "pretty","json:target/Reports/JsonReport/report.json","junit:target/Reports/Junitreports/report.xml","html:target/Reports/HTMLReport"},
        monochrome=true)

@Test
public class TestRunner extends AbstractTestNGCucumberTests {

}
