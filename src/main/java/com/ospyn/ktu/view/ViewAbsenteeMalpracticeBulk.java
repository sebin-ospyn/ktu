package com.ospyn.ktu.view;
import static org.junit.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.ospyn.ktu.test.Login;
import com.ospyn.ktu.util.SeleniumBase;

public class ViewAbsenteeMalpracticeBulk extends SeleniumBase {
	@FindBy(xpath = "//a[text()='Exam']")
	WebElement exam;
	@FindBy(xpath = "//a[text()='Exams']")
	WebElement exams;
	@FindBy(xpath = "(//a[text()='Student Exam Eligibility'])[1]")
	WebElement studentExamEligibilityMenu;

	//Button to add malpractice
		@FindBy(xpath = "//*[@id=\"add\"]")
		WebElement AddMalpractice;

		@FindBy(xpath = "//*[@id=\"add\"]")
		WebElement BackMalpractice;

		@FindBy(xpath = "//*[@id=\"Submit\"]/span")
		WebElement SubmitMalpractice;

		@FindBy(xpath = "//*[@id=\"back\"]")
		WebElement BackfromSubmitMalpractice;

		@FindBy(xpath = "//*[@id=\"absenteesForm_save\"]")
		WebElement absenteesavebutton;

		@FindBy(xpath = "//*[@id=\"absenteesForm_submit\"]")
		WebElement absenteesubmitbutton;

	String student;
	String course;
	String validationerror;
	static List<String> courseCodes=new ArrayList<String>();
	static Map<String, List<String>> studentData = new HashMap<>();
	static String studentCode;
	public static String alphacode;

	FileInputStream fs;
	XSSFWorkbook workbook;
	static XSSFSheet sheet,sheet1;

	public ViewAbsenteeMalpracticeBulk(WebDriver driver) throws IOException

	{
		//initializing the driver
		super(driver);
		fs = new FileInputStream(new File(System.getProperty("user.dir")+"/Test_Data/PARAMETER_LISTING.xlsx"));
		//Getting the workbook
		workbook = new XSSFWorkbook(fs);
		//Getting the sheet
		sheet = workbook.getSheetAt(8);
		System.out.println(sheet.getRow(1).getCell(1).getStringCellValue());

		//*************************************************************************************

	}
	public WebElement getExam()
	{
		return exam;
	}
	public WebElement getBackfromSubmitMalpractice()
	{
		return BackfromSubmitMalpractice;
	}
	public WebElement getBackMalpractice()
	{
		return BackMalpractice;
	}
	public WebElement getSubmitMalpractice()
	{
		return SubmitMalpractice;
	}
	public WebElement getAbsenteesavebutton()
	{
		return absenteesavebutton;
	}
	public WebElement getAbsenteesubmitbutton()
	{
		return absenteesubmitbutton;
	}
	public WebElement getExams()
	{
		return exams;
	}
	public WebElement getStudentExamEligibility()
	{
		return studentExamEligibilityMenu;
	}





	//*************************************************************************************
	//Entering search criteria
	public void enterDetails() throws InterruptedException

	{
//			Maximize the window
//        driver.manage().window().maximize();
        Thread.sleep(2000);

//		passing the Academic year
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='academicYearId']")));
		Select yeardropdown = new Select(element);
//		yeardropdown.selectByVisibleText(params.get(0));
		System.out.println(sheet.getRow(1));
		yeardropdown.selectByVisibleText(sheet.getRow(1).getCell(1).getStringCellValue());
		Thread.sleep(2000);

		//passing the Program
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"programId\"]")));
		Select Programdropdown = new Select(element);
//		Programdropdown.selectByVisibleText(params.get(1));
		Programdropdown.selectByVisibleText(sheet.getRow(2).getCell(1).getStringCellValue());
		Thread.sleep(2000);

		//passing the Program type
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name=\"programType\"]")));
		Select Progtypedropdown = new Select(element);
