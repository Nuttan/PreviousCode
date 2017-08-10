package objectRepository;

public class UIControlObject {
	private String controlName;
	private String controlProperty;
	private String typeOfProperty;
	
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
	public String getControlProperty() {
		return controlProperty;
	}
	public void setControlProperty(String controlProperty) {
		this.controlProperty = controlProperty;
	}
	public String getTypeOfProperty() {
		return typeOfProperty;
	}
	public void setTypeOfProperty(String typeOfProperty) {
		this.typeOfProperty = typeOfProperty;
	}

}
