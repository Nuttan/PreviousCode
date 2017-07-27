/**
 * 
 */
package verification;


import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.commons.io.FileUtils;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.SystemClock;
import org.sikuli.api.DesktopScreenRegion;
import org.sikuli.api.ImageTarget;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.Target;
import org.testng.Assert;

import com.android.ddmlib.AdbCommandRejectedException;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sun.jna.platform.win32.WinBase.SYSTEMTIME;

import resources.Systems;
import resources.VerifyImage;
import testData.TestDataFactory;
import testData.TestDataMap;
import utilities.Assertions;
import utilities.DynamicWait;
import utilities.ScreenShots;
import utilities.WebElementFactory;
import wrapper.UserActions;

public class Verify {
	
	private WebElementFactory elementFactory;
	private UserActions userActions;
	private ScreenShots screenshots=null;
	private  Alert alert = null;
	private  TestDataMap<String, String> dataMap;
	protected TestDataFactory dataFactory;
	protected RemoteWebDriver driver;
	protected DynamicWait dynamicWait;
	protected Assertions assertions;
	ExtentTest test;
	
	public Verify(RemoteWebDriver driver) {
		elementFactory = new WebElementFactory(driver);
		userActions=new UserActions(driver);
		dataFactory = new TestDataFactory();
		dataMap = dataFactory.createTestDataMap();
		dynamicWait = new DynamicWait(driver);
		screenshots =new ScreenShots(driver);
		assertions = new Assertions(driver);
		this.driver = driver;
	}
	
	/** 
	 Author Name                       : Sivanag
	 Date of Preparation               : 10/06/2014
	 Date of Modified                  : 
	 Methods Called                    : getElementNotPresent(WebElementFactory)
	 Purpose of Method                 : This method is used to verify whether particular element is present in the screen or not
	                                     As per this method, element should not be present in the page
	 Dependencies	                    : --
	 Reviewed By                       : --
	
	**/
	
	public  void isElementNotPresent(String controlName)
	{
		List<WebElement> elements = elementFactory.getElementNotPresent(controlName);
		if(elements.size()>0){
			screenshots.takeScreenShots();
			Assert.fail(controlName +"is present in the page");				
			}			
		
	}
	
	
	 /** 
	 Author Name                       : Sivanag
	 Date of Preparation               : 11/06/2014
	 Date of Modified                  : --
	 Methods Called                    : getElements(WebElementFactory)
	 Purpose of Method                 : This method is used to verify whether particular element is present in the screen or not
	                                     As per this method, element should present in the page
	 Dependencies	                   : --
	 Reviewed By                       : --
	**/
	
	public  void isElementPresent(String controlName)
	{
			
			List<WebElement> elements = elementFactory.getElements(controlName);
			if(elements.size()==0){	
				screenshots.takeScreenShots();
				Assert.fail(controlName+" is not displayed");				
			}
					
	}	
	
	
	/**
	  Author Name                       : Phanendra 
	  Date of Preparation               : 03-07-2014
	  Date of Modified                  : --
	  Methods Called                    : getElement(String controlName)
	  Purpose of Method                 : To check whether the element is not displayed on the page or not
	  Dependencies	                    : --
	  Reviewed By                       : 
	  **/
	
	public  void isElementNotDisplayed(String controlName)
	{
		List<WebElement> elements=driver.findElements(By.id(controlName));
		if(elements.size()>0)
		{
			screenshots.takeScreenShots();
			Assert.fail(controlName+ "is displayed on the page");
		}
		
	}
	
	
	/** 
	 Author Name                       : Sivanag
	 Date of Preparation               : 11/06/2014
	 Date of Modified                  : 02-09-2014
	 Methods Called                    :getElement(WebElementFactory),TestDataFactory,getTestMap(TestDataFactory)
	 Purpose of Method                 : This method is used to verify particular text is present in the screen or not
	                                     As per this method, text should present in the page
	 Dependencies	                   : --
	 Reviewed By                       : --
	 * @throws AdbCommandRejectedException 
	 * @throws InterruptedException 
	 
	**/
	public  void isTextPresent(String controlName)  
	{
		
		WebElement labelElement =elementFactory.getElement(controlName);		
		String actual=labelElement.getText().trim();
		actual=actual.replaceAll("[^\\p{ASCII}]", " ").replace(".0", "").replaceAll(" ", "");
		//actual=actual.replace(".0", "");
		//actual=actual.replaceAll(" ", "");
		String expected =dataMap.get(controlName).toString().trim();
		expected=expected.replaceAll("[^\\p{ASCII}]", " ").replaceAll(" ", "");
		//expected = expected.replaceAll(" ", "");
		assertions.str_Assertequals(actual,expected);
		
	}
	
