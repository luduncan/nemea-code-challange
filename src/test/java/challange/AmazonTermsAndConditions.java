package challange;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * Created by luduncan on 10/5/16.
 */
public class AmazonTermsAndConditions {

    WebDriver driver;

    @Then("^I go to amazon$")
    public void i_go_to_amazon() throws Throwable {
        driver = new FirefoxDriver();
        driver.get("https://www.amazon.co.uk");
    }

    @Then("^I click on todays deals$")
    public void I_click_on_todays_deals() throws Throwable {
        WebElement todayDeals = getRequiredElementByTextContent("div#nav-xshop-container div#nav-xshop a.nav-a", "Today's Deals");
        assertNotNull(todayDeals);
        todayDeals.click();
    }

    @Then("^I click on terms and conditions$")
    public void i_click_on_terms_and_conditions() throws Throwable {
        WebElement termsAndConditions = getRequiredElementByTextContent("div.unified_widget a", "Terms and conditions");
        assertNotNull(termsAndConditions);
        termsAndConditions.click();
    }

    @And("^I print all statements$")
    public void i_print_all_statements(){
        List<WebElement> elements = driver.findElements(By.cssSelector("div.help-content div ol li"));
        for(int i = 1; i <= elements.size(); i++){
            System.out.println(String.valueOf(i) +": "+ elements.get(i - 1).getText() + "\r\n");
        }
    }

    @After
    public void destroy(){
        driver = null;
    }

    private WebElement getRequiredElementByTextContent(String selector, String content){
        List<WebElement> elements = driver.findElements(By.cssSelector(selector));
        for(WebElement element : elements){
            if (element.getText().equals(content)){
                return element;
            }
        }
        return null;
    }
}
