package lesson_15;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class OpenMultiplePagesTest {
    public static void main(String[] args) {
        // Путь к драйверу
        System.setProperty("webdriver.chrome.driver", "D:\\chrometesting\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("http://www.automationpractice.pl/index.php");
            ((JavascriptExecutor) driver).executeScript("window.open('https://zoo.waw.pl/');");
            ((JavascriptExecutor) driver).executeScript("window.open('https://www.w3schools.com/');");
            ((JavascriptExecutor) driver).executeScript("window.open('https://www.clickspeedtester.com/click-counter/');");
            ((JavascriptExecutor) driver).executeScript("window.open('https://andersenlab.com/');");

            // Все окна
            Set<String> windowHandles = driver.getWindowHandles();
            Iterator<String> iterator = windowHandles.iterator();

            // Переключение между окнами
            while (iterator.hasNext()) {
                String currentWindow = iterator.next();
                driver.switchTo().window(currentWindow);

                // Название и ссылка
                System.out.println("Title: " + driver.getTitle());
                System.out.println("URL: " + driver.getCurrentUrl());

                // Закрытие окна, если оно содержит слово "Zoo" в URL
                if (driver.getCurrentUrl().contains("zoo")) {
                    driver.close();
                    break;  // Выход из цикла после закрытия окна
                }
            }
        } finally {
            driver.quit();
        }
    }
}
