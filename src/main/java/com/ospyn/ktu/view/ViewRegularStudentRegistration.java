//package com.ospyn.ktu.view;
//
//import java.awt.AWTException;
//import java.awt.Robot;
//import java.awt.event.KeyEvent;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.commons.lang3.StringUtils;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//
//import com.ospyn.ktu.util.SeleniumBase;
//import com.ospyn.ktu.util.ViewCommonUtil;
//
//public class ViewRegularStudentRegistration extends SeleniumBase{
//
//
//
//	private String SheetName="";
//	String programType="";
//	//ViewCommonUtil CommonUtilView;
//	JavascriptExecutor js = (JavascriptExecutor) driver;
//
//
//	public void enterKeypress() throws AWTException, InterruptedException {
//		Robot robot = new Robot();
//		Thread.sleep(800);
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
//		Thread.sleep(800);
//
//	}
//
//
//
//	public static 	ArrayList<String> RegNumber =new ArrayList<String>();
//
//	public void downKeyPress() throws AWTException {
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_DOWN);
//		robot.keyRelease(KeyEvent.VK_DOWN);
//	}
//
//
//
//	public ViewRegularStudentRegistration(WebDriver driver)throws Exception {
//
//		super(driver);
//		//	CommonUtilView = new ViewCommonUtil(driver);
//		ViewCommonUtil.readFromExcel("PARAMETER_LISTING.xlsx","RegularStudentRegistration");
//
//		SheetName = ViewCommonUtil.excelParameters.get("Name of student details sheet");
//		programType=ViewCommonUtil.excelParameters.get("Program Type");
//
//	}
//
//	public void logout() throws InterruptedException  {
//
//		ViewCommonUtil.click("//span[@class='glyphicon glyphicon-off']");
//
//	}
//	public void LoginasCollegeAdmin() throws Exception {
//
//
//
//		//passing user name
//		ViewCommonUtil.enterTextinTextField("InstitutionUN", "//input[@id='login-username']");
//
//		//passing password
//		ViewCommonUtil.enterTextinTextField("Password", "//input[@id='login-password']");
//		Thread.sleep(1500);
//		//click login
//		ViewCommonUtil.click("//input[@id='btn-login']");
//		Thread.sleep(1500);
//		driver. navigate(). refresh();
//
//	}
//	public void clickStudentModule() throws InterruptedException {
//		ViewCommonUtil.click("//a[text()='Student']");
//		Thread.sleep(800);
//
//
//	}
//	public void clickAddRegistration() throws InterruptedException{
//		ViewCommonUtil.click("//a[@id='add']");
//		Thread.sleep(800);
//	}
//
//	public void clickAddButtonforIndividualStudentRegistration() throws Exception {
//
//
//
//		List<WebElement> addButtons = driver.findElements(By.xpath("//a[@class='btn btn-warning btn-xs pull-right']"));
//		System.out.println("No of Branches : " +addButtons.size());
//		int count =1;
//		int p=Integer.parseInt(ViewCommonUtil.excelParameters.get("Number of student Needed in one branch"));
//
//
//		for(int i=1;i<=addButtons.size();i++) {
//
//			for(int j=count;j<=(count+(p-1));j++) {
//
//				ViewCommonUtil.click("(//a[@class='btn btn-warning btn-xs pull-right'])["+i+"]");
//
//				Thread.sleep(1500);
//
//				//				System.out.println(i);
//				//				 driver.navigate().back();
//
//
//				ViewCommonUtil.browseAttachment("Image.jpeg", "//input[@id='studentPic']");
//
//				ViewCommonUtil.browseAttachment("Signature.png", "//input[@id='signaturePic']");
//
//				js.executeScript("document.body.style.zoom='20%'");
//
//				String firstName=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"First Name",j);
//				ViewCommonUtil.enterStringValueinTextField(firstName, "//input[@id='studentForm_firstName']");
//
//				String middleNmae=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Middle Name",j);
//				ViewCommonUtil.enterStringValueinTextField(middleNmae, "//input[@id='studentForm_middleName']");
//
//				String lastName=ViewCommonUtil.randomStringGenerator(6);
//				ViewCommonUtil.enterStringValueinTextField(lastName, "//input[@id='studentForm_surName']");
//
//				String gender=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Gender",j);
//				ViewCommonUtil.selectStringDropDownItem(gender,"//select[@id='studentForm_gender']");
//
//				String dob=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Date of Birth",j);
//				ViewCommonUtil.enterStringValueinTextField(dob, "//input[@id='studentForm_dateOfBirth']");
//				enterKeypress();
//
//				String aadharNo=ViewCommonUtil.randomNumberGenerator(12);
//				ViewCommonUtil.enterStringValueinTextField(aadharNo, "//input[@id='studentForm_aadharNo']");
//
//				String nationality=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Nationality",j);
//				ViewCommonUtil.enterStringValueinTextField(nationality, "//input[@id='studentForm_nationality']");
//
//				String motherTongue=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Mother Tongue",j);
//				ViewCommonUtil.enterStringValueinTextField(motherTongue, "//input[@id='studentForm_motherTongue']");
//
//				String religion=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Religion",j);
//				ViewCommonUtil.selectStringDropDownItem(religion,"//select[@id='studentForm_religionId']");
//
//				String caste=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Caste",j);
//				ViewCommonUtil.selectStringDropDownItem(caste,"//select[@id='studentForm_casteId']");
//
//				String category=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Category",j);
//				ViewCommonUtil.selectStringDropDownItem(category,"//select[@id='categoryId']");
//
//				String additionalInformation=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Additional Information",j);
//				ViewCommonUtil.enterStringValueinTextField(additionalInformation, "//textarea[@id='studentForm_hobbies']");
//				Thread.sleep(1000);
//
//
//				String bloodGroup=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Blood Group",j);
//				ViewCommonUtil.selectStringDropDownItem(bloodGroup,"//select[@id='studentForm_bloodType']");
//
//				String familyAnnualIncome=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Family Annual Income (in Rupees)",j);
//				ViewCommonUtil.enterStringValueinTextField(familyAnnualIncome, "//input[@id='studentForm_annualIncome']");
//
//				//Economically back word check box
//				String economicallyBackWord=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Economically Backward",j);
//				ViewCommonUtil.checkBox(economicallyBackWord,"//input[@id='studentForm_ecoBackward']");
//
//				String differentlyAbled=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Differently Abled",j);
//				ViewCommonUtil.checkBox(differentlyAbled,"//input[@id='studentForm_handicapped'] ");
//
//
//
//
//				WebElement element = driver.findElement(By.id("studentForm_admissionMode"));
//				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//				Thread.sleep(500); 
//
//
//				String admissionQuota=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Admission Quota",j);
//				ViewCommonUtil.selectStringDropDownItem("Merit","//select[@id='studentForm_admissionMode']");
//
//				String collegeAdmissionNumber=ViewCommonUtil.randomNumberGenerator(6);
//				ViewCommonUtil.enterStringValueinTextField(collegeAdmissionNumber, "//input[@id='studentForm_admissionNo']");
//				System.out.println("admission entered");
//
//
//				WebElement division =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='divisionId']")));
//				Select dropdown = new Select(division);
//				dropdown.selectByIndex(1);
//
//				String admittedCtegory=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Admitted Category",j);
//				ViewCommonUtil.selectStringDropDownItem(admittedCtegory,"//select[@id='admCategoryId']");
//
//				//Eligible For Fee Concession check box
//				String eligibleforFeeConcession=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Eligible For Fee Concession",j);
//				ViewCommonUtil.checkBox(eligibleforFeeConcession,"//input[@id='eligibleForFeeConcession']");
//
//
//				String admissionType=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Admission Type",j);
//				ViewCommonUtil.selectStringDropDownItem(admissionType,"//select[@id='studentForm_admissionType']");
//
//				String remarksintheAdmission=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Remarks in the admission details",j);
//				ViewCommonUtil.enterStringValueinTextField(remarksintheAdmission, "//textarea[@id='studentForm_remarks']");
//
//				String communicationAddressofStudent=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Communication Address of student",j);
//				ViewCommonUtil.enterStringValueinTextField(communicationAddressofStudent, "//textarea[@id='studentForm_address']");
//
//				String permanentAddressofStudent=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Permanent Address of student",j);
//				ViewCommonUtil.enterStringValueinTextField(permanentAddressofStudent, "//textarea[@id='studentForm_permAddress']");
//
//				String landlineNumberStudent=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Landline Number of student",j);
//				ViewCommonUtil.enterStringValueinTextField(landlineNumberStudent, "//input[@id='studentForm_landPhoneNo']");
//
//				String districtCommunicationAddressofStudent=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"District (Communication Address) of student",j);
//				ViewCommonUtil.selectStringDropDownItem(districtCommunicationAddressofStudent,"//select[@id='studentForm_commDistrictId']");
//
//				String districtPermanentAddressofStudent=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"District (Permanent Address) of student",j);
//				ViewCommonUtil.selectStringDropDownItem(districtPermanentAddressofStudent,"//select[@id='studentForm_perDistrictId']");
//
//				String mobileNumberofStudent=ViewCommonUtil.randomNumberGenerator(10);
//				ViewCommonUtil.enterStringValueinTextField(mobileNumberofStudent, "//input[@id='studentForm_mobileNo']");
//
//				String emailofStudent=(firstName+"."+lastName+"@gmail.com");
//				System.out.println(emailofStudent);
//				ViewCommonUtil.enterStringValueinTextField(emailofStudent, "//input[@id='studentForm_email']");
//
//				String fathersNameofStudent=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Father's Name of student",j);
//				ViewCommonUtil.enterStringValueinTextField(fathersNameofStudent, "//input[@id='fathersName']");
//
//				String occupationpfParent=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Occupation of parent",j);
//				ViewCommonUtil.enterStringValueinTextField(occupationpfParent, "//input[@id='fatherOccupation']");
//				String permanentAddressofParent=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Permanent Address of parent",j);
//				ViewCommonUtil.enterStringValueinTextField(permanentAddressofParent, "//textarea[@id='fatherPerAddress']");
//
//				String communicationAddrssofParent=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Communication Address of parent",j);
//				ViewCommonUtil.enterStringValueinTextField(communicationAddrssofParent, "//textarea[@id='fatherCommAddress']");
//
//				try {
//					String mobileNumberofParent=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Mobile Number of parent",j);
//					ViewCommonUtil.enterStringValueinTextField(mobileNumberofParent, "//input[@id='fatherMobileNumber']");
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//
//				String landlineofParent=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Landline Number of parent",j);
//				ViewCommonUtil.enterStringValueinTextField(landlineofParent, "//input[@id='fatherLandline']");
//
//				String emailofParent=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Email of parent",j);
//				ViewCommonUtil.enterStringValueinTextField(emailofParent, "//input[@id='fatherEmails']");
//
//				String motherName=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Mother's Name",j);
//				ViewCommonUtil.enterStringValueinTextField(motherName, "//input[@id='mothersName']");
//
//				String occupationofMother=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Occupation of mother",j);
//				ViewCommonUtil.enterStringValueinTextField(occupationofMother, "//input[@id='mothersOccupation']");
//
//				String permanentAddressofMother=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Permanent Address of mother",j);
//				ViewCommonUtil.enterStringValueinTextField(permanentAddressofMother, "//textarea[@id='mothersPerAddress']");
//
//				String communicationAddressofMother=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Communication Address of mother",j);
//				ViewCommonUtil.enterStringValueinTextField(communicationAddressofMother, "//textarea[@id='mothersCommAddress']");
//
//				try {
//					String mobileNumberofMother=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Mobile Number of mother",j);
//					ViewCommonUtil.enterStringValueinTextField(mobileNumberofMother, "//input[@id='motherMobileNumber']");
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//
//				String landlineNumberofMother=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Landline Number of mother",j);
//				ViewCommonUtil.enterStringValueinTextField(landlineNumberofMother, "//input[@id='mothersLandline']");
//
//				String emailofMother=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Email of mother",j);
//				ViewCommonUtil.enterStringValueinTextField(emailofMother, "//input[@id='motherEmails']");
//
//				String guardianName=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Guardian Name",j);
//				ViewCommonUtil.enterStringValueinTextField(guardianName, "//input[@id='other']");
//
//				String relationwithGuardian=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Relation with guardian ",j);
//				ViewCommonUtil.enterStringValueinTextField(relationwithGuardian, "//input[@id='otherRelation']");
//
//				String occupationofGuardian=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Occupation of guardian",j);
//				ViewCommonUtil.enterStringValueinTextField(occupationofGuardian, "//input[@id='otherOccupation']");
//
//				String permanentAddressofGuardian=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Permanent Address of guardian",j);
//				ViewCommonUtil.enterStringValueinTextField(permanentAddressofGuardian, "//textarea[@id='otherPerAddress']");
//
//				String communicationAddressofGuardian=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Communication Address of guardian",j);
//				ViewCommonUtil.enterStringValueinTextField(communicationAddressofGuardian, "//textarea[@id='otherCommAddress']");
//
//				String mobileNumberofguardian=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Mobile Number of guardian",j);
//				ViewCommonUtil.enterStringValueinTextField(mobileNumberofguardian, "//input[@id='otherMobileNumber']");
//
//				String landlineNumberofGuardian=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Landline Number of guardian",j);
//				ViewCommonUtil.enterStringValueinTextField(landlineNumberofGuardian, "//input[@id='otherLandline']");
//
//				String emailofGuardian=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Email of guardian",j);
//				ViewCommonUtil.enterStringValueinTextField(emailofGuardian, "//input[@id='otherEmails']");
//
//
//				String qualificationType=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Qualification Type",j);
//				System.out.println("qualificationType="+qualificationType);
//				ViewCommonUtil.selectStringDropDownItem(qualificationType,"//select[@id='qualificationType']");
//
//
//				String board=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Board",j);
//				ViewCommonUtil.selectStringDropDownItem(board,"//select[@id='board']");
//
//				String qualifiedYear=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Qualified Year",j);
//				ViewCommonUtil.selectStringDropDownItem(qualifiedYear,"//select[@id='qualifiedYear']");
//
//				String totalMarks=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Total Marks",j);
//				ViewCommonUtil.enterStringValueinTextField(totalMarks, "//input[@id='totalScore']");
//
//				String percentageofMarks=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Percentage of Marks",j);
//				ViewCommonUtil.enterStringValueinTextField(percentageofMarks, "//input[@id='percentOfMarks']");
//
//				String cgpa=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"CGPA",j);
//				ViewCommonUtil.enterStringValueinTextField(cgpa, "//input[@id='cgpa']");
//
//				String physicsMarks=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Physics Marks",j);
//				ViewCommonUtil.enterStringValueinTextField(physicsMarks, "//input[@id='physicsMark']");
//
//				String chemistryMarks=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Chemistry/other as specified in CEE",j);
//				ViewCommonUtil.enterStringValueinTextField(chemistryMarks, "//input[@id='chemistryMark']");
//
//				String mathsMarks=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Maths Marks",j);
//				ViewCommonUtil.enterStringValueinTextField(mathsMarks, "//input[@id='mathsMark']");
//
//				String entranceType=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Entrance Type",j);
//				ViewCommonUtil.selectStringDropDownItem(entranceType,"//select[@id='entranceType']");
//
//				String rankingType=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Ranking Type",j);
//				ViewCommonUtil.selectStringDropDownItem(rankingType,"//select[@id='rankingType']");
//
//				String entranceRankorPercentile=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Entrance Rank/Percentile",j);
//				ViewCommonUtil.enterStringValueinTextField(entranceRankorPercentile, "//input[@id='entranceRank']");
//
//				String entranceScore=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Entrance Score",j);
//				ViewCommonUtil.enterStringValueinTextField(entranceScore, "//input[@id='entranceScore']");
//
//
//
//				if (programType.equals("Working Professionals")) {
//					//working profession
//					String workExperience = ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",
//							SheetName, "Entrance Score", j);
//					ViewCommonUtil.enterStringValueinTextField(workExperience, "//input[@id='workExperience']");
//					String workSiteDistance = ViewCommonUtil.readExcelColumHeader(
//							"Regular_Student_Registration.xlsx", SheetName, "Work site distance", j);
//					ViewCommonUtil.enterStringValueinTextField(workSiteDistance,
//							"//input[@id='workSiteDistance']");
//				}
//
//
//				ViewCommonUtil.browseAttachment("File.pdf", "//input[@id='certificate']");
//<<<<<<< .mine
//				ViewCommonUtil.browseAttachment("File.pdf", "//input[@id='markList']");
//				ViewCommonUtil.browseAttachment("File.pdf", "//input[@id='entranceScoreCard']");
//				ViewCommonUtil.browseAttachment("File.pdf", "//input[@id='casteCertificate']");
//				ViewCommonUtil.browseAttachment("File.pdf", "//input[@id='otherCertificate']");
//||||||| .r720
//=======
//				ViewCommonUtil.browseAttachment("File.pdf", "//input[@id='markList']");				
//				ViewCommonUtil.browseAttachment("File.pdf", "//input[@id='entranceScoreCard']");				
//				ViewCommonUtil.browseAttachment("File.pdf", "//input[@id='casteCertificate']");				
//				ViewCommonUtil.browseAttachment("File.pdf", "//input[@id='otherCertificate']");
//				if (programType.equals("Working Professionals")) {
//					ViewCommonUtil.browseAttachment("File.pdf", "//input[@id='principalAttestation']");				
//				}
//				ViewCommonUtil.browseAttachment("File.pdf", "//input[@id='ageProofDoc']");
//
//>>>>>>> .r724
//
//				ViewCommonUtil.waitforPageLoad("studentDetails.htm");
//				ViewCommonUtil.click("//button[@id='studentForm_submit']");
//				//				Thread.sleep(10000);
//				ViewCommonUtil.waitforPageLoad("studentActionList.htm");
//			}
//			count=count+p;
//
//<<<<<<< .mine
//		}
//||||||| .r720
//=======
//
//		}                       
//>>>>>>> .r724
//
//	}
//	public void submissionOfRegularStudentRegistration() throws InterruptedException, AWTException {
//		ViewCommonUtil.click("(//input[@type='checkbox'])[1]");
//
//		ViewCommonUtil.click("//button[@id='branchListingForm_Submit']");
//
//		enterKeypress();
//
//	}
//	public void loginasUniversityUser() throws Exception {
//
//		//passing user name
//		ViewCommonUtil.enterTextinTextField("UniversityUN", "//input[@id='login-username']");
//
//		//passing password
//		ViewCommonUtil.enterTextinTextField("Password", "//input[@id='login-password']");
//		Thread.sleep(1500);
//		//click login
//		ViewCommonUtil.click("//input[@id='btn-login']");
//		Thread.sleep(1500);
//		driver. navigate(). refresh();
//	}
//	public void clickSemesterTransferorRegistration() {
//		ViewCommonUtil.click("//a[text()='Semester Transfer/Registration']");
//	}
//	public void generatingRegisterNumber() throws Exception {
//
//
//		ViewCommonUtil.selectDropDownItem("Academic Year", "//select[@id='academicYearId']");
//
//		ViewCommonUtil.selectDropDownItem("Program", "//select[@id='programId']");
//
//		ViewCommonUtil.selectDropDownItem("Program Type", "//select[@id='programType']");
//
//		ViewCommonUtil.selectDropDownItem("Process Type", "//select[@id='transferSearchForm_typeId']");
//
//		ViewCommonUtil.selectDropDownItem("Admission/Transfer Type", "//select[@id='transferSearchForm_semTransferTypeId']");
//
//		ViewCommonUtil.click("//button[@id='transferSearchForm_search']");
//
//		try
//		{
//
//			WebElement registrationRequest = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='No records found.']")));
//
//
//
//			if (registrationRequest.isDisplayed()) {
//
//				ViewCommonUtil.click("//a[@id='add']");
//
//				ViewCommonUtil.selectDropDownItem("Academic Year", "//select[@id='transferForm_academicYearId']");
//
//				ViewCommonUtil.selectDropDownItem("Program", "//select[@id='programId']");
//
//				ViewCommonUtil.selectDropDownItem("Program Type", "//select[@id='programTypeId']");
//
//				ViewCommonUtil.selectDropDownItem("Scheme", "//select[@id='schemeId']");
//
//				ViewCommonUtil.selectDropDownItem("Process Type", "//select[@id='typeId']");
//
//				ViewCommonUtil.selectDropDownItem("Admission/Transfer Type", "//select[@id='semTransferTypeId']");
//
//				ViewCommonUtil.selectDropDownItem("Destination Semester", "//select[@id='destSemesterId']");
//
//				ViewCommonUtil.click("//button[@id='transferForm_submit']");
//
//				ViewCommonUtil.click("//button[@id='transferForm_confirm']");
//
//				Thread.sleep(1000);
//
//				ViewCommonUtil.click("//button[@id='transferSearchForm_search']");
//
//				ViewCommonUtil.click("//table[@id='transferTable']//tbody//tr//td[9]//a[3]");
//
//				ViewCommonUtil.click("(//button[@id='confirm'])[3]");
//
//				ViewCommonUtil.click("//button[@id='transferSearchForm_search']");
//
//				//autoRefreshingUpToElementLocate("//td[text()='REGISTER NUMBER GENERATED SUCCESSFULLY']");
//				Thread.sleep(15000);
//
//			}
//		}
//		catch(Exception e)
//		{
//
//			ViewCommonUtil.click("//button[@id='transferSearchForm_search']");
//
//			ViewCommonUtil.click("//table[@id='transferTable']//tbody//tr//td[9]//a[2]");
//
//			ViewCommonUtil.click("(//button[@id='confirm'])[3]");
//
//			//	ViewCommonUtil.click("//button[@id='transferSearchForm_search']");
//
//			//	autoRefreshingUpToElementLocate("//td[text()='REGISTER NUMBER GENERATED SUCCESSFULLY']");
//			Thread.sleep(15000);
//
//		}
//
//
//	}
//	public void clickStudentDetails() {
//
//		ViewCommonUtil.click("//a[text()='Student Details']");
//	}
//
//	public void addFiltersinStudentDetails() throws Exception {
//
//		ViewCommonUtil.selectDropDownItem("Academic Year", "//select[@id='academicYearId']");
//
//		ViewCommonUtil.selectDropDownItem("Program", "//select[@id='admittedprogramId']");
//
//		ViewCommonUtil.selectDropDownItem("Program Type", "//select[@id='programType']");
//
//		ViewCommonUtil.enterTextinTextField("Institution", "//input[@id='institution']");
//		Thread.sleep(2000);
//		enterKeypress();
//
//		ViewCommonUtil.click("//button[@id='studentForm_search']");
//
//	}
//
//	public void readingStudentRegisterNumber() throws InterruptedException, IOException {
//
//		String recordMessage = driver.findElement(By.xpath("//*[@class='pagebanner']")).getText();
//		System.out.println("recordMessage "+recordMessage);
//		String arr[] = recordMessage.split(" ");
//		int arrSize = arr.length;
//		System.out.println("arrSize"+arrSize);
//		String firstWord = arr[0];
//		String lastWord = arr[arrSize-1];
//		lastWord=lastWord.substring(0,lastWord.length()-1);
//		System.out.println("lastWord"+lastWord);
//
//		int firstWordValue=Integer.parseInt(firstWord);
//		int lastWordValue=Integer.parseInt(lastWord);
//		float lastRecord =(float)firstWordValue/lastWordValue;
//		int lastRecordValue =(int) Math.ceil(lastRecord);
//		System.out.println("lastRecordValue"+lastRecordValue);
//
//		for(int p=1;p<=lastRecordValue;p++) {
//
//			Thread.sleep(1000);
//
//			ViewCommonUtil.click("//*[text()='"+p+"']");
//
//			//	driver.findElement(By.xpath("//*[text()='"+p+"']")).click();
//
//			List<WebElement> studentlistrow = driver.findElements(By.xpath("(//table[@id='studentTable']/tbody/tr)"));
//			int rowlength=studentlistrow.size();
//
//
//			for(int s=1;s<=rowlength;s++) {
//
//				String fullRegNo= driver.findElement(By.xpath("//*[@id='studentTable']/tbody/tr["+s+"]/td[2]/label[2]")).getText();
//				//System.out.println("fullRegNo"+fullRegNo);
//				String RegNo = StringUtils.substringAfter(fullRegNo, "Reg No: ");
//				System.out.println("RegNo"+RegNo);
//
//				String fullbranch= driver.findElement(By.xpath("//*[@id='studentTable']/tbody/tr["+s+"]/td[3]/span[2]")).getText();
//				//System.out.println("fullbranch"+fullbranch);
//				String branch = StringUtils.substringAfter(fullbranch, "Branch: ");
//				System.out.println("branch"+branch);
//
//				RegNumber.add(RegNo);
//
//			}
//
//
//		}
//		System.out.println(RegNumber);
//		System.out.println(RegNumber.size());
//	}
//
//
//	public void changingPassword() throws Exception {
//		ViewCommonUtil.click("//a[text()=' Settings']");
//
//		ViewCommonUtil.click("//*[text()='View Security Settings']");
//
//		ViewCommonUtil.click("//*[text()='Change Username and Password']");
//		Thread.sleep(10000);
//
//
//		for(int i=0;i<=RegNumber.size()-1;i++) {
//			System.out.println(RegNumber.get(i));
//			ViewCommonUtil.enterStringValueinTextField(RegNumber.get(i) , "//input[@id='searchForm_userName']");
//
//			ViewCommonUtil.click("//button[@id='searchForm_search']");
//			Thread.sleep(2000);
//
//			ViewCommonUtil.click("//table[@id='userListing']//tbody//td[5]//a");
//
//			ViewCommonUtil.enterTextinTextField("Password", "//input[@id='changePasswordOrUserNameForm_password']");
//
//			ViewCommonUtil.enterTextinTextField("Password", "//input[@id='changePasswordOrUserNameForm_confirmPassword']");
//
//			ViewCommonUtil.click("//button[@id='changePasswordOrUserNameForm_submit']");
//
//			Thread.sleep(4500);
//
//
//
//		}
//
//	}
//
//	public void submittingStudentDetailsFromStudentLogin() throws Exception {
//
//		for (String element : RegNumber) {
//
//			System.out.println(element);
//
//			//passing user name
//			ViewCommonUtil.enterStringValueinTextField(element, "//input[@id='login-username']");
//
//			//passing password
//			ViewCommonUtil.enterTextinTextField("Password", "//input[@id='login-password']");
//			Thread.sleep(1500);
//			//click login
//			ViewCommonUtil.click("//input[@id='btn-login']");
//			Thread.sleep(1500);
//			ViewCommonUtil.click("//a[text()='Student']");
//			Thread.sleep(800);
//			ViewCommonUtil.click("(//a[@id='viewProfile'])[1]");
//
//			ViewCommonUtil.click("//a[@id='edit']");
//
//			studentRegistrationSubmissionDetails();
//
//			ViewCommonUtil.click("//button[@id='studentForm_finalSubmit']");
//			enterKeypress();
//
//			Thread.sleep(15000);
//
//			ViewCommonUtil.click("//span[@class='glyphicon glyphicon-off']");
//
//
//		}
//
//	}
//
//	public void studentRegistrationSubmissionDetails() throws Exception {
//
//
//		ViewCommonUtil.browseAttachment("Image.jpeg", "//input[@id='studentPic']");
//
//		ViewCommonUtil.browseAttachment("Signature.png", "//input[@id='signaturePic']");
//
//		String qualifiedBranch=ViewCommonUtil.readExcelColumHeader("Regular_Student_Registration.xlsx",SheetName,"Qualified branch/stream",1);
//		ViewCommonUtil.enterStringValueinTextField(qualifiedBranch, "//input[@id='qualifiedBranch']");
//
//		ViewCommonUtil.browseAttachment("File.pdf", "//input[@id='certificate']");
//
//		ViewCommonUtil.browseAttachment("File.pdf", "//input[@id='markList']");
//
//		ViewCommonUtil.browseAttachment("File.pdf", "//input[@id='entranceScoreCard']");
//
//		ViewCommonUtil.browseAttachment("File.pdf", "//input[@id='casteCertificate']");
//
//		ViewCommonUtil.browseAttachment("File.pdf", "//input[@id='otherCertificate']");
//
//		if (programType.equals("Working Professionals")) {
//			ViewCommonUtil.browseAttachment("File.pdf", "//input[@id='principalAttestation']");
//		}
//		ViewCommonUtil.browseAttachment("File.pdf","//input[@name='ageProofDoc']");
//
//
//	}
//
//
//	public void collegeVerifyingStudentDetailsFromCollegeLogin() throws Exception {
//
//		int registerNumberCounter=0;
//
//		for(int i=1;i<RegNumber.size();i++) {
//
//			ViewCommonUtil.selectDropDownItem("Academic Year", "//select[@id='academicYearId']");
//
//			ViewCommonUtil.selectDropDownItem("Program", "//select[@id='admittedprogramId']");
//
//			ViewCommonUtil.selectDropDownItem("Program Type", "//select[@id='programType']");
//
//			WebElement registerNumberField =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='studentForm_registerNo']")));
//			registerNumberField.clear();
//			registerNumberField.sendKeys(RegNumber.get(registerNumberCounter));
//			registerNumberCounter++;
//
//			ViewCommonUtil.click("//button[@id='studentForm_search']");
//			Thread.sleep(2000);
//
//<<<<<<< .mine
//			Boolean flag = editButton.isDisplayed();
//||||||| .r720
//=======
//>>>>>>> .r724
//
//			try {
//				WebElement editButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table[@id='studentTable']/tbody/tr/td[5]//a[2])[1]")));
//
//				Boolean flag = editButton.isDisplayed();	
//
//				try {
//					while(flag) {
//
//<<<<<<< .mine
//					ViewCommonUtil.click("//button[@id='studentForm_finalSubmit']");
//					enterKeypress();
//					//		ViewCommonUtil.waitforPageLoad();
//					Thread.sleep(4000);
//||||||| .r720
//=======
//>>>>>>> .r724
//
//						ViewCommonUtil.click("(//table[@id='studentTable']/tbody/tr/td[5]//a[2])[1]");
//						Thread.sleep(1000);
//						//		ViewCommonUtil.waitforPageLoad();
//						studentRegistrationSubmissionDetails();
//
//						ViewCommonUtil.click("//button[@id='studentForm_finalSubmit']");
//						enterKeypress();
//						//ViewCommonUtil.waitForPageLoad(driver);
//						Thread.sleep(24000);	
//
//
//						ViewCommonUtil.selectDropDownItem("Academic Year", "//select[@id='academicYearId']");
//
//<<<<<<< .mine
//					Thread.sleep(2000);
//					editButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table[@id='studentTable']/tbody/tr/td[5]//a[2])[1]")));
//					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", editButton);
//||||||| .r720
//=======
//						ViewCommonUtil.selectDropDownItem("Program", "//select[@id='admittedprogramId']");
//>>>>>>> .r724
//
//						ViewCommonUtil.selectDropDownItem("Program Type", "//select[@id='programType']");
//
//						registerNumberField =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='studentForm_registerNo']")));
//						registerNumberField.clear();
//						registerNumberField.sendKeys(RegNumber.get(registerNumberCounter));
//						registerNumberCounter++;
//
//						ViewCommonUtil.click("//button[@id='studentForm_search']");
//						Thread.sleep(2000);
//
//
//						Thread.sleep(2000);	
//						editButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table[@id='studentTable']/tbody/tr/td[5]//a[2])[1]")));
//						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", editButton);
//
//						flag = editButton.isDisplayed();
//						Thread.sleep(2000);
//					}
//				} catch (Exception e) {
//
//					e.printStackTrace();
//				}
//			} catch (Exception e) {
//
//				e.printStackTrace();
//			}
//
//
//		}
//
//
//		//
//		//		ViewCommonUtil.selectDropDownItem("Academic Year", "//select[@id='academicYearId']");
//		//
//		//		ViewCommonUtil.selectDropDownItem("Program", "//select[@id='admittedprogramId']");
//		//
//		//		ViewCommonUtil.click("//button[@id='studentForm_search']");
//		//		Thread.sleep(2000);
//		//
//		//
//		//		try {
//		//			WebElement editButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table[@id='studentTable']/tbody/tr/td[5]//a[2])[1]")));
//		//
//		//			Boolean flag = editButton.isDisplayed();	
//		//
//		//			try {
//		//				while(flag) {
//		//
//		//
//		//					ViewCommonUtil.click("(//table[@id='studentTable']/tbody/tr/td[5]//a[2])[1]");
//		//					Thread.sleep(1000);
//		//					//		ViewCommonUtil.waitforPageLoad();
//		//					studentRegistrationSubmissionDetails();
//		//
//		//					ViewCommonUtil.click("//button[@id='studentForm_finalSubmit']");
//		//					enterKeypress();
//		//					//ViewCommonUtil.waitForPageLoad(driver);
//		//					Thread.sleep(60000);	
//		//
//		//
//		//					ViewCommonUtil.selectDropDownItem("Academic Year", "//select[@id='academicYearId']");
//		//
//		//					ViewCommonUtil.selectDropDownItem("Program", "//select[@id='admittedprogramId']");
//		//
//		//					ViewCommonUtil.click("//button[@id='studentForm_search']");
//		//
//		//					Thread.sleep(2000);	
//		//					editButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table[@id='studentTable']/tbody/tr/td[5]//a[2])[1]")));
//		//					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", editButton);
//		//
//		//					flag = editButton.isDisplayed();
//		//					Thread.sleep(2000);
//		//				}
//		//			} catch (Exception e) {
//		//
//		//				e.printStackTrace();
//		//			}
//		//		} catch (Exception e) {
//		//
//		//			e.printStackTrace();
//		//		}
//
//
//	}
//	public void universityApprovingStudentDetails() throws Exception {
//
//		int registerNumberCounter=0;
//
//		for(int i=1;i<RegNumber.size();i++) {
//
//			ViewCommonUtil.selectDropDownItem("Academic Year", "//select[@id='academicYearId']");
//
//			ViewCommonUtil.selectDropDownItem("Program", "//select[@id='admittedprogramId']");
//
//			ViewCommonUtil.selectDropDownItem("Program Type", "//select[@id='programType']");
//
//			WebElement registerNumberField =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='studentForm_registerNo']")));
//			registerNumberField.clear();
//			registerNumberField.sendKeys(RegNumber.get(registerNumberCounter));
//			registerNumberCounter++;
//
//			ViewCommonUtil.enterTextinTextField("Institution", "//input[@id='institution']");
//			Thread.sleep(2000);
//			enterKeypress();
//
//			ViewCommonUtil.click("//button[@id='studentForm_search']");
//			Thread.sleep(2000);
//
//
//			ViewCommonUtil.click("//table[@id='studentTable']//tbody//tr//td[6]//a[1]");
//
//			Thread.sleep(1500);
//			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
//
//<<<<<<< .mine
//			ViewCommonUtil.click("//button[@id='universityVerify']");
//||||||| .r720
//=======
//
//
//			ViewCommonUtil.click("//button[@id='universityVerify']");			
//>>>>>>> .r724
//
//			Thread.sleep(2000);
//			ViewCommonUtil.click("(//button[@id='confirm'])[2]");
//			Thread.sleep(4000);			
//		}
//
//
//
//	}
//
//
//	/*
//	 * ViewCommonUtil.selectDropDownItem("Academic Year",
//	 * "//select[@id='academicYearId']");
//	 * 
//	 * ViewCommonUtil.selectDropDownItem("Program",
//	 * "//select[@id='admittedprogramId']");
//	 * 
//	 * ViewCommonUtil.enterTextinTextField("Institution",
//	 * "//input[@id='institution']"); Thread.sleep(2000); enterKeypress();
//	 * 
//	 * ViewCommonUtil.click("//button[@id='studentForm_search']");
//	 * Thread.sleep(2000);
//	 * 
//	 * List<WebElement> viewButton = driver.findElements(By.xpath(
//	 * "//table[@id='studentTable']//tbody//tr//td[6]//a[1]"));
//	 * 
//	 * for(int i=1;i<=viewButton.size();i++){
//	 * 
//	 * ViewCommonUtil.click("(//table[@id='studentTable']//tbody//tr//td[6]//a[1])["
//	 * +i+"]");
//	 * 
//	 * Thread.sleep(1500); ((JavascriptExecutor)
//	 * driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
//	 * 
//	 * ViewCommonUtil.click("//button[@id='universityVerify']");
//	 * 
//	 * Thread.sleep(2000); ViewCommonUtil.click("(//button[@id='confirm'])[2]");
//	 * Thread.sleep(4000); ViewCommonUtil.selectDropDownItem("Academic Year",
//	 * "//select[@id='academicYearId']");
//	 * 
//	 * ViewCommonUtil.selectDropDownItem("Program",
//	 * "//select[@id='admittedprogramId']"); Thread.sleep(2000);
//	 * 
//	 * }
//	 */
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//	public void autoRefreshingUpToElementLocate(String strLocator) throws AWTException {
//		boolean elementFound = false;
//
//		try {
//			while (!elementFound) {
//				try {
//					driver.navigate().refresh();
//					Robot robot = new Robot();
//					Thread.sleep(200);
//					robot.keyPress(KeyEvent.VK_ENTER);
//					robot.keyRelease(KeyEvent.VK_ENTER);
//					ViewCommonUtil.click("//button[@id='transferSearchForm_search']");
//					Thread.sleep(650);
//					WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(strLocator)));
//					elementFound = element != null;
//				} catch (Exception e) {
//					driver.navigate().refresh();
//					Robot robot = new Robot();
//					ViewCommonUtil.click("//button[@id='transferSearchForm_search']");
//					Thread.sleep(200);
//					robot.keyPress(KeyEvent.VK_ENTER);
//					robot.keyRelease(KeyEvent.VK_ENTER);
//					Thread.sleep(2000);
//				}
//			}
//
//			System.out.println("Element found!");
//
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		} finally {
//			driver.quit();
//		}
//	}
//	public void addFiltersinStudentRegistrationPage() throws Exception {
//
//		ViewCommonUtil.selectDropDownItem("Academic Year", "//select[@id='academicYear']");
//		ViewCommonUtil.selectDropDownItem("Program", "//select[@id='branchListingForm_universityProgramId']");
//		ViewCommonUtil.selectDropDownItem("Program Type", "//select[@id='branchListingForm_programType']");
//
//	}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
