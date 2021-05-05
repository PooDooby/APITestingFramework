package scrapbook; 


import utilities.ConstantData;
import utilities.ExcelReader;

public class ReadingExlData {
	
	public static void main(String[] args) {
		
		
		ExcelReader excel = new ExcelReader("./src/test/resources/excel/testdata.xlsx");
		
		int rows =  excel.getRowCount(ConstantData.DATA_SHEET);
		
		System.out.println("Total rows : " + rows);
		
		String testName = "AddCustomerTest";
		
		// Finding the TestCase Start Row ------
		
		int testCaseRowNum = 1;
		
		for (testCaseRowNum=1;testCaseRowNum<=rows;testCaseRowNum++) {
			
			String testCaseName = excel.getCellData(ConstantData.DATA_SHEET, 0, testCaseRowNum);
			
			if(testCaseName.equalsIgnoreCase(testName)) {
				
				break;
				
			}
		}
		System.out.println(testCaseRowNum);		
		
		// Checking the total rows int the Test Cases-------
		
		int dataStartRowNum = testCaseRowNum +2;
		int dataRows = 0;
		
		while(!excel.getCellData(ConstantData.DATA_SHEET, 0, dataStartRowNum+dataRows).equals("")) {
			
			dataRows++;
		}
		System.out.println(dataRows);
		
		int ColStartNum = testCaseRowNum +1;
		int dataCols = 0;
		
		while(!excel.getCellData(ConstantData.DATA_SHEET, dataCols, ColStartNum).equals("")) {
			
			dataCols++;
		}
		System.out.println("total cols are:  "  + dataCols);
		
		//Printing the Test data
		
		for(int rNum=0;rNum<(dataStartRowNum+dataRows);rNum++) {
			
			
			for (int cNum=0;cNum<dataCols;cNum++) {
				
				System.out.println(excel.getCellData(ConstantData.DATA_SHEET, cNum, rNum));
				
			}
			
			
		}
		
		
	}

}
