package com.ospyn.ktu.test;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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
import com.ospyn.ktu.view.ViewFirstChanceCertificate;
import com.relevantcodes.extentreports.LogStatus;

public class FirstChanceCertificate extends DriverConfig{
//	Creating reference to ViewEvaluationByCollege
	ViewFirstChanceCertificate FirstChanceCertificateview;
	//	Creating reference for log in
	static ViewLogin login;
	//	Creating reference for extended reports
	GenerateExtentReport report=Login.report;
	//	Creating reference for extracting  screenshots of failed tests
	Screenshot screenshot;
	//	Creating static variable for adding details to log
	String details;
	//	Creating reference for driver
	WebDriver driver;

	//	Creating a static variable for assigning the test name before each test
	static String[] testName;
	private String testValue;
	private String resultValue;

	public FirstChanceCertificate() throws Exception {
		screenshot = new Screenshot();
		driver = getDriver();
		report = Login.report;
		FirstChanceCertificateview=new ViewFirstChanceCertificate(driver);

	}
	@BeforeTest
	public void getTestName(final ITestContext testContext)
	{
		String test=testContext.getName(); // gets the test name assigned in the xml file
		testName=test.split("-");
	}
//	*************************************************************************************

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
	/*
	 * @Test public void StudentLogIn(String username) { try {
	 * report.beginTest("<b>"+testName[0]+"<br />"+testName[1]
	 * +"Login</b><br /><br /><i>User enters username "
	 * +username+" and password -pass1@</i>"); loginUser(username);
	 * report.setLog(LogStatus.PASS,""); Thread.sleep(1000); } catch(Exception e) {
	 * report.setLog(LogStatus.FAIL,""); } }
	 */

//	*********************************************




//	**********************************************
	@Test
	public void student_fetch1() {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> Check that user is able to log in  </i>");
	//	FirstChanceCertificateview.test();
		//FirstChanceCertificateview.studentFetch();
		FirstChanceCertificateview.test();
	//		loginUser(rgNo);
//		loginUser(FirstChanceCertificateview.studentFetch());
		details="Logged";



	}
//	*****************************************************
	@Test
	public void test() throws InterruptedException {
		String regNo=FirstChanceCertificateview.studentFetch1();
		System.out.println(regNo);
		loginUser(regNo);
		Click_Exam();
	}
	@Test
	public void Click_Exam() throws InterruptedException {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> Check that user is able to click on exam tab  </i>");
		FirstChanceCertificateview.clickExam();
		details="Exam tab clicked";

	}
	@Test
	public void Click_First_chanceCertificate() {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> Check that user is able to click on first chance certificate tab  </i>");
		FirstChanceCertificateview.ClickFirstchanceCertificate();
		details="first chance certificate clicked";

	}
	@Test
	public void User_asserting_inviation() {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> Check that user asserting invitation  </i>");
		FirstChanceCertificateview.assertingInvitation();
		details="Asserted";

	}
	@Test
	public void Click_First_chanceCertificate_add_rqst_bttn() {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> Check that user asserting invitation  </i>");
		FirstChanceCertificateview.addreqst();
		details="Asserted";
	}
	@Test
	public void Validte_rechd_page() {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> Check that the invitaion page is reached  </i>");
		FirstChanceCertificateview.vldtePage();
		details="Asserted";
	}

	@Test
	public void Select_passd_courses() {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User select the passed courses for certificate  </i>");
		FirstChanceCertificateview.selectPssdCourse();
		details="Selected";

	}
	@Test
	public void Adding_Attachmnt_and_submit() throws Exception {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User adding first chance certificate document  </i>");
		FirstChanceCertificateview.attachmentDoc();
		details="attachment added";
	}
	@Test
	public void Certificate_payment() throws Exception {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User certificate payment  </i>");
		FirstChanceCertificateview.payment();
		details="payment done";

	}
	@Test
	public void log_out() throws InterruptedException {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User logged out  </i>");
		FirstChanceCertificateview.logout();
		details="logout  done";
		}
	@Test
	public void Staffadvsr_Click_Fstchncreqst() {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>Check that staff advisor is able to click firstchanceCertificate menu  </i>");

		FirstChanceCertificateview.StaffadvsrClickFirstchanceCertificate();
		details="clicked";

		}

//	@Test
//	public void Fetch_student_Regno() {
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User fetching student reg.no  </i>");
//
//
//	}
	@Test
	public void Fetching_data() throws InterruptedException {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User fetching student and staff advisor data </i>");
		FirstChanceCertificateview.fetchData();
		details="clicked";
		}
	@Test
	public void Staffadvsr_choose_submittedStudent() {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> Staff advisor choose requested student </i>");
		FirstChanceCertificateview.advsrSelctStdnt();
		details="clicked";
		}
	@Test
	public void Frwrded_to_prncpl() throws InterruptedException {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> Staff advisor choose recommend </i>");
		FirstChanceCertificateview.frwrdToPrncpl();
		details="forwarded to principal";
		}
	@Test
	public void College_choose_submittedStudent() throws InterruptedException {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> College user choose staff advisor requested student </i>");
		FirstChanceCertificateview.cllgeSelctStdnt();
		details="clicked";

	}
	@Test
	public void Frwrded_to_university() throws Exception {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> principal submit or recommend firstchance certificate request to university </i>");
		FirstChanceCertificateview.frwrdToUnivrsty();
		details="Submited";
	}
	@Test
	public void University_user_click_first_chanceCertificate() {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> principal submit or recommend firstchance certificate request to university </i>");
		FirstChanceCertificateview.UniversityClickFirstchanceCertificate();
		details=" ";
	}
	@Test
	public void User_choose_stdnt_sbmtd_by() {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> University user choose student which is submitted by principal </i>");
		FirstChanceCertificateview.UserChooseStdntSbmtdby();
		details=" ";

	}
	@Test
	public void University_apprv() throws InterruptedException {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> University user approve certificate </i>");
		FirstChanceCertificateview.unvstyApprv();
		details="Approve button clicked";

	}
	@Test
	public void Studnt_click_editReqst() {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>  Stdent user click on edit request to generate first chance certificate </i>");
		FirstChanceCertificateview.clickEditreqst();
		details="Navigated to certificate generate page";
	}
	@Test
	public void Studnt_generate_firstchancecetfctt() throws Exception {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>  Stdent user  generate first chance certificate </i>");
		FirstChanceCertificateview.StdntGenrtefrstChnceCrtfct();
		details="Navigated to certificate generate page";

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

		String fileName=System.getProperty("user.dir")+"/target/FirstChanceCertificate_"+dtf.format(now)+".html";
		File newFile=new File(fileName);

		//Renaming the report with new name

		System.out.println(oldFile.renameTo(newFile));

		//Opening the report
		Desktop.getDesktop().browse(new File(fileName).toURI());
	}









}
