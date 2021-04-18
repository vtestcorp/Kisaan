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

public class Manage_Unit_Page {
	private WebDriver driver;
	private WaitTypes applyWait;
	private ExtentTest test;
	private JavascriptClick javascriptClick;
	private DropDown dropDown;

	public Manage_Unit_Page(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.applyWait = new WaitTypes(driver);
		this.test = test;
		javascriptClick = new JavascriptClick(driver);
		dropDown=new DropDown(driver);
	}
	
	@FindBy(xpath = "//a[normalize-space()='Manage Units']")
	private WebElement manage_Unit;
	
	@FindBy(xpath = "//a[normalize-space()='Add New Unit']")
	private WebElement addNewUnit;
	
	@FindBy(xpath = "//input[@name='name']")
	private WebElement addName;
	
	@FindBy(xpath = "//input[@name='slug']")
	private WebElement addSlug;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement addUnitBtn;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissable']")
	private WebElement SuccessMessage;
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchbox;
	
	@FindBy(xpath = "//table[@id='example']")
	private WebElement productTable;
	
	private List<WebElement> tableRows;

	private List<WebElement> tableColums;
	
	public void click_ManageUnit() {
		applyWait.waitForElementToBeClickable(manage_Unit, DefineConstants.explicitWait_60);
		javascriptClick.click(manage_Unit);
		try {
			Screenshots.takeScreenshot(driver, "User clicked Manage Unit tab");
			test.log(Status.INFO, "User clicked Manage Unit tab");
			Log.info("User clicked Manage Unit tab");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void click_AddNewUnit() {
		applyWait.waitForElementToBeClickable(addNewUnit, DefineConstants.explicitWait_60);
		javascriptClick.click(addNewUnit);
		try {
			Screenshots.takeScreenshot(driver, "User clicked add new Unit");
			test.log(Status.INFO, "User clicked add new Unit");
			Log.info("User clicked add new Unit");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void enter_AddName(String input_productName) {
		applyWait.waitForElementToBeClickable(addName, DefineConstants.explicitWait_60).clear();
		addName.sendKeys(input_productName);
			try {
				Screenshots.takeScreenshot(driver, "User entered unit name as "+ input_productName);
				test.log(Status.INFO, "User entered unit name as "+ input_productName);
				Log.info("User entered unit name as "+ input_productName);
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}	
   }
	
	public void enter_AddSlug(String input_productName) {
		applyWait.waitForElementToBeClickable(addSlug, DefineConstants.explicitWait_60).clear();
		addSlug.sendKeys(input_productName);
			try {
				Screenshots.takeScreenshot(driver, "User entered unit slug as "+ input_productName);
				test.log(Status.INFO, "User entered unit slug as "+ input_productName);
				Log.info("User entered email unit slug as "+ input_productName);
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}	
   }
	
	public void click_AddUnitBtn() {
		applyWait.waitForElementToBeClickable(addUnitBtn, DefineConstants.explicitWait_60);
		javascriptClick.click(addUnitBtn);
		try {
			Screenshots.takeScreenshot(driver, "User clicked add Unit button");
			test.log(Status.INFO, "User clicked add Unit button");
			Log.info("User clicked add Unit button");		
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
	
	public void search_UnitName(String input_productName) {
		applyWait.waitForElementToBeClickable(searchbox, DefineConstants.explicitWait_60).clear();
		searchbox.sendKeys(input_productName);
			try {
				Screenshots.takeScreenshot(driver, "User entered unit name as "+ input_productName);
				test.log(Status.INFO, "User entered unit name as "+ input_productName);
				Log.info("User entered email unit name as "+ input_productName);
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
	
	public void click_Edit(String email) {
		WebElement details=driver.findElement(By.xpath("//td[text()='"+email+"']/following-sibling::td[2]/a"));
		javascriptClick.click(details);
		try {
			Screenshots.takeScreenshot(driver, "User clicked edit unit of "+email);
			test.log(Status.INFO, "User clicked edit unit of "+email);
			Log.info("User clicked edit unit of "+email);		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}
