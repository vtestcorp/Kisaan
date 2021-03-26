package config;

public class DefineConstants {
	// Test data file Path
	public static final String Path_TestData = "";

	// Application URL
	//public static final String KISAAN_URL = "http://grocery-delivery.devwepro.com/";
	
	// New Application URL
	public static final String KISAAN_URL = "http://www.kisaansquad.com/";
	
	//Admin Portal
//	public static final String KISAAN_Admin_URL = "http://grocery-delivery.devwepro.com/admin";

	// New Admin Portal
	public static final String KISAAN_Admin_URL = "http://www.kisaansquad.com/admin";
		
//	 http://p5beta.plumb5.com/p5-newdesign/manage-campaigns.html
	
	// Explicit Wait Time
	public static final int explicitWait_10 = 10;
	
	public static final int explicitWait_20 = 20;
	
	public static final int explicitWait_30 = 30;

	public static final int explicitWait_60 = 60;

	public static final String PROJECT_PATH = System.getProperty("user.dir")+"/";

	public static final String PROJECT_OS = System.getProperty("os.name");

	public static final String TestData_Folder = "Test_Data";
	
	public static final String Customer_TestData_Folder = "Customer";
	
	public static final String Vendor_TestData_Folder = "Vendor";
	
	public static final String Admin_TestData_Folder = "Admin";
	
	public static final String Successfull_Added_To_Cart = "Successfully Added To Cart";
		
	
	//Customer
	public static final String TC_01_Customer_SignUp = TestData_Folder + "//" + Customer_TestData_Folder + "//" + "TC_01_Customer_SignUp.json";
	public static final String TC_02_Customer_SignIn = TestData_Folder + "//" + Customer_TestData_Folder + "//" + "TC_02_Customer_SignIn.json";
	public static final String TC_03_Customer_SearchProduct = TestData_Folder + "//" + Customer_TestData_Folder + "//" + "TC_03_Customer_SearchProduct.json";
	public static final String TC_04_Customer_AddProductToCart = TestData_Folder + "//" + Customer_TestData_Folder + "//" + "TC_04_Customer_AddProductToCart.json";
	public static final String TC_05_Customer_DeleteProductFromCart = TestData_Folder + "//" + Customer_TestData_Folder + "//" + "TC_05_Customer_DeleteProductFromCart.json";
	public static final String TC_06_Customer_UpdateProductQuantity = TestData_Folder + "//" + Customer_TestData_Folder + "//" + "TC_06_Customer_UpdateProductQuantity.json";
	public static final String TC_07_Customer_AddProductCheckout = TestData_Folder + "//" + Customer_TestData_Folder + "//" + "TC_07_Customer_AddProductCheckout.json";
	public static final String TC_08_EditAddress = TestData_Folder + "//" + Customer_TestData_Folder + "//" + "TC_08_EditAddress.json";
	public static final String TC_09_ChangeExistingPassword = TestData_Folder + "//" + Customer_TestData_Folder + "//" + "TC_09_ChangeExistingPassword.json";
	public static final String TC_10_FilterProducts_Categories = TestData_Folder + "//" + Customer_TestData_Folder + "//" + "TC_10_FilterProducts_Categories.json";
	public static final String TC_11_Customer_PlaceOrderMultipleProducts = TestData_Folder + "//" + Customer_TestData_Folder + "//" + "TC_11_Customer_PlaceOrderMultipleProducts.json";
	public static final String TC_12_Customer_SignOut = TestData_Folder + "//" + Customer_TestData_Folder + "//" + "TC_12_Customer_SignOut.json";
	public static final String TC_13_VerifyFacebook_Link = TestData_Folder + "//" + Customer_TestData_Folder + "//" + "TC_13_VerifyFacebook_Link.json";
	public static final String TC_14_VerifyGoogle_Link = TestData_Folder + "//" + Customer_TestData_Folder + "//" + "TC_14_VerifyGoogle_Link.json";
	public static final String TC_15_VerifyTwitter_Link = TestData_Folder + "//" + Customer_TestData_Folder + "//" + "TC_15_VerifyTwitter_Link.json";
	public static final String TC_16_VerifyLinkedin_Link = TestData_Folder + "//" + Customer_TestData_Folder + "//" + "TC_16_VerifyLinkedin_Link.json";
	public static final String TC_17_Customer_AddProduct_PickUp_Checkout = TestData_Folder + "//" + Customer_TestData_Folder + "//" + "TC_17_Customer_AddProduct_PickUp_Checkout.json";
	public static final String TC_18_Customer_CreditCard_Checkout = TestData_Folder + "//" + Customer_TestData_Folder + "//" + "TC_18_Customer_CreditCard_Checkout.json";
	public static final String TC_19_Customer_MobileMoney_Checkout = TestData_Folder + "//" + Customer_TestData_Folder + "//" + "TC_19_Customer_MobileMoney_Checkout.json";
	public static final String TC_20_Customer_BankWire_Checkout = TestData_Folder + "//" + Customer_TestData_Folder + "//" + "TC_20_Customer_BankWire_Checkout.json";
	public static final String TC_21_Customer_ShipToDifferentAddress = TestData_Folder + "//" + Customer_TestData_Folder + "//" + "TC_21_Customer_ShipToDifferentAddress.json";
	
