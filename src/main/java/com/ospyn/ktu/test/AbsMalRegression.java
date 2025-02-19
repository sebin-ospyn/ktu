package com.ospyn.ktu.test;
import static org.testng.AssertJUnit.assertEquals;

import java.awt.AWTException;
import java.awt.Desktop;
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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ospyn.ktu.util.DriverConfig;
import com.ospyn.ktu.util.GenerateExtentReport;
import com.ospyn.ktu.util.Screenshot;
import com.ospyn.ktu.util.ViewLogin;
import com.ospyn.ktu.view.ViewAbsMalRegression;
import com.relevantcodes.extentreports.LogStatus;

public class AbsMalRegression extends DriverConfig{
//	Creating a reference to ViewAbsMalRegression
	ViewAbsMalRegression AbsMalRegressionview;
//	Creating a reference for extracting screenshot for failed test cases
	Screenshot screenshot;
//Creating reference for creating Extent Reports
	GenerateExtentReport report=Login.report;
//Creating static variable for adding details to log
	String details;
//creating reference for Login
	static ViewLogin login;
//Creating reference for driver
	WebDriver driver;
	static String[] testName;
	private String testValue;
	private String resultValue;


	public AbsMalRegression() throws IOException
	{

		screenshot=new Screenshot();
		driver=getDriver();
		AbsMalRegressionview=new ViewAbsMalRegression(driver);
    }
	@BeforeTest
	public void getTestName(final ITestContext testContext)
	{
		String test=testContext.getName(); // gets the test name assigned in the xml file
		testName=test.split("-");
	}
//	*****************************************************************************************
	@Test
	public void click_Exam_Tab()throws Exception
		{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User clicks the Exam tab</i>");
		//Getting Exam tab and clicking the tab
		AbsMalRegressionview.getExam().sendKeys(Keys.ENTER);
		details="User navigates to the Exam Page";
		Thread.sleep(1000);
		}
	@Test
	public void click_Exams_Menu()throws Exception
		{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User clicks the Exams menu</i>");
		//Getting Exams menu and clicking the tab
		AbsMalRegressionview.getExams().sendKeys(Keys.ENTER);
		details="User navigates to the Exam Definitions Page";
		Thread.sleep(1000);
		}
//	@Parameters({"examDetails"})
	@Test
	public void exam_Definition_Details() throws InterruptedException
		{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User enters the exam details</i>");
		//Parameters are accepted  and used for searching the Exam definition used to enter absentee and malpractice
		AbsMalRegressionview.enterDetails();
		details="The details are entered";
		}

	@Test
	public void user_Validate_Courselisting_Page() throws InterruptedException
		{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User validate course listing page</i>");
		testValue = "Course Listing";
		Thread.sleep(2000);
		resultValue = AbsMalRegressionview.ValidateText();
		assertEquals(testValue, resultValue);
		Thread.sleep(1000);
		details="User navigate to the course listing page";
		}
	@Test
	public void course_Code() throws InterruptedException, AWTException {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User fetch courses from course listing page</i>");
		AbsMalRegressionview.courseCode();
		Thread.sleep(2000);
		details="User get the course coded from course listing page";
		}
//	@Parameters({"eligibleStudentDetails","id"})
	@Parameters({"id"})
	@Test
	public void click_Exam_Eligibility(int id) throws InterruptedException, AWTException {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>Exam eligibility page displyed</i>");
		AbsMalRegressionview.StudentExamEligibility(id);
		details="User navigate to Student eligibility page";
		}
	@Test
	public void fetch_EligibleStudent_id() throws InterruptedException, AWTException {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User fetch eligible student details to enter absentee and malpracitce details</i>");
		AbsMalRegressionview.studentId();
		details="User navigate to Student eligibility page and store eligible student against each listed course";
		}
	@Test
	public void fetch_InEligibleStudent_id() throws InterruptedException, AWTException {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User fetch eligible student details to enter absentee and malpracitce details</i>");
		AbsMalRegressionview.student();
		details="User navigate to Student eligibility page and store eligible student against each listed course";
		}
	@Test
	public void user_Checking_Validation_in_absentee_page() throws InterruptedException, AWTException {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User entering to absentee entering page and click on save button with empty set,validate error message  </i>");

		AbsMalRegressionview.checkingValidation();
		details=" User Validate the error ";
		}
	@Test
	public void User_asserting_a_note_in_absentee_page() throws InterruptedException, AWTException {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User checking that a mandatory NOTE is displaying in the top of  student course absentee page UI which says-Students reported for malpractice, debarred students and whose halltickets are not generated can't be added as absentee.   </i>");

		AbsMalRegressionview.userassertingNOTE();
		details=" User asserting note ";
		}

	@Test
	public void User_asserting_course_and_examdate_absentee_page() throws InterruptedException, AWTException {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User asserting Course and exam date which is shown in absentee entering page </i>");
		AbsMalRegressionview.userAssertingDateandCourse();
		details="User asserted";
		}
	@Test
	public void User_fetch_eligible_student() throws InterruptedException, AWTException {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User fetching eligible student register number against courses </i>");
		AbsMalRegressionview.studentRegisterNum();
		details="User data fetched";
		}
	@Test
	public void User_entering_All_students_as_absentee_and_storing() throws InterruptedException, AWTException {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User click on all students check box and submit page</i>");
		AbsMalRegressionview.allAbsentee();
		details="page get submitted";
		}

