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

public class TC_50_Admin_GeneralSetting_OfficeAddress extends BaseClass{
	
	Page_Setting page_Setting;
	Profile_Page profile_page;
	ScrollTypes scroll;
	General_Setting_Page general_Page;

	@Test(enabled = true)
	public void admin_GeneralSetting_OfficeAddress() throws AWTException {

		test = extent.createTest("TC_50_Admin_GeneralSetting_OfficeAddress","Admin should be able to add Office Address");

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
		general_Page.click_OfficeAddress();
		general_Page.enter_StreetAddress(JsonUtils.getData(DefineConstants.TC_50_Admin_GeneralSetting_OfficeAddress, "Street Address"));
		general_Page.enter_PhoneNumber(JsonUtils.getData(DefineConstants.TC_50_Admin_GeneralSetting_OfficeAddress, "Phone"));
		general_Page.enter_Fax(JsonUtils.getData(DefineConstants.TC_50_Admin_GeneralSetting_OfficeAddress, "Fax"));
		general_Page.enter_Email(JsonUtils.getData(DefineConstants.TC_50_Admin_GeneralSetting_OfficeAddress, "Email"));
		general_Page.click_UpdateOfficeButton();
		general_Page.verify_SuccessMessage(JsonUtils.getData(DefineConstants.TC_50_Admin_GeneralSetting_OfficeAddress, "Success Message"));
	}

}
