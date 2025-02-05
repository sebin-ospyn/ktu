package com.ospyn.ktu.util;

import org.openqa.selenium.WebDriver;


//import io.cucumber.java.Scenario;

public class DriverConfig {

	protected SeleniumConfig config;

	//protected ScenarioContext context;

//	protected WebDriver driver;
	protected WebDriver driver;

	protected WebDriver getDriver(){

		if(null == driver) {

			SeleniumConfig config = SeleniumConfig.getInstance();

			driver = config.getDriver();

		}

		return driver;

	}



}
