package lesson_19;


import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class CourseTest {

    private static final Logger logger = LogManager.getLogger(AndersenCourseTest.class);

    @Test
    @Feature("QA Course Website")
    @Story("Verify Page Title")
    @Description("Проверка заголовка главной страницы")
    public void testHomePageTitle() {
        logger.info("Запуск теста проверки заголовка страницы");

        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-course-01.andersenlab.com/");

        String actualTitle = driver.getTitle();
        logger.info("Полученный заголовок: " + actualTitle);

        Assertions.assertEquals("QA Automation Course", actualTitle, "Неверный заголовок страницы");

        driver.quit();
    }
}

