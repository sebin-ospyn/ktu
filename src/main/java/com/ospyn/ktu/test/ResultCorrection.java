package com.ospyn.ktu.test;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
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
import com.ospyn.ktu.view.ViewResultCorrection;
import com.relevantcodes.extentreports.LogStatus;

public class ResultCorrection extends DriverConfig {
	
	// creating reference for Login
	static ViewLogin login;
	
	
	// creating reference to ViewCourseMapping
		ViewResultCorrection ResultCorrectionView;
	

	// Creating reference for creating Extent Reports
	static GenerateExtentReport report = Login.report;

	// Creating reference for extracting screenshots of failed test
	Screenshot screenshot;
	
	
	// Creating static variable for adding details to log
		static String details;
		
		
		// Creating reference for driver
		WebDriver driver;
		WebElement element;

		// creating a variable for assigning the test name before each test
		String[] testName;
	
		public ResultCorrection() throws Exception {

			report = Login.report;
			screenshot = new Screenshot();
			driver = getDriver();
			ResultCorrectionView = new ViewResultCorrection(driver);
		}
	
	// Getting the test name
	@BeforeTest
	public void getTestName(final ITestContext testContext) {

		String test = testContext.getName(); // gets the test name assigned in the xml file
		testName = test.split("-");
	}
		
//	@Test
//	public void Login_as_AdExam() throws Exception {
//		report.beginTest("<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br /> User login as college admin ");
//		ResultCorrectionView.loginasAdExam();
////		ResultCorrectionView.perform();
//		
//		//		SemesterEnrollmentView.loginasCollegeAdmin();
//		Thread.sleep(1000);
//		details = "User logging in as adexam";
//	}
	
//	@Test
//	public void Login_as_Student() throws Exception
//	{
//		report.beginTest("<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br /> User login as student ");
//		ResultCorrectionView.loginasStudent1();
//		details = "User logged in as student";
//	}
	
//	@Test
//	public void Perform_Student_Actions2() throws Exception
//	{
//		report.beginTest("<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br /> User login as college admin ");
//		ResultCorrectionView.performStudentActions2();
//		details = "User performing student actions";
//		
//	}
//	@Test
//	public void Perform_Main_Action1() throws Exception
//	{
//		report.beginTest("<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br /> Performing main action ");
//		ResultCorrectionView.checkMarkBefore();
//		ResultCorrectionView.logout();
//		ResultCorrectionView.loginasAdExam();
//	
//		ResultCorrectionView.logout();
//		details = "main action";
//	}
	@Test
	public  void Perform_Main_Action() throws Exception
	{
		report.beginTest("<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br /> Performing main action ");
		
		ResultCorrectionView.loginasAdExam();
		String st1=ResultCorrectionView.checkMarkBefore();
		boolean maxx = ResultCorrectionView.perform();
		if (!maxx)
		{
		ResultCorrectionView.process_st1();
		ResultCorrectionView.postprocess();
		ResultCorrectionView.publish();
		ResultCorrectionView.logout();
		ResultCorrectionView.loginasAdExam();
		String st2=ResultCorrectionView.checkMarkAfter();
		System.out.println("Final Mark before performing Result correction = "+st1);
		System.out.println("Final Mark after performing Result correction = "+st2);
		String enteredMark = ResultCorrectionView.fetchExcelMark();
		System.out.println("Entered mark via excel is = "+enteredMark);
		String newMark=ResultCorrectionView.checkMarkAfter2();
		System.out.println("new mark is = " +newMark);
		Assert.assertEquals(enteredMark,newMark);
		System.out.println("validation done");
		}
		
		ResultCorrectionView.logout();
		
		details = "main action";
	}
	
