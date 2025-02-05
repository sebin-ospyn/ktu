package com.ospyn.ktu.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.ospyn.ktu.util.SeleniumBase;

public class ViewInvitations extends SeleniumBase{


	public ViewInvitations(WebDriver driver) {

		super(driver);

	}

	public WebElement getCourseSelection()
	{
		WebElement courseSelection=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//td[text()='Course Selection/Course Mapping']//following::a[1]")));

		return courseSelection;
	}

	public void enterDetails(String invitationDetails)throws Exception
	{
		List<String> params= new ArrayList<>();
		params = Arrays.asList(invitationDetails.split(","));

		//selecting academic year
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='fromAcademicYearId']")));

		Select dropdown = new Select(element);

		////passing the Academic year
		dropdown.selectByVisibleText(params.get(0));

		Thread.sleep(2000);

		//entering the process description

		element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='name']")));

		element.sendKeys(params.get(1));

		Thread.sleep(2000);


		//entering toDate

		element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='toDate']")));

		element.sendKeys(params.get(2));


		Thread.sleep(2000);

		//Selecting the duration type
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='durationTypeId']")));

		dropdown = new Select(element);


		dropdown.selectByVisibleText(params.get(3));

		Thread.sleep(2000);

		element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='registrationType']")));

		dropdown = new Select(element);

		////passing the type
		dropdown.selectByVisibleText(params.get(4));

		Thread.sleep(2000);

		//Selecting the program(B.Tech,M.Tech...)

		element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@name='programId']")));

		dropdown = new Select(element);

		dropdown.selectByVisibleText(params.get(5));

		Thread.sleep(2000);

		//Selecting the Program type(Full Time/Part Time)

		element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@name='programTypeId']")));

		dropdown = new Select(element);

		dropdown.selectByVisibleText(params.get(6));

		Thread.sleep(2000);

		//Selecting the Semester
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@name='semesterId']")));

		dropdown = new Select(element);

		dropdown.selectByVisibleText(params.get(7));

		Thread.sleep(2000);
		System.out.println("sceme is "+params.get(8));

		element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@name='schemeId']")));

		dropdown = new Select(element);

		dropdown.selectByVisibleText(params.get(8));

		Thread.sleep(2000);


	}
	public String enterSearchDetails(String invitationDetails)throws Exception
	{
		String status="";
		List<String> params= new ArrayList<>();
		params = Arrays.asList(invitationDetails.split(","));

		//selecting academic year
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='processAcdYearId']")));

		Select dropdown = new Select(element);

		////passing the Academic year
		dropdown.selectByVisibleText(params.get(0));

		Thread.sleep(2000);

		//entering the process description

		element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='processTypeId']")));

		dropdown = new Select(element);


		dropdown.selectByVisibleText(params.get(1));

		Thread.sleep(2000);
		try
		{
			/*if the element is displayed, then it confirms that the invitation details are successfully saved
			 * Then pass will be returned...Else fail
			 */

			element = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[text()='"+params.get(2)+"']")));

			if(element.isDisplayed())
			{
				status="pass";
			}
		}
		catch(Exception e)
		{
			status="fail";
		}
		return status;

	}
	public String validateDuplicate()
	{

		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='alert alert-danger col-sm-12']")));

		return element.getText();


	}


}