/**
 * 
 */
package properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author pankaj_sharma32
 *
 */

public class LoadAppConfig {
	private String appUrl;
	private String invUrl;
	private String adminUsername;
	private String adminPassword;
	private String username;
	private String password;
	private String seoUrl;
	private String benefitsUrl;
	private String eventsUrl;
	private String ipv6Url;
	private String sdnUrl; 
	private String facebookUrl;
	private String googlePlusUrl;
	private String pInterestUrl;
	private String linkedInUrl;
	private String twitterUrl;
	private String avayaEmailUrl;
	private String caseStudiesUrl;
	private String newsRoomUrl;
	private String imagineUrl;
	private String avayaLabsUrl;
	private String errorUrl;
	private String demandGenUrl;
	private String partnerUrl;
	private String premiumContentFormAUrl;
	private String premiumContentFormBUrl;
	private String testUrl;
	private String avayaUserName;
	private String avayaPassword;
	private String investorsUserName;
	private String investorsPassword;
	private String cmsStagingUrl;
	private String cmsTestUrl;
	private String partnersLandingPage;
	private String engagementLaunchMicrositeUrl;
	private String stagemanagementUrl;
    private String imagineStageManagementUrl;
    private String faqUrl;
    private String investorUrl;
    private String sponsorshipUrl;
    private String videoPortalUrl;
    private String AvayaSnapInsUrl;
    private String MobileTestURL;
    private String MUserName;
    private String MPassword;
    private String DeviceReportLocation;
    private String MobileNonResponsiveURL;

    public String getInvestorUrl() {
        return investorUrl;
 }

    public String getStagemanagementUrl() {
        return stagemanagementUrl;
    }
    public String getImagineStageManagementUrl() {
        return imagineStageManagementUrl;
    }
    
	public String getPartnersLandingPage(){
		return partnersLandingPage;
	}
	

