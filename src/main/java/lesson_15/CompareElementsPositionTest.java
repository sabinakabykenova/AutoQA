package lesson_15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CompareElementsPositionTest {
    public static void main(String[] args) {
        // Путь к драйверу
        System.setProperty("webdriver.chrome.driver", "D:\\chrometesting\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("http://www.automationpractice.pl/index.php");

            WebElement firstElement = driver.findElement(By.id("search_query_top"));
            WebElement secondElement = driver.findElement(By.className("login"));

            // Сравниваем элементов
            compareElements(firstElement, secondElement);
        } finally {
            driver.quit();
        }
    }

    public static void compareElements(WebElement element1, WebElement element2) {
        // Координаты элементов
        int y1 = element1.getLocation().getY();
        int y2 = element2.getLocation().getY();
        int x1 = element1.getLocation().getX();
        int x2 = element2.getLocation().getX();

        // Сравнение расположения
        if (y1 < y2) {
            System.out.println("Element 1 is higher than Element 2");
        } else {
            System.out.println("Element 2 is higher than Element 1");
        }

        if (x1 < x2) {
            System.out.println("Element 1 is to the left of Element 2");
        } else {
            System.out.println("Element 2 is to the left of Element 1");
        }

        int area1 = element1.getSize().getWidth() * element1.getSize().getHeight();
        int area2 = element2.getSize().getWidth() * element2.getSize().getHeight();

        if (area1 > area2) {
            System.out.println("Element 1 occupies a larger area");
        } else {
            System.out.println("Element 2 occupies a larger area");
        }
    }
}
