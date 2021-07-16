package stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.ibsplc.common.BaseSetup;
import com.ibsplc.generic.Generic;
import com.ibsplc.generic.InitialSetup;
import com.ibsplc.pageObjects.HomePage;
import com.ibsplc.utils.PropertyHandler;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Module : Regression
 * Trucking
 * @author A-8457 Souvik
 * 
 *  **/
public class Flow02_TruckOrderGenerationForFictitious extends BaseSetup {

	HomePage home = null;
	public static final String messagePath = PropertyHandler.getPropValue(
			"resources\\EnvSetup.properties", "selenium.sample.message.path");

	@Given("^Login to Application and switch role for Flow02$")
	public void navigateAndLogin() throws Throwable {
		String classname = this.getClass().getName();
		String[] ClassName = classname.split("\\.");
		BaseSetup.test = BaseSetup.extent.startTest(ClassName[1]);
		InitialSetup init = new InitialSetup();
		WebDriver driver = init.InitialSetupMethod1();
		Generic gen = new Generic(driver, browserName,"Flow02.properties");
		home = gen.login("00262485");
	}


	@When("^Create an Ad-Hoc Truck in FLT003 screen for Flow02$")
	public void performGoodsAcceptance() throws IOException, InterruptedException {
		//CCOCFULL
		home.SwitchRoleGroupParameter("station", "CCOCFULL")
		.goToFLT003()
		.AdHocTruckCreation("CarrierCode","key_route","key_schType","key_fltType","key_depTime","key_arrTime","key_acType",
				"key_fltCapVol","key_fltCapWt","key_fltNum","key_fltDate","key_truckType","key_vendorCode")
		.close();
	}
	
	@Then("^Generation of Truck Order for the Fictious truck for Flow02")
	public void truckorder() throws IOException, InterruptedException {
		//CTRKCRD
				home.SwitchRoleGroupParameter("origin", "CTRKCRD")
				.goToTRK001()
				.GenerateTruckOrderFictious("CarrierCode", "key_fltNum","key_fltDate")
				.printTLM()
				.close();
	}
}