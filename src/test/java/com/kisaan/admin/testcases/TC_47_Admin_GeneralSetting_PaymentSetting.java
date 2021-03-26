package com.kisaan.admin.testcases;

import java.awt.AWTException;

import org.testng.annotations.Test;

import com.kisaan.admin.pageobjects.General_Setting_Page;
import com.kisaan.admin.pageobjects.Page_Setting;
import com.kisaan.admin.pageobjects.Profile_Page;

import base.BaseClass;
import config.DefineConstants;
import helperMethods.JsonUtils;
import helperMethods.ScrollTypes;

public class TC_47_Admin_GeneralSetting_PaymentSetting extends BaseClass{
	
	Page_Setting page_Setting;
	Profile_Page profile_page;
	ScrollTypes scroll;
	General_Setting_Page general_Page;

	@Test(enabled = true)
	public void admin_Payment_Setting() throws AWTException {

		test = extent.createTest("TC_47_Admin_GeneralSetting_PaymentSetting","Admin should be able to add Payment Setting");

		profile_page = new Profile_Page(driver, test);
		page_Setting = new Page_Setting(driver, test);
		scroll = new ScrollTypes(driver);
		general_Page=new General_Setting_Page(driver, test);

		driver.get(DefineConstants.KISAAN_Admin_URL);
		profile_page.enter_EmailAddress(JsonUtils.getData(DefineConstants.TC_47_Admin_GeneralSetting_PaymentSetting, "Admin Email Id"));
		profile_page.enter_Password(JsonUtils.getData(DefineConstants.TC_47_Admin_GeneralSetting_PaymentSetting, "Admin Password"));
		profile_page.click_LogIN_Button();

		scroll.scrollInToView(page_Setting.page_Setting());
		general_Page.click_GeneralSettingPage();
		general_Page.click_PaymentSetting();
	//	general_Page.enter_PaypalBusinessAccount(JsonUtils.getData(DefineConstants.TC_47_Admin_GeneralSetting_PaymentSetting, "Paypal Business Account"));
		general_Page.enter_StripeKey(JsonUtils.getData(DefineConstants.TC_47_Admin_GeneralSetting_PaymentSetting, "Stripe Key"));
		general_Page.enter_StripeSecretKey(JsonUtils.getData(DefineConstants.TC_47_Admin_GeneralSetting_PaymentSetting, "Stripe Secret Key"));
	//	general_Page.enter_MobileMoneyInstruction(JsonUtils.getData(DefineConstants.TC_47_Admin_GeneralSetting_PaymentSetting, "Mobile Money Instruction"));
	//	general_Page.enter_BankInformation(JsonUtils.getData(DefineConstants.TC_47_Admin_GeneralSetting_PaymentSetting, "Bank Information"));
	//	general_Page.enter_Dynamic_Commission(JsonUtils.getData(DefineConstants.TC_47_Admin_GeneralSetting_PaymentSetting, "Dynamic Commission"));
	//	general_Page.enter_Fixed_Commission(JsonUtils.getData(DefineConstants.TC_47_Admin_GeneralSetting_PaymentSetting, "Fixed Commission"));
	//	general_Page.enter_Tax(JsonUtils.getData(DefineConstants.TC_47_Admin_GeneralSetting_PaymentSetting, "TAX"));
	//	general_Page.enter_WithdrawFee(JsonUtils.getData(DefineConstants.TC_47_Admin_GeneralSetting_PaymentSetting, "Withdraw Fee"));
	//	general_Page.enter_WithdrawCharge(JsonUtils.getData(DefineConstants.TC_47_Admin_GeneralSetting_PaymentSetting, "Withdraw Charge"));
	//	general_Page.enter_ShippingCost(JsonUtils.getData(DefineConstants.TC_47_Admin_GeneralSetting_PaymentSetting, "Shipping Cost"));
		
		// Disable/Enable Stripe
		general_Page.enableDisableButtonPaymentNew(JsonUtils.getData(DefineConstants.TC_47_Admin_GeneralSetting_PaymentSetting, "Yes"), JsonUtils.getData(DefineConstants.TC_47_Admin_GeneralSetting_PaymentSetting, "Num1"));
	
		// Disable/Enable Mobile Money
	//	general_Page.enableDisableButtonPayment(JsonUtils.getData(DefineConstants.TC_47_Admin_GeneralSetting_PaymentSetting, "Yes"), JsonUtils.getData(DefineConstants.TC_47_Admin_GeneralSetting_PaymentSetting, "Num2"));
	
		// Disable/Enable Cash On Delivery
		general_Page.enableDisableButtonPaymentNew(JsonUtils.getData(DefineConstants.TC_47_Admin_GeneralSetting_PaymentSetting, "Yes"), JsonUtils.getData(DefineConstants.TC_47_Admin_GeneralSetting_PaymentSetting, "Num2"));
	
		// Disable/Enable Paypal
	//	general_Page.enableDisableButtonPayment2(JsonUtils.getData(DefineConstants.TC_47_Admin_GeneralSetting_PaymentSetting, "Yes"), JsonUtils.getData(DefineConstants.TC_47_Admin_GeneralSetting_PaymentSetting, "Num1"));
	
		// Disable/Enable Bank
	//	general_Page.enableDisableButtonPayment2(JsonUtils.getData(DefineConstants.TC_47_Admin_GeneralSetting_PaymentSetting, "Yes"), JsonUtils.getData(DefineConstants.TC_47_Admin_GeneralSetting_PaymentSetting, "Num2"));
	
		general_Page.click_UpdatePaymentSettingButton();
		general_Page.verify_SuccessMessage(JsonUtils.getData(DefineConstants.TC_47_Admin_GeneralSetting_PaymentSetting, "Success Message"));
	
	}

}
