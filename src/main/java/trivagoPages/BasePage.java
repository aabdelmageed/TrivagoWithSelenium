package trivagoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends Page {

	public BasePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getElementText(By locator) {
		return getElement(locator).getText();
	}

	@Override
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			element = driver.findElement(locator);
			//return element;
		} catch (Exception e) {
			e.getMessage();
		}
		return element;
	}

	@Override
	public void waitForElementPresent(By locator,long timeOutInSeconds) {
		//wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		
		new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.elementToBeClickable(locator));
	}


	@Override
	public Actions doAction(By locator) {

		Actions action= new Actions(driver);
		WebElement element=driver.findElement(locator);
		action.moveToElement(element).build().perform();
		return action;
	}

}