	/** 
	 Author Name                       : Sindhuja.P
	 Date of Preparation               : 12/06/2014
	 Date of Modified                  : 05/08/2014
	 Methods Called                    : WebElementFactory,getChildElements
	 Purpose of Method                 : To check if the products are displayed with the required keyword.
	 Dependencies	                   : --
	 Reviewed By                       : --	 
	**/
	
	public  void verifySearchResults(List<WebElement> resultElements ,String keyword)
	 {
		 for (WebElement element : resultElements)
		 {
			 if(!element.getText().contains(keyword))
			 {
				 screenshots.takeScreenShots();
				 Assert.fail("Test failed since the results are not being displayed with the keyword "+keyword);
			 }
			
		 }
	 }
	
	/** 
	 Author Name                       : Sindhuja.P
	 Date of Preparation               : 16/06/2014
	 Date of Modified                  : --
	 Methods Called                    : --
	 Purpose of Method                 : Check whether the products in the 2nd page are differenr from the 1st page
	 Dependencies	                   : --
	 Reviewed By                       : --
	 
	**/

	public  void verifyPagination(List<String> elements,WebElement element) 
	{
		if(elements.contains(element.getText()))
		{
			screenshots.takeScreenShots();
			Assert.fail("Test failed since the contents in the second page match with the contents in the first page which is not valid");
		}
		
	}
	
	/**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 13-06-2014
	  Date of Modified                  : --
	  Methods Called                    : getElements(String controlName),str_Assertequals(String str_actual,String str_expected)
	  Purpose of Method                 : To check whether the  String contains the expected value
	  Dependencies	                    : --
	  Reviewed By                       : 
	  **/
	
	public  void verifyElementContainsText(String controlName, String controlNameExpected)
	{

		WebElement element = elementFactory.getElement(controlName);
		String actual=element.getText().toLowerCase();
		String expected=dataMap.get(controlNameExpected).toLowerCase();
		if(!actual.contains(expected))
		{
			screenshots.takeScreenShots();
			Assert.fail("The String does not contains "+dataMap.get(controlNameExpected));
		}
				
	}
	
	/**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 19-06-2014
	  Date of Modified                  : --
	  Methods Called                    : getElement(String controlName)
	  Purpose of Method                 : To check whether the element is displayed on the page or not
	  Dependencies	                    : --
	  Reviewed By                       : 
	  **/
	
	public  void isElementDisplayed(String controlName)
	{
		List<WebElement> elements = elementFactory.getElements(controlName);
		for (WebElement element : elements)
		{
			if(!element.isDisplayed())
			{
				screenshots.takeScreenShots();
				Assert.fail(controlName+ "is not displayed on the page");
			}
		}
	}
	
	public  void isElementDisplayed(WebElement element)
	{
		if(!element.isDisplayed())
		{
			screenshots.takeScreenShots();
			Assert.fail(element+ "is not displayed on the page");
		}
		
	}
	
		
	/** 
	 Author Name                       : Vinusha
	 Date of Preparation               : 15/06/2014
	 Date of Modified                  : --
	 Methods Called                    : 
	 Purpose of Method                 : Verifies if text is present and if font is in regular font
	 Dependencies	                   : --
	 Reviewed By                       : --
	 
	**/
	
	public  void isFontRegular(String controlName)	{
		
		WebElement element=elementFactory.getElement(controlName);
		if(element.getText().length()>0)
		{	
			if(!element.getCssValue("font-size").toString().trim().equals("100%") && !element.getCssValue("font-size").toString().trim().equals("16px"))
			{
				screenshots.takeScreenShots();
				Assert.fail(" Font size is not regular for the text under ControlName : "+controlName);
			}			
		}
		else
		{
			screenshots.takeScreenShots();
			Assert.fail("No text found under element with controlName:"+controlName);
		}
		
			
	}
	
