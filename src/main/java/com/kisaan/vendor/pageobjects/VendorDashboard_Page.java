package com.kisaan.vendor.pageobjects;

import java.io.IOException;

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
import helperMethods.WaitTypes;

public class VendorDashboard_Page {
	private WebDriver driver;
	private WaitTypes applyWait;
	private ExtentTest test;
	private JavascriptClick javascriptClick;

	public VendorDashboard_Page(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.applyWait = new WaitTypes(driver);
		this.test = test;
		javascriptClick = new JavascriptClick(driver);
	}

	@FindBy(xpath = "//h3[contains(text(),'Vendor Dashboard!')]")
	private WebElement vendorDashboard_Heading;
	
	@FindBy(xpath = "//p[contains(text(),'Current Balance!')]")
	private WebElement currentBalance_Accordion;
	
	@FindBy(xpath = "//p[contains(text(),'Total Item Sold!')]")
	private WebElement totalItemSold_Accordion;
	
	@FindBy(xpath = "//p[contains(text(),'Total Earnings!')]")
	private WebElement totalEarnings_Accordion;

	@FindBy(xpath = "//p[contains(text(),'Total Products!')]")
	private WebElement totalProducts_Accordion;
	
	@FindBy(xpath = "//p[contains(text(),'Orders Pending!')]")
	private WebElement ordersPending_Accordion;
	
	@FindBy(xpath = "//p[contains(text(),'Orders Processing!')]")
	private WebElement ordersProcessing_Accordion;
	
	@FindBy(xpath = "//p[contains(text(),'Orders Completed!')]")
	private WebElement ordersCompleted_Accordion;
	
	@FindBy(xpath = "//a[normalize-space()='Edit Profile']//preceding::a[1]")
	private WebElement username_Link;
	
	@FindBy(xpath = "//a[normalize-space()='Edit Profile']")
	private WebElement editProfile_Button;
	
	@FindBy(xpath = "//a[normalize-space()='Products']")
	private WebElement products_Button;
	
	@FindBy(xpath = "//a[normalize-space()='Withdraw Now']")
	private WebElement withdrawNow_Button;
	
	@FindBy(xpath = "//a[normalize-space()='Withdraw']")
	private WebElement withdraw_Button;
	
	public void verfiy_MyDashboard() throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(vendorDashboard_Heading, DefineConstants.explicitWait_30);
		if (vendorDashboard_Heading.isDisplayed()) {
			javascriptClick.highLighterMethod(vendorDashboard_Heading);
			Screenshots.takeScreenshot(driver, "User successfully signed up");
			test.log(Status.INFO, "User successfully signed up");
			Log.info("User successfully signed up");
			Assert.assertTrue(true, "Vendor is able to login successfully.");
		}
	}
	
	public void click_WithdrawLink() throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(withdraw_Button, DefineConstants.explicitWait_30).click();				
		Screenshots.takeScreenshot(driver, "User clicked withdraw button");
		test.log(Status.INFO, "User clicked withdraw button");
		Log.info("User clicked withdraw button");				
	}
	
	public void click_WithDrawNowButton() throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(withdrawNow_Button, DefineConstants.explicitWait_30).click();
