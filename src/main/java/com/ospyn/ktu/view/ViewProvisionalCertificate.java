package com.ospyn.ktu.view;
import static org.testng.AssertJUnit.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.ospyn.ktu.util.SeleniumBase;
import com.ospyn.ktu.util.ViewCommonUtil;
import com.ospyn.ktu.util.ViewLogin;

public class ViewProvisionalCertificate extends SeleniumBase {
	static ViewLogin login;
	FileInputStream fs;
	XSSFWorkbook workbook;
	static XSSFSheet sheet,sheet1;
	public static Map<String,String> excelParameters;


	public ViewProvisionalCertificate(WebDriver driver)throws Exception {
		super(driver);

		excelParameters=ReadFromExcel("CertificateParameter.xlsx","ProvisionalCertificate");

	}
	//	***********************************************************************************************************

	public void loginUser(String username)
	{
		try
		{
			String password="pass1@";

			login=new ViewLogin(driver);
			login.logIn(username,password);
			login.clickLogin();
			Thread.sleep(1000);

		}
		catch(Exception e)
		{

		}
	}


	public void certficateReqst() throws Exception {
		FileInputStream fs = new FileInputStream(new File(System.getProperty("user.dir")+"/Test_Data/CertificateParameter.xlsx"));

		Map<String, String> mapExcelData = new HashMap<String, String>();

				//Getting the workbook
		XSSFWorkbook workbook1 = new XSSFWorkbook(fs) ;
		DataFormatter formatter = new DataFormatter(); //creating formatter using the default locale

				 //Getting the sheet
		XSSFSheet sheetx = workbook1.getSheet("Provisional Certificate report");
		System.out.println("Number of rows in sheet are "+sheetx.getLastRowNum());
		System.out.println("Number of rows in sheet are "+sheetx.getPhysicalNumberOfRows());



		for(int tableIndex=1;tableIndex<sheetx.getPhysicalNumberOfRows();tableIndex++){
			String StudentID=ViewCommonUtil.readExcelColumHeader("CertificateParameter.xlsx","Provisional Certificate report","UserName", tableIndex );
			System.out.println(StudentID);

			loginUser(ViewCommonUtil.readExcelColumHeader("CertificateParameter.xlsx","Provisional Certificate report","UserName", tableIndex ));

			//User click on  student module
			ViewCommonUtil.click("(//*[@href='/university/eu/stu/studentBasicProfile.htm'])[2]");
			//User click on student certificate
			ViewCommonUtil.click("//*[contains(text(),'My Certificates')]");

			//User checking request button visible or not

			String Expected=driver.findElement(By.xpath(" (//*[@class='list-group-item'])[1]/table/tbody/tr/td[2]")).getText();
			System.out.println(Expected);
			String testValue="Request for certificate";
			System.out.println(testValue);


			try {
				//		**************************
				if (Expected.equals(testValue)) {
					System.out.println("Request button is visible against provisional certificate");

					//If request button is visible then move with flow(click on it)
					ViewCommonUtil.click("(//*[@class='list-group-item'])[1]//table/tbody/tr/td[2]/a[1]");




					passingCommnicatndetails();
					chooseProcessPriority();
					JavascriptExecutor js = (JavascriptExecutor) driver;

					js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
					ViewCommonUtil.click("//*[@id='addStudentForm_saveForm']");
					//Preview and submit button clicked
					ViewCommonUtil.click("//*[@id='addStudentForm_save']");


					//User checking declaration listed
					ViewCommonUtil.click("//*[@id='listStudentForm_disclaimer1']");
					ViewCommonUtil.click("//*[@id='listStudentForm_disclaimer2']");
					//user click submit and make payment
					//js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

					ViewCommonUtil.click("//*[@id='listStudentForm_submit']");


					//for request submitting page.
					try {
						WebElement  gatway=driver.findElement(By.xpath("//*[@id='paymentGateWay4']"));

						//payment method
						ViewCommonUtil.click("//*[@id='paymentGateWay4']");
						Thread.sleep(1000);
						//User click on make payment button
						ViewCommonUtil.click("//*[@id='proceedToPayForm_submit']");
						System.out.println("Payment successful ");
						Thread.sleep(1000);

						//click on back to home
						ViewCommonUtil.click("//label[@class='label label-info']");
						Thread.sleep(1000);

						//User click on  student module
						ViewCommonUtil.click("(//*[@href='/university/eu/stu/studentBasicProfile.htm'])[2]");
						//User click on student certificate
						ViewCommonUtil.click("//*[contains(text(),'My Certificates')]");

						//click on view details button against certificate
						ViewCommonUtil.click("//*[@class='btn btn-primary btn-xs pull-right']");

						//click on generate button
						ViewCommonUtil.click("//*[@title='Generate Certificate']");
						//click on confirm pop up yes button
						ViewCommonUtil.click("(//*[@id='confirm'])[2]");

						//Try block for generating certificate
						try {
							//checking that view button element is present,if not then print showing error in excel and logged out,if button showing then mark as PASS
							//xpath for view button
							WebElement  element=driver.findElement(By.xpath("//*[@id='listStudentForm_view']"));

							ViewCommonUtil.writeToExcel("CertificateParameter.xlsx","Provisional Certificate report",StudentID,"PASS");
							logout();


						}
						catch(Exception e) {
							//If element not found(after generate,view bttn not visible yet) then catch and print the throwing error in excel
							//String ValdtnMsg=driver.findElement(By.xpath("//*[contains(text(),'Error') or contains(text(),'Problem')]")).getText();
							String ValdtnMsg=driver.findElement(By.xpath("//div[@id='confirmModel']//div[@class='modal-body']/div[@id='errorDiv']")).getText();


							//String ValdtnMsg=driver.findElement(By.xpath("//*[contains(text(),'Problem while generating')]")).getText();
							ViewCommonUtil.writeToExcel("CertificateParameter.xlsx","Provisional Certificate report",StudentID,ValdtnMsg);
							ViewCommonUtil.click(" //*[@id='confirmNo']");
							logout();
						}


					}
					//if any error will throw while requesting certificate,which is handled in catch
					catch (Exception e) {
						String ValdtnMsg=driver.findElement(By.xpath("//*[contains(text(),'Error') or contains(text(),'You have pending')]")).getText();
						ViewCommonUtil.writeToExcel("CertificateParameter.xlsx","Provisional Certificate report",StudentID,ValdtnMsg);
						logout();
 					}


				}
//				else if(){
//				if button not visible then write the validation to the excel against student id
//					 			System.out.println("Clear fee dues to request for this certificate");
//								ViewCommonUtil.writeToExcel("PARAMETER_LISTING.xlsx","Provisional Certificate report",StudentID, Expected);
//								logout();
//				}





			}
			catch(Exception e) {
				//			if button not visible then write the validation to the excel against student id
				System.out.println("Clear fee dues to request for this certificate");
				ViewCommonUtil.writeToExcel("CertificateParameter.xlsx","Provisional Certificate report",StudentID, Expected);
				logout();

			}


			String xpected=driver.findElement(By.xpath(" (//*[@class='list-group-item'])[1]/table/tbody/tr/td[1]")).getText();
			System.out.println(xpected);
			String estValue="Certificate Generated";
			System.out.println(estValue);
			try {
				if(xpected.equals(estValue)) {
					ViewCommonUtil.writeToExcel("CertificateParameter.xlsx","Provisional Certificate report",StudentID, xpected);
					logout();
				}
				else {
					ViewCommonUtil.writeToExcel("CertificateParameter.xlsx","Provisional Certificate report",StudentID, xpected);
					logout();
				}
			}
			catch(Exception e) {

			}














			//		else {
			//
			//
			////			if button not visible then write the validation to the excel against student id
			// 			System.out.println("Clear fee dues to request for this certificate");
			//			ViewCommonUtil.writeToExcel("PARAMETER_LISTING.xlsx","Provisional Certificate report",StudentID, Expected);
			//			logout();
			//
			//
			//			}



		}
	}






