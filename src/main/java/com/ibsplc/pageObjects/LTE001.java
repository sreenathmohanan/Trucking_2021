/**
 * 
 */
package com.ibsplc.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * @author A-6545  on 16/2/2018.
 *
 */

import com.ibsplc.common.BasePage;
import com.ibsplc.generic.InitialSetup;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Created Shalini on 27/12/2019.
 */
public class LTE001 extends BasePage {
	private final static Logger logger = Logger.getLogger(LTE001.class);
	public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties",
			"LTE_CSH_CLM.properties");
	public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties",
			"Generic.properties");
	public static String FRAME = "iCargoContentFrameLTE001";
	private String screenFrame = "iCargoContentFrameLTE001";
	private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
	private WebDriver driver;
	private String dataFileName;

	private By

	txt_carrierCode, txt_awbNo, Link_Screendetails, select_ScreenMethod, txt_screenPcs, select_screenPassFail, btn_list,
			txt_ProductType, link_ParticipantDetail, txt_agent, txt_shipperCode, txt_ConsigneeCode,
			link_shipmentDetails, txt_Origin, txt_destination, txt_shipmentPcs, txt_shipmentwt, txt_shipmentvolume,
			txt_producttype, txt_commodityCode, link_BookingDetails, txt_CarrierCode, txt_flightnumber, txt_flightdate,
			link_AcceptanceDetails, txt_pieces, txt_weight, txt_volume, txt_AcceptAll, link_ChargeDetails, btn_Calculte,
			btn_Save, btn_AwbVerified, txt_FlightSegment, txt_Status, select_ModeofPayment, select_CustomerType,
			Txt_ULD, btn_Add, txt_SecndULD, txt_FltPcs, txt_FltWt, txt_FltVolume, Icon_SetDimention, txt_SetPcse,
			txt_SetWt, txt_SetLenght, txt_SetWidth, txt_SetHeight, Popup_btnOK,
			// A-7290
			Link_SCertificateDetails, text_driverName, text_CompanyName, select_DriverID, text_Country, chck_photoID;;

	private By btn_genericYes, info_footer, info_msg;

	public LTE001(WebDriver driver, String dataFileName) {
		super(driver);
		this.driver = driver;
		this.dataFilePath = dataFilePath + dataFileName;
		this.dataFileName = dataFileName;
		initElements();
	}

	/**
	 * Initializes all the elements
	 * 
	 * Created Shalini on 27/12/2019.
	 */
	private void initElements() {

		info_msg = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
		btn_list = MiscUtility.getWebElement(objFilepath, "LTE001_btn_list");
		Icon_SetDimention = MiscUtility.getWebElement(objFilepath, "LTE001_Icon_SetDimention");
		txt_SetPcse = MiscUtility.getWebElement(objFilepath, "LTE001_txt_SetPcse");
		txt_SetWt = MiscUtility.getWebElement(objFilepath, "LTE001_txt_SetWt");
		txt_SetLenght = MiscUtility.getWebElement(objFilepath, "LTE001_txt_SetLenght");
		txt_SetWidth = MiscUtility.getWebElement(objFilepath, "LTE001_txt_SetWidth");
		txt_SetHeight = MiscUtility.getWebElement(objFilepath, "LTE001_txt_SetHeight");
		Popup_btnOK = MiscUtility.getWebElement(objFilepath, "LTE001_Popup_btnOK");
		txt_FltVolume = MiscUtility.getWebElement(objFilepath, "LTE001_txt_FltVolume");
		Link_Screendetails = MiscUtility.getWebElement(objFilepath, "LTE001_Link_Screendetails");
		select_ScreenMethod = MiscUtility.getWebElement(objFilepath, "LTE001_select_ScreenMethod");
		txt_screenPcs = MiscUtility.getWebElement(objFilepath, "LTE001_txt_screenPcs");
		select_screenPassFail = MiscUtility.getWebElement(objFilepath, "LTE001_select_screenPassFail");

		txt_carrierCode = MiscUtility.getWebElement(objFilepath, "LTE001_txt_carrierCode");
		txt_awbNo = MiscUtility.getWebElement(objFilepath, "LTE001_txt_awbNo");
		btn_list = MiscUtility.getWebElement(objFilepath, "LTE001_btn_list");
		txt_Status = MiscUtility.getWebElement(objFilepath, "LTE001_txt_Status");
		txt_ProductType = MiscUtility.getWebElement(objFilepath, "LTE001_txt_ProductType");
		link_ParticipantDetail = MiscUtility.getWebElement(objFilepath, "LTE001_link_ParticipantDetail");
		txt_agent = MiscUtility.getWebElement(objFilepath, "LTE001_txt_agent");
		txt_shipperCode = MiscUtility.getWebElement(objFilepath, "LTE001_txt_shipperCode");
		txt_ConsigneeCode = MiscUtility.getWebElement(objFilepath, "LTE001_txt_ConsigneeCode");
		link_shipmentDetails = MiscUtility.getWebElement(objFilepath, "LTE001_link_shipmentDetails");
		txt_Origin = MiscUtility.getWebElement(objFilepath, "LTE001_txt_Origin");
		txt_destination = MiscUtility.getWebElement(objFilepath, "LTE001_txt_destination");
		txt_shipmentPcs = MiscUtility.getWebElement(objFilepath, "LTE001_txt_shipmentPcs");
		txt_shipmentwt = MiscUtility.getWebElement(objFilepath, "LTE001_txt_shipmentwt");
		txt_shipmentvolume = MiscUtility.getWebElement(objFilepath, "LTE001_txt_shipmentvolume");
		txt_producttype = MiscUtility.getWebElement(objFilepath, "LTE001_txt_producttype");
		txt_commodityCode = MiscUtility.getWebElement(objFilepath, "LTE001_txt_commodityCode");
		link_BookingDetails = MiscUtility.getWebElement(objFilepath, "LTE001_link_BookingDetails");
		txt_CarrierCode = MiscUtility.getWebElement(objFilepath, "LTE001_txt_CarrierCode");
		txt_flightnumber = MiscUtility.getWebElement(objFilepath, "LTE001_txt_flightnumber");
		txt_flightdate = MiscUtility.getWebElement(objFilepath, "LTE001_txt_flightdate");
		link_AcceptanceDetails = MiscUtility.getWebElement(objFilepath, "LTE001_link_AcceptanceDetails");
		txt_pieces = MiscUtility.getWebElement(objFilepath, "LTE001_txt_pieces");
		txt_weight = MiscUtility.getWebElement(objFilepath, "LTE001_txt_weight");
		txt_volume = MiscUtility.getWebElement(objFilepath, "LTE001_txt_volume");
		txt_AcceptAll = MiscUtility.getWebElement(objFilepath, "LTE001_txt_AcceptAll");
		link_ChargeDetails = MiscUtility.getWebElement(objFilepath, "LTE001_link_ChargeDetails");
		btn_Calculte = MiscUtility.getWebElement(objFilepath, "LTE001_btn_Calculte");
		btn_Save = MiscUtility.getWebElement(objFilepath, "LTE001_btn_Save");
		btn_AwbVerified = MiscUtility.getWebElement(objFilepath, "LTE001_btn_AwbVerified");
		txt_FlightSegment = MiscUtility.getWebElement(objFilepath, "LTE001_txt_FlightSegment");
		select_ModeofPayment = MiscUtility.getWebElement(objFilepath, "LTE001_select_ModeofPayment");
		select_CustomerType = MiscUtility.getWebElement(objFilepath, "LTE001_select_CustomerType");
		btn_genericYes = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
		info_footer = MiscUtility.getWebElement(genObjPath, "Generic_foot_layer");
		Txt_ULD = MiscUtility.getWebElement(objFilepath, "LTE001_Txt_ULD");
		btn_Add = MiscUtility.getWebElement(objFilepath, "LTE001_btn_Add");
		txt_SecndULD = MiscUtility.getWebElement(objFilepath, "LTE001_txt_SecndULD");
		txt_FltPcs = MiscUtility.getWebElement(objFilepath, "LTE001_txt_FltPcs");
		txt_FltWt = MiscUtility.getWebElement(objFilepath, "LTE001_txt_FltWt");
		txt_FltPcs = MiscUtility.getWebElement(objFilepath, "LTE001_txt_FltPcs");
		// A-7290
		Link_SCertificateDetails = MiscUtility.getWebElement(objFilepath, "LTE001_Link_SCertificateDetails");
		text_driverName = MiscUtility.getWebElement(objFilepath, "LTE001_text_driverName");
		text_CompanyName = MiscUtility.getWebElement(objFilepath, "LTE001_text_CompanyName");
		select_DriverID = MiscUtility.getWebElement(objFilepath, "LTE001_select_DriverID");
		text_Country = MiscUtility.getWebElement(objFilepath, "LTE001_text_Country");
		chck_photoID = MiscUtility.getWebElement(objFilepath, "LTE001_chck_photoID");
	}

	/**
	 * Created by Shalini
	 * 
	 * @param carriercode
	 * @param fltNo
	 *            ,awbno,Product,agentCode,shipper,consignee,origin
	 *            dest,pcs,wt,vol,Commodity,prefix,ModeofPayment
	 * @return
	 */

	public LTE001 Verify_Flightdetails(String carriercode, String awbno, String fltNo, String fltDt, String Product,
			String agentCode, String shipper, String consignee, String origin, String dest, String pcs, String wt,
			String vol, String Commodity, String prefix, String ModeofPayment) {
		minWait();
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		carriercode = PropertyHandler.getPropValue(dataFilePath, carriercode);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		Product = PropertyHandler.getPropValue(dataFilePath, Product);
		agentCode = PropertyHandler.getPropValue(dataFilePath, agentCode);
		shipper = PropertyHandler.getPropValue(dataFilePath, shipper);
		consignee = PropertyHandler.getPropValue(dataFilePath, consignee);
		origin = PropertyHandler.getPropValue(dataFilePath, origin);
		dest = PropertyHandler.getPropValue(dataFilePath, dest);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		vol = PropertyHandler.getPropValue(dataFilePath, vol);
		Commodity = PropertyHandler.getPropValue(dataFilePath, Commodity);
		ModeofPayment = PropertyHandler.getPropValue(dataFilePath, ModeofPayment);
		String orgindestination = origin + "-" + dest;

		enterKeys(txt_carrierCode, prefix);
		enterKeys(txt_awbNo, awbno);
		click(btn_list);
		InitialSetup.test.log(LogStatus.PASS,
				"Successfully entertered Carrier code and AWB No:" + prefix + "-" + awbno);
		maxWait();
		enterKeys(txt_ProductType, Product + Keys.TAB);
		selectByText(select_CustomerType, "Walk-in Customer");
		click(link_ParticipantDetail);
		enterKeys(txt_agent, agentCode);
		enterKeys(txt_shipperCode, shipper);
		enterKeys(txt_ConsigneeCode, consignee);
		click(link_shipmentDetails);
		enterKeys(txt_Origin, origin);
		enterKeys(txt_destination, dest);
		enterKeys(txt_shipmentPcs, pcs);
		enterKeys(txt_shipmentwt, wt);
		enterKeys(txt_shipmentvolume, vol);
		enterKeys(txt_producttype, Product);
		enterKeys(txt_commodityCode, Commodity);
		minWait();
		// Set Dimension
		click(Icon_SetDimention);
		minWait();
		enterKeys(txt_SetPcse, pcs);
		/*
		 * driver.findElement(By.xpath(
		 * "(//div[@name='dimensionsPanelTagName']//input[@name='dimensionPcs'])[1]"
		 * )) .sendKeys(pcs);
		 */
		enterKeys(txt_SetWt, wt);
		enterKeys(txt_SetLenght, "10");
		enterKeys(txt_SetWidth, "10");
		enterKeys(txt_SetHeight, "10");
		minWait();
		driver.findElement(By.xpath("(//input[@name='dimensionHeight'])[4]")).click();
		minWait();
		click(Popup_btnOK);
		minWait();
		driver.switchTo().defaultContent();
		handleAlert("Accept", "LTE001");
		minWait();
		driver.switchTo().frame("iCargoContentFrameLTE001");
		click(link_BookingDetails);
		minWait();
		enterKeys(txt_CarrierCode, carriercode);
		enterKeys(txt_flightnumber, fltNo);
		enterKeys(txt_flightdate, fltDt + Keys.TAB);
		enterKeys(txt_FlightSegment, orgindestination);
		enterKeys(txt_FltPcs, pcs);
		minWait();
		enterKeys(txt_FltWt, wt);
		minWait();
		enterKeys(txt_FltVolume, vol);
		minWait();
		click(link_AcceptanceDetails);
		enterKeys(txt_pieces, pcs);
		enterKeys(txt_weight, wt);
		minWait();
		enterKeys(txt_volume, vol);
		minWait();
		click(txt_AcceptAll);
		click(link_ChargeDetails);
		minWait();
		click(btn_Calculte);
		minWait();
		driver.switchTo().defaultContent();
		handleAlert("Accept", "LTE001");
		minWait();
		driver.switchTo().frame("iCargoContentFrameLTE001");
		minWait();
		try {
			selectByText(select_ModeofPayment, ModeofPayment);
		} catch (Exception e) {

		}
		// Screening
		/*
		 * click(Link_Screendetails); selectByText(select_ScreenMethod,
		 * "Metal Detection Equipment"); enterKeys(txt_screenPcs, pcs);
		 * selectByText(select_screenPassFail, "Pass"); minWait();
		 * click(btn_Save); maxWait(); maxWait();
		 * driver.switchTo().defaultContent(); handleAlert("Accept", "LTE001");
		 * maxWait(); driver.switchTo().frame("iCargoContentFrameLTE001");
		 */
		String actaulValue = driver.findElement(By.xpath("//label[contains(text(),'Booking')]/..//div")).getText();
		if (actaulValue.equalsIgnoreCase("Confirmed")) {
			InitialSetup.test.log(LogStatus.PASS, "Booking is done Successfully");
		} else {
			Assert.fail("Error in Message");
			InitialSetup.test.log(LogStatus.FAIL, "Booking is not done Successfully");
		}
		click(btn_AwbVerified);
		InitialSetup.test.log(LogStatus.PASS, "Successfully clicked on AWB verification button");
		click(btn_Save);
		maxWait();

		try {
			driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
		} catch (Exception e) {

		}
		maxWait();
		maxWait();

		actaulValue = driver
				.findElement(By.xpath("(//label[contains(text(),'Acceptance')]/../following-sibling::div//span)[1]"))
				.getText();
		if (actaulValue.equalsIgnoreCase("Ready For Carriage")) {
			InitialSetup.test.log(LogStatus.PASS, "Ready For Carriage is done Successfully");
		} else {
			Assert.fail("Error in Message");
			InitialSetup.test.log(LogStatus.FAIL, "Ready For Carriage is not done Successfully");
		}
		return this;
	}

	/**
	 * Created by Shalini
	 * 
	 * @param carriercode
	 * @param fltNo
	 *            ,awbno,Product,agentCode,shipper,consignee,origin
	 *            dest,pcs,wt,vol,Commodity,prefix,ModeofPayment
	 * @return
	 */

	public LTE001 Verify_FlightdetailsWithULDandLoose(String carriercode, String awbno, String fltNo, String fltDt,
			String Product, String agentCode, String shipper, String consignee, String origin, String dest, String pcs,
			String wt, String vol, String Commodity, String prefix, String ModeofPayment, String ULDType) {
		minWait();
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		Product = PropertyHandler.getPropValue(dataFilePath, Product);
		agentCode = PropertyHandler.getPropValue(dataFilePath, agentCode);
		shipper = PropertyHandler.getPropValue(dataFilePath, shipper);
		consignee = PropertyHandler.getPropValue(dataFilePath, consignee);
		origin = PropertyHandler.getPropValue(dataFilePath, origin);
		dest = PropertyHandler.getPropValue(dataFilePath, dest);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		vol = PropertyHandler.getPropValue(dataFilePath, vol);
		Commodity = PropertyHandler.getPropValue(dataFilePath, Commodity);
		ModeofPayment = PropertyHandler.getPropValue(dataFilePath, ModeofPayment);
		ULDType = PropertyHandler.getPropValue(dataFilePath, ULDType);
		String orgindestination = origin + "-" + dest;
		String carrierwithFlightno = carriercode + fltNo;
		PropertyHandler.setPropValue(dataFilePath, carrierwithFlightno, carrierwithFlightno);
		enterKeys(txt_carrierCode, prefix);
		enterKeys(txt_awbNo, awbno);
		click(btn_list);
		InitialSetup.test.log(LogStatus.PASS,
				"Successfully entertered Carrier code and AWB No:" + prefix + "-" + awbno);
		maxWait();
		enterKeys(txt_ProductType, Product + Keys.TAB);
		selectByText(select_CustomerType, "Walk-in Customer");
		click(link_ParticipantDetail);
		enterKeys(txt_agent, agentCode);
		enterKeys(txt_shipperCode, shipper);
		enterKeys(txt_ConsigneeCode, consignee);
		click(link_shipmentDetails);
		enterKeys(txt_Origin, origin);
		enterKeys(txt_destination, dest);
		enterKeys(txt_shipmentPcs, pcs);
		enterKeys(txt_shipmentwt, wt);
		enterKeys(txt_shipmentvolume, vol);
		enterKeys(txt_producttype, Product);
		enterKeys(txt_commodityCode, Commodity);
		click(link_BookingDetails);
		enterKeys(txt_CarrierCode, carriercode);
		enterKeys(txt_flightnumber, fltNo);
		enterKeys(txt_flightdate, fltDt);
		enterKeys(txt_FlightSegment, orgindestination);
		click(link_AcceptanceDetails);
		enterKeys(txt_pieces, pcs);
		enterKeys(txt_weight, wt);
		enterKeys(txt_volume, vol);
		enterKeys(Txt_ULD, ULDType);
		click(btn_Add);
		enterKeys(txt_SecndULD, "BULK");
		click(txt_AcceptAll);
		click(link_ChargeDetails);
		minWait();
		click(btn_Calculte);
		selectByText(select_ModeofPayment, ModeofPayment);
		click(btn_Save);
		maxWait();
		String actaulValue = driver.findElement(By.xpath("//label[contains(text(),'Booking')]/..//div")).getText();
		if (actaulValue.equalsIgnoreCase("Confirmed")) {
			InitialSetup.test.log(LogStatus.PASS, "Booking is done Successfully");
		} else {
			Assert.fail("Error in Message");
			InitialSetup.test.log(LogStatus.FAIL, "Booking is not done Successfully");
		}
		click(btn_AwbVerified);
		InitialSetup.test.log(LogStatus.PASS, "Successfully clicked on AWB verification button");
		return this;
	}

	/**
	 * CLose and screen and go to home page
	 * 
	 * @return Created A-6545 on 16/2/2018.
	 */
	public HomePage close() {

		click(By.xpath("//button[@name='btnClose']"));
		driver.switchTo().defaultContent();
		if (verifyElementPresent(btn_genericYes)) {

			click(btn_genericYes);
		}
		return new HomePage(driver, dataFileName);
	}

	/**
	 * Description... Handles an alert with options getText/Accept/Dismiss/Close
	 * 
	 * @param alertOps
	 * @param ScreenName
	 */
	public void handleAlert(String alertOps, String ScreenName) {
		driver.switchTo().defaultContent();
		String AlertText = "";

		try {
			AlertText = driver.findElement(By.xpath("//div[@role='dialog']//p")).getText();
			switch (alertOps.valueOf(alertOps)) {
			case "getText":
				InitialSetup.test.log(LogStatus.PASS, "Accepted Alert text " + AlertText + ScreenName);
				break;

			case "Accept":
				driver.findElement(By.xpath("//div[@class='ui-dialog-buttonset']//button[1]")).click();
				InitialSetup.test.log(LogStatus.PASS, "Accepted Alert with text " + ScreenName);

				break;
			case "Dismiss":
				driver.findElement(By.xpath("//div[@class='ui-dialog-buttonset']//button[2]")).click();
				InitialSetup.test.log(LogStatus.PASS, "Clicked on Dismiss button" + ScreenName);
				break;
			case "Close":
				driver.findElement(By.xpath("(//button[@title='Close'])[2]|//button[@name='btClose']")).click();
				InitialSetup.test.log(LogStatus.PASS, "Clicked on Close button" + ScreenName);
				break;
			}

		} catch (Exception e) {
			InitialSetup.test.log(LogStatus.INFO, "Not able to handle Alert" + ScreenName);

		}
	}

	public LTE001 Verify_FlightdetailsforCash(String carriercode, String awbno, String fltNo, String fltDt,
			String Product, String agentCode, String shipper, String consignee, String origin, String dest, String pcs,
			String wt, String vol, String Commodity, String prefix, String ModeofPayment, String CustomerType) {
		minWait();
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		carriercode = PropertyHandler.getPropValue(dataFilePath, carriercode);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		Product = PropertyHandler.getPropValue(dataFilePath, Product);
		agentCode = PropertyHandler.getPropValue(dataFilePath, agentCode);
		shipper = PropertyHandler.getPropValue(dataFilePath, shipper);
		consignee = PropertyHandler.getPropValue(dataFilePath, consignee);
		origin = PropertyHandler.getPropValue(dataFilePath, origin);
		dest = PropertyHandler.getPropValue(dataFilePath, dest);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		vol = PropertyHandler.getPropValue(dataFilePath, vol);
		Commodity = PropertyHandler.getPropValue(dataFilePath, Commodity);
		ModeofPayment = PropertyHandler.getPropValue(dataFilePath, ModeofPayment);
		CustomerType = PropertyHandler.getPropValue(dataFilePath, CustomerType);
		String orgindestination = origin + "-" + dest;
		String carrierWithFlightno = carriercode + fltNo;
		PropertyHandler.setPropValue(dataFilePath, "carrierwithFlightno", carrierWithFlightno);

		enterKeys(txt_carrierCode, prefix);
		enterKeys(txt_awbNo, awbno);
		click(btn_list);
		InitialSetup.test.log(LogStatus.PASS,
				"Successfully entertered Carrier code and AWB No:" + prefix + "-" + awbno);
		maxWait();
		enterKeys(txt_ProductType, Product + Keys.TAB);
		selectByText(select_CustomerType, CustomerType);
		click(link_ParticipantDetail);
		enterKeys(txt_agent, agentCode + Keys.TAB);
		enterKeys(txt_shipperCode, shipper + Keys.TAB);
		enterKeys(txt_ConsigneeCode, consignee + Keys.TAB);
		minWait();
		driver.findElement(By.xpath("//button[@name='btnParticipantCont']")).click();
		// Certificate
		// click(Link_SCertificateDetails);
		enterKeys(text_driverName, "Demo");
		enterKeys(text_CompanyName, "Testing");
		selectByText(select_DriverID, "Others");
		enterKeys(text_Country, "India");
		click(chck_photoID);
		// Shipment
		click(link_shipmentDetails);
		enterKeys(txt_Origin, origin);
		enterKeys(txt_destination, dest);
		enterKeys(txt_shipmentPcs, pcs);
		enterKeys(txt_shipmentwt, wt);
		enterKeys(txt_shipmentvolume, vol);
		enterKeys(txt_producttype, Product);
		enterKeys(txt_commodityCode, Commodity);
		minWait();
		// Set Dimension
		click(Icon_SetDimention);
		minWait();
		// enterKeys(txt_SetPcse, pcs);
		driver.findElement(By.xpath("(//div[@name='dimensionsPanelTagName']//input[@name='dimensionPcs'])[1]")).click();
		driver.findElement(By.xpath("(//div[@name='dimensionsPanelTagName']//input[@name='dimensionPcs'])[1]")).clear();

		driver.findElement(By.xpath("(//div[@name='dimensionsPanelTagName']//input[@name='dimensionPcs'])[1]"))
				.sendKeys(pcs);
		enterKeys(txt_SetWt, wt);
		enterKeys(txt_SetLenght, "10");
		enterKeys(txt_SetWidth, "10");
		enterKeys(txt_SetHeight, "10");
		minWait();
		driver.findElement(By.xpath("(//input[@name='dimensionHeight'])[4]|(//td[@class='sumUpVol'])[2]")).click();
		minWait();
		click(Popup_btnOK);
		minWait();
		driver.switchTo().defaultContent();
		handleAlert("Accept", "LTE001");
		minWait();
		driver.switchTo().frame("iCargoContentFrameLTE001");
		click(link_BookingDetails);
		minWait();
		enterKeys(txt_CarrierCode, carriercode);
		enterKeys(txt_flightnumber, fltNo);
		enterKeys(txt_flightdate, fltDt + Keys.TAB);
		enterKeys(txt_FlightSegment, orgindestination);
		enterKeys(txt_FltPcs, pcs);
		minWait();
		enterKeys(txt_FltWt, wt);
		minWait();
		enterKeys(txt_FltVolume, vol);
		minWait();
		click(link_AcceptanceDetails);
		enterKeys(txt_pieces, pcs);
		enterKeys(txt_weight, wt);
		minWait();
		enterKeys(txt_volume, vol);
		minWait();
		click(txt_AcceptAll);
		click(link_ChargeDetails);
		minWait();
		click(btn_Calculte);
		minWait();
		try {
			driver.switchTo().defaultContent();
			handleAlert("Accept", "LTE001");
			minWait();
			driver.switchTo().frame("iCargoContentFrameLTE001");
		} catch (Exception e) {

		}
		minWait();
		try {
			selectByText(select_ModeofPayment, ModeofPayment);
		} catch (Exception e) {

		}
		// Screening
		click(Link_Screendetails);
		selectByText(select_ScreenMethod, "X-ray equipment");
		enterKeys(txt_screenPcs, pcs);
		selectByText(select_screenPassFail, "Pass");
		minWait();
		click(btn_Save);
		maxWait();
		maxWait();
		driver.switchTo().defaultContent();
		handleAlert("Accept", "LTE001");
		maxWait();
		// driver.switchTo().frame("iCargoContentFrameLTE001");
		waitForFrameAndSwitch("iCargoContentFrameLTE001");
		String actaulValue = driver.findElement(By.xpath("//label[contains(text(),'Booking')]/..//div")).getText();
		if (actaulValue.equalsIgnoreCase("Confirmed")) {
			InitialSetup.test.log(LogStatus.PASS, "Booking is done Successfully");
		} else {
			InitialSetup.test.log(LogStatus.FAIL, "Booking is not done Successfully");
			Assert.fail("Error in Message");

		}
		click(btn_AwbVerified);
		InitialSetup.test.log(LogStatus.PASS, "Successfully clicked on AWB verification button");
		click(btn_Save);
		maxWait();
		try {
			driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
		} catch (Exception e) {
		}
		maxWait();
		maxWait();
		actaulValue = driver
				.findElement(By.xpath("(//label[contains(text(),'Acceptance')]/../following-sibling::div//span)[1]"))
				.getText();
		if (actaulValue.equalsIgnoreCase("Ready For Carriage")) {
			InitialSetup.test.log(LogStatus.PASS, "Ready For Carriage is done Successfully");
		} else {
			Assert.fail("Error in Message");
			InitialSetup.test.log(LogStatus.FAIL, "Ready For Carriage is not done Successfully");
		}
		return this;
	}

	// Shalini
	public LTE001 LiteScreen_GoodsAcceptance(String prefix, String awbno) {
		minWait();
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);

		enterKeys(txt_carrierCode, prefix);
		enterKeys(txt_awbNo, awbno);
		click(btn_list);
		InitialSetup.test.log(LogStatus.PASS,
				"Successfully entertered Carrier code and AWB No:" + prefix + "-" + awbno);
		maxWait();

		click(btn_AwbVerified);
		InitialSetup.test.log(LogStatus.PASS, "Successfully clicked on AWB verification button");
		click(btn_Save);
		maxWait();

		try {
			driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
		} catch (Exception e) {

		}
		maxWait();
		maxWait();

		String actaulValue = driver
				.findElement(By.xpath("(//label[contains(text(),'Acceptance')]/../following-sibling::div//span)[1]"))
				.getText();
		if (actaulValue.equalsIgnoreCase("Ready For Carriage")) {
			InitialSetup.test.log(LogStatus.PASS, "Ready For Carriage is done Successfully");
		} else {
			Assert.fail("Error in Message");
			InitialSetup.test.log(LogStatus.FAIL, "Ready For Carriage is not done Successfully");
		}
		return this;
	}

	/**
	 * Created by Shalini
	 * 
	 * @param carriercode
	 * @param fltNo
	 *            ,awbno,Product,agentCode,shipper,consignee,origin
	 *            dest,pcs,wt,vol,Commodity,prefix,ModeofPayment
	 * @return
	 */

	public LTE001 LiteScreen_Booking(String carriercode, String awbno, String fltNo, String fltDt, String Product,
			String agentCode, String shipper, String consignee, String origin, String dest, String pcs, String wt,
			String vol, String Commodity, String prefix, String ModeofPayment, String CustomerType) {
		minWait();
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		carriercode = PropertyHandler.getPropValue(dataFilePath, carriercode);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		Product = PropertyHandler.getPropValue(dataFilePath, Product);
		agentCode = PropertyHandler.getPropValue(dataFilePath, agentCode);
		shipper = PropertyHandler.getPropValue(dataFilePath, shipper);
		consignee = PropertyHandler.getPropValue(dataFilePath, consignee);
		origin = PropertyHandler.getPropValue(dataFilePath, origin);
		dest = PropertyHandler.getPropValue(dataFilePath, dest);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		vol = PropertyHandler.getPropValue(dataFilePath, vol);
		Commodity = PropertyHandler.getPropValue(dataFilePath, Commodity);
		ModeofPayment = PropertyHandler.getPropValue(dataFilePath, ModeofPayment);
		CustomerType = PropertyHandler.getPropValue(dataFilePath, CustomerType);
		String orgindestination = origin + "-" + dest;

		enterKeys(txt_carrierCode, prefix);
		enterKeys(txt_awbNo, awbno);
		click(btn_list);
		InitialSetup.test.log(LogStatus.PASS,
				"Successfully entertered Carrier code and AWB No:" + prefix + "-" + awbno);
		maxWait();
		enterKeys(txt_ProductType, Product + Keys.TAB);
		selectByText(select_CustomerType, CustomerType);
		click(link_ParticipantDetail);
		enterKeys(txt_agent, agentCode);
		enterKeys(txt_shipperCode, shipper);
		enterKeys(txt_ConsigneeCode, consignee);
		click(link_shipmentDetails);
		enterKeys(txt_Origin, origin);
		enterKeys(txt_destination, dest);
		enterKeys(txt_shipmentPcs, pcs);
		enterKeys(txt_shipmentwt, wt);
		enterKeys(txt_shipmentvolume, vol);
		enterKeys(txt_producttype, Product);
		enterKeys(txt_commodityCode, Commodity);
		minWait();
		// Set Dimension
		click(Icon_SetDimention);
		minWait();
		// enterKeys(txt_SetPcse, pcs);
		driver.findElement(By.xpath("(//div[@name='dimensionsPanelTagName']//input[@name='dimensionPcs'])[1]")).click();
		driver.findElement(By.xpath("(//div[@name='dimensionsPanelTagName']//input[@name='dimensionPcs'])[1]")).clear();

		driver.findElement(By.xpath("(//div[@name='dimensionsPanelTagName']//input[@name='dimensionPcs'])[1]"))
				.sendKeys(pcs);
		enterKeys(txt_SetWt, wt);
		enterKeys(txt_SetLenght, "10");
		enterKeys(txt_SetWidth, "10");
		enterKeys(txt_SetHeight, "10");
		minWait();
		driver.findElement(By.xpath("(//input[@name='dimensionHeight'])[4]|(//td[@class='sumUpVol'])[2]")).click();
		minWait();
		click(Popup_btnOK);
		minWait();
		driver.switchTo().defaultContent();
		handleAlert("Accept", "LTE001");
		minWait();
		driver.switchTo().frame("iCargoContentFrameLTE001");
		click(link_BookingDetails);
		minWait();
		enterKeys(txt_CarrierCode, carriercode);
		enterKeys(txt_flightnumber, fltNo);
		enterKeys(txt_flightdate, fltDt + Keys.TAB);
		enterKeys(txt_FlightSegment, orgindestination);
		enterKeys(txt_FltPcs, pcs);
		minWait();
		enterKeys(txt_FltWt, wt);
		minWait();
		enterKeys(txt_FltVolume, vol);
		minWait();
		click(link_AcceptanceDetails);
		enterKeys(txt_pieces, pcs);
		enterKeys(txt_weight, wt);
		minWait();
		enterKeys(txt_volume, vol);
		minWait();
		click(txt_AcceptAll);
		click(link_ChargeDetails);
		minWait();
		click(btn_Calculte);
		minWait();
		try {
			driver.switchTo().defaultContent();
			handleAlert("Accept", "LTE001");
			minWait();
			driver.switchTo().frame("iCargoContentFrameLTE001");
		} catch (Exception e) {

		}
		minWait();
		try {
			selectByText(select_ModeofPayment, ModeofPayment);
		} catch (Exception e) {

		}
		// Screening
		click(Link_Screendetails);
		selectByText(select_ScreenMethod, "Metal Detection Equipment");
		enterKeys(txt_screenPcs, pcs);
		selectByText(select_screenPassFail, "Pass");
		minWait();
		click(btn_Save);
		maxWait();
		maxWait();
		driver.switchTo().defaultContent();
		handleAlert("Accept", "LTE001");
		maxWait();
		driver.switchTo().frame("iCargoContentFrameLTE001");

		String actaulValue = driver.findElement(By.xpath("//label[contains(text(),'Booking')]/..//div")).getText();
		if (actaulValue.equalsIgnoreCase("Confirmed")) {
			InitialSetup.test.log(LogStatus.PASS, "Booking is done Successfully");
		} else {
			InitialSetup.test.log(LogStatus.FAIL, "Booking is not done Successfully");
			Assert.fail("Error in Message");

		}
		/*
		 * click(btn_AwbVerified); InitialSetup.test.log(LogStatus.PASS,
		 * "Successfully clicked on AWB verification button"); click(btn_Save);
		 * maxWait();
		 * 
		 * try {
		 * driver.findElement(By.xpath("//button[contains(text(),'Yes')]"))
		 * .click(); } catch (Exception e) {
		 * 
		 * } maxWait(); maxWait();
		 * 
		 * actaulValue = driver .findElement( By.xpath(
		 * "(//label[contains(text(),'Acceptance')]/../following-sibling::div//span)[1]"
		 * )) .getText(); if
		 * (actaulValue.equalsIgnoreCase("Ready For Carriage")) {
		 * InitialSetup.test.log(LogStatus.PASS,
		 * "Ready For Carriage is done Successfully"); } else {
		 * Assert.fail("Error in Message");
		 * InitialSetup.test.log(LogStatus.FAIL,
		 * "Ready For Carriage is not done Successfully"); }
		 */
		return this;
	}

	// A-8452 08May

	/**
	 * @author A-8452 Faizan Description: To list with AWB
	 * @param prefix
	 * @param awbno
	 * @return
	 */
	public LTE001 listAWB(String prefix, String awbno) {
		enterKeys(txt_carrierCode, prefix);
		enterKeys(txt_awbNo, awbno);
		click(btn_list);
		InitialSetup.test.log(LogStatus.INFO,
				"Successfully entertered Carrier code and AWB No:" + prefix + "-" + awbno);

		return this;
	}

	public LTE001 setDimension(String pcs, String wt) {
		click(Icon_SetDimention);
		minWait();
		enterKeys(txt_SetPcse, pcs);
		// driver.findElement(By.xpath("(//div[@name='dimensionsPanelTagName']//input[@name='dimensionPcs'])[1]")).sendKeys(pcs);
		enterKeys(txt_SetWt, wt);
		enterKeys(txt_SetLenght, "10");
		enterKeys(txt_SetWidth, "10");
		enterKeys(txt_SetHeight, "10" + Keys.TAB);
		enterKeys(txt_SetHeight, Keys.TAB);
		minWait();
		// driver.findElement(By.xpath("(//input[@name='dimensionHeight'])[4]")).click();
		minWait();
		click(Popup_btnOK);
		minWait();
		driver.switchTo().defaultContent();
		handleAlert("Accept", "LTE001");
		minWait();
		driver.switchTo().frame("iCargoContentFrameLTE001");
		String CalcVol = driver.findElement(txt_shipmentvolume).getAttribute("value");
		PropertyHandler.setPropValue(dataFilePath, "volume", CalcVol);
		// click(By.xpath("//button[@name='btnShipmentCont']"));
		minWait();
		return this;
	}

	/**
	 * @author A-8452 Faizan Description: For performing Booking only for single
	 *         leg
	 * @param carriercode
	 * @param awbno
	 * @param fltNo
	 * @param fltDt
	 * @param Product
	 * @param agentCode
	 * @param shipper
	 * @param consignee
	 * @param origin
	 * @param dest
	 * @param pcs
	 * @param wt
	 * @param vol
	 * @param Commodity
	 * @param prefix
	 * @return
	 */
	public LTE001 doBookingOnly(String carriercode, String awbno, String fltNo, String fltDt, String Product,
			String agentCode, String shipper, String consignee, String origin, String dest, String pcs, String wt,
			String vol, String Commodity, String prefix, String CustomerType) {

		minWait();
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		Product = PropertyHandler.getPropValue(dataFilePath, Product);
		agentCode = PropertyHandler.getPropValue(dataFilePath, agentCode);
		shipper = PropertyHandler.getPropValue(dataFilePath, shipper);
		consignee = PropertyHandler.getPropValue(dataFilePath, consignee);
		origin = PropertyHandler.getPropValue(dataFilePath, origin);
		dest = PropertyHandler.getPropValue(dataFilePath, dest);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		vol = PropertyHandler.getPropValue(dataFilePath, vol);
		Commodity = PropertyHandler.getPropValue(dataFilePath, Commodity);
		carriercode = PropertyHandler.getPropValue(dataFilePath, carriercode);
		CustomerType = PropertyHandler.getPropValue(dataFilePath, CustomerType);

		String orgindestination = origin + "-" + dest;
		String carrierwithFlightno = carriercode + fltNo;
		PropertyHandler.setPropValue(dataFilePath, "carrierwithFlightno", carrierwithFlightno);

		click(btn_list);
		click(By.xpath("//div[contains(text(),'Product and Customer')]"));
		minWait();
		enterKeys(txt_ProductType, Product + Keys.TAB);
		minWait();
		selectByText(select_CustomerType, CustomerType);
		click(By.xpath("//button[@name='btnCustomerTypeCont']"));
		minWait();

		// click(link_ParticipantDetail);
		enterKeys(txt_agent, agentCode + Keys.TAB);
		enterKeys(txt_shipperCode, shipper + Keys.TAB);
		enterKeys(txt_ConsigneeCode, consignee + Keys.TAB);
		click(By.xpath("//button[@name='btnParticipantCont']"));
		minWait();
		// ------------------------Certificate
		// Details---------------------------
		if (verifyElementPresent(By.xpath("//*[@name='driverIDType']"))) {
			selectByText(By.xpath("//*[@name='driverIDType']"), "License");
			enterKeys(By.xpath("//*[@name='stateOrCountryIssuingID']"), "US");
			enterKeys(By.xpath("//*[@name='driverName']"), "Test");
			enterKeys(By.xpath("//*[@name='driverCompany']"), "IBSAT");
			click(By.xpath("//*[@name='photoIDVerified']"));

			click(By.xpath("//button[@name='btnCertificateDetailsCont']"));
		}

		// click(link_shipmentDetails);
		enterKeys(txt_Origin, origin);
		enterKeys(txt_destination, dest);
		enterKeys(By.xpath("//*[@name='shippingDate']"), fltDt + Keys.TAB);
		selectByText(By.name("sci"), "T1");
		if (Product.equalsIgnoreCase("COMAT")) {
			selectByText(By.name("serviceCargoClass"), "COMAT");
		}
		if (Product.equalsIgnoreCase("PPS")) {
			selectByText(By.xpath("//*[@name='ppsCommodityCode']"), Commodity);
		} else {
			enterKeys(txt_commodityCode, Commodity);
		}
		enterKeys(txt_shipmentPcs, pcs);
		enterKeys(txt_shipmentwt, wt);
		// enterKeys(txt_shipmentvolume, vol);

		// selectByText(By.xpath("//*[@name='shpWeightUnit']"), "lbs");
		// selectByText(By.xpath("//*[@name='shpVolumeUnit']"), "cbf");
		// enterKeys(txt_producttype, Product);

		// Set Dimension
		minWait();
		setDimension(pcs, wt);
		click(By.xpath("//button[@name='btnShipmentCont']"));
		minWait();
		// click(link_BookingDetails);
		enterKeys(txt_CarrierCode, carriercode);
		enterKeys(txt_flightnumber, fltNo);
		enterKeys(txt_flightdate, fltDt);
		enterKeys(txt_FlightSegment, orgindestination);
		enterKeys(txt_FltPcs, pcs);
		enterKeys(txt_FltWt, wt);
		minWait();
		// String flightDt =
		// driver.findElement(txt_flightdate).getAttribute("value");
		// PropertyHandler.setPropValue(dataFilePath, "flightDt", flightDt);
		// vol = PropertyHandler.getPropValue(dataFilePath, "volume");
		// enterKeys(txt_FltVolume, vol);
		click(By.xpath("//button[@name='btnFlightDtlsCont']"));
		minWait();
		if (verifyElementVisible(By.name("btnWeatherCont"))) {
			click(By.name("btnWeatherCont"));
		}
		// click(link_ChargeDetails);
		minWait();
		click(btn_Calculte);
		minWait();
		driver.switchTo().defaultContent();
		handleAlert("Accept", "LTE001");
		minWait();
		driver.switchTo().frame(screenFrame);
		minWait();
		if (verifyElementPresent(select_ModeofPayment)) {
			selectByText(select_ModeofPayment, "CREDIT");
		}
		click(By.xpath("//button[@name='btnChargeDtlsCont']"));
		minWait();
		click(btn_Save);
		maxWait();
		// pop-up: The shipper does not have a valid certificate. Do you want to
		// continue?
		driver.switchTo().defaultContent();
		if (verifyElementPresent(info_msg)) {
			InitialSetup.test.log(LogStatus.INFO,
					"Pop-up message after saving: " + driver.findElement(info_msg).getText());
			click(btn_genericYes);
			minWait();
		}
		waitForFrameAndSwitch(screenFrame);
		// embargo
		if (verifyElementPresent(By.xpath("(//button[@id='okBtn'])[2]"))) {
			click(By.xpath("(//button[@id='okBtn'])[2]"));
		}
		// same pop-up
		/*
		 * driver.switchTo().defaultContent(); minWait();
		 * //waitForFrameAndSwitch(screenFrame); handleAlert("Accept",
		 * "LTE001"); minWait(); driver.switchTo().frame(screenFrame);
		 */
		minWait();
		// Capture booking status
		String BookingStatus = driver.findElement(By.xpath("(//*[@id='overviewBar']/div/div)[2]/div")).getText();
		PropertyHandler.setPropValue(dataFilePath, "LTEBookingStatus", BookingStatus);

		if (BookingStatus.equalsIgnoreCase("Confirmed") || BookingStatus.equalsIgnoreCase("Queued")) {
			String preAwb = getText_JS(By.xpath("//a[contains(@class,'awb-number')]"));
			String awb[] = preAwb.split("-");
			PropertyHandler.setPropValue(dataFilePath, "awbno", awb[1]);
			InitialSetup.test.log(LogStatus.PASS, "Booking done with Status: " + BookingStatus);
			captureAndAddScreenshot();
		} else {
			InitialSetup.test.log(LogStatus.FAIL,
					"Booking status is not confirmed or Queued. Status" + "displayed is: " + BookingStatus);
			Assert.fail("Booking status is not confirmed or Queued. Status" + "displayed is: ");
		}
		return this;
	}

	/**
	 * @author A-8452 Faizan Description: For performing Booking only for Two
	 *         legs
	 * @param carriercode
	 * @param awbno
	 * @param fltNo
	 * @param fltDt
	 * @param Product
	 * @param agentCode
	 * @param shipper
	 * @param consignee
	 * @param origin
	 * @param dest
	 * @param pcs
	 * @param wt
	 * @param vol
	 * @param Commodity
	 * @param prefix
	 * @param CustomerType
	 * @param intermediate
	 * @param carriercode1
	 * @param fltNo1
	 * @param fltDt1
	 * @return
	 */
	public LTE001 doBookingOnlyTwoLegs(String carriercode, String awbno, String fltNo, String fltDt, String Product,
			String agentCode, String shipper, String consignee, String origin, String dest, String pcs, String wt,
			String vol, String Commodity, String prefix, String CustomerType, String intermediate, String carriercode1,
			String fltNo1, String fltDt1) {

		minWait();
		//prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		//awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		Product = PropertyHandler.getPropValue(dataFilePath, Product);
		agentCode = PropertyHandler.getPropValue(dataFilePath, agentCode);
		shipper = PropertyHandler.getPropValue(dataFilePath, shipper);
		consignee = PropertyHandler.getPropValue(dataFilePath, consignee);
		origin = PropertyHandler.getPropValue(dataFilePath, origin);
		dest = PropertyHandler.getPropValue(dataFilePath, dest);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		vol = PropertyHandler.getPropValue(dataFilePath, vol);
		Commodity = PropertyHandler.getPropValue(dataFilePath, Commodity);
		carriercode=PropertyHandler.getPropValue(dataFilePath, carriercode);
		CustomerType=PropertyHandler.getPropValue(dataFilePath, CustomerType);
		

		//2nd flight
		carriercode1=PropertyHandler.getPropValue(dataFilePath, carriercode1);
		intermediate = PropertyHandler.getPropValue(dataFilePath, intermediate);
		fltNo1 = PropertyHandler.getPropValue(dataFilePath, fltNo1);
		fltDt1 = PropertyHandler.getPropValue(dataFilePath, fltDt1);

		String origindestination = origin + "-" + intermediate;
		String carrierwithFlightno = carriercode + fltNo;
		PropertyHandler.setPropValue(dataFilePath, "carrierwithFlightno",
				carrierwithFlightno);

		String origindestination1=intermediate +"-"+dest; 
		String carrierwithFlightno1 = carriercode1 + fltNo1;
		PropertyHandler.setPropValue(dataFilePath, "carrierwithFlightno1",
				carrierwithFlightno1);

		//listAWB(prefix, awbno);
		//enterKeys(txt_carrierCode, prefix);
		//enterKeys(txt_awbNo, awbno);
		click(btn_list);
		InitialSetup.test.log(LogStatus.INFO,
				"Successfully clicked on List");

		maxWait();
		maxWait();
		if(!verifyElementVisible(txt_ProductType))
		{
			click(By.xpath("(//span[@class='ui-accordion-header-icon ui-icon ui-icon-triangle-1-e'])[1]"));
			minWait();	
		}
		//------------------------------Product and Customer Type------------------------
		enterKeys(txt_ProductType, Product + Keys.TAB);
		maxWait();
		selectByText(select_CustomerType, CustomerType);
		InitialSetup.test.log(LogStatus.INFO,
				"Successfully entered Product and Customer Details");
		click(By.xpath("//button[@name='btnCustomerTypeCont']"));

		//-----------------------------Participant Details-------------------------------
		//click(link_ParticipantDetail);
		enterKeys(txt_agent, agentCode+Keys.TAB);
		enterKeys(txt_shipperCode, shipper+Keys.TAB);
		enterKeys(txt_ConsigneeCode, consignee+Keys.TAB);
		minWait();
		InitialSetup.test.log(LogStatus.INFO,
				"Successfully entered Participant Details");
		click(By.xpath("//button[@name='btnParticipantCont']"));
		minWait();

		//------------------------Certificate Details---------------------------
		if(verifyElementPresent(By.xpath("//*[@name='driverIDType']")))
		{
			selectByText(By.xpath("//*[@name='driverIDType']"), "Driving License");
			enterKeys(By.xpath("//*[@name='stateOrCountryIssuingID']"), "US");
			enterKeys(By.xpath("//*[@name='driverName']"), "Test");
			enterKeys(By.xpath("//*[@name='driverCompany']"), "IBSAT");
			//click(By.xpath("//*[@name='photoIDVerified']"));
			selectByText(By.xpath("//*[@name='photoIDVerified']"),"Yes");
			click(By.xpath("//button[@name='btnCertificateDetailsCont']"));

		}	
		scrollToView(link_BookingDetails);

		//---------------------------Shipment Details-------------------------------------
		//click(link_shipmentDetails);
		enterKeys(txt_Origin, origin);
		enterKeys(txt_destination, dest);
		enterKeys(txt_shipmentPcs, pcs);
		enterKeys(txt_shipmentwt, wt);
		enterKeys(txt_shipmentvolume, vol);
		enterKeys(By.xpath("//*[@name='shippingDate']"), fltDt+Keys.TAB);
		selectByText(By.xpath("//*[@name='shpWeightUnit']"), "lbs");
		selectByText(By.xpath("//*[@name='shpVolumeUnit']"), "cbf");
		enterKeys(txt_producttype, Product);
		selectByText(By.xpath("//*[@name='sci']"), "T1");
		enterKeys(txt_commodityCode, Commodity);
		minWait();
		// Set Dimension
		click(Icon_SetDimention);
		minWait();		
		enterKeys(txt_SetPcse, pcs);
		enterKeys(txt_SetWt, wt);
		enterKeys(txt_SetLenght, "10");
		enterKeys(txt_SetWidth, "10");
		enterKeys(txt_SetHeight, "10"+Keys.TAB+Keys.TAB);
		minWait();
		minWait();
		click(Popup_btnOK);
		minWait();
		driver.switchTo().defaultContent();
		handleAlert("Accept", "LTE001");
		minWait();
		driver.switchTo().frame("iCargoContentFrameLTE001");
		String CalcVol=driver.findElement(txt_shipmentvolume).getAttribute("value");
		PropertyHandler.setPropValue(dataFilePath, "volume",CalcVol );
		InitialSetup.test.log(LogStatus.INFO,
				"Successfully entered Shipment Details");
		click(By.xpath("//button[@name='btnShipmentCont']"));

		//--------------------Flight Details------------------------
		//click(link_BookingDetails);
		enterKeys(txt_CarrierCode, carriercode);
		enterKeys(txt_flightnumber, fltNo);
		enterKeys(txt_flightdate, fltDt1+Keys.TAB);
		String FlightDate1=driver.findElement(txt_flightdate).getAttribute("value");
		enterKeys(txt_flightdate, fltDt+Keys.TAB);
		enterKeys(txt_FlightSegment, origindestination);enterKeys(txt_FltPcs, pcs);
		minWait();
		enterKeys(txt_FltWt, wt);
		minWait();
		String todaysDt=driver.findElement(txt_flightdate).getAttribute("value");

		PropertyHandler.setPropValue(dataFilePath, "flightDt", todaysDt);
		enterKeys(txt_FltVolume, CalcVol);
		minWait();
		click(By.xpath("//div[@id='flightdetails']//i[@title='Add']"));
		InitialSetup.test.log(LogStatus.INFO,
				"Successfully entered flight details for O-D: "+origindestination+" and FLight No.- "+carrierwithFlightno1);

		//2nd flight details
		enterKeys(By.xpath("(//*[@name='flightCarrierCode'])[2]"),carriercode1);
		enterKeys(By.xpath("(//*[@name='flightNumber'])[2]"), fltNo1);
		//fltDt1=PropertyHandler.getPropValue(dataFilePath, fltDt1);
		enterKeys(By.xpath("(//*[@name='flightDate'])[2]"), FlightDate1);//full date required
		enterKeys(By.xpath("(//*[@name='flightSegment'])[2]"), origindestination1);
		enterKeys(By.xpath("(//*[@name='bookedPieces'])[2]"), pcs);
		enterKeys(By.xpath("(//*[@name='bookedWeight'])[2]"), wt);
		enterKeys(By.xpath("(//*[@name='bookedVolume'])[2]"), CalcVol);
		InitialSetup.test.log(LogStatus.INFO,
				"Successfully entered flight details for O-D: "+origindestination1+" and FLight No.- "+carrierwithFlightno1);

		click(By.xpath("//button[@name='btnFlightDtlsCont']"));
		minWait();

		//click(link_ChargeDetails)
		click(btn_Calculte);
		minWait();
		driver.switchTo().defaultContent();
		handleAlert("Accept", "LTE001");
		minWait();
		driver.switchTo().frame(screenFrame);
		minWait();
		try {
			selectByText(select_ModeofPayment, "CHECK");
		} catch (Exception e) {}

		click(By.xpath("//button[@name='btnChargeDtlsCont']"));
		minWait();

		click(btn_Save);
		maxWait();

		//pop-up: The shipper does not have a valid certificate. Do you want to continue?
		driver.switchTo().defaultContent();
		if (verifyElementPresent(info_msg))
		{
			InitialSetup.test.log(LogStatus.INFO, "Pop-up message after saving: "+
					driver.findElement(info_msg).getText());
			click(btn_genericYes);
		}

		minWait();
		waitForFrameAndSwitch(screenFrame);

		handleEmbargoPopUp();
		//embargo
		if(verifyElementPresent(By.xpath("(//button[@id='okBtn'])[2]")))
		{
			click(By.xpath("(//button[@id='okBtn'])[2]"));
		}

		
			//same pop-up
			driver.switchTo().defaultContent();
			minWait();
			//waitForFrameAndSwitch(screenFrame);
			handleAlert("Accept", "LTE001");
			minWait();
			driver.switchTo().frame(screenFrame);
		minWait();

		//Capture booking status

		String BookingStatus =driver.findElement(By.xpath("(//*[@id='overviewBar']/div/div)[2]/div")).getText();
		PropertyHandler.setPropValue(dataFilePath, "LTEBookingStatus", BookingStatus);
		
		minWait();
		maxWait();
		String AWB =driver.findElement(By.xpath("(//*[@id='overviewBar']/div/div)[1]/div")).getText();
		String awb[]= AWB.split("-");
		PropertyHandler.setPropValue(dataFilePath, prefix, awb[0]);
		PropertyHandler.setPropValue(dataFilePath, awbno, awb[1]);

		if(BookingStatus.equalsIgnoreCase("Confirmed")||BookingStatus.equalsIgnoreCase("Queued"))
		{
			InitialSetup.test.log(LogStatus.PASS, "Booking done with Status: "+BookingStatus);
			captureAndAddScreenshot();
		}
		else
		{
			InitialSetup.test.log(LogStatus.FAIL, "Booking status is not confirmed or Queued. Status"
					+ "displayed is: "+BookingStatus);
			Assert.fail("Booking status is not confirmed or Queued. Status"
					+ "displayed is: ");
		}
		
		return this;
	}

	// Sharath
	public LTE001 doBookingTwoLegsSplitBooking() {
		initiateBooking("Product", "prefix", "CustomerType");
		enterParticipantDetails("agentCode", "shipper", "consignee");
		enterShipmentDetails("origin", "dest", "fltDt1", "pcs", "wt", "commCode", "Product");
		enterFlightDetails("CarrierCode", "FlightNo1", "fltDt1", "origin", "dest", "pcs1", "wt1");
		enter2ndFlightDetails("CarrierCode", "FlightNo2", "fltDt2", "origin", "dest", "pcs2", "wt2");
		enterChargeDetails();
		return this;
	}

	public LTE001 initiateBooking(String Product, String prefix, String CustomerType) {
		minWait();
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		Product = PropertyHandler.getPropValue(dataFilePath, Product);
		CustomerType = PropertyHandler.getPropValue(dataFilePath, CustomerType);

		/*
		 * String carrierwithFlightno = carriercode + fltNo;
		 * PropertyHandler.setPropValue(dataFilePath, "carrierWithFlightno1",
		 * carrierwithFlightno);
		 * 
		 * String origindestination1 = intermediate + "-" + dest; String
		 * carrierwithFlightno1 = carriercode1 + fltNo1;
		 * PropertyHandler.setPropValue(dataFilePath, "carrierWithFlightno2",
		 * carrierwithFlightno1);
		 */

		click(btn_list);

		maxWait();
		// ------------------------------Product and Customer
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[contains(text(),'Product and Customer')]/preceding-sibling::span"))).click();
		enterKeys(txt_ProductType, Product + Keys.TAB);
		maxWait();
		selectByText(select_CustomerType, CustomerType);
		InitialSetup.test.log(LogStatus.INFO, "Successfully entered Product and Customer Details");
		click(By.xpath("//button[@name='btnCustomerTypeCont']"));
		minWait();
		return this;
	}

	public LTE001 enterParticipantDetails(String agentCode, String shipper, String consignee) {
		agentCode = PropertyHandler.getPropValue(dataFilePath, agentCode);
		shipper = PropertyHandler.getPropValue(dataFilePath, shipper);
		consignee = PropertyHandler.getPropValue(dataFilePath, consignee);
		// -----------------------------Participant
		// Details-------------------------------
		// click(link_ParticipantDetail);
		enterKeys(txt_agent, agentCode + Keys.TAB);
		enterKeys(txt_shipperCode, shipper + Keys.TAB);
		enterKeys(txt_ConsigneeCode, consignee + Keys.TAB);
		InitialSetup.test.log(LogStatus.INFO, "Successfully entered Participant Details");
		click(By.xpath("//button[@name='btnParticipantCont']"));
		minWait();
		return this;
	}

	public LTE001 enterShipmentDetails(String origin, String dest, String fltDt, String pcs, String wt, String commCode,
			String Product) {

		origin = PropertyHandler.getPropValue(dataFilePath, origin);
		dest = PropertyHandler.getPropValue(dataFilePath, dest);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		commCode = PropertyHandler.getPropValue(dataFilePath, commCode);
		Product = PropertyHandler.getPropValue(dataFilePath, Product);

		enterKeys(txt_Origin, origin);
		enterKeys(txt_destination, dest);
		enterKeys(txt_shipmentPcs, pcs);
		enterKeys(txt_shipmentwt, wt);
		// enterKeys(txt_shipmentvolume, vol);
		enterKeys(By.xpath("//*[@name='shippingDate']"), fltDt + Keys.TAB);
		// selectByText(By.xpath("//*[@name='shpWeightUnit']"), "lbs");
		// selectByText(By.xpath("//*[@name='shpVolumeUnit']"), "cbf");
		selectByText(By.name("sci"), "T1");
		if (Product.equals("COMAT")) {
			selectByText(By.name("serviceCargoClass"), "COMAT");
		}
		enterKeys(txt_producttype, Product);
		enterKeys(txt_commodityCode, commCode);
		minWait();
		// Set Dimension
		click(Icon_SetDimention);
		minWait();
		enterKeys(txt_SetPcse, pcs);
		enterKeys(txt_SetWt, wt);
		enterKeys(txt_SetLenght, "10");
		enterKeys(txt_SetWidth, "10");
		enterKeys(txt_SetHeight, "10" + Keys.TAB + Keys.TAB);
		minWait();
		minWait();
		click(Popup_btnOK);
		minWait();
		driver.switchTo().defaultContent();
		handleAlert("Accept", "LTE001");
		minWait();
		driver.switchTo().frame("iCargoContentFrameLTE001");
		String CalcVol = driver.findElement(txt_shipmentvolume).getAttribute("value");
		PropertyHandler.setPropValue(dataFilePath, "volume", CalcVol);
		InitialSetup.test.log(LogStatus.INFO, "Successfully entered Shipment Details");
		click(By.xpath("//button[@name='btnShipmentCont']"));

		return this;
	}

	public LTE001 enterFlightDetails(String CarrierCode, String FlightNo, String fltDt, String origin, String dest,
			String pcs, String wt) {
		CarrierCode = PropertyHandler.getPropValue(dataFilePath, CarrierCode);
		FlightNo = PropertyHandler.getPropValue(dataFilePath, FlightNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		origin = PropertyHandler.getPropValue(dataFilePath, origin);
		dest = PropertyHandler.getPropValue(dataFilePath, dest);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);

		String carrierwithFlightno = CarrierCode + FlightNo;
		PropertyHandler.setPropValue(dataFilePath, "carrierWithFlightno1", carrierwithFlightno);

		enterKeys(txt_CarrierCode, CarrierCode);
		enterKeys(txt_flightnumber, FlightNo);
		enterKeys(txt_flightdate, fltDt + Keys.TAB);
		enterKeys(txt_FlightSegment, origin + dest);
		enterKeys(txt_FltPcs, pcs);
		minWait();
		enterKeys(txt_FltWt, wt);
		minWait();
		String todaysDt = driver.findElement(txt_flightdate).getAttribute("value");
		PropertyHandler.setPropValue(dataFilePath, "flightDt", todaysDt);
		// enterKeys(txt_FltVolume, CalcVol);
		minWait();
		InitialSetup.test.log(LogStatus.INFO, "Successfully entered flight details for O-D: " + origin + dest
				+ " and FLight No.- " + carrierwithFlightno);

		return this;
	}

	public LTE001 enter2ndFlightDetails(String CarrierCode, String FlightNo2, String fltDt2, String origin, String dest,
			String pcs, String wt) {
		CarrierCode = PropertyHandler.getPropValue(dataFilePath, CarrierCode);
		FlightNo2 = PropertyHandler.getPropValue(dataFilePath, FlightNo2);
		fltDt2 = PropertyHandler.getPropValue(dataFilePath, fltDt2);
		origin = PropertyHandler.getPropValue(dataFilePath, origin);
		dest = PropertyHandler.getPropValue(dataFilePath, dest);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);

		String carrierwithFlightno2 = CarrierCode + FlightNo2;
		PropertyHandler.setPropValue(dataFilePath, "carrierWithFlightno2", carrierwithFlightno2);
		// 2nd flight details
		click(By.xpath("//div[@id='flightdetails']//i[@title='Add']"));
		minWait();
		enterKeys(By.xpath("(//*[@name='flightCarrierCode'])[2]"), CarrierCode);
		enterKeys(By.xpath("(//*[@name='flightNumber'])[2]"), FlightNo2);
		enterKeys(By.xpath("(//*[@name='flightDate'])[2]"), fltDt2);// full date
																	// required
		enterKeys(By.xpath("(//*[@name='flightSegment'])[2]"), origin + dest);
		enterKeys(By.xpath("(//*[@name='bookedPieces'])[2]"), pcs);
		enterKeys(By.xpath("(//*[@name='bookedWeight'])[2]"), wt);
		// enterKeys(By.xpath("(//*[@name='bookedVolume'])[2]"), CalcVol);
		InitialSetup.test.log(LogStatus.INFO, "Successfully entered flight details for O-D: " + origin + dest
				+ " and FLight No.- " + carrierwithFlightno2);

		click(By.xpath("//button[@name='btnFlightDtlsCont']"));
		minWait();
		return this;
	}

	public LTE001 enterChargeDetails() {
		// click(link_ChargeDetails)
		click(btn_Calculte);
		minWait();
		driver.switchTo().defaultContent();
		handleAlert("Accept", "LTE001");
		minWait();
		driver.switchTo().frame(screenFrame);
		minWait();
		/*
		 * try { selectByText(select_ModeofPayment, "CASH"); } catch (Exception
		 * e) {}
		 */
		click(By.xpath("//button[@name='btnChargeDtlsCont']"));
		minWait();
		click(btn_Save);
		maxWait();
		// pop-up: The shipper does not have a valid certificate. Do you want to
		// continue?
		driver.switchTo().defaultContent();
		if (verifyElementPresent(info_msg)) {
			InitialSetup.test.log(LogStatus.INFO,
					"Pop-up message after saving: " + driver.findElement(info_msg).getText());
			click(btn_genericYes);
		}

		minWait();
		waitForFrameAndSwitch(screenFrame);

		// embargo
		if (verifyElementPresent(By.xpath("(//button[@id='okBtn'])[2]"))) {
			click(By.xpath("(//button[@id='okBtn'])[2]"));
		}

		/*
		 * //same pop-up driver.switchTo().defaultContent(); minWait();
		 * //waitForFrameAndSwitch(screenFrame); handleAlert("Accept",
		 * "LTE001"); minWait(); driver.switchTo().frame(screenFrame);
		 */
		minWait();

		// Capture booking status

		String BookingStatus = driver.findElement(By.xpath("(//*[@id='overviewBar']/div/div)[2]/div")).getText();
		PropertyHandler.setPropValue(dataFilePath, "LTEBookingStatus", BookingStatus);

		if (BookingStatus.equalsIgnoreCase("Confirmed") || BookingStatus.equalsIgnoreCase("Queued")) {

			String preAwb = getText_JS(By.xpath("//a[contains(@class,'awb-number')]"));
			String awb[] = preAwb.split("-");
			PropertyHandler.setPropValue(dataFilePath, "awbno", awb[1]);
			InitialSetup.test.log(LogStatus.PASS,
					"Booking done with Status: " + BookingStatus + " and Awb No. : " + awb[1]);

		} else {
			InitialSetup.test.log(LogStatus.FAIL,
					"Booking status is not confirmed or Queued. Status" + "displayed is: " + BookingStatus);
			Assert.fail("Booking status is not confirmed or Queued. Status" + "displayed is: ");
		}
		return this;
	}

	/**
	 * @author A-8452 Faizan Description: Only to give mode of payment and click
	 *         on verify AWB checkbox for performing AWB capture
	 * @param prefix
	 * @param awbno
	 * @param ModeofPayment
	 * @return
	 */
	public LTE001 doCapture(String prefix, String awbno, String ModeofPayment) {
		minWait();
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		listAWB(prefix, awbno);
		maxWait();
		click(By.xpath("//*[@id='view_header_chargeDtls']"));
		minWait();
		String totalPrice = driver.findElement(By.xpath("//span[@class='mar-t-xs']")).getText();
		PropertyHandler.setPropValue(dataFilePath, "totalChargeDisplayed", totalPrice);
		maxWait();
		click(btn_AwbVerified);
		InitialSetup.test.log(LogStatus.PASS, "Successfully clicked on AWB verification checkbox");
		click(btn_Save);
		maxWait();
		if (verifyElementPresent(info_msg)) {
			InitialSetup.test.log(LogStatus.INFO,
					"Pop-up message after Save Button Click: " + driver.findElement(info_msg).getText());
			click(btn_genericYes);
		}
		// embargo
		if (verifyElementPresent(By.xpath("(//button[@id='okBtn'])[2]"))) {
			click(By.xpath("(//button[@id='okBtn'])[2]"));
		}
		minWait();
		String CaptureStatus = driver.findElement(By.xpath("(//*[@id='overviewBar']/div/div)[3]/div")).getText();
		PropertyHandler.setPropValue(dataFilePath, "CaptureStatus", CaptureStatus);

		if (CaptureStatus.equalsIgnoreCase("Executed")) {
			InitialSetup.test.log(LogStatus.PASS, "Successfully Executed AWB. AWB Capture Status: " + CaptureStatus);
			captureAndAddScreenshot();
		} else {
			InitialSetup.test.log(LogStatus.FAIL, "Could not execute AWB. Data Capture Status: " + CaptureStatus);
			Assert.fail("Cannot Execute AWB");
		}
		return this;
	}

	/**
	 * @author A-8452 Faizan Description: To perform acceptance operation in
	 *         LTE001
	 * @param pcs
	 * @param wt
	 * @param vol
	 * @param ModeofPayment
	 * @param UldNumber
	 * @param UldNeeded
	 * @return
	 */
	public LTE001 doAcceptance(String pcs, String wt, String vol, String UldNumber, boolean UldNeeded,
			String ScreenMethod, String ScreenResult) {
		
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		vol = PropertyHandler.getPropValue(dataFilePath, vol);
		ScreenMethod = PropertyHandler.getPropValue(dataFilePath, ScreenMethod);
		ScreenResult = PropertyHandler.getPropValue(dataFilePath, ScreenResult);
		// UldNumber= PropertyHandler.getPropValue(dataFileName, UldNumber);
		maxWait();
		scrollToView(By.xpath("//div[contains(text(),'Acceptance Details')]/parent::div/span"));
		minWait();
		click(By.xpath("//div[contains(text(),'Acceptance Details')]/parent::div/span"));	
		enterKeys(txt_pieces, pcs);
		enterKeys(txt_weight, wt);
		minWait();
		enterKeys(txt_volume, vol);
		minWait();

		if (UldNeeded == true)// if uld details needs to be given, then true
								// else false
		{
			UldNumber = PropertyHandler.getPropValue(dataFilePath, UldNumber);
			// enterKeys(Txt_ULD,UldNumber);
			enterKeys(By.id("uldNumer_u"), UldNumber);
			enterKeys(By.xpath("//*[contains(text(),'Location')]/following-sibling::input"), "ACP-A-1-A");
		}
		// selectByText(By.name("acpWghtUnit"), "lbs");
		// selectByText(By.name("acpVolumeUnit"), "cbf");

		click(txt_AcceptAll);
		click(By.xpath("//*[@name='btnAcceptanceDtlsCont']"));
		minWait();
		// Screening
		// click(Link_Screendetails);
		selectByText(select_ScreenMethod, ScreenMethod);
		enterKeys(txt_screenPcs, pcs);
		selectByText(select_screenPassFail, ScreenResult);
		minWait();
		click(btn_Save);
		maxWait();
		if (verifyElementPresent(By.xpath("//div[@id='EmbargoDiv']//button[@name='okBtn']"))) {
			captureAndAddScreenshot();
			click(By.xpath("//div[@id='EmbargoDiv']//button[@name='okBtn']"));
		}
		maxWait();
		driver.switchTo().defaultContent();
		handleAlert("Accept", "LTE001");
		maxWait();
		driver.switchTo().frame(screenFrame);
		if (verifyElementPresent(info_msg)) {
			InitialSetup.test.log(LogStatus.INFO,
					"Pop-up message after Save Button Click: " + driver.findElement(info_msg).getText());
			click(btn_genericYes);
		}
		if (verifyElementPresent(info_msg)) {
			InitialSetup.test.log(LogStatus.INFO,
					"Pop-up message after Save Button Click: " + driver.findElement(info_msg).getText());
			click(btn_genericYes);
		}
		String AcceptanceStatus = driver.findElement(By.xpath("(//*[@id='overviewBar']/div/div)[4]/div")).getText();
		PropertyHandler.setPropValue(dataFilePath, "AcceptanceStatus", AcceptanceStatus);
		if (AcceptanceStatus.equalsIgnoreCase("Finalised")) {
			InitialSetup.test.log(LogStatus.PASS,
					"Successfully Accepted Goods. Acceptance Status: " + AcceptanceStatus);
			captureAndAddScreenshot();
		} else {
			InitialSetup.test.log(LogStatus.FAIL, "Could not Accept Goods. Acceptance Status: " + AcceptanceStatus);
			Assert.fail("Could not Accept Goods");
		}

		return this;
	}

	/**
	 * @author A-8452 Faizan Description: fetching values from properties file
	 *         and listing with AWB
	 * @param prefix
	 * @param awbno
	 * @return
	 */
	public LTE001 getValuesAndlistAWB(String prefix, String awbno) {
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		enterKeys(txt_carrierCode, prefix);
		enterKeys(txt_awbNo, awbno);
		click(btn_list);
		minWait();
		InitialSetup.test.log(LogStatus.INFO,
				"Successfully entertered Carrier code and AWB No:" + prefix + "-" + awbno);

		return this;
	}

	/**
	 * @author A-8452 Faizan Description: For performing Booking only for single
	 *         leg Without Certificate Listing Option
	 * @param carriercode
	 * @param awbno
	 * @param fltNo
	 * @param fltDt
	 * @param Product
	 * @param agentCode
	 * @param shipper
	 * @param consignee
	 * @param origin
	 * @param dest
	 * @param pcs
	 * @param wt
	 * @param vol
	 * @param Commodity
	 * @param prefix
	 * @return
	 */
	public LTE001 doBookingWithoutCertificateDetails(String carriercode, String awbno, String fltNo, String fltDt,
			String Product, String agentCode, String shipper, String consignee, String origin, String dest, String pcs,
			String wt, String vol, String Commodity, String prefix, String CustomerType) {

		minWait();
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		Product = PropertyHandler.getPropValue(dataFilePath, Product);
		agentCode = PropertyHandler.getPropValue(dataFilePath, agentCode);
		shipper = PropertyHandler.getPropValue(dataFilePath, shipper);
		consignee = PropertyHandler.getPropValue(dataFilePath, consignee);
		origin = PropertyHandler.getPropValue(dataFilePath, origin);
		dest = PropertyHandler.getPropValue(dataFilePath, dest);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		vol = PropertyHandler.getPropValue(dataFilePath, vol);
		Commodity = PropertyHandler.getPropValue(dataFilePath, Commodity);
		carriercode = PropertyHandler.getPropValue(dataFilePath, carriercode);
		CustomerType = PropertyHandler.getPropValue(dataFilePath, CustomerType);

		String orgindestination = origin + "-" + dest;
		String carrierwithFlightno = carriercode + fltNo;
		PropertyHandler.setPropValue(dataFilePath, "carrierwithFlightno", carrierwithFlightno);

		listAWB(prefix, awbno);

		InitialSetup.test.log(LogStatus.INFO,
				"Successfully entertered Carrier code and AWB No:" + prefix + "-" + awbno);
		maxWait();
		minWait();
		enterKeys(txt_ProductType, Product + Keys.TAB);
		selectByText(select_CustomerType, CustomerType);
		click(By.xpath("//button[@name='btnCustomerTypeCont']"));
		minWait();

		// click(link_ParticipantDetail);
		enterKeys(txt_agent, agentCode + Keys.TAB);
		enterKeys(txt_shipperCode, shipper + Keys.TAB);
		enterKeys(txt_ConsigneeCode, consignee + Keys.TAB);
		click(By.xpath("//button[@name='btnParticipantCont']"));
		minWait();

		// scrollToView(link_BookingDetails);

		// click(link_shipmentDetails);
		enterKeys(txt_Origin, origin);
		enterKeys(txt_destination, dest);
		enterKeys(txt_shipmentPcs, pcs);
		enterKeys(txt_shipmentwt, wt);
		enterKeys(txt_shipmentvolume, vol);
		enterKeys(txt_producttype, Product);
		enterKeys(By.xpath("//*[@name='shippingDate']"), fltDt);
		selectByText(By.xpath("//*[@name='shpWeightUnit']"), "lbs");
		selectByText(By.xpath("//*[@name='shpVolumeUnit']"), "CBF");
		if (Product.equalsIgnoreCase("PPS")) {
			selectByText(By.xpath("//*[@name='ppsCommodityCode']"), Commodity);
		} else {
			enterKeys(txt_commodityCode, Commodity);
		}
		minWait();
		// Set Dimension
		click(Icon_SetDimention);
		minWait();
		enterKeys(txt_SetPcse, pcs);
		// driver.findElement(By.xpath("(//div[@name='dimensionsPanelTagName']//input[@name='dimensionPcs'])[1]")).sendKeys(pcs);
		enterKeys(txt_SetWt, wt);
		enterKeys(txt_SetLenght, "10");
		enterKeys(txt_SetWidth, "10");
		enterKeys(txt_SetHeight, "10" + Keys.TAB);
		enterKeys(txt_SetHeight, Keys.TAB);
		minWait();
		// driver.findElement(By.xpath("(//input[@name='dimensionHeight'])[4]"))
		// .click();
		minWait();
		click(Popup_btnOK);
		minWait();
		driver.switchTo().defaultContent();
		handleAlert("Accept", "LTE001");
		minWait();
		waitForFrameAndSwitch(screenFrame);
		String CalcVol = driver.findElement(txt_shipmentvolume).getAttribute("value");
		PropertyHandler.setPropValue(dataFilePath, "volume", CalcVol);
		click(By.xpath("//button[@name='btnShipmentCont']"));
		minWait();

		// click(link_BookingDetails);
		minWait();
		enterKeys(txt_CarrierCode, carriercode);
		enterKeys(txt_flightnumber, fltNo);
		enterKeys(txt_flightdate, fltDt);
		enterKeys(txt_FlightSegment, orgindestination);
		enterKeys(txt_FltPcs, pcs);
		minWait();
		enterKeys(txt_FltWt, wt);
		minWait();
		String flightDt = driver.findElement(txt_flightdate).getAttribute("value");

		PropertyHandler.setPropValue(dataFilePath, "flightDt", flightDt);
		vol = PropertyHandler.getPropValue(dataFilePath, "volume");
		enterKeys(txt_FltVolume, vol);
		click(By.xpath("//button[@name='btnFlightDtlsCont']"));
		minWait();
		minWait();
		driver.switchTo().defaultContent();
		handleAlert("Accept", "LTE001");
		minWait();
		waitForFrameAndSwitch(screenFrame);

		// click(link_ChargeDetails);
		minWait();
		click(btn_Calculte);
		minWait();
		driver.switchTo().defaultContent();
		handleAlert("Accept", "LTE001");
		minWait();
		waitForFrameAndSwitch(screenFrame);
		minWait();
		try {
			selectByText(select_ModeofPayment, "CASH");
		} catch (Exception e) {
		}

		click(By.xpath("//button[@name='btnChargeDtlsCont']"));
		minWait();
		click(btn_Save);
		maxWait();

		// pop-up: The shipper does not have a valid certificate. Do you want to
		// continue?
		driver.switchTo().defaultContent();
		if (verifyElementPresent(info_msg)) {
			InitialSetup.test.log(LogStatus.INFO,
					"Pop-up message after saving: " + driver.findElement(info_msg).getText());
			click(btn_genericYes);
			minWait();
		}
		waitForFrameAndSwitch(screenFrame);

		// embargo
		/*
		 * if(verifyElementPresent(By.xpath("(//button[@id='okBtn'])[2]"))) {
		 * click(By.xpath("(//button[@id='okBtn'])[2]")); }
		 * 
		 * 
		 * //same pop-up driver.switchTo().defaultContent(); minWait();
		 * //waitForFrameAndSwitch(screenFrame); handleAlert("Accept",
		 * "LTE001"); minWait(); driver.switchTo().frame(screenFrame);
		 */
		minWait();

		// Capture booking status

		String BookingStatus = driver.findElement(By.xpath("(//*[@id='overviewBar']/div/div)[2]/div")).getText();
		PropertyHandler.setPropValue(dataFilePath, "LTEBookingStatus", BookingStatus);

		if (BookingStatus.equalsIgnoreCase("Confirmed") || BookingStatus.equalsIgnoreCase("Queued")) {
			InitialSetup.test.log(LogStatus.PASS, "Booking done with Status: " + BookingStatus);
		} else {
			InitialSetup.test.log(LogStatus.FAIL,
					"Booking status is not confirmed or Queued. Status" + "displayed is: " + BookingStatus);
			Assert.fail("Booking status is not confirmed or Queued. Status" + "displayed is: ");
		}
		return this;
	}

	/**
	 * @author A-8452 Faizan Description: For performing Booking only for single
	 *         leg
	 * @param carriercode
	 * @param awbno
	 * @param fltNo
	 * @param fltDt
	 * @param Product
	 * @param agentCode
	 * @param shipper
	 * @param consignee
	 * @param origin
	 * @param dest
	 * @param pcs
	 * @param wt
	 * @param vol
	 * @param Commodity
	 * @param prefix
	 * @return
	 */
	public LTE001 doPPSBookingOnly(String carriercode, String awbno, String fltNo, String fltDt, String Product,
			String agentCode, String shipper, String consignee, String origin, String dest, String pcs, String wt,
			String vol, String Commodity, String prefix, String CustomerType) {

		minWait();
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		Product = PropertyHandler.getPropValue(dataFilePath, Product);
		agentCode = PropertyHandler.getPropValue(dataFilePath, agentCode);
		shipper = PropertyHandler.getPropValue(dataFilePath, shipper);
		consignee = PropertyHandler.getPropValue(dataFilePath, consignee);
		origin = PropertyHandler.getPropValue(dataFilePath, origin);
		dest = PropertyHandler.getPropValue(dataFilePath, dest);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		vol = PropertyHandler.getPropValue(dataFilePath, vol);
		Commodity = PropertyHandler.getPropValue(dataFilePath, Commodity);
		carriercode = PropertyHandler.getPropValue(dataFilePath, carriercode);
		CustomerType = PropertyHandler.getPropValue(dataFilePath, CustomerType);

		String orgindestination = origin + "-" + dest;
		String carrierwithFlightno = carriercode + fltNo;
		PropertyHandler.setPropValue(dataFilePath, "carrierwithFlightno", carrierwithFlightno);

		listAWB(prefix, awbno);

		maxWait();
		minWait();
		enterKeys(txt_ProductType, Product + Keys.TAB);
		selectByText(select_CustomerType, CustomerType);
		if (CustomerType.equalsIgnoreCase("Employee")) {
			enterKeys(By.xpath("//*[@name='employeeId']"), "00937305");
			click(By.xpath("//input[@name='btnVerifyEmployeeId']"));

			minWait();
			driver.switchTo().defaultContent();
			handleAlert("Accept", "LTE001");
			InitialSetup.test.log(LogStatus.INFO, "Employee Verified Successfully");
			minWait();
			driver.switchTo().frame(screenFrame);
			minWait();
		}
		click(By.xpath("//button[@name='btnCustomerTypeCont']"));
		minWait();

		// click(link_ParticipantDetail);
		enterKeys(txt_agent, agentCode + Keys.TAB);
		enterKeys(txt_shipperCode, shipper + Keys.TAB);
		enterKeys(txt_ConsigneeCode, consignee + Keys.TAB);
		click(By.xpath("//button[@name='btnParticipantCont']"));
		minWait();
		// ------------------------Certificate
		// Details---------------------------
		if (verifyElementPresent(By.xpath("//*[@name='driverIDType']"))) {
			selectByText(By.xpath("//*[@name='driverIDType']"), "License");
			enterKeys(By.xpath("//*[@name='stateOrCountryIssuingID']"), "US");
			enterKeys(By.xpath("//*[@name='driverName']"), "Test");
			enterKeys(By.xpath("//*[@name='driverCompany']"), "IBSAT");
			click(By.xpath("//*[@name='photoIDVerified']"));

			click(By.xpath("//button[@name='btnCertificateDetailsCont']"));
		}

		scrollToView(link_BookingDetails);

		// click(link_shipmentDetails);
		enterKeys(By.xpath("//*[@name='ppsOrigin']"), origin);
		enterKeys(By.xpath("//*[@name='ppsDestination']"), dest);
		enterKeys(By.xpath("//*[@name='ppsShpPcs']"), pcs);
		enterKeys(By.xpath("//*[@name='ppsShpWgt']"), wt);
		enterKeys(By.xpath("//*[@name='ppsShpVol']"), vol);
		enterKeys(By.xpath("//*[@name='ppsShippingDate']"), fltDt + Keys.TAB);
		selectByText(By.xpath("//*[@name='ppsRatingWeightUnit']"), "lbs");
		selectByText(By.xpath("//*[@name='ppsRatingVolumeUnit']"), "cbf");
		// enterKeys(By.xpath(""), Product);

		selectByText(By.xpath("//*[@name='ppsCommodityCode']"), Commodity);

		minWait();
		// Set Dimension Not there

		/*
		 * click(Icon_SetDimention); minWait(); enterKeys(txt_SetPcse, pcs);
		 * //driver.findElement(By.xpath(
		 * "(//div[@name='dimensionsPanelTagName']//input[@name='dimensionPcs'])[1]"
		 * )).sendKeys(pcs); enterKeys(txt_SetWt, wt); enterKeys(txt_SetLenght,
		 * "10"); enterKeys(txt_SetWidth, "10"); enterKeys(txt_SetHeight,
		 * "10"+Keys.TAB); enterKeys(txt_SetHeight,Keys.TAB); minWait();
		 * //driver.findElement(By.xpath("(//input[@name='dimensionHeight'])[4]"
		 * )).click(); minWait(); click(Popup_btnOK); minWait();
		 * driver.switchTo().defaultContent(); handleAlert("Accept", "LTE001");
		 * minWait(); driver.switchTo().frame("iCargoContentFrameLTE001");
		 */

		enterKeys(By.xpath("//*[@name='ppsDimensionLength']"), "10" + Keys.TAB);
		enterKeys(By.xpath("//*[@name='ppsDimensionWidth']"), "10" + Keys.TAB);
		enterKeys(By.xpath("//*[@name='ppsDimensionHeight']"), "10" + Keys.TAB);

		String CalcVol = driver.findElement(By.xpath("//*[@name='ppsShpVol']")).getAttribute("value");
		PropertyHandler.setPropValue(dataFilePath, "volume", CalcVol);
		click(By.xpath("//button[@name='btnPPSShipmentCont']"));
		minWait();

		// click(link_BookingDetails);
		minWait();
		enterKeys(txt_CarrierCode, carriercode);
		enterKeys(txt_flightnumber, fltNo);
		enterKeys(txt_flightdate, fltDt);
		enterKeys(txt_FlightSegment, orgindestination);
		enterKeys(txt_FltPcs, pcs);
		minWait();
		enterKeys(txt_FltWt, wt);
		minWait();
		String flightDt = driver.findElement(txt_flightdate).getAttribute("value");

		PropertyHandler.setPropValue(dataFilePath, "flightDt", flightDt);
		vol = PropertyHandler.getPropValue(dataFilePath, "volume");
		enterKeys(txt_FltVolume, vol);
		click(By.xpath("//button[@name='btnFlightDtlsCont']"));
		minWait();

		// click(link_ChargeDetails);
		minWait();
		click(btn_Calculte);
		minWait();
		driver.switchTo().defaultContent();
		handleAlert("Accept", "LTE001");
		minWait();
		driver.switchTo().frame(screenFrame);
		minWait();
		try {
			selectByText(select_ModeofPayment, "CASH");
		} catch (Exception e) {
		}

		click(By.xpath("//button[@name='btnChargeDtlsCont']"));
		minWait();
		click(btn_Save);
		maxWait();

		// pop-up: The shipper does not have a valid certificate. Do you want to
		// continue?
		driver.switchTo().defaultContent();
		if (verifyElementPresent(info_msg)) {
			InitialSetup.test.log(LogStatus.INFO,
					"Pop-up message after saving: " + driver.findElement(info_msg).getText());
			click(btn_genericYes);
			minWait();
		}
		waitForFrameAndSwitch(screenFrame);

		// embargo
		/*
		 * if(verifyElementPresent(By.xpath("(//button[@id='okBtn'])[2]"))) {
		 * click(By.xpath("(//button[@id='okBtn'])[2]")); }
		 * 
		 * 
		 * //same pop-up driver.switchTo().defaultContent(); minWait();
		 * //waitForFrameAndSwitch(screenFrame); handleAlert("Accept",
		 * "LTE001"); minWait(); driver.switchTo().frame(screenFrame);
		 */
		minWait();

		// Capture booking status

		String BookingStatus = driver.findElement(By.xpath("(//*[@id='overviewBar']/div/div)[2]/div")).getText();
		PropertyHandler.setPropValue(dataFilePath, "LTEBookingStatus", BookingStatus);

		if (BookingStatus.equalsIgnoreCase("Confirmed") || BookingStatus.equalsIgnoreCase("Queued")) {
			InitialSetup.test.log(LogStatus.PASS, "Booking done with Status: " + BookingStatus);
			captureAndAddScreenshot();
		} else {
			InitialSetup.test.log(LogStatus.FAIL,
					"Booking status is not confirmed or Queued. Status" + "displayed is: " + BookingStatus);
			Assert.fail("Booking status is not confirmed or Queued. Status" + "displayed is: ");
		}
		return this;
	}

	/**
	 * @author A-8452 Faizan
	 * @param listingNeeded
	 * @param paymentType
	 * @param prefix
	 * @param awbno
	 * @return
	 */

	public LTE001 editPaymentOption(Boolean listingNeeded, String paymentType, String prefix, String awbno) {
		if (listingNeeded == true)
			getValuesAndlistAWB(prefix, awbno);
		paymentType = PropertyHandler.getPropValue(dataFilePath, paymentType);
		minWait();
		// click(By.xpath("//*[@id='view_header_chargeDtls']"));
		click(By.xpath("//*[@id='charge']//div[@id='view_header_chargeDtls']"));
		minWait();
		/*
		 * click(btn_Calculte); minWait();
		 */
		String totalPrice = driver.findElement(By.xpath("//span[@class='mar-t-xs']")).getText();
		PropertyHandler.setPropValue(dataFilePath, "totalCharge", totalPrice);
		click(By.xpath("//a[@flipper='edit_chargeDetails']//i[@class='icon ico-pencil-rounded-orange']")); // edit
																											// icon
		minWait();
		scrollToView(select_ModeofPayment);
		selectByText(select_ModeofPayment, paymentType);
		click(By.xpath("//button[@name='btnChargeDtlsCont']"));
		minWait();
		click(btn_Save);
		return this;
	}

	public LTE001 editPaymentOptionCredit(Boolean listingNeeded, String paymentType, String prefix, String awbno) {
		if (listingNeeded == true)
			getValuesAndlistAWB(prefix, awbno);
		paymentType = PropertyHandler.getPropValue(dataFilePath, paymentType);
		minWait();
		// click(By.xpath("//*[@id='view_header_chargeDtls']"));
		click(By.xpath("//*[@id='charge']//div[@id='view_header_chargeDtls']"));
		minWait();
		/*
		 * click(btn_Calculte); minWait();
		 */
		String totalPrice = driver.findElement(By.xpath("//span[@class='mar-t-xs']")).getText();
		PropertyHandler.setPropValue(dataFilePath, "totalCharge", totalPrice);
		click(By.xpath("//a[@flipper='edit_chargeDetails']//i[@class='icon ico-pencil-rounded-orange']")); // edit
																											// icon
		minWait();
		// scrollToView(select_ModeofPayment);
		// selectByText(select_ModeofPayment, paymentType);
		click(By.xpath("//button[@name='btnChargeDtlsCont']"));
		minWait();
		click(btn_Save);
		return this;
	}

	/**
	 * @author A-8452 Faizan
	 * @param listingNeeded
	 * @param shipper
	 * @param consignee
	 * @param agent
	 * @param prefix
	 * @param awbno
	 * @return
	 */
	public LTE001 editParticipantDetails(Boolean listingNeeded, String shipper, String consignee, String agent,
			String prefix, String awbno) {
		if (listingNeeded == true)
			getValuesAndlistAWB(prefix, awbno);
		minWait();
		agent = PropertyHandler.getPropValue(dataFilePath, agent);
		shipper = PropertyHandler.getPropValue(dataFilePath, shipper);
		consignee = PropertyHandler.getPropValue(dataFilePath, consignee);
		click(By.xpath("//*[@id='participant']//div[@id='view_header_participant']"));
		click(By.xpath("//a[@flipper='edit_particpant']//i[@class='icon ico-pencil-rounded-orange']")); // edit
																										// icon
		enterKeys(txt_agent, agent + Keys.TAB);
		enterKeys(txt_shipperCode, shipper + Keys.TAB);
		enterKeys(txt_ConsigneeCode, consignee + Keys.TAB);
		click(By.xpath("//button[@name='btnParticipantCont']"));
		minWait();
		minWait();
		return this;
	}

	/**
	 * @author A-8452 Faizan
	 * @param pcs
	 * @param wt
	 * @param vol
	 * @param UldNumber
	 * @param UldNeeded
	 * @return
	 */
	public LTE001 doAcceptanceOnly(String pcs, String wt, String vol, String UldNumber, boolean UldNeeded) {
		minWait();
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		vol = PropertyHandler.getPropValue(dataFilePath, vol);
		maxWait();
		// Accepatance operations
		// click(link_AcceptanceDetails);
		click(By.xpath("//div[contains(text(),'Acceptance Details')]/parent::div/span"));
		// click(By.xpath("(//div[contains(text(),'Acceptance
		// Details')])[last()]"));

		// click(By.xpath("(//*[@class='ui-accordion-header-icon ui-icon
		// ui-icon-triangle-1-e'])[8]"));
		enterKeys(txt_pieces, pcs);
		enterKeys(txt_weight, wt);
		minWait();
		enterKeys(txt_volume, vol);
		minWait();

		if (UldNeeded == true)// if uld details needs to be given, then true
								// else false
		{
			UldNumber = PropertyHandler.getPropValue(dataFileName, UldNumber);
			enterKeys(Txt_ULD, UldNumber);
		}
		click(txt_AcceptAll);
		click(By.xpath("//*[@name='btnAcceptanceDtlsCont']"));
		minWait();

		minWait();
		click(btn_Save);
		maxWait();
		driver.switchTo().defaultContent();
		handleAlert("Accept", "LTE001");
		maxWait();
		driver.switchTo().frame(screenFrame);

		if (verifyElementPresent(info_msg)) {
			InitialSetup.test.log(LogStatus.INFO,
					"Pop-up message after Save Button Click: " + driver.findElement(info_msg).getText());
			click(btn_genericYes);
		}

		if (verifyElementPresent(info_msg)) {
			InitialSetup.test.log(LogStatus.INFO,
					"Pop-up message after Save Button Click: " + driver.findElement(info_msg).getText());
			click(btn_genericYes);
		}

		String AcceptanceStatus = driver.findElement(By.xpath("(//*[@id='overviewBar']/div/div)[4]/div")).getText();
		PropertyHandler.setPropValue(dataFilePath, "AcceptanceStatus", AcceptanceStatus);

		if (AcceptanceStatus.equalsIgnoreCase("Finalised")) {
			InitialSetup.test.log(LogStatus.PASS,
					"Successfully Accepted Goods. Acceptance Status: " + AcceptanceStatus);
			captureAndAddScreenshot();
		} else {
			InitialSetup.test.log(LogStatus.FAIL, "Could not Accept Goods. Acceptance Status: " + AcceptanceStatus);
			Assert.fail("Could not Accept Goods");
		}

		return this;
	}

	/**
	 * @author A-8452 Faizan
	 * @param ScreenMethod
	 * @param ScreenResult
	 * @param pcs
	 * @return
	 */
	public LTE001 doScreeningOnly(String ScreenMethod, String ScreenResult, String pcs) {
		minWait();
		ScreenMethod = PropertyHandler.getPropValue(dataFilePath, ScreenMethod);
		ScreenResult = PropertyHandler.getPropValue(dataFilePath, ScreenResult);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);

		click(By.xpath("//div[contains(text(),'Screening Details')]/parent::div/span"));
		minWait();
		selectByText(select_ScreenMethod, ScreenMethod);
		enterKeys(txt_screenPcs, pcs);
		selectByText(select_screenPassFail, ScreenResult);
		minWait();
		click(btn_Save);
		maxWait();
		driver.switchTo().defaultContent();
		handleAlert("Accept", "LTE001");
		maxWait();
		driver.switchTo().frame(screenFrame);

		if (verifyElementPresent(info_msg)) {
			InitialSetup.test.log(LogStatus.INFO,
					"Pop-up message after Save Button Click: " + driver.findElement(info_msg).getText());
			click(btn_genericYes);
		}

		if (verifyElementPresent(info_msg)) {
			InitialSetup.test.log(LogStatus.INFO,
					"Pop-up message after Save Button Click: " + driver.findElement(info_msg).getText());
			click(btn_genericYes);
		}

		String AcceptanceStatus = driver.findElement(By.xpath("(//*[@id='overviewBar']/div/div)[4]/div")).getText();
		PropertyHandler.setPropValue(dataFilePath, "AcceptanceStatus", AcceptanceStatus);

		if (AcceptanceStatus.equalsIgnoreCase("Finalised")) {
			InitialSetup.test.log(LogStatus.PASS,
					"Successfully Accepted Goods. Acceptance Status: " + AcceptanceStatus);
			captureAndAddScreenshot();
		} else {
			InitialSetup.test.log(LogStatus.FAIL, "Could not Accept Goods. Acceptance Status: " + AcceptanceStatus);
			Assert.fail("Could not Accept Goods");
		}

		return this;
	}

	/**
	 * @author A-8457 Souvik Description: Only to give mode of payment and click
	 *         on verify AWB checkbox for performing AWB capture It will also
	 *         add teh shipper and the consignee
	 * @param prefix
	 * @param awbno
	 * @param ModeofPayment
	 * @return
	 */
	public LTE001 doCaptureWithShipperConsignee(String prefix, String awbno, String ModeofPayment, String shipper,
			String consignee) {
		minWait();
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		ModeofPayment = PropertyHandler.getPropValue(dataFilePath, ModeofPayment);
		shipper = PropertyHandler.getPropValue(dataFilePath, shipper);
		consignee = PropertyHandler.getPropValue(dataFilePath, consignee);
		listAWB(prefix, awbno);
		maxWait();
		// Checksheet
		if (PropertyHandler.getPropValue(dataFilePath, "commCode").equalsIgnoreCase("CATDOG") && verifyElementPresent(By
				.xpath("//span[contains(text(),'Capture check sheet')]/preceding-sibling::div/i[contains(@class,'warning')]"))) {
			fillCheckSheet(PropertyHandler.getPropValue(dataFilePath, "commCode"));
			handleAlert("Accept", "LTE001");
			waitForFrameAndSwitch(screenFrame);
			maxWait();
		}
		//
		String scineeded = PropertyHandler.getPropValue(dataFilePath, "SCIneeded");
		if (scineeded != null && scineeded.equalsIgnoreCase("Yes")) {
			click(By.xpath("//div[@id='shipmentaccordion']/span"));
			click(By.xpath("//a[@flipper='edit_shipmetdtls']"));
			minWait();
			selectByText(By.xpath("//select[@name='sci']"), "T1");
		}
		maxWait();
		click(By.xpath("//div[@id='participant']/span"));
		minWait();
		click(By.xpath("//a[@flipper='edit_particpant']"));
		enterKeys(txt_shipperCode, shipper + Keys.TAB);
		enterKeys(txt_ConsigneeCode, consignee + Keys.TAB);
		minWait();
		click(By.xpath("//button[@name='btnParticipantCont']"));
		minWait();
		if (driver.findElements(By.xpath("//input[@name='driverName']")).size() > 0) {
			enterKeys(By.xpath("//input[@name='driverName']"), "Test Driver");
			enterKeys(By.xpath("//input[@name='driverCompany']"), "Test Company");
			scrollToView(By.name("btnCertificateDetailsCont"));
			selectByText(By.xpath("//select[@name='driverIDType']"), "Driving License");
			enterKeys(By.xpath("//input[@name='stateOrCountryIssuingID']"), "US");
			selectByText(By.xpath("//select[@name='photoIDVerified']"), "Yes");
			minWait();
			click(By.name("btnCertificateDetailsCont"));
			minWait();
		}
//		
//		  click(btn_Save); maxWait(); // Checksheet
//		  if(PropertyHandler.getPropValue(dataFilePath,
//		  "commCode").equalsIgnoreCase("CATDOG") && verifyElementPresent(By.
//		  xpath("//span[contains(text(),'Capture check sheet')]/preceding-sibling::div/i[contains(@class,'warning')]"
//		  ))){ fillCheckSheet(PropertyHandler.getPropValue(dataFilePath,
//		  "commCode")); handleAlert("Accept", "LTE001");
//		  waitForFrameAndSwitch(screenFrame); maxWait(); }
//		 
		click(By.xpath("//div[@id='charge']/span"));
		minWait();
		click(By.xpath("//a[@flipper='edit_chargeDetails']"));
		minWait();
		scrollToView(btn_Calculte);
		click(btn_Calculte);
		String totalPrice = driver.findElement(By.xpath("//span[@class='mar-t-xs']")).getText();
		PropertyHandler.setPropValue(dataFilePath, "totalCharge", totalPrice);
		minWait();
		driver.switchTo().defaultContent();
		handleAlert("Accept", "LTE001");
		minWait();
		driver.switchTo().frame(screenFrame);
		maxWait();
		if (verifyElementPresent(By.name("modeOfPay"))) {
			selectByText(By.name("modeOfPay"), ModeofPayment);
		}
//		
//		  try { selectByText(By.name("modeOfPay"), ModeofPayment); } catch
//		  (Exception e) {
//		  
//		  }
//		 
		click(btn_AwbVerified);
		InitialSetup.test.log(LogStatus.INFO, "Successfully clicked on AWB verification button");
		click(btn_Save);
		maxWait();
		
		try {
			handleAlert("Accept", "LTE001");
			waitForFrameAndSwitch(screenFrame);
		} catch (Exception e) {
			waitForFrameAndSwitch(screenFrame);
		}
		handleEmbargoPopUp();
//		try {
//			if (driver.findElement(By.xpath("//div[@id='EmbargoDiv']//button[@name='okBtn']")).isDisplayed()) {
//				captureAndAddScreenshot();
//				click(By.xpath("//div[@id='EmbargoDiv']//button[@name='okBtn']"));
//			}
//		} catch (Exception e) {
//		}
		maxWait();
		maxWait();
		if (verifyElementPresent(info_msg)) {
			InitialSetup.test.log(LogStatus.INFO,
					"Pop-up message after Save Button Click: " + driver.findElement(info_msg).getText());
			click(btn_genericYes);
		}
		String CaptureStatus = driver.findElement(By.xpath("(//*[@id='overviewBar']/div/div)[3]/div")).getText();
		PropertyHandler.setPropValue(dataFilePath, "CaptureStatus", CaptureStatus);
		if (CaptureStatus.equalsIgnoreCase("Executed")) {
			InitialSetup.test.log(LogStatus.PASS, "Successfully Executed AWB. Data Capture Status: " + CaptureStatus);
			captureAndAddScreenshot();
		} else {
			InitialSetup.test.log(LogStatus.FAIL, "Could not execute AWB. Data Capture Status: " + CaptureStatus);
			Assert.fail("Cannot Execute AWB");
		}
		return this;
	}

	public LTE001 doCaptureAndAcceptance(String prefix, String awbno, String ModeofPayment, String shipper,
			String consignee, String pcs, String wt, String vol, String UldNumber, boolean UldNeeded,
			String ScreenMethod, String ScreenResult) {
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		ModeofPayment = PropertyHandler.getPropValue(dataFilePath, ModeofPayment);
		shipper = PropertyHandler.getPropValue(dataFilePath, shipper);
		consignee = PropertyHandler.getPropValue(dataFilePath, consignee);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		vol = PropertyHandler.getPropValue(dataFilePath, vol);
		ScreenMethod = PropertyHandler.getPropValue(dataFilePath, ScreenMethod);
		ScreenResult = PropertyHandler.getPropValue(dataFilePath, ScreenResult);
		listAWB(prefix, awbno);
		maxWait();
		String scineeded = PropertyHandler.getPropValue(dataFilePath, "SCIneeded");
		if (scineeded != null && scineeded.equalsIgnoreCase("Yes")) {
			click(By.xpath("//div[@id='shipmentaccordion']/span"));
			click(By.xpath("//a[@flipper='edit_shipmetdtls']"));
			minWait();
			selectByText(By.xpath("//select[@name='sci']"), "T1");
		}
		maxWait();
		click(By.xpath("//div[@id='participant']/span"));
		minWait();
		click(By.xpath("//a[@flipper='edit_particpant']"));
		enterKeys(txt_shipperCode, shipper + Keys.TAB);
		enterKeys(txt_ConsigneeCode, consignee + Keys.TAB);
		minWait();
		click(By.xpath("//div[@id='charge']/span"));
		minWait();
		click(By.xpath("//a[@flipper='edit_chargeDetails']"));
		minWait();
		click(btn_Calculte);
		String totalPrice = driver.findElement(By.xpath("//span[@class='mar-t-xs']")).getText();
		PropertyHandler.setPropValue(dataFilePath, "totalCharge", totalPrice);
		minWait();
		driver.switchTo().defaultContent();
		handleAlert("Accept", "LTE001");
		minWait();
		driver.switchTo().frame(screenFrame);
		minWait();
		try {
			selectByText(select_ModeofPayment, ModeofPayment);
		} catch (Exception e) {
		}
		click(btn_AwbVerified);
		InitialSetup.test.log(LogStatus.INFO, "Successfully clicked on AWB verification button");
		click(btn_Save);
		maxWait();
		try {
			handleAlert("Accept", "LTE001");
			waitForFrameAndSwitch(screenFrame);
		} catch (Exception e) {
			waitForFrameAndSwitch(screenFrame);
		}
		// code of credit card
		try {
			if (driver.findElement(By.xpath("//div[@id='EmbargoDiv']//button[@name='okBtn']")).isDisplayed()) {
				captureAndAddScreenshot();
				click(By.xpath("//div[@id='EmbargoDiv']//button[@name='okBtn']"));
			}
		} catch (Exception e) {
		}
		maxWait();
		maxWait();
		if (verifyElementPresent(info_msg)) {
			InitialSetup.test.log(LogStatus.INFO,
					"Pop-up message after Save Button Click: " + driver.findElement(info_msg).getText());
			click(btn_genericYes);
		}
		String CaptureStatus = driver.findElement(By.xpath("(//*[@id='overviewBar']/div/div)[3]/div")).getText();
		PropertyHandler.setPropValue(dataFilePath, "CaptureStatus", CaptureStatus);
		if (CaptureStatus.equalsIgnoreCase("Executed")) {
			InitialSetup.test.log(LogStatus.PASS, "Successfully Executed AWB. Data Capture Status: " + CaptureStatus);
			captureAndAddScreenshot();
		} else {
			InitialSetup.test.log(LogStatus.FAIL, "Could not execute AWB. Data Capture Status: " + CaptureStatus);
			Assert.fail("Cannot Execute AWB");
		}
		maxWait();
		// Accepatance operations
		// click(link_AcceptanceDetails);
		click(By.xpath("//div[contains(text(),'Acceptance Details')]/parent::div/span"));
		// click(By.xpath("(//div[contains(text(),'Acceptance
		// Details')])[last()]"));
		// click(By.xpath("(//*[@class='ui-accordion-header-icon ui-icon
		// ui-icon-triangle-1-e'])[8]"));
		enterKeys(txt_pieces, pcs);
		enterKeys(txt_weight, wt);
		minWait();
		enterKeys(txt_volume, vol);
		minWait();
		if (UldNeeded == true)// if uld details needs to be given, then true
								// else false
		{
			UldNumber = PropertyHandler.getPropValue(dataFilePath, UldNumber);
			// enterKeys(Txt_ULD,UldNumber);
			enterKeys(By.id("uldNumer_u"), UldNumber);
			enterKeys(By.xpath("//*[contains(text(),'Location')]/following-sibling::input"), "ACP-A-1-A");
		}
		click(txt_AcceptAll);
		click(By.xpath("//*[@name='btnAcceptanceDtlsCont']"));
		minWait();

		// Screening
		// click(Link_Screendetails);
		selectByText(select_ScreenMethod, ScreenMethod);
		enterKeys(txt_screenPcs, pcs);
		selectByText(select_screenPassFail, ScreenResult);
		minWait();
		click(btn_Save);
		maxWait();
		try {
			if (driver.findElement(By.xpath("//div[@id='EmbargoDiv']//button[@name='okBtn']")).isDisplayed()) {
				captureAndAddScreenshot();
				click(By.xpath("//div[@id='EmbargoDiv']//button[@name='okBtn']"));
			}
		} catch (Exception e) {

		}
		maxWait();
		driver.switchTo().defaultContent();
		handleAlert("Accept", "LTE001");
		maxWait();
		driver.switchTo().frame(screenFrame);

		if (verifyElementPresent(info_msg)) {
			InitialSetup.test.log(LogStatus.INFO,
					"Pop-up message after Save Button Click: " + driver.findElement(info_msg).getText());
			click(btn_genericYes);
		}
		if (verifyElementPresent(info_msg)) {
			InitialSetup.test.log(LogStatus.INFO,
					"Pop-up message after Save Button Click: " + driver.findElement(info_msg).getText());
			click(btn_genericYes);
		}

		String AcceptanceStatus = driver.findElement(By.xpath("(//*[@id='overviewBar']/div/div)[4]/div")).getText();
		PropertyHandler.setPropValue(dataFilePath, "AcceptanceStatus", AcceptanceStatus);

		if (AcceptanceStatus.equalsIgnoreCase("Finalised")) {
			InitialSetup.test.log(LogStatus.PASS,
					"Successfully Accepted Goods. Acceptance Status: " + AcceptanceStatus);
			captureAndAddScreenshot();
		} else {
			InitialSetup.test.log(LogStatus.FAIL, "Could not Accept Goods. Acceptance Status: " + AcceptanceStatus);
			Assert.fail("Could not Accept Goods");
		}
		return this;
	}

	/**
	 * 
	 * @author sharath
	 */
	public void fillCheckSheet(String commodityCode) {
		click(By.xpath("//span[contains(text(),'Capture check sheet')]"));
		waitForFrameAndSwitch("popupContainerFrame");

		switch (commodityCode.toUpperCase()) {

		case "CATDOG":
			if (verifyElementEnabled(By.xpath(
					"//input[contains(@value,'Shipper Security Endorsement')]/../../following-sibling::div[1]//select"))) {
				selectByText(
						By.xpath(
								"//input[contains(@value,'Shipper Security Endorsement')]/../../following-sibling::div[1]//select"),
						"Yes");
			}
			selectByText(
					By.xpath(
							"//input[contains(@value,'statement of acclimation')]/../../following-sibling::div[1]//select"),
					"Yes");
			enterKeys(
					By.xpath(
							"//input[contains(@value,'acclimation temperature')]/../../following-sibling::div[1]/textarea"),
					"-30");
			selectByText(
					By.xpath("//input[contains(@value,'after-hours pick-up')]/../../following-sibling::div[1]//select"),
					"Yes");
			enterKeys(
					By.xpath(
							"//input[contains(@value,'station team member arrangements')]/../../following-sibling::div[1]/textarea"),
					"abc");
			selectByText(
					By.xpath(
							"//input[contains(@value,'at least 8 weeks old')]/../../following-sibling::div[1]//select"),
					"Yes");
			selectByText(
					By.xpath("//input[contains(@value,'restricted breeds')]/../../following-sibling::div[1]//select"),
					"No");
			selectByText(
					By.xpath(
							"//input[contains(@value,'Health Certificate provided')]/../../following-sibling::div[1]//select"),
					"Yes");
			selectByText(
					By.xpath(
							"//input[contains(@value,'original plus one copy')]/../../following-sibling::div[1]//select"),
					"Yes");
			selectByText(By.xpath("//input[contains(@value,'within 10 days')]/../../following-sibling::div[1]//select"),
					"Yes");
			selectByText(
					By.xpath(
							"//input[contains(@value,'completed and signed by veterinarian')]/../../following-sibling::div[1]//select"),
					"Yes");
			selectByText(
					By.xpath(
							"//input[contains(@value,'Restriction/Verification')]/../../following-sibling::div[1]//select"),
					"Yes");
			selectByText(
					By.xpath(
							"//input[contains(@value,'Customer Acknowledgement Form')]/../../following-sibling::div[1]//select"),
					"Yes");
			selectByText(By.xpath("//input[contains(@value,'dog pregnant')]/../../following-sibling::div[1]//select"),
					"No");
			selectByText(By.xpath("//input[contains(@value,'been sedated')]/../../following-sibling::div[1]//select"),
					"No");
			// ACP
			click(By.xpath("//a[text()='ACP']"));
			selectByText(
					By.xpath("//input[contains(@value,'local cut-off time')]/../../following-sibling::div[1]//select"),
					"Yes");
			selectByText(By.xpath("//input[contains(@value,'Fit for travel')]/../../following-sibling::div[1]//select"),
					"Yes");
			selectByText(
					By.xpath("//input[contains(@value,'provided FEEDING')]/../../following-sibling::div[1]//select"),
					"Yes");
			selectByText(
					By.xpath(
							"//input[contains(@value,'separate food and watering')]/../../following-sibling::div[1]//select"),
					"Yes");
			selectByText(By.xpath("//input[contains(@value,'24 hr. period')]/../../following-sibling::div[1]//select"),
					"NA");
			selectByText(
					By.xpath(
							"//input[contains(@value,'contact names, addresses')]/../../following-sibling::div[1]//select"),
					"Yes");
			selectByText(
					By.xpath(
							"//input[contains(@value,'proper neon-yellow point')]/../../following-sibling::div[1]//select"),
					"Yes");
			selectByText(
					By.xpath(
							"//input[contains(@value,'LIVE ANIMAL labels attached')]/../../following-sibling::div[1]//select"),
					"Yes");
			selectByText(
					By.xpath(
							"//input[contains(@value,'rigid and secure enough')]/../../following-sibling::div[1]//select"),
					"Yes");
			selectByText(
					By.xpath(
							"//input[contains(@value,'leak-proof with a solid')]/../../following-sibling::div[1]//select"),
					"Yes");
			selectByText(
					By.xpath(
							"//input[contains(@value,'ventilation openings')]/../../following-sibling::div[1]//select"),
					"Yes");
			selectByText(
					By.xpath("//input[contains(@value,'large enough that')]/../../following-sibling::div[1]//select"),
					"Yes");
			selectByText(
					By.xpath(
							"//input[contains(@value,'releasable cable ties on all 4')]/../../following-sibling::div[1]//select"),
					"Yes");
			selectByText(
					By.xpath(
							"//input[contains(@value,'correct container requirement')]/../../following-sibling::div[1]//select"),
					"Yes");
			click(By.xpath("//button[@name='btnSave']"));
			InitialSetup.test.log(LogStatus.INFO,
					"Successfully entered values in Check Sheet for commodity: " + commodityCode);
			break;

		default:
			Assert.assertTrue(false, "Wrong commodity Code given");

		}

	}

	/**
	 * @author A-8457 Souvik Description: For performing Booking only for two
	 *         leg
	 * @param carriercode
	 * @param awbno
	 * @param fltNo
	 * @param fltDt
	 * @param Product
	 * @param agentCode
	 * @param shipper
	 * @param consignee
	 * @param origin
	 * @param dest
	 * @param pcs
	 * @param wt
	 * @param vol
	 * @param Commodity
	 * @param prefix
	 * @return
	 */
	public LTE001 doPPSBookingOnlyfor2Legs(String carriercode, String awbno, String fltNo, String fltDt, String Product,
			String agentCode, String shipper, String consignee, String origin, String dest, String pcs, String wt,
			String vol, String Commodity, String prefix, String CustomerType, String intermediate, String carriercode1,
			String fltNo1, String fltDt1) {

		minWait();
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		Product = PropertyHandler.getPropValue(dataFilePath, Product);
		agentCode = PropertyHandler.getPropValue(dataFilePath, agentCode);
		shipper = PropertyHandler.getPropValue(dataFilePath, shipper);
		consignee = PropertyHandler.getPropValue(dataFilePath, consignee);
		origin = PropertyHandler.getPropValue(dataFilePath, origin);
		dest = PropertyHandler.getPropValue(dataFilePath, dest);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		vol = PropertyHandler.getPropValue(dataFilePath, vol);
		Commodity = PropertyHandler.getPropValue(dataFilePath, Commodity);
		carriercode = PropertyHandler.getPropValue(dataFilePath, carriercode);
		CustomerType = PropertyHandler.getPropValue(dataFilePath, CustomerType);
		carriercode1 = PropertyHandler.getPropValue(dataFilePath, carriercode1);
		fltNo1 = PropertyHandler.getPropValue(dataFilePath, fltNo1);
		fltDt1 = PropertyHandler.getPropValue(dataFilePath, fltDt1);
		intermediate = PropertyHandler.getPropValue(dataFilePath, intermediate);

		String origindestination = origin + "-" + intermediate;
		String carrierwithFlightno = carriercode + fltNo;
		PropertyHandler.setPropValue(dataFilePath, "carrierwithFlightno", carrierwithFlightno);

		String origindestination1 = intermediate + "-" + dest;
		String carrierwithFlightno1 = carriercode1 + fltNo1;
		PropertyHandler.setPropValue(dataFilePath, "carrierwithFlightno1", carrierwithFlightno1);

		listAWB(prefix, awbno);

		maxWait();
		minWait();
		if (!verifyElementVisible(txt_ProductType)) {
			click(By.xpath("(//span[@class='ui-accordion-header-icon ui-icon ui-icon-triangle-1-e'])[1]"));
			minWait();
		}
		enterKeys(txt_ProductType, Product + Keys.TAB);
		maxWait();
		selectByText(select_CustomerType, CustomerType);
		if (CustomerType.equalsIgnoreCase("Employee")) {
			enterKeys(By.xpath("//*[@name='employeeId']"), "00937305");
			click(By.xpath("//input[@name='btnVerifyEmployeeId']"));

			minWait();
			driver.switchTo().defaultContent();
			handleAlert("Accept", "LTE001");
			InitialSetup.test.log(LogStatus.INFO, "Employee Verified Successfully");
			minWait();
			driver.switchTo().frame(screenFrame);
			minWait();
		}
		click(By.xpath("//button[@name='btnCustomerTypeCont']"));
		minWait();

		// click(link_ParticipantDetail);
		enterKeys(txt_agent, agentCode + Keys.TAB);
		enterKeys(txt_shipperCode, shipper + Keys.TAB);
		enterKeys(txt_ConsigneeCode, consignee + Keys.TAB);
		click(By.xpath("//button[@name='btnParticipantCont']"));
		minWait();
		// ------------------------Certificate
		// Details---------------------------
		if (verifyElementPresent(By.xpath("//*[@name='driverIDType']"))) {
			minWait();
			selectByText(By.xpath("//*[@name='driverIDType']"), "Driving License");
			enterKeys(By.xpath("//*[@name='stateOrCountryIssuingID']"), "US");
			enterKeys(By.xpath("//*[@name='driverName']"), "Test");
			enterKeys(By.xpath("//*[@name='driverCompany']"), "IBSAT");
			// click(By.xpath("//*[@name='photoIDVerified']"));
			selectByText(By.xpath("//select[@name='photoIDVerified']"), "Yes");
			click(By.xpath("//button[@name='btnCertificateDetailsCont']"));
		}

		scrollToView(link_BookingDetails);

		// click(link_shipmentDetails);
		enterKeys(By.xpath("//*[@name='ppsOrigin']"), origin);
		enterKeys(By.xpath("//*[@name='ppsDestination']"), dest);
		selectByText(By.xpath("//select[@name='ppsWeightUnit']"), "kg");
		selectByText(By.xpath("//select[@name='ppsVolumeUnit']"), "cbm");
		selectByText(By.xpath("//select[@name='ppsWeightUnit']"), "lbs");
		selectByText(By.xpath("//select[@name='ppsVolumeUnit']"), "cbf");
		enterKeys(By.xpath("//*[@name='ppsShpPcs']"), pcs);
		enterKeys(By.xpath("//*[@name='ppsShpWgt']"), wt);
		/*
		 * selectByText(By.xpath("//select[@name='ppsWeightUnit']"), "lbs");
		 * selectByText(By.xpath("//select[@name='ppsVolumeUnit']"), "cbf");
		 */
		enterKeys(By.xpath("//*[@name='ppsShpVol']"), vol);
		enterKeys(By.xpath("//*[@name='ppsShippingDate']"), fltDt + Keys.TAB);
		/*
		 * selectByText(By.xpath("//*[@name='ppsRatingWeightUnit']"), "lbs");
		 * selectByText(By.xpath("//*[@name='ppsRatingVolumeUnit']"), "cbf");
		 */
		// enterKeys(By.xpath(""), Product);

		selectByText(By.xpath("//*[@name='ppsCommodityCode']"), Commodity);

		minWait();

		enterKeys(By.xpath("//*[@name='ppsDimensionLength']"), "10" + Keys.TAB);
		enterKeys(By.xpath("//*[@name='ppsDimensionWidth']"), "10" + Keys.TAB);
		enterKeys(By.xpath("//*[@name='ppsDimensionHeight']"), "10" + Keys.TAB);

		String CalcVol = driver.findElement(By.xpath("//*[@name='ppsShpVol']")).getAttribute("value");
		PropertyHandler.setPropValue(dataFilePath, "volume", CalcVol);
		click(By.xpath("//button[@name='btnPPSShipmentCont']"));
		minWait();

		// click(link_BookingDetails);
		minWait();
		enterKeys(txt_CarrierCode, carriercode);
		enterKeys(txt_flightnumber, fltNo);
		enterKeys(txt_flightdate, fltDt + Keys.TAB);
		enterKeys(txt_FlightSegment, origindestination);
		enterKeys(txt_FltPcs, pcs);
		minWait();
		enterKeys(txt_FltWt, wt);
		minWait();
		String todaysDt = driver.findElement(txt_flightdate).getAttribute("value");
		PropertyHandler.setPropValue(dataFilePath, "flightDt", todaysDt);
		enterKeys(txt_FltVolume, CalcVol);
		minWait();
		click(By.xpath("(//*[@class='icon ico-plus-round mar-r-xs'])[3]"));
		InitialSetup.test.log(LogStatus.INFO, "Successfully entered flight details for O-D: " + origindestination
				+ " and FLight No.- " + carrierwithFlightno1);

		// 2nd flight details
		enterKeys(By.xpath("(//*[@name='flightCarrierCode'])[2]"), carriercode1);
		enterKeys(By.xpath("(//*[@name='flightNumber'])[2]"), fltNo1);
		// fltDt1=PropertyHandler.getPropValue(dataFilePath, fltDt1);
		enterKeys(By.xpath("(//*[@name='flightDate'])[2]"), fltDt1);// full date
																	// required
		enterKeys(By.xpath("(//*[@name='flightSegment'])[2]"), origindestination1);
		enterKeys(By.xpath("(//*[@name='bookedPieces'])[2]"), pcs);
		enterKeys(By.xpath("(//*[@name='bookedWeight'])[2]"), wt);
		enterKeys(By.xpath("(//*[@name='bookedVolume'])[2]"), CalcVol);
		InitialSetup.test.log(LogStatus.INFO, "Successfully entered flight details for O-D: " + origindestination1
				+ " and FLight No.- " + carrierwithFlightno1);

		click(By.xpath("//button[@name='btnFlightDtlsCont']"));
		minWait();

		// click(link_ChargeDetails);
		minWait();
		click(btn_Calculte);
		minWait();
		driver.switchTo().defaultContent();
		handleAlert("Accept", "LTE001");
		minWait();
		driver.switchTo().frame(screenFrame);
		minWait();
		try {
			selectByText(select_ModeofPayment, "CREDIT");
		} catch (Exception e) {
		}

		click(By.xpath("//button[@name='btnChargeDtlsCont']"));
		minWait();
		click(btn_Save);
		maxWait();

		// pop-up: The shipper does not have a valid certificate. Do you want to
		// continue?
		driver.switchTo().defaultContent();
		if (verifyElementPresent(info_msg)) {
			InitialSetup.test.log(LogStatus.INFO,
					"Pop-up message after saving: " + driver.findElement(info_msg).getText());
			click(btn_genericYes);
			minWait();
		}
		waitForFrameAndSwitch(screenFrame);

		// embargo
		/*
		 * if(verifyElementPresent(By.xpath("(//button[@id='okBtn'])[2]"))) {
		 * click(By.xpath("(//button[@id='okBtn'])[2]")); }
		 * 
		 * 
		 * //same pop-up driver.switchTo().defaultContent(); minWait();
		 * //waitForFrameAndSwitch(screenFrame); handleAlert("Accept",
		 * "LTE001"); minWait(); driver.switchTo().frame(screenFrame);
		 */
		minWait();
		maxWait();
		driver.switchTo().defaultContent();
		maxWait();
		if (verifyElementPresent(btn_genericYes)) {
			click(btn_genericYes);
			minWait();
		}
		waitForFrameAndSwitch(screenFrame);
		maxWait();

		// Capture booking status

		String BookingStatus = driver.findElement(By.xpath("(//*[@id='overviewBar']/div/div)[2]/div")).getText();
		PropertyHandler.setPropValue(dataFilePath, "LTEBookingStatus", BookingStatus);

		if (BookingStatus.equalsIgnoreCase("Confirmed") || BookingStatus.equalsIgnoreCase("Queued")) {
			InitialSetup.test.log(LogStatus.PASS, "Booking done with Status: " + BookingStatus);
			captureAndAddScreenshot();
		} else {
			InitialSetup.test.log(LogStatus.FAIL,
					"Booking status is not confirmed or Queued. Status" + "displayed is: " + BookingStatus);
			Assert.fail("Booking status is not confirmed or Queued. Status" + "displayed is: ");
		}
		return this;
	}

	public LTE001 doSLACCaptureWithShipperConsignee(String prefix, String awbno, String ModeofPayment, String shipper,
			String consignee, String slacPcs) {
		minWait();
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		ModeofPayment = PropertyHandler.getPropValue(dataFilePath, ModeofPayment);
		shipper = PropertyHandler.getPropValue(dataFilePath, shipper);
		consignee = PropertyHandler.getPropValue(dataFilePath, consignee);
		slacPcs = PropertyHandler.getPropValue(dataFilePath, slacPcs);

		listAWB(prefix, awbno);

		maxWait();
		// Checksheet
		if (verifyElementPresent(By.xpath(
				"//span[contains(text(),'Capture check sheet')]/preceding-sibling::div/i[contains(@class,'warning')]"))) {
			fillCheckSheet(PropertyHandler.getPropValue(dataFilePath, "commCode"));
			handleAlert("Accept", "LTE001");
			waitForFrameAndSwitch(screenFrame);
			maxWait();
		}

		click(By.xpath("//div[@id='participant']/span"));
		minWait();
		click(By.xpath("//a[@flipper='edit_particpant']"));
		enterKeys(txt_shipperCode, shipper + Keys.TAB);
		enterKeys(txt_ConsigneeCode, consignee + Keys.TAB);
		minWait();
		click(By.xpath("//button[@name='btnParticipantCont']"));
		minWait();
		// click(By.xpath("//div[@id='shipmentaccordion']/span"));
		click(By.xpath("//a[@flipper='edit_shipmetdtls']"));
		minWait();
		selectByText(By.xpath("//select[@name='sci']"), "T1");
		enterKeys(By.xpath("//input[@name='slacPieces']"), slacPcs);
		maxWait();
		click(By.xpath("//button[@name='btnShipmentCont']"));
		if (driver.findElements(By.xpath("//input[@name='driverName']")).size() > 0) {
			enterKeys(By.xpath("//input[@name='driverName']"), "Test Driver");
			enterKeys(By.xpath("//input[@name='driverCompany']"), "Test Company");
			selectByText(By.xpath("//select[@name='driverIDType']"), "Driving License");
			enterKeys(By.xpath("//input[@name='stateOrCountryIssuingID']"), "US");
			selectByText(By.xpath("//select[@name='photoIDVerified']"), "Yes");
			minWait();
			click(By.name("btnCertificateDetailsCont"));
			minWait();
		}
		click(By.xpath("//div[@id='charge']/span"));
		minWait();
		click(By.xpath("//a[@flipper='edit_chargeDetails']"));
		minWait();
		scrollToView(btn_Calculte);
		click(btn_Calculte);
		String totalPrice = driver.findElement(By.xpath("//span[@class='mar-t-xs']")).getText();
		PropertyHandler.setPropValue(dataFilePath, "totalCharge", totalPrice);
		minWait();
		driver.switchTo().defaultContent();
		handleAlert("Accept", "LTE001");
		minWait();
		driver.switchTo().frame(screenFrame);
		maxWait();
		if (verifyElementPresent(By.name("modeOfPay"))) {
			selectByText(By.name("modeOfPay"), ModeofPayment);
		}
		/*
		 * try { selectByText(By.name("modeOfPay"), ModeofPayment); } catch
		 * (Exception e) {
		 * 
		 * }
		 */
		click(btn_AwbVerified);
		InitialSetup.test.log(LogStatus.INFO, "Successfully clicked on AWB verification button");
		click(btn_Save);
		maxWait();
		try {
			handleAlert("Accept", "LTE001");
			waitForFrameAndSwitch(screenFrame);
		} catch (Exception e) {
			waitForFrameAndSwitch(screenFrame);
		}

		// code of credit card
		try {
			if (driver.findElement(By.xpath("//div[@id='EmbargoDiv']//button[@name='okBtn']")).isDisplayed()) {
				captureAndAddScreenshot();
				click(By.xpath("//div[@id='EmbargoDiv']//button[@name='okBtn']"));
			}
		} catch (Exception e) {
		}
		maxWait();
		maxWait();
		if (verifyElementPresent(info_msg)) {
			InitialSetup.test.log(LogStatus.INFO,
					"Pop-up message after Save Button Click: " + driver.findElement(info_msg).getText());
			click(btn_genericYes);
		}
		String CaptureStatus = driver.findElement(By.xpath("(//*[@id='overviewBar']/div/div)[3]/div")).getText();
		PropertyHandler.setPropValue(dataFilePath, "CaptureStatus", CaptureStatus);
		if (CaptureStatus.equalsIgnoreCase("Executed")) {
			InitialSetup.test.log(LogStatus.PASS, "Successfully Executed AWB. Data Capture Status: " + CaptureStatus);
			captureAndAddScreenshot();
		} else {
			InitialSetup.test.log(LogStatus.FAIL, "Could not execute AWB. Data Capture Status: " + CaptureStatus);
			Assert.fail("Cannot Execute AWB");
		}
		return this;
	}

	/**
	 * @author A-8680 Sharath Description: To perform acceptance operation in
	 *         LTE001
	 * @param pcs
	 * @param wt
	 * @param vol
	 * @param ModeofPayment
	 * @param UldNumber
	 * @param UldNeeded
	 * @return
	 */
	public LTE001 doSLACAcceptance(String pcs, String slacPcs, String wt, String vol, int noOfULDs, boolean UldNeeded,
			String ScreenMethod, String ScreenResult, String... UldNumber) {
		minWait();
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		vol = PropertyHandler.getPropValue(dataFilePath, vol);
		slacPcs = PropertyHandler.getPropValue(dataFilePath, slacPcs);
		ScreenMethod = PropertyHandler.getPropValue(dataFilePath, ScreenMethod);
		ScreenResult = PropertyHandler.getPropValue(dataFilePath, ScreenResult);
		// UldNumber= PropertyHandler.getPropValue(dataFileName, UldNumber);
		maxWait();
		// Accepatance operations
		// click(link_AcceptanceDetails);
		click(By.xpath("//div[contains(text(),'Acceptance Details')]/parent::div/span"));
		// click(By.xpath("(//div[contains(text(),'Acceptance
		// Details')])[last()]"));

		// click(By.xpath("(//*[@class='ui-accordion-header-icon ui-icon
		// ui-icon-triangle-1-e'])[8]"));

		minWait();
		// enterKeys(txt_volume, vol);
		minWait();
		int pc = Integer.parseInt(pcs);
		int w = Integer.parseInt(wt);
		w = w / pc;
		pc = pc / pc;
		if (UldNeeded == true)// if uld details needs to be given, then true
								// else false
		{
			if (noOfULDs > 1) {
				for (int i = 0; i < noOfULDs; i++) {
					enterKeys(getWebElements(txt_pieces).get(i), "0" + Integer.toString(pc));
					enterKeys(getWebElements(txt_weight).get(i), Integer.toString(w));
					String uldN = PropertyHandler.getPropValue(dataFilePath, UldNumber[i]);
					enterKeys(getWebElements(By.id("uldNumer_u")).get(i), uldN);
					click(getWebElements(By.xpath("//div[@id='acceptanceDetails']//i[@title='Add']")).get(i));
				}
			} else {
				enterKeys(txt_pieces, pcs);
				enterKeys(txt_weight, wt);
				String uldN = PropertyHandler.getPropValue(dataFilePath, UldNumber[0]);
				// UldNumber = PropertyHandler.getPropValue(dataFilePath,
				// UldNumber);
				// enterKeys(Txt_ULD,UldNumber);
				enterKeys(By.id("uldNumer_u"), uldN);
			}
			enterKeys(By.xpath("//*[contains(text(),'Location')]/following-sibling::input"), "ACP-A-1-A");
		}
		// selectByText(By.name("acpWghtUnit"), "lbs");
		// selectByText(By.name("acpVolumeUnit"), "cbf");

		// click(txt_AcceptAll);
		click(By.xpath("//*[@name='btnAcceptanceDtlsCont']"));
		minWait();

		// Screening
		// click(Link_Screendetails);
		selectByText(select_ScreenMethod, ScreenMethod);
		enterKeys(txt_screenPcs, slacPcs);
		selectByText(select_screenPassFail, ScreenResult);
		minWait();
		click(btn_Save);
		maxWait();
		try {
			if (driver.findElement(By.xpath("//div[@id='EmbargoDiv']//button[@name='okBtn']")).isDisplayed()) {
				captureAndAddScreenshot();
				click(By.xpath("//div[@id='EmbargoDiv']//button[@name='okBtn']"));
			}
		} catch (Exception e) {

		}
		maxWait();
		driver.switchTo().defaultContent();
		handleAlert("Accept", "LTE001");
		maxWait();
		driver.switchTo().frame(screenFrame);

		if (verifyElementPresent(info_msg)) {
			InitialSetup.test.log(LogStatus.INFO,
					"Pop-up message after Save Button Click: " + driver.findElement(info_msg).getText());
			click(btn_genericYes);
		}

		if (verifyElementPresent(info_msg)) {
			InitialSetup.test.log(LogStatus.INFO,
					"Pop-up message after Save Button Click: " + driver.findElement(info_msg).getText());
			click(btn_genericYes);
		}

		String AcceptanceStatus = driver.findElement(By.xpath("(//*[@id='overviewBar']/div/div)[4]/div")).getText();
		PropertyHandler.setPropValue(dataFilePath, "AcceptanceStatus", AcceptanceStatus);

		if (AcceptanceStatus.equalsIgnoreCase("Finalised")) {
			InitialSetup.test.log(LogStatus.PASS,
					"Successfully Accepted Goods. Acceptance Status: " + AcceptanceStatus);
			captureAndAddScreenshot();
		} else {
			InitialSetup.test.log(LogStatus.FAIL, "Could not Accept Goods. Acceptance Status: " + AcceptanceStatus);
			Assert.fail("Could not Accept Goods");
		}

		return this;
	}

	/**
	 * @author A-8457 Souvik
	 * @param listingNeeded
	 * @param shipper
	 * @param consignee
	 * @param agent
	 * @param prefix
	 * @param awbno
	 * @return
	 */
	public LTE001 EnterSlacPieces(Boolean listingNeeded, String slacPcs, String prefix, String awbno) {
		if (listingNeeded == true)
			getValuesAndlistAWB(prefix, awbno);
		minWait();
		slacPcs = PropertyHandler.getPropValue(dataFilePath, slacPcs);

		if (!(verifyElementVisible(
				By.xpath("//a[@flipper='edit_shipmetdtls']//i[@class='icon ico-pencil-rounded-orange']")))) {
			maxWait();
			click(By.xpath("//*[@id='shipmentaccordion']//div[@id='view_header_shipmentDtls']"));
		} else {
			minWait();
			click(By.xpath("//a[@flipper='edit_shipmetdtls']//i[@class='icon ico-pencil-rounded-orange']")); // edit
																												// icon
		}
		minWait();
		click(By.xpath("//a[@flipper='edit_shipmetdtls']//i[@class='icon ico-pencil-rounded-orange']"));
		minWait();
		selectByText(By.xpath("//select[@name='sci']"), "T1");
		minWait();
		enterKeys(By.id("CMP_Operations_Shipment_Lite_CreateShipment_SlacPieces"), slacPcs);
		click(By.xpath("//button[@name='btnShipmentCont']"));
		minWait();
		minWait();
		click(btn_Save);
		maxWait();

		return this;
	}

	/**
	 * @author A-8457 Souvik Description: To perform acceptance operation in
	 *         LTE001 with SLAC Pieces
	 * @param pcs
	 * @param wt
	 * @param vol
	 * @param ModeofPayment
	 * @param UldNumber
	 * @param UldNeeded
	 * @return
	 */
	public LTE001 doAcceptanceWithSlac(String pcs, String wt, String vol, String UldNumber, boolean UldNeeded,
			String ScreenMethod, String ScreenResult, String slacpcs) {
		minWait();
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		vol = PropertyHandler.getPropValue(dataFilePath, vol);
		ScreenMethod = PropertyHandler.getPropValue(dataFilePath, ScreenMethod);
		ScreenResult = PropertyHandler.getPropValue(dataFilePath, ScreenResult);
		slacpcs = PropertyHandler.getPropValue(dataFilePath, slacpcs);

		maxWait();
		// Accepatance operations
		// click(link_AcceptanceDetails);
		click(By.xpath("//div[contains(text(),'Acceptance Details')]/parent::div/span"));
		// click(By.xpath("(//div[contains(text(),'Acceptance
		// Details')])[last()]"));

		// click(By.xpath("(//*[@class='ui-accordion-header-icon ui-icon
		// ui-icon-triangle-1-e'])[8]"));
		enterKeys(txt_pieces, pcs);
		enterKeys(txt_weight, wt);
		minWait();
		enterKeys(txt_volume, vol);
		minWait();

		if (UldNeeded == true)// if uld details needs to be given, then true
								// else false
		{
			UldNumber = PropertyHandler.getPropValue(dataFilePath, UldNumber);
			enterKeys(Txt_ULD, UldNumber);
		}
		click(txt_AcceptAll);
		minWait();

		click(By.xpath("//*[@name='btnAcceptanceDtlsCont']"));
		minWait();

		// Screening
		// click(Link_Screendetails);
		selectByText(select_ScreenMethod, ScreenMethod);
		enterKeys(txt_screenPcs, slacpcs);
		selectByText(select_screenPassFail, ScreenResult);
		minWait();
		click(btn_Save);
		maxWait();
		driver.switchTo().defaultContent();
		handleAlert("Accept", "LTE001");
		maxWait();
		driver.switchTo().frame(screenFrame);

		if (verifyElementPresent(info_msg)) {
			InitialSetup.test.log(LogStatus.INFO,
					"Pop-up message after Save Button Click: " + driver.findElement(info_msg).getText());
			click(btn_genericYes);
		}

		if (verifyElementPresent(info_msg)) {
			InitialSetup.test.log(LogStatus.INFO,
					"Pop-up message after Save Button Click: " + driver.findElement(info_msg).getText());
			click(btn_genericYes);
		}

		String AcceptanceStatus = driver.findElement(By.xpath("(//*[@id='overviewBar']/div/div)[4]/div")).getText();
		PropertyHandler.setPropValue(dataFilePath, "AcceptanceStatus", AcceptanceStatus);

		if (AcceptanceStatus.equalsIgnoreCase("Finalised")) {
			InitialSetup.test.log(LogStatus.PASS,
					"Successfully Accepted Goods. Acceptance Status: " + AcceptanceStatus);
			captureAndAddScreenshot();
		} else {
			InitialSetup.test.log(LogStatus.FAIL, "Could not Accept Goods. Acceptance Status: " + AcceptanceStatus);
			Assert.fail("Could not Accept Goods");
		}

		return this;
	}

	/**
	 * @author A-8457 Souvik Capture the Different type of checksheet in Lite
	 *         capture screen
	 * 
	 * @return
	 */
	public LTE001 CaptureChecksheetLite(String prefix, String awbno, String Commodity) {
		minWait();
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		Commodity = PropertyHandler.getPropValue(dataFilePath, Commodity);

		listAWB(prefix, awbno);
		maxWait();

		click(By.xpath("//span[contains(text(),'Capture check sheet')]"));
		maxWait();
		waitForFrameAndSwitch("popupContainerFrame");
		switch (Commodity.toUpperCase()) {
		case "AVIWARM":
			minWait();
			selectByText(
					By.xpath(
							"//input[contains(@value,'manual paper Shipper Security Endorsement')]/../../following-sibling::div[1]//select"),
					"Yes");
			selectByText(
					By.xpath(
							"//input[contains(@value,'statement of acclimation')]/../../following-sibling::div[1]//select"),
					"Yes");
			selectByText(
					By.xpath(
							"//input[contains(@value,'Are the animal(s) common name ')]/../../following-sibling::div[1]//select"),
					"Yes");
			selectByText(
					By.xpath(
							"//input[contains(@value,'If the destination city is closed upon arrival')]/../../following-sibling::div[1]//select"),
					"Yes");
			selectByText(
					By.xpath("//input[contains(@value,'non-human primate')]/../../following-sibling::div[1]//select"),
					"Yes");
			selectByText(
					By.xpath("//input[contains(@value,'animal pregnant')]/../../following-sibling::div[1]//select"),
					"No");
			selectByText(
					By.xpath(
							"//input[contains(@value,'Acknowledgement Form')]/../../following-sibling::div[1]//select"),
					"Yes");
			selectByText(
					By.xpath(
							"//input[contains(@value,'warm-blooded animals being shipped')]/../../following-sibling::div[1]//select"),
					"Yes");
			selectByText(
					By.xpath(
							"//input[contains(@value,'shipment an International Shipment')]/../../following-sibling::div[1]//select"),
					"Yes");
			enterKeys(
					By.xpath(
							"//input[contains(@value,'what is the lowest acclimation temperature')]/../../following-sibling::div[1]/textarea"),
					"-30");
			enterKeys(
					By.xpath(
							"//input[contains(@value,'who is the station team member arrangements')]/../../following-sibling::div[1]/textarea"),
					"abcdefghijklmno");
			selectByText(
					By.xpath(
							"//input[contains(@value,'is there a valid Health Certification')]/../../following-sibling::div[1]//select"),
					"Yes");
			selectByText(
					By.xpath(
							"//input[contains(@value,'provided a certification on the Shippers or Agents')]/../../following-sibling::div[1]//select"),
					"Yes");
			selectByText(
					By.xpath(
							"//input[contains(@value,'there proof of rabies vaccination')]/../../following-sibling::div[1]//select"),
					"Yes");
			selectByText(
					By.xpath(
							"//input[contains(@value,'does the original Health Certificate clarify that the animal is fit to travel')]/../../following-sibling::div[1]//select"),
					"Yes");
			selectByText(
					By.xpath(
							"//input[contains(@value,'certificate states that the pet has given birth')]/../../following-sibling::div[1]//select"),
					"Yes");
			selectByText(
					By.xpath(
							"//input[contains(@value,'Acclimation letter completed and signed by veterinarian')]/../../following-sibling::div[1]//select"),
					"Yes");
			selectByText(
					By.xpath(
							"//input[contains(@value,'is a Health Certificate or Shippers Certificate provided')]/../../following-sibling::div[1]//select"),
					"Yes");

			minWait();

			click(By.xpath("//a[text()='ACP']"));
			minWait();

			selectByText(
					By.xpath(
							"//input[contains(@value,'accepted by the local cut-off time')]/../../following-sibling::div[1]//select"),
					"Yes");
			selectByText(By.xpath("//input[contains(@value,'Fit for travel')]/../../following-sibling::div[1]//select"),
					"Yes");
			selectByText(
					By.xpath(
							"//input[contains(@value,'Clean, with no offensive odors')]/../../following-sibling::div[1]//select"),
					"Yes");
			selectByText(
					By.xpath(
							"//input[contains(@value,'Has the Shipper provided FEEDING/WATERING CERTIFICATION')]/../../following-sibling::div[1]//select"),
					"Yes");
			selectByText(
					By.xpath(
							"//input[contains(@value,'Food and watering receptacles which are accessible from the outside')]/../../following-sibling::div[1]//select"),
					"Yes");
			selectByText(
					By.xpath(
							"//input[contains(@value,'Food for a 24-hour period that has been attached to the top of the kennel')]/../../following-sibling::div[1]//select"),
					"Yes");
			selectByText(
					By.xpath(
							"//input[contains(@value,'numbers for both origin and destination attached')]/../../following-sibling::div[1]//select"),
					"Yes");
			selectByText(
					By.xpath(
							"//input[contains(@value,'neon-yellow point labels')]/../../following-sibling::div[1]//select"),
					"Yes");
			selectByText(
					By.xpath(
							"//input[contains(@value,'orientation and LIVE ANIMAL labels')]/../../following-sibling::div[1]//select"),
					"Yes");
			selectByText(
					By.xpath(
							"//input[contains(@value,'compatible for every aircraft')]/../../following-sibling::div[1]//select"),
					"Yes");
			selectByText(
					By.xpath(
							"//input[contains(@value,'or exceed the current requirements in the IATA LAR')]/../../following-sibling::div[1]//select"),
					"Yes");
			selectByText(By.xpath("//input[contains(@value,'escape-proof')]/../../following-sibling::div[1]//select"),
					"Yes");
			selectByText(
					By.xpath(
							"//input[contains(@value,'adequately ventilated on 3 sides')]/../../following-sibling::div[1]//select"),
					"Yes");
			selectByText(
					By.xpath(
							"//input[contains(@value,'spacer bars so the container can be easily moved or lifted')]/../../following-sibling::div[1]//select"),
					"Yes");
			selectByText(
					By.xpath(
							"//input[contains(@value,'containing absorbent bedding or other flooring material')]/../../following-sibling::div[1]//select"),
					"Yes");
			selectByText(
					By.xpath(
							"//input[contains(@value,'and rest comfortably without touching any of the sides of the container')]/../../following-sibling::div[1]//select"),
					"Yes");

			minWait();
			break;
		}

		click(By.name("btnSave"));
		minWait();
		driver.switchTo().defaultContent();
		click(By.xpath("//button[text()='OK']"));
		minWait();
		try {
			driver.switchTo().frame(screenFrame);
			driver.switchTo().frame("popupContainerFrame");
			driver.findElement(By.xpath("//button[text()='Close']")).click();
			driver.switchTo().frame(screenFrame);
		} catch (Exception e) {
			driver.switchTo().defaultContent();
			waitForFrameAndSwitch(screenFrame);
		}
		minWait();
		// waitForFrameAndSwitch(screenFrame);
		click(By.name("btnSave"));
		minWait();
		if (verifyElementPresent(info_msg)) {
			InitialSetup.test.log(LogStatus.INFO,
					"Pop-up message after Save Button Click: " + driver.findElement(info_msg).getText());
			click(btn_genericYes);
		}
		minWait();
		click(By.name("btnSave"));
		minWait();
		if (verifyElementPresent(info_msg)) {
			InitialSetup.test.log(LogStatus.INFO,
					"Pop-up message after Save Button Click: " + driver.findElement(info_msg).getText());
			click(btn_genericYes);
		}
		minWait();
		minWait();
		String CaptureStatus = driver.findElement(By.xpath("(//*[@id='overviewBar']/div/div)[3]/div")).getText();
		PropertyHandler.setPropValue(dataFilePath, "CaptureStatus", CaptureStatus);

		if (CaptureStatus.equalsIgnoreCase("Executed")) {
			InitialSetup.test.log(LogStatus.PASS, "Successfully Executed AWB. AWB Capture Status: " + CaptureStatus);
			captureAndAddScreenshot();
		} else {
			InitialSetup.test.log(LogStatus.FAIL, "Could not execute AWB. Data Capture Status: " + CaptureStatus);
			Assert.fail("Cannot Execute AWB");
		}
		return this;
	}

	/**
	 * @author A-8457 Souvik Description: For performing PPS Booking only for
	 *         single leg with SCC and Payment Mode
	 * @param carriercode
	 * @param awbno
	 * @param fltNo
	 * @param fltDt
	 * @param Product
	 * @param agentCode
	 * @param shipper
	 * @param consignee
	 * @param origin
	 * @param dest
	 * @param pcs
	 * @param wt
	 * @param vol
	 * @param Commodity
	 * @param prefix
	 * @return
	 */
	public LTE001 doBookingPPSWithSCCPaymentMode(String carriercode, String awbno, String fltNo, String fltDt,
			String Product, String agentCode, String shipper, String consignee, String origin, String dest, String pcs,
			String wt, String vol, String Commodity, String prefix, String CustomerType, String scc,
			String ModeOfPayment) {

		minWait();
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		Product = PropertyHandler.getPropValue(dataFilePath, Product);
		agentCode = PropertyHandler.getPropValue(dataFilePath, agentCode);
		shipper = PropertyHandler.getPropValue(dataFilePath, shipper);
		consignee = PropertyHandler.getPropValue(dataFilePath, consignee);
		origin = PropertyHandler.getPropValue(dataFilePath, origin);
		dest = PropertyHandler.getPropValue(dataFilePath, dest);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		vol = PropertyHandler.getPropValue(dataFilePath, vol);
		Commodity = PropertyHandler.getPropValue(dataFilePath, Commodity);
		carriercode = PropertyHandler.getPropValue(dataFilePath, carriercode);
		CustomerType = PropertyHandler.getPropValue(dataFilePath, CustomerType);
		scc = PropertyHandler.getPropValue(dataFilePath, scc);
		ModeOfPayment = PropertyHandler.getPropValue(dataFilePath, ModeOfPayment);

		String orgindestination = origin + "-" + dest;
		String carrierwithFlightno = carriercode + fltNo;
		PropertyHandler.setPropValue(dataFilePath, "carrierwithFlightno", carrierwithFlightno);

		listAWB(prefix, awbno);

		InitialSetup.test.log(LogStatus.INFO,
				"Successfully entertered Carrier code and AWB No:" + prefix + "-" + awbno);
		maxWait();
		// A-8457 souvik edited as per the release

		if (verifyElementVisible(txt_ProductType)) {
			minWait();
			enterKeys(txt_ProductType, Product + Keys.TAB);
			maxWait();
			selectByText(select_CustomerType, CustomerType);
			click(By.xpath("//button[@name='btnCustomerTypeCont']"));
			minWait();
		} else {
			click(By.xpath("(//span[@class='ui-accordion-header-icon ui-icon ui-icon-triangle-1-e'])[1]"));
			minWait();
			enterKeys(txt_ProductType, Product + Keys.TAB);
			maxWait();
			selectByText(select_CustomerType, CustomerType);
			click(By.xpath("//button[@name='btnCustomerTypeCont']"));
			minWait();
		}

		// click(link_ParticipantDetail);
		enterKeys(txt_agent, agentCode + Keys.TAB);
		enterKeys(txt_shipperCode, shipper + Keys.TAB);
		enterKeys(txt_ConsigneeCode, consignee + Keys.TAB);
		click(By.xpath("//button[@name='btnParticipantCont']"));
		minWait();
		// ------------------------Certificate
		// Details---------------------------
		if (verifyElementPresent(By.xpath("//*[@name='driverIDType']"))) {
			selectByText(By.xpath("//*[@name='driverIDType']"), "Driving License");
			enterKeys(By.xpath("//*[@name='stateOrCountryIssuingID']"), "US");
			enterKeys(By.xpath("//*[@name='driverName']"), "Test");
			enterKeys(By.xpath("//*[@name='driverCompany']"), "IBSAT");
			// click(By.xpath("//*[@name='photoIDVerified']"));
			selectByText(By.xpath("//select[@name='photoIDVerified']"), "Yes");
			click(By.xpath("//button[@name='btnCertificateDetailsCont']"));
		}

		scrollToView(link_BookingDetails);

		// click(link_shipmentDetails);
		enterKeys(By.xpath("//*[@name='ppsOrigin']"), origin);
		enterKeys(By.xpath("//*[@name='ppsDestination']"), dest);
		selectByText(By.xpath("//select[@name='ppsWeightUnit']"), "kg");
		selectByText(By.xpath("//select[@name='ppsVolumeUnit']"), "cbm");
		selectByText(By.xpath("//select[@name='ppsWeightUnit']"), "lbs");
		selectByText(By.xpath("//select[@name='ppsVolumeUnit']"), "cbf");
		enterKeys(By.xpath("//*[@name='ppsShpPcs']"), pcs);
		enterKeys(By.xpath("//*[@name='ppsShpWgt']"), wt);
		/*
		 * selectByText(By.xpath("//select[@name='ppsWeightUnit']"), "lbs");
		 * selectByText(By.xpath("//select[@name='ppsVolumeUnit']"), "cbf");
		 */
		enterKeys(By.xpath("//*[@name='ppsShpVol']"), vol);
		enterKeys(By.xpath("//*[@name='ppsShippingDate']"), fltDt + Keys.TAB);
		/*
		 * selectByText(By.xpath("//*[@name='ppsRatingWeightUnit']"), "lbs");
		 * selectByText(By.xpath("//*[@name='ppsRatingVolumeUnit']"), "cbf");
		 */
		// enterKeys(By.xpath(""), Product);

		selectByText(By.xpath("//*[@name='ppsCommodityCode']"), Commodity);

		minWait();

		enterKeys(By.xpath("//*[@name='ppsDimensionLength']"), "10" + Keys.TAB);
		enterKeys(By.xpath("//*[@name='ppsDimensionWidth']"), "10" + Keys.TAB);
		enterKeys(By.xpath("//*[@name='ppsDimensionHeight']"), "10" + Keys.TAB);

		String CalcVol = driver.findElement(By.xpath("//*[@name='ppsShpVol']")).getAttribute("value");
		PropertyHandler.setPropValue(dataFilePath, "volume", CalcVol);

		enterKeys(By.name("ppsScc"), scc);

		if (Product.equalsIgnoreCase("PPS")) {
			selectByText(By.xpath("//*[@name='ppsCommodityCode']"), Commodity);
		} else {
			enterKeys(txt_commodityCode, Commodity);
		}
		minWait();

		minWait();
		driver.switchTo().defaultContent();
		handleAlert("Accept", "LTE001");
		minWait();
		driver.switchTo().frame("iCargoContentFrameLTE001");
		click(By.xpath("//button[@name='btnPPSShipmentCont']"));
		minWait();

		// click(link_BookingDetails);
		minWait();
		enterKeys(txt_CarrierCode, carriercode);
		enterKeys(txt_flightnumber, fltNo);
		enterKeys(txt_flightdate, fltDt);
		enterKeys(txt_FlightSegment, orgindestination);
		enterKeys(txt_FltPcs, pcs);
		minWait();
		enterKeys(txt_FltWt, wt);
		minWait();
		String flightDt = driver.findElement(txt_flightdate).getAttribute("value");

		PropertyHandler.setPropValue(dataFilePath, "flightDt", flightDt);
		vol = PropertyHandler.getPropValue(dataFilePath, "volume");
		// enterKeys(txt_FltVolume, vol);
		click(By.xpath("//button[@name='btnFlightDtlsCont']"));
		minWait();

		// click(link_ChargeDetails);
		minWait();
		click(btn_Calculte);
		minWait();
		driver.switchTo().defaultContent();
		handleAlert("Accept", "LTE001");
		minWait();
		driver.switchTo().frame(screenFrame);
		minWait();
		try {
			selectByText(select_ModeofPayment, ModeOfPayment);
		} catch (Exception e) {
		}

		click(By.xpath("//button[@name='btnChargeDtlsCont']"));
		minWait();
		click(btn_Save);
		maxWait();

		// pop-up: The shipper does not have a valid certificate. Do you want to
		// continue?
		driver.switchTo().defaultContent();
		if (verifyElementPresent(info_msg)) {
			InitialSetup.test.log(LogStatus.INFO,
					"Pop-up message after saving: " + driver.findElement(info_msg).getText());
			click(btn_genericYes);
			minWait();
		}
		waitForFrameAndSwitch(screenFrame);

		// embargo
		/*
		 * if(verifyElementPresent(By.xpath("(//button[@id='okBtn'])[2]"))) {
		 * click(By.xpath("(//button[@id='okBtn'])[2]")); }
		 * 
		 * 
		 * //same pop-up driver.switchTo().defaultContent(); minWait();
		 * //waitForFrameAndSwitch(screenFrame); handleAlert("Accept",
		 * "LTE001"); minWait(); driver.switchTo().frame(screenFrame);
		 */
		minWait();

		// Capture booking status

		String BookingStatus = driver.findElement(By.xpath("(//*[@id='overviewBar']/div/div)[2]/div")).getText();
		PropertyHandler.setPropValue(dataFilePath, "LTEBookingStatus", BookingStatus);

		if (BookingStatus.equalsIgnoreCase("Confirmed") || BookingStatus.equalsIgnoreCase("Queued")) {
			InitialSetup.test.log(LogStatus.PASS, "Booking done with Status: " + BookingStatus);
		} else {
			InitialSetup.test.log(LogStatus.FAIL,
					"Booking status is not confirmed or Queued. Status" + "displayed is: " + BookingStatus);
			Assert.fail("Booking status is not confirmed or Queued. Status" + "displayed is: ");
		}
		return this;
	}

	/**
	 * @author A-8457 Souvik Description: For performing Booking only for single
	 *         leg with SCC and Payment Mode
	 * @param carriercode
	 * @param awbno
	 * @param fltNo
	 * @param fltDt
	 * @param Product
	 * @param agentCode
	 * @param shipper
	 * @param consignee
	 * @param origin
	 * @param dest
	 * @param pcs
	 * @param wt
	 * @param vol
	 * @param Commodity
	 * @param prefix
	 * @return
	 */
	public LTE001 doBookingOnlyWithSCCPaymentMode(String carriercode, String awbno, String fltNo, String fltDt,
			String Product, String agentCode, String shipper, String consignee, String origin, String dest, String pcs,
			String wt, String vol, String Commodity, String prefix, String CustomerType, String scc,
			String ModeOfPayment) {

		minWait();
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		Product = PropertyHandler.getPropValue(dataFilePath, Product);
		agentCode = PropertyHandler.getPropValue(dataFilePath, agentCode);
		shipper = PropertyHandler.getPropValue(dataFilePath, shipper);
		consignee = PropertyHandler.getPropValue(dataFilePath, consignee);
		origin = PropertyHandler.getPropValue(dataFilePath, origin);
		dest = PropertyHandler.getPropValue(dataFilePath, dest);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		vol = PropertyHandler.getPropValue(dataFilePath, vol);
		Commodity = PropertyHandler.getPropValue(dataFilePath, Commodity);
		carriercode = PropertyHandler.getPropValue(dataFilePath, carriercode);
		CustomerType = PropertyHandler.getPropValue(dataFilePath, CustomerType);
		scc = PropertyHandler.getPropValue(dataFilePath, scc);
		ModeOfPayment = PropertyHandler.getPropValue(dataFilePath, ModeOfPayment);

		String orgindestination = origin + "-" + dest;
		String carrierwithFlightno = carriercode + fltNo;
		PropertyHandler.setPropValue(dataFilePath, "carrierwithFlightno", carrierwithFlightno);

		listAWB(prefix, awbno);

		InitialSetup.test.log(LogStatus.INFO,
				"Successfully entertered Carrier code and AWB No:" + prefix + "-" + awbno);
		maxWait();
		// A-8457 souvik edited as per the release

		if (verifyElementVisible(txt_ProductType)) {
			minWait();
			enterKeys(txt_ProductType, Product + Keys.TAB);
			maxWait();
			selectByText(select_CustomerType, CustomerType);
			click(By.xpath("//button[@name='btnCustomerTypeCont']"));
			minWait();
		} else {
			click(By.xpath("(//span[@class='ui-accordion-header-icon ui-icon ui-icon-triangle-1-e'])[1]"));
			minWait();
			enterKeys(txt_ProductType, Product + Keys.TAB);
			maxWait();
			selectByText(select_CustomerType, CustomerType);
			click(By.xpath("//button[@name='btnCustomerTypeCont']"));
			minWait();
		}

		// click(link_ParticipantDetail);
		enterKeys(txt_agent, agentCode + Keys.TAB);
		enterKeys(txt_shipperCode, shipper + Keys.TAB);
		enterKeys(txt_ConsigneeCode, consignee + Keys.TAB);
		click(By.xpath("//button[@name='btnParticipantCont']"));
		minWait();
		// ------------------------Certificate
		// Details---------------------------
		if (verifyElementPresent(By.xpath("//*[@name='driverIDType']"))) {
			selectByText(By.xpath("//*[@name='driverIDType']"), "Driving License");
			enterKeys(By.xpath("//*[@name='stateOrCountryIssuingID']"), "US");
			enterKeys(By.xpath("//*[@name='driverName']"), "Test");
			enterKeys(By.xpath("//*[@name='driverCompany']"), "IBSAT");
			// click(By.xpath("//*[@name='photoIDVerified']"));
			selectByText(By.xpath("//select[@name='photoIDVerified']"), "Yes");
			click(By.xpath("//button[@name='btnCertificateDetailsCont']"));
		}

		scrollToView(link_BookingDetails);

		// click(link_shipmentDetails);
		enterKeys(txt_Origin, origin);
		enterKeys(txt_destination, dest);
		enterKeys(txt_shipmentPcs, pcs);
		enterKeys(txt_shipmentwt, wt);
		enterKeys(txt_shipmentvolume, vol);
		enterKeys(By.xpath("//*[@name='shippingDate']"), fltDt);
		selectByText(By.xpath("//*[@name='shpWeightUnit']"), "lbs");
		selectByText(By.xpath("//*[@name='shpVolumeUnit']"), "cbf");
		if (Product.equalsIgnoreCase("PPS")) {
		} else {
			enterKeys(txt_producttype, Product);
		}
		enterKeys(By.name("scc"), scc);
		if (Product.equalsIgnoreCase("COMAT")) {
			selectByText(By.name("serviceCargoClass"), "COMAT");
		}

		if (Product.equalsIgnoreCase("PPS")) {
			selectByText(By.xpath("//*[@name='ppsCommodityCode']"), Commodity);
		} else {
			enterKeys(txt_commodityCode, Commodity);
		}
		minWait();
		selectByText(By.xpath("//select[@name='sci']"),
				/* PropertyHandler.getPropValue(dataFilePath,"sci") */ "T1");
		minWait();
		// Set Dimension
		click(Icon_SetDimention);
		minWait();
		enterKeys(txt_SetPcse, pcs);
		// driver.findElement(By.xpath("(//div[@name='dimensionsPanelTagName']//input[@name='dimensionPcs'])[1]")).sendKeys(pcs);
		enterKeys(txt_SetWt, wt);
		enterKeys(txt_SetLenght, "10");
		enterKeys(txt_SetWidth, "10");
		enterKeys(txt_SetHeight, "10" + Keys.TAB);
		enterKeys(txt_SetHeight, Keys.TAB);
		minWait();
		// driver.findElement(By.xpath("(//input[@name='dimensionHeight'])[4]")).click();
		minWait();
		click(Popup_btnOK);
		minWait();
		driver.switchTo().defaultContent();
		handleAlert("Accept", "LTE001");
		minWait();
		driver.switchTo().frame("iCargoContentFrameLTE001");
		String CalcVol = driver.findElement(txt_shipmentvolume).getAttribute("value");
		PropertyHandler.setPropValue(dataFilePath, "volume", CalcVol);
		click(By.xpath("//button[@name='btnShipmentCont']"));
		minWait();

		// click(link_BookingDetails);
		minWait();
		enterKeys(txt_CarrierCode, carriercode);
		enterKeys(txt_flightnumber, fltNo);
		enterKeys(txt_flightdate, fltDt);
		enterKeys(txt_FlightSegment, orgindestination);
		enterKeys(txt_FltPcs, pcs);
		minWait();
		enterKeys(txt_FltWt, wt);
		minWait();
		String flightDt = driver.findElement(txt_flightdate).getAttribute("value");

		PropertyHandler.setPropValue(dataFilePath, "flightDt", flightDt);
		vol = PropertyHandler.getPropValue(dataFilePath, "volume");
		// enterKeys(txt_FltVolume, vol);
		click(By.xpath("//button[@name='btnFlightDtlsCont']"));
		minWait();

		// click(link_ChargeDetails);
		minWait();
		click(btn_Calculte);
		minWait();
		driver.switchTo().defaultContent();
		handleAlert("Accept", "LTE001");
		minWait();
		driver.switchTo().frame(screenFrame);
		minWait();
		try {
			selectByText(select_ModeofPayment, ModeOfPayment);
		} catch (Exception e) {
		}

		click(By.xpath("//button[@name='btnChargeDtlsCont']"));
		minWait();
		click(btn_Save);
		maxWait();

		// pop-up: The shipper does not have a valid certificate. Do you want to
		// continue?
		driver.switchTo().defaultContent();
		if (verifyElementPresent(info_msg)) {
			InitialSetup.test.log(LogStatus.INFO,
					"Pop-up message after saving: " + driver.findElement(info_msg).getText());
			click(btn_genericYes);
			minWait();
		}
		waitForFrameAndSwitch(screenFrame);

		// embargo
		/*
		 * if(verifyElementPresent(By.xpath("(//button[@id='okBtn'])[2]"))) {
		 * click(By.xpath("(//button[@id='okBtn'])[2]")); }
		 * 
		 * 
		 * //same pop-up driver.switchTo().defaultContent(); minWait();
		 * //waitForFrameAndSwitch(screenFrame); handleAlert("Accept",
		 * "LTE001"); minWait(); driver.switchTo().frame(screenFrame);
		 */
		minWait();

		// Capture booking status

		String BookingStatus = driver.findElement(By.xpath("(//*[@id='overviewBar']/div/div)[2]/div")).getText();
		PropertyHandler.setPropValue(dataFilePath, "LTEBookingStatus", BookingStatus);

		if (BookingStatus.equalsIgnoreCase("Confirmed") || BookingStatus.equalsIgnoreCase("Queued")) {
			InitialSetup.test.log(LogStatus.PASS, "Booking done with Status: " + BookingStatus);
		} else {
			InitialSetup.test.log(LogStatus.FAIL,
					"Booking status is not confirmed or Queued. Status" + "displayed is: " + BookingStatus);
			Assert.fail("Booking status is not confirmed or Queued. Status" + "displayed is: ");
		}
		return this;
	}

	/**
	 * @author A-8452 Faizan Description: For performing Booking only for single
	 *         leg
	 * @param carriercode
	 * @param awbno
	 * @param fltNo
	 * @param fltDt
	 * @param Product
	 * @param agentCode
	 * @param shipper
	 * @param consignee
	 * @param origin
	 * @param dest
	 * @param pcs
	 * @param wt
	 * @param vol
	 * @param Commodity
	 * @param prefix
	 * @return
	 */
	public LTE001 doBookingOnlyWithoutAwb(String carriercode, String awbno, String fltNo, String fltDt, String Product,
			String agentCode, String shipper, String consignee, String origin, String dest, String pcs, String wt,
			String vol, String Commodity, String prefix, String CustomerType, String ModeofPayment) {

		minWait();

		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		Product = PropertyHandler.getPropValue(dataFilePath, Product);
		agentCode = PropertyHandler.getPropValue(dataFilePath, agentCode);
		shipper = PropertyHandler.getPropValue(dataFilePath, shipper);
		consignee = PropertyHandler.getPropValue(dataFilePath, consignee);
		origin = PropertyHandler.getPropValue(dataFilePath, origin);
		dest = PropertyHandler.getPropValue(dataFilePath, dest);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		vol = PropertyHandler.getPropValue(dataFilePath, vol);
		Commodity = PropertyHandler.getPropValue(dataFilePath, Commodity);
		carriercode = PropertyHandler.getPropValue(dataFilePath, carriercode);
		CustomerType = PropertyHandler.getPropValue(dataFilePath, CustomerType);
		ModeofPayment = PropertyHandler.getPropValue(dataFilePath, ModeofPayment);

		String orgindestination = origin + "-" + dest;
		String carrierwithFlightno = carriercode + fltNo;
		PropertyHandler.setPropValue(dataFilePath, "carrierwithFlightno", carrierwithFlightno);
		minWait();
		click(btn_list);
		InitialSetup.test.log(LogStatus.INFO,
				"Successfully entertered Carrier code and AWB No:" + prefix + "-" + awbno);

		maxWait();
		minWait();
		// click(By.xpath("(//span[@class='ui-accordion-header-icon ui-icon
		// ui-icon-triangle-1-e'])[1]"));
		if (!verifyElementVisible(txt_ProductType)) {
			click(By.xpath("//div[contains(text(),'Product and Customer Type')]/../span"));
			minWait();
		}
		enterKeys(txt_ProductType, Product + Keys.TAB);
		minWait();
		selectByText(select_CustomerType, CustomerType);
		click(By.xpath("//button[@name='btnCustomerTypeCont']"));
		minWait();

		// click(link_ParticipantDetail);
		enterKeys(txt_agent, agentCode + Keys.TAB);
		enterKeys(txt_shipperCode, shipper + Keys.TAB);
		enterKeys(txt_ConsigneeCode, consignee + Keys.TAB);
		click(By.xpath("//button[@name='btnParticipantCont']"));
		minWait();
		// ------------------------Certificate
		// Details---------------------------
		if (verifyElementPresent(By.xpath("//*[@name='driverIDType']"))) {
			selectByText(By.xpath("//*[@name='driverIDType']"), "Driving License"); // Driving
																					// License
																					// in
																					// STAG
			scrollToView(By.name("photoIDVerified"));
			enterKeys(By.xpath("//*[@name='stateOrCountryIssuingID']"), "US");
			enterKeys(By.xpath("//*[@name='driverName']"), "Test");
			enterKeys(By.xpath("//*[@name='driverCompany']"), "IBSAT");
			// click(By.xpath("//*[@name='photoIDVerified']"));
			selectByText(By.name("photoIDVerified"), "Yes"); // Added Code on
																// 22nd Aug

			click(By.xpath("//button[@name='btnCertificateDetailsCont']"));
		}
		scrollToView(link_BookingDetails);
		// click(link_shipmentDetails);
		enterKeys(txt_Origin, origin);
		enterKeys(txt_destination, dest);
		enterKeys(By.xpath("//*[@name='shippingDate']"), fltDt + Keys.TAB);
		selectByText(By.xpath("//*[@name='sci']"), "T1");
		if (Product.equalsIgnoreCase("PPS")) {
			selectByText(By.xpath("//*[@name='ppsCommodityCode']"), Commodity);
		} else {
			enterKeys(txt_commodityCode, Commodity + Keys.TAB);
		}
		minWait();
		enterKeys(txt_shipmentPcs, pcs);
		enterKeys(txt_shipmentwt, wt);
//		enterKeys(txt_shipmentvolume, vol);
		
	/*	selectByText(By.xpath("//*[@name='shpWeightUnit']"), "lbs");
		selectByText(By.xpath("//*[@name='shpVolumeUnit']"), "cbf");*/
//		enterKeys(txt_producttype, Product);
		minWait();
		// Set Dimension
		click(Icon_SetDimention);
		minWait();
		enterKeys(txt_SetPcse, pcs);
		enterKeys(txt_SetWt, wt);
		enterKeys(txt_SetLenght, "10");
		enterKeys(txt_SetWidth, "10");
		enterKeys(txt_SetHeight, "10" + Keys.TAB);
		enterKeys(txt_SetHeight, Keys.TAB);
		minWait();
		click(Popup_btnOK);
		minWait();
		handleAlert("Accept", "LTE001");
		minWait();
		waitForFrameAndSwitch(screenFrame);
		String CalcVol = driver.findElement(txt_shipmentvolume).getAttribute("value");
		PropertyHandler.setPropValue(dataFilePath, "volume", CalcVol);
		click(By.xpath("//button[@name='btnShipmentCont']"));
		minWait();
		// click(link_BookingDetails);
		minWait();
		enterKeys(txt_CarrierCode, carriercode);
		enterKeys(txt_flightnumber, fltNo);
		enterKeys(txt_flightdate, fltDt);
		enterKeys(txt_FlightSegment, orgindestination);
		enterKeys(txt_FltPcs, pcs);
		minWait();
		enterKeys(txt_FltWt, wt);
		minWait();
		vol = PropertyHandler.getPropValue(dataFilePath, "volume");
		enterKeys(txt_FltVolume, vol);
		click(By.xpath("//button[@name='btnFlightDtlsCont']"));
		maxWait();
		minWait();
		// Added Code on 22nd Aug if-else

		// click(link_ChargeDetails);
		// if(!(driver.findElement(select_ModeofPayment).isDisplayed())){
		minWait();
		click(btn_Calculte);
		minWait();
		handleAlert("Accept", "LTE001");
		minWait();
		waitForFrameAndSwitch(screenFrame);
		minWait();
		if (verifyElementPresent(select_ModeofPayment)) {
			selectByText(select_ModeofPayment, ModeofPayment);
		}
		/*
		 * try { selectByText(select_ModeofPayment, ModeofPayment); } catch
		 * (Exception e) {}
		 */
		// }
		/*
		 * else { selectByText(select_ModeofPayment, "CASH"); }
		 */
		minWait();
		click(By.xpath("//button[@name='btnChargeDtlsCont']"));
		minWait();
		click(btn_Save);
		maxWait();
		// pop-up: The shipper does not have a valid certificate. Do you want to
		// continue?
		driver.switchTo().defaultContent();
		if (verifyElementPresent(info_msg)) {
			InitialSetup.test.log(LogStatus.INFO,
					"Pop-up message after saving: " + driver.findElement(info_msg).getText());
			click(btn_genericYes);
			minWait();
		}
		waitForFrameAndSwitch(screenFrame);
		handleEmbargoPopUp();
		// embargo
		if (verifyElementPresent(By.xpath("(//button[@id='okBtn'])[2]"))) {
			click(By.xpath("(//button[@id='okBtn'])[2]"));
		}
		// same pop-up
		/*
		 * driver.switchTo().defaultContent(); minWait();
		 * //waitForFrameAndSwitch(screenFrame); handleAlert("Accept",
		 * "LTE001"); minWait(); driver.switchTo().frame(screenFrame);
		 */
		minWait();
		// Capture booking status
		String BookingStatus = driver.findElement(By.xpath("(//*[@id='overviewBar']/div/div)[2]/div")).getText();
		PropertyHandler.setPropValue(dataFilePath, "LTEBookingStatus", BookingStatus);
		minWait();
		String AWB = driver.findElement(By.xpath("(//*[@id='overviewBar']/div/div)[1]/div")).getText();
		String awb[] = AWB.split("-");
		PropertyHandler.setPropValue(dataFilePath, prefix, awb[0]);
		PropertyHandler.setPropValue(dataFilePath, awbno, awb[1]);
		if (BookingStatus.equalsIgnoreCase("Confirmed") || BookingStatus.equalsIgnoreCase("Queued")) {
			InitialSetup.test.log(LogStatus.PASS, "Booking done with Status: " + BookingStatus);
			captureAndAddScreenshot();
		} else {
			InitialSetup.test.log(LogStatus.FAIL,
					"Booking status is not confirmed or Queued. Status" + "displayed is: " + BookingStatus);
			Assert.fail("Booking status is not confirmed or Queued. Status" + "displayed is: ");
		}
		return this;
	}

	/**
	 * @author A-8452 Faizan
	 * @return
	 */
	public LTE001 handleEmbargoPopUp() {
		if (verifyElementPresent(By.xpath("//div[@id='EMBPOP']//button[@name='okBtn']"))) {
			minWait();
			if (driver.findElement(By.xpath("//div[@id='EMBPOP']//button[@name='okBtn']")).isEnabled()) {
				captureAndAddScreenshot();
				driver.findElement(By.xpath("//div[@id='EMBPOP']//button[@name='okBtn']")).click();
				InitialSetup.test.log(LogStatus.INFO, "Embargo with Warning Handled");
			} else {
				captureAndAddScreenshot();
				driver.findElement(By.xpath("//div[@id='EMBPOP']//button[@name='cancalBtn']")).click();
				InitialSetup.test.log(LogStatus.ERROR, "Embargo with error is observed.");
				Assert.fail();
			}

		}
		return this;
	}
	