//		javascriptClick.click(withdraw_Button);
		Screenshots.takeScreenshot(driver, "User clicked withdraw now button");
		test.log(Status.INFO, "User clicked withdraw now button");
		Log.info("User clicked withdraw now button");
	}
	
	public void verfiy_CurrentBalance_Accordion() throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(currentBalance_Accordion, DefineConstants.explicitWait_30);
		if (currentBalance_Accordion.isDisplayed()) {
			javascriptClick.highLighterMethod(currentBalance_Accordion);
			Screenshots.takeScreenshot(driver, "Current Balance Accordion Verified Successfully");
			test.log(Status.INFO, "Current Balance Accordion Verified Successfully");
			Log.info("Current Balance Accordion Verified Successfully");
			Assert.assertTrue(true, "Current Balance Accordion Verified Successfully");
		}
	}
	
	public void verfiy_TotalItemSold_Accordion() throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(totalItemSold_Accordion, DefineConstants.explicitWait_30);
		if (totalItemSold_Accordion.isDisplayed()) {
			javascriptClick.highLighterMethod(totalItemSold_Accordion);
			Screenshots.takeScreenshot(driver, "Total Item Sold Accordion Verified Successfully");
			test.log(Status.INFO, "Total Item Sold Accordion Verified Successfully");
			Log.info("Total Item Sold Accordion Verified Successfully");
			Assert.assertTrue(true, "Total Item Sold Accordion Verified Successfully");
		}
	}
	
	public void verfiy_TotalEarnings_Accordion() throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(totalEarnings_Accordion, DefineConstants.explicitWait_30);
		if (totalEarnings_Accordion.isDisplayed()) {
			javascriptClick.highLighterMethod(totalEarnings_Accordion);
			Screenshots.takeScreenshot(driver, "Total Earnings Accordion Verified Successfully");
			test.log(Status.INFO, "Total Earnings Accordion Verified Successfully");
			Log.info("Total Earnings Accordion Verified Successfully");
			Assert.assertTrue(true, "Total Earnings Accordion Verified Successfully");
		}
	}

	public void verfiy_TotalProducts_Accordion() throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(totalProducts_Accordion, DefineConstants.explicitWait_30);
		if (totalProducts_Accordion.isDisplayed()) {
			javascriptClick.highLighterMethod(totalProducts_Accordion);
			Screenshots.takeScreenshot(driver, "Total Products Accordion Verified Successfully");
			test.log(Status.INFO, "Total Products Accordion Verified Successfully");
			Log.info("Total Products Accordion Verified Successfully");
			Assert.assertTrue(true, "Total Products Accordion Verified Successfully");
		}
	}
	
	public void verfiy_OrdersPending_Accordion() throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(ordersPending_Accordion, DefineConstants.explicitWait_30);
		if (ordersPending_Accordion.isDisplayed()) {
			javascriptClick.highLighterMethod(ordersPending_Accordion);
			Screenshots.takeScreenshot(driver, "Orders Pending Accordion Verified Successfully");
			test.log(Status.INFO, "Orders Pending Accordion Verified Successfully");
			Log.info("Orders Pending Accordion Verified Successfully");
			Assert.assertTrue(true, "Orders Pending Accordion Verified Successfully");
		}
	}
	
	public void verfiy_OrdersProcessing_Accordion() throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(ordersProcessing_Accordion, DefineConstants.explicitWait_30);
		if (ordersProcessing_Accordion.isDisplayed()) {
			javascriptClick.highLighterMethod(ordersProcessing_Accordion);
			Screenshots.takeScreenshot(driver, "Orders Processing Accordion Verified Successfully");
			test.log(Status.INFO, "Orders Processing Accordion Verified Successfully");
			Log.info("Orders Processing Accordion Verified Successfully");
			Assert.assertTrue(true, "Orders Processing Accordion Verified Successfully");
		}
	}
	
	public void verfiy_OrdersCompleted_Accordion() throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(ordersCompleted_Accordion, DefineConstants.explicitWait_30);
		if (ordersCompleted_Accordion.isDisplayed()) {
			javascriptClick.highLighterMethod(ordersCompleted_Accordion);
			Screenshots.takeScreenshot(driver, "Orders Completed Accordion Verified Successfully");
			test.log(Status.INFO, "Orders Completed Accordion Verified Successfully");
			Log.info("Orders Completed Accordion Verified Successfully");
			Assert.assertTrue(true, "Orders Completed Accordion Verified Successfully");
		}
	}
	
	public void click_Username() throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(username_Link, DefineConstants.explicitWait_30).click();				
		Screenshots.takeScreenshot(driver, "User clicked username");
		test.log(Status.INFO, "User clicked username");
		Log.info("User clicked username");				
	}
	
	public void edit_ProfileButton() throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(editProfile_Button, DefineConstants.explicitWait_30).click();				
		Screenshots.takeScreenshot(driver, "User clicked edit profile button");
		test.log(Status.INFO, "User clicked edit profile button");
		Log.info("User clicked edit profile button");				
	}
	
	public void click_ProductsLink() throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(products_Button, DefineConstants.explicitWait_30).click();				
		Screenshots.takeScreenshot(driver, "User clicked products button");
		test.log(Status.INFO, "User clicked products button");
		Log.info("User clicked products button");				
	}
}
