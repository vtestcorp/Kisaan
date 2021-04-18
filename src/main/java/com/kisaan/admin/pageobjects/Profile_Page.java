package com.kisaan.admin.pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import config.DefineConstants;
import helperMethods.JavascriptClick;
import helperMethods.Log;
import helperMethods.Screenshots;
import helperMethods.WaitTypes;

public class Profile_Page {
	private WebDriver driver;
	private WaitTypes applyWait;
	private ExtentTest test;
	private JavascriptClick javascriptClick;

	public Profile_Page(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.applyWait = new WaitTypes(driver);
		this.test = test;
		javascriptClick = new JavascriptClick(driver);
	}
	
	@FindBy(xpath = "//input[@name='email']")
	private WebElement emailAddress_TextBox;
	
	@FindBy(xpath = "//input[@name='phone']")
	private WebElement phoneNumber_TextBox;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement password_TextBox;
	
	@FindBy(xpath = "//input[@id='admin_btn']")
	private WebElement logIN_Button;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement update;
	
	@FindBy(xpath = "//h3[text()='Admin Dashboard! ']")
	private WebElement myDashboard_Heading;
	
	@FindBy(xpath = "//a[@class='dropdown-toggle']")
	private WebElement admin;
	
	@FindBy(xpath = "//a[text()=' Edit Profile']")
	private WebElement edit_Profile;
	
	@FindBy(xpath = "//a[normalize-space()='Logout']")
	private WebElement logout_Profile;
	
	@FindBy(xpath = "//a[@id='logo']")
	private WebElement logo;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissable']")
	private WebElement successMessageAddProducts;
	
	
	
	public void enter_EmailAddress(String input_EmailAddress) {
		applyWait.waitForElementToBeClickable(emailAddress_TextBox, DefineConstants.explicitWait_60).clear();
		javascriptClick.highLighterMethod(emailAddress_TextBox);
		emailAddress_TextBox.sendKeys(input_EmailAddress);
			try {
				Screenshots.takeScreenshot(driver, "User entered email address as "+ input_EmailAddress);
				test.log(Status.INFO, "User entered email address as "+ input_EmailAddress);
				Log.info("User entered email address as "+ input_EmailAddress);
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}	
   }
	
	public void enter_Phone_Number(String input_EmailAddress) {
		applyWait.waitForElementToBeClickable(phoneNumber_TextBox, DefineConstants.explicitWait_60).clear();
		javascriptClick.highLighterMethod(phoneNumber_TextBox);
		phoneNumber_TextBox.sendKeys(input_EmailAddress);
			try {
				Screenshots.takeScreenshot(driver, "User entered phone number as "+ input_EmailAddress);
				test.log(Status.INFO, "User entered phone number as "+ input_EmailAddress);
				Log.info("User entered phone number as "+ input_EmailAddress);
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}	
   }
	
	public void enter_Password(String input_Password){
		applyWait.waitForElementToBeClickable(password_TextBox, DefineConstants.explicitWait_60);
		javascriptClick.highLighterMethod(password_TextBox);
		password_TextBox.sendKeys(input_Password);
		try {
			Screenshots.takeScreenshot(driver, "User entered password as "+ input_Password);
			test.log(Status.INFO, "User entered password as "+ input_Password);
			Log.info("User entered password as "+ input_Password);
			Thread.sleep(3000);	
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void click_UpdateProfile() {
		applyWait.waitForElementToBeClickable(update, DefineConstants.explicitWait_60);
		javascriptClick.click(update);
		try {
			Screenshots.takeScreenshot(driver, "User clicked Update Profile button");
			test.log(Status.INFO, "User clicked Update Profile button");
			Log.info("User clicked Update Profile button");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void verify_SuccessMessage(String input_ProductName){
		String text=successMessageAddProducts.getText();
		System.out.println(text);
		if (text.contains(input_ProductName)) {
			javascriptClick.highLighterMethod(successMessageAddProducts);
			System.out.println(input_ProductName + " is verified");
			try {
				Screenshots.takeScreenshot(driver, input_ProductName + " is verified");
			} catch (IOException e) {
				e.printStackTrace();
			}
			test.log(Status.INFO, input_ProductName + " is verified");
			Log.info(input_ProductName + " is verified");
			driver.navigate().refresh();
		}
	}
	
	public void click_LogIN_Button() {
		applyWait.waitForElementToBeClickable(logIN_Button, DefineConstants.explicitWait_60);
		javascriptClick.click(logIN_Button);
		try {
			Screenshots.takeScreenshot(driver, "User clicked login button");
			test.log(Status.INFO, "User clicked login button");
			Log.info("User clicked login button");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void verfiy_AdminDashboard() {
		applyWait.waitForElementToBeClickable(myDashboard_Heading, DefineConstants.explicitWait_60);
		if (myDashboard_Heading.isDisplayed()) {
			System.out.println("Admin successfully signed in");
			javascriptClick.highLighterMethod(myDashboard_Heading);
			try {
				Screenshots.takeScreenshot(driver, "User successfully signed in");
				test.log(Status.INFO, "User successfully signed in");
			} catch (IOException e) {
				e.printStackTrace();
			}	
	}
	}
	
	public void click_Admin() {
		applyWait.waitForElementToBeClickable(admin, DefineConstants.explicitWait_60);
		javascriptClick.click(admin);
		try {
			Screenshots.takeScreenshot(driver, "User clicked admin ");
			test.log(Status.INFO, "User clicked admin");
			Log.info("User clicked admin");		
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	public void click_Edit_Profile() {
		applyWait.waitForElementToBeClickable(edit_Profile, DefineConstants.explicitWait_60);
		javascriptClick.click(edit_Profile);
		try {
			Screenshots.takeScreenshot(driver, "User clicked on Edit Profile");
			test.log(Status.INFO, "User clicked on Edit Profile");
			Log.info("User clicked on Edit Profile");		
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void click_Logout() {
		applyWait.waitForElementToBeClickable(logout_Profile, DefineConstants.explicitWait_60);
		javascriptClick.click(logout_Profile);
		try {
			Screenshots.takeScreenshot(driver, "User clicked on Logout");
			test.log(Status.INFO, "User clicked on Logout");
			Log.info("User clicked on Logout");		
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void verfiy_Logo_Visibility() {
		applyWait.waitForElementToBeClickable(logo, DefineConstants.explicitWait_60);
		if (logo.isDisplayed()) {
			System.out.println("Admin logout successfully");
			javascriptClick.highLighterMethod(logo);
			try {
				Screenshots.takeScreenshot(driver, "User logout successfully");
				test.log(Status.INFO, "User logout successfully");
			} catch (IOException e) {
				e.printStackTrace();
			}	
	}
	}
	
	
	
	
	
	
	
	
}
