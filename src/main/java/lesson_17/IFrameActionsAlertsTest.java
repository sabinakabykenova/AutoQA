package lesson_17;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class IFrameActionsAlertsTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("URL_ТВОЕЙ_СТРАНИЦЫ");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void testAlertsHandling() {
        driver.switchTo().frame("iframe_id"); // Переключаемся в iframe (замени ID)

        // Confirm Alert
        WebElement confirmButton = driver.findElement(By.id("confirmButton"));
        confirmButton.click();
        Alert confirmAlert = driver.switchTo().alert();
        assertEquals("You have called alert!", confirmAlert.getText());
        confirmAlert.accept();
        assertTrue(driver.findElement(By.id("result"))
                .getText().contains("Congratulations, you have successfully enrolled in the course!"));

        // Get Discount Alert
        WebElement discountButton = driver.findElement(By.id("discountButton"));
        discountButton.click();
        Alert discountAlert = driver.switchTo().alert();
        assertEquals("Are you sure you want to apply the discount?", discountAlert.getText());
        discountAlert.accept();
        assertTrue(driver.findElement(By.id("result"))
                .getText().contains("You received a 10% discount on the second course."));

        // Cancel Course Alert
        WebElement cancelButton = driver.findElement(By.id("cancelButton"));
        cancelButton.click();
        Alert cancelAlert = driver.switchTo().alert();
        assertEquals("Here you may describe a reason why you are cancelling your registration (or leave this field empty).", cancelAlert.getText());
        cancelAlert.sendKeys("Test");
        cancelAlert.accept();
        assertTrue(driver.findElement(By.id("result"))
                .getText().contains("You closed the course. Reason: Test"));
    }
}
