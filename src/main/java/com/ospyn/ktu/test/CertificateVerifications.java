package com.ospyn.ktu.test;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ospyn.ktu.util.DriverConfig;
import com.ospyn.ktu.util.GenerateExtentReport;
import com.ospyn.ktu.util.Screenshot;
import com.ospyn.ktu.util.ViewCommonUtil;
import com.ospyn.ktu.util.ViewLogin;
import com.ospyn.ktu.view.ViewCertificateVerificationInnerPage;
import com.ospyn.ktu.view.ViewCertificateVerifications;
import com.relevantcodes.extentreports.LogStatus;

public class CertificateVerifications extends DriverConfig {

	// creating reference to ViewCertificateVerifications
	ViewCertificateVerifications CertificateVerificationsView;
	
	 ViewCertificateVerificationInnerPage certificateVerificationInnerPage;
	// creating reference for Login
	static ViewLogin login;

	// Creating reference for creating Extent Reports
	static GenerateExtentReport report = Login.report;
	static boolean flag=false;

	// Creating reference for extracting screenshots of failed test
	Screenshot screenshot;

	// Creating static variable for adding details to log
	static String details;
	
//	String actualValue, expectedValue;
//	boolean actualText, expectedText;

	// Creating reference for driver
	WebDriver driver;
	WebElement element;

	// creating a variable for assigning the test name before each test
	String[] testName;

	public CertificateVerifications() throws Exception {

		report = Login.report;
		screenshot = new Screenshot();
		driver = getDriver();
		CertificateVerificationsView = new ViewCertificateVerifications(driver);
		certificateVerificationInnerPage = new ViewCertificateVerificationInnerPage(driver);
		
		ViewCommonUtil.readFromExcel("CertificateVerificationData.xlsx", "content validation");
		
		
	}
	
	
	
//	@BeforeClass
//	@Parameters({"os","browser"})
//	public void setup(String os, String br)
//	{
//		switch (br.toLowerCase()) {
//		case "chrome":driver=new ChromeDriver();break;
//		case "firefox":driver=new FirefoxDriver();break;
//		case "opera":driver=new OperaDriver();break;
//		default: System.out.println("Invalid broser");
//		}
//		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get("http://localhost:5173/verificationPortal/");
//	}
	
//	@BeforeMethod
//	private void syso() {
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver=new ChromeDriver();
//		driver.get("https://www.orangehrm.com/");
//	}
//	@BeforeClass
//	public void ktu_Page_Loaded()
//	{
//		report.beginTest("<b>"+testName[0]+"<br />"+testName[1]+"</B><br />Home page of KTU is loaded");
//		try
//		{
//			Thread.sleep(1000);
//		}
//		catch(Exception e)
//		{
//			System.out.print(e);
//		}
//		details="KTU Page is displayed";
//
//	}
	
	// Getting the test name
		@BeforeTest
		public void getTestName(final ITestContext testContext) {

			String test = testContext.getName(); // gets the test name assigned in the xml file
			testName = test.split("-");
		}

		@Test
		public void HFCertificateVerification() throws Exception {
			report.beginTest(
					"<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br />Certificate verification testing");
			
			
			
			CertificateVerificationsView.login(ViewCommonUtil.getExcelParameters("Register Number"),ViewCommonUtil.getExcelParameters("DOB"));
	        String exptext = CertificateVerificationsView.validatemessage();
	        System.out.println(exptext);
			String acttext ="Certificate Details";
			Assert.assertEquals(exptext, acttext);
			Thread.sleep(1500);
			CertificateVerificationsView.checkAnotherStudent();
			details = "Certificate verification done";

		}
		
		@Test(dataProvider ="ssa")
		public void multipleStudentsIncompleteStatus(String RegNo,String Pswd) throws InterruptedException
		{
			report.beginTest(
					"<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br />Certificate verification testing");
			
			CertificateVerificationsView.login(RegNo,Pswd);
			String exptext=CertificateVerificationsView.warnMessage();
			System.out.println(exptext);
			String acttext="No records found for the provided Register Number and Date of Birth.";
			Assert.assertEquals(exptext,acttext);
			details = "certificate verification done for a student";
//			Thread.sleep(1000);
		}
		
