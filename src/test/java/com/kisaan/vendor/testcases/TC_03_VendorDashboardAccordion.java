package com.kisaan.vendor.testcases;

import org.testng.annotations.Test;

import com.kisaan.customer.pageobjects.HomePage;
import com.kisaan.customer.pageobjects.SignIn_Page;
import com.kisaan.vendor.pageobjects.VendorDashboard_Page;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;

public class TC_03_VendorDashboardAccordion extends BaseClass {

	HomePage homePage;
	SignIn_Page signIn_Page;
	VendorDashboard_Page  vendorDashboard_Page;

	@Test(enabled = true)
	public void vendor_SignIn() throws Exception {

		test = extent.createTest("TC_03_VendorDashboardAccordion", "Vendor should be able to login with correct credentials");

		homePage = new HomePage(driver, test);
		signIn_Page = new SignIn_Page(driver, test); 
		vendorDashboard_Page = new VendorDashboard_Page(driver, test);
		
		driver.get(DefineConstants.KISAAN_URL);
		homePage.click_Vendor_Link();
		signIn_Page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_03_VendorDashboardAccordion, "Email Address"));	
		signIn_Page.enter_Password(JsonUtils.getData(DefineConstants.TC_03_VendorDashboardAccordion, "Password"));
		signIn_Page.click_LogIN_Button();
		vendorDashboard_Page.verfiy_MyDashboard();		
	//	vendorDashboard_Page.verfiy_CurrentBalance_Accordion();
		vendorDashboard_Page.verfiy_TotalItemSold_Accordion();
		vendorDashboard_Page.verfiy_TotalEarnings_Accordion();
		vendorDashboard_Page.verfiy_TotalProducts_Accordion();
		vendorDashboard_Page.verfiy_OrdersPending_Accordion();
		vendorDashboard_Page.verfiy_OrdersProcessing_Accordion();
		vendorDashboard_Page.verfiy_OrdersCompleted_Accordion();
	}
	
}