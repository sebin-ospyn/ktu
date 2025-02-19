package com.ospyn.ktu.view;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.ospyn.ktu.util.SeleniumBase;
import com.ospyn.ktu.util.ViewCommonUtil;

public class ViewFirstLevelValuation extends SeleniumBase {


	public static  String  branch;
	String status="";
	Robot robot;
	static WebElement element;
	int params=5;

	static ArrayList<String> packetCodes;
	static ArrayList<String> falsenumber;
	//ViewCommonUtil ViewCommonUtil = new ViewCommonUtil(driver);

	public ViewFirstLevelValuation(WebDriver driver)throws Exception {

		super(driver);
		robot = new Robot();
		ViewCommonUtil.readFromExcel("PARAMETER_LISTING.xlsx","FirstLevelValuation");
		packetCodes=new ArrayList<String>();
		falsenumber=new ArrayList<String>();
	}

	@FindBy(xpath = "//a[text()='Valuation Camp']")
	WebElement valuationcamp;
	@FindBy(xpath = "//a[@id='add']")
	WebElement add;
	@FindBy(xpath = "//a[text()='Prepare Packets']")
	WebElement preparepackets;
	@FindBy(xpath = "//a[text()='Post Faculty Members']")
	WebElement postfacultymember;
	@FindBy(xpath = "//a[text()='Assigned Courses']")
	WebElement assignedcourses;


	public WebElement getAssignedcourses() {
		return assignedcourses;
	}

	public void ValuationTab() throws InterruptedException {
		ViewCommonUtil.click("//a[text()='Valuation']");
		Thread.sleep(1000);

	}

	public WebElement getPreparepackets() {
		return preparepackets;
	}

	public WebElement valuationcamp() {
		return valuationcamp;
	}

	public WebElement clickaddbutton() {
		return add;
	}
	public void addvaluationcamp(String campdetails)throws Exception
	{
		List<String> params= new ArrayList<>();
		params = Arrays.asList(campdetails.split(","));

		Thread.sleep(2000);
		WebElement program = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//select[@id='programId']")));

		Select dropdown = new Select(program);

		////passing the Program
		dropdown.selectByVisibleText(params.get(0));

		Thread.sleep(2000);

	}
	public void robotkeys(){
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}
	public void packetpreparation()throws Exception
	{
		try {

			//Passing academic year
			ViewCommonUtil.selectDropDownItem("Academic year","//*[@id='academicYearId']");

			//Passing program
			ViewCommonUtil.selectDropDownItem("Program","//select[@id='programId']");

			//Passing exam definition
			ViewCommonUtil.selectDropDownItem("Exam Definition","//select[@id='examDefinitionId']");

			//passing the valuation camp
			ViewCommonUtil.selectDropDownItem("Valuation Camp","//select[@id='valCampid']");

			//passing the Institution name
			ViewCommonUtil.enterTextinTextField("Institution","//input[@id='institution']");
			robotkeys();

			//passing the course code(After splitting)
			ViewCommonUtil.splitAndEnter("Course","//input[@id='course']",0);
			Thread.sleep(1750);

			//Selecting degree type
			ViewCommonUtil.selectDropDownItem("Degree Type","//select[@id='searchForm_examDegreeType']");


		}
		catch(Exception e) {
			e.printStackTrace();

		}

	}

	public void createorviewpackets() throws InterruptedException {

		ViewCommonUtil.click("//button[@id='searchForm_createPackets']");
		findRows();
		Thread.sleep(1500);
	}


	public void clicksaveorverify() throws InterruptedException {
		ViewCommonUtil.click("//button[@id='searchForm_submit']");
	}

	//To find number of packets
	public void findRows()
	{

		List<WebElement> rows=driver.findElements(By.xpath("//table[@id='programDetail']//tbody//tr//td[2]"));
		packetCodes.clear();

		for(int i=1;i<rows.size();i++)
		{
			WebElement element=driver.findElement(By.xpath("//table[@id='programDetail']//tbody//tr["+i+"]//td[2]/input"));
			packetCodes.add(element.getAttribute("value"));

		}
	}

	public WebElement getPostfacultymember() {
		return postfacultymember;

	}

