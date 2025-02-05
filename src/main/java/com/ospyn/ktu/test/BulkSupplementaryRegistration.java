//package com.ospyn.ktu.test;
//
//import java.awt.AWTException;
//import java.awt.Desktop;
//import java.io.File;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.Date;
//import java.util.List;
//
//import org.junit.Assert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.testng.ITestContext;
//import org.testng.ITestResult;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//import com.ospyn.ktu.util.DriverConfig;
//import com.ospyn.ktu.util.GenerateExtentReport;
//import com.ospyn.ktu.util.Screenshot;
//import com.ospyn.ktu.util.ViewLogin;
//import com.ospyn.ktu.view.ViewBulkSupplementaryRegistration;
//import com.ospyn.ktu.view.ViewSupplymentaryCourseReg;
//import com.relevantcodes.extentreports.LogStatus;
//
//public class BulkSupplementaryRegistration extends DriverConfig{
//
//	//creating reference to ViewCourseSelection
//	static ViewBulkSupplementaryRegistration bulksupplyRegistrationView;
//
//	static ViewSupplymentaryCourseReg supplyRegistrationView;
//
//	static Object[] studentData;
//
//	//creating reference for Login
//	static ViewLogin login;
//
//	//Creating reference for creating Extent Reports
//	GenerateExtentReport report=Login.report;
//
//	//Creating reference for extracting  screenshots of failed tests
//	Screenshot screenshot;
//
//	//Creating static variable for adding details to log
//	String details;
//
//	//Creating reference for driver
//	WebDriver driver;
//
//	//creating a static variable for assigning the test name  before each test
//	static String[] testName;
//	boolean Testresult, Actualresult =true;
//	String ActualText, ExpectedText;
//
//	public BulkSupplementaryRegistration()
//	{
//		/*initializing..
////		 * ExtentReport-->Using a class GenerateExtentReport class in the util package
////		 * WebDriver--->Using the DriverConfig class in the util package
////		 *
////		 */
//		screenshot=new Screenshot();
//		driver=getDriver();
//		bulksupplyRegistrationView=new ViewBulkSupplementaryRegistration(driver);
//		supplyRegistrationView=new ViewSupplymentaryCourseReg(driver);
//        studentData=ViewBulkSupplementaryRegistration.getStudentData();
//
//	}
//	@BeforeTest
//	public void getTestName(final ITestContext testContext)
//	{
//
//		String test=testContext.getName(); // gets the test name assigned in the xml file
//		testName=test.split("-");
//    }
//
//	@Test
//	public void click_ineligibleFailedReport() throws InterruptedException
//    {
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>navigation to ineligible failed report</i>");
//		bulksupplyRegistrationView.getAcademicModule().click();
//		bulksupplyRegistrationView.getReports().click();
//		bulksupplyRegistrationView.getFailedReport().click();
//		details=" Report is displayed";
//    }
//
//	@Parameters({"studentDetails"})
//	@Test
//	public void search_ineligibleFailedReport(String stringList) throws InterruptedException, AWTException
//    {
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>searching the report with required filters</i>");
//		bulksupplyRegistrationView.searchReport(stringList);
//		details=" search result is displayed";
//    }
//
//	@Test
//	public void store_Student_Details()throws Exception
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User stores  the register number of all students listed" );
//
//		bulksupplyRegistrationView.readingStudentData();
//		studentData=ViewBulkSupplementaryRegistration.getStudentData();
//		details="The students are stored";
//		Thread.sleep(1000);
//
//	}
//
//	@Test
//	public void userLogout()
//    {
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>user clicks logout</i>");
//		bulksupplyRegistrationView.getLogout().click();
//	    details="user successfully logged out";
//    }
//
//   @Test(dataProvider = "data-provider")
//
//	public void student_Registration(String regNo)throws Exception
//	{
//	   System.out.print("ychduwjocidjocwidcwoiejc");
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />Registration done by:"+regNo );
//		Thread.sleep(1000);
//
//		try
//		{
//			/* user enters the username and password by reading the dataprovider */
//		String password="pass1@";
//		login=new ViewLogin(driver);
//		login.logIn(regNo,password);
//		details="User name and password are entered";
//		login.clickLogin();
//		Thread.sleep(1000);
//		// login.logOut();
//		Thread.sleep(1000);
//		report.setLog(LogStatus.PASS,"");
//
//		}
//		catch(Exception e)
//		{
//		report.setLog(LogStatus.FAIL,"");
//		}
//
//		//********************************************
//
//		try {
//
//		/*user clicks on exam module*/
//			supplyRegistrationView.getStudentExamModule().click();
//			report.setLog(LogStatus.PASS,"");
//        }
//		catch(Exception e)
//		{
//		report.setLog(LogStatus.FAIL,"");
//		}
//
//		//*********************************************
//
//		try {
//		/*
//		  clicking the register button against the required exam
//		  */
//
//		String data = "2022 - 2023,Btech s5 (S) test";
//		supplyRegistrationView.registerButtonclickstudLogin(data);
//		report.setLog(LogStatus.PASS,"");
//        }
//		catch(Exception e)
//		{
//		report.setLog(LogStatus.FAIL,"");
//		}
//
//		//*********************************************
//
//
//	    try {
//	    	//selecting all the courses listed for the student
//		   String data = "2022 - 2023,Btech s5 (S) test";
//		   int skipValue = bulksupplyRegistrationView.studentExamRegistration();
//		   if(skipValue==0)
//		       report.setLog(LogStatus.PASS,"");
//		   else
//			   report.setLog(LogStatus.SKIP,"");
//
//		}
//		catch(Exception e){
//			System.out.println(e);
//
//			report.setLog(LogStatus.FAIL,"");
//		}
//
//	    //**********************************************
//
//	    try {
//	    	//saving the registration
//	    	ExpectedText = "Saved successfully";
//			ActualText=supplyRegistrationView.singleCoursesave();
//			Assert.assertEquals(ActualText,ExpectedText);
//			report.setLog(LogStatus.PASS,"");
//        }
//		catch(Exception e)
//		{
//		report.setLog(LogStatus.FAIL,"");
//		}
//
//	    //***********************************************
//	    /* in the variable feeConscession we store the value of fee concession column,
//	      using this we check whether a student has fee concession or not.*/
//	   String feeConcession = driver.findElement(By.xpath("//*[@class='table table-striped table-bordered table-hover']/tbody/tr[1]/td[5]")).getText();
//	   System.out.println("feeConcession"+feeConcession);
//	   int flag=0;
//
//	   /*here we are checking the value of appearing chance
//	     if any of the course have appearing chance greater
//	     than 2 flag will be set*/
//
//	   List<WebElement> courseList = driver.findElements(By.xpath("//*[@class='table table-striped table-bordered table-hover']/tbody/tr"));
//
//	     int listSize = courseList.size();
//
//	     for(int i=1 ; i<=listSize ; i++) {
//
//	    	 String appearingChance = driver.findElement(By.xpath("//*[@class='table table-striped table-bordered table-hover']/tbody/tr["+i+"]/td[4]")).getText();
//	    	 System.out.println("appearingChance"+appearingChance);
//
//	    	 int appearingChanceValue = Integer.parseInt(appearingChance);
//	    	 System.out.println("appearingChanceValue"+appearingChanceValue);
//	    	 if(appearingChanceValue>2) {
//	    		 flag=1;
//	    	     break;
//	    	 }
//	    	 }
//
//	     /*if fee concession is YES and appearing chance is 2*/
//	    if(feeConcession.contentEquals("Yes") && flag==0) {
//
//	    	try {
//	    		ExpectedText = "Submitted to University";
//			    ActualText=supplyRegistrationView.feeConcessionSubmission();
//				details="course submitted successfully";
//				report.setLog(LogStatus.PASS,"");
//	        }
//			catch(Exception e)
//			{
//			report.setLog(LogStatus.FAIL,"");
//			}
//
//	    	 //***********************************************
//
//		    try {
//		    	supplyRegistrationView.getLogout().click();
//				report.setLog(LogStatus.PASS,"");
//	        }
//			catch(Exception e)
//			{
//			report.setLog(LogStatus.FAIL,"");
//			}
//	    }
//	    /*if fee concession is NO or appearing chance is grater than 2*/
//	    else if(flag==1 || feeConcession.contentEquals("No")){
//
//	    		try {
//	    	    	ExpectedText = "Proceed to Pay";
//	    		    ActualText=supplyRegistrationView.singleCoursesubmission();
//	    		    Assert.assertEquals(ActualText,ExpectedText);
//	    			report.setLog(LogStatus.PASS,"");
//	            }
//	    		catch(Exception e)
//	    		{
//	    		report.setLog(LogStatus.FAIL,"");
//	    		}
//
//
//	     //***********************************************
//
//	    	    try {
//	    	    	ExpectedText = "Your Payment is successful";
//	    		    ActualText=supplyRegistrationView.paymentGateway();
//	    		    Assert.assertEquals(ActualText,ExpectedText);
//	    			report.setLog(LogStatus.PASS,"");
//	            }
//	    		catch(Exception e)
//	    		{
//	    		System.out.println("payment gateway exception"+e);
//	    		report.setLog(LogStatus.FAIL,"");
//	    		}
//
//	     //***********************************************
//
//	    	    try {
//	    	    	supplyRegistrationView.getLogout().click();
//	    			report.setLog(LogStatus.PASS,"");
//	            }
//	    		catch(Exception e)
//	    		{
//	    		report.setLog(LogStatus.FAIL,"");
//	    		}
//
//	    	}
//
//	    }
//
//
//	@DataProvider(name = "data-provider")
//	public Object[] getStudentDetails1()
//	{
//
//	return studentData;
//	}
//	@Test
//	public void college_homepage_ktu_loaded() throws InterruptedException {
//
//		Thread.sleep(500);
//	}
//
//	@Test
//	public void collegeExam_click() {
//		supplyRegistrationView.getCollegeExamModule().click();
//	}
//
//
//	@Parameters({"examDetails"})
//	@Test
//	public void click_Exams_searchSupplementaryExam(String stringList) throws InterruptedException
//    {
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>navigation to exams and searching the required exam</i>");
//		supplyRegistrationView.getExams().click();
//		supplyRegistrationView.searchExamsCollegelogin(stringList);
//		details="exams are listed";
//    }
//
//	@Parameters({"examDetails"})
//	@Test
//	public void collegeRegisterSubmissionButton_click(String stringList) throws InterruptedException
//    {
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>navigation to exams and searching the required exam</i>");
//		bulksupplyRegistrationView.branchSubmission(stringList);
//		details="exams are listed";
//    }
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
//
//
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
//		String fileName=System.getProperty("user.dir")+"/target/TestResult_"+dtf.format(now)+".html";
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
//}
