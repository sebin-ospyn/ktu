package com.ospyn.ktu.test;

import static org.testng.Assert.assertEquals;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ospyn.ktu.util.DriverConfig;
import com.ospyn.ktu.util.GenerateExtentReport;
import com.ospyn.ktu.util.Screenshot;
import com.ospyn.ktu.util.ViewLogin;
import com.ospyn.ktu.view.ViewDataProviderSample;
import com.relevantcodes.extentreports.LogStatus;


public class DataProviderSample extends DriverConfig implements ITestListener
{
	//creating reference to ViewCourseSelection
	ViewDataProviderSample attendanceView;

	//creating reference for Login
	static ViewLogin login;
	static Object[][] facultyData=new Object[6][2];
	//Creating reference for creating Extent Reports
	static GenerateExtentReport report;


	//Creating reference for extracting  screenshots of failed tests
	Screenshot screenshot;

	//Creating static variable for adding details to log
	String details;

	//Creating reference for driver
	WebDriver driver;

	WebElement element;

	//creating a static variable for assigning the test name  before each test
	static String[] testName;

	public DataProviderSample()
	{
		/*initializing..
//		 * ExtentReport-->Using a class GenerateExtentReport class in the util package
//		 * WebDriver--->Using the DriverConfig class in the util package
//		 *
//		 */
		report=Login.report;
		screenshot=new Screenshot();
		driver=getDriver();
		attendanceView=new ViewDataProviderSample(driver);
		facultyData=attendanceView.getFacultyData();

	}
	@BeforeTest
	public void getTestName(final ITestContext testContext)
	{

		String test=testContext.getName(); // gets the test name assigned in the xml file
		testName=test.split("-");

	}



	@Test
	public void click_Exam_Tab()

	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User clicks the exam tab</i>");
		//Getting Academic tab and clicking the tab
		attendanceView.getExam().sendKeys(Keys.ENTER);
		details="User navigates to the Exam Management page";
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.print(e);
		}

	}

	@Test

	public void click_Attendance_Internals()throws Exception
	{
		Thread.sleep(1000);
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User clicks course details from the side menu</i>");
		//Clicking on Course Details link from the side menu
		attendanceView.getAttendancseInternal().sendKeys(Keys.ENTER);
		details="User navigates to the Attendance Internals page";
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
	}
	@Parameters({"courseDetails"})
	@Test
	public void enter_Details(String courseDetails)throws Exception
	{
		Thread.sleep(1000);
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User enters the course details</i>");
		//Clicking on Course Details link from the side menu
		attendanceView.enterDetails(courseDetails);
		details="The details are entered";
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
	}

	@Test
	public void click_Search_Button()throws InterruptedException
	{

		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User clicks on the search button" );

		WebElement element=attendanceView.getSearch();
		element.click();

		details="The branches are listed";
		Thread.sleep(1000);
	}

	@Test
	public void click_Attendance_Button()throws InterruptedException
	{

		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User clicks on the students attendance/Internals button" );

		attendanceView.getAttendanceButton().click();

		details="The faculties are listed";
		Thread.sleep(1000);
	}

	@Test
	public void store_Faculty_Details()throws Exception
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User stores  the details of all faculties listed" );

		attendanceView.getFacultyDetails();

		details="The faculties are listed";
		Thread.sleep(1000);
	}

	@Test(dataProvider = "data-provider")

	public void facultyNames(String faculty,String Course)throws Exception
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />Marks Entered By:"+faculty+" <br>Course:"+Course );

		Thread.sleep(1000);

		report.setLog(LogStatus.PASS,"");
		//report.endTest();
		hello(faculty,Course);
		hello2(faculty,Course);

	}

	public void hello(String faculty,String Course)throws Exception
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />Hello1 By:"+faculty);

		Thread.sleep(1000);
		assertEquals(true, true);
		report.setLog(LogStatus.PASS,"");


	}
	public void hello2(String faculty,String Course)throws Exception
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />Hello2 By:"+faculty);

		Thread.sleep(1000);
		assertEquals(true, true);


	}

	@DataProvider(name = "data-provider")
	public Object[][] getFacultyDetails1()
	{

		return facultyData;
	}

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

		String fileName=System.getProperty("user.dir")+"/target/Attendance_"+dtf.format(now)+".html";
		File newFile=new File(fileName);
		//
		//		//Renaming the report with new name
		//
		System.out.println(oldFile.renameTo(newFile));
		//
		//		//Opening the report
		Desktop.getDesktop().browse(new File(fileName).toURI());
	}
}


