package com.ospyn.ktu.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test2 {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","/home/u1780/MainProject/KTU_AutomationTestNG/Driver_new/chromedriver");
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8080/university/eu/uty/universityDashBoard.htm");
	}

}
