package com.ospyn.ktu.test;

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
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ospyn.ktu.util.DriverConfig;
import com.ospyn.ktu.util.GenerateExtentReport;
import com.ospyn.ktu.util.Screenshot;
import com.ospyn.ktu.util.ViewLogin;
import com.ospyn.ktu.view.KTUWebElements;
import com.ospyn.ktu.view.ViewHallTicketGeneration;
import com.relevantcodes.extentreports.LogStatus;

public class HallTicketGeneration extends DriverConfig
{
	//creating reference to ViewCourseMapping
	ViewHallTicketGeneration hallticketView;
	KTUWebElements webElements;
	//creating reference for Login
	static ViewLogin login;

	//Creating reference for creating Extent Reports
	static GenerateExtentReport report=Login.report;

	//Creating reference for extracting  screenshots of failed tests
	Screenshot screenshot;

	//Creating static variable for adding details to log
	static String details;

	String actualValue,expectedValue;
	boolean actualText,expectedText;

	//Creating reference for driver
	WebDriver driver;
	WebElement element;

	//creating a variable for assigning the test name  before each test
	String[] testName;

	public static Object[] getbranchdetails;



	public HallTicketGeneration() throws IOException
	{
		/*initializing..
//			 * ExtentReport-->Using a class GenerateExtentReport class in the util package
//			 * WebDriver--->Using the DriverConfig class in the util package
//			 *
//			 */
		report=Login.report;
		screenshot=new Screenshot();
		driver=getDriver();
		hallticketView=new ViewHallTicketGeneration(driver);
		webElements=new KTUWebElements(driver);

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
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User clicks the Exam tab");
		WebElement element=webElements.getExam();
		element.sendKeys(Keys.ENTER);

		try
		{
			Thread.sleep(2000);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		details="Exam Management side menu is displayed";

	}

	@Test
	public void click_Exam_HallTicket()
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User clicks the Hall ticket option from the side menu" );
		webElements.getHallTicket().click();
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{

		}
		details="The Institution Branches page is displayed";

	}

//	@Parameters({"examDetails"})
	@Test
	public void enter_examDetails() throws Exception
	{

		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User enters the exam details" );

		hallticketView.examHallTicketGeneration();
		Thread.sleep(1000);

		details="The branches along with hall tickets are displayed";

	}

	@Test(dataProvider="branch")
	public void User_Enter_Into_Hallticket_Page(String branchNames ) throws Exception{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User click view hallticket button of branch "+branchNames);
		try
		{

			hallticketView.clickViewHallticket(branchNames);
 			Thread.sleep(1000);

			report.setLog(LogStatus.PASS,"");
		}
		catch(Exception E)
		{
			report.setLog(LogStatus.FAIL,"");
		}
		details="User navigates to the view time table page will be displayed";

//		  try {
//			  user_clicks_View_HallTicket_Button();
//
//		  Thread.sleep(1000);
//
//		  report.setLog(LogStatus.PASS,""); }
//		  catch(Exception E)
//
//		  {
//		  report.setLog(LogStatus.FAIL,""); }



		try
		{

//			String details="Exam Registration";
			enter_hallTicket_Details();
			Thread.sleep(1000);

			report.setLog(LogStatus.PASS,"");
		}
		catch(Exception E)
		{
			report.setLog(LogStatus.FAIL,"");
		}

		try
		{

			view_TimeTable();
			Thread.sleep(1000);

			report.setLog(LogStatus.PASS,"");
		}
		catch(Exception E)
		{
			report.setLog(LogStatus.FAIL,"");
		}
		/*
		 * try {
		 *
		 * generate_HallTicket();
		 *  Thread.sleep(1000);
		 *
		 * report.setLog(LogStatus.PASS,""); }
		 * catch(Exception E) {
		 * report.setLog(LogStatus.FAIL,""); }
		 */
		try
		{
//			String details="2023 - 2024,#B.Tech,#Full Time,#B.Tech S3 (R) Exam Nov 2023 Test (2019 scheme)";
			view_TimeTable_2();
			Thread.sleep(1000);

			report.setLog(LogStatus.PASS,"");
		}
		catch(Exception E)
		{
			report.setLog(LogStatus.FAIL,"");
		}


		}

	@DataProvider(name="branch")
	public Object[] getbranchdetails()
	{
		for (Object branchName : ViewHallTicketGeneration.branchNames)
			System.out.println(branchName+"");
	return ViewHallTicketGeneration.branchNames;
	}






	@Test
	public void user_get_branchdetails() throws InterruptedException{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User fetch branch details" );

		System.out.println("Hello");
		hallticketView.getBranchDetails();
		details="User fetch branch details to string";

	}


//	@Test
	public void user_clicks_View_HallTicket_Button() throws Exception
	{

		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User clicks on the view hallticket button" );

		webElements.getViewHallTicket().click();
		Thread.sleep(1000);

		details="The page to enter details of exam comes up";

	}

//	@Parameters({"hallticketDetails"})
//	@Test
	public void enter_hallTicket_Details() throws Exception
	{

		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User clicks on the view hallticket button" );

		hallticketView.viewTimeTable();
		Thread.sleep(1000);

		details="The page to enter details of exam comes up";

	}

	public void view_TimeTable() throws Exception
	{

		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User generating hallticket " );

		webElements.getViewTimeTable().click();
		Thread.sleep(2000);
		webElements.getGenerateHallTicket().click();
		Thread.sleep(6000);
		webElements.getBack().click();
		Thread.sleep(1000);

		details="The page to enter details of exam comes up";

	}

	/*
	 * public void generate_HallTicket() throws Exception {
	 *
	 * report.beginTest("<b>"+testName[0]+"<br />"+testName[1]
	 * +"</B><br /><br />User clicks on the generate hallticket button" );
	 *
	 * // webElements.getGenerateHallTicket().click(); Thread.sleep(3000);
	 *
	 * webElements.getBack();
	 *
	 *
	 * details="The hall ticket is generated";
	 *
	 * }
	 */

	public void view_TimeTable_2() throws Exception{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User enter exam details" );
		hallticketView.examHallTicketGeneration();
		Thread.sleep(1000);
		details="Branches listing page will displayed after after entering exam details";

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

		String fileName=System.getProperty("user.dir")+"/target/HallticketGeneration_"+dtf.format(now)+".html";
		File newFile=new File(fileName);

		//Renaming the report with new name

		System.out.println(oldFile.renameTo(newFile));

		//Opening the report
		//Desktop.getDesktop().browse(new File(fileName).toURI());
	}
}


