package pageElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumElements {
	
	
	WebDriver driver;

	
	public SeleniumElements(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	
	@FindBy(xpath="//*[contains(text(), 'Droppable')]")
	public WebElement DroppableLink;
	
	@FindBy(id="draggable")
	public WebElement DragabbleBox;
	
	@FindBy(id="droppable")
	public WebElement DroppableArea;
	
	@FindBy(xpath= "//*[contains(text(), 'Selectable')]")
	WebElement SelectableLink;
	
	@FindBy(id="selectable")
	WebElement SelectableOptions;
	
	@FindBy(xpath= "//*[contains(text(), 'Controlgroup')]")
	WebElement ControlgroupLink;
	
	@FindBy(xpath="//*[@id=\"content\"]/iframe")
	WebElement ControlgroupFrame;
	
	@FindBy(xpath="(//label[@class='ui-button ui-widget ui-checkboxradio-radio-label ui-checkboxradio-label ui-controlgroup-item'])[2]")
	WebElement AutomaticRadioButton;
	
	@FindBy(xpath="(//*[contains(@for, 'insurance')])[1]")
	WebElement insuranceBox;
	
	@FindBy(xpath="//label[contains(@for, 'transmission-standard-v')]")
	WebElement standardRadioButton;
	
	@FindBy(xpath="(//*[contains(@for, 'insurance')])[2]")
	WebElement insuranceBox2;
	
	@FindBy(xpath="//button[contains(@id, 'book')]")
	WebElement BookNow;
	
	
	
	
	
	
	
	public void ClickDroppable() {
		DroppableLink.click();
		
	}
	
	public WebElement DragabbleBox() {
		return DragabbleBox;
	}
	
	public WebElement DropabbleBox() {
		return DroppableArea;
	}
	public void DragandDrop() {
		Actions act = new Actions(driver);
		act.dragAndDrop(DragabbleBox, DroppableArea).perform();
	}
	
	public void ClickSelectable() {
		SelectableLink.click();
	}
	
	public WebElement Multiselect() {
		return SelectableOptions;
	}
	public void MultiSelectOptions() {
		Actions act = new Actions(driver);
		act.scrollToElement(SelectableOptions).perform();
		List<WebElement> options = SelectableOptions.findElements(By.tagName("li"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", SelectableOptions);
		act.keyDown(Keys.CONTROL).click(options.get(0)).click(options.get(2)).click(options.get(6)).build().perform();
	
	}
	
	public void ClickControlgroup() {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", ControlgroupLink);
		ControlgroupLink.click();
	}
	
	public void ControlgroupAccess() throws Exception {
		Actions act = new Actions(driver);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", ControlgroupFrame);
		driver.switchTo().frame(0);
		AutomaticRadioButton.click();
		insuranceBox.click();
		standardRadioButton.click();
		insuranceBox2.click();
		//((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", BookNow);
		act.scrollToElement(BookNow).perform();
		BookNow.click();
	
		Thread.sleep(3000);
		
		
		
	}
	
	
	
	

}
