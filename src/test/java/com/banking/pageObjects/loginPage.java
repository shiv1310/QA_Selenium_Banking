package com.banking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.banking.utilities.WebUtils;

public class loginPage {

	WebDriver ldriver;

	public loginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}

	@FindBy(css = "input[name=uid]")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(css = "input[name=password]")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(css = "input[name=btnLogin]")
	@CacheLookup
	WebElement btnLogin;

	@FindBy(xpath = "//a[text()='Log out']")
	@CacheLookup
	WebElement btnCloseIframe;

	@FindBy(id = "closeBtn")
	@CacheLookup
	WebElement btnLogout;
	
	public void setTxtUserName(String Username) {
		WebUtils.highlightElement(txtUserName);
		txtUserName.sendKeys(Username);
	}

	public void setTxtPassword(String password) {
		WebUtils.highlightElement(txtPassword);
		txtPassword.sendKeys(password);
	}

	public void clickSubmit() {
		WebUtils.highlightElement(btnLogin);
		btnLogin.click();
	}

	public void clickLogout() {
		WebUtils.highlightElement(btnLogout);
		btnLogout.click();
	}
	
	public void login(String Username,String password) {
		closeIframe();
		txtUserName.sendKeys(Username);
		txtPassword.sendKeys(password);
		btnLogin.click();
		closeIframe();
	}
	
	public void closeIframe() {
//		WebUtils.highlightElement(btnCloseIframe);
//		ldriver.switchTo().frame("iframe1");
//		btnCloseIframe.click();
//		ldriver.switchTo().defaultContent();
	}
}
