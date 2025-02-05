import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.TestNG;
import org.testng.collections.Lists;

import com.google.common.annotations.VisibleForTesting;
import com.ospyn.ktu.test.Login;
import com.ospyn.ktu.view.ViewFalseNumbergeneration;
import com.ospyn.ktu.view.ViewTimeTableValidating;
import com.ospyn.ktu.view.ViewValuationCamp;

import org.testng.TestNG;
import org.testng.collections.Lists;

import com.ospyn.ktu.view.ViewFalseNumbergeneration;

public class TestNGClass2 {

	//methos used to run xml files
	static public void createSuite(String name)
	{
		TestNG testng=new TestNG();
		List<String> suites = Lists.newArrayList();

		String suiteName="src/main/resources/"+name;
		suites.add(suiteName);
		testng.setTestSuites(suites);
		testng.run();
		suites.remove(0);
	}

	public static void main(String[] args) throws Exception
	{    
		runLogic();

	}

		//method is used to run xml files for a single time
		public static void runLogic() throws Exception{

		//Run suite validating time table
		TestNGClass2.createSuite("XMLValidatingTimeTable.XML");

		if(ViewTimeTableValidating.flag)
		{
			TestNGClass2.createSuite("XMLAddTimeTable.xml");	
		}
		else 
		{
			TestNGClass2.createSuite("XMLlogOUT.xml");
		}
		//Run,suite false number generation
		TestNGClass2.createSuite("XMLFalseNumberGeneration.xml");

		if(ViewFalseNumbergeneration.eflag) {
			TestNGClass2.createSuite("XMLAddFalseNumber.xml");

		}
		else{ 
			TestNGClass2.createSuite("XMLEditFalseNumber.xml"); 
		}


		//Run,suite  Valuation camp
		TestNGClass2.createSuite("XMLvaluationCamp.xml");
		if(ViewValuationCamp.eflag) {

			TestNGClass2.createSuite("XMLAddValuationCamp.xml");
		}
		else {
			TestNGClass2.createSuite("XMLEditValuationCamp.xml");
		}
	}




}	




