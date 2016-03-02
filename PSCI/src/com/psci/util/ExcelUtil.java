package com.psci.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelUtil {
	
	public static String[][] getTestData(String pathName, String sheetName){
		Workbook wb = null;
		Sheet ws = null;
		Row rowValue = null;
		Cell cellValue = null;
		String[][] strData = null;
		String value = null;
		
		try{
			
			File filePath = new File(pathName);
			
			FileInputStream fis = new FileInputStream(filePath);
			
			wb = new HSSFWorkbook(fis);
			
			ws = wb.getSheet(sheetName);
			
			int rowCount = ws.getLastRowNum();
			
			int colCount = ws.getRow(0).getLastCellNum();
			
			strData = new String[rowCount][colCount];
			
			 
			 for(int i=1; i < rowCount; i++)
			 {
				// rowValue= ws.getRow(i +1);
				
				 for(int j=0; j < colCount; j++)
				 {
					 cellValue = rowValue.getCell(j);
					
					 if(cellValue.getCellType() == cellValue.CELL_TYPE_NUMERIC)
					 {
						 value = ((Double)cellValue.getNumericCellValue()).toString();
					 }
					 
					 if(cellValue.getCellType() == cellValue.CELL_TYPE_STRING)
					 {
						 value=cellValue.getStringCellValue();
					 }
					 					 					 
					 strData[i][j] = value;
				 }
			}
			 
			} catch (FileNotFoundException e){
				e.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			}
				return strData;
		}
		
}
