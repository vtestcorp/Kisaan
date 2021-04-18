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

public class Farmers_Market_Page {
	private WebDriver driver;
	private WaitTypes applyWait;
	private ExtentTest test;
	private JavascriptClick javascriptClick;
	private ScrollTypes scrollTypes;
	private DropDown dropdown;

	public Farmers_Market_Page(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.applyWait = new WaitTypes(driver);
		this.test = test;
		javascriptClick = new JavascriptClick(driver);
		scrollTypes = new ScrollTypes(driver);
		dropdown = new DropDown(driver);
	}

	@FindBy(xpath = "//a[normalize-space()=\"Farmer's Market\"]")
	private WebElement farmersMarket;
	
	@FindBy(xpath = "//a[normalize-space()='Request New Super Market']")
	private WebElement AddFarmersMarket;
	
	@FindBy(xpath = "//input[@id='markets-selectized']")
	private WebElement selectMarket;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submit;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissable']")
	private WebElement successMessageSendEmail;
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchbox;
	
	@FindBy(xpath = "//table[@id='example']")
	private WebElement productTable;
	
	private List<WebElement> tableRows;

	private List<WebElement> tableColums;
	
	@FindBy(xpath = "//table[@class='table']")
	private WebElement Table;
	
	
	public void click_FarmersMarket_Tab() {
		applyWait.waitForElementToBeClickable(farmersMarket, DefineConstants.explicitWait_60);
		javascriptClick.click(farmersMarket);
		try {
			Screenshots.takeScreenshot(driver, "User clicked Farmer's Market tab");
			test.log(Status.INFO, "User clicked Farmer's Market tab");
			Log.info("User clicked Farmer's Market tab");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void click_AddFarmersMarket() {
		applyWait.waitForElementToBeClickable(AddFarmersMarket, DefineConstants.explicitWait_60);
		javascriptClick.click(AddFarmersMarket);
		try {
			Screenshots.takeScreenshot(driver, "User clicked add new Farmer's Market");
			test.log(Status.INFO, "User clicked add new Farmer's Market");
			Log.info("User clicked add new Farmer's Market");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void enterMarketName(String subject){
		applyWait.waitForElementToBeClickable(selectMarket, DefineConstants.explicitWait_60).click();
		selectMarket.sendKeys(subject);
		selectMarket.sendKeys(Keys.ENTER);
			try {
				Screenshots.takeScreenshot(driver, "User enter market name as "+ subject);
				test.log(Status.INFO, "User enter market name as "+ subject);
				Log.info("User enter market name as "+ subject);
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}	
   }
	
	public void click_Submit() {
		applyWait.waitForElementToBeClickable(submit, DefineConstants.explicitWait_60);
		javascriptClick.click(submit);
		try {
			Screenshots.takeScreenshot(driver, "User clicked submit request");
			test.log(Status.INFO, "User clicked submit request");
			Log.info("User clicked submit request");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void verify_SuccessMessage(String input_ProductName){
		String text=successMessageSendEmail.getText();
		if (text.contains(input_ProductName)) {
			javascriptClick.highLighterMethod(successMessageSendEmail);
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
	
	public void search_MarketName(String input_productName) {
		applyWait.waitForElementToBeClickable(searchbox, DefineConstants.explicitWait_60).clear();
		searchbox.sendKeys(input_productName);
			try {
				Screenshots.takeScreenshot(driver, "User entered market name as "+ input_productName);
				test.log(Status.INFO, "User entered market name as "+ input_productName);
				Log.info("User entered market name as "+ input_productName);
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}	
   }
	
	public void verifyInputValue(String inputEmailAddress) {
		applyWait.waitForElementToBeClickable(productTable, DefineConstants.explicitWait_60);
		tableRows = productTable.findElements(By.tagName("tr"));

		for (int row = 0; row < tableRows.size(); row++) {
			tableColums = tableRows.get(row).findElements(By.tagName("td"));
			for (int column = 0; column < tableColums.size(); column++) {
				String cellText = tableColums.get(column).getText();
				if (cellText.equals(inputEmailAddress)) {
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
	
	public void click_ViewDetails(String email) {
		WebElement details=driver.findElement(By.xpath("//td[text()='"+email+"']/following-sibling::td[3]/a[1]"));
		javascriptClick.click(details);
		try {
			Screenshots.takeScreenshot(driver, "User clicked view details market of "+email);
			test.log(Status.INFO, "User clicked view details market of "+email);
			Log.info("User clicked view details market of "+email);		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void verifyInputValueInfo(String inputEmailAddress) {
		applyWait.waitForElementToBeClickable(Table, DefineConstants.explicitWait_60);
		tableRows = Table.findElements(By.tagName("tr"));

		for (int row = 0; row < tableRows.size(); row++) {
			tableColums = tableRows.get(row).findElements(By.tagName("td"));
			for (int column = 0; column < tableColums.size(); column++) {
				String cellText = tableColums.get(column).getText();
				if (cellText.equals(inputEmailAddress)) {
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

}
