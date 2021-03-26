package com.kisaan.admin.testcases;

import java.util.Random;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kisaan.admin.pageobjects.Profile_Page;
import com.kisaan.admin.pageobjects.Slider_Setting_Page;
import com.kisaan.admin.pageobjects.Testimonial_Section;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;

public class TC_29_Admin_Testimonial_AddTestimonial extends BaseClass {
	
	Testimonial_Section testimonial_Section;
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
		JsonUtils.setData("Client Name", generatedString, DefineConstants.TC_29_Admin_Testimonial_AddTestimonial);
		
	}

	@Test(enabled = true)
	public void admin_AddTestimonial() throws InterruptedException {
		
		test = extent.createTest("TC_29_Admin_Testimonial_AddTestimonial", "Admin should be able to add Testimonial");
	
		testimonial_Section=new Testimonial_Section(driver, test);
		profile_page=new Profile_Page(driver, test);
		
		driver.get(DefineConstants.KISAAN_Admin_URL);
		profile_page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_29_Admin_Testimonial_AddTestimonial, "Admin Email Id"));	
		profile_page.enter_Password(JsonUtils.getData(DefineConstants.TC_29_Admin_Testimonial_AddTestimonial, "Admin Password"));
		profile_page.click_LogIN_Button();

		//Add Testimonial
		testimonial_Section.click_TestimonialSection_Tab();
		testimonial_Section.click_AddTestimonial();
		testimonial_Section.enter_ClientReview(JsonUtils.getData(DefineConstants.TC_29_Admin_Testimonial_AddTestimonial, "Client Review"));
		testimonial_Section.enter_ClientName(JsonUtils.getData(DefineConstants.TC_29_Admin_Testimonial_AddTestimonial, "Client Name"));
		testimonial_Section.enter_ClientDesignation(JsonUtils.getData(DefineConstants.TC_29_Admin_Testimonial_AddTestimonial, "Client Designation"));
		testimonial_Section.click_AddTestimonialButton();
		testimonial_Section.verify_SuccessMessage(JsonUtils.getData(DefineConstants.TC_29_Admin_Testimonial_AddTestimonial, "Success Message"));
		testimonial_Section.searchClientName(JsonUtils.getData(DefineConstants.TC_29_Admin_Testimonial_AddTestimonial, "Client Name"));
		testimonial_Section.verifyInputValue(JsonUtils.getData(DefineConstants.TC_29_Admin_Testimonial_AddTestimonial, "Client Name"));
	
	}
}
