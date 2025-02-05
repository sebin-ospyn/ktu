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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ospyn.ktu.util.DriverConfig;
import com.ospyn.ktu.util.GenerateExtentReport;
import com.ospyn.ktu.util.Screenshot;
import com.ospyn.ktu.util.ViewLogin;
import com.ospyn.ktu.view.ViewAttendanceInternal;
import com.relevantcodes.extentreports.LogStatus;

public class AttendanceInternal extends DriverConfig   {
	ViewAttendanceInternal attendanceinternal;

	//creating reference for Login
	static ViewLogin login;

	//Creating reference for creating Extent Reports
	static GenerateExtentReport report=Login.report;

	//Creating reference for extracting  screenshots of failed tests
	Screenshot screenshot;

	//Creating static variable for adding details to log
	String details;

	//Creating reference for driver
	WebDriver driver;

	//creating a static variable for assigning the test name  before each test
	static String[] testName;
	private String testValue;
	private String resultValue;
	public static String[] RetrievedFacultyId;
	public static Object[] faculties;


	public AttendanceInternal()
	{
		/*initializing..
//		 * ExtentReport-->Using a class GenerateExtentReport class in the util package
//		 * WebDriver--->Using the DriverConfig class in the util package
//		 *
//		 */
		screenshot = new Screenshot();
		driver=getDriver();
		report=Login.report;
		attendanceinternal=new ViewAttendanceInternal(driver);

	}

	@BeforeTest
	public void getTestName(final ITestContext testContext)
	{

		String test=testContext.getName(); // gets the test name assigned in the xml file
		testName=test.split("-");

	}

	@Parameters({"attendanceinternaldetails"})
	@Test
	public void click_student_attandance_internal(String AttendanceDetails) throws InterruptedException, AWTException {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>Attendance internal page displyed</i>");
		attendanceinternal.Attendanceinternal(AttendanceDetails);
		details="User navigate to Attendance internal page  ";

	}



