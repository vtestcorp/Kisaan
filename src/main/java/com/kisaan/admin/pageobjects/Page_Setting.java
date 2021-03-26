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
import helperMethods.ScrollTypes;
import helperMethods.WaitTypes;

public class Page_Setting {

	private WebDriver driver;
	private WaitTypes applyWait;
	private ExtentTest test;
	private JavascriptClick javascriptClick;
	private DropDown dropDown;
	private ScrollTypes scroll;

	public Page_Setting(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.applyWait = new WaitTypes(driver);
		this.test = test;
		javascriptClick = new JavascriptClick(driver);
		dropDown = new DropDown(driver);
		scroll = new ScrollTypes(driver);
	}

	@FindBy(xpath = "//a[@href='http://www.kisaansquad.com/admin/pagesettings']")
	private WebElement pageSettingTab;

	@FindBy(xpath = "//a[normalize-space()='Add New FAQ']")
	private WebElement addNewFAQ;

	@FindBy(xpath = "//input[@name='question']")
	private WebElement questionTextbox;

	@FindBy(xpath = "//label[text()='Answer']/following-sibling::div/div[2]/div")
	private WebElement answerTextbox;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement addFAQButton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissable']")
	private WebElement SuccessMessage;

	@FindBy(xpath = "//input[@type='search']")
	private WebElement search;

	@FindBy(xpath = "//tbody/tr[3]/td[2]/a[1]")
	private WebElement removeLogo;

	@FindBy(xpath = "//table[@id='example']")
	private WebElement table;

	private List<WebElement> tableRows;

	private List<WebElement> tableColums;

	@FindBy(xpath = "//a[normalize-space()='Brand Logos']")
	private WebElement brandLogo;

	@FindBy(xpath = "//a[normalize-space()='Add New Logo']")
	private WebElement addNewLogo;

	@FindBy(xpath = "//input[@name='blogo']")
	private WebElement uploadlogo;

	@FindBy(xpath = "/html/body/div/div/div/div/div[2]/div/div[3]/div/div[4]/table/tbody/tr[3]")
	private WebElement verifyLogo;

	@FindBy(xpath = "//a[normalize-space()='Home Banners']")
	private WebElement homeBanner;

	@FindBy(xpath = "//a[normalize-space()='Add New Banner']")
	private WebElement addHomeBanner;

	@FindBy(xpath = "//input[@name='link']")
	private WebElement bannerLink;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement addBannerButton;

	@FindBy(xpath = "/html/body/div/div/div/div/div[2]/div/div[3]/div/div[5]/table")
	private WebElement tableLogo;

	@FindBy(xpath = "//a[normalize-space()='Large Home Banners']")
	private WebElement largeHomeBanner;

	@FindBy(xpath = "//input[@name='banner_link']")
	private WebElement largeBannerLink;

	@FindBy(xpath = "//form[@action='banner/large']//button[@type='submit']")
	private WebElement updateLargeBanner;

	@FindBy(xpath = "//input[@name='large_banner']")
	private WebElement uploadlarge;

	@FindBy(xpath = "//a[normalize-space()='About Us Page']")
	private WebElement aboutUs;

	@FindBy(xpath = "//button[@id='about_page_update']")
	private WebElement updateAboutUsPage;

	@FindBy(xpath = "//a[normalize-space()='Contact Us Page']")
	private WebElement contactUsPage;
	
	@FindBy(xpath = "//button[normalize-space()='Apply']")
	private WebElement apply;

	@FindBy(xpath = "//textarea[@name='contact']")
	private WebElement contactText;

	@FindBy(xpath = "//textarea[@name='contact_email']")
	private WebElement contactEmail;

	@FindBy(xpath = "//button[text()='Update Contact Page']")
	private WebElement updateContactPageButton;