	public void postingfaculty()throws Exception
	{
		//Passing academic year
		ViewCommonUtil.selectDropDownItem("Academic year","//select[@id='academicYearId']");


		//Passing program
		ViewCommonUtil.selectDropDownItem("Program","//select[@id='programId']");
		Thread.sleep(2000);

		//Passing exam definition
		ViewCommonUtil.selectDropDownItem("Exam Definition","//select[@id='examDefinitionId']");
		Thread.sleep(2000);

		//passing the valuation camp
		ViewCommonUtil.selectDropDownItem("Valuation CampPost faculty member","//select[@id='valCampId']");
		Thread.sleep(2000);

		try {
			//passing the course code(After splitting)
			ViewCommonUtil.splitAndEnter("Course","//input[@id='course']",0);
			Thread.sleep(2000);
		} catch (InterruptedException | AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void searchbuttonpostfaculty() throws InterruptedException {
		ViewCommonUtil.click("//button[@id='valForm_search']");

	}

	public void postfaculty() throws Exception {

		//		passing the faculty id
		ViewCommonUtil.enterTextinTextField("Faculty","//input[@id='valForm_faculty']");
		robotkeys();

	}

	public void clickpostfaculty()throws Exception {


		//click post faculty
		ViewCommonUtil.click("//button[@id='postFaculty']");
		Thread.sleep(2000);
		//passing the reporting date
		ViewCommonUtil.enterTextinTextField("Reporting Date","//input[@id='reportDate']");
		Thread.sleep(2000);
		robotkeys();

		ViewCommonUtil.click("//button[@id='saveId']");

		Thread.sleep(2000);
		robotkeys();
		Thread.sleep(2000);

		try{

			WebElement reportingdatepopup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Reporting Date']")));
			reportingdatepopup.isDisplayed();

			ViewCommonUtil.click("(//button[@class='close'])[9]");

		}
		catch(Exception e){

		}
	}

	public void clickdistributepackets() throws InterruptedException {

		ViewCommonUtil.click("//a[text()='Distribute Packets']");
		Thread.sleep(2000);

	}

	public void clickaddbtn() throws InterruptedException {

		ViewCommonUtil.click("//a[@id='add']");
		Thread.sleep(1500);

	}

	public void distributepackets() throws Exception {


		System.out.println(packetCodes.size());

		for (String packetCode2 : packetCodes) {
			//Passing academic year
			ViewCommonUtil.selectDropDownItem("Academic year" , "//select[@id='academicYearId']");

			//passing program
			ViewCommonUtil.selectDropDownItem("Program" , "//select[@id='programId']");

			//Passing Exam definition
			ViewCommonUtil.selectDropDownItem("Exam Definition" , "//select[@id='examDefinitionId']");

			//Passing valuation camp
			ViewCommonUtil.selectDropDownItem("Valuation Camp" , "//select[@id='valCampid']");

			//passing faculty id
			ViewCommonUtil.enterTextinTextField("Faculty", "//input[@id='examiner']");
			robotkeys();

			WebElement packetcode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='branch']")));
			packetcode.clear();
			Thread.sleep(500);
			packetcode.sendKeys(packetCode2);
			System.out.println(packetCode2);
			Thread.sleep(1000);

			//saving
			ViewCommonUtil.click("//button[@id='examinerPacketForm_submit']");
			Thread.sleep(1000);

		}

	}

	public void logout() throws InterruptedException {

		ViewCommonUtil.click("//span[@class='glyphicon glyphicon-off']");

	}

	public void loginasFaculty() throws Exception {


		//passing faculty id
		ViewCommonUtil.enterTextinTextField("Faculty", "//input[@id='login-username']");

		//passing password
		ViewCommonUtil.enterTextinTextField("Password", "//input[@id='login-password']");
		Thread.sleep(1500);
		//click login
		ViewCommonUtil.click("//input[@id='btn-login']");
		Thread.sleep(1500);
		driver. navigate(). refresh();

	}


	public void filterinAssignedCourses() throws Exception {

		//Passing academic year
		ViewCommonUtil.selectDropDownItem("Academic year" , "//select[@id='academicYearId']");

		//passing program
		ViewCommonUtil.selectDropDownItem("Program" , "//select[@id='programId']");

		//Passing Exam definition
		ViewCommonUtil.selectDropDownItem("Exam Definition" , "//select[@id='examDefinitionId']");

	}

	public void clickSearchbutton() throws InterruptedException {

		ViewCommonUtil.click("//button[@id='facultyAssignedForm_search']");

	}

	public void selectingAssignedPackets() throws InterruptedException {

		String assignedpacketcourse =ViewCommonUtil.getExcelParameters("Course");

		WebElement assignedpacketsButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+assignedpacketcourse+"']//following::a[1]")));
		Thread.sleep(2000);
		assignedpacketsButton.click();
		Thread.sleep(2000);

	}

	public void viewGeneratedFalseno() throws InterruptedException {

		ViewCommonUtil.click("//a[text()='View Generated False Numbers']");

	}


	public void storingFalseNumberFilter() throws Exception {


		//Passing academic year
		ViewCommonUtil.selectDropDownItem("Academic year" , "//select[@id='academicYearId']");

		//passing program
		ViewCommonUtil.selectDropDownItem("Program" , "//select[@id='programId']");

		//Passing Exam definition
		ViewCommonUtil.selectDropDownItem("Exam Definition" , "//select[@id='examDefinition']");

		//Passing Institution name
		ViewCommonUtil.enterTextinTextField("Institution", "//input[@id='institution']");
		Thread.sleep(2000);
		robotkeys();

		//passing the course code(After splitting)
		ViewCommonUtil.splitAndEnter("Course","//input[@name='course']",0);


	}
	public void searchButtonViewGeneratedFalseNumber() throws InterruptedException {

		ViewCommonUtil.click("//button[@id='falseNoForInstitutionForm_search']");

	}

	//Creating arraylist for storing false number [for that purpose first getting the number of rows and storing that number of false number]
	public void storingFalseNumber() {

		List<WebElement> rows=driver.findElements(By.xpath("//div[@id='falseNoListingTable-parent']//tbody//tr//td[6]"));

		for(int i=1;i<=rows.size();i++) {

			WebElement element=driver.findElement(By.xpath("//div[@id='falseNoListingTable-parent']//tbody//tr["+i+"]//td[6]"));
			falsenumber.add(element.getText());

		}
	}


	public void markEnteringProcess() throws InterruptedException {


		int falseNumberCounter=0;

		List<WebElement> enterMarks=driver.findElements(By.xpath("//div[@id='packetListingTable-parent']//tbody/tr"));

		for(int i=1;i<=enterMarks.size();i++)
		{

			WebElement element =driver.findElement(By.xpath("//div[@id='packetListingTable-parent']//tbody/tr["+i+"]/td[5]/a"));
			Thread.sleep(2000);
			element.click();
			List<WebElement> rows=driver.findElements(By.xpath("//input[@id='falseNo']"));

			for(int j=1;j<=rows.size();j++) {

				WebElement enterfalseno=driver.findElement(By.xpath("(//input[@id='falseNo'])["+j+"]"));
				enterfalseno.clear();
				enterfalseno.sendKeys(falsenumber.get(falseNumberCounter));
				falseNumberCounter++;
				Thread.sleep(2000);

				WebElement entermarks=driver.findElement(By.xpath("(//input[@id='mark'])["+j+"]"));
				Thread.sleep(2000);
				entermarks.clear();
				entermarks.sendKeys(ViewCommonUtil.getExcelParameters("Marks"));
				Thread.sleep(2000);

			}

			ViewCommonUtil.	click("//input[@id='declarationId']");
			Thread.sleep(2000);

			ViewCommonUtil.	click("//button[@id='finalSubmit']");
			Thread.sleep(2000);
			robotkeys();
			Thread.sleep(2000);

		}

	}

	public void adexamLogin() throws Exception {

		//passing user name
		ViewCommonUtil.enterTextinTextField("User name", "//input[@id='login-username']");
		Thread.sleep(2000);

		//passing password
		ViewCommonUtil.enterTextinTextField("Password", "//input[@id='login-password']");
		Thread.sleep(2000);

		//click login
		ViewCommonUtil.	click("//input[@id='btn-login']");
		Thread.sleep(2000);

	}

	public void addingFilterinDistributePacketsPage() throws Exception {


		//passing academic year
		ViewCommonUtil.	selectDropDownItem("Academic year", "//select[@id='academicYearId']");
		Thread.sleep(2000);

		//passing program
		ViewCommonUtil.	selectDropDownItem("Program", "//select[@id='programId']");
		Thread.sleep(2000);

		//passing exam definition
		ViewCommonUtil.selectDropDownItem("Exam Definition", "//select[@id='examDefinitionId']");
		Thread.sleep(2000);

		//passing valuation camp
		ViewCommonUtil.selectDropDownItem("Valuation Camp", "//select[@id='valCampid']");
		Thread.sleep(2000);

		//passing status
		ViewCommonUtil.	selectDropDownItem("Status in the distributed packets WR & BE", "//select[@id='status']");
		Thread.sleep(2000);

		//split and enter the course
		ViewCommonUtil.splitAndEnter("Course","//input[@id='course']",0);

		//passing examiner
		ViewCommonUtil.	enterTextinTextField("Faculty", "//input[@id='examiner']");
		Thread.sleep(2000);
		robotkeys();

		ViewCommonUtil.	click("//button[@id='searchForm_search']");
		Thread.sleep(2000);

	}

	public void packetReceiving() throws InterruptedException {

		List<WebElement> packetsForReceiving=driver.findElements(By.xpath("//div[@id='examinerPacketTable-parent']//tbody/tr"));

		for(int i=1;i<=packetsForReceiving.size();i++) {
			WebElement receive= driver.findElement(By.xpath("//div[@id='examinerPacketTable-parent']//tbody/tr["+i+"]/td[9]/a"));
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", receive);
			Thread.sleep(2000);

			try {
				WebElement text=driver.findElement(By.xpath("//*[text()='This is the first packet for the camp. No other packets have been received so far.']"));
				text.isDisplayed();
				WebElement returnSerialNumber= driver.findElement(By.xpath("//input[@id='packetSlNo']"));
				Thread.sleep(2000);
				returnSerialNumber.sendKeys("1");
				Thread.sleep(500);

			} catch (Exception e) {


				WebElement Count=driver.findElement(By.xpath("//div[@id='slNoDiv']/label/b"));
				int previousCount=Integer.parseInt(Count.getText());
				Thread.sleep(2000);
				WebElement returnSerialNumber= driver.findElement(By.xpath("//input[@id='packetSlNo']"));
				Thread.sleep(2000);
				returnSerialNumber.sendKeys(String.valueOf(previousCount+1));
				Thread.sleep(500);
			}

			WebElement save= driver.findElement(By.xpath("//button [@id='examinerPacketForm_submit']"));
			js.executeScript("arguments[0].click();", save);
			Thread.sleep(2000);
			driver.navigate().back();
			driver.navigate().back();

		}
		//		robot.keyPress(KeyEvent.VK_ENTER);
		//		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public  void revokingReturnedPackets() throws Exception {

		//passing status while receiving
		ViewCommonUtil.	selectDropDownItem("Status in the distributed packets : Receiving", "//select[@id='status']");
		Thread.sleep(2000);

		//search button
		ViewCommonUtil.	click("//button[@id='searchForm_search']");
		Thread.sleep(1250);


		WebElement revokeReturnedPackets = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='save']")));
		Thread.sleep(1500);
		boolean flag=revokeReturnedPackets.isDisplayed();

		try{

			while(flag)
			{
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", revokeReturnedPackets);
				Thread.sleep(2000);

				//Enter remarks
				ViewCommonUtil.enterTextinTextField("Remarks", "//textarea[@id='remarkField']");

				//click yes
				ViewCommonUtil.click("(//button[@id='confirm'])[1]");
				Thread.sleep(2000);

				//passing status while receiving
				ViewCommonUtil.selectDropDownItem("Status in the distributed packets : Receiving", "//select[@id='status']");
				Thread.sleep(1500);

				//search button
				ViewCommonUtil.click("//button[@id='searchForm_search']");
				Thread.sleep(2000);

				revokeReturnedPackets = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='save']")));
				Thread.sleep(3000);
				flag=revokeReturnedPackets.isDisplayed();


			}
		}
		catch(Exception e){
			e.printStackTrace();

		}

	}

	public void packetsSendBacktoExaminer() throws Exception {

		//select status
		ViewCommonUtil.selectDropDownItem("Status in the distributed packets WR & BE", "//select[@id='status']");
		Thread.sleep(1200);

		//search
		ViewCommonUtil.click("//button[@id='searchForm_search']");
		Thread.sleep(1200);


		WebElement backtoexaminerbtn=driver.findElement(By.xpath("//div[@class='panel-body']//tbody//tr//td[9]/button"));
		Thread.sleep(2000);
		boolean flag=backtoexaminerbtn.isDisplayed();

		try{
			while(flag){


				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", backtoexaminerbtn);
				Thread.sleep(1250);
				robotkeys();
				Thread.sleep(1250);

				//select status
				ViewCommonUtil.selectDropDownItem("Status in the distributed packets WR & BE", "//select[@id='status']");
				System.out.println(ViewCommonUtil.getExcelParameters("Status in the distributed packets WR & BE"));
				Thread.sleep(1200);

				//search
				ViewCommonUtil.click("//button[@id='searchForm_search']");
				Thread.sleep(1200);

				backtoexaminerbtn=driver.findElement(By.xpath("//div[@class='panel-body']//tbody//tr//td[9]/button"));
				Thread.sleep(2000);
				flag=backtoexaminerbtn.isDisplayed();


			}
		}
		catch(Exception e){
			e.printStackTrace();


		}

	}



	public void cancellingReturnedPackets() throws Exception {

		//select status
		ViewCommonUtil.selectDropDownItem("Status cancelling Returned Packets", "//select[@id='status']");
		Thread.sleep(1200);

		//search
		ViewCommonUtil.click("//button[@id='searchForm_search']");
		Thread.sleep(2000);

		WebElement cancelbtn=driver.findElement(By.xpath("//div[@class='panel-body']//tbody//tr//td[9]/a[1]"));

		boolean flag=cancelbtn.isDisplayed();
		try {
			while(flag){
				JavascriptExecutor js = (JavascriptExecutor) driver;

				js.executeScript("arguments[0].click();", cancelbtn);
				Thread.sleep(2000);

				//Enter remarks
				ViewCommonUtil.enterTextinTextField("Remarks", "//textarea[@id='remarks']");
				Thread.sleep(1000);

				//click yes
				ViewCommonUtil.click("(//button[@id='confirm'])[2]");

				//select status
				ViewCommonUtil.selectDropDownItem("Status cancelling Returned Packets", "//select[@id='status']");
				Thread.sleep(1200);

				//search
				ViewCommonUtil.click("//button[@id='searchForm_search']");
				Thread.sleep(2000);

				cancelbtn=driver.findElement(By.xpath("//div[@class='panel-body']//tbody//tr//td[9]/a[1]"));
				Thread.sleep(1250);
				flag=cancelbtn.isDisplayed();


			}


		}

		catch(Exception e){
			e.printStackTrace();


		}
	}
	public void saveMarkEntryPageWithBlankDetails() throws InterruptedException {
		//enterMarksButtonAssignedPackagesPage
		ViewCommonUtil.click("(//table[@id='packetListingTable']//tbody/tr/td[5]/a)[1]");
		Thread.sleep(1000);

		WebElement save=driver.findElement(By.xpath("//button[@id='markEntryForm_submit']"));
		save.click();
		Thread.sleep(1000);

		WebElement validationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),' You cannot save mark with out false number and mark ')]")));
		Assert.assertTrue(validationMessage.isDisplayed(),"passed");

	}
	public void saveMarkEntryPageWithoutEnterMarks() throws InterruptedException {

		//enterMarksButtonAssignedPackagesPage
		ViewCommonUtil.click("(//table[@id='packetListingTable']//tbody/tr/td[5]/a)[1]");
		Thread.sleep(1000);

		WebElement invalidFalseNo=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='falseNo']")));
		invalidFalseNo.sendKeys("1235");

		WebElement save=driver.findElement(By.xpath("//button[@id='markEntryForm_submit']"));
		save.click();
		Thread.sleep(1000);

		WebElement validationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),' Please Enter mark for SAS-4-1')]")));
		Assert.assertTrue(validationMessage.isDisplayed(),"passed");

	}

}

























