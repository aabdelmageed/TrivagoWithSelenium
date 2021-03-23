package trivagoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By loggeduser = By.xpath("//span[@data-di-mask='true']");
	private By mouseHoverToLoggedUser = By.xpath("//span[@data-di-mask='true']");
	private By signOutBtn = By.xpath("//button[contains(text(),'Log out')]");


	public Actions doMouseHoverActionOnLoginUser() {

		return doAction(mouseHoverToLoggedUser);
	}
	


	public WebElement getSignOutBtn() {
		return getElement(signOutBtn);
	}
	


	public String getloggeduser() {
		return getElement(loggeduser).getText();
	}

	public TrivagoMainPage clickSignOutBtn() {
		doMouseHoverActionOnLoginUser().build().perform();
		getSignOutBtn().click();

		return getInstance(TrivagoMainPage.class);
	}
	


}
