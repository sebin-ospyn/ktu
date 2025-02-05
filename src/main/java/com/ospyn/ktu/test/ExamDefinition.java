package com.ospyn.ktu.test;

import java.awt.AWTException;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.junit.Assert;
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
import com.ospyn.ktu.view.ViewBulkExamDefinition;
import com.relevantcodes.extentreports.LogStatus;

public class ExamDefinition extends DriverConfig{

		//creating reference to ViewCourseSelection
		static ViewBulkExamDefinition bulkExamDefinitionView;

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
		boolean Testresult, Actualresult =true;
		String ActualText, ExpectedText;

		public ExamDefinition()
		{
			/*initializing..
//			 * ExtentReport-->Using a class GenerateExtentReport class in the util package
//			 * WebDriver--->Using the DriverConfig class in the util package
//			 *
//			 */
			screenshot=new Screenshot();
			driver=getDriver();
			bulkExamDefinitionView=new ViewBulkExamDefinition(driver);

		}
		@BeforeTest
		public void getTestName(final ITestContext testContext)
		{

			String test=testContext.getName(); // gets the test name assigned in the xml file
			testName=test.split("-");

		}

		@Test
		public void university_homepage_loaded() throws InterruptedException

		{
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>University homepage is loaded</i>");
			Thread.sleep(1000);
			details="University homepage is loaded";

        }

		@Test
		public void UniversityExam_click() throws InterruptedException{

			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>user navigates to exam module</i>");
			bulkExamDefinitionView.getExam().click();
			details="Exam Definition listing page is displayed";
        }


		@Test
		public void click_addButton()

		{
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>user clicks on add exam definition</i>");
			bulkExamDefinitionView.getAddExamdefinition().click();
			details="Exam Definition add page displayed ";
        }

		@Test
		public void read_Excel() throws InterruptedException, AWTException, IOException
        {
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>user reads the value from excel</i>");
			bulkExamDefinitionView.excelRead();
		    details="excel values are read";
        }

		@Test
		public void readAndenter_examinationDetails() throws InterruptedException, AWTException, IOException
        {
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>user reads the value from excel and fill the examination details</i>");
			bulkExamDefinitionView.passValuetoExamdetails();
			details="examination details are entered";
        }

		@Test
		public void readAndenter_examSemesters() throws InterruptedException, AWTException, IOException
        {
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>user reads the value from excel and fill the exam semesers</i>");
			bulkExamDefinitionView.passValuetoExamsem();
		    details="exam semester details are entered";
        }

		@Test
		public void readAndenter_feeDetails() throws InterruptedException, AWTException, IOException
        {
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>user reads the value from excel and fill the fee details</i>");
            bulkExamDefinitionView.passValuetoFeedetails();
		    details="fee details are entered";
        }

		@Test
		public void readAndenter_examRegDetails() throws InterruptedException, AWTException, IOException
        {
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>user reads the value from excel and fill the exam registration details</i>");
			bulkExamDefinitionView.passValuetoExamregDetails();
		    details="exam registration details are entered";
        }

		@Test
		public void readAndenter_regAllowedcourse() throws InterruptedException, AWTException, IOException
        {
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>user reads the value from excel and fill the registration allowed courses</i>");
			bulkExamDefinitionView.registAllowedcourses();
		    details="registration allowed courses are entered";
        }

		@Test
		public void readAndenter_moderationDetails() throws InterruptedException, AWTException, IOException
        {
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>user reads the value from excel and fill the moderation details</i>");
			bulkExamDefinitionView.moderationDetails();
		    details="moderation details are entered";
        }

		@Test
		public void approve_examDefinition() throws InterruptedException, AWTException
        {
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>user approves exam definition</i>");
			ExpectedText="Approved";
			ActualText=bulkExamDefinitionView.approveExamDefinition();
			details="Exam definition is approved";
        }

		@Test
		public void validateResult()
        {
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>validate the result</i>");
			Assert.assertEquals(ExpectedText, ActualText);
		    details="case completed";
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

			String fileName=System.getProperty("user.dir")+"/target/TestResult_"+dtf.format(now)+".html";
			File newFile=new File(fileName);

			//Renaming the report with new name

			System.out.println(oldFile.renameTo(newFile));

			//Opening the report
			Desktop.getDesktop().browse(new File(fileName).toURI());
		}

}