	@Test
	public void User_asserting_all_eligible_students_are_present_in_field() throws InterruptedException, AWTException {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User verifying that all the eligible students who registered against courses are displaying in absentee entering page</i>");
		AbsMalRegressionview.asrtngAllEligblAbsStdnt();
		details="User asserted ";
		}
	@Test
	public void User_click_on_NoAbsentee_checkBox_and_Submit() throws InterruptedException, AWTException {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User click on NoAbsentee check box and submit page</i>");
		AbsMalRegressionview.noAbsenteeCheckBoxSubmit();
		details="page not get submitted,error showed  ";
		}
	@Test
	public void User_validating_error_message_showed() throws InterruptedException, AWTException {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User assert the error message showed</i>");
		AbsMalRegressionview.assertingError();
		details="user assert the error showed";
		}
	@Test
	public void User_fetch_Ineligible_student() throws InterruptedException, AWTException {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User fetching eligible student register number against courses </i>");
		AbsMalRegressionview.inEligiblestudentRegisterNum();
		details="User data fetched";
		}
	@Test
	public void user_Entering_Ineligible_Students_As_Absentee() throws InterruptedException, AWTException {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>  User verifying that ineligible students are not lisiting in absent entering page</i>");
		AbsMalRegressionview.asrtngAllInEligblAbsStdnt();
		details="user verified";
		}
	@Test
	public void user_adding_ineEligible_student_in_absnetee_field() throws InterruptedException, AWTException {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>  User verifying that a validation is throwing when entering ineligible student </i>");
		AbsMalRegressionview.validatingNoResultMatch();
		details="user  asserting validation";
		}
	@Test
	public void user_Deleting_Absentee_Entered_Students() throws InterruptedException, AWTException {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>  User verifying that it is able to delete saved absent student data </i>");
		AbsMalRegressionview.deleteStudent();
		details="user deleting student";
		}
	@Test
	public void User_click_malpracticeButton_and_verifying_data() throws InterruptedException, AWTException {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>  User click malpractice radio button and navigate to malpractice entering page then asserting courses </i>");
		AbsMalRegressionview.malDateTimeVerifying();
		details="user verifying exam date and time in malpractice listing page";
		}
	@Test
	public void User_submit_empty_malpracticeData_and_validate_error() throws InterruptedException, AWTException {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User submit empty set of malpractice data for a course and validate the error throwed</i>");
		AbsMalRegressionview.submitEmptyMaldata();
		details="User make sured that the error is throwed while submit empty data";
		}
	@Test
	public void User_leaves_mandatory_fieldEmpty_and_validate_errorMessage() throws InterruptedException, AWTException {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User click on save button on malpractice form page with empty data and validate the error throwed</i>");
		AbsMalRegressionview.emptymalpracticeform ();
		details="User validate the error";
		}
	@Test
	public void User_adding_ineligible_student_in_malpracticeform() throws InterruptedException, AWTException {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User passing an ineligible student data in malpractice field and try to save then validate the error throwed</i>");
		AbsMalRegressionview.ineligibleMalpractice();
		details="User validate the error";
		}
	@Test
	public void User_adding_an_absent_student_in_malpracticeform() throws InterruptedException, AWTException{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User passing an absent student data in malpractice field and try to save page then validate the error throwed</i>");
		AbsMalRegressionview.absentMarkedStudentInMalpractice();
		details="User validate the error";
		}

	@Test
	public void User_Checking_validation_for_invalid_attachments() throws InterruptedException, AWTException{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>  User attach an invalid file type supporting document which is not mentioned in the allowed supporting doc file types</i>");
		AbsMalRegressionview.InvalidAttachment();
		details="User validate the error";
		}
	@Test
	public void User_adding_an_eligible_student_in_malpracticeform() throws InterruptedException, AWTException{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User check that an eligible student is able to mark as malpractice </i>");
		AbsMalRegressionview.eligibleStudentInMalpractice();
		details="User add a malpractice student";
		}
	@Test
	public void User_checking_duplicate_validation_for_existing_malpractice_marked_student() throws InterruptedException, AWTException{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User check that malpractice marked student are not able to add again as malpractice </i>");
		AbsMalRegressionview.dupicateMalpractice();
		details="User add a malpractice student";
		}
	@Test
	public void User_verifying_malpractice_students_and_their_status() throws InterruptedException, AWTException{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User verifying students are properly marked in as malpractice and their status become submitted </i>");
		AbsMalRegressionview.verifyingMalStudentStatus();
		details="User verifying students who marked as malpractice";
		}
//	@Parameters({"examDetails"})
	@Test
	public void exam_Definition() throws InterruptedException
		{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User enters the exam details</i>");
		//Parameters are accepted  and used for searching the Exam definition used to enter absentee and malpractice
		AbsMalRegressionview.Details();
		details="The details are entered";
		}
	@Test
	public void user_click_on_exam_courses() throws InterruptedException, AWTException{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User click on button exam courses </i>");
		AbsMalRegressionview.examCoursesButton().click();
		Thread.sleep(1000);
		details="Button clicked";
		}
//	@Parameters({"institution"})
	@Test
	public void user_passing_institution() throws InterruptedException, AWTException{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User passing institution </i>");
		AbsMalRegressionview.institution( );
		Thread.sleep(1000);
		details="institution passed";
		}
	@Test
	public void University_User_revoking_absentee_details() throws InterruptedException, AWTException{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User revoking entered absentee data </i>");
		AbsMalRegressionview.Universityrevoke();
		Thread.sleep(1000);
		details="University user revoked data";
		}
	@Test
	public void User_entering_malpractice_student_as_absentee() throws InterruptedException, AWTException{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>  User validating error when entering malpractice marked student as absentee </i>");
		AbsMalRegressionview.AbsenteeMalpractice();
		Thread.sleep(1000);
		details="User validating error";
		}




















//	*************************************************************************************
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
		Desktop.getDesktop().browse(new File(fileName).toURI());
	}




}