	// Vendor
	public static final String TC_01_Vendor_SignUp = TestData_Folder + "//" + Vendor_TestData_Folder + "//" + "TC_01_Vendor_SignUp.json";
	public static final String TC_02_Vendor_SignIn = TestData_Folder + "//" + Vendor_TestData_Folder + "//" + "TC_02_Vendor_SignIn.json";
	public static final String TC_03_VendorDashboardAccordion = TestData_Folder + "//" + Vendor_TestData_Folder + "//" + "TC_03_VendorDashboardAccordion.json";
	public static final String TC_04_EditVendorProfile = TestData_Folder + "//" + Vendor_TestData_Folder + "//" + "TC_04_EditVendorProfile.json";
	public static final String TC_05_VendorChangeExistingPassword = TestData_Folder + "//" + Vendor_TestData_Folder + "//" + "TC_05_VendorChangeExistingPassword.json";
	public static final String TC_06_Vendor_AddNewProduct = TestData_Folder + "//" + Vendor_TestData_Folder + "//" + "TC_06_Vendor_AddNewProduct.json";
	public static final String TC_07_Vendor_EditProduct = TestData_Folder + "//" + Vendor_TestData_Folder + "//" + "TC_07_Vendor_EditProduct.json";
	public static final String TC_08_Vendor_ChangeProductStatus = TestData_Folder + "//" + Vendor_TestData_Folder + "//" + "TC_08_Vendor_ChangeProductStatus.json";
	public static final String TC_09_Vendor_RemoveProduct = TestData_Folder + "//" + Vendor_TestData_Folder + "//" + "TC_09_Vendor_RemoveProduct.json";
	public static final String TC_10_Vendor_AddNew_SearchProduct = TestData_Folder + "//" + Vendor_TestData_Folder + "//" + "TC_10_Vendor_AddNew_SearchProduct.json";
	public static final String TC_11_Vendor_WithdrawNow_Paypal = TestData_Folder + "//" + Vendor_TestData_Folder + "//" + "TC_11_Vendor_WithdrawNow_Paypal.json";
	public static final String TC_12_Vendor_WithdrawNow_Bank = TestData_Folder + "//" + Vendor_TestData_Folder + "//" + "TC_12_Vendor_WithdrawNow_Bank.json";
	
