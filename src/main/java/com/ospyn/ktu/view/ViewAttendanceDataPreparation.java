package com.ospyn.ktu.view;

import static org.junit.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
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

import com.ospyn.ktu.test.Login;
import com.ospyn.ktu.test.ParentBranch;
import com.ospyn.ktu.util.SeleniumBase;

public class ViewAttendanceDataPreparation extends SeleniumBase {
	FileInputStream fs;
	XSSFWorkbook workbook;
	static XSSFSheet sheet,sheet1,sheet2,sheet3;
	static int index=1;


		//	Auto-generated constructor stub
public ViewAttendanceDataPreparation(WebDriver driver) throws IOException {
		super(driver);
		//reference for exell workbook or open the excel file
        fs = new FileInputStream(new File(System.getProperty("user.dir")+"/Test_Data/attendanceInternalDataPreparation.xlsx"));
        //Getting the workbook
		workbook = new XSSFWorkbook(fs);
		//Getting the sheet
		sheet = workbook.getSheetAt(0);
		System.out.println(sheet.getRow(1).getCell(1).getStringCellValue());
		}
//************************************************************************************************************
@FindBy(xpath = "//*[@class='menuclass']/a[contains(text(),'Student Attendance/Internals')]")
WebElement AttendanceInternals;
@FindBy(xpath = "//*[@name='search']")
WebElement Search;
@FindBy(xpath = "//a[text()='Exam']")
WebElement exam;
@FindBy(xpath = "//*/a[contains(text(),'Student Internals/Attendance')]")
WebElement StudentInternalsAttendance;
@FindBy(xpath = "//*[@class='moduleclass']/a[contains(text(),'Academic Auditing')]")
WebElement AcademicAuditing;
@FindBy(xpath = "//div[@id='staffModal']//button[@class='close']")
WebElement Closebutton;
@FindBy(xpath = "//*[@class='moduleclass']/a[contains(text(),'Academics')]")
WebElement Academics;
@FindBy(xpath = "//*[@id='courseFilterForm_code']")
WebElement EnterCourseCode;
@FindBy(xpath = "(//*[@class='menuclass']/a[contains(text(),'Course')])[1]")
WebElement Coursemenu;
@FindBy(xpath = "//*[@class='menuclass']/a[contains(text(),'Evaluation Plan')]")
WebElement EvaluationPlan;
@FindBy(xpath = "//*[@class='menuclass']/a[contains(text(),'Assigned Courses')]")
WebElement AssignedCourses;
@FindBy(xpath = "//*[@id=\"submitBtnId\"]")
WebElement SaveAttendancebutton;
@FindBy(xpath = "//*[@id=\"markCompleteId\"]")
WebElement MarkAsComplete;
@FindBy(xpath = "//input[@id='login-username'][@name='username']")
WebElement username;
@FindBy(xpath = "//input[@id='login-password'][@name='password']")
WebElement password;
@FindBy(xpath = "//a[@href='/university/eu/exm/staffAdvisorBatches.htm']")
WebElement AdvisorsBatches;
@FindBy(xpath = "//*[@id='btn-login']")
WebElement login;
@FindBy(xpath = "//*[@class='btn btn-success pull-right']")
WebElement ConfirmButton;
@FindBy(xpath = "//*[@id=\"branchListingForm_Submit\"]")
WebElement BranchListingSubmit;

public static int BranchSize;
public static int CourseSize;
public static String[] strCoursecode;
public static String Batch;
public static String[] strFacultyId;

public static String[] RetrievedFacultyId = new String[10];
public static String[] RetrievedCoursecode = new String[100];
public static String[] ReducedCoursecode = new String[100];
public static String[] RetrievedBatch = new String[100];
//public static String[] RetrievedCoursetype = new String[100];
//public static String[] StaffAdvisorId;
public static String[] RetrievedStaffAdvisorId = new String[100];
//public static String[] CoursetypenameEvalution = new String[100];
public static String[] ApplSessionalsEvaluation = new String[100];
public static String[] ExamEligibilityCodnEvaluation = new String[100];
public static String[] MinAttendanceEvaluation = new String[100];

public static String[] MinAttendanceLongLeaveEvaluation = new String[100];
public static String[] MinAttendanceDutyLeaveEvaluation = new String[100];

public static String[] MenstrualLeaveRelaxationPercentage = new String[100];
public static String[] IneligibleType = new String[100];

public static String[] EligibleForWrittenExam = new String[100];

public static String[] IntAttendCourses = new String[100];
public static String[] IntAttendbatch = new String[100];
//**************************************
String course[]=new String[3];
String Facultyid;
String courseDetails;
String facultyDetails;
String batchDetails;
String Studentreg;
public static String currentIndex="1";
static String[] studentData;
static String[] students;
public static Object[] getStudentData() {
	return studentData;
}

 int flag=0,flag1=0;

public static List<String>courseCodes=new ArrayList<String>();
public static ArrayList<String> RegNumber =new ArrayList<String>();
public static ArrayList<String> studentDetails =new ArrayList<String>();
public  Object[] Branchnames;
public  Object[] facultyids;
public static List<String>batchnames=new ArrayList<String>();
public static List<Integer>flags=new ArrayList<Integer>();
public static List<String>StaffAdvisorId=new ArrayList<String>();
public static List<String>confirmStaffAdvisorId=new ArrayList<String>();
public static List<String>Branchdetails=new ArrayList<String>();
public static List<String>RetrievedCoursetype=new ArrayList<String>();
public static List<String>CoursetypenameEvalution=new ArrayList<String>();
public static List<String>ExcelInternalmarks=new ArrayList<String>();
public static List<String>ExcelCoursedetails=new ArrayList<String>();
static Map<String,Double>marksMap=new HashMap<>();

//Create a new HashMap to store ArrayLists
static Map<String, List<String>> dataMap = new HashMap<>();
public static List<String> course1Marks = new ArrayList<>();
public static List<String> course2Marks = new ArrayList<>();
public static List<String> course3Marks = new ArrayList<>();
public static List<String> course4Marks = new ArrayList<>();
public static List<String> course5Marks = new ArrayList<>();
public static List<String> course6Marks = new ArrayList<>();
public static List<String> course7Marks = new ArrayList<>();
public static List<String> course8Marks = new ArrayList<>();

//integer array
public static int[] array_internal = new int[100];

//String array
	public static String[] strArray = Arrays.stream(array_internal)
			.mapToObj(String::valueOf)
			.toArray(String[]::new);

