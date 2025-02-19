package com.ospyn.ktu.view;
import static org.testng.AssertJUnit.assertEquals;

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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.ospyn.ktu.util.SeleniumBase;

public class ViewAbsMalRegression extends SeleniumBase {

	@FindBy(xpath = "//a[text()='Exam']")
	WebElement exam;
	@FindBy(xpath = "//a[text()='Exams']")
	WebElement exams;
	@FindBy(xpath = "(//a[text()='Student Exam Eligibility'])[1]")
	WebElement studentExamEligibilityMenu;

	//Button to add MalPractise
	@FindBy(xpath = "//*[@id=\"add\"]")
	WebElement AddMalpractice;

	@FindBy(xpath = "//*[@id=\"add\"]")
	WebElement BackMalpractice;

	@FindBy(xpath = "//*[@id=\"Submit\"]/span")
	WebElement SubmitMalpractice;

	@FindBy(xpath = "//*[@id='studentMalPracticeForm_Cancel']")
	WebElement CancelfromMalpracticeform;

	@FindBy(xpath = "//*[@id=\"back\"]")
	WebElement BackfromSubmitMalpractice;

	@FindBy(xpath = "//*[@id=\"absenteesForm_save\"]")
	WebElement absenteesavebutton;

	@FindBy(xpath = "//*[@id=\"absenteesForm_submit\"]")
	WebElement absenteesubmitbutton;

	@FindBy(xpath = "//a[text()='Back']")
	WebElement absenteebackbutton;

	@FindBy(xpath = "//*[@id='studentId_chosen']")
	WebElement absentEnteringField;

	@FindBy(xpath = "//*[text()=' Back']")
	WebElement MalpracticeBackButton;

	@FindBy(xpath = "//*[@id='studentMalPracticeForm_submit']")
	WebElement SaveMalpractice;


	public WebElement getSaveMalpractice() {
		return SaveMalpractice;
	}
	public WebElement getMalpracticeBackButton() {
		return MalpracticeBackButton;
	}
	public WebElement getAbsentEnteringField() {
		return absentEnteringField;
	}
	public WebElement getAbsenteebackbutton() {
		return absenteebackbutton;
	}
	public WebElement getCancelfromMalpracticeform() {
		return CancelfromMalpracticeform;
	}

 	String course;
	String student;
	String absenteeEnteredCourse;
	String student1;
	static String studentCode;
	int allAbsentee=0;
	int StudentlistSize;
	static int CoursEligibleStudentSize;
	static int CoursInEligibleStudentSize;
	static int allAbsenteeSize;

	static List<String> courseCodes=new ArrayList<String>();
	static List<String> Coursecodedetails=new ArrayList<String>();
//	Valid student list
	static Map<String, List<String>> studentData = new HashMap<>();
//	Invalid student list
	static Map<String, List<String>> notEligibleStudentdata = new HashMap<>();
//	absent students list
	static List<String> absenteeMarkedStudentsList=new ArrayList<String>();

//	Used to store eligible student reg number,against a one course
	static List<String>studentRegNo=new ArrayList<String>();

//	Used to store in-eligible student register number,against a one course
	static List<String>inEligiblestudentRegNo=new ArrayList<String>();

//	Used to store absentee students by using all absentee check box
	static List<String>allAbsenteeRegNum=new ArrayList<String>();

	static List<String>AbsenteeForMalpractice= new ArrayList<String>();
	FileInputStream fs;
    XSSFWorkbook workbook;
    static XSSFSheet sheet;

	public ViewAbsMalRegression(WebDriver driver) throws IOException {
		super(driver);

		fs = new FileInputStream(new File(System.getProperty("user.dir")+"/Test_Data/PARAMETER_LISTING.xlsx"));

        //Getting the workbook
         workbook = new XSSFWorkbook(fs);
        //Getting the sheet
        sheet = workbook.getSheetAt(8);
        System.out.println(sheet.getRow(1).getCell(1).getStringCellValue());

 	}

//******************************************************************************
	public WebElement getExam()
	{
		return exam;
	}
	public WebElement getBackfromSubmitMalpractice() {
		return BackfromSubmitMalpractice;
	}
	public WebElement getBackMalpractice() {
		return BackMalpractice;
	}
	public WebElement getSubmitMalpractice() {
		return SubmitMalpractice;
	}
	public WebElement getAbsenteesavebutton() {
		return absenteesavebutton;
	}
	public WebElement getAbsenteesubmitbutton() {
		return absenteesubmitbutton;
	}
	public WebElement getExams() {
		return exams;
	}
	public WebElement getStudentExamEligibility() {
		return studentExamEligibilityMenu;
	}
			//Entering search criteria
			public void enterDetails() throws InterruptedException
			{
				//Parameters
//				List<String> params = new ArrayList<>();

//				params = Arrays.asList(examDetails.split(","));
			    //passing the Academic year
				WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='academicYearId']")));
				Select yeardropdown = new Select(element);
 				yeardropdown.selectByVisibleText(sheet.getRow(1).getCell(1).getStringCellValue());
//				yeardropdown.selectByVisibleText(params.get(0));
				Thread.sleep(2000);

