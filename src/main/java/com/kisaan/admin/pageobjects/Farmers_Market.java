package com.kisaan.admin.pageobjects;

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
import helperMethods.WaitTypes;

public class Farmers_Market {
	private WebDriver driver;
	private WaitTypes applyWait;
	private ExtentTest test;
	private JavascriptClick javascriptClick;
	private DropDown dropDown;

	public Farmers_Market(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.applyWait = new WaitTypes(driver);
		this.test = test;
		javascriptClick = new JavascriptClick(driver);
		dropDown=new DropDown(driver);
	}
	
	@FindBy(xpath = "//a[@href='http://www.kisaansquad.com/admin/stores']")
	private WebElement farmersMarket;
	
	@FindBy(xpath = "//a[normalize-space()='Add New Market']")
	private WebElement AddNewfarmersMarket;
	
	@FindBy(xpath = "//input[@name='name']")
	private WebElement marketName;
	
	@FindBy(xpath = "//input[@name='phone']")
	private WebElement marketPhone;
	
	@FindBy(xpath = "//input[@name='email']")
	private WebElement marketEmail;
	
	@FindBy(xpath = "//input[@id='serving_areas-selectized']")
	private WebElement serviceArea;
	
	@FindBy(xpath = "//input[@id='uploadFile']")
	private WebElement fileUpload;
	
	@FindBy(xpath = "//input[@name='address']")
	private WebElement marketAddress;
	
	@FindBy(xpath = "//input[@name='city']")
	private WebElement marketCity;
	
	@FindBy(xpath = "//input[@name='zip']")
	private WebElement marketZipCode;
	
	@FindBy(xpath = "//input[@name='pickup_address']")
	private WebElement pickupAddress;
	
	@FindBy(xpath = "//input[@name='pickup_city']")
	private WebElement pickupCity;
	
	@FindBy(xpath = "//input[@name='pickup_zip_code']")
	private WebElement pickupZip;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement addMarketBtn;
	
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
	
	@FindBy(xpath = "//input[@id='datepicker']")
	private WebElement date;
	
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

