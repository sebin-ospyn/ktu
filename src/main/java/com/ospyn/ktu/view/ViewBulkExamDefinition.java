package com.ospyn.ktu.view;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ospyn.ktu.util.SeleniumBase;

public class ViewBulkExamDefinition extends SeleniumBase {

	public ViewBulkExamDefinition(WebDriver driver)
	{
		//initializing the driver
		super(driver);
	}

	@FindBy(xpath = "//a[@id='add']")
	WebElement addExamdefinition;

	@FindBy(xpath = "//*[@class='moduleclass']/a[contains(text(),'Exam')]")
	WebElement Exam;

	public static   String examStatus;

	public WebElement getExam() {
		return Exam;
	}

	public void setExam(WebElement exam) {
		Exam = exam;
	}

	public WebElement getAddExamdefinition() {
		return addExamdefinition;
	}

	public void setAddExamdefinition(WebElement addExamdefinition) {
		this.addExamdefinition = addExamdefinition;
	}

	public static int rowSize;
	public static String[] examDetails = new String[100];
	public static int n;
	public static int eventNamecount;
	public static String courseRegValue;
	public static String supplyRegValue;
	public static String examTypeValue;
	LocalDate startExamDate;



	/* The method excelRead is used the read the exam definition
	  values that needs to be entered while creating the definition*/

	public void excelRead() throws IOException {

		FileInputStream fs = new FileInputStream("/home/u1305/eclipse-workspace1/KTU_AutomationTestNG/Test_Data/mtechs3test1.xls");
		//Creating a workbook
		HSSFWorkbook workbook = new HSSFWorkbook(fs);
		HSSFSheet sheet = workbook.getSheetAt(0);

		rowSize = sheet.getLastRowNum();
		//System.out.println("row size "+rowSize);
		int noOfColumns = sheet.getRow(0).getLastCellNum();
		//System.out.println("column size "+noOfColumns);
		for(int i=0;i<=rowSize;i++) {

			for (int j=1;j<noOfColumns;j++) {

				Row row = sheet.getRow(i);
				//System.out.println("row "+row);
				Cell cell = row.getCell(j);
				//System.out.println("cell "+cell);
				// convert any datatypes (int, boolean) to string
				DataFormatter dft = new DataFormatter();
				String value = dft.formatCellValue(cell);
				//System.out.println("value "+value);
				examDetails[i]=value;
				//System.out.println("details are"+examDetails[i]);
			}
		}

		//return examDetails;

	}

	/* The method passValuetoExamdetails is used to locate fields in
	   Examination details and pass values read from excel to these
	   fields */

	public void passValuetoExamdetails() throws InterruptedException {

		n=0;
		//passing value to exam definition name
		WebElement defName = driver.findElement(By.xpath("//*[@id='definitionName']"));
		defName.sendKeys(examDetails[n]);
		System.out.println(n+examDetails[n]);
		n++;
		//passing value to AY
		Select academicYear = new Select(driver.findElement(By.xpath("//*[@id='academicYearId']")));
		academicYear.selectByVisibleText(examDetails[n]);
		System.out.println(n+examDetails[n]);
		n++;
		//passing value to exam month
		Select examMonth = new Select(driver.findElement(By.xpath("//*[@id='examMonth']")));
		examMonth.selectByVisibleText(examDetails[n]);
		System.out.println(n+examDetails[n]);
		n++;
		//passing value to exam year
		Select examYear = new Select(driver.findElement(By.xpath("//*[@id='examYear']")));
		examYear.selectByVisibleText(examDetails[n]);
		System.out.println(n+examDetails[n]);
		n++;
		//passing value to program
		Select program = new Select(driver.findElement(By.xpath("//*[@id='program']")));
		program.selectByVisibleText(examDetails[n]);
		System.out.println(n+examDetails[n]);
		System.out.println("eventName"+examDetails[n]);
		n++;
		//passing value to program type
		Select programType = new Select(driver.findElement(By.xpath("//*[@id='programType']")));
		programType.selectByVisibleText(examDetails[n]);
		System.out.println(n+examDetails[n]);
		n++;
		//passing value to exam type
		Select examType = new Select(driver.findElement(By.xpath("//*[@id='examType']")));
		examType.selectByVisibleText(examDetails[n]);
		System.out.println(n+examDetails[n]);
		n++;
		//passing value to exam type
		Select examMode = new Select(driver.findElement(By.xpath("//*[@id='examDefinitionForm_examMode']")));
		examMode.selectByVisibleText(examDetails[n]);
		System.out.println(n+examDetails[n]);
		n++;
		//passing value to status
		Select status = new Select(driver.findElement(By.xpath("//*[@id='statusId']")));
		status.selectByVisibleText(examDetails[n]);
		System.out.println(n+examDetails[n]);
		n++;
		//passing value to coursemapping academic year
		Select courseMappingAY = new Select(driver.findElement(By.xpath("//*[@id='courseMappingAcademicYearId']")));
		courseMappingAY.selectByVisibleText(examDetails[n]);
		System.out.println(n+examDetails[n]);
		n++;
		//passing value to coursemapping academic year
		Select courseMappingsem = new Select(driver.findElement(By.xpath("//*[@id='courseMappingSemesterId']")));
		courseMappingsem.selectByVisibleText(examDetails[n]);
		System.out.println(n+examDetails[n]);
		n++;
		//passing value to financial year
		Select financialYear = new Select(driver.findElement(By.xpath("//*[@id='financialYearId']")));
		financialYear.selectByVisibleText(examDetails[n]);
		System.out.println(n+examDetails[n]);
		n++;
		//passing value to financial year
		Select examScheme = new Select(driver.findElement(By.xpath("//*[@id='examScheme']")));
		examScheme.selectByVisibleText(examDetails[n]);
		System.out.println(n+examDetails[n]);
		//System.out.println("i count "+n);

		//clicking the save button
		WebElement saveButton= driver.findElement(By.xpath("//*[@id='examDefinitionForm_save']"));
		saveButton.click();

		examTypeValue = driver.findElement(By.xpath("(//*[@id='main-div']//..//div)[6]")).getText();
		System.out.println("examTypeValue"+examTypeValue);

		Thread.sleep(500);
	}