				//passing the Program
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"programId\"]")));
				Select Programdropdown = new Select(element);
//				Programdropdown.selectByVisibleText(params.get(1));
				Programdropdown.selectByVisibleText(sheet.getRow(2).getCell(1).getStringCellValue());
				Thread.sleep(2000);

				//passing the Program type
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name=\"programType\"]")));
				Select Progtypedropdown = new Select(element);
//				Progtypedropdown.selectByVisibleText(params.get(2));
				Progtypedropdown.selectByVisibleText(sheet.getRow(3).getCell(1).getStringCellValue());

				//passing the Exam type
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"examDefinitionsForm_examType\"]")));
				Select examtypedropdown = new Select(element);
//				examtypedropdown.selectByVisibleText(params.get(3));
				examtypedropdown.selectByVisibleText(sheet.getRow(4).getCell(1).getStringCellValue());

				Thread.sleep(1000);
//				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'"+params.get(4)+"')]/../div[2]/a[3]")));
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'"+sheet.getRow(5).getCell(1).getStringCellValue()+"')]/../div[2]/a[3]")));
				element.click();

			}
			public String ValidateText() throws InterruptedException {
				//get the error message
				String status = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"page-content-wrapper\"]/div[1]/div/div/div[3]/div[1]/h3"))).getText();
				Thread.sleep(500);
				System.out.println("validate text is "+status);
				return status;
			}
//			CourseCode method is used to store listed courses
			public void courseCode() throws InterruptedException, AWTException {
				List<WebElement> Courselist = driver.findElements(By.xpath("//*[@id='courseMalpractisesTable']/tbody/tr"));
				int CourselistSize= Courselist.size();
				System.out.println("Course"+CourselistSize);
				//Iterating through the course size
				for( int j = 1; j<= CourselistSize;j++)
				{
					String courseDetails = driver.findElement(By.xpath("//*[@id='courseMalpractisesTable']/tbody/tr["+(j)+"]/td[1]")).getText();
					// System.out.print(Course);
					String courseCodesExtract[]= StringUtils.substringsBetween(courseDetails, "(", ")");
					if(courseCodesExtract.length>1)
						courseCodes.add(courseCodesExtract[1]);
					else
						courseCodes.add(courseCodesExtract[0]);
					System.out.println("Courses are "+courseCodes);
				}
			}
			public void StudentExamEligibility(int id)
			{
				System.out.println("within view");
				try
				{
					Thread.sleep(1000);
					studentExamEligibilityMenu.click();
					Thread.sleep(1000);
					//Parameters
					List<String> params = new ArrayList<>();
//					params = Arrays.asList(StudentDetails.split(",#"));

					WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='academicYearId']")));
					Select yeardropdown = new Select(element);
					//passing the Academic year
//					yeardropdown.selectByVisibleText(params.get(0));
	 				yeardropdown.selectByVisibleText(sheet.getRow(1).getCell(1).getStringCellValue());



					Thread.sleep(2000);
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name=\"programType\"]")));
					Select Progtypedropdown = new Select(element);
					////passing the Program type
//					Progtypedropdown.selectByVisibleText(params.get(1));
					Progtypedropdown.selectByVisibleText(sheet.getRow(3).getCell(1).getStringCellValue());



					Thread.sleep(2000);
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"programId\"]")));
					Select Programdropdown = new Select(element);
					//passing the Program
//					Programdropdown.selectByVisibleText(params.get(2));
					Programdropdown.selectByVisibleText(sheet.getRow(2).getCell(1).getStringCellValue());


					Thread.sleep(2000);
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"examDefId\"]")));
					Select Examropdown = new Select(element);
					//passing the Exam
//					Examropdown.selectByVisibleText(params.get(3));
					Examropdown.selectByVisibleText(sheet.getRow(5).getCell(1).getStringCellValue());


					Thread.sleep(2000);
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"examDefinitions_eligibility\"]")));
					Select Eligibilitydropdown = new Select(element);
