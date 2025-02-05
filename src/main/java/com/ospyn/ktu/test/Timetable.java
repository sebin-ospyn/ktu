package com.ospyn.ktu.test;

import static org.testng.AssertJUnit.assertEquals;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ospyn.ktu.util.DriverConfig;
import com.ospyn.ktu.util.GenerateExtentReport;
import com.ospyn.ktu.util.Screenshot;
import com.ospyn.ktu.util.ViewLogin;
import com.ospyn.ktu.view.KTUWebElements;
import com.ospyn.ktu.view.ViewTimetable;
import com.relevantcodes.extentreports.LogStatus;

public class Timetable extends DriverConfig
{
	//creating reference to ViewCourseMapping
	ViewTimetable timetableView;

	//creating reference for Login
	static ViewLogin login;

	//Creating reference for creating Extent Reports
	static GenerateExtentReport report=Login.report;

	//Creating reference for extracting  screenshots of failed tests
	Screenshot screenshot;

	//Creating static variable for adding details to log
	static String details;


	String actualValue,expectedValue;

	//Creating reference for driver
	WebDriver driver;
	WebElement element;
	KTUWebElements webelement;

	//creating a variable for assigning the test name  before each test
	String[] testName;

	public Timetable()throws Exception
	{
		/*initializing..
//			 * ExtentReport-->Using a class GenerateExtentReport class in the util package
//			 * WebDriver--->Using the DriverConfig class in the util package
//			 *
//			 */
		driver=getDriver();
		webelement=new KTUWebElements(driver);
		report=Login.report;
		screenshot=new Screenshot();
		timetableView=new ViewTimetable(driver);

	}

	@BeforeTest
	public void getTestName(final ITestContext testContext)
	{

		String test=testContext.getName(); // gets the test name assigned in the xml file
		testName=test.split("-");

	}


	@Test
	public void click_Exam_Tab()throws Exception
	{
		Thread.sleep(1000);
		System.out.println("Within university");
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User clicks the Exam tab");
		element=webelement.getExam();
		element.click();

		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		details="The administration side menu is displayed";

	}

	@Test
	public void click_ExamDefinition()
	{

		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User clicks the Exam Definition option  from the side menu" );
		webelement.getExamDefinition().click();
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{

		}
		details="The Exam Definition Listing page is displayed";

	}

	@Test
	public void exam_Selection() throws Exception
	{

		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User enters the exam details" );

		timetableView.enterDetails();

		details="The exam details are entered";

	}
	@Test
	public void click_Search_Button()
	{

		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User clicks the Search button" );
		webelement.getSearch().click();
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{

		}
		details="The exams satisfying the criteria are displayed";

	}

	@Test
	public void click_View()
	{

		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User clicks the view button" );


		try
		{
			Thread.sleep(1000);
			timetableView.viewButton().click();
			Thread.sleep(1000);
		}
		catch(Exception e)
		{

		}
		details="The examination settings  page is displayed";

	}

	@Test
	public void click_registrationAllowedCourses()
	{

		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User clicks the registration allowed courses" );


		try
		{
			timetableView.clickRegistrationAllowedCourses();
			Thread.sleep(1000);
		}
		catch(Exception e)
		{

		}
		details="The examination settings  page is displayed";

	}

