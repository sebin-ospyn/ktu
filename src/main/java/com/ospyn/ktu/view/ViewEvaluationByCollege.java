package com.ospyn.ktu.view;

import static org.testng.AssertJUnit.assertEquals;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.util.Assert;
import com.ospyn.ktu.test.Login;
import com.ospyn.ktu.util.SeleniumBase;

public class ViewEvaluationByCollege extends SeleniumBase {
	FileInputStream fs;
	XSSFWorkbook workbook;
	static XSSFSheet sheet,sheet1;
	public static Map<String,String> excelParameters;



	public ViewEvaluationByCollege(WebDriver driver) throws Exception
	{
  				//initializing the driver
				super(driver);
//				fs = new FileInputStream(new File(System.getProperty("user.dir")+"/Test_Data/PARAMETER_LISTING.xlsx"));
//				//Getting the workbook
//				workbook = new XSSFWorkbook(fs);
//				//Getting the sheet
//				sheet = workbook.getSheet("Evaluation By  College");
//				System.out.println(sheet.getRow(3).getCell(1).getStringCellValue());
				excelParameters=ReadFromExcel("PARAMETER_LISTING.xlsx","Evaluation By  College");


	}
	@FindBy(xpath = "//*[@name='search']")
	WebElement Search;
 	@FindBy(xpath = "//*[@id=\"markForm_save\"]")
 	WebElement Save;
 	@FindBy(xpath = "//*[@id=\"markForm_markAsComplete\"]")
 	WebElement MarkasComplete;


	public WebElement getMarkasComplete() {
		return MarkasComplete;
	}


	public void setMarkasComplete(WebElement markasComplete) {
		MarkasComplete = markasComplete;
	}


	public WebElement getSave() {
		return Save;
	}

	public String getCollege()
	{
		sheet1 = workbook.getSheetAt(10);
		return(sheet1.getRow(1).getCell(Login.getColumn()).getStringCellValue());

	}
	public void setSave(WebElement save) {
		Save = save;
	}

	String coursetrim[];
	public  String[] facultyids;
	int flag=0,flag1=0;
	static WebElement element;



	//integer array
	public static int[] array_internal = new int[100];
	//String array
	public static String[] strArray = Arrays.stream(array_internal)
				.mapToObj(String::valueOf)
				.toArray(String[]::new);

	public WebElement getSearch() {
		return Search;
	}


	public void setSearch(WebElement search) {
		Search = search;
	}
	public static int CourseSize;

	public static List<Integer>flags=new ArrayList<Integer>();

//	facultyID conatins list of faculties who are able to do valuation(college)--courseCode contains course and Batch contains listed Batches data.
	public static List<String>courseCode=new ArrayList<String>();
	public static List<String>Batch=new ArrayList<String>();
	List<String>valutionStatus=new ArrayList<String>();



	public void evaluationBycollege() throws InterruptedException {
//		WebElement element = driver.findElement(By.xpath("//a[@href=\"/university/eu/exm/courseRegistrationInvitation.htm\"]//following::a[text()='Evaluation by College']"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click();", element);
		click("//a[@href=\"/university/eu/exm/courseRegistrationInvitation.htm\"]//following::a[text()='Evaluation by College']");

		Thread.sleep(1000);
	}


	public void exam() {
//		WebElement element = driver.findElement(By.xpath("//a[text()='Exam']"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click();", element);
		click("//a[text()='Exam']");
		}
	public void detailSearch() throws Exception {

		Thread.sleep(2000);
		selectDropDownItem("Academic year","//*[@id='academicYearId']");
 		selectDropDownItem("Program","//select[@id='programId']");
 		System.out.println(excelParameters.get("Program"));
 		selectDropDownItem("Program Type","//select[@id='programType']");
 		System.out.println(excelParameters.get("Exam Definition"));
		selectDropDownItem("Exam Definition","//select[@id='examDefinitionId']");
		Thread.sleep(500);


		click("//*[@name='search']");
//		Search.click();
		}

