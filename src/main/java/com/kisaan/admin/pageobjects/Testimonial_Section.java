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

public class Testimonial_Section {
	private WebDriver driver;
	private WaitTypes applyWait;
	private ExtentTest test;
	private JavascriptClick javascriptClick;
	private DropDown dropDown;

	public Testimonial_Section(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.applyWait = new WaitTypes(driver);
		this.test = test;
		javascriptClick = new JavascriptClick(driver);
		dropDown=new DropDown(driver);
	}
	
	@FindBy(xpath = "//a[@href='http://grocery-delivery.devwepro.com/admin/testimonial']")
	private WebElement testimonialSection;
	
	@FindBy(xpath = "//a[@class='btn btn-primary btn-add']")
	private WebElement addTestimonial;
	
	@FindBy(xpath = "//textarea[@name='review']")
	private WebElement clientReview;
	
	@FindBy(xpath = "//input[@name='client']")
	private WebElement clientName;
	
	@FindBy(xpath = "//input[@name='designation']")
	private WebElement clientDesignation;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement addTestimonialButton;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissable']")
	private WebElement SuccessMessage;
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchClientName;
	
	@FindBy(xpath = "//table[@id='example']")
	private WebElement table;
	
	private List<WebElement> tableRows;

	private List<WebElement> tableColums;
	
	@FindBy(xpath = "//strong[normalize-space()='Testimonial Section Title']")
	private WebElement testimonialTitle;
	
	@FindBy(xpath = "//input[@placeholder='Service Title']")
	private WebElement testimonialTitleTextbox;
	
	@FindBy(xpath = "//textarea[@name='testimonial_text']")
	private WebElement testimonialTitleText;
	
	@FindBy(xpath = "//button[normalize-space()='Update Text']")
	private WebElement updateTestimonial;
	
