package com.ospyn.ktu.test;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

import com.ospyn.ktu.util.DriverConfig;
import com.ospyn.ktu.util.GenerateExtentReport;
import com.ospyn.ktu.util.Screenshot;
import com.ospyn.ktu.view.ViewCertificateVerificationOuterPage;
import com.relevantcodes.extentreports.LogStatus;

public class CertificateVerification extends DriverConfig {
	
	
	
	//Creating reference for creating Extent Reports
	static GenerateExtentReport report = Login.report;
	//Creating reference for extracting  screenshots of failed tests
	Screenshot screenshot;
	//Creating static variable for adding details to log
	String details;
	//Creating reference for driver
		WebDriver driver;

		WebElement element;
		//creating a static variable for assigning the test name  before each test
		static String[] testName;
		public CertificateVerification()
		{
			report = Login.report;
			screenshot = new Screenshot();
			driver = getDriver();
		}
		
		// Getting the test name
		@BeforeTest
		public void getTestName(final ITestContext testContext) {
			report.beginTest("<b>" + testName[0] + "<br />" + testName[1]
					+ "</B><br /><br />User clicks save/verify button in the prepare packet page");
			String test = testContext.getName(); // gets the test name assigned in the xml file
			testName = test.split("-");
			details = "User saved/verified prepared packets after clicking the button save/verify";
		}
		@Test
		public void m() throws InterruptedException
		{
//			report.beginTest("<b>" + testName[0] + "<br />" + testName[1]
//					+ "</B><br /><br />User clicks save/verify button in the prepare packet page");
			ViewCertificateVerificationOuterPage vcvop=new ViewCertificateVerificationOuterPage(driver);
			vcvop.setRegisterNumber("NSS19ME035");
			vcvop.setDOB("26,04,2000");
			System.out.println("test");
			vcvop.clickSearch();
			System.out.println("test");
			Thread.sleep(1000);
			vcvop.verifyErrorMessage("No records found for the provided Register Number and Date of Birth.");
			System.out.println("test");
//			details = "User saved/verified prepared packets after clicking the button save/verify";

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

			String fileName = System.getProperty("user.dir") + "/target/CertificateVerification" + dtf.format(now) + ".html";
			File newFile = new File(fileName);

			// Renaming the report with new name

			System.out.println(oldFile.renameTo(newFile));

			// Opening the report
			Desktop.getDesktop().browse(new File(fileName).toURI());
		}
}