//	Sharath
	public LTE001 doLitebookingToAcceptance(String carriercode, String awbno, String fltNo, String fltDt,
			String Product, String agentCode, String shipper, String consignee, String origin, String dest, String pcs,
			String wt, String vol, String Commodity, String prefix, String CustomerType, String intermediate,
			String carriercode1, String fltNo1, String fltDt1, boolean UldNeeded, String UldNumber, String ScreenMethod,
			String ScreenResult, String slacPcs, String index,String uldNo, String path) throws Exception {
	
		String origindestination = origin + "-" + intermediate;

//		String origindestination = origin + "-" + dest;
		String carrierwithFlightno = carriercode + fltNo;

		String origindestination1 = intermediate + "-" + dest;
		String carrierwithFlightno1 = carriercode1 + fltNo1;

		click(btn_list);

//		maxWait();
		maxWait();
		// ------------------------------Product and Customer
		// Type------------------------
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[contains(text(),'Product and Customer')]/preceding-sibling::span"))).click();
		// click(By.xpath("//div[contains(text(),'Product and Customer')]"));
		enterKeys(txt_ProductType, Product + Keys.TAB);
		minWait();
		selectByText(select_CustomerType, CustomerType);
		InitialSetup.test.log(LogStatus.INFO, "Successfully entered Product and Customer Details");
		click(By.xpath("//button[@name='btnCustomerTypeCont']"));

		// -----------------------------Participant
		// Details-------------------------------
		// click(link_ParticipantDetail);
		enterKeys(txt_agent, agentCode + Keys.TAB);
		minWait();
		enterKeys(txt_shipperCode, shipper + Keys.TAB);
		minWait();
		enterKeys(txt_ConsigneeCode, consignee + Keys.TAB);
		minWait();
		InitialSetup.test.log(LogStatus.INFO, "Successfully entered Participant Details");
		click(By.xpath("//button[@name='btnParticipantCont']"));
		minWait();

		// ------------------------Certificate
		// Details---------------------------
		if (verifyElementPresent(By.xpath("//*[@name='driverIDType']"))) {
			selectByText(By.xpath("//*[@name='driverIDType']"), "Driving License"); // Driving
																					// STAG
			enterKeys(By.xpath("//*[@name='stateOrCountryIssuingID']"), "US");
			enterKeys(By.xpath("//*[@name='driverName']"), "Test");
			enterKeys(By.xpath("//*[@name='driverCompany']"), "IBSAT");
			// click(By.xpath("//*[@name='photoIDVerified']"));
			selectByText(By.name("photoIDVerified"), "Yes"); // Added Code on
																// 22nd Aug

			click(By.xpath("//button[@name='btnCertificateDetailsCont']"));
		}

		scrollToView(link_BookingDetails);
		// click(link_shipmentDetails);
		enterKeys(txt_Origin, origin);
		enterKeys(txt_destination, dest);
		enterKeys(By.xpath("//*[@name='shippingDate']"), fltDt + Keys.TAB);
		selectByText(By.xpath("//*[@name='sci']"), "T1");
		if(!slacPcs.equals(null) || !slacPcs.equals("")){	
			enterKeys(By.xpath("//input[@name='slacPieces']"), slacPcs);
		}
		if (Product.equalsIgnoreCase("PPS")) {
			selectByText(By.xpath("//*[@name='ppsCommodityCode']"), Commodity);
		} else {
			enterKeys(txt_commodityCode, Commodity + Keys.TAB);
		}
		minWait();
		enterKeys(txt_shipmentPcs, pcs);
		enterKeys(txt_shipmentwt, wt);
//		enterKeys(txt_shipmentvolume, vol);
		
	/*	selectByText(By.xpath("//*[@name='shpWeightUnit']"), "lbs");
		selectByText(By.xpath("//*[@name='shpVolumeUnit']"), "cbf");*/
//		enterKeys(txt_producttype, Product);
		minWait();
		// Set Dimension
		click(Icon_SetDimention);
		minWait();
		enterKeys(txt_SetPcse, pcs);
		enterKeys(txt_SetWt, wt);
		enterKeys(txt_SetLenght, "10");
		enterKeys(txt_SetWidth, "10");
		enterKeys(txt_SetHeight, "10" + Keys.TAB);
		enterKeys(txt_SetHeight, Keys.TAB);
		minWait();
		click(Popup_btnOK);
		minWait();
		handleAlert("Accept", "LTE001");
		minWait();
		waitForFrameAndSwitch(screenFrame);
		String CalcVol = driver.findElement(txt_shipmentvolume).getAttribute("value");
		PropertyHandler.setPropValue(dataFilePath, "volume", CalcVol);
		click(By.xpath("//button[@name='btnShipmentCont']"));
		minWait();

		// --------------------Flight Details------------------------
		// click(link_BookingDetails);
		enterKeys(txt_CarrierCode, carriercode);
		enterKeys(txt_flightnumber, fltNo);
		enterKeys(txt_flightdate, fltDt + Keys.TAB);
		if(!intermediate.equals("")){
			enterKeys(txt_FlightSegment, origin+intermediate);
			}else{
				enterKeys(txt_FlightSegment, origin+dest);
			}
		enterKeys(txt_FltPcs, pcs);
		minWait();
		enterKeys(txt_FltWt, wt);
		minWait();
		String todaysDt = driver.findElement(txt_flightdate).getAttribute("value");
		PropertyHandler.setPropValue(dataFilePath, "flightDt", todaysDt);
		enterKeys(txt_FltVolume, CalcVol);
		minWait();
//		click(By.xpath("//div[@id='flightdetails']//i[@title='Add']"));
		InitialSetup.test.log(LogStatus.INFO, "Successfully entered flight details for O-D: " + origindestination
				+ " and FLight No.- " + carrierwithFlightno1);

		// 2nd flight details
		if(!intermediate.equals("")){
		click(By.xpath("//div[@id='flightdetails']//i[@title='Add']"));
		enterKeys(By.xpath("(//*[@name='flightCarrierCode'])[2]"), carriercode1);
		enterKeys(By.xpath("(//*[@name='flightNumber'])[2]"), fltNo1);
		enterKeys(By.xpath("(//*[@name='flightDate'])[2]"), fltDt1);
		enterKeys(By.xpath("(//*[@name='flightSegment'])[2]"), intermediate+dest);
		enterKeys(By.xpath("(//*[@name='bookedPieces'])[2]"), pcs);
		enterKeys(By.xpath("(//*[@name='bookedWeight'])[2]"), wt);
		enterKeys(By.xpath("(//*[@name='bookedVolume'])[2]"), CalcVol);
		click(By.xpath("(//div[@id='flightdetails']//i[@title='Add'])[last()]"));
		
		InitialSetup.test.log(LogStatus.INFO, "Successfully entered flight details for O-D: " + intermediate+dest
				+ " and FLight No.- " + carrierwithFlightno1);
		}
		click(By.xpath("//button[@name='btnFlightDtlsCont']"));
		minWait();

		// click(link_ChargeDetails)
		click(btn_Calculte);
		minWait();
		/*handleAlert("Accept", "LTE001");
		minWait();
		waitForFrameAndSwitch(screenFrame);
		minWait();*/
		maxWait();
		if (verifyElementPresent(select_ModeofPayment)) {
			selectByText(select_ModeofPayment, "CHECK");
		}
		/*
		 * try { selectByText(select_ModeofPayment, ModeofPayment); } catch
		 * (Exception e) {}
		 */
		// }
		/*
		 * else { selectByText(select_ModeofPayment, "CASH"); }
		 */
//		minWait();
		click(By.xpath("//button[@name='btnChargeDtlsCont']"));
		minWait();

		click(btn_Save);
		maxWait();

		// pop-up: The shipper does not have a valid certificate. Do you want to
		// continue?
		driver.switchTo().defaultContent();
		if (verifyElementPresent(info_msg)) {
			InitialSetup.test.log(LogStatus.INFO,
					"Pop-up message after saving: " + driver.findElement(info_msg).getText());
			click(btn_genericYes);
		}

		minWait();
		waitForFrameAndSwitch(screenFrame);

		// embargo
		if (verifyElementPresent(By.xpath("//div[@id='EmbargoDiv']//button[text()='Continue']"))) {
			click(By.xpath("//div[@id='EmbargoDiv']//button[text()='Continue']"));
		}
		maxWait();
		
		String awbNo = getText_JS(By.xpath("//a[contains(@class,'awb-number')]"));
		int rowNoint = Integer.parseInt(index);
		writeDatatoExcelCell(path, rowNoint, awbNo);
		InitialSetup.test.log(LogStatus.INFO, "Successfully booked: "+awbNo);
		
		/*click(By.xpath("//*[@id='view_header_chargeDtls']"));
		minWait();
		String totalPrice = driver.findElement(By.xpath("//span[@class='mar-t-xs']")).getText();
		PropertyHandler.setPropValue(dataFilePath, "totalChargeDisplayed", totalPrice);*/
		maxWait();
		click(btn_AwbVerified);
		InitialSetup.test.log(LogStatus.PASS, "Successfully clicked on AWB verification checkbox");
		click(btn_Save);
		maxWait();
		if (verifyElementPresent(info_msg)) {
			InitialSetup.test.log(LogStatus.INFO,
					"Pop-up message after Save Button Click: " + driver.findElement(info_msg).getText());
			click(btn_genericYes);
		}
		// embargo
		if (verifyElementPresent(By.xpath("//div[@id='EmbargoDiv']//button[text()='Continue']"))) {
			click(By.xpath("//div[@id='EmbargoDiv']//button[text()='Continue']"));
		}
		minWait();
		click(By.xpath("//div[contains(text(),'Acceptance Details')]/parent::div/span"));
		// click(By.xpath("(//div[contains(text(),'Acceptance
		// Details')])[last()]"));

		// click(By.xpath("(//*[@class='ui-accordion-header-icon ui-icon
		// ui-icon-triangle-1-e'])[8]"));
		/*enterKeys(txt_pieces, pcs);
		enterKeys(txt_weight, wt);
		minWait();
		enterKeys(txt_volume, vol);*/
		minWait();

		if (UldNeeded == true)// if uld details needs to be given, then true
								// else false
		{
			UldNumber = PropertyHandler.getPropValue(dataFilePath, UldNumber);
			// enterKeys(Txt_ULD,UldNumber);
			enterKeys(By.id("uldNumer_u"), UldNumber);
			enterKeys(By.xpath("//*[contains(text(),'Location')]/following-sibling::input"), "ACP-A-1-A");
		}
		// selectByText(By.name("acpWghtUnit"), "lbs");
		// selectByText(By.name("acpVolumeUnit"), "cbf");

		click(txt_AcceptAll);
		if(uldNo!=null || !uldNo.equals("")){
			enterKeys(By.xpath("//input[@name='uldNumer']"), uldNo);
		}
		click(By.xpath("//*[@name='btnAcceptanceDtlsCont']"));
		minWait();
		// Screening
		// click(Link_Screendetails);
		selectByText(select_ScreenMethod, ScreenMethod);
		enterKeys(txt_screenPcs, pcs);
		selectByText(select_screenPassFail, ScreenResult);
		minWait();
		click(btn_Save);
		maxWait();
		if (verifyElementPresent(By.xpath("//div[@id='EmbargoDiv']//button[@name='okBtn']"))) {
			captureAndAddScreenshot();
			click(By.xpath("//div[@id='EmbargoDiv']//button[@name='okBtn']"));
		}
		maxWait();
		driver.switchTo().defaultContent();
		handleAlert("Accept", "LTE001");
		maxWait();
		driver.switchTo().frame(screenFrame);
		if (verifyElementPresent(info_msg)) {
			InitialSetup.test.log(LogStatus.INFO,
					"Pop-up message after Save Button Click: " + driver.findElement(info_msg).getText());
			click(btn_genericYes);
		}
		if (verifyElementPresent(info_msg)) {
			InitialSetup.test.log(LogStatus.INFO,
					"Pop-up message after Save Button Click: " + driver.findElement(info_msg).getText());
			click(btn_genericYes);
		}
		
		return this;
	}

	