	public void click_Page_Setting_Tab() {
		applyWait.waitForElementToBeClickable(pageSettingTab, DefineConstants.explicitWait_60);
		pageSettingTab.click();
		try {
			Screenshots.takeScreenshot(driver, "User clicked Page Setting tab");
			test.log(Status.INFO, "User clicked Page Setting tab");
			Log.info("User clicked Page Setting tab");
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void enableDisableButtonFAQ(String input) {
		WebElement s = driver.findElement(By.xpath("//div[@class='col-md-2 col-sm-3 col-xs-6']//div[@data-toggle='toggle']"));
		if (input.equalsIgnoreCase("Yes")) {
			if (!s.getAttribute("class").contains("off")) 
				System.out.println("About Us button is Enabled");
			 else 
				s.click();
			
		}
		if (input.equalsIgnoreCase("No")) {
			if (s.getAttribute("class").contains("off"))
				System.out.println("About Us button is Disabled");
			else
				s.click();
		}
	}
	
	public void click_Apply() {
		applyWait.waitForElementToBeClickable(apply, DefineConstants.explicitWait_60);
		apply.click();
		try {
			Screenshots.takeScreenshot(driver, "User clicked Apply button");
			test.log(Status.INFO, "User clicked Apply button");
			Log.info("User clicked Apply button");
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void click_Add_NewFAQ() {
		applyWait.waitForElementToBeClickable(addNewFAQ, DefineConstants.explicitWait_60);
		javascriptClick.click(addNewFAQ);
		try {
			Screenshots.takeScreenshot(driver, "User clicked add new FAQ");
			test.log(Status.INFO, "User clicked add new FAQ");
			Log.info("User clicked add new FAQ");
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enter_QuestionFAQ(String input) {
		applyWait.waitForElementToBeClickable(questionTextbox, DefineConstants.explicitWait_60).clear();
		questionTextbox.sendKeys(input);
		try {
			Screenshots.takeScreenshot(driver, "User enter Question FAQ as: " + input);
			test.log(Status.INFO, "User enter Question FAQ as: " + input);
			Log.info("User enter Question FAQ as: " + input);
			Thread.sleep(3000);
		} catch (Exception e) {
		}
	}

	public void enter_AnswerFAQ(String input) {
		applyWait.waitForElementToBeClickable(answerTextbox, DefineConstants.explicitWait_60).click();
		answerTextbox.clear();
		answerTextbox.sendKeys(input);
		try {
			Screenshots.takeScreenshot(driver, "User enter Answer FAQ as: " + input);
			test.log(Status.INFO, "User enter Answer FAQ as: " + input);
			Log.info("User enter Answer FAQ as: " + input);
			Thread.sleep(3000);
		} catch (Exception e) {
		}
	}

	public void click_Add_NewFAQButton() {
		applyWait.waitForElementToBeClickable(addFAQButton, DefineConstants.explicitWait_60);
		javascriptClick.click(addFAQButton);
		try {
			Screenshots.takeScreenshot(driver, "User clicked Add FAQ Button");
			test.log(Status.INFO, "User clicked Add FAQ Button");
			Log.info("User clicked Add FAQ Button");
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public WebElement page_Setting() {
		WebElement s = driver.findElement(By.xpath("//a[normalize-space()='Page Settings']"));
		return s;
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
			driver.navigate().refresh();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void searchFAQName(String input_ProductName) {
		applyWait.waitForElementToBeClickable(search, DefineConstants.explicitWait_60);
		search.sendKeys(input_ProductName);
		try {
			Screenshots.takeScreenshot(driver, "User search FAQ name as " + input_ProductName);
			test.log(Status.INFO, "User search FAQ name as " + input_ProductName);
			Log.info("User search client FAQ name as " + input_ProductName);
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
				} else if (cellText.equals("No matching records found")) {
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

	public void click_EditFAQ(String inputProduct) {
		WebElement slider = driver
				.findElement(By.xpath("//td[normalize-space()='" + inputProduct + "']/following-sibling::td[2]/a[1]"));
		javascriptClick.click(slider);
		try {
			Screenshots.takeScreenshot(driver, "User clicked on edit FAQ");
			test.log(Status.INFO, "User clicked on edit FAQ");
			Log.info("User clicked on edit FAQ");
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void click_RemoveFAQ(String inputProduct) {
		WebElement slider = driver
				.findElement(By.xpath("//td[normalize-space()='" + inputProduct + "']/following-sibling::td[2]/a[2]"));
		javascriptClick.click(slider);
		try {
			Screenshots.takeScreenshot(driver, "User clicked on delete FAQ");
			test.log(Status.INFO, "User clicked on delete FAQ");
			Log.info("User clicked on delete FAQ");
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
				} else if (cellText.equals("No matching records found")) {
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

	public void click_BrandLogos() {
		applyWait.waitForElementToBeClickable(brandLogo, DefineConstants.explicitWait_60);
		javascriptClick.click(brandLogo);
		try {
			Screenshots.takeScreenshot(driver, "User clicked on Brand Logos");
			test.log(Status.INFO, "User clicked on Brand Logos");
			Log.info("User clicked on Brand Logos");
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void click_AddNewLogos() {
		applyWait.waitForElementToBeClickable(addNewLogo, DefineConstants.explicitWait_60);
		javascriptClick.click(addNewLogo);
		try {
			Screenshots.takeScreenshot(driver, "User clicked on add new Logos");
			test.log(Status.INFO, "User clicked on add new Logos");
			Log.info("User clicked on add new Logos");
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void upload_Image(String input_ImageName) {
		applyWait.waitForElementToBeClickable(uploadlogo, DefineConstants.explicitWait_30)
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

	public void click_AddBrandLogosButton() {
		applyWait.waitForElementToBeClickable(addFAQButton, DefineConstants.explicitWait_60);
		javascriptClick.click(addFAQButton);
		try {
			Screenshots.takeScreenshot(driver, "User clicked on Add Brand Logos Button");
			test.log(Status.INFO, "User clicked on Add Brand Logos Button");
			Log.info("User clicked on Add Brand Logos Button");
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verify_Logo() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		javascriptClick.highLighterMethod(verifyLogo);
		System.out.println("Logo is verified");
		try {
			Screenshots.takeScreenshot(driver, "Logo is verified");
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.log(Status.INFO, "Logo is verified");
		Log.info("Logo is verified");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void click_RemoveLogo() {
		applyWait.waitForElementToBeClickable(removeLogo, DefineConstants.explicitWait_60);
		javascriptClick.highLighterMethod(removeLogo);
		javascriptClick.click(removeLogo);
		try {
			Screenshots.takeScreenshot(driver, "User clicked on Remove Brand Logos Button");
			test.log(Status.INFO, "User clicked on Remove Brand Logos Button");
			Log.info("User clicked on Remove Brand Logos Button");
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void click_HomeBanner() {
		applyWait.waitForElementToBeClickable(homeBanner, DefineConstants.explicitWait_60);
		javascriptClick.click(homeBanner);
		try {
			Screenshots.takeScreenshot(driver, "User clicked on Home Banners");
			test.log(Status.INFO, "User clicked on Home Banners");
			Log.info("User clicked on Home Banners");
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void click_AddHomeBanner() {
		applyWait.waitForElementToBeClickable(addHomeBanner, DefineConstants.explicitWait_60);
		javascriptClick.click(addHomeBanner);
		try {
			Screenshots.takeScreenshot(driver, "User clicked on Add Home Banners");
			test.log(Status.INFO, "User clicked on add Home Banners");
			Log.info("User clicked on add Home Banners");
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enter_BannerLink(String input) {
		applyWait.waitForElementToBeClickable(bannerLink, DefineConstants.explicitWait_60).clear();
		bannerLink.sendKeys(input);
		try {
			Screenshots.takeScreenshot(driver, "User enter Banner Link as: " + input);
			test.log(Status.INFO, "User enter Banner Link as: " + input);
			Log.info("User enter Banner Link as: " + input);
			Thread.sleep(3000);
		} catch (Exception e) {
		}
	}

	public void click_AddBannerButton() {
		applyWait.waitForElementToBeClickable(addBannerButton, DefineConstants.explicitWait_60);
		javascriptClick.click(addBannerButton);
		try {
			Screenshots.takeScreenshot(driver, "User clicked on Add Banners Button");
			test.log(Status.INFO, "User clicked on Add Banners Button");
			Log.info("User clicked on Add Banners Button");
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyInputValueNew(String inputEmailAddress) {
		applyWait.waitForElementToBeClickable(tableLogo, DefineConstants.explicitWait_60);
		tableRows = tableLogo.findElements(By.tagName("tr"));

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
				} else if (cellText.equals("No matching records found")) {
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

	public void click_EditHomeBanner(String input) {
		WebElement s = driver.findElement(By.xpath("//td[text()='" + input + "']/following-sibling::td[1]/a[1]"));
		javascriptClick.click(s);
		try {
			Screenshots.takeScreenshot(driver, "User clicked on edit Home Banners");
			test.log(Status.INFO, "User clicked on edit Home Banners");
			Log.info("User clicked on edit Home Banners");
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void click_RemoveHomeBanner(String input) {
		WebElement s = driver.findElement(By.xpath("//td[text()='" + input + "']/following-sibling::td[1]/a[2]"));
		javascriptClick.click(s);
		try {
			Screenshots.takeScreenshot(driver, "User clicked on delete Home Banners");
			test.log(Status.INFO, "User clicked on delete Home Banners");
			Log.info("User clicked on delete Home Banners");
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void click_LargeHomeBanner() {
		applyWait.waitForElementToBeClickable(largeHomeBanner, DefineConstants.explicitWait_60);
		javascriptClick.click(largeHomeBanner);
		try {
			Screenshots.takeScreenshot(driver, "User clicked on Large Home Banner");
			test.log(Status.INFO, "User clicked on Large Home Banner");
			Log.info("User clicked on Large Home Banner");
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enter_LargeBannerLink(String input) {
		applyWait.waitForElementToBeClickable(largeBannerLink, DefineConstants.explicitWait_60).clear();
		largeBannerLink.sendKeys(input);
		try {
			Screenshots.takeScreenshot(driver, "User enter Banner Link as: " + input);
			test.log(Status.INFO, "User enter Banner Link as: " + input);
			Log.info("User enter Banner Link as: " + input);
			Thread.sleep(3000);
		} catch (Exception e) {
		}
	}

	public void click_UpdateLargeBannerButton() {
		applyWait.waitForElementToBeClickable(updateLargeBanner, DefineConstants.explicitWait_60);
		javascriptClick.click(updateLargeBanner);
		try {
			Screenshots.takeScreenshot(driver, "User clicked on update Large Banner button");
			test.log(Status.INFO, "User clicked on update Large Banner button");
			Log.info("User clicked on update Large Banner button");
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void upload_ImageLargeBanner(String input_ImageName) {
		applyWait.waitForElementToBeClickable(uploadlarge, DefineConstants.explicitWait_30)
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

	public void click_AboutUsPage() {
		applyWait.waitForElementToBeClickable(aboutUs, DefineConstants.explicitWait_60);
		javascriptClick.click(aboutUs);
		try {
			Screenshots.takeScreenshot(driver, "User clicked on About Us Page");
			test.log(Status.INFO, "User clicked on About Us Page");
			Log.info("User clicked on About Us Page");
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enableDisableButton(String input) {
		WebElement s = driver.findElement(By.xpath("//form[@action='http://www.kisaansquad.com/admin/pagesettings/about']//div[@data-toggle='toggle']"));
		if (input.equalsIgnoreCase("Yes")) {
			if (!s.getAttribute("class").contains("off")) 
				System.out.println("About Us button is Enabled");
			 else 
				s.click();
			
		}
		if (input.equalsIgnoreCase("No")) {
			if (s.getAttribute("class").contains("off"))
				System.out.println("About Us button is Disabled");
			else
				s.click();
		}
	}

	public void click_UpdateAboutUsPage() {
		applyWait.waitForElementToBeClickable(updateAboutUsPage, DefineConstants.explicitWait_60);
		javascriptClick.click(updateAboutUsPage);
		try {
			Screenshots.takeScreenshot(driver, "User clicked on update About Us Page");
			test.log(Status.INFO, "User clicked on update About Us Page");
			Log.info("User clicked on update About Us Page");
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void click_ContactUsPage() {
		applyWait.waitForElementToBeClickable(contactUsPage, DefineConstants.explicitWait_60);
		javascriptClick.click(contactUsPage);
		try {
			Screenshots.takeScreenshot(driver, "User clicked on Contact Us Page");
			test.log(Status.INFO, "User clicked on Contact Us Page");
			Log.info("User clicked on Contact Us Page");
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enableDisableButtonContactUs(String input) {
		WebElement s = driver.findElement(By.xpath("//form[@action='http://www.kisaansquad.com/admin/pagesettings/contact']//div[@data-toggle='toggle']"));
		if (input.equalsIgnoreCase("Yes")) {
			if (!s.getAttribute("class").contains("off")) 
				System.out.println("About Us button is Enabled");
			 else 
				s.click();	
		}
		if (input.equalsIgnoreCase("No")) {
			if (s.getAttribute("class").contains("off"))
				System.out.println("About Us button is Disabled");
			else
				s.click();
		}
	}

	public void enter_ContactText(String input) {
		applyWait.waitForElementToBeClickable(contactText, DefineConstants.explicitWait_60).clear();
		contactText.sendKeys(input);
		try {
			Screenshots.takeScreenshot(driver, "User enter Contact text as: " + input);
			test.log(Status.INFO, "User enter Contact text as: " + input);
			Log.info("User enter Contact text as: " + input);
			Thread.sleep(3000);
		} catch (Exception e) {
		}
	}

	public void enter_ContactEmail(String input) {
		applyWait.waitForElementToBeClickable(contactEmail, DefineConstants.explicitWait_60).clear();
		contactEmail.sendKeys(input);
		try {
			Screenshots.takeScreenshot(driver, "User enter Contact Email as: " + input);
			test.log(Status.INFO, "User enter Contact Email as: " + input);
			Log.info("User enter Contact Email as: " + input);
			Thread.sleep(3000);
		} catch (Exception e) {
		}
	}

	public void click_UpdateContactUsPage() {
		applyWait.waitForElementToBeClickable(updateContactPageButton, DefineConstants.explicitWait_60);
		javascriptClick.click(updateContactPageButton);
		try {
			Screenshots.takeScreenshot(driver, "User clicked on Update Contact Us Page");
			test.log(Status.INFO, "User clicked on Update Contact Us Page");
			Log.info("User clicked on Update Contact Us Page");
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
