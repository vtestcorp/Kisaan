package com.kisaan.vendor.testcases;

import org.testng.annotations.Test;

import com.kisaan.customer.pageobjects.HomePage;
import com.kisaan.customer.pageobjects.SignIn_Page;
import com.kisaan.vendor.pageobjects.VendorDashboard_Page;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;

public class TC_02_Vendor_SignIn extends BaseClass {

	HomePage homePage;
	SignIn_Page signIn_Page;
	VendorDashboard_Page  vendorDashboard_Page;

	@Test(enabled = true)
	public void vendor_SignIn() throws Exception {

		test = extent.createTest("TC_02_Vendor_SignIn", "Vendor should be able to login with correct credentials");

		homePage = new HomePage(driver, test);
		signIn_Page = new SignIn_Page(driver, test); 
		vendorDashboard_Page = new VendorDashboard_Page(driver, test);
		
		driver.get(DefineConstants.KISAAN_URL);
		homePage.click_Vendor_Link();
		signIn_Page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_02_Vendor_SignIn, "Email Address"));	
		signIn_Page.enter_Password(JsonUtils.getData(DefineConstants.TC_02_Vendor_SignIn, "Password"));
		signIn_Page.click_LogIN_Button();
		vendorDashboard_Page.verfiy_MyDashboard();
	}
}