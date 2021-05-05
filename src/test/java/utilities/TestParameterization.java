package utilities;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestParameterization {

	@Test(dataProvider = "getData")
	public void testData(Hashtable<String, String> data) {

		System.out.println(data.get("Runmode") + " " + data.get("firstname") + " " + data.get("lastname") + " "
				+ data.get("postcode"));

	}

	@DataProvider
	public Object[][] getData() {

		ExcelReader excel = new ExcelReader("./src/test/resources/excel/testdata.xlsx");

		int rows = excel.getRowCount(ConstantData.DATA_SHEET);

		System.out.println("Total rows : " + rows);

		String testName = "OpenAccountTest";

		// Finding the TestCase Start Row ------

		int testCaseRowNum = 1;

		for (testCaseRowNum = 1; testCaseRowNum <= rows; testCaseRowNum++) {

			String testCaseName = excel.getCellData(ConstantData.DATA_SHEET, 0, testCaseRowNum);

			if (testCaseName.equalsIgnoreCase(testName)) {

				break;

			}
		}
		System.out.println(testCaseRowNum);

		// Checking the total rows int the Test Cases-------

		int dataStartRowNum = testCaseRowNum + 2;
		int dataRows = 0;

		while (!excel.getCellData(ConstantData.DATA_SHEET, 0, dataStartRowNum + dataRows).equals("")) {

			dataRows++;
		}
		System.out.println(dataRows);

		int ColStartNum = testCaseRowNum + 1;
		int dataCols = 0;

		while (!excel.getCellData(ConstantData.DATA_SHEET, dataCols, ColStartNum).equals("")) {

			dataCols++;
		}
		System.out.println("total cols are:  " + dataCols);

		// Printing the Test data

		Object[][] data = new Object[dataRows][1];

		int counter = 0;

		for (int rNum = dataStartRowNum; rNum < (dataStartRowNum + dataRows); rNum++) {

			Hashtable<String, String> dataTable = new Hashtable<String, String>();

			for (int cNum = 0; cNum < dataCols; cNum++) {

				System.out.println(excel.getCellData(ConstantData.DATA_SHEET, cNum, rNum));

				String testData = excel.getCellData(ConstantData.DATA_SHEET, cNum, rNum);

				String colnum = excel.getCellData(ConstantData.DATA_SHEET, cNum, ColStartNum);

				dataTable.put(testData, colnum);

			}
			
			data[counter][0] = dataTable;
			counter++;

		}

		return data;
	}

}
