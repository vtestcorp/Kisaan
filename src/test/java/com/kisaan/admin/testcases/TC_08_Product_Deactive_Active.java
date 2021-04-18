package com.kisaan.admin.testcases;

import java.util.Random;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kisaan.admin.pageobjects.Products_Page;
import com.kisaan.admin.pageobjects.Profile_Page;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;

public class TC_08_Product_Deactive_Active extends BaseClass {
	
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
		JsonUtils.setData("Product Name", generatedString+" Apple", DefineConstants.TC_08_Product_Deactive_Active);
	}

	@Test(enabled = true)
	public void admin_DeactiveProducts() throws InterruptedException {
		
		test = extent.createTest("TC_08_Product_Deactive_Active", "Admin should be able to Deactivate Products");
	
		profile_page=new Profile_Page(driver, test);
		products_Page=new Products_Page(driver, test);
		
		driver.get(DefineConstants.KISAAN_Admin_URL);
		profile_page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_08_Product_Deactive_Active, "Email Id"));	
		profile_page.enter_Password(JsonUtils.getData(DefineConstants.TC_08_Product_Deactive_Active, "Password"));
		profile_page.click_LogIN_Button();
		
		//Create Product
		products_Page.click_Products_Tab();
		products_Page.click_Add_New_Products();
		products_Page.enter_ProductName(JsonUtils.getData(DefineConstants.TC_08_Product_Deactive_Active, "Product Name"));
		products_Page.select_Main_Category(JsonUtils.getData(DefineConstants.TC_08_Product_Deactive_Active, "Main Category Name"));
		products_Page.select_Sub_Category(JsonUtils.getData(DefineConstants.TC_08_Product_Deactive_Active, "Sub Category Name"));
		products_Page.select_Vendor(JsonUtils.getData(DefineConstants.TC_08_Product_Deactive_Active, "Vendor Name"));
		products_Page.select_VendorSuperMarket(JsonUtils.getData(DefineConstants.TC_08_Product_Deactive_Active, "Vendor Store"));
		products_Page.select_VendorUnit(JsonUtils.getData(DefineConstants.TC_08_Product_Deactive_Active, "Vendor Unit"));
		products_Page.upload_Image(JsonUtils.getData(DefineConstants.TC_08_Product_Deactive_Active, "Image Name"));
		products_Page.enter_ProductDescription(JsonUtils.getData(DefineConstants.TC_08_Product_Deactive_Active, "Product Description"));
		products_Page.enter_ProductCurrentPrice(JsonUtils.getData(DefineConstants.TC_08_Product_Deactive_Active, "Current Price"));
		products_Page.enter_ProductPreviousPrice(JsonUtils.getData(DefineConstants.TC_08_Product_Deactive_Active, "Previous Price"));
		products_Page.enter_ProductStock(JsonUtils.getData(DefineConstants.TC_08_Product_Deactive_Active, "Stock"));
		products_Page.enter_ReturnPolicy(JsonUtils.getData(DefineConstants.TC_08_Product_Deactive_Active, "Return Policy"));
		products_Page.click_Add_Feature_Products();
		products_Page.enter_CommissionRate(JsonUtils.getData(DefineConstants.TC_04_Admin_Products_Add_New_Products, "Commission Rate"));
		products_Page.click_Add_New_Products_Button();
		products_Page.verify_SuccessMessage(JsonUtils.getData(DefineConstants.TC_08_Product_Deactive_Active, "Success Message"));
		
		//Deactivate Product
		products_Page.searchProduct(JsonUtils.getData(DefineConstants.TC_08_Product_Deactive_Active, "Product Name"));
		products_Page.verifyInputValue(JsonUtils.getData(DefineConstants.TC_08_Product_Deactive_Active, "Product Name"));
		products_Page.click_Deactivate_Products(JsonUtils.getData(DefineConstants.TC_08_Product_Deactive_Active, "Product Name"));
		products_Page.verify_SuccessMessageDeactivate(JsonUtils.getData(DefineConstants.TC_08_Product_Deactive_Active, "Success Message Deactivate"));
		products_Page.searchProduct(JsonUtils.getData(DefineConstants.TC_08_Product_Deactive_Active, "Product Name"));
		products_Page.verifyInputValue(JsonUtils.getData(DefineConstants.TC_08_Product_Deactive_Active, "Status"));
	
	}
}
