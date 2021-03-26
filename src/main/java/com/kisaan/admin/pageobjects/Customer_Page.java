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

public class Customer_Page {
	private WebDriver driver;
	private WaitTypes applyWait;
	private ExtentTest test;
	private JavascriptClick javascriptClick;
	private DropDown dropDown;

	public Customer_Page(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.applyWait = new WaitTypes(driver);
		this.test = test;
		javascriptClick = new JavascriptClick(driver);
		dropDown=new DropDown(driver);
	}
	
	@FindBy(xpath = "//a[@href='http://www.kisaansquad.com/admin/customers']")
	private WebElement customerTab;
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement search;
	
	@FindBy(xpath = "//table[@class='table']")
	private WebElement Table;
	
	@FindBy(xpath = "//div[@class='panel panel-default']//div[2]//div[1]//input[1]")
	private WebElement emailSubject;
	
	@FindBy(xpath = "//textarea[@placeholder='Write Message']")
	private WebElement emailMessage;
	
	@FindBy(xpath = "//button[normalize-space()='Send Email']")
	private WebElement sendEmailButton;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissable']")
	private WebElement successMessageSendEmail;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissable']")
	private WebElement successMessageRemoveCustomer;
	
	@FindBy(xpath = "//a[@href='http://www.kisaansquad.com/admin/customers/pending']")
	private WebElement customerPendingList;
	
	private List<WebElement> tableRows;
	
	private List<WebElement> tableColums;
	
	public void click_Customer_Tab() {
		applyWait.waitForElementToBeClickable(customerTab, DefineConstants.explicitWait_60);
		javascriptClick.click(customerTab);
		try {
			Screenshots.takeScreenshot(driver, "User clicked Customer tab");
			test.log(Status.INFO, "User clicked Customer tab");
			Log.info("User clicked Customer tab");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void searchCustomerName(String input_VendorsName){
		applyWait.waitForElementToBeClickable(search, DefineConstants.explicitWait_60);
		search.sendKeys(input_VendorsName);
			try {
				Screenshots.takeScreenshot(driver, "User search Customer name as "+ input_VendorsName);
				test.log(Status.INFO, "User search Customer name as "+ input_VendorsName);
				Log.info("User search Vendor Customer as "+ input_VendorsName);
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}	
   }
	
	public void viewdetails(String email) {
		WebElement reject=driver.findElement(By.xpath("//td[text()='"+email+"']/following-sibling::td[3]/form/a[1]"));
		javascriptClick.click(reject);
		try {
			Screenshots.takeScreenshot(driver, "User clicked View Button of "+email);
			test.log(Status.INFO, "User clicked View Button of "+email);
			Log.info("User clicked View Button of "+email);		
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
	
	public void click_SendMail(String email) {
		WebElement mail=driver.findElement(By.xpath("//td[text()='"+email+"']/following-sibling::td[3]/form/a[2]"));
		javascriptClick.click(mail);
		try {
			Screenshots.takeScreenshot(driver, "User clicked on Send Email");
			test.log(Status.INFO, "User clicked on Send Email");
			Log.info("User clicked on Send Email");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void enterEmailSubject(String subject){
		applyWait.waitForElementToBeClickable(emailSubject, DefineConstants.explicitWait_60);
		emailSubject.sendKeys(subject);
			try {
				Screenshots.takeScreenshot(driver, "User enter Email Subject as "+ subject);
				test.log(Status.INFO, "User enter Email Subject as "+ subject);
				Log.info("User enter Email Subject as "+ subject);
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}	
   }
	
	public void enterEmailMessage(String subject){
		applyWait.waitForElementToBeClickable(emailMessage, DefineConstants.explicitWait_60);
		emailMessage.sendKeys(subject);
			try {
				Screenshots.takeScreenshot(driver, "User enter Email Message as "+ subject);
				test.log(Status.INFO, "User enter Email Message as "+ subject);
				Log.info("User enter Email Message as "+ subject);
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}	
   }
	
	public void click_SendMailButton() {
		applyWait.waitForElementToBeClickable(sendEmailButton, DefineConstants.explicitWait_60);
		javascriptClick.click(sendEmailButton);
		try {
			Screenshots.takeScreenshot(driver, "User clicked on Send Email button");
			test.log(Status.INFO, "User clicked on Send Email button");
			Log.info("User clicked on Send Email button");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void verify_SuccessMessageSendEmail(String input_ProductName){
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
	
	public void click_Accept_Button(String email) {
		WebElement mail=driver.findElement(By.xpath("//td[text()='"+email+"']/following-sibling::td[3]/form/a[3]"));
		javascriptClick.click(mail);
		try {
			Screenshots.takeScreenshot(driver, "User clicked on accept Button");
			test.log(Status.INFO, "User clicked on accept Button");
			Log.info("User clicked on accept Button");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void click_Remove_Button(String email) {
		WebElement mail=driver.findElement(By.xpath("//td[text()='"+email+"']/following-sibling::td[3]/form/button"));
		javascriptClick.click(mail);
		try {
			Screenshots.takeScreenshot(driver, "User clicked on Remove Button");
			test.log(Status.INFO, "User clicked on Remove Button");
			Log.info("User clicked on Remove Button");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void verify_SuccessMessageDeleteCustomer(String input_ProductName){
		String text=successMessageRemoveCustomer.getText();
		System.out.println(text);
		if (text.contains(input_ProductName)) {
			javascriptClick.highLighterMethod(successMessageRemoveCustomer);
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
	
	public void click_View_Details_Button(String email) {
		WebElement mail=driver.findElement(By.xpath("//td[text()='"+email+"']/following-sibling::td[4]/form/a[1]"));
		javascriptClick.click(mail);
		try {
			Screenshots.takeScreenshot(driver, "User clicked on View Details Button");
			test.log(Status.INFO, "User clicked on View Details Button");
			Log.info("User clicked on View Details Button");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void click_Customers_Pending_List() {
		applyWait.waitForElementToBeClickable(customerPendingList, DefineConstants.explicitWait_60);
		javascriptClick.click(customerPendingList);
		try {
			Screenshots.takeScreenshot(driver, "User clicked customers Pending List");
			test.log(Status.INFO, "User clicked customers Pending List");
			Log.info("User clicked customers Pending List");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}
