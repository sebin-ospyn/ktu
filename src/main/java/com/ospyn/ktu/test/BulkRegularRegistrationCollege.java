package com.ospyn.ktu.test;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ospyn.ktu.util.DriverConfig;
import com.ospyn.ktu.util.GenerateExtentReport;
import com.ospyn.ktu.util.Screenshot;
import com.ospyn.ktu.util.ViewLogin;
import com.ospyn.ktu.view.ViewBulkRegularRegistrationCollege;
import com.relevantcodes.extentreports.LogStatus;

public class BulkRegularRegistrationCollege extends DriverConfig{

	//creating reference to ViewCourseSelection
	static ViewBulkRegularRegistrationCollege bulkRegularRegistrationCollegeView;

	static Object[] studentData;

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

	Robot robot;

	public BulkRegularRegistrationCollege()
	{
		/*initializing..
//		 * ExtentReport-->Using a class GenerateExtentReport class in the util package
//		 * WebDriver--->Using the DriverConfig class in the util package
//		 *
//		 */
		screenshot=new Screenshot();
		driver=getDriver();
		bulkRegularRegistrationCollegeView=new ViewBulkRegularRegistrationCollege(driver);
		studentData=ViewBulkRegularRegistrationCollege.getStudentData();



	}
	@BeforeTest
	public void getTestName(final ITestContext testContext)
	{

		String test=testContext.getName(); // gets the test name assigned in the xml file
		testName=test.split("-");
		try
		{
			robot =new Robot();
		}
		catch(Exception e)
		{

		}
	}

	@Parameters({"studentDetails"})
	@Test
	public void search_Students(String stringList) throws InterruptedException, AWTException, IOException
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>searching students in student details</i>");
		bulkRegularRegistrationCollegeView.sudentDetailsSearch(stringList);
		details=" Report is displayed";
	}

	@Test
	public void reading_Students() throws InterruptedException, AWTException, IOException
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>searching students in student details</i>");
		bulkRegularRegistrationCollegeView.readingStudentRegisterNumber();
		studentData=ViewBulkRegularRegistrationCollege.getStudentData();
		details=" student register number are read";
	}

	@DataProvider(name = "data-provider")
	public Object[] getStudentDetails1()
	{

		return studentData;
	}

	@Test
	public void userLogout()
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>user clicks logout</i>");
		bulkRegularRegistrationCollegeView.getLogout().click();
		details="user successfully logged out";
	}

	@Test
	public void college_ExamModule()
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>user clicks exam module</i>");
		bulkRegularRegistrationCollegeView.getCollegeExamModule().click();
		details="exam module is displayed";
		try {
			Thread.sleep(100);
		}
		catch(Exception e) {
			System.out.println("error"+e);
		}
	}

	@Parameters({"studentDetails"})
	@Test
	public void college_ExamSearch(String StringList) throws InterruptedException, AWTException
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>user search the required exam and click register button</i>");
		bulkRegularRegistrationCollegeView.examSearch(StringList);
		details="registeration page is displayed";
	}


	public void Logout()
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>user clicks logout</i>");
		bulkRegularRegistrationCollegeView.getLogout().click();
		details="user successfully logged out";
	}


	public void student_CourseRegisteration() throws InterruptedException, AWTException
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>user select the required course</i>");
		Testresult=bulkRegularRegistrationCollegeView.courseSelection();
		details="required courses are selected";
	}


	public void creditFeeCheckValidation() {

		Assert.assertEquals(Testresult, Actualresult);
	}



	public void click_feeCollectedVerified() {

		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>user checks fee collected/verified</i>");
		WebElement feeCollecteVerifiedCheck= driver.findElement(By.xpath("//*[@id=\"feeCollected\"]"));
		feeCollecteVerifiedCheck.click();
		details="fee collected is checked";
	}

	public void college_SaveButtonClick() throws InterruptedException {

		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>user clicks save button</i>");
		bulkRegularRegistrationCollegeView.getCollegeSaveButton().click();
		Thread.sleep(1000);
		//Pressing the Enter Key
		robot.keyPress(KeyEvent.VK_ENTER);//Releasing the Enter Key
		robot.keyRelease(KeyEvent.VK_ENTER);
		details="save confirmation pop up displayed";
	}

	public void clear_RegNumber() {

		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>user clears the register number to enter the next register number</i>");
		bulkRegularRegistrationCollegeView.getStudentbox().clear();
		details="register number is cleared";
	}

	@Test(dataProvider = "data-provider")
	public void feeCollectedVerified_Check(String regNo)throws Exception{

		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />fee collected/verified done for:"+regNo );

		try {
			bulkRegularRegistrationCollegeView.getStudentbox().sendKeys(regNo);
			report.setLog(LogStatus.PASS,"");
		}
		catch(Exception e){
			System.out.println(e);
			report.setLog(LogStatus.FAIL,"");
		}

		Thread.sleep(2000);

		//String autocompletetext= driver.findElement(By.xpath("//a[contains(text(),'No Record found')]")).getText();
		String autocompletetext= driver.findElement(By.xpath("//*[@role='option']")).getText();
		System.out.println("autocompletetext"+autocompletetext);

		if(!autocompletetext.equals("No Record found") ||!(autocompletetext.equals(""))) {

			try {

				//Pressing the Enter Key
				robot.keyPress(KeyEvent.VK_ENTER);
				//Releasing the Enter Key
				robot.keyRelease(KeyEvent.VK_ENTER);

				student_CourseRegisteration();
				//Click the Fee collected check box
				click_feeCollectedVerified();
				report.setLog(LogStatus.PASS,"");
			}
			catch(Exception e){
				System.out.println(e);
				report.setLog(LogStatus.FAIL,"");
			}

			Thread.sleep(1000);
			try {
				college_SaveButtonClick();
				report.setLog(LogStatus.PASS,"");
			}
			catch(Exception e){
				System.out.println(e);
				report.setLog(LogStatus.FAIL,"");
			}

			try {
				clear_RegNumber();
				report.setLog(LogStatus.PASS,"");
			}
			catch(Exception e){
				System.out.println(e);
				report.setLog(LogStatus.FAIL,"");
			}
		}
		else {
			try {
				System.out.println("skipped reg no "+regNo);
				clear_RegNumber();
				report.setLog(LogStatus.SKIP,"");
			}
			catch(Exception e){
				System.out.println(e);
				report.setLog(LogStatus.FAIL,"");
			}
		}

		Thread.sleep(300);
	}

	@Parameters({"studentDetails"})
	@Test
	public void branch_Submission(String StringList) throws InterruptedException, AWTException {

		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>user clicks on submit button</i>");
		bulkRegularRegistrationCollegeView.examSubmission(StringList);
		details="Exam registration is submitted";
	}

	@Test
	public void click_payNow() {

		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>user clicks on pay now in dashboard</i>");
		bulkRegularRegistrationCollegeView.payNowPayment();
		details="payment page is displayed";
	}

	@Test
	public void payment() throws InterruptedException {

		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>user does the payment</i>");
		ExpectedText = "Your Payment is successful";
		ActualText=bulkRegularRegistrationCollegeView.paymentGateway();
		Assert.assertEquals(ActualText,ExpectedText);

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
