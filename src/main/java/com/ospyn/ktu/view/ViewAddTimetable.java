package com.ospyn.ktu.view;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.ospyn.ktu.util.SeleniumBase;

public class ViewAddTimetable extends SeleniumBase {

	static String examName="";
	static String eventName="";
	public static ArrayList<String> list=new ArrayList<String>();
	public static HashSet<String> slots=new HashSet<String>();
	String europeanDatePattern = "dd-MM-yyyy";
	DateTimeFormatter europeanDateFormatter;
	LocalDate startExamDate;
	FileInputStream fs;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	Robot robot=new Robot();
	public ViewAddTimetable(WebDriver driver) throws Exception
	{
	super(driver);
	europeanDateFormatter= DateTimeFormatter.ofPattern(europeanDatePattern);
	startExamDate = LocalDate.now();
	fs = new FileInputStream(new File(System.getProperty("user.dir")+"/Test_Data/PARAMETER_LISTING.xlsx"));
	//Getting the workbook
	workbook = new XSSFWorkbook(fs);
	//Getting the sheet
	sheet = workbook.getSheetAt(6);
 	}
	public void enterDetails()throws Exception
	{
		System.out.println("within enterDetails");

		//selecting academic year
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='academicYear']")));

		Select dropdown = new Select(element);
		//Selecting the Academic year
		System.out.println(sheet.getRow(1).getCell(1).getStringCellValue());
		dropdown.selectByVisibleText(sheet.getRow(1).getCell(1).getStringCellValue());
		Thread.sleep(2000);
		//Selecting the process description
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='programId']")));
		dropdown = new Select(element);

		//selecting program (B.Tech,M.Tech....)
		dropdown.selectByVisibleText(sheet.getRow(2).getCell(1).getStringCellValue());
		Thread.sleep(2000);
		//Selecting the program type

		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='searchForm_programType']")));

		dropdown = new Select(element);

		dropdown.selectByVisibleText(sheet.getRow(3).getCell(1).getStringCellValue());


		Thread.sleep(2000);

		//Selecting the exam type
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='searchForm_examType']")));

		dropdown = new Select(element);


		dropdown.selectByVisibleText(sheet.getRow(4).getCell(1).getStringCellValue());

		Thread.sleep(2000);
		//entering part of exam definition
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='searchForm_definitionName']")));

		element.sendKeys(sheet.getRow(5).getCell(1).getStringCellValue());
		Thread.sleep(2000);


	}

	public WebElement viewButton()
	{
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='btn btn-warning btn-xs'])[1]")));
		return element;
	}
	public void clickRegistrationAllowedCourses()
	{
		//clicking the registration allowed courses link
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Registration Allowed Courses ')]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
//		element.click();

	}
	public void enterExamName()throws Exception
	{
		//entering the exam name in the drop down box
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.id("specificEventId")));

		Select dropDown=new Select(element);
		dropDown.selectByVisibleText(sheet.getRow(6).getCell(1).getStringCellValue());
		Thread.sleep(1000);

		//getting the window Handle name
		String windowHandle=driver.getWindowHandle();

		//clicking the View/Do More button
		element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a[text()='View/Do More...']")));
		element.click();
		Thread.sleep(1000);

		//switching to iframe
		driver.switchTo().frame(0);
		findSlots();
		Thread.sleep(2000);

		//Switching to parent frame to close the iframe
		driver.switchTo().parentFrame();
		WebElement allowedCoursePopupclose=driver.findElement(By.xpath("//*[@class='fancybox-item fancybox-close']"));

		allowedCoursePopupclose.click();
		Thread.sleep(1000);

		//Refreshing the page
		driver.navigate().refresh();


	}
	public void findSlots()
	{
		System.out.println(driver.findElement(By.id("semesterId")).getText());

		List<WebElement> elements=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				By.xpath("//td[text()='External Lab Evaluation' or text='Evaluation By College Faculty']/../td[3]")));

		System.out.println("elements are"+elements.size());



		for(WebElement element:elements)
		{
			slots.add(element.getText());
		}

	}
	public WebElement listTimeTableButton()
	{
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='btn btn-warning btn-xs'])[2]")));
		return element;
	}
	public void enterTimetableDetails()throws Exception
	{

		//Selecting the semester
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("examTimeTableForm_semester")));

		Select dropdown = new Select(element);
		dropdown.selectByIndex(1);

		Thread.sleep(2000);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("examEventId")));
		dropdown = new Select(element);
		List<WebElement> exam=dropdown.getOptions();
		examName=exam.get(1).getText();
		dropdown.selectByIndex(1);
		Thread.sleep(1000);



		//System.out.println(dropdown.getFirstSelectedOption().getText());

		List<WebElement> semesters=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("semesterId")));
		//variable used for increment while getting the xpath of text boxes of time and date
		int i=1;
		startExamDate = LocalDate.now().minusDays(15);


		for(WebElement semester:semesters)
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			//selecting semester
			dropdown = new Select(semester);

			dropdown.selectByIndex(1);

			Thread.sleep(2000);


			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@id='course'])["+i+"]")));
			element.clear();

			//entering exam Date
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@name='examDate'])["+i+"]")));

			//incrementing date by 1
			startExamDate=startExamDate.plusDays(1);

			//changing date format to dd/mm/yyyy
			element.clear();
			Thread.sleep(1000);
			element.sendKeys(europeanDateFormatter.format(startExamDate));

			Thread.sleep(1000);
			element.sendKeys(Keys.ENTER);

			//entering time
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@name='fromTime'])["+i+"]")));
			element.clear();

			element.sendKeys("10:00 am");
			i++;

		}

		Iterator iterator=slots.iterator();

		while(iterator.hasNext())
		{
			String slot=(String) iterator.next();
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//label[text()='"+slot+"']//following::input[@type='checkbox'])[1]")));
			((RemoteWebDriver) driver).executeScript("arguments[0].click();", element);
		}


	}
	public void clickSaveButton()throws Exception
	{
		WebElement element=driver.findElement(By.xpath("//button[@id='absenteesForm_save']"));
		 element.click();
		 Thread.sleep(1000);
	}
	public void viewSavedTimetable()

	{

		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='"+examName+"']//following::a[2]")));
		element.click();
	}
	public String validateSaved()
	{
		String text=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//h3[@class='panel-title'][2]"))).getText();
		return text;

	}
	public void clickEditTimetable()
	{

		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='"+examName+"']//following::a[1]")));
		element.click();
	}
	public void editTimeTable() throws AWTException, InterruptedException
	{
 		Robot robot=new Robot();

//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='examDate0']")));
		startExamDate = LocalDate.now().plusDays(5);
 		element.sendKeys(europeanDateFormatter.format(startExamDate));
 		Thread.sleep(300);


		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='examDate1']")));
		startExamDate = LocalDate.now().plusDays(1);
 		element.sendKeys(europeanDateFormatter.format(startExamDate));


		element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//input[@id='fromTime0']")));
		element.sendKeys("11:00 am");

		element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//input[@id='fromTime1']")));
		element.clear();
		element.sendKeys("11:00 am");

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
 		Thread.sleep(300);

	}
	public void generateTimeTable()throws Exception
	{
		//using enter key to press yes button for Timetable generation
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);


		try
		{

			Thread.sleep(3000);
			while(wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//div[@class='alert alert-info ']"))).isDisplayed())
			{
				Thread.sleep(3000);
				driver.navigate().refresh();
			}
		}

		catch(Exception e)
		{

		}


	}
	public void approveTimeTable()
	{
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@id='confirm' and text()='Yes'])[2]")));
		//element.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);


	}











}
