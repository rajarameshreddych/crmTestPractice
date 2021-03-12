package com.rrr.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.rrr.base.TestBase;

public class TestUtils extends TestBase {


	public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir")
			+ "/src/main/java/com/rrr/testdata/MyData.xlsx";

	static Workbook book;
	static Sheet sheet;
	static JavascriptExecutor js;

	static Workbook workBook;
	static Sheet mySheet;

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}

	public static Object[][] readExcel(String sheetName){

		String filePath = System.getProperty("user.dir")+"/src/main/java/com/rrr/testdata";
		String fileName = "MyData.xlsx";

		try {

			File file =    new File(filePath+"/"+fileName);
			FileInputStream inputStream;
			inputStream = new FileInputStream(file);
			workBook = null;

			String fileExtensionName = fileName.substring(fileName.indexOf("."));

			if(fileExtensionName.equals(".xlsx")){
				workBook = new XSSFWorkbook(inputStream);
			}
			else if(fileExtensionName.equals(".xls")){
				workBook = new HSSFWorkbook(inputStream);

			}
		}
		catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		



		mySheet = workBook.getSheet(sheetName);


		int rowCount = mySheet.getLastRowNum()-mySheet.getFirstRowNum();

		Object[][] data = new Object[mySheet.getLastRowNum()-mySheet.getFirstRowNum()][mySheet.getRow(0).getLastCellNum()];

		for (int i = 1; i < rowCount+1; i++) {

			Row row = mySheet.getRow(i);


			for (int j = 0; j < row.getLastCellNum(); j++) {

				data[i-1][j] = row.getCell(j).getStringCellValue();

			}

		}
		return data; 

	}  

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

	
}
