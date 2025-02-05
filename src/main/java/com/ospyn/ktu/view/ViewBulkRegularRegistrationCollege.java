package com.ospyn.ktu.view;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.ospyn.ktu.util.SeleniumBase;


public class ViewBulkRegularRegistrationCollege extends SeleniumBase {

	Robot robot;

	public ViewBulkRegularRegistrationCollege(WebDriver driver)
	{
		//initializing the driver
		super(driver);
		try {
			robot=new Robot();
		}
		catch(Exception e) {

		}
	}
 //---------------------------------------------------------------------------------------------------------//
	//Initializing WebElements
	@FindBy(xpath = "//a[@href='/university/logout.htm']")
	WebElement Logout;

	@FindBy(xpath = "//a[@href='/university/eu/stu/studentBasicProfile.htm' and text()='Student']")

	WebElement Student;

	@FindBy(xpath = "//a[@href='/university/eu/acd/studentSemesterListing.htm']")
	WebElement Coursesemexamreg;

	@FindBy(xpath = "//a[@class='btn btn-info pull-right btn-xs']")
	WebElement Registernewcourses;

	@FindBy(xpath = "//button[@name='save']")
	WebElement savebutton;

	@FindBy(xpath = "//button[@name='submit']")
	WebElement submitbutton;

//	@FindBy(xpath = "//*[@href='/university/eu/exm/courseRegistrationInvitation.htm']")
//	WebElement collegeExamModule;

	@FindBy(xpath = "//*[text()='Exam']")
	WebElement collegeExamModule;

	@FindBy(xpath = "//*[@id='student']")
	WebElement studentbox;

	@FindBy(xpath = "//button[@name='save']")
	WebElement collegeSaveButton;

//--------------------------------------------------------------------------------------------------------//

	/*creating setters and generators for WebElements*/

	public WebElement getCollegeSaveButton() {
		return collegeSaveButton;
	}

	public void setCollegeSaveButton(WebElement collegeSaveButton) {
		this.collegeSaveButton = collegeSaveButton;
	}

	public WebElement getStudentbox() {
		return studentbox;
	}

	public void setStudentbox(WebElement studentbox) {
		this.studentbox = studentbox;
	}

	public WebElement getCollegeExamModule() {
		return collegeExamModule;
	}

	public void setCollegeExamModule(WebElement collegeExamModule) {
		this.collegeExamModule = collegeExamModule;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}

	public void setSavebutton(WebElement savebutton) {
		this.savebutton = savebutton;
	}

	public WebElement getSubmitbutton() {
		return submitbutton;
	}

	public void setSubmitbutton(WebElement submitbutton) {
		this.submitbutton = submitbutton;
	}

	public WebElement getRegisternewcourses() {
		return Registernewcourses;
	}

	public void setRegisternewcourses(WebElement registernewcourses) {
		Registernewcourses = registernewcourses;
	}

	public WebElement getLogout() {
		return Logout;
	}

	public void setLogout(WebElement logout) {
		Logout = logout;
	}

	public WebElement getStudent() {
		return Student;
	}

	public void setStudent(WebElement student) {
		Student = student;
	}

	public WebElement getCoursesemexamreg() {
		return Coursesemexamreg;
	}

	public void setCoursesemexamreg(WebElement coursesemexamreg) {
		Coursesemexamreg = coursesemexamreg;
	}

//---------------------------------------------------------------------------------------------------------//

	public static ArrayList<String> RegNumber =new ArrayList<String>();
	static String[] studentData;
	public static   String totalFee;
	public static   String maxCredit;
	public static   String studentBranch;
	public static   HashSet<String> branches = new HashSet<String>();
	public static   ArrayList<Integer> credits = new ArrayList<Integer>();

	public static Object[] getStudentData() {
		return studentData;
	}

	/*The method sudentDetailsSearch is used to filter the
	  students from student details by passing values to
	  fields      */

