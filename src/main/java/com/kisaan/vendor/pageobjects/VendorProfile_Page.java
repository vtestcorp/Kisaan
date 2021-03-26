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

public class VendorProfile_Page {
	private WebDriver driver;
	private WaitTypes applyWait;
	private ExtentTest test;
	private JavascriptClick javascriptClick;

	public VendorProfile_Page(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.applyWait = new WaitTypes(driver);
		this.test = test;
		javascriptClick = new JavascriptClick(driver);
	}

	@FindBy(xpath = "//input[@id='uploadFile']")
	private WebElement changePhoto_Button;
	
	@FindBy(xpath = "//input[@name='name']")
	private WebElement vendorsOwnerName_Textbox;
	
	@FindBy(xpath = "//input[@name='shop_name']")
	private WebElement vendorsShopName_Textbox;
	
	@FindBy(xpath = "//input[@name='phone']")
	private WebElement phoneNumber_Textbox;
	
	@FindBy(xpath = "//button[normalize-space()='Update profile']")
	private WebElement updateProfile_Button;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissable']")
	private WebElement updateProfile_SuccessMessage;

	// Update Password
	@FindBy(xpath = "//input[@placeholder='Current Password']")
	private WebElement currentPassword_TextBox;

	@FindBy(xpath = "//input[@placeholder='New Password']")
	private WebElement newPassword_TextBox;
	
	@FindBy(xpath = "//input[@placeholder='Re-Type New Password']")
	private WebElement changePassword_TextBox;
	
	@FindBy(xpath = "//button[normalize-space()='Change Password']")
	private WebElement changePassword_Button;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissable']")
	private WebElement successMessage;
	
	@FindBy(xpath = "//a[normalize-space()='Change Password']")
	private WebElement changePassword_Link;
	
	public void upload_VendorPhoto(String fileName) throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(changePhoto_Button, DefineConstants.explicitWait_30).sendKeys(DefineConstants.PROJECT_PATH+"FilesToUpload"+"/"+fileName);
//			javascriptClick.highLighterMethod(changePhoto_Button);
			Screenshots.takeScreenshot(driver, "User uploaded profile pic successfully");
			test.log(Status.INFO, "User uploaded profile pic successfully");
			Log.info("User uploaded profile pic successfully");					
	}
	
	public void enter_VendorOwnerName(String input_OwnerName) throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(vendorsOwnerName_Textbox, DefineConstants.explicitWait_30).clear();
		vendorsOwnerName_Textbox.sendKeys(input_OwnerName);			
		Screenshots.takeScreenshot(driver, "User entered vendor owner name as "+input_OwnerName);
		test.log(Status.INFO, "User entered vendor owner name as "+input_OwnerName);
		Log.info("User entered vendor owner name as "+input_OwnerName);					
	}
	
	public void enter_VendorShopName(String input_ShopName) throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(vendorsShopName_Textbox, DefineConstants.explicitWait_30).clear();
		vendorsShopName_Textbox.sendKeys(input_ShopName);			
		Screenshots.takeScreenshot(driver, "User entered vendor shop name as "+input_ShopName);
		test.log(Status.INFO, "User entered vendor shop name as "+input_ShopName);
		Log.info("User entered vendor shop name as "+input_ShopName);					
	}
	
	public void enter_VendorPhoneNumber(String input_VendorPhoneNumber) throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(phoneNumber_Textbox, DefineConstants.explicitWait_30).clear();
		phoneNumber_Textbox.sendKeys(input_VendorPhoneNumber);			
		Screenshots.takeScreenshot(driver, "User entered vendor phone number as "+input_VendorPhoneNumber);
		test.log(Status.INFO, "User entered vendor phone number as "+input_VendorPhoneNumber);
		Log.info("User entered vendor phone number as "+input_VendorPhoneNumber);					
	}

	public void click_UpdateProfileButton() throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(updateProfile_Button, DefineConstants.explicitWait_30).click();					
		Screenshots.takeScreenshot(driver, "User clicked update profile button");
		test.log(Status.INFO, "User clicked update profile button");
		Log.info("User clicked update profile button");					
	}
	
	public void verify_UpdateProfileSuccessMessage() throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(updateProfile_SuccessMessage, DefineConstants.explicitWait_30);
		if(updateProfile_SuccessMessage.isDisplayed()){
			javascriptClick.highLighterMethod(updateProfile_SuccessMessage);
			Screenshots.takeScreenshot(driver, "Your Vendor Profile Updated Successfully displayed to the user");
			test.log(Status.INFO, "Your Vendor Profile Updated Successfully displayed to the user");
			Log.info("Your Vendor Profile Updated Successfully displayed to the user");					
		}
			
	}
	
	// Update Vendor Passoword
	
	public void click_ChangePasword_Button() throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(changePassword_Link, DefineConstants.explicitWait_30);
		javascriptClick.click(changePassword_Link);
		Screenshots.takeScreenshot(driver, "Vendor clicked change password link");
		test.log(Status.INFO, "Vendor clicked change password link");
		Log.info("Vendor clicked change password link");		
	}
	
	public void enter_CurrentPassword(String input_CurrentPassword) throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(currentPassword_TextBox, DefineConstants.explicitWait_30).clear();
		currentPassword_TextBox.sendKeys(input_CurrentPassword);		
		Screenshots.takeScreenshot(driver, "Vendor entered current password as "+ input_CurrentPassword);
		test.log(Status.INFO, "Vendor entered current password as "+ input_CurrentPassword);
		Log.info("Vendor entered current password as "+ input_CurrentPassword);		
    }
	
	public void new_Password(String new_CurrentPassword) throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(newPassword_TextBox, DefineConstants.explicitWait_30).clear();
		newPassword_TextBox.sendKeys(new_CurrentPassword);		
		Screenshots.takeScreenshot(driver, "Vendor entered new password as "+ new_CurrentPassword);
		test.log(Status.INFO, "Vendor entered new password as "+ new_CurrentPassword);
		Log.info("Vendor entered new password as "+ new_CurrentPassword);		
    }
	
	public void change_CurrentPassword(String change_CurrentPassword) throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(changePassword_TextBox, DefineConstants.explicitWait_30).clear();
		changePassword_TextBox.sendKeys(change_CurrentPassword);		
		Screenshots.takeScreenshot(driver, "Vendor entered change password as "+ change_CurrentPassword);
		test.log(Status.INFO, "Vendor entered change password as "+ change_CurrentPassword);
		Log.info("Vendor entered change password as "+ change_CurrentPassword);		
    }
	
	public void click_ChangePassword_Button() throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(changePassword_Button, DefineConstants.explicitWait_30);
		javascriptClick.click(changePassword_Button);
		Screenshots.takeScreenshot(driver, "Vendor clicked change password button");
		test.log(Status.INFO, "Vendor clicked change password button");
		Log.info("Vendor clicked change password button");		
    }
	
	public void verify_SuccessMessage() throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(successMessage, DefineConstants.explicitWait_30);
		if(successMessage.isDisplayed()){
		Assert.assertTrue(true, "Your Vendor Password Updated Successfully. is displayed to the user");
		javascriptClick.highLighterMethod(successMessage);
		Screenshots.takeScreenshot(driver, "Your Vendor Password Updated Successfully. is displayed to the user");
		test.log(Status.INFO, "Your Vendor Password Updated Successfully. is displayed to the user");
		Log.info("Your Vendor Password Updated Successfully. is displayed to the user");		
    }
	}
}