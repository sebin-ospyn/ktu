package com.ospyn.ktu.view;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ospyn.ktu.util.SeleniumBase;

public class KTUWebElements  extends SeleniumBase
{
	/************************************
	 ************ Main Tabs***************
	 *************************************/


	//University Tab
	@FindBy(xpath = "//a[text()='University']")
	WebElement university;

	//Affiliation Tab
	@FindBy(xpath = "//a[text()='Affiliation']")
	WebElement affiliation;

	//Academics tab
	@FindBy(xpath = "//a[text()='Academics']")
	WebElement academics;

	//Academic Auditing Tab
	@FindBy(xpath = "//a[text()='Academic Auditing']")
	WebElement academicAuditing;

	//Student tab
	@FindBy(xpath = "//a[text()='Student']")
	WebElement student;

	//Exam tab
	@FindBy(xpath = "//a[text()='Exam']")
	WebElement exam;


	//Result tab

	@FindBy(xpath = "//a[text()='Result']")
	WebElement result;

	//Research tab
	@FindBy(xpath = "//a[text()='Research']")
	WebElement research;


	//Question Paper tab
	@FindBy(xpath = "//a[text()='Question Paper']")
	WebElement questionPaper;

	//Valuation tab
	@FindBy(xpath = "//a[text()='Valuation']")
	WebElement valuation;

	//Revaluation tab
	@FindBy(xpath = "//a[text()='Revaluation']")
	WebElement revaluation;

	//Payment tab
	@FindBy(xpath = "//a[text()='Payment']")
	WebElement payment;

	//NSS tab
	@FindBy(xpath = "//a[text()='NSS']")
	WebElement nss;

	//Grievance Redressal Ticket
	@FindBy(xpath = "//a[text()='Grievance Redressal Tickets']")
	WebElement grievanceRedressalTickets;


	//Forms tab
	@FindBy(xpath = "//a[text()='Forms']")
	WebElement forms;

	//Forms tab
	@FindBy(xpath = "//a[text()='Certificate']")
	WebElement certificate;

	//Finance tab
	@FindBy(xpath = "//a[text()='Finance']")
	WebElement finance;

	/************************************
	 ****Side menu options-University****
	 *************************************/

	@FindBy(xpath = "//a[text()='University Inbox']")
	WebElement universityInbox;



	@FindBy(xpath="//a[text()='Invitations']")
	WebElement invitations;


	/************************************
	 ****Side menu options-Academics*****
	 ************************************/


	@FindBy(xpath="//a[text()='Course Details']")
	WebElement courseDetails;


	/************************************
	 *Side menu options-Academic Auditing*
	 **************************************/

	@FindBy(xpath = "//a[text()='Course Mapping']")
	WebElement courseMapping;


	/************************************
	 *Side menu options-Exam*
	 **************************************/

	@FindBy(xpath = "//a[text()='Exam Definition']")
	WebElement examDefinition;

	//Exam Time Table/Hall Ticket

	@FindBy(xpath = "//a[text()='Exam Time Table/Hall Ticket']")
	WebElement hallTicket;


	/************************************
	 ******* *Page Elements************
	 ************************************/
	//University-->Invitation-->Add
	@FindBy(xpath = "//a[@id='add']")
	WebElement add;

	//University-->Invitation-->Course Selection/Course Mapping-->Back
	@FindBy(xpath = "//a[@id='back']")
	WebElement back;

	//University-->Invitation-->Course Selection/Course Mapping-->Save
	@FindBy(xpath = "//button[@value='Save']")
	WebElement save;

	//University-->Invitation-->Course Selection/Course Mapping-->Submit
	@FindBy(xpath = "//button[@value='Submit']")
	WebElement submit;

	//University-->Invitation-->Course Selection/Course Mapping-->Verify
	@FindBy(xpath = "//button[@value='Verify']")
	WebElement verify;

	//University-->Invitation-->Course Selection/Course Mapping-->Approve
	@FindBy(xpath = "//button[@value='Approve']")
	WebElement approve;

	//Exam-->Exam Definition Listing-->Search
	@FindBy(xpath = "//*[@value='Search']")
	WebElement search;

	//Exam-->Exam Time Table/Hall Ticket-->Add Exam Timetable
	@FindBy(xpath = "//*[@value='Generate']")
	WebElement generate;

	//Exam-->Exam Time Table/Hall Ticket-->View Time Table/Hall Ticket
	@FindBy(xpath = "//a[text()=' View Time Table/Hall Ticket']")
	WebElement viewHallTicket;

	//Exam-->Exam Time Table/Hall Ticket-->View Time Table
	@FindBy(xpath = "//button[@value='View Time Table']")
	WebElement viewTimeTable;

	//Exam-->Exam Time Table/Hall Ticket-->generate Hall Ticket
		@FindBy(xpath = "//button[text()='Generate Hall Ticket']")
		WebElement generateHallticket;

	public KTUWebElements(WebDriver driver)
	{
		super(driver);
	}


	public WebElement getUniversity()
	{
		return university;
	}

	public WebElement getAffiliation()
	{
		return affiliation;
	}

	public WebElement getAcademics()
	{
		return academics;

	}

	public WebElement getAcademicAuditing()
	{
		return academicAuditing;
	}

	public WebElement getStudent()
	{
		return student;
	}

	public WebElement getExam()
	{
		return exam;
	}

	public WebElement getResult()
	{
		return result;
	}

	public WebElement getResearch()
	{
		return research;
	}

	public WebElement getQuestionPaper()
	{
		return questionPaper;
	}

	public WebElement getValuation()
	{
		return valuation;
	}

	public WebElement getRevaluation()
	{
		return revaluation;
	}

	public WebElement getPayment()
	{
		return payment;
	}

	public WebElement getNSS()
	{
		return nss;
	}

	public WebElement getGrievanceRedressalTickets()
	{
		return grievanceRedressalTickets;
	}

	public WebElement getForms()
	{
		return forms;
	}

	public WebElement getCertificate()
	{
		return certificate;
	}
	public WebElement getFinance()
	{
		return finance;
	}

	public WebElement getUniversityInbox()
	{
		return universityInbox;
	}

	public WebElement getInvitations()
	{
		return invitations;
	}

	public WebElement getCourseDetails()
	{
		return courseDetails;
	}

	public WebElement getCourseMapping()
	{
		return courseMapping;
	}

	public WebElement getAdd()
	{
		return add;
	}

	public WebElement getBack()
	{
		return back;
	}

	public WebElement getSave()
	{
		return save;
	}

	public WebElement getSubmit()
	{
		return submit;
	}
	public WebElement getVerify()
	{
		return verify;
	}
	public WebElement getApprove()
	{
		return approve;
	}

	public WebElement getExamDefinition()
	{
		return examDefinition;
	}

	public WebElement getSearch()
	{
		return search;
	}

	public WebElement getGenerate()
	{
		return generate;
	}

	public WebElement getHallTicket()
	{
		return hallTicket;
	}

	public WebElement getViewHallTicket()
	{
		return viewHallTicket;
	}
	public WebElement getViewTimeTable()
	{
		return viewTimeTable;
	}
	public WebElement getGenerateHallTicket()
	{
		return generateHallticket;
	}
}
