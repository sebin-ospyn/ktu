package com.ospyn.ktu.util;

import java.io.File;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class GenerateExtentReport {
	ExtentReports report;//specify the location of the report
	static ExtentTest test;//what details should be populated in the report


	public GenerateExtentReport()
	{

		//report=new ExtentReports(System.getProperty("user.dir")+"/target/Report.html",true);
		report=new ExtentReports(System.getProperty("user.dir")+"/target/Report.html",true);
		report.addSystemInfo("Host Name","Ospyn");
		report.addSystemInfo("Environment","QA");
		report.addSystemInfo("User Name","Automation");
		report.loadConfig(new File(System.getProperty("user.dir")+"/extent_config.xml"));

	}
	public void beginTest(String str)
	{
		test=report.startTest(str);

	}

	public void setLog(LogStatus status,String msg)
	{
		test.log(status,msg);

	}

	public void addScreenShotToLog(String screenshotName)
	{
//	test.addScreenCapture(screenshotName);
		test.log(LogStatus.FAIL, test.addScreenCapture(screenshotName));

	}
	public void endTest()
	{
		report.endTest(test);
	}


public void endReport()
	{
		report.flush();
	}
}
