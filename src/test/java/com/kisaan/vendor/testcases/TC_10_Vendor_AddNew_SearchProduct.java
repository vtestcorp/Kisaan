package com.kisaan.vendor.testcases;

import java.util.Random;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kisaan.customer.pageobjects.HomePage;
import com.kisaan.customer.pageobjects.SignIn_Page;
import com.kisaan.vendor.pageobjects.Products_Page;
import com.kisaan.vendor.pageobjects.VendorDashboard_Page;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;

public class TC_10_Vendor_AddNew_SearchProduct extends BaseClass {

	HomePage homePage;
	SignIn_Page signIn_Page;
	VendorDashboard_Page  vendorDashboard_Page;
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
		//JsonUtils.setData("Email Address", generatedString+"@gmail.com", DefineConstants.TC_01_Vendor_SignUp);
		JsonUtils.setData("Product Name", "Carrots "+generatedString, DefineConstants.TC_10_Vendor_AddNew_SearchProduct);
	}


	@Test(enabled = true)
	public void vendor_SignIn() throws Exception {

		test = extent.createTest("TC_10_Vendor_AddNew_SearchProduct", "Vendor should be able to add and search products");

		homePage = new HomePage(driver, test);
		signIn_Page = new SignIn_Page(driver, test); 
		vendorDashboard_Page = new VendorDashboard_Page(driver, test);
		products_Page = new Products_Page(driver, test);
		
		driver.get(DefineConstants.KISAAN_URL);
		homePage.click_Vendor_Link();
		signIn_Page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_10_Vendor_AddNew_SearchProduct, "Email Address"));	
		signIn_Page.enter_Password(JsonUtils.getData(DefineConstants.TC_10_Vendor_AddNew_SearchProduct, "Password"));
		signIn_Page.click_LogIN_Button();
		vendorDashboard_Page.verfiy_MyDashboard();		
		vendorDashboard_Page.click_ProductsLink();
		products_Page.click_AddNewProductButton();
		products_Page.enter_ProductName(JsonUtils.getData(DefineConstants.TC_10_Vendor_AddNew_SearchProduct, "Product Name"));
		products_Page.select_MainCategory(JsonUtils.getData(DefineConstants.TC_10_Vendor_AddNew_SearchProduct, "Product Category"));
		products_Page.select_SubCategory(JsonUtils.getData(DefineConstants.TC_10_Vendor_AddNew_SearchProduct, "Sub Category"));
		products_Page.select_SuperMarket(JsonUtils.getData(DefineConstants.TC_10_Vendor_AddNew_SearchProduct, "Store Name"));
		products_Page.select_VendorUnit(JsonUtils.getData(DefineConstants.TC_10_Vendor_AddNew_SearchProduct, "Unit"));
		products_Page.upload_Image(JsonUtils.getData(DefineConstants.TC_10_Vendor_AddNew_SearchProduct, "Image Name"));
		products_Page.enter_ProductDescription(JsonUtils.getData(DefineConstants.TC_10_Vendor_AddNew_SearchProduct, "Product Description"));
		products_Page.enter_ProductCurrentPrice(JsonUtils.getData(DefineConstants.TC_10_Vendor_AddNew_SearchProduct, "Product Current Price"));
		products_Page.enter_ProductPreviousPrice(JsonUtils.getData(DefineConstants.TC_10_Vendor_AddNew_SearchProduct, "Product Previous Price"));
		products_Page.enter_ProductStock(JsonUtils.getData(DefineConstants.TC_10_Vendor_AddNew_SearchProduct, "Product Stock"));
		products_Page.enter_ProductBuyReturnPolicy(JsonUtils.getData(DefineConstants.TC_10_Vendor_AddNew_SearchProduct, "Product Return Policy"));
		products_Page.enter_ProductTags(JsonUtils.getData(DefineConstants.TC_10_Vendor_AddNew_SearchProduct, "Product Tags"));
		products_Page.click_LastAddNewProductButton();
		products_Page.verify_SuccessMessage();
		products_Page.searchProductName(JsonUtils.getData(DefineConstants.TC_10_Vendor_AddNew_SearchProduct, "Product Name"));
		products_Page.verifyProduct(JsonUtils.getData(DefineConstants.TC_10_Vendor_AddNew_SearchProduct, "Product Name"));
	}	
}