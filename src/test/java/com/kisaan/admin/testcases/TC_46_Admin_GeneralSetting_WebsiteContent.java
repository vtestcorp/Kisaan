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

public class TC_46_Admin_GeneralSetting_WebsiteContent extends BaseClass {
	
	Page_Setting page_Setting;
	Profile_Page profile_page;
	ScrollTypes scroll;
	General_Setting_Page general_Page;

	@Test(enabled = true)
	public void admin_WebsiteContent() throws AWTException {

		test = extent.createTest("TC_46_Admin_GeneralSetting_WebsiteContent","Admin should be able to add Website Content");

		profile_page = new Profile_Page(driver, test);
		page_Setting = new Page_Setting(driver, test);
		scroll = new ScrollTypes(driver);
		general_Page=new General_Setting_Page(driver, test);

		driver.get(DefineConstants.KISAAN_Admin_URL);
		profile_page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_46_Admin_GeneralSetting_WebsiteContent, "Admin Email Id"));
		profile_page.enter_Password(JsonUtils.getData(DefineConstants.TC_46_Admin_GeneralSetting_WebsiteContent, "Admin Password"));
		profile_page.click_LogIN_Button();

		scroll.scrollInToView(page_Setting.page_Setting());
		general_Page.click_GeneralSettingPage();
		general_Page.click_WebsiteContent();
		general_Page.enter_WebsiteTitle(JsonUtils.getData(DefineConstants.TC_46_Admin_GeneralSetting_WebsiteContent, "Website Title"));
		general_Page.enter_PopularTags(JsonUtils.getData(DefineConstants.TC_46_Admin_GeneralSetting_WebsiteContent, "Popular Tags"));
		general_Page.enter_CurrencySign(JsonUtils.getData(DefineConstants.TC_46_Admin_GeneralSetting_WebsiteContent, "Currency Sign"));
		
		// Disabled/Enabled Home Slider
	//	general_Page.enableDisableButton(JsonUtils.getData(DefineConstants.TC_46_Admin_GeneralSetting_WebsiteContent, "No"), JsonUtils.getData(DefineConstants.TC_46_Admin_GeneralSetting_WebsiteContent, "Num1"));
		
		// Disable/Enable Featured Category
		general_Page.enableDisableButtonNew(JsonUtils.getData(DefineConstants.TC_46_Admin_GeneralSetting_WebsiteContent, "Yes"), JsonUtils.getData(DefineConstants.TC_46_Admin_GeneralSetting_WebsiteContent, "Num2"));
		
		// Disable/Enable Small Banners
	//	general_Page.enableDisableButton(JsonUtils.getData(DefineConstants.TC_46_Admin_GeneralSetting_WebsiteContent, "Yes"), JsonUtils.getData(DefineConstants.TC_46_Admin_GeneralSetting_WebsiteContent, "Num3"));
		
		// Disable/Enable Latest Products
		general_Page.enableDisableButtonNew(JsonUtils.getData(DefineConstants.TC_46_Admin_GeneralSetting_WebsiteContent, "Yes"), JsonUtils.getData(DefineConstants.TC_46_Admin_GeneralSetting_WebsiteContent, "Num1"));
		
		// Disable/Enable Featured Products
	//	general_Page.enableDisableButton(JsonUtils.getData(DefineConstants.TC_46_Admin_GeneralSetting_WebsiteContent, "Yes"), JsonUtils.getData(DefineConstants.TC_46_Admin_GeneralSetting_WebsiteContent, "Num5"));
		
		// Enabled/Disabled Subscription
	//	general_Page.enableDisableButton(JsonUtils.getData(DefineConstants.TC_46_Admin_GeneralSetting_WebsiteContent, "No"), JsonUtils.getData(DefineConstants.TC_46_Admin_GeneralSetting_WebsiteContent, "Num6"));
		
		// Disable/Enable Large Banner
	//	general_Page.enableDisableButton1(JsonUtils.getData(DefineConstants.TC_46_Admin_GeneralSetting_WebsiteContent, "No"), JsonUtils.getData(DefineConstants.TC_46_Admin_GeneralSetting_WebsiteContent, "Num1"));
		
		// Disable/Enable Popular Products
	//	general_Page.enableDisableButton1(JsonUtils.getData(DefineConstants.TC_46_Admin_GeneralSetting_WebsiteContent, "No"), JsonUtils.getData(DefineConstants.TC_46_Admin_GeneralSetting_WebsiteContent, "Num2"));
				
		// Disable/Enable Blog Section
	//	general_Page.enableDisableButton1(JsonUtils.getData(DefineConstants.TC_46_Admin_GeneralSetting_WebsiteContent, "No"), JsonUtils.getData(DefineConstants.TC_46_Admin_GeneralSetting_WebsiteContent, "Num3"));
	
		// Disable/Enable Testimonial Section
	//	general_Page.enableDisableButton1(JsonUtils.getData(DefineConstants.TC_46_Admin_GeneralSetting_WebsiteContent, "No"), JsonUtils.getData(DefineConstants.TC_46_Admin_GeneralSetting_WebsiteContent, "Num4"));
	
		// Disable/Enable Brand Logos
	//	general_Page.enableDisableButton1(JsonUtils.getData(DefineConstants.TC_46_Admin_GeneralSetting_WebsiteContent, "No"), JsonUtils.getData(DefineConstants.TC_46_Admin_GeneralSetting_WebsiteContent, "Num5"));
	
		general_Page.click_UpdateWebsiteSettingButton();
		general_Page.verify_SuccessMessage(JsonUtils.getData(DefineConstants.TC_46_Admin_GeneralSetting_WebsiteContent, "Success Message"));
		
		
		
	}

}
