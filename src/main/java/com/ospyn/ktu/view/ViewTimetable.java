package com.ospyn.ktu.view;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.ospyn.ktu.util.SeleniumBase;

public class ViewTimetable extends SeleniumBase{
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

	public ViewTimetable(WebDriver driver) throws Exception
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
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='academicYear']")));

		Select dropdown = new Select(element);

		////Selecting the Academic year
		System.out.println(sheet.getRow(1).getCell(1).getStringCellValue());
		dropdown.selectByVisibleText(sheet.getRow(1).getCell(1).getStringCellValue());


		Thread.sleep(2000);

		//Selecting the process description

		element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='programId']")));

		dropdown = new Select(element);

		//selecting program (B.Tech,M.Tech....)
		dropdown.selectByVisibleText(sheet.getRow(2).getCell(1).getStringCellValue());

		Thread.sleep(2000);



		//Selecting the program type

		element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='searchForm_programType']")));

		dropdown = new Select(element);

		dropdown.selectByVisibleText(sheet.getRow(3).getCell(1).getStringCellValue());


		Thread.sleep(2000);

		//Selecting the exam type
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='searchForm_examType']")));

		dropdown = new Select(element);


		dropdown.selectByVisibleText(sheet.getRow(4).getCell(1).getStringCellValue());

		Thread.sleep(2000);
		//entering part of exam definition
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='searchForm_definitionName']")));

		element.sendKeys(sheet.getRow(5).getCell(1).getStringCellValue());
		Thread.sleep(2000);


	}
	public WebElement listTimeTableButton()
	{
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//a[@class='btn btn-warning btn-xs'])[2]")));
		return element;
	}
	public WebElement viewButton()
	{
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//a[@class='btn btn-warning btn-xs'])[1]")));
		return element;
	}

	public WebElement viewTimeTableButton()
	{
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//a[@class='btn btn-warning btn-xs'])[1]")));
		return element;
	}

	public void registrationAllowedCourses(String eventName)throws Exception
	{
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a[contains(text(),'Registration Allowed Courses')]")));
		element.click();

		element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.id("specificEventId")));

		Select dropDown=new Select(element);
		dropDown.selectByVisibleText(eventName);
		Thread.sleep(1000);
		Map<String,String> courseDetails=new HashMap<String,String>();
		List<WebElement> courses=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy
				(By.xpath("//table[@id='registrationCourseTable']//tr")));

		for(int i=1;i<=courses.size();i++)
		{
			String courseName=wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//table[@id='registrationCourseTable']//tr["+i+"]//td[1]"))).getText();
			String slot=wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//table[@id='registrationCourseTable']//tr["+i+"]//td[3]"))).getText();

			courseDetails.put(courseName, slot);

		}

		for (String name: courseDetails.keySet()) {
			String key = name.toString();
			String value = courseDetails.get(name).toString();
			System.out.println(key + " " + value);
		}

	}

	public WebElement getEditButton()
	{
		ViewTimetable.eventName=eventName;
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//td[text()='"+sheet.getRow(6).getCell(1).getStringCellValue()+"']//following::a[1]")));
		return element;
	}

	//clicking Revert button
	public void clickRevert() throws Exception
	{
		String eventName=sheet.getRow(6).getCell(1).getStringCellValue();
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//td[text()='"+eventName+"']//following::a[4]")));

		element.click();

		Thread.sleep(500);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	public void enterTimetableDetails()throws Exception
	{

		//Selecting the semester
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.id("examTimeTableForm_semester")));

		Select dropdown = new Select(element);


		dropdown.selectByIndex(1);

		Thread.sleep(2000);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.id("examEventId")));
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
			//selecting semester
			dropdown = new Select(semester);

			dropdown.selectByIndex(1);

			Thread.sleep(2000);


			element=wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("(//*[@id='course'])["+i+"]")));
			element.clear();

			//entering exam Date
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("(//input[@name='examDate'])["+i+"]")));

			//incrementing date by 1
			startExamDate=startExamDate.plusDays(1);

			//changing date format to dd/mm/yyyy
			element.clear();
			Thread.sleep(1000);
			element.sendKeys(europeanDateFormatter.format(startExamDate));

			Thread.sleep(1000);
			element.sendKeys(Keys.ENTER);

			//entering time
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("(//input[@name='fromTime'])["+i+"]")));
			element.clear();

			element.sendKeys("10:00 am");
			i++;

		}

		Iterator iterator=slots.iterator();

		while(iterator.hasNext())
		{
			String slot=(String) iterator.next();
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("(//label[text()='"+slot+"']//following::input[@type='checkbox'])[1]")));
			((RemoteWebDriver) driver).executeScript("arguments[0].click();", element);
		}


	}
	public void viewSavedTimetable()

	{

		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//td[text()='"+examName+"']//following::a[2]")));
		element.click();
	}

	public String validateSaved()
	{
		String text=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//h3[@class='panel-title'][2]"))).getText();
		return text;

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
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//button[@id='confirm' and text()='Yes'])[2]")));
		element.click();


	}


	public void clickEditTimetable()
	{

		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//td[text()='"+examName+"']//following::a[1]")));
		element.click();
	}
	public void editTimeTable()
	{

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//input[@id='examDate0']")));
		startExamDate = LocalDate.now().plusDays(5);
		element.sendKeys(europeanDateFormatter.format(startExamDate));
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//input[@id='examDate1']")));

		startExamDate = LocalDate.now().plusDays(1);
		element.sendKeys(europeanDateFormatter.format(startExamDate));

		element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//input[@id='fromTime0']")));

		element.sendKeys("11:00 am");

		element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//input[@id='fromTime1']")));

		element.sendKeys("11:00 am");

	}
	public void editTimeTableTwoSlots(int id)throws Exception
	{

		//clicking Add button
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a[@id='add0']")));

		element.click();
		Thread.sleep(1000);

		String examDate="7/12/2023";
		Select dropDown;

		if(id==1 || id==2)
		{

			//Selecting Semester
			element = driver.findElement(By.xpath("//select[@id='semesterId0']"));
			dropDown=new Select(element);
			dropDown.selectByIndex(1);


			//Entering the course
			element = driver.findElement(By.xpath("//input[@id='course0']"));
			element.sendKeys("MUT307-AUTO TRANSMISSION");
			Thread.sleep(1000);



		}
		if(id==1)
		{


			element = driver.findElement(By.xpath("//input[@id='course1']"));
			element.sendKeys("MUT307-AUTO TRANSMISSION)");

			//Getting exam date from the first slot
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//input[@id='examDate0']")));
			examDate=element.getAttribute("value");

			System.out.println(examDate);

			Thread.sleep(1000);



		}



		//Getting date from first exam slot
		element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//input[@id='examDate1']")));
		element.sendKeys(examDate);

		Thread.sleep(1000);


		//setting time for newly added slot
		element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//input[@id='fromTime1']")));

		if(id==1)
		{
			element.sendKeys("10:00");
		}

		else if (id==2)
		{
			element.sendKeys("11:00");


		}


		Thread.sleep(1000);



	}


	public void editTimeTableThreeSlots()throws Exception
	{

		//clicking Add button
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a[@id='add0']")));

		element.click();

		element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a[@id='add0']")));

		element.click();

		element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='course0']")));
		element.clear();
		Thread.sleep(1000);

		element.sendKeys("MUT305-VEHICLE DYNAMICS");
		Thread.sleep(1000);


		element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='course1']")));
		element.clear();
		Thread.sleep(1000);



		element.sendKeys("MPT301-THEORY OF MACHINES");
		Thread.sleep(1000);


		element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='course2']")));
		element.clear();
		Thread.sleep(1000);

		element.sendKeys("BMT307-SOFT COMPUTING TECHNIQUES");
		Thread.sleep(1000);


		element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//input[@id='examDate0']")));
		String examDate=element.getAttribute("value");

		System.out.println(examDate);

		Thread.sleep(1000);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//input[@id='fromTime0']")));
		String examTime=element.getAttribute("value");

		System.out.println(examDate);

		Thread.sleep(1000);

		//Setting date for newly added slot which is same as first slot
		element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//input[@id='examDate1']")));
		element.sendKeys(examDate);

		Thread.sleep(1000);

		element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//input[@id='examDate2']")));
		element.sendKeys(examDate);

		Thread.sleep(1000);


		//setting time for newly added slot 1
		element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//input[@id='fromTime1']")));
		element.sendKeys(examTime);

		Thread.sleep(1000);

		//setting time for newly added slot 2
		element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//input[@id='fromTime2']")));
		element.sendKeys(examTime);


	}
	public void enterCoursesInSlots()throws Exception
	{


		//Selecting the exam definition
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.id("examEventId")));
		Select dropdown = new Select(element);

		element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.id("course")));
		element.clear();
		Thread.sleep(1000);
		element.sendKeys("programming");
		Thread.sleep(1000);
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		//

	}

	public String validateSaveError()
	{
		driver.navigate().refresh();
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a[@class='btn btn-xs btn-danger']")));
		return element.getText();
	}

	public void courseDuplicate()throws Exception
	{
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.id("course")));
		element.clear();
		Thread.sleep(1000);
		element.sendKeys("programming");
		Thread.sleep(1000);

		Robot robot=new Robot();

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);


		element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.id("add0")));
		element.click();


		element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.id("examDate0")));
		element.clear();
		startExamDate = LocalDate.now().plusDays(5);
		element.sendKeys(europeanDateFormatter.format(startExamDate));
		Thread.sleep(1000);

		element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.id("fromTime0")));
		element.clear();
		element.sendKeys("10:00 am");

		element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='course1']")));
		element.clear();
		Thread.sleep(1000);
		element.sendKeys("programming");
		Thread.sleep(1000);

		robot=new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.id("examDate1")));
		element.clear();
		startExamDate = LocalDate.now().plusDays(6);
		element.sendKeys(europeanDateFormatter.format(startExamDate));
		Thread.sleep(1000);

		element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.id("fromTime1")));
		element.clear();
		element.sendKeys("10:00 am");


	}

	public void courseBlank()throws Exception
	{
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.id("course")));
		element.clear();
		Thread.sleep(1000);
		element.sendKeys("programming");
		Thread.sleep(1000);

		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);


		element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.id("add0")));
		element.click();
		//
		element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.id("examDate0")));
		element.clear();
		startExamDate = LocalDate.now().plusDays(5);
		element.sendKeys(europeanDateFormatter.format(startExamDate));
		Thread.sleep(1000);

		element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.id("fromTime0")));
		element.clear();
		element.sendKeys("10:00 am");

		element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.id("examDate1")));
		element.clear();
		startExamDate = LocalDate.now().plusDays(6);
		element.sendKeys(europeanDateFormatter.format(startExamDate));
		Thread.sleep(1000);

		element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.id("fromTime1")));
		element.clear();
		element.sendKeys("10:00 am");


	}
	public String validateDuplicate()
	{
		String msg=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='alert alert-danger col-sm-12']"))).getText();
		return msg;
	}

	public void coursesCommon(String course)throws Exception
	{
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.id("examEventId")));
		Select dropdown = new Select(element);


		//dropdown.selectByIndex(1);
		examName=dropdown.getFirstSelectedOption().getText();

		List<WebElement> semesters=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("semesterId")));
		//variable used for increment while getting the xpath of text boxes of time and date
		int i=1;
		startExamDate = LocalDate.now().plusDays(9);

		for(WebElement semester:semesters)
		{
			//selecting semester
			dropdown = new Select(semester);

			dropdown.selectByIndex(1);

			Thread.sleep(2000);


			element=wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("(//*[@id='course'])["+i+"]")));
			element.clear();
			if(i==4 || i==5)
			{
				element.sendKeys(course);
			}

			//entering exam Date
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("(//input[@name='examDate'])["+i+"]")));
			if(element.getAttribute("readonly")==null)
			{

				//incrementing date by 1
				startExamDate=startExamDate.plusDays(1);
				System.out.println(startExamDate);

				//changing date format to dd/mm/yyyy
				element.clear();
				Thread.sleep(1000);
				element.sendKeys(europeanDateFormatter.format(startExamDate));
				element.sendKeys(Keys.ESCAPE);
			}

			//entering time
			if(element.getAttribute("readonly")==null)
			{

				element = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("(//input[@name='fromTime'])["+i+"]")));
				element.clear();
				element.sendKeys("10:00 am");
				if(i==5)
				{
					element.sendKeys("11:00 am");
				}
			}

			i++;

		}
	}
	public void courseScheduledByCollegeSlotA()throws Exception
	{
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//*[@id='isScheduledByCollege'])[1]")));
		element.click();
		Thread.sleep(1000);

	}

	public String validateError()throws Exception
	{
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='alert alert-danger col-sm-12']")));
		return element.getText();
	}

	public void courseScheduledByCollegeSlotS()throws Exception
	{
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//*[@id='isScheduledByCollege'])[9]")));
		element.click();
		Thread.sleep(1000);

	}

	public void enterCourse()throws Exception
	{
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='course']")));
		element.sendKeys("MUT307-AUTO TRANSMISSION");
	}



	public void copyTimetable()throws Exception
	{
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a[text()='Copy TimeTable']")));

		element.click();
		Thread.sleep(1000);
		element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.id("copyToEvent")));

		Select dropDown=new Select(element);
		dropDown.selectByIndex(1);
		examName=dropDown.getFirstSelectedOption().getText();

		Thread.sleep(1000);

		element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//button[@id='saveButton']")));
		element.click();

		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}
	public String validateCopy()
	{

		String msg="";
		try
		{
			Thread.sleep(1000);
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[text()='"+examName+"']")));
			if(element.isDisplayed())
			{
				msg="pass";
			}
		}

		catch(Exception e)
		{
			msg="fail";
		}
		return msg;
	}

	public void clickAbsenteeDeleteButton()throws Exception
	{
		 WebElement element=driver.findElement(By.xpath("//a[@data-original-title='Delete']"));
		 element.click();

		 Thread.sleep(1000);

		 element=driver.findElement(By.xpath("//button[@name='delete']"));
		 element.click();




	}

	public WebElement clickAbsenteeButton()
	{
		 WebElement element=driver.findElement(By.xpath("(//a[@title='Enter Absentees'])[2]"));
		 return element;
	}

	public void enterAbsentee()throws Exception
	{

		WebElement element=driver.findElement(By.xpath("//input[@value='Type and choose a student']"));
		 element.click();
		 Thread.sleep(1000);
		 robot.keyPress(KeyEvent.VK_ENTER);
		 robot.keyRelease(KeyEvent.VK_ENTER);

		 element=driver.findElement(By.xpath("//input[@id='noAbsentees']"));

		 if(element.isSelected())
			 element.click();

		 Thread.sleep(1000);

	}

	public void clickSaveButton()throws Exception
	{
		WebElement element=driver.findElement(By.xpath("//button[@id='absenteesForm_save']"));
		 element.click();
		 Thread.sleep(1000);
	}

	public void coursesInDifferentSlots()throws Exception
	{
		Robot robot=new Robot();
		startExamDate = LocalDate.now().plusDays(10);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.id("add1")));
		element.click();
		Thread.sleep(1000);
		element.click();

		element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//input[@name='course'])[2]")));
		element.sendKeys("PHT100");
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//input[@name='examDate'])[2]")));
		element.sendKeys(europeanDateFormatter.format(startExamDate));
		Thread.sleep(1000);

		element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//input[@name='fromTime'])[2]")));
		element.sendKeys("10:00am");


		element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//input[@name='course'])[3]")));
		element.sendKeys("PHT110");
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//input[@name='examDate'])[3]")));
		element.sendKeys(europeanDateFormatter.format(startExamDate));
		Thread.sleep(1000);

		element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//input[@name='fromTime'])[3]")));
		element.sendKeys("10:00am");

		element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//input[@name='course'])[4]")));
		element.sendKeys("CYT100");
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//input[@name='examDate'])[4]")));
		element.sendKeys(europeanDateFormatter.format(startExamDate));
		Thread.sleep(1000);

		element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//input[@name='fromTime'])[4]")));
		element.sendKeys("10:00am");



	}
	public void S1S2Exam()throws Exception
	{

		List<WebElement> semesters=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("semesterId")));
		//variable used for increment while getting the xpath of text boxes of time and date
		int i=1;
		startExamDate = LocalDate.now().plusDays(9);
		WebElement element;

		for(WebElement semester:semesters)
		{

			element=wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("(//*[@id='course'])["+i+"]")));
			element.clear();

			//entering exam Date
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("(//input[@name='examDate'])["+i+"]")));

			//incrementing date by 1
			startExamDate=startExamDate.plusDays(1);
			System.out.println(startExamDate);

			//changing date format to dd/mm/yyyy
			element.clear();
			Thread.sleep(1000);
			element.sendKeys(europeanDateFormatter.format(startExamDate));
			element.sendKeys(Keys.ESCAPE);

			//entering time
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("(//input[@name='fromTime'])["+i+"]")));
			element.clear();

			element.sendKeys("10:00 am");
			i++;

		}


	}

	public void clickRegistrationAllowedCourses()
	{
		//clicking the registration allowed courses link
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a[contains(text(),'Registration Allowed Courses ')]")));
		element.click();

	}

	public void enterExamName(String examName)throws Exception
	{
		//entering the exam name in the drop down box
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.id("specificEventId")));

		Select dropDown=new Select(element);
		dropDown.selectByVisibleText(examName);

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

		//		Switching to parent frame to close the iframe
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


}
