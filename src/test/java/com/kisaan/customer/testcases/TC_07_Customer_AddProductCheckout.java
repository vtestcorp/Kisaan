package com.kisaan.customer.testcases;

import java.util.Random;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kisaan.customer.pageobjects.Cart_Page;
import com.kisaan.customer.pageobjects.Checkout_Page;
import com.kisaan.customer.pageobjects.Dashboard_Page;
import com.kisaan.customer.pageobjects.HomePage;
import com.kisaan.customer.pageobjects.SignIn_Page;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;

public class TC_07_Customer_AddProductCheckout extends BaseClass {

	HomePage homePage;
	SignIn_Page signIn_Page;
	Dashboard_Page  dashboard_Page;
    Cart_Page cart_Page;
    Checkout_Page checkout_Page; 
    
    @BeforeMethod
	public static void randomStringGenerate() {
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 5;
		Random random = new Random();
		
		String generatedString = random.ints(leftLimit, rightLimit + 1).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, 
				StringBuilder::append).toString();   //String Generate
		
		System.out.println(generatedString);
		JsonUtils.setData("Email", generatedString+"@gmail.com", DefineConstants.TC_07_Customer_AddProductCheckout);
		JsonUtils.setData("Full Name", generatedString, DefineConstants.TC_07_Customer_AddProductCheckout);
	}
	
	@Test(enabled = true)
	public void customer_AddProductCheckout() throws Exception {

		test = extent.createTest("TC_07_Customer_AddProductCheckout", "Customer should be able to login, search product, update product quantity");

		homePage = new HomePage(driver, test);
		signIn_Page = new SignIn_Page(driver, test); 
		dashboard_Page = new Dashboard_Page(driver, test);
		cart_Page= new Cart_Page(driver, test);
		checkout_Page= new Checkout_Page(driver, test);
		
		driver.get(DefineConstants.KISAAN_URL);
		homePage.click_SignIn_Link();
		signIn_Page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_07_Customer_AddProductCheckout, "Email Address"));	
		signIn_Page.enter_Password(JsonUtils.getData(DefineConstants.TC_07_Customer_AddProductCheckout, "Password"));
		signIn_Page.click_LogIN_Button();
		dashboard_Page.verfiy_MyDashboard();
		dashboard_Page.click_Home();
		homePage.click_DemoStore();
		homePage.click_FindButton();
		homePage.search_Product(JsonUtils.getData(DefineConstants.TC_07_Customer_AddProductCheckout, "Product"));
		homePage.verify_SearchProduct(JsonUtils.getData(DefineConstants.TC_07_Customer_AddProductCheckout, "Product"));
		homePage.add_SearchedProductToCart(JsonUtils.getData(DefineConstants.TC_07_Customer_AddProductCheckout, "Product"));
		homePage.verify_SuccessMessage(JsonUtils.getData(DefineConstants.TC_07_Customer_AddProductCheckout, "Product"));
		homePage.openCart();
		cart_Page.updateProductQuantity(JsonUtils.getData(DefineConstants.TC_07_Customer_AddProductCheckout, "Product"), JsonUtils.getData(DefineConstants.TC_07_Customer_AddProductCheckout, "Quantity"));
		cart_Page.click_ProceedToCheckoutButton();
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