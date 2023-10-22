package com.base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.relevantcodes.extentreports.LogStatus;


public class Testspecification implements ITestListener{

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result){
		if(ITestResult.FAILURE==result.getStatus())
		{
			File src=((TakesScreenshot)Helper.Instance).getScreenshotAs(OutputType.FILE);
			String srcimage=System.getProperty("user.dir")+"/target/screenshots/"+result.getMethod().getMethodName() +".png";
			File destinationPath = new File(srcimage);
			try {
				FileUtils.copyFile(src,destinationPath);
			} catch (IOException e) {
				e.printStackTrace();
			}
			Helper.test.log(LogStatus.FAIL, result.getName()+" "+" test has been failed",Helper.test.addScreenCapture(srcimage));
			
		}
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult result) {
		Helper.test=Helper.extent.startTest(result.getMethod().getMethodName());
		Helper.test.log(LogStatus.INFO,result.getMethod().getMethodName()+"test has started");
		
	}

	public void onTestSuccess(ITestResult result) {
		Helper.test.log(LogStatus.PASS,result.getMethod().getMethodName()+"test has passed");
		
	}
}
