package com.kisaan.customer.testcases;

import org.testng.annotations.Test;

import com.kisaan.customer.pageobjects.Dashboard_Page;
import com.kisaan.customer.pageobjects.EditAccountInformation_Page;
import com.kisaan.customer.pageobjects.HomePage;
import com.kisaan.customer.pageobjects.SignIn_Page;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;

public class TC_08_EditAddress extends BaseClass {

	HomePage homePage;
	SignIn_Page signIn_Page;
	Dashboard_Page  dashboard_Page;
	EditAccountInformation_Page editAccountInformation_Page;

	@Test(enabled = true)
	public void EditAddress() throws Exception {

		test = extent.createTest("TC_08_EditAddress", "Customer should be able to login and edit the address");

		homePage = new HomePage(driver, test);
		signIn_Page = new SignIn_Page(driver, test); 
		dashboard_Page = new Dashboard_Page(driver, test);
		editAccountInformation_Page = new EditAccountInformation_Page(driver, test);
		
		driver.get(DefineConstants.KISAAN_URL);
		homePage.click_SignIn_Link();
		signIn_Page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_08_EditAddress, "Email Address"));	
		signIn_Page.enter_Password(JsonUtils.getData(DefineConstants.TC_08_EditAddress, "Password"));
		signIn_Page.click_LogIN_Button();
		dashboard_Page.verfiy_MyDashboard();
		dashboard_Page.click_MyAccountLink();
		dashboard_Page.click_EditAddress_Button();
		editAccountInformation_Page.enter_FullName(JsonUtils.getData(DefineConstants.TC_08_EditAddress, "Full Name"));
		editAccountInformation_Page.enter_PhoneNumber(JsonUtils.getData(DefineConstants.TC_08_EditAddress, "Phone Number"));
		editAccountInformation_Page.enter_Address(JsonUtils.getData(DefineConstants.TC_08_EditAddress, "Address"));
		editAccountInformation_Page.enter_City(JsonUtils.getData(DefineConstants.TC_08_EditAddress, "City"));
		editAccountInformation_Page.enter_PostalCode(JsonUtils.getData(DefineConstants.TC_08_EditAddress, "Postal Code"));		
		editAccountInformation_Page.successMessageEdit(JsonUtils.getData(DefineConstants.TC_08_EditAddress, "Success Message"));
	
	}
}