package com.ospyn.ktu.view;

import static org.junit.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.ospyn.ktu.util.SeleniumBase;

public class ViewFalseNumbergeneration extends SeleniumBase {

	public static boolean eflag=false;

	FileInputStream fs;
	XSSFWorkbook workbook;
	static XSSFSheet sheet,sheet1;



	public ViewFalseNumbergeneration(WebDriver driver) throws IOException

	{
		//initializing the driver
		super(driver);
		fs = new FileInputStream(new File(System.getProperty("user.dir")+"/Test_Data/PARAMETER_LISTING.xlsx"));
		//Getting the workbook
		workbook = new XSSFWorkbook(fs);
		//Getting the sheet
		sheet = workbook.getSheetAt(11);
		System.out.println(sheet.getRow(1).getCell(1).getStringCellValue());


	}
//*************************************************************************************

	public void Falsenumbergenerate() throws InterruptedException, AWTException {
	WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"65\"]/a")));
	element.click();
	Thread.sleep(2000);

	}

	public String ValidateText() throws InterruptedException {

		// get the error message

		String status = driver.findElement(By.xpath("//*[contains(text(),'False No/Bar Code Generation')]")).getText();

		Thread.sleep(500);

		return status;

	}

	public void Valuationmodule() throws InterruptedException, AWTException {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='10']/a")));
		element.click();
		Thread.sleep(2000);

		}
	public void Addbutton() throws InterruptedException, AWTException {
 		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"add\"]")));
		element.click();
		Thread.sleep(2000);

		}

	public void generatefalsenumber()
	{
		try
		{
		Thread.sleep(1000);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //*[@id=\"academicYearId\"]")));
		Select yeardropdown = new Select(element);
		//passing the Academic year
		yeardropdown.selectByVisibleText(sheet.getRow(1).getCell(1).getStringCellValue());
 		Thread.sleep(2000);

		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"programId\"]")));
		Select Programdropdown = new Select(element);
		//passing the Program
		Programdropdown.selectByVisibleText(sheet.getRow(2).getCell(1).getStringCellValue());
		Thread.sleep(2000);

		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"programType\"]")));
		Select Programtypedropdown = new Select(element);
		//passing the Program type
		Programtypedropdown.selectByVisibleText(sheet.getRow(3).getCell(1).getStringCellValue());
		Thread.sleep(2000);

		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"answerSheetCoverType\"]")));
		Select Barcodedropdown = new Select(element);
		//passing the Barcode type
		System.out.println(sheet.getRow(4).getCell(1).getStringCellValue().trim());
		Barcodedropdown.selectByVisibleText(sheet.getRow(4).getCell(1).getStringCellValue().trim());
		Thread.sleep(2000);

		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"examDefId\"]")));
		Select ExamDefinitiondropdown = new Select(element);
		//passing the Exam definition
		ExamDefinitiondropdown.selectByVisibleText(sheet.getRow(5).getCell(1).getStringCellValue());
		Thread.sleep(2000);
		// Saving false number generation details
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@id=\"answerSheetGenerateForm_save\"]")).click();
		}

		catch (Exception e)
		{
			e.printStackTrace();
		}
}

	public String Validatecreatedtext() throws InterruptedException
	{
		// get the error message
		String status = driver.findElement(By.xpath("//*[contains(text(),'Created')]")).getText();
		Thread.sleep(1000);
		return status;
	}
	public void ClickSave()
	{
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //*[@id=\"answerSheetGenerateForm_save\"]")));
		element.click();
 	}

	public String Validaterrortext() throws InterruptedException
	{
		// get the error message
		String status = driver.findElement(By.xpath("//*[contains(text(),'You must select a value for Exam Definition')]")).getText();
		Thread.sleep(500);
		return status;
	}

	public void Clickeditbutton() throws InterruptedException
	{
	// xpath for selecting edit button
	driver.findElement(By.xpath(" //*[@id=\"courseSel\"]")).click();
	Thread.sleep(2000);
	// xpath for selecting course all check box in pop up
	driver.findElement(By.xpath("  //*[@id=\"checkAll\"]")).click();
	// Thread.sleep(1000);
	// xpath for to save data in pop up
	driver.findElement(By.xpath("  //*[@id=\"submit\"]")).click();
	 Thread.sleep(1000);
	// xpath to close pop-up
	driver.findElement(By.xpath("  (//* [@class='close'])[9]")).click();
	Thread.sleep(1000);
	}

	public void Clickedapprove() throws InterruptedException
	{
	// xpath for selecting approve button
	driver.findElement(By.xpath("//*[@class='glyphicon glyphicon-ok']")).click();
	Thread.sleep(2000);
	// xpath for pop up yes button
	driver.findElement(By.xpath("(//*[@id=\"confirm\"]/..//*[@class=\"btn btn-sm btn-warning\"])[2]")).click();
	Thread.sleep(500);
	}
	public void Clickgenerate() throws InterruptedException, AWTException
	{
	// xpath for choosing generate barcode button
	driver.findElement(By.xpath("//*[@class=\"glyphicon glyphicon-cloud-upload\"]")).click();
	Thread.sleep(1000);
	// xpath for pop up yes button
	driver.findElement(By.xpath("(//*[@id='confirm'])[2]")).click();
	Thread.sleep(10000);

	Robot robot = new Robot();
	// Page refreshing/reloading code

	// Pressing the ctrl Key
	robot.keyPress(KeyEvent.VK_CONTROL);
	// Pressing the R Key
	robot.keyPress(KeyEvent.VK_R);
	Thread.sleep(500);

	// Releasing the R Key
	robot.keyRelease(KeyEvent.VK_R);
	// Releasing the ctrl Key
	robot.keyRelease(KeyEvent.VK_CONTROL);
	Thread.sleep(1000);
	}


	public void configurefalsenumber() throws InterruptedException, AWTException
	{
	Thread.sleep(700);
//	Click on button named configure false numbers
	WebElement element = driver.findElement(By.xpath("//*[@class='btn btn-success btn-xs pull-right']"));
	element.click();
	Thread.sleep(300);
//	Enter details on Pop-up
	element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='eventTypeId']")));
	Select eventTypedropdown = new Select(element);
