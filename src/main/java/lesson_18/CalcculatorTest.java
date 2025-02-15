package lesson_18;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalculatorTest {

    @Test
    public void testAddition() {
        WebDriver driver = new ChromeDriver();
        driver.get("URL_КАЛЬКУЛЯТОРА");

        CalculatorPage calculator = new CalculatorPage(driver);

        calculator.clickButton(calculator.button2);
        calculator.clickButton(calculator.plusButton);
        calculator.clickButton(calculator.button3);
        calculator.clickButton(calculator.equalsButton);

        String result = calculator.getResult();
        Assertions.assertEquals("5", result);

        driver.quit();
    }
}
