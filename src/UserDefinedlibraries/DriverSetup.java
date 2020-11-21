package UserDefinedlibraries;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetup{
/**
 * This class is defined to setup various drivers
 * 
 *  @author 875192
 *  @since 2020-11-02
 */
public static WebDriver driver;
public static String exePath;
public static String url = "https://www.air.irctc.co.in/";
public static String browsertype;

public static WebDriver driverInstantiate(String browser) {
	browsertype= browser;
	if(browsertype.equalsIgnoreCase("chrome")) {
		exePath = "C:\\Users\\sam\\eclipse-workspace\\TripAutomation\\Drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		driver = new ChromeDriver();
	}
	else if(browser.equalsIgnoreCase("firefox")) {
		exePath = "C:\\Users\\sam\\eclipse-workspace\\TripAutomation\\Drivers\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", exePath);
		driver = new FirefoxDriver();
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get(url);
	driver.manage().deleteAllCookies();
	return driver;
}

public static void driverClose() {
	DriverSetup.driver.close();
	}

}