	/* The method passValuetoExamsem is used to locate fields in
	   Exam Semesters and pass values read from excel to these
	   fields */

	public void passValuetoExamsem() throws InterruptedException {


		n++;
		//clicking the link exam semesters
		WebElement semDetails=driver.findElement(By.xpath("//*[@href='#semesterDetails']"));
		Thread.sleep(1000);
		semDetails.click();
		Thread.sleep(1000);

		//clicking the add button
		WebElement addexamSem=driver.findElement(By.xpath("//*[@id='semesterDetails']/div/a"));
		Thread.sleep(1000);
		addexamSem.click();
		Thread.sleep(1000);
		//selecting the required semester
		Select examSemester = new Select(driver.findElement(By.xpath("//*[@id='semesterId0']")));
		examSemester.selectByVisibleText(examDetails[n]);
		System.out.println(n+examDetails[n]);
		n++;
		//System.out.println("value of i "+examDetails[n]);
		System.out.println(n+examDetails[n]);
		//checking course registration allowed only if value in excel is Yes
		if(examDetails[n].contentEquals("Yes")) {
			WebElement registrationAllowed=driver.findElement(By.xpath("//*[@id='courseRegAllowed0']"));
			registrationAllowed.click();
		}
		n++;
		//System.out.println("value of n "+examDetails[i]);
		//checking supplementary course registration allowed only if value in excel is Yes
		if(examDetails[n].contentEquals("Yes")) {
			WebElement supplyRegAllowed=driver.findElement(By.xpath("//*[@id='supplyRegAllowed0']"));
			supplyRegAllowed.click();
		}
		//clicking the save button
		driver.findElement(By.xpath("(//*[@id='submit'])[2]")).click();
		//System.out.println("value of n sem"+n);
		//clicking the exam semesters to read the values of course reg and supplementary registration
		driver.navigate().refresh();
		Thread.sleep(1000);
		semDetails=driver.findElement(By.xpath("//*[@href='#semesterDetails']"));
		semDetails.click();
		courseRegValue = driver.findElement(By.xpath("(//*[@id='mytable']/tbody/tr/td[2])[1]")).getText();
		supplyRegValue = driver.findElement(By.xpath("(//*[@id='mytable']/tbody/tr/td[3])[1]")).getText();
		Thread.sleep(1000);
		System.out.println(n+examDetails[n]);
	}

	/* The method passValuetoFeedetails is used to locate fields in
	   Fee details and pass values read from excel to these
	   fields */

