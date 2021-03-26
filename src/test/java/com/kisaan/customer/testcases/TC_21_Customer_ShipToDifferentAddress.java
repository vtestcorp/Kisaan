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

public class TC_21_Customer_ShipToDifferentAddress extends BaseClass {

	HomePage homePage;
	SignIn_Page signIn_Page;
	Dashboard_Page  dashboard_Page;
    Cart_Page cart_Page;
    Checkout_Page checkout_Page; 
	
	@Test(enabled = true)
	public void customer_AddProductCheckout() throws Exception {

		test = extent.createTest("TC_21_Customer_ShipToDifferentAddress", "Customer should be able to add product to cart and ship to different address");

		homePage = new HomePage(driver, test);
		signIn_Page = new SignIn_Page(driver, test); 
		dashboard_Page = new Dashboard_Page(driver, test);
		cart_Page= new Cart_Page(driver, test);
		checkout_Page= new Checkout_Page(driver, test);
		
		driver.get(DefineConstants.KISAAN_URL);
		homePage.click_SignIn_Link();
		signIn_Page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_21_Customer_ShipToDifferentAddress, "Email Address"));	
		signIn_Page.enter_Password(JsonUtils.getData(DefineConstants.TC_21_Customer_ShipToDifferentAddress, "Password"));
		signIn_Page.click_LogIN_Button();
		dashboard_Page.verfiy_MyDashboard();
		dashboard_Page.click_Home();
		homePage.click_DemoStore();
		homePage.click_FindButton();
		homePage.search_Product(JsonUtils.getData(DefineConstants.TC_21_Customer_ShipToDifferentAddress, "Product"));
		homePage.verify_SearchProduct(JsonUtils.getData(DefineConstants.TC_21_Customer_ShipToDifferentAddress, "Product"));
		homePage.add_SearchedProductToCart(JsonUtils.getData(DefineConstants.TC_21_Customer_ShipToDifferentAddress, "Product"));
		homePage.verify_SuccessMessage(JsonUtils.getData(DefineConstants.TC_21_Customer_ShipToDifferentAddress, "Product"));
		homePage.openCart();
		cart_Page.updateProductQuantity(JsonUtils.getData(DefineConstants.TC_21_Customer_ShipToDifferentAddress, "Product"), JsonUtils.getData(DefineConstants.TC_21_Customer_ShipToDifferentAddress, "Quantity"));
		cart_Page.click_ProceedToCheckoutButton();
		checkout_Page.select_ShipToAddress_Dropdown(JsonUtils.getData(DefineConstants.TC_21_Customer_ShipToDifferentAddress, "Address Type"));
		checkout_Page.enter_FullName(JsonUtils.getData(DefineConstants.TC_21_Customer_ShipToDifferentAddress, "Full Name"));
		checkout_Page.enter_Phone(JsonUtils.getData(DefineConstants.TC_21_Customer_ShipToDifferentAddress, "Phone Number"));
		checkout_Page.enter_Email(JsonUtils.getData(DefineConstants.TC_21_Customer_ShipToDifferentAddress, "Email"));
		checkout_Page.enter_Address(JsonUtils.getData(DefineConstants.TC_21_Customer_ShipToDifferentAddress, "Address"));
		checkout_Page.enter_City(JsonUtils.getData(DefineConstants.TC_21_Customer_ShipToDifferentAddress, "City"));
		checkout_Page.enter_PostalCode(JsonUtils.getData(DefineConstants.TC_21_Customer_ShipToDifferentAddress, "Postal Code"));
		checkout_Page.select_PaymentMethod(JsonUtils.getData(DefineConstants.TC_21_Customer_ShipToDifferentAddress, "Paymet Method"));
		checkout_Page.click_ShipToDifferentAddress();		
		checkout_Page.enter_ShipToDifferentAddress_FullName_TextBox(JsonUtils.getData(DefineConstants.TC_21_Customer_ShipToDifferentAddress, "ShipToDifferentAddress_FullName"));
		checkout_Page.enter_ShipToDifferentAddress_PhoneNumber_TextBox(JsonUtils.getData(DefineConstants.TC_21_Customer_ShipToDifferentAddress, "ShipToDifferentAddress_PhoneNumber"));
		checkout_Page.enter_ShipToDifferentAddress_EmailAddress_TextBox(JsonUtils.getData(DefineConstants.TC_21_Customer_ShipToDifferentAddress, "ShipToDifferentAddress_EmailAddress"));
		checkout_Page.enter_ShipToDifferentAddress_Address_TextBox(JsonUtils.getData(DefineConstants.TC_21_Customer_ShipToDifferentAddress, "ShipToDifferentAddress_Address"));
		checkout_Page.enter_ShipToDifferentAddress_City_TextBox(JsonUtils.getData(DefineConstants.TC_21_Customer_ShipToDifferentAddress, "ShipToDifferentAddress_City"));
        checkout_Page.enter_ShipToDifferentAddress_PostalCode_TextBox(JsonUtils.getData(DefineConstants.TC_21_Customer_ShipToDifferentAddress, "ShipToDifferentAddress_PostalCode"));		
		checkout_Page.enter_OrderNotes(JsonUtils.getData(DefineConstants.TC_21_Customer_ShipToDifferentAddress, "Order Notes"));
		checkout_Page.click_OrderNow_Button();  
		checkout_Page.verify_ConfirmationText(JsonUtils.getData(DefineConstants.TC_21_Customer_ShipToDifferentAddress, "Confirmation Text"));
	}
}