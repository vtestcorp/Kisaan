package com.kisaan.admin.testcases;

import java.util.Random;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kisaan.admin.pageobjects.Products_Page;
import com.kisaan.admin.pageobjects.Profile_Page;
import com.kisaan.admin.pageobjects.Vendors_Page;
import com.kisaan.customer.pageobjects.HomePage;
import com.kisaan.customer.pageobjects.SignIn_Page;
import com.kisaan.vendor.pageobjects.VendorRegistration_Page;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;

public class TC_09_Admin_Vendors_SearchVendors extends BaseClass {
	
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
		JsonUtils.setData("Email Address", generatedString+"@gmail.com", DefineConstants.TC_09_Admin_Vendors_SearchVendors);
		JsonUtils.setData("Name", generatedString, DefineConstants.TC_09_Admin_Vendors_SearchVendors);
	}

	@Test(enabled = true)
	public void admin_SearchVendors() throws InterruptedException, Exception {

		test = extent.createTest("TC_09_Admin_Vendors_SearchVendors", "Admin should be able to search Vendors");

		profile_page = new Profile_Page(driver, test);
		vendors_page = new Vendors_Page(driver, test);
		vendorRegistration_Page = new VendorRegistration_Page(driver, test);
		homePage = new HomePage(driver, test);
		signIn_Page = new SignIn_Page(driver, test); 
		
		//Create Vendors
		driver.get(DefineConstants.KISAAN_URL);
		homePage.click_Vendor_Link();
		signIn_Page.click_CreateNewAccount_Link();
		vendorRegistration_Page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_09_Admin_Vendors_SearchVendors, "Email Address"));
		vendorRegistration_Page.enter_Name(JsonUtils.getData(DefineConstants.TC_09_Admin_Vendors_SearchVendors, "Name"));
		vendorRegistration_Page.enter_StoreName(JsonUtils.getData(DefineConstants.TC_09_Admin_Vendors_SearchVendors, "Store Name"));
		vendorRegistration_Page.enter_Phone(JsonUtils.getData(DefineConstants.TC_09_Admin_Vendors_SearchVendors, "Phone Number"));
		vendorRegistration_Page.enter_Password(JsonUtils.getData(DefineConstants.TC_09_Admin_Vendors_SearchVendors, "Password"));
		vendorRegistration_Page.enter_ConfirmPassword(JsonUtils.getData(DefineConstants.TC_09_Admin_Vendors_SearchVendors, "Confirm Password"));		
		vendorRegistration_Page.click_SignUp_Button();
		vendorRegistration_Page.verify_SuccessMessage();

		//Search Vendors
		driver.get(DefineConstants.KISAAN_Admin_URL);
		profile_page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_09_Admin_Vendors_SearchVendors, "Admin Email Id"));
		profile_page.enter_Password(JsonUtils.getData(DefineConstants.TC_09_Admin_Vendors_SearchVendors, "Admin Password"));
		profile_page.click_LogIN_Button();

		vendors_page.click_Vendors_Tab();
		vendors_page.click_Vendors_Pending_List();
		vendors_page.searchVendorsName(JsonUtils.getData(DefineConstants.TC_09_Admin_Vendors_SearchVendors, "Email Address"));
		vendors_page.verifyInputValue(JsonUtils.getData(DefineConstants.TC_09_Admin_Vendors_SearchVendors, "Email Address"));
}
}
