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
 * @author A-8452 Faizan
 * 
 *  **/
public class Flow07_TruckOrderGenerationForUnmanifestedFromNormalScreen extends BaseSetup {

	HomePage home = null;
	public static final String messagePath = PropertyHandler.getPropValue(
			"resources\\EnvSetup.properties", "selenium.sample.message.path");

	@Given("^Login to Application and switch role for Flow07$")
	public void navigateAndLogin() throws Throwable {
		String classname = this.getClass().getName();
		String[] ClassName = classname.split("\\.");
		BaseSetup.test = BaseSetup.extent.startTest(ClassName[1]);
		InitialSetup init = new InitialSetup();
		WebDriver driver = init.InitialSetupMethod1();
		Generic gen = new Generic(driver, browserName,"Flow07.properties");
		home = gen.login("00247313");
	}

	
	@When("^Do Truck flight creation for Flow07$")
	public void performTruckFlightCreation() throws Exception {
		home.SwitchRoleGroupParameter("station", "CCOCFULL")
		.goToFLT003()
		.AdHocTruckCreation("carrierCode1","key_route","key_schType","key_fltType","key_depTime","key_arrTime","key_acType",
				"key_fltCapVol","key_fltCapWt","fltNo1","fltDt1","key_truckType","key_vendorCode")
		.close();
	}

	@And("^Do Booking till acceptance in LTE001 screen for Flow07$")
	public void performBookingToAcceptance() throws Exception {
		
		
		home.SwitchRoleGroupParameter("origin", "CCOCFULL")
		.goToFLT002()
		.fetchFlightDetails("intermediate", "dest", "fltDt2", "aircraftType","fltNo2").close();
		
		home.SwitchRoleGroupParameter("origin", "CCOCFULL")
		.goToLTE001()
		.doLTEOperationsFUllforTwoLegs("carrierCode1", "awbNo", "fltNo1", "fltDt1", "product", "agentCode",
				"shipper", "consignee", "origin", "dest", "pcs", "wt", "vol",
				"commodity", "prefix", "customerType",
				"intermediate", "carrierCode1", "fltNo2", "fltDt2", "UldNumber", 
				false, "ScreenMethod", "ScreenResult")
		//1st bool: UldNeed
		.close();
		
		home
		.goToLTE001()
		.doBookingOnlyWithoutAwb("carrierCode1", "awbNo1", "fltNo1", "fltDt1", "product", "agentCode",
				"shipper", "consignee", "origin", "intermediate", "pcs", "wt", "vol",
				"commodity", "prefix", "customerType",
				"PaymentMode")
		.close();
	}
	
	
	
	@And("^Do Build-up and Manifestation in OPR344 screen for Flow07$")
	public void performTillManifestation() throws IOException {
		//OLTEPLNR
				home.SwitchRoleGroupParameter("origin", "CCOCFULL")
				.goToOPR344()
				.performOnlyManifestWithAWBasCart("awbNo","carrierCode1","fltNo1","fltDt1", "origin", "intermediate")
				.close();
	}
	
	
	
	@And("^Generate Truck Order in TRK001 screen for Flow07 after manifestation$")
	public void GenerateTruckOrderAtManifest() throws IOException {
		//CTRKCRD
				home.SwitchRoleGroupParameter("origin", "CTRKCRD")
				.goToTRK001()
				.listFlight("carrierCode1", "fltNo1", "fltDt1")
				.CheckAwbTillApprove("awbNo")
				.close();
	}
	
	@And("^manifestation is done, finalise the flight and mark the movement for Flow07$")
	public void FinalizeFlight() throws IOException {
		
		home.SwitchRoleGroupParameter("origin", "CCOCFULL")
		.goToOPR344()
		.finalizeFlightOnly(true,"carrierCode1","fltNo1","fltDt1")
		.close();
		
		home
		.goToFLT006()
		.markFltArrival("carrierCode1", "fltNo1", "fltDt1")
		.close();
	}
	
	@Then("^do breakdown with pieces less than the manifested pieces and generate the Truck order for Flow07$")
	public void doBreakdownGenerateTruckOrder() throws IOException {
		
		home.SwitchRoleGroupParameter("intermediate", "OMGR")
		.goToOPR004()
		.breakdownFltwithAWB("awbNo","BULKorULDNo", "carrierCode1", "fltNo1", "ArrDate", "locationBreakdown", "pcs", "wt", false)
		.close();

		home.SwitchRoleGroupParameter("intermediate", "OMGR")
		.goToOPR014()
		.list("carrierCode1", "fltNo1", "ArrDate") 
		.addShipment("UldNo", "prefix", "awbNo1", "pcs", "wt")
		.close();
		
		home.SwitchRoleGroupParameter("intermediate", "OMGR")
		.goToOPR004()
		.breakdownFltwithAWB("awbNo1","UldNo", "carrierCode1", "fltNo1", "ArrDate", "locationBreakdown", "pcs", "wt", false)
		.close();

		
		//CTRKCRD
		home.SwitchRoleGroupParameter("intermediate", "CTRKCRD")
		.goToTRK001()
		.listFlight("carrierCode1", "fltNo1", "fltDt1")
		.VerifyGeneratedTruckOrder("awbNo1", "totalPcs", "totalWt", "availablePcs", "availableWt", "actualPcs", "actualWt")
		.approveTheDetails()
		.close();
		
}
}