	public WebElement getBranchListingSubmit() {
		return BranchListingSubmit;
	}

	public void setBranchListingSubmit(WebElement branchListingSubmit) {
		BranchListingSubmit = branchListingSubmit;
	}

	public WebElement getConfirmButton() {
		return ConfirmButton;
	}

	public void setConfirmButton(WebElement confirmButton) {
		ConfirmButton = confirmButton;
	}

	public WebElement getLogin() {
		return login;
	}

	public void setLogin(WebElement login) {
		this.login = login;
	}
	public String getCollege()
	{
		sheet1 = workbook.getSheetAt(1);
		return(sheet1.getRow(1).getCell(Login.getColumn()).getStringCellValue());

	}

	public WebElement getAdvisorsBatches() {
		return AdvisorsBatches;
	}

	public void setAdvisorsBatches(WebElement advisorsBatches) {
		AdvisorsBatches = advisorsBatches;
	}

	public WebElement getSaveAttendancebutton() {
		return SaveAttendancebutton;
	}

	public void setSaveAttendancebutton(WebElement saveAttendancebutton) {
		SaveAttendancebutton = saveAttendancebutton;
	}
	public WebElement getAssignedCourses() {
		return AssignedCourses;
	}

	public void setAssignedCourses(WebElement assignedCourses) {
		AssignedCourses = assignedCourses;
	}
	public WebElement getEvaluationPlan() {
		return EvaluationPlan;
	}

	public void setEvaluationPlan(WebElement evaluationPlan) {
		EvaluationPlan = evaluationPlan;
	}
	public WebElement getEnterCourseCode() {
		return EnterCourseCode;
	}

	public void setEnterCourseCode(WebElement enterCourseCode) {
		EnterCourseCode = enterCourseCode;
	}

	public WebElement getCoursemenu() {
		return Coursemenu;
	}

	public void setCoursemenu(WebElement coursemenu) {
		Coursemenu = coursemenu;
	}
	public String[] getCourse() {
		return course;
	}

	public void setCourse(String[] course) {
		this.course = course;
	}
	public WebElement getAcademics() {
		return Academics;
	}

	public void setAcademics(WebElement academics) {
		Academics = academics;
	}
	public WebElement getClosebutton() {
		return Closebutton;
	}

	public void setClosebutton(WebElement closebutton) {
		Closebutton = closebutton;
	}
	public WebElement getStudentInternalsAttendance() {
		return StudentInternalsAttendance;
	}

	public void setStudentInternalsAttendance(WebElement studentInternalsAttendance) {
		StudentInternalsAttendance = studentInternalsAttendance;
	}

	public WebElement getSearch() {
		return Search;
	}

	public void setSearch(WebElement search) {
		Search = search;
	}

	public WebElement getAttendanceInternals() {
		return AttendanceInternals;
	}

	public void setAttendanceInternals(WebElement attendanceInternals) {
		AttendanceInternals = attendanceInternals;
	}



	public WebElement getExam()
	{
		return exam;
	}
	public WebElement getAcademicAuditing() {
		return AcademicAuditing;
	}

	public void setAcademicAuditing(WebElement academicAuditing) {
		AcademicAuditing = academicAuditing;
	}
	public WebElement getMarkAsComplete() {
		return MarkAsComplete;
	}

	public void setMarkAsComplete(WebElement markAsComplete) {
		MarkAsComplete = markAsComplete;
	}
	public WebElement getPassword() {
		return password;
	}

	public void setPassword(WebElement password) {
		this.password = password;
	}
	public WebElement getUsername() {
		return username;
	}

	public void setUsername(WebElement username) {
		this.username = username;
	}