//		Progtypedropdown.selectByVisibleText(params.get(2));
		Progtypedropdown.selectByVisibleText(sheet.getRow(3).getCell(1).getStringCellValue());


		//passing the Exam type
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"examDefinitionsForm_examType\"]")));
		Select examtypedropdown = new Select(element);
		examtypedropdown.selectByVisibleText(sheet.getRow(4).getCell(1).getStringCellValue());
//		examtypedropdown.selectByVisibleText(params.get(3));

		Thread.sleep(1000);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'"+(sheet.getRow(5).getCell(1).getStringCellValue())+"')]/../div[2]/a[3]")));
		System.out.println("Exam definition name is "+element);
		element.click();



	}
	public String ValidateText() throws InterruptedException
	{

		//get the error message

		String status = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"page-content-wrapper\"]/div[1]/div/div/div[3]/div[1]/h3"))).getText();

		Thread.sleep(500);
		System.out.println("validate text is "+status);
		return status;

	}
//	fetching course codes
	public void courseCode() throws InterruptedException, AWTException
	{
		List<WebElement> Courselist = driver.findElements(By.xpath("//*[@id='courseMalpractisesTable']/tbody/tr"));
		int CourselistSize= Courselist.size();

		System.out.println("Course"+CourselistSize);

		//Iterating through the course size
		for( int j = 1; j<= CourselistSize;j++)
		{

//			String courseDetails = driver.findElement(By.xpath("//*[@id='courseMalpractisesTable']/tbody/tr["+(j)+"]/td[1]")).getText();
//			// System.out.print(Course);
//
//			course= StringUtils.substringBetween(courseDetails, "(", ")");
//			courseCodes.add(course);
			String courseDetails = driver.findElement(By.xpath("//*[@id='courseMalpractisesTable']/tbody/tr["+(j)+"]/td[1]")).getText();
 			String courseCodesExtract[]= StringUtils.substringsBetween(courseDetails, "(", ")");
			if(courseCodesExtract.length>1)
				courseCodes.add(courseCodesExtract[1]);
			else
				courseCodes.add(courseCodesExtract[0]);
		System.out.println("Courses are "+courseCodes);
			}
	}

	public void StudentExamEligibility()
	{
 		try
		{
			Thread.sleep(1000);
			studentExamEligibilityMenu.click();
			Thread.sleep(1000);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='academicYearId']")));
			Select yeardropdown = new Select(element);
			//passing the Academic year
//			yeardropdown.selectByVisibleText(params.get(0));
			yeardropdown.selectByVisibleText(sheet.getRow(1).getCell(1).getStringCellValue());
			Thread.sleep(2000);

			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name=\"programType\"]")));
			Select Progtypedropdown = new Select(element);
			//passing the Program type
//			Progtypedropdown.selectByVisibleText(params.get(1));
			Progtypedropdown.selectByVisibleText(sheet.getRow(3).getCell(1).getStringCellValue());
			Thread.sleep(2000);

			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"programId\"]")));
			Select Programdropdown = new Select(element);
			//passing the Program
//			Programdropdown.selectByVisibleText(params.get(2));
			Programdropdown.selectByVisibleText(sheet.getRow(2).getCell(1).getStringCellValue());
			Thread.sleep(2000);

			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"examDefId\"]")));
			Select Examropdown = new Select(element);
			//passing the Exam
//			Examropdown.selectByVisibleText(params.get(3));
			Examropdown.selectByVisibleText(sheet.getRow(5).getCell(1).getStringCellValue());
			Thread.sleep(2000);

			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"examDefinitions_eligibility\"]")));
			Select Eligibilitydropdown = new Select(element);
