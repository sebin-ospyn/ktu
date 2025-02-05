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
import org.testng.annotations.Test;

import com.ospyn.ktu.util.DriverConfig;
import com.ospyn.ktu.util.GenerateExtentReport;
import com.ospyn.ktu.util.Screenshot;
import com.ospyn.ktu.util.ViewLogin;
import com.ospyn.ktu.view.ViewAttendanceDataPreparation;
import com.relevantcodes.extentreports.LogStatus;

public class AttendanceDataPreparation extends DriverConfig {
	ViewAttendanceDataPreparation AttendanceDataPreparation;
//	Create reference for log in
	static ViewLogin login;
//	Create reference for creating Extend Reports
	static GenerateExtentReport report=Login.report;
	//Creating reference for extracting  screenshots of failed tests
		Screenshot screenshot;
		//Creating static variable for adding details to log
		String details;
		//Creating reference for driver
		WebDriver driver;
		static  String[] testName;
		private String testValue;
		private String resultValue;
		static Object[] studentData;

		public static String[] RetrievedFacultyId;
		public static Object[] faculties;
		public static Object[] branches;





		public AttendanceDataPreparation() throws IOException
		{
			/*initializing..
//		 * ExtentReport-->Using a class GenerateExtentReport class in the util package
//		 * WebDriver--->Using the DriverConfig class in the util package
//		 *
//		 */
			screenshot = new Screenshot();
			driver=getDriver();
			report=Login.report;
			AttendanceDataPreparation=new ViewAttendanceDataPreparation(driver);
		}

		@BeforeTest
		public void getTestName(final ITestContext testContext)
		{
			String test=testContext.getName(); // gets the test name assigned in the xml file
			testName=test.split("-");
		}
//		*************************************************************************************

		@Test
		public void User_fetch_Course_details_from_excel() throws IOException {

			AttendanceDataPreparation.readCourseFromExcelAndStoreInMap();
		}


		@Test
		public void click_student_attandance_internal() throws InterruptedException, AWTException {
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>Attendance internal page displyed</i>");
			AttendanceDataPreparation.Attendanceinternal();
			branches=AttendanceDataPreparation.Branchnames;
			details="User navigate to Attendance internal page  ";
		}

		@Test
		public void click_Exam_Tab()throws Exception

