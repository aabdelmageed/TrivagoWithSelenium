/**
 * 
 */
package trivagoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * @author Ahmed Adel
 *
 */
public class TrivagoRegistration extends BasePage {

	public TrivagoRegistration(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By emailId = By.xpath("//input[@id='register_email']");
	private By password = By.xpath("//input[@id='register_password']");
	private By loginBtn = By.id("register_email_submit");
	

	public WebElement getEmailId() {
		return getElement(emailId);
	}

	public WebElement getPassword() {
		return getElement(password);
	}

	public WebElement getLoginBtn() {
		return getElement(loginBtn);
	}

	public HomePage doRegistration(String emailAddress, String pwd) throws InterruptedException {
		getEmailId().clear();
		getEmailId().sendKeys(emailAddress);
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(password));
		getPassword().sendKeys(pwd);
		getLoginBtn().click();

		return getInstance(HomePage.class);
	}
	

}