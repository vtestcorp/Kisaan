package com.kisaan.admin.testcases;

import java.awt.AWTException;

import org.testng.annotations.Test;

import com.kisaan.admin.pageobjects.General_Setting_Page;
import com.kisaan.admin.pageobjects.Page_Setting;
import com.kisaan.admin.pageobjects.Profile_Page;
import com.kisaan.customer.pageobjects.Dashboard_Page;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;
import helperMethods.ScrollTypes;

public class Tc_53_Admin_Dashboard extends BaseClass{
	
	Dashboard_Page dashboard;
	Profile_Page profile_page;

	@Test(enabled = true)
	public void admin_DashBoard() throws AWTException {

		test = extent.createTest("Tc_53_Admin_Dashboard","Admin should be able to view Dashboard information");

		profile_page = new Profile_Page(driver, test);
		dashboard=new Dashboard_Page(driver, test);

		driver.get(DefineConstants.KISAAN_Admin_URL);
		profile_page.enter_EmailAddress(JsonUtils.getData(DefineConstants.Tc_53_Admin_Dashboard, "Admin Email Id"));
		profile_page.enter_Password(JsonUtils.getData(DefineConstants.Tc_53_Admin_Dashboard, "Admin Password"));
		profile_page.click_LogIN_Button();
		
		dashboard.VerifyDashboardEntries(JsonUtils.getData(DefineConstants.Tc_53_Admin_Dashboard, "Total Products"), "1");
		dashboard.VerifyDashboardEntries(JsonUtils.getData(DefineConstants.Tc_53_Admin_Dashboard, "Orders Pending"), "2");
		dashboard.VerifyDashboardEntries(JsonUtils.getData(DefineConstants.Tc_53_Admin_Dashboard, "Orders Processing"), "3");
		dashboard.VerifyDashboardEntries(JsonUtils.getData(DefineConstants.Tc_53_Admin_Dashboard, "Orders Completed"), "4");
		//dashboard.VerifyDashboardEntries(JsonUtils.getData(DefineConstants.Tc_53_Admin_Dashboard, "Pending Withdraws"), "5");
		dashboard.VerifyDashboardEntries(JsonUtils.getData(DefineConstants.Tc_53_Admin_Dashboard, "Total Customers"), "5");
		dashboard.VerifyDashboardEntries(JsonUtils.getData(DefineConstants.Tc_53_Admin_Dashboard, "Vendors Pending"), "6");
		dashboard.VerifyDashboardEntries(JsonUtils.getData(DefineConstants.Tc_53_Admin_Dashboard, "Total Vendors"), "7");
		
	}

}
