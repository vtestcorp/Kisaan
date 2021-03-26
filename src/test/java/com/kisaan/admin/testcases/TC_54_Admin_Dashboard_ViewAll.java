package com.kisaan.admin.testcases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import com.kisaan.admin.pageobjects.Profile_Page;
import com.kisaan.customer.pageobjects.Dashboard_Page;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;

public class TC_54_Admin_Dashboard_ViewAll extends BaseClass{
	
	Dashboard_Page dashboard;
	Profile_Page profile_page;

	@Test(enabled = true)
	public void admin_DashBoardViewAllButton() throws AWTException, IOException, InterruptedException {

		test = extent.createTest("TC_54_Admin_Dashboard_ViewAll","Admin should be able to navigate particular page while clicking (>) button");

		profile_page = new Profile_Page(driver, test);
		dashboard=new Dashboard_Page(driver, test);

		driver.get(DefineConstants.KISAAN_Admin_URL);
		profile_page.enter_EmailAddress(JsonUtils.getData(DefineConstants.Tc_53_Admin_Dashboard, "Admin Email Id"));
		profile_page.enter_Password(JsonUtils.getData(DefineConstants.Tc_53_Admin_Dashboard, "Admin Password"));
		profile_page.click_LogIN_Button();
		
		dashboard.click_ViewAll();
		dashboard.verifyProductsPage(JsonUtils.getData(DefineConstants.Tc_53_Admin_Dashboard, "Products Title"));
		
		
	}

}
