package util;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import stepdefinitioncode.BasePage;

//@RunWith(Cucumber.class)
public class Hooks extends BasePage {
	
	static WebDriver webDriver;
	static AndroidDriver appiumDriver;
	
	@Before("@Web")
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
		webDriver= new ChromeDriver();
		webDriver.manage().window().maximize();
		}
	
	@Before("@mobile") 
	public static void AppiumSetUp() throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities(); 
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		//cap.setCapability(MobileCapabilityType.PLATFORM_NAME, BasePage.getProperties("Platform_Name"));
		//cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, BasePage.getProperties("plarformVersion"));
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, BasePage.getProperties("Device_Name"));
		//cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath()  );
		//cap.setCapability(MobileCapabilityType.UDID, BasePage.getProperties("udid"));
		//cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
		cap.setCapability("appPackage", BasePage.getProperties("appPackage"));
		cap.setCapability("appActivity", BasePage.getProperties("appActivity"));
		appiumDriver=new AndroidDriver(new URL(BasePage.getProperties("url")), cap);
		
		}
	
	@After("@Web")
	public void shutdown() {
		webDriver.quit();
	}
	
	@After("@mobile")
	public void CloseAppium() {
		appiumDriver.quit();
	}
	
	public static WebDriver getDriver() {
		return webDriver;
	}
	
	public static AndroidDriver getAndroidDriver() {
		return appiumDriver;
	}

}
