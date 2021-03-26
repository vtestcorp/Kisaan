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

public class Vendors_Page {
	
	private WebDriver driver;
	private WaitTypes applyWait;
	private ExtentTest test;
	private JavascriptClick javascriptClick;
	private DropDown dropDown;

	public Vendors_Page(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.applyWait = new WaitTypes(driver);
		this.test = test;
		javascriptClick = new JavascriptClick(driver);
		dropDown=new DropDown(driver);
	}
	
	@FindBy(xpath = "//li/a[@href='http://www.kisaansquad.com/admin/vendors']")
	private WebElement vendorsTab;
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchVendors;
	
	@FindBy(xpath = "//table[@id='example']")
	private WebElement vendorsTable;
	
	@FindBy(xpath = "//div[@class='panel panel-default']//div[2]//div[1]//input[1]")
	private WebElement emailSubject;
	
	@FindBy(xpath = "//textarea[@placeholder='Write Message']")
	private WebElement emailMessage;
	
	@FindBy(xpath = "//button[normalize-space()='Send Email']")
	private WebElement sendEmailButton;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissable']")
	private WebElement successMessageSendEmail;
	
	@FindBy(xpath = "//a[@href='http://www.kisaansquad.com/admin/vendors/pending']")
	private WebElement vendorsPendingList;
	
	@FindBy(xpath = "/html/body/div/div/div/div/div[2]/div/div[2]/div[2]/div/table/tbody/tr[1]/td[2]")
	private WebElement getEmailID;
	
	@FindBy(xpath = "//a[normalize-space()='Back']")
	private WebElement backButton;
	
	@FindBy(xpath = "//button[text()='Accept']")
	private WebElement acceptButton;
	
	@FindBy(xpath = "//a[text()=' Reject']")
	private WebElement rejectButton;
	
	@FindBy(xpath = "//a[normalize-space()='View Details']")
	private WebElement viewDatails;
	
	@FindBy(xpath = "//table[@class='table']")
	private WebElement Table;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissable']")
	private WebElement successMessageRemoveVendors;
	
	private List<WebElement> tableRows;
	
	private List<WebElement> tableColums;
	
