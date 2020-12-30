package com.banking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.banking.utilities.WebUtils;

public class AddCustomerPage {

	WebDriver ldriver;

	public AddCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[text()='New Customer']")
	@CacheLookup
	WebElement lnkAddNewCustomer;

	@FindBy(how = How.CSS, using = "input[name='name']")
	@CacheLookup
	WebElement txtCustomerName;

	@FindBy(how = How.XPATH, using = "//input[@type='radio' and @value='x']")
	@CacheLookup
	WebElement rdGender;

	@CacheLookup
	@FindBy(how = How.ID_OR_NAME, using = "dob")
	WebElement txtdob;

	@CacheLookup
	@FindBy(how = How.NAME, using = "addr")
	WebElement txtaddress;

	@CacheLookup
	@FindBy(how = How.NAME, using = "city")
	WebElement txtcity;

	@CacheLookup
	@FindBy(how = How.NAME, using = "state")
	WebElement txtstate;

	@CacheLookup
	@FindBy(how = How.NAME, using = "pinno")
	WebElement txtpinno;

	@CacheLookup
	@FindBy(how = How.NAME, using = "telephoneno")
	WebElement txttelephoneno;

	@CacheLookup
	@FindBy(how = How.NAME, using = "emailid")
	WebElement txtemailid;

	@CacheLookup
	@FindBy(how = How.NAME, using = "password")
	WebElement txtpassword;

	@CacheLookup
	@FindBy(how = How.NAME, using = "sub")
	WebElement btnSubmit;

	public void clickAddNewCustomer() {
		WebUtils.highlightElement(lnkAddNewCustomer);
		lnkAddNewCustomer.click();
	}

	public void custName(String cname) {
		WebUtils.highlightElement(txtCustomerName);
		txtCustomerName.sendKeys(cname);
	}

	public void custgender(String cgender) {
		if(cgender.equals("M")) {
			cgender = "m";
		}else if(cgender.equals("F")) {
			cgender = "f";
		}
		String xpathValue = rdGender.toString();
		System.out.println(xpathValue);
		xpathValue = xpathValue.substring(xpathValue.indexOf("xpath:")+7,xpathValue.lastIndexOf("'"));
		System.out.println(xpathValue);
		WebElement genderWebElement = prepareWebElementWithDynamicXpath(xpathValue, cgender);
		String xpathValue01 = genderWebElement.toString();
		System.out.println(xpathValue01);
		genderWebElement.click();
		WebUtils.highlightElement(genderWebElement);
	}

	public void custdob(String mm, String dd, String yy) {
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
		WebUtils.highlightElement(txtdob);
	}

	public void custaddress(String caddress) {
		WebUtils.highlightElement(txtaddress);
		txtaddress.sendKeys(caddress);
	}

	public void custcity(String ccity) {
		WebUtils.highlightElement(txtcity);
		txtcity.sendKeys(ccity);
	}

	public void custstate(String cstate) {
		WebUtils.highlightElement(txtstate);
		txtstate.sendKeys(cstate);
	}

	public void custpinno(String cpinno) {
		WebUtils.highlightElement(txtpinno);
		txtpinno.sendKeys(String.valueOf(cpinno));
	}

	public void custtelephoneno(String ctelephoneno) {
		WebUtils.highlightElement(txttelephoneno);
		txttelephoneno.sendKeys(ctelephoneno);
	}

	public void custemailid(String cemailid) {
		WebUtils.highlightElement(txtemailid);
		txtemailid.sendKeys(cemailid);
	}

	public void custpassword(String cpassword) {
		WebUtils.highlightElement(txtpassword);
		txtpassword.sendKeys(cpassword);
	}

	public void custsubmit() {
		WebUtils.highlightElement(btnSubmit);
		btnSubmit.click();
	}

	private WebElement prepareWebElementWithDynamicXpath(String xpathValue, String substitutionValue) {

		return ldriver.findElement(By.xpath(xpathValue.replace("x", substitutionValue)));
	}

}