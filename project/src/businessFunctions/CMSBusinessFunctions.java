package businessFunctions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import objectRepository.ObjectMap;
import objectRepository.UIControlObject;
import properties.LoadAppConfig;
import testData.TestDataFactory;
import testData.TestDataMap;
import utilities.CMSWebElementFactory;
import utilities.DynamicWait;
import utilities.ScreenShots;
import verification.CMSVerify;
import verification.Verify;
import wrapper.CMSUserActions;

/**
 *
 * @author phanendra_k01
 *
 */
public class CMSBusinessFunctions {
	protected  TestDataMap<String, String> dataMap;
	protected  ObjectMap<String, UIControlObject> objMap;
	protected CMSUserActions cmsUserActions;
	protected CMSWebElementFactory cmsFactory;
	protected DynamicWait cmsDynamicWait;
	protected RemoteWebDriver driver;
	protected CMSVerify cmsverify;
	protected ScreenShots screenshots;

	
	
	LoadAppConfig appConfig = new LoadAppConfig();
	
	public CMSBusinessFunctions(RemoteWebDriver driver)
	{
		this.driver = driver;
		cmsFactory=new CMSWebElementFactory(driver);
		TestDataFactory dataFactory = new TestDataFactory();
		dataMap = dataFactory.createCMSTestDataMap();
		cmsUserActions=new CMSUserActions(driver);
		cmsverify= new CMSVerify(driver);
		cmsDynamicWait = new DynamicWait(driver);
		screenshots=new ScreenShots(driver);
	}
	
