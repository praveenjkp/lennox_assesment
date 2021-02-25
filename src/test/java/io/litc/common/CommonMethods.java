package io.litc.common;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Scenario;
import io.litc.common.Validator.TextValidator;

public class CommonMethods {

	WebDriverWait wait = null;
	TextValidator validator = new TextValidator();

	public void clickElement(By locator, AndroidDriver<WebElement> driver) {
		wait = new WebDriverWait(driver, 10);
		try {

			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
			element.click();
			
		} catch (NoSuchElementException e) {
			
		} catch (ElementClickInterceptedException e) {
			
		}
	}

	public void ClickPass(By locator, AndroidDriver<WebElement> driver, Scenario scn) {
		wait = new WebDriverWait(driver, 10);
		try {

			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
			element.click();
			
		} catch (NoSuchElementException e) {
			
		} catch (ElementClickInterceptedException e) {
			
		}
	}

	public void isElementVisible(By locator, AndroidDriver<WebElement> driver) {
		wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			
		} catch (NoSuchElementException e) {
			
		} catch(ElementNotVisibleException e) {
			
		}
	}

	public void enterText(By locator, String text, AndroidDriver<WebElement> driver) {

		clickElement(locator, driver);

		if (driver.isKeyboardShown()) {
			WebElement element = driver.findElement(locator);
			Actions a = new Actions(driver);
			a.sendKeys(text);
			a.perform();
			
			Assert.assertEquals(text, element.getText());
		}
		else {
			
		}
	}

	public void getOriginalText(By locator,String var, AndroidDriver<WebElement> driver) {
		isElementVisible(locator, driver);
		try {
			WebElement element = driver.findElement(locator);
			String value = element.getText();
			Map<String, String> map = new HashMap<String, String>();
	        map.put(var, value);
	        validator.setOriginalValue(map);
	        
		} catch (NoSuchElementException e) {
			
		}

	}
	
	public void getCartText(By locator,String var, AndroidDriver<WebElement> driver) {
		isElementVisible(locator, driver);
		try {
			WebElement element = driver.findElement(locator);
			String value = element.getText();
			Map<String, String> map = new HashMap<String, String>();
	        map.put(var, value);
	        validator.setCartValue(map);
	        
	        
		} catch (NoSuchElementException e) {
			
		}

	}
	
	public void verifydetailAndCart(Scenario scn) {
		boolean verify = validator.getoriginalValue().equals(validator.getCartValue());
		if(verify) {
			scn.log("detail page content and cart page content are same");
		}
		else {
			scn.log("detail page content and cart page content are not same");
		}
	}
	
	
	
	
	
		
			
			
			
		
	}


