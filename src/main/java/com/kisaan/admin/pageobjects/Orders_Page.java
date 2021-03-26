package com.kisaan.admin.pageobjects;

import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
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

public class Orders_Page {

	private WebDriver driver;
	private WaitTypes applyWait;
	private ExtentTest test;
	private JavascriptClick javascriptClick;
	private DropDown dropDown;
	private ScrollTypes scroll;

	public Orders_Page(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.applyWait = new WaitTypes(driver);
		this.test = test;
		javascriptClick = new JavascriptClick(driver);
		dropDown = new DropDown(driver);
		scroll = new ScrollTypes(driver);
	}
	
	@FindBy(xpath = "//a[normalize-space()='Orders']")
	private WebElement ordersPage;
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchBox;
	
	@FindBy(xpath = "//table[@id='example']")
	private WebElement productTable;
	
	private List<WebElement> tableRows;

	private List<WebElement> tableColums;
	
	@FindBy(xpath = "//table[1]")
	private WebElement Table;
	
	@FindBy(xpath = "//table[2]")
	private WebElement Table2;
	
	@FindBy(xpath = "//div[@class='panel panel-default']//div[2]//div[1]//input[1]")
	private WebElement subject;
	
	@FindBy(xpath = "//textarea[@placeholder='Write Message']")
	private WebElement message;
	
	@FindBy(xpath = "//button[normalize-space()='Send Email']")
	private WebElement sendmailButton;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissable']")
	private WebElement SuccessMessage;
	
	public void click_Orders_Tab() {
		applyWait.waitForElementToBeClickable(ordersPage, DefineConstants.explicitWait_60);
		javascriptClick.click(ordersPage);
		try {
			Screenshots.takeScreenshot(driver, "User clicked Orders tab");
			test.log(Status.INFO, "User clicked Orders tab");
			Log.info("User clicked Orders tab");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void searchEmail(String input_ProductName){
		applyWait.waitForElementToBeClickable(searchBox, DefineConstants.explicitWait_60);
		searchBox.sendKeys(input_ProductName);
			try {
				Screenshots.takeScreenshot(driver, "User search customer email as "+ input_ProductName);
				test.log(Status.INFO, "User search customer email as "+ input_ProductName);
				Log.info("User search customer email as "+ input_ProductName);
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
	
	public void viewdetails(String email) {
		WebElement details=driver.findElement(By.xpath("//td[text()='"+email+"']/following-sibling::td[5]/a[1]"));
		javascriptClick.click(details);
		try {
			Screenshots.takeScreenshot(driver, "User clicked View Button of "+email);
			test.log(Status.INFO, "User clicked View Button of "+email);
			Log.info("User clicked View Button of "+email);		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void sendEmail(String email) {
		WebElement details=driver.findElement(By.xpath("//td[text()='"+email+"']/following-sibling::td[5]/a[2]"));
		javascriptClick.click(details);
		try {
			Screenshots.takeScreenshot(driver, "User clicked send email of "+email);
			test.log(Status.INFO, "User clicked send email of "+email);
			Log.info("User clicked send email of "+email);		
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
	
	public void verifyInputValueOrders(JSONArray jsonArray) {
		applyWait.waitForElementToBeClickable(Table2, DefineConstants.explicitWait_60);
		tableRows = Table2.findElements(By.tagName("tr"));

		for (int row = 0; row < tableRows.size(); row++) {
			tableColums = tableRows.get(row).findElements(By.tagName("td"));
			for (int column = 0; column < tableColums.size(); column++) {
				String cellText = tableColums.get(column).getText();
				System.out.println(cellText);
				System.out.println(jsonArray+" array");
				if (cellText.contains((CharSequence) jsonArray)) {
					System.out.println("value is " + cellText);
					javascriptClick.highLighterMethod(tableColums.get(column));
					Assert.assertTrue(true, jsonArray + " is verified");
					test.log(Status.INFO, "value is " + cellText);
					Log.info("value is " + cellText);
					try {
						Screenshots.takeScreenshot(driver, jsonArray + " is verified");
					} catch (IOException e) {
						e.printStackTrace();
					}
					test.log(Status.INFO, jsonArray + " is verified");
					Log.info(jsonArray + " is verified");
				}
				else if (cellText.equals("No matching records found")) {
					try {
						javascriptClick.highLighterMethod(tableColums.get(column));
						Screenshots.takeScreenshot(driver, jsonArray + " is not found");
					} catch (IOException e) {
						e.printStackTrace();
					}
					test.log(Status.INFO, jsonArray + " is not found");
					Log.info(jsonArray + " is not found");
					Assert.assertTrue(false, jsonArray + " is not found");
				}
			}
		}
	}
	
	public void enter_Subject(String input_productName) {
		applyWait.waitForElementToBeClickable(subject, DefineConstants.explicitWait_60);
		subject.sendKeys(input_productName);
			try {
				Screenshots.takeScreenshot(driver, "User entered Subject "+input_productName);
				test.log(Status.INFO, "User entered Subject "+input_productName);
				Log.info("User entered Subject "+input_productName);
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}	
   }
	
	public void enter_Message(String input_productName) {
		applyWait.waitForElementToBeClickable(message, DefineConstants.explicitWait_60);
		message.sendKeys(input_productName);
			try {
				Screenshots.takeScreenshot(driver, "User entered Message "+input_productName);
				test.log(Status.INFO, "User entered Message "+input_productName);
				Log.info("User entered Message "+input_productName);
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}	
   }
	
	public void click_SendMailButton() {
		applyWait.waitForElementToBeClickable(sendmailButton, DefineConstants.explicitWait_60);
		javascriptClick.click(sendmailButton);
		try {
			Screenshots.takeScreenshot(driver, "User clicked Send Email button");
			test.log(Status.INFO, "User clicked Send Email button");
			Log.info("User clicked Send Email button");		
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
	
	
	
	
}
