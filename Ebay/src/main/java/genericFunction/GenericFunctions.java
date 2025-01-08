package genericFunction;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import browsers.SharedDriver;
import io.cucumber.java.After;

public class GenericFunctions {

	private static final Logger log = LoggerFactory.getLogger(GenericFunctions.class);
	WebDriver current_Driver;
	FluentWait<WebDriver> wait;
	Actions act = new Actions(SharedDriver.getDriver());
	public GenericFunctions()
	{
		this.current_Driver = SharedDriver.getDriver();
		wait = new FluentWait<WebDriver>(this.current_Driver).withTimeout(50,TimeUnit.SECONDS)
				.pollingEvery(1,TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
	}
	
	public void navigateToUrl(final String url) throws Throwable
	{
		GenericFunctions.log.info("Navigating to url==> "+url);
		this.current_Driver.manage().window().maximize();
		this.current_Driver.get(url);
	}
	
	public void waitUntilPageTitleIs(final String pageName)
	{
		try
		{
			wait.until(ExpectedConditions.titleContains(pageName));
		}
		catch(Exception e)
		{
			GenericFunctions.log.error("Unable to wait for page title...");
			GenericFunctions.log.error(e.getMessage());
		}
	}
	
	public void clickOnElementFromTheListWhichMathesText(final List<WebElement> listOfElement, final String text)
	{
		for(WebElement element : listOfElement) {
			if(element.getText().equals(text))
			{
				GenericFunctions.log.info("Now clicking on the element matching text..."+text);
				element.click();
				break;
			}
		}
		
	}
	
	public WebElement find(By by)
	{
		return this.current_Driver.findElement(by);
	}
	
	public void click(String xpath)
	{
		By by = By.xpath(xpath);
		find(by).click();
	}
	
	public WebElement getElementWhichMatchesValueForAttribute(final List<WebElement> listOfElement, final String attribute,
			final String expectedValue)
	{
		WebElement target_element = null;
		for(WebElement element : listOfElement) {
			if(element.getAttribute(attribute).equals(expectedValue))
			{
				target_element = element;
				break;
			}
		}
		return target_element;
	}
	
	public WebElement getElementWhoesAttributeIsNotNull(final List<WebElement> listOfElement, final String attribute)
	{
		WebElement source_element = null;
		for(WebElement element : listOfElement) {
			if(element.getAttribute(attribute) != null)
			{
				source_element = element;
				break;
			}
		}
		return source_element;
	}
	
	public String getAttributeOfElement(final WebElement element, final String attribute)
	{
		return element.getAttribute(attribute);
	}
	
	public void setText(String xpath, String value) {
		this.find(By.xpath(xpath)).sendKeys(value);
	}
	
	public void keyBoradAction() {
		act.sendKeys(Keys.ENTER).build().perform();
	}
	
	public void waitForSometime(int time) throws Exception {
		Thread.sleep(time);
	}
	
	public void moveMousetoElement(String xpath)
	{
		By by = By.xpath(xpath);
		act.moveToElement(find(by)).build().perform();
	}
	
	public String getText(String locator) throws Exception{
		By by = By.xpath(locator);
		String text = this.find(by).getText();
		return text;
	}
	
	public void scrollDownByPixel(String vertical, String horizontal) throws Exception{
		JavascriptExecutor js = (JavascriptExecutor) SharedDriver.getDriver();
		js.executeScript("window.scrollBy("+vertical+","+horizontal+")", "");
	}
	
	public void scrollDownByVisibleElement(String locator) throws Exception{
		By by = By.xpath(locator);
		JavascriptExecutor js = (JavascriptExecutor) SharedDriver.getDriver();
		js.executeScript("arguments[0].scrollIntoView();", find(by));
	}
	
	public void scrollDowntoBottom() throws Exception{
		JavascriptExecutor js = (JavascriptExecutor) SharedDriver.getDriver();
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	public void switchToNewWindow()
	{
		String parentWindow = current_Driver.getWindowHandle();
		Set<String> child_window = current_Driver.getWindowHandles();
		for(String cw : child_window)
		{
			if(!(cw.equals(parentWindow)))
			{
				current_Driver.switchTo().window(cw);
			}
		}
	}
}
