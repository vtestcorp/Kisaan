package com.kisaan.admin.testcases;

import java.awt.AWTException;

import org.testng.annotations.Test;

import com.kisaan.admin.pageobjects.General_Setting_Page;
import com.kisaan.admin.pageobjects.Page_Setting;
import com.kisaan.admin.pageobjects.Profile_Page;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;
import helperMethods.ScrollTypes;

public class TC_48_Admin_GeneralSetting_Background extends BaseClass{
	
	Page_Setting page_Setting;
	Profile_Page profile_page;
	ScrollTypes scroll;
	General_Setting_Page general_Page;

	@Test(enabled = true)
	public void admin_Background_Setting() throws AWTException {

		test = extent.createTest("TC_48_Admin_GeneralSetting_Background","Admin should be able to add Background Setting");

		profile_page = new Profile_Page(driver, test);
		page_Setting = new Page_Setting(driver, test);
		scroll = new ScrollTypes(driver);
		general_Page=new General_Setting_Page(driver, test);

		driver.get(DefineConstants.KISAAN_Admin_URL);
		profile_page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_48_Admin_GeneralSetting_Background, "Admin Email Id"));
		profile_page.enter_Password(JsonUtils.getData(DefineConstants.TC_48_Admin_GeneralSetting_Background, "Admin Password"));
		profile_page.click_LogIN_Button();

		scroll.scrollInToView(page_Setting.page_Setting());
		general_Page.click_GeneralSettingPage();
		general_Page.click_Background();
		general_Page.upload_ImageBackground(JsonUtils.getData(DefineConstants.TC_48_Admin_GeneralSetting_Background, "Image Name"));
		general_Page.click_UpdateSettingPageBackground();
		general_Page.verify_SuccessMessage(JsonUtils.getData(DefineConstants.TC_48_Admin_GeneralSetting_Background, "Success Message"));

	}

}
