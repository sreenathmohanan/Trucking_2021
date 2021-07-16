package com.ibsplc.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ibsplc.common.BasePage;
import com.ibsplc.utils.MiscUtility;
import com.ibsplc.utils.PropertyHandler;

/**
 * OPR017 : Generate NOTOC
 * @author a-7868 Krishna
 * <19-03-2017>
 *
 */
public class OPR017 extends BasePage{

	private static String objFilepath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "OPR_FLT.properties");
    private static String genObjPath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "Generic.properties");
    private static String FRAME = "iCargoContentFrameOPR017";
    private String dataFilePath = PropertyHandler.getPropValue("resources\\EnvSetup.properties", "testDataDirectory");
    private WebDriver driver;
    private String dataFileName;
        
    private By 	txt_carrierCode,
    			txt_fltNo,
    			txt_fltDt,
    			btn_list,
    			btn_clear,
    			btn_close,
    			btn_generateNOTOC,
    			btn_sendNTM,
    			chkbox_final,
    			tbl_otherSplLoads,
    			yesBtn,
    			info_footLayer,
    			tbl_dgrDtls,
    			link_expandAllRows,
    			btn_autoAssign;
    
    public OPR017(WebDriver driver, String dataFileName) {
        super(driver);
        this.driver = driver;
        this.dataFilePath = dataFilePath + dataFileName;
        this.dataFileName = dataFileName;
        initElements();
    }
    /**
     * MEthod to initialize page elements
     */
    private void initElements() {

    	txt_carrierCode = MiscUtility.getWebElement(objFilepath, "OPR017_txt_carrierCode");
    	txt_fltNo = MiscUtility.getWebElement(objFilepath, "OPR017_txt_fltNo");
    	txt_fltDt = MiscUtility.getWebElement(objFilepath, "OPR017_txt_fltDt");
    	btn_list = MiscUtility.getWebElement(objFilepath, "OPR017_btn_list");
    	btn_clear = MiscUtility.getWebElement(objFilepath, "OPR017_btn_clear");
    	btn_close = MiscUtility.getWebElement(objFilepath, "OPR017_btn_close");
    	btn_generateNOTOC = MiscUtility.getWebElement(objFilepath, "OPR017_btn_generateNOTOC");
    	btn_sendNTM = MiscUtility.getWebElement(objFilepath, "OPR017_btn_sendNTM");
    	chkbox_final = MiscUtility.getWebElement(objFilepath, "OPR017_chkbox_final");
    	tbl_otherSplLoads = MiscUtility.getWebElement(objFilepath, "OPR017_tbl_otherSplLoads");
        tbl_dgrDtls= MiscUtility.getWebElement(objFilepath, "OPR017_tbl_dgrDtls");
        link_expandAllRows=MiscUtility.getWebElement(objFilepath, "OPR017_link_expandAllRows");
        btn_autoAssign = MiscUtility.getWebElement(objFilepath, "OPR017_btn_autoAssign");
        yesBtn = MiscUtility.getWebElement(genObjPath, "Generic_btn_diaYes");
        info_footLayer = MiscUtility.getWebElement(genObjPath, "Generic_foot_layer");
    }
    
    /**
     * Method to lis a flight, check for the AWBm
     * check Final and click Generate NOTOC button
     * @param carrCode
     * @param fltNo
     * @param fltDt
     * @param awbNo
     * @return
     * @author a-7868 Krishna <19/03/2018>
     */
    public OPR017 generateNOTOC(String carrCode, String fltNo, String fltDt, String awbPre, String awbNo){
    	
    	carrCode = PropertyHandler.getPropValue(dataFilePath, carrCode);
    	fltNo = PropertyHandler.getPropValue(dataFilePath, fltNo);
    	fltDt = PropertyHandler.getPropValue(dataFilePath, fltDt);
    	awbPre = PropertyHandler.getPropValue(dataFilePath, awbPre);
    	awbNo = PropertyHandler.getPropValue(dataFilePath, awbNo);
    	
    	enterKeys(txt_carrierCode, carrCode);
    	enterKeys(txt_fltNo, fltNo);
    	enterKeys(txt_fltDt, fltDt);
    	click(btn_list);
    	minWait();
    	
    	Assert.assertTrue(getTableColumnValues(tbl_otherSplLoads, 1).contains(awbPre+"-"+awbNo),"ERROR : AWB not listed");
    	
    	check(chkbox_final);
    	click(btn_generateNOTOC);
    	driver.switchTo().defaultContent();
    	if(verifyElementPresent(yesBtn))
    		click(yesBtn);
    	//Assert.assertTrue(waitForElement(info_footLayer).getText().contains("successfully"), "ERROR : NOTOC not generated.");
    	waitForFrameAndSwitch(FRAME);
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	closeAndmoveToFirstWindow();
    	waitForFrameAndSwitch(FRAME);
    	return this;
    }
    
    /**
     * Method to check for the AWBm
     * check Final and click Generate NOTOC button
     * @param carrCode
     * @param fltNo
     * @param fltDt
     * @param awbNo
     * @return
     * @author a-7868 Krishna <19/03/2018>
     */
    public OPR017 assignUNIDandGenerateNOTOCFromOPR016(String carrCode, String fltNo, String fltDt, String awbPre, String awbNo){
    	
    	
    	click(link_expandAllRows);
    	tblSelectRowByColValue(tbl_dgrDtls, 1, 6, awbPre+" "+awbNo);
    	click(btn_autoAssign);
    	minWait();
    	check(chkbox_final);
    	click(btn_generateNOTOC);
    	driver.switchTo().defaultContent();
    	if(verifyElementPresent(yesBtn))
    		click(yesBtn);
    	//Assert.assertTrue(waitForElement(info_footLayer).getText().contains("successfully"), "ERROR : NOTOC not generated.");
    	waitForFrameAndSwitch("iCargoContentFrameOPR016");
    	waitForNewWindow(2);
    	switchToSecondWindow();
    	closeAndmoveToFirstWindow();
    	waitForFrameAndSwitch("iCargoContentFrameOPR016");
    	return this;
    }
    
    /**
     * closes the screen and goes back to home page
     *
     * @return
     * @author A-7868 Krishna <19/03/2018>
     */
    public HomePage close() {

        click(btn_close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        return new HomePage(driver, dataFileName);
    }
    
    /**
     * closes the screen and goes back to home page
     *
     * @return
     * @author A-7868 Krishna <19/03/2018>
     */
    public OPR016 closeToOPR016() {

        click(btn_close);
        driver.switchTo().defaultContent();
        if (verifyElementPresent(yesBtn)) {

            click(yesBtn);
        }
        return new OPR016(driver, dataFileName);
    }
    
}
