package test;

import java.awt.AWTException;
import java.awt.Robot;
import java.net.MalformedURLException;

import org.apache.xerces.impl.xs.models.CMBuilder;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.android.ddmlib.AdbCommandRejectedException;

import properties.LoadAppConfig;
import utilities.CMSWebElementFactory;
import utilities.DynamicWait;
import wrapper.UserActions;

public class CMS extends CMSBase {
	LoadAppConfig appConfig = new LoadAppConfig();
	UserActions userActions = new UserActions(driver);
	CMSWebElementFactory cmsFactory=new CMSWebElementFactory(driver);
	@Test(description="verify spotlightpod on operation services,after removing the spotlight attributes from CMS",groups="CMS")
	public void testOperationServicesSpotLightPod()
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		cmsUserActions.get().switchToFrame("LeftNavFrame");
		cmsUserActions.get().clickOn("LeftNav_Default");
		cmsUserActions.get().clickOn("LeftNav_Default_Home");
		cmsUserActions.get().clickOn("LeftNav_Default_Home_Services");
		cmsUserActions.get().doubleClickOn("LeftNav_OperationServices_Link");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().clickOn("Category_OperationServices");
		cmsBusinessFunction.get().closePreviousTab();
		cmsUserActions.get().clickOnElementUsingImage("EditCMS.JPG");
		cmsUserActions.get().clearText("OperationServicesSpotlightTitle");
		cmsUserActions.get().clickOn("OperationServicesSpotlightTextCKEditor");
		cmsUserActions.get().switchToFrame("OperationServicesSpotlightTextIframe");
		cmsUserActions.get().clearText("OperationServicesSpotlightText");
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");
		cmsVerify.get().verifyAssetSaved();
		cmsFactory.dynamicWait("OperationServicesSpotlightTitle",20);
		getDriver().get("http://wwwcms-staging.avaya.com/cs/avaya/usa/services/portfolios/operations-services");
		cmsDynamicWait.get().waittillpageloads();
		cmsVerify.get().isElementNotPresent("SpotlightPod");
	}
	@Test(description="verify the max count of accordian boxes on registration page",groups="CMS")
	public void testRegistrationPageAccordianBoxes()
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsBusinessFunction.get().searchAsset("premium");
		cmsUserActions.get().doubleClickOn("PremiumFormA");
		cmsBusinessFunction.get().closePreviousTab();
		cmsBusinessFunction.get().accordianBox("AccordianAssets");
		cmsFactory.dynamicWait("AccordianAssets", 20);
		getDriver().get("https://wwwcms-staging.avaya.com/cs/avaya/usa/registration/premium-form");
		cmsDynamicWait.get().waittillpageloads();
		cmsBusinessFunction.get().accordianBoxesCount("AccordianBoxes");
	}
	//Test case on hold
	@Test(description="",groups="CMS")
	public void testCreationOfBenefitsForCustomers()
	{
		getDriver().get("http://wwwcms-staging.avaya.com/cs/login");
		//getDriver().get("http://tlowsap1.us1.avaya.com:9001/cs/login");
		cmsBusinessFunction.get().cmsLogin("username","password");
		cmsUserActions.get().switchToFrame("LeftNavFrame");
		cmsUserActions.get().clickOn("LeftNav_Default");
		cmsUserActions.get().clickOn("LeftNav_Default_Home");
		cmsUserActions.get().doubleClickOn("LeftNav_Default_Home_Partners_Link");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().clickOn("Partners");
		cmsBusinessFunction.get().closePreviousTab();
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().clickOn("Partners_CustomerBenefits_Link");
		cmsBusinessFunction.get().closePreviousTab();
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().doubleClickOn("Edit");
		cmsUserActions.get().switchToFrame("Body_Frame");
	}
	@Test(description="Update and save About avaya-company overview asset ",groups="CMS")
	public void testUpdateCompanyoverviewAsset()
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		cmsUserActions.get().switchToFrame("LeftNavFrame");
		cmsUserActions.get().clickOn("LeftNav_Default");
		cmsUserActions.get().clickOn("LeftNav_Default_Home");
		cmsUserActions.get().clickOn("LeftNav_Default_Home_About");
		cmsUserActions.get().doubleClickOn("LeftNav_Default_Home_About_CompanyOverview");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().clickOn("Category:CompanyOverview");
		cmsBusinessFunction.get().closePreviousTab();
		cmsUserActions.get().clickOnElementUsingImage("EditCMS.JPG");
		cmsUserActions.get().clearText("Name");
		cmsUserActions.get().enterText("Name", "CompanyOverview");
		cmsUserActions.get().clearText("CompanyOverview_MetaPageTitle");
		cmsUserActions.get().enterText("CompanyOverview_MetaPageTitle", "CompanyOverview");
		cmsUserActions.get().clickOn("TemplateDropdown");
		cmsUserActions.get().clickOn("AboutAvayaCategoryDisplayTemplate");
		cmsUserActions.get().clearText("CompanyOverview_Url");
		cmsUserActions.get().enterText("CompanyOverview_Url", "CompanyOverviewWebUrl");
		cmsBusinessFunction.get().ckEditor("CompanyOverview_CategoryDescription", "CompanyOverviewCategoryDescription_CkEditorText", "CompanyOverview_CategoryDescriptionIframe");
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");
		cmsVerify.get().verifyAssetSaved();
		//cmsVerify.get().verifyText("AssetTitle", "CompanyOverview");
	}
	@Test(description="Creation of new image asset in investors",groups="CMS")
	public void testInvestorsContentNewImage() 
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getInvestorsUserName(),appConfig.getInvestorsPassword());
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().hoverOn("Content");
		cmsUserActions.get().clickOn("New");
		cmsUserActions.get().clickOn("NewImage");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().enterText("Name", "InvestorsNewImage");
		cmsUserActions.get().enterText("ImageTitle","InvestorsNewImage");
		cmsUserActions.get().clickOn("ImageBrowseButton");
		cmsBusinessFunction.get().fileUpload("tulips.jpg",'d');
		cmsDynamicWait.get().waitUntillProgressCompletes("progressBar");
		cmsUserActions.get().clickOn("ThumbnailImageBrowseButton");
		cmsBusinessFunction.get().fileUpload("tulips.jpg",'d'); 
		cmsDynamicWait.get().waitUntillProgressCompletes("progressBar");
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");
		cmsVerify.get().verifyAssetSaved();
	}
	@Test(description="Save the benefits asset",groups="CMS")
	public void testSaveBenefitsAsset()
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().hoverOn("Content");
		cmsUserActions.get().clickOn("New");
		cmsUserActions.get().clickOn("NewMasterData");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().enterText("Name", "Benefits");
		cmsUserActions.get().clickOn("AvayaMasterParentDefinition_Arrow");
		cmsUserActions.get().clickOn("RASBenefits");
		cmsUserActions.get().clickOn("TemplateDropdown");
		cmsUserActions.get().clickOn("BenefitsTemplate");
		cmsUserActions.get().enterText("Title","Benefits");
		cmsUserActions.get().enterText("MetaPageTitle","Benefits");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().clickOn("SearchWithDownArrow");
		cmsUserActions.get().clickOn("FindAvayaMasterData");
		cmsUserActions.get().clickOnElementUsingImage("Magnifier.JPG");
		cmsBusinessFunction.get().advanceSearch("AdvancedSearchAssetType_AvayaMasterData", "AdvancedSearchSubType_RASBenefits", "RepresentedBenefits");
		cmsBusinessFunction.get().dragAndDrop("AttributeToRelateBenefitspageSource", "AttributeToRelateBenefitspageDropZone",50);
		
		cmsUserActions.get().enterText("BenefitsTitle","Benefits");
		cmsUserActions.get().enterText("BenefitsDetailsTitle","Benefits");
		
		//Drag and drop RAS Url into Benefit Details Related PDFs
		//cmsUserActions.get().switchToFrame("Body_Frame");
		//Benefits description ckEditor
		cmsBusinessFunction.get().ckEditor("BenefitsDescription", "BenefitsCkEditorText", "BenefitsDescriptionIframe");
		//Benefits description 2 ckEditor
		cmsBusinessFunction.get().ckEditor("BenefitsDescription2", "BenefitsCkEditorText", "BenefitsDescription2Iframe");
		//Benefits details description ckEditor
		cmsBusinessFunction.get().ckEditor("BenefitsDetailsDescription", "BenefitsCkEditorText", "BenefitsDetailsDescriptionIframe");
		//Benefits bottom description ckEditor
		cmsBusinessFunction.get().ckEditor("BenefitsBottomDescription", "BenefitsCkEditorText", "BenefitsBottomDescriptionIframe");
		cmsBusinessFunction.get().advanceSearch("AdvancedSearchAssetType_AvayaContent", "AdvancedSearchAssetSubType_RASUrl", "Try it now url");
		cmsBusinessFunction.get().dragAndDrop("ArticleUrlSource", "BenefitDetailsRelatedPDFsDropZone",50);
		
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");
		cmsVerify.get().verifyAssetSaved();
	}
	

	/**
	  Author Name                       : Phanendra
	  Date of Preparation               : 25-08-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify the product category results populated are related to en_US locale
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	  **/
	@Test
	public void testAdvancedSearchProductCategoryEnUs()
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().clickOn("SearchWithDownArrow");
		cmsUserActions.get().clickOn("AdvancedSearchFiltersProductCategory");
		cmsUserActions.get().clickOnElementUsingImage("Magnifier.JPG");
		cmsBusinessFunction.get().verifyElementContainsText("AdvancedSearchProductCategory_EnUsLocale",",");
	}


	/**
	  Author Name                       : Phanendra
	  Date of Preparation               : 21-08-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 :  Verify the article results populated are related to de_DE locale
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	  **/
@Test(description="verify advanced search by locale",groups="CMS")
	public void testAdvancedSearchArticlesDeDeLocale()
	{
	    getDriver().get(appConfig.getCmsStagingUrl());
	    cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().clickOn("SearchWithDownArrow");
		cmsUserActions.get().clickOn("AdvancedSearch");
		cmsUserActions.get().clickOn("AdvancedSearchAssetType");
		cmsUserActions.get().clickOn("AdvancedSearchAssetType_AvayaArticle");
		cmsUserActions.get().clickOn("AdvancedSearch_LocaleArrow");
		cmsUserActions.get().clickOn("AdvancedSearch_deDE");
		cmsUserActions.get().clickOn("RunAdvancedSearch_Button");
		cmsBusinessFunction.get().verifyElementContainsText("AdvancedSearchProductCategory_deDELocale",",");
	}


	  /**
	  Author Name                       : Phanendra
	  Date of Preparation               : 23-08-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify the creation of new image in investors
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	  **/
	@Test(description="Creation of new image asset in investors",groups="CMS")
	public void testCreationOfInvestorsImageAsset() 
	{
		
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getInvestorsUserName(),appConfig.getInvestorsPassword());
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().hoverOn("Content");
		cmsUserActions.get().clickOn("New");
		cmsUserActions.get().clickOn("NewImage");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().enterText("Name", "InvestorsNewImage");
		cmsUserActions.get().enterText("ImageTitle","InvestorsNewImage");
		cmsUserActions.get().clickOn("ImageBrowseButton");
		cmsBusinessFunction.get().fileUpload("tulips.jpg",'d');
		cmsDynamicWait.get().waitUntillProgressCompletes("progressBar");
		cmsUserActions.get().clickOn("ThumbnailImageBrowseButton");
		cmsBusinessFunction.get().fileUpload("tulips.jpg",'d'); 
		cmsDynamicWait.get().waitUntillProgressCompletes("progressBar");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");
		cmsVerify.get().verifyAssetSaved();
	}
	
	/**
	  Author Name                       : Phanendra 
	  Date of Preparation               : 14-08-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify if the user is able to login to CMS application successfully.
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	 * @throws AWTException 
	  **/
	
	@Test(description="Verify if the user is able to login to CMS application successfully.",groups="CMS")
	public void testPartnersCmsLogin()
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().clickOn("CMSLogout");
	}
	
   /**
	  Author Name                       : Phanendra
	  Date of Preparation               : 21-08-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify the support services attributes
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
 * @throws InterruptedException 
	  **/
	@Test(description="verify the attributes in support services asset",groups="CMS")
	public void testSupportServicesAttributes()
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		cmsUserActions.get().switchToFrame("LeftNavFrame");
		cmsUserActions.get().clickOn("LeftNav_Default");
		cmsUserActions.get().clickOn("LeftNav_Default_Home");
		cmsUserActions.get().clickOn("LeftNav_Default_Home_Services");
		cmsUserActions.get().doubleClickOn("LeftNav_Default_Home_Services_SupportServices");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");		
		cmsUserActions.get().clickOn("SupportServices");
		cmsBusinessFunction.get().closePreviousTab();
		cmsBusinessFunction.get().verifyElementContainsText("SupportServicesAttributes", ",");
		
	}
	 /**
	  Author Name                       : Phanendra
	  Date of Preparation               : 21-08-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify the advanced search by locale filter
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
   * @throws InterruptedException 
	  **/
 @Test(description="verify advanced search by locale",groups="CMS")
	public void testAdvancedSearchLocale()
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().clickOn("SearchWithDownArrow");
		cmsUserActions.get().clickOn("AdvancedSearch");
		cmsUserActions.get().clickOn("AdvancedSearch_WordsArrow");
		//cmsUserActions.get().clickOn("AnyOfTheseWords_Option");
		//cmsUserActions.get().enterText("AdvancedSearchAssetName", "AssetImageName");
		cmsUserActions.get().clickOn("AdvancedSearch_LocaleArrow");
		cmsUserActions.get().clickOn("AdvancedSearch_jaJP");
		cmsUserActions.get().clickOn("RunAdvancedSearch_Button");
		cmsBusinessFunction.get().verifyElementContainsText("AdvancedSearchResultsLocale",",");
	}
	/**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 14-08-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify the the publishing flow in the CMS application.
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	 * @throws AWTException 
	  **/
	
   @Test(description="Verify the the publishing flow in the CMS application.",groups="CMS")
	public void testDeleteArticle() throws InterruptedException
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		cmsUserActions.get().switchToFrame("Main_Frame");
		
		cmsUserActions.get().hoverOn("Content");
		cmsUserActions.get().clickOn("New");
		cmsUserActions.get().clickOn("NewAvayaArticles");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsBusinessFunction.get().verifyElementContainsText("NewArticles_Attributes", ",");
		cmsBusinessFunction.get().verifyElementContainsText("NewArticles_Attributes", ",");	
		cmsUserActions.get().clickOn("AvayaArticlesParentDefinition_Arrow");
		cmsUserActions.get().clickOn("RASTechnicalDocuments");
		cmsBusinessFunction.get().verifyElementContainsText("TechnicalDocument_Attributes", ",");
		cmsUserActions.get().enterText("TechnicalDocument_Name", "TechnicalDocumentFieldName");
		cmsUserActions.get().clickOn("TechnicalDocumentTemplate_Arrow");
		cmsUserActions.get().clickOn("TechnicalDocument_SelectTemplate");
		cmsUserActions.get().enterText("TechnicalDocument_TechnicalSpecificationTitle", "TechnicalDocumentFieldName");
		cmsUserActions.get().clickOn("TechnicalDocumentSpecification_Arrow");
		cmsUserActions.get().clickOn("TechnicalDocument_SelectSpecification");
		cmsBusinessFunction.get().ckEditor("Technical_Specifications", "Technical_SpecificationsDescription","Services_CKEditorFrame");
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().clickOn("MetadataTab");
		cmsUserActions.get().clickOn("DropDown");
		cmsUserActions.get().clickOn("DropDown_en_US");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");
		cmsVerify.get().verifyAssetSaved();		
		cmsUserActions.get().clickOnElementUsingImage("DeleteButton.JPG");
		Thread.sleep(5000);
		cmsUserActions.get().clickOnElementUsingImage("DeleteButtonTab.JPG");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().clickOn("CMSLogout");
	}
	
	
	
	/**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 14-08-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify the advanced search functionality in the CMS application
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	 * @throws AdbCommandRejectedException 
	 * @throws AWTException 
	  **/
	
	@Test(description="Verify the advanced search functionality in the CMS application")
	public void testCmsAdvancedSearch() throws InterruptedException, AdbCommandRejectedException
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().clickOn("SearchWithDownArrow");
		cmsFactory.dynamicWait("SearchPopup", 15);
		cmsUserActions.get().clickOnElementUsingImage("AdvancedSearch.JPG");
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cmsFactory.dynamicWait("AdvancedSearchAssetName", 15);
		cmsBusinessFunction.get().verifyElementContainsText("AdvancedSearchAttributes", ",");
		cmsVerify.get().isElementDisplayed("RunAdvancedSearch_Button");
		cmsVerify.get().isElementDisplayed("AdvancedSearch_ResetButton");
		cmsVerify.get().isTextPresent("AdvancedSearch_SubHeader","AdvancedSearch_SubHeader");
		cmsVerify.get().isTextPresent("AdvancedSearch_MainHeader","AdvancedSearch_MainHeader");
		cmsVerify.get().isElementDisplayed("AdvancedSearch_TextBox");
		cmsVerify.get().isElementDisplayed("AdvancedSearch_DropDownList");
		cmsUserActions.get().clickOn("AdvancedSearch_WordsArrow");
		cmsUserActions.get().clickOn("AnyOfTheseWords_Option");
		cmsUserActions.get().enterText("AdvancedSearchAssetName", "AssetImageName");
		cmsUserActions.get().clickOn("AdvancedSearch_LocaleArrow");
		cmsUserActions.get().clickOn("AdvancedSearch_enUS");
		cmsUserActions.get().clickOn("AdvancedSearch_AuthorArrow");
		cmsUserActions.get().clickOn("AdvancedSearch_Authorfwadmin");
		cmsUserActions.get().clickOn("RunAdvancedSearch_Button");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().clickOn("CMSLogout");
	}
	
	/**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 20-08-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify the presence of attributes on Newsroom landing page
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	  **/
	
	@Test(description="Verify the presence of attributes on Newsroom landing page",groups="CMS")
	public void testNewsRoomCMS() throws InterruptedException
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		//cmsUserActions.get().clickOnElementUsingImage("Contributor.JPG");
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsBusinessFunction.get().closeOpenTabs();
		cmsUserActions.get().hoverOn("Content");
		cmsUserActions.get().clickOn("New");
		cmsUserActions.get().clickOn("NewAvayaContent");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsBusinessFunction.get().verifyElementContainsText("AvayaContent_Attributes", ",");
		cmsVerify.get().isElementDisplayed("NewAvayaContent_ContinueButton");
		cmsUserActions.get().clickOn("AvayaContentParentDefinition_Arrow");
		cmsUserActions.get().clickOn("RASNewsRoom");
		cmsBusinessFunction.get().verifyElementContainsText("RASNewsRoom_Attributes", ",");
		
	}
	
	/**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 20-08-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify the changes made to MediaKits page
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	 * @throws AWTException 
	  **/
	
	@Test(description="Verify the changes made to MediaKits page",groups="CMS")
	public void testNewsRoomCmsMediaKitsSave() 
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().hoverOn("Content");
		cmsUserActions.get().clickOn("New");
		cmsUserActions.get().clickOn("NewMasterData");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().clickOn("AvayaCountryLocaleMapParentDefinition_Arrow");
		cmsUserActions.get().clickOn("RASSearch");
		cmsUserActions.get().enterText("Name", "RASSearch_Name");
		cmsUserActions.get().clickOn("RASSearch_TemplateArrow");
		cmsUserActions.get().clickOn("RASSearch_TemplateMediakits");
		cmsUserActions.get().enterText("Name", "RASSearch_Name");
		cmsUserActions.get().enterText("Title", "RASSearch_Name");
		cmsUserActions.get().enterText("RASSearch_Title", "RASSearch_Name");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsBusinessFunction.get().advanceSearch("AdvancedSearchAssetType_AvayaContent","AdvancedSearchAssetSubType_RASUrl", "qa_auto_test_Try It Now Url");
		cmsBusinessFunction.get().dragAndDrop("RASCountries_URLSource","RASSearch_Contacts",50);
		cmsUserActions.get().clickOn("MetadataTab");
		cmsUserActions.get().clickOn("DropDown");
		cmsUserActions.get().clickOn("DropDown_en_US");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().hoverOn("Content");
		cmsUserActions.get().clickOn("SaveUnderContent");
		cmsVerify.get().verifyAssetSaved();
		//cmsVerify.get().verifyText("AssetHeader", "RASSearch_Name");
	}
	
	/**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 23/8/2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify the creation of Image asset
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws AWTException 
	  **/
	
	@Test(description="Verify the creation of Image asset",groups="CMS")
	public void testCreationOfImageAsset() throws InterruptedException, AWTException
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAdminUsername(),appConfig.getAdminPassword());
		cmsUserActions.get().clickOnElementUsingImage("Contributor.JPG");	
		Thread.sleep(5000);
		cmsUserActions.get().switchToFrame("Main_Frame");
		Thread.sleep(5000);
		cmsUserActions.get().hoverOn("Content");
		cmsUserActions.get().clickOn("New");
		cmsUserActions.get().clickOn("NewImage");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsBusinessFunction.get().verifyElementContainsText("ArticleImage_Attributes",",");
		cmsUserActions.get().enterText("Name", "AssetImageName");
		cmsUserActions.get().enterText("ImageTitle", "AssetImageName");
		cmsUserActions.get().enterText("AlternateText", "AssetAlternateName");
		cmsUserActions.get().clickOn("ImageBrowseButton");
		cmsBusinessFunction.get().fileUpload("tulips.jpg",'d');
		Thread.sleep(5000);
		cmsUserActions.get().clickOn("ThumbnailImageBrowseButton");
		cmsBusinessFunction.get().fileUpload("tulips.jpg",'d'); 
		Thread.sleep(10000);
		cmsUserActions.get().enterText("ImageCaption", "NetworksImage");
		cmsUserActions.get().clickOn("MetadataTab");
		cmsUserActions.get().clickOn("DropDown");
		cmsUserActions.get().clickOn("DropDown_en_US");
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");
		cmsVerify.get().verifyAssetSaved();
		cmsUserActions.get().clickOnElementUsingImage("ApproveCMS.JPG");
		Thread.sleep(5000);
		cmsUserActions.get().clickOn("stagingDelivery");
		cmsUserActions.get().clickOn("ApproveWithDependenciesButton");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().clickOn("CMSLogout");
		//cmsBusinessFunction.get().Publish("qa_auto_test_Networks Image");
	}
	
	
	/**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 21/8/2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : 
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	 * @throws AWTException 
	  **/
	
	@Test(description="Verify if the user is able to create a Home page in CMS")
	public void testInvestorsHomePageCMS() throws InterruptedException
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getInvestorsUserName(),appConfig.getInvestorsPassword());		
		cmsUserActions.get().switchToFrame("LeftNavFrame");
		cmsUserActions.get().clickOn("LeftNav_Default");
		cmsUserActions.get().clickOn("LeftNav_Investors");
		Thread.sleep(5000);
		cmsUserActions.get().doubleClickOn("LeftNav_Investors_Link");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");	
		cmsUserActions.get().clickOnElementUsingImage("EditCMS.JPG");		
		cmsVerify.get().verifyEnabledElement("Investors_HomePage_Attributes");
	}
	
	/**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 21/8/2014
	  Date of Modified                  : --
	  Methods Called                    : cmsLogin(String UserName, String Password),
	  									  searchAsset(String AssetName),isElementNotPresent(String controlName)
	  Purpose of Method                 : CMS_Admin_Verify the search functionality
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	 * @throws AWTException 
	  **/
	
	@Test(description="CMS_Admin_Verify the search functionality",groups="CMS")
	public void testCmsAdminSearchFunctionality()
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		cmsBusinessFunction.get().searchAsset("Products");
		cmsVerify.get().isElementNotPresent("NoResultsFound");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().clickOn("CMSLogout");
	}
	
	/**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 22-08-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify if the user is able to create  CorporateGovernance Content under Articles in CMS
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	 * @throws AWTException 
	  **/
	
	@Test(description="Verify if the user is able to create  CorporateGovernance Content under Articles in CMS",groups="CMS")
	public void testCreateArticlesCorporateGovernance() throws InterruptedException, AWTException
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getInvestorsUserName(),appConfig.getInvestorsPassword());
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().hoverOn("Content");
		cmsUserActions.get().clickOn("New");
		cmsUserActions.get().clickOn("NewAvayaArticles");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().enterText("Investors_NewArticles_NameField", "ArticleName_CorporateGovernance");
		cmsUserActions.get().clickOn("AvayaArticlesParentDefinition_Arrow");
		cmsUserActions.get().clickOn("CorporateGovernance");
		cmsUserActions.get().enterText("CorporateGovernance_TitleField", "ArticleName_CorporateGovernance");
		cmsBusinessFunction.get().ckEditor("CorporateGovernance_TextBody", "CorporateGovernance_Text","CorporateGovernance_TextBody_Frame");
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");
		cmsVerify.get().verifyAssetSaved();
	}
	

	/**
	  Author Name                       : Niharika K R
	  Date of Preparation               : 22-08-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify if the user is able to update Professional Services
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	 * @throws AWTException 
	  **/
	
	@Test(description="Verify if the user is able to update Professional Services")
	public void testUpdatingProfessionalServicesCMS() 
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		cmsUserActions.get().switchToFrame("LeftNavFrame");
		cmsUserActions.get().clickOn("LeftNav_Default");
		cmsUserActions.get().clickOn("LeftNav_Default_Home");
		cmsUserActions.get().clickOn("LeftNav_Default_Home_Services");
		cmsUserActions.get().doubleClickOn("LeftNav_ProfessionalServices_Link");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().clickOn("Category_ProfessionalServices");
		cmsBusinessFunction.get().closePreviousTab();
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().clickOnElementUsingImage("EditCMS.JPG");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().enterText("Services_IntroTextBox", "ProfessionalServices_Text");
		cmsBusinessFunction.get().ckEditor("Services_CategoryDescription", "ProfessionalServices_Text","Services_CategoryDescriptionFrame");
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().clearText("Services_MetaPageTitleField");
		cmsUserActions.get().enterText("Services_MetaPageTitleField", "ProfessionalServices_MetaPageTitle");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().hoverOn("Content");
		cmsUserActions.get().clickOn("SaveUnderContent");
		cmsVerify.get().verifyAssetSaved();
		//cmsVerify.get().verifyText("AssetHeader","ProfessionalServices");
	 
	}
	
	
	/**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 25-08-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify if the user is able to create Leadership page in CMS
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	 * @throws AWTException 
	  **/
	
	@Test(description="Verify if the user is able to create Leadership page in CMS",groups="CMS")
	public void testInvestorsCorporateGovernanceLeadership() throws InterruptedException, AWTException
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getInvestorsUserName(),appConfig.getInvestorsPassword());
		cmsUserActions.get().clickOnElementUsingImage("Contributor.JPG");
		cmsUserActions.get().switchToFrame("LeftNavFrame");
		cmsUserActions.get().clickOn("LeftNav_Inv_Default");
		cmsUserActions.get().clickOn("LeftNav_Investors");
		cmsBusinessFunction.get().verifyElementContainsText("Investors_Attributes", ",");
		cmsUserActions.get().clickOn("LeftNav_Investors_CorporateGovernance");
		cmsBusinessFunction.get().verifyElementContainsText("CorporateGovernance_Attributes", "@");
		cmsUserActions.get().doubleClickOn("LeftNav_Leadership");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsBusinessFunction.get().verifyElementContainsText("Leadership_Attributes", ",");
		cmsUserActions.get().clickOnElementUsingImage("EditCMS.JPG");
		cmsUserActions.get().clearText("Leadership_NameField");
		cmsUserActions.get().enterText("Leadership_NameField", "Leadership_Name");
		cmsUserActions.get().clickOn("Leadership_TemplateArrow");
		cmsUserActions.get().clickOn("Leadership_Template");
		cmsBusinessFunction.get().ckEditor("Leadership_TextBody", "Leadership_TextBody_Text", "Leadership_TextBodyFrame");
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().clickOn("Leadership_ExternalLink_CrossButton");
		cmsBusinessFunction.get().searchAsset("Leadership");
		cmsBusinessFunction.get().dragAndDrop("Leadership_DocumentSource","Leadership_DocumentDestination",100);
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");	
	}
	
	/**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 25-08-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify if the user is able to create Contact Board of Directors page in CMS
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	 * @throws AWTException 
	  **/
	
	@Test(description="Verify if the user is able to create Contact Board of Directors page in CMS",groups="CMS")
	public void testInvestorsCorporateGovernanceContactBoardOfDirectors() throws InterruptedException, AWTException
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getInvestorsUserName(),appConfig.getInvestorsPassword());
		//cmsUserActions.get().clickOnElementUsingImage("Contributor.JPG");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsBusinessFunction.get().closeOpenTabs();
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("LeftNavFrame");
		cmsUserActions.get().clickOn("LeftNav_Inv_Default");
		cmsUserActions.get().clickOn("LeftNav_Investors");
		cmsBusinessFunction.get().verifyElementContainsText("Investors_Attributes", ",");
		cmsUserActions.get().clickOn("LeftNav_Investors_CorporateGovernance");
		cmsBusinessFunction.get().verifyElementContainsText("CorporateGovernance_Attributes", "@");
		cmsUserActions.get().doubleClickOn("LeftNav_ContactBoardOfDirectors");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsBusinessFunction.get().verifyElementContainsText("ContactBoardOfDirectors_Attributes", ",");
		cmsUserActions.get().clickOnElementUsingImage("EditCMS.JPG");
		cmsUserActions.get().clearText("ContactBoardOfDirectors_NameField");
		cmsUserActions.get().enterText("ContactBoardOfDirectors_NameField", "ContactBoardOfDirectors_Name");
		cmsUserActions.get().clickOn("ContactBoardOfDirectors_TemplateArrow");
		cmsUserActions.get().clickOn("ContactBoardOfDirectors_Template");
		cmsUserActions.get().clearText("ContactBoardOfDirectors_TitleField");
		cmsUserActions.get().enterText("ContactBoardOfDirectors_TitleField", "ContactBoardOfDirectors_Name");
		cmsUserActions.get().clearText("ContactBoardOfDirectors_SubHeading");
		cmsUserActions.get().enterText("ContactBoardOfDirectors_SubHeading", "ContactBoardOfDirectors_Name");
		cmsUserActions.get().clickOn("ContactBoardOfDirectors_HeroImage_CrossButton");
		cmsBusinessFunction.get().advanceSearchWithoutSubAssertType("AdvancedSearchAssetType_AvayaMedia", "qa_auto_test_InvestorsImage");
		//cmsBusinessFunction.get().searchAsset("qa_auto_test_InvestorsImage");
		cmsBusinessFunction.get().dragAndDrop("ContactBoardOfDirectors_ImageSource","ContactBoardOfDirectors_ImageDestination",100);
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsBusinessFunction.get().ckEditor("ContactBoardOfDirectors_TextBody", "ContactBoardOfDirectors_Text", "ContactBoardOfDirectors_Frame");
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");
		cmsVerify.get().verifyAssetSaved();
	}
	
	/**
	  Author Name                       : Niharika K R
	  Date of Preparation               : 26-08-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify the creation  of a Demand Gen Form
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	 * @throws AWTException 
	  **/
	
	@Test(description="Verify the creation  of a Demand Gen Form")
	public void testCmsDemandGenForm() throws InterruptedException, AWTException
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());	
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().hoverOn("Content");
		cmsUserActions.get().clickOn("New");
		cmsUserActions.get().clickOn("NewAvayaPage");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsBusinessFunction.get().verifyElementContainsText("AvayaPageAttributes", ",");
		cmsUserActions.get().clickOn("NewPage_PageDefinitionArrow");
		cmsUserActions.get().clickOn("AvayaDemandGenPage_Option");
		cmsBusinessFunction.get().verifyElementContainsText("AvayaDemandGenPage_Attributes", ",");
		cmsUserActions.get().enterText("AvayaDemandGenPage_NameField", "AvayaDemandGenPage_Name");
		cmsBusinessFunction.get().advanceSearchWithoutSubAssertType("AdvancedSearchAssetType_Page", "qa_auto_test_TestDemandGenPage");
		//cmsBusinessFunction.get().searchAsset("qa_auto_test_TestDemandGenPage");
		cmsBusinessFunction.get().dragAndDrop("AvayaDemandGenPage_PageSource", "AvayaDemandGenPage_PageDestination", 50);
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().clickOn("AvayaDemandGenPage_TemplateArrow");
		cmsUserActions.get().clickOn("AvayaDemandGenPage_Template");
		cmsUserActions.get().enterText("AvayaDemandGenPage_TitleField", "AvayaDemandGenPage_Title");
		cmsUserActions.get().enterText("AvayaDemandGenPage_UrlField", "AvayaDemandGenPage_Url");
		cmsUserActions.get().enterText("AvayaDemandGenPage_TitleTwoField", "AvayaDemandGenPage_TitleTwo");
		cmsBusinessFunction.get().advanceSearchWithoutSubAssertType("AdvancedSearchAssetType_AvayaMedia", "qa_auto_test_Kaltura Video");
		//cmsBusinessFunction.get().searchAsset("qa_auto_test_Kaltura Video");
		cmsBusinessFunction.get().dragAndDrop("AvayaDemandGenPage_VideoSource", "AvayaDemandGenPage_VideoDestination", 100);
		cmsBusinessFunction.get().advanceSearchWithoutSubAssertType("AdvancedSearchAssetType_AvayaMedia", "qa_auto_test_TestImage");
		//cmsBusinessFunction.get().searchAsset("qa_auto_test_TestImage");
		cmsBusinessFunction.get().dragAndDrop("AvayaDemandGenPage_ImageSource", "AvayaDemandGenPage_ImageDestination", 100);
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsBusinessFunction.get().ckEditor("AvayaDemandGenPage_DescriptionTwoField", "AvayaDemandGenPage_DescriptionTwo", "AvayaDemandGenPage_DescriptionTwoFrame");
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsBusinessFunction.get().ckEditor("AvayaDemandGenPage_DescriptionField", "AvayaDemandGenPage_Description", "AvayaDemandGenPage_Frame");
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsBusinessFunction.get().ckEditor("AvayaDemandGenPage_DesclaimerField", "AvayaDemandGenPage_Desclaimer", "AvayaDemandGenPage_DesclaimerFrame");
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");
		cmsVerify.get().verifyAssetSaved();
	}
	

	/**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 26-08-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify the creation of article asset
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws AWTException 
	  **/
	
	@Test(description="Verify the creation of article asset",groups="CMS")
	public void testCreationOfNewArticleAsset() throws InterruptedException, AWTException
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		//cmsBusinessFunction.get().clearCookies();
		/*cmsUserActions.get().clearText("SiteSelectionField");
		cmsUserActions.get().enterText("SiteSelectionField", "Avaya");
		cmsUserActions.get().clickOnElementUsingImage("Contributor.JPG");*/
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().hoverOn("Content");
		cmsUserActions.get().clickOn("New");
		cmsUserActions.get().clickOn("NewAvayaArticles");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsBusinessFunction.get().verifyElementContainsText("AvayaArticlesParent",",");
		cmsUserActions.get().clickOn("AvayaArticlesParentDefinition_Arrow");
		cmsUserActions.get().clickOn("RASArticles");
		cmsBusinessFunction.get().verifyElementContainsText("ArticlesPageParent",",");
		cmsUserActions.get().enterText("ArticleNameField", "ArticleNewName");
		cmsUserActions.get().enterText("ArticleTitleField", "ArticleNewName");
		cmsBusinessFunction.get().ckEditor("Article_Description", "ArticleNewDescription","Article_DescriptionFrame");
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().clickOn("Article_DateField_Calender");
		cmsUserActions.get().clickOn("Article_DateField_Date");
		cmsBusinessFunction.get().advanceSearch("AdvancedSearchAssetType_AvayaMedia", "AdvancedSearchAssetSubType_RASImage", "qa_auto_test_Networks Image");
	//	cmsBusinessFunction.get().searchAsset("qa_auto_test_Networks Image");
		cmsBusinessFunction.get().dragAndDrop("Article_ImageSource","Article_ImageDestination",50);
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().clickOn("SearchField_CrossButton");
		cmsBusinessFunction.get().searchAsset("qa_auto_test_Kaltura Video");
		cmsBusinessFunction.get().dragAndDrop("Article_VideoSource","Article_VideoDestination",50);
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().clickOn("AlignmentOfArticlesDropdown");
		cmsUserActions.get().clickOn("AlignmentOfArticlesRight");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().clickOn("SearchField_CrossButton");
		cmsBusinessFunction.get().searchAsset("qa_auto_test_Try It Now Url");
		cmsBusinessFunction.get().dragAndDrop("ArticleUrlSource","Article_UrlDestination",50);
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().enterText("CTALinkTitleField", "CTALinkTitle");
		cmsUserActions.get().enterText("CTALinkUrlField", "CTALinkUrl");
		cmsUserActions.get().clickOn("MetadataTab");
		cmsUserActions.get().clickOn("DropDown");
		cmsUserActions.get().clickOn("DropDown_en_US");
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");
		cmsVerify.get().verifyAssetSaved();
		cmsUserActions.get().clickOnElementUsingImage("ApproveCMS.JPG");
		cmsUserActions.get().clickOn("stagingDelivery");
		cmsUserActions.get().clickOn("ApproveWithDependenciesButton");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().clickOn("CMSLogout");
		//cmsBusinessFunction.get().Publish("qa_auto_test_Avaya Aura - Taking the Next Steps");
		
	}
	
	/**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 27-08-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify the creation of Video asset
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	 * @throws AWTException 
	  **/
	
	@Test(description="Verify the creation of Video asset",groups="CMS")
	public void testCreationOfVideoAsset() throws InterruptedException, AWTException
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsBusinessFunction.get().closeOpenTabs();
		cmsUserActions.get().hoverOn("Content");
		cmsUserActions.get().clickOn("New");
		cmsUserActions.get().clickOn("NewMedia");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsBusinessFunction.get().verifyElementContainsText("Avaya_MediaAttributes", ",");
		cmsUserActions.get().clickOn("NewMedia_ParentDefinitionArrow");
		cmsUserActions.get().clickOn("RASVideo");
		cmsBusinessFunction.get().verifyElementContainsText("RASVideoAttributes",",");
		cmsUserActions.get().enterText("RASVideo_NameField", "RASVideo_Name");
		cmsUserActions.get().enterText("RASVideoDescriptionField", "RASVideoDescription");
		//cmsBusinessFunction.get().searchAsset("qa_auto_test_TestImage");
		cmsBusinessFunction.get().advanceSearch("AdvancedSearchAssetType_AvayaMedia", "AdvancedSearchAssetSubType_RASImage", "qa_auto_test_Networks Image");
		cmsBusinessFunction.get().dragAndDrop("RASVideo_ImageSource","RASVideo_ImageDestination",50);
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().clickOn("SearchField_CrossButton");
		cmsBusinessFunction.get().searchAsset("Kaltura Video");
		cmsBusinessFunction.get().dragAndDrop("RASVideo_VideoSource","RASVideo_VideoDestination",50);
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().enterText("VideoKalturaUrlField", "VideoKalturaUrl");
		cmsUserActions.get().clickOn("MetadataTab");
		cmsUserActions.get().clickOn("Metadata_DropDown");
		cmsUserActions.get().clickOn("DropDown_en_US");
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");
		cmsVerify.get().verifyAssetSaved();
		cmsUserActions.get().clickOnElementUsingImage("ApproveCMS.JPG");
		cmsUserActions.get().clickOn("stagingDelivery");
		cmsUserActions.get().clickOn("ApproveWithDependenciesButton");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().clickOn("CMSLogout");
		//cmsBusinessFunction.get().Publish("qa_auto_test_Kaltura Video");
	}
	/**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 27-08-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify the creation of new avaya document
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	 * @throws AWTException 
	  **/
	
	@Test(description="Verify the creation of new avaya document",groups="CMS")
	public void testCreationOfAvayaDocument() throws InterruptedException
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsBusinessFunction.get().closeOpenTabs();
		cmsUserActions.get().hoverOn("Content");
		cmsUserActions.get().clickOn("New");
		cmsUserActions.get().clickOn("NewAvayaArticles");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsBusinessFunction.get().verifyElementContainsText("NewArticles_Attributes", ",");
		cmsUserActions.get().clickOn("AvayaArticlesParentDefinition_Arrow");
		cmsUserActions.get().clickOn("RASDocument");
		cmsBusinessFunction.get().verifyElementContainsText("RASDocument_Attributes", ",");
		cmsUserActions.get().enterText("DocumentName_Field", "DocumentName");
		cmsUserActions.get().enterText("DocumentType_Field", "DocumentType");
		cmsUserActions.get().clickOn("MetadataTab");
		cmsUserActions.get().clickOn("Metadata_DropDown");
		cmsUserActions.get().clickOn("DropDown_en_US");
		//cmsUserActions.get().clickOn("SaveButton");
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");
		cmsVerify.get().verifyAssetSaved();
		
		cmsUserActions.get().clickOnElementUsingImage("ApproveCMS.JPG");
		cmsUserActions.get().clickOn("stagingDelivery");
		Thread.sleep(5000);
		cmsUserActions.get().clickOn("ApproveWithDependenciesButton");
		Thread.sleep(18000);
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().clickOn("CMSLogout");
		Thread.sleep(5000);
		//cmsBusinessFunction.get().Publish("qa_auto_test_Documentary");
	}
	

	/**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 28-08-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify if the user is able to view the asset of type "Redesign of Avaya Perspective Category"
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	 * @throws AWTException 
	  **/
	
	@Test(description="Verify if the user is able to view the asset of type Redesign of Avaya Perspective Category",groups="CMS")
	public void testPerspectiveRedesignOfAvayaPerspectiveCategory() 
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		//cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("LeftNavFrame");
		cmsUserActions.get().clickOn("LeftNav_Default");
		cmsUserActions.get().clickOn("LeftNav_Default_Home");
		cmsUserActions.get().clickOn("LeftNav_Default_Home_About");
		cmsUserActions.get().doubleClickOn("Perspectives_mainPage");	
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().clickOn("Perspectives_mainPage_Category_Link");
		cmsBusinessFunction.get().closePreviousTab();		
		cmsBusinessFunction.get().verifyElementContainsText("PerspectiveCategory_Attributes", ",");
	}
	
	/**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 28-08-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify the creation of new around the web article
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	 * @throws AWTException 
	  **/
	
	@Test(description="Verify the creation of new around the web article",groups="CMS")
	public void testCreationOfAroundTheWebArticle() throws InterruptedException, AWTException
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsBusinessFunction.get().closeOpenTabs();
		cmsUserActions.get().hoverOn("Content");
		cmsUserActions.get().clickOn("New");
		cmsUserActions.get().clickOn("NewAvayaArticles");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsBusinessFunction.get().verifyElementContainsText("NewArticles_Attributes", ",");
		cmsUserActions.get().clickOn("AvayaArticlesParentDefinition_Arrow");
		cmsUserActions.get().clickOn("RASAroundTheWebArticle");
		cmsElementFactory.get().dynamicWait("WebArticle_NameField", 10);
		cmsUserActions.get().enterText("WebArticle_NameField", "WebArticle_Name");
		cmsUserActions.get().enterText("WebArticle_HeadlineField", "WebArticle_Name");
		cmsUserActions.get().enterText("WebArticle_AuthorField", "WebArticle_Author");
		cmsBusinessFunction.get().advanceSearch("AdvancedSearchAssetType_AvayaMedia","AdvancedSearchAssetSubType_RASImage", "qa_auto_test_TestImage");
		cmsBusinessFunction.get().dragAndDrop("WebArticle_ImageSource","WebArticle_ImageDestination",50);		
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().enterText("WebArticle_ReadMoreField", "WebArticle_ReadMore");
		cmsUserActions.get().clickOn("MetadataTab");
		cmsUserActions.get().clickOn("Metadata_DropDown");
		cmsUserActions.get().clickOn("DropDown_en_US");
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");
		cmsVerify.get().verifyAssetSaved();	
		Thread.sleep(10000);	
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().clickOn("CMSLogout");
		/*getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().enterText("SearchBox", "Search_PerspectiveWidgets");
		cmsUserActions.get().clickOnElementUsingImage("Magnifier.JPG");
		cmsUserActions.get().doubleClickOn("Search_PerspectiveWidgets");
		cmsBusinessFunction.get().closePreviousTab();
		cmsUserActions.get().clickOnElementUsingImage("EditCMS.JPG");
		cmsBusinessFunction.get().advanceSearchWithoutSubAssertType("AdvancedSearchAssetType_AvayaArticle", "qa_auto_test_Apple Around the World");
		cmsBusinessFunction.get().dragAndDrop("AroundWebArticle_Source","AroundWebArticle_Destination",50);
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");
		cmsVerify.get().verifyAssetSaved();
		cmsUserActions.get().clickOnElementUsingImage("ApproveCMS.JPG");		
		cmsUserActions.get().clickOn("stagingDelivery");
		cmsUserActions.get().clickOn("ApproveWithDependenciesButton");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().clickOn("CMSLogout");
		cmsBusinessFunction.get().Publish("qa_auto_test_Apple Around the World");
		getDriver().get("http://wwwcms-staging.avaya.com/cs/avaya/usa/perspectives");
		cmsBusinessFunction.get().creationOfAroundTheWebArticleUI();*/
		
		
	}
	
	/**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 01-09-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify the Mediakits articles created
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws AWTException 
	 * @throws InterruptedException 
	  **/
	
	@Test(description="Verify the Mediakits articles created",groups="CMS")
	public void testNewsRoomCmsMediaKitArticlesSave() throws InterruptedException, AWTException
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		//cmsUserActions.get().clickOnElementUsingImage("Contributor.JPG");
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsBusinessFunction.get().closeOpenTabs();
		cmsUserActions.get().hoverOn("Content");
		cmsUserActions.get().clickOn("New");
		cmsUserActions.get().clickOn("NewAvayaContent");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsBusinessFunction.get().verifyElementContainsText("AvayaContent_Attributes", ",");
		cmsVerify.get().isElementDisplayed("NewAvayaContent_ContinueButton");
		cmsUserActions.get().clickOn("AvayaContentParentDefinition_Arrow");
		cmsUserActions.get().clickOn("RASNewsRoom");
		cmsElementFactory.get().dynamicWait("RASNewsRoom_NameField", 10);
		cmsUserActions.get().enterText("RASNewsRoom_NameField", "RASNewsRoom_AttributeName");
		cmsUserActions.get().clickOn("RASNewsRoom_TemplateArrow");
		cmsUserActions.get().clickOn("RASNewsRoom_MediaKitTemplate");
		//cmsBusinessFunction.get().searchAsset(" qa_auto_test_TestServiceCategory");
		cmsBusinessFunction.get().advanceSearch("AdvancedSearchAssetType_AvayaMasterData", "AdvancedSearchAssetSubType_RASPServiceCategory", "qa_auto_test_TestServiceCategory");
		cmsBusinessFunction.get().dragAndDrop("RASNewsRoom_CategorySource","RASNewsRoom_CategoryDestination",100);
		cmsUserActions.get().clickOn("RASNewsRoom_ContentTypeArrow");
		cmsUserActions.get().clickOn("RASNewsRoom_ContentType_MediaKits");
		cmsUserActions.get().enterText("RASNewsRoom_MetaPageTitleField", "RASNewsRoom_MetaPageTitle");
		cmsUserActions.get().enterText("RASNewsRoom_MetaDescriptionField", "RASNewsRoom_MetaDataDescription");
		cmsUserActions.get().enterText("RASNewsRoom_MetaKeywordsField", "RASNewsRoom_MetaKeywords");
		cmsUserActions.get().clickOn("MetadataTab");
		cmsUserActions.get().clickOn("Metadata_DropDown");
		cmsUserActions.get().clickOn("DropDown_en_US");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().hoverOn("Content");
		cmsUserActions.get().clickOn("SaveUnderContent");
	}
	

	/**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 01-09-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify the creation of People Asset
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws AWTException 
	 * @throws InterruptedException 
	  **/
	
	@Test(description="Verify the creation of People Asset",groups="CMS")
	public void testAvayaLabsCreationOfAboutAvayaContent() throws InterruptedException, AWTException
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsBusinessFunction.get().closeOpenTabs();
		cmsUserActions.get().hoverOn("Content");
		cmsUserActions.get().clickOn("New");
		cmsUserActions.get().clickOn("NewAvayaContent");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsBusinessFunction.get().verifyElementContainsText("AvayaContent_Attributes", ",");
		cmsUserActions.get().clickOn("AvayaArticlesParentDefinition_Arrow");
		cmsUserActions.get().clickOn("RASAboutAvayaContent");
		cmsBusinessFunction.get().verifyElementContainsText("RASAboutAvayaContent_Attributes", ",");
		cmsUserActions.get().enterText("RASAboutAvayaContent_NameField", "RASAboutAvayaContent_Name");
		Thread.sleep(5000);
		cmsUserActions.get().clickOn("RASCountries_TemplateArrow");
		cmsUserActions.get().clickOn("RASAboutAvayaContent_TemplateAboutAvayaContentDisplay");
		cmsUserActions.get().enterText("RASAboutAvayaContent_TitleField", "RASAboutAvayaContent_Title");
		//cmsBusinessFunction.get().searchAsset("qa_auto_test_TestImage");
		cmsBusinessFunction.get().advanceSearch("AdvancedSearchAssetType_AvayaMedia","AdvancedSearchAssetSubType_RASImage", "qa_auto_test_TestImage");
		cmsBusinessFunction.get().dragAndDrop("RASAboutAvayaContent_ImageSource","RASAboutAvayaContent_ImageDestination",50);
		cmsUserActions.get().enterText("RASAboutAvayaContent_DescriptionTitleField", "RASAboutAvayaContent_DescriptionTitle");
		cmsBusinessFunction.get().ckEditor("RASAboutAvayaContent_DescriptionField", "RASAboutAvayaContent_DescriptionTitle", "RASAboutAvayaContent_DescriptionFrame");
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().enterText("RASAboutAvayaContent_MetaPageTitleField", "RASAboutAvayaContent_MetaPageTitle");
		cmsUserActions.get().enterText("RASAboutAvayaContent_MetaDescriptionField", "RASAboutAvayaContent_MetaPageTitle");
		cmsUserActions.get().enterText("RASAboutAvayaContent_MetaKeyword", "RASAboutAvayaContent_MetaPageTitle");
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");
		cmsVerify.get().verifyAssetSaved();
		
	}
	
	/**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 02-09-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify the country asset in Content management application
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws AWTException 
	 * @throws InterruptedException 
	  **/
	
	@Test(description="Verify the country asset in Content management application",groups="CMS")
	public void testCreationOfCountryAssetDetails() throws InterruptedException, AWTException
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		cmsUserActions.get().switchToFrame("Main_Frame");
		//cmsBusinessFunction.get().closeOpenTabs();
		cmsUserActions.get().hoverOn("Content");
		cmsUserActions.get().clickOn("New");
		cmsUserActions.get().clickOn("New_AvayaCountry");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsBusinessFunction.get().verifyElementContainsText("NewAvayaCountryLocaleMapParent_Attributes", ",");
		cmsUserActions.get().clickOn("AvayaCountryLocaleMapParentDefinition_Arrow");
		cmsUserActions.get().clickOn("RASCountries");
		cmsElementFactory.get().dynamicWait("RASCountries_NameField", 20);
		cmsUserActions.get().enterText("RASCountries_NameField", "RASCountries_Name");
		cmsUserActions.get().clickOn("RASCountries_TemplateArrow");	
		cmsUserActions.get().clickOn("RASCountries_Template_RASContactLocation");
		cmsUserActions.get().enterText("RASCountries_CountryNameField", "RASCountries_CountryName");
		cmsBusinessFunction.get().ckEditor("RASCountries_ContactInformationField", "RASCountries_ContactInformation", "RASCountries_ContactInformationFrame");
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");
		//cmsBusinessFunction.get().searchAsset("url_test");
		cmsBusinessFunction.get().advanceSearch("AdvancedSearchAssetType_AvayaContent","AdvancedSearchAssetSubType_RASUrl", "qa_auto_test_Try It Now Url");		
		cmsBusinessFunction.get().dragAndDrop("RASCountries_URLSource","RASCountries_URLDestination",50);
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");		
		cmsUserActions.get().clickOn("RASCountries_PageTitleAddButton");
		cmsUserActions.get().enterText("RASCountries_PageTitleField","RASCountries_PageTitle");
		cmsElementFactory.get().dynamicWait("RASCountries_RASRegion", 10);
		cmsBusinessFunction.get().selectFromLeftListBox("RASCountries_RASRegion", "RASCountries_RASRegionSelect");
		cmsElementFactory.get().dynamicWait("RightButtonToTransfer", 10);
		cmsBusinessFunction.get().transferRight("RightButtonToTransfer");
		cmsUserActions.get().clickOn("RASRegion_PageTitleAddButton");
		cmsUserActions.get().enterText("RASRegion_PageTitleField", "RASRegion_RegionName");
		cmsUserActions.get().clickOn("MetadataTab");
		cmsUserActions.get().clickOn("Metadata_DropDown");
		cmsUserActions.get().clickOn("DropDown_en_US");
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");
		cmsVerify.get().verifyAssetSaved();
		cmsUserActions.get().clickOnElementUsingImage("ApproveCMS.JPG");
		cmsUserActions.get().clickOn("stagingDelivery");
		cmsUserActions.get().clickOn("ApproveWithDependenciesButton");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().clickOn("CMSLogout");
		//cmsBusinessFunction.get().Publish("qa_auto_test_Uganda");
	}
	
	/**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 02-09-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify whether the edited product in CMS application is displayed correctly on UI.
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws AWTException 
	 * @throws InterruptedException 
	  **/
	
	@Test(description="Verify whether the edited product in CMS application is displayed correctly on UI.",groups="CMS")
	public void testServiceAssetEdit() throws InterruptedException, AWTException
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		Thread.sleep(8000);
		cmsBusinessFunction.get().advanceSearchWithLocale("AdvancedSearchAssetType_AvayaContent","RASServices","DropDown_en_US", "Contact Center Optimization");
		cmsUserActions.get().doubleClickOn("Contact Center Optimization");
		Thread.sleep(8000);
		cmsUserActions.get().clickOnElementUsingImage("EditCMS.JPG");
		cmsBusinessFunction.get().ckEditor("ServiceSubHeader", "ContactCenterOptimization_SubHeading_TestPublish", "ServiceSubHeaderFrame");
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().clickOn("MetadataTab");
		cmsUserActions.get().clickOn("DropDown");
		cmsUserActions.get().clickOn("DropDown_en_US");
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");
		cmsVerify.get().verifyAssetSaved();	
		Thread.sleep(8000);
		cmsUserActions.get().clickOnElementUsingImage("ApproveCMS.JPG");		
		cmsUserActions.get().clickOn("stagingDelivery");
		cmsUserActions.get().clickOn("ApproveWithDependenciesButton");
		Thread.sleep(8000);
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().clickOn("CMSLogout");	
	/*	cmsBusinessFunction.get().Publish("Contact Center Optimization");
		getDriver().get("http://www-staging.avaya.com/usa/service/contact-center-optimization/");
		Thread.sleep(10000);
		cmsVerify.get().isTextPresent("Contact Center Optimization_label_CMSPublished", "ContactCenterOptimization_SubHeading_TestPublish");
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		Thread.sleep(8000);
		cmsBusinessFunction.get().advanceSearchWithLocale("AdvancedSearchAssetType_AvayaContent","RASServices","DropDown_en_US", "Contact Center Optimization");
		cmsUserActions.get().doubleClickOn("Contact Center Optimization");
		Thread.sleep(8000);
		cmsUserActions.get().clickOnElementUsingImage("EditCMS.JPG");
		cmsBusinessFunction.get().ckEditor("ServiceSubHeader", "ContactCenterOptimization_SubHeading", "ServiceSubHeaderFrame");
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().clickOn("MetadataTab");
		cmsUserActions.get().clickOn("DropDown");
		cmsUserActions.get().clickOn("DropDown_en_US");
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");
		cmsVerify.get().verifyAssetSaved();	
		Thread.sleep(8000);
		cmsUserActions.get().clickOnElementUsingImage("ApproveCMS.JPG");		
		cmsUserActions.get().clickOn("stagingDelivery");
		cmsUserActions.get().clickOn("ApproveWithDependenciesButton");
		Thread.sleep(8000);
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().clickOn("CMSLogout");	
		cmsBusinessFunction.get().Publish("Contact Center Optimization");	*/	
			
	}
	

	/**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 03-09-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify the creation of an annual report article
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws AWTException 
	 * @throws InterruptedException 
	  **/
	
	@Test(description="Verify the creation of an annual report article",groups="CMS")
	public void testInvestorsCreationOfAnnualReportArticle() throws InterruptedException, AWTException
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getInvestorsUserName(),appConfig.getInvestorsPassword());
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().hoverOn("Content");
		cmsUserActions.get().clickOn("New");
		cmsUserActions.get().clickOn("NewAvayaArticles");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsElementFactory.get().dynamicWait("Investors_NewArticles_NameField", 20);
		cmsUserActions.get().enterText("Investors_NewArticles_NameField", "ArticleName_AnnualReport");
		cmsUserActions.get().clickOn("AvayaArticlesParentDefinition_Arrow");
		cmsUserActions.get().clickOn("AnnualReport");
		cmsBusinessFunction.get().ckEditor("AnnualReport_DescriptionField", "AnnualReport_Description", "AnnualReport_Frame");
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().enterText("AnnualReport_TitleField", "ArticleName_AnnualReport");
		cmsBusinessFunction.get().advanceSearchWithoutSubAssertType("AdvancedSearchAssetType_AvayaArticles", "qa_auto_test_RASDocumentToTest");	
		cmsBusinessFunction.get().dragAndDrop("AnnualReport_PresentationSource","AnnualReport_PresentationDestination", 50);
		cmsBusinessFunction.get().advanceSearchWithoutSubAssertType("AdvancedSearchAssetType_AvayaArticles", "qa_auto_test_RASDocumentToTest");
		cmsBusinessFunction.get().dragAndDrop("AnnualReport_PressReleaseDocumentSource", "AnnualReport_PressReleaseDestination", 50);
		cmsBusinessFunction.get().scrollDown();
		cmsBusinessFunction.get().advanceSearchWithoutSubAssertType("AdvancedSearchAssetType_AvayaMedia", "qa_auto_test_InvestorsImage");
		cmsBusinessFunction.get().dragAndDrop("AnnualReport_ImageSource","AnnualReport_ImageDestination", 50);
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");
		cmsVerify.get().verifyAssetSaved();
		cmsUserActions.get().clickOnElementUsingImage("ApproveCMS.JPG");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().clickOn("stagingDelivery");
		cmsUserActions.get().clickOn("ApproveWithDependenciesButton");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().clickOn("CMSLogout");
		cmsBusinessFunction.get().Publish("qa_auto_test_Test_Anual Report");
	}	
	
	/**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 03-09-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify the creation of URL asset
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	  **/
	
	@Test(description="Verify the creation of URL asset",groups="CMS")
	public void testCreationOfUrlAsset() throws InterruptedException
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsBusinessFunction.get().closeOpenTabs();
		cmsUserActions.get().hoverOn("Content");
		cmsUserActions.get().clickOn("New");
		cmsUserActions.get().clickOn("NewAvayaContent");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsBusinessFunction.get().verifyElementContainsText("AvayaContent_Attributes", ",");
		cmsUserActions.get().clickOn("NewMedia_ParentDefinitionArrow");
		cmsUserActions.get().clickOn("RASUrl");
		cmsBusinessFunction.get().verifyElementContainsText("RASUrl_Attributes", ",");
		cmsUserActions.get().enterText("RASUrl_NameField", "RASUrl_Name");
		cmsUserActions.get().enterText("RASUrl_LinkTitleField", "RASUrl_Name");
		cmsUserActions.get().enterText("RASUrl_LinkUrlField", "RASUrl_LinkUrl");
		cmsUserActions.get().clickOn("MetadataTab");
		cmsUserActions.get().clickOn("DropDown");
		cmsUserActions.get().clickOn("DropDown_en_US");
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");
		cmsVerify.get().verifyAssetSaved();
		cmsUserActions.get().clickOnElementUsingImage("ApproveCMS.JPG");
		cmsUserActions.get().clickOn("stagingDelivery");
		cmsUserActions.get().clickOn("ApproveWithDependenciesButton");
		Thread.sleep(8000);
		cmsUserActions.get().switchToDefaultContent();
		Thread.sleep(8000);
		cmsUserActions.get().clickOn("CMSLogout");
		Thread.sleep(8000);
		getDriver().manage().deleteAllCookies();
		Thread.sleep(8000);
		//cmsBusinessFunction.get().Publish("qa_auto_test_Try It Now Url");
	}


	/**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 04-09-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify if the user is able to create URL Content in CMS
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	 * @throws AdbCommandRejectedException 
	  **/
	
	@Test(description="Verify if the user is able to create URL Content in CMS",groups="CMS")
	public void testCreateUrl() throws InterruptedException, AdbCommandRejectedException
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin("username","password");
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsBusinessFunction.get().closeOpenTabs();
		cmsUserActions.get().hoverOn("Content");
		cmsUserActions.get().clickOn("New");
		cmsUserActions.get().clickOn("NewAvayaUrl");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsElementFactory.get().dynamicWait("NewAvayaUrl_Attributes", 20);
		cmsBusinessFunction.get().verifyElementContainsText("NewAvayaUrl_Attributes", ",");
		cmsUserActions.get().enterText("NewAvayaUrl_NameField", "NewAvayaUrl_Name");
		cmsUserActions.get().enterText("NewAvayaUrl_LinkTitleField", "NewAvayaUrl_LinkTitle");
		cmsUserActions.get().enterText("NewAvayaUrl_LinkUrlField", "NewAvayaUrl_LinkUrl");
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");
		cmsVerify.get().verifyAssetSaved();
		cmsElementFactory.get().dynamicWait("AssetContentHeader", 20);
		cmsVerify.get().isTextPresent("AssetContentHeader","AssetHeader_Url");
		cmsUserActions.get().clickOnElementUsingImage("ApproveCMS.JPG");
		cmsUserActions.get().clickOn("stagingDelivery");
		cmsUserActions.get().clickOn("ApproveWithDependenciesButton");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().clickOn("CMSLogout");
		cmsBusinessFunction.get().Publish("qa_auto_test_testresource");
	}
	
	/**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 16-09-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : 
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws AWTException 
	 * @throws InterruptedException 
	  **/
	
	
	@Test(description="Globalization Translation Of ResourceArticle",groups="CMS")
	public void testGlobalizationTranslationOdResourceArticle() throws InterruptedException
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsBusinessFunction.get().closeOpenTabs();
		cmsUserActions.get().hoverOn("Content");
		cmsUserActions.get().clickOn("New");
		cmsUserActions.get().clickOn("NewAvayaArticles");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().enterText("NewArticles_GlobalNameField", "NewArticles_GlobalName");
		cmsUserActions.get().clickOn("NewArticles_GlobalParentDefinition_ResourceArticleArrow");
		cmsUserActions.get().clickOn("NewArticles_GlobalParentDefinition_ResourceArticle");
		cmsUserActions.get().enterText("RASArticles_ResourceTitleField", "RASArticles_ResourceTitle");
		cmsUserActions.get().enterText("RASArticles_ResourceDescriptionField", "RASArticles_ResourceDescription");
		cmsUserActions.get().clickOn("RASArticles_ResourceDateImage");
		cmsUserActions.get().clickOn("RASArticles_ResourceDate");
		cmsUserActions.get().clickOn("MetadataTab");
		cmsUserActions.get().clickOn("Metadata_DropDown");
		cmsUserActions.get().clickOn("DropDown_en_US");
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");
		Thread.sleep(30000);
		cmsUserActions.get().switchToDefaultContent();
		cmsElementFactory.get().dynamicWait("Main_Frame",10);
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsBusinessFunction.get().closeOpenTabs();
		cmsBusinessFunction.get().advanceSearchWithoutSubAssertType("AdvancedSearchAssetType_AvayaArticle", "qa_auto_test_testresourceNewSeven1");
		cmsUserActions.get().clickOn("undock");
		//cmsUserActions.get().enterText("SearchBox", "GlobalArticle_Search");
		//cmsUserActions.get().clickOnElementUsingImage("Magnifier.JPG");
		cmsUserActions.get().clickOn("GlobalArticle_Search_Results");
		cmsBusinessFunction.get().closePreviousTab();
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().clickOn("MetadataTab");
		cmsUserActions.get().clickOn("GlobalArticle_Translate_de_DE");
		Thread.sleep(10000);
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");
		cmsVerify.get().verifyAssetSaved();	
	
		
	}

	/**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 04-09-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify the creation of Service Asset
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws AWTException 
	 * @throws InterruptedException 
	  **/
	
	@Test(description="Verify the creation of Service Asset",groups="CMS")
	public void testCreationOfServiceAsset() throws InterruptedException, AWTException
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(), appConfig.getAvayaPassword());
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsBusinessFunction.get().closeOpenTabs();
		cmsUserActions.get().hoverOn("Content");
		cmsUserActions.get().clickOn("New");
		cmsUserActions.get().clickOn("NewAvayaContent");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsBusinessFunction.get().verifyElementContainsText("AvayaContent_Attributes", ",");
		cmsUserActions.get().clickOn("AvayaContentParentDefinition_Arrow");
		cmsUserActions.get().clickOn("RASServices");
		cmsElementFactory.get().dynamicWait("RASServices_NameField", 20);
		cmsUserActions.get().enterText("RASServices_NameField", "RASServices_Name");
		cmsUserActions.get().clickOn("RASServices_TemplateArrow");
		cmsUserActions.get().clickOn("RASServices_Template_ServiceDetailWrapper");
		cmsUserActions.get().enterText("RASServices_ServiceNameField", "RASServices_ServiceName");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().clickOn("SearchWithDownArrow");
		cmsUserActions.get().clickOn("SearchFilter_FindServiceCategory");
		cmsBusinessFunction.get().advanceSearchWithLocale("AdvancedSearchAssetType_AvayaMasterData","AdvancedSearchSubType_RASServiceCategory","DropDown_en_US", "Operations Services");
		//cmsBusinessFunction.get().searchAsset("Operations Services");
		//cmsBusinessFunction.get().advanceSearch("AdvancedSearchAssetType_AvayaMasterData", "AdvancedSearchSubType_RASServiceCategory", "Operation Services");
		cmsBusinessFunction.get().dragAndDrop("RASServices_CategorySource", "RASServices_CategoryDestination", 50);
		cmsUserActions.get().enterText("RASServices_MetaPageTitleField", "RASServices_MetaPageTitle");
		cmsBusinessFunction.get().ckEditor("RASServices_ServiceSubheadField", "RASServices_ServiceName", "RASServices_ServiceSubheadFrame");
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().enterText("RASServices_ServiceHeaderField", "RASServices_ServiceHeader");
		cmsBusinessFunction.get().ckEditor("RASServices_ServiceOverviewContentField", "RASServices_ServiceOverviewContent", "RASServices_ServiceOverviewContentFrame");
		/*cmsBusinessFunction.get().advanceSearchWithoutSubAssertType("AdvancedSearchAssetType_AvayaMedia", "qa_auto_test_TestImage");
		cmsBusinessFunction.get().dragAndDrop("RASServices_HeroImageSource","RASServices_HeroImageDestination",50);
		cmsBusinessFunction.get().advanceSearchWithoutSubAssertType("AdvancedSearchAssetType_AvayaMedia", "qa_auto_test_TestImage");
		cmsBusinessFunction.get().dragAndDrop("RASServices_HeroImageSource","RASServices_RelatedProductsImageDestination",50);*/
		//cmsElementFactory.get().dynamicWait("RASServices_MetaPageTitleField", 20);
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().clickOn("MetadataTab");
		cmsUserActions.get().clickOn("Metadata_DropDown");
		cmsUserActions.get().clickOn("DropDown_en_US");
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");
		cmsVerify.get().verifyAssetSaved();
		cmsUserActions.get().clickOnElementUsingImage("ApproveCMS.JPG");
		cmsUserActions.get().clickOn("stagingDelivery");
		cmsUserActions.get().clickOn("ApproveWithDependenciesButton");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().clickOn("CMSLogout");
		//cmsBusinessFunction.get().Publish("qa_auto_test_Internet Data Services");
	}
	
	
	/**
	  Author Name                       : Sindhuja P
	  Date of Preparation               : 21-08-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify if the user is able to add Intro Image and Intro text in Service Landing page.
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	 * @throws AWTException 
	  **/
	
	@Test(description="Verify if the user is able to add Intro Image and Intro text in Service Landing page")
	public void testServiceLandingPageCMS() throws InterruptedException, AWTException
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		cmsUserActions.get().switchToFrame("LeftNavFrame");
		cmsUserActions.get().clickOn("LeftNav_Default");
		cmsUserActions.get().clickOn("LeftNav_Default_Home");
		cmsUserActions.get().doubleClickOn("LeftNav_Default_Home_Services_Link");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().clickOn("Category_Services");
		cmsBusinessFunction.get().closePreviousTab();
		cmsUserActions.get().clickOnElementUsingImage("EditCMS.JPG");
		cmsUserActions.get().clearText("Services_IntroTextBox");
		cmsUserActions.get().enterText("Services_IntroTextBox", "Services_IntroText");
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");	
		cmsVerify.get().verifyText("AssetTitle", "ServiceLandingPage_Header");		
	}
	
	/**
	  Author Name                       : Sindhuja P
	  Date of Preparation               : 22-08-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify if the user is able to update Operations Services
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	 * @throws AWTException 
	  **/
	
	@Test(description="Verify if the user is able to update Operations Services")
	public void testUpdatingOperationsServicesCMS() throws InterruptedException, AWTException
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		cmsUserActions.get().clickOnElementUsingImage("Contributor.JPG");
		cmsUserActions.get().switchToFrame("LeftNavFrame");
		cmsUserActions.get().clickOn("LeftNav_Default");
		cmsUserActions.get().clickOn("LeftNav_Default_Home");
		cmsUserActions.get().clickOn("LeftNav_Default_Home_Services");
		cmsUserActions.get().doubleClickOn("LeftNav_OperationServices_Link");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().clickOn("Category_OperationServices");
		cmsBusinessFunction.get().closePreviousTab();
		//cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().clickOnElementUsingImage("EditCMS.JPG");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().clickOn("OperationServices_ImageClose");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsBusinessFunction.get().advanceSearch("AdvancedSearchAssetType_AvayaMedia", "AdvancedSearchAssetSubType_RASImage", "qa_auto_test_Networks Image");
		//cmsBusinessFunction.get().searchAsset("TestImage_Auto");
		cmsBusinessFunction.get().dragAndDrop("Services_IntroImageSource","Services_ImageDestination",100);
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().enterText("Services_IntroTextBox", "OperationServices_Text");
		cmsBusinessFunction.get().ckEditor("Services_CategoryDescription", "OperationServices_Text","Services_CategoryDescriptionFrame");
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().clearText("Services_MetaPageTitleField");
		cmsUserActions.get().enterText("Services_MetaPageTitleField", "OperationServices_MetaPageTitle");
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");	 
	}

	/**
	  Author Name                       : Sindhuja P
	  Date of Preparation               : 22-08-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify if the user is able to create AnualReport Content under Articles in CMS 
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	 * @throws AWTException 
	  **/
	
	@Test(description="Verify if the user is able to create AnualReport Content under Articles in CMS",groups="CMS")
	public void testCreateArticlesAnnualReport() throws InterruptedException, AWTException
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getInvestorsUserName(),appConfig.getInvestorsPassword());
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().hoverOn("Content");
		cmsUserActions.get().clickOn("New");
		cmsUserActions.get().clickOn("NewAvayaArticles");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().enterText("Investors_NewArticles_NameField", "ArticleName_AnnualReport");
		cmsUserActions.get().clickOn("AvayaArticlesParentDefinition_Arrow");
		cmsUserActions.get().clickOn("AnnualReport");
		cmsBusinessFunction.get().ckEditor("AnnualReport_DescriptionField", "AnnualReport_Description", "AnnualReport_Frame");
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().enterText("AnnualReport_TitleField", "ArticleName_AnnualReport");
		cmsBusinessFunction.get().advanceSearchWithoutSubAssertType("AdvancedSearchAssetType_AvayaArticles", "qa_auto_test_RASDocumentToTest");
		cmsBusinessFunction.get().dragAndDrop("AnnualReport_PresentationSource","AnnualReport_PresentationDestination", 50);
		cmsBusinessFunction.get().advanceSearchWithoutSubAssertType("AdvancedSearchAssetType_AvayaArticles", "qa_auto_test_RASDocumentToTest");	
		cmsBusinessFunction.get().dragAndDrop("AnnualReport_PressReleaseSource","AnnualReport_PressReleaseDestination", 50);
		cmsBusinessFunction.get().scrollDown();
		cmsBusinessFunction.get().advanceSearchWithoutSubAssertType("AdvancedSearchAssetType_AvayaMedia", "qa_auto_test_InvestorsImage");
		cmsBusinessFunction.get().dragAndDrop("AnnualReport_ImageSource","AnnualReport_ImageDestination", 50);
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");
		cmsVerify.get().isElementDisplayed("AssetContentHeader");
	}
	
	/**
	  Author Name                       : Sindhuja P
	  Date of Preparation               : 23-08-2014
	  Date of Modified                  : 22/09/2014
	  Methods Called                    : 
	  Purpose of Method                 : Verify the attributes in Avaya Image asset in CMS"
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	 * @throws AWTException 
	  **/
	
	@Test(description="Verify the attributes in Avaya Image asset in CMS",groups="CMS")
	public void testInvestorsContentImage() throws InterruptedException, AWTException
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getInvestorsUserName(),appConfig.getInvestorsPassword());
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().hoverOn("Content");
		cmsUserActions.get().clickOn("New");
		cmsUserActions.get().clickOn("NewImage");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsBusinessFunction.get().verifyElementContainsText("Investors_ImageAttributes", ",");
		cmsVerify.get().isElementDisplayed("Investors_ImageButton");
		cmsVerify.get().isElementDisplayed("Investors_ThumbnailImageButton");		
	}
	
	/**
	  Author Name                       : Sindhuja P
	  Date of Preparation               : 25-08-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify if the user is able to create Code Of Conduct page in CMS
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	 * @throws AWTException 
	  **/
	
	@Test(description="Verify if the user is able to create Code Of Conduct page in CMS",groups="CMS")
	public void testInvestorsCorporateGovernanceCodeOfConductCMS() throws InterruptedException, AWTException
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getInvestorsUserName(),appConfig.getInvestorsPassword());
		cmsUserActions.get().switchToFrame("LeftNavFrame");
		cmsUserActions.get().clickOn("LeftNav_Inv_Default");
		cmsFactory.dynamicWait("LeftNav_Investors", 15);
		cmsUserActions.get().clickOn("LeftNav_Investors");
		cmsBusinessFunction.get().verifyElementContainsText("Investors_Attributes", ",");
		cmsUserActions.get().clickOn("LeftNav_Investors_CorporateGovernance");
		cmsFactory.dynamicWait("LeftNav_Investors_CorporateGovernance", 15);
		cmsBusinessFunction.get().verifyElementContainsText("CorporateGovernance_Attributes", "@");
		cmsUserActions.get().doubleClickOn("LeftNav_CodeOfConduct");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsBusinessFunction.get().verifyElementContainsText("CodeOfConduct_Attributes", ",");
		cmsUserActions.get().clickOnElementUsingImage("EditCMS.JPG");
		cmsUserActions.get().clearText("CodeOfConduct_NameField");
		cmsUserActions.get().enterText("CodeOfConduct_NameField", "CodeOfConduct_Name");
		cmsUserActions.get().clickOn("CodeOfConduct_TemplateArrow");
		cmsUserActions.get().clickOn("CodeOfConduct_Template");	
		cmsUserActions.get().clearText("CodeOfConduct_TitleField");
		cmsUserActions.get().enterText("CodeOfConduct_TitleField", "CodeOfConduct_Name");
		cmsUserActions.get().enterText("CodeOfConduct_SubHeadingField", "CodeOfConduct_Name");
