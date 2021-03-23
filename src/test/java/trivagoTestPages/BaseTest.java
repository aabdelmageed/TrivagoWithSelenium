package trivagoTestPages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import trivago.util.TestUtil;
import trivagoPages.BasePage;
import trivagoPages.Page;

public class BaseTest {

	public static WebDriver driver;
	public static Properties prob;
	public Page page;

	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();

	public BaseTest() {
		prob = new Properties();
		try {
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/java/trivago/config/config.properties");
			prob.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException o) {
			o.printStackTrace();
		}
	}

	@BeforeMethod
	public void setUp() {
		String browserName = prob.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();

			options.addArguments("incognito");
			driver = new ChromeDriver(options);
		} else if (browserName.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browserName.equals("IE")) {
			System.out.println("browserName   " + browserName);
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/drivers/IEDriverServer.exe");
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			caps.setCapability("ignoreZoomSetting", true);
			driver = new InternetExplorerDriver(caps);
		}

		tdriver.set(driver);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prob.getProperty("url"));

		page = new BasePage(driver);
	}

	public void takeScreenShotForFailedTest(String FailedTestName) throws IOException {
		DateFormat df = new SimpleDateFormat("dd-MM-yy HH-mm-ss");
		Calendar calobj = Calendar.getInstance();
		String DateFormat = df.format(calobj.getTime());
		System.out.println("RFRFRFRRFRV  " + DateFormat);
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "/screenshoots/" + FailedTestName +

				" " + DateFormat + ".jpg"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
