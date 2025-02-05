package com.ospyn.ktu.test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test3_cv {
	@Test
public void m1()throws InterruptedException {
	System.setProperty("webdriver.chrome.driver","/home/u1780/MainProject/KTU_AutomationTestNG/Driver_new/chromedriver");
	WebDriver driver=new ChromeDriver();
	driver.get("http://localhost:5173/verificationPortal/");
	Thread.sleep(1000);
//	driver.manage().window().maximize();
	driver.findElement(By.xpath("//input[@name='registerNumber']")).sendKeys("NSS19ME035");
	driver.findElement(By.xpath("//input[@name='dob']")).sendKeys("26,04,2000");
//	Thread.sleep(1000);
	driver.findElement(By.xpath("//span[text()='Search']")).click();
	Thread.sleep(1000);
//	String str2 = driver.findElement(By.xpath("//table[@class='table']/tbody/tr/td[2]")).getText();
//	System.out.println(str2);
	
	String ExpectText="No records found for the provided Register Number and Date of Birth.";
	
	String ActualText= driver.findElement(By.xpath("//span[text()='No records found for the provided Register Number and Date of Birth.']")).getText();
	Assert.assertEquals(ExpectText, ActualText);
	System.out.println("test passed");
	driver.close();
	}
}
