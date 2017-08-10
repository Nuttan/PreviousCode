package report;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class AreaDataTable {
	private Object[][] dataTable;
	private HashMap<String, Integer> passAreaCount;
	private HashMap<String, Integer> failAreaCount;
	private HashMap<String, Integer> skipAreaCount;
	private List<Object> testCaseAreas;
	public Object[] [] generateAreaDataTable(ParsingTestResultXML results)
	{
		AreaCount count = null;
		try {
			count = new AreaCount(results);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		testCaseAreas=count.getlTestCaseAreas();
		count.generateAreasTestCount();
		passAreaCount=count.getPassAreaCount();
		failAreaCount=count.getFailAreaCount();
		skipAreaCount=count.getSkipAreaCount();
		dataTable= new Object[passAreaCount.size()][4];
		int size=passAreaCount.size();
		int j=0;
		Iterator<String> iterate=passAreaCount.keySet().iterator();
		while(size!=0)
		{
			dataTable[j][0]=iterate.next();
			j++;
			size--;
		}
		for(int i=0;i<passAreaCount.size();i++)
		{
			dataTable[i][1]=passAreaCount.get(dataTable[i][0]);
			dataTable[i][2]=failAreaCount.get(dataTable[i][0]);
			dataTable[i][3]=skipAreaCount.get(dataTable[i][0]);
			}
			
		return dataTable;
	}

}
