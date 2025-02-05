package com.ospyn.ktu.view;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewCertificateVerificationInnerPage extends BasePage {

public ViewCertificateVerificationInnerPage(WebDriver driver) {
		super(driver);
	}
@FindBy (xpath = "//span[normalize-space()='Name']/following-sibling::span")
WebElement Name;
@FindBy (xpath = "//span[normalize-space()='Register Number']/following-sibling::span")
WebElement RegisterNumber;
@FindBy (xpath = "//span[normalize-space()='Institution']/following-sibling::span")
WebElement Institution;
@FindBy (xpath = "//span[normalize-space()='Program']/following-sibling::span")
WebElement Program;
@FindBy (xpath = "//span[normalize-space()='Branch']/following-sibling::span")
WebElement Branch;
@FindBy (xpath = "//span[normalize-space()='Duration of the Program']/following-sibling::span")
WebElement ProgramDuration;
@FindBy (xpath = "//span[normalize-space()='Mode of Study']/following-sibling::span")
WebElement ModeOfStudy;
@FindBy (xpath = "//span[normalize-space()='Medium of Instruction']/following-sibling::span")
WebElement MediumOfInstruction;
@FindBy (xpath = "//span[normalize-space()='Year of Admission']/following-sibling::span")
WebElement AdmissionYear;
@FindBy (xpath = "//span[normalize-space()='Month and Year of Passing']/following-sibling::span")
WebElement PassingMonthYear;
@FindBy (xpath = "//span[normalize-space()='Total Credits']/following-sibling::span")
WebElement TotalCredits;
@FindBy (xpath = "//span[normalize-space()='CGPA']//following-sibling::span")
WebElement Cgpa;

@FindBy (xpath = "//td[normalize-space()='Provisional Certificate']/following-sibling::td")
WebElement PCissue;
@FindBy (xpath = "//td[normalize-space()='Consolidated Grade Card']/following-sibling::td")
WebElement CGCissue;
@FindBy (xpath = "//td[normalize-space()='Degree Certificate']/following-sibling::td")
WebElement DCissue;

public String getNameText()
{
	String NameText=Name.getText();
	return NameText;
}
public String getRegisterNumText()
{
	String RegText=RegisterNumber.getText();
	return RegText;
}
public String getInstitutionText()
{
	String InstiText=Institution.getText();
	return InstiText;
}
public String getProgramText()
{
	String ProgText=Program.getText();
	return ProgText;
}
public String getBranchText()
{
	String BranText=Branch.getText();
	return BranText;
}
public String getProgramDurationText()
{
	String ProgDurText=ProgramDuration.getText();
	return ProgDurText;
}
public String getModeOfStudyText()
{
	String ModeofStText=ModeOfStudy.getText();
	return ModeofStText;
}
public String getMediumOfInstructionText()
{
	String MedOfInsText=MediumOfInstruction.getText();
	return MedOfInsText;
}
public String getAdmissionYearText()
{
	String AdmissYrText=AdmissionYear.getText();
	return AdmissYrText;
}
public String getPassingMonthYearText()
{
	String PassMnthYrText=PassingMonthYear.getText();
	return PassMnthYrText;
}
public String getTotalCreditsText()
{
	String TotCredText=PassingMonthYear.getText();
	return TotCredText;
}
public String getCGPAText()
{
	String CgpaText=Cgpa.getText();
	return CgpaText;
}
public String getPCIssueDateText()
{
	String PCIsseText=PCissue.getText();
	return PCIsseText;
}
public String getCGCIssueDateText()
{
	String CGCIsseText=CGCissue.getText();
	return CGCIsseText;
}
public String getDCCIssueDateText()
{
	String DCIsseText=DCissue.getText();
	return DCIsseText;
}
} 
