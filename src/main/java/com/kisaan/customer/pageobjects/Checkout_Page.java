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

import config.DefineConstants;
import helperMethods.DropDown;
import helperMethods.JavascriptClick;
import helperMethods.Log;
import helperMethods.Screenshots;
import helperMethods.ScrollTypes;
import helperMethods.WaitTypes;

public class Checkout_Page {
	private WebDriver driver;
	private WaitTypes applyWait;
	private ExtentTest test;
	private JavascriptClick javascriptClick;
	private ScrollTypes scrollTypes;
    private DropDown dropdown;
	
	public Checkout_Page(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.applyWait = new WaitTypes(driver);
		this.test = test;
		javascriptClick = new JavascriptClick(driver);
		scrollTypes = new ScrollTypes(driver);
		dropdown = new DropDown(driver);
	}

	@FindBy(id = "shipop")
	private WebElement shipToAddress_Dropdown;

	@FindBy(name = "name")
	private WebElement fullName_TextBox;
	
	@FindBy(name = "phone")
	private WebElement phone_TextBox;
	
	@FindBy(name = "pickup_location")
	private WebElement pickUpLocation_Dropdown;
	
	@FindBy(name = "email")
	private WebElement email_TextBox;
		
	@FindBy(name = "address")
	private WebElement address_TextBox;
	
	@FindBy(name = "city")
	private WebElement city_TextBox;
	
	@FindBy(name = "zip")
	private WebElement postalCode_TextBox;

	@FindBy(xpath = "//select[@name='method']")
	private WebElement selectPaymentMethod_Dropdown;
	
	@FindBy(name = "txn_id")
	private WebElement bankWire_TransactionID_TextBox;
	
	@FindBy(name = "txn_id")
	private WebElement transactionID_TextBox;
	
	@FindBy(id = "order_notes")
	private WebElement orderNotes_Textbox;
	
	@FindBy(xpath = "//input[@value='order now']")
	private WebElement orderNow_Button;
	
	@FindBy(xpath = "//h2[contains(text(),'Your Order Has been Submitted.')]")
	private WebElement orderConfirmation_Text;
	
	// Card Details
	@FindBy(name = "card")
	private WebElement card_TextBox;
		
	@FindBy(name = "cvv")
	private WebElement cvv_TextBox;
		
	@FindBy(name = "month")
	private WebElement month_TextBox;
		
	@FindBy(name = "year")
	private WebElement year_TextBox;
	
	// Ship to different address
	@FindBy(xpath = "//input[@class='shippingCheck']")
	private WebElement shipToDifferentAddress_CheckBox;
		
	@FindBy(id = "shippingFull_name")
	private WebElement shipToDifferentAddress_FullName_TextBox;
		
	@FindBy(id = "shipingPhone_number")
	private WebElement shipToDifferentAddress_PhoneNumber_TextBox;
		
	@FindBy(id = "ship_email")
	private WebElement shipToDifferentAddress_EmailAddress_TextBox;
		
	@FindBy(id = "shipping_address")
	private WebElement shipToDifferentAddress_Address_TextBox;
		
	@FindBy(id = "shipping_city")
	private WebElement shipToDifferentAddress_ShippingCity_TextBox;
		
	@FindBy(id = "shippingPostal_code")
	private WebElement shipToDifferentAddress_PostalCode_TextBox;
	
	public void select_ShipToAddress_Dropdown(String input_ShipToAddress) throws IOException{
		applyWait.waitForElementToBeClickable(shipToAddress_Dropdown, DefineConstants.explicitWait_30);
		dropdown.selectByValue(shipToAddress_Dropdown, input_ShipToAddress);
		Screenshots.takeScreenshot(driver, "User selected shipping address as "+input_ShipToAddress);
		test.log(Status.INFO, "User selected shipping address as "+input_ShipToAddress);
		Log.info("User selected shipping address as "+input_ShipToAddress);
	}
	
	public void select_PickUpLocation_Dropdown(String input_PickUpLocation) throws IOException{
		applyWait.waitForElementToBeClickable(pickUpLocation_Dropdown, DefineConstants.explicitWait_30);
		dropdown.selectByVisibleText(pickUpLocation_Dropdown, input_PickUpLocation);
		Screenshots.takeScreenshot(driver, "User selected pick up location as "+input_PickUpLocation);
		test.log(Status.INFO, "User selected pick up location as "+input_PickUpLocation);
		Log.info("User selected pick up location as "+input_PickUpLocation);
	}
	
