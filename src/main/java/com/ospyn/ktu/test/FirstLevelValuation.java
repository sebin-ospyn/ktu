package com.ospyn.ktu.test;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.openqa.selenium.Keys;
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
import com.ospyn.ktu.view.ViewFirstLevelValuation;
import com.relevantcodes.extentreports.LogStatus;

public class FirstLevelValuation extends DriverConfig {

	// creating reference to ViewCourseMapping
	ViewFirstLevelValuation FirstLevelValuationview;
	// creating reference for Login
	static ViewLogin login;

	// Creating reference for creating Extent Reports
	static GenerateExtentReport report = Login.report;

	// Creating reference for extracting screenshots of failed test
	Screenshot screenshot;

	// Creating static variable for adding details to log
	static String details;

	String actualValue, expectedValue;
	boolean actualText, expectedText;

	// Creating reference for driver
	WebDriver driver;
	WebElement element;

	// creating a variable for assigning the test name before each test
	String[] testName;

	public FirstLevelValuation() throws Exception {

		report = Login.report;
		screenshot = new Screenshot();
		driver = getDriver();
		FirstLevelValuationview = new ViewFirstLevelValuation(driver);

	}

	// Getting the test name
	@BeforeTest
	public void getTestName(final ITestContext testContext) {

		String test = testContext.getName(); // gets the test name assigned in the xml file
		testName = test.split("-");

	}

