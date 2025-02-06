package lesson_15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginButtonTest {
    public static void main(String[] args) {
        // Путь к драйверу
        System.setProperty("webdriver.chrome.driver", "D:\\chrometesting\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("http://www.automationpractice.pl/index.php");

            // Кнопка "Login"
            WebElement loginButton = driver.findElement(By.xpath("//a[@class='login']"));
            if (loginButton.isDisplayed()) {
                System.out.println("Login button is present.");
            } else {
                System.out.println("Login button is NOT present.");
            }
        } finally {
            driver.quit();
        }
    }
}
