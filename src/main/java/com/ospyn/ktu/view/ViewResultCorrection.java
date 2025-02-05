package com.ospyn.ktu.view;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ospyn.ktu.util.SeleniumBase;
import com.ospyn.ktu.util.ViewCommonUtil;

public class ViewResultCorrection extends SeleniumBase {



	public ViewResultCorrection(WebDriver driver)throws Exception {

		super(driver);
		ViewCommonUtil.readFromExcel("PARAMETER_LISTING.xlsx","ResultCorrection");
	}
	
	public void loginasAdExam() throws Exception
	{
		ViewCommonUtil.logIn("LoginAsAdexam","Password");
	}
	
	public void loginasStudent1() throws Exception
	
	
	{
		ViewCommonUtil.logIn("Student1", "Password");
	}
	public void loginasStudent2() throws Exception
	{
		ViewCommonUtil.logIn("Student2", "Password");
	}
	public void loginasStudent3() throws Exception 
	{
		ViewCommonUtil.logIn("Student3", "Password");
	}
	
	public void logout() throws Exception
	{
		ViewCommonUtil.logOut();
	}
	
	public String performStudentActions2() throws Exception
	{
		ViewCommonUtil.click("//a[normalize-space()='Student']");
		driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ViewCommonUtil.click("//div[@align='right']//a[@id='viewProfile']");
		driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ViewCommonUtil.click("//button[@id='examResultTab']");
		driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String a=ViewCommonUtil.getExcelParameters("Exam Definition");
//		System.out.println(a);
		String xpath1="//label[text()='"+a+"']/following::a[text()='Examination Grades']";
		ViewCommonUtil.click(xpath1);
		driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String currentWindow = driver.getWindowHandle();
		driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		for (String windowHandle : driver.getWindowHandles()) {
	        if (!windowHandle.equals(currentWindow)) {
	            driver.switchTo().window(windowHandle); // Switch to new tab
	            break; // Exit the loop once switched
	        }
	    }
		 // You can now perform actions in the new tab
		
		driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement text123 = driver.findElement(By.xpath("//td[text()='ENGINEERING MECHANICS - ']/following-sibling::td[2]"));
		String gradeAfterMarkCorrection=text123.getText();
//		System.out.println("Grade After Mark correction = "+gradeAfterMarkCorrection);
		
	    driver.close();
		driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    // If you need to switch back to the original tab later
	    driver.switchTo().window(currentWindow);
	    Thread.sleep(1000);
	    
//	    String exp = ViewCommonUtil.getExcelParameters("Excepted Grade");
//	    System.out.println(exp);
//	    Assert.assertEquals(gradeAfterMarkCorrection, exp);
//	    System.out.println("validation done");
	    return gradeAfterMarkCorrection;
	}
	