	@Test
	public void click_Valuation_Tab() throws InterruptedException {
		report.beginTest(
				"<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br />User clicks the Valuation tab");
		FirstLevelValuationview.ValuationTab();

		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println(e);
		}
		details = "Valuation module is selected successfully and all the submodules under the valuation module is displayed";

	}

	@Test
	public void click_Valuation_Camp() {
		report.beginTest("<b>" + testName[0] + "<br />" + testName[1]
				+ "</B><br /><br />User clicks the valuation camp submodule");
		WebElement element = FirstLevelValuationview.valuationcamp();
		element.sendKeys(Keys.ENTER);

		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println(e);
		}
		details = "While clicks the valuation camp submodule it redirect to valuation camp page ";

	}

	@Test
	public void click_add_button_in_the_valuation_camp_page() {
		report.beginTest("<b>" + testName[0] + "<br />" + testName[1]
				+ "</B><br /><br />User clicks the valuation camp submodule");
		WebElement element = FirstLevelValuationview.clickaddbutton();
		element.sendKeys(Keys.ENTER);

		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println(e);
		}
		details = "While clicks the add button in the camp submodule it redirect to valuation camp page ";

	}

	@Parameters({ "campdetails" })
	@Test
	public void enter_details_of_valuation_camp(String campdetails) throws Exception {
		report.beginTest(
				"<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br />User enters the batch details");
		FirstLevelValuationview.addvaluationcamp(campdetails);
		Thread.sleep(1000);
		details = "The batch details are entered";

	}

	@Test
	public void click_prepare_packets() {
		report.beginTest("<b>" + testName[0] + "<br />" + testName[1]
				+ "</B><br /><br />User clicks the valuation camp submodule");
		WebElement element = FirstLevelValuationview.getPreparepackets();
		element.sendKeys(Keys.ENTER);

		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println(e);
		}
		details = "While clicks the add button in the camp submodule it redirect to valuation camp page ";

	}

	@Test
	public void Packet_preparation_from_camp() throws Exception {
		report.beginTest(
				"<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br />User enters the batch details");
		FirstLevelValuationview.packetpreparation();
		Thread.sleep(1000);
		details = "The batch details are entered";

	}

	@Test
	public void click_create_or_view_packets() throws InterruptedException {
		report.beginTest("<b>" + testName[0] + "<br />" + testName[1]
				+ "</B><br /><br />User clicks create/view button in the prepare packet page");
		FirstLevelValuationview.createorviewpackets();

		details = "While clicks the add button in the camp submodule it redirect to valuation camp page ";

	}

	@Test
	public void click_save_or_verify() throws InterruptedException {
		report.beginTest("<b>" + testName[0] + "<br />" + testName[1]
				+ "</B><br /><br />User clicks save/verify button in the prepare packet page");
		FirstLevelValuationview.clicksaveorverify();

		details = "User saved/verified prepared packets after clicking the button save/verify";

	}

	@Test
	public void click_post_faculty_members_tab() {
		report.beginTest("<b>" + testName[0] + "<br />" + testName[1]
				+ "</B><br /><br />User clicks the post faculty member submodule");
		WebElement element = FirstLevelValuationview.getPostfacultymember();
		element.sendKeys(Keys.ENTER);

		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println(e);
		}
		details = "Selected the submodule post faculty members";

	}

	@Test
	public void posting_faculty_members_page() throws Exception {
		report.beginTest("<b>" + testName[0] + "<br />" + testName[1]
				+ "</B><br /><br />Adding filters in the post faculty member page for posting faculty members for valuation");
		FirstLevelValuationview.postingfaculty();
		Thread.sleep(1000);
		details = "Added filters in the post faculty member page for posting faculty members for valuation";

	}

	@Test
	public void click_search_button_in_the_post_faculty_member_page() throws Exception {
		report.beginTest("<b>" + testName[0] + "<br />" + testName[1]
				+ "</B><br /><br />User clicks the search button in the post faculty member page after adding filters");
		FirstLevelValuationview.searchbuttonpostfaculty();
		Thread.sleep(1000);
		details = "User clicked the search button in the post faculty member page after adding filters and the posted faculties are listed in that page";
	}

	@Test
	public void post_faculty() throws Exception {
		report.beginTest("<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br />User enter the faculty id");
		FirstLevelValuationview.postfaculty();
		Thread.sleep(1000);
		details = "User entered the faculty id in the field faculty";

	}

	@Test
	public void click_post_faculty_button() throws Exception {
		report.beginTest(
				"<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br />User clicks the post faculty button");
		FirstLevelValuationview.clickpostfaculty();
		Thread.sleep(1000);
		details = "User posted the faculty";

	}

	@Test
	public void click_distribute_packets() throws Exception {
		report.beginTest(
				"<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br />User clicks distribute packets button");
		FirstLevelValuationview.clickdistributepackets();
		Thread.sleep(1000);
		details = "User selects distribute packets button and distribute packets page is displayed";

	}

	@Test
	public void click_add_button() throws Exception {
		report.beginTest("<b>" + testName[0] + "<br />" + testName[1]
				+ "</B><br /><br />User clicks the add button in the distribute packets page");
		FirstLevelValuationview.clickaddbtn();
		Thread.sleep(1000);
		details = "User clicked the add button and a page for adding packet details are displayed";

	}

	@Test
	public void distribute_packets() throws Exception {
		report.beginTest(
				"<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br />User distributing the packets");
		FirstLevelValuationview.distributepackets();

		Thread.sleep(1000);
		details = "User successfully distributed the packets";

	}

	@Test
	public void logout() throws Exception {
		report.beginTest("<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br /> Logout from the page");
		FirstLevelValuationview.logout();

		Thread.sleep(1000);
		details = "User logout from the page";

	}

	@Test
	public void Login_as_faculty() throws Exception {
		report.beginTest("<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br /> Log in as First examiner");
		FirstLevelValuationview.loginasFaculty();

		Thread.sleep(5000);
		details = "User logged in as first examiner";

	}

	@Test
	public void click_assigned_courses() throws Exception {
		report.beginTest(
				"<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br /> clicks assigned courses button ");
		WebElement element = FirstLevelValuationview.getAssignedcourses();
		element.click();

		Thread.sleep(1000);
		details = "User clicked assigned courses button";

	}

	@Test
	public void add_filters_in_assigned_courses_page() throws Exception {
		report.beginTest("<b>" + testName[0] + "<br />" + testName[1]
				+ "</B><br /><br />User adding filters in the assigned courses page after login as first examiner");
		FirstLevelValuationview.filterinAssignedCourses();

		Thread.sleep(1000);
		details = "User added filters in the assigned courses page after login as first examiner";

	}

	@Test
	public void click_search_button() throws Exception {
		report.beginTest("<b>" + testName[0] + "<br />" + testName[1]
				+ "</B><br /><br /> User clicks the search button after adding the filters in the assigned courses page");
		FirstLevelValuationview.clickSearchbutton();

		Thread.sleep(1000);
		details = "User clicks the search button after adding the filters in the assigned courses page and the assigned packet number and other details are displayed";

	}

	@Test
	public void selecting_assigned_packets() throws Exception {
		report.beginTest("<b>" + testName[0] + "<br />" + testName[1]
				+ "</B><br /><br /> User selecting assigned packets button against the assigned course");
		FirstLevelValuationview.selectingAssignedPackets();

		Thread.sleep(1000);
		details = "User selecting assigned packets button against the assigned courses  ";

	}

	@Test
	public void click_view_generated_false_number() throws Exception {
		report.beginTest("<b>" + testName[0] + "<br />" + testName[1]
				+ "</B><br /><br /> User clicks view generated false number button");
		FirstLevelValuationview.viewGeneratedFalseno();

		Thread.sleep(1000);
		details = "User clicked view generated false number button";

	}

	@Test
	public void storing_false_numbers() throws Exception {
		report.beginTest("<b>" + testName[0] + "<br />" + testName[1]
				+ "</B><br /><br /> Storing false number from the view generated false number page");
		FirstLevelValuationview.storingFalseNumberFilter();
		FirstLevelValuationview.searchButtonViewGeneratedFalseNumber();
		FirstLevelValuationview.storingFalseNumber();

		Thread.sleep(1000);
		details = "Stored false number from the view generated false number page ";

	}

	@Test
	public void enter_marks() throws Exception {
		report.beginTest(
				"<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br /> First examiner entering marks");
		FirstLevelValuationview.markEnteringProcess();

		Thread.sleep(1000);
		details = "First examiner entered marks";

	}

	@Test
	public void Login_as_adexam() throws Exception {
		report.beginTest("<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br /> Log in as University user");
		FirstLevelValuationview.adexamLogin();

		Thread.sleep(1000);
		details = "User logged in as University user";

	}

	@Test
	public void filters_in_distribute_packets_page() throws Exception {
		report.beginTest("<b>" + testName[0] + "<br />" + testName[1]
				+ "</B><br /><br /> Adding filters in distributed packets page");
		FirstLevelValuationview.addingFilterinDistributePacketsPage();

		Thread.sleep(1000);
		details = "User added filters in the distributed packets page";

	}

	@Test
	public void Receiving_packets() throws Exception {
		report.beginTest("<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br /> Receiving packets");

		FirstLevelValuationview.packetReceiving();

		Thread.sleep(1000);
		details = "User received packets successfully";

	}

	@Test
	public void Revoking_returned_packets() throws Exception {
		report.beginTest("<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br /> Revoking returned packets");

		FirstLevelValuationview.revokingReturnedPackets();

		Thread.sleep(1000);
		details = "User revoked returned packets";

	}

	@Test
	public void Packets_send_back_to_the_examiner() throws Exception {
		report.beginTest(
				"<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br /> Packets sent back to examiner");
		FirstLevelValuationview.packetsSendBacktoExaminer();

		Thread.sleep(1000);
		details = "User sent back the packets to examiner";

	}

	@Test
	public void Cancelling_distributed_packets() throws Exception {
		report.beginTest(
				"<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br />Cancelling the distributed packets");
		FirstLevelValuationview.cancellingReturnedPackets();

		Thread.sleep(1000);
		details = "User cancelled the distributed packets";

	}

	@Test
	public void save_mark_entry_page_with_blank_details() throws Exception {
		report.beginTest("<b>" + testName[0] + "<br />" + testName[1]
				+ "</B><br /><br />Unable to Save mark entry page with blank details and a validation' You cannot save mark with out false number and mark ' displayed at that time");
		FirstLevelValuationview.saveMarkEntryPageWithBlankDetails();

		Thread.sleep(1000);
		details = "User unable to save mark entry page with blank details and a validation ' You cannot save mark with out false number and mark ' displayed at that time";

	}

	@Test
	public void save_mark_entry_page_without_enter_mark() throws Exception {
		report.beginTest("<b>" + testName[0] + "<br />" + testName[1]
				+ "</B><br /><br />Unable to Save mark entry page with blank details and a validation' You cannot save mark with out false number and mark ' displayed at that time");
		FirstLevelValuationview.saveMarkEntryPageWithoutEnterMarks();

		Thread.sleep(1000);
		details = "User unable to save mark entry page with blank details and a validation ' You cannot save mark with out false number and mark ' displayed at that time";

	}

	@AfterMethod
	// writing the status to the report
	public void getResult(ITestResult result) {
		// if the testing is a failure
		if (result.getStatus() == ITestResult.FAILURE) {

			// Using details of date and time for naming the screenshot

			String dateName = new SimpleDateFormat("ddMMyyyy_hhmmss").format(new Date());

			// capturing screenshot of the failed method
			String screenshotName = result.getMethod().getMethodName() + "-" + dateName + ".jpg";

			screenshot.captureScreenshot(screenshotName, driver);

			// Adding screenshot to the report for the failed test
			report.addScreenShotToLog(System.getProperty("user.dir") + "/Screenshots/" + screenshotName);
		}

		// if testing is successful
		else if (result.getStatus() == ITestResult.SUCCESS) {
			report.setLog(LogStatus.PASS, details);
		}

		// if testing is skipped
		else if (result.getStatus() == ITestResult.SKIP) {
			report.setLog(LogStatus.SKIP, "Skipped");
		}
		// Ending the test
		report.endTest();

	}

	@AfterSuite
	public void endTest() throws IOException {
		// closing the report
		report.endReport();

		// Renaming the report by adding date and time to the report
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();

		File oldFile = new File(System.getProperty("user.dir") + "/target/Report.html");

		String fileName = System.getProperty("user.dir") + "/target/FirstLevelValuation_" + dtf.format(now) + ".html";
		File newFile = new File(fileName);

		// Renaming the report with new name

		System.out.println(oldFile.renameTo(newFile));

		// Opening the report
		Desktop.getDesktop().browse(new File(fileName).toURI());
	}

}