	/**
  	 * Author Name 					: phanendra_k01 
  	 * Date of Preparation 			: 22/09/2014 
  	 * Date of Modified 			: -- 
  	 * Methods Name 				: 
  	 * Purpose of Method 			: This method will verify the accordian boxes
  	 *                                
  	 * Methods Called 				: dragAndDrop 
  	 * Reviewed By 					:
  	 **/
	public void accordianBox(String controlName)
	{
		List<WebElement> countOfAccordianLinks=cmsFactory.getElements(controlName);
		if(countOfAccordianLinks.size()<11)
		{
			cmsUserActions.clickOnElementUsingImage("EditCMS.JPG");
			cmsUserActions.switchToDefaultContent();
			cmsUserActions.switchToFrame("Main_Frame");
			cmsUserActions.clickOn("SearchWithDownArrow");
			cmsUserActions.clickOn("AdvancedSearch");
			cmsUserActions.clickOn("AdvancedSearchAssetType");
			cmsUserActions.clickOn("AdvancedSearchAssetType_AvayaArticle");
			cmsUserActions.clickOn("AdvancedSearchSubAssetType");
			cmsUserActions.clickOn("AdvancedSearchSubAssetTypeAccordianArticle");
			cmsUserActions.clickOn("RunAdvancedSearch_Button");
			cmsUserActions.clickOn("AdvancedSearchDock");
			dragAndDrop("AccordianArticleSource", "AccordianArticleDestination", 50);
			cmsUserActions.clickOnElementUsingImage("SaveButton.JPG");
		}
	}
	
/**
  	 * Author Name 					: phanendra_k01 
  	 * Date of Preparation 			: 22/09/2014 
  	 * Date of Modified 			: -- 
  	 * Methods Name 				:
  	 * Purpose of Method 			: This method will verify the accordian boxes in UI
  	 *                                
  	 * Methods Called 				: -- 
  	 * Reviewed By 					:
  	 **/
	public void accordianBoxesCount(String controlName)
	{
		List<WebElement> countOfAccordianLinks=cmsFactory.getElements(controlName);
		System.out.println("Accordian assets "+countOfAccordianLinks.size());
		if(countOfAccordianLinks.size()>10)
		{
			screenshots.takeScreenShots();
			Assert.fail("There should be only 5 accordian boxes on registration page,Test failed as there are "+countOfAccordianLinks.size());
		}
	}
	/**
  	 * Author Name 					: phanendra_k01 
  	 * Date of Preparation 			: 13/07/2014 
  	 * Date of Modified 			: -- 
  	 * Methods Name 				: cmsLogin(String) 
  	 * Purpose of Method 			: This method will enter username,password and clicks on login button
  	 *                                
  	 * Methods Called 				: -- 
  	 * Reviewed By 					:
  	 **/
	public void cmsLogin(String UserName, String Password) {
		//cmsUserActions.clickOnElementUsingImage("SecurityCertificate.JPG");
		cmsFactory.dynamicWait("username",10);
		cmsUserActions.clickOn("username");
		cmsFactory.enterText("username", UserName);
		cmsFactory.dynamicWait("password",10);
		cmsUserActions.clickOn("password");
		cmsFactory.enterText("password", Password);
		cmsFactory.dynamicWait("login",10);
		cmsUserActions.clickOn("login");
		cmsFactory.dynamicWait("contributor",30);
		try {
			Thread.sleep(35000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        cmsFactory.dynamicWait("Main_Frame",30);
		cmsUserActions.switchToFrame("Main_Frame");
		closeOpenTabs();
		cmsUserActions.switchToDefaultContent();
	}
	
	/**
  	 * Author Name 					: phanendra_k01 
  	 * Date of Preparation 			: 13/07/2014 
  	 * Date of Modified 			: -- 
  	 * Methods Name 				: cmsLogin(String) 
  	 * Purpose of Method 			: This method is used to enter into CMS as admin
  	 *                                
  	 * Methods Called 				: -- 
  	 * Reviewed By 					:
  	 **/
	public void cmsAdminLogin(String UserName, String Password) {
		//cmsUserActions.clickOnElementUsingImage("SecurityCertificate.JPG");
		cmsFactory.dynamicWait("username",10);
		cmsUserActions.clickOn("username");
		cmsFactory.enterText("username", UserName);
		cmsFactory.dynamicWait("password",10);
		cmsUserActions.clickOn("password");
		cmsFactory.enterText("password", Password);
		cmsFactory.dynamicWait("login",10);
		cmsUserActions.clickOn("login");
		cmsFactory.dynamicWait("contributor",30);
		cmsUserActions.clickOnElementUsingImage("Admin.JPG");
		try {
			Thread.sleep(35000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        cmsFactory.dynamicWait("Main_Frame",30);
		cmsUserActions.switchToFrame("Main_Frame");
		closeOpenTabs();
		cmsUserActions.switchToDefaultContent();
	}

	/**
  	 * Author Name 					: phanendra_k01 
  	 * Date of Preparation 			: 14/07/2014 
  	 * Date of Modified 			: -- 
  	 * Methods Name 				: ckEditor(String,String) 
  	 * Purpose of Method 			: This method will enter text into ckEditor
  	 *                                
  	 * Methods Called 				: clickOn,switchToFrame 
  	 * Reviewed By 					:
  	 **/
	public void ckEditor(String CKEditor, String TextDescription,String frame) {
		cmsUserActions.switchToDefaultContent();
		cmsUserActions.switchToFrame("Main_Frame");
		cmsUserActions.switchToFrame("Body_Frame");
		String inputText=dataMap.get(TextDescription);	
		cmsUserActions.clickOn(CKEditor);
		cmsDynamicWait.waittillpageloads();
		cmsUserActions.switchToFrame(frame);
		cmsUserActions.clickOn("Description");
		cmsUserActions.clearText("Description");
		cmsFactory.enterText("Description", inputText);
		cmsUserActions.switchToDefaultContent();
		cmsUserActions.switchToDefaultContent();
	}
	/**
	 * Author Name 						: Sowmya Mohanan
	 * Date of Preparation 				: 16-09-2014 
	 * Date of Modified 				:  
	 * Methods Name 					: scrollDown 
	 * Purpose of Method 				: scroll down the page
	 * Methods Called 					: 
	 **/
	public void scrollDown(){
		
		Keyboard kb=driver.getKeyboard();
		kb.pressKey(Keys.PAGE_DOWN);
		kb.releaseKey(Keys.PAGE_DOWN);
	}
	
	/**
  	 * Author Name 					: phanendra_k01 
  	 * Date of Preparation 			: 14/07/2014 
  	 * Date of Modified 			: -- 
  	 * Methods Name 				: searchAsset(String) 
  	 * Purpose of Method 			: This method will enter text into search textbox and clicks on magnifier button 
  	 *                                
  	 * Methods Called 				: switchToFrame,clearText,enterText,clickOn
  	 * Reviewed By 					:
  	 **/
	public void searchAsset(String AssetName)  {
		cmsUserActions.switchToDefaultContent();
		cmsFactory.dynamicWait("Main_Frame",10);
		cmsUserActions.switchToFrame("Main_Frame");
		cmsFactory.dynamicWait("SearchBox",50);
		cmsUserActions.clickOn("SearchBox");

		cmsFactory.enterText("SearchBox", AssetName);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		cmsFactory.dynamicWait("ResultsSearchButton",10);
//		//cmsUserActions.clickOn("ResultsSearchButton");
		cmsUserActions.clickOnElementUsingImage("Magnifier.JPG");
	}
	

	public void advanceSearch(String assetType, String assetSubtype, String assetName){
		cmsUserActions.switchToDefaultContent();
		cmsFactory.dynamicWait("Main_Frame",10);
		cmsUserActions.switchToFrame("Main_Frame");
		cmsUserActions.clickOn("SearchWithDownArrow");		
		cmsFactory.dynamicWait("SearchPopup", 15);
		cmsUserActions.clickOnElementUsingImage("AdvancedSearch.JPG");
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cmsFactory.dynamicWait("AdvancedSearchAssetName", 15);
		cmsUserActions.clearText("AdvancedSearchAssetName");
		cmsFactory.enterText("AdvancedSearchAssetName", assetName);
		cmsFactory.dynamicWait("AdvancedSearchAssetType", 15);
		cmsUserActions.clickOn("AdvancedSearchAssetType");
		cmsUserActions.clickOn(assetType);
//		cmsUserActions.clickOn("AdvancedSearchAssetType_AvayaContent");
		cmsFactory.dynamicWait("AdvancedSearchAssetSubType",15);
		cmsUserActions.clickOn("AdvancedSearchAssetSubType");
		cmsUserActions.clickOn(assetSubtype);
//		cmsUserActions.clickOn("AdvancedSearchAssetSubType_RASSEO");
		cmsUserActions.clickOn("RunAdvancedSearch_Button");
		cmsFactory.dynamicWait("RunAdvancedSearch_SearchDock", 15);
		cmsUserActions.clickOn("RunAdvancedSearch_SearchDock");
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void advanceSearchWithoutSubAssertType(String assetType,String assetName){
		cmsUserActions.switchToDefaultContent();
		cmsFactory.dynamicWait("Main_Frame",10);
		cmsUserActions.switchToFrame("Main_Frame");
		cmsUserActions.clickOn("SearchWithDownArrow");		
		cmsFactory.dynamicWait("SearchPopup", 15);
		cmsUserActions.clickOnElementUsingImage("AdvancedSearch.JPG");
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cmsFactory.dynamicWait("AdvancedSearchAssetName", 15);
		cmsUserActions.clearText("AdvancedSearchAssetName");
		cmsFactory.enterText("AdvancedSearchAssetName", assetName);
		cmsFactory.dynamicWait("AdvancedSearchAssetType", 15);
		cmsUserActions.clickOn("AdvancedSearchAssetType");
		cmsUserActions.clickOn(assetType);		
		cmsUserActions.clickOn("RunAdvancedSearch_Button");
		cmsFactory.dynamicWait("RunAdvancedSearch_SearchDock", 15);
		cmsUserActions.clickOn("RunAdvancedSearch_SearchDock");
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void advanceSearchWithLocale(String assetType,String assetSubType,String assetLocale,String assetName){
		cmsUserActions.switchToDefaultContent();
		cmsFactory.dynamicWait("Main_Frame",30);
		cmsUserActions.switchToFrame("Main_Frame");
		cmsUserActions.clickOn("SearchWithDownArrow");		
		cmsFactory.dynamicWait("SearchPopup", 15);
		cmsUserActions.clickOnElementUsingImage("AdvancedSearch.JPG");
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cmsFactory.dynamicWait("AdvancedSearchAssetName", 15);
		cmsUserActions.clearText("AdvancedSearchAssetName");
		cmsFactory.enterText("AdvancedSearchAssetName", assetName);
		cmsFactory.dynamicWait("AdvancedSearch_LocaleArrow", 15);
		cmsUserActions.clickOn("AdvancedSearch_LocaleArrow");
		cmsUserActions.clickOn(assetLocale);
		cmsFactory.dynamicWait("AdvancedSearchAssetType", 15);
		cmsUserActions.clickOn("AdvancedSearchAssetType");
		cmsUserActions.clickOn(assetType);		
		cmsFactory.dynamicWait("AdvancedSearchAssetSubType",15);
		cmsUserActions.clickOn("AdvancedSearchAssetSubType");
		cmsUserActions.clickOn(assetSubType);
		cmsUserActions.clickOn("RunAdvancedSearch_Button");
		cmsFactory.dynamicWait("RunAdvancedSearch_SearchDock", 15);
		cmsUserActions.clickOn("RunAdvancedSearch_SearchDock");
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
/**
  	 * Author Name 					: phanendra_k01 
  	 * Date of Preparation 			: 16/07/2014 
  	 * Date of Modified 			: -- 
  	 * Methods Name 				: dragAndDrop(String,String,int) 
  	 * Purpose of Method 			: This method will drag and drop an element from source to destination
  	 *                                
  	 * Methods Called 				: -- 
  	 * Reviewed By 					:
  	 **/
	public void dragAndDrop(String dragFrom, String dragTo, int xOffset)
 {
		cmsFactory.dynamicWait("SearchMessage", 30);
		WebElement element = cmsFactory.getElement("SearchMessage");
		System.out.println(element.getText());
		if (!element.getText().equals("No results found.")) {
			// Setup robot
			Robot robot = null;
			try {
				robot = new Robot();
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			robot.setAutoDelay(50);
			cmsFactory.dynamicWait(dragFrom, 60);
			WebElement draggedElement = cmsFactory.getElement(dragFrom);
			Dimension fromSize = draggedElement.getSize();
			int xCentreFrom = fromSize.width / 2;
			int yCentreFrom = fromSize.height / 2;
			Point fromLocation = draggedElement.getLocation();
			Actions builder = new Actions(driver);
			builder.moveToElement(cmsFactory.getElement(dragFrom)).build()
					.perform();
			builder.clickAndHold(cmsFactory.getElement(dragFrom)).build()
					.perform();
			cmsUserActions.switchToFrame("Body_Frame");
			WebElement dragDestination = cmsFactory.getElement(dragTo);
			// Get size of elements
			Dimension toSize = dragDestination.getSize();
			// Get centre distance
			int xCentreTo = toSize.width;
			int yCentreTo = toSize.height;
			// Get x and y of WebElement to drag to
			Point toLocation = dragDestination.getLocation();
			// Make Mouse coordinate centre of element
			toLocation.x += xOffset + xCentreTo;
			toLocation.y += yCentreTo + xOffset;
			fromLocation.x += xCentreFrom;
			fromLocation.y += yCentreFrom;
			// Mouse mouse = DriverFactory.getRemoteDriver().getMouse();
			// Move mouse to drag from location
			robot.mouseMove(fromLocation.x, fromLocation.y);
			// Click and drag
			robot.mousePress(InputEvent.BUTTON1_MASK);
			// Drag events require more than one movement to register
			// Just appearing at destination doesn't work so move halfway first
			robot.mouseMove(((toLocation.x - fromLocation.x) / 2)
					+ fromLocation.x, ((toLocation.y - fromLocation.y) / 2)
					+ fromLocation.y);
			// Move to final position
			robot.mouseMove(toLocation.x, toLocation.y);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Drop
			builder.release(cmsFactory.getElement(dragTo))
					.click(cmsFactory.getElement(dragTo)).perform();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cmsUserActions.switchToDefaultContent();
			cmsUserActions.switchToFrame("Main_Frame");
			cmsUserActions.clickOn("SearchField_CrossButton");
			cmsUserActions.clickOn("CloseDock");
			cmsUserActions.switchToFrame("Body_Frame");
		} else {
			screenshots.takeScreenShots();
			Assert.fail("There is " + element.getText() + " for Search");
		}

	}
	
	/**
  	 * Author Name 					: phanendra_k01 
  	 * Date of Preparation 			: 25/07/2014 
  	 * Date of Modified 			: -- 
  	 * Methods Name 				: closeOpenTabs() 
  	 * Purpose of Method 			: This method will close all the open tabs 
  	 *                                
  	 * Methods Called 				: -- 
  	 * Reviewed By 					:
  	 **/
	public void closeOpenTabs() {
		cmsDynamicWait.waitForChildWindows();
		cmsFactory.dynamicWait("OpenTabs", 10);
		List<WebElement> elements = cmsFactory.getElements("OpenTabs");
		if (elements.size() != 1) {
			for (int i = 1; i < elements.size(); i++) {
				elements.get(i).click();
			}
		}
	}
	
	/**
  	 * Author Name 					: phanendra_k01 
  	 * Date of Preparation 			: 25/07/2014 
  	 * Date of Modified 			: -- 
  	 * Methods Name 				: closeOpenTabs() 
  	 * Purpose of Method 			: This method will close all the open tabs 
  	 *                                
  	 * Methods Called 				: -- 
  	 * Reviewed By 					:
  	 **/
	public void closePreviousTab() {
		cmsDynamicWait.waitForChildWindows();
		cmsUserActions.switchToDefaultContent();
		cmsUserActions.switchToFrame("Main_Frame");
		cmsFactory.dynamicWait("OpenTabs", 100);
		List<WebElement> elements = cmsFactory.getElements("OpenTabs");
		if (elements.size() != 1) {
			for (int i = 1; i < elements.size() - 1; i++) {
				elements.get(i).click();
			}
		}
		cmsUserActions.switchToFrame("Body_Frame");
	}
	
	
	/**
  	 * Author Name 					: phanendra_k01 
  	 * Date of Preparation 			: 24/07/2014 
  	 * Date of Modified 			: -- 
  	 * Methods Name 				: fileUpload(CharSequence,char) 
  	 * Purpose of Method 			: This method will browse the required file from local drives and uploads the file 
  	 *                                
  	 * Methods Called 				: -- 
  	 * Reviewed By 					:
  	 **/
	public void fileUpload(CharSequence characters, char driveName) {
		Robot r = null;

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		type(driveName);
		try {
			r = new Robot();
			r.keyPress(KeyEvent.VK_SHIFT);
			r.keyPress(KeyEvent.VK_SEMICOLON);
			r.keyRelease(KeyEvent.VK_SEMICOLON);
			r.keyRelease(KeyEvent.VK_SHIFT);
			r.keyPress(KeyEvent.VK_BACK_SLASH);
			r.keyRelease(KeyEvent.VK_BACK_SLASH);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int length = characters.length();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < length; i++) {
			char character = characters.charAt(i);
			type(character);
		}
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void type(char character) {
		Robot r;
		try {
			r = new Robot();
			switch (character) {
			case 'a':
				r.keyPress(KeyEvent.VK_A);
				r.keyRelease(KeyEvent.VK_A);
				break;
			case 'b':
				r.keyPress(KeyEvent.VK_B);
				r.keyRelease(KeyEvent.VK_B);
				break;
			case 'c':
				r.keyPress(KeyEvent.VK_C);
				r.keyRelease(KeyEvent.VK_C);
				break;
			case 'd':
				r.keyPress(KeyEvent.VK_D);
				r.keyRelease(KeyEvent.VK_D);
				break;
			case 'e':
				r.keyPress(KeyEvent.VK_E);
				r.keyRelease(KeyEvent.VK_E);
				break;
			case 'f':
				r.keyPress(KeyEvent.VK_F);
				r.keyRelease(KeyEvent.VK_F);
				break;
			case 'g':
				r.keyPress(KeyEvent.VK_G);
				r.keyRelease(KeyEvent.VK_G);
				break;
			case 'h':
				r.keyPress(KeyEvent.VK_H);
				r.keyRelease(KeyEvent.VK_H);
				break;
			case 'i':
				r.keyPress(KeyEvent.VK_I);
				r.keyRelease(KeyEvent.VK_I);
				break;
			case 'j':
				r.keyPress(KeyEvent.VK_J);
				r.keyRelease(KeyEvent.VK_J);
				break;
			case 'k':
				r.keyPress(KeyEvent.VK_K);
				r.keyRelease(KeyEvent.VK_K);
				break;
			case 'l':
				r.keyPress(KeyEvent.VK_L);
				r.keyRelease(KeyEvent.VK_L);
				break;
			case 'm':
				r.keyPress(KeyEvent.VK_M);
				r.keyRelease(KeyEvent.VK_M);
				break;
			case 'n':
				r.keyPress(KeyEvent.VK_N);
				r.keyRelease(KeyEvent.VK_N);
				break;
			case 'o':
				r.keyPress(KeyEvent.VK_O);
				r.keyRelease(KeyEvent.VK_O);
				break;
			case 'p':
				r.keyPress(KeyEvent.VK_P);
				r.keyRelease(KeyEvent.VK_P);
				break;
			case 'q':
				r.keyPress(KeyEvent.VK_Q);
				r.keyRelease(KeyEvent.VK_Q);
				break;
			case 'r':
				r.keyPress(KeyEvent.VK_R);
				r.keyRelease(KeyEvent.VK_R);
				break;
			case 's':
				r.keyPress(KeyEvent.VK_S);
				r.keyRelease(KeyEvent.VK_S);
				break;
			case 't':
				r.keyPress(KeyEvent.VK_T);
				r.keyRelease(KeyEvent.VK_T);
				break;
			case 'u':
				r.keyPress(KeyEvent.VK_U);
				r.keyRelease(KeyEvent.VK_U);
				break;
			case 'v':
				r.keyPress(KeyEvent.VK_V);
				r.keyRelease(KeyEvent.VK_V);
				break;
			case 'w':
				r.keyPress(KeyEvent.VK_W);
				r.keyRelease(KeyEvent.VK_W);
				break;
			case 'x':
				r.keyPress(KeyEvent.VK_X);
				r.keyRelease(KeyEvent.VK_X);
				break;
			case 'y':
				r.keyPress(KeyEvent.VK_Y);
				r.keyRelease(KeyEvent.VK_Y);
				;
				break;
			case 'z':
				r.keyPress(KeyEvent.VK_Z);
				r.keyRelease(KeyEvent.VK_Z);
				break;
			case '0':
				r.keyPress(KeyEvent.VK_0);
				r.keyRelease(KeyEvent.VK_0);
				break;
			case '1':
				r.keyPress(KeyEvent.VK_1);
				r.keyRelease(KeyEvent.VK_1);
				break;
			case '2':
				r.keyPress(KeyEvent.VK_2);
				r.keyRelease(KeyEvent.VK_2);
				break;
			case '3':
				r.keyPress(KeyEvent.VK_3);
				r.keyRelease(KeyEvent.VK_3);
				break;
			case '4':
				r.keyPress(KeyEvent.VK_4);
				r.keyRelease(KeyEvent.VK_4);
				break;
			case '5':
				r.keyPress(KeyEvent.VK_5);
				r.keyRelease(KeyEvent.VK_5);
				break;
			case '6':
				r.keyPress(KeyEvent.VK_6);
				r.keyRelease(KeyEvent.VK_6);
				break;
			case '7':
				r.keyPress(KeyEvent.VK_7);
				r.keyRelease(KeyEvent.VK_7);
				break;
			case '8':
				r.keyPress(KeyEvent.VK_8);
				r.keyRelease(KeyEvent.VK_8);
				break;
			case '9':
				r.keyPress(KeyEvent.VK_9);
				r.keyRelease(KeyEvent.VK_9);
				break;
			case '.':
				r.keyPress(KeyEvent.VK_PERIOD);
				r.keyRelease(KeyEvent.VK_PERIOD);
				break;
			default:
				throw new IllegalArgumentException("Cannot type character "+ character);
			}
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
     
 	/**
  	 * Author Name 					: phanendra_k01 
  	 * Date of Preparation 			: 24/07/2014 
  	 * Date of Modified 			: -- 
  	 * Methods Name 				: transferRight(String) 
  	 * Purpose of Method 			: This method will click on right arrow button,which is between two multi-select list boxes
  	 *                                
  	 * Methods Called 				: -- 
  	 * Reviewed By 					:
  	 **/
     
	public void transferRight(String element) {
		cmsUserActions.hoverOn(element);
		cmsUserActions.clickOn(element);
	}
     
 	/**
  	 * Author Name 					: phanendra_k01 
  	 * Date of Preparation 			: 25/07/2014 
  	 * Date of Modified 			: -- 
  	 * Methods Name 				: selectFromLeftListBox(String,String) 
  	 * Purpose of Method 			: This method will select list of categories from source selection box
  	 *                                individual strings and returns List. 
  	 * Methods Called 				: split,selectFromSourecMultiselectBox
  	 * Reviewed By 					:
  	 **/
     
	public void selectFromLeftListBox(String listBox, String element) {
		String subCategories = dataMap.get(element);
		List<String> categories = split(subCategories, ",");
		for (int i = 0; i < categories.size(); i++) {
			cmsUserActions.selectFromSourecMultiselectBox(listBox,
					categories.get(i));
		}
	}
     
 	/**
 	 * Author Name 					: phanendra_k01
 	 * Date of Preparation 			: 28/07/2014 
 	 * Date of Modified 			: -- 
 	 * Methods Name 				: split(String,String) 
 	 * Purpose of Method 			: Split's delimiter separated string coming from test data into
 	 *                                individual strings and returns List. 
 	 * Methods Called 				: -- 
 	 * Reviewed By 					:
 	 **/
	public List<String> split(String a, String delimiter) {
		List<String> list = new ArrayList<String>(Arrays.asList(a
				.split(delimiter)));
		return list;
	}
	
	/**
 	 * Author Name 					: phanendra_k01
 	 * Date of Preparation 			: 31/07/2014 
 	 * Date of Modified 			: -- 
 	 * Methods Name 				: Publish(String) 
 	 * Purpose of Method 			: This method search for the asset and publish's the asset
 	 * Methods Called 				: -- 
 	 * Reviewed By 					:
 	 **/
	public void Publish(String assetName) throws InterruptedException {
		driver.get(appConfig.getCmsStagingUrl());
		cmsAdminLogin(appConfig.getAdminUserName(),
				appConfig.getAdminPassword());
		Thread.sleep(8000);
		cmsFactory.dynamicWait("AdminPanelMainFrame", 30);
		cmsUserActions.switchToFrame("AdminPanelMainFrame");
		cmsFactory.dynamicWait("AdminPanelFrame1", 30);
		cmsUserActions.switchToFrame("AdminPanelFrame1");
		cmsFactory.dynamicWait("PublishingTab", 30);
		cmsUserActions.doubleClickOn("PublishingTab");
		Thread.sleep(8000);
		cmsUserActions.switchToDefaultContent();
		cmsUserActions.switchToFrame("PublishMainFrame");
		cmsUserActions.switchToFrame("AdminPanelFrame2");
		cmsUserActions.switchToFrame("AdminPanelFrame2");
		cmsUserActions.clickOn("PublishingDestination");
		cmsFactory.dynamicWait("PublishingDestination", 20);
		cmsUserActions.selectDropdownValue("PublishingDestination", 1);
		cmsFactory.dynamicWait("SelectDestination", 20);
		cmsUserActions.clickOn("SelectDestination");
		cmsFactory.dynamicWait("AssetsReadyToPublishLink", 20);
		cmsUserActions.clickOn("AssetsReadyToPublishLink");
		cmsFactory.dynamicWait("AssetSearchBox", 20);
		cmsUserActions.clickOn("AssetSearchBox");
		cmsFactory.dynamicWait("AssetSearchBox", 20);
		cmsFactory.enterText("AssetSearchBox", assetName);
		cmsUserActions.clickOnElementUsingImage("SearchButton.JPG");
		// cmsUserActions.clickOn("SearchButton");
		cmsFactory.dynamicWait("Checkbox", 30);
		cmsUserActions.clickOn("Checkbox");
		cmsUserActions.clickOn("AddToOnDemandQueue");
		cmsFactory.dynamicWait("PublishOnDemandQueue", 30);
		cmsUserActions.clickOn("PublishOnDemandQueue");
		cmsUserActions.clickAlertOk();
		Thread.sleep(5000);
	}
	public void clearCookies()
	{
		try {
			Runtime.getRuntime().exec("RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 255");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void verifyElementContainsText(String parentElement, String delimiter) {
		cmsFactory.dynamicWait(parentElement, 60);
		boolean flag = false;
		List<WebElement> labelElement = cmsFactory.getElements(parentElement);

		List<String> aftersplit = split(dataMap.get(parentElement), delimiter);
		for (int i = 0; i < labelElement.size(); i++) {
			for (int j = 0; j < aftersplit.size(); j++) {
				try {

					if ((labelElement.get(i).getText().trim())
							.equals(aftersplit.get(j).trim())) {
						flag = true;
						break;
					}
				} catch (NullPointerException e) {

				}
			}
			if (!flag) {
				screenshots.takeScreenShots();
				Assert.fail("Attribute : "
						+ labelElement.get(i).getText().toString()
						+ " displayed on the page.Test failed as this would not be the business requirement or working behavior");
			} else
				flag = false;

		}
	}
	
	public void creationOfAroundTheWebArticleUI()
	{
		cmsDynamicWait.waittillpageloads();
		cmsverify.isElementDisplayed("AroundWebArticle_UI_Link");
	}
	


}

	