//			Eligibilitydropdown.selectByVisibleText(params.get(4));
			Eligibilitydropdown.selectByVisibleText(sheet.getRow(6).getCell(1).getStringCellValue());
			Thread.sleep(2000);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

}
	public void studentId() throws InterruptedException, AWTException
	{
		System.out.println("Number of courses is "+courseCodes.size());
		String course;

		for(int i=0;i<courseCodes.size();i++)
		{
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"course\"]")));
			course= courseCodes.get(i);
			element.sendKeys(course);
			Thread.sleep(1000);
			Robot robot = new Robot();
			//Pressing the Enter Key
			robot.keyPress(KeyEvent.VK_ENTER);
			//Releasing the Enter Key
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"search\"]/span")).click();
			Thread.sleep(2000);

			//Getting eligible student data from student eligibility table,college side
			List<WebElement> eligibleStudentlist = driver.findElements(By.xpath("//*[@id=\"studentsTable\"]/tbody/tr"));
			int StudentlistSize= eligibleStudentlist.size();
			System.out.println("Student"+StudentlistSize);
			List<String>studentList=new ArrayList<>();
			for( int j = 1; j<= StudentlistSize;j++)
			{
				//getting student details from 1st row,1st column
				String studentDetails = driver.findElement(By.xpath("//*[@id=\"studentsTable\"]/tbody/tr["+(j)+"]/td[1]")).getText();
				student= StringUtils.substringBetween(studentDetails, "(", ")");
				studentData.put(course, studentList);
				studentData.get(course).add(student);
				Set s=studentData.entrySet();
				System.out.println(s);
				System.out.println("**********************");
				System.out.println("Stored "+student+" against course "+course);
				//courseCodes.add(course);

			}
			//to clear course code
			driver.findElement(By.xpath("//*[@id=\"course\"]")).clear();

			System.out.println("Course is "+courseCodes.get(i));
		}
	}
	public void entermalpractice() throws InterruptedException, AWTException
	{
		WebElement element;
		//for(int i=0;i<2;i++) {
		for(int i=0;i<courseCodes.size();i++)
		{

			//String xPath="(//a[@title='Enter Malpractices'])["+(i+1)+"]";
			try {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='courseMalpractisesTable']/tbody/tr["+(i+1)+"]/td[8]/a[1]")));
				System.out.println("************************");
				System.out.println(element.getText());
				System.out.println(element.getText().equalsIgnoreCase("Add Exam Date"));
				System.out.println("************************");

				//if button is Add Exam Date then skip the click  action of that button
				if(!((element.getText()).equalsIgnoreCase("Add Exam Date")) )

				{
					System.out.println(i+ "Value of i");

					element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='courseMalpractisesTable']/tbody/tr["+(i+1)+"]/td[8]/a[1]")));
					element.click();
					Thread.sleep(1000);
					//User clicked malpractice add button
					AddMalpractice.click();

					Robot robot = new Robot();
//					xpath to choose nature of malpractice
					WebElement natureOfMalpractice = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='selNatureOfMalpractice']")));
					natureOfMalpractice.click();
					Thread.sleep(300);
//					xpath for pop up
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@id=\"selectedOffenceId\"])[1]")));
//					clicking 1st nature of malpractice
					element.click();
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='submit']")));
					element.click();
					Thread.sleep(300);

					//entering details in malpractice details field
					WebElement malpracticedetails = driver.findElement(By.xpath("//*[@id=\"studentMalPracticeForm_malpractiseDetails\"]"));
					malpracticedetails.sendKeys("test");
					Thread.sleep(500);


//					**********************************************************************************************************************
//					Entering Attachment section details
//					User entering document type (Malpractice report)
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='attachmentType']")));
					Select Offencedropdown = new Select(element);
 					Offencedropdown.selectByIndex(1);
					//Selecting a valid document
					StringSelection str = new StringSelection("/home/u1464/Desktop/{0} - Data Report (Generated on 04_07_2022 05_15 PM).pdf");
	                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	                clipboard.setContents(str, null);
	                WebElement fileUpload = driver.findElement(By.xpath("//input[@value='Browse...']"));

	                fileUpload.sendKeys(Keys.ENTER);
	                robot.keyPress(KeyEvent.VK_CONTROL);
	                robot.keyPress(KeyEvent.VK_V);

	                robot.keyRelease(KeyEvent.VK_CONTROL);
	                robot.keyRelease(KeyEvent.VK_V);
	                Thread.sleep(300);

	                robot.keyPress(KeyEvent.VK_ENTER);
	                robot.keyRelease(KeyEvent.VK_ENTER);
	                Thread.sleep(1000);

