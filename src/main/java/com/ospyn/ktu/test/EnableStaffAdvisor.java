package com.ospyn.ktu.test;
import java.awt.AWTException;
import java.awt.Desktop;
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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ospyn.ktu.util.DriverConfig;
import com.ospyn.ktu.util.GenerateExtentReport;
import com.ospyn.ktu.util.Screenshot;
import com.ospyn.ktu.view.ViewStaffAdvisorEnable;
import com.relevantcodes.extentreports.LogStatus;

public class EnableStaffAdvisor extends DriverConfig{


	//Creating reference to ViewStaffAdvisorEnable
	ViewStaffAdvisorEnable StaffAdvisorEnableview;

	//Creating a reference for creating extend reports
	GenerateExtentReport report=Login.report;

	//Creating a reference for creating screenshot
	Screenshot screenshot;

	//Creating static variable for adding details to log
	String details;

	//Creating reference for driver
	WebDriver driver;

	//creating a static variable for assigning the test name  before each test
	static String[] testName;


	public EnableStaffAdvisor()
	{
//		initializing..
//		 * ExtentReport-->Using a class GenerateExtentReport class in the util package
//		 * WebDriver--->Using the DriverConfig class in the util package


		screenshot=new Screenshot();
		driver=getDriver();
		StaffAdvisorEnableview=new ViewStaffAdvisorEnable(driver);


	}
	@BeforeTest
	public void getTestName(final ITestContext testContext)
	{

		String test=testContext.getName(); // gets the test name assigned in the xml file
		testName=test.split("-");

	}
//**************************************************************

	@Test
	public void click_Exam_Tab()throws Exception

	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User clicks the Exam tab</i>");
		//Getting Exam tab and clicking the tab
		StaffAdvisorEnableview.getExam().sendKeys(Keys.ENTER);
		details="User navigates to the Exam Page";
		Thread.sleep(1000);

	}
	@Parameters({"attendanceinternaldetails"})
	@Test
	public void click_student_attandance_internal(String AttendanceDetails) throws InterruptedException, AWTException {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>Attendance internal page displyed</i>");
		StaffAdvisorEnableview.Attendanceinternal(AttendanceDetails);
		details="User navigate to Attendance internal page  ";

	}

	@Test
	public void user_fetch_ChildBranch() throws InterruptedException {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User fetch the course code and Faculty Id</i>");

		StaffAdvisorEnableview.CoursecodeFacultyId();

			details="User navigates to faculty and course lisiting page";

	}
	@Test
	public void user_click_the_Academics_Auditing_Tab() throws InterruptedException{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User click the academic auditing tab</i>");
		StaffAdvisorEnableview.getAcademicAuditing().sendKeys(Keys.ENTER);
		details="User navigates to faculty and staff advisor selecting page";
	}
	@Parameters({"staffadvisordetails"})
	@Test
	public void user_select_staff_Advisor(String advisor) throws InterruptedException, AWTException {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User choose staff advisor</i>");
		StaffAdvisorEnableview.StaffAdvisor(advisor);
		details="User navigates to faculty and staff advisor selecting page";
		}
	@Test
	public void logout_from_user() throws InterruptedException {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User log out from college log in  </i>");
		StaffAdvisorEnableview.logout();
		details="User log out from college";
	}

	@Test
	public void user_Navigate_to_userdetails_page() throws InterruptedException {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User navigate to user details page  </i>");
		StaffAdvisorEnableview.userdetails();
		details="User details page reached";
	}

	@Test
	public void user_Checking_StaffAdvisor_Status() throws InterruptedException {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User navigate to user details page  </i>");
		StaffAdvisorEnableview.CheckingStatus();
		details="User details page reached";
	}

	@Test
	public void user_Checking_disabled_StaffAdvisor_Status() throws InterruptedException, AWTException {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User navigate to user details page and checking staff advisor status  </i>");
		StaffAdvisorEnableview.checkingDisabledStatus();
		details="User details page reached";
	}

	@Parameters({"staffadvisordetails1"})
	@Test
	public void user_click_batches_Tab(String advisor) throws InterruptedException, AWTException {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User click the batches tab then staff advisor page get listed</i>");
		StaffAdvisorEnableview.pageListing(advisor);
		details="User navigates to faculty and staff advisor selecting page";
		}




























//	****************************************************************************
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

		String fileName=System.getProperty("user.dir")+"/target/AbsenteeMalPracticeBulk_"+dtf.format(now)+".html";
		File newFile=new File(fileName);

		//Renaming the report with new name

		System.out.println(oldFile.renameTo(newFile));

		//Opening the report
		Desktop.getDesktop().browse(new File(fileName).toURI());
	}







}
