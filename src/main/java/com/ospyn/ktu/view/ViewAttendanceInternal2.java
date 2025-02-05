package com.ospyn.ktu.view;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.ospyn.ktu.util.SeleniumBase;

public class ViewAttendanceInternal2 extends SeleniumBase{
	//**************************************************************************************
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
	public  static int CourseSize;
	public static String[] strCoursecode;
	public static String Batch;
	public static String[] strFacultyId;

	public static String[] RetrievedFacultyId = new String[10];
	public static String[] RetrievedCoursecode = new String[100];
	public static String[] ReducedCoursecode = new String[100];
	public static String[] RetrievedBatch = new String[100];
	//	public static String[] RetrievedCoursetype = new String[100];
	//		public static String[] StaffAdvisorId;
	public static String[] RetrievedStaffAdvisorId = new String[100];
	//		public static String[] CoursetypenameEvalution = new String[100];
	public static String[] ApplSessionalsEvaluation = new String[100];
	public static String[] ExamEligibilityCodnEvaluation = new String[100];
	public static String[] MinAttendanceEvaluation = new String[100];

	public static String[] MinAttendanceLongLeaveEvaluation = new String[100];
	public static String[] MinAttendanceDutyLeaveEvaluation = new String[100];
	public static String[] IneligibleType = new String[100];

	public static String[] EligibleForWrittenExam = new String[100];

	public static String[] IntAttendCourses = new String[100];
	public static String[] IntAttendbatch = new String[100];
	//	**************************************
	String course[]=new String[3];
	String Facultyid;
	String courseDetails;
	String facultyDetails;
	String batchDetails;
	static int flag=0,flag1=0;
	//	public static String[] RetrievedCoursetype = new String[100];

	public static List<String>courseCodes=new ArrayList<String>();
	public static Object[] Branchnames;
	public static Object[] facultyids;
	public static List<String>batchnames=new ArrayList<String>();
	public static List<Integer>flags=new ArrayList<Integer>();

	public static List<String>StaffAdvisorId=new ArrayList<String>();

	public static List<String>confirmStaffAdvisorId=new ArrayList<String>();

	public static List<String>Branchdetails=new ArrayList<String>();
	public static List<String>RetrievedCoursetype=new ArrayList<String>();

	public static List<String>CoursetypenameEvalution=new ArrayList<String>();
	//	public static String[] MinAttendanceEvaluation = new String[100];
	//	public static List<String>MinAttendanceEvaluation=new ArrayList<String>();
	//	public static List<String>EligibleForWrittenExam=new ArrayList<String>();
	//	public static List<String>IneligibleType = new ArrayList<String>();

	//	public static List<String>Coursename=new ArrayList<String>();

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

	public ViewAttendanceInternal2(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
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








	public void Attendanceinternal(String attendanceinter) throws InterruptedException {

		String status = "";

		try {

			//Parameters
			List<String> params = new ArrayList<>();
			params = Arrays.asList(attendanceinter.split(",#"));


			Thread.sleep(2000);

			// click the Student Attendance/Internals
			AttendanceInternals.click();

			WebElement yearClick = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id=\"academicYearId\"]")));

			Select yeardropdown = new Select(yearClick);

			////passing the Academic year
			yeardropdown.selectByVisibleText(params.get(0));

			Thread.sleep(2000);

