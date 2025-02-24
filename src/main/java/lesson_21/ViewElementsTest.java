package lesson_21;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ViewElementsTest {
    private AndroidDriver<MobileElement> driver;

    @BeforeAll
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        caps.setCapability(MobileCapabilityType.APP, "C:\\Users\\Sabina\\Desktop\\projects\\apidemos.apk");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void testCountViewElements() {
        driver.findElementByAccessibilityId("Views").click();
        List<MobileElement> elements = driver.findElementsByClassName("android.widget.TextView");

        Assertions.assertEquals(42, elements.size(), "Количество элементов не совпадает!");
    }

    @Test
    public void testSetDateTime() {
        driver.findElementByAccessibilityId("Views").click();
        driver.findElementByAccessibilityId("Date Widgets").click();
        driver.findElementByAccessibilityId("1. Dialog").click();

        // Установка даты
        driver.findElement(By.id("io.appium.android.apis:id/pickDate")).click();
        driver.findElement(By.xpath("//*[@content-desc='25']")).click();
        driver.findElement(By.id("android:id/button1")).click();

        // Установка времени
        driver.findElement(By.id("io.appium.android.apis:id/pickTime")).click();
        driver.findElement(By.xpath("//*[@content-desc='11']")).click();
        driver.findElement(By.xpath("//*[@content-desc='11']")).click();
        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(By.id("android:id/button1")).click();
    }

    @Test
    public void testTextSwitcher() {
        driver.findElementByAccessibilityId("Views").click();
        driver.findElementByAccessibilityId("TextSwitcher").click();

        MobileElement textView = driver.findElement(By.id("io.appium.android.apis:id/textSwitcher"));
        MobileElement nextButton = driver.findElement(By.id("io.appium.android.apis:id/next"));

        for (int i = 1; i <= 5; i++) {
            nextButton.click();
            Assertions.assertEquals(String.valueOf(i), textView.getText(), "Текст в TextSwitcher не совпадает!");
        }
    }

    @AfterAll
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