//		cmsBusinessFunction.get().advanceSearch("AdvancedSearchAssetType_AvayaMedia", "AdvancedSearchAssetSubType_RASImage","");
//		cmsBusinessFunction.get().dragAndDrop("CodeOfConduct_ImageSource","CodeOfConduct_ImageDestination",100);			
//		cmsBusinessFunction.get().ckEditor("CodeOfConduct_TextBody", "CodeOfConduct_Text", "CodeOfConduct_TextBodyFrame");
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");
		cmsVerify.get().verifyAssetSaved();
	}
	
	/**
	  Author Name                       : Sindhuja P
	  Date of Preparation               : 25-08-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify if the user is able to create Data Privacy Policy page in CMS
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	 * @throws AWTException 
	  **/

	@Test(description="Verify if the user is able to create Data Privacy Policy page in CMS",groups="CMS")
	public void testInvestorsCorporateGovernanceDataPrivacyPolicyCMS() throws InterruptedException, AWTException
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getInvestorsUserName(),appConfig.getInvestorsPassword());	
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsBusinessFunction.get().closeOpenTabs();
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("LeftNavFrame");
		cmsUserActions.get().clickOn("LeftNav_Inv_Default");
		cmsUserActions.get().clickOn("LeftNav_Investors");
		cmsBusinessFunction.get().verifyElementContainsText("Investors_Attributes", ",");
		cmsUserActions.get().clickOn("LeftNav_Investors_CorporateGovernance");
		cmsBusinessFunction.get().verifyElementContainsText("CorporateGovernance_Attributes", "@");
		cmsUserActions.get().doubleClickOn("LeftNav_DataPrivacyPolicy");	
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsBusinessFunction.get().verifyElementContainsText("CodeOfConduct_Attributes", ",");
		cmsUserActions.get().clickOnElementUsingImage("EditCMS.JPG");
		cmsUserActions.get().clearText("DataPrivacyPolicy_NameField");
		cmsUserActions.get().enterText("DataPrivacyPolicy_NameField", "DataPrivacyPolicy_Name");	
		cmsUserActions.get().clickOn("DataPrivacyPolicy_TemplateArrow");
		cmsUserActions.get().clickOn("DataPrivacyPolicy_Template");
		cmsUserActions.get().clearText("DataPrivacyPolicy_TitleField");
		cmsUserActions.get().enterText("DataPrivacyPolicy_TitleField", "DataPrivacyPolicy_Name");
		cmsUserActions.get().enterText("DataPrivacyPolicy_SubHeadingField", "DataPrivacyPolicy_Name");
		cmsUserActions.get().clickOn("DataPrivacyPolicy_HeroImageCrossButton");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsBusinessFunction.get().advanceSearchWithoutSubAssertType("AdvancedSearchAssetType_AvayaMedia", "qa_auto_test_InvestorsImage");
		cmsBusinessFunction.get().dragAndDrop("CodeOfConduct_ImageSource","DataPrivacyPolicy_ImageDestination",100);
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");		
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");
		cmsVerify.get().isElementDisplayed("AssetContentHeader");
		}
	
	/**
	  Author Name                       : Sindhuja P
	  Date of Preparation               : 26-08-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify if the user is able to edit RASBrandingCampaignStory Asset of type Avaya Content
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	 * @throws AWTException 
	  **/
	
	@Test(description="Verify if the user is able to edit RASBrandingCampaignStory Asset of type Avaya Content",groups="CMS")
	public void testCMSBrandingCampaignStoryEdit() throws InterruptedException
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsBusinessFunction.get().advanceSearchWithoutSubAssertType("AdvancedSearchAssetType_AvayaContent", "RASBrandingCampaignStory");
		//cmsBusinessFunction.get().searchAsset("RASBrandingCampaignStory");
		cmsUserActions.get().doubleClickOn("BrandingCampaignStory_Scotts");
		Thread.sleep(8000);
		cmsUserActions.get().clickOnElementUsingImage("EditCMS.JPG");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsBusinessFunction.get().ckEditor("BrandingCampaignStory_Description", "BrandCampaignStory_MetaDescription", "BrandingCampaignStory_DescriptionFrame");
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().clearText("BrandingCampaignStory_MetaPageTitle");
		cmsUserActions.get().enterText("BrandingCampaignStory_MetaPageTitle", "BrandCampaignStory_MetaPageTitle");
		cmsUserActions.get().clearText("BrandingCampaignStory_MetaDescription");
		cmsUserActions.get().enterText("BrandingCampaignStory_MetaDescription", "BrandCampaignStory_MetaDescription");
		cmsUserActions.get().clearText("BrandingCampaignStory_Keywords");
		cmsUserActions.get().enterText("BrandingCampaignStory_Keywords", "BrandCampaignStory_Keywords");
		cmsUserActions.get().clearText("BrandingCampaignStory_CustomerPageTitle");
		cmsUserActions.get().enterText("BrandingCampaignStory_CustomerPageTitle", "BrandCampaignStory_CustomerPageTitle");
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");
		cmsVerify.get().isElementDisplayed("AssetContentHeader");
	}
	
	/**
	  Author Name                       : Sindhuja P
	  Date of Preparation               : 26-08-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify the creation of Resource Technical Document asset
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	 * @throws AWTException 
	  **/
	
	@Test(description="Verify the creation of Resource Technical Document asset",groups="CMS")
	public void testCreationOfNewResourceTechnicalDocumentAsset() throws InterruptedException
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().hoverOn("Content");
		cmsUserActions.get().clickOn("New");
		cmsUserActions.get().clickOn("NewAvayaArticles");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsBusinessFunction.get().verifyElementContainsText("NewArticles_Attributes", ",");
		cmsUserActions.get().clickOn("NewMedia_ParentDefinitionArrow");
		cmsUserActions.get().clickOn("RASTechnicalDocuments");
		cmsBusinessFunction.get().verifyElementContainsText("TechnicalDocument_Attributes", ",");
		cmsUserActions.get().enterText("TechnicalDocument_Name", "TechnicalDocumentFieldName");
		cmsUserActions.get().clickOn("TechnicalDocumentTemplate_Arrow");
		cmsUserActions.get().clickOn("TechnicalDocument_SelectTemplate");
		cmsUserActions.get().enterText("TechnicalDocument_TechnicalSpecificationTitle", "TechnicalDocumentFieldName");
		cmsUserActions.get().clickOn("TechnicalDocumentSpecification_Arrow");
		cmsUserActions.get().clickOn("TechnicalDocument_SelectSpecification");
		cmsBusinessFunction.get().ckEditor("Technical_Specifications", "Technical_SpecificationsDescription","Services_CKEditorFrame");
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().clickOn("MetadataTab");
		cmsUserActions.get().clickOn("DropDown");
		cmsUserActions.get().clickOn("DropDown_en_US");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");
		cmsVerify.get().verifyAssetSaved();
		cmsUserActions.get().clickOnElementUsingImage("ApproveCMS.JPG");
		cmsUserActions.get().clickOn("stagingDelivery");
		cmsUserActions.get().clickOn("ApproveWithDependenciesButton");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().clickOn("CMSLogout");
