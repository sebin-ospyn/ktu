package com.ospyn.ktu.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewCommonUtil extends SeleniumBase{

	public ViewCommonUtil(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public static Map<String,String> excelParameters=new HashMap<String, String>();
	// return the value of a parameter defined in test data sheet.
	public static String getExcelParameters(String param) {
		//return excelParameters;
		return(excelParameters.get(param));
	}

	/**  
	 * @author u1756
	 * @date 01/07/2024
	 * @description : Method is used to read the values from test data excel sheet which is in format of parameter name and value
	 * @param : strExcelFileName - name of excel spreadsheet with full path and extension
	 * 			strSheetName     - name of the sheet to be referred for accessing parameters
	 * @return : none
	 * 
	 */
	public static void readFromExcel(String strExcelFileName, String strSheetName) throws Exception

	{


		FileInputStream fs = new FileInputStream(new File(System.getProperty("user.dir")+"/Test_Data/"+strExcelFileName));


		//Getting the workbook

		XSSFWorkbook workbook1 = new XSSFWorkbook(fs) ;
		DataFormatter formatter = new DataFormatter(); //creating formatter using the default locale


		//Getting the sheet
		try {
			XSSFSheet sheetx = workbook1.getSheet(strSheetName);

			try {


				for(int tableIndex=0;tableIndex<sheetx.getPhysicalNumberOfRows();tableIndex++){

					if(sheetx.getRow(tableIndex).getCell(1)!=null)
					{

						switch (sheetx.getRow(tableIndex).getCell(1).getCellType()) {
						case STRING:
							excelParameters.put(sheetx.getRow(tableIndex).getCell(0).getStringCellValue().trim(),sheetx.getRow(tableIndex).getCell(1).getStringCellValue());
							break;
						case NUMERIC:
							String strVal=formatter.formatCellValue(sheetx.getRow(tableIndex).getCell(1));
							excelParameters.put(sheetx.getRow(tableIndex).getCell(0).getStringCellValue().trim(),strVal);
							break;

						default:
							System.out.println("Unknown cell type");
							break;	

						}
					}
				}
			}
			catch(NullPointerException e) {
				System.out.println("Check row details");
			}

		}
		catch(NullPointerException e) {
			System.out.println("Sheet Name Invalid!!");
		}
		workbook1.close();


	}	

	/**  
	 * @author u1756
	 * @date 01/07/2024
	 * @description : Method is used to select the value from a drop down list 
	 * @param : parameterNameinDataSheet - name of parameter name defined in excel sheet
	 * 			strLocator     - locator used to identify drop down webelement.
	 * @return : none
	 */

	public static void selectDropDownItem(String parameterNameinDataSheet,String strLocator)throws Exception {

		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(strLocator)));
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(excelParameters.get(parameterNameinDataSheet));
		Thread.sleep(2000);

	}
	/**  
	 * @author u1756
	 * @date 01/07/2024
	 * @description : Method is used to enter a text value in a text box field in application
	 * @param : parameterNameinDataSheet - name of parameter name defined in excel sheet
	 * 			strLocator     - locator used to identify drop down webelement.
	 * @return : none
	 */

	public static void enterTextinTextField(String parameterNameinDataSheet,String strLocator)throws Exception{

		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(strLocator)));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		element.sendKeys(excelParameters.get(parameterNameinDataSheet));
		Thread.sleep(2000);

	}
	/**  
	 * @author u1598
	 * @date 01/07/2024
	 * @description : Method is used to enter a string value 
	 * @param : textValue - value to be entered in text field
	 * 			strLocator     - locator used to identify drop down webelement.
	 * @return : none
	 */

	public static void enterStringValueinTextField(String excelValueStoredString , String strLocator) throws Exception {
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(strLocator)));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
		
		element.clear();
		element.sendKeys(excelValueStoredString);
		Thread.sleep(300);
	}

	/**  
	 * @author u1598
	 * @date 01/07/2024
	 * @description : Method is used to select the value from a drop down list 
	 * @param : textData - text data to be selected from drop down list
	 * 			strLocator     - locator used to identify drop down webelement.
	 * @return : none
	 */

	public static void selectStringDropDownItem(String textData , String strLocator ) {
		try {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(strLocator)));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		//element.click();		
		Select dropdown = new Select(element);		
		dropdown.selectByVisibleText(textData);
		Thread.sleep(300);
		}
		catch(Exception e){
			System.out.println("exception="+e);
			
		}
		

	}

	/**  
	 * @author u1756
	 * @date 01/07/2024
	 * @description : Method is used to click on a webelement where we handled interception errors and set focus issue
	 * @param : strLocator     - locator used to identify drop down webelement.
	 * @return : none
	 */


	public static void click(String strLocator) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(strLocator)));
		//WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(strLocator)));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

		if (element.isEnabled()) {
			try {
				element.click();
			} catch (ElementClickInterceptedException e) {
				// Use JavaScript to click if normal click is intercepted


				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			}
		}
	}
	/**  
	 * @author u1756
	 * @date 01/07/2024
	 * @description : Method is used to write a new value or update an existing value in excel sheet against a parameter name
	 * @param : strExcelFileName     - Name of the excel spreadsheet with extension.
	 * 			strSheetName - name of the sheet to be referred
	 * 			fieldName - name of the parameter against which the data to be added/updated 
	 * 			strData - data to be updated 
	 * @return : none
	 */


	public static void writeToExcel(String strExcelFileName, String strSheetName,String fieldName, String strData) throws Exception {

		boolean bFieldNamefound=false;
		FileInputStream fs = new FileInputStream(new File(System.getProperty("user.dir")+"/Test_Data/"+strExcelFileName));

		XSSFWorkbook workbook = new XSSFWorkbook(fs) ;

		//Getting the sheet
		try {
			XSSFSheet sheet = workbook.getSheet(strSheetName);

			try {
				for(int tableIndex=0;tableIndex<sheet.getPhysicalNumberOfRows();tableIndex++){
					if(sheet.getRow(tableIndex).getCell(0).getStringCellValue().equals(fieldName)) {
						if(sheet.getRow(tableIndex).getCell(1)==null) {
							sheet.getRow(tableIndex).createCell(1);
						}
						sheet.getRow(tableIndex).getCell(1).setCellValue(strData);					 
						System.out.println("data written in excel sheet"+strData);


						bFieldNamefound=true;
						break;
					}
				}

				if(!bFieldNamefound){
					System.out.println(fieldName+" not found in datasheet >"+strSheetName); 

				}
			}
			catch(Exception e) {
				System.out.println("Check row details");
			}

		}
		catch(NullPointerException e) {
			System.out.println("Sheet Name Invalid!!");
		}
		fs.close();
		FileOutputStream fs2 = new FileOutputStream(new File(System.getProperty("user.dir")+"/Test_Data/"+strExcelFileName));
		workbook.write(fs2);
		fs2.close();
		workbook.close();

	}

	/**  
	 * @author u1598
	 * @date 01/07/2024
	 * @description : Method is used to enter a part of text field  
	 * @param : 
	 * 			fieldName - name of the parameter against which the data to be added/updated 
	 * 			strLocator - locator of the webelement
	 * 			index - position index
	 * @return : none
	 */

	public static void splitAndEnter(String fieldName,String strLocator,int index ) throws InterruptedException, AWTException {

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(strLocator)));
		String fieldVal=excelParameters.get(fieldName);
		String[] valueAfterSplit= fieldVal.split(" ");
		Thread.sleep(2000);
		element.sendKeys(valueAfterSplit[index]); 
		Thread.sleep(2000);
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_ENTER); 
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	/**  
	 * @author u1756
	 * @date 01/07/2024
	 * @description : Method is used to read a value form excel based on column header and row index
	 * @param : strExcelFileName     - Name of the excel spreadsheet with extension.
	 * 			strSheetName - name of the sheet to be referred
	 * 			columnHeader - name of column header
	 * 			rowindex - row index
	 * @return : column value
	 */

	public static String readExcelColumHeader(String strExcelFileName, String strSheetName,String columnHeader,int rowindex) throws Exception

	{
		System.out.println("strSheetName="+strSheetName);
		String columnValue =null;
		FileInputStream fs = new FileInputStream(new File(System.getProperty("user.dir")+"/Test_Data/"+strExcelFileName));


		//Getting the workbook

		XSSFWorkbook workbook1 = new XSSFWorkbook(fs) ;

		//Getting the sheet
		try {
			XSSFSheet sheetx = workbook1.getSheet(strSheetName);
			Row headerRow = sheetx.getRow(0);
			Map<String, Integer> columnMap = new HashMap<>();
			for (Cell cell : headerRow) {
				columnMap.put(cell.getStringCellValue(), cell.getColumnIndex());
			}

			try {


				columnValue = getCellValue(sheetx.getRow(rowindex), columnMap, columnHeader).toString();
				System.out.println(columnHeader+": " +rowindex+"="+columnValue);


			}
			catch(NullPointerException e) {
				System.out.println("Check row details");
			}

		}
		catch(NullPointerException e) {
			System.out.println(e+"Sheet Name Invalid!!");
		}
		workbook1.close();

		return columnValue;
	}	
	/**  
	 * @author u1756
	 * @date 01/07/2024
	 * @description : Method is used to read the cell value
	 * @param : row     - row object
	 * 			columnMap 
	 * 			columnName
	 * 			
	 * @return : cell value
	 */

	private static String getCellValue(Row row, Map<String, Integer> columnMap, String columnName) {
		int columnIndex = columnMap.getOrDefault(columnName, -1);
		if (columnIndex == -1) {
			return null;
		}
		Cell cell = row.getCell(columnIndex);
		if (cell == null) {
			return null;
		}

		switch (cell.getCellType()) {
		case STRING:
			return cell.getStringCellValue();
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				return cell.getDateCellValue().toString();
			} else {
				//return String.valueOf(cell.getNumericCellValue());

				return String.format("%.0f", cell.getNumericCellValue());
			}
		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		case FORMULA:
			return cell.getCellFormula();
		default:
			return null;
		}
	}


	/**  
	 * @author u1598
	 * @date 01/07/2024
	 * @description : Method is used to enter a part of text field  
	 * @param : 
	 * 			fieldName - name of the parameter against which the data to be added/updated 
	 * 			strLocator - locator of the webelement
	 * 			index - position index
	 * @return : none
	 */


	public static void checkBox(String excelValueStoredString,String Locator) throws Exception, InterruptedException {
		if (excelValueStoredString.equals("Yes")) {
			WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locator)));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
			Thread.sleep(1000);
		}

	}



	/**  
	 * @author u1756
	 * @date 01/07/2024
	 * @description : Method is used add the attachment name 
	 * @param : parameterNameinDataSheet     - attachment filed name
	 * 			strLocator -locator if <input type=file..> element
	 * 			
	 * 			
	 * @return : none
	 */
	public static void browseAttachment(String filename,String strLocator)throws Exception{

		String strFullFileName=System.getProperty("user.dir")+"/Test_Data/"+filename;
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(strLocator)));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

		element.sendKeys(strFullFileName);
		Thread.sleep(2000);
	}

	/**  
	 * @author u1756
	 * @date 01/07/2024
	 * @description : Method is used generate an 'n' digit random number
	 * @param : range     - number of digit to be generated
	 * 			

	 * @return : randomGeneratedString
	 */

	public static String randomNumberGenerator(int range) {
		Random random = new Random();


		// Generate a 16-digit number
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < range; i++) {
			int digit = random.nextInt(10); // Generate a random digit between 0 and 9
			sb.append(digit);
		}

		// Convert StringBuilder to String
		String randomGeneratedString = sb.toString();
		if(randomGeneratedString.charAt(0)=='0'){
			// Replace the first character
			randomGeneratedString = '9' + randomGeneratedString.substring(1);
		}

		System.out.println("randomDigitNumber="+randomGeneratedString);

		return randomGeneratedString;

	}
	/**  
	 * @author u1756
	 * @date 01/07/2024
	 * @description : Method is used generate an 'n' character string 
	 * @param : range     - number of character to be generated
	 * 			

	 * @return : randomGeneratedString
	 */
	public static String randomStringGenerator(int range) {

		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		Random random = new Random();

		// Generate a n-letter random name
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < range; i++) {
			int index = random.nextInt(alphabet.length());
			sb.append(alphabet.charAt(index));
		}


		// Convert StringBuilder to String
		String randomGeneratedString = sb.toString();
		System.out.println("randomGeneratedString="+randomGeneratedString);

		return randomGeneratedString;


	}

	/**  
	 * @author u1756
	 * @date 25/07/2024
	 * @description : Method is used for page load
	 * @param : none
	 * 			

	 * @return : none
	 * @throws InterruptedException 
	 */

	//	public static void waitforPageLoad()
	//	{
	//		try {
	//			new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
	//		}
	//		catch(Exception e)
	//		{
	//			System.out.print(e);
	//		}
	//
	//	}
	//
	//}

	