	/** 
	 Author Name                       : Pankaj
	 Date of Preparation               : 15/06/2014
	 Date of Modified                  : --
	 Methods Called                    : 
	 Purpose of Method                 : Verify if image src link is returning HTTP 200 status code or not
	 Dependencies	                   : --
	 Reviewed By                       : --
	 
	**/
	
	@SuppressWarnings({ "deprecation"})
	public  void verifyHttpResponse(String imgControlName)  
	{
		try{
		WebElement element = elementFactory.getElement(imgControlName);	
		String tagName = element.getTagName();
		String attribute = null;
		if("a".equals(tagName)){
			attribute = "href";
		}else{
			attribute = "src";			
		}
		@SuppressWarnings("resource")
		org.apache.http.HttpResponse response = (org.apache.http.HttpResponse) new DefaultHttpClient().execute(new HttpGet(element.getAttribute(attribute)));
		if((response.getStatusLine().getStatusCode()!=200))
		{
			screenshots.takeScreenShots();
			Assert.fail("Http Error Code "+response.getStatusLine().getStatusCode()+" encountered. Error Message: "+response.getStatusLine().getReasonPhrase());
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	

	public  void verifyHttpResponse(WebElement element)  
	{
		try{	
			String tagName=null;
			tagName = element.getTagName();
			String attribute = null;
			if("a".equals(tagName)){
				attribute = "href";
			}else{
				attribute = "src";			
			}
	
			org.apache.http.HttpResponse response = (org.apache.http.HttpResponse) new DefaultHttpClient().execute(new HttpGet(element.getAttribute(attribute)));
			if((response.getStatusLine().getStatusCode()!=200))
			{
				screenshots.takeScreenShots();
				Assert.fail("Http Error Code "+response.getStatusLine().getStatusCode()+" encountered for page - "+element.getAttribute(attribute)+". Error Message: "+response.getStatusLine().getReasonPhrase());
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	/** 
	 Author Name                       : Pankaj
	 Date of Preparation               : 15/06/2014
	 Date of Modified                  : 27-08-2014
	 Methods Called                    : 
	 Purpose of Method                 : Verify if Image Carousal is working as it should
	 Dependencies	                   : --
	 Reviewed By                       : --
	 
	**/
	
	public  void verifyCarousal() 
	{
		try
		{
		DownloadImage("./images/Image_At_Start.PNG",driver);
		Thread.sleep(7000);
		DownloadImage("./images/Image_After_7Sec.PNG",driver);
		VerifyImage.processImage("./images/Image_At_Start.PNG", "./images/Image_After_7Sec.PNG");
		}
		catch(Exception e)
		{
			e.getMessage();
		}
	}
	/** 
	 Author Name                       : Pankaj
	 Date of Preparation               : 15/06/2014
	 Date of Modified                  : 27-08-2014
	 Methods Called                    : 
	 Purpose of Method                 : Following function extract the desired image from webpage screenshot.
	 Dependencies	                   : --
	 Reviewed By                       : --
	 
	**/
	public  void DownloadImage(String loc, WebDriver driver) throws IOException{
		File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File file=new File(loc);
        FileUtils.copyFile(screen,file);
	}
	
	/** 
	 Author Name                       : Pankaj
	 Date of Preparation               : 14/07/2014
	 Date of Modified                  : --
	 Methods Called                    : 
	 Purpose of Method                 : The function is used to check whether the expected image is present in webpage or not
	 Dependencies	                   : --
	 Reviewed By                       : --
	 
	**/
	public  void verifyImagePresent(String expectedImage, String imageElement)
	{
		String imageURL=userActions.getHtmlAttribute(imageElement, "src");
		driver.get(imageURL);
		dynamicWait.waittillpageloads();
		try{			
			Thread.sleep(5000);
			ScreenRegion s = new DesktopScreenRegion();
			Target target = new ImageTarget(new File(".//ExpectedImage//"+expectedImage));
			dynamicWait.waittillpageloads();
			ScreenRegion r = s.find(target);
			r.getBounds();
			dynamicWait.waittillpageloads();
			driver.navigate().back();
		}
		catch(NullPointerException | InterruptedException e)
		{
			/*screenshots.takeScreenShots();
			Assert.fail("Not able to find Image on Screen.");*/
			test.log(LogStatus.WARNING, "Not able to find Image on Screen");
		}
		
	}


	/**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 15/7/2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : The method is used to get the text from the alert.
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws AdbCommandRejectedException 
	 * @throws InterruptedException 
	  **/
	
	public  void verifyAlertText(String expectedValue) 
	{
		alert = driver.switchTo().alert();
		assertions.str_Assertequals(alert.getText(), dataMap.get(expectedValue));
	}
	
	/**
    Author Name                       : Sowmya Mohanan
    Date of Preparation               : 17/7/2014
    Date of Modified                  : 27-08-2014
    Methods Called                    :
    Purpose of Method                 : The method is used to check if the video is playing or not.
    Dependencies                      : Jar files
    Reviewed By                       :
    Modified By                       : Niharika K R, Sindhuja P
    **/
 
  public void verifyVideo()
  {
	  String browserName = driver.getCapabilities().getBrowserName();   
	  boolean flag = false;
         try
         {
                Thread.sleep(35000);
                DownloadImage("./videos/Video_At_Start"+browserName+".PNG",driver);
                for(int i=0;i<5;i++)
                {
                Thread.sleep(20000);
                DownloadImage("./videos/Video_After_"+i+1+browserName+"Sec.PNG",driver);                 
                String pass = VerifyImage.processImage("./videos/Video_At_Start"+browserName+".PNG", "./videos/Video_After_"+i+1+browserName+"Sec.PNG");
                userActions.clickOn("VideoCloseButton");
                if(pass.equalsIgnoreCase("Fail"))
                      {
                      flag = true;
                      }
            }
            if(!flag)
            {
                screenshots.takeScreenShots();
                Assert.fail("Test failed since Video is not playing");
            }
         }
        
         catch(Exception e)
         {
                e.getMessage();
         }
  }

	/**
  Author Name                       : P Dhana Lakshmi
  Date of Preparation               : 10/5/2015
  Date of Modified                  : 
  Methods Called                    :
  Purpose of Method                 : The method is used to check if the video is playing or not.
  Dependencies                      : Jar files
  Reviewed By                       :
  Modified By                       : 
  **/
  public void verifyVideoAfterClickingPlay()
  {
	  String browserName = driver.getCapabilities().getBrowserName();   
	  boolean flag = false;
	  
	  try
         {
        
			    Thread.sleep(35000);
			    /*Keyboard kb=driver.getKeyboard();
			    kb.pressKey(Keys.TAB);
			    kb.releaseKey(Keys.TAB);
			    kb.pressKey(Keys.TAB);
			    kb.releaseKey(Keys.TAB);
			    kb.pressKey(Keys.TAB);
			    kb.releaseKey(Keys.TAB);
			    kb.pressKey(Keys.ENTER);
			    kb.releaseKey(Keys.ENTER);*/
			    Robot rb=new Robot();
			    rb.keyPress(java.awt.event.KeyEvent.VK_TAB);
			    rb.keyRelease(java.awt.event.KeyEvent.VK_TAB);
			    rb.keyPress(java.awt.event.KeyEvent.VK_TAB);
			    rb.keyRelease(java.awt.event.KeyEvent.VK_TAB);
//			    rb.keyPress(java.awt.event.KeyEvent.VK_TAB);
//			    rb.keyRelease(java.awt.event.KeyEvent.VK_TAB);
			    rb.keyPress(java.awt.event.KeyEvent.VK_ENTER);
			    rb.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
			   // sikuliActions.clickOnElementUsingImage("playButton.JPG");
                DownloadImage("./videos/Video_At_Start"+browserName+".PNG",driver);
                for(int i=0;i<5;i++)
                {
                Thread.sleep(20000);
                DownloadImage("./videos/Video_After_"+i+1+browserName+"Sec.PNG",driver);                 
                String pass = VerifyImage.processImage("./videos/Video_At_Start"+browserName+".PNG", "./videos/Video_After_"+i+1+browserName+"Sec.PNG");
                if(pass.equalsIgnoreCase("Fail"))
                      {
                      flag = true;
                      }
            }
            if(!flag)
            {
                screenshots.takeScreenShots();
                Assert.fail("Test failed since Video is not playing");
            }
         }
        
         catch(Exception e)
         {
                e.getMessage();
         }
  }
  
  
	
	/**
	  Author Name                       : Sowmya Mohanan
	  Date of Preparation               : 18/7/2014
	  Date of Modified                  : 27-08-2014
	  Methods Called                    : 
	  Purpose of Method                 : The method is used to verify the marquee is playing or not
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	  **/
	public  void verifyMarquee(String childMarquee) 
	{
		List<WebElement> imgElement = elementFactory.getElements(childMarquee);
		boolean flag = false;
		String browserName = driver.getCapabilities().getBrowserName();
		try
		{
			for(int j=0;j<imgElement.size();j++){
				dynamicWait.waitUtillAttributeChanges(imgElement.get(j));
				DownloadImage("./marquee/Marquee_At_Start"+j+browserName+".PNG",driver);
				flag = false;
				for(int i=0;i<5;i++){
					DownloadImage("./marquee/Marquee_"+j+i+1+browserName+".PNG",driver);			
					String pass = VerifyImage.processImage("./marquee/Marquee_At_Start"+j+browserName+".PNG", "./marquee/Marquee_"+j+i+1+browserName+".PNG");
					if(pass.equalsIgnoreCase("Fail")){
						flag = true;
						break;
					}
					if(!flag && i == 4){
						screenshots.takeScreenShots();
						Assert.fail("Marquee is not playing");
					}
				}
			}						
		}
		catch(Exception e)
		{
			e.getMessage();
		}
	}
	
	/** 
	 Author Name                       : Pankaj
	 Date of Preparation               : 14/07/2014
	 Date of Modified                  : --
	 Methods Called                    : 
	 Purpose of Method                 : The function is used to check whether the expected icon is present in webpage or not, where the controlName of the Icon is passed as the first parameter
	 Dependencies	                   : --
	 Reviewed By                       : --
	 
	**/
	public void verifyIcons(String controlName, String expectedImage)
	{
		userActions.hoverOn(controlName);
		ScreenRegion s = new DesktopScreenRegion();
		Target target = new ImageTarget(new File(".//ExpectedImage//"+expectedImage));
		try{
			
			ScreenRegion r = s.find(target);
			r.getBounds();
//			driver.navigate().back();
		}
		catch(NullPointerException e)
		{
			screenshots.takeScreenShots();
			Assert.fail("Not able to find Image on Screen.");
		}
		
	}
	/** 
	 Author Name                       : Sowmya Mohanan
	 Date of Preparation               : 13/08/2014
	 Date of Modified                  : 25/08/2014
	 Methods Called                    : 
	 Purpose of Method                 : The function is used to check whether the expected icon is not present in webpage, where the controlName of the Icon is passed as the first parameter
	 Dependencies	                   : --
	 Reviewed By                       : --
	 
	 **/
	public void verifyIconsNotPresent(String controlName, String expectedImage)
	{
		userActions.hoverOn(controlName);
		ScreenRegion s = new DesktopScreenRegion();
		dynamicWait.waittillpageloads();
		Target target = new ImageTarget(new File(".//ExpectedImage//"+expectedImage));
		ScreenRegion r = s.find(target);
		boolean imagePresent = false;
		try{			
			r.getBounds();
			imagePresent = true;
		}catch(NullPointerException e){
			imagePresent = false;
		}finally{
			if(imagePresent){				
				screenshots.takeScreenShots();
				Assert.fail("Able to find Icon on Screen. But Icon should not be visible");				
			}
		}
				
	}
	/** 
	 Author Name                       : Sowmya Mohanan
	 Date of Preparation               : 21/08/2014
	 Date of Modified                  : 25/08/2014
	 Methods Called                    : 
	 Purpose of Method                 : The function is used to check whether the expected icon is not present in webpage
	 Dependencies	                   : --
	 Reviewed By                       : --
	 
	 **/
	public void verifyIconsNotPresent(WebElement element, String expectedImage)
	{		
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
		ScreenRegion s = new DesktopScreenRegion();
		dynamicWait.waittillpageloads();
		Target target = new ImageTarget(new File(".//ExpectedImage//"+expectedImage));
		ScreenRegion r = s.find(target);
		boolean imagePresent = false;
		try{			
			r.getBounds();
			imagePresent = true;
		}catch(NullPointerException e){
			imagePresent = false;
		}finally{
			if(imagePresent){				
				screenshots.takeScreenShots();
				Assert.fail("Able to find Icon on Screen. But Icon should not be visible");				
			}
		}		
	}
	
	/** 
	 Author Name                       : Pankaj
	 Date of Preparation               : 08/08/2014
	 Date of Modified                  : --
	 Methods Called                    : 
	 Purpose of Method                 : The function is used to check whether the expected icon is present in webpage or not where the WebElement is passed as the first parameter
	 Dependencies	                   : --
	 Reviewed By                       : --
	 
	**/
	public void verifyIcons(WebElement element, String expectedImage)
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
		ScreenRegion s = new DesktopScreenRegion();
		Target target = new ImageTarget(new File(".//ExpectedImage//"+expectedImage));
		try{
	 
			ScreenRegion r = s.find(target);
			r.getBounds();
			// driver.navigate().back();
		}
		catch(NullPointerException e)
		{
			screenshots.takeScreenShots();
			Assert.fail("Not able to find Icon on Screen.");
		}
	 
	}
	
	/**
	  Author Name                       : @author karthik_b14
	  Date of Preparation               : 21/7/2014
	  Date of Modified                  : --
	  Methods Called                    : 
	  Purpose of Method                 : The method is used to verify the page title
	  Dependencies	                    : Jar files
	  Reviewed By                       : 
	 * @throws AdbCommandRejectedException 
	 * @throws InterruptedException 
	  **/
	public  void verifyPageTitle(String controlName){
		
		String title_expected = dataMap.get(controlName);
		String title_actual = driver.getTitle();
		assertions.str_Assertequals(title_actual, title_expected);
	}
	
	/**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 25/7/2014
	  Date of Modified                  : 17-09-2014
	  Methods Called                    : 
	  Purpose of Method                 : The method is used to verify whether the Images in the carousel are rotating twice and stopping at the first image or not
	  Dependencies	                    : Jar files
	  Modified By 						: Sowmya Mohanan, Sindhuja P
	  Reviewed By                       : 
	  **/

	public void verifyImageCarousel(String childCarouselImages) {
		List<WebElement> element = elementFactory
				.getElements(childCarouselImages);
		String browserName = driver.getCapabilities().getBrowserName();
		try {
			for (int j = 0; j < element.size(); j++) {
				dynamicWait.waitUtillAttributeChanges(element.get(j));
				DownloadImage("./carousalimages/Image_At_" + j + browserName
						+ ".PNG", driver);
				if (j > 0) {
					String imageEqual = VerifyImage.processImage(
							"./carousalimages/Image_At_" + (j - 1)
									+ browserName + ".PNG",
							"./carousalimages/Image_At_" + j + browserName
									+ ".PNG");
					if ("Pass".equals(imageEqual)) {
						screenshots.takeScreenShots();
						Assert.fail("Carousel is not playing");
					}
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	/** 
	 Author Name                       : Sindhuja.P
	 Date of Preparation               : 08/08/2014
	 Date of Modified                  : 
	 Methods Called                    : getElement(String controlName) 
	 Purpose of Method                 : To check if a particular element is checked.
	 Dependencies	                   : --
	 Reviewed By                       : --	 
	**/
	
	public void verifyElementIsChecked(String controlName)
	{
		WebElement element=elementFactory.getElement(controlName);
		if(!element.isSelected())
		{
			screenshots.takeScreenShots();
			Assert.fail("The "+controlName+"is not checked");
		}
	}
	
	/**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 08/08/2014
	  Date of Modified                  : --
	  Methods Called                    : getElements(String controlName),int_Assertequals(int iactual,int iexpected) 
	  Purpose of Method                 : To check the length of the text entered in the textbox.
	  Dependencies	                    : --
	  Reviewed By                       : 
	  **/
	
	public void verifyStringLength(String controlName, int expectedLength)
	{
		WebElement element = elementFactory.getElement(controlName);
		String actualLength = element.getAttribute("value");
		assertions.int_Assertequals(actualLength.length(), expectedLength);
	}
	
	/**
	  Author Name                       : Niharika K R 
	  Date of Preparation               : 08/09/2014
	  Date of Modified                  : --
	  Methods Called                    : getElement(String controlName)
	  Purpose of Method                 : To check whether the text is in block letters or not
	  Dependencies	                    : --
	  Reviewed By                       : 
	  **/
	
	public void verifyTextPresentInCaps(String controlName)
	{
		WebElement element = elementFactory.getElement(controlName);
		String element1 = element.getText().trim().replace(" ", "");
		if(!(element1.matches("(\\b[A-Z][A-Z0-9]+\\b)")))
		{
			screenshots.takeScreenShots();
			Assert.fail("The "+controlName+" 's text is not present in block letters");
		}
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
	public void verifyEventsSectionCategories(String eventSectionDiv, String expectedEventSubCategories)
	{
		WebElement eventSection = elementFactory.getElement(eventSectionDiv);
		List<WebElement> eventSubCategories = eventSection.findElements(By.tagName("h3"));
		String subCategories = dataMap.get(expectedEventSubCategories);
		for (WebElement subCategory : eventSubCategories) {
			if(!(subCategories.contains(subCategory.getText())))
			{
				Assert.fail("The expected Category is not present under Event Section");
			}
			
		}
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
	public void verifyEventsCategorization(String selectedEventCheckboxLabel, String expectedEventCategorization)
	{
		WebElement eventCheckBoxLabel = elementFactory.getElement(selectedEventCheckboxLabel);
		
		System.out.println(eventCheckBoxLabel.getText().indexOf("("));
		System.out.println(eventCheckBoxLabel.getText().indexOf(")"));
		System.out.println(eventCheckBoxLabel.getText());
		int noOfEventsUnderLabel = Integer.parseInt(eventCheckBoxLabel.getText().substring(eventCheckBoxLabel.getText().indexOf("(")+1, eventCheckBoxLabel.getText().indexOf(")")));
		userActions.clickOn("EventsCalender_ViewAll");
		List<WebElement> articlesEventTypeOnPage = elementFactory.getElements(expectedEventCategorization);
		Assert.assertEquals(noOfEventsUnderLabel, articlesEventTypeOnPage.size());
		String expectedEventType =eventCheckBoxLabel.getText().substring(0, eventCheckBoxLabel.getText().indexOf("(")) ;
		for (WebElement event : articlesEventTypeOnPage) {
			Assert.assertEquals(event.getText().replace(" ", ""), expectedEventType.replace(" ", ""));
		}
		
	}
	
	
	/**
	  Author Name                          : Pankaj
	  Date of Preparation                  : 29/10/2014
	  Date of Modified                     : --
	  Methods Called                       : 
	  Purpose of Method                    : Verify whether the articles/event date is in past and not equal to current date or future date
	  Dependencies	                       : 
	  Reviewed By                          : --
	**/ 
	public void verifyDateOfPastEventsOrArticles(String eventOrArticlesDateElement)
	{
		List<WebElement> dateElements = elementFactory.getElements(eventOrArticlesDateElement);
		for (WebElement dateElement : dateElements) {
			String date = dateElement.getText();
			if(date.contains("-"))
			{
				String fromDate = date.substring(0, date.indexOf("-")-1);
				Date toDate = new Date();
				Date froDate = new Date();
				DateFormat format = new SimpleDateFormat("DD mmm YYYY", Locale.ENGLISH);
				Date currentDate = new Date();
				
				try {
					froDate = format.parse(fromDate);
					System.out.println(froDate);
					toDate= format.parse(date.substring(date.indexOf("-")+1));
					System.out.println(toDate);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(!(froDate.before(currentDate) && toDate.before(currentDate)))
				{
					System.out.println(froDate.before(currentDate));
					System.out.println((toDate.before(currentDate)));
					Assert.fail("The events/articles date is not in the past");
				}
			}
		}
	}
	/**
	  Author Name                          : Aishwarya
	  Date of Preparation                  : 30/03/2015
	  Date of Modified                     : --
	  Methods Called                       : 
	  Purpose of Method                    :
	  Dependencies	                       : 
	  Reviewed By                          : --
	**/ 
	public void verifySearchResultsCategory(String artcleElements,String searchCriteria)
	{
	       List<WebElement> articles = elementFactory.getElements(artcleElements);
	       for ( WebElement ele: articles) {
	              
	              Assert.assertEquals(ele.getText(), searchCriteria);
	              
	       }
	}

}

