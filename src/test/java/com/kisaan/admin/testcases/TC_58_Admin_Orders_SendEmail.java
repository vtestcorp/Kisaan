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

public class TC_58_Admin_Orders_SendEmail extends BaseClass{
	
	HomePage homePage;
	SignIn_Page signIn_Page;
	Dashboard_Page  dashboard_Page;
	Cart_Page cart_Page;
	Checkout_Page checkout_Page;
	Orders_Page order_Page;
	Profile_Page profile_page;
	
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
		JsonUtils.setData("Full Name", generatedString, DefineConstants.TC_58_Admin_Orders_SendEmail);
		JsonUtils.setData("Email", generatedString+"@gmail.com", DefineConstants.TC_58_Admin_Orders_SendEmail);
	}

	@Test(enabled = true)
	public void admin_Orders_SendEmail() throws Exception {

		test = extent.createTest("TC_58_Admin_Orders_SendEmail", "Admin should be able to send email to customer");

		homePage = new HomePage(driver, test);
		signIn_Page = new SignIn_Page(driver, test); 
		dashboard_Page = new Dashboard_Page(driver, test);
		cart_Page= new Cart_Page(driver, test);
		checkout_Page = new Checkout_Page(driver, test);
		order_Page=new Orders_Page(driver, test);
		profile_page=new Profile_Page(driver, test);
				
		//Place Order
		driver.get(DefineConstants.KISAAN_URL);
	//	homePage.click_SignIn_Link();
		signIn_Page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_58_Admin_Orders_SendEmail, "Email Address"));	
		signIn_Page.enter_Password(JsonUtils.getData(DefineConstants.TC_58_Admin_Orders_SendEmail, "Password"));
		signIn_Page.click_LogIN_Button();
		dashboard_Page.verfiy_MyDashboard();
		dashboard_Page.click_Home();
		homePage.click_DemoStore();
		homePage.click_FindButton();
		homePage.add_Products_ToCart(JsonUtils.getArrayValues(DefineConstants.TC_58_Admin_Orders_SendEmail, "Products"));		
		homePage.openCart();
		cart_Page.updateProductQuantity(JsonUtils.getArrayValues(DefineConstants.TC_58_Admin_Orders_SendEmail, "Products"));
		cart_Page.click_ProceedToCheckoutButton();
		// Enter Billing Address
		checkout_Page.select_ShipToAddress_Dropdown(JsonUtils.getData(DefineConstants.TC_58_Admin_Orders_SendEmail, "Address Type"));
		checkout_Page.enter_FullName(JsonUtils.getData(DefineConstants.TC_58_Admin_Orders_SendEmail, "Full Name"));
		checkout_Page.enter_Phone(JsonUtils.getData(DefineConstants.TC_58_Admin_Orders_SendEmail, "Phone Number"));
		checkout_Page.enter_Email(JsonUtils.getData(DefineConstants.TC_58_Admin_Orders_SendEmail, "Email"));
		checkout_Page.enter_Address(JsonUtils.getData(DefineConstants.TC_58_Admin_Orders_SendEmail, "Address"));
		checkout_Page.enter_City(JsonUtils.getData(DefineConstants.TC_58_Admin_Orders_SendEmail, "City"));
		checkout_Page.enter_PostalCode(JsonUtils.getData(DefineConstants.TC_58_Admin_Orders_SendEmail, "Postal Code"));
		checkout_Page.select_PaymentMethod(JsonUtils.getData(DefineConstants.TC_58_Admin_Orders_SendEmail, "Paymet Method"));
		checkout_Page.enter_OrderNotes(JsonUtils.getData(DefineConstants.TC_58_Admin_Orders_SendEmail, "Order Notes"));
		checkout_Page.click_OrderNow_Button();  
		checkout_Page.verify_ConfirmationText(JsonUtils.getData(DefineConstants.TC_58_Admin_Orders_SendEmail, "Confirmation Text"));

		//Verify Order
		driver.get(DefineConstants.KISAAN_Admin_URL);
		profile_page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_58_Admin_Orders_SendEmail, "Admin Email Id"));	
		profile_page.enter_Password(JsonUtils.getData(DefineConstants.TC_58_Admin_Orders_SendEmail, "Admin Password"));
		profile_page.click_LogIN_Button();
		
		order_Page.click_Orders_Tab();
		order_Page.searchEmail(JsonUtils.getData(DefineConstants.TC_58_Admin_Orders_SendEmail, "Full Name"));
		order_Page.verifyInputValue(JsonUtils.getData(DefineConstants.TC_58_Admin_Orders_SendEmail, "Full Name"));
		order_Page.sendEmail(JsonUtils.getData(DefineConstants.TC_58_Admin_Orders_SendEmail, "Full Name"));
		order_Page.enter_Subject(JsonUtils.getData(DefineConstants.TC_58_Admin_Orders_SendEmail, "Subject"));
		order_Page.enter_Message(JsonUtils.getData(DefineConstants.TC_58_Admin_Orders_SendEmail, "Message"));
		order_Page.click_SendMailButton();
		order_Page.verify_SuccessMessage(JsonUtils.getData(DefineConstants.TC_58_Admin_Orders_SendEmail, "Success Message"));
	}

}