	public void passValuetoFeedetails() throws InterruptedException {

		driver.navigate().refresh();
		Thread.sleep(1000);
		n++;
		//System.out.println("value of n fee"+n);
		//int i=16;
		//clicking the link fee details
		WebElement feeDetails=driver.findElement(By.xpath("//*[@href='#feeDetails']"));
		feeDetails.click();
		//clicking the add button
		WebElement addexamfee=driver.findElement(By.xpath("//*[@id='feeDetails']/div/a"));
		addexamfee.click();
		//adding semester fee
		if(examTypeValue.contains("End Semester")||examTypeValue.contains("Supplementary")) {
			WebElement semFee=driver.findElement(By.xpath("//*[@id='semesterFee']"));
			semFee.clear();
			semFee.sendKeys(examDetails[n]);
		}
		System.out.println(n+examDetails[n]);
		n++;
		//adding course fee
		WebElement courseFee=driver.findElement(By.xpath("//*[@id='courseFee']"));
		courseFee.clear();
		courseFee.sendKeys(examDetails[n]);
		System.out.println(n+examDetails[n]);
		n++;
		//adding fee retained by college
		WebElement feeRetained=driver.findElement(By.xpath("//*[@id='feeRetainedByCollege']"));
		feeRetained.clear();
		feeRetained.sendKeys(examDetails[n]);
		driver.findElement(By.xpath("(//*[@id='submit'])[1]")).click();
		System.out.println(n+examDetails[n]);

	}

	/* The method passValuetoExamregDetails is used to locate fields in
	   exam registration details and pass values read from excel to these
	   fields */

	public void passValuetoExamregDetails() throws AWTException, InterruptedException {

		Robot robot=new Robot();
		n++;
		// n=19;
		driver.navigate().refresh();
		Thread.sleep(1000);
		//click exam reg details link
		WebElement examRegDetails=driver.findElement(By.xpath("//*[@href='#examRegistDetails']"));
		examRegDetails.click();
		//click open registration button
		WebElement openReg=driver.findElement(By.xpath("//*[@id='examRegistDetails']/div/a"));
		openReg.click();
		//entering event name
		WebElement eventName=driver.findElement(By.xpath("//*[@id='name']"));
		eventName.sendKeys(examDetails[n]);
		System.out.println(n+examDetails[n]);
		eventNamecount=n;
		n++;
		System.out.println(n+examDetails[n]);
		Thread.sleep(1000);
		//selecting registration type
		Select registrationType = new Select(driver.findElement(By.xpath("//*[@id='registrationTypeId']")));

		List<WebElement> options=registrationType.getOptions();
		System.out.println(examDetails[n].trim());
		System.out.println(options.get(1).getText());

		registrationType.selectByVisibleText(examDetails[n].trim());
		//entering from date
		WebElement regFromDate=driver.findElement(By.xpath("//*[@id='examRegistFromDate']"));
		String europeanDatePattern = "dd-MM-yyyy";
		DateTimeFormatter europeanDateFormatter;
		europeanDateFormatter= DateTimeFormatter.ofPattern(europeanDatePattern);
        startExamDate = LocalDate.now();
		regFromDate.sendKeys(europeanDateFormatter.format(startExamDate));
		Thread.sleep(1000);
		//Pressing the Enter Key
		robot.keyPress(KeyEvent.VK_ENTER);
		//Releasing the Enter Key
		robot.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(1000);
		//entering To Date
		WebElement regToDate=driver.findElement(By.xpath("//*[@id='examRegistToDate']"));

		//Pressing the Enter Key
		startExamDate=LocalDate.now().plusDays(15);
		regToDate.sendKeys(europeanDateFormatter.format(startExamDate));
		Thread.sleep(1000);
		//Pressing the Enter Key
		robot.keyPress(KeyEvent.VK_ENTER);
		//Releasing the Enter Key
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		n++;
		System.out.println("value of nn"+examDetails[n]);
		//entering additional days
		WebElement regAddDate=driver.findElement(By.xpath("//*[@id='additionalDateForCollegeReg']"));
		regAddDate.clear();
		regAddDate.sendKeys(examDetails[n]);
		//checking supply registration only if course and supply registration is checked
		if(courseRegValue.contentEquals("YES")&&supplyRegValue.contentEquals("YES")) {
			WebElement supplyAllowed=driver.findElement(By.xpath("//*[@id='supplyAllowed']"));
			supplyAllowed.click();
		}

		Thread.sleep(1000);
        //checking course registration allowed
		if(courseRegValue.contentEquals("YES")) {
			WebElement courseRegAllowed=driver.findElement(By.xpath("//*[@id='courseRegAllowed']"));
			courseRegAllowed.click();
		}
//		Thread.sleep(1000);
//		n++;
//		System.out.println("value of n1"+examDetails[n]);
//		if(examDetails[n].contentEquals("yes")) {
//			WebElement contactClassRegistrationAllowed=driver.findElement(By.xpath("//*[@id='contactClassRegistrationAllowed']"));
//			contactClassRegistrationAllowed.click();
//		}
//		Thread.sleep(1000);
		n++;
		System.out.println("value of n2"+examDetails[n]);
		//checking fee required
		if(examDetails[n].contentEquals("yes")) {
			WebElement isFeeCheckRequiredForHallTicket=driver.findElement(By.xpath("//*[@id='isFeeCheckRequiredForHallTicket']"));
			isFeeCheckRequiredForHallTicket.click();
		}
		//clicking save button
		driver.findElement(By.xpath("//*[@id='saveRegist']")).click();

	}