//	passing
	eventTypedropdown.selectByVisibleText(sheet.getRow(4).getCell(1).getStringCellValue().trim());
	Thread.sleep(1000);
//	passing exam specific event
	element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='examSpecificEventId']")));
	Select ExamSpecificdropDown = new Select(element);
	ExamSpecificdropDown.selectByVisibleText(sheet.getRow(6).getCell(1).getStringCellValue());
	Thread.sleep(1000);
//	Passing password
	element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='password']")));
	element.sendKeys("pass1@");
	Thread.sleep(700);
	Robot robot = new Robot();
//Pressing the Enter Key
	robot.keyPress(KeyEvent.VK_ENTER);
//Releasing the Enter Key
	robot.keyRelease(KeyEvent.VK_ENTER);

//passing % count for additional false number
	element =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='additionsheetCountPercentFldId']")));
	element.clear();
	Thread.sleep(300);
	element.sendKeys("10");
	Thread.sleep(500);
 //Pressing the Enter Key
	robot.keyPress(KeyEvent.VK_ENTER);
//Releasing the Enter Key
	robot.keyRelease(KeyEvent.VK_ENTER);
//	Passing student registration status
	element =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='studentRegistrationStatus']")));
	Select dropdown = new Select (element);
	dropdown.selectByIndex(1);
	Thread.sleep(300);
//	click save button which is visible in pop-up
	element =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='additionalFalseNumberGenerationForm_Save']")));
	element.click();
	Thread.sleep(300);
	}

