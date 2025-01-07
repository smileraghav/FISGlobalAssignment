package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Features", 
				 glue= {"stepDef","browsers"},
				  tags = "@Ebay",
				  dryRun = false, monochrome = true,
//				  plugin = {"pretty","html:target/site/cucmber-pretty",
//						    "json:target/cucumber/cucumber.json" }
				  plugin= {"pretty",
						  "json:target/cucumber/cucumber.json",
						  "html:target/Report/cucumber-html-report.html"})
public class RunnerTest {
}
//@CucumberOptions(plugin = {})