//					Eligibilitydropdown.selectByVisibleText(params.get(4));
					if(id==1)
					Eligibilitydropdown.selectByVisibleText("Eligible");
					else
						Eligibilitydropdown.selectByVisibleText("Not Eligible");


					Thread.sleep(2000);
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				}

			public void studentId() throws InterruptedException, AWTException
			{
				System.out.println("Number of courses are "+courseCodes.size());
				String course;

				for(int i=0;i<courseCodes.size();i++)
				{
					WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id=\"course\"]")));
					course= courseCodes.get(i);
					System.out.println(course);
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
					{	//getting student details from 1st row,1st column
						String studentDetails = driver.findElement(By.xpath("//*[@id=\"studentsTable\"]/tbody/tr["+(j)+"]/td[1]")).getText();
						student= StringUtils.substringBetween(studentDetails, "(", ")");
						studentData.put(course, studentList);
						studentData.get(course).add(student);
						Set s=studentData.entrySet();
						System.out.println(s);
						System.out.println("**********************");
						System.out.println("Stored "+student+" against course "+course);
					}
					//to clear course code
					driver.findElement(By.xpath("//*[@id=\"course\"]")).clear();
					System.out.println("Course is "+courseCodes.get(i));
					}

			}
			public void student() throws InterruptedException, AWTException
			{
				System.out.println("Number of courses are "+courseCodes.size());
				String course;
				for(int i=0;i<courseCodes.size();i++)
				{
					WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"course\"]")));
					course= courseCodes.get(i);
					System.out.println(course);
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
					//Getting In eligible student data from student eligibility table,college side
					List<WebElement>Ineligiblestudentlist = driver.findElements(By.xpath("//*[@id=\"studentsTable\"]/tbody/tr"));
					int StudentlistSize= Ineligiblestudentlist.size();
					System.out.println("In eligible students are "+StudentlistSize);
					List<String>Invalidstudentlist=new ArrayList<>();
					for ( int j = 1; j<=StudentlistSize;j++)
					{
						String studentDetails = driver.findElement(By.xpath("//*[@id=\"studentsTable\"]/tbody/tr["+(j)+"]/td[1]")).getText();
						student1= StringUtils.substringBetween(studentDetails, "(", ")");
						notEligibleStudentdata.put(course, Invalidstudentlist);
						notEligibleStudentdata.get(course).add(student1);
						Set s=notEligibleStudentdata.entrySet();
						System.out.println("S are "+s);
						System.out.println("Stored "+student1+" against course "+course);
					}
					//to clear course code
					driver.findElement(By.xpath("//*[@id=\"course\"]")).clear();
					System.out.println("Course is "+courseCodes.get(i));
					}

			}

			public void checkingValidation() throws InterruptedException, AWTException   {
				String D;
				WebElement element=driver.findElement(By.xpath("(//a[@title='Enter Absentees'])[1]//preceding::td[7]"));
				D=element.getText();
 				String absenteeEnteredCourse= StringUtils.substringBetween(D, "(", ")");
				System.out.println("Trimmed courses are"+absenteeEnteredCourse);
				Coursecodedetails.add(absenteeEnteredCourse);
				System.out.println(Coursecodedetails);
				element=driver.findElement(By.xpath("(//a[@title='Enter Absentees'])[1]"));
				element.click();
				absenteesavebutton.click();
				//asserting validation message while saving empty absentee data
				String validationerror = driver.findElement(By.xpath("//*[contains(text(),'Either choose')]")).getText();
				String msg="Either choose one or more Students or mark No Absentees.";
				assertEquals(validationerror, msg);
				Thread.sleep(1000);
				absenteebackbutton.click();
				Thread.sleep(500);
				}
