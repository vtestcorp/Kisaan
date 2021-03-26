package com.kisaan.admin.testcases;

import java.util.Random;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kisaan.admin.pageobjects.Customer_Page;
import com.kisaan.admin.pageobjects.Products_Page;
import com.kisaan.admin.pageobjects.Profile_Page;
import com.kisaan.customer.pageobjects.Dashboard_Page;
import com.kisaan.customer.pageobjects.HomePage;
import com.kisaan.customer.pageobjects.Registration_Page;
import com.kisaan.customer.pageobjects.SignIn_Page;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;

public class TC_15_Admin_Customer_ViewDetails extends BaseClass{
	
	HomePage homePage;
	SignIn_Page signIn_Page;
	Registration_Page registration_Page;
	Dashboard_Page  dashboard_Page;
	Profile_Page profile_page;
	Products_Page products_Page;
	Customer_Page customer_Page;
	
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
		JsonUtils.setData("Email Address", generatedString+"@gmail.com", DefineConstants.TC_15_Admin_Customer_ViewDetails);
		JsonUtils.setData("Name", generatedString, DefineConstants.TC_15_Admin_Customer_ViewDetails);
	}

	@Test(enabled = true)
	public void admin_Customer_ViewList() throws Exception {

		test = extent.createTest("TC_15_Admin_Customer_ViewDetails", "Admin should be able to View Customers all details");

		homePage = new HomePage(driver, test);
		signIn_Page = new SignIn_Page(driver, test); 
		registration_Page = new Registration_Page(driver, test);
		dashboard_Page = new Dashboard_Page(driver, test);
		profile_page=new Profile_Page(driver, test);
		products_Page=new Products_Page(driver, test);
		customer_Page=new Customer_Page(driver, test);
		
		//Create Customer
		driver.get(DefineConstants.KISAAN_URL);
		homePage.click_SignIn_Link();
		signIn_Page.click_CreateNewAccount_Link();
		registration_Page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_15_Admin_Customer_ViewDetails, "Email Address"));
        registration_Page.enter_Name(JsonUtils.getData(DefineConstants.TC_15_Admin_Customer_ViewDetails, "Name"));
        registration_Page.enter_Phone(JsonUtils.getData(DefineConstants.TC_15_Admin_Customer_ViewDetails, "Phone Number"));
        registration_Page.enter_Address(JsonUtils.getData(DefineConstants.TC_15_Admin_Customer_ViewDetails, "Address"));
        registration_Page.enter_City(JsonUtils.getData(DefineConstants.TC_15_Admin_Customer_ViewDetails, "City"));
        registration_Page.enter_Zip(JsonUtils.getData(DefineConstants.TC_15_Admin_Customer_ViewDetails, "Zip Code"));
		registration_Page.enter_Password(JsonUtils.getData(DefineConstants.TC_15_Admin_Customer_ViewDetails, "Password"));
		registration_Page.enter_ConfirmPassword(JsonUtils.getData(DefineConstants.TC_15_Admin_Customer_ViewDetails, "Confirm Password"));		
		registration_Page.click_SignUp_Button();
		
		//View Customer Details
		driver.get(DefineConstants.KISAAN_Admin_URL);
		profile_page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_15_Admin_Customer_ViewDetails, "Admin Email Id"));	
		profile_page.enter_Password(JsonUtils.getData(DefineConstants.TC_15_Admin_Customer_ViewDetails, "Admin Password"));
		profile_page.click_LogIN_Button();
		
		
		customer_Page.click_Customer_Tab();
		customer_Page.click_Customers_Pending_List();
		customer_Page.searchCustomerName(JsonUtils.getData(DefineConstants.TC_15_Admin_Customer_ViewDetails, "Email Address"));
		customer_Page.viewdetails(JsonUtils.getData(DefineConstants.TC_15_Admin_Customer_ViewDetails, "Email Address"));
		customer_Page.verifyInputValueInfo(JsonUtils.getData(DefineConstants.TC_15_Admin_Customer_ViewDetails, "Name"));
		customer_Page.verifyInputValueInfo(JsonUtils.getData(DefineConstants.TC_15_Admin_Customer_ViewDetails, "Email Address"));
		customer_Page.verifyInputValueInfo(JsonUtils.getData(DefineConstants.TC_15_Admin_Customer_ViewDetails, "Phone Number"));
		customer_Page.verifyInputValueInfo(JsonUtils.getData(DefineConstants.TC_15_Admin_Customer_ViewDetails, "Zip Code"));
	}
}
