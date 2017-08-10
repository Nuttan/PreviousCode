package businessFunctions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import objectRepository.ObjectFactory;
import objectRepository.ObjectMap;
import objectRepository.UIControlObject;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import properties.LoadAppConfig;


import resources.VerifyImage;
import testData.TestDataFactory;
import testData.TestDataMap;
import utilities.Assertions;
import utilities.DynamicWait;
import utilities.ScreenShots;
import utilities.WebElementFactory;
import verification.Verify;
//import verification.Verify;
import wrapper.UserActions;

public class BusinessFunctions{
	

	protected  TestDataMap<String, String> dataMap;
	protected  ObjectMap<String, UIControlObject> objMap;
	protected WebElementFactory factory;
	protected ScreenShots screenshots;
	public String sharedText = null;
	protected UserActions userActions;
	protected Verify verify;
	protected DynamicWait dynamicWait;
	protected RemoteWebDriver driver;
	protected Assertions assertions;
	LoadAppConfig appConfig=new LoadAppConfig();
	
	public BusinessFunctions(RemoteWebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		factory=new WebElementFactory(driver);
		TestDataFactory dataFactory = new TestDataFactory();
		dataMap = dataFactory.createTestDataMap();
		ObjectFactory objFactory = new ObjectFactory();
		objMap = objFactory.getObjectMap();
		userActions=new UserActions(driver);
		dynamicWait = new DynamicWait(driver);
	    verify = new Verify(driver);
	    screenshots=new ScreenShots(driver);
		assertions = new Assertions(driver);
	}
	
	
	
	/**
	Author Name                       : Niharika K R 
  	Date of Preparation               : 06/06/2014 
  	Date of Modified                  : 21/07/2014 
  	Methods Called                    : getElement(String controlName), str_Assertequals(String str_actual,String str_expected),getChildElements(WebElement parent, String childControls)
  	Purpose of Method                 : To verify whether the BreadCrumb is present or not
  	Dependencies	                  : --
  	Reviewed By                       : 
   **/ 
	public void verifyBreadCrumb(String actualControlName, String expectedControlName,String tagName)
	{
		String expectedValue = dataMap.get(expectedControlName);
		List<WebElement> classNameElement = null;
		WebElement element = factory.getElement(actualControlName);
		String actualValue = null;
		List<WebElement> anchorTagsList = factory.getChildElements(element, tagName);
		for(int i = 0; i < anchorTagsList.size(); i++) 
		{
			if (actualValue == null)
			{
				actualValue = anchorTagsList.get(i).getText() + " > ";
				
			} 
			else
			{
				actualValue = actualValue + anchorTagsList.get(i).getText()+ " > ";
			}
		}
		
		classNameElement = element.findElements(By.className("current"));
		int classNameCount = classNameElement.size();
		if (classNameCount == 1 && factory.getElement(tagName).toString().contains("tag name: a"))
		{
			actualValue = actualValue + classNameElement.get(0).getText();
			
		}
		else
		{				
			actualValue = actualValue.substring(0, actualValue.lastIndexOf(">")-1);
			
		}
		
		assertions.str_Assertequals(actualValue.trim(), expectedValue.trim());
		
	}
	/**
	 Author Name                      : Niharika K R, Sowmya Mohanan, Sindhuja.  
  	Date of Preparation               : 06/06/2014 
  	Date of Modified                  : 19/06/2014 
  	Methods Called                    : getElement(String controlName),Assert_positionleft_coordinates(WebElement elementleft,WebElement elementright,String relativeControlName,String controlName), 
  										Assert_positionequal_coordinates(WebElement elementabove,WebElement elementbelow, String relativeControlName,String controlName),
  										Assert_positionright_coordinates(WebElement elementleft,WebElement elementright,String relativeControlName,String controlName)
  	Purpose of Method                 : To verify whether the positions of two control elements are equal/left/right/extreme right with relative to each other.  
  	Dependencies	                  : --
  	Reviewed By                       : 
	**/

	public void pageAllignment(String relativeControlName, String controlName, String position)
	{
		WebElement relativeControlElement = factory.getElement(relativeControlName);
		WebElement controlElement = factory.getElement(controlName);
		switch(position){
		case "equal":
			assertions.Assert_positionequal_coordinates(relativeControlElement, controlElement,relativeControlName, controlName);
			break;		
		case "right":
			assertions.Assert_positionright_coordinates(relativeControlElement, controlElement, relativeControlName, controlName);
			break;
		case "above" :
			assertions.Assert_positionabove_coordinates(relativeControlElement, controlElement, relativeControlName, controlName);
			break;
		case "extremeRight" :
			Dimension dimension = relativeControlElement.getSize();
			int relativeElementWidth=dimension.getWidth();
			int relativeElementCoOrdinate =  relativeControlElement.getLocation().getX();
			int relativeElementTotalWidth = relativeElementWidth+relativeElementCoOrdinate;
			int controlElementCoOrdinate = controlElement.getLocation().getX();
			if(controlElementCoOrdinate<relativeElementTotalWidth)
			{
				screenshots.takeScreenShots();
				Assert.fail("The" +controlName+ "is not present on the extreme right of the page");
			}
			break;
		case "below" :
			Point belowTo = relativeControlElement.getLocation();
			Dimension dim = relativeControlElement.getSize();
			
			Point elementLoc = controlElement.getLocation();
			if(!(belowTo.getX()==elementLoc.getX() && belowTo.getY()+dim.height<elementLoc.getY()))
			{
				Assert.fail("The realtive position of "+controlName+" is not below "+relativeControlName);
			}
			
		}		
	}
	
	public void loginToWebsite() throws InterruptedException{
	      userActions.clearTextBox("Login_UserName");
	      userActions.enterText("Login_UserName", appConfig.getMUserName());
	      userActions.clearTextBox("Login_Password");
	      userActions.enterText("Login_Password", appConfig.getMPassword());
	      userActions.clickOn("Login_button");
	      /*dynamicWait.waitforvisibilityOfElementLocated("Toggle_Menu"); // Additional script line when running on Mobile
	      userActions.clickOn("Toggle_Menu"); // Additional script line when running on Mobile
*/  }
	
	  /**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 09-06-2014
	  Date of Modified                  : --
	  Methods Called                    : getElements(String controlName),str_Assertequals(String str_actual,String str_expected)
	  Purpose of Method                 : To verify the color of the control elements on hovering. 
	  Dependencies	                    : --
	  Reviewed By                       : 
	  Modified By 						: Sowmya Mohanan
	 **/
	
	public void checkCssColorOnHover(String controlName) 
	{
		dynamicWait.waittillpageloads();
		List<WebElement> leftMenuList = factory.getElements(controlName);
		for (WebElement element : leftMenuList) 
		{			
			Actions actions = new Actions(driver);
			Action action;
			actions.moveToElement(element);
			action = actions.build();
            action.perform();
		  	String actualColor = element.getCssValue("color");			  	
		  	assertions.str_Assertequals(actualColor, dataMap.get(controlName));		 			
		}
		
	}
	
	/**
	 Author Name                      : Niharika K R 
	Date of Preparation               : 20/06/2014
	Date of Modified                  :
	Methods Called                    : getElement(String controlName),getChildElements(WebElement parent, String childControls)
	Purpose of Method                 : To verify whether the parent element contains any child items under it or not.
	Dependencies	                  : --
	Reviewed By                       : 
	**/
	
	public void checkPresenceOfChildElements(String controlName, String childControlElement)
	{
		WebElement parentElement = factory.getElement(controlName);
		List<WebElement> childElements = factory.getChildElements(parentElement, childControlElement);
		int size = childElements.size();
		if(size==0)
		{
			screenshots.takeScreenShots();
			Assert.fail("The" +controlName+ "does not contain any items under it");
		}
		
	}
	
	/**
	 Author Name                      : Niharika K R 
	Date of Preparation               : 23/06/2014
	Date of Modified                  :
	Methods Called                    : getElement(String controlName),getChildElements(WebElement parent, String childControls)
	Purpose of Method                 : To verify whether the count of the Images and Indicator buttons are equal or not
	Dependencies	                  : --
	Reviewed By                       : 
	**/
	
	public void verifyImageAndIndicatorButtonsCount(String imageParentControl, String indicatorParentControl)
	{
		List<WebElement> imageElements = factory.getElements(imageParentControl);
		List<WebElement> indicatorElements = factory.getElements(indicatorParentControl);
		int sizeOfImages = imageElements.size();
		int sizeOfIndicators = indicatorElements.size();
		if(sizeOfImages!=sizeOfIndicators)
		{
			screenshots.takeScreenShots();
			Assert.fail("The count of images and the count of the indicator buttons are not equal");
		}
		
	}
	
		/**
	 Author Name                      : Niharika K R 
	Date of Preparation               : 6/8/2014
	Date of Modified                  :
	Methods Called                    : getElement(String controlName),getChildElements(WebElement parent, String childControls)
	Purpose of Method                 : To verify whether the parent element contains child elements exactly equal to the count specified.
	Dependencies	                  : --
	Reviewed By                       : 
	**/
	
	public void checkExactCountOfElements(String controlName,String childElement,int count)
	{
		WebElement parentElement = factory.getElement(controlName);
		List<WebElement> childElements=factory.getChildElements(parentElement, childElement);
		assertions.int_Assertequals(childElements.size(), count);
	}
	/**
	 * Author Name 					: Phanendra Ketavarapu 
	 * Date of Preparation 			: 03/06/2014 
	 * Date of Modified 			: 06/06/2014 
	 * Methods Name 				: split(String,String) Purpose of
	 * Method 						: Split's delimiter separated string coming from test data into
	 *                                individual strings and returns List. 
	 * Methods Called 				: -- 
	 * Reviewed By 					: siva
	 **/
	public List<String> split(String a, String delimiter) {
		List<String> list = new ArrayList<String>(Arrays.asList(a.split(delimiter)));
		return list;
	}


	/**
	 * Author Name 					: Pankaj Sharma
	 * Date of Preparation 			: 09/04/2014 
	 * Date of Modified 			: 
	 * Methods Name 				: getLatestNewsCount(String controlName) 
	 * Purpose of Method 			: Verify the number of latest news(dates and url's) in the latest news pod 
	 * Methods Called 				: 
	 * Reviewed By 					: 
	 **/

	public void verifyLatestNewsPod(String controlName) {
		WebElement newsElements = factory.getElement(controlName);
		// for (WebElement newsElement : newsElements) {
		List<WebElement> newsDates = factory.getChildElements(newsElements,
				"AboutAvayaNewsPodDate");
		List<WebElement> newsLink = factory.getChildElements(newsElements,
				"AboutAvayaNewsPod_NewsLink");
		if (newsDates.size() > 0) {
			for (int i = 0; i < newsDates.size(); i++) {
				if (!(newsDates.get(i).getText()
						.matches("([0-9]{1,2})\\s([a-zA-Z]{3})\\s([0-9]{4})"))) {
					screenshots.takeScreenShots();
					Assert.fail("News section doesn't contains the date for the following News:"
							+ newsLink.get(0).getText());
				}
			}
		} else {
			screenshots.takeScreenShots();
			Assert.fail("News section doesn't contains the date");
		}
		if (newsLink.size() > 0) {
			for (int i = 0; i < newsLink.size(); i++) {
				verifyLinks(newsLink.get(i));

			}
		} else {
			screenshots.takeScreenShots();
			Assert.fail("News section doesn't contains the News Links");
		}
	}
		 
 
	 
	/**
	 * Author Name 					: Pankaj
	 * Date of Preparation 			: 09/04/2014 
	 * Date of Modified 			: 
	 * Methods Name 				: getLatestNewsCount(String controlName) 
	 * Purpose of Method 			: 
	 * Methods Called 				: 
	 * Reviewed By 					: 
	 **/
 
 public void verifyPodLinksNaviagtion(String podControlName, String titleElement)
 {
	 WebElement section = factory.getElement(podControlName);
	 List<WebElement> linksElements = factory.getChildElements(section, "Tag_Anchors");
	 String linkText = linksElements.get(0).getText();
	 linkText=linkText.replace("...", "");
	 linksElements.get(0).click();
	dynamicWait.waittillpageloads();
	WebElement articleHeader = factory.getElement("NewsArticleTitle");
	 if (!(articleHeader.getText().contains(linkText)))
	 {
		 screenshots.takeScreenShots();
		 Assert.fail("News Link "+ linkText + " doesn't navigated to correct page. The links Text and articles title on the naviageted page are not same. Articles tiltle: "+articleHeader.getText()+ "Expecetd tilte: " + linkText);
	 }
 }
		
	/** 
  	Author Name                       : @author karthik_b14 
  	Date of Preparation               : 06/06/2014 
  	Date of Modified                  : 02-09-2014
  	Methods Called                    :    
  	Purpose of Method                 : private method that returns visible topics 
  	Dependencies	                  : --
  	Reviewed By                       : --
  	**/

	public void checkforvisibleLinks(String controlName, String display) {
		List<WebElement> elements = factory.getElements(controlName);
		for (WebElement element : elements) {
			if (!element.getCssValue("display").contains(display) == true) {
				screenshots.takeScreenShots();
				if (display.equals("block")) {
					Assert.fail("The Link " + element.getText()
							+ " is not visible");
				} else {
					Assert.fail("The Link " + element.getText() + " is visible");
				}
			}
		}
	}

	
	/**
	 * Author Name 						: Phanendra Ketavarapu 
	 * Date of Preparation 				: 06/06/2014 
	 * Date of Modified 				: 15/06/2014 
	 * Methods Name 					: deFocus 
	 * Purpose of Method 				: defouses from active element, can be used often when hovering action is
	                                      performed. 
	 * Methods Called 					: clickOn(UserActions) 
	 * Reviewed By 						: Vinusha
	 **/
	public void deFocus() {
		//userActions.clickOn("ButlerBar");
		Keyboard kb=driver.getKeyboard();
		kb.pressKey(Keys.PAGE_DOWN);
		kb.releaseKey(Keys.PAGE_DOWN);
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
	 * Author Name 						: @author karthik_b14 
	 * Date of Preparation 				: 07/06/2014 
	 * Date of Modified 				: 30/07/2014 
	 * Methods Name 					: getvalueofhtmlpattribute() 
	 * Purpose of Method 				: defouses from active element, can be used often when hovering
	 * 									  action is performed. 
	 * Methods Called 					: -- 
	 * Reviewed By 						: --
	 **/

	public void getValueOfHtmlAttribute(String controlName, String attribute) {

		String actual = userActions.getHtmlAttribute(controlName, attribute);
		String expected = dataMap.get(controlName);
		try {
			assertions.str_Assertequals(actual, expected);
		} catch (AssertionError e) {
			screenshots.takeScreenShots();
			Assert.fail("Incorrect label name !! Expected: " + expected
					+ " Actual:" + actual);
		}
	}


	/** 
	  Author Name                       : Sindhuja.P 
	  Date of Preparation               : 06/06/2014 
	  Date of Modified                  : 20/06/2014
	  Methods Called                    : str_Assertequals(String str_actual,String str_expected),getElement(String controlName)  
	  Purpose of Method                 : To check the css Property of the control element.
	  Dependencies	                    : --
	  Reviewed By                       : Pankaj Sharma
	**/
	public void checkCssProperty(String controlName, String cssProperty) {
		WebElement webElement = factory.getElement(controlName);
		System.out.println(webElement.getCssValue(cssProperty));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			new InterruptedException(
					"Thread is interrupted while checking the css property of the element "
							+ controlName);
		}
		assertions.str_Assertequals(webElement.getCssValue(cssProperty),
				dataMap.get(controlName));
	}
	
	/** 
	  Author Name                       : Dhana Lakshmi 
	  Date of Preparation               : 05/06/2015 
	  Date of Modified                  : 
	  Methods Called                    : str_Assertequals(String str_actual,String str_expected),getElement(String controlName)  
	  Purpose of Method                 : To check the css Property of the control element based on the browser.
	  Dependencies	                    : --
	  Reviewed By                       : 
	**/
	