	public void click_AddNewFarmersMarket_Tab() {
		applyWait.waitForElementToBeClickable(AddNewfarmersMarket, DefineConstants.explicitWait_60);
		javascriptClick.click(AddNewfarmersMarket);
		try {
			Screenshots.takeScreenshot(driver, "User clicked Add Farmer's Market");
			test.log(Status.INFO, "User clicked Add Farmer's Market tab");
			Log.info("User clicked Add Farmer's Market tab");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void enterMarketName(String subject){
		applyWait.waitForElementToBeClickable(marketName, DefineConstants.explicitWait_60).clear();
		marketName.sendKeys(subject);
			try {
				Screenshots.takeScreenshot(driver, "User enter market name as "+ subject);
				test.log(Status.INFO, "User enter market name as "+ subject);
				Log.info("User enter market name as "+ subject);
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}	
   }
	
	public void enterMarketPhone(String subject){
		applyWait.waitForElementToBeClickable(marketPhone, DefineConstants.explicitWait_60).clear();
		marketPhone.sendKeys(subject);
			try {
				Screenshots.takeScreenshot(driver, "User enter market phone as "+ subject);
				test.log(Status.INFO, "User enter market phone as "+ subject);
				Log.info("User enter market phone as "+ subject);
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}	
   }
	
	public void enterMarketEmail(String subject){
		applyWait.waitForElementToBeClickable(marketEmail, DefineConstants.explicitWait_60).clear();
		marketEmail.sendKeys(subject);
			try {
				Screenshots.takeScreenshot(driver, "User enter market email as "+ subject);
				test.log(Status.INFO, "User enter market email as "+ subject);
				Log.info("User enter market email as "+ subject);
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}	
   }
	
	public void enterMarketServiceArea(String subject){
		applyWait.waitForElementToBeClickable(serviceArea, DefineConstants.explicitWait_60).click();
		serviceArea.sendKeys(subject);
		serviceArea.sendKeys(Keys.ENTER);
			try {
				Screenshots.takeScreenshot(driver, "User enter market service area as "+ subject);
				test.log(Status.INFO, "User enter market service area as "+ subject);
				Log.info("User enter market service area as "+ subject);
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}	
   }
	
	public void upload_Image(String input_ImageName)  {
		//applyWait.waitForElementToBeClickable(fileUpload, DefineConstants.explicitWait_30)
		//		.sendKeys(DefineConstants.PROJECT_PATH1 + "FilesToUpload" + "/" + input_ImageName);
		
	//	fileUpload.click();;
		fileUpload.sendKeys("C:\\Users\\Dell\\eclipse-workspace\\KISAAN\\FilesToUpload\\Market Shop.jpg");
		try {
			Screenshots.takeScreenshot(driver, "User uploaded " + input_ImageName + "Image");
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		test.log(Status.INFO, "User uploaded " + input_ImageName + "Image");
		Log.info("User uploaded " + input_ImageName + "Image");
		
	}
	
	public void enterMarketAddress(String subject){
		applyWait.waitForElementToBeClickable(marketAddress, DefineConstants.explicitWait_60).clear();
		marketAddress.sendKeys(subject);
			try {
				Screenshots.takeScreenshot(driver, "User enter market address as "+ subject);
				test.log(Status.INFO, "User enter market address as "+ subject);
				Log.info("User enter market address as "+ subject);
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}	
   }
	
	public void enterMarketCity(String subject){
		applyWait.waitForElementToBeClickable(marketCity, DefineConstants.explicitWait_60).clear();
		marketCity.sendKeys(subject);
			try {
				Screenshots.takeScreenshot(driver, "User enter market city as "+ subject);
				test.log(Status.INFO, "User enter market city as "+ subject);
				Log.info("User enter market city as "+ subject);
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}	
   }
	
	public void enterMarketZipCode(String subject){
		applyWait.waitForElementToBeClickable(marketZipCode, DefineConstants.explicitWait_60).clear();
		marketZipCode.sendKeys(subject);
			try {
				Screenshots.takeScreenshot(driver, "User enter market zipcode as "+ subject);
				test.log(Status.INFO, "User enter market zipcode as "+ subject);
				Log.info("User enter market zipcode as "+ subject);
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}	
   }
	
	public void enterPickupAddress(String subject){
		applyWait.waitForElementToBeClickable(pickupAddress, DefineConstants.explicitWait_60).clear();
		pickupAddress.sendKeys(subject);
			try {
				Screenshots.takeScreenshot(driver, "User enter pickup address as "+ subject);
				test.log(Status.INFO, "User enter pickup address as "+ subject);
				Log.info("User enter pickup address as "+ subject);
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}	
   }
	
	public void enterPickupCity(String subject){
		applyWait.waitForElementToBeClickable(pickupCity, DefineConstants.explicitWait_60).clear();
		pickupCity.sendKeys(subject);
			try {
				Screenshots.takeScreenshot(driver, "User enter pickup city as "+ subject);
				test.log(Status.INFO, "User enter pickup city as "+ subject);
				Log.info("User enter pickup city as "+ subject);
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}	
   }
	
	public void enterPickupZipCode(String subject){
		applyWait.waitForElementToBeClickable(pickupZip, DefineConstants.explicitWait_60).clear();
		pickupZip.sendKeys(subject);
			try {
				Screenshots.takeScreenshot(driver, "User enter pickup zipcode as "+ subject);
				test.log(Status.INFO, "User enter pickup zipcode as "+ subject);
				Log.info("User enter pickup zipcode as "+ subject);
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}	
   }
	
	public void click_AddMarketBtn() {
		applyWait.waitForElementToBeClickable(addMarketBtn, DefineConstants.explicitWait_60);
		javascriptClick.click(addMarketBtn);
		try {
			Screenshots.takeScreenshot(driver, "User clicked Add Market button");
			test.log(Status.INFO, "User clicked Add Market button");
			Log.info("User clicked Add Market button");		
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
	
	public void click_Edit(String email) {
		WebElement details=driver.findElement(By.xpath("//td[text()='"+email+"']/following-sibling::td[3]/a"));
		javascriptClick.click(details);
		try {
			Screenshots.takeScreenshot(driver, "User clicked edit market of "+email);
			test.log(Status.INFO, "User clicked edit market of "+email);
			Log.info("User clicked edit market of "+email);		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void click_Deactive(String email) {
		WebElement details=driver.findElement(By.xpath("//td[text()='"+email+"']/following-sibling::td[3]/a[2]"));
		javascriptClick.click(details);
		try {
			Screenshots.takeScreenshot(driver, "User clicked deactive market of "+email);
			test.log(Status.INFO, "User clicked deactive market of "+email);
			Log.info("User clicked deactive market of "+email);		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void click_ViewDetails(String email) {
		WebElement details=driver.findElement(By.xpath("//td[text()='"+email+"']/following-sibling::td[3]/a[3]"));
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
	
	public void click_UpdateTiming(String email) {
		WebElement details=driver.findElement(By.xpath("//td[text()='"+email+"']/following-sibling::td[3]/a[4]"));
		javascriptClick.click(details);
		try {
			Screenshots.takeScreenshot(driver, "User clicked update timing market of "+email);
			test.log(Status.INFO, "User clicked update timing market of "+email);
			Log.info("User clicked update timing market of "+email);		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void select_Date(String input_ScheduledDate) {
		try {
		//	applyWait.waitForElementToBeClickable(Date, DefineConstants.explicitWait_30).click();
			date = driver.findElement(By.xpath("//a[contains(text(),'"+input_ScheduledDate+"')]"));
			date.click();
			Screenshots.takeScreenshot(driver, "User selected schedule date as " + input_ScheduledDate);
			test.log(Status.INFO, "User selected schedule date as " + input_ScheduledDate);
			Log.info("User selected schedule date as " + input_ScheduledDate);
			Thread.sleep(3000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