	public void sudentDetailsSearch(String params) throws AWTException, InterruptedException {

		//Parameters
		List<String> parameters = new ArrayList<>();
		parameters = Arrays.asList(params.split(","));

		driver.findElement(By.xpath("//a[@href='/university/eu/stu/studentDetailsListing.htm']")).click();

		WebElement batchYear = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='academicYearId']")));
		Select yeardropdown = new Select(batchYear);
		yeardropdown.selectByVisibleText(parameters.get(0));

		WebElement program = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='admittedprogramId']")));
		Select programdropdown = new Select(program);
		programdropdown.selectByVisibleText(parameters.get(1));

		WebElement programType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='programType']")));
		Select prgmTypedropdown = new Select(programType);
		prgmTypedropdown.selectByVisibleText(parameters.get(2));

		WebElement institutionName=driver.findElement(By.xpath("//*[@id='institution']"));
		institutionName.sendKeys(parameters.get(3));

		Thread.sleep(300);

		//Pressing the Enter Key
		robot.keyPress(KeyEvent.VK_ENTER);

		//Releasing the Enter Key
		robot.keyRelease(KeyEvent.VK_ENTER);


		Thread.sleep(500);

		WebElement studentStatus = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='studentForm_status']")));
		Select studentStatusdropdown = new Select(studentStatus);
		studentStatusdropdown.selectByVisibleText(parameters.get(4));

		WebElement branchName=driver.findElement(By.xpath("//*[@id='branch']"));
		branchName.sendKeys(parameters.get(5));

		Thread.sleep(300);

		//Pressing the Enter Key
		robot.keyPress(KeyEvent.VK_ENTER);

		//Releasing the Enter Key
		robot.keyRelease(KeyEvent.VK_ENTER);


		WebElement search=driver.findElement(By.xpath("//*[@id='studentForm_search']"));
		search.click();

	}

	/*The method readingStudentRegisterNumber is used to read the students
	 * from student details and store them in ArrayList */

	public void readingStudentRegisterNumber() throws InterruptedException, IOException {

		String recordMessage = driver.findElement(By.xpath("//*[@class='pagebanner']")).getText();
		System.out.println("recordMessage "+recordMessage);
		String arr[] = recordMessage.split(" ");
		int arrSize = arr.length;
		System.out.println("arrSize"+arrSize);
		String firstWord = arr[0];
		String lastWord = arr[arrSize-1];
		lastWord=lastWord.substring(0,lastWord.length()-1);
		System.out.println("lastWord"+lastWord);

		int firstWordValue=Integer.parseInt(firstWord);
		int lastWordValue=Integer.parseInt(lastWord);
		float lastRecord =(float)firstWordValue/lastWordValue;
		int lastRecordValue =(int) Math.ceil(lastRecord);
		System.out.println("lastRecordValue"+lastRecordValue);

		for(int p=1;p<=lastRecordValue;p++) {

			Thread.sleep(1000);

			driver.findElement(By.xpath("//*[text()='"+p+"']")).click();

			List<WebElement> studentlistrow = driver.findElements(By.xpath("(//table[@id='studentTable']/tbody/tr)"));
			int rowlength=studentlistrow.size();


			for(int s=1;s<=rowlength;s++) {

				String fullRegNo= driver.findElement(By.xpath("//*[@id='studentTable']/tbody/tr["+s+"]/td[2]/label[2]")).getText();
				System.out.println("fullRegNo"+fullRegNo);
				String RegNo = StringUtils.substringAfter(fullRegNo, "Reg No: ");
				System.out.println("RegNo"+RegNo);

				String fullbranch= driver.findElement(By.xpath("//*[@id='studentTable']/tbody/tr["+s+"]/td[3]/span[2]")).getText();
				System.out.println("fullbranch"+fullbranch);
				String branch = StringUtils.substringAfter(fullbranch, "Branch: ");
				System.out.println("branch"+branch);

                RegNumber.add(RegNo);

                branches.add(branch);

			}
		}

		int a= RegNumber.size();
		studentData=new String[a];
		for(int i=0;i<a;i++) {
			studentData[i]=RegNumber.get(i);
			System.out.println("regNumber"+studentData[i]);
		}

		for (String i : branches) {
			  System.out.println("branches of student"+i);
			}


	}



	/* The method courseSelection is used to select courses from student login */

	public boolean courseSelection() throws InterruptedException, AWTException {

		Thread.sleep(2000);
		boolean status = false;
		String slot="";


		//xpath of the rows in the table
		List<WebElement> courselistrow = driver.findElements(By.xpath("(//table[@id='courseListingTable']/tbody/tr)"));

		// Iterate through the all check boxes and click it
		for( int j = 1; j<= courselistrow.size();j++) {

			Thread.sleep(300);
			String courseFee="";
			String courseCredit="";

			//fetch the course fee and convert it into float
			try
			{
				courseFee= driver.findElement(By.xpath("(//table[@id='courseListingTable']/tbody/tr["+(j)+"]/td[8])")).getText();
			}
			catch(Exception e)
			{
				courseFee= driver.findElement(By.xpath("(//table[@id='courseListingTable']/tbody/tr["+(j)+"]/td[7])")).getText();

			}
			String totalFee = StringUtils.substringAfter(courseFee, "INR");
			float courseFeefloat=Float.parseFloat(totalFee);

			//fetch the semester fee and convert it into float
			//String semfee= driver.findElement(By.xpath("((//div[@class='panel-heading'])[2]//following::label)[1]")).getText();
			String semfee= driver.findElement(By.xpath("(//div[@class='panel-heading']//following::label)[6]")).getText();
			float fee= Float.parseFloat(semfee);

			Thread.sleep(300);

			//Get the Course Credit and convert into float
			try {
				courseCredit= driver.findElement(By.xpath("(//table[@id='courseListingTable']/tbody/tr["+(j)+"]/td[4])")).getText();
			}
			catch(Exception e) {
				courseCredit= driver.findElement(By.xpath("(//table[@id='courseListingTable']/tbody/tr["+(j)+"]/td[4])")).getText();

			}
			float courseCreditfloat=Float.parseFloat(courseCredit);

			System.out.println("course credit float is"+courseCreditfloat);

			//Get the Taken Credit and convert into float
			String takenCredit= driver.findElement(By.xpath("(//*[@class='profile-title'])[4]")).getText();
			float takenCreditFloat= Float.parseFloat(takenCredit);
			System.out.println("taken credit is"+takenCreditFloat);

			Thread.sleep(300);

			//Get the remaining Credit and convert into float
			String remainingCredit= driver.findElement(By.xpath("(//*[@class='profile-title'])[5]")).getText();
			float remainingCreditFloat= Float.parseFloat(remainingCredit);

			//getting the slot of each course
			String slot1 = driver.findElement(By.xpath("(//*[@id='courseBox"+(j)+"'])")).getAttribute("data-slot");
			String slotName = slot1.substring(0,1);

			Thread.sleep(300);

			//if the name of the slot is not the previous slotName the execute the following loop
			if(!slot.equals(slotName))
			{
				//select the course
				WebElement element = driver.findElement(By.xpath("(//*[@id='courseBox"+(j)+"'])"));
				((RemoteWebDriver) driver).executeScript("arguments[0].click();", element);

				//setting the slot as current slotName
				slot=slotName;

				Thread.sleep(300);

				//fetch the taken after selecting a course and convert into float
				String takenCreditAfterSelect= driver.findElement(By.xpath("(//*[@class='profile-title'])[4]")).getText();
				float takenCreditAfterSelectFloat= Float.parseFloat(takenCreditAfterSelect);
				System.out.println("taken credit after select is"+takenCreditAfterSelectFloat);

				//Calculation of expected Credits and comparison
				float expectedTakenCredit= courseCreditfloat+takenCreditFloat;

				Thread.sleep(300);

				//Get the remaining Credit after selection and convert into float
				System.out.println("remaining credit float is"+remainingCreditFloat);
				String remainingCreditAfterSelect= driver.findElement(By.xpath("(//*[@class='profile-title'])[5]")).getText();
				float remainingCreditAfterselectFloat= Float.parseFloat(remainingCreditAfterSelect);
				System.out.println("remaining credit after select is"+remainingCreditAfterselectFloat);

				//Calculation of remaining Credits and comparison
				float expectedRemainingCredit= remainingCreditFloat-courseCreditfloat;

				Thread.sleep(300);

				//fetching the total fee and convert into float
				totalFee= driver.findElement(By.xpath("((//div[@class='panel-heading'])[2]//following::label)[1]")).getText();
				float totalFeeFloat= Float.parseFloat(totalFee);
				System.out.println("total fee"+totalFeeFloat);

				//calculating the expected fees
				float expectedcourseFee= fee+courseFeefloat;
				System.out.println("expected fee"+expectedcourseFee);

				if(takenCreditAfterSelectFloat==expectedTakenCredit&&remainingCreditAfterselectFloat==expectedRemainingCredit&&totalFeeFloat==expectedcourseFee)
				{
					status = true;
				}

			}
			Thread.sleep(300);
		}

		return status;

	}


	/*The method examSearch is used to filter the exam from college login*/

	public void examSearch(String params ) throws InterruptedException, AWTException {


		List<String> parameters = new ArrayList<>();
		parameters = Arrays.asList(params.split(","));

		Thread.sleep(1000);

		//xpath of the academic year
		WebElement yearClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"academicYearId\"]")));

		Select yeardropdown = new Select(yearClick);

		////passing the Academic year
		yeardropdown.selectByVisibleText(parameters.get(0));

		//based on exam Definition click on register button
		WebElement register = driver.findElement(By.xpath("//*[contains(text(),'"+parameters.get(1)+"')]/../a[2]"));

		register.click();

	}

	/*The method examSubmission is used to submit registration branch wise*/

	public void examSubmission(String params ) throws InterruptedException, AWTException {


		List<String> parameters = new ArrayList<>();
		parameters = Arrays.asList(params.split(","));

		driver.navigate().back();

		//xpath of the academic year
		WebElement yearClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"academicYearId\"]")));

		Select yeardropdown = new Select(yearClick);

		////passing the Academic year
		yeardropdown.selectByVisibleText(parameters.get(0));

		//based on exam Definition click on register button
		WebElement registerationSubmission = driver.findElement(By.xpath("//*[contains(text(),'"+parameters.get(1)+"')]/../a[3]"));

		registerationSubmission.click();

		List<WebElement> branchList = driver.findElements(By.xpath("//b[contains(text(),'Branch/Stream')]"));

		int branchCount = branchList.size();
		System.out.println("count"+branchCount);

		for(int i=0;i<branchCount;i++)

		{
			driver.findElement(By.xpath("//input[@id='branch"+i+"']")).click();
		}

		WebElement submit=driver.findElement(By.xpath("//button[@id='branchListingForm_Submit']"));
        submit.click();
	}

public void payNowPayment() {

		WebElement payNow = driver.findElement(By.xpath("//*[@id='now']"));
		payNow.click();
	}

	public String paymentGateway() throws InterruptedException
	{	//checking hdfcbank
		WebElement hdfcBank = driver.findElement(By.xpath("//*[@id='paymentGateWay4']"));
		hdfcBank.click();
		// clicking make payment button
		WebElement makePayment = driver.findElement(By.xpath("//*[@id='submit']"));
		makePayment.click();
		//reading payment success message      "Your Payment is successful "
		WebElement paymentMsg= driver.findElement(By.xpath("//*[@class='text-center']"));
		String actualMsg=paymentMsg.getText();

		Thread.sleep(1000);
		//clicking homepage button
		WebElement homePagebtn = driver.findElement(By.xpath("//label[@class='label label-info']"));
		homePagebtn.click();

		return actualMsg;

	}


}