	public static String Branch, Branchname1;
	//	public static String Branch1, Branchname1;

//  *****************************************************************
	public void Attendanceinternal() throws InterruptedException {

		String status = "";

		try {


			Thread.sleep(2000);

			// click the Student Attendance/Internals
			AttendanceInternals.click();

			WebElement yearClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"academicYearId\"]")));
			Select yeardropdown = new Select(yearClick);
			//passing the Academic year
 			System.out.println(sheet.getRow(1).getCell(1).getStringCellValue());
			yeardropdown.selectByVisibleText(sheet.getRow(1).getCell(1).getStringCellValue());

			Thread.sleep(500);

			WebElement ProgramClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"programId\"]")));
			Select Programdropdown = new Select(ProgramClick);
			//passing the Program
 			Programdropdown.selectByVisibleText(sheet.getRow(2).getCell(1).getStringCellValue());

			Thread.sleep(500);
			WebElement ProgtypeClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"programType\"]")));
			Select Progtypedropdown = new Select(ProgtypeClick);
			//passing the Program type
 			Progtypedropdown.selectByVisibleText(sheet.getRow(3).getCell(1).getStringCellValue());

			Thread.sleep(500);

			WebElement SemesterClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"semesterId\"]")));
			Select Semesterdropdown = new Select(SemesterClick);
			//passing the Semester
 			Semesterdropdown.selectByVisibleText(sheet.getRow(4).getCell(1).getStringCellValue());

			Thread.sleep(500);

			WebElement EligibilityforClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='registrationAllowedStudentStatus']")));
			Select Eligibilityfordropdown = new Select(EligibilityforClick);
			//passing the Batch
			Eligibilityfordropdown.selectByVisibleText(sheet.getRow(5).getCell(1).getStringCellValue());
			Thread.sleep(1000);

			WebElement DegreeClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"degreeType\"]")));
			Select Degreedropdown = new Select(DegreeClick);
			//passing the Degree
 			Degreedropdown.selectByVisibleText(sheet.getRow(6).getCell(1).getStringCellValue());

			Thread.sleep(2000);

			//Click on Search button
			Search.click();
			if(flag==0)
			{
				List<WebElement> Branchlist = driver.findElements(By.xpath("//*[contains(text(),' Branch/Stream:')]"));
				BranchSize= Branchlist.size();
				Branchnames=new Object[BranchSize];
				System.out.println("element is "+Branchnames[0]);
				System.out.println("Listed branches are "+BranchSize);

				int i=0;
				for(WebElement branch:Branchlist)
				{
					Branchnames[i]=branch.getText();
					i++;
				}
				flag=1;
			}
		}
		catch (Exception e) {

			System.out.println(e);

		}

		Thread.sleep(1000);

	}
	public void clickInternalsButton(String branchname)throws Exception
	{
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[contains(text(),'"+branchname+"')]//following::a[1]")));
		System.out.println("Branch is ******"+branchname);
		element.click();
		Thread.sleep(1000);


	}
	public void moveBack()throws Exception
	{
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='back']")));
		element.click();
		Thread.sleep(1000);
	}
	public String[] CoursecodeFacultyId() throws InterruptedException {


		String status = "";

		try {



			Thread.sleep(2000);

			List<WebElement> Courselist = driver.findElements(By.xpath("//*[@id='programDetail']/tbody/tr"));
			CourseSize= Courselist.size();


			System.out.println("Course"+CourseSize);
			facultyids=new Object[CourseSize];
			if(flag1==1)
			{
				courseCodes.clear();
				batchnames.clear();
				Branchdetails.clear();
				flags.clear();


			}

			//Iterating through the course size
			for( int j = 1; j<= CourseSize;j++)
			{


				String courseDetails = driver.findElement(By.xpath("//*[@id='programDetail']/tbody/tr["+(j)+"]/td[1]")).getText();
				course = courseDetails.split("-");
				//course= StringUtils.substringBetween(courseDetails, "(", ")");
				//courseCodes.add(course);

				courseCodes.add(course[0]);
				System.out.println("Course code is "+courseCodes.get(j-1));

				//getting faculty details
				String facultyDetails = driver.findElement(By.xpath("//*[@id='programDetail']/tbody/tr["+(j)+"]/td[2]")).getText();
				Facultyid= StringUtils.substringBetween(facultyDetails, "(", ")");
				System.out.println("Faculty is" +Facultyid);
				facultyids[j-1]=Facultyid;

				//getting batch details
				String batchDetails = driver.findElement(By.xpath("//*[@id='programDetail']/tbody/tr["+(j)+"]/td[4]")).getText();
				System.out.println("Batch is" +batchDetails);
				batchnames.add(batchDetails);

				Branchname1 = driver.findElement(By.xpath("(//li[@class='list-group-item'])[3]")).getText();
				System.out.println("Branch name is " +Branchname1);
				flags.add(0);


				//Branchname = driver.findElement(By.xpath("(//*[@class='list-group-item'])[3]")).getText();
				//System.out.println("Branch name is " +Branchname);

				Branch = StringUtils.substringAfter(Branchname1, "Branch\n");
				System.out.println("Branch is "+Branch);
				//Branch data stored in a list named branchdetails
				Branchdetails.add(Branch);
				flag1=1;
			}



			Thread.sleep(2000);

		} catch (Exception e) {

			e.printStackTrace();

		}




		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='back']")));
		element.click();


		Thread.sleep(1000);
		return RetrievedFacultyId;

	}
	public void StaffAdvisor() throws InterruptedException {

		String status = "";
		System.out.println("*****************");
		System.out.println("User selecting staff advisor");
		System.out.println("*****************");
		try {

			WebElement yearClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='academicYear']")));
			Select yeardropdown = new Select(yearClick);
			//passing the Academic year
			yeardropdown.selectByVisibleText(sheet.getRow(7).getCell(1).getStringCellValue());

			Thread.sleep(2000);

			WebElement ProgramClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"programId\"]")));
			Select Programdropdown = new Select(ProgramClick);
			//passing the Program
 			Programdropdown.selectByVisibleText(sheet.getRow(2).getCell(1).getStringCellValue());

			Thread.sleep(2000);

			WebElement ProgtypeClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='degreeType']")));
			Select Progtypedropdown = new Select(ProgtypeClick);
			//passing the Program type
 			Progtypedropdown.selectByVisibleText(sheet.getRow(6).getCell(1).getStringCellValue());


			//WebElement t = ;

			// count rows with size() method
			List<WebElement> rows = driver.findElements(By.xpath("//*[@id='batchListingTable']/tbody/tr"));

			for (int i = 1; i<=rows.size(); i++)
			{
				Thread.sleep(1000);
				//List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
				WebElement cellBatch = driver.findElement(By.xpath("//*[@id='batchListingTable']/tbody/tr["+i+"]/td[2]"));

				WebElement cellBranch = driver.findElement(By.xpath("//*[@id='batchListingTable']/tbody/tr["+i+"]/td[6]"));
				System.out.println(cellBranch.getText());
				System.out.println(Branch);
				String branchName="";
				String branchNameChild=cellBranch.getText();

				branchName=ParentBranch.getParentBranchName(branchNameChild,"B.Tech","Full Time");
				branchName=StringUtils.substringBefore(branchName,"(").trim();
			System.out.println(branchName);
				if(branchName.equals(Branch))
				{
					System.out.println("cell Branch is "+cellBranch.getText());
					for(int j=0;j<batchnames.size();j++)
					{
						if(cellBatch.getText().equals(batchnames.get(j)))
						{

							WebElement element = driver.findElement(By.xpath("//*[@id='batchListingTable']/tbody/tr["+i+"]/td[8]/a[@title='Select Staff Advisor']"));
							//Click on Staff Advisor button
							element.click();
							Thread.sleep(1000);
							//fetching staff advisor id
							String StaffAdvisor= driver.findElement(By.xpath("//*[@id='facultyId']")).getAttribute("value");
							System.out.println(StaffAdvisor);
							String[] AdvisorId = StaffAdvisor.split(" ");
							StaffAdvisorId.add(0,AdvisorId[0]);
							System.out.println("staff advisor is "+StaffAdvisorId.get(0));
							Thread.sleep(1000);
							Closebutton.click();
							Thread.sleep(1000);
							break;
						}
						}
				}
			}

			Thread.sleep(2000);

		} catch (Exception e) {

			e.printStackTrace();

		}


		Thread.sleep(1000);

	}

	public void getCoursetype() throws InterruptedException {

		String status = "";

		try {

			Thread.sleep(2000);

			for( int i = 0; i< CourseSize;i++)
			{
				// click the Student Attendance/Internals
				EnterCourseCode.clear();
				Thread.sleep(100);
				EnterCourseCode.sendKeys(courseCodes.get(i));
				getSearch().click();



				WebElement  col_0 = driver.findElement(By.xpath("//*[@id='courseListingTable']/tbody/tr/td[3]"));

				RetrievedCoursetype.add(col_0.getText());
				//RetrievedCoursetype[i] = col_0.get(2).getText();

				//Course types are stored in variable "RetrievedCoursetype"
				System.out.println("The cell value is: " +RetrievedCoursetype.get(i));
			}


			Thread.sleep(2000);

		} catch (Exception e) {

			e.printStackTrace();

		}

		Thread.sleep(2000);

	}
	public void logout() throws InterruptedException{
		Thread.sleep(4000);

		//log out from university log in
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/university/logout.htm']")));
		element.click();
		Thread.sleep(2000);
		}
	public void Schemeselection() throws InterruptedException {

		String status = "";

		try {
			Thread.sleep(2000);

			WebElement SchemeId = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='schemeId']")));
			Select SchemeIddropdown = new Select(SchemeId);

			//passing the scheme
 			SchemeIddropdown.selectByVisibleText(sheet.getRow(8).getCell(1).getStringCellValue());

			Thread.sleep(2000);

			getSearch().click();

		}catch (Exception e) {

			e.printStackTrace();}
		}

	public void getConfigurationdetails() throws InterruptedException {

		String status = "", text = "";

		try {

			Thread.sleep(2000);

			WebElement t = driver.findElement(By.xpath("//*[@id='planTable']/tbody"));
			// count rows with size() method
			List<WebElement> rws = t.findElements(By.tagName("tr"));

			loop: for (int j = 0; j < rws.size(); j++)
			{

				List<WebElement> col_0 = rws.get(j).findElements(By.tagName("td"));

				String Coursetypename = col_0.get(0).getText();
				String Configuration = col_0.get(1).getText();
				String InternalConfigurationdetails = col_0.get(2).getText();
				System.out.println("****************************");
				System.out.println("Course Type Name "+Coursetypename);
				System.out.println("Con "+Configuration);
				System.out.println("internal con "+InternalConfigurationdetails);
				System.out.println(CourseSize);

				CoursetypenameEvalution.add(StringUtils.substringAfter(Coursetypename, "Course Type Name : "));
				//CoursetypenameEvalution[j] = StringUtils.substringAfter(Coursetypename, "Course Type Name : ");

				for (int k = 0; k < CourseSize; k++) {

					//        	System.out.println("Course Type name from Courses: " +RetrievedCoursetype[k]);
					System.out.println("Course Type name from Courses: " +RetrievedCoursetype.get(k));

					System.out.println("Course Type name from Courses: " +CoursetypenameEvalution.get(j));

					if((RetrievedCoursetype.get(k)).equals(CoursetypenameEvalution.get(j)))
					{
						ApplSessionalsEvaluation[j] = StringUtils.substringBetween(Configuration,"Applicable Sessionals :", "Exam Eligibility Condition :");

						System.out.println("Applicable Sessionals ["+j+"]: " +ApplSessionalsEvaluation[j]);

						ExamEligibilityCodnEvaluation[j] = StringUtils.substringBetween(Configuration,"Exam Eligibility Condition :", "Min Internals% Type :");

						System.out.println("Exam Eligibility Condition["+j+"] : " +ExamEligibilityCodnEvaluation[j]);

						MinAttendanceEvaluation[j] = StringUtils.substringBetween(InternalConfigurationdetails,"Min Attendance : ", "Min Attendance Long Leave :").trim();

						System.out.println("Min Attendance["+j+"] : " +MinAttendanceEvaluation[j]);
						//MinAttendanceEvaluation.add(StringUtils.substringBetween(InternalConfigurationdetails,"Min Attendance : ", "Min Attendance Long Leave :").trim());

						//System.out.println("Min Attendance["+j+"] : " +MinAttendanceEvaluation);


						MinAttendanceLongLeaveEvaluation[j] = StringUtils.substringBetween(InternalConfigurationdetails,"Min Attendance Long Leave : ", "Min Attendance Duty Leave:").trim();

						System.out.println("Min Attendance Long Leave["+j+"]: "+MinAttendanceLongLeaveEvaluation[j]);

						MinAttendanceDutyLeaveEvaluation[j] = StringUtils.substringBetween(InternalConfigurationdetails,"Min Attendance Duty Leave:", "Internal Mark Regulation:").trim();

						System.out.println("Min Attendance Duty Leave["+j+"]: " +MinAttendanceDutyLeaveEvaluation[j]);

						MenstrualLeaveRelaxationPercentage[j]=StringUtils.substringAfter(InternalConfigurationdetails,"Menstrual Leave Relaxation Percentage: ").trim();

						System.out.println("Menstrual Leave Relaxation Percentage is ["+j+"]: " +MenstrualLeaveRelaxationPercentage[j]);


						Thread.sleep(2000);

						continue loop;

					}
				}
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		Thread.sleep(2000);


	}

//	*****************************************************************************************************************************************************
//	public void facultylistingcourse() throws InterruptedException, AWTException {
//		int flag=0;
//
//		String status = "";
//
//		try {
//
//
//			Thread.sleep(2000);
//
//			WebElement yearClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"academicYearId\"]")));
//			Select yeardropdown = new Select(yearClick);
//			//passing the Academic year
// 			yeardropdown.selectByVisibleText(sheet.getRow(1).getCell(1).getStringCellValue());
//			Thread.sleep(2000);
//
//			WebElement ProgramClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"programId\"]")));
//			Select Programdropdown = new Select(ProgramClick);
//			//passing the Program
// 			Programdropdown.selectByVisibleText(sheet.getRow(2).getCell(1).getStringCellValue());
//
//			Thread.sleep(2000);
//
//			WebElement ProgtypeClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"programType\"]")));
//			Select Progtypedropdown = new Select(ProgtypeClick);
//			//passing the Program type
// 			Progtypedropdown.selectByVisibleText(sheet.getRow(3).getCell(1).getStringCellValue());
//
//			Thread.sleep(2000);
//
//			WebElement SemesterClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"semesterType\"]")));
//			Select Semestertypedropdown = new Select(SemesterClick);
//			//passing the Semester
// 			Semestertypedropdown.selectByVisibleText(sheet.getRow(9).getCell(1).getStringCellValue());
//			Thread.sleep(2000);
//
//			WebElement EligibilityClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"registrationAllowedStudentStatus\"]")));
//			Select Eligibilityfordropdown = new Select(EligibilityClick);
//			//passing the Semester
// 			Eligibilityfordropdown.selectByVisibleText(sheet.getRow(5).getCell(1).getStringCellValue());
//			Thread.sleep(2000);
////			Search button
//			Search.click();
//
//
//			//Faculty selecting his assigned course and click on attendance internal button
//			Thread.sleep(2000);
//			// count rows with size() method
//			List<WebElement> rws = driver.findElements(By.xpath("//*[@class='table table-responsive table-bordered']/tbody/tr"));
//
//			for (int j = 0; j < rws.size(); j++) {
//				List<WebElement> col_0 = rws.get(j).findElements(By.tagName("td"));
//				String Coursename = col_0.get(0).getText();
//				String courses[] = Coursename.split("-");
//				String courseCode="";
// 				if(courses.length==3)
//				{
//					courseCode=courses[2];
//				}
//				else
//				{
//					courseCode=courses[1];
//				}
//				String Branch = col_0.get(4).getText();
//				String Batch = col_0.get(5).getText();
//
//				System.out.println("****************************");
//				System.out.println("Course Type Name "+courses[1]);
//				System.out.println("Branch is "+Branch);
//				System.out.println("Batch is "+Batch);
//				System.out.println("Course Size="+CourseSize);
//				//Iterating through the course size
//				for( int k = 0; k< CourseSize;k++)
//				{
//
//					System.out.println("Course code is "+courseCodes.get(k));
//					//condition which says fetched course code=course listed in faculty log in && fetched Branch=
//					System.out.println(courseCode+"="+courseCodes.get(k));
//					System.out.println("****************************");
//					System.out.println(Branch+"="+Branchdetails.get(k));
//					System.out.println("****************************");
//					System.out.println(Batch+"="+batchnames.get(k));
//
//
//
//					if(courseCode.equals(courseCodes.get(k))&&Branch.equals(Branchdetails.get(k))&&Batch.equals(batchnames.get(k))&&flags.get(k)==0)
//					{
//						flags.add(k,1);
//						System.out.println("**********************");
//						System.out.println("Course code is "+courseCodes.get(k));
//						System.out.println("Branch is "+Branchdetails.get(k));
//						System.out.println("Batch name is "+batchnames.get(k));
//						System.out.println("**********************");
//
//						WebElement element = driver.findElement(By.xpath("//*[@class='table table-responsive table-bordered']/tbody/tr["+(j+1)+"]/td[8]/a[1]"));
//						element.click();
//
//
//						Thread.sleep(2000);
//						//xpath of the table
//						List<WebElement> rows = driver.findElements(By.xpath("//table[@id='programDetail']/thead/tr"));
//
//						int count = rows.size();
//						System.out.println("ROW COUNT : "+count);
//
//						// xpath of rows
//						List<WebElement> Attendance = driver.findElements(By.xpath("//input[contains(@id,'attendance')]"));
//						System.out.println("Number of students: " + Attendance.size());
//						System.out.println("Attendance "+Attendance.get(1));
//
//						//clear the mark column
//						Attendance.get(0).sendKeys(Keys.CONTROL + "a");
//						Attendance.get(0).sendKeys(Keys.DELETE);
//
//
//
//
//
//
//						int [] MinAttendanceEvaluationInteger = new int [100];
//						for(int i=0; i<10; i++) {
//							System.out.println("value is "+MinAttendanceEvaluation[i]);
//
//							if(MinAttendanceEvaluation[i] != null)
//							{
//
//								MinAttendanceEvaluationInteger[i] = Integer.parseInt(MinAttendanceEvaluation[i]);
//							}
//						}
//
//						//data for Student's Internals and Attendance
//						String maxvalue = String.valueOf((MinAttendanceEvaluationInteger[0])+26);
//						String zerovalue = String.valueOf((MinAttendanceEvaluationInteger[0])-75);
//
//
//
//						Robot robot = new Robot();
//						//Pressing the Tab Key
//
//
//
//						Thread.sleep(1000);
//						//clear the mark column
//						Attendance.get(0).sendKeys(Keys.CONTROL + "a");
//						Attendance.get(0).sendKeys(Keys.DELETE);
//
////						Entering attendance
// 						for (int i = 0; i < ((Attendance.size())-3); i++) {
//							System.out.println(Attendance.get(i).getText());
//							Attendance.get(i).sendKeys(Keys.CONTROL + "a");
//							Attendance.get(i).sendKeys(Keys.DELETE);
//							if(i<25)
//							{
//								Attendance.get(i).sendKeys(String.valueOf((Integer.parseInt(MinAttendanceEvaluation[0])-0)+i));
//							}else
//								Attendance.get(i).sendKeys(String.valueOf((Integer.parseInt(MinAttendanceEvaluation[0])+50)-i));
//						}
//
//
//
//						Thread.sleep(500);
//						// *********************************************************************************************************************
//
//
////						User Entering Internal marks
//
//						 //xpath of internal Marks rows
//						List<WebElement> Mark = driver.findElements(By.xpath("//input[contains(@id,'internalMarks')]"));
//						System.out.println("Number of students with Marks: " + Mark.size());
//
//						//get the minimum internal marks
//						String Text = driver.findElement(By.xpath("//*[@id='programDetail']/thead/tr[1]/th[3]")).getText();
//						System.out.println("Text of Marks: " +Text);
//
//						//get the value
//						String Internalmarks = Text.substring(15, 17);
//						System.out.println("Internal Marks: " +Integer.parseInt(Internalmarks));
//
//						//convert the value to integer
//						int Internal = Integer.parseInt(Internalmarks);
//						//************************************************************************
//
//
//
//
//
//
//
//
//						for (int i = 0; i < ((Mark.size())-1); i++) {
//						    if (Mark.get(i).isEnabled()) {
//						        //entering valid internal marks
//						        Mark.get(i).sendKeys(Keys.CONTROL + "a");
//						        Mark.get(i).sendKeys(Keys.DELETE);
//
//						        for (Map.Entry<String, List<String>> entry : dataMap.entrySet()) {
//						            String courseName = entry.getKey(); // Get the course name
//						            List<String> marksAsString = entry.getValue(); // Get the list of marks as strings
//						            // Convert the marks from string to integer
//						            List<Double> marksAsInteger = new ArrayList<>();
//						            for (String markAsString : marksAsString) {
//						            	if (markAsString != null && !markAsString.trim().isEmpty()) {
//						                // Parse the String mark to double(point values are there)
//						                Double mark = Double.valueOf(markAsString);
//						                marksAsInteger.add(mark);
//						            	}
//						            }
//						            System.out.println(marksAsInteger);
//
//						            // Get the mark value from marksAsInteger and convert it to String
//						            if(flag==0) {
//						            Double markValue = marksAsInteger.get(i);
//						            String markValueString = String.valueOf(markValue);
//
//						            //Send the mark value to the field
//						            Mark.get(i).sendKeys(markValueString);
//						            break;
//						            }
//						        }
//						    }
//						}
//
//
//						//Click the Save button
//						getSaveAttendancebutton().click();
//						Thread.sleep(2000);
//						//*************************************************************
//						MarkAsComplete.click();
//						//driver.navigate().refresh();
//						Thread.sleep(2000);
//
//						//Pressing the Enter Key
//						robot.keyPress(KeyEvent.VK_ENTER);
//						//Releasing the Enter Key
//						robot.keyRelease(KeyEvent.VK_ENTER);
//						Thread.sleep(3000);
//
//						}
//
//						}
//					}
//				}
//
//		catch (Exception e) {
//
//
//			System.out.println("entered in catch");
//			//e.printStackTrace();
//			getSaveAttendancebutton().click();
//			Thread.sleep(2000);
//			MarkAsComplete.click();
//			Robot robot = new Robot();
//			Thread.sleep(2000);
//			//Pressing the Enter Key
//			robot.keyPress(KeyEvent.VK_ENTER);
//			//Releasing the Enter Key
//			robot.keyRelease(KeyEvent.VK_ENTER);
//			Thread.sleep(4000);
//
//				}
//
//			}

//*************************************************************************************************************************

	public void facultylistingcourse() throws InterruptedException, AWTException {


		String status = "";

		try {


			Thread.sleep(2000);

			WebElement yearClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"academicYearId\"]")));
			Select yeardropdown = new Select(yearClick);
			//passing the Academic year
			yeardropdown.selectByVisibleText(sheet.getRow(1).getCell(1).getStringCellValue());
			Thread.sleep(500);

			WebElement ProgramClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"programId\"]")));
			Select Programdropdown = new Select(ProgramClick);
			//passing the Program
			Programdropdown.selectByVisibleText(sheet.getRow(2).getCell(1).getStringCellValue());

			Thread.sleep(500);

			WebElement ProgtypeClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"programType\"]")));
			Select Progtypedropdown = new Select(ProgtypeClick);
			//passing the Program type
			Progtypedropdown.selectByVisibleText(sheet.getRow(3).getCell(1).getStringCellValue());

			Thread.sleep(500);

			WebElement SemesterClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"semesterType\"]")));
			Select Semestertypedropdown = new Select(SemesterClick);
			//passing the Semester
			Semestertypedropdown.selectByVisibleText(sheet.getRow(9).getCell(1).getStringCellValue());
			Thread.sleep(500);

			WebElement EligibilityClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"registrationAllowedStudentStatus\"]")));
			Select Eligibilityfordropdown = new Select(EligibilityClick);
			//passing the Semester
			Eligibilityfordropdown.selectByVisibleText(sheet.getRow(5).getCell(1).getStringCellValue());
			Thread.sleep(2000);
			//			Search button
			Search.click();


			//Faculty selecting his assigned course and click on attendance internal button
			Thread.sleep(2000);
			// count rows with size() method
			List<WebElement> rws = driver.findElements(By.xpath("//*[@class='table table-responsive table-bordered']/tbody/tr"));

			for (int j = 0; j < rws.size(); j++) {
				List<WebElement> col_0 = rws.get(j).findElements(By.tagName("td"));
				String Coursename = col_0.get(0).getText();
				String courses[] = Coursename.split("-");
				String courseCode="";
				if(courses.length==3)
				{
					courseCode=courses[2];
				}
				else
				{
					courseCode=courses[1];
				}
				String Branch = col_0.get(4).getText();
				String Batch = col_0.get(5).getText();

				System.out.println("****************************");
				System.out.println("Course Type Name "+courses[1]);
				System.out.println("Branch is "+Branch);
				System.out.println("Batch is "+Batch);
				System.out.println("Course Size="+CourseSize);
				//Iterating through the course size
				for( int k = 0; k< CourseSize;k++)
				{

					System.out.println("Course code is "+courseCodes.get(k));
					//condition which says fetched course code=course listed in faculty log in && fetched Branch=
					System.out.println(courseCode+"="+courseCodes.get(k));
					System.out.println("****************************");
					System.out.println(Branch+"="+Branchdetails.get(k));
					System.out.println("****************************");
					System.out.println(Batch+"="+batchnames.get(k));



					if(courseCode.equals(courseCodes.get(k))&&Branch.equals(Branchdetails.get(k))&&Batch.equals(batchnames.get(k))&&flags.get(k)==0)
					{
						flags.add(k,1);
						System.out.println("**********************");
						System.out.println("Course code is "+courseCodes.get(k));
						System.out.println("Branch is "+Branchdetails.get(k));
						System.out.println("Batch name is "+batchnames.get(k));
						System.out.println("**********************");

						WebElement element = driver.findElement(By.xpath("//*[@class='table table-responsive table-bordered']/tbody/tr["+(j+1)+"]/td[8]/a[1]"));
						element.click();


						Thread.sleep(2000);
						//xpath of the table
						List<WebElement> rows = driver.findElements(By.xpath("//table[@id='programDetail']/thead/tr"));

						int count = rows.size();
						System.out.println("ROW COUNT : "+count);

						//xpath of rows
						List<WebElement> Attendance = driver.findElements(By.xpath("//input[contains(@id,'attendance')]"));
						System.out.println("Number of students: " + Attendance.size());
						System.out.println("Attendance "+Attendance.get(1));

						//clear the mark column
						Attendance.get(0).sendKeys(Keys.CONTROL + "a");
						Attendance.get(0).sendKeys(Keys.DELETE);
						int [] MinAttendanceEvaluationInteger = new int [100];
						for(int i=0; i<10; i++) {
							System.out.println("value is "+MinAttendanceEvaluation[i]);

							if(MinAttendanceEvaluation[i] != null)
							{

								MinAttendanceEvaluationInteger[i] = Integer.parseInt(MinAttendanceEvaluation[i]);
							}
						}

						//data for Student's Internals and Attendance
						String maxvalue = String.valueOf((MinAttendanceEvaluationInteger[0])+26);
						String zerovalue = String.valueOf((MinAttendanceEvaluationInteger[0])-75);



						Robot robot = new Robot();



						Thread.sleep(1000);
						//clear the mark column
						Attendance.get(0).sendKeys(Keys.CONTROL + "a");
						Attendance.get(0).sendKeys(Keys.DELETE);

						//						Entering attendance
						for (int i = 0; i < ((Attendance.size())-3); i++) {
							System.out.println(Attendance.get(i).getText());
							Attendance.get(i).sendKeys(Keys.CONTROL + "a");
							Attendance.get(i).sendKeys(Keys.DELETE);
							if(i<25)
							{
								Attendance.get(i).sendKeys(String.valueOf((Integer.parseInt(MinAttendanceEvaluation[0])-0)+i));
							}else
								Attendance.get(i).sendKeys(String.valueOf((Integer.parseInt(MinAttendanceEvaluation[0])+50)-i));
						}



						Thread.sleep(500);
						// *********************************************************************************************************************


						//User Entering Internal marks

						//xpath of internal Marks rows
						List<WebElement> Mark = driver.findElements(By.xpath("//input[contains(@id,'internalMarks')]"));
						System.out.println("Number of students with Marks: " + Mark.size());


						 for (int i = 0; i < ((Mark.size())-1); i++) {
							if (Mark.get(i).isEnabled()) {
								//entering valid internal marks
								Mark.get(i).sendKeys(Keys.CONTROL + "a");
								Mark.get(i).sendKeys(Keys.DELETE);

								// Get the course name based on the index
						        String courseKey = "Course" + index;
						        List<String> marksAsString = dataMap.get(courseKey);

						        if (marksAsString != null && !marksAsString.isEmpty()) {
						            // Convert the marks from string to double using loop
						            List<Double> marksAsDouble = new ArrayList<>();
						            for (String mark : marksAsString) {
						                if (mark != null && !mark.trim().isEmpty()) {
						                    marksAsDouble.add(Double.valueOf(mark));
						                }
						            }

						         // Check if the index is within the bounds of the marks list
						            if (i < marksAsDouble.size()) {
						                // Get the mark value from marksAsDouble and convert it to String
						                String markValueString = String.valueOf(marksAsDouble.get(i));

						                // Send the mark value to the field
						                Mark.get(i).sendKeys(markValueString);
//						                element.sendKeys(markValueString);
						            }
								}
						    }
						}
						// Increment the index for the next course
						dataMap.get("Course"+index++);
						if (index >= CourseSize) {
						    index = 1;
						}
//


						//Click the Save button
						getSaveAttendancebutton().click();
						Thread.sleep(2000);
 						MarkAsComplete.click();
						//driver.navigate().refresh();
						Thread.sleep(2000);

						//Pressing the Enter Key
						robot.keyPress(KeyEvent.VK_ENTER);
						//Releasing the Enter Key
						robot.keyRelease(KeyEvent.VK_ENTER);
						Thread.sleep(3000);

					}

				}
			}
		}

		catch (Exception e) {


			System.out.println("entered in catch");
			//e.printStackTrace();
			getSaveAttendancebutton().click();
			Thread.sleep(2000);
			// Increment the index for the next course
			dataMap.get("Course"+index++);
			// Reset the index if it exceeds the total number of courses
			if (index >= CourseSize) {
			    index = 1;
			}
			MarkAsComplete.click();
			Robot robot = new Robot();
			Thread.sleep(2000);
			//Pressing the Enter Key
			robot.keyPress(KeyEvent.VK_ENTER);
			//Releasing the Enter Key
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(4000);

		}

	}