	@Parameters({"eventName"})
	@Test
	public void select_EventName(String eventName)
	{

		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User enters the exam Name" );

		try
		{
			timetableView.enterExamName(eventName);
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		details="The examination settings  page is displayed";

	}


	@Test
	public void click_List_Timetable()
	{

		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User clicks the List Timetable button" );


		try
		{
			Thread.sleep(1000);
			timetableView.listTimeTableButton().click();
			Thread.sleep(1000);
		}
		catch(Exception e)
		{

		}
		details="The timetable definition page is displayed";

	}


	@Test
	public void click_EventName()
	{

		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User clicks the event name" );
		timetableView.getEditButton().click();
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{

		}
		details="The add Exam timetable page is displayed";

	}
	@Parameters({"eventName"})
	@Test
	public void click_EventName1(String eventName)
	{

		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User clicks the event name" );
		timetableView.getEditButton().click();
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{

		}
		details="The add Exam timetable page is displayed";

	}


	@Test
	public void click_Add_Button()
	{

		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User clicks the Add button" );
		webelement.getAdd().click();
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{

		}
		details="The Add Exam timetable page is displayed";

	}

	@Test
	public void exam_Timetable_Details() throws Exception
	{

		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User enters the timetable details" );
		timetableView.enterTimetableDetails();

		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{

		}
		details="The table to add timetable details will be displayed";

	}

	@Test
	public void click_Save()throws Exception
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User clicks the Save button" );
		webelement.getSave().click();
		try
		{
			Thread.sleep(1000);
			details="The timetable is saved";
			Thread.sleep(1000);
		}
		catch(Exception e)
		{

		}

	}

	@Test
	public void click_Generate()throws Exception
	{

		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User clicks the Generate button" );
		webelement.getGenerate().click();
		timetableView.generateTimeTable();
		try
		{

			Thread.sleep(2000);
		}
		catch(Exception e)
		{

		}
		details="The timetable is generated";

	}

	@Test
	public void click_Approve()throws Exception
	{

		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User clicks the Approve button" );
		webelement.getApprove().click();
		timetableView.approveTimeTable();
		try
		{

			Thread.sleep(1000);
		}
		catch(Exception e)
		{

		}
		details="The timetable is Approved";

	}


	@Test
	public void click_Back()
	{

		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User clicks the back button" );
		webelement.getBack().click();
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{

		}
		details="The user moves back to Timetable definition";

	}

	@Test
	public void click_View_TimeTable()
	{

		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User clicks view Timetable");
		timetableView.viewSavedTimetable();
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{

		}
		details="The saved timetable is opened";

	}

	@Test
	public void validate_Saved_Timetable()
	{

		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User validates saved timetable");
		actualValue=timetableView.validateSaved();
		expectedValue="Exam Time Table Details";

		System.out.println("expected Value"+expectedValue);
		System.out.println("Actual Value"+actualValue);
		assertEquals(expectedValue, actualValue);

		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{

		}
		details="The saved timetable is validated";

	}

	@Test
	public void click_Edit_Button()
	{

		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User clicks edit Timetable");
		timetableView.clickEditTimetable();
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{

		}
		details="The saved timetable is opened";

	}

	@Test
	public void select_Revert( )throws Exception
	{

		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User clicks revert Timetable");
		timetableView.clickRevert();
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{

		}
		details="The timetable is reverted";

	}

