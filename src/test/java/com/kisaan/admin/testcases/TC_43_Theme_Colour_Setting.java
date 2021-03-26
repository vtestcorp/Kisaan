package com.kisaan.admin.testcases;

import java.awt.AWTException;

import org.testng.annotations.Test;

import com.kisaan.admin.pageobjects.Page_Setting;
import com.kisaan.admin.pageobjects.Profile_Page;
import com.kisaan.admin.pageobjects.Social_Setting_Page;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;
import helperMethods.ScrollTypes;

public class TC_43_Theme_Colour_Setting extends BaseClass{
	
	Page_Setting page_Setting;
	Profile_Page profile_page;
	ScrollTypes scroll;
	Social_Setting_Page social_page;

	@Test(enabled = true)
	public void admin_ThemeColourSetting() throws AWTException {

		test = extent.createTest("TC_43_Theme_Colour_Setting","Admin should be able to edit Theme Colour Setting");

		profile_page = new Profile_Page(driver, test);
		page_Setting = new Page_Setting(driver, test);
		scroll = new ScrollTypes(driver);
		social_page=new Social_Setting_Page(driver, test);

		driver.get(DefineConstants.KISAAN_Admin_URL);
		profile_page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_42_Admin_SocialLink, "Admin Email Id"));
		profile_page.enter_Password(JsonUtils.getData(DefineConstants.TC_42_Admin_SocialLink, "Admin Password"));
		profile_page.click_LogIN_Button();

		scroll.scrollInToView(page_Setting.page_Setting());
		social_page.click_ThemeColourSetting();
		social_page.enter_ThemeColourValue(JsonUtils.getData(DefineConstants.TC_42_Admin_SocialLink, "Theme Colour Value"));
		social_page.click_UpdateWebsiteButton();
		social_page.verify_SuccessMessage(JsonUtils.getData(DefineConstants.TC_42_Admin_SocialLink, "Theme Update Success Message"));
		
		
	}

}
