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
public class Flow04_TruckOrderGenerationForEmptyContainers extends BaseSetup {

	HomePage home = null;
	public static final String messagePath = PropertyHandler.getPropValue(
			"resources\\EnvSetup.properties", "selenium.sample.message.path");

	@Given("^Login to Application and switch role for Flow04$")
	public void navigateAndLogin() throws Throwable {
		String classname = this.getClass().getName();
		String[] ClassName = classname.split("\\.");
		BaseSetup.test = BaseSetup.extent.startTest(ClassName[1]);
		InitialSetup init = new InitialSetup();
		WebDriver driver = init.InitialSetupMethod1();
		Generic gen = new Generic(driver, browserName,"Flow04.properties");
		home = gen.login("00247313");
	}

	@When("^Do Truck flight creation for Flow04$")
	public void performTruckFlightCreation() throws Exception {
		home.SwitchRoleGroupParameter("station", "CCOCFULL")
		.goToFLT003()
		.AdHocTruckCreation("CarrierCode1","key_route","key_schType","key_fltType","key_depTime","key_arrTime","key_acType",
				"key_fltCapVol","key_fltCapWt","fltNo1","fltDt1","key_truckType","key_vendorCode")
		.close();
	}

	@And("^Do Booking in CAP018 screen for Flow04$")
	public void performGoodsAcceptance() throws Exception {
		//CCOCFULL
		
		home.SwitchRoleGroupParameter("origin", "CCOCFULL")
		.goToFLT002()
		.fetchFlightDetails("intermediate", "dest", "fltDt2", "aircraftType","fltNo2").close();
		
		home.SwitchRoleGroupParameter("station", "CCOCFULL")
		.goToCAP018()
		.MultilegBookingfor2Legs("prefix","awbno","origin","dest","agentCode","Product","scc","pcs","wt","vol","fltNo1","fltDt1"
				,"intermediate","ubr","commCode","CarrierCode1","P1Value","UDIDNo","forceStatus","NoOfLegs","CarrierCode1",
				"fltDt2","fltNo2")
		.close();
	}
	
	
	
	@And("^Do Capture and Acceptance in LTE001 screen for Flow04$")
	public void performCapture() throws IOException {
		//OCTRAGT
		home.SwitchRoleGroupParameter("origin", "CCOCFULL")
		.goToLTE001()
		.doCaptureWithShipperConsignee("prefix","awbno","ModeofPayment","shipper","consignee")
		.doAcceptance("pcs","wt","vol","UldNumber", false,"screening_method","ScreenResult")
		.close();
	}
	
	
	
	@And("^Do Build-up and Manifestation in OPR344 screen for Flow04$")
	public void buildupExport() throws IOException {
		//OLTEPLNR
		home.SwitchRoleGroupParameter("origin", "CCOCFULL")
		.goToOPR344()
		.performOnlyManifestWithAWBasCart("awbno","CarrierCode1","fltNo1","fltDt1", "origin", "dest")
		.close();
	}
	
	@Then("^Generate Truck Order with Empty Containers appended in TRK001 screen for Flow04$")
	public void captureDGDetails() throws IOException {
		//CTRKCRD
		home.SwitchRoleGroupParameter("origin", "CTRKCRD")
		.goToTRK001()
		.GenerateTruckOrderWithEmptyContainers("CarrierCode1","awbno", "fltNo1","fltDt1","ULD1","ULD2")
		.printTLM()
		.close();
	}
	
}