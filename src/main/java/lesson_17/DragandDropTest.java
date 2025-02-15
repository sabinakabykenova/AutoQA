package lesson_17;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DragAndDropTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void testDragAndDrop() {
        driver.get("URL_САЙТА");

        driver.findElement(By.linkText("AQA Practice")).click();
        driver.findElement(By.linkText("Drag and Drop")).click();

        WebElement header = driver.findElement(By.tagName("h1"));
        assertEquals("Sort Your Responsibilities", header.getText());

        List<WebElement> tasks = driver.findElements(By.cssSelector(".task-item"));
        WebElement manualWorkColumn = driver.findElement(By.id("manual-work"));
        WebElement automationWorkColumn = driver.findElement(By.id("automation-work"));

        Actions actions = new Actions(driver);

        for (WebElement task : tasks) {
            String taskText = task.getText().toLowerCase();
            if (taskText.contains("manual") || taskText.contains("exploratory")) {
                actions.dragAndDrop(task, manualWorkColumn).perform();
            } else {
                actions.dragAndDrop(task, automationWorkColumn).perform();
            }
        }

        WebElement successMessage = driver.findElement(By.id("success-message"));
        assertTrue(successMessage.isDisplayed());
        assertEquals("Congratulations! Let's test for the best!", successMessage.getText());
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
