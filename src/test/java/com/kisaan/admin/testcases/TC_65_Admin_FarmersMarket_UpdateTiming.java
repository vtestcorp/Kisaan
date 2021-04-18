package com.kisaan.admin.testcases;

import java.util.Random;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kisaan.admin.pageobjects.Farmers_Market;
import com.kisaan.admin.pageobjects.Manage_Unit_Page;
import com.kisaan.admin.pageobjects.Profile_Page;
import com.kisaan.customer.pageobjects.Dashboard_Page;
import com.kisaan.customer.pageobjects.HomePage;
import com.kisaan.customer.pageobjects.SignIn_Page;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;

public class TC_65_Admin_FarmersMarket_UpdateTiming extends BaseClass{
	
	HomePage homePage;
	SignIn_Page signIn_Page;
	Dashboard_Page  dashboard_Page;
	Farmers_Market farmer_Market;
	Profile_Page profile_page;
	Manage_Unit_Page manage_Unit;
	
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
		JsonUtils.setData("Market Name", generatedString, DefineConstants.TC_65_Admin_FarmersMarket_UpdateTiming);
		JsonUtils.setData("Market Email", generatedString+"@gmail.com", DefineConstants.TC_65_Admin_FarmersMarket_UpdateTiming);
		
	}

	@Test(enabled = true)
	public void admin_FarmersMarket_DeactiveMarket() throws Exception {

		test = extent.createTest("TC_65_Admin_FarmersMarket_UpdateTiming", "Admin should be able to update market timing");

		homePage = new HomePage(driver, test);
		signIn_Page = new SignIn_Page(driver, test); 
		dashboard_Page = new Dashboard_Page(driver, test);
		profile_page=new Profile_Page(driver, test);
		farmer_Market=new Farmers_Market(driver, test);
				
		driver.get(DefineConstants.KISAAN_Admin_URL);
		profile_page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_65_Admin_FarmersMarket_UpdateTiming, "Admin Email Id"));	
		profile_page.enter_Password(JsonUtils.getData(DefineConstants.TC_65_Admin_FarmersMarket_UpdateTiming, "Admin Password"));
		profile_page.click_LogIN_Button();
		
		farmer_Market.click_FarmersMarket_Tab();
		farmer_Market.click_AddNewFarmersMarket_Tab();
		farmer_Market.enterMarketName(JsonUtils.getData(DefineConstants.TC_65_Admin_FarmersMarket_UpdateTiming, "Market Name"));
		farmer_Market.enterMarketPhone(JsonUtils.getData(DefineConstants.TC_65_Admin_FarmersMarket_UpdateTiming, "Market Phone"));
		farmer_Market.enterMarketEmail(JsonUtils.getData(DefineConstants.TC_65_Admin_FarmersMarket_UpdateTiming, "Market Email"));
		farmer_Market.enterMarketServiceArea(JsonUtils.getData(DefineConstants.TC_65_Admin_FarmersMarket_UpdateTiming, "Service Area"));
		farmer_Market.upload_Image(JsonUtils.getData(DefineConstants.TC_65_Admin_FarmersMarket_UpdateTiming, "Shop Image"));
		farmer_Market.enterMarketAddress(JsonUtils.getData(DefineConstants.TC_65_Admin_FarmersMarket_UpdateTiming, "Market Address"));
		farmer_Market.enterMarketCity(JsonUtils.getData(DefineConstants.TC_65_Admin_FarmersMarket_UpdateTiming, "Market City"));
		farmer_Market.enterMarketZipCode(JsonUtils.getData(DefineConstants.TC_65_Admin_FarmersMarket_UpdateTiming, "Market Zip"));
		farmer_Market.enterPickupAddress(JsonUtils.getData(DefineConstants.TC_65_Admin_FarmersMarket_UpdateTiming, "Pickup Address"));
		farmer_Market.enterPickupCity(JsonUtils.getData(DefineConstants.TC_65_Admin_FarmersMarket_UpdateTiming, "Pickup Zip"));
		farmer_Market.click_AddMarketBtn();
		farmer_Market.verify_SuccessMessageSendEmail(JsonUtils.getData(DefineConstants.TC_65_Admin_FarmersMarket_UpdateTiming, "Success Message"));
		farmer_Market.search_MarketName(JsonUtils.getData(DefineConstants.TC_65_Admin_FarmersMarket_UpdateTiming, "Market Name"));
		farmer_Market.verifyInputValue(JsonUtils.getData(DefineConstants.TC_65_Admin_FarmersMarket_UpdateTiming, "Market Name"));

		farmer_Market.click_UpdateTiming(JsonUtils.getData(DefineConstants.TC_65_Admin_FarmersMarket_UpdateTiming, "Market Name"));
		
		
		
		
	}
}
