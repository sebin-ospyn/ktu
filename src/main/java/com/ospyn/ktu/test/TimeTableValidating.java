package com.ospyn.ktu.test;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import com.ospyn.ktu.view.KTUWebElements;
import com.ospyn.ktu.view.ViewTimeTableValidating;
import com.relevantcodes.extentreports.LogStatus;

public class TimeTableValidating extends DriverConfig{

//	creating reference to ViewTimeTableValidating
	ViewTimeTableValidating TimeTableValidatingview;

//	Creating reference for log in
	static ViewLogin login;

//Creating reference for creating Extent Reports
	static GenerateExtentReport report=Login.report;

//Creating reference for extracting  screenshots of failed tests
		Screenshot screenshot;

//Creating static variable for adding details to log
		static String details;

		//Creating reference for driver
		WebDriver driver;
		WebElement element;
		KTUWebElements webelement;
		//creating a variable for assigning the test name  before each test
		String[] testName;

	public TimeTableValidating () throws IOException  {
		/*initializing..
//		 * ExtentReport-->Using a class GenerateExtentReport class in the util package
//		 * WebDriver--->Using the DriverConfig class in the util package
//		 *
//		 */
	driver=getDriver();
	webelement=new KTUWebElements(driver);
	report=Login.report;
	screenshot=new Screenshot();
	TimeTableValidatingview=new ViewTimeTableValidating(driver);

	}

	@BeforeTest
	public void getTestName(final ITestContext testContext)
	{

		String test=testContext.getName(); // gets the test name assigned in the xml file
		testName=test.split("-");

	}
//*******************************************************************************
	@Test
	public void click_Exam_Tab()throws Exception
	{
		Thread.sleep(1000);
		System.out.println("Within university");
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User verify Exam Tab is enabled or not by clicking on the button.");
		element=webelement.getExam();
		element.click();

		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		details="The administration side menu is displayed";
	}
	@Test
	public void click_ExamDefinition()
	{

		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User clicks the Exam Definition option  from the side menu" );
		webelement.getExamDefinition().click();
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{

		}
		details="The Exam Definition Listing page is displayed";

	}
	@Test
	public void exam_Selection() throws Exception
	{

		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User enters the exam details" );

		TimeTableValidatingview.enterDetails();

		details="The exam details are entered";

	}
	@Test
	public void click_Search_Button()
	{

		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User clicks the Search button" );
		webelement.getSearch().click();
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{

		}
		details="The exams satisfying the criteria are displayed";

	}
	@Test
	public void click_List_Timetable()
	{

		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User clicks the List Timetable button" );


		try
		{
			Thread.sleep(1000);
			TimeTableValidatingview.listTimeTableButton().click();
			Thread.sleep(1000);
		}
		catch(Exception e)
		{

		}
		details="The timetable definition page is displayed";

	}

	@Test
	public void user_validating_timeTable() throws InterruptedException {

		Thread.sleep(1000);
		TimeTableValidatingview.validatingTimetable();
		Thread.sleep(1000);
	}







































//	********************************************************************************************
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

		String fileName=System.getProperty("user.dir")+"/target/TimeTable_Validating_"+dtf.format(now)+".html";
		File newFile=new File(fileName);

		//Renaming the report with new name

		System.out.println(oldFile.renameTo(newFile));

		//Opening the report
//		Desktop.getDesktop().browse(new File(fileName).toURI());
	}


}
