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

public class Products_Page {
	private WebDriver driver;
	private WaitTypes applyWait;
	private ExtentTest test;
	private JavascriptClick javascriptClick;
	private ScrollTypes scrollTypes;
	private DropDown dropdown;

	public Products_Page(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.applyWait = new WaitTypes(driver);
		this.test = test;
		javascriptClick = new JavascriptClick(driver);
		scrollTypes = new ScrollTypes(driver);
		dropdown = new DropDown(driver);
	}

	@FindBy(xpath = "//a[normalize-space()='Add New Product']")
	private WebElement addNewProduct_Button;

	@FindBy(id = "name")
	private WebElement productName_TextBox;

	@FindBy(id = "maincats")
	private WebElement mainCategoryDropdown;

	@FindBy(xpath = "//select[@id='subs']")
	private WebElement subCategoryDropdown;

	@FindBy(id = "uploadFile")
	private WebElement currentFeaturedImage;

	@FindBy(xpath = "//textarea[@id='description']//preceding::div[1]")
	private WebElement productDescriptionTextBox;

	@FindBy(name = "price")
	private WebElement productCurrentPriceTextBox;

	@FindBy(name = "previous_price")
	private WebElement productPreviousPriceTextBox;

	@FindBy(name = "stock")
	private WebElement productStockTextBox;
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement search;

	// @FindBy(name =
	// "//div[contains(@class,'bootstrap-tagsinput')]//input[contains(@type,'text')]//preceding::div[1]")
	@FindBy(xpath = "//textarea[@id='policy']//preceding::div[1]")
	private WebElement productBuyReturnPolicyTextBox;

	@FindBy(xpath = "//div[contains(@class,'bootstrap-tagsinput')]//input[contains(@type,'text')]")
	private WebElement productTagsTextBox;

	@FindBy(id = "add_ads")
	private WebElement addNewProductLast_Button;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissable']")
	private WebElement successMessage;
	
	@FindBy(xpath = "//input[@id='stores_list-selectized']")
	private WebElement vendorSuperMarket;

	@FindBy(xpath = "//table[@id='example']")
	private WebElement products_Table;
	
	@FindBy(xpath = "//select[@name='unit_id']")
	private WebElement vendorUnit;

	private List<WebElement> tableRows;

	private List<WebElement> tableColums;

