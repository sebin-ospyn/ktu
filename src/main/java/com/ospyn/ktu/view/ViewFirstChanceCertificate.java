package com.ospyn.ktu.view;
import static org.testng.AssertJUnit.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ospyn.ktu.util.SeleniumBase;

public class ViewFirstChanceCertificate extends SeleniumBase{
	FileInputStream fs;
	//XSSFWorkbook workbook;
	//static XSSFSheet sheet,sheet1;
	public static Map<String,String> excelParameters;

	public ViewFirstChanceCertificate(WebDriver driver) throws Exception {
		super(driver);
		excelParameters=ReadFromExcel("PARAMETER_LISTING.xlsx","FirstChance Certificate");
		System.out.println("readexcel completed");

 	}
//	public String	EligibleStudent;
//	**************************************************************************************
	public static String Studentreg;
	public static String StaffAdvisor;



	public void clickExam() throws InterruptedException {
		driver.manage().window().maximize();
		Thread.sleep(300);
		click("//a[text()='Exam']");
		Thread.sleep(500);
	}
	public void ClickFirstchanceCertificate() {
		click("//*[@href='/university/eu/exm/listFirstChanceCertificateExamsForStudent.htm']");
	}
	public void UniversityClickFirstchanceCertificate() {
		click("//*[@href='/university/eu/exm/listFirstChanceCertificate.htm']");
	}
	public void test() {
		System.out.println("Hello........");

	}

	public String studentFetch1()  {
		System.out.println(excelParameters.get("StudentRegNo"));
		String EligibleStudent=excelParameters.get("StudentRegNo");
	//	String EligibleStudent="abcd";
		System.out.println(EligibleStudent);
		return EligibleStudent;

	}

	public void assertingInvitation() {
		String Actualmsg =excelParameters.get("Exam Definition");
		System.out.println("Exam defiinition name is "+Actualmsg);
		String Expectdmsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='badge pull-left']"))).getText();
		System.out.println("text from UI "+Actualmsg);
		try {
		assertEquals(Actualmsg,Expectdmsg);
		System.out.println("Invitation Assertion success ");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Invitation assertion failed");
		}
	}

	public void addreqst() {

		click("//*[contains(text(),'"+(excelParameters.get("Exam Definition"))+"')]//following::button[@class='btn btn-sm btn-success firstChanceAdd']");

	}
	public void vldtePage() {

		String Expectdmsg=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //*[contains(text(),'Info!')]"))).getText();
		System.out.println(Expectdmsg);
		String Actualmsg="Info!";
		System.out.println(Actualmsg);
		try {
			assertEquals(Actualmsg,Expectdmsg);
			System.out.println("Certificate request page reached,assertion successful ");
			}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println("Certificate request page Not reached,assertion Unsuccessful");
			}

	}
	public void selectPssdCourse() {
		List<WebElement> rws = driver.findElements(By.xpath("//*[@class='table table-striped table-bordered table-hover']/tbody/tr"));
		int CourseSize = rws.size();
		System.out.println(CourseSize);
		for(int i=1; i<=CourseSize; i++) {
			click(" //input[@class='submit-control']");
			}

	}

	public void attachmentDoc() throws Exception {
		Robot robot = new Robot();

//		selecting certificate document type  from UI
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='attachmentType']")));
		Select evidence = new Select(element);
		evidence.selectByIndex(1);

		//Selecting a valid document
		StringSelection strr = new StringSelection("/home/u1464/Desktop/{0} - Data Report (Generated on 04_07_2022 05_15 PM).pdf");
        Clipboard clipboardd = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboardd.setContents(strr, null);
        WebElement fileUploadd = driver.findElement(By.xpath("//input[@value='Browse...']"));
        Thread.sleep(2000);

//       ctrl v code
        fileUploadd.sendKeys(Keys.ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        Thread.sleep(2000);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(1000);

//        Passing text "test"
        enterTextinTextField("Description","//*[@id='attDescription']");
		Thread.sleep(1000);
//		Enter key pressing is to handle throwing pop up
		robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(1000);
	}

		public void payment() throws Exception {
		System.out.println("Entered into payment page ");
		System.out.println(" ******************************************************** ");
//		choosing bank(icon click)
		click("//*[@id='paymentGateWay4']");
        Thread.sleep(1000);
//        Click on submit button
        click("//*[@id='proceedToPayForm_submit']");
//        click on declaration
        Thread.sleep(3000);
        click("//input[@type='checkbox']");
        Thread.sleep(500);
//        click on make payment button
        click("//button[@id='makePaymentForm_makePayment']");

//      payment gateway
        click("(//*[@id='OPTNBK'])[1]");

//      click on net banking
        click("(//*[@class='primary-button-bg primary-button-text primary-button-border paymentOption'])[3]");
		Thread.sleep(500);
		selectDropDownItem("Bank name","//*[@id='netBankingBank']");
		Thread.sleep(500);
		enterTextinTextField("Receipient Name","//*[@id='orderShipName']");
		Thread.sleep(500);
		enterTextinTextField("Address","//*[@id='orderShipAddress']");
		Thread.sleep(500);
		enterTextinTextField("ZipCode","//*[@id='orderShipZip']");
		Thread.sleep(500);
		selectDropDownItem("Country","//*[@id='orderShipCountry']");
		Thread.sleep(500);
		enterTextinTextField("City","//*[@id='orderShipCity']");
		Thread.sleep(500);
		enterTextinTextField("State","//*[@id='orderShipCity']");
		Thread.sleep(500);
//		click on payment button
		click("(//*[@id='SubmitBillShip'])[1]");
		Thread.sleep(3000);
//		click on send response button
		click("//*[@id='btn']");
		Thread.sleep(3000);


//		Enter button for confirm popup

//		Asserting payment page
		String Expectdmsg=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Your Payment is successful')]"))).getText();
		String Actualmsg = "Your Payment is successful ";
		try {
			assertEquals(Actualmsg,Expectdmsg);
			System.out.println("Payment successful ");
			}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println("Payment failed");
			}
		Thread.sleep(500);




		//*[@id='orderShipCity']--city
		//*[@id='orderShipState']--state
		//*[@id='orderShipCountry']---country dropdown-India
		//*[@id='orderShipTel']--phone number
