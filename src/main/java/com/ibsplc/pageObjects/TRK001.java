/**
 * 
 */
package com.ibsplc.pageObjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * @author A-8457  on 02/4/2020
 *
 */

import com.ibsplc.common.BasePage;
import com.ibsplc.generic.InitialSetup;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Created Souvik on 02/4/2020.
 */
public class TRK001 extends BasePage {
	private final static Logger logger = Logger.getLogger(TRK001.class);
	public static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties",
			"LTE_CSH_CLM.properties");
	public static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties",
			"Generic.properties");
	public static String FRAME = "iCargoContentFrameTRK001";
	private String screenFrame = "iCargoContentFrameTRK001";
	private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
	private WebDriver driver;
	private String dataFileName;

	private By

	txt_carrierCode;

	private By btn_genericYes, info_footer, info_msg;

	public TRK001(WebDriver driver, String dataFileName) {
		super(driver);
		this.driver = driver;
		this.dataFilePath = dataFilePath + dataFileName;
		this.dataFileName = dataFileName;
		initElements();
	}

	/**
	 * Initializes all the elements
	 * 
	 * Created Souvik on 02/4/2020.
	 */
	private void initElements() {

		info_msg = MiscUtility.getWebElement(genObjPath, "Generic_info_msg");
		btn_genericYes=MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");

	}





	/**
	 * Created by Souvik
	 * A-8457
	 * 
	 * To generate TRUCK order
	 * 
	 * @return
	 */

	public TRK001 GenerateTruckOrder(String carriercode, String awbno, String fltNo, String fltDt) {
		minWait();
		//prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		carriercode = PropertyHandler.getPropValue(dataFilePath, carriercode);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		minWait();
		click(By.xpath("//label[text()='Truck Order No.']"));
		enterKeys(By.name("flightCarrierCode"), carriercode);
		enterKeys(By.name("flightNumber"), fltNo);
		enterKeys(By.name("flightDate"), fltDt+Keys.TAB);
		minWait();
		driver.findElement(By.xpath("//button[@name='btList']")).click();
		maxWait();
		//------------------------Added by Faizan--------------------------------
		driver.switchTo().defaultContent();
		if(verifyElementPresent(By.xpath("//div[@id='ic-sd-msgc']//p")))
		{
			String text=driver.findElement(By.xpath("//div[@id='ic-sd-msgc']//p")).getText();
			if(text.contains("already has a Truck Order"))
			{
				InitialSetup.test.log(LogStatus.INFO, "PopUp in Generate Truck Order: "+text);
				driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
				minWait();
			}
		}
		waitForFrameAndSwitch(FRAME);
		//------------------------------till here----------------------------
		check(By.xpath("//input[@name='checkAll']"));
		scrollToView(By.xpath("//strong[@class='mar-l-2sm'][text()='Outbound']"));
		click(By.xpath("//strong[@class='mar-l-2sm'][text()='Outbound']/preceding-sibling::span"));
		minWait();
		enterKeys(By.name("outboundTruckDriverName"), "TEST");
		enterKeys(By.name("outboundContactNumber"),"123456789");
		selectByText(By.name("outboundTruckSecuredBy"), "LOCK");
		enterKeys(By.name("outboundSealNumber"), "1122");
		scrollToView(By.name("generalRemarks"));
		selectByText(By.name("outboundStaidrType"), "HAZMAT");
		enterKeys(By.name("outboundStaidr"), "US");
		minWait();
		enterKeys(By.name("actualDateDepature"), "-1"+Keys.TAB);
		enterKeys(By.name("actualTimeDepature"), "0000");
		enterKeys(By.name("generalRemarks"), "TEST");
		minWait();
		click(By.xpath("//button[@name='btSave']"));
		maxWait();
		driver.switchTo().defaultContent();
		captureAndAddScreenshot();
		String truckorderno=driver.findElement(By.xpath("//div[@class='ic-dialog-msg-container']/p")).getText();
		PropertyHandler.setPropValue(dataFilePath,"TruckorderNo", truckorderno);
		click(By.xpath("//button[@class='ui-button ui-corner-all ui-widget']"));
		minWait();
		waitForFrameAndSwitch(FRAME);
		minWait();
		click(By.xpath("//button[@name='btApprove']"));
		minWait();
		driver.switchTo().defaultContent();
		click(By.xpath("//button[@class='btn primary ui-button ui-corner-all ui-widget']"));
		waitForFrameAndSwitch(FRAME);
		maxWait();
		driver.switchTo().defaultContent();
		click(By.xpath("//button[@class='ui-button ui-corner-all ui-widget']"));
		waitForFrameAndSwitch(FRAME);
		maxWait();
		click(By.xpath("//button[@name='btFinalize']"));
		minWait();
		driver.switchTo().defaultContent();
		click(By.xpath("//button[@class='btn primary ui-button ui-corner-all ui-widget']"));
		waitForFrameAndSwitch(FRAME);
		minWait();
		driver.switchTo().defaultContent();
		click(By.xpath("//button[@class='btn primary ui-button ui-corner-all ui-widget']"));
		waitForFrameAndSwitch(FRAME);
		maxWait();
		return this;
	}


	/**
	 * CLose and screen and go to home page
	 * 
	 * @return Created Souvik on 02/4/2020.
	 */
	public HomePage close() {
		minWait();
		driver.findElement(By.xpath("//button[@name='btClose']")).click();
		driver.switchTo().defaultContent();
		if (verifyElementPresent(btn_genericYes)) {
			click(btn_genericYes);
		}
		return new HomePage(driver, dataFileName);
	}



	/**
	 * Created by Souvik
	 * A-8457
	 * 
	 * To generate TRUCK order for Fictious Truck
	 * 
	 * @return
	 * @throws InterruptedException 
	 */

	public TRK001 GenerateTruckOrderFictious(String carriercode, String fltNo, String fltDt) throws InterruptedException {

		minWait();
		//prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		carriercode = PropertyHandler.getPropValue(dataFilePath, carriercode);
		//awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);

		minWait();
		enterKeys(By.name("flightCarrierCode"), carriercode);
		enterKeys(By.name("flightNumber"), fltNo);
		enterKeys(By.name("flightDate"), fltDt+Keys.TAB);
		minWait();
		driver.findElement(By.xpath("//button[@name='btList']")).click();
		maxWait();

		click(By.xpath("//button[@class='btn default dropdown-toggle']"));
		Thread.sleep(2000);
		click(By.xpath("(//a[@class='dropdown-item'][text()='Regular Bookings'])[2]"));
		maxWait();
		driver.switchTo().frame("popupContainerFrame");
		driver.findElement(By.xpath("//input[@name='awbPrefix']")).clear();
		driver.findElement(By.xpath("//input[@name='carrierCode']")).clear();
		enterKeys(By.xpath("//input[@name='flightDateFrom']"), "-2"+Keys.TAB);
		enterKeys(By.xpath("//input[@name='flightDateTo']"), "+2"+Keys.TAB);
		minWait();
		click(By.xpath("//button[@name='btList'][@id='BTN_CAPACITY_BOOKING_STANDARD_LISTBOOKINGS_LIST']"));
		maxWait();
		captureAndAddScreenshot();
		check(By.xpath("(//input[@name='checkRow'])[1]"));
		minWait();
		click(By.xpath("//button[@name='okButtonforTruck']"));
		minWait();
		waitForFrameAndSwitch(FRAME);

		minWait();
		check(By.xpath("//input[@name='checkAll']"));
		scrollToView(By.xpath("//strong[@class='mar-l-2sm'][text()='Outbound']"));
		click(By.xpath("//strong[@class='mar-l-2sm'][text()='Outbound']/preceding-sibling::span"));
		minWait();
		enterKeys(By.name("outboundTruckDriverName"), "TEST");
		enterKeys(By.name("outboundContactNumber"),"123456789");
		selectByText(By.name("outboundTruckSecuredBy"), "LOCK");
		enterKeys(By.name("outboundSealNumber"), "1122");
		selectByText(By.name("outboundStaidrType"), "Drivers License");
		enterKeys(By.name("outboundStaidr"), "US");
		minWait();
		enterKeys(By.name("actualDateDepature"), "-1"+Keys.TAB);
		enterKeys(By.name("actualTimeDepature"), "0000");
		enterKeys(By.name("generalRemarks"), "TEST");
		minWait();
		click(By.xpath("//button[@name='btSave']"));
		maxWait();
		driver.switchTo().defaultContent();
		captureAndAddScreenshot();
		String truckorderno=driver.findElement(By.xpath("//div[@class='ic-dialog-msg-container']/p")).getText();
		System.out.println(truckorderno);
		PropertyHandler.setPropValue(dataFilePath,"TruckorderNo", truckorderno);
		click(By.xpath("//button[text()='OK']"));
		minWait();
		waitForFrameAndSwitch(FRAME);
		minWait();
		click(By.xpath("//button[@name='btApprove']"));
		minWait();
		driver.switchTo().defaultContent();
		click(By.xpath("//button[text()='Yes']"));
		waitForFrameAndSwitch(FRAME);
		maxWait();
		driver.switchTo().defaultContent();
		click(By.xpath("//button[text()='OK']"));
		waitForFrameAndSwitch(FRAME);
		maxWait();
		click(By.xpath("//button[@name='btFinalize']"));
		minWait();
		driver.switchTo().defaultContent();
		click(By.xpath("//button[text()='Yes']"));
		waitForFrameAndSwitch(FRAME);
		minWait();
		driver.switchTo().defaultContent();
		click(By.xpath("//button[text()='Yes']"));
		waitForFrameAndSwitch(FRAME);
		maxWait();
		InitialSetup.test.log(LogStatus.PASS, "Truck order Succesfully generated with order No. "+truckorderno);
		maxWait();
		return this;
	}

	/**
	 * Created by Souvik
	 * A-8457
	 * 
	 * To generate TRUCK order with Empty Containers
	 * 
	 * @return
	 */

	public TRK001 GenerateTruckOrderWithEmptyContainers(String carriercode, String awbno, String fltNo, String fltDt, String ULD1, String ULD2) {

		minWait();
		//prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		carriercode = PropertyHandler.getPropValue(dataFilePath, carriercode);
		awbno = PropertyHandler.getPropValue(dataFilePath, awbno);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		ULD1 = PropertyHandler.getPropValue(dataFilePath, ULD1);
		ULD2 = PropertyHandler.getPropValue(dataFilePath, ULD2);

		minWait();
		enterKeys(By.name("flightCarrierCode"), carriercode);
		enterKeys(By.name("flightNumber"), fltNo);
		enterKeys(By.name("flightDate"), fltDt+Keys.TAB);
		minWait();
		driver.findElement(By.xpath("//button[@name='btList']")).click();
		maxWait();

		click(By.xpath("//a[text()='Empty ULD']"));
		minWait();
		click(By.xpath("//button[@name='btULDAdd']"));
		minWait();
		enterKeys(By.xpath("(//input[@name='emptyUldNumber'])[1]"), ULD1);
		minWait();
		click(By.xpath("//button[@name='btULDAdd']"));
		minWait();
		enterKeys(By.xpath("(//input[@name='emptyUldNumber'])[2]"), ULD2);
		minWait();
		click(By.xpath("//a[text()='AWB Details']"));
		minWait();

		check(By.xpath("//input[@name='checkAll']"));
		scrollToView(By.xpath("//strong[@class='mar-l-2sm'][text()='Outbound']"));
		click(By.xpath("//strong[@class='mar-l-2sm'][text()='Outbound']/preceding-sibling::span"));
		minWait();
		enterKeys(By.name("outboundTruckDriverName"), "TEST");
		enterKeys(By.name("outboundContactNumber"),"123456789");
		selectByText(By.name("outboundTruckSecuredBy"), "LOCK");
		enterKeys(By.name("outboundSealNumber"), "1122");
		selectByText(By.name("outboundStaidrType"), "Drivers License");
		enterKeys(By.name("outboundStaidr"), "US");
		minWait();
		enterKeys(By.name("actualDateDepature"), "-1"+Keys.TAB);
		enterKeys(By.name("actualTimeDepature"), "0000");
		enterKeys(By.name("generalRemarks"), "TEST");
		minWait();
		click(By.xpath("//button[@name='btSave']"));
		maxWait();
		driver.switchTo().defaultContent();
		captureAndAddScreenshot();
		String truckorderno=driver.findElement(By.xpath("//div[@class='ic-dialog-msg-container']/p")).getText();
		System.out.println(truckorderno);
		PropertyHandler.setPropValue(dataFilePath,"TruckorderNo", truckorderno);
		click(By.xpath("//button[@class='ui-button ui-corner-all ui-widget']"));
		minWait();
		waitForFrameAndSwitch(FRAME);
		minWait();
		click(By.xpath("//button[@name='btApprove']"));
		minWait();
		driver.switchTo().defaultContent();
		click(By.xpath("//button[@class='btn primary ui-button ui-corner-all ui-widget']"));
		waitForFrameAndSwitch(FRAME);
		maxWait();
		driver.switchTo().defaultContent();
		click(By.xpath("//button[@class='ui-button ui-corner-all ui-widget']"));
		waitForFrameAndSwitch(FRAME);
		maxWait();
		click(By.xpath("//button[@name='btFinalize']"));
		minWait();
		driver.switchTo().defaultContent();
		click(By.xpath("//button[@class='btn primary ui-button ui-corner-all ui-widget']"));
		waitForFrameAndSwitch(FRAME);
		minWait();
		driver.switchTo().defaultContent();
		click(By.xpath("//button[@class='btn primary ui-button ui-corner-all ui-widget']"));
		waitForFrameAndSwitch(FRAME);
		maxWait();
		InitialSetup.test.log(LogStatus.PASS, "Truck order Succesfully generated with order No. "+truckorderno);
		maxWait();
		return this;
	}



	/**
	 * Created by Souvik
	 * A-8457
	 * 
	 * To generate TRUCK order for Fictious Truck
	 * 
	 * @return
	 * @throws InterruptedException 
	 */

	public TRK001 GenerateTruckOrderForTransferShipment(String awbNo,String carriercode, String fltNo, String fltDt , String CTMOutNo) throws InterruptedException {

		minWait();
		//prefix = PropertyHandler.getPropValue(dataFilePath, prefix);
		carriercode = PropertyHandler.getPropValue(dataFilePath, carriercode);
		awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		CTMOutNo = PropertyHandler.getPropValue(dataFilePath, CTMOutNo);

		minWait();
		enterKeys(By.name("flightCarrierCode"), carriercode);
		enterKeys(By.name("flightNumber"), fltNo);
		enterKeys(By.name("flightDate"), fltDt+Keys.TAB);
		minWait();
		driver.findElement(By.xpath("//button[@name='btList']")).click();
		maxWait();
		click(By.xpath("//button[text()='Get Shipments']"));
		minWait();
		click(By.xpath("(//a[text()='Transfer Shipments'])[last()]"));
		maxWait();
		driver.switchTo().frame("popupContainerFrame");
		minWait();
		enterKeys(By.xpath("//input[@name='ctmReference']"), CTMOutNo);
		minWait();
		click(By.xpath("(//button[@name='btList'])"));
		maxWait();
		check(By.xpath("//input[@name='chkBoxAccEnqAll']"));
		minWait();
		click(By.xpath("//button[@name='btAddtoTruck']"));
		maxWait();
		driver.switchTo().frame(FRAME);
		minWait();
		click(By.xpath("//button[text()='Get Shipments']"));
		Thread.sleep(2000);
		click(By.xpath("(//a[text()='Regular Bookings'])[last()]"));
		maxWait();
		driver.switchTo().frame("popupContainerFrame");
		driver.findElement(By.xpath("//input[@name='awbPrefix']")).clear();
		driver.findElement(By.xpath("//input[@name='carrierCode']")).clear();
		enterKeys(By.xpath("//input[@name='flightDateFrom']"), fltDt+Keys.TAB);
		enterKeys(By.xpath("//input[@name='flightDateTo']"), fltDt+Keys.TAB);
		minWait();
		click(By.xpath("//button[@name='btList'][@id='BTN_CAPACITY_BOOKING_STANDARD_LISTBOOKINGS_LIST']"));
		maxWait();
		captureAndAddScreenshot();
		
		check(By.xpath("(//a[contains(.,'"+awbNo+"')])[last()]/../../preceding-sibling::td/input[@name='checkRow']"));
		minWait();
		scrollToView(By.xpath("//button[@name='okButtonforTruck']"));
		click(By.xpath("//button[@name='okButtonforTruck']"));
		minWait();
		if(verifyElementPresent(By.xpath("//td[contains(@class,'error-msg')]"))){
			InitialSetup.test.log(LogStatus.INFO, getText_JS(By.xpath("//td[contains(@class,'error-msg')]")).trim());
			captureAndAddScreenshot();
			driver.findElement(By.name("btClose")).click();
			minWait();
		}
		waitForFrameAndSwitch(FRAME);
		minWait();
		check(By.xpath("//input[@name='checkAll']"));
		scrollToView(By.xpath("//strong[@class='mar-l-2sm'][text()='Outbound']"));
		click(By.xpath("//strong[@class='mar-l-2sm'][text()='Outbound']/preceding-sibling::span"));
		minWait();
		enterKeys(By.name("outboundTruckDriverName"), "TEST");
		enterKeys(By.name("outboundContactNumber"),"123456789");
		selectByText(By.name("outboundTruckSecuredBy"), "LOCK");
		enterKeys(By.name("outboundSealNumber"), "1122");
		selectByText(By.name("outboundStaidrType"), "Drivers License");
		enterKeys(By.name("outboundStaidr"), "US");
		minWait();
		enterKeys(By.name("actualDateDepature"), "."+Keys.TAB);
		enterKeys(By.name("actualTimeDepature"), "0000");
		enterKeys(By.name("generalRemarks"), "TEST");
		minWait();
		click(By.xpath("//button[@name='btSave']"));
		maxWait();
		driver.switchTo().defaultContent();
		captureAndAddScreenshot();
		String truckorderno=driver.findElement(By.xpath("//div[@class='ic-dialog-msg-container']/p")).getText();
		System.out.println(truckorderno);
		PropertyHandler.setPropValue(dataFilePath,"TruckorderNo", truckorderno);
		if(verifyElementPresent(By.xpath("//button[text()='Yes']")))
			click(By.xpath("//button[text()='Yes']"));
		maxWait();
		click(By.xpath("//button[text()='OK']"));
		waitForFrameAndSwitch(FRAME);
		minWait();
		CheckVersion("1");
		click(By.xpath("//button[@name='btApprove']"));
		minWait();
		driver.switchTo().defaultContent();
		click(By.xpath("//button[text()='Yes']"));
		maxWait();
		click(By.xpath("//button[text()='OK']"));
		waitForFrameAndSwitch(FRAME);
		maxWait();
		CheckVersion("2");
		click(By.xpath("//button[@name='btFinalize']"));
		minWait();
		driver.switchTo().defaultContent();
		click(By.xpath("//button[text()='Yes']"));
		maxWait();
		click(By.xpath("//button[text()='Yes']"));
		waitForFrameAndSwitch(FRAME);
		maxWait();
		CheckVersion("3");
		//Truck cost estimation
		TruckCostEstimation(false,awbNo);
		InitialSetup.test.log(LogStatus.PASS, "Truck order Succesfully generated with order No. "+truckorderno);
		maxWait();
		return this;
	}


	/**
	 * Created by Souvik
	 * A-8457
	 * 
	 * To Check the Version Status
	 * 
	 * @return
	 * @throws InterruptedException 
	 */

	public TRK001 CheckVersion(String version) throws InterruptedException {

		minWait();
		String ver=driver.findElement(By.xpath("//span[@class='version-count mar-x-2xs']")).getText();
		if(ver.contains(version))
		{
			InitialSetup.test.log(LogStatus.PASS, "Version Number is Correct");
		}
		else
		{
			InitialSetup.test.log(LogStatus.FAIL, "Version Number is InCorrect");
			//			Assert.fail();
		}
		minWait();
		return this;
	}


	/**
	 * Created by Souvik
	 * A-8457
	 * 
	 * To see the truck cost estimation
	 * 
	 * @return
	 * @throws InterruptedException 
	 */

	public TRK001 TruckCostEstimation(boolean getAWB,String awbNo) throws InterruptedException {

		if(getAWB)
			awbNo=PropertyHandler.getPropValue(dataFilePath, awbNo);//Added by Faizan
		String pre="//td/a[contains(text(),'";
		String suff="')]/parent::td/following-sibling::td";
		minWait();
		String ver= driver.findElement(By.xpath(pre+awbNo+suff+"/div/span[@id='estimatedCharge_LBL']")).getText();
		minWait();
		String ver1[]=ver.split("\\.");
		int a = Integer.parseInt(ver1[0]);
		if(a>0)
		{
			InitialSetup.test.log(LogStatus.PASS, "Truck Cost estimation is Stamped");
		}
		else
		{
			InitialSetup.test.log(LogStatus.WARNING, "Truck Cost estimation is not stamped");
//			Assert.fail();
		}
		minWait();
		return this;
	}

	/**
	 * @author A-8452 Faizan
	 * @param carrierCode
	 * @param fltNo
	 * @param fltDt
	 * @return
	 */
	public TRK001 listFlight(String carrierCode, String fltNo,String fltDt)
	{
		carrierCode = PropertyHandler.getPropValue(dataFilePath, carrierCode);
		fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
		fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
		driver.findElement(By.xpath("//label[contains(text(),'Truck Order No.')]")).click();
		minWait();
		enterKeys(By.name("flightCarrierCode"), carrierCode);
		enterKeys(By.name("flightNumber"), fltNo);
		enterKeys(By.name("flightDate"), fltDt+Keys.TAB);
		minWait();
		driver.findElement(By.xpath("//button[@name='btList']")).click();
		maxWait();
		//------------------------Added by Faizan--------------------------------
		driver.switchTo().defaultContent();
		if(verifyElementPresent(By.xpath("//div[@id='ic-sd-msgc']//p")))
		{
			String text=driver.findElement(By.xpath("//div[@id='ic-sd-msgc']//p")).getText();
			if(text.contains("already has a Truck Order"))
			{
				InitialSetup.test.log(LogStatus.INFO, "PopUp in Generate Truck Order: "+text);
				driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
				minWait();
			}

		}
		waitForFrameAndSwitch(FRAME);
		//------------------------------till here----------------------------
		return this;
	}


	/**
	 * @author A-8452 Faizan
	 * @param awbNo
	 * @param totalPcs
	 * @param totalWt
	 * @param availablePcs
	 * @param availableWt
	 * @param actualPcs
	 * @param actualWt
	 * @return
	 */
	public TRK001 VerifyGeneratedTruckOrder(String awbNo, String totalPcs, String totalWt, String availablePcs, String availableWt,
			String actualPcs, String actualWt)
	{
		awbNo=PropertyHandler.getPropValue(dataFilePath, awbNo);
		totalPcs=PropertyHandler.getPropValue(dataFilePath, totalPcs);
		totalWt=PropertyHandler.getPropValue(dataFilePath, totalWt);
		availablePcs=PropertyHandler.getPropValue(dataFilePath, availablePcs);
		availableWt=PropertyHandler.getPropValue(dataFilePath, availableWt);
		actualPcs=PropertyHandler.getPropValue(dataFilePath, actualPcs);
		actualWt=PropertyHandler.getPropValue(dataFilePath, actualWt);
		captureAndAddScreenshot();
		
		maxWait();
		
		String pre="//td/a[contains(text(),'";
		String suff="')]/parent::td/following-sibling::td";

		String TotalPcs=driver.findElement(By.xpath(pre+awbNo+suff+"[3]")).getText();
		String TotalWt=driver.findElement(By.xpath(pre+awbNo+suff+"[4]")).getText();

		if((TotalWt.split("\\."))[0].equalsIgnoreCase(totalWt))
			TotalWt=(TotalWt.split("\\."))[0];

		String AvailablePcs=driver.findElement(By.xpath(pre+awbNo+suff+"[10]")).getText();
		String AvailableWt=driver.findElement(By.xpath(pre+awbNo+suff+"[11]")).getText();
		if((AvailableWt.split("\\."))[0].equalsIgnoreCase(availableWt))
			AvailableWt=(AvailableWt.split("\\."))[0];

		String ActualPcs=driver.findElement(By.xpath(pre+awbNo+suff+"[12]")).getText();
		String ActualWt=driver.findElement(By.xpath(pre+awbNo+suff+"[13]")).getText();
		if((ActualWt.split("\\."))[0].equalsIgnoreCase(actualWt))
			ActualWt=(ActualWt.split("\\."))[0];

		String estimatedCharge= driver.findElement(By.xpath(pre+awbNo+suff+"/div/span[@id='estimatedCharge_LBL']")).getText();

		if(!totalPcs.equalsIgnoreCase(TotalPcs))
		{
			InitialSetup.test.log(LogStatus.FAIL, "Total Pieces mismatch");
			logger.info("Total Pieces mismatch");
			Assert.fail();
		}
		else
			InitialSetup.test.log(LogStatus.PASS, "Total Pieces stamped is correct");
			logger.info("Total Pieces stamped is correct");

		if(!totalWt.equalsIgnoreCase(TotalWt))
		{
			InitialSetup.test.log(LogStatus.FAIL, "Total weight mismatch");
			logger.info("Total weight mismatch");
			Assert.fail();
		}
		else
			InitialSetup.test.log(LogStatus.PASS, "Total weight stamped is correct");
		logger.info("Total weight stamped is correct");



		if(!availablePcs.equalsIgnoreCase(AvailablePcs))
		{
			InitialSetup.test.log(LogStatus.FAIL, "Available pieces mismatch");
			logger.info("Available pieces mismatch");
			Assert.fail();
		}
		else
			InitialSetup.test.log(LogStatus.PASS, "Available pieces stamped is correct");
		logger.info("Available pieces stamped is correct");


		if(!availableWt.equalsIgnoreCase(AvailableWt))
		{
			InitialSetup.test.log(LogStatus.FAIL, "Available weight mismatch");
			logger.info("Available weight mismatch");
			Assert.fail();
		}
		else
			InitialSetup.test.log(LogStatus.PASS, "Available weight stamped is correct");
		logger.info("Available weight stamped is correct");




		if(!actualPcs.equalsIgnoreCase(ActualPcs))
		{
			InitialSetup.test.log(LogStatus.FAIL, "Actual pieces mismatch");
			logger.info("Actual pieces mismatch");
			Assert.fail();
		}
		else
			InitialSetup.test.log(LogStatus.PASS, "Actual pieces stamped is correct");
		logger.info("Actual pieces stamped is correct");


		if(!actualWt.equalsIgnoreCase(ActualWt))
		{
			InitialSetup.test.log(LogStatus.FAIL, "Actual weight mismatch");
			logger.info("Actual weight mismatch");
			Assert.fail();
		}
		else
			InitialSetup.test.log(LogStatus.PASS, "Actual weight stamped is correct");
		logger.info("Total Pieces stamped is correct");


		InitialSetup.test.log(LogStatus.INFO, "The estimated cost: "+estimatedCharge);
		logger.info("The estimated cost: "+estimatedCharge);



		return this;
	}



	public TRK001 getShipment(String prefix, String toBeAddedAwbNo)
	{
		prefix=PropertyHandler.getPropValue(dataFilePath, prefix);
		toBeAddedAwbNo=PropertyHandler.getPropValue(dataFilePath, toBeAddedAwbNo);
		maxWait();
		driver.findElement(By.xpath("//button[@id='btnGroupDrop1']")).click();
		driver.findElement(By.xpath("(//a[@name='regularBooking_Btn'])[2]")).click();
		minWait();
		minWait();
		driver.switchTo().frame("popupContainerFrame");
		enterKeys(By.xpath("//input[@name='awbPrefix']"), prefix);
		enterKeys(By.xpath("//input[@name='awbNumber']"), toBeAddedAwbNo);
		minWait();
		click(By.xpath("//button[@id='BTN_CAPACITY_BOOKING_STANDARD_LISTBOOKINGS_LIST']"));
		maxWait();
		captureAndAddScreenshot();
		check(By.xpath("(//input[@name='checkRow'])[1]"));
		minWait();
		click(By.xpath("//button[@name='okButtonforTruck']"));
		minWait();
		waitForFrameAndSwitch(FRAME);

		minWait();

		return this;
	}

	public TRK001 CheckAwbApproveAndFinalise(String awbNo) {
		awbNo=PropertyHandler.getPropValue(dataFilePath, awbNo);
		minWait();
		String pre="//td/a[contains(text(),'";
		String suff="')]";

		if(!verifyElementPresent(By.xpath(pre+awbNo+suff)))
		{
			InitialSetup.test.log(LogStatus.FAIL, "AWB Number is not listed in the screen");
			Assert.fail();
		}
		else{
			InitialSetup.test.log(LogStatus.PASS, "AWB is successfully listed");
			check(By.xpath("//input[@name='checkAll']"));
		}
		captureAndAddScreenshot();
		enterOutbounDetails();
		enterATDdetails();
		saveTheDetails();
		approveTheDetails();
		finalizeTheDetails();
		/*try {
			TruckCostEstimation(false,awbNo);
		} catch (InterruptedException e) {
			InitialSetup.test.log(LogStatus.INFO, "Truck cost estimation is not done");
		}*/
		maxWait();
		return this;
	}

	public TRK001 enterATDdetails() {

		minWait();
		scrollToView(By.name("generalRemarks"));
		enterKeys(By.name("actualDateDepature"), "-1"+Keys.TAB);
		enterKeys(By.name("actualTimeDepature"), "0000");
		enterKeys(By.name("generalRemarks"), "TEST");

		return this;

	}

	public TRK001 enterOutbounDetails() {

		minWait();
		check(By.xpath("//input[@name='checkAll']"));
		scrollToView(By.xpath("//strong[@class='mar-l-2sm'][text()='Outbound']"));
		click(By.xpath("//strong[@class='mar-l-2sm'][text()='Outbound']/preceding-sibling::span"));
		minWait();
		enterKeys(By.name("outboundTruckDriverName"), "TEST");
		enterKeys(By.name("outboundContactNumber"),"123456789");
		selectByText(By.name("outboundTruckSecuredBy"), "LOCK");
		enterKeys(By.name("outboundSealNumber"), "1122");
		selectByText(By.name("outboundStaidrType"), "HAZMAT");
		enterKeys(By.name("outboundStaidr"), "US");

		return this;

	}

	public TRK001 finalizeTheDetails() {
		minWait();
		click(By.xpath("//button[@name='btFinalize']"));
		minWait();
		driver.switchTo().defaultContent();
		if(verifyElementPresent(By.xpath("//p[contains(text(),'Do you want to mark')]")))
		click(By.xpath("//p[contains(text(),'Do you want to mark')]/following::button[text()='Yes']"));
		waitForFrameAndSwitch(FRAME);
		minWait();
		driver.switchTo().defaultContent();
		if(verifyElementPresent(By.xpath("//button[text()='Yes']")))
		click(By.xpath("//button[text()='Yes']"));
		waitForFrameAndSwitch(FRAME);
		maxWait();
		checkStatus(false, "Finalized");
		return this;
	}


