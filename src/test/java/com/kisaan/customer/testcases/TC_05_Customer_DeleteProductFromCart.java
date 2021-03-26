package com.kisaan.customer.testcases;

import org.testng.annotations.Test;

import com.kisaan.customer.pageobjects.Cart_Page;
import com.kisaan.customer.pageobjects.Dashboard_Page;
import com.kisaan.customer.pageobjects.HomePage;
import com.kisaan.customer.pageobjects.SignIn_Page;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;

public class TC_05_Customer_DeleteProductFromCart extends BaseClass {

	HomePage homePage;
	SignIn_Page signIn_Page;
	Dashboard_Page  dashboard_Page;
    Cart_Page cart_Page;
	
	@Test(enabled = true)
	public void customer_DeleteProductFromCart() throws Exception {

		test = extent.createTest("TC_05_Customer_DeleteProductFromCart", "Customer should be able to login and search the product, add product to cart then delete product from cart");

		homePage = new HomePage(driver, test);
		signIn_Page = new SignIn_Page(driver, test); 
		dashboard_Page = new Dashboard_Page(driver, test);
		cart_Page= new Cart_Page(driver, test);
		
		driver.get(DefineConstants.KISAAN_URL);
		homePage.click_SignIn_Link();
		signIn_Page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_05_Customer_DeleteProductFromCart, "Email Address"));	
		signIn_Page.enter_Password(JsonUtils.getData(DefineConstants.TC_05_Customer_DeleteProductFromCart, "Password"));
		signIn_Page.click_LogIN_Button();
		dashboard_Page.verfiy_MyDashboard();
		dashboard_Page.click_Home();
		homePage.click_DemoStore();
		homePage.click_FindButton();
		homePage.search_Product(JsonUtils.getData(DefineConstants.TC_05_Customer_DeleteProductFromCart, "Product"));
		homePage.verify_SearchProduct(JsonUtils.getData(DefineConstants.TC_05_Customer_DeleteProductFromCart, "Product"));
		homePage.add_SearchedProductToCart(JsonUtils.getData(DefineConstants.TC_05_Customer_DeleteProductFromCart, "Product"));
		homePage.verify_SuccessMessage(JsonUtils.getData(DefineConstants.TC_05_Customer_DeleteProductFromCart, "Product"));
		homePage.openCart();
		cart_Page.deleteProduct(JsonUtils.getData(DefineConstants.TC_05_Customer_DeleteProductFromCart, "Product"));
	}
}