package com.kisaan.admin.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kisaan.admin.pageobjects.Profile_Page;
import com.kisaan.admin.pageobjects.Service_Area;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;

public class TC_25_Admin_ServiceArea_EditArea extends BaseClass {

	Profile_Page profile_page;
	Service_Area serviceArea;

	@BeforeMethod
	public void randomIntGenerate() {
		int min = 100000;
		int max = 1000000;
		// Generate random int value from 100000 to 1000000
		int random_int = (int) (Math.random() * (max - min + 1) + min);
		System.out.println("Number is : " + random_int);
		String num = String.valueOf(random_int);
		JsonUtils.setData("Zip Code", num, DefineConstants.TC_25_Admin_ServiceArea_EditArea);
		JsonUtils.setData("Zip Code Edited", num+"20", DefineConstants.TC_25_Admin_ServiceArea_EditArea);
	}

	@Test(enabled = true)
	public void admin_Edit_ZipCode() throws Exception {

		test = extent.createTest("TC_25_Admin_ServiceArea_EditArea", "Admin should be able to edit Zip Code");

		profile_page = new Profile_Page(driver, test);
		serviceArea = new Service_Area(driver, test);

		driver.get(DefineConstants.KISAAN_Admin_URL);
		profile_page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_25_Admin_ServiceArea_EditArea, "Admin Email Id"));
		profile_page.enter_Password(JsonUtils.getData(DefineConstants.TC_25_Admin_ServiceArea_EditArea, "Admin Password"));
		profile_page.click_LogIN_Button();

		//Add Zip Code
		serviceArea.click_ServiceArea_Tab();
		serviceArea.click_Add_New_ServiceArea();
		serviceArea.enter_Zip_Code(JsonUtils.getData(DefineConstants.TC_25_Admin_ServiceArea_EditArea, "Zip Code"));
		serviceArea.click_AddServiceArea_Button();
		serviceArea.verify_SuccessMessage(JsonUtils.getData(DefineConstants.TC_25_Admin_ServiceArea_EditArea, "Success Message"));
		serviceArea.searchZipCode(JsonUtils.getData(DefineConstants.TC_25_Admin_ServiceArea_EditArea, "Zip Code"));
		serviceArea.verifyInputValue(JsonUtils.getData(DefineConstants.TC_25_Admin_ServiceArea_EditArea, "Zip Code"));
		
		//Edit Zip Code
		serviceArea.click_EditZipCode(JsonUtils.getData(DefineConstants.TC_25_Admin_ServiceArea_EditArea, "Zip Code"));
		serviceArea.enter_Zip_Code(JsonUtils.getData(DefineConstants.TC_25_Admin_ServiceArea_EditArea, "Zip Code Edited"));
		serviceArea.click_AddServiceArea_Button();
		serviceArea.verify_SuccessMessage(JsonUtils.getData(DefineConstants.TC_25_Admin_ServiceArea_EditArea, "Success Update Message"));
		serviceArea.searchZipCode(JsonUtils.getData(DefineConstants.TC_25_Admin_ServiceArea_EditArea, "Zip Code Edited"));
		serviceArea.verifyInputValue(JsonUtils.getData(DefineConstants.TC_25_Admin_ServiceArea_EditArea, "Zip Code Edited"));
	}
	
}