//					//Pressing the Enter Key
//					robot.keyPress(KeyEvent.VK_ENTER);
//					//Releasing the Enter Key
//					robot.keyRelease(KeyEvent.VK_ENTER);
//					Thread.sleep(1000);



//	                User adding another attachment
//	                Xpath of Add button for adding another attachment
	                WebElement addButtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='glyphicon glyphicon-plus']")));
	                addButtn.click();
	                Thread.sleep(300);

//					User entering document type (Malpractice evidence)
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@id='attachmentType'])[2]")));
					Select evidence = new Select(element);
					evidence.selectByIndex(2);
					//Selecting a valid document
					StringSelection strr = new StringSelection("/home/u1464/Desktop/{0} - Data Report (Generated on 04_07_2022 05_15 PM).pdf");
	                Clipboard clipboardd = Toolkit.getDefaultToolkit().getSystemClipboard();
	                clipboardd.setContents(strr, null);
	                WebElement fileUploadd = driver.findElement(By.xpath("(//input[@value='Browse...'])[2]"));
//	                ctrl v code
	                fileUploadd.sendKeys(Keys.ENTER);
	                robot.keyPress(KeyEvent.VK_CONTROL);
	                robot.keyPress(KeyEvent.VK_V);

	                robot.keyRelease(KeyEvent.VK_CONTROL);
	                robot.keyRelease(KeyEvent.VK_V);

	                robot.keyPress(KeyEvent.VK_ENTER);
	                robot.keyRelease(KeyEvent.VK_ENTER);
	                Thread.sleep(1000);

//					//Pressing the Enter Key
//					robot.keyPress(KeyEvent.VK_ENTER);
//					//Releasing the Enter Key
//					robot.keyRelease(KeyEvent.VK_ENTER);
//					Thread.sleep(1000);



//					**********************************************************************************************************************************
					// If there are no students to be entered for malpractice, the script will skip that part and proceed with the loop again. However, if students are present, the conditions in the else block will be executed.
					if(studentData.get(courseCodes.get(i)).get(0)==null)
					{
//						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
						element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='studentMalPracticeForm_Cancel']")));
						element.click();
						Thread.sleep(2000);

						//No malpractice check box click
						element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //*[@id='statusId']")));
						element.click();
						Thread.sleep(1000);

						//submit button click
						SubmitMalpractice.click();
						Thread.sleep(1000);

						//To click yes button from pop-up
						driver.findElement(By.xpath("(//*[@id=\"confirm\"])[2]")).click();
						Thread.sleep(2000);

						//to click back button from malpractice submit page
						BackfromSubmitMalpractice.click();
						Thread.sleep(2000);

					}
					else
					{
						//else block is used to store 1st student from 1st course also passing the student in student field which is showed in malpractice page
						String studentName = studentData.get(courseCodes.get(i)).get(0);
						System.out.println(courseCodes.get(i));
						element = driver.findElement(By.xpath("//*[@id=\"student\"]"));
						element.sendKeys(studentName);
						studentCode=studentName;

						Thread.sleep(2000);
						//Pressing the Enter Key
						robot.keyPress(KeyEvent.VK_ENTER);
						//Releasing the Enter Key
						robot.keyRelease(KeyEvent.VK_ENTER);
						Thread.sleep(1000);


						//Checking previous malpractice details and entering number of occurrence
						String pmd = driver.findElement(By.xpath("//*[@id='total_count']")).getText();
	 					String pmdExtractvalue = StringUtils.substringAfter(pmd, "Total Previous Malpractice Count:").trim();
	 					int convrtdvalue = Integer.parseInt(pmdExtractvalue);
						System.out.println("Total previous malpractice count is "+convrtdvalue);

//						String numberOfOccurrence = String.valueOf((Integer.parseInt((pmdExtractvalue)+1)));
//						System.out.println("NUmber of occurrence is "+numberOfOccurrence);
						int numberOfOccurrence = ((convrtdvalue)+1);
						System.out.println("NUmber of occurrence is "+numberOfOccurrence);

						String cnvrtdnumberOfOccurrence = String.valueOf(numberOfOccurrence);
						System.out.println("NUmber of Actual occurrence is "+cnvrtdnumberOfOccurrence);


						element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='prevMalOccurence']")));
						element.sendKeys(cnvrtdnumberOfOccurrence);
						Thread.sleep(1000);
						//save button click(Use JavaScript to Click the Element:)
