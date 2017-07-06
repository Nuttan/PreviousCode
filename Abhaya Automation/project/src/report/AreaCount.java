package report;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class AreaCount {
	
	private ArrayList<String []> areaDataTable;
	private HashMap<String,String> areaMap;
	private ParsingTestResultXML results;
	private List<Object> lTestName;
	private List<Object> lClassName;
	private List<Object> lTestmethodname;	
	private List<Object> lTestmethoddescription;
	private List<Object> lStatus;	
	private List<Object> lErrormessage;
	private List<Object> ltestduration;
	private List<Object> lScreenShotlink;
	private List<Object> lbrowserStatus;
	private Set<Integer> indexes;
	private List<Object> areas;
	private List<Object> lTestCaseAreas;
	public List<Object> getlTestCaseAreas() {
		return lTestCaseAreas;
	}
	private HashMap<String, Integer> passAreaCount;
	private HashMap<String, Integer> failAreaCount;
	private HashMap<String, Integer> skipAreaCount;
	public AreaCount(ParsingTestResultXML results) throws IOException
	{
		areaDataTable= new ArrayList<>();
		passAreaCount=new HashMap<>();
		failAreaCount=new HashMap<>();
		skipAreaCount=new HashMap<>();
		
		this.results = results;
		areas= new ArrayList<>();
		lTestCaseAreas=new ArrayList<>();
		areaMap=results.getAreaMap();
		lTestmethodname=results.gettestmethodname();
		lStatus=results.getStatus();
		for(int i = 0; i<lTestmethodname.size();i++)
		{
			String testName=(String) lTestmethodname.get(i);
			String area=areaMap.get(testName);
			lTestCaseAreas.add(i, area);
		}
		
		
	}
	public void generateAreasTestCount()
	{
		for(int i=0;i<lTestCaseAreas.size();i++)
		{
			String area = (String) lTestCaseAreas.get(i);
			if(passAreaCount.containsKey(area))
			{
				int passCount=passAreaCount.get(area);
				int failCount=failAreaCount.get(area);
				int skipCount=skipAreaCount.get(area);
			
			
				
				if(lStatus.get(i).toString().equalsIgnoreCase("Pass"))
				{
					passAreaCount.remove(area);
					passAreaCount.put(area, ++passCount);
				}
				else if(lStatus.get(i).toString().equalsIgnoreCase("Fail"))
				{
					failAreaCount.remove(area);
					failAreaCount.put(area, ++failCount);
				}
				else
				{
					skipAreaCount.remove(area);
					skipAreaCount.put(area,++skipCount);
				}
				
			
			}
			else
			{
				if(lStatus.get(i).toString().equalsIgnoreCase("Pass"))
				{
					passAreaCount.put(area, 1);
					failAreaCount.put(area, 0);
					skipAreaCount.put(area, 0);
				}
				else if(lStatus.get(i).toString().equalsIgnoreCase("Fail"))
				{
					passAreaCount.put(area, 0);
					failAreaCount.put(area, 1);
					skipAreaCount.put(area, 0);
				}
				else
				{
					passAreaCount.put(area, 0);
					failAreaCount.put(area, 0);
					skipAreaCount.put(area, 1);
				}
				
			}
				
		}
	}
	public HashMap<String, Integer> getPassAreaCount() {
		return passAreaCount;
	}
	public HashMap<String, Integer> getFailAreaCount() {
		return failAreaCount;
	}
	public HashMap<String, Integer> getSkipAreaCount() {
		return skipAreaCount;
	}
	
	
}
