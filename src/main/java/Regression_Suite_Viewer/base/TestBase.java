package Regression_Suite_Viewer.base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Regression_Suite_Viewer.util.TimeUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties property;

	public TestBase() {
		try {
			property = new Properties();
			FileInputStream fl = new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
			property.load(fl);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {

		//WebDriverManager.chromedriver().setup();
		
		String browNames = property.getProperty("browser");

		if (browNames.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browNames.equals("FireFox")) {
			System.setProperty("webdriver.gecko.driver", "Drivers\\geckodriver.exe");
			driver =  new FirefoxDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TimeUtil.Page_Load_Time, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TimeUtil.Implicit_Time, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to(property.getProperty("url"));
	}

	public static void closebrowser() {
		driver.close();
	}

}
