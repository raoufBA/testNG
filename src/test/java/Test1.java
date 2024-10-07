import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Test1 {
    WebDriver driver;

    @BeforeClass
    public void SuperClass() {
        System.out.println("SuperClass");
    }

    @BeforeTest
    public void Setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test (enabled = false)
    public void Test1() {
        driver.get("https://www.saucedemo.com/");
        String title = driver.getTitle();
        String expected = "Swag Labs";
        Assert.assertEquals(expected, title);
    }
//    @Test  (timeOut = 3000)
//    public void Test1() {
//        driver.get("https://www.saucedemo.com/");
//        String title = driver.getTitle();
//        String expected = "Swag Labs";
//        Assert.assertEquals(expected, title);
//    }

//    @AfterTest
//    public void TearDown() {
//        driver.quit();
//    }

    @AfterClass
    public void AfterClass() {
        System.out.println("AfterClass");
    }

    @Test(dataProvider = "Login")
    public void Test2(String Username, String Password, Boolean expected_result) {
        driver.get("https://www.saucedemo.com/");
        String title = driver.getTitle();
        String expected = "Swag Labs";
        Assert.assertEquals(expected, title);
        WebElement username = driver.findElement(By.xpath("//*[@id='user-name']"));
        username.sendKeys(Username);
        WebElement password = driver.findElement(By.xpath("//*[@id='password']"));
        password.sendKeys(Password);
        WebElement login = driver.findElement(By.xpath("//*[@id='login-button']"));
        login.click();

    }

    @DataProvider(name = "Login")
    public Object[][] Login() {
        return new Object[][]{
                {"standard_user", "secret_sauce", true},  // Cas 1 : Connexion réussie
                {"AMEL", "secret_sauce", false}, // Cas 2 : Mot de passe incorrect
                {"AMEL", "secret_sauce", false}, // Cas 3 : Nom d'utilisateur incorrect
                {"", "secret_sauce", false}, // Cas 4 : Nom d'utilisateur vide
                {"AMEL", "", false}, // Cas 5 : Mot de passe vide

        };
    }


}




