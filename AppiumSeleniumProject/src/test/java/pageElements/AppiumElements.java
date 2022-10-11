package pageElements;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import stepdefinitioncode.BasePage;


public class AppiumElements {
	
	AndroidDriver driver;
	BasePage b1 = new BasePage();
	
	public AppiumElements(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	

	
	@FindBy(id="com.android.permissioncontroller:id/continue_button")
	public WebElement ContinueButton;
	
	@FindBy(xpath="//android.widget.Button[@text='OK']")
	public WebElement popup;
	
	@FindBy(id="android:id/title")
	public WebElement Title;
	
	@FindBy(id="io.selendroid.testapp:id/buttonTest")
	public WebElement ENButton;
	
	@FindBy(id="io.selendroid.testapp:id/buttonStartWebview")
	public WebElement ChromeIconButton;
	
	@FindBy(id="io.selendroid.testapp:id/my_text_field")
	public WebElement SearchBox;
	
	@FindBy(id="android:id/button2")
	public WebElement NoButton;
	
	@FindBy(id="android:id/content")
	public WebElement HomePage;
	
	@FindBy(xpath="(//android.widget.TextView[@text, 'Hello'])[4]")
	public WebElement TitleText;
	
	@FindBy(xpath="//android.widget.EditText[@text, 'Enter your name here!']")
	public WebElement textBox;
	
	@FindBy(xpath="(//android.view.View[@text, 'Volvo'])[4]")
	public WebElement DropDown;
	
	@FindBy(xpath="(//android.widget.CheckedTextView[@text, 'Mercedes'])[2]")
	public WebElement SelectCarBrand;
	
	@FindBy(xpath="(//android.widget.Button[@text, 'Send me your name!'])[2]")
	public WebElement SendMeYourNameButton;
	
	@FindBy(xpath="(//android.widget.TextView[@text, 'This is my way of saying hello'])[4]")
	public WebElement ThisisMyNameText;
	
	@FindBy(xpath="(//android.widget.TextView[@text, 'This is my way of saying hello'])[7]")
	public WebElement YourNameText;
	
	@FindBy(xpath="(//android.widget.TextView[@text, 'This is my way of saying hello'])[9]")
	public WebElement PreferedCarText;
	
	@FindBy(xpath="//android.view.View[@content-desc=\"here\"]/android.widget.TextView")
	public WebElement ClickHereLink;
	
	@FindBy(id="io.selendroid.testapp:id/startUserRegistration")
	public WebElement FileLogoButton;
	
	@FindBy(xpath="(//android.widget.TextView[@text, 'Welcome to register a new User'])[2]")
	public WebElement FileLogoTitle;
	
	@FindBy(id="io.selendroid.testapp:id/inputName")
	public WebElement PopulatedName;
	
	@FindBy(id="io.selendroid.testapp:id/input_preferedProgrammingLanguage")
	public WebElement ProgLang;
	
	@FindBy(id="android:id/text1")
	public WebElement ProgLangDropDown;
	
	@FindBy(id="io.selendroid.testapp:id/inputUsername")
	public WebElement UsernameBox;
	
	@FindBy(id="io.selendroid.testapp:id/inputEmail")
	public WebElement EmailBox;
	
	@FindBy(id="io.selendroid.testapp:id/inputPassword")
	public WebElement PasswordBox;
	
	@FindBy(id="io.selendroid.testapp:id/input_adds")
	public WebElement AcceptAdsBox;
	
	@FindBy(id="io.selendroid.testapp:id/btnRegisterUser")
	public WebElement RegisterButton;
	
	@FindBy(id="io.selendroid.testapp:id/label_username_data")
	public WebElement usernameData;
	
	@FindBy(id="io.selendroid.testapp:id/label_password_data")
	public WebElement PasswordData;
	
	@FindBy(id="io.selendroid.testapp:id/label_email_data")
	public WebElement EmailData;
	
	@FindBy(id="io.selendroid.testapp:id/label_preferedProgrammingLanguage_data")
	public WebElement ProgLangData;
	
	@FindBy(id="io.selendroid.testapp:id/buttonRegisterUser")
	public WebElement RegisterUserBack;
	
	@FindBy(id="io.selendroid.testapp:id/waitingButtonTest")
	public WebElement WaitingButton;
	
	@FindBy(id="android:id/parentPanel")
	public WebElement WaitingDialog;
	
	@FindBy(id="io.selendroid.testapp:id/showToastButton")
	public WebElement ShowToast;
	
	@FindBy(xpath="/hierarchy/android.widget.Toast")
	public WebElement ToastText;
	
	@FindBy(id="io.selendroid.testapp:id/showPopupWindowButton")
	public WebElement DisplayPopUpButton;
	
	
	
	
	
	public void VerifyUserRegistration() throws Exception {
		
	
		Boolean usernamebox= UsernameBox.isDisplayed();
		System.out.println("Username Field is displayed ="+usernamebox);
		
		Boolean emailBox= EmailBox.isDisplayed();
		System.out.println("Email Field is displayed ="+emailBox);
		
		Boolean passwordbox= PasswordBox.isDisplayed();
		System.out.println("Password field is displayed ="+passwordbox);
	}
	
	
	
	public void ClickRegister() throws InterruptedException {
		driver.navigate().back();
	RegisterButton.click();
	Thread.sleep(2000);
	
	}
	
	
	
	public void Login() {
		UsernameBox.sendKeys(b1.getProperties("username"));
		EmailBox.sendKeys(b1.getProperties("email"));
		PasswordBox.sendKeys(b1.getProperties("password"));
	
		
	}
	
	
	
	
	
	public void EnterText() {
		
		textBox.clear();
		textBox.sendKeys("irfan");
	}
	
	
	public void ClickContinue() {
		ContinueButton.click();
		
	}
	public void ClickNoButton() {
		NoButton.click();
	}
	
	public void ClickPopup() {
		popup.click();
	}
	public void VerifyTitle() {
		Boolean CheckTitle= Title.isDisplayed();
		System.out.println("The Title Verified= "+CheckTitle);
	}
	public void VerifyENButton() {
		Boolean CheckEnButton = ENButton.isEnabled();
		System.out.println("EN Button is Verified= " +CheckEnButton);
	}
	public void VerifyChromeButton() {
		Boolean CheckChromeIcon = ChromeIconButton.isEnabled();
		System.out.println("ChromeIconButton is Verified =" +CheckChromeIcon);
	}
	public void VerifySearchBox() {
		Boolean CheckSearchBox= SearchBox.isDisplayed();
		System.out.println("SearchBox is verified ="+CheckSearchBox);
	}
	public void VerifyHomePage() {
		Boolean CheckHomePage= HomePage.isDisplayed();
		System.out.println("HomePage is displayed ="+CheckHomePage);
	}
	
}

