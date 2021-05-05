package utilities;

import java.lang.reflect.Method;
import java.util.Hashtable;
import org.testng.annotations.DataProvider;
import com.dooby.APITestingFrameworksetUp.BaseTest;

public class DataUtil extends BaseTest {

	@DataProvider(name = "exceldata", parallel = true)
	public Object[][] getData(Method m) {

		// String sheetName = "ValidateCreateCustomerAPI";
		String sheetName =  "testDataAPI";
		
	//	System.out.println(config.getProperty("testDataSheet"));
		
		

		int rows = excel.getRowCount(sheetName);

		String testName = m.getName();

		System.out.println("Test name is :- " + testName);

		int testCaseRowNum = 1;

		for (testCaseRowNum = 1; testCaseRowNum <= rows; testCaseRowNum++) {

			String testCaseName = excel.getCellData(sheetName, 0, testCaseRowNum);

			if (testCaseName.equalsIgnoreCase(testName)) {

				break;

			}
		}
		System.out.println(testCaseRowNum);

		// Checking the total rows int the Test Cases-------

		int dataStartRowNum = testCaseRowNum + 2;
		int dataRows = 0;

		while (!excel.getCellData(sheetName, 0, dataStartRowNum + dataRows).equals("")) {

			dataRows++;
		}
		System.out.println(dataRows);

		int ColStartNum = testCaseRowNum + 1;
		int dataCols = 0;

		while (!excel.getCellData(sheetName, dataCols, ColStartNum).equals("")) {

			dataCols++;
		}
		System.out.println("total cols are:  " + dataCols);

		// Printing the Test data

		Object[][] data = new Object[dataRows][1];

		int counter = 0;

		for (int rNum = dataStartRowNum; rNum < (dataStartRowNum + dataRows); rNum++) {

			Hashtable<String, String> dataTable = new Hashtable<String, String>();

			for (int cNum = 0; cNum < dataCols; cNum++) {

				System.out.println(excel.getCellData(sheetName, cNum, rNum));

				String testData = excel.getCellData(sheetName, cNum, rNum);

				String colnum = excel.getCellData(sheetName, cNum, ColStartNum);

				dataTable.put(colnum,testData);

			}

			data[counter][0] = dataTable;
			counter++;

		}
		System.out.println(data.toString());
		return data;

	}

}
