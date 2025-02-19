package com.ospyn.ktu.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper;


public class SeleniumConfig {

	WebDriver driver;

	ConfigurationProperties deepConfig;

	static SeleniumConfig seleniumConfig;

	public static SeleniumConfig getInstance() {

		if (null == seleniumConfig) {

			seleniumConfig = new SeleniumConfig();

		}

		return seleniumConfig;

	}

	public SeleniumConfig() {

		loadConfig();

	}

	public WebDriver getDriver() {

		if (null == driver) {

			if (deepConfig.getBrowser().equals("chrome")) {
				System.out.println("chrome");

				System.setProperty("webdriver.chrome.driver", deepConfig.getDriverPath().getChrome());
				driver = new ChromeDriver();

			}

			if (deepConfig.getBrowser().equals("firefox")) {

				System.setProperty("webdriver.gecko.driver", deepConfig.getDriverPath().getFirefox());
				driver = new FirefoxDriver();

			}

			driver.manage().deleteAllCookies();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			driver.get(deepConfig.getUrl());
			driver.manage().window().maximize();
//			FirefoxOptions options=new FirefoxOptions();
//            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			
		}

		return driver;

	}

	public void setDriver(WebDriver driver) {

		this.driver = driver;

	}

	public ConfigurationProperties getDeepConfig() {

		return deepConfig;

	}

	public void setDeepConfig(ConfigurationProperties deepConfig) {

		this.deepConfig = deepConfig;

	}

	public void loadConfig() {

		try (InputStream input = SeleniumConfig.class.getClassLoader().getResourceAsStream("config.properties")) {

			JavaPropsMapper mapper = new JavaPropsMapper();

			deepConfig = mapper.readValue(input, ConfigurationProperties.class);

			//System.out.println(mapper.writeValueAsString(deepConfig));

		} catch (IOException ex) {

			ex.printStackTrace();

		}

	}

}
