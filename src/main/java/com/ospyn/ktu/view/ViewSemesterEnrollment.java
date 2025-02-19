package com.ospyn.ktu.view;

import java.awt.Robot;
import java.util.List;

import org.apache.tools.ant.taskdefs.Sleep;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ospyn.ktu.util.SeleniumBase;
import com.ospyn.ktu.util.ViewCommonUtil;

public class ViewSemesterEnrollment extends SeleniumBase{

	Robot robot;


	public ViewSemesterEnrollment(WebDriver driver)throws Exception {

		super(driver);
		ViewCommonUtil.readFromExcel("PARAMETER_LISTING.xlsx","CommonSheet");

	}



	public void loginasCollegeAdmin() throws Exception {
		
		ViewCommonUtil.logIn("College admin user name", "Password");

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
	public void clickStudentModule() throws InterruptedException {
		ViewCommonUtil.click("//a[text()='Student']");
		Thread.sleep(800);
	}
	public void clickStudentSemesterEnrollment() throws InterruptedException {

		ViewCommonUtil.click("//a[text()='Semester Enrollment']");
		Thread.sleep(800);		
	}
	public void addFiltersintheSemesterEnrollmentPage() throws Exception {

		ViewCommonUtil.selectDropDownItem("Academic year", "//select[@id='academicYearId']");

		ViewCommonUtil.selectDropDownItem("Program", "//select[@id='programId']");

		ViewCommonUtil.selectDropDownItem("Program Type", "//select[@id='programType']");

	}
	public void clickSearchButton() throws Exception {

		ViewCommonUtil.click("//button[@id='transferSearchForm_search']");
	}
	public void selectingViewBranchesButton() {

		String semester =ViewCommonUtil.getExcelParameters("Semester");
		System.out.println(semester);
		ViewCommonUtil.click("//*[text()='To Semester : "+semester+"']//following :: a[1]");
	}
	public void enrollingStudents() throws InterruptedException {

		List<WebElement> element =driver.findElements(By.xpath("//a[@class='btn btn-xs btn-info pull-right']"));
		System.out.println(element.size());

		for(int i=4;i<=element.size();i++) {
			
				ViewCommonUtil.click("(//a[@class='btn btn-xs btn-info pull-right'])["+i+"]");
				Thread.sleep(1250);
								
				WebElement save = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='studentEnrollmentForm_save']")));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", save);

				
				ViewCommonUtil.click("//button[@id='studentEnrollmentForm_save']");

				ViewCommonUtil.click("(//button[@id='confirm'])[2]");

				ViewCommonUtil.click("//button[@id='studentEnrollmentForm_verify']");

				ViewCommonUtil.click("(//button[@id='confirm'])[2]");

				ViewCommonUtil.click("//button[@id='studentEnrollmentForm_process']");

				ViewCommonUtil.click("(//button[@id='confirm'])[2]");
				Thread.sleep(2000);

				try {
					ViewCommonUtil.click("//a[@id='back']");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		



		}
	}






}