	public void click_AddNewProductButton() throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(addNewProduct_Button, DefineConstants.explicitWait_30).click();
		// javascriptClick.highLighterMethod(emailAddress_TextBox);
		Screenshots.takeScreenshot(driver, "User clicked add new product button");
		test.log(Status.INFO, "User clicked add new product button");
		Log.info("User clicked add new product button");
	}

	public void enter_ProductName(String input_ProductName) throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(productName_TextBox, DefineConstants.explicitWait_30).clear();
		productName_TextBox.sendKeys(input_ProductName);
		// javascriptClick.highLighterMethod(emailAddress_TextBox);
		Screenshots.takeScreenshot(driver, "User entered product name is " + input_ProductName);
		test.log(Status.INFO, "User entered product name is " + input_ProductName);
		Log.info("User entered product name is " + input_ProductName);
	}

	public void select_MainCategory(String input_MainCategory) throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(mainCategoryDropdown, DefineConstants.explicitWait_30);
		dropdown.selectByVisibleText(mainCategoryDropdown, input_MainCategory);
		// javascriptClick.highLighterMethod(emailAddress_TextBox);
		Screenshots.takeScreenshot(driver, "User selected main category as " + input_MainCategory);
		test.log(Status.INFO, "User selected main category as " + input_MainCategory);
		Log.info("User selected main category as " + input_MainCategory);
	}

	public void select_SubCategory(String input_SubCategory) throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(subCategoryDropdown, DefineConstants.explicitWait_30);
		dropdown.selectByVisibleText(subCategoryDropdown, input_SubCategory);
		// javascriptClick.highLighterMethod(emailAddress_TextBox);
		Screenshots.takeScreenshot(driver, "User selected sub category as " + input_SubCategory);
		test.log(Status.INFO, "User selected sub category as " + input_SubCategory);
		Log.info("User selected sub category as " + input_SubCategory);
	}
	
	public void select_SuperMarket(String category) {
		applyWait.waitForElementToBeClickable(vendorSuperMarket, DefineConstants.explicitWait_60);
		//dropDown.selectByVisibleText(vendorSuperMarket, category);
		vendorSuperMarket.click();
		vendorSuperMarket.sendKeys(category);
		vendorSuperMarket.sendKeys(Keys.ENTER);
			try {
				Screenshots.takeScreenshot(driver, "User selected vendor Super market as "+ category);
				test.log(Status.INFO, "User selected vendor Super market as "+ category);
				Log.info("User selected vendor Super market as "+ category);
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}	
   }
	
	public void select_VendorUnit(String category) {
		applyWait.waitForElementToBeClickable(vendorUnit, DefineConstants.explicitWait_60);
		dropdown.selectByVisibleText(vendorUnit, category);
			try {
				Screenshots.takeScreenshot(driver, "User selected Unit as "+ category);
				test.log(Status.INFO, "User selected Unit as "+ category);
				Log.info("User selected Unit as "+ category);
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}	
   }

	public void upload_Image(String input_ImageName) throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(currentFeaturedImage, DefineConstants.explicitWait_30)
				.sendKeys(DefineConstants.PROJECT_PATH + "FilesToUpload" + "/" + input_ImageName);
		// javascriptClick.highLighterMethod(emailAddress_TextBox);
		Screenshots.takeScreenshot(driver, "User uploaded " + input_ImageName + "Image");
		test.log(Status.INFO, "User uploaded " + input_ImageName + "Image");
		Log.info("User uploaded " + input_ImageName + "Image");
	}

	public void enter_ProductDescription(String input_ProductDescription) throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(productDescriptionTextBox, DefineConstants.explicitWait_30).clear();
		productDescriptionTextBox.sendKeys(input_ProductDescription);
		// javascriptClick.click(productDescriptionTextBox);
		// javascriptClick.sendKeys(productDescriptionTextBox,input_ProductDescription);
		// javascriptClick.highLighterMethod(emailAddress_TextBox);
		Screenshots.takeScreenshot(driver, "User entered product description as  " + input_ProductDescription);
		test.log(Status.INFO, "User entered product description as  " + input_ProductDescription);
		Log.info("User entered product description as  " + input_ProductDescription);
	}

	public void enter_ProductCurrentPrice(String input_ProductCurrentPrice) throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(productCurrentPriceTextBox, DefineConstants.explicitWait_30).clear();
		productCurrentPriceTextBox.sendKeys(input_ProductCurrentPrice);
		// javascriptClick.highLighterMethod(emailAddress_TextBox);
		Screenshots.takeScreenshot(driver, "User entered product price as  " + input_ProductCurrentPrice);
		test.log(Status.INFO, "User entered product price as  " + input_ProductCurrentPrice);
		Log.info("User entered product price as  " + input_ProductCurrentPrice);
	}

	public void enter_ProductPreviousPrice(String input_ProductPreviousPrice) throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(productPreviousPriceTextBox, DefineConstants.explicitWait_30).clear();
		productPreviousPriceTextBox.sendKeys(input_ProductPreviousPrice);
		// javascriptClick.highLighterMethod(emailAddress_TextBox);
		Screenshots.takeScreenshot(driver, "User entered product previous price as  " + input_ProductPreviousPrice);
		test.log(Status.INFO, "User entered product previous price as  " + input_ProductPreviousPrice);
		Log.info("User entered product previous price as  " + input_ProductPreviousPrice);
	}

	public void enter_ProductStock(String input_ProductStock) throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(productStockTextBox, DefineConstants.explicitWait_30).clear();
		productStockTextBox.sendKeys(input_ProductStock);
		// javascriptClick.highLighterMethod(emailAddress_TextBox);
		Screenshots.takeScreenshot(driver, "User entered product stock as  " + input_ProductStock);
		test.log(Status.INFO, "User entered product stock as  " + input_ProductStock);
		Log.info("User entered product stock as  " + input_ProductStock);
	}

	public void enter_ProductBuyReturnPolicy(String input_ProductBuyReturnPolicy)
			throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(productBuyReturnPolicyTextBox, DefineConstants.explicitWait_30).clear();
		productBuyReturnPolicyTextBox.sendKeys(input_ProductBuyReturnPolicy);
		// javascriptClick.highLighterMethod(emailAddress_TextBox);
		Screenshots.takeScreenshot(driver,
				"User entered product buy return policy as  " + input_ProductBuyReturnPolicy);
		test.log(Status.INFO, "User entered product buy return policy as  " + input_ProductBuyReturnPolicy);
		Log.info("User entered product buy return policy as  " + input_ProductBuyReturnPolicy);
	}

	public void enter_ProductTags(String input_ProductTags) throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(productTagsTextBox, DefineConstants.explicitWait_30).click();
		productTagsTextBox.sendKeys(Keys.BACK_SPACE);
		productTagsTextBox.sendKeys(input_ProductTags);
		// javascriptClick.highLighterMethod(emailAddress_TextBox);
		Screenshots.takeScreenshot(driver, "User entered product tags as  " + input_ProductTags);
		test.log(Status.INFO, "User entered product tags as  " + input_ProductTags);
		Log.info("User entered product tags as  " + input_ProductTags);
	}

	public void click_LastAddNewProductButton() throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(addNewProductLast_Button, DefineConstants.explicitWait_30).click();
		// javascriptClick.highLighterMethod(emailAddress_TextBox);
		Screenshots.takeScreenshot(driver, "User clicked add new product button to submit details");
		test.log(Status.INFO, "User clicked add new product button to submit details");
		Log.info("User clicked add new product button to submit details");
	}
	
	public void searchProductName(String input) throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(search, DefineConstants.explicitWait_30).clear();
		search.sendKeys(input);
		Screenshots.takeScreenshot(driver, "User search product name as  " + input);
		test.log(Status.INFO, "User search product name as  " + input);
		Log.info("User search product name as  " + input);
	}

	public void verify_SuccessMessage() throws IOException, InterruptedException {
		applyWait.waitForElementToBeClickable(successMessage, DefineConstants.explicitWait_30);
		if (successMessage.isDisplayed()) {
			Assert.assertTrue(true, "Account Password Updated Successfully.");
			javascriptClick.highLighterMethod(successMessage);
			Screenshots.takeScreenshot(driver, "Account Password Updated Successfully. displayed to the user");
			test.log(Status.INFO, "Account Password Updated Successfully. displayed to the user");
			Log.info("Account Password Updated Successfully. displayed to the user");
		}
	}

	public void verifyProduct(String input_ProductName) throws IOException {
		applyWait.waitForElementToBeClickable(products_Table, DefineConstants.explicitWait_60);
		tableRows = products_Table.findElements(By.tagName("tr"));
		for (int row = 0; row < tableRows.size(); row++) {
			tableColums = tableRows.get(row).findElements(By.tagName("td"));
			for (int column = 0; column < tableColums.size(); column++) {
				String cellText = tableColums.get(column).getText();
				if (cellText.contains(input_ProductName) || cellText.equals(input_ProductName)) {
					javascriptClick.highLighterMethod(tableColums.get(column));
					test.log(Status.INFO, input_ProductName + " is present");
					Log.info(input_ProductName + " is present");
					Screenshots.takeScreenshot(driver, input_ProductName + " is present");
				}

				/*
				 * else if (cellText.equals(DefineConstants.
				 * There_is_no_data_for_this_view)) {
				 * javascriptClick.highLighterMethod(tableColums.get(column));
				 * Screenshots.takeScreenshot(driver, draftName +
				 * " is not found"); test.log(Status.INFO, "value is " +
				 * cellText); Log.info("value is " + cellText);
				 * System.out.println("value is " + cellText);
				 * test.log(Status.INFO, draftName + " is not found");
				 * Log.info(draftName + " is not found");
				 * Assert.assertTrue(false, draftName + " is not found"); }
				 */
			}
		}
	}

	public void editProduct(String input_ProductName) throws IOException {
		driver.findElement(By.xpath("//td[text()='"+input_ProductName+"']/following-sibling::td[5]/form/a[1]")).click();
		test.log(Status.INFO, "User Selected " + input_ProductName + " to edit");
		Log.info("User Selected " + input_ProductName + " to edit");
		Screenshots.takeScreenshot(driver, "User Selected " + input_ProductName + " to edit");
	}
	
	public void removeProduct(String input_ProductName) throws IOException {
		driver.findElement(By.xpath("//td[text()='"+input_ProductName+"']/following-sibling::td[5]/form/button")).click();
		test.log(Status.INFO, "User Selected " + input_ProductName + " to remove");
		Log.info("User Selected " + input_ProductName + " to remove");
		Screenshots.takeScreenshot(driver, "User Selected " + input_ProductName + " to remove");
	}
	
	public void changeProductStatus(String input_ProductName) throws IOException {
		driver.findElement(By.xpath("//td[text()='"+input_ProductName+"']/following-sibling::td[5]/form/a[2]")).click();
		test.log(Status.INFO, "User Selected " + input_ProductName + " to Deactive button");
		Log.info("User Selected " + input_ProductName + " to Deactive button");
		Screenshots.takeScreenshot(driver, "User Selected " + input_ProductName + " to Deactive button");
	}
	
	public void checkProductStatus(String input_ProductName) throws IOException {
		String productStatus=driver.findElement(By.xpath("//td[contains(text(),'"+input_ProductName+"')]//following::td[3]")).getText();
		javascriptClick.highLighterMethod(driver.findElement(By.xpath("//td[contains(text(),'"+input_ProductName+"')]//following::td[3]")));
		test.log(Status.INFO, input_ProductName + " status is "+productStatus);
		Log.info(input_ProductName + " status is "+productStatus);
		Screenshots.takeScreenshot(driver, input_ProductName + " status is "+productStatus);		
	}
}
