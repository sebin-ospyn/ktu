package com.ospyn.ktu.view;

import java.awt.Robot;
import java.util.List;

import javax.swing.text.Document;

import org.apache.tools.ant.taskdefs.Sleep;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.ospyn.ktu.util.SeleniumBase;
import com.ospyn.ktu.util.ViewCommonUtil;

public class ViewRevaluation extends SeleniumBase{



	public ViewRevaluation(WebDriver driver)throws Exception {

		super(driver);
		ViewCommonUtil.readFromExcel("PARAMETER_LISTING.xlsx","Revaluation");
	}


	public static void loginasUniversity() throws Exception {

		ViewCommonUtil.logIn("Login_university", "Password");



		/*
		 * //passing user name
		 * ViewCommonUtil.enterTextinTextField("College admin user name",
		 * "//input[@id='login-username']");
		 * 
		 * //passing password ViewCommonUtil.enterTextinTextField("Password",
		 * "//input[@id='login-password']");
		 * 
		 * //click login ViewCommonUtil. click("//input[@id='btn-login']");
		 */

	}
	public static void loginasStudent() throws Exception {
		ViewCommonUtil.logIn("Login_student", "Password");
	}
	public static void loginasAdexam() throws Exception {
		ViewCommonUtil.logIn("Login_adexam", "Password");
	}
	public static void loginasfaculty() throws Exception {
		ViewCommonUtil.logIn("Login_faculty", "Password");
	}


	public void clickExam()
	{
		WebElement checkNext = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Exam']")));
		checkNext.click();
	}

	



	public  static void studentRevaluationRegistration() throws Exception {
		ViewCommonUtil.click("//a[text()='Exam']");
		ViewCommonUtil.selectDropDownItem("Academic Year", "//select[@name='academicYear']");
		ViewCommonUtil.selectDropDownItem("Exam Type","//select[@id='searchForm_examType']");
		Thread.sleep(2000);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		
		String examdef="B.Tech S3 (R,S) Exam Dec 2023 (2019 scheme)";
		String xpathExpression = "//*[text()='" + examdef + "']/following::a[4]";
		WebElement element = driver.findElement(By.xpath(xpathExpression));
		element.click();
		Thread.sleep(5000);
		
		
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		String coursenameWithCode="FLUID MECHANICS AND HYDRAULICS (CET203)";
		String xpathExpress = "//td[normalize-space(text())='"+coursenameWithCode+"']/following::input[1]";
		WebElement elem=driver.findElement(By.xpath(xpathExpress));
		elem.click();
		Thread.sleep(5000);
		ViewCommonUtil.click("//button[@id='submitProceedToPay']");
		Thread.sleep(2000);
		ViewCommonUtil.acceptAlert();
		Thread.sleep(2000);
		ViewCommonUtil.click("//input[@id='paymentGateWay2']");
		Thread.sleep(2000);
		ViewCommonUtil.click("//button[@id='proceedToPayForm_submit']");
		Thread.sleep(5000);
		String confirmationMsg = "Your Payment is successful";
		String msg = driver.findElement(By.xpath("//h3[@class='text-center']")).getText();
		Assert.assertEquals(msg, confirmationMsg);
		

		// String s=ViewCommonUtil.readFromExcel("PARAMETER_LISTING.xlsx","Revaluation");
		//*[text()='B.Tech S2 (R,S) Exam May 2024 (2019 Scheme)']/following::a[3]

	}
	
//	public  static void studentRevaluationRegistrationMultiple() throws Exception {
//		ViewCommonUtil.click("//a[text()='Exam']");
//		ViewCommonUtil.selectDropDownItem("Academic Year", "//select[@name='academicYear']");
//		ViewCommonUtil.selectDropDownItem("Exam Type","//select[@id='searchForm_examType']");
//		Thread.sleep(2000);
//		
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//		
//		
//		String examdef="B.Tech S3 (R,S) Exam Dec 2023 (2019 scheme)";
//		String xpathExpression = "//*[text()='" + examdef + "']/following::a[4]";
//		WebElement element = driver.findElement(By.xpath(xpathExpression));
//		element.click();
//		Thread.sleep(5000);
//		
//		
//		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//
//		String coursenameWithCode="MECHANICS OF SOLIDS (CET201)";
//		String xpathExpress = "//td[normalize-space(text())='"+coursenameWithCode+"']/following::input[1]";
//		WebElement elem=driver.findElement(By.xpath(xpathExpress));
//		elem.click();
//		Thread.sleep(5000);
//		ViewCommonUtil.click("//button[@id='submitProceedToPay']");
//		Thread.sleep(2000);
//		ViewCommonUtil.acceptAlert();
//		Thread.sleep(2000);
//		ViewCommonUtil.click("//input[@id='paymentGateWay2']");
//		Thread.sleep(2000);
//		ViewCommonUtil.click("//button[@id='proceedToPayForm_submit']");
//		Thread.sleep(5000);
//		String confirmationMsg = "Your Payment is successful";
//		String msg = driver.findElement(By.xpath("//h3[@class='text-center']")).getText();
//		Assert.assertEquals(msg, confirmationMsg);
//		
//
//		// String s=ViewCommonUtil.readFromExcel("PARAMETER_LISTING.xlsx","Revaluation");
//		//*[text()='B.Tech S2 (R,S) Exam May 2024 (2019 Scheme)']/following::a[3]
//
//	}
	public static void RevaluationPacketMovement()
	{
		ViewCommonUtil.click("//a[text()='Revaluation']");
		
	}
	
