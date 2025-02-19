package com.ospyn.ktu.view;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ospyn.ktu.test.Login;
import com.ospyn.ktu.test.ParentBranch;
import com.ospyn.ktu.util.SeleniumBase;
import com.ospyn.ktu.util.ViewCommonUtil;


public class ViewBulkRegularExamRegistration extends SeleniumBase {

	Robot robot;
	//BulkRegularRegistration regularRegistration = new BulkRegularRegistration();
	private FileInputStream fs;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
//	ViewCommonUtil CommonUtilView =new ViewCommonUtil(driver);


	public ViewBulkRegularExamRegistration(WebDriver driver)
	{
		//initializing the driver
		super(driver);
		try {
			robot=new Robot();
			fs = new FileInputStream(new File(System.getProperty("user.dir")+"/Test_Data/PARAMETER_LISTING.xlsx"));

			//Getting the workbook
		     workbook = new XSSFWorkbook(fs);

			//Getting the sheet
			sheet = workbook.getSheetAt(4);

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

	public static 	ArrayList<String> RegNumber =new ArrayList<String>();
	public static 	String[] studentData;
	public static   String totalFee;
	public static   String maxCredit;
	public static   String studentBranch;
	public static   HashSet<String> branches = new HashSet<String>();
	public static   ArrayList<String> credits = new ArrayList<String>();
	public static   ArrayList<String> parentBranches = new ArrayList<String>();
	public static int branchPosition;

	public static Object[] getStudentData() {
		return studentData;
	}

	/*The method sudentDetailsSearch is used to filter the
	  students from student details by passing values to
	  fields      */

	public void sudentDetailsSearch() throws AWTException, InterruptedException {

		Thread.sleep(1000);

//		Maximize the window
        driver.manage().window().maximize();
		Thread.sleep(1000);


        //Parameters
		driver.findElement(By.xpath("//a[@href='/university/eu/stu/studentDetailsListing.htm']")).click();
		Thread.sleep(1000);


		WebElement batchYear = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='academicYearId']")));
		Select yeardropdown = new Select(batchYear);
		yeardropdown.selectByVisibleText(sheet.getRow(10).getCell(1).getStringCellValue());

		WebElement program = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='admittedprogramId']")));
		Select programdropdown = new Select(program);
		programdropdown.selectByVisibleText(sheet.getRow(2).getCell(1).getStringCellValue());

		WebElement programType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='programType']")));
		Select prgmTypedropdown = new Select(programType);
		prgmTypedropdown.selectByVisibleText(sheet.getRow(3).getCell(1).getStringCellValue());

		WebElement institutionName=driver.findElement(By.xpath("//*[@id='institution']"));
		institutionName.sendKeys(sheet.getRow(4).getCell(Login.getColumn()).getStringCellValue());
		Thread.sleep(1000);

		//Pressing the Enter Key
		robot.keyPress(KeyEvent.VK_ENTER);

		//Releasing the Enter Key
		robot.keyRelease(KeyEvent.VK_ENTER);

		//	WebElement branchName=driver.findElement(By.xpath("//*[@id='branch']"));
		//	branchName.sendKeys(parameters.get(4));

		Thread.sleep(300);

		//Pressing the Enter Key
//		robot.keyPress(KeyEvent.VK_ENTER);

		//Releasing the Enter Key
//		robot.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(500);
		WebElement studentStatus = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='studentForm_status']")));
		Select studentStatusdropdown = new Select(studentStatus);
		studentStatusdropdown.selectByVisibleText(sheet.getRow(5).getCell(1).getStringCellValue());
		Thread.sleep(1000);

		WebElement search=driver.findElement(By.xpath("//*[@id='studentForm_search']"));
		search.click();
		Thread.sleep(2000);


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
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(1000);


			driver.findElement(By.xpath("//*[text()='"+p+"']")).click();

