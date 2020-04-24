import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author guoqinglin
 * @create 2020-04-22-22:52
 */
public class ChromeTest {




    WebDriver driver;
    @BeforeMethod
    public void beforeMethod() {
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Page title is: " + driver.getTitle());
        driver.quit();
    }

    @Test
    public void test_case01() {
        driver = new ChromeDriver();
        driver.get("http://www.baidu.com");


    }
}
