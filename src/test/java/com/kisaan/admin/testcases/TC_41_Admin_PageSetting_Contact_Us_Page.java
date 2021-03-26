package com.kisaan.admin.testcases;

import java.awt.AWTException;

import org.testng.annotations.Test;

import com.kisaan.admin.pageobjects.Page_Setting;
import com.kisaan.admin.pageobjects.Profile_Page;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;
import helperMethods.ScrollTypes;

public class TC_41_Admin_PageSetting_Contact_Us_Page extends BaseClass{
	
	Page_Setting page_Setting;
	Profile_Page profile_page;
	ScrollTypes scroll;

	@Test(enabled = true)
	public void admin_PageSetting_Contact_Page() throws AWTException {

		test = extent.createTest("TC_41_Admin_PageSetting_Contact_Us_Page","Admin should be able to edit Contact us information in page Setting tab");

		profile_page = new Profile_Page(driver, test);
		page_Setting = new Page_Setting(driver, test);
		scroll = new ScrollTypes(driver);

		driver.get(DefineConstants.KISAAN_Admin_URL);
		profile_page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_41_Admin_PageSetting_Contact_Us_Page, "Admin Email Id"));
		profile_page.enter_Password(JsonUtils.getData(DefineConstants.TC_41_Admin_PageSetting_Contact_Us_Page, "Admin Password"));
		profile_page.click_LogIN_Button();

		scroll.scrollInToView(page_Setting.page_Setting());
		page_Setting.click_Page_Setting_Tab();
		page_Setting.click_ContactUsPage();
		page_Setting.enableDisableButtonContactUs(JsonUtils.getData(DefineConstants.TC_41_Admin_PageSetting_Contact_Us_Page, "Yes"));
		page_Setting.enter_ContactText(JsonUtils.getData(DefineConstants.TC_41_Admin_PageSetting_Contact_Us_Page, "Contact Form Success Text"));
		page_Setting.enter_ContactEmail(JsonUtils.getData(DefineConstants.TC_41_Admin_PageSetting_Contact_Us_Page, "Contact Us Email Address"));
		page_Setting.click_UpdateContactUsPage();
		page_Setting.verify_SuccessMessage(JsonUtils.getData(DefineConstants.TC_41_Admin_PageSetting_Contact_Us_Page, "Success Message"));
	}

}
