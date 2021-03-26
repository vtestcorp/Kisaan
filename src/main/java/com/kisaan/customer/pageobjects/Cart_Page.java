package com.kisaan.customer.pageobjects;

import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import config.DefineConstants;
import helperMethods.JavascriptClick;
import helperMethods.Log;
import helperMethods.Screenshots;
import helperMethods.ScrollTypes;
import helperMethods.WaitTypes;

public class Cart_Page {
	private WebDriver driver;
	private WaitTypes applyWait;
	private ExtentTest test;
	private JavascriptClick javascriptClick;
	private ScrollTypes scrollTypes;

	public Cart_Page(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.applyWait = new WaitTypes(driver);
		this.test = test;
		javascriptClick = new JavascriptClick(driver);
		scrollTypes = new ScrollTypes(driver);
	}

	@FindBy(xpath = "//table[@class='table']")
	private WebElement customerCart_Table;

	private List<WebElement> tableRows;

	private List<WebElement> tableColums;

	@FindBy(xpath = "//a[normalize-space()='Proceed To Checkout']")
	private WebElement proceedToCheckout;
	
	public void deleteProduct(String input_ProductName) throws IOException {
		applyWait.waitForElementToBeClickable(customerCart_Table, DefineConstants.explicitWait_60);
		tableRows = customerCart_Table.findElements(By.tagName("tr"));
		for (int row = 0; row < tableRows.size(); row++) {
			tableColums = tableRows.get(row).findElements(By.tagName("td"));
			for (int column = 0; column < tableColums.size(); column++) {
				String cellText = tableColums.get(column).getText();
				System.out.println("cell textx is " + cellText);
				if (cellText.contains(input_ProductName)||cellText.contains(input_ProductName)) {
					javascriptClick.highLighterMethod(tableColums.get(column));
					test.log(Status.INFO, input_ProductName+ " is present");
					Log.info(input_ProductName+ " is present");
					Screenshots.takeScreenshot(driver, input_ProductName+ " is present");
                    WebElement s=driver.findElement(By.xpath("//a[text()='"+input_ProductName+"']/preceding::td[2]/a/i"));  
                    s.click();
                    test.log(Status.INFO, input_ProductName +" is deleted");
					Log.info(input_ProductName +" is deleted");
					Screenshots.takeScreenshot(driver, input_ProductName +" is deleted");
					break;
				}
			

				/*else if (cellText.equals(DefineConstants.There_is_no_data_for_this_view)) {
					javascriptClick.highLighterMethod(tableColums.get(column));
					Screenshots.takeScreenshot(driver, draftName + " is not found");
					test.log(Status.INFO, "value is " + cellText);
					Log.info("value is " + cellText);
					System.out.println("value is " + cellText);
					test.log(Status.INFO, draftName + " is not found");
					Log.info(draftName + " is not found");
					Assert.assertTrue(false, draftName + " is not found");
				}*/
			}
		}
	}
		
	public void updateProductQuantity(String input_ProductName, String input_Quantity) throws IOException {
		applyWait.waitForElementToBeClickable(customerCart_Table, DefineConstants.explicitWait_60);
		tableRows = customerCart_Table.findElements(By.tagName("tr"));
		for (int row = 0; row < tableRows.size(); row++) {
			tableColums = tableRows.get(row).findElements(By.tagName("td"));
			for (int column = 0; column < tableColums.size(); column++) {
				String cellText = tableColums.get(column).getText();		
				if (cellText.contains(input_ProductName)||cellText.contains(input_ProductName)) {			
					javascriptClick.highLighterMethod(tableColums.get(column));
					test.log(Status.INFO, input_ProductName+ " is present");
					Log.info(input_ProductName+ " is present");
					Screenshots.takeScreenshot(driver, input_ProductName+ " is present");
					WebElement productQuantityElement=driver.findElement(By.xpath("//td/a[text()='"+input_ProductName+"']/following::span[2]"));
                    String productQuantityText=productQuantityElement.getText();
                    test.log(Status.INFO, input_ProductName +" quantity is "+productQuantityText);
					Log.info(input_ProductName +" quantity is "+productQuantityText);
					Screenshots.takeScreenshot(driver, input_ProductName +" quantity is "+productQuantityText);
                   
					int productQuantityNumber=Integer.parseInt(productQuantityText);
                    int inputProductQuantityNumber=Integer.parseInt(input_Quantity);
                    if(productQuantityNumber < inputProductQuantityNumber){                    	                    
                    	while(!productQuantityElement.getText().equals(input_Quantity)){                    		
                    		driver.findElement(By.xpath("//td/a[text()='"+input_ProductName+"']/following::span[3]")).click();                    		
                    	}
                    }
                    javascriptClick.highLighterMethod(productQuantityElement);
                    String productUpdatedQuantity=productQuantityElement.getText();
                    test.log(Status.INFO, input_ProductName +" updated quantity is "+productUpdatedQuantity);
					Log.info(input_ProductName +" updated quantity is "+productUpdatedQuantity);
					Screenshots.takeScreenshot(driver, input_ProductName +" updated quantity is "+productUpdatedQuantity);
				}
			}			
		}	
	}
	
