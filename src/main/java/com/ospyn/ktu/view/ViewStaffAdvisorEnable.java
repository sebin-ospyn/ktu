package com.ospyn.ktu.view;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.ospyn.ktu.util.SeleniumBase;

public class ViewStaffAdvisorEnable extends SeleniumBase {
	//	****************************************
	@FindBy(xpath = "//*[@class='moduleclass']/a[contains(text(),'Academic Auditing')]")
	WebElement AcademicAuditing;
	@FindBy(xpath = "//a[text()='Exam']")
	WebElement exam;
	@FindBy(xpath = "//*[@class='menuclass']/a[contains(text(),'Student Attendance/Internals')]")
	WebElement AttendanceInternals;
	@FindBy(xpath = "//*[@name='search']")
	WebElement Search;
	int flag=0;



	public WebElement getExam() {
		return exam;
	}
	public void setExam(WebElement exam) {
		this.exam = exam;
	}
	public WebElement getAttendanceInternals() {
		return AttendanceInternals;
	}
	public void setAttendanceInternals(WebElement attendanceInternals) {
		AttendanceInternals = attendanceInternals;
	}
	public WebElement getSearch() {
		return Search;
	}
	public void setSearch(WebElement search) {
		Search = search;
	}
	public WebElement getAcademicAuditing() {
		return AcademicAuditing;
	}
	public void setAcademicAuditing(WebElement academicAuditing) {
		AcademicAuditing = academicAuditing;
	}



	public ViewStaffAdvisorEnable(WebDriver driver)

	{
		//initializing the driver
		super(driver);

	}
	public static List<String>StaffAdvisorId=new ArrayList<String>();
	public static int BranchSize;
	public static String Branch;
	public static Object[] Branchnames;
	public static List<String>branchList=new ArrayList<String>();
	public static ArrayList<String> branchNames=new ArrayList<String>();
	public static ArrayList<String> batches=new ArrayList<String>();
	public static ArrayList<String> advisorStatus=new ArrayList<String>();



	String branches[]=new String[10];













