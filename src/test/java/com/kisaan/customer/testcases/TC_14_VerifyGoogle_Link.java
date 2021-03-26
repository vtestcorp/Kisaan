package com.kisaan.customer.testcases;

import org.testng.annotations.Test;

import com.kisaan.customer.pageobjects.Dashboard_Page;
import com.kisaan.customer.pageobjects.HomePage;
import com.kisaan.customer.pageobjects.SignIn_Page;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;

public class TC_14_VerifyGoogle_Link extends BaseClass {

	HomePage homePage;
	SignIn_Page signIn_Page;
	Dashboard_Page  dashboard_Page;

	@Test(enabled = true)
	public void verify_GoogleLink() throws Exception {

		test = extent.createTest("TC_14_VerifyGoogle_Link", "Verify Google Link");

		homePage = new HomePage(driver, test);
		signIn_Page = new SignIn_Page(driver, test); 
		dashboard_Page = new Dashboard_Page(driver, test);
		
		driver.get(DefineConstants.KISAAN_URL);
		homePage.click_SignIn_Link();
		signIn_Page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_14_VerifyGoogle_Link, "Email Address"));	
		signIn_Page.enter_Password(JsonUtils.getData(DefineConstants.TC_14_VerifyGoogle_Link, "Password"));
		signIn_Page.click_LogIN_Button();
		dashboard_Page.verfiy_MyDashboard();
		homePage.click_Google_Link();
		homePage.verify_Google_Page();
	}
}