package com.kisaan.admin.testcases;

import java.util.Random;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kisaan.admin.pageobjects.Orders_Page;
import com.kisaan.admin.pageobjects.Profile_Page;
import com.kisaan.customer.pageobjects.Cart_Page;
import com.kisaan.customer.pageobjects.Checkout_Page;
import com.kisaan.customer.pageobjects.Dashboard_Page;
import com.kisaan.customer.pageobjects.HomePage;
import com.kisaan.customer.pageobjects.SignIn_Page;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;

public class TC_57_Admin_Orders_ViewDetails extends BaseClass {
	
	HomePage homePage;
	SignIn_Page signIn_Page;
	Dashboard_Page  dashboard_Page;
	Cart_Page cart_Page;
	Checkout_Page checkout_Page;
	Orders_Page order_Page;
	Profile_Page profile_page;
	
//	@BeforeMethod
//	public static void randomStringGenerate() {
//		int leftLimit = 97; // letter 'a'
//		int rightLimit = 122; // letter 'z'
//		int targetStringLength = 5;
//		Random random = new Random();
//		
//		String generatedString = random.ints(leftLimit, rightLimit + 1).limit(targetStringLength)
//				.collect(StringBuilder::new, StringBuilder::appendCodePoint, 
//				StringBuilder::append).toString();   //String Generate
//		
//		System.out.println(generatedString);
//		JsonUtils.setData("Full Name", generatedString, DefineConstants.TC_57_Admin_Orders_ViewDetails);
//		JsonUtils.setData("Email", generatedString+"@gmail.com", DefineConstants.TC_57_Admin_Orders_ViewDetails);
//	}

	@Test(enabled = true)
	public void admin_Orders_ViewDetails() throws Exception {

		test = extent.createTest("TC_57_Admin_Orders_ViewDetails", "Admin should be able to view order details.");

		homePage = new HomePage(driver, test);
		signIn_Page = new SignIn_Page(driver, test); 
		dashboard_Page = new Dashboard_Page(driver, test);
		cart_Page= new Cart_Page(driver, test);
		checkout_Page = new Checkout_Page(driver, test);
		order_Page=new Orders_Page(driver, test);
		profile_page=new Profile_Page(driver, test);
				
		//Place Order
//		driver.get(DefineConstants.KISAAN_URL);
//		homePage.click_SignIn_Link();
//		signIn_Page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_57_Admin_Orders_ViewDetails, "Email Address"));	
//		signIn_Page.enter_Password(JsonUtils.getData(DefineConstants.TC_57_Admin_Orders_ViewDetails, "Password"));
//		signIn_Page.click_LogIN_Button();
//		dashboard_Page.verfiy_MyDashboard();
//		dashboard_Page.click_Home();
//		homePage.click_FindButton();
//		homePage.add_Products_ToCart(JsonUtils.getArrayValues(DefineConstants.TC_57_Admin_Orders_ViewDetails, "Products"));		
//		homePage.openCart();
//		cart_Page.updateProductQuantity(JsonUtils.getArrayValues(DefineConstants.TC_57_Admin_Orders_ViewDetails, "Products"));
//		cart_Page.click_ProceedToCheckoutButton();
//		// Enter Billing Address
//		checkout_Page.select_ShipToAddress_Dropdown(JsonUtils.getData(DefineConstants.TC_57_Admin_Orders_ViewDetails, "Address Type"));
//		checkout_Page.enter_FullName(JsonUtils.getData(DefineConstants.TC_57_Admin_Orders_ViewDetails, "Full Name"));
//		checkout_Page.enter_Phone(JsonUtils.getData(DefineConstants.TC_57_Admin_Orders_ViewDetails, "Phone Number"));
//		checkout_Page.enter_Email(JsonUtils.getData(DefineConstants.TC_57_Admin_Orders_ViewDetails, "Email"));
//		checkout_Page.enter_Address(JsonUtils.getData(DefineConstants.TC_57_Admin_Orders_ViewDetails, "Address"));
//		checkout_Page.enter_City(JsonUtils.getData(DefineConstants.TC_57_Admin_Orders_ViewDetails, "City"));
//		checkout_Page.enter_PostalCode(JsonUtils.getData(DefineConstants.TC_57_Admin_Orders_ViewDetails, "Postal Code"));
//		checkout_Page.select_PaymentMethod(JsonUtils.getData(DefineConstants.TC_57_Admin_Orders_ViewDetails, "Paymet Method"));
//		checkout_Page.enter_OrderNotes(JsonUtils.getData(DefineConstants.TC_57_Admin_Orders_ViewDetails, "Order Notes"));
//		checkout_Page.click_OrderNow_Button();  
//		checkout_Page.verify_ConfirmationText(JsonUtils.getData(DefineConstants.TC_57_Admin_Orders_ViewDetails, "Confirmation Text"));
//
		//Verify Order
		driver.get(DefineConstants.KISAAN_Admin_URL);
		profile_page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_57_Admin_Orders_ViewDetails, "Admin Email Id"));	
		profile_page.enter_Password(JsonUtils.getData(DefineConstants.TC_57_Admin_Orders_ViewDetails, "Admin Password"));
		profile_page.click_LogIN_Button();
		
		order_Page.click_Orders_Tab();
		order_Page.searchEmail(JsonUtils.getData(DefineConstants.TC_57_Admin_Orders_ViewDetails, "Full Name"));
		order_Page.verifyInputValue(JsonUtils.getData(DefineConstants.TC_57_Admin_Orders_ViewDetails, "Full Name"));
		order_Page.viewdetails(JsonUtils.getData(DefineConstants.TC_57_Admin_Orders_ViewDetails, "Full Name"));
		order_Page.verifyInputValueInfo(JsonUtils.getData(DefineConstants.TC_57_Admin_Orders_ViewDetails, "Full Name"));
		order_Page.verifyInputValueInfo(JsonUtils.getData(DefineConstants.TC_57_Admin_Orders_ViewDetails, "Email"));
		order_Page.verifyInputValueInfo(JsonUtils.getData(DefineConstants.TC_57_Admin_Orders_ViewDetails, "Phone Number"));
		order_Page.verifyInputValueInfo(JsonUtils.getData(DefineConstants.TC_57_Admin_Orders_ViewDetails, "Paymet Method"));
	
	
	}
}
