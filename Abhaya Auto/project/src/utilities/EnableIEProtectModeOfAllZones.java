package utilities;

import java.io.IOException;

public class EnableIEProtectModeOfAllZones {
	
	 public EnableIEProtectModeOfAllZones() {

	    final String[] ZONES = {
	        "\"HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\1\""
	        , "\"HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\2\""
	        , "\"HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\3\""
	        , "\"HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\4\""
	    };
	    for (String zone : ZONES) {
	        ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "reg", "add",
	                zone, "/v", "2500", "/t", "REG_DWORD", "/d", "0", "/f");
	        try {
	            pb.start();
	        } catch (IOException ioe) { ioe.printStackTrace(); }
	    }
	}


}
