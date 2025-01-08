package browsers;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import automation.config.TestConfig;

public class ChromeBrowser extends ChromeDriver
{
	private static final Logger log = LoggerFactory.getLogger(ChromeBrowser.class);
	public static ChromeBrowser configuredChromeBrowser() throws Throwable
	{
//		String chromerDriverPath = System.getProperty("user.dir") + TestConfig.valueFor("WebDriverChromeDriverPath");
		String chromerDriverPath = System.getProperty("user.dir") +"\\Driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromerDriverPath);
		ChromeBrowser browser = new ChromeBrowser();
		browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return browser;
	}
	
	private ChromeBrowser()
	{
		super();
	}
}
