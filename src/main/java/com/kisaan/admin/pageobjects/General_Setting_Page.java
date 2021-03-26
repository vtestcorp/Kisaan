package com.kisaan.admin.pageobjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
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
import helperMethods.WaitTypes;

public class General_Setting_Page{
	
	private WebDriver driver;
	private WaitTypes applyWait;
	private ExtentTest test;
	private JavascriptClick javascriptClick;
	private DropDown dropDown;

	public General_Setting_Page(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.applyWait = new WaitTypes(driver);
		this.test = test;
		javascriptClick = new JavascriptClick(driver);
		dropDown=new DropDown(driver);
	}
	
	@FindBy(xpath = "//a[normalize-space()='General Settings']")
	private WebElement generalSettingTab;
	
	@FindBy(xpath = "//input[@name='logo']")
	private WebElement uploadImage;
	
	@FindBy(xpath = "//form[@action='settings/logo']//button[@type='submit'][normalize-space()='Update Settings']")
	private WebElement updateSetting;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissable']")
	private WebElement SuccessMessage;
	
	@FindBy(xpath = "//a[normalize-space()='Favicon']")
	private WebElement favicon;
	
	@FindBy(xpath = "//input[@name='favicon']")
	private WebElement uploadFaviconLogo;
	
	@FindBy(xpath = "//form[@action='settings/favicon']//button[@type='submit'][normalize-space()='Update Settings']")
	private WebElement updateFaviconSetting;
	
	@FindBy(xpath = "//a[normalize-space()='Website Contents']")
	private WebElement websiteContent;
	
	@FindBy(xpath = "//input[@placeholder='Website Title']")
	private WebElement websiteTitle;
	
	@FindBy(xpath = "//textarea[@placeholder='Popular Tags']")
	private WebElement popularTags;
	
	@FindBy(xpath = "//input[@placeholder='Currency Sign']")
	private WebElement currencySign;
	
	@FindBy(xpath = "//form[@action='settings/title']//button[@type='submit'][normalize-space()='Update Settings']")
	private WebElement UpdateSettingWebsiteContent;
	
	@FindBy(xpath = "//a[normalize-space()='Payment Settings']")
	private WebElement paymentSetting;
	
	@FindBy(xpath = "//input[@placeholder='Paypal Business']")
	private WebElement paypalBusiness;
	
	@FindBy(xpath = "//input[@placeholder='Stripe Key']")
	private WebElement stripKey;
	
	@FindBy(xpath = "//input[@placeholder='Stripe Secret Key']")
	private WebElement stripSecretKey;
	
	@FindBy(xpath = "//input[@placeholder='Mobile Money Instruction']")
	private WebElement mobileMoney;
	
	@FindBy(xpath = "//input[@placeholder='Bank Information']")
	private WebElement bankinformation;
	
	@FindBy(xpath = "//input[@name='dynamic_commission']")
	private WebElement dynamic;
	
	@FindBy(xpath = "//input[@name='fixed_commission']")
	private WebElement fixed;
	
	@FindBy(xpath = "//input[@name='tax']")
	private WebElement tax;
	
	@FindBy(xpath = "//input[@name='withdraw_fee']")
	private WebElement withdrawFee;
	
	@FindBy(xpath = "//input[@name='withdraw_charge']")
	private WebElement withdrawCharge;
	
	@FindBy(xpath = "//input[@name='shipping_cost']")
	private WebElement shippingCost;
	
	@FindBy(xpath = "//form[@action='settings/payment']//button[@type='submit'][normalize-space()='Update Settings']")
	private WebElement updatePaymentSettingButton;
	
	@FindBy(xpath = "//a[normalize-space()='Background']")
	private WebElement background;
	
	@FindBy(xpath = "//input[@name='background']")
	private WebElement uploadBackground;
	
	@FindBy(xpath = "//form[@action='settings/background']//button[@type='submit'][normalize-space()='Update Settings']")
	private WebElement updateBackgroundButton;
	
	@FindBy(xpath = "//a[normalize-space()='About Us']")
	private WebElement aboutUs;
	
	@FindBy(xpath = "//label[text()=' About Us Text ']/following-sibling::div/div[2]/div")
	private WebElement aboutUsTextbox;
	
