package com.kisaan.admin.testcases;

import java.util.Random;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kisaan.admin.pageobjects.Profile_Page;
import com.kisaan.admin.pageobjects.Testimonial_Section;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;

public class TC_55_Admin_Testimonial_TestimonialTitle extends BaseClass {
	
	Testimonial_Section testimonial_Section;
	Profile_Page profile_page;
	

	@Test(enabled = true)
	public void admin_TestimonialTitle() throws InterruptedException {
		
		test = extent.createTest("TC_55_Admin_Testimonial_TestimonialTitle", "Admin should be able to add Testimonial Title");
	
		testimonial_Section=new Testimonial_Section(driver, test);
		profile_page=new Profile_Page(driver, test);
		
		driver.get(DefineConstants.KISAAN_Admin_URL);
		profile_page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_55_Admin_Testimonial_TestimonialTitle, "Admin Email Id"));	
		profile_page.enter_Password(JsonUtils.getData(DefineConstants.TC_55_Admin_Testimonial_TestimonialTitle, "Admin Password"));
		profile_page.click_LogIN_Button();

	
		testimonial_Section.click_TestimonialSection_Tab();
		testimonial_Section.click_TestimonialSectionTitle();
		testimonial_Section.enter_TestimonialTitle(JsonUtils.getData(DefineConstants.TC_55_Admin_Testimonial_TestimonialTitle, "Testimonial Title"));
		testimonial_Section.enter_TestimonialText(JsonUtils.getData(DefineConstants.TC_55_Admin_Testimonial_TestimonialTitle, "Testimonial Text"));
		testimonial_Section.click_UpdateTestimonialSectionTitle();
		testimonial_Section.verify_SuccessMessage(JsonUtils.getData(DefineConstants.TC_55_Admin_Testimonial_TestimonialTitle, "Success Message"));
		
	}

}