//		cmsBusinessFunction.get().Publish("qa_auto_test_The Avaya Collaborative Cloud");
	}
	
	/**
	  Author Name                       : Sindhuja P
	  Date of Preparation               : 27-08-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 :Verify whether the user is able to create a new  Promotions Content page
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	 * @throws AWTException 
	  **/
	
	@Test(description="Verify whether the user is able to create a new  Promotions Content page",groups="CMS")
	public void testCMSPromotionsProgramsCreatingPromotionsContentpage() throws InterruptedException, AWTException 
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().hoverOn("Content");
		cmsUserActions.get().clickOn("New");
		cmsUserActions.get().clickOn("NewAvayaContent");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsBusinessFunction.get().verifyElementContainsText("AvayaContent_Attributes", ",");
		cmsVerify.get().isElementDisplayed("NewAvayaContent_ContinueButton");
		cmsUserActions.get().clickOn("AvayaContentParentDefinition_Arrow");
		cmsUserActions.get().clickOn("RASPromotionsContent");
		cmsBusinessFunction.get().verifyElementContainsText("RASPromotionsContent_Attributes", ",");
		cmsUserActions.get().clickOn("TechnicalDocumentTemplate_Arrow");
		cmsUserActions.get().clickOn("RASPromotionsContent_SelectTemplate");
		cmsUserActions.get().enterText("RASPromotionsContent_NameField", "RASPromotionsContent_Name");
		cmsUserActions.get().enterText("RASPromotionsContent_TitleField", "RASPromotionsContent_Name");
		cmsUserActions.get().enterText("RASPromotionsContent_BreadcrumbTitleField", "RASPromotionsContent_Name");
		cmsBusinessFunction.get().advanceSearch("AdvancedSearchAssetType_AvayaMedia", "AdvancedSearchAssetSubType_RASImage","");
		cmsBusinessFunction.get().dragAndDrop("RASPromotionsContent_ImageSource","RASPromotionsContent_ImageDestination",100);
		cmsUserActions.get().enterText("RASPromotionsContent_DescriptionTitleField", "RASPromotionsContent_Name");
		cmsBusinessFunction.get().ckEditor("RASPromotionsContent_DescriptionField", "RASPromotionsContent_Name","RASPromotionsContent_DescriptionFrame");
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().enterText("RASPromotionsContent_MetaPageTitleField", "RASPromotionsContent_Name");
		cmsBusinessFunction.get().advanceSearch("AdvancedSearchAssetType_AvayaContent", "AdvancedSearchAssetSubType_RASUrl","");
		cmsBusinessFunction.get().dragAndDrop("RASPromotionsContent_FindAPartnerSource","RASPromotionsContent_FindAPartnerDestination",100);
		cmsUserActions.get().clickOn("MetadataTab");
		cmsUserActions.get().clickOn("DropDown");
		cmsUserActions.get().clickOn("DropDown_en_US");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");
		cmsVerify.get().verifyAssetSaved();
	}
	
	@Test(description="Verify if the user is able to create Diversity page in CMS",groups="CMS")
	public void testAboutAvayaCompanyOverviewOurCultureDiversityCMS() throws InterruptedException, AWTException
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		cmsUserActions.get().switchToFrame("LeftNavFrame");
		cmsUserActions.get().clickOn("LeftNav_Default");
		cmsUserActions.get().clickOn("LeftNav_Default_Home");
		cmsBusinessFunction.get().verifyElementContainsText("Home_Attributes", ",");
		cmsUserActions.get().clickOn("LeftNav_Default_Home_About");
		cmsUserActions.get().doubleClickOn("LeftNavAbout_CompanyOverview");	
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().clickOn("CompanyOverview_Category");
		cmsBusinessFunction.get().closePreviousTab();
		cmsUserActions.get().clickOn("CompanyOverview_OurCulture");
		cmsBusinessFunction.get().closePreviousTab();
		cmsUserActions.get().clickOn("OurCulture_Diversity");
		cmsBusinessFunction.get().closePreviousTab();
		cmsBusinessFunction.get().verifyElementContainsText("Diversity_Attributes", ",");
		cmsUserActions.get().clickOnElementUsingImage("EditCMS.JPG");
		cmsUserActions.get().clearText("Diversity_NameField");
		cmsUserActions.get().enterText("Diversity_NameField", "Diversity_Name");
		cmsUserActions.get().clearText("Diversity_TitleField");
		cmsUserActions.get().enterText("Diversity_TitleField", "Diversity_Name");
		cmsUserActions.get().clickOn("DiversityTemplate_Arrow");
		cmsUserActions.get().clickOn("Diversity_SelectTemplate");
		cmsUserActions.get().clearText("Diversity_DescriptionTitleField");
		cmsUserActions.get().enterText("Diversity_DescriptionTitleField", "Diversity_DescriptionTitle");
		cmsUserActions.get().clearText("Diversity_MetaPageTitleField");
		cmsUserActions.get().enterText("Diversity_MetaPageTitleField", "Diversity_MetaPageTitle");
		cmsUserActions.get().clearText("Diversity_MetaDescriptionField");
		cmsUserActions.get().enterText("Diversity_MetaDescriptionField", "Diversity_MetaDescription");
		cmsUserActions.get().clearText("Diversity_MetaKeywordsField");
		cmsUserActions.get().enterText("Diversity_MetaKeywordsField", "Diversity_MetaKeywords");
