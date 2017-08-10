package test;

import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

import io.selendroid.client.SelendroidDriver;
import io.selendroid.common.SelendroidCapabilities;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class sample {
	
	RemoteWebDriver driver;
	ExtentReports extent;
	ExtentTest test;
	
	@BeforeSuite
    public void M1(){
        extent = ExtentManager.Instance();
    }
	
	@BeforeClass
	public void proxySetting(){
		System.setProperty("http.proxyHost", "10.136.64.150");
		System.setProperty("http.proxyPort", "80");
	}
	
	@Test
	public void test() throws Exception{

		/*Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.136.64.150", 80));
		URL url = new URL("http://www.somewebsite.com");
		HttpURLConnection uc = (HttpURLConnection)url.openConnection(proxy);*/
		
		/*System.setProperty("http.proxyHost", "10.136.64.150");
	    System.setProperty("http.proxyPort", "80");
	    System.setProperty("http.nonProxyHosts", "localhost|127.0.0.1");
		System.setProperty("http.proxyUser", "hemasai.nimmala");
		System.setProperty("http.proxyPassword", "n$Ai12071965");*/
		DesiredCapabilities caps = SelendroidCapabilities.android();
		test = extent.startTest("Go to Google Search page", "");
		driver = new SelendroidDriver(caps);
		driver.get("https://www.google.com");
		test.log(LogStatus.PASS, "Navigated to Google Search page",test.addScreenCapture(ExtentManager.CaptureScreen(driver, ExtentManager.appConfig.getDeviceReportLocation()+"/GoogleSearchPage")));
	}
	
	@AfterMethod
	  public void close() {
	    if (driver != null) {
	      driver.quit();
	  }
	}
	  
	  @AfterSuite(alwaysRun = true)
	    public void endReport(){
	          extent.endTest(test);
	          extent.flush();
	    }
}

