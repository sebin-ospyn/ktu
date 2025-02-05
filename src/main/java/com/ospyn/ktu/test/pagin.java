package com.ospyn.ktu.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.ospyn.ktu.util.DriverConfig;
import com.ospyn.ktu.util.GenerateExtentReport;
import com.ospyn.ktu.util.Screenshot;
import com.ospyn.ktu.util.ViewLogin;

import io.github.bonigarcia.wdm.WebDriverManager;

public class pagin extends DriverConfig{

	
	// creating reference for Login
		static ViewLogin login;
		
		static GenerateExtentReport report = Login.report;
		static boolean flag=false;
		
		// Creating reference for extracting screenshots of failed test
		Screenshot screenshot;

		// Creating static variable for adding details to log
		static String details;
		
		WebDriver driver;
		WebElement element;
		// creating a variable for assigning the test name before each test
		String[] testName;
		
		@Test
		public void m3()
		{
			System.out.println("sys");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.get("http://localhost:8080/university/login.htm");
		}
}
