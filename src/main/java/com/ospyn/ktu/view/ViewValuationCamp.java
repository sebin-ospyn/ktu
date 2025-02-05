package com.ospyn.ktu.view;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.ospyn.ktu.util.SeleniumBase;

public class ViewValuationCamp extends SeleniumBase {
	FileInputStream fs;
	XSSFWorkbook workbook;
	static XSSFSheet sheet,sheet1;
	public static boolean eflag=false;

public ViewValuationCamp(WebDriver driver) throws IOException
	{
		super(driver);
 		fs = new FileInputStream(new File(System.getProperty("user.dir")+"/Test_Data/PARAMETER_LISTING.xlsx"));
		//Getting the workbook
		workbook = new XSSFWorkbook(fs);
		//Getting the sheet
		sheet = workbook.getSheetAt(9);
		System.out.println(sheet.getRow(1).getCell(1).getStringCellValue());
	}
//	***********************************************************************************************************
@FindBy(xpath = "//*[@id='10']/a")
WebElement Valuation;
@FindBy(xpath = "(//*[text()='Valuation Camp'])[1]")
WebElement ValuationCamp;




	public WebElement getValuationCamp()
	{
	return ValuationCamp;
	}
	public WebElement getValuation()
	{
	return Valuation;
	}

	String centreName;
	private String testValue;
	private String resultValue;


public String valdtngValuationCamp() throws InterruptedException
{
	// get the error message
			String status = driver.findElement(By.xpath("//*[text()='Valuation Camps']")).getText();
			Thread.sleep(500);
			return status;
}

public void addclick() throws InterruptedException
{
	Thread.sleep(300);
	WebElement element = driver.findElement(By.xpath("//*[@id='add']"));
	element.click();
	Thread.sleep(500);


}

public void cnfgrValtnCamp()
{
try {
	//passing the Program
	WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='programId']")));
	Select Programdropdown = new Select(element);
	Programdropdown.selectByVisibleText(sheet.getRow(1).getCell(1).getStringCellValue());
	Thread.sleep(1000);

//	Passing Academic Year
	element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='academicYearId']")));
	Select Yeardrpdown= new Select(element);
	Yeardrpdown.selectByVisibleText(sheet.getRow(2).getCell(1).getStringCellValue());
	Thread.sleep(500);

//	Passing Exam
	element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='examDefinitionId']")));
	Select Exam= new Select(element);
	Exam.selectByVisibleText(sheet.getRow(3).getCell(1).getStringCellValue());
	Thread.sleep(500);

//	Passing Valuation Camp Center
	element = driver.findElement(By.xpath("//*[@id='valuationCampCentre']"));
	element.sendKeys(sheet.getRow(4).getCell(1).getStringCellValue());
	Thread.sleep(500);

		Robot robot = new Robot();
	//	Pressing the Enter Key
		robot.keyPress(KeyEvent.VK_ENTER);
	//	Releasing the Enter Key
		robot.keyRelease(KeyEvent.VK_ENTER);

//		Passing Valuation Camp Officer
		element = driver.findElement(By.xpath("//*[@id='valuationCampForm_campAdmin']"));
		element.click();
		Thread.sleep(500);
		element.sendKeys("K");
		Thread.sleep(1500);
	//	Pressing the Enter Key
		robot.keyPress(KeyEvent.VK_ENTER);
	//	Releasing the Enter Key
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(500);

//		Passing month
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='valuationCampForm_month']")));
		Select Month= new Select(element);
		Month.selectByVisibleText(sheet.getRow(5).getCell(1).getStringCellValue());
		Thread.sleep(500);

//		Passing Year
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='valuationCampForm_year']")));
		Select Year= new Select(element);
 		Year.selectByVisibleText(sheet.getRow(6).getCell(1).getRawValue());
		Thread.sleep(500);

//		Passing From date
		element = driver.findElement(By.xpath("//*[@id='valuationCampForm_fromDate']"));
		element.sendKeys(sheet.getRow(7).getCell(1).getRawValue());
		Thread.sleep(500);
		//Pressing the Enter Key
		robot.keyPress(KeyEvent.VK_ENTER);
		//Releasing the Enter Key
		robot.keyRelease(KeyEvent.VK_ENTER);

