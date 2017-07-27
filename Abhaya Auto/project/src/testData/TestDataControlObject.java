package testData;

public class TestDataControlObject {
	private String controlName;
	private String expectedResult;
	
	/**
	 * @return UI Control Name String
	 */
	public String getControlName() {
		return controlName;
	}
	/**
	 * Set the Name of UI Control
	 * @param controlName
	 */
	public void setControlName(String controlName) {
		this.controlName = controlName;
	}
	/**
	 * 
	 * @return
	 */
	public void setExpectedResults(String expectedResult) {
		this.expectedResult = expectedResult;
	}

	public String getExpectedResult() {
		return expectedResult;
	}
	

}
