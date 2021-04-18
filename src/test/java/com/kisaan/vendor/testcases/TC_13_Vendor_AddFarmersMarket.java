package com.kisaan.vendor.testcases;

import java.util.Random;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kisaan.admin.pageobjects.Farmers_Market;
import com.kisaan.admin.pageobjects.Profile_Page;
import com.kisaan.customer.pageobjects.HomePage;
import com.kisaan.customer.pageobjects.SignIn_Page;
import com.kisaan.vendor.pageobjects.Farmers_Market_Page;
import com.kisaan.vendor.pageobjects.MyWithdraws_Page;
import com.kisaan.vendor.pageobjects.VendorDashboard_Page;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;

public class TC_13_Vendor_AddFarmersMarket extends BaseClass{
	
	HomePage homePage;
	SignIn_Page signIn_Page;
	Farmers_Market_Page farmer_Market_Page;
	Farmers_Market farmer_Market;
	Profile_Page profile_page;
	
	@BeforeMethod
	public static void randomStringGenerate() {
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 5;
		Random random = new Random();
		
		String generatedString = random.ints(leftLimit, rightLimit + 1).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, 
				StringBuilder::append).toString();   //String Generate
		
		System.out.println(generatedString);
		JsonUtils.setData("Market Name", generatedString, DefineConstants.TC_61_Admin_FarmersMarket_AddMarket);
		JsonUtils.setData("Market Email", generatedString+"@gmail.com", DefineConstants.TC_61_Admin_FarmersMarket_AddMarket);
	}

	@Test(enabled = true)
	public void vendor_AddSuperMarket() throws Exception {

		test = extent.createTest("TC_13_Vendor_AddFarmersMarket", "Vendor should be able to add new Super Market");

		homePage = new HomePage(driver, test);
		signIn_Page = new SignIn_Page(driver, test); 
		farmer_Market_Page = new Farmers_Market_Page(driver, test);
		profile_page=new Profile_Page(driver, test);
		farmer_Market=new Farmers_Market(driver, test);
		
		driver.get(DefineConstants.KISAAN_Admin_URL);
		profile_page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_61_Admin_FarmersMarket_AddMarket, "Admin Email Id"));	
		profile_page.enter_Password(JsonUtils.getData(DefineConstants.TC_61_Admin_FarmersMarket_AddMarket, "Admin Password"));
		profile_page.click_LogIN_Button();
		
		farmer_Market.click_FarmersMarket_Tab();
		farmer_Market.click_AddNewFarmersMarket_Tab();
		farmer_Market.enterMarketName(JsonUtils.getData(DefineConstants.TC_61_Admin_FarmersMarket_AddMarket, "Market Name"));
		farmer_Market.enterMarketPhone(JsonUtils.getData(DefineConstants.TC_61_Admin_FarmersMarket_AddMarket, "Market Phone"));
		farmer_Market.enterMarketEmail(JsonUtils.getData(DefineConstants.TC_61_Admin_FarmersMarket_AddMarket, "Market Email"));
		farmer_Market.enterMarketServiceArea(JsonUtils.getData(DefineConstants.TC_61_Admin_FarmersMarket_AddMarket, "Service Area"));
		farmer_Market.upload_Image(JsonUtils.getData(DefineConstants.TC_61_Admin_FarmersMarket_AddMarket, "Shop Image"));
		farmer_Market.enterMarketAddress(JsonUtils.getData(DefineConstants.TC_61_Admin_FarmersMarket_AddMarket, "Market Address"));
		farmer_Market.enterMarketCity(JsonUtils.getData(DefineConstants.TC_61_Admin_FarmersMarket_AddMarket, "Market City"));
		farmer_Market.enterMarketZipCode(JsonUtils.getData(DefineConstants.TC_61_Admin_FarmersMarket_AddMarket, "Market Zip"));
		farmer_Market.enterPickupAddress(JsonUtils.getData(DefineConstants.TC_61_Admin_FarmersMarket_AddMarket, "Pickup Address"));
		farmer_Market.enterPickupCity(JsonUtils.getData(DefineConstants.TC_61_Admin_FarmersMarket_AddMarket, "Pickup City"));
		farmer_Market.enterPickupZipCode(JsonUtils.getData(DefineConstants.TC_61_Admin_FarmersMarket_AddMarket, "Pickup Zip"));
		farmer_Market.click_AddMarketBtn();
		
		driver.get(DefineConstants.KISAAN_URL);
		homePage.click_Vendor_Link();
		signIn_Page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_13_Vendor_AddFarmersMarket, "Email Address"));	
		signIn_Page.enter_Password(JsonUtils.getData(DefineConstants.TC_13_Vendor_AddFarmersMarket, "Password"));
		signIn_Page.click_LogIN_Button();
		
		farmer_Market_Page.click_FarmersMarket_Tab();
		farmer_Market_Page.click_AddFarmersMarket();
		farmer_Market_Page.enterMarketName(JsonUtils.getData(DefineConstants.TC_61_Admin_FarmersMarket_AddMarket, "Market Name"));
		farmer_Market_Page.click_Submit();
		farmer_Market_Page.verify_SuccessMessage(JsonUtils.getData(DefineConstants.TC_13_Vendor_AddFarmersMarket, "Success Message"));
		farmer_Market_Page.search_MarketName(JsonUtils.getData(DefineConstants.TC_61_Admin_FarmersMarket_AddMarket, "Market Name"));
		farmer_Market_Page.verifyInputValue(JsonUtils.getData(DefineConstants.TC_61_Admin_FarmersMarket_AddMarket, "Market Name"));
	
		farmer_Market_Page.click_ViewDetails(JsonUtils.getData(DefineConstants.TC_61_Admin_FarmersMarket_AddMarket, "Market Name"));
		farmer_Market_Page.verifyInputValueInfo(JsonUtils.getData(DefineConstants.TC_61_Admin_FarmersMarket_AddMarket, "Market Name"));
		farmer_Market_Page.verifyInputValueInfo(JsonUtils.getData(DefineConstants.TC_61_Admin_FarmersMarket_AddMarket, "Market Phone"));
		farmer_Market_Page.verifyInputValueInfo(JsonUtils.getData(DefineConstants.TC_61_Admin_FarmersMarket_AddMarket, "Market Email"));
	}

}