	public void checkCssPropertyVerifyingBrowser(String controlName, String cssProperty, String IEcontrolName) {
		WebElement webElement = factory.getElement(controlName);
		System.out.println(webElement.getCssValue(cssProperty));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			new InterruptedException(
					"Thread is interrupted while checking the css property of the element "
							+ controlName);
		}
		if("firefox".equalsIgnoreCase(driver.getCapabilities().getBrowserName()) || "chrome".equalsIgnoreCase(driver.getCapabilities().getBrowserName())){
		assertions.str_Assertequals(webElement.getCssValue(cssProperty),
				dataMap.get(controlName));
		}else{
			assertions.str_Assertequals(webElement.getCssValue(cssProperty),
					dataMap.get(IEcontrolName));
		}
	}

	/**
	  Author Name                       : Sindhuja.P 
	  Date of Preparation               : 06/06/2014 
	  Date of Modified                  : --
	  Methods Called                    : str_Assertequals(String str_actual,String str_expected),TestDatamap<String,String>,getRemoteDriver() 
	  Purpose of Method                 : To check the Url of the page. 
	  Dependencies	                    : --
	  Reviewed By                       : Pankaj Sharma
	**/
	
	public void checkUrl(String controlName,String flag) 
 {
		String currentUrl = userActions.getCurrentUrl();
		switch (flag) {
		case "equal":

			assertions.str_Assertequals(currentUrl, dataMap.get(controlName));
			break;
		case "contains":
			if (!(currentUrl.contains(dataMap.get(controlName)))) {
				screenshots.takeScreenShots();
				Assert.fail("The Actual URL is not equal to expecetd URL: Expecetd: "
						+ dataMap.get(controlName) + " Actual: " + currentUrl);
			}

			if (driver.getTitle().contains("Page cannot be found")) {
				screenshots.takeScreenShots();
				Assert.fail("Encountered page not found");
			}

		}
	}

	
	/** 
	  Author Name                       : Sindhuja.P
	  Date of Preparation               : 12/06/2014
	  Date of Modified                  : 05/08/2014
	  Methods Called                    : verifySearchProductResults(WebElement webElement ,String keyword),getElement(String controlName) 
	  Purpose of Method                 : To check if the results are displayed with required keyword when a valid input is given in search box.
	  Dependencies	                    : --
	  Reviewed By                       : Pankaj Sharma
	**/
	
	 public void searchValidResults(String resultsSection,String keyword)
	 {
		 List<WebElement> resultElements = factory.getElements(resultsSection);
		 verify.verifySearchResults(resultElements, keyword);		 
	 }

	 /**
	  Author Name                       : Sindhuja.P 
	  Date of Preparation               : 13/06/2014 
	  Date of Modified                  : 08/09/2014
	  Methods Called                    : getElement(String controlName) , getChildElements(WebElement parent, String childControls),verifyPagination(List<String> elements,WebElement element)    
	  Purpose of Method                 : To verify whether corresponding results are displayed in different pages.
	  Dependencies	                    : --
	  Reviewed By                       : Pankaj Sharma
	**/

	 public void paginationValidation(String secondPageSection,String firstPageSection,String previousLink) 
	 {
		 List<WebElement> secondPageElements = factory.getElements(secondPageSection);
		 List<String> totalProducts=new ArrayList<String>();
		 for(int i=0;i<secondPageElements.size();i++)
		 {	
			 totalProducts.add(secondPageElements.get(i).getText());
		 } 	 
		 userActions.clickOn(previousLink);
		 dynamicWait.waittillpageloads();
		 List<WebElement> firstPageElements = factory.getElements(firstPageSection); 
		 for(WebElement element : firstPageElements )
		 {	
			 	verify.verifyPagination(totalProducts,element);				
	     }
	
	}
	 
	 /**
	  Author Name                       : Sindhuja.P 
	  Date of Preparation               : 13/06/2014 
	  Date of Modified                  : 05/08/2014
	  Methods Called                    : getElement(String controlName) , getChildElements(WebElement parent, String childControls),str_Assertequals(String str_actual,String str_expected)    
	  Purpose of Method                 : To check if the element has all the child elements displayed on the page.
	  Dependencies	                    : --
	  Reviewed By                       : Pankaj Sharma
	  Modified By 						: Sowmya Mohanan
	**/
	
	public void verifySubMenuElements(String parentMenu,String subMenu,String delimiter)
 {
		WebElement parentMenuElement = factory.getElement(parentMenu);
		List<WebElement> subMenuElements = factory.getChildElements(
				parentMenuElement, subMenu);
		List<String> expectedSubMenuList = split(dataMap.get(parentMenu),
				delimiter);
		if (expectedSubMenuList.size() == subMenuElements.size()) {
			for (int i = 0; i < expectedSubMenuList.size(); i++) {
				assertions.str_Assertequals(subMenuElements.get(i).getText(),
						expectedSubMenuList.get(i));
			}
		} else {
			screenshots.takeScreenShots();
			Assert.fail("Test failed since the expected details count under "
					+ parentMenu
					+ "is not equal to the actual details count.Expected Details count:"
					+ expectedSubMenuList.size() + "Actual Details count"
					+ subMenuElements.size());
		}
	}

	/**
	  Author Name                       : Sindhuja.P 
	  Date of Preparation               : 16/06/2014 
	  Date of Modified                  : 18/06/2014
	  Methods Called                    : getElement(String controlName) ,  getCssValue("property")   
	  Purpose of Method                 : To check the functionality of Toggle Menu
	  Dependencies	                    : --
	  Reviewed By                       : Pankaj Sharma
	**/
	
	public void checkToggleMenuArrows(String actualControlName,String expectedControlName,String direction)
 {

		WebElement element = factory.getElement(actualControlName);
		String actual = element.getCssValue("background-image");
		switch (direction) {
		case "up":
			if (!actual.contains(dataMap.get(expectedControlName))) {
				screenshots.takeScreenShots();
				Assert.fail("Test failed since the arrow is not pointed upwards for"
						+ actualControlName);
			}
		case "down":
			if (!actual.contains(dataMap.get(expectedControlName))) {
				screenshots.takeScreenShots();
				Assert.fail("Test failed since the arrow is not pointed downwards for"
						+ actualControlName);
			}
		case "cross":
			if (!actual.contains(dataMap.get(expectedControlName))) {
				screenshots.takeScreenShots();
				Assert.fail("Test failed since the cross mark is not displayed for"
						+ actualControlName);
			}
		}
	}

	/**
	  Author Name                       : Sindhuja.P 
	  Date of Preparation               : 17/06/2014 
	  Date of Modified                  : 05/08/2014
	  Methods Called                    : getElement(String controlName) ,  getChildElements(WebElement parent, String childControls)     
	  Purpose of Method                 : To verify whether a particular tab in the page is selected.
	  Dependencies	                    : --
	  Reviewed By                       : Pankaj Sharma
	**/
	
	public void checkSelectedTabActive(String tabSection, String tabs,String str_selectedtabname) 
 {
		int count = 0;
		WebElement tabSectionElement = factory.getElement(tabSection);
		List<WebElement> tabElements = factory.getChildElements(
				tabSectionElement, tabs);
		boolean flag = false;
		for (WebElement element : tabElements) {
			if (element.getAttribute("class").contains("active")) {
				count++;
				if (element.getText().equals(str_selectedtabname)) {
					flag = true;
				}
			}
		}
		if (count != 1 && flag == false) {
			screenshots.takeScreenShots();
			Assert.fail("Test failed since the " + str_selectedtabname
					+ " is not Selected");
		}
	}
	

	/**
	 * Author Name : Sindhuja.P Date of Preparation : 23/06/2014 Date of
	 * Modified : 05/08/2014 Methods Called : getElements(String controlName),
	 * Purpose of Method : To verify the title in each Pod Dependencies : --
	 * Reviewed By : Pankaj Sharma
	 **/

	public void checkPodsTitle(String podsSection, String titleElement) {
		List<WebElement> pods = factory.getElements(podsSection);
		List<String> expectedTitleList = split(dataMap.get(podsSection), ",");
		for (WebElement pod : pods) {
			List<WebElement> titleElements = factory.getChildElements(pod,
					titleElement);
			if (!expectedTitleList.contains(titleElements.get(0).getText())) {
				screenshots.takeScreenShots();
				Assert.fail("Test Failed since the Pod does not have the title "
						+ titleElements.get(0).getText());
			}
		}
	}
	
	/** 
	  Author Name                       : Sindhuja.P 
	  Date of Preparation               : 24/06/2014 
	  Date of Modified                  : --
	  Methods Called                    : getChildElements(WebElement parent, String childControls)getElement(String controlName)  
	  Purpose of Method                 : To verify if the products in the page are displayed in the Alphabetical order
	  Dependencies	                    : --
	  Reviewed By                       : Pankaj Sharma
	**/
	
	public void checkProductsSortByName(String productsSection) {
		List<WebElement> products = factory.getElements(productsSection);
		List<String> productsByName = new ArrayList<String>();
		for (int i = 0; i < products.size(); i++) {
			productsByName.add(products.get(i).getText());
		}
		String previous = "";
		for (final String current : productsByName) {
			if (current.compareTo(previous) < 0) {
				screenshots.takeScreenShots();
				Assert.fail("Test failed since the products in the page are not displayed in the Alphabetical order from "
						+ current);
			}
			previous = current;
		}

	}
	

		
	/** 
	  Author Name                       : Sindhuja.P 
	  Date of Preparation               : 02/07/2014 
	  Date of Modified                  : 05/08/2014
	  Methods Called                    : getElement(String controlName),split(String a, String delimiter) 
	  Purpose of Method                 : To compare the font size of two different elements
	  Dependencies	                    : --
	  Reviewed By                       : Pankaj Sharma
	**/
	
	public void compareFont(String relativeTextElement,String textElement)
 {
		WebElement relativeElement = factory.getElement(relativeTextElement);
		WebElement element = factory.getElement(textElement);
		String elementFont = split(element.getCssValue("font-size"), "px").get(
				0);
		if (relativeElement.getCssValue("font-size") == "100%") {
			if (Integer.parseInt(split(
					relativeElement.getCssValue("line-height"), "px").get(0)) > Integer
					.parseInt(split(element.getCssValue("line-height"), "px")
							.get(0))) {
				screenshots.takeScreenShots();
				Assert.fail("Test failed since the font size of the"
						+ relativeTextElement
						+ "is more than the font size of the" + textElement);
			}
		} else {
			String relativeElementFont = split(
					relativeElement.getCssValue("font-size"), "px").get(0);
			if (Integer.parseInt(relativeElementFont) > Integer
					.parseInt(elementFont)) {
				screenshots.takeScreenShots();
				Assert.fail("Test failed since the font size of the"
						+ relativeTextElement
						+ "is more than the font size of the" + textElement);
			}
		}

	}
	/** 
	  Author Name                       : Sindhuja.P 
	  Date of Preparation               : 02/07/2014 
	  Date of Modified                  : 23/07/2014
	  Methods Called                    :  getElement(String controlName), checkChildElements(String controlName,String childElement)
	  Purpose of Method                 : To check the details present under the respective Toggle Menu
	  Dependencies	                    : --
	  Reviewed By                       : Pankaj Sharma
	**/

	public void checkToggleMenuDetails(String toggleMenuSection,String toggleMenuLinks,String toggleMenuTab,String delimiter)
	{
		WebElement toggleMenuElement = factory.getElement(toggleMenuTab);
		verifySubMenuElements(toggleMenuSection, toggleMenuLinks,delimiter);
		assertions.str_Assertequals(toggleMenuElement.getText(), dataMap.get(toggleMenuTab));	
	}
	/** 
	  Author Name                       : Sindhuja.P 
	  Date of Preparation               : 04/07/2014 
	  Date of Modified                  : 30/07/14
	  Methods Called                    : getElement(String controlName), getChildElements(WebElement parent, String childControls)
	  Purpose of Method                 : To check all the details of the articles present in the Case Studies page.
	  Dependencies	                    : --
	  Reviewed By                       : Pankaj Sharma
	  Modified By                       : Sowmya Mohanan
	**/
	public void checkCaseStudiesDetails(String controlName) {
		WebElement parentElement = factory.getElement(controlName);
		List<WebElement> imageElements = factory.getChildElements(
				parentElement, "Tag_Image");
		List<WebElement> headerElements = factory.getChildElements(
				parentElement, "Tag_Header");
		List<WebElement> spanElements = factory.getChildElements(parentElement,
				"Tag_Span");
		List<WebElement> listElements = factory.getChildElements(parentElement,
				"Tag_Unorderedlist");
		String img = "";
		for (WebElement imageElement : imageElements) {
			if (imageElement.getAttribute("src") == null) {
				screenshots.takeScreenShots();
				Assert.fail("Test failed since Image or Video is not displayed for the "
						+ headerElements.get(0).getText());
			} else {
				WebElement parent = imageElement.findElement(By.xpath(".."));
				String parentTag = parent.getTagName();
				if ("a".equals(parentTag)) {
					img = "video";
				} else {
					img = "image";
				}
			}
			if ("".equals(img)) {
				screenshots.takeScreenShots();
				Assert.fail("Test failed since Image or Video is not displayed for the "
						+ headerElements.get(0).getText());
			}
		}
		for (WebElement headerElement : headerElements) {
			if (headerElement.getText() == null) {
				screenshots.takeScreenShots();
				Assert.fail("Test failed since Header is not displayed for the "
						+ headerElements.get(0).getText());
			}
		}
		for (WebElement spanElement : spanElements) {
			if (spanElement.getText() == null) {
				screenshots.takeScreenShots();
				Assert.fail("Test failed since Date is not displayed for the "
						+ headerElements.get(0).getText());
			}
		}
		for (WebElement listElement : listElements) {
			if (listElement.getText() == null) {
				screenshots.takeScreenShots();
				Assert.fail("Test failed since Categories are not displayed for the "
						+ headerElements.get(0).getText());
			}
		}
	}
	/** 
	  Author Name                       : Sindhuja.P 
	  Date of Preparation               : 11/07/2014 
	  Date of Modified                  : 05/08/2014
	  Methods Called                    : getElements(String controlName), getChildElements(WebElement parent, String childControls)
	  Purpose of Method                 : To check if the News link is present with Date above it
	  Dependencies	                    : --
	  Reviewed By                       : Pankaj Sharma
	**/
	
	public void checkNewsAndDate(String newsDateSection, String dateElement,
			String newsElement) {
		List<WebElement> newsDateElements = factory
				.getElements(newsDateSection);
		for (WebElement element : newsDateElements) {
			List<WebElement> dateElements = factory.getChildElements(element,
					dateElement);
			List<WebElement> newsElements = factory.getChildElements(element,
					newsElement);
			try {
				newsElements.get(0).isDisplayed();
				Assert.assertTrue((dateElements.get(0).getLocation().y) < (newsElements
						.get(0).getLocation().y));
			} catch (AssertionError e) {
				screenshots.takeScreenShots();
				Assert.fail("Test Failed since date "
						+ dateElements.get(0).getText()
						+ "is not above the news link "
						+ newsElements.get(0).getText());
			}
		}
	}
		
	/** 
	  Author Name                       : Sindhuja.P 
	  Date of Preparation               : 15/07/2014 
	  Date of Modified                  : 05/08/2014
	  Methods Called                    : getChildElements(WebElement parent, String childControls)
	  Purpose of Method                 : To check if the control element contains a set of child elements
	  Dependencies	                    : --
	  Reviewed By                       : Pankaj Sharma
	**/
	
	public void checkContainsChildElements(String parentMenu,String subMenu,String delimiter)
	{
		WebElement parentMenuElement = factory.getElement(parentMenu);
		List<WebElement> subMenuElements=factory.getChildElements(parentMenuElement, subMenu);
		List<String> subMenuList = new ArrayList<String>();
		for(WebElement element : subMenuElements)
		{
			subMenuList.add(element.getText());
		}
		List<String> expectedSubMenuList = split(dataMap.get(parentMenu), delimiter);
		for(int i=0;i<expectedSubMenuList.size();i++)
		{
			if(!subMenuList.contains(expectedSubMenuList.get(i)))
			{
				screenshots.takeScreenShots();
				Assert.fail("Test Failed since the element "+ parentMenu+" does not contain the option"+ expectedSubMenuList.get(i));
			}
		}
	}
	/** 
	  Author Name                       : Sindhuja.P 
	  Date of Preparation               : 15/07/2014 
	  Date of Modified                  : --
	  Methods Called                    : getChildElements(WebElement parent, String childControls)
	  Purpose of Method                 : To check if the all the elements are displayed on the page.
	  Dependencies	                    : --
	  Reviewed By                       : Pankaj Sharma
	**/
	public void verifyElementsByCount(String controlName, int count)
	{
		List<WebElement> elements = factory.getElements(controlName);
		if(!(elements.size()==count))
		{
			screenshots.takeScreenShots();
			Assert.fail("Test failed since the expected count of the element "+controlName+"in the page is not equal to the actual.Expected Value :"+count+"Actual value: "+elements.size());
		}		
	}		
	
	/** 
	  Author Name                       : Sindhuja.P 
	  Date of Preparation               : 04/08/2014 
	  Date of Modified                  : --
	  Methods Called                    : getElements(String controlName)
	  Purpose of Method                 : To check if the elements are displayed per row in the page.
	  Dependencies	                    : --
	  Reviewed By                       : Pankaj Sharma
	**/
	
	public void checkIconsPresent(String parentControlName,String childControlName)
	{
		List<WebElement> parentElements = factory.getElements(parentControlName);
		List<WebElement> childElements = factory.getElements(childControlName);
		if(!(parentElements.size()==childElements.size()))
		{
			screenshots.takeScreenShots();
			Assert.fail("Test failed since "+childControlName+" is not present in one of the rows in the page");
		}
	}
	
	/** 
	  Author Name                       : Sindhuja Pogakula
	  Date of Preparation               : 08/09/2014
	  Date of Modified                  : 
	  Methods Called                    :  getElements(WebElementFactory)
	  Purpose of Method                 : To click on View all link and verify whether all the products are being displayed or not
	  Dependencies	                    : --
	  Reviewed By                       : --	  
	 * @throws InterruptedException 
	**/
	public void productsAndArticlesOnLoadMore(String firstPageProducts,String viewAllPageProducts,String clickOnElement)
	{
		List<WebElement> firstPageProductelements = factory.getElements(firstPageProducts);
		userActions.clickOn(clickOnElement);
		dynamicWait.waittillpageloads();
		List<WebElement> viewAllPageProductelements = factory.getElements(viewAllPageProducts);
		if(firstPageProductelements.size()>viewAllPageProductelements.size())
		{
			screenshots.takeScreenShots();
			Assert.fail("All the related elements available are not being displayed on click "+clickOnElement);
		}
		
	}
	
	/** 
	  Author Name                       : Phanendra
	  Date of Preparation               : 10/06/2014
	  Date of Modified                  : --
	  Methods Called                    : clickOn(Utilities), isTitlePresent(businessFunction)
	  Purpose of Method                 : Indentifies the social media icons on the page and verifies there urls
	  Dependencies	                    : --
	  Reviewed By                       : siva,Sowmya
	**/
	
	
	public void socialIcons(String controlName,String childElement,String attribute) 
	{
		String expectedIcons = dataMap.get(controlName);
		List<String> afterSplit = split(expectedIcons, ",");
		WebElement socialIconsDiv = factory.getElement(controlName);
		List<String> socialIcons=new ArrayList<String>();
		socialIcons.clear();
		for (WebElement parentDiv : factory.getChildElements(socialIconsDiv,childElement))
		{
			socialIcons.add(parentDiv.getAttribute(attribute).toString());
		}
		for(int i=0;i<socialIcons.size();i++)
		{
			assertions.str_Assertequals(socialIcons.get(i), afterSplit.get(i));
		}
	}
	
	
	/** 
	  Author Name                       : Phanendra
	  Date of Preparation               : 10/06/2014
	  Date of Modified                  : 17/06/2014
	  Methods Called                    : clickOn(Utilities), isTitlePresent(businessFunction)
	  Purpose of Method                 : verifies Header,description,image and learnmore links present under about avaya pods
	  Dependencies	                    : --
	  Reviewed By                       : siva
	**/
	public void aboutAvayaPods(String controlName,String headerControlName)
	{
		//To verify header of About avaya text
		verify.isTextPresent(headerControlName);
		//To verify whether description is present 
		WebElement paragraph =factory.getChildElement(factory.getElement(controlName),"Tag_Paragraphs");
			if(paragraph.getText()=="")
			{
				Assert.fail("Pod description is not available");
			}
		//To verify the links
		WebElement anchorLink=factory.getChildElement(factory.getElement(controlName),"Tag_Anchors");
		verifyLinks(anchorLink);
	}
	
	/** 
	  Author Name                       : Sivanag
	  Date of Preparation               : 23/08/2014
	  Date of Modified                  : --
	  Methods Called                    : clickOn(Utilities)
	  Purpose of Method                 : Verify the text after clicking on link
	  Dependencies	                    : --
	  Reviewed By                       : --
	**/
	public void verifyPageTitle(String pageTitle)
	{
		assertions.str_Assertequals(driver.getTitle().trim(),dataMap.get(pageTitle));
	}
	
	/** 
	  Author Name                       : Sivanag
	  Date of Preparation               : 11/06/2014
	  Date of Modified                  : --
	  Methods Called                    : clickOn(Utilities), isTextPresent(Verify)
	  Purpose of Method                 : Verify the text after clicking on link
	  Dependencies	                    : --
	  Reviewed By                       : --
	**/
	
	public void clickAndVerifyNavigation(String navigatetopage,String pageTitle)
	{
		userActions.clickOn(navigatetopage);
		dynamicWait.waittillpageloads();
		verify.isTextPresent(pageTitle);		
	}
	
	
	/** 
	  Author Name                       : Sivanag
	  Date of Preparation               : 17/06/2014
	  Date of Modified                  : 23/08/2014
	  Methods Called                    : getChildElements(WebElementFactory)
	  Purpose of Method                 : Verifying the multiple content type values
	  Dependencies	                    : --
	  Reviewed By                       : --	  
	**/
	
	public void verifyMultipleContentType(String controlName, String Child, String fcontrolName)
	{
		List<String> firstcontrolValues=new ArrayList<String>();	
		String expectedPodData1 = dataMap.get(fcontrolName);			
		List<String> afterSplit = split(expectedPodData1, ",,,");	
		
		WebElement podSpan = factory.getElement(controlName);
		for (WebElement fvalues : factory.getChildElements(podSpan,Child))
		{
			if(!fvalues.getText().isEmpty())
			{
			   firstcontrolValues.add(fvalues.getText().trim());				  
			}
		}
		
		if(firstcontrolValues.size()>0)
		{
			for(int p=0;p<firstcontrolValues.size();p++) {			
				
				if(!firstcontrolValues.get(p).contains(afterSplit.get(p).trim()))
				{
					screenshots.takeScreenShots();
					Assert.fail("Actual value: " + firstcontrolValues.get(p)+ "is not matching with Expected value: " +afterSplit.get(p));
				}		
				
			}
		}	
		firstcontrolValues.clear();		
	}
	


	/** 
	Author Name                       : Sivanag
	Date of Preparation               : 11/06/2014
	Date of Modified                  : 23/06/2014
	Methods Called                    : getElements(WebElementFactory)
	Purpose of Method                 : Fetch the application details and fetch the test data details and compare both the data
	Dependencies	                    : --
	Reviewed By                       : --
	Method Complete Name			  : 
	**/
	
	public void verifyChildItems(String controlName,String scontrolName, String redirectflagreqd)
	{
		
		// This map is used to get the link names
		String expected = dataMap.get(controlName);
		String linkexpected = dataMap.get(scontrolName);		
		//Using List fetching the list of values and storing into "FetchValFromApp" and it returns the WebElement
		List<WebElement> FetchValFromApp = factory.getElements(controlName);		
				
		//Here fetching the data from excel data sheet and splitting the values and then storing into List
		List<String> aftersplit = split(expected, ",");			
		List<String> linkaftersplit = split(linkexpected,",");
		
		//Here both the values comparing
		if(FetchValFromApp.size() == aftersplit.size()){			
			for(int j = 0;j<aftersplit.size();j++){
				if(!FetchValFromApp.get(j).getText().trim().contains(aftersplit.get(j).trim()))
				{
					screenshots.takeScreenShots();
					Assert.fail("Actual value is: "+FetchValFromApp.get(j).getText()+" not matching with Expected value: "+aftersplit.get(j).trim());
				}
			}
				
		String gCurrentURL = driver.getCurrentUrl();
		for(int k=0;k<aftersplit.size();k++)			
		{
			userActions.clickOn(aftersplit.get(k));			
			dynamicWait.waittillpageloads();
			String gTitle = driver.getTitle().toUpperCase();			
			driver.navigate().to(gCurrentURL);
			dynamicWait.waittillpageloads();			
			if(redirectflagreqd.equalsIgnoreCase("Yes")){
				userActions.clickOn("Home_Support"); //added by @author -karthik_b14
				userActions.hoverOn("HomePageSupportHover");}
			else{
			if(!gTitle.contains(linkaftersplit.get(k).toUpperCase())){	//Modified by sivanag as on 23/06/2014					
	           assertions.str_Assertequals(gTitle, linkaftersplit.get(k));
			}			
		
		}	
		}	
		
	}	
	
	}	
	
	
	/** 
	Author Name                       : Sivanag
	Date of Preparation               : 30/06/2014
	Date of Modified                  : 
	Methods Called                    : clickOn(Utilities), isTextPresent,isElementPresent(Verify)
	Purpose of Method                 : Fetch the server time and compare with start time and end time and verify whether chat message is displaying in that interval or not
	Dependencies	                    : --
	Reviewed By                       : --
	Method Complete Name			  : 
	 * @throws ParseException 
	 * @throws InterruptedException 
	**/
	
	public void chatPopupCheck(String controlName,String operation) throws ParseException, InterruptedException
 {

		// The below code is used to get the Respective country Timezone
		Date date = new Date();
		DateFormat gmtDf = DateFormat.getDateTimeInstance(DateFormat.FULL,
				DateFormat.FULL);
		gmtDf.setTimeZone(TimeZone.getTimeZone("EST"));
		// To retrieve the entire date information
		String nDate = gmtDf.format(date);

		// The below code is used to get the Time value from the entire string
		List<String> afterSplit = split(nDate, " ");
		// Here Concatenating the time and interval(AM or PM)
		String Concat = afterSplit.get(4) + " " + afterSplit.get(5);

		// *************The below block of code is for System Time
		// *******************

		// System date is converting into 24 hours format
		SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm:ss a");
		Date dateFor = parseFormat.parse(Concat);
		Time sysTime = new Time(dateFor.getTime());
		// Here spliting the time with ":"
		List<String> afterSplit1 = split(sysTime.toString(), ":");
		// Converting String seconds into integer milliseconds
		int secondsToMs = Integer.parseInt(afterSplit1.get(2)) * 1000;
		// Converting String minutes into integer milliseconds
		int minutesToMs = Integer.parseInt(afterSplit1.get(1)) * 60000;
		// Converting String hours into integer milliseconds
		int hoursToMs = Integer.parseInt(afterSplit1.get(0)) * 3600000;
		long total = secondsToMs + minutesToMs + hoursToMs;

		// *************The above block of code is for System Time
		// *******************

		// *************The below block of code is for Start Time
		// *******************

		// Start date is converting into 24 hours format
		String sTime = "08:00:00 AM";
		SimpleDateFormat sparseFormat = new SimpleDateFormat("hh:mm:ss a");
		Date sdateFor = sparseFormat.parse(sTime);
		Time startTime = new Time(sdateFor.getTime());
		// Here spliting the time with ":"
		List<String> afterSplit2 = split(startTime.toString(), ":");
		// Converting String seconds into integer milliseconds
		int secondsToMs1 = Integer.parseInt(afterSplit2.get(2)) * 1000;
		// Converting String minutes into integer milliseconds
		int minutesToMs1 = Integer.parseInt(afterSplit2.get(1)) * 60000;
		// Converting String hours into integer milliseconds
		int hoursToMs1 = Integer.parseInt(afterSplit2.get(0)) * 3600000;
		long total1 = secondsToMs1 + minutesToMs1 + hoursToMs1;

		// *************The above block of code is for Start Time
		// *******************

		// *************The below block of code is for End Time
		// *******************

		// End date is converting into 24 hours format
		String eTime = "4:59:59 PM";
		SimpleDateFormat eparseFormat = new SimpleDateFormat("hh:mm:ss a");
		Date edateFor = eparseFormat.parse(eTime);
		Time endTime = new Time(edateFor.getTime());
		// Here spliting the time with ":"
		List<String> afterSplit3 = split(endTime.toString(), ":");
		// Converting String seconds into integer milliseconds
		int secondsToMs2 = Integer.parseInt(afterSplit3.get(2)) * 1000;
		// Converting String minutes into integer milliseconds
		int minutesToMs2 = Integer.parseInt(afterSplit3.get(1)) * 60000;
		// Converting String hours into integer milliseconds
		int hoursToMs2 = Integer.parseInt(afterSplit3.get(0)) * 3600000;
		long total2 = secondsToMs2 + minutesToMs2 + hoursToMs2;

		// *************The above block of code is for End Time
		// *******************
		Thread.sleep(50000);

		// Comparting the System time with Start Time and End Time
		if ((total >= total1) && (total <= total2)) {
			WebElement element = factory.getElement(controlName);

			if (element.isDisplayed()) {
				switch (operation) {
				case "ChatWithUsClick":
					// Verify the chatpopup is present or not
					verify.isElementPresent("ChatPOPUP");
					// Verifying the chatwithus is present or not
					verify.isTextPresent("Chatwithus");
					// Veriyfing the ChatNoThanks is present or not
					verify.isTextPresent("ChatNoThanks");
					// Clicking on Chatwithus button
					userActions.clickOn("Chatwithus");
					dynamicWait.waittillpageloads();
					userActions.switchToChildWindow();
					// Veriyfing ChatNow is present or not
					verify.isElementPresent("ChatNow");
					break;
				case "ChatNoThanks":
					// Verify the chatpopup is present or not
					verify.isElementPresent("ChatPOPUP");
					// Verifying the chatwithus is present or not
					verify.isTextPresent("Chatwithus");
					// Veriyfing the ChatNoThanks is present or not
					verify.isTextPresent("ChatNoThanks");
					// Clicking on ChatNoThanks button
					userActions.clickOn("ChatNoThanks");
					dynamicWait.waittillpageloads();
					// Verifying the Home page
					verify.isTextPresent("AvayaAuraCallCenterEliteHomePage");
					break;
				case "PageRefresh":
					// Verify the chatpopup is present or not
					verify.isElementPresent("ChatPOPUP");
					// Verifying the chatwithus is present or not
					verify.isTextPresent("Chatwithus");
					// Veriyfing the ChatNoThanks is present or not
					verify.isTextPresent("ChatNoThanks");
					// Refershing the screen
					driver.navigate().refresh();
					Thread.sleep(50000);
					// Verify the chatpopup is present or not
					verify.isElementPresent("ChatPOPUP");
					break;
				case "OutsideClick":
					// Verify the chatpopup is present or not
					verify.isElementPresent("ChatPOPUP");
					// Verifying the chatwithus is present or not
					verify.isTextPresent("Chatwithus");
					// Veriyfing the ChatNoThanks is present or not
					verify.isTextPresent("ChatNoThanks");
					// Clicking on Outside
					userActions.clickOn("Products_Overview");
					Thread.sleep(50000);
					// Verify the chatpopup is present or not
					verify.isTextPresent("AvayaAuraCallCenterEliteHomePage");
					break;
				case "ClickonIcon":
					// Verify the chatpopup is present or not
					verify.isElementPresent("ChatIcon");
					//Click on the ICon
					userActions.clickOn("ChatIcon");
					dynamicWait.waittillpageloads();
					userActions.switchToChildWindow();
					// Veriyfing ChatNow is present or not
					verify.isElementPresent("ChatNow");
					break;

				}

			}

			else {
				if (element.isDisplayed()) {
					screenshots.takeScreenShots();
					Assert.fail("Chat Pop Up screen not found");
				}

			}

		} else {
			Reporter.log("Warning: We're sorry, agents are only available Monday through Friday, 8am to 7pm ET. Please check back then");
		}

	}
		
		
		
    
    /** 
    Author Name                       : Sowmya Mohanan
    Date of Preparation               : 11-09-2014
    Date of Modified                  : --
    Methods Called                    : --
    Purpose of Method                 : Purpose of this method is to get the count of images and validate the image sizes as per the expected values 
    Dependencies                    : --
    Reviewed By                       : --
    

    **/
    
    public void validateFlexiImages(String FlexiImages, String footer) {
    	List<WebElement> childElements = factory.getOptionalElements(FlexiImages);
    	
    	if(0 == childElements.size()){
    		screenshots.takeScreenShots();
			Assert.fail("Flexi Images are not displayed");
    	}else if (1 == childElements.size()){    			
    		String imgWidth = childElements.get(0).getAttribute("naturalWidth"); 
    		String footerWidth = userActions.getCssProperty(footer, "width"); 
    		assertions.str_Assertequals(imgWidth,footerWidth);    		
    	}else if(childElements.size() > 3){
    		screenshots.takeScreenShots();
			Assert.fail("Flexi Images cannot be more than 3 displayed");
    	}
  } 
		
		
		
	
	/**
	  Author Name                       : Sowmya Mohanan 
	  Date of Preparation               : 20/06/2014 
	  Date of Modified                  : 06/08/2014
	  Methods Called                    : getElements(String controlName), getChildElements(WebElement element, String elementType)   
	  Purpose of Method                 : verify the related article displayed on the page is as per the selected article Topics
	  Dependencies	                    : --
	  Reviewed By                       : Vinusha Tanuku 
	**/
	public void checkRelatedArticlesInArticlePage(String topicArticlescontrolName, String topicRelatedArticlescontrolName){
		List<WebElement> topics=factory.getElements(topicArticlescontrolName);
		
		List<String> topicsText = new ArrayList<String>();
		for(WebElement e : topics){
			topicsText.add(e.getText());
		}		
		List<WebElement> relatedArticleTopics=factory.getElements(topicRelatedArticlescontrolName);

		if(0 != relatedArticleTopics.size()){
			int count = 0;
			for(WebElement relatedArticle : relatedArticleTopics){
				List<WebElement> articletopics= factory.getChildElements(relatedArticle, "Tag_List");
				for(WebElement articletopic : articletopics){
					if(topicsText.contains(articletopic.getText())){
						count++;
					}
				}
				if(count != topics.size()){
					screenshots.takeScreenShots();
					Assert.fail("Related Articles should be displayed for "+topicsText+". But the Related Article topics are not matching with the Article topics. ");
				}
				count =0;
			}	
		}					
	}
	
	/** 
    Author Name                       : @author karthik_b14
    Date of Preparation               : 13/06/2014
    Date of Modified                  : 11-09-2014
    Methods Called                    : --
    Purpose of Method                 : Purpose of this method is used to send test data from the excel sheet row in comma seperated values to the application, This method accepts additional argument to perform input on the user specified form 
    Dependencies                      : --
    Reviewed By                       : --
    Modified By						  : Sowmya Mohanan,Sivanag, Dhana Lakshmi


    **/

	public void sendinputdata(String controlName, String option, String searchControlName) {
		
		if(searchControlName.equalsIgnoreCase("none")){
			
			
		}
		
		
		switch(option.toLowerCase()){
		
		case "subscription" : 	String subscriptioninputdata = dataMap.get(controlName);
								List<String> aftersplit = split(subscriptioninputdata, ",");
								factory.enterText("FirstName", aftersplit.get(0));
								factory.enterText("LastName", aftersplit.get(1));
								factory.enterText("EmailAddress", aftersplit.get(2));
								factory.enterText("Company", aftersplit.get(3));
								factory.selectByValue("CountryName", aftersplit.get(4));
								factory.selectByValue("BusinessSize", aftersplit.get(5));
								
								break;
					
		case "search" :		    String searchinputdata = dataMap.get(controlName);
								factory.enterText(searchControlName, searchinputdata);

		                        break;
	 
		
		                        
		case "registration" :   String registrationinputdata = dataMap.get(controlName);
								List<String> aftersplit_register = split(registrationinputdata, ",");
								factory.enterText("Registration_FirstName", aftersplit_register.get(0));
								factory.enterText("Registration_LastName", aftersplit_register.get(1));
								factory.enterText("Registration_EmailAddress", aftersplit_register.get(2));
								factory.enterText("Registration_BusinessPhone", aftersplit_register.get(3));
								factory.enterText("Registration_Company", aftersplit_register.get(4));
								factory.enterText("Registration_PostalCode", aftersplit_register.get(5));
								factory.selectByValue("Registration_CountryName", aftersplit_register.get(6));
								factory.selectByValue("Registration_BusinessSize", aftersplit_register.get(7));
								break;
								
		
		case "demregistration": String Demregistrationinputdata = dataMap.get(controlName);
								List<String> aftersplit_Demregister = split(Demregistrationinputdata, ",");
								factory.enterText("DemandFirstName", aftersplit_Demregister.get(0));
								factory.enterText("DemandLastName", aftersplit_Demregister.get(1));
								factory.enterText("DemandEmailAddress", aftersplit_Demregister.get(2));	
								factory.enterText("DemandWorkPhone", aftersplit_Demregister.get(3));
								factory.enterText("DemandCompany", aftersplit_Demregister.get(4));								
								factory.enterText("DemandZipCode", aftersplit_Demregister.get(5));		
								factory.selectByText("DemandCountryName", aftersplit_Demregister.get(6));
								factory.selectByText("DemandNoOfEmployees", aftersplit_Demregister.get(7));
								break;

		case "emailavaya" : String emailAvayaInputData = dataMap.get(controlName);	
							List<String> aftersplit_email = split(emailAvayaInputData, ",");
							factory.selectByValue("Email_Inquiry", aftersplit_email.get(0));
							factory.enterText("Email_FirstName", aftersplit_email.get(1));
							factory.enterText("Email_LastName", aftersplit_email.get(2));
							factory.enterText("EmailAvaya_EmailAddress", aftersplit_email.get(3));
							factory.enterText("Email_BusinessPhone", aftersplit_email.get(4));
							factory.enterText("Email_Company", aftersplit_email.get(5));		
							factory.selectByValue("Email_CountryName", aftersplit_email.get(6));
							factory.enterText("Email_PostalCode", aftersplit_email.get(7));
							factory.selectByValue("Email_NoOfEmployees", aftersplit_email.get(8));
							factory.enterText("Email_Message", aftersplit_email.get(9));
							break;
		case "sponsorshiprequest" : String sponsorshipFormData= dataMap.get(controlName);
		List<String> aftersplit_sponsorship = split(sponsorshipFormData, ",");
		factory.enterText("SponsorshipForm_Company", aftersplit_sponsorship.get(0));
		factory.enterText("SponsorshipForm_ContactName", aftersplit_sponsorship.get(1));
		factory.enterText("SponsorshipForm_Phone", aftersplit_sponsorship.get(2));
		factory.enterText("SponsorshipForm_Email", aftersplit_sponsorship.get(3));
		factory.selectByText("SponsorshipForm_Category", aftersplit_sponsorship.get(4));
		factory.enterText("SponsorshipForm_Impressions", aftersplit_sponsorship.get(5));
		factory.enterText("SponsorshipForm_Cost", aftersplit_sponsorship.get(6));
		factory.enterText("SponsorshipForm_Description", aftersplit_sponsorship.get(7));
		break;
		}	
				
	} 
	
	public void clickOnSubMenuItem(String mainMenu, String subMenu,String subMenuTitle)
    {
    	userActions.hoverOn(mainMenu);
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			new InterruptedException("Thread is interrupted while Clicking on Submenu");
		}
    	String subMenuLink = userActions.getHtmlAttribute(subMenu, "href");    	
    	driver.get(subMenuLink);
    	dynamicWait.waittillpageloads();
    	verify.isTextPresent(subMenuTitle); 	
    	
    	
    	
    }
	
	

	/** 
	  Author Name                       : Phanendra
	  Date of Preparation               : 18/06/2014
	  Date of Modified                  : --
	  Methods Called                    : clickOn(Utilities), isTitlePresent(businessFunction)
	  Purpose of Method                 : Verifies the resources on the results area in resources page
	  Dependencies	                    : --
	  Reviewed By                       : Vinusha
	**/
	 public void checkSelectedResources(String controlName)
	    {
	    	WebElement parentElement = factory.getElement(controlName);
	    	String ExpectedResources=dataMap.get(controlName);
	    	int count=0;
			for(WebElement a:factory.getChildElements(parentElement,"ResourceTitle"))
			{
				if(a.getText().equalsIgnoreCase(ExpectedResources)){
					count++;
				}
			}
			if(count<1){
				Assert.fail("Articles related to the WhitePapers are not displayed");
			}
			List<WebElement> checkedResourceDescription=factory.getElements("DocumentandVideos_CheckedResourceDescription");
			if(checkedResourceDescription.size()==0)
			{
				screenshots.takeScreenShots();
				Assert.fail("Articles related to the WhitePapers are not displayed" );
			}
		}
    /** 
	  Author Name                       : Phanendra
	  Date of Preparation               : 19/06/2014
	  Date of Modified                  : --
	  Methods Called                    : clickOn(Utilities), isTitlePresent(businessFunction)
	  Purpose of Method                 : Verifies url of the child window 
	  Dependencies	                    : --
	  Reviewed By                       : --
   	**/
	public void checkChildWindow(String controlName) 
	{
		userActions.clickOn(controlName);		
		userActions.switchToChildWindow();		
//		String currentUrl=userActions.getCurrentUrl();	
//		assertions.str_Assertequals(currentUrl,dataMap.get(controlName));
	}
	
	

	
	
	/** 
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 24/06/2014
	  Date of Modified                  : 06/08/14
	  Methods Called                    : 
	  Purpose of Method                 : Verifies if 'Show All' is displayed if the filter option is greater than 8
	  Dependencies	                    : --
	  Reviewed By                       : Vinusha Tanuku
	**/
	public void verifyFilterOptionsSelected(String controlName,String controlNameText ){
		WebElement elementFilter = factory.getElement(controlNameText);		
		List<WebElement> childElement = factory.getElements(controlName);
		int size = childElement.size();
		if(size > 8){
			String showAll = childElement.get(size-1).getText();
			if(!showAll.equals("Show All")){
				screenshots.takeScreenShots();
				Assert.fail("Show All link is not displayed for filter "+elementFilter.getText()+", where the filter option count is "+size);				
			}
		}
		
	}	
	
	/** 
	  Author Name                       : Phanendra
	  Date of Preparation               : 19/06/2014
	  Date of Modified                  : 05-09-2014
	  Methods Called                    : clickOn(Utilities), isTitlePresent(businessFunction)
	  Purpose of Method                 : Verifies tealium tags present in the source code of the page 
	  Dependencies	                    : --
	  Reviewed By                       : --
	  Modified By						: Sivanag
	**/
	public void verifyTealiumTags(String controlName,String MetaTagName, String Subtagname)
	{
		int metaTagNameCount=0;
		String expectedTagNames=dataMap.get(MetaTagName);
		List<String> actualMetaTagName=new ArrayList<String>();
		List<String> actualMetaTagContent=new ArrayList<String>();
		List<String> afterSplitTagName;
		List<WebElement> metatags= userActions.getElements(controlName);
		for(WebElement a:metatags)
		{			
			if(a.getAttribute(Subtagname)!=null)
			{
				try{
				   actualMetaTagName.add(a.getAttribute(Subtagname));
				   actualMetaTagContent.add(a.getAttribute("content"));				 
				}
				catch(NullPointerException e)
				{
					break;
				}
			}
			
		}
		String actualMetaName=StringUtils.join(actualMetaTagName);
		afterSplitTagName = split(expectedTagNames, ",");
		for(int i=0;i<actualMetaTagName.size();i++)
		{
			for(int j=0;j<afterSplitTagName.size();j++)
			{
			if(actualMetaTagName.get(i).trim().equalsIgnoreCase(afterSplitTagName.get(j).trim()))
			{
				metaTagNameCount++;
				
			}
			}	
		}
	
		if(metaTagNameCount!=afterSplitTagName.size())
		{
			Assert.fail("Incorrect meta tag names,Actual meta tags"+actualMetaName+" Should contains "+expectedTagNames);
		}
	}
	
	/** 
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 25/06/2014
	  Date of Modified                  : 06/08/14
	  Methods Called                    : 
	  Purpose of Method                 : Verifies if the selected checkbox text in displayed in Your Selection section and filter count is same
	  Dependencies	                    : --
	  Reviewed By                       : Vinusha Tanuku
	**/
	public void checkFilterSelections(String FilterOptions, String selectionBox, String searchCriteria){			
		List<WebElement> elements = factory.getElements(FilterOptions);
		List<String> selectedText = new ArrayList<String>();
		List<String> selectionText = new ArrayList<String>();
		int count = 0;
		for(WebElement element : elements){
			WebElement childElement=element.findElement(By.tagName("input"));
			if(childElement.isSelected()){
				String text = element.getText();
				int indexStart = text.indexOf("(");
				int indexEnd = text.indexOf(")");
				String subString = text.substring(indexStart+1, indexEnd);
				String subText = text.substring(0,indexStart).trim().replaceAll("[^\\p{ASCII}]", " ");
				selectedText.add(subText);
				count = count+ Integer.parseInt(subString);
			}
		}	
		List<WebElement> selectionElements = factory.getElements(selectionBox);
		for(WebElement selectionElement : selectionElements){
			
			selectionText.add(selectionElement.getText().trim().replaceAll("[^\\p{ASCII}]", " "));
		}
		WebElement countElement = factory.getElement(searchCriteria);
		String subCount = countElement.getText().substring(0,countElement.getText().indexOf(" ")).trim();
		if(!(selectedText.equals(selectionText))){
			screenshots.takeScreenShots();
			
			Assert.fail("Filter Option Selected are "+selectedText+". But Your Selection Block shows only "+selectionText+" as selected");				
		}
		
		if(!(Integer.parseInt(subCount) == count)){
			screenshots.takeScreenShots();
			Assert.fail("No of Articles displayed on the page is not equal to the Filter criteria selected for option "+selectedText+". Count  displayedon the page :"+subCount+" whereas on Filter criteria displays:"+count);				
		}
	}
	
	/** 
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 25/06/2014
	  Date of Modified                  : 06/08/14
	  Methods Called                    : 
	  Purpose of Method                 : Verifies if the no.of search result displayed as same as the count displayed in search criteria
	  Dependencies	                    : --
	  Reviewed By                       : Vinusha Tanuku
	**/
	public void checkSearchCount(String selectionlist, String searchCriteria){
		List<WebElement> element = factory.getElements(selectionlist);
		WebElement countElement = factory.getElement(searchCriteria);
		String subCount = countElement.getText().substring(0,countElement.getText().indexOf(" ")).trim();
		if(Integer.parseInt(subCount) != element.size()){
			screenshots.takeScreenShots();
			Assert.fail("Search Result is showing "+element.size()+" number of results. But the count displayed in the Search Criteria is "+Integer.parseInt(subCount));	
		}
	}
	/** 
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 10-09-2014
	  Date of Modified                  : 
	  Methods Called                    : 
	  Purpose of Method                 : Verifies if the no.of search result displayed as same as the count displayed in search criteria
	  Dependencies	                    : --
	  Reviewed By                       : 
	 **/
	public void verifySelectionCount(String selectionlist, String selected){
		List<WebElement> element = factory.getElements(selectionlist);
		WebElement countElement = factory.getElement(selected);
		String subCount = countElement.getText().substring(countElement.getText().lastIndexOf("(")+1,countElement.getText().lastIndexOf(")")).trim();
		if(Integer.parseInt(subCount) != element.size()){
			screenshots.takeScreenShots();
			Assert.fail("Results displayed in the page doenot match with the Filter selected "+selectionlist+". Count displayed at Filters is  "+element.size()+" . But the count displayed on the page : "+Integer.parseInt(subCount));	
		}
	}
	
	
	
	
	/** 
	  Author Name                       : Vinusha
	  Date of Preparation               : 9/4/2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : Verifies auto suggestion results in a form element 
	  Dependencies	                    : --
	  Reviewed By                       : --
	  * @throws InterruptedException 
	**/
	public void checkAutoCompleteResults(String autosuggestioncontrolName,
			String searchType, String searchControlName) {
		if (searchType == "InvalidSearch") {
			factory.enterText(searchControlName, "###@@");
			List<WebElement> autosuggestionNames = factory
					.getElements(autosuggestioncontrolName);
		if (autosuggestionNames.size() > 1 && autosuggestionNames.get(0).getText()!="") {				
				screenshots.takeScreenShots();
				Assert.fail("Auto Suggestion Search results are  displayed when Searched by term '###@@'");
			}
		} else if (searchType == "ValidSearch") {
			factory.enterText(searchControlName, "Avaya Aura Platform");
			List<WebElement> autosuggestionNames = factory
					.getElements(autosuggestioncontrolName);
			if (autosuggestionNames.size() <1 && autosuggestionNames.get(0).getText()=="") {
				screenshots.takeScreenShots();
				Assert.fail("Auto Suggestion Search results are not displayed when Searched by term 'Avaya'");
			}
			}

	}

	
	/** 
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 26/06/2014
	  Date of Modified                  : 18-09-2014
	  Methods Called                    : 
	  Purpose of Method                 : Shares the article in respective Social site
	  Dependencies	                    : --
	  Reviewed By                       : Vinusha Tanuku
	 * @throws InterruptedException 
	**/
	public void shareArticleInSocialSites(String controlName, String socialSites) {
		WebElement elementText = null;
		String LinkedInIcon = null;
		String inputdata = dataMap.get(controlName);
		List<String> inputaftersplit = split(inputdata, ",");			
		userActions.switchToChildWindow();
		dynamicWait.waittillpageloads();
		try{
			Thread.sleep(20000);
			String pageName = driver.getTitle();
			if(pageName.equalsIgnoreCase("Facebook") || pageName.equalsIgnoreCase("Share a link on Twitter") || pageName.equalsIgnoreCase("Twitter") || pageName.equalsIgnoreCase("Sign Up | LinkedIn") || pageName.equalsIgnoreCase("Welcome! | LinkedIn") || pageName.equalsIgnoreCase("Google+") || pageName.equalsIgnoreCase("Pinterest") || pageName.equalsIgnoreCase("Twitter") || pageName.contains("LinkedIn")){
				switch (socialSites.toLowerCase()) {
				case "facebook":	
					dynamicWait.waittillpageloads();
					factory.enterText("Facebook_EmailId", inputaftersplit.get(0));
					factory.enterText("Facebook_pwd", inputaftersplit.get(1));
					userActions.clickOn("Facebook_login");
					dynamicWait.waittillpageloads();
					elementText = factory.getElement("Facebook_Text");						
					sharedText = elementText.getText();
					userActions.clickOn("Facebook_ShareLink");
					userActions.switchToParentWindow();																											
					break; 
				case "twitter":	
					dynamicWait.waittillpageloads();
					factory.enterText("Twitter_EmailId", inputaftersplit.get(0));
					factory.enterText("Twitter_pwd", inputaftersplit.get(1));
					elementText = factory.getElement("Twitter_Text");						
					sharedText = elementText.getText();
					userActions.clickOn("Twitter_login");
					Thread.sleep(8000);
//					if(userActions.isChildWindowOpen()){
//						WebElement twitterErr = factory.getElement("Twitter_Error");
//						List<WebElement> twitterchildElements = factory.getChildElements(twitterErr, "Tag_Div");
//						if(4 == twitterchildElements.size()){
//							WebElement error = factory.getElement("twitter_errormsg");
//							if(!error.getText().equals("")){
//								screenshots.takeScreenShots();
//								Assert.fail("Link is not shared in Twitter site due to: "+error.getText()+" error");
//							}	
//						}
//					}
					 //userActions.closeChildWindow();
					userActions.switchToParentWindow();							
					break;
				case "googleplus":
					dynamicWait.waittillpageloads();
					List<WebElement> user= factory.getOptionalElements("google_user");
					if(user.size()==0)
					{
					factory.enterText("GooglePlus_EmailId", inputaftersplit.get(0));
					}
					Keyboard kb=driver.getKeyboard();
//					kb.pressKey(Keys.TAB);
//					kb.releaseKey(Keys.TAB);
					kb.pressKey(Keys.ENTER);
					kb.releaseKey(Keys.ENTER);
					
					dynamicWait.waittillpageloads();
					/*try {
						Thread.sleep(1000);
						Robot rb = new Robot();
						rb.keyPress(java.awt.event.KeyEvent.VK_TAB);
					    rb.keyRelease(java.awt.event.KeyEvent.VK_TAB); 
					    rb.keyPress(java.awt.event.KeyEvent.VK_ENTER);
					    rb.keyRelease(java.awt.event.KeyEvent.VK_ENTER); 
					} catch (AWTException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
					factory.enterText("GooglePlus_pwd", inputaftersplit.get(1));
					userActions.clickOn("GooglePlus_login");
					dynamicWait.waittillpageloads();
					Thread.sleep(8000);
					elementText = factory.getElement("GooglePlus_Text");
					sharedText = elementText.getText();
					userActions.clickOn("GooglePlus_ShareLink");
					Thread.sleep(8000);
					if(userActions.isChildWindowOpen()){					
						WebElement errorgooglemsg = factory.getElement("GooglePlus_ErrorMessage");
						if(!errorgooglemsg.getText().isEmpty()){
							screenshots.takeScreenShots();
							Assert.fail("Link is not shared in GooglePlus site due to: "+errorgooglemsg.getText()+" error");
						}
					}
					userActions.switchToParentWindow();				
					break;
				case "linkedin":
					
					if(driver.getTitle().contains("Sign Up"))
					{
						
						userActions.clickOn("LinkedInSignIn");
						dynamicWait.waittillpageloads();
					}
					dynamicWait.waitforvisibilityOfElementLocated("LinkedIn_EmailId");
					factory.enterText("LinkedIn_EmailId", inputaftersplit.get(0));
					if("firefox".equalsIgnoreCase(driver.getCapabilities().getBrowserName()) || "chrome".equalsIgnoreCase(driver.getCapabilities().getBrowserName())){						
						factory.enterText("LinkedIn_pwd", inputaftersplit.get(1));
					}else{						
						//userActions.clickOn("LinkedInIE_password");
						factory.enterText("LinkedInIE_password_Feild", inputaftersplit.get(1));
					}
					userActions.clickOn("LinkedIn_login");
					Thread.sleep(15000);					
					
				/*	userActions.switchToParentWindow();
					dynamicWait.waittillpageloads();
					deFocus();
					String link = userActions.getCurrentUrl();
					if(link.contains("events") || link.contains("case-studies")){
						LinkedInIcon = "EventPage_LinkedInIcon";
					}else if(link.contains("perspectives")){
						LinkedInIcon = "Perspective_article_linkedIn";
					}else if(link.contains("newsroom")){
						LinkedInIcon = "NewsRoomLinkedIn";
					}
					userActions.clickOn(LinkedInIcon);					
					userActions.switchToChildWindow();
					dynamicWait.waittillpageloads();
					Thread.sleep(8000);*/
					elementText = factory.getElement("LinkedIn_Text");
					sharedText = elementText.getText();
					userActions.clickOn("LinkedIn_ShareLink");	
					Thread.sleep(10000);
					userActions.clickOn("LinkedIn_close");
					userActions.switchToParentWindow();	
							
					break;
				case "pinterest":
					userActions.clickOn("PInterestLoginInButton");
					dynamicWait.waittillpageloads();
					Thread.sleep(10000);
					factory.enterText("Pinterest_EmailId", inputaftersplit.get(0));
					factory.enterText("Pinterest_pwd", inputaftersplit.get(1));
					userActions.clickOn("Pinterest_login");
					Thread.sleep(8000);
					elementText = factory.getElement("Pinterest_Text");
					sharedText = elementText.getText();
					userActions.clickOn("Pinterest_ShareLink");	
					Thread.sleep(10000);
					if(userActions.isChildWindowOpen()){	
						WebElement pInteresterror = factory.getElement("Pintersect_ErrorMessage");
						if(!pInteresterror.getText().equals("")){
							screenshots.takeScreenShots();
							Assert.fail("Link is not shared in PInterest site due to: "+pInteresterror.getText()+" error");
						}
					}
					userActions.switchToParentWindow();					
					break;				
				}			
			}else{
				userActions.closeChildWindow();
				screenshots.takeScreenShots();			
				Assert.fail(socialSites.toUpperCase()+" Page your trying to access is not available");
			}			
		}catch(InterruptedException e){
			screenshots.takeScreenShots();			
			Assert.fail("Thread has been interrupted while sharing the article in "+socialSites.toUpperCase()+" Social Site");
		}
	}
	/** 
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 26/06/2014
	  Date of Modified                  : 09-09-2014
	  Methods Called                    : 
	  Purpose of Method                 : Validate the Shared article in respective Social sites
	  Dependencies	                    : --
	  Reviewed By                       : Vinusha Tanuku
	 * @throws InterruptedException 
	 **/
	public void validateSharedArticleInSocialSites(String controlName, String socialSites) {
		WebElement sharedTextPresent = null;		
		dynamicWait.waittillpageloads();
		try{
			switch (socialSites.toLowerCase()) {
			case "facebook":
				Thread.sleep(8000);
				userActions.clickOn("facebook_Home");
				dynamicWait.waittillpageloads();
				sharedTextPresent = factory.getElement("Facebook_SharedTextPresent");
				if(!sharedTextPresent.getText().contains(sharedText)){
					screenshots.takeScreenShots();
					Assert.fail("Link was not shared in "+socialSites.toUpperCase()+" site");
				}
				userActions.clickOn("facebook_OptionButton");
				dynamicWait.waittillpageloads();
				Thread.sleep(8000);
				userActions.clickOn("facebook_Delete");
				dynamicWait.waittillpageloads();
				Thread.sleep(8000);
				userActions.clickOn("facebook_DeleteButton");
				Thread.sleep(8000);																								
				break; 
			case "twitter":											
				Thread.sleep(20000);
				sharedTextPresent = factory.getElement("TwitterBlock");
				if(!sharedTextPresent.getText().contains(sharedText)){
					screenshots.takeScreenShots();
					Assert.fail("Link was not shared in "+socialSites.toUpperCase()+" site");
				}
				
				userActions.clickOn("Twitter_MoreLink");
				//Thread.sleep(8000);							
				userActions.clickOn("twitter_delete");
				dynamicWait.waittillpageloads();
				userActions.clickOn("twitter_DeleteButton");
				Thread.sleep(8000);			
				break;
			case "googleplus":													
				Thread.sleep(30000);
				sharedTextPresent = factory.getElement("GooglePlus_SharedTextPresent");
				if(!sharedTextPresent.getText().contains(sharedText)){
					screenshots.takeScreenShots();
					Assert.fail("Link was not shared in "+socialSites.toUpperCase()+" site");
				}
				Thread.sleep(8000);
				userActions.hoverOn("GooglePlus_Option");
				userActions.clickOn("GooglePlus_OptionButton");
				dynamicWait.waittillpageloads();
				Thread.sleep(8000);
				userActions.clickOn("GooglePlus_Delete");
				dynamicWait.waittillpageloads();
				Thread.sleep(8000);
				userActions.clickOn("GooglePlus_DeleteButton");
				Thread.sleep(8000);
				break;
			case "linkedin":
				Thread.sleep(50000);
				userActions.clickOn("LinkedIn_Home");
				Thread.sleep(8000);					
				sharedTextPresent = factory.getElement("LinkedIn_SharedTextPresent");
				if(!sharedTextPresent.getText().contains(sharedText)){
					screenshots.takeScreenShots();
					Assert.fail("Link was not shared in "+socialSites.toUpperCase()+" site");
				}
//				Thread.sleep(8000);	
//				userActions.hoverOn("LinkedInShareText_Hover");
//				Thread.sleep(4000);
//				userActions.clickOn("LinkedIn_Delete");
//				Thread.sleep(8000);	
//				userActions.clickOn("LinkedIn_DeleteButton");
//				Thread.sleep(8000);	
				break;
			case "pinterest":
				
				Thread.sleep(8000);
				userActions.clickOn("Pinterest_User");
				dynamicWait.waittillpageloads();
				Thread.sleep(8000);
				userActions.clickOn("Pintersect_TakeALook");
				dynamicWait.waittillpageloads();
				Thread.sleep(10000);
				sharedTextPresent = factory.getElement("Pintersect_SharedPins");
				if(!sharedTextPresent.getText().contains(sharedText)){
					screenshots.takeScreenShots();
					Assert.fail("Link was not shared in "+socialSites.toUpperCase()+" site");
				}
				Thread.sleep(8000);
				userActions.hoverOn("Pinterest_Pin");
				Thread.sleep(8000);
				userActions.clickOn("Pinterest_EditButton");
				dynamicWait.waittillpageloads();
				Thread.sleep(8000);
				userActions.clickOn("Pinterest_DeleteButton");
				dynamicWait.waittillpageloads();
				Thread.sleep(8000);
				userActions.clickOn("Pinterest_DeleteConfirm");
				Thread.sleep(8000);
				break;				
			}								
		}catch(InterruptedException e){
			screenshots.takeScreenShots();			
			Assert.fail("Thread has been interrupted while sharing the article in "+socialSites.toUpperCase()+" Social Site ");
		}
	}
	
	/** 
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 30/06/2014
	  Date of Modified                  : 27-08-2014
	  Methods Called                    : getElement(String controlName)
	  Purpose of Method                 : Verifies the displayed image in the page is a Video/Image.
	  	  								  -- imageVideo param takes values - image / video
	  Dependencies	                    : --
	  Reviewed By                       : Vinusha Tanuku
	**/
	public void checkImageOrVideo(String imageElement){
		WebElement element = factory.getElement(imageElement);
		WebElement parent = element.findElement(By.xpath(".."));
		String parentTag = parent.getTagName();
		String img = "";
		if("a".equals(parentTag)){
			img = "video";
			userActions.clickOn(imageElement);
			dynamicWait.waittillpageloads();
			verify.verifyVideo();
		}else{
			img = "image";
			imageValidation(imageElement);
		}
	}
	
	/** 
    Author Name                       : Phanendra
    Date of Preparation               : 30/06/2014
    Date of Modified                  : --
    Methods Called                    : 
    Purpose of Method                 : Verifies the content under any of the category under resources tab
    Dependencies                           : --
    Reviewed By                       : --
  **/
  public void verifyResoureContent(String controlName,String expected, String isImgVideo)
 {
		int count = 0;
		List<String> expectedResourcesAfterSplit = new ArrayList<>();
		List<String> actualResourcesAfterSplit = new ArrayList<>();
		List<String> resourceDateList = new ArrayList<>();
		List<Date> dateList = new ArrayList<>();
		UIControlObject controlElementsObj = objMap.get(controlName);
		expectedResourcesAfterSplit = split(dataMap.get(expected), ",");
		actualResourcesAfterSplit = split(
				controlElementsObj.getControlProperty(), ",");

		WebElement resourcePodDate = factory.findElementsByXpath(
				actualResourcesAfterSplit.get(0)).get(0);
		if (resourcePodDate.getText() == null) {
			Assert.fail("Date is not displayed");
		}
		WebElement resourcePodTitle = factory.findElementsByXpath(
				actualResourcesAfterSplit.get(1)).get(0);
		if (resourcePodTitle.getText() == null) {
			Assert.fail("Title is not displayed");
		}
		WebElement resourcePodDescription = factory.findElementsByXpath(
				actualResourcesAfterSplit.get(2)).get(0);
		if (resourcePodDescription.getText() == null) {
			Assert.fail("description is not displayed");
		} else {
			if (!resourcePodDescription.getCssValue("font-size").equals(
					expectedResourcesAfterSplit.get(0))) {
				Assert.fail("Incorrect font size");
			}

		}
		// WebElement
		// resourcesImage=factory.getElement(actualResourcesAfterSplit.get(3));
		List<WebElement> ParentdateList = factory
				.findElementsByXpath(actualResourcesAfterSplit.get(4));
		if (!"none".equalsIgnoreCase(isImgVideo)) {
			// checkImageOrVideo(actualResourcesAfterSplit.get(3),isImgVideo);
			WebElement element = factory.findElementsByXpath(
					actualResourcesAfterSplit.get(3)).get(0);
			WebElement parent = element.findElement(By.xpath(".."));
			String parentTag = parent.getTagName();
			String img = "";
			if ("a".equals(parentTag)) {
				img = "video";
			} else {
				img = "image";
			}
			if (!img.equalsIgnoreCase(isImgVideo)) {
				screenshots.takeScreenShots();
				Assert.fail("Image or Video displayed in the page should be "
						+ isImgVideo + " but is displayed as " + img);
			}
		}
		for (WebElement descendingDates : ParentdateList) {
			resourceDateList.add(descendingDates.getText());
		}
		dateList = stringToDate(resourceDateList);
		List<Date> descendingOrder = dateList;
		Collections.sort(dateList, Collections.reverseOrder());
		for (int i = 0; i < dateList.size(); i++) {
			if (descendingOrder.get(i) != dateList.get(i)) {
				count++;
			}
		}
		if (count != 0) {
			Assert.fail("Dates are not in descending order");
		}

	}
  /** 
    Author Name                       : Phanendra
    Date of Preparation               : 30/06/2014
    Date of Modified                  : 15-09-2014
    Methods Called                    : 
    Purpose of Method                 : This function converts string object to date object.
    Dependencies                           : --
    Reviewed By                       : --
  **/
  public List<Date> stringToDate(List<String> actualDates)
  {
         List<Date> dateList=new ArrayList<>();
         SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
         List<String> dateInString = actualDates;
         for(int i=0;i<actualDates.size();i++)
         {
                try {
                      Date date = formatter.parse(dateInString.get(i));
                      dateList.add(date);
                } catch (ParseException e) {
                	screenshots.takeScreenShots();
           			Assert.fail("Date should be in dd MMM yyyy format");
                }
         }
         return dateList;
  }
  
  /** 
  Author Name                       : Sowmya Mohanan
  Date of Preparation               : 04/07/2014
  Date of Modified                  : 06/08/14
  Methods Called                    : getElement(String controlName)
  Purpose of Method                 : Verifies the NewsRoom page Content	  								  
  Dependencies	                    : --
  Reviewed By                       : Vinusha Tanuku
  **/
  public void checkNewsRoomContent(String controlName, String dateElements){
	  List<WebElement> clickableelements = factory.getElements(controlName);
	  if(3 != clickableelements.size()){
		  screenshots.takeScreenShots();
		  Assert.fail("NewsRoom Clickable Elements should be 3, but in page its displayed only "+clickableelements.size());
	  }
	  for(WebElement element : clickableelements){
		  List<WebElement> childElements = factory.getChildElements(element, "Tag_Anchors");
		  String more = childElements.get(childElements.size()-1).getText();
		  if(!"more...".equalsIgnoreCase(more)){
			  screenshots.takeScreenShots();
			  Assert.fail("more... Link should be present under each NewsRoom Clickable Elements, but its not present");
		  }
	  }
	  List<WebElement> date = factory.getElements(dateElements);
	  List<String> dateToString = new ArrayList<String>();
	  for(WebElement element : date){
		  dateToString.add(element.getText());
	  }
	  stringToDate(dateToString);
	  
  }
  
  
  
  
  
  /** 
  Author Name                       : @author karthik_b14
  Date of Preparation               : 27/06/2014
  Date of Modified                  : 6-Aug-2014
  Methods Called                    : 
  Purpose of Method                 : Verifies order of publishing of related articles 
  Dependencies	                    : --
  Reviewed By                       : --
  * @throws InterruptedException 
**/

