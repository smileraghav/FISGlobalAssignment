package browsers;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.*;
import automation.config.TestConfig;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Scenario;

public class BrowserFactory {
	private static final Logger log = LoggerFactory.getLogger(BrowserFactory.class);
	
	@Before
	public static WebDriver configuredBrowser() throws Throwable {
		String desiredBrowser = System.getProperty("browser", TestConfig.valueFor("Browser"));
		System.out.println("Browser Selected is " + desiredBrowser);
		return runonLocal(desiredBrowser);
	}

	private static WebDriver runonLocal(String desiredBrowser) throws Throwable {
		WebDriver selectedDriver = null;
		switch (desiredBrowser) {
//		case "ie":
//			selectedDriver = IeBrowser.configuredIeBrowser();
//			break;
		case "chrome":
			selectedDriver = ChromeBrowser.configuredChromeBrowser();
			break;
//		default:
//			BrowserFactory.log.info("Default browser - firefox is picked");
//			selectedDriver = FirefoxBrowser.configuredFirefoxBrowser();
		}
		selectedDriver.manage().window().maximize();
		return selectedDriver;
	}
	
//	@AfterAll
//	public static void before_or_after_all()
//	{
//		SharedDriver.getDriver().close();
//	}
	
	@After(order = 1)
	public void takeScraenshotOnFailure(Scenario scenario) {

	if (scenario.isFailed()) {

		TakesScreenshot ts = (TakesScreenshot) SharedDriver.getDriver();

	byte[] src = ts.getScreenshotAs(OutputType.BYTES);
//	scenario.embed(src, "image/png", "screenshot");
	scenario.attach(src, "image/png", "screenshot");
	}

	}
	
	@After
	public void closeBrowser(){
		SharedDriver.getDriver().quit();
	}
}
