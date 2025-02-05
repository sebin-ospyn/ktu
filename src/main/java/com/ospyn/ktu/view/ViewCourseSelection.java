package com.ospyn.ktu.view;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.ospyn.ktu.util.SeleniumBase;

public class ViewCourseSelection extends SeleniumBase
{
	//getting elements by xpath
	@FindBy(xpath = "//a[text()='Academics']")
	WebElement academics;

	@FindBy(xpath = "//a[text()='University']")
	WebElement university;

	@FindBy(xpath = "//a[text()='University Inbox']")
	WebElement universityInbox;

	@FindBy(xpath="//a[text()='Course Details']")
	WebElement courseDetails;

	public String str="";
	private String status="Submit";

	private String semester="S6";
	private FileInputStream fs;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;

	public ViewCourseSelection(WebDriver driver) throws Exception

	{
		//initializing the driver
		super(driver);

		fs = new FileInputStream(new File(System.getProperty("user.dir")+"/Test_Data/PARAMETER_LISTING.xlsx"));

		//Getting the workbook
	     workbook = new XSSFWorkbook(fs);

		//Getting the sheet
		sheet = workbook.getSheetAt(1);

	}

	public void setStatus(String status)
	{
		this.status=status;
	}

	public String getStatus()
	{
		return status;
	}
	//returning Academics tab
	public WebElement getAcademics()

	{

		return academics;

	}
	//Returning University Inbox from the side menu
	public WebElement getUniversityInbox()

	{

		return universityInbox;

	}

	//returning Course Details link from side menu

	public WebElement getCourseDetailsLink()
	{
		return courseDetails;

	}
	//returning University tab

	public WebElement getUniversity()

	{

		return university;

	}

	//Returning the search button
	public WebElement getSearch()

	{

		WebElement searchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//button[contains(@id,'search')]")));

		return searchButton;

	}
	//Entering search criteria
	public void enterDetails() throws Exception

	{

		System.out.println(sheet.getRow(1).getCell(1).getStringCellValue());

		//Getting the academic year(Eg:2022 - 2023)
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='academicYearId']")));

