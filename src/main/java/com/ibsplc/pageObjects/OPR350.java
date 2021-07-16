package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.ibsplc.common.BasePage;
import com.ibsplc.generic.InitialSetup;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Screen OPR350 - Capture DG Details Screen
 * @author Souvik
 * A-8457
 * on 24th March-2020
 */
public class OPR350 extends BasePage {

	public static String FRAME = "iCargoContentFrameOPR350";
	public static String screenFrame = "iCargoContentFrameOPR350";
	private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties",
			"OPR_FLT.properties");
	private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties",
			"Generic.properties");
	WebDriver driver;
	String dataFileName;
	private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");

	private By txtbx_carriercode, txtbx_ATDdate, txtbx_flightNumber, txtbx_date, btn_List;
	private By sel_blockedFor, txt_remarks, btn_blk_details, chcbx_Bulk, btn_manifst, btn_finalize, btn_close, yesBtn,
			btn_editIcon, btn_switchRole, btn_station, btn_ok, btn_flightfinalize, txt_statusfinalized, btn_assignhere,
			btn_Manifest, btn_PopOk, btn_Popup_Save,
			// A-7290
			Select_Rolegroup, btn_Bulk, Icon_bulk;

	public OPR350(WebDriver driver, String dataFileName) {
		super(driver);
		this.driver = driver;
		initElements();
		this.dataFilePath = this.dataFilePath + dataFileName;
		this.dataFileName = dataFileName;
	}

	/**
	 * Method to initialize page elements
	 */
	private void initElements() {
		yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
		
	}

	/**
	 
	 * @author Souvik
	 * A-8457
	 * Capture DG details
	 */
	public OPR350 CapturedDGDetails(String awbno) {
		
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		
		
		
		maxWait();
		enterKeys(By.name("masterDocumentNumber"), awbno);
		click(By.name("btList"));
		maxWait();
		click(By.xpath("//i[@class='icon edit']"));
		minWait();
		enterKeys(By.name("shipperpobox"), "245245");
		enterKeys(By.name("consigneepobox"), "245245");
		enterKeys(By.name("shipmentlimitation"), "DG");
		enterKeys(By.name("shipmenttype"), "DG");
		enterKeys(By.name("additionalhandlingInformation"), "TEST");
		enterKeys(By.name("warning"), "TEST");
		enterKeys(By.name("declaration"), "TEST");
		enterKeys(By.name("nameortitleofsignatory"), "TEST");
		enterKeys(By.name("place"), "TEST");
		enterKeys(By.name("signature"),"TEST");
		enterKeys(By.name("signatoryDate"), "."+Keys.TAB);
		enterKeys(By.name("signatoryTime"), "0000");
		minWait();
		click(By.xpath("//button[@name='btnShipperReferenceOk']"));
		minWait();
		click(By.xpath("//button[@name='btnSave']"));
		maxWait();
		
		InitialSetup.test.log(LogStatus.PASS, "DG Details has been succesfully captured");
		return this;		
	}

	public HomePage close() {

		click(By.xpath("//button[@name='btnClose']"));
		driver.switchTo().defaultContent();
		if (verifyElementPresent(yesBtn)) {

			click(yesBtn);
		}
		return new HomePage(driver, dataFileName);
	}

}