	//	********************************************************************************************************************
	public void logout() throws InterruptedException {
		//		element.click();
		ViewCommonUtil.click("//a[@href='/university/logout.htm']");
		Thread.sleep(2000);
	}
	public void clickStudentModule() {

		ViewCommonUtil.click("(//*[@href='/university/eu/stu/studentBasicProfile.htm'])[2]");
	}
	public void clickMycertificates() {
		ViewCommonUtil.click("//*[contains(text(),'My Certificates')]");
	}
	public void ButtonAssert() {
		String Expected=driver.findElement(By.xpath(" (//*[@class='btn btn-warning btn-xs pull-centre'])[1]")).getText();
		System.out.println(Expected);
		String testValue="Request for certificate";
		System.out.println(testValue);
		assertEquals(Expected, testValue);
		System.out.println("Request button is visible against provisional certificate");
	}

	public void clickReqBttn() {
		ViewCommonUtil.click(" (//*[@class='btn btn-warning btn-xs pull-centre'])[1]");

	}
	public void passingCommnicatndetails() throws Exception {

		enterTextinTextField("Mobile Number","//*[@id='addStudentForm_mobileNumber']");
		enterTextinTextField("Email","//*[@id='addStudentForm_email']");
		enterTextinTextField("Address","//*[@id='addStudentForm_address']");
		enterTextinTextField("City","//*[@id='addStudentForm_city']");
		enterTextinTextField("State","//*[@id='state']");
		selectDropDownItem("Country","//*[@id='countryId']");
		enterTextinTextField("Pincode","//*[@id='addStudentForm_pincode']");

	}

