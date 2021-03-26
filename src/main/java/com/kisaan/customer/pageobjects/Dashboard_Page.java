package com.kisaan.customer.pageobjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.google.common.base.Verify;

import config.DefineConstants;
import helperMethods.DropDown;
import helperMethods.JavascriptClick;
import helperMethods.Log;
import helperMethods.Screenshots;
import helperMethods.WaitTypes;

public class Dashboard_Page {
	private WebDriver driver;
	private WaitTypes applyWait;
	private ExtentTest test;
	private JavascriptClick javascriptClick;
    private DropDown dropDown;
	
	public Dashboard_Page(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.applyWait = new WaitTypes(driver);
		this.test = test;
		javascriptClick = new JavascriptClick(driver);
		dropDown = new DropDown(driver);
	}

	@FindBy(xpath = "//h2[contains(text(),'my dashboard')]")
	private WebElement myDashboard_Heading;
	
	@FindBy(xpath = "//a[text()='Home']")
	private WebElement home_Link;
	
	@FindBy(xpath = "//span[contains(text(),'My Account')]")
	private WebElement myAccount_Link;
	
	@FindBy(xpath = "//a[contains(text(),'Edit address')]")
	private WebElement editAddress_Button;
	
	@FindBy(xpath = "//a[contains(text(),'Change Password')]")
	private WebElement changePassword_Link;
	
	@FindBy(xpath = "//a[contains(text(),'Category')]")
	private WebElement categories_Link;
	
	@FindBy(id = "sortby")
	private WebElement sort_Dropdown;
	
	@FindBy(xpath = "//a[normalize-space()='Logout']")
	private WebElement Logout;
	
	@FindBy(xpath = "//a[@href='http://www.kisaansquad.com/admin/products']//span[@class='pull-right']//i[@class='fa fa-chevron-circle-right']")
	private WebElement viewAllButton;
	
	@FindBy(xpath = "//h3[text()='Products ']")
	private WebElement productsName;

	public void verfiy_MyDashboard() throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(myDashboard_Heading, DefineConstants.explicitWait_30);
		if (myDashboard_Heading.isDisplayed()) {
			javascriptClick.highLighterMethod(myDashboard_Heading);
			Screenshots.takeScreenshot(driver, "User successfully signed up");
			test.log(Status.INFO, "User successfully signed up");
			Log.info("User successfully signed up");
		}
	}
	
	public void click_Home() throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(home_Link, DefineConstants.explicitWait_30);
		javascriptClick.click(home_Link);
		Screenshots.takeScreenshot(driver, "User clicked home link");
		test.log(Status.INFO, "User clicked home link");
		Log.info("User clicked home link");		
	}
	
	public void click_MyAccountLink() throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(myAccount_Link, DefineConstants.explicitWait_30);
		javascriptClick.click(myAccount_Link);
		Screenshots.takeScreenshot(driver, "User clicked My Account link");
		test.log(Status.INFO, "User clicked My Account link");
		Log.info("User clicked My Account link");		
	}
	
	public void click_EditAddress_Button() throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(editAddress_Button, DefineConstants.explicitWait_30);
		javascriptClick.click(editAddress_Button);
		Screenshots.takeScreenshot(driver, "User clicked edit address button");
		test.log(Status.INFO, "User clicked edit address button");
		Log.info("User clicked edit address button");		
	}
	
	public void click_ChangePasword_Button() throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(changePassword_Link, DefineConstants.explicitWait_30);
		javascriptClick.click(changePassword_Link);
		Screenshots.takeScreenshot(driver, "User clicked change password link");
		test.log(Status.INFO, "User clicked change password link");
		Log.info("User clicked change password link");		
	}

	public void select_Product(String input_Product) throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(categories_Link, DefineConstants.explicitWait_30).click();
		driver.findElement(By.xpath("//ul[@class='list-type-1']//a[normalize-space()='"+input_Product+"']")).click();
		Screenshots.takeScreenshot(driver, "User selected "+input_Product);
		test.log(Status.INFO, "User selected "+input_Product);
		Log.info("User selected "+input_Product);		
	}
	
	public void sort_Product(String input_Sort) throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(sort_Dropdown, DefineConstants.explicitWait_30);
		dropDown.selectByVisibleText(sort_Dropdown, input_Sort);
		Screenshots.takeScreenshot(driver, "User selected "+input_Sort +" in filter option");
		test.log(Status.INFO, "User selected "+input_Sort +" in filter option");
		Log.info("User selected "+input_Sort +" in filter option");		
	}
	
	public void click_Logout() throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(Logout, DefineConstants.explicitWait_30);
		javascriptClick.click(Logout);
		Screenshots.takeScreenshot(driver, "User clicked logout button");
		test.log(Status.INFO, "User clicked logout button");
		Log.info("User clicked logout button");		
	}
	
	public void VerifyDashboardEntries(String input, String num) {
		WebElement s=driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='page-wrapper']/div[@class='container-fluid']/div[@class='row']/div[@class='dashboard-header-area col-lg-12 col-md-12 col-sm-12 col-xs-12']/div["+num+"]/div/div[2]"));
		String cellText=s.getText().trim();
		
		if (cellText.contains(input)) {
			System.out.println("value is " + cellText);
			javascriptClick.highLighterMethod(s);
			Assert.assertTrue(true, input + " is verified");
			test.log(Status.INFO, "value is " + cellText);
			Log.info("value is " + cellText);
			try {
				Screenshots.takeScreenshot(driver, input + " is verified");
			} catch (IOException e) {
				e.printStackTrace();
			}
			test.log(Status.INFO, input + " is verified");
			Log.info(input + " is verified");
		}
		else if (cellText.equals("No matching records found")) {
			try {
				javascriptClick.highLighterMethod(s);
				Screenshots.takeScreenshot(driver, input + " is not found");
			} catch (IOException e) {
				e.printStackTrace();
			}
			test.log(Status.INFO, input + " is not found");
			Log.info(input + " is not found");
			Assert.assertTrue(false, input + " is not found");
		}
	}
	
	public void click_ViewAll() throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(viewAllButton, DefineConstants.explicitWait_60);
		javascriptClick.click(viewAllButton);
		Screenshots.takeScreenshot(driver, "User clicked View All button");
		test.log(Status.INFO, "User clicked View All button");
		Log.info("User clicked View All button");		
	}
	
	public void verifyProductsPage(String input) {
		applyWait.waitforElementToBeDisplayed(productsName, DefineConstants.explicitWait_60);
		javascriptClick.highLighterMethod(productsName);
		String s=productsName.getText();
		System.out.println(s);
		Assert.assertTrue(s.contains(input));
		try {
			Screenshots.takeScreenshot(driver, input + " is not found");
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.log(Status.INFO, "Product page is open");
		Log.info("Product page is open");
		
	}
	
}
