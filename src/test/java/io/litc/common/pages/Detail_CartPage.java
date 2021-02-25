package io.litc.common.pages;


import org.openqa.selenium.By;


public class Detail_CartPage {

	public static final By cancel_locationPopUp = By.xpath("//*[@resource-id='com.flipkart.android:id/not_now_button']");

	public static final By select_firstObject = By.xpath("//*[@class='android.widget.TextView'][1]");

	

//	public static final By txt_detailSelect = By.xpath("//*[@class='android.widget.TextView'][1]");

	public static final By txt_detailTitle = By.xpath("//android.widget.TextView[contains(@text, 'Bose ')]");

	public static final By txt_detailPrice = By.xpath("//*[@class='android.widget.TextView'][2]");

	public static final By btn_addToCart = By.xpath("//android.widget.TextView[contains(@text, 'ADD TO CART')]");

	public static final By btn_goToCart = By.xpath("//android.widget.TextView[contains(@text, 'GO TO CART')]");
	
	public static final By dropdown_quantityInitial = By.xpath("//android.widget.TextView[contains(@text, 'Qty: 1')]");
	
//	public static final By dropdown_quantityFinal = By.xpath("//android.widget.TextView[contains(@text, 'Qty: 3')]");

	public static final By txt_cartTitle = By.xpath("//*[@class='android.widget.TextView'][1]");

	public static final By txt_cartPrice = By.xpath("//*[@class='android.widget.TextView'][2]");
	
	public static final By txt_removeitem = By.xpath("//android.widget.TextView[contains(@text, 'Remove']");

}
