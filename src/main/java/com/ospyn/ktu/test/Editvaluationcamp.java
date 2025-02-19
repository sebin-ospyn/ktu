package com.ospyn.ktu.test;

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
import com.ospyn.ktu.view.ViewEditingvaluationcamp;
import com.relevantcodes.extentreports.LogStatus;

public class Editvaluationcamp extends DriverConfig {
//	Creating reference to ViewAddingvaluationCamp
	ViewEditingvaluationcamp Addingvaluationcampview;
//	Creating reference for Log In
	static ViewLogin login;
//	Creating reference for extracting  screenshots of failed tests
	Screenshot screenshot;
//	Creating static variable for adding details to log
	String details;
//	Creating reference for creating Extent Reports
	GenerateExtentReport report=Login.report;
//	Creating reference for driver
	WebDriver driver;
//creating a static variable for assigning the test name  before each test
			static String[] testName;
			private String testValue;
			private String resultValue;

public Editvaluationcamp() throws IOException
			{
				/*initializing..
//				 * ExtentReport--> Using a class GenerateExte
//				 * WebDriver---> Using the DriverConfig class in the util package
//				 *
//				 */
				screenshot=new Screenshot();
				driver=getDriver();
				report=Login.report;
				Addingvaluationcampview = new ViewEditingvaluationcamp(driver);

			}
@BeforeTest
public void getTestName(final ITestContext testContext)
{
	String test=testContext.getName(); // gets the test name assigned in the xml file
	testName=test.split("-");
//	System.out.println(testName[0]+" "+testName[1]);
}
//******************************************************************************************
@Test
public void User_searching_created_camp() throws AWTException, InterruptedException {
	report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User searching created camp </i>");
	Addingvaluationcampview.campSearching();
	details="camp searching";
	}
@Test
public void User_validating_created_camp() {
	report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User validating created camp </i>");
	Addingvaluationcampview.campValidating();
	details="camp validated";
	}
@Test
public void User_editing_created_camp() {
	report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User edit exisiting created camp </i>");
	Addingvaluationcampview.campEditing();
	details="camp edited";
	}

@Test
public void User_click_add_button() throws InterruptedException    {
	report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User click add button  </i>");
	Addingvaluationcampview.addclick();
	details="Valuation camp page will get displayed while click on add button";
}
@Test
public void User_entering_details_in_valutionCamp_configuring_Page()
{
	report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User entering details in valution configuring page  </i>");
	Addingvaluationcampview.cnfgrValtnCamp();
	details="Camp configuring details entered";
}
@Test
public void User_checking_chiefenabled_check_box()
{
	report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User checking chief enabled check box  </i>");
	Addingvaluationcampview.checkBox();
	details="Camp configuring details entered";
}
@Test
public void User_enetring_memberprovidingExaminers_answersheets() throws AWTException, InterruptedException
{
	report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User entering details in members providing answersheets and examiners  </i>");
	Addingvaluationcampview.answesheetsExaminers();
	details="Camp configuring details entered";
}
@Test
public void User_click_on_save_button() throws InterruptedException
{
	report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User click on save button </i>");
	Addingvaluationcampview.saveCamp();
details="camp saved";
}

@Test
public void User_changing_camp_status() throws InterruptedException, AWTException
{
	report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User changing camp status from created to opened </i>");
	Addingvaluationcampview.campStatus();
	details="camp opened";
}
@Test
public void User_validating_camp_status() throws InterruptedException, AWTException
{
	report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i> User validating camp status </i>");
	Addingvaluationcampview.validateCampStatus();
	details="camp status validated";
}












//******************************************************************************************
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

	String fileName=System.getProperty("user.dir")+"/target/Edit_ValuationCamp_"+dtf.format(now)+".html";
	File newFile=new File(fileName);

	//Renaming the report with new name

	System.out.println(oldFile.renameTo(newFile));

	//Opening the report
//	Desktop.getDesktop().browse(new File(fileName).toURI());
}













}
