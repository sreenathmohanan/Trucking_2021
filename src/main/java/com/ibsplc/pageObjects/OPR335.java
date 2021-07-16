package com.ibsplc.pageObjects;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.common.enums.StockType;
import com.ibsplc.generic.InitialSetup;
import com.ibsplc.utils.BizUtility;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;
import com.relevantcodes.extentreports.LogStatus;

public class OPR335 extends BasePage {

	private static String objFilepath = PropertyHandler.getPropValue(
			"resources\\EnvSetup.properties", "OPR_FLT.properties");
	private static String genObjPath = PropertyHandler.getPropValue(
			"resources\\EnvSetup.properties", "Generic.properties");
	private static String screenFrame,FRAME = "iCargoContentFrameOPR335";
	private static String subFRAME = "if11";
	private String dataFilePath = PropertyHandler.getPropValue(
			"resources\\EnvSetup.properties", "testDataDirectory");
	private WebDriver driver;
	private String dataFileName = "";

	private By txt_awbPre, txt_awbNo, div_looseAcc, div_ULDAcc, txt_loose_pcs,btn_popOK,
	Icon_UldAcceptance,chckbx_securitydataRetrvd,
			Security_Screening,Shipment_Details,Shipment_EditButton,txt_Shipmnt,txt_loose_wt, loose_location, btn_list,
			chkbox_allPartsRcvd, btn_loose_add, btn_save, btn_close, btn_clear,
			yesBtn, info_finalized, info_looseTotal, msg_popup, txt_uld_pcs,
			txt_uld_wt, txt_uld_vol, txt_uld_location, txt_uldNum, btn_uld_add,
			info_uldTotal, div_awbDtls, txt_loose_vol, info_errorMsg, info_rcs,
			btn_print, icon_edit, chkbox_transshipment, txt_origin,
			txt_destination, txt_shpmntdescription, txt_mastrStatedPieces,
			txt_mastrStatedWt, txt_scc, icon_cross, txt_inboundCarrier,
			txt_inboundFlt, txt_inboundFltDt, btn_hawbAdd, txt_hawbNum,
			txt_stdPcs, txt_stdWt, hawb_btn_add, hawb_btn_close, tbl_hawbAdded,
			hawb_dropArrow, hawb_txt_HAWB, hawb_txt_pcs, hawb_txt_wt, btn_yes,
			noBtn, okBtn,
			dropdown_houses,
			link_checksheet,
			dropdown_yesOrNo,
			chksht_btn_save,
			chksht_btn_close,
			btn_shipperRtrn,
			info_awbDetails,
			captureChecksheet_txt_freeText,
			frame_popupContainerFrame,
			// a-8260
			msg_rsn_nt_rfc, info_genericMsg, txt_pcs, txt_wt, tab_secScrDet,
			tab_expand, tab_shipmnt, chk_secRev, btnOk, btnSave, selResult,
			selMethd, msg_warn, lbl_scc, btn_Add, tab_secDet, chk_secsttsgvn,
			chk_Sec_Revd, tab_collapse, lbl_scr_svd, msg_acc_finl,
			info_Acceptance_label,
			btn_RecoEmbargoClose, tbl_RecoPopup,
			btn_editAccPcs, lbl_totAccPcs, lbl_actualAccPcs, lbl_totalLoosePcs,
			lbl_totalLooseWt, lbl_totalLooseVol, lbl_totalULDPcs,
			lbl_totalULDWt, lbl_totalULDVol;

	private By lbl_scrMethds, txt_scr_name, txt_date, lbl_agent_id,
			lbl_expirydt, txt_remrks, tab_agents_det, div_directBuildup,
			txt_directBuildup_fltNum, txt_directBuildup_fltDt,
			txt_directBuildup_fltPou, txt_acceptancPcs, txt_acceptanceLocatn, 
			txt_acceptanceULD, btn_acceptanceAdd, 
			sel_screenMethod,txt_statedpcs,txt_statedwt,sel_result,btn_btnadd,txt_frmDate,btn_newSavebtn, btn_looseAdd;
	
	

	private By txt_houseAwb;
	private By txt_housePcs;
	private By txt_houseWt;
	private By btn_houseADD;

	public OPR335(WebDriver driver, String dataFileName) {
		super(driver);
		this.driver = driver;
		initElements();
		this.dataFilePath = this.dataFilePath + dataFileName;
		this.dataFileName = dataFileName;
	}

	/**
	 * Method to initialize page objects 19/01/2018
	 * 
	 * @author a-7868 Krishna
	 */
	private void initElements() {

		btn_RecoEmbargoClose = MiscUtility.getWebElement(objFilepath,
				"OPR026_btn_RecoEmbargoClose");
		tbl_RecoPopup = MiscUtility.getWebElement(objFilepath,
				"OPR026_tbl_RecoPopup");
		txt_awbPre = MiscUtility
				.getWebElement(objFilepath, "OPR335_txt_awbPre");
		txt_awbNo = MiscUtility.getWebElement(objFilepath, "OPR335_txt_awbNo");
		btn_list = MiscUtility.getWebElement(objFilepath, "OPR335_btn_list");
		Icon_UldAcceptance=MiscUtility.getWebElement(objFilepath, "OPR335_Icon_UldAcceptance");
		
		chckbx_securitydataRetrvd = MiscUtility.getWebElement(objFilepath, "OPR335_chckbx_securitydataRetrvd");
		btn_popOK = MiscUtility.getWebElement(objFilepath, "OPR335_btn_PopupOK");
		Security_Screening = MiscUtility.getWebElement(objFilepath, "OPR335_Security_Screening");
		Shipment_Details = MiscUtility.getWebElement(objFilepath, "OPR335_Shipment_Details");
		Shipment_EditButton = MiscUtility.getWebElement(objFilepath, "OPR335_Shipment_EditButton");
		txt_Shipmnt = MiscUtility.getWebElement(objFilepath, "OPR335_txt_Shipmnt");
		btn_close = MiscUtility.getWebElement(objFilepath, "OPR335_btn_close");
		btn_clear = MiscUtility.getWebElement(objFilepath, "OPR335_btn_clear");
		info_awbDetails = MiscUtility.getWebElement(objFilepath,
				"OPR335_info_awbDetails");
		icon_cross = MiscUtility
				.getWebElement(objFilepath, "OPR335_icon_cross");
		div_looseAcc = MiscUtility.getWebElement(objFilepath,
				"OPR335_div_looseAcc");
		div_ULDAcc = MiscUtility
				.getWebElement(objFilepath, "OPR335_div_ULDAcc");
		div_awbDtls = MiscUtility.getWebElement(objFilepath,
				"OPR335_div_awbDtls");
		txt_loose_pcs = MiscUtility.getWebElement(objFilepath,
				"OPR335_txt_loose_pcs");
		txt_loose_wt = MiscUtility.getWebElement(objFilepath,
				"OPR335_txt_loose_wt");
		txt_loose_vol = MiscUtility.getWebElement(objFilepath,
				"OPR335_txt_loose_vol");
		loose_location = MiscUtility.getWebElement(objFilepath,
				"OPR335_txt_loose_location");
		btn_loose_add = MiscUtility.getWebElement(objFilepath,
				"OPR335_btn_loose_add");
		chkbox_allPartsRcvd = MiscUtility.getWebElement(objFilepath,
				"OPR335_chkbox_allPartsRcvd");
		btn_save = MiscUtility.getWebElement(objFilepath, "OPR335_btn_save");
		btn_print = MiscUtility.getWebElement(objFilepath, "OPR335_btn_print");
		info_finalized = MiscUtility.getWebElement(objFilepath,
				"OPR335_info_finalized");
		info_rcs = MiscUtility.getWebElement(objFilepath, "OPR335_info_rcs");
		info_looseTotal = MiscUtility.getWebElement(objFilepath,
				"OPR335_tbl_looseTotal");
		icon_edit = MiscUtility.getWebElement(objFilepath, "OPR335_icon_edit");
		chkbox_transshipment = MiscUtility.getWebElement(objFilepath,
				"OPR335_chkbox_transshipment");
		// div_ULDAcc = MiscUtility.getWebElement(objFilepath,
		// "OPR335_div_ULDAcc");
		txt_uld_pcs = MiscUtility.getWebElement(objFilepath,
				"OPR335_txt_uld_pcs");
		txt_uld_wt = MiscUtility
				.getWebElement(objFilepath, "OPR335_txt_uld_wt");
		txt_uld_vol = MiscUtility.getWebElement(objFilepath,
				"OPR335_txt_uld_vol");
		txt_uld_location = MiscUtility.getWebElement(objFilepath,
				"OPR335_txt_uld_location");
		// txt_uldNum = MiscUtility.getWebElement(objFilepath,
		// "OPR335_txt_uld_Number");
		btn_uld_add = MiscUtility.getWebElement(objFilepath,
				"OPR335_btn_uld_add");
		info_uldTotal = MiscUtility.getWebElement(objFilepath,
				"OPR335_tbl_uldTotal");
		info_errorMsg = MiscUtility.getWebElement(objFilepath,
				"OPR335_info_errorMsg");
		link_checksheet = MiscUtility.getWebElement(objFilepath,
				"OPR335_link_checksheet");
		btn_yes = MiscUtility.getWebElement(objFilepath, "OPR335_btn_yes");
		dropdown_yesOrNo = MiscUtility.getWebElement(objFilepath,
				"OPR335_chksht_dropdown_yesOrNo1");
		chksht_btn_save = MiscUtility.getWebElement(objFilepath,
				"OPR335_chksht_btn_save");
		chksht_btn_close = MiscUtility.getWebElement(objFilepath,
				"OPR335_chksht_btn_close");
		btn_shipperRtrn = MiscUtility.getWebElement(objFilepath,
				"OPR335_btn_shipperRtrn");
		txt_awbPre = MiscUtility
				.getWebElement(objFilepath, "OPR335_txt_awbPre");
		txt_awbNo = MiscUtility.getWebElement(objFilepath, "OPR335_txt_awbNo");
		btn_list = MiscUtility.getWebElement(objFilepath, "OPR335_btn_list");
		btn_close = MiscUtility.getWebElement(objFilepath, "OPR335_btn_close");
		btn_clear = MiscUtility.getWebElement(objFilepath, "OPR335_btn_clear");
		info_awbDetails = MiscUtility.getWebElement(objFilepath,
				"OPR335_info_awbDetails");
		icon_cross = MiscUtility
				.getWebElement(objFilepath, "OPR335_icon_cross");
		div_looseAcc = MiscUtility.getWebElement(objFilepath,
				"OPR335_div_looseAcc");
		div_ULDAcc = MiscUtility
				.getWebElement(objFilepath, "OPR335_div_ULDAcc");
		div_awbDtls = MiscUtility.getWebElement(objFilepath,
				"OPR335_div_awbDtls");
		txt_loose_pcs = MiscUtility.getWebElement(objFilepath,
				"OPR335_txt_loose_pcs");
		txt_loose_wt = MiscUtility.getWebElement(objFilepath,
				"OPR335_txt_loose_wt");
		txt_loose_vol = MiscUtility.getWebElement(objFilepath,
				"OPR335_txt_loose_vol");
		loose_location = MiscUtility.getWebElement(objFilepath,
				"OPR335_txt_loose_location");
		btn_loose_add = MiscUtility.getWebElement(objFilepath,
				"OPR335_btn_loose_add");
		chkbox_allPartsRcvd = MiscUtility.getWebElement(objFilepath,
				"OPR335_chkbox_allPartsRcvd");
		btn_save = MiscUtility.getWebElement(objFilepath, "OPR335_btn_save");
		btn_print = MiscUtility.getWebElement(objFilepath, "OPR335_btn_print");
		info_finalized = MiscUtility.getWebElement(objFilepath,
				"OPR335_info_finalized");
		info_rcs = MiscUtility.getWebElement(objFilepath, "OPR335_info_rcs");
		info_looseTotal = MiscUtility.getWebElement(objFilepath,
				"OPR335_tbl_looseTotal");
		icon_edit = MiscUtility.getWebElement(objFilepath, "OPR335_icon_edit");
		chkbox_transshipment = MiscUtility.getWebElement(objFilepath,
				"OPR335_chkbox_transshipment");
		div_ULDAcc = MiscUtility
				.getWebElement(objFilepath, "OPR335_div_ULDAcc");
		txt_uld_pcs = MiscUtility.getWebElement(objFilepath,
				"OPR335_txt_uld_pcs");
		txt_uld_wt = MiscUtility
				.getWebElement(objFilepath, "OPR335_txt_uld_wt");
		txt_uld_vol = MiscUtility.getWebElement(objFilepath,
				"OPR335_txt_uld_vol");
		txt_uld_location = MiscUtility.getWebElement(objFilepath,
				"OPR335_txt_uld_location");
		// txt_uldNum = MiscUtility.getWebElement(objFilepath,
		// "OPR335_txt_uld_Number");
		btn_uld_add = MiscUtility.getWebElement(objFilepath,
				"OPR335_btn_uld_add");
		info_uldTotal = MiscUtility.getWebElement(objFilepath,
				"OPR335_tbl_uldTotal");
		info_errorMsg = MiscUtility.getWebElement(objFilepath,
				"OPR335_info_errorMsg");
		link_checksheet = MiscUtility.getWebElement(objFilepath,
				"OPR335_link_checksheet");
		btn_yes = MiscUtility.getWebElement(objFilepath, "OPR335_btn_yes");
		dropdown_yesOrNo = MiscUtility.getWebElement(objFilepath,
				"OPR335_chksht_dropdown_yesOrNo1");
		chksht_btn_save = MiscUtility.getWebElement(objFilepath,
				"OPR335_chksht_btn_save");
		chksht_btn_close = MiscUtility.getWebElement(objFilepath,
				"OPR335_chksht_btn_close");
		btn_shipperRtrn = MiscUtility.getWebElement(objFilepath,
				"OPR335_btn_shipperRtrn");

		txt_inboundCarrier = MiscUtility.getWebElement(objFilepath,
				"OPR335_txt_inboundCarrier");
		txt_inboundFlt = MiscUtility.getWebElement(objFilepath,
				"OPR335_txt_inboundFlt");
		txt_inboundFltDt = MiscUtility.getWebElement(objFilepath,
				"OPR335_txt_inboundFltDt");
		txt_origin = MiscUtility
				.getWebElement(objFilepath, "OPR335_txt_origin");
		txt_destination = MiscUtility.getWebElement(objFilepath,
				"OPR335_txt_destination");
		txt_shpmntdescription = MiscUtility.getWebElement(objFilepath,
				"OPR335_txt_shpmntdescription");
		txt_mastrStatedPieces = MiscUtility.getWebElement(objFilepath,
				"OPR335_txt_mastrStatedPieces");
		txt_mastrStatedWt = MiscUtility.getWebElement(objFilepath,
				"OPR335_txt_mastrStatedWt");
		txt_scc = MiscUtility.getWebElement(objFilepath, "OPR335_txt_scc");
		captureChecksheet_txt_freeText = MiscUtility.getWebElement(objFilepath,
				"OPR335_CaptureChecksheet_txt_freeText");
		frame_popupContainerFrame = MiscUtility.getWebElement(objFilepath,
				"OPR335_frame_popupContainerFrame");

		btn_hawbAdd = MiscUtility.getWebElement(objFilepath,
				"OPR335_btn_hawbAdd");
		txt_hawbNum = MiscUtility.getWebElement(objFilepath,
				"OPR335_hawb_txt_hawbNum");
		txt_stdPcs = MiscUtility.getWebElement(objFilepath,
				"OPR335_hawb_txt_stdPcs");
		txt_stdWt = MiscUtility.getWebElement(objFilepath,
				"OPR335_hawb_txt_stdWt");
		hawb_btn_add = MiscUtility.getWebElement(objFilepath,
				"OPR335_hawb_btn_add");
		hawb_btn_close = MiscUtility.getWebElement(objFilepath,
				"OPR335_hawb_btn_close");
		tbl_hawbAdded = MiscUtility.getWebElement(objFilepath,
				"OPR335_hawb_tbl_hawbAdded");
		hawb_dropArrow = MiscUtility.getWebElement(objFilepath,
				"OPR335_hawb_dropArrow");
		dropdown_houses = MiscUtility.getWebElement(objFilepath,
				"OPR335_hawb_dropdown_houses");
		hawb_txt_HAWB = MiscUtility.getWebElement(objFilepath,
				"OPR335_hawb_txt_HAWB");
		hawb_txt_pcs = MiscUtility.getWebElement(objFilepath,
				"OPR335_hawb_txt_pcs");
		hawb_txt_wt = MiscUtility.getWebElement(objFilepath,
				"OPR335_hawb_txt_wt");

		yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
		noBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_noBtn");
		okBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_ok");
		msg_popup = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");

		// abhilash a-8260
		msg_rsn_nt_rfc = MiscUtility.getWebElement(objFilepath,
				"OPR335_reason_for_not_RFC");
		info_genericMsg = MiscUtility.getWebElement(genObjPath,
				"Generic_info_msg");
		txt_pcs = MiscUtility.getWebElement(objFilepath, "OPR335_txt_Pcs");
		txt_wt = MiscUtility.getWebElement(objFilepath, "OPR335_txt_Wt");
		tab_secScrDet = MiscUtility.getWebElement(objFilepath,
				"OPR335_tab_secScreenDet");
		tab_expand = MiscUtility
				.getWebElement(objFilepath, "OPR335_tab_expand");
		tab_collapse = MiscUtility.getWebElement(objFilepath,
				"OPR335_tab_collapse");
		btnOk = MiscUtility.getWebElement(objFilepath, "OPR335_btn_ok");
		btnSave = MiscUtility.getWebElement(objFilepath,
				"OPR335_chksht_btn_save");
		selResult = MiscUtility.getWebElement(objFilepath, "OPR335_sel_reslt");
		selMethd = MiscUtility.getWebElement(objFilepath, "OPR335_sel_method");
		msg_warn = MiscUtility.getWebElement(objFilepath, "OPR335_msg_warn");
		tab_shipmnt = MiscUtility.getWebElement(objFilepath,
				"OPR335_tab_shipmnt");
		lbl_scc = MiscUtility.getWebElement(objFilepath, "OPR335_lbl_scc");
		btn_Add = MiscUtility.getWebElement(objFilepath, "OPR335_btn_add");
		tab_secDet = MiscUtility
				.getWebElement(objFilepath, "OPR335_tab_secDet");
		chk_secsttsgvn = MiscUtility.getWebElement(objFilepath,
				"OPR335_chk_secsttsgvn");
		/*chk_Sec_Revd = MiscUtility.getWebElement(objFilepath,
				"OPR335_chk_secdatRevd");*/
		chk_Sec_Revd=MiscUtility.getWebElement(objFilepath,"OPR335_chk_secdatRevd");
		lbl_scr_svd = MiscUtility.getWebElement(objFilepath,
				"OPR335_chk_secdatRevd");
		info_finalized = MiscUtility.getWebElement(objFilepath,
				"OPR335_info_finalized");
		MiscUtility.getWebElement(objFilepath,
				"OPR335_info_finalized_label");
		info_Acceptance_label = MiscUtility.getWebElement(objFilepath,
				"OPR335_info_Acceptance_label");
		MiscUtility.getWebElement(objFilepath,
				"OPR335_info_Acceptance_label1");
		msg_acc_finl = MiscUtility.getWebElement(objFilepath,
				"OPR335_msg_acceptancefinalization");

		btn_editAccPcs = MiscUtility.getWebElement(objFilepath,
				"OPR335_btn_editAccPcs");
		div_directBuildup = MiscUtility.getWebElement(objFilepath,
				"OPR335_div_directBuildup");
		txt_directBuildup_fltNum = MiscUtility.getWebElement(objFilepath,
				"OPR335_txt_directBuildup_fltNum");
		txt_directBuildup_fltDt = MiscUtility.getWebElement(objFilepath,
				"OPR335_txt_directBuildup_fltDt");
		txt_directBuildup_fltPou = MiscUtility.getWebElement(objFilepath,
				"OPR335_txt_directBuildup_fltPou");
		
		txt_acceptancPcs = MiscUtility.getWebElement(objFilepath,
				"OPR335_txt_acceptancPcs");
		txt_acceptanceLocatn = MiscUtility.getWebElement(objFilepath,
				"OPR335_txt_acceptanceLocatn");
		txt_acceptanceULD = MiscUtility.getWebElement(objFilepath,
				"OPR335_txt_acceptanceULD");
		btn_acceptanceAdd = MiscUtility.getWebElement(objFilepath,
				"OPR335_btn_acceptanceAdd");

		
		
		
		/*
		 * lbl_scrMethds=MiscUtility.getWebElement(objFilepath,
		 * "OPR335_lbl_scrMethods");
		 * txt_scr_name=MiscUtility.getWebElement(objFilepath,
		 * "OPR335_txt_scrName");
		 * txt_remrks=MiscUtility.getWebElement(objFilepath,
		 * "OPR335_txt_remrks"); txt_date=MiscUtility.getWebElement(objFilepath,
		 * "OPR335_txt_date");
		 * lbl_agent_id=MiscUtility.getWebElement(objFilepath,
		 * "OPR335_lbl_agentid");
		 * lbl_expirydt=MiscUtility.getWebElement(objFilepath,
		 * "OPR335_lbl_epiry");
		 * tab_agents_det=MiscUtility.getWebElement(objFilepath,
		 * "OPR335_tab_agent_det");
		 * 
		 * lbl_totAccPcs=MiscUtility.getWebElement(objFilepath,
		 * "OPR335_lbl_totAccPcs");
		 * lbl_totAccPcs=MiscUtility.getWebElement(objFilepath,
		 * "OPR335_lbl_actualAccPcs");
		 * lbl_totalLoosePcs=MiscUtility.getWebElement(objFilepath,
		 * "OPR335_lbl_totalLoosePcs");
		 * lbl_totalLooseWt=MiscUtility.getWebElement
		 * (objFilepath,"OPR335_lbl_totalLooseWt");
		 * lbl_totalLooseVol=MiscUtility
		 * .getWebElement(objFilepath,"OPR335_lbl_totalLooseVol");
		 * lbl_totalULDPcs
		 * =MiscUtility.getWebElement(objFilepath,"OPR335_lbl_totalULDPcs");
		 * lbl_totalULDWt
		 * =MiscUtility.getWebElement(objFilepath,"OPR335_lbl_totalULDWt");
		 * lbl_totalULDVol
		 * =MiscUtility.getWebElement(objFilepath,"OPR335_lbl_totalULDVol");
		 */

		// txt_houseAwb=MiscUtility.getWebElement(objFilepath,"OPR335_hawb_textHouse");
		// txt_housePcs=MiscUtility.getWebElement(objFilepath,"OPR335_house_txt_pcs");
		// txt_houseWt=MiscUtility.getWebElement(objFilepath,"OPR335_house_txt_wt");
		// btn_houseADD=MiscUtility.getWebElement(objFilepath,"OPR335_btn_houseAdd");
				
		sel_screenMethod = MiscUtility.getWebElement(objFilepath,"OPR335_sel_screenMethod");
	    txt_statedpcs = MiscUtility.getWebElement(objFilepath,"OPR335_txt_statedpcs");
	    txt_statedwt = MiscUtility.getWebElement(objFilepath,"OPR335_txt_statedwt");
	    sel_result = MiscUtility.getWebElement(objFilepath,"OPR335_sel_result");
	    btn_btnadd = MiscUtility.getWebElement(objFilepath,"OPR335_btn_btnadd");
	    txt_frmDate = MiscUtility.getWebElement(objFilepath,"OPR335_txt_frmDate");
	    btn_newSavebtn = MiscUtility.getWebElement(objFilepath,"OPR335_btn_newSavebtn");
	    btn_looseAdd = MiscUtility.getWebElement(objFilepath,"OPR335_btn_looseAdd");
	    
	    
	}

