package com.kisaan.admin.testcases;

import java.util.Random;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kisaan.admin.pageobjects.Manage_Unit_Page;
import com.kisaan.admin.pageobjects.Profile_Page;
import com.kisaan.customer.pageobjects.Dashboard_Page;
import com.kisaan.customer.pageobjects.HomePage;
import com.kisaan.customer.pageobjects.SignIn_Page;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;

public class TC_60_Admin_ManageUnit_EditUnit extends BaseClass{
	
	HomePage homePage;
	SignIn_Page signIn_Page;
	Dashboard_Page  dashboard_Page;
	
	Profile_Page profile_page;
	Manage_Unit_Page manage_Unit;
	
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
		JsonUtils.setData("Unit Name", generatedString+" Unit", DefineConstants.TC_60_Admin_ManageUnit_EditUnit);
		JsonUtils.setData("Unit Slug", generatedString, DefineConstants.TC_60_Admin_ManageUnit_EditUnit);
	}

	@Test(enabled = true)
	public void admin_ManageUnit_EditUnit() throws Exception {

		test = extent.createTest("TC_60_Admin_ManageUnit_EditUnit", "Admin should be able to edit Unit");

		homePage = new HomePage(driver, test);
		signIn_Page = new SignIn_Page(driver, test); 
		dashboard_Page = new Dashboard_Page(driver, test);
		profile_page=new Profile_Page(driver, test);
		manage_Unit=new Manage_Unit_Page(driver, test);
				
		driver.get(DefineConstants.KISAAN_Admin_URL);
		profile_page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_60_Admin_ManageUnit_EditUnit, "Admin Email Id"));	
		profile_page.enter_Password(JsonUtils.getData(DefineConstants.TC_60_Admin_ManageUnit_EditUnit, "Admin Password"));
		profile_page.click_LogIN_Button();
		
		manage_Unit.click_ManageUnit();
		manage_Unit.click_AddNewUnit();
		manage_Unit.enter_AddName(JsonUtils.getData(DefineConstants.TC_60_Admin_ManageUnit_EditUnit, "Unit Name"));
		manage_Unit.enter_AddSlug(JsonUtils.getData(DefineConstants.TC_60_Admin_ManageUnit_EditUnit, "Unit Slug"));
		manage_Unit.click_AddUnitBtn();
		manage_Unit.verify_SuccessMessage(JsonUtils.getData(DefineConstants.TC_60_Admin_ManageUnit_EditUnit, "Success Message"));
		manage_Unit.search_UnitName(JsonUtils.getData(DefineConstants.TC_60_Admin_ManageUnit_EditUnit, "Unit Name"));
		manage_Unit.verifyInputValue(JsonUtils.getData(DefineConstants.TC_60_Admin_ManageUnit_EditUnit, "Unit Name"));
	
		//Edit
		manage_Unit.click_Edit(JsonUtils.getData(DefineConstants.TC_60_Admin_ManageUnit_EditUnit, "Unit Name"));
		manage_Unit.enter_AddName(JsonUtils.getData(DefineConstants.TC_60_Admin_ManageUnit_EditUnit, "Unit Name")+" Edited");
		manage_Unit.enter_AddSlug(JsonUtils.getData(DefineConstants.TC_60_Admin_ManageUnit_EditUnit, "Unit Slug")+" Edited");
		manage_Unit.click_AddUnitBtn();
		manage_Unit.verify_SuccessMessage(JsonUtils.getData(DefineConstants.TC_60_Admin_ManageUnit_EditUnit, "Success Message Edited"));
		manage_Unit.search_UnitName(JsonUtils.getData(DefineConstants.TC_60_Admin_ManageUnit_EditUnit, "Unit Name")+" Edited");
		manage_Unit.verifyInputValue(JsonUtils.getData(DefineConstants.TC_60_Admin_ManageUnit_EditUnit, "Unit Name")+" Edited");
		
	}

}
