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
import helperMethods.Keyboard;
import helperMethods.Log;
import helperMethods.Screenshots;
import helperMethods.WaitTypes;

public class Products_Page {
	private WebDriver driver;
	private WaitTypes applyWait;
	private ExtentTest test;
	private JavascriptClick javascriptClick;
	private DropDown dropDown;

	public Products_Page(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.applyWait = new WaitTypes(driver);
		this.test = test;
		javascriptClick = new JavascriptClick(driver);
		dropDown=new DropDown(driver);
	}
	
	@FindBy(xpath = "//li/a[@href='http://www.kisaansquad.com/admin/products']")
	private WebElement products;
	
	@FindBy(xpath = "//a[@class='btn btn-primary btn-add']")
	private WebElement addNewProducts;
	
	@FindBy(xpath = "//input[@id='name']")
	private WebElement productNameTextbox;
	
	@FindBy(xpath = "//select[@id='maincats']")
	private WebElement mainCategory;
	
	@FindBy(xpath = "//select[@id='subs']")
	private WebElement subCategory;
	
	@FindBy(xpath = "//select[@id='select_vendor']")
	private WebElement vendor;
	
	@FindBy(xpath = "//input[@id='vendor_stores_list-selectized']")
	private WebElement vendorSuperMarket;
	
	@FindBy(xpath = "//select[@name='unit_id']")
	private WebElement vendorUnit;
	
	@FindBy(xpath = "//input[@id='uploadFile']")
	private WebElement fileUpload;
	
	@FindBy(xpath = "//label[text()='Product Description']/following-sibling::div/div[2]/div")
	private WebElement productDescription;
	
	@FindBy(xpath = "//input[@name='price']")
	private WebElement productCurrentPrice;
	
	@FindBy(xpath = "//input[@name='previous_price']")
	private WebElement productPreviousPrice;
	
	@FindBy(xpath = "//input[@name='stock']")
	private WebElement productStock;
	
	@FindBy(xpath = "//label[text()='Product Buy/Return Policy']/following-sibling::div/div[2]/div")
	private WebElement returnPolicy;
	
	@FindBy(xpath = "//i[contains(@class,'glyphicon glyphicon-ok')]")
	private WebElement addFeatureProduct;
	
	@FindBy(xpath = "//div[@class='bootstrap-tagsinput']//input[@type='text']")
	private WebElement productTags;
	
	@FindBy(xpath = "//button[normalize-space()='Add New Product']")
	private WebElement addNewProductsButton;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissable']")
	private WebElement successMessageAddProducts;
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchProducts;
	
	@FindBy(xpath = "//table[@id='example']")
	private WebElement productTable;
	
	private List<WebElement> tableRows;

	private List<WebElement> tableColums;
	
	@FindBy(xpath = "//td[normalize-space()='vzebm Apple']/following-sibling::td[4]/form/a[1]")
	private WebElement editProduct;
	
	@FindBy(xpath = "//button[normalize-space()='Update Product']")
	private WebElement updateProductsButton;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissable']")
	private WebElement successMessageRemoveProducts;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissable']")
	private WebElement successMessageDeactivateProducts;
	