/**
 * @author A-8452 Faizan
 * @return
 */
	public TRK001 approveTheDetails() {
		minWait();
		click(By.xpath("//button[@name='btApprove']"));
		minWait();
		driver.switchTo().defaultContent();
		if(verifyElementPresent(By.xpath("//button[@class='btn primary ui-button ui-corner-all ui-widget']")))
			click(By.xpath("//button[@class='btn primary ui-button ui-corner-all ui-widget']"));
		waitForFrameAndSwitch(FRAME);
		minWait();minWait();
		driver.switchTo().defaultContent();
		if(verifyElementPresent(By.xpath("//button[@class='ui-button ui-corner-all ui-widget']")))
			click(By.xpath("//button[@class='ui-button ui-corner-all ui-widget']"));
		waitForFrameAndSwitch(FRAME);
		minWait();

		checkStatus(false, "Approved");

		return this;

	}
	
	
	/**
	 * @author A-8452 Faizan
	 * @return
	 */
	public TRK001 approveTheDetailsWithOutStatusCheck() {
		minWait();
		click(By.xpath("//button[@name='btApprove']"));
		minWait();
		driver.switchTo().defaultContent();
		if(verifyElementPresent(By.xpath("//button[contains(text(),'Yes')]"))) 
			//button[@class='btn primary ui-button ui-corner-all ui-widget']
			click(By.xpath("//button[contains(text(),'Yes')]"));
		waitForFrameAndSwitch(FRAME);
		minWait();minWait();
		driver.switchTo().defaultContent();
		if(verifyElementPresent(By.xpath("//button[@class='ui-button ui-corner-all ui-widget']")))
			click(By.xpath("//button[@class='ui-button ui-corner-all ui-widget']"));
		waitForFrameAndSwitch(FRAME);
		minWait();


		return this;

	}

	/**
	 * @author A-8452 Faizan
	 * @return
	 */
	public TRK001 saveTheDetails() {

		minWait();
		click(By.xpath("//button[@name='btSave']"));
		maxWait();
		driver.switchTo().defaultContent();
		captureAndAddScreenshot();

		if(verifyElementPresent(By.xpath("//button[contains(text(),'Yes')]"))){
			click(By.xpath("//button[contains(text(),'Yes')]"));
			minWait();
		}
		if(verifyElementPresent(By.xpath("//button[contains(text(),'OK')]")))
			click(By.xpath("//button[contains(text(),'OK')]"));


		minWait();
		waitForFrameAndSwitch(FRAME);
		minWait();
		String truckorderno=driver.findElement(By.xpath("//div/label[contains(text(),'Truck Order No.')]/following-sibling::div")).getText();
		InitialSetup.test.log(LogStatus.PASS,truckorderno);
		PropertyHandler.setPropValue(dataFilePath,"TruckOrderNo", truckorderno);
		minWait();
		//checkStatus(false, "To be Approved");
		return this;	
	}

	/**
	 * @author A-8452 Faizan
	 * Modified by A-8142 Nikhil
	 * @return
	 */
	public TRK001 printTLM()
	{	
		minWait();
		String truckorderno=driver.findElement(By.id("truckOrderNumber")).getAttribute("value");
		click(By.xpath("//button[@name='btPrint']"));
		maxWait();
		maxWait();
		maxWait();
		InitialSetup.test.log(LogStatus.PASS, "Truck order Succesfully generated with order No. "+truckorderno);
		maxWait();
		switchToSecondWindow();
		minWait();
		captureAndAddScreenshot();
		InitialSetup.test.log(LogStatus.INFO, "TLM printed successfully.");
		minWait();
		driver.close();
		switchToFirstWindow();
		maxWait();
		waitForFrameAndSwitch(FRAME);
		return this;
	}

	/**
	 * @author A-8452 Faizan
	 * @return
	 */
	public TRK001 reopenTruck() {

		minWait();
		click(By.xpath("//button[@name='Reopen']"));
		minWait();
		driver.switchTo().defaultContent();
		click(By.xpath("//button[@class='btn primary ui-button ui-corner-all ui-widget']"));
		waitForFrameAndSwitch(FRAME);
		minWait();
		checkStatus(false, "Reopened");

		return this;
	}

	/**
	 * @author A-8452 Faizan
	 * @param getStatus
	 * @param Status
	 * @return
	 */
	public TRK001 checkStatus(boolean getStatus, String Status) {
		maxWait();
		if (getStatus) {
			Status = PropertyHandler.getPropValue(dataFilePath, Status);
			String status = driver.findElement(By.xpath("//label[text()='Status']//following-sibling::div")).getText();
			if (!Status.trim().equalsIgnoreCase(status.trim())) {
				InitialSetup.test.log(LogStatus.FAIL, "Status of the truck doesn't match");
				Assert.fail();
			} else
				InitialSetup.test.log(LogStatus.PASS, "Status verified: " + status.trim());
		} else {
			InitialSetup.test.log(LogStatus.INFO, "Status check not required");
		}
		return this;
	}

