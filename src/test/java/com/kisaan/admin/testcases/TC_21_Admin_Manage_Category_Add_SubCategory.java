package com.kisaan.admin.testcases;

import java.util.Random;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kisaan.admin.pageobjects.Manage_Category;
import com.kisaan.admin.pageobjects.Profile_Page;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;

public class TC_21_Admin_Manage_Category_Add_SubCategory extends BaseClass{
	
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
		JsonUtils.setData("Category Url Slug", generatedString, DefineConstants.TC_21_Admin_Manage_Category_Add_SubCategory);
		JsonUtils.setData("Category Name", generatedString, DefineConstants.TC_21_Admin_Manage_Category_Add_SubCategory);
	}
	
	@Test(enabled = true)
	public void admin_Add_SubCategory() throws Exception {

		test = extent.createTest("TC_21_Admin_Manage_Category_Add_SubCategory", "Admin should be able to Add Sub-Category");
	
		manage_Category=new Manage_Category(driver, test);
		profile_page=new Profile_Page(driver, test);
		
		driver.get(DefineConstants.KISAAN_Admin_URL);
		profile_page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_21_Admin_Manage_Category_Add_SubCategory, "Admin Email Id"));	
		profile_page.enter_Password(JsonUtils.getData(DefineConstants.TC_21_Admin_Manage_Category_Add_SubCategory, "Admin Password"));
		profile_page.click_LogIN_Button();
	
		//Create Main Category
		manage_Category.click_ManageCategory();
		manage_Category.click_AddMainCategory();
		manage_Category.enter_CategoryName(JsonUtils.getData(DefineConstants.TC_21_Admin_Manage_Category_Add_SubCategory, "Category Name"));
		manage_Category.enter_CategoryURLSlug(JsonUtils.getData(DefineConstants.TC_21_Admin_Manage_Category_Add_SubCategory, "Category Url Slug"));
		manage_Category.click_AddToFeature();
		manage_Category.upload_Image(JsonUtils.getData(DefineConstants.TC_21_Admin_Manage_Category_Add_SubCategory, "Image Name"));
		manage_Category.click_AddCategoryButton();
		manage_Category.verify_SuccessMessageCategory(JsonUtils.getData(DefineConstants.TC_21_Admin_Manage_Category_Add_SubCategory, "Success Message"));
		
		//Create Sub Category
		manage_Category.click_SubCategory();
		manage_Category.click_Add_SubCategory();
		manage_Category.selectMainCategory(JsonUtils.getData(DefineConstants.TC_21_Admin_Manage_Category_Add_SubCategory, "Category Name"));
		manage_Category.enter_CategoryName(JsonUtils.getData(DefineConstants.TC_21_Admin_Manage_Category_Add_SubCategory, "Category Name")+" Submodule");
		manage_Category.enter_CategoryURLSlug(JsonUtils.getData(DefineConstants.TC_21_Admin_Manage_Category_Add_SubCategory, "Category Url Slug")+" Submodule");
		manage_Category.click_AddToFeature();
		manage_Category.upload_Image(JsonUtils.getData(DefineConstants.TC_21_Admin_Manage_Category_Add_SubCategory, "Image Name"));
		manage_Category.click_AddCategoryButton();
		manage_Category.verify_SuccessMessageCategory(JsonUtils.getData(DefineConstants.TC_21_Admin_Manage_Category_Add_SubCategory, "Success Message Subcategory"));
		manage_Category.click_SubCategory();
		manage_Category.searchSubCategory(JsonUtils.getData(DefineConstants.TC_21_Admin_Manage_Category_Add_SubCategory, "Category Name")+" Submodule");
		manage_Category.verifyInputValue(JsonUtils.getData(DefineConstants.TC_21_Admin_Manage_Category_Add_SubCategory, "Category Name")+" Submodule");
	}
}
