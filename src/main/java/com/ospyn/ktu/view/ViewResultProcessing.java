//package com.ospyn.ktu.view;
//import static org.testng.AssertJUnit.assertEquals;
//
//import java.awt.AWTException;
//import java.awt.Robot;
//import java.awt.event.KeyEvent;
//import java.io.File;
//import java.io.FileInputStream;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.apache.poi.ss.usermodel.DataFormatter;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//
//import com.ospyn.ktu.util.SeleniumBase;
//import com.ospyn.ktu.util.ViewCommonUtil;
//import com.ospyn.ktu.util.ViewLogin;
//
//public class ViewResultProcessing extends SeleniumBase {
//	static ViewLogin login;
//	FileInputStream fs;
//	XSSFWorkbook workbook;
//	static XSSFSheet sheet,sheet1;
//
//
//	public static String examYearMonth;
//	public static String actualexamYearMonth;
//	public static String ExamType;
//	public static String ExamMode;
//
//	public static Map<String,String> excelParameters;
//	ViewCommonUtil CommonUtilView = new ViewCommonUtil(driver);
//
//	public ViewResultProcessing(WebDriver driver) throws Exception {
//		super(driver);
//		CommonUtilView.ReadFromExcel("PARAMETER_LISTING.xlsx","Result Processing");
//
//	}
//
//
//
//
//
//
//
//
//
//	public void clickResultModule() {
//		//		CommonUtilView.click("(//*[@href='/university/eu/res/listExams.htm'])[2]");
//		ViewCommonUtil.click("(//*[@href='/university/eu/res/examCourseStudentResultsListing.htm'])[1]");
//
//	}
//	public void clickResultProcessing() throws Exception  {
//		//		CommonUtilView.click("//*[@href='/university/eu/res/listExams.htm']");
//		ViewCommonUtil.click("(//*[@href='/university/eu/res/listExams.htm'])[1]");
//		Thread.sleep(1000);
//
//	}
//	public void filterData() throws Exception {
//		//User select academic year from Dropdown
//		ViewCommonUtil.selectDropDownItem("Academic year","//*[@id='academicYear']");
//		//User passing exam definition
//		ViewCommonUtil.enterTextinTextField("Exam definition","//*[@id='searchForm_definitionName']");
//		//User click on search button
//		ViewCommonUtil.click("//*[@id='searchForm_search']");
//		Thread.sleep(2000);
//	}
//	public void resultProcessing() throws Exception {
//		ViewCommonUtil.click(" //*[@id='examDefinitionTable']/tbody/tr/td[3]/a[1]");
//		Thread.sleep(2000);
//	}
//	public void assertngExamdf() {
//		String actual = ViewCommonUtil.getExcelParameters("Exam definition");
//		//String actual= excelParameters.get("CommonUtilView");
//		System.out.println(actual);
//		String Expected = driver.findElement(By.xpath("//*[@class='badge']")).getText();
//		assertEquals(actual,Expected);
//	}
//	public void clickExam() throws Exception {
//		try {
//			String actual = ViewCommonUtil.getExcelParameters("Exam definition");
//			//			String actual= excelParameters.get("CommonUtilView");
//			System.out.println(actual);
//			ViewCommonUtil.click("//*[@href='/university/eu/exm/listExamDefinition.htm']");
//			//User passing exam definition
//			ViewCommonUtil.enterTextinTextField("Exam definition","//*[@id='searchForm_definitionName']");
//			//User click on search button
//			ViewCommonUtil.click("//*[@id='searchForm_search']");
//		} catch (Exception e) 
//		{
//
//			e.printStackTrace();
//		}
//
//	}
//	public void fetchExamDetails() throws Exception {
//		Thread.sleep(1500);
//
//
//		examYearMonth = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='examDefinitionTable']/tbody/tr/td[3]"))).getText().trim();
//		actualexamYearMonth = examYearMonth.replace(" ", "/");
//		Thread.sleep(1000);
//		System.out.println(actualexamYearMonth);
//		ExamType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='examDefinitionTable']/tbody/tr/td[5]"))).getText();
//		System.out.println(ExamType);
//		Thread.sleep(1000);
//		ExamMode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='examDefinitionTable']/tbody/tr/td[6]"))).getText();
//		System.out.println(ExamMode);
//		Thread.sleep(1500);
//
//	}
//
//	public void examModeType() throws Exception {
//
//		String examMode = driver.findElement(By.xpath("(//*[@class='col-md-2'])[3]/b")).getText();
//		System.out.println("Exam mode taken from UI is "+examMode);
//		System.out.println(ExamMode);
//
//		String examType = driver.findElement(By.xpath("(//*[@class='col-md-2'])[4]/b")).getText();
//		System.out.println("Exam Type taken from UI is "+examType);
//		System.out.println(ExamType);
//
//		String examMonthYear = driver.findElement(By.xpath("//*[@class='col-md-2']/h5/b")).getText();
//		System.out.println("Exam month and year"+examMonthYear);
//		System.out.println(actualexamYearMonth);
//
//
//
//		assertEquals(examMode,ExamMode);
//		assertEquals(examType,ExamType);
//		assertEquals(examMonthYear,actualexamYearMonth);
//		Thread.sleep(1000);
//		System.out.println("Assertion Successful");
//	}
//	public void preProcessorJob() throws Exception {
//		//Pre-Processor Button click x-path
//		ViewCommonUtil.click("//*[@value='Pre-process ']");
//		Thread.sleep(1000);
//		//Pop up confirmation x-path
//		ViewCommonUtil.click("(//*[@id='confirm'])[3]");
//		WebElement element =driver.findElement(By.xpath("//*[@id='proProcessorTable-parent']"));
//		if(element.isDisplayed()) {
//			//Selecting all process
//			ViewCommonUtil.click("//*[@id='checkAll']");
//			Thread.sleep(1500);
//			//Click on processAll
//			ViewCommonUtil.click("//*[@id='filterForm_processAllBtn']");
//			Thread.sleep(1000);
//			Robot robot = new Robot ();
//			//Pressing the Enter Key
//			robot.keyPress(KeyEvent.VK_ENTER);
//			//Releasing the Enter Key
//			robot.keyRelease(KeyEvent.VK_ENTER);
//			Thread.sleep(1000);
//		}
//		else {
//			//User click on back boat
//			ViewCommonUtil.click(" //*[@class='btn btn-xs btn-default pull-right']");
//		}
//
//	}
//
//	public void validatingpreprocessorJob() throws InterruptedException {
//
//		System.out.println("Helooo");
//		try
//		{
//			Thread.sleep(3000);
//			while(wait.until(ExpectedConditions.visibilityOfElementLocated(
//					By.xpath("(//*[@id='showProgress'])[2]"))).isDisplayed())
//			{
//				Thread.sleep(5000);
//				driver.navigate().refresh();
//			}
//		}
//
//		catch(Exception e)
//		{
//			e.printStackTrace(); // Print stack trace for debugging
//			//User click on back boat
//			ViewCommonUtil.click(" //*[@class='btn btn-xs btn-default pull-right']");
//			Thread.sleep(1500);
//		}
//
//
//
//
//	}
//
//
//	public void markValidationJob() throws InterruptedException, AWTException
//	{
//		long startTime = System.currentTimeMillis();
//        long timeout = 3600000; // 1 hour in milliseconds
//		//Validate Button click x-path
//		ViewCommonUtil.click("//*[@value='Validate ']");
//		Thread.sleep(1000);
//		//Pop up confirmation x-path
//		ViewCommonUtil.click("(//*[@id='confirm'])[3]");
//		WebElement element =driver.findElement(By.xpath("//*[@id='examTimeTable']"));
//		if(element.isDisplayed()) {
//			//Selecting result select all process
//			ViewCommonUtil.click("//*[@id='checkAll']");
//			Thread.sleep(1500);
//			//Click on validateAll
//			ViewCommonUtil.click("//*[@id='filterForm_moveAll']");
//			Thread.sleep(1000);
//			ViewCommonUtil.click("(//*[@id='confirm'])[2]");
//			//************************
//			try
//			{
//				Thread.sleep(3000);
//				while(wait.until(ExpectedConditions.visibilityOfElementLocated(
//						By.xpath("(//*[@id='showProgress'])[2]"))).isDisplayed())
//				{
//					if (System.currentTimeMillis() - startTime > timeout) {
//	                    System.out.println("Test timed out after 1 hour");
//	                    break;
//	                }
//					if (wait.until(ExpectedConditions.visibilityOfElementLocated(
//	                        By.xpath("(//*[@id='showProgress'])[2]"))).isDisplayed()) {
//	                    Thread.sleep(5000); // Adjust sleep time as needed
//	                    driver.navigate().refresh();
//	                } else {
//	                    break;
//	                }
//					Thread.sleep(5000);
//					driver.navigate().refresh();
//				}
//			}
//
//			catch(Exception e)
//			{
//				e.printStackTrace(); // Print stack trace for debugging
//				//User click on back button
//				ViewCommonUtil.click(" //*[@class='btn btn-danger btn-xs pull-right']");
//				Thread.sleep(1500);
//			}
//
//		}
//		else {
//			//User click on back button
//			ViewCommonUtil.click(" //*[@class='btn btn-danger btn-xs pull-right']");
//		}
//		}
//
//
//		public void graceMarkModeration() throws InterruptedException {
//			long startTime = System.currentTimeMillis();
//	        long timeout = 3600000; // 1 hour in milliseconds
//			//Grace mark moderation process Button click x-path
//			ViewCommonUtil.click("(//*[@id='process'])[3]]");
//			Thread.sleep(1000);
//			//Pop up confirmation x-path
//			ViewCommonUtil.click("(//*[@id='confirm'])[3]");
//			WebElement element =driver.findElement(By.xpath("//*[@id='courseListingTable']"));
//			if(element.isDisplayed())
//				{
//				//Selecting result select all process
//				ViewCommonUtil.click("//*[@id='checkAll']");
//				Thread.sleep(1500);
//				//Click on generate moderation all
//				ViewCommonUtil.click("//*[@id='searchForm_generateModeration']");
//				Thread.sleep(1000);
//				ViewCommonUtil.click("(//*[@id='confirm'])[2]");
//				//************************
//				try
//				{
//					Thread.sleep(3000);
//					while(wait.until(ExpectedConditions.visibilityOfElementLocated(
//							By.xpath("(//*[@id='showProgress'])[2]"))).isDisplayed())
//					{
//						if (System.currentTimeMillis() - startTime > timeout) {
//	                    System.out.println("Test timed out after 1 hour");
//	                    break;
//	                }
//					if (wait.until(ExpectedConditions.visibilityOfElementLocated(
//	                        By.xpath("(//*[@id='showProgress'])[2]"))).isDisplayed()) {
//	                    Thread.sleep(5000); // Adjust sleep time as needed
//	                    driver.navigate().refresh();
//	                } else {
//	                    break;
//	                }
//
//						Thread.sleep(5000);
//						driver.navigate().refresh();
//					}
//				}
//
//				catch(Exception e)
//				{
//					e.printStackTrace(); // Print stack trace for debugging
//					//User click on back button
//					ViewCommonUtil.click("//*[@class='btn btn-danger btn-xs pull-right']");
//					Thread.sleep(1500);
//				}
//				}
//			else
//			{
//				//User click on back button
//				ViewCommonUtil.click("//*[@class='btn btn-danger btn-xs pull-right']");
//			}
//
//		}
//
//		public void processResult() throws InterruptedException {
//			long startTime = System.currentTimeMillis();
//	        long timeout = 3600000; // 1 hour in milliseconds
//			//Button click on Process result
//			ViewCommonUtil.click("//*[@id='processLink']");
//			Thread.sleep(500);
//			//Pop up confirmation x-path
//			ViewCommonUtil.click("(//*[@id='confirm'])[3]");
//			WebElement element =driver.findElement(By.xpath("//*[@id='resultBranchListingTable']"));
//			if(element.isDisplayed())
//				{
//				//Selecting result select all process
//				ViewCommonUtil.click("//*[@id='checkAll']");
//				Thread.sleep(1500);
//				//Click on process result all
//				ViewCommonUtil.click("//*[@id='processResult']");
//				Thread.sleep(1000);
//				ViewCommonUtil.click("(//*[@id='confirm'])[2]");
//				//************************
//				try
//				{
//					Thread.sleep(3000);
//					while(wait.until(ExpectedConditions.visibilityOfElementLocated(
//							By.xpath("(//*[@id='showProgress'])[2]"))).isDisplayed())
//					{
//						if (System.currentTimeMillis() - startTime > timeout) {
//		                    System.out.println("Test timed out after 1 hour");
//		                    break;
//		                }
//						if (wait.until(ExpectedConditions.visibilityOfElementLocated(
//		                        By.xpath("(//*[@id='showProgress'])[2]"))).isDisplayed()) {
//		                    Thread.sleep(5000); // Adjust sleep time as needed
//		                    driver.navigate().refresh();
//		                } else {
//		                    break;
//		                }
//						Thread.sleep(5000);
//						driver.navigate().refresh();
//					}
//				}
//
//				catch(Exception e)
//				{
//					e.printStackTrace(); // Print stack trace for debugging
//					//User click on back button
//					ViewCommonUtil.click("//*[@class='btn btn-xs btn-default pull-right']");
//					Thread.sleep(1500);
//				}
//				}
//			else
//			{
//				//User click on back button
//				ViewCommonUtil.click("//*[@class='btn btn-xs btn-default pull-right']");
//			}
//
//			}
//
//
//
//		public void clickPostProcess() throws InterruptedException {
//			//Button click on postProcess
//			ViewCommonUtil.click("//*[@id='postProcessLink']");
//			Thread.sleep(500);
//			//Pop up confirmation x-path
//			ViewCommonUtil.click("(//*[@id='confirm'])[3]");
//
//		}
//
//		public void clickPostProcessAll() throws InterruptedException {
//			long startTime = System.currentTimeMillis();
//	        long timeout = 3600000; // 1 hour in milliseconds
//			WebElement element =driver.findElement(By.xpath("//*[@id='branchListingTable']"));
//			if(element.isDisplayed())
//				{
//				//Selecting  check box
//				ViewCommonUtil.click("//*[@id='checkAll']");
//				Thread.sleep(1500);
//				//Click on process result all
//				ViewCommonUtil.click("//*[@id='searchForm_postProcessAll']");
//				Thread.sleep(1000);
//				ViewCommonUtil.click("(//*[@id='confirm'])[2]");
//				//************************
//				try
//				{
//					Thread.sleep(3000);
//					while(wait.until(ExpectedConditions.visibilityOfElementLocated(
//							By.xpath("(//*[@id='showProgress'])[2]"))).isDisplayed())
//					{
//						if (System.currentTimeMillis() - startTime > timeout) {
//		                    System.out.println("Test timed out after 1 hour");
//		                    break;
//		                }
//						if (wait.until(ExpectedConditions.visibilityOfElementLocated(
//		                        By.xpath("(//*[@id='showProgress'])[2]"))).isDisplayed()) {
//		                    Thread.sleep(5000); // Adjust sleep time as needed
//		                    driver.navigate().refresh();
//		                } else {
//		                    break;
//		                }
//						Thread.sleep(5000);
//						driver.navigate().refresh();
//					}
//				}
//
//				catch(Exception e)
//				{
//					e.printStackTrace(); // Print stack trace for debugging
//					//User click on back button
//					ViewCommonUtil.click("//*[@class='btn btn-xs btn-default pull-right']");
//					Thread.sleep(1500);
//				}
//				}
//			else
//			{
//				//User click on back button
//				ViewCommonUtil.click("//*[@class='btn btn-xs btn-default pull-right']");
//			}
//
//
//			}
//
//
//			//User clicking publish button
//			public void buttonClick() throws InterruptedException {
//				ViewCommonUtil.click("//*[@id='publishLink']");
//				Thread.sleep(500);
//				ViewCommonUtil.click("(//*[@id='confirm'])[3]");
//
//
//			}
//
//			public void publishResult() throws InterruptedException {
//				WebElement element =driver.findElement(By.xpath("//*[@id='courseListingTable-parent']"));
//				if(element.isDisplayed())
//					{
//					long startTime = System.currentTimeMillis();
//			        long timeout = 3600000; // 1 hour in milliseconds
//					//Selecting  check box
//					ViewCommonUtil.click("//*[@id='checkAll']");
//					Thread.sleep(1500);
//					//Click on publish all
//					ViewCommonUtil.click("//*[@id='searchForm_publishAll']");
//					Thread.sleep(1000);
//					ViewCommonUtil.click("(//*[@id='confirm'])[5]");
//					//************************
//					try
//					{
//						Thread.sleep(3000);
//						while(wait.until(ExpectedConditions.visibilityOfElementLocated(
//								By.xpath("(//*[@id='showProgress'])[2]"))).isDisplayed())
//						{
//							if (System.currentTimeMillis() - startTime > timeout) {
//			                    System.out.println("Test timed out after 1 hour");
//			                    break;
//			                }
//							if (wait.until(ExpectedConditions.visibilityOfElementLocated(
//			                        By.xpath("(//*[@id='showProgress'])[2]"))).isDisplayed()) {
//			                    Thread.sleep(5000); // Adjust sleep time as needed
//			                    driver.navigate().refresh();
//			                } else {
//			                    break;
//			                }
//
//
//
//
//							Thread.sleep(5000);
//							driver.navigate().refresh();
//						}
//					}
//
//					catch(Exception e)
//					{
//						e.printStackTrace(); // Print stack trace for debugging
//						//User click on back button
//						ViewCommonUtil.click("//*[@class='btn btn-xs btn-default pull-right']");
//						Thread.sleep(1500);
//					}
//					}
//				else
//				{
//					//User click on back button
//					ViewCommonUtil.click("//*[@class='btn btn-xs btn-default pull-right']");
//				}
//
//
//			}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//	//	**********************************
//	public Map<String,String> ReadFromExcel(String strExcelFileName, String strSheetName) throws Exception
//
//	{
//
//		System.out.println("strSheetName="+strSheetName);
//
//		FileInputStream fs = new FileInputStream(new File(System.getProperty("user.dir")+"/Test_Data/"+strExcelFileName));
//
//		Map<String, String> mapExcelData = new HashMap<String, String>();
//
//		//Getting the workbook
//		XSSFWorkbook workbook1 = new XSSFWorkbook(fs) ;
//		DataFormatter formatter = new DataFormatter(); //creating formatter using the default locale
//
//		//Getting the sheet
//		XSSFSheet sheetx = workbook1.getSheet(strSheetName);
//		System.out.println("Number of rows in sheet are "+sheetx.getLastRowNum());
//
//		for(int tableIndex=0;tableIndex<sheetx.getPhysicalNumberOfRows();tableIndex++){
//			//System.out.println("value="+formatter.formatCellValue(sheetx.getRow(tableIndex).getCell(0)));
//			System.out.println("2=="+sheetx.getRow(tableIndex).getCell(0).getStringCellValue());
//			System.out.println("333"+sheetx.getRow(tableIndex).getCell(1).getCellType());
//			switch (sheetx.getRow(tableIndex).getCell(1).getCellType()) {
//			case STRING:
//				mapExcelData.put(sheetx.getRow(tableIndex).getCell(0).getStringCellValue().trim(),sheetx.getRow(tableIndex).getCell(1).getStringCellValue());
//				break;
//			case NUMERIC:
//				String strVal=formatter.formatCellValue(sheetx.getRow(tableIndex).getCell(1));
//				mapExcelData.put(sheetx.getRow(tableIndex).getCell(0).getStringCellValue().trim(),strVal);
//				break;
//
//			case BLANK:
//				System.out.println("Blank cell");
//				break;
//			default:
//				System.out.println("Unknown cell type");
//				break;
//
//			}
//
//
//
//		}
//
//		workbook1.close();
//
//		return mapExcelData;
//
//	}
//}
