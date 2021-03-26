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

public class Service_Area {
	private WebDriver driver;
	private WaitTypes applyWait;
	private ExtentTest test;
	private JavascriptClick javascriptClick;
	private DropDown dropDown;

	public Service_Area(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.applyWait = new WaitTypes(driver);
		this.test = test;
		javascriptClick = new JavascriptClick(driver);
		dropDown=new DropDown(driver);
	}
	
	@FindBy(xpath = "//a[@href='http://www.kisaansquad.com/admin/serving-areas']")
	private WebElement serviceArea;
	
	@FindBy(xpath = "//a[@class='btn btn-primary btn-add']")
	private WebElement addNewServiceArea;
	
	@FindBy(xpath = "//input[@name='zip_code']")
	private WebElement zipCodeTextBox;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement addServiceAreaButton;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissable']")
	private WebElement SuccessMessageZipCode;
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchZipCode;
	
	@FindBy(xpath = "//table[@id='example']")
	private WebElement zipTable;
	
	private List<WebElement> tableRows;

	private List<WebElement> tableColums;
	
	public void click_ServiceArea_Tab() {
		applyWait.waitForElementToBeClickable(serviceArea, DefineConstants.explicitWait_60);
		javascriptClick.click(serviceArea);
		try {
			Screenshots.takeScreenshot(driver, "User clicked Service Area tab");
			test.log(Status.INFO, "User clicked Service Area tab");
			Log.info("User clicked Service Area tab");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void click_Add_New_ServiceArea() {
		applyWait.waitForElementToBeClickable(addNewServiceArea, DefineConstants.explicitWait_60);
		javascriptClick.click(addNewServiceArea);
		try {
			Screenshots.takeScreenshot(driver, "User clicked Add New Service Area tab");
			test.log(Status.INFO, "User clicked Add New Service Area tab");
			Log.info("User clicked Add New Service Area tab");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void enter_Zip_Code(String input) {
		applyWait.waitForElementToBeClickable(zipCodeTextBox, DefineConstants.explicitWait_60).clear();
		zipCodeTextBox.sendKeys(input);
		try {
			Screenshots.takeScreenshot(driver, "User enter Zip code");
			test.log(Status.INFO, "User enter Zip code");
			Log.info("User enter Zip code");		
			Thread.sleep(3000);
		} catch (Exception e) {
		}
    }
	
	public void click_AddServiceArea_Button() {
		applyWait.waitForElementToBeClickable(addServiceAreaButton, DefineConstants.explicitWait_60);
		javascriptClick.click(addServiceAreaButton);
		try {
			Screenshots.takeScreenshot(driver, "User clicked Service Area button");
			test.log(Status.INFO, "User clicked Service Area button");
			Log.info("User clicked Service Area button");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void verify_SuccessMessage(String input_ProductName){
		String text=SuccessMessageZipCode.getText();
		if (text.contains(input_ProductName)) {
			javascriptClick.highLighterMethod(SuccessMessageZipCode);
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
	
	public void searchZipCode(String input_ProductName){
		applyWait.waitForElementToBeClickable(searchZipCode, DefineConstants.explicitWait_60);
		searchZipCode.sendKeys(input_ProductName);
			try {
				Screenshots.takeScreenshot(driver, "User search Zip Code as "+ input_ProductName);
				test.log(Status.INFO, "User search Zip Code as "+ input_ProductName);
				Log.info("User search Zip Code as "+ input_ProductName);
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}	
   }
	
	public void verifyInputValue(String inputEmailAddress) {
		applyWait.waitForElementToBeClickable(zipTable, DefineConstants.explicitWait_60);
		tableRows = zipTable.findElements(By.tagName("tr"));

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
	
	public void click_EditZipCode(String inputProduct) {
		WebElement zip=driver.findElement(By.xpath("//td[normalize-space()='"+inputProduct+"']/following-sibling::td[1]/a[1]"));
		javascriptClick.click(zip);
		try {
			Screenshots.takeScreenshot(driver, "User clicked on edit zip code");
			test.log(Status.INFO, "User clicked on edit zip code");
			Log.info("User clicked on edit zip code");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}
