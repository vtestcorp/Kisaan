package com.kisaan.customer.testcases;

import org.testng.annotations.Test;

import com.kisaan.customer.pageobjects.Dashboard_Page;
import com.kisaan.customer.pageobjects.HomePage;
import com.kisaan.customer.pageobjects.SignIn_Page;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;

public class TC_10_FilterProducts_Categories extends BaseClass {

	HomePage homePage;
	SignIn_Page signIn_Page;
	Dashboard_Page  dashboard_Page;

	@Test(enabled = true)
	public void customer_FilterProduct() throws Exception {

		test = extent.createTest("TC_10_FilterProducts_Categories", "Customer should be able to filter products by categories");

		homePage = new HomePage(driver, test);
		signIn_Page = new SignIn_Page(driver, test); 
		dashboard_Page = new Dashboard_Page(driver, test);
		
		driver.get(DefineConstants.KISAAN_URL);
		homePage.click_SignIn_Link();
		signIn_Page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_10_FilterProducts_Categories, "Email Address"));	
		signIn_Page.enter_Password(JsonUtils.getData(DefineConstants.TC_10_FilterProducts_Categories, "Password"));
		signIn_Page.click_LogIN_Button();
		dashboard_Page.verfiy_MyDashboard();
		dashboard_Page.click_Home();
		homePage.click_DemoStore();
		dashboard_Page.select_Product(JsonUtils.getData(DefineConstants.TC_10_FilterProducts_Categories, "Product"));
		dashboard_Page.sort_Product(JsonUtils.getData(DefineConstants.TC_10_FilterProducts_Categories, "Filter Option"));
		
	}
}