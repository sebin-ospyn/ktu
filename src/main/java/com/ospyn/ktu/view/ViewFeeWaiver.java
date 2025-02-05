package com.ospyn.ktu.view;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ospyn.ktu.util.SeleniumBase;
import com.ospyn.ktu.util.ViewCommonUtil;

public class ViewFeeWaiver extends SeleniumBase {

	public ViewFeeWaiver(WebDriver driver) throws Exception{
		super(driver);
		ViewCommonUtil.readFromExcel("PARAMETER_LISTING.xlsx","FeeWaiver");
	}
	
	@FindBy(xpath = "//a[@href=\"/university/eu/uty/additionalFeeCollectionList.htm\"]")
	private WebElement AdditionFeeCollectionBtn;
	@FindBy(xpath="//a[@id='add']")
	private WebElement AddBtn;
	@FindBy(xpath = "//select[@id='academicYearId']")
	private WebElement AcademicYearLstBx;
	@FindBy(xpath = "//select[@name='financialYear']")
	private WebElement FinancialYearLstBx;
	@FindBy(xpath = "//select[@id='processTypeId']")
	private WebElement ProcessTypeLstBx;
	@FindBy(xpath = "//select[@id='processes']")
	private WebElement ProcessLstBx;
	@FindBy(xpath = "//select[@id='paymentType']")
	private WebElement PaymentTypeLstBx;
	@FindBy(xpath = "//input[@id='additionalFeeCollectionForm_amount']")
	private WebElement AmtTxtBx;
	@FindBy(xpath = "//input[@id='fromDate']")
	private WebElement EffectiveDate;
	@FindBy(xpath = "//input[@id='toDate']")
	private WebElement ToDate;
	@FindBy(xpath= "//input[@name='noOfInstallments']")
	private WebElement NumInstallmentTxtBx;
	@FindBy(xpath = "//textarea[@id='descriptionField']")
	private WebElement DescriptionTxtBx;
	@FindBy(xpath = "//input[@type='button']")
	private WebElement UploadBtn;
	@FindBy(xpath = "//input[@id='institution0']")
	private WebElement ChooseInsti;
	@FindBy(xpath = "//input[@id='additionalAmount0']")
	private WebElement chooseAmt;
	@FindBy(xpath = "//button[@id='submit']")
	private WebElement SaveBtn;
	@FindBy(xpath = "//td[@class='today day']")
	private WebElement TodaysDate;
	@FindBy(xpath = "//input[@id='attachment']")
	private WebElement uploadAttachment;
	@FindBy(xpath="(//a[@class='btn btn-primary btn-xs'])[1]")
	private WebElement editBtn;
	@FindBy(xpath="//button[@name='submit']")
	private WebElement submitBtn;
	@FindBy (xpath = "//button[@id='save']")
	private WebElement okbtn;
	@FindBy (xpath = "//button[@id='verify']")
	private WebElement verifyBtn;
	@FindBy (xpath = "(//button[@id='confirm'])[2]")
	private WebElement cnfmVerify;
	@FindBy (xpath = "//button[@id='approve']")
	private WebElement approveBtn;
	@FindBy (xpath = "(//button[@id='confirm'])[2]")
	private WebElement cnfmApprove;
	
