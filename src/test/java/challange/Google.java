package challange;

import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertEquals;

public class Google {
    WebDriver driver;

    @Then("^I go to google$")
    public void i_go_to_google() throws Throwable {
        driver = new FirefoxDriver();
        driver.get("https://www.google.com");
    }

    @When("^I insert a number$")
    public void i_insert_a_number() throws Throwable {
        WebElement element = driver.findElement(By.cssSelector("input.gsfi"));
        element.click();
        element.sendKeys("5+2");
        element.submit();
    }

    @Then("^The answer should be$")
    public void the_answer_should_be() throws Throwable {
        driver.manage().timeouts().implicitlyWait(2l, TimeUnit.SECONDS);
        String answer = driver.findElement(By.cssSelector("div.cwtlotc")).getText();
        assertEquals("7", answer);
    }

    @After
    public void destroy(){
        driver = null;
    }
}