	public static void RevaluationCampCreation() throws Exception
	{
		ViewCommonUtil.click("//a[text()='Valuation']");
		ViewCommonUtil.click("//a[text()='Camp Bulk Cloning']");
		ViewCommonUtil.selectDropDownItem("Academic Year", "//select[@name='academicYearId']");
		ViewCommonUtil.selectDropDownItem("Program","//select[@name='programId']");
		ViewCommonUtil.selectDropDownItem("Exam definition name", "//select[@id='examDefinition']");
		ViewCommonUtil.click("//button[@id='searchForm_search']");
		ViewCommonUtil.click("//input[@id='check']");
		ViewCommonUtil.click("//button[@name='cloneBtn']");
		Thread.sleep(1000);
		ViewCommonUtil.selectDropDownItem("Valuation Type","//select[@id='cloneValuationType']");
		Thread.sleep(1000);
		ViewCommonUtil.selectDropDownItem("Exam definition name","//select[@id='cloneExamDefinition']");
		ViewCommonUtil.selectDropDownItem("Month","//select[@id='month']");
		ViewCommonUtil.selectDropDownItem("Year","//select[@id='year']");
		ViewCommonUtil.click("//input[@id='toDate']");
		ViewCommonUtil.click("//td[@class='today active day']/following-sibling::td");
		ViewCommonUtil.click("//input[@id='exmMemberChk']");
		ViewCommonUtil.click("//input[@id='valMemberChk']");

		ViewCommonUtil.click("//button[@id='saveButton']");
		Thread.sleep(1000);
		ViewCommonUtil.acceptAlert();
		Thread.sleep(1000);
		ViewCommonUtil.click("//input[@id='changeStatusChkBoxId']");
		ViewCommonUtil.click("//button[@id='changeStatusBtnId']");
		ViewCommonUtil.acceptAlert();
	}