//	public static void waitforPageLoad(String currPageUrl)
//	{
//		try {
//			System.out.println("wait funtcion="+currPageUrl);		
//			boolean bflag=false;
//			Timer timer= new Timer();
//			int seconds=0;
//			
//			do {
//				System.out.println("seconds"+seconds);
//				 Thread.sleep(1000);
//			
//				
//				 if(driver.getCurrentUrl().contains(currPageUrl)) {
//					bflag=true;
//				 }
//				
//				if(seconds>120)	{
//					bflag=true;
//				}
//				seconds++;
//				
//			}while(!bflag);
//			
//			 
//				WebDriverWait webDriverWait = new WebDriverWait(driver, 50);
//			
//			    webDriverWait.until((ExpectedCondition<Boolean>) wd ->
//			        ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
//
//			    webDriverWait.until((ExpectedCondition<Boolean>) wd ->
//			        ((JavascriptExecutor) wd).executeScript("return jQuery.active==0").equals(true));
//			  
//		}
//		catch(Exception e)
//		{
//			System.out.print(e);
//		}
//		
//	}
	
	/**  
	 * @author u1598
	 * @date 04/08/2024
	 * @description : Method is used to login
	 * @param : 
	 * 			userName - user name of the user
	 * 			password - password of the user
	 * @return : none
	 */
	
	public static void logIn(String userName ,String password) throws Exception {


		//passing user name
		
		enterTextinTextField( userName, "//input[@id='login-username']");

		//passing password
	
		enterTextinTextField( password, "//input[@id='login-password']");
		Thread.sleep(1500);
		//click login
		click("//input[@id='btn-login']");
		Thread.sleep(1500);
		driver. navigate(). refresh();

	}
	
	/**  
	 * @author u1598
	 * @date 04/08/2024
	 * @description : Method is used to logout
	 * @param : none
	 * @return : none
	 */
	
	public static void logOut() throws Exception {
		
		click("//span[@class='glyphicon glyphicon-off']");

	}
	
	/**  
	 * @author u1780
	 * @date 06/09/2024
	 * @description : This method is user for accepting the alert popup 
	 * @return : none
	 */
	public static void acceptAlert()
	{
		driver.switchTo().alert().accept();
	}
	
	/**  
	 * @author u1780
	 * @date 18/09/2024
	 * @description : This method is user for performing the scroll action to the bottom of webpage
	 * @return : none
	 */
	public static void scrollToBottom()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	/**  
	 * @author u1780
	 * @date 23/10/2024
	 * @description : This method is user for performing the scroll action to the bottom of webpage
	 * @return : none
	 * @throws AWTException 
	 */
	public static void enterKeyPress() throws AWTException
	{
		Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
	}
	/**  
	 * @author u1780
	 * @date 23/10/2024
	 * @description : This method is user for handling selectbox ( for performing POM design pattern)
	 * @return : none
	 * @throws AWTException 
	 */
	
	public static void selectDropdownOptionFromExcel(WebElement dropdownElement, String valueKey) throws Exception {
        // Fetch the value to select from Excel
        String valueToSelect = ViewCommonUtil.getExcelParameters(valueKey);

        // Create a Select object to interact with the dropdown
        Select select = new Select(dropdownElement);

        // Select the value from the dropdown by visible text
        select.selectByVisibleText(valueToSelect); // You can also use select.selectByValue() or select.selectByIndex()
    }
	/**  
	 * @author u1780
	 * @date 26/11/2024
	 * @description : This method is user for establishing the mysql connection and fetching the data from query
	 * @return :String 
	 * @throws AWTException 
	 */
	
