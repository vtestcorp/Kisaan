package com.kisaan.admin.testcases;

import java.awt.AWTException;
import java.util.Random;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kisaan.admin.pageobjects.Page_Setting;
import com.kisaan.admin.pageobjects.Profile_Page;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;
import helperMethods.ScrollTypes;

public class TC_35_Admin_PageSetting_Add_Remove_Logo extends BaseClass{
	
	Page_Setting page_Setting;
	Profile_Page profile_page;
	ScrollTypes scroll;

	@BeforeMethod
	public static void randomStringGenerate() {
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 5;
		Random random = new Random();

		String generatedString = random.ints(leftLimit, rightLimit + 1).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString(); // String
																												// Generate

		System.out.println(generatedString);
		//JsonUtils.setData("Question", "FAQ Question " + generatedString,DefineConstants.TC_35_Admin_PageSetting_Add_Remove_Logo);
	}

	@Test(enabled = true)
	public void admin_Add_DeleteLogo() throws InterruptedException, AWTException {

		test = extent.createTest("TC_35_Admin_PageSetting_Add_Remove_Logo","Admin should be able to Add and Delete Brand Logo in page Setting tab");

		profile_page = new Profile_Page(driver, test);
		page_Setting = new Page_Setting(driver, test);
		scroll = new ScrollTypes(driver);

		driver.get(DefineConstants.KISAAN_Admin_URL);
		profile_page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_35_Admin_PageSetting_Add_Remove_Logo, "Admin Email Id"));
		profile_page.enter_Password(JsonUtils.getData(DefineConstants.TC_35_Admin_PageSetting_Add_Remove_Logo, "Admin Password"));
		profile_page.click_LogIN_Button();

		//Create Logo
		scroll.scrollInToView(page_Setting.page_Setting());
		page_Setting.click_Page_Setting_Tab();
		page_Setting.click_BrandLogos();
		page_Setting.click_AddNewLogos();
		page_Setting.upload_Image(JsonUtils.getData(DefineConstants.TC_35_Admin_PageSetting_Add_Remove_Logo, "Image Name"));
		page_Setting.click_AddBrandLogosButton();
		page_Setting.verify_SuccessMessage(JsonUtils.getData(DefineConstants.TC_35_Admin_PageSetting_Add_Remove_Logo, "Success Message"));
		page_Setting.click_BrandLogos();
		scroll.scrollDown();
		page_Setting.verify_Logo();
		
		//Remove Logo
		page_Setting.click_RemoveLogo();
		page_Setting.verify_SuccessMessage(JsonUtils.getData(DefineConstants.TC_35_Admin_PageSetting_Add_Remove_Logo, "Success Message Delete"));
	}

}
