package lesson_15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToCartTest {
    public static void main(String[] args) {
        // Путь к драйверу
        System.setProperty("webdriver.chrome.driver", "D:\\chrometesting\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("http://www.automationpractice.pl/index.php");

            // Кнопка "Добавить в корзину"
            WebElement addToCartButton = driver.findElement(By.xpath("//a[@title='Add to cart']"));
            addToCartButton.click();

            System.out.println("Page title after clicking Add to Cart: " + driver.getTitle());
        } finally {
            driver.quit();
        }
    }
}
