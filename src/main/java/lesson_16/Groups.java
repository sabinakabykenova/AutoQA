package lesson_16;


public class Groups {

    public static void main(String[] args) {
        Groups groups = new Groups();

        // Запуск тестов по порядку
        groups.one();
        groups.two();
        groups.three();
        groups.four();
        groups.five();
        groups.six();
        groups.seven();
        groups.eight();
    }

    public void one() {
        // Тест для нечетного числа
        assertCondition(true, "Test one failed");
    }

    public void two() {
        // Тест для четного числа
        assertCondition(true, "Test two failed");
    }

    public void three() {
        // Тест для нечетного числа
        assertCondition(true, "Test three failed");
    }

    public void four() {
        // Тест для четного числа
        assertCondition(true, "Test four failed");
    }

    public void five() {
        // Тест для нечетного числа
        assertCondition(true, "Test five failed");
    }

    public void six() {
        // Тест для четного числа
        assertCondition(true, "Test six failed");
    }

    public void seven() {
        // Тест для нечетного числа
        assertCondition(true, "Test seven failed");
    }

    public void eight() {
        // Тест для четного числа
        assertCondition(true, "Test eight failed");
    }

    private void assertCondition(boolean condition, String errorMessage) {
        if (!condition) {
            System.out.println(errorMessage);
            System.exit(1); // Завершаем выполнение программы с ошибкой, если условие не выполнено
        } else {
            System.out.println("Test passed");
        }
    }
}