//		(//*[@id='SubmitBillShip'])[1]-Make payment button

	}

public void logout() throws InterruptedException {
	//		element.click();
		click("//a[@href='/university/logout.htm']");
		Thread.sleep(2000);
	}
public void StaffadvsrClickFirstchanceCertificate() {
	click("//*[@href='/university/eu/exm/listFirstChanceCertificate.htm']");
}
public void fetchData() throws InterruptedException {
	driver.manage().window().maximize();
	Thread.sleep(1000);
	click("(//*[@href='/university/eu/stu/studentBasicProfile.htm'])[2]");
	Thread.sleep(1000);
 	String a = driver.findElement(By.xpath("(//*[@class='profile-title'])[1]")).getText();
 	System.out.println("Text from UI "+a);
 	String b=StringUtils.substringBetween(a,"(",")").trim();
 	System.out.println(b);
 	Studentreg=b;
	click("(//*[@id='viewProfile'])[1]");
	Thread.sleep(1000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

	String c = driver.findElement(By.xpath("(//*[@class='list-group-item'])[17]")).getText();
 	System.out.println("Text from UI "+c);
 	String d=StringUtils.substringBetween(c,"(",")").trim();
 	System.out.println(d);
 	StaffAdvisor=d;

}

	public void advsrSelctStdnt() {


		String stdntNme = driver.findElement(By.xpath("//*[@id='firstChanceCertificateLisitngTable']/tbody/tr/td[2]")).getText();
		System.out.println("Student name froM UI is "+stdntNme);
		String stdntRegFrmUi=StringUtils.substringAfter(stdntNme, " - ");
		System.out.println(stdntRegFrmUi);
		System.out.println(Studentreg);
		if(stdntRegFrmUi.equals(Studentreg)) {
			click("//*[@id='firstChanceCertificateLisitngTable']/tbody/tr/td[6]/a[1]");
		}


	}
	public void  frwrdToPrncpl() throws InterruptedException {
		click("//*[@id='recommended']");
		Thread.sleep(500);
		click("//*[@id='viewFirstChanceCertificateRequestForm_forwarToPrincipal']");
		Thread.sleep(2000);
		click("(//*[@id='confirm'])[2]");
		Thread.sleep(2000);
	}
	public void cllgeSelctStdnt() throws InterruptedException {

		// count rows with size() method
		List<WebElement> rws = driver.findElements(By.xpath("//*[@id='firstChanceCertificateLisitngTable']/tbody/tr"));
		int	RWSSize=rws.size();
		System.out.println(RWSSize);

		String stdntNme = driver.findElement(By.xpath("//*[@id='firstChanceCertificateLisitngTable']/tbody/tr[1]/td[2]")).getText();
		System.out.println("Student name from UI is "+stdntNme);
		String stdntRegFrmUi=StringUtils.substringAfter(stdntNme, " - ");
		System.out.println(stdntRegFrmUi);
		System.out.println(Studentreg);
//		college user choose request which is submitted by staff advisor
		if(Studentreg.equals(stdntRegFrmUi)) {
			WebElement element = driver.findElement(By.xpath("//*[@id='firstChanceCertificateLisitngTable']/tbody/tr[1]/td[6]/a[1]"));
			element.click();
			Thread.sleep(500);
		}
//		for(int i=0;i<RWSSize;i++) {

//		}
		}

	public void frwrdToUnivrsty () throws Exception {
		click("//*[@id='recommended']");
		Thread.sleep(500);
		click("//*[@id='viewFirstChanceCertificateRequestForm_forwarToUniversity']");
		Thread.sleep(2000);
		click("(//*[@id='confirm'])[2]");
		Thread.sleep(2000);

	}
	public void UserChooseStdntSbmtdby() {

		click("//*[contains(text(),'"+Studentreg+"')]//following::a[1]");
	}
	public void unvstyApprv() throws InterruptedException {
		click("//*[@id='viewFirstChanceCertificateRequestForm_approve']");
		Thread.sleep(500);
		click("(//*[@id='confirm'])[2]");
		Thread.sleep(2000);

	}
	public void clickEditreqst() {

		click("//*[contains(text(),'"+(excelParameters.get("Exam Definition"))+"')]//following::button[@class='btn btn-sm btn-warning firstChanceView']");
		}

	public void StdntGenrtefrstChnceCrtfct() throws AWTException, Exception {
		click("//*[@id='viewFirstChanceCertificateRequestForm_generateCertificateBtn']");
		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(1000);

		}

//	******************************************************************************************************
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
	element.sendKeys(excelParameters.get(parameterNameinDataSheet));
	Thread.sleep(2000);
	Robot robot = new Robot();
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);
}

public static void click(String strLocator) {
	 WebDriverWait wait = new WebDriverWait(driver, 10);
     WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(strLocator)));
     ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

     if (element.isEnabled()) {
         try {
             element.click();
         } catch (ElementClickInterceptedException e) {
         // Use JavaScript to click if normal click is intercepted


((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
         }
     }
     System.out.println("Button Clicked !!"+strLocator);
 }






}
