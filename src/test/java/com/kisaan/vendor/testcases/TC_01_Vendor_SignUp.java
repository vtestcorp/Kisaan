package com.kisaan.vendor.testcases;

import java.util.Random;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kisaan.customer.pageobjects.Dashboard_Page;
import com.kisaan.customer.pageobjects.HomePage;
import com.kisaan.customer.pageobjects.SignIn_Page;
import com.kisaan.vendor.pageobjects.VendorRegistration_Page;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;

public class TC_01_Vendor_SignUp extends BaseClass {

	HomePage homePage;
	SignIn_Page signIn_Page;
	VendorRegistration_Page vendorRegistration_Page; 
	Dashboard_Page  dashboard_Page;
	
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
		JsonUtils.setData("Email Address", generatedString+"@gmail.com", DefineConstants.TC_01_Vendor_SignUp);
		JsonUtils.setData("Name", generatedString, DefineConstants.TC_01_Vendor_SignUp);
	}
	
	
	@Test(enabled = true)
	public void vendor_SignUp() throws Exception {

		test = extent.createTest("TC_01_Vendor_SignUp", "Vendor should be able to sign up by filling all details");

		homePage = new HomePage(driver, test);
		signIn_Page = new SignIn_Page(driver, test); 
		vendorRegistration_Page = new VendorRegistration_Page(driver, test);
		dashboard_Page = new Dashboard_Page(driver, test);
		
		driver.get(DefineConstants.KISAAN_URL);
		homePage.click_Vendor_Link();
		signIn_Page.click_CreateNewAccount_Link();
		vendorRegistration_Page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_01_Vendor_SignUp, "Email Address"));
		vendorRegistration_Page.enter_Name(JsonUtils.getData(DefineConstants.TC_01_Vendor_SignUp, "Name"));
		vendorRegistration_Page.enter_StoreName(JsonUtils.getData(DefineConstants.TC_01_Vendor_SignUp, "Store Name"));
		vendorRegistration_Page.enter_Phone(JsonUtils.getData(DefineConstants.TC_01_Vendor_SignUp, "Phone Number"));
		vendorRegistration_Page.enter_Password(JsonUtils.getData(DefineConstants.TC_01_Vendor_SignUp, "Password"));
		vendorRegistration_Page.enter_ConfirmPassword(JsonUtils.getData(DefineConstants.TC_01_Vendor_SignUp, "Confirm Password"));		
		vendorRegistration_Page.click_SignUp_Button();
		vendorRegistration_Page.verify_SuccessMessage();
	}
}