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
import com.ospyn.ktu.view.ViewAbsenteeMalpracticeBulk;
import com.relevantcodes.extentreports.LogStatus;

public class AbsenteeMalpracticeBulk extends DriverConfig{
	//creating reference to ViewAbsenteeMalpracticeBulk
		ViewAbsenteeMalpracticeBulk absenteeMalpracticeBulkview;

		//creating reference for Login
		static ViewLogin login;

		//Creating reference for creating Extent Reports
		GenerateExtentReport report=Login.report;

		//Creating reference for extracting  screenshots of failed tests
		Screenshot screenshot;

		//Creating static variable for adding details to log
		String details;

		//Creating reference for driver
		WebDriver driver;

		//creating a static variable for assigning the test name  before each test
		static String[] testName;
		private String testValue;
		private String resultValue;

		public AbsenteeMalpracticeBulk() throws IOException
		{
			/*initializing..
//			 * ExtentReport-->Using a class GenerateExtentReport class in the util package
//			 * WebDriver--->Using the DriverConfig class in the util package
//			 *
//			 */
			screenshot=new Screenshot();
			driver=getDriver();
			report=Login.report;
			absenteeMalpracticeBulkview=new ViewAbsenteeMalpracticeBulk(driver);
		}
		@BeforeTest
		public void getTestName(final ITestContext testContext)
		{
			String test=testContext.getName(); // gets the test name assigned in the xml file
			testName=test.split("-");
		}
		@Test
		public void click_Exam_Tab()throws Exception
		{
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User clicks the Exam tab</i>");
			//Getting Exam tab and clicking the tab
			absenteeMalpracticeBulkview.getExam().sendKeys(Keys.ENTER);
			details="User navigates to the Exam Page";
			Thread.sleep(1000);
		}
		@Test
		public void click_Exams_Menu()throws Exception

		{
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User clicks the Exams menu</i>");
			//Getting Exams menu and clicking the tab
			absenteeMalpracticeBulkview.getExams().sendKeys(Keys.ENTER);
			details="User navigates to the Exam Definitions Page";
			Thread.sleep(1000);
		}

//		@Parameters({"examDetails"})
		@Test
		public void exam_Definition_Details() throws InterruptedException
		{
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User enters the exam details</i>");
			//Parameters are accepted  and used for searching the Exam definition used to enter absentee and Malpractice
			absenteeMalpracticeBulkview.enterDetails();
			details="The details are entered";
		}

