package com.kisaan.admin.testcases;

import java.util.Random;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kisaan.admin.pageobjects.Profile_Page;
import com.kisaan.admin.pageobjects.Slider_Setting_Page;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;

public class TC_27_Admin_SliderSetting_EditSlider extends BaseClass{
	
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
		JsonUtils.setData("Slider Title", generatedString+" Slider Title", DefineConstants.TC_27_Admin_SliderSetting_EditSlider);
		JsonUtils.setData("Slider Text", generatedString+" Slider Text", DefineConstants.TC_27_Admin_SliderSetting_EditSlider);
		JsonUtils.setData("Slider Title Edited", generatedString+" Slider Title Edited", DefineConstants.TC_27_Admin_SliderSetting_EditSlider);
		JsonUtils.setData("Slider Text Edited", generatedString+" Slider Text Edited", DefineConstants.TC_27_Admin_SliderSetting_EditSlider);
	}

	@Test(enabled = true)
	public void admin_EditSlider() throws InterruptedException {
		
		test = extent.createTest("TC_27_Admin_SliderSetting_EditSlider", "Admin should be able to edit Slider");
	
		slider_Setting_Page=new Slider_Setting_Page(driver, test);
		profile_page=new Profile_Page(driver, test);
		
		driver.get(DefineConstants.KISAAN_Admin_URL);
		profile_page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_27_Admin_SliderSetting_EditSlider, "Admin Email Id"));	
		profile_page.enter_Password(JsonUtils.getData(DefineConstants.TC_27_Admin_SliderSetting_EditSlider, "Admin Password"));
		profile_page.click_LogIN_Button();
		
		//Add Slider
		slider_Setting_Page.click_SliderSetting_Tab();
		slider_Setting_Page.click_Add_New_Slider();
		slider_Setting_Page.upload_Image(JsonUtils.getData(DefineConstants.TC_27_Admin_SliderSetting_EditSlider, "Image Name"));
	//	slider_Setting_Page.enter_SliderTitle(JsonUtils.getData(DefineConstants.TC_27_Admin_SliderSetting_EditSlider, "Slider Title"));
	//	slider_Setting_Page.enter_SliderText(JsonUtils.getData(DefineConstants.TC_27_Admin_SliderSetting_EditSlider, "Slider Text"));
		slider_Setting_Page.select_SliderPosition(JsonUtils.getData(DefineConstants.TC_27_Admin_SliderSetting_EditSlider, "Slider Position"));
		slider_Setting_Page.click_AddSliderButton();
		slider_Setting_Page.verify_SuccessMessage(JsonUtils.getData(DefineConstants.TC_27_Admin_SliderSetting_EditSlider, "Success Message"));
	//	slider_Setting_Page.searchSlider(JsonUtils.getData(DefineConstants.TC_27_Admin_SliderSetting_EditSlider, "Slider Title"));
	//	slider_Setting_Page.verifyInputValue(JsonUtils.getData(DefineConstants.TC_27_Admin_SliderSetting_EditSlider, "Slider Title"));
		
		//Edit Slider
		slider_Setting_Page.click_EditSlider(JsonUtils.getData(DefineConstants.TC_27_Admin_SliderSetting_EditSlider, "Slider Title"));
		slider_Setting_Page.enter_SliderTitle(JsonUtils.getData(DefineConstants.TC_27_Admin_SliderSetting_EditSlider, "Slider Title Edited"));
		slider_Setting_Page.enter_SliderText(JsonUtils.getData(DefineConstants.TC_27_Admin_SliderSetting_EditSlider, "Slider Text Edited"));
		slider_Setting_Page.select_SliderPosition(JsonUtils.getData(DefineConstants.TC_27_Admin_SliderSetting_EditSlider, "Slider Position Edited"));
		slider_Setting_Page.click_AddSliderButton();
		slider_Setting_Page.verify_SuccessMessage(JsonUtils.getData(DefineConstants.TC_27_Admin_SliderSetting_EditSlider, "Success Message Edited"));
		slider_Setting_Page.searchSlider(JsonUtils.getData(DefineConstants.TC_27_Admin_SliderSetting_EditSlider, "Slider Title Edited"));
		slider_Setting_Page.verifyInputValue(JsonUtils.getData(DefineConstants.TC_27_Admin_SliderSetting_EditSlider, "Slider Title Edited"));
	}


}
