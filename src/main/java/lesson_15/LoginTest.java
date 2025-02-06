package lesson_15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    public static void main(String[] args) {
        // Указываем путь к драйверу
        System.setProperty("webdriver.chrome.driver", "путь_к_твоему_драйверу/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://andersenlab.com/");

            WebElement loginButton = driver.findElement(By.xpath("//a[@href='/login']"));
            loginButton.click();

            WebElement usernameField = driver.findElement(By.id("username"));
            WebElement passwordField = driver.findElement(By.id("password"));

            // Данные
            usernameField.sendKeys("your_username");
            passwordField.sendKeys("your_password");

            // Кнопка входа
            WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
            submitButton.click();

            // Результат
            System.out.println("Login successful. Current URL: " + driver.getCurrentUrl());
        } finally {
            driver.quit();
        }
    }
}
