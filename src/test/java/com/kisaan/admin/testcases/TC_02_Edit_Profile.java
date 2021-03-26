package com.kisaan.admin.testcases;

import org.testng.annotations.Test;

import com.kisaan.admin.pageobjects.Profile_Page;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;

public class TC_02_Edit_Profile extends BaseClass {

	Profile_Page profile_page;

	@Test(enabled = true)
	public void admin_Edit_Profile() {

		test = extent.createTest("TC_02_Edit_Profile", "Edit Profile");

		profile_page = new Profile_Page(driver, test);

		driver.get(DefineConstants.KISAAN_Admin_URL);
		profile_page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_02_Admin_Edit_Profile, "Email Id"));
		profile_page.enter_Password(JsonUtils.getData(DefineConstants.TC_02_Admin_Edit_Profile, "Password"));
		profile_page.click_LogIN_Button();
		profile_page.click_Admin();
		profile_page.click_Edit_Profile();
		profile_page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_02_Admin_Edit_Profile, "Email Id Edited"));
		profile_page.enter_Phone_Number(JsonUtils.getData(DefineConstants.TC_02_Admin_Edit_Profile, "Phone Number"));
		profile_page.click_UpdateProfile();
		profile_page.verify_SuccessMessage(JsonUtils.getData(DefineConstants.TC_02_Admin_Edit_Profile, "Success Message"));
		
	}
}
