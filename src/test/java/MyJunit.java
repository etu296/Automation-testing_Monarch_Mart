import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public void a_getTitle()
    {

        String titleActual = driver.getTitle();
        String titleExpected= "Monarch Mart - Home";
        System.out.println(titleActual);
        Assert.assertEquals(titleExpected, titleActual);

    }

    public void b_ifElementExist()
    {
      boolean status = driver.findElement(By.xpath("//body/div[@id='__next']/div[1]/div[1]/div[1]/div[1]/a[1]/span[1]/img[1]")).isDisplayed();
       Assert.assertTrue(status);
    }

    public void c_clickOnButton(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        driver.findElement(By.xpath("//header/div[1]/div[1]/div[1]/div[3]/div[4]/button[1]/div[1]")).click();
    }
    @Test
    public void d_loginUser()
    {

        driver.findElement(By.xpath("//header/div[1]/div[1]/div[1]/div[3]/div[4]/button[1]/div[1]")).click();
        WebElement txtUserNam = driver.findElement(By.xpath("//body/div[@id='__next']/div[1]/main[1]/div[1]/div[1]/div[1]/form[1]/div[1]/input[1]"));
        txtUserNam.sendKeys("01315655618");
        WebElement txtPass = driver.findElement(By.xpath("//body/div[@id='__next']/div[1]/main[1]/div[1]/div[1]/div[1]/form[1]/div[2]/input[1]"));
        txtPass.sendKeys("123456");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        driver.findElement(By.xpath("//body/div[@id='__next']/div[1]/main[1]/div[1]/div[1]/div[1]/form[1]/button[1]")).click();

    }
//    @After
//    public void closeBrowser()
//    {
//        driver.close();
//    }
}
