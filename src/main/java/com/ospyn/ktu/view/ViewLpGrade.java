package com.ospyn.ktu.view;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ospyn.ktu.util.SeleniumBase;
import com.ospyn.ktu.util.ViewCommonUtil;

public class ViewLpGrade extends SeleniumBase 
{
	public ViewLpGrade(WebDriver driver)throws Exception 
	{
		super(driver);
		ViewCommonUtil.readFromExcel("PARAMETER_LISTING.xlsx","LowPass");
	}
	
	
	public void loginasAdExam() throws Exception
	{
		ViewCommonUtil.logIn("LoginAsAdexam","Password");
	}
	
	public void loginasStudent() throws Exception
	{
		ViewCommonUtil.logIn("Student", "Password");
	}
	public void logout() throws Exception
	{
		ViewCommonUtil.logOut();
	}
	
	public void applyLP() throws InterruptedException
	{
		ViewCommonUtil.click("//a[text()='Result']");
		driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ViewCommonUtil.click("//a[normalize-space()='Request Low Pass Grade']");
		driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ViewCommonUtil.click("//a[@id='generate']");
		Thread.sleep(1000);
		ViewCommonUtil.click("//input[@id='courseCheck']");
		Thread.sleep(1000);
		ViewCommonUtil.click("//button[@id='submitBtn']");
		Thread.sleep(1000);
		ViewCommonUtil.click("//div[@id='saveModal']//button[@id='confirm']");
		Thread.sleep(1000);
	}
	
	public void process() throws Exception
	{
		driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ViewCommonUtil.click("//a[text()='Result']");
		ViewCommonUtil.click("//a[text()='Result Processing']");
		System.out.println("tete");
		driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(1000);
		ViewCommonUtil.selectDropDownItem("Academic Year", "//select[@id='academicYear']");
		System.out.println("tete");
		ViewCommonUtil.enterTextinTextField("Exam Definition", "//input[@id='searchForm_definitionName']");
		ViewCommonUtil.click("//button[@id='searchForm_search']");
		driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ViewCommonUtil.click("//a[@class='btn btn-warning btn-xs']");
		ViewCommonUtil.click("//a[normalize-space()='Student-wise result processing']");
		ViewCommonUtil.selectDropDownItem("Result Processing Type", "//select[@id='resultProcessingType']");
		ViewCommonUtil.enterTextinTextField("Student","//div[@class='col-sm-4 clear-both']//input[1]" );
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
	public String checkLPGradeasStudent() throws InterruptedException
	{
		ViewCommonUtil.click("//a[normalize-space()='Student']");
		ViewCommonUtil.click("//div[@align='right']//a[@id='viewProfile']");
		ViewCommonUtil.click("//b[normalize-space()='Curriculum']");
		 String sem = ViewCommonUtil.getExcelParameters("Semester");
		 System.out.println(sem);
		ViewCommonUtil.click("//a[normalize-space()='"+sem+"']");		
		String courseName = ViewCommonUtil.getExcelParameters("CourseName");
		System.out.println(courseName);
		Thread.sleep(2000);
		String grade = driver.findElement(By.xpath("//*[contains(text(),'"+courseName+"')]//following::td[6]")).getText();
		System.out.println(grade);
		return grade;
		
		
		//*[contains(text(),'ENGINEERING GRAPHICS')]//following::td[6]
		
	}
	public void CheckAvailedNumber() throws InterruptedException
	{
		driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		ViewCommonUtil.click("//a[normalize-space()='Result']");
		ViewCommonUtil.click("//a[normalize-space()='Request Low Pass Grade']");
		Thread.sleep(1000);
		String text = driver.findElement(By.xpath("//span[@data-toggle='tooltip'][2]")).getText();
		System.out.println(text);
		
		
	}
}