//			this Method is used to assert a quoted note in absentee entering page
			public void userassertingNOTE() throws InterruptedException
			{
				WebElement element=driver.findElement(By.xpath("(//a[@title='Enter Absentees'])[1]"));
				element.click();
				String actualValue = driver.findElement(By.xpath("//*[contains(text(),'Note : Students reported for malpractice')]")).getText();
				System.out.println(actualValue);
				String ExpectedValue = "Note : Students reported for malpractice, debarred students and whose halltickets are not generated can't be added as absentee.";
				System.out.println(ExpectedValue);
				assertEquals(actualValue,ExpectedValue);
				Thread.sleep(1000);
				absenteebackbutton.click();
				Thread.sleep(1000);
			}
		public void userAssertingDateandCourse() throws InterruptedException {
//			User fetching Exam date from Course Lisiting page.
			String examDate = driver.findElement(By.xpath("(//a[@title='Enter Absentees'])[1]//preceding::td[5]")).getText();
			String TrimmedexamDate = StringUtils.substringBefore(examDate,"(").trim();
			System.out.println(TrimmedexamDate);
			WebElement element=driver.findElement(By.xpath("(//a[@title='Enter Absentees'])[1]"));
			element.click();
			Thread.sleep(500);
//			User getting Exam date text from absentee entering UI
			String uiExamDate = driver.findElement(By.xpath("(//li[@class='list-group-item'])[3]/b")).getText().trim();
 			System.out.println(uiExamDate);
			assertEquals(TrimmedexamDate,uiExamDate);
			Thread.sleep(500);
			System.out.println(TrimmedexamDate.equals(uiExamDate));
//			User getting course code from UI
			String Coursecode = driver.findElement(By.xpath("(//li[@class='list-group-item'])[2]/b")).getText();
			String TrimmedCoursecode = StringUtils.substringBetween(Coursecode,"(",")").trim();
			System.out.println(TrimmedCoursecode);
			assertEquals(TrimmedCoursecode,Coursecodedetails.get(0));
			System.out.println(TrimmedCoursecode.equals(Coursecodedetails.get(0)));
			Thread.sleep(1000);
			absenteebackbutton.click();
			Thread.sleep(1000);
			}
		public void enterIneligibleasAbsentee() throws InterruptedException, AWTException
			{
			WebElement element=driver.findElement(By.xpath("//*[@id='examCourseListForm_search']"));
			for(int i=0;i<courseCodes.size();i++) //a[@title='Enter Absentees'])[1]
					{
						try
						{
							element=driver.findElement(By.xpath("//*[@id='courseMalpractisesTable']/tbody/tr["+(i+1)+"]/td[8]/a[2]"));
						}
						catch(Exception e)
						{
							continue;
						}
						if(element.isDisplayed())
						{
//						*******************************
							try
							{
		                    if(notEligibleStudentdata.get(courseCodes.get(i)).get(1)!=null)
							{
								System.out.println("within if");
								String studentName=notEligibleStudentdata.get(courseCodes.get(i)).get(1);
//								System.out.println(studentName);
								System.out.println("student is"+studentName+"*****");
								element = driver.findElement(By.xpath("//*[@id=\"studentId_chosen\"]"));
//								To click a button or to send a
								Actions action = new Actions(driver);
								action.sendKeys(element, studentName).build().perform();
								Robot robot = new Robot();
								robot.keyPress(KeyEvent.VK_ENTER);
								//Releasing the Enter Key
								robot.keyRelease(KeyEvent.VK_ENTER);
								Thread.sleep(1000);
								System.out.println(element.getText());
//								User asserting No results match found after entering not eligible student as absentee
								NoResultMatchValidateError();
//								absenteesavebutton.click();
								absenteebackbutton.click();
								Thread.sleep(500);
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
//						*******************************
					break;
					}
					}
			public void  NoResultMatchValidateError()
				{
				String actualValue = driver.findElement(By.xpath("//*[contains(text(),'No results match')]")).getText();
				System.out.println("actual value is"+actualValue);
				String expectedValue = "No results match";
				System.out.println("expected value is"+expectedValue);
				assertEquals(true,actualValue.startsWith(expectedValue));
				}
			public void studentRegisterNum() throws InterruptedException, AWTException
				{
					WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath("//*[@id=\"course\"]")));
//					Coursecodedetails is a arraylist used to storing student register number who are eligible for one course
 					element.sendKeys(Coursecodedetails.get(0));
					Thread.sleep(1000);
					Robot robot = new Robot();
//					//Pressing the Enter Key
					robot.keyPress(KeyEvent.VK_ENTER);
//					//Releasing the Enter Key
					robot.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(1000);
					driver.findElement(By.xpath("//*[@id=\"search\"]/span")).click();
					Thread.sleep(2000);
					List<WebElement> f = driver.findElements(By.xpath("//*[@id='studentsTable']/tbody/tr"));
					CoursEligibleStudentSize = f.size();
					System.out.println("Students size are "+CoursEligibleStudentSize);

					for (int i=1;i<=CoursEligibleStudentSize;i++)
					{
						String J = driver.findElement(By.xpath("//*[@id='studentsTable']/tbody/tr["+(i)+"]/td[1]")).getText();
						String  jExtract= StringUtils.substringBetween(J, "(", ")");
 						studentRegNo.add(jExtract);
						System.out.println(studentRegNo);
					}

					}


			public void allAbsentee() throws InterruptedException{
				Thread.sleep(1000);
				WebElement element=driver.findElement(By.xpath("(//a[@title='Enter Absentees'])[1]"));
				element.click();
				Thread.sleep(1000);
				element=driver.findElement(By.xpath("//*[@id='allStudents']"));
				element.click();
				Thread.sleep(500);
				absenteesavebutton.click();
 				List<WebElement> abs = driver.findElements(By.xpath("//*[@id='absenteesTable']/tbody/tr"));
 				allAbsenteeSize = abs.size();
 				System.out.println("absentee marked student size are "+allAbsenteeSize);
 				for (int i=1;i<=allAbsenteeSize;i++) {
					String zExtract = driver.findElement(By.xpath("//*[@id='absenteesTable']/tbody/tr["+(i)+"]/td[1]")).getText();
 					allAbsenteeRegNum.add(zExtract);

 				}
 				System.out.println("all absentee students are "+allAbsenteeRegNum);
			}

 			public void asrtngAllEligblAbsStdnt() throws InterruptedException{
// 				if students count taken from eligible list equals student taken from all absentee marked students
 				boolean flag=true;
 				System.out.println(allAbsenteeSize+" "+CoursEligibleStudentSize);
 				if(allAbsenteeSize==CoursEligibleStudentSize)
 				{
 				System.out.println(allAbsenteeRegNum);
// 				i=0 when fetching data from array list
 				for(int i=0;i<allAbsenteeSize;i++)
 				{
 				System.out.println(allAbsenteeRegNum.contains(studentRegNo.get(i)));
 				if(!(allAbsenteeRegNum.contains(studentRegNo.get(i))))
 				{
 				System.out.println(studentRegNo.get(i));
 				flag=false;
 				break;
  				}
 				}
 				}
 				else
 				{
 				flag=false;
 				}
 				assertEquals(true, flag);
 				absenteebackbutton.click();
 				Thread.sleep(500);
 				}

 				public void noAbsenteeCheckBoxSubmit() throws InterruptedException
 				{
 					Thread.sleep(1000);
 					WebElement element=driver.findElement(By.xpath("(//a[@title='Enter Absentees'])[1]"));
 					element.click();
 					Thread.sleep(1000);
 					element=driver.findElement(By.xpath("//*[@id=\"noAbsentees\"]"));
  					element.click();
 					Thread.sleep(500);
 					absenteesavebutton.click();
 				}
 				public void assertingError() throws InterruptedException
 				{
 					Thread.sleep(500);
 					String Expectedvalue=driver.findElement(By.xpath("//*[contains(text(),'Students are already added')]")).getText();
 					System.out.println(Expectedvalue);
 					String Actual="Students are already added in absentees list. No Absentees cannot be marked.";
 					System.out.println(Actual);
 					assertEquals(Expectedvalue, Actual);
 				}

//	 				Method used to store course In-eligible students register number's
 				public void inEligiblestudentRegisterNum() throws InterruptedException, AWTException
				{
					WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"course\"]")));
