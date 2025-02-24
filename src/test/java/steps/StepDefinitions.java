package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefinitions {
    WebDriver driver;

    @Given("The user opens the website {string}")
    public void openWebsite(String url) {
        driver = new ChromeDriver();
        driver.get(url);
    }

    @Then("The website should load without errors")
    public void checkWebsiteLoaded() {
        String title = driver.getTitle();
        Assertions.assertFalse(title.isEmpty(), "The website did not load");
        driver.quit();
    }

    @Then("The logo should be displayed at the top of the page")
    public void checkLogoDisplayed() {
        boolean isLogoPresent = driver.findElement(By.id("logo")).isDisplayed();
        Assertions.assertTrue(isLogoPresent, "The logo is not displayed");
        driver.quit();
    }

    @When("The user clicks the {string} button")
    public void clickButton(String buttonText) {
        driver.findElement(By.xpath("//button[text()='" + buttonText + "']")).click();
    }

    @Then("The login form should appear")
    public void checkLoginForm() {
        boolean isFormPresent = driver.findElement(By.id("login-form")).isDisplayed();
        Assertions.assertTrue(isFormPresent, "The login form is not displayed");
        driver.quit();
    }
}