//		Passing To Date
		element = driver.findElement(By.xpath("//*[@id='valuationCampForm_toDate']"));
 		element.sendKeys(sheet.getRow(8).getCell(1).getStringCellValue());

		Thread.sleep(500);
		//Pressing the Enter Key
		robot.keyPress(KeyEvent.VK_ENTER);
		//Releasing the Enter Key
		robot.keyRelease(KeyEvent.VK_ENTER);


}
catch (Exception e)
{
	e.printStackTrace();
}
}

public void answesheetsExaminers() throws AWTException, InterruptedException
{
	try {
	Robot robot = new Robot();
//	Passing Member's providing Examiners,First college
	WebElement element = driver.findElement(By.xpath("//input[@value='Select the member colleges providing examiners']"));
	element.click();
	System.out.println(sheet.getRow(9).getCell(1).getStringCellValue());
	element.sendKeys(sheet.getRow(9).getCell(1).getStringCellValue());
 	Thread.sleep(300);
 	robot.keyPress(KeyEvent.VK_ENTER);
 	robot.keyRelease(KeyEvent.VK_ENTER);
	Thread.sleep(500);

//	Passing Member's providing Examiners,Second college
	WebElement delement = driver.findElement(By.xpath("//input[@value='Select the member colleges providing examiners']"));
	delement.click();
	System.out.println(sheet.getRow(9).getCell(2).getStringCellValue());
	delement.sendKeys(sheet.getRow(9).getCell(2).getStringCellValue());
 	Thread.sleep(300);
 	robot.keyPress(KeyEvent.VK_ENTER);
 	robot.keyRelease(KeyEvent.VK_ENTER);
	Thread.sleep(500);

//	Passing Member's providing Answer sheets,First College
	element = driver.findElement(By.xpath("//input[@value='Select the member colleges providing answer sheets']"));
	element.click();
	System.out.println(sheet.getRow(10).getCell(1).getStringCellValue());
	element.sendKeys(sheet.getRow(10).getCell(1).getStringCellValue());
 	Thread.sleep(300);
 	robot.keyPress(KeyEvent.VK_ENTER);
 	robot.keyRelease(KeyEvent.VK_ENTER);
	Thread.sleep(500);

//	Passing Member's providing Answer sheets,Second College
	element = driver.findElement(By.xpath("//input[@value='Select the member colleges providing answer sheets']"));
	element.click();
	System.out.println(sheet.getRow(10).getCell(2).getStringCellValue());
	element.sendKeys(sheet.getRow(10).getCell(2).getStringCellValue());
 	Thread.sleep(300);
 	robot.keyPress(KeyEvent.VK_ENTER);
 	robot.keyRelease(KeyEvent.VK_ENTER);
	Thread.sleep(500);
	}

	catch(Exception e)
	{
		e.printStackTrace();
	}

	}

	public void checkBox()
	{
		WebElement element = driver.findElement(By.xpath("//*[@id='chiefEnabled']"));
		element.click();
	}
	public void saveCamp() throws InterruptedException
	{

		WebElement saveButton = driver.findElement(By.xpath("//*[@id='valuationCampForm_submit']"));
		saveButton.click();
		Thread.sleep(300);
	}
	public void campSearching() throws AWTException, InterruptedException
	{
//		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='valuationCampForm_campName']")));
//		element.sendKeys(sheet.getRow(4).getCell(1).getStringCellValue());
//		Thread.sleep(300);
		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_ENTER);
	 	robot.keyRelease(KeyEvent.VK_ENTER);

//		Passing Academic Year
	 	WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='academicYearId']")));
		Select Yeardrpdown= new Select(element);
		Yeardrpdown.selectByVisibleText(sheet.getRow(2).getCell(1).getStringCellValue());
		Thread.sleep(500);

//		passing the Program
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //*[@id='program']")));
		Select Programdropdown = new Select(element);
		Programdropdown.selectByVisibleText(sheet.getRow(1).getCell(1).getStringCellValue());
		Thread.sleep(500);

//		Passing Exam
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='examDefinition']")));
		Select Exam= new Select(element);
		Exam.selectByVisibleText(sheet.getRow(3).getCell(1).getStringCellValue());
		Thread.sleep(500);
