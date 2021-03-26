package com.kisaan.admin.testcases;

import org.testng.annotations.Test;

import com.kisaan.admin.pageobjects.Profile_Page;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;

public class TC_01_Admin_SignIn extends BaseClass{
	
	Profile_Page profile_page;
	
	@Test(enabled = true)
	public void admin_SignIn() {
		
		test = extent.createTest("TC_01_Admin_SignIn", "Admin should be able to login with valid credentials");
	
		profile_page=new Profile_Page(driver, test);
		
		driver.get(DefineConstants.KISAAN_Admin_URL);
		profile_page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_01_Admin_SignIn, "Email Id"));	
		profile_page.enter_Password(JsonUtils.getData(DefineConstants.TC_01_Admin_SignIn, "Password"));
		profile_page.click_LogIN_Button();
		profile_page.verfiy_AdminDashboard();
	}
	
	
}


