package io.litc.stepdefenition;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

//import org.openqa.selenium.remote.DesiredCapabilities;

import com.saucelabs.saucerest.SauceREST;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.litc.common.SauceUtils;
import io.litc.common.ScreenshotHelper;
import io.litc.common.pages.Detail_CartPage;
import io.litc.common.pages.HomePage;
import io.litc.common.pages.LoginPage;
import io.litc.common.CommonMethods;
import io.litc.common.ExcelReader;

public class StepDefinitions {
	private AndroidDriver<WebElement> driver;
	private String sessionId;

	private String username = "mobile900";
	private String accesskey = "c02f856d551e498d800aae1650e2d4b9";

	private SauceUtils sauceUtils;
	CommonMethods methods = new CommonMethods();
	static ExtentTest test;
	static ExtentReports report;
	Scenario scenario;
	ExcelReader reader = new ExcelReader();

	@Before
	public void setUp(Scenario scenario) throws MalformedURLException {
		// Set up the ChromeOptions object, which will store the capabilities for the
		// Sauce run
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "Android GoogleAPI Emulator");
		capabilities.setCapability("deviceType", "tablet");//Android GoogleAPI Emulator Samsung_Galaxy_S9_free
		capabilities.setCapability("platformVersion", "10.0");
		capabilities.setCapability("app", "sauce-storage:flipkart.apk");
		capabilities.setCapability("browserName", "");
		capabilities.setCapability("deviceOrientation", "portrait");
		capabilities.setCapability("appiumVersion", "1.16.0");
		capabilities.setCapability("appActivity", "com.flipkart.android.SplashActivity");
		capabilities.setCapability("autoAcceptAlerts", false);
		capabilities.setCapability("autoGrantPermissions", false);
		driver = new AndroidDriver<WebElement>(new URL(
				"https://mobile900:c02f856d551e498d800aae1650e2d4b9@ondemand.us-west-1.saucelabs.com:443/wd/hub"),
				capabilities);

		SauceREST sauceREST = new SauceREST(username, accesskey);
		sauceUtils = new SauceUtils(sauceREST);
	}

	@After
	public void tearDown(Scenario scenario) {
		driver.closeApp();
		driver.removeApp("com.flipkart.android");
		driver.quit();
		sauceUtils.updateResults(!scenario.isFailed(), sessionId);
		
	}
	
	@AfterStep
    public void afterStep() {
		Date date = new Date();
	      //This method returns the time in millis
	      long timeMilli = date.getTime();
        ScreenshotHelper.screenshot(driver,timeMilli );
    }

	@Given("^I go to the login page of flipkart app$")
	public void go_to_login_page_of_flipkart_app() {
		methods.ClickPass(LoginPage.selectLang, driver, scenario);
		methods.ClickPass(LoginPage.btn_langContinue, driver, scenario);
	}

	@And("I enter email and password from datafile")
	public void enter_email_and_password_from_datafile() throws IOException, InvalidFormatException {
		
		List<Map<String, String>> testdata = reader.getData("D:\\Users\\PK19\\Documents\\Automation-Personal\\maven_temp\\lennox-litc\\src\\test\\resources\\data.xlsx", "Data");
		String userName = testdata.get(0).get("UserName");
		String password = testdata.get(0).get("Pwd");
		methods.clickElement(LoginPage.link_emailOption, driver);
		methods.enterText(LoginPage.txt_emailId, userName, driver);
		methods.clickElement(LoginPage.btn_emailConfirm, driver);
		methods.enterText(LoginPage.txt_pwdField, password, driver);
		methods.clickElement(LoginPage.btn_pwdConfirm, driver);
	}

	@When("I search for the item from datafile")
	public void search_for_the_Item_from_datafile() throws IOException, InvalidFormatException {
		List<Map<String, String>> testdata = reader.getData("D:\\Users\\PK19\\Documents\\Automation-Personal\\maven_temp\\lennox-litc\\src\\test\\resources\\data.xlsx", "Data");
		String searchItem = testdata.get(0).get("SearchItem");
		
//		methods.alterPresent(driver);
		methods.clickElement(HomePage.txt_homeSearchBox, driver);
		methods.enterText(HomePage.txt_searchInputBox, searchItem, driver);
		methods.clickElement(Detail_CartPage.select_firstObject, driver);
//		methods.clickElement(HomePage.select_searchResults, driver);
		methods.clickElement(Detail_CartPage.cancel_locationPopUp, driver);
	}

	@And("I look into the detail page of the first item")
	public void look_into_the_detail_page_of_the_item() {
		methods.clickElement(Detail_CartPage.txt_detailTitle, driver);
		methods.clickElement(Detail_CartPage.select_firstObject, driver);
		methods.getOriginalText(Detail_CartPage.txt_detailTitle, "title", driver);
		methods.getOriginalText(Detail_CartPage.txt_detailPrice, "price", driver);
	}

	@And("I add the item to the cart")
	public void add_item_to_cart() {
		driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
		methods.clickElement(Detail_CartPage.btn_addToCart, driver);
	}

	@Then("I go to the cart and increase the quantity")
	public void open_cart_and_increase_quantity() {
		methods.clickElement(Detail_CartPage.btn_goToCart, driver);
		
	}
	
	@And("I increase the quantity of the item from datafile")
	public void increase_the_quantity_of_the_item_from_sheetName_and_the_RowNumber() throws IOException, InvalidFormatException {
		List<Map<String, String>> testdata = reader.getData("D:\\Users\\PK19\\Documents\\Automation-Personal\\maven_temp\\lennox-litc\\src\\test\\resources\\data.xlsx", "Data");
		String quantity = testdata.get(0).get("OrderQuantity");
		methods.clickElement(Detail_CartPage.dropdown_quantityInitial, driver);
		methods.clickElement(By.xpath("//android.widget.TextView[contains(@text, 'Qty: '"+quantity+"')]"), driver);
		
	}

	@And("verify that only added item is available in the cart")
	public void verify_cart_with_added_item() {
		methods.getCartText(Detail_CartPage.txt_cartTitle, "title", driver);
		methods.getCartText(Detail_CartPage.txt_cartPrice, "title", driver);
		methods.verifydetailAndCart(scenario);
	}
	
	@And("I remove the item from the cart")
	public void remove_item_from_cart() {
		methods.clickElement(Detail_CartPage.txt_removeitem, driver);
	}

}
