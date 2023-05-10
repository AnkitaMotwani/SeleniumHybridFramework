package com.automation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	public ExcelDataProvider() {
		
		File src = new File("./TestData/LoginStockMarket.xlsx");
		FileInputStream fis;
		try {
			fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("File not found exception "+e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public String getStringData(String sheetNm,int row,int colmn) {
		
		return wb.getSheet(sheetNm).getRow(row).getCell(colmn).getStringCellValue();
	}
	public Double getNumericData(String sheetNm,int row,int colmn) {
		
		return wb.getSheet(sheetNm).getRow(row).getCell(colmn).getNumericCellValue();
	}

}