			WebElement ProgramClick = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id=\"programId\"]")));

			Select Programdropdown = new Select(ProgramClick);

			////passing the Program
			Programdropdown.selectByVisibleText(params.get(1));

			Thread.sleep(2000);

			WebElement ProgtypeClick = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id=\"programType\"]")));

			Select Progtypedropdown = new Select(ProgtypeClick);

			////passing the Program type
			Progtypedropdown.selectByVisibleText(params.get(2));

			Thread.sleep(2000);

			WebElement SemesterClick = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id=\"semesterId\"]")));

			Select Semesterdropdown = new Select(SemesterClick);

			////passing the Semester
			Semesterdropdown.selectByVisibleText(params.get(3));

			Thread.sleep(2000);

			WebElement BatchClick = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id='registrationAllowedStudentStatus']")));

			Select Batchdropdown = new Select(BatchClick);

			////passing the Batch
			Batchdropdown.selectByVisibleText(params.get(4));

			Thread.sleep(2000);

			WebElement DegreeClick = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id=\"degreeType\"]")));

			Select Degreedropdown = new Select(DegreeClick);

			////passing the Degree
			Degreedropdown.selectByVisibleText(params.get(5));

			Thread.sleep(2000);

			//Click on Search button
			Search.click();

			//			Branchname = driver.findElement(By.xpath("//a[@class='list-group-item active']")).getText();
			//
			//			Branch = StringUtils.substringAfter(Branchname, "Branch/Stream:");
			//
			//			System.out.println(Branch);
			//
			//			Thread.sleep(2000);

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

			e.printStackTrace();

		}

		Thread.sleep(1000);

	}

	public void clickInternalsButton(String branchname)throws Exception
	{
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//b[contains(text(),'"+branchname+"')]//following::a[1]")));
		System.out.println("Branch is ******"+branchname);
		element.click();
		Thread.sleep(1000);


	}
	public void moveBack()throws Exception
	{
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='back']")));
		element.click();
		Thread.sleep(1000);
	}


	public String[] CoursecodeFacultyId() throws InterruptedException {


		String status = "";

		try {



			Thread.sleep(2000);

			// click the Student Attendance/Internals
			//			StudentInternalsAttendance.click();
			//				***************************
			//				Getting course code
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
				//					course= StringUtils.substringBetween(courseDetails, "(", ")");
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


		/*
		 * WebElement element =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(
		 * By.xpath("//*[@id='back']")));
		 *
		 * element.click();
		 */

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='back']")));
		element.click();


		Thread.sleep(1000);
		return RetrievedFacultyId;

	}
	public void StaffAdvisor(String advisor) throws InterruptedException {

		String status = "";

		try {
			//Parameters
			List<String> params = new ArrayList<>();
			params = Arrays.asList(advisor.split(",#"));



			Thread.sleep(2000);

			WebElement yearClick = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id='academicYear']")));

			Select yeardropdown = new Select(yearClick);

			////passing the Academic year
			yeardropdown.selectByVisibleText(params.get(0));

			Thread.sleep(2000);

			WebElement ProgramClick = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id=\"programId\"]")));

			Select Programdropdown = new Select(ProgramClick);

			////passing the Program
			Programdropdown.selectByVisibleText(params.get(1));

			Thread.sleep(2000);

			WebElement ProgtypeClick = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id='degreeType']")));

			Select Progtypedropdown = new Select(ProgtypeClick);

			////passing the Program type
			Progtypedropdown.selectByVisibleText(params.get(2));


			//WebElement t = ;

			// count rows with size() method
			List<WebElement> rows = driver.findElements(By.xpath("//*[@id='batchListingTable']/tbody/tr"));

			for (int i = 1; i < rows.size(); i++)
			{
				Thread.sleep(1000);
				//List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
				WebElement cellBatch = driver.findElement(By.xpath("//*[@id='batchListingTable']/tbody/tr["+i+"]/td[2]"));

				WebElement cellBranch = driver.findElement(By.xpath("//*[@id='batchListingTable']/tbody/tr["+i+"]/td[6]"));
				System.out.println(cellBranch.getText());
				System.out.println(Branch);
				String branchName=cellBranch.getText();
				if(branchName.equals("ELECTRONICS & COMMUNICATION ENGG"))
					branchName="ELECTRONICS AND COMMUNICATION ENGINEERING";

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

							//System.out.println(AdvisorId);

							StaffAdvisorId.add(0,AdvisorId[0]);
							System.out.println("staff advisor is "+StaffAdvisorId.get(0));

							Thread.sleep(1000);


							Closebutton.click();
							Thread.sleep(1000);
							break;
						}}

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

				//			List<WebElement> rws =driver.findElements(By.xpath("//*[@id='courseListingTable']/tbody/tr"));
				//	         // count rows with size() method
				//			//List<WebElement> rws = t.findElements(By.tagName("tr"));
				//
				//			for (int j = 0; j < rws.size(); j++) {

				WebElement  col_0 = driver.findElement(By.xpath("//*[@id='courseListingTable']/tbody/tr/td[3]"));

				RetrievedCoursetype.add(col_0.getText());
				//	        RetrievedCoursetype[i] = col_0.get(2).getText();

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

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a[@href='/university/logout.htm']")));

		element.click();




	}


	public void Schemeselection(String stringList) throws InterruptedException {

		String status = "";

		try {
			//Parameters
			List<String> params = new ArrayList<>();
			params = Arrays.asList(stringList.split(",#"));

			Thread.sleep(2000);

			WebElement SchemeId = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id='schemeId']")));

			Select SchemeIddropdown = new Select(SchemeId);

			////passing the scheme
			SchemeIddropdown.selectByVisibleText(params.get(0));

			Thread.sleep(2000);

			getSearch().click();

		}catch (Exception e) {

			e.printStackTrace();

		}

	}
	public void getConfigurationdetails() throws InterruptedException {

		String status = "", text = "";

		try {

			Thread.sleep(2000);

			WebElement t = driver.findElement(By.xpath("//*[@id='planTable']/tbody"));
			// count rows with size() method
			List<WebElement> rws = t.findElements(By.tagName("tr"));

			loop: for (int j = 0; j < rws.size(); j++) {

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
				//        CoursetypenameEvalution[j] = StringUtils.substringAfter(Coursetypename, "Course Type Name : ");

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
						//						MinAttendanceEvaluation.add(StringUtils.substringBetween(InternalConfigurationdetails,"Min Attendance : ", "Min Attendance Long Leave :").trim());

						//						System.out.println("Min Attendance["+j+"] : " +MinAttendanceEvaluation);


						MinAttendanceLongLeaveEvaluation[j] = StringUtils.substringBetween(InternalConfigurationdetails,"Min Attendance Long Leave : ", "Min Attendance Duty Leave:").trim();

						System.out.println("Min Attendance Long Leave["+j+"]: "+MinAttendanceLongLeaveEvaluation[j]);

						MinAttendanceDutyLeaveEvaluation[j] = StringUtils.substringBetween(InternalConfigurationdetails,"Min Attendance Duty Leave:", "Internal Mark Regulation:").trim();

						System.out.println("Min Attendance Duty Leave["+j+"]: " +MinAttendanceDutyLeaveEvaluation[j]);

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

	public void facultylistingcourse(String AssignedCourses) throws InterruptedException {

		String status = "";

		try {
			//Parameters
			List<String> params = new ArrayList<>();
			params = Arrays.asList(AssignedCourses.split(",#"));

			Thread.sleep(2000);

			WebElement yearClick = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id=\"academicYearId\"]")));

			Select yeardropdown = new Select(yearClick);

			////passing the Academic year
			yeardropdown.selectByVisibleText("2022 - 2023");

			Thread.sleep(2000);

			WebElement ProgramClick = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id=\"programId\"]")));

			Select Programdropdown = new Select(ProgramClick);

			////passing the Program
			Programdropdown.selectByVisibleText("B.Tech");

			Thread.sleep(2000);

			WebElement ProgtypeClick = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id=\"programType\"]")));

			Select Progtypedropdown = new Select(ProgtypeClick);

			////passing the Program type
			Progtypedropdown.selectByVisibleText("Full Time");

			Thread.sleep(2000);

			WebElement SemesterClick = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id=\"semesterType\"]")));

			Select Semesterdropdown = new Select(SemesterClick);

			////passing the Semester
			Semesterdropdown.selectByVisibleText("Even");

			Thread.sleep(2000);

			WebElement EligibilityClick = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id=\"registrationAllowedStudentStatus\"]")));

			Select Eligibilityfordropdown = new Select(EligibilityClick);

			////passing the Semester
			Eligibilityfordropdown.selectByVisibleText("Pursuing Students");
			Thread.sleep(2000);

			Search.click();


			//	Faculty selecting his assigned course and click on attendance internal button
			Thread.sleep(2000);

			//		WebElement t = driver.findElement(By.xpath("//*[@class='table table-responsive table-bordered']/tbody"));
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

						// xpath of rows
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

						// 1st element error scenario
						Attendance.get(0).sendKeys(maxvalue);

						Thread.sleep(500);

						Robot robot = new Robot();

						//Pressing the Tab Key
						robot.keyPress(KeyEvent.VK_TAB);

						//Releasing the Tab Key
						robot.keyRelease(KeyEvent.VK_TAB);

						Thread.sleep(2000);
						//Pressing the Enter Key

						robot.keyPress(KeyEvent.VK_ENTER);

						//Releasing the Enter Key
						robot.keyRelease(KeyEvent.VK_ENTER);
						//						scenario.log("<b style = \"font-size: 10px;\">Value not accepted and validation message is displayed</b>");

						Thread.sleep(1000);

						//clear the mark column
						Attendance.get(0).sendKeys(Keys.CONTROL + "a");
						Attendance.get(0).sendKeys(Keys.DELETE);

						//enter a valid internal marks
						Attendance.get(0).sendKeys(zerovalue);

						//clear the mark column
						Attendance.get(1).sendKeys(Keys.CONTROL + "a");
						Attendance.get(1).sendKeys(Keys.DELETE);

						// 1st element error scenario negative value

						Attendance.get(1).sendKeys("-1");

						Thread.sleep(500);

						//Pressing the Tab Key
						robot.keyPress(KeyEvent.VK_TAB);

						//Releasing the Tab Key
						robot.keyRelease(KeyEvent.VK_TAB);

						Thread.sleep(2000);

						//Pressing the Enter Key
						robot.keyPress(KeyEvent.VK_ENTER);

						//Releasing the Enter Key
						robot.keyRelease(KeyEvent.VK_ENTER);

						Thread.sleep(1000);

						//clear the mark column
						Attendance.get(1).sendKeys(Keys.CONTROL + "a");
						Attendance.get(1).sendKeys(Keys.DELETE);

						//enter a valid internal marks
						Attendance.get(1).sendKeys(zerovalue+1);
						//						scenario.log("<b style = \"font-size: 10px;\">Entering Valid Attendance for each student </b>");


						for (int i = 2; i < ((Attendance.size())-3); i++) {
							System.out.println(Attendance.get(i).getText());
							Attendance.get(i).sendKeys(Keys.CONTROL + "a");
							Attendance.get(i).sendKeys(Keys.DELETE);
							if(i<25)
							{
								Attendance.get(i).sendKeys(String.valueOf((Integer.parseInt(MinAttendanceEvaluation[0])-4)+i));
							}else
								Attendance.get(i).sendKeys(String.valueOf((Integer.parseInt(MinAttendanceEvaluation[0])+50)-i));
						}

						//initial value is given as 101, then updated to 0 (so ineligible type is
						//attendance shortage)
						IneligibleType[0] = "Attendance Shortage";
						EligibleForWrittenExam[0] = "No";
						//							scenario.log("<b style = \"font-size: 10px;\">Ineligibility-Type will  be set to \"Attendance Shortage\" while entering values less than required attendance </b>");


						//initial value is given as -1, then updated to 1 (so ineligible type is
						//attendance shortage)
						IneligibleType[1] = "Attendance Shortage";
						EligibleForWrittenExam[1] = "No";

						for (int i = 2; i < ((Attendance.size())-3); i++) {

							//System.out.println(Attendance.get(i).getAttribute("value"));
							int enteredAttendance = Integer.parseInt(Attendance.get(i).getAttribute("value"));
							if (enteredAttendance < 75) {
								IneligibleType[i] = "Attendance Shortage";
								EligibleForWrittenExam[i] = "No";
							}else// if((Integer.parseInt(params.get(i)) >= 75) && (Integer.parseInt(strArray[i]) > 0))
							{
								IneligibleType[i] = "";
								EligibleForWrittenExam[i] = "Yes";
							}
						}

						Thread.sleep(500);




						//*********************************************************************************************************************
						//*********************************************************************************************************************
						//					   if(faculty[k].equals("KTU-F2850") && RetrievedCoursecode[k].equals("CST308"))
						//					   {
						//
						//						   //Click the Save button
						//						   getSaveAttendancebutton().click();
						//						   Thread.sleep(3000);
						//
						//						   MarkAsComplete.click();
						//						   Thread.sleep(1000);
						//
						//						   //Pressing the Enter Key
						//						   robot.keyPress(KeyEvent.VK_ENTER);
						//
						//						   //Releasing the Enter Key
						//						   robot.keyRelease(KeyEvent.VK_ENTER);
						//
						//						   Thread.sleep(2000);
						//						   List<WebElement> reason = driver.findElements(By.xpath("//label[contains(@id,'reason')]"));
						//						   System.out.println("Reason for Ineligibility: " + reason.size());
						//
						//						   ArrayList<String> expected = new ArrayList<String>(){{
						//						   for (int i = 0; i < ((reason.size())-1); i++) {
						//							    add(IneligibleType[i]);
						//							   }
						//						    }};
						//
						//						   ArrayList<String> actual = new ArrayList<String>()
						//						   {{
						//							  for (int i = 0; i < ((reason.size())-1); i++)
						//							  {
						//							      System.out.println(reason.get(i).getText());
						//							      //get the reason for ineligibility for all students
						//							      add(reason.get(i).getText());
						//							    }
						//							 }};
						//
						//						   for (int i=0;i<actual.size();i++)
						//							    {
						//							       System.out.println("Validation Message =" + " " + actual.get(i));
						//							    }
						//
						////							System.out.println("expected="+expected);
						////							System.out.println("actual="+actual);
						//
						//							Assert.assertEquals(actual,expected,"incorrect error message or error message is absent");
						//
						//							List<WebElement> eligibility = driver.findElements(By.xpath("//label[contains(@id,'eligibility')]"));
						//							System.out.println("eligibility for exam: " + eligibility.size());
						//
						//							ArrayList<String> expectedEligibility = new ArrayList<String>(){{
						//							for (int i = 0; i < ((eligibility.size())-1); i++) {
						//							             add(EligibleForWrittenExam[i]);
						//							     }
						//							}};
						//
						//							ArrayList<String> actualEligibility = new ArrayList<String>()
						//							     {{
						//							     for (int i = 0; i < ((eligibility.size())-1); i++) {
						//							         	System.out.println(eligibility.get(i).getText());
						//							         	    	    add(eligibility.get(i).getText());
						//							         }
						//							     }};
						//
						//							     for (int i=0;i<actual.size();i++)
						//							           {
						//							              System.out.println("Validation Message =" + " " + actual.get(i));
						//							           }
						//
						//							System.out.println("expected="+expectedEligibility);
						//							System.out.println("actual="+actualEligibility);
						//
						//							Assert.assertEquals(actualEligibility,expectedEligibility,"incorrect error message or error message is absent");
						//
						//							//logout from the current faculty
						//							driver.findElement(By.xpath("//a[contains(@href,'logout.htm')]")).click();
						//							Thread.sleep(2000);
						//
						//				            continue outerloop;
						//					   }

						//xpath of internal Marks rows
						List<WebElement> Mark = driver.findElements(By.xpath("//input[contains(@id,'internalMarks')]"));
						System.out.println("Number of students with Marks: " + Mark.size());

						//get the minimum internal marks
						String Text = driver.findElement(By.xpath("//*[@id='programDetail']/thead/tr[1]/th[3]")).getText();
						System.out.println("Text of Marks: " +Text);

						//get the value
						String Internalmarks = Text.substring(15, 17);
						System.out.println("Internal Marks: " +Integer.parseInt(Internalmarks));

						//convert the value to integer
						int Internal = Integer.parseInt(Internalmarks);

						//clear the mark column
						Mark.get(4).sendKeys(Keys.CONTROL + "a");
						Mark.get(4).sendKeys(Keys.DELETE);

						// 1st element error scenario
						strArray[0] = String.valueOf(Internal+1);
						//						scenario.log("<b style = \"font-size: 10px;\">Trying to input value greater than maximum internal </b>");


						Mark.get(4).sendKeys(strArray[0]);
						Thread.sleep(500);

						//Pressing the Tab Key
						robot.keyPress(KeyEvent.VK_TAB);

						//Releasing the Tab Key
						robot.keyRelease(KeyEvent.VK_TAB);

						Thread.sleep(2000);
						//Pressing the Enter Key
						robot.keyPress(KeyEvent.VK_ENTER);

						//Releasing the Enter Key
						robot.keyRelease(KeyEvent.VK_ENTER);
						//						scenario.log("<b style = \"font-size: 10px;\">Value not accepted and validation message is displayed </b>");

						Thread.sleep(1000);

						//clear the mark column
						Mark.get(4).sendKeys(Keys.CONTROL + "a");
						Mark.get(4).sendKeys(Keys.DELETE);

						// Entering the Internals value
						strArray[1] = String.valueOf(Internal-(Internal+1));

						Mark.get(4).sendKeys(strArray[1]);

						Thread.sleep(500);

						//Pressing the Tab Key
						robot.keyPress(KeyEvent.VK_TAB);

						//Releasing the Tab Key
						robot.keyRelease(KeyEvent.VK_TAB);

						Thread.sleep(1000);
						//Pressing the Enter Key

												robot.keyPress(KeyEvent.VK_ENTER);

						//Releasing the Enter Key
												robot.keyRelease(KeyEvent.VK_ENTER);

						Thread.sleep(1000);

						//enter a valid internal marks
						//						scenario.log("<b style = \"font-size: 10px;\">Entering Internal marks for each student starting with maximum internal marks</b>");

						Mark.get(4).sendKeys(Internalmarks);

						for (int i = 5; i < ((Mark.size())-1); i++) {

							//entering valid internal marks
							//System.out.println(Mark.get(i).getText());
							Mark.get(i).sendKeys(Keys.CONTROL + "a");
							Mark.get(i).sendKeys(Keys.DELETE);
							//Mark.get(i).sendKeys(params.get(i));
							strArray[i] = String.valueOf(Internal-i);
							Mark.get(i).sendKeys(strArray[i]);

						}

						//Click the Save button
						getSaveAttendancebutton().click();
						Thread.sleep(2000);

						MarkAsComplete.click();
