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

public class Manage_Category {
	private WebDriver driver;
	private WaitTypes applyWait;
	private ExtentTest test;
	private JavascriptClick javascriptClick;
	private DropDown dropDown;

	public Manage_Category(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.applyWait = new WaitTypes(driver);
		this.test = test;
		javascriptClick = new JavascriptClick(driver);
		dropDown=new DropDown(driver);
	}
	
	@FindBy(xpath = "//a[@href='http://www.kisaansquad.com/admin/categories']")
	private WebElement manage_Cateory;
	
	@FindBy(xpath = "//a[normalize-space()='Add Main Category']")
	private WebElement add_Main_Cateory;
	
	@FindBy(xpath = "//input[@id='name']")
	private WebElement enterName;
	
	@FindBy(xpath = "//input[@id='slug']")
	private WebElement enterURLSlug;
	
	@FindBy(xpath = "//input[@id='atofea']")
	private WebElement addToFeature;
	
	@FindBy(xpath = "//button[normalize-space()='Add Category']")
	private WebElement addCategoryButton;
	
	@FindBy(xpath = "//input[@type='file']")
	private WebElement fileUpload;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissable']")
	private WebElement successMessageCategory;
	
	@FindBy(xpath = "//input[@aria-controls='example']")
	private WebElement searchCategory;
	
	@FindBy(xpath = "//div[@class='tab-pane active']//table[@role='grid']")
	private WebElement productTable;
	
	@FindBy(xpath = "//button[text()='Update Category']")
	private WebElement updateCategory;
	
	@FindBy(xpath = "//strong[text()='Sub Category']")
	private WebElement subCategory;
	
	@FindBy(xpath = "//a[normalize-space()='Add Sub Category']")
	private WebElement addSubCategory;
	
	@FindBy(xpath = "//a[text()='Delete']")
	private WebElement DeleteCategoryAlert;
	
	@FindBy(xpath = "//select[@name='mainid']")
	private WebElement selectMainCategory;
	
	@FindBy(xpath = "//input[@aria-controls='example2']")
	private WebElement searchSubCategory;
	
	private List<WebElement> tableRows;

	private List<WebElement> tableColums;
	
