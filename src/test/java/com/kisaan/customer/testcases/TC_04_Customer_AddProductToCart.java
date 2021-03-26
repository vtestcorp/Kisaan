package com.kisaan.customer.testcases;

import org.testng.annotations.Test;

import com.kisaan.customer.pageobjects.Dashboard_Page;
import com.kisaan.customer.pageobjects.HomePage;
import com.kisaan.customer.pageobjects.SignIn_Page;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;

public class TC_04_Customer_AddProductToCart extends BaseClass {

	HomePage homePage;
	SignIn_Page signIn_Page;
	Dashboard_Page  dashboard_Page;

	@Test(enabled = true)
	public void customer_AddProductToCart() throws Exception {

		test = extent.createTest("TC_04_Customer_AddProductToCart", "Customer should be able to login and search the product, add product to cart");

		homePage = new HomePage(driver, test);
		signIn_Page = new SignIn_Page(driver, test); 
		dashboard_Page = new Dashboard_Page(driver, test);
		
		driver.get(DefineConstants.KISAAN_URL);
		homePage.click_SignIn_Link();
		signIn_Page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_04_Customer_AddProductToCart, "Email Address"));	
		signIn_Page.enter_Password(JsonUtils.getData(DefineConstants.TC_04_Customer_AddProductToCart, "Password"));
		signIn_Page.click_LogIN_Button();
		dashboard_Page.verfiy_MyDashboard();
		dashboard_Page.click_Home();
		homePage.click_DemoStore();
		homePage.click_FindButton();
		homePage.search_Product(JsonUtils.getData(DefineConstants.TC_04_Customer_AddProductToCart, "Product"));
		homePage.verify_SearchProduct(JsonUtils.getData(DefineConstants.TC_04_Customer_AddProductToCart, "Product"));
		homePage.add_SearchedProductToCart(JsonUtils.getData(DefineConstants.TC_04_Customer_AddProductToCart, "Product"));
		homePage.verify_SuccessMessage(JsonUtils.getData(DefineConstants.TC_04_Customer_AddProductToCart, "Product"));
	}
}