	public void chooseProcessPriority() throws AWTException, InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		//xpath of process priority
		WebElement  element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='processpriority']")));
		Select dropdown = new Select(element);
		//passing the process priority
		dropdown.selectByIndex(1);
	}
	public void validatingSavedReqst() {
		ViewCommonUtil.click("//*[@id='addStudentForm_saveForm']");
		//		User clicked back button
		ViewCommonUtil.click("//*[@id='add']");

		String Expected = driver.findElement(By.xpath("//*[contains(text(),'Request Submission')]")).getText();
		System.out.println(Expected);
		String Actual ="Request Submission Pending";
		System.out.println(Actual);
		// Create an instance of SoftAssert
		SoftAssert softAssert = new SoftAssert();
		// Perform the soft assertion
		softAssert.assertEquals(Expected, Actual, "The expected and actual strings do not match!");
		// assertEquals(Expected,Actual);
	}

	public void certificatePayment() throws InterruptedException {
		ViewCommonUtil.click("//*[@id='addStudentForm_save']");
		ViewCommonUtil.click("//*[@id='addStudentForm_save']");
		//		User checking declaration listed
		ViewCommonUtil.click("//*[@id='listStudentForm_disclaimer1']");
		ViewCommonUtil.click("//*[@id='listStudentForm_disclaimer2']");
		//		user click submit and make payment
		ViewCommonUtil.click("//*[@id='listStudentForm_submit']");

		//		payment method
		ViewCommonUtil.click("//*[@id='paymentGateWay4']");
		Thread.sleep(1000);
		ViewCommonUtil.click("");


	}


















	//	*************************************************************************************************************
	public Map<String,String> ReadFromExcel(String strExcelFileName, String strSheetName) throws Exception

	{

		System.out.println("strSheetName="+strSheetName);

		FileInputStream fs = new FileInputStream(new File(System.getProperty("user.dir")+"/Test_Data/"+strExcelFileName));

		Map<String, String> mapExcelData = new HashMap<String, String>();

		//Getting the workbook
		XSSFWorkbook workbook1 = new XSSFWorkbook(fs) ;
		DataFormatter formatter = new DataFormatter(); //creating formatter using the default locale

		//Getting the sheet
		XSSFSheet sheetx = workbook1.getSheet(strSheetName);
		System.out.println("Number of rows in sheet are "+sheetx.getLastRowNum());

		for(int tableIndex=0;tableIndex<sheetx.getPhysicalNumberOfRows();tableIndex++){
			//System.out.println("value="+formatter.formatCellValue(sheetx.getRow(tableIndex).getCell(0)));
			System.out.println("2=="+sheetx.getRow(tableIndex).getCell(0).getStringCellValue());
			System.out.println("333"+sheetx.getRow(tableIndex).getCell(1).getCellType());
			switch (sheetx.getRow(tableIndex).getCell(1).getCellType()) {
			case STRING:
				mapExcelData.put(sheetx.getRow(tableIndex).getCell(0).getStringCellValue().trim(),sheetx.getRow(tableIndex).getCell(1).getStringCellValue());
				break;
			case NUMERIC:
				String strVal=formatter.formatCellValue(sheetx.getRow(tableIndex).getCell(1));
				mapExcelData.put(sheetx.getRow(tableIndex).getCell(0).getStringCellValue().trim(),strVal);
				break;

			case BLANK:
				System.out.println("Blank cell");
				break;
			default:
				System.out.println("Unknown cell type");
				break;

			}



		}

		workbook1.close();

		return mapExcelData;

	}

	public void selectDropDownItem(String parameterNameinDataSheet,String strLocator)throws Exception {

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(strLocator)));
		Select dropdown = new Select(element);

		dropdown.selectByVisibleText(excelParameters.get(parameterNameinDataSheet));

		System.out.println(parameterNameinDataSheet+"DONE!!!!");

		Thread.sleep(2000);

	}

	public void enterTextinTextField(String parameterNameinDataSheet,String strLocator)throws Exception{

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(strLocator)));
		element.clear();
		element.sendKeys(excelParameters.get(parameterNameinDataSheet));
		Thread.sleep(2000);
		Robot robot = new Robot();
		//	robot.keyPress(KeyEvent.VK_ENTER);
		//	srobot.keyRelease(KeyEvent.VK_ENTER);
		System.out.println("Test Passed sucessfully !!"+parameterNameinDataSheet);

	}



}