		@Test(dataProvider ="ssb")
		public void multipleStudentsCompletedStatus(String RegNo,String Pswd) throws InterruptedException
		{
			report.beginTest(
					"<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br />Certificate verification testing");
			
			CertificateVerificationsView.login(RegNo, Pswd);
			
			String exptext=CertificateVerificationsView.validatemessage();
			
			String acttext="Certificate Details";
			Assert.assertEquals(exptext,acttext);
			Thread.sleep(1500);
			CertificateVerificationsView.checkAnotherStudent();
			details = "certificate verification done for a student";
//			Thread.sleep(1000);
		}
		
		@Test
		public void verifyContent() throws InterruptedException
		{
			report.beginTest(
					"<b>" + testName[0] + "<br />" + testName[1] + "</B><br /><br />Certificate verification testing");

			CertificateVerificationsView.login(ViewCommonUtil.getExcelParameters("Register Number"),ViewCommonUtil.getExcelParameters("DOB"));
			
			
			String name= CertificateVerificationsView.getNameText();
			System.out.println("Student name is "+name);
//			String actname="ARUN P";
			String actname=	ViewCommonUtil.getExcelParameters("Name");
			System.out.println(actname+"from excel");
			Assert.assertEquals(name,actname);
			
			String registerNumber=CertificateVerificationsView.getRegisterNumText();
			System.out.println("Student register number is "+registerNumber);
//			String actregisterNumber="NSS19ME035";
			String actregisterNumber=	ViewCommonUtil.getExcelParameters("Register Number");
			System.out.println(actregisterNumber+"from excel");
			Assert.assertEquals(registerNumber,actregisterNumber);
			
			String InstitutionName=CertificateVerificationsView.getInstitutionText();
			System.out.println("Institution name is "+InstitutionName);
//			String actInstitutionName="NSS COLLEGE OF ENGINEERING";
			String actInstitutionName=	ViewCommonUtil.getExcelParameters("Institution");
			System.out.println(actInstitutionName+"from excel");
			Assert.assertEquals(InstitutionName,actInstitutionName);
			
			String programName=CertificateVerificationsView.getProgramText();
			System.out.println("Program name is "+programName);
//			String actprogramName="Bachelor of Technology";
			String actprogramName=	ViewCommonUtil.getExcelParameters("Program");
			System.out.println(actprogramName+"from excel");
			Assert.assertEquals(programName,actprogramName);
			
			String branchName=CertificateVerificationsView.getBranchText();
			System.out.println("Branch name is "+ branchName);
//			String actbranchName="Mechanical Engineering";
			String actbranchName=	ViewCommonUtil.getExcelParameters("Branch");
			System.out.println(actbranchName+"from excel");
			Assert.assertEquals(branchName,actbranchName);
			
			String programDuration=CertificateVerificationsView.getProgramDurationText();
			System.out.println("Duration of the program is "+programDuration);
//			String actprogramDuration="4 Years (8 Semesters)";
			String actprogramDuration=	ViewCommonUtil.getExcelParameters("Duration of the Program");
			System.out.println(actprogramDuration+"from excel");
			Assert.assertEquals(programDuration,actprogramDuration);
			
			String modeOfStudy=CertificateVerificationsView.getModeOfStudyText();
			System.out.println("Mode of study is "+modeOfStudy);
//			String actmodeOfStudy="Regular";
			String actmodeOfStudy=	ViewCommonUtil.getExcelParameters("Mode of Study");
			System.out.println(actmodeOfStudy+"from excel");
			Assert.assertEquals(modeOfStudy,actmodeOfStudy);
			
			String mediumOfStudy=CertificateVerificationsView.getMediumOfInstructionText(); 
			System.out.println("Medium of Instruction is "+mediumOfStudy);
//			String actmediumOfStudy="English";
			String actmediumOfStudy=	ViewCommonUtil.getExcelParameters("Medium of Instruction");
			System.out.println(actmediumOfStudy+"from excel");
			Assert.assertEquals(mediumOfStudy,actmediumOfStudy);
			
			String admissionYear=CertificateVerificationsView.getAdmissionYearText(); 
			System.out.println("Year of admission is "+admissionYear);
//			String actadmissionYear="2019";
			String actadmissionYear=	ViewCommonUtil.getExcelParameters("Year of Admission");
			System.out.println(actadmissionYear+"from excel");
			Assert.assertEquals(admissionYear,actadmissionYear);
			
//			String passingMonthYear=CertificateVerificationsView.getPassingMonthYearText();
//			System.out.println("Month and year of passing is "+passingMonthYear);
////			String actpassingMonthYear="JUNE-2023";
//			String actpassingMonthYear=	ViewCommonUtil.getExcelParameters("Month and Year of Passing");
//			System.out.println(actpassingMonthYear+"from excel111");
//			Assert.assertEquals(passingMonthYear,actpassingMonthYear);
			
			String totalCredits=CertificateVerificationsView.getTotalCreditsText();
			System.out.println("Total credits is "+totalCredits);
//			String acttotalCredits="162";
			String acttotalCredits=	ViewCommonUtil.getExcelParameters("Total Credits");
			System.out.println(acttotalCredits+"from excel");
			Assert.assertEquals(totalCredits,acttotalCredits);
			
			String cgpa=CertificateVerificationsView.getCGPAText();
			System.out.println("CGPA is "+cgpa);
//			String actcgpa="6.96 ( Six Point Nine Six) (First Class)";
			String actcgpa=	ViewCommonUtil.getExcelParameters("CGPA");
			System.out.println(actcgpa+"from excel");
			Assert.assertEquals(cgpa,actcgpa);
			
			String pci=CertificateVerificationsView.getPCIssueDateText();
			System.out.println("Provisional certificate issued date is "+ pci);
//			String actpci="12/08/2024";
			String actpci=	ViewCommonUtil.getExcelParameters("Provisional Certificate issued on");
			System.out.println(actpci+"from excel");
			Assert.assertEquals(pci,actpci);
			
			String cgci=CertificateVerificationsView.getCGCIssueDateText();
			System.out.println("Consolidated grade card issued date is "+cgci);
//			String actcgci="12/08/2024";
			String actcgci=	ViewCommonUtil.getExcelParameters("Consolidated Grade Card issued on");
			System.out.println(actcgci+"from excel");
			Assert.assertEquals(cgci,actcgci);
			
			String dci=CertificateVerificationsView.getDCCIssueDateText();
			System.out.println("Degree certificate issued date is "+dci);
//			String actdci="12/08/2024";
			String actdci=	ViewCommonUtil.getExcelParameters("Degree Certificate issued on");
			System.out.println(actdci+"from excel");
			Assert.assertEquals(dci,actdci);
			
			CertificateVerificationsView.checkAnotherStudent();
			details = "certificate verification done for a student";
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

			String fileName = System.getProperty("user.dir") + "/target/CertificateVerifications_" + dtf.format(now) + ".html";
			File newFile = new File(fileName);

			// Renaming the report with new name

			System.out.println(oldFile.renameTo(newFile));

			// Opening the report
			Desktop.getDesktop().browse(new File(fileName).toURI());
		}
		
