package com.psci.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DriverScript {

	private FileInputStream fis;
	private Workbook wb;
	private Sheet sh;
	String[][] getData;
	
	public void testData(String fileName, String sheetName) throws BiffException, IOException{
		
		fis = new FileInputStream(fileName);
		wb = Workbook.getWorkbook(fis);
		sh = wb.getSheet(0);
		
		for(int i = 1; i < sh.getRows(); i++){
			
			String userName = sh.getCell(0, i).getContents();
			String passWord = sh.getCell(1, i).getContents();
			
			System.out.println(userName);
			System.out.println(passWord);
		}
	}
	
	
	
	public String[][] getTestData(String fileName, String sheetName) throws BiffException, IOException{
		try{
		
		fis = new FileInputStream(fileName);
		wb = Workbook.getWorkbook(fis);
		sh = wb.getSheet(sheetName);
		String strData=null;
		
		int rowCount = sh.getRows();
		int colCount = sh.getColumns();
		
		//Defining the size of two dimension array
		getData= new String[rowCount-1][colCount];
		
		for(int i = 1; i < rowCount; i++ ){
			for(int j = 0; j < colCount; j++){
				strData = sh.getCell(j, i).getContents();
				
				//Storing the data in array elements after fetching from excel through strData string variable
				getData[i-1][j]=strData;
			}
		}
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return getData;
	}
}
