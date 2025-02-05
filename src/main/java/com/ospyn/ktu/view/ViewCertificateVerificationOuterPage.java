package com.ospyn.ktu.view;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ViewCertificateVerificationOuterPage extends BasePage {
	
	public ViewCertificateVerificationOuterPage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy (xpath = "//input[@id='formRegisterNumber']")
	WebElement RegNumtextbox;
	@FindBy (xpath ="//input[@id='formDob']")
	WebElement DOBtextbox;
	@FindBy (xpath = "//span[normalize-space()='Search']")
	WebElement SearchBtn;
	@FindBy (xpath = "//span[text()='No records found for the provided Register Number and Date of Birth.']")
	WebElement valMessage;
	
	public void setRegisterNumber(String RegNO)
	{
		RegNumtextbox.sendKeys(RegNO);
	}
	public void setDOB(String dob)
	{
		DOBtextbox.sendKeys(dob);
	}
	public void clickSearch()
	{
		SearchBtn.click();
	}
	public void verifyErrorMessage(String exptext)
	{
		String acttext = valMessage.getText();
		System.out.println(acttext);
		Assert.assertEquals(acttext, exptext, "Error message mismatch!");
		System.out.println("pass");
	}
}

