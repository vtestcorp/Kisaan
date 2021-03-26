package com.kisaan.customer.testcases;

import org.testng.annotations.Test;

import com.kisaan.customer.pageobjects.Dashboard_Page;
import com.kisaan.customer.pageobjects.EditAccountInformation_Page;
import com.kisaan.customer.pageobjects.HomePage;
import com.kisaan.customer.pageobjects.SignIn_Page;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;

public class TC_09_ChangeExistingPassword extends BaseClass {

	HomePage homePage;
	SignIn_Page signIn_Page;
	Dashboard_Page  dashboard_Page;
	EditAccountInformation_Page editAccountInformation_Page;

	@Test(enabled = true)
	public void ChangeExistingPassword() throws Exception {

		test = extent.createTest("TC_09_ChangeExistingPassword", "Customer should be able to login and change existing password");

		homePage = new HomePage(driver, test);
		signIn_Page = new SignIn_Page(driver, test); 
		dashboard_Page = new Dashboard_Page(driver, test);
		editAccountInformation_Page = new EditAccountInformation_Page(driver, test);
		
		driver.get(DefineConstants.KISAAN_URL);
		homePage.click_SignIn_Link();
		signIn_Page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_09_ChangeExistingPassword, "Email Address"));	
		signIn_Page.enter_Password(JsonUtils.getData(DefineConstants.TC_09_ChangeExistingPassword, "Password"));
		signIn_Page.click_LogIN_Button();
		dashboard_Page.verfiy_MyDashboard();
		dashboard_Page.click_MyAccountLink();
		dashboard_Page.click_ChangePasword_Button();
		editAccountInformation_Page.enter_CurrentPassword(JsonUtils.getData(DefineConstants.TC_09_ChangeExistingPassword, "Password"));
		editAccountInformation_Page.new_Password(JsonUtils.getData(DefineConstants.TC_09_ChangeExistingPassword, "New Password"));
		editAccountInformation_Page.change_CurrentPassword(JsonUtils.getData(DefineConstants.TC_09_ChangeExistingPassword, "Change Password"));		
		editAccountInformation_Page.click_ChangePassword_Button();
		editAccountInformation_Page.verify_SuccessMessage();
		
		//Reset Password
		editAccountInformation_Page.enter_CurrentPassword(JsonUtils.getData(DefineConstants.TC_09_ChangeExistingPassword, "New Password"));
		editAccountInformation_Page.new_Password(JsonUtils.getData(DefineConstants.TC_09_ChangeExistingPassword, "Password"));
		editAccountInformation_Page.change_CurrentPassword(JsonUtils.getData(DefineConstants.TC_09_ChangeExistingPassword, "Password"));		
		editAccountInformation_Page.click_ChangePassword_Button();
		editAccountInformation_Page.verify_SuccessMessage();
	}
}