	//**********************************************************************************
	public void Attendanceinternal(String attendanceinter) throws InterruptedException {


		String status = "";

		try {

			//Parameters
			List<String> params = new ArrayList<>();
			params = Arrays.asList(attendanceinter.split(",#"));


			Thread.sleep(2000);

			// click the Student Attendance/Internals
			AttendanceInternals.click();

			WebElement yearClick = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id=\"academicYearId\"]")));

			Select yeardropdown = new Select(yearClick);

			////passing the Academic year
			yeardropdown.selectByVisibleText(params.get(0));

			Thread.sleep(2000);

			WebElement ProgramClick = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id=\"programId\"]")));

			Select Programdropdown = new Select(ProgramClick);

			////passing the Program
			Programdropdown.selectByVisibleText(params.get(1));

			Thread.sleep(2000);

			WebElement ProgtypeClick = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id=\"programType\"]")));

			Select Progtypedropdown = new Select(ProgtypeClick);

			////passing the Program type
			Progtypedropdown.selectByVisibleText(params.get(2));

			Thread.sleep(2000);

			WebElement SemesterClick = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id=\"semesterId\"]")));

			Select Semesterdropdown = new Select(SemesterClick);

			////passing the Semester
			Semesterdropdown.selectByVisibleText(params.get(3));

			Thread.sleep(2000);

			WebElement BatchClick = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id='registrationAllowedStudentStatus']")));

			Select Batchdropdown = new Select(BatchClick);

			////passing the Batch
			Batchdropdown.selectByVisibleText(params.get(4));

			Thread.sleep(2000);

			WebElement DegreeClick = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id=\"degreeType\"]")));

			Select Degreedropdown = new Select(DegreeClick);

			////passing the Degree
			Degreedropdown.selectByVisibleText(params.get(5));

			Thread.sleep(2000);

			//Click on Search button
			Search.click();

		} catch (Exception e) {

			e.printStackTrace();

		}

		Thread.sleep(1000);

	}
	public void CoursecodeFacultyId() throws InterruptedException {


		String status = "";

		try {



			Thread.sleep(2000);

			//Count Branch rows
			List<WebElement> Branchlist = driver.findElements(By.xpath("//*[contains(text(),' Branch/Stream:')]"));
			BranchSize= Branchlist.size();
			System.out.println("Listed branches are "+BranchSize);
			for(int i = 1; i <=BranchSize; i++) {


				//String branch = driver.findElement(By.xpath("//*[@id='programDetail']/tbody/tr["+(i)+"]/td[1]")).getText();
				String branch = driver.findElement(By.xpath("(//*[contains(text(),' Branch/Stream:')])["+(i)+"]")).getText();
				branch = StringUtils.substringAfter(branch, "Branch/Stream:");


				branchNames.add(branch);
				System.out.println("Child branches are "+branchNames);


			}

			Thread.sleep(2000);

		} catch (Exception e)
		{

			e.printStackTrace();

		}
	}




	public void StaffAdvisor(String advisor) throws InterruptedException {

		String status = "";

		try {
			//Parameters
			List<String> params = new ArrayList<>();
			params = Arrays.asList(advisor.split(",#"));



			Thread.sleep(2000);

			WebElement yearClick = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id='academicYear']")));

			Select yeardropdown = new Select(yearClick);

			////passing the Academic year
			yeardropdown.selectByVisibleText(params.get(0));

			Thread.sleep(2000);

			WebElement ProgramClick = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id=\"programId\"]")));

			Select Programdropdown = new Select(ProgramClick);

			////passing the Program
			Programdropdown.selectByVisibleText(params.get(1));

			Thread.sleep(2000);

			WebElement ProgtypeClick = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id='degreeType']")));

			Select Progtypedropdown = new Select(ProgtypeClick);

			////passing the Program type
			Progtypedropdown.selectByVisibleText(params.get(2));

			Thread.sleep(2000);
			// count rows with size() method


			List<WebElement> rows = driver.findElements(By.xpath("//*[@id='batchListingTable']/tbody/tr"));

			for (int i = 0; i <branchNames.size(); i++)
			{
				String currentBranchName=branchNames.get(i);
				for(int j = 1; j<=rows.size();j++)
				{
					String cellBranch = driver.findElement(By.xpath("//*[@id='batchListingTable']/tbody/tr["+j+"]/td[6]")).getText();
					System.out.println(cellBranch+"="+currentBranchName);


					if(currentBranchName.equals(cellBranch)) {
						try
						{
							// user fetch batch details from staff advisor selecting UI
							WebElement element=driver.findElement(By.xpath("//*[@id='batchListingTable']/tbody/tr["+j+"]/td[2]"));

							System.out.println(i+"="+j);
							batches.add(element.getText());
							System.out.println("batches are "+batches);

							element =driver.findElement(By.xpath("(//*[@id='batchListingTable']/tbody/tr["+j+"]/td[8]/a)[2]"));
							Thread.sleep(2000);

							element.click();
							Thread.sleep(1000);
							String seniorValue;

							List<WebElement> elements =driver.findElements(By.xpath("//*[@id=\"advisorType\"]"));
							WebElement senior;

							if (elements.size() > 1)
							{

								String element1[]=elements.get(0).getText().split("\n");
								System.out.println(element1[0]);
								System.out.println("*****************");
								if(element1[0].equals("Senior Staff Advisor"))
								{

									senior = driver.findElement(By.xpath("//*[@id='facultyId']"));

								}
								else
								{
									senior = driver.findElement(By.xpath("(//*[@id='facultyId'])[2]"));
								}
							}

							else {

								senior=driver.findElement(By.xpath("//*[@id='facultyId']"));


							}
							//Getting values from senior value field
							seniorValue = senior.getAttribute("value");
							System.out.println("faculty code is "+seniorValue);
							//if staff advisor fields are empty then add a staff advisor then save and fetch that.
							if(seniorValue.equals(""))
							{
								//add staff advisor and save then get text from the field
								senior.sendKeys("K");
								Thread.sleep(1000);
								Robot robot = new Robot();
								//Pressing the Enter Key
								robot.keyPress(KeyEvent.VK_ENTER);
								//Releasing the Enter Key
								robot.keyRelease(KeyEvent.VK_ENTER);
								Thread.sleep(1000);
								System.out.println(senior.getAttribute("value"));
								//after entering faculty,fetching that faculty id
								String[] AdvisorId = senior.getAttribute("value").split("-");
								System.out.println(AdvisorId[0]+"-"+AdvisorId[1]);
								StaffAdvisorId.add(AdvisorId[0]+"-"+AdvisorId[1]);
								System.out.println("newly added staff advisor is "+StaffAdvisorId);
								Thread.sleep(1000);
								element =driver.findElement(By.xpath("//*[@id='submit']"));
								element.click();
								Thread.sleep(1000);
								break;
							}
							else
							{
								String[] AdvisorId = seniorValue.split(" ");
								StaffAdvisorId.add(AdvisorId[0]);
								System.out.println(StaffAdvisorId);
								element =driver.findElement(By.xpath("//*[@id='submit']"));
								element.click();
								Thread.sleep(500);
								break;

							}

						}

						catch(Exception e)
						{
							continue;
						}

					}
				}

				Robot robot = new Robot();
				driver.navigate().refresh();
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(1000);
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();

		}
	}
	public void logout() throws InterruptedException{
		//		Added on 27/10/2023 12:34

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a[@href='/university/logout.htm']")));

		element.click();
	}

	public void userdetails() throws InterruptedException{
		//		user click settings button
		WebElement element= driver.findElement(By.xpath("//a[@href='/university/eu/set/settingsDashBoard.htm']"));
		element.click();
		Thread.sleep(500);
		//		User click university user button
		element= driver.findElement(By.xpath("(//*[@class='glyphicon glyphicon-circle-arrow-right'])[2]"));
		element.click();
		Thread.sleep(500);
		//		User click user details button
		element= driver.findElement(By.xpath("//*[text()='User Details']"));
		Thread.sleep(2000);
		element.click();
		//		User click user details button
		element= driver.findElement(By.xpath("//*[text()='User Details']"));
		Thread.sleep(2000);
		element.click();


	}
	public void CheckingStatus() throws InterruptedException
	{
		//		Added on 27/10/2023 12:34

		//		User pass user name on user details
		for (String element2 : StaffAdvisorId) {

			WebElement element= driver.findElement(By.xpath("//*[@id=\"userName\"]"));
			element.clear();
			Thread.sleep(500);
			element.sendKeys(element2);
			Thread.sleep(500);


			//		User click on search button
			element= driver.findElement(By.xpath("//*[@id=\"searchForm_search\"]"));
			element.click();
			Thread.sleep(500);
			try
			{

				element = driver.findElement(By.xpath("//*[@id='userListing']/tbody/tr/td[4]"));
				element.getText();
				advisorStatus.add(element.getText());
			}
			catch(Exception e)
			{
				advisorStatus.add("Disabled");
			}
			//System.out.println("Staff advisor "+advisorStatus);



		}
		System.out.println("Staff advisor "+advisorStatus);
	}


	public void checkingDisabledStatus() throws InterruptedException, AWTException{

		driver.manage().window().maximize();
		String branchName="";
		String batchName="";
		String branch,batch;
		WebElement element;

		for(int i=0;i<advisorStatus.size();i++)
		{
			if(advisorStatus.get(i).equals("Disabled"))
			{
				branchName=branchNames.get(i);
				batchName=batches.get(i);

				System.out.println(branchName+" "+batchName+" "+StaffAdvisorId.get(i));

				List<WebElement> elements1=driver.findElements(By.xpath("//*[@id='batchListingTable']/tbody/tr"));
				System.out.println(elements1.size());
				for(int j=1;j<=elements1.size();j++)
				{
					branch=driver.findElement(By.xpath("//*[@id='batchListingTable']/tbody/tr["+j+"]/td[6]")).getText();
					batch=driver.findElement(By.xpath("//*[@id='batchListingTable']/tbody/tr["+j+"]/td[2]")).getText();
					System.out.println(branch+" "+batch);
					System.out.println("j="+j);

					if(branch.equals(branchName)&&batch.equals(batchName))
					{
						System.out.println("(//*[@id='batchListingTable']/tbody/tr["+j+"]/td[8]/a)[2]");
						//						driver.navigate().refresh();
						Thread.sleep(1000);

						element=driver.findElement(By.xpath("(//a[@title='Select Staff Advisor'])["+j+"]"));
						//						System.out.println(element.getAttribute("title"));
						Thread.sleep(1000);
						//((RemoteWebDriver) driver).executeScript("arguments[0].click();", element);
						element.click();
						//						element.sendKeys(Keys.ENTER);
						Thread.sleep(1000);

						//*********************************
						element=driver.findElement(By.xpath("//*[@id='facultyId']"));
						element.clear();
						Thread.sleep(1000);

						element.sendKeys("K");
						Thread.sleep(500);

						Robot robot = new Robot();
						//Pressing the Enter Key


						robot.keyPress(KeyEvent.VK_ENTER);



						//Releasing the Enter Key
						robot.keyRelease(KeyEvent.VK_ENTER);
						Thread.sleep(1000);
						element =driver.findElement(By.xpath("//*[@id='submit']"));
						element.click();
						Thread.sleep(2000);

						//						Page refresh
						driver.navigate().refresh();
						robot.keyPress(KeyEvent.VK_ENTER);
						robot.keyRelease(KeyEvent.VK_ENTER);
						Thread.sleep(1000);





					}

				}
			}

		}

	}






	public void pageListing(String advisor) throws InterruptedException {

		String status = "";


		//Parameters
		List<String> params = new ArrayList<>();
		params = Arrays.asList(advisor.split(",#"));



		Thread.sleep(2000);

		WebElement yearClick = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='academicYear']")));

		Select yeardropdown = new Select(yearClick);

		////passing the Academic year
		yeardropdown.selectByVisibleText(params.get(0));

		Thread.sleep(2000);

		WebElement ProgramClick = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"programId\"]")));

		Select Programdropdown = new Select(ProgramClick);

		////passing the Program
		Programdropdown.selectByVisibleText(params.get(1));

		Thread.sleep(2000);

		WebElement ProgtypeClick = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='degreeType']")));

		Select Progtypedropdown = new Select(ProgtypeClick);

		////passing the Program type
		Progtypedropdown.selectByVisibleText(params.get(2));

		Thread.sleep(2000);
		// count rows with size() method






	}
}
