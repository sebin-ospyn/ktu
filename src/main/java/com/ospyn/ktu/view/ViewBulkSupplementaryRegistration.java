//package com.ospyn.ktu.view;
//
//import java.awt.AWTException;
//import java.awt.Robot;
//import java.awt.event.KeyEvent;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import org.apache.commons.lang3.StringUtils;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.testng.Assert;
//
//import com.ospyn.ktu.util.SeleniumBase;
//
//public class ViewBulkSupplementaryRegistration extends SeleniumBase {
//
//	public ViewBulkSupplementaryRegistration(WebDriver driver)
//    {
//		//initializing the driver
//		super(driver);
//    }
//
//	static ViewSupplymentaryCourseReg bulkSupplyRegistration;
//
//	@FindBy(xpath = "//*[@href='/university/eu/acd/settings/courseListing.htm']")
//	WebElement academicModule;
//
//	@FindBy(xpath = "//*[text()='Reports']")
////	/university/eu/reports/reportListing.htm?moduleId=0nzMyEoVq5qd1qs%2BRBzMDMR0LNq7KirxN9nlBG3gurU%3D ......
//	WebElement Reports;
//
//	@FindBy(xpath = "(//div[@class='col-sm-12']//li//a)[5]")
//	WebElement failedReport;
//
//	@FindBy(xpath = "//*[@id='joinedBatchYearId']")
//	WebElement batchYear;
//
//	@FindBy(xpath = "//*[@id='programId']")
//	WebElement program;
//
//	@FindBy(xpath = "//*[@id='programType']")
//	WebElement progType;
//
//	@FindBy(xpath = "//*[@id='regulationId']")
//	WebElement prgmRegulation;
//
//	@FindBy(xpath = "//*[@id='schemeId']")
//	WebElement prgmScheme;
//
//	@FindBy(xpath = "//*[@id='semester']")
//	WebElement prgmSem;
//
//	@FindBy(xpath = "//*[@id='institution']")
//	WebElement prgmInstitution;
//
//	@FindBy(xpath = "//*[@id='course']")
//	WebElement prgmCourse;
//
//	@FindBy(xpath = "//*[@id='gradeType_chosen']")
//	WebElement prgmGrade;
//
//	@FindBy(xpath = "//*[@id='studentStatus_chosen']")
//	WebElement studStatus;
//
//
//
//	@FindBy(xpath = "//a[@href='/university/logout.htm']")
//	WebElement Logout;
//
//
//
//	static String[] studentData;
//	public static float expectedFee=0.0f;
//
//
//
//
//	public static Object[] getStudentData() {
//		return studentData;
//	}
//
//
//
//	public WebElement getLogout() {
//		return Logout;
//	}
//
//
//
//	public void setLogout(WebElement logout) {
//		Logout = logout;
//	}
//
//
//
//	public static void setStudentData(String[] studentData) {
//		ViewBulkSupplementaryRegistration.studentData = studentData;
//	}
//
//	public WebElement getAcademicModule() {
//		return academicModule;
//	}
//
//	public WebElement getReports() {
//		return Reports;
//	}
//
//	public void setReports(WebElement reports) {
//		Reports = reports;
//	}
//
//	public WebElement getFailedReport() {
//		return failedReport;
//	}
//
//	public void setFailedReport(WebElement failedReport) {
//		this.failedReport = failedReport;
//	}
//
//	public void setAcademicModule(WebElement academicModule) {
//		this.academicModule = academicModule;
//	}
//
//
//	public void searchReport(String params) throws AWTException, InterruptedException {
//
//		Robot robot = new Robot();
//
//
//		//Parameters
//		List<String> parameters = new ArrayList<>();
//		parameters = Arrays.asList(params.split(","));
//
//		Select batch = new Select(batchYear);
//		System.out.println(parameters.get(0));
//		batch.selectByVisibleText(parameters.get(0));
//
//		Select prgm = new Select(program);
//		System.out.println(parameters.get(1));
//		prgm.selectByVisibleText(parameters.get(1));
//
//		Select prgmType = new Select(progType);
//		System.out.println(parameters.get(2));
//		prgmType.selectByVisibleText(parameters.get(2));
//
//		Select regulation = new Select(prgmRegulation);
//		System.out.println(parameters.get(3));
//		regulation.selectByVisibleText(parameters.get(3));
//
//		Select scheme = new Select(prgmScheme);
//		System.out.println(parameters.get(4));
//		scheme.selectByVisibleText(parameters.get(4));
//
//		Select semester = new Select(prgmSem);
//		System.out.println(parameters.get(5));
//		semester.selectByVisibleText(parameters.get(5));
//
//		prgmInstitution.sendKeys(parameters.get(6));
//		Thread.sleep(1000);
//		robot.keyPress(KeyEvent.VK_ENTER);
//	    robot.keyRelease(KeyEvent.VK_ENTER);
//
//
//
//		prgmCourse.sendKeys(parameters.get(7));
//		Thread.sleep(1000);
//		robot.keyPress(KeyEvent.VK_ENTER);
//	    robot.keyRelease(KeyEvent.VK_ENTER);
//
//	    WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Select Some Options'])[1]")));
//	    element.click();
//	    Thread.sleep(1000);
//		System.out.println(parameters.get(8));
//        element.sendKeys(parameters.get(8));
//        robot.keyPress(KeyEvent.VK_ENTER);
//	    robot.keyRelease(KeyEvent.VK_ENTER);
//
//	    WebElement studentStatus=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='Select Some Options'])[2]")));
//	    studentStatus.click();
//	    Thread.sleep(1000);
//		System.out.println(parameters.get(9));
//		studentStatus.sendKeys(parameters.get(9));
//        robot.keyPress(KeyEvent.VK_ENTER);
//	    robot.keyRelease(KeyEvent.VK_ENTER);
//
//	    WebElement searchButton = driver.findElement(By.xpath("//*[@id='ineligibleStudentListingFilterForm_search']"));
//	    searchButton.click();
//
//
//	}
//
//
//	public void readingStudentData() {
//
//		List<WebElement> studentListing = driver.findElements(By.xpath("//*[@id='ineligibleStudentListingTable']/tbody/tr"));
//
//		int listSize = studentListing.size();
//
//		studentData=new String[listSize];
//
//		for (int i=0 ; i<listSize ; i++) {
//
//			studentData[i] = driver.findElement(By.xpath("//*[@id='ineligibleStudentListingTable']/tbody/tr["+(i+1)+"]/td[2]")).getText();
//			System.out.println("reg"+studentData[i]);
//		}
//	}
//
//	public int studentExamRegistration() throws InterruptedException {
//
//
//		    List<WebElement> courseList = driver.findElements(By.xpath("//*[@class='table table-striped table-bordered table-hover']/tbody/tr"));
//
//		    int listSize = courseList.size();
//
//		    System.out.print("size"+listSize);
//		    int skip=0;
//
//		    for(int i=1 ; i<=listSize ; i++) {
//
//
//		    	String appearingChance=driver.findElement(By.xpath("//*[@class='table table-striped table-bordered table-hover']/tbody/tr["+(i+1)+"]/td[4]")).getText();
//		    	int appearingChanceValue = Integer.parseInt(appearingChance);
//			    System.out.print("appearingChanceValue"+appearingChanceValue);
//
//		    	if(appearingChanceValue>1) {
//
//		    	String total=driver.findElement(By.xpath("//*[@id='totalVal']")).getText();
//				String totalFee = StringUtils.substringAfter(total, "INR");
//				System.out.println("totalFee"+totalFee);
//				float totalFeeFloat=Float.parseFloat(totalFee);
//
//				//taking the course fee and converting it into float
//				String courseFeeValue=driver.findElement(By.xpath("//*[@class='table table-striped table-bordered table-hover']/tbody/tr["+i+"]/td[6]")).getText();
//				String courseFee = StringUtils.substringAfter(courseFeeValue, "INR");
//				System.out.println("courseFee"+courseFee);
//		        float courseFeeFloat=Float.parseFloat(courseFee);
//
//		        //calculating the expected fee by adding total and course fee
//				expectedFee=totalFeeFloat+courseFeeFloat;
//				System.out.println("expectedFee"+expectedFee);
//
//
//				WebElement courseSelect=driver.findElement(By.xpath("(//*[@id='courseSel'])["+i+"]"));
//				courseSelect.click();
//
//				//taking the total fee after course select
//				String totalValue=driver.findElement(By.xpath("//*[@id='totalVal']")).getText();
//				String actualFee = StringUtils.substringAfter(totalValue, "INR");
//				float actualFeeFloat=Float.parseFloat(actualFee);
//				System.out.println("actualFeeFloat"+actualFeeFloat);
//
//				//checking whether actual and expected fee are correct
//				Assert.assertEquals(actualFeeFloat, expectedFee);
//
//		    	}
//				else
//				{
//				skip=1;
//				}
//
//	}
//		   return skip;
//
//	}
//
//	public void branchSubmission(String params) {
//
//		//Parameters
//		List<String> parameters = new ArrayList<>();
//		parameters = Arrays.asList(params.split(","));
//
//		WebElement viewRegisterButton=driver.findElement(By.xpath("//*[contains(text(),'"+parameters.get(4)+"')]/..//*[text()='View/Register Exam Courses']"));
//		viewRegisterButton.click();
//
//		WebElement registerationSubmissionButton=driver.findElement(By.xpath("//*[contains(text(),'"+parameters.get(4)+"')]/..//*[text()='View/Register Exam Courses']/..//*[text()='Registration Submission']"));
//		registerationSubmissionButton.click();
//
//        List<WebElement> branchList = driver.findElements(By.xpath("//b[contains(text(),'Branch/Stream')]"));
//
//		int branchCount = branchList.size();
//		System.out.println("count"+branchCount);
//
//		for(int i=0;i<branchCount;i++)
//
//		{
//			driver.findElement(By.xpath("//input[@id='branch"+i+"']")).click();
//		}
//
//		driver.findElement(By.xpath("//button[@id='branchListingForm_Submit']")).click();
//
//
//
//
//	}
//
//
//}
