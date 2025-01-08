package browsers;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import static browsers.BrowserFactory.configuredBrowser;

public class SharedDriver extends EventFiringWebDriver{

	private static WebDriver sharedDriver;
	private static WebDriver REAL_Driver = null;
	
	private static final Thread Closed_Thread = new Thread();
	
	public void run()
	{
		SharedDriver.REAL_Driver.quit();
	};
	
	static 
	{
		try 
		{
			REAL_Driver = configuredBrowser();
		}catch(Throwable e) {
			e.printStackTrace();
		}
	}
	
	public SharedDriver()
	{
		super(SharedDriver.REAL_Driver);
	}
	
	public static WebDriver getDriver()
	{
		if(SharedDriver.REAL_Driver != null)
		{
			SharedDriver.sharedDriver = SharedDriver.REAL_Driver;
		}
		return SharedDriver.REAL_Driver;
	}
	
	public void close()
	{
		if(Closed_Thread.currentThread()!= SharedDriver.Closed_Thread)
		{
			throw new UnsupportedOperationException("You should close this driver");
		}
	}
	
}
