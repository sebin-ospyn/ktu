package com.ospyn.ktu.test;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

// This class consists of configuration annotation methods which are used for opening the browser and closing the browser
public class BaseClass {
public WebDriver driver;
@BeforeClass
public void setup()
{
	WebDriverManager.chromedriver().setup();
	 driver= new ChromeDriver();
	
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.get("http://localhost:5173/verificationPortal/");
	driver.manage().window().maximize();
	
		
}
//@AfterClass
//public void teardown()
//{
//	driver.quit();
//}

}