//		cmsBusinessFunction.get().searchAsset("DiversityImage");
		cmsBusinessFunction.get().advanceSearch("AdvancedSearchAssetType_AvayaMedia", "AdvancedSearchAssetSubType_RASImage","DiversityImage");
//		cmsUserActions.get().clickOn("DiversityImage_CrossButton");
		cmsBusinessFunction.get().dragAndDrop("Diversity_ImageSource","Diversity_ImageDestination",100);
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");
		cmsVerify.get().verifyAssetSaved();
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsVerify.get().verifyText("AssetTitle", "Diversity_Name");
	}
	
	/**
	  Author Name                       : Sindhuja P
	  Date of Preparation               : 28-08-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify the creation of Associated Core Component asset
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	 * @throws AWTException 
	  **/
	
	@Test(description="Verify the creation of Associated Core Component asset",groups="CMS")
	public void testCMSCreationOfAssociatedCoreComponentAsset() throws InterruptedException, AWTException
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsBusinessFunction.get().closeOpenTabs();
		cmsUserActions.get().hoverOn("Content");
		cmsUserActions.get().clickOn("New");
		cmsUserActions.get().clickOn("NewAvayaArticles");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsBusinessFunction.get().verifyElementContainsText("NewArticles_Attributes", ",");
		cmsUserActions.get().clickOn("AvayaArticlesParentDefinition_Arrow");
		cmsUserActions.get().clickOn("RASCoreComponents");
		cmsBusinessFunction.get().verifyElementContainsText("CoreComponent_Attributes", ",");
		cmsUserActions.get().enterText("CoreComponent_NameField", "CoreComponent_Name");
		cmsUserActions.get().clickOn("CoreComponent_TypeArrow");
		cmsUserActions.get().clickOn("CoreComponent_Type");
		cmsUserActions.get().enterText("CoreComponent_TitleField", "CoreComponent_Name");
		cmsUserActions.get().clickOn("Article_DateField_Calender");
		cmsUserActions.get().clickOn("Article_DateField_Date");
		cmsBusinessFunction.get().ckEditor("CoreComponent_DescriptionField", "CoreComponent_Description","CoreComponent_DescriptionFrame");
		cmsBusinessFunction.get().advanceSearch("AdvancedSearchAssetType_AvayaMedia", "AdvancedSearchAssetSubType_RASImage","");
		cmsBusinessFunction.get().dragAndDrop("CoreComponent_ImageSource","CoreComponent_ImageDestination",100);
		cmsBusinessFunction.get().advanceSearch("AdvancedSearchAssetType_AvayaMedia", "AdvancedSearchAssetSubType_RASVideo","");
		cmsBusinessFunction.get().dragAndDrop("CoreComponent_VideoSource","CoreComponent_VideoDestination",100);
		cmsBusinessFunction.get().advanceSearch("AdvancedSearchAssetType_AvayaContent", "AdvancedSearchAssetSubType_RASUrl","");
		cmsBusinessFunction.get().dragAndDrop("CoreComponent_UrlSource","CoreComponent_UrlDestination",100);	
		cmsUserActions.get().clickOn("MetadataTab");
		cmsUserActions.get().clickOn("DropDown");
		cmsUserActions.get().clickOn("DropDown_en_US");
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");
		cmsVerify.get().verifyAssetSaved();
		cmsUserActions.get().clickOnElementUsingImage("ApproveCMS.JPG");
		cmsUserActions.get().clickOn("stagingDelivery");
		cmsUserActions.get().clickOn("ApproveWithDependenciesButton");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().clickOn("CMSLogout");
