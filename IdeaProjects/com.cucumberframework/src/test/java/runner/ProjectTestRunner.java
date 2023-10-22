package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(features = {"src/test/java/com/framework/featurefiles"},
        glue = {"basehelper", "com.framework.Pageobjects", "com.framework.steps"},
        plugin = {"pretty", "json:target/Report/JsonReport/report.json", "junit:target/Report/Junitreports/report.xml",
                "html:target/Report/HTMLReport","rerun:target/Report/rerun.txt"})

@Test
public class ProjectTestRunner extends AbstractTestNGCucumberTests {

}
	