	@FindBy(xpath = "//form[@action='settings/about']//button[@type='submit'][normalize-space()='Update Settings']")
	private WebElement aboutUsUpdate;
	
	@FindBy(xpath = "//a[normalize-space()='Office Address']")
	private WebElement officeAddress;
	
	@FindBy(xpath = "//textarea[@name='address']")
	private WebElement streetAddress;
	
	@FindBy(xpath = "//input[@placeholder='Phone Number']")
	private WebElement phoneNumber;
	
	@FindBy(xpath = "//input[@placeholder='Fax']")
	private WebElement fax;
	
	@FindBy(xpath = "//input[@placeholder='Email Address']")
	private WebElement emailAddress;
	
	@FindBy(xpath = "//form[@action='settings/address']//button[@type='submit'][normalize-space()='Update Settings']")
	private WebElement updateOffce;
	
	@FindBy(xpath = "//a[normalize-space()='Footer']")
	private WebElement footer;
	
	@FindBy(xpath = "//label[text()=' Footer Text ']/following-sibling::div/div[2]/div")
	private WebElement enterFooter;
	
	@FindBy(xpath = "//button[@id='footer_update']")
	private WebElement updateFooter;
	
	@FindBy(xpath = "//a[normalize-space()='PickUp Locations']")
	private WebElement pickUpLocations;
	
	@FindBy(xpath = "//input[@placeholder='New Pickup Address']")
	private WebElement pickUpAddress;
	
	@FindBy(xpath = "//button[normalize-space()='Add New Location']")
	private WebElement addLocationButton;
	
	@FindBy(xpath = "//table[@class='table']")
	private WebElement table;
	
	private List<WebElement> tableRows;

	private List<WebElement> tableColums;
	