public void checkRelatedArticlesOrder(String articleDateElements) {

		List<String> orderedlist = new ArrayList<String>();

		for (WebElement element : factory.getElements(articleDateElements)) {

			orderedlist.add(element.getText());
		}

		for (int i = 0; i < orderedlist.size(); i++) {

			Collections.sort(orderedlist, new Comparator<String>() {
				DateFormat f = new SimpleDateFormat("dd MMM yyyy");

				@Override
				public int compare(String o1, String o2) {
					try {
						if (f.parse(o1).compareTo(f.parse(o2)) > 0) {
							return -1;
						}
					} catch (Exception e) {
						e.printStackTrace();
						Assert.fail("List cannot be ordered");
					}
					return 0;
				}
			});

		}
	}


/** 
  Author Name                       : @author karthik_b14
  Date of Preparation               : 30/06/2014
  Date of Modified                  : --
  Methods Called                    : 
  Purpose of Method                 : check width of a given two elements and validate if they are equal 
  Dependencies	                    : --
  Reviewed By                       : --
  * @throws InterruptedException 
**/

public void checkWidth(String contolName1, String controlName2){

		WebElement controlElement1 = factory.getElement(contolName1);
		WebElement controlElement2 = factory.getElement(controlName2);

		String width1 = controlElement1.getCssValue("width");
		String width2 = controlElement2.getCssValue("width");

		if (!(width1.equalsIgnoreCase(width2))) {
			screenshots.takeScreenShots();
			Assert.fail("Width of :" + contolName1 + "and" + controlName2
					+ "are not matching");

		}
	}