//	Sharath
	public LTE001 doLitebookingOnlyTestData(String carriercode, String awbno, String fltNo, String fltDt,
			String Product, String agentCode, String shipper, String consignee, String origin, String dest, String pcs,
			String wt, String vol, String Commodity, String prefix, String CustomerType, String intermediate,
			String carriercode1, String fltNo1, String fltDt1, boolean UldNeeded, String UldNumber, String ScreenMethod,
			String ScreenResult, String slacPcs, String index,String uldNo, String path) throws Exception {
	
		/*if(intermediate.equals("")){
		String origindestination = origin + "-" + dest;
		String carrierwithFlightno = carriercode + fltNo;
		}
		else
		{
		String origindestination1 = origin + "-" + intermediate;
		String origindestination2 = intermediate + "-" + dest;
		}*/
		String carrierwithFlightno1 = carriercode1 + fltNo1;

		click(btn_list);

//		maxWait();
		maxWait();
		// ------------------------------Product and Customer
		// Type------------------------
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[contains(text(),'Product and Customer')]/preceding-sibling::span"))).click();
		// click(By.xpath("//div[contains(text(),'Product and Customer')]"));
		enterKeys(txt_ProductType, Product + Keys.TAB);
		minWait();
		selectByText(select_CustomerType, CustomerType);
		InitialSetup.test.log(LogStatus.INFO, "Successfully entered Product and Customer Details");
		click(By.xpath("//button[@name='btnCustomerTypeCont']"));

		// -----------------------------Participant
		// Details-------------------------------
		// click(link_ParticipantDetail);
		enterKeys(txt_agent, agentCode + Keys.TAB);
		minWait();
		enterKeys(txt_shipperCode, shipper + Keys.TAB);
		minWait();
		enterKeys(txt_ConsigneeCode, consignee + Keys.TAB);
		minWait();
		InitialSetup.test.log(LogStatus.INFO, "Successfully entered Participant Details");
		click(By.xpath("//button[@name='btnParticipantCont']"));
		minWait();

		// ------------------------Certificate
		// Details---------------------------
		if (verifyElementPresent(By.xpath("//*[@name='driverIDType']"))) {
			selectByText(By.xpath("//*[@name='driverIDType']"), "Driving License"); // Driving
																					// STAG
			enterKeys(By.xpath("//*[@name='stateOrCountryIssuingID']"), "US");
			enterKeys(By.xpath("//*[@name='driverName']"), "Test");
			enterKeys(By.xpath("//*[@name='driverCompany']"), "IBSAT");
			// click(By.xpath("//*[@name='photoIDVerified']"));
			selectByText(By.name("photoIDVerified"), "Yes"); // Added Code on
																// 22nd Aug

			click(By.xpath("//button[@name='btnCertificateDetailsCont']"));
		}

		scrollToView(link_BookingDetails);
		// click(link_shipmentDetails);
		enterKeys(txt_Origin, origin);
		enterKeys(txt_destination, dest);
		enterKeys(By.xpath("//*[@name='shippingDate']"), fltDt + Keys.TAB);
		selectByText(By.xpath("//*[@name='sci']"), "T1");
		if(!slacPcs.equals(null) || !slacPcs.equals("")){	
			enterKeys(By.xpath("//input[@name='slacPieces']"), slacPcs);
		}
		if (Product.equalsIgnoreCase("PPS")) {
			selectByText(By.xpath("//*[@name='ppsCommodityCode']"), Commodity);
		} else {
			enterKeys(txt_commodityCode, Commodity + Keys.TAB);
		}
		minWait();
		enterKeys(txt_shipmentPcs, pcs);
		enterKeys(txt_shipmentwt, wt);
//		enterKeys(txt_shipmentvolume, vol);
		
	/*	selectByText(By.xpath("//*[@name='shpWeightUnit']"), "lbs");
		selectByText(By.xpath("//*[@name='shpVolumeUnit']"), "cbf");*/
//		enterKeys(txt_producttype, Product);
		minWait();
		// Set Dimension
		click(Icon_SetDimention);
		minWait();
		enterKeys(txt_SetPcse, pcs);
		enterKeys(txt_SetWt, wt);
		enterKeys(txt_SetLenght, "10");
		enterKeys(txt_SetWidth, "10");
		enterKeys(txt_SetHeight, "10" + Keys.TAB);
		enterKeys(txt_SetHeight, Keys.TAB);
		minWait();
		click(Popup_btnOK);
		minWait();
		handleAlert("Accept", "LTE001");
		minWait();
		waitForFrameAndSwitch(screenFrame);
		String CalcVol = driver.findElement(txt_shipmentvolume).getAttribute("value");
		PropertyHandler.setPropValue(dataFilePath, "volume", CalcVol);
		click(By.xpath("//button[@name='btnShipmentCont']"));
		minWait();

		// --------------------Flight Details------------------------
		// click(link_BookingDetails);
		enterKeys(txt_CarrierCode, carriercode);
		enterKeys(txt_flightnumber, fltNo);
		enterKeys(txt_flightdate, fltDt + Keys.TAB);
		if(intermediate.equals("")){
		enterKeys(txt_FlightSegment, origin+dest);
		}else{
			enterKeys(txt_FlightSegment, origin+intermediate);
		}
		enterKeys(txt_FltPcs, pcs);
		minWait();
		enterKeys(txt_FltWt, wt);
		minWait();
		String todaysDt = driver.findElement(txt_flightdate).getAttribute("value");
		PropertyHandler.setPropValue(dataFilePath, "flightDt", todaysDt);
		enterKeys(txt_FltVolume, CalcVol);
		minWait();

		InitialSetup.test.log(LogStatus.INFO, "Successfully entered flight details for O-D: " + origin+dest
				+ " and FLight No.- " + carrierwithFlightno1);

		// 2nd flight details
		if(!intermediate.equals("")){
		click(By.xpath("//div[@id='flightdetails']//i[@title='Add']"));
		enterKeys(By.xpath("(//*[@name='flightCarrierCode'])[2]"), carriercode1);
		enterKeys(By.xpath("(//*[@name='flightNumber'])[2]"), fltNo1);
		enterKeys(By.xpath("(//*[@name='flightDate'])[2]"), fltDt1);
		enterKeys(By.xpath("(//*[@name='flightSegment'])[2]"), intermediate+dest);
		enterKeys(By.xpath("(//*[@name='bookedPieces'])[2]"), pcs);
		enterKeys(By.xpath("(//*[@name='bookedWeight'])[2]"), wt);
		enterKeys(By.xpath("(//*[@name='bookedVolume'])[2]"), CalcVol);
		click(By.xpath("(//div[@id='flightdetails']//i[@title='Add'])[last()]"));
		
		InitialSetup.test.log(LogStatus.INFO, "Successfully entered flight details for O-D: " + intermediate+dest
				+ " and FLight No.- " + carrierwithFlightno1);
		}
		click(By.xpath("//button[@name='btnFlightDtlsCont']"));
		minWait();

		// click(link_ChargeDetails)
		click(btn_Calculte);
		minWait();
		/*handleAlert("Accept", "LTE001");
		minWait();
		waitForFrameAndSwitch(screenFrame);
		minWait();*/
		maxWait();
		if (verifyElementPresent(select_ModeofPayment)) {
			selectByText(select_ModeofPayment, "CHECK");
		}
		/*
		 * try { selectByText(select_ModeofPayment, ModeofPayment); } catch
		 * (Exception e) {}
		 */
		// }
		/*
		 * else { selectByText(select_ModeofPayment, "CASH"); }
		 */
//		minWait();
		click(By.xpath("//button[@name='btnChargeDtlsCont']"));
		minWait();

		click(btn_Save);
		maxWait();

		// pop-up: The shipper does not have a valid certificate. Do you want to
		// continue?
		driver.switchTo().defaultContent();
		if (verifyElementPresent(info_msg)) {
			InitialSetup.test.log(LogStatus.INFO,
					"Pop-up message after saving: " + driver.findElement(info_msg).getText());
			click(btn_genericYes);
		}

		minWait();
		waitForFrameAndSwitch(screenFrame);

		// embargo
		if (verifyElementPresent(By.xpath("//div[@id='EmbargoDiv']//button[@id='okBtn']"))) {
			click(By.xpath("//div[@id='EmbargoDiv']//button[@id='okBtn']"));
		}
//		maxWait();
		
		String awbNo = getText_JS(By.xpath("//a[contains(@class,'awb-number')]"));
		int rowNoint = Integer.parseInt(index);
		writeDatatoExcelCell(path, rowNoint, awbNo);
		String awb[] = awbNo.split("-");
		PropertyHandler.setPropValue(dataFilePath, "awbNo", awb[1]);
		return this;
	}
	
	
