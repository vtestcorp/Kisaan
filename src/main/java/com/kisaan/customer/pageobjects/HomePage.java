package com.kisaan.customer.pageobjects;

import java.awt.AWTException;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import config.DefineConstants;
import helperMethods.JavascriptClick;
import helperMethods.Log;
import helperMethods.Screenshots;
import helperMethods.ScrollTypes;
import helperMethods.WaitTypes;

public class HomePage {
	private WebDriver driver;
	private WaitTypes applyWait;
	private ExtentTest test;
	private JavascriptClick javascriptClick;
	private ScrollTypes scrollTypes;

	public HomePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.applyWait = new WaitTypes(driver);
		this.test = test;
		javascriptClick = new JavascriptClick(driver);
		scrollTypes = new ScrollTypes(driver);
	}

	@FindBy(xpath = "//span[contains(text(),'Sign In')]")
	private WebElement signIn_Link;

	@FindBy(xpath = "//span[contains(text(),'Search')]//preceding::i[1]")
	private WebElement find_Button;
	
	@FindBy(xpath = "//a[normalize-space()='Demo Store']")
	private WebElement demo_store;

	@FindBy(xpath = "//input[@id='searchdata']")
	private WebElement searchProduct_Textbox;

	@FindBy(xpath = "//h3[contains(text(),'No Products Found')]")
	private WebElement noProductsFound;

	@FindBy(xpath = "//span[contains(text(),'Successfully Added To Cart')]")
	private WebElement successfulAddedToCart;

	@FindBy(xpath = "//span[contains(text(),'My Cart')]")
	private WebElement myCart;

	@FindBy(xpath = "//a[contains(text(),'View Cart')]")
	private WebElement viewCart;

	@FindBy(xpath = "//span[contains(text(),'Vendor')]")
	private WebElement vendor_Link;
	
	@FindBy(xpath = "//a[@class='facebook']")
	private WebElement facebook_Link;
	
	@FindBy(xpath = "//img[@alt='Facebook']")
	private WebElement facebook_Title;
	
	@FindBy(xpath = "")
	private WebElement google_Title;
	
	@FindBy(xpath = "//span[normalize-space()='Join Twitter today.']")
	private WebElement twitter_Title;
	
	@FindBy(xpath = "//icon[@class='nav-logo lazy-loaded']//*[local-name()='svg']")
	private WebElement linkedin_Title;
	
	@FindBy(xpath = "//i[@class='fa fa-google']")
	private WebElement google_Link;
	
	@FindBy(xpath = "//i[@class='fa fa-twitter']")
	private WebElement twitter_Link;
	
	@FindBy(xpath = "//a[@class='tumblr']")
	private WebElement linkedin_Link;

	public void click_SignIn_Link() throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(signIn_Link, DefineConstants.explicitWait_30);
		javascriptClick.highLighterMethod(signIn_Link);
		javascriptClick.click(signIn_Link);
		Screenshots.takeScreenshot(driver, "User clicked sign in link on Home Page tab");
		test.log(Status.INFO, "User clicked sign in link on Home Page tab");
		Log.info("User clicked sign in link on Home Page tab");
	}

	public void verify_SignIn_Link() throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(signIn_Link, DefineConstants.explicitWait_30);
		if (signIn_Link.isDisplayed()) {
			javascriptClick.highLighterMethod(signIn_Link);			
			Screenshots.takeScreenshot(driver, "User logged out successfully");
			test.log(Status.INFO, "User logged out successfully");
			Log.info("User logged out successfully");
		}
	}

	public void click_Vendor_Link() throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(vendor_Link, DefineConstants.explicitWait_30);
		javascriptClick.highLighterMethod(vendor_Link);
		javascriptClick.click(vendor_Link);
		Screenshots.takeScreenshot	(driver, "User clicked Vendor link on Home Page tab");
		test.log(Status.INFO, "User clicked Vendor link on Home Page tab");
		Log.info("User clicked Vendor link on Home Page tab");
	}

	public void click_FindButton() throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(find_Button, DefineConstants.explicitWait_30).click();
		Screenshots.takeScreenshot(driver, "User clicked find button");
		test.log(Status.INFO, "User clicked find button");
		Log.info("User clicked find button");
		Thread.sleep(3000);
	}
	
	public void click_DemoStore() throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(demo_store, DefineConstants.explicitWait_30);
		javascriptClick.click(demo_store);
		Screenshots.takeScreenshot(driver, "User clicked Demo Store");
		test.log(Status.INFO, "User clicked Demo Store");
		Log.info("User clicked Demo Store");
		Thread.sleep(3000);
	}

	public void search_Product(String input_ProductName) throws IOException, InterruptedException {

		applyWait.waitForElementToBeClickable(searchProduct_Textbox, DefineConstants.explicitWait_30);
		searchProduct_Textbox.sendKeys(input_ProductName);
		searchProduct_Textbox.sendKeys(Keys.ENTER);
		Screenshots.takeScreenshot(driver, "User searched product " + input_ProductName);
		test.log(Status.INFO, "User searched product " + input_ProductName);
		Log.info("User searched product " + input_ProductName);
	}

	public void add_Products_ToCart(JSONArray jsonArray) throws IOException, InterruptedException, AWTException {
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject productDetails = (JSONObject) jsonArray.get(i);
			String productName = productDetails.get("productName").toString();

			System.out.println("prod name is " + productName);
			System.out.println("sequence " + i);
			scrollTypes.scrollUp();
			applyWait.waitForElementToBeClickable(find_Button, DefineConstants.explicitWait_30).click();
			searchProduct_Textbox.sendKeys(productName);
			searchProduct_Textbox.sendKeys(Keys.ENTER);
			Screenshots.takeScreenshot(driver, "User searched product " + productName);
			test.log(Status.INFO, "User searched product " + productName);
			Log.info("User searched product " + productName);
			String product;
			// add product to cart
			if (productName.equals("Onion")) {
				product=productName.toLowerCase();
			}else {
				product=productName;
			}
			WebElement productAddToCart = driver.findElement(By.xpath("//h4[contains(text(),'" + product + "')]//following::span[2]"));
			javascriptClick.click(productAddToCart);
			Screenshots.takeScreenshot(driver, "User clicked add to cart button for " + productName);
			test.log(Status.INFO, "User clicked add to cart button for " + productName);
			Log.info("User clicked add to cart button for " + productName);
			
		}
	}

	public void verify_SearchProduct(String input_ProductName) throws IOException, InterruptedException {
		if (driver.findElement(By.xpath("//h4[contains(text(),'" + input_ProductName + "')]")).isDisplayed()) {
			scrollTypes.scrollInToView(driver.findElement(By.xpath("//h4[contains(text(),'" + input_ProductName + "')]//preceding::img[1]")));
			javascriptClick.highLighterMethod(driver.findElement(By.xpath("//h4[contains(text(),'" + input_ProductName + "')]")));
			Screenshots.takeScreenshot(driver, "Product found as " + input_ProductName);
			test.log(Status.INFO, "Product found as " + input_ProductName);
			Log.info("Product found as " + input_ProductName);
			Assert.assertTrue(true);
		}
	}

	public void add_SearchedProductToCart(String input_ProductName) throws IOException, InterruptedException {
		WebElement s=driver.findElement(By.xpath("//h4[contains(text(),'" + input_ProductName + "')]//following::button[2]"));
		javascriptClick.click(s);
		Screenshots.takeScreenshot(driver, "User clicked add to cart button for " + input_ProductName);
		test.log(Status.INFO, "User clicked add to cart button for " + input_ProductName);
		Log.info("User clicked add to cart button for " + input_ProductName);
	}

	public void verify_SuccessMessage(String input_ProductName) throws IOException, InterruptedException {
		if (successfulAddedToCart.getText().equals(DefineConstants.Successfull_Added_To_Cart)) {
			javascriptClick.highLighterMethod(successfulAddedToCart);
			Screenshots.takeScreenshot(driver, input_ProductName + " added to cart successfull message is displayed");
			test.log(Status.INFO, input_ProductName + " added to cart successfull message is displayed");
			Log.info(input_ProductName + " added to cart successfull message is displayed");
			driver.navigate().refresh();
		}
	}

	public void openCart() throws IOException, InterruptedException, AWTException {
		scrollTypes.scrollUp();
		applyWait.waitForElementToBeClickable(myCart, DefineConstants.explicitWait_30);
		javascriptClick.highLighterMethod(myCart);
		javascriptClick.click(myCart);
		applyWait.waitForElementToBeClickable(viewCart, DefineConstants.explicitWait_30);
		javascriptClick.click(viewCart);
		Screenshots.takeScreenshot(driver, "User opened my cart for the customer");
		test.log(Status.INFO, "User opened my cart for the customer");
		Log.info("User opened my cart for the customer");
	}
	
	public void click_Facebook_Link() throws IOException, InterruptedException, AWTException {
		scrollTypes.scrollDown();
		applyWait.waitForElementToBeClickable(facebook_Link, DefineConstants.explicitWait_30);
		javascriptClick.highLighterMethod(facebook_Link);
		javascriptClick.click(facebook_Link);
		Screenshots.takeScreenshot	(driver, "User clicked facebook link on Home Page tab");
		test.log(Status.INFO, "User clicked facebook link on Home Page tab");
		Log.info("User clicked facebook link on Home Page tab");
	}
	
	public void verify_Facebook_Page() throws IOException, InterruptedException, AWTException {		
		applyWait.waitForElementToBeClickable(facebook_Title, DefineConstants.explicitWait_30);
		if(facebook_Title.isDisplayed()){
		javascriptClick.highLighterMethod(facebook_Title);		
		Screenshots.takeScreenshot	(driver, "Facebook page is verified");
		test.log(Status.INFO, "Facebook page is verified");
		Log.info("Facebook page is verified");
		}
	}
	
	public void verify_Google_Page() throws IOException, InterruptedException, AWTException {		
		applyWait.waitForElementToBeClickable(google_Title, DefineConstants.explicitWait_30);
		if(google_Title.isDisplayed()){
		javascriptClick.highLighterMethod(google_Title);		
		Screenshots.takeScreenshot	(driver, "Google page is verified");
		test.log(Status.INFO, "Google page is verified");
		Log.info("Google page is verified");
		}
	}
	
	public void verify_Twitter_Page() throws IOException, InterruptedException, AWTException {		
		applyWait.waitForElementToBeClickable(twitter_Title, DefineConstants.explicitWait_30);
		if(twitter_Title.isDisplayed()){
		javascriptClick.highLighterMethod(twitter_Title);		
		Screenshots.takeScreenshot	(driver, "Twitter page is verified");
		test.log(Status.INFO, "Twitter page is verified");
		Log.info("Twitter page is verified");
		}
	}
	
	public void verify_Linkedin_Page() throws IOException, InterruptedException, AWTException {		
		applyWait.waitForElementToBeClickable(linkedin_Title, DefineConstants.explicitWait_30);
		if(linkedin_Title.isDisplayed()){
		javascriptClick.highLighterMethod(linkedin_Title);		
		Screenshots.takeScreenshot	(driver, "Linkedin page is verified");
		test.log(Status.INFO, "Linkedin page is verified");
		Log.info("Linkedin page is verified");
		}
	}
	
	public void click_Google_Link() throws IOException, InterruptedException, AWTException {
		scrollTypes.scrollDown();
		applyWait.waitForElementToBeClickable(google_Link, DefineConstants.explicitWait_30);
		javascriptClick.highLighterMethod(google_Link);
		javascriptClick.click(google_Link);
		Screenshots.takeScreenshot	(driver, "User clicked google link on Home Page tab");
		test.log(Status.INFO, "User clicked google link on Home Page tab");
		Log.info("User clicked google link on Home Page tab");
	}
	
	public void click_Twitter_Link() throws IOException, InterruptedException, AWTException {
		scrollTypes.scrollDown();
		applyWait.waitForElementToBeClickable(twitter_Link, DefineConstants.explicitWait_30);
		javascriptClick.highLighterMethod(twitter_Link);
		javascriptClick.click(twitter_Link);
		Screenshots.takeScreenshot	(driver, "User clicked twitter link on Home Page tab");
		test.log(Status.INFO, "User clicked twitter link on Home Page tab");
		Log.info("User clicked twitter link on Home Page tab");
	}
	
	public void click_Linkedin_Link() throws IOException, InterruptedException, AWTException {
		scrollTypes.scrollDown();
		applyWait.waitForElementToBeClickable(linkedin_Link, DefineConstants.explicitWait_30);
		javascriptClick.highLighterMethod(linkedin_Link);
		javascriptClick.click(linkedin_Link);
		Screenshots.takeScreenshot	(driver, "User clicked linkedin link on Home Page tab");
		test.log(Status.INFO, "User clicked linkedin link on Home Page tab");
		Log.info("User clicked linkedin link on Home Page tab");
	}
}