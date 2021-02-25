package io.litc.common.pages;

import org.openqa.selenium.By;


public class LoginPage {
	
	public static final By selectLang =  By.xpath("//android.widget.TextView[contains(@text, 'English')]");
	
	public static final By btn_langContinue =  By.xpath("//*[@resource-id='com.flipkart.android:id/select_btn']");
	
	public static final By link_emailOption =  By.xpath("//*[@resource-id='com.flipkart.android:id/tv_right_cta']");
	
	public static final By txt_emailId =  By.xpath("//android.widget.EditText[@content-desc='Email ID']");
	
	public static final By btn_emailConfirm =  By.xpath("//*[@resource-id='com.flipkart.android:id/button']");
	
	public static final By txt_pwdField =  By.xpath("//*[@resource-id='com.flipkart.android:id/phone_input']");
	
	public static final By btn_pwdConfirm =  By.xpath("//*[@resource-id='com.flipkart.android:id/button']");
	
}
