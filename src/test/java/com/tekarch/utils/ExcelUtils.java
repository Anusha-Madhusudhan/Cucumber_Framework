/**
 * 
 */
package com.tekarch.utils;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.teckarck.constants.FileConstants;

/**
 * 
 */
public class ExcelUtils {
	
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	static XSSFRow row;
	static XSSFCell cell;
	
	
	
	public static String readCellDataFromExcelFile(String sheetName,int rowNum,int cellNum) throws InvalidFormatException, IOException {
		
	String filePath=FileConstants.LOGIN_TEST_DATA_EXCEL_FILE_PATH;
	
	 wb=new XSSFWorkbook(new File(filePath));
	 sheet=wb.getSheet(sheetName);
	
	row=sheet.getRow(rowNum);
//	XSSFCell cell1=row.getCell(1);
//	XSSFCell cell2=row.getCell(2);
	
//	String userName=cell1.getStringCellValue();
	
//	String pwd=cell2.getStringCellValue();
//	
//	String[] userCreds=new String[row.getLastCellNum()];
//	
//	userCreds[0]=userName;
//	userCreds[1]=pwd;
//	
//	return userCreds;
	
	 cell=row.getCell(cellNum);
	 
	 String cellValue=cell.getStringCellValue();
	 wb.close();
	
	return cellValue;
	
	
	
	
	
	}

	public static String[][] readExcelFile(String sheetName) throws InvalidFormatException, IOException {
		
		
//		String filePath=System.getProperty("user.dir")+"\\src\\test\\resources\\testData\\LoginTestData.xlsx";
		
		String filePath=FileConstants.LOGIN_TEST_DATA_EXCEL_FILE_PATH;
		
		
		wb=new XSSFWorkbook(new File(filePath));
		
		sheet=wb.getSheet(sheetName);
		
		int rowCount=sheet.getLastRowNum();
		
		int coloumnCount=sheet.getRow(0).getLastCellNum();
		
		
		String[][] userCreds=new String[rowCount][coloumnCount-1];
		
		for(int i=1;i<=rowCount;i++) {
			
			row=sheet.getRow(i);
			
			for(int j=1;j<coloumnCount;j++) {
				
				userCreds[i-1][j-1]=row.getCell(j).getStringCellValue();
				
				System.out.print(userCreds[i-1][j-1]+"   ");
			}
			
			System.out.println();
		}
		
		wb.close();
		
		return userCreds;
		
	}
}