//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[text()='"+p+"']")));

			List<WebElement> studentlistrow = driver.findElements(By.xpath("(//table[@id='studentTable']/tbody/tr)"));
			int rowlength=studentlistrow.size();


			for(int s=1;s<=rowlength;s++) {

				String fullRegNo= driver.findElement(By.xpath("//*[@id='studentTable']/tbody/tr["+s+"]/td[2]/label[2]")).getText();
				//System.out.println("fullRegNo"+fullRegNo);
				String RegNo = StringUtils.substringAfter(fullRegNo, "Reg No: ");
				System.out.println("RegNo"+RegNo);

				String fullbranch= driver.findElement(By.xpath("//*[@id='studentTable']/tbody/tr["+s+"]/td[3]/span[2]")).getText();
				//System.out.println("fullbranch"+fullbranch);
				String branch = StringUtils.substringAfter(fullbranch, "Branch: ");
				System.out.println("branch"+branch);

				RegNumber.add(RegNo);

				branches.add(branch);

			}
		}

		int a= RegNumber.size();
		System.out.println("RegNumber size "+a);
		studentData=new String[a];
		for(int i=0;i<a;i++) {
			studentData[i]=RegNumber.get(i);
			System.out.println("regNumber"+studentData[i]);
		}

		for (String i : branches) {
			System.out.println("branches of student"+i);
		}


	}
	public void gettingParentBranch() throws Exception {


		Iterator it=branches.iterator();
		while(it.hasNext()) {

			parentBranches.add(ParentBranch.getParentBranchName(it.next()+"","B.Tech","Full Time"));
		}

		System.out.println("parent  "+parentBranches);
		Thread.sleep(500);


	}

	public void readingSemCredits() throws InterruptedException, AWTException {


		WebElement academics = driver.findElement(By.xpath("//*[text()='Academics']"));
		academics.click();
		WebElement examCredit = driver.findElement(By.xpath("//*[text()='Credits/Public Exam Count']"));
		examCredit.click();
		Thread.sleep(1000);

		for(int i=0;i<parentBranches.size();i++)
		{
			//System.out.println(parameters.get(0));
			WebElement cluster = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='orgId']")));
			Select clusterdropdown = new Select(cluster);
			List<WebElement> options=clusterdropdown.getOptions();
			//System.out.println(options.get(2).getText());
			clusterdropdown.selectByVisibleText(sheet.getRow(9).getCell(1).getStringCellValue());

			WebElement program = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='programId']")));
			Select programdropdown = new Select(program);
			programdropdown.selectByVisibleText(sheet.getRow(2).getCell(1).getStringCellValue());

			WebElement scheme = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='schemeId']")));
			Select schemedropdown = new Select(scheme);
			schemedropdown.selectByVisibleText(sheet.getRow(7).getCell(1).getStringCellValue());

			String branchCode=parentBranches.get(i);
			String newString=branchCode.substring(0,branchCode.indexOf("("))+("["+sheet.getRow(3).getCell(1).getStringCellValue()+"]");

			String newStringSub= StringUtils.substringBefore(newString, "[");
			System.out.println(newStringSub);
			WebElement branch = driver.findElement(By.xpath("//*[@id='branch']"));
			branch.sendKeys(newStringSub);
			WebElement branchoptions = driver.findElement(By.xpath("//*[@class='typeahead dropdown-menu']"));

			List<WebElement> branchList = branchoptions.findElements(By.tagName("li"));
			System.out.print("sizeee "+branchList.size());

			for (WebElement element : branchList) {
				//System.out.println(branchList.get(k).getText());
				if(newString.equalsIgnoreCase(element.getText())) {
					element.click();
				}
			}

			WebElement search=driver.findElement(By.xpath("//*[@id='publicExamCountForm_search']"));
			search.click();

			WebElement defineCount=driver.findElement(By.xpath("//*[text()='Define Count']"));
			defineCount.click();

			List<WebElement> creditList = driver.findElements(By.xpath("//*[@id='countTbl']/tbody/tr"));
			System.out.println("credit size"+creditList.size());

			for(int r=1;r<=creditList.size();r++) {

				String semester = driver.findElement(By.xpath("//*[@id='countTbl']/tbody/tr["+(r)+"]/td[1]")).getText();
				//				System.out.println("semester"+semester);
				//				System.out.println("para"+parameters.get(4));
				if(semester.equalsIgnoreCase(sheet.getRow(8).getCell(1).getStringCellValue())) {

					Thread.sleep(500);
					WebElement totalCreditElemt = driver.findElement(By.xpath("//*[@id='countTbl']/tbody/tr["+(r)+"]/td[3]/input"));
					String totalCredit=totalCreditElemt.getAttribute("value");
					credits.add(totalCredit);
					break;
}
}

			WebElement close = driver.findElement(By.xpath("(//*[@class='close'])[8]"));
			close.click();

			driver.findElement(By.xpath("//*[@id='branch']")).clear();

		}
		int a= credits.size();

		for(int i=0;i<a;i++) {

			System.out.println("credit print"+credits.get(i));
		}

	}

	public void getBranch() throws Exception {

		WebElement viewProfile = driver.findElement(By.xpath("(//*[@href='/university/eu/stu/studentDetailsView.htm'])[1]"));
		viewProfile.click();
		Thread.sleep(1000);
		String fullBranchName = driver.findElement(By.xpath("//*[text()='Admitted Branch']/..")).getText();
		List<String> BranchName = new ArrayList<>();
		BranchName = Arrays.asList(fullBranchName.split("\n"));
		System.out.println(BranchName.get(1).trim());


		String[] branchArr = branches.toArray(new String[branches.size()]);

		for(int i=0;i<branchArr.length;i++){
			System.out.println(branchArr[i]);
			if(branchArr[i].equals(BranchName.get(1).trim())) {

				branchPosition= i;
				System.out.println("branchPosition"+branchPosition);
				break;
			}

		}
		System.out.println("credit after checking position"+credits.get(branchPosition));

	}

	/* The method courseSelection is used to select courses from student login */


	public boolean courseSelection1() throws InterruptedException, AWTException {
		//		 Student.click();
		//		 Coursesemexamreg.click();
		//		 Registernewcourses.click();

		Thread.sleep(2000);
		boolean status = false;
		String slot="";
		String totalFee="",semfee="",takenCredit="",remainingCredit="",takenCreditAfterSelect="",remainingCreditAfterSelect="";
		float courseFeefloat=0,fee,courseCreditfloat=0,takenCreditFloat=0,expectedRemainingCredit=0,
		totalFeeFloat=0,remainingCreditFloat=0,takenCreditAfterSelectFloat = 0,expectedTakenCredit=0,remainingCreditAfterselectFloat=0,expectedcourseFee=0,maximumCreditLimitFloat=0;

//		fetching table 1st row
		List<WebElement> courselistrow = driver.findElements(By.xpath("(//table[@id='courseListingTable']/tbody/tr)"));
//		Iterating through table rows and click on check box
		for( int j = 1;j<=courselistrow.size();j++)
		{
//			WebElement element = driver.findElement(By.xpath("(//*[@name='courseBox"+(j)+"'])"));
			WebElement element = driver.findElement(By.xpath("(//*[@name='courseBox'])["+(j)+"]"));

//			IF Check box is already clicked then skip and move to next check box
			if(!(element.isSelected()))
			{

				((RemoteWebDriver) driver).executeScript("arguments[0].click();", element);
				Thread.sleep(700);
			}
		}
//		driver.navigate().refresh();

		Thread.sleep(500);

//		Fetching the maximum credit limit and convert into float
		String CreditLimit= driver.findElement(By.xpath("(//*[@class='profile-title'])[3]")).getText();
		String maximumCreditLimit = StringUtils.substringBefore(CreditLimit, ".");
		maximumCreditLimitFloat = Float.parseFloat(maximumCreditLimit);
		System.out.println("maximumCreditLimit "+maximumCreditLimit);
		System.out.println("maximumCreditLimitfloat "+maximumCreditLimitFloat);



		//fetch the credit taken after selecting a course and convert into float
		takenCreditAfterSelect= driver.findElement(By.xpath("(//*[@class='profile-title'])[4]")).getText();
		takenCreditAfterSelectFloat= Float.parseFloat(takenCreditAfterSelect);
		System.out.println("taken credit after select is "+takenCreditAfterSelectFloat);

//		fetch remaining credit after selecting a course and convert into float
		remainingCreditAfterSelect= driver.findElement(By.xpath("(//*[@class='profile-title'])[5]")).getText();
		remainingCreditAfterselectFloat= Float.parseFloat(remainingCreditAfterSelect);
		System.out.println("remaining credit after select is "+remainingCreditAfterselectFloat);

		//calculating the expected fees
//		expected fees

//		Checking remaining credit is equal to the difference between maximum credit allowed for a semester and credits of course taken
	if((maximumCreditLimitFloat-takenCreditAfterSelectFloat)==remainingCreditAfterselectFloat)
	{

			status = true;

	}
	Thread.sleep(500);

		return status;
	}


	public boolean courseSelection() throws InterruptedException, AWTException {

		//		 Student.click();
		//		 Coursesemexamreg.click();
		//		 Registernewcourses.click();

		Thread.sleep(2000);
		boolean status = false;
		String slot="";
		String totalFee="",semfee="",takenCredit="",remainingCredit="",takenCreditAfterSelect="",remainingCreditAfterSelect="";
		float courseFeefloat=0,fee,courseCreditfloat=0,takenCreditFloat=0,expectedRemainingCredit=0,
		totalFeeFloat=0,remainingCreditFloat=0,takenCreditAfterSelectFloat = 0,expectedTakenCredit=0,remainingCreditAfterselectFloat=0,expectedcourseFee=0;

		String CreditLimit= driver.findElement(By.xpath("(//*[@class='profile-title'])[3]")).getText();
		String maximumCreditLimit = StringUtils.substringBefore(CreditLimit, ".");
		System.out.println("maximumCreditLimit"+maximumCreditLimit);
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
			totalFee = StringUtils.substringAfter(courseFee, "INR");
			courseFeefloat=Float.parseFloat(totalFee);

			//fetch the semester fee and convert it into float
			semfee= driver.findElement(By.xpath("((//div[@class='panel-heading'])[2]//following::label)[1]")).getText();
			fee= Float.parseFloat(semfee);

			Thread.sleep(300);

			//Get the Course Credit and convert into float
			try {
				courseCredit= driver.findElement(By.xpath("(//table[@id='courseListingTable']/tbody/tr["+(j)+"]/td[4])")).getText();
			}
			catch(Exception e) {
				courseCredit= driver.findElement(By.xpath("(//table[@id='courseListingTable']/tbody/tr["+(j)+"]/td[4])")).getText();

			}
			courseCreditfloat=Float.parseFloat(courseCredit);

			System.out.println("course credit float is"+courseCreditfloat);

			//Get the Taken Credit and convert into float
			takenCredit= driver.findElement(By.xpath("(//*[@class='profile-title'])[4]")).getText();
		    takenCreditFloat= Float.parseFloat(takenCredit);
			System.out.println("taken credit is"+takenCreditFloat);

			Thread.sleep(300);

			//Get the remaining Credit and convert into float
			remainingCredit= driver.findElement(By.xpath("(//*[@class='profile-title'])[5]")).getText();
			remainingCreditFloat= Float.parseFloat(remainingCredit);

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
				takenCreditAfterSelect= driver.findElement(By.xpath("(//*[@class='profile-title'])[4]")).getText();
				takenCreditAfterSelectFloat= Float.parseFloat(takenCreditAfterSelect);
				System.out.println("taken credit after select is"+takenCreditAfterSelectFloat);

				//Calculation of expected Credits and comparison
				expectedTakenCredit= courseCreditfloat+takenCreditFloat;

				Thread.sleep(500);

				//Get the remaining Credit after selection and convert into float
				System.out.println("remaining credit float is"+remainingCreditFloat);
				remainingCreditAfterSelect= driver.findElement(By.xpath("(//*[@class='profile-title'])[5]")).getText();
				remainingCreditAfterselectFloat= Float.parseFloat(remainingCreditAfterSelect);
				System.out.println("remaining credit after select is"+remainingCreditAfterselectFloat);

				//Calculation of remaining Credits and comparison
				expectedRemainingCredit= remainingCreditFloat-courseCreditfloat;

				Thread.sleep(500);

				//fetching the total fee and convert into float
				totalFee= driver.findElement(By.xpath("((//div[@class='panel-heading'])[2]//following::label)[1]")).getText();
				totalFeeFloat= Float.parseFloat(totalFee);
				System.out.println("total fee"+totalFeeFloat);

				//calculating the expected fees
				expectedcourseFee= fee+courseFeefloat;
				System.out.println("expected fee"+expectedcourseFee);



			}
			Thread.sleep(800);
		}

		System.out.println("CREDITTTTT"+credits.get(branchPosition));

		if(takenCreditAfterSelectFloat==expectedTakenCredit&&remainingCreditAfterselectFloat==expectedRemainingCredit&&totalFeeFloat==expectedcourseFee&&maximumCreditLimit.equals(maxCredit)&&takenCreditAfterSelect.equals(credits.get(branchPosition)))
		{
			status = true;
		}

		return status;

	}

	/*The method coursesubmissionsuccessvalidation is used ensure
	  the successful submission of registration from student login*/
	public void coursesubmissionsuccessvalidation() {

		String Expected = "My Semesters";

		//Get the Error message and Comparison of error message
		String alertmsg= driver.findElement(By.xpath("//h3[text()='My Semesters']")).getText();
		Assert.assertEquals(alertmsg, Expected);

	}

	/*The method examSearch is used to filter the exam from college login*/

	public void examSearch() throws InterruptedException, AWTException
	{

		Thread.sleep(1000);

		//xpath of the academic year
		WebElement yearClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"academicYearId\"]")));

		Select yeardropdown = new Select(yearClick);

		////passing the Academic year
		yeardropdown.selectByVisibleText(sheet.getRow(1).getCell(1).getStringCellValue());

		//based on exam Definition click on register button
		System.out.println("//*[contains(text(),'"+sheet.getRow(6).getCell(1).getStringCellValue()+"')]/../a[2]");

		WebElement register = driver.findElement(By.xpath("//*[contains(text(),'"+sheet.getRow(6).getCell(1).getStringCellValue()+"')]/../a[2]"));

		register.click();

		Thread.sleep(1000);

	}

	/*The method examSubmission is used to submit registration branch wise*/

	public boolean examSubmission() throws InterruptedException, AWTException {

		boolean status;
		driver.navigate().back();

		//xpath of the academic year
		WebElement yearClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"academicYearId\"]")));
		Select yeardropdown = new Select(yearClick);

		//passing the Academic year
		yeardropdown.selectByVisibleText(sheet.getRow(1).getCell(1).getStringCellValue());

		//based on exam Definition click on register button
		WebElement registerationSubmission = driver.findElement(By.xpath("//*[contains(text(),'"+sheet.getRow(6).getCell(1).getStringCellValue()+"')]/../a[3]"));
		registerationSubmission.click();

		List<WebElement> branchList = driver.findElements(By.xpath("//b[contains(text(),'Branch/Stream')]"));
		int branchCount = branchList.size();
		System.out.println("count"+branchCount);

		for(int i=0;i<branchCount;i++)

		{
			driver.findElement(By.xpath("//input[@id='branch"+i+"']")).click();
		}

