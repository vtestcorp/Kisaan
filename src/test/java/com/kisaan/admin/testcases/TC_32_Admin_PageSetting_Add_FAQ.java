package com.kisaan.admin.testcases;

import java.awt.AWTException;
import java.util.Random;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kisaan.admin.pageobjects.Page_Setting;
import com.kisaan.admin.pageobjects.Profile_Page;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;
import helperMethods.ScrollTypes;

public class TC_32_Admin_PageSetting_Add_FAQ extends BaseClass{
	
	Page_Setting page_Setting;
	Profile_Page profile_page;
	ScrollTypes scroll;
	
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
		JsonUtils.setData("Question","FAQ Question "+generatedString, DefineConstants.TC_32_Admin_PageSetting_Add_FAQ);
	}

	@Test(enabled = true)
	public void admin_AddFAQ() throws InterruptedException, AWTException {
		
		test = extent.createTest("TC_32_Admin_PageSetting_Add_FAQ", "Admin should be able to Add FAQ in page Setting tab");
	
		profile_page=new Profile_Page(driver, test);
		page_Setting=new Page_Setting(driver, test);
		scroll=new ScrollTypes(driver);
		
		driver.get(DefineConstants.KISAAN_Admin_URL);
		profile_page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_32_Admin_PageSetting_Add_FAQ, "Admin Email Id"));	
		profile_page.enter_Password(JsonUtils.getData(DefineConstants.TC_32_Admin_PageSetting_Add_FAQ, "Admin Password"));
		profile_page.click_LogIN_Button();
		
		scroll.scrollInToView(page_Setting.page_Setting());
		page_Setting.click_Page_Setting_Tab();
		page_Setting.enableDisableButtonFAQ(JsonUtils.getData(DefineConstants.TC_32_Admin_PageSetting_Add_FAQ, "Yes"));
		page_Setting.click_Apply();
		page_Setting.verify_SuccessMessage(JsonUtils.getData(DefineConstants.TC_32_Admin_PageSetting_Add_FAQ, "Success Message Update"));
		page_Setting.click_Add_NewFAQ();
		page_Setting.enter_QuestionFAQ(JsonUtils.getData(DefineConstants.TC_32_Admin_PageSetting_Add_FAQ, "Question"));
		page_Setting.enter_AnswerFAQ(JsonUtils.getData(DefineConstants.TC_32_Admin_PageSetting_Add_FAQ, "Answer"));
		page_Setting.click_Add_NewFAQButton();
		page_Setting.verify_SuccessMessage(JsonUtils.getData(DefineConstants.TC_32_Admin_PageSetting_Add_FAQ, "Success Message"));
		page_Setting.searchFAQName(JsonUtils.getData(DefineConstants.TC_32_Admin_PageSetting_Add_FAQ, "Question"));
		page_Setting.verifyInputValue(JsonUtils.getData(DefineConstants.TC_32_Admin_PageSetting_Add_FAQ, "Question"));
	}
}
