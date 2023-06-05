package com.Actitime.GenericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * this is a generic class which contains all the generic methods
 * @author Shraddha
 *
 */
public class File_Library {
	/**
	 * 
	 * @param key
	 * @return
	 * @throws IOException
	 */
public String readDataFromPropertyFile(String key) throws IOException {
	FileInputStream fis=new FileInputStream("./TestData/common data.property");
	Properties p=new Properties();
	p.load(fis);
	String value = p.getProperty(key);
	return value;
}

/**
 * 
 * @param sheetname
 * @param row
 * @param cell
 * @return
 * @throws IOException
 */
public String readDataFromExcel(String sheetname,int row,int cell) throws IOException {
	FileInputStream fis=new FileInputStream("./TestData/testdata.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	String value = wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
	return value;
}
}