	public void facultyFetch() throws InterruptedException
	{
		List<WebElement> rws = driver.findElements(By.xpath("//*[@id='courseTable']/tbody/tr"));
		CourseSize = rws.size();
		facultyids=new String[CourseSize];
		if(flag1==1)
		{
			courseCode.clear();
			Batch.clear();
			flags.clear();
		}
		for (int i = 1; i<=CourseSize; i++) {
			String faculty = driver.findElement(By.xpath("//*[@id='courseTable']/tbody/tr["+(i)+"]/td[4]")).getText();
			 List<String>facultyID=new ArrayList<String>();
				System.out.println(faculty);

			facultyID.add((faculty.split(" - ")[0]));
			System.out.println(facultyID);

			facultyids[i-1]=facultyID.get(0)+"";
			System.out.println("******"+facultyids[i-1]);


//			Storing Course code details
			String course = driver.findElement(By.xpath("//*[@id='courseTable']/tbody/tr["+(i)+"]/td[1]")).getText();
			coursetrim=course.split("-");
			courseCode.add(coursetrim[0]);
			System.out.println("Course code are"+courseCode);
			flags.add(0);


//			Storing batch details
			String bat = driver.findElement(By.xpath("//*[@id='courseTable']/tbody/tr["+(i)+"]/td[3]")).getText();
			Batch.add(bat);
			System.out.println(Batch);
			flag1=1;



		}

	}
	public void clickMarkEntry() throws InterruptedException {
		Thread.sleep(1000);
//		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Evaluation by College (Mark Entry)']")));
//		element.click();
		click("//a[text()='Evaluation by College (Mark Entry)']");
		Thread.sleep(1000);

	}
	public void userSearchassignedCourses() throws Exception {


		Thread.sleep(2000);
		selectDropDownItem("Academic year","//*[@id='academicYearId']");
 		selectDropDownItem("Program","//select[@id='programId']");
 		selectDropDownItem("Exam Definition","//select[@id='examDefinition']");
 		Thread.sleep(500);
 		click("//*[@name='search']");
//		Search.click();

		}
	public void clicksEntermarks() {
//		Faculty selecting his assigned course and click on attendance internal button
		// count rows with size() method
		List<WebElement> rws = driver.findElements(By.xpath("//*[@id='courseTable']/tbody/tr"));
		for (int j = 0; j < rws.size(); j++)
		{
			List<WebElement> col_0 = rws.get(j).findElements(By.tagName("td"));
			String Coursename = col_0.get(0).getText();
			String courses[] = Coursename.split("-");
			String courseid="";
				if(courses.length==3)
			{
				courseid=courses[0];
			}
			else
			{
				courseid=courses[0];
			}
 			String Batchname = col_0.get(2).getText();

			System.out.println("****************************");
			System.out.println("Course Name "+courses[0]);
 			System.out.println("Batch is "+Batchname);
			System.out.println("Course Size="+CourseSize);
			//Iterating through the course size
			for( int k = 0; k< CourseSize;k++)
			{
				System.out.println(courseid+"="+courseCode.get(k));
				System.out.println("****************************");
 				System.out.println(Batchname+"="+Batch.get(k));



				if(courseid.equals(courseCode.get(k))&&Batchname.equals(Batch.get(k))&&flags.get(k)==0)
				{
					flags.add(k,1);
					System.out.println("**********************");
					System.out.println("Course code is "+courseCode.get(k));
 					System.out.println("Batch name is "+Batch.get(k));
					System.out.println("**********************");

//					WebElement element = driver.findElement(By.xpath("//*[@class='table table-responsive table-bordered']/tbody/tr["+(j+1)+"]/td[8]/a[1]"));
					WebElement element = driver.findElement(By.xpath("//*[@id='courseTable']/tbody/tr["+(j+1)+"]/td[4]/a[1]"));

					element.click();

				}

			}
		}
	}







	public void FacultyEnteringmarks() throws InterruptedException {
		// count rows with size() method

		//xpath of valuation Marks rows
		List<WebElement> ValuationMark = driver.findElements(By.xpath("//input[contains(@class,'form-control unsignedInteger')]"));
		System.out.println("Number of students with Marks: " + ValuationMark.size());


//		get the maximum valuation marks

 		String Text = driver.findElement(By.xpath("//*[@id='programDetail']/thead/tr[1]/th[3]")).getText();
		System.out.println("Text of Marks: " +Text);

//		 Extract the number after "/"
        String[] parts = Text.split("/");
        String number = parts[1].trim();

// 		 Print the extracted number
        System.out.println("Extracted number: " + Integer.parseInt(number));

//		 convert the value to integer
		int Internal = Integer.parseInt(number);
//		*******************************************************************************************************

		for (int i = 0; i < ((ValuationMark.size())-1); i++)
		{
			if((ValuationMark.get(i).isEnabled()))	{
				//entering valid internal marks
				//System.out.println(Mark.get(i).getText());
				ValuationMark.get(i).sendKeys(Keys.CONTROL + "a");
				ValuationMark.get(i).sendKeys(Keys.DELETE);
				//Mark.get(i).sendKeys(params.get(i));
				strArray[i] = String.valueOf(Internal-i);
				if(Internal-i==1) {
					Internal = Integer.parseInt(number);
				}
				ValuationMark.get(i).sendKeys(strArray[i]);

			}

		}

		getSave().click();
		Thread.sleep(1000);
		getMarkasComplete().click();
		Thread.sleep(3000);


	}

	public void logout() throws InterruptedException {

//		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//a[@href='/university/logout.htm']")));

//		element.click();
		click("//a[@href='/university/logout.htm']");
		Thread.sleep(2000);
	}