//						driver.findElement(By.xpath("//*[@id=\"studentMalPracticeForm_submit\"]")).click();
						element = driver.findElement(By.xpath("//*[@id=\"studentMalPracticeForm_submit\"]"));
//						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("arguments[0].click();", element);
						Thread.sleep(1000);


						//asserting malpractice data entered is equals to data which is listed
						//getting text from malpractice listing page after saving data,only taking student register number using substring
						String validationerror = driver.findElement(By.xpath("//*[@id='malPracticeListingTable']/tbody/tr/td[1]")).getText();
						student= StringUtils.substringBetween(validationerror, "(", ")");
						student=student.substring(1);

						String studentfromeligibility = studentData.get(courseCodes.get(i)).get(0);
						System.out.println("Student is"+student);
						System.out.println("Student from"+studentfromeligibility);
						assertEquals(student, studentfromeligibility);

						Thread.sleep(3000);
						SubmitMalpractice.click();
						Thread.sleep(1000);
						//To click yes button from pop-up
						driver.findElement(By.xpath("(//*[@id=\"confirm\"])[2]")).click();
						Thread.sleep(2000);
						//to click back button from malpractice submit page
						BackfromSubmitMalpractice.click();
						Thread.sleep(2000);
					}
				}

			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}
	public void enterAbsentee() throws InterruptedException
	{

		WebElement element=driver.findElement(By.xpath("//*[@id='examCourseListForm_search']"));
		for(int i=0;i<courseCodes.size();i++)
		{
			try
			{
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

				element=driver.findElement(By.xpath("//*[@id='courseMalpractisesTable']/tbody/tr["+(i+1)+"]/td[8]/a[2]"));
			}
			catch(Exception e)
			{
				continue;

			}
				if(element.isDisplayed())
				{
					element=driver.findElement(By.xpath("//*[@id='courseMalpractisesTable']/tbody/tr["+(i+1)+"]/td[8]/a[2]"));
					Thread.sleep(1000);
					element.sendKeys(Keys.ENTER);
					Thread.sleep(1000);
					absenteesavebutton.click();
					//asserting validation message while saving empty absentee data
					String validationerror = driver.findElement(By.xpath("//*[contains(text(),'Either choose')]")).getText();
					String msg="Either choose one or more Students or mark No Absentees.";
					assertEquals(validationerror, msg);
					Thread.sleep(1000);
					//Passing students in absentee field
					try
					{


						if(studentData.get(courseCodes.get(i)).get(1)!=null)
					{
						System.out.println("within if");
						String studentName=studentData.get(courseCodes.get(i)).get(1);
						System.out.println(studentName);
						System.out.println("student is"+studentName+"*****");
						element = driver.findElement(By.xpath("//*[@id=\"studentId_chosen\"]"));
						Actions action = new Actions(driver);

						action.sendKeys(element, studentName).build().perform();
						Thread.sleep(500);

						Robot robot = new Robot();
						robot.keyPress(KeyEvent.VK_ENTER);
						//Releasing the Enter Key
						robot.keyRelease(KeyEvent.VK_ENTER);
						Thread.sleep(1000);
						System.out.println(element.getText());
						absenteesavebutton.click();
						System.out.println("Absentee Save button clicked!!!!");
					}
					}
					catch(Exception e)
					{
						driver.findElement(By.xpath("//*[@id='noAbsentees']")).click();
					}
					Thread.sleep(2000);

					absenteesubmitbutton.click();
					Thread.sleep(2000);
				}
				}
	}
	public void generatereport() throws InterruptedException, AWTException
	{
		WebElement element;
		for(int i=0;i<courseCodes.size();i++)
		{
			try
			{
				element=driver.findElement(By.xpath("//*[@id='courseMalpractisesTable']/tbody/tr["+(i+1)+"]/td[8]/a[3]"));
				if(element.isDisplayed())
				{
					//element=driver.findElement(By.xpath("//*[@id='courseMalpractisesTable']/tbody/tr["+(i+1)+"]/td[8]/a[3]"));
					element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='courseMalpractisesTable']/tbody/tr["+(i+1)+"]/td[8]/a[3]")));
					element.click();
					Thread.sleep(2000);
					Robot robot = new Robot();

					//Pressing control+A Key
					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_R);

					Thread.sleep(500);

					//Releasing the Control+A KEY
					robot.keyRelease(KeyEvent.VK_R);
					robot.keyRelease(KeyEvent.VK_CONTROL);

					Thread.sleep(1000);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}

		}
	}
	public void packetEntry() throws InterruptedException, AWTException {
 		for(int i=0;i<courseCodes.size();i++)
		{
			try
			{
				WebElement element=driver.findElement(By.xpath("//*[@id='courseMalpractisesTable']/tbody/tr["+(i+1)+"]/td[8]/a[5]"));
				if(element.isDisplayed())
				{
					//To click answersheet packet entry button for first course in course lisitng table
					element=driver.findElement(By.xpath("//*[@id='courseMalpractisesTable']/tbody/tr["+(i+1)+"]/td[8]/a[5]"));
					element.click();
					Thread.sleep(1000);
					break;
				}

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	public String answersheetError() throws InterruptedException{
		//user validating error message if trying to enter packets before submitting additional replaced barcode details
//		String status = wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//div[text()='Packet entry cannot be done without submitting additional barcode used details and Packet entry cannot be done. Valuation camp configuration is not complete. Please contact University.']"))).getText();
						String status = wait.until(ExpectedConditions.visibilityOfElementLocated(
								By.xpath("//div[text()='Packet entry cannot be done without submitting additional barcode used details']"))).getText();
		wait.until(ExpectedConditions.visibilityOf(BackfromSubmitMalpractice)).click();
		return status;



	}
	public void savenulldata() throws InterruptedException, AWTException {
		//		for(int i=0;i<1;i++)
		for(int i=0;i<courseCodes.size();i++)
		{
			try
			{
				WebElement element=driver.findElement(By.xpath("//*[@id='courseMalpractisesTable']/tbody/tr["+(i+1)+"]/td[8]/a[4]"));
				if(element.isDisplayed())
				{
					element=driver.findElement(By.xpath("//*[@id='courseMalpractisesTable']/tbody/tr["+(i+1)+"]/td[8]/a[4]"));
					element.click();

					Thread.sleep(2000);
					driver.findElement(By.xpath("//*[@id=\"damangedAnserSheetForm_Save\"]/span")).click();
					//asserting validation message while saving empty replaced bar code page
					String validationerror1 = driver.findElement(By.xpath("//*[contains(text(),'You must enter a value for Student Name')]")).getText();
					String validationerror2 = driver.findElement(By.xpath("//*[contains(text(),'You must enter a value for Reason')]")).getText();
					String validationerror3 = driver.findElement(By.xpath("//*[contains(text(),'You must enter a value for Select Facing Sheet Code')]")).getText();

					String msg="You must enter a value for Student Name\n"
							+ "You must enter a value for Reason\n"
							+ "You must enter a value for Select Facing Sheet Code";

					assertEquals(validationerror1+"\n"+validationerror2+"\n"+ validationerror3,msg);
					Thread.sleep(1000);
					BackfromSubmitMalpractice.click();
					break;
				}

			}


			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	public void collegelogout() throws InterruptedException, AWTException {

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a[@href='/university/logout.htm']")));
		element.click();
		Thread.sleep(2000);


	}
	public void Valuationmodule() throws InterruptedException, AWTException {

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='10']/a")));
		element.click();
		Thread.sleep(2000);

	}
	public void Barcodeget() throws InterruptedException, AWTException {
		try {
		Thread.sleep(1000);
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'View Generated False Numbers')]"));
//		added javaScript executer for to click element.
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);
 		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='academicYearId']")));
		Select yeardropdown = new Select(element);
		//passing the Academic year
		System.out.println(sheet.getRow(1).getCell(1).getStringCellValue());
		yeardropdown.selectByVisibleText(sheet.getRow(1).getCell(1).getStringCellValue());
 		Thread.sleep(1000);

		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"programId\"]")));
		Select Programdropdown = new Select(element);
		//passing the Program
		System.out.println(sheet.getRow(2).getCell(1).getStringCellValue());
		Programdropdown.selectByVisibleText(sheet.getRow(2).getCell(1).getStringCellValue());
		Thread.sleep(1000);

		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"examDefinition\"]")));
		Select Examropdown = new Select(element);
		//passing the Exam
		System.out.println(sheet.getRow(5).getCell(1).getStringCellValue());
		Examropdown.selectByVisibleText(sheet.getRow(5).getCell(1).getStringCellValue());
		Thread.sleep(1000);

		//College name
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"institution\"]")));
		System.out.println(sheet.getRow(8).getCell(Login.getColumn()).getStringCellValue());
		element.sendKeys(sheet.getRow(8).getCell(Login.getColumn()).getStringCellValue());
		Thread.sleep(500);
		Robot robot = new Robot();
		//Pressing the Enter Key
		robot.keyPress(KeyEvent.VK_ENTER);
		//Releasing the Enter Key
		robot.keyRelease(KeyEvent.VK_ENTER);

