package com.ospyn.ktu.view;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ospyn.ktu.util.SeleniumBase;
import com.ospyn.ktu.util.ViewCommonUtil;

public class ViewResultCorrection1 extends SeleniumBase {

	public ViewResultCorrection1(WebDriver driver) throws Exception 
	{
		super(driver);
		ViewCommonUtil.readFromExcel("PARAMETER_LISTING.xlsx","ResultCorrection");
	}
	@FindBy (xpath = "//input[@id='login-username']")
	WebElement txtUsername;
	@FindBy (xpath ="//input[@id='login-password']" )
	WebElement txtPassword;
	@FindBy (xpath = "//input[@id='btn-login']")
	WebElement btnLogin;
	@FindBy(xpath="//a[normalize-space()='Result']")
	WebElement btnResult;
	@FindBy (xpath ="//select[@id='academicYear']")
	WebElement selAcademicYear;
	@FindBy (xpath = "//select[@id='programId']")
	WebElement selProgram;
	
	public void login() throws Exception
	{
		txtUsername.sendKeys(ViewCommonUtil.getExcelParameters("LoginAsAdexam"));
		txtPassword.sendKeys(ViewCommonUtil.getExcelParameters("Password"));
		btnLogin.click();
	}
	public void CheckMarkBefore () throws Exception
	{
		btnResult.click();
		ViewCommonUtil.selectDropdownOptionFromExcel(selAcademicYear,"Academic Year");
		ViewCommonUtil.selectDropdownOptionFromExcel(selProgram,"Program");
		

	}
	
	

}
