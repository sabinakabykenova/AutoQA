package lesson_16;


import org.testng.annotations.Test;

public class ParallelClass2 {

    @Test
    public void parallel6() {
        System.out.println("Test parallel6 from ParallelClass2 - Thread ID: " + Thread.currentThread().getId());
    }

    @Test
    public void parallel7() {
        System.out.println("Test parallel7 from ParallelClass2 - Thread ID: " + Thread.currentThread().getId());
    }

    @Test
    public void parallel8() {
        System.out.println("Test parallel8 from ParallelClass2 - Thread ID: " + Thread.currentThread().getId());
    }

    @Test
    public void parallel9() {
        System.out.println("Test parallel9 from ParallelClass2 - Thread ID: " + Thread.currentThread().getId());
    }

    @Test
    public void parallel10() {
        System.out.println("Test parallel10 from ParallelClass2 - Thread ID: " + Thread.currentThread().getId());
    }
}
