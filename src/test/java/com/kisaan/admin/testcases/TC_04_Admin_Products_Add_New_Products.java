package com.kisaan.admin.testcases;

import java.io.IOException;
import java.util.Random;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kisaan.admin.pageobjects.Products_Page;
import com.kisaan.admin.pageobjects.Profile_Page;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;

public class TC_04_Admin_Products_Add_New_Products extends BaseClass {

	Profile_Page profile_page;
	Products_Page products_Page;
	
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
		JsonUtils.setData("Product Name", generatedString+" Apple", DefineConstants.TC_04_Admin_Products_Add_New_Products);
		JsonUtils.setData("Name", generatedString, DefineConstants.TC_04_Admin_Products_Add_New_Products);
	}

	@Test(enabled = true)
	public void admin_AddProduct() throws InterruptedException, IOException {
		
		test = extent.createTest("TC_04_Admin_Products_Add_New_Products", "Admin should be able to Add New Products");
	
		profile_page=new Profile_Page(driver, test);
		products_Page=new Products_Page(driver, test);
		
		driver.get(DefineConstants.KISAAN_Admin_URL);
		profile_page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_04_Admin_Products_Add_New_Products, "Email Id"));	
		profile_page.enter_Password(JsonUtils.getData(DefineConstants.TC_04_Admin_Products_Add_New_Products, "Password"));
		profile_page.click_LogIN_Button();
		
		products_Page.click_Products_Tab();
		products_Page.click_Add_New_Products();
		products_Page.enter_ProductName(JsonUtils.getData(DefineConstants.TC_04_Admin_Products_Add_New_Products, "Product Name"));
		products_Page.select_Main_Category(JsonUtils.getData(DefineConstants.TC_04_Admin_Products_Add_New_Products, "Main Category Name"));
		products_Page.select_Sub_Category(JsonUtils.getData(DefineConstants.TC_04_Admin_Products_Add_New_Products, "Sub Category Name"));
		products_Page.select_Vendor(JsonUtils.getData(DefineConstants.TC_04_Admin_Products_Add_New_Products, "Vendor Name"));
		products_Page.select_VendorSuperMarket(JsonUtils.getData(DefineConstants.TC_04_Admin_Products_Add_New_Products, "Vendor Store"));
		products_Page.select_VendorUnit(JsonUtils.getData(DefineConstants.TC_04_Admin_Products_Add_New_Products, "Vendor Unit"));
		products_Page.upload_Image(JsonUtils.getData(DefineConstants.TC_04_Admin_Products_Add_New_Products, "Image Name"));
		products_Page.enter_ProductDescription(JsonUtils.getData(DefineConstants.TC_04_Admin_Products_Add_New_Products, "Product Description"));
		products_Page.enter_ProductCurrentPrice(JsonUtils.getData(DefineConstants.TC_04_Admin_Products_Add_New_Products, "Current Price"));
		products_Page.enter_ProductPreviousPrice(JsonUtils.getData(DefineConstants.TC_04_Admin_Products_Add_New_Products, "Previous Price"));
		products_Page.enter_ProductStock(JsonUtils.getData(DefineConstants.TC_04_Admin_Products_Add_New_Products, "Stock"));
		products_Page.enter_ReturnPolicy(JsonUtils.getData(DefineConstants.TC_04_Admin_Products_Add_New_Products, "Return Policy"));
		products_Page.click_Add_Feature_Products();
		products_Page.enter_CommissionRate(JsonUtils.getData(DefineConstants.TC_04_Admin_Products_Add_New_Products, "Commission Rate"));
		products_Page.click_Add_New_Products_Button();
		products_Page.verify_SuccessMessage(JsonUtils.getData(DefineConstants.TC_04_Admin_Products_Add_New_Products, "Success Message"));
		products_Page.searchProduct(JsonUtils.getData(DefineConstants.TC_04_Admin_Products_Add_New_Products, "Product Name"));
		products_Page.verifyInputValue(JsonUtils.getData(DefineConstants.TC_04_Admin_Products_Add_New_Products, "Product Name"));
	}
}
