package com.banking.testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.banking.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readConfig = new ReadConfig();
	public String baseURL = readConfig.getApplicationUrl();
	public String username = readConfig.getUsername();
	public String password = readConfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		logger = Logger.getLogger("Banking website");
		PropertyConfigurator.configure("log4j.properties");

		if (br.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", readConfig.getChromepath());
			driver = new ChromeDriver();
			ChromeOptions options =new ChromeOptions();
			options.setBinary(readConfig.getChromeExepath());
		} else if (br.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.firefox.driver", readConfig.getFirefoxpath());
			driver = new FirefoxDriver();
		} else if (br.equalsIgnoreCase("ie")) {
			
			System.setProperty("webdriver.ie.driver", readConfig.getIEpath());
			driver = new InternetExplorerDriver();
		}
		
	}

	protected void openURL() {
		driver.get(baseURL);
		logger.info("URL entered");
		driver.manage().window().maximize();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}
	
	public boolean isAlertPresent() // user defined method created to check alert is presetn or not
	{
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}

	}
}
