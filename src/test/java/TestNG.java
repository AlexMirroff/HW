import org.testng.annotations.Test;

public class TestNG {
    @Test(priority = 2)
    public void test1() {
        System.out.println("priority2");
    }

    @Test(priority = 1)
    public void test2() {
        System.out.println("priority1");
    }


}