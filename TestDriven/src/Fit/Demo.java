package Fit;

import java.io.IOException;

public class Demo {
	public static void main(String[] args) throws IOException{
		try {
			XLSReader reader = new XLSReader("C:\\Users\\User\\Downloads\\HCL\\Technical\\test.xlsx");
			String sheetName = "Sheet1";
			
			int noOfRow = reader.getRow(sheetName) + 1;
			int noOfCell = reader.getCell(sheetName, 1);	
			
			for(int i = 1; i < noOfRow; i++) {
				for(int j = 1; j < noOfCell; j++) {
					System.out.print(reader.getCellData(sheetName, i, j) + " ");
				}
				System.out.println("");
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
