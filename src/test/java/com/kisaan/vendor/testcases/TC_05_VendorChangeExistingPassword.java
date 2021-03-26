package com.kisaan.vendor.testcases;

import org.testng.annotations.Test;

import com.kisaan.customer.pageobjects.HomePage;
import com.kisaan.customer.pageobjects.SignIn_Page;
import com.kisaan.vendor.pageobjects.VendorDashboard_Page;
import com.kisaan.vendor.pageobjects.VendorProfile_Page;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;

public class TC_05_VendorChangeExistingPassword extends BaseClass {

	HomePage homePage;
	SignIn_Page signIn_Page;	
	VendorProfile_Page vendorProfile_Page;
	VendorDashboard_Page  vendorDashboard_Page;

	@Test(enabled = true)
	public void ChangeExistingPassword() throws Exception {

		test = extent.createTest("TC_05_VendorChangeExistingPassword", "Vendor should be able to login and change existing password");

		homePage = new HomePage(driver, test);
		signIn_Page = new SignIn_Page(driver, test); 		
		vendorProfile_Page = new VendorProfile_Page(driver, test);
		vendorDashboard_Page= new VendorDashboard_Page(driver, test);
		
		driver.get(DefineConstants.KISAAN_URL);
		homePage.click_Vendor_Link();
		signIn_Page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_05_VendorChangeExistingPassword, "Email Address"));	
		signIn_Page.enter_Password(JsonUtils.getData(DefineConstants.TC_05_VendorChangeExistingPassword, "Password"));
		signIn_Page.click_LogIN_Button();
		vendorDashboard_Page.verfiy_MyDashboard();	
		vendorDashboard_Page.click_Username();		
		vendorProfile_Page.click_ChangePasword_Button();
		vendorProfile_Page.enter_CurrentPassword(JsonUtils.getData(DefineConstants.TC_05_VendorChangeExistingPassword, "Password"));
		vendorProfile_Page.new_Password(JsonUtils.getData(DefineConstants.TC_05_VendorChangeExistingPassword, "New Password"));
		vendorProfile_Page.change_CurrentPassword(JsonUtils.getData(DefineConstants.TC_05_VendorChangeExistingPassword, "Change Password"));		
		vendorProfile_Page.click_ChangePassword_Button();
		vendorProfile_Page.verify_SuccessMessage();
		
		//Reset Password
		vendorProfile_Page.enter_CurrentPassword(JsonUtils.getData(DefineConstants.TC_05_VendorChangeExistingPassword, "New Password"));
		vendorProfile_Page.new_Password(JsonUtils.getData(DefineConstants.TC_05_VendorChangeExistingPassword, "Password"));
		vendorProfile_Page.change_CurrentPassword(JsonUtils.getData(DefineConstants.TC_05_VendorChangeExistingPassword, "Password"));		
		vendorProfile_Page.click_ChangePassword_Button();
		vendorProfile_Page.verify_SuccessMessage();
	
	}
}