package com.ospyn.ktu.test;

import static org.testng.AssertJUnit.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import com.ospyn.ktu.view.ViewCourseSelection;
import com.relevantcodes.extentreports.LogStatus;


public class CourseSelection extends DriverConfig
{
	//creating reference to ViewCourseSelection
	ViewCourseSelection courseSelectionView;

	//creating reference for Login
	static ViewLogin login;

	//Creating reference for creating Extent Reports
	static GenerateExtentReport report;

	//Creating reference for extracting  screenshots of failed tests
	Screenshot screenshot;

	//Creating static variable for adding details to log
	String details;

	//Creating reference for driver
	WebDriver driver;

	WebElement element;

	//creating a static variable for assigning the test name  before each test
	static String[] testName;

	public CourseSelection()throws Exception
	{
		/*initializing..
//		 * ExtentReport-->Using a class GenerateExtentReport class in the util package
//		 * WebDriver--->Using the DriverConfig class in the util package
//		 *
//		 */
		report=Login.report;
		screenshot=new Screenshot();
		driver=getDriver();
		courseSelectionView=new ViewCourseSelection(driver);

	}

	@BeforeTest
	public void getTestName(final ITestContext testContext)
	{

		String test=testContext.getName(); // gets the test name assigned in the xml file
		testName=test.split("-");

	}

	@Test
	public void click_AcademicsTab() throws InterruptedException

	{
		// Maximize the browser window
        driver.manage().window().maximize();
		Thread.sleep(1000);


		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User clicks the Academics tab</i>");
		//Getting Academic tab and clicking the tab
		courseSelectionView.getAcademics().sendKeys(Keys.ENTER);
		details="User navigates to the Academic Management page";
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.print(e);
		}

	}

	@Test

	public void click_Course_Details()throws Exception
	{
		Thread.sleep(1000);
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User clicks course details from the side menu</i>");
		//Clicking on Course Details link from the side menu
		courseSelectionView.getCourseDetailsLink().sendKeys(Keys.ENTER);
		details="User navigates to the Course Selection page";
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
	}

	@Test

	public void course_Selection_Details() throws Exception

	{

		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User enters the course details");
		//Parameters are accepted  and used for searching the branches of college
		courseSelectionView.enterDetails();
		details="The details are entered";
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
	}


	@Test

	public void course_Selection_Details_RequestType() throws Exception

	{

		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User enters the course details");
		//Parameters are accepted  and used for searching the branches of college
		courseSelectionView.enterDetailsWithRequestType();
		details="The details are entered";
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
	}


	@Test

	public void click_Search()throws Exception
	{
		//Getting search button and clicking the button
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User clicks on the search button");

		element=courseSelectionView.getSearch();
		element.click();
		Thread.sleep(2000);
		details="The branches satisfying the criteria are listed";
	}

	@Test

	public void part_Time_error()throws Exception
	{

		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User validates the error of course selection for the semester not opened yet</i>");
		assertEquals("Course Selection for this semester is not yet opened.", courseSelectionView.getPartTimeError().getText());
		details="The error message is validated";
		Thread.sleep(1000);
	}

	@Test
	public void page_loaded() throws InterruptedException
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User stays in the display results page of search</i>");
		details="";
		Thread.sleep(1000);

	}

	@Test
	public void choose_Course()
	{
		//Choosing courses for branches
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User selects a branch");
		element=courseSelectionView.getChooseCourseButton();
//		Java script executor added beacause element.click not working.element displying out of UI
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
//		element.click();
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		details="The course list of that particular branch is displayed";

	}

	@Test
	public void click_Save()
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User clicks on Save button without selecting any courses for slots</i>");
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		//getting save button and clicking the button
		JavascriptExecutor js = (JavascriptExecutor) driver;
		element= courseSelectionView.getSaveButton();
		js.executeScript("arguments[0].click();", element);
		//element.click();
		details="Error message is displayed";
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
	}

	@Test
	public void display_Error_Message()throws Exception
	{
		//validating the expected message with actual message shown
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User validates the message displayed</i>");

		String str="Select 1 courses from the slots";
		assertEquals(true,courseSelectionView.getErrorMessage().startsWith(str));
		details="Error message validated";

	}

	@Test
	public void course_Slots() throws InterruptedException
	{

		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User enters values for slots</i>");
		//selecting courses for slots in the selected branch
		String result=courseSelectionView.selectCoursesInSlots();
		details="Courses are selected";
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		if(result.equals("pass"))
		{
			details="Courses are selected";
			report.setLog(LogStatus.PASS, details);
		}
		else
		{
			details="";
			report.setLog(LogStatus.FAIL, details);

		}

	}


	@Test
	public void validate_Saved_Success()throws Exception
	{

		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>The saved message is validated</i>");
		//validating the expected message with actual message shown
		assertEquals("Saved Successfully",courseSelectionView.showSavedMessage().getText());
		details="Expected result and actual result are same";
		Thread.sleep(1000);
	}
	@Test
	public void search_Page_Displayed()throws Exception
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User is in branches displayed page</i>");
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		//Moving back to the course selection page
		element=courseSelectionView.getBackButton();
		element.click();
		Thread.sleep(1000);
		details="User moves back to course selection page";

	}
	@Test
	public void export_Courses_Click()throws Exception
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User clicks on the Export Button</i>");
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		element=courseSelectionView.getExportCouseButton();
		element.click();
		details="The branches list is downloaded";
		Thread.sleep(1000);

	}

	@Test
	public  void validate_Excel_File() throws Exception

	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User validates the file downloaded</i>");

		File excelfile=courseSelectionView.getExcelFile();

		String content= courseSelectionView.getExcelFileContent(excelfile);

		assertEquals(content, "B.Tech");
		details="The file is downloaded to downloads folder";
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.print(e);
		}

	}

	@Test
	public void click_Submit_Button() throws AWTException, InterruptedException

	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User clicks the Submit button</i>");
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.print(e);
		}

		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);

		element=courseSelectionView.getSubmitButton();

