/**
 * 
 */
package invoketest;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import objectRepository.ObjectFactory;
import objectRepository.ObjectMap;
import objectRepository.UIControlObject;
import testData.TestDataFactory;
import testData.TestDataMap;

/**
 * @author pankaj_sharma32
 *
 */
public class StartExecution {
	private static ObjectMap<String, UIControlObject> objMap=null;
	private static TestDataMap<String, String> testDataMap=null;

	

	/**
	 * @param args
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
		// TODO Auto-generated method stub
		/*ObjectFactory factory = new ObjectFactory();
		factory.createObjectMap();
		objMap = factory.getObjectMap();	*/	
		//Test Data Factory
		TestDataFactory tdFactory=new TestDataFactory();
		tdFactory.createTestDataMap();
		testDataMap=tdFactory.getTestMap();
		InvokeTest invoke = new InvokeTest();
		invoke.createBatchRun();
		invoke.startTests();
		//TestReport.generateReport();
	}
	/*public static ObjectMap<String, UIControlObject> getObjMap() {
		return objMap;
	}
    public static TestDataMap<String, String> getTestMap(){
    	return testDataMap;
    }*/
}
