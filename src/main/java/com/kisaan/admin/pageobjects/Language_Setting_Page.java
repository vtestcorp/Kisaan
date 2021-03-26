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

public class Language_Setting_Page {
	
	private WebDriver driver;
	private WaitTypes applyWait;
	private ExtentTest test;
	private JavascriptClick javascriptClick;
	private DropDown dropDown;

	public Language_Setting_Page(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.applyWait = new WaitTypes(driver);
		this.test = test;
		javascriptClick = new JavascriptClick(driver);
		dropDown=new DropDown(driver);
	}
	
	@FindBy(xpath = "//a[normalize-space()='Language Settings']")
	private WebElement languageSetting;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissable']")
	private WebElement SuccessMessage;
	
	@FindBy(xpath = "//button[normalize-space()='Update Website Language']")
	private WebElement updateLanguageSetting;
	
	WebElement element;
	
	public void click_UpdateLanguageSetting() {
		applyWait.waitForElementToBeClickable(updateLanguageSetting, DefineConstants.explicitWait_60);
		javascriptClick.click(updateLanguageSetting);
		try {
			Screenshots.takeScreenshot(driver, "User clicked update Language Setting button");
			test.log(Status.INFO, "User clicked update Language Setting button");
			Log.info("User clicked update Language Setting button");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void click_LanguageSetting() {
		applyWait.waitForElementToBeClickable(languageSetting, DefineConstants.explicitWait_60);
		javascriptClick.click(languageSetting);
		try {
			Screenshots.takeScreenshot(driver, "User clicked Language Setting tab");
			test.log(Status.INFO, "User clicked Language Setting tab");
			Log.info("User clicked Language Setting tab");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void verify_SuccessMessage(String input_ProductName){
		String text=SuccessMessage.getText();
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
	
	public void enterText(String name,WebElement s, String input_ProductName){
		applyWait.waitForElementToBeClickable(element, DefineConstants.explicitWait_60).clear();
		element.sendKeys(input_ProductName);
		
		test.log(Status.INFO, "User enter value in "+name+" textbox as "+ input_ProductName);
		Log.info("User enter value in "+name+" textbox as "+ input_ProductName);
		//Thread.sleep(2000);		
   }
	
	public WebElement getWebElement(String input) {
		
		switch (input) {
		case "Home":
			element=driver.findElement(By.xpath("//input[@name='home']"));
			break;
			
		case "About_Us":
			element=driver.findElement(By.xpath("//input[@name='about_us']"));
			break;

		case "Contact_Us":
			element=driver.findElement(By.xpath("//input[@name='contact_us']"));
			break;
			
		case "FAQ":
			element=driver.findElement(By.xpath("//input[@name='faq']"));
			break;
			
		case "Search":
			element=driver.findElement(By.xpath("//input[@name='search']"));
			break;
			
		case "Vendor":
			element=driver.findElement(By.xpath("//input[@name='vendor']"));
			break;

		case "SignIn":
			element=driver.findElement(By.xpath("//input[@name='sign_in']"));
			break;
			
		case "My_Account":
			element=driver.findElement(By.xpath("//input[@name='my_account']"));
			break;
			
		case "My_Cart":
			element=driver.findElement(By.xpath("//input[@name='my_cart']"));
			break;
			
		case "View_Cart":
			element=driver.findElement(By.xpath("//input[@name='view_cart']"));
			break;
			
		case "Checkout":
			element=driver.findElement(By.xpath("//input[@name='checkout']"));
			break;

		case "Continue_Shopping":
			element=driver.findElement(By.xpath("//input[@name='continue_shopping']"));
			break;
			
		case "Proceed_To_Checkout":
			element=driver.findElement(By.xpath("//input[@name='proceed_to_checkout']"));
			break;
			
		case "Empty_Cart":
			element=driver.findElement(By.xpath("//input[@name='empty_cart']"));
			break;
			
		case "Ship_To_Different_Address":
			element=driver.findElement(By.xpath("//input[@name='ship_to_another']"));
			break;
			
		case "Pickup_Datails":
			element=driver.findElement(By.xpath("//input[@name='pickup_details']"));
			break;

		case "Top_Category":
			element=driver.findElement(By.xpath("//input[@name='top_category']"));
			break;
			
		case "Featured_Products":
			element=driver.findElement(By.xpath("//input[@name='featured_products']"));
			break;
			
		case "Latest_Products":
			element=driver.findElement(By.xpath("//input[@name='latest_products']"));
			break;

		case "Popular_Products":
			element=driver.findElement(By.xpath("//input[@name='popular_products']"));
			break;
			
		case "Product_Name":
			element=driver.findElement(By.xpath("//input[@name='product_name']"));
			break;
			
		case "Unit_Price":
			element=driver.findElement(By.xpath("//input[@name='unit_price']"));
			break;
			
		case "Sub_Total":
			element=driver.findElement(By.xpath("//input[@name='subtotal']"));
			break;
			
		case "Total":
			element=driver.findElement(By.xpath("//input[@name='total']"));
			break;
			
		case "Quality":
			element=driver.findElement(By.xpath("//input[@name='quantity']"));
			break;
			
		case "Add_To_Card":
			element=driver.findElement(By.xpath("//input[@name='add_to_cart']"));
			break;
			
		case "Out_Of_Stock":
			element=driver.findElement(By.xpath("//input[@name='out_of_stock']"));
			break;

		case "Available":
			element=driver.findElement(By.xpath("//input[@name='available']"));
			break;
			
		case "Reviews":
			element=driver.findElement(By.xpath("//input[@name='reviews']"));
			break;
			
		case "Related_Products":
			element=driver.findElement(By.xpath("//input[@name='related_products']"));
			break;
			
		case "Return_Policy":
			element=driver.findElement(By.xpath("//input[@name='return_policy']"));
			break;
			
		case "No_Review":
			element=driver.findElement(By.xpath("//input[@name='no_review']"));
			break;

		case "Write_a_Review":
			element=driver.findElement(By.xpath("//input[@name='write_a_review']"));
			break;
			
		case "Subscription":
			element=driver.findElement(By.xpath("//input[@name='subscription']"));
			break;
			
		case "Subscribe":
			element=driver.findElement(By.xpath("//input[@name='subscribe']"));
			break;
			
		case "Address":
			element=driver.findElement(By.xpath("//input[@name='address']"));
			break;
			
		case "Added_To_Card":
			element=driver.findElement(By.xpath("//input[@name='added_to_cart']"));
			break;
			
		case "Description":
			element=driver.findElement(By.xpath("//input[@name='description']"));
			break;
			
		case "Share_In_Social":
			element=driver.findElement(By.xpath("//input[@name='share_in_social']"));
			break;
			
		case "Search_Result":
			element=driver.findElement(By.xpath("//input[@name='search_result']"));
			break;
			
		case "No_Products_Found":
			element=driver.findElement(By.xpath("//input[@name='no_result']"));
			break;

		case "Contact_Us_Greetings":
			element=driver.findElement(By.xpath("//input[@name='contact_us_today']"));
			break;
			
		case "Filter_Option":
			element=driver.findElement(By.xpath("//input[@name='filter_option']"));
			break;
			
		case "All_Categories":
			element=driver.findElement(By.xpath("//input[@name='all_categories']"));
			break;
			
		case "Load_More":
			element=driver.findElement(By.xpath("//input[@name='load_more']"));
			break;
			
		case "Sort_By_Latest_Products":
			element=driver.findElement(By.xpath("//input[@name='sort_by_latest']"));
			break;

		case "Sort_By_Oldest_Products":
			element=driver.findElement(By.xpath("//input[@name='sort_by_oldest']"));
			break;
			
		case "Sort_By_Highest_Price":
			element=driver.findElement(By.xpath("//input[@name='sort_by_highest']"));
			break;
			
		case "Sort_By_Lowest_Price":
			element=driver.findElement(By.xpath("//input[@name='sort_by_lowest']"));
			break;
			
		case "Street_Address":
			element=driver.findElement(By.xpath("//input[@name='street_address']"));
			break;

		case "Phone":
			element=driver.findElement(By.xpath("//input[@name='phone']"));
			break;
			
		case "Email":
			element=driver.findElement(By.xpath("//input[@name='email']"));
			break;
			
		case "Fax":
			element=driver.findElement(By.xpath("//input[@name='fax']"));
			break;
			
		case "Name":
			element=driver.findElement(By.xpath("//input[@name='name']"));
			break;
			
		case "Review_Details":
			element=driver.findElement(By.xpath("//input[@name='review_details']"));
			break;

		case "Order_Details":
			element=driver.findElement(By.xpath("//input[@name='order_details']"));
			break;
			
		case "Enter_Shipping_Details":
			element=driver.findElement(By.xpath("//input[@name='enter_shipping']"));
			break;
			
		case "Shipping_Cost":
			element=driver.findElement(By.xpath("//input[@name='shipping_cost']"));
			break;
			
		case "Order_Now":
			element=driver.findElement(By.xpath("//input[@name='order_now']"));
			break;
			
		case "View_Details":
			element=driver.findElement(By.xpath("//input[@name='view_details']"));
			break;
			
		case "Quick_Review":
			element=driver.findElement(By.xpath("//input[@name='quick_review']"));
			break;
			
		case "Submit":
			element=driver.findElement(By.xpath("//input[@name='submit']"));
			break;
			
		default:
			break;
		}
		return element;
	}
	
	

}
