package com.kisaan.admin.testcases;

import java.util.Random;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kisaan.admin.pageobjects.Profile_Page;
import com.kisaan.admin.pageobjects.Slider_Setting_Page;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;

public class TC_28_Admin_SliderSetting_RemoveSlider extends BaseClass{
	Slider_Setting_Page slider_Setting_Page;
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
		JsonUtils.setData("Slider Title", generatedString+" Slider Title", DefineConstants.TC_28_Admin_SliderSetting_RemoveSlider);
		JsonUtils.setData("Slider Text", generatedString+" Slider Text", DefineConstants.TC_28_Admin_SliderSetting_RemoveSlider);
		
	}

	@Test(enabled = true)
	public void admin_RemoveSlider() throws InterruptedException {
		
		test = extent.createTest("TC_28_Admin_SliderSetting_RemoveSlider", "Admin should be able to delete Slider");
	
		slider_Setting_Page=new Slider_Setting_Page(driver, test);
		profile_page=new Profile_Page(driver, test);
		
		driver.get(DefineConstants.KISAAN_Admin_URL);
		profile_page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_28_Admin_SliderSetting_RemoveSlider, "Admin Email Id"));	
		profile_page.enter_Password(JsonUtils.getData(DefineConstants.TC_28_Admin_SliderSetting_RemoveSlider, "Admin Password"));
		profile_page.click_LogIN_Button();
		
		//Add Slider
		slider_Setting_Page.click_SliderSetting_Tab();
		slider_Setting_Page.click_Add_New_Slider();
		slider_Setting_Page.upload_Image(JsonUtils.getData(DefineConstants.TC_28_Admin_SliderSetting_RemoveSlider, "Image Name"));
		slider_Setting_Page.enter_SliderTitle(JsonUtils.getData(DefineConstants.TC_28_Admin_SliderSetting_RemoveSlider, "Slider Title"));
		slider_Setting_Page.enter_SliderText(JsonUtils.getData(DefineConstants.TC_28_Admin_SliderSetting_RemoveSlider, "Slider Text"));
		slider_Setting_Page.select_SliderPosition(JsonUtils.getData(DefineConstants.TC_28_Admin_SliderSetting_RemoveSlider, "Slider Position"));
		slider_Setting_Page.click_AddSliderButton();
		slider_Setting_Page.verify_SuccessMessage(JsonUtils.getData(DefineConstants.TC_28_Admin_SliderSetting_RemoveSlider, "Success Message"));
		slider_Setting_Page.searchSlider(JsonUtils.getData(DefineConstants.TC_28_Admin_SliderSetting_RemoveSlider, "Slider Title"));
		slider_Setting_Page.verifyInputValue(JsonUtils.getData(DefineConstants.TC_28_Admin_SliderSetting_RemoveSlider, "Slider Title"));
		
		//Delete Slider
		slider_Setting_Page.click_RemoveSlider(JsonUtils.getData(DefineConstants.TC_28_Admin_SliderSetting_RemoveSlider, "Slider Title"));
		slider_Setting_Page.verify_SuccessMessage(JsonUtils.getData(DefineConstants.TC_28_Admin_SliderSetting_RemoveSlider, "Success Message Delete"));
		slider_Setting_Page.searchSlider(JsonUtils.getData(DefineConstants.TC_28_Admin_SliderSetting_RemoveSlider, "Slider Title"));
		slider_Setting_Page.verifyInputValueDelete(JsonUtils.getData(DefineConstants.TC_28_Admin_SliderSetting_RemoveSlider, "Slider Title"));
		
	}
}