/** 
  Author Name                       : @author karthik_b14
  Date of Preparation               : 30/06/2014
  Date of Modified                  : --
  Methods Called                    : 
  Purpose of Method                 : check if expected elements are clickable or not  
  Dependencies	                    : --
  Reviewed By                       : --
  * @throws InterruptedException 
**/

public void checkElementsClickable(String controlName, String childControlName,
		String result) {
	
		List<String> Listvalues = new ArrayList<String>();

		String expectedresult = dataMap.get(result);

		WebElement parent = factory.getElement(controlName);

		for (WebElement element : factory.getChildElements(parent,
				childControlName)) {

			if (!element.getTagName().isEmpty()) {
				Listvalues.add(element.getTagName());
			}
		}
		for (int i = 0; i < Listvalues.size(); i++) {

			assertions.str_Assertequals(Listvalues.get(i), expectedresult);
		}

	}



/** 
  Author Name                       : @author karthik_b14
  Date of Preparation               : 02/07/2014
  Date of Modified                  : --
  Methods Called                    : 
  Purpose of Method                 : check CSS properties of multiple elements  
  Dependencies	                    : --
  Reviewed By                       : --
  * @throws InterruptedException 
**/

public void checkMultipleCSSProperties(String controlName, String cssProperty) {

		List<String> Listvalues = new ArrayList<String>();
		String expectedData = dataMap.get(controlName);
		List<String> afterSplit = split(expectedData, ",,,");

		for (WebElement element : factory.getElements(controlName)) {

			Listvalues.add(element.getCssValue(cssProperty));

		}

		for (int i = 0; i < Listvalues.size(); i++) {
			assertions.str_Assertequals(Listvalues.get(i), afterSplit.get(i));
		}

	}


