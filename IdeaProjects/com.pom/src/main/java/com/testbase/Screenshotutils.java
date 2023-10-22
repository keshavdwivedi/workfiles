package com.testbase;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

public class Screenshotutils implements ITestListener {
    
	public void onTestStart(ITestResult result) {
		
		PagefactoryBase.Test=PagefactoryBase.extent.startTest(result.getMethod().getMethodName()+" "+" test has been started");
	}

	public void onTestFailure(ITestResult result) {
		
		File src=((TakesScreenshot)PagefactoryBase.getbaseclassdriver()).getScreenshotAs(OutputType.FILE);
		   String srcimage=System.getProperty("user.dir")+"/target/screenshots/"+result.getMethod().getMethodName() +".png";
			File destinationPath = new File(srcimage);
			try {
				FileUtils.copyFile(src,destinationPath);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		PagefactoryBase.Test.log(LogStatus.FAIL,result.getName()+" "+" test has been failed",PagefactoryBase.Test.addScreenCapture(srcimage));
		System.out.println("screenshot taken");
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
	}
	
	public void onTestSuccess(ITestResult result) {
		
		PagefactoryBase.Test.log(LogStatus.PASS,result.getMethod().getMethodName()+" "+"has been successfully passed");
		
	}
}