	public void click_ManageCategory() {
		applyWait.waitForElementToBeClickable(manage_Cateory, DefineConstants.explicitWait_60);
		javascriptClick.click(manage_Cateory);
		try {
			Screenshots.takeScreenshot(driver, "User clicked Manage Category tab");
			test.log(Status.INFO, "User clicked Manage Category tab");
			Log.info("User clicked Manage Category tab");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void click_AddMainCategory() {
		applyWait.waitForElementToBeClickable(add_Main_Cateory, DefineConstants.explicitWait_60);
		javascriptClick.click(add_Main_Cateory);
		try {
			Screenshots.takeScreenshot(driver, "User clicked Add Main Category");
			test.log(Status.INFO, "User clicked Add Main Category");
			Log.info("User clicked Add Main Category");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void enter_CategoryName(String input_productName) {
		applyWait.waitForElementToBeClickable(enterName, DefineConstants.explicitWait_60).clear();
		enterName.sendKeys(input_productName);
			try {
				Screenshots.takeScreenshot(driver, "User entered Main Category as "+ input_productName);
				test.log(Status.INFO, "User entered Main Category as "+ input_productName);
				Log.info("User entered email Main Category as "+ input_productName);
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}	
   }
	
	public void enter_CategoryURLSlug(String input_productName) {
		applyWait.waitForElementToBeClickable(enterURLSlug, DefineConstants.explicitWait_60).clear();
		enterURLSlug.sendKeys(input_productName);
			try {
				Screenshots.takeScreenshot(driver, "User entered Category Url Slug");
				test.log(Status.INFO, "User entered Category Url Slug");
				Log.info( "User entered Category Url Slug");
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}	
   }
	
	public void click_AddToFeature() {
		applyWait.waitForElementToBeClickable(addToFeature, DefineConstants.explicitWait_60);
		javascriptClick.click(addToFeature);
		try {
			Screenshots.takeScreenshot(driver, "User clicked Add to Feature");
			test.log(Status.INFO, "User clicked Add to Feature");
			Log.info("User clicked Add to Feature");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void click_AddCategoryButton() {
		applyWait.waitForElementToBeClickable(addCategoryButton, DefineConstants.explicitWait_60);
		javascriptClick.click(addCategoryButton);
		try {
			Screenshots.takeScreenshot(driver, "User clicked Add Category Button");
			test.log(Status.INFO, "User clicked Add Add Category Button");
			Log.info("User clicked Add Add Category Button");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
/*	public void click_UploadFile() throws InterruptedException {
		applyWait.waitForElementToBeClickable(fileUpload, DefineConstants.explicitWait_60);
		javascriptClick.click(fileUpload);
		Thread.sleep(3000);
		driver.findElement(By.name("fimage")).sendKeys("C:\\Users\\Dell\\Desktop\\Apple.jpg");
		try {
			Screenshots.takeScreenshot(driver, "User upload file Successfully");
			test.log(Status.INFO, "User upload file Successfully");
			Log.info("User upload file Successfully");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	*/
	
	public void upload_Image(String input_ImageName)  {
		applyWait.waitForElementToBeClickable(fileUpload, DefineConstants.explicitWait_30)
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
	
	public void verify_SuccessMessageCategory(String input_ProductName){
		String text=successMessageCategory.getText();
		if (text.contains(input_ProductName)) {
			javascriptClick.highLighterMethod(successMessageCategory);
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
	
	public void searchCategory(String input_ProductName){
		applyWait.waitForElementToBeClickable(searchCategory, DefineConstants.explicitWait_60);
		searchCategory.sendKeys(input_ProductName);
			try {
				Screenshots.takeScreenshot(driver, "User search Category name as "+ input_ProductName);
				test.log(Status.INFO, "User search Category name as "+ input_ProductName);
				Log.info("User search Category name as "+ input_ProductName);
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
	
	public void click_EditCategory(String input) {
		WebElement mail=driver.findElement(By.xpath("//td[text()='"+input+"']/following-sibling::td[1]/a[1]"));
		javascriptClick.click(mail);
		try {
			Screenshots.takeScreenshot(driver, "User clicked on Edit Button");
			test.log(Status.INFO, "User clicked on Edit Button");
			Log.info("User clicked on Edit Button");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	public void click_UploadFileEdited() throws InterruptedException {
		applyWait.waitForElementToBeClickable(fileUpload, DefineConstants.explicitWait_60);
		javascriptClick.click(fileUpload);
		Thread.sleep(3000);
		driver.findElement(By.name("fimage")).sendKeys("C:\\Users\\Dell\\Desktop\\Fruits.jpg");
		try {
			Screenshots.takeScreenshot(driver, "User change upload file Successfully");
			test.log(Status.INFO, "User change upload file Successfully");
			Log.info("User upload file Successfully");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void click_UpdateCategory() {
		applyWait.waitForElementToBeClickable(updateCategory, DefineConstants.explicitWait_60);
		javascriptClick.click(updateCategory);
		try {
			Screenshots.takeScreenshot(driver, "User clicked Update Category Button");
			test.log(Status.INFO, "User clicked Update Category Button");
			Log.info("User clicked Update Category Button");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void click_RemoveCategory(String input) {
		WebElement mail=driver.findElement(By.xpath("//td[text()='"+input+"']/following-sibling::td[1]/a[2]"));
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
	public void click_DeleteCategory() {
		applyWait.waitForElementToBeClickable(DeleteCategoryAlert, DefineConstants.explicitWait_60);
		javascriptClick.click(DeleteCategoryAlert);
		try {
			Screenshots.takeScreenshot(driver, "User clicked on Delete button of alert box");
			test.log(Status.INFO, "User clicked on Delete button of alert box");
			Log.info("User clicked on Delete button of alert box");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void verifyInputValueDelete(String inputEmailAddress) {
		applyWait.waitForElementToBeClickable(productTable, DefineConstants.explicitWait_60);
		tableRows = productTable.findElements(By.tagName("tr"));

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
	
	public void click_SubCategory() {
		applyWait.waitForElementToBeClickable(subCategory, DefineConstants.explicitWait_60);
		javascriptClick.click(subCategory);
		try {
			Screenshots.takeScreenshot(driver, "User clicked Sub-Category");
			test.log(Status.INFO, "User clicked Sub-Category");
			Log.info("User clicked Sub-Category");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void click_Add_SubCategory() {
		applyWait.waitForElementToBeClickable(addSubCategory, DefineConstants.explicitWait_60);
		javascriptClick.click(addSubCategory);
		try {
			Screenshots.takeScreenshot(driver, "User clicked Add Sub-Category");
			test.log(Status.INFO, "User clicked Add Sub-Category");
			Log.info("User clicked Add Sub-Category");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void selectMainCategory(String text) {
		applyWait.waitForElementToBeClickable(selectMainCategory, DefineConstants.explicitWait_60);
		dropDown.selectByVisibleText(selectMainCategory, text);
		try {
			Screenshots.takeScreenshot(driver, "User select main-Category as "+text);
			test.log(Status.INFO, "User select main-Category as "+text);
			Log.info("User select main-Category as "+text);		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void searchSubCategory(String input_ProductName){
		applyWait.waitForElementToBeClickable(searchSubCategory, DefineConstants.explicitWait_60);
		searchSubCategory.sendKeys(input_ProductName);
			try {
				Screenshots.takeScreenshot(driver, "User search Category name as "+ input_ProductName);
				test.log(Status.INFO, "User search Category name as "+ input_ProductName);
				Log.info("User search Category name as "+ input_ProductName);
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}	
   }
	
	public void click_RemoveSubCategory(String input) {
		WebElement mail=driver.findElement(By.xpath("//td[text()='"+input+"']/following-sibling::td[1]/a[2]"));
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
	
}
	
	
