package lesson_17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SelectTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("URL_страницы"); // URL сайта нужен

        // Country -> USA
        Select countrySelect = new Select(driver.findElement(By.id("country")));
        countrySelect.selectByVisibleText("USA");

        // Language -> English
        Select languageSelect = new Select(driver.findElement(By.id("language")));
        languageSelect.selectByVisibleText("English");

        // Type -> Testing
        Select typeSelect = new Select(driver.findElement(By.id("type")));
        typeSelect.selectByVisibleText("Testing");

        String[] dates = getDates();
        String startDate = dates[0];
        String lastDate = dates[1];

        // Start date и Last date
        driver.findElement(By.id("start_date")).sendKeys(startDate);
        driver.findElement(By.id("last_date")).sendKeys(lastDate);

        // AQA Java и AQA Python
        Select coursesSelect = new Select(driver.findElement(By.id("courses")));
        coursesSelect.selectByVisibleText("AQA Java");
        coursesSelect.selectByVisibleText("AQA Python");

        // "Search"
        driver.findElement(By.id("search_button")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement message = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[contains(text(), 'Unfortunately, we did not find any courses matching your chosen criteria.')]")));

        if (message.isDisplayed()) {
            System.out.println("Тест успешно выполнен! Сообщение найдено.");
        } else {
            System.out.println("Тест провален! Сообщение не найдено.");
        }

        driver.quit();
    }

    public static String[] getDates() {
        LocalDate today = LocalDate.now();
        int daysUntilMonday = (7 - today.getDayOfWeek().getValue()) % 7;
        LocalDate startDate = today.plusDays(daysUntilMonday);
        LocalDate lastDate = startDate.plusDays(14);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return new String[]{startDate.format(formatter), lastDate.format(formatter)};
    }
}

