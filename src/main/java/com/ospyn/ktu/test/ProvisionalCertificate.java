package com.ospyn.ktu.test;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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
import com.ospyn.ktu.view.ViewProvisionalCertificate;
import com.relevantcodes.extentreports.LogStatus;


public class ProvisionalCertificate extends DriverConfig{
//	Creating reference to ViewProvisionalCertificate
	ViewProvisionalCertificate provisionalcertificateview;
	//	Creating reference for log in
	static ViewLogin login;
	//	Creating reference for extended reports
	GenerateExtentReport report=Login.report;
	//	Creating reference for extracting  screenshots of failed tests
	Screenshot screenshot;
	//	Creating static variable for adding details to log
	String details;
	//	Creating reference for driver
	WebDriver driver;

	static String[] testName;
	private String testValue;
	private String resultValue;
	public static Object[] faculties;

	public ProvisionalCertificate() throws Exception {
		screenshot = new Screenshot();
		driver = getDriver();
		report = Login.report;
		provisionalcertificateview = new ViewProvisionalCertificate(driver);

	}
	@BeforeTest
	public void getTestName(final ITestContext testContext)
	{
		String test=testContext.getName(); // gets the test name assigned in the xml file
		testName=test.split("-");
	}
//	***********************************************************************************

	@Test
	public void Certificate_reqst() throws Exception {
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>Checking whether user is able to request for certificate</i>");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		provisionalcertificateview.certficateReqst();
//		details="User ";

		}









	@Test
	public void Click_student_module() throws Exception {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>Checking whether user is able to click on Tab named Student</i>");
		driver.manage().window().maximize();
		Thread.sleep(1500);
		provisionalcertificateview.clickStudentModule();
		details="User navigate to student page";
	}
	@Test
	public void Click_Mycertificates() throws Exception{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>Checking whether user is able to click on my certificate tab</i>");
		provisionalcertificateview.clickMycertificates();
		details="User navigate to certificate listing page";
	}
	@Test
	public void User_asserting_requestButton() throws Exception{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>Checking whether user is able to find request button against eleigible students</i>");
		provisionalcertificateview.ButtonAssert();
		details="";
	}
	@Test
	public void Click_req_buttn() {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>Checking whether the user is able to click on request button</i>");
		provisionalcertificateview.clickReqBttn();
		details="User navigate to certificate page";
	}
	@Test
	public void Passing_commnicatndetails() throws Exception {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>Checking  </i>");
		provisionalcertificateview.passingCommnicatndetails();
		details="User  ";

	}
	@Test
	public void Choose_ProcessPriority()throws Exception {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>Checking that user is able to choose process priority </i>");
		provisionalcertificateview.chooseProcessPriority();
		details="User choosed process priority";

	}
	@Test
	public void User_validating_savedReqst() {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User validating saved request </i>");
		provisionalcertificateview.validatingSavedReqst();
		details="Saved request validated";
	}
	@Test
	public void Certificate_Payment() throws Exception{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User do payment </i>");
		provisionalcertificateview.certificatePayment();
		details="payment done";

	}











//	***********************************************************************************
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

		String fileName=System.getProperty("user.dir")+"/target/Provisional_Certificate_"+dtf.format(now)+".html";
		File newFile=new File(fileName);

		//Renaming the report with new name

		System.out.println(oldFile.renameTo(newFile));

		//Opening the report
		Desktop.getDesktop().browse(new File(fileName).toURI());
	}

}