//						driver.navigate().refresh();

						Thread.sleep(2000);

						//Pressing the Enter Key
						robot.keyPress(KeyEvent.VK_ENTER);

						//Releasing the Enter Key
						robot.keyRelease(KeyEvent.VK_ENTER);

						Thread.sleep(3000);

						//					   if (l == 1) {
						//						  driver.navigate().back();
						//									}

						//					   List<WebElement> reason = driver.findElements(By.xpath("//label[contains(@id,'reason')]"));
						//					   System.out.println("Reason for Ineligibility: " + reason.size());
						//
						//					   ArrayList<String> expected = new ArrayList<String>(){{
						//					   for (int i = 0; i < ((reason.size())-1); i++) {
						//						    add(IneligibleType[i]);
						//						   }
						//					    }};
						//
						//					   ArrayList<String> actual = new ArrayList<String>()
						//					   {{
						//						  for (int i = 0; i < ((reason.size())-1); i++) {
						//						      System.out.println(reason.get(i).getText());
						//						      //get the reason for ineligibility for all students
						//						      add(reason.get(i).getText());
						//						    }
						//						 }};
						//
						//					   for (int i=0;i<actual.size();i++)
						//						    {
						//						       System.out.println("Validation Message =" + " " + actual.get(i));
						//						    }
						//
						//						System.out.println("expected="+expected);
						//						System.out.println("actual="+actual);
						//
						//						Assert.assertEquals(actual,expected,"incorrect error message or error message is absent");
						//						List<WebElement> eligibility = driver.findElements(By.xpath("//label[contains(@id,'eligibility')]"));
						//
						//						System.out.println("eligibility for exam: " + eligibility.size());

						//						ArrayList<String> expectedEligibility = new ArrayList<String>(){{
						//						for (int i = 0; i < ((eligibility.size())-1); i++) {
						//						             add(EligibleForWrittenExam[i]);
						//						     }
						//						}};
						//
						//						ArrayList<String> actualEligibility = new ArrayList<String>()
						//						     {{
						//						     for (int i = 0; i < ((eligibility.size())-1); i++) {
						//						         	//System.out.println(eligibility.get(i).getText());
						//						         	    	    add(eligibility.get(i).getText());
						//						         }
						//						     }};



						//						System.out.println("expected="+expectedEligibility);
						//						System.out.println("actual="+actualEligibility);
						//
						//						Assert.assertEquals(actualEligibility,expectedEligibility,"incorrect error message or error message is absent");


						//						break internal;
					}else {
						//						            	 break nextrow;
					}

					//	*******************************************************************************************************************



				}
			}
		}

		catch (Exception e) {

			e.printStackTrace();

		}

	}


	public void advisorBatches(String advisorBatch) throws InterruptedException {


		try {

			//Parameters
			List<String> params = new ArrayList<>();
			params = Arrays.asList(advisorBatch.split(",#"));



			Thread.sleep(2000);

			WebElement yearClick = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id=\"academicYearId\"]")));

			Select yeardropdown = new Select(yearClick);

			////passing the Academic year
			yeardropdown.selectByVisibleText(params.get(0));

			Thread.sleep(2000);

			WebElement ProgramClick = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id=\"programId\"]")));

			Select Programdropdown = new Select(ProgramClick);

			////passing the Program
			Programdropdown.selectByVisibleText(params.get(1));

			Thread.sleep(2000);

			WebElement ProgtypeClick = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id=\"programType\"]")));

			Select Progtypedropdown = new Select(ProgtypeClick);

			////passing the Program type
			Progtypedropdown.selectByVisibleText(params.get(2));

			Thread.sleep(2000);

			WebElement SemesterClick = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id=\"semesterId\"]")));

			Select Semesterdropdown = new Select(SemesterClick);

			////passing the Semester
			Semesterdropdown.selectByVisibleText(params.get(3));

			Thread.sleep(2000);


			WebElement BatchClick = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id='registrationAllowedStudentStatus']")));

			Select Batchdropdown = new Select(BatchClick);

			////passing the Batch
			Batchdropdown.selectByVisibleText(params.get(4));

			Thread.sleep(2000);

			WebElement DegreeClick = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id=\"degreeType\"]")));

			Select Degreedropdown = new Select(DegreeClick);

			////passing the Degree
			Degreedropdown.selectByVisibleText(params.get(5));

			Thread.sleep(2000);

			//			WebElement branchClick = wait.until(ExpectedConditions.visibilityOfElementLocated(
			//					By.xpath("//*[@id='batch']")));

			//Select batchdropdown = new Select(branchClick);

			////passing the Academic year
			//batchdropdown.selectByVisibleText(params.get(6));
			Thread.sleep(2000);


			//Click on Search button
			driver.findElement(By.xpath("//*[@id=\"searchForm_search\"]")).click();

			Thread.sleep(2000);

		} catch (Exception e) {

			e.printStackTrace();

		}

		Thread.sleep(1000);
	}



	public void confirmAttendance() throws InterruptedException {


		try {





			//fetching completion status from staff advisor log in
			//			String StaffAdvisor= driver.findElement(By.xpath("//td[text()='Submitted by Faculty']"));

			//			confirmStaffAdvisorId.add(StaffAdvisor);

			//			System.out.println("staff advisor is "+StaffAdvisor);


			List<WebElement> StaffAdvisor = driver.findElements(By.xpath("//td[text()='Submitted by Faculty']"));

			int staffAdvisorlistsize=StaffAdvisor.size();
			System.out.println("staff advisor status size is "+staffAdvisorlistsize);
			for( int i = 0; i< staffAdvisorlistsize;i++)
			{
				//click the view student attendance internal button
				//			WebElement element = driver.findElement(By.xpath("(//td[text()='Submitted by Faculty'])["+(i+1)+"]/following::a[1]"));
				WebElement element = driver.findElement(By.xpath("(//table[@id='programDetail']//tbody//tr["+(i+1)+"]//td[text()='Submitted by Faculty']//following::a[1])"));

				//table[@id='programDetail']//tbody//tr//td[text()='Submitted by Faculty']//following::a[1]
				System.out.println("i is " +i );

				Thread.sleep(3000);
				element.click();
				Thread.sleep(3000);


				ConfirmButton.click();
				//			Submit popu-p button
				Robot robot= new Robot();
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(2000);


			}


			//		confirmStaffAdvisorId.add(StaffAdvisor);




			//
			//			System.out.println("Course"+CourseSize);
			//


			//			Thread.sleep(2000);
			//
			//			for( int i = 0; i< CourseSize;i++)
			//			{
			//				// click the Student Attendance/Internals
			//				EnterCourseCode.clear();
			//				Thread.sleep(100);
			//				EnterCourseCode.sendKeys(courseCodes.get(i));
			//				getSearch().click();
			//
			//
			//				WebElement element = driver.findElement(By.xpath("//*[@id='courseListingTable']/tbody/tr/td[3]"));
			//
			//
			//				System.out.println("The cell value is: " +RetrievedCoursetype.get(i));
			//			}



		}


		catch (Exception e) {

			e.printStackTrace();

		}



	}
	public void AttendanceInternals(String  college) throws InterruptedException {

		//		String status = "";

		try {

			//Parameters
			List<String> params = new ArrayList<>();
			params = Arrays.asList(college.split(",#"));

			Thread.sleep(2000);

			// click the Student Attendance/Internals
			AttendanceInternals.click();

			WebElement yearClick = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id=\"academicYearId\"]")));

			Select yeardropdown = new Select(yearClick);

			////passing the Academic year
			yeardropdown.selectByVisibleText(params.get(0));

			Thread.sleep(2000);

			WebElement ProgramClick = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id=\"programId\"]")));

			Select Programdropdown = new Select(ProgramClick);

			////passing the Program
			Programdropdown.selectByVisibleText(params.get(1));

			Thread.sleep(2000);

			WebElement ProgtypeClick = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id=\"programType\"]")));

			Select Progtypedropdown = new Select(ProgtypeClick);

			////passing the Program type
			Progtypedropdown.selectByVisibleText(params.get(2));

			Thread.sleep(2000);

			WebElement SemesterClick = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id=\"semesterId\"]")));

			Select Semesterdropdown = new Select(SemesterClick);

			////passing the Semester
			Semesterdropdown.selectByVisibleText(params.get(3));

			Thread.sleep(2000);

			WebElement BatchClick = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id='registrationAllowedStudentStatus']")));

			Select Batchdropdown = new Select(BatchClick);

			////passing the Batch
			Batchdropdown.selectByVisibleText(params.get(4));

			Thread.sleep(2000);

			WebElement DegreeClick = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id=\"degreeType\"]")));

			Select Degreedropdown = new Select(DegreeClick);

			////passing the Degree
			Degreedropdown.selectByVisibleText(params.get(5));

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




	public  String  validationMsg() {

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='alert alert-warning']")));
		element.getText();


		return "Your institution's Internals have been submitted for the selected program to the university";

	}

	public void branchSubmit () throws InterruptedException, AWTException{
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"selectAll\"]")));

		element.click();
		BranchListingSubmit.click();

		Thread.sleep(1000);
		Robot robot = new Robot();
		//Pressing the Enter Key
		robot.keyPress(KeyEvent.VK_ENTER);

		//Releasing the Enter Key
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(13000);


	}






}























































































