package lesson_16;

import org.testng.annotations.Test;

public class ParallelClass1 {

    @Test
    public void parallel1() {
        System.out.println("Test parallel1 from ParallelClass1 - Thread ID: " + Thread.currentThread().getId());
    }

    @Test
    public void parallel2() {
        System.out.println("Test parallel2 from ParallelClass1 - Thread ID: " + Thread.currentThread().getId());
    }

    @Test
    public void parallel3() {
        System.out.println("Test parallel3 from ParallelClass1 - Thread ID: " + Thread.currentThread().getId());
    }

    @Test
    public void parallel4() {
        System.out.println("Test parallel4 from ParallelClass1 - Thread ID: " + Thread.currentThread().getId());
    }

    @Test
    public void parallel5() {
        System.out.println("Test parallel5 from ParallelClass1 - Thread ID: " + Thread.currentThread().getId());
    }
}
