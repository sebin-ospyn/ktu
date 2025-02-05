package com.ospyn.ktu.test;
import static org.testng.AssertJUnit.assertEquals;

import java.awt.AWTException;
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
import com.ospyn.ktu.view.ViewFalseNumbergeneration;
import com.relevantcodes.extentreports.LogStatus;

public class Falsenumbergeneration extends DriverConfig {

	ViewFalseNumbergeneration falseNumbergenerationview;

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
			private String testValue;
			private String resultValue;



//*********************************************************************************
	public Falsenumbergeneration() throws IOException
	{
		/*initializing..
//		 * ExtentReport-->Using a class GenerateExtentReport class in the util package
//		 * WebDriver--->Using the DriverConfig class in the util package
//		 *
//		 */
		screenshot=new Screenshot();
		driver=getDriver();
		falseNumbergenerationview=new ViewFalseNumbergeneration(driver);
	}
	@BeforeTest
	public void getTestName(final ITestContext testContext)
	{

		String test=testContext.getName(); // gets the test name assigned in the xml file
		testName=test.split("-");

	}

//	************************************************
	@Test
	public void user_Click_Generate_Falsenumber_Menu() throws InterruptedException, AWTException
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User click generate false number menu </i>");
		falseNumbergenerationview.Falsenumbergenerate();
		details="False number generation page displayed";
	}
	@Test
	public void user_Validating_Falsenumber_Listing_Page() throws InterruptedException{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User enter into falsenumberlisting page </i>");
		testValue = "False No/Bar Code Generation";
		resultValue = falseNumbergenerationview.ValidateText();
		assertEquals(testValue, resultValue);
		details="user entered into falsenumber listing page and validate that user reached in that page";
	}
	@Test
	public void click_Valuation_Module() throws InterruptedException, AWTException {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User click valuation module </i>");
		falseNumbergenerationview.Valuationmodule();
		details="Valution module will displayed";
	}
	@Test
	public void user_Click_Add_Button() throws InterruptedException, AWTException {
 		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User click Add Button </i>");
		falseNumbergenerationview.Addbutton();
		details="False number adding page will get displyed";
	}
//	@Parameters({"generatefalsenumber"})
	@Test
	public void user_Generate_Falsenumber() throws InterruptedException, AWTException{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User generating  false number </i>");
		falseNumbergenerationview.generatefalsenumber();
		details="false number generating page is displyed and data entered,generated";
	}
	@Test
	public void user__Validating_Falsenumber() throws InterruptedException
	{
 		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User validating whether the false number created or not </i>");
 		testValue = "Created";
		resultValue = falseNumbergenerationview.Validatecreatedtext();
		assertEquals(testValue, resultValue);
		details="User validating whether the false number created or not";
	}
	@Test
    public void user_Click_Edit_Course() throws InterruptedException
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User choose edit button to select courses  </i>");
		falseNumbergenerationview.Clickeditbutton();
		details=" user select edit course ";
	}
	@Test
	public void user_Click_Approve() throws InterruptedException
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User choose edit button to select courses  </i>");
		falseNumbergenerationview.Clickedapprove();
		details=" user select edit course ";
	}
	@Test
	public void user_Click_Generate_Barcode_Button() throws InterruptedException, AWTException{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User choose generate barcode button   </i>");
		falseNumbergenerationview.Clickgenerate();
		details=" page get loaded and barcod get generated ";
	}
	@Test
	public void user_configure_false_numbers() throws InterruptedException, AWTException {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User configuring false numbers </i>");
		falseNumbergenerationview.configurefalsenumber();
		details="user configured false number";
	}
	@Test
	public void  user_validating_event_type() throws InterruptedException, AWTException
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User validate field event type </i>");
		falseNumbergenerationview.eventValidating();
		details="user validated field event type";
	}
	@Test
	public void  user_validating_exam_specific_event() throws InterruptedException, AWTException
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User validate field exam specific event </i>");
		falseNumbergenerationview.examSpecificevent();
		details="user validated field  exam specific event";
	}
	@Test
	public void  user_validating_flase_number_from_field() throws InterruptedException, AWTException
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User validate field named false number from </i>");
		falseNumbergenerationview.falseNumberfrom();
		details="user validated field false number from";
	}
	@Test
	public void user_click_courseselection_button() throws InterruptedException
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User click on course selection button </i>");
		falseNumbergenerationview.courseSelection();
		details="course selection button clicked";
	}
	@Test
	public void user_approve_falsenumber_generate_request() throws InterruptedException
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User approve false number generating request </i>");
		falseNumbergenerationview.requestapprove();
		details="user request approved";
	}

	@Test
	public void user_validating_status() throws InterruptedException
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User validating status of false number generated </i>");
		testValue="Created";
		resultValue=falseNumbergenerationview.validateStatus();
		assertEquals(testValue, resultValue);
		details="status validated";
	}
	@Test
	public void user_generating_barcode() throws InterruptedException
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User generating barcode </i>");
		falseNumbergenerationview.generateBarcode();
		details="user generated barcode";
	}
	@Test
	public void user_validating_barcode() throws InterruptedException
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User validating status of false number is changed from created to barcode generated </i>");
		testValue="Bar Code Generated";
		resultValue=falseNumbergenerationview.validatebarcodegenerated();
		assertEquals(testValue, resultValue);
		details="status validated";
	}
	@Test
	public void user_generating_zip() throws InterruptedException {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User generating zip</i>");

		falseNumbergenerationview.generateZip();

		details="user generated zip ";
	}

	@Test
	public void User_passing_year_program() throws InterruptedException {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User check that falsenumber is listing or not </i>");
		falseNumbergenerationview.serchingfalsenumber();
		details="status validated";

	}

	@Test
	public void User_click_edit_button() throws InterruptedException {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User click on edit falsenumber button </i>");
		falseNumbergenerationview.clickEdit();
		details="status validated";
	}

	@Test
	public void User_configure_falsenumbers() throws InterruptedException, AWTException {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User configuring false numbers </i>");
		falseNumbergenerationview.Reconfigurefalsenumber();
		details="user configured false number";
	}

	@Test
	public void User_checking_whether_the_camp_is_present() {
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User check whether that the valuation camp is created or not </i>");
		falseNumbergenerationview.addOReditValuationcamp();
		details="user validate valuation camp";

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

		String fileName=System.getProperty("user.dir")+"/target/FalseNumberGeneration_"+dtf.format(now)+".html";
		File newFile=new File(fileName);

		//Renaming the report with new name

		System.out.println(oldFile.renameTo(newFile));

		//Opening the report
		//Desktop.getDesktop().browse(new File(fileName).toURI());
	}





}