//		cmsBusinessFunction.get().Publish("qa_auto_test_Virtual Services Platform 9000 Series");		
	}
	
	/**
	  Author Name                       : Sindhuja P
	  Date of Preparation               : 28-08-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify if the changes made are saved successfully to NewsRelease page
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	 * @throws AWTException 
	  **/
	
	@Test(description="Verify if the changes made are saved successfully to NewsRelease page",groups="CMS")
	public void testNewsReleaseCMSSaveFillAllAttributes() throws InterruptedException, AWTException 
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().hoverOn("Content");
		cmsUserActions.get().clickOn("New");
		cmsUserActions.get().clickOn("NewAvayaContent");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsBusinessFunction.get().verifyElementContainsText("AvayaContent_Attributes", ",");
		cmsVerify.get().isElementDisplayed("NewAvayaContent_ContinueButton");
		cmsUserActions.get().enterText("RASNewsRoom_NameField", "RASNewsRoom_Name");
		cmsUserActions.get().clickOn("AvayaContentParentDefinition_Arrow");
		cmsUserActions.get().clickOn("RASNewsRoom");
		cmsUserActions.get().clickOn("RASNewsRoom_TemplateArrow");
		cmsUserActions.get().clickOn("RASNewsRoom_SelectTemplate");
		cmsUserActions.get().clickOn("RASNewsRoom_ContentTypeArrow");
		cmsUserActions.get().clickOn("RASNewsRoom_ContentType");
		cmsUserActions.get().enterText("RASNewsRoom_HeadlineField", "RASNewsRoom_Headline");
		cmsUserActions.get().enterText("RASNewsRoom_SubHeadlineField", "RASNewsRoom_SubHeadline");
		cmsUserActions.get().enterText("RASNewsRoom_PRCategoryField", "RASNewsRoom_PRCategory");
		cmsUserActions.get().enterText("RASNewsRoom_GeographyField", "RASNewsRoom_Geography");
		cmsBusinessFunction.get().advanceSearch("AdvancedSearchAssetType_AvayaMasterData", "AdvancedSearchAssetSubType_RASProductCategory","");		
		cmsBusinessFunction.get().dragAndDrop("RASNewsRoom_CategorySource","RASNewsRoom_CategoryDestination",100);
		cmsBusinessFunction.get().ckEditor("RASNewsRoom_BodyField", "RASNewsRoom_Body","RASNewsRoom_BodyFrame");
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().enterText("RASNewsRoom_AbstractField", "RASNewsRoom_Abstract");
		cmsUserActions.get().enterText("RASNewsRoom_KeywordsField", "RASNewsRoom_Keywords");
		cmsElementFactory.get().dynamicWait("RASNewsRoom_Industry", 10);
		cmsBusinessFunction.get().selectFromLeftListBox("RASNewsRoom_Industry", "RASNewsRoom_IndustryList");
		cmsElementFactory.get().dynamicWait("RightButtonToTransfer", 10);
		cmsBusinessFunction.get().transferRight("RightButtonToTransfer");
		cmsUserActions.get().enterText("RASNewsRoom_MetaDescriptionField", "RASNewsRoom_MetaInfo");
		cmsUserActions.get().enterText("RASNewsRoom_MetaKeywordsField", "RASNewsRoom_MetaInfo");
		cmsUserActions.get().enterText("RASNewsRoom_ContactInformationField", "RASNewsRoom_ContactInformation");
		cmsUserActions.get().enterText("RASNewsRoom_MoreInformationField", "RASNewsRoom_MoreInformation");
		cmsUserActions.get().enterText("RASNewsRoom_MetaPageTitleField", "RASNewsRoom_MetaInfo");
		cmsUserActions.get().clickOn("RASNewsRoom_ExperiationDateArrow");
		cmsUserActions.get().clickOn("RASNewsRoom_ExperiationDate");	
		cmsUserActions.get().clickOn("MetadataTab");
		cmsUserActions.get().clickOn("DropDown");
		cmsUserActions.get().clickOn("DropDown_en_US");
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");		
		cmsVerify.get().verifyAssetSaved();
		
	}
	
	/**
	  Author Name                       : Sindhuja P
	  Date of Preparation               : 01-09-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify if the changes made are saved successfully to Newsroom page
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	 * @throws AWTException 
	  **/
	
	@Test(description="Verify if the changes made are saved successfully to Newsroom page",groups="CMS")
	public void testNewsroomCMSSaveFillAllAttributes() throws InterruptedException, AWTException 
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().hoverOn("Content");
		cmsUserActions.get().clickOn("New");
		cmsUserActions.get().clickOn("NewAvayaContent");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsBusinessFunction.get().verifyElementContainsText("AvayaContent_Attributes", ",");
		cmsVerify.get().isElementDisplayed("NewAvayaContent_ContinueButton");
		cmsUserActions.get().enterText("RASNewsRoom_NameField", "RASNewsRoomRelease_Name");
		cmsUserActions.get().clickOn("AvayaContentParentDefinition_Arrow");
		cmsUserActions.get().clickOn("RASNewsRoom");
		cmsUserActions.get().clickOn("RASNewsRoom_TemplateArrow");
		cmsUserActions.get().clickOn("RASNewsRoomRelease_SelectTemplate");
		cmsUserActions.get().enterText("RASNewsRoom_HeadlineField", "RASNewsRoom_Headline");
		cmsUserActions.get().enterText("RASNewsRoom_SubHeadlineField", "RASNewsRoom_SubHeadline");
		cmsUserActions.get().clickOn("RASNewsRoom_ContentTypeArrow");
		cmsUserActions.get().clickOn("RASNewsRoomRelease_ContentType");		
		cmsUserActions.get().clickOn("RASNewsRoom_ReleaseDateArrow");
		cmsUserActions.get().clickOn("RASNewsRoom_ReleaseDateSelect");
		cmsBusinessFunction.get().advanceSearch("AdvancedSearchAssetType_AvayaMasterData", "AdvancedSearchAssetSubType_RASProductCategory","");		
		cmsBusinessFunction.get().dragAndDrop("RASNewsRoom_CategorySource","RASNewsRoom_CategoryDestination",100);
		cmsUserActions.get().enterText("RASNewsRoom_PRCategoryField", "RASNewsRoom_PRCategory");
		cmsUserActions.get().enterText("RASNewsRoom_GeographyField", "RASNewsRoom_Geography");
		cmsBusinessFunction.get().ckEditor("RASNewsRoom_BodyField", "RASNewsRoom_Body","RASNewsRoom_BodyFrame");
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().enterText("RASNewsRoom_AbstractField", "RASNewsRoom_Abstract");
		cmsUserActions.get().enterText("RASNewsRoom_KeywordsField", "RASNewsRoom_Keywords");
		cmsUserActions.get().enterText("RASNewsRoom_MetaDescriptionField", "RASNewsRoom_MetaInfo");
		cmsUserActions.get().enterText("RASNewsRoom_MetaKeywordsField", "RASNewsRoom_MetaInfo");
		cmsUserActions.get().enterText("RASNewsRoom_ContactInformationField", "RASNewsRoom_ContactInformation");
		cmsUserActions.get().enterText("RASNewsRoom_MoreInformationField", "RASNewsRoom_MoreInformation");
		cmsUserActions.get().enterText("RASNewsRoom_MetaPageTitleField", "RASNewsRoom_MetaInfo");
		cmsUserActions.get().clickOn("RASNewsRoom_ExperiationDateArrow");
		cmsUserActions.get().clickOn("RASNewsRoom_ExperiationDate");		
		/*cmsBusinessFunction.get().advanceSearch("AdvancedSearchAssetType_AvayaContent", "AdvancedSearchAssetSubType_RASUrl","");		
		cmsBusinessFunction.get().dragAndDrop("RASNewsRoom_ContactsSource","RASNewsRoom_ContactsDestination",100);
		cmsBusinessFunction.get().advanceSearch("AdvancedSearchAssetType_AvayaMasterData", "AdvancedSearchAssetSubType_NewsRoomContact","");		
		cmsBusinessFunction.get().dragAndDrop("RASNewsRoom_NewsRoomContactSource","RASNewsRoom_NewsRoomContactDestination",100);
		cmsElementFactory.get().dynamicWait("RASNewsRoom_Industry", 10);
		cmsBusinessFunction.get().selectFromLeftListBox("RASNewsRoom_Industry", "RASNewsRoom_IndustryList");
		cmsElementFactory.get().dynamicWait("RightButtonToTransfer", 10);
		cmsBusinessFunction.get().transferRight("RightButtonToTransfer");*/
		cmsUserActions.get().clickOn("MetadataTab");
		cmsUserActions.get().clickOn("DropDown");
		cmsUserActions.get().clickOn("DropDown_en_US");
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");		
		cmsVerify.get().verifyAssetSaved();
		
	}
	
	/**
	  Author Name                       : Sindhuja P
	  Date of Preparation               : 01-09-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify if a product is enabled for Segmentation
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	 * @throws AWTException 
	  **/
	
	@Test(description="Verify if a product is enabled for Segmentation",groups="CMS")
	public void testHPSegmentationCMSEnablingProductForSegmentation() throws InterruptedException, AWTException 
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		cmsUserActions.get().clickOnElementUsingImage("Contributor.JPG");
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsBusinessFunction.get().closeOpenTabs();
		cmsBusinessFunction.get().advanceSearch("AdvancedSearchAssetType_AvayaContent", "AdvancedSearchAssetSubType_RASProducts", "qa_auto_test_Internet Data Phones ");
	//	cmsBusinessFunction.get().searchAsset("qa_auto_test_TestProduct");
		cmsUserActions.get().clickOn("undock");
		cmsUserActions.get().doubleClickOn("Search_RASProduct");
		cmsUserActions.get().clickOnElementUsingImage("EditCMS.JPG");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("BrandingCampaignStory_Frame");
		cmsElementFactory.get().dynamicWait("RASProduct_BusinessSize", 10);
		//cmsBusinessFunction.get().selectFromLeftListBox("RASProduct_BusinessSize", "RASProduct_BusinessSizeSelect");
		cmsElementFactory.get().dynamicWait("RightButtonToTransfer", 10);
		cmsBusinessFunction.get().transferRight("RightButtonToTransfer");
		cmsUserActions.get().clickOn("RASProduct_SegmentationArrow");
		cmsUserActions.get().clickOn("RASProduct_SelectSegmentation");
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");
		cmsVerify.get().verifyAssetSaved();
	}
	
	/**
	  Author Name                       : Sindhuja P
	  Date of Preparation               : 02-09-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify the creation of new perspective article
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	 * @throws AWTException 
	  **/
	
	@Test(description="Verify the creation of new perspective article",groups="CMS")
	public void testPerspectiveArticleCreation() throws InterruptedException, AWTException
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		cmsUserActions.get().clickOnElementUsingImage("Contributor.JPG");
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsBusinessFunction.get().closeOpenTabs();
		cmsUserActions.get().hoverOn("Content");
		cmsUserActions.get().clickOn("New");
		cmsUserActions.get().clickOn("NewAvayaArticles");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsBusinessFunction.get().verifyElementContainsText("NewArticles_Attributes", ",");
		cmsUserActions.get().clickOn("AvayaArticlesParentDefinition_Arrow");
		cmsUserActions.get().clickOn("RASPerspectiveArticles");
		cmsUserActions.get().enterText("PerspectiveArticle_NameField","PerspectiveArticle_Name");
		cmsUserActions.get().clickOn("PerspectiveArticle_TemplateArrow");
		cmsUserActions.get().clickOn("PerspectiveArticle_SelectTemplate");
		cmsUserActions.get().enterText("PerspectiveArticle_TitleField", "PerspectiveArticle_Title");
		cmsBusinessFunction.get().advanceSearch("AdvancedSearchAssetType_AvayaMedia", "AdvancedSearchAssetSubType_RASImage", "qa_auto_test_TestImage");
		cmsBusinessFunction.get().dragAndDrop("PerspectiveArticle_ImageSource","PerspectiveArticle_ArticleImageDestination",100);
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().clickOn("SearchField_CrossButton");
		//cmsBusinessFunction.get().searchAsset("qa_auto_test_TestVideo");
		cmsBusinessFunction.get().advanceSearch("AdvancedSearchAssetType_AvayaMedia", "AdvancedSearchSubType_RASVideo", "qa_auto_test_Kaltura Video");
		cmsBusinessFunction.get().dragAndDrop("PerspectiveArticle_VideoSource","PerspectiveArticle_ArticleVideoDestination",100);
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().clickOn("SearchField_CrossButton");
		cmsBusinessFunction.get().advanceSearch("AdvancedSearchAssetType_AvayaMedia", "AdvancedSearchAssetSubType_RASImage", "qa_auto_test_TestImage");
		cmsBusinessFunction.get().dragAndDrop("PerspectiveArticle_ImageSource","PerspectiveArticle_BaseBallImageDestination",100);
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().clickOn("SearchField_CrossButton");
		cmsBusinessFunction.get().advanceSearch("AdvancedSearchAssetType_AvayaMedia", "AdvancedSearchSubType_RASVideo", "qa_auto_test_Kaltura Video");
		cmsBusinessFunction.get().dragAndDrop("PerspectiveArticle_VideoSource","PerspectiveArticle_BaseBallVideoDestination",100);
		cmsElementFactory.get().dynamicWait("PerspectiveArticle_Category", 10);
		cmsBusinessFunction.get().selectFromLeftListBox("PerspectiveArticle_Category", "PerspectiveArticle_CategorySelect");
		cmsElementFactory.get().dynamicWait("RightButtonToTransfer", 10);
		cmsBusinessFunction.get().transferRight("RightButtonToTransfer");
		cmsElementFactory.get().dynamicWait("PerspectiveArticle_Topics", 10);
		cmsBusinessFunction.get().selectFromLeftListBox("PerspectiveArticle_Topics", "PerspectiveArticle_TopicsSelect");
		cmsElementFactory.get().dynamicWait("RightButtonToTransfer_SecondList", 10);
		cmsBusinessFunction.get().transferRight("RightButtonToTransfer_SecondList");
		cmsUserActions.get().enterText("PerspectiveArticle_SEOMetaPageTitleField", "PerspectiveArticle_Title");
		cmsUserActions.get().enterText("PerspectiveArticle_AuthorField", "PerspectiveArticle_Author");
		cmsUserActions.get().clickOn("PerspectiveArticle_DateArrow");
		cmsUserActions.get().clickOn("PerspectiveArticle_SelectDate");
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");
		cmsUserActions.get().clickOn("MetadataTab");
		cmsUserActions.get().clickOn("DropDown");
		cmsUserActions.get().clickOn("DropDown_en_US");
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");
		cmsVerify.get().verifyAssetSaved();
		cmsUserActions.get().clickOnElementUsingImage("ApproveCMS.JPG");
		cmsUserActions.get().clickOn("stagingDelivery");
		cmsUserActions.get().clickOn("ApproveWithDependenciesButton");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().clickOn("CMSLogout");
		//cmsBusinessFunction.get().Publish("qa_auto_test_Apple buys Viber");
	}
	
	/**
	  Author Name                       : Sindhuja P
	  Date of Preparation               : 02-09-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify whether the edited product in CMS application is displayed correctly on UI.
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	 * @throws AWTException 
	  **/
	
	@Test(description="Verify whether the edited product in CMS application is displayed correctly on UI.",groups="CMS")
	public void testCMSProductAssetEdit() throws InterruptedException, AWTException
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		cmsUserActions.get().clickOnElementUsingImage("Contributor.JPG");
		cmsUserActions.get().switchToFrame("LeftNavFrame");
		cmsUserActions.get().clickOn("LeftNav_Default");
		cmsUserActions.get().clickOn("LeftNav_Default_Home");
		cmsUserActions.get().clickOn("LeftNav_Default_Home_Products_Link");
		cmsUserActions.get().doubleClickOn("LeftNav_Cloud");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().clickOn("Category_Cloud");
		cmsBusinessFunction.get().closePreviousTab();
		cmsUserActions.get().clickOn("AssociatedCategories_PublicCloud");
		cmsBusinessFunction.get().closePreviousTab();
		cmsUserActions.get().clickOn("PublicCloud_MegaMenuItems");
		cmsBusinessFunction.get().closePreviousTab();
		cmsUserActions.get().clickOnElementUsingImage("EditCMS.JPG");
		cmsUserActions.get().clearText("ProductEdit_NameField");
		cmsUserActions.get().enterText("ProductEdit_NameField", "ProductEdit_Name");
		cmsUserActions.get().clearText("ProductEdit_ProductNameField");
		cmsUserActions.get().enterText("ProductEdit_ProductNameField", "ProductEdit_Name");
		//cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");		
	}
	/**
	  Author Name                       : Sindhuja P
	  Date of Preparation               :
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify whether the edited Solution in CMS application is displayed correctly on UI.
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	 * @throws AWTException 
	  **/

	@Test(description="Verify whether the edited Solution in CMS application is displayed correctly on UI.",groups="CMS")
	public void testCMSSolutionAssetEdit() throws InterruptedException, AWTException
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		Thread.sleep(8000);
		cmsBusinessFunction.get().advanceSearchWithLocale("AdvancedSearchAssetType_AvayaContent","RASSolutions","DropDown_en_US", "Contact Center for Midmarket");
		cmsUserActions.get().doubleClickOn("Contact Center Optimization");
		Thread.sleep(8000);
		cmsUserActions.get().clickOnElementUsingImage("EditCMS.JPG");		
		cmsBusinessFunction.get().advanceSearchWithLocale("AdvancedSearchAssetType_AvayaMasterData","RASSolutionCategory_AdavanceSearchSubAssetType","DropDown_en_US", "Industry Vertical");
		cmsBusinessFunction.get().dragAndDrop("Industry Vertical", "ContactCenterforMidmarket_Category_Destination", 100);
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");
		cmsVerify.get().verifyAssetSaved();	
		Thread.sleep(8000);
		cmsUserActions.get().clickOnElementUsingImage("ApproveCMS.JPG");		
		cmsUserActions.get().clickOn("stagingDelivery");
		cmsUserActions.get().clickOn("ApproveWithDependenciesButton");
		Thread.sleep(8000);
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().clickOn("CMSLogout");	
		//cmsBusinessFunction.get().Publish("Contact Center for Midmarket");		
		
	}
	
	/**
	  Author Name                       : Sindhuja P

	  Date of Preparation               :
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify the cost basis analysis page edited in the CMS application are displayed in the Investors events UI page.
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	 * @throws AWTException 
	  **/
	
	@Test(description="Verify the cost basis analysis page edited in the CMS application are displayed in the Investors events UI page.",groups="CMS")
	public void testCMSEditCostBasisAnalysisInvestors() throws InterruptedException, AWTException
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getInvestorsUserName(),appConfig.getInvestorsPassword());
		cmsUserActions.get().switchToFrame("LeftNavFrame");
		cmsUserActions.get().clickOn("LeftNav_Inv_Default");
		cmsUserActions.get().clickOn("LeftNav_Investors");
		cmsBusinessFunction.get().verifyElementContainsText("Investors_Attributes", ",");
		cmsUserActions.get().clickOn("LeftNav_Investors_ShareHolderServices");
		cmsBusinessFunction.get().verifyElementContainsText("ShareHolderServices_Attributes", ",");
		cmsUserActions.get().doubleClickOn("LeftNav_CostBasisAnalysis");	
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().clickOnElementUsingImage("EditCMS.JPG");
		cmsUserActions.get().clearText("CostBasisAnalysis_NameField");
		cmsUserActions.get().enterText("CostBasisAnalysis_NameField", "CostBasisAnalysis_Name");	
		cmsUserActions.get().clickOn("CostBasisAnalysis_TemplateArrow");
		cmsUserActions.get().clickOn("CostBasisAnalysis_Template");
		cmsUserActions.get().clearText("CostBasisAnalysis_TitleField");
		cmsUserActions.get().enterText("CostBasisAnalysis_TitleField", "CostBasisAnalysis_Name");
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");
		cmsVerify.get().isElementDisplayed("AssetContentHeader");
		/*cmsUserActions.get().clickOn("MetadataTab");
		cmsUserActions.get().clickOn("DropDown");
		cmsUserActions.get().clickOn("DropDown_en_US");
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");
		cmsVerify.get().verifyAssetSaved();
		cmsUserActions.get().clickOnElementUsingImage("ApproveCMS.JPG");
		cmsUserActions.get().clickOn("stagingDelivery");
		cmsUserActions.get().clickOn("ApproveWithDependenciesButton");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().clickOn("CMSLogout");
		cmsBusinessFunction.get().Publish("Cost Basis Analysis");*/	
	}
	
	/**
	  Author Name                       : Sindhuja P
	  Date of Preparation               : 03-09-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify the creation of Associated Service Details asset
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	 * @throws AWTException 
	  **/
	
	@Test(description="Verify the creation of Associated Service Details asset",groups="CMS")
	public void testCMSCreationOfAssociatedServiceDetails() throws InterruptedException, AWTException
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsBusinessFunction.get().closeOpenTabs();
		cmsUserActions.get().hoverOn("Content");
		cmsUserActions.get().clickOn("New");
		cmsUserActions.get().clickOn("NewAvayaArticles");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsBusinessFunction.get().verifyElementContainsText("NewArticles_Attributes", ",");
		cmsUserActions.get().clickOn("AvayaArticlesParentDefinition_Arrow");
		cmsUserActions.get().clickOn("RASServiceDetails");
		cmsFactory.dynamicWait("RASServiceDetails_ServiceCategoryField", 15);
		cmsUserActions.get().enterText("RASServiceDetails_ServiceCategoryField", "RASServiceDetails_ServiceCategory");
		cmsUserActions.get().enterText("RASServiceDetails_NameField", "RASServiceDetails_Name");
		cmsBusinessFunction.get().ckEditor("RASServiceDetails_ServiceCategoryDescriptionField", "RASServiceDetails_ServiceCategoryDescription","RASServiceDetails_ServiceCategoryFrame");
		cmsBusinessFunction.get().advanceSearch("AdvancedSearchAssetType_AvayaMedia", "AdvancedSearchAssetSubType_RASImage","");
		cmsBusinessFunction.get().dragAndDrop("RASServiceDetails_ImageSource","RASServiceDetails_ImageDestination",100);
		cmsUserActions.get().clickOn("MetadataTab");
		cmsUserActions.get().clickOn("DropDown");
		cmsUserActions.get().clickOn("DropDown_en_US");
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");
		cmsVerify.get().verifyAssetSaved();
		cmsUserActions.get().clickOnElementUsingImage("ApproveCMS.JPG");
		cmsUserActions.get().clickOn("stagingDelivery");
		cmsUserActions.get().clickOn("ApproveWithDependenciesButton");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().clickOn("CMSLogout");