/** 
  Author Name                       : @author karthik_b14
  Date of Preparation               : 02/07/2014
  Date of Modified                  : --
  Methods Called                    : 
  Purpose of Method                 : check the scroll contents and verifies the scroll based on text  
  Dependencies	                    : --
  Reviewed By                       : --
  * @throws InterruptedException 
**/
public void checkPerspectivePODscroll(String controlName, String controlName2) {

		List<String> Listvalues1 = new ArrayList<String>();
		List<String> Listvalues2 = new ArrayList<String>();

		for (WebElement element : factory.getElements(controlName)) {

			Listvalues1.add(element.getText());

		}

		userActions.clickOn(controlName2);

		dynamicWait.waittillpageloads();

		for (WebElement element : factory.getElements(controlName)) {

			Listvalues2.add(element.getText());

		}

		if (Listvalues2.equals(Listvalues1)) {
			Assert.fail("Both the text contents are same in the list, Hence scroll was not proper");
		}
	}



		/** 
		Author Name                       : Sowmya Mohanan
		Date of Preparation               : 07/07/2014
		Date of Modified                  : 06/08/14
		Methods Called                    : getElement(String controlName)
		Purpose of Method                 : Verifies Articles dispalyed as per the category clicked	  								  
		Dependencies	                  : --
		Reviewed By                       : Vinusha Tanuku
		**/
	public void checkArticleHeader(String controlName, String categorys) {
		WebElement element = factory.getElement(controlName);
		String selectedCateory = element.getText().trim();
		// Click on the Category
		userActions.clickOn(controlName);
		List<WebElement> childElements = factory.getElements(categorys);
		if (0 != childElements.size()) {
			int count = 0;
			for (WebElement relatedArticle : childElements) {
				List<WebElement> articletopics = factory.getChildElements(
						relatedArticle, "Tag_List");
				for (WebElement articletopic : articletopics) {
					if (selectedCateory.contains(articletopic.getText())) {
						count++;
					}
				}
				if (0 == count) {
					screenshots.takeScreenShots();
					Assert.fail("Article specific to the selected category "
							+ selectedCateory + " is not displayed");
				}
			}
		}
	}
  
  		
  		/**
  	  Author Name                       : Sowmya Mohanan
  	  Date of Preparation               : 08/07/2014 
  	  Date of Modified                  : 06/08/14
  	  Methods Called                    : getElement(String controlName) , getChildElements(WebElement parent, String childControls),str_Assertequals(String str_actual,String str_expected)    
  	  Purpose of Method                 : To verify sub menu element details
  	  Dependencies	                    : --
  	  Reviewed By                       : Vinusha Tanuku
  	**/
  	
  	public void verifySubMenuElementDetails(String controlName)
 {
		List<WebElement> childElements = factory.getElements(controlName);
		List<String> aftersplit = split(dataMap.get(controlName), ",");
		String text = null;
		if (aftersplit.size() == childElements.size()) {
			for (int i = 0; i < aftersplit.size(); i++) {
				int index = childElements.get(i).getText().lastIndexOf("(");
				if (-1 != index) {
					text = childElements.get(i).getText()
							.substring(0, index - 1).trim();
				} else {
					text = childElements.get(i).getText();
				}
				
				assertions.str_Assertequals(text, aftersplit.get(i));
			}
		} else {
			screenshots.takeScreenShots();
			Assert.fail("Test Failed since Expected value is not equal to actual .Expected value:"
					+ aftersplit.size()
					+ " Actual value:"
					+ childElements.size());
		}
	}

  	/**
	  Author Name                       : Phanendra_k01
	  Date of Preparation               : 24/07/2014 
	  Date of Modified                  : --
	  Methods Called                    : --    
	  Purpose of Method                 : To refresh the page
	  Dependencies	                    : --
	  Reviewed By                       : --
	**/	
  	public void refreshPage()
  	{
  		driver.navigate().refresh();
  	}

  	
  	/**
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 31/08/2014 
	  Date of Modified                  : 06/08/14
	  Methods Called                    : 
	  Purpose of Method                 : To verify whether the page urls are as expected
	  Dependencies	                    : --
	  Reviewed By                       : Vinusha Tanuku
  	 * @throws InterruptedException 
	**/	
	public void verifyMagazinePageUrls(String controlName)
			throws InterruptedException {
		List<WebElement> elements = factory.getElements(controlName);
		for (WebElement element : elements) {
			element.click();
			Thread.sleep(5000);
			userActions.switchToChildWindow();
			Thread.sleep(5000);
			String currentUrl = driver.getCurrentUrl();
			if (-1 == currentUrl.indexOf("usa/campaign")) {
				screenshots.takeScreenShots();
				Assert.fail("Navigated page URL is not as expected");
			}
			if ("Page Not Found".equalsIgnoreCase(driver.getTitle())) {
				screenshots.takeScreenShots();
				Assert.fail(driver.getTitle() + " page is displayed");
			}
			//userActions.closeChildWindow();
			userActions.switchToParentWindow();
		}
	}
  	
  	/**
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 07/08/2014 
	  Date of Modified                  : 03-09-2014
	  Methods Called                    : 
	  Purpose of Method                 : To verify Partner Details are dispalyed in Expert Badge sorted order
	  Dependencies	                    : --
	  Reviewed By                       : 
	 * @throws InterruptedException 
	**/	
  	public void verifyExpertBadgeOrder() throws InterruptedException{
  		WebElement lastPage = factory.getElement("PartnerLocator_LastPageName");
  		
  		List<String> partnerLevels = new ArrayList<String>();
  		partnerLevels.add("Platinum");
  		partnerLevels.add("Gold");
  		partnerLevels.add("Silver");
  		partnerLevels.add("Authorized");
  		
  		String firstPartnerLevel = "";
  		String prevPartnerLevel = "";
  		
  		String lastPageName = lastPage.getText();
  		int index = lastPageName.lastIndexOf(".");
  		lastPageName = lastPageName.substring(index+1, lastPageName.length());
  		List<WebElement> expertBadges = new ArrayList<WebElement>();
  		List<Integer> expertBadgeCount = new ArrayList<Integer>();
  		List<Integer> sortExpertBadge = new ArrayList<Integer>();
  		for(int i=0;i<Integer.parseInt(lastPageName);i++){
  			List<WebElement> details = factory.getElements("PartnerLocator_DetailsArrow");
  			List<WebElement> levelNames = factory.getElements("PartnerLocator_PartnerLevels");
  			int countLevel = 0;
  			for(WebElement detail : details){
  				firstPartnerLevel = levelNames.get(countLevel).getText();
  				if(!firstPartnerLevel.equals(prevPartnerLevel) && !prevPartnerLevel.equals("")){
  					partnerLevels.remove(prevPartnerLevel);  					
  					sortExpertBadge.addAll(expertBadgeCount);
  					Collections.sort(sortExpertBadge); 					
  					Collections.reverse(sortExpertBadge);
  					if(!sortExpertBadge.equals(expertBadgeCount)){
  						screenshots.takeScreenShots();
  	  					Assert.fail("Partner Details are not sorted by Expert Badge Tick count");
  					}
  					expertBadgeCount.clear(); 
  					sortExpertBadge.clear();
  				}
  				if(!partnerLevels.contains(firstPartnerLevel)){
  					screenshots.takeScreenShots();
  					Assert.fail("Partner Details are not sorted by Partner Level");
  				}
  				prevPartnerLevel = firstPartnerLevel;                           
  				
  				detail.click();
  				Thread.sleep(2000);
  				expertBadges = factory.getOptionalElements("PartnerLocator_ExpertBadge");
  				expertBadgeCount.add(expertBadges.size());
  				countLevel++;
  			}  			
  			userActions.clickOn("PartnerLocator_NextButton");
  		}
  		sortExpertBadge.addAll(expertBadgeCount);
  		Collections.sort(sortExpertBadge);
  		Collections.reverse(sortExpertBadge);
  		if(!sortExpertBadge.equals(expertBadgeCount)){
  			screenshots.takeScreenShots();
			Assert.fail("Partner Details are not sorted by Expert Badge Tick count");
  		}
  	}
  	
  	/**
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 08/08/2014 
	  Date of Modified                  : 
	  Methods Called                    : 
	  Purpose of Method                 : To verify all the Partner Details and its irrespective Icons
	  Dependencies	                    : --
	  Reviewed By                       : 
	 * @throws InterruptedException 
	**/	
	public void verifyPartnerDetails() throws InterruptedException {
		WebElement lastPage = factory.getElement("PartnerLocator_LastPageName");

		String lastPageName = lastPage.getText();
		int index = lastPageName.lastIndexOf(".");
		lastPageName = lastPageName.substring(index + 1, lastPageName.length());

		for (int i = 0; i < Integer.parseInt(lastPageName); i++) {
			List<WebElement> details = factory
					.getElements("PartnerLocator_DetailsArrow");
			List<WebElement> leftDetails = factory
					.getElements("PartnerLocator_leftDetails");
			int countdetails = 0;
			for (WebElement detail : details) {

				WebElement element = leftDetails.get(countdetails);
				detail.click();
				Thread.sleep(2000);

				WebElement popUpDetails = factory
						.getElement("PartnerLocator_PopupDetails");

				// verify the Popup is displayed over the Map
				WebElement map = factory.getElement("PartnerLocator_Map");
				popUpDetails.getText().contains("Solution");
				popUpDetails.getText().contains("Authorized");
				popUpDetails.getText().contains("Expert Specialization");
				popUpDetails.getText().contains("Earned");
				Dimension dimensionMap = map.getSize();
				Dimension dimensionPopUp = popUpDetails.getSize();

				int mapX = map.getLocation().x;
				int mapWidth = dimensionMap.getWidth();

				int mapHorizontal = mapX + mapWidth;

				int popUpX = popUpDetails.getLocation().x;
				int popUpWidth = dimensionPopUp.getWidth();

				int popUpHorizontal = popUpX + popUpWidth;

				int mapY = map.getLocation().y;
				int mapHeight = dimensionMap.getHeight();

				int popUpY = popUpDetails.getLocation().x;
				int popUpHeight = dimensionPopUp.getHeight();
				if (!(popUpY > mapY && popUpHeight < mapHeight)
						|| !(popUpX > mapX && popUpHorizontal < mapHorizontal)) {
					screenshots.takeScreenShots();
					Assert.fail("Popup is not displayed over the Map");
				}

				// Title
				comparePartnerDetails(element, popUpDetails, "Common_Heading4",
						"");

				// Distance
				comparePartnerDetails(element, popUpDetails, "Tag_Span", "");

				// Phone No
				comparePartnerDetails(element, popUpDetails,
						"PartnerLocator_Phone", "phoneIcon.jpg");

				// Email
				comparePartnerDetails(element, popUpDetails,
						"PartnerLocator_Email", "mailIcon.jpg");

				// Website
				comparePartnerDetails(element, popUpDetails,
						"PartnerLocator_Website", "ComputerIcon.jpg");

				// Partner Level
				comparePartnerDetails(element, popUpDetails,
						"PartnerLocator_PartnerLevel", "partnerlevelIcon.jpg");

				// Partner in Customer Excellence
				comparePartnerDetails(element, popUpDetails,
						"PartnerLocator_CustomerExcellence", "partnerIcon.jpg");

				countdetails++;
			}
			userActions.clickOn("PartnerLocator_NextButton");
		}

	}
  	
  	/**
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 08/08/2014 
	  Date of Modified                  : 
	  Methods Called                    : 
	  Purpose of Method                 : To verify all the Partner Details and its irrespective Icons
	  Dependencies	                    : --
	  Reviewed By                       : 
  	 * @throws InterruptedException 
  	 **/	
  	public void verifyFirstPartnerDetails(String firstDetailArrow, String leftDetail) throws InterruptedException{  		
  		WebElement detail = factory.getElement(firstDetailArrow);
  		WebElement element = factory.getElement(leftDetail);
 				
  		detail.click();
  		Thread.sleep(2000);  				
  				
  		WebElement popUpDetails = factory.getElement("PartnerLocator_PopupDetails");
  			
  		//verify the Popup is displayed over the Map
  		WebElement map = factory.getElement("PartnerLocator_Map");
  			  			
  		Dimension dimensionMap = map.getSize();
  		Dimension dimensionPopUp = popUpDetails.getSize();
  			
  		int mapX = map.getLocation().x;
  		int mapWidth = dimensionMap.getWidth();
  			
  		int mapHorizontal = mapX+mapWidth;
  			
  		int popUpX = popUpDetails.getLocation().x;
  		int popUpWidth = dimensionPopUp.getWidth();
  			
  		int popUpHorizontal = popUpX+popUpWidth;
  			
  		int mapY = map.getLocation().y;
  		int mapHeight = dimensionMap.getHeight();
  			
  		int popUpY = popUpDetails.getLocation().x;
  		int popUpHeight = dimensionPopUp.getHeight(); 			
  			
  		if(!(popUpY > mapY && popUpHeight < mapHeight) || !(popUpX > mapX && popUpHorizontal < mapHorizontal)){
  			screenshots.takeScreenShots();
			Assert.fail("Popup is not displayed over the Map");
  		}
  			
  		//Title
  		comparePartnerDetails(element,popUpDetails,"Common_Heading4","");
  				
  		//Distance
  		comparePartnerDetails(element,popUpDetails,"Tag_Span","");
  				
  		//Phone No
  		comparePartnerDetails(element,popUpDetails,"PartnerLocator_Phone","phoneIcon.jpg");
  				
  		//Email
  		comparePartnerDetails(element,popUpDetails,"PartnerLocator_Email","mailIcon.jpg");
  				
  		//Website
  		comparePartnerDetails(element,popUpDetails,"PartnerLocator_Website","ComputerIcon.jpg");
  				
  		//Partner Level
  		comparePartnerDetails(element,popUpDetails,"PartnerLocator_PartnerLevel","partnerlevelIcon.jpg");
  				
  		//Partner in Customer Excellence
  		comparePartnerDetails(element,popUpDetails,"PartnerLocator_CustomerExcellence","partnerIcon.jpg");
  				

  		verify.isElementDisplayed("PartnerLocator_PopUpDetails_Solution");
		verify.isElementDisplayed("PartnerLocator_PopUpDetails_Authorized");
		verify.isElementDisplayed("PartnerLocator_PopUpDetails_Expert Badge");
  	}
  	
  	/**
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 08/08/2014 
	  Date of Modified                  : 
	  Methods Called                    : 
	  Purpose of Method                 : To compare left side Partner Details with the PopUp details
	  Dependencies	                    : --
	  Reviewed By                       : 
	**/	
  	public void comparePartnerDetails(WebElement leftDetails, WebElement popUpDetail, String childElement, String expectedIcon){
  		String data = "";
  		String popUpData = "";
  		List<WebElement> element = factory.verifyContainsChildElements(leftDetails, childElement);
		if(element.size() != 0){
			data = element.get(0).getText();
		}
		
		List<WebElement> popUpElements = factory.verifyContainsChildElements(popUpDetail, childElement);
		if(popUpElements.size() != 0){
			popUpData = popUpElements.get(0).getText();
		}
		if(!data.equals("") && !popUpData.equals("")){
			assertions.str_Assertequals(popUpData, data);
			if(!expectedIcon.equals("")){				
				verify.verifyIcons(element.get(0), expectedIcon);
				verify.verifyIcons(popUpDetail, expectedIcon);
				
			}
		}
  	}
  	
  	/**
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 07/08/2014 
	  Date of Modified                  : 
	  Methods Called                    : 
	  Purpose of Method                 : To verify Partner Details are dispalyed in Partner Level sorted order
	  Dependencies	                    : --
	  Reviewed By                       : 
	 * @throws InterruptedException 
	**/	
  	public void verifyPartnerLevels()
  	{
  		WebElement lastPage = factory.getElement("PartnerLocator_LastPageName");
  		List<String> partnerLevels = new ArrayList<String>();
  		partnerLevels.add("Platinum");
  		partnerLevels.add("Gold");
  		partnerLevels.add("Silver");
  		partnerLevels.add("Authorized");
  		String firstPartnerLevel = "";
  		String prevPartnerLevel = "";
  		String lastPageName = lastPage.getText();
  		int index = lastPageName.lastIndexOf(".");
  		lastPageName = lastPageName.substring(index+1, lastPageName.length());
  		for(int i=0;i<Integer.parseInt(lastPageName);i++)
  		{  			
  			List<WebElement> levelNames = factory.getElements("PartnerLocator_PartnerLevels");
  			for(WebElement levelName : levelNames)
  			{
  				firstPartnerLevel = levelName.getText();
  				if(!firstPartnerLevel.equals(prevPartnerLevel) && !prevPartnerLevel.equals(""))
  				{
  					partnerLevels.remove(prevPartnerLevel);  					  					
  				}
  				if(!partnerLevels.contains(firstPartnerLevel))
  				{
  					screenshots.takeScreenShots();
  					Assert.fail("Partner Details are not sorted by Partner Level"); 
  				}
  				prevPartnerLevel = firstPartnerLevel;                             				
  			}  			
  			userActions.clickOn("PartnerLocator_NextButton");
   		}  		
  		
  	}

  	
  	/**
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 07/08/2014 
	  Date of Modified                  : 
	  Methods Called                    : 
	  Purpose of Method                 : To verify Partner Details are dispalyed in Distance sorted order
	  Dependencies	                    : --
	  Reviewed By                       : 
	**/	
  	public void verifySort(String order, String controlName)
  	{
  		WebElement lastPage = factory.getElement("PartnerLocator_LastPageName");
  		String lastPageName = lastPage.getText();
  		int index = lastPageName.lastIndexOf(".");
  		lastPageName = lastPageName.substring(index+1, lastPageName.length());
  		for(int i=0;i<Integer.parseInt(lastPageName);i++)
  		{
  			List<WebElement> elements = factory.getElements(controlName);
  			List<Double> childElements = new ArrayList<Double>();
  			List<Double> sortList = new ArrayList<Double>();
  			for(WebElement element : elements)
  			{
  				String value = element.getText();
  				int firstIndex = value.indexOf(" ");
  				int lastIndex = value.lastIndexOf(" ");
  				String valueOfDistance = value.substring(firstIndex, lastIndex);
  				childElements.add(Double.parseDouble(valueOfDistance));
  			}
  			sortList.addAll(childElements);
  			if("ascending".equals(order))
  			{
  				Collections.sort(sortList);
  			}
  			else
  			{
  				Collections.sort(sortList);
  				Collections.reverse(sortList);
  			} 		 		
  			if(!sortList.equals(childElements))
  			{
  				screenshots.takeScreenShots();
				Assert.fail("Not in sorted order");  
  			}
  			userActions.clickOn("PartnerLocator_NextButton");
  		}
  	}
  	
  	/**
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 11/08/2014 
	  Date of Modified                  : 
	  Methods Called                    : 
	  Purpose of Method                 : To compare values present in Database
	  Dependencies	                    : --
	  Reviewed By                       : 
	**/	
  	public void compareValuesPresentInDatabase(String listName,ResultSet rs,String columnName){    		
  		List<WebElement> elements = factory.getElements(listName);
  		List<String> values = new ArrayList<String>();
  		List<String> queryValues = new ArrayList<String>();
  		for(WebElement element : elements){
  			values.add(element.getText());
  		}
  		try {
			while(rs.next()){
				queryValues.add(rs.getString(columnName));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  		  		if(!values.equals(queryValues)){
  			screenshots.takeScreenShots();
			Assert.fail("Values displayed in "+columnName+" and database is not same"); 
  		}
  	}
  	
  	/**
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 10-09-2014
	  Date of Modified                  : 
	  Methods Called                    : 
	  Purpose of Method                 : To compare values present in Database
	  Dependencies	                    : --
	  Reviewed By                       : 
  	 **/	
  	public void validateEmailPresentInDatabase(String listName,ResultSet rs,String columnName){    		
  		WebElement element = factory.getElement(listName);
  		try {
  			while(rs.next()){
  				if(rs.getString(columnName) != null){
  					assertions.str_Assertequals(element.getText(), "Send Email");
  				}
  			}
  		} catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
  	}
  	
  	
  	/**
	  Author Name                       : Niharika K R
	  Date of Preparation               : 07/08/2014 
	  Date of Modified                  : 
	  Methods Called                    : 
	  Purpose of Method                 : To verify Partner Details Popup is closed
	  Dependencies	                    : --
	  Reviewed By                       : 
	**/	
  	public void verifyAutoPopUpClose()
    {
  		List<WebElement> arrowElements = factory.getElements("PartnerLocator_DetailsArrow");
  		arrowElements.get(0).click();
  		WebElement firstTitleElement = factory.getElement("PopUpTitle");
  		String firstTitle = firstTitleElement.getText();
  		arrowElements.get(1).click();
  		WebElement secondTitleElement = factory.getElement("PopUpTitle");
  		String secondTitle = secondTitleElement.getText();
  		if(firstTitle.equals(secondTitle))
  		{
  			screenshots.takeScreenShots();
  			Assert.fail("The First pop up is not yet closed");
  		}
    }


  	/**
	  Author Name                       : Sindhuja.P 
	  Date of Preparation               : 12/08/2014 
	  Date of Modified                  : --
	  Methods Called                    : getElements(String controlName)
	  Purpose of Method                 : To check if the distance is displayed below the partner title with respective units.
	  Dependencies	                    : --
	  Reviewed By                       : 
	**/	
  	public void checkDistanceUnits(String distanceUnits)
  	{
  		WebElement lastPage = factory.getElement("PartnerLocator_LastPageName");
  		String lastPageName = lastPage.getText();
  		int index = lastPageName.lastIndexOf(".");
  		lastPageName = lastPageName.substring(index+1, lastPageName.length());
  		for(int i=0;i<Integer.parseInt(lastPageName);i++)
  		{
  			List<WebElement> distanceElements = factory.getElements("PartnerLocator_DistanceValues");
  			List<WebElement> titleElements = factory.getElements("PartnerLocator_PartnerTitle");
			 int count = 0;
			 for (WebElement distanceElement : distanceElements)
  			{
				 WebElement titleElement =  titleElements.get(count);
				 if(!distanceElement.getText().contains(distanceUnits))
  				{
  					screenshots.takeScreenShots();
  					Assert.fail("The data displayed does not contain the units in "+distanceUnits);  
  				}
				 if(titleElement.getLocation().y > distanceElement.getLocation().y)
  				{
  					screenshots.takeScreenShots();
  					Assert.fail("The data displayed contains the units in "+distanceUnits+"but the distance units are not displayed under Partners title");
  				}
				 count++;
  			}
  			userActions.clickOn("PartnerLocator_NextButton");
  		}
  	}
  	
  	/**
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 12/08/2014 
	  Date of Modified                  : 
	  Methods Called                    : 
	  Purpose of Method                 : To verify the value selected in drop down
	  Dependencies	                    : --
	  Reviewed By                       : 
	**/	
  	public void verifyDropDownSelection(String dropDown, String valueToBeSelected){
  		userActions.clickOn(dropDown);
  		dynamicWait.waittillpageloads();
  		String selectionValue = userActions.getText(valueToBeSelected);
  		userActions.clickOn(valueToBeSelected);
  		dynamicWait.waittillpageloads();
  		String valueSelected = userActions.getText(dropDown);
  		assertions.str_Assertequals(valueSelected, selectionValue);
  	}
  	
  	/**
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 12/08/2014 
	  Date of Modified                  : 
	  Methods Called                    : 
	  Purpose of Method                 : To verify the value entered in text field
	  Dependencies	                    : --
	  Reviewed By                       : 
	**/	
  	public void verifyTextEntered(String textField, String enteredText){
  		userActions.enterText(textField, enteredText);
  		dynamicWait.waittillpageloads();
  		WebElement element = factory.getElement(textField);
  		String textfieldValue = element.getAttribute("value");
  		assertions.str_Assertequals(textfieldValue, enteredText);
  	}  	
  	
  	
  	/**
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 20/08/2014 
	  Date of Modified                  : 02-09-2014
	  Methods Called                    : 
	  Purpose of Method                 : verify the navigated article page
	  Arguments							: articles - This argument will take the list of the article Names present in the page,
	  									articleHeader - This argument will take the Header controlName in the article landing page
	  Dependencies	                    : --
	  Reviewed By                       : 
	**/	
  	public void verifyArticleNavigation(String articles, String articleHeader){
  		List<WebElement> article = factory.getElements(articles);
  		String articleName = article.get(0).getText();
  		if(articleName.lastIndexOf("(") != -1){
  			articleName = articleName.substring(0, articleName.lastIndexOf("(")).trim();
  		}
  		dynamicWait.waittillpageloads();
  		article.get(0).click();
  		dynamicWait.waittillpageloads();
  		scrollDown();
  		WebElement header = factory.getElement(articleHeader);
  		String headerText = header.getText();
  		assertions.str_Assertequals(headerText, articleName);
  	}
  	
  	/**
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 18/08/2014 
	  Date of Modified                  : 20/08/2014
	  Methods Called                    : 
	  Purpose of Method                 : To check the presence of tick mark in required row and column.
	  Dependencies	                    : --
	  Reviewed By                       : 
	  Modified By                       : Sindhuja P
	**/	
	
	public void verifyTickMark(String solution, String columnName,
			String expertValue) {
		List<WebElement> tableRows = factory
				.getElements("PartnerLocator_Table");
		for (WebElement row : tableRows) {
			if (row.getText().contains(solution)) {
				List<WebElement> columns = factory.getChildElements(row,
						"Table_Column");
				if ("Authorized".equalsIgnoreCase(columnName)) {
					WebElement authorizedColumn = columns.get(1);
					List<WebElement> tickElements = factory
							.verifyContainsChildElements(authorizedColumn,
									"CaseStudies_SocialIcons_Child");
					if (tickElements.get(0).getAttribute("class")
							.equals("fa fa-check")) {
						verify.verifyIcons(authorizedColumn, "TickMarkIcon.JPG");
					} else {
						screenshots.takeScreenShots();
						Assert.fail("The tick mark is not present under the "
								+ columnName + "beside the solution "
								+ solution);
					}
				} else {
					WebElement expertBadgeColumn = columns.get(2);
					List<WebElement> tickElements = factory
							.verifyContainsChildElements(expertBadgeColumn,
									"CaseStudies_SocialIcons_Child");
					if (tickElements.get(0).getAttribute("class")
							.equals("fa fa-check")) {
						verify.verifyIcons(expertBadgeColumn,
								"TickMarkIcon.JPG");
						if (!expertBadgeColumn.getText().equals(expertValue)) {
							screenshots.takeScreenShots();
							Assert.fail("The text "
									+ expertValue
									+ "is not present beside the tick mark under the "
									+ columnName + " beside the solution "
									+ solution);
						}
					} else {
						screenshots.takeScreenShots();
						Assert.fail("The tick mark is not present under the "
								+ columnName + "beside the solution "
								+ solution);
					}
				}
			}
		}
	}
  	
  	
  	/**
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 21/08/2014 
	  Date of Modified                  : 10-09-2014
	  Methods Called                    : 
	  Purpose of Method                 : To compare ticks displayed in the popup from Database
	  Dependencies	                    : --
	  Reviewed By                       : 
	 **/	
	public void verifyTickFromDatabase(ResultSet rs){    		
		List<String> solutionNames = split(dataMap.get("PartnerLocator_SolutionNames"),",");
		List<String> dbColumnNames = split(dataMap.get("PartnerLocator_DBColumnNames"),",");

		try {			
			while(rs.next()){
					List<WebElement> tableRows = factory.getElements("PartnerLocator_Table");
					int i=0;
					for(WebElement row : tableRows)
					{
						List<WebElement> columns = factory.getChildElements(row, "Table_Column");
						int index = solutionNames.indexOf(columns.get(0).getText());
						if(-1 != index)
						{
							WebElement authorizedColumn = columns.get(1);
							List<WebElement> tickElements = factory.verifyContainsChildElements(authorizedColumn, "CaseStudies_SocialIcons_Child");
							if(tickElements.get(0).getAttribute("class").equals("fa fa-check"))
							{  						
								verify.verifyIcons(authorizedColumn, "TickMarkIcon.JPG");
								if(0 == rs.getInt(dbColumnNames.get(index))){
									screenshots.takeScreenShots();
				  					Assert.fail("The tick mark is present for the Solution "+solutionNames.get(index)+" but its not matching with the database");
								}
							}else{
								verify.verifyIconsNotPresent(authorizedColumn, "TickMarkIcon.JPG");
								if(1 == rs.getInt(dbColumnNames.get(index))){
									screenshots.takeScreenShots();
									Assert.fail("The tick mark is not present for the Solution "+solutionNames.get(index)+" but its not matching with the database");
								}								
							}
						}else{
							screenshots.takeScreenShots();
		  					Assert.fail("In Partner Locator Popup Table "+columns.get(0).getText()+" details should not be displayed");
						}
						i++;
				}				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	/** 
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 25/08/2014
	  Date of Modified                  : 
	  Methods Called                    : getElements(WebElementFactory)
	  Purpose of Method                 : 
	  Dependencies	                    : --
	  Reviewed By                       : --	  
	 * @throws InterruptedException 
	**/
	public void verifyMenuOrCategoryLinks(String controlName){
		List<WebElement> elements = factory.getElements(controlName);
		if(elements.size() == 0){
			screenshots.takeScreenShots();
			Assert.fail("Menu/Category does not contain any child Nodes");							
		}
		for(WebElement element : elements){
			System.out.println(element.getText());
			//assertions.assertNotNull(element);
			if(!element.getTagName().equals("a")){
				List<WebElement> childElements = factory.getChildElements(element, "Tag_Anchors");
				if(childElements.size() == 1){
					verify.verifyHttpResponse(childElements.get(0));
				}else if(childElements.size() == 0){
					screenshots.takeScreenShots();
					Assert.fail("Menu/Category does not contain any child Nodes");				
				}
			}else{
				verify.verifyHttpResponse(element);
			}
		}
	}
	
	/** 
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 25/08/2014
	  Date of Modified                  : 
	  Methods Called                    : getElements(WebElementFactory)
	  Purpose of Method                 : 
	  Dependencies	                    : --
	  Reviewed By                       : --	  
	 * @throws InterruptedException 
	**/
	public void verifyLinks(WebElement element){

			if(!element.getTagName().equals("a")){
				List<WebElement> childElements = factory.getChildElements(element, "Tag_Anchors");
				if(childElements.size() == 1){
					verify.verifyHttpResponse(childElements.get(0));
				}else if(childElements.size() == 0){
					screenshots.takeScreenShots();
					Assert.fail("Menu/Category does not contain any child Nodes");				
				}
			}else{
				verify.verifyHttpResponse(element);
			}
		}
	
	/** 
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 26/08/2014
	  Date of Modified                  : 
	  Methods Called                    : getElements(WebElementFactory)
	  Purpose of Method                 : 
	  Dependencies	                    : --
	  Reviewed By                       : --	  
	 * @throws InterruptedException 
	**/
	public void contentValidation(String controlName){
		List<WebElement> elements = factory.getElements(controlName);
		for(WebElement element : elements){	
			if(element.isDisplayed()){
			assertions.assertNotNull(element);
		}
		}
	}
	
	/** 
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 26/08/2014
	  Date of Modified                  : 
	  Methods Called                    : getElements(WebElementFactory)
	  Purpose of Method                 : 
	  Dependencies	                    : --
	  Reviewed By                       : --	  
	 * @throws InterruptedException 
	**/
	public void verifyPods(String podsControlName){
		List<WebElement> podsElement = factory.getElements(podsControlName);
		for(WebElement podElement : podsElement){
			List<WebElement> imgElements = factory.getChildElements(podElement, "Tag_Image");
			if(imgElements.size() == 0){
				screenshots.takeScreenShots();
				Assert.fail("Image Element is not present in Pod");								
			}
			if(imgElements.size() > 3){
				screenshots.takeScreenShots();
				Assert.fail("Image Element cannot be more than 3 in a Pod");								
			}
			
			for(WebElement img : imgElements){
				Dimension dimension = img.getSize();			
				if(dimension.getHeight() == 0 || dimension.getWidth() == 0){
					screenshots.takeScreenShots();
					Assert.fail("Image Element is not present in Pod");								
				}				
				verify.verifyHttpResponse(img);
			}
			
			List<WebElement> podTextElements = factory.getChildElements(podElement, "CareersPodText");
			assertions.assertNotNull(podTextElements.get(0));
			verify.isElementDisplayed(podTextElements.get(0));
		}
	}

	/** 
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 27/08/2014
	  Date of Modified                  : 05-09-2014
	  Methods Called                    : getElements(WebElementFactory)
	  Purpose of Method                 : 
	  Dependencies	                    : --
	  Reviewed By                       : --	  
	 * @throws InterruptedException 
	**/
	public void imageValidation(String imageControlName){
		List<WebElement> imageElements = factory.getElements(imageControlName);
		if(imageElements.size() == 0){
			screenshots.takeScreenShots();
			Assert.fail("Image Element is not present in Pod");								
		}
		for(WebElement imageElement : imageElements){
			Dimension dimension = imageElement.getSize();			
			if(dimension.getHeight() == 0 || dimension.getWidth() == 0){
				screenshots.takeScreenShots();
				Assert.fail("Image Element is not present in Pod");								
			}
			verify.verifyHttpResponse(imageElement);			
		}
	}

	/** 
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 27/08/2014
	  Date of Modified                  : 05-09-2014
	  Methods Called                    : getElements(WebElementFactory)
	  Purpose of Method                 : 
	  Dependencies	                    : --
	  Reviewed By                       : --	  
	 * @throws InterruptedException 
	**/
	public void imageValidation(WebElement imageElement){
		
	
		
			Dimension dimension = imageElement.getSize();			
			if(dimension.getHeight() == 0 || dimension.getWidth() == 0){
				screenshots.takeScreenShots();
				Assert.fail("Image Element is not present in Pod");								
			verify.verifyHttpResponse(imageElement);			
		}
	}

	/** 
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 27/08/2014
	  Date of Modified                  : 05-09-2014
	  Methods Called                    : getElements(WebElementFactory)
	  Purpose of Method                 : 
	  Dependencies	                    : --
	  Reviewed By                       : --	  
	 * @throws InterruptedException 
	**/
	public void imageValidationAvayaLogo(String imageControlName){
		List<WebElement> imageElements = factory.getElements(imageControlName);
		if(imageElements.size() == 0){
			screenshots.takeScreenShots();
			Assert.fail("Image Element is not present in Pod");								
		}
		for(WebElement imageElement : imageElements){
			
			verify.verifyHttpResponse(imageElement);			
		}
	}
	
	public void verifyMinimumCountOfElements(String controlName, int count)
	{
		List<WebElement> elements = factory.getElements(controlName);
		if(!(elements.size()>=count))
		{
			screenshots.takeScreenShots();
			Assert.fail("Test failed since the elements with "+controlName+"in the page should not be less than - Expected Value :"+count+"Actual value: "+elements.size());
		}		
	}	
	/** 
	  Author Name                       : Vinusha
	  Date of Preparation               : 28/08/2014
	  Date of Modified                  : 
	  Methods Called                    : getOptionalElements(WebElementFactory)
	  Purpose of Method                 : Verify Pods in Partners
	  Dependencies	                    : --
	  Reviewed By                       : --	  
	**/
	
	public void verifyPartnerAndProductPods(String controlName, String Child) {
		List<WebElement> podData = factory.getOptionalElements(controlName);
		if (podData.size() > 0) {
			for (WebElement eachPod : podData) {
				if (eachPod.getText().isEmpty()) {
					screenshots.takeScreenShots();
					Assert.fail("There is no Text in the Partner Landing Page Pods ");
				} else {
					List<WebElement> podLinks = factory.verifyContainsChildElements(
							eachPod, Child);
					for (WebElement eachPodLink : podLinks) {
						verify.verifyHttpResponse(eachPodLink);
					}
				}
			}
		}

	}
	

	
	/** 
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 02/09/2014
	  Date of Modified                  : 
	  Methods Called                    : getElements(WebElementFactory)
	  Purpose of Method                 : 
	  Dependencies	                    : --
	  Reviewed By                       : --	  
	 * @throws InterruptedException 
	**/
	public void verifyArticlesInPerspective(String controlName){
		List<WebElement> articles = factory.getElements(controlName);
		for(WebElement article : articles){
			List<WebElement> image = factory.verifyContainsChildElements(article, "Tag_Image");
			List<WebElement> category = factory.verifyContainsChildElements(article, "CategoryClass");
			List<WebElement> title = factory.verifyContainsChildElements(article, "TitleClass");
			List<WebElement> topics = factory.verifyContainsChildElements(article, "TopicsClass");
			//List<WebElement> date = factory.verifyContainsChildElements(article, "PublishedDateClass");
			
			if(title.size() == 0){
				screenshots.takeScreenShots();
				Assert.fail("Title is not displayed for Article on Perspective Page ");				
			}else if(title.size() > 1){
				screenshots.takeScreenShots();
				Assert.fail("Only one Title should be displayed for Article on Perspective Page ");
			}else{
				assertions.assertNotNull(title.get(0));
			}
			
			if(image.size() == 0){
				screenshots.takeScreenShots();
				Assert.fail("Image is not displayed for "+title.get(0).getText()+" Articles on Perspective Page ");				
			}else if(image.size() > 1){
				screenshots.takeScreenShots();
				Assert.fail("Only one Image should be displayed for "+title.get(0).getText()+" Articles on Perspective Page ");
			}else{
				verify.verifyHttpResponse(image.get(0));
			}
			
			if(category.size() == 0){
				screenshots.takeScreenShots();
				Assert.fail("Category is not displayed for "+title.get(0).getText()+" Article on Perspective Page ");				
			}else if(category.size() > 1){
				screenshots.takeScreenShots();
				Assert.fail("Only one Category should be displayed for "+title.get(0).getText()+" Article on Perspective Page ");
			}else{
				assertions.assertNotNull(category.get(0));
			}
			
			if(topics.size() == 0){
				screenshots.takeScreenShots();
				Assert.fail("Topics are not displayed for "+title.get(0).getText()+" Article on Perspective Page ");				
			}else if(topics.size() > 0){
				List<WebElement> listOfTopics = factory.getChildElements(topics.get(0), "Tag_List");
				for(WebElement topic : listOfTopics){
					assertions.assertNotNull(topic);
				}
			}
			
			/*if(date.size() == 0){
				screenshots.takeScreenShots();
				Assert.fail("Date is not displayed for "+title.get(0).getText()+" Article on Perspective Page ");				
			}else if(date.size() > 1){
				screenshots.takeScreenShots();
				Assert.fail("Only one Date should be displayed for "+title.get(0).getText()+" Articles on Perspective Page ");
			}else{
				List<String> actualDates = new ArrayList<String>();
				actualDates.add(date.get(0).getText());
				stringToDate(actualDates);				
			}*/
		}
	}
	
	/** 
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 03/09/2014
	  Date of Modified                  : 
	  Methods Called                    : getElements(WebElementFactory)
	  Purpose of Method                 : 
	  Dependencies	                    : --
	  Reviewed By                       : --	  
	 * @throws InterruptedException 
	**/
	public void verifyDateOrTime(String controlName){
		List<WebElement> elements = factory.getElements(controlName);
		for(WebElement dateOrTime : elements){
			System.out.println("date "+dateOrTime.getText());
			if(!dateOrTime.getText().matches("([0-9]{1,2})\\s?([a-zA-Z]{1,3})")){
				screenshots.takeScreenShots();
				Assert.fail("Date or Time displayed is not in correct format");				
			}
		}
	}
	
	/** 
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 09/09/2014
	  Date of Modified                  : 
	  Methods Called                    : getElements(WebElementFactory)
	  Purpose of Method                 : 
	  Dependencies	                    : --
	  Reviewed By                       : --	  
	 * @throws InterruptedException 
	**/
	public void verifyPerspectiveMagazinePage(String controlName){
		List<WebElement> articles = factory.getElements(controlName);
		for(WebElement article : articles){
			List<WebElement> images = factory.getChildElements(article, "Tag_Image");
			List<WebElement> date = factory.getChildElements(article, "Perspectives_Article_Date");
			List<WebElement> title = factory.getChildElements(article, "Tag_Anchors");
			List<WebElement> content = factory.getChildElements(article, "Perspectives_Magazines_Pagination_Third");
			System.out.println(content.size());
			List<WebElement> description = factory.getChildElements(content.get(0), "Tag_Div");
			System.out.println(description.size());
			System.out.println(description);
			if(images.size() == 0){
				screenshots.takeScreenShots();
				Assert.fail("Image Element is not present in Article");								
			}else if(images.size() > 1){
				screenshots.takeScreenShots();
				Assert.fail("Image Element cannot be more than 1 in a Article");								
			}else{
				Dimension dimension = images.get(0).getSize();			
				if(dimension.getHeight() == 0 || dimension.getWidth() == 0){
					screenshots.takeScreenShots();
					Assert.fail("Image Element is not present in Article");								
				}
				verify.verifyHttpResponse(images.get(0));
			}
			
			if(description.size() == 0){
				screenshots.takeScreenShots();
				Assert.fail("Description Element is not present in Article");																		
			}else{
				assertions.assertNotNull(description.get(0));
			}
			
			if(title.size() == 0){
				screenshots.takeScreenShots();
				Assert.fail("Title Element is not present in Article");								
			}else if(title.size() > 1){
				screenshots.takeScreenShots();
				Assert.fail("Title Element cannot be more than 1 in a Article");								
			}else{
				assertions.assertNotNull(title.get(0));
				verify.verifyHttpResponse(title.get(0));
			}
			
			if(date.size() == 0){
				screenshots.takeScreenShots();
				Assert.fail("Date is not displayed for "+title.get(0).getText()+" Article on Perspective Magazine Page ");				
			}else if(date.size() > 1){
				screenshots.takeScreenShots();
				Assert.fail("Only one Date should be displayed for "+title.get(0).getText()+" Articles on Perspective Magazine Page ");
			}else{
				List<String> actualDates = new ArrayList<String>();
				actualDates.add(date.get(0).getText());
				stringToDate(actualDates);				
			}			
		}
	}
	
	/** 
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 10-09-2014
	  Date of Modified                  : 
	  Methods Called                    : getElements(WebElementFactory)
	  Purpose of Method                 : 
	  Dependencies	                    : --
	  Reviewed By                       : --	  
	 * @throws InterruptedException 
	**/
	public void validateReadTheArticleLink(String controlName){
		List<WebElement> element = factory.getElementNotPresent(controlName);
		if(element.size()>0){
			userActions.clickOn("ReadTheArticleLink");
			dynamicWait.waittillpageloads();
			try {
				Thread.sleep(25000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//userActions.get().clickOn("SkipAd");
			userActions.clickOn("ReadTheArticleLinkHeader");
			verify.isElementDisplayed("ReadTheArticleLinkHeader");
		}
	}
	
	/** 
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 10/09/2014
	  Date of Modified                  : 
	  Methods Called                    : getElements(WebElementFactory)
	  Purpose of Method                 : 
	  Dependencies	                    : --
	  Reviewed By                       : --	  
	 * @throws InterruptedException 
	**/
	public void verfiyBrandCampaignPods(String controlName){
		List<WebElement> pods = factory.getElements(controlName);
		for(WebElement pod : pods){
			List<WebElement> images = factory.getChildElements(pod, "Tag_Image");
			List<WebElement> title = factory.getChildElements(pod, "Tag_Header");
			List<WebElement> description = factory.getChildElements(pod, "Tag_Paragraphs");
			List<WebElement> cta = factory.getChildElements(pod, "BrandCampaign_cta");
			
			if(images.size() == 0){
				screenshots.takeScreenShots();
				Assert.fail("Image Element is not present in Article");								
			}else if(images.size() > 1){
				screenshots.takeScreenShots();
				Assert.fail("Image Element cannot be more than 1 in a Article");								
			}else{
				Dimension dimension = images.get(0).getSize();			
				if(dimension.getHeight() == 0 || dimension.getWidth() == 0){
					screenshots.takeScreenShots();
					Assert.fail("Image Element is not present in Article");								
				}
				verify.verifyHttpResponse(images.get(0));
			}
			
			if(title.size() == 0){
				screenshots.takeScreenShots();
				Assert.fail("Title Element is not present in Article");								
			}else if(title.size() > 1){
				screenshots.takeScreenShots();
				Assert.fail("Title Element cannot be more than 1 in a Article");								
			}else{
				assertions.assertNotNull(title.get(0));
				verifyLinks(title.get(0));
			}
			
			if(description.size() == 0){
				screenshots.takeScreenShots();
				Assert.fail("Description Element is not present in Article");																		
			}else{
				assertions.assertNotNull(description.get(0));
			}
			
			if(cta.size() == 0){
				screenshots.takeScreenShots();
				Assert.fail("Title Element is not present in Article");								
			}else if(cta.size() > 1){
				screenshots.takeScreenShots();
				Assert.fail("Title Element cannot be more than 1 in a Article");								
			}else{
				assertions.assertNotNull(cta.get(0));
				verifyLinks(title.get(0));
			}			
		}
	}
	
	/** 
	  Author Name                       : Sindhuja P
	  Date of Preparation               : 11/9/2014
	  Date of Modified                  : --
	  Methods Called                    :
	  Purpose of Method                 : To verify the link is navigating to the correct url or not using href attribute
	  Dependencies	                    : --
	  Reviewed By                       : --
	**/
	
	public void verifyLinksAndNavigatedUrl(String controlName)
	{
		List<WebElement> elements = factory.getElements(controlName);
		for (int index=0;index<elements.size();index++)
		{
			elements = factory.getElements(controlName);
			String hrefValue = elements.get(index).getAttribute("href");
			elements.get(index).click();
			dynamicWait.waittillpageloads();
			String currentUrl = driver.getCurrentUrl();
			if(!currentUrl.contains(hrefValue))
			{
				screenshots.takeScreenShots();
				Assert.fail("Expected PDF filename is "+hrefValue+" .But actual PDF file opened is "+currentUrl);
			}
			driver.navigate().back();
			dynamicWait.waittillpageloads();
		}
	}
	
	/** 
	  Author Name                       : P Dhana Lakshmi
	  Date of Preparation               : 10/06/2015
	  Date of Modified                  : --
	  Methods Called                    :
	  Purpose of Method                 : To verify pdf url using href attribute
	  Dependencies	                    : --
	  Reviewed By                       : --
	**/
	
	public void verifyPdfUrl(String controlName)
	{
		List<WebElement> elements = factory.getElements(controlName);
		for (int index=0;index<elements.size();index++)
		{
			elements = factory.getElements(controlName);
			String hrefValue = elements.get(index).getAttribute("href");
			verify.verifyHttpResponse(elements.get(index));
			String containsUrl=dataMap.get(controlName);
			if(!hrefValue.contains(containsUrl))
			{
				screenshots.takeScreenShots();
				Assert.fail("Link is not navigated to any PDF");
			}
			}
	}
	
	/** 
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 11/9/2014
	  Date of Modified                  : --
	  Methods Called                    :
	  Purpose of Method                 : To verify whether the given element is clickable or not
	  Dependencies	                    : --
	  Reviewed By                       : --
	**/
	public void verifyImagesClickable(String controlName)
	{
		List<WebElement> elements = factory.getElements(controlName);
		for (WebElement element : elements) {
			WebElement parent = element.findElement(By.xpath(".."));
			String parentTag = parent.getTagName();
			if(!"a".equals(parentTag)){
				screenshots.takeScreenShots();
				Assert.fail("The "+controlName+ " is not clickable");
			}
		}
		
	}
	
	/** 
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 15/09/2014
	  Date of Modified                  : 
	  Methods Called                    : getElements(WebElementFactory)
	  Purpose of Method                 : 
	  Dependencies	                    : --
	  Reviewed By                       : --	  
	 * @throws InterruptedException 
	**/
	public void verfiyEventPods(String controlName, String expectedBreadcrumb){
		WebElement element = factory.getElement(controlName);
		WebElement title = factory.getChildElement(element, "Tag_Header");
		assertions.str_Assertequals(title.getText(), dataMap.get(controlName));
		
		List<WebElement> eventElements = factory.getChildElements(element, "EventPage_Events");
		if(eventElements.size() > 3){
			WebElement seeAllElement = factory.getChildElement(element, "EventPage_SeeAll");
			assertions.assertNotNull(seeAllElement);
			seeAllElement.click();
			dynamicWait.waittillpageloads();
			
			WebElement seeAllPageTitle = factory.getElement("EventPage_SeeAllPage_Title");
			assertions.str_Assertequals(seeAllPageTitle.getText(), dataMap.get(controlName));
			verifyBreadCrumb("Breadcrumb_Actual", expectedBreadcrumb, "Tag_Anchors");
			verify.isElementDisplayed("SocialIcons");
			
		}
	}
	
	/** 
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 15/09/2014
	  Date of Modified                  : 
	  Methods Called                    : getElements(WebElementFactory)
	  Purpose of Method                 : 
	  Dependencies	                    : --
	  Reviewed By                       : --	  
	 * @throws InterruptedException 
	**/
	public void verifyImageForPinterest(){
		List<WebElement> parentElement = factory.getOptionalElements("ImagesParentElement_PInterest");
		if(parentElement.size() == 0){
			screenshots.takeScreenShots();
			Assert.fail("Cannot Share in Pinterest as there is no Element with a 'photo' class");
		}
		
		List<WebElement> images = factory.verifyContainsChildElements(parentElement.get(0), "Tag_Image");
		if(images.size() == 0){
			screenshots.takeScreenShots();
			Assert.fail("Cannot Share in Pinterest as there is no Image enclosed within a 'photo' class Element");
		}						
	}
	
	/** 
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 16/09/2014
	  Date of Modified                  : 
	  Methods Called                    : getElements(WebElementFactory)
	  Purpose of Method                 : 
	  Dependencies	                    : --
	  Reviewed By                       : --	  
	 * @throws InterruptedException 
	**/
	public void verifyResultsPerPage(){
		List<WebElement> articles = factory.getOptionalElements("NewsRoom_NoArticles");
		if(articles.size() == 0){
			WebElement resultsTextElement = factory.getElement("Pagination_Count");
			String resultsText = resultsTextElement.getText().substring(resultsTextElement.getText().indexOf("F")+2, resultsTextElement.getText().lastIndexOf(" "));
			int TotalCount = Integer.parseInt(resultsText);
			List<WebElement> newsItems;
			if(TotalCount < 10){
				newsItems = factory.getElements("NewsRoom_NewsItems");
				resultsTextElement = factory.getElement("Pagination_Count");
				assertions.str_Assertequals(resultsTextElement.getText(), "SHOWING 1-"+TotalCount+" OF "+TotalCount+" RESULTS");
				assertions.int_Assertequals(newsItems.size(), TotalCount);				
				Reporter.log("Warning: In the NewsRoom Page, Total No. of records displayed are less than 10");
			}else{
				newsItems = factory.getElements("NewsRoom_NewsItems");
				resultsTextElement = factory.getElement("Pagination_Count");
				assertions.str_Assertequals(resultsTextElement.getText(), "SHOWING 1-10 OF "+TotalCount+" RESULTS");
				assertions.int_Assertequals(newsItems.size(), 10);
				if(TotalCount > 10){
					userActions.clickOn("NewReleaseTwentyFiveClick");
			    	dynamicWait.waittillpageloads();
			    	if(TotalCount < 25){
			    		newsItems = factory.getElements("NewsRoom_NewsItems");
			    		resultsTextElement = factory.getElement("Pagination_Count");
			    		assertions.str_Assertequals(resultsTextElement.getText(), "SHOWING 1-"+TotalCount+" OF "+TotalCount+" RESULTS");
			    		assertions.int_Assertequals(newsItems.size(), TotalCount);				
			    		Reporter.log("Warning: In the NewsRoom Page, Total No. of records displayed are less than 25");			    	
			    	}else{
			    		newsItems = factory.getElements("NewsRoom_NewsItems");
			    		resultsTextElement = factory.getElement("Pagination_Count");
			    		assertions.str_Assertequals(resultsTextElement.getText(), "SHOWING 1-25 OF "+TotalCount+" RESULTS");
			    		assertions.int_Assertequals(newsItems.size(), 25);
			    		if(TotalCount > 25){
			    			userActions.clickOn("NewReleaseFiftyClick");
			    			dynamicWait.waittillpageloads();
			    		}
			    		if(TotalCount < 50){
			    			newsItems = factory.getElements("NewsRoom_NewsItems");
			    			resultsTextElement = factory.getElement("Pagination_Count");
			    			assertions.str_Assertequals(resultsTextElement.getText(), "SHOWING 1-"+TotalCount+" OF "+TotalCount+" RESULTS");
			    			assertions.int_Assertequals(newsItems.size(), TotalCount);				
			    			Reporter.log("Warning: In the NewsRoom Page, Total No. of records displayed are less than 50");			    	
			    		}else{
			    			newsItems = factory.getElements("NewsRoom_NewsItems");
			    			resultsTextElement = factory.getElement("Pagination_Count");
			    			assertions.str_Assertequals(resultsTextElement.getText(), "SHOWING 1-50 OF "+TotalCount+" RESULTS");
			    			assertions.int_Assertequals(newsItems.size(), 50);			    			
			    		}
			    	}
				}
			}
		}else{
			Reporter.log("Warning: In the NewsRoom Page, "+articles.get(0).getText());
		}
	}
	
	public void verifyPresenceOfCommasInCategory(String controlName)
	{
		List<WebElement> elements = factory.getElements(controlName);
		
		for (WebElement element : elements) {
		List<WebElement> listElements = factory.getChildElements(element, "Tag_List");	
		if(listElements.size()>1)
		{
			System.out.println(listElements.size());
			String delimeter = userActions.getCssProperty(listElements.get(0), "content");
			System.out.println(listElements.get(0).getText());
			System.out.println("delimeter"+delimeter);
			if(!(delimeter==", "))
			{
				screenshots.takeScreenShots();
				Assert.fail("The category list is not separated by commas");
			}
		}
		}
	}
	
	/** 
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 15/9/2014
	  Date of Modified                  : --
	  Methods Called                    :
	  Purpose of Method                 : To verify whether the date format is MMM YYYY
	  Dependencies	                    : --
	  Reviewed By                       : --
	**/
	
	public void verifyDateFormat(String controlName)
	{
		List<WebElement> elements = factory.getElements(controlName);
		if (elements.size() > 0) {
			for (int i = 0; i < elements.size(); i++) {
				if (!(elements.get(i).getText()
						.matches("([a-zA-Z]{3})\\s([0-9]{4})"))) {
					screenshots.takeScreenShots();
					Assert.fail("The date format is incorrect.It should be in MMM YYYY format");
				}
			}
		}
	}
	
	/** 
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 15/9/2014
	  Date of Modified                  : --
	  Methods Called                    :
	  Purpose of Method                 : To verify whether the dates are displayed in the descending order
	  Dependencies	                    : --
	  Reviewed By                       : --
	**/
	
	public void verifyDatesInDescendingOrder(String controlName)
	{
		int count=0;
		List<WebElement> resourceDateList = factory.getElements(controlName);
		List<String> listOfDate = new ArrayList<String>();
		for(WebElement date : resourceDateList)
		{
			listOfDate.add(date.getText());
		}
		List<Date> dateList = stringToDate(listOfDate);
	    List<Date> descendingOrder=dateList;
	    Collections.sort(dateList, Collections.reverseOrder());
	    for(int i=0;i<dateList.size();i++)
	     {
	        if(descendingOrder.get(i)!=dateList.get(i))
	          {
	             count++;
	          }
	      }
	      if(count!=0)
	      {
	        Assert.fail("Dates are not in descending order");
	      }
	}
	
	/** 
	  Author Name                       : Phanendra 
	  Date of Preparation               : 15/09/2014 
	  Date of Modified                  : 
	  Methods Called                    : getChildElements(WebElement parent, String childControls)
	  Purpose of Method                 : To verify the megamenu links by names and http response
	  Dependencies	                    : --
	  Reviewed By                       : 
	**/ 
	
	public void validateMegamenuLinks(String parentMenu)
	{
		WebElement parentMenuElement = factory.getElement(parentMenu);
		verifyMenuOrCategoryLinks(parentMenu);
		List<WebElement> subMenuElements=factory.getChildElements(parentMenuElement, "Tag_Anchors");
		List<String> subMenuList = new ArrayList<String>();
		for(WebElement element : subMenuElements)
		{
			subMenuList.add(element.getText().toLowerCase());
		}
		List<String> expectedSubMenuList = split(dataMap.get(parentMenu), ",");
		for(int i=0;i<expectedSubMenuList.size();i++)
		{
			if(!subMenuList.contains(expectedSubMenuList.get(i).toLowerCase()))
			{
				screenshots.takeScreenShots();
				Assert.fail("Test Failed since the element "+ parentMenu+" does not contain the option"+ expectedSubMenuList.get(i));
			}
		}
	}
	/** 
	  Author Name                       : Phanendra
	  Date of Preparation               : 15/09/2014
	  Date of Modified                  : 
	  Methods Called                    : getChildElements(WebElementFactory)
	  Purpose of Method                 : Verifies the GSA search results
	  Dependencies	                    : --
	  Reviewed By                       : --	  
	**/
	
	public void validateGSASearchResults(String resultsArea)
	{
		contentValidation(resultsArea);
		if(factory.getElement("GSAPagination").isDisplayed())
		{
		
			driver.findElementByLinkText("2").click();
			dynamicWait.waittillpageloads();
			contentValidation(resultsArea);			
		}
		
	}
	
	/** 
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 16/09/2014
	  Date of Modified                  : 
	  Methods Called                    : getElements(WebElementFactory)
	  Purpose of Method                 : 
	  Dependencies	                    : --
	  Reviewed By                       : --	  
	 * @throws InterruptedException 
	**/
	public void validateAccordianBox(){
		List<WebElement> accordianBoxs = factory.getElements("PremiumContentForm_AccordianBoxPlus");
		List<WebElement> accordianBoxBlocks = factory.getElements("PremiumContentForm_AccordianBoxBlocks");
		if(accordianBoxBlocks.size() != accordianBoxs.size()){
			screenshots.takeScreenShots();
			Assert.fail("Accordian Boxes are not equal to Accordian Blocks");			
		}
		int count = 0;
		for(WebElement accordianBox : accordianBoxs){
			verify.verifyIcons(accordianBox, "Plus.JPG");
			accordianBox.click();
			dynamicWait.waittillpageloads();
			verify.verifyIcons(accordianBox, "Minus.JPG");
			dynamicWait.waittillpageloads();
			
			accordianBoxBlocks = factory.getElements("PremiumContentForm_AccordianBoxBlocks");			
			assertions.str_Assertequals(accordianBoxBlocks.get(count).getCssValue("display"), "block");
			assertions.assertNotNull(accordianBoxBlocks.get(count));
			
			List<WebElement> images = factory.verifyContainsChildElements(accordianBoxBlocks.get(count), "Tag_Image");
			for(WebElement img : images){
				verify.verifyHttpResponse(img);				
			}
			accordianBox.click();
			dynamicWait.waittillpageloads();
			scrollDown();
			dynamicWait.waittillpageloads();
			count++;
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/** 
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 16/09/2014
	  Date of Modified                  : 
	  Methods Called                    : getElements(WebElementFactory)
	  Purpose of Method                 : 
	  Dependencies	                    : --
	  Reviewed By                       : --	  
	 * @throws InterruptedException 
	**/
	public void verifyCarouselContent(){
		
		List<WebElement> carousels = factory.getOptionalElements("Carousel_Blocks");
		if(carousels.size()!=0)
		{
		try {
			Thread.sleep((long) (2.5 * carousels.size() * 8000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		carousels = factory.getElements("Carousel_Blocks");
		List<WebElement> carouselButtons = factory
				.getOptionalElements("Carousel_Buttons");
		if(carouselButtons.size()!=0)
		{
		if (carousels.size() != carouselButtons.size()) {
			screenshots.takeScreenShots();
			Assert.fail("Carousel Buttons count is not matching with the Carousel on the page");
		}
		for (int i = carousels.size() - 1; i >= 0; i--) {
			carouselButtons.get(i).click();
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			WebElement activeImage = factory.getElement("CarouselActiveImage");
			WebElement image = factory
					.getChildElement(activeImage, "Tag_Image");
			
			WebElement content = factory.getOptionalChildElement(activeImage,
					"Carousel_Content");
			WebElement title = factory.getOptionalChildElement(content, "Tag_Header2");
			verify.verifyHttpResponse(image);
			List<WebElement> anchorLinks = factory.verifyContainsChildElements(
					title, "Tag_Anchors");
			if (anchorLinks.size() == 0) {
				assertions.assertNotNull(title);
			} else {
				verify.verifyHttpResponse(anchorLinks.get(0));
				//assertions.assertNotNull(anchorLinks.get(0));
			}

		}
		}
		}

	}
	
	/** 
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 17/09/2014
	  Date of Modified                  : 
	  Methods Called                    : getElements(WebElementFactory)
	  Purpose of Method                 : 
	  Dependencies	                    : --
	  Reviewed By                       : --	  
	 * @throws InterruptedException 
	**/
	public void verifyCollaborationPodImagesClickable(String controlName) {
		List<WebElement> collaborationPods = factory.getElements(controlName);
		if (collaborationPods.size() > 3) {
			screenshots.takeScreenShots();
			Assert.fail("Collaboration Pod Images should be maximum 3");
		}
		for (WebElement collaborationPod : collaborationPods) {
			assertions.str_Assertequals(collaborationPod.getCssValue("cursor"),
					"pointer");
			List<WebElement> images = factory.getChildElements(
					collaborationPod, "Tag_Image");
			if (images.size() != 2) {
				screenshots.takeScreenShots();
				Assert.fail("Collaboration Pod Images are not displayed properly");
			}
			for (WebElement image : images) {
				verify.verifyHttpResponse(image);
			}
		}

		WebElement redDots = factory.getElement(controlName);
		List<WebElement> indicator = factory.getChildElements(redDots,
				"Tag_Div");

		if (indicator.size() != 3) {
			screenshots.takeScreenShots();
			Assert.fail("Collaboration Pod Red Dot Indicator is not displayed");
		}

	}

	
	
	/** 
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 17/09/2014
	  Date of Modified                  : 
	  Methods Called                    : getElements(WebElementFactory)
	  Purpose of Method                 : 
	  Dependencies	                    : --
	  Reviewed By                       : --	  
	 * @throws InterruptedException 
	**/
	public void verifyCollaborationPodsRotation(String controlName)
	{
		List<WebElement> collaborationPods=factory.getElements(controlName);
		for (WebElement pod : collaborationPods) {
			if(pod.getAttribute("class")=="active")
			{
				List<WebElement> imageContent = pod.findElements(By.tagName("img"));
				for (WebElement img : imageContent) {
					if(img.getAttribute("class")=="blurred")
					{
						String display=userActions.getCssProperty(img, "display");
						if(!(display.equalsIgnoreCase("none")))
						{
							screenshots.takeScreenShots();
							Assert.fail("Active Image is blurred");	
						}
					}
					else
					{
						String display=userActions.getCssProperty(img, "display");
						if(!(display.equalsIgnoreCase("block")))
						{
							screenshots.takeScreenShots();
							Assert.fail("Active image is blurred");
						}
					}
				}
			}
			else
			{
				List<WebElement> imageContent = pod.findElements(By.tagName("img"));
				for (WebElement img : imageContent) {
					if(img.getAttribute("class")=="blurred")
					{
						String display=userActions.getCssProperty(img, "display");
						if(display.equalsIgnoreCase("none"))
						{
							screenshots.takeScreenShots();
							Assert.fail("InActive image is not blurred");
						}
					}
				}
			}
		}
		
	}
	/** 
	  Author Name                       : Pankaj Sharma
	  Date of Preparation               : 17/09/2014
	  Date of Modified                  : 
	  Methods Called                    : getElements(WebElementFactory)
	  Purpose of Method                 : 
	  Dependencies	                    : --
	  Reviewed By                       : --	  
	 * @throws InterruptedException 
	**/
	
	
	public void verifyLatestNewsTicker(String controlName)
	{
		List<WebElement> newsItems = factory.getElements(controlName);
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> newsItemsOrder = factory.getElements(controlName);
		if (newsItems.get(0)==newsItemsOrder.get(0)) {
			Assert.fail("News items are not ticking");
		}
		
	}
	
	public void verifyEventPagePods(String controlName)
	{
		WebElement eventPod = factory.getElement("eventPod");
		List<WebElement> events = factory.getChildElements(eventPod, "Events");
		List<WebElement> seeAllLink = factory.getChildElements(eventPod, "SeeAllLink");
	
		for (WebElement event : events) {
			WebElement link = factory.getChildElement(event, "Tag_Anchors");
			verify.verifyHttpResponse(link);
		}
		if(seeAllLink.get(0).isDisplayed())
		{
			seeAllLink.get(0).click();
			dynamicWait.waittillpageloads();
			List<WebElement> eventsOnAvayaEventsPage = factory.getElements("AvayaEvents");
			if(eventsOnAvayaEventsPage.size()<3)
			{
				Assert.fail("");
			}
		}
	}
	/**
	  Author Name                          : Pankaj Sharma
	  Date of Preparation                  : 22/09/2014
	  Date of Modified                     : --
	  Methods Called                       : 
	  Purpose of Method                    : Verify the HPSegementation on Image Carousel
	  Dependencies	                       : 
	  Reviewed By                          : --
	**/ 
	
	public void verifyHomePageCarouselHPSegmentation(String carouselActiveImage,String expectedImageTitle)
	{
		WebElement activeImage = factory.getElement(carouselActiveImage);
		WebElement imageContent = factory.getChildElement(activeImage, "Tag_Image");
		WebElement imageTitle = factory.getChildElement(activeImage, "Tag_h1");
		verify.verifyHttpResponse(imageContent);
		if(!(imageTitle.getText().equalsIgnoreCase(expectedImageTitle)))
		{
			screenshots.takeScreenShots();
			Assert.fail("The expected Segmentation image title is not present");
		}
	}
	
	/**
	  Author Name                          : Pankaj Sharma
	  Date of Preparation                  : 22/09/2014
	  Date of Modified                     : --
	  Methods Called                       : 
	  Purpose of Method                    : Verify the PremiumPodsContent
	  Dependencies	                       : 
	  Reviewed By                          : --
	**/ 	
	
	public void verifyPremiumPodsContent(String control)
	{
		WebElement premiumPod = factory.getElement(control);
		WebElement title = factory.getChildElement(premiumPod, "Tag_Header");
		WebElement textContent = factory.getElement("PremiumPod_Description");
		WebElement learnMoreLink = factory.getChildElement(premiumPod, "LearnMoreLink");
		System.out.println(title.getText());
		System.out.println(textContent.getText());
		assertions.assertNotNull(title);
		assertions.assertNotNull(textContent);
		verify.verifyHttpResponse(learnMoreLink);
 	}
	
	/**
	  Author Name                          : Vinusha
	  Date of Preparation                  : 29/10/2014
	  Date of Modified                     : --
	  Methods Called                       : 
	  Purpose of Method                    : Verify the PremiumPodsContent
	  Dependencies	                       : 
	  Reviewed By                          : --
	**/ 	
	
	public void AboutAvaya(String control)
	{
		WebElement premiumPod = factory.getElement(control);
		WebElement title = factory.getChildElement(premiumPod, "Tag_Header");
		WebElement textContent = factory.getChildElement(premiumPod, "Tag_Paragraphs");
		WebElement learnMoreLink = factory.getChildElement(premiumPod, "LearnMoreLink");
		assertions.assertNotNull(title);
		assertions.assertNotNull(textContent);
		verify.verifyHttpResponse(learnMoreLink);
	}
	
	/**
	  Author Name                          : Mahima
	  Date of Preparation                  : 29/10/2014
	  Date of Modified                     : --
	  Methods Called                       : 
	  Purpose of Method                    :Verify the presence of cloud filter in product type filter
	  Dependencies	                       : 
	  Reviewed By                          : --
	**/ 
	
	public void checkProductTypeFiltersWithoutCount(String filter)
	{
	
		WebElement labelElement =factory.getElement(filter);		
		String actual=labelElement.getText().trim();
		actual=actual.replaceAll("[^\\p{ASCII}]", " ");
		actual=actual.replace(".0", "");
		actual=actual.replaceAll(" ", "");	
		actual=actual.replaceAll("[()0-9]", "");
		String expected =dataMap.get(filter).toString().trim();
		expected=expected.replaceAll("[^\\p{ASCII}]", " ");
		expected = expected.replaceAll(" ", "");
		assertions.str_Assertequals(actual,expected);
			
	}
	
	/**
	  Author Name                          : Mahima
	  Date of Preparation                  : 29/10/2014
	  Date of Modified                     : --
	  Methods Called                       : 
	  Purpose of Method                    : Verify the subcategories under cloud in the mega menu
	  Dependencies	                       : 
	  Reviewed By                          : --
	**/ 
	
	public void verifyCloudSubCategories(String parentMenu, String delimiter) {
		WebElement parentMenuElement = factory.getElement(parentMenu);
		List<WebElement> subMenuElements_p = factory.getChildElements(
				parentMenuElement, "Tag_Paragraphs");
		List<WebElement> subMenuElements_a = factory.getChildElements(
				parentMenuElement, "Tag_Anchors");
		List<String> expectedSubMenuList = split(dataMap.get(parentMenu),
				delimiter);
		int counter = 0;
		int counters = 0;
		List<String> subMenuList_p = new ArrayList<String>();
		for (WebElement element : subMenuElements_p) {
			subMenuList_p.add(element.getText().toLowerCase());

		}
		List<String> subMenuList_a = new ArrayList<String>();
		for (WebElement element : subMenuElements_a) {
			subMenuList_a.add(element.getText().toLowerCase());

		}
		if (subMenuList_p.size() != 0 && subMenuList_a.size() != 0) {

			for (int i = 0; i < expectedSubMenuList.size(); i++) {
				for (int j = 0; j < subMenuList_p.size(); j++) {
					if (subMenuList_p
							.get(j)
							.trim()
							.equalsIgnoreCase(
									(expectedSubMenuList.get(i).trim()))) {
						counter++;
						break;
					} else {
						continue;
					}
				}
			}
			for (int i = 0; i < expectedSubMenuList.size(); i++) {
				for (int j = 0; j < subMenuList_a.size(); j++) {
					if (subMenuList_a
							.get(j)
							.trim()
							.equalsIgnoreCase(
									(expectedSubMenuList.get(i).trim()))) {
						counters++;
						break;
					} else {
						continue;
					}
				}
			}
			if ((counter + counters) != expectedSubMenuList.size()) {
				screenshots.takeScreenShots();
				Assert.fail("The count of expected child elements is not equal to count of actual child elements");
			}
		} else {
			screenshots.takeScreenShots();
			Assert.fail("The element" + parentMenu
					+ "does not have any child elments under it");

		}
	}
	
	/**
	  Author Name                          : Aishwarya
	  Date of Preparation                  : 12/01/2015
	  Date of Modified                     : --
	  Methods Called                       : 
	  Purpose of Method                    :Verify Twitter Tout Content
	  Dependencies	                       : 
	  Reviewed By                          : --
	**/ 
	
	public void verifyTwitterTout()
	{
		verify.verifyElementContainsText("TwitterWidgetHeader", "TwitterTitle");
		verify.isElementPresent("twitter_link");
		userActions.switchToFrame("TwitterWidget_Frame");
		verify.isElementPresent("TwitterFollowButton");
		verify.isElementDisplayed("TwitterWidgetTweets");
		verify.verifyElementContainsText("TweetTextBoxButton", "TweetBox_keyword");
		userActions.switchToDefaultContent();
	}
	/**
	  Author Name                          : Aishwarya
	  Date of Preparation                  : 13/01/2015
	  Date of Modified                     : --
	  Methods Called                       : 
	  Purpose of Method                    :Verify Twitter Tout Content
	  Dependencies	                       : 
	  Reviewed By                          : --
	**/ 
	
	public void verifyEventsListingContent(String eventListing)
	{
		List<WebElement> events = factory.getElements(eventListing);
		for (WebElement event : events) {
			WebElement image = event.findElement(By.xpath(".//*[starts-with(@class,'event-photo')]/img"));
			WebElement eventTitle = event.findElement(By.xpath(".//*[starts-with(@class,'event-title')]/span"));
			WebElement eventDate = event.findElement(By.xpath(".//*[starts-with(@class,'event-date')]"));
			imageValidation(image);
			assertions.assertNotNull(eventTitle);
			Assert.assertTrue(eventTitle.isDisplayed(), "Event title is not displayed");
			assertions.assertNotNull(eventDate);
			
		}
	}
	
	/**
	  Author Name                          : Aishwarya
	  Date of Preparation                  : 13/01/2015
	  Date of Modified                     : --
	  Methods Called                       : 
	  Purpose of Method                    : Verifies the date format on Events page
	  Dependencies	                       : 
	  Reviewed By                          : --
	**/
	public void dateFormatCheck(String controlName)
	{
	WebElement EventDate = factory.getElement(controlName);
	if (!(EventDate.getText()
	.matches("([0-9]{1,2})\\s([a-zA-Z]{3})\\s([0-9]{4}\\s(-)\\s[0-9]{1,2})\\s([a-zA-Z]{3})\\s([0-9]{4})"))) {
	screenshots.takeScreenShots();
	Assert.fail("Date is not in DD MMM YYYY format");
	}
	}
	 
	/**
	  Author Name                          : Aishwarya
	  Date of Preparation                  : 13/01/2015
	  Date of Modified                     : --
	  Methods Called                       : 
	  Purpose of Method                    : Verifies the future event start date (count down days)
	  Dependencies	                       : 
	  Reviewed By                          : --
	**/
	
	public void checkFutureEventStartDate(String controlName)
	{
	WebElement EventDate = factory.getElement(controlName);
	   if(!(EventDate.getText().contains("Days Until Event")))
	    {
	             screenshots.takeScreenShots();
	         Assert.fail("<Number> Days until event text is not displayed");
	    }
	}
	
	/**
	  Author Name                          : Aishwarya
	  Date of Preparation                  : 13/01/2015
	  Date of Modified                     : --
	  Methods Called                       : 
	  Purpose of Method                    : Verifies Your selection filters on events page
	  Dependencies	                       : 
	  Reviewed By                          : --
	**/
	public void checkYourSelection(String controlName,String categoryTagName)
	{
	List<String> actualCategoryTagName=new ArrayList<String>();
	List<WebElement> tags=factory.getElements(controlName);
	String ExpectedTags=dataMap.get(categoryTagName);
	List<String> afterSplit=split(ExpectedTags,",");
	for (WebElement element : tags) {
	 
	actualCategoryTagName.add(element.getText());
	}
	for(int i=0;i<tags.size();i++)
	{
	System.out.println(ExpectedTags);
	 
	if(!(actualCategoryTagName.contains(afterSplit.get(i).toString())))
	{
	screenshots.takeScreenShots();
	       Assert.fail("Incorrect tag names");
	}
	}
	
}
	
	public void checkCssBackGroundColorOnHover(String controlName) 
	{
	dynamicWait.waittillpageloads();
	List<WebElement> leftMenuList = factory.getElements(controlName);
	for (WebElement element : leftMenuList) 
	{
	 
	Actions actions = new Actions(driver);
	Action action;
	actions.moveToElement(element);
	action = actions.build();
	action.perform();
	  
	String actualColor = element.getCssValue("background-color");
	  
	 
	  
	assertions.str_Assertequals(actualColor, dataMap.get(controlName));
	 
	 
	}
	}
	/**
	  Author Name                          : Aishwarya
	  Date of Preparation                  : 13/03/2015
	  Date of Modified                     : --
	  Methods Called                       : 
	  Purpose of Method                    : Verify the count of pods
	  Dependencies	                       : 
	  Reviewed By                          : --
	**/
	
	public void verifyImaginePods(String podsControlName){
		List<WebElement> podsElement = factory.getElements(podsControlName);
		for(WebElement podElement : podsElement){
		List<WebElement> imgElements = factory.getChildElements(podElement, "Tag_Image");
		if(imgElements.size() == 0){
		screenshots.takeScreenShots();
		Assert.fail("Image Element is not present in Pod");
		 
		}
		if(imgElements.size() > 4){
		screenshots.takeScreenShots();
		Assert.fail("Image Element cannot be more than 4 in a Pod");
		 
		}
		for(WebElement img : imgElements){
		Dimension dimension = img.getSize();
		 
		if(dimension.getHeight() == 0 || dimension.getWidth() == 0){
		screenshots.takeScreenShots();
		Assert.fail("Image Element is not present in Pod");
		 
		}
		 
		verify.verifyHttpResponse(img);
		}
		List<WebElement> podTextElements = factory.getChildElements(podElement, "text");
		assertions.assertNotNull(podTextElements.get(0));
		verify.isElementDisplayed(podTextElements.get(0));
		}
		}

 public void verifyFeaturedCaseStudyPods(String podsControlName, String imgCntrl){
        List<WebElement> podsElement = factory.getElements(podsControlName);
        System.out.println();
        List<WebElement> imgElements1 = factory.getElements(imgCntrl);
        if(podsElement.size()!=imgElements1.size())
        {
               screenshots.takeScreenShots();
               Assert.fail("no. of pod images are not equl to pods count");  
        }
        for(WebElement podElement : podsElement){
               List<WebElement> imgElements = factory.getChildElements(podElement, imgCntrl);
               if(imgElements.size() > 6){
                     screenshots.takeScreenShots();
                     Assert.fail("Images should not be more than 6");                                                       
               }
               
               if(imgElements.size() == 0){
                     screenshots.takeScreenShots();
                     Assert.fail("Image Element is not present in Pod");                                                    
               }
               
                     Dimension dimension = imgElements.get(0).getSize();                  
                     if(dimension.getHeight() == 0 || dimension.getWidth() == 0){
                            screenshots.takeScreenShots();
                            Assert.fail("Image Element is not present in Pod");                                                    
                     }             
                     //verify.verifyHttpResponse(imgElements.get(0));
               
               
               
        }
        List<WebElement> podTextElements = factory.getElements("Pod_Text");
        for(WebElement podElement : podTextElements)
        {
                     assertions.assertNotNull(podTextElements.get(0));
                            verify.isElementDisplayed(podTextElements.get(0));
        }
 }
 public void verifyTestomonialPods(String podsControlName, String imgCntrl){
        List<WebElement> podsElement = factory.getElements(podsControlName);
        System.out.println();
        List<WebElement> imgElements1 = factory.getElements(imgCntrl);
        if(podsElement.size()!=imgElements1.size())
        {
               screenshots.takeScreenShots();
               Assert.fail("no. of pod images are not equl to pods count");  
        }
        for(WebElement podElement : podsElement){
               List<WebElement> imgElements = factory.getChildElements(podElement, imgCntrl);
               if(imgElements.size() > 4){
                     screenshots.takeScreenShots();
                     Assert.fail("Images should not be more than 6");                                                       
               }
               
               if(imgElements.size() == 0){
                     screenshots.takeScreenShots();
                     Assert.fail("Image Element is not present in Pod");                                                    
               }
               
                     Dimension dimension = imgElements.get(0).getSize();                  
                     if(dimension.getHeight() == 0 || dimension.getWidth() == 0){
                            screenshots.takeScreenShots();
                            Assert.fail("Image Element is not present in Pod");                                                    
                     }             
                     //verify.verifyHttpResponse(imgElements.get(0));
               
               
               
        }
        List<WebElement> podTextElements = factory.getElements("Textt");
        for(WebElement podElement : podTextElements)
        {
                     assertions.assertNotNull(podTextElements.get(0));
                            verify.isElementDisplayed(podTextElements.get(0));
        }
 }
 
 public void verifyFeaturedCustomerPod(String podsControlName, String imgCntrl){
        List<WebElement> podsElement = factory.getElements(podsControlName);
        System.out.println();
        List<WebElement> imgElements1 = factory.getElements(imgCntrl);
        if(podsElement.size()!=imgElements1.size())
        {
               screenshots.takeScreenShots();
               Assert.fail("no. of pod images are not equl to pods count");  
        }
        
        for(WebElement podElement : podsElement){
               List<WebElement> imgElements = factory.getChildElements(podElement, imgCntrl);
               if(imgElements.size() == 0){
                     screenshots.takeScreenShots();
                     Assert.fail("Image Element is not present in Pod");                                                    
               }
               if(imgElements.size() > 6){
                     screenshots.takeScreenShots();
                     Assert.fail("More than 6 images should not be present");                                                      
               }
               
                     Dimension dimension = imgElements.get(0).getSize();                  
                     if(dimension.getHeight() == 0 || dimension.getWidth() == 0){
                            screenshots.takeScreenShots();
                            Assert.fail("Image Element is not present in Pod");                                                    
                     }             
                     //verify.verifyHttpResponse(imgElements.get(0));
               
               
               
        }
        List<WebElement> podTextElements = factory.getElements("Pod_Text");
        for(WebElement podElement : podTextElements)
        {
                     assertions.assertNotNull(podTextElements.get(0));
                            verify.isElementDisplayed(podTextElements.get(0));
        }
 }
 
 
/*     public void verifyFeaturedCustomerPod(String podsControlName){
        
        List<WebElement> podsElement = factory.getElements(podsControlName);
        for(WebElement podElement : podsElement){
               List<WebElement> imgElements = factory.getChildElements(podElement, "Tag_Image");
               if(imgElements.size() == 0){
                     screenshots.takeScreenShots();
                     Assert.fail("Image Element is not present in Pod");                                                    
               }
               if(imgElements.size() > 6){
                     screenshots.takeScreenShots();
                     Assert.fail("Image Element cannot be more than 6 in a Pod");                                                  
               }
               
               for(WebElement img : imgElements){
                     Dimension dimension = img.getSize();                   
                     if(dimension.getHeight() == 0 || dimension.getWidth() == 0){
                            screenshots.takeScreenShots();
                            Assert.fail("Image Element is not present in Pod");                                                    
                     }                          
                     verify.verifyHttpResponse(img);
               }
               
               List<WebElement> podTextElements = factory.getChildElements(podElement, "podtext");
               assertions.assertNotNull(podTextElements.get(0));
               verify.isElementDisplayed(podTextElements.get(0));
        }
 }*/

 public void verifyTestimonialPods(String podsControlName){
        List<WebElement> podsElement = factory.getElements(podsControlName);
        for(WebElement podElement : podsElement){
               List<WebElement> imgElements = factory.getChildElements(podElement, "Tag_Image");
               if(imgElements.size() == 0){
                     screenshots.takeScreenShots();
                     Assert.fail("Image Element is not present in Pod");                                                    
               }
               if(imgElements.size() > 4){
                     screenshots.takeScreenShots();
                     Assert.fail("Image Element cannot be more than 4 in a Pod");                                                  
               }
               
               for(WebElement img : imgElements){
                     Dimension dimension = img.getSize();                   
                     if(dimension.getHeight() == 0 || dimension.getWidth() == 0){
                            screenshots.takeScreenShots();
                            Assert.fail("Image Element is not present in Pod");                                                    
                     }                          
                     verify.verifyHttpResponse(img);
               }
               
               List<WebElement> podTextElements = factory.getChildElements(podElement,"Testimonial_Pods_Content");
               assertions.assertNotNull(podTextElements.get(0));
               verify.isElementDisplayed(podTextElements.get(0));
        }
 }
 public void validateText(String text) {
 	List<WebElement> childElements = factory.getOptionalElements(text);
 	
 	 if(childElements.size() > 8){
 		screenshots.takeScreenShots();
			Assert.fail("It should not contain more than 8 divs");
			System.out.println(childElements);
 	}
 }
 	 
 	public void validateLinks(String text) {
 		List<WebElement> childElements = factory.getElements(text);
 		System.out.println(childElements.size());
 		int norows=childElements.size();
 		System.out.println(norows);
 	 	if((norows >= 26)){
 	 		System.out.println(norows);
 	 		screenshots.takeScreenShots();
 				Assert.fail("Greater than 25 links should not be present in Browse FAQ pod");
 	 	 }
 	}
 	 	
 	/**
	  Author Name                          : Dhana Lakshmi
	  Date of Preparation                  : 19/05/2015
	  Date of Modified                     : --
	  Methods Called                       : 
	  Purpose of Method                    : Verify the SubPromos Content in Sponsorship Landing Page
	  Dependencies	                       : 
	  Reviewed By                          : --
	**/
	public void verifySponsorshipSubPromosContent(String controlName) {
		
		List <WebElement> elements=factory.getElements(controlName);
		for (int index=0;index<elements.size();index++)
		{
			List<WebElement> imageElements=factory.getChildElements(elements.get(index), "Tag_Image");
	 		for(WebElement element: imageElements){
	 			verify.isElementDisplayed(element);
	 		}
	 		
	 		
	 		List<WebElement> paragraphs=factory.getChildElements(elements.get(index),"Tag_Paragraphs");
	 		int count=paragraphs.size();
	 		if(!(count==2)){
	 			screenshots.takeScreenShots();
	 			Assert.fail("Either of Title and Subtext is missing");
	 		}
	 		for(WebElement element: paragraphs){
	 			if(element.getText()==""){
	 				screenshots.takeScreenShots();
	 				Assert.fail("Title or Subtext are not present");
	 			} 	 			
	 		}
	 		
		}
	
	}
	
	/**
	  Author Name                          : Dhana Lakshmi
	  Date of Preparation                  : 20/05/2015
	  Date of Modified                     : --
	  Methods Called                       : 
	  Purpose of Method                    : Verify the navigation to a child window
	  Dependencies	                       : 
	  Reviewed By                          : --
	**/
	public void clickAndVerifyNavigationToChildWindow(String controlName, String pageElement){

		userActions.clickOn(controlName);
		userActions.switchToChildWindow();
		dynamicWait.waittillpageloads();
		verify.isElementPresent(pageElement);
		userActions.switchToParentWindow();
	}
	
	/**
	  Author Name                          : Dhana Lakshmi
	  Date of Preparation                  : 21/05/2015
	  Date of Modified                     : --
	  Methods Called                       : 
	  Purpose of Method                    : Verify whether more than one banner dsiplayed in Sponsorship Pages
	  Dependencies	                       : 
	  Reviewed By                          : --
	**/
	public void verifySponsorshipSubLandingPageBanner(String detailPage, String bannerControlName){
		
		userActions.clickOn(detailPage);
		dynamicWait.waittillpageloads();
		
		WebElement element=factory.getElement(bannerControlName);
		List<WebElement> banner=factory.getChildElements(element, "Tag_Image");
		int count=banner.size();
		
		if(count==0){
			screenshots.takeScreenShots();
			Assert.fail("Banner is not displayed");
		}
		
		else if(!(count==1)){
			Assert.fail("More than one banner is displayed");
		}
		
	}
	
	/**
	  Author Name                          : Dhana Lakshmi
	  Date of Preparation                  : 22/05/2015
	  Date of Modified                     : --
	  Methods Called                       : 
	  Purpose of Method                    : For Sponsorship Form Email field Validation
	  Dependencies	                       : 
	  Reviewed By                          : --
	**/
	public void sponsorshipFormEmailValidation(String email, String flag){
			
			// Enter email in the text box
	 		userActions.enterText("SponsorshipForm_Email", email);
	 		// Click on Submit button
	 		userActions.clickOn("SponsorshipForm_SubmitButton");
	 		
	 		switch(flag){
	 		
		 		case "invalid":
			 		// Verify whether error message is displayed
			 		verify.isTextPresent("SponsorshipForm_InvalidEmail");
			 	
		 		case "valid":
		 			// Verify whether error message is displayed
		 			verify.isElementNotDisplayed("SponsorshipForm_InvalidEmail");
	 		}
	}
	
	/**
	  Author Name                          : Dhana Lakshmi
	  Date of Preparation                  : 23/05/2015
	  Date of Modified                     : --
	  Methods Called                       : 
	  Purpose of Method                    : To Verify Sponsorship Detail Page Content
	  Dependencies	                       : 
	  Reviewed By                          : --
	**/
	public void verifySponsorshipDetailContent(String controlName, String nextButton){
		
		List<WebElement> elements=factory.getElements(controlName);
		ArrayList<String> list=new ArrayList<String>(); 
		for(int index=0; index < elements.size(); index++){
			list.add(index,elements.get(index).getAttribute("href"));
		}
		elements.get(0).click();
		dynamicWait.waittillpageloads();
		for(int index=0; index<list.size(); index++){
			String currentUrl=driver.getCurrentUrl();
	 			if(!(currentUrl.equals(list.get(index)))){
	 				screenshots.takeScreenShots();
	 				Assert.fail("The articles are not displayed in a cycle");
	 			}
			userActions.clickOn(nextButton);
			dynamicWait.waittillpageloads();
		}
			
	}
	
	/**
	  Author Name                          : Dhana Lakshmi
	  Date of Preparation                  : 24/05/2015
	  Date of Modified                     : --
	  Methods Called                       : 
	  Purpose of Method                    : To Verify Sponsorship Detail Page Content
	  Dependencies	                       : 
	  Reviewed By                          : --
	**/
	public void verifySponsorshipDetailTwitterWidget(String SubLanding, String detailPage){
		
		userActions.clickOn(SubLanding);
		dynamicWait.waittillpageloads();
		List<WebElement> elements=factory.getElements(detailPage);
		elements.get(0).click();
		dynamicWait.waittillpageloads();
		verify.isElementPresent("TwitterWidget");
		verifyTwitterTout();
	}	
	

	/**
	  Author Name                          : Dhana Lakshmi
	  Date of Preparation                  : 03/06/2015
	  Date of Modified                     : --
	  Methods Called                       : 
	  Purpose of Method                    : To Verify Article Date in Perpectives Pages
	  Dependencies	                       : 
	  Reviewed By                          : --
	**/
	
	public void verifyPerspectivesArticleDate(String controlName) {
		
		List<WebElement> articles = factory.getElements(controlName);
		for(WebElement article : articles){
			List<WebElement> title = factory.verifyContainsChildElements(article, "TitleClass");		
			List<WebElement> date = factory.verifyContainsChildElements(article, "PublishedDateClass");
		
			if(date.size() >= 1){
				screenshots.takeScreenShots();
				Assert.fail("Date is displayed for "+title.get(0).getText()+" Article on Perspective Page ");
				
			}
		}
	}
	
	/**
	  Author Name                          : Dhana Lakshmi
	  Date of Preparation                  : 29/06/2015
	  Date of Modified                     : --
	  Methods Called                       : 
	  Purpose of Method                    : To Verify whether a single element is displayed or not
	  Dependencies	                       : 
	  Reviewed By                          : --
	**/
	public void isElementDisplayed(String controlName){
		WebElement element= factory.getElement(controlName);
		verify.isElementDisplayed(element);
	}
	
	/**
	  Author Name                          : Dhana Lakshmi
	  Date of Preparation                  : 30/06/2015
	  Date of Modified                     : --
	  Methods Called                       : 
	  Purpose of Method                    : Verify filtered results by verifying the filter value is present in URL or not.
	  Dependencies	                       : 
	  Reviewed By                          : --
	**/
	
	public void validateResultsByCheckingValuesInUrl(String parent, String child, String textElement){
		WebElement element=factory.getElement(parent);
		List<WebElement> results=factory.getChildElements(element, child);
		String validationText= (factory.getElement(textElement)).getText();
		for(int index=0; index < results.size(); index++){
			String hrefValue=results.get(index).getAttribute("href");
			validationText=validationText.replaceAll("[^a-zA-Z0-9]", "");
			System.out.println(hrefValue);
			System.out.println(validationText);
			if(!(hrefValue.contains(validationText.toLowerCase()))){
				Assert.fail("Results displayed are not valid, since they do not belong to" +validationText);
			}
		}	
	}
	
	/**
	  Author Name                          : Dhana Lakshmi
	  Date of Preparation                  : 30/06/2015
	  Date of Modified                     : --
	  Methods Called                       : 
	  Purpose of Method                    : Verify text of two elements
	  Dependencies	                       : 
	  Reviewed By                          : --
	**/
	public void compareTextOfTwoElements(String element1, String element2){
		String element1Text=(factory.getElement(element1)).getText();
		String element2Text=(factory.getElement(element2)).getText();
		if (!(element1Text.equals(element2Text))){
			Assert.fail("failed");
		}
	}
	
	/**
	  Author Name                          : Dhana Lakshmi
	  Date of Preparation                  : 13/06/2015
	  Date of Modified                     : --
	  Methods Called                       : 
	  Purpose of Method                    : Verify GSA Search Page Related Searches
	  Dependencies	                       : 
	  Reviewed By                          : --
	**/	
	public void verifyGSASearchPageRelatedSearches(String controlName){
		
		List<WebElement> elements=factory.getElements(controlName);
		if(!(elements.isEmpty())){
			for(WebElement element:elements){
				verify.verifyHttpResponse(element);
				element.click();
				dynamicWait.waittillpageloads();
				searchValidResults("ResultDetails", element.getText());
			}
		}
		else{
			Assert.fail("There are no Related Searches present for your Search Keyword");
		}
	}	
	
}	