	//Admin
	public static final String TC_01_Admin_SignIn = TestData_Folder + "//" + Admin_TestData_Folder + "//" + "TC_01_Admin_SignIn.json";
	public static final String TC_02_Admin_Edit_Profile = TestData_Folder + "//" + Admin_TestData_Folder + "//" + "TC_02_Edit_Profile.json";
	public static final String TC_03_Admin_Logout = TestData_Folder + "//" + Admin_TestData_Folder + "//" + "TC_03_Admin_Logout.json";
	public static final String TC_04_Admin_Products_Add_New_Products = TestData_Folder + "//" + Admin_TestData_Folder + "//" + "TC_04_Admin_Products_Add_New_Products.json";
	public static final String TC_05_Admin_Products_SearchProducts = TestData_Folder + "//" + Admin_TestData_Folder + "//" + "TC_05_Admin_Products_SearchProducts.json";
	public static final String TC_06_Admin_Products_EditProducts = TestData_Folder + "//" + Admin_TestData_Folder + "//" + "TC_06_Admin_Products_EditProducts.json";
	public static final String TC_07_Admin_Products_Remove = TestData_Folder + "//" + Admin_TestData_Folder + "//" + "TC_07_Admin_Products_Remove.json";
	public static final String TC_08_Product_Deactive_Active = TestData_Folder + "//" + Admin_TestData_Folder + "//" + "TC_08_Product_Deactive_Active.json";
	public static final String TC_09_Admin_Vendors_SearchVendors = TestData_Folder + "//" + Admin_TestData_Folder + "//" + "TC_09_Admin_Vendors_SearchVendors.json";
	public static final String TC_10_Admin_Vendors_SendMail = TestData_Folder + "//" + Admin_TestData_Folder + "//" + "TC_10_Admin_Vendors_SendMail.json";
	public static final String TC_11_Admin_Vendors_RemoveVendors = TestData_Folder + "//" + Admin_TestData_Folder + "//" + "TC_11_Admin_Vendors_RemoveVendors.json";
	public static final String TC_12_Admin_Vendors_Accept = TestData_Folder + "//" + Admin_TestData_Folder + "//" + "TC_12_Admin_Vendors_Accept.json";
	public static final String TC_13_Admin_Vendors_RejectPendingVendors = TestData_Folder + "//" + Admin_TestData_Folder + "//" + "TC_13_Admin_Vendors_RejectPendingVendors.json";
	public static final String TC_14_Admin_Vendors_ViewList = TestData_Folder + "//" + Admin_TestData_Folder + "//" + "TC_14_Admin_Vendors_ViewList.json";
	public static final String TC_15_Admin_Customer_ViewDetails = TestData_Folder + "//" + Admin_TestData_Folder + "//" + "TC_15_Admin_Customer_ViewDetails.json";
	public static final String TC_16_Admin_Customer_SendMail = TestData_Folder + "//" + Admin_TestData_Folder + "//" + "TC_16_Admin_Customer_SendMail.json";
	public static final String TC_17_Admin_Customer_RemoveCustomer = TestData_Folder + "//" + Admin_TestData_Folder + "//" + "TC_17_Admin_Customer_RemoveCustomer.json";
	public static final String TC_18_Admin_Manage_Category_Add_Main_Category = TestData_Folder + "//" + Admin_TestData_Folder + "//" + "TC_18_Admin_Manage_Category_Add_Main_Category.json";
	public static final String TC_19_Admin_Manage_Category_Edit_Main_Category = TestData_Folder + "//" + Admin_TestData_Folder + "//" + "TC_19_Admin_Manage_Category_Edit_Main_Category.json";
	public static final String TC_20_Admin_Manage_Category_Remove_Main_Category = TestData_Folder + "//" + Admin_TestData_Folder + "//" + "TC_20_Admin_Manage_Category_Remove_Main_Category.json";
	public static final String TC_21_Admin_Manage_Category_Add_SubCategory = TestData_Folder + "//" + Admin_TestData_Folder + "//" + "TC_21_Admin_Manage_Category_Add_SubCategory.json";
	public static final String TC_22_Admin_Manage_Category_Edit_SubCategory = TestData_Folder + "//" + Admin_TestData_Folder + "//" + "TC_22_Admin_Manage_Category_Edit_SubCategory.json";
	public static final String TC_23_Admin_Manage_Category_Remove_SubCategory = TestData_Folder + "//" + Admin_TestData_Folder + "//" + "TC_23_Admin_Manage_Category_Remove_SubCategory.json";
	public static final String TC_24_Admin_ServiceArea_AddArea = TestData_Folder + "//" + Admin_TestData_Folder + "//" + "TC_24_Admin_ServiceArea_AddArea.json";
	public static final String TC_25_Admin_ServiceArea_EditArea = TestData_Folder + "//" + Admin_TestData_Folder + "//" + "TC_25_Admin_ServiceArea_EditArea.json";
	public static final String TC_26_Admin_SliderSetting_AddSlider = TestData_Folder + "//" + Admin_TestData_Folder + "//" + "TC_26_Admin_SliderSetting_AddSlider.json";
	public static final String TC_27_Admin_SliderSetting_EditSlider = TestData_Folder + "//" + Admin_TestData_Folder + "//" + "TC_27_Admin_SliderSetting_EditSlider.json";
	public static final String TC_28_Admin_SliderSetting_RemoveSlider = TestData_Folder + "//" + Admin_TestData_Folder + "//" + "TC_28_Admin_SliderSetting_RemoveSlider.json";
	public static final String TC_29_Admin_Testimonial_AddTestimonial = TestData_Folder + "//" + Admin_TestData_Folder + "//" + "TC_29_Admin_Testimonial_AddTestimonial.json";
	public static final String TC_30_Admin_Testimonial_Edit_Testimonial = TestData_Folder + "//" + Admin_TestData_Folder + "//" + "TC_30_Admin_Testimonial_Edit_Testimonial.json";
	public static final String TC_31_Admin_Testimonial_Remove_Testimonial = TestData_Folder + "//" + Admin_TestData_Folder + "//" + "TC_31_Admin_Testimonial_Remove_Testimonial.json";
	public static final String TC_32_Admin_PageSetting_Add_FAQ = TestData_Folder + "//" + Admin_TestData_Folder + "//" + "TC_32_Admin_PageSetting_Add_FAQ.json";
	public static final String TC_33_Admin_PageSetting_Edit_FAQ = TestData_Folder + "//" + Admin_TestData_Folder + "//" + "TC_33_Admin_PageSetting_Edit_FAQ.json";
	public static final String TC_34_Admin_PageSetting_Remove_FAQ = TestData_Folder + "//" + Admin_TestData_Folder + "//" + "TC_34_Admin_PageSetting_Remove_FAQ.json";
	public static final String TC_35_Admin_PageSetting_Add_Remove_Logo = TestData_Folder + "//" + Admin_TestData_Folder + "//" + "TC_35_Admin_PageSetting_Add_Remove_Logo.json";
	public static final String TC_36_Admin_PageSetting_Add_HomeBanners = TestData_Folder + "//" + Admin_TestData_Folder + "//" + "TC_36_Admin_PageSetting_Add_HomeBanners.json";
	public static final String TC_37_Admin_PageSetting_Edit_Banner = TestData_Folder + "//" + Admin_TestData_Folder + "//" + "TC_37_Admin_PageSetting_Edit_Banner.json";
	public static final String TC_38_Admin_PageSetting_Remove_Banner = TestData_Folder + "//" + Admin_TestData_Folder + "//" + "TC_38_Admin_PageSetting_Remove_Banner.json";
	public static final String TC_39_Admin_PageSetting_Large_HomeBanner = TestData_Folder + "//" + Admin_TestData_Folder + "//" + "TC_39_Admin_PageSetting_Large_HomeBanner.json";
	public static final String TC_40_Admin_PageSetting_About_Us_Page = TestData_Folder + "//" + Admin_TestData_Folder + "//" + "TC_40_Admin_PageSetting_About_Us_Page.json";
	public static final String TC_41_Admin_PageSetting_Contact_Us_Page = TestData_Folder + "//" + Admin_TestData_Folder + "//" + "TC_41_Admin_PageSetting_Contact_Us_Page.json";
	public static final String TC_42_Admin_SocialLink = TestData_Folder + "//" + Admin_TestData_Folder + "//" + "TC_42_Admin_SocialLink.json";
	public static final String TC_44_Admin_Update_WebsiteLogo = TestData_Folder + "//" + Admin_TestData_Folder + "//" + "TC_44_Admin_Update_WebsiteLogo.json";
	public static final String TC_45_Admin_GeneralSetting_FeviconLogo = TestData_Folder + "//" + Admin_TestData_Folder + "//" + "TC_45_Admin_GeneralSetting_FeviconLogo.json";
	public static final String TC_46_Admin_GeneralSetting_WebsiteContent = TestData_Folder + "//" + Admin_TestData_Folder + "//" + "TC_46_Admin_GeneralSetting_WebsiteContent.json";
	public static final String TC_47_Admin_GeneralSetting_PaymentSetting = TestData_Folder + "//" + Admin_TestData_Folder + "//" + "TC_47_Admin_GeneralSetting_PaymentSetting.json";
	public static final String TC_48_Admin_GeneralSetting_Background = TestData_Folder + "//" + Admin_TestData_Folder + "//" + "TC_48_Admin_GeneralSetting_Background.json";
	public static final String TC_49_Admin_GeneralSetting_AboutUs = TestData_Folder + "//" + Admin_TestData_Folder + "//" + "TC_49_Admin_GeneralSetting_AboutUs.json";
	public static final String TC_50_Admin_GeneralSetting_OfficeAddress = TestData_Folder + "//" + Admin_TestData_Folder + "//" + "TC_50_Admin_GeneralSetting_OfficeAddress.json";
	public static final String TC_52_Admin_GeneralSetting_PickUp_Locations = TestData_Folder + "//" + Admin_TestData_Folder + "//" + "TC_52_Admin_GeneralSetting_PickUp_Locations.json";
	public static final String Tc_53_Admin_Dashboard = TestData_Folder + "//" + Admin_TestData_Folder + "//" + "Tc_53_Admin_Dashboard.json";
	public static final String TC_55_Admin_Testimonial_TestimonialTitle = TestData_Folder + "//" + Admin_TestData_Folder + "//" + "TC_55_Admin_Testimonial_TestimonialTitle.json";
	public static final String TC_56_Admin_Language_Setting = TestData_Folder + "//" + Admin_TestData_Folder + "//" + "TC_56_Admin_Language_Setting.json";
	public static final String TC_57_Admin_Orders_ViewDetails = TestData_Folder + "//" + Admin_TestData_Folder + "//" + "TC_57_Admin_Orders_ViewDetails.json";
	public static final String TC_58_Admin_Orders_SendEmail = TestData_Folder + "//" + Admin_TestData_Folder + "//" + "TC_58_Admin_Orders_SendEmail.json";




}