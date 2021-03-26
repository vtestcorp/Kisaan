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

public class TC_20_Customer_BankWire_Checkout extends BaseClass {

	HomePage homePage;
	SignIn_Page signIn_Page;
	Dashboard_Page  dashboard_Page;
    Cart_Page cart_Page;
    Checkout_Page checkout_Page; 
	
	@Test(enabled = true)
	public void customer_AddProductCheckout() throws Exception {

		test = extent.createTest("TC_20_Customer_BankWire_Checkout", "Customer should be able to place order and make payment through BankWire");

		homePage = new HomePage(driver, test);
		signIn_Page = new SignIn_Page(driver, test); 
		dashboard_Page = new Dashboard_Page(driver, test);
		cart_Page= new Cart_Page(driver, test);
		checkout_Page= new Checkout_Page(driver, test);
		
		driver.get(DefineConstants.KISAAN_URL);
		homePage.click_SignIn_Link();
		signIn_Page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_20_Customer_BankWire_Checkout, "Email Address"));	
		signIn_Page.enter_Password(JsonUtils.getData(DefineConstants.TC_20_Customer_BankWire_Checkout, "Password"));
		signIn_Page.click_LogIN_Button();
		dashboard_Page.verfiy_MyDashboard();
		dashboard_Page.click_Home();
		homePage.click_DemoStore();
		homePage.click_FindButton();
		homePage.search_Product(JsonUtils.getData(DefineConstants.TC_20_Customer_BankWire_Checkout, "Product"));
		homePage.verify_SearchProduct(JsonUtils.getData(DefineConstants.TC_20_Customer_BankWire_Checkout, "Product"));
		homePage.add_SearchedProductToCart(JsonUtils.getData(DefineConstants.TC_20_Customer_BankWire_Checkout, "Product"));
		homePage.verify_SuccessMessage(JsonUtils.getData(DefineConstants.TC_20_Customer_BankWire_Checkout, "Product"));
		homePage.openCart();
		cart_Page.updateProductQuantity(JsonUtils.getData(DefineConstants.TC_20_Customer_BankWire_Checkout, "Product"), JsonUtils.getData(DefineConstants.TC_20_Customer_BankWire_Checkout, "Quantity"));
		cart_Page.click_ProceedToCheckoutButton();
		checkout_Page.select_ShipToAddress_Dropdown(JsonUtils.getData(DefineConstants.TC_20_Customer_BankWire_Checkout, "Address Type"));
		checkout_Page.select_PickUpLocation_Dropdown(JsonUtils.getData(DefineConstants.TC_20_Customer_BankWire_Checkout, "Pick Up Location"));
		checkout_Page.enter_FullName(JsonUtils.getData(DefineConstants.TC_20_Customer_BankWire_Checkout, "Full Name"));
		checkout_Page.enter_Phone(JsonUtils.getData(DefineConstants.TC_20_Customer_BankWire_Checkout, "Phone Number"));
		checkout_Page.enter_Email(JsonUtils.getData(DefineConstants.TC_20_Customer_BankWire_Checkout, "Email"));
		checkout_Page.enter_Address(JsonUtils.getData(DefineConstants.TC_20_Customer_BankWire_Checkout, "Address"));
		checkout_Page.enter_City(JsonUtils.getData(DefineConstants.TC_20_Customer_BankWire_Checkout, "City"));
		checkout_Page.enter_PostalCode(JsonUtils.getData(DefineConstants.TC_20_Customer_BankWire_Checkout, "Postal Code"));
		checkout_Page.select_PaymentMethod(JsonUtils.getData(DefineConstants.TC_20_Customer_BankWire_Checkout, "Paymet Method"));
		checkout_Page.enter_BankWireTransactionID(JsonUtils.getData(DefineConstants.TC_20_Customer_BankWire_Checkout, "Bank Wire Transaction ID"));		
		checkout_Page.enter_OrderNotes(JsonUtils.getData(DefineConstants.TC_20_Customer_BankWire_Checkout, "Order Notes"));
		checkout_Page.click_OrderNow_Button(); 
		checkout_Page.verify_ConfirmationText(JsonUtils.getData(DefineConstants.TC_20_Customer_BankWire_Checkout, "Confirmation Text"));			
	}
}