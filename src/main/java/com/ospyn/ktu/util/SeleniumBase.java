package com.ospyn.ktu.util;

import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import io.cucumber.java.Scenario;

public class SeleniumBase {

	protected static WebDriver driver;

	protected static WebDriverWait wait;



	protected SeleniumBase(WebDriver driver) {

		this.driver = driver;

		wait = new WebDriverWait(driver, 15, 50);

		PageFactory.initElements(driver, this);


	}

	protected WebElement getElementWithWait(WebElement webElement){

		return wait.until(ExpectedConditions.visibilityOf(webElement));

	}

	public Boolean waitUntilAjaxLoaded() {

		WebElement element = driver.findElement(By.xpath("//*[@id='ajaxLoader']"));

		return wait.until(ExpectedConditions.invisibilityOf(element));

	}

}
