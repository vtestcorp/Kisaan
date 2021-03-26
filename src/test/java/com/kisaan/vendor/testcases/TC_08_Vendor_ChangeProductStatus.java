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

public class TC_08_Vendor_ChangeProductStatus extends BaseClass {

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
		JsonUtils.setData("Product Name", "Carrots "+generatedString, DefineConstants.TC_08_Vendor_ChangeProductStatus);
	}

	@Test(enabled = true)
	public void vendor_SignIn() throws Exception {

		test = extent.createTest("TC_08_Vendor_ChangeProductStatus", "Vendor should be able to add and change product status");

		homePage = new HomePage(driver, test);
		signIn_Page = new SignIn_Page(driver, test); 
		vendorDashboard_Page = new VendorDashboard_Page(driver, test);
		products_Page = new Products_Page(driver, test);
		
		driver.get(DefineConstants.KISAAN_URL);
		homePage.click_Vendor_Link();
		signIn_Page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_08_Vendor_ChangeProductStatus, "Email Address"));	
		signIn_Page.enter_Password(JsonUtils.getData(DefineConstants.TC_08_Vendor_ChangeProductStatus, "Password"));
		signIn_Page.click_LogIN_Button();
		vendorDashboard_Page.verfiy_MyDashboard();		
		vendorDashboard_Page.click_ProductsLink();
		products_Page.click_AddNewProductButton();
		products_Page.enter_ProductName(JsonUtils.getData(DefineConstants.TC_08_Vendor_ChangeProductStatus, "Product Name"));
		products_Page.select_MainCategory(JsonUtils.getData(DefineConstants.TC_08_Vendor_ChangeProductStatus, "Product Category"));
		products_Page.select_SubCategory(JsonUtils.getData(DefineConstants.TC_08_Vendor_ChangeProductStatus, "Sub Category"));
		products_Page.select_SuperMarket(JsonUtils.getData(DefineConstants.TC_08_Vendor_ChangeProductStatus, "Store Name"));
		products_Page.select_VendorUnit(JsonUtils.getData(DefineConstants.TC_08_Vendor_ChangeProductStatus, "Unit"));
		products_Page.upload_Image(JsonUtils.getData(DefineConstants.TC_08_Vendor_ChangeProductStatus, "Image Name"));
		products_Page.enter_ProductDescription(JsonUtils.getData(DefineConstants.TC_08_Vendor_ChangeProductStatus, "Product Description"));
		products_Page.enter_ProductCurrentPrice(JsonUtils.getData(DefineConstants.TC_08_Vendor_ChangeProductStatus, "Product Current Price"));
		products_Page.enter_ProductPreviousPrice(JsonUtils.getData(DefineConstants.TC_08_Vendor_ChangeProductStatus, "Product Previous Price"));
		products_Page.enter_ProductStock(JsonUtils.getData(DefineConstants.TC_08_Vendor_ChangeProductStatus, "Product Stock"));
		products_Page.enter_ProductBuyReturnPolicy(JsonUtils.getData(DefineConstants.TC_08_Vendor_ChangeProductStatus, "Product Return Policy"));
		products_Page.enter_ProductTags(JsonUtils.getData(DefineConstants.TC_08_Vendor_ChangeProductStatus, "Product Tags"));
		products_Page.click_LastAddNewProductButton();
		products_Page.verify_SuccessMessage();
		
		// Change Product Status
		products_Page.searchProductName(JsonUtils.getData(DefineConstants.TC_08_Vendor_ChangeProductStatus, "Product Name"));
		products_Page.verifyProduct(JsonUtils.getData(DefineConstants.TC_08_Vendor_ChangeProductStatus, "Product Name"));
		products_Page.changeProductStatus(JsonUtils.getData(DefineConstants.TC_08_Vendor_ChangeProductStatus, "Product Name"));
		products_Page.verify_SuccessMessage();
		products_Page.checkProductStatus(JsonUtils.getData(DefineConstants.TC_08_Vendor_ChangeProductStatus, "Product Name"));
	}	
}