package stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.ibsplc.common.BaseSetup;
import com.ibsplc.generic.Generic;
import com.ibsplc.generic.InitialSetup;
import com.ibsplc.pageObjects.HomePage;
import com.ibsplc.utils.PropertyHandler;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Module : Regression
 * Trucking
 * @author A-8457 Souvik
 * 
 *  **/
public class Flow01_TLMGeneration extends BaseSetup {

	HomePage home = null;
	public static final String messagePath = PropertyHandler.getPropValue(
			"resources\\EnvSetup.properties", "selenium.sample.message.path");

	@Given("^Login to Application and switch role for Flow01$")
	public void navigateAndLogin() throws Throwable {
		String classname = this.getClass().getName();
		String[] ClassName = classname.split("\\.");
		BaseSetup.test = BaseSetup.extent.startTest(ClassName[1]);
		InitialSetup init = new InitialSetup();
		WebDriver driver = init.InitialSetupMethod1();
		Generic gen = new Generic(driver, browserName,"Flow01.properties");
		home = gen.login("00262485");
	}

	@When("^Do Truck flight creation for Flow01$")
	public void performTruckFlightCreation() throws Exception {
		home.SwitchRoleGroupParameter("station", "CCOCFULL")
		.goToFLT003()
		.AdHocTruckCreation("CarrierCode","key_route","key_schType","key_fltType","key_depTime","key_arrTime","key_acType",
				"key_fltCapVol","key_fltCapWt","fltNo1","fltDt1","key_truckType","key_vendorCode")
		.close();
	}

	@And("^Do Booking in CAP018 screen for Flow01$")
	public void performGoodsAcceptance() throws Exception {
		//CCOCFULL
		home.SwitchRoleGroupParameter("origin", "CCOCFULL")
		.goToFLT002()
		.fetchFlightDetails("intermediate", "dest", "fltDt2", "aircraftType","fltNo2").close();
		
		home.SwitchRoleGroupParameter("origin", "CCOCFULL")
		.goToCAP018()
		.MultilegBookingfor2Legs("prefix","awbno","origin","dest","agentCode","Product","scc","pcs","wt","vol","fltNo1","fltDt1"
				,"intermediate","ubr","commCode","CarrierCode","P1Value","UDIDNo","forceStatus","NoOfLegs","CarrierCode",
				"fltDt2","fltNo2")
		.close();
	}
	
	@And("^Do Capture and Acceptance in LTE001 screen for Flow01$")
	public void performCapture() throws IOException {
		//OCTRAGT
		home.SwitchRoleGroupParameter("origin", "OLTEINT")
		.goToLTE001()
		.doCaptureWithShipperConsignee("prefix","awbno","ModeofPayment","shipper","consignee")
		.doAcceptance("pcs","wt","vol","UldNumber", false,"screening_method","ScreenResult")
		.close();
	}
	
	
	
	@And("^Do Build-up and Manifestation in OPR344 screen for Flow01$")
	public void buildupExport() throws IOException {
		//OLTEPLNR
		home.SwitchRoleGroupParameter("origin", "OLTEPLNR")
		.goToOPR344()
		.performOnlyManifestWithAWBasCart("awbno","CarrierCode","fltNo1","fltDt1", "origin", "dest")
		.close();
	}
	
	@Then("^Generate Truck Order in TRK001 screen for Flow01$")
	public void captureDGDetails() throws IOException {
		//CTRKCRD
		home.SwitchRoleGroupParameter("origin", "CTRKCRD")
		.goToTRK001()
		.GenerateTruckOrder("CarrierCode","awbno", "fltNo1","fltDt1")
		.printTLM()
		.close();
	}
	
}