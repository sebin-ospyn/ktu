//package com.ospyn.ktu.test;
//
//import java.awt.Desktop;
//import java.io.File;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.Date;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.testng.ITestContext;
//import org.testng.ITestResult;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//import com.ospyn.ktu.util.DriverConfig;
//import com.ospyn.ktu.util.GenerateExtentReport;
//import com.ospyn.ktu.util.Screenshot;
//import com.ospyn.ktu.util.ViewLogin;
//import com.ospyn.ktu.view.ViewAddingScheme;
//import com.relevantcodes.extentreports.LogStatus;
//
//public class AddingScheme extends DriverConfig{
//
//	// creating reference to ViewCourseMapping
//	ViewAddingScheme AddingSchemeView;
//	// creating reference for Login
//	static ViewLogin login;
//
//	// Creating reference for creating Extent Reports
//	static GenerateExtentReport report = Login.report;
//
//	// Creating reference for extracting screenshots of failed test
//	Screenshot screenshot;
//
//	// Creating static variable for adding details to log
//	static String details;
//
//	String actualValue, expectedValue;
//	boolean actualText, expectedText;
//
//	// Creating reference for driver
//	WebDriver driver;
//	WebElement element;
//
//	// creating a variable for assigning the test name before each test
//	String[] testName;
//
//	public AddingScheme() throws Exception {
//
//		report = Login.report;
//		screenshot = new Screenshot();
//		driver = getDriver();
//		AddingSchemeView = new ViewAddingScheme(driver);
//
//	}
//
//	// Getting the test name
//	@BeforeTest
//	public void getTestName(final ITestContext testContext) {
//
//		String test = testContext.getName(); // gets the test name assigned in the xml file
//		testName = test.split("-");
//
//	}
//	@Test
//	public void Login_as_College_Admin() throws Exception {
//		report.beginTest("<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br /> User login as university user ");
//		AddingSchemeView.loginasUniversityUser();
//		Thread.sleep(1000);
//		details = "User log in as university user";
//
//	}
//	@Test
//	public void click_Academics() throws Exception {
//		report.beginTest("<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br /> User login as university user ");
//		AddingSchemeView.clickAcademics();
//		Thread.sleep(1000);
//		details = "User log in as university user";
//
//	}
//	@Test
//	public void click_Schemes() throws Exception {
//		report.beginTest("<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br /> User login as university user ");
//		AddingSchemeView.clickSchemes();
//		Thread.sleep(1000);
//		details = "User log in as university user";
//
//	}
//	@Test
//	public void click_Add_Button() throws Exception {
//		report.beginTest("<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br /> User login as university user ");
//		AddingSchemeView.clickAddButton();
//		Thread.sleep(1000);
//		details = "User log in as university user";
//
//	}
//	@Test
//	public void adding_Scheme_Details() throws Exception {
//		report.beginTest("<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br /> User login as university user ");
//		AddingSchemeView.addingSchemeDetails();
//		details = "User log in as university user";
//
//	}
//	@Test
//	public void add_Program_Duration() throws Exception {
//		report.beginTest("<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br /> User login as university user ");
//		AddingSchemeView.addProgramDuration();
//		details = "User log in as university user";
//
//	}
//
//
//
//
//
//
//
//	
//	
//	
//	
//
//	@AfterMethod
//	// writing the status to the report
//	public void getResult(ITestResult result) {
//		// if the testing is a failure
//		if (result.getStatus() == ITestResult.FAILURE) {
//
//			// Using details of date and time for naming the screenshot
//
//			String dateName = new SimpleDateFormat("ddMMyyyy_hhmmss").format(new Date());
//
//			// capturing screenshot of the failed method
//			String screenshotName = result.getMethod().getMethodName() + "-" + dateName + ".jpg";
//
//			screenshot.captureScreenshot(screenshotName, driver);
//
//			// Adding screenshot to the report for the failed test
//			report.addScreenShotToLog(System.getProperty("user.dir") + "/Screenshots/" + screenshotName);
//		}
//
//		// if testing is successful
//		else if (result.getStatus() == ITestResult.SUCCESS) {
//			report.setLog(LogStatus.PASS, details);
//		}
//
//		// if testing is skipped
//		else if (result.getStatus() == ITestResult.SKIP) {
//			report.setLog(LogStatus.SKIP, "Skipped");
//		}
//		// Ending the test
//		report.endTest();
//
//	}
//
//	@AfterSuite
//	public void endTest() throws IOException {
//		// closing the report
//		report.endReport();
//
//		// Renaming the report by adding date and time to the report
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH:mm:ss");
//		LocalDateTime now = LocalDateTime.now();
//
//		File oldFile = new File(System.getProperty("user.dir") + "/target/Report.html");
//
//		String fileName = System.getProperty("user.dir") + "/target/AddingScheme_" + dtf.format(now) + ".html";
//		File newFile = new File(fileName);
//
//		// Renaming the report with new name
//
//		System.out.println(oldFile.renameTo(newFile));
//
//		// Opening the report
//		Desktop.getDesktop().browse(new File(fileName).toURI());
//	}
//
//
//}