	public void enter_FullName(String input_FullName) throws IOException{
		applyWait.waitForElementToBeClickable(fullName_TextBox, DefineConstants.explicitWait_30).clear();
		fullName_TextBox.sendKeys(input_FullName);		
		Screenshots.takeScreenshot(driver, "User entered full name as "+input_FullName);
		test.log(Status.INFO, "User entered full name as "+input_FullName);
		Log.info("User entered full name as "+input_FullName);
	}
	
	public void enter_Phone(String input_Phone) throws IOException{
		applyWait.waitForElementToBeClickable(phone_TextBox, DefineConstants.explicitWait_30).clear();
		phone_TextBox.sendKeys(input_Phone);		
		Screenshots.takeScreenshot(driver, "User entered Phone number as "+input_Phone);
		test.log(Status.INFO, "User entered Phone number as "+input_Phone);
		Log.info("User entered Phone number as "+input_Phone);
	}
	
	public void enter_Email(String input_Email) throws IOException{
		applyWait.waitForElementToBeClickable(email_TextBox, DefineConstants.explicitWait_30).clear();
		email_TextBox.sendKeys(input_Email);		
		Screenshots.takeScreenshot(driver, "User entered email as "+ input_Email);
		test.log(Status.INFO, "User entered email as "+ input_Email);
		Log.info("User entered email as "+ input_Email);
	}
	
	public void enter_Address(String input_Address) throws IOException{
		applyWait.waitForElementToBeClickable(address_TextBox, DefineConstants.explicitWait_30).clear();
		address_TextBox.sendKeys(input_Address);		
		Screenshots.takeScreenshot(driver, "User entered address as "+ input_Address);
		test.log(Status.INFO, "User entered address as "+ input_Address);
		Log.info("User entered address as "+ input_Address);
	}
	
	public void enter_City(String input_City) throws IOException{
		applyWait.waitForElementToBeClickable(city_TextBox, DefineConstants.explicitWait_30).clear();
		city_TextBox.sendKeys(input_City);		
		Screenshots.takeScreenshot(driver, "User entered city as "+ input_City);
		test.log(Status.INFO, "User entered city as "+ input_City);
		Log.info("User entered city as "+ input_City);
	}
	
	public void enter_PostalCode(String input_PostalCode) throws IOException{
		applyWait.waitForElementToBeClickable(postalCode_TextBox, DefineConstants.explicitWait_30).clear();
		postalCode_TextBox.sendKeys(input_PostalCode);		
		Screenshots.takeScreenshot(driver, "User entered postal code as "+ input_PostalCode);
		test.log(Status.INFO, "User entered postal code as "+ input_PostalCode);
		Log.info("User entered postal code as "+ input_PostalCode);
	}
	
	public void select_PaymentMethod(String input_PaymentMethod) throws IOException{
		applyWait.waitForElementToBeClickable(selectPaymentMethod_Dropdown, DefineConstants.explicitWait_30).click();
		driver.findElement(By.xpath("//option[text()='"+input_PaymentMethod+"']")).click();
		Screenshots.takeScreenshot(driver, "User entered payment method as "+ input_PaymentMethod);
		test.log(Status.INFO, "User entered payment method as "+ input_PaymentMethod);
		Log.info("User entered payment method as "+ input_PaymentMethod);
	}
	
	public void enter_BankWireTransactionID(String input_BankWireTransactionID) throws IOException{
		applyWait.waitForElementToBeClickable(bankWire_TransactionID_TextBox, DefineConstants.explicitWait_30);
		javascriptClick.sendKeys(bankWire_TransactionID_TextBox, input_BankWireTransactionID);
		Screenshots.takeScreenshot(driver, "User entered bank wire transaction ID  as "+ input_BankWireTransactionID);
		test.log(Status.INFO, "User entered bank wire transaction ID as "+ input_BankWireTransactionID);
		Log.info("User entered bank wire transaction ID as "+ input_BankWireTransactionID);
	}
	
