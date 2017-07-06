/**
 * 
 */
package testData;

/**
 * @author phanendra_k01
 *
 */
public class Testing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TestDataFactory tdFactory=new TestDataFactory();
		tdFactory.createTestDataMap();
		TestDataMap<String, String> testDataMap = tdFactory.getTestMap();
	

	}

}
