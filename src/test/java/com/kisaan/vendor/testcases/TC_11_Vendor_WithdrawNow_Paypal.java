package com.kisaan.vendor.testcases;

import org.testng.annotations.Test;

import com.kisaan.customer.pageobjects.HomePage;
import com.kisaan.customer.pageobjects.SignIn_Page;
import com.kisaan.vendor.pageobjects.MyWithdraws_Page;
import com.kisaan.vendor.pageobjects.VendorDashboard_Page;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;

public class TC_11_Vendor_WithdrawNow_Paypal extends BaseClass {

	HomePage homePage;
	SignIn_Page signIn_Page;
	VendorDashboard_Page  vendorDashboard_Page;
	MyWithdraws_Page myWithdraws_Page;

	@Test(enabled = true)
	public void vendor_SignIn() throws Exception {

		test = extent.createTest("TC_11_Vendor_WithdrawNow_Paypal", "Vendor should be able to withdraw money via paypal");

		homePage = new HomePage(driver, test);
		signIn_Page = new SignIn_Page(driver, test); 
		vendorDashboard_Page = new VendorDashboard_Page(driver, test);
		myWithdraws_Page = new MyWithdraws_Page(driver, test);
		
		driver.get(DefineConstants.KISAAN_URL);
		homePage.click_Vendor_Link();
		signIn_Page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_11_Vendor_WithdrawNow_Paypal, "Email Address"));	
		signIn_Page.enter_Password(JsonUtils.getData(DefineConstants.TC_11_Vendor_WithdrawNow_Paypal, "Password"));
		signIn_Page.click_LogIN_Button();
		vendorDashboard_Page.verfiy_MyDashboard();		
		vendorDashboard_Page.click_WithdrawLink();
		myWithdraws_Page.click_WithDrawNowButton();
		myWithdraws_Page.select_WithdrawMethod(JsonUtils.getData(DefineConstants.TC_11_Vendor_WithdrawNow_Paypal, "Withdraw Method"));
		myWithdraws_Page.enter_WithdrawAmount(JsonUtils.getData(DefineConstants.TC_11_Vendor_WithdrawNow_Paypal, "Withdraw Amount"));
		myWithdraws_Page.enter_AccountEmail(JsonUtils.getData(DefineConstants.TC_11_Vendor_WithdrawNow_Paypal, "Enter Account Email"));
		myWithdraws_Page.enter_AdditionalReference(JsonUtils.getData(DefineConstants.TC_11_Vendor_WithdrawNow_Paypal, "Additional Reference"));		
		myWithdraws_Page.click_WithDrawButton();
		myWithdraws_Page.verifySuccessMessage();
	}	
}