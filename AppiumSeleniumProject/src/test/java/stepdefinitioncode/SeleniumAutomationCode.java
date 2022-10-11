package stepdefinitioncode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageElements.SeleniumElements;
import util.Hooks;

public class SeleniumAutomationCode {
	
	
	
	public WebDriver driver;
	SeleniumElements s1;
	BasePage b1;
	

	public SeleniumAutomationCode() {
		this.driver=Hooks.getDriver();
		s1=new SeleniumElements(driver);
	}
	
	@Given("^Go to JqueryUi Website$")
	public void go_to_jquery_ui_website() {
		//SeleniumAutomationCode s1= new SeleniumAutomationCode();
		
		driver.get(b1.getProperties("WebURL"));
	    
	}

	@Given("^Select 'Dropabble' option from Left menu$")
	public void select_option_from_left_menu() throws Exception {
		//s1=new SeleniumElements(driver);
		s1.ClickDroppable();
	
	}

	@Then("^Drag 'Drag me to my target' component to 'Drop here' component$")
	public void drag_component_to_component() throws Exception {
			//s1=new SeleniumElements(driver);
			driver.switchTo().frame(0);
			s1.DragandDrop();
			Thread.sleep(3000);
			
	}

	@Given("^Select 'Selectable' option from Left menu$")
	public void select_Selectableoption_from_left_menu() throws Exception {
		//s1=new SeleniumElements(driver);
		s1.ClickSelectable();
	
	}

	@Then("^Select Multiple Items$")
	public void Select_Multiple() throws Exception {
			//s1=new SeleniumElements(driver);
			driver.switchTo().frame(0);
			s1.MultiSelectOptions();
			Thread.sleep(3000);
			
	}
	
	@Given("^Select 'Controlgroup' option from Left menu under Widgets$")
	public void select_ControlgroupOption_from_left_menu() throws Exception {
		//s1=new SeleniumElements(driver);
		s1.ClickControlgroup();
		Thread.sleep(3000);
	
	}

	@Then("^Select Multiple options$")
	public void Select_MultipleOptions() throws Exception {
			//s1=new SeleniumElements(driver);
			s1.ControlgroupAccess();
			
			
	}
	
}
