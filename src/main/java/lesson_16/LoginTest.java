package lesson_16;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest {

    // Создаем DataProvider для трех пользователей
    @DataProvider(name = "userData")
    public Object[][] createUsers() {
        return new Object[][] {
                { new User("user1", "password1") },
                { new User("user2", "password2") },
                { new User("user3", "password3") }
        };
    }

    // Тест с использованием DataProvider
    @Test(dataProvider = "userData")
    public void testLogin(User user) {
        // В реальной ситуации тут будет код для выполнения логина на сайте
        // Например, с использованием Selenium или другого инструмента для тестирования UI

        // Для простоты выводим логин и пароль пользователя
        System.out.println("Login test for user: " + user.getUsername() + " with password: " + user.getPassword());

        // Логика проверки успешного логина (это просто пример)
        // assert loginUser(user.getUsername(), user.getPassword());
    }
}