	@Test
	public void Perform_Student_Failing() throws Exception
	{
		report.beginTest("<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br /> Performing main action ");
		ResultCorrectionView.loginasStudent2();
		String GradeBefore = ResultCorrectionView.performStudentActions1();
		ResultCorrectionView.logout();
		ResultCorrectionView.loginasAdExam();
		boolean max=ResultCorrectionView.perform2();
		if (!max)
		{
		ResultCorrectionView.process_st2();
		ResultCorrectionView.postprocess();
		ResultCorrectionView.publish();
		ResultCorrectionView.logout();
		ResultCorrectionView.loginasStudent2();
		String GradeAfter = ResultCorrectionView.performStudentActions2();
		System.out.println("Grade before mark correction "+GradeBefore);
		System.out.println("Grade after mark correction "+GradeAfter);
		String FailedGrade=ResultCorrectionView.fetchExcelFailGrade();
		System.out.println("marking as failed = "+FailedGrade);
		Assert.assertEquals(GradeAfter, FailedGrade);
		System.out.println("validation done");
		}
		ResultCorrectionView.logout();
		details = "student fetching the grade";
	}
	
	@Test
	public void Perform_Student_Passing() throws Exception
	{
		report.beginTest("<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br /> Performing main action ");
		ResultCorrectionView.loginasStudent3();
		String GradeBefore = ResultCorrectionView.performStudentActions3();
		ResultCorrectionView.logout();
		ResultCorrectionView.loginasAdExam();
		ResultCorrectionView.perform3();
		ResultCorrectionView.process_st3();
		ResultCorrectionView.postprocess();
		ResultCorrectionView.publish();
		ResultCorrectionView.logout();
		ResultCorrectionView.loginasStudent3();
		String GradeAfter = ResultCorrectionView.performStudentActions4();
		System.out.println("Grade before mark correction "+GradeBefore);
		System.out.println("Grade after mark correction "+GradeAfter);
		Assert.assertNotEquals(GradeBefore, GradeAfter);
		System.out.println("validation done");
		details = "student fetching the grade";
	}
	
//	@Test
//	public void Perform_Student_Actions1() throws Exception
//	{
//		report.beginTest("<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br /> User logged in as student ");
//		ResultCorrectionView.performStudentActions1();
//		details = "Grade before the mark correction is fetched";
//	}
	
//	@Test
//	public void Perform_Action() throws Exception
//	{
//		report.beginTest("<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br /> User login as college admin ");
//		ResultCorrectionView.perform();
//		ResultCorrectionView.process_st1();
//		ResultCorrectionView.postprocess();
//		ResultCorrectionView.publish();
//		//Thread.sleep(3000);
//		details = "Performing the mark correction";
//	}
//	@Test
//	public void Log_Out() throws Exception
//	{
//		report.beginTest("<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br /> User login as college admin ");
//		Thread.sleep(5000);
//		ResultCorrectionView.logout();
//		Thread.sleep(2000);
//		details = "User logged out  as adexam";
//	}
		@AfterMethod
		// writing the status to the report
		public void getResult(ITestResult result) {
			// if the testing is a failure
			if (result.getStatus() == ITestResult.FAILURE) {

				// Using details of date and time for naming the screenshot

				String dateName = new SimpleDateFormat("ddMMyyyy_hhmmss").format(new Date());

				// capturing screenshot of the failed method
				String screenshotName = result.getMethod().getMethodName() + "-" + dateName + ".jpg";

				screenshot.captureScreenshot(screenshotName, driver);

				// Adding screenshot to the report for the failed test
				report.addScreenShotToLog(System.getProperty("user.dir") + "/Screenshots/" + screenshotName);
			}

			// if testing is successful
			else if (result.getStatus() == ITestResult.SUCCESS) {
				report.setLog(LogStatus.PASS, details);
			}

			// if testing is skipped
			else if (result.getStatus() == ITestResult.SKIP) {
				report.setLog(LogStatus.SKIP, "Skipped");
			}
			// Ending the test
			report.endTest();

		}
		
		@AfterSuite
		public void endTest() throws IOException {
			// closing the report
			report.endReport();

			// Renaming the report by adding date and time to the report
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();

			File oldFile = new File(System.getProperty("user.dir") + "/target/Report.html");

			String fileName = System.getProperty("user.dir") + "/target/SemesterEnrollment_" + dtf.format(now) + ".html";
			File newFile = new File(fileName);

			// Renaming the report with new name

			System.out.println(oldFile.renameTo(newFile));

			// Opening the report
			Desktop.getDesktop().browse(new File(fileName).toURI());
		}

}
