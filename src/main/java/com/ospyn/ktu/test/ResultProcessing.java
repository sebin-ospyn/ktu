//package com.ospyn.ktu.test;
//import java.awt.Desktop;
//import java.io.File;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.Date;
//
//import org.openqa.selenium.WebDriver;
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
//import com.ospyn.ktu.view.ViewResultProcessing;
//import com.relevantcodes.extentreports.LogStatus;
//
//public class ResultProcessing extends DriverConfig {
//	static String[] testName;
//	//Creating reference for log in
//	static ViewLogin login;
//	//Creating reference to ViewResultProcessing
//	ViewResultProcessing ResultProcessingView;
//	//Creating reference for extended reports
//	GenerateExtentReport report=Login.report;
//	//Creating reference for extracting  screenshots of failed tests
//	Screenshot screenshot;
//	//	Creating static variable for adding details to log
//	String details;
//	//	Creating reference for driver
//	WebDriver driver;
//
//
//
//	public ResultProcessing() throws Exception {
//		screenshot = new Screenshot();
//		driver = getDriver();
//		report = Login.report;
//		ResultProcessingView = new ViewResultProcessing(driver);
//	}
//	@BeforeTest
//	public void getTestName(final ITestContext testContext)
//	{
//		String test=testContext.getName(); // gets the test name assigned in the xml file
//		testName=test.split("-");
//	}
//	//***************************************************************************
//
//
//	@Test
//	public void User_click_result() throws Exception {
//
////		CommonUtilView.click("(//*[@href='/university/eu/res/examCourseStudentResultsListing.htm'])[2]");
//		System.out.println("hELOOOOOO");
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>Checking whether user is able to click on Tab named Result</i>");
//		Thread.sleep(1500);
//		ResultProcessingView.clickResultModule();
//		details="User navigate to result page";
//
//	}
//
//	@Test
//	public void User_click_resultProcessing() throws Exception {
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>Checking whether user is able to click on Tab named ResultProcessing</i>");
// 		ResultProcessingView.clickResultProcessing();
//		details="User navigate to result processing page";
//
//	}
//	@Test
//	public void User_filter_examdef_data() throws Exception {
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>Checking whether user is able to Filter data</i>");
//		ResultProcessingView.filterData();
//		details="Data displyed";
//
//	}
//	@Test
//	public void User_click_resultProcessing_agnst_ExamDef() throws Exception {
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User click on resultProcessing against exam definition</i>");
//		ResultProcessingView.resultProcessing();
//		details="Result processing page get displyed";
//
//	}
//	@Test
//	public void User_asserting_ExamDef() {
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User click on resultProcessing against exam definition</i>");
//		ResultProcessingView.assertngExamdf();
//		details="Result processing page get displyed";
//
//	}
//	@Test
//	public void User_Search_Exam() throws Exception {
//	report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>Checking whether user is able to click on Tab named Exam</i>");
//	driver.manage().window().maximize();
//	ResultProcessingView.clickExam();
//	details="Exam Tab clicked";
//
//	}
//	@Test
//	public void User_Fetching_ExamDef_details() throws Exception {
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User fetching examdefdetails</i>");
//		ResultProcessingView.fetchExamDetails();
//		details="Exam Tab clicked";
//
//	}
//	@Test
//	public void User_asserting_ExamMode_ExamType_etc() throws Exception {
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>Check that examination details(Exam mode,Exam type,Exam month/year) shown in process result page are correct</i>");
//		ResultProcessingView.examModeType();
//		details="";
//
//	}
//	@Test
//	public void User_validating_preprocessor() throws Exception {
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>Check that user is able to run PreProcessor job</i>");
//		ResultProcessingView.preProcessorJob();
//		details="Job run sucessfully";
//
//	}
//	@Test
//	public void User_validating_preprocessorJob() throws Exception {
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>Check that user is able validate PreProcessor job</i>");
//		ResultProcessingView.validatingpreprocessorJob();
//		details="Job run sucessfully";
//
//	}
//
//	@Test
//	public void User_validating_markValidation() throws Exception {
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>Check that user is able validate Mark validation job</i>");
//		ResultProcessingView.markValidationJob();
//		details="Job run sucessfully";
//
//	}
//	@Test
//	public void User_process_graceMark_Moderation() throws InterruptedException{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>Check that user is able to process grace mark and moderation job</i>");
//		ResultProcessingView.graceMarkModeration();
//		details="Job run sucessfully";
//
//	}
//
//	@Test
//	public void User_process_processResult() throws InterruptedException{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>Check that user is able to process processResult job</i>");
//		ResultProcessingView.processResult();
//		details="Job run sucessfully";
//
//	}
//	@Test
//	public void User_click_on_postProcess_Button() throws InterruptedException {
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>Check that user is able to click postProcess button</i>");
//		ResultProcessingView.clickPostProcess();
//		details="Job run sucessfully";
//		}
//
//	@Test
//	public void User_click_on_postProcessAll() throws InterruptedException {
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>Check that user is able to click postProcess button</i>");
//		ResultProcessingView.clickPostProcessAll();
//		details="Job run sucessfully";
//		}
//	@Test
//	public void User_click_on_publish_Button() throws InterruptedException {
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>Check that user is able to click publish button</i>");
//		ResultProcessingView.buttonClick();
//		details="Button clicked and navigated to publish page";
//
//	}
//	@Test
//	public void User_click_on_publish_selected() throws InterruptedException {
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>Check that user is able to publish result</i>");
//		ResultProcessingView.publishResult();
//		details="";
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
//	//*************************************************************************
//
//
//
//	@AfterMethod
//	//writing the status to the report
//	public void getResult(ITestResult result)
//	{
//		//if the testing is a failure
//		if(result.getStatus()==ITestResult.FAILURE)
//		{
//			//Using details of date and time for naming the screenshot
//			String dateName = new SimpleDateFormat("ddMMyyyy_hhmmss").format(new Date());
//
//			//capturing screenshot of the failed method
//			String screenshotName=result.getMethod().getMethodName()+"-"+dateName+".jpg";
//
//			screenshot.captureScreenshot(screenshotName, driver);
//
//			//Adding screenshot to the report for the failed test
//			report.addScreenShotToLog(System.getProperty("user.dir")+"/Screenshots/"+screenshotName);
//		}
//
//		//if testing is successful
//		else if(result.getStatus()==ITestResult.SUCCESS)
//		{
//			report.setLog(LogStatus.PASS, details);
//		}
//
//		//if testing is skipped
//		else if(result.getStatus()==ITestResult.SKIP)
//		{
//			report.setLog(LogStatus.SKIP, "Skipped");
//		}
//		//Ending the test
//		report.endTest();
//
//	}
//	@AfterSuite
//	public void endTest() throws IOException
//	{
//		//closing the report
//		report.endReport();
//
//		//Renaming the report by adding date and time to the report
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH:mm:ss");
//		LocalDateTime now = LocalDateTime.now();
//
//		File oldFile=new File(System.getProperty("user.dir")+"/target/Report.html");
//
//		String fileName=System.getProperty("user.dir")+"/target/Result_Processing_"+dtf.format(now)+".html";
//		File newFile=new File(fileName);
//
//		//Renaming the report with new name
//
//		System.out.println(oldFile.renameTo(newFile));
//
//		//Opening the report
//		Desktop.getDesktop().browse(new File(fileName).toURI());
//	}
//}
