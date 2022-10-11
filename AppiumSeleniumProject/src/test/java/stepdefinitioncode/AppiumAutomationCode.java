package stepdefinitioncode;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageElements.AppiumElements;
import util.Hooks;

public class AppiumAutomationCode {
	
	public AndroidDriver driver;
	AppiumElements a1;
	
	
	public AppiumAutomationCode() {
		this.driver=Hooks.getAndroidDriver();
		a1= new AppiumElements(driver);
	}
	
	@Given("^Launch Application$")
	public void launch_application() throws Exception {
		a1.ClickContinue();
		Thread.sleep(3000);
		a1.ClickPopup();
		
	}

	@Given("^I Verify the title$")
	public void i_verify_the_title() {
	    a1.VerifyTitle();
	    System.out.println("Title is Verified");
	}

	@Then("^I Verify the elements on the screen$")
	public void i_verify_the_elements_on_the_screen() {
		a1.VerifyENButton();
		a1.VerifyChromeButton();
		a1.VerifySearchBox();
	    
	}
	@Given("^Tap on 'EN Button'$")
	public void Tap_ENButton() throws Exception {
	    a1.ENButton.click();
	    Thread.sleep(2000);
	}

	@Then("^Select Option 'No, no' and Check if HomePage is displayed$")
	public void SelectOptionNo_CheckHomePage() throws Exception {
		a1.ClickNoButton();
		a1.VerifyHomePage();
		
	    
	}
	
	@Given("^Tap on ChromeLogoButton$")
	public void Tap_ChromeButton() throws Exception {
	    a1.ChromeIconButton.click();
	    Thread.sleep(5000);
	}

	@Then("^Verify the Title and Verify the Text 'Hello, Can you'$")
	public void VerifyTitleandVerifyText() throws Exception {
		//System.out.println(driver.getTitle());
		Assert.assertEquals("Hello, can you please tell me your name?", a1.TitleText.getText());
		System.out.println(a1.TitleText.getText());
		
	    
	}
	@Given("^Enter your name in text box and Select Prefered car as 'Mercedes'$")
	public void EnterName_SelectPreferedCar() throws Exception {
		a1.EnterText();
		a1.DropDown.click();
		Thread.sleep(2000);
		a1.SelectCarBrand.click();
		
	   
	}

	@Then("^Tap on 'Send me your name' and Verify the text 'This is My'$")
	public void TapSendMe_VerifyTheText() throws Exception {
		a1.SendMeYourNameButton.click();
		Thread.sleep(3000);
		Assert.assertEquals("This is my way of saying hello", a1.ThisisMyNameText.getText());
		System.out.println("Verified Text is =" +a1.ThisisMyNameText.getText());
		
	    
	}
	@Given("^Verify your name and Prefered car selected from the previous screen$")
	public void VerifyName_PreferedCar() throws Exception {
		
		System.out.println("Your name is : "+a1.YourNameText.getText());
		System.out.println("Your Prefered Car is :"+a1.PreferedCarText.getText());
	    
	}

	@Then("^Click on Link 'here' at the bottom and Check if Default prefered car is 'Volvo'$")
	public void ClickLinkhere_checkDefaultPreferdCard() throws Exception {
		
		a1.ClickHereLink.click();
		Thread.sleep(2000);
		System.out.println("Your Default Prefered car is :"+a1.DropDown.getText());
	    
	}
	
	@When("^I Tap on File logo button i should navigate to next page$")
	public void TapOnFIleLogo_VerifyTitle() throws Exception {
		
		a1.FileLogoButton.click();
		Thread.sleep(2000);
	    
	}
	
	@And("^Verify Text 'Welcome to' and Verify the elements on screen$")
	public void VerifyText_VerifyElements() throws Exception {
		
		System.out.println("Verified title is :" +a1.FileLogoTitle.getText());
		
	    
	}

	@And("^Check Name Field is pre-populated with 'Mr. Burns' and Check if Ruby is selected$")
	public void CheckNameField_CheckRubyIsSelected() throws Exception {
		
		System.out.println("Field is Populated with :" +a1.PopulatedName.getText());
		System.out.println("Programming Language selected is " +a1.ProgLangDropDown.getText());
		
	    }
	@Then("^Fill in the fields with new Values and Select 'I accept ads'$")
	public void FillFields_SelectIAcceptAds() throws Exception {
		
		a1.Login();
		a1.AcceptAdsBox.click();
	    
	}
	@And("^Tap on Register User and Verify the user details on the next screen$")
	public void TapRegisterUser_VerifyUserDetails() throws Exception {
		a1.ClickRegister();
		Thread.sleep(2000);
		System.out.println("Verify Username :" +a1.usernameData.getText());
		System.out.println("Verify Username :" +a1.PasswordData.getText());
		System.out.println("Verify Username :" +a1.EmailData.getText());
		System.out.println("Verify Username :" +a1.ProgLangData.getText());
		
	    }
	@When("^I tap on Register user check if the screen navigates to homescreen$")
	public void TapRegisterUser_CheckScreenNavigateHomeScreen() throws Exception {
		a1.RegisterUserBack.click();
		Thread.sleep(2000);
		
		
	    }
	@When("^i tap on 'show progres button' wait for loader to disappear$")
	public void TapOnShowprogressButton_waitforLoader() throws Exception {
		a1.WaitingButton.click();
		Thread.sleep(15000);
		
	    }
	
	@Then("^Verify the Elements on the user registration screen$")
	public void VerifyElementsonUserRegistration() throws Exception {
		a1.VerifyUserRegistration();
		
	    }
	@When("^I tap on Displays a toast button$")
	public void TapOnDisplayAToast() throws Exception {
		a1.ShowToast.click();
		
	    }
	
	@Then("^Verify the Text$")
	public void VerifyToastText() throws Exception {
		System.out.println("Toast Text is " +a1.ToastText.getText());
		
	    }
	@When("^I tap on Display popup button$")
	public void TapOnDisplayAPopup() throws Exception {
		a1.DisplayPopUpButton.click();
		
	    }
	
	@Then("^Click on Dismiss$")
	public void ClickonDimiss() throws Exception {
		//driver.switchTo().alert().dismiss();
		
	    }

}
