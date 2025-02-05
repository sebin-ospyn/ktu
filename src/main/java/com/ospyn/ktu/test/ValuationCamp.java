package com.ospyn.ktu.test;

import static org.testng.AssertJUnit.assertEquals;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ospyn.ktu.util.DriverConfig;
import com.ospyn.ktu.util.GenerateExtentReport;
import com.ospyn.ktu.util.Screenshot;
import com.ospyn.ktu.util.ViewLogin;
import com.ospyn.ktu.view.ViewValuationCamp;
import com.relevantcodes.extentreports.LogStatus;

public class ValuationCamp extends DriverConfig
{
//	Creating reference to ViewvaluationCamp
	ViewValuationCamp valuationcampview;
//	Creating reference for Log In
	static ViewLogin login;
//	Creating reference for extracting  screenshots of failed tests
	Screenshot screenshot;
//	Creating static variable for adding details to log
	String details;
//	Creating reference for creating Extent Reports
	GenerateExtentReport report=Login.report;
//	Creating reference for driver
	WebDriver driver;
//creating a static variable for assigning the test name  before each test
			static String[] testName;
			private String testValue;
			private String resultValue;

public ValuationCamp() throws IOException
			{
				/*initializing..
//				 * ExtentReport--> Using a class GenerateExte
//				 * WebDriver---> Using the DriverConfig class in the util package
//				 *
//				 */
				screenshot=new Screenshot();
				driver=getDriver();
				report=Login.report;
				valuationcampview = new ViewValuationCamp(driver);

			}

@BeforeTest
public void getTestName(final ITestContext testContext)
{
	String test=testContext.getName(); // gets the test name assigned in the xml file
	testName=test.split("-");
//	System.out.println(testName[0]+" "+testName[1]);
}
//*********************************************************************************************
@Test
public void User_click_on_valuation_module() throws InterruptedException
{
	report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User click on module valuation </i>");
	valuationcampview.getValuation().sendKeys(Keys.ENTER);
	Thread.sleep(500);
	details="False number generation page displayed";
}
@Test
public void User_click_on_valuation_camp() throws InterruptedException
{
	report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User click on  valuation camp menu</i>");
	valuationcampview.getValuationCamp().sendKeys(Keys.ENTER);
	Thread.sleep(500);
	details="valuation camp listing page displayed";
}
@Test
public void User_validating_valuation_camp_page() throws InterruptedException
{
	report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User validating valuation camp listing page  </i>");
	testValue = "Valuation Camps";
	resultValue =valuationcampview.valdtngValuationCamp();
	assertEquals(testValue, resultValue);
	Thread.sleep(500);
	details="User validated valuation camp listing page";
}

@Test
public void User_click_add_button() throws InterruptedException    {
	report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User click add button  </i>");
	valuationcampview.addclick();
	details="Valuation camp page will get displayed while click on add button";
}
@Test
public void User_entering_details_in_valutionCamp_configuring_Page()
{
	report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User entering details in valution configuring page  </i>");
	valuationcampview.cnfgrValtnCamp();
	details="Camp configuring details entered";
}
@Test
public void User_enetring_memberprovidingExaminers_answersheets() throws AWTException, InterruptedException
{
	report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User entering details in members providing answersheets and examiners  </i>");
	valuationcampview.answesheetsExaminers();
	details="Camp configuring details entered";
}

@Test
public void User_checking_chiefenabled_check_box()
{
	report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User checking chief enabled check box  </i>");
	valuationcampview.checkBox();
	details="Camp configuring details entered";
}
@Test
public void User_click_on_save_button() throws InterruptedException
{
	report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User click on save button </i>");
valuationcampview.saveCamp();
details="camp saved";
}

@Test
public void User_searching_created_camp() throws AWTException, InterruptedException
	{
	report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User searching created camp </i>");
	valuationcampview.campSearching();
	details="camp searching";
	}
@Test
public void User_validating_created_camp()
	{
	report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User validating created camp </i>");
 	valuationcampview.campValidating();
	details="camp validated";
	}

@Test
public void User_changing_camp_status() throws InterruptedException, AWTException
	{
	report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User changing camp status from created to opened </i>");
	valuationcampview.campStatus();
	details="camp opened";


	}
@Test
public void User_validating_camp_status() throws InterruptedException, AWTException
	{
	report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User validating camp status </i>");
	valuationcampview.validateCampStatus();
	details="camp status validated";
	}
@Test
public void User_editing_created_camp()
	{
	report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User edit exisiting created camp </i>");
	valuationcampview.campEditing();
	details="camp edited";
	}






//**********************************************************************************************
@AfterMethod
//writing the status to the report
public void getResult(ITestResult result)
{
	//if the testing is a failure
	if(result.getStatus()==ITestResult.FAILURE)
	{
		//Using details of date and time for naming the screenshot
		String dateName = new SimpleDateFormat("ddMMyyyy_hhmmss").format(new Date());

		//capturing screenshot of the failed method
		String screenshotName=result.getMethod().getMethodName()+"-"+dateName+".jpg";

		screenshot.captureScreenshot(screenshotName, driver);

		//Adding screenshot to the report for the failed test
		report.addScreenShotToLog(System.getProperty("user.dir")+"/Screenshots/"+screenshotName);
	}

	//if testing is successful
	else if(result.getStatus()==ITestResult.SUCCESS)
	{
		report.setLog(LogStatus.PASS, details);
	}

	//if testing is skipped
	else if(result.getStatus()==ITestResult.SKIP)
	{
		report.setLog(LogStatus.SKIP, "Skipped");
	}
	//Ending the test
	report.endTest();

}
@AfterSuite
public void endTest() throws IOException
{
	//closing the report
	report.endReport();

	//Renaming the report by adding date and time to the report
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH:mm:ss");
	LocalDateTime now = LocalDateTime.now();

	File oldFile=new File(System.getProperty("user.dir")+"/target/Report.html");

	String fileName=System.getProperty("user.dir")+"/target/ValuationCamp_"+dtf.format(now)+".html";
	File newFile=new File(fileName);

	//Renaming the report with new name

	System.out.println(oldFile.renameTo(newFile));

	//Opening the report
//	Desktop.getDesktop().browse(new File(fileName).toURI());
}

}
