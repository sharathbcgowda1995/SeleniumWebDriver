package com.java.youTubeSelenium;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//import org.apache.poi.xssf.usermodel.*;

public class ReadDataFromExcel {

	public static void main(String[] args) throws Exception {

		// Step 1
		FileInputStream file = new FileInputStream("C://Users//sharabc//Desktop//Selenium//DataDriven//Book1.xlsx");

		// Step 2
		XSSFWorkbook workbook = new XSSFWorkbook(file);

		// Step 3
		XSSFSheet sheet = workbook.getSheet("sheet1");
		XSSFSheet getSheetUsingIndex = workbook.getSheetAt(0);

		// Before iterate over all the excel elements
		int rowCount = sheet.getLastRowNum();
		int columnCount = sheet.getRow(0).getLastCellNum();

		// Step 4 and Step 5 Get rows and fetch the cells value
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				String value = sheet.getRow(i).getCell(j).toString();
				System.out.print(" " + value);
			}
			System.out.println();
		}

	}

}
