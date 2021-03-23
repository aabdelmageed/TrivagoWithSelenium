package trivagoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class TrivagoLoginPage extends BasePage {

	public TrivagoLoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By emailAddress = By.id("check_email");
	private By loginEmailSubmit = By.xpath("//span[contains(text(),'Next')]");
	private By loginPassword = By.id("login_password");
	private By loginSubmit = By.id("login_submit");
	private By registerButn = By.id("login_signup_link");

	public WebElement getloginLink() {
		return getElement(registerButn);
	}

	public WebElement getEmailAddress() {
		return getElement(emailAddress);
	}

	public WebElement getLoginEmailSubmit() {
		return getElement(loginEmailSubmit);
	}

	public WebElement getLoginPassword() {
		return getElement(loginPassword);
	}

	public WebElement getLoginSubmit() {
		return getElement(loginSubmit);
	}

	public TrivagoRegistration clickRegistrationBtn() {

		getloginLink().click();

		return getInstance(TrivagoRegistration.class);
	}

	public HomePage doLogin(String emailAddress, String pwd) throws Exception {

		getEmailAddress().clear();
		getEmailAddress().sendKeys(emailAddress);
		getLoginEmailSubmit().click();
		
		// Page Not Getting Populated With DOM And Refresh Failing With Access Denied 
//		WebElement element = driver.findElement(loginEmailSubmit);
//		JavascriptExecutor executor = (JavascriptExecutor) driver;
//		executor.executeScript("arguments[0].click();", element);
		
		//Refresh
//		driver.navigate().to(driver.getCurrentUrl());

//		 wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.visibilityOf(getElement(loginEmailSubmit)));
//		wait.until(ExpectedConditions.elementToBeClickable(loginSubmit));
//		System.out.println("XXXXXX   " + getElement(loginSubmit).isDisplayed());
		
		getLoginPassword().clear();
		getLoginPassword().sendKeys(pwd);
		wait.until(ExpectedConditions.presenceOfElementLocated(loginSubmit));
		getLoginSubmit().click();

		return getInstance(HomePage.class);
	}

}
