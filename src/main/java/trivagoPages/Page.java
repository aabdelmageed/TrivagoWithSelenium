package trivagoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
	
	WebDriver driver;
	WebDriverWait wait;
	
	
	public Page(WebDriver driver) {
		this.driver = driver;
	}
	
	//Abstract Methods
	
	public abstract String getElementText(By locator);
	public abstract WebElement getElement(By locator);
	public abstract void waitForElementPresent(By locator,long timeOutInSeconds);
	public abstract Actions doAction(By locator);
	
	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass ){
		try {
		 return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
		}catch(Exception e) {
			e.getMessage();
			return null;
			
		}
	}

}
