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

public class TC_51_Admin_GeneralSetting_Footer extends BaseClass{
	
	Page_Setting page_Setting;
	Profile_Page profile_page;
	ScrollTypes scroll;
	General_Setting_Page general_Page;

	@Test(enabled = true)
	public void admin_GeneralSetting_Footer() throws AWTException {

		test = extent.createTest("TC_51_Admin_GeneralSetting_Footer","Admin should be able to add footer information");

		profile_page = new Profile_Page(driver, test);
		page_Setting = new Page_Setting(driver, test);
		scroll = new ScrollTypes(driver);
		general_Page=new General_Setting_Page(driver, test);

		driver.get(DefineConstants.KISAAN_Admin_URL);
		profile_page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_50_Admin_GeneralSetting_OfficeAddress, "Admin Email Id"));
		profile_page.enter_Password(JsonUtils.getData(DefineConstants.TC_50_Admin_GeneralSetting_OfficeAddress, "Admin Password"));
		profile_page.click_LogIN_Button();

		scroll.scrollInToView(page_Setting.page_Setting());
		general_Page.click_GeneralSettingPage();
		general_Page.click_Footer();
		general_Page.enter_FooterInfo(JsonUtils.getData(DefineConstants.TC_50_Admin_GeneralSetting_OfficeAddress, "Footer"));
		general_Page.click_UpdateFooter();
		general_Page.verify_SuccessMessage(JsonUtils.getData(DefineConstants.TC_50_Admin_GeneralSetting_OfficeAddress, "Success Message Footer"));
		
	}

}
