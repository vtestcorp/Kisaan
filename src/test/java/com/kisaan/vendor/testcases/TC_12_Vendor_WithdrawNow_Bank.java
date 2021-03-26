package com.kisaan.vendor.testcases;

import org.testng.annotations.Test;

import com.kisaan.customer.pageobjects.HomePage;
import com.kisaan.customer.pageobjects.SignIn_Page;
import com.kisaan.vendor.pageobjects.MyWithdraws_Page;
import com.kisaan.vendor.pageobjects.VendorDashboard_Page;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;

public class TC_12_Vendor_WithdrawNow_Bank extends BaseClass {

	HomePage homePage;
	SignIn_Page signIn_Page;
	VendorDashboard_Page  vendorDashboard_Page;
	MyWithdraws_Page myWithdraws_Page;

	@Test(enabled = true)
	public void vendor_SignIn() throws Exception {

		test = extent.createTest("TC_12_Vendor_WithdrawNow_Bank", "Vendor should be able to withdraw money via bank");

		homePage = new HomePage(driver, test);
		signIn_Page = new SignIn_Page(driver, test); 
		vendorDashboard_Page = new VendorDashboard_Page(driver, test);
		myWithdraws_Page = new MyWithdraws_Page(driver, test);
		
		driver.get(DefineConstants.KISAAN_URL);
		homePage.click_Vendor_Link();
		signIn_Page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_12_Vendor_WithdrawNow_Bank, "Email Address"));	
		signIn_Page.enter_Password(JsonUtils.getData(DefineConstants.TC_12_Vendor_WithdrawNow_Bank, "Password"));
		signIn_Page.click_LogIN_Button();
		vendorDashboard_Page.verfiy_MyDashboard();		
		vendorDashboard_Page.click_WithdrawLink();
		myWithdraws_Page.click_WithDrawNowButton();
		myWithdraws_Page.select_WithdrawMethod(JsonUtils.getData(DefineConstants.TC_12_Vendor_WithdrawNow_Bank, "Withdraw Method"));
		myWithdraws_Page.enter_WithdrawAmount(JsonUtils.getData(DefineConstants.TC_12_Vendor_WithdrawNow_Bank, "Withdraw Amount"));
		myWithdraws_Page.enter_IBANAccountNo(JsonUtils.getData(DefineConstants.TC_12_Vendor_WithdrawNow_Bank, "Account No"));
		myWithdraws_Page.enter_IBANAccountName(JsonUtils.getData(DefineConstants.TC_12_Vendor_WithdrawNow_Bank, "Account Name"));
		myWithdraws_Page.enter_IBANAccountAddress(JsonUtils.getData(DefineConstants.TC_12_Vendor_WithdrawNow_Bank, "Account Address"));
		myWithdraws_Page.enter_IBANSwiftCode(JsonUtils.getData(DefineConstants.TC_12_Vendor_WithdrawNow_Bank, "Swift Code"));
		myWithdraws_Page.enter_AdditionalReference(JsonUtils.getData(DefineConstants.TC_12_Vendor_WithdrawNow_Bank, "Additional Reference"));		
		myWithdraws_Page.click_WithDrawButton();		
	}	
}