package stepdefinitioncode;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class BasePage {
	
	AndroidDriver driver;
	
	
public static String getProperties(String key) {
		
		String value = "";
		try {
			FileInputStream fileInputStream = new FileInputStream("./Data.properties");
			Properties property = new Properties();
			property.load(fileInputStream);
			value = property.getProperty(key);
			
			fileInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return value;
			
	}

public void scrollToWebElement(WebElement locator)
{
    try
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;    
        js.executeScript("arguments[0].scrollIntoView();", locator);
    }
    catch (Exception e)
    {
        System.err.println("Unable to scroll to webelement.  WebElement is not visible.");
    }
}

}