//		cmsBusinessFunction.get().Publish(" qa_auto_test_Choose the Right Service Delivery Path");		
	}
	
	/**
	  Author Name                       : Sindhuja P
	  Date of Preparation               : 03-09-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify the creatio of new region in the CMS application.
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	 * @throws AWTException 
	  **/
	
	@Test(description="Verify the creatio of new region in the CMS application.",groups="CMS")
	public void testCreationOfNewRegion() throws InterruptedException
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().hoverOn("Content");
		cmsUserActions.get().hoverOn("New");
		cmsUserActions.get().clickOn("New_AvayaCountry");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsBusinessFunction.get().verifyElementContainsText("NewAvayaCountry_Attributes", ",");
		cmsUserActions.get().enterText("RASRegion_NameField", "RASRegion_Name");
		cmsUserActions.get().clickOn("AvayaCountryParentDefinition_Arrow");
		cmsUserActions.get().clickOn("RASRegion");
		cmsElementFactory.get().dynamicWait("RASRegion_NameField", 5);
		cmsUserActions.get().clickOn("RASRegion_RegionNameAddButton");
		cmsUserActions.get().enterText("RASRegion_RegionNameField", "RASRegion_RegionName");
		cmsUserActions.get().clickOn("RASRegion_PageTitleAddButton");
		cmsUserActions.get().enterText("RASRegion_PageTitleField", "RASRegion_RegionName");
		cmsUserActions.get().clickOn("MetadataTab");
		cmsUserActions.get().clickOn("DropDown");
		cmsUserActions.get().clickOn("DropDown_en_US");
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");
		cmsVerify.get().verifyAssetSaved();
		cmsUserActions.get().clickOnElementUsingImage("ApproveCMS.JPG");
		cmsUserActions.get().clickOn("stagingDelivery");
		cmsUserActions.get().clickOn("ApproveWithDependenciesButton");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().clickOn("CMSLogout");
//		cmsBusinessFunction.get().Publish("qa_auto_test_AsiaPacific");			
	}
	
	/**
	  Author Name                       : Sindhuja P
	  Date of Preparation               : 04-09-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify the creation of Resource Article asset
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	 * @throws AWTException 
	  **/
	
	@Test(description="Verify the creation of Resource Article asset",groups="CMS")
	public void testCMSCreationOfResourceArticleAsset() throws InterruptedException, AWTException
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin("username","password");
		cmsUserActions.get().clickOnElementUsingImage("Contributor.JPG");
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsBusinessFunction.get().closeOpenTabs();
		cmsUserActions.get().hoverOn("Content");
		cmsUserActions.get().clickOn("New");
		cmsUserActions.get().clickOn("NewAvayaArticles");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsBusinessFunction.get().verifyElementContainsText("NewArticles_Attributes", ",");
		cmsUserActions.get().clickOn("AvayaArticlesParentDefinition_Arrow");
		cmsUserActions.get().clickOn("RASResourceArticles");
		cmsUserActions.get().enterText("RASResourceArticles_NameField", "RASResourceArticles_Name");
		cmsUserActions.get().enterText("RASResourceArticles_TitleField", "RASResourceArticles_Name");
		cmsUserActions.get().enterText("RASResourceArticles_DescriptionField", "RASResourceArticles_Description");
		cmsUserActions.get().clickOn("RASResourceArticles_TypeArrow");
		cmsUserActions.get().clickOn("RASResourceArticles_TypeSelect");
		cmsUserActions.get().clickOn("RASResourceArticles_DateArrow");
		cmsUserActions.get().clickOn("RASResourceArticles_DateSelect");
		cmsBusinessFunction.get().advanceSearch("AdvancedSearchAssetType_AvayaMedia", "AdvancedSearchAssetSubType_RASImage", "qa_auto_test_TestImage");
		cmsBusinessFunction.get().dragAndDrop("RASResourceArticles_ImageSource","RASResourceArticles_ImageDestination",100);
//		cmsUserActions.get().switchToDefaultContent();
//		cmsUserActions.get().switchToFrame("Main_Frame");
//		cmsUserActions.get().clickOn("SearchField_CrossButton");
//		cmsBusinessFunction.get().searchAsset("qa_auto_test_TestVideo");
//		cmsBusinessFunction.get().dragAndDrop("RASResourceArticles_VideoSource","RASResourceArticles_VideoDestination",100);
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().clickOn("SearchField_CrossButton");
		cmsBusinessFunction.get().searchAsset("qa_auto_test_TestDocument");
		cmsBusinessFunction.get().dragAndDrop("RASResourceArticles_DocumentSource","RASResourceArticles_DocumentDestination",100);
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().clickOn("SearchField_CrossButton");
		cmsBusinessFunction.get().searchAsset("AvayaAuraPlatformReloaded");
		cmsBusinessFunction.get().dragAndDrop("RASResourceArticles_ProductSource","RASResourceArticles_ProductDestination",100);
		cmsUserActions.get().clickOn("RASResourceArticles_PremiumUrlArrow");
		cmsUserActions.get().clickOn("RASResourceArticles_PremiumUrlSelect");
		cmsUserActions.get().enterText("RASResourceArticles_PremiumUrlField", "RASResourceArticles_PremiumUrl");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().clickOn("SearchField_CrossButton");
		cmsBusinessFunction.get().searchAsset("qa_auto_test_TestPremiumContentPage");
		cmsBusinessFunction.get().dragAndDrop("RASResourceArticles_ThankYouPageSource","RASResourceArticles_ThankYouPageDestination",100);
		cmsUserActions.get().clickOn("MetadataTab");
		cmsUserActions.get().clickOn("DropDown");
		cmsUserActions.get().clickOn("DropDown_en_US");
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");
		cmsVerify.get().verifyAssetSaved();
		cmsUserActions.get().clickOnElementUsingImage("ApproveCMS.JPG");
		cmsUserActions.get().clickOn("stagingDelivery");
		cmsUserActions.get().clickOn("ApproveWithDependenciesButton");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().clickOn("CMSLogout");
		//cmsBusinessFunction.get().Publish("qa_auto_testResource_Virtual Services Platform 9000 Series");		
	}
	
	/**
	  Author Name                       : Sindhuja P
	  Date of Preparation               : 04-09-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify the creation of New Featured Customer story asset
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	 * @throws AWTException 
	  **/
	
	@Test(description=" Verify the creation of New Featured Customer story asset",groups="CMS")
	public void testCreationOfNewFeaturedCustomerStoryAsset() throws InterruptedException, AWTException
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		cmsUserActions.get().clickOnElementUsingImage("Contributor.JPG");
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsBusinessFunction.get().closeOpenTabs();
		cmsUserActions.get().hoverOn("Content");
		cmsUserActions.get().clickOn("New");
		cmsUserActions.get().clickOn("NewAvayaArticles");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsBusinessFunction.get().verifyElementContainsText("NewArticles_Attributes", ",");
		cmsUserActions.get().clickOn("AvayaArticlesParentDefinition_Arrow");
		cmsUserActions.get().clickOn("RASCustomerStory");
		//cmsBusinessFunction.get().verifyElementContainsText("RASCustomerStory_Attributes", ",");
		cmsUserActions.get().enterText("CustomerStoryName_Field", "CustomerStoryName_Name");
		cmsUserActions.get().enterText("CustomerStory_CustomerName_Field", "CustomerStory_CustomerName_Name");
		cmsUserActions.get().clickOn("CustomerStory_BusinessSize_Arrow");
		cmsUserActions.get().clickOn("CustomerStory_BusinessSize_Medium");
		cmsUserActions.get().clickOn("CustomerStory_Industry_Arrow");
		cmsUserActions.get().clickOn("CustomerStory_Industry_Other");
		cmsBusinessFunction.get().advanceSearch("AdvancedSearchAssetType_AvayaMasterData", "AdvancedSearchAssetSubType_RASProductCategory", "Networking");
		//cmsBusinessFunction.get().searchAsset("Networking");
		cmsBusinessFunction.get().dragAndDrop("CustomerStorySubCategory","CustomerStorySubCategoryDestination",50);
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().clickOn("SearchField_CrossButton");
		//cmsBusinessFunction.get().searchAsset("qa_auto_test_TestDocument");
		cmsBusinessFunction.get().advanceSearch("AdvancedSearchAssetType_AvayaArticle", "AdvancedSearchAssetSubType_RASDocument", "AvayaDoc");
		cmsBusinessFunction.get().dragAndDrop("CustomerSuccessStory_Source","CustomerSuccessStory_Destination",50);
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().clickOn("SearchField_CrossButton");
		cmsBusinessFunction.get().advanceSearch("AdvancedSearchAssetType_AvayaMedia", "AdvancedSearchAssetSubType_RASImage", "qa_auto_test_TestImage");
		//cmsBusinessFunction.get().searchAsset("qa_auto_test_TestImage");
		cmsBusinessFunction.get().dragAndDrop("CustomerSuccessImage_Source","CustomerSuccessImage_Destination",100);