	public void click_GeneralSettingPage() {
		applyWait.waitForElementToBeClickable(generalSettingTab, DefineConstants.explicitWait_60);
		javascriptClick.click(generalSettingTab);
		try {
			Screenshots.takeScreenshot(driver, "User clicked General Setting Page");
			test.log(Status.INFO, "User clicked General Setting Page");
			Log.info("User clicked General Setting Page");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void click_UpdateSettingButton() {
		applyWait.waitForElementToBeClickable(updateSetting, DefineConstants.explicitWait_60);
		javascriptClick.click(updateSetting);
		try {
			Screenshots.takeScreenshot(driver, "User clicked Update Setting Button");
			test.log(Status.INFO, "User clicked Update Setting Button");
			Log.info("User clicked Update Setting Button");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void upload_Image(String input_ImageName) {
		applyWait.waitForElementToBeClickable(uploadImage, DefineConstants.explicitWait_30)
				.sendKeys(DefineConstants.PROJECT_PATH + "FilesToUpload" + "/" + input_ImageName);
		try {
			Screenshots.takeScreenshot(driver, "User uploaded " + input_ImageName + "Image");
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(Status.INFO, "User uploaded " + input_ImageName + "Image");
		Log.info("User uploaded " + input_ImageName + "Image");
	}
	
	public void click_FaviconButton() {
		applyWait.waitForElementToBeClickable(favicon, DefineConstants.explicitWait_60);
		javascriptClick.click(favicon);
		try {
			Screenshots.takeScreenshot(driver, "User clicked Favicon Button");
			test.log(Status.INFO, "User clicked Favicon Button");
			Log.info("User clicked Favicon Button");		
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
	
	public void upload_FaviconImage(String input_ImageName) {
		applyWait.waitForElementToBeClickable(uploadFaviconLogo, DefineConstants.explicitWait_30)
				.sendKeys(DefineConstants.PROJECT_PATH + "FilesToUpload" + "/" + input_ImageName);
		try {
			Screenshots.takeScreenshot(driver, "User uploaded " + input_ImageName + "Image");
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(Status.INFO, "User uploaded " + input_ImageName + "Image");
		Log.info("User uploaded " + input_ImageName + "Image");
	}
	
	public void click_UpdateFaviconSettingButton() {
		applyWait.waitForElementToBeClickable(updateFaviconSetting, DefineConstants.explicitWait_60);
		javascriptClick.click(updateFaviconSetting);
		try {
			Screenshots.takeScreenshot(driver, "User clicked Update Setting Button");
			test.log(Status.INFO, "User clicked Update Setting Button");
			Log.info("User clicked Update Setting Button");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void click_WebsiteContent() {
		applyWait.waitForElementToBeClickable(websiteContent, DefineConstants.explicitWait_60);
		javascriptClick.click(websiteContent);
		try {
			Screenshots.takeScreenshot(driver, "User clicked Website Content");
			test.log(Status.INFO, "User clicked Website Content");
			Log.info("User clicked Website Content");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void enter_WebsiteTitle(String input) {
		applyWait.waitForElementToBeClickable(websiteTitle, DefineConstants.explicitWait_60).clear();
		websiteTitle.sendKeys(input);
		try {
			Screenshots.takeScreenshot(driver, "User enter Website Title as: " + input);
			test.log(Status.INFO, "User enter Website Title as: " + input);
			Log.info("User enter Website Title as: " + input);
			Thread.sleep(3000);
		} catch (Exception e) {
		}
	}
	
	public void enter_PopularTags(String input) {
		applyWait.waitForElementToBeClickable(popularTags, DefineConstants.explicitWait_60).clear();
		popularTags.sendKeys(input);
		try {
			Screenshots.takeScreenshot(driver, "User enter Popular Tags as: " + input);
			test.log(Status.INFO, "User enter Popular Tags as: " + input);
			Log.info("User enter Popular Tags as: " + input);
			Thread.sleep(3000);
		} catch (Exception e) {
		}
	}
	
	public void enter_CurrencySign(String input) {
		applyWait.waitForElementToBeClickable(currencySign, DefineConstants.explicitWait_60).clear();
		currencySign.sendKeys(input);
		try {
			Screenshots.takeScreenshot(driver, "User enter Currency Sign as: " + input);
			test.log(Status.INFO, "User enter Currency Sign as: " + input);
			Log.info("User enter Currency Sign as: " + input);
			Thread.sleep(3000);
		} catch (Exception e) {
		}
	}
	
	public void enableDisableButton1(String input,String num) {
		WebElement s = driver.findElement(By.xpath("//body/div/div/div[@class='container-fluid']/div[@class='row']/div[@class='panel panel-default']/div[@class='panel-body']/div[@class='col-xs-12']/div[@class='tab-content']/div[@class='tab-pane active']/form[@class='form-horizontal form-label-left']/div[@class='row']/div[2]/div["+num+"]/div[1]/div[1]"));
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
	
	public void enableDisableButton(String input,String num) {
		WebElement s = driver.findElement(By.xpath("//div[@class='tab-pane active']//div[1]//div["+num+"]//div[1]//div[1]"));
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
	
	public void enableDisableButtonNew(String input,String num) {
		WebElement s = driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='page-wrapper']/div[@class='container-fluid']/div[@id='main']/div[@class='panel panel-default']/div[@class='panel-body']/div[@class='col-xs-12']/div[@class='tab-content']/div[@id='website']/form[@id='website_form']/div[@class='row']/div[@class='col-md-6']/div["+num+"]/div[1]/div[1]"));
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
	
	public void click_UpdateWebsiteSettingButton() {
		applyWait.waitForElementToBeClickable(UpdateSettingWebsiteContent, DefineConstants.explicitWait_60);
		javascriptClick.click(UpdateSettingWebsiteContent);
		try {
			Screenshots.takeScreenshot(driver, "User clicked Update Setting Button");
			test.log(Status.INFO, "User clicked Update Setting Button");
			Log.info("User clicked Update Setting Button");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void click_PaymentSetting() {
		applyWait.waitForElementToBeClickable(paymentSetting, DefineConstants.explicitWait_60);
		javascriptClick.click(paymentSetting);
		try {
			Screenshots.takeScreenshot(driver, "User clicked Payment Setting");
			test.log(Status.INFO, "User clicked General Payment Setting");
			Log.info("User clicked General Payment Setting");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void enter_PaypalBusinessAccount(String input) {
		applyWait.waitForElementToBeClickable(paypalBusiness, DefineConstants.explicitWait_60).clear();
		paypalBusiness.sendKeys(input);
		try {
			Screenshots.takeScreenshot(driver, "User enter Paypal Business Account as: " + input);
			test.log(Status.INFO, "User enter Paypal Business Account as: " + input);
			Log.info("User enter Paypal Business Account as: " + input);
			Thread.sleep(3000);
		} catch (Exception e) {
		}
	}
	
	public void enter_StripeKey(String input) {
		applyWait.waitForElementToBeClickable(stripKey, DefineConstants.explicitWait_60).clear();
		stripKey.sendKeys(input);
		try {
			Screenshots.takeScreenshot(driver, "User enter Stripe Key as: " + input);
			test.log(Status.INFO, "User enter Stripe Key as: " + input);
			Log.info("User enter Stripe Key as: " + input);
			Thread.sleep(3000);
		} catch (Exception e) {
		}
	}
	
	public void enter_StripeSecretKey(String input) {
		applyWait.waitForElementToBeClickable(stripSecretKey, DefineConstants.explicitWait_60).clear();
		stripSecretKey.sendKeys(input);
		try {
			Screenshots.takeScreenshot(driver, "User enter Stripe Secret Key as: " + input);
			test.log(Status.INFO, "User enter Stripe Secret Key as: " + input);
			Log.info("User enter Stripe Secret Key as: " + input);
			Thread.sleep(3000);
		} catch (Exception e) {
		}
	}

	
	public void enter_MobileMoneyInstruction(String input) {
		applyWait.waitForElementToBeClickable(mobileMoney, DefineConstants.explicitWait_60).clear();
		mobileMoney.sendKeys(input);
		try {
			Screenshots.takeScreenshot(driver, "User enter Mobile Money instruction as: " + input);
			test.log(Status.INFO, "User enter Mobile Money instruction as: " + input);
			Log.info("User enter Mobile Money instruction as: " + input);
			Thread.sleep(3000);
		} catch (Exception e) {
		}
	}
	
	public void enter_BankInformation(String input) {
		applyWait.waitForElementToBeClickable(bankinformation, DefineConstants.explicitWait_60).clear();
		bankinformation.sendKeys(input);
		try {
			Screenshots.takeScreenshot(driver, "User enter Bank information as: " + input);
			test.log(Status.INFO, "User enter Bank information as: " + input);
			Log.info("User enter Bank information as: " + input);
			Thread.sleep(3000);
		} catch (Exception e) {
		}
	}

	
	public void enter_Dynamic_Commission(String input) {
		applyWait.waitForElementToBeClickable(dynamic, DefineConstants.explicitWait_60).clear();
		dynamic.sendKeys(input);
		try {
			Screenshots.takeScreenshot(driver, "User enter Dynamic Commission as: " + input);
			test.log(Status.INFO, "User enter Dynamic Commission as: " + input);
			Log.info("User enter Dynamic Commission as: " + input);
			Thread.sleep(3000);
		} catch (Exception e) {
		}
	}

	public void enter_Fixed_Commission(String input) {
		applyWait.waitForElementToBeClickable(fixed, DefineConstants.explicitWait_60).clear();
		fixed.sendKeys(input);
		try {
			Screenshots.takeScreenshot(driver, "User enter Fixed Commission as: " + input);
			test.log(Status.INFO, "User enter Fixed Commission as: " + input);
			Log.info("User enter Fixed Commission as: " + input);
			Thread.sleep(3000);
		} catch (Exception e) {
		}
	}
	
	public void enter_Tax(String input) {
		applyWait.waitForElementToBeClickable(tax, DefineConstants.explicitWait_60).clear();
		tax.sendKeys(input);
		try {
			Screenshots.takeScreenshot(driver, "User enter Tax as: " + input);
			test.log(Status.INFO, "User enter Tax as: " + input);
			Log.info("User enter Tax as: " + input);
			Thread.sleep(3000);
		} catch (Exception e) {
		}
	}
	
	public void enter_WithdrawFee(String input) {
		applyWait.waitForElementToBeClickable(withdrawFee, DefineConstants.explicitWait_60).clear();
		withdrawFee.sendKeys(input);
		try {
			Screenshots.takeScreenshot(driver, "User enter withdraw fee as: " + input);
			test.log(Status.INFO, "User enter  withdraw fee as: " + input);
			Log.info("User enter withdraw fee as: " + input);
			Thread.sleep(3000);
		} catch (Exception e) {
		}
	}
	
	public void enter_WithdrawCharge(String input) {
		applyWait.waitForElementToBeClickable(withdrawCharge, DefineConstants.explicitWait_60).clear();
		withdrawCharge.sendKeys(input);
		try {
			Screenshots.takeScreenshot(driver, "User enter withdraw charges as: " + input);
			test.log(Status.INFO, "User enter withdraw charges as: " + input);
			Log.info("User enter withdraw charges as: " + input);
			Thread.sleep(3000);
		} catch (Exception e) {
		}
	}
	
	public void enter_ShippingCost(String input) {
		applyWait.waitForElementToBeClickable(shippingCost, DefineConstants.explicitWait_60).clear();
		shippingCost.sendKeys(input);
		try {
			Screenshots.takeScreenshot(driver, "User enter Shipping Cost as: " + input);
			test.log(Status.INFO, "User enter Shipping Cost as: " + input);
			Log.info("User enter Shipping Cost as: " + input);
			Thread.sleep(3000);
		} catch (Exception e) {
		}
	}
	
	public void enableDisableButtonPayment(String input,String num) {
		WebElement s = driver.findElement(By.xpath("//div[@class='tab-pane active']//div[1]//div["+num+"]//div[1]//div[1]"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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
	
	public void enableDisableButtonPaymentNew(String input,String num) {
		WebElement s = driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='page-wrapper']/div[@class='container-fluid']/div[@id='main']/div[@class='panel panel-default']/div[@class='panel-body']/div[@class='col-xs-12']/div[@class='tab-content']/div[@id='payment']/form[@id='website_form']/div[@class='row']/div[@class='col-md-6']/div["+num+"]/div[1]/div[1]"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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
	
	public void enableDisableButtonPayment2(String input,String num) {
		WebElement s = driver.findElement(By.xpath("//body/div/div/div[@class='container-fluid']/div[@class='row']/div[@class='panel panel-default']/div[@class='panel-body']/div[@class='col-xs-12']/div[@class='tab-content']/div[@class='tab-pane active']/form[@class='form-horizontal form-label-left']/div[@class='row']/div[2]/div["+num+"]/div[1]/div[1]"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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
	
	public void click_UpdatePaymentSettingButton() {
		applyWait.waitForElementToBeClickable(updatePaymentSettingButton, DefineConstants.explicitWait_60);
		javascriptClick.click(updatePaymentSettingButton);
		try {
			Screenshots.takeScreenshot(driver, "User clicked update Payment Setting button");
			test.log(Status.INFO, "User clicked update Payment Setting button");
			Log.info("User clicked update Payment Setting button");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void click_Background() {
		applyWait.waitForElementToBeClickable(background, DefineConstants.explicitWait_60);
		javascriptClick.click(background);
		try {
			Screenshots.takeScreenshot(driver, "User clicked Background");
			test.log(Status.INFO, "User clicked General Background");
			Log.info("User clicked General Background");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void upload_ImageBackground(String input_ImageName) {
		applyWait.waitForElementToBeClickable(uploadBackground, DefineConstants.explicitWait_30)
				.sendKeys(DefineConstants.PROJECT_PATH + "FilesToUpload" + "/" + input_ImageName);
		try {
			Screenshots.takeScreenshot(driver, "User uploaded " + input_ImageName + "Image");
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(Status.INFO, "User uploaded " + input_ImageName + "Image");
		Log.info("User uploaded " + input_ImageName + "Image");
	}
	
	public void click_UpdateSettingPageBackground() {
		applyWait.waitForElementToBeClickable(updateBackgroundButton, DefineConstants.explicitWait_60);
		javascriptClick.click(updateBackgroundButton);
		try {
			Screenshots.takeScreenshot(driver, "User clicked Update Setting button");
			test.log(Status.INFO, "User clicked Update Setting button");
			Log.info("User clicked Update Setting button");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void click_AboutUsPage() {
		applyWait.waitForElementToBeClickable(aboutUs, DefineConstants.explicitWait_60);
		javascriptClick.click(aboutUs);
		try {
			Screenshots.takeScreenshot(driver, "User clicked About Us page");
			test.log(Status.INFO, "User clicked About Us page");
			Log.info("User clicked About Us page");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void enter_AboutUsText(String input) {
		applyWait.waitForElementToBeClickable(aboutUsTextbox, DefineConstants.explicitWait_60).clear();
		aboutUsTextbox.sendKeys(input);
		try {
			Screenshots.takeScreenshot(driver, "User enter About us as: " + input);
			test.log(Status.INFO, "User enter About us as: " + input);
			Log.info("User enter About us as: " + input);
			Thread.sleep(3000);
		} catch (Exception e) {
		}
	}
	
	public void click_UpdateSettingPageAboutUs() {
		applyWait.waitForElementToBeClickable(aboutUsUpdate, DefineConstants.explicitWait_60);
		javascriptClick.click(aboutUsUpdate);
		try {
			Screenshots.takeScreenshot(driver, "User clicked Update Setting");
			test.log(Status.INFO, "User clicked Update Setting");
			Log.info("User clicked Update Setting");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void click_OfficeAddress() {
		applyWait.waitForElementToBeClickable(officeAddress, DefineConstants.explicitWait_60);
		javascriptClick.click(officeAddress);
		try {
			Screenshots.takeScreenshot(driver, "User clicked Office Address");
			test.log(Status.INFO, "User clicked Office Address");
			Log.info("User clicked Office Address");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void enter_StreetAddress(String input) {
		applyWait.waitForElementToBeClickable(streetAddress, DefineConstants.explicitWait_60).clear();
		streetAddress.sendKeys(input);
		try {
			Screenshots.takeScreenshot(driver, "User enter Street Address as: " + input);
			test.log(Status.INFO, "User enter Street Address as: " + input);
			Log.info("User enter Street Address as: " + input);
			Thread.sleep(3000);
		} catch (Exception e) {
		}
	}

	public void enter_PhoneNumber(String input) {
		applyWait.waitForElementToBeClickable(phoneNumber, DefineConstants.explicitWait_60).clear();
		phoneNumber.sendKeys(input);
		try {
			Screenshots.takeScreenshot(driver, "User enter phone number as: " + input);
			test.log(Status.INFO, "User enter phone number as: " + input);
			Log.info("User enter phone number as: " + input);
			Thread.sleep(3000);
		} catch (Exception e) {
		}
	}
	
	public void enter_Fax(String input) {
		applyWait.waitForElementToBeClickable(fax, DefineConstants.explicitWait_60).clear();
		fax.sendKeys(input);
		try {
			Screenshots.takeScreenshot(driver, "User enter fax as: " + input);
			test.log(Status.INFO, "User enter fax as: " + input);
			Log.info("User enter fax as: " + input);
			Thread.sleep(3000);
		} catch (Exception e) {
		}
	}
	
	public void enter_Email(String input) {
		applyWait.waitForElementToBeClickable(emailAddress, DefineConstants.explicitWait_60).clear();
		emailAddress.sendKeys(input);
		try {
			Screenshots.takeScreenshot(driver, "User enter Email as: " + input);
			test.log(Status.INFO, "User enter Email as: " + input);
			Log.info("User enter Email as: " + input);
			Thread.sleep(3000);
		} catch (Exception e) {
		}
	}
	
	public void click_UpdateOfficeButton() {
		applyWait.waitForElementToBeClickable(updateOffce, DefineConstants.explicitWait_60);
		javascriptClick.click(updateOffce);
		try {
			Screenshots.takeScreenshot(driver, "User clicked Update Office Address Button");
			test.log(Status.INFO, "User clicked Update Office Address Button");
			Log.info("User clicked Update Office Address Button");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void click_Footer() {
		applyWait.waitForElementToBeClickable(footer, DefineConstants.explicitWait_60);
		javascriptClick.click(footer);
		try {
			Screenshots.takeScreenshot(driver, "User clicked Footer");
			test.log(Status.INFO, "User clicked Footer");
			Log.info("User clicked Footer");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void enter_FooterInfo(String input) {
		applyWait.waitForElementToBeClickable(enterFooter, DefineConstants.explicitWait_60).clear();
		enterFooter.sendKeys(input);
		try {
			Screenshots.takeScreenshot(driver, "User enter footer as: " + input);
			test.log(Status.INFO, "User enter footer as: " + input);
			Log.info("User enter footer as: " + input);
			Thread.sleep(3000);
		} catch (Exception e) {
		}
	}
	
	public void click_UpdateFooter() {
		applyWait.waitForElementToBeClickable(updateFooter, DefineConstants.explicitWait_60);
		javascriptClick.click(updateFooter);
		try {
			Screenshots.takeScreenshot(driver, "User clicked update Footer button");
			test.log(Status.INFO, "User clicked update Footer button");
			Log.info("User clicked update Footer button");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void click_PickUpLocations() {
		applyWait.waitForElementToBeClickable(pickUpLocations, DefineConstants.explicitWait_60);
		javascriptClick.click(pickUpLocations);
		try {
			Screenshots.takeScreenshot(driver, "User clicked PickUp Locations");
			test.log(Status.INFO, "User clicked PickUp Locations");
			Log.info("User clicked PickUp Locations");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void enter_PickUpAddress(String input) {
		applyWait.waitForElementToBeClickable(pickUpAddress, DefineConstants.explicitWait_60).clear();
		pickUpAddress.sendKeys(input);
		try {
			Screenshots.takeScreenshot(driver, "User enter pickup address as: " + input);
			test.log(Status.INFO, "User enter pickup address as: " + input);
			Log.info("User enter pickup address as: " + input);
			Thread.sleep(3000);
		} catch (Exception e) {
		}
	}

	public void click_AddLocationsButton() {
		applyWait.waitForElementToBeClickable(addLocationButton, DefineConstants.explicitWait_60);
		javascriptClick.click(addLocationButton);
		try {
			Screenshots.takeScreenshot(driver, "User clicked Add Locations button");
			test.log(Status.INFO, "User clicked Add Locations button");
			Log.info("User clicked Add Locations button");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void verifyInputValue(String inputEmailAddress) {
		applyWait.waitForElementToBeClickable(table, DefineConstants.explicitWait_60);
		tableRows = table.findElements(By.tagName("tr"));

		for (int row = 0; row < tableRows.size(); row++) {
			tableColums = tableRows.get(row).findElements(By.tagName("td"));
			for (int column = 0; column < tableColums.size(); column++) {
				String cellText = tableColums.get(column).getText();
				if (cellText.contains(inputEmailAddress)) {
					System.out.println("value is " + cellText);
					javascriptClick.highLighterMethod(tableColums.get(column));
					Assert.assertTrue(true, inputEmailAddress + " is verified");
					test.log(Status.INFO, "value is " + cellText);
					Log.info("value is " + cellText);
					try {
						Screenshots.takeScreenshot(driver, inputEmailAddress + " is verified");
					} catch (IOException e) {
						e.printStackTrace();
					}
					test.log(Status.INFO, inputEmailAddress + " is verified");
					Log.info(inputEmailAddress + " is verified");
				}
				else if (cellText.equals("No matching records found")) {
					try {
						javascriptClick.highLighterMethod(tableColums.get(column));
						Screenshots.takeScreenshot(driver, inputEmailAddress + " is not found");
					} catch (IOException e) {
						e.printStackTrace();
					}
					test.log(Status.INFO, inputEmailAddress + " is not found");
					Log.info(inputEmailAddress + " is not found");
					Assert.assertTrue(false, inputEmailAddress + " is not found");
				}
			}
		}
	}
	
	public void click_Remove_PickUpLocation(String input) {
		WebElement slider = driver.findElement(By.xpath("//td[text()='"+input+"']/following-sibling::td/a"));
		javascriptClick.click(slider);
		try {
			Screenshots.takeScreenshot(driver, "User clicked on remove pick up location");
			test.log(Status.INFO, "User clicked on remove pick up location");
			Log.info("User clicked on remove pick up location");
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void refresh() {
		driver.navigate().refresh();
	}

}
