package MLL.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import MLL.AbstractComponents.AbstractComponent;
import MLL.AbstractComponents.Utility;
import MLL.PageObjects.LoginPageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public LoginPageObjects loginPageObjects;
	public Logger log = LogManager.getLogger(BaseTest.class);
	public String browserName = null;
	public String WmsUrl = null;
	public String ItemCodeValue = null;
	public String ItemStatus = null;
	public String supplier = null;
	public String UOMValue = null;
	public Properties prop;
	public Utility util;

//	private static final Logger logger = LogManager.getLogger(BaseTest.class);
	public WebDriver initializeDriver() {
		util = new Utility();
		util.setFileInputValue(
				System.getProperty("user.dir") + "//src//main//java//MLL//Resources//GlobalData.properties");
		browserName = util.getPropertyValue("browser");
		WmsUrl = util.getPropertyValue("WmsBaseUrl");
		ItemCodeValue = util.getPropertyValue("itemCode");
		ItemStatus = util.getPropertyValue("itemStatus");
		supplier = util.getPropertyValue("supplierValue");
		UOMValue = util.getPropertyValue("UOM");
		if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

			log.info("browser will invoke");
		} else if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		return driver;

	}

	@BeforeClass
	public void launchApplication() throws IOException {
		// TODO Auto-generated method stub
		driver = initializeDriver();
		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get(WmsUrl);
	}

	public void loginScreen(HashMap<String, String> input) throws InterruptedException {
		loginPageObjects = new LoginPageObjects(driver);
		loginPageObjects.loginApplication(input.get("username"), input.get("password"));
		Thread.sleep(5000);
		loginPageObjects.selectWarehouse();
	}

	@DataProvider
	public Object[][] getData() throws IOException {

		HashMap<String, String> FunAdmin = new HashMap<String, String>();
		FunAdmin.put("username", "Preetham");
		FunAdmin.put("password", "Welcome@1234");
		return new Object[][] { { FunAdmin } };
	}

//	@AfterClass
//	public void teardown() {
//		driver.close();
//	}
}
