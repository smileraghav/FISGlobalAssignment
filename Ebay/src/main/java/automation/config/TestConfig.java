package automation.config;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;


public class TestConfig {
	
	private static TestConfig testConfig;
	private static String requiredEnvironmentName;
	private static Properties properties;
	
	public static TestConfig getInstance() throws Throwable
	{
		
		if(TestConfig.testConfig == null)
		{
			TestConfig.requiredEnvironmentName = System.getProperty("env","localEnv");
			TestConfig.properties = new Properties();
			TestConfig.testConfig = new TestConfig();
			populateCommonDetails();
			populateLocalEnvDetails(TestConfig.requiredEnvironmentName);
		}
		
		return TestConfig.testConfig;
	}
	
	public static String valueFor(final String keyName) throws Throwable
	{
		return getInstance().getProperty(keyName);
	}
	
	private String getProperty(final String keyName)
	{
		String value = TestConfig.properties.getProperty(keyName);
		if(value==null)
		{
			throw new Error(String.format("key %s not configured %s", keyName,TestConfig.requiredEnvironmentName));
		}
		return value;
	}
	
	private static void populateCommonDetails() throws Throwable
	{
		String commonPropertyfilePath = "config/common.properties";
		loadPropertiesFromFile(commonPropertyfilePath);
	}

	private static void populateLocalEnvDetails(final String requestedEnv) throws Throwable
	{
		String propertiesFilePath = String.format("config/%s.properties",requestedEnv);
		loadPropertiesFromFile(propertiesFilePath);
	}

	private static void loadPropertiesFromFile(String filePath) throws Throwable
	{
		File propertiesFile = new File(filePath);
		if(!propertiesFile.exists())
		{
			throw new FileNotFoundException(String.format("No property file found at: %s", filePath));
		}
		java.io.InputStream input = new FileInputStream(filePath);
		TestConfig.properties.load(input);
		input.close();
	}
}
