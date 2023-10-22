package com.parellelFramework.reportUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.parellelFramework.tests.TestSetup;
import com.parellelFramework.utilities.CommonUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ExtentReportListener extends TestSetup implements ITestListener{

     ExtentReports reporter;
     ExtentTest extentTest;

    public void onTestStart(ITestResult result) {

        reporter=ExtentReporterUtils.extentReportGenerator();
        extentTest=reporter.createTest(result.getMethod().getMethodName());
        extentTest.log(Status.INFO,result.getMethod().getMethodName()+" has been started");

    }

    public void onTestSkipped(ITestResult result) {

      extentTest.log(Status.INFO,result.getMethod().getMethodName()+ "has been skipped");
    }


    public void onTestSuccess(ITestResult result) {

        extentTest.log(Status.PASS,result.getMethod().getMethodName()+" has been successfully completed");

    }

    public void onTestFailure(ITestResult result) {

       if (result.getStatus()==ITestResult.FAILURE){
           extentTest.log(Status.FAIL,result.getMethod().getMethodName()+"has been failed");
           CommonUtils.TakeScreenshot(result.getMethod().getMethodName(),driver);
       }
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onStart(ITestContext context) {

    }

    public void onFinish(ITestContext context) {

    }

}
