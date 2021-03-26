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

public class TC_39_Admin_PageSetting_Large_HomeBanner extends BaseClass{
	
	Page_Setting page_Setting;
	Profile_Page profile_page;
	ScrollTypes scroll;

	@Test(enabled = true)
	public void admin_LargeHomeBanner() throws AWTException {

		test = extent.createTest("TC_39_Admin_PageSetting_Large_HomeBanner","Admin should be able to add Large Home Banner in page Setting tab");

		profile_page = new Profile_Page(driver, test);
		page_Setting = new Page_Setting(driver, test);
		scroll = new ScrollTypes(driver);

		driver.get(DefineConstants.KISAAN_Admin_URL);
		profile_page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_39_Admin_PageSetting_Large_HomeBanner, "Admin Email Id"));
		profile_page.enter_Password(JsonUtils.getData(DefineConstants.TC_39_Admin_PageSetting_Large_HomeBanner, "Admin Password"));
		profile_page.click_LogIN_Button();

		//Create Large Home Banner
		scroll.scrollInToView(page_Setting.page_Setting());
		page_Setting.click_Page_Setting_Tab();
		page_Setting.click_LargeHomeBanner();
		page_Setting.upload_ImageLargeBanner(JsonUtils.getData(DefineConstants.TC_39_Admin_PageSetting_Large_HomeBanner, "Image Name"));
		page_Setting.enter_LargeBannerLink(JsonUtils.getData(DefineConstants.TC_39_Admin_PageSetting_Large_HomeBanner, "Large Banner Link"));
		page_Setting.click_UpdateLargeBannerButton();
		page_Setting.verify_SuccessMessage(JsonUtils.getData(DefineConstants.TC_39_Admin_PageSetting_Large_HomeBanner, "Success Message"));
		
	}
}