		{
			driver.manage().window().maximize();
			Thread.sleep(1000);
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User clicks the Exam tab</i>");
			//Getting Exam tab and clicking the tab
			AttendanceDataPreparation.getExam().sendKeys(Keys.ENTER);
			details="User navigates to the Exam Page";
			Thread.sleep(1000);

		}
//		**************************************************************
		@Test(dataProvider="branch")
		public void user_click_Internals_Button(String branchname)throws Exception
		{
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User click the Student internals/Attendance button of "+branchname+"</i>");

			try
			{
				AttendanceDataPreparation.clickInternalsButton(branchname);
				Thread.sleep(3000);

				report.setLog(LogStatus.PASS,"");
			}
			catch(Exception e)
			{
				report.setLog(LogStatus.FAIL,"");
			}
			details="User navigates to the Students Attendance/Internal Listing page will be displayed";

			try
			{
				user_fetch_course_code_Faculty_Id();
				Thread.sleep(1000);

				report.setLog(LogStatus.PASS,"");
			}
			catch(Exception E)
			{
				report.setLog(LogStatus.FAIL,"");
			}
			try
			{
				user_click_the_Academics_Auditing_Tab();
				Thread.sleep(2000);
				report.setLog(LogStatus.PASS,"");
			}
			catch(Exception e)
			{
				report.setLog(LogStatus.FAIL,"");
			}

			try
			{

				user_select_staff_Advisor();
				Thread.sleep(2000);
				report.setLog(LogStatus.PASS,"");
			}
			catch(Exception e)
			{
				report.setLog(LogStatus.FAIL,"");
			}


			try
			{
				logout_from_user();
				Thread.sleep(2000);
				report.setLog(LogStatus.PASS,"");
			}
			catch(Exception e)
			{
				report.setLog(LogStatus.FAIL,"");
			}
			try
			{
				Thread.sleep(1000);
				loginUser("ktusupport02");
				//	report.setLog(LogStatus.PASS,"");

			}
			catch(Exception e)
			{
				report.setLog(LogStatus.FAIL,"");
			}


			try
			{
				User_click_the_Academics_Tab();
				Thread.sleep(1000);
				report.setLog(LogStatus.PASS,"");

			}
			catch(Exception e)
			{
				report.setLog(LogStatus.FAIL,"");
			}

			try
			{
				user_clicks_Course_menu();
				report.setLog(LogStatus.PASS,"");
			}
			catch(Exception e)
			{

				report.setLog(LogStatus.FAIL,"");
			}
			try
			{

				user_get_the_course_type_from_course_code();
				report.setLog(LogStatus.PASS,"");

			}
			catch(Exception e)
			{
				report.setLog(LogStatus.FAIL,"");
			}
			try
			{
				click_Exam_Tab();
				report.setLog(LogStatus.PASS,"");
			}
			catch(Exception e)
			{
				report.setLog(LogStatus.FAIL,"");
			}

			try
			{
				click_Evaluation_plan_side_menu();
				report.setLog(LogStatus.PASS,"");
			}
			catch(Exception e)
			{
				report.setLog(LogStatus.FAIL,"");
			}
			try
			{
				user_Enters_The_Scheme();
				report.setLog(LogStatus.PASS,"");
			}
			catch(Exception e)
			{
				report.setLog(LogStatus.FAIL,"");
			}


			try
			{
				user_Get_The_Configuration_Details_From_Evaluation_Plan();
				report.setLog(LogStatus.PASS,"");
			}
			catch(Exception e)
			{
				report.setLog(LogStatus.FAIL,"");
			}


			try
			{
				logout_from_user();
				report.setLog(LogStatus.PASS,"");
			}

			catch(Exception e)
			{

			}
			try
			{
				for(Object faculty:faculties)
				{
					Attendance_Internal(faculty+"");
				}
			}
			catch(Exception e)
			{
				report.setLog(LogStatus.FAIL,"");
			}

			try
			{
				User_login_as_Staff_Advisor();
				report.setLog(LogStatus.PASS,"");
			}



			catch(Exception e)
			{
				report.setLog(LogStatus.FAIL,"");
			}
			try
			{
				click_Exam_Tab();
				Thread.sleep(2000);
				report.setLog(LogStatus.PASS,"");
			}



			catch(Exception e)
			{
				report.setLog(LogStatus.FAIL,"");
			}
			try
			{
				User_clicks_on_advisors_Batches();
				Thread.sleep(2000);

				report.setLog(LogStatus.PASS,"");
			}

			catch(Exception e)
			{
				report.setLog(LogStatus.FAIL,"");
			}
			try
			{
				User_filter_advisor_batches_data();
				report.setLog(LogStatus.PASS,"");
			}

			catch(Exception e)
			{
				report.setLog(LogStatus.FAIL,"");
			}

			try
			{
				StaffAdvisor_confirmAttendance();
				Thread.sleep(3000);

				report.setLog(LogStatus.PASS,"");
			}


			catch(Exception e)
			{
				report.setLog(LogStatus.FAIL,"");
			}


			try
			{
				logout_from_user();
				report.setLog(LogStatus.PASS,"");

			}
			catch(Exception e)
			{
				report.setLog(LogStatus.FAIL,"");
			}
			try
			{
				loginUser(AttendanceDataPreparation.getCollege());
				report.setLog(LogStatus.PASS,"");

			}
			catch(Exception e)
			{
				report.setLog(LogStatus.FAIL,"");
			}
			try
			{
				click_Exam_Tab();
				report.setLog(LogStatus.PASS,"");

			}
			catch(Exception e)
			{
				report.setLog(LogStatus.FAIL,"");
			}
			try
			{
	 			click_student_attandance_internal();

				report.setLog(LogStatus.PASS,"");


			}
			catch(Exception e)
			{
				report.setLog(LogStatus.FAIL,"");
			}



		}