		@Test
		public void user_Validate_Courselisting_Page() throws InterruptedException
		{
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User validate course listing page</i>");
			testValue = "Course Listing";
			Thread.sleep(2000);
			resultValue = absenteeMalpracticeBulkview.ValidateText();
			assertEquals(testValue, resultValue);
			Thread.sleep(1000);
			details="User navigate to the course listing page";

		}
		@Test
		public void course_Code() throws InterruptedException, AWTException {
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User fetch courses from course listing page</i>");

			absenteeMalpracticeBulkview.courseCode();
			Thread.sleep(2000);
			details="User get the course coded from course listing page";

		}
//		@Parameters({"eligibleStudentDetails"})
		@Test
		public void click_Exam_Eligibility() throws InterruptedException, AWTException {
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>Exam eligibility page displyed</i>");
			absenteeMalpracticeBulkview.StudentExamEligibility();
			details="User navigate to Student eligibility page";

			 }
		@Test
		public void fetch_EligibleStudent_id() throws InterruptedException, AWTException {
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User fetch eligible student details</i>");
			absenteeMalpracticeBulkview.studentId();
			details="User navigate to Student eligibility page and store eligible student against each listed course";
			}
//		@Parameters({"examDetails"})
		@Test
		public void entering_Malpractice_Data() throws InterruptedException, AWTException
		{
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User enter malpractice and submit against listed course</i>");
			absenteeMalpracticeBulkview.entermalpractice();
			details=" user enter malpractice data";

		}
		@Test
		public void entering_Absentee_Data() throws InterruptedException, AWTException {
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User entering absentee and submit against listed course</i>");
			absenteeMalpracticeBulkview.enterAbsentee();
			details=" user enter absentee data";

		}
		@Test
		public void user_Generate_Reports() throws InterruptedException, AWTException {
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User generating absentee malpractice reports</i>");
			absenteeMalpracticeBulkview.generatereport();
			details=" user generate absentee malpractice reports";

		}
		@Test
		public void user_Click_Answersheet_Packetentry_button() throws InterruptedException, AWTException
		{
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User click packet entry button and try to enter answersheets</i>");
			absenteeMalpracticeBulkview.packetEntry();
			details=" user click answer sheet packet entrty";

		}
		@Test
		public void user_Asserting_Error() throws InterruptedException
		{
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User Asserting validation message Which is packet entry cannot be done without submitting additional barcode used details</i>");

			testValue = "Packet entry cannot be done without submitting additional barcode used details";
//			testValue = "Packet entry cannot be done without submitting additional barcode used details and Packet entry cannot be done. Valuation camp configuration is not complete. Please contact University.";
			resultValue = absenteeMalpracticeBulkview.answersheetError();
 			assertEquals(testValue, resultValue);
			details="user asserting validation message while trying packet entry without submit barcode details";

		}
		@Test
		public void user_Leaves_Mandatory_Field_And_Validate_Errormessage  () throws InterruptedException, AWTException
		{
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User saving data by leaving required mandatory fields as empty,and checking proper validations are displaying </i>");
			absenteeMalpracticeBulkview.savenulldata();
			details="Checking validation message for mandatory fields";

		}
		@Test
		public void user_Logout_From_College() throws InterruptedException, AWTException
		{
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User logout from college </i>");
			absenteeMalpracticeBulkview.collegelogout();
			details="college log out";
		}
		@Test
		public void click_Valuation_Module() throws InterruptedException, AWTException
		{
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User click valuation module </i>");
			absenteeMalpracticeBulkview.Valuationmodule();
			details="Valution module will displayed";
		}

		@Test
		public void user_click_Viewfalsenumbergenerate() throws InterruptedException, AWTException
		{
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User click view generated false number </i>");
			absenteeMalpracticeBulkview.Barcodeget();
			details="false number generated page will displayed and fetch details";
		}
		@Test
		public void user_fetching_falsenumber() throws InterruptedException, AWTException
		{
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User fetch generated additional false number </i>");
			absenteeMalpracticeBulkview.getfalsenumber();
			details="fetch data will be stored";
		}
		@Test
		public void user_Logout_From_University() throws InterruptedException, AWTException
		{
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User logout from college </i>");
			absenteeMalpracticeBulkview.universitylogout();
			details="college log out";

		}
		@Test
		public void user_Replace_Barcode_Absentee_Student() throws InterruptedException, AWTException {
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User replace barcode for absentee student </i>");
			absenteeMalpracticeBulkview.replacedbarcode();
			details="user validate error after replace barcode ";

		}
		@Test
		public void user_Validate_Error_Absentee_Student() throws InterruptedException{
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User validate the error message while entering absentee student </i>");

			testValue = "No Record found";
			resultValue = absenteeMalpracticeBulkview.errorabsenteefalse();
			assertEquals(testValue, resultValue);
			details="user found No record found";

		}
		@Test
		public void user_Replace_Barcode_And_Validate() throws InterruptedException, AWTException {
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User replace barcode and validate successfully </i>");
			absenteeMalpracticeBulkview.replacedfacesheet();
			details="user get back to course listing page ";

		}

		@Test
		public void user_Entering_Answersheet_packets() throws InterruptedException, AWTException {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User entering answersheet packets </i>");
		absenteeMalpracticeBulkview.answersheet();
		absenteeMalpracticeBulkview.clearall();
		details="user navigate to answersheet entering page";
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

			String fileName=System.getProperty("user.dir")+"/target/AbsenteeMalPracticeBulk_"+dtf.format(now)+".html";
			File newFile=new File(fileName);

			//Renaming the report with new name

			System.out.println(oldFile.renameTo(newFile));

			//Opening the report
			//Desktop.getDesktop().browse(new File(fileName).toURI());
		}

}
