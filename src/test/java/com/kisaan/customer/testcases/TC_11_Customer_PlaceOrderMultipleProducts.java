package com.kisaan.customer.testcases;

import org.testng.annotations.Test;

import com.kisaan.customer.pageobjects.Cart_Page;
import com.kisaan.customer.pageobjects.Checkout_Page;
import com.kisaan.customer.pageobjects.Dashboard_Page;
import com.kisaan.customer.pageobjects.HomePage;
import com.kisaan.customer.pageobjects.SignIn_Page;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;

public class TC_11_Customer_PlaceOrderMultipleProducts extends BaseClass {

	HomePage homePage;
	SignIn_Page signIn_Page;
	Dashboard_Page  dashboard_Page;
	Cart_Page cart_Page;
	Checkout_Page checkout_Page;

	@Test(enabled = true)
	public void customer_PlaceOrderMultipleProducts() throws Exception {

		test = extent.createTest("TC_11_Customer_PlaceOrderMultipleProducts", "Customer should be able to login and place orders for multiple products");

		homePage = new HomePage(driver, test);
		signIn_Page = new SignIn_Page(driver, test); 
		dashboard_Page = new Dashboard_Page(driver, test);
		cart_Page= new Cart_Page(driver, test);
		checkout_Page = new Checkout_Page(driver, test);				
								
		driver.get(DefineConstants.KISAAN_URL);
		homePage.click_SignIn_Link();
		signIn_Page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_11_Customer_PlaceOrderMultipleProducts, "Email Address"));	
		signIn_Page.enter_Password(JsonUtils.getData(DefineConstants.TC_11_Customer_PlaceOrderMultipleProducts, "Password"));
		signIn_Page.click_LogIN_Button();
		dashboard_Page.verfiy_MyDashboard();
		dashboard_Page.click_Home();
		homePage.click_DemoStore();
		homePage.click_FindButton();
		homePage.add_Products_ToCart(JsonUtils.getArrayValues(DefineConstants.TC_11_Customer_PlaceOrderMultipleProducts, "Products"));		
		homePage.openCart();
		cart_Page.updateProductQuantity(JsonUtils.getArrayValues(DefineConstants.TC_11_Customer_PlaceOrderMultipleProducts, "Products"));
		cart_Page.click_ProceedToCheckoutButton();
		// Enter Billing Address
		checkout_Page.select_ShipToAddress_Dropdown(JsonUtils.getData(DefineConstants.TC_07_Customer_AddProductCheckout, "Address Type"));
		checkout_Page.enter_FullName(JsonUtils.getData(DefineConstants.TC_07_Customer_AddProductCheckout, "Full Name"));
		checkout_Page.enter_Phone(JsonUtils.getData(DefineConstants.TC_07_Customer_AddProductCheckout, "Phone Number"));
		checkout_Page.enter_Email(JsonUtils.getData(DefineConstants.TC_07_Customer_AddProductCheckout, "Email"));
		checkout_Page.enter_Address(JsonUtils.getData(DefineConstants.TC_07_Customer_AddProductCheckout, "Address"));
		checkout_Page.enter_City(JsonUtils.getData(DefineConstants.TC_07_Customer_AddProductCheckout, "City"));
		checkout_Page.enter_PostalCode(JsonUtils.getData(DefineConstants.TC_07_Customer_AddProductCheckout, "Postal Code"));
		checkout_Page.select_PaymentMethod(JsonUtils.getData(DefineConstants.TC_07_Customer_AddProductCheckout, "Paymet Method"));
		checkout_Page.enter_OrderNotes(JsonUtils.getData(DefineConstants.TC_07_Customer_AddProductCheckout, "Order Notes"));
		checkout_Page.click_OrderNow_Button();  
		checkout_Page.verify_ConfirmationText(JsonUtils.getData(DefineConstants.TC_07_Customer_AddProductCheckout, "Confirmation Text"));
	}
}