	public String getCmsStagingUrl() {
		return cmsStagingUrl;
	}
	public String getCmsTestUrl() {
		return cmsTestUrl;
	}
	public String getAdminUserName() {
		return adminUsername;
	}
	public String getAvayaUserName() {
		return avayaUserName;
	}
	public String getAvayaPassword() {
		return avayaPassword;
	}
	public String getInvestorsUserName() {
		return investorsUserName;
	}
	public String getInvestorsPassword() {
		return investorsPassword;
	}
	public String getPremiumContentFormAUrl() {
		return premiumContentFormAUrl;
	}
	public String getPremiumContentFormBUrl() {
		return premiumContentFormBUrl;
	}
	public String getPartnerUrl()
	{
		return partnerUrl;
	}
	public String getSeoUrl() {
		return seoUrl;
	}
	public String getBenefitsUrl() {
		return benefitsUrl;
	}
	public String getDemandGenUrl() {
		return demandGenUrl;
	}
	public String getInvUrl() {
		return invUrl;
	}
	public String getAppUrl() {
		return appUrl;
	}
	public String getAdminUsername() {
		return adminUsername;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getSeo_Url() {
		return seoUrl;
		}
	public String getBefenitsUrl() {
		return benefitsUrl;
		}
	public String getEventsUrl() {
		return eventsUrl;
		}
	public String getIpv6Url() {
		return ipv6Url;
	}
    public String getSdnUrl() {
		return sdnUrl;
	}
	public String getFacebookUrl() {
		return facebookUrl;
	}
	public String getGooglePlusUrl() {
		return googlePlusUrl;
	}
	public String getpInterestUrl() {
		return pInterestUrl;
	}
	public String getLinkedInUrl() {
		return linkedInUrl;
	}
	public String getTwitterUrl() {
		return twitterUrl;
	}
	public String getAvayaEmailUrl() {
		return avayaEmailUrl;
	}
	public String getCaseStudiesUrl() {
		return caseStudiesUrl;
	}
	public String getNewsRoomUrl()
	{
		return newsRoomUrl;
	}
	public String getImagineUrl()
	{
		return imagineUrl;
	}
	public String getAvayaLabsUrl()
	{
		return avayaLabsUrl;
	}
	public String getErrorUrl() {
		return errorUrl;
	}
	public String getTestUrl() {
		return testUrl;
	}
	public String getEngagementLaunchMicrositeUrl() {
		return engagementLaunchMicrositeUrl;
	}
	public String getFaqUrl() {
		return faqUrl;
	}
	public String getSponsorshipUrl() {
        return sponsorshipUrl;
 }
	public String getVideoPortalUrl() {
        return videoPortalUrl;
 }
	public String getAvayaSnapInsUrl() {
        return AvayaSnapInsUrl;
 }
	public String getMobileTestUrl() {
        return MobileTestURL;
 }
	
	public String getMUserName() {
        return MUserName;
 }
	
	public String getMPassword() {
        return MPassword;
 }
	
	public String getDeviceReportLocation() {
        return DeviceReportLocation;
 }
	
	public String getMobileNonResponsiveUrl() {
        return MobileNonResponsiveURL;
 }	
	
	
	public LoadAppConfig()
	{
		Properties prop = new Properties();
		InputStream is = null;
		
		try
		{
			
			File config = new File("app-config.properties");
			is = new FileInputStream(config);
			
		}
		catch(Exception e)
		{
			is = null;
		}
		try
		{
			if(is==null)
			{
				is = getClass().getResourceAsStream("app-config.properties");
			}
			prop.load(is);
			appUrl = prop.getProperty("app-url");
			invUrl = prop.getProperty("Investors_Url");
			seoUrl = prop.getProperty("SEO_Url");
			benefitsUrl = prop.getProperty("Benefits_url");
			eventsUrl = prop.getProperty("Events_url");
			ipv6Url = prop.getProperty("IPV6_Url");
			sdnUrl = prop.getProperty("SDN_Url");
			linkedInUrl = prop.getProperty("Linkedin_Url");
			facebookUrl = prop.getProperty("Facebook_Url");
			googlePlusUrl = prop.getProperty("GooglePlus_Url");
			twitterUrl = prop.getProperty("Twitter_Url");
			avayaEmailUrl = prop.getProperty("AvayaEmail_Url");
			caseStudiesUrl = prop.getProperty("CaseStudies_Url");
			newsRoomUrl = prop.getProperty("NewsRoom_Url");
			imagineUrl = prop.getProperty("Imagine_Url");
			avayaLabsUrl=prop.getProperty("AvayaLabs_Url");
		    errorUrl = prop.getProperty("Error_Url");
		    demandGenUrl = prop.getProperty("DemandGen_URL");
		    partnerUrl = prop.getProperty("Partners_Url");
		    premiumContentFormAUrl = prop.getProperty("PremiumContentFormA_Url");
		    premiumContentFormBUrl = prop.getProperty("PremiumContentFormB_Url");
		    testUrl	= prop.getProperty("Test_Url");	
		    adminUsername = prop.getProperty("AdminUser");
			adminPassword = prop.getProperty("AdminPassword");
			avayaUserName = prop.getProperty("AvayaUser");
			avayaPassword = prop.getProperty("AvayaPassword");
			investorsPassword = prop.getProperty("InvestorsPassword");
			investorsUserName = prop.getProperty("InvestorsUser");
			cmsStagingUrl = prop.getProperty("CMS_StagingEnvironment");
			cmsTestUrl = prop.getProperty("CMS_TestEnvironment");
			partnersLandingPage = prop.getProperty("PartnersLandingPage_Url");
			engagementLaunchMicrositeUrl=prop.getProperty("EngagementLaunchMicrositePage_Url");
			stagemanagementUrl=prop.getProperty("StageManagement_url");
			imagineStageManagementUrl=prop.getProperty("ImagineStageManagement_Url");
			faqUrl=prop.getProperty("FAQ_url");
			investorUrl=prop.getProperty("Investor_Url");
			sponsorshipUrl=prop.getProperty("sponsorship_Url");
			videoPortalUrl=prop.getProperty("video_URL");
			AvayaSnapInsUrl=prop.getProperty("AvayaSnapIns_Url");
			MobileTestURL=prop.getProperty("MobileTest_URL");
			MUserName=prop.getProperty("musername");
			MPassword=prop.getProperty("mpassword");
			MobileNonResponsiveURL=prop.getProperty("MobileNonResponsive_URL");
			DeviceReportLocation=prop.getProperty("DeviceReportLoc");
		}
		catch(Exception e)
		{
			
		}
		
	}
	
	

}
