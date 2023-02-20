package day05_assertions_dropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Radio_Button {
    /*
    a. Verilen web sayfasına gidin.
https://facebook.com
b. Cookies’i kabul edin
c. Create an account buton’una basin
d. Radio button elementlerini locate edin ve size uygun olani secin
e.sectiginiz radio butonun secili otekilerin ise secili olmadigini test edin.
     */
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void teardown(){
        driver.close();
    }
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://facebook.com");
        driver.findElement(By.xpath("(//div[@class='_6ltg'])[2]")).click();
        WebElement female=driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
        WebElement male=driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
        WebElement custom=driver.findElement(By.xpath("(//input[@type='radio'])[3]"));
        male.click();
        Thread.sleep(3000);
        Assert.assertTrue(male.isSelected());
        Assert.assertFalse(female.isSelected());
        Assert.assertFalse(custom.isSelected());
    }
}
