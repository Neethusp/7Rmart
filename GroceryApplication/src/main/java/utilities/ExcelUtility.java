package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility{ 
	static FileInputStream f;
	static XSSFWorkbook w;
	static XSSFSheet sh;
	
	public static String readUsernameData(int row, int col, String sheet) throws IOException
	{
		
		f= new FileInputStream (System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\TestData.xlsx");
		w= new XSSFWorkbook(f);
		sh= w.getSheet(sheet);
		XSSFRow r= sh.getRow(row);
		XSSFCell c= r.getCell(col);
		return c.getStringCellValue();
	}
	public static String readPasswordData(int row, int col, String sheet) throws IOException

{
	
	f= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\TestData.xlsx");
	w= new XSSFWorkbook(f);
	sh= w.getSheet(sheet);
	XSSFRow r= sh.getRow(row);
	XSSFCell c= r.getCell(col);
	return c.getStringCellValue();
	
}
	
}