public static String connectDBFetchSingleDataFinal(String Dburl,String username,String pswd,String SQL) {


    // Database credentials
//    final String DB_URL = "jdbc:mysql://localhost:3306/university_aug24";
    final String DB_URL=Dburl;
//    final String USER = "root";
    final String USER= username;
//    final String PASS = "0spyn123";
    final String PASS=pswd;


        Connection conn = null;
        Statement stmt = null;
        String id = null;

        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("catalog="+ conn.getCatalog());
            // Step 3: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
//					sql="SELECT accountHolder FROM eustu_institution_student WHERE registerNo LIKE '%tki20cs011%';";
					sql=SQL;

            ResultSet rs = stmt.executeQuery(sql);

            // Step 4: Extract data from result set
            if (rs.next()) {  // Check if there's at least one row
                id = rs.getString("accountHolder");  // Retrieve the accountHolder value
                System.out.println(id);  // Display the id
            }
            rs.close();
            stmt.close();
            conn.close();
            
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // Finally block used to close resources
            try {
                if (stmt != null) {
					stmt.close();
				}
            } catch (SQLException se2) {
            } // nothing we can do
            try {
                if (conn != null) {
					conn.close();
				}
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
        return id;
}

public static void connectDB() {


//	public class DatabaseQueryExample {
	    // Database credentials
	    final String DB_URL = "jdbc:mysql://localhost:3306/university_mar23";
	    final String USER = "root";
	     final String PASS = "0spyn123";


	        Connection conn = null;
	        Statement stmt = null;

	        try {
	            // Step 1: Register JDBC driver
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            // Step 2: Open a connection
	            System.out.println("Connecting to database...");
	            conn = DriverManager.getConnection(DB_URL, USER, PASS);
	            System.out.println("catalog="+ conn.getCatalog());
	            // Step 3: Execute a query
	            System.out.println("Creating statement...");
	            stmt = conn.createStatement();
	            String sql;
//	            sql = "SELECT distinct(S.registerNo),C.studentId,C.courseId,C.noOfChances FROM\n"
//	            		+ "eustu_student_curriclum C join eustu_institution_student S ON\n"
//	            		+ "c.studentId=S.id WHERE C.semId = 4 AND C.completed = 0 AND\n"
//	            		+ "C.isEligibleForWrittenExam = 1 and S.schemeId=17  \n"
//	            		+ "ORDER BY\n"
						sql="SELECT registerNo, aadharNo, institutionName FROM eustu_institution_student WHERE registerNo LIKE '%tki20cs011%';";

	            ResultSet rs = stmt.executeQuery(sql);

	            // Step 4: Extract data from result set
	            while (rs.next()) {
	                // Retrieve by column name
	                String id = rs.getString("username");
	               // String name = rs.getString("studentId");
	             //   String age = rs.getString("courseId");

	                // Display values
	                System.out.print("username: " + id);
	            //    System.out.print(", studentId: " + name);
	             //   System.out.println(", courseId: " + age);
	            }
	            // Step 5: Clean-up environment
	            rs.close();
	            stmt.close();
	            conn.close();
	        } catch (SQLException se) {
	            // Handle errors for JDBC
	            se.printStackTrace();
	        } catch (Exception e) {
	            // Handle errors for Class.forName
	            e.printStackTrace();
	        } finally {
	            // Finally block used to close resources
	            try {
	                if (stmt != null) {
						stmt.close();
					}
	            } catch (SQLException se2) {
	            } // nothing we can do
	            try {
	                if (conn != null) {
						conn.close();
					}
	            } catch (SQLException se) {
	                se.printStackTrace();
	            }
	        }
	        System.out.println("Goodbye!");
	   // }
//	}


}
public static String finaldb() {


    // Database credentials
    final String DB_URL = "jdbc:mysql://localhost:3306/university_aug24";
//    final String DB_URL=Dburl;
    final String USER = "root";
//    final String USER= username;
    final String PASS = "0spyn123";
//    final String PASS=pswd;


        Connection conn = null;
        Statement stmt = null;
        String id = null;

        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("catalog="+ conn.getCatalog());
            // Step 3: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
					sql="SELECT accountHolder FROM eustu_institution_student WHERE registerNo LIKE '%tki20cs011%';";
//					sql=SQL;

            ResultSet rs = stmt.executeQuery(sql);

            // Step 4: Extract data from result set
            if (rs.next()) {  // Check if there's at least one row
                id = rs.getString("accountHolder");  // Retrieve the accountHolder value
                System.out.println(id);  // Display the id
            }
            rs.close();
            stmt.close();
            conn.close();
            
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // Finally block used to close resources
            try {
                if (stmt != null) {
					stmt.close();
				}
            } catch (SQLException se2) {
            } // nothing we can do
            try {
                if (conn != null) {
					conn.close();
				}
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
        return id;
}





/**  
 * @author u1598
 * @date 04/08/2024
 * @description : Method is used to login
 * @param : 
 * 			userName - user name of the user
 * 			password - password of the user
 * @return : none
 */
//
//public static Map<String, String> getDataFromExcel(String excelPath, String sheetName) throws Exception {
//    FileInputStream fis = new FileInputStream(excelPath);
//    Workbook workbook = new XSSFWorkbook(fis);
//    Sheet sheet = workbook.getSheet(sheetName);
//
//    Map<String, String> dataMap = new HashMap<>();
//    for (Row row : sheet) {
//        Cell keyCell = row.getCell(0); // First column: Parameter Name
//        Cell valueCell = row.getCell(1); // Second column: Value
//
//        if (keyCell != null && valueCell != null) {
//            keyCell.setCellType(CellType.STRING);
//            valueCell.setCellType(CellType.STRING);
//            dataMap.put(keyCell.getStringCellValue().trim(), valueCell.getStringCellValue().trim());
//        }
//    }
//
//    workbook.close();
//    fis.close();
//    return dataMap;
//}
//
//public static String getValueFromExcel(String excelPath, String sheetName, String key) throws Exception {
//    Map<String, String> dataMap = getDataFromExcel(excelPath, sheetName);
//    return dataMap.getOrDefault(key, ""); // Return the value or an empty string if the key is not found
//}
//}
/**  
 * @author u1598
 * @date 04/08/2024
 * @description : Method is used to enter text in text field     // for following pom design pattern
 * @param : 
 * 			userName - user name of the user
 * 			password - password of the user
 * @return : none
 */
public static void enterTextFromExcel(String parameterNameinDataSheet,WebElement ele)throws Exception{

	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
	ele.sendKeys(excelParameters.get(parameterNameinDataSheet));
	Thread.sleep(2000);
}
/**  
 * @author u1756
 * @date 01/07/2024
 * @description : Method is used add the attachment name 
 * @param : parameterNameinDataSheet     - attachment filed name // for pom design pattern
 * 			strLocator -locator if <input type=file..> element
 * 			
 * 			
 * @return : none
 */
public static void browseAttachmentp(String filename,WebElement elem)throws Exception{

	String strFullFileName=System.getProperty("user.dir")+"/Test_Data/"+filename;

	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elem);

	elem.sendKeys(strFullFileName);
	Thread.sleep(2000);
}
/**  
 * @author u1756
 * @date 01/07/2024
 * @description : To click the element with scroll
 * @param : parameterNameinDataSheet     - attachment filed name // for pom design pattern
 * 			strLocator -locator if <input type=file..> element
 * 			
 * 			
 * @return : none
 */
public static void clickwithscroll(WebElement ele) {
	//WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(strLocator)));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);

	if (ele.isEnabled()) {
		try {
			ele.click();
		} catch (ElementClickInterceptedException e) {
			// Use JavaScript to click if normal click is intercepted


			((JavascriptExecutor) driver).executeScript("arguments[0].click();", ele);
		}
	}
}
}
	
	
	
	
	
	
	
	
