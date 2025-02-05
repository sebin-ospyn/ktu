//package com.ospyn.ktu.test;
//
//import java.awt.Desktop;
//import java.io.File;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.Date;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.testng.ITestContext;
//import org.testng.ITestResult;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//import com.ospyn.ktu.util.DriverConfig;
//import com.ospyn.ktu.util.GenerateExtentReport;
//import com.ospyn.ktu.util.Screenshot;
//import com.ospyn.ktu.util.ViewLogin;
//import com.ospyn.ktu.view.ViewRegularStudentRegistration;
//import com.relevantcodes.extentreports.LogStatus;
//
//public class RegularStudentRegistration extends DriverConfig{
//	// creating reference to ViewCourseMapping
//	ViewRegularStudentRegistration RegularStudentRegistrationView;
//		// creating reference for Login
//		static ViewLogin login;
//
//		// Creating reference for creating Extent Reports
//		static GenerateExtentReport report = Login.report;
//
//		// Creating reference for extracting screenshots of failed test
//		Screenshot screenshot;
//
//		// Creating static variable for adding details to log
//		static String details;
//
//		String actualValue, expectedValue;
//		boolean actualText, expectedText;
//
//		// Creating reference for driver
//		WebDriver driver;
//		WebElement element;
//
//		// creating a variable for assigning the test name before each test
//		String[] testName;
//
//		public RegularStudentRegistration() throws Exception {
//			
//			report = Login.report;
//			screenshot = new Screenshot();
//			driver = getDriver();
//			RegularStudentRegistrationView = new ViewRegularStudentRegistration(driver);
//
//		}
//
//		// Getting the test name
//		@BeforeTest
//		public void getTestName(final ITestContext testContext) {
//
//			String test = testContext.getName(); // gets the test name assigned in the xml file
//			testName = test.split("-");
//
//		}
//		@Test
//		public void logout() throws Exception {
//			report.beginTest("<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br /> Logout from the page");
//			RegularStudentRegistrationView.logout();
//
//			Thread.sleep(1000);
//			details = "User logout from the page";
//
//		}
//		@Test
//		public void Login_as_College_Admin() throws Exception {
//			report.beginTest("<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br /> Log in as college admin");
//			RegularStudentRegistrationView.LoginasCollegeAdmin();
//
//			Thread.sleep(1000);
//			details = "User logged in as college admin";
//
//		}
//		@Test
//		public void click_Student_Module() throws Exception {
//			report.beginTest("<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br /> User clicks student module");
//			RegularStudentRegistrationView.clickStudentModule();
//
//			Thread.sleep(1000);
//			details = "User clicked student module and students details are displayed";
//
//		}
//		@Test
//		public void click_Add_Registration() throws Exception {
//			report.beginTest("<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br /> User clicks add registration button");
//			RegularStudentRegistrationView.clickAddRegistration();
//
//			Thread.sleep(1000);
//			details = "User clicked registration button and Student Registration for Academic year page is displayed";
//
//
//		}
//		@Test
//		public void add_Filters_in_Student_Registration_Page() throws Exception {
//			report.beginTest("<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br /> User clicks add registration button");
//			RegularStudentRegistrationView.addFiltersinStudentRegistrationPage();
//
//			Thread.sleep(1000);
//			details = "User clicked registration button and Student Registration for Academic year page is displayed";
//
//
//		}
//
//		@Test
//		public void click_Add_Button_For_Individual_Student_Registration() throws Exception {
//			report.beginTest("<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br /> The user registers students in each branch by clicking the \"Add\" button");
//			RegularStudentRegistrationView.clickAddButtonforIndividualStudentRegistration();
//
//			Thread.sleep(1000);
//			details = "User registered students in each branch by clicks the add button";
//
//		}
//		@Test
//		public void submission_of_Regular_Student_Registration() throws Exception {
//			report.beginTest("<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br /> User clicks submit button after checking the checkbox Click here to select students of all the branches for submission ");
//			RegularStudentRegistrationView.submissionOfRegularStudentRegistration();
//			Thread.sleep(1000);
//			details = "User successfully submitted all branches after added the students";
//
//		}
//		
//		@Test
//		public void Login_as_University_User() throws Exception {
//			report.beginTest("<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br /> User log in as university user  ");
//			RegularStudentRegistrationView.loginasUniversityUser();
//			Thread.sleep(1000);
//			details = "Usersuccessfully logged in as university user ";
//
//		}
//		@Test
//		public void click_Semester_Transfer_or_Registration() throws Exception {
//			report.beginTest("<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br /> User clicks semester transfer/registration sub module ");
//			RegularStudentRegistrationView.clickSemesterTransferorRegistration();
//			Thread.sleep(1000);
//			details = "User clicked semester transfer/registration sub module";
//
//		}
//		@Test
//		public void generating_Register_Number() throws Exception {
//			report.beginTest("<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br /> User genng register number");
//
//			RegularStudentRegistrationView.generatingRegisterNumber();
//			Thread.sleep(1000);
//			details = "User successfully generated register number ";
//
//		}
//		@Test
//		public void click_Student_Details() throws Exception {
//			report.beginTest("<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br /> User clicks student details button sub module");
//			RegularStudentRegistrationView.clickStudentDetails();
//			Thread.sleep(1000);
//			details = "student details page is displayed ";
//
//		}
//		
//		@Test
//		public void add_Filters_in_Student_Details_Page() throws Exception {
//			report.beginTest("<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br /> User clicks student details button sub module");
//			RegularStudentRegistrationView.addFiltersinStudentDetails();
//			Thread.sleep(1000);
//			details = "student details page is displayed ";
//
//		}
//		@Test
//		public void storing_Student_Register_Number() throws Exception {
//			report.beginTest("<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br /> User clicks student details button sub module");
//			RegularStudentRegistrationView.readingStudentRegisterNumber();
//			Thread.sleep(1000);
//			details = "student details page is displayed ";
//
//		}
//		@Test
//		public void user_Changing_Password() throws Exception {
//			report.beginTest("<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br /> User clicks student details button sub module");
//			RegularStudentRegistrationView.changingPassword();
//			Thread.sleep(1000);
//			details = "student details page is displayed ";
//
//		}
//		@Test
//		public void student_Submitting_Registration_Details() throws Exception {
//			report.beginTest("<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br /> User clicks student details button sub module");
//			RegularStudentRegistrationView.submittingStudentDetailsFromStudentLogin();
//			Thread.sleep(1000);
//			details = "student details page is displayed ";
//
//		}
//		@Test
//		public void college_Verifying_Student_Details() throws Exception {
//			report.beginTest("<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br />college verifying student details");
//			RegularStudentRegistrationView.collegeVerifyingStudentDetailsFromCollegeLogin();
//			Thread.sleep(1000);
//			details = "college successfully verified student details";
//
//		}
//		@Test
//		public void university_Approving_Student_Details() throws Exception {
//			report.beginTest("<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br /> University user approve student details");
//			RegularStudentRegistrationView.universityApprovingStudentDetails();
//			Thread.sleep(1000);
//			details = "university user approves student details";
//
//		}
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
//		
//		
//		
//		
//		@AfterMethod
//		// writing the status to the report
//		public void getResult(ITestResult result) {
//			// if the testing is a failure
//			if (result.getStatus() == ITestResult.FAILURE) {
//
//				// Using details of date and time for naming the screenshot
//
//				String dateName = new SimpleDateFormat("ddMMyyyy_hhmmss").format(new Date());
//
//				// capturing screenshot of the failed method
//				String screenshotName = result.getMethod().getMethodName() + "-" + dateName + ".jpg";
//
//				screenshot.captureScreenshot(screenshotName, driver);
//
//				// Adding screenshot to the report for the failed test
//				report.addScreenShotToLog(System.getProperty("user.dir") + "/Screenshots/" + screenshotName);
//			}
//
//			// if testing is successful
//			else if (result.getStatus() == ITestResult.SUCCESS) {
//				report.setLog(LogStatus.PASS, details);
//			}
//
//			// if testing is skipped
//			else if (result.getStatus() == ITestResult.SKIP) {
//				report.setLog(LogStatus.SKIP, "Skipped");
//			}
//			// Ending the test
//			report.endTest();
//
//		}
//
//		@AfterSuite
//		public void endTest() throws IOException {
//			// closing the report
//			report.endReport();
//
//			// Renaming the report by adding date and time to the report
//			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH:mm:ss");
//			LocalDateTime now = LocalDateTime.now();
//
//			File oldFile = new File(System.getProperty("user.dir") + "/target/Report.html");
//
//			String fileName = System.getProperty("user.dir") + "/target/RegularStudentRegistration_" + dtf.format(now) + ".html";
//			File newFile = new File(fileName);
//
//			// Renaming the report with new name
//
//			System.out.println(oldFile.renameTo(newFile));
//
//			// Opening the report
//			Desktop.getDesktop().browse(new File(fileName).toURI());
//		}
//}
