package com.kisaan.admin.testcases;

import org.testng.annotations.Test;

import com.kisaan.admin.pageobjects.Profile_Page;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;

public class TC_03_Admin_Logout extends BaseClass{
	Profile_Page profile_page;

	@Test(enabled = true)
	public void admin_Logout_Profile() {

		test = extent.createTest("TC_03_Admin_Logout", "Admin should be able to logout successfully");

		profile_page = new Profile_Page(driver, test);

		driver.get(DefineConstants.KISAAN_Admin_URL);
		profile_page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_03_Admin_Logout, "Email Id"));
		profile_page.enter_Password(JsonUtils.getData(DefineConstants.TC_03_Admin_Logout, "Password"));
		profile_page.click_LogIN_Button();
		profile_page.click_Admin();
		profile_page.click_Logout();
		profile_page.verfiy_Logo_Visibility();
	
		
	}
}