//		WebElement submit=driver.findElement(By.xpath("//button[@id='branchListingForm_Submit']"));
		ViewCommonUtil.click("//button[@id='branchListingForm_Submit']");

//		submit.click();

		try
		{

			driver.findElement(By.xpath("//*[@class='alert alert-danger errorStyle col-sm-12']")).isDisplayed();
			status=true;
		}
		catch(Exception e)
		{
			status=false;
		}

		return status;

	}

	public void payNowPayment() {

		WebElement payNow = driver.findElement(By.xpath("//*[@id='now']"));
		payNow.click();
	}

	public String paymentGateway() throws InterruptedException
	{	//checking hdfcbank
		WebElement hdfcBank = driver.findElement(By.xpath("//*[@id='paymentGateWay4']"));
		hdfcBank.click();
		Thread.sleep(300);
		// clicking make payment button
		WebElement makePayment = driver.findElement(By.xpath("//*[@id='submit']"));
		makePayment.click();
		Thread.sleep(3000);


//		//User check payment declaration
//		WebElement element=driver.findElement(By.xpath("//input[@type='checkbox']"));
//		element.click();
//		Thread.sleep(300);
//		//User click on Pay button which is green in colour
//		WebElement element1=driver.findElement(By.xpath("//*[@id='makePaymentForm_makePayment']"));
//		element1.click();
//		Thread.sleep(300);


		//reading payment success message      "Your Payment is successful "
		WebElement paymentMsg= driver.findElement(By.xpath("//*[@class='text-center']"));
		String actualMsg=paymentMsg.getText();
		Thread.sleep(1000);
		//clicking homepage button
		WebElement homePagebtn = driver.findElement(By.xpath("//label[@class='label label-info']"));
		homePagebtn.click();
		return actualMsg;

	}

	public void getMaximumCreditScheme()throws Exception {



		driver.findElement(By.xpath("//*[text()='Academics']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[text()='Schemes']")).click();
		WebElement schemeName= driver.findElement(By.xpath("//*[@id='nameId']"));
		schemeName.sendKeys(sheet.getRow(7).getCell(1).getStringCellValue());
		Thread.sleep(500);
		WebElement schemeSearch= driver.findElement(By.xpath("//*[@id='schemeFilterForm_search']"));
		schemeSearch.click();
		Thread.sleep(1000);
		WebElement schemeView = driver.findElement(By.xpath("//*[@class='btn btn-success btn-xs']"));
		schemeView.click();
		Thread.sleep(1000);
		WebElement maxCreditlink = driver.findElement(By.xpath("//*[@href='#schemeCreditLimit']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", maxCreditlink);

//		maxCreditlink.click();
		Thread.sleep(1000);
		System.out.println(sheet.getRow(1).getCell(1).getStringCellValue());
 		WebElement academicYear = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='creditLimitAcademicYear']")));

		Select yeardropdown = new Select(academicYear);
//		yeardropdown.selectByVisibleText(sheet.getRow(1).getCell(1).getStringCellValue());

		List<WebElement> options=yeardropdown.getOptions();

		int rowlength=0;

		again:
			for(int k=1;k<=options.size();k++) {

				yeardropdown.selectByIndex(k);
				Thread.sleep(1000);
				if(rowlength==0)
				{
					List<WebElement> creditlistrow = driver.findElements(By.xpath("//*[@id='systemRoleDetailsTable']/tbody/tr"));
					rowlength=creditlistrow.size();
				}

				for(int i=1;i<=rowlength;i++)
				{

					String semValue = driver.findElement(By.xpath("//*[@id='systemRoleDetailsTable']/tbody/tr["+i+"]/td[2]")).getText();
					if(semValue.equals(sheet.getRow(8).getCell(1).getStringCellValue())) {
						maxCredit = driver.findElement(By.xpath("//*[@id='systemRoleDetailsTable']/tbody/tr["+i+"]/td[3]")).getText();
						System.out.println("maxCredit"+maxCredit);
						if(maxCredit.equals(""))
						{
							continue again;
						}
						else {
							break again;
						}

					}
				}

			}

	}

	public boolean courseSelectionCollege() throws InterruptedException, AWTException {

		Thread.sleep(2000);
		boolean status = false;
		String slot="";

		String totalFee="",semfee="",takenCredit="",remainingCredit="",takenCreditAfterSelect="",remainingCreditAfterSelect="";
		float courseFeefloat=0,fee,courseCreditfloat=0,takenCreditFloat=0,expectedRemainingCredit=0,
		totalFeeFloat=0,remainingCreditFloat=0,takenCreditAfterSelectFloat = 0,expectedTakenCredit=0,remainingCreditAfterselectFloat=0,expectedcourseFee=0;

		String CreditLimit= driver.findElement(By.xpath("(//*[@class='profile-title'])[3]")).getText();
		String maximumCreditLimit = StringUtils.substringBefore(CreditLimit, ".");
		System.out.println("maximumCreditLimit"+maximumCreditLimit);


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
				if(courseFee.equals("Change Course"))
				{
					courseFee= driver.findElement(By.xpath("(//table[@id='courseListingTable']/tbody/tr["+(j)+"]/td[7])")).getText();

				}
			}
			catch(Exception e)
			{

			}
			totalFee = StringUtils.substringAfter(courseFee, "INR");
			System.out.println(totalFee);
			courseFeefloat=Float.parseFloat(totalFee);

			//fetch the semester fee and convert it into float
			//String semfee= driver.findElement(By.xpath("((//div[@class='panel-heading'])[2]//following::label)[1]")).getText();
			semfee= driver.findElement(By.xpath("(//div[@class='panel-heading']//following::label)[6]")).getText();
			fee= Float.parseFloat(semfee);

			Thread.sleep(300);

			//Get the Course Credit and convert into float
			try {
				courseCredit= driver.findElement(By.xpath("(//table[@id='courseListingTable']/tbody/tr["+(j)+"]/td[4])")).getText();
			}
			catch(Exception e) {
				courseCredit= driver.findElement(By.xpath("(//table[@id='courseListingTable']/tbody/tr["+(j)+"]/td[4])")).getText();

			}
			courseCreditfloat=Float.parseFloat(courseCredit);

			System.out.println("course credit float is"+courseCreditfloat);

			//Get the Taken Credit and convert into float
			takenCredit= driver.findElement(By.xpath("(//*[@class='profile-title'])[4]")).getText();
			takenCreditFloat= Float.parseFloat(takenCredit);
			System.out.println("taken credit is"+takenCreditFloat);

			Thread.sleep(300);

			//Get the remaining Credit and convert into float
			remainingCredit= driver.findElement(By.xpath("(//*[@class='profile-title'])[5]")).getText();
			remainingCreditFloat= Float.parseFloat(remainingCredit);

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
				takenCreditAfterSelect= driver.findElement(By.xpath("(//*[@class='profile-title'])[4]")).getText();
				takenCreditAfterSelectFloat= Float.parseFloat(takenCreditAfterSelect);
				System.out.println("taken credit after select is"+takenCreditAfterSelectFloat);

				//Calculation of expected Credits and comparison
				expectedTakenCredit= courseCreditfloat+takenCreditFloat;

				Thread.sleep(300);

				//Get the remaining Credit after selection and convert into float
				System.out.println("remaining credit float is"+remainingCreditFloat);
				remainingCreditAfterSelect= driver.findElement(By.xpath("(//*[@class='profile-title'])[5]")).getText();
				remainingCreditAfterselectFloat= Float.parseFloat(remainingCreditAfterSelect);
				System.out.println("remaining credit after select is"+remainingCreditAfterselectFloat);

				//Calculation of remaining Credits and comparison
				expectedRemainingCredit= remainingCreditFloat-courseCreditfloat;

				Thread.sleep(300);

				//fetching the total fee and convert into float
				totalFee= driver.findElement(By.xpath("((//div[@class='panel-heading'])[2]//following::label)[1]")).getText();
				totalFeeFloat= Float.parseFloat(totalFee);
				System.out.println("total fee"+totalFeeFloat);

				//calculating the expected fees
				expectedcourseFee= fee+courseFeefloat;
				System.out.println("expected fee"+expectedcourseFee);


			}
			Thread.sleep(300);
		}

		if(takenCreditAfterSelectFloat==expectedTakenCredit&&remainingCreditAfterselectFloat==expectedRemainingCredit&&totalFeeFloat==expectedcourseFee&&maximumCreditLimit.equals(maxCredit))
		{
			status = true;
		}

		return status;

	}

	public void submissionErrorMsg() throws InterruptedException, AWTException {



		boolean status =true;

		Thread.sleep(100);

		String errorMsg=driver.findElement(By.xpath("//*[@class='alert alert-danger errorStyle col-sm-12']")).getText();

		if(errorMsg.contains("students register for this semester's course registration")){

			List<String> errorArr = new ArrayList<>();
			errorArr = Arrays.asList(errorMsg.split(":"));
			List<String> errorStudent = new ArrayList<>();
			errorStudent = Arrays.asList(errorArr.get(1).split(","));
			System.out.println(errorStudent.size());


			driver.navigate().back();
			driver.navigate().back();

			//xpath of the academic year
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement yearClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"academicYearId\"]")));

			Select yeardropdown = new Select(yearClick);

			////passing the Academic year
			yeardropdown.selectByVisibleText(sheet.getRow(1).getCell(1).getStringCellValue());

			//based on exam Definition click on register button
			WebElement register = driver.findElement(By.xpath("//*[contains(text(),'"+sheet.getRow(6).getCell(1).getStringCellValue()+"')]/../a[2]"));
			register.click();

			for (String element : errorStudent) {
				System.out.println(element);
				Thread.sleep(300);
				getStudentbox().sendKeys(element);
				WebElement studtList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='typeahead dropdown-menu']")));
				List<WebElement> studt = studtList.findElements(By.tagName("li"));
				System.out.print("sizeee "+studt.size()+" "+studt.get(0));
				studt.get(0).click();
				//Thread.sleep(500);
				//Pressing the Enter Key
				//robot.keyPress(KeyEvent.VK_ENTER);
				//Releasing the Enter Key
				//robot.keyRelease(KeyEvent.VK_ENTER);

				Thread.sleep(300);
				status=courseSelectionCollege();
				Assert.assertEquals(status, true);
				WebElement feeCollecteVerifiedCheck= driver.findElement(By.xpath("//*[@id=\"feeCollected\"]"));
				feeCollecteVerifiedCheck.click();
			     ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getCollegeSaveButton());