	/**
	 * Method to list an AWB
	 * 
	 * @param awbPre
	 * @param awbNo
	 * @author a-7868 Krishna <19/01/2018>
	 */
	public void list(String awbPre, String awbNo) {
		enterKeys(txt_awbPre, awbPre);
		enterKeys(txt_awbNo, awbNo);
		click(btn_list);
		minWait();
	}

	/**
	 * Method to list an AWB and save
	 * 
	 * @param awbPre
	 * @param awbNo
	 * @author a-7868 Krishna <19/01/2018>
	 */
	public OPR335 listAndSave(String awbPre, String awbNo, boolean chkRCS) {

		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);

		list(awbPre, awbNo);
		minWait();
		click(btn_save);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn))// LAT popup
			click(yesBtn);
		if (verifyElementPresent(yesBtn))// saved popup
			click(yesBtn);
		if (chkRCS)
			Assert.assertFalse(waitForElement(info_rcs).getAttribute("class")
					.equalsIgnoreCase("icon rejected"),
					"ERROR : Shipment NOT ready for carriage.");

		return this;
	}

	public OPR335 acceptance_Embargo(String awbPrefix, String AWBNo,
			String Location, String pcs, String wgt, String embargoId) {

		awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		AWBNo = PropertyHandler.getPropValue(dataFilePath, AWBNo);
		Location = PropertyHandler.getPropValue(dataFilePath, Location);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wgt = PropertyHandler.getPropValue(dataFilePath, wgt);
		embargoId = PropertyHandler.getPropValue(dataFilePath, embargoId);

		list(awbPrefix, AWBNo);
		minWait();
		minWait();
		Assert.assertTrue(
				waitForElement(div_awbDtls).getText().contains(AWBNo),
				"ERROR : AWB not listed.");

		click(div_looseAcc);
		enterKeys(loose_location, Location);
		enterKeys(txt_loose_pcs, pcs + Keys.TAB);
		enterKeys(txt_loose_wt, wgt);

		// if(!vol.equals("")) enterKeys(txt_loose_vol, vol);
		enterKeys(loose_location, Location);
		click(btn_loose_add);
		minWait();

		check(chkbox_allPartsRcvd);

		click(btn_save);
		driver.switchTo().defaultContent();

		if (verifyElementPresent(btn_yes))
			click(btn_yes);
		waitForFrameAndSwitch(FRAME);
		driver.switchTo().defaultContent();
		waitForNewWindow(2);
		switchToSecondWindow();
		waitForElement(btn_RecoEmbargoClose).isEnabled();
		String tmpTblData = waitForElement(tbl_RecoPopup).getText();
		Assert.assertTrue(tmpTblData.contains(embargoId),
				"Error:Embargo restriction failed");
		click(btn_RecoEmbargoClose);
		switchToFirstWindow();
		waitForFrameAndSwitch(FRAME);

		return this;

	}

	/***
	 * Direct transhipmnt acceptance without booking
	 * 
	 * @param awbPre
	 * @param awbNo
	 * @param pcs
	 * @param wt
	 * @param Origin
	 * @param Destination
	 * @param carrierCode
	 * @param flightno
	 * @param fltDate
	 * @param location
	 * @param scc
	 * @return A-6784
	 **/
	public OPR335 transAcceptancewithoutBooking(String awbPre, String awbNo,
			String pcs, String wt, String Origin, String Destination,
			String carrierCode, String flightno, String fltDate,
			String location, String scc, boolean allPartsRcvd) {

		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		Origin = PropertyHandler.getPropValue(dataFilePath, Origin);
		Destination = PropertyHandler.getPropValue(dataFilePath, Destination);
		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		flightno = PropertyHandler.getPropValue(dataFilePath, flightno);
		fltDate = PropertyHandler.getPropValue(dataFilePath, fltDate);
		location = PropertyHandler.getPropValue(dataFilePath, location);
		scc = PropertyHandler.getPropValue(dataFilePath, scc);

		check(chkbox_transshipment);
		list(awbPre, awbNo);
		minWait();

		driver.switchTo().defaultContent();
		if (verifyElementPresent(btn_yes))
			click(btn_yes);
		waitForFrameAndSwitch(FRAME);
		minWait();
		enterKeys(txt_origin, Origin);
		enterKeys(txt_destination, Destination);
		enterKeys(txt_mastrStatedPieces, pcs);
		enterKeys(txt_mastrStatedWt, wt);
		enterKeys(txt_shpmntdescription, "Remarks");
		enterKeys(txt_scc, scc);
		enterKeys(txt_inboundCarrier, carrierCode);
		enterKeys(txt_inboundFlt, flightno);
		enterKeys(txt_inboundFltDt, fltDate);

		enterKeys(txt_loose_pcs, pcs + Keys.TAB);
		enterKeys(txt_loose_wt, wt);
		System.out.println(location);
		if (waitForElement(loose_location).isEnabled())
			enterKeys(loose_location, location);
		click(btn_loose_add);
		minWait();

		if (allPartsRcvd)
			check(chkbox_allPartsRcvd);

		click(btn_save);
		driver.switchTo().defaultContent();

		if (verifyElementPresent(yesBtn))// LAT popup
			click(yesBtn);
		if (verifyElementPresent(yesBtn))// save popup
			click(yesBtn);

		waitForFrameAndSwitch(FRAME);
		if (allPartsRcvd)
			Assert.assertTrue(waitForElement(info_finalized).getText()
					.contains("Acceptance finalised"),
					"ERROR : Shipment not finalized.");

		/*** script is not complete due to application issue **/
		return this;

	}

	/**
	 * Method to list an AWB and update
	 * 
	 * @param awbPre
	 * @param awbNo
	 * @author a-7868 Krishna <22/01/2018>
	 */
	public OPR335 listAndUpdate(String awbPre, String awbNo, String pcs,
			String wt, String location, boolean allPartsRcvd, boolean chkRCS) {

		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		location = PropertyHandler.getPropValue(dataFilePath, location);

		list(awbPre, awbNo);
		minWait();

		if (!waitForElement(txt_loose_pcs).isDisplayed())
			click(div_looseAcc);

		// delete existing pieces

		enterKeys(txt_loose_pcs, pcs);
		enterKeys(txt_loose_wt, wt);
		enterKeys(loose_location, location);
		click(btn_loose_add);

		minWait();

		if (allPartsRcvd)
			check(chkbox_allPartsRcvd);
		click(btn_save);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn))// LAT popup
			click(yesBtn);
		if (verifyElementPresent(yesBtn))// saved popup
			click(yesBtn);

		if (allPartsRcvd)
			Assert.assertTrue(waitForElement(info_finalized).getText()
					.contains("Acceptance finalised"),
					"ERROR : Shipment not finalized.");

		if (chkRCS)
			Assert.assertFalse(waitForElement(info_rcs).getAttribute("class")
					.equalsIgnoreCase("icon rejected"),
					"ERROR : Shipment NOT ready for carriage.");

		return this;
	}

	/**
	 * Method to list an AWB and print
	 * 
	 * @param awbPre
	 * @param awbNo
	 * @author a-7868 Krishna <19/01/2018>
	 */
	public OPR335 listAndPrint(String awbPre, String awbNo) {

		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);

		list(awbPre, awbNo);
		minWait();
		click(btn_print);
		driver.switchTo().defaultContent();
		try {
			waitForNewWindow(2);
			switchToSecondWindow();
			closeAndmoveToFirstWindow();
		} catch (Exception e) {
			Assert.fail("Acceptance report print failed.");
		}

		waitForFrameAndSwitch(FRAME);
		return this;
	}

	/**
	 * Method to make a loose acceptance
	 * 
	 * @param awbPre
	 * @param awbNo
	 * @param pcs
	 * @param wt
	 * @param vol
	 *            (optional param; use "")
	 * @param location
	 * @param allPartsRcvd
	 * @param chkRCS
	 *            (true when Ready for Carriage status is to be checked)
	 * @param errorChk
	 *            (true when error is to be checked)
	 * @param errorMsg
	 *            (Error message to be checked when errorChk is true; else "")
	 * @return
	 * @author a-7868 Krishna <19/01/2018>
	 */
	public OPR335 looseAcceptance(String awbPre, String awbNo, String pcs,
			String wt, String vol, String location, boolean allPartsRcvd,
			boolean chkRCS, boolean errorChk, String errorMsg) {

		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		if (!vol.equals(""))
			vol = PropertyHandler.getPropValue(dataFilePath, vol);
		location = PropertyHandler.getPropValue(dataFilePath, location);
		if (errorMsg != null && !errorMsg.equals(""))
			errorMsg = PropertyHandler.getPropValue(dataFilePath, errorMsg);

		list(awbPre, awbNo);
		minWait();
		minWait();
		Assert.assertTrue(
				waitForElement(div_awbDtls).getText().contains(awbNo),
				"ERROR : AWB not listed.");

		if (!verifyElementVisible(txt_loose_pcs))
			click(div_looseAcc);
		enterKeys(txt_loose_pcs, pcs + Keys.TAB);
		enterKeys(txt_loose_wt, wt);
		// if(!vol.equals("")) enterKeys(txt_loose_vol, vol);
		if (waitForElement(loose_location).isEnabled())
			enterKeys(loose_location, location);
		click(btn_loose_add);
		minWait();

		if (allPartsRcvd)
			check(chkbox_allPartsRcvd);

		click(btn_save);
		driver.switchTo().defaultContent();

		if (verifyElementPresent(yesBtn))// LAT popup
			click(yesBtn);

		if (errorChk) {
			waitForFrameAndSwitch(FRAME);
			Assert.assertTrue(
					waitForElement(info_errorMsg).getText().contains(errorMsg),
					"ERROR : Error message not shown.");
		} else {

			if (allPartsRcvd) {
				while (true) {
					minWait();
					if (verifyElementPresent(yesBtn))
						click(yesBtn);
					else
						break;
				}
				waitForFrameAndSwitch(FRAME);
				Assert.assertTrue(waitForElement(info_finalized).getText()
						.contains("Acceptance finalised"),
						"ERROR : Shipment not finalized.");
			} else {
				if (verifyElementPresent(yesBtn)) {
					Assert.assertTrue(waitForElement(msg_popup).getText()
							.contains("All parts received not checked"),
							"ERROR : Warning message not shown.");
					click(yesBtn);
				}
				waitForFrameAndSwitch(FRAME);
				Assert.assertTrue(waitForElement(info_finalized).getText()
						.contains("Acceptance not finalised"),
						"ERROR : In Shipment status.");
			}

			if (chkRCS) {

				Assert.assertFalse(waitForElementVisible(info_rcs)
						.getAttribute("class").contains("icon rejected"),
						"ERROR : Shipment NOT ready for carriage.");
			} else
				minWait();
			// Assert.assertTrue(waitForElement(info_rcs).getAttribute("class").contains("icon rejected"),
			// "ERROR : Shipment NOT ready for carriage.");

		}

		// click(icon_edit);
		// click(btn_clear);
		return this;
	}

	/**
	 * Method to make a loose acceptance to a location irrespective of the
	 * status
	 * 
	 * @param awbPre
	 * @param awbNo
	 * @param pcs
	 * @param wt
	 * @param location
	 * @return
	 * @author a-7681 Arun
	 */
	public OPR335 acceptToLocation(String awbPre, String awbNo, String pcs,
			String wt, String location) {

		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		location = PropertyHandler.getPropValue(dataFilePath, location);

		list(awbPre, awbNo);
		minWait();
		minWait();
		/*Assert.assertTrue(
				waitForElement(div_awbDtls).getText().contains(awbNo),
				"ERROR : AWB not listed.");
*/
		 click(div_looseAcc);
		enterKeys(txt_loose_pcs, pcs + Keys.TAB);
		enterKeys(txt_loose_wt, wt);
		// if(!vol.equals("")) enterKeys(txt_loose_vol, vol);
		enterKeys(loose_location, location);
		maxWait();
		enterKeys(By.xpath("//input[@name='looseShipmentVolume']"),"0.72");
		click(btn_loose_add);
		minWait();

		check(chkbox_allPartsRcvd);

		click(btn_save);
		driver.switchTo().defaultContent();
		
		if (verifyElementPresent(yesBtn))// LAT popup
			click(yesBtn);
		InitialSetup.test.log(LogStatus.INFO, "Goods Acceptance Blocked for screening");
		
		if (verifyElementPresent(yesBtn))
			click(yesBtn);
		
		waitForFrameAndSwitch(FRAME);
		maxWait();
		maxWait();
		
			click(By.xpath("//a[@name='expand']"));
			maxWait();
			maxWait();
			driver.switchTo().frame("if11");
			selectByText(By.xpath("//select[@name='screenMethod']"),"Screened by TSA");
			//click(By.xpath("//select[@name='screenMethod']"));
			//click(By.xpath("//option[@value='MDE']"));
			//doubleClick((WebElement) By.xpath("//select[@name='screenMethod']"));
		//	doubleClick((WebElement) By.xpath("//option[@value='MDE']"));
			
			enterKeys(By.xpath("(//input[@name='statedPieces'])[1]"),pcs);
			enterKeys(By.xpath("(//input[@name='statedWeight'])[1]"), wt);
			selectByText(By.xpath("(//select[@name='result'])[1]"),"Pass");
			enterKeys(By.xpath("(//input[@name='screeningRemarks'])[1]"), "Screening Done");
			click(By.xpath("//button[@name='btnAdd']"));
			InitialSetup.test.log(LogStatus.PASS, "Security screening details entered succesfully");
			minWait();
			click(By.xpath("//button[@name='btSave']"));
			
			
			driver.switchTo().defaultContent();
			if (verifyElementPresent(yesBtn))
				click(yesBtn);
			waitForFrameAndSwitch(FRAME);
			
			//driver.switchTo().frame("iCargoContentFrameOPR335");
			maxWait();
			click(btn_save);
			driver.switchTo().defaultContent();

			if (verifyElementPresent(yesBtn))
				click(yesBtn);

			waitForFrameAndSwitch(FRAME);
	
			String message=driver.findElement(By.xpath("//label[@class='message-short complete m-t-15 pull-left block']")).getText();
			if(message.contains("Ready for carriage"))
			{
				InitialSetup.test.log(LogStatus.PASS, "Goods acceptance successfully done");
			}
			else
			{
				InitialSetup.test.log(LogStatus.FAIL, "Goods Acceptance failed");
				Assert.fail("Goods Acceptance failed");
			}

		//click(icon_edit);
		//click(btn_clear);
		
		return this;
	}

	public OPR335 simpleAcceptance(String awbPre, String awbNo, String pcs,
			String wt, String vol, String location, boolean allPartsRcvd) {

		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		if (!vol.equals(""))
			vol = PropertyHandler.getPropValue(dataFilePath, vol);
		location = PropertyHandler.getPropValue(dataFilePath, location);

		list(awbPre, awbNo);
		minWait();
		minWait();
		Assert.assertTrue(
				waitForElement(div_awbDtls).getText().contains(awbNo),
				"ERROR : AWB not listed.");

		click(div_looseAcc);
		enterKeys(txt_loose_pcs, pcs + Keys.TAB);
		enterKeys(txt_loose_wt, wt);
		if (!vol.equals("")) {
			enterKeys(txt_loose_vol, vol);
		}
		enterKeys(loose_location, location);
		minWait();
		click(btn_loose_add);
		minWait();

		if (allPartsRcvd)
			check(chkbox_allPartsRcvd);

		click(btn_save);
		driver.switchTo().defaultContent();

		if (verifyElementPresent(yesBtn))// LAT popup
			click(yesBtn);

		waitForFrameAndSwitch(FRAME);
		minWait();
		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn)) {
			click(yesBtn);
		}
		waitForFrameAndSwitch(FRAME);

		if (allPartsRcvd) {
			Assert.assertFalse(waitForElement(info_finalized).getText()
					.contains("Acceptance not finalised"),
					"ERROR : In Shipment status.");
		}

		click(icon_edit);
		// click(btn_clear);
		return this;
	}

	/**
	 * Method to make a loose acceptance after clicking the transshipment
	 * checkbox
	 * 
	 * @param awbPre
	 * @param awbNo
	 * @param pcs
	 * @param wt
	 * @param location
	 * @param allPartsRcvd
	 * @param chkRCS
	 *            (true when Ready for Carriage status is to be checked)
	 * @return
	 * @author a-7868 Krishna <22/01/2018>
	 */
	public OPR335 looseAcceptAsTransShipment(String awbPre, String awbNo,
			String pcs, String wt, String location, boolean allPartsRcvd,
			boolean chkRCS) {

		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		location = PropertyHandler.getPropValue(dataFilePath, location);

		check(chkbox_transshipment);
		list(awbPre, awbNo);
		minWait();

		Assert.assertTrue(
				waitForElement(div_awbDtls).getText().contains(awbNo),
				"ERROR : AWB not listed.");

		click(div_looseAcc);
		enterKeys(txt_loose_pcs, pcs);
		enterKeys(txt_loose_wt, wt);
		enterKeys(loose_location, location);
		click(btn_loose_add);
		minWait();

		if (allPartsRcvd)
			check(chkbox_allPartsRcvd);

		click(btn_save);
		driver.switchTo().defaultContent();

		if (verifyElementPresent(yesBtn))// LAT popup
			click(yesBtn);
		if (verifyElementPresent(yesBtn))// save popup
			click(yesBtn);

		waitForFrameAndSwitch(FRAME);
		if (allPartsRcvd)
			Assert.assertTrue(waitForElement(info_finalized).getText()
					.contains("Acceptance finalised"),
					"ERROR : Shipment not finalized.");
		if (chkRCS)
			Assert.assertFalse(waitForElement(info_rcs).getAttribute("class")
					.equalsIgnoreCase("icon rejected"),
					"ERROR : Shipment NOT ready for carriage.");

		return this;
	}

	/**
	 * Method to make a loose acceptance after clicking the transshipment
	 * checkbox And also provide CTM details
	 * 
	 * @param awbPre
	 * @param awbNo
	 * @param carrCode
	 * @param fltNo
	 * @param fltDt
	 * @param pcs
	 * @param wt
	 * @param location
	 * @param allPartsRcvd
	 * @param chkRCS
	 * @return
	 * @author a-7868 Krishna <08/03/2018>
	 */
	public OPR335 looseAcceptTransShipmentWithCTM(String awbPre, String awbNo,
			String carrCode, String fltNo, String fltDt, String pcs, String wt,
			String location, boolean allPartsRcvd, boolean chkRCS) {

		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		location = PropertyHandler.getPropValue(dataFilePath, location);
		carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);

		check(chkbox_transshipment);
		list(awbPre, awbNo);
		minWait();

		Assert.assertTrue(
				waitForElement(div_awbDtls).getText().contains(awbNo),
				"ERROR : AWB not listed.");

		enterKeys(txt_inboundCarrier, carrCode);
		enterKeys(txt_inboundFlt, fltNo);
		enterKeys(txt_inboundFltDt, fltDt);

		expandLooseAcceptanceAccordin();
		enterKeys(txt_loose_pcs, pcs);
		enterKeys(txt_loose_wt, wt);
		if (waitForElement(loose_location).isEnabled())
			enterKeys(loose_location, location);
		click(btn_loose_add);
		minWait();

		if (allPartsRcvd)
			check(chkbox_allPartsRcvd);

		click(btn_save);
		driver.switchTo().defaultContent();

		if (verifyElementPresent(yesBtn))// LAT popup
			click(yesBtn);
		if (verifyElementPresent(yesBtn))// save popup
			click(yesBtn);

		waitForFrameAndSwitch(FRAME);
		if (allPartsRcvd)
			Assert.assertTrue(waitForElement(info_finalized).getText()
					.contains("Acceptance finalised"),
					"ERROR : Shipment not finalized.");
		if (chkRCS)
			Assert.assertFalse(waitForElement(info_rcs).getAttribute("class")
					.equalsIgnoreCase("icon rejected"),
					"ERROR : Shipment NOT ready for carriage.");

		return this;
	}

	/**
	 * Method to make an acceptance by adding 2 houses
	 * 
	 * @param awbPre
	 * @param awbNo
	 * @param pcs
	 * @param wt
	 * @param location
	 * @param h1Pcs
	 * @param h2Pcs
	 * @param h1Wt
	 * @param h2Wt
	 * @param house1
	 * @param house2
	 * @param allPartsRcvd
	 * @param chkRCS
	 * @return
	 * @author a-7868 Krishna <24/01/2018>
	 */
	public OPR335 houseAcceptance(String awbPre, String awbNo, String pcs,
			String wt, String location, String h1Pcs, String h2Pcs,
			String h1Wt, String h2Wt, String house1, String house2,
			boolean allPartsRcvd, boolean chkRCS) {

		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		location = PropertyHandler.getPropValue(dataFilePath, location);
		h1Pcs = PropertyHandler.getPropValue(dataFilePath, h1Pcs);
		h2Pcs = PropertyHandler.getPropValue(dataFilePath, h2Pcs);
		h1Wt = PropertyHandler.getPropValue(dataFilePath, h1Wt);
		h2Wt = PropertyHandler.getPropValue(dataFilePath, h2Wt);
		house1 = PropertyHandler.getPropValue(dataFilePath, house1);
		house2 = PropertyHandler.getPropValue(dataFilePath, house2);

		list(awbPre, awbNo);
		minWait();

		Assert.assertTrue(
				waitForElement(div_awbDtls).getText().contains(awbNo),
				"ERROR : AWB not listed.");

		click(div_looseAcc);
		enterKeys(txt_loose_pcs, pcs);
		enterKeys(txt_loose_wt, wt);
		enterKeys(loose_location, location);
		click(btn_loose_add);
		minWait();

		// house add
		click(btn_hawbAdd);

		// driver.switchTo().defaultContent();

		driver.switchTo().defaultContent();
		minWait();
		click(hawb_dropArrow);
		selectByValue(dropdown_houses, house1);
		enterKeys(txt_stdPcs, h1Pcs);
		enterKeys(txt_stdWt, h1Wt);
		click(btn_hawbAdd);
		// 2nd house

		click(hawb_dropArrow);
		// selectByValue(dropdown_houses, house1);
		enterKeys(txt_houseAwb, house1);
		// enterKeys(txt_stdPcs, h1Pcs);
		enterKeys(txt_housePcs, h1Pcs);
		// enterKeys(txt_stdWt, h1Wt);
		enterKeys(txt_houseWt, h1Wt);
		click(btn_houseADD);
		// click(btn_hawbAdd);
		// >>>>>>>>>>> 2nd house
		// click(hawb_dropArrow);
		enterKeys(txt_houseAwb, house2);
		// selectByValue(dropdown_houses, house2);
		// enterKeys(dropdown_houses, house2);
		enterKeys(txt_housePcs, h2Pcs);
		enterKeys(txt_houseWt, h2Wt);
		click(btn_houseADD);

		click(hawb_btn_close);
		// waitForFrameAndSwitch(FRAME);

		if (allPartsRcvd)
			check(chkbox_allPartsRcvd);

		click(btn_save);
		driver.switchTo().defaultContent();

		if (verifyElementPresent(yesBtn))// LAT popup
			click(yesBtn);

		if (allPartsRcvd) {
			if (verifyElementPresent(yesBtn))
				click(yesBtn);
			waitForFrameAndSwitch(FRAME);
			Assert.assertTrue(waitForElement(info_finalized).getText()
					.contains("Acceptance finalised"),
					"ERROR : Shipment not finalized.");
		}

		if (chkRCS)
			Assert.assertFalse(waitForElement(info_rcs).getAttribute("class")
					.equalsIgnoreCase("icon rejected"),
					"ERROR : Shipment NOT ready for carriage.");

		click(icon_edit);
		click(btn_clear);
		minWait();
		list(awbPre, awbNo);
		minWait();
		return this;
	}

	/**
	 * Method to make loose acceptance Accept the shipment in two different
	 * locations Loc1 - (pcs/2, wt/2), Loc2 - (pcs/2, wt/2)
	 * 
	 * @param awbPre
	 * @param awbNo
	 * @param pcs
	 * @param wt
	 * @param location1
	 * @param location2
	 * @return
	 * @author a-7868 Krishna <19/01/2018>
	 */
	public OPR335 looseAcceptanceSplit(String awbPre, String awbNo, String pcs,
			String wt, String location1, String location2) {

		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		location1 = PropertyHandler.getPropValue(dataFilePath, location1);
		location2 = PropertyHandler.getPropValue(dataFilePath, location2);

		String halfPcs = String.valueOf(Integer.parseInt(pcs) / 2);
		String halfWt = String.valueOf(Integer.parseInt(wt) / 2);

		list(awbPre, awbNo);
		minWait();
		expandLooseAcceptanceAccordin();
		enterKeys(txt_loose_pcs, halfPcs);
		enterKeys(txt_loose_wt, halfWt);
		enterKeys(loose_location, location1);
		click(btn_loose_add);
		minWait();
		enterKeys(txt_loose_pcs, halfPcs);
		enterKeys(txt_loose_wt, halfWt);
		enterKeys(loose_location, location2);
		click(btn_loose_add);
		minWait();
		scrollToView(info_looseTotal);
		System.out.println(getTableRowCount(info_looseTotal));
		Assert.assertTrue((getTableRowCount(info_looseTotal) == 3),
				"ERROR : Pcs not added to location.");
		minWait();
		check(chkbox_allPartsRcvd);
		click(btn_save);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn))
			click(yesBtn);
		if (verifyElementPresent(yesBtn))
			click(yesBtn);
		waitForFrameAndSwitch(FRAME);
		Assert.assertTrue(
				waitForElement(info_finalized).getText().contains(
						"Acceptance finalised"),
				"ERROR : Shipment not finalized.");
		return this;
	}

	/**
	 * Method to make a ULD acceptance with ULD Type = AKE
	 * 
	 * @param awbPre
	 * @param awbNo
	 * @param pcs
	 * @param wt
	 * @param location
	 * @param allPartsRcvd
	 * @param uldNum
	 * @param errChk
	 *            (true when error is to be checked)
	 * @param errorMsg
	 *            (Error message to be checked when errorChk is true; else "")
	 * @return
	 * @author a-7868 Krishna <19/01/2018>
	 */
	public OPR335 uldAcceptance(String compCode, String awbPre, String awbNo,
			String pcs, String wt, String location, boolean allPartsRcvd,
			String uldNum, boolean errChk, String errorMsg) {

		compCode = PropertyHandler.getPropValue(dataFilePath, compCode);
		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		location = PropertyHandler.getPropValue(dataFilePath, location);

		list(awbPre, awbNo);
		minWait();
		Assert.assertTrue(
				waitForElement(div_awbDtls).getText().contains(awbNo),
				"ERROR : AWB not listed.");
		if (!verifyElementVisible(txt_uld_pcs))
			click(div_ULDAcc);
		enterKeys((txt_uld_pcs), pcs);
		enterKeys(txt_uld_wt, wt);
		if (waitForElement(txt_uld_location).isEnabled())
			enterKeys(txt_uld_location, location);

		String uld = null;
		int count = 0;

		while (count < 5) {
			uld = BizUtility.createULDNum("AKE", compCode);
			enterKeys(txt_uldNum, uld);
			// enterKeys(txt_uldNum, Keys.TAB);
			minWait();
			//
			driver.switchTo().defaultContent();
			if (verifyElementPresent(yesBtn)) {
				click(yesBtn);
				waitForFrameAndSwitch(FRAME);
				break;
			}
			waitForFrameAndSwitch(FRAME);
			count++;
		}
		minWait();
		click(btn_uld_add);
		PropertyHandler.setPropValue(dataFilePath, uldNum, uld.trim());
		if (allPartsRcvd)
			check(chkbox_allPartsRcvd);

		click(btn_save);
		driver.switchTo().defaultContent();

		if (verifyElementPresent(yesBtn))// LAT popup
			click(yesBtn);

		if (errChk) {
			waitForFrameAndSwitch(FRAME);
			errorMsg = PropertyHandler.getPropValue(dataFilePath, errorMsg);
			Assert.assertTrue(
					waitForElement(info_errorMsg).getText().contains(errorMsg),
					"ERROR : Error message not shown.");

		} else {
			if (allPartsRcvd) {
				while (true) {
					minWait();
					if (verifyElementPresent(yesBtn))
						click(yesBtn);
					else
						break;
				}
				waitForFrameAndSwitch(FRAME);
				new WebDriverWait(driver, 60).until(ExpectedConditions
						.elementToBeClickable(btn_save));
				minWait();
				Assert.assertTrue(waitForElement(info_finalized).getText()
						.contains("Acceptance finalised"),
						"ERROR : Shipment not finalized.");
			} else {
				if (verifyElementPresent(yesBtn)) {
					Assert.assertTrue(waitForElement(msg_popup).getText()
							.contains("All parts received not checked"),
							"ERROR : Warning message not shown.");
					click(yesBtn);
				}
				waitForFrameAndSwitch(FRAME);
				Assert.assertTrue(waitForElement(info_finalized).getText()
						.contains("Acceptance not finalised"),
						"ERROR : In Shipment status.");
			}
		}

		return this;
	}

	/**
	 * Method to make a ULD acceptance with specific ULD Type
	 * 
	 * @param compCode
	 * @param awbPre
	 * @param awbNo
	 * @param pcs
	 * @param wt
	 * @param location
	 * @param allPartsRcvd
	 * @param uldType
	 * @param uldNum
	 * @param errChk
	 * @param errorMsg
	 * @return
	 * @author A-7868 Krishna <28/05/2018>
	 */
	public OPR335 uldAcceptance(String compCode, String awbPre, String awbNo,
			String pcs, String wt, String location, boolean allPartsRcvd,
			String uldType, String uldNum, boolean errChk, String errorMsg) {

		compCode = PropertyHandler.getPropValue(dataFilePath, compCode);
		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		location = PropertyHandler.getPropValue(dataFilePath, location);
		uldType = PropertyHandler.getPropValue(dataFilePath, uldType);

		list(awbPre, awbNo);
		minWait();
		Assert.assertTrue(
				waitForElement(div_awbDtls).getText().contains(awbNo),
				"ERROR : AWB not listed.");
		if (!verifyElementVisible(txt_uld_pcs))
			click(div_ULDAcc);
		enterKeys((txt_uld_pcs), pcs);
		enterKeys(txt_uld_wt, wt);
		if (waitForElement(txt_uld_location).isEnabled())
			enterKeys(txt_uld_location, location);

		String uld = null;
		int count = 0;

		while (count < 5) {
			uld = BizUtility.createULDNum(uldType, compCode);
			enterKeys(txt_uldNum, uld);
			// enterKeys(txt_uldNum, Keys.TAB);
			minWait();
			//
			driver.switchTo().defaultContent();
			if (verifyElementPresent(yesBtn)) {
				click(yesBtn);
				waitForFrameAndSwitch(FRAME);
				break;
			}
			waitForFrameAndSwitch(FRAME);
			count++;
		}
		minWait();
		click(btn_uld_add);
		PropertyHandler.setPropValue(dataFilePath, uldNum, uld.trim());
		if (allPartsRcvd)
			check(chkbox_allPartsRcvd);

		click(btn_save);
		driver.switchTo().defaultContent();

		if (verifyElementPresent(yesBtn))// LAT popup
			click(yesBtn);

		if (errChk) {
			waitForFrameAndSwitch(FRAME);
			errorMsg = PropertyHandler.getPropValue(dataFilePath, errorMsg);
			Assert.assertTrue(
					waitForElement(info_errorMsg).getText().contains(errorMsg),
					"ERROR : Error message not shown.");

		} else {
			if (allPartsRcvd) {
				while (true) {
					minWait();
					if (verifyElementPresent(yesBtn))
						click(yesBtn);
					else
						break;
				}
				waitForFrameAndSwitch(FRAME);
				new WebDriverWait(driver, 60).until(ExpectedConditions
						.elementToBeClickable(btn_save));
				minWait();
				Assert.assertTrue(waitForElement(info_finalized).getText()
						.contains("Acceptance finalised"),
						"ERROR : Shipment not finalized.");
			} else {
				if (verifyElementPresent(yesBtn)) {
					Assert.assertTrue(waitForElement(msg_popup).getText()
							.contains("All parts received not checked"),
							"ERROR : Warning message not shown.");
					click(yesBtn);
				}
				waitForFrameAndSwitch(FRAME);
				Assert.assertTrue(waitForElement(info_finalized).getText()
						.contains("Acceptance not finalised"),
						"ERROR : In Shipment status.");
			}
		}

		return this;
	}

	/**
	 * Method to make a ULD acceptance to a location irrespective of the status
	 * 
	 * @param awbPre
	 * @param awbNo
	 * @param pcs
	 * @param wt
	 * @param location
	 * @param uldNum
	 * @return
	 * @author a-7681 run
	 */
	public OPR335 acceptULDToLoc(String compCode, String awbPre, String awbNo,
			String pcs, String wt, String location, String uldNum) {

		compCode = PropertyHandler.getPropValue(dataFilePath, compCode);
		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		location = PropertyHandler.getPropValue(dataFilePath, location);

		list(awbPre, awbNo);
		minWait();
		scrollToView(div_ULDAcc);
		click(div_ULDAcc);
		enterKeys((txt_uld_pcs), pcs);
		enterKeys(txt_uld_wt, wt);
		enterKeys(txt_uld_location, location);

		String uld = null;
		int count = 0;

		while (count < 5) {
			uld = BizUtility.createULDNum("AKE", compCode);
			enterKeys(txt_uldNum, uld);
			// enterKeys(txt_uldNum, Keys.TAB);

			driver.switchTo().defaultContent();
			if (verifyElementPresent(btn_yes)) {
				click(btn_yes);
				waitForFrameAndSwitch(FRAME);
				break;
			}
			waitForFrameAndSwitch(FRAME);
			count++;
		}
		minWait();
		click(btn_uld_add);
		PropertyHandler.setPropValue(dataFilePath, uldNum, uld);
		check(chkbox_allPartsRcvd);

		click(btn_save);
		driver.switchTo().defaultContent();

		count = 0;
		while (verifyElementPresent(yesBtn) && count < 5) {
			click(yesBtn);
			count++;
		}
		/*
		 * if (verifyElementPresent(yesBtn)) click(yesBtn);
		 */
		waitForFrameAndSwitch(FRAME);

		return this;
	}

	/**
	 * Method to make a ULD acceptance
	 * 
	 * @param awbPre
	 * @param awbNo
	 * @param pcs
	 * @param wt
	 * @param location
	 * @param allPartsRcvd
	 * @param uldNum
	 * @return
	 * @author a-7868 Krishna <19/01/2018>
	 */
	public OPR335 uldAcceptance_existinguld(String compCode, String awbPre,
			String awbNo, String pcs, String wt, String location,
			boolean allPartsRcvd, String uldNum) {

		compCode = PropertyHandler.getPropValue(dataFilePath, compCode);
		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		location = PropertyHandler.getPropValue(dataFilePath, location);
		uldNum = PropertyHandler.getPropValue(dataFilePath, uldNum);
		list(awbPre, awbNo);
		minWait();
		scrollToView(div_ULDAcc);
		click(div_ULDAcc);
		enterKeys((txt_uld_pcs), pcs);
		enterKeys(txt_uld_wt, wt);
		enterKeys(txt_uld_location, location);

		enterKeys(txt_uldNum, uldNum);
		enterKeys(txt_uldNum, Keys.TAB);

		//
		/*
		 * driver.switchTo().defaultContent();
		 * if(verifyElementPresent(btn_yes)){ click(btn_yes); minWait();
		 * waitForFrameAndSwitch(FRAME);}
		 */
		click(btn_uld_add);

		if (allPartsRcvd)
			check(chkbox_allPartsRcvd);

		click(btn_save);
		driver.switchTo().defaultContent();

		if (verifyElementPresent(yesBtn))// LAT popup
			click(yesBtn);

		if (allPartsRcvd) {
			if (verifyElementPresent(yesBtn))
				click(yesBtn);
			waitForFrameAndSwitch(FRAME);
			Assert.assertTrue(waitForElement(info_finalized).getText()
					.contains("Acceptance finalised"),
					"ERROR : Shipment not finalized.");
		} else {
			if (verifyElementPresent(yesBtn)) {
				Assert.assertTrue(
						waitForElement(msg_popup).getText().contains(
								"All parts received not checked"),
						"ERROR : Warning message not shown.");
				click(yesBtn);
			}
			waitForFrameAndSwitch(FRAME);
			Assert.assertTrue(waitForElement(info_finalized).getText()
					.contains("Acceptance not finalised"),
					"ERROR : In Shipment status.");
		}
		return this;
	}

	/**
	 * Method to accept in both Loose and ULD
	 * 
	 * @param compCode
	 * @param awbPre
	 * @param awbNo
	 * @param loosePcs
	 * @param looseWt
	 * @param location1
	 * @param uldPcs
	 * @param uldWt
	 * @param location2
	 * @param allPartsRcvd
	 * @param uldNum
	 * @return
	 */
	public OPR335 looseAndULDAcceptance(String compCode, String awbPre,
			String awbNo, String loosePcs, String looseWt, String location1,
			String uldPcs, String uldWt, String location2,
			boolean allPartsRcvd, String uldNum) {

		compCode = PropertyHandler.getPropValue(dataFilePath, compCode);
		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		loosePcs = PropertyHandler.getPropValue(dataFilePath, loosePcs);
		looseWt = PropertyHandler.getPropValue(dataFilePath, looseWt);
		location1 = PropertyHandler.getPropValue(dataFilePath, location1);
		uldPcs = PropertyHandler.getPropValue(dataFilePath, uldPcs);
		uldWt = PropertyHandler.getPropValue(dataFilePath, uldWt);
		location2 = PropertyHandler.getPropValue(dataFilePath, location2);

		list(awbPre, awbNo);
		minWait();

		if (!verifyElementVisible(txt_loose_pcs))
			click(div_looseAcc);

		scrollToView(txt_loose_pcs);
		enterKeys(txt_loose_pcs, loosePcs);
		enterKeys(txt_loose_wt, looseWt);
		enterKeys(loose_location, location1);
		click(btn_loose_add);
		minWait();

		scrollToView(div_ULDAcc);

		if (!verifyElementVisible(txt_uld_pcs))
			click(div_ULDAcc);

		enterKeys(txt_uld_pcs, uldPcs);
		enterKeys(txt_uld_wt, uldWt);
		enterKeys(txt_uld_location, location2);
		String uld;
		uld = BizUtility.createULDNum("AKE", compCode);
		enterKeys(txt_uldNum, uld);
		enterKeys(txt_uldNum, Keys.TAB);
		minWait();
		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn))// new ULD Num
			click(yesBtn);
		waitForFrameAndSwitch(FRAME);
		click(btn_uld_add);

		PropertyHandler.setPropValue(dataFilePath, uldNum, uld);
		scrollToView(chkbox_allPartsRcvd);
		if (allPartsRcvd)
			check(chkbox_allPartsRcvd);

		click(btn_save);
		driver.switchTo().defaultContent();

		if (verifyElementPresent(yesBtn))// LAT popup
			click(yesBtn);

		if (allPartsRcvd) {
			if (verifyElementPresent(yesBtn))
				click(yesBtn);
			waitForFrameAndSwitch(FRAME);
			Assert.assertTrue(waitForElement(info_finalized).getText()
					.contains("Acceptance finalised"),
					"ERROR : Shipment not finalized.");
		} else {
			if (verifyElementPresent(yesBtn)) {
				Assert.assertTrue(
						waitForElement(msg_popup).getText().contains(
								"All parts received not checked"),
						"ERROR : Warning message not shown.");
				click(yesBtn);
			}
			waitForFrameAndSwitch(FRAME);
			Assert.assertTrue(waitForElement(info_finalized).getText()
					.contains("Acceptance not finalised"),
					"ERROR : In Shipment status.");
		}
		click(icon_edit);
		click(btn_clear);
		return this;
	}

	/**
	 * Method to accept a Transshipment (intermediate stn)
	 * 
	 * @param awbPre
	 * @param awbNo
	 * @param pcs
	 * @param wt
	 * @param location
	 * @param carrierCode
	 * @param frmFlt
	 * @param fltDate
	 * @param allPartsRcvd
	 * @return
	 * @author a-7868 Krishna <22/01/2018>
	 */
	public OPR335 looseAcceptTransShipment(String awbPre, String awbNo,
			String pcs, String wt, String location, String carrierCode,
			String frmFlt, String fltDate, boolean allPartsRcvd) {

		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		location = PropertyHandler.getPropValue(dataFilePath, location);
		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		frmFlt = PropertyHandler.getPropValue(dataFilePath, frmFlt);
		fltDate = PropertyHandler.getPropValue(dataFilePath, fltDate);

		list(awbPre, awbNo);
		// check transshipment checkbox
		click(icon_edit);
		Assert.assertTrue(waitForElement(chkbox_transshipment).isSelected(),
				"ERROR : Transshipment checbox not checked.");
		click(icon_cross);

		enterKeys(txt_inboundCarrier, carrierCode);
		enterKeys(txt_inboundFlt, frmFlt);
		enterKeys(txt_inboundFltDt, fltDate);
		Assert.assertTrue(
				waitForElement(div_awbDtls).getText().contains(awbNo),
				"ERROR : AWB not listed.");
		click(div_looseAcc);
		enterKeys(txt_loose_pcs, pcs);
		enterKeys(txt_loose_wt, wt);
		enterKeys(loose_location, location);
		click(btn_loose_add);
		minWait();
		if (allPartsRcvd)
			check(chkbox_allPartsRcvd);
		click(btn_save);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn))// LAT popup
			click(yesBtn);
		if (verifyElementPresent(yesBtn))// Save successful popupS
			click(yesBtn);
		waitForFrameAndSwitch(FRAME);
		if (allPartsRcvd) {
			// check Finalised status
			Assert.assertTrue(waitForElement(info_finalized).getText()
					.contains("Acceptance finalised"),
					"ERROR : Shipment Not Finalised.");
			// check RCS status
			Assert.assertFalse(waitForElement(info_rcs).getAttribute("class")
					.equalsIgnoreCase("icon rejected"),
					"ERROR : Shipment NOT ready for carriage.");
		}
		return this;
	}

	private void expandLooseAcceptanceAccordin() {
		while (true) {
			minWait();
			WebElement looseAcceptancePiece = driver.findElement(txt_loose_pcs);
			if (looseAcceptancePiece.isDisplayed())
				break;
			click(div_looseAcc);
		}
		minWait();
	}

	/**
	 * @param awbPre
	 * @param awbNo
	 * @param pcs
	 * @param wt
	 * @param location
	 * @return
	 */
	public OPR335 looseAcceptWithChkSht(String awbPre, String awbNo,
			String pcs, String wt, String location) {

		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		location = PropertyHandler.getPropValue(dataFilePath, location);

		list(awbPre, awbNo);
		minWait();
		waitForElement(btn_close);
		minWait();
		Assert.assertTrue(
				waitForElement(div_awbDtls).getText().contains(awbNo),
				"ERROR : AWB not listed.");

		expandLooseAcceptanceAccordin();
		enterKeys(txt_loose_pcs, pcs);
		enterKeys(txt_loose_wt, wt);
		enterKeys(loose_location, location);
		click(btn_loose_add);
		minWait();

		check(chkbox_allPartsRcvd);

		click(btn_save);
		driver.switchTo().defaultContent();

		if (verifyElementPresent(yesBtn))// LAT popup
			click(yesBtn);

		if (verifyElementPresent(yesBtn)) {
			Assert.assertTrue(
					waitForElement(msg_popup).getText().contains(
							"Acceptance check sheet not complete"),
					"ERROR : Warning message not shown.");
			click(yesBtn);
			waitForFrameAndSwitch(FRAME);

			// checksheet window with one yes/no question
			click(link_checksheet);
			waitForNewWindow(2);
			switchToSecondWindow();
			selectByText(dropdown_yesOrNo, "Yes");
			check(chksht_btn_save);
			check(chksht_btn_close);
			switchToFirstWindow();
			waitForFrameAndSwitch(FRAME);

			click(btn_save);
			driver.switchTo().defaultContent();
			if (verifyElementPresent(yesBtn))// LAT popup
				click(yesBtn);
			if (verifyElementPresent(yesBtn)) {
				Assert.assertTrue(waitForElement(info_finalized).getText()
						.contains("Acceptance finalised"),
						"ERROR : Shipment not finalized.");
				click(yesBtn);
			}
			waitForFrameAndSwitch(FRAME);
			Assert.assertTrue(waitForElement(link_checksheet).getText()
					.contains("Checksheet - Completed"),
					"ERROR : Checksheet status");

		}

		click(icon_edit);
		click(btn_clear);
		return this;
	}

	public OPR040 shipperReturn(String awbPre, String awbNo) {

		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);

		list(awbPre, awbNo);

		click(btn_shipperRtrn);

		return new OPR040(driver, dataFileName);
	}

	/**
	 * Clears the form
	 * 
	 * @return
	 * @author Arun A-7681
	 */
	public OPR335 clear() {

		waitForElement(btn_close);
		minWait();
		Actions action = new Actions(driver);
		action.keyDown(Keys.ALT).sendKeys("c").keyUp(Keys.ALT).perform();
		// click(btn_clear);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn)) {
			click(yesBtn);
		}

		waitForFrameAndSwitch(FRAME);
		return this;
	}

	/**
	 * Method to close current page and return to Homepae returns the instance
	 * of Homepage
	 * 
	 * @return
	 * @author a-7868 Krishna <19-01-2018>
	 */
	public HomePage close() {

		if (verifyElementPresent(btn_close))
			click(btn_close);
		else
			driver.findElements(By.className("remove")).get(1).click();

		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn))
			click(yesBtn);
		return new HomePage(driver, dataFileName);
	}

	/**
	 * Created by A-7605 on 19-2-18 This method will accept awb with one house
	 * 
	 * @param awbPre
	 * @param awbNo
	 * @param pcs
	 * @param wt
	 * @param location
	 * @param house1
	 * @param h1Wt
	 * @param h1Pcs
	 * @param allPartsRcvd
	 * @param chkRCS
	 * @return
	 */
	public OPR335 singleHouseAcceptance(String awbPre, String awbNo,
			String pcs, String wt, String location, String house1, String h1Wt,
			String h1Pcs, boolean allPartsRcvd, boolean chkRCS) {

		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		location = PropertyHandler.getPropValue(dataFilePath, location);
		h1Pcs = PropertyHandler.getPropValue(dataFilePath, h1Pcs);
		h1Wt = PropertyHandler.getPropValue(dataFilePath, h1Wt);
		house1 = PropertyHandler.getPropValue(dataFilePath, house1);

		list(awbPre, awbNo);
		minWait();

		Assert.assertTrue(
				waitForElement(div_awbDtls).getText().contains(awbNo),
				"ERROR : AWB not listed.");
		expandLooseAcceptanceAccordin();
		enterKeys(txt_loose_pcs, pcs);
		enterKeys(txt_loose_wt, wt);
		enterKeys(loose_location, location);
		click(btn_loose_add);
		minWait();

		// house add
		click(btn_hawbAdd);
		enterKeys(hawb_txt_HAWB, house1);
		enterKeys(hawb_txt_pcs, h1Pcs);
		enterKeys(hawb_txt_wt, h1Wt);
		click(hawb_btn_add);
		minWait();
		enterKeys(hawb_btn_add, Keys.ESCAPE);
		if (allPartsRcvd)
			click(chkbox_allPartsRcvd);

		click(btn_save);
		driver.switchTo().defaultContent();

		if (verifyElementPresent(yesBtn))// LAT popup
			click(yesBtn);

		if (allPartsRcvd) {
			while (true) {
				minWait();
				if (verifyElementPresent(yesBtn))
					click(yesBtn);
				else
					break;
			}
			waitForFrameAndSwitch(FRAME);
			new WebDriverWait(driver, 60).until(ExpectedConditions
					.elementToBeClickable(btn_save));
			minWait();
			Assert.assertTrue(waitForElement(info_finalized).getText()
					.contains("Acceptance finalised"),
					"ERROR : Shipment not finalized.");
		}

		if (chkRCS)
			Assert.assertFalse(waitForElementVisible(info_rcs).getText()
					.equalsIgnoreCase("Ready for carriage"),
					"ERROR : Shipment NOT ready for carriage.");

		// click(icon_edit);
		// click(btn_clear);
		return this;
	}

	/**
	 * Method to list an AWB and verify the details listed (pcs, wt) (i.e., to
	 * check whether the AWB is available in the Station for acceptance)
	 * 
	 * @param awbPre
	 * @param awbNo
	 * @param pcs
	 * @param wt
	 * @return
	 * @author a-7868 Krishna <06/02/2018>
	 */
	public OPR335 verifyAWBAvailable(String awbPre, String awbNo, String pcs,
			String wt) {

		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);

		list(awbPre, awbNo);
		Assert.assertTrue(
				waitForElement(div_awbDtls).getText().contains(awbNo),
				"ERROR : AWB not listed.");
		Assert.assertTrue(
				waitForElement(info_awbDetails).getText().contains(pcs + " "),
				"ERROR : Incorrect pcs.");
		Assert.assertTrue(waitForElement(info_awbDetails).getText()
				.contains(wt), "ERROR : Incorrect wt.");

		return this;
	}

	/**
	 * Created by A-7605 on 19-3-18 This method perform the loose acceptance and
	 * save the checksheet details that contains free text template
	 * 
	 * @param awbPre
	 * @param awbNo
	 * @param pieces
	 * @param weight
	 * @param location
	 * @return
	 */
	public OPR335 looseAcceptWithFreeTextChecksheet(String awbPre,
			String awbNo, String pieces, String weight, String location,
			String checksheetResponse) {
		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pieces = PropertyHandler.getPropValue(dataFilePath, pieces);
		weight = PropertyHandler.getPropValue(dataFilePath, weight);
		location = PropertyHandler.getPropValue(dataFilePath, location);
		checksheetResponse = PropertyHandler.getPropValue(dataFilePath,
				checksheetResponse);

		list(awbPre, awbNo);
		minWait();
		waitForElement(btn_close);
		minWait();
		Assert.assertTrue(
				waitForElement(div_awbDtls).getText().contains(awbNo),
				"ERROR : AWB not listed.");

		expandLooseAcceptanceAccordin();
		enterKeys(txt_loose_pcs, pieces);
		enterKeys(txt_loose_wt, weight);
		enterKeys(loose_location, location);
		click(btn_loose_add);
		minWait();

		check(chkbox_allPartsRcvd);

		click(btn_save);
		driver.switchTo().defaultContent();
		boolean isChecksheetBlockExists = false;
		while (true) {
			if (verifyElementPresent(yesBtn)) {
				if (waitForElement(msg_popup).getText().contains(
						"Acceptance check sheet not complete"))
					isChecksheetBlockExists = true;
				click(yesBtn);
				minWait();
			} else
				break;
		}
		Assert.assertTrue(isChecksheetBlockExists,
				"Checksheet block does not exist");
		waitForFrameAndSwitch(FRAME);
		click(link_checksheet);
		driver.switchTo().frame(waitForElement(frame_popupContainerFrame));
		enterKeys(captureChecksheet_txt_freeText, checksheetResponse);
		check(chksht_btn_save);
		driver.switchTo().defaultContent();
		click(okBtn);
		waitForFrameAndSwitch(FRAME);
		driver.switchTo().frame(waitForElement(frame_popupContainerFrame));
		minWait();
		try {
			waitForElement(chksht_btn_close).click();
		} catch (StaleElementReferenceException e) {
		}
		minWait();
		driver.switchTo().defaultContent();
		waitForFrameAndSwitch(FRAME);
		click(btn_save);
		driver.switchTo().defaultContent();
		while (true) {
			if (verifyElementPresent(yesBtn)) {
				click(yesBtn);
				minWait();
			} else
				break;
		}
		minWait();
		waitForFrameAndSwitch(FRAME);
		Assert.assertTrue(
				waitForElement(info_finalized).getText().contains(
						"Acceptance finalised"),
				"ERROR : Shipment not finalized.");
		return this;
	}

	/**
	 * @author A-8260
	 * @param awbPre
	 * @param awbNo
	 * @param pcs
	 * @param wt
	 * @param vol
	 * @param location
	 * @param allPartsRcvd
	 * @return
	 */
	public OPR335 simpleAcceptanceSecureSCCBlockSetupCheck(String awbPre,
			String awbNo, String pcs, String wt, String vol, String location,
			boolean allPartsRcvd) {

		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		if (!vol.equals(""))
			vol = PropertyHandler.getPropValue(dataFilePath, vol);
		location = PropertyHandler.getPropValue(dataFilePath, location);

		list(awbPre, awbNo);
		minWait();
		minWait();
		Assert.assertTrue(
				waitForElement(div_awbDtls).getText().contains(awbNo),
				"ERROR : AWB not listed.");

		click(div_looseAcc);
		enterKeys(txt_loose_pcs, pcs + Keys.TAB);
		enterKeys(txt_loose_wt, wt);
		// if(!vol.equals("")) enterKeys(txt_loose_vol, vol);
		enterKeys(loose_location, location);
		click(btn_loose_add);
		minWait();

		if (allPartsRcvd)
			check(chkbox_allPartsRcvd);

		click(btn_save);
		driver.switchTo().defaultContent();

		if (verifyElementPresent(yesBtn))// LAT popup
			click(yesBtn);

		waitForFrameAndSwitch(FRAME);
		minWait();
		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn)) {
			click(yesBtn);
		}
		waitForFrameAndSwitch(FRAME);

		System.out.println(driver.findElement(info_finalized).getText());
		if (waitForElement(info_finalized).getText().equals(
				"Acceptance finalised"))
			Assert.assertTrue(
					waitForElement(info_finalized).getText().equals(
							"Acceptance finalised"),
					"Acceptance has been finalized");

		if (verifyElementPresent(info_finalized))
			if (driver.findElement(info_finalized).getText()
					.equals("Acceptance not finalised"))
				click(info_finalized);
		if (verifyElementPresent(msg_acc_finl))

			if ((driver.findElement(msg_acc_finl).getText()
					.equals("Blocked for Screening")))
				Assert.assertTrue(waitForElement(msg_acc_finl).getText()
						.contains("Blocked for Screening"),
						"Screening block  validation successful");

		click(icon_edit);
		click(btn_clear);
		return this;
	}

	/**
	 * @author A-8260
	 * @param awbPre
	 * @param awbNo
	 * @param pcs
	 * @param wt
	 * @param location
	 * @param result
	 * @param alPrtRcvd
	 * @return
	 */

	public OPR335 screeningWithNoSecureSCC(String awbPre, String awbNo,
			String pcs, String wt, String location, boolean result,
			boolean alPrtRcvd) {
		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		location = PropertyHandler.getPropValue(dataFilePath, location);

		list(awbPre, awbNo);
		if (alPrtRcvd)
			click(chkbox_allPartsRcvd);
		enterKeys(txt_loose_pcs, pcs + Keys.TAB);
		enterKeys(txt_loose_wt, wt);
		enterKeys(loose_location, location);
		click(btn_loose_add);
		click(tab_secScrDet);
		click(tab_expand);
		waitForFrameAndSwitch(subFRAME);
		// waitForElement(txt_pcs);
		minWait();
		enterKeys(txt_pcs, pcs + Keys.TAB);
		enterKeys(txt_wt, wt);
		selectByIndex(selMethd, 2);
		if (result)
			selectByText(selResult, "Pass");
		else
			selectByText(selResult, "Fail");
		minWait();
		click(btn_Add);
		// click(chk_secRev);
		scrollToView(btnOk);
		click(btnOk);
		// waitForFrameAndSwitch(FRAME);
		driver.switchTo().defaultContent();
		waitForFrameAndSwitch(FRAME);
		click(btnSave);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn)) {
			if (result == false) {
				if (alPrtRcvd)
					Assert.assertTrue(waitForElement(msg_warn).getText()
							.contains("Blocked for Screening"),
							"Warning Message should be Blocked for Screening");
				else
					Assert.assertTrue(waitForElement(msg_warn).getText()
							.contains("All parts received not checked"),
							"Warning Message should be Blocked for Screening");
				click(yesBtn);
			} else
				click(yesBtn);

		}

		waitForFrameAndSwitch(FRAME);
		click(tab_secScrDet);
		click(tab_expand);
		minWait();
		// driver.switchTo().defaultContent();

		waitForFrameAndSwitch(subFRAME);
		minWait();
		click(tab_shipmnt);
		Assert.assertTrue(waitForElement(lbl_scc).getText().equals("GEN"),
				"Unsecure SCC should not be captured");

		return this;
	}

	/**
	 * @author A-8260
	 * @param awbPre
	 * @param awbNo
	 * @param accPc
	 * @param accWt
	 * @param scrPc
	 * @param scrWt
	 * @param location
	 * @param result
	 * @param alPrtRcvd
	 * @return
	 */

	public OPR335 screeningWithStatedAcceptancePieces(String awbPre,
			String awbNo, String accPc, String accWt, String scrPc,
			String scrWt, String location, boolean result, boolean alPrtRcvd) {
		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		accPc = PropertyHandler.getPropValue(dataFilePath, accPc);
		accWt = PropertyHandler.getPropValue(dataFilePath, accWt);
		scrPc = PropertyHandler.getPropValue(dataFilePath, scrPc);
		scrWt = PropertyHandler.getPropValue(dataFilePath, scrWt);
		location = PropertyHandler.getPropValue(dataFilePath, location);

		list(awbPre, awbNo);
		if (alPrtRcvd)
			click(chkbox_allPartsRcvd);
		click(txt_loose_pcs);
		enterKeys(txt_loose_pcs, accPc);
		click(txt_loose_wt);
		enterKeys(txt_loose_wt, accWt);
		enterKeys(loose_location, location);
		click(btn_loose_add);
		click(tab_secScrDet);
		click(tab_expand);
		waitForFrameAndSwitch(subFRAME);
		// waitForElement(txt_pcs);
		minWait();
		enterKeys(txt_pcs, scrPc + Keys.TAB);
		enterKeys(txt_wt, scrWt);
		selectByIndex(selMethd, 2);
		if (result)
			selectByText(selResult, "Pass");
		else
			selectByText(selResult, "Fail");
		minWait();
		click(btn_Add);
		// click(chk_secRev);
		scrollToView(btnOk);
		click(btnOk);
		// waitForFrameAndSwitch(FRAME);
		driver.switchTo().defaultContent();
		// verifying saved pieces details
		if (verifyElementPresent(yesBtn)) {
			click(yesBtn);
		}
		// verifying block release
		if (verifyElementPresent(yesBtn)) {
			click(yesBtn);
		}
		waitForFrameAndSwitch(FRAME);
		click(btnSave);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn)) {
			if (result == false) {
				if (alPrtRcvd)
					Assert.assertTrue(waitForElement(msg_warn).getText()
							.contains("Blocked for Screening"),
							"Warning Message should be Blocked for Screening");
				else
					Assert.assertTrue(waitForElement(msg_warn).getText()
							.contains("All parts received not checked"),
							"Warning Message should be Blocked for Screening");
				click(yesBtn);
			} else
				click(yesBtn);

		}

		waitForFrameAndSwitch(FRAME);
		click(tab_secScrDet);
		click(tab_expand);
		minWait();
		// driver.switchTo().defaultContent();

		waitForFrameAndSwitch(subFRAME);
		minWait();
		click(tab_secDet);
		Assert.assertTrue(waitForElement(chk_Sec_Revd).isSelected(),
				"Security Data Reviewed should be selected");
		Assert.assertTrue(waitForElement(chk_secsttsgvn).isSelected(),
				"Security Data Reviewed should be selected");
		click(tab_shipmnt);
		Assert.assertTrue(waitForElement(lbl_scc).getText().contains("SPX"),
				"Secure SCC should be finalized");
		driver.switchTo().defaultContent();
		waitForFrameAndSwitch(FRAME);
		click(tab_collapse);
		if (!(alPrtRcvd))
			click(chkbox_allPartsRcvd);
		click(btnSave);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn)) {
			click(yesBtn);
		}
		waitForFrameAndSwitch(FRAME);
		minWait();
		minWait();
		// System.out.println(driver.findElement(info_Acceptance_label).getAttribute("innerText"));
		Assert.assertTrue(waitForElement(info_Acceptance_label).getText()
				.contains("Acceptance finalised"),
				"Acceptance should be finalised");
		return this;
	}

	/**
	 * @author A-8260
	 * @param awbPre
	 * @param awbNo
	 * @param accPc
	 * @param accWt
	 * @param scrPc
	 * @param scrWt
	 * @param location
	 * @param result
	 * @param alPrtRcvd
	 * @return
	 */
	public OPR335 saveScreenedPieces(String awbPre, String awbNo, String accPc,
			String accWt, String scrPc, String scrWt, String location,
			boolean result, boolean alPrtRcvd) {
		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		accPc = PropertyHandler.getPropValue(dataFilePath, accPc);
		accWt = PropertyHandler.getPropValue(dataFilePath, accWt);
		scrPc = PropertyHandler.getPropValue(dataFilePath, scrPc);
		scrWt = PropertyHandler.getPropValue(dataFilePath, scrWt);
		location = PropertyHandler.getPropValue(dataFilePath, location);

		list(awbPre, awbNo);
		if (alPrtRcvd)
			click(chkbox_allPartsRcvd);
		click(txt_loose_pcs);
		enterKeys(txt_loose_pcs, accPc);
		click(txt_loose_wt);
		enterKeys(txt_loose_wt, accWt);
		enterKeys(loose_location, location);
		click(btn_loose_add);
		click(tab_secScrDet);
		click(tab_expand);
		waitForFrameAndSwitch(subFRAME);

		minWait();
		enterKeys(txt_pcs, scrPc + Keys.TAB);
		enterKeys(txt_wt, scrWt);
		selectByIndex(selMethd, 2);
		if (result)
			selectByText(selResult, "Pass");
		else
			selectByText(selResult, "Fail");
		minWait();
		click(btn_Add);

		scrollToView(btnOk);
		click(btnOk);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(noBtn)) {
			click(noBtn);
		}
		if (verifyElementPresent(noBtn)) {
			click(noBtn);
		}
		driver.switchTo().frame(FRAME);
		driver.switchTo().frame(subFRAME);
		// waitForFrameAndSwitch(subFRAME);
		Assert.assertTrue(waitForElement(lbl_scr_svd).getAttribute("innerText")
				.contains(scrPc), "Screened pieces should be saved");
		Assert.assertTrue(waitForElement(lbl_scr_svd).getAttribute("innerText")
				.contains(scrWt), "Screened weight should be saved");
		return this;
	}

	/**
	 * short capture AWB secure SSC
	 * 
	 * @author A-8260
	 **/

	public OPR335 shortCaptureAwbSecureSCC(String stock, String awbPre,
			String awbNo, String pcs, String wt, String Destination,
			String location, String scc, boolean allPartsRcvd) {
		stock = PropertyHandler.getPropValue(dataFilePath, stock);
		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		Destination = PropertyHandler.getPropValue(dataFilePath, Destination);
		// carrierCode = PropertyHandler.getPropValue(dataFilePath,
		// carrierCode);
		// flightno = PropertyHandler.getPropValue(dataFilePath, flightno);
		// fltDate = PropertyHandler.getPropValue(dataFilePath, fltDate);
		location = PropertyHandler.getPropValue(dataFilePath, location);
		scc = PropertyHandler.getPropValue(dataFilePath, scc);

		StockType stockType = StockType.valueOf(stock);
		awbNo = getAWB(stockType, awbPre, awbNo);
		// check(chkbox_transshipment);

		// list(awbPre, awbNo);
		minWait();

		// Assert.assertTrue(waitForElement(div_awbDtls).getText().contains(awbNo),
		// "ERROR : AWB not listed.");

		// enterKeys(txt_origin, Origin);
		enterKeys(txt_destination, Destination);
		enterKeys(txt_mastrStatedPieces, pcs);
		enterKeys(txt_mastrStatedWt, wt);
		enterKeys(txt_shpmntdescription, "Remarks");
		enterKeys(txt_scc, scc);

		// click(div_looseAcc);
		enterKeys(txt_loose_pcs, pcs);
		enterKeys(txt_loose_wt, wt);
		enterKeys(loose_location, location);
		click(btn_loose_add);
		minWait();
		// enterKeys(txt_inboundCarrier, carrierCode);
		// enterKeys(txt_inboundFlt, flightno);
		// enterKeys(txt_inboundFltDt, fltDate);

		if (allPartsRcvd)
			check(chkbox_allPartsRcvd);

		click(btn_save);
		driver.switchTo().defaultContent();

		if (verifyElementPresent(yesBtn))// LAT popup
			click(yesBtn);
		if (verifyElementPresent(yesBtn))// save popup
			click(yesBtn);

		waitForFrameAndSwitch(FRAME);
		if (allPartsRcvd)
			minWait();
		minWait();
		minWait();
		if (waitForElement(info_finalized).getText().equals(
				"Acceptance finalised"))
			Assert.assertTrue(waitForElement(info_finalized).getText()
					.contains("Acceptance finalised"),
					"ERROR : Shipment not finalized.");
		if (waitForElement(info_finalized).getText().equals(
				"Acceptance not finalised"))
			click(info_Acceptance_label);
		if (verifyElementPresent(msg_acc_finl))
			Assert.assertTrue(
					waitForElement(msg_acc_finl).getText().contains(
							"Blocked for Screening"),
					"Screening block  validation successful");

		return this;

	}

	public String getAWB(StockType stock, String awbPre, String awb) {

		String awbNo;
		while (true) {
			awbNo = BizUtility.createAWBNum(stock);
			enterKeys((txt_awbPre), awbPre);
			enterKeys(txt_awbNo, awbNo);
			click(btn_list);
			maxWait();
			driver.switchTo().defaultContent();
			if (verifyElementPresent(yesBtn)) {

				if (waitForElement(info_genericMsg).getText().contains(
						"executed")) {
					click(noBtn);
					waitForFrameAndSwitch(FRAME);
					continue;
				}
				click(yesBtn);
				waitForFrameAndSwitch(FRAME);
				break;
			}
			waitForFrameAndSwitch(FRAME);
			click(btn_clear);
		}
		PropertyHandler.setPropValue(dataFilePath, awb, awbNo);

		return awbNo;
	}

	/**
	 * @author A-8260
	 * @param awbPre
	 * @param awbNo
	 * @param pcs
	 * @param wt
	 * @return
	 */
	public OPR335 checkSecurityDataReviewed(String awbPre, String awbNo,
			String pcs, String wt) {
		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);

		list(awbPre, awbNo);

		click(tab_secScrDet);
		click(tab_expand);
		enterKeys(txt_pcs, pcs + Keys.TAB);
		enterKeys(txt_wt, wt);
		selectByValue(selResult, "Pass");
		minWait();
		click(chk_secRev);
		scrollToView(btnOk);
		click(btnSave);
		if (verifyElementPresent(yesBtn))
			click(yesBtn);

		return this;
	}

	/**
	 * @author A-8260
	 * @param awbPre
	 * @param awbNo
	 * @param pcs
	 * @param wt
	 * @param location
	 * @param accFin
	 * @return
	 */

	public OPR335 checkAcceptanceFinalizedAllpartsReceivedCheck(String awbPre,
			String awbNo, String pcs, String wt, String location, boolean accFin) {
		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		location = PropertyHandler.getPropValue(dataFilePath, location);
		list(awbPre, awbNo);
		minWait();

		check(chkbox_allPartsRcvd);
		enterKeys(txt_loose_pcs, pcs + Keys.TAB);
		enterKeys(txt_loose_wt, wt);
		// if(!vol.equals("")) enterKeys(txt_loose_vol, vol);
		enterKeys(loose_location, location);
		click(btn_loose_add);
		minWait();
		click(btn_save);
		driver.switchTo().defaultContent();

		if (verifyElementPresent(yesBtn))// LAT popup
			click(yesBtn);
		waitForFrameAndSwitch(FRAME);
		minWait();
		System.out.println(getText_JS(info_Acceptance_label));
		if (accFin)
			Assert.assertTrue(driver.findElement(info_Acceptance_label)
					.getText().contains("Acceptance finalised"),
					"Acceptance finalised");
		else {
			System.out.println(waitForElement(info_Acceptance_label).getText());

			Assert.assertTrue(waitForElement(info_Acceptance_label).getText()
					.contains("Acceptance not finalised"),
					"Acceptance should not be finalised");
		}
		return this;
	}

	/**
	 * @author A-8260
	 * @param awbPrefix
	 * @param awbNo
	 * @param finalized
	 * @return
	 */

	public OPR335 listAndSaveAcceptanceFinalized(String awbPrefix,
			String awbNo, boolean finalized) {
		awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		list(awbPrefix, awbNo);
		minWait();
		click(btn_save);
		driver.switchTo().defaultContent();

		if (verifyElementPresent(yesBtn))// LAT popup
			click(yesBtn);
		waitForFrameAndSwitch(FRAME);
		if (finalized)
			Assert.assertTrue(driver.findElement(info_Acceptance_label)
					.getText().contains("Acceptance finalised"),
					"Acceptance should be finalised");
		else
			Assert.assertTrue(driver.findElement(info_Acceptance_label)
					.getText().contains("Acceptance not finalised"),
					"Acceptance should not befinalised");
		return this;
	}

	/**
	 * Method to verify whether the All Parts Received checkbox is checked.
	 * 
	 * @param awbPre
	 * @param awbNo
	 * @return
	 * @author A-7868 Krishna <02/04/2018>
	 */
	public OPR335 verifyAllPartsRcvd(String awbPre, String awbNo) {

		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		list(awbPre, awbNo);
		minWait();

		Assert.assertTrue(waitForElement(chkbox_allPartsRcvd).isSelected(),
				"ERROR : All parts received checkbox not checked.");

		return this;
	}

	/**
	 * Method to verify whether the All Parts Received checkbox is NOT checked.
	 * 
	 * @param awbPre
	 * @param awbNo
	 * @return
	 * @author A-7868 Krishna <03/04/2018>
	 */
	public OPR335 verifyAllPartsRcvdNotChecked(String awbPre, String awbNo) {

		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		list(awbPre, awbNo);
		minWait();

		Assert.assertFalse(waitForElement(chkbox_allPartsRcvd).isSelected(),
				"ERROR : All parts received checkbox checked.");

		return this;
	}

	/**
	 * Method to list an AWB and edit the loose acceptance details
	 * 
	 * @param awbPre
	 * @param awbNo
	 * @param pcs
	 * @param wt
	 * @param loc
	 * @param allPartsRcvd
	 * @param chkRCS
	 * @param errorChk
	 * @param errorMsg
	 * @return
	 * @author A-7868 Krishna <09/04/2018>
	 */
	public OPR335 editLooseAcceptance(String awbPre, String awbNo, String pcs,
			String wt, String vol, String loc, boolean allPartsRcvd,
			boolean chkRCS, boolean errorChk, String errorMsg) {

		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		if (!vol.equals(""))
			vol = PropertyHandler.getPropValue(dataFilePath, vol);
		loc = PropertyHandler.getPropValue(dataFilePath, loc);
		errorMsg = PropertyHandler.getPropValue(dataFilePath, errorMsg);

		list(awbPre, awbNo);
		minWait();

		scrollToView(btn_editAccPcs);
		click(btn_editAccPcs);
		enterKeys(txt_loose_pcs, pcs + Keys.TAB);
		enterKeys(txt_loose_wt, wt);

		if (allPartsRcvd)
			check(chkbox_allPartsRcvd);

		click(btn_save);
		driver.switchTo().defaultContent();

		if (verifyElementPresent(yesBtn))// LAT popup
			click(yesBtn);

		if (errorChk) {
			waitForFrameAndSwitch(FRAME);
			Assert.assertTrue(
					waitForElement(info_errorMsg).getText().contains(errorMsg),
					"ERROR : Error message not shown.");
		} else {

			if (allPartsRcvd) {
				if (verifyElementPresent(yesBtn))
					click(yesBtn);
				waitForFrameAndSwitch(FRAME);
				Assert.assertTrue(waitForElement(info_finalized).getText()
						.contains("Acceptance finalised"),
						"ERROR : Shipment not finalized.");
			} else {
				if (verifyElementPresent(yesBtn)) {
					Assert.assertTrue(waitForElement(msg_popup).getText()
							.contains("All parts received not checked"),
							"ERROR : Warning message not shown.");
					click(yesBtn);
				}
				waitForFrameAndSwitch(FRAME);
				Assert.assertTrue(waitForElement(info_finalized).getText()
						.contains("Acceptance not finalised"),
						"ERROR : In Shipment status.");
			}

			if (chkRCS) {

				Assert.assertFalse(waitForElementVisible(info_rcs)
						.getAttribute("class").contains("icon rejected"),
						"ERROR : Shipment NOT ready for carriage.");
			} else
				minWait();
			// Assert.assertTrue(waitForElement(info_rcs).getAttribute("class").contains("icon rejected"),
			// "ERROR : Shipment NOT ready for carriage.");

		}

		click(icon_edit);
		click(btn_clear);
		return this;
	}

	/**
	 * Created by A-7605 o 19-4-18 This method perform goods acceptance to two
	 * houses
	 * 
	 * @param awbPre
	 * @param awbNo
	 * @param pcs
	 * @param wt
	 * @param location
	 * @param house1
	 * @param h1Wt
	 * @param h1Pcs
	 * @param house2
	 * @param h2Wt
	 * @param h2Pcs
	 * @param allPartsRcvd
	 * @param chkRCS
	 * @return
	 */
	public OPR335 twoHouseAcceptance(String awbPre, String awbNo, String pcs,
			String wt, String location, String house1, String h1Wt,
			String h1Pcs, String house2, String h2Wt, String h2Pcs,
			boolean allPartsRcvd, boolean chkRCS) {

		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		location = PropertyHandler.getPropValue(dataFilePath, location);
		h1Pcs = PropertyHandler.getPropValue(dataFilePath, h1Pcs);
		h1Wt = PropertyHandler.getPropValue(dataFilePath, h1Wt);
		house1 = PropertyHandler.getPropValue(dataFilePath, house1);
		h2Pcs = PropertyHandler.getPropValue(dataFilePath, h2Pcs);
		h2Wt = PropertyHandler.getPropValue(dataFilePath, h2Wt);
		house2 = PropertyHandler.getPropValue(dataFilePath, house2);

		list(awbPre, awbNo);
		minWait();

		Assert.assertTrue(
				waitForElement(div_awbDtls).getText().contains(awbNo),
				"ERROR : AWB not listed.");
		expandLooseAcceptanceAccordin();
		enterKeys(txt_loose_pcs, pcs);
		enterKeys(txt_loose_wt, wt);
		enterKeys(loose_location, location);
		click(btn_loose_add);
		minWait();

		// house add
		click(btn_hawbAdd);
		enterKeys(hawb_txt_HAWB, house1);
		enterKeys(hawb_txt_pcs, h1Pcs);
		enterKeys(hawb_txt_wt, h1Wt);
		click(hawb_btn_add);
		minWait();
		enterKeys(hawb_txt_HAWB, house2);
		enterKeys(hawb_txt_pcs, h2Pcs);
		enterKeys(hawb_txt_wt, h2Wt);
		click(hawb_btn_add);
		minWait();
		enterKeys(hawb_btn_add, Keys.ESCAPE);
		if (allPartsRcvd)
			click(chkbox_allPartsRcvd);

		click(btn_save);
		driver.switchTo().defaultContent();

		if (verifyElementPresent(yesBtn))// LAT popup
			click(yesBtn);

		if (allPartsRcvd) {
			while (true) {
				minWait();
				if (verifyElementPresent(yesBtn)) {
					click(yesBtn);
				} else
					break;
			}
			waitForFrameAndSwitch(FRAME);
			Assert.assertTrue(waitForElement(info_finalized).getText()
					.contains("Acceptance finalised"),
					"ERROR : Shipment not finalized.");
		}

		if (chkRCS)
			Assert.assertFalse(waitForElementVisible(info_rcs).getText()
					.equalsIgnoreCase("Ready for carriage"),
					"ERROR : Shipment NOT ready for carriage.");

		// click(icon_edit);
		// click(btn_clear);
		return this;
	}

	/**
	 * Created by A-7605 o 19-4-18 This method perform goods acceptance to two
	 * houses
	 * 
	 * @param awbPre
	 * @param awbNo
	 * @param pcs
	 * @param wt
	 * @param location
	 * @param house1
	 * @param h1Wt
	 * @param h1Pcs
	 * @param house2
	 * @param h2Wt
	 * @param h2Pcs
	 * @param allPartsRcvd
	 * @param chkRCS
	 * @param companyCode
	 * @param uldNo
	 * @return
	 */
	public OPR335 twoHouseULDAcceptance(String awbPre, String awbNo,
			String pcs, String wt, String location, String house1, String h1Wt,
			String h1Pcs, String house2, String h2Wt, String h2Pcs,
			boolean allPartsRcvd, boolean chkRCS, String companyCode,
			String uldNo) {

		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		location = PropertyHandler.getPropValue(dataFilePath, location);
		h1Pcs = PropertyHandler.getPropValue(dataFilePath, h1Pcs);
		h1Wt = PropertyHandler.getPropValue(dataFilePath, h1Wt);
		house1 = PropertyHandler.getPropValue(dataFilePath, house1);
		h2Pcs = PropertyHandler.getPropValue(dataFilePath, h2Pcs);
		h2Wt = PropertyHandler.getPropValue(dataFilePath, h2Wt);
		house2 = PropertyHandler.getPropValue(dataFilePath, house2);
		companyCode = PropertyHandler.getPropValue(dataFilePath, companyCode);

		list(awbPre, awbNo);
		minWait();

		Assert.assertTrue(
				waitForElement(div_awbDtls).getText().contains(awbNo),
				"ERROR : AWB not listed.");
		scrollToView(div_ULDAcc);
		click(div_ULDAcc);
		enterKeys((txt_uld_pcs), pcs);
		enterKeys(txt_uld_wt, wt);
		if (waitForElement(txt_uld_location).isEnabled())
			enterKeys(txt_uld_location, location);

		String uld = null;
		int count = 0;

		while (count < 5) {
			uld = BizUtility.createULDNum("AKE", companyCode);
			enterKeys(txt_uldNum, uld);
			// enterKeys(txt_uldNum, Keys.TAB);
			minWait();
			//
			driver.switchTo().defaultContent();
			if (verifyElementPresent(yesBtn)) {
				click(yesBtn);
				waitForFrameAndSwitch(FRAME);
				break;
			}
			waitForFrameAndSwitch(FRAME);
			count++;
		}
		minWait();
		click(btn_uld_add);
		PropertyHandler.setPropValue(dataFilePath, uldNo, uld.trim());
		minWait();

		// house add
		click(btn_hawbAdd);
		enterKeys(hawb_txt_HAWB, house1);
		enterKeys(hawb_txt_pcs, h1Pcs);
		enterKeys(hawb_txt_wt, h1Wt);
		click(hawb_btn_add);
		minWait();
		enterKeys(hawb_txt_HAWB, house2);
		enterKeys(hawb_txt_pcs, h2Pcs);
		enterKeys(hawb_txt_wt, h2Wt);
		click(hawb_btn_add);
		minWait();
		enterKeys(hawb_btn_add, Keys.ESCAPE);
		if (allPartsRcvd)
			click(chkbox_allPartsRcvd);

		click(btn_save);
		driver.switchTo().defaultContent();

		if (verifyElementPresent(yesBtn))// LAT popup
			click(yesBtn);

		if (allPartsRcvd) {
			if (verifyElementPresent(yesBtn))
				click(yesBtn);
			minWait();
			waitForFrameAndSwitch(FRAME);
			Assert.assertTrue(waitForElement(info_finalized).getText()
					.contains("Acceptance finalised"),
					"ERROR : Shipment not finalized.");
		}

		if (chkRCS)
			Assert.assertFalse(waitForElementVisible(info_rcs).getText()
					.equalsIgnoreCase("Ready for carriage"),
					"ERROR : Shipment NOT ready for carriage.");

		click(icon_edit);
		click(btn_clear);
		return this;
	}

	private void expandULDAcceptanceAccordin() {

		while (true) {
			minWait();
			WebElement uldAcceptancePiece = driver.findElement(txt_uld_pcs);
			if (uldAcceptancePiece.isDisplayed())
				break;
			click(div_ULDAcc);
		}
		minWait();
	}

	/**
	 * Created by A-7605 on 27-4-18 This method accepts a single shipment into 3
	 * ULDs
	 * 
	 * @param compCode
	 * @param awbPre
	 * @param awbNo
	 * @param uldNo1
	 * @param pieces1
	 * @param weight1
	 * @param location1
	 * @param uldNo2
	 * @param pieces2
	 * @param weight2
	 * @param location2
	 * @param uldNo3
	 * @param pieces3
	 * @param weight3
	 * @param location3
	 * @param allPartsRcvd
	 * @param errChk
	 * @param errorMsg
	 * @return
	 */
	public OPR335 acceptanceToThreeULDs(String compCode, String awbPre,
			String awbNo, String uldNo1, String pieces1, String weight1,
			String location1, String uldNo2, String pieces2, String weight2,
			String location2, String uldNo3, String pieces3, String weight3,
			String location3, boolean allPartsRcvd, boolean errChk,
			String errorMsg) {

		compCode = PropertyHandler.getPropValue(dataFilePath, compCode);
		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pieces1 = PropertyHandler.getPropValue(dataFilePath, pieces1);
		weight1 = PropertyHandler.getPropValue(dataFilePath, weight1);
		location1 = PropertyHandler.getPropValue(dataFilePath, location1);
		pieces2 = PropertyHandler.getPropValue(dataFilePath, pieces2);
		weight2 = PropertyHandler.getPropValue(dataFilePath, weight2);
		location2 = PropertyHandler.getPropValue(dataFilePath, location2);
		pieces3 = PropertyHandler.getPropValue(dataFilePath, pieces3);
		weight3 = PropertyHandler.getPropValue(dataFilePath, weight3);
		location3 = PropertyHandler.getPropValue(dataFilePath, location3);

		list(awbPre, awbNo);
		waitForElement(div_ULDAcc);
		expandULDAcceptanceAccordin();
		scrollToView(div_ULDAcc);
		enterKeys((txt_uld_pcs), pieces1);
		enterKeys(txt_uld_wt, weight1);
		if (waitForElement(txt_uld_location).isEnabled())
			enterKeys(txt_uld_location, location1);
		String uld = null;
		int count = 0;

		while (count < 5) {
			uld = BizUtility.createULDNum("AKE", compCode);
			enterKeys(txt_uldNum, uld);
			enterKeys(txt_uldNum, Keys.TAB);
			minWait();
			driver.switchTo().defaultContent();
			if (verifyElementPresent(yesBtn)) {
				click(yesBtn);
				waitForFrameAndSwitch(FRAME);
				break;
			}
			waitForFrameAndSwitch(FRAME);
			count++;
		}
		minWait();
		click(btn_uld_add);
		PropertyHandler.setPropValue(dataFilePath, uldNo1, uld.trim());

		enterKeys((txt_uld_pcs), pieces2);
		enterKeys(txt_uld_wt, weight2);
		if (waitForElement(txt_uld_location).isEnabled())
			enterKeys(txt_uld_location, location2);
		uld = null;
		count = 0;

		while (count < 5) {
			uld = BizUtility.createULDNum("AKE", compCode);
			enterKeys(txt_uldNum, uld);
			enterKeys(txt_uldNum, Keys.TAB);
			minWait();
			driver.switchTo().defaultContent();
			if (verifyElementPresent(yesBtn)) {
				click(yesBtn);
				waitForFrameAndSwitch(FRAME);
				break;
			}
			waitForFrameAndSwitch(FRAME);
			count++;
		}
		minWait();
		click(btn_uld_add);
		PropertyHandler.setPropValue(dataFilePath, uldNo2, uld.trim());

		enterKeys((txt_uld_pcs), pieces3);
		enterKeys(txt_uld_wt, weight3);
		if (waitForElement(txt_uld_location).isEnabled())
			enterKeys(txt_uld_location, location3);
		uld = null;
		count = 0;

		while (count < 5) {
			uld = BizUtility.createULDNum("AKE", compCode);
			enterKeys(txt_uldNum, uld);
			enterKeys(txt_uldNum, Keys.TAB);
			minWait();
			driver.switchTo().defaultContent();
			if (verifyElementPresent(yesBtn)) {
				click(yesBtn);
				waitForFrameAndSwitch(FRAME);
				break;
			}
			waitForFrameAndSwitch(FRAME);
			count++;
		}
		minWait();
		click(btn_uld_add);
		PropertyHandler.setPropValue(dataFilePath, uldNo3, uld.trim());

		if (allPartsRcvd)
			check(chkbox_allPartsRcvd);

		click(btn_save);
		driver.switchTo().defaultContent();

		if (verifyElementPresent(yesBtn))// LAT popup
			click(yesBtn);

		if (errChk) {
			waitForFrameAndSwitch(FRAME);
			errorMsg = PropertyHandler.getPropValue(dataFilePath, errorMsg);
			Assert.assertTrue(
					waitForElement(info_errorMsg).getText().contains(errorMsg),
					"ERROR : Error message not shown.");

		} else {
			if (allPartsRcvd) {
				if (verifyElementPresent(yesBtn))
					click(yesBtn);
				waitForFrameAndSwitch(FRAME);
				maxWait();
				Assert.assertTrue(waitForElement(info_finalized).getText()
						.contains("Acceptance finalised"),
						"ERROR : Shipment not finalized.");
			} else {
				if (verifyElementPresent(yesBtn)) {
					Assert.assertTrue(waitForElement(msg_popup).getText()
							.contains("All parts received not checked"),
							"ERROR : Warning message not shown.");
					click(yesBtn);
				}
				waitForFrameAndSwitch(FRAME);
				Assert.assertTrue(waitForElement(info_finalized).getText()
						.contains("Acceptance not finalised"),
						"ERROR : In Shipment status.");
			}
		}

		return this;
	}

	/**
	 * Method to list an awb and verify the accepted pcs
	 * 
	 * @param awbPre
	 * @param awbNo
	 * @param pcs
	 * @param wt
	 * @return
	 * @author A-7868 Krishna <30/04/2018>
	 */
	public OPR335 verifyAcceptedPcs(String awbPre, String awbNo, String pcs) {

		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);

		list(awbPre, awbNo);
		click(div_looseAcc);
		Assert.assertTrue(waitForElement(lbl_totAccPcs).getText().equals(pcs),
				"ERROR : Pcs mismatch.");
		return this;
	}

	/**
	 * Method to list an AWB and check if its Finalised
	 * 
	 * @param awbPre
	 * @param awbNo
	 * @param finStat
	 *            (true: Finalised; false: Not Finalised)
	 * @return
	 * @author A-7868 Krishna <30/04/2018>
	 */
	public OPR335 checkIfAccFinalised(String awbPre, String awbNo,
			boolean finStat) {

		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);

		list(awbPre, awbNo);

		if (finStat)
			Assert.assertTrue(waitForElement(info_finalized).getText()
					.contains("Acceptance finalised"),
					"ERROR : Shipment Not Finalised.");
		else
			Assert.assertFalse(waitForElement(info_finalized).getText()
					.contains("Acceptance finalised"),
					"ERROR : Shipment Finalised.");

		return this;
	}

	/**
	 * Method to verify the total Loose Acceptance Pcs/Wt
	 * 
	 * @param awbPre
	 * @param awbNo
	 * @param pcs
	 * @param wt
	 * @return
	 * @author A-7868 Krishna <02/05/2018>
	 */
	public OPR335 verifyLooseAccPcsWt(String awbPre, String awbNo, String pcs,
			String wt) {

		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);

		list(awbPre, awbNo);
		Assert.assertTrue(waitForElement(lbl_totalLoosePcs).getText().trim()
				.contains(pcs), "ERROR : Pcs mismatch.");
		Assert.assertTrue(waitForElement(lbl_totalLooseWt).getText().trim()
				.contains(wt), "ERROR : Wt mismatch.");
		return this;
	}

	/**
	 * Method to verify the total accepted pcs/wt under ULD acceptance
	 * 
	 * @param awbPre
	 * @param awbNo
	 * @param pcs
	 * @param wt
	 * @return
	 * @author A-7868 Krishna <02/05/2018>
	 */
	public OPR335 verifyULDAccPcsWt(String awbPre, String awbNo, String pcs,
			String wt) {

		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);

		list(awbPre, awbNo);
		Assert.assertTrue(waitForElement(lbl_totalULDPcs).getText().trim()
				.contains(pcs), "ERROR : Pcs mismatch.");
		Assert.assertTrue(waitForElement(lbl_totalULDWt).getText().trim()
				.contains(wt), "ERROR : Wt mismatch.");
		return this;
	}

	/**
	 * @author A-8260
	 * @param awbPre
	 * @param awbNo
	 * @param accPc
	 * @param accWt
	 * @param location
	 * @param result
	 * @param alPrtRcvd
	 * @return
	 */
	public OPR335 validateScreeningMethods(String awbPre, String awbNo,
			String accPc, String accWt, String location, boolean result,
			boolean alPrtRcvd) {

		String date = new SimpleDateFormat("dd-MMM-yyyy").format(Calendar
				.getInstance().getTime());
		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		accPc = PropertyHandler.getPropValue(dataFilePath, accPc);
		accWt = PropertyHandler.getPropValue(dataFilePath, accWt);

		location = PropertyHandler.getPropValue(dataFilePath, location);

		list(awbPre, awbNo);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn))
			click(yesBtn);
		waitForFrameAndSwitch(FRAME);
		if (alPrtRcvd)
			click(chkbox_allPartsRcvd);
		click(txt_loose_pcs);
		enterKeys(txt_loose_pcs, accPc);
		click(txt_loose_wt);
		enterKeys(txt_loose_wt, accWt);
		enterKeys(loose_location, location);
		click(btn_loose_add);
		click(tab_secScrDet);
		click(tab_expand);
		minWait();
		waitForFrameAndSwitch(subFRAME);

		List<WebElement> scrMethds = getWebElements(lbl_scrMethds);
		for (int i = 0; i < scrMethds.size(); i++) {
			// scrMethds.get(i).getText().contains("TRACE DETECTION CONFIRMED AWBS");
			Assert.assertTrue(
					scrMethds.get(i).getText()
							.contains("TRACE DETECTION CONFIRMED AWBS"),
					"Screening Method should be dsplayed ");
			break;

		}
		minWait();

		// System.out.println(waitForElementVisible(txt_remrks).getAttribute("value"));
		// System.out.println(driver.findElement(txt_remrks).getText());
		Assert.assertTrue(
				waitForElementVisible(txt_remrks).getAttribute("value").equals(
						"TESTED IN BASE"),
				"Remarks should exist and match with test data");
		Assert.assertTrue(
				waitForElementVisible(txt_scr_name).getAttribute("value")
						.equals("ANDREAS WILHELM"),
				"Remarks should exist and match with test data");
		Assert.assertTrue(waitForElementVisible(txt_date).getAttribute("value")
				.equals(date), "Date should exist and match with test data");
		click(tab_agents_det);
		minWait();
		Assert.assertTrue(
				waitForElement(lbl_agent_id).getText().equals("00150-01"),
				"Agent ID should exist and match with test data");
		Assert.assertTrue(
				waitForElement(lbl_expirydt).getText().equals("0535"),
				"Remarks should exist and match with test data");

		return this;
	}

	/**
	 * close screen methods
	 * 
	 * @author A-8260
	 * @return
	 */
	public HomePage closeScreen() {
		Actions action = new Actions(driver);
		action.keyDown(Keys.ALT).sendKeys("c").keyUp(Keys.ALT).perform();

		return new HomePage(driver, dataFileName);

	}

	/**
	 * @author A-8260
	 * @param awbPre
	 * @param awbNo
	 * @param accPc
	 * @param accWt
	 * @param location
	 * @param result
	 * @param alPrtRcvd
	 * @return
	 */
	public OPR335 validateScreeningMethodsModifiedValue(String awbPre,
			String awbNo, String accPc, String accWt, String location,
			boolean result, boolean alPrtRcvd) {

		String date = new SimpleDateFormat("dd-MMM-yyyy").format(Calendar
				.getInstance().getTime());
		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		accPc = PropertyHandler.getPropValue(dataFilePath, accPc);
		accWt = PropertyHandler.getPropValue(dataFilePath, accWt);

		location = PropertyHandler.getPropValue(dataFilePath, location);

		list(awbPre, awbNo);
		if (alPrtRcvd)
			click(chkbox_allPartsRcvd);
		click(txt_loose_pcs);
		enterKeys(txt_loose_pcs, accPc);
		click(txt_loose_wt);
		enterKeys(txt_loose_wt, accWt);
		enterKeys(loose_location, location);
		click(btn_loose_add);
		click(tab_secScrDet);
		click(tab_expand);
		minWait();
		waitForFrameAndSwitch(subFRAME);

		List<WebElement> scrMethds = getWebElements(lbl_scrMethds);
		for (int i = 0; i < scrMethds.size(); i++) {
			// scrMethds.get(i).getText().contains("TRACE DETECTION CONFIRMED AWBS");
			scrollToView(scrMethds.get(3));
			Assert.assertTrue(
					scrMethds.get(3).getText()
							.contains("Explosive detection system"),
					"Screening Method should be displayed ");
			break;

		}
		minWait();

		System.out.println(waitForElementVisible(txt_remrks).getAttribute(
				"value"));
		// System.out.println(driver.findElement(txt_remrks).getText());
		Assert.assertTrue(
				waitForElementVisible(txt_remrks).getAttribute("value").equals(
						"TESTED IN BASE"),
				"Remarks should exist and match with test data");
		Assert.assertTrue(
				waitForElementVisible(txt_scr_name).getAttribute("value")
						.equals("ANDREAS WILHELM"),
				"Remarks should exist and match with test data");
		Assert.assertTrue(waitForElementVisible(txt_date).getAttribute("value")
				.equals(date), "Date should exist and match with test data");
		click(tab_agents_det);
		minWait();
		Assert.assertTrue(
				waitForElement(lbl_agent_id).getText().equals("00150-01"),
				"Agent ID should exist and match with test data");
		Assert.assertTrue(
				waitForElement(lbl_expirydt).getText().equals("0535"),
				"Remarks should exist and match with test data");

		return this;
	}

	public OPR335 validateScreeningMethodsxFWB(String awbPre, String awbNo,
			String accPc, String accWt, String location, boolean result,
			boolean alPrtRcvd) {

		String date = new SimpleDateFormat("dd-MMM-yyyy").format(Calendar
				.getInstance().getTime());
		awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		accPc = PropertyHandler.getPropValue(dataFilePath, accPc);
		accWt = PropertyHandler.getPropValue(dataFilePath, accWt);

		location = PropertyHandler.getPropValue(dataFilePath, location);

		list(awbPre, awbNo);
		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn))
			click(yesBtn);
		waitForFrameAndSwitch(FRAME);
		// if(alPrtRcvd)
		// click(chkbox_allPartsRcvd);
		// click(txt_loose_pcs);
		// enterKeys(txt_loose_pcs, accPc);
		// click(txt_loose_wt);
		// enterKeys(txt_loose_wt, accWt);
		// enterKeys(loose_location, location);
		// click(btn_loose_add);
		click(tab_secScrDet);
		click(tab_expand);
		minWait();
		waitForFrameAndSwitch(subFRAME);

		List<WebElement> scrMethds = getWebElements(lbl_scrMethds);
		for (int i = 0; i < scrMethds.size(); i++) {
			// scrMethds.get(i).getText().contains("TRACE DETECTION CONFIRMED AWBS");
			Assert.assertTrue(
					scrMethds.get(i).getText()
							.contains("confirmed awb-success screen"),
					"Screening Method should be dsplayed ");
			break;

		}
		minWait();

		System.out.println(waitForElementVisible(txt_remrks).getAttribute(
				"value"));
		// System.out.println(driver.findElement(txt_remrks).getText());
		// Assert.assertTrue(waitForElementVisible(txt_remrks).getAttribute("value").equals("TESTED IN BASE"),"Remarks should exist and match with test data");
		Assert.assertTrue(
				waitForElementVisible(txt_scr_name).getAttribute("value")
						.equals("HHTFRA"),
				"Remarks should exist and match with test data");
		Assert.assertTrue(waitForElementVisible(txt_date).getAttribute("value")
				.equals("15-Jan-2018"),
				"Date should exist and match with test data");
		click(tab_agents_det);
		minWait();
		Assert.assertTrue(waitForElement(lbl_agent_id).getText()
				.equals("12345"),
				"Agent ID should exist and match with test data");
		// Assert.assertTrue(waitForElement(lbl_expirydt).getText().equals("0535"),"Remarks should exist and match with test data");

		return this;
	}

	/**
	 * Created by A-7605 on 15-2-18 This method accept single AWB into 3ULDs and
	 * 1loose locations
	 * 
	 * @param awbPrefix
	 * @param awbNo
	 * @param loosePcs
	 * @param looseWgt
	 * @param looseAcceptanceLoc1
	 * @param uld1
	 * @param uld1Pcs
	 * @param uld1Wgt
	 * @param uld1AcceptanceLoc
	 * @param uld2
	 * @param uld2Pcs
	 * @param uld2Wgt
	 * @param uld2AcceptanceLoc
	 * @param uld3
	 * @param uld3Pcs
	 * @param uld3Wgt
	 * @param uld3AcceptanceLoc
	 * @param companyCode
	 * @return
	 */
	public OPR335 acceptance_1Loose_3ULDs(String awbPrefix, String awbNo,
			String loosePcs, String looseWgt, String looseAcceptanceLoc1,
			String uld1, String uld1Pcs, String uld1Wgt,
			String uld1AcceptanceLoc, String uld2, String uld2Pcs,
			String uld2Wgt, String uld2AcceptanceLoc, String uld3,
			String uld3Pcs, String uld3Wgt, String uld3AcceptanceLoc,
			String companyCode) {

		awbPrefix = PropertyHandler.getPropValue(dataFilePath, awbPrefix);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		loosePcs = PropertyHandler.getPropValue(dataFilePath, loosePcs);
		looseWgt = PropertyHandler.getPropValue(dataFilePath, looseWgt);
		uld1Pcs = PropertyHandler.getPropValue(dataFilePath, uld1Pcs);
		uld1Wgt = PropertyHandler.getPropValue(dataFilePath, uld1Wgt);
		uld2Pcs = PropertyHandler.getPropValue(dataFilePath, uld2Pcs);
		uld2Wgt = PropertyHandler.getPropValue(dataFilePath, uld2Wgt);
		uld3Pcs = PropertyHandler.getPropValue(dataFilePath, uld3Pcs);
		uld3Wgt = PropertyHandler.getPropValue(dataFilePath, uld3Wgt);
		looseAcceptanceLoc1 = PropertyHandler.getPropValue(dataFilePath,
				looseAcceptanceLoc1);
		uld1AcceptanceLoc = PropertyHandler.getPropValue(dataFilePath,
				uld1AcceptanceLoc);
		uld2AcceptanceLoc = PropertyHandler.getPropValue(dataFilePath,
				uld2AcceptanceLoc);
		uld3AcceptanceLoc = PropertyHandler.getPropValue(dataFilePath,
				uld3AcceptanceLoc);
		companyCode = PropertyHandler.getPropValue(dataFilePath, companyCode);

		list(awbPrefix, awbNo);
		maxWait();
		expandLooseAcceptanceAccordin();
		enterKeys(txt_loose_pcs, loosePcs);
		enterKeys(txt_loose_pcs, Keys.TAB);
		enterKeys(txt_loose_wt, looseWgt);
		enterKeys(loose_location, looseAcceptanceLoc1);
		click(btn_loose_add);
		minWait();
		expandULDAcceptanceAccordin();
		enterKeys((txt_uld_pcs), uld1Pcs);
		enterKeys(txt_uld_wt, uld1Wgt);
		enterKeys(txt_uld_location, uld1AcceptanceLoc);
		String uld = null;
		int count = 0;

		while (count < 5) {
			uld = BizUtility.createULDNum("AKE", companyCode);
			enterKeys(txt_uldNum, uld);
			enterKeys(txt_uldNum, Keys.TAB);
			minWait();
			driver.switchTo().defaultContent();
			if (verifyElementPresent(yesBtn)) {
				click(yesBtn);
				waitForFrameAndSwitch(FRAME);
				break;
			}
			waitForFrameAndSwitch(FRAME);
			count++;
		}
		minWait();
		PropertyHandler.setPropValue(dataFilePath, uld1, uld);
		scrollToView(btn_uld_add);
		click(btn_uld_add);

		expandULDAcceptanceAccordin();
		enterKeys((txt_uld_pcs), uld2Pcs);
		enterKeys(txt_uld_wt, uld2Wgt);
		enterKeys(txt_uld_location, uld2AcceptanceLoc);
		uld = null;
		count = 0;

		while (count < 5) {
			uld = BizUtility.createULDNum("AKE", companyCode);
			enterKeys(txt_uldNum, uld);
			enterKeys(txt_uldNum, Keys.TAB);
			minWait();
			driver.switchTo().defaultContent();
			if (verifyElementPresent(yesBtn)) {
				click(yesBtn);
				waitForFrameAndSwitch(FRAME);
				break;
			}
			waitForFrameAndSwitch(FRAME);
			count++;
		}
		minWait();
		PropertyHandler.setPropValue(dataFilePath, uld2, uld);
		click(btn_uld_add);
		expandULDAcceptanceAccordin();
		enterKeys((txt_uld_pcs), uld3Pcs);
		enterKeys(txt_uld_wt, uld3Wgt);
		enterKeys(txt_uld_location, uld3AcceptanceLoc);
		uld = null;
		count = 0;

		while (count < 5) {
			uld = BizUtility.createULDNum("AKE", companyCode);
			enterKeys(txt_uldNum, uld);
			enterKeys(txt_uldNum, Keys.TAB);
			minWait();
			driver.switchTo().defaultContent();
			if (verifyElementPresent(yesBtn)) {
				click(yesBtn);
				waitForFrameAndSwitch(FRAME);
				break;
			}
			waitForFrameAndSwitch(FRAME);
			count++;
		}
		minWait();
		PropertyHandler.setPropValue(dataFilePath, uld3, uld);
		check(chkbox_allPartsRcvd);

		click(btn_save);
		driver.switchTo().defaultContent();

		while (true) {
			minWait();
			if (verifyElementPresent(yesBtn))
				click(yesBtn);
			else
				break;
		}
		maxWait();
		waitForFrameAndSwitch(FRAME);
		Assert.assertTrue(
				waitForElement(info_finalized).getText().contains(
						"Acceptance finalised"),
				"ERROR : Shipment not finalized.");
		Assert.assertFalse(waitForElementVisible(info_rcs)
				.getAttribute("class").contains("icon rejected"),
				"ERROR : Shipment NOT ready for carriage.");

		return this;
	}

	/**
	 * Method to list an AWB, fill the Manditory fields and click on Save button
	 * 
	 * @param: Location,pcs
	 * @author Shalini on 31/12/2018
	 */
	public OPR335 processGoodsAcceptance(String prefix, String awbno,
			String Location, String pcs) {
		boolean isFound = true;
		minWait();
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		Location = PropertyHandler.getPropValue(dataFilePath, Location);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		enterKeys(txt_awbPre, prefix);
		enterKeys(txt_awbNo, awbno);
		click(btn_list);
		InitialSetup.test.log(LogStatus.PASS, "Successfully printed AWB No "+awbno);
		maxWait();
		click(chkbox_allPartsRcvd);
		click(div_looseAcc);		
		enterKeys(txt_loose_pcs, pcs + Keys.TAB);
		enterKeys(loose_location, Location);
		
		click(tab_expand);
		minWait();
		driver.switchTo().frame("if11");
		click(chckbx_securitydataRetrvd);
		//Some time not Manditory
		click(Shipment_Details);
		click(Shipment_EditButton);
		enterKeys(txt_Shipmnt, "SPX");
		InitialSetup.test.log(LogStatus.PASS, "Successfully entered SPX in security and secreening");
		click(btn_popOK);	
		click(btnOk);
		minWait();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("iCargoContentFrameOPR335");
		click(btn_save);
		minWait();
		handleAlert("Accept", "OPR335");
		driver.switchTo().frame("iCargoContentFrameOPR335");
		maxWait();		
		InitialSetup.test.log(LogStatus.PASS, "Successfully clicked on Save button");
		minWait();
		String actaulValue=driver.findElement(By.xpath("//label[text()='Ready for carriage']")).getText();
		if (actaulValue.equalsIgnoreCase("Ready for carriage")) {
			InitialSetup.test.log(LogStatus.PASS, "Goods acceptance is done Successfully");
		}
		else
		{
			Assert.fail("Error in Message");
			InitialSetup.test.log(LogStatus.FAIL, "Goods acceptance is not done Successfully");
		}
		
		return this;
	}
	/**
	 * Method to list an AWB, fill the Manditory fields and click on Save button
	 * 
	 * @param: Location,pcs
	 * @author Shalini on 31/12/2018
	 */
	public OPR335 processGoodsAcceptanceWithULD(String prefix, String awbno,
			String Location, String pcs,String ULDpcs,String ULDLocation,String ULDName) {
		boolean isFound = true;
		minWait();
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		Location = PropertyHandler.getPropValue(dataFilePath, Location);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		ULDpcs= PropertyHandler.getPropValue(dataFilePath, ULDpcs);
		ULDLocation= PropertyHandler.getPropValue(dataFilePath, ULDLocation);
		ULDName= PropertyHandler.getPropValue(dataFilePath, ULDName);
		
		enterKeys(txt_awbPre, prefix);
		enterKeys(txt_awbNo, awbno);
		click(btn_list);
		InitialSetup.test.log(LogStatus.PASS, "Successfully entered AWB No in OPR335 Screen ");
		maxWait();
		click(chkbox_allPartsRcvd);
		click(div_looseAcc);		
		enterKeys(txt_loose_pcs, ULDpcs + Keys.TAB);
		enterKeys(loose_location, Location);
		//To Enter ULD details
		click(Icon_UldAcceptance);
		enterKeys(txt_acceptancPcs,ULDpcs + Keys.TAB);
		enterKeys(txt_acceptanceLocatn, ULDLocation);
		enterKeys(txt_acceptanceULD,ULDName );
		click(btn_acceptanceAdd);		
		
		click(tab_expand);
		minWait();
		driver.switchTo().frame("if11");
		click(chckbx_securitydataRetrvd);
		//Some time not Mandatory
		click(Shipment_Details);
		click(Shipment_EditButton);
		enterKeys(txt_Shipmnt, "SPX");
		InitialSetup.test.log(LogStatus.PASS, "Successfully entered SPX in security and secreening");
		click(btn_popOK);	
		click(btnOk);
		minWait();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("iCargoContentFrameOPR335");
		click(btn_save);
		minWait();
		handleAlert("Accept", "OPR335");
		driver.switchTo().frame("iCargoContentFrameOPR335");
		maxWait();		
		InitialSetup.test.log(LogStatus.PASS, "Successfully clicked on Save button");
		maxWait();
		try{
		String actaulValue=driver.findElement(By.xpath("(//div[@id='messagePane']/label)[1]")).getText();
		if (actaulValue.equalsIgnoreCase("Ready for carriage")) {
			InitialSetup.test.log(LogStatus.PASS, "Goods acceptance is done Successfully");
		}
		else
		{
			Assert.fail("Error in Message");
			InitialSetup.test.log(LogStatus.FAIL, "Goods acceptance is not done Successfully");
			
		}
		}catch(Exception e){
			InitialSetup.test.log(LogStatus.FAIL, "Goods acceptance is not done"+e);
		}
		return this;
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
			AlertText = driver.findElement(By.xpath("//div[@role='dialog']//p"))
					.getText();
			switch (alertOps.valueOf(alertOps)) {
			case "getText":
				 InitialSetup.test.log(LogStatus.PASS, "Accepted Alert text "+AlertText+ScreenName);
				break;

			case "Accept":
				driver.findElement(By.xpath("//div[@class='ui-dialog-buttonset']//button[1]")).click();
				 InitialSetup.test.log(LogStatus.PASS, "Accepted Alert with text "+ScreenName);

				break;
			case "Dismiss":
				driver.findElement(By.xpath("//div[@class='ui-dialog-buttonset']//button[2]")).click();
				InitialSetup.test.log(LogStatus.PASS,"Clicked on Dismiss button "+ScreenName);
				break;
			case "Close":
				driver.findElement(By.xpath("(//button[@title='Close'])[2]|//button[@name='btClose']")).click();
				InitialSetup.test.log(LogStatus.PASS,"Clicked on Close button "+ScreenName);
				break;
			}

		} catch (Exception e) {
			InitialSetup.test.log(LogStatus.INFO,"Alert not available/handled "+ScreenName);

		}
	}
	public OPR335 writeDatatoPropertyfile(String Path, String prefix,
			String awbno, String origin, String dest, String agentCode,
			String Product, String pcs, String wt, String vol, String FlightNo,
			String fltDt, String ubr, String bookingType, String ULDType,
			String noOfULD, String CarrierCode,String uldNo) {
		Path = PropertyHandler.getPropValue(dataFilePath, Path);

		Path = "./resources/TestData/BASE/" + Path;
		InitialSetup.test.log(LogStatus.INFO, "Starting with writing the data");
		CarrierCode = PropertyHandler.getPropValue(dataFilePath, CarrierCode);
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		FlightNo = PropertyHandler.getPropValue(dataFilePath, FlightNo);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		origin = PropertyHandler.getPropValue(dataFilePath, origin);
		dest = PropertyHandler.getPropValue(dataFilePath, dest);
		agentCode = PropertyHandler.getPropValue(dataFilePath, agentCode);
		Product = PropertyHandler.getPropValue(dataFilePath, Product);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		wt = PropertyHandler.getPropValue(dataFilePath, wt);
		vol = PropertyHandler.getPropValue(dataFilePath, vol);
		ULDType = PropertyHandler.getPropValue(dataFilePath, ULDType);
		noOfULD = PropertyHandler.getPropValue(dataFilePath, noOfULD);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		String carrierWithFlightno = CarrierCode + FlightNo;
		PropertyHandler.setPropValue(dataFilePath, "carrierwithFlightno",
				carrierWithFlightno);
		uldNo=PropertyHandler.getPropValue(dataFilePath, uldNo);
		// Writing to Another Property File
		PropertyHandler.setPropValue(Path, "prefix", prefix);
		PropertyHandler.setPropValue(Path, "CarrierCode", CarrierCode);
		PropertyHandler.setPropValue(Path, "FlightNo", FlightNo);
		PropertyHandler.setPropValue(Path, "awbno", awbno);
		PropertyHandler.setPropValue(Path, "dest", dest);
		PropertyHandler.setPropValue(Path, "agentCode", agentCode);
		PropertyHandler.setPropValue(Path, "Product", Product);
		PropertyHandler.setPropValue(Path, "pcs", pcs);
		PropertyHandler.setPropValue(Path, "wt", wt);
		PropertyHandler.setPropValue(Path, "vol", vol);
		PropertyHandler.setPropValue(Path, "ULDType", ULDType);
		PropertyHandler.setPropValue(Path, "noOfULD", noOfULD);
		PropertyHandler.setPropValue(Path, "fltDt", fltDt);
		PropertyHandler.setPropValue(Path, "carrierwithFlightno",
				carrierWithFlightno);
		
		PropertyHandler.setPropValue(Path, "uldNo",
				uldNo);
		InitialSetup.test.log(LogStatus.INFO, "Data has been written successfully");
		return this;

	}
	
	
	
	/**
	 * Method to list an AWB, fill the Manditory fields and click on Save button
	 * 
	 * @param: Location,pcs
	 * @author Sharath on 04/03/2019
	 */
	public OPR335 processGoodsAcceptanceWithULDandScreening(String prefix, String awbno,
			String Location, String screening_method,String ULDpcs,String ULDLocation,String ULDName, String wt) {
		boolean isFound = true;
		minWait();
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		/*Location = PropertyHandler.getPropValue(dataFilePath, Location);*/
		screening_method = PropertyHandler.getPropValue(dataFilePath, screening_method);
		ULDpcs= PropertyHandler.getPropValue(dataFilePath, ULDpcs);
		ULDLocation= PropertyHandler.getPropValue(dataFilePath, ULDLocation);
		ULDName= PropertyHandler.getPropValue(dataFilePath, ULDName);
		wt= PropertyHandler.getPropValue(dataFilePath, wt);
		
		enterKeys(txt_awbPre, prefix);
		enterKeys(txt_awbNo, awbno);
		click(btn_list);
		InitialSetup.test.log(LogStatus.PASS, "Successfully entered AWB No in OPR335 Screen ");
		maxWait();
		click(chkbox_allPartsRcvd);
	/*	click(div_looseAcc);		
		enterKeys(txt_loose_pcs, ULDpcs + Keys.TAB);
		enterKeys(loose_location, Location);*/
		//To Enter ULD details
		click(Icon_UldAcceptance);
		enterKeys(txt_acceptancPcs,ULDpcs + Keys.TAB);
		enterKeys(txt_acceptanceLocatn, ULDLocation);
		enterKeys(txt_acceptanceULD,ULDName );
		click(btn_acceptanceAdd);		
		minWait();
		click(btn_save);
		minWait();
		handleAlert("Accept", "OPR335");
		minWait();
		waitForFrameAndSwitch("iCargoContentFrameOPR335");
		maxWait();	
		InitialSetup.test.log(LogStatus.INFO, "The Loose and ULD shipment details have been saved successfully");
		click(tab_expand);
		minWait();
		InitialSetup.test.log(LogStatus.INFO, "Entering the screening details");
		waitForFrameAndSwitch("if11");
		selectByText(sel_screenMethod, screening_method);
		enterKeys(txt_statedpcs,ULDpcs);
		enterKeys(txt_statedwt,wt);
		selectByText(sel_result, "Pass");
		minWait();
		click(btn_btnadd);
		scrollToView(txt_frmDate);
		minWait();
		click(btn_newSavebtn);
		InitialSetup.test.log(LogStatus.INFO, "Clicked on Screening Ok button");
		maxWait();
		maxWait();
		try{
			handleAlert("Accept", "OPR335");
			waitForFrameAndSwitch("iCargoContentFrameOPR335");
		}catch(Exception e){
			InitialSetup.test.log(LogStatus.INFO, "No pop-up post clicking Ok button");
		}
		try{
			handleAlert("Accept", "OPR335");
			waitForFrameAndSwitch("iCargoContentFrameOPR335");
		}catch(Exception e){
			InitialSetup.test.log(LogStatus.INFO, "No pop-up post clicking accepting first alert");
		}
		InitialSetup.test.log(LogStatus.INFO, "The screening details have been entered successfully");
		maxWait();
		click(btn_save);
		minWait();
		handleAlert("Accept", "OPR335");
		waitForFrameAndSwitch("iCargoContentFrameOPR335");
		InitialSetup.test.log(LogStatus.INFO, "Successfully clicked on Save button");
		maxWait();
		maxWait();
		try{
		String actualValue=driver.findElement(By.xpath("(//div[@id='messagePane']/label)[1]")).getText();
		if (actualValue.equalsIgnoreCase("Ready for carriage")) {
			InitialSetup.test.log(LogStatus.PASS, "Goods acceptance has been successfully performed with status : "+actualValue);
			captureAndAddScreenshot();
		}
		else
		{	
			InitialSetup.test.log(LogStatus.FAIL, "Goods acceptance is failed  with status : "+actualValue);
			Assert.fail("Goods acceptance is failed  with status : "+actualValue);
			
		}
		}catch(Exception e){
			InitialSetup.test.log(LogStatus.FAIL, "Goods acceptance is failed due to : "+e);
			Assert.fail("Goods Acceptance Failed");
		}
		return this;
	}
	
	
	//A-8680
	public OPR335 processGoodsAcceptanceWithULDbeforeScreening(String prefix, String awbno,
			String Location, String blkpcs,String ULDpcs,String pcs, String ULDLocation,String ULDName, String wt, String screening_method) {
		boolean isFound = true;
		InitialSetup.test.log(LogStatus.INFO, "Starting the Goods Acceptance");
		minWait();
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		Location = PropertyHandler.getPropValue(dataFilePath, Location);
		blkpcs = PropertyHandler.getPropValue(dataFilePath, blkpcs);
		ULDpcs= PropertyHandler.getPropValue(dataFilePath, ULDpcs);
		ULDLocation= PropertyHandler.getPropValue(dataFilePath, ULDLocation);
		ULDName= PropertyHandler.getPropValue(dataFilePath, ULDName);
		wt= PropertyHandler.getPropValue(dataFilePath, wt);
		pcs= PropertyHandler.getPropValue(dataFilePath, pcs);
		screening_method= PropertyHandler.getPropValue(dataFilePath, screening_method);	
		
		enterKeys(txt_awbPre, prefix);
		enterKeys(txt_awbNo, awbno);
		click(btn_list);
		InitialSetup.test.log(LogStatus.INFO, "Listed the awb : "+prefix+"-"+awbno+" successfully");
		maxWait();
		InitialSetup.test.log(LogStatus.INFO, "Entering the Loose and ULD shipment details");
		click(chkbox_allPartsRcvd);
		
//		To enter loose
		/*click(div_looseAcc);		
		enterKeys(txt_loose_pcs, blkpcs + Keys.TAB);
		enterKeys(txt_loose_pcs, pcs + Keys.TAB);
		enterKeys(loose_location, Location);*/
		
		//To Enter ULD details
		click(Icon_UldAcceptance);
		enterKeys(txt_acceptancPcs,pcs + Keys.TAB);
		enterKeys(By.name("uldShipmentWeight"),wt);
		enterKeys(txt_acceptanceLocatn, ULDLocation);
		enterKeys(txt_acceptanceULD,ULDName);
		click(btn_acceptanceAdd);	
		minWait();
		click(btn_save);
		maxWait();
		handleAlert("Accept", "OPR335");
		minWait();
		waitForFrameAndSwitch("iCargoContentFrameOPR335");
		maxWait();	
		InitialSetup.test.log(LogStatus.INFO, "The Loose and ULD shipment details have been saved successfully");
		click(tab_expand);
		minWait();
		InitialSetup.test.log(LogStatus.INFO, "Entering the screening details");
		waitForFrameAndSwitch("if11");
		selectByText(sel_screenMethod, screening_method);
		enterKeys(txt_statedpcs,pcs);
		enterKeys(txt_statedwt,wt);
		selectByText(sel_result, "Pass");
		minWait();
		click(btn_btnadd);
		scrollToView(txt_frmDate);
		minWait();
		click(btn_newSavebtn);
		captureAndAddScreenshot();
		InitialSetup.test.log(LogStatus.INFO, "Clicked on Screening Ok button");
		maxWait();
		maxWait();
		try{
			handleAlert("Accept", "OPR335");
			waitForFrameAndSwitch("iCargoContentFrameOPR335");
		}catch(Exception e){
			InitialSetup.test.log(LogStatus.INFO, "No pop-up post clicking Ok button");
		}
		try{
			handleAlert("Accept", "OPR335");
			waitForFrameAndSwitch("iCargoContentFrameOPR335");
		}catch(Exception e){
			InitialSetup.test.log(LogStatus.INFO, "No pop-up post clicking accepting first alert");
		}
		InitialSetup.test.log(LogStatus.INFO, "The screening details have been entered successfully");
		maxWait();
		click(btn_save);
		minWait();
		handleAlert("Accept", "OPR335");
		waitForFrameAndSwitch("iCargoContentFrameOPR335");
		InitialSetup.test.log(LogStatus.INFO, "Successfully clicked on Save button");
		maxWait();
		maxWait();
		maxWait();
		try{
		String actualValue=driver.findElement(By.xpath("(//div[@id='messagePane']/label)[1]")).getText();
		if (actualValue.equalsIgnoreCase("Ready for carriage")) {
			InitialSetup.test.log(LogStatus.PASS, "Goods acceptance has been successfully performed with status : "+actualValue);
			captureAndAddScreenshot();
		}
		else
		{	
			InitialSetup.test.log(LogStatus.FAIL, "Goods acceptance is failed  with status : "+actualValue);
			Assert.fail("Goods acceptance is failed  with status : "+actualValue);
			
		}
		}catch(Exception e){
			InitialSetup.test.log(LogStatus.FAIL, "Goods acceptance is failed due to : "+e);
			Assert.fail("Goods Acceptance Failed");
		}
		return this;
	}
	
	//A-8680 5th Mar, 2019
	public OPR335 enterScreeingDetails(String prefix, String awbno,
			String Location, String pcs,String ULDpcs,String ULDLocation,String ULDName, String wt) {
		boolean isFound = true;
		minWait();
		prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		Location = PropertyHandler.getPropValue(dataFilePath, Location);
		pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
		ULDpcs= PropertyHandler.getPropValue(dataFilePath, ULDpcs);
		ULDLocation= PropertyHandler.getPropValue(dataFilePath, ULDLocation);
		ULDName= PropertyHandler.getPropValue(dataFilePath, ULDName);
		wt= PropertyHandler.getPropValue(dataFilePath, wt);
		
		enterKeys(txt_awbPre, prefix);
		enterKeys(txt_awbNo, awbno);
		click(btn_list);
		InitialSetup.test.log(LogStatus.INFO, "Successfully entered AWB No in OPR335 Screen ");
		maxWait();
		
		click(tab_expand);
		minWait();
		driver.switchTo().frame("if11");
		selectByText(sel_screenMethod, "Particle trace");
		enterKeys(txt_statedpcs,pcs);
		enterKeys(txt_statedwt,wt);
		selectByText(sel_result, "Pass");
		click(btn_btnadd);
		scrollToView(txt_frmDate);
		click(btn_newSavebtn);
		maxWait();
		try{
			handleAlert("Accept", "OPR335");
			waitForFrameAndSwitch("iCargoContentFrameOPR335");
		}catch(Exception e){
			
		}
		InitialSetup.test.log(LogStatus.INFO, "Successfully entered screening details");
		minWait();
		click(btn_save);
		minWait();
		handleAlert("Accept", "OPR335");
		waitForFrameAndSwitch("iCargoContentFrameOPR335");
		InitialSetup.test.log(LogStatus.INFO, "Successfully clicked on Save button");
		maxWait();
		try{
		String actaulValue=driver.findElement(By.xpath("(//div[@id='messagePane']/label)[1]")).getText();
		if (actaulValue.equalsIgnoreCase("Ready for carriage")) {
			InitialSetup.test.log(LogStatus.PASS, "Goods acceptance is done Successfully");
		}
		else
		{
			Assert.fail("Error in Message");
			InitialSetup.test.log(LogStatus.FAIL, "Goods acceptance is not done Successfully");
			
		}
		}catch(Exception e){
			InitialSetup.test.log(LogStatus.FAIL, "Goods acceptance is not done"+e);
		}
		return this;
	}
	
	//A-8680
		public OPR335 processGoodsAcceptanceULDOnly(String prefix, String awbno,
				String pcs, String newWt, String ULDLocation,String uldNo, String screeningMethod) {
			boolean isFound = true;
			InitialSetup.test.log(LogStatus.INFO, "Starting the Goods Acceptance");
			minWait();
			prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
			awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
			pcs= PropertyHandler.getPropValue(dataFilePath, pcs);
			newWt= PropertyHandler.getPropValue(dataFilePath, newWt);
			ULDLocation= PropertyHandler.getPropValue(dataFilePath, ULDLocation);
			uldNo= PropertyHandler.getPropValue(dataFilePath, uldNo);		
			screeningMethod= PropertyHandler.getPropValue(dataFilePath, screeningMethod);	
			
			enterKeys(txt_awbPre, prefix);
			enterKeys(txt_awbNo, awbno);
			click(btn_list);
			InitialSetup.test.log(LogStatus.INFO, "Listed the awb : "+prefix+"-"+awbno+" successfully");
			maxWait();
			InitialSetup.test.log(LogStatus.INFO, "Entering the Loose and ULD shipment details");
			click(chkbox_allPartsRcvd);
			click(Icon_UldAcceptance);
			enterKeys(txt_acceptancPcs,pcs + Keys.TAB);
			enterKeys(By.xpath("//input[@name='uldShipmentWeight']"),newWt);
			enterKeys(txt_acceptanceLocatn, ULDLocation);
			enterKeys(txt_acceptanceULD,uldNo);
			click(btn_acceptanceAdd);	
			minWait();
			click(btn_save);
			minWait();
			handleAlert("Accept", "OPR335");
			minWait();
			waitForFrameAndSwitch("iCargoContentFrameOPR335");
			maxWait();	
			InitialSetup.test.log(LogStatus.INFO, "The Loose and ULD shipment details have been saved successfully");
			click(tab_expand);
			minWait();
			InitialSetup.test.log(LogStatus.INFO, "Entering the screening details");
			waitForFrameAndSwitch("if11");
			selectByText(sel_screenMethod, screeningMethod);
			enterKeys(txt_statedpcs,pcs);
			enterKeys(txt_statedwt,newWt);
			selectByText(sel_result, "Pass");
			click(btn_btnadd);
			scrollToView(txt_frmDate);
			click(btn_newSavebtn);
			maxWait();
			try{
				handleAlert("Accept", "OPR335");
				waitForFrameAndSwitch("iCargoContentFrameOPR335");
			}catch(Exception e){
				InitialSetup.test.log(LogStatus.INFO, "No pop-up post clicking Ok button");
				waitForFrameAndSwitch("iCargoContentFrameOPR335");
			}
			try{
				handleAlert("Accept", "OPR335");
				waitForFrameAndSwitch("iCargoContentFrameOPR335");
			}catch(Exception e){
				InitialSetup.test.log(LogStatus.INFO, "No pop-up post clicking accepting first alert");
				waitForFrameAndSwitch("iCargoContentFrameOPR335");
			}
			InitialSetup.test.log(LogStatus.INFO, "The screening details have been entered successfully");
			minWait();
			click(btn_save);
			minWait();
			handleAlert("Accept", "OPR335");
			waitForFrameAndSwitch("iCargoContentFrameOPR335");
			InitialSetup.test.log(LogStatus.INFO, "Successfully clicked on Save button");
			maxWait();
			maxWait();
			try{
			String actualValue=driver.findElement(By.xpath("(//div[@id='messagePane']/label)[1]")).getText();
			if (actualValue.equalsIgnoreCase("Ready for carriage")) {
				InitialSetup.test.log(LogStatus.PASS, "Goods acceptance has been successfully performed with status : "+actualValue);
			}
			else
			{	
				InitialSetup.test.log(LogStatus.FAIL, "Goods acceptance is failed  with status : "+actualValue);
				Assert.fail("Goods acceptance is failed  with status : "+actualValue);
				
			}
			}catch(Exception e){
				InitialSetup.test.log(LogStatus.FAIL, "Goods acceptance is failed due to : "+e);
				Assert.fail("Goods Acceptance Failed");
			}
			return this;
		}
		

		//A-8680
			public OPR335 processDGGoodsAcceptance(String prefix, String awbno,
					String pcs, String wt, String Location, String screeningMethod) {
				boolean isFound = true;
				InitialSetup.test.log(LogStatus.INFO, "Starting the Goods Acceptance");
				minWait();
				prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
				awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
				pcs= PropertyHandler.getPropValue(dataFilePath, pcs);
				wt= PropertyHandler.getPropValue(dataFilePath, wt);
				Location= PropertyHandler.getPropValue(dataFilePath, Location);		
				screeningMethod= PropertyHandler.getPropValue(dataFilePath, screeningMethod);	
				enterKeys(txt_awbPre, prefix);
				enterKeys(txt_awbNo, awbno);
				click(btn_list);
				InitialSetup.test.log(LogStatus.INFO, "Listed the awb : "+prefix+"-"+awbno+" successfully");
				maxWait();
				InitialSetup.test.log(LogStatus.INFO, "Entering the Loose and ULD shipment details");
				click(chkbox_allPartsRcvd);
				click(div_looseAcc);		
				enterKeys(txt_loose_pcs, pcs + Keys.TAB);				
				enterKeys(loose_location, Location);
				enterKeys(By.xpath("//input[@name='looseShipmentWeight']"), wt);				
				click(btn_looseAdd);	
				minWait();
				click(btn_save);
				minWait();
				handleAlert("Accept", "OPR335");
				minWait();
				waitForFrameAndSwitch("iCargoContentFrameOPR335");
				maxWait();	
				InitialSetup.test.log(LogStatus.INFO, "The Loose and ULD shipment details have been saved successfully");
				click(tab_expand);
				minWait();
				InitialSetup.test.log(LogStatus.INFO, "Entering the screening details");
				waitForFrameAndSwitch("if11");
				selectByText(sel_screenMethod, screeningMethod);
				enterKeys(txt_statedpcs,pcs);
				enterKeys(txt_statedwt,wt);
				selectByText(sel_result, "Pass");
				click(btn_btnadd);
				scrollToView(txt_frmDate);
				click(btn_newSavebtn);
				maxWait();
				try{
					handleAlert("Accept", "OPR335");
					waitForFrameAndSwitch("iCargoContentFrameOPR335");
				}catch(Exception e){
					InitialSetup.test.log(LogStatus.INFO, "No pop-up post clicking Ok button");
				}
				try{
					handleAlert("Accept", "OPR335");
					waitForFrameAndSwitch("iCargoContentFrameOPR335");
				}catch(Exception e){
					InitialSetup.test.log(LogStatus.INFO, "No pop-up post clicking accepting first alert");
				}
				InitialSetup.test.log(LogStatus.INFO, "The screening details have been entered successfully");
				minWait();
				click(btn_save);
				minWait();
				handleAlert("Accept", "OPR335");
				waitForFrameAndSwitch("iCargoContentFrameOPR335");
				InitialSetup.test.log(LogStatus.INFO, "Successfully clicked on Save button");
				maxWait();
				maxWait();
				try{
				String actualValue=driver.findElement(By.xpath("(//div[@id='messagePane']/label)[1]")).getText();
				if (actualValue.equalsIgnoreCase("Ready for carriage")) {
					InitialSetup.test.log(LogStatus.PASS, "Goods acceptance has been successfully performed with status : "+actualValue);
					captureAndAddScreenshot();
				}
				else
				{	
					InitialSetup.test.log(LogStatus.FAIL, "Goods acceptance is failed  with status : "+actualValue);
					captureAndAddScreenshot();
					Assert.fail("Goods acceptance is failed  with status : "+actualValue);					
				}
				}catch(Exception e){
					InitialSetup.test.log(LogStatus.FAIL, "Goods acceptance is failed due to : "+e);
					captureAndAddScreenshot();
					Assert.fail("Goods Acceptance Failed");
				}
				return this;
			}
			
			//A-8680
			public OPR335 enterAcceptanceDetailsWithoutScreening(String prefix, String awbno,
					String Location, String blkpcs, String blkwt, String ULDpcs,String ULDwt, String pcs, String ULDLocation,String ULDName, String wt) {
				boolean isFound = true;
				InitialSetup.test.log(LogStatus.INFO, "Starting the Goods Acceptance");
				minWait();
				prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
				awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
				Location = PropertyHandler.getPropValue(dataFilePath, Location);
				blkpcs = PropertyHandler.getPropValue(dataFilePath, blkpcs);
				blkwt = PropertyHandler.getPropValue(dataFilePath, blkwt);
				ULDpcs= PropertyHandler.getPropValue(dataFilePath, ULDpcs);
				ULDwt= PropertyHandler.getPropValue(dataFilePath, ULDwt);
				ULDLocation= PropertyHandler.getPropValue(dataFilePath, ULDLocation);
				ULDName= PropertyHandler.getPropValue(dataFilePath, ULDName);
				wt= PropertyHandler.getPropValue(dataFilePath, wt);
				pcs= PropertyHandler.getPropValue(dataFilePath, pcs);
				enterKeys(txt_awbPre, prefix);
				enterKeys(txt_awbNo, awbno);
				click(btn_list);
				InitialSetup.test.log(LogStatus.INFO, "Listed the awb : "+prefix+"-"+awbno+" successfully");
				maxWait();
				InitialSetup.test.log(LogStatus.INFO, "Entering the Loose and ULD shipment details");
				click(chkbox_allPartsRcvd);
				click(div_looseAcc);		
				enterKeys(txt_loose_pcs, blkpcs + Keys.TAB);
				enterKeys(txt_loose_wt, blkwt + Keys.TAB);
				enterKeys(loose_location, Location);
				//To Enter ULD details
				click(Icon_UldAcceptance);
				enterKeys(txt_acceptancPcs,ULDpcs + Keys.TAB);
				enterKeys(txt_acceptanceLocatn, ULDLocation);
				enterKeys(By.name("uldShipmentWeight"), ULDwt);
				enterKeys(txt_acceptanceULD,ULDName);
				click(btn_acceptanceAdd);	
				minWait();
				click(btn_save);
				maxWait();
				//dimmed pcs popup
				try{
					handleAlert("Accept", "OPR335");
					waitForFrameAndSwitch("iCargoContentFrameOPR335");
				}catch(Exception e){
					InitialSetup.test.log(LogStatus.INFO, "No pop-up post clicking Ok button");
					waitForFrameAndSwitch("iCargoContentFrameOPR335");
				}
				try{
					handleAlert("Accept", "OPR335");
					waitForFrameAndSwitch("iCargoContentFrameOPR335");
				}catch(Exception e){
					InitialSetup.test.log(LogStatus.INFO, "No pop-up post clicking accepting first alert");
					waitForFrameAndSwitch("iCargoContentFrameOPR335");
				}
				InitialSetup.test.log(LogStatus.INFO, "Successfully clicked on Save button");
				click(By.xpath("//button[@name='btnShipperReturn']"));
				enterKeys(By.name("staffId"),"Test");
				enterKeys(By.xpath("//input[@tooltip_info='Valid Until']"), "+1"+Keys.TAB);
				enterKeys(By.name("picesForReturn"), pcs);
				enterKeys(By.name("weightForReturn"), wt);
				selectByText(By.xpath("//select[@name='reasonCode']"), "AWB Cancellation");
				enterKeys(By.xpath("(//textarea[@name='remarks'])"), "Broken");
				click(By.name("btSave"));
				maxWait();
				driver.switchTo().defaultContent();
				String AlertText = driver.findElement(By.xpath("//div[@role='dialog']//p")).getText();
				if(!AlertText.equals(null)){
				InitialSetup.test.log(LogStatus.PASS, AlertText);
				captureAndAddScreenshot();
				}else{
					InitialSetup.test.log(LogStatus.FAIL, "Shipper return failed");
					Assert.fail("Shipper return failed");
					captureAndAddScreenshot();
				}
				click(By.xpath("//div[@class='ui-dialog-buttonset']//button[1]"));
				
				return this;
			}
			
			/**
			 * Method to list an AWB, fill the Manditory fields and click on Save button
			 * 
			 * @param: Location,pcs
			 * @author Sharath on 04/03/2019
			 */
			public OPR335 processGoodsAcceptanceWithoutULDandScreening(String prefix, String awbno,
					String Location, String pcs, String wt, String screening_method) {
				boolean isFound = true;
				minWait();
				prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
				awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
				Location = PropertyHandler.getPropValue(dataFilePath, Location);
				pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
				wt= PropertyHandler.getPropValue(dataFilePath, wt);
				screening_method= PropertyHandler.getPropValue(dataFilePath, screening_method);
				enterKeys(txt_awbPre, prefix);
				enterKeys(txt_awbNo, awbno);
				click(btn_list);
				InitialSetup.test.log(LogStatus.PASS, "Successfully entered AWB No in OPR335 Screen ");
				maxWait();
				click(chkbox_allPartsRcvd);
				click(div_looseAcc);		
				enterKeys(txt_loose_pcs, pcs + Keys.TAB);
				enterKeys(loose_location, Location);
				minWait();
				click(btn_save);
				maxWait();
				maxWait();
				try{
					continueEmbargo();
				}catch(Exception e){
				}
				try{
					handleAlert("Accept", "OPR335");
					waitForFrameAndSwitch("iCargoContentFrameOPR335");
				}catch(Exception e){
					InitialSetup.test.log(LogStatus.INFO, "No pop-up post clicking Ok button");
					waitForFrameAndSwitch("iCargoContentFrameOPR335");
				}
				
				click(tab_expand);
				minWait();
				InitialSetup.test.log(LogStatus.INFO, "Entering the screening details");
				waitForFrameAndSwitch("if11");
				selectByText(sel_screenMethod, screening_method);
				enterKeys(txt_statedpcs,pcs);
				enterKeys(txt_statedwt,wt);
				selectByText(sel_result, "Pass");
				minWait();
				click(btn_btnadd);
				scrollToView(txt_frmDate);
				minWait();
				click(btn_newSavebtn);
				InitialSetup.test.log(LogStatus.INFO, "Clicked on Screening Ok button");
				maxWait();
				maxWait();
				try{
					handleAlert("Accept", "OPR335");
					waitForFrameAndSwitch("iCargoContentFrameOPR335");
				}catch(Exception e){
					InitialSetup.test.log(LogStatus.INFO, "No pop-up post clicking Ok button");
				}
				try{
					handleAlert("Accept", "OPR335");
					waitForFrameAndSwitch("iCargoContentFrameOPR335");
				}catch(Exception e){
					InitialSetup.test.log(LogStatus.INFO, "No pop-up post clicking accepting first alert");
				}
				InitialSetup.test.log(LogStatus.INFO, "The screening details have been entered successfully");
				maxWait();
				click(btn_save);
				minWait();
				handleAlert("Accept", "OPR335");
				waitForFrameAndSwitch("iCargoContentFrameOPR335");
				InitialSetup.test.log(LogStatus.INFO, "Successfully clicked on Save button");
				maxWait();
				maxWait();
				if(driver.findElements(By.xpath("//a[text()='Checksheet - Pending']")).size() > 0){
					captureChecksheetForAvi();
					maxWait();
					click(btn_save);
					try{
						handleAlert("Accept", "OPR335");
						waitForFrameAndSwitch("iCargoContentFrameOPR335");
						maxWait();
					}catch(Exception e){
						waitForFrameAndSwitch("iCargoContentFrameOPR335");
						InitialSetup.test.log(LogStatus.INFO, "No pop-up post clicking Ok button");
					}
				}
				try{
				String actualValue=driver.findElement(By.xpath("(//div[@id='messagePane']/label)[1]")).getText();
				if (actualValue.equalsIgnoreCase("Ready for carriage")) {
					InitialSetup.test.log(LogStatus.PASS, "Goods acceptance has been successfully performed with status : "+actualValue);
					captureAndAddScreenshot();
				}
				else
				{	
					InitialSetup.test.log(LogStatus.FAIL, "Goods acceptance is failed  with status : "+actualValue);
					Assert.fail("Goods acceptance is failed  with status : "+actualValue);
				}
				}catch(Exception e){
					InitialSetup.test.log(LogStatus.FAIL, "Goods acceptance is failed due to : "+e);
					Assert.fail("Goods Acceptance Failed");
				}
				return this;
			}
			
			public OPR335 continueEmbargo()
			{
				try{
					driver.switchTo().frame("popupContainerFrame");
//					click(By.name("btContinue"));
//					click(By.xpath("//*[@name='btContinue']"));
					driver.findElement(By.xpath("//*[@name='btContinue']")).click();
					minWait();
					handleAlert("Accept", "OPR335");
					waitForFrameAndSwitch(FRAME);
					InitialSetup.test.log(LogStatus.INFO, "Restriction has been handled");
					logger.info("Restriction has been handled");
				}catch(Exception e){
					InitialSetup.test.log(LogStatus.INFO, "No Restriction found");
					logger.info("No Restriction found");
				}
				return this;
			}
			
			//Sharath
			public void captureChecksheetForAvi()
			{
				minWait();
				click(By.xpath("//a[text()='Checksheet - Pending']"));
				maxWait();
				maxWait();
				driver.switchTo().frame("popupContainerFrame");
				selectByText(By.xpath("//input[contains(@value,'Was the cat or dog accepted by the local cut-off time')]/parent::label/../following-sibling::div[1]/select"),"Yes");
				selectByText(By.xpath("//input[contains(@value,'Fit for travel')]/parent::label/../following-sibling::div[1]/select"),"Yes");
				selectByText(By.xpath("//input[contains(@value,'no offensive odors')]/parent::label/../following-sibling::div[1]/select"),"Yes");
				selectByText(By.xpath("//input[contains(@value,'attached to kennel')]/parent::label/../following-sibling::div[1]/select"),"Yes");
				selectByText(By.xpath("//input[contains(@value,'WATERING CERTIFICATION attached')]/parent::label/../following-sibling::div[1]/select"),"Yes");
				selectByText(By.xpath("//input[contains(@value,'Separate food and watering dishes')]/parent::label/../following-sibling::div[1]/select"),"Yes");
				selectByText(By.xpath("//input[contains(@value,'Food for a 24 hr. period')]/parent::label/../following-sibling::div[1]/select"),"Yes");
				
				selectByText(By.xpath("//input[contains(@value,'telephone numbers for both origin and destination')]/parent::label/../following-sibling::div[1]/select"),"Yes");
				
				selectByText(By.xpath("//input[contains(@value,'routing codes, customer initials')]/parent::label/../following-sibling::div[1]/select"),"Yes");
				
				selectByText(By.xpath("//input[contains(@value,'neon-yellow point labels attached')]/parent::label/../following-sibling::div[1]/select"),"Yes");
				
				selectByText(By.xpath("//input[contains(@value,'LIVE ANIMAL labels attached to each kennel')]/parent::label/../following-sibling::div[1]/select"),"Yes");
				
				selectByText(By.xpath("//input[contains(@value,'cat or dog cannot escape or poke')]/parent::label/../following-sibling::div[1]/select"),"Yes");
				
				selectByText(By.xpath("//input[contains(@value,'Leak-proof with a solid floor')]/parent::label/../following-sibling::div[1]/select"),"Yes");
				
				selectByText(By.xpath("//input[contains(@value,'Constructed with ventilation openings')]/parent::label/../following-sibling::div[1]/select"),"Yes");
				
				selectByText(By.xpath("//input[contains(@value,'Secured with releasable cable')]/parent::label/../following-sibling::div[1]/select"),"Yes");
				selectByText(By.xpath("//input[contains(@value,'Suitable for the animal to sit erect')]/parent::label/../following-sibling::div[1]/select"),"Yes");
				
				click(By.xpath("//button[@name='btnSave']"));
				maxWait();
				handleAlert("Accept", "OPR026");
				waitForFrameAndSwitch(FRAME);
			    InitialSetup.test.log(LogStatus.INFO, "Successfully entered values in Check Sheet for commodity: ");
			}
			
			//A-8680
			public OPR335 processGoodsAcceptanceWith2ULDs(String prefix, String awbno,
					String pcs, String pcs1,String pcs2, String ULDLocation,String ULDName1, String ULDName2, String wt,String wt1,String wt2, String screening_method) {
				boolean isFound = true;
				InitialSetup.test.log(LogStatus.INFO, "Starting the Goods Acceptance");
				minWait();
				prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
				awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
				pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
				pcs1= PropertyHandler.getPropValue(dataFilePath, pcs1);
				pcs2= PropertyHandler.getPropValue(dataFilePath, pcs2);
				ULDLocation= PropertyHandler.getPropValue(dataFilePath, ULDLocation);
				ULDName1= PropertyHandler.getPropValue(dataFilePath, ULDName1);
				ULDName2= PropertyHandler.getPropValue(dataFilePath, ULDName2);
				wt1= PropertyHandler.getPropValue(dataFilePath, wt1);
				wt2= PropertyHandler.getPropValue(dataFilePath, wt2);
				wt= PropertyHandler.getPropValue(dataFilePath, wt);
				screening_method= PropertyHandler.getPropValue(dataFilePath, screening_method);	
				
				enterKeys(txt_awbPre, prefix);
				enterKeys(txt_awbNo, awbno);
				click(btn_list);
				InitialSetup.test.log(LogStatus.INFO, "Listed the awb : "+prefix+"-"+awbno+" successfully");
				maxWait();
				InitialSetup.test.log(LogStatus.INFO, "Entering the Loose and ULD shipment details");
				click(chkbox_allPartsRcvd);
				
				//To Enter ULD details
				click(Icon_UldAcceptance);
				enterKeys(txt_acceptancPcs,pcs1 + Keys.TAB);
				enterKeys(By.name("uldShipmentWeight"),wt1);
				enterKeys(txt_acceptanceLocatn, ULDLocation);
				enterKeys(txt_acceptanceULD,ULDName1);
				click(btn_acceptanceAdd);	
				minWait();
//				click(Icon_UldAcceptance);
				enterKeys(txt_acceptancPcs,pcs2 + Keys.TAB);
				enterKeys(By.name("uldShipmentWeight"),wt2);
				enterKeys(txt_acceptanceLocatn, ULDLocation);
				enterKeys(txt_acceptanceULD,ULDName2);
				click(btn_acceptanceAdd);
				minWait();
				click(btn_save);
				maxWait();
				handleAlert("Accept", "OPR335");
				minWait();
				waitForFrameAndSwitch("iCargoContentFrameOPR335");
				maxWait();	
				InitialSetup.test.log(LogStatus.INFO, "The Loose and ULD shipment details have been saved successfully");
				click(tab_expand);
				minWait();
				InitialSetup.test.log(LogStatus.INFO, "Entering the screening details");
				waitForFrameAndSwitch("if11");
				selectByText(sel_screenMethod, screening_method);
				enterKeys(txt_statedpcs,pcs);
				enterKeys(txt_statedwt,wt);
				selectByText(sel_result, "Pass");
				minWait();
				click(btn_btnadd);
				scrollToView(txt_frmDate);
				minWait();
				click(btn_newSavebtn);
				captureAndAddScreenshot();
				InitialSetup.test.log(LogStatus.INFO, "Clicked on Screening Ok button");
				maxWait();
				maxWait();
				try{
					handleAlert("Accept", "OPR335");
					waitForFrameAndSwitch("iCargoContentFrameOPR335");
				}catch(Exception e){
					InitialSetup.test.log(LogStatus.INFO, "No pop-up post clicking Ok button");
				}
				try{
					handleAlert("Accept", "OPR335");
					waitForFrameAndSwitch("iCargoContentFrameOPR335");
				}catch(Exception e){
					InitialSetup.test.log(LogStatus.INFO, "No pop-up post clicking accepting first alert");
				}
				InitialSetup.test.log(LogStatus.INFO, "The screening details have been entered successfully");
				maxWait();
				click(btn_save);
				minWait();
				handleAlert("Accept", "OPR335");
				waitForFrameAndSwitch("iCargoContentFrameOPR335");
				InitialSetup.test.log(LogStatus.INFO, "Successfully clicked on Save button");
				maxWait();
				maxWait();
				maxWait();
				try{
				String actualValue=driver.findElement(By.xpath("(//div[@id='messagePane']/label)[1]")).getText();
				if (actualValue.equalsIgnoreCase("Ready for carriage")) {
					InitialSetup.test.log(LogStatus.PASS, "Goods acceptance has been successfully performed with status : "+actualValue);
					captureAndAddScreenshot();
				}
				else
				{	
					InitialSetup.test.log(LogStatus.FAIL, "Goods acceptance is failed  with status : "+actualValue);
					Assert.fail("Goods acceptance is failed  with status : "+actualValue);
					
				}
				}catch(Exception e){
					InitialSetup.test.log(LogStatus.FAIL, "Goods acceptance is failed due to : "+e);
					Assert.fail("Goods Acceptance Failed");
				}
				return this;
			}
			
			
			/**
			 * Method to list an AWB, fill the Manditory fields and click on Save button
			 * 
			 * @param: Location,pcs
			 * @author Sharath on 04/03/2019
			 */
			public OPR335 TestDataCreationProcessGoodsAcceptanceWithoutULDandScreening(String prefix, String awbno,
					String Location, String pcs, String wt) {
				awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
				enterKeys(txt_awbPre, prefix);
				enterKeys(txt_awbNo, awbno);
				click(btn_list);
				InitialSetup.test.log(LogStatus.PASS, "Successfully entered AWB No in OPR335 Screen ");
				maxWait();
				click(chkbox_allPartsRcvd);
				click(div_looseAcc);		
				enterKeys(txt_loose_pcs, pcs + Keys.TAB);
				enterKeys(loose_location, Location);
				click(By.name("btnlooseeadd"));
				minWait();
				click(btn_save);
				maxWait();
				/*try{
					continueEmbargo();
				}catch(Exception e){
				}*/
				try{
					handleAlert("Accept", "OPR335");
					waitForFrameAndSwitch("iCargoContentFrameOPR335");
				}catch(Exception e){
					InitialSetup.test.log(LogStatus.INFO, "No pop-up post clicking Ok button");
					waitForFrameAndSwitch("iCargoContentFrameOPR335");
				}
				
				click(tab_expand);
				minWait();
				InitialSetup.test.log(LogStatus.INFO, "Entering the screening details");
				waitForFrameAndSwitch("if11");
				selectByText(sel_screenMethod, "Screened by TSA");
				enterKeys(txt_statedpcs,pcs);
				enterKeys(txt_statedwt,wt);
				selectByText(sel_result, "Pass");
				minWait();
				click(btn_btnadd);
				scrollToView(txt_frmDate);
				minWait();
				click(btn_newSavebtn);
				InitialSetup.test.log(LogStatus.INFO, "Clicked on Screening Ok button");
				maxWait();
				maxWait();
				try{
					handleAlert("Accept", "OPR335");
					waitForFrameAndSwitch("iCargoContentFrameOPR335");
				}catch(Exception e){
					InitialSetup.test.log(LogStatus.INFO, "No pop-up post clicking Ok button");
				}
				/*try{
					handleAlert("Accept", "OPR335");
					waitForFrameAndSwitch("iCargoContentFrameOPR335");
				}catch(Exception e){
					InitialSetup.test.log(LogStatus.INFO, "No pop-up post clicking accepting first alert");
				}*/
				InitialSetup.test.log(LogStatus.INFO, "The screening details have been entered successfully");
				maxWait();
				click(btn_save);
				minWait();
				handleAlert("Accept", "OPR335");
				waitForFrameAndSwitch("iCargoContentFrameOPR335");
				/*InitialSetup.test.log(LogStatus.INFO, "Successfully clicked on Save button");
				maxWait();
				maxWait();
				if(driver.findElements(By.xpath("//a[text()='Checksheet - Pending']")).size() > 0){
					captureChecksheetForAvi();
					maxWait();
					click(btn_save);
					try{
						handleAlert("Accept", "OPR335");
						waitForFrameAndSwitch("iCargoContentFrameOPR335");
						maxWait();
					}catch(Exception e){
						waitForFrameAndSwitch("iCargoContentFrameOPR335");
						InitialSetup.test.log(LogStatus.INFO, "No pop-up post clicking Ok button");
					}
				}*/
				return this;
			}
			
			
			//A-8680
			public OPR335 processGoodsAcceptanceWithULDbeforeScreeningTestData(String prefix, String awbno,
					String Location, String pcs,String wt,String noOfULDs,String... ULDName) {
				awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
				boolean isFound = true;
				InitialSetup.test.log(LogStatus.INFO, "Starting the Goods Acceptance");
				minWait();
								
				enterKeys(txt_awbPre, prefix);
				enterKeys(txt_awbNo, awbno);
				click(btn_list);
				InitialSetup.test.log(LogStatus.INFO, "Listed the awb : "+prefix+"-"+awbno+" successfully");
				maxWait();
				InitialSetup.test.log(LogStatus.INFO, "Entering the Loose and ULD shipment details");
				click(chkbox_allPartsRcvd);
				minWait();
				scrollToView(Icon_UldAcceptance);
				click(By.xpath("//h2[text()='ULD Acceptance']"));
				
					//To Enter ULD details
					int k = Integer.parseInt(noOfULDs);
//					int z = ULDName.length;
					for(int i=0; i<k;i++){
					maxWait();
					int a = Integer.parseInt(pcs);
					a=a/k;
					int b = Integer.parseInt(wt);
					b=b/k;
					scrollToView(txt_acceptancPcs);
					enterKeys(txt_acceptancPcs,Integer.toString(a) + Keys.TAB);
					enterKeys(By.name("uldShipmentWeight"),Integer.toString(b));
					enterKeys(txt_acceptanceLocatn, Location);
					enterKeys(txt_acceptanceULD,ULDName[i]);
					minWait();
					click(By.name("btnuldeadd"));	
					}
				
				/*if(ULDName[0].equals("")){
//				To enter loose
				click(div_looseAcc);		
//				enterKeys(txt_loose_pcs, blkpcs + Keys.TAB);
				enterKeys(txt_loose_pcs, pcs + Keys.TAB);
				enterKeys(loose_location, Location);
				} else{
				//To Enter ULD details
				int z = ULDName.length;
				for(int i=0; i<=ULDName.length;i++){
				click(Icon_UldAcceptance);
				int a = Integer.parseInt(pcs);
				a=a/z;
				int b = Integer.parseInt(wt);
				b=b/z;
				enterKeys(txt_acceptancPcs,Integer.toString(a) + Keys.TAB);
				enterKeys(By.name("uldShipmentWeight"),Integer.toString(b));
				enterKeys(txt_acceptanceLocatn, Location);
				enterKeys(txt_acceptanceULD,ULDName[i]);
				click(btn_acceptanceAdd);	
				}
			}*/
				minWait();
				click(btn_save);
				maxWait();
				handleAlert("Accept", "OPR335");
				minWait();
				waitForFrameAndSwitch("iCargoContentFrameOPR335");
				maxWait();	
				InitialSetup.test.log(LogStatus.INFO, "The Loose and ULD shipment details have been saved successfully");
				click(tab_expand);
				minWait();
				InitialSetup.test.log(LogStatus.INFO, "Entering the screening details");
				waitForFrameAndSwitch("if11");
				selectByText(sel_screenMethod, "Screened by TSA");
				enterKeys(txt_statedpcs,pcs);
				enterKeys(txt_statedwt,wt);
				selectByText(sel_result, "Pass");
				minWait();
				click(btn_btnadd);
				scrollToView(txt_frmDate);
				minWait();
				click(btn_newSavebtn);
				captureAndAddScreenshot();
				InitialSetup.test.log(LogStatus.INFO, "Clicked on Screening Ok button");
				maxWait();
				maxWait();
				try{
					handleAlert("Accept", "OPR335");
					waitForFrameAndSwitch("iCargoContentFrameOPR335");
				}catch(Exception e){
					InitialSetup.test.log(LogStatus.INFO, "No pop-up post clicking Ok button");
				}
				try{
					handleAlert("Accept", "OPR335");
					waitForFrameAndSwitch("iCargoContentFrameOPR335");
				}catch(Exception e){
					InitialSetup.test.log(LogStatus.INFO, "No pop-up post clicking accepting first alert");
				}
				InitialSetup.test.log(LogStatus.INFO, "The screening details have been entered successfully");
				maxWait();
				click(btn_save);
				minWait();
				handleAlert("Accept", "OPR335");
				waitForFrameAndSwitch("iCargoContentFrameOPR335");
				InitialSetup.test.log(LogStatus.INFO, "Successfully clicked on Save button");
				maxWait();
				maxWait();
				maxWait();
				try{
				String actualValue=driver.findElement(By.xpath("(//div[@id='messagePane']/label)[1]")).getText();
				if (actualValue.equalsIgnoreCase("Ready for carriage")) {
					InitialSetup.test.log(LogStatus.PASS, "Goods acceptance has been successfully performed with status : "+actualValue);
					captureAndAddScreenshot();
				}
				else
				{	
					InitialSetup.test.log(LogStatus.FAIL, "Goods acceptance is failed  with status : "+actualValue);
					Assert.fail("Goods acceptance is failed  with status : "+actualValue);
					
				}
				}catch(Exception e){
					InitialSetup.test.log(LogStatus.FAIL, "Goods acceptance is failed due to : "+e);
					Assert.fail("Goods Acceptance Failed");
				}
				return this;
			}
			
			
			
			/**
			 * Method to make a loose acceptance to a location irrespective of the
			 * status
			 * with Checksheet
			 * @param awbPre
			 * @param awbNo
			 * @param pcs
			 * @param wt
			 * @param location
			 * @return
			 * @author A-8457 Souvik
			 */
			public OPR335 AcceptToLocationWithCheckSheet(String awbPre, String awbNo, String pcs,
					String wt, String location,String UNID) {

				awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
				awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
				pcs = PropertyHandler.getPropValue(dataFilePath, pcs);
				wt = PropertyHandler.getPropValue(dataFilePath, wt);
				location = PropertyHandler.getPropValue(dataFilePath, location);
				UNID = PropertyHandler.getPropValue(dataFilePath, UNID);

				list(awbPre, awbNo);
				minWait();
				minWait();
				/*Assert.assertTrue(
						waitForElement(div_awbDtls).getText().contains(awbNo),
						"ERROR : AWB not listed.");
		*/
				 click(div_looseAcc);
				enterKeys(txt_loose_pcs, pcs + Keys.TAB);
				enterKeys(txt_loose_wt, wt);
				// if(!vol.equals("")) enterKeys(txt_loose_vol, vol);
				enterKeys(loose_location, location);
				maxWait();
				enterKeys(By.xpath("//input[@name='looseShipmentVolume']"),"0.72");
				click(btn_loose_add);
				minWait();

				check(chkbox_allPartsRcvd);

				click(btn_save);
				driver.switchTo().defaultContent();
				
				if (verifyElementPresent(yesBtn))// LAT popup
					click(yesBtn);
				InitialSetup.test.log(LogStatus.INFO, "Goods Acceptance Blocked for screening");
				
				if (verifyElementPresent(yesBtn))
					click(yesBtn);
				
				waitForFrameAndSwitch(FRAME);
				maxWait();
				maxWait();
				
					click(By.xpath("//a[@name='expand']"));
					maxWait();
					maxWait();
					driver.switchTo().frame("if11");
					selectByText(By.xpath("//select[@name='screenMethod']"),"Screened by TSA");
					//click(By.xpath("//select[@name='screenMethod']"));
					//click(By.xpath("//option[@value='MDE']"));
					//doubleClick((WebElement) By.xpath("//select[@name='screenMethod']"));
				//	doubleClick((WebElement) By.xpath("//option[@value='MDE']"));
					
					enterKeys(By.xpath("(//input[@name='statedPieces'])[1]"),pcs);
					enterKeys(By.xpath("(//input[@name='statedWeight'])[1]"), wt);
					selectByText(By.xpath("(//select[@name='result'])[1]"),"Pass");
					enterKeys(By.xpath("(//input[@name='screeningRemarks'])[1]"), "Screening Done");
					click(By.xpath("//button[@name='btnAdd']"));
					InitialSetup.test.log(LogStatus.PASS, "Security screening details entered succesfully");
					minWait();
					click(By.xpath("//button[@name='btSave']"));
					
					
					driver.switchTo().defaultContent();
					if (verifyElementPresent(yesBtn))
						click(yesBtn);
					waitForFrameAndSwitch(FRAME);
					
					//driver.switchTo().frame("iCargoContentFrameOPR335");
					maxWait();
					click(btn_save);
					driver.switchTo().defaultContent();

					if (verifyElementPresent(yesBtn))
						click(yesBtn);

					waitForFrameAndSwitch(FRAME);
					maxWait();
					
					if(driver.findElements(By.xpath("//a[@class='block hovertip'][text()='Checksheet - Pending']")).size() > 0){
					maxWait();
					waitForFrameAndSwitch("popupContainerFrame");
					minWait();
					switch(UNID)
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
					waitForFrameAndSwitch("iCargoContentFrameOPR335");
					minWait();
					//click(btn_save);
					maxWait();
					
					 try{
	                        handleAlert("Accept", "OPR335");
	                        waitForFrameAndSwitch("iCargoContentFrameOPR335");
	                        maxWait();
	                    }catch(Exception e){
	                        waitForFrameAndSwitch("iCargoContentFrameOPR335");
	                        InitialSetup.test.log(LogStatus.INFO, "No pop-up post clicking Ok button");
	                    }
	                }
					
					String message=driver.findElement(By.xpath("//label[@class='message-short complete m-t-15 pull-left block']")).getText();
					if(message.contains("Ready for carriage"))
					{
						InitialSetup.test.log(LogStatus.PASS, "Goods acceptance successfully done");
					}
					else
					{
						InitialSetup.test.log(LogStatus.FAIL, "Goods Acceptance failed");
						Assert.fail("Goods Acceptance failed");
					}

				//click(icon_edit);
				//click(btn_clear);
				
				return this;
			}

}
