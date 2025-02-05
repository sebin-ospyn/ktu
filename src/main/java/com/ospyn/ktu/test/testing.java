package com.ospyn.ktu.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testing {
	
	
	
@BeforeMethod
private void syso() {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.orangehrm.com/");
}
@Test
public void cc()
{
	System.out.println("testing");
}
@AfterClass
public void sysss()
{
}
}
