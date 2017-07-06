package utilities;

import java.util.List;

import objectRepository.ObjectFactory;
import objectRepository.ObjectMap;
import objectRepository.UIControlObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import exceptions.ExceptionHandling_NoSuchElementException;

public class CMSWebElementFactory {

	protected RemoteWebDriver driver;

	public CMSWebElementFactory(RemoteWebDriver driver) {
		this.driver = driver;
	}

	public void doMouseAction(String controlName, String typeOfAction) {
		WebElement element = getElement(controlName);
		Actions actions = new Actions(driver);
		Action action;
		switch (typeOfAction) {
		case "click":
			actions.click(element);
			actions.build().perform();
			break;
		case "clickandhold":
			actions.clickAndHold(element);
			action = actions.build();
			action.perform();
			break;
		case "doubleclick":
			actions.doubleClick(element);
			action = actions.build();
			action.perform();
			break;
		case "contextclick":
			actions.contextClick(element);
			action = actions.build();
			action.perform();
			break;
		case "hover":
			Action mouseHover = actions.moveToElement(getElement(controlName))
					.build();
			mouseHover.perform();
			break;
		case "release":
			actions.release(element);
			action = actions.build();
			action.perform();
			break;
		default:
			break;
		}
	}

	public WebElement getElement(String controlName) {
		List<WebElement> element = null;
		ObjectFactory factory = new ObjectFactory();
		factory.createCMSObjectMap();
		ObjectMap<String, UIControlObject> map = factory.getObjectMap();
		UIControlObject obj = map.get(controlName);
		By elementLocator = getLocator(obj.getControlProperty(),
				obj.getTypeOfProperty());
		try {
			element = driver.findElements(elementLocator);
			if (element.size() == 0) {
				new ExceptionHandling_NoSuchElementException(controlName);
			} else {
				return element.get(0);
			}

		} catch (StaleElementReferenceException e) {

		}
		return element.get(0);
	}

	public List<WebElement> getElements(String controlName) {
		ObjectFactory factory = new ObjectFactory();
		factory.createCMSObjectMap();
		ObjectMap<String, UIControlObject> map = factory.getObjectMap();
		;
		UIControlObject obj = map.get(controlName);
		By locator = getLocator(obj.getControlProperty(),
				obj.getTypeOfProperty());
		List<WebElement> element = driver.findElements(locator);
		return element;
	}

	public By getLocator(String controlProperty, String propertyType) {

		switch (propertyType) {
		case "xpath":
			return By.xpath(controlProperty);
		case "id":
			return By.id(controlProperty);
		case "name":
			return By.name(controlProperty);
		case "linktext":
			return By.linkText(controlProperty);
		case "partiallinktext":
			return By.partialLinkText(controlProperty);
		case "classname":
			return By.className(controlProperty);
		case "cssSelector":
			return By.cssSelector(controlProperty);
		case "tagname":
			return By.tagName(controlProperty);
		default:
			return null;
		}
	}

	public void enterText(String controlName, String text) {
		Actions actions = new Actions(driver);
		WebElement element = getElement(controlName);
		actions.sendKeys(element, text).perform();

	}

	public void clearTextBox(String controlName) {
		getElement(controlName).clear();
	}

	public void selectDropdownValue(String controlName, int value) {
		WebElement pubdestination = getElement(controlName);
		Select publishDestination = new Select(pubdestination);
		publishDestination.selectByIndex(value);
	}

	public void selectFromSelectBox(String controlName, String text) {
		Select element = new Select(getElement(controlName));
		element.selectByVisibleText(text);
	}

	public void dynamicWait(String controlName, long maxSeconds) {
		ObjectFactory factory = new ObjectFactory();
		factory.createCMSObjectMap();
		By elementLocator = null;
		ObjectMap<String, UIControlObject> map = factory.getObjectMap();
		try {
			UIControlObject obj = map.get(controlName);
			elementLocator = getLocator(obj.getControlProperty(),
					obj.getTypeOfProperty());
		} catch (NullPointerException | NoSuchElementException e) {

		}
		// WebElement element = null;
		long maxMilliseconds = maxSeconds * 10;
		long additionalDelay = 2;
		long elapsedMilliseconds = 100;
		while (++elapsedMilliseconds < maxMilliseconds) {
			try {
				WebElement element = driver.findElement(elementLocator);
				element.isDisplayed();
				break;
			} catch (NullPointerException | NoSuchElementException
					| StaleElementReferenceException e) {

			}
			try {
				Thread.sleep(elapsedMilliseconds + additionalDelay);
			} catch (Exception excp) {
			}
			elapsedMilliseconds = elapsedMilliseconds + additionalDelay;
		}

	}

	// for(long elapsedMilliseconds = 0;
	// elapsedMilliseconds < maxMilliseconds;
	// elapsedMilliseconds += incrementMilliseconds) {
	// try {
	// element = driver.findElement(elementLocator);
	// break;
	// } catch(Exception e) {
	//
	// }
	// try { Thread.sleep(incrementMilliseconds); } catch(Exception excp) { }
	// }
	// return element;
	// }

	public List<WebElement> getChildElements(WebElement parent,
			String childControls) {
		ObjectFactory factory = new ObjectFactory();
		factory.createObjectMap();
		ObjectMap<String, UIControlObject> map = factory.getObjectMap();
		UIControlObject obj = map.get(childControls);
		By locator = getLocator(obj.getControlProperty(),
				obj.getTypeOfProperty());
		// return parent.findElements(locator);
		List<WebElement> element = parent.findElements(locator);
		if (element.size() == 0) {
			throw new ExceptionHandling_NoSuchElementException(childControls);
		} else {
			return element;
		}
	}

	public List<WebElement> getElementNotPresent(String controlName) {

		ObjectFactory factory = new ObjectFactory();
		factory.createCMSObjectMap();
		ObjectMap<String, UIControlObject> map = factory.getObjectMap();
		UIControlObject obj = map.get(controlName);
		By elementLocator = getLocator(obj.getControlProperty(),
				obj.getTypeOfProperty());
		List<WebElement> element = driver.findElements(elementLocator);
		if (element.size() == 0) {
		} else {
			return element;
		}
		return element;

	}

}
