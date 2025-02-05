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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.ospyn.ktu.util.SeleniumBase;

public class ViewEditingvaluationcamp extends SeleniumBase{
	FileInputStream fs;
	XSSFWorkbook workbook;
	static XSSFSheet sheet,sheet1;

 	public   ViewEditingvaluationcamp(WebDriver driver) throws IOException {
		// TODO Auto-generated constructor stub
		//initializing the driver
		super(driver);

 				fs = new FileInputStream(new File(System.getProperty("user.dir")+"/Test_Data/PARAMETER_LISTING.xlsx"));
				//Getting the workbook
				workbook = new XSSFWorkbook(fs);
				//Getting the sheet
				sheet = workbook.getSheetAt(9);
				System.out.println(sheet.getRow(1).getCell(1).getStringCellValue());
	}

	String centreName;
	private String testValue;
	private String resultValue;
	public void campSearching() throws AWTException, InterruptedException
	{
//		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='valuationCampForm_campName']")));
//		element.sendKeys(sheet.getRow(4).getCell(1).getStringCellValue());
//		Thread.sleep(300);
//		Robot robot = new Robot();
//
//		robot.keyPress(KeyEvent.VK_ENTER);
//	 	robot.keyRelease(KeyEvent.VK_ENTER);

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

	public void campEditing()
	{

		try
		{
//			Xpath for edit button-If edit button is displayed,then click on it and add other colleges

			WebElement element= driver.findElement(By.xpath("//*[@class='glyphicon glyphicon-pencil']"));
			element.click();
			Thread.sleep(300);
			Robot robot = new Robot();

//			Passing Member's providing Examiners,3rd college
			element = driver.findElement(By.xpath("//input[@value='Select the member colleges providing examiners']"));
			element.click();
			System.out.println(sheet.getRow(12).getCell(1).getStringCellValue());
			element.sendKeys(sheet.getRow(12).getCell(1).getStringCellValue());
		 	Thread.sleep(300);
		 	robot.keyPress(KeyEvent.VK_ENTER);
		 	robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(500);

//			Passing Member's providing Examiners,3rd college
			WebElement delement = driver.findElement(By.xpath("//input[@value='Select the member colleges providing examiners']"));
			delement.click();
			System.out.println(sheet.getRow(12).getCell(2).getStringCellValue());
			delement.sendKeys(sheet.getRow(12).getCell(2).getStringCellValue());
		 	Thread.sleep(300);
		 	robot.keyPress(KeyEvent.VK_ENTER);
		 	robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(500);

//			Passing Member's providing Answer sheets,4th College
			element = driver.findElement(By.xpath("//input[@value='Select the member colleges providing answer sheets']"));
			element.click();
			System.out.println(sheet.getRow(13).getCell(1).getStringCellValue());
			element.sendKeys(sheet.getRow(13).getCell(1).getStringCellValue());
		 	Thread.sleep(300);
		 	robot.keyPress(KeyEvent.VK_ENTER);
		 	robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(500);

//			Passing Member's providing Answer sheets,4th College
			element = driver.findElement(By.xpath("//input[@value='Select the member colleges providing answer sheets']"));
			element.click();
			System.out.println(sheet.getRow(13).getCell(2).getStringCellValue());
			element.sendKeys(sheet.getRow(13).getCell(2).getStringCellValue());
		 	Thread.sleep(300);
		 	robot.keyPress(KeyEvent.VK_ENTER);
		 	robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(500);

 			WebElement saveButton = driver.findElement(By.xpath("//*[@id='valuationCampForm_submit']"));
			saveButton.click();
			Thread.sleep(300);



		}

		catch(Exception e)

		{
 			System.out.println(e);
		}





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

//		Passing Academic Year
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='academicYearId']")));
		Select Yeardrpdown= new Select(element);
		Yeardrpdown.selectByVisibleText(sheet.getRow(2).getCell(1).getStringCellValue());
		Thread.sleep(500);

//		Passing Exam
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='examDefinitionId']")));
		Select Exam= new Select(element);
		Exam.selectByVisibleText(sheet.getRow(3).getCell(1).getStringCellValue());
		Thread.sleep(500);

//		Passing Valuation Camp Center
		element = driver.findElement(By.xpath("//*[@id='valuationCampCentre']"));
		element.sendKeys(sheet.getRow(4).getCell(1).getStringCellValue());
		Thread.sleep(500);