	//**
	public String performStudentActions1() throws Exception
	{
		ViewCommonUtil.click("//a[normalize-space()='Student']");
		driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ViewCommonUtil.click("//div[@align='right']//a[@id='viewProfile']");
		driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ViewCommonUtil.click("//button[@id='examResultTab']");
		driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String a=ViewCommonUtil.getExcelParameters("Exam Definition");
		System.out.println(a);
		driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String xpath1="//label[text()='"+a+"']/following::a[text()='Examination Grades']";
		ViewCommonUtil.click(xpath1);
		driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String currentWindow = driver.getWindowHandle();
		driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		for (String windowHandle : driver.getWindowHandles()) {
	        if (!windowHandle.equals(currentWindow)) {
	            driver.switchTo().window(windowHandle); // Switch to new tab
	            break; // Exit the loop once switched
	        }
	    }
		
		
		
		driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement text123 = driver.findElement(By.xpath("//td[text()='ENGINEERING MECHANICS - ']/following-sibling::td[2]"));
		String GradeBeforeMarkCorrection=text123.getText();
//		System.out.println("Grade Before  Mark correction = "+GradeBeforeMarkCorrection);
		
	    driver.close();
	    driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    // If you need to switch back to the original tab later
	    driver.switchTo().window(currentWindow);
	    driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    return GradeBeforeMarkCorrection;
	}
	
	
	public String performStudentActions3() throws Exception
	{
		ViewCommonUtil.click("//a[normalize-space()='Student']");
		driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ViewCommonUtil.click("//div[@align='right']//a[@id='viewProfile']");
		driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ViewCommonUtil.click("//button[@id='examResultTab']");
		driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String a=ViewCommonUtil.getExcelParameters("Exam Definition");
		System.out.println(a);
		driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String xpath1="//label[text()='"+a+"']/following::a[text()='Examination Grades']";
		ViewCommonUtil.click(xpath1);
		driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String currentWindow = driver.getWindowHandle();
		driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		for (String windowHandle : driver.getWindowHandles()) {
	        if (!windowHandle.equals(currentWindow)) {
	            driver.switchTo().window(windowHandle); // Switch to new tab
	            break; // Exit the loop once switched
	        }
	    }
		
		
		
		driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement text123 = driver.findElement(By.xpath("//td[text()='ENGINEERING MECHANICS - ']/following-sibling::td[2]"));
		String GradeBeforeMarkCorrection=text123.getText();
//		System.out.println("Grade Before  Mark correction = "+GradeBeforeMarkCorrection);
		
	    driver.close();
	    driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    // If you need to switch back to the original tab later
	    driver.switchTo().window(currentWindow);
	    driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    return GradeBeforeMarkCorrection;
	}
	public String performStudentActions4() throws Exception
	{
		ViewCommonUtil.click("//a[normalize-space()='Student']");
		driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ViewCommonUtil.click("//div[@align='right']//a[@id='viewProfile']");
		driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ViewCommonUtil.click("//button[@id='examResultTab']");
		driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String a=ViewCommonUtil.getExcelParameters("Exam Definition");
//		System.out.println(a);
		String xpath1="//label[text()='"+a+"']/following::a[text()='Examination Grades']";
		ViewCommonUtil.click(xpath1);
		driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String currentWindow = driver.getWindowHandle();
		driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		for (String windowHandle : driver.getWindowHandles()) {
	        if (!windowHandle.equals(currentWindow)) {
	            driver.switchTo().window(windowHandle); // Switch to new tab
	            break; // Exit the loop once switched
	        }
	    }
		 // You can now perform actions in the new tab
		
		driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement text123 = driver.findElement(By.xpath("//td[text()='ENGINEERING MECHANICS - ']/following-sibling::td[2]"));
		String gradeAfterMarkCorrection=text123.getText();
//		System.out.println("Grade After Mark correction = "+gradeAfterMarkCorrection);
		
	    driver.close();
		driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    // If you need to switch back to the original tab later
	    driver.switchTo().window(currentWindow);
	    Thread.sleep(1000);
	    
//	    String exp = ViewCommonUtil.getExcelParameters("Excepted Grade");
//	    System.out.println(exp);
//	    Assert.assertEquals(gradeAfterMarkCorrection, exp);
//	    System.out.println("validation done");
	    return gradeAfterMarkCorrection;
	}
	
	
	public void validate()
	{
		String expected=ViewCommonUtil.getExcelParameters("Exam Definition");
		System.out.println(expected);
		
	}
	
