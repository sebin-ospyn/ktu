package com.ospyn.ktu.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {

	public void captureScreenshot(String fileName,WebDriver driver)
	{
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./Screenshots/"+fileName);
		try
		{
			FileUtils.copyFile(sourceFile, destFile);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		System.out.println("Screenshot saved successfully");
	}
}
