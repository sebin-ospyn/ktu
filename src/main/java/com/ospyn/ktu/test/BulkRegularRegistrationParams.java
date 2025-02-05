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
import java.util.List;

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
import com.ospyn.ktu.view.ViewBulkRegularExamRegistrationParams;
import com.relevantcodes.extentreports.LogStatus;

public class BulkRegularRegistrationParams extends DriverConfig{

	//creating reference to ViewCourseSelection
	static ViewBulkRegularExamRegistrationParams bulkRegularRegistrationView;

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

	public BulkRegularRegistrationParams()
	{
		/*initializing..
//		 * ExtentReport-->Using a class GenerateExtentReport class in the util package
//		 * WebDriver--->Using the DriverConfig class in the util package
//		 *
//		 */
		screenshot=new Screenshot();
		driver=getDriver();
		bulkRegularRegistrationView=new ViewBulkRegularExamRegistrationParams(driver);
		studentData=ViewBulkRegularExamRegistrationParams.getStudentData();



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
		bulkRegularRegistrationView.sudentDetailsSearch(stringList);
		details=" Report is displayed";
	}

	@Test
	public void reading_Students() throws InterruptedException, AWTException, IOException
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>searching students in student details</i>");
		bulkRegularRegistrationView.readingStudentRegisterNumber();
		studentData=ViewBulkRegularExamRegistrationParams.getStudentData();
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
		bulkRegularRegistrationView.getLogout().click();
		details="user successfully logged out";
	}

	@Test
	public void college_ExamModule()
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>user clicks exam module</i>");
		bulkRegularRegistrationView.getCollegeExamModule().click();
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
		bulkRegularRegistrationView.examSearch(StringList);
		details="registeration page is displayed";
	}


	public void Logout()
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>user clicks logout</i>");
		bulkRegularRegistrationView.getLogout().click();
		details="user successfully logged out";
	}

	public void click_SemExamRegistration() {

		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>user clicks course/sem registration</i>");
		bulkRegularRegistrationView.getCoursesemexamreg().click();
		details="course/sem registration is displayed";

	}

	public void click_Student()
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>user clicks student module</i>");
		bulkRegularRegistrationView.getStudent().click();
		details="student module is displayed";
	}

	public void click_RegisterButton()
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>user clicks on register button</i>");
		bulkRegularRegistrationView.getRegisternewcourses().click();
		details="registration page is displayed";
	}

	public void student_CourseRegisteration() throws InterruptedException, AWTException
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>user select the required course</i>");
		Testresult=bulkRegularRegistrationView.courseSelection();
		details="required courses are selected";
	}


	public void student_RegisterationSave() throws InterruptedException, AWTException
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>user clicks on save button</i>");
		WebElement save = driver.findElement(By.xpath("//button[@name='save']"));
		//((RemoteWebDriver) driver).executeScript("arguments[0].click();", save);
		save.click();
		details="course registration is saved";
	}


	public void student_RegisterationSubmit() throws InterruptedException, AWTException
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>user clicks on submit button</i>");
		bulkRegularRegistrationView.getSubmitbutton().click();

		Thread.sleep(1000);

		//Pressing the Enter Key
		robot.keyPress(KeyEvent.VK_ENTER);
		//Releasing the Enter Key
		robot.keyRelease(KeyEvent.VK_ENTER);

		details="course registration is submitted";
	}

	public void registerationSubmit_Check() throws InterruptedException, AWTException
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>user clicks on submit button</i>");
		bulkRegularRegistrationView.coursesubmissionsuccessvalidation();
		details="course registration is submitted";
	}

	public void registerButton_NotDisplayed() {

		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>register button not displayed</i>");
		details="register button not displayed";
	}
	@Test
	public void testMethod() throws InterruptedException, AWTException {
		Testresult=bulkRegularRegistrationView.courseSelection();
	}


	public void creditFeeCheckValidation() {

		Assert.assertEquals(Testresult, Actualresult);
	}

	@Test(dataProvider = "data-provider")
	public void student_Registration(String regNo)throws Exception
	{
		System.out.print("ychduwjocidjocwidcwoiejc");
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />Registration done by:"+regNo );
		Thread.sleep(1000);

		try
		{
			/* user enters the username and password by reading the dataprovider */
			String password="pass1@";
			login=new ViewLogin(driver);
			login.logIn(regNo,password);
			details="User name and password are entered";
			login.clickLogin();
			Thread.sleep(1000);
			// login.logOut();
			Thread.sleep(1000);
			report.setLog(LogStatus.PASS,"");

		}
		catch(Exception e)
		{
			report.setLog(LogStatus.FAIL,"");
		}

		//********************************************

		try {

			/*user clicks on student module*/
			click_Student();
			report.setLog(LogStatus.PASS,"");
		}
		catch(Exception e)
		{
			report.setLog(LogStatus.FAIL,"");
		}

		//*********************************************

		try {

			/*reading the student branch*/
			branchDetails();
			report.setLog(LogStatus.PASS,"");
		}
		catch(Exception e)
		{
			report.setLog(LogStatus.FAIL,"");
		}

		//*********************************************

		try {

			/*clicking the course/sem exam registration button */
			click_SemExamRegistration();
			report.setLog(LogStatus.PASS,"");
		}
		catch(Exception e)
		{
			report.setLog(LogStatus.FAIL,"");
		}

		//*********************************************

		List<WebElement> list = driver.findElements(By.xpath("//a[@class='btn btn-info pull-right btn-xs']"));
		if(list.size()!=0) {
			try {
				//selecting all the courses listed for the student
				click_RegisterButton();
				report.setLog(LogStatus.PASS,"");
			}
			catch(Exception e){
				System.out.println(e);
				report.setLog(LogStatus.FAIL,"");
			}
			try {
				student_CourseRegisteration();
				report.setLog(LogStatus.PASS,"");
			}
			catch(Exception e){
				System.out.println(e);
				report.setLog(LogStatus.FAIL,"");
			}
			try {
				creditFeeCheckValidation();
				report.setLog(LogStatus.PASS,"");
			}
			catch(Exception e){
				System.out.println(e);
				report.setLog(LogStatus.FAIL,"");
			}
			try {
				student_RegisterationSave();
				report.setLog(LogStatus.PASS,"");
			}
			catch(Exception e){
				System.out.println(e);
				report.setLog(LogStatus.FAIL,"");
			}
			try {
				student_RegisterationSubmit();
				report.setLog(LogStatus.PASS,"");
			}
			catch(Exception e){
				System.out.println(e);
				report.setLog(LogStatus.FAIL,"");
			}
			try {
				registerationSubmit_Check();
				report.setLog(LogStatus.PASS,"");
			}
			catch(Exception e){
				System.out.println(e);
				report.setLog(LogStatus.FAIL,"");
			}
			try {
				Thread.sleep(1000);
				Logout();
				report.setLog(LogStatus.PASS,"");
			}
			catch(Exception e){
				System.out.println(e);
				report.setLog(LogStatus.FAIL,"");
			}
		}
		else {
			try {
				registerButton_NotDisplayed();
				System.out.println("skipped student"+regNo);
				report.setLog(LogStatus.PASS,"");
			}
			catch(Exception e){
				System.out.println(e);
				report.setLog(LogStatus.FAIL,"");
			}
			try {
				Logout();
				report.setLog(LogStatus.PASS,"");
			}
			catch(Exception e){
				System.out.println(e);
				report.setLog(LogStatus.FAIL,"");
			}
		}

	}

	public void click_feeCollectedVerified() {

		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>user checks fee collected/verified</i>");
		WebElement feeCollecteVerifiedCheck= driver.findElement(By.xpath("//*[@id=\"feeCollected\"]"));
		feeCollecteVerifiedCheck.click();
		details="fee collected is checked";
	}

	public void college_SaveButtonClick() throws InterruptedException {

		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>user clicks save button</i>");
		bulkRegularRegistrationView.getCollegeSaveButton().click();
		Thread.sleep(1000);
		//Pressing the Enter Key
		robot.keyPress(KeyEvent.VK_ENTER);//Releasing the Enter Key
		robot.keyRelease(KeyEvent.VK_ENTER);
		details="save confirmation pop up displayed";
	}

	public void clear_RegNumber() {

		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>user clears the register number to enter the next register number</i>");
		bulkRegularRegistrationView.getStudentbox().clear();
		details="register number is cleared";
	}

	@Test(dataProvider = "data-provider")
	public void feeCollectedVerified_Check(String regNo)throws Exception{

		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />fee collected/verified done for:"+regNo );

		try {
			bulkRegularRegistrationView.getStudentbox().sendKeys(regNo);
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
		Testresult=bulkRegularRegistrationView.examSubmission(StringList);
		while(Testresult) {

			bulkRegularRegistrationView.submissionErrorMsg(StringList);
			Testresult=bulkRegularRegistrationView.examSubmission(StringList);

		}

		details="Exam registration is submitted";
	}

	@Test
	public void click_payNow() {

		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>user clicks on pay now in dashboard</i>");
		bulkRegularRegistrationView.payNowPayment();
		details="payment page is displayed";
	}

	@Test
	public void payment() throws InterruptedException {

		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>user does the payment</i>");
		ExpectedText = "Your Payment is successful";
		ActualText=bulkRegularRegistrationView.paymentGateway();
		Assert.assertEquals(ActualText,ExpectedText);

	}

	@Parameters({"maxCreditDetails"})
	@Test
	public void maxCreditValue(String StringList) throws Exception {

		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>user reads the maximum credit limit from scheme</i>");
		bulkRegularRegistrationView.getMaximumCreditScheme(StringList);
		details="maximum credit is read from scheme";
	}

	@Test
	public void read_ParentBranch() throws Exception {

		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>user reads the parent branches</i>");
		bulkRegularRegistrationView.gettingParentBranch();
		details="parent branches are read";
	}

	@Parameters({"examCreditDetails"})
	@Test
	public void examCredit_Value(String StringList) throws Exception {

		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>user reads the maximum credit limit from scheme</i>");
	    bulkRegularRegistrationView.readingSemCredits(StringList);
		details="maximum credit is read from scheme";
	}

	public void branchDetails() throws Exception {

		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>user reads student branch from profile</i>");
		bulkRegularRegistrationView.getStudent().click();
		bulkRegularRegistrationView.getBranch();
		details="student branch is read";
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
