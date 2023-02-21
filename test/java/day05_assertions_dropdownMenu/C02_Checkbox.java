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

public class C02_Checkbox {
    /*
   a. Verilen web sayfasına gidin.
https://the-internet.herokuapp.com/checkboxes
b. Checkbox1 ve checkbox2 elementlerini locate edin.
c. Checkbox1 seçili değilse onay kutusunu tıklayın
d. Checkbox2 seçili değilse onay kutusunu tıklayın

     */
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @After
    public void teardown() {
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement kutu1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement kutu2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        if (!kutu1.isSelected()){
            kutu1.click();
        }

        if (!kutu2.isSelected()){
            kutu2.click();
        }
        // son durumda 2 si de seciliolması gereken testi yapınız.
        Assert.assertTrue(kutu1.isSelected());
        Assert.assertTrue(kutu2.isSelected());
        Thread.sleep(3000);
    }
}
