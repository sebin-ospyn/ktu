import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.TestNG;
import org.testng.collections.Lists;
import com.ospyn.ktu.test.Login;



public class TestNGClass {


	public static void main(String[] args) throws Exception
	{    	
		TestNG testng;
		List<String> suites = Lists.newArrayList();
		//Reading from the excel file parameter listing
		FileInputStream fs= new FileInputStream(new File(System.getProperty("user.dir")+"/Test_Data/PARAMETER_LISTING.xlsx"));
		XSSFWorkbook workbook= new XSSFWorkbook(fs);
		XSSFSheet sheet= workbook.getSheetAt(10);

		//Getting number of colleges from excel sheet using last cell in a row
		int columns=sheet.getRow(1).getLastCellNum();
		System.out.println("No of colleges "+columns);
//		Storing  the module names in an array
		String testNames[]= {"XMLAdditionalFeeCollection.xml","testng.xml"};

//		String testNames[]= {"XMLabsenteeMalpracticeBulk.xml"};


//		//Running each module for each college
		for(int tests=0;tests<testNames.length;tests++)
		{
			testng=new TestNG();
			String suiteName="KTU_AutomationTestNG/"+testNames[tests];
			System.out.println(suiteName);
			suites.add(suiteName);
			System.out.println("Suites are "+suites);
			testng.setTestSuites(suites);

//			//Running the same suite for all the colleges
			for(int i=1;i<=columns-1;i++)
			{
				System.out.println("Columns are"+columns);
				testng.run();
			}
//			//Setting column number to 1 to start the next module from first college onwards
			Login.setColumn(1);	
			suites.remove(0);
		
		}

		
		
		



	}




}