//				getCollegeSaveButton().click();

				robot.keyPress(KeyEvent.VK_ENTER);
				//Releasing the Enter Key
				robot.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(1000);
				getStudentbox().clear();
			}
			//driver.navigate().back();
			//		    examSubmission(params);

		}
		if(errorMsg.contains("has not marked,verified/fee collected")) {

			String error = StringUtils.substringBefore(errorMsg, "has not marked,verified/fee collected");
			System.out.println("error");
			List<String> errorStudent = new ArrayList<>();
			errorStudent = Arrays.asList(error.split(","));
			System.out.println(errorStudent.size());
			System.out.println(errorStudent.size()-1);

			//				List<String> parameters = new ArrayList<>();
			//				parameters = Arrays.asList(params.split(","));

			driver.navigate().back();
			driver.navigate().back();

			//xpath of the academic year
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement yearClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"academicYearId\"]")));


			Select yeardropdown = new Select(yearClick);

			////passing the Academic year
			yeardropdown.selectByVisibleText(sheet.getRow(1).getCell(1).getStringCellValue());

			//based on exam Definition click on register button
			WebElement register = driver.findElement(By.xpath("//*[contains(text(),'"+sheet.getRow(6).getCell(1).getStringCellValue()+"')]/../a[2]"));

			register.click();

			for(int i=0;i<errorStudent.size()-1;i++) {
				System.out.println(errorStudent.get(i));
				Thread.sleep(300);
				getStudentbox().sendKeys(errorStudent.get(i).trim());
				WebElement studtList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='typeahead dropdown-menu']")));
				List<WebElement> studt = studtList.findElements(By.tagName("li"));
				System.out.print("sizeee "+studt.size()+" "+studt.get(0));
				studt.get(0).click();
				//driver.findElement(By.xpath("//*[@role='option']")).click();
				//Thread.sleep(500);
				//Pressing the Enter Key
				//robot.keyPress(KeyEvent.VK_ENTER);
				//Releasing the Enter Key
				//robot.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(500);
				WebElement feeCollecteVerifiedCheck= driver.findElement(By.xpath("//*[@id='feeCollected']"));
				feeCollecteVerifiedCheck.click();
			     ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getCollegeSaveButton());

			     //getCollegeSaveButton().click();
				//Pressing the Enter Key
				robot.keyPress(KeyEvent.VK_ENTER);
				//Releasing the Enter Key
				robot.keyRelease(KeyEvent.VK_ENTER);
				getStudentbox().clear();
			}
			//driver.navigate().back();
			//				bulkRegularRegistrationView.examSubmission(StringList);
			//				click_payNow();
			//				details="Exam registration is submitted";
		}
		//
		//			//click_payNow();

		//
	}


	public void clearall()
	{
		RegNumber.clear();
		branches.clear();
		credits.clear();
		parentBranches.clear();



	}

}