//					Coursecodedetails is a arraylist used to storing student register number who are eligible for one course
 					element.sendKeys(Coursecodedetails.get(0));
					Thread.sleep(1000);
					Robot robot = new Robot();
//					//Pressing the Enter Key
					robot.keyPress(KeyEvent.VK_ENTER);
//					//Releasing the Enter Key
					robot.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(1000);
					driver.findElement(By.xpath("//*[@id=\"search\"]/span")).click();
					Thread.sleep(2000);
					List<WebElement> f = driver.findElements(By.xpath("//*[@id='studentsTable']/tbody/tr"));
					CoursInEligibleStudentSize = f.size();
					System.out.println("Students size are "+CoursInEligibleStudentSize);

//					i starts from 1 when iterating through tables
					for (int i=1;i<=CoursInEligibleStudentSize;i++)
					{
						String J = driver.findElement(By.xpath("//*[@id='studentsTable']/tbody/tr["+(i)+"]/td[1]")).getText();
						String  jExtract= StringUtils.substringBetween(J, "(", ")");
 						inEligiblestudentRegNo.add(jExtract);
						System.out.println(inEligiblestudentRegNo);
					}

					}
// 				************************************************************************************************************

 				public void asrtngAllInEligblAbsStdnt() throws InterruptedException{
// 	 				if students count taken from eligible list equals student taken from all absentee marked students

 	 				boolean flag=true;
 	 				System.out.println(allAbsenteeSize+" "+CoursInEligibleStudentSize);
 	 				System.out.println(allAbsenteeRegNum);
// 	 					i=0 when fetching data from array list
 	 						for(int i=0;i<allAbsenteeSize;i++)
 	 						{
 	 							System.out.println(inEligiblestudentRegNo.contains(allAbsenteeRegNum.get(i)));
 	 						if((inEligiblestudentRegNo.contains(allAbsenteeRegNum.get(i))))
 	 						{

 	 						System.out.println(allAbsenteeRegNum.get(i));
 	 						flag=false;
 	 						break;
 	  						}
 	 						}
 	 						assertEquals(true, flag);
 	 						absenteebackbutton.click();
 	 						Thread.sleep(500);
 	 					}

 				public void validatingNoResultMatch() throws InterruptedException, AWTException
				{
 					Thread.sleep(500);
 					WebElement element=driver.findElement(By.xpath("(//a[@title='Enter Absentees'])[1]"));
 					element.click();
 					Thread.sleep(1000);
 					element = driver.findElement(By.xpath("//*[@class='chosen-choices']"));
 					System.out.println(inEligiblestudentRegNo.get(0));
//					element.sendKeys(inEligiblestudentRegNo.get(0));
//					To click a button or to send an element
 					Actions action = new Actions(driver);
 					action.sendKeys(element, inEligiblestudentRegNo.get(0)).build().perform();
 					Thread.sleep(500);
 					NoResultMatchValidateError();
				}
