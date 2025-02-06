package lesson_16;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest2 {

    // Используем аннотацию @Parameters для получения данных из XML файла
    @Test
    @Parameters({"username", "password"})
    public void testLogin(String username, String password) {
        // В реальной ситуации тут будет код для выполнения логина на сайте
        // Например, с использованием Selenium или другого инструмента для тестирования UI

        // Для простоты выводим логин и пароль пользователя
        System.out.println("Login test for user: " + username + " with password: " + password);

        // Логика проверки успешного логина (это просто пример)
        // assert loginUser(username, password);
    }
}