	public boolean perform() throws Exception 
	{
		boolean maxMark=false;
			ViewCommonUtil.click("//a[text()='Result']");
			ViewCommonUtil.click("//a[normalize-space()='Result Correction']");
			ViewCommonUtil.click("//a[@id='add']");
//			Thread.sleep(1000);
			ViewCommonUtil.selectDropDownItem("Academic Year", "//select[@id='academicYear']");
			ViewCommonUtil.selectDropDownItem("Program", "//select[@id='program']");
//			Thread.sleep(1000);
			ViewCommonUtil.selectDropDownItem("Exam Definition", "//select[@id='examDefinitionId']");
			ViewCommonUtil.enterTextinTextField("Course", "//input[@id='course']");
			ViewCommonUtil.enterKeyPress();
			
			ViewCommonUtil.enterTextinTextField("Student1", "//input[@id='student']");
//			Thread.sleep(1000);
			driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			ViewCommonUtil.enterKeyPress();
			Thread.sleep(2000);
			driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//*		
			ViewCommonUtil.click("//input[@id='markCorrection' and @value='1']");
			ViewCommonUtil.click("//input[@id='finalMark']");
//changed	ViewCommonUtil.click("//input[@id='valuationMark' and @value='1']");
			
//changed	ViewCommonUtil.enterTextinTextField("New Mark(Student1)", "//input[@id='newMark1']");
			ViewCommonUtil.enterTextinTextField("New Mark(Student1)", "//input[@id='newfinalMark']");
			//how do
			ViewCommonUtil.enterTextinTextField("Remarks", "//textarea[@id='remarks']");
			ViewCommonUtil.browseAttachment("File.pdf", "//input[@name='dataFile']");
			driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			ViewCommonUtil.click("//button[@id='searchForm_Submit']");
			ViewCommonUtil.click("(//button[@id='confirm' and text()='Yes'])[2]");
			
			Thread.sleep(1000);
			
//			String enteredMark = driver.findElement(By.xpath("//input[@id='newMark1']")).getAttribute("value");
	        
	
			//** Check if the entered mark is greater than 100
//	        int newMark = Integer.parseInt(enteredMark);
//	        
//	        System.out.println("sss");
//	        String mark;
//	        mark=ViewCommonUtil.getExcelParameters("Max marks for exam");
//	        int mar= Integer.parseInt(mark);
//	        
//	        if (newMark > mar) //
//	        {
//	        	maxMark=true;
//	        	System.out.println("Test stopped: The entered mark is greater than 100. Entered mark:");
//	        	return maxMark;
//	**        }
	        
//			driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	        ViewCommonUtil.click("//div[@id='saveModal']//button[@id='confirm']");
	        
			driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			ViewCommonUtil.click("//a[@title='Approve']");
//			Thread.sleep(2000);
			driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			ViewCommonUtil.click("//div[@id='confirmModel']//button[@id='confirm']");
//			Thread.sleep(1000);
			driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
//		Thread.sleep(3000);
		System.out.println("click");
		
		return maxMark;
		

	}
	
