package com.ospyn.ktu.view;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

// this class consists of only constructor, also this page is extended by every other page object class

public class BasePage {
WebDriver driver;

public BasePage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
}
