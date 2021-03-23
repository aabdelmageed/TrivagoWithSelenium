package trivagoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TrivagoMainPage extends BasePage {

	public TrivagoMainPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	private By loginLink=By.xpath("//span[contains(text(),'Log in')]");

	String menuMainPeg=getElementText(loginLink);
	
	
	
	public String getElementText() {
		return getElementText(loginLink);
	}

	public WebElement getloginLink() {
		return getElement(loginLink);
	}
	
	public TrivagoLoginPage clickOnLoginBtn() throws InterruptedException {
		wait= new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(loginLink));
		getloginLink().click();

		return getInstance(TrivagoLoginPage.class);
	}
	
	
}
