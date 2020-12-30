package com.banking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.pageObjects.loginPage;


public class TC_LoginTest_001 extends BaseClass{

	@Test
	public void loginTest() {
		openURL();
		loginPage ln = new loginPage(driver);
		ln.setTxtUserName(username); 
		logger.info("Username entered");
		
		ln.setTxtPassword(password);
		logger.info("Password entered");
		
		ln.clickSubmit();
		
		Assert.assertEquals(driver.getTitle(), "Guru99 Bank Manager HomePage");
		logger.info("Passed");
	}
}
