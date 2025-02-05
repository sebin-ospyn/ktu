//package com.ospyn.ktu.view;
//
//import java.awt.Robot;
//import java.awt.event.KeyEvent;
//import java.io.File;
//import java.io.FileInputStream;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Set;
//
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//
//
//public class ViewCourseMapping extends SeleniumBase{
//
//	@FindBy(xpath = "//a[text()='Academic Auditing']")
//	WebElement AcademicAuditing;
//
//	@FindBy(xpath = "//a[text()='Course Mapping']")
//	WebElement CourseMapping;
//
//	@FindBy(xpath = "//a[text()='Batches']")
//	WebElement Batches;
//
//	@FindBy(xpath = "//*[@id='add']")
//	WebElement add;
//
//	@FindBy(xpath = "//*[@id='branchListingForm_search']")
//	WebElement Search;
//
//	@FindBy(xpath = "//*[@name='partialsave']")
//	WebElement saveCourseMapping;
//
//	@FindBy(xpath = "//*[@id='courseBookFormCtrl_save']")
//	WebElement markAsComplete;
//
//	@FindBy(xpath = "//*[@title='EXPORT']")
//	WebElement CourseMappingExport;
//
//
//	@FindBy(xpath = "//*[@id='branchListingForm_submitToUniversity']")
//	WebElement SubmitToUniversity;
//
//	@FindBy(xpath = "//*[@id='choose']")
//	WebElement Choose;
//
//	@FindBy(xpath = "//*[@id='batchForm_submit']")
//	WebElement batchSave;
//
//	@FindBy(xpath = "//*[text()='Back']")
//	WebElement Back;
//
//	@FindBy(xpath = "//*[text()='Revoke']")
//	WebElement Revoke;
//
//	@FindBy(xpath = "//*[text()='Revoked']")
//	WebElement Revokedbutton;
//
//
//
//
//	public static  String  branch;
//	String status="";
//	Robot robot;
//	static WebElement element;
//	int params=5;
//
//	public ViewCourseMapping(WebDriver driver)throws Exception {
//
//		super(driver);
//		robot = new Robot();
//
//	}
//
//	public WebElement getAcademicAuditing() {
//		return AcademicAuditing;
//	}
//
//
//
//
//	public WebElement getCourseMapping() {
//		return CourseMapping;
//	}
//
//	public WebElement getsaveCourseMapping() {
//		return saveCourseMapping;
//	}
//
//
//	public WebElement getSearch() {
//		return Search;
//	}
//
//
//
//	public WebElement getMarkAsComplete() {
//		return markAsComplete;
//	}
//
//
//	public WebElement getCourseMappingExport() {
//		return CourseMappingExport;
//	}
//
//
//
//	public WebElement getSubmitToUniversity() {
//		return SubmitToUniversity;
//	}
//
//
//	public WebElement getBatches() {
//		return Batches;
//	}
//
//
//
//	public WebElement getAdd() {
//		return add;
//	}
//
//
//	public WebElement getChoose() {
//		return Choose;
//	}
//
//
//
//	public WebElement getBatchSave() {
//		return batchSave;
//	}
//
//
//	public WebElement getBack() {
//		return Back;
//	}
//
//	public WebElement getRevoke() {
//		return Revoke;
//	}
//
//
//	public WebElement getRevokedButton() {
//		return Revokedbutton;
//	}
//
//
//	public void CourseMappingOption() throws Exception
//	{
//
//		FileInputStream fs = new FileInputStream(new File(System.getProperty("user.dir")+"/Test_Data/PARAMETER_LISTING.xlsx"));
//
//		//Getting the workbook
//		XSSFWorkbook workbook = new XSSFWorkbook(fs) ;
//
//		//Getting the sheet
//		XSSFSheet sheet = workbook.getSheetAt(2);
//
//
//		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//*[@id='academicYearId']")));
//
//		Select dropdown = new Select(element);
//
//		System.out.println("*****2023 - 2024******");
//		System.out.println("*****value"+sheet.getRow(1).getCell(1).getStringCellValue()+"******");
//
//		////passing the Academic year
//		dropdown.selectByVisibleText(sheet.getRow(1).getCell(1).getStringCellValue());
//
//		Thread.sleep(2000);
//
//		element = wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//*[@id='universityProgramId']")));
//
//		dropdown = new Select(element);
//
//		////passing the Program
//		dropdown.selectByVisibleText(sheet.getRow(2).getCell(1).getStringCellValue());
//
//		Thread.sleep(2000);
//
//		element = wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//*[@id='programType']")));
//
//		dropdown = new Select(element);
//
//		////passing the Program type
//		dropdown.selectByVisibleText(sheet.getRow(3).getCell(1).getStringCellValue());
//
//		Thread.sleep(2000);
//
//		element = wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//*[@id='semester']")));
//
//		dropdown = new Select(element);
//
//		////passing the Semester
//		dropdown.selectByVisibleText(sheet.getRow(4).getCell(1).getStringCellValue());
//
//		Thread.sleep(2000);
//
//		element = wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//*[@id='registrationType']")));
//
//		dropdown = new Select(element);
//
//		////passing the Degree
//		dropdown.selectByVisibleText(sheet.getRow(5).getCell(1).getStringCellValue());
//
//		Thread.sleep(2000);
//
//		element = wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//*[@id='registrationAllowedStudentStatus']")));
//
//		dropdown = new Select(element);
//
//		////passing the Degree
//		dropdown.selectByVisibleText(sheet.getRow(6).getCell(1).getStringCellValue());
//
//		Thread.sleep(2000);
//
//
//
//	}
//	public void detailsWithInstitutionName()throws Exception
//	{
//		CourseMappingOption();
//		//reading the excel file
//		FileInputStream fs = new FileInputStream(new File(System.getProperty("user.dir")+"/Test_Data/PARAMETER_LISTING.xlsx"));
//
//		//Getting the workbook
//		XSSFWorkbook workbook = new XSSFWorkbook(fs);
//
//		//Getting the sheet
//		XSSFSheet sheet = workbook.getSheetAt(2);
//
//		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("institution")));
//		element.sendKeys(sheet.getRow(7).getCell(1).getStringCellValue());
//		Thread.sleep(1000);
//
//		Robot robot=new Robot();
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
//
//	}
//
//
//	public String validateError() {
//
//		String errorStatus= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Semester transfer not completed.Please contact University.' )]"))).getText();
//
//		return errorStatus;
//
//	}
//
//	public String validateErrorCourse() {
//
//		String errorStatus= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Either course selection is not submitted or Branch(es) not affiliated.' )]"))).getText();
//
//		return errorStatus;
//
//	}
//
//	public void entersFacultyOnly()throws Exception
//	{
//		WebElement element=driver.findElement(By.xpath("(//*[starts-with(@id,'courseBookTable')])[1]/tbody/tr/td[1]/input[@type='text']"));
//		element.clear();
//
//		element.sendKeys("K");
//		Thread.sleep(1000);
//
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
//
//
//	}
//
//	public void entersFacultyOnlyQPSetter()throws Exception
//	{
//
//		WebElement element=driver.findElement(By.xpath("(//*[starts-with(@id,'courseBookTable')])[1]/tbody/tr/td[1]/input[@type='text']"));
//
//		//Using auto complete field, finding a faculty by entering the first letter of their ids
//
//		element.clear();
//		Thread.sleep(1000);
//
//		element.sendKeys("K");
//		Thread.sleep(1000);
//
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
//
//
//		Thread.sleep(1000);
//		element=driver.findElement(By.xpath("(//*[starts-with(@id,'courseBookTable')])[1]/tbody/tr/td[4]/select"));
//
//		Select dropDown=new Select(element);
//		dropDown.selectByIndex(1);
//
//
//
//	}
//
//	public void deleteDuplicateRow()throws Exception
//	{
//
//		WebElement element=driver.findElement(By.xpath("((//*[starts-with(@id,'courseBookTable')])[1]/tbody/tr/td[6]/a)[1]"));
//		element.click();
//
//		Thread.sleep(1000);
//
//		element=driver.findElement(By.xpath("((//*[starts-with(@id,'courseBookTable')])[1]/tbody/tr[2]/td[6]/a)[2]"));
//		element.click();
//
//		Thread.sleep(1000);
//
//		element=driver.findElement(By.xpath("//button[@id='delete']"));
//		element.click();
//
//
//	}
//	public void deleteOnlyRow()throws Exception
//	{
//
//		entersFacultyOnlyQPSetter();
//		WebElement element=driver.findElement(By.xpath("((//*[starts-with(@id,'courseBookTable')])[1]/tbody/tr[1]/td[6]/a)[2]"));
//		element.click();
//
//		Thread.sleep(1000);
//
//		element=driver.findElement(By.xpath("//button[@id='delete']"));
//		element.click();
//
//	}
//
//
//
//	public String  validateDeletionRow()throws Exception
//	{
//
//		String faculty=driver.findElement(By.xpath("(//*[starts-with(@id,'courseBookTable')])[1]/tbody/tr[1]/td[1]/input")).getText();
//		String qpsetter=driver.findElement(By.xpath("(//*[starts-with(@id,'courseBookTable')])[1]/tbody/tr[1]/td[4]/select")).getText();
//		if(faculty.equals("")&&qpsetter.equals(""))
//			return "pass";
//		else
//			return "fail";
//
//
//	}
//
//	public void entersMainFacultyTwoBatches()throws Exception
//	{
//		WebElement element=driver.findElement(By.xpath("(//*[starts-with(@id,'courseBookTable')])[1]/tbody/tr[1]/td[1]/input[@type='text']"));
//		element.clear();
//		Thread.sleep(1000);
//
//		element.sendKeys("K");
//		Thread.sleep(1000);
//
//
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
//
//
//		Thread.sleep(1000);
//
//
//		element=driver.findElement(By.xpath("(//*[starts-with(@id,'courseBookTable')])[1]/tbody/tr/td[4]/select"));
//
//		Select dropDown=new Select(element);
//		dropDown.selectByIndex(1);
//
//
//		element=driver.findElement(By.xpath("(//*[starts-with(@id,'courseBookTable')])[1]/tbody/tr/td[5]/input"));
//		element.clear();
//		element.sendKeys("4");
//
//		element=driver.findElement(By.xpath("(//*[starts-with(@id,'courseBookTable')])[2]/tbody/tr[1]/td[1]/input[@type='text']"));
//
//		element.sendKeys("K");
//		Thread.sleep(1000);
//
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
//
//
//		Thread.sleep(1000);
//		element=driver.findElement(By.xpath("(//*[starts-with(@id,'courseBookTable')])[2]/tbody/tr[1]/td[4]/select"));
//
//		dropDown=new Select(element);
//		dropDown.selectByIndex(1);
//
//		Thread.sleep(1000);
//
//		element=driver.findElement(By.xpath("(//*[starts-with(@id,'courseBookTable')])[2]/tbody/tr[1]/td[5]/input"));
//		element.clear();
//		element.sendKeys("4");
//
//		element=driver.findElement(By.xpath("(//*[starts-with(@id,'courseBookTable')])[1]/tbody/tr[1]/td[3]/label/input"));
//		element.click();
//
//		element=driver.findElement(By.xpath("(//*[starts-with(@id,'courseBookTable')])[2]/tbody/tr[1]/td[3]/label/input"));
//		element.click();
//
//	}
//
//	public void noQpPart1Part2(int number)throws Exception
//	{
//		WebElement element=driver.findElement(By.xpath("//a[text()='Slot : D']"));
//		element.click();
//
//		element=driver.findElement(By.xpath("(//*[starts-with(@id,'courseBookTable')])[4]/tbody/tr[1]/td[1]/input[@type='text']"));
//		element.clear();
//		Thread.sleep(1000);
//
//		element.sendKeys("K");
//		Thread.sleep(1000);
//
//
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
//
//
//		Thread.sleep(1000);
//		//setting the experience if number parameter is 1.
//
//
//		element=driver.findElement(By.xpath("(//*[starts-with(@id,'courseBookTable')])[4]/tbody/tr/td[5]/input"));
//		element.clear();
//
//		if(number==1 || number==3||number==5||number==7||number==14||number==16)
//			element.sendKeys("4");
//
//		element=driver.findElement(By.xpath("(//*[starts-with(@id,'courseBookTable')])[5]/tbody/tr[1]/td[5]/input"));
//		element.clear();
//
//		if(number==1 ||number==4||number==6||number==8||number==15||number==16)
//			element.sendKeys("4");
//
//		element=driver.findElement(By.xpath("(//*[starts-with(@id,'courseBookTable')])[5]/tbody/tr[1]/td[1]/input[@type='text']"));
//		element.clear();
//
//		Thread.sleep(1000);
//		element.sendKeys("K");
//		Thread.sleep(1000);
//
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
//
//
//		Thread.sleep(1000);
//
//		element=driver.findElement(By.xpath("(//*[starts-with(@id,'courseBookTable')])[4]/tbody/tr[1]/td[3]/label/input"));
//		if(!element.isSelected())
//			element.click();
//		if(number==2)
//		{
//
//			element=driver.findElement(By.xpath("(//*[starts-with(@id,'courseBookTable')])[4]/tbody/tr/td[4]/select"));
//
//			Select dropDown=new Select(element);
//			dropDown.selectByIndex(2);
//
//			element=driver.findElement(By.xpath("(//*[starts-with(@id,'courseBookTable')])[5]/tbody/tr/td[4]/select"));
//
//			dropDown=new Select(element);
//			dropDown.selectByIndex(2);
//		}
//
//		if(number==3)
//		{
//			element=driver.findElement(By.xpath("(//*[starts-with(@id,'courseBookTable')])[4]/tbody/tr/td[4]/select"));
//
//			Select dropDown=new Select(element);
//			dropDown.selectByIndex(1);
//
//			element=driver.findElement(By.xpath("(//*[starts-with(@id,'courseBookTable')])[5]/tbody/tr/td[4]/select"));
//
//			dropDown=new Select(element);
//			dropDown.selectByIndex(0);
//
//
//
//		}
//
//		else if(number==4)
//		{
//
//
//			element=driver.findElement(By.xpath("(//*[starts-with(@id,'courseBookTable')])[4]/tbody/tr/td[4]/select"));
//
//			Select dropDown=new Select(element);
//			dropDown.selectByIndex(0);
//
//			element=driver.findElement(By.xpath("(//*[starts-with(@id,'courseBookTable')])[5]/tbody/tr/td[4]/select"));
//
//			dropDown=new Select(element);
//			dropDown.selectByIndex(1);
//		}
//
//		else if(number==5)
//		{
//			element=driver.findElement(By.xpath("(//*[starts-with(@id,'courseBookTable')])[4]/tbody/tr/td[4]/select"));
//
//			Select dropDown=new Select(element);
//			dropDown.selectByIndex(2);
//
//			element=driver.findElement(By.xpath("(//*[starts-with(@id,'courseBookTable')])[5]/tbody/tr/td[4]/select"));
//
//			dropDown=new Select(element);
//			dropDown.selectByIndex(0);
//
//		}
//
//		else if(number==6)
//		{
//			element=driver.findElement(By.xpath("(//*[starts-with(@id,'courseBookTable')])[5]/tbody/tr/td[4]/select"));
//
//			Select dropDown=new Select(element);
//			dropDown.selectByIndex(2);
//
//			element=driver.findElement(By.xpath("(//*[starts-with(@id,'courseBookTable')])[4]/tbody/tr/td[4]/select"));
//
//			dropDown=new Select(element);
//			dropDown.selectByIndex(0);
//		}
//
//		else if (number==7||number==8)
//		{
//
//			element=driver.findElement(By.xpath("(//*[starts-with(@id,'courseBookTable')])[5]/tbody/tr/td[4]/select"));
//
//			Select dropDown=new Select(element);
//			dropDown.selectByIndex(1);
//
//			element=driver.findElement(By.xpath("(//*[starts-with(@id,'courseBookTable')])[4]/tbody/tr/td[4]/select"));
//
//			dropDown=new Select(element);
//			dropDown.selectByIndex(1);
//
//		}
//		else if(number==9)
//		{
//
//			element=driver.findElement(By.xpath("(//*[starts-with(@id,'courseBookTable')])[5]/tbody/tr/td[4]/select"));
//
//			Select dropDown=new Select(element);
//			dropDown.selectByIndex(1);
//
//			element=driver.findElement(By.xpath("(//*[starts-with(@id,'courseBookTable')])[4]/tbody/tr/td[4]/select"));
//
//			dropDown=new Select(element);
//			dropDown.selectByIndex(1);
//		}
//
//		else if(number==10)
//		{
//
//			element=driver.findElement(By.xpath("(//*[starts-with(@id,'courseBookTable')])[4]/tbody/tr/td[4]/select"));
//
//			Select dropDown=new Select(element);
//			dropDown.selectByIndex(1);
//
//			element=driver.findElement(By.xpath("(//*[starts-with(@id,'courseBookTable')])[5]/tbody/tr/td[4]/select"));
//
//			dropDown=new Select(element);
//			dropDown.selectByIndex(0);
//		}
//		else if (number==11)
//		{
//			element=driver.findElement(By.xpath("(//*[starts-with(@id,'courseBookTable')])[4]/tbody/tr/td[4]/select"));
//
//			Select dropDown=new Select(element);
//			dropDown.selectByIndex(2);
//
//			element=driver.findElement(By.xpath("(//*[starts-with(@id,'courseBookTable')])[5]/tbody/tr/td[4]/select"));
//
//			dropDown=new Select(element);
//			dropDown.selectByIndex(0);
//		}
//		else if (number==12)
//		{
//			element=driver.findElement(By.xpath("(//*[starts-with(@id,'courseBookTable')])[5]/tbody/tr/td[4]/select"));
//
//			Select dropDown=new Select(element);
//			dropDown.selectByIndex(1);
//
//			element=driver.findElement(By.xpath("(//*[starts-with(@id,'courseBookTable')])[4]/tbody/tr/td[4]/select"));
//
//			dropDown=new Select(element);
//			dropDown.selectByIndex(0);
//		}
//		else if (number==13)
//		{
//			element=driver.findElement(By.xpath("(//*[starts-with(@id,'courseBookTable')])[5]/tbody/tr/td[4]/select"));
//
//			Select dropDown=new Select(element);
//			dropDown.selectByIndex(2);
//
//			element=driver.findElement(By.xpath("(//*[starts-with(@id,'courseBookTable')])[4]/tbody/tr/td[4]/select"));
//
//			dropDown=new Select(element);
//			dropDown.selectByIndex(0);
//		}
//
//		else if (number==14||number==15||number==16)
//		{
//			element=driver.findElement(By.xpath("(//*[starts-with(@id,'courseBookTable')])[5]/tbody/tr/td[4]/select"));
//
//			Select dropDown=new Select(element);
//			dropDown.selectByIndex(1);
//
//			element=driver.findElement(By.xpath("(//*[starts-with(@id,'courseBookTable')])[4]/tbody/tr/td[4]/select"));
//
//			dropDown=new Select(element);
//			dropDown.selectByIndex(1);
//		}
//
//
//
//
//
//	}
//
//	public String twoMainFaculty()throws Exception
//	{
//
//		WebElement element=driver.findElement(By.xpath("((//*[starts-with(@id,'courseBookTable')])[1]/tbody/tr/td[6]/a)[1]"));
//		element.click();
//
//		Thread.sleep(1000);
//		element=driver.findElement(By.xpath("(//*[starts-with(@id,'courseBookTable')])[1]/tbody/tr[1]/td[1]/input[@type='text']"));
//		element.clear();
//		Thread.sleep(1000);
//
//		element.sendKeys("K");
//		Thread.sleep(1000);
//
//
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
//
//
//		Thread.sleep(1000);
//
//
//		element=driver.findElement(By.xpath("(//*[starts-with(@id,'courseBookTable')])[1]/tbody/tr/td[4]/select"));
//
//		Select dropDown=new Select(element);
//		dropDown.selectByIndex(1);
//
//
//		element=driver.findElement(By.xpath("(//*[starts-with(@id,'courseBookTable')])[1]/tbody/tr/td[5]/input"));
//		element.clear();
//		element.sendKeys("4");
//
//		element=driver.findElement(By.xpath("(//*[starts-with(@id,'courseBookTable')])[1]/tbody/tr[2]/td[1]/input[@type='text']"));
//
//		element.sendKeys("K");
//		Thread.sleep(1000);
//
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
//
//
//		Thread.sleep(1000);
//		element=driver.findElement(By.xpath("(//*[starts-with(@id,'courseBookTable')])[1]/tbody/tr[2]/td[4]/select"));
//
//		dropDown=new Select(element);
//		dropDown.selectByIndex(1);
//		Thread.sleep(1000);
//
//		element=driver.findElement(By.xpath("(//*[starts-with(@id,'courseBookTable')])[1]/tbody/tr[2]/td[5]/input"));
//		element.clear();
//		element.sendKeys("4");
//
//		element=driver.findElement(By.xpath("(//*[starts-with(@id,'courseBookTable')])[1]/tbody/tr[2]/td[3]/input"));
//		String clickable;
//		try
//		{
//			element.click();
//			clickable="yes";
//		}
//		catch(Exception e)
//		{
//			clickable="no";
//		}
//		return clickable;
//
//
//	}
//
//	public String validateMessages()
//	{
//		WebElement element=driver.findElement(By.xpath("//h3[text()='Course Mapping']//following::div[@class='alert alert-danger']"));
//		return element.getText();
//	}
//
//	public void entersDuplicateTwoSlots()throws Exception
//	{
//		fillFacultyDetails(1);
//
//
//	}
//
//	public void fillFacultyDetails(int number)throws Exception
//	{
//		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='faculty'])[1]")));
//		element.clear();
//		element.sendKeys("K");
//		Thread.sleep(1000);
//
//		String s=driver.findElement(By.xpath("(//ul[@class='typeahead dropdown-menu']/li/a)[1]")).getText();
//		System.out.println("First option is"+s);
//		List<WebElement> optionsToSelect = driver.findElements(By.xpath("//ul[@class='typeahead dropdown-menu']/li/a"));
//		List<String> facultyNames=new ArrayList<String>();
//
//		for(WebElement faculty:optionsToSelect)
//		{
//			String name=faculty.getText();
//			facultyNames.add(name.substring(0,name.indexOf("-",4)));
//		}
//
//
//		try
//		{
//
//			Thread.sleep(1000);
//			element.clear();
//
//			List<WebElement> faculties =wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
//					By.xpath("(//*[starts-with(@id,'courseBookTable')])[1]/tbody/tr/td[1]/input[@type='text']")));
//			Thread.sleep(2000);
//
//			if(faculties.size()<2)
//			{
//				wait.until(ExpectedConditions.visibilityOfElementLocated(
//						By.xpath("(//*[starts-with(@id, 'courseBookTable')])[1]/tbody/tr/td[6]/a[1]"))).click();
//
//			}
//
//			faculties =wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
//					By.xpath("(//*[starts-with(@id,'courseBookTable')])[1]/tbody/tr/td[1]/input[@type='text']")));
//			List<WebElement> checkboxes=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
//					By.xpath("(//*[starts-with(@id,'courseBookTable')])[1]/tbody/tr/td[3]/label/input")));
//			List<WebElement> qpsetter=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
//					By.xpath("(//*[starts-with(@id,'courseBookTable')])[1]/tbody/tr/td[4]/select")));
//			List<WebElement> qpsetterExp=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
//					By.xpath("(//*[starts-with(@id,'courseBookTable')])[1]/tbody/tr/td[5]/input")));
//
//
//			for(int i=0;i<faculties.size();i++)
//			{
//
//				WebElement faculty=faculties.get(i);
//				faculty.clear();
//
//
//
//				if(number==3|| number==4)
//				{
//					faculty.sendKeys(facultyNames.get(i));
//				}
//
//				else
//				{
//					faculty.sendKeys("K");
//					Thread.sleep(1000);
//					robot.keyPress(KeyEvent.VK_ENTER);
//					robot.keyRelease(KeyEvent.VK_ENTER);
//
//				}
//
//				Thread.sleep(1000);
//				//Pressing the Enter Key
//				robot.keyPress(KeyEvent.VK_ENTER);
//				robot.keyRelease(KeyEvent.VK_ENTER);
//
//
//				Thread.sleep(1000);
//				if(number==1)
//				{
//					if(checkboxes.get(i).isSelected())
//						checkboxes.get(i).click();
//
//				}
//				else
//				{
//
//					if(!(checkboxes.get(i).isSelected()))
//						checkboxes.get(i).click();
//				}
//
//				Select dropdown=new Select(qpsetter.get(i));
//				dropdown.selectByIndex(1);
//				Thread.sleep(1000);
//
//				qpsetterExp.get(i).sendKeys("3");
//
//			}
//		}
//		catch(Exception e)
//		{
//			System.out.println(e);
//		}
//
//
//	}
//
//	public String entersNoFaculty()throws Exception
//	{
//		List<WebElement> faculties =wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
//				By.xpath("(//*[starts-with(@id,'courseBookTable')])[1]/tbody/tr/td[1]/input[@type='text']")));
//		for(WebElement faculty:faculties)
//		{
//			faculty.clear();
//		}
//
//
//		saveCourseMapping.click();
//		Thread.sleep(2000);
//
//		String errorStatus= driver.findElement(By.xpath("//*[@id='courseBookFormCtrl']/div[1]")).getText();
//
//		return errorStatus;
//	}
//
//	public String clickSaveButton()
//	{
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click();", saveCourseMapping);
////		saveCourseMapping.click();
//		String Status= "pass";
//		return Status;
//	}
//	public void entersDuplicateFaculty(int number) throws Exception
//
//	{
//		fillFacultyDetails(number);
//		Thread.sleep(2000);
//
//	}
//
//
//	public String entersNoRegistration() throws Exception
//	{
//		fillFacultyDetails(3);
//		driver.findElement(By.xpath("((//*[starts-with(@id,'courseBookTable')])[1]//following::input[@id='noAdmission'])[1]")).click();
//
//		Thread.sleep(1000);
//		saveCourseMapping.click();
//
//		Thread.sleep(2000);
//		String errorStatus= driver.findElement(By.xpath("//*[@id=\"courseBookFormCtrl\"]/div[1]")).getText();
//
//		return errorStatus;
//
//	}
//	public void noQpSetter()throws Exception
//	{
//		WebElement element=driver.findElement(By.xpath("(//*[starts-with(@id,'courseBookTable')])[1]/tbody/tr/td[1]/input[@type='text']"));
//		element.clear();
//
//		element.sendKeys("K");
//		Thread.sleep(1000);
//
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
//
//		element=driver.findElement(By.xpath("(//*[starts-with(@id,'courseBookTable')])[1]/tbody/tr/td[4]/select"));
//		Select dropdown=new Select(element);
//
//		dropdown.selectByVisibleText("No");
//
//
//	}
//
//
//
//
//	public void saveFacultyForAllSlots() throws Exception
//
//	{
//		int flag1=0;
//
//		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='faculty'])[1]")));
//		element.clear();
//
//		element.sendKeys("K");
//		Thread.sleep(1000);
//
//		String s=driver.findElement(By.xpath("(//ul[@class='typeahead dropdown-menu']/li/a)[1]")).getText();
//		System.out.println("First option is"+s);
//
//		List<WebElement> optionsToSelect = driver.findElements(By.xpath("//ul[@class='typeahead dropdown-menu']/li/a"));
//		List<String> facultyNames=new ArrayList<String>();
//
//		for(WebElement faculty:optionsToSelect)
//		{
//			String name=faculty.getText();
//			facultyNames.add(name.substring(0,name.indexOf("-",4)));
//		}
//
//		System.out.println("Number of faculties is "+facultyNames.size());
//		Thread.sleep(2000);
//
//		List<WebElement> slots=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
//				By.xpath("//a[contains(text(),'Slot')]")));
//		System.out.println("slot 3 is "+slots.get(3).getText());
//
//
//		//for iterating through slots
//		int j=0;
//		List<WebElement> batchType=driver.findElements(By.xpath("//*[starts-with(@id,'courseBookTable')]/tbody/tr/td[2]//input[@id='batchType']"));
//		List<WebElement> faculties=driver.findElements(By.xpath("//*[starts-with(@id,'courseBookTable')]/tbody/tr/td[1]/input[@type='text']"));
//		System.out.println("No of boxes is "+faculties.size());
//
//		List<WebElement> mainFaculty=driver.findElements(
//				By.xpath("//*[starts-with(@id,'courseBookTable')]/tbody/tr/td[3]/label/input"));
//
//		List<WebElement>qpsetter=driver.findElements(By.xpath
//				("(//*[starts-with(@id,'courseBookTable')])/tbody/tr/td[4]/select"));
//		List<WebElement>qpsetterExp=driver.findElements(By.xpath
//				("(//*[starts-with(@id,'courseBookTable')])/tbody/tr/td[5]/input"));
//		List<WebElement>noAdmission=driver.findElements(By.xpath("//input[@id='noAdmission']"));
//
//
//		//Used to iterate through the array elements
//		int k=0;
//		Robot robot=new Robot();
//		WebElement faculty=faculties.get(0);
//		System.out.println(faculties.size());
//		if(	!(mainFaculty.get(0).isSelected()))
//			mainFaculty.get(0).click();
//
//		for(int i=0;i<faculties.size();i++)
//		{
//
//			System.out.print("**************\n"+i+"**********\n");
//			if(Integer.parseInt(batchType.get(i).getAttribute("value"))==2)
//			{
//				try
//				{
//					System.out.println("(//input[@id='batchType'])["+(i+1)+"]//following::input[@id='noAdmission']");
//					element=driver.findElement(By.xpath("(//input[@id='batchType'])["+(i+1)+"]//following::input[@id='noAdmission']"));
//					if(!element.isSelected())
//					{
//						//Added on 01/07/2024-Unable to click "Mark here if there are no registrations"check box for some UI hide elements
//						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//					((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
//					//element.click();
//						continue;
//					}
//				}
//				catch(Exception e)
//				{
//					System.out.println(e);
//					flag1=1;
//				}
//			}
//			else
//			{
//				try
//				{
//					System.out.println("i="+i);
//					faculty=faculties.get(i);
//					faculty.clear();
//					Thread.sleep(1000);
//
//					faculty.sendKeys(facultyNames.get(k));
//
//					Thread.sleep(1000);
//
//					robot.keyPress(KeyEvent.VK_ENTER);
//					robot.keyRelease(KeyEvent.VK_ENTER);
//					Thread.sleep(1000);
//					k++;
//
//					if(k==10)
//						k=0;
//
//					flag1=0;
//
//					Select dropdown=new Select(qpsetter.get(i));
//					dropdown.selectByIndex(1);
//					Thread.sleep(1000);
//
//					qpsetterExp.get(i).clear();
//					qpsetterExp.get(i).sendKeys("3");
//
//				}
//				catch(Exception e)
//				{
//					System.out.println(e);
//					flag1=1;
//
//				}
//			}
//
//			if(flag1==1)
//			{
//				j++;
//				slots.get(j).click();
//				Thread.sleep(1000);
//
//				if(Integer.parseInt(batchType.get(i).getAttribute("value"))==2)
//				{
//
//					element=driver.findElement(By.xpath("(//input[@id='batchType'])["+(i+1)+"]//following::input[@id='noAdmission']"));
//					if(!element.isSelected())
//					{
//						element.click();
//						continue;
//					}
//				}
//				else
//				{
//
//					System.out.println(faculty.getAttribute("name")+" cleared");
//					if(k==10)
//						k=0;
//
//					faculty.clear();
//					Thread.sleep(1000);
//					faculty.sendKeys(facultyNames.get(k));
//					Thread.sleep(1000);
//					robot.keyPress(KeyEvent.VK_ENTER);
//					robot.keyRelease(KeyEvent.VK_ENTER);
//					Thread.sleep(1000);
//					Select dropdown=new Select(qpsetter.get(i));
//					dropdown.selectByIndex(1);
//					Thread.sleep(1000);
//
//					qpsetterExp.get(i).clear();
//					qpsetterExp.get(i).sendKeys("4");
//
//					if(	!(mainFaculty.get(i).isSelected()))
//						mainFaculty.get(i).click();
//
//					Thread.sleep(1000);
//					k++;
//
//					flag1=0;
//				}
//
//			}
//		}
//
//	}
//
//
//
//
//	public String entersTwoFaculties()throws Exception
//	{
//		fillFacultyDetails(4);
//		saveCourseMapping.click();
//		Thread.sleep(2000);
//		return "pass";
//
//	}
//
//	public WebElement getAddCourseMapping()
//	{
//		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//*[text()='Add/Edit Course Mapping' or text()='Revoked']")));
//
//		return element;
//
//	}
//	public WebElement getAddCourseMapping1()
//	{
//		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("(//*[text()='Add/Edit Course Mapping' or text()='Revoked'])[2]")));
//
//		return element;
//
//	}
//
//	public WebElement getMarkAsCompleteButton()
//	{
//		branch=wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//input[@name='branchName']"))).getAttribute("value");
//		branch=" Branch/Stream:"+branch;
//		System.out.println(branch);
//		return markAsComplete;
//
//	}
//
//	public String getMarkedStatus()
//	{
//		String status=wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//*[text()='"+branch+"']//following::a"))).getText();
//		return status;
//
//	}
//
//	public WebElement getMarkedAsCompleteButton()
//	{
//		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//a[text()='Marked as Complete']")));
//		return element;
//
//	}
//
//	public void windowSwitch() throws InterruptedException
//	{
//		String parentWindow = driver.getWindowHandle();
//
//		Set<String> handles = driver.getWindowHandles();
//		Thread.sleep(1000);
//		System.out.println("number of windows is"+handles.size());
//
//
//		for (String windowHandle : handles) {
//
//			if (!windowHandle.equals(parentWindow)) {
//
//				driver.switchTo().window(windowHandle);
//				Thread.sleep(3000);
//
//			}
//		}
//		Thread.sleep(1000);
//	}
//
//	public boolean validatesExportedCourseMapping() throws Exception
//
//	{
//
//		boolean flag=true;
//		windowSwitch();
//		Thread.sleep(3000);
//
//		try
//		{
//			flag=driver.findElement(By.xpath("//*[text()= 'Course Book Details For']")).isDisplayed();
//		}
//		catch(Exception e){
//			System.out.println(flag);
//			flag=false;
//		}
//		windowSwitch();
//		Thread.sleep(1000);
//		return flag;
//
//	}
//
//	public WebElement getCheckBox()
//	{
//		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//*[text()='"+branch+"']/../input[@type='checkBox']")));
//
//		return element;
//	}
//
//	public void partialSubmission() throws Exception
//	{
//
//		Robot robot = new Robot();
//
//		//pressing escape key to move the pointer from file downloaded
//
//		robot.keyPress(KeyEvent.VK_ESCAPE);
//		//Releasing escape key
//
//		robot.keyRelease(KeyEvent.VK_ESCAPE);
//		Thread.sleep(1000);
//
//
//		SubmitToUniversity.click();
//
//		Thread.sleep(1000);
//
//		//Pressing the Enter Key
//
//		robot.keyPress(KeyEvent.VK_ENTER);
//
//		//Releasing the Enter Key
//		robot.keyRelease(KeyEvent.VK_ENTER);
//
//		Thread.sleep(1000);
//
//
//	}
//	public String getPartialSubmissionError()
//	{
//		String errorMsg=wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//*[text()='Selected branch/s already submitted to the university']"))).getText();
//		return  errorMsg;
//	}
//	public String mapAllBranches()throws Exception
//	{
//
//		List<WebElement> branches =wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
//				By.xpath("//*[text()='Add/Edit Course Mapping' or text()='Revoked']")));
//		WebElement branchName;
//		for(int i=0;i<branches.size();i++)
//		{
//			System.out.println(branches.size());
//			branchName=wait.until(ExpectedConditions.visibilityOfElementLocated(
//					By.xpath("//*[text()='Add/Edit Course Mapping' or text()='Revoked']")));
//			branchName.sendKeys(Keys.ENTER);
//			Thread.sleep(1000);
//			saveFacultyForAllSlots();
//			clickSaveButton();
//
//			Thread.sleep(1000);
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("arguments[0].click();", markAsComplete);
////			markAsComplete.click();
//
//		}
//
//		return "pass";
//	}
//	public String  submitCourseMappingAllBranches()throws Exception
//	{
//		List<WebElement> branches1 =driver.findElements(By.xpath("//a[contains(text(),'Marked as Complete')]"));
//		branch="";
//		int size=branches1.size();
//		System.out.println(branches1.size());
//
//
//		Robot robot = new Robot();
//
//		for(int i=1;i<=size;i++)
//
//		{
//			WebElement element= wait.until(ExpectedConditions.visibilityOfElementLocated(
//					By.xpath("(//a[text()='Marked as Complete']//..//..//..//input[@type='checkBox'])["+i+"]")));
//			Thread.sleep(2000);
//
//			((RemoteWebDriver) driver).executeScript("arguments[0].click();", element);
//
//
//			System.out.println(element);
//
//
//		}
//
//		SubmitToUniversity.sendKeys(Keys.ENTER);
//
//		Thread.sleep(1000);
//
//		//Pressing the Enter Key
//		robot.keyPress(KeyEvent.VK_ENTER);
//
//		//Releasing the Enter Key
//		robot.keyRelease(KeyEvent.VK_ENTER);
//
//		return "pass";
//
//
//	}
//	public WebElement getValidationErrorSubmission()throws Exception
//	{
//		WebElement element=driver.findElement(By.xpath("(//div[@class='alert alert-danger'])[7]"));
//		return element;
//	}
//	public void revokeBranch()throws Exception
//	{
//		/*storing the name of the branch for the button to be revoked
//		 * The  branch name stored  will be used to check whether the button changed to revoked.
//		 *
//		 */
//
//		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//*[text()='Revoke']/../../..//b[contains(text(),'Branch/Stream')]")));
//		branch=" "+element.getText();
//
//		System.out.println(branch);
//
//		//clicking the first revoke button available in the page
//		Revoke.click();
//
//		//Delay by 1 s
//		Thread.sleep(1000);
//
//		//Pressing the yes button confirming the revoke using the enter key
//
//		Robot robot=new Robot();
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
//		Thread.sleep(1000);
//
//
//	}
//	/*Getting the text from the revoked button and returning it
//	 * branch name stored in the variable branch is used to get the latest revoked branch
//	 */
//
//	public String validateRevokeBranch()
//	{
//		System.out.println("//*[text()='"+branch+"']//following::span[3]");
//
//		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//*[text()='"+branch+"']//following::span[3]")));
//
//		return element.getText();
//
//	}
//
//	public void enterNewCustomBatchDetails(String batchDetails)throws Exception
//	{
//		List<String> params= new ArrayList<>();
//		params = Arrays.asList(batchDetails.split(","));
//
//
//		Thread.sleep(2000);
//
//		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//*[@id='batchForm_batchName']")));
//
//		element.sendKeys(params.get(0));
//
//		element = wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//*[@id='academicYear']")));
//
//		Select dropdown = new Select(element);
//
//		////passing the Program
//		dropdown.selectByVisibleText(params.get(1));
//
//		Thread.sleep(2000);
//
//		element = wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//*[@id='programId']")));
//
//		dropdown = new Select(element);
//
//		////passing the Program type
//		dropdown.selectByVisibleText(params.get(2));
//
//		Thread.sleep(2000);
//
//		element = wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//*[@id='degreeType']")));
//
//		dropdown = new Select(element);
//
//		////passing the Degree
//		dropdown.selectByVisibleText(params.get(3));
//
//		Thread.sleep(2000);
//
//		element = wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//*[@id='branchId']")));
//
//		dropdown = new Select(element);
//
//		////passing the Degree
//		dropdown.selectByVisibleText(params.get(4));
//
//		Thread.sleep(2000);
//		int num=Integer.parseInt(params.get(5));
//		if(num==1)
//
//		{
//
//			element = wait.until(ExpectedConditions.visibilityOfElementLocated(
//					By.xpath("//*[@id='chooseStudentSpan']/a/span")));
//
//			element.click();
//			Thread.sleep(2000);
//
//			String parentWindow = driver.getWindowHandle();
//
//			Set<String> handles = driver.getWindowHandles();
//
//
//			for (String windowHandle : handles) {
//
//				if (!windowHandle.equals(parentWindow)) {
//
//					driver.switchTo().window(windowHandle);
//
//					Thread.sleep(3000);
//
//				}
//			}
//
//
//			Thread.sleep(1000);
//
//			element = wait.until(ExpectedConditions.visibilityOfElementLocated(
//					By.xpath("(//*[@id=\"studentId\"])[1]")));
//
//			element.click();
//
//			//Click on Choose button
//
//			Choose.click();
//			driver.switchTo().window(parentWindow);
//		}
//
//	}
//	//Clicking on save button
//	public String saveBatch()throws Exception
//	{
//		String status="";
//		batchSave.click();
//
//		try
//		{
//			WebElement element=driver.findElement(By.xpath("//div[@class='alert alert-danger col-sm-12']"));
//			if(element.isDisplayed())
//				status=element.getText();
//
//		}
//		catch(Exception e)
//		{
//			status="pass";
//		}
//
//		Thread.sleep(1000);
//
//		return status;
//	}
//	public void differentCoursesSameSlot()throws Exception
//	{
//		//Click Slots B
//		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//*[text()='Slot : B']")));
//		element.click();
//
//		element = wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("(//*[starts-with(@id,'courseBookTable')])[2]/tbody/tr[1]/td[1]/input[@type='text']")));
//		element.sendKeys("k");
//
//		Thread.sleep(1000);
//
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
//
//
//		element = wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("(//*[starts-with(@id,'courseBookTable')])[2]/tbody/tr[1]/td[4]/select")));
//
//		Select dropDown=new Select(element);
//		dropDown.selectByIndex(1);
//
//		element = wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("(//*[starts-with(@id,'courseBookTable')])[2]/tbody/tr[1]/td[5]/input")));
//		element.sendKeys("4");
//
//
//		element = wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("(//*[starts-with(@id,'courseBookTable')])[3]/tbody/tr[1]/td[1]/input[@type='text']")));
//		element.sendKeys("k");
//
//		Thread.sleep(1000);
//
//		robot.keyPress(KeyEvent.VK_DOWN);
//		robot.keyRelease(KeyEvent.VK_DOWN);
//
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
//
//
//
//
//
//	}
//
//	public void searchCustomBatch(String batchDetails)throws Exception
//	{
//		List<String> params= new ArrayList<>();
//		params = Arrays.asList(batchDetails.split(","));
//
//		Thread.sleep(2000);
//		System.out.println("within search....");
//		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//*[@id='academicYear']")));
//
//		Select dropdown = new Select(element);
//
//		////passing the Program
//		dropdown.selectByVisibleText(params.get(0));
//
//		Thread.sleep(2000);
//
//		element = wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//*[@id='programId']")));
//
//		dropdown = new Select(element);
//
//		////passing the Program type
//		dropdown.selectByVisibleText(params.get(1));
//
//		Thread.sleep(2000);
//
//		element = wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//*[@id='degreeType']")));
//
//		dropdown = new Select(element);
//
//		////passing the Degree
//
//		dropdown.selectByVisibleText(params.get(2));
//
//		Thread.sleep(2000);
//
//		element = wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//select[@name='batchTypeId']")));
//		dropdown = new Select(element);
//		dropdown.selectByVisibleText("Custom");
//
//
//	}
//
//	public String saveStaffAdvisor(String batchName)throws Exception
//	{
//
//		element = wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//*[text()='"+batchName+"']//following::a[@title='Select Staff Advisor']")));
//		element.click();
//
//		Thread.sleep(1000);
//
//		element = wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//input[@id='facultyId']")));
//		element.sendKeys("KTU");
//		Thread.sleep(1000);
//
//		Robot robot=new Robot();
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
//
//		Thread.sleep(1000);
//		element = wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//button[@id='submit']")));
//		element.click();
//		Thread.sleep(1000);
//		return "pass";
//
//
//	}
//
//	public void deleteCustomBatch(String batchName)throws Exception
//	{
//
//		element = wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//*[text()='"+batchName+"']//following::a[@data-original-title='Delete']")));
//		element.click();
//
//		Thread.sleep(1000);
//
//		element = wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//button[@id='delete']")));
//		element.click();
//		Thread.sleep(1000);
//
//	}
//
//	public String validateErrorDeleteBatch()
//	{
//		element = wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//*[text()='Confirmation']//following::div[1]")));
//		return element.getText();
//	}
//
//
//
//}
//
//
