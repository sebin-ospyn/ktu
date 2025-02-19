//package com.ospyn.ktu.test;
//
//import static org.testng.AssertJUnit.assertEquals;
//
//import java.awt.Robot;
//import java.awt.event.KeyEvent;
//import java.io.File;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.Date;
//
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.testng.ITestContext;
//import org.testng.ITestResult;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//import com.ospyn.ktu.util.DriverConfig;
//import com.ospyn.ktu.util.GenerateExtentReport;
//import com.ospyn.ktu.util.Screenshot;
//import com.ospyn.ktu.util.ViewLogin;
//import com.ospyn.ktu.view.ViewCourseMapping;
//import com.relevantcodes.extentreports.LogStatus;
//
//public class CourseMapping extends DriverConfig
//{
//	//creating reference to ViewCourseMapping
//	ViewCourseMapping courseMappingView;
//	//creating reference for Login
//	static ViewLogin login;
//
//	//Creating reference for creating Extent Reports
//	static GenerateExtentReport report=Login.report;
//
//	//Creating reference for extracting  screenshots of failed test
//	Screenshot screenshot;
//
//	//Creating static variable for adding details to log
//	static String details;
//
//	String actualValue,expectedValue;
//	boolean actualText,expectedText;
//
//	//Creating reference for driver
//	WebDriver driver;
//	WebElement element;
//
//	//creating a variable for assigning the test name  before each test
//	String[] testName;
//
//	public CourseMapping()throws Exception
//	{
//		/*initializing..
////			 * ExtentReport-->Using a class GenerateExtentReport class in the util package
////			 * WebDriver--->Using the DriverConfig class in the util package
////			 *
////			 */
//		report=Login.report;
//		screenshot=new Screenshot();
//		driver=getDriver();
//		courseMappingView=new ViewCourseMapping(driver);
//
//	}
//
//	@BeforeTest
//	public void getTestName(final ITestContext testContext)
//	{
//
//		String test=testContext.getName(); // gets the test name assigned in the xml file
//		testName=test.split("-");
//
//	}
//
//
//	@Test
//	public void click_Academic_Auditing_Tab() throws InterruptedException
//	{
//		// Maximize the browser window
//        driver.manage().window().maximize();
//		Thread.sleep(1000);
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User clicks the Academic Auditing tab");
//		WebElement element=courseMappingView.getAcademicAuditing();
//		element.sendKeys(Keys.ENTER);
//
//		try
//		{
//			Thread.sleep(1000);
//		}
//		catch(Exception e)
//		{
//			System.out.println(e);
//		}
//		details="Batches are displayed";
//
//	}
//
//	@Test
//	public void click_Course_Mapping()
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User clicks the Course Mapping option from the side menu" );
//		courseMappingView.getCourseMapping().click();
//		try
//		{
//			Thread.sleep(1000);
//		}
//		catch(Exception e)
//		{
//
//		}
//		details="Course Mapping page is displayed";
//
//	}
//
//	@Test
//	public void course_Selection() throws Exception
//	{
//
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User enters the course details" );
//
//		courseMappingView.CourseMappingOption();
//
//		details="Course for mapping is selected";
//
//	}
//
//	@Test
//	public void course_Selection_Institution() throws Exception
//	{
//
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User enters the course details" );
//
//		courseMappingView.detailsWithInstitutionName();
//
//		details="Course for mapping is selected";
//
//	}
//	@Test
//	public void click_Search_Button()throws InterruptedException
//	{
//
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User clicks on the search button" );
//
//		courseMappingView.getSearch().click();
//
//		details="Error message appears";
//		Thread.sleep(1000);
//	}
//
//
//	@Test
//	public void validate_Error_Message() throws InterruptedException
//	{
//
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User validates the error message" );
//
//		Thread.sleep(1000);
//		expectedValue = "Semester transfer not completed.Please contact University.";
//		actualValue = courseMappingView.validateError();
//
//		assertEquals(expectedValue,actualValue);
//		details="The error message of \"Semester transfer not completed.Please contact University.\"is validated";
//
//	}
//
//	@Test
//	public void validate_Error_Message_Course() throws InterruptedException
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User validates the error message" );
//		Thread.sleep(1000);
//
//		expectedValue = "Either course selection is not submitted or Branch(es) not affiliated.";
//		actualValue = courseMappingView.validateErrorCourse();
//
//		assertEquals(expectedValue, actualValue);
//		details="The error message of \"Either course selection is not submitted or Branch(es) not affiliated.\"is validated";
//
//	}
//
//	@Test
//	public void select_Branch()throws Exception
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User selects a branch for course mapping" );
//		Thread.sleep(1000);
//		WebElement element=courseMappingView.getAddCourseMapping();
//		System.out.println("The branch is *************"+element.getText());
//
//		element.sendKeys(Keys.ENTER);
//
//		Thread.sleep(1000);
//
//		details="The course mapping for that branch is displayed";
//
//	}
//
//
//	@Test
//	public void enters_Duplicate_Faculty() throws Exception
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User enters the duplicate faculty without selecting Main Faculty" );
//
//		courseMappingView.entersDuplicateFaculty(1);
//
//		details="The error message is displayed";
//
//	}
//
//	@Test
//	public void enters_Faculty_Only() throws Exception
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User enters the faculty for Slot A only" );
//
//		courseMappingView.entersFacultyOnly();
//
//		details="The error message is displayed";
//
//
//	}
//
//	@Test
//	public void enters_Faculty_QpSetter_Save() throws Exception
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User enters the faculty for Slot A only and make him the QpSetter wihout giving experience" );
//
//		courseMappingView.entersFacultyOnlyQPSetter();
//
//		details="The error message is displayed";
//
//
//	}
//	@Test
//	public void validate_No_QPsetter() throws Exception
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User validates the error message" );
//		Thread.sleep(1000);
//		actualValue=courseMappingView.validateMessages();
//		expectedValue = "At least one QP Setter need to be marked against course";
//		assertEquals(actualValue.startsWith(expectedValue),true);
//		details="The error message of \"At least one QP Setter need to be marked against course\" is dislpayed";
//	}
//
//
//
//	@Test
//	public void validate_No_QPsetter1() throws Exception
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User validates the error message" );
//		Thread.sleep(1000);
//		actualValue=courseMappingView.validateMessages();
//		expectedValue = "Qp Setter need to be selected against";
//		assertEquals(actualValue.startsWith(expectedValue),true);
//		details="The error message of \"Qp Setter need to be selected against course\" is dislpayed";
//	}
//	@Test
//	public void delete_Duplicate_Row() throws Exception
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User deletes duplicate row of a slot" );
//
//		courseMappingView.deleteDuplicateRow();
//
//		details="The duplicate row is deleted";
//
//	}
//
//	@Test
//	public void delete_Only_Row() throws Exception
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User deletes the single row of a slot" );
//
//		courseMappingView.deleteOnlyRow();
//
//		details="The error message is displayed";
//
//	}
//
//	public void validate_Only_Row_Deletion() throws Exception
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User validate deletion of single row" );
//
//		actualValue=courseMappingView.validateDeletionRow();
//		expectedValue="pass";
//
//		assertEquals(expectedValue, actualValue);
//
//		details="The error message is displayed";
//	}
//
//	@Test
//	public void error_Message_MainFaculty() throws Exception
//	{
//
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User validates the error message" );
//		Thread.sleep(1000);
//		expectedValue = "Main Faculty is not marked";
//		assertEquals(expectedValue, actualValue);
//		details="The error message of \"Main Faculty is not marked\" is validated";
//
//	}
//
//	@Test
//	public void validate_Faculty_Only() throws Exception
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User validates the error message" );
//		Thread.sleep(1000);
//		actualValue=courseMappingView.validateMessages();
//		expectedValue = "Qp Setter need to be selected";
//		assertEquals(actualValue.startsWith(expectedValue),true);
//		details="The error message of \"Qp Setter need to be selected\" is dislpayed";
//	}
//
//	@Test
//	public void validate_Save_Faculty_QPSetter() throws Exception
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User validates the error message" );
//		Thread.sleep(1000);
//		actualValue=courseMappingView.validateMessages();
//		expectedValue = "Qp Setter Experience need to be selected against";
//		assertEquals(actualValue.startsWith(expectedValue),true);
//		details="The error message of \"Qp Setter need to be selected\" is dislpayed";
//	}
//
//	@Test
//	public void validate_Mark_Faculty_QPSetter() throws Exception
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User validates the error message" );
//		Thread.sleep(1000);
//		actualValue=courseMappingView.validateMessages();
//		expectedValue = "Qp Setter need to be selected";
//		assertEquals(actualValue.startsWith(expectedValue),true);
//		details="";
//	}
//
//
//
//	@Test
//	public void enters_Duplicate_Faculty_Main() throws Exception
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User enters the duplicate faculty after selecting Main Faculty" );
//
//		courseMappingView.entersDuplicateFaculty(2);
//		details="The error message is displayed";
//
//	}
//
//	@Test
//	public void enters_Same_Faculty_Two_Slots() throws Exception
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User enters the duplicate faculty after selecting Main Faculty for two different slots" );
//
//		courseMappingView.entersDuplicateTwoSlots();
//		details="The error message is displayed";
//
//	}
//
//
//	@Test
//	public void two_BatchesMainFaculty() throws Exception
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />user makes two faculties as main faculty against a course with different batch" );
//
//		courseMappingView.entersMainFacultyTwoBatches();
//		details="The error message is displayed";
//
//	}
//
//	@Test
//	@Parameters({"exp_Entered"})
//	public void part1_2_WithoutQP(int number) throws Exception
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />user enters faculties for part1-part2 course without qiving Qp setter" );
//
//		courseMappingView.noQpPart1Part2(number);
//		details="The error message is displayed";
//
//	}
//
//
//
//	@Test
//	public void error_Message_Duplicate_Faculty() throws Exception
//	{
//
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User validates the error message" );
//		Thread.sleep(1000);
//		actualValue=courseMappingView.validateMessages();
//		expectedValue = "Can't add same faculty with the same course and batch.";
//		assertEquals(expectedValue, actualValue);
//		details="The error message of \"Can't add same faculty with the same course and batch\" is validated";
//
//	}
//
//	@Test
//	public void enters_No_Faculty() throws Exception
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User attempts to save without any faculty" );
//
//		actualValue = courseMappingView.entersNoFaculty();
//		details="The error message is displayed";
//
//	}
//
//	@Test
//	public void error_Message_No_Faculty() throws Exception
//	{
//
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User validates the error message" );
//		Thread.sleep(1000);
//		expectedValue = "Please select a faculty";
//		assertEquals(true, actualValue.contains(expectedValue));
//		details="The error message of \"Please select a faculty\" is validated";
//
//	}
//	@Test
//	public void enters_No_Registration() throws Exception
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User attempts to save with no registration" );
//
//		actualValue = courseMappingView.entersNoRegistration();
//		details="The error message is displayed";
//
//	}
//
//	@Test
//	public void QpSetter_No()throws Exception
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User attempts to save with Qp Setter set as No" );
//
//		courseMappingView.noQpSetter();
//		details="The error message is displayed";
//	}
//
//	@Test
//	public void two_Main_Faculty() throws Exception
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User attempts to save with two main faculties");
//
//		String clickable=courseMappingView.twoMainFaculty();
//		assertEquals("no",clickable);
//		details="The second faculty cannot be made as main faculty";
//
//	}
//	@Test
//
//	public void error_Message_No_Registration()throws Exception
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User validates the error message" );
//		Thread.sleep(1000);
//		expectedValue = "Not possible to add Faculty and check No Registration together";
//		assertEquals(expectedValue, actualValue);
//		details="The error message of \"Not possible to add Faculty and check No Registration together\" is validated";
//	}
//
//
//
//	@Test
//	public void faculty_All_Slots_Save() throws Exception
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User enters faculty for all the slots");
//		courseMappingView.saveFacultyForAllSlots();
//		actualValue = courseMappingView.clickSaveButton();
//		details="The faculties are entered";
//
//	}
//
//	@Test
//	public void save_Success()
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User validates the message after saving all slots" );
//		if(actualValue.equals("fail"))
//		{
//			expectedValue="fail";
//
//		}
//		else
//		{
//			expectedValue = "pass";
//		}
//		assertEquals(expectedValue, actualValue);
//		details="The slots are saved";
//	}
//
//	@Test
//	public void mark_As_Complete()throws Exception
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User clicks on Mark as Complete button" );
//		Thread.sleep(1000);
//
//		courseMappingView.getMarkAsCompleteButton().click();
//
//		details="";
//		Thread.sleep(1000);
//	}
//
//	@Test
//	public void validate_Marked()throws Exception
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User validates the message after marking as complete");
//
//		actualValue=courseMappingView.getMarkedStatus();
//		Thread.sleep(1000);
//
//		expectedValue = "Marked as Complete";
//		assertEquals(expectedValue, actualValue);
//		details="The expected and actual value is the same";
//	}
//
//	@Test
//	public void select_Marked_Branch() throws Exception
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User clicks the branch which is marked as complete" );
//		courseMappingView.getMarkedAsCompleteButton().sendKeys(Keys.ENTER);
//		details="The branch is selected";
//
//	}
//
//	@Test
//	public void click_Export_Button() throws Exception
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User clicks the export button" );
//		Thread.sleep(1000);
//
//		element=courseMappingView.getCourseMappingExport();
//		element.click();
//		details="The course mapping details file is downloaded";
//
//	}
//
//	@Test
//	public void validate_Export_Button() throws Exception
//	{
//
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User validates whether the correct file was downloaded during export" );
//
//		actualText=courseMappingView.validatesExportedCourseMapping();
//		System.out.println("Actual Text is "+actualText);
//		Thread.sleep(1000);
//		expectedText=true;
//		System.out.println(expectedText+"****"+actualText);
//		assertEquals(expectedText,actualText);
//
//		details="The user confirms the contents of the downloaded file";
//
//	}
//
//
//
//	@Test
//	public void enters_Two_Faculties() throws Exception
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User enters the two different faculties for the same course" );
//
//		actualValue=courseMappingView.entersTwoFaculties();
//
//		details="The faculties are mapped";
//
//	}
//
//	@Test
//	public void validate_Two_Faculties()
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User validates two faculties saved for a course");
//		expectedValue = "pass";
//		assertEquals(expectedValue, actualValue);
//		details="The expected and actual value is the same";
//	}
//
//	@Test
//	public void partial_Submission()throws Exception
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User selects the course and submits to university");
//		Thread.sleep(1000);
//
//		element=courseMappingView.getCheckBox();
//		element.click();
//		Thread.sleep(1000);
//
//
//		courseMappingView.partialSubmission();
//		actualValue="pass";
//
//		details="The faculties are mapped";
//	}
//
//	@Test
//	public void validate_Partial_Submission()
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User validates partial submission");
//		expectedValue = "pass";
//		assertEquals(expectedValue, actualValue);
//		details="The expected and actual value is the same";
//	}
//
//	@Test
//	public void partial_Submission_Repeat()throws Exception
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User tries to submit the course again");
//		Thread.sleep(1000);
//		courseMappingView.partialSubmission();
//
//
//		details="The error message is displayed";
//	}
//
//	@Test
//	public void validate_Partial_Submission_Error()
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User validates partial submission error");
//		expectedValue = "Selected branch/s already submitted to the university";
//		actualValue=courseMappingView.getPartialSubmissionError();
//		assertEquals(expectedValue, actualValue);
//		details="The expected and actual value is the same";
//	}
//	@Test
//	public void all_Branches_Faculty()throws Exception
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User completes course mapping for all the branches");
//		actualValue=courseMappingView.mapAllBranches();
//		details="User saves all branches after course mapping and Marks as Complete";
//
//	}
//	@Test
//	public void validate_All_Branches_Marked()
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User validates whether course mapping for all branches done");
//		expectedValue = "pass";
//
//		assertEquals(expectedValue, actualValue);
//		details="The expected and actual value is the same";
//	}
//
//
//	@Test
//	public void click_Submit_University_Button()throws Exception
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User clicks the Submit to university buttons");
//		courseMappingView.getSubmitToUniversity().click();
//		Robot robot=new Robot();
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
//
//
//		Thread.sleep(1000);
//		details="Error message is shown";
//
//	}
//
//	@Test
//	public void validate_Error_Submission()throws Exception
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User validates the message while submission");
//		actualValue=courseMappingView.getValidationErrorSubmission().getText();
//		expectedValue="Selected branch/s already submitted to the university";
//		assertEquals(expectedValue,actualValue);
//		Thread.sleep(1000);
//		details="Course Mapping of all the branches sould not be submitted as one branch is in revoked status";
//
//	}
//
//	@Test
//	public void submit_CourseMapping_All_Branches_To_University()throws Exception
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User selects all the courses to be submitted to university");
//		actualValue=courseMappingView.submitCourseMappingAllBranches();
//
//		Thread.sleep(1000);
//		details="Course Mapping of all the branches are submitted to university";
//
//	}
//
//	@Test
//	public void validate_All_Branches_Submission()
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User validates whether course mapping of all branches are submitted to university");
//		expectedValue = "pass";
//
//		assertEquals(expectedValue, actualValue);
//		details="The expected and actual value is the same";
//	}
//
//	@Test
//	public void revoke_Courses()throws Exception
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User clicks on the revoke button");
//		courseMappingView.revokeBranch();
//
//		Thread.sleep(1000);
//		details="Course Mapping of that branch is revoked";
//
//	}
//
//	@Test
//	public void validate_Revoke_Branch()throws Exception
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User validates whether the mapping was revoked");
//		actualValue=courseMappingView.validateRevokeBranch();
//		expectedValue="Revoked";
//
//		System.out.println("Actual Value is "+actualValue);
//
//		assertEquals(expectedValue,actualValue);
//		Thread.sleep(1000);
//
//		details="User confirms the revoke was successfully completed";
//
//	}
//
//	@Test
//	public void submit_Revoked_Branch()throws Exception
//	{
//
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User selects the revoked branch and Mark as Complete");
//		courseMappingView.getRevokedButton().click();
//		courseMappingView.getMarkAsCompleteButton().click();
//		Thread.sleep(1000);
//
//		details="The branch is marked as complete";
//	}
//
//	@Test
//	public void click_Batches()throws Exception
//	{
//
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User clicks the Batches option from side menu");
//		courseMappingView.getBatches().click();
//		Thread.sleep(1000);
//		details="The Batches page is displayed";
//
//	}
//
//	@Test
//	public void click_Add_Button()throws Exception
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User clicks the Add Custom Batch button");
//		courseMappingView.getAdd().click();
//		Thread.sleep(1000);
//		details="The Add Custom Batch page is displayed";
//
//	}
//
//	@Test
//	public void different_Courses()throws Exception
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User enters details");
//		courseMappingView.differentCoursesSameSlot();
//
//
//		details="The user confirms that the new custom batch is created";
//
//	}
//
//	@Parameters({"batchDetails"})
//	@Test
//	public void enter_Batch_Details(String batchDetails)throws Exception
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User enters the details for the new custom batch");
//		courseMappingView.enterNewCustomBatchDetails(batchDetails);
//		Thread.sleep(1000);
//		details="The details are entered";
//
//	}
//
//	@Test
//	public void click_Save_Button()throws Exception
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User clicks save button");
//		actualValue=courseMappingView.saveBatch();
//		Thread.sleep(1000);
//		details="The new custom batch is saved";
//
//	}
//	@Test
//	public void click_SaveCourseMapping_Button()throws Exception
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User clicks save button");
//		courseMappingView.getsaveCourseMapping().click();
//		Thread.sleep(1000);
//		details="";
//
//	}
//
//
//	@Test
//	public void validate_Save_Batch()throws Exception
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User checks whether new batch was added successfully");
//		Thread.sleep(1000);
//		expectedValue="pass";
//		assertEquals(expectedValue, actualValue);
//		details="The user confirms that the new custom batch is created";
//
//	}
//	@Test
//	public void validate_Error_Save_Batch()throws Exception
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User checks whether the new batch was added");
//		Thread.sleep(1000);
//		expectedValue="Same batch name exists";
//		assertEquals(expectedValue, actualValue);
//		details="The user confirms that the new custom batch is not created due to the name conflict";
//
//	}
//
//	@Test
//	public void click_Back_Button()throws Exception
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User clicks the Back Button");
//		courseMappingView.getBack().click();
//		Thread.sleep(1000);
//		details="The user moves back to Create Custom Batch page";
//
//	}
//
//	@Test
//
//	public void validate_Error_NoStudent_Batch()throws Exception
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User validates the error of saving new batch without students");
//		Thread.sleep(1000);
//		expectedValue="Please select the students";
//		assertEquals(expectedValue, actualValue);
//		details="The user confirms that the new custom batch is not created without students";
//
//	}
//
//	@Parameters({"batchDetails"})
//	@Test
//	public void search_Custom_Batch(String batchDetails)throws Exception
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User enters the batch details");
//		courseMappingView.searchCustomBatch(batchDetails);
//		Thread.sleep(1000);
//		details="The batch details are entered";
//
//	}
//
//	@Parameters({"batchName"})
//	@Test
//	public void save_Staff_Advisor(String batchName)throws Exception
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User enters the staff advisor for the new custom batch");
//		actualValue=courseMappingView.saveStaffAdvisor(batchName);
//		Thread.sleep(1000);
//		details="The staff advisor is assigned";
//
//	}
//
//	@Test
//	public void validate_Save_Staff_Advisor()throws Exception
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User validates the assignment of Staff Advisor ");
//		expectedValue="pass";
//
//		assertEquals(expectedValue, actualValue);
//		Thread.sleep(1000);
//		details="The user confirms the assignment of staff advisor";
//
//	}
//
//
//	@Parameters({"batchName"})
//	@Test
//	public void delete_Custom_Batch(String batchName)throws Exception
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User deletes the custom batch");
//		courseMappingView.deleteCustomBatch(batchName);
//		Thread.sleep(1000);
//		details="Error message is displayed";
//
//	}
//
//
//	@Test
//	public void validate_Error_Delete_Batch()throws Exception
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User validates the assignment of Staff Advisor ");
//		actualValue=courseMappingView.validateErrorDeleteBatch();
//
//		expectedValue=actualValue;
//
//		assertEquals(expectedValue, actualValue);
//		Thread.sleep(1000);
//		details="The error message is validated";
//
//	}
//
//
//	@AfterMethod
//	//writing the status to the report
//	public void getResult(ITestResult result)
//	{
//		//if the testing is a failure
//		if(result.getStatus()==ITestResult.FAILURE)
//		{
//
//			//Using details of date and time for naming the screenshot
//
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
//		String fileName=System.getProperty("user.dir")+"/target/CourseMapping_"+dtf.format(now)+".html";
//		File newFile=new File(fileName);
//
//		//Renaming the report with new name
//
//		System.out.println(oldFile.renameTo(newFile));
//
//		//Opening the report
//		//Desktop.getDesktop().browse(new File(fileName).toURI());
//	}
//}
//
//
//
//
//
//