public void  eventValidating() throws InterruptedException, AWTException
	{
	Thread.sleep(300);
//	asserting  event type
	 String status = (sheet.getRow(4).getCell(1).getStringCellValue().trim());
	 System.out.println("status is " +status);
	 String event = driver.findElement(By.xpath("//*[@id=\"listingTable\"]/tbody/tr/td[1]")).getText();
	 System.out.println("event is " +event);
	 assertEquals(status,event);
	 }


public void  examSpecificevent() throws InterruptedException, AWTException
	{
 Thread.sleep(300);
//asserting  Specific exam event
 String status = (sheet.getRow(6).getCell(1).getStringCellValue().trim());
 System.out.println("status is  " +status);

 String specificExamEvent = driver.findElement(By.xpath("//*[@id=\"listingTable\"]/tbody/tr/td[2]")).getText();
 System.out.println("exam event is " +specificExamEvent);
 assertEquals(status,specificExamEvent);
	}
public void  falseNumberfrom() throws InterruptedException, AWTException
	{
 Thread.sleep(300);
// asserting  false number from
 String status = driver.findElement(By.xpath("//*[@id='falseNoFrom']")).getAttribute("value");
 status=status.replace(",", "");

 System.out.println(status);
 String specificExamEvent = driver.findElement(By.xpath("//*[@id='listingTable']/tbody/tr/td[5]")).getText();
 System.out.println("False number from " +specificExamEvent);
 assertEquals(status,specificExamEvent);
	}


public void courseSelection () throws InterruptedException
	{
	 Thread.sleep(300);

	WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Created')]//following::*[@id='courseSel']"));
	element.click();
	Thread.sleep(300);
//	xpath to check box for selecting courses
	element = driver.findElement(By.xpath("//*[@id='checkAll']"));
	element.click();
	Thread.sleep(300);
//	xpath for save button
	element = driver.findElement(By.xpath("//*[@id='submit']"));
	element.click();
	Thread.sleep(300);
//	xpath to close pop-up
	element = driver.findElement(By.xpath("//*[@id=\"courseSelDiv\"]/div[2]/div/div[1]/button/span"));
	element.click();
	Thread.sleep(300);
	}
public void requestapprove () throws InterruptedException {
	//*[contains(text(),'Created')]//following::a[1]
//	WebElement element = driver.findElement(By.xpath("//*[@class='btn btn-success btn-xs']"));
	WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Created')]//following::a[1]"));
	element.click();
	Thread.sleep(500);
	element = driver.findElement(By.xpath("(//*[@id='confirm'])[2]"));
	element.click();
	Thread.sleep(1000);


	}
public String validateStatus () throws InterruptedException
	{
	//xpath for a
	String status = driver.findElement(By.xpath("//*[@id='listingTable']/tbody/tr/td[8]")).getText();
	Thread.sleep(500);
	return status;
	}


public void generateBarcode() throws InterruptedException
	{
//	WebElement element = driver.findElement(By.xpath("//*[@id='listingTable']/tbody/tr/td[10]/a[1]"));
/**
 * Xpath for false number generate button
 */
	WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Created')]//following::a[1]"));
	element.click();
	Thread.sleep(300);
	element = driver.findElement(By.xpath("(//*[@id='confirm'])[2]"));
	element.click();
 	Thread.sleep(10000);
    driver.navigate().refresh();
	}
public String validatebarcodegenerated () throws InterruptedException
	{
	//xpath for status
	String status = driver.findElement(By.xpath("//*[@id='listingTable']/tbody/tr/td[8]")).getText();
	Thread.sleep(500);
	System.out.println(status);
	return status;
	}

public void generateZip() throws InterruptedException
	{
	WebElement element = driver.findElement(By.xpath("//*[@id='listingTable']/tbody/tr/td[10]/a[1]"));
	element.click();
	Thread.sleep(300);
	element = driver.findElement(By.xpath("(//*[@id='confirm'])[2]"));
	element.click();
 	Thread.sleep(10000);
    driver.navigate().refresh();
	}


