package com.ospyn.ktu.view;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ospyn.ktu.util.SeleniumBase;

public class ViewCertificateVerifications extends SeleniumBase{


	public ViewCertificateVerifications(WebDriver driver)throws Exception {

		super(driver);
		//	ViewCommonUtil.readFromExcel("PARAMETER_LISTING.xlsx","FirstLevelValuation");

	}

	public void login(String regno,String psw) throws InterruptedException {
		WebElement RegisterNumTxtbx = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='formRegisterNumber']")));
		RegisterNumTxtbx.clear();
		RegisterNumTxtbx.sendKeys(regno);
		Thread.sleep(250);


		WebElement DOBTxtbx = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='formDob']")));
		DOBTxtbx.clear();
		DOBTxtbx.sendKeys(psw);
		Thread.sleep(250);

		WebElement SearchBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Search']")));
		SearchBtn.click();
		Thread.sleep(250);

		//		String ActualText= driver.findElement(By.xpath("//span[text()='No records found for the provided Register Number and Date of Birth.']")).getText();
	}

	public String validatemessage()
	{
		WebElement element3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='text-white' ]")));
		String st = element3.getText();
		return st;
	}
	public String warnMessage()
	{
		WebElement element4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-danger']/span")));
		String str= element4.getText();
		return str;
	}
	public void checkAnotherStudent()
	{
		WebElement checkNext = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Verify another certificate']")));
//		WebElement checkNext = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='aLink']")));
		checkNext.click();
	}
	//for verifying content in inner page
	public String getNameText()
	{
		WebElement Name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Name']/following-sibling::span")));
		String NameText=Name.getText();
		return NameText;
	}
	public String getRegisterNumText()
	{
		WebElement RegisterNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Register Number']/following-sibling::span")));
		String RegText=RegisterNumber.getText();
		return RegText;
	}
	public String getInstitutionText()
	{
		WebElement Institution = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Institution']/following-sibling::span")));
		String InstiText=Institution.getText();
		return InstiText;
	}
	public String getProgramText()
	{
		WebElement Program = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Program']/following-sibling::span")));
		String ProgText=Program.getText();
		return ProgText;
	}
	public String getBranchText()
	{
		
		WebElement Branch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Branch']/following-sibling::span")));
		String BranText=Branch.getText();
		return BranText;
	}
	public String getProgramDurationText()
	{
		WebElement ProgramDuration = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Duration of the Program']/following-sibling::span")));
		String ProgDurText=ProgramDuration.getText();
		return ProgDurText;
	}
	public String getModeOfStudyText()
	{
		WebElement ModeOfStudy = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Mode of Study']/following-sibling::span")));
		String ModeofStText=ModeOfStudy.getText();
		return ModeofStText;
	}
	public String getMediumOfInstructionText()
	{
		WebElement MediumOfInstruction = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Medium of Instruction']/following-sibling::span")));
		String MedOfInsText=MediumOfInstruction.getText();
		return MedOfInsText;
	}
	public String getAdmissionYearText()
	{
		WebElement AdmissionYear = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Year of Admission']/following-sibling::span")));
		String AdmissYrText=AdmissionYear.getText();
		return AdmissYrText;
	}
	public String getPassingMonthYearText()
	{
		WebElement PassingMonthYear = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Month and Year of Passing']/following-sibling::span")));
		String PassMnthYrText=PassingMonthYear.getText();
		return PassMnthYrText;
	}
	public String getTotalCreditsText()
	{
		WebElement TotalCredits = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Total Credits']/following-sibling::span")));
		String TotCredText=TotalCredits.getText();
		return TotCredText;
	}
	public String getCGPAText()
	{
		WebElement Cgpa = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='CGPA']//following-sibling::span")));
		String CgpaText=Cgpa.getText();
		return CgpaText;
	}
	public String getPCIssueDateText()
	{
		WebElement PCissue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[normalize-space()='Provisional Certificate']/following-sibling::td")));
		String PCIsseText=PCissue.getText();
		return PCIsseText;
	}
	public String getCGCIssueDateText()
	{
		WebElement CGCissue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[normalize-space()='Consolidated Grade Card']/following-sibling::td")));
		String CGCIsseText=CGCissue.getText();
		return CGCIsseText;
	}
	public String getDCCIssueDateText()
	{
		WebElement DCissue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[normalize-space()='Degree Certificate']/following-sibling::td")));
		String DCIsseText=DCissue.getText();
		return DCIsseText;
	}
	
}
