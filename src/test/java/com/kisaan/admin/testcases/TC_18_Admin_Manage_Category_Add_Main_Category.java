package com.kisaan.admin.testcases;

import java.util.Random;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kisaan.admin.pageobjects.Manage_Category;
import com.kisaan.admin.pageobjects.Profile_Page;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;

public class TC_18_Admin_Manage_Category_Add_Main_Category extends BaseClass{
	
	Manage_Category manage_Category;
	Profile_Page profile_page;
	
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
		JsonUtils.setData("Category Url Slug", generatedString, DefineConstants.TC_18_Admin_Manage_Category_Add_Main_Category);
		JsonUtils.setData("Category Name", generatedString, DefineConstants.TC_18_Admin_Manage_Category_Add_Main_Category);
	}
	
	@Test(enabled = true)
	public void admin_Add_MainCategory() throws Exception {

		test = extent.createTest("TC_18_Admin_Manage_Category_Add_Main_Category", "Admin should be able to Add Main Category");
	
		manage_Category=new Manage_Category(driver, test);
		profile_page=new Profile_Page(driver, test);
		
		driver.get(DefineConstants.KISAAN_Admin_URL);
		profile_page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_18_Admin_Manage_Category_Add_Main_Category, "Admin Email Id"));	
		profile_page.enter_Password(JsonUtils.getData(DefineConstants.TC_18_Admin_Manage_Category_Add_Main_Category, "Admin Password"));
		profile_page.click_LogIN_Button();
	
		manage_Category.click_ManageCategory();
		manage_Category.click_AddMainCategory();
		manage_Category.enter_CategoryName(JsonUtils.getData(DefineConstants.TC_18_Admin_Manage_Category_Add_Main_Category, "Category Name"));
		manage_Category.enter_CategoryURLSlug(JsonUtils.getData(DefineConstants.TC_18_Admin_Manage_Category_Add_Main_Category, "Category Url Slug"));
		manage_Category.click_AddToFeature();
		manage_Category.upload_Image(JsonUtils.getData(DefineConstants.TC_18_Admin_Manage_Category_Add_Main_Category, "Image Name"));
		manage_Category.click_AddCategoryButton();
		manage_Category.verify_SuccessMessageCategory(JsonUtils.getData(DefineConstants.TC_18_Admin_Manage_Category_Add_Main_Category, "Success Message"));
		manage_Category.searchCategory(JsonUtils.getData(DefineConstants.TC_18_Admin_Manage_Category_Add_Main_Category, "Category Name"));
		manage_Category.verifyInputValue(JsonUtils.getData(DefineConstants.TC_18_Admin_Manage_Category_Add_Main_Category, "Category Name"));	
	
	}
}