/**
 * @author A-8452 Faizan
 * @param awbNo
 * @return
 */
	public TRK001 CheckAwbTillApprove(String awbNo) {

		awbNo=PropertyHandler.getPropValue(dataFilePath, awbNo);
		minWait();
		String pre="//td/a[contains(text(),'";
		String suff="')]";

		if(!verifyElementPresent(By.xpath(pre+awbNo+suff)))
		{
			InitialSetup.test.log(LogStatus.FAIL, "AWB Number is not listed in the screen");
			Assert.fail();
		}
		else{
			InitialSetup.test.log(LogStatus.PASS, "AWB is successfully listed");
			check(By.xpath("//input[@name='checkAll']"));
		}
		captureAndAddScreenshot();
		enterOutbounDetails();
		enterATDdetails();
		saveTheDetails();
		approveTheDetails();
		//finalizeTheDetails();
		/*	try {
			TruckCostEstimation(false,awbNo);
		} catch (InterruptedException e) {
			InitialSetup.test.log(LogStatus.INFO, "Truck cost estimation is not done");
		}*/
		maxWait();
		return this;
	}


/**
 * @author A-8452 Faizan
 * @param awbNo
 * @param errorText
 * @return
 */
	public TRK001 verifyErrorAfterApprove(String awbNo, String errorText) {

		awbNo=PropertyHandler.getPropValue(dataFilePath, awbNo);
		minWait();
		String pre="//td/a[contains(text(),'";
		String suff="')]";

		if(!verifyElementPresent(By.xpath(pre+awbNo+suff)))
		{
			InitialSetup.test.log(LogStatus.FAIL, "AWB Number is not listed in the screen");
			Assert.fail();
		}
		else{
			InitialSetup.test.log(LogStatus.PASS, "AWB is successfully listed");
			check(By.xpath("//input[@name='checkAll']"));
		}
		captureAndAddScreenshot();
		enterOutbounDetails();
		saveTheDetails();
//		approveTheDetailsWithOutStatusCheck();
		checkError(errorText);
		return this;
	}

	/**
	 * @author A-8452 Faizan
	 * @param errorText
	 * @return
	 */
	public TRK001 checkError(String errorText) {
		errorText=PropertyHandler.getPropValue(dataFilePath, errorText);
		minWait();
		if(verifyElementVisible(By.xpath("//div[@id='errorDisplayDiv']"))){
			String msg=driver.findElement(By.xpath("//div[@id='errorDisplayDiv']//tr//td[2]")).getText();
			if(msg.contains(errorText))
				InitialSetup.test.log(LogStatus.PASS, "Error Msg Displayed: "+msg);
			captureAndAddScreenshot();
			click(By.xpath("(//div[@id='errorDiv']/table//tr/td/img)[1]"));
		}
		else
		{
			InitialSetup.test.log(LogStatus.WARNING, "Error Msg is not displayed: ");
//			Assert.fail();
		}
		return this;
		}

	
	public TRK001 addChargeHead(String chargeHead) {
		chargeHead=PropertyHandler.getPropValue(dataFilePath, chargeHead);
		minWait();		
		click(By.xpath("//button[@name='btViewCalCharge']"));
		maxWait();
		driver.switchTo().defaultContent();
		captureAndAddScreenshot();

		if(verifyElementPresent(By.xpath("//button[contains(text(),'Yes')]"))){
			click(By.xpath("//button[contains(text(),'Yes')]"));
			minWait();
		}
		
		waitForFrameAndSwitch(FRAME);
		driver.switchTo().frame("popupContainerFrame");
		minWait();
		List <WebElement> elementName = driver.findElements(By.xpath("//input[@name='popUpChargeHeadCode']"));
		int size=elementName.size();
		click(By.xpath("//button[@name='btpopUpAdd']"));
		enterKeys(By.xpath("(//input[@name='popUpChargeHeadCode'])["+size+"]"), chargeHead+Keys.TAB);
		captureAndAddScreenshot();
		minWait();
		click(By.xpath("(//a[text()='Details'])[last()-1]"));
		maxWait();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(screenFrame);
		driver.switchTo().frame("popupContainerFrame");
		enterKeys(By.name("popUpParamValue"), "2");
		enterKeys(By.name("popUpAmount"), "10");
		click(By.name("btParampopUpSave"));
		driver.switchTo().defaultContent();
		driver.switchTo().frame(screenFrame);
		minWait();
		driver.switchTo().frame("popupContainerFrame");
		click(By.name("retainCharges"));
		click(By.name("btpopUpCalculate"));
		maxWait();
		scrollToView(By.xpath("//button[@name='btpopUpSave']"));
		click(By.xpath("//button[@name='btpopUpSave']"));
		minWait();
		driver.switchTo().frame(screenFrame);
		return this;
	}

	public TRK001 verifyChargeHead(String chargeHead) {
		chargeHead=PropertyHandler.getPropValue(dataFilePath, chargeHead);
		boolean chargeHeadPresent=false;
		minWait();		
		click(By.xpath("//button[@name='btViewCalCharge']"));
		maxWait();
		driver.switchTo().defaultContent();
		captureAndAddScreenshot();

		if(verifyElementPresent(By.xpath("//button[contains(text(),'Yes')]"))){
			click(By.xpath("//button[contains(text(),'Yes')]"));
			minWait();
		}
		
		waitForFrameAndSwitch(FRAME);
		driver.switchTo().frame("popupContainerFrame");
		minWait();
		List <WebElement> elementName = driver.findElements(By.xpath("//input[@name='popUpChargeHeadCode']"));
		//int size=elementName.size();
		for(WebElement e : elementName) {
			String text=e.getAttribute("value");
			  if(text.equalsIgnoreCase(chargeHead))
			  {
				  chargeHeadPresent=true;
			  }
			  break;
			}
		if(chargeHeadPresent==true)
		{
			InitialSetup.test.log(LogStatus.PASS, "Added Charge head is successfully verified");
		}
		else{
			InitialSetup.test.log(LogStatus.FAIL, "Added Charge head is could not be found");
			Assert.fail();
		}
		click(By.xpath("//button[@name='btpopUpSave']"));
		minWait();
		driver.switchTo().frame(screenFrame);
		return this;
	}
	
	//A-8142 Nikhil
	
	public TRK001 addShipment(String prefix, String toBeAddedAwbNo)
	{
		prefix=PropertyHandler.getPropValue(dataFilePath, prefix);
		toBeAddedAwbNo=PropertyHandler.getPropValue(dataFilePath, toBeAddedAwbNo);
		maxWait();
		
		click(By.id("btAdd"));
		enterKeys(By.name("shipmentPrefix"), prefix);
		enterKeys(By.name("documentNumber"), toBeAddedAwbNo);
		maxWait();
		captureAndAddScreenshot();
		InitialSetup.test.log(LogStatus.INFO, "Added shipments manually into truck order.");
		return this;
	}
	
}