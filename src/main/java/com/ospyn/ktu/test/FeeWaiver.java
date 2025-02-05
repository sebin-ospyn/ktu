		package com.ospyn.ktu.test;
		
		import java.awt.Desktop;
		import java.io.File;
		import java.io.IOException;
		import java.text.SimpleDateFormat;
		import java.time.LocalDateTime;
		import java.time.format.DateTimeFormatter;
		import java.util.Date;
		
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.WebElement;
		import org.testng.Assert;
		import org.testng.ITestContext;
		import org.testng.ITestResult;
		import org.testng.annotations.AfterMethod;
		import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
		import org.testng.annotations.Test;
		
		import com.ospyn.ktu.util.DriverConfig;
		import com.ospyn.ktu.util.GenerateExtentReport;
		import com.ospyn.ktu.util.Screenshot;
		import com.ospyn.ktu.util.ViewCommonUtil;
		import com.ospyn.ktu.util.ViewLogin;
		import com.ospyn.ktu.view.ViewFeeWaiver;
		import com.relevantcodes.extentreports.LogStatus;
		
		public class FeeWaiver extends DriverConfig {
			
			// creating reference for Login
			static ViewLogin login;
			
			// creating reference to ViewFeeWaiver
				ViewFeeWaiver FeeWaiverView;
		
			// Creating reference for creating Extent Reports
			static GenerateExtentReport report; //= Login.report;	==>edited
		
			// Creating reference for extracting screenshots of failed test
			Screenshot screenshot;
			
			// Creating static variable for adding details to log
				static String details;
				
				// Creating reference for driver
				WebDriver driver;    
//				WebElement element;                     ==> edited
		
				// creating a variable for assigning the test name before each test
				String[] testName;
				
				 // Variable to store the current test method name
			    String currentTestMethodName;
				
				public FeeWaiver() throws Exception {
		
//					report = Login.report;              ==> edited
					screenshot = new Screenshot();
					driver = getDriver();
					FeeWaiverView =new ViewFeeWaiver(driver);
					ViewCommonUtil.readFromExcel("PARAMETER_LISTING.xlsx","FeeWaiver");

				}
				//     ==>                                This annotation edited
				@BeforeSuite
			    public void initializeReport() {
// - next line					
					if(report==null)
			        // Initialize the ExtentReports object with a default name (will be updated later)
			        report = new GenerateExtentReport();
			    }
				
				@BeforeTest
				public void getTestName(final ITestContext testContext) {
		
					String test = testContext.getName(); // gets the test name assigned in the xml file
					testName = test.split("-");
				}
				@Test
				public void loginAsKtusupport() throws Exception
				{
//-						if (report != null) {
//					        if (testName.length > 1) {
//					            report.beginTest("<b>" + testName[0] + "<br />" + testName[1] + "</b><br /><br /> Performing main action1 ");
//					        } else {
//					            report.beginTest("<b>" + testName[0] + "</b><br /><br />Perform Login as ktusupport02");
//					        }
//					    } else {
//					        System.out.println("Report object is null.");
//-	next line also				    }
					report.beginTest("<b>" + testName[0] + "</b><br /><br /> Perform Login as ktusupport02");
					//starts from here	
						FeeWaiverView.LoginAsktusupport02();
					}
//				
				@Test
				public void addAdditionalFeeCollection() throws Exception
				{
//						if (report != null) {
//					        if (testName.length > 1) {
//					            report.beginTest("<b>" + testName[0] + "<br />" + testName[1] + "</b><br /><br /> Performing main action2 ");
//					        } else {
//					            report.beginTest("<b>" + testName[0] + "</b><br /><br /> Adding Additional Fee Collection ");
//					        }
//					    } else {
//					        System.out.println("Report object is null.");
//					    }
					report.beginTest("<b>" + testName[0] + "</b><br /><br /> Adding Additional Fee Collection");
					//starts from here	
						FeeWaiverView.addAdditionalFeeCollection();
					}
				@Test
				public void logout() throws Exception
				{
					Thread.sleep(1500);//						if (report != null) {
//					        if (testName.length > 1) {
//					            report.beginTest("<b>" + testName[0] + "<br />" + testName[1] + "</b><br /><br /> Performing main action2 ");
//					        } else {
//					            report.beginTest("<b>" + testName[0] + "</b><br /><br /> Perform logout");
//					        }
//					    } else {
//					        System.out.println("Report object is null.");
//					    }
						report.beginTest("<b>" + testName[0] + "</b><br /><br /> Perform logout");
					//starts from here	
						Thread.sleep(1500);
						ViewCommonUtil.logOut();
						Thread.sleep(1500);
					}
				@Test
				public void loginAsInstitue() throws Exception
				{
//						if (report != null) {
//					        if (testName.length > 1) {
//					            report.beginTest("<b>" + testName[0] + "<br />" + testName[1] + "</b><br /><br /> Performing main action2 ");
//					        } else {
//					            report.beginTest("<b>" + testName[0] + "</b><br /><br /> Perorm Login as Institute");
//					        }
//					    } else {
//					        System.out.println("Report object is null.");
//					    }
						 report.beginTest("<b>" + testName[0] + "</b><br /><br /> Perform Login as Institute");
					//starts from here	
						FeeWaiverView.loginasInstitute();
					}
				@Test
				public void verifyAmtAndDescription() throws Exception
				{
//						if (report != null) {
//					        if (testName.length > 1) {
//					            report.beginTest("<b>" + testName[0] + "<br />" + testName[1] + "</b><br /><br /> Performing main action2 ");
//					        } else {
//					            report.beginTest("<b>" + testName[0] + "</b><br /><br /> Verifying Amount and Description college login");
//					        }
//					    } else {
//					        System.out.println("Report object is null.");
//					    }
					report.beginTest("<b>" + testName[0] + "</b><br /><br /> Verifying Amount and Description (College Login)");
					//starts from here	
						String desc = FeeWaiverView.verificationDescriptionCollegelogin();
						String desc1 = ViewCommonUtil.getExcelParameters("Description for assertion");
						Assert.assertEquals(desc, desc1);
						
						String amt=FeeWaiverView.verificationAmtCollegelogin();
						String amt2=ViewCommonUtil.getExcelParameters("Amount for assertion");
						Assert.assertEquals(amt, amt2);
					}
				//fee waiver or
				@Test
				public void AddFeeWaiver() throws Exception
				{
//						if (report != null) {
//					        if (testName.length > 1) {
//					            report.beginTest("<b>" + testName[0] + "<br />" + testName[1] + "</b><br /><br /> Performing main action2 ");
//					        } else {
//					            report.beginTest("<b>" + testName[0] + "</b><br /><br /> Perorm Login as Institute");
//					        }
//					    } else {
//					        System.out.println("Report object is null.");
//					    }
						 report.beginTest("<b>" + testName[0] + "</b><br /><br /> Perform Login as Institute");
					//starts from here	
						FeeWaiverView.addFeeWaiver();
					}
				
				@AfterMethod
				// writing the status to the report
				public void getResult(ITestResult result) {
					 // Set the current test method name
			        currentTestMethodName = result.getMethod().getMethodName();
					
					
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
//						report.setLog(LogStatus.PASS, details);   =============> edited
						report.setLog(LogStatus.PASS,"Test passed successfully.");
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
		
					String fileName = System.getProperty("user.dir") + "/target/SemesterEnrollment_" + dtf.format(now) + ".html";
					File newFile = new File(fileName);
		
					// Renaming the report with new name
		
					System.out.println(oldFile.renameTo(newFile));
					
					// Opening the report
					Desktop.getDesktop().browse(new File(fileName).toURI());
				}
		
		}
