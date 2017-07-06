package test;

import java.io.IOException;

public class cmdTest {
	
	public static void main(String []args) throws IOException{
		Runtime rt = Runtime.getRuntime();
		Process p = rt.exec("cmd /k dir /s");
	}

}
