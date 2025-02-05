package com.ospyn.ktu.test;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
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
import com.ospyn.ktu.util.ViewCommonUtil;
import com.ospyn.ktu.util.ViewLogin;
import com.ospyn.ktu.view.ViewRevaluation;
import com.relevantcodes.extentreports.LogStatus;

public class Revaluation extends DriverConfig{

	// creating reference to ViewCourseMapping
	ViewRevaluation RevaluationView;
	// creating reference for Login
	static ViewLogin login;

	// Creating reference for creating Extent Reports
	static GenerateExtentReport report = Login.report;
	static boolean flag=false;

	// Creating reference for extracting screenshots of failed test
	Screenshot screenshot;

	// Creating static variable for adding details to log
	static String details;

	String actualValue, expectedValue;
	boolean actualText, expectedText;

	// Creating reference for driver
	WebDriver driver;
	WebElement element;

	// creating a variable for assigning the test name before each test
	String[] testName;

	public Revaluation() throws Exception {

		report = Login.report;
		screenshot = new Screenshot();
		driver = getDriver();
		RevaluationView = new ViewRevaluation(driver);
		ViewCommonUtil.readFromExcel("PARAMETER_LISTING.xlsx","Revaluation");
//		ViewCommonUtil.readFromExcel("CertificateVerificationData.xlsx","Revaluation registration");
	}
	// Getting the test name
	@BeforeTest
	public void getTestName(final ITestContext testContext) {

		String test = testContext.getName(); // gets the test name assigned in the xml file
		testName = test.split("-");

	}
	@Test
	public void Login_as_University() throws Exception {
		report.beginTest("<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br /> User login as college admin ");
		RevaluationView.loginasUniversity();
		Thread.sleep(2000);
		details = "User log in as college admin";
		
	}

	@Test
	public void Login_as_Adexam() throws Exception {
		report.beginTest("<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br /> User login as college admin ");
		RevaluationView.loginasAdexam();
		Thread.sleep(2000);
		details = "User log in as college admin";
		
	}
	
	
	@Test
	public void Revaluation_Date_Extension() throws Exception
	{
		report.beginTest(
				"<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br />Revaluatoin date extension");
		
		ViewRevaluation.loginasUniversity();
		ViewCommonUtil.logOut();
		details = "Revaluation date extension completed";
		
	}
	@Test
	public void Revaluation_Packet_Movement() throws Exception
	{
		report.beginTest(
				"<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br />Revaluatoin date extension");
		
		ViewRevaluation.loginasAdexam();
		ViewRevaluation.RevaluationPacketMovement();
		
		details = "Revaluation packet movement completed";
	}
	
	@Test
	public void Student_Revaluation_Registration() throws Exception
	{
		report.beginTest(
				"<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br />Student Revaluation registration");
		ViewRevaluation.loginasStudent();
		ViewRevaluation.studentRevaluationRegistration();
		
	
		
		ViewCommonUtil.logOut();
//		 String s=ViewCommonUtil.readFromExcel("PARAMETER_LISTING.xlsx","Revaluation");
		details = "student revaluation registration completed";
		
		
	}
	
	@Test(dataProvider = "tes")
	public void Student_Revaluation_Registration_Multiple(String regno, String courseCode) throws Throwable
	{
		report.beginTest(
				"<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br />Student Revaluation registration");
		ViewRevaluation.StudentRevaluationRegistrationMultiple(regno, courseCode);
		
		ViewCommonUtil.logOut();

		
		
		details = "student revaluation registration completed";
	}
	
	@Test
	public void Revaluation_Camp_Creation() throws Exception
	{
		report.beginTest(
				"<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br />Revaluation camp creation");
		ViewRevaluation.loginasAdexam();
		ViewRevaluation.RevaluationCampCreation();
		ViewCommonUtil.logOut();
		details = "Revaluation camp creation done";
		
	}

	
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
	
	@DataProvider(name="tes")
	public Object[][] getdata1() throws EncryptedDocumentException, IOException
	{
		System.out.println("dataprovider");
		FileInputStream fis=new FileInputStream("/home/u1780/MainProject/KTU_AutomationTestNG/Test_Data/CertificateVerificationData.xlsx");
//		FileInputStream fis=new FileInputStream("/home/u1780/MainProject/KTU_AutomationTestNG/Test_Data/CertificateParameter.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Revaluation registration");
		int numofrows=sh.getLastRowNum();
		System.out.println(numofrows);
		int numofcols=sh.getRow(0).getLastCellNum();
		System.out.println(numofcols);
		Object value[][]=new Object[numofrows][numofcols];
		
		for (int i = 0; i < numofrows; i++) 
		{
            DataFormatter df = new DataFormatter();
            value[i][0] = df.formatCellValue(sh.getRow(i + 1).getCell(0)); // Register number
            value[i][1] = df.formatCellValue(sh.getRow(i + 1).getCell(1)); // Course code
        }
		wb.close();
		fis.close();
		return value;
	}


}