//	******************************************************************************************************************************************************************
	public void notEligible(int i) throws InterruptedException
	{
		String eligibleForWrittenExam = driver.findElement(By.xpath("//*[@class='table table-bordered table-striped']/thead/tr["+i+"]/td[7]/span[2]/label")).getText();
		String msg="No";
		assertEquals(eligibleForWrittenExam, msg);
		Thread.sleep(500);


	}
	public void eligible(int i) throws InterruptedException
	{

		String eligibleForWrittenExam = driver.findElement(By.xpath("//*[@class='table table-bordered table-striped']/thead/tr["+(i)+"]/td[7]/span[2]/label")).getText();
		String msg="Yes";
		assertEquals(eligibleForWrittenExam, msg);
		Thread.sleep(500);
	}

	public void advisorBatches() throws InterruptedException {


		try {


			Thread.sleep(2000);

			WebElement yearClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"academicYearId\"]")));
			Select yeardropdown = new Select(yearClick);

			//passing the Academic year
 			yeardropdown.selectByVisibleText(sheet.getRow(1).getCell(1).getStringCellValue());

			Thread.sleep(2000);

			WebElement ProgramClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"programId\"]")));
			Select Programdropdown = new Select(ProgramClick);
			//passing the Program
 			Programdropdown.selectByVisibleText(sheet.getRow(2).getCell(1).getStringCellValue());

			Thread.sleep(2000);

			WebElement ProgtypeClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"programType\"]")));
			Select Progtypedropdown = new Select(ProgtypeClick);
			//passing the Program type
 			Progtypedropdown.selectByVisibleText(sheet.getRow(3).getCell(1).getStringCellValue());

			Thread.sleep(2000);

			WebElement SemesterClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"semesterId\"]")));
			Select Semesterdropdown = new Select(SemesterClick);
			//passing the Semester
 			Semesterdropdown.selectByVisibleText(sheet.getRow(4).getCell(1).getStringCellValue());

			Thread.sleep(2000);
			WebElement EligibilityClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='registrationAllowedStudentStatus']")));
			Select Eligibilitydropdown = new Select(EligibilityClick);
			//passing the Batch
 			Eligibilitydropdown.selectByVisibleText(sheet.getRow(5).getCell(1).getStringCellValue());

			Thread.sleep(2000);

			WebElement DegreetypeClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"degreeType\"]")));
			Select Degreetypedropdown = new Select(DegreetypeClick);
			//passing the Degree
			Degreetypedropdown.selectByVisibleText(sheet.getRow(6).getCell(1).getStringCellValue());

			Thread.sleep(2000);
			//Click on Search button
			driver.findElement(By.xpath("//*[@id=\"searchForm_search\"]")).click();

			Thread.sleep(2000);

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		Thread.sleep(1000);
	}

	public void confirmAttendance() throws InterruptedException {


		try {

			List<WebElement> StaffAdvisor = driver.findElements(By.xpath("//td[text()='Submitted by Faculty']"));

			int staffAdvisorlistsize=StaffAdvisor.size();
			System.out.println("staff advisor status size is "+staffAdvisorlistsize);
			for( int i = 0; i< staffAdvisorlistsize;i++)

			{

				//click the view student attendance internal button
				try
				{
//				WebElement element = driver.findElement(By.xpath("(//table[@id='programDetail']//tbody//tr["+(i+1)+"]//td[text()='Submitted by Faculty']//following::a[1])"));
				WebElement element = driver.findElement(By.xpath("(//table[@id='programDetail']//tbody//tr//td[text()='Submitted by Faculty']//following::a[1])"));
				System.out.println("i is " +i );
				Thread.sleep(3000);

				element.click();
				Thread.sleep(3000);
				ConfirmButton.click();
				//Submit pop-up button
				Robot robot= new Robot();
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(2000);
				}
				catch(Exception e)
				{

				}

			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}



	}
	public void AttendanceInternals() throws InterruptedException {


		try {



			Thread.sleep(2000);

			// click the Student Attendance/Internals
			AttendanceInternals.click();

			WebElement yearClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"academicYearId\"]")));
			Select yeardropdown = new Select(yearClick);

			//passing the Academic year
 			yeardropdown.selectByVisibleText(sheet.getRow(1).getCell(1).getStringCellValue());

			Thread.sleep(2000);

			WebElement ProgramClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"programId\"]")));
			Select Programdropdown = new Select(ProgramClick);

			//passing the Program
			Programdropdown.selectByVisibleText(sheet.getRow(2).getCell(1).getStringCellValue());

			Thread.sleep(2000);

			WebElement ProgtypeClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"programType\"]")));
			Select Progtypedropdown = new Select(ProgtypeClick);

			//passing the Program type
 			Progtypedropdown.selectByVisibleText(sheet.getRow(3).getCell(1).getStringCellValue());

			Thread.sleep(2000);

			WebElement SemesterClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"semesterId\"]")));
			Select Semesterdropdown = new Select(SemesterClick);

			//passing the Semester
 			Semesterdropdown.selectByVisibleText(sheet.getRow(4).getCell(1).getStringCellValue());

			Thread.sleep(2000);

			WebElement EligibilityClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='registrationAllowedStudentStatus']")));
			Select Eligibilitydropdown = new Select(EligibilityClick);
			//passing the Batch
			Eligibilitydropdown.selectByVisibleText(sheet.getRow(5).getCell(1).getStringCellValue());

			Thread.sleep(2000);

			WebElement DegreeClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"degreeType\"]")));
			Select Degreedropdown = new Select(DegreeClick);

			//passing the Degree
 			Degreedropdown.selectByVisibleText(sheet.getRow(6).getCell(1).getStringCellValue());

			Thread.sleep(2000);

			//Click on Search button
			Search.click();

			Branchname1 = driver.findElement(By.xpath("//a[@class='list-group-item active']")).getText();

			Branch = StringUtils.substringAfter(Branchname1, "Branch/Stream:");

			System.out.println("*********** "+Branch);

			Thread.sleep(2000);

		} catch (Exception e) {

			e.printStackTrace();

		}

		Thread.sleep(1000);

	}

	public  String  validationMsg()
	{

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='alert alert-warning']")));
		element.getText();


		return "Your institution's Internals have been submitted for the selected program to the university";

	}
	public void branchSubmit () throws InterruptedException, AWTException{
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"selectAll\"]")));

		element.click();
		BranchListingSubmit.click();

		Thread.sleep(1000);
		Robot robot = new Robot();
		//Pressing the Enter Key
		robot.keyPress(KeyEvent.VK_ENTER);

		//Releasing the Enter Key
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(25000);


	}

	public void clearAll()
	{
		courseCodes.clear();
		batchnames.clear();
		Branchdetails.clear();
		flags.clear();

	}





	public void readCourseFromExcelAndStoreInMap() throws IOException {


        //Getting the sheet
		sheet2 = workbook.getSheetAt(3);
		System.out.println(sheet2.getRow(1).getCell(1).getRawValue());

		//Start fetching marks from the second row
		int rowNum=0;
		for (rowNum=0;rowNum<42;rowNum++) {
			course1Marks.add(sheet2.getRow(rowNum).getCell(1).getRawValue());

		}
		System.out.println("Course1 mark is "+course1Marks);


// 		start fetching mark of course2
		for (rowNum=43;rowNum<85;rowNum++){
			course2Marks.add(sheet2.getRow(rowNum).getCell(1).getRawValue());
		}

		System.out.println("course2 mark is "+course2Marks);

//		Start fetching mark of course3
		for(rowNum=86;rowNum<128;rowNum++) {
			course3Marks.add(sheet2.getRow(rowNum).getCell(1).getRawValue());

		}
		System.out.println("course3 mark is "+course3Marks);

//		Start fetching mark of Course4
		for(rowNum=129;rowNum<171;rowNum++) {
			course4Marks.add(sheet2.getRow(rowNum).getCell(1).getRawValue());
		}
		System.out.println("course4 mark is "+course4Marks);

//		Start fetching mark of course5
		for(rowNum=172;rowNum<214;rowNum++) {
			course5Marks.add(sheet2.getRow(rowNum).getCell(1).getRawValue());

		}
		System.out.println("course5 mark is "+course5Marks);


//		Start fetching mark of course6
		for(rowNum=215;rowNum<257;rowNum++) {
			course6Marks.add(sheet2.getRow(rowNum).getCell(1).getRawValue());

		}
		System.out.println("course6 mark is "+course6Marks);

//		Start fetching mark of course7
		for(rowNum=258;rowNum<300;rowNum++) {
			course7Marks.add(sheet2.getRow(rowNum).getCell(1).getRawValue());

		}
		System.out.println("course7 mark is "+course7Marks);

//		Start fetching mark of course8
		for(rowNum=301;rowNum<343;rowNum++) {
			course8Marks.add(sheet2.getRow(rowNum).getCell(1).getRawValue());

		}
		System.out.println("course8 mark is "+course8Marks);

//		Store ArrayList in Map
		dataMap.put("Course1", course1Marks);
		dataMap.put("Course2", course2Marks);
		dataMap.put("Course3", course3Marks);
		dataMap.put("Course4", course4Marks);
		dataMap.put("Course5", course5Marks);
		dataMap.put("Course6", course6Marks);
		dataMap.put("Course7", course7Marks);
		dataMap.put("Course8", course8Marks);



//		print the data stored in the maps

		for (Map.Entry<String, List<String>> entry : dataMap.entrySet())
			{
            System.out.println("Course: " + entry.getKey());
            List<String> marks = entry.getValue();
            for (String mark : marks) {
                System.out.println("Mark: " + mark);
            }





	}







	}
}










