package test;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.android.ddmlib.AdbCommandRejectedException;

import properties.LoadAppConfig;
import resources.VerifyImage;
import utilities.ScreenShots;




public class UI extends Base {
	
	Date dNow = new Date();
    SimpleDateFormat ft_foldername =  new SimpleDateFormat ("ddMMyyyyhhmmss");	
    ScreenShots screenshots=new ScreenShots(driver);
    File file= screenshots.createscreenshotfolder("Screenshots_UI"+ft_foldername.format(dNow));
    LoadAppConfig appConfig=new LoadAppConfig();
   
    /**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 02-07-2014
	  Date of Modified                  : --
	  Methods Called                    : verifyBreadCrumb(String actualControlName, String expectedControlName)
	  Purpose of Method                 : verify the presence of bread crumb in Partners page
	  Dependencies	                    : 
	  Reviewed By                       : 
	  **/
	
	@Test(description="Verify the presence of breadcrumb in Partners page",groups="Partners")
	public void testPartnersIsBreadCrumbPresent()
	{
		//Launching the Avaya website
		getDriver().get(appConfig.getAppUrl());
		//To click on the Partners tab from the megamenu 
		businessFunction.get().clickAndVerifyNavigation("Partners", "Partners_Title");
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		//verifying the presence of BreadCrumb using the business function verifyBreadCrumb 
		businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "Partners_Breadcrumb_Expected","Tag_Anchors");
				
	}

	
	/** 
    Author Name                       : Niharika K R 
    Date of Preparation               : 16-10-2014
    Date of Modified                  : 
    Methods Called                    : 
    Purpose of Method                 : Verify the Partners Landing Page(Incomplete)
    Dependencies	                  : --
    Reviewed By                       : --
    **/
	
	@Test(description="Verify the Partners Landing Page",groups="Partners")
	public void testPartnersLandingPage()
	{
		//Launching the Avaya website
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		businessFunction.get().clickAndVerifyNavigation("Partners", "Partners_Title");
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		verify.get().isElementDisplayed("ButlerBar");
		verify.get().isElementDisplayed("Megamenu");
		businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "Breadcrumb_PartnersLandingPage", "Tag_Anchors");
		verify.get().isElementDisplayed("ChatPOPUP");
		verify.get().isElementDisplayed("PartnersLandingPage_FindAPartnerModule");
		verify.get().isElementDisplayed("PartnersLandingPage_BecomeAnAvayaPartner");
		
	}
	
	  
	
	/** 
	  Author Name                       : Vinusha
	  Date of Preparation               : 07/07/2014
	  Date of Modified                  : --
	  Methods Called                    : Click_VerifyNavigation(businessFunction.get().get()), waittillpageloads(dynamicWait.get().)
	  Purpose of Method                 : Verifying whether About Avaya page is opening or not
	  Dependencies	                    : --
	  Reviewed By                       : --
	 **/
	@Test(description="Verify About Avaya landing page is opending or not",groups="About Avaya")
	public void testAbtAvayaLandPage()
	{
		// Launching the Avaya URL
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		businessFunction.get().clickAndVerifyNavigation("MegaMenuAboutAvaya",
				"AboutAvayaLabel");

	}
	
	
	 /** 
	 Author Name                       : Niharika
	 Date of Preparation               : 07/07/2014
	 Date of Modified                  : --
	 Methods Called                    : clickOn(Utilities),waittillpageloads(dynamicWait.get().),isElementPresent(Verify)
	 Purpose of Method                 : Verifying whether BulterBar is present in the About Avaya page or not
	 Dependencies	                   : --
	 Reviewed By                       : --
	**/
	
	  @Test(description="Verify About Avaya Butler Bar details are displaying in the main page or not",groups="About Avaya")
	    public void testAbtAvayaLandPageButlerBar()
	    {
	    	// Launching the Avaya URL
	    	getDriver().get(appConfig.getAppUrl());
	    	dynamicWait.get().waittillpageloads();
	    	// Clicing on About Avaya tab
	    	userActions.get().clickOn("MegaMenuAboutAvaya"); 	
	    	dynamicWait.get().waittillpageloads();
	    	// Verifying the ButlerBar.
	    	verify.get().isElementPresent("ButlerBar");		
	    				
	    }
	
	  /** 
	   Author Name                       : Vinusha Tanuku
	   Date of Preparation               : 07/07/2014
	   Date of Modified                  : --
	   Methods Called                    : 
	   Purpose of Method                 : Verify the navigation to Legacy pages for Operations services and Support Services
	   Dependencies                      : --
	   Reviewed By                       : --
	   **/
	   @Test(description="Verify the navigation to Legacy pages for Operations services and Support Services",groups="Services")
	   public void testServicesPromotionalPodsPageNavigation()
	   {
		  //Launching the Avaya URL
	      getDriver().get(appConfig.getAppUrl());
	      //wait tillpage loads
	      dynamicWait.get().waittillpageloads();
	      // Navigate to Service landing page
	      businessFunction.get().clickAndVerifyNavigation("Services", "Service_label");
	      // Navigate to ExploreProfessionalServices page
	      businessFunction.get().clickAndVerifyNavigation("ExploreProfessionalServices_button", "ExploreProfessionalServices_title");
	      //Navigate back to Service landing page
	      businessFunction.get().clickAndVerifyNavigation("Services", "Service_label");
	      //Navigate to ExploreOperationsServices page
	      businessFunction.get().clickAndVerifyNavigation("ExploreOperationsServices_button", "ExploreOperationsServices_title");
	     //Navigate back to Service landing page
	      businessFunction.get().clickAndVerifyNavigation("Services", "Service_label");
	     //Navigate to ExploreSupportServices page
	      businessFunction.get().clickAndVerifyNavigation("ExploreSupportServices_button", "ExploreSupportServices_title");
	         
	   }
	   
		/** 
       	Author Name                       : Vinusha Tanuku
      	Date of Preparation               : 07/07/2014
      	Date of Modified                  : 
      	Methods Called                    : 
       	Purpose of Method                 : Verify the launching of the service detail page
      	Dependencies                      : --
      	Reviewed By                       : --
      **/
      @Test(description="Verify the launching of the service detail page",groups="Services")
      public void testServiceDetailLaunch()
      {
        //Launch the Url 
       getDriver().get(appConfig.getAppUrl());
       //Wait tillpage loads
   	   dynamicWait.get().waittillpageloads();
   	   //Click on ContactCenterOptimization link under Service Category and verify the Title of teh page after navigation
   	   businessFunction.get().clickOnSubMenuItem("Services","ContactCenterOptimization","ContactCenterOptimization_Title");              
      }
      
  	/**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 07/07/2014
	  Date of Modified                  : --
	  Methods Called                    : isElementPresent(String controlName),VerifyElementContainsText(String controlName, String controlNameExpected)
	  Purpose of Method                 : Verify the content in the benefits landing page
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	  **/
	
  	@Test(description="Verify the content in the benefits landing page",groups="Home Page")
  	public void testHomepageGlobalFooterLinks()
  	{
  		// Launching the Avaya Website
  		getDriver().get(appConfig.getAppUrl());
  		businessFunction.get().deFocus();
  		//To verify the presence of Newsroom link 
  		verify.get().isElementDisplayed("Newsroom");
  		//To verify the presence of Careers link
  		verify.get().isElementDisplayed("Careers");
  		//To verify the presence of Sitemap link
  		verify.get().isElementDisplayed("Sitemap");
  		//To verify the presence of Terms of Use link
  		verify.get().isElementDisplayed("Terms_of_Use");
  		//To verify the presence of Privacy link
  		verify.get().isElementDisplayed("Privacy");
  		//To verify the presence of Cookies link
  		verify.get().isElementDisplayed("Cookies");
  		//To verify the presence of Contacts link
  		verify.get().isElementDisplayed("Contacts");
  		//To verify the presence of copyright symbol
  		verify.get().verifyElementContainsText("Copyright_Symbol", "Copyright_Symbol_expected");
  	}
	
	 /** 
	 Author Name                       : Vinusha
	 Date of Preparation               : 09/07/2014
	 Date of Modified                  : --
	 Methods Called                    : clickOn(Utilities),waittillpageloads(dynamicWait.get().),isElementPresent(Verify)
	 Purpose of Method                 : Verifying whether Megamenu is present in the about avaya page or not
	 Dependencies	                    : --
	 Reviewed By                       : --
	 Test Case name					   : About Avaya_Landing page_MegaNavigation
	**/

	@Test(description="Verify whether Megamenu is displaying while clicking on About Avaya",groups="About Avaya")
	public void testAbtAvayaLandPageMegaMenu()
	{
		// Launching the Avaya URL
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		// Clicing on About Avaya tab
		userActions.get().clickOn("MegaMenuAboutAvaya");
		dynamicWait.get().waittillpageloads();
		// Verifying the Megamenu is present or not.
		verify.get().isElementPresent("ButlerBar");		
	}
	
	/** 
	 Author Name                       : Phani
	 Date of Preparation               : 09/07/2014
	 Date of Modified                  : --
	 Methods Called                    : clickOn(Utilities), waittillpageloads(dynamicWait.get().), VerifyBreadCrumb(businessFunction.get().get())
	 Purpose of Method                 : Checking whether Breadcrumb content is available in About Avaya page or not
	 Dependencies	                    : --
	 Reviewed By                       : --
	 Test Case name					   :  About Avaya_Landing page_Bread Crumb
	**/

	@Test(description="Verify About Avaya BreadCrumb is displaying in the main page or not",groups="About Avaya")
	  public void testAbtAvayaBreadCrumb()
    {
		// Launching the Avaya URL
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		// Clicing on About Avaya tab
		userActions.get().clickOn("MegaMenuAboutAvaya");
		dynamicWait.get().waittillpageloads();
		// Verifying the BreadCrumb title.
		businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "AboutAvayaBreadCrumb","Tag_Anchors");
    				
    }
	
	/** 
	 Author Name                       : Pankaj
	 Date of Preparation               : 09/07/2014
	 Date of Modified                  : --
	 Methods Called                    : clickOn(Utilities), waittillpageloads(dynamicWait.get().), isElementNotPresent(Verify)
	 Purpose of Method                 : Verifying whether Chat link is available in the About Avaya page or not
	 Dependencies	                    : --
	 Reviewed By                       : --
	 Test Case name					   : About Avaya_Landing page_Chat link
	**/

	@Test(description="Verify if the Chat Link is present in About Avaya landing page",groups="About Avaya")
	public void testAboutAvayaChat()
	{
		// Launching the Avaya URL
    	getDriver().get(appConfig.getAppUrl());
    	dynamicWait.get().waittillpageloads();
    	// Clicking on About Avaya tab
    	userActions.get().clickOn("MegaMenuAboutAvaya"); 	
    	dynamicWait.get().waittillpageloads();
    	// Verifying the ChatLink is exist or not.
    	verify.get().isElementNotPresent("AboutAvayaChatLink");				
	}
	
	/** 
	 Author Name                       : Vinusha
	 Date of Preparation               : 10/07/2014
	 Date of Modified                  : --
	 Methods Called                    : clickOn(Utilities), Click_VerifyNavigation(businessFunction.get().get()), waittillpageloads(dynamicWait.get().)
	 Purpose of Method                 : Checking Image text is present in the About avaya page or not
	 Dependencies	                   : --
	 Reviewed By                       : --
	 Test Case name					   : About Avaya_Landing page_Image Text
	**/
	  @Test(description="Verify About Avaya Title is displaying in the main page or not",groups="About Avaya")
	    public void testAbtAvayaLandImageText()
	  {
		// Launching the Avaya URL
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		// Clicking on About Avaya tab
		userActions.get().clickOn("MegaMenuAboutAvaya");
		businessFunction.get().deFocus();	
		//businessFunction.get().contentValidation("AbtAvayaLandImageText");
	  }
	
	 /** 
	 Author Name                       : Vinusha
	 Date of Preparation               : 10/07/2014
	 Date of Modified                  : --
	 Methods Called                    : Click_VerifyNavigation,isTextPresent(businessFunction.get().get()), waittillpageloads(dynamicWait.get().)
	 Purpose of Method                 : Verify if Contacts Pod is present in About Avaya landing page
	 Dependencies	                   : --
	 Reviewed By                       : --
	 Test Case name					   : About Avaya_Landing page_Contacts Pod
	**/

	  @Test(description="Verify if Contacts Pod is present in About Avaya landing page",groups="About Avaya")
	    public void testAbtAvayaLandContactsPod()
	    {
	    	// Launching the Avaya URL
	    	getDriver().get(appConfig.getAppUrl());
	    	dynamicWait.get().waittillpageloads();			
	    	//Click on About Avaya from megamenu
	    	userActions.get().clickOn("MegaMenuAboutAvaya");
	    	dynamicWait.get().waittillpageloads();
	    	//Verfiy the Contacts pod content
	    	businessFunction.get().contentValidation("AboutAvayaTopPods_ContactsPod_Header");
	    	businessFunction.get().verifyPartnerAndProductPods("AboutAvayaTopPods_ContactsPod_Description","Tag_Anchors");    					    				
	    }
	/** 
	 Author Name                       : Sindhuja
	 Date of Preparation               : 10/07/2014
	 Date of Modified                  : --
	 Methods Called                    : clickOn(Utilities),waittillpageloads(dynamicWait.get().),isElementPresent(Verify)
	 Purpose of Method                 : Verify if the global footer is present in About Avaya landing page

	 Dependencies	                   : --
	 Reviewed By                       : --
	 Test Case name					   : About Avaya_Landing page_Global Footer
	**/

	  @Test(description="Verify if the global footer is present in About Avaya landing page",groups="About Avaya")
	    public void testAbtAvayaLandPageFooter()
	    {
	    	// Launching the Avaya URL
	    	getDriver().get(appConfig.getAppUrl());
	    	dynamicWait.get().waittillpageloads();	
	    	// Clicking on About Avaya tab
	    	userActions.get().clickOn("MegaMenuAboutAvaya"); 	
	    	dynamicWait.get().waittillpageloads();	
	    	// Verifying the Footer is exist or not in About avaya page
	    	verify.get().isElementPresent("AbtAvayaLandPageFooter"); 		
	    					
	    }
	/** 
	 Author Name                       : Sindhuja
	 Date of Preparation               : 10/07/2014
	 Date of Modified                  : --
	 Methods Called                    : Click_VerifyNavigation,checkUrl(businessFunction.get().get())
	 Purpose of Method                 : Verify the URL of magazines of Perspectives Pages.
	 Dependencies	                    : --
	 Reviewed By                       : --
	 TestCase name					   : wi01147068_Perspective_Magazine URL
	**/


	  @Test(description="Verify the URL of magazines of Perspectives Pages.",groups="Perspectives")
	    public void testPerspectivesMagazineURL()
	    {
	    	// Launching the Avaya URL
	    	getDriver().get(appConfig.getAppUrl());
	    	dynamicWait.get().waittillpageloads();
	    	// Verifying the Perspectives title page
	    	businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "Perspectives_SubMenu", "PerspectivesTitlePage");		
	    	// Verifying the PerspectivesMagazine Title.
	    	businessFunction.get().clickAndVerifyNavigation("Perspectives_addl_links_mags_guides", "PerspecMagazineGuidesHeading");
	    	//Verify the Perspective Magazine Guides URL
	    	businessFunction.get().checkUrl("PerspecMagazineGuidesURL","contains");				
	    								
	    }
	
	/**
	  Author Name                       : Phanendra Ketavarapu
	  Date of Preparation               : 10/07/2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verifies the display of categories according to the selection
	  Dependencies	                    : clickOn(userActions.get()),clickOnSubMenuItem(businessFunction.get().get()s),checkSelectedResources(businessFunction.get().get()s)
	  Reviewed By                       : --
	**/ 
	  @Test(description="Verify the Operation Services resource page",groups="Services")
		public void testOperationsServicesResources()
		{
			//Launch the avaya website
			getDriver().get(appConfig.getAppUrl());
			dynamicWait.get().waittillpageloads();
			//click on operation services link present under services from megamenu
			businessFunction.get().clickOnSubMenuItem("Services","OperationsServices","Operations_Services_Title");
			dynamicWait.get().waittillpageloads();
			businessFunction.get().deFocus();
			//click on resources tab
			userActions.get().clickOn("DocumentandVideos_tab");
			dynamicWait.get().waittillpageloads();
			businessFunction.get().deFocus();
			//select whitepapers category
			userActions.get().clickOn("Resources_WhitePapers");
			dynamicWait.get().waittillpageloads();
			//verify the results area 
			businessFunction.get().checkSelectedResources("Resources_ResultsArea");
		}
		
	 /** 
	 Author Name                       : Phanendra Ketavarapu
	 Date of Preparation               : 10/07/2014
	 Date of Modified                  : --
	 Methods Called                    : clickOn(Utilities)
	 Purpose of Method                 : Verifies social media icons displayed on footer section of Home page
	 Dependencies	                   : --
	 Reviewed By                       : --
	**/
	@Test(description="Home_Page_Global_Footer_Social Media Icons",groups="Home Page")
	public void testHomePageSocialMediaIcons() 
	{
		//Launch the avaya website
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		//verify social icons present on the home page
		businessFunction.get().socialIcons("FooterSocialIcons","Tag_Anchors","href");
    }
	/** 
	 Author Name                       : Phanendra Ketavarapu
	 Date of Preparation               : 10/07/2014
	 Date of Modified                  : --
	 Methods Called                    : clickOn(Utilities)
	 Purpose of Method                 : Verifies social media icons displayed on footer section of about avaya page
	 Dependencies	                   : --
	 Reviewed By                       : --
	**/
	@Test(description="About Avaya_Landing page_Social Media Icons",groups="About Avaya")
	public void testAboutAvayaSocialMediaIcons() 
	{
		//Launch the avaya website
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		//Click on About Avaya from megamenu
		userActions.get().clickOn("MegaMenuAboutAvaya");
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		//verify the social icons on the footer section of about avaya page
		businessFunction.get().socialIcons("FooterSocialIcons","Tag_Anchors","href");
	}
	
	/**
	 Author Name                       : Niharika K R 
	 Date of Preparation               : 11-07-2014
	 Date of Modified                  : --
	 Methods Called                    : checkUrl(String controlName) 
	 Purpose of Method                 : Verify the pretty Url for Home page
	 Dependencies                      : Jar files
	 Reviewed By                       : 
	 **/
	 
	@Test(description="Verify the pretty Url for Home page",groups="Home Page")
	public void testHomeUrl()
	{
		//Launching the Avaya Website
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		//Verify if butler bar is present
		verify.get().isElementDisplayed("ButlerBar");
		
	}
	
	/**
	 Author Name                       : Vinusha
	 Date of Preparation               : 11/07/2014
	 Date of Modified                  : --
	 Methods Called                    : isElementDisplayed(String controlName)
	 Purpose of Method                 : Verify Butler Bar is present in page
	 Dependencies                      : Jar files
	 Reviewed By                       : --
	**/
	@Test(description = "Verify Butler Bar is present in page",groups = "SEO page")
	public void testSEOLandingPageButlerBar(){
		//Launching the Avaya website
		getDriver().get(appConfig.getSeo_Url());
		//Verify butler bar is present in page
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		verify.get().isElementDisplayed("ButlerBar");
	}
	
	 /**
	 Author Name                      	: Sindhuja.P
	 Date of Preparation              	: 08/07/2014
	 Date of Modified                   : --
	 Methods Called                    	: clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle),checkUrl(String controlName),clickOn(String controlName)
	 Purpose of Method               	: Verify the pretty Url for Products Landing page-Unified Communication and Collaboration 
	 Dependencies                    	: Jar files
	 Reviewed By                        : --
	**/ 
	@Test(description="Verify the pretty Url for Products Landing page-Unified Communication and Collaboration",groups="Products")
	public void testProductsUnifiedCommunicationCollaboration() 
	{
	  	//Launching the Avaya Website
	  	getDriver().get(appConfig.getAppUrl());
	  	dynamicWait.get().waittillpageloads();
		// To click on Unified Communication and Collaboration from products sub
		// menu
		businessFunction.get().clickOnSubMenuItem("Products",
				"Products_Category1", "Products_Category1_Title");
	  	

	}
	    
	    
	 /** 
	    Author Name                       : Sindhuja
	    Date of Preparation               : 14/7/2014
	    Date of Modified                  : 
	    Methods Called                    : isTextPresent(Verify),check_css_property,pageAllignment(businessFunction.get().get())
	    Purpose of Method                 : Verify the See All Avaya Capabilities is displayed in the left side of the screen
	    Dependencies	                  : --
	    Reviewed By                       : --
	    TestCase name					  : wi01155379_Solution_PerspectivePod_HorizontalRule
	 **/

	@Test(description="Verify the See All Avaya Capabilities is displayed in the left side of the screen",groups="Home Page")
    public void testPerspectivePodHorizontalRule()
    {
    	// Launching the Avaya URL
    	getDriver().get(appConfig.getAppUrl());
    	dynamicWait.get().waittillpageloads();
    	//Verifying About Avaya page is opened or not
//    	verify.get().isTextPresent("AboutAvayaContacts");
    	//Verifying whether Horizontal line is displayed under Solutions and Perspective pods
    	businessFunction.get().checkCssProperty("HorizontalWidth", "border-top-width");
    	businessFunction.get().checkCssProperty("HorizontalColor", "border-top-color");
    	businessFunction.get().checkCssProperty("HorizontalStyle", "border-top-style");
    	//Verifying whether See All Avaya Capabilities text is displayed in the left side of the screen or not
    	businessFunction.get().pageAllignment("ButlerBar", "AvayaSeeAllCapabilities","equal");      	
    								
    }
	    
		/**
		  Author Name                       : Vinusha
		  Date of Preparation               : 15/7/2014
		  Date of Modified                  : --
		  Methods Called                    : deFocus(String controlName),isElementDisplayed(String controlName),clickOn(String controlName)
		  										checkFilterSelections(String controlName, String controlNameSelected, String countSelected)
		  										clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle)
		  Purpose of Method                 : Verify the Filter Search in Case Studies page under Product/Avaya Aura Platform
		  Dependencies	                    : Jar files
		  Reviewed By                       : --
		**/
	    @Test(description = "Verify the Filter Search in Case Studies page under Product/Avaya Aura Platform", groups ="Products")
		public void testProductsDetailPageCaseStudiesFilterSearch(){
			//Launching the Avaya website
			getDriver().get(appConfig.getAppUrl());
			//Hover on Product and Click on Avaya Aura Platform
			dynamicWait.get().waittillpageloads();
			businessFunction.get().deFocus();
			businessFunction.get().clickOnSubMenuItem("Products", "Products_AvayaAuraPlatform", "Products_AvayaAuraPlatform_Title");
			businessFunction.get().deFocus();
			dynamicWait.get().waittillpageloads();
			//To check whether Overview tab is selected by default
			businessFunction.get().checkSelectedTabActive("Products_AAP_ParentTab", "Products_AAP_Tabs_Child", "OVERVIEW");
			//Click on Case Studies
			userActions.get().clickOn("Products_CaseStudies");
			//Click on checkbox in Case Studies page
			dynamicWait.get().waittillpageloads();
			userActions.get().clickOn("CaseStudies_Industry_Healthcare");
			//Verify the count of the filter search result
			dynamicWait.get().waittillpageloads();
			businessFunction.get().checkFilterSelections("CaseStudies_IndustryCheckboxes", "CaseStudies_YourSelectionList1","CaseStudies_CountText1");
			
		}
		
		/**
		  Author Name                       : Phanendra Ketavarapu
		  Date of Preparation               : 14/07/2014
		  Date of Modified                  : --
		  Methods Called                    : isElementDisplayed(String controlName),deFocus(),isElementDisplayed(String controlName)
		  										checkChildElementsCountAferHover(String parentControlName, String tagName),
		  										VerifyBreadCrumb(String actualControlName, String expectedControlName)
		  Purpose of Method                 : Verify the Event Landing Page
		  Dependencies	                    : Jar files
		  Reviewed By                       : --
		 **/
		@Test(description = "Verify the Event Landing Page",groups="Events Page")
		public void testEventsLandingPage(){
			//Launching the Events Landing page
			getDriver().get(appConfig.getEventsUrl());
			//Check the Global Header
			dynamicWait.get().waittillpageloads();
			businessFunction.get().deFocus();
			verify.get().isElementDisplayed("Global_Header");
			//Check the Global Footer
			verify.get().isElementDisplayed("Global_Footer");
			//Navigate to footer section and hover the mouse on Quick links tab
			userActions.get().hoverOn("Home_QuickLinks");
			//check if list of elements are present under Quicklinks
			businessFunction.get().verifyMenuOrCategoryLinks("QuickLinks_ChildElements");
			businessFunction.get().deFocus();
			//Check the Breadcrumb in Events page
			businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "Events_BreadcrumbExpected","Tag_Anchors");
			//Check if Social Icons are present
			verify.get().isElementDisplayed("SocialIcons");
			//Check if the Twitter Widget is present
			verify.get().isElementDisplayed("Twitter_Widget");
			//Check if the Avaya Magazine Widget is present
			verify.get().isElementDisplayed("Avaya_Magazine_Widget");
			//Check if the Avaya Connected Blog Pod is present
			verify.get().isElementDisplayed("Avaya_Connected_Blog_Pod");
		}
		
		  /** 
		   Author Name                      : Vinusha Tanuku
		  Date of Preparation               : 16/07/2014
		  Date of Modified                  : --
		  Methods Called                    : 
		  Purpose of Method                 : Verify if the user is able to search Case Studies using invalid Details.
		  Dependencies                      : --
		  Reviewed By                       : --
		 
		 
		  **/
		
		@Test(description="Verify if the user is able to search Case Studies using invalid Details",groups="Products")
		public void testProductsCasestudySearchInvalidinput() 
		{
		//Launching the Avaya website
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		//click on the Products tab in the Megamenu
		businessFunction.get().clickOnSubMenuItem("Products","Products_AvayaAuraPlatform","Products_AvayaAuraPlatform_Title");
		//Click on Case Study tab
		userActions.get().clickOn("Products_AAP_CaseStudies_tab");
		//Verify if Case Studies Tab is Selected
		businessFunction.get().checkSelectedTabActive("Products_AAP_ParentTab", "Products_AAP_Tabs_Child", "CASE STUDIES");  
		//To enter the invalid data in the search box in the Products landing page
		userActions.get().enterText("Products_SearchBox","!@#");
		//To click on the search button
		userActions.get().clickOn("Products_AAP_CaseStudies_SearchButton");
		//Verify if Results are displayed right to the Search Pod
		businessFunction.get().pageAllignment("Products_AAP_CaseStudies_SearchByPod","Products_AAP_CaseStudies_SearchResults","right");
		//To check whether message is displayed under "Your Results" Section
		businessFunction.get().pageAllignment("Products_CaseStudies_YourResults","Products_CaseStudies_Invalidinput_SearchMessage","equal");
		//To check whether proper message is displayed
		verify.get().isTextPresent("Products_CaseStudies_YourResults");
		 
		}
		
		
	       /** 
	   		Author Name                       	: Vinusha Tanuku
	  		Date of Preparation               	: 12/06/2014
	      	Date of Modified                  	: --
	      	Methods Called                    	: ClickonMegaMenu_LandingPages(businessFunction.get().get()),isElementNotPresent(Verify)
	   		Purpose of Method                 	: Verify Products Landing Page_Chat Link
	  		Dependencies                    	: --
	      	Reviewed By                       	: --
	     
	      **/
	      @Test(description="Verify Products Landing Page_Chat Link",groups="Products")
	      public void testProductsLandingPageChatLink()
	      {
	     // Launch the Avaya.com URL
		getDriver().get(appConfig.getAppUrl());
		// Wait till page loads
		dynamicWait.get().waittillpageloads();
		// Navigate to the Products URL
		businessFunction.get().clickAndVerifyNavigation("Products",
				"Products_label");
		// Verify if Chat link is Present
		verify.get().isElementPresent("Products_Chatlink");
	}
			/**
		  Author Name                       : Niharika
		  Date of Preparation               : 16/07/2014
		  Date of Modified                  : --
		  Methods Called                    : deFocus(),isElementDisplayed(String controlName),
		  										pageAllignment(String relativeControlName, String controlName, String position),
		  										check_ChildElements(String controlName,String childElement),
		  										VerifyElementContainsText(String controlName, String controlNameExpected),
		  										clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle),
		  Purpose of Method                 : Verify the Case Studies page under Capabilities/Video Collaboration
		  Dependencies	                    : Jar files
		  Reviewed By                       : --
		**/
	      @Test(description = "Verify the Case Studies page under Capabilities/Video Collaboration",groups = "Case Studies page")
			public void testCapabiltiesDetailPageCaseStudies(){
	    	//Launching the Avaya website
				getDriver().get(appConfig.getAppUrl());
				//Hover on Capabilities and Click on Video Collaboration
				dynamicWait.get().waittillpageloads();
				businessFunction.get().deFocus();
				businessFunction.get().clickOnSubMenuItem("Solutions", "Network_Virtualization", "Network_Virtualization_Header");
				businessFunction.get().deFocus();
				//Click on Case Studies
				dynamicWait.get().waittillpageloads();
				userActions.get().clickOn("CaseStudies_Tab");
				//Check Narrow Results By is left aligned
				dynamicWait.get().waittillpageloads();
				businessFunction.get().pageAllignment("ButlerBar","Capabilities_VideoCollaboration_CaseStudies_Narrow_Results_By", "equal"); 
				businessFunction.get().pageAllignment("ButlerBar","CaseStudies_SearchCategories", "equal");
				//Check the filter categories 
				businessFunction.get().verifySubMenuElements("CaseStudies_SearchCategories", "Tag_Span",",");
				//Check Show All for more than 8 filter options
				businessFunction.get().verifyFilterOptionsSelected("CaseStudies_Customer_Filter", "CaseStudies_Customer_Text");
				businessFunction.get().verifyFilterOptionsSelected("CaseStudies_Industry_Filter", "CaseStudies_Industry_Text");
				businessFunction.get().verifyFilterOptionsSelected("CaseStudies_BusinessSize_Filter", "CaseStudies_BusinessSize_Text");
				//Check for Sort Result By
				verify.get().isElementDisplayed("CaseStudies_SortResultBy");
				//Check for the Count Case Studies message
				verify.get().verifyElementContainsText("CaseStudies_CountText", "CaseStudies_CountTextMessage");
				//Check for the Your Result section
				verify.get().isElementDisplayed("CaseStudies_YourResultsText");
				
			}
		/**
		  Author Name                       : Niharika
		  Date of Preparation               : 16/07/2014
		  Date of Modified                  : --
		  Methods Called                    : Click_VerifyNavigation,clickOn,isTextPresent,isElementPresent
		  Purpose of Method                 : Verify if global footer is present
		  Dependencies	                    : Jar files
		  Reviewed By                       : --
		 
		 
		**/
	    @Test(description="Verify if global footer is present", groups="Perspectives")
	    public void testPerspectivesMagazineGlobalFooter() {
	    	//navigate to app url
			getDriver().get(appConfig.getAppUrl());
			dynamicWait.get().waittillpageloads();
			//Click on 'Perspectives' tab of mega menu. System should navigate to Perspectives Landing Page
			businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "Perspectives_SubMenu", "PerspectivesTitlePage");
			//Click on Magazines and guides
			userActions.get().clickOn("Perspectives_addl_links_mags_guides");
			dynamicWait.get().waittillpageloads();
			//Magazines and guides Landing page is displayed
			verify.get().isTextPresent("Perspectives_mags_guides_titlepage");
			//verify.get() if the global footer is present global footer should be present at the bottom of the page
			verify.get().isElementPresent("GlobalFooter");		
			}
	    
		/**
		  Author Name                       : Niharika
		  Date of Preparation               : 16/07/2014
		  Date of Modified                  : --
		  Methods Called                    : Click_VerifyNavigation,clickOn,isTextPresent,isElementPresent
		  Purpose of Method                 : Verify if global footer is present
		  Dependencies	                    : Jar files
		  Reviewed By                       : --
		 
		 
		**/
		@Test(description="Verify if the bread crumb is present on Perspectives page",groups="Perspectives")
		public void testPerspectivesMagazineBreadCrumb() 
		{			
			//navigate to app url
	    	getDriver().get(appConfig.getAppUrl());
	    	dynamicWait.get().waittillpageloads();
	    	//Click on 'Perspectives' tab of mega menu System should navigate to Perspectives Landing Page
	    	businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "Perspectives_SubMenu", "PerspectivesTitlePage");
			userActions.get().clickOn("Perspectives_addl_links_mags_guides");
			verify.get().isTextPresent("Perspectives_mags_guides_titlepage");
			//Verify if the Bread crumb is present
			businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "Archives_Breadcrumb_Expected", "Tag_Anchors");			
		}
		
		
		/**
		  Author Name                       : Niharika K R 
		  Date of Preparation               : 18-07-2014
		  Date of Modified                  : --
		  Methods Called                    : isElementPresent(String controlName),checkUrl(String controlName)
		  Purpose of Method                 : Verify the navigation to the Terms of Use page from Home page
		  Dependencies	                    : Jar files
		  Reviewed By                       : 
		  **/
		
		@Test(description="Verify Terms Of Use link in the global footer of Avaya Home Page",groups="Home Page")
		public void testHomepageTerms()
		{
		// Launching the Avaya Website
		getDriver().get(appConfig.getAppUrl());
		businessFunction.get().deFocus();
		// To click on the Terms of Use link
		businessFunction.get().clickAndVerifyNavigation("Terms_of_Use",
				"TermsOfUseHeader");
		dynamicWait.get().waittillpageloads();
		// To check the Terms of Use URL after the navigation to the Terms of
		// Use page
		businessFunction.get().checkUrl("Terms_of_Page_URL","contains");
			
		}
		
		
		/**
		  Author Name                       : Niharika K R 
		  Date of Preparation               : 18-07-2014
		  Date of Modified                  : --
		  Methods Called                    : isElementPresent(String controlName),VerifyBreadCrumb(String actualControlName, String expectedControlName),isTitlePresent(String controlName)
		  Purpose of Method                 : Verify the content in the Terms of Use landing page
		  Dependencies	                    : Jar files
		  Reviewed By                       : 
		 
		 
		  **/
		
		@Test(description="Verify terms of use page",groups="Home Page")
		public void testHomepageTermsPage() 
		{
			// Launching the Avaya Website
			getDriver().get(appConfig.getAppUrl());
			businessFunction.get().deFocus();
			//To click on the Terms of Use link
			businessFunction.get().clickAndVerifyNavigation("Terms_of_Use", "TermsOfUseHeader");
			dynamicWait.get().waittillpageloads();
			//verifying the presence of BreadCrumb using the business function verifyBreadCrumb
			businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "Terms_Page_breadcrumb_expected","Tag_Anchors");
			//To verify the presence of Butler bar
			verify.get().isElementDisplayed("ButlerBar");
			//To verify the presence of Megamenu
			verify.get().isElementDisplayed("Mega_Menu");
			//To verify the presence of title Terms Of Use
			verify.get().isTextPresent("Terms_of_Use_Description");
			//To check whether the the footer is present or not
			verify.get().isElementDisplayed("Footer");
		}
		
		/**
		  Author Name                       : Niharika K R 
		  Date of Preparation               : 18-07-2014
		  Date of Modified                  : --
		  Methods Called                    : isElementPresent(String controlName),checkUrl(String controlName)
		  Purpose of Method                 : Verify the navigation to the Cookies page from Home page
		  Dependencies	                    : Jar files
		  Reviewed By                       : 
		  **/
		@Test(description="Verify Cookies link in the global footer of Avaya Home Page",groups="Home Page")
		public void testHomePageCookies() 
		{
			//Launching the Avaya Website
			getDriver().get(appConfig.getAppUrl());
			businessFunction.get().deFocus();
			//To click on the Cookies link
			userActions.get().clickOn("Cookies");
			dynamicWait.get().waittillpageloads();
			//To check the Cookies URL after the navigation to the Cookies page
			businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "Cookies_breadcrumb_expected","Tag_Anchors");
			
		}
		
		
		/**
		  Author Name                       : Niharika K R 
		  Date of Preparation               : 17-07-2014
		  Date of Modified                  : --
		  Methods Called                    : isElementPresent(String controlName),VerifyBreadCrumb(String actualControlName, String expectedControlName),isTextPresent(String controlName)
		  Purpose of Method                 : Verify the content in the Cookies landing page
		  Dependencies	                    : Jar files
		  Reviewed By                       : 
		  **/
		
		@Test(description="Verify Cookies page",groups="Home Page")
		public void testHomePageCookiesPage()
		{
			//Launching the Avaya Website
			getDriver().get(appConfig.getAppUrl());
			businessFunction.get().deFocus();
			//To click on the Cookies link
			userActions.get().clickOn("Cookies");
			dynamicWait.get().waittillpageloads();
			//To verify the presence of Butler bar
			verify.get().isElementDisplayed("ButlerBar");
			//To verify the presence of Megamenu
			verify.get().isElementDisplayed("Mega_Menu");
			//To verify the presence of title 
			businessFunction.get().contentValidation("Cookies_Description");
			//To check whether the the footer is present or not
			verify.get().isElementDisplayed("Footer");
			
		}
		
		
		/**
		  Author Name                       : Niharika K R 
		  Date of Preparation               : 17-07-2014
		  Date of Modified                  : --
		  Methods Called                    : isElementPresent(String controlName),checkUrl(String controlName)
		  Purpose of Method                 : Verify the navigation to the Cookies page from Home page
		  Dependencies	                    : Jar files
		  Reviewed By                       : 
		  **/
		
		@Test(description="Verify Privacy link in the global footer of Avaya Home Page",groups="Home Page")
		public void testHomePagePrivacy()
		{
			//Launching the Avaya Website
			getDriver().get(appConfig.getAppUrl());
			businessFunction.get().deFocus();
			//To click on the Privacy link
			userActions.get().clickOn("Privacy");
			dynamicWait.get().waittillpageloads();
			//verifying the presence of BreadCrumb using the business function verifyBreadCrumb
			businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "Privacy_breadcrumb_expected","Tag_Anchors");
		}
		/**
		  Author Name                       : Niharika K R 
		  Date of Preparation               : 18-07-2014
		  Date of Modified                  : --
		  Methods Called                    : isElementDisplayed(String controlName),VerifyBreadCrumb(String actualControlName, String expectedControlName),
		  									  isTextPresent(String controlName)
		  Purpose of Method                 : Verify the content in the Privacy landing page
		  Dependencies	                    : Jar files
		  Reviewed By                       : 
		  **/
		
		@Test(description="Verify Privacy page",groups="Home Page")
		public void testHomePagePrivacyPage()
		{
			//Launching the Avaya Website
			getDriver().get(appConfig.getAppUrl());
			//To click on the Privacy link
			userActions.get().clickOn("Privacy");
			dynamicWait.get().waittillpageloads();
			//To verify the presence of Butler bar
			verify.get().isElementDisplayed("ButlerBar");
			//To verify the presence of Megamenu
			verify.get().isElementDisplayed("Mega_Menu");
			//To verify the presence of title 
			businessFunction.get().contentValidation("Privacy_Description");
			//To check whether the the footer is present or not
			verify.get().isElementDisplayed("Footer");
		}
		
		
		
		/**
		  Author Name                       : Niharika K R 
		  Date of Preparation               : 18-07-2014
		  Date of Modified                  : --
		  Methods Called                    : clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle)
		  									  isElementDisplayed(String controlName),VerifyBreadCrumb(String actualControlName, String expectedControlName)
		  									  pageAllignment(String relativeControlName, String controlName, String position)
		  									  check_ChildElements(String controlName,String childElement),isTextPresent(String controlName)
		  Purpose of Method                 : Verify if the user is able to navigate to Operations Services page
		  Dependencies	                    : Jar files
		  Reviewed By                       : 
		 
		 
		  **/
		
		@Test(description="Verify if the user is able to navigate to Operations Services page",groups="Services")
		public void testOperationsServicesDetailedPage() 
		{
			//Launching the Avaya Website
			getDriver().get(appConfig.getAppUrl());
			//To click on the Operations Services link from the Services tab
			businessFunction.get().clickOnSubMenuItem("Services", "OperationsServices", "Operations_Services_Title");
			businessFunction.get().deFocus();
			//To check whether the Butler bar is been displayed or not
			verify.get().isElementDisplayed("ButlerBar");
			//To check whether the megamenu is been displayed or not
			verify.get().isElementDisplayed("Megamenu");
			//To verify the breadcrumb of the Operations Services page
			businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "Operations_Services_Breadcrumb_Expected","Tag_Anchors");
			//To verify tab menu with details Overview, Resources
			businessFunction.get().verifySubMenuElements("Operations_Services_Parent_Tab", "Tag_List",",");
			//To verify Overview title should  be displayed to the left side of the page
			businessFunction.get().pageAllignment("ButlerBar", "Operations_Services_Overview_Text_Title", "equal");
			//To verify whethet Overview Image is displayed to the right side of the page
			businessFunction.get().imageValidation("Operations_Services_Overview_Image");	
			businessFunction.get().pageAllignment("ButlerBar", "Operations_Services_Overview_Image", "right");
			//To verify whether a pod with  Spotlight title, Spotlight text & four resoucres pods is displayed to the right side of the page
			//businessFunction.get().pageAllignment("ButlerBar", "Operations_Services_Spotlight_Parent", "right");
			//To verify whether Title,Description & CTA are present in all the resource pod
			businessFunction.get().verifyPartnerAndProductPods("OperationsServices_Pods", "Tag_Anchors");
			//To verify whether "Explore Operations Services" SubCategory Menu Title is displayed
			verify.get().isTextPresent("Operations_Services_Explore");
			//To verify whether Category Image of resolution (555 x 286) should be displayed to the left side of the page
			businessFunction.get().imageValidation("Operations_Services_Category_Image");
			businessFunction.get().pageAllignment("ButlerBar", "Operations_Services_Category_ImageSection", "equal");
			//To verify whether Category Detailed links should be displayed to the right side of the page
			businessFunction.get().verifyMenuOrCategoryLinks("Operations_Services_Category_Links");
			businessFunction.get().pageAllignment("ButlerBar", "Operations_Services_Category_Links_All", "right");
			
		}
	  
		/**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 18-07-2014
	  Date of Modified                  : --
	  Methods Called                    : clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle),
	  									  pageAllignment(String relativeControlName, String controlName, String position)
	  									  checkSelectedTabActive(String controlName, String childElement,String str_selectedtabname)
	  									  isTextPresent(String controlName) 
	  Purpose of Method                 : Verify if the user is able to navigate to Resources page
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	  **/
	
	  @Test(description="Verify if the user is able to navigate to Resources page",groups="Products")
		public void testProductsResources()
		{
			//Launching the Avaya Website
			getDriver().get(appConfig.getAppUrl());
			//To click on the submenu Avaya Aura Platform from the Products tab
			businessFunction.get().clickOnSubMenuItem("Products", "Products_AvayaAuraPlatform", "Products_AvayaAuraPlatform_Title");
			businessFunction.get().deFocus();
			//To check whether the Overview tab is selected by default or not
			businessFunction.get().checkSelectedTabActive("Products_AAP_ParentTab", "Products_AAP_Tabs_Child", "OVERVIEW");
			//To click on the resources tab
			userActions.get().clickOn("DocumentandVideos_tab");
			businessFunction.get().deFocus();
			//To verify whether the Jump to category is present on the right side of the page or not
			businessFunction.get().pageAllignment("ButlerBar", "Products_Resources_JumpToCategory", "equal");
			//To verify the title Category
			verify.get().isTextPresent("Category_Header");
			//To verify whether the Category contains White Papers,Fact Sheets,Brochures,Tools,Videos elements
			businessFunction.get().contentValidation("Products_Category_Parent");
			//To verify whether resources by category are below text is present or not
			verify.get().isTextPresent("Products_DocumentsAndVideos_By_Category");
			//To verify whether the Resources tab has been selected or not
			businessFunction.get().checkSelectedTabActive("Products_AAP_ParentTab", "Products_AAP_Tabs_Child", "RESOURCES");
		}
	
	/**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 25-06-2014
	  Date of Modified                  : --
	  Methods Called                    : clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle),
	  									  pageAllignment(String relativeControlName, String controlName, String position)
	  									  checkSelectedTabActive(String controlName, String childElement,String str_selectedtabname)
	  									  isTextPresent(String controlName) 
	  Purpose of Method                 : Verify the user is able to navigate Service Detail resource page
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 **/

	  @Test(description="Verify the user is able to navigate Service Detail resource page",groups="Services")
		public void testServiceDetailResource()
		{
			//Launching the Avaya Website
			getDriver().get(appConfig.getAppUrl());
			//To click on the Contact Center Optimization from the Services tab
			businessFunction.get().clickOnSubMenuItem("Services", "ContactCenterOptimization", "ContactCenterOptimization_Title");
			businessFunction.get().deFocus();
			//To check whether the Overview tab has been selected or not 
			businessFunction.get().checkSelectedTabActive("Services_CCO_Parent_Tab", "Tag_List", "OVERVIEW");
			businessFunction.get().deFocus();
			//To click on the Resources tab
			userActions.get().clickOn("DocumentandVideos_tab");
			businessFunction.get().deFocus();
			//To verify whether the Jump To Category is present on the left side of the page or not
			businessFunction.get().pageAllignment("ButlerBar", "Services_Resources_JumpToCategory", "equal");
			//To verify whether the Category Title is present or not
			verify.get().isTextPresent("Category_Header");
			//To verify whether the Category contains White Papers,Brochures,Videos elements
			businessFunction.get().contentValidation("Services_Category_Parent");
			//To verify whether resources by category are below text is present or not
			verify.get().isTextPresent("Services_Resource_By_Category");
			//To verify whether the White Papers,Brochures,Videos elements are present on the right side of the page or not
			businessFunction.get().pageAllignment("ButlerBar", "Resources_Categories_All", "right");
				
		}
	
	
	/**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 18-07-2014
	  Date of Modified                  : --
	  Methods Called                    : clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle),
	  									  pageAllignment(String relativeControlName, String controlName, String position)
	  									  checkSelectedTabActive(String controlName, String childElement,String str_selectedtabname)
	  									  isTextPresent(String controlName),check_ChildElements(String controlName,String childElement)
	  Purpose of Method                 : Verify if the user is able to navigate to TECH SPECS page
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 **/

	@Test(description="Verify if the user is able to navigate to TECH SPECS page",groups="Products")
	public void testProductsTechSpecs()
	{
		//Launching the Avaya Website
		getDriver().get(appConfig.getAppUrl());
		businessFunction.get().clickOnSubMenuItem("Products", "Products_AvayaAuraPlatform", "Products_AvayaAuraPlatform_Title");
		businessFunction.get().deFocus();
		//To check whether the Overview tab is selected by default or not
		businessFunction.get().checkSelectedTabActive("Products_AAP_ParentTab", "Products_AAP_Tabs_Child", "OVERVIEW");
		businessFunction.get().deFocus();
		//To click on the Tech Specs tab 
		userActions.get().clickOn("TechSpecs");
		businessFunction.get().deFocus();
		//To verify whether the Tech Specs tab has been selected or not
		businessFunction.get().checkSelectedTabActive("Products_AAP_ParentTab", "Products_AAP_Tabs_Child", "TechSpecs");
		//To verify whether the Jump To Category is present on the left side of the page or not
		businessFunction.get().pageAllignment("ButlerBar", "Products_TechSpecs_JumpToCategory", "equal");
		//To verify whether the Category Title is present or not
		verify.get().isTextPresent("TechSpecs_CategoryHeader");
		businessFunction.get().verifySubMenuElements("TechSpecs_Category_Parent", "Tag_Anchors",",");
		//To verify whether the title is present on the page or not 
		verify.get().isTextPresent("Products_TechSpecs_Title");
		//To verify whether the text is present under Scalability section
		businessFunction.get().contentValidation("TechSpecs_Scalability_Description");
		//To verify whether the text is present under High Availability section
		businessFunction.get().contentValidation("TechSpecs_HighAvailability_Description");				
	}

	/**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 18-07-2014
	  Date of Modified                  : --
	  Methods Called                    : clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle),
	  									  pageAllignment(String relativeControlName, String controlName, String position)
	  									  checkSelectedTabActive(String controlName, String childElement,String str_selectedtabname)
	  									  isTextPresent(String controlName),check_ChildElements(String controlName,String childElement)
	  Purpose of Method                 : Verify if the user is able to navigate to Service Detail page
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 **/

	@Test(description="Verify if the user is able to navigate to Service Detail page",groups="Services")
	public void testServicesServiceDetails()
	{
		//Launching the Avaya Website
		getDriver().get(appConfig.getAppUrl());
		//To click on the Contact Center Optimization from the Services tab
		businessFunction.get().clickOnSubMenuItem("Services", "ContactCenterOptimization", "ContactCenterOptimization_Title");
		businessFunction.get().deFocus();
		//To check whether the Overview tab has been selected or not 
		businessFunction.get().checkSelectedTabActive("Services_CCO_Parent_Tab", "Tag_List", "OVERVIEW");
		//To click on the Service details tab
		userActions.get().clickOn("ServiceDetails");
		businessFunction.get().deFocus();
		businessFunction.get().pageAllignment("ButlerBar", "Services_ServicesDetails_JumpToCategory", "equal");
		//To verify whether the Category Title is present or not
		verify.get().isTextPresent("ServiceDetails_CategoryHeader");
		businessFunction.get().verifyMenuOrCategoryLinks("Services_ServiceDetails_Category_Parent");
		//To verify the  title Service details by category are below is present or not
		verify.get().isTextPresent("Services_ServicesDetails_Title");
		//To verify whether 'Business Operational Performance Management section','Call Center Solutions with Agent-assisted Operations Assessment and Improvement','Automated Experience Management','Performance and Analysis' is present on the right side of the page or not
		businessFunction.get().pageAllignment("ButlerBar", "ServiceDetails_Category_All", "right");
		
	}
	
	
	
	/**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 18-07-2014
	  Date of Modified                  : --
	  Methods Called                    : clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle),
	  									  checkSelectedTabActive(String controlName, String childElement,String str_selectedtabname)
	  									  checkSelectedResources(String controlName)
	  Purpose of Method                 : Verify if the user is able to Filter the Results on the Resources Page
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 **/

	@Test(description="Verify if the user is able to Filter the Results on the Resources Page",groups="Services")
	public void testServiceDetailResourceFilterCategory()
	{
		//Launching the Avaya Website
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		//To click on the Contact Center Optimization from the Services tab
		businessFunction.get().clickOnSubMenuItem("Services", "ContactCenterOptimization", "ContactCenterOptimization_Title");
		businessFunction.get().deFocus();
		//To check whether the Overview tab has been selected or not 
		businessFunction.get().checkSelectedTabActive("Services_CCO_Parent_Tab", "Tag_List", "OVERVIEW");
		//To click on the Resources tab
		userActions.get().clickOn("DocumentandVideos_tab");
		//To click on the chekbox peratining to whitepapers
		userActions.get().clickOn("Resources_WhitePapers");
		//To verify whether the details related to whitepapers is being displyed in the results section or not 
		businessFunction.get().checkSelectedResources("Resources_ResultsArea");
		
	}
	
	/**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 04/07/2014
	  Date of Modified                  : --
	  Methods Called                    : isTextPresent(String controlName) ,pageAllignment(String relativeControlName, String controlName, String position)
	                                      isElementDisplayed(String controlName),socialIcons(String controlName,String childElement,String attribute) 
	  Purpose of Method                 : Verify if the user is able to view share section in Case studies page
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/	
	
  @Test(description="Verify if the user is able to view share section in Case studies page",groups="Case Studies page")
  public void testCaseStudiesLandingPageShareSection() 
	{
		//Launching the Case Studies Landing page 
		getDriver().get(appConfig.getCaseStudiesUrl());
		dynamicWait.get().waittillpageloads();
		//To check if Case studies Landing page is displayed.
		verify.get().isTextPresent("CaseStudies_Title");
		//To Verify the share section present in the CaseStudies Landing page to the right of title
		businessFunction.get().pageAllignment("CaseStudies_Title", "CaseStudies_ShareSection", "right");
		//To verify if the Share section is  present with social media icons
		verify.get().isElementDisplayed("CaseStudies_Share");
		businessFunction.get().pageAllignment("CaseStudies_Share", "CaseStudies_SocialIcons", "right");
		businessFunction.get().socialIcons("CaseStudies_SocialIcons","CaseStudies_SocialIcons_Child","class");		
	}
	
	/**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 18-07-2014
	  Date of Modified                  : --
	  Methods Called                    : clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle),
	  									  checkSelectedTabActive(String controlName, String childElement,String str_selectedtabname)
	  									  checkChildWindow(String controlName),isTextPresent(String controlName) 
	  									  pageAllignment(String relativeControlName, String controlName, String position)
	  Purpose of Method                 : Verify if the user is able to Filter the Results on the Resources Page
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 
	 
	 **/

	@Test(description="Verify if the user is able to search for services using invalid input",groups="Services")
	public void testServiceDetailsCustomerSuccessInvalidSearch() 
	{
		//Launching the Avaya Website
		getDriver().get(appConfig.getAppUrl());
		//To click on the Contact Center Optimization from the Services tab
		businessFunction.get().clickOnSubMenuItem("Services", "ContactCenterOptimization", "ContactCenterOptimization_Title");
		businessFunction.get().deFocus();
		//To check whether the Overview tab has been selected or not 
		businessFunction.get().checkSelectedTabActive("Services_CCO_Parent_Tab", "Tag_List", "OVERVIEW");
		//To click on the case studies tab
		userActions.get().clickOn("CaseStudies_Tab");
		//To enter the invalid data in the search box in the Services detailed page
		userActions.get().enterText("Products_SearchBox","!@#");
		//To click on the search button
		userActions.get().clickOn("Products_AAP_CaseStudies_SearchButton");
		dynamicWait.get().waittillpageloads();
		//To check whether proper eroor messages are displayed
		verify.get().isTextPresent("CaseStudies_YourResultsText");

						
	}
	
	/**
	  Author Name                       : Phani 
	  Date of Preparation               : 18-07-2014
	  Date of Modified                  : --
	  Methods Called                    : isElementDisplayed(String controlName)
	  Purpose of Method                 : Verify if the Megamenu is present in the SEO landing page
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 **/

	@Test(description="Verify if the Megamenu is present in the SEO landing page",groups="SEO page")
	public void testSEOLandingPageMegaMenu()
	{
		//Launching the Avaya SEO page
		getDriver().get(appConfig.getSeo_Url());
		dynamicWait.get().waittillpageloads();
		//To verify whether the megamenu is present or not
		verify.get().isElementDisplayed("Megamenu");
		//To verify whether the Avaya Logo is present or not
		businessFunction.get().imageValidationAvayaLogo("AvayaLogo");
		//To verify whether Products, Services,Capabilities,Perspectives,Partners,About Avaya is present in the megamenu or not
		verify.get().isElementDisplayed("Products");
		verify.get().isElementDisplayed("Services");
		verify.get().isElementDisplayed("Solutions");
		verify.get().isElementDisplayed("CaseStudies_MegaMenu");
		verify.get().isElementDisplayed("Partners");
		verify.get().isElementDisplayed("MegaMenuAboutAvaya");
		
	}
	
	/** 
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 18/07/2014
	  Date of Modified                  : --
	  Methods Called                    : searchInvalidResults(String relativeControlName, String controlName),isTextPresent(String controlName) 
	  Purpose of Method                 : Verify if the user is able to search for invalid details
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	 
	 
	 **/
	@Test(description="Verify if the user is able to search for invalid details",groups="Products")
	public void testProductsLandingPageInvalidinput()  
	{
		//Launching the Avaya website
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		//click on the Products tab in the Megamenu and check the heading in the Products landing page.
		businessFunction.get().clickAndVerifyNavigation("Products", "Products_label");
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		//To enter the invalid data in the search box in the Products landing page
		userActions.get().enterText("Products_SearchBox","!@#");
		//To click on the search button
		userActions.get().clickOn("Products_SearchButton");
		dynamicWait.get().waittillpageloads();
		verify.get().isTextPresent("GlobalInvalidSearchMessage");
	}	
	
	/** 
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 17/07/2014
	  Date of Modified                  : --
	  Methods Called                    : check_ChildElements(String controlName,String childElement) 
	  Purpose of Method                 : Verify if the user is able to see Share Holder services on Avaya website
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	 **/	
	@Test(description="Verify if the user is able to see Share Holder services on Avaya website",groups="Investors")
	public void testInvestorsShareHolderServices() 
	{
		//Launching the Investors Avaya website
		getDriver().get(appConfig.getInvUrl());
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		//To check if Investors home page is be displayed
		verify.get().isTextPresent("Investors_Title");
		//To click on ShareHolderServices Tab
		userActions.get().clickOn("Investors_ShareHolderServices");
		//To check if menu is collapsed 
		businessFunction.get().checkCssProperty("Investors_ShareholderServicesSection", "display");
		//To check if the Arrow mark on the Tab is displayed pointing Downwards
		businessFunction.get().checkToggleMenuArrows("Investors_ShareHolderServices","Collapsed_Arrow","down");
	}	
	
	/**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 18/07/2014
	  Date of Modified                  : --
	  Methods Called                    : check_ChildElements(String controlName,String childElement),relativeAllignment(String relativeControlName,String controlName) 
	  Purpose of Method                 :Verify the search functionality in product landing page
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	 **/
	@Test(description="Verify the search functionality in product landing page",groups="Products")
	public void testProductsLandingPageFilterSearch() 
	{
		//Launching the Avaya website
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		//click on the Products tab in the Megamenu
		businessFunction.get().clickAndVerifyNavigation("Products", "Products_label");
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		//Click on the check box beside Security Option
		userActions.get().clickOn("Products_checkbox_Security");
		//To  check whether Security option is displayed beside Your Selections section
		businessFunction.get().pageAllignment("Products_YourSelections","Products_Security","right");
		//To check whether user is able to view Products under Sort Results Section
		businessFunction.get().pageAllignment("Products_SortResults_Section","Products_SecurityResults","equal");
		//To check whether user is able to view Products under "Security"
		businessFunction.get().checkSearchCount("Product_SearchResult","Product_SearchCount");
	}
	
	/**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 18/07/2014
	  Date of Modified                  : --
	  Methods Called                    : toggleMenuArrows(String controlName,String direction)
	  Purpose of Method                 :Verify the toggle functionality and direction of arrows in product landing page
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	 **/	
	@Test(description="Verify the toggle functionality and direction of arrows",groups="Products")
	public void testProductsLandingPageTogglemenu() 
	{
		//Launching the Avaya website
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		//click on the Products tab in the Megamenu
		businessFunction.get().clickAndVerifyNavigation("Products", "Products_label");
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		//Click on Business Need
	    userActions.get().clickOn("Products_BusinessNeed");
	    //To check whether Business Need Section is collapsing
	    businessFunction.get().checkCssProperty("Products_BusinessNeed_Collapsed","display");
	   	//To check if the arrow of Business Need Section is pointed towards downward 
	   	businessFunction.get().checkToggleMenuArrows("Products_BusinessNeed_Collapsed_Arrow","Collapsed_Arrow","down");
	   	//To check if the arrow of Product Search Section is pointed towards upward 
	   	businessFunction.get().checkToggleMenuArrows("Products_ProductSearch_Expanded_Arrow","Expanded_Arrow","up");
	   	//To check if the arrow of Product typeSection is pointed towards upward 
	   	businessFunction.get().checkToggleMenuArrows("Products_ProductType_Expanded_Arrow","Expanded_Arrow","up");
	   	//To check if the arrow of Business Size Section is pointed towards upward 
	   	businessFunction.get().checkToggleMenuArrows("Products_BusinessSize_Expanded_Arrow","Expanded_Arrow","up");		
	}
	
	
	/**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 18/07/2014
	  Date of Modified                  : --
	  Methods Called                    : Click_VerifyNavigation(String navigatetopage,String pageTitle)
	  Purpose of Method                 : Verify if the user is able to sort results by name
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	 **/
	@Test(description="Verify if the user is able to sort results by name",groups="Products")
	public void testProductsLandingPageSortbyName() 
	{
		//Launching the Avaya website
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		//click on the Products tab in the Megamenu and check the title in Products landing page
		businessFunction.get().clickAndVerifyNavigation("Products", "Products_label");
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		//To click on Name link
		userActions.get().clickOn("Products_Name");
		//To check if the products in the page are displayed in the Alphabetical order
		businessFunction.get().checkProductsSortByName("Products_All");	
	}
	
	/**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 18/07/2014
	  Date of Modified                  : --
	  Methods Called                    : pageAllignment(String relativeControlName, String controlName, String position),deFocus(String controlName)
	                                      check_ChildElements(String controlName,String childElement),clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle)
	  Purpose of Method                 : Verify the user is able to navigate to  resource page under Capabilties
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	 
	 
	 **/
	@Test(description="Verify the user is able to navigate to  resource page under Capabilties",groups="Solutions")
	public void testCapabiltiesDetailResources() 
	{
		//Launching the Avaya Website
        getDriver().get(appConfig.getAppUrl());
        //Hover on Capabilities and Click on Video Collaboration
        dynamicWait.get().waittillpageloads();
        businessFunction.get().deFocus();
        businessFunction.get().clickOnSubMenuItem("Solutions", "Megamenu_Industry_Vertical", "Explore_Industry_Vertical_Header");
        businessFunction.get().deFocus();
        businessFunction.get().clickAndVerifyNavigation("Hotels", "Hotels_Header");
        //To click on the Resources tab
        userActions.get().clickOn("DocumentandVideos_tab");
        //To verify whether the Category Title is present or not
        verify.get().isTextPresent("Category_Header");
        //To verify whether the Category contains White Papers,FactSheets ,Brochures,Videos elements
        businessFunction.get().verifySubMenuElements("Capabilities_ResourcesCategory_Parent","Child_Label_Items",",");
        //To verify whether "Document and Videos by category are below" text is present or not
        verify.get().isTextPresent("DocumentandVideos_By_Category");
        //To verify whether the White Papers,FactSheets ,Brochures,Videos elements are present on the right side of the page or not
        businessFunction.get().pageAllignment("ButlerBar", "Resources_WhitePapers", "right");
        businessFunction.get().pageAllignment("ButlerBar", "Resources_FactSheets", "right");
        businessFunction.get().pageAllignment("ButlerBar", "Resources_Brochures", "right");
        businessFunction.get().pageAllignment("ButlerBar", "Resources_Videos", "right");
		

	}	
	
	
	/**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 20/07/2014
	  Date of Modified                  : --
	  Methods Called                    : deFocus(String controlName),checkSelectedTabActive(String controlName, String childElement,String str_selectedtabname)
	                                      check_ChildElements(String controlName,String childElement),pageAllignment(String relativeControlName, String controlName, String position)
	                                      checkSearchCount(String selectionlist, String searchCriteria),enterText(String controlName,String text),clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle)
	  Purpose of Method                 : Verify if the user is able to search Case Studies using valid input
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	 **/
	@Test(description="Verify if the user is able to search Case Studies using valid input",groups="Products")
	public void testProductsDetailPageCaseStudiesSearch() 
	{
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		//Hover on the Products tab in the Megamenu and click on AvayaAuraPlatform from the menu and Check the presence of the title in Products Detailed Page
		businessFunction.get().clickOnSubMenuItem("Products","Products_AvayaAuraPlatform","Products_AvayaAuraPlatform_Title");
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		//To check whether Overview tab is selected by default
		businessFunction.get().checkSelectedTabActive("Products_AAP_ParentTab", "Tag_List", "OVERVIEW");
		//Click on Case studies tab
		businessFunction.get().deFocus();
		userActions.get().clickOn("Products_CaseStudies");
		//Verify if Case Studies Tab is Selected
		businessFunction.get().checkSelectedTabActive("Products_AAP_ParentTab", "Tag_List", "CASE STUDIES");
		//To enter valid input in the search box
		userActions.get().enterText("Products_SearchBox","Avaya");
		//To click on the Magnifier button
		businessFunction.get().deFocus();
		userActions.get().clickOn("CaseStudies_SearchButton");
		dynamicWait.get().waittillpageloads();
		//To check if "<Count> Case Studies match your search criteria" is  displayed
		verify.get().verifyElementContainsText("CaseStudies_Text", "CaseStudies_Message");
		//Verify if SortResultsBy Section is displayed 
		verify.get().isElementDisplayed("CaseStudies_SortResultsBySection");
		//Verify if Name is Present in SortResultsBy Section
		businessFunction.get().verifySubMenuElements("CaseStudies_SortResultsBy","Tag_Anchors",",");
		//To check if The number of  CASE STUDIES Search displayed in the text matches with results obtained in the results area
		businessFunction.get().checkSearchCount("CaseStudies_YourResults","CaseStudies_Count");
		//To check if results are  displayed  in the right side of the page
		businessFunction.get().pageAllignment("ButlerBar", "CaseStudies_ResultsSection", "right");		
	}
	
	/** 
	 Author Name                       : Phanendra Ketavarapu
	 Date of Preparation               : 20/07/2014
	 Date of Modified                  : --
	 Methods Called                    : clickOn(Utilities)
	 Purpose of Method                 : Verifies the latest news pod in about avaya page and click on the view 
	                                     newsroom link
	 Dependencies	                   : --
	 Reviewed By                       : --
	**/
	@Test(description="About Avaya_Landing page_Latest News Pod_View AvayaNewsroom link",groups="About Avaya")
	public void testNavigateToAvayaNewsRoom()
	{
		//Launch the avaya website
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		//Click on About avaya link from megamenu
		userActions.get().clickOn("MegaMenuAboutAvaya");
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		//verify the link navigation
		businessFunction.get().clickAndVerifyNavigation("AvayaNewsRoom_TabTitle","Newsroom_Title");
	
	}	
	/**
	  Author Name                       : Phanendra Ketavarapu
	  Date of Preparation               : 20/07/2014
	  Date of Modified                  : 
	  Methods Called                    : deFocus(),isElementDisplayed(String controlName),
	  										checkFilterSelections(String controlName, String controlNameSelected, String countSelected)
	  										clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle)
	  Purpose of Method                 : Verify the Filter Search in Case Studies page under Capabilities/Video Collaboration
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/
	@Test(description = "Verify the Filter Search in Case Studies page under Capabilities/Video Collaboration",groups = "Case Studies page")
	public void testCapabiltiesDetailPageCaseStudiesFilterSearch(){
		//Launching the Avaya website
				getDriver().get(appConfig.getAppUrl());
				//Hover on Capabilities and Click on Video Collaboration
				dynamicWait.get().waittillpageloads();
				businessFunction.get().deFocus();
				businessFunction.get().clickOnSubMenuItem("Solutions", "Network_Virtualization", "Network_Virtualization_Header");
				businessFunction.get().deFocus();
				//Click on Case Studies
				dynamicWait.get().waittillpageloads();
				userActions.get().clickOn("CaseStudies_Tab");
				//Click on Government State checkbox 
				dynamicWait.get().waittillpageloads();
//				userActions.get().clickOn("CaseStudies_BusinessSize_large");
//				dynamicWait.get().waittillpageloads();
				userActions.get().clickOn("CaseStudies_Industry_Healthcare");
				dynamicWait.get().waittillpageloads();
				businessFunction.get().checkFilterSelections("CaseStudies_IndustryCheckboxes", "CaseStudies_YourSelectionList","CaseStudies_CountText");

		
	}
	
	/**
	  Author Name                       : Phanendra Ketavarapu
	  Date of Preparation               : 20/07/2014
	  Date of Modified                  : --
	  Methods Called                    : deFocus(),isElementDisplayed(String controlName),
	  										clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle),
	  										checkSearchCount(String selectionlist, String searchCriteria),clickOn(String controlName),
	  										enterText(String controlName,String text)
	  Purpose of Method                 : Verify the Text Search in Case Studies page under Capabilities/Video Collaboration
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/
	@Test(description = "Verify the Text Search in Case Studies page under Capabilities/Video Collaboration", groups = "Solutions")
	public void testCapabiltiesDetailPageCaseStudiesSearch(){
		//Launching the Avaya website
		getDriver().get(appConfig.getAppUrl());
		//Hover on Capabilities and Click on Video Collaboration
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		businessFunction.get().clickOnSubMenuItem("Solutions", "Network_Virtualization", "Network_Virtualization_Header");
		businessFunction.get().deFocus();
		//Click on Case Studies
		dynamicWait.get().waittillpageloads();
		userActions.get().clickOn("CaseStudies_Tab");
		//Enter data in Search Box
		dynamicWait.get().waittillpageloads();
		userActions.get().enterText("CaseStudies_SearchBox", "Alliance");
		//Click on Magnifier Button
		userActions.get().clickOn("CaseStudies_SearchButton");
		//check the search count text
		dynamicWait.get().waittillpageloads();
		businessFunction.get().checkSearchCount("CaseStudies_YourReultsList","CaseStudies_CountText");

	}


	/**
	  Author Name                       : Phanendra Ketavarapu
	  Date of Preparation               : 20/07/2014
	  Date of Modified                  : --
	  Methods Called                    : deFocus(String controlName),isElementDisplayed(String controlName),clickOn(String controlName)
	  										checkFilterSelections(String controlName, String controlNameSelected, String countSelected)
	  										clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle)
	  Purpose of Method                 : Verify the Filter Search in Case Studies page under Services/Contact Center Optimization
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/
	@Test(description = "Verify the Filter Search in Case Studies page under Services/Contact Center Optimization", groups = "Services")
	public void testServiceDetailCustomerSuccessFilterSearch(){
		//Launching the Avaya website
		getDriver().get(appConfig.getAppUrl());
		//Hover on Service and Click on Contact Center Optimization
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		businessFunction.get().clickOnSubMenuItem("Services_MegaMenu", "ContactCenterOptimization", "ContactCenterOptimization_Title");
		businessFunction.get().deFocus();
		//To check whether Overview tab is selected by default
		dynamicWait.get().waittillpageloads();
		businessFunction.get().checkSelectedTabActive("Products_AAP_ParentTab", "Products_AAP_Tabs_Child", "OVERVIEW");
		//Click on Case Studies
		userActions.get().clickOn("Products_CaseStudies");
		//Click on checkbox in Case Studies page
		dynamicWait.get().waittillpageloads();
		userActions.get().clickOn("Transportation");
		//Verify the count of the filter search result
		dynamicWait.get().waittillpageloads();
		businessFunction.get().checkFilterSelections("CaseStudies_IndustryCheckboxes", "CaseStudies_YourSelectionList","CaseStudies_CountText");
		
	}
	
	/**
	  Author Name                       : Phanendra Ketavarapu
	  Date of Preparation               : 20/07/2014
	  Date of Modified                  : --
	  Methods Called                    : deFocus(String controlName),clickOn(String controlName),
	  										toggleMenuArrows(String actualControlName,String expectedControlName,String direction)
	  										clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle)
	  Purpose of Method                 : Verify the Our Customers Details page under About Avaya/Doing Business With You
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	 
	 **/
	@Test(description = "Verify the Our Customers Details page under About Avaya/Doing Business With You",groups = "About Avaya")
	public void testAboutAvayaOurCustomersDetails() {
		//Launching the Avaya website
		getDriver().get(appConfig.getAppUrl());
		//Click on Doing Business with you after Hovering on About Avaya
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "Doing_Business_With_Us", "Our_Customers_Title");
		businessFunction.get().deFocus();
		//Check the Our Customers pod displayed in expanded mode
		dynamicWait.get().waittillpageloads();
		businessFunction.get().checkToggleMenuArrows("AboutAvaya_Our_CustomersPod", "Expanded_Arrow", "up");
		//Check the Partners pod displayed in expanded mode
		businessFunction.get().checkToggleMenuArrows("AboutAvaya_PatnersPod", "Expanded_Arrow", "up");		
		//Check the Supplier Information pod displayed in expanded mode
		businessFunction.get().checkToggleMenuArrows("AboutAvaya_SupplierInformationPod", "Expanded_Arrow", "up");
		//Check the Investors Relations pod displayed in expanded mode
		businessFunction.get().checkToggleMenuArrows("AboutAvaya_InvestorRelationsPod", "Expanded_Arrow", "up");
		//Check the Case Studies pod displayed in expanded mode
		businessFunction.get().checkToggleMenuArrows("AboutAvaya_CaseStudies", "Expanded_Arrow", "up");
		businessFunction.get().deFocus();
		//Click on CaseStudies Pod
		userActions.get().clickOn("AboutAvaya_CaseStudies");
		//Check the Partners pod displayed is collapsed mode
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dynamicWait.get().waittillpageloads();
		businessFunction.get().checkToggleMenuArrows("AboutAvaya_CaseStudies", "Collapsed_Arrow", "down");				
	}
	
	/**
	  Author Name                       : Phanendra Ketavarapu
	  Date of Preparation               : 20/07/2014
	  Date of Modified                  : --
	  Methods Called                    : clickOn(String controlName),isElementDisplayed(String ControlName) ,pageAllignment(String relativeControlName, String controlName, String position)
	  Purpose of Method                 : Verifies Case studies text under products
	  Dependencies	                    : clickOn(userActions.get())
	  Reviewed By                       : --
	**/ 
	@Test(description="wi01155615_Products_Case Studies",groups="Products")
	public void testProductsCaseStudies()
	{
		//Launch the avaya website
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		//click on products from megamenu
		userActions.get().clickOn("Products");
		dynamicWait.get().waittillpageloads();
		userActions.get().clickOn("ViewAll");
		dynamicWait.get().waittillpageloads();
		//click on avaya aura platform product
		userActions.get().clickOn("AvayaAuraCallCenterElite");
		dynamicWait.get().waittillpageloads();
		//verify the case studies tab
		verify.get().isElementDisplayed("CaseStudies_Tab");
		//click on case stuides tab
		userActions.get().clickOn("CaseStudies_Tab");
		dynamicWait.get().waittillpageloads();
		//verify the text above the searchbox
		verify.get().isElementDisplayed("CaseStudies_TextAboveSearchbox");
		//verify the text present in the results area
		verify.get().verifyElementContainsText("Products_CaseStudies_Title", "CaseStudies_CountTextMessage");
	}
	
	/**
	  Author Name                       : Phanendra Ketavarapu
	  Date of Preparation               : 20/07/2014
	  Date of Modified                  : --
	  Methods Called                    : clickOn(String controlName),isElementDisplayed(String ControlName) ,pageAllignment(String relativeControlName, String controlName, String position)
	  Purpose of Method                 : Verifies Feedback button on home page
	  Dependencies	                    : clickOn(userActions.get())
	  Reviewed By                       : --
	 * @throws InterruptedException 
	 
	**/ 
	@Test(description="Home Page_Feedback",groups="Home Page")
	public void testHomePageFeedback() throws InterruptedException 
	{
		//Launch the avaya website
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		//Wait till the feedback widget load 
		Thread.sleep(20000);
		//click on Feedback button
		userActions.get().clickOn("HomePage_Feedback");
		dynamicWait.get().waittillpageloads();
		Thread.sleep(20000);
		//switch to frame
	    userActions.get().switchToFrame("HomePage_Feedback_Frame");
		dynamicWait.get().waittillpageloads();
	    //Select satisfied radio button
		userActions.get().clickOn("Feedback_Satisfied");
		dynamicWait.get().waittillpageloads();
		//enter comments
		userActions.get().enterText("Feedback_text","QA_Test_Automation_Feedback");
		//click on submit button
		userActions.get().clickOn("Feedback_Submit_Button");
		dynamicWait.get().waittillpageloads();
		//verify the thank you button
		verify.get().isTextPresent("Feedback_Thankyou_Message");
 }
	
	/**
	  Author Name                       : Phanendra Ketavarapu
	  Date of Preparation               : 20/07/2014
	  Date of Modified                  : --
	  Methods Called                    : clickOn(String controlName),isElementDisplayed(String ControlName) ,pageAllignment(String relativeControlName, String controlName, String position)
	  Purpose of Method                 : Verifies Feedback button on home page
	  Dependencies	                    : clickOn(userActions.get())
	  Reviewed By                       : --
	**/ 
	@Test(description="Verify whether the selected year news are displayed when clicked on the year from drop down",groups="About Avaya-Newsroom")
	public void testNewsRoomNewsReleaseFilter()
	{
		//Launching the NewsRoom URL 
		getDriver().get(appConfig.getNewsRoomUrl());
		dynamicWait.get().waittillpageloads();
		//To click on the more under news releases at the bottom of the page
		userActions.get().clickOn("NewsRoom_MoreLink");
		dynamicWait.get().waittillpageloads();
		//businessFunction.get().deFocus();
		//To verrify the navigation to the News Release page
		businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "NewsReleaseExpected","Tag_Anchors");
		//To click on the Select Range: Last 90 days drop down arrow
		userActions.get().clickOn("NewsRoom_SelectRange");
		//To verify the arrow pointing upward
		businessFunction.get().checkToggleMenuArrows("NewsRoom_SelectRange", "NewsRoom_SelectRangeExpected", "up");
		//To select 2012 link from the drop down
		userActions.get().clickOn("NewsRoom_SelectRange_2012");
		//To verify whether the news displayed only for the selected year.
		verify.get().verifyElementContainsText("SelectedYearList", "SelectedYearListExpected");
	}
	/**
	  Author Name                       : Phanendra Ketavarapu
	  Date of Preparation               : 20/07/2014
	  Date of Modified                  : --
	  Methods Called                    : clickOn(String controlName),isElementDisplayed(String ControlName) ,pageAllignment(String relativeControlName, String controlName, String position)
	  Purpose of Method                 : Verify the resources results area
	  Dependencies	                    : clickOn(userActions.get())
	  Reviewed By                       : --
	**/
	@Test(description="Capabilties_Detail Page_Resources_Filter_Category",groups="Solutions")
	public void testCapabilitiesResourceFilterCategory()
	{
		//Launching the Avaya Website
		getDriver().get(appConfig.getAppUrl());
		//Hover on Capabilities and Click on Video Collaboration
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		businessFunction.get().clickOnSubMenuItem("Solutions", "Network_Virtualization", "Network_Virtualization_Header");
		businessFunction.get().deFocus();
		//click on Resources tab
		userActions.get().clickOn("DocumentandVideos_tab");
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		//select whitepapers category 
		userActions.get().clickOn("Resources_WhitePapers");
		dynamicWait.get().waittillpageloads();
		//verify if the results are populated according to selection criteria
		businessFunction.get().checkSelectedResources("Resources_ResultsArea");

	}        
	
	/**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 20/07/2014
	  Date of Modified                  : --
	  Methods Called                    : Click_VerifyNavigation(String navigatetopage,String pageTitle),
	  									  isTextPresent(String controlName) 
	  Purpose of Method                 : Verify the Analysts tab
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	  **/
	@Test(description="Verify the Analysts tab",groups="About-Avaya")
	public void testContactsAnalysts()
	{
		// Launching the Avaya Website
		getDriver().get(appConfig.getAppUrl());
		// To click on Contacts tab in the footer
		businessFunction.get().clickAndVerifyNavigation("Contacts",
				"Contacts_Title");
		//verify if General,Media and Analyst Tabs presence
		businessFunction.get().verifySubMenuElements("Contacts_Pane", "Tag_Anchors", ",");
		// To click on the Analysts tab in Contacts page
		userActions.get().clickOn("ContactsAnalystsTab");
		dynamicWait.get().waittillpageloads();
		// To verify whether the details are present under Analysts Tab
		businessFunction.get().contentValidation("Contacts_Analysts_Text");
	}
	
	/**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 11-07-2014
	  Date of Modified                  : --
	  Methods Called                    :
	  Purpose of Method                 : Verify the Media tab
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	  **/
	
	@Test(description="Verify the Media tab",groups="About-Avaya")
	public void testContactsMedia()
	{
		//Launching the Avaya Website
		getDriver().get(appConfig.getAppUrl());
		//To click on Contacts tab in the footer
		businessFunction.get().clickAndVerifyNavigation("Contacts","Contacts_Title");
		//verify if General,Media and Analyst Tabs presence
		businessFunction.get().verifySubMenuElements("Contacts_Pane", "Tag_Anchors", ",");
		//To click on the Media tab in the Contacts page
		userActions.get().clickOn("ContactsMediaTab");
		//To verify whether the details are present under Media tab
		businessFunction.get().contentValidation("ContactsMediaText");
	}
	/**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 30/06/2014
	  Date of Modified                  : --
	  Methods Called                    : isElementNotPresent(String controlName),isTextPresent(String controlName)
	  Purpose of Method                 : Verify if the chat link is present in SDN
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	 
	 
	**/
	@Test(description="Verify if the chat link is present in SDN",groups="Products")
	public void testProductsSDNChatLink()  
	{
		//Launch the Software Defined Networking page
		getDriver().get(appConfig.getSdnUrl());
		dynamicWait.get().waittillpageloads();
		//To check if title is present
		verify.get().isTextPresent("SDN_Title");
		//To check if Chat link is not present
		verify.get().isElementNotPresent("Products_Chatlink");
				
	}
	/**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 20/07/2014
	  Date of Modified                  : --
	  Methods Called                    : clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle),checkSelectedTabActive(String controlName, String childElement,String str_selectedtabname) 
	                                      check_css_property(String controlName,String cssProperty) ,VerifyElementContainsText(String controlName, String controlNameExpected)
	                                      isElementDisplayed(String controlName),checkFilterOptionsCount(String controlName,String controlNameText ,String childControlName)
	                                      pageAllignment(String relativeControlName, String controlName, String position),check_ChildElements(String controlName,String childElement)
	  Purpose of Method                 : Verify the Content present under the Case Studies tab for a product
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/
	@Test(description="Verify the Content present under the Case Studies tab for a product",groups="Products")
	public void testProductCasestudies()
	{
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		//Hover on the Products tab in the Megamenu and click on AvayaAuraPlatform from the menu and Check the presence of the title in Products Detailed Page
		businessFunction.get().clickOnSubMenuItem("Products","Products_AvayaAuraPlatform","Products_AvayaAuraPlatform_Title");
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		//To check whether Overview tab is selected by default
		businessFunction.get().checkSelectedTabActive("Products_AAP_ParentTab", "Tag_List", "OVERVIEW");
		businessFunction.get().deFocus();
		//Click on Case studies tab
		userActions.get().clickOn("Products_CaseStudies");
		//Verify if Case Studies Tab is Selected
		businessFunction.get().checkSelectedTabActive("Products_AAP_ParentTab", "Tag_List", "CASE STUDIES");
		//To check whether "Narrow Results By" section is displayed in the left corner of the page
		businessFunction.get().pageAllignment("ButlerBar","CaseStudies_NarrowResultsBy","equal");
		//Check if Search, Customer,Industry,Business Size Catergories are Available
		businessFunction.get().verifySubMenuElements("CaseStudies_SearchCategories","Tag_Span",",");
		//Check if  Show All is displayed for more than 8 filter options
		businessFunction.get().verifyFilterOptionsSelected("CaseStudies_Customer_Filter", "CaseStudies_Customer_Text");
		businessFunction.get().verifyFilterOptionsSelected("CaseStudies_Industry_Filter", "CaseStudies_Industry_Text");
		businessFunction.get().verifyFilterOptionsSelected("CaseStudies_BusinessSize_Filter", "CaseStudies_BusinessSize_Text");
		//To check if "<Count> Customer Success match your criteria" is  displayed
		verify.get().verifyElementContainsText("CaseStudies_Text", "CaseStudies_Message");
		//To verify if SortResultsBy Section is displayed
		verify.get().isElementDisplayed("CaseStudies_SortResultsBySection");
		//To verify if SortResultsBy Section is displayed in red color
		businessFunction.get().checkCssProperty("CaseStudies_SortResultsBySection","background-color");
		//To verify if Name is Present in Sort By Container by Default
		businessFunction.get().verifySubMenuElements("CaseStudies_SortResultsBy","Tag_Anchors",",");
		//To check if the Your Result section is displayed
		verify.get().isElementDisplayed("CaseStudies_YourResults");
	}	
			
	/**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 20/07/2014
	  Date of Modified                  : --
	  Methods Called                    : deFocus(String controlName),checkSelectedTabActive(String controlName, String childElement,String str_selectedtabname)
	                                      checkSelectedResources(String controlName),clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle)
	  Purpose of Method                 : Verify if the user is able to Filter the Results on the Resources Page
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/	
	@Test(description="Verify if the user is able to Filter the Results on the Resources Page",groups="Products")
	public void testProductsDetailPageResourcesFilter() 
	{
		//Launching the Avaya Website
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		//Hover on the Products tab in the Megamenu and click on AvayaAuraPlatform from the menu and Check the presence of the title in Products Detailed Page
		businessFunction.get().clickOnSubMenuItem("Products","Products_AvayaAuraPlatform","Products_AvayaAuraPlatform_Title");
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		//To check whether Overview tab is selected by default
		businessFunction.get().checkSelectedTabActive("Products_AAP_ParentTab", "Products_AAP_Tabs_Child", "OVERVIEW");
		//To Click on the Resources tab 
		businessFunction.get().deFocus();
		userActions.get().clickOn("DocumentandVideos_tab");
		//Verify if  Resources Tab is Selected
		businessFunction.get().checkSelectedTabActive("Products_AAP_ParentTab", "Products_AAP_Tabs_Child", "RESOURCES");
		dynamicWait.get().waittillpageloads();
		//To click on the chekbox pertaining to whitepapers
		userActions.get().clickOn("Resources_WhitePapers");
		//To verify whether the details related to whitepapers is being displyed in the results section or not 
		businessFunction.get().checkSelectedResources("Resources_ResultsArea");		
	}
	/**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 20/07/2014
	  Date of Modified                  : --
	  Methods Called                    : isTextPresent(String controlName) ,checkSelectedTabActive(String controlName, String childElement,String str_selectedtabname),pageAllignment(String relativeControlName, String controlName, String position),clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle)
	  Purpose of Method                 : Verify if the user is able to search Case Studies using invalid Details
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	 
	 
	**/
	
	@Test(description="Verify if the user is able to search Case Studies using invalid Details",groups="Solutions")
	public void testCapabiltiesDetailPageCaseStudiesInvalidSearch()  
	{
		//Launching the Avaya Website
		getDriver().get(appConfig.getAppUrl());
		//Hover on Capabilities and Click on Video Collaboration
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		businessFunction.get().clickOnSubMenuItem("Solutions", "Network_Virtualization", "Network_Virtualization_Header");		
		businessFunction.get().deFocus();
		//Click on Case Studies
		dynamicWait.get().waittillpageloads();
		userActions.get().clickOn("CaseStudies_Tab");
		//Enter data in Search Box
		dynamicWait.get().waittillpageloads();
		//To check if Case studies tab is selected.
		businessFunction.get().checkSelectedTabActive("Capabilities_VC_ParentTab","Tag_List","CASE STUDIES");
		//To enter the invalid data in the search box
		userActions.get().enterText("Capabilities_SearchBox","!@#");
		//To click on the search button
		businessFunction.get().deFocus();
		userActions.get().clickOn("CaseStudies_SearchButton");
		dynamicWait.get().waittillpageloads();
		//To check if following message should be displayed "0 CASE STUDIES MATCH YOUR SEARCH CRITERIA"
		verify.get().isTextPresent("Capabilities_Message");
		//To check whether message is displayed under "Your Results" Section
		businessFunction.get().pageAllignment("Capabilities_YourResults","Capabilities_InvalidResult","equal");

	}
  
  /**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 20/07/2014
	  Date of Modified                  : --
	  Methods Called                    : clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle),checkUrl(String controlName) 
	  Purpose of Method                 : Verify if the correct url opened on click of contacts
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/  
	
	@Test(description="Verify if the correct url opened on click of contacts",groups="About-Avaya")
	public void testWorldWideDirectoryClickonContacts() 
	{
	  	//Launching the Avaya Website
	  	getDriver().get(appConfig.getAppUrl());
	  	dynamicWait.get().waittillpageloads();
	  	//To hover on AboutAvaya in Mega menu and click on WorldWide Directory
	  	businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "WorldwideDirectory", "WorldwideDirectory_Title");
	  	dynamicWait.get().waittillpageloads();
	  	businessFunction.get().deFocus();
	  	//To click on contacts link 
	  	userActions.get().clickOn("WorldWide_Contacts");
	  	//To check if page is navigated to contacts page
	  	businessFunction.get().checkUrl("Contacts_Url","contains");
	}
	
  /**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 07/07/2014
	  Date of Modified                  : --
	  Methods Called                    : clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle),isElementDisplayed(String controlName) 
	                                      Click_VerifyNavigation(String navigatetopage,String pageTitle)
	  Purpose of Method                 : Verify the content on click of any country  in World Wide Directory in About Avaya
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/   
	@Test(description="Verify the content on click of any country  in World Wide Directory in About Avaya",groups="About-Avaya")
	public void testWorldWideDirectoryClickOnCountry() 
	{
	  	//Launching the Avaya Website
	  	getDriver().get(appConfig.getAppUrl());
	  	dynamicWait.get().waittillpageloads();
	  	//To hover on AboutAvaya in Mega menu and click on WorldWide Directory
	  	businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "WorldwideDirectory", "WorldwideDirectory_Title");
	  	dynamicWait.get().waittillpageloads();
	  	businessFunction.get().deFocus();
	  	//To click on any country 
	  	businessFunction.get().clickAndVerifyNavigation("WorldwideDirectory_CountryArgentina", "WorldwideDirectory_CountryNameArgentina");
	  	//To check if Contact information Tab is present in the page.
	  	verify.get().isElementDisplayed("Country_ContactTab");
	  	//To check if mail and contact information is present in the page.
	  	businessFunction.get().contentValidation("Country_ContactTabDetails");
	  	//To check if Urls tab is present in the page.
	  	verify.get().isElementDisplayed("Country_UrlTab");
	  	//To check if Url of that specific country is present in the page.
	  	businessFunction.get().verifyMenuOrCategoryLinks("Country_Url"); 	
	}
	/**
  Author Name                       : Niharika K R 
  Date of Preparation               : 22-07-2014
  Date of Modified                  : --
  Methods Called                    : isTextPresent(String controlName),isElementDisplayed(String controlName),
  									  verify.get().BreadCrumb(String actualControlName, String expectedControlName),
  									  pageAllignment(String relativeControlName, String controlName, String position)	  									  	  									  
  Purpose of Method                 : verify.get(). the options  present in the left menu of Newsroom page
  Dependencies	                    : Jar files
  Reviewed By                       : 
  **/

	@Test(description="Verify the options  present in the left menu of Newsroom page",groups="About Avaya-Newsroom")
	public void testNewsRoomLeftMenu()
	{
		//Launching the Avaya Website
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		//To hover on the About Avaya tab which is present in the mega menu
		userActions.get().hoverOn("MegaMenuAboutAvaya");
		//To verify the list drop down with categories Company Overview,News And Events,Doing Business With Us,Careers,Contacts
		verify.get().isElementDisplayed("AboutAvaya_CompanyOverview");
		verify.get().isElementDisplayed("AboutAvaya_NewsAndEvents");
		verify.get().isElementDisplayed("AboutAvaya_DoingBusinessWithUs");
		verify.get().isElementDisplayed("AboutAvaya_Careers");
		verify.get().isElementDisplayed("AboutAvaya_Contacts");
		verify.get().isElementDisplayed("Perspectives_SubMenu");
		//To click on Newsroom link which is under the category News And Events
		businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya","AboutAvaya_NewsRoom", "Newsroom_Title");
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		//To verify the presence of options in the left menu such as NewsRoom,Avaya In The News,Media Kits,Industry Recognition,Events.
		verify.get().isElementDisplayed("AboutAvaya_NewsRoom_LeftMenu");
		verify.get().isElementDisplayed("AboutAvaya_AvayaInTheNews_LeftMenu");
		verify.get().isElementDisplayed("AboutAvaya_MediaKits_LeftMenu");
		verify.get().isElementDisplayed("AboutAvaya_IndustryRecognition_LeftMenu");
		verify.get().isElementDisplayed("AboutAvaya_Events_LeftMenu");
				
	}

/**
Author Name                       : Niharika K R
Date of Preparation               : 22/07/2014
Date of Modified                  : 02/09/2014
Methods Called                    : isElementNotPresent(String controlName),isTextPresent(String controlName)
Purpose of Method                 : verify.get(). if the chat link is present in IPV6
Dependencies	                    : Jar files
Reviewed By                       : --
 
 
**/

	@Test(description="Verify if the chat link is present in IPV6",groups="Products")
	public void testProductsIPV6ChatLink()  
	{
		//Launch the IPV6 page
		getDriver().get(appConfig.getIpv6Url());
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		//To check if title is present
		verify.get().isTextPresent("IPV6_Title");
		//To check if Chat link is not present
		verify.get().isElementNotPresent("Products_Chatlink");
	}

/** 
	 Author Name                       : Phanendra Ketavarapu
	 Date of Preparation               : 22/07/2014
	 Date of Modified                  : --
	 Methods Called                    : clickOn(Utilities),waittillpageloads(Dynamicwaits)
	 Purpose of Method                 : Verifies whether Header,description text,Learn more link present under company
	                                     Overview pod and clicks on Learn more link
	 Dependencies	                   : --
	 Reviewed By                       : --
	**/
	@Test(description="About Avaya_Landing page_Company OverView Pod_Learn More link",groups="About Avaya")
	public void testAboutAvayaCompanyOverviewPodLearnMoreLink() 
	{
		//Launch the avaya website
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		//Click on About Avaya from megamenu
		userActions.get().clickOn("MegaMenuAboutAvaya");
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		//verify the content under company overview pod1
		businessFunction.get().contentValidation("AboutAvayaTopPods_CompanyOverviewPod_Header");
		businessFunction.get().verifyPartnerAndProductPods("AboutAvayaTopPods_CompanyOverviewPod_Description","Tag_Anchors");								
		//click on learn more link under company overview pod
		userActions.get().clickOn("AboutAvayaTopPods_CompanyOverviewPodLearnMore");
		//verify the title is present
		businessFunction.get().contentValidation("Page_Title");									
	}
	
	
	/** 
	 Author Name                       : Phanendra Ketavarapu
	 Date of Preparation               : 22/07/2014
	 Date of Modified                  : --
	 Methods Called                    : clickOn(Utilities),waittillpageloads(Dynamicwaits)
	 Purpose of Method                 : Verifies whether Header,description text,Learn more link present under news 
	                                     and events pod and clicks on Learn more link
	 Dependencies	                   : --
	 Reviewed By                       : --
	**/
	@Test(description="About Avaya_Landing page_News and Events Pod_Learn More link",groups="About Avaya")
	public void testAboutAvayaNewsAndEventsPodLearnMoreLink() 
	{
		//Launch the avaya website
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		//Click on About Avaya from megamenu
		userActions.get().clickOn("MegaMenuAboutAvaya");
	    dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		//verify the content under News and Events pod
		businessFunction.get().contentValidation("AboutAvayaTopPods_NewandEventsPod_Header");
		businessFunction.get().verifyPartnerAndProductPods("AboutAvayaTopPods_NewandEventsPod_Description","Tag_Anchors");
		//click on learn more link under News and Events pod
		userActions.get().clickOn("AboutAvayaTopPods_NewandEventsPodLearnMore");
		//verify the title is present
		businessFunction.get().contentValidation("Page_Title");					
	}
	/** 
	 Author Name                       : Phanendra Ketavarapu
	 Date of Preparation               :  22/07/2014
	 Date of Modified                  : --
	 Methods Called                    : clickOn(Utilities),waittillpageloads(Dynamicwaits)
	 Purpose of Method                 : Verifies whether Header,description text,Learn more link present under doing
	                                     business with us pod
	 Dependencies	                   : --
	 Reviewed By                       : --
	**/
	@Test(description="About Avaya_Landing page_Doing Business With Us Pod",groups="About Avaya")
	public void testAboutAvayaDBWUPod() 
	{
		//Launch the avaya website
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		//Click on About Avaya from megamenu
		userActions.get().clickOn("MegaMenuAboutAvaya");
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		//verify the content under DBWU pod
		businessFunction.get().contentValidation("AboutAvayaTopPods_DBWUPod_Header");
		businessFunction.get().verifyPartnerAndProductPods("AboutAvayaTopPods_DBWUPod_Description","Tag_Anchors");
	}
	/** 
	 Author Name                       : Phanendra Ketavarapu
	 Date of Preparation               : 22/07/2014
	 Date of Modified                  : --
	 Methods Called                    : clickOn(Utilities),waittillpageloads(Dynamicwaits)
	 Purpose of Method                 : Verifies whether Header,description text,Learn more link present under doing
	                                     business with us pod and clicks on learn more link
	 Dependencies	                   : --
	 Reviewed By                       : --
	**/
	@Test(description="About Avaya_Landing page_Doing Business With Us Pod_Learn More link",groups="About Avaya")
	public void testAboutAvayaDBWUPodLearnMoreLink() 
	{
		//Launch the avaya website
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		//Click on About Avaya from megamenu
		userActions.get().clickOn("MegaMenuAboutAvaya");
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		//verify the content under DBWU pod
		businessFunction.get().contentValidation("AboutAvayaTopPods_DBWUPod_Header");
		businessFunction.get().verifyPartnerAndProductPods("AboutAvayaTopPods_DBWUPod_Description","Tag_Anchors");
		//click on learn more link under doing business with us pod
		userActions.get().clickOn("AboutAvayaTopPods_DBWUPodLearnMore");
		//verify the title is present
		businessFunction.get().contentValidation("Page_Title");								
	}
	
	/** 
	 Author Name                       : Phanendra Ketavarapu
	 Date of Preparation               : 22/07/2014
	 Date of Modified                  : --
	 Methods Called                    : clickOn(Utilities),waittillpageloads(Dynamicwaits)
	 Purpose of Method                 : Verifies whether Header,description text,Learn more link present under careers
	                                     pod and clicks on learn more link
	 Dependencies	                   : --
	 Reviewed By                       : --
	**/
	@Test(description="About Avaya_Landing page_Careers Pod_Learn More Link",groups="About Avaya")
	public void testAboutAvayaCareersPodLearnMoreLink() 
	{
		//Launch the avaya website
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		//Click on About Avaya from megamenu
		userActions.get().clickOn("MegaMenuAboutAvaya");
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		//verify careers pod
		businessFunction.get().contentValidation("AboutAvayaTopPods_CareersPod_Header");
		businessFunction.get().verifyPartnerAndProductPods("AboutAvayaTopPods_CareersPod_Description","Tag_Anchors");
		//click on learn more link under Career pod
		userActions.get().clickOn("AboutAvayaTopPods_CareersPodLearnMore");
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		//verify the title is present
		businessFunction.get().contentValidation("Page_Title");
	}
    /**
    Author Name                       : Vinusha
    Date of Preparation               : 22/07/2014
    Date of Modified                  : --
    Methods Called                    : clickAndVerifyNavigation(businessFunction.get().), waittillpageloads(DynamicWait)
    Purpose of Method                 : verify.get(). About Avaya Title is displaying in the main page or not
    Dependencies	                  : --
    Reviewed By                       : --
    **/

    @Test(description="Verify About Avaya Title is displaying in the main page or not",groups="About Avaya")
    public void testAbtAvayaLandTitle()
    {
    	// Launching the Avaya URL
		getDriver().get(appConfig.getAppUrl());				
		dynamicWait.get().waittillpageloads();			
		// Verifying the page title heading.
		businessFunction.get().clickAndVerifyNavigation("MegaMenuAboutAvaya","AboutAvayaLabel");
    	
    }
    /**
    Author Name                       : Vinusha
    Date of Preparation               : 22/07/2014
    Date of Modified                  : --
    Methods Called                    : clickOn(Utilities),waittillpageloads(DynamicWait),isElementPresent(verify.get().)
    Purpose of Method                 : verify.get().ing whether ImageTile is exist in the About Avaya page or not
    Dependencies	                    : --
    Reviewed By                       : --
    **/

    @Test(description="Verify if the user is able to view Image Title below the static image in About Avaya landing page",groups="About Avaya")
    public void testAbtAvayaImageTitleVerify()
    {
    	// Launching the Avaya URL
    	getDriver().get(appConfig.getAppUrl());
    	dynamicWait.get().waittillpageloads();
    	// Clicking on About Avaya tab
    	userActions.get().clickOn("MegaMenuAboutAvaya"); 	
    	dynamicWait.get().waittillpageloads();
    	// Verifying the Image Title.
    	businessFunction.get().contentValidation("AboutAvayaImageTitle");
    					
    }

    /** 
    Author Name                       : Vinusha
    Date of Preparation               : 22/07/2014
    Date of Modified                  : 
    Methods Called                    : isElementPresent(verify.get().)
    Purpose of Method                 : verify.get(). the home page of Avaya
    Dependencies	                  : --
    Reviewed By                       : --
    Test Case name					  : Avaya_Home_Page_Launch
    **/

    @Test(description="Verify the home page of Avaya",groups="Home Page")
  	public void testAvayaHomePage() {
      	// Launching the Avaya URL
      	getDriver().get(appConfig.getAppUrl());
      	dynamicWait.get().waittillpageloads();
      	//Verifying about avaya home page title
  		verify.get().isElementPresent("ButlerBar");
      									
      } 
	
	 /**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 14/07/2014
	  Date of Modified                  : 02/09/2014
	  Methods Called                    : Click_VerifyNavigation(String navigatetopage,String pageTitle),check_ChildElements(String controlName,String childElement,String delimiter)
	                                      checkSelectedTabActive(String controlName, String childElement,String str_selectedtabname)
	  Purpose of Method                 : Verify the Navigation menu in the Detail Page
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/
  
    @Test(description="Verify the Navigation menu in the Detail Page",groups="Phones")
	public void testPhonesDetailPageNavigationMenu()
	{
		//Launching the Avaya Website
	    getDriver().get(appConfig.getAppUrl());
	    dynamicWait.get().waittillpageloads();
	    //Hover on Products tab in Megamenu and Click on New Phones Page
	    businessFunction.get().clickOnSubMenuItem("Products", "NewPhonesPage", "NewPhonesPageHeading");
	    dynamicWait.get().waittillpageloads();
	    businessFunction.get().deFocus();
	    //To click on "Desktop Phones" Link 
	    businessFunction.get().clickAndVerifyNavigation("Phones_DesktopPhones", "DesktopPhones_Title");
	    dynamicWait.get().waittillpageloads();
	    businessFunction.get().deFocus();
	    //To click on "Learn More" Link and to check if detail page is displayed.
	    businessFunction.get().clickAndVerifyNavigation("1600Phones_LearnMore", "1600PhonesDetailPage_Title");
	    dynamicWait.get().waittillpageloads();
	    businessFunction.get().deFocus();
	    //To check if Navigation pane is present with tabs
	    businessFunction.get().verifySubMenuElements("1600DeskPhones_Tabs", "Tag_Anchors", ",");
	    //To check whether Overview tab is selected by default
	    businessFunction.get().checkSelectedTabActive("1600DeskPhones_TabSection", "Tag_List", "OVERVIEW");
	}
	
	/**
	Author Name                       : Vinusha
	Date of Preparation               : 22/07/2014
	Date of Modified                  : --
	Methods Called                    : clickOn(String controlName),isElementDisplayed(String ControlName) ,pageAllignment(String relativeControlName, String controlName, String position)
	Purpose of Method                 : verify.get(). the Widgets displayed in Perspective page in webpage
	Dependencies	                    : Jar files
	Reviewed By                       : --
	**/
	@Test(description = "Verify the Widgets displayed in Perspective page",groups = "Perspectives")
	public void testPerspectivesLandingPageWidgets(){
		//Launching the Avaya website
		getDriver().get(appConfig.getAppUrl());
		//Click on Perspective MegaMenu
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "Perspectives_SubMenu", "PerspectivesTitlePage");
		businessFunction.get().deFocus();
		//Check the Widgets
		dynamicWait.get().waittillpageloads();
		verify.get().isElementDisplayed("Perspectives_widget_mostPopularArticles");
		verify.get().isElementDisplayed("Perspectives_widget_Topics");
		verify.get().isElementDisplayed("Perspectives_widget_Pinterest");
		verify.get().isElementDisplayed("Perspectives_widget_AvayaMagazines");
		verify.get().isElementDisplayed("Perspectives _widget_twitter");
		verify.get().isElementDisplayed("Perspectives_widget_youtube");
		verify.get().isElementDisplayed("Perspectives_widget_facebook");
		verify.get().isElementDisplayed("Perspectives_widget_slideshare");
		verify.get().isElementDisplayed("Perspectives_widget_linkedin");
		verify.get().isElementDisplayed("Perspectives_widget_news");
		verify.get().isElementDisplayed("Perspectives_widget_additionalLinks");
		//Check the widgets are right aligned
		businessFunction.get().pageAllignment("ButlerBar", "Perspectives_widget", "right");
	}
	
	 /**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 11/07/2014
	  Date of Modified                  : --
	  Methods Called                    : clickOn(String controlName),isElementDisplayed(String controlName),checkNewsAndDate(String controlName,String dateChild,String newsChild)
	                                      clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle),
	  Purpose of Method                 : Verify the content in Avaya in the News page
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/
  
	@Test(description="Verify the content in Avaya in the News page",groups="About Avaya-Newsroom")
	public void testAvayaInTheNewsContent() 
	{
	    //Launching the Avaya Website
	    getDriver().get(appConfig.getAppUrl());
	    dynamicWait.get().waittillpageloads();
	    //To hover on About Avaya tab and click on NewsRoom link
	    businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "AboutAvaya_NewsRoom", "Newsroom_Title");
	    dynamicWait.get().waittillpageloads();
	    businessFunction.get().deFocus();
	    //To click on Avaya in the News link
	    userActions.get().clickOn("AvayaInTheNews_Link");
	    //To check the presence of Select Range
	    verify.get().isElementDisplayed("AvayaInTheNews_SelectRange");
	    userActions.get().clickOn("NewsRoom_SelectRange");
		userActions.get().clickOn("NewsRoom_SelectRange_2014");
	    //To check the presence of Show
	    verify.get().isElementDisplayed("AvayaInTheNews_Show");
	    //To check the presence of News links with date mentioned above the link
	    businessFunction.get().checkNewsAndDate("AvayaInTheNews_News", "Tag_Span", "Tag_Anchors");
	}

	/**
  Author Name                       : Niharika K R 
  Date of Preparation               : 15-07-2014
  Date of Modified                  : 02-09-2014
  Methods Called                    : clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle),
  									  Click_VerifyNavigation(String navigatetopage,String pageTitle),
  									  pageAllignment(String relativeControlName, String controlName, String position),
  									  verifyElementContainsText(String controlName, String controlNameExpected)
  Purpose of Method                 : Verify the content in media kits detail page.
  Dependencies	                    : Jar files
  Reviewed By                       : 
  **/

	@Test(description="Verify the content in media kits detail page",groups="About Avaya-Newsroom")
	public void testMediaKitsDetailPageContent()
	{
		//Launching the Avaya Website
		getDriver().get(appConfig.getAppUrl());
		businessFunction.get().deFocus();
		//To click on the Newroom submenu present under About Avaya menu
		businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "AboutAvaya_NewsRoom", "Newsroom_Title");
		businessFunction.get().deFocus();
		//To click on Media Kits link from the left menu in Newsroom landing page
		userActions.get().clickOn("AboutAvaya_MediaKits_LeftMenu");
		businessFunction.get().deFocus();
		businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "AboutAvayaMediaKitsExpected","Tag_Anchors");
		//To click on the Article Avaya IPOffice 8.1 Media Kit
		businessFunction.get().verifyArticleNavigation("AvayaIPOffice_MediaKit_Links", "AvayaIPOffice_MediaKit_Links_Title");
		//To verify whether the Avaya IPOffice 8.1 Media Kit title is present next to the Left Menu
		businessFunction.get().pageAllignment("NewsRoom_LeftMenu", "AvayaIPOffice_MediaKit_Links_Title", "right");
		//To verify whether the page contains related content or not
		businessFunction.get().contentValidation("AvayaIPOffice8.1MediaKitRelatedContent");
	}
	
	/**
	Author Name                       : Sowmya Mohanan
	Date of Preparation               : 04/07/2014
	Date of Modified                  : --
	Methods Called                    : checkNewsRoomContent(String controlName, String dateElements,String moreLink)
	Purpose of Method                 : Verify the NewsRoom Content in the page
	Dependencies	                    : Jar files
	Reviewed By                       : --
	 **/
	@Test(description = "Verify the NewsRoom Content in the page",groups = "About Avaya-Newsroom")
	public void testNewsroomAvayaIntheNewsContent(){
		//Launching the Avaya website
		getDriver().get(appConfig.getAppUrl());
		//Click on NewsRoom links present under About Avaya
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "AboutAvaya_NewsRoom", "Newsroom_Title");
		businessFunction.get().deFocus();
		//Check the NewsRoom Clickable Links, Date and More Link
		dynamicWait.get().waittillpageloads();
		businessFunction.get().checkNewsRoomContent("NewsRoom_ClickableLinks", "NewsRoom_Date");
	}
    /**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 22/07/2014
	  Date of Modified                  : --
	  Methods Called                    : clickOn(String controlName), clickAndVerifyNavigation(String navigatetopage,String pageTitle),isTextPresent(String controlName)
	                                      check_ChildElements(String controlName,String childElement,String delimiter),checkUrl(String controlName) 
	  Purpose of Method                 : Verify the General Contacts tab
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/
	@Test(description="Verify the General Contacts tab",groups="About-Avaya")
	public void testContactsGeneralContacts() 
	{
	    //Launching the Avaya Website
	    getDriver().get(appConfig.getAppUrl());
	    dynamicWait.get().waittillpageloads();
	    //To click on "Contacts" Link displayed in the Footer
	    businessFunction.get().clickAndVerifyNavigation("Contacts", "Contacts_Title");
	    //To verify if Navigation Paneis present with tabs
	    businessFunction.get().verifySubMenuElements("Contacts_Pane", "Tag_Anchors", ",");
	    //To click on "General Contacts" tab
	    userActions.get().clickOn("Contacts_GeneralContacts");
	    dynamicWait.get().waittillpageloads();
	    //To check the presence of "Corporate Headquarters" section with  details
	    businessFunction.get().contentValidation("CorporateHeadquarters_Section");
	    //To check the presence of "Other Contacts" section with links
	    businessFunction.get().verifyMenuOrCategoryLinks("OtherContacts_Section");
	    //To click on "Email Avaya" link
	    businessFunction.get().clickAndVerifyNavigation("EmailAvaya", "EmailAvaya_Title");
	    //To navigate back to the Contacts page.
	    getDriver().navigate().back();
	    dynamicWait.get().waittillpageloads();
	    //To click on All Local Offices on Contacts page
	    userActions.get().clickOn("Contacts_AllLocalOffices");
	    dynamicWait.get().waittillpageloads();
	    //To check the url of All Local Offices page
	    businessFunction.get().checkUrl("AllLocalOffices_Url","contains");
	    //To navigate back to the Contacts page
	    getDriver().navigate().back();
	    dynamicWait.get().waittillpageloads();
	    //To click on "Worldwide Directory" link
	    userActions.get().clickOn("Contacts_WorldWideDirectory");
	    dynamicWait.get().waittillpageloads();
	    //To check the url of Worldwide Directory page
	    businessFunction.get().checkUrl("Contacts_WorldWideDirectory_Url","contains");    
	}
	/**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 22/07/2014
	  Date of Modified                  : --
	  Methods Called                    : check_ChildElements(String controlName,String childElement),clickAndVerifyNavigation(String navigatetopage,String pageTitle)                                     
	  Purpose of Method                 : Verify the details present in the Our Customers Page
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/
	@Test(description="Verify the details present in the Our Customers Page",groups="About Avaya ")
	public void testAboutAvayaOurCustomersPods() 
	{
		//Launching the Avaya Website
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		//To click on About Avaya in Mega menu and check title in the page
		businessFunction.get().clickAndVerifyNavigation("MegaMenuAboutAvaya", "AboutAvayaLabel");
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		//To click on "Learn More" link under "Doing Business with us" 
		businessFunction.get().clickAndVerifyNavigation("DoingBusiness_LearnMore", "OurCustomers_Title");
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		//To verify the details in the pods
		businessFunction.get() .checkToggleMenuDetails("OurCustomers_Parent", "Tag_Anchors", "OurCustomers_Section",",");
		businessFunction.get() .checkToggleMenuDetails("Partners_Parent", "Tag_Anchors", "Partners_Section",",");
		businessFunction.get() .checkToggleMenuDetails("SupplierInformation_Parent", "Tag_Anchors", "SupplierInformation_Section",",");
		businessFunction.get() .checkToggleMenuDetails("InvestorRelations_Parent", "Tag_Anchors", "InvestorRelations_Section",",");
		businessFunction.get() .checkToggleMenuDetails("CaseStudies_Parent", "Tag_Anchors", "CaseStudies_Section",",");
	}
  
  /**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 03/07/2014
	  Date of Modified                  : --
	  Methods Called                    : isTextPresent(String controlName),check_ChildElements(String controlName,String childElement),isElementDisplayed(String controlName)
	  Purpose of Method                 : Verify the content in Email Avaya page
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
 
 
	**/
  @Test(description="Verify the content in Email Avaya page",groups="Email Avaya")
  public void testEmailAvayaContent()  
	{
	    //Launching the Email Avaya Page
	    getDriver().get(appConfig.getAvayaEmailUrl());
	    //To check if Email Avaya page is displayed
	    verify.get().isTextPresent("EmailAvaya_Title");
 	    //To check the presence of Global Header
	    verify.get().isElementDisplayed("Global_Header");
	    //To check the presence of Global Footer
	    verify.get().isElementDisplayed("GlobalFooter");
	    //To check the presence of Bread crumb
	    verify.get().isTextPresent("EmailAvaya_Breadcrumb");
	    businessFunction.get().checkMultipleCSSProperties("EmailAvaya_Parent_Fields", "color");
	    //To check if the attributes first name,country etc are present in the page
 	   	businessFunction.get().verifySubMenuElements("EmailAvaya_Parent", "Child_Label_Items",",");
	    //To check the presence of the Submit button 
	    verify.get().isElementDisplayed("EmailAvaya_Submit");   	
	}


	
	/**
	  Author Name                       : Vinusha
	  Date of Preparation               : 23/07/2014
	  Date of Modified                  : --
	  Methods Called                    : clickOn(String controlName),
	  									pageAllignment(String relativeControlName, String controlName, String position),
	  									isElementDisplayed(String controlName),checkChildElements(String controlName,String childElement)
	  Purpose of Method                 : Verify the Business Size filter in CaseStudies Landing Page
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	 **/
  @Test(description = "Verify the Business Size filter in CaseStudies Landing Page",groups = "Case Studies page")
	public void testCaseStudiesLandingPageBusinessSizeFilter(){
		//Launching the Case Studies Landing page
		getDriver().get(appConfig.getCaseStudiesUrl());
		//check the Business Size is aligned on the right side of the page
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		businessFunction.get().pageAllignment("ButlerBar", "CaseStudiesLandingPage_BusinessSizeSection", "right");
		//check the Business Size is present
		verify.get().isElementPresent("CaseStudiesLandingPage_BusinessSize");
		//Click on Large Link
		userActions.get().clickOn("CaseStudiesLandingPage_BusinessSize_Large");
		//Check the Your Selection is dispalyed below the Scrollable Bar
		dynamicWait.get().waittillpageloads();
		businessFunction.get().pageAllignment("CaseStudiesLandingPage_ScrollAble", "CaseStudiesLandingPage_YourSelection", "above");
		//Click on Small Link
		userActions.get().clickOn("CaseStudiesLandingPage_BusinessSize_Small");
		//Check the Your Selection is dispalyed below the Scrollable Bar
		dynamicWait.get().waittillpageloads();
		businessFunction.get().pageAllignment("CaseStudiesLandingPage_ScrollAble", "CaseStudiesLandingPage_YourSelection", "above");
		//Click on MidSize Link
		userActions.get().clickOn("CaseStudiesLandingPage_BusinessSize_Midsize");
		//Check the Your Selection is dispalyed below the Scrollable Bar
		dynamicWait.get().waittillpageloads();
		businessFunction.get().pageAllignment("CaseStudiesLandingPage_ScrollAble", "CaseStudiesLandingPage_YourSelection", "above");
		
	}
	
	
    /**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 23/07/2014
	  Date of Modified                  : --
	  Methods Called                    : clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle),isElementDisplayed(String controlName) 
	                                      clickAndVerifyNavigation(String navigatetopage,String pageTitle),isTextPresent(String controlName) 
	  Purpose of Method                 : Verify the content on click of any country  in World Wide Directory in About Avaya
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/ 
  @Test(description="Verify if the correct page title is present on click of any country in world wide locator home page",groups="About-Avaya")
	public void testWorldWideDirectoryPageTitleOnclickofCountry() 
	{
	  	//Launching the Avaya Website
	  	getDriver().get(appConfig.getAppUrl());
	  	dynamicWait.get().waittillpageloads();
	  	//To hover on AboutAvaya in Mega menu and click on WorldWide Directory
	  	businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "WorldwideDirectory", "WorldwideDirectory_Title");
	  	dynamicWait.get().waittillpageloads();
	  	businessFunction.get().deFocus();
	  	//To click on any country 
	  	businessFunction.get().clickAndVerifyNavigation("WorldwideDirectory_CountryArgentina", "WorldwideDirectory_CountryNameArgentina");
	  	//To check if Contact information Tab is present in the page.
	  	verify.get().isElementDisplayed("Country_ContactTab");
	  	//To check if mail and contact information is present in the page.
	  	businessFunction.get().contentValidation("Country_ContactTabDetails");
	  	//To check if Urls tab is present in the page.
	  	verify.get().isElementDisplayed("Country_UrlTab");
	  	//To check if Url of that specific country is present in the page.
	  	businessFunction.get().verifyMenuOrCategoryLinks("Country_Url"); 	
	}

    
    /**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 24/07/2014
	  Date of Modified                  : --
	  Methods Called                    : clickAndVerifyNavigation(String navigatetopage,String pageTitle),isTextPresent(String controlName),enterText(String controlName,String text) 
	  Purpose of Method                 : Verify the message displayed on entering invalid serach criteria on Perspectives Landing Page
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
     
     
	**/ 
  @Test(description="Verify the display of more than 24 articles on Perspectives Landing Page.",groups="Perspectives")
	public void testPerspectivesLandingPageInvalidSearch()  
	{
	  	//Launching the Avaya Website
	  	getDriver().get(appConfig.getAppUrl());
	  	dynamicWait.get().waittillpageloads();
	  	//To click on Perspectives tab of mega menu.
	  	businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "Perspectives_SubMenu", "PerspectivesTitlePage");
	  	dynamicWait.get().waittillpageloads();
	  	businessFunction.get().deFocus();
	  	//To enter "!@#$" in the search text box
	  	userActions.get().enterText("Products_SearchBox", "!@#$");
	  	//To click on the Search Image
	  	userActions.get().clickOn("Perspectives_SearchButton");
	  	dynamicWait.get().waittillpageloads();
	  	//To verify if "No Articles found" text is displayed
	  	verify.get().isTextPresent("Perspectives_SearchResult");  	
	}
    
    
	/**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 24-06-2014
	  Date of Modified                  : --
	  Methods Called                    : isElementDisplayed(String controlName),check_ChildElements(String controlName,String childElement)
	  									  check_css_property(String controlName, String cssProperty),clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle)
	  Purpose of Method                 : Verify the Content present under the Core Components tab
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	  **/
	
    @Test(description="Verify the Content present under the Core Components tab",groups="Solutions")
	public void testCapabilitiesDetailPageCoreComponents()
	{
		//Launching the Avaya Website
		getDriver().get(appConfig.getAppUrl());
		businessFunction.get().deFocus();
		//To click on the submenu Video Collaboration from the Capabilities tab and to verify the header
		businessFunction.get().clickOnSubMenuItem("Solutions", "Network_Virtualization", "Network_Virtualization_Header");
		businessFunction.get().deFocus();
		//To click on the Core Components tab
		userActions.get().clickOn("Capabilities_Core_Components");
		businessFunction.get().deFocus();
		//To check the CSS property background color 
		businessFunction.get().checkCssProperty("Capabilities_Category", "background-color");
		//To verify the presence of the child elements
		businessFunction.get().verifySubMenuElements("Capabilities_Category_Parent_Options", "Tag_Anchors",",");
		//To check the CSS property color 
		businessFunction.get().checkCssProperty("Infrastructure", "color");
		//To verify the presence of related items under respective categories
//		businessFunction.get().checkPresenceOfChildElements("Capabilities_Clients_and_Devices", "Capabilities_Child_List");
//		businessFunction.get().checkPresenceOfChildElements("Capabilities_Applications", "Capabilities_Child_List");
		businessFunction.get().checkPresenceOfChildElements("Capabilities_Infrastructure", "Capabilities_Child_List");
		businessFunction.get().checkPresenceOfChildElements("Capabilities_Services", "Capabilities_Child_List");
		//To verify whether the How to Buy pod is displayed or not
		verify.get().isElementDisplayed("Capabilities_How_to_Buy");
		businessFunction.get().contentValidation("Capabilities_How_to_Buy");
		verify.get().verifyElementContainsText("Capabilities_How_to_Buy", "Howtobuy_text");
		//To verify whether the Cross Sell content is displayed or not
		verify.get().isElementDisplayed("Capabilities_Cross_Sell_Content");
		businessFunction.get().contentValidation("Capabilities_Cross_Sell_Content");
		
	}
			
	
    /**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 24/07/2014
	  Date of Modified                  : --
	  Methods Called                    : clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle),checkSelectedTabActive(String controlName, String childElement,String str_selectedtabname) 
	                                      deFocus(),pageAllignment(String relativeControlName, String controlName, String position),check_ChildElements(String controlName,String childElement,String delimiter)
	                                      verifyElementContainsText(String controlName, String controlNameExpected),isElementDisplayed(String controlName),check_css_property(String controlName, String cssProperty)
	  Purpose of Method                 : Verify the details present on the Customer Success tab of Service Detail page
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/
    @Test(description="Verify the details present on the Customer Success tab of Service Detail page",groups="Services")
	public void testFDSServiceDetailCustomerSuccess() 
	{
	  	//Launching the Avaya Website
	  	getDriver().get(appConfig.getAppUrl());
	  	dynamicWait.get().waittillpageloads();
	  	//To click on the service "Contact Center Optimization" under Operations Services in mega menu
	  	businessFunction.get().clickOnSubMenuItem("Services", "ContactCenterOptimization", "ContactCenterOptimization_Title");
		businessFunction.get().deFocus();
		//To check whether the Overview tab has been selected or not 
		businessFunction.get().checkSelectedTabActive("Services_CCO_Parent_Tab", "Tag_List", "OVERVIEW");
		//To Click on the Case Studies tab 
		businessFunction.get().deFocus();
		userActions.get().clickOn("Services_CaseStudies_tab");
		//Verify if Case Studies Tab is Selected
		businessFunction.get().checkSelectedTabActive("Services_CCO_Parent_Tab", "Tag_List", "CASE STUDIES");
		//To check whether "Narrow Results By" section is displayed in the left corner of the page
		businessFunction.get().pageAllignment("ButlerBar","CaseStudies_NarrowResultsBy","equal");
		//Check if Search, Customer,Industry,Business Size Catergories are Available
		businessFunction.get().verifySubMenuElements("CaseStudies_SearchCategories","Tag_Span",",");
		//To check if "<Count> Customer Success match your criteria" is  displayed
		verify.get().verifyElementContainsText("ServicesCaseStudies_Text", "CaseStudies_Message");
		//Verify if SortResultsBy Section is displayed
		verify.get().isElementDisplayed("CaseStudies_SortResultsBySection");
		//Verify if SortResultsBy Section is displayed in red color
		businessFunction.get().checkCssProperty("CaseStudies_SortResultsBySection","background-color");
		//Verify if Name is Present in Sort By Container by Default
		businessFunction.get().verifySubMenuElements("CaseStudies_SortResultsBy","Tag_Anchors",",");
		//Check for the Your Result section
		verify.get().isElementDisplayed("CaseStudies_ResultsSection");	
	} 
    
	
	/** 
	 Author Name                       : Phanendra Ketavarapu
	 Date of Preparation               : 24/06/2014
	 Date of Modified                  : --
	 Methods Called                    : clickOn(Utilities),waittillpageloads(Dynamicwaits)
	 Purpose of Method                 : Verifies whether Header,description text,Learn more link present under careers
	                                     pod
	 Dependencies	                   : --
	 Reviewed By                       : --
	**/
    @Test(description="About Avaya_Landing page_Careers Pod",groups="About Avaya")
	public void testAboutAvayaCareersPod() 
	{
		//Launch the avaya website
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		//Click on About Avaya from megamenu
		userActions.get().clickOn("MegaMenuAboutAvaya");
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		//verify careers pod
		businessFunction.get().contentValidation("AboutAvayaTopPods_CareersPod_Header");
		businessFunction.get().verifyPartnerAndProductPods("AboutAvayaTopPods_CareersPod_Description","Tag_Anchors");
	}
	
	
    /** 
    Author Name                       : Phani
    Date of Preparation               : 24/07/2014
    Date of Modified                  : 
    Methods Called                    : clickOn(Utilities), isElementPresent(businessFunction)
    Purpose of Method                 : Verify if the user is able to view Image Title below the static image in About Avaya landing page
    Dependencies	                  : --
    Reviewed By                       : --
    Test Case name					  : About Avaya_Landing page_Image Title Link
    **/

	  @Test(description="Verify if the user is able to view Image Title below the static image in About Avaya landing page",groups="About Avaya")
	    public void testAbtAvayaImageTitleClick()
	    {
	    	// Launching the Avaya URL
	    	getDriver().get(appConfig.getAppUrl());
	    	dynamicWait.get().waittillpageloads();	
	    	// Clicking on About Avaya tab
	    	userActions.get().clickOn("MegaMenuAboutAvaya"); 	
	    	dynamicWait.get().waittillpageloads();	
	    	// Verifying the Image Title.    
	    	verify.get().isElementPresent("AboutAvayaImageTitle");	    	
	    							
	    } 
    
    /** 
    Author Name                       : Vinusha
    Date of Preparation               : 24/07/2014
    Date of Modified                  : --
    Methods Called                    : isTextPresent(Verify), clickAndVerifyNavigation,checkUrl(businessfunction)
    Purpose of Method                 : Verify whether navigation is successful to Active Represented Employee page
    Dependencies	                  : --
    Reviewed By                       : --
    Test Case name					  : wi01152055_Benefits_Active Represented Employee
     
     
    **/

	  @Test(description="Verify whether navigation is successful to Active Represented Employee page",groups="Benefits")
	    public void testBenefitsActiveRepresent() 
	    {
	    	// Launching the Avaya URL
	    	getDriver().get(appConfig.getBenefitsUrl());    	
	    	dynamicWait.get().waittillpageloads();	
	    	//Verifying Avaya Benefits home page		
	    	verify.get().isTextPresent("AvayaBenefitsHomePage");
	    	//Clicking on Active Represent link which is present in the Benefits Answers page
	  	businessFunction.get().clickAndVerifyNavigation("AvayaBenefitsActiveRepresent","AvayaBenefitsActRepresentHome");
	    	//Verifying Active Represent URL		
	  	businessFunction.get().checkUrl("AbtAvayaBenefitsActRepresURL","contains");
	    									
	    }   
    
    /** 
    Author Name                       : Sindhuja.P
    Date of Preparation               : 25/07/2014
    Date of Modified                  : 
    Methods Called                    : isTextPresent(Verify), clickAndVerifyNavigation,checkUrl(businessfunction)
    Purpose of Method                 : Verify whether navigation is successful to Retired Represented Employee page
    Dependencies	                    : --
    Reviewed By                       : --
    Test Case name					   : wi01152055_Benefits_Retired Represented Employee
     
     
    **/

	  @Test(description="Verify whether navigation is successful to Retired Represented Employee page",groups="Benefits")
		public void testBenefitsRetiredRepresent()  {
	    	// Launching the Avaya URL
	    	getDriver().get(appConfig.getBenefitsUrl());    	
	    	dynamicWait.get().waittillpageloads();
	    	//Verifying Avaya Benefits home page		
	    	verify.get().isTextPresent("AvayaBenefitsHomePage");
			// Clicking on Retired Represent link which is present in the Benefits
			// Answers page
			businessFunction.get().clickAndVerifyNavigation(
					"AvayaBenefitsRetiredRepresent",
					"AvayaBenefitsRetiredRepresentHome");
	    	//Verifying Active Represent URL		
			businessFunction.get().checkUrl("AbtAvayaBenefitsRetiredRepresURL",
					"contains");
	    									
	    }   
    
    /** 
    Author Name                       : Sindhuja.P
    Date of Preparation               : 25/07/2014
    Date of Modified                  : --
    Methods Called                    : isTextPresent(Verify)
    Purpose of Method                 : Verify the content in the benefits landing page
    Dependencies	                    : --
    Reviewed By                       : --
    Test Case name					   : wi01152055_Benefits_Landing Page_Content
    **/

    @Test(description="Verify the content in the benefits landing page",groups="Benefits")
  	public void testBenefitsLandPage() {
      	// Launching the Avaya URL
      	getDriver().get(appConfig.getBenefitsUrl());    	
      	dynamicWait.get().waittillpageloads();
      	//Verifying Avaya Benefits home page
      	verify.get().isTextPresent("AvayaBenefitsHomePage");
  		// Verify the Content Presence on the Landing page
  		businessFunction.get().contentValidation(
  				"BenefitsAnswers_LandingPage_Text");
  		;
      }   
    
    /**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 25/07/2014
	  Date of Modified                  : --
	  Methods Called                    : clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle),pageAllignment(String relativeControlName, String controlName, String position)
	                                      check_ChildElements(String controlName,String childElement,String delimiter)
	  Purpose of Method                 : Verify the content in left menu in clouds page
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/
  
	@Test(description="Verify the content in left menu in clouds page",groups="Cloud page")
	public void testCloudLeftMenu() 
	{
	  	//Launching the Avaya Website
	  	getDriver().get(appConfig.getAppUrl());
	  	dynamicWait.get().waittillpageloads();
	  	//To hover on products tab and click on Cloud link
	  	businessFunction.get().clickOnSubMenuItem("Products", "Products_Category4", "Products_Category4_Title");
	  	//To verify  left menu in the Cloud page is not present.
	  	verify.get().isElementNotDisplayed("Cloud_LeftMenu");
	  
	}
    
    
     /**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 25/07/2014
	  Date of Modified                  : --
	  Methods Called                    : clickOn(String controlName),isElementDisplayed(String controlName),isTextPresent(String controlName)
	  Purpose of Method                 : Verify whether WEBINARS AND VIRTUAL EVENTS widget is present in Conferences and Trade Shows page
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/
    
    @Test(description="Verify whether WEBINARS AND VIRTUAL EVENTS widget is present in Conferences and Trade Shows page",groups="Events Page")
	public void testEventsConferencesTradeShows() 
	{
		//Launching the Avaya website
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		//To hover on About Avaya tab which is present in the mega menu and click on Events link
		businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "AboutAvaya_Events", "Events_Title");
		//To click on SEE ALL link which is under Conferences and Trade Shows
		businessFunction.get().pageAllignment("ConferencesAndTradeShows", "ConferencesTradeShows_SeeAll", "above");
		userActions.get().clickOn("ConferencesTradeShows_SeeAll");
		//To verify whether WEBINARS AND VIRTUAL EVENTS widget is present or not
		verify.get().isElementDisplayed("WebinarsVirtualEvents_Widget");
		//To verify whether WEBINARS AND VIRTUAL EVENTS text is present on the widget
		verify.get().isTextPresent("WebinarsVirtualEvents");
	}
    
	/**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 25-07-2014
	  Date of Modified                  : 02-09-2014
	  Methods Called                    : clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle),
	  									  check_ChildElements(String controlName,String childElement,String delimiter),
	  									  Click_VerifyNavigation(String navigatetopage,String pageTitle)
	  Purpose of Method                 : Verify the content in Press Resources pod for both  landing and detail pages of media kits
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	  **/
	
    @Test(description="Verify the content in Press Resources pod for both  landing and detail pages of media kits",groups="About Avaya-Newsroom")
	public void testPressResourcesPodContent()
	{
		//Launching the Avaya Website
		getDriver().get(appConfig.getAppUrl());
		businessFunction.get().deFocus();
		//To click on the Newroom submenu present under About Avaya menu
		businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "AboutAvaya_NewsRoom", "Newsroom_Title");
		businessFunction.get().deFocus();
		//To click on Media Kits link from the left menu in Newsroom landing page
		userActions.get().clickOn("AboutAvaya_MediaKits_LeftMenu");
		businessFunction.get().deFocus();
		//To verify the content in Press Resources pod
		businessFunction.get().verifySubMenuElements("PressResourcesParent","Tag_Anchors", ",");
		businessFunction.get().verifyMenuOrCategoryLinks("PressResourcesParentLinks");
		//To click on the Article Avaya IPOffice 8.1 Media Kit
		businessFunction.get().verifyArticleNavigation("AvayaIPOffice_MediaKit_Links", "AvayaIPOffice_MediaKit_Links_Title");
		//To verify the content in Press Resources pod
		businessFunction.get().verifySubMenuElements("PressResourcesParent","Tag_List", ",");
		businessFunction.get().verifyMenuOrCategoryLinks("PressResourcesParentLinks");
	}
	
	
	/**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 16-07-2014
	  Date of Modified                  : --
	  Methods Called                    : verifyBreadCrumb(String actualControlName, String expectedControlName),
	  									  toggleMenuArrows(String actualControlName,String expectedControlName,String direction),
	  									  verifyElementContainsText(String controlName, String controlNameExpected)
	  Purpose of Method                 : Verify whether the selected year news are displayed when clicked on the year from drop down 
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	  **/
	
	@Test(description="Verify whether the selected year news are displayed when clicked on the year from drop down",groups="About Avaya-Newsroom")
	public void testNewsRoomAvayaInTheNewsFilter()
	{
		//Launching the NewsRoom URL 
		getDriver().get(appConfig.getNewsRoomUrl());
		//To click on the Avaya In the News link in the left menu
		userActions.get().clickOn("AboutAvaya_AvayaInTheNews_LeftMenu");
		businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "AvayaInTheNews_Expected","Tag_Anchors");
		//To click on the Select Range: Last 90 days drop down arrow
		userActions.get().clickOn("NewsRoom_SelectRange");
		//To verify the arrow pointing upward
		businessFunction.get().checkToggleMenuArrows("NewsRoom_SelectRange", "NewsRoom_SelectRangeExpected", "up");
		//To select 2012 link from the drop down
		userActions.get().clickOn("NewsRoom_SelectRange_2012");
		//To verify whether the news displayed only for the selected year.
		verify.get().verifyElementContainsText("SelectedYearList", "SelectedYearListExpected");
	}
	
	
	/**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 28/07/2014
	  Date of Modified                  : --
	  Methods Called                    : searchValidResults(String controlName,String keyword),isTextPresent(String controlName) 
	  Purpose of Method                 : Verify if the user is able to search for valid details
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/	
	
	@Test(description="Verify if the user is able to search for valid details",groups="Products")
	public void testProductsLandingPageValidinput() 
	{
		//Launching the Avaya website
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		//click on the Products tab in the Megamenu and check the heading in the Products landing page.
		businessFunction.get().clickAndVerifyNavigation("Products", "Products_label");
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		//To enter Avaya in the search box in the Products landing page
		userActions.get().enterText("Products_SearchBox","Avaya");
		//To click on the search button
		userActions.get().clickOn("Products_SearchButton");
		dynamicWait.get().waittillpageloads();
		//To check whether the products are being displayed with the keyword entered.
		businessFunction.get().searchValidResults("searchresults", "Avaya");	
	}
	
  	/**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 28/07/2014
	  Date of Modified                  : --
	  Methods Called                    : enterText(String controlName,String text),clickOn(String controlName), isTextPresent(String controlName) 
	                                      verifyElementContainsText(String controlName, String controlNameExpected),verifyElementsByCount(String controlName, int count)
	  Purpose of Method                 : Verify the Results per page functionality in GSA search page
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/
  
  	@Test(description="Verify the Results per page functionality in GSA search page",groups="GSA Search page")
  	public void testGSASearchResultsPerPage()
	{
		// Launching the Avaya Website
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		// To enter "Avaya" in the Search Text Box
		businessFunction.get().deFocus();
		userActions.get().enterText("AvayaHome_SearchBox", "Avaya");
		// To click on Search Icon
		userActions.get().clickOn("Search_Button_Test");
		// To check if user is able to view Global results Page
		verify.get().isTextPresent("ResultsPage_Title");
		// To click on 25 results per page
		userActions.get().clickOn("GSAPage_25");
		// To check if "showing 1-25 of xxxx results" is displayed
		verify.get().verifyElementContainsText("GSAPage_25_TextPage",
				"GSAPage_25_Text");
		// To check if 25 results are displayed on the page
		businessFunction.get().verifyElementsByCount("GSAPage_Results", 25);
		// To click on 50 results per page
		userActions.get().clickOn("GSAPage_50");
		// To check if "showing 1-25 of xxxx results" is displayed
		verify.get().verifyElementContainsText("GSAPage_50_TextPage",
				"GSAPage_50_Text");
		// To check if 50 results are displayed on the page
		businessFunction.get().verifyElementsByCount("GSAPage_Results", 50);
	}
  	
  	
	/**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 28/07/2014
	  Date of Modified                  : --
	  Methods Called                    : checkToggleMenuDetails(String parentControlName,String childElement,String controlName,String delimiter)
	                                      Click_VerifyNavigation(String navigatetopage,String pageTitle),isTextPresent(String controlName)   									  
	  Purpose of Method                 : Verify the options present under Unified Communications tab which is present in the left menu
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/

  	@Test(description="Verify if the user is able to see the content of Overview",groups="Investors")
	public void testInvestorsCorporateGovernanceDataPrivacyPolicyOverview() 
	{
		//Launching the Investors Avaya website
		getDriver().get(appConfig.getInvUrl());
		dynamicWait.get().waittillpageloads();
		//To verify the Links under the Corporate Governance tab
		businessFunction.get().verifyMenuOrCategoryLinks("Investors_CorporateGovernanceSectionLinks");
		//Click on Data Privacy Policy
		businessFunction.get().clickAndVerifyNavigation("Investors_DataPrivacyPolicy", "Investors_CorporateGovernance_Title");
		dynamicWait.get().waittillpageloads();
		//To verify the data present in Overview Section
		businessFunction.get().contentValidation("InvestorsDataPrivacyPolicy_OverviewText");
	}

	
  	/**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 28/07/2014
	  Date of Modified                  : 28/08/2014
	  Methods Called                    : clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle),clickOn(String controlName)
	                                      checkUrl(String controlName) 
	  Purpose of Method                 : Verify the logo Avaya The Power of We
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/
  
	@Test(description="Verify the logo Avaya The Power of We",groups="All pages")
	public void testAvayaPowerWeHomeNavigation()
	{
	    //Launching the Avaya Website
	    getDriver().get(appConfig.getAppUrl());
	    dynamicWait.get().waittillpageloads();
	    //To hover on Products in the meaga menu and click on any product
	    businessFunction.get().clickOnSubMenuItem("Products","Products_AvayaAuraPlatform","Products_AvayaAuraPlatform_Title");
	    //Click on Avaya The Power of We to the left of the mega menu
	    userActions.get().clickOn("AvayaPowerOfWe");
	    dynamicWait.get().waittillpageloads();
	    //To check if Avaya Home Page is displayed.
	    businessFunction.get().checkUrl("AvayaHome_Url","contains");
	    //To hover on Services in the mega menu and click on any link under Professional services
	    businessFunction.get().clickOnSubMenuItem("Services", "ContactCenterOptimization", "ContactCenterOptimization_Title");
	    //Click on Avaya The Power of We to the left of the mega menu
	    userActions.get().clickOn("AvayaPowerOfWe");
	    dynamicWait.get().waittillpageloads();
	    //To check if Avaya Home Page is displayed.
	    businessFunction.get().checkUrl("AvayaHome_Url","contains");
	    //Hover on perspective under the About mega menu 
	    businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya",
				"Perspectives_SubMenu", "PerspectivesTitlePage");
	    //Click on Avaya The Power of We to the left of the mega menu
	    userActions.get().clickOn("AvayaPowerOfWe");
	    dynamicWait.get().waittillpageloads();
	    //To check if Avaya Home Page is displayed.
	    businessFunction.get().checkUrl("AvayaHome_Url","contains");	    
	}
	
	/**
	  Author Name                       : Vinusha
	  Date of Preparation               : 28/07/2014
	  Date of Modified                  : --
	  Methods Called                    : clickOn(String controlName),isElementDisplayed(String controlName)
	  									isTextPresent(String controlName)
	  Purpose of Method                 : Verify that Webinar and Virtual Events page
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/
	@Test(description = "Verify that Webinar and Virtual Events page",groups = "Events Page")
	public void testEventsWebinarsAndVirtualEvents(){
		//Launching the Events Landing page
		getDriver().get(appConfig.getEventsUrl());
		//Click on SEE ALL under Webinar and Virtual Events
		dynamicWait.get().waittillpageloads();
		userActions.get().clickOn("Webinars_and_VirtualEvents_SeeAll");
		//Check the Conferences and Trade Show Widget is present
		dynamicWait.get().waittillpageloads();
		verify.get().isElementDisplayed("Conferences_and_TradeShows_Widget");
		//Check the Conferences and Trade Show Widget text
		verify.get().isTextPresent("Conferences_and_TradeShows");
	}
	/**
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 10/07/2014
	  Date of Modified                  : --
	  Methods Called                    : clickOn(String controlName)
	  									sendinputdata(String controlName, String option, String searchControlName)
	  Purpose of Method                 : Verify whether error message is displayed if the form is incompletely filled and submitted
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/
	@Test(description = "Verify whether error message is displayed if the form is incompletely filled and submitted",groups = "Email Avaya")
	public void testEmailAvayaWarningMessage(){
		//Launching the Email Avaya page
		getDriver().get(appConfig.getAvayaEmailUrl());
		//Enter details in Subscribe Form
		dynamicWait.get().waittillpageloads();
		businessFunction.get().sendinputdata("EmailInputData", "emailAvaya","none");
		userActions.get().clickOn("Email_Submit");
	}
	
	/**
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 28/07/2014
	  Date of Modified                  : --
	  Methods Called                    : checkNewsRoomContent(String controlName, String dateElements,String moreLink)
	  Purpose of Method                 : Verify the NewsRoom Content in the page
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	 **/
	@Test(description = "Verify the NewsRoom Content in the page",groups = "About Avaya-Newsroom")
	public void testNewsroomNewsReleasesContent(){
		//Launching the Avaya website
		getDriver().get(appConfig.getAppUrl());
		//Click on NewsRoom links present under About Avaya
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "AboutAvaya_NewsRoom", "Newsroom_Title");
		businessFunction.get().deFocus();
		//Check the NewsRoom Clickable Links, Date and More Link
		dynamicWait.get().waittillpageloads();
		businessFunction.get().checkNewsRoomContent("NewsRoom_ClickableLinks", "NewsRoom_Date");		
	}
	
	/**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 17-07-2014
	  Date of Modified                  : 10-09-2014
	  Methods Called                    : clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle),
	  									  verifyBreadCrumb(String actualControlName, String expectedControlName,String tagName),
	  									  isTextPresent(String controlName)
	  Purpose of Method                 : Verify whether navigation is successful to related article page
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	  **/
	
	@Test(description="Verify whether navigation is successful to related article page",groups="About Avaya-Newsroom")
	public void testAvayaInTheNewsReadTheArticle()
	{
		//Launching the Avaya Website
		getDriver().get(appConfig.getAppUrl());
		businessFunction.get().deFocus();
		//To click on the Newroom submenu present under About Avaya menu
		businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "AboutAvaya_NewsRoom", "Newsroom_Title");
		//To click on the Avaya In the News link in the left menu
		businessFunction.get().deFocus();
		userActions.get().clickOn("AboutAvaya_AvayaInTheNews_LeftMenu");
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		//To verify the navigation to the Avaya In The News page
		businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "AvayaInTheNews_Expected","Tag_Anchors");
		//To click on the article "Avaya Expands Line of Collaboration Pods"
		businessFunction.get().deFocus();
		userActions.get().clickOn("NewsRoom_SelectRange");
		userActions.get().clickOn("NewsRoom_SelectRange_2014");
		businessFunction.get().verifyArticleNavigation("AvayaIPOffice_MediaKit_Links", "AvayaIPOffice_MediaKit_Links_Title");
		//To click on Read the Article link
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		businessFunction.get().validateReadTheArticleLink("ReadTheArticleLink");		
	}
	
	  /** 
    Author Name                       : Sivanag
    Date of Preparation               : 21/7/2014
    Date of Modified                  : 10/09/2014
    Methods Called                    : verifyMenuOrCategoryLinks(String controlName),clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle)
    									checkToggleMenuArrows(String actualControlName,String expectedControlName,String direction)
    Purpose of Method                 : Verify the options present under Financing tab
    Dependencies	                  : --
    Reviewed By                       : --
    Test Case Name					  :  wi01173950_Promotions & Programs_Financing tab_options
    **/
    
  	@Test(description=" Verify if latest news releases are displaying under News Releases",groups="Promotions & Programs")
    public void testPromotionsProgramsFinanceTab()
    {
  		//Launching the Avaya Website
  		getDriver().get(appConfig.getAppUrl());
  		dynamicWait.get().waittillpageloads();
  		//Navigate to footer section and hover the mouse on Quick links tab
  		userActions.get().hoverOn("Home_QuickLinks");
  		//To check if options are displayed when hovered on Quick Links
  		businessFunction.get().verifyMenuOrCategoryLinks("QuickLinks_ChildElements");
  		//To click on Promotions & Programs link
  		businessFunction.get().clickOnSubMenuItem("Home_QuickLinks", "PromotionsAndPrograms", "PromotionsAndPrograms_Title");
  		businessFunction.get().deFocus();
    	dynamicWait.get().waittillpageloads();  
    	businessFunction.get().verifyMenuOrCategoryLinks("PromotionsProgramsFinancing_MenuItems");
    	//To verify the arrow pointing upwards
    	businessFunction.get().checkToggleMenuArrows("PromotionsProgramsFinancingArrow", "Expanded_Arrow", "up");
    	//To click on the Financing tab
    	userActions.get().clickOn("PromotionsProgramsFinancingArrow");
    	//To verify the arrow pointing downwards
    	businessFunction.get().checkToggleMenuArrows("PromotionsProgramsFinancingArrow", "Collapsed_Arrow", "down");
    }
  	
  	 /** 
    Author Name                       : Sivanag
    Date of Preparation               : 21/7/2014
    Date of Modified                  : 10/09/2014
    Methods Called                    : verifyMenuOrCategoryLinks(String controlName),clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle)
    									clickAndVerifyNavigation(String navigatetopage,String pageTitle),verifyBreadCrumb(String actualControlName, String expectedControlName,String tagName)
    									contentValidation(String controlName),imageValidation(String imageControlName)
    Purpose of Method                 : Verify the content in Government Education and Medical (G.E.M)
    Dependencies	                  : --
    Reviewed By                       : --
    **/
    
  @Test(description="Verify the content in Government Education and Medical (G.E.M)",groups="Promotions & Programs")
    public void testPromotionsProgramsGEM()
    {
	  	//Launching the Avaya Website
	    getDriver().get(appConfig.getAppUrl());
	    dynamicWait.get().waittillpageloads();
	    //Navigate to footer section and hover the mouse on Quick links tab
	    userActions.get().hoverOn("Home_QuickLinks");
	    //To check if options are displayed when hovered on Quick Links
	    businessFunction.get().verifyMenuOrCategoryLinks("QuickLinks_ChildElements");
	    //To click on Promotions & Programs link and check the title on the page
	    businessFunction.get().clickOnSubMenuItem("Home_QuickLinks", "PromotionsAndPrograms", "PromotionsAndPrograms_Title");
    	//Clicking on Promotions For Networking and verify the navigation to the Promotions For Networking page
	    businessFunction.get().clickAndVerifyNavigation("AvayaPromotionsforNetworking", "Products_Category3_Title");
    	//Clicking on Learn More link under Networking and verify the navigation of  Government GEM page
	    businessFunction.get().clickAndVerifyNavigation("AvayaPromotionsNetLearnMore", "AvayaPromotionsGovernmentGEM");	
    	//Verifying the Promotions for Enterprise Technology
	    businessFunction.get().contentValidation("AvayaPromotionsGovernContent");
    	//Verifying the Image in Government GEM page
	    businessFunction.get().imageValidation("AvayaPromotionsGovernImage");
    	//To check the presence of Find A Partner CTA
	    verify.get().isTextPresent("Find_A_Partner_CTA");
	    businessFunction.get().verifyMenuOrCategoryLinks("Find_A_Partner_CTA");	 	    	    	
    	//To verify whether the breadcrumb is present or not
	    businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "AvayaPromotionsGovernBreadcrumb_Expected", "Tag_Anchors");
    }
    
  /**
  Author Name                       : Sowmya Mohanan
  Date of Preparation               : 13/08/2014
  Date of Modified                  : --
  Methods Called                    : deFocus(),clickOn(String controlName),verifyDropDownSelection(String dropDown, String valueToBeSelected),
  											verifyTextEntered(String textField, String enteredText),verifyIconsNotPresent(String controlName, String expectedImage)
  									 	verifyFirstPartnerDetails(String firstDetailArrow, String leftDetail) 									
  Purpose of Method                 : Verify the Partner Icon is not displayed in Partner Locator page
  Dependencies	                    : Jar files
  Reviewed By                       : --
 **/
@Test(description = "Verify the Partner Icon is not displayed in Partner Locator page", groups="Partner Locator")
public void testPartnerLocatorSearchNoPartnersInCustomerExcellence(){
	//Lauch the Partner Locator Url
	getDriver().get(appConfig.getPartnerUrl());
	dynamicWait.get().waittillpageloads();
	businessFunction.get().deFocus();
	//select a value from country drop down and verify whether the value is selected
	businessFunction.get().verifyDropDownSelection("Partner_CountryList", "Partner_CountrtyUnitedStateSelect");
	dynamicWait.get().waittillpageloads();
	//Enter a value in City field and verify if it is entered
	businessFunction.get().verifyTextEntered("PartnerLocator_CityField", "New York");
	dynamicWait.get().waittillpageloads();
	//click on Search button
	userActions.get().clickOn("PartnerLocator_SearchButton");
	try {
		Thread.sleep(45000);
		//verify the partner details
		businessFunction.get().verifyFirstPartnerDetails("PartnerLocator_FirstDetailArrow", "PartnerLocator_FirstLeftDetail");
		//verify partner Icon is not visible in the popup
		verify.get().verifyIconsNotPresent("PartnerLocator_CustomerExcellenceIcon", "CustomerExcellenceIcon.JPG");
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}				
}

/**
Author Name                       : Sindhuja.P
Date of Preparation               : 20/08/2014
Date of Modified                  : 10/09/2014
Methods Called                    : isTextPresent(String controlName) ,verifyTextEntered(String textField, String enteredText)
                                    verifyExpertBadgeOrder(),verifyPartnerDetails(),verifyFirstPartnerDetails(String firstDetailArrow, String leftDetail)
                                    verifyDropDownSelection(String dropDown, String valueToBeSelected),verifyElementIsChecked(String controlName)
Purpose of Method                 : Verify the solutions data on the  Pop up  when Networking is checked
Dependencies	                    : Jar files
Reviewed By                       : --
**/

@Test(description="Verify the solutions data on the  Pop up  when Networking is checked",groups="Configuration & Provision")
public void testPartnerLocatorSearchExpertBadgeNetworking() 
{
	//Launching Partner Locator Page.
	getDriver().get(appConfig.getPartnerUrl());
	dynamicWait.get().waittillpageloads();
	//To check if Partner Locator Home Page is displayed
	verify.get().isTextPresent("PartnerLocator_Title");
	//To select "United States" from the "Country" Drop Down and to check if System has displayed the selected Option
	businessFunction.get().verifyDropDownSelection("Partner_CountryList", "Partner_CountryUSASelect");
	//To enter "New York" in the City Text Box and to check if system has accepted the input
	businessFunction.get().verifyTextEntered("PartnerLocator_CityField", "New York");
	//To check Networking checkbox under Solution 
	userActions.get().clickOn("Networking_CheckBox");
	//To check if Networking checkbox is checked.
	verify.get().verifyElementIsChecked("Networking_CheckBox");
	//To click on "Search" Button
	userActions.get().clickOn("PartnerLocator_SearchButton");
	try
	{
		Thread.sleep(40000);
		//To click on the > symbol corresponding to the first result displayed in the results section and to check the details in the pop up.
		businessFunction.get().verifyFirstPartnerDetails("PartnerLocator_LeftDetailArrow", "PartnerLocator_leftDetails");
		//To check if Networking  row is  ticked under Expert Badge with 'Product' text next to tick mark
		userActions.get().clickOn("PartnerLocator_LeftDetailArrow");
		businessFunction.get().verifyTickMark("Networking", "Expert Badge", "Product");
		//To check the order of Partner Levels and Expert Badge count order of the results displayed.
		businessFunction.get().verifyExpertBadgeOrder();
	}
	catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

/**
Author Name                       : Sowmya Mohanan
Date of Preparation               : 12/08/2014
Date of Modified                  : --
Methods Called                    : deFocus(),clickOn(String controlName),verifyDropDownSelection(String dropDown, String valueToBeSelected),
									verifyTextEntered(String textField, String enteredText),verifyElementIsChecked(String controlName),
									verifyFirstPartnerDetails(String firstDetailArrow, String leftDetail),verifyAutoPopUpClose()	  									
Purpose of Method                 : Verify the Partner Details Popup is closed, in Partner Locator page
Dependencies	                    : Jar files
Reviewed By                       : --

**/
@Test(description = "Verify the Partner Details Popup is closed, in Partner Locator page")
public void testPartnerLocatorAutoClosePopUp(){
	//Lauch the Partner Locator Url
	getDriver().get(appConfig.getPartnerUrl());
	dynamicWait.get().waittillpageloads();
	businessFunction.get().deFocus();
	//select a value from country drop down and verify whether the value is selected
	businessFunction.get().verifyDropDownSelection("Partner_CountryList", "Partner_CountrtyUnitedStateSelect");
	dynamicWait.get().waittillpageloads();
	//Enter a value in City field and verify if it is entered
	businessFunction.get().verifyTextEntered("PartnerLocator_CityField", "New York");
	dynamicWait.get().waittillpageloads();
	//click on the Networking checkbox
	userActions.get().clickOn("PartnerLocator_Networking");
	dynamicWait.get().waittillpageloads();
	//verify the Networking checkbox is checked
	verify.get().verifyElementIsChecked("PartnerLocator_Networking");
	//click on Search button
	userActions.get().clickOn("PartnerLocator_SearchButton");
	try {
		Thread.sleep(25000);
		//verify the partner details
		businessFunction.get().verifyFirstPartnerDetails("PartnerLocator_FirstDetailArrow", "PartnerLocator_FirstLeftDetail");
		//verify the first popup is closed when second partner details popup is displayed
		businessFunction.get().verifyAutoPopUpClose();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}				
}

/**
Author Name                       : Sindhuja.P
Date of Preparation               : 14/08/2014
Date of Modified                  : 10/09/2014
Methods Called                    : isTextPresent(String controlName) ,verifyTextEntered(String textField, String enteredText)
                                    pageAllignment(String relativeControlName, String controlName, String position),verifyPartnerDetails()
                                    verifyDropDownSelection(String dropDown, String valueToBeSelected),verifyElementIsChecked(String controlName)
Purpose of Method                 : Verify the results displayed when Country,Zip,Partner Name ,Size and Solution  are entered.
Dependencies	                    : Jar files
Reviewed By                       : --
**/

@Test(description="Verify the results displayed when Country,Zip,Partner Name ,Size and Solution  are entered.",groups="Configuration & Provision")
public void testPartnerLocator5OptionsSearchCombination9() 
{
	//Launching Partner Locator Page.
	getDriver().get(appConfig.getPartnerUrl());
	dynamicWait.get().waittillpageloads();
	//To check if Partner Locator Home Page is displayed
	verify.get().isTextPresent("PartnerLocator_Title");
	//To enter "85282" in the "Zip/Postal Code" Text Box and to check if system has accepted the input
	businessFunction.get().verifyTextEntered("PartnerLocator_ZipCodeField", "85282");
	//To enter "Phoenix" in the City Text Box and to check if system has accepted the input
	businessFunction.get().verifyTextEntered("PartnerLocator_CityField", "Phoenix");
	//To enter "ALTURA COMMUNICATION SOLUTIONS, LLC" in ParnterName field and check if system has accepted the input
	businessFunction.get().verifyTextEntered("PartnerLocator_PartnerNameField", "ALTURA COMMUNICATION SOLUTIONS, LLC");
	//To enter 0-250 in size field and check if System has displayed the selected Option
	businessFunction.get().verifyDropDownSelection("PartnerLocator_BusinessSizeField", "BusinessSize_Small");
	//To check Networking checkbox under Solution 
	userActions.get().clickOn("Networking_CheckBox");
	//To check if Networking checkbox is checked.
	verify.get().verifyElementIsChecked("Networking_CheckBox");
	//To click on "Search" Button
	userActions.get().clickOn("PartnerLocator_SearchButton");
	try
	{
		Thread.sleep(40000);
		//To check if corresponding results on left side under sort By section
		businessFunction.get().pageAllignment("ButlerBar", "PartnerLocator_ResultsSection", "equal");
		businessFunction.get().pageAllignment("PartnerLocator_SortBy", "PartnerLocator_ResultsSection", "above");
		//To click on the > symbol corresponding to each of the results displayed and check the pop up details
		businessFunction.get().verifyPartnerDetails();
	}
	catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


/**
Author Name                       : Sindhuja.P
Date of Preparation               : 18/08/2014
Date of Modified                  : 10/09/2014
Methods Called                    : isTextPresent(String controlName) ,verifyTextEntered(String textField, String enteredText)
                                    pageAllignment(String relativeControlName, String controlName, String position),verifyPartnerDetails()
                                    verifyDropDownSelection(String dropDown, String valueToBeSelected),verifyElementIsChecked(String controlName)
Purpose of Method                 : Verify the Partners in Customer Excellence when Country,Zip,Partner Name,Size and Solution are entered.
Dependencies	                    : Jar files
Reviewed By                       : --
**/

@Test(description="Verify the Partners in Customer Excellence when Country,Zip,Partner Name,Size and Solution are entered.",groups="Configuration & Provision")
public void testPartnerLocator6OptionsSearchCombination8() 
{
	//Launching Partner Locator Page.
	getDriver().get(appConfig.getPartnerUrl());
	dynamicWait.get().waittillpageloads();
	//To check if Partner Locator Home Page is displayed
	verify.get().isTextPresent("PartnerLocator_Title");
	//To select "United States" from the "Country" Drop Down and to check if System has displayed the selected Option
	businessFunction.get().verifyDropDownSelection("Partner_CountryList", "Partner_CountryUSASelect");
	//To enter "10018-4308" in the "Zip/Postal Code" Text Box and to check if system has accepted the input
	businessFunction.get().verifyTextEntered("PartnerLocator_ZipCodeField", "10018-4308");
	//To enter "CONSOLIDATED TECHNOLOGIES, INC" in ParnterName field and check if system has accepted the input
	businessFunction.get().verifyTextEntered("PartnerLocator_PartnerNameField", "CONSOLIDATED TECHNOLOGIES, INC");
	//To enter 0-250 in size field and check if System has displayed the selected Option
	businessFunction.get().verifyDropDownSelection("PartnerLocator_BusinessSizeField", "BusinessSize_Small");
	//To check Contact Center checkbox under Solution 
	userActions.get().clickOn("ContactCenter_CheckBox");
	//To check if Contact Center checkbox is checked.
	verify.get().verifyElementIsChecked("ContactCenter_CheckBox");
	//To check Partners in Customer Excellence check box
	userActions.get().clickOn("CustomerExcellence_CheckBox");
	//To check if Partners in Customer Excellence checkbox is checked.
	verify.get().verifyElementIsChecked("CustomerExcellence_CheckBox");
	//To click on "Search" Button
	userActions.get().clickOn("PartnerLocator_SearchButton");
	try
	{
		Thread.sleep(40000);
		//To check if corresponding results are displayed on left side under sort By section
		businessFunction.get().pageAllignment("ButlerBar", "PartnerLocator_ResultsSection", "equal");
		businessFunction.get().pageAllignment("PartnerLocator_SortBy", "PartnerLocator_ResultsSection", "above");
		//To click on the > symbol corresponding to each of the results displayed and check the pop up details
		businessFunction.get().verifyPartnerDetails();	
	}
	catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

/**
Author Name                       : Sindhuja.P
Date of Preparation               : 18/08/2014
Date of Modified                  : 10/09/2014
Methods Called                    : isTextPresent(String controlName) ,verifyTextEntered(String textField, String enteredText)
                                    pageAllignment(String relativeControlName, String controlName, String position),verifyPartnerDetails()
                                    verifyDropDownSelection(String dropDown, String valueToBeSelected),verifyElementIsChecked(String controlName)
Purpose of Method                 : Verify the Partners in Customer Excellence  when Country,City,State,Partner Name,Size and Solution are entered.
Dependencies	                    : Jar files
Reviewed By                       : --
**/

@Test(description="Verify the Partners in Customer Excellence  when Country,City,State,Partner Name,Size and Solution are entered.",groups="Configuration & Provision")
public void testPartnerLocator7OptionsSearchCombination1() 
{
	//Launching Partner Locator Page.
	getDriver().get(appConfig.getPartnerUrl());
	dynamicWait.get().waittillpageloads();
	//To check if Partner Locator Home Page is displayed
	verify.get().isTextPresent("PartnerLocator_Title");
	//To select "United States" from the "Country" Drop Down and to check if System has displayed the selected Option
	businessFunction.get().verifyDropDownSelection("Partner_CountryList", "Partner_CountryUSASelect");
	//To enter "Los Angeles" in the City Field and to check if system has accepted the input
	businessFunction.get().verifyTextEntered("PartnerLocator_CityField", "Los Angeles");
	//To enter "California" in the State Field and to check if if System has displayed the selected Option
	businessFunction.get().verifyDropDownSelection("PartnerLocator_StateField", "Partner_StateCalifornia");
	//To enter "ROI NETWORKS, INC." in ParnterName field and check if system has accepted the input
	businessFunction.get().verifyTextEntered("PartnerLocator_PartnerNameField", "ROI NETWORKS, INC.");
	//To enter 0-250 in size field and check if System has displayed the selected Option
	businessFunction.get().verifyDropDownSelection("PartnerLocator_BusinessSizeField", "BusinessSize_Small");
	//To check Video  checkbox under Solution 
	userActions.get().clickOn("Video_CheckBox");
	//To check if Video  checkbox is checked.
	verify.get().verifyElementIsChecked("Video_CheckBox");
	//To check Partners in Customer Excellence check box
	userActions.get().clickOn("CustomerExcellence_CheckBox");
	//To check if Partners in Customer Excellence checkbox is checked.
	verify.get().verifyElementIsChecked("CustomerExcellence_CheckBox");
	//To click on "Search" Button
	userActions.get().clickOn("PartnerLocator_SearchButton");
	try
	{
		Thread.sleep(40000);
		//To check if corresponding results are displayed on left side under sort By section
		businessFunction.get().pageAllignment("ButlerBar", "PartnerLocator_ResultsSection", "equal");
		businessFunction.get().pageAllignment("PartnerLocator_SortBy", "PartnerLocator_ResultsSection", "above");
		//To click on the > symbol corresponding to each of the results displayed and check the pop up details
		businessFunction.get().verifyPartnerDetails();	
	}
	catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}	

/**
Author Name                       : Sindhuja.P
Date of Preparation               : 14/08/2014
Date of Modified                  : 10/09/2014
Methods Called                    : isElementDisplayed(String controlName), pageAllignment(String relativeControlName, String controlName, String position)
                                    checkCssProperty(String controlName, String cssProperty),clickOn(String controlName) 
Purpose of Method                 : Verify the functionality of 'X' Symbol in pop up on Premium Content Registration form B page
Dependencies	                    : Jar files
Reviewed By                       : --
**/

@Test(description="Verify the functionality of 'X' Symbol in pop up on Premium Content Registration form B page",groups="Configuration & Provision")
public void testPremiumContentFormBPopUpClickOnXSymbol() 
{
	//Launching Premium Content Registration Form page
	getDriver().get(appConfig.getPremiumContentFormBUrl());
	dynamicWait.get().waittillpageloads();
	try
	{
		Thread.sleep(10000);
		//To check if the  pop up is present 
		verify.get().isElementDisplayed("PremiumContent_Popup");
		//To check if the  pop up is present along the footer
		businessFunction.get().pageAllignment("PremiumContentPopup_Footer", "PremiumContent_Popup", "right");
		//To check if the  pop up is present in red color
		businessFunction.get().checkCssProperty("PremiumContent_Popup", "color");
		//To check if presence of link on the popup.
		userActions.get().hoverOn("PremiumContent_PopupLink");
		businessFunction.get().checkCssProperty("PremiumContent_PopupLink", "text-decoration");
		userActions.get().clickOn("PremiumContent_Popup");
		dynamicWait.get().waitforvisibilityOfElementLocated("PremiumContent_PopupX");
		//To check the presence of X symbol on the popup.
		verify.get().isElementDisplayed("PremiumContent_PopupX");
		//To click on X symbol
		userActions.get().clickOn("PremiumContent_PopupX");
		//To check if the pop up has disappeared.
		businessFunction.get().checkCssProperty("PremiumContent_PopupCollapsed", "display");
	}
	catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

/**
Author Name                       : Sindhuja.P
Date of Preparation               : 12/08/2014
Date of Modified                  : --
Methods Called                    : isTextPresent(String controlName),verifySubMenuElements(String parentMenu,String subMenu,String delimiter)
                                    isElementDisplayed(String controlName),pageAllignment(String relativeControlName, String controlName, String position)
Purpose of Method                 : Verify the right side form on  premium content registration page
Dependencies	                    : Jar files
Reviewed By                       : --
**/

@Test(description="Verify the right side form on  premium content registration page",groups="Configuration & Provision")
public void testPremiumContentFormARightForm()
{
		// Launching the Premium Content Registration Form A page.
		getDriver().get(appConfig.getPremiumContentFormAUrl());
		dynamicWait.get().waittillpageloads();
		// To check if Premium Content Registration Form A page is displayed
		verify.get().isTextPresent("PremiumContentFormA_Title");
		// To check if all the fields are displayed.
		businessFunction.get().verifySubMenuElements(
				"PremiumContentFormA_Form", "Child_Label_Items", ",");
		// To check the presence of Submit button.
		verify.get().isElementDisplayed("PremiumContentFormA_Submit");
		// To check if related text is present.
		businessFunction.get().contentValidation("PremiumContentFormA_Text");
		// To check if related text is present below Submit button
		businessFunction.get().pageAllignment("PremiumContentFormA_Submit",
				"PremiumContentFormA_Text", "above");
	}

/**
Author Name                       : Sindhuja.P
Date of Preparation               : 14/08/2014
Date of Modified                  : --
Methods Called                    : isElementDisplayed(String controlName), pageAllignment(String relativeControlName, String controlName, String position)
                                    verifySubMenuElements(String parentMenu,String subMenu,String delimiter),sendinputdata(String controlName, String option, String searchControlName)
                                    verifyIcons(String controlName, String expectedImage),verifyImagePresent(String expectedImage, String imageElement)
                                    checkCssProperty(String controlName, String cssProperty),clickOn(String controlName),isTextPresent(String controlName)  
Purpose of Method                 : To verify the content in the pop up on the Premium Content Registration Form B page 
Dependencies	                    : Jar files
Reviewed By                       : --
**/

@Test(description="To verify the content in the pop up on the Premium Content Registration Form B page ",groups="Configuration & Provision")
public void testPremiumContentFormThankYouPage()
{
	//Launching Premium Content Registration Form page
	getDriver().get(appConfig.getPremiumContentFormBUrl());
	dynamicWait.get().waittillpageloads();
	try
	{
		Thread.sleep(10000);
		//To check if the  pop up is present 
		verify.get().isElementDisplayed("PremiumContent_Popup");
		//To check if the  pop up is present along the footer
		businessFunction.get().pageAllignment("PremiumContentPopup_Footer", "PremiumContent_Popup", "right");
		//To check if the  pop up is present in red color
		businessFunction.get().checkCssProperty("PremiumContent_Popup", "color");
		//To check if presence of link on the popup.
		userActions.get().hoverOn("PremiumContent_PopupLink");
		businessFunction.get().checkCssProperty("PremiumContent_PopupLink", "text-decoration");
		//To check the presence of X symbol on the popup.
//		verify.get().isElementDisplayed("PremiumContent_PopupX");
		//To click on the pop up
		userActions.get().clickOn("PremiumContent_PopupLink");
		//To check if the popup has expanded
		businessFunction.get().checkCssProperty("PremiumContent_PopupExpanded", "display");
		//To check the presence of Introduction content.
		businessFunction.get().contentValidation("PremiumContentPopup_Introduction");
		//To check the presence of All Fields Required text 
		verify.get().isTextPresent("PremiumContentPopup_AllFieldsText");
		//To check the presence of All Fields Required text in red color
		businessFunction.get().checkCssProperty("PremiumContentPopup_AllFields", "color");
		//To check the presence of all the fields like first name,last name etc on the page.
		businessFunction.get().verifySubMenuElements("PremiumContentFormA_Form","Child_Label_Items", ",");
		//To check the presence of Submit button
		verify.get().isElementDisplayed("PremiumContentPopup_Submit");
		//To check the presence of required text.
		verify.get().isTextPresent("PremiumContentPopup_Text");
		//To check the presence of required text below Submit button.
		businessFunction.get().pageAllignment("PremiumContentPopup_Submit", "PremiumContentPopup_Text", "above");
		//To enter the data in the fields
		businessFunction.get().sendinputdata("RegistrationInputdata", "registration","none");
		//To click on Submit button.
		userActions.get().clickOn("PremiumContentPopup_Submit");
		//To check if Thank You page is displayed.
		verify.get().isTextPresent("PremiumContentPopup_ThankYouPage");
		//To check the presence of Avaya Logo in Thank you Page.
		verify.get().verifyIcons("PopupThankYouPage_AvayaLogo", "AvayaLogo.png");
		//To check the presence of Get It Now button in Thank you Page.
		verify.get().isElementDisplayed("PopupThankYouPage_GetItNow");
		//To check the presence of Image 
		businessFunction.get().imageValidation("PopupThankYouPage_Image");
		//To check the presence of Image in the right side.
		businessFunction.get().pageAllignment("PopupThankYouPage_GetItNow", "PopupThankYouPage_Image", "right");
		//To check the presence of Footer with links.
		businessFunction.get().verifySubMenuElements("PopupThankYouPage_Footer","Tag_Anchors", ",");
		//To check the presence of Share section
		verify.get().isElementDisplayed("PopupThankYouPage_Share");		
	}
	catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
	/**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 15/07/2014
	  Date of Modified                  : 09/09/2014
	  Methods Called                    : enterText(String controlName,String text),clickOn(String controlName),isTextPresent(String controlName) 
	                                      productsAndArticlesOnLoadMore(String firstPageProducts,String viewAllPageProducts,String clickOnElement)
	                                      verifySubMenuElements(String parentMenu,String subMenu,String delimiter)
	                                      checkToggleMenuArrows(String actualControlName,String expectedControlName,String direction)
	  Purpose of Method                 : Verify the functionality of show all link in GSA search page
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/

	@Test(description="Verify the functionality of show all link in GSA search page",groups="GSA Search page")
	public void testGSASearchLeftNavShowAll()
	{
	    //Launching the Avaya Website
	    getDriver().get(appConfig.getAppUrl());
	    dynamicWait.get().waittillpageloads();
	    //To enter "Avaya" in the Search Text Box
	    businessFunction.get().deFocus();
	    userActions.get().enterText("AvayaHome_SearchBox", "Avaya Aura Platform");
	    //To click on Search Icon
	    userActions.get().clickOn("Search_Button_Test");
	    //To check if user is able to view Global results Page 
	    verify.get().isTextPresent("ResultsPage_Title");
	    //To check if business need,business size,industry,site section sections are displayed
	    businessFunction.get().verifySubMenuElements("ResultsPage_Sections", "Tag_Span", ",");
	    //To check if business need,business size,industry,site section sections are expanded by default
	   	businessFunction.get().checkToggleMenuArrows("BusinessNeed_Expanded_Arrow","Expanded_Arrow","up");
	   	businessFunction.get().checkToggleMenuArrows("BusinessSize_Expanded_Arrow","Expanded_Arrow","up");
	   	businessFunction.get().checkToggleMenuArrows("Industry_Expanded_Arrow","Expanded_Arrow","up");
	   	businessFunction.get().checkToggleMenuArrows("SiteSection_Expanded_Arrow","Expanded_Arrow","up");
	   	//To click on Show All link and check if all fields of industry section are displayed
	   	businessFunction.get().productsAndArticlesOnLoadMore("IndustryFieldsBeforeShowAll", "IndustryFieldsAfterShowAll", "Industry_ShowAll");  
	}
	

	
	/**
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 28/07/2014
	  Date of Modified                  : --
	  Methods Called                    : clickOn(String controlName),enterText(String controlName,String text)
	  									pageAllignment(String relativeControlName, String controlName, String position),
	  									getvalueofhtmlattribute(String controlName, String attribute),
	  									searchValidResults(String controlName,String keyword,String childElement)
	  Purpose of Method                 : Verify the Search Functionality in Case Studies Landing Page
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	 **/
	@Test(description = "Verify the Search Functionality in Case Studies Landing Page",groups = "Case Studies page")
	public void testCaseStudiesLandingPageSearchSectionValidSearch(){
		//Launching the Case Studies Landing page
		getDriver().get(appConfig.getCaseStudiesUrl());
		//check the Business Size is aligned on the right side of the page
		dynamicWait.get().waittillpageloads();
		//businessFunction.get().deFocus();
		businessFunction.get().pageAllignment("ButlerBar", "CaseStudiesLandingPage_SearchBox", "right");
		//Check the SearchBox is default value is 'Search'
		businessFunction.get().getValueOfHtmlAttribute("CaseStudiesLandingPage_SearchBox", "placeholder");
		//Enter text in Search Box
		businessFunction.get().deFocus();
		userActions.get().enterText("CaseStudiesLandingPage_SearchBox", "Avaya");
		//Click on Search Button
		userActions.get().clickOn("CaseStudiesLandingPage_SearchBox_Button");
		//Verify the Search Result
		dynamicWait.get().waittillpageloads();
		businessFunction.get().contentValidation("CaseStudiesLandingPage_SearchResult");
	}
	
	/**
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 30/07/2014
	  Date of Modified                  : --
	  Methods Called                    : isElementNotPresent(String controlName)
	  Purpose of Method                 : Verify whether the Chat Icon is not displayed in the Brand Campaign Page
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	 **/
	@Test(description = "Verify whether the Chat Icon is not displayed in the Brand Campaign Page",groups = "Brand Campaign")
	public void testBrandCamapaignChatIcon(){
		//Launching the Brand Camapaign Page
		getDriver().get(appConfig.getImagineUrl());
		//Check the Chat Icon is not persent in the page
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		verify.get().isElementNotPresent("ChatIcon");
	}
	
	
    /** 
    Author Name                       : Sindhuja.P
    Date of Preparation               : 30/07/2014
    Date of Modified                  : 
    Methods Called                    : Click_VerifyNavigation(businessFunction), waittillpageloads(DynamicWait),isTextPresent(Verify)
    Purpose of Method                 : Verify if Contacts Pod is present in About Avaya landing page
    Dependencies	                   : --
    Reviewed By                       : --
    Test Case name					   : About Avaya_Landing page_Contacts Pod_Learn More link
    **/

	@Test(description="Verify if Contacts Pod is present in About Avaya landing page",groups="About Avaya")
    public void testAbtAvayaLandContPodLearnMore()
    {
    	// Launching the Avaya URL
    	getDriver().get(appConfig.getAppUrl());
    	dynamicWait.get().waittillpageloads();			
    	// Verifying the About Avaya Landing page title heading.				
  		businessFunction.get().clickAndVerifyNavigation("MegaMenuAboutAvaya","AboutAvayaLabel");
  		//Verfiy the Contacts pod content
    	businessFunction.get().contentValidation("AboutAvayaTopPods_ContactsPod_Header");
    	businessFunction.get().verifyPartnerAndProductPods("AboutAvayaTopPods_ContactsPod_Description","Tag_Anchors");    					    							
    	//Verifying whether contact page is opening while clicking on Learn More link in About Avaya Land Contacts Pod page
    	userActions.get().clickOn("AboutAvayaTopPods_ContactsPodLearnMore");
    	//verify the title is present
    	businessFunction.get().contentValidation("Page_Title");    				
    }

    
    /** 
    Author Name                       : Niharika
    Date of Preparation               : 30/07/2014
    Date of Modified                  : --
    Methods Called                    : waittillpageloads(DynamicWait),isTextPresent,isElementPresent(Verify),verifyBreadCrumb,Click_VerifyNavigation,getvalueofhtmlattribute(businessFunction)
    Purpose of Method                 : Verify the subheading under Perspectives title on Landing Page.
    Dependencies	                    : --
    Reviewed By                       : --
    Test Case Name					   : wi01142999_Perspectives Landing Page_SubHeading   
    **/

    @Test(description="Verify the subheading under Perspectives title on Landing Page.",groups="Perspectives")
    public void testPerceptivesLandSubHeading()
    {
    	//Launch the Avaya Home page and check whether Avaya Main page is opening or not
    	getDriver().get(appConfig.getAppUrl());
    	dynamicWait.get().waittillpageloads();
    	//Verifying the data which is available in Perceptives Landing Page
    	businessFunction.get().getValueOfHtmlAttribute("AvayaTitlePage", "title");
    	//Verifying the Perspectives page
    	businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "Perspectives_SubMenu", "PerspectivesTitlePage");
    	//Verifying the ButlerBar
    	verify.get().isElementPresent("ButlerBar");
    	//Verifying the Megamenu
    	verify.get().isElementPresent("Megamenu");
    	//Verifying the Perspectives BreadCrumb
    	businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "PerspectivesBreadCrumb","Tag_Anchors");    	
    	//Verifying the Perspectives Page details
    	verify.get().isTextPresent("PerspectivesTitlePage");	
    	//Verify Subheading is present or not
    	verify.get().isTextPresent("PerspectivesSubHeading");
    }


    /** 
    Author Name                       : Sowmya Mohanan
    Date of Preparation               : 30/07/2014
    Date of Modified                  : --
    Methods Called                    : isTextPresent(Verify),verifyBreadCrumb(businessFunction)
    Purpose of Method                 : Verify The Bread Crumb on the CaseStudies Landing page
    Dependencies	                  : --
    Reviewed By                       : --
    Test Case name					  : CaseforAvaya Landing page_Breadcrumb
    **/

    @Test(description="Verify The Bread Crumb on the CaseStudies Landing page",groups="About Avaya -Case Studies page")
    public void testCaseStudiesBreadCrumb()
    {
    		// Launching the Avaya URL
    		getDriver().get(appConfig.getCaseStudiesUrl());	    	  
	    	dynamicWait.get().waittillpageloads();
	    	//Verifying the page title heading.
	    	verify.get().isTextPresent("CaseStudiesHomePage");
    		// Vefying the breadCrumb of the Case Studies page. 	    	
    		businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "CaseStudiesBreadCrumb","Tag_Anchors");
    				
    }
    
	/** 
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 30/07/2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify the email icon functionality for  invalid inputs
	  Dependencies	                   	: --
	  Reviewed By                       : --
	* 
	**/
    @Test(description="Verify the email icon functionality for  invalid inputs", groups="About Avaya-Case Studies page")
	public void testCaseForAvayaLandingPageShareEmailInvalid(){
		
		//navigate to case studies URL
		getDriver().get(appConfig.getCaseStudiesUrl());
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		//verify case studies landing page is displayed
		verify.get().isTextPresent("CaseStudies_Title");
		//verify the share section is present towards right of the page
		businessFunction.get().checkCssProperty("SocialIcons","float");
		/*Share section should be present with the following buttons:

			•Twitter icon

			•Facebook icon

			•Linked In icon

			•Google + icon

			•Email icon*/
		businessFunction.get().socialIcons("CaseStudies_SocialIcons","CaseStudies_SocialIcons_Child","class");
		//click on e-mail icon 
		userActions.get().clickOn("CaseStudies_Email_Icon");
		//verify A pop up should be displayed
		verify.get().isElementPresent("CaseStudies_Email_Popup");
		//verify Title:  Email This Page to a Colleague
		verify.get().isTextPresent("CaseStudies_Email_Title");
		//Verify Your Name:
		verify.get().isTextPresent("CaseStudies_EmailPopUp_YourName");
		//Verify Your Email:
		verify.get().isTextPresent("CaseStudies_EmailPopUp_YourEmail");
		//Verify Your Colleague's Name:
		verify.get().isTextPresent("CaseStudies_EmailPopUp_YourColleaguesName");
		//Verify Your Colleague's Email:
		verify.get().isTextPresent("CaseStudies_EmailPopUp_YourColleaguesEmail");
		//Verify Message (optional):
		verify.get().isTextPresent("CaseStudies_EmailPopUp_Message");
		//Verify Link:  Read our Privacy Statement
		verify.get().isTextPresent("CaseStudies_EmailPopUp_PrivacyLink");
		//verify Send Button
		verify.get().isElementPresent("CaseStudies_EmailPopUp_SendButton");
		//click on send button
		userActions.get().clickOn("CaseStudies_EmailPopUp_SendButton");
		//verify boxes are in red color
		businessFunction.get().checkMultipleCSSProperties("CaseStudies_EmailPopUP_Labels", "color");
	}
	
	/**
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 30/07/2014
	  Date of Modified                  : --
	  Methods Called                    : clickOn(String controlName),verifyAlertText(String expectedValue),clickAlertOk(),deFocus()
	  Purpose of Method                 : Verify the alert message displayed which is displayed on clicking search button without entering any search value present in Global Header
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	 * @throws AdbCommandRejectedException 
	 * @throws InterruptedException 
	**/
	@Test(description = "Verify the alert message displayed which is displayed on clicking search button without entering any search value present in Global Header",groups = "GSA Search page")
	public void testGlobalSearchValidationNoInputsGlobalHeader() throws InterruptedException, AdbCommandRejectedException{
		//Launching the Avaya website
		getDriver().get(appConfig.getAppUrl());
		//Click on Search Button in Global Header
		dynamicWait.get().waittillpageloads();
		userActions.get().clickOn("GlobalHeaderSearchBoxButton");
		//Check the alert message displayed
//		dynamicWait.get().waittillpageloads();
		verify.get().verifyAlertText("GlobalSearchAlertMessage");
		//Click on Ok button in Alert
		userActions.get().clickAlertOk();
	}
	
	
	/**
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 30/07/2014
	  Date of Modified                  : --
	  Methods Called                    : clickOn(String controlName),enterText(String controlName,String text)
	  									socialIcons(String controlName,String childElement,String attribute) 
	  									sharingArticleInSocialSites(String controlName, String option, String ShareText)
	  Purpose of Method                 : Share NewsRoom Url in Facebook Social Site from NewsRoom page
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	 
	 **/
	@Test(description = "Share NewsRoom Url in Facebook Social Site from NewsRoom page",groups = "About Avaya-Newsroom")
	public void testNewsRoomFaceBook() {
		//Launching the Newsroom website
		getDriver().get(appConfig.getNewsRoomUrl());
		//Check the Social Icons are present on the top right 
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		businessFunction.get().socialIcons("NewsRoom_SocialIcons","CaseStudies_SocialIcons_Child","class");
		//Click on Facebook Icon
		userActions.get().clickOn("NewsRoom_FacebookIcon");
		//Switch to Facebook window and share
		businessFunction.get().shareArticleInSocialSites("FacebookPlusData", "facebook");																
		//Check the Shared Link in Facebook page
		getDriver().get(appConfig.getFacebookUrl());
		businessFunction.get().validateSharedArticleInSocialSites("FacebookPlusData", "facebook");	
	}
	/** 
    Author Name                       : Niharika K R 
    Date of Preparation               : 16-10-2014
    Date of Modified                  : 
    Methods Called                    : Verify the Developers module on Partner Landing Page
    Purpose of Method                 : isTextPresent(String controlName),isElementDisplayed(String controlName)
    									contentValidation(String controlName),verifyMenuOrCategoryLinks(String controlName)
    Dependencies	                  : --
    Reviewed By                       : --
    **/
	
	@Test(description="Verify the Developers module on Partner Landing Page",groups="Partners")
	public void testPartnersLandingPageDevelopers()
	{
		//To navigate to the Partners landing page
		getDriver().get(appConfig.getPartnersLandingPage());
		dynamicWait.get().waittillpageloads();
		verify.get().isTextPresent("Partners_Title");
		//To verify whether the Develeopers module is displayed. 
		verify.get().isElementDisplayed("PartnersLandingPage_DevelopersModule");
		//To verify whether the Develeopers title is displayed 			
		verify.get().isTextPresent("PartnersLandingPage_DevelopersTitle");
		//To verify whether the Develeopers content is displayed 	
		businessFunction.get().contentValidation("PartnersLandingPage_DevelopersModuleText");
		//To verify the Explore Becoming a Developer CTA
		businessFunction.get().verifyMenuOrCategoryLinks("PartnersLandingPage_DevelopersModuleCTA");
		verify.get().isTextPresent("PartnersLandingPage_DevelopersModuleCTA");
	}
	
	/** 
    Author Name                       : Niharika K R 
    Date of Preparation               : 16-10-2014
    Date of Modified                  : 
    Methods Called                    : Verify the Customers Landing page
    Purpose of Method                 : isTextPresent(String controlName),isElementDisplayed(String controlName)
    									contentValidation(String controlName),verifyMenuOrCategoryLinks(String controlName)
    									clickAndVerifyNavigation(String navigatetopage,String pageTitle),
    									verifySubMenuElements(String parentMenu,String subMenu,String delimiter)
    									checkImageOrVideo(String imageElement),
    									verifyBreadCrumb(String actualControlName, String expectedControlName,String tagName)
    Dependencies	                  : --
    Reviewed By                       : --
    **/
	
	@Test(description="Verify the Customers Landing page",groups="Partners")
	public void testPartnersCustomersLandingPage()
	{
		//To navigate to the Partners landing page
		getDriver().get(appConfig.getPartnersLandingPage());
		dynamicWait.get().waittillpageloads();
		verify.get().isTextPresent("Partners_Title");
		//To verify whether the Customers module is displyed
		verify.get().isElementDisplayed("PartnersLandingPage_CustomersModule");
		//To verify whether the Customers title is displyed
		verify.get().isTextPresent("PartnersLandingPage_CustomersTitle");
		//To verify whether the Customers module content is displyed 
		businessFunction.get().contentValidation("PartnersLandingPage_CustomersModuleText");
		//To verify the Explore Becoming a Customer CTA
		businessFunction.get().verifyMenuOrCategoryLinks("PartnersLandingPage_CustomersModuleCTA");
		verify.get().isTextPresent("PartnersLandingPage_CustomersModuleCTA");
		//To verify the Customers landing page navigation and title
		businessFunction.get().clickAndVerifyNavigation("PartnersLandingPage_CustomersModuleCTA", "CustomersLandingPage_Title");
		
		//To verify the Global Header display on Customers Landing Page
		verify.get().isElementDisplayed("Global_Header");
		//To verify the breadcrumb on Customers Landing Page
		businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "Breadcrumb_CustomersLandingPage", "Tag_Anchors");
		//To verify the chat link on Customers Landing Page
		verify.get().isElementDisplayed("Partners_ChatLink");
		//To vreify the sub navigation menu on Customers Landing Page
		businessFunction.get().verifySubMenuElements("CustomersLandingPage_ParentTab", "Tag_Anchors", ",");
		//To verify the image or video on Customers Landing Page
		businessFunction.get().checkImageOrVideo("CustomersLandingPage_Image");
		//To verify whether the Find a Partner Module is displayed
		verify.get().isElementDisplayed("CustomersLandingPage_FindAPartnerModule");
		//To verify whether the Dowload the Brochure Module is displayed
		verify.get().isElementDisplayed("CustomersLandingPage_DownloadBrochureModule");
		//To verify the content on Customers Landing Page
		businessFunction.get().contentValidation("CustomersLandingPage_Content");
		//To verify whether the Global Footer is displayed
		verify.get().isElementDisplayed("GlobalFooter");
	}
	/** 
    Author Name                       : Niharika K R 
    Date of Preparation               : 16-10-2014
    Date of Modified                  : 
    Methods Called                    : Verify the Why Avaya page.
    Purpose of Method                 : isTextPresent(String controlName),isElementDisplayed(String controlName)
    									contentValidation(String controlName),verifyMenuOrCategoryLinks(String controlName)
    									clickAndVerifyNavigation(String navigatetopage,String pageTitle)
    									checkSelectedTabActive(String tabSection, String tabs,String str_selectedtabname) 
    Dependencies	                  : --
    Reviewed By                       : --
    **/
	
	@Test(description="Verify the Why Avaya page.",groups="Partners")
	public void testPartnersProspectivePartnersLandingPageWhyAvaya()
	{
		//To navigate to the Partners landing page
		getDriver().get(appConfig.getPartnersLandingPage());
		dynamicWait.get().waittillpageloads();
		verify.get().isTextPresent("Partners_Title");
		//To verify whether the Partners module is displayed. 
		verify.get().isElementDisplayed("PartnersLandingPage_PartnersModule");
		//To verify whether the Partners title is displayed 			
		verify.get().isTextPresent("PartnersLandingPage_PartnersTitle");
		//To verify whether the Partners content is displayed 	
		businessFunction.get().contentValidation("PartnersLandingPage_PartnersModuleText");
		//To verify the Explore Becoming a Partner CTA
		businessFunction.get().verifyMenuOrCategoryLinks("PartnersLandingPage_PartnersModuleCTA");
		verify.get().isTextPresent("PartnersLandingPage_PartnersModuleCTA");
		//To click on the Explore Becoming a Partner CTA
		businessFunction.get().clickAndVerifyNavigation("PartnersLandingPage_PartnersModuleCTA", "ProspectiveCustomersPage_Landing Page_Title");
		//To click on the Why AVaya Tab and to check whether the Why Avaya Tab is selected or not
		userActions.get().clickOn("ProspectiveCustomersPage_WhyAvayaTab");
		businessFunction.get().checkSelectedTabActive("ProspectiveCustomersPage_ParentTabs", "Tag_List", "WHY AVAYA");
	}
	
	/** 
    Author Name                       : Niharika K R 
    Date of Preparation               : 16-10-2014
    Date of Modified                  : 
    Methods Called                    : Verify the About the Program page.
    Purpose of Method                 : isTextPresent(String controlName),isElementDisplayed(String controlName)
    									contentValidation(String controlName),verifyMenuOrCategoryLinks(String controlName)
    									clickAndVerifyNavigation(String navigatetopage,String pageTitle)
    									checkSelectedTabActive(String tabSection, String tabs,String str_selectedtabname) 
    Dependencies	                  : --
    Reviewed By                       : --
	 
	 
    **/
	
	@Test(description="Verify the About the Program page.",groups="Partners")
	public void testPartnersProspectivePartnersLandingPageAboutTheProgram() 
	{
		//To navigate to the Partners landing page
		getDriver().get(appConfig.getPartnersLandingPage());
		dynamicWait.get().waittillpageloads();
		verify.get().isTextPresent("Partners_Title");
		//To verify whether the Partners module is displayed. 
		verify.get().isElementDisplayed("PartnersLandingPage_PartnersModule");
		//To verify whether the Partners title is displayed 			
		verify.get().isTextPresent("PartnersLandingPage_PartnersTitle");
		//To verify whether the Partners content is displayed 	
		businessFunction.get().contentValidation("PartnersLandingPage_PartnersModuleText");
		//To verify the Explore Becoming a Partner CTA
		businessFunction.get().verifyMenuOrCategoryLinks("PartnersLandingPage_PartnersModuleCTA");
		verify.get().isTextPresent("PartnersLandingPage_PartnersModuleCTA");
		//To click on the Explore Becoming a Partner CTA
		businessFunction.get().clickAndVerifyNavigation("PartnersLandingPage_PartnersModuleCTA", "ProspectiveCustomersPage_Landing Page_Title");
		//To click on the Why AVaya Tab and to check whether the About The Program Tab is selected or not
		userActions.get().clickOn("ProspectiveCustomersPage_AboutTheProgramTab");
		businessFunction.get().checkSelectedTabActive("ProspectiveCustomersPage_ParentTabs", "Tag_List", "ABOUT THE PROGRAM");
	}
	
	/** 
    Author Name                       : Niharika K R 
    Date of Preparation               : 16-10-2014
    Date of Modified                  : 
    Methods Called                    : Verify the Breadcrumb on Prospective Customers Landing Page
    Purpose of Method                 : isTextPresent(String controlName),isElementDisplayed(String controlName)
    									contentValidation(String controlName),verifyMenuOrCategoryLinks(String controlName)
    									clickAndVerifyNavigation(String navigatetopage,String pageTitle)
    									verifyBreadCrumb(String actualControlName, String expectedControlName,String tagName)
    Dependencies	                  : --
    Reviewed By                       : --
	 
	 
    **/
	
	@Test(description="Verify the Breadcrumb on Prospective Customers Landing Page",groups="Partners")
	public void testPartnersProspectivePartnersLandingPageBreadcrumb() 
	{
		//To navigate to the Partners landing page
		getDriver().get(appConfig.getPartnersLandingPage());
		dynamicWait.get().waittillpageloads();
		verify.get().isTextPresent("Partners_Title");
		//To verify whether the Partners module is displayed. 
		verify.get().isElementDisplayed("PartnersLandingPage_PartnersModule");
		//To verify whether the Partners title is displayed 			
		verify.get().isTextPresent("PartnersLandingPage_PartnersTitle");
		//To verify whether the Partners content is displayed 	
		businessFunction.get().contentValidation("PartnersLandingPage_PartnersModuleText");
		//To verify the Explore Becoming a Partner CTA
		businessFunction.get().verifyMenuOrCategoryLinks("PartnersLandingPage_PartnersModuleCTA");
		verify.get().isTextPresent("PartnersLandingPage_PartnersModuleCTA");
		//To click on the Explore Becoming a Partner CTA
		businessFunction.get().clickAndVerifyNavigation("PartnersLandingPage_PartnersModuleCTA", "ProspectiveCustomersPage_Landing Page_Title");
		//To verify the Breadcrumb of the Prospective Customers Landing Page
		businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "ProspectiveCustomers_Breadcrumb", "Tag_Anchors");
	}
	
	/** 
    Author Name                       : Niharika K R 
    Date of Preparation               : 17-10-2014
    Date of Modified                  :  
    Methods Called                    : isElementDisplayed(String controlName), imageValidation(String imageControlName)
    Purpose of Method                 : Verify the  categories under Partners tab of mega menu
    Dependencies	                  : --
    Reviewed By                       : --
    **/
	
	@Test(description="Verify the  categories under Partners tab of mega menu",groups="Partners")
	public void testPartnersMegaMenuCategories()
	{
		//To launch the Avaya application
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		//To hover on the Partners Tab
		userActions.get().hoverOn("Partners");
		//To verify whether the submenu elements are displayed under Partners tab
		verify.get().isElementDisplayed("Partners_Submenu");
		//To verify whether the spotlight image is displyed or not
		businessFunction.get().imageValidation("Partners_SpotlightImage");
	}
	
	/**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 31-07-2014
	  Date of Modified                  : --
	  Methods Called                    : isElementDisplayed(String controlName),isTextPresent(String controlName),
	  									  verifyImagePresent(String expectedImage, String imageElement)
	  Purpose of Method                 : Verify the Details present in the Promotional Pods in MidMarketing landing Page
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 
	 
	  **/
	
	@Test(description="Verify the Details present in the Promotional Pods in MidMarketing landing Page",groups="Solutions")
	public void testCapabilitiesMidmarketingPromotionalPods() 
	{
        //Launching the Avaya Website
        getDriver().get(appConfig.getAppUrl());
        //To click on Capabilities tab
        dynamicWait.get().waittillpageloads();
        businessFunction.get().clickAndVerifyNavigation("Solutions", "Solutions_Title");
        businessFunction.get().deFocus();
        //To click on Explore Midmarket Business CTA
        businessFunction.get().clickAndVerifyNavigation("Explore_Midmarket_Business", "Explore_Midmarket_Business_Title");
        businessFunction.get().deFocus();
        //To verify the presence of the Video for Midmarket pod
        verify.get().isElementDisplayed("Video_for_Midmarket");
        //To verify the presence of the Video for Midmarket pod
        verify.get().isElementDisplayed("Contact_Center_Midmarket");
        //To verify the presence of the Video for Midmarket pod
        verify.get().isElementDisplayed("Networking_for_Midmarket");
        //To verify the presence of the Video for Midmarket pod
        verify.get().isElementDisplayed("Security_for_Midmarket");
        //To verify the details of the Video for Midmarket pod
        verify.get().isTextPresent("Video_for_Midmarket_Header");
        businessFunction.get().imageValidation("Video_for_Midmarket_Image");
        businessFunction.get().contentValidation("Video_for_Midmarket_Description");
        verify.get().isElementDisplayed("Video_for_Midmarket_CTA");
        //To verify the details of the Contact Center for Midmarket pod
        verify.get().isTextPresent("Contact_Center_Midmarket_Header");
        businessFunction.get().imageValidation("Contact_Center_Midmarket_Image");
        businessFunction.get().contentValidation("Contact_Center_Midmarket_Description");
        verify.get().isElementDisplayed("Contact_Center_Midmarket_CTA");
        //To verify the details of the Networking for Midmarket pod
        verify.get().isTextPresent("Networking_for_Midmarket_Header");
        businessFunction.get().imageValidation("Networking_for_Midmarket_Image");
        businessFunction.get().contentValidation("Networking_for_Midmarket_Description");
        verify.get().isElementDisplayed("Networking_for_Midmarket_CTA");
        //To verify the details of the Security for Midmarket pod
        verify.get().isTextPresent("Security_for_Midmarket_Header");
        businessFunction.get().imageValidation("Security_for_Midmarket_Image");
        businessFunction.get().contentValidation("Security_for_Midmarket_Description");
        verify.get().isElementDisplayed("Security_for_Midmarket_CTA");
						
	}
	
	/**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 19-06-2014
	  Date of Modified                  : --
	  Methods Called                    : isElementDisplayed(String controlName),check_ChildElements(String controlName,String childElement,String delimiter)
	  									  isTextPresent(String controlName),verifyImagePresent(String expectedImage, String imageElement)
	  Purpose of Method                 : Verify the Details present in the Promotional Pods in Industry Vertical landing Page
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 
	 
	  **/
		
	@Test(description="Verify the Details present in the Promotional Pods in Industry Vertical landing Page",groups="Solutions")
	public void testCapabilitiesIndustryVerticalPromotionalPods() 
	{
		//Launching the Avaya Website
		getDriver().get(appConfig.getAppUrl());
		//To click on Capabilities tab
		dynamicWait.get().waittillpageloads();
		businessFunction.get().clickAndVerifyNavigation("Solutions", "Capabilities_Title");
		businessFunction.get().deFocus();
		userActions.get().clickOn("Explore_Industry_Vertical");
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		//Verify if Pods are present
		verify.get().isElementDisplayed("Parent_Banking");
		verify.get().isElementDisplayed("Parent_Insurance");
		verify.get().isElementDisplayed("Parent_Hotels_Lodging");
		verify.get().isElementDisplayed("Parent_Healthcare");
		verify.get().isElementDisplayed("Parent_Education");
		verify.get().isElementDisplayed("Parent_State_Local_Government");
		verify.get().isElementDisplayed("Parent_Federal_Government");
		//To check whether the Title,Image, CTA and the description of respective pods are present or not	
		verify.get().isTextPresent("IndustryVertical_Banking_Header");
		businessFunction.get().imageValidation("Banking_Image");
		businessFunction.get().contentValidation("Banking_Description");
		verify.get().isElementDisplayed("Banking_CTA");
		verify.get().isTextPresent("IndustryVertical_Insurance_Header");
		businessFunction.get().imageValidation("Insurance_Image");
		businessFunction.get().contentValidation("Insurance_Description");
		verify.get().isElementDisplayed("Insurance_CTA");
		verify.get().isTextPresent("IndustryVertical_HotelsandLodging_Header");
		businessFunction.get().imageValidation("Hotels_Image");
		businessFunction.get().contentValidation("Hotels_Description");
		verify.get().isElementDisplayed("Hotels_CTA");
		verify.get().isTextPresent("IndustryVertical_HealthCareProviders_Header");
		businessFunction.get().imageValidation("Healthcare_Image");
		businessFunction.get().contentValidation("Healthcare_Description");
		verify.get().isElementDisplayed("Healthcare_CTA");
		verify.get().isTextPresent("IndustryVertical_Education_Header");
		businessFunction.get().imageValidation("Education_Image");
		businessFunction.get().contentValidation("Education_Description");
		verify.get().isElementDisplayed("Education_CTA");
		verify.get().isTextPresent("IndustryVertical_StateandLocalgov_Header");
		businessFunction.get().imageValidation("State_Local_Image");
		businessFunction.get().contentValidation("State_Local_Description");
		verify.get().isElementDisplayed("State_Local_CTA");
		verify.get().isTextPresent("IndustryVertical_Fedlgov_Header");
		businessFunction.get().imageValidation("Federal_Image");
		businessFunction.get().contentValidation("Federal_Description");
		verify.get().isElementDisplayed("Federal_CTA");
		
	}
	
	
	/**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 14-07-2014
	  Date of Modified                  : --
	  Methods Called                    : isTextPresent(String controlName),isElementDisplayed(String controlName),
	  									  verifyBreadCrumb(String actualControlName, String expectedControlName,String tagName),
	  									  pageAllignment(String relativeControlName, String controlName, String position)	  									  
	  Purpose of Method                 : Verify the display of IPV6 on Avaya Page.
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 
	 
	  **/
	
	@Test(description="Verify the display of IPV6 on Avaya Page",groups="Products")
	public void testIPv6Page() 
	{
		//To launch Avaya IPv6 website
		getDriver().get(appConfig.getIpv6Url());
		//To verify whether the IPv6 title is displayed or not
		verify.get().isTextPresent("IPV6_Title");
		//To verify whether the Butler bar is displayed or not
		verify.get().isElementDisplayed("ButlerBar");
		//To verify whether the megamenu is displayed or not
		verify.get().isElementDisplayed("Megamenu");
		//To verify whether the breadcrumb is displayed or not
		businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "IPv6BreadcrumbExpected","Tag_Anchors");
		//To verify whether the List of IPV6 products is present under heading 'AVAYA IPV6 COMPLIANT PRODUCTS' on left navigation menu
		businessFunction.get().pageAllignment("IPv6TitleRelative", "IPv6ListOfProducts", "above");
		//To verify whether the static Image is present or not
		businessFunction.get().imageValidation("IPv6Image");
		//To verify whether the related content is present or not
		businessFunction.get().contentValidation("IPv6RelatedContent");
		//To verify whether the Footer is displayed or not
		verify.get().isElementDisplayed("Footer");
	}
	
	
	/**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 31-07-2014
	  Date of Modified                  : --
	  Methods Called                    : isTextPresent(String controlName),isElementDisplayed(String controlName),
	  									  verifyBreadCrumb(String actualControlName, String expectedControlName,String tagName),
	  									  pageAllignment(String relativeControlName, String controlName, String position)	  									  	  									  
	  Purpose of Method                 : Verify the display of Software Defined Networking on Avaya Page.
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 
	 
	  **/
	
	@Test(description="Verify the display of Software Defined Networking on Avaya Page",groups="Solutions")
	public void testSDNPage() 
	{
		//To launch Avaya SDN website
		getDriver().get(appConfig.getSdnUrl());
		//To verify whether the IPv6 title is displayed or not
		verify.get().isTextPresent("SDN_Title");
		//To verify whether the Butler bar is displayed or not
		verify.get().isElementDisplayed("ButlerBar");
		//To verify whether the megamenu is displayed or not
		verify.get().isElementDisplayed("Megamenu");
		//To verify whether the breadcrumb is displayed or not
		businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "SDNBreadcrumbExpected","Tag_Anchors");
		/*//To verify whether the List of IPV6 products is present under heading 'AVAYA IPV6 COMPLIANT PRODUCTS' on left navigation menu
		businessFunction.get().pageAllignment("SDNTitleRelative", "SDNListOfProducts", "equal");
		//To verify whether the Static Image is present or not
		businessFunction.get().imageValidation("SDNImage");
		//To verify whether the related content is present or not
		businessFunction.get().contentValidation("SDNRelatedContent");*/
		//To verify whether the Footer is displayed or not
		verify.get().isElementDisplayed("Footer");
	}
	
	/**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 31-07-2014
	  Date of Modified                  : --
	  Methods Called                    : checkContainsChildElements(String controlName,String childElement,String delimiter),
	  									  verifyImagePresent(String expectedImage, String imageElement),
	  									  clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle),
	  									  isElementDisplayed(String controlName),isTextPresent(String controlName),
	  									  verifyBreadCrumb(String actualControlName, String expectedControlName,String tagName)
	  Purpose of Method                 : Verify the content in Overview page
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 
	 
	  **/
	
	@Test(description="Verify the content in Overview page",groups="Promotions & Programs")
	public void testPromotionsProgramsOverviewContent() 
	{
		//Launching the Avaya Website
	    getDriver().get(appConfig.getAppUrl());
	    dynamicWait.get().waittillpageloads();
	    //Navigate to footer section and hover the mouse on Quick links tab
	    userActions.get().hoverOn("Home_QuickLinks");
	    //To check if options are displayed when hovered on Quick Links
	    businessFunction.get().verifyMenuOrCategoryLinks("QuickLinks_ChildElements");
	    //To click on Promotions & Programs link and check the title on the page
	    businessFunction.get().clickOnSubMenuItem("Home_QuickLinks", "PromotionsAndPrograms", "PromotionsAndPrograms_Title");
	    //To check the presence of Find A Partner CTA
	    verify.get().isTextPresent("Find_A_Partner_CTA");
	    businessFunction.get().verifyMenuOrCategoryLinks("Find_A_Partner_CTA");
	    //To verify whether the Image is present or not
	    businessFunction.get().imageValidation("PromotionsProgramsOverviewImage");
	    //To verify whether the related content is present or not
	    businessFunction.get().contentValidation("PromotionsProgramsOverviewRelatedContent");
	    //To verify whether the breadcrumb is present or not
	    businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "PromotionsProgramsOverviewExpected","Tag_Anchors");
	}
	  /**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 31-07-2014
	  Date of Modified                  : --
	  Methods Called                    : checkContainsChildElements(String controlName,String childElement,String delimiter),
	  									  verifyImagePresent(String expectedImage, String imageElement),
	  									  clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle),
	  									  isElementDisplayed(String controlName),isTextPresent(String controlName),
	  									  verifyBreadCrumb(String actualControlName, String expectedControlName,String tagName),
	  									  Click_VerifyNavigation(String navigatetopage,String pageTitle)
	  Purpose of Method                 : Verify the content in Promotions for Contact Centers page
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 
	 
	  **/
	
	  @Test(description="Verify the content in Promotions for Contact Centers page",groups="Promotions & Programs")
	  public void testPromotionsForContactCentersContent() 
	  {
		  //Launching the Avaya Website
	  	  getDriver().get(appConfig.getAppUrl());
	  	  dynamicWait.get().waittillpageloads();
	  	  //Navigate to footer section and hover the mouse on Quick links tab
	  	  userActions.get().hoverOn("Home_QuickLinks");
	  	  //To check if options are displayed when hovered on Quick Links
	  	  businessFunction.get().verifyMenuOrCategoryLinks("QuickLinks_ChildElements");
	  	  //To click on Promotions & Programs link
	  	  businessFunction.get().clickOnSubMenuItem("Home_QuickLinks", "PromotionsAndPrograms", "PromotionsAndPrograms_Title");
	  	  //To click on the Promotions for Contact Centers link
	  	  businessFunction.get().clickAndVerifyNavigation("PromotionsForContactCenters", "PromotionsForContactCentersTitle");
	      //To check the presence of Find A Partner CTA
	  	  verify.get().isTextPresent("Find_A_Partner_CTA");
	  	  businessFunction.get().verifyMenuOrCategoryLinks("Find_A_Partner_CTA");
	  	  //To verify whether the Image is present or not
	  	  businessFunction.get().imageValidation("PromotionsForContactCentersImage");
	  	  //To verify whether the related content is present or not
	  	  businessFunction.get().contentValidation("PromotionsForContactCentersRelatedContent");
	  	  //To verify whether the breadcrumb is present or not
	  	  businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "PromotionsForContactCentersExpected","Tag_Anchors");
	  	  //To verify whether the Avaya Software Investment Protection Program content with Learn More CTA is present or not
	  	  verify.get().isElementDisplayed("AvayaSoftwareInvestmentProtectionProgramPod");
	  	  verify.get().isTextPresent("AvayaSoftwareInvestmentProtectionProgramPod_Header");
	  	  businessFunction.get().contentValidation("AvayaSoftwareInvestmentProtectionProgramPod_Content");
	  	  verify.get().isTextPresent("AvayaSoftwareInvestmentProtectionProgramPod_LearnMore");
	  	  businessFunction.get().verifyMenuOrCategoryLinks("AvayaSoftwareInvestmentProtectionProgramPod_LearnMore");  	  
	  }
	  
	  
	  /**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 31-07-2014
	  Date of Modified                  : --
	  Methods Called                    : checkContainsChildElements(String controlName,String childElement,String delimiter),
	  									  verifyImagePresent(String expectedImage, String imageElement),
	  									  clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle),
	  									  isElementDisplayed(String controlName),isTextPresent(String controlName),
	  									  verifyBreadCrumb(String actualControlName, String expectedControlName,String tagName),
	  									  Click_VerifyNavigation(String navigatetopage,String pageTitle)
	  Purpose of Method                 : Verify the content in Avaya Software Investment Protection Program
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 
	 
	  **/
	  
	  @Test(description="Verify the content in Avaya Software Investment Protection Program",groups="Promotions & Programs")
	  public void testContactCenterSoftwareInvestmentContent() 
	  {
		  //Launching the Avaya Website
	  	  getDriver().get(appConfig.getAppUrl());
	  	  dynamicWait.get().waittillpageloads();
	  	  //Navigate to footer section and hover the mouse on Quick links tab
	  	  userActions.get().hoverOn("Home_QuickLinks");
	  	  //To check if options are displayed when hovered on Quick Links
	  	  businessFunction.get().verifyMenuOrCategoryLinks("QuickLinks_ChildElements");
	  	  //To click on Promotions & Programs link
	  	  businessFunction.get().clickOnSubMenuItem("Home_QuickLinks", "PromotionsAndPrograms", "PromotionsAndPrograms_Title");
	  	  //To click on the Promotions for Contact Centers link and check the title on the page
	  	  businessFunction.get().clickAndVerifyNavigation("PromotionsForContactCenters", "PromotionsForContactCentersTitle"); 
	  	  //To click on the Learn More link and check whether the title is being displayed or not
	  	  businessFunction.get().clickAndVerifyNavigation("ContactCentersLearnMore", "ContactCentersLearnMoreHeader");
	  	  //To check the presence of Find A Partner CTA
	  	  verify.get().isTextPresent("Find_A_Partner_CTA");
	  	  businessFunction.get().verifyMenuOrCategoryLinks("Find_A_Partner_CTA");
	  	  //To verify whether the Image is present or not
	  	  businessFunction.get().imageValidation("PromotionsForContactCentersImage");
	  	  //To verify whether the related content is present or not
	  	  businessFunction.get().contentValidation("AvayaSoftwareInvestmentRelatedContent");
	  	  //To verify whether the breadcrumb is present or not
	  	  businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "AvayaSoftwareInvestmentExpected","Tag_Anchors");
	  }
	  
	  /**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 31-07-2014
	  Date of Modified                  : --
	  Methods Called                    : checkContainsChildElements(String controlName,String childElement,String delimiter),
	  									  checkToggleMenuDetails(String parentControlName,String childElement,String controlName,String delimiter),
	  									  clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle),
	  									  toggleMenuArrows(String actualControlName,String expectedControlName,String direction)
	  Purpose of Method                 : Verify the options present under Networking tab
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	  **/
	  
	  @Test(description="Verify the options present under Networking tab",groups="Promotions & Programs")
	  public void testPromotionsProgramsNetworkingTabOptions()
	  {
		  //Launching the Avaya Website
	  	  getDriver().get(appConfig.getAppUrl());
	  	  dynamicWait.get().waittillpageloads();
	  	  //Navigate to footer section and hover the mouse on Quick links tab
	  	  userActions.get().hoverOn("Home_QuickLinks");
	  	  //To check if options are displayed when hovered on Quick Links
	  	  businessFunction.get().verifyMenuOrCategoryLinks("QuickLinks_ChildElements");
	  	  //To click on Promotions & Programs link
	  	  businessFunction.get().clickOnSubMenuItem("Home_QuickLinks", "PromotionsAndPrograms", "PromotionsAndPrograms_Title");
	  	  //To verify whether the Promotions for Networking options is present under Networking tab
	  	  businessFunction.get().checkToggleMenuDetails("PromotionsProgramsPromotionsNetworking", "Tag_Anchors", "PromotionsProgramsNetworkingTab",",");
	  	  //To verify whether the arrow is pointing upwards
	  	  businessFunction.get().checkToggleMenuArrows("PromotionsProgramsNetworkingTab", "Expanded_Arrow", "up");
	  	  //To click on the Networking tab
	  	  userActions.get().clickOn("PromotionsProgramsNetworkingTab");
	  	  //To verify whether the arrow is pointing downwards
	  	  businessFunction.get().checkToggleMenuArrows("PromotionsProgramsNetworkingTab", "Collapsed_Arrow", "down");
	  }
	  
		/**
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 31/07/2014
	  Date of Modified                  : --
	  Methods Called                    : clickOn(String controlName),deFocus(),enterText(String controlName,String text),
	  									isElementDisplayed(String controlName),
	  Purpose of Method                 : Verify the Pagination in GSA Search Page
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/
	@Test(description = "Verify the Pagination in GSA Search Page",groups = "GSA Search page")
	public void testGsaSearchPagination(){
		//Launching the Avaya website
		getDriver().get(appConfig.getAppUrl());
		//Enter text in Search Box present in Global Header
		dynamicWait.get().waittillpageloads();
		userActions.get().enterText("GlobalHeaderSearchBox", "Avaya");
		//Click on Search Button in Global Header
		userActions.get().clickOn("GlobalHeaderSearchBoxButton");
		//Verify the '1' is highlighted in Pagination as its displaying the '1' page
		dynamicWait.get().waittillpageloads();
		verify.get().isElementDisplayed("Pagination_Page1");
		if("chrome".equalsIgnoreCase(threadDriver.get().getCapabilities().getBrowserName())){			
			businessFunction.get().checkMultipleCSSProperties("Pagination_Page1","font-weight");			
		}else{
			businessFunction.get().checkMultipleCSSProperties("Pagination_Page1Firefox","font-weight");
		}
		//Click on Next link from Pageination
		userActions.get().clickOn("Pagination_Next");
		//Verify its displaying the page 2 and '2' is highlighted in the Pagination displayed
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		verify.get().isElementDisplayed("Pagination_Page2");
		if("chrome".equalsIgnoreCase(threadDriver.get().getCapabilities().getBrowserName())){			
			businessFunction.get().checkMultipleCSSProperties("Pagination_Page2","font-weight");			
		}else{
			businessFunction.get().checkMultipleCSSProperties("Pagination_Page2Firefox","font-weight");
		}
		//Click on Prev Link
		userActions.get().clickOn("Pagination_Prev");
		//Verify its displaying the page 1 and '1' is highlighted in the Pagination displayed
		dynamicWait.get().waittillpageloads();
		verify.get().isElementDisplayed("Pagination_Page1");
		if("chrome".equalsIgnoreCase(threadDriver.get().getCapabilities().getBrowserName())){			
			businessFunction.get().checkMultipleCSSProperties("Pagination_Page1","font-weight");			
		}else{
			businessFunction.get().checkMultipleCSSProperties("Pagination_Page1Firefox","font-weight");
		}
		//Click on '3' page link on the Pagination displayed
		userActions.get().clickOn("Pagination_Page3Link");
		//Verify its displaying the page 3 and '3' is highlighted in the Pagination displayed
		dynamicWait.get().waittillpageloads();
		verify.get().isElementDisplayed("Pagination_Page3Link");
		if("chrome".equalsIgnoreCase(threadDriver.get().getCapabilities().getBrowserName())){			
			businessFunction.get().checkMultipleCSSProperties("Pagination_Page2","font-weight");			
		}else{
			businessFunction.get().checkMultipleCSSProperties("Pagination_Page2Firefox","font-weight");
		}
		
	}
	
	/**
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 31/07/2014
	  Date of Modified                  : --
	  Methods Called                    : clickOn(String controlName),enterText(String controlName,String text),isTextPresent(String controlName) 
	  										sendinputdata(String controlName, String option, String searchControlName)
	  Purpose of Method                 : Verify that a Magazine is subscribed in Perspective Avaya Magazine page
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	 
	**/
	@Test(description = "Verify that a Magazine is subscribed in Perspective Avaya Magazine page",groups = "Perspectives")
	public void testPerspectivesMagazinesSubscribe() throws AdbCommandRejectedException{
		//Launching the Avaya website
		getDriver().get(appConfig.getAppUrl());
		//Click on Perspective MegaMenu
		try {
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "Perspectives_SubMenu", "PerspectivesTitlePage");
		businessFunction.get().deFocus();
		//Click on the Archives link on the AVAYA MAGAZINE Rail
		dynamicWait.get().waittillpageloads();
		userActions.get().clickOn("AvayaMagazine_ArchiveLink");
			Thread.sleep(5000);
		//Verify the Magazine Header				
		userActions.get().switchToChildWindow();
		Thread.sleep(5000);
		verify.get().isTextPresent("AvayaMagazine_Header");
		//Click on Subscribe
		userActions.get().clickOn("Perspectives_subscribe");
		//Verify the fields in Subscribe Form
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		businessFunction.get().verifySubMenuElements("Subscribe_Parent", "Child_Label_Items",",");
		verify.get().isElementDisplayed("Subscription_Firstname");
		verify.get().isElementDisplayed("Subscription_LastName");
		verify.get().isElementDisplayed("Subscription_EmailAddress");
		verify.get().isElementDisplayed("Subscription_Company");
		verify.get().isElementDisplayed("Subscription_CountryName");
		verify.get().isElementDisplayed("Subscription_BusinessSize");
		
		//Enter details in Subscribe Form
		businessFunction.get().sendinputdata("subscriptioninputdata", "subscription","none");
		userActions.get().clickOn("Perspectives_subscribe_SubmitForm");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
	}
	
	/**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 31/07/2014
	  Date of Modified                  : --
	  Methods Called                    : deFocus(String controlName),checkSelectedTabActive(String controlName, String childElement,String str_selectedtabname)
	                                      verifySubMenuElements(String controlName,String childElement),pageAllignment(String relativeControlName, String controlName, String position)
	                                      checkSearchCount(String selectionlist, String searchCriteria),enterText(String controlName,String text),clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle)
	  Purpose of Method                 : Verify if the user is able to search for services using valid input
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	 
	 
	**/
	
	@Test(description="Verify if the user is able to search for services using valid input",groups="Services")
	public void testServiceDetailCustomerSuccessSearch()  {
		//Launching the Avaya Website
		getDriver().get(appConfig.getAppUrl());
		//To click on the Contact Center Optimization from the Services tab
		businessFunction.get().clickOnSubMenuItem("Services",
				"ContactCenterOptimization", "ContactCenterOptimization_Title");
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		//To check whether the Overview tab has been selected or not 
		businessFunction.get().checkSelectedTabActive(
				"Services_CCO_Parent_Tab", "Tag_List", "OVERVIEW");
		//To Click on the Case Studies tab 
		userActions.get().clickOn("Services_CaseStudies_tab");
		//Verify if Case Studies Tab is Selected
		businessFunction.get().checkSelectedTabActive(
				"Services_CCO_Parent_Tab", "Tag_List", "CASE STUDIES");
		//To enter valid input in the search box
		userActions.get().enterText("Services_SearchBox","Avaya");
		//To click on the Magnifier button
		businessFunction.get().deFocus();
		userActions.get().clickOn("CaseStudies_SearchButton");
		dynamicWait.get().waittillpageloads();
		// To check if "<Count> Case Studies match your search criteria" is
		// displayed
		verify.get().verifyElementContainsText("ServicesCaseStudies_Text",
				"CaseStudies_Message");
		//Verify if SortResultsBy Section is displayed 
		verify.get().isElementDisplayed("CaseStudies_SortResultsBySection");
		verify.get().isTextPresent("CaseStudies_SortbyContainer");
		//Verify if Name is Present in SortResultsBy Section
		businessFunction.get().verifySubMenuElements(
				"CaseStudies_SortResultsBy", "Tag_Anchors", ",");
		// To check if The number of CASE STUDIES Search displayed in the text
		// matches with results obtained in the results area
		businessFunction.get().checkSearchCount("CaseStudies_Results",
				"CaseStudies_Text");
		//To check if results are  displayed  in the right side of the page
		businessFunction.get().pageAllignment("ButlerBar",
				"CaseStudies_ResultsSection", "right");
		
	}
	
	/**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 31/07/2014
	  Date of Modified                  : --
	  Methods Called                    : isElementDisplayed(String controlName),isTextPresent(String controlName),compareFont(String relativeControlName,String controlName)
	                                      clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle),checkSelectedTabActive(String controlName, String childElement,String str_selectedtabname) 
	  Purpose of Method                 : Verify if the contents of the Component Services in the Detail page
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/	
	
	@Test(description="Verify if the contents of the Component Services in the Detail page",groups="Services")
	public void testServiceDetailComponentServices() 
	{
		//Launching the Avaya Website
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		//To click on the Contact Center Managed Services from the Services tab
		businessFunction.get().clickOnSubMenuItem("Services", "ContactCenterManagedServices", "ContactCenterManagedServices_Title");
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		//To check whether the Overview tab has been selected or not 
		businessFunction.get().checkSelectedTabActive("Services_CCO_Parent_Tab", "Tag_List", "OVERVIEW");
		//To click on the Service Details tab
		userActions.get().clickOn("ServiceDetails");
		//To check whether the Service Details tab has been selected or not 
		businessFunction.get().checkSelectedTabActive("Services_CCO_Parent_Tab", "Tag_List", "SERVICE DETAILS");
		//To check the presence of Component Services Text in Component Services pod
		businessFunction.get().contentValidation("ComponentServices_Content");
		//To check the if font size ofComponent Services title is more than static text
		businessFunction.get().compareFont("ComponentServices_Text","ComponentServices_Title");			
	}
	
	

	/**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 31/07/2014
	  Date of Modified                  : --
	  Methods Called                    : verifyImagePresent(String expectedImage, String imageElement),isTextPresent(String controlName),isElementDisplayed(String controlName)
	                                      pageAllignment(String relativeControlName, String controlName, String position),clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle)
	  Purpose of Method                 : Verify the categories and spotlight content when hovered on Products Megamenu
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/
	
	@Test(description="Verify the categories and spotlight content",groups="Products")
	public void testProductsMegamenu() 
	{
		//Launching the Avaya website
		getDriver().get(appConfig.getAppUrl());
		//Hover on Products in mega menu
		userActions.get().hoverOn("Products");
		//To check the presence of the Spotlight Image  on hovering of Products Megamenu
		businessFunction.get().imageValidation("Products_SpotlightImage");		
		//To check the presence of the Spotlight Image to the right side of Megamenu  on hovering of Products Megamenu
		businessFunction.get().pageAllignment("Megamenu","Products_SpotlightImage","right");
		//To hover on Products Megamenu
		userActions.get().hoverOn("Products");
		//To check the presence of the CTA in Spotlight Image  on hovering of Products Megamenu
		businessFunction.get().contentValidation("Products_SpotlightImage_CTA");
		//To check the presence  Spotlight Image  on hovering of Products Megamenu
		businessFunction.get().imageValidation("Products_SpotlightImage");
		//Checking for the presence of Unified Communication and Collaboration category on hovering of Products Megamenu
		businessFunction.get().clickOnSubMenuItem("Products", "Products_Category1", "Products_Category1_Title");
		//Checking for the presence of Customer Experience Management  on hovering of Products Megamenu
		businessFunction.get().clickOnSubMenuItem("Products", "Products_Category2", "Products_Category2_Title");
		//Checking for the presence of Networking category on hovering of Products Megamenu
		businessFunction.get().clickOnSubMenuItem("Products", "Products_Category3", "Products_Category3_Title");
		//Checking for the presence of  Cloud category  on hovering of Products Megamenu
		businessFunction.get().clickOnSubMenuItem("Products", "Products_Category4", "Products_Category4_Title");		
	}	
	
	
	/**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 31/06/2014
	  Date of Modified                  : --
	  Methods Called                    : Click_VerifyNavigation(String navigatetopage,String pageTitle),deFocus(String controlName),isElementNotPresent(String controlName)
	                                      verifySubMenuElements(String controlName,String childElement),checkPodsCountAndTitle(String controlName,String count,String childElement),isTextPresent(String controlName)
	                                      isElementDisplayed(String controlName),verifyImagePresent(String expectedImage, String imageElement),hoverOn(String controlName)  
	  Purpose of Method                 : Verify the Details present in the Promotional Pods
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/
	

	@Test(description="Verify the Details present in the Promotional Pods",groups="Solutions")
	public void testCapabiltiesLandingPagePromotionalPods() 
	{
		//Launching the Avaya Website
		getDriver().get(appConfig.getAppUrl());
		//To click on Capabilities tab in Megamenu
		businessFunction.get().clickAndVerifyNavigation("Solutions", "Capabilities_Title");
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		//To check if User is to view four promotional pods with titles
		businessFunction.get().verifyElementsByCount("ParentPods_Title", 7);
		businessFunction.get().checkPodsTitle("ParentPods_Title","Tag_Header");
		//To check whether the Image, CTA and the description  are present for First pod.
		businessFunction.get().imageValidation("CustomerEngagement_Image");
		businessFunction.get().contentValidation("CustomerEngagement_Description");
		verify.get().isElementDisplayed("CustomerEngagement_CTA");
		//To check whether the Image, CTA and the description  are present for Second pod.
		businessFunction.get().imageValidation("Team Engagement_Image");
		businessFunction.get().contentValidation("Team Engagement_Description");
		verify.get().isElementDisplayed("Team Engagement_CTA");
		//To check whether the Image, CTA and the description  are present for Third pod.
		businessFunction.get().imageValidation("Fabric Networking_Image");
		businessFunction.get().contentValidation("Fabric Networking_Description");
		verify.get().isElementDisplayed("Fabric Networking_CTA");
		//To check whether the Image, CTA and the description  are present for Fourth pod.
		businessFunction.get().imageValidation("Engagement Environment_Image");
		businessFunction.get().contentValidation("Engagement Environment_Description");
		verify.get().isElementDisplayed("Engagement Environment_CTA");
		//To check whether the Image, CTA and the description  are present for fifth pod.
		businessFunction.get().imageValidation("Industry Vertical_Image");
		businessFunction.get().contentValidation("Industry Vertical_Description");
		verify.get().isElementDisplayed("Industry Vertical_CTA");
		//To check whether the Image, CTA and the description  are present for sixth pod.
		businessFunction.get().imageValidation("Midmarket Business_Image");
		businessFunction.get().contentValidation("Midmarket Business_Description");
		verify.get().isElementDisplayed("Midmarket Business_CTA");
		//To check whether the Image, CTA and the description  are present for seventh pod.
		businessFunction.get().imageValidation("Mobility_Image");
		businessFunction.get().contentValidation("Mobility_Description");
		verify.get().isElementDisplayed("Mobility_CTA");
		//To check whether the Image, CTA and the description  are present for eighth pod.
		/*businessFunction.get().imageValidation("Cloud_Image");
		businessFunction.get().contentValidation("Cloud_Description");
		verify.get().isElementDisplayed("Cloud_CTA");*/
		//To check if user is able to view a fly out menu on hovering of Explore Customer Engagement CTA
		userActions.get().hoverOn("CustomerEngagement_CTA");
		verify.get().isElementDisplayed("Customer Engagement_Flyout");
		//businessFunction.get().verifySubMenuElements("Customer Engagement_Flyout", "Tag_List",",");
		//To check if User is not able to view a fly out menu on hovering of Explore Midmarket Business tab
		userActions.get().hoverOn("Midmarket Business_CTA");
		verify.get().isElementNotPresent("MidmarketBusiness_Tab");
		//To check if User is not able to view a fly out menu on hovering of  Explore Industry tab
		userActions.get().hoverOn("Industry Vertical_CTA");
		verify.get().isElementNotPresent("IndustryVertical_Tab");
		//To check if user is able to view a fly out menu on hovering of Explore Team Engagement CTA
		userActions.get().hoverOn("Team Engagement_CTA");
		businessFunction.get().verifySubMenuElements("Team Engagement_Flyout", "Tag_List",",");		
	}
	
	/**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 31/07/2014
	  Date of Modified                  : --
	  Methods Called                    : isElementDisplayed(String controlName),isTextPresent(String controlName),verifyImagePresent(String expectedImage, String imageElement)
	                                      check_css_property(String controlName, String cssProperty),toggleMenuArrows(String actualControlName,String expectedControlName,String direction)
	                                      verifyBreadCrumb(String actualControlName, String expectedControlName,String tagName),check_ChildElements(String controlName,String childElement,String delimiter)
	                                      pageAllignment(String relativeControlName, String controlName, String position)
	  Purpose of Method                 : Verify the Investors Landing Page
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	 
	 
	**/	
	
	@Test(description="Verify the Investors Landing Page",groups="Investors")
	public void testInvestorsHomePage()  
	{
		//Launching the Investors Avaya website
		getDriver().get(appConfig.getInvUrl());
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		//To check if Investors home page is be displayed
		verify.get().isTextPresent("Investors_Title");
		//To check the presence of Butler bar		
		verify.get().isElementDisplayed("ButlerBar");
		//To check the presence of Mega Navigation menu
		verify.get().isElementDisplayed("Megamenu");
		//To check the presence of Bread crumb
		businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "Investors_Expected_Breadcrumb","Tag_List");
		//To check the presence of Title
		verify.get().isTextPresent("Investors_Title");
		//To check the presence of one line description
		businessFunction.get().contentValidation("Investors_SubTitle");
		//To check the presence of Image 
		businessFunction.get().imageValidation("Investors_HeroImage");
		//To verify if the toggle menu is present to the left of the page
		verify.get().isElementDisplayed("Investors_ToggleMenu");
		businessFunction.get().pageAllignment("ButlerBar", "Investors_ToggleMenu", "equal");
		//To verify if Toggle menu is displayed with sections
		//businessFunction.get().verifySubMenuElements("Investors_CostBasisAnalysis_ToggleMenu", "Tag_Span",",");
		//To verify if arrows in the  toggle menu are  pointed upward by default
		businessFunction.get().checkToggleMenuArrows("Investors_ShareHolderServices_Expanded_Arrow","Expanded_Arrow","up");
		businessFunction.get().checkToggleMenuArrows("Investors_Financials_Expanded_Arrow","Expanded_Arrow","up");
		businessFunction.get().checkToggleMenuArrows("Investors_Events_Expanded_Arrow","Expanded_Arrow","up");
		businessFunction.get().checkToggleMenuArrows("Investors_SEC_Expanded_Arrow","Expanded_Arrow","up");
		businessFunction.get().checkToggleMenuArrows("Investors_CorpGov_Expanded_Arrow","Expanded_Arrow","up");
		//Click on Shareholder Services
		userActions.get().clickOn("Investors_ShareHolderServices");
		//To check whether Shareholder Services Section is collapsing
		//businessFunction.get().checkCssProperty("Investors_ShareHolderServices_Collapsed","display");
		//The arrow of Shareholder Services Section should be pointed towards downward 
		businessFunction.get().checkToggleMenuArrows("Investors_ShareHolderServices_Collapsed_Arrow","Collapsed_Arrow","down");
		//To check the presence of Footer section
		verify.get().isElementDisplayed("Footer");			
	}
	
	/** 
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 31/06/2014
	  Date of Modified                  : --
	  Methods Called                    : verifyImagePresent(String expectedImage, String imageElement), isTextPresent(String controlName)
	  Purpose of Method                 : Verify the presence of the HeroImage In Investors Avaya Home Page
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	 
	 
	**/
	
	@Test(description="Verify the presence of the HeroImage In Investors Avaya Home Page",groups="Investors")
	public void testInvestorsHeroImage()  
	{
	    //Launching the Investors Avaya website
		getDriver().get(appConfig.getInvUrl());
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		//To check if Investors home page is be displayed
		verify.get().isTextPresent("Investors_Title");
		//To check the presence of the HeroImage in the Investors Avaya Home page.
		businessFunction.get().imageValidation("Investors_HeroImage");		
	}	
	
	/** 
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 10/06/2014
	  Date of Modified                  : --
	  Methods Called                    : isTextPresent(String controlName),Click_VerifyNavigation(String navigatetopage,String pageTitle),verifyImagePresent(String expectedImage, String imageElement)
	  Purpose of Method                 : Verify if the user is able to view Contact Board of Directors page in webpage
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	 
	 
	**/
	
	@Test(description="Verify if the user is able to view Contact Board of Directors page in webpage",groups="Investors")
	public void testInvestorsContactBoardofDirectors()  
	{
		//Launching the Investors Avaya website
		getDriver().get(appConfig.getInvUrl());
		dynamicWait.get().waittillpageloads();
		//To check if Investors home page is be displayed
		verify.get().isTextPresent("Investors_Title");
		//To click on the Contact Board of Directors
		businessFunction.get().clickAndVerifyNavigation("Investors_ContactBoardofDirectorslink", "Investors_CorporateGovernance_Title");
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		//To check the presence of the HeroImage on the page
		businessFunction.get().imageValidation("Investors_ContactBoardofDirectors_HeroImage");
		//To check the presence of the Description and Address 
		dynamicWait.get().waittillpageloads();
		businessFunction.get().contentValidation("Investors_ContactBoardofDirectors_All");
		//To check the presence of the EmailId
		businessFunction.get().contentValidation("Investors_ContactBoardofDirectors_EmailId");
	}
	
	/**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 03/07/2014
	  Date of Modified                  : --
	  Methods Called                    : check_ChildElements(String controlName,String childElement), pageAllignment(String relativeControlName, String controlName, String position)                                     
	                                      isElementDisplayed(String controlName),verifyBreadCrumb(String actualControlName, String expectedControlName,String tagName)
	                                      isTextPresent(String controlName),toggleMenuArrows(String actualControlName,String expectedControlName,String direction),verifyImagePresent(String expectedImage, String imageElement)
	  Purpose of Method                 : Verify if the user is able to view Overview page in Avaya Labs page
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	 
	 
	**/
	@Test(description="Verify if the user is able to view Overview page in Avaya Labs page",groups="Avaya Labs ")
	public void testAvayaLabsOverviewPage()  
	{
	    //Launch the Avaya Labs Page
	    getDriver().get(appConfig.getAvayaLabsUrl());
	    dynamicWait.get().waittillpageloads();
		//To check if Avaya Labs page is displayed.
	    verify.get().isTextPresent("AvayaLabs_Title");
	    //To verify if toggle menu is present in the left of the page 
	    businessFunction.get().pageAllignment("ButlerBar", "AvayaLabs_ToggleMenu", "equal");
	    //To verify if toggle menu is present with the options
	    businessFunction.get().verifySubMenuElements("AvayaLabs_ToggleMenu", "Tag_Span",",");
	    //To click on overview from left toggle menu
	    userActions.get().clickOn("AvayaLabs_Overview");
	    //To verify the presence of Bread crumb in Overview page
	    businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "AvayaLabs_Overview_ExpectedBreadCrumb","Tag_Anchors");
	    //To verify the presence of title in Overview page
	    verify.get().isTextPresent("AvayaLabs_Title");
	    //To verify the presence of toggle menu in Overview page
	    businessFunction.get().checkToggleMenuArrows("AvayaLabs_ToggleMenu_Overview", "Expanded_Arrow", "up");
	    businessFunction.get().checkToggleMenuArrows("AvayaLabs_ToggleMenu_People", "Expanded_Arrow", "up");
	    //To verify the presence of Image in Overview page
	    businessFunction.get().imageValidation("AvayaLabs_Overview_Image");
	    //To verify the presence of Image title in Overview page
	    businessFunction.get().contentValidation("AvayaLabs_Overview_ImageTitle");
	    //To verify the presence of Related Description in Overview page
	    businessFunction.get().contentValidation("AvayaLabs_Overview_Description");
	    //To verify the presence of More information pod in Overview page
	    verify.get().isElementDisplayed("AvayaLabs_Overview_MoreInfoPod"); 
	    businessFunction.get().contentValidation("AvayaLabs_Overview_MoreInfoPod"); 
	}
	
	/**
	  Author Name                       : Phanendra Ketavarapu
	  Date of Preparation               : 19/06/2014
	  Date of Modified                  : 02-09-2014
	  Methods Called                    : clickOn(String controlName),isElementDisplayed(String ControlName) ,pageAllignment(String relativeControlName, String controlName, String position)
	  Purpose of Method                 : Verify Indicator buttons and images on the Home page image carousel
	  Dependencies	                    : clickOn(userActions.get()),verifyImageActive(userActions.get())
	  Reviewed By                       : --
	**/            
	@Test(description="wi01155380_Home page HP Marquee_Verify images on click of indicator",groups="Home Page")
	public void testHPImageCarouselClickIndicator()
	{
		//Launch the avaya website
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		//click on 5th indicator button
		userActions.get().clickOn("IndicatorButton5");
		//verify image
		verify.get().verifyHttpResponse("HomePage_HeroCarousel");
		//click on 4th indicator button
		userActions.get().clickOn("IndicatorButton4");
		//verify image
		verify.get().verifyHttpResponse("HomePage_HeroCarousel");
		//click on 3th indicator button
		userActions.get().clickOn("IndicatorButton3");
		//verify image
		verify.get().verifyHttpResponse("HomePage_HeroCarousel");
		//click on 2th indicator button
		userActions.get().clickOn("IndicatorButton2");
		//verify image
		verify.get().verifyHttpResponse("HomePage_HeroCarousel");
		//click on 1th indicator button
		userActions.get().clickOn("IndicatorButton1");
		//verify image
		verify.get().verifyHttpResponse("HomePage_HeroCarousel");
	}
	
	/** 
	  Author Name                       : @author karthik_b14
	  Date of Preparation               : 15/07/2014
	  Date of Modified                  : 02-09-2014
	  Methods Called                    : 
	  Purpose of Method                 : Verify Support Option module on the Phones Landing Page
	  Dependencies	                   	: --
	  Reviewed By                       : --
	* 
	**/
@Test(description="Verify Support Option module on the Phones Landing Page", groups="Phones")
	public void testPhoneLandingPageSupportOption(){			
		//navigate to app URL
		getDriver().get(appConfig.getAppUrl());
		//Click on the products, System should display Products Landing page
		businessFunction.get().clickAndVerifyNavigation("Products", "Products_label");
		//Click on "Phones" Link which is displayed in the products Grid and verify the selection
		businessFunction.get().verifyArticleNavigation("Phones", "Phones_Selection");
		//verify Display of Support Option module on Phones Landing page
		verify.get().isElementPresent("Products_SupportOptionsPod");
		/*User should able to see the Support Option module on Phones Landing page with the following Details
		•Contact US
		-Billing Questions: 1-866-328-7834
		-"Technical Information:" Label with "Visit Support Site" Link 
		•"CUSTOMER TRAINING" Link 
		•"SUPPORT FORUMS" Link
		•"AVAYA PRODUCTS" Link*/
		businessFunction.get().contentValidation("supportoptions");			
	}
	
	/**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 31/07/2014
	  Date of Modified                  : --
	  Methods Called                    : Click_VerifyNavigation(String navigatetopage,String pageTitle),verifyImagePresent(String expectedImage, String imageElement),isTextPresent(String controlName)
	                                      isElementDisplayed(String controlName),checkUrl(String controlName),clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle)
	                                      checkSelectedTabActive(String controlName, String childElement,String str_selectedtabname),verifyBreadCrumb(String actualControlName, String expectedControlName,String tagName) 
	  Purpose of Method                 : Verify the details present in the Global Management Development Program page
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/	
	
	@Test(description="Verify the details present in the Global Management Development Program page",groups="Careers page")
	public void testCareersGlobalManagementDevelopmentProgramContent() 
	{
		//Launching the Avaya Website
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		//To click on Careers from  About Avaya tab 
		businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "AboutAvaya_Careers", "Careers_Title");
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		//To Click on Explore Your Future With Us CTA
		businessFunction.get().clickAndVerifyNavigation("Careers_ExploreYourFutureCTA", "Careers_Title");
		//To check whether the Overview tab has been selected or not 
		businessFunction.get().checkSelectedTabActive("Careers_Parent_Tab", "Tag_List", "OVERVIEW");
		//To click on Global Management Development Program tab and verify the title in the page.
		businessFunction.get().clickAndVerifyNavigation("GlobalManagementDevelopmenProgram_Tab", "GlobalManagementDevelopmenProgram_Title");
		//To verify the Bread crumb is present or not
		businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "GDP_Breadcrumb_Expected","Tag_Anchors");
		//To verify the presence of Explore Global Oppurtunities link
		verify.get().isElementDisplayed("ExploreGlobalOppurtunities_link");
		businessFunction.get().verifyMenuOrCategoryLinks("ExploreGlobalOppurtunities_link");
		//To check if Related content and Images are displayed.
		businessFunction.get().imageValidation("GDP_Pod1_Image");
		businessFunction.get().contentValidation("GDP_Pod1_Content");
		//Verify.verifyImageActive("GDP_Pod2_Image");
		businessFunction.get().imageValidation("GDP_Pod2_Image");
		businessFunction.get().contentValidation("GDP_Pod2_Content");
		//Verify.verifyImageActive("GDP_Pod3_Image");
		businessFunction.get().imageValidation("GDP_Pod3_Image");
		businessFunction.get().contentValidation("GDP_Pod3_Content");
		//To check the url of the page
		businessFunction.get().checkUrl("GDP_Url","contains");	
	}
	
	/**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 31/07/2014
	  Date of Modified                  : --
	  Methods Called                    : clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle),pageAllignment(String relativeControlName, String controlName, String position)
	                                      isElementDisplayed(String controlName),isTextPresent(String controlName) 
	                                      verifyBreadCrumb(String actualControlName, String expectedControlName), verifyImagePresent(String expectedImage, String imageElement)
	  Purpose of Method                 : Verify the content in Consultants Landing page
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/

	@Test(description="Verify the content in Consultants Landing page",groups="Partners")
	public void testConsultantsLandingPageContent() 
	{
	  	//Launching the Avaya Website
	  	getDriver().get(appConfig.getAppUrl());
	  	dynamicWait.get().waittillpageloads();
	  	//To hover on Partners tab in mega menu and click on Consultants link and check heading in the Consultants page
	  	businessFunction.get().clickOnSubMenuItem("Partners", "Consultants", "Consultants_Title");
	  	//To check the presence of Bread crumb
	  	businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "Consultants_ExpectedBreadCrumb","Tag_Anchors");
	  	//To check the presence of Consultants Relation Program link
	  	verify.get().isTextPresent("Consultants_RelationProgramLink");
	  	businessFunction.get().verifyMenuOrCategoryLinks("Consultants_RelationProgramLink");
	  	//To check the presence of Consultants Relation Program link in the left menu
	  	businessFunction.get().pageAllignment("ButlerBar","RelationProgramLink_Allignment","equal");
	  	//To check the presence of Member Login CTA
	  	verify.get().isElementDisplayed("MemberLogin_CTA");
	  	//To check the presence of Image 
	  	businessFunction.get().imageValidation("Consultants_Image");
	  	//To check the presence related content
	  	businessFunction.get().contentValidation("Consultants_Content");
	  	//To check the presence of related content below Image
	  	businessFunction.get().pageAllignment("Consultants_Image","Consultants_Content","equal");
	  	//To check the presence of Register to Become a Member pod
	  	verify.get().isTextPresent("RegisterBecomeAMember_Pod");
	  	verify.get().isElementDisplayed("RegisterBecomeAMember_Pod");   	   	
	}
	
	
	/**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 31/07/2014
	  Date of Modified                  : --
	  Methods Called                    : verifyImagePresent(String expectedImage, String imageElement),pageAllignment(String relativeControlName, String controlName, String position)
	                                      isTextPresent(String controlName),isElementDisplayed(String controlName)
	  Purpose of Method                 : Verify whether mega menu tout image is present or not
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/

	@Test(description="Verify whether mega menu tout image is present or not",groups="Home Page")
	public void testMegaMenuToutImage() 
	{
	  	//Launching the Avaya Website
	  	getDriver().get(appConfig.getAppUrl());
	  	dynamicWait.get().waittillpageloads();
	  	//Hover on Products in mega menu
	  	userActions.get().hoverOn("Products");
	  	//To check the presence of the Mega menu tout image  on hovering of Products Megamenu
	  	businessFunction.get().imageValidation("Products_SpotlightImage");
	  	//To check the presence of the Mega menu tout image to the right side of Megamenu  on hovering of Products Megamenu
	  	businessFunction.get().pageAllignment("Megamenu","Products_SpotlightImage","right");
	  	userActions.get().hoverOn("Products");
	  	//To check the presence of the MegaMenu CTA  on hovering of Products Megamenu
	  	verify.get().isElementDisplayed("Products_SpotlightImage_CTA");
	  	//To check the presence of the Mega menu tout image to the right side of Megamenu  on hovering of Products Megamenu
	  	businessFunction.get().pageAllignment("Megamenu","Products_SpotlightImage_CTA","right");
	  	//To check the presence of the MegaMenu Description  on hovering of Products Megamenu
	  	businessFunction.get().contentValidation("Products_SpotlightImage_Description");
	  	//To check the presence of the Mega menu tout image to the right side of Megamenu  on hovering of Products Megamenu
	  	businessFunction.get().pageAllignment("Megamenu","Products_SpotlightImage_Description","right");  	
	}
	
	/**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 31/07/2014
	  Date of Modified                  : --
	  Methods Called                    : Click_VerifyNavigation(String navigatetopage,String pageTitle),clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle)
	                                      isElementDisplayed(String controlName),isTextPresent(String controlName),verifyBreadCrumb(String actualControlName, String expectedControlName)
	  									  (String controlName,String childElement,String delimiter),verifyImagePresent(String expectedImage, String imageElement)
	  Purpose of Method                 : Verify the content in Enterprise Technology page
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/
	@Test(description="Verify the content in Enterprise Technology page",groups="Promotions & Programs")
	public void testPromotionsProgramsEnterpriseTechnologyContent()
	{
		 //Launching the Avaya Website
	    getDriver().get(appConfig.getAppUrl());
	    dynamicWait.get().waittillpageloads();
	    //Navigate to footer section and hover the mouse on Quick links tab
	    userActions.get().hoverOn("Home_QuickLinks");
	    //To check if options are displayed when hovered on Quick Links
	    businessFunction.get().verifyMenuOrCategoryLinks("QuickLinks_ChildElements");
	    //To click on Promotions & Programs link
	    businessFunction.get().clickOnSubMenuItem("Home_QuickLinks", "PromotionsAndPrograms", "PromotionsAndPrograms_Title");
	    //To click on Enterprise Technology link and check the heading in the page
	    businessFunction.get().clickAndVerifyNavigation("PromotionsAndPrograms_EnterpriseTechnology", "EnterpriseTechnology_Title");
	    //To check the presence of Find A Partner CTA
	    verify.get().isTextPresent("Find_A_Partner_CTA");
	    businessFunction.get().verifyMenuOrCategoryLinks("Find_A_Partner_CTA");
	    //To check the presence of Image
	    businessFunction.get().imageValidation("EnterpriseTechnology_Image");
	    //To check the presence of Related content
	    businessFunction.get().contentValidation("EnterpriseTechnology_Content");
	    //To check the presence of Bread crumb
	    businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "EnterpriseTechnology_Breadcrumb_Expected","Tag_Anchors");
	}
	
	/**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 31/07/2014
	  Date of Modified                  : --
	  Methods Called                    : Click_VerifyNavigation(String navigatetopage,String pageTitle),clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle)
	                                      isElementDisplayed(String controlName),isTextPresent(String controlName),verifyBreadCrumb(String actualControlName, String expectedControlName)
	  									  (String controlName,String childElement,String delimiter),verifyImagePresent(String expectedImage, String imageElement)
	  Purpose of Method                 : Verify the content in Enterprise Technology page
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/

	@Test(description="Verify the content in Promotions for Networking page",groups="Promotions & Programs")
	public void testPromotionsProgramPromotionsNetworkingContent()
	{
		 //Launching the Avaya Website
	    getDriver().get(appConfig.getAppUrl());
	    dynamicWait.get().waittillpageloads();
	    //Navigate to footer section and hover the mouse on Quick links tab
	    userActions.get().hoverOn("Home_QuickLinks");
	    //To check if options are displayed when hovered on Quick Links
	    businessFunction.get().verifyMenuOrCategoryLinks("QuickLinks_ChildElements");
	    //To click on Promotions & Programs link
	    businessFunction.get().clickOnSubMenuItem("Home_QuickLinks", "PromotionsAndPrograms", "PromotionsAndPrograms_Title");
	    //To click on Promotions for Networking link and check the heading in the page
	    businessFunction.get().clickAndVerifyNavigation("PromotionsAndPrograms_PromotionsForNetworking", "PromotionsForNetworking_Title");
	    //To check the presence of Find A Partner CTA
	    verify.get().isTextPresent("Find_A_Partner_CTA");
	    businessFunction.get().verifyMenuOrCategoryLinks("Find_A_Partner_CTA");
	    //To check the presence of Image
	    businessFunction.get().imageValidation("PromotionsForNetworking_Image");
	    //To check the presence of Related content
	    businessFunction.get().contentValidation("PromotionsForNetworking_Content");
	    //To check the presence of Bread crumb
	    businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "PromotionsForNetworking_Breadcrumb_Expected","Tag_Anchors");
	    //To check the presence of Government Education and Medical(G.E.M) POD 
	    verify.get().isElementDisplayed("PromotionsForNetworking_GEMPod");
	    verify.get().isTextPresent("PromotionsForNetworking_GEMPod_Header");
	    businessFunction.get().contentValidation("PromotionsForNetworking_GEMPod_Content");
	    verify.get().isTextPresent("PromotionsForNetworking_GEMPod_LearnMore");
	    businessFunction.get().verifyMenuOrCategoryLinks("PromotionsForNetworking_GEMPod_LearnMore");
	} 
	
	/**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 31/07/2014
	  Date of Modified                  : --
	  Methods Called                    : Click_VerifyNavigation(String navigatetopage,String pageTitle),clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle)
	                                      isElementDisplayed(String controlName),isTextPresent(String controlName),verifyBreadCrumb(String actualControlName, String expectedControlName,String tagName)
	  									  (String controlName,String childElement,String delimiter),verifyImagePresent(String expectedImage, String imageElement)
	  Purpose of Method                 : Verify the content in Small & Midsize Enterprises page
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/

	@Test(description="Verify the content in Small & Midsize Enterprises page",groups="Promotions & Programs")
	public void testPromotionsProgramsSmallMidsizeEnterprisesContent()
	{
		//Launching the Avaya Website
	    getDriver().get(appConfig.getAppUrl());
	    dynamicWait.get().waittillpageloads();
	    //Navigate to footer section and hover the mouse on Quick links tab
	    userActions.get().hoverOn("Home_QuickLinks");
	    //To check if options are displayed when hovered on Quick Links
	    businessFunction.get().verifyMenuOrCategoryLinks("QuickLinks_ChildElements");
	    //To click on Promotions & Programs link
	    businessFunction.get().clickOnSubMenuItem("Home_QuickLinks", "PromotionsAndPrograms", "PromotionsAndPrograms_Title");
	    //To click on Small & Midsize Enterprises  link and check the heading in the page
	    businessFunction.get().clickAndVerifyNavigation("PromotionsAndPrograms_SmallMidsizeEnterprises", "SmallMidsizeEnterprises_Title");
	    dynamicWait.get().waittillpageloads();
	    //To check the presence of Find A Partner CTA
	    verify.get().isTextPresent("Find_A_Partner_CTA");
	    businessFunction.get().verifyMenuOrCategoryLinks("Find_A_Partner_CTA");
	    //To check the presence of Image
	    businessFunction.get().imageValidation("SmallMidsizeEnterprises_Image");
	    //To check the presence of Related content
	    businessFunction.get().contentValidation("SmallMidsizeEnterprises_Content");
	    //To check the presence of Bread crumb
	    businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "SmallMidsizeEnterprises_Breadcrumb_Expected","Tag_Anchors");
	}
	
	/**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 31/07/2014
	  Date of Modified                  : --
	  Methods Called                    : Click_VerifyNavigation(String navigatetopage,String pageTitle),clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle)
	                                      isElementDisplayed(String controlName),isTextPresent(String controlName),verifyBreadCrumb(String actualControlName, String expectedControlName)
	  									  (String controlName,String childElement,String delimiter),verifyImagePresent(String expectedImage, String imageElement)
	  Purpose of Method                 : Verify whether navigation is successful to Promotions and Programs page
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/

	@Test(description="Verify the content in Financing Programs page",groups="Promotions & Programs")
	public void testPromotionsProgramsFinancingProgramsContent()
	{
		 //Launching the Avaya Website
	    getDriver().get(appConfig.getAppUrl());
	    dynamicWait.get().waittillpageloads();
	    //Navigate to footer section and hover the mouse on Quick links tab
	    userActions.get().hoverOn("Home_QuickLinks");
	    //To check if options are displayed when hovered on Quick Links
	    businessFunction.get().verifyMenuOrCategoryLinks("QuickLinks_ChildElements");
	    //To click on Promotions & Programs link
	    businessFunction.get().clickOnSubMenuItem("Home_QuickLinks", "PromotionsAndPrograms", "PromotionsAndPrograms_Title");
	    //To click on Financing Programs  link and check the heading in the page
	    businessFunction.get().clickAndVerifyNavigation("PromotionsAndPrograms_FinancingPrograms", "FinancingPrograms_Title");
	    dynamicWait.get().waittillpageloads();
	    //To check the presence of Find A Partner CTA
	    verify.get().isTextPresent("Find_A_Partner_CTA");
	    businessFunction.get().verifyMenuOrCategoryLinks("Find_A_Partner_CTA");
	    //To check the presence of Image
	    businessFunction.get().imageValidation("FinancingPrograms_Image");
	    //To check the presence of Related content
	    businessFunction.get().contentValidation("FinancingPrograms_Content");
	    //To check the presence of Bread crumb
	    businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "FinancingPrograms_Breadcrumb_Expected","Tag_Anchors");
	}
	
	/**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 31/07/2014
	  Date of Modified                  : --
	  Methods Called                    : clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle),checkToggleMenuDetails(String parentControlName,String childElement,String controlName)
	                                      check_css_property(String controlName, String cssProperty) ,toggleMenuArrows(String actualControlName,String expectedControlName,String direction)
	  									  (String controlName,String childElement,String delimiter)
	  Purpose of Method                 : Verify the options present under Authentic Avaya tab
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/

	@Test(description="Verify the options present under Authentic Avaya tab",groups="Promotions & Programs")
	public void testPromotionsProgramsAuthenticAvayaOptions()
	{
		//Launching the Avaya Website
	    getDriver().get(appConfig.getAppUrl());
	    dynamicWait.get().waittillpageloads();
	    //Navigate to footer section and hover the mouse on Quick links tab
	    userActions.get().hoverOn("Home_QuickLinks");
	    //To check if options are displayed when hovered on Quick Links
	    businessFunction.get().verifyMenuOrCategoryLinks("QuickLinks_ChildElements");
	    //To click on Promotions & Programs link
	    businessFunction.get().clickOnSubMenuItem("Home_QuickLinks", "PromotionsAndPrograms", "PromotionsAndPrograms_Title");
	    //To check if Authentic Avaya tab is opened by default 
	    businessFunction.get().checkCssProperty("AuthenticAvaya_Tab", "display");
	    //To check if the arrow in Authentic Avaya tab is pointing towards upwards
	    businessFunction.get().checkToggleMenuArrows("AuthenticAvaya_Section", "Expanded_Arrow", "up");
	    //To verify the options under Authentic Avaya tab
	    businessFunction.get().checkToggleMenuDetails("AuthenticAvaya_Parent", "Tag_Anchors", "AuthenticAvaya_Section",",");
	}
	
	
	/**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 31/07/2014
	  Date of Modified                  : --
	  Methods Called                    : Click_VerifyNavigation(String navigatetopage,String pageTitle),clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle)
	                                      isElementDisplayed(String controlName),isTextPresent(String controlName),verifyBreadCrumb(String actualControlName, String expectedControlName,String tagName)
	  									  (String controlName,String childElement,String delimiter),verifyImagePresent(String expectedImage, String imageElement)
	  Purpose of Method                 : Verify the content in Small & Midsize Enterprises page
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/

	@Test(description="Verify the content in Promotions for Small and Midsize Business page",groups="Promotions & Programs")
	public void testPromotionsProgramsPromotionsSmallMidsizeBusiness()
	{
		// Launching the Avaya Website
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		// Navigate to footer section and hover the mouse on Quick links tab
		userActions.get().hoverOn("Home_QuickLinks");
		// To check if options are displayed when hovered on Quick Links
		businessFunction.get().verifyMenuOrCategoryLinks(
				"QuickLinks_ChildElements");
		// To click on Promotions & Programs link
		businessFunction.get().clickOnSubMenuItem("Home_QuickLinks",
				"PromotionsAndPrograms", "PromotionsAndPrograms_Title");
		// To click on Promotions for Small and Midsize Business link and check
		// the heading in the page
		businessFunction.get().clickAndVerifyNavigation(
				"PromotionsAndPrograms_SmallMidsizeBusiness",
				"SmallMidsizeBusiness_Title");
		dynamicWait.get().waittillpageloads();
		// To check the presence of Find A Partner CTA
		verify.get().isTextPresent("Find_A_Partner_CTA");
		businessFunction.get().verifyMenuOrCategoryLinks("Find_A_Partner_CTA");
		// To check the presence of Image
		businessFunction.get().imageValidation("SmallMidsizeBusiness_Image");
		// To check the presence of Related content
		businessFunction.get()
				.contentValidation("SmallMidsizeBusiness_Content");
		// To check the presence of Bread crumb
		businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual",
				"SmallMidsizeBusiness_Breadcrumb_Expected", "Tag_Anchors");
	}
	/**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 23/07/2014
	  Date of Modified                  : 26-08-2014
	  Methods Called                    : clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle),checkToggleMenuDetails(String parentControlName,String childElement,String controlName,String delimiter)
	                                      checkCssProperty(String controlName, String cssProperty) ,checkToggleMenuArrows(String actualControlName,String expectedControlName,String direction)
	  									  (String controlName,String childElement,String delimiter)
	  Purpose of Method                 : Verify the options present under Unified Communications tab which is present in the left menu
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/

	@Test(description="Verify the options present under Contact Centers tab",groups="Promotions & Programs")
	public void testPromotionsProgramsContactCentersTabOptions()
	{
		//Launching the Avaya Website
	    getDriver().get(appConfig.getAppUrl());
	    dynamicWait.get().waittillpageloads();
	    //Navigate to footer section and hover the mouse on Quick links tab
	    userActions.get().hoverOn("Home_QuickLinks");
	    //To check if options are displayed when hovered on Quick Links
	    businessFunction.get().verifyMenuOrCategoryLinks("QuickLinks_ChildElements");
	    //To click on Promotions & Programs link
	    businessFunction.get().clickOnSubMenuItem("Home_QuickLinks", "PromotionsAndPrograms", "PromotionsAndPrograms_Title");
	    //To verify whether the Promotions for Contact Centers option is present under Contact Centers tab
	  	businessFunction.get().checkToggleMenuDetails("PromotionsPrograms_ContactCenters", "Tag_Anchors", "PromotionsPrograms_ContactCentersTab",",");
	  	//To verify whether the arrow is pointing upwards
	  	businessFunction.get().checkToggleMenuArrows("PromotionsPrograms_ContactCentersTab", "Expanded_Arrow", "up");
	  	//To click on the Contact Centers tab
	  	userActions.get().clickOn("PromotionsPrograms_ContactCentersTab");
	  	//To verify whether the arrow is pointing downwards
	  	businessFunction.get().checkToggleMenuArrows("PromotionsPrograms_ContactCentersTab", "Collapsed_Arrow", "down");	    
	}

	
	/**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 31/07/2014
	  Date of Modified                  : --
	  Methods Called                    : clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle),checkToggleMenuDetails(String parentControlName,String childElement,String controlName)
	                                      check_css_property(String controlName, String cssProperty) ,toggleMenuArrows(String actualControlName,String expectedControlName,String direction)
	  									  (String controlName,String childElement,String delimiter)
	  Purpose of Method                 : Verify the options present under Unified Communications tab which is present in the left menu
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/

	@Test(description="Verify the options present under Unified Communications tab which is present in the left menu",groups="Promotions & Programs")
	public void testPromotionsProgramsUnifiedCommunicationsTabOptions()
	{
	    //Launching the Avaya Website
	    getDriver().get(appConfig.getAppUrl());
	    dynamicWait.get().waittillpageloads();
	    //Navigate to footer section and hover the mouse on Quick links tab
	    userActions.get().hoverOn("Home_QuickLinks");
	    //To check if options are displayed when hovered on Quick Links
	    businessFunction.get().verifyMenuOrCategoryLinks("QuickLinks_ChildElements");
	    //To click on Promotions & Programs link
	    businessFunction.get().clickOnSubMenuItem("Home_QuickLinks", "PromotionsAndPrograms", "PromotionsAndPrograms_Title");
	    //To verify whether the Promotions for Unified Communications option is present under Unified Communications tab
	  	businessFunction.get().checkToggleMenuDetails("PromotionsPrograms_UnifiedCommParent", "Tag_Anchors", "PromotionsPrograms_UnifiedCommTab",",");
	  	//To verify whether the arrow is pointing upwards
	  	businessFunction.get().checkToggleMenuArrows("PromotionsPrograms_UnifiedCommTab", "Expanded_Arrow", "up");
	  	//To click on the Unified Communications tab
	  	userActions.get().clickOn("PromotionsPrograms_UnifiedCommTab");
	  	//To verify whether the arrow is pointing downwards
	  	businessFunction.get().checkToggleMenuArrows("PromotionsPrograms_UnifiedCommTab", "Collapsed_Arrow", "down");
	}
	
	/**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 31/07/2014
	  Date of Modified                  : --
	  Methods Called                    : hoverOn(String controlName),(String controlName,String childElement,String delimiter)
	                                      check_ChildElements(String controlName,String childElement,String delimiter),clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle)
	  Purpose of Method                 : Verify the content in left menu in Promotions & Programs page
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/

	@Test(description="Verify the content in left menu in Promotions & Programs page",groups="Promotions & Programs")
	public void testPromotionsProgramsLeftMenu()
	{
		 //Launching the Avaya Website
	    getDriver().get(appConfig.getAppUrl());
	    dynamicWait.get().waittillpageloads();
	    //Navigate to footer section and hover the mouse on Quick links tab
	    userActions.get().hoverOn("Home_QuickLinks");
	    //To check if options are displayed when hovered on Quick Links
	    businessFunction.get().verifyMenuOrCategoryLinks("QuickLinks_ChildElements");
	    //To click on Promotions & Programs link
	    businessFunction.get().clickOnSubMenuItem("Home_QuickLinks", "PromotionsAndPrograms", "PromotionsAndPrograms_Title");
	    //To verify the content in left menu in Promotions & Programs page
	    businessFunction.get().verifySubMenuElements("PromotionsAndPrograms_Section", "Tag_Span", ",");
	}
	
	
	/** 
	 Author Name                       : Phanendra Ketavarapu
	 Date of Preparation               : 31/07/2014
	 Date of Modified                  : --
	 Methods Called                    : clickOn(Utilities),waittillpageloads(Dynamicwaits)
	 Purpose of Method                 : Verifies whether Header,description text,Learn more link present under company
	                                     Overview pod
	 Dependencies	                   : --
	 Reviewed By                       : --
	**/
	@Test(description="About Avaya_Landing page_Company OverView Pod",groups="About Avaya")
	public void testAboutAvayaCompanyOverviewPod() 
	{
		//Launch the avaya website
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		//Click on About Avaya from megamenu
		userActions.get().clickOn("MegaMenuAboutAvaya");
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
       //verify the image under company overview pod
		businessFunction.get().imageValidation("AboutAvayaCompanyOverviewPod_Image");
		//verify the content under company overview pod1
		businessFunction.get().contentValidation("AboutAvayaTopPods_CompanyOverviewPod_Header");
		businessFunction.get().verifyPartnerAndProductPods("AboutAvayaTopPods_CompanyOverviewPod_Description","Tag_Anchors");								
	}
	
	/** 
	 Author Name                       : Phanendra Ketavarapu
	 Date of Preparation               : 31/07/2014
	 Date of Modified                  : --
	 Methods Called                    : clickOn(Utilities),waittillpageloads(Dynamicwaits)
	 Purpose of Method                 : Verifies whether Header,description text,Learn more link present under news 
	                                     and events pod
	 Dependencies	                   : --
	 Reviewed By                       : --
	**/
	@Test(description="About Avaya_Landing page_News and Events Pod",groups="About Avaya")
	public void testAboutAvayaNewsAndEventsPod() 
	{
		//Launch the avaya website
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		//Click on About Avaya from megamenu
		userActions.get().clickOn("MegaMenuAboutAvaya");
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
       //verify the image under news and events pod
		businessFunction.get().imageValidation("AboutAvayaNewsAndEventsPod_Image");
		//verify the content under News and Events pod
		businessFunction.get().contentValidation("AboutAvayaTopPods_NewandEventsPod_Header");
		businessFunction.get().verifyPartnerAndProductPods("AboutAvayaTopPods_NewandEventsPod_Description","Tag_Anchors");
	}
	
	/** 
	 Author Name                       : Phanendra Ketavarapu
	 Date of Preparation               : 31/07/2014
	 Date of Modified                  : --
	 Methods Called                    : clickOn(Utilities),waittillpageloads(Dynamicwaits)
	 Purpose of Method                 : Verifies whether Header,description text,Learn more link present under community
	                                     pod
	 Dependencies	                   : --
	 Reviewed By                       : --
	**/
	@Test(description="About Avaya_Landing page_Community Pod",groups="About Avaya")
	public void testAboutAvayaCommunityPod() 
	{
		//Launch the avaya website
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		//Click on About Avaya from megamenu
		userActions.get().clickOn("MegaMenuAboutAvaya");
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
       //verify the image under community pod
		businessFunction.get().imageValidation("AboutAvayaCommunityPod_Image");
		//verify the content under Community pod
		businessFunction.get().contentValidation("AboutAvayaTopPods_CommunityPod_Header");
		businessFunction.get().verifyPartnerAndProductPods("AboutAvayaTopPods_CommunityPod_Description","Tag_Anchors");
	}
	/**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 31/07/2014
	  Date of Modified                  : --
	  Methods Called                    : hoverOn(String controlName),(String controlName,String childElement,String delimiter)
	                                      clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle)
	  Purpose of Method                 : Verify whether navigation is successful to Promotions and Programs page
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/

	@Test(description="Verify whether navigation is successful to Promotions and Programs page",groups="Promotions & Programs")
	public void testPromotionsProgramsNavigation()
	{
		//Launching the Avaya Website
	    getDriver().get(appConfig.getAppUrl());
	    dynamicWait.get().waittillpageloads();
	    //Navigate to footer section and hover the mouse on Quick links tab
	    userActions.get().hoverOn("Home_QuickLinks");
	    //To check if options are displayed when hovered on Quick Links
	    businessFunction.get().verifyMenuOrCategoryLinks("QuickLinks_ChildElements");
	    //To click on Promotions & Programs link
	    businessFunction.get().clickOnSubMenuItem("Home_QuickLinks", "PromotionsAndPrograms", "PromotionsAndPrograms_Title");
	}
	
	  /**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 31-07-2014
	  Date of Modified                  : --
	  Methods Called                    : checkContainsChildElements(String controlName,String childElement,String delimiter),
	  									  checkToggleMenuDetails(String parentControlName,String childElement,String controlName,String delimiter),
	  									  clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle),
	  									  isElementDisplayed(String controlName),isTextPresent(String controlName),
	  									  verifyImagePresent(String expectedImage, String imageElement),
	  									  verifyBreadCrumb(String actualControlName, String expectedControlName,String tagName)
	  Purpose of Method                 : Verify the content in Certified Refurbished Equipment-Voice page
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	  **/
	  
	  @Test(description="Verify the content in Certified Refurbished Equipment-Voice page",groups="Promotions & Programs")
	  public void testPromotionsProgramsCertifiedRefurbishedVoice()
	  {
		  //Launching the Avaya Website
	  	  getDriver().get(appConfig.getAppUrl());
	  	  dynamicWait.get().waittillpageloads();
	  	  //Navigate to footer section and hover the mouse on Quick links tab
	  	  userActions.get().hoverOn("Home_QuickLinks");
	  	  //To check if options are displayed when hovered on Quick Links
	  	  businessFunction.get().verifyMenuOrCategoryLinks("QuickLinks_ChildElements");
	  	  //To click on Promotions & Programs link
	  	  businessFunction.get().clickOnSubMenuItem("Home_QuickLinks", "PromotionsAndPrograms", "PromotionsAndPrograms_Title");
	  	  //To click on Certified Refurbished Equipment-Voice and verify the navigation to the page
	  	  businessFunction.get().clickAndVerifyNavigation("CertifiedRefurbishedVoice", "AuthenticAvayaHeader");
	  	  //To check the presence of Find A Partner CTA
	  	  verify.get().isTextPresent("Find_A_Partner_CTA");
	  	  businessFunction.get().verifyMenuOrCategoryLinks("Find_A_Partner_CTA");
	  	  //To verify whether the Image is displayed or not
	  	  businessFunction.get().imageValidation("AuthenticAvayaImage");
	  	  //To verify whether the Related Content is present or not
	  	  businessFunction.get().contentValidation("CertifiedRefurbishedVoiceRelatedContent");
	  	  //To verify whether the Breadcrumb is present or not
	  	  businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "CertifiedRefurbishedVoiceExpected", "Tag_Anchors");
	  }
	  
	  /**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 01-08-2014
	  Date of Modified                  : --
	  Methods Called                    : checkContainsChildElements(String controlName,String childElement,String delimiter),
	  									  checkToggleMenuDetails(String parentControlName,String childElement,String controlName,String delimiter),
	  									  clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle),
	  									  isElementDisplayed(String controlName),isTextPresent(String controlName),
	  									  verifyImagePresent(String expectedImage, String imageElement),
	  									  verifyBreadCrumb(String actualControlName, String expectedControlName,String tagName)
	  Purpose of Method                 : Verify the content in Certified Refurbished Equipment-Networking page
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	  **/
	  
	  @Test(description="Verify the content in Certified Refurbished Equipment-Networking page",groups="Promotions & Programs")
	  public void testPromotionsProgramsCertifiedRefurbishedNetworking()
	  {
		// Launching the Avaya Website
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		// Navigate to footer section and hover the mouse on Quick links tab
		userActions.get().hoverOn("Home_QuickLinks");
		// To check if options are displayed when hovered on Quick Links
		businessFunction.get().verifyMenuOrCategoryLinks(
				"QuickLinks_ChildElements");
		// To click on Promotions & Programs link
		businessFunction.get().clickOnSubMenuItem("Home_QuickLinks",
				"PromotionsAndPrograms", "PromotionsAndPrograms_Title");
		// To click on Certified Refurbished Equipment-Voice and verify the
		// navigation to the page
		businessFunction.get().clickAndVerifyNavigation(
				"CertifiedRefurbishedNetworking", "AuthenticAvayaHeader");
		// To check the presence of Find A Partner CTA
		verify.get().isTextPresent("Find_A_Partner_CTA");
		businessFunction.get().verifyMenuOrCategoryLinks("Find_A_Partner_CTA");
		// To verify whether the Image is displayed or not
		businessFunction.get().imageValidation("AuthenticAvayaImage");
		// To verify whether the Related Content is present or not
		businessFunction.get().contentValidation(
				"CertifiedRefurbishedNetworkingRelatedContent");
		// To verify whether the Breadcrumb is present or not
		businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual",
				"CertifiedRefurbishedNetworkingExpected", "Tag_Anchors");
	  }
	  
	  /**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 1-08-2014
	  Date of Modified                  : --
	  Methods Called                    : checkContainsChildElements(String controlName,String childElement,String delimiter),
	  									  clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle),
	  									  Click_VerifyNavigation(String navigatetopage,String pageTitle),isElementDisplayed(String controlName),
	  									  verifyImagePresent(String expectedImage, String imageElement),isTextPresent(String controlName) 
	  									  verifyBreadCrumb(String actualControlName, String expectedControlName,String tagName)
	  Purpose of Method                 : Verify the content in Overstock Equipment page
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	  **/
	  
	  @Test(description="Verify the content in Overstock Equipment page",groups="Promotions & Programs")
	  public void testPromotionsProgramsOverstockEquipmentContent()
	  {
		  //Launching the Avaya Website
	  	  getDriver().get(appConfig.getAppUrl());
	  	  dynamicWait.get().waittillpageloads();
	  	  //Navigate to footer section and hover the mouse on Quick links tab
	  	  userActions.get().hoverOn("Home_QuickLinks");
	  	  //To check if options are displayed when hovered on Quick Links
	  	  businessFunction.get().verifyMenuOrCategoryLinks("QuickLinks_ChildElements");
	  	  //To click on Promotions & Programs link
	  	  businessFunction.get().clickOnSubMenuItem("Home_QuickLinks", "PromotionsAndPrograms", "PromotionsAndPrograms_Title");
	  	  //To click on Overstock Equipment tab and verify the navigation to the page
	  	  businessFunction.get().clickAndVerifyNavigation("PromotionsProgramsOverstockEquipment", "AuthenticAvayaHeader");
	  	  //To check the presence of Find A Partner CTA
	  	  verify.get().isTextPresent("Find_A_Partner_CTA");
	  	  businessFunction.get().verifyMenuOrCategoryLinks("Find_A_Partner_CTA");
	  	  //To verify whether the Image is displayed or not
	  	  businessFunction.get().imageValidation("AuthenticAvayaImage");
	  	  //To verify whether the Related Content is present or not
	  	  businessFunction.get().contentValidation("PromotionsProgramsOverstockEquipmentDescription");
	  	  //To verify whether the Breadcrumb is present or not
	  	  businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "PromotionsProgramsOverstockEquipmentExpected", "Tag_Anchors");
	  }
	  
	  /**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 01-08-2014
	  Date of Modified                  : --
	  Methods Called                    : checkContainsChildElements(String controlName,String childElement,String delimiter),
	  									  clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle),
	  									  Click_VerifyNavigation(String navigatetopage,String pageTitle),isElementDisplayed(String controlName),
	  									  verifyImagePresent(String expectedImage, String imageElement),isTextPresent(String controlName) 
	  									  verifyBreadCrumb(String actualControlName, String expectedControlName,String tagName)
	  Purpose of Method                 : Verify the content in Trade In page
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	  **/
	  
	  @Test(description="Verify the content in Trade In page",groups="Promotions & Programs")
	  public void testPromotionsProgramsTradeInTradeUpContent()
	  {
		  //Launching the Avaya Website
	  	  getDriver().get(appConfig.getAppUrl());
	  	  dynamicWait.get().waittillpageloads();
	  	  //Navigate to footer section and hover the mouse on Quick links tab
	  	  userActions.get().hoverOn("Home_QuickLinks");
	  	  //To check if options are displayed when hovered on Quick Links	  	  
	  	  businessFunction.get().verifyMenuOrCategoryLinks("QuickLinks_ChildElements");
	  	  //To click on Promotions & Programs link
	  	  businessFunction.get().clickOnSubMenuItem("Home_QuickLinks", "PromotionsAndPrograms", "PromotionsAndPrograms_Title");
	  	  //To click on Trade In/Trade Up tab and verify the navigation to the page
	  	  businessFunction.get().clickAndVerifyNavigation("PromotionsProgramsTradeInTradeUp", "AuthenticAvayaHeader");
	  	  //To check the presence of Find A Partner CTA
	  	  verify.get().isTextPresent("Find_A_Partner_CTA");
	  	  businessFunction.get().verifyMenuOrCategoryLinks("Find_A_Partner_CTA");
	  	  //To verify whether the Image is displayed or not
	  	  businessFunction.get().imageValidation("AuthenticAvayaImage");
	  	  //To verify whether the Related Content is present or not
	  	  businessFunction.get().contentValidation("PromotionsProgramsTradeInTradeUpDescription");
	  	  //To verify whether the Breadcrumb is present or not
	  	  businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "PromotionsProgramsTradeInTradeUpExpected", "Tag_Anchors");
	  }
	  /**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 01-08-2014
	  Date of Modified                  : --
	  Methods Called                    : checkContainsChildElements(String controlName,String childElement,String delimiter),
	  									  clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle),
	  									  Click_VerifyNavigation(String navigatetopage,String pageTitle),isElementDisplayed(String controlName),
	  									  verifyImagePresent(String expectedImage, String imageElement),isTextPresent(String controlName) 
	  									  verifyBreadCrumb(String actualControlName, String expectedControlName,String tagName)
	  Purpose of Method                 : Verify the content in Buy Back page
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	  **/
	  
	  @Test(description="Verify the content in Buy Back page",groups="Promotions & Programs")
	  public void testPromotionsProgramsBuyBackProgramContent()
	  {
		  //Launching the Avaya Website
	  	  getDriver().get(appConfig.getAppUrl());
	  	  dynamicWait.get().waittillpageloads();
	  	  //Navigate to footer section and hover the mouse on Quick links tab
	  	  userActions.get().hoverOn("Home_QuickLinks");
	  	  //To check if options are displayed when hovered on Quick Links
	  	  businessFunction.get().verifyMenuOrCategoryLinks("QuickLinks_ChildElements");
	  	  //To click on Promotions & Programs link
	  	  businessFunction.get().clickOnSubMenuItem("Home_QuickLinks", "PromotionsAndPrograms", "PromotionsAndPrograms_Title");
	  	  //To click on the Buy Back Program link and verify the navigation to the page
	  	  businessFunction.get().clickAndVerifyNavigation("PromotionsProgramsBuyBackProgram", "AuthenticAvayaHeader");
	  	  //To check the presence of Find A Partner CTA
	  	  verify.get().isTextPresent("Find_A_Partner_CTA");
	  	  businessFunction.get().verifyMenuOrCategoryLinks("Find_A_Partner_CTA");
	  	  //To verify whether the Image is displayed or not
	  	  businessFunction.get().imageValidation("AuthenticAvayaImage");
	  	  //To verify whether the Related Content is present or not
	  	  businessFunction.get().contentValidation("PromotionsProgramsBuyBackProgramDescription");
	  	  //To verify whether the Breadcrumb is present or not
	  	  businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "PromotionsProgramsBuyBackProgram", "Tag_Anchors");
	  }
	  
	  /**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 01-08-2014
	  Date of Modified                  : --
	  Methods Called                    : checkContainsChildElements(String controlName,String childElement,String delimiter),
	  									  clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle),
	  									  Click_VerifyNavigation(String navigatetopage,String pageTitle),isElementDisplayed(String controlName),
	  									  verifyImagePresent(String expectedImage, String imageElement),isTextPresent(String controlName) 
	  									  verifyBreadCrumb(String actualControlName, String expectedControlName,String tagName)
	  Purpose of Method                 : Verify the options present under Small and Midsize business tab which is present in the left menu
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	  **/
	  
	  @Test(description="Verify the options present under Small and Midsize business tab which is present in the left menu",groups="Promotions & Programs")
	  public void testPromotionsProgramsSmallMidsizeTabOptions()
	  { 
		// Launching the Avaya Website
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		// Navigate to footer section and hover the mouse on Quick links tab
		userActions.get().hoverOn("Home_QuickLinks");
		// To check if options are displayed when hovered on Quick Links
		businessFunction.get().verifyMenuOrCategoryLinks(
				"QuickLinks_ChildElements");
		// To click on Promotions & Programs link
		businessFunction.get().clickOnSubMenuItem("Home_QuickLinks",
				"PromotionsAndPrograms", "PromotionsAndPrograms_Title");
		// To verify whether the Promotions for Networking options is present
		// under Networking tab
		businessFunction.get().checkToggleMenuDetails(
				"PromotionsProgramsPromotionsSmallMediumBusiness",
				"Tag_Anchors", "PromotionsProgramsSmallMediumBusinessTab", ",");
		// To verify whether the arrow is pointing upwards
		businessFunction.get().checkToggleMenuArrows(
				"PromotionsProgramsSmallMediumBusinessTab", "Expanded_Arrow",
				"up");
		// To click on the Networking tab
		userActions.get().clickOn("PromotionsProgramsSmallMediumBusinessTab");
		// To verify whether the arrow is pointing downwards
		businessFunction.get().checkToggleMenuArrows(
				"PromotionsProgramsSmallMediumBusinessTab", "Collapsed_Arrow",
				"down");
	  }
	
	  /**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 25-07-2014
	  Date of Modified                  : 26-08-2014
	  Methods Called                    : clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle),
	  									  clickAndVerifyNavigation(String navigatetopage,String pageTitle),
	  									  checkSelectedTabActive(String controlName, String childElement,String str_selectedtabname),
	  									  verifyBreadCrumb(String actualControlName, String expectedControlName,String tagName),
	  									  isElementDisplayed(String controlName),checkChildElements(String controlName,String childElement,String delimiter)
	  									  verifyImagePresent(String expectedImage, String imageElement)
	  Purpose of Method                 : Verify the content in Your Future With Us page
	  Dependencies	                    : Jar files
	  Reviewed By                       : Pankaj
	  **/
	  
	  @Test(description="Verify the content in Your Future With Us page",groups="Careers page")
	  public void testCareersExploreYourFutureWithUs()
	  {
		  //Launching the Avaya Website
		  getDriver().get(appConfig.getAppUrl());
		  //To click on the Careers link present under About Avaya tab
		  businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "AboutAvaya_Careers", "Careers_Title");
		  //To click on Explore Your Future CTA and to check the navigation of the page
		  businessFunction.get().clickAndVerifyNavigation("Careers_ExploreYourFutureCTA", "Careers_Title");
		  businessFunction.get().deFocus();
		  //To verify whether the OVERVIEW tab is selected by default
		  businessFunction.get().checkSelectedTabActive("CareersExploreYourFutureParentTab", "CareersExploreYourFutureChildTabs", "OVERVIEW");
		  //To verify whether the breadcrumb is present or not
		  businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual","CareersExploreYourFutureParentExpected", "Tag_Anchors");
		  //To verify whether Explore Global Oppurtunities CTA is displayed or not
		  verify.get().isElementDisplayed("CareersExploreGlobalOpportunitiesCTA");
		  //To verify whether Overview, Global Management Development Program, Internships tabs are present or not
		  businessFunction.get().verifySubMenuElements("CareersExploreYourFutureParentTabElements", "Tag_Anchors", ",");
		  //To verify whether the Images and Text are present for few pods on the page or not		  
		  businessFunction.get().verifyPods("CareersPods");
	  }
	  /**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 23-07-2014
	  Date of Modified                  : 26-08-2014
	  Methods Called                    : checkContainsChildElements(String controlName,String childElement,String delimiter),
	  									  clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle),
	  									  clickAndVerifyNavigation(String navigatetopage,String pageTitle),isElementDisplayed(String controlName),
	  									  verifyImagePresent(String expectedImage, String imageElement),isTextPresent(String controlName) 
	  									  verifyBreadCrumb(String actualControlName, String expectedControlName,String tagName),
	  									  checkToggleMenuArrows(String actualControlName,String expectedControlName,String direction)
	  Purpose of Method                 : Verify the options present under Overview tab
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	  **/
	  
	  @Test(description="Verify the options present under Overview tab",groups="Promotions & Programs")
	  public void testPromotionsProgramsOverviewTabOptions()
	  {
		  //Launching the Avaya Website
	  	  getDriver().get(appConfig.getAppUrl());
	  	  dynamicWait.get().waittillpageloads();
	  	  //Navigate to footer section and hover the mouse on Quick links tab
	  	  userActions.get().hoverOn("Home_QuickLinks");
	  	  //To check if options are displayed when hovered on Quick Links
	  	  businessFunction.get().verifyMenuOrCategoryLinks("QuickLinks_ChildElements");
	  	  //To click on Promotions & Programs link
	  	  businessFunction.get().clickOnSubMenuItem("Home_QuickLinks", "PromotionsAndPrograms", "PromotionsAndPrograms_Title");
	  	  //To verify whether the Overview option is present under Overview tab
	  	  businessFunction.get().checkToggleMenuDetails("PromotionsProgramsPromotionsOverviewOption", "Tag_Anchors", "PromotionsProgramsOverviewTab",",");
	  	  //To verify whether the arrow is pointing upwards
	  	  businessFunction.get().checkToggleMenuArrows("PromotionsProgramsOverviewTab", "Expanded_Arrow", "up");
	  	  //To click on the Overview tab
	  	  userActions.get().clickOn("PromotionsProgramsOverviewTab");
	  	  //To verify whether the arrow is pointing downwards
	  	  businessFunction.get().checkToggleMenuArrows("PromotionsProgramsOverviewTab", "Collapsed_Arrow", "down");
	  }
	  
	  
		/**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 01/08/2014
	  Date of Modified                  : --
	  Methods Called                    : clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle),checkChildElements(String controlName,String childElement,String delimiter)
	                                      pageAllignment(String relativeControlName, String controlName, String position),verifyChildElementsByCount(String parentControlName,String tagName, int count)
	  Purpose of Method                 : Verify the content on click of any country  in World Wide Directory in About Avaya
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/ 
	  @Test(description="Verify the Home Page of World Wide Directory in About Avaya",groups="About-Avaya")
		public void testWorldWideDirectoryHomePage() 
		{
		  	//Launching the Avaya Website
		  	getDriver().get(appConfig.getAppUrl());
		  	dynamicWait.get().waittillpageloads();
		  	//To hover on AboutAvaya in Mega menu and click on WorldWide Directory and check the title in the WorldWide Directory page
		  	businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "WorldwideDirectory", "WorldwideDirectory_Title");
		  	businessFunction.get().deFocus();
		  	//To verify if the region specific links are present
		  	businessFunction.get().verifySubMenuElements("WorldwideDirectory_Regions", "Tag_Anchors","@");
		  	//To verify if all countries are present below region specific links
		  	businessFunction.get().pageAllignment("WorldwideDirectory_Regions", "WorldwideDirectory_Countries", "above");
		  	//To check if Countries under Tab are present 
		  	businessFunction.get().verifyMenuOrCategoryLinks("AboutAvaya_WorldWideDirectory1_Text");
		  	businessFunction.get().verifyMenuOrCategoryLinks("AboutAvaya_WorldWideDirectory2_Text");
		  	businessFunction.get().verifyMenuOrCategoryLinks("AboutAvaya_WorldWideDirectory3_Text");
		} 
	
	/**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 10/07/2014
	  Date of Modified                  : --
	  Methods Called                    : Click_VerifyNavigation(String navigatetopage,String pageTitle),isTextPresent(String controlName),clickOn(String controlName) 
	                                      isElementDisplayed(String controlName),sendinputdata(String controlName, String option, String searchControlName)
	                                      checkUrl(String controlName), checkChildElements(String controlName,String childElement,String delimiter),verifyImagePresent(String expectedImage, String imageElement)
	  Purpose of Method                 : Verify the message displayed when user clicks submit after entering all mandatory inputs.
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/

	  @Test(description="Verify the message displayed when user clicks submit after entering all mandatory inputs.",groups="Contact Avaya Sales")
		public void testHowToBuyContactAvayaSalesSubmitValidInputs() 
		{
		  	//Launching the Avaya Website
		  	getDriver().get(appConfig.getAppUrl());
		  	dynamicWait.get().waittillpageloads();
		  	//To click on Products tab of mega menu.
		  	businessFunction.get().clickAndVerifyNavigation("Products", "Products_label");
			dynamicWait.get().waittillpageloads();
			businessFunction.get().deFocus();
			//To click on Email Us link in How To Buy section.
			businessFunction.get().clickAndVerifyNavigation("Products_EmailUs","Products_EmailUs_Title");
			//To check the Url of the page
			businessFunction.get().checkUrl("Products_EmailUs_Url","contains");
			dynamicWait.get().waittillpageloads();
			//To check the presence of  text on the page
			businessFunction.get().contentValidation("EmailUs_Text");
			//To check if Read our Privacy Statement is in red color
			businessFunction.get().checkCssProperty("EmailUs_PrivacyStatement", "color");
			//To check if Read our Privacy Statement is in red color
			businessFunction.get().checkCssProperty("EmailUs_TermsOfUse", "color");
			//To check the presence of all the fields like FirstName,Email etc on the page
			businessFunction.get().verifySubMenuElements("EmailUs_Parent", "Child_Label_Items",",");
			//To check the presence of text boxes and drop down  in the page
			verify.get().isElementDisplayed("EmailUs_Fields");
			//To check the presence of Submit button 
			verify.get().isElementDisplayed("Registration_Submit");
			//To enter the data in the fields
			businessFunction.get().sendinputdata("RegistrationInputdata", "registration","none");
			//To click on submit button
			userActions.get().clickOn("Registration_Submit");
			//To check the message in the navigated page
			verify.get().isTextPresent("EmailUs_ThankYouMessage");
			businessFunction.get().contentValidation("EmailUs_Message");
			//To check if Avaya logo is displayed.
			verify.get().verifyIcons("ContactSales_AvayaLogo","AvayaLogoNew.png");
		}

	
	/**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 01/08/2014
	  Date of Modified                  : --
	  Methods Called                    : Click_VerifyNavigation(String navigatetopage,String pageTitle),clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle)
	                                      isElementDisplayed(String controlName),isTextPresent(String controlName)
	  									  verifyImagePresent(String expectedImage, String imageElement)
	  Purpose of Method                 : Verify the functionality of Learn More link in the Phone Series Module
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/

	@Test(description="Verify the functionality of Learn More link in the Phone Series Module",groups="Phones")
	public void testPhonesCategoryPageSeriesModuleLearnMore()
	{
	    //Launching the Avaya Website
	    getDriver().get(appConfig.getAppUrl());
	    dynamicWait.get().waittillpageloads();
	    //Hover on Products tab in Megamenu and Click on New Phones Page
	    businessFunction.get().clickOnSubMenuItem("Products", "Products_Phones", "Phones_Title");
	    dynamicWait.get().waittillpageloads();
	    businessFunction.get().deFocus();
	    //To click on "Explore Desktop Phones" CTA
	    businessFunction.get().clickAndVerifyNavigation("Phones_DesktopPhones", "DesktopPhones_Title");
	    //To check if  Phone Series Module is displayed with Image
	    businessFunction.get().imageValidation("1600Phones_Image");
	    //To check if  Phone Series Module is displayed with Title of the Product
	    verify.get().isTextPresent("1600Phones_Title");
	    //To check if  Phone Series Module is displayed with Description of the Product
	    businessFunction.get().contentValidation("1600Phones_Content");
	    //To check if  Phone Series Module is displayed with Learn More Link 
	    verify.get().isElementDisplayed("1600Phones_LearnMore");
	    businessFunction.get().verifyMenuOrCategoryLinks("1600Phones_LearnMore");
	    //To click on "Learn More" Link and to check if detail page is displayed.
	    businessFunction.get().clickAndVerifyNavigation("1600Phones_LearnMore", "1600PhonesDetailPage_Title"); 	    
	}
	
	/**
	  Author Name                       : Phanendra Ketavarapu
	  Date of Preparation               : 01/08/2014
	  Date of Modified                  : --
	  Methods Called                    : clickOn(String controlName),isElementDisplayed(String ControlName) ,pageAllignment(String relativeControlName, String controlName, String position)
	  Purpose of Method                 : Verifies Case studies text under products
	  Dependencies	                    : clickOn(userActions.get())
	  Reviewed By                       : --
	**/ 
	@Test(description="wi01155615_Service Detail Page_Case Studies",groups="Services")
	public void testServiceDetailedPageCaseStudies()
	{
		//Launch the avaya website
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		//click on communications outsourcing solutions which is under services from megamenu
		businessFunction.get().clickOnSubMenuItem("Services","Services_CommunicationsOutsourcingSolutions","Page_Title_Communications Outsourcing Solutions");
		businessFunction.get().deFocus();
		dynamicWait.get().waittillpageloads();		
		//verify case studies tab
		verify.get().isElementDisplayed("CaseStudies_Tab");
		//click on case studies tab
		userActions.get().clickOn("CaseStudies_Tab");
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		//verify the text displayed above the search textbox
		verify.get().isElementDisplayed("CaseStudies_TextAboveSearchbox");
		//verify the text present above the results area 
		verify.get().verifyElementContainsText("CaseStudies_CountText", "CaseStudies_CountTextMessage");
	}
	
	/** 
	 Author Name                       : Phanendra Ketavarapu
	 Date of Preparation               : 01/08/2014
	 Date of Modified                  : --
	 Methods Called                    : clickOn(Utilities),waittillpageloads(Dynamicwaits)
	 Purpose of Method                 : Verifies whether Header,description text,Learn more link present under community
	                                     pod and clicks on Learn more link
	 Dependencies	                   : --
	 Reviewed By                       : --
	**/
	@Test(description="About Avaya_Landing page_Community Pod_Learn More link",groups="About Avaya")
	public void testAboutAvayaCommunityPodLearnMoreLink() 
	{
		//Launch the avaya website
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		//Click on About Avaya from megamenu
		userActions.get().clickOn("MegaMenuAboutAvaya");
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		//verify the content under Community pod
		businessFunction.get().aboutAvayaPods("AboutAvayaTopPods_CommunityPod","CommunityHeader");
		//click on learn more link under community pod
		userActions.get().clickOn("AboutAvayaTopPods_CommunityPodLearnMore");
		//verify the title is present
		businessFunction.get().contentValidation("Page_Title");	
	}
	
	/** 
	  Author Name                       : Phanendra Ketavarapu
	  Date of Preparation               : 05/08/2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify if the Global footer is present in the SEO landing page
	  Dependencies	                   	: --
	  Reviewed By                       : --
	* 
	**/
	@Test(description="Verify if the Global footer is present in the SEO landing page", groups="SEO Page")
	public void testSEOLandingPageGlobalFooter(){
		
		//navigate to SEO URL
		getDriver().get(appConfig.getSeo_Url());	
		dynamicWait.get().waittillpageloads();
		//Verfiy the Latest News
		businessFunction.get().verifyMenuOrCategoryLinks("Footer_News_Parent");
		//Navigate to footer section and hover the mouse on Quick links tab
		userActions.get().hoverOn("Home_QuickLinks");			
		businessFunction.get().verifyMenuOrCategoryLinks("QuickLinks_ChildElements");
		//Verfiy the footer Links
		verify.get().isElementDisplayed("Magazine");
		verify.get().isElementDisplayed("Newsroom");
		verify.get().isElementDisplayed("Careers");
		verify.get().isElementDisplayed("Sitemap");
		verify.get().isElementDisplayed("Terms_of_Use");
		verify.get().isElementDisplayed("Privacy");
		verify.get().isElementDisplayed("Cookies");
		verify.get().isElementDisplayed("Contacts");
		businessFunction.get().verifyMenuOrCategoryLinks("Footer_Links");
		//verify the copyright
		verify.get().verifyElementContainsText("Copyright_Symbol", "Copyright_Symbol_expected");
		//Verify the Social Icons present in the footer
		businessFunction.get().socialIcons("FooterSocialIcons","Tag_Anchors","href");
		
	}
	
	/**
	  Author Name                       : Niharika K R 
	  Date of Preparation               :05-08-2014
	  Date of Modified                  : --
	  Methods Called                    : verifyAlertText(String expectedValue)
	  Purpose of Method                 : Verify the Search box functionality when single character is given in the global header 
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	  **/
	
	@Test(description="Verify the Search box functionality when single character is given in the global header",groups="GSA Search page")
	public void testGlobalSearchValidationSingleCharacter()
	{
		// Launching the Avaya Website
		getDriver().get(appConfig.getAppUrl());
		businessFunction.get().deFocus();
		// To eneter a single character in the search box of home page
		userActions.get().enterText("AvayaHome_SearchBox", "a");
		// To click on the search button
		userActions.get().clickOn("Search_Button_Test");
		// To verify the message displayed in the alert
		verify.get().verifyAlertText("AlertFailureMessage");
		// To clikck on OK button of alert
		userActions.get().clickAlertOk();
	}	
		
	/**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 05-08-2014
	  Date of Modified                  : --
	  Methods Called                    : isTextPresent(String controlName),verifyAlertText(String expectedValue)
	  Purpose of Method                 : Verify the Search box functionality when no inputs are given in the GSA search page
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	  **/
	
	@Test(description="Verify the Search box functionality when no inputs are given in the GSA search page",groups="GSA Search page")
	public void testGlobalSearchValidationNoInputs()
	{
		// Launching the Avaya Website
		getDriver().get(appConfig.getAppUrl());
		businessFunction.get().deFocus();
		// To eneter a single character in the search box of home page
		userActions.get().enterText("AvayaHome_SearchBox", "Avaya");
		// To click on the search button
		userActions.get().clickOn("Search_Button_Test");
		// To check if user is able to view Global results Page
		verify.get().isTextPresent("ResultsPage_Title");
		// To clear the search box
		userActions.get().clearTextBox("GSAResultsSearchBox");
		businessFunction.get().deFocus();
		// To click on the search button
		userActions.get().clickOn("GSAResultsSearchButton");
		// To verify the message displayed in the alert
		verify.get().verifyAlertText("GSAResultsFailureMessage");
		// To clikck on OK button of alert
		userActions.get().clickAlertOk();
	}
	
	/**
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 05/08/2014
	  Date of Modified                  : --
	  Methods Called                    : clickOn(String controlName),switchToChildWindow()
	  									switchToParentWindow(),sharingArticle(String controlName, String option)
	  Purpose of Method                 : Verify that a section can be shared in Facebook in a Perspective Article page
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	 
	**/
	@Test(description = "Share the section in Facebook Social site from Events Landing page",groups = "Events Page")
	public void testEventsLandingPageFacebook(){
		//Launching the Events Landing page
		getDriver().get(appConfig.getEventsUrl());
		//Click on Facebook icon
		dynamicWait.get().waittillpageloads();
		userActions.get().clickOn("EventPage_FacebookIcon");
		//Share the Link
		businessFunction.get().shareArticleInSocialSites("FacebookPlusData", "facebook");																				
		//Check the Shared Link in Facebook page
		getDriver().get(appConfig.getFacebookUrl());		
		businessFunction.get().validateSharedArticleInSocialSites("FacebookPlusData", "facebook");															
	}
	
	/**
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 05/08/2014
	  Date of Modified                  : --
	  Methods Called                    : clickOn(String controlName),switchToChildWindow()
	  									switchToParentWindow(),sharingArticle(String controlName, String option)
	  Purpose of Method                 : Verify that a section can be shared in GooglePlus in a Perspective Article page
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	 
	**/
	@Test(description = "Share the section in GooglePlus Social site from Events Landing page",groups = "Events Page")
	public void testEventsLandingPageGooglePlus() {
		//Launching the Events Landing page
		getDriver().get(appConfig.getEventsUrl());
		//Click on GooglePlus icon
		dynamicWait.get().waittillpageloads();
		userActions.get().clickOn("EventPage_GooglePlusIcon");	
		//Share the Link
		businessFunction.get().shareArticleInSocialSites("GooglePlusData", "googleplus");																				
		//Check the Shared Link in GooglePlus page
		getDriver().get(appConfig.getGooglePlusUrl());		
		businessFunction.get().validateSharedArticleInSocialSites("GooglePlusData", "googleplus");															
	}
	
	/**
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 05/08/2014
	  Date of Modified                  : --
	  Methods Called                    : clickOn(String controlName),switchToChildWindow()
	  									switchToParentWindow(),sharingArticle(String controlName, String option)
	  Purpose of Method                 : Verify that a section can be shared in LinkedIn in a Perspective Article page
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	 
	**/
	@Test(description = "Verify that a section can be shared in LinkedIn in a Perspective Article page",groups = "Events Page")
	public void testEventsLandingPageLinkedIn(){
		//Launching the Events Landing page
		getDriver().get(appConfig.getEventsUrl());
		//Click on LinkedIn icon
		dynamicWait.get().waittillpageloads();
		userActions.get().clickOn("EventPage_LinkedInIcon");	
		//Share the Link
		businessFunction.get().shareArticleInSocialSites("LinkedInPlusData", "linkedIn");																							
		//Check the Shared Link in LinkedIn page
		getDriver().get(appConfig.getLinkedInUrl());		
		businessFunction.get().validateSharedArticleInSocialSites("LinkedInPlusData", "linkedIn");
	}
	
	/**
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 18/07/2014
	  Date of Modified                  : --
	  Methods Called                    : clickOn(String controlName),enterText(String controlName,String text)
	  									sharingArticleInSocialSites(String controlName, String option, String ShareText)
	  Purpose of Method                 : Share Section in Twitter Social Site from Events Landing page
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	 
	 **/
	@Test(description = "Share Section in Twitter Social Site from Events Landing page",groups = "Events Page")
	public void testEventsLandingPageTwitter(){
		//Launching the Events Landing page
		getDriver().get(appConfig.getEventsUrl());
		//Click on Twitter Icon	to Share
		dynamicWait.get().waittillpageloads();
		userActions.get().clickOn("CaseStudiesLandingPage_TwitterIcon");
		//switch to the twitter window and share
		businessFunction.get().shareArticleInSocialSites("TwitterPlusData", "twitter");																
		//Check the Shared Link in Twitter page
		getDriver().get(appConfig.getTwitterUrl());		
		businessFunction.get().validateSharedArticleInSocialSites("TwitterPlusData", "twitter");	
	}
	
	/**
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 05/08/2014
	  Date of Modified                  : --
	  Methods Called                    : clickOn(String controlName),enterText(String controlName,String text)
	  									sharingArticleInSocialSites(String controlName, String option, String ShareText)
	  Purpose of Method                 : Share Sectionn in Twitter Social Site from NewsRoom Landing page
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	 
	 **/
	@Test(description = "Share Section in Twitter Social Site from NewsRoom Landing page",groups = "About Avaya-Newsroom")
	public void testNewRoomTwitter() throws InterruptedException{
		//Launching the Newsroom website
		getDriver().get(appConfig.getNewsRoomUrl());
		//Check the Social Icons are present on the top right 
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		businessFunction.get().socialIcons("NewsRoom_SocialIcons","CaseStudies_SocialIcons_Child","class");
		//Click on Twitter Icon	to Share
		userActions.get().clickOn("NewsRoom_TwitterIcon");
		//switch to the twitter window and share
		businessFunction.get().shareArticleInSocialSites("TwitterPlusData", "twitter");																
		//Check the Shared Link in Twitter page
		getDriver().get(appConfig.getTwitterUrl());	
		dynamicWait.get().waittillpageloads();
		businessFunction.get().validateSharedArticleInSocialSites("TwitterPlusData", "twitter");															
	}
	
	/**
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 07/07/2014
	  Date of Modified                  : 15-09-2014
	  Methods Called                    : clickOn(String controlName),switchToChildWindow()
	  									switchToParentWindow(),sharingArticle(String controlName, String option)
	  Purpose of Method                 : Verify that a section can be shared in PInterest in a Perspective Article page
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	 
	**/
	@Test(description = "Share the section in PInterest Social site from Events Landing page",groups = "Events Page")
	public void testEventsLandingPagePinterest(){
		//Launching the Events Landing page
		getDriver().get(appConfig.getEventsUrl());
		//Verify the Images present on the page for Pinterest
		businessFunction.get().verifyImageForPinterest();
		//Click on PInterest icon
		dynamicWait.get().waittillpageloads();
		userActions.get().clickOn("EventPage_PInterestIcon");
		//Share in PInterest site
		businessFunction.get().shareArticleInSocialSites("PinterestPlusData", "pinterest");																
		//Check the Shared Link in PInterest page
		getDriver().get(appConfig.getpInterestUrl());		
		businessFunction.get().validateSharedArticleInSocialSites("PinterestPlusData", "pinterest");															
	}
	
	/**
	  Author Name                       : Vinusha
	  Date of Preparation               : 15/09/2014
	  Date of Modified                  : --
	  Methods Called                    : clickOn(String controlName),enterText(String controlName,String text)
	  									sharingArticleInSocialSites(String controlName, String option, String ShareText)
	  Purpose of Method                 : Share Section in PInterest Social Site from NewsRoom Landing page
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	 
	 **/
	@Test(description = "Share Section in PInterest Social Site from NewsRoom Landing page",groups = "About Avaya-Newsroom")
	public void testNewRoomPInterest() {
		//Launching the Newsroom website
		getDriver().get(appConfig.getNewsRoomUrl());
		//Check the Social Icons are present on the top right 
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		businessFunction.get().socialIcons("NewsRoom_SocialIcons","CaseStudies_SocialIcons_Child","class");
		//Verfiy Images on the page for PInterest
		businessFunction.get().verifyImageForPinterest();
		//Click on Twitter Icon	to Share
		userActions.get().clickOn("NewsRoom_PInterestIcon");
		//Share in PInterest site
		businessFunction.get().shareArticleInSocialSites("PinterestPlusData", "pinterest");																
		//Check the Shared Link in PInterest page
		getDriver().get(appConfig.getpInterestUrl());		
		businessFunction.get().validateSharedArticleInSocialSites("PinterestPlusData", "pinterest");														
	}
	
	/**
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 05/08/2014
	  Date of Modified                  : --
	  Methods Called                    : clickOn(String controlName),switchToChildWindow(),closeChildWindow()
	  									sharingArticleInSocialSites(String controlName, String option, String shareText)
	  Purpose of Method                 : Verify that a Article can be shared in PInterest in a Perspective Article page
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	 
	**/
	@Test(description = "Verify that a Article can be shared in Pinterest in a Perspective Article page", groups = "Perspectives")
	public void testPerspectivesDetailPageSharePinterest() {
		//Launching the Avaya website
		getDriver().get(appConfig.getAppUrl());
		//Click on Perspective MegaMenu
		dynamicWait.get().waittillpageloads();
		businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "Perspectives_SubMenu", "PerspectivesTitlePage");
		//Click on Perspective Article
		dynamicWait.get().waittillpageloads();
		userActions.get().clickOn("Perspectives_article");
		//Click on Pinterest Icon
		dynamicWait.get().waittillpageloads();
		userActions.get().clickOn("Perspective_article_pinterest");
		//Share the Link
		businessFunction.get().shareArticleInSocialSites("PinterestPlusData", "pinterest");
		//Check the Shared Link in PInterest page
		getDriver().get(appConfig.getpInterestUrl());		
		businessFunction.get().validateSharedArticleInSocialSites("PinterestPlusData", "pinterest");	
	}
	
	/**
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 05/08/2014
	  Date of Modified                  : --
	  Methods Called                    : clickOn(String controlName),switchToChildWindow(),closeChildWindow()
	  									sharingArticleInSocialSites(String controlName, String option, String shareText)
	  Purpose of Method                 : Verify that a Article can be shared in GooglePlus in a Perspective Article page
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	 
	**/
	@Test(description = "Verify that a Article can be shared in GooglePlus in a Perspective Article page", groups = "Perspectives")
	public void testPerspectivesDetailPageShareGooglePlus() {
		//Launching the Avaya website
		getDriver().get(appConfig.getAppUrl());
		//Click on Perspective MegaMenu
		dynamicWait.get().waittillpageloads();
		businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "Perspectives_SubMenu", "PerspectivesTitlePage");
		//Click on Perspective Article
		dynamicWait.get().waittillpageloads();
//		userActions.get().clickOn("Perspectives_article");
		businessFunction.get().verifyArticleNavigation("Perspectives_ArticleList", "Perspectives_ArticleHeader");
		//Click on Google+ Icon
		dynamicWait.get().waittillpageloads();
		userActions.get().clickOn("Perspective_article_googleplus");
		//Share the Link
		businessFunction.get().shareArticleInSocialSites("GooglePlusData", "googleplus");	
		//Check the Shared Link in GooglePlus page
		getDriver().get(appConfig.getGooglePlusUrl());		
		businessFunction.get().validateSharedArticleInSocialSites("GooglePlusData", "googleplus");
	}
	
	/**
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 05/08/2014
	  Date of Modified                  : --
	  Methods Called                    : clickOn(String controlName),checkExtremeRightPosition(String controlName, String relativeControlName)
	  									checkCssProperty(String controlName, String cssProperty),switchToFrame(String frameName) 
	  									switchToDefaultContent(),isTextPresent(String controlName), isElementNotDisplayed(String controlName) 
	  Purpose of Method                 : Submit Feedback from CaseStudies page
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	 
	 **/
	@Test(description="Submit Feedback from CaseStudies page",groups = "About Avaya -Case Studies page")
	public void testCaseforAvayaLandingPageFeedBack() 
	{
		//Launching the Avaya Case Studies website
		getDriver().get(appConfig.getCaseStudiesUrl());
		//Wait till the feedback widget load 
		try {
		dynamicWait.get().waittillpageloads();
			Thread.sleep(5000);
		//Verify whether the Feedback button is present on the extreme right position on the page or not
		verify.get().isElementDisplayed("HomePage_Feedback");
		//click on Feedback button
		userActions.get().clickOn("HomePage_Feedback");
		dynamicWait.get().waittillpageloads();
		Thread.sleep(5000);
		//switch to frame
	    userActions.get().switchToFrame("HomePage_Feedback_Frame");
	    //Select satisfied radio button
		userActions.get().clickOn("Feedback_Satisfied");
		//enter comments
		userActions.get().enterText("Feedback_text","QA_Test_Automation_Feedback");
		//click on submit button
	    userActions.get().clickOn("Feedback_Submit_Button");
	    //verify thankyou message
	    verify.get().isTextPresent("Thankyou_FeedbackMessage");
	    //click in the Close Button
	    userActions.get().clickOn("Feedback_CloseButton");
	    userActions.get().switchToDefaultContent();
	    //verify if feedback widget is closed 
	    verify.get().isElementNotDisplayed("HomePage_Feedback_Frame");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/** 
	  Author Name                       :Pankaj
	  Date of Preparation               : 22/09/2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify if the user is able to share the page on LinkedIn
	  Dependencies	                   	: --
	  Reviewed By                       : --
	 
	* 
	**/
@Test(description="Verify if the user is able to share the page on LinkedIn", groups="About Avaya-Newsroom")
	public void testNewsRoomLinkedIN() throws InterruptedException{
		
		//navigate to newroom URL
		getDriver().get(appConfig.getNewsRoomUrl());
		dynamicWait.get().waittillpageloads();
		//verify newsroom landing page
		//verify.get().isTextPresent("Newsroom_Title");
		//verify the share section is present towards right of the page
		//businessFunction.get().checkCssProperty("NewsRoom_SocialIcons_Alignment","float");
		/*Share section should be present with the following buttons:

		•Twitter icon

		•Facebook icon

		•Linked In icon

		•Google + icon

		•Email icon*/
		businessFunction.get().socialIcons("NewsRoom_SocialIcons_Parent","CaseStudies_SocialIcons_Child","class");
		//click on LinkedIN Icon
		userActions.get().clickOn("NewsRoomLinkedIn");
		//Share the article in linkedIn site
		businessFunction.get().shareArticleInSocialSites("LinkedInPlusData", "linkedIn");	
		//Check the Shared Link in LinkedIn page
		getDriver().get(appConfig.getLinkedInUrl());		
		businessFunction.get().validateSharedArticleInSocialSites("LinkedInPlusData", "linkedIn");
		}
	
	
	/**
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 02/07/2014
	  Date of Modified                  : --
	  Methods Called                    : deFocus(String controlName),clickOn(String controlName),
	  									verifyBreadCrumb(String actualControlName, String expectedControlName),
	  									clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle),
	  									isTextPresent(String controlName),isElementDisplayed(String controlName)
	  Purpose of Method                 : Verify the Interships page content present under About Avaya/Careers
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	 **/
	@Test(description = "Verify the Interships page content present under About Avaya/Careers",groups = "Careers page")
	public void testCareersInternshipsContent(){
		//Launching the Avaya website
		getDriver().get(appConfig.getAppUrl());
		//Click on Doing Business with you after Hovering on About Avaya
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "AboutAvaya_Careers", "Careers_Title");
		businessFunction.get().deFocus();
		//Click on Explore Your Future With Us CTA
		dynamicWait.get().waittillpageloads();
		userActions.get().clickOn("Careers_ExploreYourFutureWithUs");
		//Click on Internship Tab
		dynamicWait.get().waittillpageloads();
		userActions.get().clickOn("Careers_InternshipTab");
		//Check the Breadcrumb in Internship Tab page
		dynamicWait.get().waittillpageloads();
		businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "Career_InternshipTab_BreadcrumbExpected","Tag_Anchors");
		//Check the Header is Internship
		verify.get().isTextPresent("Careers_InternshipsTab_Title");
		//Check the Explore Global Opportunities
		verify.get().isElementDisplayed("ExploreGlobalOpportunities");
		//Check the Content
		businessFunction.get().contentValidation("InternshipContent");
		//Verify the Image present
		businessFunction.get().imageValidation("Meaningful_Internships");
		//Check the Content
		businessFunction.get().contentValidation("InternshipContent2");
		//Verify the Image present
		businessFunction.get().imageValidation("AvayaInterns");
		//Check the Content
		businessFunction.get().contentValidation("InternshipContent3");
		//Verify the Image present
		businessFunction.get().imageValidation("RequirementsInternship");
		
	}
	
	/**
	  Author Name                       : Phanendra Ketavarapu
	  Date of Preparation               : 08/05/2014
	  Date of Modified                  : --
	  Methods Called                    : clickOn(String controlName),isElementDisplayed(String ControlName) ,pageAllignment(String relativeControlName, String controlName, String position)
	  Purpose of Method                 : Verify the resource artilce link
	  Dependencies	                    : clickOn(userActions)
	  Reviewed By                       : --
	**/            
	@Test(description="Capabilties_Detail Page_Resources_View Article",groups="Solutions")
	public void testCapabilitiesResourcesViewArticle()
	{
		//Launching the Avaya Website
		getDriver().get(appConfig.getAppUrl());
		//Hover on Capabilities and Click on Video Collaboration
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		businessFunction.get().clickOnSubMenuItem("Solutions", "Network_Virtualization", "Network_Virtualization_Header");
		businessFunction.get().deFocus();
		//click on Resources tab
		userActions.get().clickOn("DocumentandVideos_tab");
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		//Check the navigation of article link
		businessFunction.get().checkChildWindow("ResourceLink");

	}      
	
	/**
	  Author Name                          : Pankaj Sharma
	  Date of Preparation                  : 22/09/2014
	  Date of Modified                     : --
	  Methods Called                       : 
	  Purpose of Method                    : Verify the images displayed in the Capabilites pod when user is segmented under Networking
	  Dependencies	                       : 
	  Reviewed By                          : --
	**/ 
	
	@Test(description="Verify the images displayed in the Capabilites pod when user is segmented under Networking",groups="Solutions")
	public void testHomePageCapabilitiesNetworkingModule()
	{
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		businessFunction.get().clickOnSubMenuItem("Products", "ProductsSubMenuEthernetRoutingSwitch3500Series", "EthernetRoutingSwitch3500PageTitle");
		getDriver().navigate().refresh();
		dynamicWait.get().waittillpageloads();
		getDriver().navigate().refresh();
		dynamicWait.get().waittillpageloads();
		getDriver().navigate().refresh();
		dynamicWait.get().waittillpageloads();
		userActions.get().clickOn("HomePage_Logo");
		dynamicWait.get().waittillpageloads();
		businessFunction.get().verifyHomePageCarouselHPSegmentation("HomePageCarouselActiveImage","Avaya Fabric Connect");
		
	}
	/**
	  Author Name                       : Phanendra Ketavarapu
	  Date of Preparation               : 02-09-2014
	  Date of Modified                  : 
	  Methods Called                    : clickOn(String controlName),isElementDisplayed(String ControlName) ,pageAllignment(String relativeControlName, String controlName, String position)
	  Purpose of Method                 : Verify the tealium tags present in the source code for thank you page
	  Dependencies	                    : clickOn(userActions.get()),verifyTealiumTags(BusinessFunctions)
	  Reviewed By                       : --
	**/ 
	@Test(description="wi01157104_Premium Content Registration Form_Thank you page_Tealium Tags",groups="Tealium Tags")
	public void testThankYouPageTealiumTags()
	{
		//Launch the avaya website
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		//click on Avaya Aura platform link which is under products from megamenu
		businessFunction.get().clickOnSubMenuItem("Products", "Products_AvayaAuraPlatform", "Products_AvayaAuraPlatform_Title");
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		//click on Resources tab
		userActions.get().clickOn("DocumentandVideos_tab");
		dynamicWait.get().waittillpageloads();		
		//click on article link
		userActions.get().clickOn("PremiumLink_AvayaDeploymentServices");
		dynamicWait.get().waittillpageloads();
		//key in the user details for registration
		businessFunction.get().sendinputdata("RegistrationInputdata", "registration","none");
		//click on submit button
		userActions.get().clickOn("Registration_Submit");
		dynamicWait.get().waittillpageloads();
		//verify the tealium tags
		businessFunction.get().verifyTealiumTags("ThankYouPage_TealiumTag","ThankYouPage_TealiumTagName","name");
	}
	
	/** 
    Author Name                       : Pankaj
    Date of Preparation               : 11/07/2014
    Date of Modified                  : --
    Methods Called                    : verifyImageActive,isTextPresent,isElementPresent(Verify),clickOn(UserActions)
    Purpose of Method                 : Verify the Details present in the  Additional resources Pod in the Story page
    Dependencies	                  : --
    Reviewed By                       : --
    Test Case Name					  : Brand Campaign Story_BR-F.040_Additional resources_Details
    **/

  @Test(description="Verify the Details present in the  Additional resources Pod in the Story page",groups="Brand Campaign")
	public void testBrandCamapaignAddResources() {

		// Launching the Avaya URL
		getDriver().get(appConfig.getImagineUrl());
		dynamicWait.get().waittillpageloads();
		// Verifying BrandCamapaignHeroImage is present or not
		businessFunction.get().imageValidation("BrandCamapaignHeroImage");
		// Clicking on BrandCamapaignViewStory link
		userActions.get().clickOn("BrandCamapaignViewStory");
		dynamicWait.get().waittillpageloads();
		// Verifying CustomerStoryTitle
		businessFunction.get().contentValidation("CustomerStoryTitle");
/*		// Verifying DemandProducts
		businessFunction.get().contentValidation("DemandProducts");
		businessFunction.get().contentValidation("ProductsUsedByCarlosBakery");*/
	}
	
  /**
  Author Name                       : Sowmya Mohanan
  Date of Preparation               : 11/07/2014
  Date of Modified                  : 10-09-2014
  Methods Called                    : isElementDisplayed(String controlName),verifyBreadCrumb(String actualControlName, String expectedControlName)
  									socialIcons(String controlName,String childElement,String attribute),verifyImageActive(String imgControlName)
  									verifyElementContainsText(String controlName, String controlNameExpected)
  									checkImageSource(String controlName,String expected,String attrName),isTextPresent(String controlName)
  Purpose of Method                 : Verify the Brand Campaign Landing Page Content
  Dependencies	                    : Jar files
  Reviewed By                       : --
**/
@Test(description = "Verify the Brand Campaign Landing Page Content",groups = "Brand Campaign")
public void testBrandCamapaignLandingPage(){
	//Launching the Brand Camapaign Page
	getDriver().get(appConfig.getImagineUrl());
	//Verify the Butler Bar
	dynamicWait.get().waittillpageloads();
	businessFunction.get().deFocus();
	verify.get().isElementDisplayed("ButlerBar");
	//Verify the Mega Menu
	verify.get().isElementDisplayed("Megamenu");
	//Verify the Global Search
	verify.get().isElementDisplayed("GlobalSearch");
	//Check the Breadcrumb
	businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "Imagine_BreadCrumb_Expected","Tag_Anchors");
	//Check the Social Share Icons
	businessFunction.get().socialIcons("Image_SocialIcons", "CaseStudies_SocialIcons_Child", "class");
	//Check the Image Title
	businessFunction.get().imageValidation("Image_Title");
	//Verify the description 
	businessFunction.get().contentValidation("Image_Description");
	//Verify the Meet Our Customers Title
	businessFunction.get().contentValidation("Meet_Our_Customers_Title");
	
	/*Check the Customer Story Pods Details*/
	businessFunction.get().verfiyBrandCampaignPods("BrandCampaign_PodsSection");
			
	//Check the Latest News
	verify.get().isElementDisplayed("LatestNews");
	//Verify the Quick Links
	verify.get().isElementDisplayed("Home_QuickLinks");
	//Check the Global Footer
	verify.get().isElementDisplayed("Global_Footer");
	//To check the presence of Footer Social Media icons 
	businessFunction.get().socialIcons("FooterSocialIcons","Tag_Anchors","href");		
	//To verify the presence of copyright symbol
	verify.get().verifyElementContainsText("Copyright_Symbol", "Copyright_Symbol_expected");
	
}

/** 
Author Name                       : @author karthik_b14
Date of Preparation               : 16/07/2014
Date of Modified                  : 10/09/2014
Methods Called                    : checkToggleMenuArrows(String actualControlName,String expectedControlName,String direction),
									  pageAllignment(String relativeControlName, String controlName, String position),
									  isTextPresent(String controlName) 
Purpose of Method                 : Verify the toggle menu present in the avaya labs home page
Dependencies	                   	: --
Reviewed By                       : --
* 
**/
@Test(description="Verify the toggle menu present in the avaya labs home page", groups="Avaya Labs")
public void testAvayalabsToggleMenu()
{
	//navgiate to avaya labs
	getDriver().get(appConfig.getAvayaLabsUrl());
	dynamicWait.get().waittillpageloads();
	businessFunction.get().deFocus();
	//Verify the toggle menu present in the avaya labs home page
	businessFunction.get().checkToggleMenuArrows("AvayaLabs_OverviewToggleArrow", "Expanded_Arrow", "up");
	businessFunction.get().checkToggleMenuArrows("AvayaLabs_PeopleToggleArrow", "Expanded_Arrow", "up");
	//To verify whether the Toggle menu section is present on the left side of the page
	businessFunction.get().pageAllignment("ButlerBar", "Avayalabs_ToggleSection", "equal");
	verify.get().isTextPresent("AvayaLabs_ToggleMenu_Overview");
	verify.get().isTextPresent("AvayaLabs_ToggleMenu_People");
}

/** 
Author Name                       : Pankaj
Date of Preparation               : 16/07/2014
Date of Modified                  : 10/09/2014
Methods Called                    : clickOn(UserActions),clickOnSubMenuItem(businessfunction),isTextPresent,
									clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle),
									imageValidation(String imageControlName)
									verifyMenuOrCategoryLinks(String controlName)
Purpose of Method                 : Verify the Phone Category Modules Present on the Phones Landing Page
Dependencies	                  : --
Reviewed By                       : --
Image							  : YES
Test Case Name					  :  Phones_Landing Page_Category Module

**/

@Test(description="Verify the Phone Category Modules Present on the Phones Landing Page",groups="Phones")
public void testProductsPhoneLandCategory()
{
	// Launching the Avaya URL
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	//Clicking on NewPhonesPage link when user hover on Products	
	businessFunction.get().clickOnSubMenuItem("Products", "NewPhonesPage", "NewPhonesPageHeading");
	//To verify the title of the Desktop phone category pod
	verify.get().isTextPresent("NewPhones_DesktopPhoneTitle"); 
	//To verify the description of the Desktop phone category pod
	businessFunction.get().contentValidation("NewPhones_DesktopPhoneDescription");
	//To verify the image of the Desktop phone category pod
	businessFunction.get().imageValidation("NewPhones_DesktopPhoneImage");
	//To verify the CTA of the Desktop phone category pod
	businessFunction.get().verifyMenuOrCategoryLinks("NewPhones_DesktopPhoneCTA");	
}

/** 
Author Name                       : Sivanag
Date of Preparation               : 16/07/2014
Date of Modified                  : --
Methods Called                    : clickAndVerifyNavigation(String navigatetopage,String pageTitle),
									clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle),
									imageValidation(String imageControlName),
									contentValidation(String controlName),
									verifyMenuOrCategoryLinks(String controlName)
Purpose of Method                 : Verify the Phone Series Modules Present on the  Desktop Phones Category Page
Dependencies	                  : --
Reviewed By                       : --
Image 							  : YES
Test Case Name					  :  Phones_Category Page_Series Module

**/

@Test(description="Verify the Phone Series Modules Present on the  Desktop Phones Category Page",groups="Phones")
public void testProductsPhoneSeriesModule()
{
	// Launching the Avaya URL
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	//Clicking on NewPhonesPage link when user hover on Products	
	businessFunction.get().clickOnSubMenuItem("Products", "NewPhonesPage", "NewPhonesPageHeading");    	 
   	//Clicking on the ExploreDesktopPhones line
	businessFunction.get().clickAndVerifyNavigation("Phones_DesktopPhones", "DesktopPhoneHeading");
	//Verifying Desktop phone Image
	businessFunction.get().imageValidation("DesktopPhoneImage");	
	//Verifying Desktop Phone Description/Network/Platform
	businessFunction.get().contentValidation("DesktopPhoneDesc");
	//Verifying DesktopPhoneLearnMore
	businessFunction.get().verifyMenuOrCategoryLinks("DesktopPhoneLearnMore");
}

/**
Author Name                       : Sowmya Mohanan
Date of Preparation               : 07/07/2014
Date of Modified                  : --
Methods Called                    : clickOn(String controlName),switchToChildWindow()
									
Purpose of Method                 : Verify the Base Ball Cards present in CaseStudies page
Dependencies	                    : Jar files
Reviewed By                       : --
**/
@Test(description = "Verify the Base Ball Cards present in CaseStudies page",groups = "Case Studies page")
public void testCaseStudiesLandingPageBaseBallCardClickOnCategory(){
	//Launching the Avaya website
	getDriver().get(appConfig.getCaseStudiesUrl());
	//Verify the Article Sections are displayed below the Menu section
	dynamicWait.get().waittillpageloads();
	businessFunction.get().deFocus();
	businessFunction.get().pageAllignment("CaseStudiesLandingPage_ScrollAble", "CaseStudies_LandingPage_ArticleSection", "above");
	//Verify all the Articles
	businessFunction.get().checkCaseStudiesDetails("CaseStudies_Details");
	//Click on a category and Check the article matching to the selected category
	businessFunction.get().checkArticleHeader("CaseStudiesLandingPage_ArticleCategory","CaseStudiesLandingPage_CategoryList");
}

/**
Author Name                       : Sowmya Mohanan
Date of Preparation               : 08/07/2014
Date of Modified                  : 10-09-1986
Methods Called                    : clickOn(String controlName),
									pageAllignment(String relativeControlName, String controlName, String position),
									isElementDisplayed(String controlName),checkChildElementsText(String controlName,String childElement)
Purpose of Method                 : Verify the Industry filter in CaseStudies Landing Page
Dependencies	                    : Jar files
Reviewed By                       : --
**/
@Test(description = "Verify the Industry filter in CaseStudies Landing Page",groups = "Case Studies page")
public void testCaseStudiesLandingPageIndustryFilter(){
	//Launching the Avaya CaseStudies Page
	getDriver().get(appConfig.getCaseStudiesUrl());
	//Check the Industry section is aligned to right
	dynamicWait.get().waittillpageloads();
	businessFunction.get().deFocus();
	businessFunction.get().pageAllignment("ButlerBar","CaseStudiesLandingPage_IndustrySection", "right");
	dynamicWait.get().waittillpageloads();
	//Click on Show All Link
	userActions.get().clickOn("show_all_topics");
	dynamicWait.get().waittillpageloads();
	//Check the Industry section filter
	businessFunction.get().verifySubMenuElementDetails("CaseStudiesLandingPage_IndustrySection");
	//Click on Higher Education Link
	userActions.get().clickOn("CaseStudiesLandingPage_IndustrySection_HigherEducation");
	//Check the Your Selection is dispalyed below the Scrollable Bar
	dynamicWait.get().waittillpageloads();
	userActions.get().clickOn("show_all_topics");
	businessFunction.get().verifySelectionCount("CaseStudiesLandingPage_Articles", "CaseStudiesLandingPage_IndustrySection_HigherEducation");
	//Click on Education k-12 Link
	userActions.get().clickOn("CaseStudiesLandingPage_IndustrySection_EducationK12");
	//Check the Your Selection is dispalyed below the Scrollable Bar
	dynamicWait.get().waittillpageloads();
	businessFunction.get().verifySelectionCount("CaseStudiesLandingPage_Articles", "CaseStudiesLandingPage_IndustrySection_EducationK12");
	//Click on Energy and utilities Link
	userActions.get().clickOn("CaseStudiesLandingPage_IndustrySection_EngergyUtilities");
	//Check the Your Selection is dispalyed below the Scrollable Bar
	dynamicWait.get().waittillpageloads();
	businessFunction.get().verifySelectionCount("CaseStudiesLandingPage_Articles", "CaseStudiesLandingPage_IndustrySection_EngergyUtilities");
	//Click on Finance Link
	//userActions.get().clickOn("CaseStudiesLandingPage_IndustrySection_finance");
	//Check the Your Selection is dispalyed below the Scrollable Bar
	//dynamicWait.get().waittillpageloads();
	//businessFunction.get().verifySelectionCount("CaseStudiesLandingPage_Articles", "CaseStudiesLandingPage_IndustrySection_finance");
	//Click on General services Link
	userActions.get().clickOn("CaseStudiesLandingPage_IndustrySection_GeneralServices");
	//Check the Your Selection is dispalyed below the Scrollable Bar
	dynamicWait.get().waittillpageloads();
	businessFunction.get().verifySelectionCount("CaseStudiesLandingPage_Articles", "CaseStudiesLandingPage_IndustrySection_GeneralServices");
	//Click on Government-state & Local Link
	userActions.get().clickOn("CaseStudiesLandingPage_IndustrySection_Government");
	//Check the Your Selection is dispalyed below the Scrollable Bar
	dynamicWait.get().waittillpageloads();
	businessFunction.get().verifySelectionCount("CaseStudiesLandingPage_Articles", "CaseStudiesLandingPage_IndustrySection_Government");
	//Click on Tele communications Link
	userActions.get().clickOn("CaseStudiesLandingPage_IndustrySection_Telecommunciations");
	//Check the Your Selection is dispalyed below the Scrollable Bar
	dynamicWait.get().waittillpageloads();
	businessFunction.get().verifySelectionCount("CaseStudiesLandingPage_Articles", "CaseStudiesLandingPage_IndustrySection_Telecommunciations");
	//Click on Utilities/oil & Gas Link
	userActions.get().clickOn("show_all_topics");
	userActions.get().clickOn("CaseStudiesLandingPage_IndustrySection_Utilities");
	//Check the Your Selection is dispalyed below the Scrollable Bar
	dynamicWait.get().waittillpageloads();
	userActions.get().clickOn("show_all_topics");
	businessFunction.get().verifySelectionCount("CaseStudiesLandingPage_Articles", "CaseStudiesLandingPage_IndustrySection_Utilities");
	//Click on Virtualization Link
	userActions.get().clickOn("CaseStudiesLandingPage_IndustrySection_Virtualization");
	//Check the Your Selection is dispalyed below the Scrollable Bar
	dynamicWait.get().waittillpageloads();
	businessFunction.get().verifySelectionCount("CaseStudiesLandingPage_Articles", "CaseStudiesLandingPage_IndustrySection_Virtualization");
			
}



/** 
Author Name                       : Sivanag
Date of Preparation               : 16/07/2014
Date of Modified                  : --
Methods Called                    : clickOn(UserActions),clickOnSubMenuItem(businessfunction),isTextPresent,verifyImageActive,isElementPresent(Verify)
Purpose of Method                 : Verify the details in the Featured Image Pod
Dependencies	                  : --
Reviewed By                       : --
Test Case Name					  :  Phones_Detail page_Featured Phone

**/

@Test(description="Verify the details in the Featured Image Pod",groups="Phones")
public void testProductsFeaturedPhone()
{
	// Launching the Avaya URL
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	//Clicking on NewPhonesPage link when user hover on Products	
	businessFunction.get().clickOnSubMenuItem("Products", "NewPhonesPage", "NewPhonesPageHeading");    	 
   	//Clicking on the ExploreDesktopPhones line
	businessFunction.get().clickAndVerifyNavigation("Phones_DesktopPhones","DesktopPhoneHeading");
	//Clicking on LearnMore
	userActions.get().clickOn("DesktopPhoneLearnMore");
	dynamicWait.get().waittillpageloads();
	//Verifying SeriesPhoneImage
	businessFunction.get().imageValidation("SeriesPhoneImage");
	//Verifying SeriesPhone title
	verify.get().isTextPresent("SeriesPhoneTitle");
	//Verifying SeriesPhone Description
	businessFunction.get().contentValidation("SeriesPhoneDesc");
}

/**
Author Name                       : Sowmya Mohanan
Date of Preparation               : 03/07/2014
Date of Modified                  : 16/07/14
Methods Called                    : clickOn(String controlName),enterText(String controlName,String text)
									sharingArticleInSocialSites(String controlName, String option, String ShareText)
Purpose of Method                 : Share Sectionn in Twitter Social Site from CaseStudies Landing page
Dependencies	                    : Jar files
Reviewed By                       : --

**/
@Test(description = "Share Sectionn in Twitter Social Site from CaseStudies Landing page",groups = "Case Studies page")
public void testCaseStudiesLandingPageShareSectionTwitterIcon(){
	//Launching the Case Studies Landing page
	getDriver().get(appConfig.getCaseStudiesUrl());
	//Check the Social Icons are presen on the top right 
	dynamicWait.get().waittillpageloads();
	businessFunction.get().deFocus();
	businessFunction.get().socialIcons("CaseStudies_SocialIcons","CaseStudies_SocialIcons_Child","class");		
	//Click on Twitter Icon	to Share
	userActions.get().clickOn("CaseStudiesLandingPage_TwitterIcon");
	//switch to the twitter window and share
	businessFunction.get().shareArticleInSocialSites("TwitterPlusData", "twitter");																
	//Check the Shared Link in Twitter page
	getDriver().get(appConfig.getTwitterUrl());		
	businessFunction.get().validateSharedArticleInSocialSites("TwitterPlusData", "twitter");															
}

/** 
Author Name                       : @author Pankaj
Date of Preparation               : 18/07/2014
Date of Modified                  : 10/09/2014
Methods Called                    : isTextPresent(String controlName),contentValidation(String controlName)
Purpose of Method                 : Verify the title and subtitle present in the SEO landing page and compare with CMS
Dependencies	                   	: --
Reviewed By                       : --
* 
**/
@Test(description="Verify the title and subtitle present in the SEO landing page and compare with CMS(in this case subtitle set in CMS will be set as expected value in test data sheet)", groups="SEO Page")
public void testSEOLandingPageTitleSubTitle()
{
	//navigate to SEO URL
	getDriver().get(appConfig.getSeo_Url());
	//Verifies Title
	verify.get().isTextPresent("SEO_Title");
//To verify  Sub Title 
businessFunction.get().contentValidation("SEO_SubTitle");
}
  
	/** 
    Author Name                       : Pankaj
    Date of Preparation               : 09/07/2014
    Date of Modified                  : --
    Methods Called                    : verifyImageActive,isElementPresent(Verify),clickOn(UserActions)
    Purpose of Method                 : Verify the customer section on the landing page
    Dependencies	                  : --
    Reviewed By                       : --
    Image							  : YES
    Test Case Name					  :  Brand Camapaign_BR-F.0012A_Hero Image_link
    **/

	@Test(description = "Verify the customer section on the landing page", groups = "Brand Campaign")
	public void testBrandCamapaignHeroImage() {
		// Launching the Avaya URL
		getDriver().get(appConfig.getImagineUrl());
		dynamicWait.get().waittillpageloads();		
		// Verifying the CamapaignImage
		businessFunction.get().imageValidation("BrandCamapaignImageLandpage");		
		// Clicking on the Image present in the First Customer Pod
		businessFunction.get().imageValidation("BrandCamapaignHeroImage");
		userActions.get().clickOn("BrandCamapaignHeroImage");
		dynamicWait.get().waittillpageloads();
		
	}
	
	
	/** 
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 05/08/2014
	  Date of Modified                  : --
	  Methods Called                    : clickAndVerifyNavigation(String navigatetopage,String pageTitle),productsPagination(String controlName,String relativeControlName,String childControlName)
	  Purpose of Method                 : Verify the functionality of View All link
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/
	
	@Test(description="Verify the pagination in the products landing page",groups="Products")
	public void testProductsPagination() 
	{
		//Launching the Avaya website
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		//click on the Products tab in the Megamenu
		businessFunction.get().clickAndVerifyNavigation("Products", "Products_label");
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		//Click on the 2 link in the pagination in Products landing page
		userActions.get().clickOn("Products_Pagination_2ndlink");
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		//To click on the Previous link in the Products landing page and to verify if corresponding products are displayed in both the pages.
		businessFunction.get().paginationValidation("Products_2ndPage","Products_1stPage","Products_Pagination_Prev");
		//Click on "Next"  Link in Products landing page
		userActions.get().clickOn("Products_Pagination_Next");		
	}
	/** 
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 05/08/2014
	  Date of Modified                  : --
	  Methods Called                    : isElementNotPresent(String controlName),verifyChildElementsByCount(String parentControlName,String tagName, String count)
	                                       clickAndVerifyNavigation(String navigatetopage,String pageTitle)
	  Purpose of Method                 : Verify the functionality of View All link
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/
	
	@Test(description="Verify the functionality of View All link",groups="Products")
	public void testProductsPaginationViewAll() 
	{
		//Launching the Avaya website
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		//click on the Products tab in the Megamenu
		businessFunction.get().clickAndVerifyNavigation("Products", "Products_label");
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		//Click on the View All link in Products landing page
		businessFunction.get().productsAndArticlesOnLoadMore("Products_FirstPageAllNames", "Products_ViewAllNames","Products_Pagination_ViewAll");
		//To check if Pagination is not being displayed.
		verify.get().isElementNotPresent("Products_Pagination");
	}
	/**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 17/06/2014
	  Date of Modified                  : --
	  Methods Called                    : clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle),checkSelectedTabActive(String controlName, String childElement,String str_selectedtabname)  ,checkVideoPresent(String imageControlName,String videoControlName, String attribute),isTextPresent(String controlName),verifyVideo(String videoPlay, String playIcon)
	                                      checkChildElements(String controlName,String childElement,String delimiter),verifyImagePresent(String expectedImage, String imageElement)
	                                      checkPodsImageCount(String controlName, String count),isElementDisplayed(String controlName)
	  Purpose of Method                 : Verify the Content present under the Overview tab
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/	
	
	@Test(description="Verify the Content present under the Overview tab",groups="Products")
	public void testProductsDetailedPage() 
	{
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		//Hover on the Products tab in the Megamenu and click on AvayaAuraPlatform from the menu and Check the presence of the title in Products Detailed Page
		businessFunction.get().clickOnSubMenuItem("Products","Products_AvayaAuraPlatform","Products_AvayaAuraPlatform_Title");
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		//Check the presence of the tabs in the tab control
	    businessFunction.get().verifySubMenuElements("Products_AAP_Tabs","Tag_List",",");
		//Check the presence of the Product Image in Products Detailed Page.
	    userActions.get().clickOn("Products_AvayaAuraPlatform_Image");
	    verify.get().verifyVideoAfterClickingPlay();
		//To check the presence of Teaser Description in Products Detailed Page.
	    businessFunction.get().contentValidation("Products_AvayaAuraPlatform_Description");
		//To check the presence of the Product Descriptive Pods and if each pod has either 1 or 3 images in it.
		businessFunction.get().verifyPods("Products_AAP_DescriptivePods");
	    //To Check the presence of the pods in Products Detailed Page.
		businessFunction.get().verifyPartnerAndProductPods("Products_AAP_Pods", "Tag_Anchors");		
		//To check whether Overview tab is selected by default
		businessFunction.get().checkSelectedTabActive("Products_AAP_ParentTab", "Products_AAP_Tabs_Child", "OVERVIEW");	
	}	
	
	/**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 01/07/2014
	  Date of Modified                  : --
	  Methods Called                    : verifyImagePresent(String expectedImage, String imageElement),isTextPresent(String controlName)
	                                      checkSelectedTabActive(String controlName, String childElement,String str_selectedtabname) ,clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle)
	  Purpose of Method                 : Verify the details present on the Overview tab of Service Detail page
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/
	
	@Test(description="Verify the details present on the Overview tab of Service Detail page",groups="Services")
	public void testServiceDetailOverview() 
	{
		//Launching the Avaya Website
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		//To click on the Contact Center Optimization from the Services tab
		businessFunction.get().clickOnSubMenuItem("Services", "ContactCenterOptimization", "ContactCenterOptimization_Title");
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		//To check whether the Overview tab has been selected or not 
		businessFunction.get().checkSelectedTabActive("Services_CCO_Parent_Tab", "Tag_List", "OVERVIEW");
		//To verify the presence of static image in the Introsection of overview page 
		businessFunction.get().imageValidation("ContactCenterOptimization_Image");
		//To verify the presence of A sentence all in caps in the Introsection of overview page 
		verify.get().verifyTextPresentInCaps("ContactCenterOptimization_Text");
		//To verify the text in the Promo pods
		businessFunction.get().contentValidation("PromoPod1_Text");
		businessFunction.get().contentValidation("PromoPod2_Text");
	}
	
	/** 
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 12/07/2014
	  Date of Modified                  : 09-09-1986
	  Methods Called                    : clickAndVerifyNavigation(String navigatetopage,String pageTitle),verifyElementContainsText(String controlName, String controlNameExpected)
	                                      deFocus(String controlName) ,isTextPresent(String controlName) 
	  Purpose of Method                 : Verify if the user is able to navigate to the corresponding pages on click of links in the HOW TO BUY pod
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/
	
	@Test(description="Verify if the user is able to navigate to the corresponding pages on click of links in the HOW TO BUY pod",groups="Investors")
	public void testInvestorsHowToBuy() 
	{
		//Launching the Investors Avaya website
		getDriver().get(appConfig.getInvUrl());
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		//To check if Investors home page is be displayed
		verify.get().isTextPresent("Investors_Title");
		//To check the content in the How to Buy pod
		businessFunction.get().verifyPartnerAndProductPods("Investors_HowToBuyPod", "Tag_Anchors");
//		verify.get().verifyElementContainsText("Investors_HowToBuyPod", "Investors_HowToBuyPod_Content");
	    //Click on Email Us link and check if the page is navigated to Email Avaya Page
		businessFunction.get().clickAndVerifyNavigation("Investors_HowToBuy_Email","Investors_HowToBuy_EmailPage");				
	}
	
	/**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 05/08/2014
	  Date of Modified                  : --
	  Methods Called                    : clickAndVerifyNavigation(String navigatetopage,String pageTitle),verifyImagePresent(String expectedImage, String imageElement)
	                                      checkChildElements(String controlName,String childElement),checkText(String controlName,String childElement,String expectedFileName)
	  Purpose of Method                 : Verify if the user is able to view Code Of Conduct page in investors webpage
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/
	
	@Test(description="Verify if the user is able to view Code Of Conduct page in investors webpage",groups="Investors")
	public void testInvestorsCorporateGovernanceCodeOfConduct() 
	{
		//Launching the Investors Avaya website
		getDriver().get(appConfig.getInvUrl());
		dynamicWait.get().waittillpageloads();
		//To click on Code of Conduct
		businessFunction.get().clickAndVerifyNavigation("Investors_CodeOfConduct", "Investors_CorporateGovernance_Title");
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		//To check the presence of Hero Image in Code Of Conduct  web page
		businessFunction.get().imageValidation("Investors_CodeOfConduct_Image");
		//To check the presence of text description in Code Of Conduct  web page
		businessFunction.get().contentValidation("Investors_CodeOfConduct_Description");
	} 
	
	/**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 05/08/2014
	  Date of Modified                  : --
	  Methods Called                    : clickAndVerifyNavigation(String navigatetopage,String pageTitle),verifyImagePresent(String expectedImage, String imageElement)
	                                      checkChildElements(String controlName,String childElement),checkText(String controlName,String childElement,String expectedFileName)
	  Purpose of Method                 : Verify if the user is able to view Data Privacy Policy page in webpage
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/
	
	@Test(description="Verify if the user is able to view Data Privacy Policy page in webpage",groups="Investors")
	public void testInvestorsCorporateGovernanceDataPrivacyPolicy() 
	{
		//Launching the Investors Avaya website
		getDriver().get(appConfig.getInvUrl());
		dynamicWait.get().waittillpageloads();
		//Click on Data Privacy Policy
		businessFunction.get().clickAndVerifyNavigation("Investors_DataPrivacyPolicy", "Investors_CorporateGovernance_Title");
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		//To check the presence of Hero Image in Data Privacy Policy web page
		businessFunction.get().imageValidation("Investors_DataPrivacyPolicy_Image");
		//To check the presence of text description in Data Privacy Policy  web page
		businessFunction.get().contentValidation("Investors_DataPrivacyPolicy_Description");
//		businessFunction.get().checkText("Investors_DataPrivacyPolicy_Description", "Tag_Unorderedlist","InvestorsDataPrivacyPolicyUl.txt");
//		businessFunction.get().checkText("Investors_DataPrivacyPolicy_Description", "Tag_Paragraphs","InvestorsDataPrivacyPolicyParagraphs.txt");
		//To check the presence of links in Data Privacy Policy  web page
//		businessFunction.get().verifyMenuOrCategoryLinks("Investors_DataPrivacyPolicy_Links");
//		businessFunction.get().verifySubMenuElements("Investors_DataPrivacyPolicy_Links", "Tag_Anchors",",");						
	} 
	
	/** 
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 05/08/2014
	  Date of Modified                  : --
	  Methods Called                    : checkUrl(String controlName),isTextPresent(String controlName) ,checkCssProperty(String controlName, String cssProperty) 
	                                      clickAndVerifyNavigation(String navigatetopage,String pageTitle)
	  Purpose of Method                 : Verify if the user is able to View Leadership page in Investors Avaya Webpage
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/
	
	@Test(description="Verify if the user is able to View Leadership page in Webpage",groups="Investors")
	public void testInvestorsLeadershipPage() 
	{
		//Launching the Investors Avaya website
		getDriver().get(appConfig.getInvUrl());
		dynamicWait.get().waittillpageloads();
		//To check if Investors home page is be displayed
		verify.get().isTextPresent("Investors_Title");
		verify.get().isElementDisplayed("Investors_Leadership");
		//To click on Corporate Governance tab
		userActions.get().clickOn("Investors_CorporateGovernanceSection");
		//To check if Corporate Governance tab is collapsed.
		businessFunction.get().checkCssProperty("Investors_CorporateGovernanceDisplay", "display");
		//To click on Corporate Governance tab
		userActions.get().clickOn("Investors_CorporateGovernanceSection");
		//To check if Corporate Governance tab is expanded.
		businessFunction.get().checkCssProperty("Investors_CorporateGovernanceLinks", "display");
					
	}
	
	/**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 22/07/2014
	  Date of Modified                  : 16-09-2014
	  Methods Called                    : clickAndVerifyNavigation(String navigatetopage,String pageTitle),clickOn(String controlName),deFocus() 
	                                      sendinputdata(String controlName, String option, String searchControlName),isTextPresent(String controlName) 
	                                      checkChildElements(String controlName,String childElement,String delimiter),isElementDisplayed(String controlName)
	  Purpose of Method                 : Verify the options present under Unified Communications tab which is present in the left menu
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/

	@Test(description="Verify if the user is able to subscribe to the Magazine",groups="Perspectives")
	public void testPerspectivesSubscribe()
	{
	    //Launching the Avaya Website
	    getDriver().get(appConfig.getAppUrl());
	    dynamicWait.get().waittillpageloads();
	    //To click on Perspective tab from megamenu
	    businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "Perspectives_SubMenu", "PerspectivesTitlePage");
	    dynamicWait.get().waittillpageloads();
	    businessFunction.get().deFocus();
	    //To click on "Subscribe" Button
	    userActions.get().clickOn("PerspectivesLanding_Subscribe");
	    //To check if drop down is displayed with fields like First Name, Last Name etc
	    businessFunction.get().verifySubMenuElements("PerspectivesLanding_Subscribe_Parent", "Child_Label_Items",",");
	    //To check the presence of text boxes and drop down  in the page
	    verify.get().isElementDisplayed("Subscribe_FirstName");
	    verify.get().isElementDisplayed("Subscribe_LastName");
	    verify.get().isElementDisplayed("Subscribe_EmailAddress");
		verify.get().isElementDisplayed("Subscribe_Company");
		verify.get().isElementDisplayed("Subscribe_CountryName");
		verify.get().isElementDisplayed("Subscribe_BusinessSize");
		//To enter the data in the fields
		businessFunction.get().sendinputdata("subscriptioninputdata", "subscription","none");
		//To click on submit button
		userActions.get().clickOn("PerspectivesLanding_Subscribe_Submit");
		dynamicWait.get().waittillpageloads();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//To check if Magazines page is displayed.
		businessFunction.get().checkUrl("PerspectivesLanding_Subscribe_Magazine", "contains");
	}

	/**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 05/08/2014
	  Date of Modified                  : --
	  Methods Called                    : clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle),checkUrl(String controlName),clickOn(String controlName) 
	  Purpose of Method                 : Verify the pretty Url for Services Detail page.
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/ 

	@Test(description="Verify the pretty Url for Services Detail page",groups="Services")
	public void testBRFServicesDetailPage() 
	{
	  	//Launching the Avaya Website
	  	getDriver().get(appConfig.getAppUrl());
	  	dynamicWait.get().waittillpageloads();
	  	//Click on any one of the items from Services sub menu.
	  	businessFunction.get().clickOnSubMenuItem("Services", "Services_CommunicationsOutsourcingSolutions", "CommunicationsOutsourcingSolutions_Title");
	  	dynamicWait.get().waittillpageloads();
	  	businessFunction.get().deFocus();
	  	//To check the url of the Service detail page
	  	businessFunction.get().checkUrl("CommunicationsOutsourcingSolutions_Url","contains");
	  	//To click on Case Studies tab
	  	businessFunction.get().deFocus();
	  	userActions.get().clickOn("Services_CaseStudies_tab");
	  	//To check the url of the Service detail-Case Studies page
	  	businessFunction.get().checkUrl("CaseStudies_Url","contains");
	  	//To click on Resources tab
	  	businessFunction.get().deFocus();
	  	userActions.get().clickOn("DocumentandVideos_tab");
	  	//To check the url of the Service detail-Resources page
	  	businessFunction.get().checkUrl("DocumentandVideos_Url","contains");
	  	//To click on Service Details tab
	  	businessFunction.get().deFocus();
	  	userActions.get().clickOn("ServiceDetails");
	  	//To check the url of the Service detail-Service Details page
	  	businessFunction.get().checkUrl("ServiceDetails_Url","contains");
	  	//To click on Overview tab
	  	businessFunction.get().deFocus();
	  	userActions.get().clickOn("Overview_Tab");
	  	//To check the url of the Service detail-Ovreview page
	  	businessFunction.get().checkUrl("Overview_Url","contains");
	}

	/**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 05/08/2014
	  Date of Modified                  : --
	  Methods Called                    : isTextPresent(String controlName),checkUrl(String controlName) ,verifyImagePresent(String expectedImage, String imageElement) 
	  Purpose of Method                 : Verify the functionality of HP Marquee Call Out
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/

	@Test(description="Verify the functionality of HP Marquee Call Out",groups="Home Page")
	public void testHomePageHPMarqueeCallOut() 
	{
		//Launching the Avaya Website
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		//To click on the 5th Indicator button
		userActions.get().clickOn("HomePage_5thIndicator");
		//To check if 5th image is displayed
		businessFunction.get().imageValidation("HomePage_5thImage");
		dynamicWait.get().waittillpageloads();
		//To click on the 5th Indicator button
		userActions.get().clickOn("HomePage_5thIndicator");
		//To check the presence of Heading in the call out
		businessFunction.get().contentValidation("HomePage_5thImage_Heading");
		//To check the presence of Description in the call out
		businessFunction.get().contentValidation("HomePage_5thImage_Description");
		//To check the presence of Learn More CTA in the call out
		verify.get().isTextPresent("HomePage_5thImage_CTA");
		//To click on Learn More CTA
		
		userActions.get().clickOn("HomePage_5thImage_CTA");
		dynamicWait.get().waittillpageloads();
		//To check if system is navigated to "/usa/solution/network-virtualization" url
		businessFunction.get().checkUrl("HomePage_5thImage_Url","contains");
	}
	
	/**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 05/08/2014
	  Date of Modified                  : --
	  Methods Called                    : checkChildElements(String controlName,String childElement),pageAllignment(String relativeControlName, String controlName, String position)
	                                      isTextPresent(String controlName),checkSelectedTabActive(String controlName, String childElement,String str_selectedtabname),checkCaseStudiesDetails(String controlName)
	  Purpose of Method                 : Verify the details present in the Case Studies Landing Page
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/

	@Test(description="Verify the details present in the Case Studies Landing Page",groups="Case Studies page")
	public void testCaseStudiesLandingPageAll() 
	{
	    //Launching the Case Studies Landing page 
		getDriver().get(appConfig.getCaseStudiesUrl());
		dynamicWait.get().waittillpageloads();
		//To check if Case studies Landing page is displayed.
		verify.get().isTextPresent("CaseStudies_Title");
		//To verify if the sub navigation menu is present below title
		businessFunction.get().pageAllignment("CaseStudies_Title", "CaseStudies_SubNavigationMenu", "above");
		//To verify if the sub navigation menu has tabs
		businessFunction.get().verifySubMenuElements("CaseStudies_Tabs_Parent", "Tag_List",",");
		//To click on All tab
		userActions.get().clickOn("CaseStudies_All");
		//To check if all case studies are displayed
		businessFunction.get().checkCaseStudiesDetails("CaseStudies_Details");
		//To check whether the All tab is selected
		businessFunction.get().checkSelectedTabActive("CaseStudies_SubMenu_Parent", "Tag_List", "ALL");		
	}
	
	/**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 05/08/2014
	  Date of Modified                  : --
	  Methods Called                    : clickOn(String controlName),clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle),checkUrl(String controlName)
	  Purpose of Method                 : Verify if the user is able to view Avaya Blogs page
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/

	@Test(description="Verify if the user is able to view Avaya Blogs page",groups="About Avaya-Newsroom")
	public void testNewsroomAvayaBlogs() 
	{
	    //Launching the Avaya Website
	    getDriver().get(appConfig.getAppUrl());
	    dynamicWait.get().waittillpageloads();
	    //To hover on About Avaya tab and click on NewsRoom link
	    businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "AboutAvaya_NewsRoom", "Newsroom_Title");
	    dynamicWait.get().waittillpageloads();
	    businessFunction.get().deFocus();
	    //To click on Avaya Blog icon 
	    userActions.get().clickOn("NewsRoom_AvayaBlog");
	    userActions.get().switchToChildWindow();
	    dynamicWait.get().waittillpageloads();
	    //To check if navigated to Avaya Blogs page
	    businessFunction.get().checkUrl("AvayaBlog_Url","equal");	
	}
	
	/**
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 05/08/2014
	  Date of Modified                  : --
	  Methods Called                    : isTextPresent(String controlName),isElementDisplayed(String controlName),checkElementPosition(String relativeControlName,String controlName)
	  Purpose of Method                 : Verify if the chat icon is present in the CaseStudies Landing page
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/

	@Test(description="Verify if the chat icon is present in the CaseStudies Landing page",groups="About Avaya -Case Studies page")
	public void testCaseforAvayaLandingPageChatIcon()
	{
		//Launching the Case Studies Landing page 
	    getDriver().get(appConfig.getCaseStudiesUrl());
	    dynamicWait.get().waittillpageloads();
	    //To check if Case studies Landing page is displayed.
	    verify.get().isTextPresent("CaseStudies_Title");
		//To check if chat icon is displayed
		verify.get().isElementNotDisplayed("CaseStudies_ChatIcon");
	    
	}
	
	/**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 05-08-2014
	  Date of Modified                  : --
	  Methods Called                    : clickAndVerifyNavigation(String navigatetopage,String pageTitle),checkImageButton(String controlName, String cssAttribute,String controlNameText, String controlNameImage),
	  									  checkChildElements(String controlName,String childElement,String delimiter),pageAllignment(String relativeControlName, String controlName, String position)
	  									  isElementDisplayed(String controlName),verifyIcons(String controlName, String expectedImage)
	  Purpose of Method                 : Verify the Industry Vertical Landing Page
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	  **/
	
	@Test(description="Verify the Industry Vertical Landing Page",groups="Solutions")
	public void testCapabilitiesIndustryVertical()
	{
        //Launching the Avaya Website
        getDriver().get(appConfig.getAppUrl());
        //To click on Capabilities tab
        businessFunction.get().clickAndVerifyNavigation("Solutions", "Solutions_Title");
        businessFunction.get().deFocus();
        //To click on Explore Industry Vertical CTA
        businessFunction.get().clickAndVerifyNavigation("Explore_Industry_Vertical", "Explore_Industry_Vertical_Header");
        //To verify the Buy It CTA
        verify.get().isTextPresent("Capabilities_BuyItImage");
        businessFunction.get().verifyMenuOrCategoryLinks("Capabilities_BuyItImage");
        //To verify Overview tab in the Navigation pane.
        businessFunction.get().verifySubMenuElements("Industry_Vertical_Parent_Pane", "Tag_List",",");
        //To verify whether the promotional pods are displayed or not
        businessFunction.get().imageValidation("Industry_Vertical_PodsImages");
        verify.get().isElementDisplayed("Industry_Vertical_Pods");
        verify.get().isTextPresent("Industry_Vertical_Banking");
        verify.get().isTextPresent("Industry_Vertical_Insurance");
        verify.get().isTextPresent("Industry_Vertical_Hotels_Lodging");
        verify.get().isTextPresent("Industry_Vertical_Healthcare");
        verify.get().isTextPresent("Industry_Vertical_Education");
        verify.get().isTextPresent("Industry_Vertical_State_Local_Government");
        verify.get().isTextPresent("Industry_Vertical_Federal_Government");
        verify.get().isTextPresent("Industry_Vertical_K-12 Education");

	}
	
	/**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 05-08-2014
	  Date of Modified                  : --
	  Methods Called                    : isTextPresent(String controlName),clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle),
	  									  checkChildElements(String controlName,String childElement,String delimiter),
	  									  verifyIcons(String controlName, String expectedImage),
	  Purpose of Method                 : Verify if the user is able to navigate to Capabilities Detail Page
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	  **/
	
	@Test(description="Verify if the user is able to navigate to Capabilities Detail Page",groups="Solutions")
	public void testCapabilitiesDetailPage()
	{
		 //Launching the Avaya Website
        getDriver().get(appConfig.getAppUrl());
        //To click on the submenu Network Virtualization from the Solutions tab and to verify the header
        businessFunction.get().clickOnSubMenuItem("Solutions", "Network_Virtualization", "Network_Virtualization_Header");
        //To verify the one line description about Network Virtualization
        businessFunction.get().contentValidation("Network_Virtualization_Oneline_Description");
        //To verify the presence of four tabs with their respective names
        businessFunction.get().verifySubMenuElements("Parent_Mega_Navigation_Pane", "Tag_List",",");
        //To verify the presence of the 'Buy It' image button 
        verify.get().verifyIcons("Capabilities_BuyItImageButton", "BuyIt.JPG");
        verify.get().isTextPresent("Capabilities_BuyItImage");
        businessFunction.get().verifyMenuOrCategoryLinks("Capabilities_BuyItImage");

		
	}
	
	/**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 05-08-2014
	  Date of Modified                  : --
	  Methods Called                    : clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle),
	  									  checkSelectedTabActive(String controlName, String childElement,String str_selectedtabname)
	  									  checkChildWindow(String controlName) 
	  Purpose of Method                 : Verify if the user is able to Filter the Results on the Resources Page
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	  **/
	
	@Test(description="Verify if the user is able to view the Resource Article",groups="Services")
	public void testServiceDetailsResourcesViewArticle()
	{
		//Launching the Avaya Website
		getDriver().get(appConfig.getAppUrl());
		//To click on the Contact Center Optimization from the Services tab
		businessFunction.get().clickOnSubMenuItem("Services", "ContactCenterOptimization", "ContactCenterOptimization_Title");
		businessFunction.get().deFocus();
		//To check whether the Overview tab has been selected or not 
		businessFunction.get().checkSelectedTabActive("Services_CCO_Parent_Tab", "Tag_List", "OVERVIEW");
		//To click on the Resources tab
		userActions.get().clickOn("DocumentandVideos_tab");
	    dynamicWait.get().waittillpageloads();
		//userActions.get().clickOn("ServiceDetails_Resources_EnhancingCustomer");
		businessFunction.get().verifyPdfUrl("ServiceDetails_Resources_EnhancingCustomer");
		
	}
	
	
	 /** 
	  Author Name                       : Vinusha
	  Date of Preparation               : 06/08/2014
	  Date of Modified                  : --
	  Methods Called                    : clickOnSubMenuItem(businessfunction), clickOn(UserActipns),verifyImagePresent,isTextPresent(Verify)
	  Purpose of Method                 : Verify the content in Promotions for Unified Communications page
	  Dependencies	                    : --
	  Reviewed By                       : --
	  Image							    : YES
	  Test Case Name					:  wi01173950_Promotions & Programs_Promotions for Unified Communications_Content
	  **/
	  
	  @Test(description="Verify the content in Promotions for Unified Communications page",groups="Promotions & Programs")
	  public void testPromotionsUnifiedComm()
	  {
		  	// Launching the Avaya URL
	    	getDriver().get(appConfig.getAppUrl());
	    	dynamicWait.get().waittillpageloads();     	
	    	//Hovering on Quick Links and click on Promotions and Programs link and verifying the heading		
	    	businessFunction.get().clickOnSubMenuItem("AvayaQuickLinks", "AvayaPromotionsPrograms", "PromotionsProgramsHeading");
	    	//Clicking on Promotions For Networking
	    	userActions.get().clickOn("AvayaPromotionsForUnifiedComm");
	    	dynamicWait.get().waittillpageloads();  
	    	//Verifying the Networking Heading
	    	verify.get().isTextPresent("AvayaUnifiedCommunications");
	    	//Verifying the Find A Partner Text
	    	verify.get().isTextPresent("AvayaPromotionsFindAPartner");
	    	businessFunction.get().verifyMenuOrCategoryLinks("AvayaPromotionsFindAPartner");
	    	//Verifying the UnifiedCommunications Text
	    	businessFunction.get().contentValidation("AvayaUnifiedCommText"); 
	    	//Verify Colloborate Now Text
	    	verify.get().isTextPresent("AvayaColloborateNow");
	    	// Verify the Colloboration text
	    	businessFunction.get().contentValidation("AvayaColloborateText");
	    	//Verify the Colloborate LearnMore text
	    	verify.get().isTextPresent("AvayaColloborateLearnMore");
	    	businessFunction.get().verifyMenuOrCategoryLinks("AvayaColloborateLearnMore");
	    	//Verify SoftwareInvestment Text
	    	verify.get().isTextPresent("AvayaSoftwareInvestment");
	    	//Verify SoftwareInvestment Content Text
	    	businessFunction.get().contentValidation("AvayaSoftwareInvestmentText");
	    	//Verify SoftwareInvestment LearnMore Text
	    	verify.get().isTextPresent("AvayaSoftwareInvestmentLearnMore");
	    	businessFunction.get().verifyMenuOrCategoryLinks("AvayaSoftwareInvestmentLearnMore");   	
	    	//Verify Colloboration Pack Text
	    	verify.get().isTextPresent("AvayaColloborationPack");
	    	//Verify Colloboration Content Text
	    	businessFunction.get().contentValidation("AvayaColloborationPackText");
	    	//Verify ColloborationPack LearnMore Text
	    	verify.get().isTextPresent("AvayaColloborationPackLearnMore");
	    	businessFunction.get().verifyMenuOrCategoryLinks("AvayaColloborationPackLearnMore");    	
	    	//Verifying the Image in Unified Communications page
	    	businessFunction.get().imageValidation("AvayaUnifiedCommunicationsImage");    	
	  }
	  
	  /** 
	  Author Name                       : Niharika
	  Date of Preparation               : 06/08/2014
	  Date of Modified                  : --
	  Methods Called                    : clickOnSubMenuItem(businessfunction), clickOn(UserActipns),verifyImagePresent,isTextPresent(Verify)
	  Purpose of Method                 : Verify the content in Collaborate Now page
	  Dependencies	                    : --
	  Reviewed By                       : --
	  Image							    : YES
	  Test Case Name					:  wi01173950_Promotions & Programs_Promotions for Unified Communications_Collaborate Now_Content
	  **/
	  
	  @Test(description="Verify the content in Collaborate Now page",groups="Promotions & Programs")
	  public void testPromotionsUnifiedCommColloborate()
	  {
		// Launching the Avaya URL
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		// Hovering on Quick Links and click on Promotions and Programs link and
		// verifying the heading
		businessFunction.get().clickOnSubMenuItem("AvayaQuickLinks",
				"AvayaPromotionsPrograms", "PromotionsProgramsHeading");
		// Clicking on Promotions For Networking
		userActions.get().clickOn("AvayaPromotionsForUnifiedComm");
		dynamicWait.get().waittillpageloads();
		// Verifying the Networking Heading
		verify.get().isTextPresent("AvayaUnifiedCommunications");
		// Clicking on Colloborate Learn More link
		userActions.get().clickOn("AvayaColloborateLearnMore");
		dynamicWait.get().waittillpageloads();
		// Verify the Colloborate LearnMore text
		verify.get().isTextPresent("AvayaUnifiedCommColloborateLearnMore");
		// Verifying the Find A Partner Text
		verify.get().isTextPresent("AvayaPromotionsFindAPartner");
		businessFunction.get().verifyMenuOrCategoryLinks(
				"AvayaPromotionsFindAPartner");
		// Verifying the AvayaUnifiedCommLearnMoreRelated1 Text
		businessFunction.get().contentValidation(
				"AvayaUnifiedCommLearnMoreRelated1");
		// Verifying the AvayaUnifiedCommLearnMorePod1 Text
		businessFunction.get().contentValidation(
				"AvayaUnifiedCommLearnMorePod1");
		// Verifying the AvayaUnifiedCommLearnMorePod2 Text
		businessFunction.get().contentValidation(
				"AvayaUnifiedCommLearnMorePod2");
		// Verifying the AvayaUnifiedCommLearnMorePod3 Text
		businessFunction.get().contentValidation(
				"AvayaUnifiedCommLearnMorePod3");
		// Verifying the AvayaUnifiedCommLearnMorePod4 Text
		businessFunction.get().contentValidation(
				"AvayaUnifiedCommLearnMorePod4");
		// Verifying the Image in Unified Communications page
		businessFunction.get().imageValidation(
				"AvayaUnifiedCommunicationsLearnMoreImage");     	
	  }
	  
	  /** 
	  Author Name                       : Sindhuja
	  Date of Preparation               : 06/08/2014
	  Date of Modified                  : --
	  Methods Called                    : clickOnSubMenuItem(businessfunction), clickOn(UserActipns),verifyImagePresent,isTextPresent(Verify)
	  Purpose of Method                 : Verify the pods in Collaborate Now page
	  Dependencies	                  : --
	  Reviewed By                       : --
	  Test Case Name					  :  wi01173950_Promotions & Programs_Promotions for Unified Communications_Collaborate Now_Content_Pods
	   
	  **/
	  
	  @Test(description="Verify the pods in Collaborate Now page",groups="Promotions & Programs")
	  public void testPromotionsUnifiedCommPods() 
	  {
			// Launching the Avaya URL
	    	getDriver().get(appConfig.getAppUrl());
	    	dynamicWait.get().waittillpageloads(); 
	    	//Navigate to footer section and hover the mouse on Quick links tab
		  	userActions.get().hoverOn("Home_QuickLinks");
	    	//verify the links under quick links flyout
//	    	businessFunction.get().verifyLatestNewsFooter("Footer_Quicklinks_ParentElement", "Tag_Anchors", "HoverYes","expectedQuickLinks");
		  	businessFunction.get().verifyMenuOrCategoryLinks("QuickLinks_ChildElements");
	    	//Hovering on Quick Links and click on Promotions and Programs link and verifying the heading		
	    	businessFunction.get().clickOnSubMenuItem("AvayaQuickLinks", "AvayaPromotionsPrograms", "PromotionsProgramsHeading");
	    	//Clicking on Promotions For Networking
	    	userActions.get().clickOn("AvayaPromotionsForUnifiedComm");
	    	dynamicWait.get().waittillpageloads();  
	    	//Verifying the Networking Heading
	    	verify.get().isTextPresent("AvayaUnifiedCommunications");
	    	//Clicking on Colloborate Learn More link
	    	userActions.get().clickOn("AvayaColloborateLearnMore");
	    	dynamicWait.get().waittillpageloads(); 
	    	//Verify the Colloborate LearnMore text
	    	verify.get().isTextPresent("AvayaUnifiedCommColloborateLearnMore");    	
	    	//Verifying the AvayaUnifiedCommLearnMorePod1 Text
	    	businessFunction.get().contentValidation("AvayaUnifiedCommLearnMorePod1");
	    	//Verifying the AvayaUnifiedCommLearnMorePod2 Text
	    	businessFunction.get().contentValidation("AvayaUnifiedCommLearnMorePod2");
	    	//Verifying the AvayaUnifiedCommLearnMorePod3 Text
	    	businessFunction.get().contentValidation("AvayaUnifiedCommLearnMorePod3");
	    	//Verifying the AvayaUnifiedCommLearnMorePod4 Text
	    	businessFunction.get().contentValidation("AvayaUnifiedCommLearnMorePod4");  
	    	//Verifying the AvayaUnifiedCommLearnMorePodLink1 Text
	    	verify.get().isTextPresent("AvayaUnifiedCommLearnMorePodLink1");
	    	businessFunction.get().verifyMenuOrCategoryLinks("AvayaUnifiedCommLearnMorePodLink1");
	    	//Verifying the AvayaUnifiedCommLearnMorePod2 Text
	    	verify.get().isTextPresent("AvayaUnifiedCommLearnMorePodLink3");
	    	businessFunction.get().verifyMenuOrCategoryLinks("AvayaUnifiedCommLearnMorePodLink3");    	
	    	//Verifying the AvayaUnifiedCommLearnMorePod3 Text
	    	verify.get().isTextPresent("AvayaUnifiedCommLearnMorePodLink3");
	    	businessFunction.get().verifyMenuOrCategoryLinks("AvayaUnifiedCommLearnMorePodLink3");
	    	//Verifying the AvayaUnifiedCommLearnMorePodLink4 Text
	    	verify.get().isTextPresent("AvayaUnifiedCommLearnMorePodLink4");     	    	 	    	    	
	    	businessFunction.get().verifyMenuOrCategoryLinks("AvayaUnifiedCommLearnMorePodLink4");    	    	 	    	    	
	  	
	  }
	  
	  /** 
	  Author Name                       : Phanendra
	  Date of Preparation               : 06/08/2014
	  Date of Modified                  : --
	  Methods Called                    : clickOnSubMenuItem(businessfunction), clickOn(UserActipns),verifyImagePresent,isTextPresent(Verify)
	  Purpose of Method                 : Verify the content in Collaboration Pack for CS 1000 page
	  Dependencies	                    : --
	  Reviewed By                       : --
	  Image							    : YES
	  Test Case Name					:  wi01173950_Promotions & Programs_Promotions for Unified Communications_Collaboration Pack for CS 1000_Content
	  **/
	  
	  @Test(description="Verify the content in Collaboration Pack for CS 1000 page",groups="Promotions & Programs")
	  public void testPromotionsCS1000Content()
	  {
		// Launching the Avaya URL
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		// Hovering on Quick Links and click on Promotions and Programs link and
		// verifying the heading
		businessFunction.get().clickOnSubMenuItem("AvayaQuickLinks",
				"AvayaPromotionsPrograms", "PromotionsProgramsHeading");
		// Clicking on Promotions For Networking
		userActions.get().clickOn("AvayaPromotionsForUnifiedComm");
		dynamicWait.get().waittillpageloads();
		// Verifying the Networking Heading
		verify.get().isTextPresent("AvayaUnifiedCommunications");
		// Clicking on LearnMore of Collaboration Pack
		userActions.get().clickOn("AvayaColloborationPackLearnMore");
		dynamicWait.get().waittillpageloads();
		// Verifying the Collaboration pack CS 1000 heading
		verify.get().isTextPresent("AvayaCollaborationPackforCS1000Head");
		// Verifying the Find A Partner Text
		verify.get().isTextPresent("AvayaPromotionsFindAPartner");
		businessFunction.get().contentValidation("AvayaPromotionsFindAPartner");
		// Verifying the Image in Collaboration pack cs 1000
		businessFunction.get().imageValidation(
				"AvayaUnifiedCommunicationsLearnMoreImage");
		// verifying the presence of BreadCrumb using the business function
		// verifyBreadCrumb
		businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual",
				"AvayaCollaborationPackBreadcrumb", "Tag_Anchors");
	  }

	  /**
	  Author Name                       : Phanendra
	  Date of Preparation               : 06/08/2014
	  Date of Modified                  : --
	  Methods Called                    : pageAllignment(String relativeControlName, String controlName, String position),checkImageButton(String controlName, String cssAttribute,String controlNameText, String controlNameImage)
	                                      isElementDisplayed(String controlName),clickAndVerifyNavigation(String navigatetopage,String pageTitle)
	  Purpose of Method                 : Verify the Capabilties Landing Page 2
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/
	  @Test(description="Verify the Capabilties Landing Page 2",groups="Solutions")
		public void testCapabiltiesLandingPage2MidMarketing() 
		{

          //Launching the Avaya Website
          getDriver().get(appConfig.getAppUrl());
          //To click on Solutions tab 
          businessFunction.get().clickAndVerifyNavigation("Solutions", "Solutions_Title");
          dynamicWait.get().waittillpageloads();
          businessFunction.get().deFocus();
          //To click on "Explore Midmarket Business"  CTA
          businessFunction.get().clickAndVerifyNavigation("Explore_Midmarket_Business", "Explore_Midmarket_Business_Title");
          //To check the presence of "Buy It"Drop Down
          verify.get().verifyIcons("Solutions_BuyItImage", "BuyIt.JPG");
          //To check the presence of Overview in navigation page
          businessFunction.get().verifySubMenuElements("Explore_Midmarket_Parent_Pane", "Tag_List",",");
          //To check the presence of Hero Image with description beside it
          businessFunction.get().imageValidation("Explore_Midmarket_Image");
          businessFunction.get().contentValidation("Explore_Midmarket_Description");
          //To verify whether the promotional pods are displayed or not
          verify.get().isElementDisplayed("ExploreMidmarket_PromoPods");
          verify.get().isTextPresent("ExploreMidmarket_ContactCenterHeader");
          verify.get().isTextPresent("ExploreMidmarket_VideoforMidmarketHeader");
          verify.get().isTextPresent("ExploreMidmarket_NetworkingforMidmarketHeader");
          verify.get().isTextPresent("ExploreMidmarket_SecurityforMidmarketHeader"); 
	
		}
		
	
	/**
	  Author Name                       : Phanendra 
	  Date of Preparation               : 06-08-2014
	  Date of Modified                  : --
	  Methods Called                    : verifyAlertText(String expectedValue),isTextPresent(String controlName)
	  Purpose of Method                 : Verify the Search box functionality when single character is given in the GSA search page
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	  **/
	
	@Test(description="Verify the Search box functionality when single character is given in the GSA search page",groups="GSA Search page")
	public void testGSAPageSingleCharacter()
	{
		// Launching the Avaya Website
		getDriver().get(appConfig.getAppUrl());
		businessFunction.get().deFocus();
		// To eneter a single character in the search box of home page
		userActions.get().enterText("AvayaHome_SearchBox", "Avaya");
		// To click on the search button
		userActions.get().clickOn("Search_Button_Test");
		// To check if user is able to view Global results Page
		verify.get().isTextPresent("ResultsPage_Title");
		// To clear the search box
		userActions.get().clearTextBox("GSAResultsSearchBox");
		businessFunction.get().deFocus();
		userActions.get().enterText("GSAResultsSearchBox", "a");
		businessFunction.get().deFocus();
		// To click on the search button
		userActions.get().clickOn("GSAResultsSearchButton");
		// To verify the message displayed in the alert
		verify.get().verifyAlertText("AlertFailureMessage");
		// To clikck on OK button of alert
		userActions.get().clickAlertOk();
	}
	/** 
	  Author Name                       : Vinusha
	  Date of Preparation               : 06-08-2014
	  Date of Modified                  : --
	  Methods Called                    : clickOn(UserActions),waittillpageloads(DynamicWait),isTextPresent,isElementPresent,verifyImageActive(Verify),clickOnSubMenuItem,verifyMultipleContentType(businessFunction)
	  Purpose of Method                 : Verify the resource tab functionality on the portfolio page
	  Dependencies	                    : --
	  Reviewed By                       : --
	  Test Case Name					:  Operation portfolio page_Resource tab_validation
	  **/
	 @Test(description="Verify the resource tab functionality on the portfolio page",groups="Services")
	    public void testOperationResourceValidation()
	    {
	    	// Launching the Avaya URL
	    	getDriver().get(appConfig.getAppUrl());
	    	dynamicWait.get().waittillpageloads();
	    	//Verify the Avaya Home Page
	    	verify.get().isElementPresent("AboutAvayaHomePage");	
	    	//Clicking on Operations Services which is present in the Services hover screen	
	    	businessFunction.get().clickOnSubMenuItem("Services", "OperationsServices", "OperationsHomePage");
	    	businessFunction.get().deFocus();
	    	//Verifying the Hero image is present in Operations Services Home page or not
	    	businessFunction.get().imageValidation("OperationsHeroImage");    	
	    	//Verifying Operations Service PODs Anchor information
	    	businessFunction.get().verifyPartnerAndProductPods("OperationsServicesPods", "Tag_Anchors");
	    	//Verifying the Explore Operation Services Image
	    	businessFunction.get().imageValidation("ExploreOperationsServiceImage");    	
	    	//Verify the Explore Operations Services Links			
	    	businessFunction.get().verifyMenuOrCategoryLinks("ExploreOperationsServicesLinks");
	    	businessFunction.get().deFocus();
	    	//Clicking on the Resources Tab which is present in the Operations Services page
	    	userActions.get().clickOn("DocumentandVideos_tab");
	    	dynamicWait.get().waittillpageloads();	    
	    	businessFunction.get().deFocus();
	    	//Clicking on the White Papers checkbox and verifying all the White Papers are displayed in the page or not
	    	userActions.get().clickOn("Resources_WhitePapers");
	    	businessFunction.get().checkSelectedResources("Resources_ResultsArea");	
	    }
	
	  /** 
	  Author Name                       : Phanendra
	  Date of Preparation               : 06/08/2014
	  Date of Modified                  : --
	  Methods Called                    : waittillpageloads(DynamicWait),isTextPresent,verifyImageActive(Verify),clickOnSubMenuItem,verifyMultipleContentType(businessFunction)
	  Purpose of Method                 : Verify the overview tab functionality of the portfolio page
	  Dependencies	                    : --
	  Reviewed By                       : --
	  Test Case Name					:  Operation portfolio page validation
	  **/
	  @Test(description="Verify the overview tab functionality of the portfolio page",groups="Services")
	    public void testOperationPageValidation()
	    {
	    	// Launching the Avaya URL
	    	getDriver().get(appConfig.getAppUrl());
	    	dynamicWait.get().waittillpageloads();
	    	//Verifying the Home page
	    	verify.get().isElementPresent("AboutAvayaHomePage");	
	    	//Clicking on Operations Services which is present in the Services hover screen	
	    	businessFunction.get().clickOnSubMenuItem("Services", "OperationsServices", "OperationsHomePage");
	    	//Verifying the Hero image is present in Operations Services Home page or not
	    	businessFunction.get().imageValidation("OperationsHeroImage");    	
	    	//Verifying Operations Service PODs Anchor information
	    	businessFunction.get().verifyPartnerAndProductPods("OperationsServicesPods", "Tag_Anchors");
	    	//Verifying the Explore Operation Services Image
	    	businessFunction.get().imageValidation("ExploreOperationsServiceImage");    	
	    	//Verify the Explore Operations Services Links			
	    	businessFunction.get().verifyMenuOrCategoryLinks("ExploreOperationsServicesLinks");	
	    							
	    }
	  
	  /** 
	  Author Name                       : Phanendra
	  Date of Preparation               : 06/08/2014
	  Date of Modified                  : --
	  Methods Called                    : clickOn,hoverOn(Utilities),verifyImageActive(Verify)
	  Purpose of Method                 : Verify the mega menu on the legacy pages
	  Dependencies	                    : --
	  Reviewed By                       : --
	  Image 							: YES
	  Test Case name					: Mega menu on Legacy Page
	  **/

	  @Test(description="Verify the mega menu on the legacy pages",groups="Home Page")
	    public void testAbtAvayaNewsRoomImage()
	    {
	    	// Launching the Avaya URL
	    	getDriver().get(appConfig.getAppUrl());
	    	dynamicWait.get().waittillpageloads();
	    	// Clicing on Newsroom link
	    	userActions.get().clickOn("Newsroom"); 
	    	dynamicWait.get().waittillpageloads();
	    	// Hovering on the mega menu and verifying the TOUT image is existing or not
	    	userActions.get().hoverOn("Products");
	    	//Veriyf the Product Tout Image
	    	businessFunction.get().imageValidation("ProductsTOUTImage");    		
	    					
	    }
	  
	  /** 
	  Author Name                       :Pankaj
	  Date of Preparation               : 11/06/2014
	  Date of Modified                  : 02/09/2014
	  Methods Called                    : 
	  Purpose of Method                 : Verify the subscribe (Eloqua form) form validation on the perspective magazine page
	  Dependencies	                   	: --
	  Reviewed By                       : --
	  
	**/
	  @Test(description="Verify the subscribe (Eloqua form) form validation on the perspective magazine page", groups="Perspectives")
		public void testSubscribePageValidation(){
			//navigate to app url
			getDriver().get(appConfig.getAppUrl());
			dynamicWait.get().waittillpageloads();
			businessFunction.get().getValueOfHtmlAttribute("AvayaTitlePage", "title");
			//Click on Perspectives tab in the mega menu. and System should navigate to Magazine Page.
			businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "Perspectives_SubMenu", "PerspectivesTitlePage");
			//Click on Archives link the Magazine pod. and System should navigate to Magazine Page.
		//businessFunction.get().clickAndVerifyNavigation("Archives", "Perspectives_mags_guides_titlepage");
		userActions.get().clickOn("Archives");
			userActions.get().switchToChildWindow();
		verify.get().isTextPresent("Perspectives_mags_guides_titlepage");
		businessFunction.get().deFocus();
			//Click on Subscribe button
			userActions.get().clickOn("Subscribe");
			//send input data from the test data
			businessFunction.get().sendinputdata("subscriptioninputdata", "subscription", "searchinput");
			//Click on Submit button
			userActions.get().clickOn("Submit");
			//System should display Thank You page for a few seconds and then redirect to latest magazine page.
		businessFunction.get().checkUrl("subscriptconfirmation","contains");
			}

		/** 
	  Author Name                       : Pankaj
	  Date of Preparation               : 17/06/2014
	  Date of Modified                  : 10-09-2014
	  Methods Called                    : 
	  Purpose of Method                 : Verify the latest news (Global footer) functionality. Latest  news should automatically rotate.
	  Dependencies	                   	: --
	  Reviewed By                       : --
	  
	**/
	@Test(description = "Verify the latest news (Global footer) functionality. Latest  news should automatically rotate.", groups = "Home Page")
	public void testLatestNewsValidation() {
		// navigate to app url
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		businessFunction.get().getValueOfHtmlAttribute("AvayaTitlePage",
				"title");
		// verify latest news global footer
		businessFunction.get().verifyMenuOrCategoryLinks("Footer_News_Parent");
		businessFunction.get().verifyLatestNewsTicker("Footer_News_Parent");
	}
	
	/** 
	  Author Name                       : Sowmya
	  Date of Preparation               : 06/08/2014
	  Date of Modified                  : 
	  Methods Called                    : clickOn(Utilities),verifyMultipleContentType(businessFunction)
	  Purpose of Method                 : Verify the functionality of Content filters on the product landing page.
	  Dependencies	                  : --
	  Reviewed By                       : --
	  Test Case name					  : Content Filters functionality validation on Product Landing page
	  **/

	@Test(description="Verify the functionality of Content filters on the product landing page.",groups="Products")
    public void testContentFiltersProducts()
    {
    	// Launching the Avaya URL
    	getDriver().get(appConfig.getAppUrl());	
    	dynamicWait.get().waittillpageloads();
    	//Clicking on Products Megamenu
    	userActions.get().clickOn("Products");
    	dynamicWait.get().waittillpageloads();
    	//Check Phones check box and verify the products
    	userActions.get().clickOn("Phones");
    	dynamicWait.get().waittillpageloads();
    	//Verify the Products displayed
    	businessFunction.get().checkSearchCount("Product_SearchResult","Product_SearchCount");
    	userActions.get().clickOn("Phones");
    	dynamicWait.get().waittillpageloads();
    	//Check the Networkig check box and verify the commonproducts
    	userActions.get().clickOn("ProdProductTypeNetworking");
    	dynamicWait.get().waittillpageloads();
    	//Verify the Products displayed
    	businessFunction.get().checkSearchCount("Product_SearchResult","Product_SearchCount");
    	//Uncheck the Phones checkbox
    	userActions.get().clickOn("Products_BusinessSize_Large");
    	dynamicWait.get().waittillpageloads();
    	//Verify the Products displayed
    	businessFunction.get().checkSearchCount("Product_SearchResult","Product_SearchCount");    									
    }   



	  /** 
	  Author Name                       : Phanendra
	  Date of Preparation               : 06/08/2014
	  Date of Modified                  : --
	  Methods Called                    : clickOn(Utilities),waittillpageloads(DynamicWait),verifyImageActive(Verify)
	  Purpose of Method                 : Verify if the User is able to see the Static image in the hero section of desktop and tablet versions in About Avaya landing page
	  Dependencies	                    : --
	  Reviewed By                       : --
	  Image   						    : YES
	  Test Case name					: About Avaya_Landing page_Image
	  **/

	  @Test(description="Verify if the User is able to see the Static image in the hero section of desktop and tablet versions in About Avaya landing page",groups="About Avaya")
	  public void testAbtAvayaLandPageImage()
	  {
		// Launching the Avaya URL
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		// MegaMenuAboutAvaya will be passing from excel sheet
		userActions.get().clickOn("MegaMenuAboutAvaya");
		dynamicWait.get().waittillpageloads();
		// Verifying whether static image is present or not in the Avaya home
		// page.
		//businessFunction.get().imageValidation("AboutAvayaStaticHeroImage");	
		verify.get().verifyCarousal();
	  }
	  
	  /** 
		 Author Name                       : Phanendra Ketavarapu
		 Date of Preparation               : 06/08/2014
		 Date of Modified                  : --
		 Methods Called                    : clickOn(Utilities)
		 Purpose of Method                 : Verifies the latest news pod in about avaya page
		 Dependencies	                   : --
		 Reviewed By                       : Vinusha
		 **/
		@Test(description="About Avaya_Landing page_Latest News Pod",groups="About Avaya")
		public void testLatestNewsPod() 
		{
		// Launch the avaya website
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		// Click on About avaya link from megamenu
		userActions.get().clickOn("MegaMenuAboutAvaya");
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		// verify the latest news pod
		businessFunction.get().verifyLatestNewsPod("Latest_News");
		// Verify the presence of view Avaya News Room
		verify.get().isTextPresent("ViewAvayaNewsRoom_Link");
		businessFunction.get().verifyMenuOrCategoryLinks(
				"ViewAvayaNewsRoom_Link");
		}
	
	/** 
	 Author Name                       : Phanendra Ketavarapu
	 Date of Preparation               : 06/08/2014
	 Date of Modified                  : --
	 Methods Called                    : clickOn(Utilities)
	 Purpose of Method                 : Verifies the latest news pod in about avaya page
	 Dependencies	                   : --
	 Reviewed By                       : Vinusha
	 **/

	@Test(description="About Avaya_Landing page_Latest News Pod_Links of Different News",groups="About Avaya")
	public void testNavigateToLatestNews() 
	{
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		//Click on About avaya link from megamenu
		userActions.get().clickOn("MegaMenuAboutAvaya");
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		//Click on the latest news link
		businessFunction.get().verifyLatestNewsPod("Latest_News");
		businessFunction.get().verifyPodLinksNaviagtion("Latest_News","NewsArticleTitle");
	}

/** 
Author Name                       : Phanendra
Date of Preparation               : 06/08/2014
Date of Modified                  : --
Methods Called                    : 
Purpose of Method                 : Verify the archival of Avaya Magazine
Dependencies	                   	: --
Reviewed By                       : --
* @throws Exception 

**/
	@Test(description="Verify the archival of Avaya Magazine", groups="Perspectives")
	public void testPerspectiveAvayaMagArchive(){
		
		//naviagate to app URL
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		businessFunction.get().getValueOfHtmlAttribute("AvayaTitlePage", "title");
		//Click on Perspectives tab in the mega menu. and System should navigate to Magazine Page.
		businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "Perspectives_SubMenu", "PerspectivesTitlePage");
		//click on archive link and verify title
		businessFunction.get().clickAndVerifyNavigation("Archives", "PerspectivesTitlePage");
		userActions.get().switchToChildWindow();
		//verify mag archive url
		businessFunction.get().checkUrl("magazine_archive_url","contains");
		}

   /** 
    Author Name                       : Phanendra
    Date of Preparation               : 06/08/2014
    Date of Modified                  : --
    Methods Called                    :  
    Purpose of Method                 : Verify the page navigation for Cloud under the Perspectives tab of mega menu 
    Dependencies	                  : -- 
    Reviewed By                       : -- 
   **/
	@Test(description="Verify the page navigation for Cloud under the Perspectives tab of mega menu", groups="Perspectives")
	public void testPerspectivesCloudNavigation(){
		//navigate to app URL
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		//Click on Cloud and System should display Cloud page with all the articles tagged to it.
		businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "Cloudsubmenu", "cloudtitle");
		businessFunction.get().deFocus();
		businessFunction.get().contentValidation("article_parent");
	}
     /** 

	/** 
	  Author Name                       : Phanendra
	  Date of Preparation               : 06/08/2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify content of the magazines landing page
	  Dependencies	                   	: --
	  Reviewed By                       : --
	  @throws Exception 
	**/
	@Test(description="Verify content of the magazines landing page", groups="Perspectives")
	public void testPerspectivesMagazineLandingPage(){
		//navigate to app url
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		//Click on 'Perspectives' tab of mega menu and System should navigate to Perspectives 
		businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "Perspectives_SubMenu", "PerspectivesTitlePage");
		dynamicWait.get().waittillpageloads();
		//Click on Magazines and guides under additional links present in perspectives landing page and Magazines and guides Landing page is displayed
	businessFunction.get().clickAndVerifyNavigation("Perspectives_addl_links_mags_guides", "PerspecMagazineGuidesHeading");
	//Verify the content in Magazine page
	businessFunction.get().verifyPerspectiveMagazinePage("Perspectives_Magazines_Pagination_Parent");
}
	
	/** 
	  Author Name                       : Sindhuja
	  Date of Preparation               : 06/08/2014
	  Date of Modified                  : --
	  Methods Called                    : clickOn,hoverOn,switchToParentWindow,switchToChildWindow(Utilities),waittillpageloads(DynamicWait),isElementPresent(Verify),clickOnSubMenuItem,checkUrl(businessFunction)
	  Purpose of Method                 : Verify if the Url is opened on click of Url link in Url's tab of specific country
	  Dependencies	                  : --
	  Reviewed By                       : --
	  Test Case Name					  :  About Avaya_World Wide Directory_Click on country_Url
	  **/

	  @Test(description="Verify if the Url is opened on click of Url link in Url's tab of specific country",groups="About Avaya")
	public void testAbtAvayaWWWCountryURL() {
		// Launching the Avaya URL
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		// Clicking on Worldwide Directory which is present in the AboutAvaya
		// hover screen
		businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya",
				"AboutAvayaWWDirectory", "AbtAvayaWWDirectoryHomePage");
		// Click on Country link and verify whether the respective page is
		// landing and verify the respective fields information
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		userActions.get().clickOn("AbtAvayaWWDCountryName");
		dynamicWait.get().waittillpageloads();
		// Verify the Country Name
		verify.get().isTextPresent("AbtAvayaWWDCName");
		// Verify the Contact Tab
		businessFunction.get().contentValidation(
				"AbtAvayaWWDContactInformation");
		// Verify the URL tab
		verify.get().isTextPresent("AbtAvayaWWDURLTab");
		// Verify the URL info
		businessFunction.get().contentValidation("AbtAvayaWWDURLInfo");
		// Verify if the link opens in a new window
		verify.get().verifyHttpResponse("AbtAvayaWWDContactURL");
		}
	  
	  /** 
	  Author Name                       : Sivanag
	  Date of Preparation               : 06/08/2014
	  Date of Modified                  : 
	  Methods Called                    : clickOn(Utilities), checkUrl,clickAndVerifyNavigation,verifyMultipleContentType(businessFunction)
	  Purpose of Method                 : Verify the URL of subdirectories of magazines.
	  Dependencies	                  : --
	  Reviewed By                       : --
	  TestCase name					  : wi01147050_Contacts Page
	  **/


	  @Test(description="Verify the URL of subdirectories of magazines.",groups="About Avaya")
	    public void testPerspectivesContactsPage()
	    {
	    	// Launching the Avaya URL
	    	getDriver().get(appConfig.getAppUrl());
	    	dynamicWait.get().waittillpageloads();
	    	// Clicking on Contacts Link which is displayed in the footer
	    	businessFunction.get().clickAndVerifyNavigation("Contacts", "ContactsPage"); 	
	    	dynamicWait.get().waittillpageloads();
	    	//Verifying Contacts Page tabs
	    	businessFunction.get().verifySubMenuElements("PerspecContactsTabs", "Tag_List",",");
	    	//Verifying Contacts Page rightside content class values
	    	businessFunction.get().contentValidation("ContactRightData");
	    	businessFunction.get().verifyMenuOrCategoryLinks("ContactRightData_Links");
	    	//Verifying ContactAvayaSupport link is opening or not and coming back to the main window
	    	String gCurrentURL = getDriver().getCurrentUrl();    	
	    	//Clicking on AvayaSupport
	    	userActions.get().clickOn("ContactAvayaSupport");
	    	dynamicWait.get().waittillpageloads();
	    	//Verifying the Childwindow url
	    	businessFunction.get().checkUrl("ContactAvayaSupport","equal");
	    	getDriver().navigate().to(gCurrentURL);
	    	
	    	//Verifying ContactAvayaSales link is opening or not and coming back to the main window
	    	userActions.get().clickOn("ContactAvayaSales");
	    	dynamicWait.get().waittillpageloads();
	    	//Verifying the Sales url
	    	businessFunction.get().checkUrl("ContactAvayaSales","contains");
	    	getDriver().navigate().to(gCurrentURL);	
	    	
	    	//Verifying FindanAyayaPartner link is opening or not and coming back to the main window
	    	userActions.get().clickOn("FindanAyayaPartner");
	    	dynamicWait.get().waittillpageloads();
	    	//Verifying  the AvayaPartner url
	    	businessFunction.get().checkUrl("FindanAyayaPartner","contains");
	    								
	    }


	  /** 
	  Author Name                       : Phanendra
	  Date of Preparation               : 06/08/2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify the presence of butler bar on home page
	  Dependencies	                   	: --
	  Reviewed By                       : --
	  @throws Exception 
	**/
	@Test(description="Verify the presence of butler bar on home page", groups="Home Page")
	public void testHomepageButlerBar(){
		//navigate to app url
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		//verify butler bar
		verify.get().isElementPresent("ButlerBar");
		//verify width of butler bar is same as mega menu
		businessFunction.get().checkWidth("ButlerBar", "Home_MegaMenu");
		//verify support element is displayed
		verify.get().isElementDisplayed("Home_Support");
		//verify country selectro element is displayed
		verify.get().isElementDisplayed("Home_Country_Selector");
		//verify search input element
		verify.get().isElementDisplayed("GlobalHeaderSearchBox");
		}

	/** 
	  Author Name                       : Niharika
	  Date of Preparation               : 06/08/2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify the links under support
	  Dependencies	                   	: --
	  Reviewed By                       : --
	  @throws Exception 
	 **/
	@Test(description="Verify the links under support", groups="Home Page")
	public void testHomePageButlerBarSupport(){
		//navigate to app url
		//navigate to app url
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		//click on each support link and verify its navigation
		userActions.get().clickOn("Home_Support");
		// userActions.get().hoverOn("HomePageSupportHover");
		businessFunction.get().verifyChildItems("Home_Support_LinkNames", "Home_Support_Links", "Yes");
		//Click on Support Home Link
		userActions.get().clickOn("Home_SupportHome");
		dynamicWait.get().waittillpageloads();
		//Verfiy the Url
		businessFunction.get().checkUrl("Home_SupportHome", "equal");
		//Navigate back to Avaya Site
		getDriver().navigate().back();
		dynamicWait.get().waittillpageloads();
		userActions.get().clickOn("Home_Support");
		//Click on Support Home Link
		userActions.get().clickOn("Home_Support_Bash-ShellshockVulnerabilityInfo");
		dynamicWait.get().waittillpageloads();
		//Verfiy the Url
		businessFunction.get().checkUrl("Home_Support_Bash-ShellshockVulnerabilityInfo", "contains");
		//Navigate back to Avaya Site
		getDriver().navigate().back();
		dynamicWait.get().waittillpageloads();
		userActions.get().clickOn("Home_Support");		
		//Click on Contact Support Link
		userActions.get().clickOn("Home_ContactSupport");
		dynamicWait.get().waittillpageloads();
		//Verfiy the Url
		businessFunction.get().checkUrl("Home_ContactSupport", "equal");
		//Navigate back to Avaya Site
		getDriver().navigate().back();
		dynamicWait.get().waittillpageloads();
		userActions.get().clickOn("Home_Support");
		//Click on My SSo Profile Link
		userActions.get().clickOn("Home_MySSOProfile");
		dynamicWait.get().waittillpageloads();
		//Verfiy the Url
		businessFunction.get().checkUrl("Home_MySSOProfile", "contains");
		//Navigate back to Avaya Site
		//getDriver().navigate().back();
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		userActions.get().clickOn("Home_Support");
		//Click on Open a New Service Request Link
		userActions.get().clickOn("Home_NewServiceRequest");
		dynamicWait.get().waittillpageloads();
		//Verfiy the Url
		businessFunction.get().checkUrl("Home_NewServiceRequest", "contains");
		//Navigate back to Avaya Site
		getDriver().navigate().back();
		dynamicWait.get().waittillpageloads();
		userActions.get().clickOn("Home_Support");
		//Click on Support By Product Link
		userActions.get().clickOn("Home_SupportByProduct");
		dynamicWait.get().waittillpageloads();
		//Verfiy the Url
		businessFunction.get().checkUrl("Home_SupportByProduct", "equal");
		//Navigate back to Avaya Site
		getDriver().navigate().back();
		dynamicWait.get().waittillpageloads();
		userActions.get().clickOn("Home_Support");
		//Click on Downloads Link
		userActions.get().clickOn("Home_Downloads");
		dynamicWait.get().waittillpageloads();
		//Verfiy the Url
		businessFunction.get().checkUrl("Home_Downloads", "contains");
		//Navigate back to Avaya Site
		getDriver().navigate().back();
		dynamicWait.get().waittillpageloads();
		userActions.get().clickOn("Home_Support");
		//Click on Support By Product Link
		userActions.get().clickOn("Home_GlobalProductRegistration");
		dynamicWait.get().waittillpageloads();
		//Verfiy the Url
		businessFunction.get().checkUrl("Home_GlobalProductRegistration", "contains");
		//Navigate back to Avaya Site
		getDriver().navigate().back();
		dynamicWait.get().waittillpageloads();
		userActions.get().clickOn("Home_Support");

		//Click on Downloads Link
		userActions.get().clickOn("Home_SupportForums");
		dynamicWait.get().waittillpageloads();
		//Verfiy the Url
		businessFunction.get().checkUrl("Home_SupportForums", "equal");
		//Navigate back to Avaya Site
		getDriver().navigate().back();
		dynamicWait.get().waittillpageloads();
		userActions.get().clickOn("Home_Support");
		//Click on Downloads Link
		userActions.get().clickOn("Home_BillerDirect");
		dynamicWait.get().waittillpageloads();
		//Verfiy the Url
		businessFunction.get().checkUrl("Home_BillerDirect", "contains");
		 
		
		}
	
	/**
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 07/08/2014
	  Date of Modified                  : --
	  Methods Called                    : clickOn(String controlName),enterText(String controlName,String text)
	  									socialIcons(String controlName,String childElement,String attribute) 
	  									sharingArticleInSocialSites(String controlName, String option, String ShareText)
	  Purpose of Method                 : Share Section in LinkedIn Social Site from CaseStudies Landing page
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	 
	 **/
	@Test(description = "Share Section in LinkedIn Social Site from CaseStudies Landing page",groups = "About Avaya -Case Studies page")
	public void testCaseforAvayaLandingPageShareSectionLinkedIn() {
		//Launching the Case Studies Landing page
		getDriver().get(appConfig.getCaseStudiesUrl());
		//Check the Social Icons are presen on the top right 
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		businessFunction.get().socialIcons("CaseStudies_SocialIcons","CaseStudies_SocialIcons_Child","class");	
		//Click on the LinkedIn Icon
		userActions.get().clickOn("EventPage_LinkedInIcon");	
		//Share the Link
		businessFunction.get().shareArticleInSocialSites("LinkedInPlusData", "linkedIn");																							
		//Check the Shared Link in LinkedIn page
		getDriver().get(appConfig.getLinkedInUrl());		
		businessFunction.get().validateSharedArticleInSocialSites("LinkedInPlusData", "linkedIn");
	}
	
	/**
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 07/08/2014
	  Date of Modified                  : --
	  Methods Called                    : clickOn(String controlName),enterText(String controlName,String text)
	  									sharingArticleInSocialSites(String controlName, String option, String ShareText)
	  Purpose of Method                 : Share Sectionn in Facebook Social Site from CaseStudies Landing page
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	 **/
	@Test(description = "Share Sectionn in Facebook Social Site from CaseStudies Landing page",groups = "About Avaya -Case Studies page")
	public void testCaseforAvayaLandingPageShareSectionFaceBook() {
		//Launching the Case Studies Landing page
		getDriver().get(appConfig.getCaseStudiesUrl());
		//Check the Social Icons are presen on the top right 
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		businessFunction.get().socialIcons("CaseStudies_SocialIcons","CaseStudies_SocialIcons_Child","class");
		//Click on Facebook Icon
		userActions.get().clickOn("CaseStudiesLandingPage_FacebookIcon");
		//Switch to Facebook window and share
		businessFunction.get().shareArticleInSocialSites("FacebookPlusData", "facebook");																
		//Check the Shared Link in Facebook page
		getDriver().get(appConfig.getFacebookUrl());
		businessFunction.get().validateSharedArticleInSocialSites("FacebookPlusData", "facebook");																
	}
	
	/**
	  Author Name                       : Sindhuja
	  Date of Preparation               : 07/08/2014
	  Date of Modified                  : --
	  Methods Called                    : clickOn(String controlName),enterText(String controlName,String text)
	  									socialIcons(String controlName,String childElement,String attribute) 
	  									sharingArticleInSocialSites(String controlName, String option, String ShareText)
	  Purpose of Method                 : Share Section in GooglePlus Social Site from CaseStudies Landing page
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	 **/
	@Test(description = "Share Section in GooglePlus Social Site from CaseStudies Landing page",groups = "About Avaya -Case Studies page")
	public void testCaseStudiesLandingPageShareSectionGooglePlusIcon(){
		//Launching the Case Studies Landing page
		getDriver().get(appConfig.getCaseStudiesUrl());
		//Check the Social Icons are presen on the top right 
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		businessFunction.get().socialIcons("CaseStudies_SocialIcons","CaseStudies_SocialIcons_Child","class");		
		//Click on GooglePlus Icon to Share
		userActions.get().clickOn("EventPage_GooglePlusIcon");
		//Share the Link
		businessFunction.get().shareArticleInSocialSites("GooglePlusData", "googleplus");																		
		//Check the Shared Link in GooglePlus page
		getDriver().get(appConfig.getGooglePlusUrl());		
		businessFunction.get().validateSharedArticleInSocialSites("GooglePlusData", "googleplus");
	}
	
	/**
	  Author Name                       : Niharika
	  Date of Preparation               : 07/08/2014
	  Date of Modified                  : --
	  Methods Called                    : isElementDisplayed(String controlName),verifyBreadCrumb(String actualControlName, String expectedControlName)
	  									clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle),deFocus()
	  									verifyElementContainsText(String controlName, String controlNameExpected)
	  Purpose of Method                 : Verify the Cloud page content
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/
	@Test(description = "Verify the Cloud page content",groups = "Cloud page")
	public void testCloudContent(){
		//Launching the Avaya website
		getDriver().get(appConfig.getAppUrl());
		//Hover on Product Mega Menu and click on the Cloud Link
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		businessFunction.get().clickOnSubMenuItem("Products", "Products_Category4", "Products_Category4_Title");
		businessFunction.get().deFocus();
		//Verify the breadcrumb
		dynamicWait.get().waittillpageloads();
		businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "Avaya_Cloud_Breadcrumb_Expected","Tag_Anchors");
		//Verify the Image Carousel
		verify.get().verifyImageCarousel("Cloud_Marquee");	
		//Verify navigation to UCaaS page
		businessFunction.get().clickAndVerifyNavigation("UCaaS","UCaaS Title");
		//Verify cross cell pod
		verify.get().isElementPresent("UCaasCrossCellPod");
		//Verify navigation of Learn more
		verify.get().isElementPresent("UCaasLearnMore");
		
	}
	
	/** 
	  Author Name                       : Vinusha
	  Date of Preparation               : 07/08/2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify the content displayed  on All tab of Perspectives Landing Page.
	  Dependencies	                   	: --
	  Reviewed By                       : --
	  
	**/
@Test(description="Verify the content displayed  on All tab of Perspectives Landing Page.", groups="Perspectives")
	public void testPerspectivesLandingPageAll(){
	//navigate to app url	
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	//Click on 'Perspectives' tab of mega menu. and System should navigate to Perspectives Landing Page with All tab contents displayed by default.
	businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "Perspectives_SubMenu", "PerspectivesTitlePage");
	businessFunction.get().deFocus();
	/*System should display the Perspectives LandingPage with the following details: • Butler bar*/
	verify.get().isElementPresent("ButlerBar");
	//verify megamenu
	verify.get().isElementPresent("Megamenu");
	//verify breadcrumb
	//businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "PerspectivesBreadCrumb","Tag_Anchors");
	//verify perspectives sub heading
	verify.get().isTextPresent("PerspectivesSubHeading");
	//verify subscribe element
	verify.get().isElementPresent("Subscribe");
	//Verfiy the Sub menu with tabs All,Unified  Comunications and Collaboration, Customer Experience Management,Networking,Midmarket,Cloud
	businessFunction.get().verifySubMenuElements("Perspectives_Tabs_Parent", "Tag_List",",");
	//verify load articles element
	verify.get().isElementPresent("Loadmorearticles");
	//verify global footer
	verify.get().isElementPresent("GlobalFooter");
	//verify most popular widget
	verify.get().isElementPresent("MostPopularArticlesWidget");
	//verify topics widget
	verify.get().isElementPresent("TopicsWidget");
	//verify avaya magazine widget
	verify.get().isElementPresent("AvayaMagazineWidget");
	//verify pintrest widget
	verify.get().isElementPresent("PintrestWidget");
	//verify twitter widget
	verify.get().isElementPresent("TwitterWidget");
	//verify YT widget
	verify.get().isElementPresent("YTwidget");
	//verify fb widget
	verify.get().isElementPresent("FBWidget");
	//verify slide share widget
	verify.get().isElementPresent("SlideShareWidget");
	//verify linkedin widget
	verify.get().isElementPresent("LinkedInWidget");
	//verify news widget
	verify.get().isElementPresent("NewsWidget");
	//click on load more articles
	userActions.get().clickOn("Loadmorearticles");
	//Verfiy the Articles are displayed in two columns
	businessFunction.get().checkCssProperty("Perspectives_ArticlesLeft", "float");
	businessFunction.get().checkCssProperty("Perspectives_ArticlesRight", "float");			
	//verify the articles displayed
	businessFunction.get().verifyArticlesInPerspective("Perspectives_ArticlesDetails");				
	}

      /** 
      Author Name                       : Sindhuja
      Date of Preparation               : 07/08/2014
      Date of Modified                  : --
      Methods Called                    :  
      Purpose of Method                 : Verify the Topics displayed on click 'Show All Topics' link on Perspectives Landing Page.
      Dependencies	                   	: --
      Reviewed By                       : --
      **/
@Test(description="Verify the Topics displayed on click 'Show All Topics' link on Perspectives Landing Page.", groups="Perspectives")
public void testPerspectivesShowAllTopics(){
	//navigate to app URL
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	businessFunction.get().getValueOfHtmlAttribute("AvayaTitlePage", "title");
	//Click on 'Perspectives' tab of mega menu. and System should navigate to Perspectives Landing Page with All tab contents displayed by default.
	businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "Perspectives_SubMenu", "PerspectivesTitlePage");
	//Click on 'Show All Topics'  link and System should display all the topics in one column.
	userActions.get().clickOn("Perspectives_ShowAllTopics");
	dynamicWait.get().waittillpageloads();
	verify.get().isElementNotDisplayed("Perspectives_ShowAllTopics");    		
	businessFunction.get().checkforvisibleLinks("Topics_container", "block");	
	}

    
	/** 
	  
	  Author Name                       : Phanendra
	  Date of Preparation               : 07/08/2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify Follow us link functionality
	  Dependencies	                   	: --
	  Reviewed By                       : --
	  
	**/
    @Test(description="Verify Follow us link functionality", groups="Perspectives")
    public void testPerspectivesMagzCheckTwitter(){
    	//navigate to app url
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		businessFunction.get().getValueOfHtmlAttribute("AvayaTitlePage", "title");
		//Click on 'Perspectives' tab of mega menu. System should navigate to Perspectives Landing Page
		businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "Perspectives_SubMenu", "PerspectivesTitlePage");
		//Click on Magazines and guides
		userActions.get().clickOn("Perspectives_addl_links_mags_guides");
		dynamicWait.get().waittillpageloads();
		//Magazines and guides Landing page is displayed
		verify.get().isTextPresent("Perspectives_mags_guides_titlepage");
		//Verfiy Follow Us Link is displayed on the page
		verify.get().isElementDisplayed("twitter_link");
		//switch to Twitter Frame
		userActions.get().switchToFrame("TwitterWidget_Frame");
		dynamicWait.get().waittillpageloads();
		//verfiy the Time of Tweet
		businessFunction.get().verifyDateOrTime("TwitterWidget_Time");
		
		//Verfiy the Load More Link is displayed in Twitter Pod
		verify.get().isElementDisplayed("Twitter_LoadMoreLink");
		//swtich to the default content
		userActions.get().switchToDefaultContent();
		//Click on the 'Follow Us' link.
		userActions.get().clickOn("twitter_link");
		dynamicWait.get().waittillpageloads();
		userActions.get().switchToChildWindow();
		dynamicWait.get().waittillpageloads();
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System should display the Avaya Twitter page
		businessFunction.get().checkUrl("twitter_title", "contains");
    	}

    	/**
		  Author Name                       : Phanendra
		  Date of Preparation               : 07/08/2014
		  Date of Modified                  : 
		  Methods Called                    : clickOn(String controlName),switchToChildWindow()
		  									switchToParentWindow(),sharingArticle(String controlName, String option)
		  Purpose of Method                 : Verify that a Article can be shared in LinkedIn in a Perspective Article page
		  Dependencies	                    : Jar files
		  Reviewed By                       : --
		**/
		@Test(description= "Verify sharing article in all social sites in Case Studies page under Capabilities/Video Collaboration", groups = "Perspectives")
		public void testSocialSharingIconsValidationOnPerspectiveDetailpage(){
			//Launching the Avaya website
			getDriver().get(appConfig.getAppUrl());
			//Click on Perspective MegaMenu
			dynamicWait.get().waittillpageloads();
			businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "Perspectives_SubMenu", "PerspectivesTitlePage");
			//Click on Perspective Article
			dynamicWait.get().waittillpageloads();
			userActions.get().clickOn("Perspectives_article");
			//Click on Twitter Icon	
			dynamicWait.get().waittillpageloads();
			businessFunction.get().deFocus();
			//verify the social icons present in perspective article page
			businessFunction.get().socialIcons("Perspectivies_Icon","CaseStudies_SocialIcons_Child","class");				
		}
		
		 /** 
	    Author Name                       : Sindhuja
	    Date of Preparation               : 7/08/2014
	    Date of Modified                  : --
	    Methods Called                    : clickOn(Utilities),waittillpageloads(DynamicWait),isTextPresent(Verify),clickOnSubMenuItem,chatPopupCheck(businessFunction)
	    Purpose of Method                 : Verify the functionality of proactive chat on click of chat with us
	    Dependencies	                    : --
	    Reviewed By                       : --
	    Test Case Name					  :  Proactive chat_No Thanks
	    **/

	  @Test(description="Verify the functionality of proactive chat on click of chat with us",groups="Products")
	    public void testProactiveNoThanks() throws ParseException, InterruptedException
	    {
		    getDriver().manage().deleteAllCookies();
	    	// Launching the Avaya URL
	    	getDriver().get(appConfig.getAppUrl());
	    	dynamicWait.get().waittillpageloads();
	    	// Click on Products link and verify whether Products page is opening or not
	    	userActions.get().clickOn("Products");
	    	dynamicWait.get().waittillpageloads();
	    	//Checking the products label
	    	verify.get().isTextPresent("Products_label");			
	    	//Clicking on AvayaAuraCallCenterElite which is present in the Products hover screen	
	    	businessFunction.get().clickOnSubMenuItem("Products", "AvayaAuraCallCenterElitePopUp", "AvayaAuraCallCenterEliteHomePage");
	    	//Calling business function to validate the pop up message along with "ChatWithUs","No Thanks" options are available or not
	    	businessFunction.get().chatPopupCheck("ChatPOPUP","ChatNoThanks");		
	    	
	    }
	  
	   /** 
	    Author Name                       : Niharika
	    Date of Preparation               : 7/08/2014
	    Date of Modified                  : --
	    Methods Called                    : clickOn(Utilities),waittillpageloads(dynamicWait.get().),isTextPresent(Verify),clickOnSubMenuItem,chatPopupCheck(businessFunction)
	    Purpose of Method                 : Verify the functionality of proactive chat on click of any other tab other than overview
	    Dependencies	                  : --
	    Reviewed By                       : --
	    Test Case Name					  :  Proactive chat_Other than overview 
	    **/

	  @Test(description="Verify the functionality of proactive chat on click of any other tab other than overview",groups="Products")
	  public void testProactiveChatOtherThanOverview() throws ParseException, InterruptedException
	    {
		    getDriver().manage().deleteAllCookies();
	    	// Launching the Avaya URL
	    	getDriver().get(appConfig.getAppUrl());
	    	dynamicWait.get().waittillpageloads();
	    	// Click on Products link and verify whether Products page is opening or not
	    	userActions.get().clickOn("Products");
	    	dynamicWait.get().waittillpageloads();
	    	//Checking the products label
	    	verify.get().isTextPresent("Products_label");			
	    	//Clicking on AvayaAuraCallCenterElite which is present in the Products hover screen
	    	businessFunction.get().clickOnSubMenuItem("Products", "AvayaAuraCallCenterElitePopUp", "AvayaAuraCallCenterEliteHomePage");
	    	dynamicWait.get().waittillpageloads();
	    	businessFunction.get().deFocus();
	    	//Clicking on Resources tab and verify whether Resources tab is opened or not
	    	userActions.get().clickOn("DocumentandVideos_tab");
	    	dynamicWait.get().waittillpageloads();
	    	//Checking the Resources Home page
	    	verify.get().isTextPresent("ResourcesHomePage");
	    	//Calling business function to validate the pop up message along with "ChatWithUs","No Thanks" options are available or not
	  	    businessFunction.get().chatPopupCheck("ChatPOPUP","ChatNoThanks");
	    	
	    }
	  
	  /** 
	  Author Name                       : Pankaj
	  Date of Preparation               : 
	  Date of Modified                  : --
	  Methods Called                    : clickOn(Utilities),waittillpageloads(DynamicWait),isTextPresent(Verify),clickOnSubMenuItem,chatPopupCheck(businessFunction)
	  Purpose of Method                 : Verify that proactive chat popup window is closed on clicking outside the pop up window
	  Dependencies	                  	: --
	  Reviewed By                       : --
	  Test Case Name					:  Proactive chat_Outside click
	  * @throws ParseException 
	  
	    **/ 

	  @Test(description="Verify that proactive chat popup window is closed on clicking outside the pop up window",groups="Products")
	  public void testProactiveChatOutsideClick() throws ParseException, InterruptedException
	    {
		  getDriver().manage().deleteAllCookies();
	  	// Launching the Avaya URL
	  	getDriver().get(appConfig.getAppUrl());
	    	dynamicWait.get().waittillpageloads();
	  	// Click on Products link and verify whether Products page is opening or not
	  	userActions.get().clickOn("Products");
	  	dynamicWait.get().waittillpageloads();
	  	//Verifying the Products label
	  	verify.get().isTextPresent("Products_label");			
	  	//Clicking on AvayaAuraCallCenterElite which is present in the Products hover screen
	  	businessFunction.get().clickOnSubMenuItem("Products", "AvayaAuraCallCenterElitePopUp", "AvayaAuraCallCenterEliteHomePage");
	  	//Calling business function to validate the pop up message along with "ChatWithUs","No Thanks" options are available or not
	  	businessFunction.get().chatPopupCheck("ChatPOPUP","OutsideClick");		
	  	
	    }

	    /** 
	    Author Name                       : Sivanag
	    Date of Preparation               : 
	    Date of Modified                  : 15/09/2014
	    Methods Called                    : clickAndVerifyNavigation(String navigatetopage,String pageTitle)
	   										  clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle)
	    Purpose of Method                 : Verify that proactive chat popup window is displayed every time page is refreshed
	    Dependencies	                    : --
	    Reviewed By                       : --
	    * @throws ParseException 
	    
	    **/

	  @Test(description="Verify that proactive chat popup window is displayed every time page is refreshed",groups="Products")
	  public void testProactiveChatRefresh() throws ParseException, InterruptedException
	    {
		  getDriver().manage().deleteAllCookies();
		// Launching the Avaya URL
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		// Click on Products link and verify whether Products page is opening or
		// not
		businessFunction.get().clickAndVerifyNavigation("Products",
				"Products_label");
		dynamicWait.get().waittillpageloads();
		// Clicking on AvayaAuraCallCenterElite on hovering of Products tab in
		// the Megamenu
		businessFunction.get().clickOnSubMenuItem("Products",
				"AvayaAuraCallCenterElitePopUp",
				"AvayaAuraCallCenterEliteHomePage");
		// Calling business function to validate the pop up message along with
		// "ChatWithUs","No Thanks" options are available or not
		businessFunction.get().chatPopupCheck("ChatPOPUP", "PageRefresh");

	}

	  
	  /**
	  Author Name                       : Phanendra
	  Date of Preparation               : 07/08/2014
	  Date of Modified                  : --
	  Methods Called                    : deFocus(String controlName),clickOn(String controlName),
	  									checkCssProperty(String controlName, String cssProperty),
	  									clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle)
	  Purpose of Method                 : Verify the Survey popup is displayed and click on No
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	 **/
	  @Test(description = "Verify the Survey popup is displayed and click on No", groups ="Survey")
		public void testSurveyPopUpNo(){		
			//Launching the Avaya website
			getDriver().get(appConfig.getAppUrl());
			//Click on Product Mega Menu
			dynamicWait.get().waittillpageloads();
			userActions.get().clickOn("Products");
			//Click on Avaya Aura Call Center Elite
			dynamicWait.get().waittillpageloads();
			businessFunction.get().scrollDown();
			userActions.get().clickOn("Product_AvayaAuraCallCenterElite");
			dynamicWait.get().waittillpageloads();
			verify.get().isElementDisplayed("Product_AvayaAuraCallCenterElite_Title");
			//Click on the Case Studies Tab		
			userActions.get().clickOn("CaseStudies_Tab");
			//Click on the Resources Tab
			dynamicWait.get().waittillpageloads();
			userActions.get().clickOn("DocumentandVideos_tab");
//			System.out.println(getDriver().manage().getCookieNamed("surveyclickcounter"));		
			//Click on About Avaya
			dynamicWait.get().waittillpageloads();
			userActions.get().clickOn("MegaMenuAboutAvaya");
			//Verify Survey Popup is displayed
			dynamicWait.get().waitforvisibilityOfElementLocated("SurveryWindowDisplay");
			businessFunction.get().checkCssProperty("SurveryWindowDisplay", "display");
			//Click on No Thankyou
			userActions.get().clickOn("SurveyNoThankYou");

			try{
				Thread.sleep(2000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			/*Check Survey Popup does not display again as No Thankyou button was clicked*/
			dynamicWait.get().waittillpageloads();
			//Click on Product Mega Menu
			userActions.get().clickOn("Products");
			//Click on Avaya Aura Call Center Elite
			dynamicWait.get().waittillpageloads();
			businessFunction.get().scrollDown();
			userActions.get().clickOn("Product_AvayaAuraCallCenterElite");
			verify.get().isElementDisplayed("Product_AvayaAuraCallCenterElite_Title");
			//Click on the Case Studies Tab
			userActions.get().clickOn("CaseStudies_Tab");
			//Click on the Resources Tab
			dynamicWait.get().waittillpageloads();
			userActions.get().clickOn("DocumentandVideos_tab");
			//Click on About Avaya
			dynamicWait.get().waittillpageloads();
			userActions.get().clickOn("MegaMenuAboutAvaya");		
			//Verify Survey Popup is not displayed
			dynamicWait.get().waittillpageloads();
			businessFunction.get().checkCssProperty("SurveryWindowNoDisplay", "display");
			
			/*Launching the Avaya website again to check Survey popup is displayed in new session*/
			
			//Launching the Avaya website
			getDriver().manage().deleteAllCookies();
			//Click on Product Mega Menu
			dynamicWait.get().waittillpageloads();
			userActions.get().clickOn("Products");
			//Click on Avaya Aura Call Center Elite
			dynamicWait.get().waittillpageloads();
			businessFunction.get().scrollDown();
			userActions.get().clickOn("Product_AvayaAuraCallCenterElite");
			dynamicWait.get().waittillpageloads();
			verify.get().isElementDisplayed("Product_AvayaAuraCallCenterElite_Title");
			//Click on the Case Studies Tab
			userActions.get().clickOn("CaseStudies_Tab");
			//Click on the Resources Tab
			dynamicWait.get().waittillpageloads();
			userActions.get().clickOn("DocumentandVideos_tab");
			dynamicWait.get().waittillpageloads();
			businessFunction.get().checkCssProperty("SurveryWindowNoDisplay", "display");
			//Click on About Avaya
			userActions.get().clickOn("MegaMenuAboutAvaya");
			//Verify Survey Popup is displayed
			dynamicWait.get().waittillpageloads();
			dynamicWait.get().waitforvisibilityOfElementLocated("SurveryWindowDisplay");
			businessFunction.get().checkCssProperty("SurveryWindowDisplay", "display");		
		}
	
	/**
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 31/07/2014
	  Date of Modified                  : --
	  Methods Called                    : deFocus(),clickOn(String controlName)
	  									  verifyPagesUrls(String controlName)
	  Purpose of Method                 : Verify the Magazine pages urls
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	 
	 **/
	@Test(description ="Verify the Magazine pages urls", groups ="Perspectives")
	public void testPerspectiveMagazineSubdirectory() {
		// Launching the Avaya website
		getDriver().get(appConfig.getAppUrl());
		// Click on Perspective MegaMenu
		try {
			dynamicWait.get().waittillpageloads();
			businessFunction.get().deFocus();
			businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "Perspectives_SubMenu", "PerspectivesTitlePage");
			businessFunction.get().deFocus();
			// Check on the Magazine and guidlines link present under Additional
			// links
			dynamicWait.get().waittillpageloads();
			userActions.get().clickOn("Perspectives_addl_links_mags_guides");
			// Navigate to page and validate the URLs
			Thread.sleep(5000);
			businessFunction.get().verifyMagazinePageUrls("Magazine_pages");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	/** 
	  Author Name                       : Phanendra
	  Date of Preparation               : 07/08/2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify the Country selector
	  Dependencies	                   	: --
	  Reviewed By                       : --
	**/
       @Test(description="Verify the Country selector", groups="Home Page")
	   public void testHomePageButlerBarCountrySelector(){
		//navigate to app url
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		//Click on the Country Selector from the butler bar
		userActions.get().clickOn("Home_Country_Selector");
		businessFunction.get().checkContainsChildElements("Home_Country_Selector", "Home_Country_Selector_Tabs","@");
		//Click on Australia from rollout and System should navigate to Avaya website of Australia region
		userActions.get().clickOn("Home_Country_Australia");
		businessFunction.get().checkUrl("Home_Country_Australia_Url", "contains");
		}
       
       /**
       Author Name                       : Niharika K R 
       Date of Preparation               : 11-08-2014
       Date of Modified                  : --
       Methods Called                    : clickAndVerifyNavigation(String navigatetopage,String pageTitle),clickOn(String controlName)
         checkSelectedTabActive(String tabSection, String tabs,String str_selectedtabname),verifyVideo(String videoPlay)
       Purpose of Method                 : Verify if the User is able to play the video for Product Avaya Aura Collaboration Environment
       Dependencies                    : Jar files
       Reviewed By                       : 
       **/
       
       @Test(description="Verify if the User is able to play the video for Product Avaya Aura Collaboration Environment",groups="Products")
   	public void testProductDetailPageProductGalleryVideoPlay()
   	{
   		//Launching the Avaya website
   		getDriver().get(appConfig.getAppUrl());
   		dynamicWait.get().waittillpageloads();
   		//Click on the Products tab in the Megamenu and check the title in Products landing page
   		businessFunction.get().clickAndVerifyNavigation("Products", "Products_label");
   		dynamicWait.get().waittillpageloads();
   		businessFunction.get().deFocus();
   		//To click on the View All link.
   		userActions.get().clickOn("Products_Pagination_ViewAll");
   		dynamicWait.get().waittillpageloads();
   		dynamicWait.get().waittillpageloads();
   		//To click on  "Avaya Aura Collaboration Environment" Product
   		businessFunction.get().clickAndVerifyNavigation("AvayaAuraCollaborationEnvironment", "AvayaAuraCollaborationEnvironment_Title");
   		//To check the presence of the video in the overview section.
   		businessFunction.get().checkSelectedTabActive("AvayaAuraCollaborationEnvironment_Tabs", "Tag_List", "OVERVIEW");
   		//To click on the Play icon on the Video.
   		userActions.get().clickOn("AvayaAuraCollaborationEnvironment_Video");
   		//To check if the video is playing.
   		verify.get().verifyVideo();
   	}
 	/** 
	  Author Name                       : Phanendra
	  Date of Preparation               : 11/08/2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify the search results displayed on entering valid input in 'Search Articles' textbox.
	  Dependencies	                   	: --
	  Reviewed By                       : --
	   @throws Exception 
	  
	**/
      @Test(description="Verify the search results displayed on entering valid input in 'Search Articles' textbox.", groups="Perspectives")
		public void testPerspectiveSearchResults(){
			//navigate to app url
			getDriver().get(appConfig.getAppUrl());
	    	dynamicWait.get().waittillpageloads();
				//Click on Perspectives tab in the mega menu. and System should navigate to Magazine Page.
			businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "Perspectives_SubMenu", "PerspectivesTitlePage");
			//send input data to search
			businessFunction.get().sendinputdata("searchinput", "search", "AvayaHome_SearchBox");
			//click on search
			userActions.get().clickOn("Search_Button_Test");
			dynamicWait.get().waittillpageloads();
			//verify search results
			businessFunction.get().searchValidResults("searchresults", "Avaya");
		}
	
	/** 
	  Author Name                       : Vinusha
	  Date of Preparation               : 11/08/2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify whether the changes are reflected in the avaya application
	  Dependencies	                   	: --
	  Reviewed By                       : --
	  @throws Exception 
	  
	**/
      @Test(description="Verify whether the changes are reflected in the avaya application", groups="Perspectives")
	public void testPerspectivesNetworking() {
		// navigate to app url
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		// Click on Perspectives tab and Perspectives landing page should be
		// displayed
		businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya",
				"Perspectives_SubMenu", "PerspectivesTitlePage");
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		// Click on Networking link and System should be navigated to Networking
		// link
		businessFunction.get().clickAndVerifyNavigation(
				"Perspectives_Networking", "Networking_Title");
		businessFunction.get().deFocus();
		// send test data
		userActions.get().enterText("Perspectives_Networking_SearchBox",
				"Cloud");
		// click on search button
		userActions.get().clickOn("search_button");
		// Article named "perspectives_articles" should be present
		businessFunction.get().contentValidation("article_parent");
	}
	 /**
    Author Name                       : Phanendra
    Date of Preparation               : 11/08/2014
    Date of Modified                  : --
    Methods Called                    : isTextPresent(Verify) ,verifyTealiumTags(businessfunction)
    Purpose of Method                 : Verify if the meta tag is displayed in the source for the page not found pages
    Dependencies	                    : clickOn(UserActions),verifyTealiumTags(BusinessFunctions)
    Reviewed By                       : --
  Test Case Name					  : wi01143248_404 meta tag
  **/ 

  
  @Test(description="Verify if the meta tag is displayed in the source for the page not found pages",groups="Meta tag")
  public void test404MetaTag()
  {
  	// Launching the Benefits URL
  	getDriver().get(appConfig.getErrorUrl());    	
  	dynamicWait.get().waittillpageloads();
  	//Verify 404 Error is present or not
  	businessFunction.get().verifyPageTitle("PageNotFound_Title");
  	getDriver().getPageSource().contains("<meta name=\"WT.error\" content=\"404\"/>");
   }
  
  /** 
  Author Name                       : @author karthik_b14
  Date of Preparation               : 25/06/2014
  Date of Modified                  : --
  Methods Called                    : 
  Purpose of Method                 : Verify that the global search has the autocomplete functionality
  Dependencies	                   	: --
  Reviewed By                       : --
 * @throws Exception 
  
**/
  @Test(description="Verify if the user is able to search with invalid keywords", groups="Home Page")
  public void testHomePageGlobalSearchInvalidKeywords(){
  //navigate to app url
  getDriver().get(appConfig.getAppUrl());
      dynamicWait.get().waittillpageloads();
  //send invalid data
  businessFunction.get().checkAutoCompleteResults("autosuggestion_results", "InvalidSearch", "AvayaHome_SearchBox");
  //click on search button
  userActions.get().clickOn("Search_Button_Test");
  //verify search results
  verify.get().isTextPresent("GlobalInvalidSearchMessage");
   
  }
 
   /** 
   Author Name                       : Phanendra 
   Date of Preparation               : 11/08/2014
   Date of Modified                  : --
   Methods Called                    : 
   Purpose of Method                 : Verify that the global search has the autocomplete functionality
   Dependencies	                   	: --
   Reviewed By                       : --
   **/
  @Test(description="Verify that the global search has the autocomplete functionality", groups="Home Page")
  public void testHomePageGlobalSearch(){
  //navigate to app url
  getDriver().get(appConfig.getAppUrl());
      dynamicWait.get().waittillpageloads();
  businessFunction.get().getValueOfHtmlAttribute("AvayaTitlePage", "title");
  //send input data
  businessFunction.get().checkAutoCompleteResults("autosuggestion_results","ValidSearch", "AvayaHome_SearchBox");
  //click on search button
  userActions.get().clickOn("Search_Button_Test");
  businessFunction.get().searchValidResults("searchresults", "Avaya");
  }
    
	/** 
	  Author Name                       : Phanendra
	  Date of Preparation               : 11/08/2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verify search result are 10
	  Dependencies	                   	: --
	  Reviewed By                       : --
	**/
	@Test(description = "Verify search result are 10", groups = "Home Page")
	public void testHomePageGlobalSearch2() {
		// navigate to app url
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		businessFunction.get().getValueOfHtmlAttribute("AvayaTitlePage",
				"title");
		// provide input data and verify search results
		businessFunction.get().checkAutoCompleteResults(
				"autosuggestion_results", "Home_Search_Input", "searchinput");
	}
	

	/**
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 11/08/2014
	  Date of Modified                  : --
	  Methods Called                    : deFocus(String controlName),clickOn(String controlName),
	  									checkCssProperty(String controlName, String cssProperty),
	  									clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle)
	  Purpose of Method                 : Verify the Survey popup is displayed
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	 **/
	@Test(description = "Verify the Survey popup is displayed", groups ="Survey")
	public void testSurveyPopUpAfter3SuccessfulPages(){
		getDriver().manage().deleteAllCookies();
		//Launching the Avaya website
		getDriver().get(appConfig.getAppUrl());
		//Click on Product Mega Menu
		dynamicWait.get().waittillpageloads();
		threadDriver.get().manage().deleteCookieNamed("surveyclickcounter");
		userActions.get().clickOn("Products");
		//Click on Avaya Aura Call Center Elite
		dynamicWait.get().waittillpageloads();
		businessFunction.get().scrollDown();
		userActions.get().clickOn("Product_AvayaAuraCallCenterElite");
		dynamicWait.get().waittillpageloads();
		//Verify the Avaya Aura Call Center Elite Header
		verify.get().isElementDisplayed("Product_AvayaAuraCallCenterElite_Title");
		//Click on the Case Studies Tab
		userActions.get().clickOn("CaseStudies_Tab");
		//Click on the Resources Tab
		dynamicWait.get().waittillpageloads();
		userActions.get().clickOn("DocumentandVideos_tab");
		//Click on About Avaya
		dynamicWait.get().waittillpageloads();
		userActions.get().clickOn("MegaMenuAboutAvaya");
		dynamicWait.get().waitforvisibilityOfElementLocated("SurveryWindowDisplay");
		//Verify Survey Popup is displayed
		businessFunction.get().checkCssProperty("SurveryWindowDisplay", "display");				
	}	
	
	/**
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 11/08/2014
	  Date of Modified                  : --
	  Methods Called                    : deFocus(String controlName),clickOn(String controlName),
	  									checkCssProperty(String controlName, String cssProperty),
	  									clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle)
	  Purpose of Method                 : Verify the Survey popup is displayed and click on Yes
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/
	@Test(description = "Verify the Survey popup is displayed and click on Yes", groups ="Survey Pop up")
	public void testSurveyPopUpYes(){
		//Launching the Avaya website
		getDriver().get(appConfig.getAppUrl());
		//Click on Product Mega Menu
		dynamicWait.get().waittillpageloads();
		userActions.get().clickOn("Products");
		//Click on Avaya Aura Call Center Elite
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		userActions.get().clickOn("Product_AvayaAuraCallCenterElite");
		dynamicWait.get().waittillpageloads();
		verify.get().isElementDisplayed("Product_AvayaAuraCallCenterElite_Title");
		//Click on the Case Studies Tab
		userActions.get().clickOn("CaseStudies_Tab");
		//Click on the Resources Tab
		dynamicWait.get().waittillpageloads();
		userActions.get().clickOn("DocumentandVideos_tab");		
		//Click on About Avaya
		dynamicWait.get().waittillpageloads();
		userActions.get().clickOn("MegaMenuAboutAvaya");
		dynamicWait.get().waitforvisibilityOfElementLocated("SurveryWindowDisplay");
		//Verify Survey Popup is displayed
		businessFunction.get().checkCssProperty("SurveryWindowDisplay", "display");
		//Click on Participate Button
		userActions.get().clickOn("SurveyParticipate");
		userActions.get().clickOn("SurveyClose");
		//Verify Survey Popup is not displayed
		businessFunction.get().checkCssProperty("SurveryWindowNoDisplay", "display");
	}
	
	/**
	  Author Name                       : Phanendra
	  Date of Preparation               : 11/08/2014
	  Date of Modified                  : --
	  Methods Called                    : deFocus(String controlName),clickOn(String controlName),
	  									checkCssProperty(String controlName, String cssProperty),
	  									clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle)
	  Purpose of Method                 : Verify the Survey popup is displayed irrespective of the Start
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	 **/
	@Test(description = "Verify the Survey popup is displayed irrespective of the Start", groups ="Survey")
	public void testSurveyPopUpAfter3SuccessfulPagesRegardlessOfStart(){
		//Delete cookies
		getDriver().manage().deleteAllCookies();		
		//Launching the Avaya website
		getDriver().get(appConfig.getAppUrl());
		//Click on Perspectives Mega Menu
		dynamicWait.get().waittillpageloads();
		businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "Perspectives_SubMenu", "PerspectivesTitlePage");
		//Click on Product Mega Menu
		dynamicWait.get().waittillpageloads();	
		dynamicWait.get().waittillpageloads();	
		userActions.get().clickOn("Products");
		//Click on Avaya Aura Call Center Elite
		dynamicWait.get().waittillpageloads();	
			
		businessFunction.get().scrollDown();
		userActions.get().clickOn("Product_AvayaAuraCallCenterElite");
		dynamicWait.get().waittillpageloads();
		verify.get().isElementDisplayed("Product_AvayaAuraCallCenterElite_Title");
		//Click on the Case Studies Tab
		userActions.get().clickOn("CaseStudies_Tab");
		//Click on the Resources Tab
		dynamicWait.get().waittillpageloads();
		userActions.get().clickOn("DocumentandVideos_tab");
		//Click on About Avaya
		dynamicWait.get().waittillpageloads();
		userActions.get().clickOn("MegaMenuAboutAvaya");
		dynamicWait.get().waitforvisibilityOfElementLocated("SurveryWindowDisplay");
		//Verify Survey Popup is displayed
		businessFunction.get().checkCssProperty("SurveryWindowDisplay", "display");					
	}
	
	/**
	  Author Name                       : Phanendra
	  Date of Preparation               : 11/08/2014
	  Date of Modified                  : 
	  Methods Called                    : clickOn(String controlName),enterText(String controlName,String text),
	  										sendinputdata(String controlName, String option, String searchControlName)
	  Purpose of Method                 : Verify that a Article is subscribed in Perspective Article page
	  Dependencies	                    : Jar files
	  Reviewed By                       : --
	**/
	@Test(description = "Verify that a Article is subscribed in Perspective Article page",groups = "Perspectives")
	public void testPerspectivesDetailPageSubscribe(){
		//Launching the Avaya website
		getDriver().get(appConfig.getAppUrl());
		//Click on Perspective MegaMenu
		dynamicWait.get().waittillpageloads();
		businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "Perspectives_SubMenu", "PerspectivesTitlePage");
		//Click on Perspective Article
		dynamicWait.get().waittillpageloads();
//		userActions.get().clickOn("Perspectives_article");
		businessFunction.get().verifyArticleNavigation("Perspectives_ArticleList", "Perspectives_ArticleHeader");
		//Click on Subscribe
		dynamicWait.get().waittillpageloads();
		userActions.get().clickOn("Perspectives_subscribe");
		//Enter details in Subscribe Form
		dynamicWait.get().waittillpageloads();
		businessFunction.get().sendinputdata("subscriptioninputdata", "subscription","none");
		userActions.get().clickOn("Perspectives_subscribe_SubmitForm");
	}
	
	
	/** 
	   Author Name                      : Vinusha Tanuku
	  Date of Preparation               : 21/06/2014
	  Date of Modified                  : 10/09/2014
	  Methods Called                    : clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle)
	  									  checkSelectedTabActive(String tabSection, String tabs,String str_selectedtabname) 
	  									  pageAllignment(String relativeControlName, String controlName, String position)
	  									  verifyElementContainsText(String controlName, String controlNameExpected)
	  									  checkCssProperty(String controlName, String cssProperty)
	  									  isElementDisplayed(String controlName)
	  Purpose of Method                 : Verify the details present on the Customer Success tab of Service Detail page.
	  Dependencies                      : --
	  Reviewed By                       : --
	  **/
	
	@Test(description="Verify the details present on the Customer Success tab of Service Detail page")
	public void testServiceDetailCaseStudies()
	{
		//Launching the Avaya website
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		//Hover on Services Mega Menu and Click on ContactCenterOptimization
		businessFunction.get().clickOnSubMenuItem("Services","ContactCenterOptimization","ContactCenterOptimization_Title");
		businessFunction.get().deFocus();
		//Verify if OverviewTab is selected by default
		businessFunction.get().checkSelectedTabActive("Products_AAP_ParentTab", "Products_AAP_Tabs_Child", "OVERVIEW");
		//Click On Case Studies Tab
		userActions.get().clickOn("Services_CaseStudies_tab");
		//Verify if Case Studies Tab is Selected
		businessFunction.get().checkSelectedTabActive("Products_AAP_ParentTab", "Products_AAP_Tabs_Child", "CASE STUDIES");
		//Verify if the Position of Narrow Search Results is on left
		businessFunction.get().pageAllignment("ButlerBar", "Services_CaseStudies_SearchByPod","equal");
		//Check if Search, Customer,Industry,Business Size Catergories are Available
		businessFunction.get().verifySubMenuElements("CaseStudies_SearchCategories","Tag_Span",",");
		//To check if "<Count> Customer Success match your criteria" is  displayed
		verify.get().verifyElementContainsText("ServicesCaseStudies_Text", "CaseStudies_Message");
		//Verify if SortResultsBy Section is displayed
		verify.get().isElementDisplayed("CaseStudies_SortResultsBySection");
		//Verify if SortResultsBy Section is displayed in red color
		businessFunction.get().checkCssProperty("CaseStudies_SortResultsBySection","background-color");
		//Verify if Name is Present in Sort By Container by Default
		businessFunction.get().verifySubMenuElements("CaseStudies_SortResultsBy","Tag_Anchors",",");
		//Check for the Your Result section
		verify.get().isElementDisplayed("CaseStudies_ResultsSection");	
	}
	
	/** 
	Author Name                       : @author karthik_b14
	Date of Preparation               : 01/07/2014
	Date of Modified                  : 17-09-2014
	Methods Called                    : 
	Purpose of Method                 : Verify the Explore Capabilities pod
	Dependencies	                   	: --
	Reviewed By                       : --
	* @throws Exception 

	**/
	@Test(description="Verify the Explore Capabilities pod", groups="Home Page")
	public void testHomePageExploreCapabilitiesPod()
	{
	//navigate to app URL
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	businessFunction.get().deFocus();
	//To check the presence of bold line title.
	businessFunction.get().checkCssProperty("HomePage_CollaborationPOD_Title", "font-weight");
	businessFunction.get().contentValidation("HomePage_CollaborationPOD_Title");
	//To check the presence of non bold line sub title.
	businessFunction.get().checkCssProperty("HomePage_CollaborationPOD_SubTitle", "font-weight");
	businessFunction.get().contentValidation("HomePage_CollaborationPOD_SubTitle");
	//To check the presence of maximum 3 images		
	//To check the presence of clickable images.
	//To check the presence of  Each image with a red dot along with the heading 
	businessFunction.get().verifyCollaborationPodImagesClickable("CollaborationPods_ClicakableImages");
	//To check the presence of Previous and Next links
	businessFunction.get().verifyMenuOrCategoryLinks("HomePage_CollaborationPOD_Links");
	verify.get().isTextPresent("HomePage_CollaborationPOD_PreviousLink");
	verify.get().isTextPresent("HomePage_CollaborationPOD_NextLink");
	//To check the presence of A link to the Solutions landing page
	businessFunction.get().verifyMenuOrCategoryLinks("HomePage_CollaborationPOD_CapabilitiesLink");
							
	//To hover on the dot of the image.
	userActions.get().hoverOn("CollaborationPOD_RedDot");
	//To check if fly out is appeared with few lines of related content and one link named "Learn More"
	businessFunction.get().contentValidation("CollaborationPOD_RedDot_Content");
	businessFunction.get().verifyMenuOrCategoryLinks("CollaborationPOD_RedDot_CTA");
	//verify.get().isTextPresent("CollaborationPOD_RedDot_CTA");
	//To click on Learn More CTA and verify the navigation.
	userActions.get().clickOn("CollaborationPOD_RedDot_CTA");	
	getDriver().navigate().back();
	dynamicWait.get().waittillpageloads();
	//Click on the "next" link displayed in the pod
	businessFunction.get().checkPerspectivePODscroll("CollaborationPOD_ImageTitle", "HomePage_CollaborationPOD_NextLink");
	//Click on the "Prev" link displayed in the pod
	businessFunction.get().checkPerspectivePODscroll("CollaborationPOD_ImageTitle", "HomePage_CollaborationPOD_PreviousLink");
	//To Click on "See All Avaya Solutions" link and verify the navigation
	businessFunction.get().clickAndVerifyNavigation("HomePage_CollaborationPOD_CapabilitiesLink", "HomePage_CollaborationPOD_CapabilitiesTitle");
	getDriver().navigate().back();
	dynamicWait.get().waittillpageloads();
	//To click on first image and check if other 2 images are blurred
	userActions.get().clickOn("CollaborationPods_Indicator1");
	dynamicWait.get().waittillpageloads();
	businessFunction.get().verifyCollaborationPodsRotation("CollaborationPods_ClicakableImages");
	////To click on second image and check if other 2 images are blurred
	userActions.get().clickOn("CollaborationPods_Indicator1");
	dynamicWait.get().waittillpageloads();
	businessFunction.get().verifyCollaborationPodsRotation("CollaborationPods_ClicakableImages");
	////To click on third image and check if other 2 images are blurred
	userActions.get().clickOn("CollaborationPods_Indicator1");
	dynamicWait.get().waittillpageloads();
	businessFunction.get().verifyCollaborationPodsRotation("CollaborationPods_ClicakableImages");
	}


	/** 
	  Author Name                       : Niharika
	  Date of Preparation               : 15/09/2014
	  Date of Modified                  : 
	  Methods Called                    : checkCssProperty(String controlName, String cssProperty),imageValidation(String imageControlName)
										  verifyImagesClickable(String controlName),verifyMenuOrCategoryLinks(String controlName)
										  verifySubMenuElements(String parentMenu,String subMenu,String delimiter),isTextPresent(String controlName) 
										  checkPerspectivePODscroll(String controlName, String controlName2),clickAndVerifyNavigation(String navigatetopage,String pageTitle)
										  
	  Purpose of Method                 : Verify the perspective pod on home page
	  Dependencies	                   	: --
	  Reviewed By                       : --
	  @throws Exception 
	  **/
	@Test(description="Verify the perspective pod on home page", groups="Home Page")
	public void testHomePagePerspectivePod() {
	// navigate to Avaya Home page
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	// Verify the content in Perspectives pod section•Bolded Heading •Five
	// clickable images •Scroll down link with a downward arrow next to it
	// •Unified Communications and Collaboration link •Customer Experience
	// Managemen •Networking •All links
	businessFunction.get().checkCssProperty("PerspectivePOD_Title",
			"font-weight");
	// To verify the images present in the Perspectives pod
	businessFunction.get().imageValidation("PerspectivePOD_Images");
	// To verify whether the images are clickable
	businessFunction.get().verifyImagesClickable("PerspectivePOD_Images");
	// To verify the links Unified Communications and Collaboration,Customer
	// Experience Management,All,Networking
	businessFunction.get()
			.verifyMenuOrCategoryLinks("PerspectivePOD_Links");
	businessFunction.get().verifySubMenuElements(
			"PerspectivePOD_Links_All", "Tag_Anchors", ",");
	// To verify the Scroll Down link with a downward arrow
	verify.get().isTextPresent("PerspectivePOD_ScrollDownLink");
	// Click on Scroll down link and System should scroll the images
	// downwards
	businessFunction.get().checkPerspectivePODscroll(
			"HomePerspectivePODText", "Scroll");
	// To verify if the navigation of images
	businessFunction.get().verifyMenuOrCategoryLinks(
			"HomePage_PerspectivePod_FirstImageLinks");
	businessFunction.get().verifyMenuOrCategoryLinks(
			"HomePage_PerspectivePod_SecondImageLinks");
	businessFunction.get().verifyMenuOrCategoryLinks(
			"HomePage_PerspectivePod_ThirdImageLinks");
	// To verify the navigation of the links Unified Communications and
	// Collaboration,Customer Experience Management,All,Networking
	businessFunction.get().clickAndVerifyNavigation("HomePage_UnifiedLink",
			"HomePage_UnifiedLinkTitle");
	getDriver().navigate().back();
	dynamicWait.get().waittillpageloads();
	businessFunction.get().clickAndVerifyNavigation(
			"HomePage_CustomerLink", "HomePage_CustomerLinkTitle");
	getDriver().navigate().back();
	dynamicWait.get().waittillpageloads();
	businessFunction.get().clickAndVerifyNavigation(
			"HomePage_NetworkingLink", "HomePage_NetworkingLinkTitle");
	getDriver().navigate().back();
	dynamicWait.get().waittillpageloads();
	businessFunction.get().clickAndVerifyNavigation("HomePage_AllLink",
			"HomePage_AllLinkTitle");
	}

/** 
Author Name                       : Sindhuja
Date of Preparation               : 16/9/2014
Date of Modified                  : --
Methods Called                    : 
Purpose of Method                 : Verify the Flexi on Home page
Dependencies	                   	: --
Reviewed By                       : --

**/
@Test(description="Verify the Flexi on Home page", groups="Home Page")
public void testHomePageFlexi(){
	//navigate to app URL
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	//Verify the flexi on Home page
	businessFunction.get().validateFlexiImages("Flexi_Images", "Home_Footer");		
}



/**
  Author Name                       : Phanendra Ketavarapu
  Date of Preparation               : 25/06/2014
  Date of Modified                  : --
  Methods Called                    : clickOn(String controlName),isElementDisplayed(String ControlName) ,pageAllignment(String relativeControlName, String controlName, String position)
  Purpose of Method                 : Verifies the latest news section present in the home page
  Dependencies	                    : clickOn(userActions.get())
  Reviewed By                       : --
**/ 
@Test(description="Home_Page_Latest News",groups="Home Page")
public void testHomePageLatestNews()
{
	//Launch the avaya website
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	businessFunction.get().verifyMenuOrCategoryLinks("Footer_News_Parent");
	//verify latestnews section in the footer
	verify.get().isElementDisplayed("Footer_LatestNews");
	businessFunction.get().verifyMenuOrCategoryLinks("Footer_News_Parent");
	businessFunction.get().verifyLatestNewsTicker("Footer_News_Parent");
	//verify the quick links section
	verify.get().isTextPresent("Home_QuickLinks");
    //verify latest news section
	businessFunction.get().verifyMenuOrCategoryLinks("Footer_News_Parent");
 }

/** 
Author Name                       : Niharika
Date of Preparation               : 15/09/2014
Date of Modified                  : 
Methods Called                    : isTextPresent(Verify),checkCssProperty(businessFunction.get())
Purpose of Method                 : Verify whether All Fields Required should be displayed in proper color or not
Dependencies	                  : --
Reviewed By                       : --
TestCase name					  : wi01159736_6_Demand Gen Registration Page_Text for  mandatory fields
**/


@Test(description="Verify whether All Fields Required should be displayed in proper color or not",groups="Demand Gen page")
public void testDemandGenRegistrationPageText()
{
	// Launching the Avaya URL
	getDriver().get(appConfig.getDemandGenUrl());    	
	dynamicWait.get().waittillpageloads();
	//Verifying Demand Gen Registration page is opened or not
	businessFunction.get().contentValidation("DemandGeneral_Title");
	//Verifying whether All Fields Required text is displayed in the required color or not		
	businessFunction.get().checkCssProperty("AllFieldsRequiredText", "Color");
}

/** 
Author Name                       : Sindhuja
Date of Preparation               : 11-09-2014
Date of Modified                  : 
Methods Called                    : clickOn(Utilities), isTextPresent(Verify),sendinputdata(businessFunction)
Purpose of Method                 : Verify whether Thank you page is opened once submit the details
Dependencies	                    : --
Reviewed By                       : --
TestCase name					   : wi01159736_12_Demand Gen Registration Page_ Details Submission
**/


@Test(description="Verify whether Thank you page is opened once submit the details",groups="Demand Gen page")
public void testDemandGenRegistrationDetailPage()
{
	// Launching the Avaya URL
	getDriver().get(appConfig.getDemandGenUrl());    	  
	dynamicWait.get().waittillpageloads();
	//Verifying Demand Gen Registration page is opened or not
	businessFunction.get().contentValidation("DemandGeneral_Title");
	//Filling all the details in Demand Registration page and clicking on Submit button	
	businessFunction.get().sendinputdata("DemRegInputData", "demregistration", "demregistration");
	//Clicking on submit button
	userActions.get().clickOn("DemandSubmit");
	dynamicWait.get().waittillpageloads();
	//Verify the Thank you page
	verify.get().isTextPresent("DemandThankYou");
	
	
}


/** 
Author Name                       : Phani
Date of Preparation               : 16/09/2014
Date of Modified                  : --
Methods Called                    : isElementPresent,isTextPresent(Verify),clickOn(userActions.get()),clickOnSubMenuItem,checkUrl(businessfunction)
Purpose of Method                 : Verify links in Work Place
Dependencies	                  : --
Reviewed By                       : --
Test Case Name					  :  wi01152051_About Avaya_WorkPlace_links
**/

@Test(description="Verify links in Work Place",groups="About Avaya")
public void testAbtAvayaWorkPlaceLinks()
{
	// Launching the Avaya URL
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	verify.get().isElementPresent("HomePage_Logo");
	//Clicking on Worldwide Directory which is present in the AboutAvaya hover screen
	businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "AbtAvayaCorporateResponse", "CorporateResponsibilitypage");
	//Click on Country link and verify whether the respective page is landing and verify the respective fields information
	userActions.get().clickOn("WorkPlaceClick");
	dynamicWait.get().waittillpageloads();
	//Checking the Workplacehome page
	verify.get().isTextPresent("WorkPlaceHomePage");
	//Capturing the current URL into string variable
	String gCurrentURL = getDriver().getCurrentUrl();
	//String gCurrentURL = driver.getCurrentUrl();    	
	//Clicking on Diversity and Equal Opportunity link and verify whether PDF page is opened or not
	userActions.get().clickOn("DiversityEqualLink");
	dynamicWait.get().waittillpageloads();
	//Checking the DiversityEqualLink url
	businessFunction.get().verifyPdfUrl("DiversityEqualLink");
	getDriver().navigate().to(gCurrentURL);    	    	
	//Clicking on EmployeeBenefits link and verify the PDF URL
	userActions.get().clickOn("EmployeeBenefits");
	dynamicWait.get().waittillpageloads();
	//Checking the EmployeeBenefits url
	businessFunction.get().verifyPdfUrl("EmployeeBenefits");
	getDriver().navigate().to(gCurrentURL);
	//Clicking on AvayaCulture link and verify the heading
	userActions.get().clickOn("AvayaCulture");
	dynamicWait.get().waittillpageloads();
	//Verifying the OurCulture text
	verify.get().isTextPresent("OurCulture");
	getDriver().navigate().to(gCurrentURL);
	//Clicking on AvayaCodeOfConduct link and verify the PDF URL
	userActions.get().clickOn("AvayaCodeOfConduct");
	dynamicWait.get().waittillpageloads();
	//Verifying the AvayaCodeofConduct url
	businessFunction.get().verifyPdfUrl("AvayaCodeOfConduct");
	
}
/**
Author Name                       : Sindhuja.P
Date of Preparation               : 11/08/2014
Date of Modified                  : --
Methods Called                    : clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle),verifyBreadCrumb(String actualControlName, String expectedControlName,String tagName)
Purpose of Method                 : Verify the breadcrumb on Partner Locator  page
Dependencies	                    : Jar files
Reviewed By                       : --
**/

@Test(description="Verify the breadcrumb on Partner Locator  page",groups="Configuration & Provision")
public void testPartnerLocatorPageBreadcrumb()
{
	//Launching the Avaya Website
    getDriver().get(appConfig.getAppUrl());
    dynamicWait.get().waittillpageloads();
    //To hover on Partners tab of mega menu and click on 'Find an Avaya Partner'
  	businessFunction.get().clickOnSubMenuItem("Partners", "Partners_FindAPartner", "PartnerLocator_Title");
  	dynamicWait.get().waittillpageloads();
  	businessFunction.get().deFocus();
  	//To check the Bread crumb in the Partner Locator page.
  	businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "PartnerLocator_ExpectedBreadcrumb", "Tag_Anchors");
}

/**
Author Name                       : Sindhuja.P
Date of Preparation               : 11/08/2014
Date of Modified                  : --
Methods Called                    : isTextPresent(String controlName),checkCssProperty(String controlName, String cssProperty) 
                                    checkToggleMenuArrows(String actualControlName,String expectedControlName,String direction),verifySubMenuElements(String parentMenu,String subMenu,String delimiter)
Purpose of Method                 : Verify the expanded Sort By Section on Partner Locator Page
Dependencies	                    : Jar files
Reviewed By                       : --
**/

@Test(description="Verify the expanded Sort By Section on Partner Locator Page",groups="Configuration & Provision")
public void testPartnerLocatorPageSortByExpand()
{
	//Launching Partner Locator Page.
	getDriver().get(appConfig.getPartnerUrl());
    dynamicWait.get().waittillpageloads();
    //To check if Partner Locator Home Page is displayed
    verify.get().isTextPresent("PartnerLocator_Title");
    //To check if Sort By section is in closed state 
    businessFunction.get().checkCssProperty("PartnerLocator_SortBySection_Home", "display");
    //To check if Sort By section is with the arrow on the bar pointing downwards.
    businessFunction.get().checkToggleMenuArrows("PartnerLocator_SortBy", "Collapsed_Arrow", "down");
    //To click on the Sort By bar
    userActions.get().clickOn("PartnerLocator_SortBy");
    //To check if Sort By section is in expanded state 
    businessFunction.get().checkCssProperty("PartnerLocator_SortByArea", "display");
    //To check if the links are displayed in Sort By section
    businessFunction.get().verifySubMenuElements("PartnerLocator_SortByLinks", "Child_Label_Items", ",");
    //To check if Sort By section is with the arrow on the bar pointing upwards.
    businessFunction.get().checkToggleMenuArrows("PartnerLocator_SortBy", "Expanded_Arrow", "up");
	
}


/**
Author Name                       : Sindhuja.P
Date of Preparation               : 11/08/2014
Date of Modified                  : --
Methods Called                    : isTextPresent(String controlName),checkCssProperty(String controlName, String cssProperty) 
                                    checkToggleMenuArrows(String actualControlName,String expectedControlName,String direction)
Purpose of Method                 : Verify the closed state of Search Section on Partner Locator Page
Dependencies	                    : Jar files
Reviewed By                       : --
**/

@Test(description="Verify the closed state of Search Section on Partner Locator Page",groups="Configuration & Provision")
public void testPartnerLocatorPageSearchCollapse()
{
//Launching Partner Locator Page.
getDriver().get(appConfig.getPartnerUrl());
dynamicWait.get().waittillpageloads();
//To check if Partner Locator Home Page is displayed
verify.get().isTextPresent("PartnerLocator_Title");
//To check if Search section is in open state 
businessFunction.get().checkCssProperty("PartnerLocator_SearchSection", "display");
//To check if Sort By section is with the arrow on the bar pointing upwards
businessFunction.get().checkToggleMenuArrows("PartnerLocator_Search","Expanded_Arrow", "up");
//To click on the Search bar
userActions.get().clickOn("PartnerLocator_Search");
//To check if Sort By section is in closed state 
businessFunction.get().checkCssProperty("PartnerLocator_SearchBar", "display");
//To check if Sort By section is with the arrow on the bar pointing downwards.
businessFunction.get().checkToggleMenuArrows("PartnerLocator_Search","Collapsed_Arrow", "down");
}

/**
Author Name                       : Sowmya Mohanan
Date of Preparation               : 11/08/2014
Date of Modified                  : --
Methods Called                    : deFocus(),clickOn(String controlName),getDBConnection(),executeQuery(String query),waittillpageloads()
									compareValuesPresentInDatabase(String listName,ResultSet rs,String columnName)
Purpose of Method                 : Verify Country Drop Down values in Partner Locator page
Dependencies	                    : Jar files
Reviewed By                       : --

**/
	/*
	 * @Test(description =
	 * "Verify Country Drop Down values in Partner Locator page") public void
	 * testPartnerLocatorCountryDropdownValues(){ //Connecting to Database
	 * dbConnection.get().getDBConnection(); //Executing a Query in Database
	 * ResultSet rs = dbConnection.get().executeQuery(
	 * "SELECT DISTINCT b.Country_name,a.COUNTRY_LIST__C,b.ID  FROM SFR_PARTNER_ACCOUNT_MV a "
	 * + "JOIN SFR_PARTNER_COUNTRY b "+ "ON b.ID=a.COUNTRY_LIST__C "+
	 * "ORDER BY b.Country_name ASC"); //Lauch the Partner Locator Url
	 * getDriver().get(appConfig.getPartnerUrl());
	 * dynamicWait.get().waittillpageloads(); businessFunction.get().deFocus();
	 * //Click on Country Dropdown
	 * userActions.get().clickOn("Partner_CountryList");
	 * dynamicWait.get().waittillpageloads(); //Verify whether the Country
	 * dropdown contains the same values as present in database
	 * businessFunction.
	 * get().compareValuesPresentInDatabase("PartnerLocator_CountryDropDownList"
	 * , rs, "Country_name"); }
	 */


/**
Author Name                       : Sowmya Mohanan
Date of Preparation               : 12/08/2014
Date of Modified                  : --
Methods Called                    : deFocus(),clickOn(String controlName),getDBConnection(),executeQuery(String query),waittillpageloads()
									compareValuesPresentInDatabase(String listName,ResultSet rs,String columnName),
									verifyDropDownSelection(String dropDown, String valueToBeSelected),
Purpose of Method                 : Verify State/Province Drop Down values for Australia Country, in Partner Locator page
Dependencies	                    : Jar files
Reviewed By                       : --

**//*
@Test
public void testPartnerLocatorStateProvinceAustralia(){
	//Connecting to Database
				dbConnection.get().getDBConnection();
				//Executing a Query in Database
				ResultSet rs = dbConnection.get().executeQuery("SELECT Distinct c.state_name,b.Country_name,a.COUNTRY_LIST__C  FROM SFR_PARTNER_ACCOUNT_MV a "
						+"JOIN SFR_PARTNER_STATE c "
						+"ON c.country_id=a.COUNTRY_LIST__C "
						+"JOIN SFR_PARTNER_COUNTRY b "
						+"ON b.id=a.COUNTRY_LIST__C "
						+"AND b.country_name='Australia' "
						+"ORDER BY c.state_name ASC");
				//Lauch the Partner Locator Url
				getDriver().get(appConfig.getPartnerUrl());
				dynamicWait.get().waittillpageloads();
				businessFunction.get().deFocus();
				//Click on Country Dropdown and select Australia
				businessFunction.get().verifyDropDownSelection("Partner_CountryList", "Partner_CountrtyAustraliaSelect");		
				//Click on State Dropdown
				userActions.get().clickOn("Partner_StateList");
				dynamicWait.get().waittillpageloads();
				//Verify whether the State dropdown contains states under Australia and are same as present in database
				businessFunction.get().compareValuesPresentInDatabase("PartnerLocator_StateDropDownList", rs, "state_name");	
}*/

/**
Author Name                       : Sindhuja.P
Date of Preparation               : 13/08/2014
Date of Modified                  : --
Methods Called                    : isTextPresent(String controlName) ,verifyDropDownSelection(String dropDown, String valueToBeSelected)
                                    verifyStringLength(String controlName, int expectedLength),verifyTextEntered(String textField, String enteredText),enterText(String controlName,String text)
Purpose of Method                 : Verify the number of characters accepted in the Zipcode Text Box
Dependencies	                    : Jar files
Reviewed By                       : --
**/

@Test(description="Verify the number of characters accepted in the Zipcode Text Box",groups="Configuration & Provision")
public void testPartnerLocatorCityNameTextlength125Characters()
{
	//Launching Partner Locator Page.
	getDriver().get(appConfig.getPartnerUrl());
	dynamicWait.get().waittillpageloads();
	//To check if Partner Locator Home Page is displayed
	verify.get().isTextPresent("PartnerLocator_Title");
	//To select "India" from the "Country" Drop Down and to check if System has displayed the selected Option
	businessFunction.get().verifyDropDownSelection("Partner_CountryList", "Partner_CountrtyIndiaSelect");
	//To enter "Hyderabad" in the City Text Box and to check if system has accepted the input
	businessFunction.get().verifyTextEntered("PartnerLocator_CityField", "Hyderabad");
	//To enter Zipcode Having a text length equal to 125 Characters
	userActions.get().enterText("PartnerLocator_ZipCodeField", "12345698712365478912369854789654123698521478965412369258147896541236985471234569874561236547896541231234569871236547891236547");
	//To check if the system has accepted the input as it is
	verify.get().verifyStringLength("PartnerLocator_ZipCodeField",125);
}

/**
Author Name                       : Sindhuja.P
Date of Preparation               : 12/08/2014
Date of Modified                  : --
Methods Called                    : isTextPresent(String controlName),verifyAlertText(String expectedValue),clickAlertOk()
                                    verifyTextEntered(String textField, String enteredText),verifyDropDownSelection(String dropDown, String valueToBeSelected)
Purpose of Method                 : Verify if the System is able to display the Partner Results if  country is not selected
Dependencies	                    : Jar files
Reviewed By                       : --
**/

@Test(description="Verify if the System is able to display the Partner Results if  country is not selected",groups="Configuration & Provision")
public void testPartnerLocatorSearchInvalidCountry()
{
	//Launching Partner Locator Page.
	getDriver().get(appConfig.getPartnerUrl());
	dynamicWait.get().waittillpageloads();
	//To check if Partner Locator Home Page is displayed
	verify.get().isTextPresent("PartnerLocator_Title");
	//To enter "500032" in the "Zip/Postal Code" Text Box and to check if system has accepted the input
	businessFunction.get().verifyTextEntered("PartnerLocator_ZipCodeField", "500032");
	//To select "Please Select..." from the "Country" Drop Down and to check if System has displayed the selected Option
	businessFunction.get().verifyDropDownSelection("Partner_CountryList", "Partner_CountryPleaseSelect");
	//To click on "Search" Button
	userActions.get().clickOn("PartnerLocator_SearchButton");
	//To check if "Please select Country." error message is displayed
	verify.get().verifyAlertText("InvalidCountry_Text");
	userActions.get().clickAlertOk();
}



/**
Author Name                       : Sindhuja.P
Date of Preparation               : 12/08/2014
Date of Modified                  : --
Methods Called                    : isTextPresent(String controlName) ,verifyDropDownSelection(String dropDown, String valueToBeSelected)
                                    checkDistanceUnits(String distanceUnits)
Purpose of Method                 : Verify the Units of Distance for United States
Dependencies	                    : Jar files
Reviewed By                       : --
**/

@Test(description="Verify the Units of Distance for United States",groups="Configuration & Provision")
public void testPartnerLocatorSearchDistanceUnitedStatesUnits()
{
	//Launching Partner Locator Page.
	getDriver().get(appConfig.getPartnerUrl());
	dynamicWait.get().waittillpageloads();
	//To check if Partner Locator Home Page is displayed
	verify.get().isTextPresent("PartnerLocator_Title");
	//To select "United States" from the "Country" Drop Down and to check if System has displayed the selected Option
	businessFunction.get().verifyDropDownSelection("Partner_CountryList", "Partner_CountryUSASelect");
	//To enter "New York" in the City Text Box and to check if system has accepted the input
	businessFunction.get().verifyTextEntered("PartnerLocator_CityField", "New York");
	//To click on "Search" Button
	userActions.get().clickOn("PartnerLocator_SearchButton");
	try
	{
	Thread.sleep(40000);
	//To check if the distance in Miles is displayed under the Partner title
	businessFunction.get().checkDistanceUnits("miles");
}
	catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

/**
Author Name                       : Sindhuja.P
Date of Preparation               : 13/08/2014
Date of Modified                  : --
Methods Called                    : isTextPresent(String controlName) ,verifyDropDownSelection(String dropDown, String valueToBeSelected)
                                    checkDistanceUnits(String distanceUnits)
Purpose of Method                 : Verify the Units of Distance for India
Dependencies	                    : Jar files
Reviewed By                       : --
**/

@Test(description="Verify the Units of Distance for India",groups="Configuration & Provision")
public void testPartnerLocatorSearchDistanceIndiaUnits() 
{
	//Launching Partner Locator Page.
	getDriver().get(appConfig.getPartnerUrl());
	dynamicWait.get().waittillpageloads();
	//To check if Partner Locator Home Page is displayed
	verify.get().isTextPresent("PartnerLocator_Title");
	//To select "India" from the "Country" Drop Down and to check if System has displayed the selected Option
	businessFunction.get().verifyDropDownSelection("Partner_CountryList", "Partner_CountrtyIndiaSelect");
	//To enter "Ahmedabad" in the City Text Box and to check if system has accepted the input
	businessFunction.get().verifyTextEntered("PartnerLocator_CityField", "Ahmedabad");
	//To click on "Search" Button
	userActions.get().clickOn("PartnerLocator_SearchButton");
	try
	{
	Thread.sleep(40000);
	//To check if the distance in Kilometers is displayed under the Partner title
	businessFunction.get().checkDistanceUnits("km");
}
	catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}	 

 
/**
Author Name                       : Sowmya Mohanan
Date of Preparation               : 20/08/2014
Date of Modified                  : --
Methods Called                    : deFocus(),clickOn(String controlName),verifyElementIsChecked(String controlName),clickOn(String controlName),
									  verifyTextEntered(String textField, String enteredText),verifyPartnerDetails(),isElementNotDisplayed(String controlName),
									  isTextPresent(String controlName),checkToggleMenuArrows(String actualControlName,String expectedControlName,String direction)	  									 
Purpose of Method                 : Verify if the user is able to remove a filter of the Search Criteria",groups="Configuration & Provision
Dependencies	                    : Jar files
Reviewed By                       : --
**/

@Test(description="Verify if the user is able to remove a filter of the Search Criteria",groups="Configuration & Provision")
public void testPartnerLocatorDeleteFilter() 
{
	//Launching Partner Locator Page.
	getDriver().get(appConfig.getPartnerUrl());
	dynamicWait.get().waittillpageloads();
	//To check if Partner Locator Home Page is displayed
	verify.get().isTextPresent("PartnerLocator_Title");
	//To enter "New York" in the City Text Box and to check if system has accepted the input
	businessFunction.get().verifyTextEntered("PartnerLocator_CityField", "New York");
	//To check Contact Center checkbox under Solution 
	userActions.get().clickOn("ContactCenter_CheckBox");
	//To check if Contact Center checkbox is checked.
	verify.get().verifyElementIsChecked("ContactCenter_CheckBox");
	//To click on "Search" Button
	userActions.get().clickOn("PartnerLocator_SearchButton");
	try
	{
		Thread.sleep(40000);
		//To check if the selected Filter "Contact Center" is displayed.
		verify.get().isTextPresent("Filter_ContactCenter");
		//To check if a cross mark is displayed on the filter
		businessFunction.get().checkToggleMenuArrows("ContactCenterFilter_CrossMark", "CrossMark_Expected", "cross");
		//To click on the cross mark on "Contact Center" Filter
		userActions.get().clickOn("ContactCenterFilter_CrossMark");
		//To check if the cross marsk is not displayed.
		verify.get().isElementNotDisplayed("ContactCenterFilter_CrossMark");
	}
	catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

/** 
Author Name                       : Sivanag
Date of Preparation               : 13/08/2014
Date of Modified                  : 26-08-2014
Methods Called                    : isTextPresent,isElementPresent(verify),clickOn(userActions),
Purpose of Method                 : Verify the Partners in Customer Excellence when country, ZipCode and Solution are entered
Dependencies	                  	: --
Reviewed By                       : --
Test Case Name					:  Partner Locator_4 options Search combination_20
**/

@Test(description="Verify the Partners in Customer Excellence when country, ZipCode and Solution are entered",groups="Partners")
public void testPartnerFourOption()
{
	// Launching the Avaya URL
	getDriver().get(appConfig.getPartnerUrl());
	dynamicWait.get().waittillpageloads();
	// Verify whether Partner Locator page is opened or not  	
	verify.get().isTextPresent("PartnetLocatorHeading");
	//Selecting country value from the dropdown
	businessFunction.get().verifyDropDownSelection("Partner_CountryList","Partner_CountrtyUnitedStateSelect");  	
	//Enter the text into City field
	businessFunction.get().verifyTextEntered("PartnerZipCode","72914");  	
	//Check the checkbox of Contact Center
	userActions.get().clickOn("PartnerLocator_Networking");
	dynamicWait.get().waittillpageloads();
	//Check the Only Display check box
	userActions.get().clickOn("PartnerOnlyDisplay");
	dynamicWait.get().waittillpageloads();
	//Clicking on Search Button
	userActions.get().clickOn("PartnerLocator_SearchButton");
	try {
		Thread.sleep(25000);
		//Verify the Sort by text
		verify.get().isTextPresent("PartnerSortBy");
		//Verify the Partner Details
		businessFunction.get().verifyPartnerDetails();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

/** 
Author Name                       : Sivanag
Date of Preparation               : 12/08/2014
Date of Modified                  : --
Methods Called                    : isTextPresent,isElementPresent(verify),clickOn(userActions),
Purpose of Method                 : Verify  if the user is able to send a email to the Partner from the Search Results
Dependencies	                  	: --
Reviewed By                       : --
Test Case Name					:  Partner Locator_SearchList_Partner Email
**/

@Test(description="Verify  if the user is able to send a email to the Partner from the Search Results",groups="Partners")
public void testPartnerEmail()
{
  	// Launching the Avaya URL
  	getDriver().get(appConfig.getPartnerUrl());
  	dynamicWait.get().waittillpageloads();
  	// Verify whether Partner Locator page is opened or not  	
  	verify.get().isTextPresent("PartnetLocatorHeading");
  	//Enter the text into City field
  	userActions.get().enterText("PartnerCity","New York");
  	//Check the checkbox of Contact Center
  	userActions.get().clickOn("PartnerContactCenter");
  	dynamicWait.get().waittillpageloads();
  	//Clicking on Search Button
  	userActions.get().clickOn("PartnerLocator_SearchButton");
  	try {
		Thread.sleep(25000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  	//Verify the Sort by text
  	verify.get().isTextPresent("PartnerSortBy");
  	//Verify the Send Email
  	verify.get().isTextPresent("PartnerSendEmail");
  	//Clicking on Send Email link
  	userActions.get().clickOn("PartnerSendEmail");
  	dynamicWait.get().waittillpageloads();  	
  	//Verify the EmailPopup
  	verify.get().isElementPresent("PartnerEmailPopup");
  	
  }


/**
Author Name                       : Sowmya Mohanan
Date of Preparation               : 13/08/2014
Date of Modified                  : --
Methods Called                    : deFocus(),clickOn(String controlName),
									verifyTextEntered(String textField, String enteredText),verifyElementIsChecked(String controlName),
									pageAllignment(String relativeControlName, String controlName, String position),
									verifySubMenuElements(String parentMenu,String subMenu,String delimiter),verifySort(String order, String controlName)									
Purpose of Method                 : Verify the Partner Details are sorted as per the distance value
Dependencies	                    : Jar files
Reviewed By                       : --

**/
@Test(description = "Verify the Partner Details are sorted as per the distance value")
public void testPartnerLocatorDistanceReverseSort(){
	//Lauch the Partner Locator Url
	getDriver().get(appConfig.getPartnerUrl());
	dynamicWait.get().waittillpageloads();
	businessFunction.get().deFocus();
	//Enter a value in City field and verify if it is entered
	businessFunction.get().verifyTextEntered("PartnerLocator_CityField", "New York");
	//click on the Contact Center checkbox
	userActions.get().clickOn("PartnerLocator_ContactCenter");
	dynamicWait.get().waittillpageloads();
	//verify the Contact Center checkbox is checked
	verify.get().verifyElementIsChecked("PartnerLocator_ContactCenter");
	//click on Search button
	userActions.get().clickOn("PartnerLocator_SearchButton");
	try {
		Thread.sleep(25000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}						
	//verify the Sort Options section is displayed below the Sort By Tab
	businessFunction.get().pageAllignment("PartnerLocator_SortBySection", "PartnerLocator_SortOption", "above");
	//verify the Sort Options present under Sort By Tab
	businessFunction.get().verifySubMenuElements("PartnerLocator_SortOptionSection", "Child_Label_Items", ",");
	//click on the Distance link
	userActions.get().clickOn("PartnerLocator_Distance");
	//verify the partner details are sorted in ascending order as per the distance
	businessFunction.get().verifySort("ascending", "PartnerLocator_DistanceValues");
	//click on the Distance link
	userActions.get().clickOn("PartnerLocator_Distance");
	//verify the partner details are sorted in descending order as per the distance
	businessFunction.get().verifySort("descending", "PartnerLocator_DistanceValues");
}






/**
Author Name                       : Sindhuja.P
Date of Preparation               : 13/08/2014
Date of Modified                  : --
Methods Called                    : isTextPresent(String controlName) ,verifyTextEntered(String textField, String enteredText)
                                    pageAllignment(String relativeControlName, String controlName, String position),verifyPartnerLevels()
Purpose of Method                 : Verify the default sort  by Partner Level on the results fetched.
Dependencies	                    : Jar files
Reviewed By                       : --
**/

@Test(description="Verify the default sort  by Partner Level on the results fetched.",groups="Configuration & Provision")
public void testPartnerLocatorDefaultSortPartnerLevel() 
{
	//Launching Partner Locator Page.
	getDriver().get(appConfig.getPartnerUrl());
	dynamicWait.get().waittillpageloads();
	//To check if Partner Locator Home Page is displayed
	verify.get().isTextPresent("PartnerLocator_Title");
	//To enter "New York" in the City Text Box and to check if system has accepted the input
	businessFunction.get().verifyTextEntered("PartnerLocator_CityField", "New York");
	//To click on "Search" Button
	userActions.get().clickOn("PartnerLocator_SearchButton");
	try
	{
	Thread.sleep(40000);
	businessFunction.get().deFocus();
	//To check if search Results are displayed under the "Sort By" Tab
	businessFunction.get().pageAllignment("PartnerLocator_SortBy", "PartnerLocator_ResultsSection", "above");
	//To check if the results are displayed based on partner level
	businessFunction.get().verifyPartnerLevels();
}
	catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
@Test(description="Verify the Content present under the Overview tab",groups="Solutions")
public void testCapabilitiesDetailPageOverview()
{
	//Launching the Avaya Website
	getDriver().get(appConfig.getAppUrl());
	businessFunction.get().deFocus();
	//To clcik on the Video Collaboration link under the Capabilities tab
	businessFunction.get().clickOnSubMenuItem("Solutions", "Network_Virtualization", "Network_Virtualization_Header");
	businessFunction.get().deFocus();
	dynamicWait.get().waittillpageloads();
	//To verify whether the Overview tab has been selected by default
	businessFunction.get().checkSelectedTabActive("VideoCollaborationParentTab", "Tag_List", "OVERVIEW");
	//To verify whether User is be able to view the Overview, Corecomponents, Casestudies and Documents and Videos tab
	businessFunction.get().verifySubMenuElements("VideoCollaborationParentTabList", "Tag_List", ",");
	//To verify whether the Image of the first pod is present on the left side of the page and the Text is present is present on the right side of the page
	businessFunction.get().pageAllignment("ButlerBar", "FirstPodImage", "left");
	businessFunction.get().pageAllignment("FirstPodImage", "FirstPodText", "right");
	//To verify whether the Text of the first pod is present on the left side of the page and the Image is present is present on the right side of the page
	businessFunction.get().pageAllignment("ButlerBar", "SecondPodText", "left");
	businessFunction.get().pageAllignment("SecondPodText", "SecondPodImage", "right");
	//To verify whether the Image of the first pod is present on the left side of the page and the Text is present is present on the right side of the page
	businessFunction.get().pageAllignment("ButlerBar", "ThirdPodImage", "left");
	businessFunction.get().pageAllignment("ThirdPodImage", "ThirdPodText", "right");
	//To verify whether the Text of the first pod is present on the left side of the page and the Image is present is present on the right side of the page
	businessFunction.get().pageAllignment("ButlerBar", "FourthPodText", "left");
	businessFunction.get().pageAllignment("FourthPodText", "FourthPodImage", "right");
	//To verify whether the Image of the first pod is present on the left side of the page and the Text is present is present on the right side of the page
	businessFunction.get().pageAllignment("ButlerBar", "FifthPodImage", "left");
	businessFunction.get().pageAllignment("FifthPodImage", "FifthPodText", "right");
	//To verify whether Each promotional pod contains a image or video 
	businessFunction.get().checkImageOrVideo("SecondPodImage");
	businessFunction.get().checkImageOrVideo("ThirdPodImage");
	businessFunction.get().checkImageOrVideo("FourthPodImage");
	businessFunction.get().checkImageOrVideo("FifthPodImage");
	//To verify whether 3 baseball pods are present or not
	businessFunction.get().verifyMinimumCountOfElements("AllBaseBallPodsForCount", 1);
	//To verify whether 3 baseball pods above footer
	businessFunction.get().pageAllignment("ThreeBaseBallPods", "GlobalFooter", "above");
	
}
/**
Author Name                       : Sowmya Mohanan
Date of Preparation               : 12/08/2014
Date of Modified                  : --
Methods Called                    : deFocus(),clickOn(String controlName),verifyExpertBadgeOrder()
									verifyTextEntered(String textField, String enteredText),verifyElementIsChecked(String controlName)	  									
Purpose of Method                 : Verify the Expert Badge present in Solution column is displayed in Sorted order, in Partner Locator page
Dependencies	                    : Jar files
Reviewed By                       : --

**/
@Test(description = "Verify the Expert Badge present in Solution column is displayed in Sorted order, in Partner Locator page")
public void testPartnerLocatorSortWithSolutionExpertBadge(){
	//Lauch the Partner Locator Url
	getDriver().get(appConfig.getPartnerUrl());
	dynamicWait.get().waittillpageloads();
	businessFunction.get().deFocus();
	//Enter a value in City field and verify if it is entered
	businessFunction.get().verifyTextEntered("PartnerLocator_CityField", "New York");
	//click on the Contact Center checkbox
	userActions.get().clickOn("PartnerLocator_ContactCenter");
	dynamicWait.get().waittillpageloads();
	//verify the Contact Center checkbox is checked
	verify.get().verifyElementIsChecked("PartnerLocator_ContactCenter");
	//click on Search button
	userActions.get().clickOn("PartnerLocator_SearchButton");
	try {
		Thread.sleep(25000);
		//verify the expert badge in descending order
		businessFunction.get().verifyExpertBadgeOrder();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
	/** 
	  Author Name                       : @author pankaj
	  Date of Preparation               : 19/08/2014
	  Date of Modified                  : 08/09/2014
	  Methods Called                    : clickAndVerifyNavigation(String navigatetopage,String pageTitle)
	  									  productsAndArticlesOnLoadMore(String firstPageProducts,String viewAllPageProducts,String clickOnElement)
	  Purpose of Method                 : Verify the display of more than 24 articles on Perspectives Landing Page.
	  Dependencies	                   	: --
	  Reviewed By                       : --
	 
	 * @throws Exception 
	  
	**/
	@Test(description="Verify the display of more than 24 articles on Perspectives Landing Page.", groups="Perspectives")
	public void testPerspectivesLoadmorearticles()  {
		//navigate to app URL
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		//click on perspectives tab and verify perspectives title
		businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "Perspectives_SubMenu", "PerspectivesTitlePage");
		//To click on load more articles and check whether all the articles are displayed
		businessFunction.get().productsAndArticlesOnLoadMore("Perspectives_ArticlesBeforeLoadMore", "Perspectives_ArticlesAfterLoadMore", "Perspectives_ArticlesLoadMore");
	    }

	/** 
	  Author Name                       : @author karthik_b14
	  Date of Preparation               : 10/06/2014
	  Date of Modified                  : --
	  Methods Called                    : clickAndVerifyNavigation(String navigatetopage,String pageTitle),pageAllignment(String relativeControlName, String controlName, String position)
	  									  productsPagination(String secondPageSection,String firstPageSection,String previousLink)
	  Purpose of Method                 : Verify functionality of prev link
	  Dependencies	                   	: --
	  Reviewed By                       : --	  
   **/
  @Test(description="Verify functionality of prev link", groups="Perspectives")
  public void testPerspectivesMagzcheckprevlinkfunct()
  {
  	//navigate to app URL
  	getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		businessFunction.get().getValueOfHtmlAttribute("AvayaTitlePage", "title");
		//Click on 'Perspectives' tab of mega menu. System should navigate to Perspectives Landing Page
		businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "Perspectives_SubMenu", "PerspectivesTitlePage");
		//Click on Magazines and guides
		businessFunction.get().clickAndVerifyNavigation("Perspectives_addl_links_mags_guides", "Perspectives_mags_guides_titlepage");
		//To validate if prev link is present before Pagination
		businessFunction.get().pageAllignment("Magz_Pagination_Prevlink", "Magz_Pagination", "right");
		//To click on 2nd link in Pagination
		userActions.get().clickOn("Magz_Pagination_Secondlink");
		//To Click on Prev link and check if results of Previous page are displayed.
		businessFunction.get().paginationValidation("Magz_Pagination_SecondPage", "Magz_Pagination_FirstPage","Magz_Pagination_Prevlink");
  	}
  
  
  /** 
  Author Name                      : Vinusha Tanuku
 Date of Preparation               : 21/08/2014
 Date of Modified                  : 10/09/2014
 Methods Called                    : clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle),
 									  checkSelectedTabActive(String tabSection, String tabs,String str_selectedtabname) 
 									  verifyMenuOrCategoryLinks(String controlName)
 Purpose of Method                 : Verify if the user is able to view the Resource Article under products.
 Dependencies                      : --
 Reviewed By                       : --

 **/
 @Test(description="Verify if the user is able to view the Resource Article under products")
 public void testProductsDetailPageResourcesViewArticle() 
 {
	//To launch the Avaya URL
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();      
	//To hover on Products and click on the submenu Avaya Aura Platform
	businessFunction.get().clickOnSubMenuItem("Products","Products_AvayaAuraPlatform","Products_AvayaAuraPlatform_Title");
	businessFunction.get().deFocus();
	//To click on the Document and Videos tab
	userActions.get().clickOn("DocumentandVideos_tab");
	//To verify whether the Documents and Videos tab is selected or not
	businessFunction.get().checkSelectedTabActive("Products_AAP_ParentTab", "Products_AAP_Tabs_Child", "RESOURCES");
	dynamicWait.get().waittillpageloads();   
	
	businessFunction.get().verifyMenuOrCategoryLinks("Products_Docandvideos_Article");			  
 }
 
 /** 
 Author Name                       : Pankaj
 Date of Preparation               : 14/08/2014
 Date of Modified                  : --
 Methods Called                    : clickOn(Utilities),waittillpageloads(DynamicWait),isTextPresent(Verify),clickOnSubMenuItem,chatPopupCheck(businessFunction)
 Purpose of Method                 : Verify the functionality of chat link
 Dependencies	                  : --
 Reviewed By                       : --
 Test Case Name					  :  Products_Detail Page_Chat Link Functionality

 **/

 @Test(description="Verify the functionality of chat link",groups="Products")
 public void testProductsChatLink()
 {
 	// Launching the Avaya URL
 	getDriver().get(appConfig.getAppUrl());
 	dynamicWait.get().waittillpageloads();
 	// Click on Products link and verify whether Products page is opening or not
 	userActions.get().clickOn("Products");
 	dynamicWait.get().waittillpageloads();
 	//Verifying the Products label
 	verify.get().isTextPresent("Products_label");			
 	//Clicking on AvayaAuraCallCenterElite which is present in the Products hover screen
 	businessFunction.get().clickOnSubMenuItem("Products", "AvayaAuraCallCenterElitePopUp", "AvayaAuraCallCenterEliteHomePage");
 	// Click on Live Chat link and validate
 	try {
		businessFunction.get().chatPopupCheck("ChatIcon","ClickonIcon");
	} catch (ParseException | InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 	
 	
 }

 /**
 Author Name                       : Phanendra Ketavarapu
 Date of Preparation               : 27/06/2014
 Date of Modified                  : --
 Methods Called                    : clickOn(String controlName),isElementDisplayed(String ControlName) ,pageAllignment(String relativeControlName, String controlName, String position)
 Purpose of Method                 : Verifies Feedback button on home page
 Dependencies	                    : clickOn(userActions.get())
 Reviewed By                       : --
**/ 
@Test(description="Home_Page_Feedback",groups="Home Page")
public void testHomePageFeedbackCloseButton() throws InterruptedException
{
	//Launch the avaya website
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	//Wait till the feedback widget load 
	Thread.sleep(8000);
	//click on Feedback button
	userActions.get().clickOn("HomePage_Feedback");
	Thread.sleep(3000);
	//switch to frame
   userActions.get().switchToFrame("HomePage_Feedback_Frame");
   //Select satisfied radio button
	userActions.get().clickOn("Feedback_Satisfied");
	dynamicWait.get().waittillpageloads();
	//enter comments
	userActions.get().enterText("Feedback_text","QA_Test_Automation_Feedback");
	//click on submit button
   userActions.get().clickOn("Feedback_Submit_Button");
   dynamicWait.get().waittillpageloads();
   //verify thankyou message
   //verify.get().isTextPresent("Feedback_Thankyou_Message");
   userActions.get().switchToDefaultContent();
   //click in the cross button to close
   userActions.get().clickOn("Feedback_CrossButton");
	dynamicWait.get().waittillpageloads();
   //verify if feedback widget is closed 
   verify.get().isElementNotDisplayed("HomePage_Feedback_Frame");
}

/** 
Author Name                      : Vinusha Tanuku
Date of Preparation               : 15/06/2014
Date of Modified                  : 10/09/2014
Methods Called                    : contentValidation(String controlName),clickAndVerifyNavigation(String navigatetopage,String pageTitle)
									  isTextPresent(String controlName),imageValidation(String imageControlName)
									  verifyMenuOrCategoryLinks(String controlName)
Purpose of Method                 : Verify the contents of Professional Services Promotional Pod on Service Landing page.
Dependencies                      : --
Reviewed By                       : --
**/
@Test(description="Verify the contents of Professional Services Promotional Pod on Service Landing page.")
public void testServicesPromotionalPodsProfessionalServices()
{
	//To launch the Avaya URL
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();   
	//To click on Services menu and to verify the navigation of the title on the Services landing page.
	businessFunction.get().clickAndVerifyNavigation("Services", "Service_label");
	//To verify the title of the Professional Services pod
	verify.get().isTextPresent("ProfessionalServices_PromotionalPods_Title");
	//To verify the content of the professional Services pod
	businessFunction.get().contentValidation("ProfessionalServices_PromotionalPods_Text");
	//To verify the static image present on the Professional Services pod
	businessFunction.get().imageValidation("ProfessionalServices_PromotionalPods_Image");
	//To verify the presence of 'Explore Professional services>' CTA on the Professional Services pod
	businessFunction.get().verifyMenuOrCategoryLinks("ExploreProfessionalServices_button");
	businessFunction.get().clickAndVerifyNavigation("ExploreProfessionalServices_button", "ExploreProfessionalServices_title"); 
}


/**
Author Name                       :Pankaj
Date of Preparation               : 02/08/2014
Date of Modified                  : --
Methods Called                    : deFocus(String controlName),clickOn(String controlName),
									verifyResoureContent(String controlName,String expected, String isImgVideo)
									clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle)
Purpose of Method                 : Verify the Videos displayed in Resources tab present in Services/Contact Center Optimization
Dependencies	                    : Jar files
Reviewed By                       : --
**/
@Test(description = "Verify the Videos displayed in Resources tab present in Services/Contact Center Optimization", groups = "Services")
public void testServiceDetailResourcesVideos(){
	//Launching the Avaya website
	getDriver().get(appConfig.getAppUrl());		
	//Hover on Service and Click on Contact Center Optimization
	dynamicWait.get().waittillpageloads();
	businessFunction.get().deFocus();
	businessFunction.get().clickOnSubMenuItem("Services_MegaMenu", "ContactCenterOptimization", "ContactCenterOptimization_Title");
	businessFunction.get().deFocus();
	//Click on Documents and Videos Tab
	dynamicWait.get().waittillpageloads();
	userActions.get().clickOn("DocumentandVideos_tab");
	//Check the Video section in Documents and Videos Tab
	dynamicWait.get().waittillpageloads();
	//businessFunction.get().verifyResoureContent("AboutAvaya_ResourceTabVideoContent", "Description_FontSize","video");
}

/**
Author Name                       : Sowmya Mohanan
Date of Preparation               : 07/07/2014
Date of Modified                  : --
Methods Called                    : clickOn(String controlName),switchToChildWindow()
									switchToParentWindow(),sharingArticle(String controlName, String option)
Purpose of Method                 : Verify that a Article can be shared in Twitter in a Perspective Article page
Dependencies	                    : Jar files
Reviewed By                       : --

**/
@Test(description = "Verify that a Article can be shared in Twitter in a Perspective Article page", groups = "Perspectives")
public void testPerspectivesDetailPageShareTwitter(){
	//Launching the Avaya website
	getDriver().get(appConfig.getAppUrl());
	//Click on Perspective MegaMenu
	dynamicWait.get().waittillpageloads();
	businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "Perspectives_SubMenu", "PerspectivesTitlePage");
	//Click on Perspective Article
	dynamicWait.get().waittillpageloads();
//	userActions.get().clickOn("Perspectives_article");
	businessFunction.get().verifyArticleNavigation("Perspectives_ArticleList", "Perspectives_ArticleHeader");
	//Click on Twitter Icon	
	dynamicWait.get().waittillpageloads();
	userActions.get().clickOn("Perspective_article_twitter");
	//Share article in Twitter site
	businessFunction.get().shareArticleInSocialSites("TwitterPlusData", "twitter");
	//Check the Shared Link in Twitter page
	getDriver().get(appConfig.getTwitterUrl());		
	businessFunction.get().validateSharedArticleInSocialSites("TwitterPlusData", "twitter");
}

/**
Author Name                       : Sowmya Mohanan
Date of Preparation               : 20/06/2014
Date of Modified                  : --
Methods Called                    : clickOn(String controlName),isElementDisplayed(String ControlName) ,checkRelatedArticlesInArticlePage(String topicArticlescontrolName, String topicRelatedArticlescontrolName)
Purpose of Method                 : Verify the Related Articles present in a Perspective Article page
Dependencies	                    : Jar files
Reviewed By                       : --
**/
@Test(description = "Verify the Related Articles present in a Perspective Aritcle page",groups = "Perspectives")
public void testPerspectivesDetailPageRelatedArticles(){
	//Launching the Avaya website
	getDriver().get(appConfig.getAppUrl());
	//Click on Perspective MegaMenu
	dynamicWait.get().waittillpageloads();
	businessFunction.get().deFocus();
	businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "Perspectives_SubMenu", "PerspectivesTitlePage");
	//Click on Perspective Article
	dynamicWait.get().waittillpageloads();
	businessFunction.get().verifyArticleNavigation("Perspectives_ArticleList", "Perspectives_ArticleHeader");
	//check the related articles
	dynamicWait.get().waittillpageloads();
	businessFunction.get().checkRelatedArticlesInArticlePage("Perspectives_article_topic", "Perspectives_relatedArticle_topic");
}

/**
Author Name                       : Sowmya Mohanan
Date of Preparation               : 20/06/2014
Date of Modified                  : 26/06/2014
Methods Called                    : clickOn(String controlName),switchToChildWindow()
									switchToParentWindow(),sharingArticle(String controlName, String option)
Purpose of Method                 : Verify that a Article can be shared in Facebook in a Perspective Article page
Dependencies	                    : Jar files
Reviewed By                       : --
**/
@Test(description = "Verify that a Article can be shared in Facebook in a Perspective Article page",groups = "Perspectives")
public void testPerspectivesDetailPageShareFacebook(){
	//Launching the Avaya website
	getDriver().get(appConfig.getAppUrl());
	//Click on Perspective MegaMenu
	dynamicWait.get().waittillpageloads();
	businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "Perspectives_SubMenu", "PerspectivesTitlePage");
	//Click on Perspective Article
	dynamicWait.get().waittillpageloads();
	businessFunction.get().deFocus();
//	userActions.get().clickOn("Perspectives_article");
	businessFunction.get().verifyArticleNavigation("Perspectives_ArticleList", "Perspectives_ArticleHeader");
	//Click on Facebook Icon
	dynamicWait.get().waittillpageloads();
	userActions.get().clickOn("Perspective_article_facebook");
	//Share the article in facebook site
	businessFunction.get().shareArticleInSocialSites("FacebookPlusData", "facebook");
	//Check the Shared Link in Facebook page
	getDriver().get(appConfig.getFacebookUrl());
	businessFunction.get().validateSharedArticleInSocialSites("FacebookPlusData", "facebook");
}

/** 
Author Name                       : Sowmya
Date of Preparation               : 16/09/2014
Date of Modified                  : --
Methods Called                    : clickOn,hoverOn,switchToParentWindow,switchToChildWindow(Utilities),waittillpageloads(DynamicWait),isTextPresent(Verify),checkUrl(businessFunction)
Purpose of Method                 : Verify all the functionalities of the Social sharing icons on the global footer
Dependencies	                  : --
Reviewed By                       : --
Test Case Name					  :  Functionality of social media icons (Global Footer)
**/

@Test(description = "Verify all the functionalities of the Social sharing icons on the global footer", groups = "Home Page")
public void testSocialIcons() {
	// Launching the Avaya URL
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	// Verifying Twitter
	userActions.get().clickOn("Twitter");
	dynamicWait.get().waitForChildWindows();
	// Switching to child window
	userActions.get().switchToChildWindow();
	// Verifying the Twitter url
	businessFunction.get().checkUrl("Twitter", "contains");
	// Closing the child window
	userActions.get().closeChildWindowBrowserDependent();

	// Verifying FaceBook
	userActions.get().clickOn("FaceBook");
	dynamicWait.get().waitForChildWindows();
	// Switching to child window
	userActions.get().switchToChildWindow();
	// Checking Facebook url
	businessFunction.get().checkUrl("FaceBook", "contains");
	// Closing the child window
	userActions.get().closeChildWindowBrowserDependent();

	// Verifying YouTube
	userActions.get().clickOn("YouTube");
	dynamicWait.get().waitForChildWindows();
	// Switching to child window
	userActions.get().switchToChildWindow();
	// Checking Youtube url
	businessFunction.get().checkUrl("YouTube", "contains");
	// Closing the child window
	userActions.get().closeChildWindowBrowserDependent();

	// Verifying LinkedIn
	userActions.get().clickOn("LinkedIn");
	dynamicWait.get().waitForChildWindows();
	// Switching to child window
	userActions.get().switchToChildWindow();
	// Checkign the LinkedIn url
	businessFunction.get().checkUrl("LinkedIn", "contains");
	// Closing the child window
	userActions.get().closeChildWindowBrowserDependent();

	// Verifying AvayaIcon
	userActions.get().clickOn("AvayaIcon");
	dynamicWait.get().waitForChildWindows();
	// Switching to child window
	userActions.get().switchToChildWindow();
	// Checking the AvayaIcon url
	businessFunction.get().checkUrl("AvayaIcon", "contains");
	// Closing the child window
	userActions.get().closeChildWindowBrowserDependent();

	// Verifying GooglePlus
	userActions.get().clickOn("GooglePlus");
	dynamicWait.get().waitForChildWindows();
	// Switching to child window
	userActions.get().switchToChildWindow();
	// Checking the Googleplus url
	businessFunction.get().checkUrl("GooglePlus", "contains");
	// Closing the child window
	userActions.get().closeChildWindowBrowserDependent();

	// Verifying Pinterest
	userActions.get().clickOn("Pinterest");
	dynamicWait.get().waitForChildWindows();
	// Switching to Child window
	userActions.get().switchToChildWindow();
	// Checking the Pinterrest url
	businessFunction.get().checkUrl("Pinterest", "contains");
	// Closig the child window
	userActions.get().closeChildWindowBrowserDependent();

}
/**
Author Name                       : Sowmya Mohanan
Date of Preparation               : 11/07/2014
Date of Modified                  : 15-09-2014
Methods Called                    : clickOn(String controlName),switchToChildWindow(),closeChildWindow()
									sharingArticleInSocialSites(String controlName, String option, String shareText)
Purpose of Method                 : Verify that a Article can be shared in PInterest in a Perspective Article page
Dependencies	                    : Jar files
Reviewed By                       : --

**/
@Test(description = "Verify that a Article can be shared in PInterest in a Perspective Article page", groups = "Perspectives")
public void testPerspectivesDetailPageSharePInterest() {
	//Launching the Avaya website
	getDriver().get(appConfig.getAppUrl());
	//Click on Perspective MegaMenu
	dynamicWait.get().waittillpageloads();
	businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "Perspectives_SubMenu", "PerspectivesTitlePage");
	//Click on Perspective Article
	dynamicWait.get().waittillpageloads();
//	userActions.get().clickOn("Perspectives_article");
	businessFunction.get().verifyArticleNavigation("Perspectives_ArticleList", "Perspectives_ArticleHeader");
	//Verify the Images on the page for Pinterest
	businessFunction.get().verifyImageForPinterest();
	//Click on Pinterest Icon
	dynamicWait.get().waittillpageloads();
	userActions.get().clickOn("Perspective_article_pinterest");
	//Share the Link
	businessFunction.get().shareArticleInSocialSites("PinterestPlusData", "pinterest");
	//Check the Shared Link in PInterest page
	getDriver().get(appConfig.getpInterestUrl());		
	businessFunction.get().validateSharedArticleInSocialSites("PinterestPlusData", "pinterest");	
}

/** 
Author Name                       : Sindhuja
Date of Preparation               : 16/09/2014
Date of Modified                  : --
Methods Called                    : 
Purpose of Method                 : Verify the presence of mega menu bar on home page
Dependencies	                   	: --
Reviewed By                       : --
@throws Exception 
**/
@Test(description="Verify the presence of mega menu bar on home page", groups="Home Page")
public void testHomePageMegaMenuBar() {
// navigate to app url
getDriver().get(appConfig.getAppUrl());
dynamicWait.get().waittillpageloads();
// verify butler bar
verify.get().isElementPresent("ButlerBar");
// verify width of butler bar is same as mega menu
businessFunction.get().checkWidth("ButlerBar", "Home_MegaMenu");
// verify home page logo
businessFunction.get().imageValidation("HomePage_Logo");
/*
* Verify the content present in the mega menu bar and The following
* content should be present in the mega menu •Avaya Logo •Products
* •Services •Capabilities •Perspectives •Partners •About Avaya
*/
businessFunction.get()
		.validateMegamenuLinks("HomePage_MegaMenu_Header");
userActions.get().hoverOn("Products");
/*
* Verify the clickable links under products megamenu and rollout should
* be displayed with categories and sub categories •Categories should be
* clickable •Sub categories should not be clickable •Product links
* should be clickable
* 
*/
verify.get().isElementPresent("HomePage_Products_Flyout");
verify.get().isElementPresent("HomePage_Products_Flyout_Categories");
verify.get().isElementPresent("HomePage_Products_Flyout_subcategories");
verify.get().isElementPresent("HomePage_Products_Flyout_Prdctlinks");

}
@Test(description = "Verify the videos listing in the resources page", groups = "Solutions")
public void testCapabilitiesDetailPageResourcesVideos() {
    // navigate to app URL
    getDriver().get(appConfig.getAppUrl());
    dynamicWait.get().waittillpageloads();
    // click on Network Virtualization tab
    businessFunction.get().clickOnSubMenuItem("Solutions", "Network_Virtualization", "Network_Virtualization_Header");
    // click on documents and videos tab
    userActions.get().clickOn("DocumentandVideos_tab");
    // verify date published, title, description of the video
    businessFunction.get().contentValidation(
                  "Network_Virtualization_DocAndVideos_VideosDate");
    businessFunction.get().contentValidation(
                  "Network_Virtualization_DocAndVideos_VideosTitle");
    businessFunction.get().contentValidation(
                  "Network_Virtualization_DocAndVideos_VideosDescription");
    // Verify the company's video/ image/logo displayed in the video
    verify.get().verifyIcons(
                  "Network_Virtualization_DocAndVideos_PlayIconImage",
                  "Video_PlayIcon.PNG");
    // Verify the order of videos to be displayed
    businessFunction.get().verifyDatesInDescendingOrder(
                  "Network_Virtualization_DocAndVideos_Dates");
    // To verify the content   
    businessFunction.get().contentValidation(
                  "Network_Virtualization_DocAndVideos_Paragraphs");
    userActions.get().clickOn("VideoCollaboration_Video");
    // click on video and verify video
    verify.get().verifyVideo();


}
/**
Author Name                       : Sindhuja.P
Date of Preparation               : 15/09/2014
Date of Modified                  : 
Methods Called                    : isTextPresent(String controlName),clickAndVerifyNavigation(String navigatetopage,String pageTitle)
									  pageAllignment(String relativeControlName, String controlName, String position),isElementDisplayed(String controlName)
									  verifyBreadCrumb(String actualControlName, String expectedControlName,String tagName),imageValidation(String imageControlName)
									  verifySubMenuElements(String parentMenu,String subMenu,String delimiter)
									  contentValidation(String controlName),verifyPartnerAndProductPods(String controlName, String Child)
									  verifyMenuOrCategoryLinks(String controlName),socialIcons(String controlName,String childElement,String attribute)
Purpose of Method                 : Verify if the user is able to View CostBasisAnalysis on Avaya website
Dependencies	                    : Jar files
Reviewed By                       : --
 
 
**/

@Test(description="Verify if the user is able to View CostBasisAnalysis on Avaya website",groups="Investors")
public void testInvestorsShareHolderServicesCostBasisAnalysis() 
{
	//Launching the Investors Avaya website
	getDriver().get(appConfig.getInvUrl());
	dynamicWait.get().waittillpageloads();
	//To click on Cost Basis Analysis and check the presence of title
	businessFunction.get().clickAndVerifyNavigation("Investors_CostBasisAnalysis", "Investors_CostBasisAnalysis_Title");
	dynamicWait.get().waittillpageloads();
	//To check the presence of title to left side of page 
	businessFunction.get().pageAllignment("ButlerBar", "Title_Allignment", "equal");
	//To check the presence of Butler bar 
	verify.get().isElementDisplayed("ButlerBar");
	//To check the presence of Global Header 
	verify.get().isElementDisplayed("Investors_CostBasisAnalysis_GlobalHeader");
	//To check the presence of Breadcrumb 
	businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual","Investors_CostBasisAnalysis_ExpectedBreadcrumb","Tag_List");
	//To check the presence of Bread crumb to left side of the page.
	businessFunction.get().pageAllignment("ButlerBar", "Breadcrumb_Actual","equal");
	//To check the presence of sub title 
	verify.get().isTextPresent("Investors_CostBasisAnalysis_SubTitle");
	//To check the presence of sub title below title  
	businessFunction.get().pageAllignment("Investors_CostBasisAnalysis_Title", "Investors_CostBasisAnalysis_SubTitle","equal");
	//To check the presence of Contact Information to the right of page 
	verify.get().isTextPresent("Investors_ContactInformation_Button");
	businessFunction.get().pageAllignment("ButlerBar", "Investors_ContactInformation_Button", "right");
	//To check the presence of Hero image 
	businessFunction.get().imageValidation("Investors_CostBasisAnalysis_Image");
	//To check the presence of Toggle menu with options 
	businessFunction.get().verifySubMenuElements("Investors_CostBasisAnalysis_ToggleMenu", "Tag_Span",",");
	//To check the presence of text description
	businessFunction.get().contentValidation("Investors_CostBasisAnalysis_Description");
	//To check the presence of links with image and size of the file
	businessFunction.get().verifyMenuOrCategoryLinks("Investors_CostBasisAnalysis_FirstLink");
	businessFunction.get().verifyMenuOrCategoryLinks("Investors_CostBasisAnalysis_SecondLink");
	verify.get().verifyIcons("Investors_CostBasisAnalysis_FirstLink_Image", "icon_pdf.gif");
	verify.get().verifyIcons("Investors_CostBasisAnalysis_SecondLink_Image", "icon_pdf.gif");
	//To check the presence of Related products pod,Contact Info pod,How to Buy pod 
	businessFunction.get().verifyPartnerAndProductPods("Investors_CostBasisAnalysis_Pods", "Tag_Anchors");
	//To check the presence of Global footer 
	verify.get().isElementDisplayed("GlobalFooter");
	//To check the presence of Social Media icons 
	businessFunction.get().socialIcons("FooterSocialIcons","Tag_Anchors","href");	
}

/**
Author Name                       : Sindhuja.P
Date of Preparation               : 15/09/2014
Date of Modified                  : 
Methods Called                    : pageAllignment(String relativeControlName, String controlName, String position),deFocus(String controlName)
                                    clickAndVerifyNavigation(String navigatetopage,String pageTitle),socialIcons(String controlName) 
                                    isElementDisplayed(String controlName),isTextPresent(String controlName) , verifyBreadCrumb(String actualControlName, String expectedControlName,String tagName) 
                                    isTextPresent(String controlName),imageValidation(String imageControlName),verifySubMenuElements(String parentMenu,String subMenu,String delimiter)
                                    checkIconsPresent(String parentControlName,String childControlName),socialIcons(String controlName,String childElement,String attribute) 
Purpose of Method                 : Verify the Investors SEC Filings Page
Dependencies	                    : Jar files
Reviewed By                       : --
**/

@Test(description="Verify the Investors Landing Page",groups="Investors")
public void testInvestorsSECFilings() 
{
	//Launching the Investors Avaya website
	getDriver().get(appConfig.getInvUrl());
	dynamicWait.get().waittillpageloads();
	//click on SEC Filings and check the title in the navigated page
	businessFunction.get().clickAndVerifyNavigation("Investors_SECFilings", "SECFilings_Title");
	dynamicWait.get().waittillpageloads();
	businessFunction.get().deFocus();
	//To check the presence of Butler bar		
	verify.get().isElementDisplayed("ButlerBar");
	//To check the presence of Global Header 
	verify.get().isElementDisplayed("Investors_CostBasisAnalysis_GlobalHeader");
	//To check the presence of Bread crumb
	businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "SECFilings_Expected_Breadcrumb","Tag_List");
	//To check the presence of Bread crumb to left side of the page
	businessFunction.get().pageAllignment("ButlerBar", "Breadcrumb_Actual", "equal");
	//To check the presence of Contact Information to the right of page 
	verify.get().isTextPresent("Investors_ContactInformation_Button");
	businessFunction.get().pageAllignment("ButlerBar", "Investors_ContactInformation_Button", "right");
	//To check the presence of Title to left side of the page
	businessFunction.get().pageAllignment("ButlerBar", "Title_Allignment", "equal");
	//To check the presence of sub title
	verify.get().isTextPresent("SECFilings_SubTitle");
	//To check the presence of sub title below title
	businessFunction.get().pageAllignment("SECFilings_Title", "SECFilings_SubTitle", "equal");
	//To check the presence of Hero image
	businessFunction.get().imageValidation("SECFilings_HeroImage");
	//To check the presence of Toggle menu
	verify.get().isElementDisplayed("Investors_ToggleMenu");
	//To check the presence of Filing Types text 
	verify.get().isTextPresent("SECFilings_Filingtypes");
	//To check Sub menu with All Filings, Annual Filings, Quarterly Filings,Proxy,Insider tabs
	businessFunction.get().verifySubMenuElements("SECFilings_SubMenu","Tag_List",",");
	//To check the presence of grid with Date,Type,Description,Filer,View columns
	businessFunction.get().verifySubMenuElements("SECFilings_Grid", "SECFilings_Grid_Child",",");
	//To check the presence of Word icon under View column
	businessFunction.get().checkIconsPresent("InvestorsSEC_Icons", "SEC_WordIcon");
	businessFunction.get().pageAllignment("InvestorsSEC_View", "SEC_WordIcon", "above");
	//To check the presence of PDF icon under View column
	businessFunction.get().checkIconsPresent("InvestorsSEC_Icons", "SEC_PDFIcon");
	businessFunction.get().pageAllignment("InvestorsSEC_View", "SEC_PDFIcon", "above");
	//To check the presence of Excel icon under View column
	businessFunction.get().checkIconsPresent("InvestorsSEC_Icons", "SEC_ExeclIcon");
	businessFunction.get().pageAllignment("InvestorsSEC_View", "SEC_ExeclIcon", "above");
	//To check the presence of Search icon(disabled/enabled) under View column
	businessFunction.get().checkIconsPresent("InvestorsSEC_Icons", "SEC_SearchIcon");
	businessFunction.get().pageAllignment("InvestorsSEC_View", "SEC_SearchIcon", "above");
	//To check the presence of Related products pod,Contact Info pod,How to Buy pod 
	businessFunction.get().verifyPartnerAndProductPods("Investors_CostBasisAnalysis_Pods", "Tag_Anchors");
	//To check the presence of Global footer
	verify.get().isElementDisplayed("Footer");	
	//To check the presence of Social Media icons
	businessFunction.get().socialIcons("FooterSocialIcons","Tag_Anchors","href");
}
/** 
Author Name                       : Phani
Date of Preparation               : 27/06/2014
Date of Modified                  : --
Methods Called                    : 
Purpose of Method                 : Verify the order of related articles displayed on Article detail page.
Dependencies	                   	: --
Reviewed By                       : --
* @throws Exception 

**/
@Test(description = "Verify the order of related articles displayed on Article detail page.", groups = "Perspectives")
public void testPerspectivesRelatedArticlesOrder() {
getDriver().get(appConfig.getAppUrl());
// Click on Perspective MegaMenu
dynamicWait.get().waittillpageloads();
businessFunction.get().deFocus();
businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "Perspectives_SubMenu", "PerspectivesTitlePage");
// Click on Perspective Article
dynamicWait.get().waittillpageloads();
businessFunction.get().verifyArticleNavigation(
		"Perspectives_ArticleList", "Perspectives_ArticleHeader");
// check the related articles
dynamicWait.get().waittillpageloads();
businessFunction.get().checkRelatedArticlesInArticlePage(
		"Perspectives_article_topic",
		"Perspectives_relatedArticle_topic");
// verified the magazines are in descending order
//businessFunction.get().checkRelatedArticlesOrder("ArticleDates");
}
/** 
Author Name                       : Niharika
Date of Preparation               : 11/9/2014
Date of Modified                  : 
Methods Called                    : verifyLinksAndNavigatedUrl(String controlName),isTextPresent(String controlName) 
										clickAndVerifyNavigation(String navigatetopage,String pageTitle)
Purpose of Method                 : verify the pdf names for all the links present in Active Salaried Employee page
Dependencies	                    : --
Reviewed By                       : --
**/

@Test(description="verify the pdf names for all the links present in Active Salaried Employee page",groups="Benefits")
public void testBenefitsActiveSalariedEmployee()
{
	// Launching the Avaya URL
	getDriver().get(appConfig.getBenefitsUrl());    	
	dynamicWait.get().waittillpageloads();
	//Verifying Avaya Benefits home page		
	verify.get().isTextPresent("AvayaBenefitsHomePage");
	//To click on the Active Salaried Employee tab in the left menu
	businessFunction.get().clickAndVerifyNavigation("AvayaBenefitsActiveSalEmployee", "Benefits_ActiveSalariedEmployee_Title");
	//Verifying the PDF link names		
	businessFunction.get().verifyPdfUrl("Benefits_ActiveSalariedEmployee_Links");							
}  
/** 
Author Name                       : Niharika
Date of Preparation               : 11-09-2014
Date of Modified                  : 
Methods Called                    : clickOn(Utilities),isTextPresent(Verify),searchValidResults,checkautocompleteresults(businessFunction)
Purpose of Method                 : Verify that the search option available has the autocomplete functionality
Dependencies	                  : --
Reviewed By                       : --
TestCase name					  : wi01152055_Benefits_Search_1
**/


@Test(description="Verify that the search option available has the autocomplete functionality",groups="Benefits")
public void testBenefitsSerach()
{
	// Launching the Benefits URL
	getDriver().get(appConfig.getBenefitsUrl());    	
	dynamicWait.get().waittillpageloads();
	//Verify the Benefits Home Page
	verify.get().isTextPresent("AvayaBenefitsHomePage");
	// Entering the text in search field and verifying whether relevant details are displaying in the list or not			
	businessFunction.get().checkAutoCompleteResults("autosuggestion_results","ValidSearch", "AvayaHome_SearchBox");	
	//Clicking on Search button
	userActions.get().clickOn("Search_Button_Test");
	dynamicWait.get().waittillpageloads();
	//Verifying the Search results
	businessFunction.get().searchValidResults("searchresults", "Avaya");				
								
}

/** 
Author Name                       : Sowmya
Date of Preparation               : 11/09/2014
Date of Modified                  : 
Methods Called                    : verfiyBrandCampaignPods(String controlName)
Purpose of Method                 : Verify the Customer Section on the Landing page
Dependencies	                  : --
Reviewed By                       : --
* 
**/
@Test(description="Verify the Customer Section on the Landing page", groups="Brand Campaign")
public void testBrandCampaignCustomer(){
	
	//Navigate to imagine url
	getDriver().get(appConfig.getImagineUrl());
	//Verify the Customer Section on the Landing page
	businessFunction.get().verfiyBrandCampaignPods("BrandCampaign_PodsSection");	
}
/** 
Author Name                       : Sowmya
Date of Preparation               : 11-09-2014
Date of Modified                  : 
Methods Called                    : 
Purpose of Method                 : Verify if the user is able to share the Brand Campaign Story Page Details on twitter
Dependencies	                   	: --
Reviewed By                       : --

* 
**/
@Test(description="Verify if the user is able to share the Brand Campaign Story Page Details on twitter", groups="Brand Campaign")
public void testBrandCampaignTwitterStoryPage(){
	
	//navigate to Imagine URL
	getDriver().get(appConfig.getImagineUrl());
	/*Click on the Brand Campaign banner on the Home Page and User should be able to view Brand Campaign landing Page
	Click on "View Story" CTA of the first Customer Section present in the Landing Page*/
	userActions.get().clickOn("Customer_CTA");
	businessFunction.get().contentValidation("CustomerStoryTitle");
//	businessFunction.get().clickAndVerifyNavigation("Customer_CTA", "StoryPage_CustomerName");
	//Click on "Twitter" Icon
	userActions.get().clickOn("BrandCampaign_TwitterIcon");
	dynamicWait.get().waittillpageloads();
	//switch to the twitter window and share
	businessFunction.get().shareArticleInSocialSites("TwitterPlusData", "twitter");																
	//Check the Shared Link in Twitter page
	getDriver().get(appConfig.getTwitterUrl());		
	businessFunction.get().validateSharedArticleInSocialSites("TwitterPlusData", "twitter");
}

/** 
Author Name                       : Sowmya
Date of Preparation               : 11-09-2014
Date of Modified                  : --
Methods Called                    : 
Purpose of Method                 : Verify the Details present in the products Rail Pod in the Story page
Dependencies	                   	: --
Reviewed By                       : --
* 
**/
@Test(description="Verify the Details present in the products Rail Pod in the Story page", groups="Brand Campaign")
	public void testBrandCampaignProductUsedDetails() {

		// Navigate to imagine url
		getDriver().get(appConfig.getImagineUrl());
		// Click on the Brand Campaign banner on the Home Page and User should
		// be able to view Brand Campaign landing Page
		businessFunction.get().clickAndVerifyNavigation("Customer_CTA",
				"StoryPage_CustomerName");
		/*
		 * Verify the Details present in the products Rail Pod in the Story page
		 * user should be able to view the following details in the products
		 * Rail Pod •Product Name •Product Text
		 */
		businessFunction.get().contentValidation("ProductsUsedByCarlosBakery");
		businessFunction.get().contentValidation("ProductDescription1");
		businessFunction.get().contentValidation("ProductDescription2");
	}
/** 
Author Name                       : Sowmya
Date of Preparation               : 11/09/2014
Date of Modified                  : 
Methods Called                    : imageValidation(String imageControlName),contentValidation(String controlName)
									verifyMenuOrCategoryLinks(String controlName)
									isTextPresent(String controlName) 
Purpose of Method                 : Verify the Details present in the  Related Stories Rail Pod in the Story page
Dependencies	                  : --
Reviewed By                       : --
**/

@Test(description="Verify the Details present in the  Related Stories Rail Pod in the Story page",groups="Brand Campaign")
public void testBrandCamapaignRelatedStories()
{
	
	// Launching the Avaya URL
	getDriver().get(appConfig.getImagineUrl());    	  
	dynamicWait.get().waittillpageloads();	
	//Clicking on View Story link
	userActions.get().clickOn("BrandCamapaignViewStory");
	dynamicWait.get().waittillpageloads();
	businessFunction.get().scrollDown();
	//To verify the related stories Image 
	businessFunction.get().imageValidation("RelatedStoriesImage");
	//Verifying the Related Stories Title 
	businessFunction.get().contentValidation("CustomerStoryTitle");
	//Verifying Related Stories Intro Text is present in the page or not
	businessFunction.get().contentValidation("RelatedStories_IntroText");
/*	//To verify the See More Customer Stories link
	businessFunction.get().verifyMenuOrCategoryLinks("RelatedStoriesSeeMore");
	//Verifying the RelatedStoriesSeeMore text
	verify.get().isTextPresent("RelatedStoriesSeeMore");*/
	
}

/** 
Author Name                       : Vinusha
Date of Preparation               : 16/09/2014
Date of Modified                  : --
Methods Called                    : verifyImageActive,isElementPresent(Verify),clickOn(UserActions)
Purpose of Method                 : Verify the Details present in the Brand Campaign Story Page
Dependencies	                  : --
Reviewed By                       : --
Test Case Name					  : Brand Campaign_BR-F.019_ StoryPage_Details
**/
@Test(description="Verify the Details present in the Brand Campaign Story Page",groups="Brand Campaign")
public void testBrandCamapaignStoryDetails()
 {

		// Launching the Avaya URL
		getDriver().get(appConfig.getImagineUrl());
		dynamicWait.get().waittillpageloads();
		// Verifying Brand Camapaign page is opened or not
		businessFunction.get().imageValidation("BrandCamapaignHeroImage");
		// verify.get().verifyImagePresent("BrandCamapaignHeroImage.jpg",
		// "BrandCamapaignHeroImage");
		// Clicking on the Image present in the First Customer Pod
		userActions.get().clickOn("BrandCamapaignHeroImage");
		dynamicWait.get().waittillpageloads();
		// Verify the BrandCamapaign image
		verify.get().isElementPresent("BrandCamapaignImageLandpage");
		// Verifying CustomerStoryTitle details
		businessFunction.get().contentValidation("CustomerStoryTitle");
		// verify.get().isTextPresent("CustomerStoryTitle");
		// Verifying CustomerTwitter details
		verify.get().isElementPresent("CustomerTwitter");
		// Verifying CustomerFaceBook details
		verify.get().isElementPresent("CustomerFaceBook");
		// Verifying CustomerLinkedin details
		verify.get().isElementPresent("CustomerLinkedin");
		// Verifying CustomerGoogle details
		verify.get().isElementPresent("CustomerGoogle");
		// Verifying CustomerPrint details
		verify.get().isElementPresent("CustomerPrint");
		// Verifying StoryTitle details
		businessFunction.get().contentValidation("StoryTitle");
		// Verifying StoryTextPart1 details
		businessFunction.get().contentValidation("StoryTextPart1");
		// Verifying StoryTextPart2 details
		businessFunction.get().contentValidation("StoryTextPart2");
		// Verifying StoryNextStep details
		businessFunction.get().contentValidation("StoryNextStep");

	}

	/** 
	Author Name                       : Vinusha
	Date of Preparation               : 11/9/2014
	Date of Modified                  : 	
	Methods Called                    : pageAllignment(String relativeControlName, String controlName, String position),
										verifyTextEntered(String textField, String enteredText)
	Purpose of Method                 : Verify the search box beside the search results title
	Dependencies	                  : --
	Reviewed By                       : --
	**/
	@Test(description = "Verify the search box beside the search results title", groups = "GSA Search page")
	public void testGlobalSearchPageSearchBox() {
		// Launching the Avaya Website
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		// To eneter avaya in the search box of home page
		userActions.get().enterText("AvayaHome_SearchBox", "avaya");
		// To click on the search button
		userActions.get().clickOn("Search_Button_Test");
		// To verify whether the Search Results section is present beside the
		// Search text box
		businessFunction.get().pageAllignment(
				"GlobalSearch_SearchResultsSection",
				"GlobalSearch_SearchTextBox", "right");
		// To verify whether the search keyword filled in the search box
		businessFunction.get().verifyTextEntered("GlobalSearch_SearchTextBox",
				"avaya");
	}
	
    /** 
    Author Name                       : Phani
    Date of Preparation               : 15/09/2014
    Date of Modified                  : 
    Methods Called                    : isTextPresent,verifyImageActive,isElementPresent(Verify),clickOn(UserActions),sendinputdata,checkCssProperty(businessfunction)
    Purpose of Method                 : Verify the details on Demand Gen Thank You Page
    Dependencies	                  : --
    Reviewed By                       : --
    TestCase name					  : wi01159736_Demand Gen_Thank you Page
    **/


  @Test(description="Verify the details on Demand Gen Thank You Page",groups="Demand Gen page")
    public void testDemandGenThankYouPage()
 {
		// Launching the Avaya URL
		getDriver().get(appConfig.getDemandGenUrl());
		dynamicWait.get().waittillpageloads();
		// Verifying Demand Gen Registration page is opened or not
		verify.get().isTextPresent("AllFieldsRequiredColorText");
		// Filling all the details in Demand Registration page and clicking on
		// Submit button
		businessFunction.get().sendinputdata("DemRegInputData",
				"demregistration", "demregistration");
		// Clicking on submit button
		userActions.get().clickOn("DemandSubmit");
		dynamicWait.get().waittillpageloads();
		// Verify the Thank you page
		verify.get().isTextPresent("DemandThankYou");
		// Verifying Thank you for registering text color
		businessFunction.get().checkCssProperty("ThankYouForRegistering",
				"Color"); // here color is application property that will not be
							// available in UI map sheet
		// Verify DownloadNow button is exist or not
		verify.get().isElementPresent("DownloadNow");
		// Verifying DocumentTitle
		verify.get().isElementPresent("DocumentTitleandText");
		// Verifying TermsofUse text
		verify.get().isTextPresent("ThankYouTermsofUse");
		// Verifying YouPrivacey text
		verify.get().isTextPresent("ThankYouPrivacy");
		// Verify Thank you page image
		businessFunction.get().imageValidation("ThankYouImage");
		// Verifying Avaya Logo
		businessFunction.get().imageValidation("AvayaLogo");

	}
  
  /** 
  Author Name                       : Sowmya
  Date of Preparation               : 11-09-2014
  Date of Modified                  : 
  Methods Called                    : clickOn(Utilities), isTextPresent,isElementPresent(Verify),sendinputdata(businessFunction)
  Purpose of Method                 : Verify whether Thank you page is shared to Facebook or not
  Dependencies	                    : --
  Reviewed By                       : --
  TestCase name					   : wi01159736_Demand Gen_Thank you Page_Share on Facebook
  **/


@Test(description="Verify whether Thank you page is shared to Facebook or not",groups="Demand Gen page")
	public void testDemandGenFaceBook() {
		// Launching the Avaya URL
		getDriver().get(appConfig.getDemandGenUrl());
		dynamicWait.get().waittillpageloads();
		// Verifying Demand Gen Registration page is opened or not
		businessFunction.get().contentValidation("DemandGeneral_Title");
		// Filling all the details in Demand Registration page and clicking on
		// Submit button
		businessFunction.get().sendinputdata("DemRegInputData",
				"demregistration", "demregistration");
		// Clicking on submit button
		userActions.get().clickOn("DemandSubmit");
		dynamicWait.get().waittillpageloads();
		// Verify the Thank you page
		verify.get().isTextPresent("DemandThankYou");
		// Clicking on FaceBook link
		userActions.get().clickOn("DemandFaceBook");
		dynamicWait.get().waittillpageloads();
		// Share the Link
		businessFunction.get().shareArticleInSocialSites("FacebookPlusData",
				"facebook");
		// Check the Shared Link in Facebook page
		getDriver().get(appConfig.getFacebookUrl());
		businessFunction.get().validateSharedArticleInSocialSites(
				"FacebookPlusData", "facebook");
	}

/** 
Author Name                       : Niharika
Date of Preparation               : 11/9/2014
Date of Modified                  : 
Methods Called                    : checkToggleMenuArrows(String actualControlName,String expectedControlName,String direction)
									  pageAllignment(String relativeControlName, String controlName, String position)
									  isTextPresent(String controlName),verifyBreadCrumb(String actualControlName, String expectedControlName,String tagName)
									  verifyMenuOrCategoryLinks(String controlName),verifyPartnerAndProductPods(String controlName, String Child)
									  imageValidation(String imageControlName),contentValidation(String controlName)
Purpose of Method                 : Verify the toggle menu present in the avaya labs home page
Dependencies	                  : --
Reviewed By                       : --
* 
**/
@Test(description="Verify the toggle menu present in the avaya labs home page", groups="Avaya Labs")
public void testAvayaLabsPeoplePage(){
	
	//navigate to avaya labs
	getDriver().get(appConfig.getAvayaLabsUrl());
	dynamicWait.get().waittillpageloads();
	businessFunction.get().deFocus();
	//Verify the toggle menu present in the avaya labs home page
	businessFunction.get().checkToggleMenuArrows("AvayaLabs_OverviewToggleArrow", "Expanded_Arrow", "up");
	businessFunction.get().checkToggleMenuArrows("AvayaLabs_PeopleToggleArrow", "Expanded_Arrow", "up");
	//To verify whether the Toggle menu section is present on the left side of the page
	businessFunction.get().pageAllignment("ButlerBar", "Avayalabs_ToggleSection", "equal");
	verify.get().isTextPresent("AvayaLabs_ToggleMenu_Overview");
	verify.get().isTextPresent("AvayaLabs_ToggleMenu_People");
	//Click on people from left toggle menu
	userActions.get().clickOn("AvayaLabs_Peoplelink");
	//To verify whether the Home>Avaya labs>People breadcrumb is present or not
	businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "AvayaLabs_Overview_ExpectedBreadCrumb","Tag_Anchors");
	//Verify the toggle menu present in the avaya labs people page
	businessFunction.get().checkToggleMenuArrows("AvayaLabs_OverviewToggleArrow", "Expanded_Arrow", "up");
	businessFunction.get().checkToggleMenuArrows("AvayaLabs_PeopleToggleArrow", "Expanded_Arrow", "up");
	//To verify whether links of people are present or not
	businessFunction.get().verifyMenuOrCategoryLinks("AvayaLabs_People_AllLinks");
	//To verify whether description about people are present or not
	businessFunction.get().contentValidation("AvayaLabs_People_AllContent");
	//To verify whether the More information pod is present or not 
	businessFunction.get().verifyPartnerAndProductPods("AvayaLabs_People_MoreInfoPod", "Tag_Anchors");
	//To Click on any person's link
	userActions.get().clickOn("AvayaLabs_People_PersonLink");
	//To check the title,breadcrumb,Image,Image title and related content
	businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "AvayaLabs_Overview_ExpectedBreadCrumb","Tag_Anchors");
	businessFunction.get().imageValidation("AvayaLabs_People_PersonImage");
	businessFunction.get().contentValidation("AvayaLabs_People_PersonTitle");
	businessFunction.get().contentValidation("AvayaLabs_People_PersonDescription");
	verify.get().isTextPresent("AvayaLabs_People_PersonImageTitle");
	//Verify the toggle menu present in the avaya labs people page
	businessFunction.get().checkToggleMenuArrows("AvayaLabs_OverviewToggleArrow", "Expanded_Arrow", "up");
	businessFunction.get().checkToggleMenuArrows("AvayaLabs_PeopleToggleArrow", "Expanded_Arrow", "up");
	}
/** 
Author Name                       : Phani
Date of Preparation               : 16/09/2014
Date of Modified                  : --
Methods Called                    : clickOn(UserActions),clickOnSubMenuItem,verifyTealiumTags(businessfunction),isTextPresent(Verify)
Purpose of Method                 : Verify the Canonical Tags in Phone Series Page
Dependencies	                  : --
Reviewed By                       : --
Test Case Name					  :  Phones Detail Page_Canonical Tags

**/

@Test(description="Verify the Canonical Tags in Phone Series Page",groups="Phones")
public void testProductsCanonicalTags()
{
	// Launching the Avaya URL
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	// Click on Products link and verify whether Products page is opening or not
	userActions.get().clickOn("Products");
	dynamicWait.get().waittillpageloads();
	//Verify the products label text
	verify.get().isTextPresent("Products_label");	
	//Clicking on NewPhonesPage link when user hover on Products	
	businessFunction.get().clickOnSubMenuItem("Products", "NewPhonesPage", "NewPhonesPageHeading");    	 
   	//Clicking on the ExploreDesktopPhones line
	userActions.get().clickOn("Phones_DesktopPhones");
	dynamicWait.get().waittillpageloads();
	//Verifying DesktopPhoneHeading
	businessFunction.get().contentValidation("DesktopPhoneHeading");
	//Verifying DesktopPhoneOptionheading
	businessFunction.get().contentValidation("DesktopPhoneOptionHeading");
	//Clicking on LearnMore option
	userActions.get().clickOn("DesktopPhoneLearnMore");
	dynamicWait.get().waittillpageloads();
	//Clicking on PhonesResources
	userActions.get().clickOn("PhonesResources");
	dynamicWait.get().waittillpageloads();
	//Verifying PhonesResourcesHeading
	businessFunction.get().contentValidation("PhonesResourcesHeading");
	//Verifying Canonical Tags
	businessFunction.get().verifyTealiumTags("PhonesTags","CanonicalTagValues","rel");
	
}

/**
Author Name                       : Niharika K R 
Date of Preparation               : 15-09-2014
Date of Modified                  : 
Methods Called                    : pageAllignment(String relativeControlName, String controlName, String position),
									verifyElementsByCount(String controlName, int count),verifySelectionCount(String selectionlist, String selected)
									verifyMenuOrCategoryLinks(String controlName),checkCssProperty(String controlName, String cssProperty)
									verifySubMenuElements(String parentMenu,String subMenu,String delimiter)
Purpose of Method                 : Verify the entire Content of case studies landing page
Dependencies	                  : Jar files
Reviewed By                       : 
**/

@Test(description="Verify the entire Content of case studies landing page",groups="Case Studies page")
public void testCaseStudiesLandingPageContent()
{
	 //Launching the Avaya website
	 getDriver().get(appConfig.getCaseStudiesUrl());
	 businessFunction.get().deFocus();
	 //To verify whether Base ball cards is displayed below the sub navigation menu in two columns
	 businessFunction.get().pageAllignment("CaseStudiesLandingPage_ScrollAble", "CaseStudies_LandingPage_ArticleSection", "above");
	 businessFunction.get().checkCssProperty("CaseStudiesLandingPage_LeftArticles", "float");
	 businessFunction.get().checkCssProperty("CaseStudiesLandingPage_RightArticles", "float");
	 //To verify whether the case study can be linked to one or more Business size 
	 userActions.get().clickOn("CaseStudiesLandingPage_BusinessSize_Large");
	 dynamicWait.get().waittillpageloads();
	 businessFunction.get().verifySelectionCount("CaseStudiesLandingPage_Articles", "CaseStudiesLandingPage_BusinessSize_Large");
	 userActions.get().clickOn("CaseStudiesLandingPage_BusinessSize_Small");
	 dynamicWait.get().waittillpageloads();
	 businessFunction.get().verifySelectionCount("CaseStudiesLandingPage_Articles", "CaseStudiesLandingPage_BusinessSize_Small");
	 userActions.get().clickOn("CaseStudiesLandingPage_BusinessSize_Midsize");
	 dynamicWait.get().waittillpageloads();
	 businessFunction.get().verifySelectionCount("CaseStudiesLandingPage_Articles", "CaseStudiesLandingPage_BusinessSize_Midsize");
	 //To verify whether the case study can be linked to one or more Industry
	 userActions.get().clickOn("ShowAllTopics");
	 userActions.get().clickOn("CaseStudiesLandingPage_IndustrySection_HigherEducation");
	 dynamicWait.get().waittillpageloads();
	 userActions.get().clickOn("ShowAllTopics");
	 businessFunction.get().verifySelectionCount("CaseStudiesLandingPage_Articles", "CaseStudiesLandingPage_IndustrySection_HigherEducation");
	 userActions.get().clickOn("CaseStudiesLandingPage_IndustrySection_EducationK12");
	 dynamicWait.get().waittillpageloads();
	 userActions.get().clickOn("ShowAllTopics");
	 businessFunction.get().verifySelectionCount("CaseStudiesLandingPage_Articles", "CaseStudiesLandingPage_IndustrySection_EducationK12");
	 userActions.get().clickOn("CaseStudiesLandingPage_IndustrySection_EngergyUtilities");
	 dynamicWait.get().waittillpageloads();
	 userActions.get().clickOn("ShowAllTopics");
	 businessFunction.get().verifySelectionCount("CaseStudiesLandingPage_Articles", "CaseStudiesLandingPage_IndustrySection_EngergyUtilities");
	 userActions.get().clickOn("CaseStudiesLandingPage_IndustrySection_GeneralServices");
	 dynamicWait.get().waittillpageloads();
	 userActions.get().clickOn("ShowAllTopics");
	 businessFunction.get().verifySelectionCount("CaseStudiesLandingPage_Articles", "CaseStudiesLandingPage_IndustrySection_GeneralServices");
	 userActions.get().clickOn("CaseStudiesLandingPage_IndustrySection_Telecommunciations");
	 dynamicWait.get().waittillpageloads();
	 userActions.get().clickOn("ShowAllTopics");
	 businessFunction.get().verifySelectionCount("CaseStudiesLandingPage_Articles", "CaseStudiesLandingPage_IndustrySection_Government");
	 userActions.get().clickOn("CaseStudiesLandingPage_IndustrySection_Telecommunciations");
	 dynamicWait.get().waittillpageloads();
	 userActions.get().clickOn("ShowAllTopics");
	 businessFunction.get().verifySelectionCount("CaseStudiesLandingPage_Articles", "CaseStudiesLandingPage_IndustrySection_Telecommunciations");
	 userActions.get().clickOn("CaseStudiesLandingPage_IndustrySection_Utilities"); 
	 dynamicWait.get().waittillpageloads();
	 userActions.get().clickOn("ShowAllTopics");
	 businessFunction.get().verifySelectionCount("CaseStudiesLandingPage_Articles", "CaseStudiesLandingPage_IndustrySection_Utilities");
	 userActions.get().clickOn("CaseStudiesLandingPage_IndustrySection_Virtualization");
	 dynamicWait.get().waittillpageloads();
	 userActions.get().clickOn("ShowAllTopics");
	 businessFunction.get().verifySelectionCount("CaseStudiesLandingPage_Articles", "CaseStudiesLandingPage_IndustrySection_Virtualization");
	 userActions.get().clickOn("CaseStudiesLandingPage_IndustrySection_finance");
	 dynamicWait.get().waittillpageloads();
	 userActions.get().clickOn("ShowAllTopics");
	 businessFunction.get().verifySelectionCount("CaseStudiesLandingPage_Articles", "CaseStudiesLandingPage_IndustrySection_finance");
	 userActions.get().clickOn("CaseStudiesLandingPage_IndustrySection_Other");
	 dynamicWait.get().waittillpageloads();
	 userActions.get().clickOn("ShowAllTopics");
	 businessFunction.get().verifySelectionCount("CaseStudiesLandingPage_Articles", "CaseStudiesLandingPage_IndustrySection_Other");
	 //To verify whether Featured case studies pod is present which contains maximum of 5 case study links(content managed)
	 businessFunction.get().verifyMenuOrCategoryLinks("FeaturedCaseStudiesPod_Links");
	 //To verify whether the search case studies section is present with search text box and search button
	 verify.get().isElementDisplayed("CaseStudies_SearchBox");
	 verify.get().isElementDisplayed("CaseStudies_SearchButton");
	 //To verify whether business size section should be present with 3 filter values: large,small,midsize
	 businessFunction.get().verifySubMenuElements("CaseStudiesBusniessSizeParent", "Tag_Anchors", ",");
	 //To verify whether industry section should be present with 10 filter values
	 businessFunction.get().verifySubMenuElements("CaseStudiesIndustryParent", "Tag_List", ",");
}
/** 
Author Name                       : Sindhuja
Date of Preparation               : 10/09/2014
Date of Modified                  : --
Methods Called                    : clickOn,switchToChildWindow,switchToParentWindow,closeChildWindow(UserActions),isElementPresent,isTextPresent(Verify)
Purpose of Method                 : Verify if the user is able to navigate to Avaya Youtube page.
Dependencies	                  : --
Reviewed By                       : --
Test Case name					  : wi01159903_Newsroom_Youtube
**/

@Test(description="Verify if the user is able to navigate to Avaya Youtube page.",groups="About Avaya-Newsroom")
public void testAbtAvayaNewsRoomYouTube()
{
	// Launching the Avaya URL
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	// MegaMenuAboutAvaya will be passing from excel sheet
	userActions.get().clickOn("MegaMenuAboutAvaya"); 
	dynamicWait.get().waittillpageloads();
	// Verifying the ButlerBar.
	verify.get().isElementPresent("AboutAvayaMegaMenu");	
	//Clicking on NewRoom link which is available in the bottom
	userActions.get().clickOn("Newsroom");
	dynamicWait.get().waittillpageloads();
	//Verify the NewRoomtitle text
	verify.get().isTextPresent("Newsroom_Title");
	//Clicking on YouTube icon which is available in the bottom	
	userActions.get().clickOn("YouTube");
  dynamicWait.get().waitForChildWindows();
	//Switching to child window
	userActions.get().switchToChildWindow();	
	//Checking the YouTube url
    businessFunction.get().checkUrl("YouTube","contains");	
	//Closing the child window
	userActions.get().closeChildWindowBrowserDependent();					
}


/** 
Author Name                       : Sivanag
Date of Preparation               : 18/07/2014
Date of Modified                  : 11-09-2014
Methods Called                    : isTextPresent,isElementPresent(Verify),clickOn,switchToChildWindow(UserActions),sendinputdata(businessfunction)
Purpose of Method                 : Verify if the user is able to share the page on Google+
Dependencies	                  : --
Reviewed By                       : --
Test Case name					  : NewRoom_Google+
**/

@Test(description="Verify if the user is able to share the page on Google+",groups="About Avaya-Newsroom")
public void testNewsRoomGoogle()
{
		// Launching the Avaya URL
		getDriver().get(appConfig.getNewsRoomUrl());    		    	  
    	dynamicWait.get().waittillpageloads();
    	//Verifying the page title heading.
    	verify.get().isTextPresent("Newsroom_Title");
    	//Verifying the social site icons is present or not
    	businessFunction.get().socialIcons("NewsRoom_SocialIcons","CaseStudies_SocialIcons_Child","class");
    	//Clicking on Google+ link
    	userActions.get().clickOn("NewsRoomGoogle");
    	dynamicWait.get().waittillpageloads();
    	//Share the link in GooglePlus page
    	businessFunction.get().shareArticleInSocialSites("GooglePlusData", "googleplus");																				
		//Check the Shared Link in GooglePlus page
		getDriver().get(appConfig.getGooglePlusUrl());		
		businessFunction.get().validateSharedArticleInSocialSites("GooglePlusData", "googleplus");    	    	
    	
}

/** 
Author Name                       : Sowmya
Date of Preparation               : 11/09/2014
Date of Modified                  : 
Methods Called                    : pageAllignment(String relativeControlName, String controlName, String position)
									verifySubMenuElements(String parentMenu,String subMenu,String delimiter)
									checkToggleMenuArrows(String actualControlName,String expectedControlName,String direction)
									checkCssProperty(String controlName, String cssProperty)
									
Purpose of Method                 : Verify the expand and collapse functionality of left menu in GSA search page
Dependencies	                    : --
Reviewed By                       : --
**/


@Test(description="Verify the expand and collapse functionality of left menu in GSA search page",groups="GSA Search page")
public void testGSASearchExpandCollapse()
{
  //Launching the Avaya Website
	getDriver().get(appConfig.getAppUrl());
	businessFunction.get().deFocus();
	//To eneter avaya in the search box of home page
	userActions.get().enterText("AvayaHome_SearchBox", "Avaya Aura Platform");
	//To click on the search button 
	userActions.get().clickOn("Search_Button_Test");
		//To verify whether the Search Results section is present beside the Search text box
	businessFunction.get().pageAllignment("GlobalSearch_SearchResultsSection", "GlobalSearch_SearchTextBox", "right");
	//To check if business need,business size,industry,site section sections are displayed
    businessFunction.get().verifySubMenuElements("ResultsPage_Sections", "Tag_Span", ",");
    //To check if business need,business size,industry,site section sections are expanded by default
   	businessFunction.get().checkToggleMenuArrows("BusinessNeed_Expanded_Arrow","Expanded_Arrow","up");
   	businessFunction.get().checkToggleMenuArrows("BusinessSize_Expanded_Arrow","Expanded_Arrow","up");
   	businessFunction.get().checkToggleMenuArrows("Industry_Expanded_Arrow","Expanded_Arrow","up");
   	businessFunction.get().checkToggleMenuArrows("SiteSection_Expanded_Arrow","Expanded_Arrow","up");
   	//To check if business need,business size,industry,site section sections are collapsed
   	userActions.get().clickOn("BusinessSize_Expanded_Arrow");
	businessFunction.get().checkCssProperty("BusinessSize_MenuDetails_Collapsed", "display");
	userActions.get().clickOn("BusinessNeed_Expanded_Arrow");
	businessFunction.get().checkCssProperty("BusinessNeed_MenuDetails_Collapsed", "display");
	userActions.get().clickOn("Industry_Expanded_Arrow");
	businessFunction.get().checkCssProperty("Industry_MenuDetails_Collapsed", "display");
	userActions.get().clickOn("SiteSection_Expanded_Arrow");
	businessFunction.get().checkCssProperty("SiteSection_MenuDetails_Collapsed", "display");
	//To check if business need,business size,industry,site section sections are expanded
	userActions.get().clickOn("BusinessSize_Expanded_Arrow");
	businessFunction.get().checkCssProperty("BusinessSize_MenuDetails_Expanded", "display");
	userActions.get().clickOn("BusinessNeed_Expanded_Arrow");
	businessFunction.get().checkCssProperty("BusinessNeed_MenuDetails_Expanded", "display");
	userActions.get().clickOn("Industry_Expanded_Arrow");
	businessFunction.get().checkCssProperty("Industry_MenuDetails_Expanded", "display");
	userActions.get().clickOn("SiteSection_Expanded_Arrow");
	businessFunction.get().checkCssProperty("SiteSection_MenuDetails_Expanded", "display");  								
}

/** 
Author Name                       : Vinusha
Date of Preparation               : 17/07/2014
Date of Modified                  : 10/09/2014
Methods Called                    : isElementDisplayed(String controlName)
									  verifyBreadCrumb(String actualControlName, String expectedControlName,String tagName)
Purpose of Method                 : Verify the sitemap page not found page
Dependencies	                   	: --
Reviewed By                       : --
* 
**/

@Test(description="Verify the sitemap page not found page", groups="Global Footer-Site Map")
public void testPageNotFoundSiteMap()
{
	//navigatr to test URL
	getDriver().get(appConfig.getTestUrl());
	dynamicWait.get().waittillpageloads();
	//verify the content of the page and system should display the page 
	businessFunction.get().deFocus();
	businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual","Sitemap_Pagenotfound_breadcrumb","Tag_Anchors");
	verify.get().isElementDisplayed("Megamenu");
	verify.get().isElementDisplayed("Global_Footer");
	verify.get().isElementDisplayed("HomePage_Feedback");
	verify.get().isElementDisplayed("HomePage_LatestNews");
	verify.get().isElementDisplayed("Home_QuickLinks");
	
}
/**
Author Name                       : Niharika K R 
Date of Preparation               : 23-06-2014
Date of Modified                  : 15/09/2014
Methods Called                    : clickAndVerifyNavigation(String navigatetopage,String pageTitle),verifyImageCarouselRotations(String childCarouselImages) 
									pageAllignment(String relativeControlName, String controlName, String position)
									verifyImageAndIndicatorButtonsCount(String imageParentControl, String imageTagName, String indicatorParentControl, String indicatorParentTagName)
Purpose of Method                 : Verify whether images in the carousel are rotated for every 7 seconds
Dependencies	                    : Jar files
Reviewed By                       : 
**/

@Test(description="Verify whether images in the carousel are rotated for every 7 seconds",groups="Partners")
public void testPartnersImageCarousel()
{
	//Launching the Avaya Website
	getDriver().get(appConfig.getAppUrl());
	//To click on the Partners tab from the mega menu
	businessFunction.get().clickAndVerifyNavigation("Partners", "Partners_Title");
	businessFunction.get().deFocus();
	//To check whether CTA and text should be present below the carousel section
	businessFunction.get().pageAllignment("Partners_Parent_Carousel", "Partners_CTA_Text", "equal");
	//To verify whether the count of Images and indicator buttons are same
	businessFunction.get().verifyImageAndIndicatorButtonsCount("Partners_Parent_Carousel","Partners_Parent_Indicator");
	//To verify if Images in the carousel 
	verify.get().verifyImageCarousel("Carousel_Blocks");
}

/** 
Author Name                       : Sindhuja.P
Date of Preparation               : 05/06/2014
Date of Modified                  : 27-08-2014
Methods Called                    : verifyBreadCrumb(String actualControlName, String expectedControlName,String tagName),isTextPresent(String controlName)
                                    pageAllignment(String relativeControlName, String controlName, String position),,isElementDisplayed(String controlName)
Purpose of Method                 : Verify the Products Landing Page
Dependencies	                    : Jar files
Reviewed By                       : --
**/	

@Test(description="Verify if the user is able to navigate to Products landing page",groups="Products")
public void testProductsLandingPage() 
{
	//Launching the Avaya website
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	//Click on the Products tab in the Megamenu and check the title in Products landing page
	businessFunction.get().clickAndVerifyNavigation("Products", "Products_label");
	dynamicWait.get().waittillpageloads();
	//To check the presence of the Image carousel
	verify.get().verifyImageCarousel("Carousel_Blocks");
	//To check the presence of the Header section
	verify.get().isElementDisplayed("Products_Header");
	//To check the presence of the Bread crumb
	businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual","Products_Expected_Breadcrumb","Tag_Anchors");
	//To check the presence of the Image carousel on the left side of the page in the Products Landing Page
	businessFunction.get().pageAllignment("ButlerBar", "Products_ImageCarousel","equal");
	//To check the presence of How to Buy Pod
	verify.get().isElementDisplayed("Products_HowToBuyPod");
	//To check the presence of the How to Buy Pod on the right side of the page in the Products Landing Page
	businessFunction.get().pageAllignment("Products_ImageCarousel","Products_HowToBuyPod","right");
	//To check the presence of Support Options Pod
	verify.get().isElementDisplayed("Products_SupportOptionsPod");
	//To check the presence of the Support Options Pod on the right side of the page in the Products Landing Page
	businessFunction.get().pageAllignment("Products_ImageCarousel","Products_SupportOptionsPod","right");
	//To check the presence of the Sort Results by: section  in the Products Landing Page
	verify.get().isTextPresent("Products_SortResultsBy");
	verify.get().isElementDisplayed("Products_SortResultsBySection");
	//To check the presence of Name link  in the Products Landing Page
	verify.get().isTextPresent("Products_Name");	
	businessFunction.get().verifyMenuOrCategoryLinks("Products_Name");
}

/**
Author Name                       : Sindhuja.P
Date of Preparation               : 26/06/2014
Date of Modified                  : 17-9-2014
Methods Called                    : verifyImageCarouselRotations(String childCarouselImages),imageValidation(String imageControlName)
                                    clickAndVerifyNavigation(String navigatetopage,String pageTitle)
Purpose of Method                 : Verify the functionality of Image carousel
Dependencies	                    : Jar files
Reviewed By                       : --
**/

@Test(description="Verify the functionality of Image carousel",groups="Products")
public void testProductsLandingPageImageCarousel()
{
	//Launching the Avaya website
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	//click on the Products tab in the Megamenu and check the title in Products landing page
	businessFunction.get().clickAndVerifyNavigation("Products", "Products_label");
	dynamicWait.get().waittillpageloads();
	//To verify if Images in the carousel auto rotate twice for the interval of 7 seconds and stop at the first image
	verify.get().verifyImageCarousel("Carousel_Blocks");
	//Click on the second indicator button
	userActions.get().clickOn("Products_2ndIndicatorButton");
	//To verify if second image in the carousel is displayed
	businessFunction.get().imageValidation("Products_2ndImage");
}
/** 
Author Name                       : @author karthik_b14
Date of Preparation               : 01/07/2014
Date of Modified                  : 27-08-2014
Methods Called                    : 
Purpose of Method                 : Verify the functionality of Image Carousel
Dependencies	                   	: --
Reviewed By                       : --
* @throws Exception 

**/
@Test(description="Verify the functionality of Image Carousel", groups="Home Page")
public void testHomePageImageCarousel(){

//navgiate to app URL
getDriver().get(appConfig.getAppUrl());
dynamicWait.get().waittillpageloads();
verify.get().verifyImageCarousel("HomePageImageCarousel");
}



/**
Author Name                       : Niharika K R 
Date of Preparation               : 24-06-2014
Date of Modified                  : 17-9-2014
Methods Called                    : clickAndVerifyNavigation(String navigatetopage,String pageTitle),isElementDisplayed(String controlName)
									  verifyBreadCrumb(String actualControlName, String expectedControlName,String tagName)
									  pageAllignment(String relativeControlName, String controlName, String position)
									  imageValidation(String imageControlName),verifyImageCarouselRotations(String childCarouselImages) 
									  contentValidation(String controlName),isTextPresent(String controlName)
									  verifyMenuOrCategoryLinks(String controlName)
Purpose of Method                 : Verify if the user is able to navigate to Services landing page
Dependencies	                    : Jar files
Reviewed By                       : 
**/

@Test(description="Verify if the user is able to navigate to Services landing page",groups="Services")
public void testServices()
{
	//Launching the Avaya Website
	getDriver().get(appConfig.getAppUrl());
	//To navigate to the Services landing page
	businessFunction.get().clickAndVerifyNavigation("Services", "Services_Title");
	//To verify whether the image carousel is present or not
	verify.get().verifyImageCarousel("Carousel_Blocks");
	//To verify whether the Global Header is present or not
	verify.get().isElementDisplayed("Global_Header");
	//To verify whether the breadcrumb is present or not
	businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "Services_Breadcrumb_Expected","Tag_Anchors");
	//To Verify whether the Image carousel is present below the Services title or not
	businessFunction.get().pageAllignment("Service_Title_coordinate", "Services_Image_Carousel_Parent", "above");
	businessFunction.get().pageAllignment("ButlerBar", "Services_Image_Carousel_Parent", "equal");
	//To verify whether the How to buy pod is present on the right side of the page or not
	businessFunction.get().pageAllignment("ButlerBar", "Services_How_to_buy", "right");
	//To verify whether the Support Options pod is present on the right side of the page or not
	businessFunction.get().pageAllignment("ButlerBar", "Services_Support_Options", "right");
	//To verify the Intro Image and the Intro text
	businessFunction.get().imageValidation("ServicesLandingPage_IntroImage");
	businessFunction.get().contentValidation("ServicesLandingPage_IntroText");
	//To verify whether there are 4 promotional pods present in the Services landing page or not
	businessFunction.get().verifyMenuOrCategoryLinks("ServicesLandingPage_PodCTA");
	businessFunction.get().contentValidation("ServicesLandingPage_PodDescription");
	verify.get().isTextPresent("ServicesLandingPage_OperationsPodHeader");
	verify.get().isTextPresent("ServicesLandingPage_ProfessionalPodHeader");
	verify.get().isTextPresent("ServicesLandingPage_SupportPodHeader");
	//To verify whether the Feedback button is present on the extreme right position on the page or not
	businessFunction.get().pageAllignment("ButlerBar", "Feedback", "extremeRight");
	//To verify whether the Global Footer is present or not
	verify.get().isElementDisplayed("Footer");
	
}

/**
Author Name                       : Niharika K R 
Date of Preparation               : 23-06-2014
Date of Modified                  : 27-08-2014
Methods Called                    : isElementDisplayed(String controlName),verifyCarousal(String carousalActiveImage)
									  isTextPresent(String controlName),pageAllignment(String relativeControlName, String controlName, String position)
Purpose of Method                 : Verify if the user is able to see the intro image and intro text on service landing page
Dependencies	                    : Jar files
Reviewed By                       : 
**/

@Test(description="Verify if the user is able to see the intro image and intro text on service landing page",groups="Services")
public void testServicesLandingPage()
{
	//Launching the Avaya Website
	getDriver().get(appConfig.getAppUrl());
	//To click on the Services tab from the megamenu and to verify the title of the page on navigation to the services landing page
	businessFunction.get().clickAndVerifyNavigation("Services", "Services_Title");
	//To verify the presence of Image Carousel
	verify.get().verifyImageCarousel("Carousel_Blocks");
	//To verify the presence of the 4 images and 4 indicator buttons
	businessFunction.get().verifyImageAndIndicatorButtonsCount("Carousel_Blocks", "Services_Parent_Indicator_Buttons");
	//To verify the presence of How to Buy pod
	verify.get().isElementDisplayed("Services_How_to_buy");
	//To verify the presence of Support Options pod
	verify.get().isElementDisplayed("Services_Support_Options");
	//To verify whether the Services Intro Image is present on the left side of the page
	businessFunction.get().pageAllignment("ButlerBar", "Services_Intro_Image", "equal");
	//To verify whether there are 4 promotional pods present in the Services landing page or not
	businessFunction.get().verifyMenuOrCategoryLinks("ServicesLandingPage_PodCTA");
	businessFunction.get().contentValidation("ServicesLandingPage_PodDescription");
	verify.get().isTextPresent("ServicesLandingPage_OperationsPodHeader");
	verify.get().isTextPresent("ServicesLandingPage_ProfessionalPodHeader");
	verify.get().isTextPresent("ServicesLandingPage_SupportPodHeader");
}

	
/**
  Author Name                       : Sindhuja.P
  Date of Preparation               : 25/07/2014
  Date of Modified                  : 16-09-2014
  Methods Called                    : clickAndVerifyNavigation(String navigatetopage,String pageTitle),clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle)
                                      pageAllignment(String relativeControlName, String controlName, String position),isElementDisplayed(String controlName),isTextPresent(String controlName)
  									  checkSelectedTabActive(String tabSection, String tabs,String str_selectedtabname),verifySubMenuElements(String parentMenu,String subMenu,String delimiter)
  									  checkCssProperty(String controlName, String cssProperty),
  Purpose of Method                 : Verify the functionality of Learn More link in the Phone Series Module
  Dependencies	                    : Jar files
  Reviewed By                       : --
**/

@Test(description="Verify the customer successes tab",groups="Services")
public void testOperationsServicesCustomersSuccesses()
{
    //Launching the Avaya Website
    getDriver().get(appConfig.getAppUrl());
    dynamicWait.get().waittillpageloads();
    //To click on the Operations Services link from the Services tab
  	businessFunction.get().clickOnSubMenuItem("Services", "Operations_Services", "Operations_Services_Title");
  	businessFunction.get().deFocus();
  	//To check if Overview tab is selected by default
  	businessFunction.get().checkSelectedTabActive("OperationServices_Tabs", "Tag_List", "OVERVIEW");
  	//To click on Case Studies tab
  	userActions.get().clickOn("OperationServices_CaseStudies");
  	//To check if Case Studies is selected
  	businessFunction.get().checkSelectedTabActive("OperationServices_Tabs", "Tag_List", "CASE STUDIES");
  	//To check whether "Narrow Results By" section is displayed in the left corner of the page
  	businessFunction.get().pageAllignment("ButlerBar","OperationServices_NarrowResultsBy","equal");
  	//Check if Search, Customer,Industry,Business Size Catergories are Available
  	businessFunction.get().verifySubMenuElements("CaseStudies_SearchCategories","Tag_Span",",");
  	//To check if "<Count> Customer Success match your criteria" is  displayed
  	verify.get().verifyElementContainsText("CaseStudies_Text", "CaseStudies_Message");	  		  	
  	//Check for the Your Result section
  	verify.get().isElementDisplayed("CaseStudies_YourResults");
}
/**
Author Name                       : Sowmya Mohanan
Date of Preparation               : 31/07/2014
Date of Modified                  : 17-09-2014
Methods Called                    : deFocus(),checkwidth(String contolName1, String controlName2),
									verifyMarquee(String marquee, String childMarquee),
									verifyImageCarouselRotations(String carousalActiveImage,String childCarouselImages)
Purpose of Method                 : Verify the Marquee
Dependencies	                    : Jar files
Reviewed By                       : --

**/
@Test(description ="Verify the Marquee",groups = "Home Page")
public void testHPMarqueeWidth(){
	//Launching the Avaya website
	getDriver().get(appConfig.getAppUrl());
	//Check Marquee is playing
	dynamicWait.get().waittillpageloads();
	//Verify the Marquee
	verify.get().verifyMarquee("MarqueeImages");
	//Verify the width of the Marquee is same as the BulterBar and MegaMenu
	businessFunction.get().checkWidth("Marquee_Container", "ButlerBar");
	//Verify the Carousal rotations
	verify.get().verifyImageCarousel("MarqueeImages");
}
/** 
Author Name                       : Sivanag
Date of Preparation               : 14/07/2014
Date of Modified                  : 16-09-2014
	Methods Called                    : 
Purpose of Method                 : Verify if the user is able to filter with Industry and Site section filters
Dependencies	                  : -
Reviewed By                       : -
**/


@Test(description="Verify if the user is able to filter with Industry and Site section filters",groups="GSA Search page")
public void testGSASearchIndustry()
{
	// Launching the Avaya URL
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	// Verify whether home page is opened or not
	verify.get().isElementPresent("HomePage_Logo");  
	// Entering the text in search field and verifying whether relevant details are displaying in the list or not			
	businessFunction.get().checkAutoCompleteResults("autosuggestion_results", "ValidSearch","AvayaHome_SearchBox");
	//Clicking on Search button
	userActions.get().clickOn("Search_Button_Test");
	dynamicWait.get().waittillpageloads();
	//Verify the search results
	verify.get().isElementPresent("searchresults");
	//Check the checkbox of Finance under Industry Filters
	userActions.get().clickOn("FinanceIndustryFilters");
	dynamicWait.get().waittillpageloads();
	businessFunction.get().validateGSASearchResults("ResultDetails");
	userActions.get().clickOn("Industry_AutomotiveFilter");
	dynamicWait.get().waittillpageloads();
	businessFunction.get().validateGSASearchResults("ResultDetails");    								
}

/** 
Author Name                       : Sivanag
Date of Preparation               : 14/07/2014
Date of Modified                  : 
Methods Called                    : clickOn(UserActions),checkautocompleteresults,searchValidResults,verifyMultipleContentType(businessfunction)
Purpose of Method                 : Verify if the user is able to filter with all the filters in GSAsearch page
Dependencies	                    : --
Reviewed By                       : --
TestCase name					   : GSAsearch_Landing_Filtering_All filters
**/


@Test(description="Verify if the user is able to filter with all the filters in GSAsearch page",groups="GSA Search page")
public void testGSASearchAllFilters()
{
	// Launching the Avaya URL
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	// Verify whether home page is opened or not
	verify.get().isElementPresent("HomePage_Logo");  
	// Entering the text in search field and verifying whether relevant details are displaying in the list or not			
	businessFunction.get().checkAutoCompleteResults("autosuggestion_results","ValidSearch","AvayaHome_SearchBox");
	//Clicking on search button
	userActions.get().clickOn("Search_Button_Test");
	dynamicWait.get().waittillpageloads();
	//Verify the search results
	verify.get().isElementPresent("searchresults");	
	//Check the checkbox of VoiceColloboration
	userActions.get().clickOn("FilterVoiceColloboration");
	dynamicWait.get().waittillpageloads();
    businessFunction.get().validateGSASearchResults("ResultDetails");
	//Check the checkbox of Large
	userActions.get().clickOn("FilterLarge");
	dynamicWait.get().waittillpageloads();
	businessFunction.get().validateGSASearchResults("ResultDetails");
	//Check the checkbox of General Services
	userActions.get().clickOn("FilterGeneralServices");
	dynamicWait.get().waittillpageloads();
	businessFunction.get().validateGSASearchResults("ResultDetails");
	//Check the checkbox of Products
	userActions.get().clickOn("FilterProducts");
	dynamicWait.get().waittillpageloads();
	businessFunction.get().validateGSASearchResults("ResultDetails");
								
}

/** 
Author Name                       : Phanendra
Date of Preparation               : 17/09/2014
Date of Modified                  : 
Methods Called                : verifySubMenuElements,clickOnSubMenuItem,isElementDisplayed
Purpose of Method                 : verify the toggle navigation present on company overview page
Dependencies	                  : --
Reviewed By                       : --
**/
 @Test(description="Verify the toggle menu in company overview page",groups="About Avaya")
 public void testCompanyOverviewToggleMenus() {
	 // Launching the Avaya website
	 getDriver().get(appConfig.getAppUrl());
	 businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya",
			 "CompanyOverview", "CompanyOverviewPageHeader");
	 verify.get().isElementDisplayed("CompanyOverviewToggleMenus");
	 businessFunction.get().verifySubMenuElements("CompanyOverviewLeftNav",
			 "CompanyOverviewToggleMenus", ",");
		}
 
	/**
 Author Name                       : Sowmya Mohanan
 Date of Preparation               : 04/08/2014
 Date of Modified                  : 17-09-2014
 Methods Called                    : deFocus(),clickOn(String controlName),verifyImagePresent(String expectedImage, String imageElement)
 									clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle)
 Purpose of Method                 : Verify the HP Segmentation for the business Size Midsize
 Dependencies	                    : Jar files
 Reviewed By                       : --

**/
@Test(description = "Verify the HP Segmentation for the business Size Midsize", groups = "HP Segmentation")
public void testHPSegmentationMidmarketSegment1(){
	//Launching the Avaya website
	getDriver().get(appConfig.getAppUrl());
	//Hover on Products MegaMenu and click on IP Office Platform
	dynamicWait.get().waittillpageloads();
	getDriver().manage().deleteAllCookies();
	dynamicWait.get().waittillpageloads();
	businessFunction.get().deFocus();
	businessFunction.get().clickOnSubMenuItem("Products", "Products_IPOfficePlatform", "Products_IPOfficePlatform_Title");
	//Click on the Case Studies Tab
	dynamicWait.get().waittillpageloads();
	userActions.get().clickOn("CaseStudies_Tab");
	//Click on the Resource Tab
	dynamicWait.get().waittillpageloads();
	userActions.get().clickOn("DocumentandVideos_tab");
	//Click on the Avaya Logo
	dynamicWait.get().waittillpageloads();
	userActions.get().clickOn("AvayaLogoclick");
	dynamicWait.get().waittillpageloads();				
	//verify the Home Page Marquee IP Office Image
	verify.get().verifyImagePresent("IP_Office_Carousel.jpg", "MarqueeFirstImage");
	//Verify the Carousal rotations
	verify.get().verifyImageCarousel("MarqueeImages");				
	//verify the perspective pods
	businessFunction.get().imageValidation("IPOffice_PerspectivePod1");
	businessFunction.get().imageValidation("IPOffice_PerspectivePod2");
	businessFunction.get().imageValidation("IPOffice_PerspectivePod3");
	//verify the tout images
	businessFunction.get().imageValidation("IPOffice_Tout1");
	businessFunction.get().imageValidation("IPOffice_Tout2");
	businessFunction.get().imageValidation("IPOffice_Tout3");
}

/**
Author Name                       : Sowmya Mohanan
Date of Preparation               : 04/08/2014
Date of Modified                  : 17-09-2014
Methods Called                    : deFocus(),clickOn(String controlName),verifyImagePresent(String expectedImage, String imageElement)
									clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle)
Purpose of Method                 : Verify the HP Segmentation for the business Size Large
Dependencies	                    : Jar files
Reviewed By                       : --

**/
@Test(description = "Verify the HP Segmentation for the business Size Large", groups = "HP Segmentation")
public void testHPSegmentationLargeUCAndCSegment3(){
	//Launching the Avaya website
	getDriver().get(appConfig.getAppUrl());
	//Hover on Products MegaMenu and click on IP Office Platform
	dynamicWait.get().waittillpageloads();
	getDriver().manage().deleteAllCookies();
	dynamicWait.get().waittillpageloads();
	businessFunction.get().deFocus();
	businessFunction.get().clickOnSubMenuItem("Products", "Products_AvayaAuraPlatform", "Products_AvayaAuraPlatform_Title");
	//Click on the Case Studies Tab
	dynamicWait.get().waittillpageloads();
	userActions.get().clickOn("CaseStudies_Tab");
	//Click on the Resource Tab
	dynamicWait.get().waittillpageloads();
	userActions.get().clickOn("DocumentandVideos_tab");
	//Click on the Avaya Logo
	dynamicWait.get().waittillpageloads();
	userActions.get().clickOn("AvayaLogoclick");
	dynamicWait.get().waittillpageloads();				
	//verify the Home Page Marquee
	verify.get().verifyImagePresent("AvayaHomePageImage.jpg", "MarqueeFirstImage");
	//Verify the Carousal rotations
	verify.get().verifyImageCarousel("MarqueeImages");				
	//verify the perspective pods
	businessFunction.get().imageValidation("IPOffice_PerspectivePod1");
	businessFunction.get().imageValidation("IPOffice_PerspectivePod2");
	businessFunction.get().imageValidation("IPOffice_PerspectivePod3");
	//verify the tout images
	businessFunction.get().imageValidation("IPOffice_Tout1");
	businessFunction.get().imageValidation("IPOffice_Tout2");
	businessFunction.get().imageValidation("IPOffice_Tout3");
}

/** 
Author Name                       : Sivanag
Date of Preparation               : 28/07/2014
Date of Modified                  : 17/09/2014
Methods Called                    : isElementPresent,clickOnSubMenuItem(businessFunction),clickOn(userActions)
									imageValidation(String imageControlName),verifyImagePresent(String expectedImage, String imageElement)
Purpose of Method                 : Verify the website display when a detail page of a product of size Large and category Networking is refreshed thrice.
Dependencies	                  : --
Reviewed By                       : --
**/

@Test(description="Verify the website display when a detail page of a product of size Large and category Networking is refreshed thrice.",groups="HP Segmentation")
public void testHPSegmentNetworking()
{
	// Launching the Avaya URL
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	// Verify whether home page is opened or not
	verify.get().isElementPresent("HomePage_Logo");
	//Clicking on EthernetRoutingSwitch4000Series link when user hover on Products	
	businessFunction.get().clickOnSubMenuItem("Products", "EthernetRoutingSwitch4000Series", "EthernetRoutingSwitch4000Series_Title");
	//Refershing the browser url
	getDriver().navigate().refresh();
	dynamicWait.get().waittillpageloads();
	//Refershing the browser url
	getDriver().navigate().refresh();
	dynamicWait.get().waittillpageloads();	
	//Clicking on Avaya Logo
	userActions.get().clickOn("AvayaLogoclick");
	dynamicWait.get().waittillpageloads();
	//Verifying the Avaya Call Center Elite Image
	verify.get().verifyImagePresent("HPmarquis_Networking.PNG", "MarqueeFirstImage");
	dynamicWait.get().waittillpageloads();
	//Verifying first perspective pod image1
	businessFunction.get().imageValidation("PerspectiveImage1");
	//Verifying  perspective pod image2
	businessFunction.get().imageValidation("PerspectiveImage2");
	//Verifying third perspective pod image3
	businessFunction.get().imageValidation("PerspectiveImage3");
	//Verifying first TOUT image1
	businessFunction.get().imageValidation("TOUTImage1");
	//Verifying second TOUT image2
	businessFunction.get().imageValidation("TOUTImage2");
	//Verifying third TOUT image3
	businessFunction.get().imageValidation("TOUTImage3");
	//Verifying spot light image
	businessFunction.get().imageValidation("Networking_SpotlightImage");  	
}

/** 
Author Name                       : Sivanag
Date of Preparation               : 28/07/2014
Date of Modified                  : 17-09-2014
Methods Called                    : isElementPresent,isTextPresent,verifyImagePresent(Verify),clickOnSubMenuItem(businessFunction),clickOn(userActions)
Purpose of Method                 : Verify the change in segments when a new session is opened.
Dependencies	                  : --
Reviewed By                       : --
Test Case Name					  :  HP Segmentation_Change in Segments_New session
**/

@Test(description="Verify the change in segments when a new session is opened.",groups="HP Segmentation")
public void testHPSegmentNewSessionPart1()
{
	// Launching the Avaya URL
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	// Verify whether home page is opened or not
	verify.get().isElementPresent("HomePage_Logo");
	//Clicking on NewPhonesPage link when user hover on Products	
	businessFunction.get().clickOnSubMenuItem("Products", "ProductsAvayaCallCenterElite", "Product_AvayaAuraCallCenterElite_Title");  
	//Clicking on Case Studies tab
	userActions.get().clickOn("CaseStudies_Tab");
	dynamicWait.get().waittillpageloads();
	//Checking the Workplacehome page
	verify.get().isTextPresent("Product_AvayaAuraCallCenterElite_Title");
	//Clicking on Resources Tab
	userActions.get().clickOn("DocumentandVideos_tab");
	dynamicWait.get().waittillpageloads();    	
	//Checking the Workplacehome page
	verify.get().isTextPresent("Products_DocumentsAndVideos_By_Category");    	 	
	//Clicking on Avaya Logo
	userActions.get().clickOn("AvayaLogoclick");
	dynamicWait.get().waittillpageloads();
	//Verifying the Avaya Call Center Elite Image
	verify.get().verifyImagePresent("AvayaCallCenterElite.PNG", "MarqueeFirstImage");
	dynamicWait.get().waittillpageloads();
	//Verify the Carousal rotations
	verify.get().verifyImageCarousel("MarqueeImages");	
	//Verifying first perspective pod image1
	businessFunction.get().imageValidation("PerspectiveImage1");
	dynamicWait.get().waittillpageloads();
	//Verifying  perspective pod image2
	businessFunction.get().imageValidation("PerspectiveImage2");
	dynamicWait.get().waittillpageloads();
	//Verifying third perspective pod image3
	businessFunction.get().imageValidation("PerspectiveImage3");
	dynamicWait.get().waittillpageloads();
	//Verifying first TOUT image1
	businessFunction.get().imageValidation("TOUTImage1");
	dynamicWait.get().waittillpageloads();
	//Verifying second TOUT image2
	businessFunction.get().imageValidation("TOUTImage2");
	dynamicWait.get().waittillpageloads();
	//Verifying third TOUT image3
	businessFunction.get().imageValidation("TOUTImage3");
	dynamicWait.get().waittillpageloads();
	//Hover on Products MegaMenu
	userActions.get().hoverOn("Products");
	dynamicWait.get().waittillpageloads();
	//Verfiy the SpotLight Image under Products Megamenu
	businessFunction.get().imageValidation("Megamenu_SpotLightImages");
	//Hover on Services MegaMenu
	userActions.get().hoverOn("Services_MegaMenu");
	dynamicWait.get().waittillpageloads();
	//Verfiy the SpotLight Image under Services Megamenu
	businessFunction.get().imageValidation("Megamenu_SpotLightImages");
	//Hover on Capabilities MegaMenu
	userActions.get().hoverOn("Solutions");
	dynamicWait.get().waittillpageloads();
	//Verfiy the SpotLight Image under Capabilities Megamenu
	businessFunction.get().imageValidation("Megamenu_SpotLightImages");
	//Hover on Partners MegaMenu
	userActions.get().hoverOn("Partners");
	dynamicWait.get().waittillpageloads();
	//Verfiy the SpotLight Image under Partners Megamenu
	businessFunction.get().imageValidation("Megamenu_SpotLightImages");
	//Hover on About Avaya MegaMenu
	userActions.get().hoverOn("MegaMenuAboutAvaya");
	dynamicWait.get().waittillpageloads();
	//Verfiy the SpotLight Image under About Avaya Megamenu
	businessFunction.get().imageValidation("Megamenu_SpotLightImages");
//	Delete cookies
	//Launching the Avaya website
	getDriver().manage().deleteAllCookies();
	dynamicWait.get().waittillpageloads();
	// Launching the Avaya URL for a new session
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	//Verifying the Default Home details
	verify.get().verifyImagePresent("AvayaHomePageImg.PNG", "MarqueeFirstImage");
} 

/** 
Author Name                       : @author karthik_b14
Date of Preparation               : 25/07/2014
Date of Modified                  : 17-09-2014
Methods Called                    : 
Purpose of Method                 : Verify the presence of content below the image carousel section
Dependencies	                   	: --
Reviewed By                       : --
* 
**/
@Test(description="Verify the presence of content below the image carousel section", groups="Events Page")
public void testEventLandingPageImgMarqueRotn(){

//navigate to event landing page url
getDriver().get(appConfig.getAppUrl());
dynamicWait.get().waittillpageloads();
businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "AboutAvaya_Events", "Events_Title");
dynamicWait.get().waittillpageloads();
businessFunction.get().deFocus();
//verify the rotation of the image carousel section
verify.get().verifyImageCarousel("EventsPageImageCarousel");
}

/** 
Author Name                       : Sivanag
Date of Preparation               : 18/07/2014
Date of Modified                  : 16-09-2014
Methods Called                    : isTextPresent(Verify),clickOn(UserActions)
Purpose of Method                 : Verify the  "Results Per Page" option
Dependencies	                  : --
Reviewed By                       : --
**/

@Test(description="Verify the  Results Per Page option",groups="About Avaya-Newsroom")
public void testNewsRoomResultperpage(){
	// Launching the Avaya URL
	getDriver().get(appConfig.getNewsRoomUrl());    		    	  
    dynamicWait.get().waittillpageloads();
    //Verifying the page title heading.
    verify.get().isTextPresent("Newsroom_Title");
    //Verifying whether Sharelink is present or not
    userActions.get().clickOn("NewsRoomMoreLink");
    dynamicWait.get().waittillpageloads();
    //Verifing whether NewsRelease page is opened or not
    verify.get().isTextPresent("NewsRoomNewRelease");	    	
    //Verify whether Results Per Page is exist in the page or not
    businessFunction.get().verifyResultsPerPage();
}

/** 
Author Name                       : @author karthik_b14
Date of Preparation               : 28/07/2014
Date of Modified                  : 16-09-2014
Methods Called                    : 
Purpose of Method                 : Verify the  "Results Per Page" option
Dependencies	                   	: --
Reviewed By                       : --
* 
**/
@Test(description="Verify the  Results Per Page option", groups="About Avaya-Newsroom")
public void testNewsRoomAvayaInNewsResultsPerPage(){
	//navigate to newroom URL
	getDriver().get(appConfig.getNewsRoomUrl());
	dynamicWait.get().waittillpageloads();
	//Newsroom Landing page should be displayed
	verify.get().isTextPresent("Newsroom_Title");
	//Click on "Avaya in the News" link present in the left navigation menu
	userActions.get().clickOn("AvayaInTheNews_Link");
	dynamicWait.get().waittillpageloads();
	//Verify the presence of Results Per Page" option Results Per Page option should be present
	verify.get().isTextPresent("NewReleaseResultsPerPage");
	businessFunction.get().getValueOfHtmlAttribute("NewsRoomDefaultPageSelection", "class");	
	businessFunction.get().verifyResultsPerPage();
}

/** 
Author Name                       : Sivanag
Date of Preparation               : 12/08/2014
Date of Modified                  : 16-09-2014
Methods Called                    : isTextPresent,isElementPresent,verifyImagePresent(verify),clickOn(userActions),
Purpose of Method                 : Verify the content of accordian box in the Premium Content Registration form B page
Dependencies	                  	: --
Reviewed By                       : --
Test Case Name					:  Premium Content Form B_Accordian box Content
**/

@Test(description="Verify the content of accordian box in the Premium Content Registration form B page",groups="Premium")
public void testAccordianBox()
{
	// Launching the Avaya URL
	getDriver().get(appConfig.getPremiumContentFormBUrl());
	dynamicWait.get().waittillpageloads();
	businessFunction.get().scrollDown();
	//Verify Accordian Box is present in the page
	verify.get().isElementDisplayed("PremiumContentForm_AccordianBox");
	businessFunction.get().validateAccordianBox();  	
}

/** 
Author Name                       : @author karthik_b14
Date of Preparation               : 18/07/2014
Date of Modified                  : 16-09-2014
Methods Called                    : 
Purpose of Method                 : Verify the Image Carousel on Phones Landing Page
Dependencies	                   	: --
Reviewed By                       : --
* 
**/
@Test(description="Verify the Image Carousel on Phones Landing Page", groups="Phones")
public void testPhoneLandingFeaturedFlagshipCarousel(){
	//navigate to app URL
	getDriver().get(appConfig.getAppUrl());
	//Click on the products tab and verify product landing page
	businessFunction.get().clickAndVerifyNavigation("Products","Products_label");
	dynamicWait.get().waittillpageloads();
	//click on phones link
	userActions.get().clickOn("Phones");
	dynamicWait.get().waittillpageloads();			
	//Verify the Products displayed
	businessFunction.get().checkSearchCount("Product_SearchResult","Product_SearchCount");			
	//Verify the Carousel Images, Buttons, Title and content
	businessFunction.get().verifyCarouselContent();
}

/** 
Author Name                       : Sivanag
Date of Preparation               : 31/07/2014
Date of Modified                  : 17/09/2014
Methods Called                    : isElementPresent,isTextPresent,verifyImagePresent(String expectedImage, String imageElement)
									clickOnSubMenuItem(businessFunction),clickOn(userActions),imageValidation(String imageControlName)
Purpose of Method                 : Verify the website display when user navigates to 3 different products of size Large and Category Customer Experience Management.
Dependencies	                  : --
Reviewed By                       : --
Test Case Name					  :  HP Segmentation_Large Customer Experience Management Segment_1
**/

@Test(description="Verify the website display when a detail page of a product of size Large and category Networking is refreshed thrice.",groups="HP Segmentation")
public void testHPSegmentMgmtSegment1()
{
	// Launching the Avaya URL
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	// Verify whether home page is opened or not
	verify.get().isElementPresent("HomePage_Logo");
	//Clicking on NewPhonesPage link when user hover on Products	
	businessFunction.get().clickOnSubMenuItem("Products", "ProductsAvayaCallCenterElite", "Product_AvayaAuraCallCenterElite_Title");
	//Clicking on NewPhonesPage link when user hover on Products	
	businessFunction.get().clickOnSubMenuItem("Products", "ProductsAvayaCallCenterElite", "Product_AvayaAuraCallCenterElite_Title");
	//Clicking on NewPhonesPage link when user hover on Products	
	businessFunction.get().clickOnSubMenuItem("Products", "ProductsAvayaCallCenterElite", "Product_AvayaAuraCallCenterElite_Title");
	//Clicking on Avaya Logo
	userActions.get().clickOn("AvayaLogoclick");
	//dynamicWait.get().waittillpageloads();
	//Verifying the Avaya Call Center Elite Image
	verify.get().verifyImagePresent("AvayaCallCenterElite.PNG", "MarqueeFirstImage");
	dynamicWait.get().waittillpageloads();
	//Verifying first perspective pod image1
	businessFunction.get().imageValidation("PerspectiveImage1");
	//Verifying  perspective pod image2
	businessFunction.get().imageValidation("PerspectiveImage2");
	//Verifying third perspective pod image3
	businessFunction.get().imageValidation("PerspectiveImage3");
	//Verifying first TOUT image1
	businessFunction.get().imageValidation("TOUTImage1");
	//Verifying second TOUT image2
	businessFunction.get().imageValidation("TOUTImage2");
	//Verifying third TOUT image3
	businessFunction.get().imageValidation("TOUTImage3");   	
}
/**
Author Name                       : Niharika K R 
Date of Preparation               : 30-06-2014
Date of Modified                  : --
Methods Called                    : clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle),
									clickAndVerifyNavigation(String navigatetopage,String pageTitle),
									verifyElementContainsText(String controlName, String controlNameExpected)
Purpose of Method                 : Verify tealium tag on avaya pages
Dependencies	                    : Jar files
Reviewed By                       : 
**/

@Test(description="Verify tealium tag on avaya pages",groups="Tealium-tag")
public void testTealiumTagVerifyOnAvayaPages()
{
	//Launching the Avaya Website
	getDriver().get(appConfig.getAppUrl());
	//To click on the Products tab
	businessFunction.get().clickAndVerifyNavigation("Products", "Products_label");
	dynamicWait.get().waittillpageloads();
	businessFunction.get().deFocus();
	getDriver().getPageSource().contains("utag.js");
//	//To click on the submenu Avaya Aura Platform from the Products megamenu
	businessFunction.get().clickOnSubMenuItem("Products", "Products_AvayaAuraPlatform", "Products_AvayaAuraPlatform_Title");
	getDriver().getPageSource().contains("utag.js");
//	//To click on the Services tab
	businessFunction.get().clickAndVerifyNavigation("Services", "Service_label");
	getDriver().getPageSource().contains("utag.js");
	//To click on the Contact Center Optimization from the Services tab
	businessFunction.get().clickOnSubMenuItem("Services", "ContactCenterOptimization", "ContactCenterOptimization_Title");
	getDriver().getPageSource().contains("utag.js");
	//To click on the Capabilities tab
	businessFunction.get().clickAndVerifyNavigation("Solutions", "Capabilities_Title");
	getDriver().getPageSource().contains("utag.js");
	//To hover on Capabilities tab in Megamenu and to click on Network Virtualization 
	businessFunction.get().clickOnSubMenuItem("Solutions", "Network_Virtualization", "Network_Virtualization_Header");
	getDriver().getPageSource().contains("utag.js");
	//To click on the Perspectives tab
	businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "Perspectives_SubMenu", "PerspectivesTitlePage");
	getDriver().getPageSource().contains("utag.js");
	//To hover on Perspectives tab in Megamenu and to click on "Unified Communications and Collaborations" tab 
	businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "Perspectives_Unified_Communications", "Perspectives_Unified_Communications_Title");
	getDriver().getPageSource().contains("utag.js");
	//To click on the Partners tab
	businessFunction.get().clickAndVerifyNavigation("Partners", "Partners_Title");
	getDriver().getPageSource().contains("utag.js");
	
	//To click on the About Avaya tab
	businessFunction.get().clickAndVerifyNavigation("MegaMenuAboutAvaya", "AboutAvayaLabel");
	getDriver().getPageSource().contains("utag.js");
	//To hover on About Avaya tab in Megamenu and to click on "" tab 
	businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "AboutAvaya_CompanyOverview", "AboutAvaya_CompanyOverview_Title");
	getDriver().getPageSource().contains("utag.js");
}

/**
Author Name                       : Sindhuja.P
Date of Preparation               : 22/09/2014
Date of Modified                  : --
Methods Called                    : clickAndVerifyNavigation(String navigatetopage,String pageTitle),verifyElementContainsText(String controlName, String controlNameExpected)
Purpose of Method                 : Verify Tealium tag on investor pages
Dependencies	                    : Jar files
Reviewed By                       : --
**/
@Test(description="Verify Tealium tag on investor pages",groups="Tealium-tag")
public void testTealiumTagverificationInvestorPages() 
{
	//Launching the Investors Avaya website
	getDriver().get(appConfig.getInvUrl());
	dynamicWait.get().waittillpageloads();
	//To navigate to Cost Basis Analysis Page
	businessFunction.get().clickAndVerifyNavigation("Investors_CostBasisAnalysis", "Investors_CostBasisAnalysis_Title");
	getDriver().getPageSource().contains("utag.js");
	//To navigate to Contact Information Analysis Page
	businessFunction.get().clickAndVerifyNavigation("Investors_ContactInformation", "Investors_ContactInformation_Title");
	getDriver().getPageSource().contains("utag.js");
	//To navigate to Cash Consideration Page
	businessFunction.get().clickAndVerifyNavigation("Investors_CashConsideration", "Investors_ContactInformation_Title");
	getDriver().getPageSource().contains("utag.js");
	//To navigate to Annual Reports Page
	businessFunction.get().clickAndVerifyNavigation("Investors_AnnualReports", "Investors_AnnualReports_Title");
	getDriver().getPageSource().contains("utag.js");
	//To navigate to SEC Filings Page
	businessFunction.get().clickAndVerifyNavigation("Investors_SECFilings", "SECFilings_Title");
	getDriver().getPageSource().contains("utag.js");
	//To navigate to Code of conduct Page
	businessFunction.get().clickAndVerifyNavigation("Investors_CodeOfConduct", "Investors_CorporateGovernance_Title");
	getDriver().getPageSource().contains("utag.js");
	//To navigate to Data privacy policy Page
	businessFunction.get().clickAndVerifyNavigation("Investors_DataPrivacyPolicy", "Investors_CorporateGovernance_Title");
	getDriver().getPageSource().contains("utag.js");
	//To navigate to Contact Board of Directors page
	businessFunction.get().clickAndVerifyNavigation("Investors_ContactBoardofDirectorslink", "Investors_CorporateGovernance_Title");
	getDriver().getPageSource().contains("utag.js");
	//To navigate to Leadership page
	businessFunction.get().clickAndVerifyNavigation("Investors_Leadership", "Investors_Leadership_Title");
	getDriver().getPageSource().contains("utag.js");		
}

/** 
  Author Name                       : Pankaj
  Date of Preparation               : 
  Date of Modified                  : 22/09/2014
  Methods Called                    : clickAndVerifyNavigation(String navigatetopage,String pageTitle)
									  clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle)
  Purpose of Method                 : Verify the functionality of proactive chat on click of chat with us
  Dependencies	                  : --
  Reviewed By                       : --
* @throws ParseException 

**/

@Test(description="Verify the functionality of proactive chat on click of chat with us",groups="Products")
public void testProactiveChatWithUs() throws ParseException, InterruptedException
{
getDriver().manage().deleteAllCookies();
// Launching the Avaya URL
getDriver().get(appConfig.getAppUrl());
dynamicWait.get().waittillpageloads();
// Click on Products link and verify whether Products page is opening or not
	//businessFunction.get().clickAndVerifyNavigation("Products", "Products_label");
dynamicWait.get().waittillpageloads();
	//Clicking on AvayaAuraCallCenterElite on hovering of Products tab in the Megamenu
businessFunction.get().clickOnSubMenuItem("Products", "AvayaAuraCallCenterElitePopUp", "AvayaAuraCallCenterEliteHomePage");
//Calling business function to validate the pop up message along with "ChatWithUs","No Thanks" options are available or not
businessFunction.get().chatPopupCheck("ChatPOPUP","ChatWithUsClick");		

}
/**
Author Name                       : Sowmya Mohanan
Date of Preparation               : 23/06/2014
Date of Modified                  : 26/06/2014
Methods Called                    : clickOn(String controlName),switchToChildWindow()
									switchToParentWindow(),sharingArticle(String controlName, String option)
Purpose of Method                 : Verify that a Article can be shared in LinkedIn in a Perspective Article page
Dependencies	                    : Jar files
Reviewed By                       : --
**/
@Test(description = "Verify that a Article can be shared in LinkedIn in a Perspective Article page",groups = "Perspectives")
public void testPerspectivesDetailPageSharelinkedIn(){
	//Launching the Avaya website
	getDriver().get(appConfig.getAppUrl());
	//Click on Perspective MegaMenu
	dynamicWait.get().waittillpageloads();
	businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "Perspectives_SubMenu", "PerspectivesTitlePage");
	//Click on Perspective Article
	dynamicWait.get().waittillpageloads();
//	userActions.get().clickOn("Perspectives_article");
	businessFunction.get().verifyArticleNavigation("Perspectives_ArticleList", "Perspectives_ArticleHeader");
	//Click on LinkedIn
	dynamicWait.get().waittillpageloads();
	userActions.get().clickOn("Perspective_article_linkedIn");
	//Share the article in linkedIn site
	businessFunction.get().shareArticleInSocialSites("LinkedInPlusData", "linkedIn");	
	//Check the Shared Link in LinkedIn page
	getDriver().get(appConfig.getLinkedInUrl());		
	businessFunction.get().validateSharedArticleInSocialSites("LinkedInPlusData", "linkedIn");
}
/** 
Author Name                       : Sivanag
Date of Preparation               : 10/07/2014
Date of Modified                  : --
Methods Called                    : clickOn,switchToChildWindow,switchToParentWindow,closeChildWindow(UserActions),isTextPresent(Verify)
Purpose of Method                 : Verify if the user is able to share the Brand Campaign landing Page Details on Linked In
Dependencies	                  : --
Reviewed By                       : --
Image							  : YES
Test Case Name					  :  Brand Camapaign_BR-F.006_Social Sharing Icon_Linked In
**/

@Test(description="Verify if the user is able to share the Brand Campaign landing Page Details on Linked In",groups="Brand Campaign")
public void testBrandCamapaignLinedIn()
{

	// Launching the Avaya URL
	getDriver().get(appConfig.getImagineUrl());
	dynamicWait.get().waittillpageloads();
	// Verifying Demand Gen Registration page is opened or not
	/**verify.get().verifyImagePresent("BrandCamapaignHeroImage.jpg",
			"BrandCamapaignHeroImage");
	// Clicking on the Image present in the First Customer Pod
	userActions.get().clickOn("BrandCamapaignHeroImage");
	dynamicWait.get().waittillpageloads();
	// Verifying the CutsomerStoryTitle details
	verify.get().isTextPresent("CustomerStoryTitle");**/
	// Clicking on LinedIn icon and verify whether LinkedIn page is opened
	// or not
	userActions.get().clickOn("LinkedIn");
	dynamicWait.get().waittillpageloads();
	// Switching to Child window
	userActions.get().switchToChildWindow();
	// Checking the LinkedIn url
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	businessFunction.get().checkUrl("LinkedIn", "contains");
/*	// Closing the child window
	userActions.get().closeChildWindow();
	// Switching to parent window
	userActions.get().switchToParentWindow();*/

}

/**
  Author Name                       : Pankaj Sharma
  Date of Preparation               : 22/09/2014
  Date of Modified                  : --
  Methods Called                    : 
  Purpose of Method                 : Verify the complete Product Information link on Tech Specs page of a product.
  Dependencies	                    : 
  Reviewed By                       : --
**/ 


@Test(description="Verify the complete Product Information link on Tech Specs page of a product.",groups="Products")
public void testProductTechSpecsCompleteInfo()
{
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	
	//To click on the Products tab
	businessFunction.get().clickAndVerifyNavigation("Products", "Products_label");
	dynamicWait.get().waittillpageloads();
	businessFunction.get().clickAndVerifyNavigation("AvayaAuraMessaging", "AvayaAuraMessagingPageTittle");
	dynamicWait.get().waittillpageloads();
	businessFunction.get().deFocus();
	userActions.get().clickOn("TechSpecs");
	dynamicWait.get().waittillpageloads();
	//userActions.get().clickOn("AvayaAuraMessaging");
	verify.get().isElementPresent("TechSpecsCompleteProductInfo");
	verify.get().verifyHttpResponse("TechSpecsCompleteProductInfo");
}
/**
Author Name                       : Pankaj Sharma
Date of Preparation               : 22/09/2014
Date of Modified                  : --
Methods Called                    : 
Purpose of Method                 : Verifies Premium Pod  on Capabilities page
Dependencies	                    : clickOn(userActions.get())
Reviewed By                       : --
**/ 

@Test(description="Verify the Premium Content module on Capabilities Detail Page",groups="Solutions")
public void testPremiumContentModule()
{
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	businessFunction.get().clickOnSubMenuItem("Solutions", "Network_Virtualization", "Network_Virtualization_Header");
	dynamicWait.get().waittillpageloads();
	businessFunction.get().verifyPremiumPodsContent("Network_PremiumPod");
	
}

/** 
Author Name                       : Pankaj
Date of Preparation               : 09/25/2014
Date of Modified                  : --
Methods Called                    : 
Purpose of Method                 : Pro active chat should not be displayed
Dependencies	                   	: --
Reviewed By                       : --
@throws Exception 
**/
@Test(description = "Pro active chat should not be displayed", groups = "Survey Pop Up")
public void testChatPopupAfterSurveyInvitation() {

// navigate to app URL
getDriver().get(appConfig.getAppUrl());
dynamicWait.get().waittillpageloads();
// Click on the Products link from mega menu System should navigate to
// Products landing page
businessFunction.get().clickAndVerifyNavigation("Products",
		"Products_label");
// Click on the Services link from mega menu and System should navigate
// to Services landing page
businessFunction.get().clickAndVerifyNavigation("Services",
		"Services_Title");
// Click on the Capabilities link from mega menu and System should
// navigate to Capabilities landing page
businessFunction.get().clickAndVerifyNavigation("Solutions",
		"Capabilities_Title");
// Navigate to product detailed page and wait for 45 seconds and Pro
// active chat should not be displayed
businessFunction.get().clickOnSubMenuItem("Products", "AvayaAuraCallCenterElitePopUp", "AvayaAuraCallCenterEliteHomePage");

//userActions.get().hoverOn("Products");
//businessFunction.get().clickAndVerifyNavigation(
		//"AvayaAuraCallCenterElitePopUp",
		//"AvayaAuraCallCenterEliteHomePage");
verify.get().isElementNotPresent("ChatPOPUP");
}

/**
Author Name                       : Sowmya Mohanan
Date of Preparation               : 18/08/2014
Date of Modified                  : --
Methods Called                    : deFocus(),clickOn(String controlName),verifyDropDownSelection(String dropDown, String valueToBeSelected),
									verifyTextEntered(String textField, String enteredText),verifyPartnerDetails()	  									 
Purpose of Method                 : Verify the Search Result for the 3 Options
Dependencies	                    : Jar files
Reviewed By                       : --
**/
@Test(description="Verify the Search Result for the 3 Options", groups = "Configuration and Provision")
public void testPartnerLocator3OptionsSearchCombination5(){
	//Lauch the Partner Locator Url
	getDriver().get(appConfig.getPartnerUrl());
	dynamicWait.get().waittillpageloads();
	businessFunction.get().deFocus();
	//select a value from country drop down and verify whether the value is selected
	businessFunction.get().verifyDropDownSelection("Partner_CountryList", "Partner_CountrtyUnitedStateSelect");
	dynamicWait.get().waittillpageloads();
	//Enter a value in City field and verify if it is entered
	businessFunction.get().verifyTextEntered("PartnerLocator_CityField", "Cortland");
	dynamicWait.get().waittillpageloads();
	//select a value from Business Size drop down and verify whether the value is selected
	businessFunction.get().verifyDropDownSelection("PartnerLocator_BusinessSizeField", "PartnerLocator_BusinessSizeMidSize");
	//click on Search button
	userActions.get().clickOn("PartnerLocator_SearchButton");
	try {
		Thread.sleep(25000);	
		businessFunction.get().verifyPartnerDetails();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		

	
}
/** 
Author Name                       : Vinusha
Date of Preparation               : 25/09/2014
Date of Modified                  : --
Methods Called                    : isTextPresent(Verify),verifyMultipleContentType,checkCssProperty(businessFunction)
Purpose of Method                 : Verify whether the categories are clickable
Dependencies	                  : --
Reviewed By                       : --
Test Case name					  : CaseforAvaya_Categories_Clickable
**/

@Test(description="Verify whether the categories are clickable",groups="About Avaya -Case Studies page")
public void testCaseStudiesCategoryClick()
{
		// Launching the Avaya URL
		getDriver().get(appConfig.getCaseStudiesUrl());	    	  
    	dynamicWait.get().waittillpageloads();
    	//Verifying the page title heading.
    	verify.get().isTextPresent("CaseStudiesHomePage");
    	//Clicking on BaseBall Pod and verify the category casestudies
    	userActions.get().clickOn("CaseStudiesBaseBallPod");
    	dynamicWait.get().waittillpageloads();
    	//Verifying whether Customer Experience Management category is selected
    	businessFunction.get().checkSelectedTabActive("CaseStudiesCategories", "Tag_List", "CUSTOMER EXPERIENCE MANAGEMENT");
    	
		   				
}

/** 
Author Name                       : Pankaj
Date of Preparation               :25/09/2014
Date of Modified                  : --
Methods Called                    : 
Purpose of Method                 : Verify the generic segment display when user navigates across products of size Large but  different categories.
Dependencies	                   	: --
Reviewed By                       : --

**/
@Test(description="Verify the generic segment display when user navigates across products of size Large but  different categories.", groups="HP Segmentation")
public void testHPSegmtnGenericSegmtDisplay2() {
	
	//navigate to app URL
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	try {
		verify.get().DownloadImage("../ParallelTestDemo/ScreenShots/image1.jpg", getDriver());
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	businessFunction.get().getValueOfHtmlAttribute("AvayaTitlePage", "title");
	/*Hover the mouse on the mega menu and click the product of category Networking and business size 'Large'*/
	//Note: currently case studies are not available for 3500 series products, so underlying locators belong to 4000 series
	businessFunction.get().clickOnSubMenuItem("Products","ProductsSubMenuEthernetRoutingSwitch4000Series", "EthernetRoutingSwitch4000PageTitle");
	dynamicWait.get().waittillpageloads();
	businessFunction.get().deFocus();
	verify.get().isElementPresent("CaseStudies_Tab");
	//Click on the Case studies tab of the product.
	userActions.get().clickOn("CaseStudies_Tab");
	//System should display Case Studies page of the Product.
	verify.get().verifyElementContainsText("CaseStudies_SearchTitle", "CaseStudies_SearchTitle");
	//System should display Overview tab of the product.
	businessFunction.get().clickOnSubMenuItem("Products","Products_AvayaAuraPlatform", "Products_AvayaAuraPlatform_Title");
	dynamicWait.get().waitforPresenceOfElementLocated("HomePage_Logo");
	//Click on the Avaya Logo on mega menu
	userActions.get().clickOn("HomePage_Logo");
	//userActions.get().clickOn("SurveyNoThankYou");
	userActions.get().clickOn("HomePage_Logo");
	dynamicWait.get().waittillpageloads();
	/*Verify the generic segment display when user navigates across products of size Large but  different categories.*/
	try {
		verify.get().DownloadImage("../ParallelTestDemo/ScreenShots/image2.jpg", getDriver());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	VerifyImage.processImage("../ParallelTestDemo/ScreenShots/image1.jpg", "../ParallelTestDemo/ScreenShots/image2.jpg");
}

/**
Author Name                       : Niharika K R 
Date of Preparation               : 21-07-2014
Date of Modified                  : 27-08-2014
Methods Called                    : verifyImageAndIndicatorButtonsCount(String imageParentControl, String imageTagName, String indicatorParentControl, String indicatorParentTagName),
									verifyImagePresent(String expectedImage, String imageElement),
									verifyCarousal(String carousalActiveImage) 
Purpose of Method                 : Verify the Image carousel on Services Landing page.
Dependencies	                    : Jar files
Reviewed By                       : 
**/

@Test(description="Verify the Image carousel on Services Landing page.",groups="Services")
public void testServicesImageCarousel()
{
	  //Launching the Avaya Website
	  getDriver().get(appConfig.getAppUrl());
	  //To navigate to the Services landing page
	  businessFunction.get().clickAndVerifyNavigation("Services", "Services_Title");
	  businessFunction.get().deFocus(); 
	  businessFunction.get().verifyCarouselContent();;
	  dynamicWait.get().waittillpageloads();
	   //To verify whether the count of indicator buttons is same as that of the images on the Carousel
	  businessFunction.get().verifyImageAndIndicatorButtonsCount("ServicesParentImage","ServicesParentIndicator");
	   //To click on the Third Indicator Button 
	  userActions.get().clickOn("ServicesThirdIndicator");
	  //To verify whether the Third Image is being displayed
	  businessFunction.get().imageValidation("ServicesThirdImage");
	 	 		  
}
/** 
Author Name                       : Pankaj
Date of Preparation               :25/09/2014
Date of Modified                  : --
Methods Called                    : 
Purpose of Method                 : Verify the generic segment display when user navigates across products of size Large but  different categories.
Dependencies	                   	: --
Reviewed By                       : --

**/

@Test(description="Verify the Capabilties Landing Page",groups="Solutions")
public void testCapabiltiesLandingPage() 
{
	//Launching the Avaya Website
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	//To click on Capabilities tab in Megamenu
	businessFunction.get().clickAndVerifyNavigation("Solutions", "Capabilities_Title");
	dynamicWait.get().waittillpageloads();
	businessFunction.get().deFocus();
	//To check the presence of Bread crumb
	businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "Capabilities_BreadCrumb_Expected","Tag_Anchors");
	//To check the images on Landing Page.
	verify.get().verifyHttpResponse("SolutionLanding_Image");	
	//To verify content next to image on Solution Landing page.
	businessFunction.get().contentValidation("SolutionLanding_Content");	
	//To check the presence of promotional Pods
	businessFunction.get().checkPodsTitle("ParentPods_Title","Tag_Header");

}


/**
  Author Name                       : Sowmya Mohanan
  Date of Preparation               : 20/09/2014
  Date of Modified                  : --
  Methods Called                    : deFocus(),clickOn(String controlName),getDBConnection(),executeQuery(String query),waittillpageloads()
  									compareValuesPresentInDatabase(String listName,ResultSet rs,String columnName)
  Purpose of Method                 : Verify Country Drop Down values in Partner Locator page
  Dependencies	                    : Jar files
  Reviewed By                       : --
 
 **/
@Test(description = "Verify Country Drop Down values in Partner Locator page")
public void testPartnerLocatorCountryDropdownValues(){
	//Connecting to Database
	dbConnection.get().getDBConnection();
	//Executing a Query in Database
	ResultSet rs = dbConnection.get().executeQuery("SELECT DISTINCT b.Country_name,a.COUNTRY_LIST__C,b.ID  FROM SFR_PARTNER_ACCOUNT_MV a "+
			"JOIN SFR_PARTNER_COUNTRY b "+
			"ON b.ID=a.COUNTRY_LIST__C "+
			"ORDER BY b.Country_name ASC");
	//Lauch the Partner Locator Url
	getDriver().get(appConfig.getPartnerUrl());
	dynamicWait.get().waittillpageloads();
	businessFunction.get().deFocus();
	//Click on Country Dropdown
	userActions.get().clickOn("Partner_CountryList");
	dynamicWait.get().waittillpageloads();
	//Verify whether the Country dropdown contains the same values as present in database
	businessFunction.get().compareValuesPresentInDatabase("PartnerLocator_CountryDropDownList", rs, "Country_name");
}
/**
Author Name                       : Sowmya Mohanan
Date of Preparation               : 12/08/2014
Date of Modified                  : --
Methods Called                    : deFocus(),clickOn(String controlName),getDBConnection(),executeQuery(String query),waittillpageloads()
									compareValuesPresentInDatabase(String listName,ResultSet rs,String columnName),
									verifyDropDownSelection(String dropDown, String valueToBeSelected),
Purpose of Method                 : Verify State/Province Drop Down values for Australia Country, in Partner Locator page
Dependencies	                    : Jar files
Reviewed By                       : --

**/
@Test
public void testPartnerLocatorStateProvinceAustralia(){
	//Connecting to Database
	dbConnection.get().getDBConnection();
	//Executing a Query in Database
	ResultSet rs = dbConnection.get().executeQuery("SELECT Distinct c.state_name,b.Country_name,a.COUNTRY_LIST__C  FROM SFR_PARTNER_ACCOUNT_MV a "
			+"JOIN SFR_PARTNER_STATE c "
			+"ON c.country_id=a.COUNTRY_LIST__C "
			+"JOIN SFR_PARTNER_COUNTRY b "
			+"ON b.id=a.COUNTRY_LIST__C "
			+"AND b.country_name='Australia' "
			+"ORDER BY c.state_name ASC");
	//Lauch the Partner Locator Url
	getDriver().get(appConfig.getPartnerUrl());
	dynamicWait.get().waittillpageloads();
	businessFunction.get().deFocus();
	//Click on Country Dropdown and select Australia
	businessFunction.get().verifyDropDownSelection("Partner_CountryList", "Partner_CountrtyAustraliaSelect");		
	//Click on State Dropdown
	userActions.get().clickOn("Partner_StateList");
	dynamicWait.get().waittillpageloads();
	//Verify whether the State dropdown contains states under Australia and are same as present in database
	businessFunction.get().compareValuesPresentInDatabase("PartnerLocator_StateDropDownList", rs, "state_name");		
}
/**
Author Name                       : Sowmya Mohanan
Date of Preparation               : 21/08/2014
Date of Modified                  : --
Methods Called                    : deFocus(),clickOn(String controlName),verifyDropDownSelection(String dropDown, String valueToBeSelected),
									verifyTextEntered(String textField, String enteredText),verifyPartnerDetails(),
									verifyTickMark(String solution,String columnName,String expertValue),getDBConnection(),
									executeQuery(String query),verifyTickFromDatabase(ResultSet rs)	  									 
Purpose of Method                 : Verify the Unified Communication(Voice) is ticked under Authorized in Partner Locator page
Dependencies	                    : Jar files
Reviewed By                       : --
**/
@Test(description="Verify the Unified Communication(Voice) is ticked under Authorized in Partner Locator page",groups="Configuration and Provision")
public void testPartnerLocatorSearchAuthorizedUnifiedCommunicationVoice(){
	//Lauch the Partner Locator Url
	getDriver().get(appConfig.getPartnerUrl());
	dynamicWait.get().waittillpageloads();
	businessFunction.get().deFocus();
	//select a value from country drop down and verify whether the value is selected
	businessFunction.get().verifyDropDownSelection("Partner_CountryList", "Partner_CountrtyUnitedStateSelect");
	dynamicWait.get().waittillpageloads();
	//Enter a value in City field and verify if it is entered
	businessFunction.get().verifyTextEntered("PartnerLocator_CityField", "New York");
	dynamicWait.get().waittillpageloads();
	//click on the Unified Communication(Voice) checkbox
	userActions.get().clickOn("PartnerLocator_UnifiedCommunication");
	dynamicWait.get().waittillpageloads();
	//verify the Contact Center checkbox is checked
	verify.get().verifyElementIsChecked("PartnerLocator_UnifiedCommunication");
	//click on Search button
	userActions.get().clickOn("PartnerLocator_SearchButton");
	try {
		Thread.sleep(25000);
		//verify the partner details
		businessFunction.get().verifyFirstPartnerDetails("PartnerLocator_FirstDetailArrow", "PartnerLocator_FirstLeftDetail");
		//verify if the Unified Communicatin(Voice) has tick in Authorized column
		businessFunction.get().verifyTickMark("Unified Communications", "Authorized", "");
		//Connecting to Database
		dbConnection.get().getDBConnection();
		//Executing a Query in Database
		ResultSet rs = dbConnection.get().executeQuery("select * from SFR_PARTNER_ACCOUNT where name like 'ALTURA%' and ZIP_POSTAL_CODE__C = '11201'");
		businessFunction.get().verifyTickFromDatabase(rs);							
		
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
/**
Author Name                       : Sowmya Mohanan
Date of Preparation               : 20/08/2014
Date of Modified                  : 10-09-2014
Methods Called                    : deFocus(),clickOn(String controlName),verifyDropDownSelection(String dropDown, String valueToBeSelected),
									verifyTextEntered(String textField, String enteredText),verifyPartnerDetails(),
									compareValuesPresentInDatabase(String listName,ResultSet rs,String columnName)	  									 
Purpose of Method                 : Verify the Search Result for the 3 Options
Dependencies	                    : Jar files
Reviewed By                       : --
**/
@Test(description="Verify the Search Result for the 2 Options", groups = "Configuration and Provision")
public void testPartnerLocator2OptionsSearchCombination1(){
	//Lauch the Partner Locator Url
	getDriver().get(appConfig.getPartnerUrl());
	dynamicWait.get().waittillpageloads();
	businessFunction.get().deFocus();
	//select a value from country drop down and verify whether the value is selected
	businessFunction.get().verifyDropDownSelection("Partner_CountryList", "Partner_CountrtyUnitedStateSelect");
	dynamicWait.get().waittillpageloads();
	//Enter a value in City field and verify if it is entered
	businessFunction.get().verifyTextEntered("PartnerLocator_CityField", "New York");
	dynamicWait.get().waittillpageloads();
	//click on Search button
	userActions.get().clickOn("PartnerLocator_SearchButton");
	try {
		Thread.sleep(25000);			
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}				
			
	//Connecting to Database
	dbConnection.get().getDBConnection();
	//Executing a Query in Database
	ResultSet rs = dbConnection.get().executeQuery("select * from SFR_PARTNER_ACCOUNT where name like 'ALTURA%' and ZIP_POSTAL_CODE__C = '11201'");
	//Click on the first arrow
	userActions.get().clickOn("PartnerLocator_FirstDetailArrow");
	try {
		Thread.sleep(20000);			
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}				
	//Compare 
	try {
	businessFunction.get().compareValuesPresentInDatabase("PopUpTitle", rs, "NAME");
	rs.beforeFirst();
	businessFunction.get().compareValuesPresentInDatabase("PartnerLocator_PopUpPhone", rs, "PHONE");
	rs.beforeFirst();
	businessFunction.get().compareValuesPresentInDatabase("PartnerLocator_PopUpWebsite", rs, "WEBSITE");
	rs.beforeFirst();
	businessFunction.get().compareValuesPresentInDatabase("PartnerLocator_PopUpPartnerLevel", rs, "AVAYA_CERTIFICATION_LEVEL__C");
	rs.beforeFirst();
	businessFunction.get().validateEmailPresentInDatabase("PartnerLocator_PopUpEmail", rs, "PRIMARY_CONTACT_EMAIL__C");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
/** 
Author Name                       : Vinusha
Date of Preparation               : 21-10-2014
Date of Modified                  :  
Methods Called                    : isElementDisplayed(String controlName), imageValidation(String imageControlName)
Purpose of Method                 : Verify the  categories under Partners tab of mega menu
Dependencies	                  : --
Reviewed By                       : --
**/

@Test(description="Verify the  categories under Partners tab of mega menu",groups="Partners")
public void testPartnersProspectiveCustomersLandingPageContent()
{
	//To navigate to the Partners landing page
	getDriver().get(appConfig.getPartnersLandingPage());
	dynamicWait.get().waittillpageloads();
	//Verify if Content is present
	businessFunction.get().contentValidation("Partner_ProspectiveCustomers_Description");
	//Click on Explore Becoming a Partner CTA
	userActions.get().clickOn("PartnersLandingPage_PartnersModuleCTA");
	dynamicWait.get().waittillpageloads();
	businessFunction.get().deFocus();
	verify.get().isElementDisplayed("Partners_ProspectiveCustomersPage_BoldText");	
}

/** 
Author Name                       : Vinusha
Date of Preparation               : 22-10-2014
Date of Modified                  :  
Methods Called                    : isElementDisplayed(String controlName), imageValidation(String imageControlName)
Purpose of Method                 : Verify the Become an Avaya Partner module on Prospective Customers Landing Page
Dependencies	                  : --
Reviewed By                       : --
**/

@Test(description="Verify the Become an Avaya Partner module on Prospective Customers Landing Page",groups="Partners")
public void testPartnersProspectiveCustomersLandingBecomeanAvayaPartnermodule()
{
	//To navigate to the Partners landing page
	getDriver().get(appConfig.getPartnersLandingPage());
	dynamicWait.get().waittillpageloads();
	//Verify if the Partner's header Text is present 
	verify.get().isTextPresent("ProspectiveCustomersPage_Title");
	//Verify if Content is present
	businessFunction.get().contentValidation("Partner_ProspectiveCustomers_Description");
	//Click on Explore Becoming a Partner CTA
	userActions.get().clickOn("PartnersLandingPage_PartnersModuleCTA");
	dynamicWait.get().waittillpageloads();
	businessFunction.get().deFocus();
	//Verify if Become Avaya Partner Module, Description and Apply Now Link is present
	verify.get().isElementDisplayed("ProspectiveCustomersPage_BecomeAvayaPartner_Module");
	//verify.get().isElementDisplayed("ProspectiveCustomersPage_BecomeAvayaPartner_Text");
	verify.get().isElementDisplayed("ProspectiveCustomersPage_BecomeAvayaPartner_Description");
	verify.get().isElementDisplayed("ProspectiveCustomersPage_BecomeAvayaPartner_ApplyNowLink");
	// Verify if Apply Now Link Navigates to Corresponding URL
	userActions.get().clickOn("ProspectiveCustomersPage_BecomeAvayaPartner_ApplyNowLink");
	businessFunction.get().checkUrl("ProspectiveCustomersPage_BecomeAvayaPartner_ApplyNowLink_URL","equal");
}

/** 
Author Name                       : Vinusha
Date of Preparation               : 22-10-2014
Date of Modified                  :  
Methods Called                    : isElementDisplayed(String controlName), imageValidation(String imageControlName)
Purpose of Method                 : Verify the Hero Image or Video on Prospective Customers Landing Page
Dependencies	                  : --
Reviewed By                       : --
**/

@Test(description="Verify the Hero Image or Video on Prospective Customers Landing Page",groups="Partners")
public void testPartnersProspectiveCustomersLandingHeroImageorVideo()
{
	//To navigate to the Partners landing page
	getDriver().get(appConfig.getPartnersLandingPage());
	dynamicWait.get().waittillpageloads();
	//Verify if the Partner's header Text is present 
	verify.get().isTextPresent("ProspectiveCustomersPage_Title");
	//Verify if Content is present
	businessFunction.get().contentValidation("Partner_ProspectiveCustomers_Description");
	//Click on Explore Becoming a Partner CTA
	userActions.get().clickOn("PartnersLandingPage_PartnersModuleCTA");
	dynamicWait.get().waittillpageloads();
	businessFunction.get().deFocus();
	//Verify if Image or Video exists
	businessFunction.get().checkImageOrVideo("Partners_ProspectiveCustomersPage_HeroImageOrVideo");
	
}

/** 
Author Name                       : Vinusha
Date of Preparation               : 22-10-2014
Date of Modified                  :  
Methods Called                    : isElementDisplayed(String controlName), imageValidation(String imageControlName)
Purpose of Method                 : Verify the Download Brochure module on Customer Landing Page
Dependencies	                  : --
Reviewed By                       : --
**/

@Test(description="Verify the Download Brochure module on Customer Landing Page",groups="Partners")
public void testPartnersProspectiveCustomersLandingDownloadBrochuremodule()
{
	//To navigate to the Partners landing page
	getDriver().get(appConfig.getPartnersLandingPage());
	dynamicWait.get().waittillpageloads();
	//Verify if the Partner's Module and header Text are present 
	verify.get().isElementDisplayed("PartnersLandingPage_CustomersModule");
	verify.get().isTextPresent("PartnersLandingPage_CustomersTitle");
	//Verify if Content is present
	businessFunction.get().contentValidation("PartnersLandingPage_CustomersModuleText");
	//Click on Explore Becoming a Partner CTA
	verify.get().isTextPresent("PartnersLandingPage_CustomersModuleCTA");
	userActions.get().clickOn("PartnersLandingPage_CustomersModuleCTA");
	dynamicWait.get().waittillpageloads();
	businessFunction.get().deFocus();
	//Verify Download Brochure module->DOWNLOAD BROCHURE title,Description,Avaya At Glance Title
	verify.get().isElementDisplayed("Customers_Downloadbrochure_Module");
	//verify.get().isElementDisplayed("CustomersPage_Downloadbrochure_Text");
	verify.get().isElementDisplayed("CustomersPage_Downloadbrochure_Description");
	verify.get().isElementDisplayed("Customer_Downloadbrochure_WhyAvayaConnect");
	verify.get().verifyHttpResponse("Customer_Downloadbrochure_WhyAvayaConnect");
	
}
/** 
Author Name                       : Vinusha
Date of Preparation               : 24-10-2014
Date of Modified                  :  
Methods Called                    : isElementDisplayed(String controlName), imageValidation(String imageControlName)
Purpose of Method                 : Verify the Partners Landing Page
Dependencies	                  : --
Reviewed By                       : --
**/
@Test(description="Verify the Partners Landing Page",groups="Partners")
public void testNewPartnersLandingPage()
{
	// Launching the Avaya Website
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	//To click on the Partners tab from the megamenu 
	businessFunction.get().clickAndVerifyNavigation("Partners", "Partners_Title");
	dynamicWait.get().waittillpageloads();
	//Verify if butler Bar,Mega Menu,Bread crumb,Chatlink is displayed
	verify.get().isElementDisplayed("ButlerBar");
	verify.get().isElementDisplayed("Megamenu");
	businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "Partners_Breadcrumb_Expected", "Tag_Anchors");
	verify.get().isElementDisplayed("Partners_ChatLink");
	//Verify Image Carousel
	verify.get().verifyImageCarousel("Carousel_Blocks");
	//Verify Image Carousel Content
	businessFunction.get().verifyCarouselContent();
	//Find APartnerModule and Become Avaya Partner
	verify.get().isElementDisplayed("PartnersLandingPage_FindAPartnerModule");
	verify.get().isElementDisplayed("PartnersLandingPage_BecomeAnAvayaPartner");
	//Verify if Develper's Module
	verify.get().isElementDisplayed("PartnersLandingPage_DevelopersModule");
	verify.get().isTextPresent("PartnersLandingPage_DevelopersTitle");
	businessFunction.get().contentValidation("PartnersLandingPage_DevelopersModuleText");
	verify.get().isElementDisplayed("PartnersLandingPage_DevelopersModuleCTA");
	//Verify Customer's Module
	verify.get().isElementDisplayed("PartnersLandingPage_CustomersModule");
	verify.get().isTextPresent("PartnersLandingPage_CustomersTitle");
	businessFunction.get().contentValidation("PartnersLandingPage_CustomersModuleText");
	verify.get().isElementDisplayed("PartnersLandingPage_CustomersModuleCTA");
	//Verify Partner's Module
	verify.get().isTextPresent("ProspectiveCustomersPage_Title");
	businessFunction.get().contentValidation("Partner_ProspectiveCustomers_Description");
	userActions.get().clickOn("PartnersLandingPage_PartnersModuleCTA");
	
	
}


/** 
Author Name                       : Vinusha
Date of Preparation               : 24-10-2014
Date of Modified                  :  
Methods Called                    : isElementDisplayed(String controlName), imageValidation(String imageControlName)
Purpose of Method                 : Verify the page rendered on accessing the URL placed with the Canoncial tags present on Case studies Source page of the Solution.
Dependencies	                  : --
Reviewed By                       : --
**/
@Test(description="Verify the page rendered on accessing the URL placed with the Canoncial tags present on Case studies Source page of the Solution.",groups="Case Studies page")
public void testCaseStudiesCanonicalTags()
{
	// Launching the Avaya Website
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	//Navigate to Video Collaboration Header
	businessFunction.get().clickOnSubMenuItem("Solutions", "Video_Collaboration", "Video_Collaboration_Header");
	//Check if the required Canonical Tag is present
	getDriver().getPageSource().contains("http://www-staging.avaya.com/usa/solution/network-virtualization/?view=customerSuccesses&sorttyp=0");
	
}

/** 
Author Name                       : Vinusha
Date of Preparation               : 24-10-2014
Date of Modified                  :  
Methods Called                    : isElementDisplayed(String controlName), imageValidation(String imageControlName)
Purpose of Method                 : Verify the page rendered on accessing the URL placed with the Canoncial tags present on Case studies Source page of the Solution.
Dependencies	                  : --
Reviewed By                       : --
**/
@Test(description="Verify the page rendered on accessing the URL placed with the Canoncial tagspresent on Overview Source page of a product",groups="Products")
public void testOverviewCanonicalTags()
{
	// Launching the Avaya Website
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	//Navigate to Video Collaboration Header
	businessFunction.get().clickOnSubMenuItem("Products", "Products_AvayaAuraPlatform", "Products_AvayaAuraPlatform_Title");
	businessFunction.get().deFocus();
	//Check if the required Canonical Tag is present
	getDriver().getPageSource().contains("http://www-staging.avaya.com/usa/product/avaya-aura-platform/");
	
}
/**
Author Name                       : Aishwarya
Date of Preparation               : 21-10-2014
Date of Modified                  : --
Methods Called                    : --
Purpose of Method                 : Verify whether Meet Ava link is present in the mega menu
Dependencies	                    : Jar files
Reviewed By                       : 
**/

@Test(description="Verify whether Meet Ava link is present in the mega menu",groups="About Avaya")
public void testMeetAvaLink()
{
	//Launching the Avaya website
	getDriver().get(appConfig.getAppUrl());
	//Wait for Page to load
	dynamicWait.get().waittillpageloads();
	//Hover on About tab in the megamenu
	userActions.get().hoverOn("MegaMenuAboutAvaya");		
	// Wait for Rollout to be displayed to locate Meet Ava link
	dynamicWait.get().waitforvisibilityOfElementLocated("MeetAvaSubMenuItem");
	//verifying the presence of Meet Ava link 
	verify.get().isElementPresent("MeetAvaSubMenuItem");
}

/**
Author Name                       : Aishwarya
Date of Preparation               : 21-10-2014
Date of Modified                  : --
Methods Called                    : clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle)
									  verifyBreadCrumb(String actualControlName, String expectedControlName,String tagName)
Purpose of Method                 : Verify the presence of bread crumb on Meet Ava page
Dependencies	                    : Jar files
Reviewed By                       : 
**/

@Test(description="Verify the presence of breadcrumb in Meet Ava page", groups="About Avaya")
public void testMeetAvaLinkBreadCrumb()
{
 //Launching the Avaya website
 getDriver().get(appConfig.getAppUrl());
 //Wait for Page to load
 dynamicWait.get().waittillpageloads();
 //Clicking on the Meet Ava link in the megamenu
 businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "MeetAvaSubMenuItem","MeetAvaTitle");
//Wait for Page to load
 dynamicWait.get().waittillpageloads();
 //verifying the presence of BreadCrumb using the business function verifyBreadCrumb 
 businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "MeetAvaBreadCrumb", "Tag_Anchors");   
}

/**
Author Name                       : Mahima
Date of Preparation               : 21-10-2014
Date of Modified                  : --
Methods Called                    : clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle)
									  verifySubMenuElements(String parentMenu,String subMenu,String delimiter)
Purpose of Method                 : Verify the presence of overview tab on Meet Ava page
Dependencies	                    : Jar files
Reviewed By                       : 
**/

@Test(description="Verify the presence of overview tab on Meet Ava page",groups="About Avaya")
public void testMeetAvaIsOverviewTabPresent()
{
	//Launching the Avaya website
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	//To click on the Meet Ava tab from the megamenu 
	businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "MeetAvaSubMenuItem", "MeetAvaTitle");		
	//To check if Overview tab only is present		
	businessFunction.get().verifySubMenuElements("MeetAvaSubNav", "Tag_Anchors", ",");	
	
			
}
/**
Author Name                       : Mahima
Date of Preparation               : 27-10-2014
Date of Modified                  : --
Methods Called                    : clickAndVerifyNavigation(String navigatetopage,String pageTitle)
									checkProductTypeFiltersWithoutCount(String filter)
Purpose of Method                 : Verify the presence of cloud filter in product type filter in the left toggle menu of product landing page
Dependencies	                  : Jar files
Reviewed By                       : 
**/

@Test(description="Verify the presence of cloud filter in product type filter in the left toggle menu of product landing page",groups="Cloud")
public void testProductsLandingCloudFilter()
{
	//Launching the Avaya website
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	//To click on the Products tab from the megamenu 
	businessFunction.get().clickAndVerifyNavigation("Products", "Products_label");	
	//To check if Cloud filter is present within Product type filter on Product Landing Page
	businessFunction.get().checkProductTypeFiltersWithoutCount("ProductTypeCloudFilter");		
					
}

/**
Author Name                       : Mahima
Date of Preparation               : 27-10-2014
Date of Modified                  : --
Methods Called                    : validateMegamenuLinks(String parentMenu)
									imageValidation(String imageControlName)
									clickAndVerifyNavigation(String navigatetopage,String pageTitle)
									verifyCloudSubCategories(String parentMenu,String delimiter)
Purpose of Method                 : Verify the subcategories under cloud in the mega menu
Dependencies	                  : Jar files
Reviewed By                       : 
**/

@Test(description="Verify the subcategories under cloud in the mega menu",groups="Cloud")
public void testsubCategoriesUnderCloud()
{
	//Launching the Avaya website
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	//Hover on the Products tab from the megamenu 
	userActions.get().hoverOn("Products");
	//To check visibility of Categories under Products
	dynamicWait.get().waitforvisibilityOfElementLocated("Products_Categories");
	//To validate Categories under Products
	businessFunction.get().verifyMenuOrCategoryLinks("Products_Categories");	
	//To check visibility of Spotlight image for Products
	dynamicWait.get().waitforvisibilityOfElementLocated("Products_SpotlightImages");
	//To validate  Spotlight image for Products		
	businessFunction.get().imageValidation("Products_SpotlightImages");
	//To check visibility of Spotlight image description for Products
	dynamicWait.get().waitforvisibilityOfElementLocated("ProductsSpotlight_Description");
	//To validate  Spotlight image description for Products
	verify.get().isElementPresent("ProductsSpotlight_Description");
	//To check visibility of Spotlight image CTA for Products
	dynamicWait.get().waitforvisibilityOfElementLocated("ProductsSpotlight_CTA");
	//To validate  Spotlight image CTA for Products
	verify.get().isElementPresent("ProductsSpotlight_CTA");
	//To verify  navigation to Cloud Landing Page
	businessFunction.get().clickAndVerifyNavigation("Products_CloudLink", "CloudPageTitle");
	dynamicWait.get().waittillpageloads();
	//To verify logo in the megamenu on Cloud Landing Page
	verify.get().isElementPresent("HomePage_Logo");
	//Hover on Products
	userActions.get().hoverOn("Products");
	dynamicWait.get().waitforvisibilityOfElementLocated("CloudParent");
	//To verify  megamenu tabs on Cloud Landing Page
	businessFunction.get().verifyCloudSubCategories("CloudParent",",");
						
}


/**
Author Name                       : Mahima
Date of Preparation               : 14-11-2014
Date of Modified                  : --
Methods Called                    : clickAndVerifyNavigation(String navigatetopage,String pageTitle)
									verifySubMenuElements(String parentMenu,String subMenu,String delimiter)
									checkCssProperty(String controlName, String cssProperty)
									contentValidation(String controlName)
Purpose of Method                 : Verify the Investors tab on Contacts page
Dependencies	                  : Jar files
Reviewed By                       : 
**/

@Test(description="Verify the Investors tab on Contacts page", groups="Contacts")
public void testinvestorstabincontactspage()
{
      //To launch the Avaya application
      getDriver().get(appConfig.getAppUrl());
      dynamicWait.get().waittillpageloads();
      businessFunction.get().clickAndVerifyNavigation("Contacts","Contacts_Title");
      dynamicWait.get().waittillpageloads();
       //verify if Investors Tab is present
      businessFunction.get().verifySubMenuElements("Contacts_Pane", "Tag_Anchors", ",");
      userActions.get().clickOn("ContactsInvestorsTab");
      dynamicWait.get().waittillpageloads();
      businessFunction.get().deFocus();
      // To verify whether the colour of investors tab is grey
      businessFunction.get().checkCssProperty("InvestorsTab_Colour", "background-color");
      //To Verify the content in investors tab
      businessFunction.get().contentValidation("ContactsInvestorsText");

}

/** 
Author Name                       : Mahima 
Date of Preparation               : 17-11-2014
Date of Modified                  : -- 
Methods Called                    : verifyBreadCrumb(String actualControlName, String expectedControlName,String tagName)
									socialIcons(String controlName,String childElement,String attribute)
									pageAllignment(String relativeControlName, String controlName, String position)
Purpose of Method                 : Verify whether the Enagagement Launch Microsite Home Page 
									is launched successfully
Dependencies	                  : --
Reviewed By                       : --
**/

@Test(description="Verify whether the Enagagement Launch Microsite Home Page is launched successfully", groups="Engagement Launch Microsite")
public void testEnagagementLaunchMicrosite()
{
	//To launch the Avaya application
	getDriver().get(appConfig.getEngagementLaunchMicrositeUrl());
	dynamicWait.get().waittillpageloads();
	//To verify whether the Global Header is present or not
	verify.get().isElementDisplayed("Global_Header");
	//To check the presence of Global footer 
	verify.get().isElementDisplayed("GlobalFooter");
	//verifying the presence of BreadCrumb 
	businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "ELMBreadCrumb","Tag_Anchors");
	//verifying the presence of Title on ELM page 
	verify.get().isTextPresent("ELMTitle");
	//verifying the presence of Social Media icons 
	businessFunction.get().socialIcons("ELMSocialIcons","CaseStudies_SocialIcons_Child","class");
	//verifying the presence of Feedback buttons
	businessFunction.get().pageAllignment("ButlerBar", "Feedback", "extremeRight");
}

/**
Author Name                       : Aishwarya
Date of Preparation               : 18/11/2014
Date of Modified                  : --
Methods Called                    : clickOn(String controlName),clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle), sendinputdata(String controlName, String option, String searchControlName)
Purpose of Method                 : Verify whether the Premium Content form is displayed on the UI after the publishing is done
Dependencies
                  : --
Reviewed By                       : --
**/ 
@Test(description="Verify whether the Premium Content form is displayed on the UI after the publishing is done", groups="Premium Content Form")
public void testVerifyPremiumRegistrationUrl(){
try{
					//Launch the avaya website
                   getDriver().get(appConfig.getAppUrl());
                   // clear cookies
                   getDriver().manage().deleteAllCookies();
                   dynamicWait.get().waittillpageloads();
                   businessFunction.get().deFocus();
                   //Hover on Products tab and click on Avaya Aura Conferencing link
                   businessFunction.get().clickOnSubMenuItem("Products","AvayaAuraConferencing", "Product_AvayaAuraConferencing_Title");
                   dynamicWait.get().waittillpageloads();
                   businessFunction.get().deFocus();
                   //Click on Documents and Videos tab
                   userActions.get().clickOn("DocumentsAndVideos");
                   businessFunction.get().deFocus();
                   //Click on the link named Avaya Aura Conferencing Fact Sheet
                   userActions.get().clickOn("AvayaAuraConferencingFactSheet");
                   dynamicWait.get().waittillpageloads();
                   //To enter the data in the fields
                   businessFunction.get().sendinputdata("RegistrationInputdata", "registration","none");
                   //Click on Submit button
                   userActions.get().clickOn("Registration_Submit");
                   dynamicWait.get().waittillpageloads();
                   //Click on GetIt button
                   userActions.get().clickOn("GetItButton");
                   dynamicWait.get().waittillpageloads();
                   Thread.sleep(20000);
                   //To verify the url 
                   businessFunction.get().checkUrl("PremiumRegistrationDocumentUrl","contains");
                   }
               catch (InterruptedException e) 
                   {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                   }
}

/** 
Author Name                       : Mahima 
Date of Preparation               : 05-12-2014
Date of Modified                  : -- 
Methods Called                    : pageAllignment(String relativeControlName, String controlName, String position)
Purpose of Method                 : Verify the presence of Solutions tab in the mega menu
Dependencies	                  : --
Reviewed By                       : --
**/

@Test(description="Verify the presence of Solutions tab in the mega menu", groups="Home Page")
public void testSolutionsTabInMegamenu()
{
	//To launch the Avaya application
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	//To verify whether the Global Header is present or not
	verify.get().isElementDisplayed("Global_Header");	
	//verifying the position of Solutions tab
	businessFunction.get().pageAllignment("Solutions","Products", "right");
}

/** 
Author Name                       : Mahima 
Date of Preparation               : 08-12-2014
Date of Modified                  : -- 
Methods Called                    : verifySubMenuElements(String parentMenu,String subMenu,String delimiter)
Purpose of Method                 : Verify the categories present for Solutions category
Dependencies	                  : --
Reviewed By                       : --
**/

@Test(description="Verify the categories present for Solutions category", groups="Home Page")
public void testSolutionCategoriesInMegamenu()
{
	//To launch the Avaya application
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	//Hover on Solutions tab of megamenu
	userActions.get().hoverOn("Solutions");
	//verify the categories under Solutions tab of megamenu
	businessFunction.get().verifySubMenuElements("HomePage_SolutionsCategories", "Tag_Div",",");
}

/** 
Author Name                       : Mahima 
Date of Preparation               : 08-12-2014
Date of Modified                  : -- 
Methods Called                    : clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle)
									verifyDropDownSelection(String dropDown, String valueToBeSelected)
									verifyTextEntered(String textField, String enteredText)
									verifyPartnerDetails()
Purpose of Method                 : Verify whether a pop up containing two tables is displayed over the map in the Partner Locator page.
Dependencies	                  : --
Reviewed By                       : --
**/

@Test(description="Verify whether a pop up containing two tables is displayed over the map in the Partner Locator page.", groups="Partner Locator")
public void testTablesOnPartnerPopPup()
{
	//To launch the Avaya application
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	//Hover on Solutions tab of megamenu
	userActions.get().hoverOn("Partners");
	//Navigate to Partner locator page
  	businessFunction.get().clickOnSubMenuItem("Partners", "Partners_FindAPartner", "PartnerLocator_Title");
	businessFunction.get().verifyDropDownSelection("Partner_CountryList", "Partner_CountryUSASelect");
	//To enter "New York" in the City Text Box and to check if system has accepted the input
	businessFunction.get().verifyTextEntered("PartnerLocator_CityField", "San Jose");
	//To click on "Search" Button
	userActions.get().clickOn("PartnerLocator_SearchButton");
	try {
		Thread.sleep(25000);
		//Verify the Partner Details
		businessFunction.get().verifyPartnerDetails();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

/** 
Author Name                       : Mahima 
Date of Preparation               : 08-12-2014
Date of Modified                  : -- 
Methods Called                    : pageAllignment(String relativeControlName, String controlName, String position)
									verifySubMenuElements(String parentMenu,String subMenu,String delimiter)
Purpose of Method                 : Verify the presence of View By section in the right hand navigational pane.
Dependencies	                  : --
Reviewed By                       : --
**/

@Test(description="Verify the presence of View By section in the right hand navigational pane.", groups="Case Studies")
public void testViewBySectionCaseStudies()
{
	//To launch the Avaya application
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	//Click on Case Studies tab of megamenu
	userActions.get().clickOn("CaseStudies_MegaMenu");
	//Prescence of View by section 
	verify.get().isElementDisplayed("CaseStudiesLandingPage_View By");
	//Prescence of text - View by  
	verify.get().isTextPresent("CaseStudiesLandingPage_View By_Title");
	//View by section above Business Size section
	businessFunction.get().pageAllignment("CaseStudiesLandingPage_View By","CaseStudiesLandingPage_BusinessSize", "above");
	//View by section below Search section
	businessFunction.get().pageAllignment("CaseStudiesLandingPage_Search","CaseStudiesLandingPage_View By", "above");
	//Verify options in View By section
	businessFunction.get().verifySubMenuElements("CaseStudiesLandingPage_View By_Options","Tag_Anchors",",");

}

/** 
Author Name                       : Mahima 
Date of Preparation               : 08-12-2014
Date of Modified                  : -- 
Methods Called                    : clickAndVerifyNavigation(String navigatetopage,String pageTitle)									
Purpose of Method                 : Verify the navigation to Team Engagement tab when Unified communciations and Collaboration is clicked in View By section
Dependencies	                  : --
Reviewed By                       : --
**/

@Test(description="Verify the navigation to Team Engagement tab when Unified communciations and Collaboration is clicked in View By section", groups="Case Studies")
public void testCaseStudiestoTeamEngagementNavigation()
{
	//To launch the Avaya application
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	//Click on Case Studies tab of megamenu
	businessFunction.get().clickAndVerifyNavigation("CaseStudies_MegaMenu","Page_Title");	
	//Navigation to Team Engagement Page
	businessFunction.get().clickAndVerifyNavigation("CaseStudiesLandingPage_View By_UC&C","Capabilities_Title");
}

/** 
Author Name                       : Aishwarya 
Date of Preparation               : 01-12-2015
Date of Modified                  : -- 
Methods Called                    : clickAndVerifyNavigation(String navigatetopage,String pageTitle)									
Purpose of Method                 : Verify whether a pop up is displayed when Chat Icon is clicked in the Events Landing page.
Dependencies	                  : --
Reviewed By                       : --
**/

@Test(description="Verify whether a pop up is displayed when Chat Icon is clicked in the Events Landing page.", groups="Events")
public void testEventsLandingPageChatIcon()
{
	//To launch the Avaya application
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	//Click on Case Studies tab of megamenu
	businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "AboutAvaya_Events", "Events_Title");
	businessFunction.get().deFocus();
	verify.get().isElementDisplayed("ChatIcon");
	businessFunction.get().checkCssProperty("ChatIcon", "text-align");
	//businessFunction.get().pageAllignment("MegaMenuAboutAvaya", "ChatIcon", "below");
}

/** 
Author Name                       : Aishwarya 
Date of Preparation               : 01-12-2015
Date of Modified                  : -- 
Methods Called                    : clickAndVerifyNavigation(String navigatetopage,String pageTitle)									
Purpose of Method                 : Verify whether system is navigated to the respective listings page when See All link under Featured Conferences and Trade Shows section is clicked.
Dependencies	                  : --
Reviewed By                       : --
**/

@Test(description="Verify whether system is navigated to the respective listings page when See All link under Featured Conferences and Trade Shows section is clicked.", groups="Events")
public void testEventsLandingPageEventsSecFeaturedConfSeeAll()
{
	//To launch the Avaya application
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	//Click on Case Studies tab of megamenu
	businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "AboutAvaya_Events", "Events_Title");
	businessFunction.get().deFocus();
	verify.get().isElementDisplayed("ChatIcon");
	businessFunction.get().checkCssProperty("ChatIcon", "text-align");
	//businessFunction.get().pageAllignment("MegaMenuAboutAvaya", "ChatIcon", "below");
	verify.get().verifyEventsSectionCategories("EventLandinPageMainPOD", "EventSectionSubCategories");
	businessFunction.get().clickAndVerifyNavigation("ConferencesTradeShows_SeeAll", "EventCalendarPageTittle");
	Assert.assertEquals(userActions.get().getHtmlAttribute("ConferencesAndTradeShowsEventTypeCheckBox", "Checked"), "true");
	verify.get().verifyEventsCategorization("SelectedFilterLabel","EventTypes");
	
	
}

/** 
Author Name                       : Aishwarya 
Date of Preparation               : 01-12-2015
Date of Modified                  : -- 
Methods Called                    : clickAndVerifyNavigation(String navigatetopage,String pageTitle)									
Purpose of Method                 : 
Dependencies	                  : --
Reviewed By                       : --
 
**/

@Test(description="Verify the functionality on click of follow us link in the twitter Tout in events landing page", groups="Events") 
public void testEventsTwitterToutFollowUsLink() throws InterruptedException
{
	//To launch the Avaya application
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	//Click on Case Studies tab of megamenu
	businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "AboutAvaya_Events", "Events_Title");
	businessFunction.get().deFocus();
	businessFunction.get().verifyTwitterTout();
	userActions.get().clickOn("twitter_link");
	dynamicWait.get().waittillpageloads();
	userActions.get().switchToChildWindow();
	businessFunction.get().checkUrl("twitter_title", "equal");
	
	
}

/** 
Author Name                       : Aishwarya 
Date of Preparation               : 01-12-2015
Date of Modified                  : -- 
Methods Called                    : clickAndVerifyNavigation(String navigatetopage,String pageTitle)									
Purpose of Method                 : 
Dependencies	                  : --
Reviewed By                       : --
**/

@Test(description="Verify the content in Promotional Marquee section in Events page", groups="Events")
public void testEventsPromotionalMarquee()
{
	//To launch the Avaya application
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	//Click on Case Studies tab of megamenu
	businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "AboutAvaya_Events", "Events_Title");
	businessFunction.get().deFocus();
	businessFunction.get().verifyCarouselContent();
	
	
}


/** 
Author Name                       : Aishwarya 
Date of Preparation               : 01-12-2015
Date of Modified                  : -- 
Methods Called                    : clickAndVerifyNavigation(String navigatetopage,String pageTitle)									
Purpose of Method                 : 
Dependencies	                  : --
Reviewed By                       : --
**/

@Test(description="Verify whether the results displayed are according to the search criteria when selected Past Events check box", groups="Events")
public void testEventsListingPageDateFilterPastEvents()
{
	//To launch the Avaya application
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	//Click on Case Studies tab of megamenu
	businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "AboutAvaya_Events", "Events_Title");
	businessFunction.get().deFocus();
	businessFunction.get().clickAndVerifyNavigation("ViewAllEvents", "EventCalendarPageTittle");
	userActions.get().clickOn("DateFilterPastEventsChkBox");
	verify.get().verifyDateOfPastEventsOrArticles("EventsListingPageEventsDate");
	
	
}

/** 
Author Name                       : Aishwarya 
Date of Preparation               : 01-12-2015
Date of Modified                  : -- 
Methods Called                    : clickAndVerifyNavigation(String navigatetopage,String pageTitle)									
Purpose of Method                 : 
Dependencies	                  : --
Reviewed By                       : --
**/

@Test(description="Verify whether the results displayed are according to the search criteria when selected Past Events check box", groups="Events")
public void testEventsListingPageEventslistings()
{
	//To launch the Avaya application
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	//Click on Case Studies tab of megamenu
	businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "AboutAvaya_Events", "Events_Title");
	//businessFunction.get().deFocus();
	dynamicWait.get().waittillpageloads();
	businessFunction.get().clickAndVerifyNavigation("ViewAllEvents", "EventCalendarPageTittle");

	businessFunction.get().verifyEventsListingContent("EventListings");
	
	
}

/** 
Author Name                       : Aishwarya 
Date of Preparation               : 01-12-2015
Date of Modified                  : -- 
Methods Called                    : clickAndVerifyNavigation(String navigatetopage,String pageTitle)									
Purpose of Method                 : 
Dependencies	                  : --
Reviewed By                       : --
**/

@Test(description="Verify the Content Widgets On the Future Customer Event Detail Page.", groups="Events")
public void Future()
{
	//To launch the Avaya application
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	//Click on Case Studies tab of megamenu
	businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "AboutAvaya_Events", "Events_Title");
	businessFunction.get().deFocus();
	businessFunction.get().clickAndVerifyNavigation("ConferencesTradeShows_SeeAll", "EventCalendarPageTittle");
	userActions.get().clickOn("Next90DaysChkBox");
	dynamicWait.get().waittillpageloads();
	userActions.get().clickOn("FirstEventArticleLink");
	dynamicWait.get().waittillpageloads();
	verify.get().isElementDisplayed("EventRegisterNow");
	verify.get().isElementDisplayed("EventsAddToCalendar");
	businessFunction.get().contentValidation("EventDescription");
}

/** 
Author Name                       : Aishwarya 
Date of Preparation               : 13-01-2015
Date of Modified                  : -- 
Methods Called                    : clickOnSubMenuItem(String,String,String)									
Purpose of Method                 : 
Dependencies	                  : --
Reviewed By                       : --
**/

@Test(description="Verify the Title  in the Events Landing page.",groups="Events")
public void testLandingPageEventsTitle()
{
	getDriver().get(appConfig.getAppUrl());
	businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "AboutAvaya_Events", "Events_Title");
}

/** 
Author Name                       : Aishwarya 
Date of Preparation               : 13-01-2015
Date of Modified                  : -- 
Methods Called                    : clickOnSubMenuItem(String,String,String),isTextPresent(String)								
Purpose of Method                 : 
Dependencies	                  : --
Reviewed By                       : --
**/
@Test(description="Verify the functionality of the Events Search when a wrong search keyword is given.",groups="Events")
public void testEventsSearchWithInvalidInput()
{
	getDriver().get(appConfig.getAppUrl());
	businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "AboutAvaya_Events", "Events_Title");
	dynamicWait.get().waittillpageloads();
	userActions.get().enterText("Events_SearchBox", "@#$@#$!@#$");
	userActions.get().clickOn("Events_SearchButton");
	verify.get().isTextPresent("Events_NoResultsArea");
}

/** 
Author Name                       : Aishwarya 
Date of Preparation               : 13-01-2015
Date of Modified                  : -- 
Methods Called                    : clickOnSubMenuItem(String,String,String),searchValidResults(String,String)								
Purpose of Method                 : 
Dependencies	                  : --
Reviewed By                       : --
**/
@Test(description="Verify the functionality of the Events Search when an Event Name/Title is given.",groups="Events")
public void testEventsSearchWithValidInputs()
{
	getDriver().get(appConfig.getAppUrl());
	businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "AboutAvaya_Events", "Events_Title");
	dynamicWait.get().waittillpageloads();
	userActions.get().enterText("Events_SearchBox", "IP Video Surveillance Deployment Webinar");
	userActions.get().clickOn("Events_SearchButton");
	businessFunction.get().searchValidResults("Events_ResultsArea", "IP Video Surveillance Deployment Webinar");
}

/** 
Author Name                       : Aishwarya 
Date of Preparation               : 13-01-2015
Date of Modified                  : -- 
Methods Called                    : clickOnSubMenuItem(String,String,String),contentValidation(String)								
Purpose of Method                 : 
Dependencies	                  : --
Reviewed By                       : --
**/
@Test(description="Verify the functionality of the Events Search when a no keyword is given.",groups="Events")
public void testEventsSearchWithoutInput()
{
	getDriver().get(appConfig.getAppUrl());
	businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "AboutAvaya_Events", "Events_Title");
	dynamicWait.get().waittillpageloads();
	userActions.get().clickOn("Events_SearchButton");
	dynamicWait.get().waittillpageloads();
	businessFunction.get().contentValidation("Events_ResultsArea");
}

/** 
Author Name                       : Aishwarya 
Date of Preparation               : 13-01-2015
Date of Modified                  : -- 
Methods Called                    : clickOnSubMenuItem(String,String,String),pageAlignment(String,String,String)								
Purpose of Method                 : 
Dependencies	                  : --
Reviewed By                       : --
**/
@Test(description="Verify the Browse Events Tout in events landing page", groups="Events")
public void testBrowseEventsPodPosition()
{
	getDriver().get(appConfig.getAppUrl());
	businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "AboutAvaya_Events", "Events_Title");
	dynamicWait.get().waittillpageloads();
	businessFunction.get().pageAllignment("Events_SearchPod","Events_BrowseEventsPod", "above");
}

/** 
Author Name                       : Aishwarya 
Date of Preparation               : 13-01-2015
Date of Modified                  : -- 
Methods Called                    : clickOnSubMenuItem(String,String,String),verifyBreadCrumb(String,String,String)								
Purpose of Method                 : 
Dependencies	                  : --
Reviewed By                       : --
**/
@Test(description="Verify the presence of Bread Crumb in Events Listing Page")
public void testEventsListingBreadCrumb()
{
	getDriver().get(appConfig.getAppUrl());
	businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "AboutAvaya_Events", "Events_Title");
	dynamicWait.get().waittillpageloads();
	userActions.get().clickOn("Events_EventListing_ConfAndTradShow");
	businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "Events_EventListing", "Tag_Anchors");
}

/** 
Author Name                       : Aishwarya 
Date of Preparation               : 13-01-2015
Date of Modified                  : -- 
Methods Called                    : clickOnSubMenuItem(String,String,String),dateFormatCheck(String)								
Purpose of Method                 : 
Dependencies	                  : --
Reviewed By                       : --
**/
@Test(description="Verify the presence of Date & Location below the Event title in the Event Detail Page.")
public void testEventDateAndLocation()
{
	getDriver().get(appConfig.getAppUrl());
	businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "AboutAvaya_Events", "Events_Title");
	dynamicWait.get().waittillpageloads();
	userActions.get().clickOn("Events_EventListing_ConfAndTradShow");
	dynamicWait.get().waittillpageloads();
	userActions.get().clickOn("Event");
	verify.get().isElementDisplayed("Events_EventDate");
	businessFunction.get().dateFormatCheck("Events_EventDate");
	verify.get().isElementDisplayed("Events_EventLocation");
}

/** 
Author Name                       : Aishwarya 
Date of Preparation               : 13-01-2015
Date of Modified                  : -- 
Methods Called                    : clickOnSubMenuItem(String,String,String),verifyPageTitle(String)								
Purpose of Method                 : 
Dependencies	                  : --
Reviewed By                       : --
**/
@Test(description="Verify whether navigation is successful to Events Detail page",groups="Events")
public void testEventsPageNavigation()
{
	getDriver().get(appConfig.getAppUrl());
	businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "AboutAvaya_Events", "Events_Title");
	dynamicWait.get().waittillpageloads();
	userActions.get().clickOn("Events_EventListing_ConfAndTradShow");
	verify.get().verifyPageTitle("Title_EventsCalendar");
	userActions.get().clickOn("Event");
}

/** 
Author Name                       : Aishwarya 
Date of Preparation               : 13-01-2015
Date of Modified                  : -- 
Methods Called                    : clickOnSubMenuItem(String,String,String),imageValidation(String)								
Purpose of Method                 : 
Dependencies	                  : --
Reviewed By                       : --
**/
@Test(description="Verify the presence of Map Image placeholder for an event which does not have an image associated to it.",groups="Events")
public void testEventsImagePlaceHolder()
{
	getDriver().get(appConfig.getAppUrl());
	businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "AboutAvaya_Events", "Events_Title");
	dynamicWait.get().waittillpageloads();
	userActions.get().clickOn("Events_EventListing_ConfAndTradShow");
	dynamicWait.get().waittillpageloads();
	userActions.get().clickOn("Event");
	dynamicWait.get().waittillpageloads();
	businessFunction.get().imageValidation("Events_ImagePlaceHolder");

}

/** 
Author Name                       : Aishwarya 
Date of Preparation               : 13-01-2015
Date of Modified                  : -- 
Methods Called                    : clickOnSubMenuItem(String,String,String),isElementDisplayed(String),isTextPresent(String)								
Purpose of Method                 : 
Dependencies	                  : --
Reviewed By                       : --
**/
@Test(description="Verify the message displayed when there are no events present for a filter.",groups="Events")
public void testEventsFilterNoResults()
{
	getDriver().get(appConfig.getAppUrl());
	businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "AboutAvaya_Events", "Events_Title");
	dynamicWait.get().waittillpageloads();
	userActions.get().clickOn("Events_EventListing_ConfAndTradShow");
	userActions.get().enterText("Events_SearchBox", "@#$@#$!@#$");
	userActions.get().clickOn("Events_FilterPageSearch");
	verify.get().isTextPresent("Events_NoResultsArea");
	verify.get().isElementDisplayed("Events_ClearAllFiltersLink");
}

/** 
Author Name                       : Aishwarya 
Date of Preparation               : 13-01-2015
Date of Modified                  : -- 
Methods Called                    : clickOnSubMenuItem(String,String,String),isElementDisplayed(String),checkYourSelection(String)								
Purpose of Method                 : 
Dependencies	                  : --
Reviewed By                       : --
**/
@Test(description="Verify the Default Filter Settings in the Event Listing Page.",groups="Events")
public void testEventsDefaultFilterSettings()
{
	getDriver().get(appConfig.getAppUrl());
	businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "AboutAvaya_Events", "Events_Title");
	dynamicWait.get().waittillpageloads();
	userActions.get().clickOn("Events_EventListing_ConfAndTradShow");
	dynamicWait.get().waittillpageloads();
	verify.get().isElementDisplayed("Events_CategoryTagNames");
	userActions.get().clickOn("Events_FilterNV");
	businessFunction.get().checkYourSelection("Events_CategoryTagNames", "categoryTagName");
}


/** 
Author Name                       : Aishwarya 
Date of Preparation               : 15-01-2015
Date of Modified                  : -- 
Methods Called                    : clickOnSubMenuItem(String,String,String),checkFutureEventStartDate(String)								
Purpose of Method                 : 
Dependencies	                  : --
Reviewed By                       : --
**/
@Test(description="Verify Event Status Label on the Future Customer Event Detail Page.",groups="Events")
public void testFutureEventStatusLabel()
{
	getDriver().get(appConfig.getAppUrl());
	businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "AboutAvaya_Events", "Events_Title");
	dynamicWait.get().waittillpageloads();
	userActions.get().clickOn("Events_EventListing_ConfAndTradShow");
	dynamicWait.get().waittillpageloads();
	userActions.get().clickOn("Events_FutureEvent");
	dynamicWait.get().waittillpageloads();
	businessFunction.get().checkFutureEventStartDate("Events_FutureEventDate");
}

/** 
Author Name                       : Aishwarya 
Date of Preparation               : 15-01-2015
Date of Modified                  : -- 
Methods Called                    : clickOnSubMenuItem(String,String,String),contentValidation(String)								
Purpose of Method                 : 
Dependencies	                  : --
Reviewed By                       : --
**/
@Test(description="Verify the presence of Avaya Partner Event Label on Future Partner Event Detail Page.",groups="Events")
public void testEventsPartnerEventLabel()
{
	getDriver().get(appConfig.getAppUrl());
	businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "AboutAvaya_Events", "Events_Title");
	dynamicWait.get().waittillpageloads();
	userActions.get().clickOn("Events_EventListing_ConfAndTradShow");
	dynamicWait.get().waittillpageloads();
	userActions.get().clickOn("Events_FutureEvent");
	dynamicWait.get().waittillpageloads();
	businessFunction.get().contentValidation("Events_EventLabel");
}

/** 
Author Name                       : Aishwarya 
Date of Preparation               : 15-01-2015
Date of Modified                  : -- 
Methods Called                    : clickOnSubMenuItem(String,String,String),verifyHttpResponse(String)								
Purpose of Method                 : 
Dependencies	                  : --
Reviewed By                       : --
**/
@Test(description="Verify whether Event Title is clickable.",groups="Events")
public void testEventsTitle()
{
	getDriver().get(appConfig.getAppUrl());
	businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "AboutAvaya_Events", "Events_Title");
	dynamicWait.get().waittillpageloads();
	verify.get().verifyHttpResponse("Events_EventTitle");
}

/** 
Author Name                       : Aishwarya 
Date of Preparation               : 15-01-2015
Date of Modified                  : -- 
Methods Called                    : clickOnSubMenuItem(String,String,String),isElementDisplayed(String)								
Purpose of Method                 : 
Dependencies	                  : --
Reviewed By                       : --
**/
@Test(description="Verify the presence of 'Add to Calendar+' button on the Future Customer Event Detail Page.",groups="Events")
public void testEventsAddToCalendar()
{
	getDriver().get(appConfig.getAppUrl());
	businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "AboutAvaya_Events", "Events_Title");
	dynamicWait.get().waittillpageloads();
	userActions.get().clickOn("Events_EventListing_ConfAndTradShow");
	dynamicWait.get().waittillpageloads();
	userActions.get().clickOn("Events_FutureEvent");
	dynamicWait.get().waittillpageloads();
	verify.get().isElementDisplayed("Events_AddToCalendar");
}
@Test(description="",groups="")
public void testHistoryPageLinks()
{
	getDriver().get(appConfig.getAppUrl());
	businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "AboutAvaya_History", "History_Title");
	businessFunction.get().checkCssColorOnHover("History_Link");
}

/** 
Author Name                       : Aishwarya 
Date of Preparation               : 30-01-2015
Date of Modified                  : -- 
Methods Called                    : checkCssBackGroundColorOnHover(String), isElementNotPresent(String)
 
Purpose of Method                 : 
Dependencies                  : --
Reviewed By                       : --
**/

@Test(description="Verify the presence of Inactive link and compare it between both the environment Stage Managament and Stage Delivery.", groups="ActiveInactive Pages")

public void testSolutionsLinkColor()
{
//Launching avaya application
getDriver().get(appConfig.getStagemanagementUrl());
//Checking the background color for the link named "Contact Center Efficiency"
businessFunction.get().checkCssBackGroundColorOnHover("ContactCenterEfficiency");
getDriver().get(appConfig.getAppUrl());
//Verifying the absence of the link named Contact Center Efficiency
verify.get().isElementNotPresent("ContactCenterEfficiency");
}



/** 
Author Name                       : Aishwarya 
Date of Preparation               : 30-01-2015
Date of Modified                  : -- 
Methods Called                    : checkCssBackGroundColorOnHover(String), isElementNotPresent(String)
 
Purpose of Method                 : 
Dependencies                  : --
Reviewed By                       : --
**/

@Test(description="Verify the presence of Inactive link and compare it between both the environment Stage Managament and Stage Delivery.", groups="ActiveInactive Pages")

public void testProductsLinkColor()
{
//Launching avaya application
getDriver().get(appConfig.getStagemanagementUrl());
//Checking the background color for the link 
businessFunction.get().checkCssBackGroundColorOnHover("AvayaFlareExperience_MegaMenu");
getDriver().get(appConfig.getAppUrl());
//Verifying the absence of the link
verify.get().isElementNotPresent("AvayaFlareExperience_MegaMenu");
}


/** 
Author Name                       : Aishwarya 
Date of Preparation               : 30-01-2015
Date of Modified                  : -- 
Methods Called                    : checkCssBackGroundColorOnHover(String), isElementNotPresent(String)
 
Purpose of Method                 : 
Dependencies                  : --
Reviewed By                       : --
**/

@Test(description="Verify the presence of Inactive link and compare it between both the environment Stage Managament and Stage Delivery.", groups="ActiveInactive Pages")

public void testServicesLinkColor()
{
//Launching avaya application
getDriver().get(appConfig.getStagemanagementUrl());
//Checking the background color for the link 
businessFunction.get().checkCssBackGroundColorOnHover("NetworkReadinessAssessment");
getDriver().get(appConfig.getAppUrl());
//Verifying the absence of the link
verify.get().isElementNotPresent("NetworkReadinessAssessment");
}


/** 
Author Name                       : Aishwarya 
Date of Preparation               : 30-01-2015
Date of Modified                  : -- 
Methods Called                    : checkCssBackGroundColorOnHover(String), clickOnSubMenuItem(String,String,String)
 
Purpose of Method                 : 
Dependencies                  : --
Reviewed By                       : --
**/

@Test(description="Verify the message displayed for an inactive article in stage management", groups="ActiveInactive Pages")

public void testInactiveLinkMessage()
{
//Launching avaya application
getDriver().get(appConfig.getStagemanagementUrl());
//Checking the background color for the link 
businessFunction.get().checkCssBackGroundColorOnHover("ContactCenterEfficiency");
//Click on submenu item
System.out.println("one");
dynamicWait.get().waittillpageloads();
businessFunction.get().clickOnSubMenuItem("Solutions", "ContactCenterEfficiency", "ContactCenterEfficiencyTitle");
System.out.println("test");
//verify the back ground color
businessFunction.get().checkCssBackGroundColorOnHover("InactiveMessagePath");
verify.get().verifyElementContainsText("InactiveMessagePath","InactiveMessage");
}

/** 
Author Name                       : Aishwarya 
Date of Preparation               : 30-01-2015
Date of Modified                  : -- 
Methods Called                    : checkCssBackGroundColorOnHover(String), clickOnSubMenuItem(String,String,String)
 
Purpose of Method                 : 
Dependencies                  : --
Reviewed By                       : --
**/

@Test(description="Verify the message displayed for an inactive article in stage management", groups="ActiveInactive Pages")

public void testProductsInactiveLinkMessage()
{
//Launching avaya application
getDriver().get(appConfig.getStagemanagementUrl());
dynamicWait.get().waittillpageloads();
//Checking the background color for the link 
businessFunction.get().checkCssBackGroundColorOnHover("AvayaFlareExperience_MegaMenu");
//Click on submenu item
businessFunction.get().clickOnSubMenuItem("Products", "AvayaFlareExperience_MegaMenu", "AvayaFlareExperienceTitle");
//verify the back ground color
businessFunction.get().checkCssBackGroundColorOnHover("InactiveMessagePath");
verify.get().verifyElementContainsText("InactiveMessagePath","InactiveMessage");
}

/** 
Author Name                       : Aishwarya 
Date of Preparation               : 30-01-2015
Date of Modified                  : -- 
Methods Called                    : checkCssBackGroundColorOnHover(String), clickOnSubMenuItem(String,String,String)
 
Purpose of Method                 : 
Dependencies                  : --
Reviewed By                       : --
**/

@Test(description="Verify the message displayed for an inactive article in stage management", groups="ActiveInactive Pages")

public void testServicesInactiveLinkMessage()
{
//Launching avaya application
getDriver().get(appConfig.getStagemanagementUrl());
dynamicWait.get().waittillpageloads();
//Checking the background color for the link 
businessFunction.get().checkCssBackGroundColorOnHover("NetworkReadinessAssessment");
//Click on submenu item
businessFunction.get().clickOnSubMenuItem("Services", "NetworkReadinessAssessment", "NetworkReadinessAssessmentTitle");
//verify the back ground color
businessFunction.get().checkCssBackGroundColorOnHover("InactiveMessagePath");
verify.get().verifyElementContainsText("InactiveMessagePath","InactiveMessage");
}


/** 
Author Name                       : Aishwarya 
Date of Preparation               : 30-01-2015
Date of Modified                  : -- 
Methods Called                    : checkCssBackGroundColorOnHover(String), clickOnSubMenuItem(String,String,String), isElementNotPresent(String), isElementPresent(String)
 
Purpose of Method                 : 
Dependencies                  : --
Reviewed By                       : --
**/

@Test(description="Verify the message displayed for an inactive article in stage management", groups="ActiveInactive Pages")

public void testLinkInRelatedProductsPod()
{
//Launching avaya application
getDriver().get(appConfig.getStagemanagementUrl());
//Click on sub menu item
businessFunction.get().clickOnSubMenuItem("Products", "AvayaAuraConferencing", "Product_AvayaAuraConferencing_Title");
verify.get().isElementPresent("AvayaFlareExperience");
//Checking the background color for the link 
businessFunction.get().checkCssBackGroundColorOnHover("Pod_AvayaFlareExperience");
getDriver().get(appConfig.getAppUrl());
businessFunction.get().clickOnSubMenuItem("Products", "AvayaAuraConferencing", "Product_AvayaAuraConferencing_Title");
verify.get().isElementNotPresent("AvayaFlareExperience");
}


/** 
Author Name                       : Aishwarya 
Date of Preparation               : 30-01-2015
Date of Modified                  : -- 
Methods Called                    : checkCssBackGroundColorOnHover(String), clickOnSubMenuItem(String,String,String), isElementNotPresent(String), isElementPresent(String)
 
Purpose of Method                 : 
Dependencies                  : --
Reviewed By                       : --
**/

@Test(description="Verify the link present in Related Products pod", groups="ActiveInactive Pages")

public void testLinkInRelatedSolutionsPod()
{
//Launching avaya application
getDriver().get(appConfig.getStagemanagementUrl());
//Click on sub menu item
businessFunction.get().clickOnSubMenuItem("Solutions", "CommunicationsOptimization", "CommunicationsOptimizationTitle");
verify.get().isElementPresent("AvayaFlareExperience");
//Checking the background color for the link 
businessFunction.get().checkCssBackGroundColorOnHover("RelatedProductsPod_Solutions_InactiveBackground");
getDriver().get(appConfig.getAppUrl());
businessFunction.get().clickOnSubMenuItem("Solutions", "CommunicationsOptimization", "CommunicationsOptimizationTitle");
verify.get().isElementNotPresent("AvayaFlareExperience");
}

/** 
Author Name                       : Aishwarya 
Date of Preparation               : 30-01-2015
Date of Modified                  : -- 
Methods Called                    : checkCssColorOnHover(String), verifyElementContainsText(String)
 
Purpose of Method                 : 
Dependencies                  : --
Reviewed By                       : --
**/

@Test(description="Verify the link in brand campaign page in Associated Products pod ", groups="Brand Campaign")

public void testLinkInBrandCampaignPage()
{
getDriver().get(appConfig.getImagineStageManagementUrl());
businessFunction.get().clickAndVerifyNavigation("Carlo'sBakery", "Carlo'sBakeryTitle");
verify.get().isElementPresent("InactiveLinkinCarlosBakeryPage");
businessFunction.get().checkCssColorOnHover("InactiveLinkinCarlosBakeryPage_AssociatedProductspod_BackGroundColor");
getDriver().get(appConfig.getImagineUrl());
businessFunction.get().clickAndVerifyNavigation("Carlo'sBakery", "Carlo'sBakeryTitle");
verify.get().isElementNotPresent("InactiveLinkinCarlosBakeryPage");
}

//March 9th 2015
/**
Author Name                          : Aishwarya
Date of Preparation                  : 3/03/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the content in the page source for service page
Reviewed By                          : --
**/ 


@Test(description="Verify the description in the Page Source", groups="Services")
public void testSourceContentForService()
{
getDriver().get(appConfig.getAppUrl());
dynamicWait.get().waittillpageloads();
businessFunction.get().clickOnSubMenuItem("Services", "ContactCenterOptimization", "ContactCenterOptimization_Title");
getDriver().getPageSource().contains("Avaya helps you streamline contact center operations & increase agent productivity, which can transform how customers experience support & purchasing. Learn more.");
userActions.get().clickOn("DocumentandVideos_tab");
getDriver().getPageSource().contains("Docs and Video Descriptions");
userActions.get().clickOn("CaseStudies_Tab");
 
getDriver().getPageSource().contains("Case Studies-Docs and Video");
userActions.get().clickOn("ServiceDetails");
getDriver().getPageSource().contains("Service Details Description");
}
/**
Author Name                          : Aishwarya
Date of Preparation                  : 3/03/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the description in page source for Products page
Reviewed By                          : --
**/ 

@Test(description="Verify the description in the Page Source", groups="Products")
public void testSourceContentForProducts()
{
getDriver().get(appConfig.getAppUrl());
dynamicWait.get().waittillpageloads();
businessFunction.get().clickOnSubMenuItem("Products", "Products_AvayaAuraPlatform", "Products_AvayaAuraPlatform_Title");
getDriver().getPageSource().contains("The Avaya Aura Platform supports a suite of products that work together to deliver advanced unified communications & contact center solutions. Learn more here. overview tested");
userActions.get().clickOn("DocumentandVideos_tab");
getDriver().getPageSource().contains("Docs and Videos Description-Avaya");
userActions.get().clickOn("CaseStudies_Tab");
getDriver().getPageSource().contains("Case Studies Description-Avaya");
userActions.get().clickOn("TechSpecs");
    getDriver().getPageSource().contains("Tech Description-Avaya");
}
/**
Author Name                          : Aishwarya
Date of Preparation                  : 3/03/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the description in page source for solution page
Reviewed By                          : --
**/ 

@Test(description="Verify the description in the Page Source", groups="Solutions")
public void testSourceContentForSolution()
{
getDriver().get(appConfig.getAppUrl());
dynamicWait.get().waittillpageloads();
//Hover on Solutions and click on Customer Experience link
businessFunction.get().clickOnSubMenuItem("Solutions", "CustomerExperience", "CustomerExperienceTitle");
getDriver().getPageSource().contains("Avaya Customer Experience - Better monitor and measure customer experience data & feedback. Improve customer acquisition & retention. Learn much more here.");
userActions.get().clickOn("DocumentandVideos_tab");
getDriver().getPageSource().contains("Docs and Videos Description");
userActions.get().clickOn("CaseStudies_Tab");
getDriver().getPageSource().contains("Case Studies-Description");
userActions.get().clickOn("Capabilities_Core_Components");
    getDriver().getPageSource().contains("Core Components-Description");
}

/**
Author Name                          : Aishwarya
Date of Preparation                  : 3/03/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the text named "Mutiple Location" in Events Landing page
Reviewed By                          : --
**/ 

@Test(description="Verify the presence of text Multiple Locations", groups="Events")
public void testTextMultipleLocations(){
getDriver().get(appConfig.getAppUrl());
dynamicWait.get().waittillpageloads();
//Hover on About tab and click on Events link
businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "AboutAvaya_Events", "Events_Title");
//Verify the Presence of Multiple Locations
verify.get().isTextPresent("MultipleLocations");
 
 
}

/**
Author Name                          : Aishwarya
Date of Preparation                  : 3/03/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the text named "Mutiple Location" in Events Listing page
Reviewed By                          : --
**/ 

@Test(description="Verify the presence of text Multiple Locations in listing page", groups="Events")
public void testTextMultipleLocationsInListingPage(){
getDriver().get(appConfig.getAppUrl());
dynamicWait.get().waittillpageloads();
//Hover on About tab and click on Events link
businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "AboutAvaya_Events", "Events_Title");
businessFunction.get().clickAndVerifyNavigation("SEEALL","EventCalendarPageTittle");
//Verify the Presence of Multiple Locations
verify.get().isTextPresent("MultipleLocationsInListingPage");

}

/**
Author Name                          : Aishwarya
Date of Preparation                  : 2/03/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the images when it is under Customer Engagement Segment
Dependencies                       : 
Reviewed By                          : --
**/ 

@Test(description="Verify the images displayed in the Capabilites pod when user is segmented under Networking",groups="Segmentation")
public void testImageCarouselForCustomerEngagementSegment()
{
getDriver().get(appConfig.getAppUrl());
dynamicWait.get().waittillpageloads();
//Click on Communication Optimization link under Solutions
businessFunction.get().clickOnSubMenuItem("Solutions", "CommunicationsOptimization", "CommunicationsOptimizationTitle");
getDriver().navigate().refresh();
dynamicWait.get().waittillpageloads();
businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "CustomerEngagementCTA_1", "HomePage_CustEng_Title");
//Click on the home page logo
userActions.get().clickOn("HomePage_Logo");
dynamicWait.get().waittillpageloads();
//Verify the first image in the carousel section
businessFunction.get().verifyHomePageCarouselHPSegmentation("HomePageCarouselActiveImage","Avaya Scopia®");
//Verify the promo pods
businessFunction.get().imageValidation("promopod1");
businessFunction.get().imageValidation("promopod2");
businessFunction.get().imageValidation("promopod3");
    //Navigate to Products page
businessFunction.get().clickAndVerifyNavigation("Products", "Products_label");
//businessFunction.get().imageValidation("casestudy1");
businessFunction.get().imageValidation("Promotional_image11");
//businessFunction.get().imageValidation("Promotional_image11");
//Hover on products tab and verify the spotlight image
userActions.get().hoverOn("Products");
businessFunction.get().imageValidation("Products_SpotlightImage");
 
 
}
/**
Author Name                          : Aishwarya
Date of Preparation                  : 2/03/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the images when it is under Team Engagement Segment
Reviewed By                          : --
**/ 


@Test(description="Verify the images displayed in the Capabilites pod when user is segmented under Networking",groups="Segmentation")
public void testImageCarouselForTeamEngagementSegment()
{
getDriver().get(appConfig.getAppUrl());
dynamicWait.get().waittillpageloads();
businessFunction.get().clickOnSubMenuItem("Solutions", "WorkerandTeamProductivity", "WorkerandTeamProductivity_Title");
//Hover on Case Studies tab in the mega menu and click on Team Engagement Link

//businessFunction.get().clickOnSubMenuItem("CaseStudies_MegaMenu", "TeamEngagementCTA", "CaseStudies_Title");
//Hover on About tab in the mega menu and click on Customer Engagement link
//businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "TeamEngagementCTA_1", "HomePage_TeamEng_Title");
getDriver().navigate().refresh();
getDriver().navigate().refresh();
dynamicWait.get().waittillpageloads();
userActions.get().clickOn("HomePage_Logo");
dynamicWait.get().waittillpageloads();
businessFunction.get().verifyHomePageCarouselHPSegmentation("HomePageCarouselActiveImage","Avaya IP Office");
businessFunction.get().imageValidation("TE_Promopod1");
businessFunction.get().imageValidation("TE_Promopod2");
businessFunction.get().imageValidation("TE_Promopod3");
businessFunction.get().clickAndVerifyNavigation("Products", "Products_label");
businessFunction.get().imageValidation("TE_Products_Marquee");
 
userActions.get().hoverOn("Products");
businessFunction.get().imageValidation("TE_Spotlight_Image");
 
 
}
/**
Author Name                          : Aishwarya
Date of Preparation                  : 2/03/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the images when it is under Fabric Networking Segment
Reviewed By                          : --
**/ 


@Test(description="Verify the images displayed in the Capabilites pod when user is segmented under Networking",groups="Segmentation")
public void testImageCarouselForFabricNetworkingSegment()
{
getDriver().get(appConfig.getAppUrl());
dynamicWait.get().waittillpageloads();

//Hover on Solutions tab and click on Unified Access
businessFunction.get().clickOnSubMenuItem("Solutions", "Unified_Access", "Unified_Access_Header");
//businessFunction.get().clickOnSubMenuItem("CaseStudies_MegaMenu", "FabricNetworkingCTA", "CaseStudies_Title");
businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "FabricNetworkingCTA_1", "HomePage_NetworkingLinkTitle");
getDriver().navigate().refresh();
dynamicWait.get().waittillpageloads();
//Click on Avaya Logo
userActions.get().clickOn("HomePage_Logo");
dynamicWait.get().waittillpageloads();
//businessFunction.get().verifyHomePageCarouselHPSegmentation("HomePageCarouselActiveImage","Avaya Fabric Connect");
//Verify the images in Promo pod
businessFunction.get().imageValidation("FN_Promo1");
businessFunction.get().imageValidation("FN_Promo2");
businessFunction.get().imageValidation("FN_Promo3");
businessFunction.get().clickAndVerifyNavigation("Products", "Products_label");
businessFunction.get().imageValidation("FN_Products_Marquee");
 
userActions.get().hoverOn("Products");
businessFunction.get().imageValidation("TE_Spotlight_Image");
 
 
}
/**
Author Name                          : Aishwarya
Date of Preparation                  : 2/03/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the images when it is under Midmarket Segment
Reviewed By                          : --
**/ 


@Test(description="Verify the images displayed in the Capabilites pod when user is segmented under Networking",groups="Segmentation")
public void testImageCarouselForMidmarketSegment()
{
getDriver().get(appConfig.getAppUrl());
dynamicWait.get().waittillpageloads();
//Hover on Solutions tab and click on Midmarket
businessFunction.get().clickOnSubMenuItem("Solutions", "Midmarket", "Explore_Midmarket_Business_Title");
businessFunction.get().clickOnSubMenuItem("Products", "OutboundContactExpress", "OutboundContactExpress_Title");
businessFunction.get().clickOnSubMenuItem("Solutions", "ContactCenterforMidmarket", "Explore_Midmarket_Business_Title");
//Click on Avaya Logo
userActions.get().clickOn("HomePage_Logo");
dynamicWait.get().waittillpageloads();
businessFunction.get().verifyHomePageCarouselHPSegmentation("HomePageCarouselActiveImage","Avaya IP Office");
businessFunction.get().imageValidation("MidmarketPromo1");
businessFunction.get().imageValidation("MidmarketPromo2");
businessFunction.get().imageValidation("MidmarketPromo3");
businessFunction.get().clickAndVerifyNavigation("Products", "Products_label");
businessFunction.get().imageValidation("Midmarket_Products_Marquee");
 
userActions.get().hoverOn("Products");
businessFunction.get().imageValidation("Midmarket_Products_Spotlight");
}

/**
Author Name                          : Aishwarya
Date of Preparation                  : 3/03/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the text named "Mutiple Location" in Events Listing page
Reviewed By                          : --
**/ 

@Test(description="Verify the functonality of Expand and Collapse links", groups="Brand Campaign")
public void testBrandCampaign(){
//Launch the imagine url
getDriver().get(appConfig.getImagineUrl());
//Verify whether four pods are present above the Expand link
    businessFunction.get().verifyImaginePods("PodsBeforeExpand");
    //Click on Expand link
userActions.get().clickOn("Expand");
dynamicWait.get().waittillpageloads();
//Verify the pods present
verify.get().isElementDisplayed("PodsAfterExpand");
//Click on Collapse link
userActions.get().clickOn("collapse");
//Verify whether four pods are present 
businessFunction.get().verifyImaginePods("PodsBeforeExpand");


}

/**
Author Name                          : Aishwarya
Date of Preparation                  : 13/03/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the text named "Mutiple Location" in Events Listing page
Reviewed By                          : --
**/ 

@Test(description="Verify the pod present in the brand campaign detail page", groups="Brand Campaign")
public void testBrandCampaignPod(){
//Launch the brand campaign url
    getDriver().get(appConfig.getImagineUrl());
//Click on View Story button
userActions.get().clickOn("viewbutton");
verify.get().isElementDisplayed("BrandCampaignPod");
}

/**
Author Name                          : Aishwarya
Date of Preparation                  : 18/03/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the content in case studies page
Reviewed By                          : --
**/ 
@Test(description="Verify the Case Studies Page",groups="Case Studies")
public void testCaseStudiesLandingPage()
{
       //Launching the Avaya website
       getDriver().get(appConfig.getAppUrl());
       dynamicWait.get().waittillpageloads();
       //Click on Case Studies link which is present in the mega menu
       businessFunction.get().clickAndVerifyNavigation("CaseStudies_MegaMenu","Page_Title");    
       dynamicWait.get().waittillpageloads();
       businessFunction.get().deFocus();
       //verify the butler bar
       verify.get().isElementDisplayed("ButlerBar");
       //verify the mega menu
       verify.get().isElementDisplayed("Megamenu");
       //verify the bread crumb
       businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "CaseStudiesBreadCrumb", "Tag_Anchors");
       //verify the chat icon
       verify.get().isElementDisplayed("ChatPOPUP");
       
       
}

/**
Author Name                       : Aishwarya
Date of Preparation               : 18/03/2014
Date of Modified                  : 17-9-2014
Methods Called                    : verifyImageCarouselRotations(String childCarouselImages),imageValidation(String imageControlName)
                                    clickAndVerifyNavigation(String navigatetopage,String pageTitle)
Purpose of Method                 : Verify the functionality of Image carousel
Dependencies                      : Jar files
Reviewed By                       : --
**/

@Test(description="Verify the functionality of Image carousel",groups="Case Studies")
public void testCaseStudiesLandingPageImageCarousel()
{
       getDriver().get(appConfig.getAppUrl());
       dynamicWait.get().waittillpageloads();
       //Click on Case Studies link which is present in the mega menu
       businessFunction.get().clickAndVerifyNavigation("CaseStudies_MegaMenu","Page_Title");    
       dynamicWait.get().waittillpageloads();
       //To verify if Images in the carousel auto rotate twice for the interval of 7 seconds and stop at the first image
       verify.get().verifyImageCarousel("Carousel_Blocks");
       //Click on the second indicator button
       userActions.get().clickOn("Products_2ndIndicatorButton");
       //To verify if second image in the carousel is displayed
       businessFunction.get().imageValidation("Products_2ndImage");
}




/** 
Author Name                       : Aishwarya 
Date of Preparation               : 18-3-2015
Date of Modified                  : -- 
Methods Called                    : clickAndVerifyNavigation(String navigatetopage,String pageTitle)                                                              
Purpose of Method                 : Verify whether system is navigated to the respective listings page when See All link under Featured Conferences and Trade Shows section is clicked.
Dependencies                    : --
Reviewed By                       : --
**/

@Test(description="Verify whether system is navigated to the respective listings page when See All link under Featured CaseStudies is clicked.", groups="Case Studies")
public void testCaseStudiesLandingPageFeaturedCaseStudiesSeeAll()
{
       //To launch the Avaya application
       getDriver().get(appConfig.getAppUrl());
       dynamicWait.get().waittillpageloads();
       //Click on Case Studies tab of megamenu
       businessFunction.get().clickAndVerifyNavigation("CaseStudies_MegaMenu","Page_Title");    
       businessFunction.get().deFocus();
       businessFunction.get().clickAndVerifyNavigation("SeeAllCaseStudies_Link","FindaCaseStudy");
       
       
}

/** 
Author Name                       : Aishwarya 
Date of Preparation               : 18-3-2015
Date of Modified                  : -- 
Methods Called                    : clickAndVerifyNavigation(String navigatetopage,String pageTitle)                                                              
Purpose of Method                 : Verify the content in the case study pod in the case study landing page and check whether there are only 6 pods or not
Dependencies                    : --
Reviewed By                       : --
**/

@Test(description="Verify the content in the case study pod in the case study landing page", groups="Case Studies")
public void testCaseStudies(){
       //To launch the Avaya application
              getDriver().get(appConfig.getAppUrl());
              dynamicWait.get().waittillpageloads();
              //Click on Case Studies tab of megamenu
              businessFunction.get().clickAndVerifyNavigation("CaseStudies_MegaMenu","Page_Title");       
              businessFunction.get().deFocus();
              //Verify theere are exactly 6 pods before See All Case Studies link
           businessFunction.get().verifyFeaturedCaseStudyPods("FeaturedCaseStudiesPod_Count","CaseStudiesPodImages");


}
/** 
Author Name                       : Aishwarya 
Date of Preparation               : 18-3-2015
Date of Modified                  : -- 
Methods Called                    : clickAndVerifyNavigation(String navigatetopage,String pageTitle)                                                              
Purpose of Method                 : Verify the content in the Featured Customer pod which is present in the right side of case studies page
Dependencies                    : --
Reviewed By                       : --
**/

@Test(description="Verify the content in the Featured Customer pod which is present in the right side of case studies page", groups="Case Studies")
public void testFeauturedCustomersPod(){
           //To launch the Avaya application
              getDriver().get(appConfig.getAppUrl());
              dynamicWait.get().waittillpageloads();
              //Click on Case Studies tab of megamenu
              businessFunction.get().clickAndVerifyNavigation("CaseStudies_MegaMenu","Page_Title");       
              businessFunction.get().deFocus();
           verify.get().isElementPresent("FeaturedCustomersHeading");
           businessFunction.get().verifyFeaturedCustomerPod("CaseStudy_Pod","podImg");


}

/** 
Author Name                       : Aishwarya
Date of Preparation               : 19/03/2015
Date of Modified                  : --
Methods Called                    : clickAndVerifyNavigation(String navigatetopage,String pageTitle),productsPagination(String controlName,String relativeControlName,String childControlName)
Purpose of Method                 : Verify the pagination in the Find a Case Study page
Dependencies                      : 
Reviewed By                       : --
**/

@Test(description="Verify the pagination in the Find a Case Study page",groups="Case Studies")
public void testCaseStudiesPagination() 
{
       //To launch the Avaya application
       getDriver().get(appConfig.getAppUrl());
       dynamicWait.get().waittillpageloads();
       //Click on Case Studies tab of megamenu
       businessFunction.get().clickAndVerifyNavigation("CaseStudies_MegaMenu","Page_Title");    
       businessFunction.get().deFocus();
       businessFunction.get().clickAndVerifyNavigation("SeeAllCaseStudies_Link","FindaCaseStudy");
       //Click on the 2 link in the Find a Case Study page
       userActions.get().clickOn("Products_Pagination_2ndlink");
       dynamicWait.get().waittillpageloads();
       businessFunction.get().deFocus();
       //To click on the Previous link in the Find a Case Study  page and to verify if corresponding case studies are displayed in both the pages.
       businessFunction.get().paginationValidation("casestudy_1stpage","casestudy_2ndpage","Products_Pagination_Prev");
       //Click on "Next"  Link in Find a Case Study page
       userActions.get().clickOn("Products_Pagination_Next");        
}

/** 
Author Name                       : Aishwarya
Date of Preparation               : 19/03/2015
Date of Modified                  : --
Methods Called                    : searchInvalidResults(String relativeControlName, String controlName),isTextPresent(String controlName) 
Purpose of Method                 : Verify if the user is able to search for invalid details
Dependencies                    :
Reviewed By                       : --
**/
@Test(description="Verify if the user is able to search for invalid details",groups="Case Studies")
public void testCaseStudiesPageInvalidinput() 
{
       //To launch the Avaya application
    getDriver().get(appConfig.getAppUrl());
    dynamicWait.get().waittillpageloads();
       //Click on Case Studies tab of megamenu
       businessFunction.get().clickAndVerifyNavigation("CaseStudies_MegaMenu","Page_Title");    
       businessFunction.get().deFocus();
       businessFunction.get().clickAndVerifyNavigation("SeeAllCaseStudies_Link","FindaCaseStudy");
       //To enter the invalid data in the search box in the Products landing page
       userActions.get().enterText("Products_SearchBox","!@#");
       //To click on the search button
       userActions.get().clickOn("case_SearchButton");
       dynamicWait.get().waittillpageloads();
       //To check whether message is displayed under "Your Results" Section
       businessFunction.get().pageAllignment("Products_YourResults","CaseStudies_Invalid_Result","equal");
       //To check whether proper message is displayed
       verify.get().isTextPresent("InvalidMessage");
       
}      


/**
Author Name                       : Aishwarya
Date of Preparation               : 23/03/2015
Date of Modified                  : --
Methods Called                    : check_ChildElements(String controlName,String childElement),relativeAllignment(String relativeControlName,String controlName) 
Purpose of Method                 :Verify the filter functionality in Find a Case Study page
Dependencies                      : Jar files
Reviewed By                       : --
**/
@Test(description="Verify the filter functionality in Find a Case Study page",groups="Case Studies")
public void testCaseStudiesPageFilterSearch() 
{
       //To launch the Avaya application
              getDriver().get(appConfig.getAppUrl());
              dynamicWait.get().waittillpageloads();
              //Click on Case Studies tab of megamenu
              businessFunction.get().clickAndVerifyNavigation("CaseStudies_MegaMenu","Page_Title");       
              businessFunction.get().deFocus();
              businessFunction.get().clickAndVerifyNavigation("SeeAllCaseStudies_Link","FindaCaseStudy");
       //Click on the check box beside Security Option
       userActions.get().clickOn("CustomerEngagement_Filter");
       //To  check whether Customer Engagement option is displayed beside Your Selections section
       businessFunction.get().pageAllignment("YourSelection","CaseStudies_CustomerEngagement","right");
       //To check whether user is able to view casestudies under Sort Results Section
       businessFunction.get().pageAllignment("CaseStudies_SortResults_Section","CaseStudies_SecurityResults","equal");
       //verify the count
       businessFunction.get().checkSearchCount("CaseStudies_SearchResult","CaseStudies_SearchCount");
}




@Test(description = "Verify the content in Infographic detail page", groups ="Case Studies")
public void testInfographicDetailContent(){
       //Launching the Avaya website
       getDriver().get(appConfig.getAppUrl());
       //Hover on Product and Click on Avaya Aura Platform
       dynamicWait.get().waittillpageloads();
       businessFunction.get().deFocus();
       //businessFunction.get().clickOnSubMenuItem("CaseStudies_MegaMenu", "CustomerEngagementCTA", "CaseStudies_Title");
       businessFunction.get().clickOnSubMenuItem("CaseStudies_MegaMenu", "Infographic_Detail", "Infographic_Detail_Title");
       businessFunction.get().deFocus();
       dynamicWait.get().waittillpageloads();
       businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "InfographicDetail_BreadCrumb", "Tag_Anchors");
       verify.get().isElementPresent("Infographic_Detail_Page_Image");
       verify.get().isElementPresent("Infographic_Detail_Page_FullCaseStudy");
       verify.get().isElementPresent("Infographic_Detail_Page_FullCaseStudy_Pod");
}

/**
Author Name                       : Aishwarya
Date of Preparation               : 24/03/2015
Date of Modified                  : --
Methods Called                    : 
Purpose of Method                 :Verify the functionality of See All link in Testimonial Page
Dependencies                      : Jar files
Reviewed By                       : --
**/
@Test(description="Verify the functionality of See All link in Testimonial Page", groups="Case Studies")
public void testTestimonialsPage(){
       //To launch the Avaya application
       getDriver().get(appConfig.getAppUrl());
       dynamicWait.get().waittillpageloads();
       //Click on Case Studies link
       businessFunction.get().clickAndVerifyNavigation("CaseStudies_MegaMenu","Page_Title");
       //Click on See All Customer Testimonials link
       businessFunction.get().clickAndVerifyNavigation("SeeAllCustomerTestimonials_Link", "Testimonial_Title");
       //Verify the presence of 4 pods before Clicking on See All link
    verify.get().isElementPresent("Testimonial_Div");
    //Verify the presence of See All link
    verify.get().isElementPresent("SeeAll_link");
    //Click on See All link
    userActions.get().clickOn("SeeAll_link");
    //Verify the presence of pods after clicking on See All link
    verify.get().isElementPresent("PodsAfter_Clicking_SeeAll");
}

/**
Author Name                       : Aishwarya
Date of Preparation               : 24/03/2015
Date of Modified                  : --
Methods Called                    : 
Purpose of Method                 :Verify the presence of Testimonial Widget in case studies landing page
Dependencies                      : Jar files
Reviewed By                       : --
**/
@Test(description="Verify the presence of Testimonial Widget in case studies landing page", groups="Case Studies")
public void testWhatOurCustomersAreSayingPod(){
       //To launch the Avaya application
       getDriver().get(appConfig.getAppUrl());
       dynamicWait.get().waittillpageloads();
       //Click on Case Studies link
       businessFunction.get().clickAndVerifyNavigation("CaseStudies_MegaMenu","Page_Title");
       //verify the presence of testimonial widget named what Our Customers Are Saying
       verify.get().isElementPresent("WhatOurCustomersAreSaying_Pod");
       //Verify the link named See All Customer Testimonials link in testimonial widget
       verify.get().isElementPresent("SeeAllCustomerTestimonials_Link");
       
       
}


/**
Author Name                       : Aishwarya
Date of Preparation               : 24/03/2015
Date of Modified                  : --
Methods Called                    : 
Purpose of Method                 :Verify the presence of Testimonial Widget in case studies landing page
Dependencies                      : Jar files
Reviewed By                       : --
**/
@Test(description="Verify the presence of search pod landing page", groups="Case Studies")
public void testSearchCaseStudiesPod(){
       //To launch the Avaya application
       getDriver().get(appConfig.getAppUrl());
       dynamicWait.get().waittillpageloads();
       //Click on Case Studies link
       businessFunction.get().clickAndVerifyNavigation("CaseStudies_MegaMenu","Page_Title");
       //verify the presence of search-case studies pod
       verify.get().isElementPresent("SearchCaseStudiesPod");
       
       
       
}

/**
Author Name                       : Aishwarya
Date of Preparation               : 24/03/2015
Date of Modified                  : --
Methods Called                    : 
Purpose of Method                 :Verify the presence of social Media icons
Dependencies                      : Jar files
Reviewed By                       : --
**/

@Test(description="Verify the presence of social Media icons", groups="Case Studies")
public void testCaseStudiesSocialMediaIcons(){
       //To launch the Avaya application
       getDriver().get(appConfig.getAppUrl());
       dynamicWait.get().waittillpageloads();
       //Click on Case Studies link
       businessFunction.get().clickAndVerifyNavigation("CaseStudies_MegaMenu","Page_Title");
    //Check if Social Icons are present
       verify.get().isElementDisplayed("SocialIcons");
       //Check if the Twitter Widget is present
       verify.get().isElementDisplayed("SocialIcons_Twitter");
       //Check if the facebook Widget is present
       verify.get().isElementDisplayed("SocialIcons_Facebook");
       //Check if the Linked In widget is present
       verify.get().isElementDisplayed("SocialIcons_LinkedIn");
       verify.get().isElementDisplayed("SocialIcons_GooglePlus");
}


/** 
Author Name                       : Aishwarya 
Date of Preparation               : 24-03-2015
Date of Modified                  : -- 
Methods Called                    : clickOnSubMenuItem(String,String,String),searchValidResults(String,String)                                                 
Purpose of Method                 : 
Dependencies                    : --
Reviewed By                       : --
**/
@Test(description="Verify the functionality of search",groups="Case Studies")
public void testCaseStudiesSearchWithValidInputs()
{
       getDriver().get(appConfig.getAppUrl());
       businessFunction.get().clickAndVerifyNavigation("CaseStudies_MegaMenu","Page_Title");
       dynamicWait.get().waittillpageloads();
       //Enter text in the search text box
       userActions.get().enterText("Events_SearchBox", "Landmark BanK article");
       //Click on search button
       userActions.get().clickOn("CaseStudy_Search_Button");
       //verify whether the result is displayed or not
       businessFunction.get().searchValidResults("casestudy_1stpage", "Landmark BanK article");
}

/**
Author Name                       : Aishwarya
Date of Preparation               : 24/03/2015
Date of Modified                  : --
Methods Called                    : 
Purpose of Method                 :Verify the presence of Testimonial Widget in case studies landing page
Dependencies                      : Jar files
Reviewed By                       : --
**/
@Test(description="Verify the presence of Testimonial Widget in case studies landing page", groups="Case Studies")
public void testCaseStudyWidgets(){
       //To launch the Avaya application
       getDriver().get(appConfig.getAppUrl());
       dynamicWait.get().waittillpageloads();
       //Click on Case Studies link
       businessFunction.get().clickAndVerifyNavigation("CaseStudies_MegaMenu","Page_Title");
       //verify the presence of search-case studies pod
       verify.get().isElementPresent("CaseStudy_InfographicPod_Heading");
       verify.get().isElementPresent("CaseStudy_InfographicPod");
       verify.get().isElementPresent("CaseStudy_SeeAllInfographic_Link");
       
       
       
       
}

/**
Author Name                       : Aishwarya
Date of Preparation               : 24/03/2015
Date of Modified                  : --
Methods Called                    : 
Purpose of Method                 :verify the presence of promotional tout pod
Dependencies                      : Jar files
Reviewed By                       : --
**/
@Test(description="verify the presence of promotional tout pod", groups="Case Studies")
public void testCaseStudyPromoTout(){
       //To launch the Avaya application
       getDriver().get(appConfig.getAppUrl());
       dynamicWait.get().waittillpageloads();
       //Click on Case Studies link
       businessFunction.get().clickAndVerifyNavigation("CaseStudies_MegaMenu","Page_Title");
       //verify the presence of promotional tout pod
       verify.get().isElementPresent("CaseStudy_PromoTout");
       
       
       
}

/**
Author Name                       : Aishwarya
Date of Preparation               : 25/03/2015
Date of Modified                  : --
Methods Called                    : 
Purpose of Method                 :Verify the content in Infographic Gallary Page
Dependencies                      : Jar files
Reviewed By                       : --
**/
@Test(description="Verify the content in Infographic Gallary Page", groups="Case Studies")
public void testInfographicsPage(){
       //To launch the Avaya application
       getDriver().get(appConfig.getAppUrl());
       dynamicWait.get().waittillpageloads();
       //Click on View All Infographics link    
       businessFunction.get().clickOnSubMenuItem("CaseStudies_MegaMenu", "CaseStudy_Megamenu_ViewAllInfographics_Link", "CaseStudy_Infographic_Title");
       //Verify the bread crumb
       businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "Infographic_BreadCrumb", "Tag_Anchors");
       //Verify the pods present in the Infographic Gallary page
       verify.get().isElementPresent("FeaturedCaseStudiesPod_Count");
       //Verify the heading bar
       verify.get().isElementPresent("CaseStudy_Infographic_Heading_Bar");
       //Verify the image present in the infograhic gallary page
       verify.get().isElementPresent("CaseStudy_Infographic_Image");
       //Verify the description
       verify.get().isElementPresent("CaseStudy_Infographic_Description");
}
/**
Author Name                       : Aishwarya
Date of Preparation               : 25/03/2015
Date of Modified                  : --
Methods Called                    : 
Purpose of Method                 :verify the functionality of Quick View
Dependencies                      : Jar files
Reviewed By                       : --
**/
@Test(description="verify the functionality of Quick View", groups="Case Studies")
public void testCaseStudyQuickView(){
       //To launch the Avaya application
       getDriver().get(appConfig.getAppUrl());
       dynamicWait.get().waittillpageloads();
       //Click on Case Studies link
       businessFunction.get().clickAndVerifyNavigation("CaseStudies_MegaMenu","Page_Title");
       //verify the presence of search-case studies pod
       userActions.get().clickOn("ChangeImage");
       try {
              Thread.sleep(5000);
       } catch (InterruptedException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
       }
       dynamicWait.get().waitforvisibilityOfElementLocated("PopupWindow");
       verify.get().isElementPresent("PopupWindow_Image");
       verify.get().isElementPresent("PopupWindow_Topic");
       verify.get().isElementPresent("PopupWindow_BusinessSize");
    userActions.get().clickOn("ViewFullCaseStudy_Button");
    businessFunction.get().clickAndVerifyNavigation("energy", "FindaCaseStudy");
       
       
}
/**
Author Name                       : Aishwarya
Date of Preparation               : 25/03/2015
Date of Modified                  : --
Methods Called                    : 
Purpose of Method                 :verify the presence of pop up window and verify the functionality
Dependencies                      : Jar files
Reviewed By                       : --
**/
@Test(description="verify the presence of pop up window and verify the functionality", groups="Case Studies")
public void testCaseStudyQuickView1(){
       //To launch the Avaya application
       getDriver().get(appConfig.getAppUrl());
       dynamicWait.get().waittillpageloads();
       //Click on Case Studies link
       businessFunction.get().clickAndVerifyNavigation("CaseStudies_MegaMenu","Page_Title");
       //verify the presence of search-case studies pod
       userActions.get().clickOn("ChangeImage");
       try {
              Thread.sleep(5000);
       } catch (InterruptedException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
       }
       //Verify whether the user is able to see the pop up window
       dynamicWait.get().waitforvisibilityOfElementLocated("PopupWindow");
       verify.get().isElementPresent("PopupWindow_Topic");
    verify.get().isElementPresent("PopupWindow_BusinessSize");
    
}

/**
Author Name                       : Aishwarya
Date of Preparation               : 25/03/2015
Date of Modified                  : --
Methods Called                    : 
Purpose of Method                 :verify the functionality for Find a Case Study pod
Dependencies                      : Jar files
Reviewed By                       : --
**/
@Test(description="verify the functionality for Find a Case Study pod", groups="Case Studies")
public void testCaseStudyFindaCaseStudyFunctionality()
{
       getDriver().get(appConfig.getAppUrl());
       dynamicWait.get().waittillpageloads();
       //Click on Case Studies link
       businessFunction.get().clickAndVerifyNavigation("CaseStudies_MegaMenu","Page_Title");
       //Select large from the drop down list for the attribute All Business Size
       userActions.get().SelectByText("CaseStudyDropDownBusinessSize", "Large");
       //Click on Submit button
       userActions.get().clickOn("CaseStudySubmit");
       dynamicWait.get().waittillpageloads();
       verify.get().verifySearchResultsCategory("ArticleFilterCategory","Large");
       Assert.assertEquals(userActions.get().getText("ArticleFilterKeyword"), "Large");
       Assert.assertEquals(userActions.get().getHtmlAttribute("CustomerBusinessSizeChkBox", "checked"), "true");
}



/**
Author Name                       : Aishwarya
Date of Preparation               : 25/03/2015
Date of Modified                  : --
Methods Called                    : 
Purpose of Method                 :verify the presence of pop up window and verify the functionality
Dependencies                      : Jar files
Reviewed By                       : --
**/
@Test(description="verify the presence of pop up window and verify the functionality", groups="Case Studies")
public void testCaseStudyDetailPage(){
       //To launch the Avaya application
       getDriver().get(appConfig.getAppUrl());
       dynamicWait.get().waittillpageloads();
       //Click on Case Studies link
       businessFunction.get().clickAndVerifyNavigation("CaseStudies_MegaMenu","Page_Title");
       //verify the presence of search-case studies pod
       userActions.get().clickOn("ChangeImage");
       try {
              Thread.sleep(5000);
       } catch (InterruptedException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
       }
       //Verify whether the user is able to see the pop up window
       dynamicWait.get().waitforvisibilityOfElementLocated("PopupWindow");
       verify.get().isElementPresent("PopupWindow_Topic");
       userActions.get().clickOn("ViewFullCaseStudy_Button");
       verify.get().isTextPresent("TransportationBureau_Heading");
       verify.get().isElementPresent("Benefitspods");
       verify.get().isElementPresent("Benefitspods_Heading");
       
       
}

/**
Author Name                       : Aishwarya
Date of Preparation               : 25/03/2015
Date of Modified                  : --
Methods Called                    : 
Purpose of Method                 :verify the description in case study detail page
Dependencies                      : Jar files
Reviewed By                       : --
**/
@Test(description="verify the description in case study detail page", groups="Case Studies")
public void testCaseStudyDetailPageDescription(){
       //To launch the Avaya application
       getDriver().get(appConfig.getAppUrl());
       dynamicWait.get().waittillpageloads();
       //Click on Case Studies link
       businessFunction.get().clickAndVerifyNavigation("CaseStudies_MegaMenu","Page_Title");
       //Click on the first image
       userActions.get().clickOn("ChangeImage");
       try {
              Thread.sleep(5000);
       } catch (InterruptedException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
       }
       //Verify whether the user is able to see the pop up window
       dynamicWait.get().waitforvisibilityOfElementLocated("PopupWindow");
       //Click on View Full Case Study Button
       userActions.get().clickOn("ViewFullCaseStudy_Button");
       verify.get().isTextPresent("TransportationBureau_Heading");
       verify.get().isElementPresent("CaseStudyDetailPage_Description");
       
        verify.get().isElementPresent("AvayaSolutionsDelivered_Heading");
       verify.get().isElementPresent("WhatOurCustomersAreSaying_Heading");
       verify.get().isElementPresent("CustomerProfile_Heading");
       
       
}
/**
Author Name                       : Aishwarya
Date of Preparation               : 25/03/2015
Date of Modified                  : --
Methods Called                    : 
Purpose of Method                 :verify the description in case study detail page
Dependencies                      : Jar files
Reviewed By                       : --
 
 
**/
@Test(description="verify the description in case study detail page", groups="Case Studies")
public void testCaseStudyDetailPagePodHeadings() {
       //To launch the Avaya application
       getDriver().get(appConfig.getAppUrl());
       dynamicWait.get().waittillpageloads();
       //Click on Case Studies link
       businessFunction.get().clickAndVerifyNavigation("CaseStudies_MegaMenu","Page_Title");
       //Click on the first image
       userActions.get().clickOn("ChangeImage");
       try {
              Thread.sleep(5000);
       } catch (InterruptedException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
       }
       //Verify whether the user is able to see the pop up window
       dynamicWait.get().waitforvisibilityOfElementLocated("PopupWindow");
       //Click on View Full Case Study Button
       userActions.get().clickOn("ViewFullCaseStudy_Button");
       //verify the presence of heading
       verify.get().isTextPresent("TransportationBureau_Heading");
       verify.get().isElementPresent("AvayaSolutionsDelivered_Heading");
       verify.get().isElementPresent("WhatOurCustomersAreSaying_Heading");
       verify.get().isElementPresent("CustomerProfile_Heading");
       
       
}


/**
Author Name                          : Aishwarya
Date of Preparation                  : 18/03/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the content in case studies page
Reviewed By                          : --
 
 
**/ 
@Test(description="Verify the Case Studies Page", groups="Case Studies")
public void testCaseStudiesDetailPage() 
{
       //Launching the Avaya website
       getDriver().get(appConfig.getAppUrl());
         dynamicWait.get().waittillpageloads();
       //Click on Case Studies link
       businessFunction.get().clickAndVerifyNavigation("CaseStudies_MegaMenu","Page_Title");
       //Click on the first image
       userActions.get().clickOn("ChangeImage");
       try {
       Thread.sleep(5000);
       } catch (InterruptedException e) {
       // TODO Auto-generated catch block
       e.printStackTrace();
       }
       //Verify whether the user is able to see the pop up window
       dynamicWait.get().waitforvisibilityOfElementLocated("PopupWindow");
       //Click on View Full Case Study Button
       userActions.get().clickOn("ViewFullCaseStudy_Button");
       //verify the presence of heading
       verify.get().isTextPresent("TransportationBureau_Heading");//Click on Case Studies link which is present in the mega menu
       verify.get().isElementDisplayed("ButlerBar");
       //verify the mega menu
       verify.get().isElementDisplayed("Megamenu");
       //verify the bread crumb
       businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "TransportationBureau_BreadCrumb", "Tag_Anchors");
       //verify the chat icon
       verify.get().isElementDisplayed("ChatPOPUP");
       
  }
/**
Author Name                          : Aishwarya
Date of Preparation                  : 3/04/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the navigation and heading of FAQ page
Reviewed By                          : --
**/ 
@Test(description="Verify the navigation and heading of FAQ page",groups="FAQS")
public void testFAQ()
{
		//Launching the Avaya Website
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		//Navigate to footer section and hover the mouse on Quick links tab
		userActions.get().hoverOn("Home_QuickLinks");
		//To check if options are displayed when hovered on Quick Links
		businessFunction.get().verifyMenuOrCategoryLinks("QuickLinks_ChildElements");
		//To click on Promotions & Programs link
		businessFunction.get().clickOnSubMenuItem("Home_QuickLinks", "FAQ", "FAQ_Heading");
		businessFunction.get().deFocus();
	    dynamicWait.get().waittillpageloads(); 
	

}
/**
Author Name                          : Aishwarya
Date of Preparation                  : 3/04/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the presence of breadcrumb and chat icon in FAQ landing page
Reviewed By                          : --
**/ 
@Test(description=" Verify the presence of breadcrumb and chat icon in FAQ landing page ",groups="FAQS")
public void testFAQBreadCrumb()
{
	//Launching the Avaya Website
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	//Navigate to footer section and hover the mouse on Quick links tab
	userActions.get().hoverOn("Home_QuickLinks");
	//To check if options are displayed when hovered on Quick Links
	businessFunction.get().verifyMenuOrCategoryLinks("QuickLinks_ChildElements");
	//To click on FAQ link
	businessFunction.get().clickOnSubMenuItem("Home_QuickLinks", "FAQ", "FAQ_Heading");
	businessFunction.get().deFocus();
	dynamicWait.get().waittillpageloads(); 
	//verify the presence of breadcrumb
	businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "FAQ_BreadCrumb", "Tag_Anchors");
	//To verify the presence of chat icon
	verify.get().isElementDisplayed("ChatPOPUP");
     
}
/**
Author Name                          : Aishwarya
Date of Preparation                  : 3/04/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the image carousel functionality in FAQ landing page
Reviewed By                          : --
**/ 
@Test(description="Verify the image carousel functionality in FAQ landing page",groups="FAQS")
public void testFAQLandingPageImageCarousel()
{
	//Launching the Avaya Website
		getDriver().get(appConfig.getAppUrl());
		dynamicWait.get().waittillpageloads();
		//Navigate to footer section and hover the mouse on Quick links tab
		userActions.get().hoverOn("Home_QuickLinks");
		//To check if options are displayed when hovered on Quick Links
		businessFunction.get().verifyMenuOrCategoryLinks("QuickLinks_ChildElements");
		//To click on FAQ link
		businessFunction.get().clickOnSubMenuItem("Home_QuickLinks", "FAQ", "FAQ_Heading");
		businessFunction.get().deFocus();
		dynamicWait.get().waittillpageloads(); 
       //Click on the second indicator button
       userActions.get().clickOn("Products_2ndIndicatorButton");
       //To verify if second image in the carousel is displayed
       businessFunction.get().imageValidation("Products_2ndImage");
}
/**
Author Name                          : Aishwarya
Date of Preparation                  : 3/04/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the pods in FAQ page, cannot be more than 8 pods before SEE ALL link
Reviewed By                          : --
**/ 
@Test(description="Verify the pods in FAQ page, cannot be more than 8 pods before SEE ALL link",groups="FAQS")
public void testFAQDiv()
{
	//Launching the Avaya Website
		getDriver().get(appConfig.getFaqUrl());
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		dynamicWait.get().waittillpageloads(); 
		//Validate the count of pods, cannot be more than 8
		businessFunction.get().validateText("FAQ_div");
		//Click on see all link
		userActions.get().clickOn("FAQ_SeeAll");
		//verify the pods present after clicking see all link
		verify.get().isElementPresent("FAQ_Pods_WhenClickedOn_SeeAll");
}
/**
Author Name                          : Aishwarya
Date of Preparation                  : 3/04/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the links in Browse FAQ widget
Reviewed By                          : --
**/ 

@Test(description="Verify the links in Browse FAQ widget",groups="FAQS")
public void testFAQBrowseFAQLinks()
{
	//Launching the Avaya Website
		getDriver().get(appConfig.getFaqUrl());
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		businessFunction.get().validateLinks("FAQ_BrowseFAQ_links");
		verify.get().isElementPresent("Show_More");
		userActions.get().clickOn("Show_More");
		verify.get().isElementPresent("Show_Less");
		
	
		
}
/**
Author Name                          : Aishwarya
Date of Preparation                  : 3/04/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the pods in FAQ landing page
Reviewed By                          : --
**/ 
@Test(description="Verify the pods in FAQ landing page",groups="FAQS")
public void testFAQLandingPagePods()
{
	    //Launching the Avaya Website
		getDriver().get(appConfig.getFaqUrl());
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		dynamicWait.get().waittillpageloads();
		//verify the presence of Browse FAQ Widget
		verify.get().isElementPresent("FAQ_BrowseFAQ_Widget");
		//Verify the presence of twitter pod
		verify.get().isElementPresent("FAQ_TwitterWidget");
		//Verify the presence of promo tout
		verify.get().isElementPresent("FAQ_PromoTout");
}
/**
Author Name                          : Aishwarya
Date of Preparation                  : 3/04/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the content in FAQ detail page
Reviewed By                          : --
**/ 
@Test(description="Verify the content in FAQ detail page",groups="FAQS")
public void testFAQDetailPage()
{
	    //Launching the Avaya Website
		getDriver().get(appConfig.getFaqUrl());
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		dynamicWait.get().waittillpageloads();
		//navigate to detail page
	businessFunction.get().clickAndVerifyNavigation("FAQ_Sachin_link", "Sachin_Title");
	//verify the bread  crumb in detail page
	businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "FAQ_DetailPage_BreadCrumb", "Tag_Anchors");
	//verify the content in detail page
	verify.get().isElementPresent("FAQ_DetailPage_Content");
	
}
/**
Author Name                          : Aishwarya
Date of Preparation                  : 3/04/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the pods in FAQ detail page
Reviewed By                          : --
**/ 
@Test(description="Verify the pods in FAQ detail page",groups="FAQS")
public void testFAQDetailPagePods()
{
	    //Launching the FAQ PAGE
		getDriver().get(appConfig.getFaqUrl());
		dynamicWait.get().waittillpageloads();
		businessFunction.get().deFocus();
		dynamicWait.get().waittillpageloads();
		//Click on the link
	   businessFunction.get().clickAndVerifyNavigation("FAQ_Sachin_link", "Sachin_Title");
	   //Verify the presence of promo pod
	   verify.get().isElementPresent("FAQ_DetailPage_Promo_Pod");
	   //verify the presence of leadership pod
	   verify.get().isElementPresent("FAQ_DetailPage_FeaturedLeaderShip_Pod");
	   verify.get().isElementPresent("FAQ_DetailPage_RelatedTopicsPod");
	  

	
}

/**
Author Name                          : Aishwarya
Date of Preparation                  : 5//11/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the Presence of Licensing tab in the Products page
Reviewed By                          : --
**/ 
@Test(description = "Verify the Presence of Licensing tab in the Products page", groups ="Licensing")
public void testLicensingTabInProductsPage(){
       //Launching the Avaya website
       getDriver().get(appConfig.getAppUrl());
       //Hover on Product and Click on Avaya Aura Platform
       dynamicWait.get().waittillpageloads();
       businessFunction.get().deFocus();
       //Click on the submenu item
       businessFunction.get().clickOnSubMenuItem("Products", "Products_AvayaAuraPlatform", "Products_AvayaAuraPlatform_Title");
       businessFunction.get().deFocus();
       //Verify the presence of Licensing tab
       verify.get().isElementPresent("Licensing_Tab");
       //Verify the presence of the arrow in the Licensing tab
       verify.get().isElementPresent("Licensing_Tab_Arrow");
}
/**
Author Name                          : Aishwarya
Date of Preparation                  : 5//11/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the presence of bread crumb in Licensing page
Reviewed By                          : --
**/ 
@Test(description = "Verify the presence of bread crumb in Licensing page", groups ="Licensing")
public void testClickOnLicensingTabInProductsPage(){
       //Launching the Avaya website
       getDriver().get(appConfig.getAppUrl());
       //Hover on Product and Click on Avaya Aura Platform
       dynamicWait.get().waittillpageloads();
       businessFunction.get().deFocus();
       //Click on the submenu item
       businessFunction.get().clickOnSubMenuItem("Products", "Products_AvayaAuraPlatform", "Products_AvayaAuraPlatform_Title");
       businessFunction.get().deFocus();
       businessFunction.get().clickAndVerifyNavigation("Licensing_Tab", "Licensing_Title");
    //chat icon should not be present
       verify.get().isElementNotPresent("ChatPOPUP");
       //verify the presence of bread crumb
       businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "Licensing_BreadCrumb", "Tag_Anchors");
       //verify the presence of Global Header
       verify.get().isElementPresent("Global_Header");
       //Verify the presence of Global Footer
       verify.get().isElementPresent("Global_Footer");
}

/**
Author Name                          : Aishwarya
Date of Preparation                  : 5//11/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the presence of bread crumb in Licensing page
Reviewed By                          : --
**/ 
@Test(description = "Verify the pods present in Licensing Landing page", groups ="Licensing")
public void testVerifyPodsinLicensingPage(){
       //Launching the Avaya website
       getDriver().get(appConfig.getAppUrl());
       //Hover on Product and Click on Avaya Aura Platform
       dynamicWait.get().waittillpageloads();
       businessFunction.get().deFocus();
       //Click on the submenu item
       businessFunction.get().clickOnSubMenuItem("Products", "Products_AvayaAuraPlatform", "Products_AvayaAuraPlatform_Title");
       businessFunction.get().deFocus();
       businessFunction.get().clickAndVerifyNavigation("Licensing_Tab", "Licensing_Title");
       verify.get().isElementPresent("Licensing_Enterprise_License_Agreement_Pod");
       verify.get().isElementPresent("Licensing_Avaya_Aura_Suite_Licensing_Pod");
       verify.get().isElementPresent("Licensing_Article_By_Pod");
       
}
/**
Author Name                          : Aishwarya
Date of Preparation                  : 5//11/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the content present in the Licensing pods
Reviewed By                          : --
**/ 
@Test(description = "Verify the content present in the Licensing pods", groups ="Licensing")
public void testVerifyContentInPodsinLicensingPage(){
       //Launching the Avaya website
       getDriver().get(appConfig.getAppUrl());
       //Hover on Product and Click on Avaya Aura Platform
       dynamicWait.get().waittillpageloads();
       businessFunction.get().deFocus();
       //Click on the submenu item
       businessFunction.get().clickOnSubMenuItem("Products", "Products_AvayaAuraPlatform", "Products_AvayaAuraPlatform_Title");
       businessFunction.get().deFocus();
       //Verify the page title
       businessFunction.get().clickAndVerifyNavigation("Licensing_Tab", "Licensing_Title");
       //verify the presence of the pod
       verify.get().isElementPresent("Licensing_Article_By_Pod");
       //verify the heading present in the pod
       verify.get().isElementPresent("Licensing_Article_By_Pod_Heading");
       //verify the description present in the pod
       verify.get().isElementPresent("Licensing_Article_By_Pod_Description");
       //verify the presence of the cta in the pod
       verify.get().isElementPresent("Licensing_Article_By_Pod_CTA");
       
}
/**
Author Name                          : Aishwarya
Date of Preparation                  : 5//11/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the content present in the Licensing detail page
Reviewed By                          : --
**/ 
@Test(description = "Verify the content present in the Licensing detail page", groups ="Licensing")
public void testVerifyContentInLicensingDetailPage(){
       //Launching the Avaya website
       getDriver().get(appConfig.getAppUrl());
       //Hover on Product and Click on Avaya Aura Platform
       dynamicWait.get().waittillpageloads();
       businessFunction.get().deFocus();
       //Click on the submenu item
       businessFunction.get().clickOnSubMenuItem("Products", "Products_AvayaAuraPlatform", "Products_AvayaAuraPlatform_Title");
       businessFunction.get().deFocus();
       //Verify the page title
       businessFunction.get().clickAndVerifyNavigation("Licensing_Tab", "Licensing_Title");
       //verify the presence of the pod
       verify.get().isElementPresent("Licensing_Article_By_Pod");
       userActions.get().clickOn("Licensing_Article_By_Pod_CTA");
       //chat icon should not be present
       verify.get().isElementNotPresent("ChatPOPUP");
       //verify the presence of bread crumb
       businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "Licensing_BreadCrumb_DetailPage", "Tag_Anchors");
       //verify the presence of Global Header
       verify.get().isElementPresent("Global_Header");
       //Verify the presence of Global Footer
       verify.get().isElementPresent("Global_Footer");
}
/**
Author Name                          : Aishwarya
Date of Preparation                  : 5//11/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the pods present in the Licensing detail page
Reviewed By                          : --
**/
@Test(description = "Verify the pods present in the Licensing detail page", groups ="Licensing")
public void testVerifypodsInLicensingDetailPage(){
       //Launching the Avaya website
       getDriver().get(appConfig.getAppUrl());
       //Hover on Product and Click on Avaya Aura Platform
       dynamicWait.get().waittillpageloads();
       businessFunction.get().deFocus();
       //Click on the submenu item
       businessFunction.get().clickOnSubMenuItem("Products", "Products_AvayaAuraPlatform", "Products_AvayaAuraPlatform_Title");
       businessFunction.get().deFocus();
       //Verify the page title
       businessFunction.get().clickAndVerifyNavigation("Licensing_Tab", "Licensing_Title");
       //verify the presence of the pod
       verify.get().isElementPresent("Licensing_Article_By_Pod");
       userActions.get().clickOn("Licensing_Article_By_Pod_CTA");
       verify.get().isElementPresent("Licensing_DetailPage_FeaturedPod");
       verify.get().isElementPresent("Licensing_DetailPage_Pods");
       verify.get().isElementPresent("Licensing_DetailPage_MiddlePods");
}
/**
Author Name                          : Aishwarya
Date of Preparation                  : 5//11/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the Filter Search in Case Studies page under Product/Avaya Aura Platform-Licensing
Reviewed By                          : --
**/
@Test(description = "Verify the Filter Search in Case Studies page under Product/Avaya Aura Platform-Licensing", groups ="Licensing")
              public void testlicensingDetailPageCaseStudiesFilterSearch(){
       //Launching the Avaya website
              getDriver().get(appConfig.getAppUrl());
              //Hover on Product and Click on Avaya Aura Platform
              dynamicWait.get().waittillpageloads();
              businessFunction.get().deFocus();
              //Click on the submenu item
              businessFunction.get().clickOnSubMenuItem("Products", "Products_AvayaAuraPlatform", "Products_AvayaAuraPlatform_Title");
              businessFunction.get().deFocus();
              //Verify the page title
              businessFunction.get().clickAndVerifyNavigation("Licensing_Tab", "Licensing_Title");
              verify.get().isElementPresent("Licensing_Article_By_Pod");
              userActions.get().clickOn("Licensing_Article_By_Pod_CTA");
              userActions.get().clickOn("Licensing_CaseStudies");
              //Click on checkbox in Case Studies page
              dynamicWait.get().waittillpageloads();
              userActions.get().clickOn("CaseStudies_Industry_Healthcare");
              //Verify the count of the filter search result
              dynamicWait.get().waittillpageloads();
              businessFunction.get().checkFilterSelections("CaseStudies_IndustryCheckboxes", "YourSelection_Title","Licensing_CountText1");
                     
              }

//Licensing-Services
/**
Author Name                          : Aishwarya
Date of Preparation                  : 5//11/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the Presence of Licensing tab in the services page
Reviewed By                          : --
**/ 
@Test(description = "Verify the Presence of Licensing tab in the services page", groups ="Licensing")
public void testLicensingTabInServicesPage(){
       //Launching the Avaya website
       getDriver().get(appConfig.getAppUrl());
       
       dynamicWait.get().waittillpageloads();
       businessFunction.get().deFocus();
       //Click on the submenu item
       businessFunction.get().clickOnSubMenuItem("Services","CloudTransformationServices","CloudTransformationServices_Title");  
       businessFunction.get().deFocus();
       //Verify the presence of Licensing tab
       verify.get().isElementPresent("Licensing_Tab");
       //Verify the presence of the arrow in the Licensing tab
       verify.get().isElementPresent("Licensing_Tab_Arrow");
}
/**
Author Name                          : Aishwarya
Date of Preparation                  : 5//11/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the presence of bread crumb in Licensing page-services
Reviewed By                          : --
**/ 
@Test(description = "Verify the presence of bread crumb in Licensing page-services", groups ="Licensing")
public void testClickOnLicensingTabInServicesPage(){
       //Launching the Avaya website
       getDriver().get(appConfig.getAppUrl());
       
       dynamicWait.get().waittillpageloads();
       businessFunction.get().deFocus();
       //Click on the submenu item
       businessFunction.get().clickOnSubMenuItem("Services","CloudTransformationServices","CloudTransformationServices_Title");
       businessFunction.get().deFocus();
       businessFunction.get().clickAndVerifyNavigation("Licensing_Tab", "Licensing_Title");
    //chat icon should not be present
       verify.get().isElementNotPresent("ChatPOPUP");
       //verify the presence of bread crumb
       businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "Licensing_BreadCrumb", "Tag_Anchors");
       //verify the presence of Global Header
       verify.get().isElementPresent("Global_Header");
       //Verify the presence of Global Footer
       verify.get().isElementPresent("Global_Footer");
}

/**
Author Name                          : Aishwarya
Date of Preparation                  : 5//11/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the presence of bread crumb in Licensing page-services
Reviewed By                          : --
**/ 
@Test(description = "Verify the pods present in Licensing Landing page-services", groups ="Licensing")
public void testVerifyPodsinLicensingPageServices(){
       //Launching the Avaya website
       getDriver().get(appConfig.getAppUrl());
       
       dynamicWait.get().waittillpageloads();
       businessFunction.get().deFocus();
       //Click on the submenu item
       businessFunction.get().clickOnSubMenuItem("Services","CloudTransformationServices","CloudTransformationServices_Title");
       businessFunction.get().deFocus();
       businessFunction.get().clickAndVerifyNavigation("Licensing_Tab", "Licensing_Title");
       verify.get().isElementPresent("Licensing_Enterprise_License_Agreement_Pod");
       verify.get().isElementPresent("Licensing_Avaya_Aura_Suite_Licensing_Pod");
       verify.get().isElementPresent("Licensing_Article_By_Pod");
       
}
/**
Author Name                          : Aishwarya
Date of Preparation                  : 5//11/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the content present in the Licensing pods-services
Reviewed By                          : --
**/ 
@Test(description = "Verify the content present in the Licensing pods-services", groups ="Licensing")
public void testVerifyContentInPodsinLicensingPageServices(){
       //Launching the Avaya website
       getDriver().get(appConfig.getAppUrl());
       
       dynamicWait.get().waittillpageloads();
       businessFunction.get().deFocus();
       //Click on the submenu item
       businessFunction.get().clickOnSubMenuItem("Services","CloudTransformationServices","CloudTransformationServices_Title");
       businessFunction.get().deFocus();
       //Verify the page title
       businessFunction.get().clickAndVerifyNavigation("Licensing_Tab", "Licensing_Title");
       //verify the presence of the pod
       verify.get().isElementPresent("Licensing_Article_By_Pod");
       //verify the heading present in the pod
       verify.get().isElementPresent("Licensing_Article_By_Pod_Heading");
       //verify the description present in the pod
       verify.get().isElementPresent("Licensing_Article_By_Pod_Description");
       //verify the presence of the cta in the pod
       verify.get().isElementPresent("Licensing_Article_By_Pod_CTA");
       
}
/**
Author Name                          : Aishwarya
Date of Preparation                  : 5//11/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the content present in the Licensing detail page
Reviewed By                          : --
**/ 
@Test(description = "Verify the content present in the Licensing detail page-Services", groups ="Licensing")
public void testVerifyContentInLicensingDetailPageServices(){
       //Launching the Avaya website
       getDriver().get(appConfig.getAppUrl());
       
       dynamicWait.get().waittillpageloads();
       businessFunction.get().deFocus();
       //Click on the submenu item
       businessFunction.get().clickOnSubMenuItem("Services","CloudTransformationServices","CloudTransformationServices_Title");
       businessFunction.get().deFocus();
       //Verify the page title
       businessFunction.get().clickAndVerifyNavigation("Licensing_Tab", "Licensing_Title");
       //verify the presence of the pod
       verify.get().isElementPresent("Licensing_Article_By_Pod");
       userActions.get().clickOn("Licensing_Article_By_Pod_CTA");
       //chat icon should not be present
       verify.get().isElementNotPresent("ChatPOPUP");
       //verify the presence of bread crumb
       businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "Licensing_BreadCrumb_DetailPage", "Tag_Anchors");
       //verify the presence of Global Header
       verify.get().isElementPresent("Global_Header");
       //Verify the presence of Global Footer
       verify.get().isElementPresent("Global_Footer");
}
/**
Author Name                          : Aishwarya
Date of Preparation                  : 5//11/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the pods present in the Licensing detail page
Reviewed By                          : --
**/
@Test(description = "Verify the pods present in the Licensing detail page-services", groups ="Licensing")
public void testVerifypodsInLicensingDetailPageServices(){
       //Launching the Avaya website
       getDriver().get(appConfig.getAppUrl());
       
       dynamicWait.get().waittillpageloads();
       businessFunction.get().deFocus();
       //Click on the submenu item
       businessFunction.get().clickOnSubMenuItem("Services","CloudTransformationServices","CloudTransformationServices_Title");
       businessFunction.get().deFocus();
       //Verify the page title
       businessFunction.get().clickAndVerifyNavigation("Licensing_Tab", "Licensing_Title");
       //verify the presence of the pod
       verify.get().isElementPresent("Licensing_Article_By_Pod");
       userActions.get().clickOn("Licensing_Article_By_Pod_CTA");
       verify.get().isElementPresent("Licensing_DetailPage_FeaturedPod");
       verify.get().isElementPresent("Licensing_DetailPage_Pods");
       verify.get().isElementPresent("Licensing_DetailPage_MiddlePods");
}
/**
Author Name                          : Aishwarya
Date of Preparation                  : 5//11/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the Filter Search in Case Studies page under Product/Avaya Aura Platform-Licensing
Reviewed By                          : --
**/
@Test(description = "Verify the Filter Search in Case Studies page under Product/Avaya Aura Platform-Licensing-services", groups ="Licensing")
              public void testlicensingDetailPageCaseStudiesFilterSearchServices(){
       //Launching the Avaya website
              getDriver().get(appConfig.getAppUrl());
       
              dynamicWait.get().waittillpageloads();
              businessFunction.get().deFocus();
              //Click on the submenu item
              businessFunction.get().clickOnSubMenuItem("Services","CloudTransformationServices","CloudTransformationServices_Title");
              businessFunction.get().deFocus();
              //Verify the page title
              businessFunction.get().clickAndVerifyNavigation("Licensing_Tab", "Licensing_Title");
              verify.get().isElementPresent("Licensing_Article_By_Pod");
              userActions.get().clickOn("Licensing_Article_By_Pod_CTA");
              userActions.get().clickOn("Licensing_CaseStudies");
              //Click on checkbox in Case Studies page
              dynamicWait.get().waittillpageloads();
              userActions.get().clickOn("CaseStudies_Industry_Healthcare");
              //Verify the count of the filter search result
              dynamicWait.get().waittillpageloads();
              businessFunction.get().checkFilterSelections("CaseStudies_IndustryCheckboxes", "YourSelection_Title","Licensing_CountText1");
                     
              }


//Solutions
/**
Author Name                          : Aishwarya
Date of Preparation                  : 5//11/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the Presence of Licensing tab in the solutions page
Reviewed By                          : --
**/ 
@Test(description = "Verify the Presence of Licensing tab in the solutions page", groups ="Licensing")
public void testLicensingTabInSolutionsPage(){
       //Launching the Avaya website
       getDriver().get(appConfig.getAppUrl());
       
       dynamicWait.get().waittillpageloads();
       businessFunction.get().deFocus();
       //Click on the submenu item
       businessFunction.get().clickOnSubMenuItem("Solutions","CustomerExperience","CustomerExperienceTitle");  
       businessFunction.get().deFocus();
       //Verify the presence of Licensing tab
       verify.get().isElementPresent("Licensing_Tab");
       //Verify the presence of the arrow in the Licensing tab
       verify.get().isElementPresent("Licensing_Tab_Arrow");
}
/**
Author Name                          : Aishwarya
Date of Preparation                  : 5//11/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the presence of bread crumb in Licensing page-solutions
Reviewed By                          : --
**/ 
@Test(description = "Verify the presence of bread crumb in Licensing page-Solutions", groups ="Licensing")
public void testClickOnLicensingTabInSolutionsPage(){
       //Launching the Avaya website
       getDriver().get(appConfig.getAppUrl());
       
       dynamicWait.get().waittillpageloads();
       businessFunction.get().deFocus();
       //Click on the submenu item
       businessFunction.get().clickOnSubMenuItem("Solutions","CustomerExperience","CustomerExperienceTitle");  
       businessFunction.get().deFocus();
       businessFunction.get().clickAndVerifyNavigation("Licensing_Tab", "Licensing_Title");
    //chat icon should not be present
       verify.get().isElementNotPresent("ChatPOPUP");
       //verify the presence of bread crumb
       businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "Licensing_BreadCrumb", "Tag_Anchors");
       //verify the presence of Global Header
       verify.get().isElementPresent("Global_Header");
       //Verify the presence of Global Footer
       verify.get().isElementPresent("Global_Footer");
}

/**
Author Name                          : Aishwarya
Date of Preparation                  : 5//11/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the presence of bread crumb in Licensing page-Solutions
Reviewed By                          : --
**/ 
@Test(description = "Verify the pods present in Licensing Landing page-services", groups ="Licensing")
public void testVerifyPodsinLicensingPageSolutions(){
       //Launching the Avaya website
       getDriver().get(appConfig.getAppUrl());
       
       dynamicWait.get().waittillpageloads();
       businessFunction.get().deFocus();
       //Click on the submenu item
       businessFunction.get().clickOnSubMenuItem("Solutions","CustomerExperience","CustomerExperienceTitle");  
       businessFunction.get().deFocus();
       businessFunction.get().clickAndVerifyNavigation("Licensing_Tab", "Licensing_Title");
       verify.get().isElementPresent("Licensing_Enterprise_License_Agreement_Pod");
       verify.get().isElementPresent("Licensing_Avaya_Aura_Suite_Licensing_Pod");
       verify.get().isElementPresent("Licensing_Article_By_Pod");
       
}
/**
Author Name                          : Aishwarya
Date of Preparation                  : 5//11/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the content present in the Licensing pods-Solutions
Reviewed By                          : --
**/ 
@Test(description = "Verify the content present in the Licensing pods-services", groups ="Licensing")
public void testVerifyContentInPodsinLicensingPageSolutions(){
       //Launching the Avaya website
       getDriver().get(appConfig.getAppUrl());
       
       dynamicWait.get().waittillpageloads();
       businessFunction.get().deFocus();
       //Click on the submenu item
       businessFunction.get().clickOnSubMenuItem("Solutions","CustomerExperience","CustomerExperienceTitle");  
       businessFunction.get().deFocus();
       //Verify the page title
       businessFunction.get().clickAndVerifyNavigation("Licensing_Tab", "Licensing_Title");
       //verify the presence of the pod
       verify.get().isElementPresent("Licensing_Article_By_Pod");
       //verify the heading present in the pod
       verify.get().isElementPresent("Licensing_Article_By_Pod_Heading");
       //verify the description present in the pod
       verify.get().isElementPresent("Licensing_Article_By_Pod_Description");
       //verify the presence of the cta in the pod
       verify.get().isElementPresent("Licensing_Article_By_Pod_CTA");
       
}
/**
Author Name                          : Aishwarya
Date of Preparation                  : 5//11/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the content present in the Licensing detail page
Reviewed By                          : --
**/ 
@Test(description = "Verify the content present in the Licensing detail page-Solutions", groups ="Licensing")
public void testVerifyContentInLicensingDetailPageSolutions(){
       //Launching the Avaya website
       getDriver().get(appConfig.getAppUrl());
       
       dynamicWait.get().waittillpageloads();
       businessFunction.get().deFocus();
       //Click on the submenu item
       businessFunction.get().clickOnSubMenuItem("Solutions","CustomerExperience","CustomerExperienceTitle");  
       businessFunction.get().deFocus();
       //Verify the page title
       businessFunction.get().clickAndVerifyNavigation("Licensing_Tab", "Licensing_Title");
       //verify the presence of the pod
       verify.get().isElementPresent("Licensing_Article_By_Pod");
       userActions.get().clickOn("Licensing_Article_By_Pod_CTA");
       //chat icon should not be present
       verify.get().isElementNotPresent("ChatPOPUP");
       //verify the presence of bread crumb
       businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "Licensing_BreadCrumb_DetailPage", "Tag_Anchors");
       //verify the presence of Global Header
       verify.get().isElementPresent("Global_Header");
       //Verify the presence of Global Footer
       verify.get().isElementPresent("Global_Footer");
}
/**
Author Name                          : Aishwarya
Date of Preparation                  : 5//11/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the pods present in the Licensing detail page
Reviewed By                          : --
**/
@Test(description = "Verify the pods present in the Licensing detail page-Solutions", groups ="Licensing")
public void testVerifypodsInLicensingDetailPageSolutions(){
       //Launching the Avaya website
       getDriver().get(appConfig.getAppUrl());
       
       dynamicWait.get().waittillpageloads();
       businessFunction.get().deFocus();
       //Click on the submenu item
       businessFunction.get().clickOnSubMenuItem("Solutions","CustomerExperience","CustomerExperienceTitle");  
       businessFunction.get().deFocus();
       //Verify the page title
       businessFunction.get().clickAndVerifyNavigation("Licensing_Tab", "Licensing_Title");
       //verify the presence of the pod
       verify.get().isElementPresent("Licensing_Article_By_Pod");
       userActions.get().clickOn("Licensing_Article_By_Pod_CTA");
       verify.get().isElementPresent("Licensing_DetailPage_FeaturedPod");
       verify.get().isElementPresent("Licensing_DetailPage_Pods");
       verify.get().isElementPresent("Licensing_DetailPage_MiddlePods");
}
/**
Author Name                          : Aishwarya
Date of Preparation                  : 5//11/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the Filter Search in Case Studies page under Product/Avaya Aura Platform-Licensing
Reviewed By                          : --
**/
@Test(description = "Verify the Filter Search in Case Studies page under Product/Avaya Aura Platform-Licensing-Solutions", groups ="Licensing")
              public void testlicensingDetailPageCaseStudiesFilterSearchSolutions(){
       //Launching the Avaya website
              getDriver().get(appConfig.getAppUrl());
              
              dynamicWait.get().waittillpageloads();
              businessFunction.get().deFocus();
              //Click on the submenu item
              businessFunction.get().clickOnSubMenuItem("Solutions","CustomerExperience","CustomerExperienceTitle");  
              businessFunction.get().deFocus();
              //Verify the page title
              businessFunction.get().clickAndVerifyNavigation("Licensing_Tab", "Licensing_Title");
              verify.get().isElementPresent("Licensing_Article_By_Pod");
              userActions.get().clickOn("Licensing_Article_By_Pod_CTA");
              userActions.get().clickOn("Licensing_CaseStudies");
              //Click on checkbox in Case Studies page
              dynamicWait.get().waittillpageloads();
              userActions.get().clickOn("CaseStudies_Industry_Healthcare");
              //Verify the count of the filter search result
              dynamicWait.get().waittillpageloads();
              businessFunction.get().checkFilterSelections("CaseStudies_IndustryCheckboxes", "YourSelection_Title","Licensing_CountText1");
                     
              }

/**
Author Name                          : Aishwarya
Date of Preparation                  : 5//11/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the Presence of Licensing tab in the phones page
Reviewed By                          : --
**/ 
@Test(description = "Verify the Presence of Licensing tab in the phones page", groups ="Licensing")
public void testLicensingTabInPhonesPage(){
       //Launching the Avaya website
       getDriver().get(appConfig.getAppUrl());
       
       dynamicWait.get().waittillpageloads();
       businessFunction.get().deFocus();
       //Click on the submenu item
       businessFunction.get().clickOnSubMenuItem("Products","Phones_Licensing","Phones_LicensingTilte");  
       businessFunction.get().deFocus();
       userActions.get().clickOn("Desktop_Telephones");
       userActions.get().clickOn("Desktop_Telephones_LearnMore");
       //Verify the presence of Licensing tab
       verify.get().isElementPresent("Licensing_Tab");
       //Verify the presence of the arrow in the Licensing tab
       verify.get().isElementPresent("Licensing_Tab_Arrow");
}
/**
Author Name                          : Aishwarya
Date of Preparation                  : 5//11/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the presence of bread crumb in Licensing page-phones
Reviewed By                          : --
**/ 
@Test(description = "Verify the presence of bread crumb in Licensing page-phones", groups ="Licensing")
public void testClickOnLicensingTabInPhonesPage(){
       //Launching the Avaya website
       getDriver().get(appConfig.getAppUrl());
       
       dynamicWait.get().waittillpageloads();
       businessFunction.get().deFocus();
       //Click on the submenu item
       businessFunction.get().clickOnSubMenuItem("Products","Phones_Licensing","Phones_LicensingTilte");  
       businessFunction.get().deFocus();
       userActions.get().clickOn("Desktop_Telephones");
       userActions.get().clickOn("Desktop_Telephones_LearnMore");
       businessFunction.get().clickAndVerifyNavigation("Licensing_Tab", "Licensing_Title");
    //chat icon should not be present
       verify.get().isElementNotPresent("ChatPOPUP");
       //verify the presence of bread crumb
       businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "Licensing_BreadCrumb", "Tag_Anchors");
       //verify the presence of Global Header
       verify.get().isElementPresent("Global_Header");
       //Verify the presence of Global Footer
       verify.get().isElementPresent("Global_Footer");
}

/**
Author Name                          : Aishwarya
Date of Preparation                  : 5//11/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the presence of bread crumb in Licensing page-Phones
Reviewed By                          : --
**/ 
@Test(description = "Verify the pods present in Licensing Landing page-Phones", groups ="Licensing")
public void testVerifyPodsinLicensingPagePhones(){
       //Launching the Avaya website
       getDriver().get(appConfig.getAppUrl());
       
       dynamicWait.get().waittillpageloads();
       businessFunction.get().deFocus();
       //Click on the submenu item
       businessFunction.get().clickOnSubMenuItem("Products","Phones_Licensing","Phones_LicensingTilte");  
       businessFunction.get().deFocus();
       userActions.get().clickOn("Desktop_Telephones");
       userActions.get().clickOn("Desktop_Telephones_LearnMore");
       businessFunction.get().clickAndVerifyNavigation("Licensing_Tab", "Licensing_Title");
       verify.get().isElementPresent("Licensing_Enterprise_License_Agreement_Pod");
       verify.get().isElementPresent("Licensing_Avaya_Aura_Suite_Licensing_Pod");
       verify.get().isElementPresent("Licensing_Article_By_Pod");
       
}
/**
Author Name                          : Aishwarya
Date of Preparation                  : 5//11/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the content present in the Licensing pods-phones
Reviewed By                          : --
**/ 
@Test(description = "Verify the content present in the Licensing pods-phones", groups ="Licensing")
public void testVerifyContentInPodsinLicensingPagePhones(){
       //Launching the Avaya website
       getDriver().get(appConfig.getAppUrl());
       
       dynamicWait.get().waittillpageloads();
       businessFunction.get().deFocus();
       //Click on the submenu item
       businessFunction.get().clickOnSubMenuItem("Products","Phones_Licensing","Phones_LicensingTilte");  
       businessFunction.get().deFocus();
       userActions.get().clickOn("Desktop_Telephones");
       userActions.get().clickOn("Desktop_Telephones_LearnMore");
       //Verify the page title
       businessFunction.get().clickAndVerifyNavigation("Licensing_Tab", "Licensing_Title");
       //verify the presence of the pod
       verify.get().isElementPresent("Licensing_Article_By_Pod");
       //verify the heading present in the pod
       verify.get().isElementPresent("Licensing_Article_By_Pod_Heading");
       //verify the description present in the pod
       verify.get().isElementPresent("Licensing_Article_By_Pod_Description");
       //verify the presence of the cta in the pod
       verify.get().isElementPresent("Licensing_Article_By_Pod_CTA");
       
}
/**
Author Name                          : Aishwarya
Date of Preparation                  : 5//11/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the content present in the Licensing detail page-phones
Reviewed By                          : --
**/ 
@Test(description = "Verify the content present in the Licensing detail page-Phones", groups ="Licensing")
public void testVerifyContentInLicensingDetailPagePhones(){
       //Launching the Avaya website
       getDriver().get(appConfig.getAppUrl());
       
       dynamicWait.get().waittillpageloads();
       businessFunction.get().deFocus();
       //Click on the submenu item
       businessFunction.get().clickOnSubMenuItem("Products","Phones_Licensing","Phones_LicensingTilte");  
       businessFunction.get().deFocus();
       userActions.get().clickOn("Desktop_Telephones");
       userActions.get().clickOn("Desktop_Telephones_LearnMore");
       //Verify the page title
       businessFunction.get().clickAndVerifyNavigation("Licensing_Tab", "Licensing_Title");
       //verify the presence of the pod
       verify.get().isElementPresent("Licensing_Article_By_Pod");
       userActions.get().clickOn("Licensing_Article_By_Pod_CTA");
       //chat icon should not be present
       verify.get().isElementNotPresent("ChatPOPUP");
       //verify the presence of bread crumb
       businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "Licensing_BreadCrumb_DetailPage", "Tag_Anchors");
       //verify the presence of Global Header
       verify.get().isElementPresent("Global_Header");
       //Verify the presence of Global Footer
       verify.get().isElementPresent("Global_Footer");
}
/**
Author Name                          : Aishwarya
Date of Preparation                  : 5//11/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the pods present in the Licensing detail page-phones
Reviewed By                          : --
**/
@Test(description = "Verify the pods present in the Licensing detail page-phones", groups ="Licensing")
public void testVerifypodsInLicensingDetailPagePhones(){
       //Launching the Avaya website
       getDriver().get(appConfig.getAppUrl());

       dynamicWait.get().waittillpageloads();
       businessFunction.get().deFocus();
       //Click on the submenu item
       businessFunction.get().clickOnSubMenuItem("Products","Phones_Licensing","Phones_LicensingTilte");  
       businessFunction.get().deFocus();
       userActions.get().clickOn("Desktop_Telephones");
       userActions.get().clickOn("Desktop_Telephones_LearnMore");
       //Verify the page title
       businessFunction.get().clickAndVerifyNavigation("Licensing_Tab", "Licensing_Title");
       //verify the presence of the pod
       verify.get().isElementPresent("Licensing_Article_By_Pod");
       userActions.get().clickOn("Licensing_Article_By_Pod_CTA");
       verify.get().isElementPresent("Licensing_DetailPage_FeaturedPod");
       verify.get().isElementPresent("Licensing_DetailPage_Pods");
       verify.get().isElementPresent("Licensing_DetailPage_MiddlePods");
}
/**
Author Name                          : Aishwarya
Date of Preparation                  : 5//11/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the Filter Search in Case Studies page under phones-Licensing
Reviewed By                          : --
**/
@Test(description = "Verify the Filter Search in Case Studies page under Product-phones", groups ="Licensing")
              public void testlicensingDetailPageCaseStudiesFilterSearchPhones(){
       //Launching the Avaya website
              getDriver().get(appConfig.getAppUrl());
              dynamicWait.get().waittillpageloads();
              businessFunction.get().deFocus();
              //Click on the submenu item
              businessFunction.get().clickOnSubMenuItem("Products","Phones_Licensing","Phones_LicensingTilte");  
              businessFunction.get().deFocus();
              userActions.get().clickOn("Desktop_Telephones");
              userActions.get().clickOn("Desktop_Telephones_LearnMore");
              //Verify the page title
              businessFunction.get().clickAndVerifyNavigation("Licensing_Tab", "Licensing_Title");
              verify.get().isElementPresent("Licensing_Article_By_Pod");
              userActions.get().clickOn("Licensing_Article_By_Pod_CTA");
              userActions.get().clickOn("Licensing_CaseStudies");
              //Click on checkbox in Case Studies page
              dynamicWait.get().waittillpageloads();
              userActions.get().clickOn("CaseStudies_Industry_Healthcare");
              //Verify the count of the filter search result
              dynamicWait.get().waittillpageloads();
              businessFunction.get().checkFilterSelections("CaseStudies_IndustryCheckboxes", "YourSelection_Title","Licensing_CountText1");
                     
              }


//Investors Start Point
/**
Author Name                          : Aishwarya
Date of Preparation                  : 5//13/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the content in Investors page
Reviewed By                          : --
**/
@Test(description="Verify the content in Investors page",groups="Investors")
public void testInvestorPage(){
       getDriver().get(appConfig.getInvestorUrl());
       dynamicWait.get().waittillpageloads();
  //verify the presence of breadcrumb
       businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "Investors_Overview_breadcrumb", "Tag_Anchors");

       verify.get().isElementNotPresent("ChatPOPUP");
       verify.get().isElementPresent("Investors_Heading");
       verify.get().isElementPresent("Investors_Overview_Tab");
       verify.get().isElementPresent("Investors_NewsEvents_Tab");
       verify.get().isElementPresent("Investors_FinancialInfo_Tab");
       verify.get().isElementPresent("Investors_CorporateGovernance_Tab");
       //verify the presence of Global Header
       verify.get().isElementPresent("Global_Header");
       //Verify the presence of Global Footer
       verify.get().isElementPresent("Global_Footer");
       }
       /**
       Author Name                          : Aishwarya
       Date of Preparation                  : 5//13/2015
       Date of Modified                     : --
       Methods Called                       : 
       Purpose of Method                    : Verify the content present in Corporate Overview pod
       Reviewed By                          : --
    **/
       @Test(description="Verify the content present in Corporate Overview pod ",groups="Investors")
       public void testInvestorPageCorporateOverview(){
       getDriver().get(appConfig.getInvestorUrl());
       dynamicWait.get().waittillpageloads();
    //verify the presence of breadcrumb
       businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "Investors_Overview_breadcrumb", "Tag_Anchors");
    verify.get().isElementPresent("CorporateOverview_Heading");
    verify.get().isElementPresent("CorporateOverview_Description");
    verify.get().isElementPresent("CorporateOverview_ReadMore");
       
       }

       /**
       Author Name                          : Aishwarya
       Date of Preparation                  : 5//13/2015
       Date of Modified                     : --
       Methods Called                       : 
       Purpose of Method                    : Verify the content present in Leadership pod
       Reviewed By                          : --
       **/
       @Test(description="Verify the content present in Leadership pod",groups="Investors")
       public void testInvestorPageLeaderShip(){
       getDriver().get(appConfig.getInvestorUrl());
       dynamicWait.get().waittillpageloads();
    //verify the presence of breadcrumb
       businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "Investors_Overview_breadcrumb", "Tag_Anchors");
       verify.get().isElementPresent("Leadership_Heading");
       verify.get().isElementPresent("Leadership_Description");
       verify.get().isElementPresent("Leadership_ReadMore");
       businessFunction.get().clickAndVerifyNavigation("Leadership_ReadMore", "Investors_Leadership_Title");    
              }

       /**
       Author Name                          : Aishwarya
       Date of Preparation                  : 5//13/2015
       Date of Modified                     : --
       Methods Called                       : 
       Purpose of Method                    : Verify the content present in News and Events pod
       Reviewed By                          : --
       **/
       @Test(description="Verify the content present in News and Events pod",groups="Investors")
       public void testInvestorPageNews(){
       getDriver().get(appConfig.getInvestorUrl());
       dynamicWait.get().waittillpageloads();
       //verify the presence of breadcrumb
       businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "Investors_Overview_breadcrumb", "Tag_Anchors");
       verify.get().isElementPresent("News_Heading");
       verify.get().isElementPresent("News_Description");
       verify.get().isElementPresent("News_ReadMore");
       verify.get().isElementPresent("News_Link");
       verify.get().isElementPresent("News_Date");     
       verify.get().isElementPresent("Latest_Quarter");
       verify.get().isElementPresent("Featured_Widget");
       verify.get().isElementPresent("Email");  
       verify.get().isElementPresent("Investor");
              }

       /**
       Author Name                          : Aishwarya
       Date of Preparation                  : 5//13/2015
       Date of Modified                     : --
       Methods Called                       : 
       Purpose of Method                    : Verify whether the selected year news are displayed when clicked on the year from drop down
       Reviewed By                          : --
       **/

       @Test(description="Verify whether the selected year news are displayed when clicked on the year from drop down",groups="Investors")
       public void testInvestorsQuarterlyResultsYear()
       {
       getDriver().get(appConfig.getInvestorUrl());
       dynamicWait.get().waittillpageloads();
       userActions.get().clickOn("Investors_FinancialInfo_Tab");
       //verify the heading
       verify.get().isElementPresent("title_Licensing");
       //Click on the year drop down
    userActions.get().clickOn("Year");
    businessFunction.get().checkToggleMenuArrows("Year", "NewsRoom_SelectRangeExpected", "up");
    //select 2012
    userActions.get().clickOn("NewsRoom_SelectRange_2012");
    //verify the results
    verify.get().isElementPresent("SelectedYearList_Licensing");
    verify.get().isElementPresent("Licensing_ReportList");

    }
       /**
       Author Name                          : Aishwarya
       Date of Preparation                  : 5//13/2015
       Date of Modified                     : --
       Methods Called                       : 
       Purpose of Method                    :Verify the content in Investors-Quarterly Results Page
       Reviewed By                          : --
       **/
       @Test(description="Verify the content in Investors-Quarterly Results Page",groups="Investors")
       public void testInvestorsQuarterlyResultsContent(){
       getDriver().get(appConfig.getInvestorUrl());
       dynamicWait.get().waittillpageloads();
       userActions.get().clickOn("Investors_FinancialInfo_Tab");
       verify.get().isElementPresent("title_Licensing");
    //verify the presence of breadcrumb
       businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "Investors_QuarterlyResults_breadcrumb", "Tag_Anchors");
    //chat option should not be present
       verify.get().isElementNotPresent("ChatPOPUP");
       //verify the presence of investors heading
       verify.get().isElementPresent("Investors_Heading");
       verify.get().isElementPresent("Investors_Overview_Tab");
       verify.get().isElementPresent("Investors_NewsEvents_Tab");
       verify.get().isElementPresent("Investors_FinancialInfo_Tab");
       verify.get().isElementPresent("Investors_CorporateGovernance_Tab");
       //verify the presence of Global Header
       verify.get().isElementPresent("Global_Header");
       //Verify the presence of Global Footer
       verify.get().isElementPresent("Global_Footer");
       }

       /**
       Author Name                          : Aishwarya
       Date of Preparation                  : 5//13/2015
       Date of Modified                     : --
       Methods Called                       : 
       Purpose of Method                    :Verify the sub-bar in Investors-Quarterly Results Page
       Reviewed By                          : --
       **/
       @Test(description="Verify the sub-bar in Investors-Quarterly Results Page",groups="Investors")
       public void testInvestorsQuarterlyResultsSubbar(){
       getDriver().get(appConfig.getInvestorUrl());
       dynamicWait.get().waittillpageloads();
       userActions.get().clickOn("Investors_FinancialInfo_Tab");
       verify.get().isElementPresent("title_Licensing");
    //verify the presence of breadcrumb
       businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "Investors_QuarterlyResults_breadcrumb", "Tag_Anchors");
       verify.get().isElementPresent("Subbar_QR");
       verify.get().isElementPresent("Subbar_AR");
       verify.get().isElementPresent("Subbar_SEC");
       verify.get().isElementPresent("Subbar");
    verify.get().isElementPresent("InvestorContactWidget");
       }

       /**
       Author Name                          : Aishwarya
       Date of Preparation                  : 5//13/2015
       Date of Modified                     : --
       Methods Called                       : 
       Purpose of Method                    :Verify whether the selected year news are displayed when clicked on the year from drop down-financial Info
       Reviewed By                          : --
       **/
       @Test(description="Verify whether the selected year news are displayed when clicked on the year from drop down",groups="Investors")
       public void testInvestorsAnnualReportsYear()
       {
       getDriver().get(appConfig.getInvestorUrl());
       dynamicWait.get().waittillpageloads();
       userActions.get().hoverOn("Investors_FinancialInfo_Tab");
       userActions.get().clickOn("Subbar_AR");
       //verify the heading
       verify.get().isElementPresent("AR_Tilte");
       //Click on the year drop down
    userActions.get().clickOn("Year");
    businessFunction.get().checkToggleMenuArrows("Year", "NewsRoom_SelectRangeExpected", "up");
    //select 2012
    userActions.get().clickOn("NewsRoom_SelectRange_2011");
    //verify the results
    verify.get().isElementPresent("SelectedYearList_Licensing_Annual");
    verify.get().isElementPresent("Licensing_ReportList");

       }
       /**
       Author Name                          : Aishwarya
       Date of Preparation                  : 5//14/2015
       Date of Modified                     : --
       Methods Called                       : 
       Purpose of Method                    :Verify the content in Investors-Annual Results Page
       Reviewed By                          : --
       **/
@Test(description="Verify the content in Investors-Annual Results Page",groups="Investors")
public void testInvestorsAnnualResultsContent(){
       getDriver().get(appConfig.getInvestorUrl());
       dynamicWait.get().waittillpageloads();
       userActions.get().hoverOn("Investors_FinancialInfo_Tab");
       userActions.get().clickOn("Subbar_AR");
       //verify the heading
       verify.get().isElementPresent("AR_Tilte");
       //verify the presence of breadcrumb
       businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "Investors_AnnualResults_breadcrumb", "Tag_Anchors");
    //chat option should not be present
       verify.get().isElementNotPresent("ChatPOPUP");
       //verify the presence of investors heading
       verify.get().isElementPresent("Investors_Heading");
       verify.get().isElementPresent("Investors_Overview_Tab");
       verify.get().isElementPresent("Investors_NewsEvents_Tab");
       verify.get().isElementPresent("Investors_FinancialInfo_Tab");
       verify.get().isElementPresent("Investors_CorporateGovernance_Tab");
       //verify the presence of Global Header
       verify.get().isElementPresent("Global_Header");
       //Verify the presence of Global Footer
       verify.get().isElementPresent("Global_Footer");
       }

/**
Author Name                          : Aishwarya
Date of Preparation                  : 5//14/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    :Verify the sub-bar in Annual Results Page
Reviewed By                          : --
**/
@Test(description="Verify the sub-bar in Annual Results Page",groups="Investors")
public void testInvestorsAnnualReportsSubbar(){
       getDriver().get(appConfig.getInvestorUrl());
       dynamicWait.get().waittillpageloads();
       userActions.get().hoverOn("Investors_FinancialInfo_Tab");
       userActions.get().clickOn("Subbar_AR");
       //verify the heading
       verify.get().isElementPresent("AR_Tilte");
    //verify the presence of breadcrumb
       businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "Investors_AnnualResults_breadcrumb", "Tag_Anchors");
       verify.get().isElementPresent("Subbar_QR");
       verify.get().isElementPresent("Subbar_AR");
       verify.get().isElementPresent("Subbar_SEC");
       verify.get().isElementPresent("Subbar");
    verify.get().isElementPresent("InvestorContactWidget");
       }
/**
Author Name                          : Aishwarya
Date of Preparation                  : 5//14/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    :Verify the content present in SEC Filings page
Reviewed By                          : --
**/
@Test(description="Verify the content present in SEC Filings page ",groups="Investors")
public void testInvestorSECFilings()
{
       getDriver().get(appConfig.getInvestorUrl());
       dynamicWait.get().waittillpageloads();
       userActions.get().hoverOn("Investors_FinancialInfo_Tab");
       userActions.get().clickOn("Subbar_SEC");
       //verify the heading
       verify.get().isElementPresent("SEC_Title");
       verify.get().isElementPresent("SEC_Subheader");
       verify.get().isElementPresent("SEC_Subheader_Date");
       verify.get().isElementPresent("SEC_Subheader_type");
       verify.get().isElementPresent("SEC_Subheader_description");
       verify.get().isElementPresent("SEC_Subheader_view");
       verify.get().isElementPresent("SEC_Dropdown");
}
/**
Author Name                          : Aishwarya
Date of Preparation                  : 5//14/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    :verify the pagination functionality in sec filings page
Reviewed By                          : --
**/
@Test(description="verify the pagination functionality in sec filings page",groups="Investors")
public void testInvestorSECFilingsPagination()
{
       getDriver().get(appConfig.getInvestorUrl());
       dynamicWait.get().waittillpageloads();
       userActions.get().hoverOn("Investors_FinancialInfo_Tab");
       userActions.get().clickOn("Subbar_SEC");
       //verify the heading
       verify.get().isElementPresent("SEC_Title");
       verify.get().isElementPresent("SEC_Subheader");
       userActions.get().clickOn("SEC_Next");
       verify.get().isElementPresent("SEC_Subheader_Date");
       verify.get().isElementPresent("SEC_Subheader_type");
       verify.get().isElementPresent("SEC_Subheader_description");
       verify.get().isElementPresent("SEC_Subheader_view");
       userActions.get().clickOn("SEC_Prev");
       verify.get().isElementPresent("SEC_Subheader_Date");
       verify.get().isElementPresent("SEC_Subheader_type");
       verify.get().isElementPresent("SEC_Subheader_description");
       verify.get().isElementPresent("SEC_Subheader_view");
       verify.get().isElementPresent("InvestorContactWidget");
}
/**
Author Name                          : Aishwarya
Date of Preparation                  : 5//14/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    :Verify the content in Events and Presentations page
Reviewed By                          : --
**/
@Test(description="Verify the content in Events and Presentations page",groups="Investors")
public void testInvestorEventsandPresentationContent()
{
       getDriver().get(appConfig.getInvestorUrl());
       dynamicWait.get().waittillpageloads();
       userActions.get().clickOn("Investors_NewsEvents_Tab");
       //verify the heading
       verify.get().isElementPresent("News_EventsPresentation_Title");
       businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "News_EventsPresentation_BreadCrumb", "Tag_Anchors");
       verify.get().isElementPresent("News_PressRelease");
       verify.get().isElementPresent("News_EventsPresentation");
       verify.get().isElementPresent("Subbar");
    verify.get().isElementPresent("InvestorContactWidget");
       
}
/**
Author Name                          : Aishwarya
Date of Preparation                  : 5//14/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    :Verify the page content
Reviewed By                          : --
**/
@Test(description="Verify the page content",groups="Investors")
public void testInvestorEventsandPresentation()
{
       getDriver().get(appConfig.getInvestorUrl());
       dynamicWait.get().waittillpageloads();
       userActions.get().clickOn("Investors_NewsEvents_Tab");
       //verify the heading
       verify.get().isElementPresent("News_EventsPresentation_Title");
       businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "News_EventsPresentation_BreadCrumb", "Tag_Anchors");
       verify.get().isElementPresent("EventsPresentation_Image");
       verify.get().isElementPresent("Upcoming_Title");
       verify.get().isElementPresent("UpcomingEvents_Box");
       verify.get().isElementPresent("AddToCalendar");
       verify.get().isElementPresent("ViewRelatedArticle");
       verify.get().isElementPresent("Date_UpcomingEventsBox");

       
}




/**
Author Name                          : Aishwarya
Date of Preparation                  : 5//14/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    :Verify whether the selected year news are displayed when clicked on the year from drop down
Reviewed By                          : --
**/

@Test(description="Verify whether the selected year news are displayed when clicked on the year from drop down",groups="Investors")
public void testInvestorsPressReleaseYear()
{
       getDriver().get(appConfig.getInvestorUrl());
       dynamicWait.get().waittillpageloads();
       userActions.get().hoverOn("Investors_NewsEvents_Tab");
       userActions.get().clickOn("PressRelease_Subbar");
       //verify the heading
       verify.get().isElementPresent("PR_Title");
    userActions.get().clickOn("Category");
    userActions.get().clickOn("Category_Others");
    dynamicWait.get().waittillpageloads();
    dynamicWait.get().waittillpageloads();
    userActions.get().clickOn("Range");
     userActions.get().clickOn("Range_2011");
    verify.get().isElementPresent("Range_Results");
    verify.get().isElementPresent("Show");
   userActions.get().clickOn("Pagination_2");
   verify.get().isElementPresent("Range_Results");

}
/**
Author Name                          : Aishwarya
Date of Preparation                  : 5//14/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    :Verify the content in Investors-Press Release Page
Reviewed By                          : --
**/
@Test(description="Verify the content in Investors-Press Release Page",groups="Investors")
public void testInvestorsPressReleaseContent(){
       getDriver().get(appConfig.getInvestorUrl());
       dynamicWait.get().waittillpageloads();
       userActions.get().hoverOn("Investors_NewsEvents_Tab");
       userActions.get().clickOn("PressRelease_Subbar");
       //verify the heading
       verify.get().isElementPresent("PR_Title");
       //verify the presence of breadcrumb
       businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "PR_BreadCrumb", "Tag_Anchors");
    //chat option should not be present
       verify.get().isElementNotPresent("ChatPOPUP");
       //verify the presence of investors heading
       verify.get().isElementPresent("Investors_Heading");
       verify.get().isElementPresent("Investors_Overview_Tab");
       verify.get().isElementPresent("Investors_NewsEvents_Tab");
       verify.get().isElementPresent("Investors_FinancialInfo_Tab");
       verify.get().isElementPresent("Investors_CorporateGovernance_Tab");
       //verify the presence of Global Header
       verify.get().isElementPresent("Global_Header");
       //Verify the presence of Global Footer
       verify.get().isElementPresent("Global_Footer");
       }

/**
Author Name                          : Aishwarya
Date of Preparation                  : 5//14/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    :Verify the sub-bar in Press Release Page
Reviewed By                          : --
**/
@Test(description="Verify the sub-bar in Press Release Page",groups="Investors")
public void testInvestorsPressReleaseSubbar(){
       getDriver().get(appConfig.getInvestorUrl());
       dynamicWait.get().waittillpageloads();
       userActions.get().hoverOn("Investors_NewsEvents_Tab");
       userActions.get().clickOn("PressRelease_Subbar");
       //verify the heading
       verify.get().isElementPresent("PR_Title");
       //verify the presence of breadcrumb
       businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "PR_BreadCrumb", "Tag_Anchors");
       verify.get().isElementPresent("PressRelease_Subbar");
       verify.get().isElementPresent("News_EventsPresentation");
       
       verify.get().isElementPresent("Subbar");
    verify.get().isElementPresent("InvestorContactWidget");
    verify.get().isElementPresent("EmailAlert");
       }

// Sponsorship Scripts- Start 
/**
Author Name                          : Dhana Lakshmi
Date of Preparation                  : 18/05/2015
Date of Modified                     : --
Methods Called                       : verifyImageAndIndicatorButtonsCount(String imageParentControl, String indicatorParentControl)
Purpose of Method                    : Verify whether count of indicator buttons is equal to count of images
Reviewed By                          : --
**/ 

@Test(description="Verify the Clickable indicator displayed for # of "
		+ "banners in Sponsorship Landing Page",groups="Sponsorship")
public void testSponsorshipNumberOfIndicatorButtons()
{
	getDriver().get(appConfig.getSponsorshipUrl());
	dynamicWait.get().waittillpageloads();
	//Verify the number of clickable indicator buttons displayed for # of banners
	businessFunction.get().verifyImageAndIndicatorButtonsCount("Sponsorship_CarousalImages", 
			"Sponsorship_IndicatorButtons");
	
}

/**
Author Name                          : Dhana Lakshmi
Date of Preparation                  : 18/05/2015
Date of Modified                     : --
Methods Called                       : verifyImageCarousel(String childCarouselImages)
Purpose of Method                    : Verify Banner Rotation in Sponsorship Landing Page
Reviewed By                          : --
**/ 
@Test(description="Verify the Banner rotation when images > 1"
		+ " in Sponsorship Landing Page",groups="Sponsorship")
public void testSponsorshipBannerRotation()
{
	getDriver().get(appConfig.getSponsorshipUrl());
	dynamicWait.get().waittillpageloads();
	//Verify banner rotation when more than one image is present
	verify.get().verifyImageCarousel("Sponsorship_CarousalImages");
}

/**
Author Name                          : Dhana Lakshmi
Date of Preparation                  : 19/05/2015
Date of Modified                     : --
Methods Called                       : verifyLinksAndNavigatedUrl(String controlName)
Purpose of Method                    : Verify whether Links provided for Sports, Arts & Entertainment, C-Level Engagements, 
									   Academia, Philanthropy, Sponsorship requests
Reviewed By                          : --
**/ 
@Test(description="Verify the clickable links provided in the Header of "
		+ "Sponsorship Landing Page",groups="Sponsorship")
public void testSponsorshipLandingPageCategoryLinks()
{
	getDriver().get(appConfig.getSponsorshipUrl());
	dynamicWait.get().waittillpageloads();
	//Verify the category links in the header
	businessFunction.get().verifyLinksAndNavigatedUrl("Sponsorship_CategoryLinks");
}

/**
Author Name                          : Dhana Lakshmi
Date of Preparation                  : 19/05/2015
Date of Modified                     : --
Methods Called                       : verifyLinksAndNavigatedUrl(String controlName)
Purpose of Method                    : Verify the red underline on hover
Reviewed By                          : --
**/ 
@Test(description="Verify whether red underline appeared on hovering on category links in the Header of "
		+ "Sponsorship Landing Page",groups="Sponsorship")
public void testSponsorshipLandingPageCategoryLinksColor()
{
	getDriver().get(appConfig.getSponsorshipUrl());
	dynamicWait.get().waittillpageloads();
	// Check whether underline present without hover
	businessFunction.get().checkCssPropertyVerifyingBrowser("Sponsorship_Sports","border-bottom-color","Sponsorship_Sports_IE");
	// Hover on Sports Category link
	userActions.get().hoverOn("Sponsorship_Sports");
	// Check whether red underline displayed on hover
	businessFunction.get().checkCssProperty("Sponsorship_Sports_Hover", "border-bottom-color");
	
}



/**
Author Name                          : Dhana Lakshmi
Date of Preparation                  : 19/05/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify whether User returned to Avaya.com site(click on logo)
Reviewed By                          : --
**/ 
@Test(description="Verify the Avaya Logo in "
		+ "Sponsorship Landing Page",groups="Sponsorship")
public void testSponsorshipLandingPageLogo()
{
	getDriver().get(appConfig.getSponsorshipUrl());
	dynamicWait.get().waittillpageloads();
	//Verify Avaya Sponsorships Logo 
	verify.get().isElementPresent("Sponsorship_AvayaLogo");
	// Click on Avaya Sponsorships Logo
	userActions.get().clickOn("Sponsorship_AvayaLogo");
	//Verify Avaya Sponsorships Logo navigation
	businessFunction.get().checkUrl("Sponsorship_Url", "equal");
	//Verify Avaya.com link in the Header
	verify.get().isElementPresent("Sponsorship_Avaya.com_Link");
	// Verify Avaya.com link is displayed to the right of the page
	businessFunction.get().checkCssProperty("Sponsorship_Avaya.com_Link", "text-align");
	// Click on Avaya.com link
	userActions.get().clickOn("Sponsorship_Avaya.com_Link");
	//Verify Avaya.com link navigation
	businessFunction.get().checkUrl("HomePageUrl_Production", "equal");
	
}

/**
Author Name                          : Dhana Lakshmi
Date of Preparation                  : 19/05/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify whether 4 Sub promos displayed and selectable
Reviewed By                          : --
**/ 
@Test(description="Verify whether 4 Sub promos displayed and selectable "
		+ "in Sponsorship Landing Page",groups="Sponsorship")
public void testSponsorshipSubPromos()
{
	getDriver().get(appConfig.getSponsorshipUrl());
	dynamicWait.get().waittillpageloads();
	// Verify the number of Subpromos displayed
	businessFunction.get().verifyElementsByCount("Sponsorship_SubPromos", 4);
	// Verify whether the subpromos are selectable
	businessFunction.get().verifyLinksAndNavigatedUrl("Sponsorship_SubPromos");
	
}

/**
Author Name                          : Dhana Lakshmi
Date of Preparation                  : 20/05/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify whether Subpromos consists of Image title and sub text
Reviewed By                          : --
**/ 
@Test(description="Verify whether Subpromos consists of Image, title and sub text",groups="Sponsorship")
public void testSponsorshipSubpromosContent()
{
	getDriver().get(appConfig.getSponsorshipUrl());
	dynamicWait.get().waittillpageloads();
	businessFunction.get().deFocus();
	// Verify the content in Subpromos
	businessFunction.get().verifySponsorshipSubPromosContent("Sponsorship_SubPromos");
	
}


/**
Author Name                          : Dhana Lakshmi
Date of Preparation                  : 20/05/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify whether Footer displayed centered in the page
Reviewed By                          : --
**/ 
@Test(description="Verify whether Footer displayed centered in the page",groups="Sponsorship")
public void testSponsorshipPageFooter() 
{
	getDriver().get(appConfig.getSponsorshipUrl());
	dynamicWait.get().waittillpageloads();
	// Verify Footer
	verify.get().isElementDisplayed("Sponsorship_Footer");
	verify.get().isElementDisplayed("Sponsorship_FooterSocialIcons");
	verify.get().isElementDisplayed("Sponsorship_FooterLinks");
	verify.get().isElementDisplayed("Sponsorship_FooterText");
	verify.get().isTextPresent("Sponsorship_FooterText");
	businessFunction.get().checkCssProperty("Sponsorship_Footer", "text-align");
}

/**
Author Name                          : Dhana Lakshmi
Date of Preparation                  : 20/05/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify whether Valid links provided for Facebook, Twitter, YouTube, 
									   LinkedIn, Google+, Pinterest are provided
Reviewed By                          : --
**/
@Test(description="Verify whether valid links are provided for "
		+ "Facebook, Twitter, YouTube, LinkedIn, Google+, Pinterest in Footer",groups="Sponsorship")
public void testSponsorshipFooterSocialicons() 
{
	getDriver().get(appConfig.getSponsorshipUrl());
	dynamicWait.get().waittillpageloads();
	businessFunction.get().deFocus();
	// Verify the Social icons in footer
	businessFunction.get().socialIcons("Sponsorship_FooterSocialIcons","Tag_Anchors","href");
}

/**
Author Name                          : Dhana Lakshmi
Date of Preparation                  : 21/05/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify whether Valid links provided for All rights reserved, Location, 
									   Terms of Use, Privacy Policy, Cookies are provided
Reviewed By                          : --
**/
@Test(description="Verify whether Valid links Terms of Use, Privacy Policy and Cookies in Footer",groups="Sponsorship")
public void testSponsorshipFooterLinks() 
{
	getDriver().get(appConfig.getSponsorshipUrl());
	dynamicWait.get().waittillpageloads();
	businessFunction.get().deFocus();
	// Verify the text of Footer links.
	businessFunction.get().verifySubMenuElements("Sponsorship_FooterLinks","Tag_Anchors",",");
	// Click on Terms of Use and Verify Navigation
	businessFunction.get().clickAndVerifyNavigationToChildWindow("Sponsorship_FooterLinks_TermsOfUse", "TermsOfUseHeader");
	// Click on Privacy policy and Verify Navigation
	businessFunction.get().clickAndVerifyNavigationToChildWindow("Sponsorship_FooterLinks_PrivacyPolicy", "Privacy_Description");
	// Click on Cookies and Verify Navigation
	businessFunction.get().clickAndVerifyNavigationToChildWindow("Sponsorship_FooterLinks_Cookies", "Cookies_Description");
	
}

/**
Author Name                          : Dhana Lakshmi
Date of Preparation                  : 21/05/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify whether One banner per Sponsorship SubLanding page displayed
Reviewed By                          : --
**/
@Test(description="Verify whether One banner per detail page is displayed",groups="Sponsorship")
public void testSponsorshipSubLandingPages() 
{
	getDriver().get(appConfig.getSponsorshipUrl());
	dynamicWait.get().waittillpageloads();
	// Navigate to Sports page and verify the banner
	businessFunction.get().verifySponsorshipSubLandingPageBanner("Sponsorship_Sports", "Sponsorship_SubLanding_Banner");
	// Navigate to Sports page and verify the banner
	businessFunction.get().verifySponsorshipSubLandingPageBanner("Sponsorship_Arts & Entertainment", "Sponsorship_SubLanding_Banner");
	// Navigate to Sports page and verify the banner
	businessFunction.get().verifySponsorshipSubLandingPageBanner("Sponsorship_C-Level Engagements", "Sponsorship_SubLanding_Banner");
	// Navigate to Sports page and verify the banner
	businessFunction.get().verifySponsorshipSubLandingPageBanner("Sponsorship_Academia", "Sponsorship_SubLanding_Banner");
	// Navigate to Sports page and verify the banner
	businessFunction.get().verifySponsorshipSubLandingPageBanner("Sponsorship_Philanthropy", "Sponsorship_SubLanding_Banner");
	// Navigate to Sports page and verify the banner
	businessFunction.get().verifySponsorshipSubLandingPageBanner("Sponsorship_SponsorshipRequests", "Sponsorship_SubLanding_Banner");

}

/**
Author Name                          : Dhana Lakshmi
Date of Preparation                  : 22/05/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify whether dynamic fields (interest and location) not displayed for categories 
									   other than sports and arts & entertainment
Reviewed By                          : --
**/
@Test(description=" Verify whether dynamic fields (interest and location) not displayed for categories "
		+ "other than sports and arts & entertainment",groups="Sponsorship")
public void testSponsorshipRequestsFormDynamicFields() 
{
	getDriver().get(appConfig.getSponsorshipUrl());
	dynamicWait.get().waittillpageloads();
	// Click on Sponsorship Requests link
	userActions.get().clickOn("Sponsorship_SponsorshipRequests");
	dynamicWait.get().waittillpageloads();
	// Click on Continue button 
	businessFunction.get().deFocus();
	userActions.get().clickOn("SponsorshipRequests_Continue");
	dynamicWait.get().waittillpageloads();
	// Select Sports category and check whether dynamic fields appeared
	userActions.get().SelectByText("SponsorshipForm_Category", "Sports");
	//Verify the display of dynamic labels
	verify.get().isElementDisplayed("SponsorshipForm_DynamicLabels");
	//Select Sports category and check whether dynamic fields appeared
	userActions.get().SelectByText("SponsorshipForm_Category", "Academia");
	//Verify the display of dynamic labels
	verify.get().isElementNotDisplayed("SponsorshipForm_DynamicLabels");
	//Select Arts & Entertainment category and check whether dynamic fields appeared
	userActions.get().SelectByText("SponsorshipForm_Category", "Arts and Entertainment");
	//Verify the display of dynamic labels
	verify.get().isElementDisplayed("SponsorshipForm_DynamicLabels");
	
}

/**
Author Name                          : Dhana Lakshmi
Date of Preparation                  : 22/05/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify whether date, company, contact name,phone, email, category, impressions, cost displayed
Reviewed By                          : --
**/
@Test(description="Verify whether date, company, contact name,phone, email, category,"
		+ " impressions, cost displayed",groups="Sponsorship")
public void testSponsorshipRequestsFormlabels() 
{
	getDriver().get(appConfig.getSponsorshipUrl());
	dynamicWait.get().waittillpageloads();
	// Click on Sponsorship Requests link
	userActions.get().clickOn("Sponsorship_SponsorshipRequests");
	dynamicWait.get().waittillpageloads();
	// Click on Continue button 
	businessFunction.get().deFocus();
	userActions.get().clickOn("SponsorshipRequests_Continue");
	dynamicWait.get().waittillpageloads();
	// Verify the form visible elements
	verify.get().isElementDisplayed("SponsorshipForm_Company");
	verify.get().isElementDisplayed("SponsorshipForm_ContactName");
	verify.get().isElementDisplayed("SponsorshipForm_Phone");
	verify.get().isElementDisplayed("SponsorshipForm_Email");
	verify.get().isElementDisplayed("SponsorshipForm_Category");
	verify.get().isElementDisplayed("SponsorshipForm_Impressions");
	verify.get().isElementDisplayed("SponsorshipForm_Cost");
	verify.get().isElementDisplayed("SponsorshipForm_Description");	
	// Verify the visible labels 
	// businessFunction.get().verifySubMenuElements("Sponsorship_Form", "SponsorshipForm_VisibleLabels", ",");
				
}

/**
Author Name                          : Dhana Lakshmi
Date of Preparation                  : 25/05/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify whether required field error message displayed
Reviewed By                          : --
**/
@Test(description="Verify whether required field error message displayed",groups="Sponsorship")
public void testSponsorshipRequestsRequiredFieldErrorMessage() 
{
	
	getDriver().get(appConfig.getSponsorshipUrl());
	dynamicWait.get().waittillpageloads();
	// Click on Sponsorship Requests link
	userActions.get().clickOn("Sponsorship_SponsorshipRequests");
	dynamicWait.get().waittillpageloads();
	// Click on Continue button 
	businessFunction.get().deFocus();
	userActions.get().clickOn("SponsorshipRequests_Continue");
	dynamicWait.get().waittillpageloads();
	// Click on Submit button without entering data
	userActions.get().clickOn("SponsorshipForm_SubmitButton");
	// Verify whether error message is displayed for all the 7 required fields in the form
	businessFunction.get().checkExactCountOfElements("SponsorshipForm_ErrorMessage", "Tag_Span_ContainsText", 7);
}

/**
Author Name                          : Dhana Lakshmi
Date of Preparation                  : 25/05/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify whether entry of non numeric impressions value results in error
Reviewed By                          : --
 
 
**/
@Test(description=" Verify whether entry of non numeric impressions value results in error",groups="Sponsorship")
public void testSponsorshipRequestsInvalidImpressionsErrorMessage()  
{
	
	getDriver().get(appConfig.getSponsorshipUrl());
	dynamicWait.get().waittillpageloads();
	// Click on Sponsorship Requests link
	userActions.get().clickOn("Sponsorship_SponsorshipRequests");
	dynamicWait.get().waittillpageloads();
	// Click on Continue button 
	businessFunction.get().deFocus();
	userActions.get().clickOn("SponsorshipRequests_Continue");
	dynamicWait.get().waittillpageloads();
	// Enter Invalid Impressionsvalue
	userActions.get().enterText("SponsorshipForm_Impressions", "abcd");
	// Click on Submit button
	userActions.get().clickOn("SponsorshipForm_SubmitButton");
	// Verify whether error message is displayed
	verify.get().isTextPresent("SponsorshipForm_MustBeANumber");
	// Verify border color for Impressions text box
	businessFunction.get().checkCssPropertyVerifyingBrowser("SponsorshipForm_Impressions", "border-color", "SponsorshipForm_Impressions_IE");
	
}

/**
Author Name                          : Dhana Lakshmi
Date of Preparation                  : 26/05/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify whether entry of numeric impressions value accepted
Reviewed By                          : --
**/
@Test(description="Verify whether entry of numeric impressions value accepted",groups="Sponsorship")
public void testSponsorshipRequestsValidImpressions() 
{
	
	getDriver().get(appConfig.getSponsorshipUrl());
	dynamicWait.get().waittillpageloads();
	// Click on Sponsorship Requests link
	userActions.get().clickOn("Sponsorship_SponsorshipRequests");
	dynamicWait.get().waittillpageloads();
	// Click on Continue button 
	businessFunction.get().deFocus();
	userActions.get().clickOn("SponsorshipRequests_Continue");
	dynamicWait.get().waittillpageloads();
	// Enter Invalid Impressionsvalue
	userActions.get().enterText("SponsorshipForm_Impressions", "12345");
	// Click on Submit button
	userActions.get().clickOn("SponsorshipForm_SubmitButton");
	// Verify whether error message is displayed
	verify.get().isElementNotDisplayed("SponsorshipForm_MustBeANumber");
	
}

/**
Author Name                          : Dhana Lakshmi
Date of Preparation                  : 26/05/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify whether entry of numeric Cost value accepted
Reviewed By                          : --
**/
@Test(description="Verify whether entry of numeric impressions value accepted",groups="Sponsorship")
public void testSponsorshipRequestsValidCost() 
{
	
	getDriver().get(appConfig.getSponsorshipUrl());
	dynamicWait.get().waittillpageloads();
	// Click on Sponsorship Requests link
	userActions.get().clickOn("Sponsorship_SponsorshipRequests");
	dynamicWait.get().waittillpageloads();
	// Click on Continue button 
	businessFunction.get().deFocus();
	userActions.get().clickOn("SponsorshipRequests_Continue");
	dynamicWait.get().waittillpageloads();
	// Enter Invalid Impressionsvalue
	userActions.get().enterText("SponsorshipForm_Cost", "12345");
	// Click on Submit button
	userActions.get().clickOn("SponsorshipForm_SubmitButton");
	// Verify whether error message is displayed
	businessFunction.get().checkCssPropertyVerifyingBrowser("SponsorshipForm_Cost", "border-color", "SponsorshipForm_Cost_IE");		
}
/**
Author Name                          : Dhana Lakshmi
Date of Preparation                  : 26/05/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify whether entry of non numeric phone number results in error
Reviewed By                          : --
 
 
**/
@Test(description=" Verify whether entry of non numeric phone number results in error",groups="Sponsorship")
public void testSponsorshipRequestsInvalidPhoneErrorMessage()  
{
	getDriver().get(appConfig.getSponsorshipUrl());
	dynamicWait.get().waittillpageloads();
	// Click on Sponsorship Requests link
	userActions.get().clickOn("Sponsorship_SponsorshipRequests");
	dynamicWait.get().waittillpageloads();
	// Click on Continue button 
	businessFunction.get().deFocus();
	userActions.get().clickOn("SponsorshipRequests_Continue");
	dynamicWait.get().waittillpageloads();
	// Enter Invalid Phone Number
	userActions.get().enterText("SponsorshipForm_Phone", "abcd");
	// Click on Submit button
	userActions.get().clickOn("SponsorshipForm_SubmitButton");
	// Verify whether error message is displayed
	verify.get().isTextPresent("SponsorshipForm_Phone_MustBeANumber");
}

/**
Author Name                          : Dhana Lakshmi
Date of Preparation                  : 27/05/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify whether entry of numeric phone number accepted
Reviewed By                          : --
**/
@Test(description="Verify whether entry of numeric phone number accepted",groups="Sponsorship")
public void testSponsorshipRequestsValidPhoneNumber() 
{
	getDriver().get(appConfig.getSponsorshipUrl());
	dynamicWait.get().waittillpageloads();
	// Click on Sponsorship Requests link
	userActions.get().clickOn("Sponsorship_SponsorshipRequests");
	dynamicWait.get().waittillpageloads();
	// Click on Continue button 
	businessFunction.get().deFocus();
	userActions.get().clickOn("SponsorshipRequests_Continue");
	dynamicWait.get().waittillpageloads();
	// Enter Invalid Phone Number
	userActions.get().enterText("SponsorshipForm_Phone", "8957562426");
	// Click on Submit button
	userActions.get().clickOn("SponsorshipForm_SubmitButton");
	dynamicWait.get().waitforPresenceOfElementLocated("SponsorshipForm_Phone_MustBeANumber");
	// Verify whether error message is displayed
	verify.get().isElementNotDisplayed("SponsorshipForm_Phone_MustBeANumber");
}

/**
Author Name                          : Dhana Lakshmi
Date of Preparation                  : 27/05/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify whether entry of email in format other than test@example.com results in error message
Reviewed By                          : --
**/
@Test(description="Verify whether entry of email in format other than "
		+ "test@example.com results in error message",groups="Sponsorship")
public void testSponsorshipRequestsInvalidEmailErrorMessage() 
{
	getDriver().get(appConfig.getSponsorshipUrl());
	dynamicWait.get().waittillpageloads();
	// Click on Sponsorship Requests link
	userActions.get().clickOn("Sponsorship_SponsorshipRequests");
	dynamicWait.get().waittillpageloads();
	// Click on Continue button 
	businessFunction.get().deFocus();
	userActions.get().clickOn("SponsorshipRequests_Continue");
	dynamicWait.get().waittillpageloads();
	// Enter Invalid Email
	businessFunction.get().sponsorshipFormEmailValidation("abc&gmail.com", "invalid");
	businessFunction.get().sponsorshipFormEmailValidation("abc@gmail", "invalid");
}

/**
Author Name                          : Dhana Lakshmi
Date of Preparation                  : 27/05/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify whether entry of email in format test@example.com accepted
Reviewed By                          : --
**/
@Test(description="Verify whether entry of email in format test@example.com accepted",groups="Sponsorship")
public void testSponsorshipRequestsValidEmail() 
{
	getDriver().get(appConfig.getSponsorshipUrl());
	dynamicWait.get().waittillpageloads();
	// Click on Sponsorship Requests link
	userActions.get().clickOn("Sponsorship_SponsorshipRequests");
	dynamicWait.get().waittillpageloads();
	// Click on Continue button 
	businessFunction.get().deFocus();
	userActions.get().clickOn("SponsorshipRequests_Continue");
	dynamicWait.get().waittillpageloads();
	// Enter Invalid Email
	businessFunction.get().sponsorshipFormEmailValidation("abc@gmail.com", "valid");
	
}

/**
Author Name                          : Dhana Lakshmi
Date of Preparation                  : 28/05/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify whether Thank you message displayed and re-directed to home page
Reviewed By                          : --
 
**/
@Test(description="Verify whether Thank you message displayed and re-directed to home page",groups="Sponsorship")
public void testSponsorshipRequestsValidData() 
{
	getDriver().get(appConfig.getSponsorshipUrl());
	dynamicWait.get().waittillpageloads();
	// Click on Sponsorship Requests link
	userActions.get().clickOn("Sponsorship_SponsorshipRequests");
	dynamicWait.get().waittillpageloads();
	// Click on Continue button 
	businessFunction.get().deFocus();
	userActions.get().clickOn("SponsorshipRequests_Continue");
	dynamicWait.get().waittillpageloads();
	// Enter Valid Data in form
	businessFunction.get().sendinputdata("SponsorshipForm_ValidData", "sponsorshiprequest", "none");
	businessFunction.get().deFocus();
	// Click on Submit button
	userActions.get().clickOn("SponsorshipForm_SubmitButton");
	//dynamicWait.get().waitforvisibilityOfElementLocated("ThankYou_PopUp");
	// Verify whether Tahnk You message displayed
	/*userActions.get().switchToFrame("ThankYou_PopUpFrame");
	verify.get().isElementPresent("ThankYou_PopUp");*/
	// Verify Page redirect
	try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	dynamicWait.get().waittillpageloads();
	businessFunction.get().checkUrl("SponsorshipUrl_Production", "equal");
}

/**
Author Name                          : Dhana Lakshmi
Date of Preparation                  : 28/05/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify whether Twitter widget displayed and showing feed
Reviewed By                          : --
**/
@Test(description="Twitter widget displayed and showing feed",groups="Sponsorship")
public void testSponsorshipSubLandingTwitterWidget() 
{
	getDriver().get(appConfig.getSponsorshipUrl());
	dynamicWait.get().waittillpageloads();
	// Click on Sports link in the Header
	userActions.get().clickOn("Sponsorship_Sports");
	// Verify the presence of Twitter Widget
	verify.get().isElementPresent("TwitterWidget");
	businessFunction.get().verifyTwitterTout();
	
}

/**
Author Name                          : Dhana Lakshmi
Date of Preparation                  : 03/06/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the presence of title in detail Page
Reviewed By                          : --
**/

@Test(description="Verify the title in detail Page",groups="Sponsorship")
public void testSponsorshipDetailPageTitle() 
{
	getDriver().get(appConfig.getSponsorshipUrl());
	dynamicWait.get().waittillpageloads();
	// Click on a SubPromo
	userActions.get().clickOn("Sponsorship_SubPromos");
	dynamicWait.get().waittillpageloads();
	// Verify whether Heading is displayed
	verify.get().isElementDisplayed("SponsorshipDetail_Heading");
}

/**
Author Name                          : Dhana Lakshmi
Date of Preparation                  : 03/06/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the Title color in Detail Page
Reviewed By                          : --
**/

@Test(description="Verify the Title color in Detail Page",groups="Sponsorship")
public void testSponsorshipDetailPageTitleColor() 
{
	getDriver().get(appConfig.getSponsorshipUrl());
	dynamicWait.get().waittillpageloads();
	// Click on a SubPromo
	userActions.get().clickOn("Sponsorship_SubPromos");
	dynamicWait.get().waittillpageloads();
	// Verify whether Heading is displayed
	businessFunction.get().checkCssProperty("SponsorshipDetail_Heading", "color");
}

/**
Author Name                          : Dhana Lakshmi
Date of Preparation                  : 03/06/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the Text in Detail Page
Reviewed By                          : --
**/

@Test(description="Verify the Text in Detail Page",groups="Sponsorship")
public void testSponsorshipDetailPageText() 
{
	getDriver().get(appConfig.getSponsorshipUrl());
	dynamicWait.get().waittillpageloads();
	// Click on a SubPromo
	userActions.get().clickOn("Sponsorship_SubPromos");
	dynamicWait.get().waittillpageloads();
	// Verify whether text is present
	verify.get().isElementDisplayed("SponsorshipDetail_Text");
}

/**
Author Name                          : Dhana Lakshmi
Date of Preparation                  : 03/06/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the Previous , Next Links in Detail Page
Reviewed By                          : --
**/
@Test(description="Verify the Previous , Next Links in Detail Page",groups="Sponsorship")
public void testSponsorshipDetailPageLinks() 
{

	getDriver().get(appConfig.getSponsorshipUrl());
	dynamicWait.get().waittillpageloads();
	// Click on a SubPromo
	userActions.get().clickOn("Sponsorship_SubPromos");
	dynamicWait.get().waittillpageloads();
	// Verify whether the Next and Previous links are displayed
	verify.get().isElementDisplayed("Sponsorship_PreviousLink");
	verify.get().isElementDisplayed("Sponsorship_NextLink");
	// Verify the color on hover
	businessFunction.get().checkCssColorOnHover("Sponsorship_PreviousLink");
	businessFunction.get().checkCssColorOnHover("Sponsorship_NextLink");
}


/**
Author Name                          : Dhana Lakshmi
Date of Preparation                  : 28/05/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify Content in Sponsorship detail Pages
Reviewed By                          : --
**/
@Test(description="Verify Content in Sponsorship detail Pages",groups="Sponsorship")
public void testSponsorshipDetailContent() 
{
	getDriver().get(appConfig.getSponsorshipUrl());
	dynamicWait.get().waittillpageloads();
	// Click on Sports link in the Header
	userActions.get().clickOn("Sponsorship_Sports");
	// Verify Content in Sports Detail Page
	businessFunction.get().verifySponsorshipDetailContent("Sponsorship_DetailContent", "Sponsorship_NextLink");
	// Click on Arts & Entertainment link 
	userActions.get().clickOn("Sponsorship_Arts & Entertainment");
	// Verify Content
	businessFunction.get().verifySponsorshipDetailContent("Sponsorship_DetailContent1", "Sponsorship_NextLink");
	// Click on C-Level Engagements link
	userActions.get().clickOn("Sponsorship_C-Level Engagements");
	// Verify Content
	businessFunction.get().verifySponsorshipDetailContent("Sponsorship_DetailContent1", "Sponsorship_NextLink");
	// Click on C-Level Engagements link
	userActions.get().clickOn("Sponsorship_Academia");
	// Verify Content
	businessFunction.get().verifySponsorshipDetailContent("Sponsorship_DetailContent1", "Sponsorship_NextLink");
	// Click on C-Level Engagements link
	userActions.get().clickOn("Sponsorship_Philanthropy");
	// Verify Content
	businessFunction.get().verifySponsorshipDetailContent("Sponsorship_DetailContent", "Sponsorship_NextLink");
}

/**
Author Name                          : Dhana Lakshmi
Date of Preparation                  : 29/05/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify whether Twitter widget displayed and showing feed in detail Pages
Reviewed By                          : --
**/
@Test(description="Verify whether Twitter widget displayed and showing feed",groups="Sponsorship")
public void testSponsorshipDetailTwitterWidget() 
{
	getDriver().get(appConfig.getSponsorshipUrl());
	dynamicWait.get().waittillpageloads();
	// Verify Twitter Widget in Sports Detail Pages
	businessFunction.get().verifySponsorshipDetailTwitterWidget("Sponsorship_Sports", "Sponsorship_DetailContent");
	// Verify Twitter Widget in Arts & Entertainment Detail Pages
	businessFunction.get().verifySponsorshipDetailTwitterWidget("Sponsorship_Arts & Entertainment", "Sponsorship_DetailContent1");
	// Verify Twitter Widget in C-Level Engagements Detail Pages
	businessFunction.get().verifySponsorshipDetailTwitterWidget("Sponsorship_C-Level Engagements", "Sponsorship_DetailContent1");
	// Verify Twitter Widget in Academia Detail Pages
	businessFunction.get().verifySponsorshipDetailTwitterWidget("Sponsorship_Academia", "Sponsorship_DetailContent1");
	// Verify Twitter Widget in Philanthropy Detail Pages
	businessFunction.get().verifySponsorshipDetailTwitterWidget("Sponsorship_Philanthropy", "Sponsorship_DetailContent");
	
}

//Sponsorship Scripts- End

/**
Author Name                          : Dhana Lakshmi
Date of Preparation                  : 03/06/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the date in Perspectives Landing Page
Reviewed By                          : --
**/
@Test(description="Verify the date in Perspectives Landing Page",groups="Perspectives")
public void testPerspectivesArticleDate() 
{
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	//Click on 'Perspectives' tab of mega menu. and System should navigate to Perspectives Landing Page with All tab contents displayed by default.
	businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "Perspectives_SubMenu", "PerspectivesTitlePage");
	businessFunction.get().deFocus();
	// Click on Load more articles link
	userActions.get().clickOn("Loadmorearticles");
	businessFunction.get().verifyPerspectivesArticleDate("Perspectives_ArticlesDetails");
}

/**
Author Name                          : Dhana Lakshmi
Date of Preparation                  : 03/06/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the Article date in Perspectives Detail Page
Reviewed By                          : --
**/
@Test(description="Verify the Article date in Perspectives Detail Page",groups="Perspectives")
public void testPerspectivesDetailPageArticleDate() 
{
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	//Click on 'Perspectives' tab of mega menu. and System should navigate to Perspectives Landing Page with All tab contents displayed by default.
	businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "Perspectives_SubMenu", "PerspectivesTitlePage");
	businessFunction.get().deFocus();
	// Click on an Article Title
	userActions.get().clickOn("Perspectives_article");
	// Verify the presence of Article Date
	//businessFunction.get().verifyPerspectivesArticleDate("Perspectives_ArticlesDetails");
	verify.get().verifyElementContainsText("PublishedDateClass", "Perspectives_DateText");
}
//Video Potal - start of scripts

/**
Author Name                          : Dhana Lakshmi
Date of Preparation                  : 29/06/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the Header, Footer and Page Title of Video Portal Page
Reviewed By                          : --
**/
@Test(description="Verify the Header, Footer and Page Title of Video Portal Page",groups="VideoPortal")
public void testVideoPortalPage() 
{
	getDriver().get(appConfig.getVideoPortalUrl());
	dynamicWait.get().waittillpageloads();
	// Verify the presence of header 
	businessFunction.get().isElementDisplayed("VideoPotal_Buttlerbar");
	businessFunction.get().isElementDisplayed("VideoPortal_MegaMenuBar");
	// Verify the presence of footer
	businessFunction.get().isElementDisplayed("VideoPortal_NewsBar");
	businessFunction.get().isElementDisplayed("VideoPortal_Quicklinks");
	businessFunction.get().isElementDisplayed("VideoPortal_FooterLinks");
	// Verify the Page title
	businessFunction.get().isElementDisplayed("VideoPortal_PageTitle");
	verify.get().isTextPresent("VideoPortal_PageTitle");
	// Verify the Bread Crumb 
	businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "VideoPortal_BreadCrumb", "Tag_Anchors");
	// Verify whether chat icon is present in the page
	verify.get().isElementNotPresent("ChatIcon");
}

/**
Author Name                          : Dhana Lakshmi
Date of Preparation                  : 29/06/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the Channel Selector dropdown and the results displayed in Video Portal Page
Reviewed By                          : --
**/
@Test(description="Verify the Channel Selector dropdown and the results displayed in Video Portal Page",groups="VideoPortal")
public void testVideoPortalChannelSelector() 
{
	getDriver().get(appConfig.getVideoPortalUrl());
	dynamicWait.get().waittillpageloads();
	// Verify the presence of Channel Selector
	businessFunction.get().isElementDisplayed("VideoPortal_ChannelSelector");
	// Click on the Channel Selector dropdown button
	userActions.get().clickOn("VideoPortal_ChannelSelector");
	// Verify whether the dropdown displayed
	businessFunction.get().isElementDisplayed("VideoPortal_ChannelDropdown");
	// Verify the Videos list under Channel Selector 
	businessFunction.get().checkExactCountOfElements("VideoPortal_VideoList", "Tag_Anchors", 10);
	// Verify the presence of See More link
	businessFunction.get().isElementDisplayed("VideoPortal_SeeMoreLink");
}

/**
Author Name                          : Dhana Lakshmi
Date of Preparation                  : 29/06/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the See More Videos link under the Channel Selector in Video Portal Page
Reviewed By                          : --
**/
@Test(description="Verify the See More Videos link under the Channel Selector in Video Portal Page",groups="VideoPortal")
public void testVideoPortalSeeMoreVideos() 
{
	getDriver().get(appConfig.getVideoPortalUrl());
	dynamicWait.get().waittillpageloads();
	// Click on See More Videos Link
	businessFunction.get().deFocus();
	userActions.get().clickOn("VideoPortal_SeeMoreLink");
	try {
		Thread.sleep(8000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	// Verify whether more than 10 articles are dsiplayed on click of See More Videos link
	businessFunction.get().verifyMinimumCountOfElements("VideoPortal_Videos", 11);
	// Verify whether See More Videos link disappeared
	verify.get().isElementNotDisplayed("VideoPortal_SeeMoreLink");
}


/**
Author Name                          : Dhana Lakshmi
Date of Preparation                  : 29/06/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify whether the main Video is playing in Video Portal Page
Reviewed By                          : --
**/
@Test(description="Verify whether the main Video is playing in Video Portal Page",groups="VideoPortal")
public void testVideoPortalVideoPlay() 
{
	getDriver().get(appConfig.getVideoPortalUrl());
	dynamicWait.get().waittillpageloads();
	// Verify the video in the Kaltura Player
	verify.get().verifyVideo();
	// Click on a Video from the List
	userActions.get().clickOn("VideoPortal_Video");
	dynamicWait.get().waittillpageloads();
	// Verify whether the respective video is played
	verify.get().verifyVideo();
	// Verify whether the Video Title below the Video is changed
	businessFunction.get().compareTextOfTwoElements("VideoPortal_VideoTitle", "VideoPortal_Video_Title");
}

/**
Author Name                          : Dhana Lakshmi
Date of Preparation                  : 29/06/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the Video Information below the main Video in Video Portal Page
Reviewed By                          : --
**/
@Test(description="Verify the Video Information below the main Video in Video Portal Page",groups="VideoPortal")
public void testVideoPortalVideoInformation() 
{
	getDriver().get(appConfig.getVideoPortalUrl());
	dynamicWait.get().waittillpageloads();
	businessFunction.get().isElementDisplayed("VideoPortal_ChannelName");
	businessFunction.get().isElementDisplayed("VideoPortal_VideoTitle");
	businessFunction.get().isElementDisplayed("VideoPortal_VideoSubTitle");
	businessFunction.get().isElementDisplayed("VideoPortal_VideoDescription");
	
}

/**
Author Name                          : Dhana Lakshmi
Date of Preparation                  : 30/06/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the Channel Selector filter functionality in Video Portal Page
Reviewed By                          : --
**/
@Test(description="Verify the Channel Selector filter functionality in Video Portal Page",groups="VideoPortal")
public void testVideoPortalVideoChannel() 
{
	getDriver().get(appConfig.getVideoPortalUrl());
	dynamicWait.get().waittillpageloads();
	// Click on the Channel Selector dropdown button
	userActions.get().clickOn("VideoPortal_ChannelSelector");
	// Hover on a channel in the dropdown
	userActions.get().hoverOn("VideoPortal_ChannelLink");
	// Verify whether it is underlined on hover
	businessFunction.get().checkCssProperty("VideoPortal_ChannelLink", "text-decoration");
	// Click on the channel link
	userActions.get().clickOn("VideoPortal_ChannelLink");
	// Verify results displayed
	businessFunction.get().validateResultsByCheckingValuesInUrl("VideoPortal_VideoList", 
			"Tag_Anchors", "VideoPortal_ChannelLink");
	// Verify whether only 10 results are displayed initially
	businessFunction.get().checkExactCountOfElements("VideoPortal_VideoList", "Tag_Anchors", 10);
}

/**
Author Name                          : Dhana Lakshmi
Date of Preparation                  : 30/06/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the Social Sharing Icons in Video Portal Page
Reviewed By                          : --
**/
@Test(description="Verify the Social Sharing Icons in Video Portal Page",groups="VideoPortal")
public void testVideoPortalSocialSharingIcons() 
{
	getDriver().get(appConfig.getVideoPortalUrl());
	dynamicWait.get().waittillpageloads();
	businessFunction.get().socialIcons("VideoPortal_SocialIcons", "Tag_i", "class");
	// TWITTER validation
	userActions.get().clickOn("VideoPortal_Twitter");
	businessFunction.get().shareArticleInSocialSites("TwitterPlusData", "twitter");
	getDriver().get(appConfig.getTwitterUrl());
	dynamicWait.get().waittillpageloads();
	businessFunction.get().validateSharedArticleInSocialSites("TwitterPlusData", "twitter");
	// FACEBOOK validation
	getDriver().get(appConfig.getVideoPortalUrl());
	dynamicWait.get().waittillpageloads();
	userActions.get().clickOn("VideoPortal_Facebook");
	businessFunction.get().shareArticleInSocialSites("FacebookPlusData", "facebook");
	getDriver().get(appConfig.getFacebookUrl());
	dynamicWait.get().waittillpageloads();
	businessFunction.get().validateSharedArticleInSocialSites("FacebookPlusData", "facebook");
	// LINKEDIN validation
	getDriver().get(appConfig.getVideoPortalUrl());
	dynamicWait.get().waittillpageloads();
	userActions.get().clickOn("VideoPortal_LinkedIn");
	businessFunction.get().shareArticleInSocialSites("LinkedInPlusData", "linkedin");
	getDriver().get(appConfig.getLinkedInUrl());
	dynamicWait.get().waittillpageloads();
	businessFunction.get().validateSharedArticleInSocialSites("LinkedInPlusData", "linkedin");
	// GOOGLE+ validation
	getDriver().get(appConfig.getVideoPortalUrl());
	dynamicWait.get().waittillpageloads();
	userActions.get().clickOn("VideoPortal_Google+");
	businessFunction.get().shareArticleInSocialSites("GooglePlusData", "googleplus");
	getDriver().get(appConfig.getGooglePlusUrl());
	dynamicWait.get().waittillpageloads();
	businessFunction.get().validateSharedArticleInSocialSites("GooglePlusData", "googleplus");
}

/**
Author Name                          : Dhana Lakshmi
Date of Preparation                  : 30/06/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify whether the Video results contain all Title, Description, Thumbnail and Duration
Reviewed By                          : --
**/
@Test(description="Verify whether the Video results contain all Title, Description, Thumbnail and Duration",groups="VideoPortal")
public void testVideoPortalVideoResultContent() 
{
	getDriver().get(appConfig.getVideoPortalUrl());
	dynamicWait.get().waittillpageloads();
	verify.get().isElementDisplayed("VideoResults_Title");
	verify.get().isElementDisplayed("VideoResults_Description");
	verify.get().isElementDisplayed("VideoResults_Duration");
	verify.get().isElementDisplayed("VideoResults_Thumbnail");
}

/**
Author Name                          : Dhana Lakshmi
Date of Preparation                  : 30/06/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the Video Rating in Video Portal Page
Reviewed By                          : --
**/
@Test(description="Verify the Video Rating in Video Portal Page",groups="VideoPortal")
public void testVideoPortalRating() 
{
	getDriver().get(appConfig.getVideoPortalUrl());
	dynamicWait.get().waittillpageloads();
	dynamicWait.get().waitforvisibilityOfElementLocated("VideoPortal_RatingStar");
	// Verify the presence of Video Rating Stars
	businessFunction.get().isElementDisplayed("VideoPortal_Rating");
	// Give rating for the video
	userActions.get().clickOn("VideoPortal_RatingStar");
	try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	// Hover on the Video rating
	userActions.get().hoverOn("VideoPortal_Rating");
	// Verify whether the rating details flyout appeared
	businessFunction.get().isElementDisplayed("VideoPortal_RatingDetails");
	verify.get().isTextPresent("VideoPortal_RatingValue");
	
}
	
	
/*@Test(description="Verify the Channel Selector filter in Video Portal Page",groups="VideoPortal")
public void testVerifyVideoPortalRating(String value) 
{
	getDriver().get(appConfig.getVideoPortalUrl());
	dynamicWait.get().waittillpageloads();
	dynamicWait.get().waitforvisibilityOfElementLocated("VideoPortal_RatingStar");
	// Verify the presence of Video Rating Stars
	businessFunction.get().isElementDisplayed("VideoPortal_Rating");
	// Give rating for the video
	userActions.get().clickOn("VideoPortal_RatingStar");
	try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	// Hover on the Video rating
	userActions.get().hoverOn("VideoPortal_Rating");
	businessFunction.get().checkRatingValue("VideoPortal_RatingValue", value);
	}*/
	
/**
Author Name                          : Dhana Lakshmi
Date of Preparation                  : 30/06/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the Feedback panel in Video Portal Page
Reviewed By                          : --
**/
@Test(description="Verify the Feedback panel in Video Portal Page",groups="VideoPortal")
public void testVideoPortalFeedback() 
{
	
	getDriver().get(appConfig.getVideoPortalUrl());
	dynamicWait.get().waittillpageloads();
	
	//Verify whether the Feedback button is present on the extreme right position on the page or not
	verify.get().isElementDisplayed("HomePage_Feedback");
	//click on Feedback button
	userActions.get().clickOn("HomePage_Feedback");
	dynamicWait.get().waittillpageloads();
	try {
		Thread.sleep(20000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//switch to frame
 userActions.get().switchToFrame("HomePage_Feedback_Frame");
 //Select satisfied radio button
	userActions.get().clickOn("Feedback_Satisfied");
	//enter comments
	userActions.get().enterText("Feedback_text","QA_Test_Automation_Feedback");
	//click on submit button
 userActions.get().clickOn("Feedback_Submit_Button");
 //verify thankyou message
 verify.get().isTextPresent("Thankyou_FeedbackMessage");
 //click in the Close Button
 userActions.get().clickOn("Feedback_CloseButton");
 userActions.get().switchToDefaultContent();
 //verify if feedback widget is closed 
 verify.get().isElementNotDisplayed("HomePage_Feedback_Frame");
}

/**
Author Name                          : Dhana Lakshmi
Date of Preparation                  : 30/06/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the Video Tags functionality in Video Portal Page
Reviewed By                          : --
**/
@Test(description="Verify the Video Tags functionality in Video Portal Page",groups="VideoPortal")
public void testVideoPortalTags() 
{
	getDriver().get(appConfig.getVideoPortalUrl());
	dynamicWait.get().waittillpageloads();
	userActions.get().clickOn("VideoPortal_Video");
	dynamicWait.get().waittillpageloads();
	// Verify the presence of tag links
	verify.get().isElementDisplayed("VideoPortal_Tags");
	// Verify whether tag links are clickable
	userActions.get().clickOn("VideoPortal_Tags");
	// verify the results got filtered 
	businessFunction.get().validateResultsByCheckingValuesInUrl("VideoPortal_VideoList", "Tag_Anchors", "VideoPortal_Tags");
	
}

//Video Portal -Test scripts end

/**
Author Name                          : Dhana Lakshmi
Date of Preparation                  : 13/07/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the Country Selector Dropdown
Reviewed By                          : --
**/
@Test(description="Verify the Country Selector Dropdown",groups="CountrySelector")
public void testCountrySelectorLabel() 
{
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	// Verify whether the country map icon, dropdown arrow, and country label are clickable as one element
	userActions.get().hoverOn("CountrySelector_Label");
	businessFunction.get().checkCssProperty("CountrySelector_Label", "cursor");
	//Click on the Country Selector
	userActions.get().clickOn("CountrySelector_Label");
	// Verify the presence of Country Selector dropdown
	businessFunction.get().isElementDisplayed("CountrySelector_RegionUS");
	businessFunction.get().isElementDisplayed("CountrySelector_RegionEMEA");
	businessFunction.get().isElementDisplayed("CountrySelector_RegionAPAC");
	businessFunction.get().isElementDisplayed("CountrySelector_RegionCALA");
	verify.get().isTextPresent("CountrySelector_DropdownText");
	verify.get().isTextPresent("CountrySelector_WorldwideOffice");
	verify.get().isElementPresent("CountrySelector_WorldwideLinks");
	// Verify whether the selected country is highlighted 
	businessFunction.get().checkCssProperty("CountrySelector_USA", "color");
	// Verify all the links in the dropdown
	//WebElement element=getDriver().findElement(By.className("content"));
	//businessFunction.get().verifyLinks(element);
}
/**
Author Name                          : Dhana Lakshmi
Date of Preparation                  : 13/07/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the Country Selector label for the Selected Country
Reviewed By                          : --
**/
@Test(description="Verify the Country Selector label for the Selected Country",groups="CountrySelector")
public void testCountrySelectorCountryNavigation() 
{
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	// Verify whether the country map icon, dropdown arrow, and country label are clickable as one element
	userActions.get().clickOn("CountrySelector_Label");
	// Verify whether the link turned red and underlined on hover
	userActions.get().hoverOn("CountrySelector_DE");
	businessFunction.get().checkCssProperty("CountrySelector_DE", "color");
	// Click on any one of the country link from the dropdown
	userActions.get().clickOn("CountrySelector_DE");
	dynamicWait.get().waittillpageloads();
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	// Verify whether country selector label is changed from USA to DE label
	verify.get().verifyElementContainsText("CountrySelector_Label", "CountrySelector_DE_Label");
	// Verify whether the selected country link is highlighted
	userActions.get().clickOn("CountrySelector_Label");
	businessFunction.get().checkCssProperty("CountrySelector_DELink", "color");
}

/**
Author Name                          : Dhana Lakshmi
Date of Preparation                  : 13/07/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    :Verify the presence of New Rules of Engagement link and tab under Perspectives
Reviewed By                          : --
**/
@Test(description="Verify the presence of New Rules of Engagement link and tab under Perspectives",groups="NewRulesOfEngagement")
public void testPerspectivesNewRulesOfEngagement() 
{
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	// Click on the SubMenu Item- Perspectives
	businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "Perspectives_SubMenu", "PerspectivesTitlePage");	
	// Verify the presence of New Rules of Engagement Tab
	businessFunction.get().isElementDisplayed("NewRulesOfEngagement_Tab");
	// Click on the Tab and verify navigation
	businessFunction.get().clickAndVerifyNavigation("NewRulesOfEngagement_Tab", "NewRulesOfEngagement_PageTitle");
	// Hover on About Tab in Mega Menu
	userActions.get().hoverOn("MegaMenuAboutAvaya");
	// Verify the presence of New Rules of Engagement link in Mega Menu
	businessFunction.get().isElementDisplayed("NewRulesOfEngagement_Link");
	// Click on the link and Verify navigation
	businessFunction.get().clickAndVerifyNavigation("NewRulesOfEngagement_Link", "NewRulesOfEngagement_PageTitle");	
}

/**
Author Name                          : Dhana Lakshmi
Date of Preparation                  : 14/07/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify New Rules Of Enagagement page
Reviewed By                          : --
**/
@Test(description="Verify New Rules Of Enagagement page",groups="NewRulesOfEngagement")
public void testPerspectivesNewRulesOfEngagementPage() 
{
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	// Navigate to New Rules of Engagement Page
	businessFunction.get().clickOnSubMenuItem("MegaMenuAboutAvaya", "NewRulesOfEngagement_Link", "NewRulesOfEngagement_PageTitle");
	// Verify the Bread Crumb of the Page
	businessFunction.get().verifyBreadCrumb("Breadcrumb_Actual", "NewRulesOfEngagement_BreadCrumb", "Tag_Anchors");
	// Verify whether Overview tab is present
	businessFunction.get().verifySubMenuElements("MeetAvaSubNav", "Tag_Anchors", ",");
	// Verify Header and footer in the page
	verify.get().isElementPresent("Global_Header");
	verify.get().isElementPresent("Global_Footer");
}

/**
Author Name                          : Dhana Lakshmi
Date of Preparation                  : 14/07/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the GSA Search Page
Reviewed By                          : --
**/
@Test(description="Verify the Search Page",groups="GSASearch")
public void testGSASearchPage() 
{
	//Launching the Avaya Website
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	// To enter "Avaya" in the Search Text Box
	businessFunction.get().deFocus();
	userActions.get().enterText("AvayaHome_SearchBox", "Avaya");
	// To click on Search Icon
	userActions.get().clickOn("Search_Button_Test");
	// To check if user is able to view Global results Page
	verify.get().isTextPresent("ResultsPage_Title");
	// To Verify whether Filter is present to the right of the Search results
	businessFunction.get().pageAllignment("ResultDetails", "GSA_Filter", "right");
	// Verify the presence of only two tabs Avaya and Support
	businessFunction.get().verifySubMenuElements("GSA_Tabs", "Tag_Anchors", ",");
	// To Verify the Search Results
	businessFunction.get().searchValidResults("ResultDetails", "Avaya");
	// To Verify the presence of Header and footer in the page
	verify.get().isElementPresent("Global_Header");
	verify.get().isElementPresent("Global_Footer");
	// To Verify the Bread Crumb  of Search Page
	verify.get().isTextPresent("GSA_BreadCrumb");
}

/**
Author Name                          : Dhana Lakshmi
Date of Preparation                  : 14/07/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the Filter functionality in Search Page
Reviewed By                          : --
**/
@Test(description="Verify the Filter functionality in Search Page",groups="GSASearch")
public void testGSASearchPageFilter() 
{
	//Launching the Avaya Website
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	// To enter "Avaya" in the Search Text Box
	businessFunction.get().deFocus();
	userActions.get().enterText("AvayaHome_SearchBox", "Avaya");
	// To click on Search Icon
	userActions.get().clickOn("Search_Button_Test");
	// Verify the Filter Pod arrow before collapse
	businessFunction.get().checkToggleMenuArrows("GSA_Filter_Arrow","Expanded_Arrow","up");
	// Click on the pod bar to collapse
	userActions.get().clickOn("GSA_Filter_Arrow");
	// Verify the Filter Pod arrow after collapse
	businessFunction.get().checkToggleMenuArrows("GSA_Filter_Arrow","Collapsed_Arrow","down");
	// Click again to expand the filter pod
	userActions.get().clickOn("GSA_Filter_Arrow");
	// To Select a filter option and validate the results obtained
	userActions.get().clickOn("FilterProducts");
	dynamicWait.get().waittillpageloads();
	businessFunction.get().validateGSASearchResults("ResultDetails");
}

/**
Author Name                          : Dhana Lakshmi
Date of Preparation                  : 15/07/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the Pagination in Search Page
Reviewed By                          : --
**/
@Test(description="Verify the Pagination in Search Page",groups="GSASearch")
public void testGSASearchPagePagination() 
{
	//Launching the Avaya Website
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	// To enter "Avaya" in the Search Text Box
	businessFunction.get().deFocus();
	userActions.get().enterText("AvayaHome_SearchBox", "Avaya");
	// To click on Search Icon
	userActions.get().clickOn("Search_Button_Test");
	// To verify the number of pages displayed initially
	businessFunction.get().checkExactCountOfElements("GSAPagination_PageNumbers", "Tag_Anchors", 10);
	//Verify the '1' is highlighted in Pagination as its displaying the '1' page
	dynamicWait.get().waittillpageloads();
	verify.get().isElementDisplayed("Pagination_Page1");
	if("chrome".equalsIgnoreCase(threadDriver.get().getCapabilities().getBrowserName())){			
		businessFunction.get().checkCssProperty("Pagination_Page1","font-weight");			
	}else{
		businessFunction.get().checkMultipleCSSProperties("Pagination_Page1Firefox","font-weight");
	}
	//Click on Next link from Pageination
	userActions.get().clickOn("Pagination_Next");
	//Verify its displaying the page 2 and '2' is highlighted in the Pagination displayed
	dynamicWait.get().waittillpageloads();
	businessFunction.get().deFocus();
	verify.get().isElementDisplayed("Pagination_Page2");
	if("chrome".equalsIgnoreCase(threadDriver.get().getCapabilities().getBrowserName())){			
		businessFunction.get().checkMultipleCSSProperties("Pagination_Page2","font-weight");			
	}else{
		businessFunction.get().checkMultipleCSSProperties("Pagination_Page2Firefox","font-weight");
	}
	//Click on Prev Link
	userActions.get().clickOn("Pagination_Prev");
	//Verify its displaying the page 1 and '1' is highlighted in the Pagination displayed
	dynamicWait.get().waittillpageloads();
	verify.get().isElementDisplayed("Pagination_Page1");
	if("chrome".equalsIgnoreCase(threadDriver.get().getCapabilities().getBrowserName())){			
		businessFunction.get().checkMultipleCSSProperties("Pagination_Page1","font-weight");			
	}else{
		businessFunction.get().checkMultipleCSSProperties("Pagination_Page1Firefox","font-weight");
	}
	// To click on Page number 10 and verify the number of new pages dsiplayed
	userActions.get().clickOn("Pagination_Page10");
	dynamicWait.get().waittillpageloads();
	businessFunction.get().verifySubMenuElements("GSAPagination_PageNumbers", "Tag_Anchors", ",");
	// To Click on the page number displayed at the start and verify the change in page numbers display
	userActions.get().clickOn("Pagination_FirstNumber");
	dynamicWait.get().waittillpageloads();
	businessFunction.get().verifySubMenuElements("GSAPagination_InitialPageNumbers", "Tag_Anchors", ",");	
	// To verify that the results dipslayed are different in different pages
}

/**
Author Name                          : Dhana Lakshmi
Date of Preparation                  : 16/07/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the Results displayed in Search Page
Reviewed By                          : --
 
**/
@Test(description="Verify the Results displayed in Search Page",groups="GSASearch")
public void testGSASearchPageResults()  
{
	
	//Launching the Avaya Website
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	// To enter "Avaya" in the Search Text Box
	businessFunction.get().deFocus();
	userActions.get().enterText("AvayaHome_SearchBox", "test");
	// To click on Search Icon
	userActions.get().clickOn("Search_Button_Test");
	// Verify the number of results displayed per page
	// businessFunction.get().checkExactCountOfElements("GSAResults", "Tag_Anchors", 10);
	// Verify the allignment in which result content is dsiplayed
	businessFunction.get().pageAllignment("GSA_ResultTitle", "GSA_ResultUrl", "below");
	businessFunction.get().pageAllignment("GSA_ResultUrl", "GSA_ResultDescription", "above");
	// Verify the presence of Featured result at the top of the other results 
	verify.get().isElementDisplayed("GSAFeaturedResult");
	businessFunction.get().checkCssProperty("GSAFeaturedResult", "background-color");
	// Verify the presence of Related Searches
	verify.get().isTextPresent("GSA_RelatedSearches_Headline");
	verify.get().isElementDisplayed("GSA_RelatedSearchLinks");
	// To click on a related Search link and validate the results	
	businessFunction.get().verifyGSASearchPageRelatedSearches("GSA_RelatedSearchLinks");
}

/**
Author Name                          : Dhana Lakshmi
Date of Preparation                  : 16/07/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the Results displayed in Search Page
Reviewed By                          : --
**/
@Test(description="Verify the Did You Mean in Search Page",groups="GSASearch")
public void testGSASearchPageDidYouMean() 
{
	//Launching the Avaya Website
	getDriver().get(appConfig.getAppUrl());
	dynamicWait.get().waittillpageloads();
	// To enter "Avaya" in the Search Text Box
	businessFunction.get().deFocus();
	userActions.get().enterText("AvayaHome_SearchBox", "avaya aura i");
	// To click on Search Icon
	userActions.get().clickOn("Search_Button_Test");
	// To Verify the presence of Keyword Suggestion (Did You Mean?)
	verify.get().isElementDisplayed("GSA_DidYouMean");
	verify.get().verifyElementContainsText("GSA_DidYouMean", "GSA_DidYouMeanText");
	// Enter Text in Search Box
	userActions.get().enterText("GlobalSearchPageSearchBox", "network");
	// Verify the auto completion results
	businessFunction.get().checkAutoCompleteResults("autosuggestion_results", "ValidSearch", "AvayaHome_SearchBox");
	
}

/**
Author Name                          : Dhana Lakshmi
Date of Preparation                  : 16/07/2015
Date of Modified                     : --
Methods Called                       : 
Purpose of Method                    : Verify the Video functionality in Avaya SnapIns Page
Reviewed By                          : --
**/
@Test(description="Verify the Video functionality in Avaya SnapIns Page",groups="Avaya-SnapIns")
public void testAvayaSnapInsAssociatedModules() 
{
	
	getDriver().get(appConfig.getAvayaSnapInsUrl());
	dynamicWait.get().waittillpageloads();
	// To Verify the Image or Video in the hero Space 
	businessFunction.get().checkImageOrVideo("AvayaSnapIns_HeroSpace");
	// To Verify the Image in Associated Module Space 
	businessFunction.get().deFocus();
	businessFunction.get().checkImageOrVideo("AvayaSnapIns_AssociatedModuleImg");
	// To Verify the Video in Associated Module Space 
	businessFunction.get().checkImageOrVideo("AvayaSnapIns_AssociatedModuleVideo");
}

}