	public void click_Vendors_Tab() {
		applyWait.waitForElementToBeClickable(vendorsTab, DefineConstants.explicitWait_60);
		javascriptClick.click(vendorsTab);
		try {
			Screenshots.takeScreenshot(driver, "User clicked Vendors tab");
			test.log(Status.INFO, "User clicked Vendors tab");
			Log.info("User clicked Vendors tab");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void searchVendorsName(String input_VendorsName){
		applyWait.waitForElementToBeClickable(searchVendors, DefineConstants.explicitWait_60);
		searchVendors.sendKeys(input_VendorsName);
			try {
				Screenshots.takeScreenshot(driver, "User search Vendor name as "+ input_VendorsName);
				test.log(Status.INFO, "User search Vendor name as "+ input_VendorsName);
				Log.info("User search Vendor name as "+ input_VendorsName);
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}	
   }
	
	public void verifyInputValue(String inputEmailAddress) {
		applyWait.waitForElementToBeClickable(vendorsTable, DefineConstants.explicitWait_60);
		tableRows = vendorsTable.findElements(By.tagName("tr"));

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
	
	public void click_SendMail(String inputProduct) {
		WebElement mail=driver.findElement(By.xpath("//td[normalize-space()='"+inputProduct+"']/following-sibling::td[3]/form/a[3]"));
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
	
	public void click_Remove_Vendors(String inputProduct) {
		WebElement remove=driver.findElement(By.xpath("//td[normalize-space()='"+inputProduct+"']/following-sibling::td[3]/form/button"));
		javascriptClick.click(remove);
		try {
			Screenshots.takeScreenshot(driver, "User clicked on Remove button");
			test.log(Status.INFO, "User clicked on Remove button");
			Log.info("User clicked on Remove button");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void click_Vendors_Pending_List() {
		applyWait.waitForElementToBeClickable(vendorsPendingList, DefineConstants.explicitWait_60);
		javascriptClick.click(vendorsPendingList);
		try {
			Screenshots.takeScreenshot(driver, "User clicked Vendors Pending List");
			test.log(Status.INFO, "User clicked Vendors Vendors Pending List");
			Log.info("User clicked Vendors Vendors Pending List");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void click_View_Button(String email) {
		WebElement accept=driver.findElement(By.xpath("//td[text()='"+email+"']/following-sibling::td[2]/a[1]"));
		javascriptClick.click(accept);
		try {
			Screenshots.takeScreenshot(driver, "User clicked view button of "+email);
			test.log(Status.INFO, "User clicked view button of "+email);
			Log.info("User clicked view button of "+email);		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void click_Accept_Button() {
		applyWait.waitForElementToBeClickable(acceptButton, DefineConstants.explicitWait_60);
		javascriptClick.click(acceptButton);
		try {
			Screenshots.takeScreenshot(driver, "User clicked Accept Button");
			test.log(Status.INFO, "User clicked Accept Button");
			Log.info("User clicked Accept Button");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void verify_SuccessMessageAcceptVendors(String input_ProductName){
		String text=successMessageSendEmail.getText();
		System.out.println(text);
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
	
	public void click_Back_Button() {
		applyWait.waitForElementToBeClickable(backButton, DefineConstants.explicitWait_60);
		javascriptClick.click(backButton);
		try {
			Screenshots.takeScreenshot(driver, "User clicked Back Button");
			test.log(Status.INFO, "User clicked Back Button");
			Log.info("User clicked Back Button");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void click_Reject_Button() {
		applyWait.waitForElementToBeClickable(rejectButton, DefineConstants.explicitWait_60);
		javascriptClick.click(rejectButton);
		try {
			Screenshots.takeScreenshot(driver, "User clicked reject button of ");
			test.log(Status.INFO, "User clicked reject button of ");
			Log.info("User clicked reject button of ");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void verifyInputValueRejected(String inputEmailAddress) {
		applyWait.waitForElementToBeClickable(vendorsTable, DefineConstants.explicitWait_60);
		tableRows = vendorsTable.findElements(By.tagName("tr"));

		for (int row = 0; row < tableRows.size(); row++) {
			tableColums = tableRows.get(row).findElements(By.tagName("td"));
			for (int column = 0; column < tableColums.size(); column++) {
				String cellText = tableColums.get(column).getText();
				if (cellText.equals(inputEmailAddress)) {
					System.out.println("value is " + cellText);
					javascriptClick.highLighterMethod(tableColums.get(column));
					Assert.assertTrue(false, inputEmailAddress + " is verified");
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
						Assert.assertTrue(true, inputEmailAddress + " is found");
						javascriptClick.highLighterMethod(tableColums.get(column));
						System.out.println(inputEmailAddress + " is not found");
						Screenshots.takeScreenshot(driver, inputEmailAddress + " is not found");
					} catch (IOException e) {
						e.printStackTrace();
					}
					test.log(Status.INFO, inputEmailAddress + " is not found");
					Log.info(inputEmailAddress + " is not found");
					
				}
			}
		}
	}
	
	public void viewdetails(String email) {
		WebElement reject=driver.findElement(By.xpath("//td[text()='"+email+"']/following-sibling::td[4]/a[1]"));
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
	
	public void verify_SuccessMessageDeleteVendors(String input_ProductName){
		String text=successMessageRemoveVendors.getText();
		System.out.println(text);
		if (text.contains(input_ProductName)) {
			javascriptClick.highLighterMethod(successMessageRemoveVendors);
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
	
	public void verifyValues(String input) {
		for (int i = 1; i < 4; i++) {
			WebElement s=driver.findElement(By.xpath("//form[@class='form-horizontal form-label-left']/div["+i+"]/div"));
			String text=s.getText().trim();
			System.out.println(text);
			if (text.equals(input)) {
				javascriptClick.highLighterMethod(s);
				System.out.println(input + " is verified");
				try {
					Assert.assertEquals(text.trim(), input);
					Screenshots.takeScreenshot(driver, input + " is verified");
					test.log(Status.INFO, input + " is verified");
					Log.info(input + " is verified");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else if (text.equals("No matching records found")) {
				try {
					javascriptClick.highLighterMethod(s);
					Screenshots.takeScreenshot(driver, input + " is not found");
				} catch (IOException e) {
					e.printStackTrace();
				}
				test.log(Status.INFO, input + " is not found");
				Log.info(input + " is not found");
				Assert.assertTrue(false, input + " is not found");
			}
		}
		
	}
	
	
	
	
}
