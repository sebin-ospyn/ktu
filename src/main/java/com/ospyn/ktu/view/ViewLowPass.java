package com.ospyn.ktu.view;

import org.openqa.selenium.WebDriver;

import com.ospyn.ktu.util.SeleniumBase;
import com.ospyn.ktu.util.ViewCommonUtil;

public class ViewLowPass extends SeleniumBase {
	public ViewLowPass (WebDriver driver) throws Exception
	{
		super(driver);
		ViewCommonUtil.readFromExcel("PARAMETER_LISTING.xlsx","LowPass");
	}
	public void loginasAdExam() throws Exception
	{
		ViewCommonUtil.logIn("LoginAsAdexam","Password");
	}
	
	public void loginasStudent() throws Exception
	{
		ViewCommonUtil.logIn("Student", "Password");
	}
}
