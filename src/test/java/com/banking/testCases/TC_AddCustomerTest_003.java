package com.banking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.banking.pageObjects.AddCustomerPage;
import com.banking.pageObjects.loginPage;
import com.banking.utilities.XLUtils;

public class TC_AddCustomerTest_003 extends BaseClass {

	@Test(dataProvider = "NewCustomerData")
	public void addNewCustomer(String customerName, String gender, String dob, String addr, String city, String state,
			String pin, String mobileNum, String email, String pwd) throws InterruptedException, IOException {
		openURL();
		loginPage lp = new loginPage(driver);
		lp.login(username, password);

		Thread.sleep(3000);

		AddCustomerPage addcust = new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		logger.info("providing customer details....");
		addcust.custName(customerName);
		addcust.custgender(gender);
		String[] date = dob.split("/");
		addcust.custdob(date[0], date[1], date[2]);
		Thread.sleep(5000);
		addcust.custaddress(addr);
		addcust.custcity(city);
		addcust.custstate(state);
		addcust.custpinno(pin);
		addcust.custtelephoneno(mobileNum);

		email = email + "+" + randomestring()+ randomeNum() + "@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword(pwd);
		addcust.custsubmit();

		Thread.sleep(3000);

		logger.info("validation started....");

		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");

		if (res == true) {
			Assert.assertTrue(true);
			logger.info("test case passed....");

		} else {
			logger.info("test case failed....");
			Assert.assertTrue(false);
		}

	}

	@DataProvider(name = "NewCustomerData")
	String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/banking/testData/NewCustomerData.xlsx";

		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);

		String customerdata[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				customerdata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);// 1 0
			}
		}
		return customerdata;
	}

}
