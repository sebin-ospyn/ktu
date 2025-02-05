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
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import com.ospyn.ktu.util.DriverConfig;
//import com.ospyn.ktu.util.GenerateExtentReport;
//import com.ospyn.ktu.util.Screenshot;
//import com.ospyn.ktu.util.ViewLogin;
//import com.ospyn.ktu.view.ViewEvaluationByCollege;
//import com.relevantcodes.extentreports.LogStatus;
//public class EvaluationByCollege extends DriverConfig {
////	Creating reference to ViewEvaluationByCollege
//	ViewEvaluationByCollege evaluationByCollegeview;
//	//	Creating reference for log in
//	static ViewLogin login;
//	//	Creating reference for extended reports
//	GenerateExtentReport report=Login.report;
//	//	Creating reference for extracting  screenshots of failed tests
//	Screenshot screenshot;
//	//	Creating static variable for adding details to log
//	String details;
//	//	Creating reference for driver
//	WebDriver driver;
//
//	//	Creating a static variable for assigning the test name before each test
//	static String[] testName;
//	private String testValue;
//	private String resultValue;
//	public static Object[] faculties;
//
//	public EvaluationByCollege() throws IOException {
//		/*initializing..
//		 * ExtentReport-->Using a class GenerateExtentReport class in the util package
//		 * WebDriver--->Using the DriverConfig class in the util package
//		 *
//		 */
//
//		screenshot = new Screenshot();
//		driver = getDriver();
//		report = Login.report;
//		evaluationByCollegeview = new ViewEvaluationByCollege(driver);
//
//	}
//
//	@BeforeTest
//	public void getTestName(final ITestContext testContext)
//	{
//		String test=testContext.getName(); // gets the test name assigned in the xml file
//		testName=test.split("-");
//	}
//
//
//	@Test
//	public void click_on_evaluation_by_college() throws InterruptedException
//	{
//		Thread.sleep(1000);
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>Checking whether user is able to click on Tab named evaluation by college</i>");
//		evaluationByCollegeview.evaluationBycollege();
//		details="User navigate to exam page";
//
//	}
//	@Test
//	public void click_Exam_Tab() throws InterruptedException
//	{
//		driver.manage().window().maximize();
//		Thread.sleep(1000);
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>Checking whether user is able to click on Tab named Exam</i>");
//		evaluationByCollegeview.exam();
//		details="User navigate to exam page";
//
//	}
//	public void click_Exam_Tab_faculty() throws InterruptedException{
//		Thread.sleep(1000);
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>Checking whether user is able to click on Tab named Exam</i>");
//		evaluationByCollegeview.exam();
//		details="User navigate to exam page";
//	}
//
//
//	@Test
//	public void user_search_course() throws InterruptedException
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User searching course and faculty details</i>");
//		evaluationByCollegeview.detailSearch();
//		details="User navigate to evaluation by college menu";
//
//	}
//
//	@Test
//	public void user_fetching_faculties() throws InterruptedException
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User fetching course and faculty details</i>");
//		evaluationByCollegeview.facultyFetch();
//		faculties=evaluationByCollegeview.facultyids;
//		details="User navigate to evaluation by college menu";
//
//	}
//	//	@Test
//	public void click_evaluaton_by_college_mark_entry_menu() throws InterruptedException {
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>Check whether user is able to  clicks on evaluation by college mark entry button</i>");
//		evaluationByCollegeview.clickMarkEntry();
//		details="User navigate to evaluation by college menu";
//
//	}
//	//	@Test
//	public void User_search_assigned_courses() throws InterruptedException {
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User searching assigned courses using filters</i>");
//		evaluationByCollegeview.userSearchassignedCourses();
//		details="User navigate to evaluation by college mark entry menu";
//
//	}
//	//	@Test
//	public void User_click_on_enter_marks() {
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User click on enter marks</i>");
//		evaluationByCollegeview.clicksEntermarks();
//		details="User navigate to mark entering page";
//
//	}
//	//	@Test
//	public void Faculty_entering_marks() throws InterruptedException{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User check that faculty is not able to enter marks more than the required mark,Check that absent marked student is not able to enter mark,Check that user able to submit data</i>");
//		evaluationByCollegeview.FacultyEnteringmarks();
//		details="User navigate to mark entering page";
//
//	}
//
//	public void logout_from_user() throws InterruptedException {
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User log out from college log in  </i>");
//		evaluationByCollegeview.logout();
//		details="User log out from college";
//	}
//	@Test
//	public void logout_from_college() throws InterruptedException{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User log out from college log in  </i>");
//		evaluationByCollegeview.logoutFromCollege();
//		details="User log out from college";
//
//	}
//	@Test
//	public void college_listout_faculty_submitted_details() throws InterruptedException{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> Check that college user is able to verify the marks which is entered by the faculties  </i>");
//		evaluationByCollegeview.ListFromCollege();
//		details="";
//
//	}
//	@Test
//	public void user_asserting_valution_submitted_by_faculty() {
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> Check that college user validating the status of valuation submitted by faculty  </i>");
//		evaluationByCollegeview.assertngValtnSbtByFaclty();
//
//		details="Asserting faculty submitted details";
//	}
//	@Test
//	public void User_click_submit_button() throws InterruptedException {
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> Check that  user is able to submit faculty submitted details to the uniersity  </i>");
//		evaluationByCollegeview.submitDetails();
//		details="faculty submitted details ";
//
//	}
//	@Test
//	public void User_assrtng_vltn_mrk_sbmitd_by_college() {
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> Check that college user validating the status of valuation after submitted by faculty  </i>");
//		evaluationByCollegeview.assertngValtnByCollege();
//		details="Asserting college submitted details";
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
//	//	****************************************************************************************************************************
//
//
//
//
//
//	public void loginUser(String facultyids)
//	{
//		try
//		{
//			String password="pass1@";
//
//			login=new ViewLogin(driver);
//			login.logIn(facultyids,password);
//			login.clickLogin();
//			Thread.sleep(1000);
//
//		}
//		catch(Exception e)
//		{
//			report.setLog(LogStatus.FAIL,"");
//		}
//	}
//
//
//	@Test(dataProvider="data-provider")
//	public void Valuation(String facultyids) {
//		try
//		{
//			report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"Login</b><br /><br /><i>User enters username "+facultyids+" and password -pass1@</i>");
//			loginUser(facultyids);
//			report.setLog(LogStatus.PASS,"");
//			Thread.sleep(1000);
//		}
//		catch(Exception e)
//		{
//			report.setLog(LogStatus.FAIL,"");
//		}
//		//		******************************
//		try
//		{
//			click_Exam_Tab_faculty();
//			Thread.sleep(1000);
//
//			report.setLog(LogStatus.PASS,"");
//		}
//		catch(Exception E)
//		{
//			report.setLog(LogStatus.FAIL,"");
//		}
//		//		*******************************
//		try
//		{
//			click_evaluaton_by_college_mark_entry_menu();
//			Thread.sleep(1000);
//
//			report.setLog(LogStatus.PASS,"");
//		}
//		catch(Exception E)
//		{
//			report.setLog(LogStatus.FAIL,"");
//		}
//		//		********************************
//		try
//		{
//			User_search_assigned_courses();
//			Thread.sleep(1000);
//
//			report.setLog(LogStatus.PASS,"");
//		}
//		catch(Exception E)
//		{
//			report.setLog(LogStatus.FAIL,"");
//		}
//
//		//		********************************
//		try
//		{
//			User_click_on_enter_marks();
//			Thread.sleep(1000);
//
//			report.setLog(LogStatus.PASS,"");
//		}
//		catch(Exception E)
//		{
//			report.setLog(LogStatus.FAIL,"");
//		}
//
//		//		*********************************
//		try
//		{
//			Faculty_entering_marks();
//			Thread.sleep(1000);
//
//			report.setLog(LogStatus.PASS,"");
//		}
//		catch(Exception E)
//		{
//			report.setLog(LogStatus.FAIL,"");
//		}
//		//		**********************************
//		try
//		{
//			logout_from_user();
//			Thread.sleep(1000);
//
//			report.setLog(LogStatus.PASS,"");
//		}
//		catch(Exception E)
//		{
//			report.setLog(LogStatus.FAIL,"");
//		}
//
//
//
//	}
//
//
//	@DataProvider(name = "data-provider")
//	public Object[] getDetails()
//	{
//		return faculties;
//	}
//
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
//		String fileName=System.getProperty("user.dir")+"/target/EvaluationByCollege_"+dtf.format(now)+".html";
//		File newFile=new File(fileName);
//
//		//Renaming the report with new name
//
//		System.out.println(oldFile.renameTo(newFile));
//
//		//Opening the report
//		Desktop.getDesktop().browse(new File(fileName).toURI());
//	}
//
//
//
//
//
//
//
//}
