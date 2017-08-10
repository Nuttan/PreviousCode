package invoketest;

import java.io.IOException;




import properties.LoadFrameworkProp;
import resources.CreateGridConfig;
import resources.CreateLocalTestBatch;
import resources.CreateTestBatch;

public class InvokeTest {
	private LoadFrameworkProp frameProp;

	/**
	 * This method invokes the dynamically created TestNG Suit xml file for starting Test execution
	 * @throws IOException 
	 */
	public void startTests() throws IOException
	{
		try{
		frameProp = new LoadFrameworkProp();
		String path = getClass().getClassLoader().getResource(".").getPath();
		String command = "cmd /c start cmd.exe /K java -cp \""+frameProp.getTestNGPlugin()+path+"\""+" org.testng.TestNG testng1.xml localtestng.xml" ;
		Runtime.getRuntime().exec(command);
		}
		catch(IOException io)
		{
			io.getMessage();
		}
	}
	
	/**
	 * This Methods calls the Create Batch Method to dynamically generate TestNg suite xml from Batch excel
	 */
	public void createBatchRun()
	{
		CreateGridConfig.createConfig();
		CreateTestBatch.createBatch();
		CreateLocalTestBatch.createLocalBatch();
		
	}
	


}
