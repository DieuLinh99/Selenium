package EX4;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;

public class XLSReader {
	private FileInputStream fis;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private XSSFRow row;
	private XSSFCell cell;
	private CellStyle style;
	
	private String path = null;
	
	public XLSReader(String path){
		this.path = path;
	
	}
	
	public int getRow(String sheetName) throws IOException{
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		
		int rowCount = sheet.getLastRowNum();
		workbook.close();
		fis.close();
		return rowCount;
		
	}
	public int getCell(String sheetName, int rowIndex) throws IOException{
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowIndex);
		
		int cellCount = row.getLastCellNum(); 
		workbook.close();
		fis.close();
		return cellCount;
			
	}	
	public String getCellData(String sheetName, int rowIndex, int colIndex) throws IOException{	
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowIndex);
		cell = row.getCell(colIndex);
		
		DataFormatter formatter = new DataFormatter();
		String cellData;
		try {
			cellData = formatter.formatCellValue(cell);
		}catch(Exception e) {
			cellData = "";
		}
		workbook.close();
		fis.close();
		return cellData;
	}
}

