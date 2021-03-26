package com.kisaan.admin.testcases;

import java.awt.AWTException;

import org.testng.annotations.Test;

import com.kisaan.admin.pageobjects.General_Setting_Page;
import com.kisaan.admin.pageobjects.Page_Setting;
import com.kisaan.admin.pageobjects.Profile_Page;
import com.kisaan.admin.pageobjects.Social_Setting_Page;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;
import helperMethods.ScrollTypes;

public class TC_44_Admin_Update_WebsiteLogo extends BaseClass {
	
	Page_Setting page_Setting;
	Profile_Page profile_page;
	ScrollTypes scroll;
	General_Setting_Page general_Page;

	@Test(enabled = true)
	public void admin_WebsiteLogo() throws AWTException {

		test = extent.createTest("TC_44_Admin_Update_WebsiteLogo","Admin should be able to edit Website Logo");

		profile_page = new Profile_Page(driver, test);
		page_Setting = new Page_Setting(driver, test);
		scroll = new ScrollTypes(driver);
		general_Page=new General_Setting_Page(driver, test);

		driver.get(DefineConstants.KISAAN_Admin_URL);
		profile_page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_44_Admin_Update_WebsiteLogo, "Admin Email Id"));
		profile_page.enter_Password(JsonUtils.getData(DefineConstants.TC_44_Admin_Update_WebsiteLogo, "Admin Password"));
		profile_page.click_LogIN_Button();

		scroll.scrollInToView(page_Setting.page_Setting());
		general_Page.click_GeneralSettingPage();
		general_Page.upload_Image(JsonUtils.getData(DefineConstants.TC_44_Admin_Update_WebsiteLogo, "Image Name"));
		general_Page.click_UpdateSettingButton();
		general_Page.verify_SuccessMessage(JsonUtils.getData(DefineConstants.TC_44_Admin_Update_WebsiteLogo, "Success Message"));
		
	}
}