	@Test
	public void edit_Timetable()
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User enters updations");
		timetableView.editTimeTable();
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{

		}
		details="The saved timetable is opened";

	}

	@Parameters({"id"})

	@Test
	public void edit_Timetable_TwoSlots(int id)throws Exception
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User add new slot and enters data");
		timetableView.editTimeTableTwoSlots(id);

		try
		{
			Thread.sleep(1000);
		}

		catch(Exception e)
		{

		}
		details="The saved timetable is opened";

	}
	@Test
	public void edit_Timetable_Three_Slots()throws Exception
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User add new slot and enters data");
		timetableView.editTimeTableThreeSlots();

		try
		{
			Thread.sleep(1000);
		}

		catch(Exception e)
		{

		}
		details="The courses are entered";

	}

	@Test
	public void enter_Course_A_Slot()throws Exception
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User adds a course to the slot");
		timetableView.enterCourse();

		try
		{
			Thread.sleep(1000);
		}

		catch(Exception e)
		{

		}
		details="The couerse is added";

	}

	@Test
	public void courses_In_Slots()throws Exception
	{

		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User enters courses in slots");
		timetableView.enterCoursesInSlots();
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{

		}
		details="The details are entered";

	}

	@Test
	public void validate_Save_Error()throws Exception
	{

		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User validates the error in save");
		actualValue=timetableView.validateSaveError();
		expectedValue="View Missing Time Table";
		assertEquals(expectedValue,actualValue);
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{

		}
		details="The actual result is same as expected result";

	}

	@Test
	public void slots_Course_Blank()throws Exception
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User enters courses in slots");
		timetableView.courseBlank();
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{

		}
		details="The details are entered";
	}

	@Test
	public void same_Course_slots()throws Exception
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User enters courses in slots");
		System.out.println("Hello");
		timetableView.courseDuplicate();
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{

		}
		details="The details are entered";
	}
	@Test
	public void validate_Duplicate_Course()throws Exception
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User validates error message");

		expectedValue="Duplicate Timetable found in A slot";
		actualValue=timetableView.validateDuplicate();
		assertEquals(true,actualValue.startsWith(expectedValue));

	}
	@Test
	public void click_View_Timetable()
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User clicks the view Timetable button" );
		timetableView.viewTimeTableButton().click();
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{

		}
		details="The Examination details page is displayed";

	}
	@Parameters({"eventName"})
	@Test
	public void click_Courses(String eventName)throws Exception
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User clicks the courses link" );
		timetableView.registrationAllowedCourses(eventName);
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{

		}
		details="The slot details are listed";

	}
	@Parameters({"course"})
	@Test
	public void common_Course_Slots(String course)throws Exception
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User enters the courses" );
		timetableView.coursesCommon(course);
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{

		}
		details="The slot details are listed";

	}
	@Test
	public void copy_Timetable()throws Exception
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User copies timetable to another event" );
		timetableView.copyTimetable();
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{

		}
		details="The timetable is copied";

	}

	@Test
	public void vaidate_Copy()throws Exception
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User validates whether timetable was copied");

		expectedValue="pass";
		actualValue=timetableView.validateCopy();
		assertEquals(expectedValue,actualValue);
		details="Actual result and expected result are same";

	}

	@Test
	public void scheduled_By_College_SlotA()throws Exception
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User enters exam details" );
		timetableView.courseScheduledByCollegeSlotA();
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{

		}
		details="Error message is shown";

	}
	@Test
	public void validate_Error_Schedule_By_College()throws Exception
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User validates the error message");

		expectedValue="Following slot(s) can't be marked as Scheduled by college: A";
		actualValue=timetableView.validateError();
		assertEquals(expectedValue,actualValue);
		details="Actual result and expected result are same";

	}

	@Test
	public void scheduled_By_College_SlotS()throws Exception
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User enters exam details" );
		timetableView.courseScheduledByCollegeSlotS();
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{

		}
		details="The Examination details page is displayed";

	}

	@Test
	public void S1_S2_Combined()throws Exception
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User enters time and date" );
		timetableView.S1S2Exam();
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{

		}
		details="The Examination details page is displayed";

	}
	@Test

	public void courses_Different_Slots()throws Exception
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br /><br />User enters three courses in slot B" );
		timetableView.coursesInDifferentSlots();
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{

		}
		details="The Examination details page is displayed";

	}

	@Test
	public void clicking_Absentee() throws Exception
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User clicks the enter absentee button</i>");

		timetableView.clickAbsenteeButton().click();


		details="Enter absentee button is clicked";


}


	@Test
	public void entering_Absentee_Data() throws Exception
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User enters the absentee name</i>");

		timetableView.enterAbsentee();


		details=" user enters the absentee data";


}
	@Test
	public void clicking_Absentee_Delete() throws Exception
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User clicks on the delete button</i>");

		timetableView.clickAbsenteeDeleteButton();


		details=" user deletes the absentee";


}

	@Test
	public void click_Save_Button() throws Exception
	{
		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</b><br /><br /><i>User enters the absentee name</i>");

		timetableView.clickSaveButton();


		details=" user enters the absentee data";


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

		String fileName=System.getProperty("user.dir")+"/target/CourseMapping_"+dtf.format(now)+".html";
		File newFile=new File(fileName);

		//Renaming the report with new name

		System.out.println(oldFile.renameTo(newFile));

		//Opening the report
		Desktop.getDesktop().browse(new File(fileName).toURI());
	}
}



