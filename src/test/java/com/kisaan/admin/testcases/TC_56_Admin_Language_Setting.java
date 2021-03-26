package com.kisaan.admin.testcases;

import org.testng.annotations.Test;

import com.kisaan.admin.pageobjects.Language_Setting_Page;
import com.kisaan.admin.pageobjects.Profile_Page;
import com.kisaan.admin.pageobjects.Testimonial_Section;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;

public class TC_56_Admin_Language_Setting extends BaseClass{
	
	Profile_Page profile_page;
	Language_Setting_Page language_page;
	

	@Test(enabled = true)
	public void admin_Language_Setting() throws InterruptedException {
		
		test = extent.createTest("TC_56_Admin_Language_Setting", "Admin should be able to add Language Setting");
	
		profile_page=new Profile_Page(driver, test);
		language_page=new Language_Setting_Page(driver, test);
		
		driver.get(DefineConstants.KISAAN_Admin_URL);
		profile_page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "Admin Email Id"));	
		profile_page.enter_Password(JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "Admin Password"));
		profile_page.click_LogIN_Button();
		
		language_page.click_LanguageSetting();
		language_page.enterText("Home",language_page.getWebElement("Home"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "Home"));
		language_page.enterText("About Us", language_page.getWebElement("About_Us"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "About_Us"));
		language_page.enterText("Contact Us", language_page.getWebElement("Contact_Us"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "Contact_Us"));
		language_page.enterText("FAQ", language_page.getWebElement("FAQ"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "FAQ"));
		language_page.enterText("Search", language_page.getWebElement("Search"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "Search"));
		language_page.enterText("Vendor", language_page.getWebElement("Vendor"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "Vendor"));
		language_page.enterText("SignIn", language_page.getWebElement("SignIn"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "SignIn"));
		language_page.enterText("My_Account", language_page.getWebElement("My_Account"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "My_Account"));
		language_page.enterText("My_Cart", language_page.getWebElement("My_Cart"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "My_Cart"));
		language_page.enterText("View_Cart", language_page.getWebElement("View_Cart"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "View_Cart"));
		language_page.enterText("Checkout", language_page.getWebElement("Checkout"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "Checkout"));
		language_page.enterText("Continue_Shopping", language_page.getWebElement("Continue_Shopping"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "Continue_Shopping"));
		language_page.enterText("Proceed_To_Checkout", language_page.getWebElement("Proceed_To_Checkout"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "Proceed_To_Checkout"));
		language_page.enterText("Empty_Cart", language_page.getWebElement("Empty_Cart"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "Empty_Cart"));
		language_page.enterText("Ship_To_Different_Address", language_page.getWebElement("Ship_To_Different_Address"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "Ship_To_Different_Address"));
		language_page.enterText("Pickup_Datails", language_page.getWebElement("Pickup_Datails"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "Pickup_Datails"));
		language_page.enterText("Top_Category", language_page.getWebElement("Top_Category"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "Top_Category"));
		language_page.enterText("Featured_Products", language_page.getWebElement("Featured_Products"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "Featured_Products"));
		language_page.enterText("Latest_Products", language_page.getWebElement("Latest_Products"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "Latest_Products"));
		language_page.enterText("Popular_Products", language_page.getWebElement("Popular_Products"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "Popular_Products"));
		language_page.enterText("Product_Name", language_page.getWebElement("Product_Name"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "Product_Name"));
		language_page.enterText("Unit_Price", language_page.getWebElement("Unit_Price"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "Unit_Price"));
		language_page.enterText("Sub_Total", language_page.getWebElement("Sub_Total"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "Sub_Total"));
		language_page.enterText("Total", language_page.getWebElement("Total"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "Total"));
		language_page.enterText("Quality", language_page.getWebElement("Quality"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "Quality"));
		language_page.enterText("Add_To_Card", language_page.getWebElement("Add_To_Card"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "Add_To_Card"));
		language_page.enterText("Out_Of_Stock", language_page.getWebElement("Out_Of_Stock"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "Out_Of_Stock"));
		language_page.enterText("Available", language_page.getWebElement("Available"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "Available"));
		language_page.enterText("Reviews", language_page.getWebElement("Reviews"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "Reviews"));
		language_page.enterText("Related_Products", language_page.getWebElement("Related_Products"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "Related_Products"));
		language_page.enterText("Return_Policy", language_page.getWebElement("Return_Policy"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "Return_Policy"));
		language_page.enterText("No_Review", language_page.getWebElement("No_Review"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "No_Review"));
		language_page.enterText("Write_a_Review", language_page.getWebElement("Write_a_Review"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "Write_a_Review"));
		language_page.enterText("Subscription", language_page.getWebElement("Subscription"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "Subscription"));
		language_page.enterText("Subscribe", language_page.getWebElement("Subscribe"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "Subscribe"));
		language_page.enterText("Address", language_page.getWebElement("Address"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "Address"));
		language_page.enterText("Added_To_Card", language_page.getWebElement("Added_To_Card"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "Added_To_Card"));
		language_page.enterText("Description", language_page.getWebElement("Description"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "Description"));
		language_page.enterText("Share_In_Social", language_page.getWebElement("Share_In_Social"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "Share_In_Social"));
		language_page.enterText("Search_Result", language_page.getWebElement("Search_Result"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "Search_Result"));
		language_page.enterText("No_Products_Found", language_page.getWebElement("No_Products_Found"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "No_Products_Found"));
		language_page.enterText("Contact_Us_Greetings", language_page.getWebElement("Contact_Us_Greetings"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "Contact_Us_Greetings"));
		language_page.enterText("Filter_Option", language_page.getWebElement("Filter_Option"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "Filter_Option"));
		language_page.enterText("All_Categories", language_page.getWebElement("All_Categories"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "All_Categories"));
		language_page.enterText("Load_More", language_page.getWebElement("Load_More"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "Load_More"));
		language_page.enterText("Sort_By_Latest_Products", language_page.getWebElement("Sort_By_Latest_Products"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "Sort_By_Latest_Products"));
		language_page.enterText("Sort_By_Oldest_Products", language_page.getWebElement("Sort_By_Oldest_Products"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "Sort_By_Oldest_Products"));
		language_page.enterText("Sort_By_Highest_Price", language_page.getWebElement("Sort_By_Highest_Price"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "Sort_By_Highest_Price"));
		language_page.enterText("Sort_By_Lowest_Price", language_page.getWebElement("Sort_By_Lowest_Price"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "Sort_By_Lowest_Price"));
		language_page.enterText("Street_Address", language_page.getWebElement("Street_Address"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "Street_Address"));
		language_page.enterText("Phone", language_page.getWebElement("Phone"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "Phone"));
		language_page.enterText("Email", language_page.getWebElement("Email"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "Email"));
		language_page.enterText("Fax", language_page.getWebElement("Fax"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "Fax"));
		language_page.enterText("Name", language_page.getWebElement("Name"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "Name"));
		language_page.enterText("Review_Details", language_page.getWebElement("Review_Details"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "Review_Details"));
		language_page.enterText("Order_Details", language_page.getWebElement("Order_Details"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "Order_Details"));
		language_page.enterText("Enter_Shipping_Details", language_page.getWebElement("Enter_Shipping_Details"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "Enter_Shipping_Details"));
		language_page.enterText("Shipping_Cost", language_page.getWebElement("Shipping_Cost"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "Shipping_Cost"));
		language_page.enterText("Order_Now", language_page.getWebElement("Order_Now"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "Order_Now"));
		language_page.enterText("View_Details", language_page.getWebElement("View_Details"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "View_Details"));
		language_page.enterText("Quick_Review", language_page.getWebElement("Quick_Review"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "Quick_Review"));
		language_page.enterText("Submit", language_page.getWebElement("Submit"), JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "Submit"));
		
		language_page.click_UpdateLanguageSetting();
		language_page.verify_SuccessMessage(JsonUtils.getData(DefineConstants.TC_56_Admin_Language_Setting, "Success Message"));
	
	}

}
