package lesson_18;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalculatorPage {
    private WebDriver driver;

    @FindBy(id = "button_1")
    private WebElement button1;

    @FindBy(id = "button_2")
    private WebElement button2;

    @FindBy(id = "button_3")
    private WebElement button3;

    @FindBy(id = "button_plus")
    private WebElement plusButton;

    @FindBy(id = "button_equality")
    private WebElement equalsButton;

    @FindBy(id = "result_textview")
    private WebElement resultText;

    public CalculatorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickButton(WebElement button) {
        button.click();
    }

    public String getResult() {
        return resultText.getText();
    }
}