	public void logoutFromCollege () throws InterruptedException {
//		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//a[@href='/university/logout.htm']")));
//
//		element.click();
		click("//a[@href='/university/logout.htm']");

		Thread.sleep(2000);

	}
	public void ListFromCollege() throws Exception {
		Thread.sleep(2000);
		selectDropDownItem("Academic year","//*[@id='academicYearId']");
 		selectDropDownItem("Program","//select[@id='programId']");
 		selectDropDownItem("Program Type","//select[@id='programType']");
 		selectDropDownItem("Exam Definition","//select[@id='examDefinitionId']");
 		Thread.sleep(500);
		Search.click();



	}
	public void assertngValtnSbtByFaclty() {
 		List<WebElement> rws = driver.findElements(By.xpath("//*[@id=\"courseTable\"]/tbody/tr"));

		 String testValue="Faculty Submitted";
		for(int i = 1;i<=rws.size();i++)
			{

			String status = driver.findElement(By.xpath("//*[@id=\"courseTable\"]/tbody/tr[\"+(i)+\"]/td[5]")).getText();
			valutionStatus.add(status);
			System.out.println("Valuation status is"+valutionStatus);
			}
		// Assert that each status in valutionStatus is equal to the testValue
        for (String status : valutionStatus)
        {
          assertEquals(status, testValue);
         }
	}

	public void submitDetails() throws InterruptedException {
		Thread.sleep(2000);



//		WebElement element = driver.findElement(By.xpath("//*[@id=\"submissionForm_submit\"]"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click();", element);

//		click(//*[@id=\"submissionForm_submit\"]);


		click("//*[@id=\"submissionForm_submit\"]");
		Thread.sleep(500);

		click("(//*[contains(text(),'Yes')])[8]");




//		element  = driver.findElement(By.xpath("(//*[contains(text(),'Yes')])[8]"));
//		js.executeScript("arguments[0].click();", element);
		Thread.sleep(2000);

	}

	public void assertngValtnByCollege() {
		valutionStatus.clear();
		List<WebElement> rws = driver.findElements(By.xpath("//*[@id=\"courseTable\"]/tbody/tr"));

		 String testValue="Institution Submitted";
		for(int i = 1;i<=rws.size();i++)
			{

			String status = driver.findElement(By.xpath("//*[@id=\"courseTable\"]/tbody/tr[\"+(i)+\"]/td[5]")).getText();
			valutionStatus.add(status);
			System.out.println("Valuation status is"+valutionStatus);
			}
	// Assert that each status in valutionStatus is equal to the testValue
       for (String status : valutionStatus)
       {
         assertEquals(status, testValue);
        }
	}























	public Map<String,String> ReadFromExcel(String strExcelFileName, String strSheetName) throws Exception

	{

		System.out.println("strSheetName="+strSheetName);

		FileInputStream fs = new FileInputStream(new File(System.getProperty("user.dir")+"/Test_Data/"+strExcelFileName));

		Map<String, String> mapExcelData = new HashMap<String, String>();

		//Getting the workbook
		XSSFWorkbook workbook1 = new XSSFWorkbook(fs) ;
		 DataFormatter formatter = new DataFormatter(); //creating formatter using the default locale

		 //Getting the sheet
		 XSSFSheet sheetx = workbook1.getSheet(strSheetName);
		 System.out.println("Number of rows in sheet are "+sheetx.getLastRowNum());

		for(int tableIndex=0;tableIndex<sheetx.getPhysicalNumberOfRows();tableIndex++){
			//System.out.println("value="+formatter.formatCellValue(sheetx.getRow(tableIndex).getCell(0)));
			System.out.println("2=="+sheetx.getRow(tableIndex).getCell(0).getStringCellValue());
			System.out.println("333"+sheetx.getRow(tableIndex).getCell(1).getCellType());
			switch (sheetx.getRow(tableIndex).getCell(1).getCellType()) {
			case STRING:
				mapExcelData.put(sheetx.getRow(tableIndex).getCell(0).getStringCellValue().trim(),sheetx.getRow(tableIndex).getCell(1).getStringCellValue());
				break;
			case NUMERIC:
				String strVal=formatter.formatCellValue(sheetx.getRow(tableIndex).getCell(1));
				mapExcelData.put(sheetx.getRow(tableIndex).getCell(0).getStringCellValue().trim(),strVal);
				break;

			case BLANK:
                System.out.println("Blank cell");
                break;
            default:
                System.out.println("Unknown cell type");
                break;

			}



		}

		return mapExcelData;

	}

	public void selectDropDownItem(String parameterNameinDataSheet,String strLocator)throws Exception {

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(strLocator)));
		Select dropdown = new Select(element);

		dropdown.selectByVisibleText(excelParameters.get(parameterNameinDataSheet));

		System.out.println(parameterNameinDataSheet+"DONE!!!!");

		Thread.sleep(2000);

	}

public void enterTextinTextField(String parameterNameinDataSheet,String strLocator)throws Exception{

	WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(strLocator)));
	element.sendKeys(excelParameters.get(parameterNameinDataSheet));
	Thread.sleep(2000);
	Robot robot = new Robot();
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);
}

public static void click(String strLocator) {
	 WebDriverWait wait = new WebDriverWait(driver, 10);
     WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(strLocator)));
     ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

     if (element.isEnabled()) {
         try {
             element.click();
         } catch (ElementClickInterceptedException e) {
         // Use JavaScript to click if normal click is intercepted


((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
         }
     }
     System.out.println("Button Clicked !!"+strLocator);
 }



}
