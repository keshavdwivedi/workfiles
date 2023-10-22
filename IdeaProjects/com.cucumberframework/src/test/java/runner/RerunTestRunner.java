package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(features = "target/Report/rerun.txt",glue = {"basehelper", "com.framework.Pageobjects", "com.framework.steps"},
        plugin = {
                "pretty","json:target/FailedReports/JsonReport/report.json","junit:target/FailedReports/Junitreports/report.xml",
                "html:target/FailedReports/HTMLReport"},monochrome=true)
@Test
public class RerunTestRunner extends AbstractTestNGCucumberTests {

}