// 			deleteStudent()	Method is used to delete existing entered absentee students
				public void deleteStudent() throws InterruptedException, AWTException{
					 for(int i=1;i<=(allAbsenteeSize-1);i++)
					 {
						 WebElement element = driver.findElement(By.xpath("//*[@id='absenteesTable']/tbody/tr/td[4]/a[1]"));
						 element.click();
						 Thread.sleep(500);
						 element = driver.findElement(By.xpath("//*[text() = 'Delete']"));
						 element.click();
						 Thread.sleep(1000);
					 }
					 String aBSENTEEsTUDENT = driver.findElement(By.xpath("//*[@id='absenteesTable']/tbody/tr/td[1]")).getText();
					 AbsenteeForMalpractice.add(aBSENTEEsTUDENT);
					 System.out.println("Absentee student name used to enter in malpractice field for testing purpose "+AbsenteeForMalpractice);
					 absenteesubmitbutton.click();
					 Thread.sleep(500);
					 }
				public void malDateTimeVerifying() throws InterruptedException {
//					User fetching Exam date from Course Lisiting page.
					String examDate = driver.findElement(By.xpath("(//a[@title='Enter Absentees'])[1]//preceding::td[5]")).getText();
					String TrimmedexamDate = StringUtils.substringBefore(examDate,"(").trim();
					System.out.println(TrimmedexamDate);
					WebElement element=driver.findElement(By.xpath("(//a[@title='Enter Malpractices'])[1]"));
					element.click();

					Thread.sleep(500);
//					User getting Exam date text from absentee entering UI
					String uiExamDate = driver.findElement(By.xpath("(//li[@class='list-group-item'])[2]/b")).getText().trim();
		 			System.out.println(uiExamDate);
					assertEquals(TrimmedexamDate,uiExamDate);
					Thread.sleep(500);
					System.out.println(TrimmedexamDate.equals(uiExamDate));

//					User getting course code from UI
					String Coursecode = driver.findElement(By.xpath("(//li[@class='list-group-item'])[4]/b")).getText();
					String TrimmedCoursecode = StringUtils.substringBetween(Coursecode,"(",")").trim();
					System.out.println(TrimmedCoursecode);
					assertEquals(TrimmedCoursecode,Coursecodedetails.get(0));
					System.out.println(TrimmedCoursecode.equals(Coursecodedetails.get(0)));
					Thread.sleep(1000);
					MalpracticeBackButton.click();
					Thread.sleep(1000);
					}
//				Method
 				public void submitEmptyMaldata() throws InterruptedException {
 					WebElement element=driver.findElement(By.xpath("(//a[@title='Enter Malpractices'])[1]"));
					element.click();
					Thread.sleep(500);
					SubmitMalpractice.click();
					Thread.sleep(500);
//					getting validation message from pop up using x-path get text
					String Expected = driver.findElement(By.xpath("(//*[@id=\"confirmMsg\"])[2]")).getText();
					System.out.println("Pop up validation messgae is "+Expected);
					String actual = "Are you sure you want to submit? Data cannot edited after submission.";
					System.out.println(actual);
					assertEquals(Expected,actual);
//					Not-confirm throwing pop up message
					element = driver.findElement(By.xpath("(//*[text() = 'No'])[8]"));
					element.click();
					MalpracticeBackButton.click();
					Thread.sleep(500);
 					}
 				public void emptymalpracticeform() throws InterruptedException {
 					WebElement element=driver.findElement(By.xpath("(//a[@title='Enter Malpractices'])[1]"));
					element.click();
					Thread.sleep(500);
					AddMalpractice.click();
					Thread.sleep(500);
					SaveMalpractice.click();
					String validationerror1 = driver.findElement(By.xpath("//*[contains(text(),'You must select a value for Offences')]")).getText();
					String validationerror2 = driver.findElement(By.xpath("//*[contains(text(),'You must enter a value for Student')]")).getText();
					String validationerror3 = driver.findElement(By.xpath("//*[contains(text(),'You must enter a value for Malpractice Details')]")).getText();
					String msg="You must select a value for Offences\n"
							+ "You must enter a value for Student\n"
							+ "You must enter a value for Malpractice Details";
					assertEquals(validationerror1+"\n"+validationerror2+"\n"+ validationerror3,msg);
					CancelfromMalpracticeform.click();
					Thread.sleep(500);
					MalpracticeBackButton.click();
 					}