//		Passing false number validity
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"falseNoForInstitutionForm_validSel\"]")));
		Select FalsenumberValidity = new Select(element);
		System.out.println(sheet.getRow(7).getCell(1).getStringCellValue());
		FalsenumberValidity.selectByVisibleText(sheet.getRow(7).getCell(1).getStringCellValue());
		Thread.sleep(2000);

		Thread.sleep(1000);
		//search button click
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"falseNoForInstitutionForm_search\"]")));
		element.click();
 		Thread.sleep(1000);
		}
		catch(Exception e)
		{
			e.printStackTrace();		}

	}
	public void getfalsenumber() throws InterruptedException, AWTException {
		//get student alphacode

		alphacode = driver.findElement(By.xpath(" //*[contains(text(),\"SR-\")]")).getText();
		System.out.println(alphacode);
	}
	public void universitylogout() throws InterruptedException, AWTException {
		try {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a[@href=\"/university/logout.htm\"]")));
		element.click();
		Thread.sleep(2000);
		}
		catch(Exception e) {
		e.printStackTrace();
		}

	}
	public void replacedbarcode() throws InterruptedException, AWTException {
		for(int i=0;i<courseCodes.size();i++)
		{
			try
			{
				WebElement element=driver.findElement(By.xpath("//*[@id='courseMalpractisesTable']/tbody/tr["+(i+1)+"]/td[8]/a[4]"));
				if(element.isDisplayed())
				{
					element=driver.findElement(By.xpath("//*[@id='courseMalpractisesTable']/tbody/tr["+(i+1)+"]/td[8]/a[4]"));
					element.click();
					String studentName = studentData.get(courseCodes.get(i)).get(1);
					System.out.println("Student data fetched to enter "+studentName);
					element = driver.findElement(By.xpath("//*[@id=\"student\"]"));
				    element.sendKeys(studentName);
					studentCode=studentName;
					Thread.sleep(1000);
					break;
				}

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

	}
	public String errorabsenteefalse() throws InterruptedException{
		//user validating error message
		String status = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[contains(text(),'No Record found')]"))).getText();
		return status;
	}
	public void replacedfacesheet() throws InterruptedException, AWTException {

		int flag=0;
		System.out.println(courseCodes.size());
		Thread.sleep(1000);
		for(int i=0;i<courseCodes.size();i++)
		{
			System.out.println("Value of i is "+i);
			try
			{
				Thread.sleep(1000);
				WebElement element=driver.findElement(By.xpath("//*[@id='courseMalpractisesTable']/tbody/tr["+(i+1)+"]/td[8]/a[4]"));
				if(element.isDisplayed())
				{
					//To click answer sheet packet entry button for first course in course listing table
					element=driver.findElement(By.xpath("//*[@id='courseMalpractisesTable']/tbody/tr["+(i+1)+"]/td[8]/a[4]"));
					element.sendKeys(Keys.ENTER);
//					element.click();
					Thread.sleep(1000);
					if(flag==0)
					{
						try {
						String studentName = studentData.get(courseCodes.get(i)).get(0);
						element = driver.findElement(By.xpath("//*[@id=\"student\"]"));
						element.sendKeys(studentName);
						studentCode=studentName;
						flag=1;

						Thread.sleep(1000);
						Robot robot = new Robot();
						//Pressing the Enter Key
						robot.keyPress(KeyEvent.VK_ENTER);
						//Releasing the Enter Key
						robot.keyRelease(KeyEvent.VK_ENTER);
						Thread.sleep(1000);
						//code to enter text "test"
						WebElement facesheetchangereason = driver.findElement(By.xpath("//*[@id=\"reasonId\"]"));
						facesheetchangereason.sendKeys("test");
						Thread.sleep(1000);
						robot.keyPress(KeyEvent.VK_ENTER);
						robot.keyRelease(KeyEvent.VK_ENTER);
						//user passing barcode
						element = driver.findElement(By.xpath("//*[@id=\"randamCode\"]"));
						Actions action = new Actions(driver);
						action.sendKeys(element, alphacode).build().perform();
						Thread.sleep(1000);
						robot.keyPress(KeyEvent.VK_ENTER);
						robot.keyRelease(KeyEvent.VK_ENTER);

						//replaced barcode save  button click
						element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"damangedAnserSheetForm_Save\"]")));
						element.click();
						Thread.sleep(2000);
						//asserting  replaced barcode
						String replacedbarcode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[7]/div[1]/div/div/div[3]/div[2]/div/div[2]/table/tbody/tr/td[3]"))).getText();
 						System.out.println("Student is "+replacedbarcode);
 						System.out.println("alphacode is "+alphacode);
 						assertEquals(replacedbarcode, alphacode);
						}
						catch(Exception e) {
							//System.out.println("Within...............else.");
							element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"noDamage\"]")));
							element.click();
							Thread.sleep(2000);

						}
					}
					else
						//user marking barcode entering page as No replaced barcode and submit
					{
						//System.out.println("Within...............else.");
						element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"noDamage\"]")));
						element.click();
						Thread.sleep(2000);
					}
					}
					}
			catch(Exception e)
			{
			continue;
			}
			//replaced barcode submit  button click
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='submitFrom_Submit']")));
			element.click();
			//To click pop up yes button
			Thread.sleep(1000);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			}
	  		}
