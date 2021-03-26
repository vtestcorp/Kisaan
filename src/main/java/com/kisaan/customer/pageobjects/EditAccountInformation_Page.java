package com.kisaan.customer.pageobjects;

import java.io.IOException;

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
import helperMethods.WaitTypes;

public class EditAccountInformation_Page {
	private WebDriver driver;
	private WaitTypes applyWait;
	private ExtentTest test;
	private JavascriptClick javascriptClick;

	public EditAccountInformation_Page(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.applyWait = new WaitTypes(driver);
		this.test = test;
		javascriptClick = new JavascriptClick(driver);
	}

	@FindBy(id = "dash_fname")
	private WebElement fullName_Textbox;
	
	@FindBy(name = "phone")
	private WebElement phoneNumber_TextBox;
	
	@FindBy(name = "address")
	private WebElement address_TextBox;
	
	@FindBy(name = "city")
	private WebElement city_TextBox;
	
	@FindBy(name = "zip")
	private WebElement zip_TextBox;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissable']")
	private WebElement successEditMessage;
	
	@FindBy(xpath = "//input[@value='save'][@value='save']")
	private WebElement save_Button;
	
	@FindBy(id = "dash_password")
	private WebElement currentPassword_TextBox;

	@FindBy(id = "new_password")
	private WebElement newPassword_TextBox;
	
	@FindBy(id = "change_password")
	private WebElement changePassword_TextBox;
	
	@FindBy(xpath = "//input[@value='change password']")
	private WebElement changePassword_Button;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissable']")
	private WebElement successMessage;
	
	public void enter_FullName(String input_FullName) throws IOException, InterruptedException {
			applyWait.waitForElementToBeClickable(fullName_Textbox, DefineConstants.explicitWait_30).clear();
			fullName_Textbox.sendKeys(input_FullName);			
			Screenshots.takeScreenshot(driver, "User entered full name as "+ input_FullName);
			test.log(Status.INFO, "User entered full name as "+ input_FullName);
			Log.info("User entered full name as "+ input_FullName);		
	}
	
	public void enter_PhoneNumber(String input_PhoneNumber) throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(phoneNumber_TextBox, DefineConstants.explicitWait_30).clear();
		phoneNumber_TextBox.sendKeys(input_PhoneNumber);		
		Screenshots.takeScreenshot(driver, "User entered Phone number as "+ input_PhoneNumber);
		test.log(Status.INFO, "User entered Phone number as "+ input_PhoneNumber);
		Log.info("User entered Phone number as "+ input_PhoneNumber);		
   }
	
	public void enter_Address(String input_Address) throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(address_TextBox, DefineConstants.explicitWait_30).clear();
		address_TextBox.sendKeys(input_Address);		
		Screenshots.takeScreenshot(driver, "User entered address as "+ input_Address);
		test.log(Status.INFO, "User entered address as "+ input_Address);
		Log.info("User entered address as "+ input_Address);		
    }
	
	public void enter_City(String input_City) throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(city_TextBox, DefineConstants.explicitWait_30).clear();
		city_TextBox.sendKeys(input_City);		
		Screenshots.takeScreenshot(driver, "User entered city as "+ input_City);
		test.log(Status.INFO, "User entered city as "+ input_City);
		Log.info("User entered city as "+ input_City);		
    }
	
	public void enter_PostalCode(String PostalCode) throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(zip_TextBox, DefineConstants.explicitWait_30).clear();
		zip_TextBox.sendKeys(PostalCode);		
		zip_TextBox.sendKeys(Keys.ENTER);
		Screenshots.takeScreenshot(driver, "User entered Postal Code as "+ PostalCode);
		test.log(Status.INFO, "User entered Postal Code as "+ PostalCode);
		Log.info("User entered Postal Code as "+ PostalCode);		
    }
	
	public void click_Save_Button() throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(save_Button, DefineConstants.explicitWait_30).click();
		javascriptClick.click(save_Button);
		Screenshots.takeScreenshot(driver, "User clicked save button");
		test.log(Status.INFO, "User clicked save button");
		Log.info("User clicked save button");		
    }
	
	public void enter_CurrentPassword(String input_CurrentPassword) throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(currentPassword_TextBox, DefineConstants.explicitWait_30).clear();
		currentPassword_TextBox.sendKeys(input_CurrentPassword);		
		Screenshots.takeScreenshot(driver, "User entered current password as "+ input_CurrentPassword);
		test.log(Status.INFO, "User entered current password as "+ input_CurrentPassword);
		Log.info("User entered current password as "+ input_CurrentPassword);		
    }
	
	public void new_Password(String new_CurrentPassword) throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(newPassword_TextBox, DefineConstants.explicitWait_30).clear();
		newPassword_TextBox.sendKeys(new_CurrentPassword);		
		Screenshots.takeScreenshot(driver, "User entered new password as "+ new_CurrentPassword);
		test.log(Status.INFO, "User entered new password as "+ new_CurrentPassword);
		Log.info("User entered new password as "+ new_CurrentPassword);		
    }
	
	public void change_CurrentPassword(String change_CurrentPassword) throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(changePassword_TextBox, DefineConstants.explicitWait_30).clear();
		changePassword_TextBox.sendKeys(change_CurrentPassword);		
		Screenshots.takeScreenshot(driver, "User entered change password as "+ change_CurrentPassword);
		test.log(Status.INFO, "User entered change password as "+ change_CurrentPassword);
		Log.info("User entered change password as "+ change_CurrentPassword);		
    }
	
	public void click_ChangePassword_Button() throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(changePassword_Button, DefineConstants.explicitWait_30);
		javascriptClick.click(changePassword_Button);
		Screenshots.takeScreenshot(driver, "User clicked change password button");
		test.log(Status.INFO, "User clicked change password button");
		Log.info("User clicked change password button");		
    }
	
	public void verify_SuccessMessage() throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(successMessage, DefineConstants.explicitWait_30);
		if(successMessage.isDisplayed()){
		Assert.assertTrue(true, "Account Password Updated Successfully.");
		javascriptClick.highLighterMethod(successMessage);
		Screenshots.takeScreenshot(driver, "Account Password Updated Successfully. displayed to the user");
		test.log(Status.INFO, "Account Password Updated Successfully. displayed to the user");
		Log.info("Account Password Updated Successfully. displayed to the user");		
    }
	}
		
	public void successMessageEdit(String input_ProductName) {
			String text=successEditMessage.getText();
			System.out.println(text);
			if (text.contains(input_ProductName)) {
				javascriptClick.highLighterMethod(successEditMessage);
				System.out.println(input_ProductName + " is verified");
				try {
					Screenshots.takeScreenshot(driver, input_ProductName + " is verified");
				} catch (IOException e) {
					e.printStackTrace();
				}
				test.log(Status.INFO, input_ProductName + " is verified");
				Log.info(input_ProductName + " is verified");
		
			}
		}
 }
