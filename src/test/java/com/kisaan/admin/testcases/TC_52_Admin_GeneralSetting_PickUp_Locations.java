package com.kisaan.admin.testcases;

import java.awt.AWTException;
import java.util.Random;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kisaan.admin.pageobjects.General_Setting_Page;
import com.kisaan.admin.pageobjects.Page_Setting;
import com.kisaan.admin.pageobjects.Profile_Page;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;
import helperMethods.ScrollTypes;

public class TC_52_Admin_GeneralSetting_PickUp_Locations extends BaseClass {

	Page_Setting page_Setting;
	Profile_Page profile_page;
	ScrollTypes scroll;
	General_Setting_Page general_Page;

	@BeforeMethod
	public static void randomStringGenerate() {
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 5;
		Random random = new Random();

		String generatedString = random.ints(leftLimit, rightLimit + 1).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
		System.out.println(generatedString);
		JsonUtils.setData("Pickup Address", generatedString + " Address",DefineConstants.TC_52_Admin_GeneralSetting_PickUp_Locations);
	}

	@Test(enabled = true)
	public void admin_GeneralSetting_Pickup_Location() throws AWTException {

		test = extent.createTest("TC_52_Admin_GeneralSetting_PickUp_Locations","Admin should be able to add Pickup Location");

		profile_page = new Profile_Page(driver, test);
		page_Setting = new Page_Setting(driver, test);
		scroll = new ScrollTypes(driver);
		general_Page = new General_Setting_Page(driver, test);

		driver.get(DefineConstants.KISAAN_Admin_URL);
		profile_page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_52_Admin_GeneralSetting_PickUp_Locations, "Admin Email Id"));
		profile_page.enter_Password(JsonUtils.getData(DefineConstants.TC_52_Admin_GeneralSetting_PickUp_Locations, "Admin Password"));
		profile_page.click_LogIN_Button();

		//Create
		scroll.scrollInToView(page_Setting.page_Setting());
		general_Page.click_GeneralSettingPage();
		general_Page.click_PickUpLocations();
		general_Page.enter_PickUpAddress(JsonUtils.getData(DefineConstants.TC_52_Admin_GeneralSetting_PickUp_Locations, "Pickup Address"));
		general_Page.click_AddLocationsButton();
		general_Page.verify_SuccessMessage(JsonUtils.getData(DefineConstants.TC_52_Admin_GeneralSetting_PickUp_Locations, "Success Message"));
		general_Page.click_PickUpLocations();
		general_Page.verifyInputValue(JsonUtils.getData(DefineConstants.TC_52_Admin_GeneralSetting_PickUp_Locations, "Pickup Address"));
		
		//Delete
		general_Page.click_Remove_PickUpLocation(JsonUtils.getData(DefineConstants.TC_52_Admin_GeneralSetting_PickUp_Locations, "Pickup Address"));
		general_Page.verify_SuccessMessage(JsonUtils.getData(DefineConstants.TC_52_Admin_GeneralSetting_PickUp_Locations, "Success Message Delete"));
	}

}
