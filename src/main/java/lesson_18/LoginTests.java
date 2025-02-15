package lesson_18;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class LoginTests {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://qa-course-01.andersenlab.com/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testValidLogin() {
        driver.findElement(By.id("email")).sendKeys("sample@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Sample@123");
        driver.findElement(By.id("login-button")).click();
        assertTrue(driver.getCurrentUrl().contains("dashboard"));
    }

    @Test
    public void testInvalidEmailLogin() {
        driver.findElement(By.id("email")).sendKeys("wrongemail@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Sample@123");
        driver.findElement(By.id("login-button")).click();
        WebElement error = driver.findElement(By.id("error-message"));
        assertTrue(error.isDisplayed());
    }

    @Test
    public void testPasswordReset() {
        driver.findElement(By.id("forgot-password")).click();
        driver.findElement(By.id("email")).sendKeys("sample@gmail.com");
        driver.findElement(By.id("reset-button")).click();
        WebElement confirmation = driver.findElement(By.id("confirmation-message"));
        assertTrue(confirmation.isDisplayed());
    }

    @Test
    public void testUnsuccessfulLoginStaysOnPage() {
        driver.findElement(By.id("email")).sendKeys("wrongemail@gmail.com");
        driver.findElement(By.id("password")).sendKeys("wrongpass");
        driver.findElement(By.id("login-button")).click();
        assertEquals("https://qa-course-01.andersenlab.com/login", driver.getCurrentUrl());
    }

    @Test
    public void testForgotPasswordLink() {
        driver.findElement(By.id("forgot-password")).click();
        assertEquals("https://qa-course-01.andersenlab.com/reset-password", driver.getCurrentUrl());
    }

    @Test
    public void testEmptyEmailLogin() {
        driver.findElement(By.id("login-button")).click();
        WebElement error = driver.findElement(By.id("error-message"));
        assertTrue(error.isDisplayed());
    }

    @Test
    public void testEmptyPasswordLogin() {
        driver.findElement(By.id("email")).sendKeys("sample@gmail.com");
        driver.findElement(By.id("login-button")).click();
        WebElement error = driver.findElement(By.id("error-message"));
        assertTrue(error.isDisplayed());
    }

    @Test
    public void testLogoutFunctionality() {
        driver.findElement(By.id("email")).sendKeys("sample@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Sample@123");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.id("logout-button")).click();
        assertEquals("https://qa-course-01.andersenlab.com/login", driver.getCurrentUrl());
    }

    @Test
    public void testRedirectToSignupPage() {
        driver.findElement(By.id("signup-link")).click();
        assertEquals("https://qa-course-01.andersenlab.com/signup", driver.getCurrentUrl());
    }

    @Test
    public void testRememberMeFunctionality() {
        driver.findElement(By.id("email")).sendKeys("sample@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Sample@123");
        driver.findElement(By.id("remember-me")).click();
        driver.findElement(By.id("login-button")).click();
        driver.quit();
        setUp();
        driver.get("https://qa-course-01.andersenlab.com/");
        assertTrue(driver.findElement(By.id("email")).getAttribute("value").equals("sample@gmail.com"));
    }
}