//	Sharath
	public LTE001 doCaptureAcceptanceTestData(String awbno, String uldNo, String ScreenMethod,
			String ScreenResult, String slacPcs, String pcs, String path) throws Exception {
	
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		listAWB("001", awbno);
		maxWait();
		click(btn_AwbVerified);
		InitialSetup.test.log(LogStatus.PASS, "Successfully clicked on AWB verification checkbox");
		click(btn_Save);
		maxWait();
		if (verifyElementPresent(info_msg)) {
			InitialSetup.test.log(LogStatus.INFO,
					"Pop-up message after Save Button Click: " + driver.findElement(info_msg).getText());
			click(btn_genericYes);
		}
		// embargo
		if (verifyElementPresent(By.xpath("(//button[@id='okBtn'])[2]"))) {
			click(By.xpath("(//button[@id='okBtn'])[2]"));
		}
		minWait();
		click(By.xpath("//div[contains(text(),'Acceptance Details')]/parent::div/span"));
		// click(By.xpath("(//div[contains(text(),'Acceptance
		// Details')])[last()]"));

		// click(By.xpath("(//*[@class='ui-accordion-header-icon ui-icon
		// ui-icon-triangle-1-e'])[8]"));
		/*enterKeys(txt_pieces, pcs);
		enterKeys(txt_weight, wt);
		minWait();
		enterKeys(txt_volume, vol);*/
		minWait();
		// selectByText(By.name("acpWghtUnit"), "lbs");
		// selectByText(By.name("acpVolumeUnit"), "cbf");

		click(txt_AcceptAll);
		if(uldNo!=null || !uldNo.equals("")){
			enterKeys(By.xpath("//input[@name='uldNumer']"), uldNo);
		}
		click(By.xpath("//*[@name='btnAcceptanceDtlsCont']"));
		minWait();
		// Screening
		// click(Link_Screendetails);
		selectByText(select_ScreenMethod, ScreenMethod);
		enterKeys(txt_screenPcs, pcs);
		selectByText(select_screenPassFail, ScreenResult);
		minWait();
		click(btn_Save);
		maxWait();
		if (verifyElementPresent(By.xpath("//div[@id='EmbargoDiv']//button[@name='okBtn']"))) {
			captureAndAddScreenshot();
			click(By.xpath("//div[@id='EmbargoDiv']//button[@name='okBtn']"));
		}
		maxWait();
		driver.switchTo().defaultContent();
		handleAlert("Accept", "LTE001");
		maxWait();
		driver.switchTo().frame(screenFrame);
		if (verifyElementPresent(info_msg)) {
			InitialSetup.test.log(LogStatus.INFO,
					"Pop-up message after Save Button Click: " + driver.findElement(info_msg).getText());
			click(btn_genericYes);
		}
		if (verifyElementPresent(info_msg)) {
			InitialSetup.test.log(LogStatus.INFO,
					"Pop-up message after Save Button Click: " + driver.findElement(info_msg).getText());
			click(btn_genericYes);
		}
		return this;
	}
	