//		cmsUserActions.get().switchToDefaultContent();
//		cmsUserActions.get().switchToFrame("Main_Frame");
//		cmsUserActions.get().clickOn("SearchField_CrossButton");
//		cmsBusinessFunction.get().searchAsset("qa_auto_test_TestVideo");
//		cmsBusinessFunction.get().dragAndDrop("CustomerSuccess_VideoSource","CustomerSuccess_VideoDestination",100);
		cmsUserActions.get().clickOn("CustomerSuccessDateArrow");
		cmsUserActions.get().clickOn("CustomerSuccessDate");
		cmsUserActions.get().enterText("CustomerSuccessStory_TitleField", "CustomerStory_CustomerName_Name");
		cmsUserActions.get().enterText("CustomerSuccessStoryDescription_Field", "CustomerSuccessStoryDescription");
		cmsUserActions.get().enterText("CaseStudyLink_Field", "CaseStudyLink");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().clickOn("SearchField_CrossButton");
		cmsBusinessFunction.get().advanceSearch("AdvancedSearchAssetType_AvayaContent","AdvancedSearchAssetSubType_RASUrl" , "qa_auto_test_Try It Now Url");
		//cmsBusinessFunction.get().searchAsset("url_test");
		cmsBusinessFunction.get().dragAndDrop("CustomerSuccessStoryPdfUrl_Source","CustomerSuccessStoryPdfUrl_Destination",100);
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().clickOn("SearchField_CrossButton");
		cmsUserActions.get().clickOn("MetadataTab");
		cmsUserActions.get().clickOn("LocaleDropdown");
		cmsUserActions.get().clickOn("DropDown_en_US");
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");
		cmsVerify.get().verifyAssetSaved();
		cmsUserActions.get().clickOnElementUsingImage("ApproveCMS.JPG");
		cmsUserActions.get().clickOn("stagingDelivery");
		cmsUserActions.get().clickOn("ApproveWithDependenciesButton");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().clickOn("CMSLogout");
	/*	cmsBusinessFunction.get().Publish("CustomerStoryName_Name");
		getDriver().get(appConfig.getAppUrl());
		cmsDynamicWait.get().cmsWaittillpageloads(30);
		cmsUserActions.get().clickOn("MegaMenu_Products");
		cmsDynamicWait.get().cmsWaittillpageloads(30);
		cmsUserActions.get().clickOn("Products_AvayaAuraPlatform");
		cmsDynamicWait.get().cmsWaittillpageloads(30);
		cmsUserActions.get().clickOn("CaseStudiesTab");
		cmsDynamicWait.get().cmsWaittillpageloads(30);
		cmsVerify.get().isElementDisplayed("HotelBellevueCaseStudy");*/
	}
	
	/**
	  Author Name                       : Sindhuja P
	  Date of Preparation               : 16-09-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify the changes made to attributes related to hero image or video in CMS are reflected on SEO Page
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	 * @throws AWTException 
	  **/
	
	@Test(description="Verify the changes made to attributes related to hero image or video in CMS are reflected ",groups="CMS")
	public void testSEOLandingPageHeroImageVideoCMS() throws InterruptedException, AWTException
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		cmsUserActions.get().clickOnElementUsingImage("Contributor.JPG");
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsBusinessFunction.get().advanceSearch("AdvancedSearchAssetType_AvayaContent", "AdvancedSearchAssetSubType_RASSEO", "qa_auto_test_TestAvayaSEO");
		cmsUserActions.get().doubleClickOn("Search_SEOAvaya");
		cmsBusinessFunction.get().closePreviousTab();
		cmsUserActions.get().clickOnElementUsingImage("EditCMS.JPG");
		cmsUserActions.get().clickOn("SEOAvaya_ImageCrossButton");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().clickOn("SearchField_CrossButton");
		cmsBusinessFunction.get().searchAsset("qa_auto_test_Networks Image");
		cmsBusinessFunction.get().dragAndDrop("SEOAvaya_ImageSource","SEOAvaya_ImageDestination",100);
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");	
		cmsVerify.get().verifyAssetSaved();
		
	}
	
	/**
	  Author Name                       : Sindhuja P
	  Date of Preparation               : 16-09-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify whether the changes are reflected in the UI.
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	 * @throws AWTException 
	  **/
	
	@Test(description="Verify whether the changes are reflected.",groups="CMS")
	public void testCMSPromotionsProgramsPublish() throws InterruptedException, AWTException
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		cmsUserActions.get().clickOnElementUsingImage("Contributor.JPG");
		cmsUserActions.get().switchToFrame("LeftNavFrame");
		cmsUserActions.get().clickOn("LeftNav_Unplaced");
		cmsUserActions.get().clickOn("LeftNav_Unplaced_PromotionsPrograms");
		cmsUserActions.get().doubleClickOn("LeftNav_AuthenticAvaya");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().clickOn("Category_AuthenticAvaya");
		cmsBusinessFunction.get().closePreviousTab();
		cmsUserActions.get().clickOnElementUsingImage("EditCMS.JPG");
		cmsUserActions.get().clearText("AuthenticAvaya_SubtitleField");
		cmsUserActions.get().enterText("AuthenticAvaya_SubtitleField", "AuthenticAvaya_Subtitle");
		/*cmsBusinessFunction.get().searchAsset("qa_auto_test_TestPromotionsContent");
		cmsBusinessFunction.get().dragAndDrop("AuthenticAvaya_LeftNavAssociationsSource","AuthenticAvaya_LeftNavAssociationsDestination",100);*/
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");
		cmsVerify.get().verifyAssetSaved();
		cmsUserActions.get().clickOnElementUsingImage("ApproveCMS.JPG");
		cmsUserActions.get().clickOn("stagingDelivery");
		cmsUserActions.get().clickOn("ApproveWithDependenciesButton");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().clickOn("CMSLogout");
		//cmsBusinessFunction.get().Publish("Authentic Avaya");		
	}
	
	/**
	  Author Name                       : Sindhuja P
	  Date of Preparation               : 18-09-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify the creation of Product Asset
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	 * @throws AWTException 
	  **/
	
	@Test(description="Verify the creation of Product Asset",groups="CMS")
	public void testCreationOfProductAsset() throws InterruptedException, AWTException
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		cmsUserActions.get().clickOnElementUsingImage("Contributor.JPG");
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().hoverOn("Content");
		cmsUserActions.get().clickOn("New");
		cmsUserActions.get().clickOn("NewAvayaContent");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().clickOn("AvayaContentParentDefinition_Arrow");
		cmsUserActions.get().clickOn("RASProducts");
		cmsUserActions.get().enterText("RASProducts_NameField", "RASProducts_Name");
		// Template not present in test environment.
//		cmsUserActions.get().clickOn("RASProducts_TemplateArrow");
//		cmsUserActions.get().clickOn("RASProducts_SelectTemplate");
		cmsUserActions.get().enterText("RASProducts_ProductNameField", "RASProducts_Name");
		//cmsBusinessFunction.get().searchAsset("Networking");
		cmsBusinessFunction.get().advanceSearch("AdvancedSearchAssetType_AvayaMasterData", "AdvancedSearchAssetSubType_RASProductCategory", "Networking");
		cmsBusinessFunction.get().dragAndDrop("RASProducts_CategorySource","RASProducts_CategoryDestination",100);
		cmsBusinessFunction.get().ckEditor("RASProducts_ProductSubheadField", "RASProducts_ProductSubhead","RASProducts_ProductSubheadFrame");
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().enterText("RASProducts_ProductHeaderField", "RASProducts_ProductHeader");
		cmsBusinessFunction.get().ckEditor("RASProducts_ProductOverviewContentField", "RASProducts_ProductOverviewContent","RASProducts_ProductOverviewContentFrame");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().clickOn("SearchField_CrossButton");
		cmsBusinessFunction.get().advanceSearch("AdvancedSearchAssetType_AvayaMedia", "AdvancedSearchAssetSubType_RASImage", "qa_auto_test_TestImage");
		cmsBusinessFunction.get().dragAndDrop("RASProducts_HeroImageSource","RASProducts_HeroImageDestination",100);
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().clickOn("SearchField_CrossButton");
		//cmsBusinessFunction.get().searchAsset("qa_auto_test_Test_URL");
		cmsBusinessFunction.get().advanceSearch("AdvancedSearchAssetType_AvayaContent","AdvancedSearchAssetSubType_RASUrl" , "qa_auto_test_Try It Now Url");
		cmsBusinessFunction.get().dragAndDrop("RASProducts_DemoUrlSource","RASProducts_DemoUrlDestination",100);
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().clickOn("SearchField_CrossButton");
		//cmsBusinessFunction.get().searchAsset("qa_auto_test_TestArticle");
		cmsBusinessFunction.get().advanceSearch("AdvancedSearchAssetType_AvayaArticle","AdvancedSearchAssetSubType_RASArticle" , "qa_auto_test_Avaya Aura - Taking the Next Steps");
		cmsBusinessFunction.get().dragAndDrop("RASProducts_AssociatedModulesSource","RASProducts_AssociatedModulesDestination",100);
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		//cmsBusinessFunction.get().searchAsset("qa_auto_test_TestProduct");
		cmsBusinessFunction.get().advanceSearch("AdvancedSearchAssetType_AvayaContent", "AdvancedSearchAssetSubType_RASProducts", "Avaya Aura Platform");
		cmsBusinessFunction.get().dragAndDrop("RASProducts_RelatedProductsSource","RASProducts_RelatedProductsDestination",100);	
		cmsUserActions.get().clickOn("RASProducts_RankingArrow");
		cmsUserActions.get().clickOn("RASProducts_SelectRanking");
		cmsUserActions.get().enterText("RASProducts_MetaPageTitleField", "RASProducts_MetaPageTitle");
		cmsUserActions.get().clickOn("MetadataTab");
		cmsUserActions.get().clickOn("DropDown");
		cmsUserActions.get().clickOn("LocaleDropdown");
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");
		cmsVerify.get().verifyAssetSaved();
		cmsUserActions.get().clickOnElementUsingImage("ApproveCMS.JPG");
		cmsUserActions.get().clickOn("stagingDelivery");
		cmsUserActions.get().clickOn("ApproveWithDependenciesButton");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().clickOn("CMSLogout");
		//cmsBusinessFunction.get().Publish("Networking");		
	}
	
	/**
	  Author Name                       : Sindhuja P
	  Date of Preparation               : 18-09-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify the updated content filters are displayed on the filters section
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	 * @throws AWTException 
	  **/
	
	@Test(description="Verify the updated content filters are displayed on the filters section",groups="CMS")
	public void testUpdationOfContentFilters() throws InterruptedException, AWTException
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		cmsUserActions.get().switchToFrame("Main_Frame");

		cmsBusinessFunction.get().advanceSearch("AdvancedSearchAssetType_AvayaMasterData", "AdvancedSearchAssetSubType_RASContentFilters","Content Filters");
		cmsUserActions.get().clickOn("Search_ContentFilters");
		Thread.sleep(15000);
		cmsUserActions.get().clickOnElementUsingImage("EditCMS.JPG");

		cmsBusinessFunction.get().advanceSearch("AdvancedSearchAssetType_AvayaMasterData", "AvayaCVL","Vertically Stacked Solution");
		cmsBusinessFunction.get().dragAndDrop("ContentFilters_BusinessNeedSource","ContentFilters_BusinessNeedDestination",100);	
		cmsUserActions.get().clickOn("MetadataTab");
		cmsUserActions.get().clickOn("DropDown");
		cmsUserActions.get().clickOn("DropDown_en_US");
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");
		cmsVerify.get().verifyAssetSaved();
		cmsUserActions.get().clickOnElementUsingImage("ApproveCMS.JPG");
		cmsUserActions.get().clickOn("stagingDelivery");
		cmsUserActions.get().clickOn("ApproveWithDependenciesButton");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().clickOn("CMSLogout");
//		cmsBusinessFunction.get().Publish("Content Filters");	
	}
	
	/**
	  Author Name                       : Sindhuja P
	  Date of Preparation               : 18-09-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify the updation of Quick Links in global footer
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	 * @throws AWTException 
	  **/
	
	@Test(description="Verify the updation of Quick Links in global footer",groups="CMS")
	public void testUpdationOfLinkInQuickLinks() throws InterruptedException, AWTException
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		cmsUserActions.get().clickOnElementUsingImage("Contributor.JPG");
		cmsUserActions.get().switchToFrame("Main_Frame");
		//cmsUserActions.get().enterText("SearchBox", "Quick");
		//cmsUserActions.get().clickOnElementUsingImage("Magnifier.JPG");
		//cmsUserActions.get().doubleClickOn("Search_QuickLinks");
		//cmsBusinessFunction.get().closePreviousTab();
		cmsBusinessFunction.get().advanceSearch("AdvancedSearchAssetType_AvayaMasterData", "AdvancedSearchSubType_RASQuickLinks", "Quick Links");
		cmsUserActions.get().clickOn("undock");
		cmsUserActions.get().clickOn("QuickLinks_enUS");
		cmsDynamicWait.get().cmsWaittillpageloads(30);
		cmsUserActions.get().clickOnElementUsingImage("EditCMS.JPG");
		//cmsUserActions.get().clickOn("QuickLinks_LinkUrlCrossButton");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		/*cmsUserActions.get().clickOn("SearchField_CrossButton");
		cmsBusinessFunction.get().searchAsset("qa_auto_test_Test_URL");*/
		cmsBusinessFunction.get().advanceSearch("AdvancedSearchAssetType_AvayaContent","AdvancedSearchAssetSubType_RASUrl" , "qa_auto_test_Try It Now Url");
		cmsBusinessFunction.get().dragAndDrop("QuickLinks_LinkUrlSource","QuickLinks_LinkUrlDestination",100);	
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");
		cmsVerify.get().verifyAssetSaved();
		cmsUserActions.get().clickOnElementUsingImage("ApproveCMS.JPG");
		cmsUserActions.get().clickOn("stagingDelivery");
		cmsUserActions.get().clickOn("ApproveWithDependenciesButton");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().clickOn("CMSLogout");
		//cmsBusinessFunction.get().Publish("Quick Links");		
	}
	
	/**
	  Author Name                       : Sindhuja P
	  Date of Preparation               : 19-09-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify  whether the  Perspectives Widgets asset in CMS is editable
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	 * @throws AWTException 
	  **/
	
	@Test(description="Verify  whether the  Perspectives Widgets asset in CMS is editable",groups="CMS")
	public void testPerspectivesLandingWidgetsEdit() throws InterruptedException, AWTException
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		cmsUserActions.get().clickOnElementUsingImage("Contributor.JPG");
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().enterText("SearchBox", "Search_PerspectiveWidgets");
		cmsUserActions.get().clickOnElementUsingImage("Magnifier.JPG");
		cmsUserActions.get().doubleClickOn("Search_PerspectiveWidgets");
		cmsBusinessFunction.get().closePreviousTab();
		cmsUserActions.get().clickOnElementUsingImage("EditCMS.JPG");
		cmsUserActions.get().clearText("PerspectiveWidgets_YoutubeUrlField");
		cmsUserActions.get().enterText("PerspectiveWidgets_YoutubeUrlField", "PerspectiveWidgets_YoutubeUrl");
		cmsUserActions.get().clearText("PerspectiveWidgets_SlideShareUrlField");
		cmsUserActions.get().enterText("PerspectiveWidgets_SlideShareUrlField", "PerspectiveWidgets_SlideShareUrl");
		cmsUserActions.get().clickOn("PerspectiveWidgets_MagazineCrossButton");
		cmsBusinessFunction.get().advanceSearch("AdvancedSearchAssetType_AvayaArticle", "AdvancedSearchAssetSubType_AvayaMagazine","Innovations Magazine, 2013 Issue #2");			
		cmsBusinessFunction.get().dragAndDrop("PerspectiveWidgets_MagazineSource","PerspectiveWidgets_MagazineDestination",100);	
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");
		cmsVerify.get().verifyAssetSaved();
		cmsUserActions.get().clickOnElementUsingImage("ApproveCMS.JPG");
		cmsUserActions.get().clickOn("stagingDelivery");
		cmsUserActions.get().clickOn("ApproveWithDependenciesButton");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().clickOn("CMSLogout");
		//cmsBusinessFunction.get().Publish("PerspectiveWidgets");
		
	}
	
	/**
	  Author Name                       : Sindhuja P
	  Date of Preparation               : 19-09-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify the creation of new leader in CMS application and the new leader should be displayed on the Leader ship page
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	 * @throws AWTException 
	  **/
	
	@Test(description="Verify the creation of new leader in CMS application and the new leader should be displayed on the Leader ship page",groups="CMS")
	public void testCreationOfNewLeader() throws InterruptedException, AWTException
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		cmsUserActions.get().clickOnElementUsingImage("Contributor.JPG");
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().hoverOn("Content");
		cmsUserActions.get().clickOn("New");
		cmsUserActions.get().clickOn("NewAvayaContent");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().clickOn("AvayaContentParentDefinition_Arrow");
		cmsUserActions.get().clickOn("RASAboutAvayaContent");
		cmsBusinessFunction.get().verifyElementContainsText("RASAboutAvayaContent_Attributes", ",");
		cmsUserActions.get().enterText("RASAboutAvayaContent_NameField", "RASAboutAvayaContent_LeaderName");
		cmsUserActions.get().enterText("RASAboutAvayaContent_TitleField", "RASAboutAvayaContent_LeaderTitle");
		cmsBusinessFunction.get().advanceSearch("AdvancedSearchAssetType_AvayaMedia","AdvancedSearchAssetSubType_RASImage", "qa_auto_test_TestImage");
		cmsBusinessFunction.get().dragAndDrop("RASAboutAvayaContent_ImageSource","RASAboutAvayaContent_ImageDestination",50);
		cmsUserActions.get().enterText("RASAboutAvayaContent_DescriptionTitleField", "RASAboutAvayaContent_LeaderDescriptionTitle");
		cmsBusinessFunction.get().ckEditor("RASAboutAvayaContent_DescriptionField", "RASAboutAvayaContent_LeaderName", "RASAboutAvayaContent_DescriptionFrame");
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().enterText("RASAboutAvayaContent_MetaPageTitleField", "RASAboutAvayaContent_LeaderMetaPageTitle");
		cmsUserActions.get().enterText("RASAboutAvayaContent_MetaDescriptionField", "RASAboutAvayaContent_LeaderMetaPageTitle");
		cmsUserActions.get().enterText("RASAboutAvayaContent_MetaKeyword", "RASAboutAvayaContent_LeaderMetaPageTitle");
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");	
		
	}
	
	/**
	  Author Name                       : Sindhuja P
	  Date of Preparation               : 19-09-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify the Thank You page if both CTA on Image attribute and Thank you Image attribute is updated in OWC
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	 * @throws AWTException 
	  **/
	
	@Test(description="Verify the Thank You page if both CTA on Image attribute and Thank you Image attribute is updated in OWC",groups="CMS")
	public void testPremiumContentCTAOnImageThankyouImageUpdated() throws InterruptedException, AWTException
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		cmsUserActions.get().clickOnElementUsingImage("Contributor.JPG");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().enterText("SearchBox", "Search_PremiumResource");
		cmsUserActions.get().clickOnElementUsingImage("Magnifier.JPG");
		cmsUserActions.get().doubleClickOn("Search_PremiumResource");
		cmsBusinessFunction.get().closePreviousTab();
		cmsUserActions.get().switchToFrame("Body_Frame");
		System.out.println(getDriver().getPageSource());
		cmsUserActions.get().clickOn("PremiumResource_ThankYouPage");
		cmsBusinessFunction.get().closePreviousTab();
		cmsUserActions.get().clickOnElementUsingImage("EditCMS.JPG");
		//cmsUserActions.get().clickOn("PremiumResourceThankYouPage_Image");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().clickOn("SearchField_CrossButton");
		cmsUserActions.get().clickOn("SearchWithDownArrow");
		cmsUserActions.get().clickOn("SearchType_FindAvayaMedia");
		cmsBusinessFunction.get().searchAsset("The Guide to Cloud Collaboration");
		cmsBusinessFunction.get().dragAndDrop("ThankYouPage_ImageSource","ThankYouPage_ImageDestination",100);
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().clickOn("SearchField_CrossButton");
		cmsUserActions.get().clickOn("SearchWithDownArrow");
		cmsUserActions.get().clickOn("SearchType_FindAll");
		cmsBusinessFunction.get().searchAsset("The Guide to Cloud Collaboration");
		cmsBusinessFunction.get().dragAndDrop("ThankYouPage_CTAOnImageSource","ThankYouPage_CTAOnImageDestination",100);
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");
	}
	
	@Test(description="Verify the error message when saving asset without name",groups="CMS")
	public void testPartnersErrorMessage()throws InterruptedException
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		cmsUserActions.get().switchToFrame("LeftNavFrame");
		cmsUserActions.get().clickOn("LeftNav_Default");
		cmsUserActions.get().clickOn("LeftNav_Default_Home");
		cmsUserActions.get().doubleClickOn("LeftNav_Default_Home_Partners_Link");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().clickOn("Partners");
		cmsBusinessFunction.get().closePreviousTab();
		//cmsUserActions.get().switchToFrame("Body_Frame");
		//cmsUserActions.get().clickOn("Partners_CustomerBenefits_Link");
		//cmsBusinessFunction.get().closePreviousTab();
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().doubleClickOn("Edit");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().clearText("Article_Name");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().doubleClickOn("CMSSaveButton");
		cmsVerify.get().verifyText("AvayaMasterDataErrorMessage","AvayaMasterDataErrorMessage");
	}
	
	@Test(description="Verify the attributes of benefits for customers asset",groups="CMS")
	public void testBenefitsForCustomersAttributes()
	{
	getDriver().get("http://tlowsap1.us1.avaya.com:9001/cs/login");
	cmsBusinessFunction.get().cmsLogin("username","password");
	cmsUserActions.get().switchToFrame("LeftNavFrame");
	cmsUserActions.get().clickOn("LeftNav_Default");
	cmsUserActions.get().clickOn("LeftNav_Default_Home");
	cmsUserActions.get().doubleClickOn("LeftNav_Default_Home_Partners_Link");
	cmsUserActions.get().switchToDefaultContent();
	cmsUserActions.get().switchToFrame("Main_Frame");
	cmsUserActions.get().switchToFrame("Body_Frame");
	cmsUserActions.get().clickOn("Partners");
	cmsBusinessFunction.get().closePreviousTab();
	cmsUserActions.get().switchToFrame("Body_Frame");
	cmsUserActions.get().clickOn("Partners_CustomerBenefits_Link");
	cmsBusinessFunction.get().closePreviousTab();
	cmsUserActions.get().switchToFrame("Body_Frame");
	cmsBusinessFunction.get().verifyElementContainsText("BenefitsForPartnersAttributes",",");
	}
	
	@Test(description="Verify the preview of asset",groups="CMS")
	public void testPreviewPage() throws InterruptedException 
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		//cmsBusinessFunction.get().searchAsset("Products");
		cmsUserActions.get().switchToFrame("Main_Frame");
		//cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().clickOn("SearchWithDownArrow");
		cmsUserActions.get().clickOn("SearchType_FindAvayaMasterData");
		cmsBusinessFunction.get().searchAsset("IP Office");
		//cmsBusinessFunction.get().advanceSearch("AdvancedSearchAssetType_AvayaMasterData", "Any", "Avaya Aura Platform");
		cmsUserActions.get().clickOn("RunAdvancedSearch_SearchDock");
		//cmsUserActions.get().enterText("SearchBox", "SearchAsset");
		cmsUserActions.get().doubleClickOn("IP Office");
		Thread.sleep(30000);
		cmsUserActions.get().clickOnElementUsingImage("Preview.JPG");
		Thread.sleep(60000);
		//cmsBusinessFunction.get().closePreviousTab();
		//cmsUserActions.get().doubleClickOn("Preview");
		//cmsUserActions.get().switchToFrame("RASImagesContentFrame");
		cmsFactory.dynamicWait("Butlerbar", 30);
		cmsVerify.get().isElementDisplayed("Butlerbar");
		
	}
	
	
	@Test(description="CMS_Creation of Image asset",groups="CMS")
	public void createImageAsset() throws InterruptedException
	{
		getDriver().get("http://tlowsap1.us1.avaya.com:9001/cs/login");
		//cmsDynamicWait.get().waittillpageloads();
		Thread.sleep(3000);
		cmsBusinessFunction.get().cmsLogin("username","password");
		cmsUserActions.get().clickOn("contributor");
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsBusinessFunction.get().closeOpenTabs();
		cmsUserActions.get().hoverOn("Content");
		cmsUserActions.get().hoverOn("New");
		cmsUserActions.get().clickOn("NewMedia");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().clickOn("Dropdown");
		cmsUserActions.get().clickOn("RASImage");
		cmsUserActions.get().enterText("Article_Name","AssetName");
		cmsUserActions.get().enterText("Article_Title","AssetName");
		cmsUserActions.get().clickOn("ImageBrowseButton");
		cmsBusinessFunction.get().fileUpload("tulips.jpg",'d'); 
		cmsUserActions.get().clickOn("ThumbnailImageBrowseButton");
		cmsBusinessFunction.get().fileUpload("tulips.jpg",'d'); 
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("LeftNavFrame");
		cmsUserActions.get().clickOn("CMSSaveButton");
		cmsVerify.get().verifyAssetSaved();
		cmsUserActions.get().clickOn("CMSApprove");
		cmsUserActions.get().clickOn("stagingDelivery");
		cmsUserActions.get().clickOn("ArticleAsset");
		cmsUserActions.get().doubleClickOn("ApproveWithDependenciesButton");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().clickOn("CMSLogout");
		cmsBusinessFunction.get().Publish("AutomationImageTest");
	}
	
	
	
	
	/**
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 18-09-2014
	  Date of Modified                  : 23-09-2014
	  Methods Called                    : 
	  Purpose of Method                 : To verify if user is able to create a Solution Asset in CMS
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	 * @throws AWTException 
	  **/
	@Test(description = "To verify if user is able to create a Solution Asset in CMS")
	public void testCMSCreationOfSolutionAsset() throws InterruptedException {
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),
				appConfig.getAvayaPassword());
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().hoverOn("Content");
		cmsUserActions.get().clickOn("New");
		cmsUserActions.get().clickOn("NewAvayaContent");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsBusinessFunction.get().verifyElementContainsText(
				"AvayaContent_Attributes", ",");
		cmsVerify.get().isElementDisplayed("NewAvayaContent_ContinueButton");
		cmsUserActions.get().enterText("RASSolutions_NameField",
				"RASSolutionsText");
		cmsUserActions.get().clickOn("AvayaContentParentDefinition_Arrow");
		cmsUserActions.get().clickOn("RASSolutions");
		cmsElementFactory.get().dynamicWait("RASSolutions_SolutionsNameField",
				20);
		cmsUserActions.get().clickOn("RASSolutions_TemplateArrow");
		cmsUserActions.get().clickOn("RASSolutions_SelectTemplate");
		cmsUserActions.get().enterText("RASSolutions_SolutionsNameField",
				"RASSolutionsText");

		cmsBusinessFunction.get().advanceSearch(
				"AdvancedSearchAssetType_AvayaMasterData",
				"AdvancedSearchAssetSubType_RASSearch", "");
		cmsBusinessFunction.get().dragAndDrop("RASSolutions_CategorySource",
				"RASSolutions_Category", 100);
		cmsBusinessFunction.get().ckEditor(
				"RASSolutions_SolutionSubHeaderDescription",
				"RASSolutionsText", "RASSolutions_SolutionSubHeaderFrame");
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().enterText("RASSolutions_SolutionHeaderField",
				"RASSolutionsText");
		cmsBusinessFunction.get()
				.ckEditor("RASSolutions_SolutionOverviewContentDescription",
						"RASSolutionsText",
						"RASSolutions_SolutionOverviewContentFrame");

		cmsBusinessFunction.get().advanceSearch(
				"AdvancedSearchAssetType_AvayaMedia",
				"AdvancedSearchAssetSubType_RASImage", "");
		cmsBusinessFunction.get().dragAndDrop("RASSolutions_HeroImageSource",
				"RASSolutions_HeroImage", 100);

		// cmsBusinessFunction.get().searchAsset("qa_auto_test_RASArticle");
		cmsBusinessFunction.get().advanceSearch(
				"AdvancedSearchAssetType_AvayaArticles",
				"AdvancedSearchAssetSubType_RASArticle", "");
		cmsBusinessFunction.get().dragAndDrop(
				"RASSolutions_AssociatedModulesSource",
				"RASSolutions_AssociatedModule", 100);

		// cmsBusinessFunction.get().searchAsset("qa_auto_test_RASArticle");
		cmsBusinessFunction.get().advanceSearch(
				"AdvancedSearchAssetType_AvayaArticles",
				"AdvancedSearchAssetSubType_RASArticle", "");
		cmsBusinessFunction.get().dragAndDrop(
				"RASSolutions_AssociatedModulesSource",
				"RASSolutions_CoreComponentOverviewIntroModule", 100);

		// cmsBusinessFunction.get().searchAsset("qa_auto_test_RASArticle");
		cmsBusinessFunction.get().advanceSearch(
				"AdvancedSearchAssetType_AvayaArticles",
				"AdvancedSearchAssetSubType_RASArticle", "");
		cmsBusinessFunction.get().dragAndDrop(
				"RASSolutions_AssociatedModulesSource",
				"RASSolutions_CoreComponentOverviewMoules", 100);

		cmsUserActions.get().enterText("RASSolutions_CrossSellTitle",
				"DataServices");
		cmsUserActions.get().enterText("RASSolutions_CrossSellDescription",
				"DataServices");
		cmsUserActions.get()
				.enterText("RASSolutions_MegaTitle", "DataServices");

		cmsUserActions.get().clickOn("MetadataTab");
		cmsUserActions.get().clickOn("DropDown");
		cmsUserActions.get().clickOn("DropDown_en_US");
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");
		cmsVerify.get().verifyAssetSaved();
		cmsUserActions.get().clickOnElementUsingImage("ApproveCMS.JPG");
		cmsUserActions.get().clickOn("stagingDelivery");
		cmsUserActions.get().clickOn("ApproveWithDependenciesButton");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().clickOn("CMSLogout");
		// cmsBusinessFunction.get().Publish("qa_auto_test_Data Solutions");

		}
	
	/**
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 18-09-2014
	  Date of Modified                  : 23-09-2014
	  Methods Called                    : 
	  Purpose of Method                 : To verify if user is able to Create a Avaya Magazine Asset in CMS
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	 * @throws AWTException 
	  **/
	@Test(description = "To verify if user is able to Create a Avaya Magazine Asset in CMS")
	public void testCMSCreationOfAvayaMagazinePerspective() throws InterruptedException{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());		
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().hoverOn("Content");
		cmsUserActions.get().clickOn("New");
		cmsUserActions.get().clickOn("NewAvayaArticles");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsBusinessFunction.get().verifyElementContainsText("AvayaArticlesParent", ",");
		cmsVerify.get().isElementDisplayed("NewAvayaContent_ContinueButton");
		cmsUserActions.get().enterText("RASAvayaMagazine_NameField", "RASAvayaMagazine_Name");
		cmsUserActions.get().clickOn("AvayaArticlesParentDefinition_Arrow");
		cmsUserActions.get().clickOn("RASAvayaMagazine");
		cmsElementFactory.get().dynamicWait("RASAvayaMagazine_ArticleDescriptionField", 20);
		cmsUserActions.get().clickOn("RASAvayaMagazine_TemplateArrow");
		cmsUserActions.get().clickOn("RASAvayaMagazine_SelectTemplate");
		cmsBusinessFunction.get().ckEditor("RASAvayaMagazine_ArticleDescriptionField", "RASAvayaMagazine_ArticleDescription", "RASAvayaMagazine_ArticleDescriptionFrame");
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsBusinessFunction.get().advanceSearch("AdvancedSearchAssetType_AvayaMedia", "AdvancedSearchAssetSubType_RASImage","");
		cmsBusinessFunction.get().dragAndDrop("RASAvayaMagazine_ImageSource","RASAvayaMagazine_ImageDestination",100);
		cmsUserActions.get().clickOn("MetadataTab");
		cmsUserActions.get().clickOn("DropDown");
		cmsUserActions.get().clickOn("DropDown_en_US");
		cmsUserActions.get().clickOn("ContentTab");		
		cmsUserActions.get().clickOn("RASAvayaMagazine_DateArrow");
		cmsUserActions.get().clickOn("RASAvayaMagazine_SelectDate");
		cmsUserActions.get().enterText("RASAvayaMagazine_MagazineTitleField", "RASAvayaMagazine_MagazineTitle");
		cmsUserActions.get().enterText("RASAvayaMagazine_MagazineURlField", "RASAvayaMagazine_MagazineURl");
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");
		cmsVerify.get().verifyAssetSaved();
		cmsUserActions.get().clickOnElementUsingImage("ApproveCMS.JPG");
		cmsUserActions.get().clickOn("stagingDelivery");
		cmsUserActions.get().clickOn("ApproveWithDependenciesButton");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().clickOn("CMSLogout");