		@DataProvider(name ="ssa")
		public Object[][] getdata() throws EncryptedDocumentException, IOException
		{
			System.out.println("dataprovider");
			FileInputStream fis=new FileInputStream("/home/u1780/MainProject/KTU_AutomationTestNG/Test_Data/CertificateVerificationData.xlsx");
			Workbook wb=WorkbookFactory.create(fis);
			Sheet sh=wb.getSheet("Data Incompleted status");
			int numofrows=sh.getLastRowNum();
			System.out.println(numofrows);
			int numofcols=sh.getRow(0).getLastCellNum();
			System.out.println(numofcols);
			Object value[][]=new Object[numofrows][numofcols];
			
			for(int i=0;i<numofrows;i++)
			{
				for(int j=0;j<numofcols;j++)
				{
					DataFormatter df=new DataFormatter();
					value[i][j]=df.formatCellValue(sh.getRow(i+1).getCell(j));
				}
			}
			wb.close();
			fis.close();
			return value;
		}
		@DataProvider(name ="ssb")
		public Object[][] getdata2() throws EncryptedDocumentException, IOException
		{
			System.out.println("dataprovider");
			FileInputStream fis=new FileInputStream("/home/u1780/MainProject/KTU_AutomationTestNG/Test_Data/CertificateVerificationData.xlsx");
			Workbook wb=WorkbookFactory.create(fis);
			Sheet sh=wb.getSheet("Data Completed status");
			int numofrows=sh.getLastRowNum();
			System.out.println(numofrows);
			int numofcols=sh.getRow(0).getLastCellNum();
			System.out.println(numofcols);
			Object value[][]=new Object[numofrows][numofcols];
			
			for(int i=0;i<numofrows;i++)
			{
				for(int j=0;j<numofcols;j++)
				{
					DataFormatter df=new DataFormatter();
					value[i][j]=df.formatCellValue(sh.getRow(i+1).getCell(j));
				}
			}
			wb.close();
			fis.close();
			return value;
		}
		
}
