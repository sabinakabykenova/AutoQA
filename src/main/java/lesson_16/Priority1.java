package lesson_16;

import java.util.Arrays;
import java.util.List;

public class Priority1 {

    public static void main(String[] args) {
        // Создаем список с именами тестов
        List<Runnable> tests = Arrays.asList(
                Priority1::testA,
                Priority1::testB,
                Priority1::testC,
                Priority1::testD,
                Priority1::testE,
                Priority1::testF,
                Priority1::testG
        );

        // Запускаем тесты в обратном порядке
        for (int i = tests.size() - 1; i >= 0; i--) {
            tests.get(i).run();
        }
    }

    public static void testA() {
        System.out.println("Running test A");
        assertCondition(true);
    }

    public static void testB() {
        System.out.println("Running test B");
        assertCondition(true);
    }

    public static void testC() {
        System.out.println("Running test C");
        assertCondition(true);
    }

    public static void testD() {
        System.out.println("Running test D");
        assertCondition(true);
    }

    public static void testE() {
        System.out.println("Running test E");
        assertCondition(true);
    }

    public static void testF() {
        System.out.println("Running test F");
        assertCondition(true);
    }

    public static void testG() {
        System.out.println("Running test G");
        assertCondition(true);
    }

    public static void assertCondition(boolean condition) {
        if (!condition) {
            System.out.println("Test failed!");
        } else {
            System.out.println("Test passed!");
        }
    }
}
