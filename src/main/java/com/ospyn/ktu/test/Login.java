package com.ospyn.ktu.test;

import static org.testng.AssertJUnit.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ospyn.ktu.util.DriverConfig;
import com.ospyn.ktu.util.GenerateExtentReport;
import com.ospyn.ktu.util.Screenshot;
import com.ospyn.ktu.util.ViewLogin;
import com.relevantcodes.extentreports.LogStatus;


public class Login extends DriverConfig
{

	//creating reference for Login
	static ViewLogin login;

	//Creating reference for creating Extent Reports
	static GenerateExtentReport report;
	static boolean flag=false;

	//Creating reference for extracting  screenshots of failed tests
	Screenshot screenshot;

	//Creating static variable for adding details to log
	String details;

	//Creating reference for driver 
	WebDriver driver;

	//creating a static variable for assigning the test name  before each test
	static String[] testName;
	static private int column=1;

	public Login()
	{
		/*initializing..
//		 * ExtentReport-->Using a class GenerateExtentReport class in the util package
//		 * WebDriver--->Using the DriverConfig class in the util package
//		 * 
//		 */
		if(!flag)
		{	
		report=new GenerateExtentReport();
		flag=true;
		}
		screenshot=new Screenshot();
		driver=getDriver();

	}
	public static int getColumn()
	{
		return column;
	}

	public static void setColumn(int value)
	{
		column=value;
		System.out.println(column);
	}
	
	
	@BeforeTest
	public void getTestName(final ITestContext testContext) 
	{

		String test=testContext.getName(); // gets the test name assigned in the xml file
		testName=test.split("-");

	}
	
	@Test
	public void ktu_Page_Loaded()
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br />Home page of KTU is loaded");
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.print(e);
		} 
		details="KTU Page is displayed";
		driver.manage().window().maximize();
	}

	@Parameters({"username","password"})//passing parameters
	@Test
	//Using the built in class for Login
	
	public void loginUser(String username,String password)throws Exception
	{
		//Calls the method beginTest in GenerateExtentReport class to start the test
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"Login</b><br /><br /><i>User enters username "+username+" and password "+password+"</i>");
		login=new ViewLogin(driver);
		login.logIn(username, password);
		details="User name and password are entered";
	}

	@Test
	//Using the built in class for Login
	public void login_With_Excel()throws Exception
	{
		//Calls the method beginTest in GenerateExtentReport class to start the test
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"Login</b><br /><br /><i>User enters username and password</i>");
		login=new ViewLogin(driver);
		System.out.println("Colummn number is"+column);
		login.loginWithExcel( column);
		details="User name and password are entered";
	}

	@Test
	public void click_Login_Button()
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User clicks on Login button</i>");
		login.clickLogin();
		details="New page appears";
	}

	@Test
	public void validate_Login_Success()
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User validates the page displayed</i>");
		assertEquals("Success",login.getStatus());
		details="User validates the login page displayed";
	}

	@Test
	public void click_logOut()
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User clicks on Logout button</i>");
		try
		{
			login.logOut();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		details="User logs out from the KTU page";
	}
	@Test

	public void next_College()throws Exception
	{ 
		
		column++;
		
					
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
	
}

/*
 * 
 */



