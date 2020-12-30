package com.banking.utilities;

import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.banking.testCases.BaseClass;

public class WebUtils {

	public static void highlightElement(WebElement element) {
		try {
			Thread.sleep(1000);
			for (int i = 0; i < 5; i++) {
				JavascriptExecutor js = (JavascriptExecutor) BaseClass.driver;
				js.executeScript("arguments[0].setAttribute('style','border: 5px solid red;');", element);
			}
			BaseClass.logger.info("Element has been highlighted");
		} catch (NoSuchElementException e) {
			BaseClass.logger.error("Element not found");
		} catch (Exception e) {
			BaseClass.logger.error("Fail to highlight element");
		}
	}
}
