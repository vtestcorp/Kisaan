package com.kisaan.vendor.pageobjects;

import java.io.IOException;
import java.util.List;

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
import helperMethods.DropDown;
import helperMethods.JavascriptClick;
import helperMethods.Log;
import helperMethods.Screenshots;
import helperMethods.ScrollTypes;
import helperMethods.WaitTypes;

public class MyWithdraws_Page {
	private WebDriver driver;
	private WaitTypes applyWait;
	private ExtentTest test;
	private JavascriptClick javascriptClick;
	private ScrollTypes scrollTypes;
	private DropDown dropdown;

	public MyWithdraws_Page(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.applyWait = new WaitTypes(driver);
		this.test = test;
		javascriptClick = new JavascriptClick(driver);
		scrollTypes = new ScrollTypes(driver);
		dropdown = new DropDown(driver);
	}

	@FindBy(xpath = "//a[normalize-space()='Withdraw Now']")
	private WebElement withdrawNow_Button;
	
	@FindBy(xpath = "//select[@id='withmethod']")
	private WebElement withdrawNow_Method;
	
	@FindBy(name = "amount")
	private WebElement withdrawAmount_TextBox;
	
	@FindBy(name = "acc_email")
	private WebElement enterAccountEmail_TextBox;
	
	@FindBy(name = "reference")
	private WebElement additionalReference_TextBox;
	
	@FindBy(xpath = "//button[contains(text(),'Withdraw')]")
	private WebElement withdraw_Button;
	
	@FindBy(name = "iban")
	private WebElement enter_IBANAccountNo_TextBox;
	
	@FindBy(name = "acc_name")
	private WebElement enter_IBANAccountName_TextBox;
	
	@FindBy(name = "address")
	private WebElement enter_IBANAccountAddress_TextBox;
	
	@FindBy(name = "swift")
	private WebElement enter_IBANSwiftCode_TextBox;
	
	@FindBy(xpath = "//h3[contains(text(),'Withdraw Now')]//following::div[4]")
	private WebElement alertMessage;

	public void click_WithDrawNowButton() throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(withdrawNow_Button, DefineConstants.explicitWait_30).click();
//		javascriptClick.click(withdraw_Button);
		Screenshots.takeScreenshot(driver, "User clicked withdraw now button");
		test.log(Status.INFO, "User clicked withdraw now button");
		Log.info("User clicked withdraw now button");
	}
	
	public void select_WithdrawMethod(String input_WithdrawMethod) throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(withdrawNow_Method, DefineConstants.explicitWait_30);
		dropdown.selectByVisibleText(withdrawNow_Method, input_WithdrawMethod);
		Screenshots.takeScreenshot(driver, "User selected "+input_WithdrawMethod+ " as withdraw method type");
		test.log(Status.INFO, "User selected "+input_WithdrawMethod+ " as withdraw method type");
		Log.info("User selected "+input_WithdrawMethod+ " as withdraw method type");
	}
	
	public void enter_WithdrawAmount(String input_WithdrawAmount) throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(withdrawAmount_TextBox, DefineConstants.explicitWait_30).sendKeys(input_WithdrawAmount);		
		Screenshots.takeScreenshot(driver, "User entered "+input_WithdrawAmount+ " as withdraw amount");
		test.log(Status.INFO, "User entered "+input_WithdrawAmount+ " as withdraw amount");
		Log.info("User entered "+input_WithdrawAmount+ " as withdraw amount");
	}
	
	public void enter_AccountEmail(String input_AccountEmail) throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(enterAccountEmail_TextBox, DefineConstants.explicitWait_30).sendKeys(input_AccountEmail);		
		Screenshots.takeScreenshot(driver, "User entered "+input_AccountEmail+ " as account email");
		test.log(Status.INFO, "User entered "+input_AccountEmail+ " as account email");
		Log.info("User entered "+input_AccountEmail+ " as account email");
	}
	
	public void enter_AdditionalReference(String input_AdditionalReference) throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(additionalReference_TextBox, DefineConstants.explicitWait_30).sendKeys(input_AdditionalReference);		
		Screenshots.takeScreenshot(driver, "User entered "+input_AdditionalReference+ " as additional reference");
		test.log(Status.INFO, "User entered "+input_AdditionalReference+ " as additional reference");
		Log.info("User entered "+input_AdditionalReference+ " as additional reference");
	}
	
	public void enter_IBANAccountNo(String input_IBANAccountNo) throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(enter_IBANAccountNo_TextBox, DefineConstants.explicitWait_30).sendKeys(input_IBANAccountNo);		
		Screenshots.takeScreenshot(driver, "User entered "+input_IBANAccountNo+ " as IBAN Account Number");
		test.log(Status.INFO, "User entered "+input_IBANAccountNo+ " as IBAN Account Number");
		Log.info("User entered "+input_IBANAccountNo+ " as IBAN Account Number");
	}
	
	public void enter_IBANAccountName(String input_IBANAccountName) throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(enter_IBANAccountName_TextBox, DefineConstants.explicitWait_30).sendKeys(input_IBANAccountName);		
		Screenshots.takeScreenshot(driver, "User entered "+input_IBANAccountName+ " as IBAN Account Name");
		test.log(Status.INFO, "User entered "+input_IBANAccountName+ " as IBAN Account Name");
		Log.info("User entered "+input_IBANAccountName+ " as IBAN Account Name");
	}
	
	public void enter_IBANAccountAddress(String input_IBANAccountAddress) throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(enter_IBANAccountAddress_TextBox, DefineConstants.explicitWait_30).sendKeys(input_IBANAccountAddress);		
		Screenshots.takeScreenshot(driver, "User entered "+input_IBANAccountAddress+ " as IBAN Account Address");
		test.log(Status.INFO, "User entered "+input_IBANAccountAddress+ " as IBAN Account Address");
		Log.info("User entered "+input_IBANAccountAddress+ " as IBAN Account Address");
	}
	
	public void enter_IBANSwiftCode(String input_IBANAccountSwiftCode) throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(enter_IBANSwiftCode_TextBox, DefineConstants.explicitWait_30).sendKeys(input_IBANAccountSwiftCode);		
		Screenshots.takeScreenshot(driver, "User entered "+input_IBANAccountSwiftCode+ " as IBAN Swift Code");
		test.log(Status.INFO, "User entered "+input_IBANAccountSwiftCode+ " as IBAN Swift Code");
		Log.info("User entered "+input_IBANAccountSwiftCode+ " as IBAN Swift Code");
	}
	
	public void click_WithDrawButton() throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(withdraw_Button, DefineConstants.explicitWait_30).click();
		Screenshots.takeScreenshot(driver, "User entered clicked withdraw button");
		test.log(Status.INFO, "User entered clicked withdraw button");
		Log.info("User entered clicked withdraw button");
	}
	
	public void verifySuccessMessage() throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(alertMessage, DefineConstants.explicitWait_30);		
		if(alertMessage.getText().contains("Insufficient Balance.")){
		javascriptClick.highLighterMethod(alertMessage);
		Screenshots.takeScreenshot(driver, "Insufficient Balance displayed to the user");
		test.log(Status.INFO, "Insufficient Balance displayed to the user");
		Log.info("Insufficient Balance displayed to the user");
		Assert.assertTrue(false,"Insufficient Balance displayed to the user");
		}
	}
}