	public void enter_TransactionID(String input_TransactionID) throws IOException{
		applyWait.waitForElementToBeClickable(transactionID_TextBox, DefineConstants.explicitWait_30).sendKeys(input_TransactionID);		
		Screenshots.takeScreenshot(driver, "User entered transaction ID  as "+ input_TransactionID);
		test.log(Status.INFO, "User entered transaction ID as "+ input_TransactionID);
		Log.info("User entered transaction ID as "+ input_TransactionID);
	}
	
	public void enter_OrderNotes(String input_OrderNots) throws IOException{
		applyWait.waitForElementToBeClickable(orderNotes_Textbox, DefineConstants.explicitWait_30).clear();
		orderNotes_Textbox.sendKeys(input_OrderNots);		
		Screenshots.takeScreenshot(driver, "User entered order notes as "+ input_OrderNots);
		test.log(Status.INFO, "User entered order notes as "+ input_OrderNots);
		Log.info("User entered order notes as "+ input_OrderNots);
	}
	
	public void click_OrderNow_Button() throws IOException{
		applyWait.waitForElementToBeClickable(orderNow_Button, DefineConstants.explicitWait_30).click();		
		Screenshots.takeScreenshot(driver, "User clicked order now button");
		test.log(Status.INFO, "User clicked order now button");
		Log.info("User clicked order now button");
	}
	
	public void verify_ConfirmationText(String input_ConfirmationText) throws IOException{
		applyWait.waitForElementToBeClickable(orderConfirmation_Text, DefineConstants.explicitWait_30);
		String actualConfirmationText=orderConfirmation_Text.getText();
		if(actualConfirmationText.equals(input_ConfirmationText)){
			javascriptClick.highLighterMethod(orderConfirmation_Text);
			Screenshots.takeScreenshot(driver, "Your order has been confirmed displayed to user");
			test.log(Status.INFO, "Your order has been confirmed displayed to user");
			Log.info("Your order has been confirmed displayed to user");
			Assert.assertEquals(actualConfirmationText, input_ConfirmationText);
		}		
	}
	
	public void enter_CardNumber(String input_CardNumber) throws IOException{
		applyWait.waitForElementToBeClickable(card_TextBox, DefineConstants.explicitWait_30).sendKeys(input_CardNumber);		
		Screenshots.takeScreenshot(driver, "User entered card number as "+ input_CardNumber);
		test.log(Status.INFO, "User entered card number as "+ input_CardNumber);
		Log.info("User entered card number as "+ input_CardNumber);
	}
	
	public void enter_CVVNumber(String input_CVVNumber) throws IOException{
		applyWait.waitForElementToBeClickable(cvv_TextBox, DefineConstants.explicitWait_30).sendKeys(input_CVVNumber);		
		Screenshots.takeScreenshot(driver, "User entered cvv number as "+ input_CVVNumber);
		test.log(Status.INFO, "User entered cvv number as "+ input_CVVNumber);
		Log.info("User entered cvv number as "+ input_CVVNumber);
	}
	
	public void enter_Month(String input_Month) throws IOException{
		applyWait.waitForElementToBeClickable(month_TextBox, DefineConstants.explicitWait_30).sendKeys(input_Month);		
		Screenshots.takeScreenshot(driver, "User entered month as "+ input_Month);
		test.log(Status.INFO, "User entered month number as "+ input_Month);
		Log.info("User entered month number as "+ input_Month);
	}
	
	public void enter_Year(String input_Year) throws IOException{
		applyWait.waitForElementToBeClickable(year_TextBox, DefineConstants.explicitWait_30).sendKeys(input_Year);		
		Screenshots.takeScreenshot(driver, "User entered year as "+ input_Year);
		test.log(Status.INFO, "User entered year number as "+ input_Year);
		Log.info("User entered year number as "+ input_Year);
	}
	
	// Ship to different address	
		public void click_ShipToDifferentAddress() throws IOException{
			applyWait.waitForElementToBeClickable(shipToDifferentAddress_CheckBox, DefineConstants.explicitWait_30);
			javascriptClick.click(shipToDifferentAddress_CheckBox);
			Screenshots.takeScreenshot(driver, "User clicked ship to different address checkbox");
			test.log(Status.INFO, "User clicked ship to different address checkbox");
			Log.info("User clicked ship to different address checkbox");
		}
		