//		element.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);
		details="Error message is shown";


	}

	@Test

	public void validate_Submit_Error_Message()

	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User validates the error message</i>");
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		courseSelectionView.getConfirmYes1().sendKeys(Keys.ENTER);
		String expected="Course selection not completed";
		assertEquals(true,courseSelectionView.getErrorLabel().getText().startsWith(expected));
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		courseSelectionView.getConfirmNo2().sendKeys(Keys.ENTER);
		details="Error message \"Course selection not completed \"is displayed";
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.print(e);
		}

	}

	@Test

	public void fill_All_Courses() throws Exception

	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User chooses courses for all the branches available</i>");
		courseSelectionView.setStatus("Submit");
		courseSelectionView.chooseAllCourses();
		details="Courses for all the branches are selected";
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
	}
	@Test

	public void get_Submit_button()throws Exception

	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User clicks on Submit button</i>");
		element=courseSelectionView.getSubmitButton();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
//		element.click();

		Thread.sleep(1000);

		courseSelectionView.getConfirmYes1().sendKeys(Keys.ENTER);
		details="Alert message showing courses submitted to university is shown";
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
	}

	@Test
	public void validate_Submit_Success()
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User validates the submission of courses to university</i>");

		assertEquals("Your institution's Course selections for the selected program have been submitted to the university",
				courseSelectionView.getSuccessLabel().getText());
		details="Message:\"Your institution's Course selections for the selected program have been submitted to the university\" is shown";

	}


	@Test
	public void course_Selection_Page()throws Exception
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User moves back to course selection page</i>");
		click_AcademicsTab();
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		click_Course_Details();
		details="User is in the course selection page";

	}

	@Test

	public void no_Curriculum_Found()throws Exception

	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User validates the error message</i>");
		assertEquals("No curriculum found",courseSelectionView.getErrorMessage1().getText());
		Thread.sleep(1000);
		details="Error message \" No Curriculum found\" is validated";
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
	}

	@Test
	public void get_LastDate_Error()throws Exception

	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User validates the error message</i>");
		String message=courseSelectionView.getDateOverMessage().getText();
		assertEquals(true,message.contains("Last date for course selection is over"));
		Thread.sleep(1000);
		details="Error message of \"Last date for the course selection is over\" is validated";
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.print(e);
		}

	}

	@Test
	public void view_Curriculum()

	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User clicks on  view curriculum</i>");
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.print(e);
		}

		element=courseSelectionView.getViewCurriculum();
		element.click();

		details="The course list of that particular branch is dislayed";


	}

	@Test

	public void add_Course()

	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User clicks on Add Course</i>");
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.print(e);
		}

		element=courseSelectionView.getAddCourse();
		element.click();

		System.out.println("Add Course button clicked");

		details="The additonal courses adding window appears ";

	}

	@Test

	public void fill_Slots()
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User enters the slot and course name</i>");

		courseSelectionView.fillSlots();

		details="The courses and slots are entered ";

		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.print(e);
		}

	}

	@Test

	public void get_Save_Button()
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><i>User clicks on Save button</i>");
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		courseSelectionView.getSaveButton1().sendKeys(Keys.ENTER);
		details="Message is displayed";
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.print(e);
		}

	}
	@Test

	public void validate_Saved_Course()
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><i><br />User validates the Saved course</i>");

		System.out.println(courseSelectionView.getSavedCourse().getText());
		assertEquals(courseSelectionView.getSelectedValue(), courseSelectionView.getSavedCourse().getText());
		details="The \"Course is saved \" message is validated";

	}


	@Test

	public void enter_Details_Course()throws Exception

	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><i><br />User enters the course details</i>");
		courseSelectionView.enterDetailsCourse();
		details="The submitted course selections of that college are displayed";

	}
	@Test
	public void click_College()

	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><i><br />User clicks on the course required</i>");
		courseSelectionView.getCollegeName().sendKeys(Keys.ENTER);
		details="The course selection of that particular semester is displayed";

	}
	@Test

	public void view_Course()

	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><i><br />User clicks on View Course</i>");


		courseSelectionView.getCoursesButton().sendKeys(Keys.ENTER);
		details="The course selection of that particular branch is displayed";

	}
	@Test
	public void click_UniversityTab()

	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User clicks the University tab</i>");
		//Getting Academic tab and clicking the tab
		courseSelectionView.getUniversity().sendKeys(Keys.ENTER);
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.print(e);
		}

	}
	@Test
	public void click_UniversityInbox()

	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User clicks the University Inbox from the side menu</i>");

		//Getting Academic tab and clicking the tab
		courseSelectionView.getUniversityInbox().click();
		details="User navigates to the University Inbox page";
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.print(e);
		}

	}


	@Test
	public void change_Course()

	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User clicks on Change Course</i>");

		element=courseSelectionView.getChangeCourseButton();
		element.click();

		details="The window to change courses will appear ";
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.print(e);
		}


	}

	@Test
	public void enter_slot_Scheme()

	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User enters the slot and scheme</i>");

		courseSelectionView.selectSlotScheme();
		details="The slot and scheme is selected";

	}

	@Test
	public void remove_Course()throws Exception

	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User clicks the Remove button</i>");

		element=courseSelectionView.getRemoveButton();
		element.click();
		Thread.sleep(1000);
		details="The confirmation dfialog box appears";

	}
	@Test

	public void click_YesButton() throws Exception

	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User clicks the Yes button</i>");

		courseSelectionView.clickYesButton();
		Thread.sleep(1000);
		details="The course is removed";


	}

	@Test
	public void click_Save_Change()throws Exception

	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User clicks the Save button</i>");

		element=courseSelectionView.getSaveButton2();
		element.click();
		Thread.sleep(1000);
		details="The change is saved";

	}
	@Test

	public void click_CancelButton()throws Exception

	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User clicks the Cancel button</i>");

		element=courseSelectionView.getCancelButton();
		element.click();

		Thread.sleep(1000);

		element=courseSelectionView.getBackButton1();
		element.click();


		Thread.sleep(1000);

		details="User moves back to the Search Page";

	}


	@Test
	public void select_CheckBox()throws Exception

	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User selects the checkbox</i>");

		Thread.sleep(1000);
		element=courseSelectionView.getCheckBox();
		element.click();
		details="The course needed to be revoked is selected";

	}
	@Test

	public void get_Revoke_Button()throws Exception

	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User clicks on Revoke button</i>");
		Thread.sleep(1000);

		element=courseSelectionView.getRevokeButton();
		element.click();

		details="The confirm dialog box is displayed";

	}
	@Test
	public void get_Confirm()throws Exception

	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User clicks on the confirm button</i>");

		Thread.sleep(1000);
		element=courseSelectionView.getConfirmYes3();
		element.click();

		details="The revoke error message is displayed";
	}

	@Test
	public void get_errorMsg()

	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User validates the error of Revoke cannot be done</i>");

		String str="Revoke cannot be done";
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{

		}
		boolean actual=courseSelectionView.getErrorMsg().getText().startsWith(str);
		System.out.println(courseSelectionView.getErrorMsg().getText());
		assertEquals(true,actual);

		details="The error message of \"Revoke cannot be done is validated\"";

	}
	@Test

	public void click_No()

	{

		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User confirms No</i>");
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{

		}
		courseSelectionView.getNoButton().sendKeys(Keys.ENTER);
		details="User moves back to the course selection page";

	}
	@Test

	public void select_BranchName()

	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User selects the checkbox</i>");
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{

		}

		courseSelectionView.storeBranchName();
		element=courseSelectionView.getCheckBox();
		element.click();

		details="The course is revoked";

	}
	@Test

	public  void revoke_Success()

	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User validates whether course was revoked</i>");
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{

		}
		String msg=courseSelectionView.getRevokedMessage();
		assertEquals("Revoked",msg);
		details="The revoke is confirmed";

	}
	@Test
	public void fill_All_CoursesRevoked() throws Exception

	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User chooses slots for all the courses revoked</i>");

		courseSelectionView.setStatus("Revoke");
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{

		}
		courseSelectionView.chooseAllCoursesRevoked();
		details="Slots in all branches are filled";
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
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd_MMM_yyyy_HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();

		File oldFile=new File(System.getProperty("user.dir")+"/target/Report.html");

		String fileName=System.getProperty("user.dir")+"/target/CourseSelection_"+dtf.format(now)+".html";
		File newFile=new File(fileName);

		//Renaming the report with new name

		System.out.println(oldFile.renameTo(newFile));

		//Opening the report
		//Desktop.getDesktop().browse(new File(fileName).toURI());
	}
}

/*
 *
 */




