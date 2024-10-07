import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class Test2 {
    @BeforeGroups("Groupe1")
    public void beforeGroups() {
        System.out.println("Before Groups");
    }

    @Test(groups = "Groupe1")
    public void test1() {
        System.out.println("Methode1_Groupe1");

    }

    @Test(groups = "Groupe1")
    public void test2() {
        System.out.println("Methode2_Groupe1");

    }

    @Test(groups = "Groupe2")
    public void test3() {
        System.out.println("Methode3_Groupe2");
    }
    @AfterGroups ("Groupe1")
    public void afterGroups() {
        System.out.println("After Groups");
    }
}