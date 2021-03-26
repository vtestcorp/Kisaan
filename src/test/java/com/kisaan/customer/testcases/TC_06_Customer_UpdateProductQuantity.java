package com.kisaan.customer.testcases;

import org.testng.annotations.Test;

import com.kisaan.customer.pageobjects.Cart_Page;
import com.kisaan.customer.pageobjects.Dashboard_Page;
import com.kisaan.customer.pageobjects.HomePage;
import com.kisaan.customer.pageobjects.SignIn_Page;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;

public class TC_06_Customer_UpdateProductQuantity extends BaseClass {

	HomePage homePage;
	SignIn_Page signIn_Page;
	Dashboard_Page  dashboard_Page;
    Cart_Page cart_Page;
	
	@Test(enabled = true)
	public void customer_UpdateProductQuantity() throws Exception {

		test = extent.createTest("TC_06_Customer_UpdateProductQuantity", "Customer should be able to login and search the product, add product to cart then update product quantity");

		homePage = new HomePage(driver, test);
		signIn_Page = new SignIn_Page(driver, test); 
		dashboard_Page = new Dashboard_Page(driver, test);
		cart_Page= new Cart_Page(driver, test);
		
		driver.get(DefineConstants.KISAAN_URL);
		homePage.click_SignIn_Link();
		signIn_Page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_06_Customer_UpdateProductQuantity, "Email Address"));	
		signIn_Page.enter_Password(JsonUtils.getData(DefineConstants.TC_06_Customer_UpdateProductQuantity, "Password"));
		signIn_Page.click_LogIN_Button();
		dashboard_Page.verfiy_MyDashboard();
		dashboard_Page.click_Home();
		homePage.click_DemoStore();
		homePage.click_FindButton();
		homePage.search_Product(JsonUtils.getData(DefineConstants.TC_06_Customer_UpdateProductQuantity, "Product"));
		homePage.verify_SearchProduct(JsonUtils.getData(DefineConstants.TC_06_Customer_UpdateProductQuantity, "Product"));
		homePage.add_SearchedProductToCart(JsonUtils.getData(DefineConstants.TC_06_Customer_UpdateProductQuantity, "Product"));
		homePage.verify_SuccessMessage(JsonUtils.getData(DefineConstants.TC_06_Customer_UpdateProductQuantity, "Product"));
		homePage.openCart();
		cart_Page.updateProductQuantity(JsonUtils.getData(DefineConstants.TC_06_Customer_UpdateProductQuantity, "Product"), JsonUtils.getData(DefineConstants.TC_06_Customer_UpdateProductQuantity, "Quantity"));
	}
}