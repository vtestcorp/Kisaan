package com.kisaan.vendor.testcases;

import java.util.Random;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kisaan.customer.pageobjects.Dashboard_Page;
import com.kisaan.customer.pageobjects.HomePage;
import com.kisaan.customer.pageobjects.SignIn_Page;
import com.kisaan.vendor.pageobjects.VendorDashboard_Page;
import com.kisaan.vendor.pageobjects.VendorProfile_Page;
import com.kisaan.vendor.pageobjects.VendorRegistration_Page;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;

public class TC_04_EditVendorProfile extends BaseClass {

	HomePage homePage;
	SignIn_Page signIn_Page;
	VendorDashboard_Page  vendorDashboard_Page;
	VendorProfile_Page vendorProfile_Page;
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
		JsonUtils.setData("Vendor Owner Name","Tanveer "+generatedString, DefineConstants.TC_04_EditVendorProfile);
	//	JsonUtils.setData("Name", generatedString, DefineConstants.TC_04_EditVendorProfile);
	}

	@Test(enabled = true)
	public void vendor_SignIn() throws Exception {

		test = extent.createTest("TC_04_EditVendorProfile", "Vendor should be able to edit vendor profile");

		homePage = new HomePage(driver, test);
		signIn_Page = new SignIn_Page(driver, test); 
		vendorDashboard_Page = new VendorDashboard_Page(driver, test);
		vendorProfile_Page = new VendorProfile_Page(driver, test);
		
		driver.get(DefineConstants.KISAAN_URL);
		homePage.click_Vendor_Link();
		signIn_Page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_04_EditVendorProfile, "Email Address"));	
		signIn_Page.enter_Password(JsonUtils.getData(DefineConstants.TC_04_EditVendorProfile, "Password"));
		signIn_Page.click_LogIN_Button();
		vendorDashboard_Page.verfiy_MyDashboard();	
		vendorDashboard_Page.click_Username();
		vendorDashboard_Page.edit_ProfileButton();
		vendorProfile_Page.upload_VendorPhoto(JsonUtils.getData(DefineConstants.TC_04_EditVendorProfile, "File Name"));
		vendorProfile_Page.enter_VendorOwnerName(JsonUtils.getData(DefineConstants.TC_04_EditVendorProfile, "Vendor Owner Name"));
	//	vendorProfile_Page.enter_VendorShopName(JsonUtils.getData(DefineConstants.TC_04_EditVendorProfile, "Vendor Shop Name"));
		vendorProfile_Page.enter_VendorPhoneNumber(JsonUtils.getData(DefineConstants.TC_04_EditVendorProfile, "Phone Number"));
		vendorProfile_Page.click_UpdateProfileButton();
		vendorProfile_Page.verify_UpdateProfileSuccessMessage();
	}	
}