	                      // institution payment summary page
	@FindBy(xpath = "//a[text()='Institution Payment Summary']")
	private WebElement smodInstitutionPaymentSummary;
	@FindBy(xpath = "//select[@name='financialYearId']")
	private WebElement IFinancialYearLstBx;
	@FindBy(xpath = "//input[@id='name']")
	private WebElement Insti;
	@FindBy(xpath = "//select[@id='paymentType']")
	private WebElement paytype;
	@FindBy(xpath = "//button[@name='search']")
	private WebElement searchbt;
	@FindBy(xpath = "(//a[@data-original-title='Fee Waiving/Adjusting'])[1]")
	private WebElement addFeeWaiver;
	@FindBy(xpath = "//input[@id='waiveredMandatoryAmtId']")
	private WebElement waiveMandatoryAmttxtbx;
	@FindBy(xpath = "//textarea[@id='feeWaiverForm_reason']")
	private WebElement waiveReason;
	@FindBy (xpath = "//button[@id='feeWaiverForm_save']")
	private WebElement waiversavebtn;
	@FindBy (xpath = "//a[text()='Fee Waiver']")
	private WebElement smodFeewaiver;
	@FindBy (xpath = "(//a[@data-original-title=\"Edit Fee Waiver\"])[1]")
	private WebElement editFeeWaiver;
	@FindBy (xpath = "//button[@id='approveButton']")
	private WebElement approveFeeWaiverBtn;
	@FindBy (xpath = "(//button[@id='confirm'])[1]")
	private WebElement cnfApproveFeeWaiver;
	@FindBy (xpath = "//textarea[@id='remarkField']")
	private WebElement cnfApproveFeeWavierRemark;
	                   // payment refund
	@FindBy (xpath = "//a[text()='Payment Refunds']")
	private WebElement smodPamentRefund;
	
	
	// Institution payment
	@FindBy(xpath = "//a[@href=\"/university/eu/ins/institutionPaymentDashboard.htm\"]")
	private WebElement clickherePay;
	
	@FindBy(xpath = "//tbody/tr[1]/td[1]")
	private WebElement Paydescription;
	
	@FindBy(xpath = "//tbody/tr[1]/td[3]/b[1]")
	private WebElement PayAmount;
	
	
	public void LoginAsktusupport02() throws Exception
	{
		ViewCommonUtil.logIn("LoginAsktusupport02","Password");
	}
	
	public void loginasStudent1() throws Exception
	{
		ViewCommonUtil.logIn("Student1", "Password");
	}
	public void loginasInstitute() throws Exception
	{
		ViewCommonUtil.logIn("Institution", "Password");
	}
	
	public void addAdditionalFeeCollection() throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, 10); // 10 seconds timeout

		System.out.println("adding additional fee collection");
		 wait.until(ExpectedConditions.elementToBeClickable(AdditionFeeCollectionBtn)).click();
		 wait.until(ExpectedConditions.elementToBeClickable(AddBtn)).click();
		Thread.sleep(1000);
		ViewCommonUtil.selectDropdownOptionFromExcel(AcademicYearLstBx, "Academic Year"); //hyphen needs to be edited in excel
		ViewCommonUtil.selectDropdownOptionFromExcel(FinancialYearLstBx, "Financial Year");
		ViewCommonUtil.selectDropdownOptionFromExcel(ProcessTypeLstBx,"Process Type" );
		ViewCommonUtil.selectDropdownOptionFromExcel(ProcessLstBx,"Process");
		Thread.sleep(1000);
		ViewCommonUtil.selectDropdownOptionFromExcel(PaymentTypeLstBx, "Payment Type");
		wait.until(ExpectedConditions.visibilityOf(AmtTxtBx));
		ViewCommonUtil.enterTextFromExcel("Amount (INR )", AmtTxtBx);
		wait.until(ExpectedConditions.elementToBeClickable(EffectiveDate)).click();
		
//		wait.until(ExpectedConditions.elementToBeClickable(TodaysDate)).click();
		wait.until(ExpectedConditions.elementToBeClickable(TodaysDate));
		ViewCommonUtil.clickwithscroll(TodaysDate);
		wait.until(ExpectedConditions.elementToBeClickable(ToDate)).click();
