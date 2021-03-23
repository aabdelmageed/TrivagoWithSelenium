/**
 * 
 */
package trivagoTestPages;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import trivago.util.CustomListener;
import trivagoPages.HomePage;
import trivagoPages.TrivagoLoginPage;
import trivagoPages.TrivagoMainPage;
import trivagoPages.TrivagoRegistration;


/**
 * @author Ahmed Adel
 *
 */
@Listeners(CustomListener.class)
public class TrivagoTestCases extends BaseTest{
	@Test(priority=1)	
	public void trivagoRegistration() throws InterruptedException  {

		TrivagoLoginPage trivagoLoginPage;
		HomePage homePage;
		TrivagoRegistration trivagoRegistration;
		trivagoLoginPage=page.getInstance(TrivagoMainPage.class).clickOnLoginBtn();
		trivagoRegistration=page.getInstance(TrivagoLoginPage.class).clickRegistrationBtn();
		homePage=page.getInstance(TrivagoRegistration.class).doRegistration(prob.getProperty("username"), prob.getProperty("password"));
		String loggeduser=homePage.getloggeduser();
		Assert.assertEquals(loggeduser, prob.getProperty("username"));

	}
	
	@Test(priority=2)
	public void logOut() throws Exception {

		TrivagoLoginPage trivagoLoginPage;
		HomePage homePage;
		TrivagoMainPage trivagoMainPage;
		trivagoLoginPage=page.getInstance(TrivagoMainPage.class).clickOnLoginBtn();
		homePage=page.getInstance(TrivagoLoginPage.class).doLogin(prob.getProperty("username"), prob.getProperty("password"));
		homePage.doMouseHoverActionOnLoginUser();
		trivagoMainPage=page.getInstance(HomePage.class).clickSignOutBtn();
		Assert.assertEquals(trivagoMainPage.getElementText(), "Log in");

	}
	
	

}
