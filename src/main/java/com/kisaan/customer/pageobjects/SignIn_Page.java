package com.kisaan.customer.pageobjects;

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

public class SignIn_Page {
	private WebDriver driver;
	private WaitTypes applyWait;
	private ExtentTest test;
	private JavascriptClick javascriptClick;

	public SignIn_Page(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.applyWait = new WaitTypes(driver);
		this.test = test;
		javascriptClick = new JavascriptClick(driver);
	}

	@FindBy(xpath = "//a[contains(text(),'Create New Account')]")
	private WebElement createNewAccount_Link;
	
	@FindBy(id = "email")
	private WebElement emailAddress_TextBox;
	
	@FindBy(id = "password")
	private WebElement password_TextBox;
	
	@FindBy(xpath = "//input[@value='LOGIN']")
	private WebElement logIN_Button;
	
	public void click_CreateNewAccount_Link() throws IOException, InterruptedException {
			applyWait.waitForElementToBeClickable(createNewAccount_Link, DefineConstants.explicitWait_30);
			javascriptClick.highLighterMethod(createNewAccount_Link);
			javascriptClick.click(createNewAccount_Link);
			Screenshots.takeScreenshot(driver, "User clicked new account link on Sign In Page");
			test.log(Status.INFO, "User clicked new account link on Sign In Page");
			Log.info("User clicked new account link on Sign In Page");		
	}
	
	public void enter_EmailAddress(String input_EmailAddress) throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(emailAddress_TextBox, DefineConstants.explicitWait_30);
		javascriptClick.highLighterMethod(emailAddress_TextBox);
		emailAddress_TextBox.sendKeys(input_EmailAddress);
		Screenshots.takeScreenshot(driver, "User entered email address as "+ input_EmailAddress);
		test.log(Status.INFO, "User entered email address as "+ input_EmailAddress);
		Log.info("User entered email address as "+ input_EmailAddress);		
   }
	
	public void enter_Password(String input_Password) throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(password_TextBox, DefineConstants.explicitWait_30);
		javascriptClick.highLighterMethod(password_TextBox);
		password_TextBox.sendKeys(input_Password);
		Screenshots.takeScreenshot(driver, "User entered password as "+ input_Password);
		test.log(Status.INFO, "User entered password as "+ input_Password);
		Log.info("User entered password as "+ input_Password);		
    }
	
	public void click_LogIN_Button() throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(logIN_Button, DefineConstants.explicitWait_30);
		javascriptClick.highLighterMethod(logIN_Button);
		javascriptClick.click(logIN_Button);
		Screenshots.takeScreenshot(driver, "User clicked login button");
		test.log(Status.INFO, "User clicked login button");
		Log.info("User clicked login button");		
    }
}
