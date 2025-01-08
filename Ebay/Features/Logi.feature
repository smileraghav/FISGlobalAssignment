@Ebay
Feature: Login feature

@EbayUI
Scenario:
When I hit the website "https://www.ebay.com/"
Given I enter "book" in text box "//input[@type='text']" by xpath
And I click on element "//div[@id='gAC']/ul/li[1]"
And I wait for 2 seconds
And I click on element "//span[text()='Dayton Audio Classic B40 Bookshelf Speaker Pair Black']"
And I wait for 2 seconds
Then I Switch to new window
And I click on element "//span[text()='Add to cart']/../parent::a/parent::div/parent::li"
And I wait for 2 seconds
Then I validate actual count with expected count "1"


@APITest
Scenario: 
When As user I validate API response "bpi.GBP.description"

