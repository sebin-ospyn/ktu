package com.ospyn.ktu.test;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

public class ParentBranch {
	public static String getParentBranchName(String childBranch,String program,String programType)throws Exception
	{
		FileInputStream fs=new FileInputStream(new File(System.getProperty("user.dir")+"/Test_Data/UniversityBranchReport.xls"));
		HSSFWorkbook workbook = new HSSFWorkbook(fs) ;

		String parentBranch="";

		//Getting the sheet
		HSSFSheet sheet = workbook.getSheetAt(0);
		for(int i=1;i<=sheet.getLastRowNum();i++)

		{
			Row row=sheet.getRow(i);
			String childBranchExcel=row.getCell(5).getStringCellValue();
			String programExcel=row.getCell(1).getStringCellValue();
			String programTypeExcel=row.getCell(2).getStringCellValue();

			if(childBranch.equalsIgnoreCase(childBranchExcel)&&program.equalsIgnoreCase(programExcel)&&programType.equalsIgnoreCase(programTypeExcel))
			{
				parentBranch=row.getCell(3).getStringCellValue();
				break;
			}
		}
		workbook.close();

		return parentBranch;


	}
	public static void main(String args[])throws Exception
	{
		//String parentBranchName=ParentBranch.getParentBranchName("child branch name");

		String branchName=ParentBranch.getParentBranchName("ELEcTRONICS & INSTRUMENTATION ENGINEERING","B.Tech","Full Time");
		System.out.println(branchName);
		branchName=StringUtils.substringBefore(branchName,"(").trim();
		System.out.println("branchName is "+branchName);



	}

}
