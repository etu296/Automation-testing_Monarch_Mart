import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MyJunit {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://monarchmart.com/");

    }
@Test
    public void getTitle()
    {

        String titleActual = driver.getTitle();
        String titleExpected= "Monarch Mart - Home";
        System.out.println(titleActual);
        Assert.assertEquals(titleExpected, titleActual);

    }
    @Test
    public void ifElementExist()
    {
      boolean status = driver.findElement(By.xpath("//body/div[@id='__next']/div[1]/div[1]/div[1]/div[1]/a[1]/span[1]/img[1]")).isDisplayed();
       Assert.assertTrue(status);
    }
    @After
    public void closeBrowser()
    {
        driver.close();
    }
}