// 				Method to check in-eligible student listing in MalPractise form
 				public void ineligibleMalpractice() throws InterruptedException {
 					WebElement element=driver.findElement(By.xpath("(//a[@title='Enter Malpractices'])[1]"));
					element.click();
					Thread.sleep(500);
					AddMalpractice.click();
					Thread.sleep(500);
//					X path for field student
					System.out.println(inEligiblestudentRegNo.get(0));
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='student']")));
					element.sendKeys(inEligiblestudentRegNo.get(0));
					Thread.sleep(500);
					String Actual = driver.findElement(By.xpath("//*[contains(text(),'No Record found')]")).getText();
					System.out.println(Actual);
					String Expected = "No Record found";
					assertEquals(Actual,Expected);
					Thread.sleep(500);
					CancelfromMalpracticeform.click();
					Thread.sleep(500);
					MalpracticeBackButton.click();
 					}
 				public void absentMarkedStudentInMalpractice() throws InterruptedException {
 					WebElement element=driver.findElement(By.xpath("(//a[@title='Enter Malpractices'])[1]"));
					element.click();
					Thread.sleep(500);
					AddMalpractice.click();
					Thread.sleep(500);
//					X path for field student
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='student']")));
					element.sendKeys(AbsenteeForMalpractice.get(0));
					Thread.sleep(500);
					String Actual = driver.findElement(By.xpath("//*[contains(text(),'No Record found')]")).getText();
					System.out.println(Actual);
					String Expected = "No Record found";
					assertEquals(Actual,Expected);
					Thread.sleep(500);
					CancelfromMalpracticeform.click();
					Thread.sleep(500);
					MalpracticeBackButton.click();
 					}
			public void eligibleStudentInMalpractice() throws InterruptedException, AWTException {
				Robot robot = new Robot();
				WebElement element=driver.findElement(By.xpath("(//a[@title='Enter Malpractices'])[1]"));
				element.click();
				Thread.sleep(500);
				AddMalpractice.click();
				Thread.sleep(500);
				WebElement chooseoffences = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"offenceId\"]")));
				Select Offencesdropdown = new Select(chooseoffences);
				//passing the offence
				Offencesdropdown.selectByVisibleText("Copying");
				//code for entering MalPractise details
				WebElement malpracticedetails = driver.findElement(By.xpath("//*[@id=\"studentMalPracticeForm_malpractiseDetails\"]"));
				malpracticedetails.sendKeys("test");
				Thread.sleep(1000);

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

                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
                Thread.sleep(1000);

				//X path for field student and passing an eligible student
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='student']")));
				element.sendKeys(studentRegNo.get(1));
				Thread.sleep(500);
				//Pressing the Enter Key
				robot.keyPress(KeyEvent.VK_ENTER);
				//Releasing the Enter Key
				robot.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(500);
                SaveMalpractice.click();
				Thread.sleep(500);
				MalpracticeBackButton.click();

 				}

			public void InvalidAttachment() throws InterruptedException, AWTException {

				Robot robot = new Robot();
				WebElement element=driver.findElement(By.xpath("(//a[@title='Enter Malpractices'])[1]"));
				element.click();
				Thread.sleep(500);
				AddMalpractice.click();
				Thread.sleep(500);
				WebElement chooseoffences = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"offenceId\"]")));
				Select Offencesdropdown = new Select(chooseoffences);
				//passing the offense
				Offencesdropdown.selectByVisibleText("Copying");
				//code for entering MalPractise details
				WebElement malpracticedetails = driver.findElement(By.xpath("//*[@id=\"studentMalPracticeForm_malpractiseDetails\"]"));
				malpracticedetails.sendKeys("test");
				Thread.sleep(1000);
				//X path for field student
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='student']")));
				element.sendKeys(studentRegNo.get(1));
				Thread.sleep(500);
				//Pressing the Enter Key
				robot.keyPress(KeyEvent.VK_ENTER);
				//Releasing the Enter Key
				robot.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(500);

				//Selecting an invalid document
				StringSelection str = new StringSelection("/home/u1464/Downloads/Invalid supporting document/images.jpeg");
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(str, null);
                WebElement fileUpload = driver.findElement(By.xpath("//input[@value='Browse...']"));
                fileUpload.click();

                Thread.sleep(1000);
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_V);
 //				Key release-Cntrl V
                robot.keyRelease(KeyEvent.VK_CONTROL);
                robot.keyRelease(KeyEvent.VK_V);