public void serchingfalsenumber() throws InterruptedException {
	Thread.sleep(300);

	WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='searchForm_academicYearId']")));
	Select Yeardropdown = new Select(element);
	System.out.println(sheet.getRow(1).getCell(1).getStringCellValue());
	Yeardropdown.selectByVisibleText(sheet.getRow(1).getCell(1).getStringCellValue());
	Thread.sleep(300);

	element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='programId']")));
	Select programdropdown = new Select(element);
	programdropdown.selectByVisibleText(sheet.getRow(2).getCell(1).getStringCellValue());
	Thread.sleep(1000);

}

public void clickEdit() {

try {
	String cellvalue = (sheet.getRow(5).getCell(1).getStringCellValue());
	WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'"+cellvalue+"')]//following::a[1]")));
	element.click();
	}
catch (Exception e)
{
	e.printStackTrace();
}

}
public void Reconfigurefalsenumber() throws InterruptedException, AWTException
{
Thread.sleep(700);
//Click on button named configure false numbers
WebElement element = driver.findElement(By.xpath("//*[@class='btn btn-success btn-xs pull-right']"));
element.click();
Thread.sleep(300);
//Enter details on Pop-up
element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='eventTypeId']")));
Select eventTypedropdown = new Select(element);
//passing
eventTypedropdown.selectByVisibleText(sheet.getRow(4).getCell(1).getStringCellValue().trim());
Thread.sleep(1000);
//passing exam specific event
element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@id='examSpecificEventId'])[2]")));
Select ExamSpecificdropDown = new Select(element);
ExamSpecificdropDown.selectByVisibleText(sheet.getRow(6).getCell(1).getStringCellValue());
Thread.sleep(1000);
//Passing password
element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='password']")));
element.sendKeys("pass1@");
Thread.sleep(700);
Robot robot = new Robot();
//Pressing the Enter Key
robot.keyPress(KeyEvent.VK_ENTER);
//Releasing the Enter Key
robot.keyRelease(KeyEvent.VK_ENTER);

//passing % count for additional false number
element =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='additionsheetCountPercentFldId']")));
element.clear();
Thread.sleep(300);
element.sendKeys("10");
Thread.sleep(500);
//Pressing the Enter Key
robot.keyPress(KeyEvent.VK_ENTER);
//Releasing the Enter Key
robot.keyRelease(KeyEvent.VK_ENTER);
//Passing student registration status
element =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='studentRegistrationStatus']")));
Select dropdown = new Select (element);
dropdown.selectByIndex(1);
Thread.sleep(300);
//click save button which is visible in pop-up
element =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='additionalFalseNumberGenerationForm_Save']")));
element.click();
Thread.sleep(300);
}





//public void addOReditValuationcamp() {
//	try {
//		boolean eflag=false;
//
//		try {
//		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'"+(sheet.getRow(5).getCell(1).getStringCellValue())+"')]//following::a[1]"));
//		if(element.isDisplayed()) {
//			System.out.println("Elements contains a value");
//			eflag=true;
//		}
//		else {
//			System.out.println("Elements not contains a value");
//			eflag=false;
//		}
//
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		TestNG testng;
//		List<String> suites = Lists.newArrayList();
//		testng = new TestNG();
//		if (eflag) {
//
//			String suiteName = "src/main/resources/XMLEditFalseNumber.xml";
//
//			testng.setTestSuites(suites);
//			suites.add(suiteName);
//
//		} else {
//
//			String suiteName = "src/main/resources/XMLAddFalseNumber.xml";
//
//			testng.setTestSuites(suites);
//			suites.add(suiteName);
//
//		}
//
//
//		testng.run();
//
//		Thread.sleep(300);
//
//
//	}
//
//	catch(Exception e) {
//
//
//	}
//	}


public void addOReditValuationcamp() {
	try {
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'"+(sheet.getRow(5).getCell(1).getStringCellValue())+"')]//following::a[1]"));

		}



	catch(Exception e)
	{
		System.out.println("Element not found");
		eflag=true;
	}

}






























}