public void answersheet () throws InterruptedException, AWTException{
		for(int i=0;i<courseCodes.size();i++)
		{
			try
			{
				WebElement element=driver.findElement(By.xpath("//*[@id='courseMalpractisesTable']/tbody/tr["+(i+1)+"]/td[8]/a[6]"));
				if(element.isDisplayed())
				{
					//To click answersheet packet entry button for first course in course listing table
					element=driver.findElement(By.xpath("//*[@id='courseMalpractisesTable']/tbody/tr["+(i+1)+"]/td[8]/a[6]"));
					element.click();
					Thread.sleep(1000);

					try {
//					xpath for no answer sheet pack check box
					WebElement  checkBox = driver.findElement(By.xpath("//*[@id='noAnswerScripts']"));
					  	checkBox.click();
						Thread.sleep(300);
						WebElement  submit=driver.findElement(By.xpath("//*[@id='searchForm_submitNoAnswerSheet']"));
						submit.click();
					Thread.sleep(1000);
					}
					catch(Exception e)
					{
//						save button click
						element=driver.findElement(By.xpath("//*[@id=\"searchForm_submit\"]\n"));
						element.click();
						Thread.sleep(1000);
//						Submit button click
						element=driver.findElement(By.xpath("//*[@id=\"searchForm_finalSubmit\"]\n "));
						element.click();
						Thread.sleep(2000);
					}
					}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}


	}
public void clearall()
{
	courseCodes.clear();
	studentData.clear();
}




}
