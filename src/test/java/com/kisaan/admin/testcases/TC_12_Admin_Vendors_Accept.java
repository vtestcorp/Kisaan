package com.kisaan.admin.testcases;

import java.io.IOException;
import java.util.Random;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kisaan.admin.pageobjects.Profile_Page;
import com.kisaan.admin.pageobjects.Vendors_Page;
import com.kisaan.customer.pageobjects.HomePage;
import com.kisaan.customer.pageobjects.SignIn_Page;
import com.kisaan.vendor.pageobjects.VendorRegistration_Page;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;

public class TC_12_Admin_Vendors_Accept extends BaseClass{
	
	Profile_Page profile_page;
	Vendors_Page vendors_page;
	VendorRegistration_Page vendorRegistration_Page; 
	HomePage homePage;
	SignIn_Page signIn_Page;
	
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
		JsonUtils.setData("Email Address", generatedString+"@gmail.com", DefineConstants.TC_12_Admin_Vendors_Accept);
		JsonUtils.setData("Name", generatedString, DefineConstants.TC_12_Admin_Vendors_Accept);
	}

	@Test(enabled = true)
	public void admin_AcceptVendors() throws InterruptedException, Exception {

		test = extent.createTest("TC_12_Admin_Vendors_Accept", "Admin should be able to Accept Vendor");

		profile_page = new Profile_Page(driver, test);
		vendors_page = new Vendors_Page(driver, test);
		vendorRegistration_Page = new VendorRegistration_Page(driver, test);
		homePage = new HomePage(driver, test);
		signIn_Page = new SignIn_Page(driver, test); 
		
		//Create Vendors
		driver.get(DefineConstants.KISAAN_URL);
		homePage.click_Vendor_Link();
		signIn_Page.click_CreateNewAccount_Link();
		vendorRegistration_Page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_12_Admin_Vendors_Accept, "Email Address"));
		vendorRegistration_Page.enter_Name(JsonUtils.getData(DefineConstants.TC_12_Admin_Vendors_Accept, "Name"));
		vendorRegistration_Page.enter_StoreName(JsonUtils.getData(DefineConstants.TC_12_Admin_Vendors_Accept, "Store Name"));
		vendorRegistration_Page.enter_Phone(JsonUtils.getData(DefineConstants.TC_12_Admin_Vendors_Accept, "Phone Number"));
		vendorRegistration_Page.enter_Password(JsonUtils.getData(DefineConstants.TC_12_Admin_Vendors_Accept, "Password"));
		vendorRegistration_Page.enter_ConfirmPassword(JsonUtils.getData(DefineConstants.TC_12_Admin_Vendors_Accept, "Confirm Password"));		
		vendorRegistration_Page.click_SignUp_Button();
		vendorRegistration_Page.verify_SuccessMessage();

		//Accept Vendors
		driver.get(DefineConstants.KISAAN_Admin_URL);
		profile_page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_12_Admin_Vendors_Accept, "Admin Email Id"));
		profile_page.enter_Password(JsonUtils.getData(DefineConstants.TC_12_Admin_Vendors_Accept, "Admin Password"));
		profile_page.click_LogIN_Button();

		vendors_page.click_Vendors_Tab();
		vendors_page.click_Vendors_Pending_List();
		vendors_page.searchVendorsName(JsonUtils.getData(DefineConstants.TC_12_Admin_Vendors_Accept, "Email Address"));
		vendors_page.click_View_Button(JsonUtils.getData(DefineConstants.TC_12_Admin_Vendors_Accept, "Email Address"));
		vendors_page.click_Accept_Button();
		vendors_page.verify_SuccessMessageAcceptVendors(JsonUtils.getData(DefineConstants.TC_12_Admin_Vendors_Accept, "Success Acceptance Message"));
	//	vendors_page.click_Back_Button();
		vendors_page.searchVendorsName(JsonUtils.getData(DefineConstants.TC_12_Admin_Vendors_Accept, "Email Address"));
		vendors_page.verifyInputValue(JsonUtils.getData(DefineConstants.TC_12_Admin_Vendors_Accept, "Email Address"));
	
	}
}