	@Test
	public void click_Exam_Tab()throws Exception

	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User clicks the Exam tab</i>");
		//Getting Exam tab and clicking the tab
		attendanceinternal.getExam().sendKeys(Keys.ENTER);
		details="User navigates to the Exam Page";
		Thread.sleep(1000);

	}
	@Test
	public void user_course_code_Faculty_Id() throws InterruptedException {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User fetch the course code and Faculty Id</i>");

		RetrievedFacultyId = attendanceinternal.CoursecodeFacultyId();
		faculties=ViewAttendanceInternal.facultyids;

			details="User navigates to faculty and course lisiting page";

	}
	@Test
	public void user_click_the_Academics_Auditing_Tab() throws InterruptedException{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User click the academic auditing tab</i>");
		attendanceinternal.getAcademicAuditing().sendKeys(Keys.ENTER);
		details="User navigates to faculty and staff advisor selecting page";
	}

	@Parameters({"staffadvisordetails"})
	@Test
	public void user_select_staff_Advisor(String advisor) throws InterruptedException, AWTException {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User choose staff advisor</i>");
		attendanceinternal.StaffAdvisor(advisor);
		details="User navigates to faculty and staff advisor selecting page";

	}

	@Test

	public void logout_from_user() throws InterruptedException {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User log out from college log in  </i>");
		attendanceinternal.logout();
		details="User log out from college";
	}
	@Test
	public void User_click_the_Academics_Tab() throws InterruptedException{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User click on academic module</i>");
		attendanceinternal.getAcademics().click();
		details="User navigates to academic module page";

		Thread.sleep(1000);
	}
	@Test
	public void user_clicks_Course_menu() throws InterruptedException{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User click on course menu</i>");
		attendanceinternal.getCoursemenu().click();
		details="User navigates to course page";
	}
	@Test
	public void user_get_the_course_type_from_course_code() throws InterruptedException{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User get the course type from course code</i>");
		attendanceinternal.getCoursetype();
		details="User fetching course type from course code";

	}
	@Test
	public void click_Evaluation_plan_side_menu() throws InterruptedException{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User click on evaluation menu</i>");
		attendanceinternal.getEvaluationPlan().click();
		Thread.sleep(1000);
		details="User click on evaluation menu";


	}
	@Parameters({"Evaluationplan"})
	@Test
	public void user_Enters_The_Scheme(String stringList) throws InterruptedException{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User navigate into evaluation plan page</i>");
		attendanceinternal.Schemeselection(stringList);
		details="User enter into evaluation plan";



	}
	@Test
	public void user_Get_The_Configuration_Details_From_Evaluation_Plan() throws InterruptedException{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User fetch details from  evaluation plan</i>");

		attendanceinternal.getConfigurationdetails();
		details="User fetch details from evaluation plan";

	}


	public void User_click_on_Academics() throws InterruptedException{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User clicks on academics module</i>");
		attendanceinternal.getAcademics().click();
		details="User clicks on academics module";

	}


	public void User_clicks_on_assignedcourses() throws InterruptedException{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User clicks on assignedcourses submodule</i>");
		attendanceinternal.getAssignedCourses().click();
		details="User clicks on assignedcourses sub module";

	}
  	public void User_fetching_faculty_assignedcourses(String AssignedCourses) throws InterruptedException{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>Faculty navigate to course assigned page</i>");
		attendanceinternal.facultylistingcourse(AssignedCourses);
		details="Faculty enter into course assigned page";
	}

	@Test
	public void User_login_as_Staff_Advisor() throws InterruptedException{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User log in as staff advisor</i>");
		attendanceinternal.loginasStaffAdvisor();
		details="User logged as staff advisor";
	}
	@Test
	public void User_clicks_on_advisors_Batches() throws InterruptedException{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User clicks on advisors batches submodule</i>");
		attendanceinternal.getAdvisorsBatches().click();
		details="User navigate into advisors Batches list page ";

	}
	@Test
	public void click_Login_Button() throws InterruptedException{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User clicks on login button</i>");
		attendanceinternal.getLogin().sendKeys(Keys.ENTER);
		details="User logged into page ";

	}
	@Parameters({"advisorBatches"})
	@Test
	public void User_filter_advisor_batches_data(String advisorBatch) throws InterruptedException{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>Faculty user navigate to course assigned page</i>");
		attendanceinternal.advisorBatches(advisorBatch);
		details="Faculty enter into course assigned page";
	}
	@Parameters({"collegeSubmit"})
	@Test
	public void User_click_Student_Attendance_Internals_option(String collegeSubmit) throws InterruptedException {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> College user submit attendance internal to university</i>");
		attendanceinternal.AttendanceInternals(collegeSubmit);
		details="atteance internal submitted to university";

	}
	@Test
	public void College_Submit_the_student_Attendance_and_Internal() throws InterruptedException, AWTException{
	report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> College user submit branch wise  attendance internal </i>");
	attendanceinternal.branchSubmit();
	details=" after submitting attendance internal there is a message shown which is attendance internal submitted to university ";
	}

	@Test
	public void User_validate_successful_submit_validation() throws InterruptedException {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>  College user validate the successful submission of attendance internal to the university </i>");

 		testValue = "Your institution's Internals have been submitted for the selected program to the university .\n"
				+ "Please generate the hallticket to update the eligibility ";

		Thread.sleep(2000);
		resultValue = attendanceinternal.validationMsg();
		assertEquals(testValue, resultValue);
		Thread.sleep(1000);
		details="atteance internal submitted to the university";


	}

	@Test
	public void StaffAdvisor_confirmAttendance() throws InterruptedException{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>Staff advisor confirms attendance internal</i>");
		attendanceinternal.confirmAttendance();
		details="after confirms atteandance the status submitted by faculty changed to submitted by staff advisor ";

	}
	@Test(dataProvider="data-provider")
	public void Attendance_Internal(String username){


		System.out.println("hello***********");
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"Login</b><br /><br /><i>User enters username "+username+" and password -pass1@</i>");


		try
		{
			String password="pass1@";
			login=new ViewLogin(driver);
			login.logIn(username,password);
			details="User name and password are entered";
			login.clickLogin();
			Thread.sleep(1000);
//			login.logOut();
			Thread.sleep(1000);
			report.setLog(LogStatus.PASS,"");

		}
		catch(Exception e)
		{
			report.setLog(LogStatus.FAIL,"");
		}
//		***************************************

		try {

		System.out.println("say hello");
			User_click_on_Academics();
			report.setLog(LogStatus.PASS,"");

		}
		catch(Exception e)
		{
			report.setLog(LogStatus.FAIL,"");

		}
//		**************************************
		try
		{
			User_clicks_on_assignedcourses();
			report.setLog(LogStatus.PASS,"");
 		}
		catch(Exception e)
		{
			report.setLog(LogStatus.FAIL,"");
		}
//		**************************************
		try
		{
			String facultyAssignedCourses="2022 - 2023,#B.Tech,#Full Time,#Even,#Pursuing Students";
			User_fetching_faculty_assignedcourses(facultyAssignedCourses);
			report.setLog(LogStatus.PASS,"");

		}
		catch(Exception e) {
			report.setLog(LogStatus.FAIL,"");

		}
		try {
		login.logOut();
		report.setLog(LogStatus.PASS,"");
		}
		catch(Exception e) {
		report.setLog(LogStatus.FAIL,"");

		}
		}

	@DataProvider(name = "data-provider")
	public Object[] getDetails()
	{
		for (Object element : faculties)
			System.out.println(element);
		return faculties;
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

		String fileName=System.getProperty("user.dir")+"/target/AbsenteeMalPracticeBulk_"+dtf.format(now)+".html";
		File newFile=new File(fileName);

		//Renaming the report with new name

		System.out.println(oldFile.renameTo(newFile));

		//Opening the report
		Desktop.getDesktop().browse(new File(fileName).toURI());
	}


}
