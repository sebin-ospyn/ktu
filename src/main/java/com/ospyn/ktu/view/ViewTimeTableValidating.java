package com.ospyn.ktu.view;

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

public class ViewTimeTableValidating extends SeleniumBase {
	FileInputStream fs;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
//	Robot robot=new Robot();
	public static	boolean flag=false;
public ViewTimeTableValidating(WebDriver driver) throws IOException
	{
		super(driver);
		// TODO Auto-generated constructor stub
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
public WebElement listTimeTableButton()
{
	WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='btn btn-warning btn-xs'])[2]")));
	return element;
}

public void validatingTimetable() {

	try {

//		xapth for revert button-if revert button is appear then it is confirm that time table is approved
		WebElement element= driver.findElement(By.xpath("//a[@title='Revert TimeTable']"));
		}
	catch(Exception e)
		{

		flag=true;
		}
}












}
