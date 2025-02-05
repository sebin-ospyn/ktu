package com.ospyn.ktu.util;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ViewLogin extends SeleniumBase {

	@FindBy(xpath = "//input[@id='login-username'][@name='username']")
	WebElement username;

	@FindBy(xpath = "//input[@id='login-password'][@name='password']")
	WebElement password;

	@FindBy(xpath = "//*[@id='btn-login']")
	WebElement loginButton;

	public ViewLogin(WebDriver driver) {

		super(driver);

	}

	public WebElement getUsername() {

		return getElementWithWait(username);

	}

	public void setUsername(WebElement username) {

		this.username = username;

	}

	public WebElement getPassword() {

		return getElementWithWait(password);

	}

	public void setPassword(WebElement password) {

		this.password = password;

	}

	public WebElement getLoginButton() {

		return getElementWithWait(loginButton);

	}

	public void setLoginButton(WebElement loginButton) {

		this.loginButton = loginButton;

	}

	public void logIn(String userName, String password) throws InterruptedException 
	{

		getUsername().sendKeys(userName);
		try
		{
			Thread.sleep(1000);


			getPassword().sendKeys(password);
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}
	public void clickLogin()
	{
		try
		{
			getLoginButton().click();
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}
	public String getStatus()
	{
		String status="";
		try
		{
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//a[contains(text(),'Welcome')]")));
			if(element.isDisplayed())
				status="Success";
			else
				status="Failure";
		}
		catch(Exception e)
		{

		}
		return status;
	}
	public void logOut()
	{
//		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//a[@href='/university/logout.htm']")));
//		
		ViewCommonUtil.click("//a[@href='/university/logout.htm']");
	//	element.click();
	}
	public void loginWithExcel(int column)throws Exception
    {
        
        FileInputStream fs=new FileInputStream(new File(System.getProperty("user.dir")+"/Test_Data/PARAMETER_LISTING.xlsx"));;
        //Getting the workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fs);

       //Getting the sheet
        XSSFSheet sheet = workbook.getSheetAt(10);
        System.out.println("Column is "+column);
        System.out.println(sheet.getRow(1).getCell(column).getStringCellValue());
         getUsername().sendKeys(sheet.getRow(1).getCell(column).getStringCellValue());
         Thread.sleep(1000);
        try
        {
            Thread.sleep(1000);
            getPassword().sendKeys(sheet.getRow(2).getCell(column).getStringCellValue());
            Thread.sleep(1000);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        

    }



}
