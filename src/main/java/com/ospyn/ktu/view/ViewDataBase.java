package com.ospyn.ktu.view;

import org.openqa.selenium.WebDriver;

import com.ospyn.ktu.util.SeleniumBase;
import com.ospyn.ktu.util.ViewCommonUtil;

public class ViewDataBase extends SeleniumBase {
	public ViewDataBase(WebDriver driver)throws Exception 
	{
		super(driver);
//		ViewCommonUtil.readFromExcel("PARAMETER_LISTING.xlsx","LowPass");
	}
	public void loginasStudent() throws Exception
	{
		ViewCommonUtil.logIn("Student", "Password");
	}

}