//		wait.until(ExpectedConditions.elementToBeClickable(TodaysDate)).click();
		wait.until(ExpectedConditions.elementToBeClickable(TodaysDate));
		ViewCommonUtil.clickwithscroll(TodaysDate);
		
		ViewCommonUtil.enterTextFromExcel("Description",DescriptionTxtBx);
		ViewCommonUtil.browseAttachmentp("File.pdf",uploadAttachment);
		Thread.sleep(1000);
		 wait.until(ExpectedConditions.elementToBeClickable(ChooseInsti)).sendKeys("MUT"); // hard coded needs rework
		ViewCommonUtil.enterKeyPress();
		wait.until(ExpectedConditions.elementToBeClickable(SaveBtn)).click();
	    wait.until(ExpectedConditions.elementToBeClickable(editBtn)).click();
		Thread.sleep(1500);
		System.out.println("ssss");
		ViewCommonUtil.scrollToBottom();
		wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
	    wait.until(ExpectedConditions.elementToBeClickable(okbtn)).click();
		Thread.sleep(1500);
		wait.until(ExpectedConditions.elementToBeClickable(editBtn)).click();
	    wait.until(ExpectedConditions.elementToBeClickable(verifyBtn)).click();
	    wait.until(ExpectedConditions.elementToBeClickable(cnfmVerify)).click();
		Thread.sleep(1500);
		wait.until(ExpectedConditions.elementToBeClickable(editBtn)).click();
	    wait.until(ExpectedConditions.elementToBeClickable(approveBtn)).click();
	    wait.until(ExpectedConditions.elementToBeClickable(cnfmApprove)).click();
	}
	public void addFeeWaiver() throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, 25); // 10 seconds timeout
		wait.until(ExpectedConditions.elementToBeClickable(smodInstitutionPaymentSummary)).click();

		wait.until(ExpectedConditions.visibilityOf(IFinancialYearLstBx));
		ViewCommonUtil.selectDropdownOptionFromExcel(AcademicYearLstBx, "Academic Year"); //hyphen needs to be edited in excel
		ViewCommonUtil.selectDropdownOptionFromExcel(IFinancialYearLstBx, "Financial Year");
		wait.until(ExpectedConditions.visibilityOf(Insti)).sendKeys("MUT");
		ViewCommonUtil.enterKeyPress();
		ViewCommonUtil.selectDropdownOptionFromExcel(paytype,"Payment Type");
		wait.until(ExpectedConditions.elementToBeClickable(searchbt)).click();
//		Thread.sleep(1500);
		wait.until(ExpectedConditions.elementToBeClickable(addFeeWaiver));
		ViewCommonUtil.clickwithscroll(addFeeWaiver);
		
		wait.until(ExpectedConditions.visibilityOf(waiveMandatoryAmttxtbx));
		ViewCommonUtil.enterTextFromExcel("Waive Mandatory Amt", waiveMandatoryAmttxtbx);
		wait.until(ExpectedConditions.elementToBeClickable(waiversavebtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(smodFeewaiver)).click();
		wait.until(ExpectedConditions.elementToBeClickable(editFeeWaiver)).click();
		wait.until(ExpectedConditions.elementToBeClickable(approveFeeWaiverBtn)).click();
		wait.until(ExpectedConditions.visibilityOf(cnfApproveFeeWavierRemark));
		ViewCommonUtil.enterTextFromExcel("Fee waiver cnf approvel remark",cnfApproveFeeWavierRemark);
		 wait.until(ExpectedConditions.elementToBeClickable(cnfApproveFeeWaiver)).click();
	}
	public String verificationDescriptionCollegelogin()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10); // 10 seconds timeout
		 wait.until(ExpectedConditions.elementToBeClickable(clickherePay)).click();
		 wait.until(ExpectedConditions.visibilityOf(Paydescription));
		 String desc = Paydescription.getText();
		return desc;
	}
	public String verificationAmtCollegelogin()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10); // 10 seconds timeout
		 wait.until(ExpectedConditions.visibilityOf(PayAmount));
		String amt = PayAmount.getText();
		return amt;
	}
	
	
	public void approvePaymentRefund()
	{
		smodPamentRefund.click();
	}
	public void feePaymentAsCollege()
	{
//		href="/university/eu/ins/institutionPaymentDashboard.htm"
	}
	
	
	
	
	 
	
	
	
	
	
	
}