	public boolean perform2() throws Exception 
	{
		boolean maxMark=false;
			ViewCommonUtil.click("//a[text()='Result']");
			ViewCommonUtil.click("//a[normalize-space()='Result Correction']");
			ViewCommonUtil.click("//a[@id='add']");
//			Thread.sleep(1000);
			ViewCommonUtil.selectDropDownItem("Academic Year", "//select[@id='academicYear']");
			ViewCommonUtil.selectDropDownItem("Program", "//select[@id='program']");
//			Thread.sleep(1000);
			ViewCommonUtil.selectDropDownItem("Exam Definition", "//select[@id='examDefinitionId']");
			ViewCommonUtil.enterTextinTextField("Course", "//input[@id='course']");
			ViewCommonUtil.enterKeyPress();
			
			ViewCommonUtil.enterTextinTextField("Student2", "//input[@id='student']");
			Thread.sleep(1000);
			driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			ViewCommonUtil.enterKeyPress();
			Thread.sleep(1000);
			driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			ViewCommonUtil.click("//input[@id='markCorrection' and @value='1']");
			//input[@id='finalMark']
//changed	ViewCommonUtil.click("//input[@id='valuationMark' and @value='1']");
			ViewCommonUtil.click("//input[@id='finalMark']");
			ViewCommonUtil.enterTextinTextField("New marks(Student2)(marking as failed)", "//input[@id='newfinalMark']");
//changed	ViewCommonUtil.enterTextinTextField("New marks(Student2)(marking as failed)", "//input[@id='newMark1']");
			//how do
			ViewCommonUtil.enterTextinTextField("Remarks", "//textarea[@id='remarks']");
			ViewCommonUtil.browseAttachment("File.pdf", "//input[@name='dataFile']");
			ViewCommonUtil.click("//button[@id='searchForm_Submit']");
			
			Thread.sleep(1000);
			
//			String enteredMark = driver.findElement(By.xpath("//input[@id='newMark1']")).getAttribute("value");
	        
	
			//** Check if the entered mark is greater than 100
//	        int newMark = Integer.parseInt(enteredMark);
//	        
//	        System.out.println("sss");
//	        String mark;
//	        mark=ViewCommonUtil.getExcelParameters("Max marks for exam");
//	        int mar= Integer.parseInt(mark);
//	        
//	        if (newMark > mar) //
//	        {
//	        	maxMark=true;
//	        	System.out.println("Test stopped: The entered mark is greater than 100. Entered mark:");
//	        	return maxMark;
//	**        }
	        
	        
	        ViewCommonUtil.click("//div[@id='saveModal']//button[@id='confirm']");
	        
			driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			ViewCommonUtil.click("//a[@title='Approve']");
//			Thread.sleep(2000);
			driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			ViewCommonUtil.click("//div[@id='confirmModel']//button[@id='confirm']");
//			Thread.sleep(1000);
			driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
//		Thread.sleep(3000);
		System.out.println("click");
		
		return maxMark;
		

	}public boolean perform3() throws Exception 
	{
		boolean maxMark=false;
			ViewCommonUtil.click("//a[text()='Result']");
			ViewCommonUtil.click("//a[normalize-space()='Result Correction']");
			ViewCommonUtil.click("//a[@id='add']");
//			Thread.sleep(1000);
			ViewCommonUtil.selectDropDownItem("Academic Year", "//select[@id='academicYear']");
			ViewCommonUtil.selectDropDownItem("Program", "//select[@id='program']");
//			Thread.sleep(1000);
			ViewCommonUtil.selectDropDownItem("Exam Definition", "//select[@id='examDefinitionId']");
			ViewCommonUtil.enterTextinTextField("Course", "//input[@id='course']");
			ViewCommonUtil.enterKeyPress();
			
			ViewCommonUtil.enterTextinTextField("Student3", "//input[@id='student']");
			Thread.sleep(2000);
			driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			ViewCommonUtil.enterKeyPress();
			Thread.sleep(1000);
			driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			ViewCommonUtil.click("//input[@id='markCorrection' and @value='1']");
	//*		ViewCommonUtil.click("//input[@id='valuationMark' and @value='1']");
			driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			ViewCommonUtil.enterKeyPress();
			ViewCommonUtil.click("//input[@id='finalMark']");
			
			ViewCommonUtil.enterTextinTextField("New mark (Student3)(marking as passed)", "//input[@id='newfinalMark']");
			//how do
			ViewCommonUtil.enterTextinTextField("Remarks", "//textarea[@id='remarks']");
			ViewCommonUtil.browseAttachment("File.pdf", "//input[@name='dataFile']");
			ViewCommonUtil.click("//button[@id='searchForm_Submit']");
			
			Thread.sleep(1000);
			
//			String enteredMark = driver.findElement(By.xpath("//input[@id='newMark1']")).getAttribute("value");
	        
	
			//** Check if the entered mark is greater than 100
//	        int newMark = Integer.parseInt(enteredMark);
//	        
//	        System.out.println("sss");
//	        String mark;
//	        mark=ViewCommonUtil.getExcelParameters("Max marks for exam");
//	        int mar= Integer.parseInt(mark);
//	        
//	        if (newMark > mar) //
//	        {
//	        	maxMark=true;
//	        	System.out.println("Test stopped: The entered mark is greater than 100. Entered mark:");
//	        	return maxMark;
//	**        }
	        
	        
	        ViewCommonUtil.click("//div[@id='saveModal']//button[@id='confirm']");
	        
			driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			ViewCommonUtil.click("//a[@title='Approve']");
//			Thread.sleep(2000);
			driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			ViewCommonUtil.click("//div[@id='confirmModel']//button[@id='confirm']");
//			Thread.sleep(1000);
			driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
//		Thread.sleep(3000);
		System.out.println("click");
		
		return maxMark;
		

	}
	public void process_st1() throws Exception
	{
		ViewCommonUtil.click("//a[text()='Result Processing']");
		ViewCommonUtil.selectDropDownItem("Academic Year", "//select[@id='academicYear']");
		ViewCommonUtil.enterTextinTextField("Exam Definition", "//input[@id='searchForm_definitionName']");
		ViewCommonUtil.click("//button[@id='searchForm_search']");
		driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ViewCommonUtil.click("//a[@class='btn btn-warning btn-xs']");
		ViewCommonUtil.click("//a[normalize-space()='Student-wise result processing']");
		ViewCommonUtil.selectDropDownItem("Result Processing Type", "//select[@id='resultProcessingType']");
		ViewCommonUtil.enterTextinTextField("Student1","//div[@class='col-sm-4 clear-both']//input[1]" );
		ViewCommonUtil.enterKeyPress();
		
		ViewCommonUtil.click("//button[@id='studentResultProcessForm_search']");
		Thread.sleep(1000);
		driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ViewCommonUtil.click("//a[normalize-space()='Validate']");
		ViewCommonUtil.click("//div[@id='confirmModel']//button[@id='confirm']");
		Thread.sleep(1000);
		driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ViewCommonUtil.click("//button[@id='process']");
		
	
		try {
	        // Re-check for the element in a loop
	        WebElement ele;
	        while (true) {
	            try {
	                ele = driver.findElement(By.xpath("//a[normalize-space()='Show progress']"));
	                if (ele.isDisplayed()) {
	                    driver.navigate().refresh();
	                    Thread.sleep(3000);
	                    System.out.println("Refreshing due to progress shown.");
	                }
	            } catch (StaleElementReferenceException e) {
	                System.out.println("StaleElementReferenceException caught, trying again.");
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    System.out.println("Process completed.");
	    driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public void process_st2() throws Exception
	{
		ViewCommonUtil.click("//a[text()='Result Processing']");
		ViewCommonUtil.selectDropDownItem("Academic Year", "//select[@id='academicYear']");
		ViewCommonUtil.enterTextinTextField("Exam Definition", "//input[@id='searchForm_definitionName']");
		ViewCommonUtil.click("//button[@id='searchForm_search']");
		driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ViewCommonUtil.click("//a[@class='btn btn-warning btn-xs']");
		ViewCommonUtil.click("//a[normalize-space()='Student-wise result processing']");
		ViewCommonUtil.selectDropDownItem("Result Processing Type", "//select[@id='resultProcessingType']");
		ViewCommonUtil.enterTextinTextField("Student2","//div[@class='col-sm-4 clear-both']//input[1]" );
		ViewCommonUtil.enterKeyPress();
		
		ViewCommonUtil.click("//button[@id='studentResultProcessForm_search']");
		Thread.sleep(1000);
		driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ViewCommonUtil.click("//a[normalize-space()='Validate']");
		ViewCommonUtil.click("//div[@id='confirmModel']//button[@id='confirm']");
		Thread.sleep(1000);
		driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ViewCommonUtil.click("//button[@id='process']");
		
	
		try {
	        // Re-check for the element in a loop
	        WebElement ele;
	        while (true) {
	            try {
	                ele = driver.findElement(By.xpath("//a[normalize-space()='Show progress']"));
	                if (ele.isDisplayed()) {
	                    driver.navigate().refresh();
	                    Thread.sleep(3000);
	                    System.out.println("Refreshing due to progress shown.");
	                }
	            } catch (StaleElementReferenceException e) {
	                System.out.println("StaleElementReferenceException caught, trying again.");
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    System.out.println("Process completed.");
	    driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}	

	public void process_st3() throws Exception
	{
		ViewCommonUtil.click("//a[text()='Result Processing']");
		ViewCommonUtil.selectDropDownItem("Academic Year", "//select[@id='academicYear']");
		ViewCommonUtil.enterTextinTextField("Exam Definition", "//input[@id='searchForm_definitionName']");
		ViewCommonUtil.click("//button[@id='searchForm_search']");
		driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ViewCommonUtil.click("//a[@class='btn btn-warning btn-xs']");
		ViewCommonUtil.click("//a[normalize-space()='Student-wise result processing']");
		ViewCommonUtil.selectDropDownItem("Result Processing Type", "//select[@id='resultProcessingType']");
		ViewCommonUtil.enterTextinTextField("Student3","//div[@class='col-sm-4 clear-both']//input[1]" );
		ViewCommonUtil.enterKeyPress();
		
		ViewCommonUtil.click("//button[@id='studentResultProcessForm_search']");
		Thread.sleep(1000);
		driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ViewCommonUtil.click("//a[normalize-space()='Validate']");
		ViewCommonUtil.click("//div[@id='confirmModel']//button[@id='confirm']");
		Thread.sleep(1000);
		driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ViewCommonUtil.click("//button[@id='process']");
		
	
		try {
	        // Re-check for the element in a loop
	        WebElement ele;
	        while (true) {
	            try {
	                ele = driver.findElement(By.xpath("//a[normalize-space()='Show progress']"));
	                if (ele.isDisplayed()) {
	                    driver.navigate().refresh();
	                    Thread.sleep(3000);
	                    System.out.println("Refreshing due to progress shown.");
	                }
	            } catch (StaleElementReferenceException e) {
	                System.out.println("StaleElementReferenceException caught, trying again.");
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    System.out.println("Process completed.");
	    driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}		
	
	public void postprocess() throws InterruptedException
	{
		try {
			Thread.sleep(1000);
	        ViewCommonUtil.click("//button[@id='postProcessAll']");
	        Thread.sleep(1000); // Optional, can be replaced with a wait if needed
	        
	        // Loop to check for the element
	        WebElement ele;
	        while (true) {
	            try {
	                ele = driver.findElement(By.xpath("//a[normalize-space()='Show progress']"));
	                if (ele.isDisplayed()) {
	                    driver.navigate().refresh();
	                    Thread.sleep(3000);
	                    System.out.println("Refreshing due to progress shown.");
	                }
	            } catch (StaleElementReferenceException e) {
	                System.out.println("StaleElementReferenceException caught, trying again.");
	            } catch (NoSuchElementException e) {
	                // If the element is not found, you might want to break the loop
	                System.out.println("Element not found, exiting loop.");
	                break;
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    System.out.println("Post process completed.");
	}
		
	
	public void publish()
	{
		try {
	        ViewCommonUtil.click("//button[@id='generate']");
	        Thread.sleep(1000); // Optional, can be replaced with a wait if needed
	        
	        // Loop to check for the element
	        WebElement ele;
	        while (true) {
	            try {
	                ele = driver.findElement(By.xpath("//a[normalize-space()='Show progress']"));
	                if (ele.isDisplayed()) {
	                    driver.navigate().refresh();
	                    Thread.sleep(3000);
	                    System.out.println("Refreshing due to progress shown.");
	                }
	            } catch (StaleElementReferenceException e) {
	                System.out.println("StaleElementReferenceException caught, trying again.");
	            } catch (NoSuchElementException e) {
	                // If the element is not found, you might want to break the loop
	                System.out.println("Element not found, exiting loop.");
	                break;
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    System.out.println("Publish completed.");
	}
	public String checkMarkBefore() throws Exception
	{
		ViewCommonUtil.click("//a[text()='Result']");
		ViewCommonUtil.click("//a[@href='/university/eu/res/examCourseStudentResultsListing.htm']");
		ViewCommonUtil.selectDropDownItem("Academic Year", "//select[@id='academicYear']");
		ViewCommonUtil.selectDropDownItem("Program", "//select[@id='programId']");
		Thread.sleep(1000);
		ViewCommonUtil.selectDropDownItem("Exam Definition", "//select[@id='examDefinition']");
		ViewCommonUtil.selectDropDownItem("Cluster", "//select[@id='orgId']");	
		
		ViewCommonUtil.enterTextinTextField("Course", "//input[@id='courseId']");
		ViewCommonUtil.enterKeyPress();
		ViewCommonUtil.enterTextinTextField("Student1","//input[@id='student']");
		ViewCommonUtil.enterKeyPress();
		ViewCommonUtil.click("//button[@id='resultFilterForm_search']");
		String st1 = driver.findElement(By.xpath("//tbody//tr//td[19]")).getText();
		System.out.println("Before mark correction ="+st1);
		return st1;
		
	}
	public String checkMarkAfter() throws Exception
	{
		ViewCommonUtil.click("//a[text()='Result']");
		ViewCommonUtil.click("//a[@href='/university/eu/res/examCourseStudentResultsListing.htm']");
		ViewCommonUtil.selectDropDownItem("Academic Year", "//select[@id='academicYear']");
		ViewCommonUtil.selectDropDownItem("Program", "//select[@id='programId']");
		ViewCommonUtil.selectDropDownItem("Exam Definition", "//select[@id='examDefinition']");
		ViewCommonUtil.selectDropDownItem("Cluster", "//select[@id='orgId']");	
		
		ViewCommonUtil.enterTextinTextField("Course", "//input[@id='courseId']");
		ViewCommonUtil.enterKeyPress();
		ViewCommonUtil.enterTextinTextField("Student1","//input[@id='student']");
		ViewCommonUtil.enterKeyPress();
		ViewCommonUtil.click("//button[@id='resultFilterForm_search']");
		String st2 = driver.findElement(By.xpath("//tbody//tr//td[19]")).getText();
//		String st=driver.findElement(By.xpath("//tbody//tr//td[10]")).getText();
		System.out.println("After mark correction ="+st2);
		return st2;
	}
	public String checkMarkAfter2() throws Exception
	{
		ViewCommonUtil.click("//a[text()='Result']");
		ViewCommonUtil.click("//a[@href='/university/eu/res/examCourseStudentResultsListing.htm']");
		ViewCommonUtil.selectDropDownItem("Academic Year", "//select[@id='academicYear']");
		ViewCommonUtil.selectDropDownItem("Program", "//select[@id='programId']");
		ViewCommonUtil.selectDropDownItem("Exam Definition", "//select[@id='examDefinition']");
		ViewCommonUtil.selectDropDownItem("Cluster", "//select[@id='orgId']");	
		
		ViewCommonUtil.enterTextinTextField("Course", "//input[@id='courseId']");
		ViewCommonUtil.enterKeyPress();
		ViewCommonUtil.enterTextinTextField("Student1","//input[@id='student']");
		ViewCommonUtil.enterKeyPress();
		ViewCommonUtil.click("//button[@id='resultFilterForm_search']");
		String st=driver.findElement(By.xpath("//tbody//tr//td[10]")).getText();
//		System.out.println("Corrected mark = "+st);
		return st;
	}
	public String fetchExcelMark()
	{
		String givenMark=ViewCommonUtil.getExcelParameters("New Mark(Student1)");
		return givenMark;
	}
	public String fetchExcelFailGrade()
	{
		String grade=ViewCommonUtil.getExcelParameters("Excepted Grade");
		return grade;
	}
}