	public static void StudentRevaluationRegistrationMultiple(String username, String coursecode) throws Throwable
	{
		driver.findElement(By.xpath("//input[@id='login-username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='login-password']")).sendKeys(ViewCommonUtil.getExcelParameters("Password"));
		ViewCommonUtil.click("//input[@id='btn-login']");
		
		ViewCommonUtil.click("//a[text()='Exam']");
		ViewCommonUtil.selectDropDownItem("Academic Year", "//select[@name='academicYear']");
		ViewCommonUtil.selectDropDownItem("Exam Type","//select[@id='searchForm_examType']");
		Thread.sleep(1000);
		
		ViewCommonUtil.scrollToBottom();
		
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
//		String examdef="B.Tech S3 (R,S) Exam Dec 2023 (2019 scheme)";
		String examdef=ViewCommonUtil.getExcelParameters("Exam definition name");
		String xpathExpression = "//*[text()='" + examdef + "']/following::a[4]";
		WebElement element = driver.findElement(By.xpath(xpathExpression));
		element.click();
		Thread.sleep(1000);
		
		ViewCommonUtil.scrollToBottom();
//		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

//		String coursenameWithCode="FLUID MECHANICS AND HYDRAULICS (CET203)";
		String xpathExpress = "//td[normalize-space(text())='"+coursecode+"']/following::input[1]";
		WebElement elem=driver.findElement(By.xpath(xpathExpress));
		elem.click();
		Thread.sleep(1000);
		ViewCommonUtil.click("//button[@id='submitProceedToPay']");
		Thread.sleep(1000);
		ViewCommonUtil.acceptAlert();
		Thread.sleep(1000);
		ViewCommonUtil.click("//input[@id='paymentGateWay2']");
		Thread.sleep(1000);
		ViewCommonUtil.click("//button[@id='proceedToPayForm_submit']");
		Thread.sleep(1000);
		String confirmationMsg = "Your Payment is successful";
		String msg = driver.findElement(By.xpath("//h3[@class='text-center']")).getText();
		Assert.assertEquals(msg, confirmationMsg);
	}
	

	//	public void clickStudentModule() throws InterruptedException {
	//		ViewCommonUtil.click("//a[text()='Student']");
	//		Thread.sleep(800);
	//	}
	//	public void clickStudentSemesterEnrollment() throws InterruptedException {
	//
	//		ViewCommonUtil.click("//a[text()='Semester Enrollment']");
	//		Thread.sleep(800);		
	//	}
	//	public void addFiltersintheSemesterEnrollmentPage() throws Exception {
	//
	//		ViewCommonUtil.selectDropDownItem("Academic year", "//select[@id='academicYearId']");
	//
	//		ViewCommonUtil.selectDropDownItem("Program", "//select[@id='programId']");
	//
	//		ViewCommonUtil.selectDropDownItem("Program Type", "//select[@id='programType']");
	//
	//	}
	//	public void clickSearchButton() throws Exception {
	//
	//		ViewCommonUtil.click("//button[@id='transferSearchForm_search']");
	//	}
	//	public void selectingViewBranchesButton() {
	//
	//		String semester =ViewCommonUtil.getExcelParameters("Semester");
	//		System.out.println(semester);
	//		ViewCommonUtil.click("//*[text()='To Semester : "+semester+"']//following :: a[1]");
	//	}
	//	public void enrollingStudents() throws InterruptedException {
	//
	//		List<WebElement> element =driver.findElements(By.xpath("//a[@class='btn btn-xs btn-info pull-right']"));
	//		System.out.println(element.size());
	//
	//		for(int i=4;i<=element.size();i++) {
	//			
	//				ViewCommonUtil.click("(//a[@class='btn btn-xs btn-info pull-right'])["+i+"]");
	//				Thread.sleep(1250);
	//								
	//				WebElement save = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='studentEnrollmentForm_save']")));
	//				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", save);
	//
	//				
	//				ViewCommonUtil.click("//button[@id='studentEnrollmentForm_save']");
	//
	//				ViewCommonUtil.click("(//button[@id='confirm'])[2]");
	//
	//				ViewCommonUtil.click("//button[@id='studentEnrollmentForm_verify']");
	//
	//				ViewCommonUtil.click("(//button[@id='confirm'])[2]");
	//
	//				ViewCommonUtil.click("//button[@id='studentEnrollmentForm_process']");
	//
	//				ViewCommonUtil.click("(//button[@id='confirm'])[2]");
	//				Thread.sleep(1000);
	//
	//				ViewCommonUtil.click("//a[@id='back']");
	//		
	//
	//
	//
	//		}
	//	}


}
