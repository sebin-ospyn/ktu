package com.ospyn.ktu.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.ospyn.ktu.util.SeleniumBase;

public class ViewHallTicketGeneration extends SeleniumBase{

	@FindBy(xpath = "//a[@href='/university/eu/exm/viewInstitutionBranches.htm']")
	WebElement ExamHallTicket;

	@FindBy(xpath = "(//*[text()= ' View Time Table/Hall Ticket'])[1]")
	WebElement ViewHallTicket;

	@FindBy(xpath = "//*[@id=\"generateHallTicket\"]")
	WebElement genHallTicket;

	@FindBy(xpath = "(//*[@class=\"btn btn-danger btn-xs pull-right\"])[2]")
	WebElement exportHallTicket;

	@FindBy(xpath = "//*[@id=\"hallTicketLink\"]")
	WebElement downloadHallTicket;

	@FindBy(xpath = "(//*[text()= 'Download Hall Ticket'])[1]")
	WebElement downloadHallTicketStudent;

	@FindBy(xpath = "//*[contains(text(),'TVE17CE-P019')]/..//td[6]//span[contains(text(),'Download Hall Ticket')]")
	WebElement downloadHallTicketwithStudent;

	@FindBy(xpath = "//*[text()= 'Appearing Student List']")
	WebElement appearingStudentList;

	@FindBy(xpath = "//*[text()= 'University']")
	WebElement University;

	@FindBy(xpath = "//*[text()= 'Examinations']")
	WebElement Examinations;

	@FindBy(xpath = "//a[text()='Exam Time Table/Hall Ticket']")
	WebElement hallTicket;

	@FindBy(xpath = "//*[text()=\"B.Tech S5 (PT) (S,FE) Exam Jan 2023 (2015 scheme)\"]/..//a[3]")
	WebElement eligibilityStudent;

	@FindBy(xpath = "//*[text()= 'Student Exam Eligibility']")
	WebElement StudentExamEligibility;


	public static  String  branch;
	public static String Branch;
	public static Object[] branchNames;
	static WebElement element;




	FileInputStream fs;
	XSSFWorkbook workbook;
	static XSSFSheet sheet,sheet1;





	public ViewHallTicketGeneration(WebDriver driver) throws IOException
	{
		super(driver);

		fs = new FileInputStream(new File(System.getProperty("user.dir")+"/Test_Data/PARAMETER_LISTING.xlsx"));


		//Getting the workbook
		workbook = new XSSFWorkbook(fs);
		//Getting the sheet
		sheet = workbook.getSheetAt(7);
		System.out.println(sheet.getRow(1).getCell(1).getStringCellValue());

	}

	public void examHallTicketGeneration() throws InterruptedException
	{

//		List<String> params= new ArrayList<>();
//		params = Arrays.asList(examDetails.split(",#"));
		Thread.sleep(500);

		//xpath of Academic Year Dropdown
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"academicYearId\"]")));
		Select yearDropdown = new Select(element);
		//passing the Academic year
//		yearDropdown.selectByVisibleText(params.get(0));
		yearDropdown.selectByVisibleText(sheet.getRow(1).getCell(1).getStringCellValue());


		//xpath of Program
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='program']")));
		Select prgrmdropdown = new Select(element);
		//passing the Program
		prgrmdropdown.selectByVisibleText(sheet.getRow(2).getCell(1).getStringCellValue());
//		dropdown.selectByVisibleText(params.get(1));

		//xpath of Program Type
		element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='branchListingForm_programType']")));
		Select prgrmTypedropdown = new Select(element);
		//passing the Program Type
// 		dropdown.selectByVisibleText(params.get(2));
		prgrmTypedropdown.selectByVisibleText(sheet.getRow(3).getCell(1).getStringCellValue());
		Thread.sleep(500);

		//xpath of Exam Definition
		element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='examDefinition']")));
		Select examDefdropdown = new Select(element);

		//passing the Exam Definition
//		examDefdropdown.selectByVisibleText(params.get(3));
		examDefdropdown.selectByVisibleText(sheet.getRow(4).getCell(1).getStringCellValue());

	}

	public void viewTimeTable() throws InterruptedException
	{
		Thread.sleep(300);

		//xpath of Exam Registration Type
	    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='examEventType']")));
	    Select dropdown = new Select(element);
	    //passing the Exam Registration Type
	    System.out.println("******"+sheet.getRow(5).getCell(1).getStringCellValue()+"************");
	    dropdown.selectByVisibleText(sheet.getRow(5).getCell(1).getStringCellValue().trim());
		Thread.sleep(300);

	    //xpath of Event Name
	     element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='eventId']")));
	     dropdown = new Select(element);
	     //passing the Event Name
	    dropdown.selectByIndex(1);


	}

	//	public WebElement getRevokedButton()
	//	{
	//		return Revokedbutton;
	//	}

	public void getBranchDetails() throws InterruptedException
		{

		List<WebElement> branches=driver.findElements(By.xpath("//*[contains(text(),' Branch/Stream:')]"));
		branchNames=new Object[branches.size()];
		int i=0;

		for(WebElement branch:branches)
		{
		branchNames[i]=branch.getText();
		i++;

		}
		System.out.println("*********** " +branchNames);
		for(int j=0; j<branches.size(); j++)
		{
			System.out.println("value is "+branchNames[j]);
		}



//		Branch = StringUtils.substringAfter(Branchname, "Branch/Stream:");
//
//		System.out.println("*********** "+Branch);
//		Branchdetails.add(Branch);




	}


	public void clickViewHallticket(String branchNames) throws Exception{
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[contains(text(),'"+branchNames+"')]//following::a[1]")));
//		System.out.println("Branch is ******"+branchNames);
		element.click();
		Thread.sleep(1000);


	}







}