//		cmsBusinessFunction.get().Publish("qa_auto_test_Evolutions Magazine");
	}
	
	/**
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 18-09-2014
	  Date of Modified                  : 23-09-2014
	  Methods Called                    : 
	  Purpose of Method                 : To Verify if user is able to Create Featured News Article Asset in CMS
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	 * @throws AWTException 
	  **/
	@Test(description = "To Verify if user is able to Create Featured News Article Asset in CMS")
	public void testCMSCreationFeaturedNewsArticle() throws InterruptedException{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());		
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().hoverOn("Content");
		cmsUserActions.get().clickOn("New");
		cmsUserActions.get().clickOn("NewAvayaArticles");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().enterText("AvayaArticles_NameField", "AvayaArticles_Name");
		cmsVerify.get().isElementDisplayed("NewAvayaContent_ContinueButton");
		cmsUserActions.get().clickOn("AvayaArticlesParentDefinition_Arrow");
		cmsUserActions.get().clickOn("FeaturedNews");
		cmsElementFactory.get().dynamicWait("FeaturedNews_DateArrow", 30);
		cmsUserActions.get().clickOn("FeaturedNews_DateArrow");
		cmsUserActions.get().clickOn("FeaturedNews_SelectDate");
		cmsBusinessFunction.get().ckEditor("FeaturedNews_DescriptionField", "FeaturedNews_Description", "FeaturedNews_DescriptionFrame");
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().enterText("FeaturedNews_TitleField", "FeaturedNews_Title");		
		
		cmsBusinessFunction.get().advanceSearch("AdvancedSearchAssetType_AvayaArticle", "AdvancedSearchAssetSubType_RASDocument","");
		cmsBusinessFunction.get().dragAndDrop("RASAvayaMagazine_PresentationSource","RASAvayaMagazine_PresentationDestination",100);		

		cmsBusinessFunction.get().advanceSearch("AdvancedSearchAssetType_AvayaContent", "AdvancedSearchAssetSubType_RASUrl","");
		cmsBusinessFunction.get().dragAndDrop("RASAvayaMagazine_WebCaseUrlSource","RASAvayaMagazine_WebCaseUrlDestination",100);		
		
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");
		cmsVerify.get().verifyAssetSaved();
//		cmsVerify.get().verifyText("AssetTitle", "AvayaArticles_Name");
		cmsUserActions.get().clickOnElementUsingImage("ApproveCMS.JPG");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().clickOn("stagingDelivery");
		cmsUserActions.get().clickOn("ApproveWithDependenciesButton");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().clickOn("CMSLogout");
//		cmsBusinessFunction.get().Publish("qa_auto_test_Test_FeaturedNewse");
	}

	/**
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 19-09-2014
	  Date of Modified                  : 23-09-2014
	  Methods Called                    : 
	  Purpose of Method                 : To create a avaya CVL Asset in CMS
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	 * @throws AWTException 
	  **/
	@Test(description = "To create a avaya CVL Asset in CMS")
	public void testCMSCreationOfContentFilters() throws InterruptedException{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().hoverOn("Content");
		cmsUserActions.get().clickOn("New");
		cmsUserActions.get().clickOn("NewAvayaMasterData");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsVerify.get().isElementDisplayed("NewAvayaContent_ContinueButton");
		cmsUserActions.get().enterText("AvayaCVL_NameField", "AvayaCVL_Name");
		cmsUserActions.get().clickOn("AvayaArticlesParentDefinition_Arrow");
		cmsUserActions.get().clickOn("AvayaCVL");
		cmsElementFactory.get().dynamicWait("AvayaCVL_FilterValueField", 30);
		cmsUserActions.get().enterText("AvayaCVL_FilterValueField", "AvayaCVL_FilterValue");
		cmsUserActions.get().enterText("AvayaCVL_KeyField", "AvayaCVL_Key");
		cmsUserActions.get().clickOn("MetadataTab");
		cmsUserActions.get().clickOn("DropDown");
		cmsUserActions.get().clickOn("DropDown_en_US");		
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");		
		cmsVerify.get().verifyAssetSaved();
		cmsUserActions.get().clickOnElementUsingImage("ApproveCMS.JPG");
		cmsUserActions.get().clickOn("stagingDelivery");
		cmsUserActions.get().clickOn("ApproveWithDependenciesButton");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().clickOn("CMSLogout");
//		cmsBusinessFunction.get().Publish("qa_auto_test_Test_Conferencing");
	}

	/**
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 19-09-2014
	  Date of Modified                  : 23-09-2014
	  Methods Called                    : 
	  Purpose of Method                 : To edit the Partner page in CMS
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	 * @throws AWTException 
	  **/
	@Test(description = "To edit the Partner page in CMS")
	public void testPartnersCMSLandingPage() throws InterruptedException{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		cmsUserActions.get().switchToFrame("LeftNavFrame");
		cmsUserActions.get().clickOn("LeftNav_Default");
		cmsUserActions.get().clickOn("LeftNav_Default_Home");
		cmsUserActions.get().doubleClickOn("LeftNav_Default_Home_Partners_Link");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().switchToFrame("Body_Frame");
		cmsUserActions.get().clickOn("Partners_CategoryLink");
		cmsBusinessFunction.get().closePreviousTab();
		cmsBusinessFunction.get().verifyElementContainsText("PartnersPage_Attributes", ",");		
	}

	/**
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 22-09-2014
	  Date of Modified                  : 23-09-2014
	  Methods Called                    : 
	  Purpose of Method                 : To edit the SEO Landing page in CMS
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	 * @throws AWTException 
	  **/
	@Test(description = "To edit the SEO Landing page in CMS")
	public void testSEOLandingPageCMS() throws InterruptedException{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsBusinessFunction.get().advanceSearch("AdvancedSearchAssetType_AvayaContent", "AdvancedSearchAssetSubType_RASSEO","");
		cmsUserActions.get().clickOn("SEOProduct");
		cmsBusinessFunction.get().verifyElementContainsText("SEOPage_Attributes", ",");
		cmsUserActions.get().clickOnElementUsingImage("EditCMS.JPG");
		cmsFactory.dynamicWait("RASSEO_NameField",20);
		cmsUserActions.get().clearText("RASSEO_NameField");
		cmsUserActions.get().enterText("RASSEO_NameField", "RASSEOName");
		cmsUserActions.get().clickOn("RASSEO_Arrow");
		cmsUserActions.get().clickOn("RASSEOTemplate");
		cmsUserActions.get().clearText("RASSEO_TitleField");
		cmsUserActions.get().enterText("RASSEO_TitleField", "RASSEOTitle");
		cmsUserActions.get().clearText("RASSEO_SubTitleField");
		cmsUserActions.get().enterText("RASSEO_SubTitleField", "RASSEOSubTitle");
		cmsUserActions.get().clickOn("RASSEO_ImageDelete");
		cmsUserActions.get().clearText("RASSEO_PremiumContentDescriptionField");
		cmsUserActions.get().enterText("RASSEO_PremiumContentDescriptionField", "RASSEOPremiumContentDescription");
		cmsUserActions.get().clickOn("RASSEO_PremiumContentImageDelete");
		cmsUserActions.get().clearText("RASSEO_MegaPageTitleField");
		cmsUserActions.get().enterText("RASSEO_MegaPageTitleField", "RASSEOMegaPageTitle");
		cmsUserActions.get().clearText("RASSEO_MegaDescriptionField");
		cmsUserActions.get().enterText("RASSEO_MegaDescriptionField", "RASSEOMegaDescription");
		cmsUserActions.get().clearText("RASSEO_MegaKeywordsField");
		cmsUserActions.get().enterText("RASSEO_MegaKeywordsField", "RASSEOMegaKeywords");

		cmsBusinessFunction.get().advanceSearch("AdvancedSearchAssetType_AvayaMedia", "AdvancedSearchAssetSubType_RASImage","AboutAvayaImage1");
		cmsBusinessFunction.get().dragAndDrop("RASSEO_ImageSource","RASSEO_ImageDestination",100);
		
		cmsBusinessFunction.get().advanceSearch("AdvancedSearchAssetType_AvayaMedia", "AdvancedSearchAssetSubType_RASImage","Cross sell image faction");
		cmsBusinessFunction.get().dragAndDrop("RASSEO_PremiumContentImageSource","RASSEO_PremiumContentImageDestination",100);			
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");
		cmsVerify.get().verifyAssetSaved();		
//		cmsVerify.get().verifyText("AssetTitle", "RASSEOName");
		cmsUserActions.get().clickOnElementUsingImage("ApproveCMS.JPG");
		cmsUserActions.get().clickOn("stagingDelivery");
		cmsUserActions.get().clickOn("ApproveWithDependenciesButton");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().clickOn("CMSLogout");
//		cmsBusinessFunction.get().Publish("SEOProduct");
		
	}
	/**
	  Author Name                       : Sindhuja P
	  Date of Preparation               : 16-09-2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify the changes made to attributes related to hero image or video in CMS are reflected on SEO Page
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws InterruptedException 
	 * @throws AWTException 
	  **/
	
	@Test(description="Verify the changes made to attributes related to hero image or video in CMS are reflected on SEO Page",groups="CMS")
	public void testSEOLanding() throws InterruptedException, AWTException
	{
		getDriver().get(appConfig.getCmsStagingUrl());
		cmsBusinessFunction.get().cmsLogin(appConfig.getAvayaUserName(),appConfig.getAvayaPassword());
		cmsUserActions.get().clickOnElementUsingImage("Contributor.JPG");
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsBusinessFunction.get().advanceSearch("AdvancedSearchAssetType_AvayaContent", "AdvancedSearchAssetSubType_RASSEO", "qa_auto_test_TestAvayaSEO");
		cmsUserActions.get().doubleClickOn("Search_SEOAvaya");
		cmsBusinessFunction.get().closePreviousTab();
		cmsUserActions.get().clickOnElementUsingImage("EditCMS.JPG");
		cmsUserActions.get().clickOn("SEOAvaya_ImageCrossButton");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().switchToFrame("Main_Frame");
		cmsUserActions.get().clickOn("SearchField_CrossButton");
		cmsBusinessFunction.get().searchAsset("qa_auto_test_Networks Image");
		cmsBusinessFunction.get().dragAndDrop("SEOAvaya_ImageSource","SEOAvaya_ImageDestination",100);
		cmsUserActions.get().clickOnElementUsingImage("SaveButton.JPG");	
		cmsVerify.get().verifyAssetSaved();
		cmsUserActions.get().clickOnElementUsingImage("ApproveCMS.JPG");
		cmsUserActions.get().clickOn("stagingDelivery");
		cmsUserActions.get().clickOn("ApproveWithDependenciesButton");
		cmsUserActions.get().switchToDefaultContent();
		cmsUserActions.get().clickOn("CMSLogout");
		
	}
	
}