	/* The method registAllowedcourses is used to locate fields in
	   registration allowed courses and pass values read from excel
	   to these fields */

	public void registAllowedcourses() throws InterruptedException, AWTException {

		Thread.sleep(1000);
		driver.navigate().refresh();
		WebElement allowedCourses=driver.findElement(By.xpath("//*[@href='#registeredCourses']"));
		allowedCourses.click();
		Select allowedcourseEvent= new Select(driver.findElement(By.xpath("//*[@id='specificEventId']")));
		allowedcourseEvent.selectByVisibleText(examDetails[eventNamecount]);
		//allowedcourseEvent.selectByVisibleText(examDetails[19]);
		WebElement viewDoMore=driver.findElement(By.xpath("//*[@id='courseDiv']/a"));
		viewDoMore.click();
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		WebDriverWait wait=new WebDriverWait(driver, 20);
		WebElement selectAll=driver.findElement(By.xpath("//*[@id='registrationCourseTable']/thead/tr/th[6]/input"));
		//selectAll.click();
		wait.until(ExpectedConditions.elementToBeClickable(selectAll)).click();
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		//Releasing the Enter Key
		robot.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		WebElement allowedCourseSave=driver.findElement(By.xpath("//*[@id='submit' and @value='Save']"));
		//Actions act =  new Actions(driver);
		//act.moveToElement(driver.findElement(By.xpath("//*[@id='regAllowedForm']/following-sibling::button"))).click().perform();
		//act.moveToElement(allowedCourseSave).click().perform();
		//allowedCourseSave.click();
		wait.until(ExpectedConditions.elementToBeClickable(allowedCourseSave)).click();
		Thread.sleep(2000);
		driver.switchTo().parentFrame();
		WebElement allowedCoursePopupclose=driver.findElement(By.xpath("//*[@class='fancybox-item fancybox-close']"));
		allowedCoursePopupclose.click();
		Thread.sleep(2000);
	}

	/* The method moderationDetails is used to locate fields in
	   moderation details and pass values read from excel to
	   these fields */

	public void moderationDetails() throws InterruptedException {

		/*WebElement examName = driver.findElement(By.xpath("//*[@id='searchForm_definitionName']"));
	    examName.sendKeys("Btech s6 (S) test");
	    WebElement search = driver.findElement(By.xpath("//*[@id='searchForm_search']"));
	    search.click();
	    WebElement view = driver.findElement(By.xpath("(//*[@class='btn btn-warning btn-xs'])[1]"));
	    view.click();   */
		driver.navigate().refresh();
		WebElement moderationTab = driver.findElement(By.xpath("//*[@href='#moderationDetails']"));
		moderationTab.click();
		WebElement moderationAdd = driver.findElement(By.xpath("(//*[ @id='modAddDetails']//..//a)[1]"));
		moderationAdd.click();

		WebElement moderationProfile = driver.findElement(By.xpath("//*[@id='moderationTypeId']"));
		Select profile = new Select(moderationProfile);
		profile.selectByVisibleText("Course-wise Moderation");

		WebElement moderationSave = driver.findElement(By.xpath("//*[ @id='moderationSubmit']"));
		moderationSave.click();

		Thread.sleep(500);
	}

	/*The method approveExamDefinition is used to
	  Approve exam definition*/

	public String approveExamDefinition() {


		WebElement examDefSubmit = driver.findElement(By.xpath("//button[@id='examDefForm_submit']"));
		examDefSubmit.click();

		WebElement confirm=driver.findElement(By.xpath("(//button[@id='confirm'])[2]"));
		confirm.click();

		WebElement examDefVerify =driver.findElement(By.xpath("//button[@id='examDefForm_verify']"));
		examDefVerify.click();

		WebElement confirmVerify=driver.findElement(By.xpath("(//button[@id='confirm'])[2]"));
		confirmVerify.click();

		WebElement examDefApprove = driver.findElement(By.xpath("//button[@id='examDefForm_approve']"));
		examDefApprove.click();

		WebElement confirmApprove=driver.findElement(By.xpath("(//button[@id='confirm'])[2]"));
		confirmApprove.click();

		examStatus= driver.findElement(By.xpath("//*[@id='examDefintionDetails']//*[contains(text(),'Approved')]")).getText();

		return examStatus;
		//logout.click();
	}


}
