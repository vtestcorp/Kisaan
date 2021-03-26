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

public class TC_37_Admin_PageSetting_Edit_Banner extends BaseClass{
	
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
		JsonUtils.setData("Banner Link", "www."+generatedString+".com" ,DefineConstants.TC_37_Admin_PageSetting_Edit_Banner);
	}

	@Test(enabled = true)
	public void admin_Edit_HomeBanners() throws AWTException {

		test = extent.createTest("TC_37_Admin_PageSetting_Edit_Banner","Admin should be able to Edit Home Banners in page Setting tab");

		profile_page = new Profile_Page(driver, test);
		page_Setting = new Page_Setting(driver, test);
		scroll = new ScrollTypes(driver);

		driver.get(DefineConstants.KISAAN_Admin_URL);
		profile_page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_37_Admin_PageSetting_Edit_Banner, "Admin Email Id"));
		profile_page.enter_Password(JsonUtils.getData(DefineConstants.TC_37_Admin_PageSetting_Edit_Banner, "Admin Password"));
		profile_page.click_LogIN_Button();

		//Create Banner
		scroll.scrollInToView(page_Setting.page_Setting());
		page_Setting.click_Page_Setting_Tab();
		page_Setting.click_HomeBanner();
		page_Setting.click_AddHomeBanner();
		page_Setting.upload_Image(JsonUtils.getData(DefineConstants.TC_37_Admin_PageSetting_Edit_Banner, "Image Name"));
		page_Setting.enter_BannerLink(JsonUtils.getData(DefineConstants.TC_37_Admin_PageSetting_Edit_Banner, "Banner Link"));
		page_Setting.click_AddBannerButton();
		page_Setting.verify_SuccessMessage(JsonUtils.getData(DefineConstants.TC_37_Admin_PageSetting_Edit_Banner, "Success Message"));
		page_Setting.click_HomeBanner();
		scroll.scrollDown();
		page_Setting.verifyInputValueNew(JsonUtils.getData(DefineConstants.TC_37_Admin_PageSetting_Edit_Banner, "Banner Link"));
	
		//Edit Baneer
		page_Setting.click_EditHomeBanner(JsonUtils.getData(DefineConstants.TC_37_Admin_PageSetting_Edit_Banner, "Banner Link"));
		page_Setting.enter_BannerLink(JsonUtils.getData(DefineConstants.TC_37_Admin_PageSetting_Edit_Banner, "Banner Link")+"/edited");
		page_Setting.click_AddBannerButton();
		page_Setting.verify_SuccessMessage(JsonUtils.getData(DefineConstants.TC_37_Admin_PageSetting_Edit_Banner, "Success Message Edited"));
		page_Setting.click_HomeBanner();
		scroll.scrollDown();
		page_Setting.verifyInputValueNew(JsonUtils.getData(DefineConstants.TC_37_Admin_PageSetting_Edit_Banner, "Banner Link")+"/edited");
	}

}