		//Using dropdown to select the Year
		Select yeardropdown = new Select(element);
		System.out.println(yeardropdown.getFirstSelectedOption().getText()+"");
		//Selecting the parameter passed, from the dropdown
		yeardropdown.selectByVisibleText(sheet.getRow(1).getCell(1).getStringCellValue());
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS)	;

		//Selecting Program(B.Tech/M.Tech/...)

		element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='universityProgramId']")));
		Select programClick = new Select(element);


		programClick.selectByVisibleText(sheet.getRow(2).getCell(1).getStringCellValue());
		Thread.sleep(1000);


		//Getting the type(Full Time/Part Time/PhD)
		element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='programType']")));

		Select programTypeClick=new Select(element);
		programTypeClick.selectByVisibleText(sheet.getRow(3).getCell(1).getStringCellValue());
		Thread.sleep(1000);

		//Getting the Semester(S1/S2/....)
		element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='semester']")));

		Select semesterClick=new Select(element);
		semesterClick.selectByVisibleText(sheet.getRow(4).getCell(1).getStringCellValue());
		semester=sheet.getRow(4).getCell(1).getStringCellValue();
		Thread.sleep(1000);

		//Getting the Degree Type(Regular/Honors/Minor)
		element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='registrationType']")));

		Select registrationTypeClick=new Select(element);
		registrationTypeClick.selectByVisibleText(sheet.getRow(5).getCell(1).getStringCellValue());
		Thread.sleep(1000);


	}

	public void enterDetailsWithRequestType()throws Exception
	{
		enterDetails();

		//Getting the Course Selection For(Pursuing Students/Trailing Students)
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='registrationTypeId']")));

		Select courseTypeClick=new Select(element);
		courseTypeClick.selectByVisibleText(sheet.getRow(6).getCell(1).getStringCellValue());
		Thread.sleep(1000);
	}

	/*Getting the Choose Course button for branches of the college
	 * and returning the button
	 */
	public WebElement getChooseCourseButton()
	{

		WebElement chooseCourse=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a[@class='list-group-item active ']//following::a[text()='Choose Courses (Not done yet)']")));

		return chooseCourse;

	}
	/*Getting the Save button for adding courses to slots of a college
	 * and returning the button
	 */
	public WebElement getSaveButton()
	{

		WebElement saveButton=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.id("courseSelectionForm_save")));

		return saveButton;

	}

	//Getting the error message
	public String getErrorMessage()
	{
		WebElement errorMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='alert alert-danger col-sm-12']	")));

		return errorMessage.getText();

	}

	/*Adding courses to slots for branches of a college
	 *
	 */

	public String selectCoursesInSlots()
	{
		String result="pass";
		try
		{
			List<WebElement> courseClick = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
					By.xpath("//option[@selected='selected' and @value='']/parent::*")));
			Thread.sleep(1000);
			Select courseDropDown;
			List<WebElement>  option;
			String slot=" ";

			for(WebElement element:courseClick)

			{
				//Selecting only one course  from one slot

				if(!(element.getAttribute("id").startsWith(slot)))
				{
					courseDropDown = new Select(element);
					option=courseDropDown.getOptions();

					if(status.equals("Submit"))
						courseDropDown.selectByVisibleText(option.get(1).getText());
					else
					{
						if(option.size()>2)
							courseDropDown.selectByVisibleText(option.get(2).getText());

						Thread.sleep(1000);


					}
					slot=element.getAttribute("id").substring(0,element.getAttribute("id").indexOf("_"));

					Thread.sleep(2000);
				}
			}
		}
		catch(Exception e)
		{
			result="fail";
		}




		return result;



	}

	//Getting saved message and returning it
	public WebElement showSavedMessage()

	{

		WebElement success = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[text()=\'Saved Successfully\']")));
		return success;

	}


	//Getting error message while searching for empty fields and returning it
	public WebElement getSearchError()
	{
		WebElement searchError = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class = 'alert alert-danger' and contains(text(),'Please')]")));

		return searchError;
	}

	//Getting error message while selecting part time courses
	public WebElement getPartTimeError()
	{
		WebElement partTimeError= wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class = 'alert alert-warning' and contains(text(),'Course Selection')]")));
		return partTimeError;

	}
	//Getting export button and returning the button
	public WebElement getExportCouseButton()
	{
		WebElement exportButton= wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a[@class='btn btn-danger btn-xs pull-right']")));
		return exportButton;

	}
	//Returning the excel file downloaded during the export
	public File getExcelFile()throws Exception

	{
		File dir = new File("/home/u1602/Downloads/");

		File[] foundFiles = dir.listFiles(new FilenameFilter()

		{

			//Checking all files that starts with College  and returning the first file
			@Override
			public boolean accept(File foundFiles, String name)

			{

				return name.startsWith("College");

			}
		});


		return foundFiles[0];
	}

	//Checking the excel file content
	public String getExcelFileContent(File f) throws Exception
	{


		FileInputStream fs = new FileInputStream(f);

		//Getting the workbook
		HSSFWorkbook workbook = new HSSFWorkbook(fs) ;

		//Getting the sheet
		HSSFSheet sheet = workbook.getSheetAt(0);

		//	Getting the first row
		Row row = sheet.getRow(1);

		//	Getting the first cell of the first row
		Cell cell = row.getCell(0);

		//Getting the value of the first cell
		String content=cell.getStringCellValue();

		return(content);

	}
	//Returning list of all the courses available
	public List<WebElement> getCourses()

	{

		List<WebElement> elements=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				By.xpath("//a[@class='btn btn-xs btn-warning pull-right']")));
		return elements;

	}


	//Getting the back button
	public WebElement getBackButton()
	{
		WebElement backButton=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.id("back")));
		return backButton;


	}
	//Getting the submit button
	public WebElement getSubmitButton()
	{

		WebElement submitButton=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a[@class='btn btn-success btn-sm pull-right']")));

		return submitButton;


	}
	//Getting the confirmation Yes button

	public WebElement getConfirmYes1()

	{
		WebElement confirmYes=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='courseSubmission']/..//div[4]//*[@id='delete']")));

		return confirmYes;


	}

	//Getting the confirmation No button

	public WebElement getConfirmNo2()

	{

		WebElement confirmNo=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='courseSubmission']/..//div[4]//*[text()='No']")));

		return confirmNo;

	}
	//Getting the error label

	public WebElement getErrorLabel()
	{

		WebElement errorLabel=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[contains(text(),'not completed')]")));
		return errorLabel;

	}
	//Getting the confirmation No button
	public WebElement getConfirmNo()

	{
		WebElement confirmNo=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[contains(text(),'Course selection')]/following::button[2]")));

		return confirmNo;

	}
	//Getting the Success Label

	public WebElement getSuccessLabel()

	{

		WebElement successLabel=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[contains(text(),'Your')]")));
		return successLabel;


	}
	//Getting error message of curriculum  not added
	public WebElement getErrorMessage1()

	{
		WebElement errorLabel=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[contains(text(),'curriculum')]")));

		return errorLabel;

	}

	//Getting error message of Last Date for course selection
	public WebElement getDateOverMessage()
	{
		WebElement errorLabel=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[contains(text(),'Last date for course selection')]")));

		return errorLabel;
	}

	//Getting the ViewCurriculum button
	public WebElement getViewCurriculum()

	{
		WebElement viewButton=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a[@class='btn btn-xs btn-success pull-right']")));

		return viewButton;

	}

	//Getting Add Course button
	public WebElement getAddCourse()

	{
		WebElement addButton=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//span[text()='Add Course']")));
		System.out.println("getting Add course");

		return addButton;

	}
	//Filling slots for courses in branches of college
	public void fillSlots()
	{
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.id("schemeId")));

		Select Id1=new Select(element);

		Id1.selectByIndex(1);

		element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.id("slotId")));

		//Finding the slots which have courses offered
		Id1=new Select(element);

		List<WebElement> options=Id1.getOptions();
		options.remove(0);
		for(WebElement opt:options)
		{
			Id1.selectByVisibleText(opt.getText());
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.id("courseId")));
			Select Id2=new Select(element);
			if(Id2.getOptions().size()>1)
			{
				Id2.selectByIndex(1);
				//storing the value in a string
				str=Id2.getFirstSelectedOption().getText();
				break;
			}
			try
			{
				Thread.sleep(1000);
			}
			catch(Exception e)
			{
				System.out.print(e);
			}

		}

	}

	//Getting the submit button for submitting branches to university
	public WebElement getSaveButton1()
	{
		WebElement saveButton=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.id("submitBtn")));

		return saveButton;

	}

	//Getting Saved course message for validating saved course
	public WebElement getSavedCourse()
	{
		str=str.substring(str.indexOf("-")+1);

		String xpath="//td[contains(text(),'"+str+"')]";


		WebElement course=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(xpath)));

		return course;

	}


	public String getSelectedValue()

	{
		return str;

	}

	public void enterDetailsCourse() throws InterruptedException, AWTException

	{


		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.id("academicYearId")));


		Select dropdown = new Select(element);
             System.out.println(sheet.getRow(1).getCell(1).getStringCellValue());

		dropdown.selectByVisibleText(sheet.getRow(1).getCell(1).getStringCellValue());
		Thread.sleep(1000);


		element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.id("requestType")));

		dropdown = new Select(element);

		System.out.println("reg type="+sheet.getRow(7).getCell(1).getStringCellValue());
		dropdown.selectByVisibleText(sheet.getRow(7).getCell(1).getStringCellValue());
		Thread.sleep(1000);

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);



		element = wait.until(ExpectedConditions.visibilityOfElementLocated(

				By.id("inst")));
		element.clear();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		element.sendKeys(sheet.getRow(8).getCell(1).getStringCellValue());

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Pressing the Enter Key


		Thread.sleep(1000);


		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);


		element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.id("programType")));

		dropdown = new Select(element);
		System.out.println("program Type"+sheet.getRow(2).getCell(1).getStringCellValue());

		dropdown.selectByVisibleText(sheet.getRow(2).getCell(1).getStringCellValue());
		Thread.sleep(1000);

		element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.id("degreeType")));

		dropdown = new Select(element);
		System.out.println("degree TYpe"+sheet.getRow(5).getCell(1).getStringCellValue());

		dropdown.selectByVisibleText(sheet.getRow(5).getCell(1).getStringCellValue());
		Thread.sleep(1000);

		element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.id("registrationTypeId")));

		dropdown = new Select(element);
		System.out.println("Registration type="+sheet.getRow(6).getCell(1).getStringCellValue());

		dropdown.selectByVisibleText(sheet.getRow(6).getCell(1).getStringCellValue());
		Thread.sleep(1000);

	}



	public WebElement  getCollegeName()

	{
		WebElement collegeNameLink=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//span[text()='"+semester+"']//preceding::a[3]")));

		return collegeNameLink;

	}

	public WebElement getCoursesButton()
	{
		WebElement collegeNameLink=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a[@class='btn btn-xs btn-success pull-right']")));

		return collegeNameLink;

	}



	public WebElement getChangeCourseButton()
	{
		WebElement changeCourse=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//span[text()='Change Course']")));

		return changeCourse;

	}

	public void selectSlotScheme()

	{
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.id("curriculumSlotId")));

		Select dropdown = new Select(element);


		dropdown.selectByIndex(1);
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{

		}

		element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.id("schemeSelect")));

		dropdown = new Select(element);


		dropdown.selectByIndex(1);
		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{

		}


	}

	public WebElement getRemoveButton()
	{
		WebElement removeButton=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//button[contains(@id,'remove')]")));

		return removeButton;
	}

	public void clickYesButton() throws Exception

	{

		String parentWindow = driver.getWindowHandle();

		Set<String> handles = driver.getWindowHandles();

		for (String windowHandle : handles)
		{

			if (!windowHandle.equals(parentWindow))

			{

				driver.switchTo().window(windowHandle);

				Thread.sleep(3000);
			}

		}
		Robot robot = new Robot();

		//Pressing the Enter Key
		robot.keyPress(KeyEvent.VK_ENTER);

		//Releasing the Enter Key
		robot.keyRelease(KeyEvent.VK_ENTER);
	}


	public WebElement getSaveButton2()
	{
		WebElement saveButton=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//input[@id='courseId']//following::button[1]")));

		return saveButton;

	}

	public WebElement getCancelButton()
	{
		WebElement cancelButton=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='modal-footer ']/button[2]")));

		return cancelButton;

	}

	public WebElement getBackButton1()
	{
		WebElement backButton=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.id("add")));

		return backButton;

	}

	public WebElement getCheckBox()

	{
		WebElement checkbox=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='checkRevoke']")));

		return checkbox;

	}

	public void storeBranchName()

	{
		WebElement branchName=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//input[@id='checkRevoke']/preceding::a[@class='list-group-item active'])[1]")));

		str=" "+branchName.getText();
		System.out.println(str);

	}

	public WebElement getRevokeButton()

	{
		WebElement revoke=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.id("branchListingForm_saveRevoke")));

		return revoke;

	}

	public WebElement getConfirmYes3()

	{
		WebElement yes=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[text()='Are you sure to revoke course selection ?']//following::button[1]")));

		return yes;

	}

	public String getRevokedMessage()
	{
		//getting the message when the course is revoke
		String msg=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[text()='"+str+"']/following::label"))).getText();
		return msg;
	}
	public WebElement getErrorMsg()

	{
		WebElement error=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[contains(text(),'Revoke')]")));

		return error;

	}

	public void chooseAllCourses()throws Exception

	{
		boolean isPresent = driver.findElements(By.xpath("//a[@class='list-group-item active ']//following::a[text()='Choose Courses (Not done yet)']")).size() > 0;

		if(isPresent)
		{

			List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
					By.xpath("//a[@class='list-group-item active ']//following::a[text()='Choose Courses (Not done yet)']")));

			WebElement button;


			for(int i=0;i<elements.size();i++)

			{


				try {


					Thread.sleep(1000);
					button= wait.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath("//a[@class='list-group-item active ']//following::a[text()='Choose Courses (Not done yet)']")));

					button.sendKeys(Keys.ENTER);
					Thread.sleep(1000);

					selectCoursesInSlots();
					Thread.sleep(1000);

					WebElement element=getSaveButton();
					element.sendKeys(Keys.ENTER);
					Thread.sleep(1000);

					element=getBackButton();
					element.sendKeys(Keys.ENTER);

					Thread.sleep(1000);


				}


				catch(Exception e)

				{

					System.out.println(e);

				}


			}
			driver.navigate().refresh();

		}


	}

	public WebElement getNoButton()

	{
		WebElement no=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[text()='Are you sure to revoke course selection ?']//following::button[2]")));

		//	    		WebElement no=wait.until(ExpectedConditions.visibilityOfElementLocated(
		//					      By.xpath("//button[@id='confirmNo']")));
		return no;
		//driver.switchTo().alert().dismiss();

	}


	public WebElement  getCollegeName1()

	{
		WebElement collegeName=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//span[text()='S8']//following::a[1]")));

		return collegeName;

	}

	public WebElement getRevokeLabel()

	{
		WebElement collegeLabel=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//b[text()='"+str+"']//following::label[1]")));

		return collegeLabel;


	}
	public void chooseAllCoursesRevoked()throws Exception

	{
		boolean isPresent = driver.findElements(By.xpath("//a[contains(text(),'Choose Courses (Revoked)')]")).size() > 0;

		if(isPresent)
		{
			try {

				WebElement button= wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//a[contains(text(),'Choose Courses (Revoked)')]")));

				button.sendKeys(Keys.ENTER);

				selectCoursesInSlots();

				getSaveButton().sendKeys(Keys.ENTER);
				Thread.sleep(1000);

				getBackButton().sendKeys(Keys.ENTER);
				Thread.sleep(1000);

			}

			catch(Exception e)

			{

				System.out.println(e);

			}


		}
		driver.navigate().refresh();


	}


}

