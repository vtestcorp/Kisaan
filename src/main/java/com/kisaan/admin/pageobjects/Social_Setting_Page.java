package com.kisaan.admin.pageobjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import config.DefineConstants;
import helperMethods.DropDown;
import helperMethods.JavascriptClick;
import helperMethods.Log;
import helperMethods.Screenshots;
import helperMethods.WaitTypes;

public class Social_Setting_Page {
	
	private WebDriver driver;
	private WaitTypes applyWait;
	private ExtentTest test;
	private JavascriptClick javascriptClick;
	private DropDown dropDown;

	public Social_Setting_Page(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.applyWait = new WaitTypes(driver);
		this.test = test;
		javascriptClick = new JavascriptClick(driver);
		dropDown=new DropDown(driver);
	}
	
	@FindBy(xpath = "//a[normalize-space()='Social Settings']")
	private WebElement socialSettingTab;
	
	@FindBy(xpath = "//input[@name='facebook']")
	private WebElement facebookTextbox;
	
	@FindBy(xpath = "//input[@name='g_plus']")
	private WebElement googleTextbox;

	
	@FindBy(xpath = "//input[@name='twiter']")
	private WebElement	twiterTextbox;
	
	@FindBy(xpath = "//input[@name='linkedin']")
	private WebElement linkedinTextbox;
	
	@FindBy(xpath = "//button[normalize-space()='Update Social Settings']")
	private WebElement updateSocialSetting;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissable']")
	private WebElement SuccessMessage;
	
	@FindBy(xpath = "//a[normalize-space()='Theme Color Settings']")
	private WebElement themeColourSettingTab;
	
	@FindBy(xpath = "//input[@name='color']")
	private WebElement themeColourTextbox;
	
	@FindBy(xpath = "//button[normalize-space()='Update Website Color']")
	private WebElement updateWebsiteColourButton;
	
	public void click_Social_Setting_Tab() {
		applyWait.waitForElementToBeClickable(socialSettingTab, DefineConstants.explicitWait_60);
		socialSettingTab.click();
		try {
			Screenshots.takeScreenshot(driver, "User clicked Social Setting tab");
			test.log(Status.INFO, "User clicked Social Setting tab");
			Log.info("User clicked Social Setting tab");
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void enter_FacebookLink(String input) {
		applyWait.waitForElementToBeClickable(facebookTextbox, DefineConstants.explicitWait_60).clear();
		facebookTextbox.sendKeys(input);
		try {
			Screenshots.takeScreenshot(driver, "User enter facebook Link as: " + input);
			test.log(Status.INFO, "User enter facebook Link as: " + input);
			Log.info("User enter facebook Link as: " + input);
			Thread.sleep(3000);
		} catch (Exception e) {
		}
	}
	
	public void enableDisableButton(String input,String num) {
		WebElement s = driver.findElement(By.xpath("//body/div/div/div[@class='container-fluid']/div[@class='row']/div[@class='panel panel-default']/div[@class='panel-body']/form[@class='form-horizontal form-label-left']/div["+num+"]/div[2]/div[1]"));
		if (input.equalsIgnoreCase("Yes")) {
			if (!s.getAttribute("class").contains("off")) {
				System.out.println("Button is already Enabled");
				test.log(Status.INFO, "Button is already Enabled");
				Log.info("Button is already Enabled");
			}
			 else {
				s.click();
				System.out.println("Button is Enabled");
				test.log(Status.INFO, "Button is Enabled");
				Log.info("Button is Enabled");
			 }
		}
		if (input.equalsIgnoreCase("No")) {
			if (s.getAttribute("class").contains("off")) {
				System.out.println("Button is already Disabled");
				test.log(Status.INFO, "Button is already Disabled");
				Log.info("Button is already Disabled");
			}
			else {
				s.click();
				System.out.println("Button is Disabled");
				test.log(Status.INFO, "Button is Disabled");
				Log.info("Button is Disabled");
			}
		}
	}
	
	public void enter_GooglePlusLink(String input) {
		applyWait.waitForElementToBeClickable(googleTextbox, DefineConstants.explicitWait_60).clear();
		googleTextbox.sendKeys(input);
		try {
			Screenshots.takeScreenshot(driver, "User enter Google Plus Link as: " + input);
			test.log(Status.INFO, "User enter Google Plus Link as: " + input);
			Log.info("User enter Google Plus Link as: " + input);
			Thread.sleep(3000);
		} catch (Exception e) {
		}
	}
	
	public void enter_TwiterLink(String input) {
		applyWait.waitForElementToBeClickable(twiterTextbox, DefineConstants.explicitWait_60).clear();
		twiterTextbox.sendKeys(input);
		try {
			Screenshots.takeScreenshot(driver, "User enter Twiter Link as: " + input);
			test.log(Status.INFO, "User enter Twiter Link as: " + input);
			Log.info("User enter Twiter Link as: " + input);
			Thread.sleep(3000);
		} catch (Exception e) {
		}
	}
	
	public void enter_LinkedinLink(String input) {
		applyWait.waitForElementToBeClickable(linkedinTextbox, DefineConstants.explicitWait_60).clear();
		linkedinTextbox.sendKeys(input);
		try {
			Screenshots.takeScreenshot(driver, "User enter Linkedin Link as: " + input);
			test.log(Status.INFO, "User enter Linkedin Link as: " + input);
			Log.info("User enter Linkedin Link as: " + input);
			Thread.sleep(3000);
		} catch (Exception e) {
		}
	}
	
	public void click_UpdateSocial_Setting_Button() {
		applyWait.waitForElementToBeClickable(updateSocialSetting, DefineConstants.explicitWait_60);
		updateSocialSetting.click();
		try {
			Screenshots.takeScreenshot(driver, "User clicked Update Social Setting");
			test.log(Status.INFO, "User clicked Update Social Setting");
			Log.info("User clicked Update Social Setting");
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void verify_SuccessMessage(String input_ProductName) {
		String text = SuccessMessage.getText();
		if (text.contains(input_ProductName)) {
			javascriptClick.highLighterMethod(SuccessMessage);
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
	
	public void click_ThemeColourSetting() {
		applyWait.waitForElementToBeClickable(themeColourSettingTab, DefineConstants.explicitWait_60);
		themeColourSettingTab.click();
		try {
			Screenshots.takeScreenshot(driver, "User clicked Theme Colour Setting tab");
			test.log(Status.INFO, "User clicked Theme Colour Setting tab");
			Log.info("User clicked Theme Colour Setting tab");
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void enter_ThemeColourValue(String input) {
		applyWait.waitForElementToBeClickable(themeColourTextbox, DefineConstants.explicitWait_60).clear();
		themeColourTextbox.sendKeys(input);
		try {
			Screenshots.takeScreenshot(driver, "User enter Theme Colour Value as: " + input);
			test.log(Status.INFO, "User enter Theme Colour Value as: " + input);
			Log.info("User enter Theme Colour Value as: " + input);
			Thread.sleep(3000);
		} catch (Exception e) {
		}
	}
	
	public void click_UpdateWebsiteButton() {
		applyWait.waitForElementToBeClickable(updateWebsiteColourButton, DefineConstants.explicitWait_60);
		updateWebsiteColourButton.click();
		try {
			Screenshots.takeScreenshot(driver, "User clicked Update Website Colour Button");
			test.log(Status.INFO, "User clicked Update Website Colour Button");
			Log.info("User clicked Update Website Colour Button");
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