		public void enter_ShipToDifferentAddress_FullName_TextBox(String input_ShipToDifferentAddress_FullName) throws IOException{
			applyWait.waitForElementToBeClickable(shipToDifferentAddress_FullName_TextBox, DefineConstants.explicitWait_30).sendKeys(input_ShipToDifferentAddress_FullName);		
			Screenshots.takeScreenshot(driver, "User entered Ship To Different Address FullName as "+input_ShipToDifferentAddress_FullName);
			test.log(Status.INFO, "User entered Ship To Different Address FullName as "+input_ShipToDifferentAddress_FullName);
			Log.info("User entered Ship To Different Address FullName as "+input_ShipToDifferentAddress_FullName);
		}
		
		public void enter_ShipToDifferentAddress_PhoneNumber_TextBox(String input_ShipToDifferentAddress_PhoneNumber) throws IOException{
			applyWait.waitForElementToBeClickable(shipToDifferentAddress_PhoneNumber_TextBox, DefineConstants.explicitWait_30).sendKeys(input_ShipToDifferentAddress_PhoneNumber);		
			Screenshots.takeScreenshot(driver, "User entered Ship To Different Address Phone Number as "+input_ShipToDifferentAddress_PhoneNumber);
			test.log(Status.INFO, "User entered Ship To Different Address Phone Number as "+input_ShipToDifferentAddress_PhoneNumber);
			Log.info("User entered Ship To Different Address Phone Number as "+input_ShipToDifferentAddress_PhoneNumber);
		}
		
		public void enter_ShipToDifferentAddress_EmailAddress_TextBox(String input_ShipToDifferentAddress_EmailAddress) throws IOException{
			applyWait.waitForElementToBeClickable(shipToDifferentAddress_EmailAddress_TextBox, DefineConstants.explicitWait_30).sendKeys(input_ShipToDifferentAddress_EmailAddress);		
			Screenshots.takeScreenshot(driver, "User entered Ship To Different Address Email Address as "+input_ShipToDifferentAddress_EmailAddress);
			test.log(Status.INFO, "User entered Ship To Different Address Email Address as "+input_ShipToDifferentAddress_EmailAddress);
			Log.info("User entered Ship To Different Address Email Address as "+input_ShipToDifferentAddress_EmailAddress);
		}
		
		public void enter_ShipToDifferentAddress_Address_TextBox(String input_ShipToDifferentAddress_Address) throws IOException{
			applyWait.waitForElementToBeClickable(shipToDifferentAddress_Address_TextBox, DefineConstants.explicitWait_30).sendKeys(input_ShipToDifferentAddress_Address);		
			Screenshots.takeScreenshot(driver, "User entered Ship To Different Address, Address as "+input_ShipToDifferentAddress_Address);
			test.log(Status.INFO, "User entered Ship To Different Address, Address as "+input_ShipToDifferentAddress_Address);
			Log.info("User entered Ship To Different Address, Address as "+input_ShipToDifferentAddress_Address);
		}
		
		public void enter_ShipToDifferentAddress_City_TextBox(String input_ShipToDifferentAddress_City) throws IOException{
			applyWait.waitForElementToBeClickable(shipToDifferentAddress_ShippingCity_TextBox, DefineConstants.explicitWait_30).sendKeys(input_ShipToDifferentAddress_City);		
			Screenshots.takeScreenshot(driver, "User entered Ship To Different Address, City as "+input_ShipToDifferentAddress_City);
			test.log(Status.INFO, "User entered Ship To Different Address, City as "+input_ShipToDifferentAddress_City);
			Log.info("User entered Ship To Different Address, City as "+input_ShipToDifferentAddress_City);
		}
		
		public void enter_ShipToDifferentAddress_PostalCode_TextBox(String input_ShipToDifferentAddress_PostalCode) throws IOException{
			applyWait.waitForElementToBeClickable(shipToDifferentAddress_PostalCode_TextBox, DefineConstants.explicitWait_30).sendKeys(input_ShipToDifferentAddress_PostalCode);		
			Screenshots.takeScreenshot(driver, "User entered Ship To Different Address, Postal Code as "+input_ShipToDifferentAddress_PostalCode);
			test.log(Status.INFO, "User entered Ship To Different Address, Postal Code as "+input_ShipToDifferentAddress_PostalCode);
			Log.info("User entered Ship To Different Address, Postal Code as "+input_ShipToDifferentAddress_PostalCode);
		}
}