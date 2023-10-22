package com.parellelFramework.reportUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterUtils {

    static ExtentReports extentReporter;

    public static ExtentReports extentReportGenerator(){

        String path=System.getProperty("user.dir")+"/Extent-reports/index.html";
        ExtentSparkReporter sparkReporter=new ExtentSparkReporter(path);
        sparkReporter.config().setReportName("Demo insurance Test report");
        sparkReporter.config().setDocumentTitle("Parallel test execution");
        sparkReporter.config().setTheme(Theme.DARK);

        extentReporter=new ExtentReports();
        extentReporter.attachReporter(sparkReporter);
        extentReporter.setSystemInfo("OS NAME",System.getProperty("os.name"));
        extentReporter.setSystemInfo("JAVA VERSION",System.getProperty("java.version"));
        extentReporter.setSystemInfo("MAVEN VERSION",System.getProperty("3.6.3"));
        extentReporter.setSystemInfo("USER LOCATION",System.getProperty("user.country"));
        extentReporter.setSystemInfo("USER TIME",System.getProperty("user.timezone"));
        return extentReporter;
    }
}
