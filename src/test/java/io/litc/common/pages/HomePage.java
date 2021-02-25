package io.litc.common.pages;

import org.openqa.selenium.By;


public class HomePage {
	
	
	
	public static final By txt_homeSearchBox = By.xpath("//*[@resource-id='com.flipkart.android:id/search_widget_textbox']");
	
	public static final By txt_searchInputBox = By.xpath("//*[@resource-id='com.flipkart.android:id/search_autoCompleteTextView']");
	
	public static final By select_searchResults = By.xpath("//*[@resource-id='com.flipkart.android:id/txt_subtitle']");
	
	public static final By googleSmartLock = By.xpath("//android.widget.TextView[contains(@text, 'NEVER')]");
	
	
}
