package com.kisaan.customer.pageobjects;

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
import helperMethods.ScrollTypes;
import helperMethods.WaitTypes;

public class Registration_Page {
	private WebDriver driver;
	private WaitTypes applyWait;
	private ExtentTest test;
	private JavascriptClick javascriptClick;
	private ScrollTypes scroll;

	public Registration_Page(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.applyWait = new WaitTypes(driver);
		this.test = test;
		javascriptClick = new JavascriptClick(driver);
		scroll=new ScrollTypes(driver);
	}

	@FindBy(id = "reg_email")
	private WebElement emailAddress_TextBox;
	
	@FindBy(id = "reg_name")
	private WebElement name_TextBox;
	
	@FindBy(id = "reg_Pnumber")
	private WebElement phone_TextBox;
	
	
	@FindBy(id = "reg_address")
	private WebElement address_TextBox;
	
	@FindBy(id = "reg_city")
	private WebElement city_TextBox;
	
	@FindBy(id = "zip")
	private WebElement zip_TextBox;
	
	@FindBy(id = "reg_password")
	private WebElement password_TextBox;

	@FindBy(id = "confirm_password")
	private WebElement confirmPassword_TextBox;
	
	@FindBy(xpath = "//input[@value='sign up']")
	private WebElement signUp_Button;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissable']")
	private WebElement successSignup;
	
	
	public void enter_EmailAddress(String input_EmailAddress) throws IOException, InterruptedException {
			applyWait.waitForElementToBeClickable(emailAddress_TextBox, DefineConstants.explicitWait_30);
			javascriptClick.highLighterMethod(emailAddress_TextBox);
			emailAddress_TextBox.sendKeys(input_EmailAddress);
			Screenshots.takeScreenshot(driver, "User entered email address as "+ input_EmailAddress);
			test.log(Status.INFO, "User entered email address as "+ input_EmailAddress);
			Log.info("User entered email address as "+ input_EmailAddress);		
	}
	
	public void enter_Name(String input_Name) throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(name_TextBox, DefineConstants.explicitWait_30);
		javascriptClick.highLighterMethod(name_TextBox);
		name_TextBox.sendKeys(input_Name);
		Screenshots.takeScreenshot(driver, "User entered name as "+ input_Name);
		test.log(Status.INFO, "User entered name as "+ input_Name);
		Log.info("User entered name as "+ input_Name);		
    }

	public void enter_Phone(String input_Phone) throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(phone_TextBox, DefineConstants.explicitWait_30);
		javascriptClick.highLighterMethod(phone_TextBox);
		phone_TextBox.sendKeys(input_Phone);
		Screenshots.takeScreenshot(driver, "User entered phone as "+ input_Phone);
		test.log(Status.INFO, "User entered phone as "+ input_Phone);
		Log.info("User entered phone as "+ input_Phone);		
    }
	
	public void enter_Address(String input_Phone) throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(address_TextBox, DefineConstants.explicitWait_30);
		javascriptClick.highLighterMethod(address_TextBox);
		address_TextBox.sendKeys(input_Phone);
		Screenshots.takeScreenshot(driver, "User entered address as "+ input_Phone);
		test.log(Status.INFO, "User entered address as "+ input_Phone);
		Log.info("User entered address as "+ input_Phone);		
    }
	
	public void enter_City(String input_Phone) throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(city_TextBox, DefineConstants.explicitWait_30);
		javascriptClick.highLighterMethod(city_TextBox);
		city_TextBox.sendKeys(input_Phone);
		Screenshots.takeScreenshot(driver, "User entered city as "+ input_Phone);
		test.log(Status.INFO, "User entered city as "+ input_Phone);
		Log.info("User entered city as "+ input_Phone);		
    }
	
	public void enter_Zip(String input_Zip) throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(zip_TextBox, DefineConstants.explicitWait_30);
		javascriptClick.highLighterMethod(zip_TextBox);
		zip_TextBox.sendKeys(input_Zip);
		Screenshots.takeScreenshot(driver, "User entered zip as "+ input_Zip);
		test.log(Status.INFO, "User entered zip as "+ input_Zip);
		Log.info("User entered zip as "+ input_Zip);		
    }
	
	public void enter_Password(String input_Password) throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(password_TextBox, DefineConstants.explicitWait_30);
		javascriptClick.highLighterMethod(password_TextBox);
		password_TextBox.sendKeys(input_Password);
		Screenshots.takeScreenshot(driver, "User entered password as "+ input_Password);
		test.log(Status.INFO, "User entered password as "+ input_Password);
		Log.info("User entered password as "+ input_Password);		
    }
	
	public void enter_ConfirmPassword(String input_ConfirmPassword) throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(confirmPassword_TextBox, DefineConstants.explicitWait_30);
		javascriptClick.highLighterMethod(confirmPassword_TextBox);
		confirmPassword_TextBox.sendKeys(input_ConfirmPassword);
		Screenshots.takeScreenshot(driver, "User entered confirm password as "+ input_ConfirmPassword);
		test.log(Status.INFO, "User entered confirm password as "+ input_ConfirmPassword);
		Log.info("User entered confirm password as "+ input_ConfirmPassword);		
    }
	
	public void click_SignUp_Button() throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(signUp_Button, DefineConstants.explicitWait_30);
		javascriptClick.highLighterMethod(signUp_Button);
		javascriptClick.click(signUp_Button);
		Screenshots.takeScreenshot(driver, "User clicked sign up button");
		test.log(Status.INFO, "User clicked sign up button");
		Log.info("User clicked sign up button");		
    }
	
	public void verify_SuccessMessage(String input_ProductName){
		String text=successSignup.getText();
		System.out.println(text);
		if (text.contains(input_ProductName)) {
			scroll.scrollInToView(successSignup);
			javascriptClick.highLighterMethod(successSignup);
			System.out.println(input_ProductName + " is varified");
			try {
				Screenshots.takeScreenshot(driver, input_ProductName + " is varified");
			} catch (IOException e) {
				e.printStackTrace();
			}
			test.log(Status.INFO, input_ProductName + " is varified");
			Log.info(input_ProductName + " is varified");
		}
	}
	
}
