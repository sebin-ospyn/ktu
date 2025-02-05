package com.ospyn.ktu.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.ospyn.ktu.util.SeleniumBase;

public class ViewDataProviderSample extends SeleniumBase
{
	//getting elements by xpath
	@FindBy(xpath = "//a[text()='Exam']")
	WebElement exam;

	@FindBy(xpath = "//a[text()='Student Attendance/Internals']")
	WebElement attendanceInternals;

	@FindBy(xpath = "//*[@id='branchListingForm_search']")
	WebElement search;

	@FindBy(xpath = "//a[text()='Student Internals/Attendance']")
	WebElement studentAttendance;

	static String[][] facultyData=new String[6][2];



	public ViewDataProviderSample(WebDriver driver)

	{
		//initializing the driver
		super(driver);


	}

	//returning Exams tab

	public WebElement getExam()
	{
		return exam;
	}
	//returning Student Attendance/Internals option from the side menu

	public WebElement getAttendancseInternal()

	{

		return attendanceInternals;

	}

	public WebElement getAttendanceButton()

	{

		return studentAttendance;

	}
	public Object[][] getFacultyData()
	{
		return facultyData;
	}


	//returning search button
	public WebElement getSearch()
	{
		return search;
	}
	//Entering search criteria
	public void enterDetails(String courseDetails) throws InterruptedException

	{
		//Parameters
		List<String> parameters = new ArrayList<>();
		parameters = Arrays.asList(courseDetails.split(","));

		//Getting the academic year(Eg:2022 - 2023)
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='academicYearId']")));

		//Using dropdown to select the Year
		Select dropDown = new Select(element);

		//Selecting the parameter passed, from the dropdown
		dropDown.selectByVisibleText(parameters.get(0));

		Thread.sleep(1000);

		//Selecting Program(B.Tech/M.Tech/...)
		element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='programId']")));
		dropDown = new Select(element);


		dropDown.selectByVisibleText(parameters.get(1));
		Thread.sleep(1000);


		//Getting the type(Full Time/Part Time/PhD)
		element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='programType']")));

		dropDown=new Select(element);
		dropDown.selectByVisibleText(parameters.get(2));
		Thread.sleep(1000);

		//Getting the Semester(S1/S2/....)
		element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='semesterId']")));

		dropDown=new Select(element);
		dropDown.selectByVisibleText(parameters.get(3));

		Thread.sleep(1000);

		//Getting the Degree Type(Regular/Honors/Minor)
		element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='registrationAllowedStudentStatus']")));

		dropDown=new Select(element);
		dropDown.selectByVisibleText(parameters.get(4));
		Thread.sleep(1000);


		element=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='degreeType']")));

		dropDown=new Select(element);
		dropDown.selectByVisibleText(parameters.get(5));
		Thread.sleep(1000);
		// Reusing the same function for different search criteria based on the parameters passed


	}


	public void getFacultyDetails()
	{
		List<WebElement> faculties=driver.findElements(By.xpath("//table[@id='programDetail']//tr//td[2]"));
		List<WebElement> courses=driver.findElements(By.xpath("//table[@id='programDetail']//tr//td[1]"));
		System.out.println(faculties.size());

		for(int i=0;i<faculties.size();i++)
		{
			facultyData[i][0]=faculties.get(i).getText();
			System.out.print(faculties.get(i).getText()+"   ");

			facultyData[i][1]=courses.get(i).getText();
			System.out.println(courses.get(i).getText());


		}




	}

}
