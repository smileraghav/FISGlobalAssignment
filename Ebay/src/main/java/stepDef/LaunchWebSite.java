package stepDef;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import browsers.BrowserFactory;
import genericFunction.GenericFunctions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LaunchWebSite {
	
	GenericFunctions generticFunctions = new GenericFunctions();
	private static final Logger log = LoggerFactory.getLogger(LaunchWebSite.class);
	
	@When("^I hit the website \"(.*?)\"$")
	public void i_hit_the_website(String url) throws Throwable {
	    generticFunctions.navigateToUrl(url);
	}
	
	@Given("I enter {string} in text box {string} by xpath")
	public void i_enter_in_text_box_by_xpath(String value, String xpath) {
		 generticFunctions.setText(xpath, value);
	}
	
	@And("^I hit enter key$")
	public void I_hit_Enter_Key()
	{
		generticFunctions.keyBoradAction();
	}
	
	@And("^I click on element \"(.*?)\"$")
	public void I_click_on_Element(String xpath)
	{
		generticFunctions.click(xpath);
	}

	@Then("I wait for {int} seconds")
	public void i_wait_for_seconds(Integer time) throws Exception {
	   generticFunctions.waitForSometime(time);
	}
	
	@When("I move mouse to element {string}")
	public void I_move_mouse_to_element(String xpath)
	{
		generticFunctions.moveMousetoElement(xpath);
	}
	
	@Then("I validate the text {string},{string}")
	public void I_validate_the_text(String locator, String text) throws Exception {
		log.info("Text from UI is "+generticFunctions.getText(locator));
		Assert.assertEquals("Text is not matching",text , generticFunctions.getText(locator));
	}
	
	@When("I scroll using pixel {string},{string}")
	public void I_scroll_using_pixel(String vertical, String horizontal) throws Exception{
		generticFunctions.scrollDownByPixel(vertical, horizontal);
	}
	
	@When("I scroll using element {string}")
	public void I_scroll_using_element(String locator) throws Exception{
		generticFunctions.scrollDownByVisibleElement(locator);
	}
	
	@When("^I scroll to bottom of page$")
	public void I_scroll_bottom_of_page() throws Exception{
		generticFunctions.scrollDowntoBottom();
	}
	
	@When("I Switch to new window")
	public void I_Switch_to_new_window() throws Exception
	{
		generticFunctions.switchToNewWindow(); 
	}
	
	@Then("I validate actual count with expected count {string}")
	public void validateElement(String expectedCount) throws Exception
	{
		String cart_number = "//a[@alt='Your shopping cart contains "+expectedCount+" item']//i";
		String actual_count = generticFunctions.getText(cart_number);
		log.info("account count is "+actual_count);
		System.out.println("account count is "+actual_count);
		Assert.assertEquals("Count is not matching", expectedCount, actual_count);
	}
}