		@DataProvider(name = "branch")
		public Object[] getDetailsBranches()
		{

			return branches;
		}









//		*************************************************************
		public void user_fetch_course_code_Faculty_Id() throws InterruptedException
		{
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User fetch the course code and Faculty Id</i>");

			RetrievedFacultyId = AttendanceDataPreparation.CoursecodeFacultyId();
			faculties=AttendanceDataPreparation.facultyids;

			System.out.println("faculties are");
			System.out.println("**************");
			for (String element : ViewAttendanceDataPreparation.batchnames)
				System.out.println(element);

			details="User navigates to faculty and course lisiting page";

		}
		public void user_click_the_Academics_Auditing_Tab() throws InterruptedException{
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User click the academic auditing tab</i>");
			AttendanceDataPreparation.getAcademicAuditing().sendKeys(Keys.ENTER);
			details="User navigates to faculty and staff advisor selecting page";
		}
		public void user_select_staff_Advisor() throws InterruptedException, AWTException {
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User choose staff advisor</i>");

			AttendanceDataPreparation.StaffAdvisor();
		}
//		****************************************************************************************************************
		public void logout_from_user() throws InterruptedException {
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User log out from college log in  </i>");
			AttendanceDataPreparation.logout();
			details="User log out from college";
		}
		public void User_click_the_Academics_Tab() throws InterruptedException{
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User click on academic module</i>");
			AttendanceDataPreparation.getAcademics().click();
			details="User navigates to academic module page";
			Thread.sleep(1000);
		}
		public void user_clicks_Course_menu() throws InterruptedException{
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User click on course menu</i>");
			AttendanceDataPreparation.getCoursemenu().click();
			details="User navigates to course page";
		}
		public void user_get_the_course_type_from_course_code() throws InterruptedException{
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User get the course type from course code</i>");
			AttendanceDataPreparation.getCoursetype();
			details="User fetching course type from course code";

		}
		public void click_Evaluation_plan_side_menu() throws InterruptedException{
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User click on evaluation menu</i>");
			AttendanceDataPreparation.getEvaluationPlan().click();
			Thread.sleep(1000);
			details="User click on evaluation menu";
		}
		public void user_Enters_The_Scheme() throws InterruptedException{
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User navigate into evaluation plan page</i>");
			AttendanceDataPreparation.Schemeselection();
			details="User enter into evaluation plan";
		}
		public void user_Get_The_Configuration_Details_From_Evaluation_Plan() throws InterruptedException
		{
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User fetch details from  evaluation plan</i>");
			AttendanceDataPreparation.getConfigurationdetails();
			details="User fetch details from evaluation plan";
		}
		public void User_click_on_Academics() throws InterruptedException{
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User clicks on academics module</i>");
			AttendanceDataPreparation.getAcademics().click();
			details="User clicks on academics module";
		}
		public void User_clicks_on_assignedcourses() throws InterruptedException{
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User clicks on assignedcourses submodule</i>");
			AttendanceDataPreparation.getAssignedCourses().click();
			details="User clicks on assignedcourses sub module";
		}
		public void User_fetching_faculty_assignedcourses() throws InterruptedException, AWTException{
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>Faculty navigate to course assigned page then Entering Valid,Invalid,attendance and internal also checking their eligibility. </i>");
			AttendanceDataPreparation.facultylistingcourse();
			details="Faculty enter into course assigned page";
		}
		public void User_login_as_Staff_Advisor() throws InterruptedException{
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User log in as staff advisor</i>");
			System.out.println(ViewAttendanceDataPreparation.StaffAdvisorId.get(0));
			loginUser(ViewAttendanceDataPreparation.StaffAdvisorId.get(0));
			details="User logged as staff advisor";
		}
		public void User_clicks_on_advisors_Batches() throws InterruptedException{
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User clicks on advisors batches submodule</i>");
			AttendanceDataPreparation.getAdvisorsBatches().click();
			details="User navigate into advisors Batches list page ";
		}
		public void click_Login_Button() throws InterruptedException{
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User clicks on login button</i>");
			AttendanceDataPreparation.getLogin().sendKeys(Keys.ENTER);
			details="User logged into page ";
		}
		public void User_filter_advisor_batches_data() throws InterruptedException{
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>Faculty user navigate to course assigned page</i>");
			//	String advisorBatch="2023 - 2024,#B.Tech,#Full Time,#S5,#Pursuing Students,#Regular";
			AttendanceDataPreparation.advisorBatches();
			details="Faculty enters into course assigned page";
		}
		@Test
		public void User_click_Student_Attendance_Internals_option() throws InterruptedException {
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> College user submit attendance internal to university</i>");
			AttendanceDataPreparation.AttendanceInternals();
			details="attendance internal submitted to university";
		}
		@Test
		public void College_Submit_the_student_Attendance_and_Internal() throws InterruptedException, AWTException{
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> College user submit branch wise  attendance internal </i>");
			AttendanceDataPreparation.branchSubmit();
			Thread.sleep(500);
			AttendanceDataPreparation.clearAll();
			details="After submitting attendance internal, there is a message shown which is attendance internal submitted to university ";
		}
		@Test
		public void User_validate_successful_submit_validation() throws InterruptedException {
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>  College user validate the successful submission of attendance internal to the university </i>");
			testValue = "Your institution's Internals have been submitted for the selected program to the university.Please generate the hallticket to update the eligibility";
			Thread.sleep(6000);
			resultValue = AttendanceDataPreparation.validationMsg();
			assertEquals(true,testValue.startsWith(resultValue));

			Thread.sleep(1000);
			details="atteance internal submitted to the university";
		}
		@Test
		public void StaffAdvisor_confirmAttendance() throws InterruptedException
		{
			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>Staff advisor confirms attendance internal</i>");
			AttendanceDataPreparation.confirmAttendance();
			details="after confirms atteandance the status submitted by faculty changed to submitted by staff advisor ";
		}
		//@Test(dataProvider="data-provider")
		public void loginUser(String username)
		{
			try
			{
				String password="pass1@";

				login=new ViewLogin(driver);
				login.logIn(username,password);
				login.clickLogin();
				Thread.sleep(1000);

			}
			catch(Exception e)
			{
				report.setLog(LogStatus.FAIL,"");
			}
		}
		public void Attendance_Internal(String username){


			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"Login</b><br /><br /><i>User enters username "+username+" and password -pass1@</i>");

			try
			{
				loginUser(username);
				report.setLog(LogStatus.PASS,"");
				Thread.sleep(1000);
			}
			catch(Exception e)
			{
				report.setLog(LogStatus.FAIL,"");
			}
			//		***************************************

			try {

				User_click_on_Academics();
				Thread.sleep(1000);
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
				Thread.sleep(1000);
				report.setLog(LogStatus.PASS,"");
			}
			catch(Exception e)
			{
				report.setLog(LogStatus.FAIL,"");
			}
			//		**************************************
			try
			{

				User_fetching_faculty_assignedcourses();
				report.setLog(LogStatus.PASS,"");

			}
			catch(Exception e) {
				report.setLog(LogStatus.PASS,"");

			}
			try {
				Thread.sleep(3000);
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




//		*************************************************************************************
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

			String fileName=System.getProperty("user.dir")+"/target/Attendance_Internal_datapreparation_"+dtf.format(now)+".html";
			File newFile=new File(fileName);

			//Renaming the report with new name

			System.out.println(oldFile.renameTo(newFile));

			//Opening the report
			Desktop.getDesktop().browse(new File(fileName).toURI());
		}
}
