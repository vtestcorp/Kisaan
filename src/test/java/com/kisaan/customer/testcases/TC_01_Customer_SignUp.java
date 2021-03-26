package com.kisaan.customer.testcases;

import java.util.Random;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kisaan.admin.pageobjects.Customer_Page;
import com.kisaan.admin.pageobjects.Profile_Page;
import com.kisaan.customer.pageobjects.Dashboard_Page;
import com.kisaan.customer.pageobjects.HomePage;
import com.kisaan.customer.pageobjects.Registration_Page;
import com.kisaan.customer.pageobjects.SignIn_Page;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;
import helperMethods.ScrollTypes;

public class TC_01_Customer_SignUp extends BaseClass {

	HomePage homePage;
	SignIn_Page signIn_Page;
	Registration_Page registration_Page;
	Dashboard_Page  dashboard_Page;
	Profile_Page profile_page;
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
		JsonUtils.setData("Email Address", generatedString+"@gmail.com", DefineConstants.TC_01_Customer_SignUp);
		JsonUtils.setData("Name", generatedString, DefineConstants.TC_01_Customer_SignUp);
	}

	@Test(enabled = true)
	public void customer_SignUp() throws Exception {

		test = extent.createTest("TC_01_Customer_SignUp", "Customer should be able to sign up by filling all details");

		homePage = new HomePage(driver, test);
		signIn_Page = new SignIn_Page(driver, test); 
		registration_Page = new Registration_Page(driver, test);
		dashboard_Page = new Dashboard_Page(driver, test);
		customer_Page=new Customer_Page(driver, test);
		profile_page=new Profile_Page(driver, test);
		
		driver.get(DefineConstants.KISAAN_URL);
		homePage.click_SignIn_Link();
		signIn_Page.click_CreateNewAccount_Link();
		registration_Page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_01_Customer_SignUp, "Email Address"));
        registration_Page.enter_Name(JsonUtils.getData(DefineConstants.TC_01_Customer_SignUp, "Name"));
        registration_Page.enter_Phone(JsonUtils.getData(DefineConstants.TC_01_Customer_SignUp, "Phone Number"));
        registration_Page.enter_Address(JsonUtils.getData(DefineConstants.TC_01_Customer_SignUp, "Address"));
        registration_Page.enter_City(JsonUtils.getData(DefineConstants.TC_01_Customer_SignUp, "City"));
        registration_Page.enter_Zip(JsonUtils.getData(DefineConstants.TC_01_Customer_SignUp, "Zip Code"));
		registration_Page.enter_Password(JsonUtils.getData(DefineConstants.TC_01_Customer_SignUp, "Password"));
		registration_Page.enter_ConfirmPassword(JsonUtils.getData(DefineConstants.TC_01_Customer_SignUp, "Confirm Password"));		
		registration_Page.click_SignUp_Button();
		registration_Page.verify_SuccessMessage(JsonUtils.getData(DefineConstants.TC_01_Customer_SignUp, "Success Message"));
	
		//Admin Acceptance
		driver.get(DefineConstants.KISAAN_Admin_URL);
		profile_page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_01_Customer_SignUp, "Admin Email Id"));	
		profile_page.enter_Password(JsonUtils.getData(DefineConstants.TC_01_Customer_SignUp, "Admin Password"));
		profile_page.click_LogIN_Button();
				
		customer_Page.click_Customer_Tab();
		customer_Page.click_Customers_Pending_List();
		customer_Page.searchCustomerName(JsonUtils.getData(DefineConstants.TC_01_Customer_SignUp, "Email Address"));
		customer_Page.click_Accept_Button(JsonUtils.getData(DefineConstants.TC_01_Customer_SignUp, "Email Address"));
		
		//verify Dashboard
		driver.get(DefineConstants.KISAAN_URL);
		homePage.click_SignIn_Link();
		signIn_Page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_01_Customer_SignUp, "Email Address"));	
		signIn_Page.enter_Password(JsonUtils.getData(DefineConstants.TC_01_Customer_SignUp, "Password"));
		signIn_Page.click_LogIN_Button();
		dashboard_Page.verfiy_MyDashboard();
	}
}