//	Sharath
	public LTE001 doLitebookingToExecution(String carriercode, String awbno, String fltNo, String fltDt,
			String Product, String agentCode, String shipper, String consignee, String origin, String dest, String pcs,
			String wt, String vol, String Commodity, String prefix, String CustomerType, String intermediate,
			String carriercode1, String fltNo1, String fltDt1, boolean UldNeeded, String UldNumber, String ScreenMethod,
			String ScreenResult, String slacPcs, String index,String uldNo, String path, String wtUnit, boolean executionReqd) throws Exception {
	
		String origindestination = origin + "-" + intermediate;

//		String origindestination = origin + "-" + dest;
		String carrierwithFlightno = carriercode + fltNo;

		String origindestination1 = intermediate + "-" + dest;
		String carrierwithFlightno1 = carriercode1 + fltNo1;

		click(btn_list);

//		maxWait();
		maxWait();
		// ------------------------------Product and Customer
		// Type------------------------
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[contains(text(),'Product and Customer')]/preceding-sibling::span"))).click();
		// click(By.xpath("//div[contains(text(),'Product and Customer')]"));
		enterKeys(txt_ProductType, Product + Keys.TAB);
		minWait();
		selectByText(select_CustomerType, CustomerType);
		InitialSetup.test.log(LogStatus.INFO, "Successfully entered Product and Customer Details");
		click(By.xpath("//button[@name='btnCustomerTypeCont']"));

		// -----------------------------Participant
		// Details-------------------------------
		// click(link_ParticipantDetail);
		enterKeys(txt_agent, agentCode + Keys.TAB);
		minWait();
		enterKeys(txt_shipperCode, shipper + Keys.TAB);
		minWait();
		enterKeys(txt_ConsigneeCode, consignee + Keys.TAB);
		minWait();
		InitialSetup.test.log(LogStatus.INFO, "Successfully entered Participant Details");
		click(By.xpath("//button[@name='btnParticipantCont']"));
		minWait();

		/*// ------------------------Certificate
		// Details---------------------------
		if (verifyElementPresent(By.xpath("//*[@name='driverIDType']"))) {
			selectByText(By.xpath("//*[@name='driverIDType']"), "Driving License"); // Driving
																					// STAG
			enterKeys(By.xpath("//*[@name='stateOrCountryIssuingID']"), "US");
			enterKeys(By.xpath("//*[@name='driverName']"), "Test");
			enterKeys(By.xpath("//*[@name='driverCompany']"), "IBSAT");
			// click(By.xpath("//*[@name='photoIDVerified']"));
			selectByText(By.name("photoIDVerified"), "Yes"); // Added Code on
																// 22nd Aug
			click(By.xpath("//button[@name='btnCertificateDetailsCont']"));
		}*/
		// ------------------------Certificate
				// Details---------------------------
				if (verifyElementPresent(By.xpath("//input[@name='driverName']"))) {
					enterKeys(By.xpath("//input[@name='driverName']"),"Test Driver");
					enterKeys(By.name("driverCompany"), "Test Company");
					selectByText(By.xpath("//select[@name='driverIDType']"), "Driving License");
					scrollToView(By.xpath("//select[@name='photoIDVerified']"));
					enterKeys(By.name("stateOrCountryIssuingID"), "US");
					selectByText(By.xpath("//select[@name='photoIDVerified']"), "Yes");
					click(By.xpath("//button[@name='btnCertificateDetailsCont']"));
				}
				scrollToView(link_BookingDetails);

		scrollToView(link_BookingDetails);
		// click(link_shipmentDetails);
		enterKeys(txt_Origin, origin);
		enterKeys(txt_destination, dest);
		enterKeys(By.xpath("//*[@name='shippingDate']"), fltDt + Keys.TAB);
		selectByText(By.xpath("//*[@name='sci']"), "T1");
		try{
		if(!slacPcs.equals(null) || !slacPcs.equals("")){	
			enterKeys(By.xpath("//input[@name='slacPieces']"), slacPcs);
		}}catch(Exception e){
			System.out.println("Slac not reqd");
		}
		if (Product.equalsIgnoreCase("PPS")) {
			selectByText(By.xpath("//*[@name='ppsCommodityCode']"), Commodity);
		} else {
			enterKeys(txt_commodityCode, Commodity + Keys.TAB);
		}
		minWait();
		enterKeys(txt_shipmentPcs, pcs);
		enterKeys(txt_shipmentwt, wt);
//		enterKeys(txt_shipmentvolume, vol);
		if(wtUnit.equalsIgnoreCase("lbs")){
		selectByText(By.xpath("//*[@name='shpWeightUnit']"), "lbs");
		selectByText(By.xpath("//*[@name='shpVolumeUnit']"), "cbf");
		}else{
			selectByText(By.xpath("//*[@name='shpWeightUnit']"), "kg");
			selectByText(By.xpath("//*[@name='shpVolumeUnit']"), "cbm");
		}
//		enterKeys(txt_producttype, Product);
		minWait();
		// Set Dimension
		click(Icon_SetDimention);
		minWait();
		enterKeys(txt_SetPcse, pcs);
		enterKeys(txt_SetWt, wt);
		enterKeys(txt_SetLenght, "10");
		enterKeys(txt_SetWidth, "10");
		enterKeys(txt_SetHeight, "10" + Keys.TAB);
		enterKeys(txt_SetHeight, Keys.TAB);
		minWait();
		click(Popup_btnOK);
		minWait();
		handleAlert("Accept", "LTE001");
		minWait();
		waitForFrameAndSwitch(screenFrame);
		String CalcVol = driver.findElement(txt_shipmentvolume).getAttribute("value");
		PropertyHandler.setPropValue(dataFilePath, "volume", CalcVol);
		click(By.xpath("//button[@name='btnShipmentCont']"));
		minWait();

		// --------------------Flight Details------------------------
		// click(link_BookingDetails);
		enterKeys(txt_CarrierCode, carriercode);
		enterKeys(txt_flightnumber, fltNo);
		enterKeys(txt_flightdate, fltDt + Keys.TAB);
		if(!intermediate.equalsIgnoreCase("")){
		enterKeys(txt_FlightSegment, origin+intermediate);
		}else{
			enterKeys(txt_FlightSegment, origin+dest);
		}
		enterKeys(txt_FltPcs, pcs);
		minWait();
		enterKeys(txt_FltWt, wt);
		minWait();
		String todaysDt = driver.findElement(txt_flightdate).getAttribute("value");
		PropertyHandler.setPropValue(dataFilePath, "flightDt", todaysDt);
		enterKeys(txt_FltVolume, CalcVol);
		minWait();
//		click(By.xpath("//div[@id='flightdetails']//i[@title='Add']"));
		InitialSetup.test.log(LogStatus.INFO, "Successfully entered flight details for O-D: " + origindestination
				+ " and FLight No.- " + carrierwithFlightno1);

		// 2nd flight details
		if(!intermediate.equals("")){
		click(By.xpath("//div[@id='flightdetails']//i[@title='Add']"));
		enterKeys(By.xpath("(//*[@name='flightCarrierCode'])[2]"), carriercode1);
		enterKeys(By.xpath("(//*[@name='flightNumber'])[2]"), fltNo1);
		enterKeys(By.xpath("(//*[@name='flightDate'])[2]"), fltDt1);
		enterKeys(By.xpath("(//*[@name='flightSegment'])[2]"), intermediate+dest);
		enterKeys(By.xpath("(//*[@name='bookedPieces'])[2]"), pcs);
		enterKeys(By.xpath("(//*[@name='bookedWeight'])[2]"), wt);
		enterKeys(By.xpath("(//*[@name='bookedVolume'])[2]"), CalcVol);
		click(By.xpath("(//div[@id='flightdetails']//i[@title='Add'])[last()]"));
		
		InitialSetup.test.log(LogStatus.INFO, "Successfully entered flight details for O-D: " + intermediate+dest
				+ " and FLight No.- " + carrierwithFlightno1);
		}
		click(By.xpath("//button[@name='btnFlightDtlsCont']"));
		minWait();

		// click(link_ChargeDetails)
		click(btn_Calculte);
		minWait();
		/*handleAlert("Accept", "LTE001");
		minWait();
		waitForFrameAndSwitch(screenFrame);
		minWait();*/
		maxWait();
		if (verifyElementPresent(select_ModeofPayment)) {
			selectByText(select_ModeofPayment, "CHECK");
		}
		/*
		 * try { selectByText(select_ModeofPayment, ModeofPayment); } catch
		 * (Exception e) {}
		 */
		// }
		/*
		 * else { selectByText(select_ModeofPayment, "CASH"); }
		 */
//		minWait();
		click(By.xpath("//button[@name='btnChargeDtlsCont']"));
		minWait();

		click(btn_Save);
		maxWait();

		// pop-up: The shipper does not have a valid certificate. Do you want to
		// continue?
		driver.switchTo().defaultContent();
		if (verifyElementPresent(info_msg)) {
			InitialSetup.test.log(LogStatus.INFO,
					"Pop-up message after saving: " + driver.findElement(info_msg).getText());
			click(btn_genericYes);
		}

		minWait();
		waitForFrameAndSwitch(screenFrame);

		// embargo
		if (verifyElementPresent(By.xpath("//div[@id='EmbargoDiv']//button[text()='Continue']"))) {
			click(By.xpath("//div[@id='EmbargoDiv']//button[text()='Continue']"));
		}
		maxWait();
		
		String awbNo = getText_JS(By.xpath("//a[contains(@class,'awb-number')]"));
		int rowNoint = Integer.parseInt(index);
		writeDatatoExcelCell(path, rowNoint, awbNo);
		InitialSetup.test.log(LogStatus.INFO, "Successfully booked: "+awbNo);
		
		/*click(By.xpath("//*[@id='view_header_chargeDtls']"));
		minWait();
		String totalPrice = driver.findElement(By.xpath("//span[@class='mar-t-xs']")).getText();
		PropertyHandler.setPropValue(dataFilePath, "totalChargeDisplayed", totalPrice);*/
		if (executionReqd) {
			maxWait();
			click(btn_AwbVerified);
			InitialSetup.test.log(LogStatus.PASS, "Successfully clicked on AWB verification checkbox");
			click(btn_Save);
			maxWait();
			if (verifyElementPresent(info_msg)) {
				InitialSetup.test.log(LogStatus.INFO,
						"Pop-up message after Save Button Click: " + driver.findElement(info_msg).getText());
				click(btn_genericYes);
			}
			// embargo
			if (verifyElementPresent(By.xpath("//div[@id='EmbargoDiv']//button[text()='Continue']"))) {
				click(By.xpath("//div[@id='EmbargoDiv']//button[text()='Continue']"));
			}
			minWait();
		}
		/*click(By.xpath("//div[contains(text(),'Acceptance Details')]/parent::div/span"));
		// click(By.xpath("(//div[contains(text(),'Acceptance
		// Details')])[last()]"));

		// click(By.xpath("(//*[@class='ui-accordion-header-icon ui-icon
		// ui-icon-triangle-1-e'])[8]"));
		enterKeys(txt_pieces, pcs);
		enterKeys(txt_weight, wt);
		minWait();
		enterKeys(txt_volume, vol);
		minWait();

		if (UldNeeded == true)// if uld details needs to be given, then true
								// else false
		{
			UldNumber = PropertyHandler.getPropValue(dataFilePath, UldNumber);
			// enterKeys(Txt_ULD,UldNumber);
			enterKeys(By.id("uldNumer_u"), UldNumber);
			enterKeys(By.xpath("//*[contains(text(),'Location')]/following-sibling::input"), "ACP-A-1-A");
		}
		// selectByText(By.name("acpWghtUnit"), "lbs");
		// selectByText(By.name("acpVolumeUnit"), "cbf");

		click(txt_AcceptAll);
		if(uldNo!=null || !uldNo.equals("")){
			enterKeys(By.xpath("//input[@name='uldNumer']"), uldNo);
		}
		click(By.xpath("//*[@name='btnAcceptanceDtlsCont']"));
		minWait();
		// Screening
		// click(Link_Screendetails);
		selectByText(select_ScreenMethod, ScreenMethod);
		enterKeys(txt_screenPcs, pcs);
		selectByText(select_screenPassFail, ScreenResult);
		minWait();
		click(btn_Save);
		maxWait();
		if (verifyElementPresent(By.xpath("//div[@id='EmbargoDiv']//button[@name='okBtn']"))) {
			captureAndAddScreenshot();
			click(By.xpath("//div[@id='EmbargoDiv']//button[@name='okBtn']"));
		}
		maxWait();
		driver.switchTo().defaultContent();
		handleAlert("Accept", "LTE001");
		maxWait();
		driver.switchTo().frame(screenFrame);
		if (verifyElementPresent(info_msg)) {
			InitialSetup.test.log(LogStatus.INFO,
					"Pop-up message after Save Button Click: " + driver.findElement(info_msg).getText());
			click(btn_genericYes);
		}
		if (verifyElementPresent(info_msg)) {
			InitialSetup.test.log(LogStatus.INFO,
					"Pop-up message after Save Button Click: " + driver.findElement(info_msg).getText());
			click(btn_genericYes);
		}*/
		
		return this;
	}
	
	public LTE001 doPPSBookingOnlyTestdata(String carriercode, String awbno, String fltNo, String fltDt,
			String Product, String agentCode, String shipper, String consignee, String origin, String dest, String pcs,
			String wt, String vol, String Commodity, String prefix, String CustomerType, String intermediate,
			String carriercode1, String fltNo1, String fltDt1, boolean UldNeeded, String UldNumber, String ScreenMethod,
			String ScreenResult, String slacPcs, String index,String uldNo, String path, String wtUnit, boolean executionreqd) throws Exception {


		String carrierwithFlightno = carriercode + fltNo;

		String origindestination1 = intermediate + "-" + dest;
		String carrierwithFlightno1 = carriercode1 + fltNo1;

		click(btn_list);

//		maxWait();
		maxWait();
		// ------------------------------Product and Customer
		// Type------------------------
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[contains(text(),'Product and Customer')]/preceding-sibling::span"))).click();
		// click(By.xpath("//div[contains(text(),'Product and Customer')]"));
		enterKeys(txt_ProductType, Product + Keys.TAB);
		minWait();
		selectByText(select_CustomerType, CustomerType);
		InitialSetup.test.log(LogStatus.INFO, "Successfully entered Product and Customer Details");
		click(By.xpath("//button[@name='btnCustomerTypeCont']"));

		// -----------------------------Participant
		// Details-------------------------------
		// click(link_ParticipantDetail);
		enterKeys(txt_agent, agentCode + Keys.TAB);
		minWait();
		enterKeys(txt_shipperCode, shipper + Keys.TAB);
		minWait();
		enterKeys(txt_ConsigneeCode, consignee + Keys.TAB);
		minWait();
		InitialSetup.test.log(LogStatus.INFO, "Successfully entered Participant Details");
		click(By.xpath("//button[@name='btnParticipantCont']"));
		minWait();


		// ------------------------Certificate
		// Details---------------------------
		if (verifyElementPresent(By.xpath("//input[@name='driverName']"))) {
			enterKeys(By.xpath("//input[@name='driverName']"),"Test Driver");
			enterKeys(By.name("driverCompany"), "Test Company");
			selectByText(By.xpath("//select[@name='driverIDType']"), "Driving License");
			scrollToView(By.xpath("//select[@name='photoIDVerified']"));
			enterKeys(By.name("stateOrCountryIssuingID"), "US");
			selectByText(By.xpath("//select[@name='photoIDVerified']"), "Yes");
			click(By.xpath("//button[@name='btnCertificateDetailsCont']"));
		}
		scrollToView(link_BookingDetails);

		// click(link_shipmentDetails);
		enterKeys(By.xpath("//*[@name='ppsOrigin']"), origin);
		enterKeys(By.xpath("//*[@name='ppsDestination']"), dest);
	
		enterKeys(By.xpath("//*[@name='ppsShippingDate']"), fltDt + Keys.TAB);
		
		if(wtUnit.equalsIgnoreCase("lbs")){
		selectByText(By.xpath("//select[@name='ppsWeightUnit']"), "lbs");
		selectByText(By.xpath("//select[@name='ppsVolumeUnit']"), "cbf");
		}else{
			selectByText(By.xpath("//select[@name='ppsWeightUnit']"), "kg");
			selectByText(By.xpath("//select[@name='ppsVolumeUnit']"), "cbm");
		}
		// enterKeys(By.xpath(""), Product);

		selectByText(By.xpath("//*[@name='ppsCommodityCode']"), Commodity);

		minWait();
		enterKeys(By.xpath("//*[@name='ppsShpPcs']"), pcs);
		enterKeys(By.xpath("//*[@name='ppsShpWgt']"), wt);
		enterKeys(By.xpath("//*[@name='ppsShpVol']"), vol);
		// Set Dimension Not there

		/*
		 * click(Icon_SetDimention); minWait(); enterKeys(txt_SetPcse, pcs);
		 * //driver.findElement(By.xpath(
		 * "(//div[@name='dimensionsPanelTagName']//input[@name='dimensionPcs'])[1]"
		 * )).sendKeys(pcs); enterKeys(txt_SetWt, wt); enterKeys(txt_SetLenght,
		 * "10"); enterKeys(txt_SetWidth, "10"); enterKeys(txt_SetHeight,
		 * "10"+Keys.TAB); enterKeys(txt_SetHeight,Keys.TAB); minWait();
		 * //driver.findElement(By.xpath("(//input[@name='dimensionHeight'])[4]"
		 * )).click(); minWait(); click(Popup_btnOK); minWait();
		 * driver.switchTo().defaultContent(); handleAlert("Accept", "LTE001");
		 * minWait(); driver.switchTo().frame("iCargoContentFrameLTE001");
		 */

		enterKeys(By.xpath("//*[@name='ppsDimensionLength']"), "10" + Keys.TAB);
		enterKeys(By.xpath("//*[@name='ppsDimensionWidth']"), "10" + Keys.TAB);
		enterKeys(By.xpath("//*[@name='ppsDimensionHeight']"), "10" + Keys.TAB);

		String CalcVol = driver.findElement(By.xpath("//*[@name='ppsShpVol']")).getAttribute("value");
		PropertyHandler.setPropValue(dataFilePath, "volume", CalcVol);
		click(By.xpath("//button[@name='btnPPSShipmentCont']"));
		minWait();

		// click(link_BookingDetails);
		minWait();
		enterKeys(txt_CarrierCode, carriercode);
		enterKeys(txt_flightnumber, fltNo);
		enterKeys(txt_flightdate, fltDt);
		enterKeys(txt_FlightSegment, origin+dest);
		enterKeys(txt_FltPcs, pcs);
		minWait();
		enterKeys(txt_FltWt, wt);
		minWait();
		String flightDt = driver.findElement(txt_flightdate).getAttribute("value");

		PropertyHandler.setPropValue(dataFilePath, "flightDt", flightDt);
		vol = PropertyHandler.getPropValue(dataFilePath, "volume");
		enterKeys(txt_FltVolume, vol);
		click(By.xpath("//button[@name='btnFlightDtlsCont']"));
		minWait();

		// click(link_ChargeDetails);
		minWait();
		click(btn_Calculte);
		minWait();
		maxWait();
		if (verifyElementPresent(select_ModeofPayment)) {
			selectByText(select_ModeofPayment, "CHECK");
		}
		
		click(By.xpath("//button[@name='btnChargeDtlsCont']"));
		minWait();
		click(btn_Save);
		maxWait();

		// pop-up: The shipper does not have a valid certificate. Do you want to
		// continue?
		driver.switchTo().defaultContent();
		if (verifyElementPresent(info_msg)) {
			InitialSetup.test.log(LogStatus.INFO,
					"Pop-up message after saving: " + driver.findElement(info_msg).getText());
			click(btn_genericYes);
		}
		minWait();
		waitForFrameAndSwitch(screenFrame);
		// embargo
		if (verifyElementPresent(By.xpath("//div[@id='EmbargoDiv']//button[text()='Continue']"))) {
			click(By.xpath("//div[@id='EmbargoDiv']//button[text()='Continue']"));
		}
		maxWait();
		
		String awbNo = getText_JS(By.xpath("//a[contains(@class,'awb-number')]"));
		int rowNoint = Integer.parseInt(index);
		writeDatatoExcelCell(path, rowNoint, awbNo);
		InitialSetup.test.log(LogStatus.INFO, "Successfully booked: "+awbNo);
		
		/*click(By.xpath("//*[@id='view_header_chargeDtls']"));
		minWait();
		String totalPrice = driver.findElement(By.xpath("//span[@class='mar-t-xs']")).getText();
		PropertyHandler.setPropValue(dataFilePath, "totalChargeDisplayed", totalPrice);*/
		if (executionreqd) {
			maxWait();
			click(btn_AwbVerified);
			InitialSetup.test.log(LogStatus.PASS, "Successfully clicked on AWB verification checkbox");
			click(btn_Save);
			maxWait();
			driver.switchTo().defaultContent();
			if (verifyElementPresent(info_msg)) {
				InitialSetup.test.log(LogStatus.INFO,
						"Pop-up message after saving: " + driver.findElement(info_msg).getText());
				click(btn_genericYes);
			}
			waitForFrameAndSwitch(screenFrame);
			// embargo
			if (verifyElementPresent(By.xpath("//div[@id='EmbargoDiv']//button[text()='Continue']"))) {
				click(By.xpath("//div[@id='EmbargoDiv']//button[text()='Continue']"));
			}
			minWait();
		}
		/*click(By.xpath("//div[contains(text(),'Acceptance Details')]/parent::div/span"));
		// click(By.xpath("(//div[contains(text(),'Acceptance
		// Details')])[last()]"));

		// click(By.xpath("(//*[@class='ui-accordion-header-icon ui-icon
		// ui-icon-triangle-1-e'])[8]"));
		enterKeys(txt_pieces, pcs);
		enterKeys(txt_weight, wt);
		minWait();
		enterKeys(txt_volume, vol);
		minWait();

		if (UldNeeded == true)// if uld details needs to be given, then true
								// else false
		{
			UldNumber = PropertyHandler.getPropValue(dataFilePath, UldNumber);
			// enterKeys(Txt_ULD,UldNumber);
			enterKeys(By.id("uldNumer_u"), UldNumber);
			enterKeys(By.xpath("//*[contains(text(),'Location')]/following-sibling::input"), "ACP-A-1-A");
		}
		// selectByText(By.name("acpWghtUnit"), "lbs");
		// selectByText(By.name("acpVolumeUnit"), "cbf");

		click(txt_AcceptAll);
		if(uldNo!=null || !uldNo.equals("")){
			enterKeys(By.xpath("//input[@name='uldNumer']"), uldNo);
		}
		click(By.xpath("//*[@name='btnAcceptanceDtlsCont']"));
		minWait();
		// Screening
		// click(Link_Screendetails);
		selectByText(select_ScreenMethod, ScreenMethod);
		enterKeys(txt_screenPcs, pcs);
		selectByText(select_screenPassFail, ScreenResult);
		minWait();
		click(btn_Save);
		maxWait();
		if (verifyElementPresent(By.xpath("//div[@id='EmbargoDiv']//button[@name='okBtn']"))) {
			captureAndAddScreenshot();
			click(By.xpath("//div[@id='EmbargoDiv']//button[@name='okBtn']"));
		}
		maxWait();
		driver.switchTo().defaultContent();
		handleAlert("Accept", "LTE001");
		maxWait();
		driver.switchTo().frame(screenFrame);
		if (verifyElementPresent(info_msg)) {
			InitialSetup.test.log(LogStatus.INFO,
					"Pop-up message after Save Button Click: " + driver.findElement(info_msg).getText());
			click(btn_genericYes);
		}
		if (verifyElementPresent(info_msg)) {
			InitialSetup.test.log(LogStatus.INFO,
					"Pop-up message after Save Button Click: " + driver.findElement(info_msg).getText());
			click(btn_genericYes);
		}*/
		
		return this;
	}