			Robot robot = new Robot();
		//	Pressing the Enter Key
			robot.keyPress(KeyEvent.VK_ENTER);
		//	Releasing the Enter Key
			robot.keyRelease(KeyEvent.VK_ENTER);

//			Passing Valuation Camp Officer
			element = driver.findElement(By.xpath("//*[@id='valuationCampForm_campAdmin']"));
			element.click();
			element.sendKeys("K");
			Thread.sleep(2000);
		//	Pressing the Enter Key
			robot.keyPress(KeyEvent.VK_ENTER);
		//	Releasing the Enter Key
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(500);

//			Passing month
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='valuationCampForm_month']")));
			Select Month= new Select(element);
			Month.selectByVisibleText(sheet.getRow(5).getCell(1).getStringCellValue());
			Thread.sleep(500);

//			Passing Year
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='valuationCampForm_year']")));
			Select Year= new Select(element);
	 		Year.selectByVisibleText(sheet.getRow(6).getCell(1).getRawValue());
			Thread.sleep(500);

//			Passing From date
			element = driver.findElement(By.xpath("//*[@id='valuationCampForm_fromDate']"));
			element.sendKeys(sheet.getRow(7).getCell(1).getRawValue());
			Thread.sleep(500);
			//Pressing the Enter Key
			robot.keyPress(KeyEvent.VK_ENTER);
			//Releasing the Enter Key
			robot.keyRelease(KeyEvent.VK_ENTER);

//			Passing To Date
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
	public void checkBox()
	{
		WebElement element = driver.findElement(By.xpath("//*[@id='chiefEnabled']"));
		element.click();
	}
	public void answesheetsExaminers() throws AWTException, InterruptedException
	{
		try {
		Robot robot = new Robot();
//		Passing Member's providing Examiners,First college
		WebElement element = driver.findElement(By.xpath("//input[@value='Select the member colleges providing examiners']"));
		element.click();
		System.out.println(sheet.getRow(9).getCell(1).getStringCellValue());
		element.sendKeys(sheet.getRow(9).getCell(1).getStringCellValue());
	 	Thread.sleep(300);
	 	robot.keyPress(KeyEvent.VK_ENTER);
	 	robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(500);

//		Passing Member's providing Examiners,Second college
		WebElement delement = driver.findElement(By.xpath("//input[@value='Select the member colleges providing examiners']"));
		delement.click();
		System.out.println(sheet.getRow(9).getCell(2).getStringCellValue());
		delement.sendKeys(sheet.getRow(9).getCell(2).getStringCellValue());
	 	Thread.sleep(300);
	 	robot.keyPress(KeyEvent.VK_ENTER);
	 	robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(500);

//		Passing Member's providing Answer sheets,First College
		element = driver.findElement(By.xpath("//input[@value='Select the member colleges providing answer sheets']"));
		element.click();
		System.out.println(sheet.getRow(10).getCell(1).getStringCellValue());
		element.sendKeys(sheet.getRow(10).getCell(1).getStringCellValue());
	 	Thread.sleep(300);
	 	robot.keyPress(KeyEvent.VK_ENTER);
	 	robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(500);

//		Passing Member's providing Answer sheets,Second College
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
public void saveCamp() throws InterruptedException {
		Thread.sleep(300);
		WebElement saveButton = driver.findElement(By.xpath("//*[@id='valuationCampForm_submit']"));
		saveButton.click();
		Thread.sleep(500);
	}
public void campStatus() throws InterruptedException, AWTException
{
	WebElement element = driver.findElement(By.xpath(" //*[@id='checkAll']"));
	element.click();
	Thread.sleep(300);
//	Passing Camp status
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



}