	public void click_TestimonialSection_Tab() {
		applyWait.waitForElementToBeClickable(testimonialSection, DefineConstants.explicitWait_60);
		javascriptClick.click(testimonialSection);
		try {
			Screenshots.takeScreenshot(driver, "User clicked Testimonial Section tab");
			test.log(Status.INFO, "User clicked Testimonial Section tab");
			Log.info("User clicked Testimonial Section tab");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void click_AddTestimonial() {
		applyWait.waitForElementToBeClickable(addTestimonial, DefineConstants.explicitWait_60);
		javascriptClick.click(addTestimonial);
		try {
			Screenshots.takeScreenshot(driver, "User clicked add Testimonial");
			test.log(Status.INFO, "User clicked add Testimonial");
			Log.info("User clicked add Testimonial");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void enter_ClientReview(String input) {
		applyWait.waitForElementToBeClickable(clientReview, DefineConstants.explicitWait_60).clear();
		clientReview.sendKeys(input);
		try {
			Screenshots.takeScreenshot(driver, "User enter client review as: "+input);
			test.log(Status.INFO, "User enter client review as: "+input);
			Log.info("User enter client review as: "+input);		
			Thread.sleep(3000);
		} catch (Exception e) {
		}
    }
	
	public void enter_ClientName(String input) {
		applyWait.waitForElementToBeClickable(clientName, DefineConstants.explicitWait_60).clear();
		clientName.sendKeys(input);
		try {
			Screenshots.takeScreenshot(driver, "User enter client name as: "+input);
			test.log(Status.INFO, "User enter client name as: "+input);
			Log.info("User enter client name as: "+input);		
			Thread.sleep(3000);
		} catch (Exception e) {
		}
    }
	
	public void enter_ClientDesignation(String input) {
		applyWait.waitForElementToBeClickable(clientDesignation, DefineConstants.explicitWait_60).clear();
		clientDesignation.sendKeys(input);
		try {
			Screenshots.takeScreenshot(driver, "User enter Client Designation as: "+input);
			test.log(Status.INFO, "User enter Client Designation as: "+input);
			Log.info("User enter Client Designation as: "+input);		
			Thread.sleep(3000);
		} catch (Exception e) {
		}
    }
	
	public void click_AddTestimonialButton() {
		applyWait.waitForElementToBeClickable(addTestimonialButton, DefineConstants.explicitWait_60);
		javascriptClick.click(addTestimonialButton);
		try {
			Screenshots.takeScreenshot(driver, "User clicked add Testimonial button");
			test.log(Status.INFO, "User clicked add Testimonial button");
			Log.info("User clicked add Testimonial button");		
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
	
	public void searchClientName(String input_ProductName){
		applyWait.waitForElementToBeClickable(searchClientName, DefineConstants.explicitWait_60);
		searchClientName.sendKeys(input_ProductName);
			try {
				Screenshots.takeScreenshot(driver, "User search client name as "+ input_ProductName);
				test.log(Status.INFO, "User search client name as "+ input_ProductName);
				Log.info("User search client name as "+ input_ProductName);
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
	
	public void click_EditTestimonial(String inputProduct) {
		WebElement slider=driver.findElement(By.xpath("//td[normalize-space()='"+inputProduct+"']/following-sibling::td[2]/form/a[1]"));
		javascriptClick.click(slider);
		try {
			Screenshots.takeScreenshot(driver, "User clicked on edit testimonial");
			test.log(Status.INFO, "User clicked on edit testimonial");
			Log.info("User clicked on edit testimonial");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void click_RemoveTestimonial(String inputProduct) {
		WebElement slider=driver.findElement(By.xpath("//td[normalize-space()='"+inputProduct+"']/following-sibling::td[2]/form/button"));
		javascriptClick.click(slider);
		try {
			Screenshots.takeScreenshot(driver, "User clicked on delete testimonial");
			test.log(Status.INFO, "User clicked on delete testimonial");
			Log.info("User clicked on delete testimonial");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void verifyInputValueDelete(String inputEmailAddress) {
		applyWait.waitForElementToBeClickable(table, DefineConstants.explicitWait_60);
		tableRows = table.findElements(By.tagName("tr"));

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
	
	public void click_TestimonialSectionTitle() {
		applyWait.waitForElementToBeClickable(testimonialTitle, DefineConstants.explicitWait_60);
		javascriptClick.click(testimonialTitle);
		try {
			Screenshots.takeScreenshot(driver, "User clicked Testimonial Section Title");
			test.log(Status.INFO, "User clicked Testimonial Section Title");
			Log.info("User clicked Testimonial Section Title");		
			Thread.sleep(3000);
		} catch (Exception e) {
		}
    }
	
	public void enter_TestimonialTitle(String input) {
		applyWait.waitForElementToBeClickable(testimonialTitleTextbox, DefineConstants.explicitWait_60).clear();
		testimonialTitleTextbox.sendKeys(input);
		try {
			Screenshots.takeScreenshot(driver, "User enter testimonial title as: "+input);
			test.log(Status.INFO, "User enter testimonial title as: "+input);
			Log.info("User enter testimonial title as: "+input);		
			Thread.sleep(3000);
		} catch (Exception e) {
		}
    }
	
	public void enter_TestimonialText(String input) {
		applyWait.waitForElementToBeClickable(testimonialTitleText, DefineConstants.explicitWait_60).clear();
		testimonialTitleText.sendKeys(input);
		try {
			Screenshots.takeScreenshot(driver, "User enter testimonial text as: "+input);
			test.log(Status.INFO, "User enter testimonial text as: "+input);
			Log.info("User enter testimonial text as: "+input);		
			Thread.sleep(3000);
		} catch (Exception e) {
		}
    }
	
	public void click_UpdateTestimonialSectionTitle() {
		applyWait.waitForElementToBeClickable(updateTestimonial, DefineConstants.explicitWait_60);
		javascriptClick.click(updateTestimonial);
		try {
			Screenshots.takeScreenshot(driver, "User clicked update Testimonial Section Title");
			test.log(Status.INFO, "User clicked update Testimonial Section Title");
			Log.info("User clicked update Testimonial Section Title");		
			Thread.sleep(3000);
		} catch (Exception e) {
		}
    }
	

}