//	Sharath
	public LTE001 doLitebookingToAcceptanceMultipleULDs(String carriercode, String awbno, String fltNo, String fltDt,
			String Product, String agentCode, String shipper, String consignee, String origin, String dest, String pcs,
			String wt, String vol, String Commodity, String prefix, String CustomerType, String intermediate,
			String carriercode1, String fltNo1, String fltDt1, boolean UldNeeded, String UldNumber, String ScreenMethod,
			String ScreenResult, String slacPcs, String index, String path, String noofULDs, String...uldNo) throws Exception {
	
		String origindestination = origin + "-" + intermediate;

//		String origindestination = origin + "-" + dest;
		String carrierwithFlightno = carriercode + fltNo;

		String origindestination1 = intermediate + "-" + dest;
		String carrierwithFlightno1 = carriercode1 + fltNo1;

		click(btn_list);

//		maxWait();
		maxWait();
		// ------------------------------Product and Customer
		// Type------------------------
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[contains(text(),'Product and Customer')]/preceding-sibling::span"))).click();
		// click(By.xpath("//div[contains(text(),'Product and Customer')]"));
		enterKeys(txt_ProductType, Product + Keys.TAB);
		minWait();
		selectByText(select_CustomerType, CustomerType);
		InitialSetup.test.log(LogStatus.INFO, "Successfully entered Product and Customer Details");
		click(By.xpath("//button[@name='btnCustomerTypeCont']"));

		// -----------------------------Participant
		// Details-------------------------------
		// click(link_ParticipantDetail);
		enterKeys(txt_agent, agentCode + Keys.TAB);
		minWait();
		enterKeys(txt_shipperCode, shipper + Keys.TAB);
		minWait();
		enterKeys(txt_ConsigneeCode, consignee + Keys.TAB);
		minWait();
		InitialSetup.test.log(LogStatus.INFO, "Successfully entered Participant Details");
		click(By.xpath("//button[@name='btnParticipantCont']"));
		minWait();

		// ------------------------Certificate
		// Details---------------------------
		if (verifyElementPresent(By.xpath("//input[@name='driverName']"))) {
			enterKeys(By.xpath("//input[@name='driverName']"),"Test Driver");
			enterKeys(By.name("driverCompany"), "Test Company");
			selectByText(By.xpath("//select[@name='driverIDType']"), "Driving License");
			scrollToView(By.xpath("//select[@name='photoIDVerified']"));
			enterKeys(By.name("stateOrCountryIssuingID"), "US");
			selectByText(By.xpath("//select[@name='photoIDVerified']"), "Yes");
			click(By.xpath("//button[@name='btnCertificateDetailsCont']"));
		}
		scrollToView(link_BookingDetails);

		// click(link_shipmentDetails);
		enterKeys(txt_Origin, origin);
		enterKeys(txt_destination, dest);
		enterKeys(By.xpath("//*[@name='shippingDate']"), fltDt + Keys.TAB);
		selectByText(By.xpath("//*[@name='sci']"), "T1");
		try{
		if(!slacPcs.equals(null) || !slacPcs.equals("")){	
			enterKeys(By.xpath("//input[@name='slacPieces']"), slacPcs);
		}}
		catch(Exception e){
			System.out.println("Slac not reqd");
		}
		if (Product.equalsIgnoreCase("PPS")) {
			selectByText(By.xpath("//*[@name='ppsCommodityCode']"), Commodity);
		} else {
			enterKeys(txt_commodityCode, Commodity + Keys.TAB);
		}
		minWait();
		enterKeys(txt_shipmentPcs, pcs);
		enterKeys(txt_shipmentwt, wt);
//		enterKeys(txt_shipmentvolume, vol);
		
	/*	selectByText(By.xpath("//*[@name='shpWeightUnit']"), "lbs");
		selectByText(By.xpath("//*[@name='shpVolumeUnit']"), "cbf");*/
//		enterKeys(txt_producttype, Product);
		minWait();
		// Set Dimension
		click(Icon_SetDimention);
		minWait();
		enterKeys(txt_SetPcse, pcs);
		enterKeys(txt_SetWt, wt);
		enterKeys(txt_SetLenght, "10");
		enterKeys(txt_SetWidth, "10");
		enterKeys(txt_SetHeight, "10" + Keys.TAB);
		enterKeys(txt_SetHeight, Keys.TAB);
		minWait();
		click(Popup_btnOK);
		minWait();
		handleAlert("Accept", "LTE001");
		minWait();
		waitForFrameAndSwitch(screenFrame);
		String CalcVol = driver.findElement(txt_shipmentvolume).getAttribute("value");
		PropertyHandler.setPropValue(dataFilePath, "volume", CalcVol);
		click(By.xpath("//button[@name='btnShipmentCont']"));
		minWait();

		// --------------------Flight Details------------------------
		// click(link_BookingDetails);
		enterKeys(txt_CarrierCode, carriercode);
		enterKeys(txt_flightnumber, fltNo);
		enterKeys(txt_flightdate, fltDt + Keys.TAB);
		if(!intermediate.equals("")){
		enterKeys(txt_FlightSegment, origin+intermediate);
		}else{
			enterKeys(txt_FlightSegment, origin+dest);
		}
		enterKeys(txt_FltPcs, pcs);
		minWait();
		enterKeys(txt_FltWt, wt);
		minWait();
		String todaysDt = driver.findElement(txt_flightdate).getAttribute("value");
		PropertyHandler.setPropValue(dataFilePath, "flightDt", todaysDt);
		enterKeys(txt_FltVolume, CalcVol);
		minWait();
//		click(By.xpath("//div[@id='flightdetails']//i[@title='Add']"));
		InitialSetup.test.log(LogStatus.INFO, "Successfully entered flight details for O-D: " + origindestination
				+ " and FLight No.- " + carrierwithFlightno1);

		// 2nd flight details
		if(!intermediate.equals("")){
		click(By.xpath("//div[@id='flightdetails']//i[@title='Add']"));
		enterKeys(By.xpath("(//*[@name='flightCarrierCode'])[2]"), carriercode1);
		enterKeys(By.xpath("(//*[@name='flightNumber'])[2]"), fltNo1);
		enterKeys(By.xpath("(//*[@name='flightDate'])[2]"), fltDt1);
		enterKeys(By.xpath("(//*[@name='flightSegment'])[2]"), intermediate+dest);
		enterKeys(By.xpath("(//*[@name='bookedPieces'])[2]"), pcs);
		enterKeys(By.xpath("(//*[@name='bookedWeight'])[2]"), wt);
		enterKeys(By.xpath("(//*[@name='bookedVolume'])[2]"), CalcVol);
		click(By.xpath("(//div[@id='flightdetails']//i[@title='Add'])[last()]"));
		
		InitialSetup.test.log(LogStatus.INFO, "Successfully entered flight details for O-D: " + intermediate+dest
				+ " and FLight No.- " + carrierwithFlightno1);
		}
		click(By.xpath("//button[@name='btnFlightDtlsCont']"));
		minWait();

		// click(link_ChargeDetails)
		click(btn_Calculte);
		minWait();
		/*handleAlert("Accept", "LTE001");
		minWait();
		waitForFrameAndSwitch(screenFrame);
		minWait();*/
		maxWait();
		if (verifyElementPresent(select_ModeofPayment)) {
			selectByText(select_ModeofPayment, "CHECK");
		}
		/*
		 * try { selectByText(select_ModeofPayment, ModeofPayment); } catch
		 * (Exception e) {}
		 */
		// }
		/*
		 * else { selectByText(select_ModeofPayment, "CASH"); }
		 */
//		minWait();
		click(By.xpath("//button[@name='btnChargeDtlsCont']"));
		minWait();

		click(btn_Save);
		maxWait();

		// pop-up: The shipper does not have a valid certificate. Do you want to
		// continue?
		driver.switchTo().defaultContent();
		if (verifyElementPresent(info_msg)) {
			InitialSetup.test.log(LogStatus.INFO,
					"Pop-up message after saving: " + driver.findElement(info_msg).getText());
			click(btn_genericYes);
		}

		minWait();
		waitForFrameAndSwitch(screenFrame);

		// embargo
		if (verifyElementPresent(By.xpath("//div[@id='EmbargoDiv']//button[text()='Continue']"))) {
			click(By.xpath("//div[@id='EmbargoDiv']//button[text()='Continue']"));
		}
		maxWait();
		
		String awbNo = getText_JS(By.xpath("//a[contains(@class,'awb-number')]"));
		int rowNoint = Integer.parseInt(index);
		writeDatatoExcelCell(path, rowNoint, awbNo);
		InitialSetup.test.log(LogStatus.INFO, "Successfully booked: "+awbNo);
		
		/*click(By.xpath("//*[@id='view_header_chargeDtls']"));
		minWait();
		String totalPrice = driver.findElement(By.xpath("//span[@class='mar-t-xs']")).getText();
		PropertyHandler.setPropValue(dataFilePath, "totalChargeDisplayed", totalPrice);*/
		maxWait();
		click(btn_AwbVerified);
		InitialSetup.test.log(LogStatus.PASS, "Successfully clicked on AWB verification checkbox");
		click(btn_Save);
		maxWait();
		if (verifyElementPresent(info_msg)) {
			InitialSetup.test.log(LogStatus.INFO,
					"Pop-up message after Save Button Click: " + driver.findElement(info_msg).getText());
			click(btn_genericYes);
		}
		// embargo
		if (verifyElementPresent(By.xpath("//div[@id='EmbargoDiv']//button[text()='Continue']"))) {
			click(By.xpath("//div[@id='EmbargoDiv']//button[text()='Continue']"));
		}
		minWait();
		click(By.xpath("//div[contains(text(),'Acceptance Details')]/parent::div/span"));
		// click(By.xpath("(//div[contains(text(),'Acceptance
		// Details')])[last()]"));

		// click(By.xpath("(//*[@class='ui-accordion-header-icon ui-icon
		// ui-icon-triangle-1-e'])[8]"));
		/*enterKeys(txt_pieces, pcs);
		enterKeys(txt_weight, wt);
		minWait();
		enterKeys(txt_volume, vol);*/
		minWait();

		if (UldNeeded == true)// if uld details needs to be given, then true
								// else false
		{
			UldNumber = PropertyHandler.getPropValue(dataFilePath, UldNumber);
			// enterKeys(Txt_ULD,UldNumber);
			enterKeys(By.id("uldNumer_u"), UldNumber);
			enterKeys(By.xpath("//*[contains(text(),'Location')]/following-sibling::input"), "ACP-A-1-A");
		}
		// selectByText(By.name("acpWghtUnit"), "lbs");
		// selectByText(By.name("acpVolumeUnit"), "cbf");

		int a = Integer.parseInt(noofULDs);
		if(a==0){
		click(txt_AcceptAll);
		} else if (a>0){
			for (int i = 0; i < a; i++) {
				int pc = Integer.parseInt(pcs);
				enterKeys(getWebElements(txt_pieces).get(i), Integer.toString(pc/a)+Keys.TAB);
//				enterKeys(getWebElements(txt_weight).get(i), wt);
				enterKeys(getWebElements(By.id("uldNumer_u")).get(i), uldNo[i]);
				click(getWebElements(By.xpath("//div[@id='acceptanceDetails']//i[@title='Add']")).get(i));
			}
		}

		click(By.xpath("//*[@name='btnAcceptanceDtlsCont']"));
		minWait();
		// Screening
		// click(Link_Screendetails);
		selectByText(select_ScreenMethod, ScreenMethod);
		enterKeys(txt_screenPcs, pcs);
		selectByText(select_screenPassFail, ScreenResult);
		minWait();
		click(btn_Save);
		maxWait();
		if (verifyElementPresent(By.xpath("//div[@id='EmbargoDiv']//button[@name='okBtn']"))) {
			captureAndAddScreenshot();
			click(By.xpath("//div[@id='EmbargoDiv']//button[@name='okBtn']"));
		}
		maxWait();
		driver.switchTo().defaultContent();
		handleAlert("Accept", "LTE001");
		maxWait();
		driver.switchTo().frame(screenFrame);
		if (verifyElementPresent(info_msg)) {
			InitialSetup.test.log(LogStatus.INFO,
					"Pop-up message after Save Button Click: " + driver.findElement(info_msg).getText());
			click(btn_genericYes);
		}
		if (verifyElementPresent(info_msg)) {
			InitialSetup.test.log(LogStatus.INFO,
					"Pop-up message after Save Button Click: " + driver.findElement(info_msg).getText());
			click(btn_genericYes);
		}
		
		return this;
	}

	
	
	
	public LTE001 DGchecksheet(String UNIDNo) throws Exception {
		
		UNIDNo = PropertyHandler.getPropValue(dataFilePath, UNIDNo);
		minWait();
		click(By.xpath("//a[@class='d-inline-flex']/span[@class='align-middle']"));
		maxWait();
		waitForFrameAndSwitch("popupContainerFrame");
		minWait();
		switch(UNIDNo)
			{
				case "1057":
							minWait();
							selectByText(By.xpath("//input[contains(@value,'Are there at least two candy-striped copies')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'Complete name and address of shipper and consignee')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'Not required for Limited Quantity, Dry Ice, Battery powered Equipment')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'declaration include an Air Transport Certification')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'Airbill/Air Waybill number of transporting carrier')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'Number of pages shown')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'Cargo Aircraft only box deleted')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'Name of airport or city of origin and destination')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'RAM box deleted')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'Name of Signatory/Date/Signature complete')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'UN or ID prefix and number')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'Proper shipping name')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'Class/Division Number')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'Subsidiary risk, if applicable')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'Packing group, if applicable')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'Number and type of packages')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'Net or gross weight or quantity within acceptable limits')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'Overpack Used or All Packed in One, if applicable')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'All items are compatible according to Table')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'For All Packed in One, calculation of Q')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'more than one overpack is used, identification marks')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'Packing instruction number?')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'When Limited Quantity provisions are used')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'all applicable state and operator variations for transport to destination')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'Listed in sequential order, if applicable')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'Approval Certificates or Special Provisions listed in the authorizations')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'the same person who signed the declaration')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'Dangerous Goods as per attached Shippers Declaration')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'Packages in good condition')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'the correct primary risk label on each package')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'correct subsidiary risk label on each package')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'Orientation labels')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'Cryogenic liquid, or Keep Away From Heat labels, or Environmentally Hazardous')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'Name and address of Shipper and Consignee')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'UN specification packaging is required')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'UN/ID prefix and number, Proper Shipping Name, RQ')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'of all classes (except ID 8000) the net quantity marked')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'overpack is presented and the markings and labels on the inside packages are not visible')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'LIMITED QUANTITY provisions are used, is the package marked with the Limited Quantity')]/../../following-sibling::div[1]//select"),"Yes");
							minWait();
							click(By.xpath("//button[@name='btnSave'][text()='OK']"));
							minWait();
							break;
					
				case "3091":
							minWait();
							click(By.xpath("//span[text()='Select']/preceding-sibling::span"));
							minWait();
							check(By.xpath("(//input[@name='multiselect_CMP_Checksheet_Defaults_CaptureCheckSheet_MultiSelect2'])[1]"));
							minWait();
							click(By.xpath("(//input[@name='multiselect_CMP_Checksheet_Defaults_CaptureCheckSheet_MultiSelect2'])[1]/../../../../div/ul/li/a[@class='ui-multiselect-close']"));
							minWait();
							selectByText(By.xpath("//input[contains(@value,'Full name and address of Shipper and Consignee')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'Lithium Battery mark affixed to each package')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'Lithium Battery mark contains UN3481')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'Lithium Battery mark contains UN3091')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'Lithium Battery mark contains a valid phone')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'Full name and address of Shipper/Consignee or Freight Forwarder')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'Outer packing complies with the Acceptance - Packaging')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'When an Overpack is presented and the markings and labels on the inside packages are not visible')]/../../following-sibling::div[1]//select"),"Yes");
							minWait();
							click(By.xpath("//button[@name='btnSave'][text()='OK']"));
							minWait();
							break;
							
				case "1845":
							minWait();
							selectByText(By.xpath("//input[contains(@value,'The UN Number 1845, preceded by the prefix UN')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'The words Carbon dioxide, solid or Dry ice')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'The Class number 9')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'The number of packages of dry ice')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'The net quantity of dry ice in kilograms')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'Each package quantity in an OVERPACK')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'The number of packages containing dry ice')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'Package are free from damage and in a proper')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'The words Carbon dioxide, solid or Dry ice [7.1.5.1(a)]')]/../../following-sibling::div[1]//select"),"Yes");
							//selectByText(By.xpath("//input[contains(@value,'The words Carbon dioxide, solid or Dry ice')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'The UN Number 1845 preceded by prefix UN')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'Full name and address of the shipper and consignee')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'The net quantity of dry ice within each package')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'Class 9 label affixed')]/../../following-sibling::div[1]//select"),"Yes");
							selectByText(By.xpath("//input[contains(@value,'Irrelevant marks and labels removed')]/../../following-sibling::div[1]//select"),"Yes");
							//selectByText(By.xpath("//input[contains(@value,'Carbon dioxide')]/../../following-sibling::div[1]//select"),"Yes");
							minWait();
							click(By.xpath("//button[@name='btnSave'][text()='OK']"));
							minWait();
							break;
											
		}
		
		driver.switchTo().defaultContent();
		click(By.xpath("//button[@class='ui-button ui-corner-all ui-widget'][text()='OK']"));
		minWait();
		minWait();
		waitForFrameAndSwitch(FRAME);
		minWait();
		click(By.xpath("//button[@name='btnSave']"));
		maxWait();
		InitialSetup.test.log(LogStatus.PASS,"Checksheet is filled");
		
		return this;
	}
	
	/**
	 * @author A-8452 Faizan
	 * Description: For performing Booking only for Two legs
	 * @param carriercode
	 * @param awbno
	 * @param fltNo
	 * @param fltDt
	 * @param Product
	 * @param agentCode
	 * @param shipper
	 * @param consignee
	 * @param origin
	 * @param dest
	 * @param pcs
	 * @param wt
	 * @param vol
	 * @param Commodity
	 * @param prefix
	 * @param CustomerType
	 * @param intermediate
	 * @param carriercode1
	 * @param fltNo1
	 * @param fltDt1
	 * @return
	 */
	public LTE001 doLTEOperationsFUllforTwoLegs(String carriercode,
			String awbno, String fltNo, String fltDt, String Product,
			String agentCode, String shipper, String consignee, String origin,
			String dest, String pcs, String wt, String vol, String Commodity,
			String prefix, String CustomerType,
			String intermediate,String carriercode1,String fltNo1,String fltDt1, 
			String UldNumber,Boolean UldNeeded,String ScreenMethod,String ScreenResult)
	{

		minWait();
		//prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		//awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		Product = PropertyHandler.getPropValue(dataFilePath, Product);
		agentCode = PropertyHandler.getPropValue(dataFilePath, agentCode);
		shipper = PropertyHandler.getPropValue(dataFilePath, shipper);
		consignee = PropertyHandler.getPropValue(dataFilePath, consignee);
		origin = PropertyHandler.getPropValue(dataFilePath, origin);
		dest = PropertyHandler.getPropValue(dataFilePath, dest);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		vol = PropertyHandler.getPropValue(dataFilePath, vol);
		Commodity = PropertyHandler.getPropValue(dataFilePath, Commodity);
		carriercode=PropertyHandler.getPropValue(dataFilePath, carriercode);
		CustomerType=PropertyHandler.getPropValue(dataFilePath, CustomerType);
		
		 ScreenMethod=PropertyHandler.getPropValue(dataFilePath, ScreenMethod);
		 ScreenResult=PropertyHandler.getPropValue(dataFilePath, ScreenResult);

		//2nd flight
		carriercode1=PropertyHandler.getPropValue(dataFilePath, carriercode1);
		intermediate = PropertyHandler.getPropValue(dataFilePath, intermediate);
		fltNo1 = PropertyHandler.getPropValue(dataFilePath, fltNo1);
		fltDt1 = PropertyHandler.getPropValue(dataFilePath, fltDt1);

		String origindestination = origin + "-" + intermediate;
		String carrierwithFlightno = carriercode + fltNo;
		PropertyHandler.setPropValue(dataFilePath, "carrierwithFlightno",
				carrierwithFlightno);

		String origindestination1=intermediate +"-"+dest; 
		String carrierwithFlightno1 = carriercode1 + fltNo1;
		PropertyHandler.setPropValue(dataFilePath, "carrierwithFlightno1",
				carrierwithFlightno1);

		//listAWB(prefix, awbno);
		//enterKeys(txt_carrierCode, prefix);
		//enterKeys(txt_awbNo, awbno);
		click(btn_list);
		InitialSetup.test.log(LogStatus.INFO,
				"Successfully clicked on List");

		maxWait();
		maxWait();
		if(!verifyElementVisible(txt_ProductType))
		{
			click(By.xpath("(//span[@class='ui-accordion-header-icon ui-icon ui-icon-triangle-1-e'])[1]"));
			minWait();	
		}
		//------------------------------Product and Customer Type------------------------
		enterKeys(txt_ProductType, Product + Keys.TAB);
		maxWait();
		selectByText(select_CustomerType, CustomerType);
		InitialSetup.test.log(LogStatus.INFO,
				"Successfully entered Product and Customer Details");
		click(By.xpath("//button[@name='btnCustomerTypeCont']"));

		//-----------------------------Participant Details-------------------------------
		//click(link_ParticipantDetail);
		enterKeys(txt_agent, agentCode+Keys.TAB);
		enterKeys(txt_shipperCode, shipper+Keys.TAB);
		enterKeys(txt_ConsigneeCode, consignee+Keys.TAB);
		minWait();
		InitialSetup.test.log(LogStatus.INFO,
				"Successfully entered Participant Details");
		click(By.xpath("//button[@name='btnParticipantCont']"));
		minWait();

		// ------------------------Certificate
				// Details---------------------------
				if (verifyElementPresent(By.xpath("//*[@name='driverIDType']"))) {
					selectByText(By.xpath("//*[@name='driverIDType']"), "Driving License"); // Driving
																							// License
																							// in
																							// STAG
					scrollToView(By.name("photoIDVerified"));
					enterKeys(By.xpath("//*[@name='stateOrCountryIssuingID']"), "US");
					enterKeys(By.xpath("//*[@name='driverName']"), "Test");
					enterKeys(By.xpath("//*[@name='driverCompany']"), "IBSAT");
					// click(By.xpath("//*[@name='photoIDVerified']"));
					selectByText(By.name("photoIDVerified"), "Yes"); // Added Code on
																		// 22nd Aug

					click(By.xpath("//button[@name='btnCertificateDetailsCont']"));
				}
		
		scrollToView(link_BookingDetails);

		//---------------------------Shipment Details-------------------------------------
		//click(link_shipmentDetails);
		enterKeys(txt_Origin, origin);
		enterKeys(txt_destination, dest);
		enterKeys(txt_shipmentPcs, pcs);
		enterKeys(txt_shipmentwt, wt);
		enterKeys(txt_shipmentvolume, vol);
		enterKeys(By.xpath("//*[@name='shippingDate']"), fltDt+Keys.TAB);
		selectByText(By.xpath("//*[@name='shpWeightUnit']"), "lbs");
		selectByText(By.xpath("//*[@name='shpVolumeUnit']"), "cbf");
		enterKeys(txt_producttype, Product);
		selectByText(By.xpath("//*[@name='sci']"), "T1");
		enterKeys(txt_commodityCode, Commodity);
		minWait();
		// Set Dimension
		click(Icon_SetDimention);
		minWait();		
		enterKeys(txt_SetPcse, pcs);
		enterKeys(txt_SetWt, wt);
		enterKeys(txt_SetLenght, "10");
		enterKeys(txt_SetWidth, "10");
		enterKeys(txt_SetHeight, "10"+Keys.TAB+Keys.TAB);
		minWait();
		minWait();
		click(Popup_btnOK);
		minWait();
		driver.switchTo().defaultContent();
		handleAlert("Accept", "LTE001");
		minWait();
		driver.switchTo().frame("iCargoContentFrameLTE001");
		String CalcVol=driver.findElement(txt_shipmentvolume).getAttribute("value");
		PropertyHandler.setPropValue(dataFilePath, "volume",CalcVol );
		InitialSetup.test.log(LogStatus.INFO,
				"Successfully entered Shipment Details");
		click(By.xpath("//button[@name='btnShipmentCont']"));

		//--------------------Flight Details------------------------
		//click(link_BookingDetails);
		enterKeys(txt_CarrierCode, carriercode);
		enterKeys(txt_flightnumber, fltNo);
		enterKeys(txt_flightdate, fltDt1+Keys.TAB);
		String FlightDate1=driver.findElement(txt_flightdate).getAttribute("value");
		enterKeys(txt_flightdate, fltDt+Keys.TAB);
		enterKeys(txt_FlightSegment, origindestination);enterKeys(txt_FltPcs, pcs);
		minWait();
		enterKeys(txt_FltWt, wt);
		minWait();
		String todaysDt=driver.findElement(txt_flightdate).getAttribute("value");

		PropertyHandler.setPropValue(dataFilePath, "flightDt", todaysDt);
		enterKeys(txt_FltVolume, CalcVol);
		minWait();
		click(By.xpath("//div[@id='flightdetails']//i[@title='Add']"));
		InitialSetup.test.log(LogStatus.INFO,
				"Successfully entered flight details for O-D: "+origindestination+" and FLight No.- "+carrierwithFlightno1);

		//2nd flight details
		enterKeys(By.xpath("(//*[@name='flightCarrierCode'])[2]"),carriercode1);
		enterKeys(By.xpath("(//*[@name='flightNumber'])[2]"), fltNo1);
		//fltDt1=PropertyHandler.getPropValue(dataFilePath, fltDt1);
		enterKeys(By.xpath("(//*[@name='flightDate'])[2]"), FlightDate1);//full date required
		enterKeys(By.xpath("(//*[@name='flightSegment'])[2]"), origindestination1);
		enterKeys(By.xpath("(//*[@name='bookedPieces'])[2]"), pcs);
		enterKeys(By.xpath("(//*[@name='bookedWeight'])[2]"), wt);
		enterKeys(By.xpath("(//*[@name='bookedVolume'])[2]"), CalcVol);
		InitialSetup.test.log(LogStatus.INFO,
				"Successfully entered flight details for O-D: "+origindestination1+" and FLight No.- "+carrierwithFlightno1);

		click(By.xpath("//button[@name='btnFlightDtlsCont']"));
		minWait();

		//click(link_ChargeDetails)
		click(btn_Calculte);
		minWait();
		driver.switchTo().defaultContent();
		handleAlert("Accept", "LTE001");
		minWait();
		driver.switchTo().frame(screenFrame);
		maxWait();
		minWait();
		try {
			selectByText(select_ModeofPayment, "CHECK");
		} catch (Exception e) {}

		click(By.xpath("//button[@name='btnChargeDtlsCont']"));
		minWait();

		click(btn_Save);
		maxWait();

		//pop-up: The shipper does not have a valid certificate. Do you want to continue?
		driver.switchTo().defaultContent();
		if (verifyElementPresent(info_msg))
		{
			InitialSetup.test.log(LogStatus.INFO, "Pop-up message after saving: "+
					driver.findElement(info_msg).getText());
			click(btn_genericYes);
		}

		minWait();
		waitForFrameAndSwitch(screenFrame);

		handleEmbargoPopUp();
		//embargo
		if(verifyElementPresent(By.xpath("(//button[@id='okBtn'])[2]")))
		{
			click(By.xpath("(//button[@id='okBtn'])[2]"));
		}

		
			//same pop-up
			driver.switchTo().defaultContent();
			minWait();
			//waitForFrameAndSwitch(screenFrame);
			handleAlert("Accept", "LTE001");
			minWait();
			driver.switchTo().frame(screenFrame);
		minWait();

		//Capture booking status

		String BookingStatus =driver.findElement(By.xpath("(//*[@id='overviewBar']/div/div)[2]/div")).getText();
		PropertyHandler.setPropValue(dataFilePath, "LTEBookingStatus", BookingStatus);
		
		minWait();
		maxWait();
		String AWB =driver.findElement(By.xpath("(//*[@id='overviewBar']/div/div)[1]/div")).getText();
		String awb[]= AWB.split("-");
		PropertyHandler.setPropValue(dataFilePath, prefix, awb[0]);
		PropertyHandler.setPropValue(dataFilePath, awbno, awb[1]);

		if(BookingStatus.equalsIgnoreCase("Confirmed")||BookingStatus.equalsIgnoreCase("Queued"))
		{
			InitialSetup.test.log(LogStatus.PASS, "Booking done with Status: "+BookingStatus);
			captureAndAddScreenshot();
		}
		else
		{
			InitialSetup.test.log(LogStatus.FAIL, "Booking status is not confirmed or Queued. Status"
					+ "displayed is: "+BookingStatus);
			Assert.fail("Booking status is not confirmed or Queued. Status"
					+ "displayed is: ");
		}
		
		doCapture(false, prefix, awbno, "ModeofPayment");
		doAcceptanceTestDataCreation(pcs, wt,CalcVol, UldNumber, UldNeeded, ScreenMethod, ScreenResult);
		return this;
	}
	
	/**
	 * @author A-8452 Faizan
	 */
	public LTE001 doCapture(boolean ListingNeeded, String prefix, String awbno, String ModeofPayment)
	{
		minWait();
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		ModeofPayment=PropertyHandler.getPropValue(dataFilePath, ModeofPayment);

		if(ListingNeeded == true){
			listAWB(prefix, awbno);
			minWait();}

		//click(link_ChargeDetails);
		//click(By.xpath("//*[@id='ui-id-22']"));
		maxWait();
		click(btn_AwbVerified);
		InitialSetup.test.log(LogStatus.PASS,
				"Successfully clicked on AWB verification checkbox");
		click(btn_Save);
		maxWait();

		if (verifyElementPresent(info_msg))
		{
			InitialSetup.test.log(LogStatus.INFO, "Pop-up message after Save Button Click: "+
					driver.findElement(info_msg).getText());
			click(btn_genericYes);
		}

		//embargo
		if(verifyElementPresent(By.xpath("(//button[@id='okBtn'])[2]")))
		{
			click(By.xpath("(//button[@id='okBtn'])[2]"));
		}
		minWait();

		String CaptureStatus =driver.findElement(By.xpath("(//*[@id='overviewBar']/div/div)[3]/div")).getText();
		PropertyHandler.setPropValue(dataFilePath, "CaptureStatus", CaptureStatus);

		if(CaptureStatus.equalsIgnoreCase("Executed"))
		{
			InitialSetup.test.log(LogStatus.PASS, "Successfully Executed AWB. AWB Capture Status: "+CaptureStatus);
			captureAndAddScreenshot();
		}
		else
		{
			InitialSetup.test.log(LogStatus.FAIL, "Could not execute AWB. Data Capture Status: "+CaptureStatus);
			Assert.fail("Cannot Execute AWB");
		}
		return this;
	}


	/**
	 * @author A-8452 Faizan Description: To perform acceptance operation in
	 *         LTE001
	 * @param pcs
	 * @param wt
	 * @param vol
	 * @param ModeofPayment
	 * @param UldNumber
	 * @param UldNeeded
	 * @return
	 */
	public LTE001 doAcceptanceTestDataCreation(String pcs, String wt, String vol, String UldNumber, boolean UldNeeded,
			String ScreenMethod, String ScreenResult) {
		minWait();
	
		maxWait();
		click(By.xpath("//div[contains(text(),'Acceptance Details')]/parent::div/span"));
		scrollToView(txt_volume);
		enterKeys(txt_pieces, pcs);
		enterKeys(txt_weight, wt);
		minWait();
		enterKeys(txt_volume, vol);
		minWait();

		if (UldNeeded == true)// if uld details needs to be given, then true
								// else false
		{
			UldNumber = PropertyHandler.getPropValue(dataFilePath, UldNumber);
			enterKeys(By.id("uldNumer_u"), UldNumber);
			enterKeys(By.xpath("//*[contains(text(),'Location')]/following-sibling::input"), "ACP-A-1-A");
		}
		// selectByText(By.name("acpWghtUnit"), "lbs");
		// selectByText(By.name("acpVolumeUnit"), "cbf");

		click(txt_AcceptAll);
		click(By.xpath("//*[@name='btnAcceptanceDtlsCont']"));
		minWait();
		// Screening
		// click(Link_Screendetails);
		selectByText(select_ScreenMethod, ScreenMethod);
		enterKeys(txt_screenPcs, pcs);
		selectByText(select_screenPassFail, ScreenResult);
		minWait();
		click(btn_Save);
		maxWait();
		if (verifyElementPresent(By.xpath("//div[@id='EmbargoDiv']//button[@name='okBtn']"))) {
			captureAndAddScreenshot();
			click(By.xpath("//div[@id='EmbargoDiv']//button[@name='okBtn']"));
		}
		maxWait();
		driver.switchTo().defaultContent();
		handleAlert("Accept", "LTE001");
		maxWait();
		driver.switchTo().frame(screenFrame);
		if (verifyElementPresent(info_msg)) {
			InitialSetup.test.log(LogStatus.INFO,
					"Pop-up message after Save Button Click: " + driver.findElement(info_msg).getText());
			click(btn_genericYes);
		}
		if (verifyElementPresent(info_msg)) {
			InitialSetup.test.log(LogStatus.INFO,
					"Pop-up message after Save Button Click: " + driver.findElement(info_msg).getText());
			click(btn_genericYes);
		}
		String AcceptanceStatus = driver.findElement(By.xpath("(//*[@id='overviewBar']/div/div)[4]/div")).getText();
		PropertyHandler.setPropValue(dataFilePath, "AcceptanceStatus", AcceptanceStatus);
		if (AcceptanceStatus.equalsIgnoreCase("Finalised")) {
			InitialSetup.test.log(LogStatus.PASS,
					"Successfully Accepted Goods. Acceptance Status: " + AcceptanceStatus);
			captureAndAddScreenshot();
		} else {
			InitialSetup.test.log(LogStatus.FAIL, "Could not Accept Goods. Acceptance Status: " + AcceptanceStatus);
			Assert.fail("Could not Accept Goods");
		}

		return this;
	}
}