import org.testng.annotations.Test;

public class Test3 {
    @Test(priority = 1)
    public void test1() {
        System.out.println("first_test");
    }
    @Test(priority = 2)
    public void test2() {
        System.out.println("second_test");
    }
    @Test(priority = 0)
    public void test3() {
        System.out.println("third_test");
    }
    @Test
    public void test4() {
        System.out.println("last_test");
    }
}