	public void updateProductQuantity(JSONArray jsonArray) throws IOException {
		
	for (int i = 0; i < jsonArray.size(); i++) {
		JSONObject productDetails = (JSONObject) jsonArray.get(i);
		String input_ProductName = productDetails.get("productName").toString();
		String input_Quantity = productDetails.get("quantity").toString();
			
		applyWait.waitForElementToBeClickable(customerCart_Table, DefineConstants.explicitWait_60);
		tableRows = customerCart_Table.findElements(By.tagName("tr"));
		for (int row = 0; row < tableRows.size(); row++) {
			tableColums = tableRows.get(row).findElements(By.tagName("td"));
			for (int column = 0; column < tableColums.size(); column++) {
				String cellText = tableColums.get(column).getText();		
				if (cellText.contains(input_ProductName)||cellText.contains(input_ProductName)) {			
					javascriptClick.highLighterMethod(tableColums.get(column));
					test.log(Status.INFO, input_ProductName+ " is present");
					Log.info(input_ProductName+ " is present");
					Screenshots.takeScreenshot(driver, input_ProductName+ " is present");
					WebElement productQuantityElement=driver.findElement(By.xpath("//td/a[text()='"+input_ProductName+"']/following::span[2]"));
                    String productQuantityText=productQuantityElement.getText();
                    test.log(Status.INFO, input_ProductName +" quantity is "+productQuantityText);
					Log.info(input_ProductName +" quantity is "+productQuantityText);
					Screenshots.takeScreenshot(driver, input_ProductName +" quantity is "+productQuantityText);
                    int productQuantityNumber=Integer.parseInt(productQuantityText);
                    int inputProductQuantityNumber=Integer.parseInt(input_Quantity);
                    if(productQuantityNumber<inputProductQuantityNumber){                    	                    
                    	while(!productQuantityElement.getText().equals(input_Quantity)){                    		
                    		driver.findElement(By.xpath("//td/a[text()='"+input_ProductName+"']/following::span[3]")).click();                    		
                    	}
                    }
                    javascriptClick.highLighterMethod(productQuantityElement);
                    String productUpdatedQuantity=productQuantityElement.getText();
                    test.log(Status.INFO, input_ProductName +" updated quantity is "+productUpdatedQuantity);
					Log.info(input_ProductName +" updated quantity is "+productUpdatedQuantity);
					Screenshots.takeScreenshot(driver, input_ProductName +" updated quantity is "+productUpdatedQuantity);
				}
			}
		  }
		}	
	driver.navigate().refresh();
	}
	
	public void click_ProceedToCheckoutButton() throws IOException{
		applyWait.waitForElementToBeClickable(proceedToCheckout, DefineConstants.explicitWait_30);
		scrollTypes.scrollInToView(proceedToCheckout);
		javascriptClick.click(proceedToCheckout);
		Screenshots.takeScreenshot(driver, "User clicked proceed to checkout button");
		test.log(Status.INFO, "User clicked proceed to checkout button");
		Log.info("User clicked proceed to checkout button");
	}
}