//				Enter key press release
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
                Thread.sleep(1000);
                SaveMalpractice.click();
                Thread.sleep(500);
                String Expected = driver.findElement(By.xpath("//*[contains(text(),'Unsupported File format')]")).getText();
                System.out.println(Expected);
                String Actual = "Unsupported File format (image/jpeg)";
                System.out.println(Actual);
                assertEquals(Expected,Actual);
                Thread.sleep(500);
                CancelfromMalpracticeform.click();
                Thread.sleep(500);
                MalpracticeBackButton.click();

				}
				public void dupicateMalpractice() throws InterruptedException, AWTException {
					Robot robot = new Robot();
					WebElement element=driver.findElement(By.xpath("(//a[@title='Enter Malpractices'])[1]"));
					element.click();
					Thread.sleep(500);
					AddMalpractice.click();
					Thread.sleep(500);
					WebElement chooseoffences = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"offenceId\"]")));
					Select Offencesdropdown = new Select(chooseoffences);
					//passing the offense
					Offencesdropdown.selectByVisibleText("Copying");
					//code for entering MalPractise details
					WebElement malpracticedetails = driver.findElement(By.xpath("//*[@id=\"studentMalPracticeForm_malpractiseDetails\"]"));
					malpracticedetails.sendKeys("test");
					Thread.sleep(1000);

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

	                robot.keyPress(KeyEvent.VK_ENTER);
	                robot.keyRelease(KeyEvent.VK_ENTER);
	                Thread.sleep(1000);

					//X path for field student and passing an eligible student
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='student']")));
					element.sendKeys(studentRegNo.get(1));
					Thread.sleep(500);
					//Pressing the Enter Key
					robot.keyPress(KeyEvent.VK_ENTER);
					//Releasing the Enter Key
					robot.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(500);
	                SaveMalpractice.click();
	                Thread.sleep(500);
	                String Actual = driver.findElement(By.xpath("//*[contains(text(),'The malpractise already exists for the student')]")).getText();
	                System.out.println(Actual);
	                String Expected = "The malpractise already exists for the student";
	                System.out.println(Expected);
	                assertEquals(Actual, Expected);
	                Thread.sleep(500);
	                CancelfromMalpracticeform.click();
	                Thread.sleep(500);
	                SubmitMalpractice.click();
	                Thread.sleep(500);
	                driver.findElement(By.xpath("(//*[contains(text(),'Yes')])[8]")).click();
	                Thread.sleep(500);
					}
				public void verifyingMalStudentStatus() throws InterruptedException {

					String malstu = driver.findElement(By.xpath("//*[@id='malPracticeListingTable']/tbody/tr/td[1]")).getText();
					String Stud = StringUtils.substringBetween(malstu,"(",")").trim();
					System.out.println("Fetched student id is "+Stud);
					System.out.println("Stored student is "+(studentRegNo.get(1)));
					assertEquals(Stud, (studentRegNo.get(1)));
					Thread.sleep(500);

					String status = driver.findElement(By.xpath("//*[@id='malPracticeListingTable']/tbody/tr/td[5]")).getText();
					System.out.println(status);
					String sta = "Submitted";
					System.out.println(sta);
					assertEquals(sta,status);
					Thread.sleep(500);
	                MalpracticeBackButton.click();
					}


				//Entering search criteria
				public void Details( ) throws InterruptedException
				{
					//Parameters
//					List<String> params = new ArrayList<>();
//					params = Arrays.asList(examDetails.split(",#"));
					//passing the Academic year
					WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" (//*[@id='academicYear'])[1]")));
					Select yeardropdown = new Select(element);
//					yeardropdown.selectByVisibleText(params.get(0));
	 				yeardropdown.selectByVisibleText(sheet.getRow(1).getCell(1).getStringCellValue());

					Thread.sleep(2000);

					//passing the Program
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"programId\"]")));
					Select Programdropdown = new Select(element);
//					Programdropdown.selectByVisibleText(params.get(1));
					Programdropdown.selectByVisibleText(sheet.getRow(2).getCell(1).getStringCellValue());

					Thread.sleep(2000);

					//passing the Program type
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@name='programType'])[1]")));
					Select Progtypedropdown = new Select(element);
//					Progtypedropdown.selectByVisibleText(params.get(2));
					Progtypedropdown.selectByVisibleText(sheet.getRow(3).getCell(1).getStringCellValue());


					//passing the Exam type
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='searchForm_examType']")));
					Select examtypedropdown = new Select(element);
//					examtypedropdown.selectByVisibleText(params.get(3));
					examtypedropdown.selectByVisibleText(sheet.getRow(4).getCell(1).getStringCellValue());

					Thread.sleep(1000);

//					Passing exam definition
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='searchForm_definitionName']")));
					element.sendKeys(sheet.getRow(5).getCell(1).getStringCellValue());
//					User click on search button
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='searchForm_search']")));
					element.click();
					}
				public WebElement examCoursesButton () {

					WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-original-title='Exam Courses']")));
					return element;
				}
				public void institution() throws InterruptedException, AWTException
				{
					//Parameters
//					List<String> params = new ArrayList<>();
//					params = Arrays.asList(institutionDetails.split(",#"));
					WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='institution']")));
					element.sendKeys(sheet.getRow(7).getCell(1).getStringCellValue());
					Thread.sleep(500);
					Robot robot = new Robot();
					//Pressing the Enter Key
					robot.keyPress(KeyEvent.VK_ENTER);
					//Releasing the Enter Key
					robot.keyRelease(KeyEvent.VK_ENTER);
					element = driver.findElement(By.xpath("//*[@id='examCourseListForm_search']"));
					element.click();
					Thread.sleep(500);
					}
				public void Universityrevoke() throws AWTException, InterruptedException {
//					University user clicked on revoke button
					WebElement  element = driver.findElement(By.xpath("(//a[@title='Revoke Absentees'])[1]"));
					element.click();
					Robot robot = new Robot();
					//Pressing the Enter Key
					robot.keyPress(KeyEvent.VK_ENTER);
					//Releasing the Enter Key
					robot.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(2000);
					}


				public void AbsenteeMalpractice() throws InterruptedException {
					Thread.sleep(500);
 					WebElement element=driver.findElement(By.xpath("(//a[@title='Enter Absentees'])[1]"));
 					element.click();
 					element = driver.findElement(By.xpath("//*[@class='chosen-choices']"));
 					element.sendKeys(studentRegNo.get(1));
					Thread.sleep(500);
					System.out.println(studentRegNo.get(1));
					Thread.sleep(500);
					NoResultMatchValidateError();
 					}



}
