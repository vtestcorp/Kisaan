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

public class Slider_Setting_Page {
	
	private WebDriver driver;
	private WaitTypes applyWait;
	private ExtentTest test;
	private JavascriptClick javascriptClick;
	private DropDown dropDown;

	public Slider_Setting_Page(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.applyWait = new WaitTypes(driver);
		this.test = test;
		javascriptClick = new JavascriptClick(driver);
		dropDown=new DropDown(driver);
	}
	
	@FindBy(xpath = "//a[normalize-space()='Slider Settings']")
	private WebElement sliderTab;
	
	@FindBy(xpath = "//a[@class='btn btn-primary btn-add']")
	private WebElement addNewSlider;
	
	@FindBy(xpath = "//input[@name='image']")
	private WebElement uploadFile;
	
	@FindBy(xpath = "//input[@name='title']")
	private WebElement sliderTitle;
	
	@FindBy(xpath = "//input[@name='text']")
	private WebElement sliderText;
	
	@FindBy(xpath = "//select[@name='text_position']")
	private WebElement sliderTextPosition;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement addSliderButton;
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchSlider;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissable']")
	private WebElement SuccessMessage;
	
	@FindBy(xpath = "//table[@id='example']")
	private WebElement table;
	
	private List<WebElement> tableRows;

	private List<WebElement> tableColums;
	
	
	public void click_SliderSetting_Tab() {
		applyWait.waitForElementToBeClickable(sliderTab, DefineConstants.explicitWait_60);
		javascriptClick.click(sliderTab);
		try {
			Screenshots.takeScreenshot(driver, "User clicked Slider Setting tab");
			test.log(Status.INFO, "User clicked Slider Setting tab");
			Log.info("User clicked Slider Setting tab");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void click_Add_New_Slider() {
		applyWait.waitForElementToBeClickable(addNewSlider, DefineConstants.explicitWait_60);
		javascriptClick.click(addNewSlider);
		try {
			Screenshots.takeScreenshot(driver, "User clicked add new Slider");
			test.log(Status.INFO, "User clicked add new Slider");
			Log.info("User clicked add new Slider");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void upload_Image(String input_ImageName)  {
		applyWait.waitForElementToBeClickable(uploadFile, DefineConstants.explicitWait_30)
				.sendKeys(DefineConstants.PROJECT_PATH + "FilesToUpload" + "/" + input_ImageName);
		try {
			Screenshots.takeScreenshot(driver, "User uploaded " + input_ImageName + "Image");
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(Status.INFO, "User uploaded " + input_ImageName + "Image");
		Log.info("User uploaded " + input_ImageName + "Image");
		
	}
	
	public void enter_SliderTitle(String input) {
		applyWait.waitForElementToBeClickable(sliderTitle, DefineConstants.explicitWait_60).clear();
		sliderTitle.sendKeys(input);
		try {
			Screenshots.takeScreenshot(driver, "User enter Slider Title as: "+input);
			test.log(Status.INFO, "User enter Slider Title as: "+input);
			Log.info("User enter Slider Title as: "+input);		
			Thread.sleep(3000);
		} catch (Exception e) {
		}
    }
	
	public void enter_SliderText(String input) {
		applyWait.waitForElementToBeClickable(sliderText, DefineConstants.explicitWait_60).clear();
		sliderText.sendKeys(input);
		try {
			Screenshots.takeScreenshot(driver, "User enter Slider Text as: "+input);
			test.log(Status.INFO, "User enter Slider Text :"+input);
			Log.info("User enter Slider Text :"+input);		
			Thread.sleep(3000);
		} catch (Exception e) {
		}
    }
	
	public void select_SliderPosition(String input) {
		applyWait.waitForElementToBeClickable(sliderTextPosition, DefineConstants.explicitWait_60);
		dropDown.selectByVisibleText(sliderTextPosition, input);
		try {
			Screenshots.takeScreenshot(driver, "User Select Slider Text Position as "+input);
			test.log(Status.INFO, "User Select Slider Text Position as "+input);
			Log.info("User Select Slider Text Position as "+input);		
			Thread.sleep(3000);
		} catch (Exception e) {
		}
    }
	
	public void click_AddSliderButton() {
		applyWait.waitForElementToBeClickable(addSliderButton, DefineConstants.explicitWait_60);
		javascriptClick.click(addSliderButton);
		try {
			Screenshots.takeScreenshot(driver, "User clicked add Slider Button");
			test.log(Status.INFO, "User clicked add Slider Button");
			Log.info("User clicked add Slider Button");		
			Thread.sleep(3000);
		} catch (Exception e) {
		}
    }
	
	public void searchSlider(String input_ProductName){
		applyWait.waitForElementToBeClickable(searchSlider, DefineConstants.explicitWait_60);
		searchSlider.sendKeys(input_ProductName);
			try {
				Screenshots.takeScreenshot(driver, "User search Slider as "+ input_ProductName);
				test.log(Status.INFO, "User search Slider as "+ input_ProductName);
				Log.info("User search Slider as "+ input_ProductName);
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
	
	public void click_EditSlider(String inputProduct) {
		WebElement slider=driver.findElement(By.xpath("//td[normalize-space()='"+inputProduct+"']/following-sibling::td[2]/form/a[1]"));
		javascriptClick.click(slider);
		try {
			Screenshots.takeScreenshot(driver, "User clicked on edit Slider");
			test.log(Status.INFO, "User clicked on edit Slider");
			Log.info("User clicked on edit Slider");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void click_RemoveSlider(String inputProduct) {
		WebElement slider=driver.findElement(By.xpath("//td[normalize-space()='"+inputProduct+"']/following-sibling::td[2]/form/button"));
		javascriptClick.click(slider);
		try {
			Screenshots.takeScreenshot(driver, "User clicked on delete Slider");
			test.log(Status.INFO, "User clicked on delete Slider");
			Log.info("User clicked on delete Slider");		
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

}
