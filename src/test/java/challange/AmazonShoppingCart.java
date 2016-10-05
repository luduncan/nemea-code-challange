package challange;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertTrue;

/**
 * Created by luduncan on 10/5/16.
 */
public class AmazonShoppingCart {

    WebDriver driver;

    String secondElementText= "";

    @Given("^search for notepad$")
    public void search_for_notepad() throws Throwable {
        driver = new FirefoxDriver();
        driver.get("https://www.amazon.co.uk");

        WebElement searchBox = driver.findElement(By.cssSelector("div.nav-search-field input#twotabsearchtextbox"));
        searchBox.sendKeys("Notepad");
        searchBox.submit();
    }

    @Then("^click on the second item$")
    public void click_on_second_item() throws Throwable {
        WebElement secondElement = driver.findElement(By.cssSelector("div#centerMinus div#atfResults ul li#result_2 div.s-item-container a"));
        secondElementText = driver.findElement(By.cssSelector("div#centerMinus div#atfResults ul li#result_2 div.s-item-container")).getText();
        secondElement.click();
    }

    @And("^add to basket$")
    public void add_to_basket() throws Throwable {
        WebElement addToCartButton = driver.findElement(By.cssSelector("div.a-button-stack"));
        addToCartButton.click();
    }

    @Then("^go to the shopping cart$")
    public void go_to_shopping_cart(){
        WebElement cart = driver.findElement(By.cssSelector("div#nav-main a#nav-cart"));
        cart.click();
    }

    @And("^check the item is added$")
    public void check_the_item_is_added() throws Throwable {
        String cartItemText = driver.findElement(By.cssSelector("span.a-list-item a span.a-size-medium")).getText();
        assertTrue(secondElementText.contains(cartItemText));
    }

    @After
    public void destroy(){
        driver = null;
    }

}