	public void click_Products_Tab() {
		applyWait.waitForElementToBeClickable(products, DefineConstants.explicitWait_60);
		javascriptClick.click(products);
		try {
			Screenshots.takeScreenshot(driver, "User clicked Products tab");
			test.log(Status.INFO, "User clicked Products tab");
			Log.info("User clicked Products tab");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void click_Add_New_Products() {
		applyWait.waitForElementToBeClickable(addNewProducts, DefineConstants.explicitWait_60);
		javascriptClick.click(addNewProducts);
		try {
			Screenshots.takeScreenshot(driver, "User clicked Add New Products tab");
			test.log(Status.INFO, "User clicked Add New Products tab");
			Log.info("User clicked Add New Products");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void enter_ProductName(String input_productName) {
		applyWait.waitForElementToBeClickable(productNameTextbox, DefineConstants.explicitWait_60).clear();
		productNameTextbox.sendKeys(input_productName);
			try {
				Screenshots.takeScreenshot(driver, "User entered email address as "+ input_productName);
				test.log(Status.INFO, "User entered email address as "+ input_productName);
				Log.info("User entered email address as "+ input_productName);
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}	
   }
	
	public void select_Main_Category(String category) {
		applyWait.waitForElementToBeClickable(mainCategory, DefineConstants.explicitWait_60);
		dropDown.selectByVisibleText(mainCategory, category);
			try {
				Screenshots.takeScreenshot(driver, "User selected main category as "+ category);
				test.log(Status.INFO, "User selected main category as "+ category);
				Log.info("User selected main category as "+ category);
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}	
   }
	
	public void select_Sub_Category(String category) {
		applyWait.waitForElementToBeClickable(subCategory, DefineConstants.explicitWait_60);
		dropDown.selectByVisibleText(subCategory, category);
			try {
				Screenshots.takeScreenshot(driver, "User selected Sub category as "+ category);
				test.log(Status.INFO, "User selected Sub category as "+ category);
				Log.info("User selected Sub category as "+ category);
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}	
   }
	
	public void select_Vendor(String category) {
		applyWait.waitForElementToBeClickable(vendor, DefineConstants.explicitWait_60);
		dropDown.selectByVisibleText(vendor, category);
			try {
				Screenshots.takeScreenshot(driver, "User selected vendor as "+ category);
				test.log(Status.INFO, "User selected vendor as "+ category);
				Log.info("User selected vendor as "+ category);
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}	
   }
	
	public void select_VendorSuperMarket(String category) {
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
		dropDown.selectByVisibleText(vendorUnit, category);
			try {
				Screenshots.takeScreenshot(driver, "User selected Vendor Unit as "+ category);
				test.log(Status.INFO, "User selected Vendor Unit as "+ category);
				Log.info("User selected Vendor Unit as "+ category);
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}	
   }
	
	public void enter_ProductDescription(String input_productdescription) {
		applyWait.waitForElementToBeClickable(productDescription, DefineConstants.explicitWait_60).click();
		productDescription.clear();
		productDescription.sendKeys(input_productdescription);
			try {
				Screenshots.takeScreenshot(driver, "User entered product description as "+ input_productdescription);
				test.log(Status.INFO, "User entered product description as "+ input_productdescription);
				Log.info("User entered product description as "+ input_productdescription);
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}	
   }
	
	public void enter_ProductCurrentPrice(String input_price) {
		applyWait.waitForElementToBeClickable(productCurrentPrice, DefineConstants.explicitWait_60).clear();
		productCurrentPrice.sendKeys(input_price);
			try {
				Screenshots.takeScreenshot(driver, "User entered Product Current Price as "+ input_price);
				test.log(Status.INFO, "User entered Product Current Price as "+ input_price);
				Log.info("User entered Product Current Price as "+ input_price);
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}	
   }
	
	public void enter_ProductPreviousPrice(String input_price) {
		applyWait.waitForElementToBeClickable(productPreviousPrice, DefineConstants.explicitWait_60).clear();
		productPreviousPrice.sendKeys(input_price);
			try {
				Screenshots.takeScreenshot(driver, "User entered Product Previous Price as "+ input_price);
				test.log(Status.INFO, "User entered Product Previous Price as "+ input_price);
				Log.info("User entered Product Previous Price as "+ input_price);
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}	
   }
	
	public void enter_ProductStock(String stock) {
		applyWait.waitForElementToBeClickable(productStock, DefineConstants.explicitWait_60).clear();
		productStock.sendKeys(stock);
			try {
				Screenshots.takeScreenshot(driver, "User entered Product Stocke as "+ stock);
				test.log(Status.INFO, "User entered Product Stocke as "+ stock);
				Log.info("User entered Product Stocke as "+ stock);
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}	
   }
	
	public void enter_ReturnPolicy(String policy) {
		applyWait.waitForElementToBeClickable(returnPolicy, DefineConstants.explicitWait_60).clear();
		returnPolicy.sendKeys(policy);
			try {
				Screenshots.takeScreenshot(driver, "User entered Return Policy as "+ policy);
				test.log(Status.INFO, "User entered Return Policy as "+ policy);
				Log.info("User entered Return Policy as "+ policy);
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}	
   }
	
	public void click_Add_Feature_Products() {
		applyWait.waitForElementToBeClickable(addFeatureProduct, DefineConstants.explicitWait_60);
		javascriptClick.click(addFeatureProduct);
		try {
			Screenshots.takeScreenshot(driver, "User clicked Add to Feature Products");
			test.log(Status.INFO, "User clicked Add to Feature Products");
			Log.info("User clicked Add to Feature Products");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void enter_ProductTags(String input_Tags) {
		applyWait.waitForElementToBeClickable(productTags, DefineConstants.explicitWait_60);
		productTags.sendKeys(input_Tags);
			try {
				Screenshots.takeScreenshot(driver, "User entered Product tags as "+ input_Tags);
				test.log(Status.INFO, "User entered Product tags as "+ input_Tags);
				Log.info("User entered Product tags as "+ input_Tags);
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}	
   }
	
	public void click_Add_New_Products_Button() {
		applyWait.waitForElementToBeClickable(addNewProductsButton, DefineConstants.explicitWait_60);
		javascriptClick.click(addNewProductsButton);
		try {
			Screenshots.takeScreenshot(driver, "User clicked Add New Products Button");
			test.log(Status.INFO, "User clicked Add New Products Button");
			Log.info("User clicked Add New Products Button");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
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
	
	public void verify_SuccessMessage(String input_ProductName){
		String text=successMessageAddProducts.getText();
		System.out.println(text);
		if (text.contains(input_ProductName)) {
			javascriptClick.highLighterMethod(successMessageAddProducts);
			System.out.println(input_ProductName + " is new product added");
			try {
				Screenshots.takeScreenshot(driver, input_ProductName + " is new product added");
			} catch (IOException e) {
				e.printStackTrace();
			}
			test.log(Status.INFO, input_ProductName + " is new product added");
			Log.info(input_ProductName + " is new product added");
			driver.navigate().refresh();
		}
	}
	
	public void searchProduct(String input_ProductName){
		applyWait.waitForElementToBeClickable(searchProducts, DefineConstants.explicitWait_60);
		searchProducts.sendKeys(input_ProductName);
			try {
				Screenshots.takeScreenshot(driver, "User search product name as "+ input_ProductName);
				test.log(Status.INFO, "User search product name as "+ input_ProductName);
				Log.info("User search product name as "+ input_ProductName);
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
	
	public void click_Edit_Products(String inputProduct) {
		WebElement edit=driver.findElement(By.xpath("//td[normalize-space()='"+inputProduct+"']/following-sibling::td[6]/form/a[1]"));
		javascriptClick.click(edit);
		try {
			Screenshots.takeScreenshot(driver, "User clicked on Edit Products");
			test.log(Status.INFO, "User clicked on Edit Products");
			Log.info("User clicked on Edit Products");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	public void click_Update_Products_Button() {
		applyWait.waitForElementToBeClickable(updateProductsButton, DefineConstants.explicitWait_60);
		javascriptClick.click(updateProductsButton);
		try {
			Screenshots.takeScreenshot(driver, "User clicked Add New Products Button");
			test.log(Status.INFO, "User clicked Add New Products Button");
			Log.info("User clicked Add New Products Button");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	public void click_Remove_Products(String inputProduct) {
		WebElement remove=driver.findElement(By.xpath("//td[normalize-space()='"+inputProduct+"']/following-sibling::td[6]/form/button"));
		javascriptClick.click(remove);
		try {
			Screenshots.takeScreenshot(driver, "User clicked on Remove Products");
			test.log(Status.INFO, "User clicked on Remove Products");
			Log.info("User clicked on Remove Products");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void verify_SuccessMessage1(String input_ProductName){
		String text=successMessageRemoveProducts.getText();
		if (text.contains(input_ProductName)) {
			javascriptClick.highLighterMethod(successMessageRemoveProducts);
			System.out.println(input_ProductName + " is verified");
			try {
				Screenshots.takeScreenshot(driver, input_ProductName + " is verified");
			} catch (IOException e) {
				e.printStackTrace();
			}
			test.log(Status.INFO, input_ProductName + " is verified");
			Log.info(input_ProductName + " is verified");
			driver.navigate().refresh();
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
	
	public void click_Deactivate_Products(String inputProduct) {
		WebElement deactive=driver.findElement(By.xpath("//td[normalize-space()='"+inputProduct+"']/following-sibling::td[6]/form/a[2]"));
		javascriptClick.click(deactive);
		try {
			Screenshots.takeScreenshot(driver, "User clicked on Deactive Products");
			test.log(Status.INFO, "User clicked on Deactive Products");
			Log.info("User clicked on Deactive Products");		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void verify_SuccessMessageDeactivate(String input_ProductName){
		String text=successMessageDeactivateProducts.getText();
		if (text.contains(input_ProductName)) {
			javascriptClick.highLighterMethod(successMessageDeactivateProducts);
			System.out.println(input_ProductName + " is verified");
			try {
				Screenshots.takeScreenshot(driver, input_ProductName + " is verified");
			} catch (IOException e) {
				e.printStackTrace();
			}
			test.log(Status.INFO, input_ProductName + " is verified");
			Log.info(input_ProductName + " is verified");
			driver.navigate().refresh();
		}
	}

}