//		User click search button
		element = driver.findElement(By.xpath("//*[@id='valuationCampForm_search']"));
		element.click();
		Thread.sleep(500);


}

	public String campValidating()
	{

		 String status = driver.findElement(By.xpath("//*[@id='valuationTable']/tbody/tr/td[1]")).getText();
		 centreName = StringUtils.substringAfter(status, "-").trim();
		 resultValue=sheet.getRow(4).getCell(1).getStringCellValue();
		 System.out.println("Camp centre name is "+resultValue);
		 System.out.println("Camp centre name is "+centreName);
		 assertEquals(centreName,resultValue);

		 String exam = driver.findElement(By.xpath("//*[@id='valuationTable']/tbody/tr/td[2]")).getText();
		 centreName = exam.trim();
		 resultValue=sheet.getRow(3).getCell(1).getStringCellValue();
		 System.out.println("Exam is "+resultValue);
		 System.out.println("Exam is "+centreName);
		 assertEquals(centreName,resultValue);
		 return centreName;

	}

	public void campStatus() throws InterruptedException, AWTException
	{
		WebElement element = driver.findElement(By.xpath(" //*[@id='checkAll']"));
		element.click();
		Thread.sleep(300);
//		Passing Camp status
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='changeStatusFilter']")));
		Select statusDropdown= new Select(element);
		statusDropdown.selectByVisibleText(sheet.getRow(11).getCell(1).getStringCellValue());
		Thread.sleep(500);
		WebElement campstatus = driver.findElement(By.xpath("//*[@id='changeStatusBtnId']"));
		campstatus.click();
		Thread.sleep(500);
		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_ENTER);
	 	robot.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(500);

	}
	public String validateCampStatus() throws InterruptedException
	{
		Thread.sleep(500);

		 String status = driver.findElement(By.xpath("//*[@id='valuationTable']/tbody/tr/td[5]")).getText();
		 String campstatus =  status.trim();
		 resultValue=sheet.getRow(11).getCell(1).getStringCellValue();
		 System.out.println("Camp centre name is "+resultValue);
		 System.out.println("Camp centre name is "+campstatus);
		 assertEquals(campstatus,resultValue);
		return status;
	}
	/**
	 * @author u1464
	 *
	 *
	 */
//	public void campEditing()
//	{
//		try
//		{
////			Xpath for edit button-If edit button is displayed,then click on it and add other colleges
//
//			//WebElement element = driver.findElement(By.xpath("//*[@class='glyphicon glyphicon-pencil']"));
//			boolean elementFlag=false;
// 			try {
//				WebElement  element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='glyphicon glyphicon-pencil']")));
////			    String value = element.getText(); // Assuming the value is text content, you can use 'getAttribute("value")' for input elements
//			    if (element.isDisplayed())
//			    {
//			        // Element contains a non-empty value
////			        System.out.println("Element value: " + value);
//			        elementFlag= true;
//			    } else {
//			        // Element does not contain a value
//			        System.out.println("Element does not contain a value");
//			        elementFlag=false;
//			    }
//			} catch (NoSuchElementException e) {
//			    // Handle NoSuchElementException (element not found)
//			    e.printStackTrace();
//			    elementFlag=false;
//			} catch (TimeoutException e) {
//			    // Handle TimeoutException (element not found within specified time)
//			    System.out.println("Element not found within the specified time");
//			    elementFlag=false;
//			}
//
//
//			TestNG testng;
//			List<String> suites = Lists.newArrayList();
//			testng = new TestNG();
//			if (elementFlag) {
//
//				String suiteName = "src/main/resources/XMLEditValuationCamp.xml";
//
//				testng.setTestSuites(suites);
//				suites.add(suiteName);
////				System.out.println("Suites are "+suites);
////				testng.setTestSuites(suites);
//
//			} else {
//
//				String suiteName = "src/main/resources/XMLAddValuationCamp.xml";
//
//				testng.setTestSuites(suites);
//				suites.add(suiteName);
////				System.out.println("Suites are "+suites);
////				testng.setTestSuites(suites);
//			}
//
//
//			testng.run();
//
//			Thread.sleep(300);
//		}
//
//		catch(Exception e)
//
//		{
////			flag=false;
//			System.out.println(e);
//		}
//
//
//
//
//
//	}
	public void campEditing()
	{
		try
		{
			WebElement element = driver.findElement(By.xpath("//*[@class='glyphicon glyphicon-pencil']"));
		}
		catch(Exception e) {
			System.out.println("element not found");
			eflag=true;


		}

	}









}
